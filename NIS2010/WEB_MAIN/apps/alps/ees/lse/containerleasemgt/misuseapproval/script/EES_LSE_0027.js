/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0027.js
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
* =======================================================
* 2010.12.22 남궁진호[CHM-201007442-01] Request OFC POPUP 세로SIZE 조정
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
     * @class EES_LSE_0027 : EES_LSE_0027 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0027() {
    	this.processButtonClick = processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.loadPage 			= loadPage;
		this.initControl 		= initControl;
		this.obj_blur 			= obj_blur;
		this.obj_focus 			= obj_focus;
		this.obj_change 		= obj_change;
		this.obj_keypress 		= obj_keypress;
		this.obj_keyup 			= obj_keyup;
		this.obj_keydown 		= obj_keydown;
		this.obj_click			= obj_click;
		this.initSheet 			= initSheet;
		this.doActionIBSheet 	= doActionIBSheet;
		this.setAsycData_ReturnLoc = setAsycData_ReturnLoc;
		this.sheet1_OnChange 	= sheet1_OnChange;
		this.sheet1_OnPopupClick = sheet1_OnPopupClick;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnClick 	= sheet1_OnClick;
		this.sheet1_OnValidation = sheet1_OnValidation;
		this.sheet1_OnSaveEnd 	= sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.openPopup 			= openPopup;
		this.setPopData_ReturnLoc = setPopData_ReturnLoc;
		this.setPopData_Currency = setPopData_Currency;
		this.setPopData_YardCode = setPopData_YardCode;
		this.validateForm 		 = validateForm;
		this.clearForm 			 = clearForm;
    }

   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;
	var fileSaveFlag = false;

	var vOrgModCd = "O";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject, formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.rtrn_loc);
 					}
 					break;

 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject, "del_chk");
 					} else {
 						ComSetFocus(formObj.rtrn_loc);
 					}
 					break;

                case "btn_New":
					ComResetAll();
					vOrgModCd = "O";
					/* Request Number 조회 */
    				doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
					ComSetFocus(formObj.rtrn_loc);
					break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObj,IBSAVE);
                    break;

				case "btns_search":		//Return Location 조회 팝업
 					openPopup("1");
 					break;

 				case "btns_search2":	//Currency Code 조회 팝업
 					openPopup("2");
 					break;

 				case "mss_rqst_io_mod_cd" :
	  				if ( ComGetObjValue(srcObj) != vOrgModCd ) {
	  					vOrgModCd = ComGetObjValue(srcObj);
	  					sheetObject.RemoveAll();
	  					/* Request Number 조회 */
    					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
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

        ComConfigUpload(uploadObjects[0], "/hanjin/LSE_INTGS.do");
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
    	 doActionIBSheet(sheetObjects[0],document.form,IBCREATE);

        /* Axon Control Setting*/
    	initControl();

    	/* Request Number 조회 */
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);

    	/* 초기 Value Setting */
		vOrgModCd = ComGetObjValue(formObj.mss_rqst_io_mod_cd);

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.rtrn_loc);
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
		axon_event.addListenerFormat('change', 		'obj_change',  	formObj); //- 변경될때.
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 클릭하였을 때
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur() {
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name) {
	    	case "rtrn_loc" :
	            ComChkObjValid(obj);
	    		break;
	    	case "curr_cd" :
	            ComChkObjValid(obj);
	    		break;
	    	default:
	            /* Validation 전체 체크(길이,format,최대,최소 등등) */
	            ComChkObjValid(obj);
	        	break;
	    }

	    preEventType = event.type;
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}

	/**
	 * Change Event 처리
	 */
	function obj_change() {
		var obj = event.srcElement;
		var formObj = document.form;

  		switch(obj.name) {
  			case "rtrn_loc":	//Return Location
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				}
				break;
  			case "n1st_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
				}
				break;
  			case "n2nd_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
				}
				break;
  			case "n3rd_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);
				}
				break;
  			case "n4th_ref_ofc_cd":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC06);
				}
				break;

			case "curr_cd":		//Currency Code
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC07);
				}
				break;
		}
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
  		var obj = event.srcElement;
  		var formObj = document.form;

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
	        	if(obj.name == "curr_cd") {
		            ComKeyOnlyAlphabet('upper');
	        	}else{
	        		ComKeyOnlyAlphabet('uppernum');
	        	}
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
			default :
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

  		switch (obj.name) {
  			case "agmt_seq":
		  		if ( vKeyCode == 13 ) {
		  			//do nothing
		  		}
		  		break;

  			case "diff_rmk":
				if (vKeyCode != 8 && ComGetLenByByte(obj) > 200) {
  					ComShowCodeMessage("LSE01024");
  					//ComShowMessage("입력한 Remarks의 길이가 200자를 초과하였습니다.");
  					return false;
  				}
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

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 270;
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

                    var HeadTitle = "|Sel.|CNTR No.|TP/SZ|Lease\nTerm|MVMT|POD|POL|MU O/I Date|MU By/From|Yard|Per Diem|Lift On\nCharge|Liable Party|||||Request Reason|Request File Attachment|";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk");

                    InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  	true,   "cntr_no",  		true,       "",     dfEngUpKey,		0, false, true, 	14);
                    InitDataProperty(0, cnt++ , dtCombo,     50,    daCenter,  	true,   "cntr_tpsz_cd",   	false,      "",     dfEngUpKey,		0, false, true,		4);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	true,   "lstm_cd",     		false,      "",     dfEngUpKey,		0, false, false,	2);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	true,   "mvmt_sts_cd", 		false,      "",     dfEngUpKey,		0, false, false,	2);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	true,   "pod_cd", 			false,      "",     dfEngUpKey,		0, false, false,	5);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	true,   "pol_cd", 			false,      "",     dfEngUpKey,		0, false, false,	5);
                    InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  	true,   "mss_usd_dt", 		false,      "",     dfDateYmd,		0, false, true,		8);
                    InitDataProperty(0, cnt++ , dtData,      300,   daLeft,  	true,   "mss_usd_fm_nm", 	false,      "",     dfEngUpKey,		0, false, true,		50);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 75,    daCenter,  	true,   "mss_use_plc_nm", 	true,       "",    	dfEngUpKey,		0, false, true,		7);
                    InitDataProperty(0, cnt++ , dtData,      75,    daRight,  	true,   "pd_chg_rt_amt",  	false,      "",     dfNullFloat,	2, false, true, 	8);
                    InitDataProperty(0, cnt++ , dtData,      75,   	daRight,  	true,   "lft_chg_rt_amt", 	false,      "",     dfNullFloat,	2, false, true, 	8);
                    InitDataProperty(0, cnt++ , dtData,      300,   daLeft,  	true,   "libor_pty_nm",   	false,      "",    	dfEngUpKey,		2, false, true,		50);

                    InitDataProperty(0, cnt++ , dtHidden,	 60,	daCenter,	true,	"rqst_no",			false,		"",		dfNone,     	0,	false,	true,	20);
                    InitDataProperty(0, cnt++ , dtHidden,	 60,	daCenter,	true,	"agmt_cty_cd",		false,		"",		dfNone,     	0,	false,	true,	3);
                    InitDataProperty(0, cnt++ , dtHidden,	 60,	daCenter,	true,	"agmt_seq",			false,		"",		dfNone,     	0,	false,	true,	6);
                    InitDataProperty(0, cnt++ , dtHidden,	 60,	daCenter,	true,	"rqst_loc_nm",		false,		"",		dfNone,     	0,	false,	true,	20);

					InitDataProperty(0, cnt++ , dtData,		350,	daLeft,		false,	"rqst_rsn_desc",	false,		"",		dfEngUpKey,		0,	false,	true, 	100);
                    InitDataProperty(0, cnt++ , dtPopup,	300,	daLeft,		false,	"rqst_file_sav_nm",	false,		"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,	300,	daLeft,		false,	"rqst_file_sav_id",	false,		"",		dfNone,			0,	false,	false);

					InitDataValid(0, "cntr_no",			vtEngUpOther, "0123456789");
					InitDataValid(0, "mss_usd_fm_nm",	vtEngOther,   "0123456789 ");
					InitDataValid(0, "mss_use_plc_nm",	vtEngUpOther, "0123456789");
					InitDataValid(0, "libor_pty_nm",	vtEngOther,   "0123456789 ");
					InitDataValid(0, "rqst_rsn_desc",	vtEngOther,   "0123456789 ");

					//ImageList에 이미지를 설정한다.
				  	//ImageList(0) = "/hanjin/img/btns_search.gif";
				  	//ImageList(1) = "/hanjin/img/btn_file.gif";

					ShowButtonImage = 0;
					SelectBackColor = LSE_SELECT_BACK_COLOR;
					CountPosition = 0;
					//FitColWidth();
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
				sheetObj.WaitImageVisible = false;
				//Container Type/Size Grid Combo Item Setting
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( sXml != "" ) {
					sheetObj.InitDataCombo(0, "cntr_tpsz_cd", ComGetEtcData(sXml, "cntr_tpsz_nm"), ComGetEtcData(sXml, "cntr_tpsz_cd"));
				}
				//----------------------------------------------------------
				//Lease Term Grid Combo Item Setting
				//formObj.f_cmd.value = SEARCH01;
				//sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
				//if ( sXml != "" ) {
				//	sheetObj.InitDataCombo(0, "lstm_cd", " |"+ ComGetEtcData(sXml, "lease_term_nm"), " |"+ ComGetEtcData(sXml, "lease_term_cd"));
				//}
				//----------------------------------------------------------
				sheetObj.WaitImageVisible = true;
				break;

			case IBSAVE:			//저장
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = MULTI;
						sheetObj.DoSave("EES_LSE_0027GS.do", FormQueryString(formObj));
					}
				}
				break;

			case IBSEARCH_ASYNC01:
				//Request No Setting
				sheetObj.WaitImageVisible = false;
				var param = "f_cmd="+SEARCH01+"&ofc_cd="+ComGetObjValue(formObj.rqst_ofc_cd);
				var sXml = sheetObj.GetSearchXml("EES_LSE_0027GS.do",param);
				sheetObj.WaitImageVisible = true;

				if(sXml != "") {
					if ( ComGetEtcData(sXml, "rqst_no") != undefined ) {
						if ( ComGetEtcData(sXml, "rqst_no") != "" ) {
							var vRqstNo = ComGetEtcData(sXml, "rqst_no");
							ComSetObjValue(formObj.rqst_no,  vRqstNo);

							// 조회 후 데이터 가공을 위한 버튼 콘트롤
    						LseComBtnControl(true, "btn_RowAdd|btn_Delete");
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.rqst_no.value = "";
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						formObj.rqst_no.value = "";
					}
				}
				break;

			case IBSEARCH_ASYNC02:	//조회(Form Return Location 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(formObj.rtrn_loc);

					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					setAsycData_ReturnLoc(sXml, formObj.rtrn_loc);
				}
				break;
			case IBSEARCH_ASYNC03:	//조회(Form Return Location 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(formObj.n1st_ref_ofc_cd);

					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					setAsycData_ReturnLoc(sXml, formObj.n1st_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC04:	//조회(Form Return Location 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(formObj.n2nd_ref_ofc_cd);

					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					setAsycData_ReturnLoc(sXml, formObj.n2nd_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC05:	//조회(Form Return Location 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(formObj.n3rd_ref_ofc_cd);

					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					setAsycData_ReturnLoc(sXml, formObj.n3rd_ref_ofc_cd);
				}
				break;
			case IBSEARCH_ASYNC06:	//조회(Form Return Location 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH05+"&loc_tp=SCC"
							  +"&loc_cd="+ComGetObjValue(formObj.n4th_ref_ofc_cd);

					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					setAsycData_ReturnLoc(sXml, formObj.n4th_ref_ofc_cd);
				}
				break;

			case IBSEARCH_ASYNC07:	//조회(Form Currency Code 입력시)
 				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(formObj.curr_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(formObj.curr_cd);
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(formObj.curr_cd);
					}
				}
				break;

 			case IBINSERT:			// 입력
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var Row = sheetObj.DataInsert(-1);
	  					var editFlag = vOrgModCd == "I";
  						sheetObj.CellEditable(Row, "cntr_tpsz_cd") = editFlag;
  						sheetObj.CellValue2(Row,"cntr_tpsz_cd") = editFlag ? "D2" : "";
  						sheetObj.CellValue2(Row,"lstm_cd") = editFlag ? "MI" : "";
  						sheetObj.CellValue2(Row,"rqst_no") = formObj.rqst_no.value;
						sheetObj.CellValue2(Row,"rqst_loc_nm") = formObj.rqst_ofc_cd.value;
						sheetObj.SelectCell(Row,"cntr_no");
					}
				}
				break;
        }
    }

    /**
     * Return Location의 조회결과를 검증한다.
     */
    function setAsycData_ReturnLoc(sXml, obj) {
    	var formObj = document.form;

    	if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
				if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
					var vLocCd = ComGetEtcData(sXml, "scc_cd");
		    		var vTmpStr = formObj.n1st_ref_ofc_cd.value +","
		    					+ formObj.n2nd_ref_ofc_cd.value +","
		    					+ formObj.n3rd_ref_ofc_cd.value +","
		    					+ formObj.n4th_ref_ofc_cd.value;
					var vTmpArr = vTmpStr.split(vLocCd);

					if(obj.name == "rtrn_loc") {
						if(formObj.n1st_ref_ofc_cd.value == "") {
							if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n1st_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n1st_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n2nd_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n2nd_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n2nd_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n3rd_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n3rd_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n3rd_ref_ofc_cd, vLocCd);
			    			}
			    		} else if(formObj.n4th_ref_ofc_cd.value == "") {
			    			if(vTmpArr.length > 1) {
			    				ComShowCodeMessage("LSE01030");
			    	 			ComSetObjValue(formObj.n4th_ref_ofc_cd, "");
			    			} else {
			    				ComSetObjValue(formObj.n4th_ref_ofc_cd, vLocCd);
			    			}
			    		} else {
			    			ComShowCodeMessage("LSE01029");
			    		}

			    		ComSetObjValue(obj, "");
			    		ComSetFocus(obj);
					} else {
						if(vTmpArr.length > 2) {
		    				ComShowCodeMessage("LSE01030");
		    	 			ComSetObjValue(obj, "");
		    	 			ComSetFocus(obj);
		    			} else {
		    				ComSetObjValue(obj, vLocCd);
		    				ComSetNextFocus(obj);
		    			}
					}
		    	} else {
					ComShowCodeMessage("LSE01037");
		    	 	ComSetObjValue(obj, "");
		    	 	ComSetFocus(obj);
				}
			} else {
				var errMsg = LseComGetErrMsg(sXml);
				if ( errMsg != "" ) {
					ComShowMessage(errMsg);
				}
				ComSetObjValue(obj, "");
				ComSetFocus(obj);
			}
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
			var sName = ColSaveName(Col);

			switch(sName) {
				case "cntr_no":
					//입력 컨테이너 번호의 중복을 확인한다.
					var dupRow = ColValueDup("cntr_no", false);
					if(CellValue(dupRow, "cntr_no") != "" && dupRow != -1) {
						ComShowCodeMessage("LSE01075", CellValue(dupRow, "cntr_no"));
						clearForm("cntr_no");
						SelectCell(dupRow, "cntr_no");
					}

					//입력 컨테이너 번호의 유효성 여부를 확인한다.
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH02
 								 + "&cntr_no="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_0027GS.do",param);
 						WaitImageVisible = true;

 						if(sXml != "") {
							if ( ComGetEtcData(sXml, "exist_flag") != undefined ) {
								if(ComGetEtcData(sXml, "exist_flag") == "TRUE") {
									ComShowCodeMessage("LSE01140", Value);
									clearForm("cntr_no");
								}
							}
						}
					}

					//입력 컨테이너 번호의 기본정보를 조회한다.
					if(CellValue(Row,Col) != "" && vOrgModCd == "O") {
						var param = "f_cmd="  + SEARCH03
 								 + "&cntr_no="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_0027GS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "cntr_no") != undefined) {
				 				if (ComGetEtcData(sXml, "cntr_no") != "") {
				 					CellValue2(Row,"cntr_no") 	   = ComGetEtcData(sXml, "cntr_no");
				 					CellValue2(Row,"agmt_cty_cd")  = ComGetEtcData(sXml, "agmt_cty_cd");
				 					CellValue2(Row,"agmt_seq") 	   = ComGetEtcData(sXml, "agmt_seq");
				 					CellValue2(Row,"cntr_tpsz_cd") = ComGetEtcData(sXml, "cntr_tpsz_cd");
				 					CellValue2(Row,"lstm_cd") 	   = ComGetEtcData(sXml, "lstm_cd");
				 					CellValue2(Row,"mvmt_sts_cd")  = ComGetEtcData(sXml, "mvmt_sts_cd");
				 					CellValue2(Row,"pod_cd") 	   = ComGetEtcData(sXml, "pod_cd");
				 					CellValue2(Row,"pol_cd") 	   = ComGetEtcData(sXml, "pol_cd");
				 					CellValue2(Row,"mss_usd_dt")   = ComGetEtcData(sXml, "cnmv_dt");
				 					CellValue2(Row,"mss_use_plc_nm") = ComGetEtcData(sXml, "crnt_yd_cd");
				 					CellValue2(Row,"pd_chg_rt_amt")  = ComGetEtcData(sXml, "pdm_amt");
				 					CellValue2(Row,"lft_chg_rt_amt") = ComGetEtcData(sXml, "lon_amt");
		 						} else {
		 							ComShowCodeMessage("LSE01075");
		 							clearForm("cntr_no");
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "") {
 									ComShowMessage(errMsg);
 								} else {
									ComShowCodeMessage("LSE01074");
 								}

 								clearForm("cntr_no");
 								SelectCell(Row,Col);
 							}
 						}
					}
					break;
				case "mss_use_plc_nm":		// Grid Yard Code Check
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="+SEARCH+"&node_cd="+CellValue(Row,Col)
 								  + "&mode=yard";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) != 1 ) {
							CellValue2(Row,"mss_use_plc_nm") = "";
							ComShowCodeMessage("LSE01048");
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
			var sName = ColSaveName(Col);

			switch(sName) {
				case "mss_use_plc_nm":	//Yard Code No Pop-up
					openPopup("3", Row, Col);
					break;
				case "rqst_file_sav_nm":
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
				 		sheetObj.CellValue2(Row, "rqst_file_sav_nm")   = relativePath;

				 		// 기존파일을 모두 지운후 추가함
				 		upObj.Files = "";
				 		var ret  = upObj.AddFile(fileName);
						var sXml = upObj.DoUpload(true);
						uploadFileName = ComGetEtcData(sXml,"filename");
						sheetObj.CellValue2(Row, "rqst_file_sav_id") = uploadFileName;

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
	    	//특정 컬럼 내에 중복된 값이 존재하는지 여부를 확인
			var dupRow = ColValueDup("cntr_no", false);

			if(CellValue(dupRow, "cntr_no") != "" && dupRow != -1) {
				ComShowCodeMessage("LSE01075", CellValue(dupRow, "cntr_no"));
				ValidateFail = true;
				SelectCell(dupRow, "cntr_no");
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
    		ComShowCodeMessage("LSE10001");
    		// 저장 후 데이터 가공을 위한 버튼 콘트롤
    		LseComBtnControl(false, "btn_RowAdd|btn_Delete");
			// 파일 다운로드를 위한 색상변경
    		sheetObj.ColFontColor("rqst_file_sav_nm") = sheetObj.RgbColor(0, 0, 255);
    	}
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//sheetObj.FitColWidth();
    }

    /**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("rqst_file_sav_nm") = linkFlag;
		}
	}

	/**
	 * sheet1_OnClick
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "rqst_file_sav_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "rqst_file_sav_id");
					break;
			}
		}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Return Location. Popup for FORM, 2:Currency Code Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, "setPopData_ReturnLoc", "1,0,1,1,1,1,1", true);
    	} else if ( type == "2" ) {
			ComOpenPopup('/hanjin/COM_ENS_N13.do', 500, 420, 'setPopData_Currency', '1,0,1', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 610, "setPopData_YardCode", "1,0,1,1,1,1,1,1", true, false, Row, Col, 0);
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
    function setPopData_ReturnLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		var vLocCd = aryPopupData[0][10];	//SCC
    		var vTmpStr = formObj.n1st_ref_ofc_cd.value +","
    					+ formObj.n2nd_ref_ofc_cd.value +","
    					+ formObj.n3rd_ref_ofc_cd.value +","
    					+ formObj.n4th_ref_ofc_cd.value;
			var vTmpArr = vTmpStr.split(vLocCd);

			if(formObj.n1st_ref_ofc_cd.value == "") {
				if(vTmpArr.length > 1) {
					ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n1st_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n1st_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n2nd_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n2nd_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n2nd_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n3rd_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n3rd_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n3rd_ref_ofc_cd, vLocCd);
    			}
    		} else if(formObj.n4th_ref_ofc_cd.value == "") {
    			if(vTmpArr.length > 1) {
    				ComShowCodeMessage("LSE01030");
    	 			ComSetObjValue(formObj.n4th_ref_ofc_cd, "");
    			} else {
    				ComSetObjValue(formObj.n4th_ref_ofc_cd, vLocCd);
    			}
    		} else {
    			ComShowCodeMessage("LSE01029");
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
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][2]);
		}
	}

	/**
      * Yard Code Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_YardCode(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);

				switch(sName) {
					case "mss_use_plc_nm":
						CellValue2(Row, sName) = aryPopupData[0][3]; //Yard
						break;
					default :	//do nothing
				}
			}
		}
     }

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			//return checkDupData(sheetObj);
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
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		switch(fieldName) {
			case "cntr_no":
				with(sheetObj) {
					CellValue2(SelectRow, "cntr_no") 	    = "";
					CellValue2(SelectRow, "agmt_cty_cd")    = "";
					CellValue2(SelectRow, "agmt_seq") 	    = "";
					CellValue2(SelectRow, "cntr_tpsz_cd")   = "";
					CellValue2(SelectRow, "lstm_cd") 	    = "";
					CellValue2(SelectRow, "mvmt_sts_cd") 	= "";
					CellValue2(SelectRow, "pod_cd") 	    = "";
					CellValue2(SelectRow, "pol_cd") 	    = "";
					CellValue2(SelectRow, "mss_usd_dt")     = "";
					CellValue2(SelectRow, "mss_use_plc_nm") = "";
					CellValue2(SelectRow, "pd_chg_rt_amt")  = "";
					CellValue2(SelectRow, "lft_chg_rt_amt") = "";
				}
				break;
			default :	//do nothing
		}
	}

	/* 개발자 작업  끝 */