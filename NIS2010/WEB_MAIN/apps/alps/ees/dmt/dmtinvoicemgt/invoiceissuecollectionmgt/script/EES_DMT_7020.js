/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DMT_7020.js
*@FileTitle : DEM/DET Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.03.22 김기태
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
     * @class EES_DMT_7020 : EES_DMT_7020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

    function EES_DMT_7020() {
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

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var pgm_no = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */

    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];		
		var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
	    		case "btn_retrieve":
	    			doActionIBSheet(sheetObj,formObj,IBSEARCH);
	    			break;

				case "btn_detail":
					if(sheetObj.SelectRow != -1) {
						openPayerPopup(sheetObj, sheetObj.SelectRow);
					}
					break;

				case "btn_new":
                	initViewControl();
                    break;
                
				case 'btns_cust_cd':
                	// Customer 검색 공통 팝업 호출
                	ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
                	break;               	

                case 'btn_down_excel':
                	sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'CheckBox');
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
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정
  	 */
    function getCustCd(aryPopupData) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.payr_cd, aryPopupData[0][3]);
    }

    /**
     * Payer Info Creation 팝업 창에서 Close 시 현재 목록을 갱신을 위해 재조회한다.
     */
    function retrievePayerInfoList(){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	} 

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	pgm_no = ComGetObjValue(formObj.pgm_no);
    	
    	for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        // IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        initViewControl();
        
        otsEmailAddressFlg();
    }

    function initControl() {
//        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
//        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
//        axon_event.addListenerFormat( 'keypress' , 'obj_OnKeyPress'  , 'payr_cd' ); //- 키보드 입력할때
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 * 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   		var formObj = document.form;
   	    switch(comboObj.id) {
   	    	case "svr_id":
   	    		with (comboObj) {
   					MultiSelect = false;
   					UseAutoComplete = false;
   					DropHeight = 160;
   					ValidChar(2,0);		//영문 대문자 
   		    	}
   	    		var comboItems = ['CHN', 'EUR', 'KOR', 'SWA', 'USA'];
				for (var i = 0 ; i < comboItems.length ; i++) {
					comboObj.InsertItem(i, comboItems[i], comboItems[i]);
		    	}
   				break;   				

   	    	case "payer_type":
   	    		with (comboObj) {
   					MultiSelect = false;
   					UseAutoComplete = false;
   					DropHeight = 160;
   		    	}
   	    		var comboItems = ['A=All', 'C=Customer', 'S=S/P'];
				for (var i = 0 ; i < comboItems.length ; i++) {
					var item = comboItems[i].split(FIELDMARK);
					comboObj.InsertItem(i, item[1], item[0]);
		    	}
				comboObj.Code = 'A'; // Default All
   				break;

   	    	case "sending_cycle":
   	    		with (comboObj) {
   					MultiSelect = true;
   					UseAutoComplete = false;
   					DropHeight = 160;
   		    	}
   	    		doActionIBCommon(sheetObjects[0], formObj, SEARCH15);
   				break;
   				
   	    	case "email":
   	    		with (comboObj) {
   	    		MultiSelect = false;
   	    		UseAutoComplete = false;
   	    		DropHeight = 160;
   	    	}
   	    		var comboItems = ['A=All', 'Y=Y', 'N=N'];
				for (var i = 0 ; i < comboItems.length ; i++) {
					var item = comboItems[i].split(FIELDMARK);
					comboObj.InsertItem(i, item[1], item[0]);
		    	}
				comboObj.Code = 'A'; // Default All
   	    		break; 
   	     }
   	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
    	var formObj = document.form;
        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 460;                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);
                    
                    var HeadTitle1 	= 	"|Seq.|SVR ID|Payer Code|Payer Type|Payer Name|E-mail Addr Exist|Sending Cycle|Sending Cycle Code|OTS Sheet|OTS Sheet|OTS Sheet|OTS Sheet|cust_cnt_cd|cust_seq|ATTN|Tel.|Fax|E-mail|Sheet|OTS Receiver";
                    var HeadTitle2 	= 	"|Seq.|SVR ID|Payer Code|Payer Type|Payer Name|E-mail Addr Exist|Sending Cycle|Sending Cycle Code|ots_sh_grp_cd|Group by|With CNTR List|With Invoice|cust_cnt_cd|cust_seq|ATTN|Tel.|Fax|E-mail|Sheet|OTS Receiver";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다[SORT, ColMove, AllCheck, UserResize, RowMove, Head3D]
                    InitHeadMode(true, true, false, true, false, false);                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,			daCenter,   true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,			daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"sys_area_grp_id",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"payr_cd",					false,		"",			dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"payr_tp",					false,		"",			dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,			280,		daLeft,		true,		"payr_nm",					false,		"",			dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,		"eml_exist_flg",			false,		"",			dfNone,		0,			false,		false);						                               
					InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"snd_cyc_desc",				false,		"",			dfNone,		0,			false,		false);						                               
					InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,	false,		"snd_cyc_cd",				false,		"",			dfNone,		0,			false,		false);						                               
					InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,	false,		"ots_sh_grp_cd",			false,		"",			dfNone,		0,			false,		false);						                               
					InitDataProperty(0, cnt++ , dtData,			100,		daCenter,   false,		"ots_sh_grp_desc",			false,		"",			dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtCheckBox,		100,			daCenter,	false,		"snd_cntr_list_flg",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,	false,		"snd_inv_flg",    			false,		"",			dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,	true,		"cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,	true,		"cust_seq");	

					InitDataProperty(0, cnt++ , dtData,			160,		daLeft,		true,		"payr_cntc_pnt_nm",			false,		"",			dfNone,		0,			false,		false,		45);
					InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,		"payr_cntc_pnt_phn_no",		false,		"",			dfNone,		0,			false,		false,		20);	                             
					InitDataProperty(0, cnt++ , dtData,			150,		daLeft,   	true,		"payr_cntc_pnt_fax_no",		false,		"",			dfNone,		0,			false,		false,		20);	
					InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,		"payr_cntc_pnt_eml",		false,		"",			dfNone,		0,			false,		false,		100);
					InitDataProperty(0, cnt++ , dtCheckBox,		60,			daCenter,	true,		"sheet",    				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,	true,		"ots_snd_flg",    			false,		"",			dfNone,		0,			false,		false);

					Ellipsis = true;
                }
                break;
        }
    }	

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					ComSetObjValue(formObj.sys_area_grp_id, ComGetObjValue(formObj.svr_id));
					ComSetObjValue(formObj.snd_cyc_cd, ComGetObjValue(formObj.sending_cycle));
					ComSetObjValue(formObj.eml_exist_flg, ComGetObjValue(formObj.email));
					var payr_tp = ComGetObjValue(formObj.payer_type);
					ComSetObjValue(formObj.sp_yn, payr_tp == 'A' ? '' : (payr_tp == 'S' ? 'Y' : 'N'));
					
					if ( formObj.otsEmailFlg.checked ){
						ComSetObjValue(formObj.ots_email_flg, "Y");
					} else {
						ComSetObjValue(formObj.ots_email_flg, "N");
					}
					sheetObj.DoSearch("EES_DMT_7020GS.do", FormQueryString(formObj));
				}
				break;	
        }
    }

	/*
	 * 초기화
	 */
	function initViewControl(){
		var formObj = document.form;
		ComSetObjValue(formObj.payr_cd, '');
		
		//combo박스 초기화
		doActionIBCommon(sheetObjects[0], formObj, SEARCH27);
		comboObjects[1].Code = "A";
		comboObjects[3].Code = "A";
	    selectAllSendingCycle();
	}    

    //콤보관련 데이터를 조회하는 함수
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	

        switch(sAction) {
        	//로그인 OFC에 해당하는 SYS_AREA_GRP_ID 조회
			case SEARCH27:
				ComSetObjValue(formObj.f_cmd, SEARCH27);
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				ComSetObjValue(formObj.svr_id, ComGetEtcData(sXml, "SVR_ID"));
				break;

			//Sending Cycle 목록 조회
			case SEARCH15:
				var comboObj = comboObjects[2];
				ComSetObjValue(formObj.f_cmd, SEARCH15);
			    ComSetObjValue(formObj.intg_cd_id, "CD03506");
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				var codeList = ComGetEtcData(sXml, "COMMON_CD");

				// 콤보 데이터 설정
				var comboDatas = codeList.split(ROWMARK);
				comboObj.InsertItem(0, 'All', 'A');
				comboObj.InsertItem(1, 'Not Set', 'N');
				for(var i = 0; i < comboDatas.length; i++) {
					var item = comboDatas[i].split(FIELDMARK);
					comboObj.InsertItem(i + 2, item[1], item[0]);
				}
				break;
        }
		sheetObj.WaitImageVisible = true;
    }    

    /*
	 * 더블클릭 팝업
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {

		if(sheetObj.SelectRow != -1) {
			openPayerPopup(sheetObj, Row);
		}
	}

	/**
	 * Billing에서 사용하는 Payer Info 공통 팝업창을 호출한다.<br>
	 * 본 화면에서는 선택한 행의 Payer Code에 해당하는 정보를 띄운다.
	 *
	 * @param sheetObj
	 * @param Row
	 * @returns
	 */
	function openPayerPopup(sheetObj, Row) {

		var formObj = document.form;

		var cust_cd = '';
		var cust_cnt_cd = sheetObj.CellValue(sheetObj.SelectRow, "cust_cnt_cd");
		var str = "" + sheetObj.CellValue(sheetObj.SelectRow, "cust_seq");
		
		var pad = "000000";
		var cust_seq_str = pad.substring(0, pad.length - str.length) + str;

		if(cust_cnt_cd == '00') { // 6자리 S/P 코드
			cust_cd = cust_seq_str;
		} else {
			cust_cd = cust_cnt_cd + cust_seq_str;
		}
		var cust_gubun = sheetObj.CellValue(sheetObj.SelectRow, "payr_tp") == 'Customer' ? '2' : '1';  // 1 - S/P , 2 - Customer
		
		var url = "EES_DMT_4104.do";
		var param = "?s_cust_cd=" + cust_cd
			+"&s_cust_gubun=" + cust_gubun
			+"&jspno=" + ComGetObjValue(formObj.pgm_no)
			+"&s_ofc_cd="+ComGetObjValue(formObj.s_ofc_cd)
			+"&svr_id="+sheetObj.CellValue(sheetObj.SelectRow, "sys_area_grp_id")
			;
		var returnValue = ComOpenWindowCenter(url + param, "EES_DMT_4104", "825","620", true);
	}	

	//멀티콤보 클릭 이벤트
	function sending_cycle_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code);
	}

	/**
	 * Sending Cycle 전체 선택해준다.
	 */
	function selectAllSendingCycle(){
		var comboObj = comboObjects[2];
		for (var i = 0 ; i < comboObj.GetCount; i++) {
			comboObj.CheckIndex(i) = true; 
		}
	}

    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} SheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj의 선택된 Row
     * @param {ibsheet} Col         sheetObj의 선택된 Col
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            var colName = ColSaveName(Col);
        }
        // 셀 콤보가 변경될 때 코드값을 함께 변경시켜준다
        switch(colName) {
	        case 'snd_cyc_desc':
	        	sheetObj.CellValue(Row, 'snd_cyc_cd') = Value;
	        	break;
	        case 'ots_sh_grp_desc':
		        sheetObj.CellValue(Row, 'ots_sh_grp_cd') = Value;
		    	break;
        }
    }
    
    function otsEmailAddressFlg() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];		
		
		if ( formObj.otsEmailFlg.checked ){
			sheetObj.ColHidden("payr_cntc_pnt_nm") 		= false;
			sheetObj.ColHidden("payr_cntc_pnt_phn_no") 	= false;
			sheetObj.ColHidden("payr_cntc_pnt_fax_no") 	= false;
			sheetObj.ColHidden("payr_cntc_pnt_eml") 	= false;
			sheetObj.ColHidden("sheet") 				= false;
			sheetObj.ColHidden("ots_snd_flg") 			= false;
		} else {
			sheetObj.ColHidden("payr_cntc_pnt_nm") 		= true;
			sheetObj.ColHidden("payr_cntc_pnt_phn_no") 	= true;
			sheetObj.ColHidden("payr_cntc_pnt_fax_no") 	= true;
			sheetObj.ColHidden("payr_cntc_pnt_eml") 	= true;
			sheetObj.ColHidden("sheet") 				= true;
			sheetObj.ColHidden("ots_snd_flg") 			= true;
		}
    }
    

	/**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;  		
  		otsEmailAddressFlg();
  	}
    