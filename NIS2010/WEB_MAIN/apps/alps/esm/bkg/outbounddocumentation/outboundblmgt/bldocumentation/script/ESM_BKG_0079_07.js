/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_07.js
*@FileTitle : C/M by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
===============================================================================
 History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
* 2012.08.06 김보배 [CHM-201219468] [BKG] [C/M] Syria - HS Code Mandatory 및 pop-up msg
* 2012.11.08 김보배 [CHM-201221406] [BKG] 이란 Sanction 관련 HS Code 삽입 로직 보완 요청
* 2012.11.20 김보배 [CHM-201221505] [BKG] [BKG MAIN] Germany HS code Mandatory 설정 요청
* 2013.01.10 변종건 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청
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
     * @class esm_bkg_0079_07 : esm_bkg_0079_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079_07() {
    	this.processButtonClick		= processButtonClick;
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
	var decision_flag = -1; //0-NO, 1-Yes, 2-Close

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display = "none";
        		}    	    			
    		}
			
            switch(srcName) {

				case "dcgo_flg":
				case "bb_cgo_flg":
				case "awk_cgo_flg":
				case "rc_flg":
				case "rd_cgo_flg":
				case "hngr_flg":
					return false;
				break;

				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				
				case "btn_t9AllConfirm":
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
				break;

				case "btn_t9AllRelease":
					doActionIBSheet(sheetObject1,formObject,COMMAND02);
				break;



				case "btn_t9Add":
					if(ComIsBtnEnable("btn_t9Add")){
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
				break;

				case "btn_t9Del":
					if(ComIsBtnEnable("btn_t9Del")){
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
				break;

				case "btn_t9CopyMnd":
					if(ComIsBtnEnable("btn_t9CopyMnd")){
						doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					}
				break;

				case "btn_t9Retrieve":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
				break;

				case "btn_t9Save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;

				case "btn_t9CMCopyCM":
					var selIdx = sheetObject1.SelectRow;
					if(selIdx > 0){
						var cntr_no  = sheetObject1.CellValue(selIdx, "cntr_no");
						var cntr_tpsz_cd = sheetObject1.CellValue(selIdx, "cntr_tpsz_cd");
						var url = "ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
						ComOpenWindow(url, "ESM_BKG_0176", "width=450,height=300", false);
					}else{
						ComShowMessage(ComGetMsg("BKG00188"));
					}
				break;
				
				case "btn_t9CopyFmCntr":
//					alert("btn_t9CopyFmCntr");
					doActionIBSheet(sheetObject2,formObject,COMMAND05);
				break;
				
				case "btn_t9CMbyCntr":
					var cntr_no = formObject.cntr_no.value;
					var t_vvd = formObject.t_vvd.value;
//					alert(cntr_no + " " + t_vvd);
					var url = "ESM_BKG_0178.do?pgmNo=ESM_BKG_0178&cntr_no="+cntr_no+"&t_vvd="+t_vvd;
					ComOpenWindowCenter(url, "ESM_BKG_0178", 1014, 680, false);
				break;

				case "btn_t9NVOHBL":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0366.do?pgmNo=ESM_BKG_0366&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0366", 1014, 640, false);
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

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//
			initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].WaitImageVisible=false;
		}

		//iframe 생성 
//    	CofigIframe();

    	//------------------------------------------------>
    	//setInquiryDisableButton 이벤트 호출
   		setInquiryDisableButton();
     	//------------------------------------------------>
   		
        // do initialize
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		initControl();
    }

	function initControl() {
		//add listener
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		applyShortcut();
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

			case "t9sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
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

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(25, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle = "|C|Container No.|C/M|seal_no|cntr_tpsz_cd|rcv_term_cd|de_term_cd|cntr_vol_qty|adv_shtg_cd|dcgo_flg|bb_cgo_flg|awk_cgo_flg|rc_flg|rd_cgo_flg|hngr_flg|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|A1|A2|A3";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,         WIDTH,     DATAALIGN,   COLMERGE,     SAVENAME,        KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,    40,        daCenter,    false,        "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,        30,        daCenter,    false,        "mf_cfm_flg",    false,     "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtData,            110,       daCenter,    false,        "cntr_no",       false,     "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,            20,        daCenter,    false,        "cntr_mf_flag",  false,     "",         dfNone,     0,          false,      false);

                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "cntr_seal_no",  false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "cntr_tpsz_cd",  false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "rcv_term_cd",   false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "de_term_cd",    false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "cntr_vol_qty",  false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "adv_shtg_cd",   false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "dcgo_flg",      false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "bb_cgo_flg",    false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "awk_cgo_flg",   false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "rc_flg",        false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "rd_cgo_flg",    false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daLeft,      false,        "hngr_flg",      false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daRight,     false,        "pck_qty",       false,     "",         dfInteger,  0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daCenter,    false,        "pck_tp_cd",     false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daRight,     false,        "cntr_wgt",      false,     "",         dfFloat,    3,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daCenter,    false,        "wgt_ut_cd",     false,     "",         dfNone,     0,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daRight,     false,        "meas_qty",      false,     "",         dfFloat,    3,          true,       true);
                    InitdataProperty(0, cnt++, dtHidden,          10,        daCenter,    false,        "meas_ut_cd",    false,     "",         dfNone,     0,          true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,         70,        daRight,     false,        "cm_pck_qty",    false,     "",         dfInteger,  0,          true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,         70,        daRight,     false,        "cm_cntr_wgt",   false,     "",         dfFloat,    3,          true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,         70,        daRight,     false,        "cm_meas_qty",   false,     "",         dfFloat,    3,          true,       true);
                    
                    

				}
				break;

			case "t9sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 202;
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

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(31, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false);

					var HeadTitle = "|Sel.|Seq.|MfSeq.|CntrNo|Package|Package|Package|WPM|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|HTS Code|HTS Code|HS Code|HS Code|NCM Code|NCM Code|NCM Code|NCM Multi Flag|NCM Multi Code|Manifest File No.|Self|DG|DG|AK|HG";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,     "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,     daCenter,   false,     "sel");
                    InitDataProperty(0, cnt++ , dtData,         30,     daCenter,   false,     "seq",              false,     "",          dfNone,      0,           false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,       20,     daRight,    false,     "cntr_mf_seq",      false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   false,     "cntr_no",          false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         50,     daRight,    false,     "pck_qty",          false,     "",          dfInteger,   0,           true,        true, 7);
                    InitDataProperty(0, cnt++ , dtData,         40,     daCenter,   false,     "pck_tp_cd",        false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        20,     daCenter,   false,     "PCKPop",           false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtCombo,        40,    	daCenter,  	false,     "wpm_trt_cd",       false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,    false,     "cntr_mf_wgt",      false,     "",          dfFloat,     3,           true,        true, 13);
                    InitDataProperty(0, cnt++ , dtHidden,       20,     daCenter,   false,     "wgt_ut_cd",        false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,    false,     "meas_qty",         false,     "",          dfFloat,     3,           true,        true, 9);
                    InitDataProperty(0, cnt++ , dtHidden,       20,     daCenter,   false,     "meas_ut_cd",       false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daLeft,     false,     "cntr_mf_mk_desc",  false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtPopup,        20,     daCenter,   false,     "MDPop",            false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,        250,     daLeft,     false,     "cntr_mf_gds_desc", false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   false,     "hamo_trf_cd",      false,     "",          dfNone,      0,           true,        true,    10);
                    InitDataProperty(0, cnt++ , dtPopup,        20,     daCenter,   false,     "HTCPop",           false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   false,     "cmdt_hs_cd",       false,     "",          dfNone,      0,           true,        true,    8);
                    InitDataProperty(0, cnt++ , dtPopup,        20,     daCenter,   false,     "CMDTPop",          false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   false,     "ncm_no",           false,     "",          dfNone,      0,           true,        true,    8);
                    InitDataProperty(0, cnt++ , dtPopup,        20,     daCenter,   false,     "NCMPop",           false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++, 	dtImage,     	20,    	daCenter,  	true,      "ncm_multi_pop",    false,     "",          dfNone,    	0,     		 false,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   100,		daLeft,		false,	   "ncm_multi_flg",	   false,	  "",      	   dfNone,		0,			 false,		  false);
					InitDataProperty(0, cnt++ , dtHidden,	   100,		daLeft,		false,	   "ncm_multi_no",	   false,	  "",      	   dfNone,		0,			 false,		  false);
                    InitDataProperty(0, cnt++ , dtData,        100,     daCenter,   false,     "cntr_mf_no",       false,     "",          dfNone,      0,           true,        true);
					InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   false,     "self",             false,     "",          dfNone,      0,           true,        true);

                    InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   false,     "dcgo_flg",         false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtCombo,       210,    	daLeft,  	false,     "dcgo_seq",         false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   false,     "awk_cgo_flg",      false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   false,     "hngr_flg",         false,     "",          dfNone,      0,           true,        true);

					ShowButtonImage = 2;
					CountPosition = 0;
					
					ImageList(0) = "/hanjin/img/button/btns_multisearch.gif";
 					ImageList(1) = "/hanjin/img/button/btns_multisearch.gif";
					DataLinkMouse("ncm_multi_pop") = true;

					AutoRowHeight = false;
				}
			break;
			
			
			case "t9sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
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

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(3, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false);

					var HeadTitle = "cntr_no|dcgo_seq|diff_rmk";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "cntr_no",          false,     "",          dfNone,   0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "dcgo_seq",        false,     "",          dfNone,      0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "diff_rmk",      false,     "",          dfNone,     0,           true,        true);
                    
					CountPosition = 0;

					AutoRowHeight = false;
				}
			break;
			
			
			case "t9sheet4":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
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

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false);

					var HeadTitle = "ATTR_CTNT5|ATTR_CTNT6|HRD_CDG_ID|HRD_CDG_ID_SEQ";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,  DATAALIGN,  COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	"attr_ctnt5",		false,		"",			dfNone,		0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	"attr_ctnt6",		false,		"",			dfNone,		0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,	200,	daCenter,	false,	"hrd_cdg_id",		false,		"",			dfNone,		0,           true,        true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	"hrd_cdg_id_seq",	false,		"",			dfNone,		0,           true,        true);
                    
					CountPosition = 0;
					AutoRowHeight = false;
				}
			break;

        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	//	sheetObj.ShowDebugMsg = 1;
		switch(sAction) {

			case IBSEARCH:      // 기본값 조회
				/* 변경 사항이 있을 경우 "SAVE_CNFM" 메시지를 표시한다. - Yes를 선택하면 save를 호출한다. */
				if(formObj.dirty_flag.value == 'Y'){
					if(confirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObj, formObj, IBSAVE);
						return;
					}
				}

				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value = SEARCH;
					//sheetObj.DoSearch("ESM_BKG_0079_07GS.do", FormQueryString(formObj));+
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_07GS.do", FormQueryString(formObj));
                    if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
										
                    var arrXml = rXml.split("|$$|");
//                    alert("xml count : " + arrXml.length);
					if(arrXml.length==5){
						var cmCntrXml  = arrXml[0];
						var cmDtlXml  = "<?xml version='1.0' ?>" + arrXml[1];
						var cdgCgoXml  = arrXml[2];
						var HrdCdgXml  = arrXml[3];
						var wpmXml  = arrXml[4];
						
						// HrdCdgCtnt
						sheetObjects[3].LoadSearchXml(HrdCdgXml, false);
						
						// DG CGO Info
						sheetObjects[2].LoadSearchXml(cdgCgoXml, false);
						
						if(sheetObjects[2].TotalRows  > 0){							 
							var arrData = ComBkgXml2ComboString(cdgCgoXml, "dcgo_seq", "diff_rmk");
						     arrData[1] =" \t |"+ arrData[1];
						     arrData[0] =" |"+ arrData[0];
						     sheetObjects[1].InitDataCombo(0,"dcgo_seq", arrData[1], arrData[0]);
						 }

						var arrData = ComBkgXml2ComboString(wpmXml, "val", "multidesc");
					    arrData[1] =" \t |"+ arrData[1].replace("|A","|N/A");
					    arrData[0] =" |"+ arrData[0];
					    sheetObjects[1].InitDataCombo(0,"wpm_trt_cd", arrData[1], arrData[0]);
					     
						formObj.old_bkg_no.value = ComGetEtcData(arrXml[0],"bkg_no");  
						// CM Booking Info
						ComEtcDataXmlToForm(cmCntrXml, formObj);
						// CM Container Info
						sheetObjects[0].LoadSearchXml(cmCntrXml, false);
						// CM Cntr MF Info
						sheetObjects[1].LoadSearchXml(cmDtlXml, false);
						// Show & Hide
						if(sheetObjects[0].TotalRows  > 0){
							sheetObjects[0].SelectCell(1, "cntr_no", false);
							setCMInfo(1);
						}
						

					     
						//BDR flag = "Y" 일 경우 BKG no 바탕색을 파랑게 변경. "N"일 경우 흰색으로 변경
						if(formObj.bdr_flg.value == 'Y'){
							document.getElementById("bkg_no").className = "input1";
						}else{
							document.getElementById("bkg_no").className = "input";
						}
						// Confrim Release 상태
						var cfmFlg = ComFindText(sheetObjects[0], "mf_cfm_flg", 0);
						if(cfmFlg.length == 0){
							formObj.bkg_cfm_flg.value = "CMCFM";
							//formObj.mf_cfm_flg.value = 'Y';
						}else{
							formObj.bkg_cfm_flg.value = "CMRLSE";
							//formObj.mf_cfm_flg.value = 'N';
						}
						// 데이타 수정 여부 기록 
						formObj.dirty_flag.value = 'N';
						// ca controll
						//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
						if(parent.t9frame != undefined && typeof(parent.t9frame) == "object") {
							parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value); 
						}
						
						
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}
					}else{
						//alert("SEARCH xml : " + arrXml.length);
						return;
					}
				}finally{
					ComOpenWait(false);
				}
				}
			break;

			case IBSAVE:        //저장
				if(document.form.isInquiry.value == "Y") return;
				
				if(validateForm(sheetObj,formObj,sAction)){
					//BKG95061 [CHM-201324007] 개발:CNTR Screen에서 WGT 관련 Pop-up 생성 개발
                	formObj.f_cmd.value = SEARCH02;
                	// form param
					var sParam = FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					// Sheet2 param
					var sParamSheet2 = sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
                	
                	
    				//params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true), "sheet1_");
    	           	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_07GS.do", sParam);
    	           	var arrXml = sXml.split("|$$|");
    	           	var chkFlg = ComGetEtcData(arrXml[0],"chkFlg");
    	           	if(chkFlg =="Y"){
    	           		ComShowMessage(ComGetMsg("BKG95061"));
    	           	}
					
					
					try {
						ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						
						
						//2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 - Start
						var stwg_flg = false
						if( document.form.cmdt_cd.value == "251506" || document.form.cmdt_cd.value == "251501" || document.form.cmdt_cd.value == "250031" || document.form.cmdt_cd.value == "251603" ){
							for( var idx = sheetObjects[1].HeaderRows; idx <= sheetObjects[1].LastRow; idx++ ){
								var fndRow = sheetObjects[0].FindText("cntr_no", sheetObjects[1].CellValue(idx,"cntr_no"));
								if( sheetObjects[0].CellValue(fndRow,"cntr_tpsz_cd") == "D2" ){
									if( sheetObjects[1].CellValue(idx,"cntr_wgt") != "" && sheetObjects[1].CellValue(idx,"pck_qty") != "" ){
										if( parseFloat(sheetObjects[1].CellValue(idx,"cntr_mf_wgt")) / parseFloat(sheetObjects[1].CellValue(idx,"pck_qty")) >= 5000 ){
											stwg_flg = true;
										}
									}
								}
							}
						}
						if( stwg_flg == true ){
							document.form.stwg_cd.value = "MUPG";
						} else{
							document.form.stwg_cd.value = "";
						}
						//2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 - End
						
						
						// form param
						var sParam = FormQueryString(formObj);
						// Sheet1 param
						var sParamSheet1 = sheetObjects[0].GetSaveString();
						if (sParamSheet1 != "") {
							sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
						}
						// Sheet2 param
						var sParamSheet2 = sheetObjects[1].GetSaveString();
						if (sParamSheet2 != "") {
							sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
						}

						// return xML
						var rXml = sheetObj.GetSaveXml("ESM_BKG_0079_07GS.do", sParam, true);
						var rMsg = ComResultMessage(rXml);
						var dgKeyFlg = ComGetEtcData(rXml, "dg_key_flg");
						var dgKeyFlg2 = ComGetEtcData(rXml, "dg_key_flg2");
						if(rMsg == ''){
							/* Transaction 상태 복원 */
							sheetObjects[0].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
							sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
							/* 데이터 변경 여부 체크 */
							formObj.dirty_flag.value = 'N';
							//POTENTIAL DG화물목록이있는지 확인메세지
							if(dgKeyFlg=="Y")
								ComShowMessage(ComGetMsg("BKG08314"));
							if(dgKeyFlg2!="N")
								ComShowCodeMessage("BKG95100",dgKeyFlg2);
							/* 성공메세지 */
							ComShowMessage(ComGetMsg("BKG00166"));
							
							/* 2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 성공 메시지 */
							if( stwg_flg == true ){
								ComShowMessage(ComGetMsg("BKG08249"));
							}
							
							doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
							
							setCMInfo(1);
						} else {
							//alert(rMsg.split('<||>').join('\n'));
							ComShowMessage(rMsg);
						}
					}finally{
						ComOpenWait(false);
					}
				}
			break;



			case IBINSERT:      // 입력
				/* confirm 상태 일경우 수정 불가 */
				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;

				if(formObj.cntr_no.value == '' || sheetObjects[0].RowCount == 0 || sheetObjects[0].SelectRow < 1){
					ComShowMessage(ComGetMsg("BKG08130"));
					return;
				}else{
					if(sheetObj.SelectRow == -1){
						for(var i = sheetObj.LastRow;i>-1;i-- ){
							if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no") == sheetObj.CellValue(i,"cntr_no")){
								sheetObj.SelectRow = i;
								break;
							}								
						}					
					}
				
					var newRow = sheetObj.DataInsert();
	
					sheetObj.CellValue2(newRow, "cntr_no")     = formObj.cntr_no.value;
					sheetObj.CellValue2(newRow, "pck_qty")     = 0;
					//sheetObj.CellValue2(newRow, "pck_tp_cd")   = formObj.bkg_pck_unit.value;
					sheetObj.CellValue2(newRow, "cntr_mf_wgt") = 0;
					sheetObj.CellValue2(newRow, "wgt_ut_cd")   = formObj.wgt_ut_cd.value;
					sheetObj.CellValue2(newRow, "meas_qty")    = 0;
					sheetObj.CellValue2(newRow, "meas_ut_cd")  = formObj.meas_ut_cd.value;
					sheetObj.CellValue2(newRow, "ncm_multi_pop")  = 0;
						
					// changeEditable
					changeEditable();
					// rearangeSeq
					setSeq();
	
					/* 수정 여부 기록 */
					formObj.dirty_flag.value = 'Y';
				}
			break;

			case IBDELETE:      // 삭제
				/* confirm 상태 일경우 수정 불가 */
				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;
				/* Row 삭제 */
				ComRowDelete(sheetObj, "sel", 1);
				//ComRowHideDelete(sheetObj, "sel");
				/* Queantity 재계산*/
				syncQuantity("pck_qty");
				syncQuantity("cntr_mf_wgt");
				syncQuantity("meas_qty");
				// changeEditable
				//changeEditable();
				// rearangeSeq
				setSeq();
				/* 수정 여부 기록 */
				formObj.dirty_flag.value = 'Y';

			break;

			case IBCOPYROW:
				/* confirm 상태 일경우 수정 불가 */
				//alert("->" + formObj.mf_cfm_flg.value);
				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;
				/*Rep Commodity 가 00 또는 99 인 경우 validation 처리 - 메시지 [BKG00338]를 표시하고 리턴처리*/
				//if(formObj.rep_cmdt_cd.value == '00' || formObj.rep_cmdt_cd.value == '99'){
				//	ComShowMessage(ComGetMsg("BKG00338"));
				//	return;
				//}
				/* mk_desc */
				//alert(sheetObj.id + " " +sheetObj.RowCount+ "/" + sheetObj.SelectRow + " - " + formObj.bkg_mk_desc.value);
				//alert(sheetObj.RowHidden(sheetObj.SelectRow)==false)
				if(sheetObj.RowCount > 0 && sheetObj.SelectRow > 0 && sheetObj.RowHidden(sheetObj.SelectRow)==false) {
					// quantity
					sheetObj.CellValue2(sheetObj.SelectRow, "pck_qty")     = formObj.bkg_pck_qty.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "pck_tp_cd")   = formObj.bkg_pck_unit.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_wgt") = formObj.bkg_wgt_qty.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "wgt_ut_cd")   = formObj.wgt_ut_cd.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "meas_qty")    = formObj.bkg_meas_qty.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "meas_ut_cd")  = formObj.meas_ut_cd.value;
					// description
					sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_mk_desc") = formObj.bkg_mk_desc.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_gds_desc") = formObj.bkg_cstms_desc.value;
					/* 수정 여부 기록 */
					formObj.dirty_flag.value = 'Y';
				}

			break;



			case COMMAND01:
				// 2. 좌측그리드의 체크박스를 전체 체크 설정
				var isAsk = false;
				var rflg = false;
				var rcnt = sheetObj.RowCount;
				if(formObj.pod_cd.value.substring(0, 2)=="BR"){
					for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
						if(sheetObjects[1].CellValue(ix, "meas_qty")==0||ComIsEmpty(sheetObjects[1].CellValue(ix, "ncm_no"))){
							ComShowCodeMessage("BKG95077");
							//CBM & NCM no is mandatory for Brazil manifest, please update it.
							return false;
						}
						
					}
				}
				
				if(formObj.pol_cd.value.substring(0,2)=="BR"||formObj.pod_cd.value.substring(0,2)=="BR"){
					for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
						if(ComIsEmpty(sheetObjects[1].CellValue(ix, "wpm_trt_cd"))){
							ComShowCodeMessage("BKG95104");
							//The WPM (Wooden Packing Material) Treatment status should be manifested to Brazil customs for export/import cargo. please select WPM
							return false;
						}
						if(sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WC"
							||sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WP"
							||sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WT"){
							if("A"==sheetObjects[1].CellValue(ix, "wpm_trt_cd")){
								ComShowCodeMessage("BKG95105");
								//If package type is WC or WP or WT, You cannot select ‘N/A’ in WPM field.
								return false;
							}
						}
					}
				}
				
				// 2018.05.09 iylee US frob 또는 POD 가 US 나 CA 인 경우 HTS 필수 체크
				if(formObj.us_frob_flg.value == "Y"
					||(formObj.pod_cd.value.substring(0, 2)=="US" || formObj.pod_cd.value.substring(0, 2)=="CA")){
					for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
						if(ComIsEmpty(sheetObjects[1].CellValue(ix, "hamo_trf_cd"))){
							ComShowCodeMessage("BKG95078");
							//HTS Code is mandatory for US customs manifest, please update it..
							return false;
						}
						
					}
				}
				
				// eu 28개국 발 인 경우 HS CODE필수
				if(formObj.hs_eu_flg.value == "Y"){
					for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
						if(ComIsEmpty(sheetObjects[1].CellValue(ix, "cmdt_hs_cd"))){
							ComShowMessage(ComGetMsg("BKG95090"));
							return false;
						}
						
					}
				}
				
				// 국가코드가 'DE'인 경우 HS code 값 validation 체크
				if(formObj.de_flg.value == "Y"){
					for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
						if(ComIsEmpty(sheetObjects[1].CellValue(ix, "cmdt_hs_cd"))){
							ComShowMessage(ComGetMsg("BKG02213", "Germany (Inbound, T/S)"));
							return false;
						}
						
					}
				}
				
				for(ix=1;ix <= rcnt;ix++){
					sheetObj.CellValue2(ix, "mf_cfm_flg") = 1;
					//
					var qty1 = ComColumnSumByCond(sheetObjects[1], "pck_qty", "cntr_no", sheetObj.CellValue(ix, "cntr_no"), false);
					var qty2 = ComColumnSumByCond(sheetObjects[1], "cntr_mf_wgt", "cntr_no", sheetObj.CellValue(ix, "cntr_no"), false);
					var qty3 = ComColumnSumByCond(sheetObjects[1], "meas_qty", "cntr_no", sheetObj.CellValue(ix, "cntr_no"), false);
					if(sheetObj.CellValue(ix, "pck_qty") != qty1 ||
						sheetObj.CellValue(ix, "cntr_wgt") != qty2 ||
						sheetObj.CellValue(ix, "meas_qty") != qty3 ||
						sheetObj.CellValue(ix, "pck_tp_cd") == ''){
						if(!isAsk){
							rflg = confirm(ComGetMsg("BKG00787"));
							isAsk = true;
						}
						if(rflg){
							sheetObj.CellValue2(ix, "cm_pck_qty")  = qty1;
							sheetObj.CellValue2(ix, "cm_cntr_wgt") = qty2;
							sheetObj.CellValue2(ix, "cm_meas_qty") = qty3;
							sheetObj.CellValue2(ix, "pck_qty")  = qty1;
							sheetObj.CellValue2(ix, "cntr_wgt") = qty2;
							sheetObj.CellValue2(ix, "meas_qty") = qty3	;
							// syncPckUnit
							syncPckUnit(sheetObj.CellValue(ix, "cntr_no"), "PK");
							// change current view
							if(formObj.cntr_no.value == sheetObj.CellValue(ix, "cntr_no")){
								formObj.pck_qty.value  = ComAddComma3(sheetObj.CellValue(ix, "cm_pck_qty"), "#,###");
								formObj.cntr_wgt.value = ComAddComma3(sheetObj.CellValue(ix, "cm_cntr_wgt"), "#,###.000");
								formObj.meas_qty.value = ComAddComma3(sheetObj.CellValue(ix, "cm_meas_qty")	, "#,###.000");
							}
						}
					}
				}
				// 3. Confirm Flag에 CMCFM으로 설정
				formObj.bkg_cfm_flg.value = "CMCFM";
				formObj.mf_cfm_flg.value = "Y";
				// 1. Container Grid check box 호출
				changeEditable();
				// 수정 여부 기록
				formObj.dirty_flag.value = 'Y';
			break;

			case COMMAND02:
				// 2. 좌측그리드의 체크박스를 전체 체크 해제
				var rcnt = sheetObj.RowCount;
				for(ix=1;ix<=rcnt;ix++){
					sheetObj.CellValue2(ix, "mf_cfm_flg") = 0;
				}
				// 3. Confirm Flag에 CMCFM으로 설정
				formObj.bkg_cfm_flg.value = "CMRLSE";
				formObj.mf_cfm_flg.value = "N";
				// 1. Container Grid check box 호출
				changeEditable();
				// 수정 여부 기록
				formObj.dirty_flag.value = 'Y';
			break;
			
			case COMMAND04:      //booking split no조회 
				if(validateForm(sheetObj, formObj, sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.WaitImageVisible = false;
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.WaitImageVisible = true;
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;		
			
			case COMMAND05:      // Copy from Container 
				if(validateForm(sheetObj, formObj, sAction)) {
				//try {
				//	ComOpenWait(true); 
					var rcnt = sheetObjects[0].RowCount;
					var srcCol = "cntr_no|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|dcgo_flg|awk_cgo_flg|hngr_flg";
					var tgtCol = "cntr_no|pck_qty|pck_tp_cd|cntr_mf_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|dcgo_flg|awk_cgo_flg|hngr_flg";
					for(ix=1; ix<=rcnt; ix++){
						var mfCfmFlg = sheetObjects[0].CellValue(ix, "mf_cfm_flg");
						if(mfCfmFlg == 0) {
//							sheetObjects[0].Copy2SheetCol(sheetObjects[1],srcCol,tgtCol,ix,ix,-1,1); 
							
							var rowIdx = sheetObjects[1].DataInsert(-1);
							sheetObjects[1].CellValue2(rowIdx,"cntr_no") = sheetObjects[0].CellValue(ix,"cntr_no");
							sheetObjects[1].CellValue2(rowIdx,"pck_qty") = sheetObjects[0].CellValue(ix,"pck_qty");
							sheetObjects[1].CellValue2(rowIdx,"pck_tp_cd") = sheetObjects[0].CellValue(ix,"pck_tp_cd");
							sheetObjects[1].CellValue2(rowIdx,"cntr_mf_wgt") = sheetObjects[0].CellValue(ix,"cntr_wgt");
							sheetObjects[1].CellValue2(rowIdx,"wgt_ut_cd") = sheetObjects[0].CellValue(ix,"wgt_ut_cd");
							sheetObjects[1].CellValue2(rowIdx,"meas_qty") = sheetObjects[0].CellValue(ix,"meas_qty");
							sheetObjects[1].CellValue2(rowIdx,"meas_ut_cd") = sheetObjects[0].CellValue(ix,"meas_ut_cd");
							sheetObjects[1].CellValue2(rowIdx,"dcgo_flg") = sheetObjects[0].CellValue(ix,"dcgo_flg");
							sheetObjects[1].CellValue2(rowIdx,"awk_cgo_flg") = sheetObjects[0].CellValue(ix,"awk_cgo_flg");
							sheetObjects[1].CellValue2(rowIdx,"hngr_flg") = sheetObjects[0].CellValue(ix,"hngr_flg");
						};
					}
					syncQuantityAll();

					setSeq();
					
					// Show & Hide
					if(sheetObjects[0].TotalRows  > 0){
						sheetObjects[0].SelectCell(1, "cntr_no", false);
						setCMInfo(1);
					}
					/* 수정 여부 기록 */
					formObj.dirty_flag.value = 'Y';
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
			
			case SEARCH01:		//Validation Check
				formObj.f_cmd.value = SEARCH01;
				var Row = sheetObj.SelectRow ;
				var param = "f_cmd=" + SEARCH01 + "&ncm_no=" + sheetObj.CellValue(Row, "ncm_no");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_07GS.do", param);
				
				var cmdt_desc = ComGetEtcData(sXml, "cmdt_desc");
				if( cmdt_desc == "" && sheetObj.CellValue(Row, "ncm_no") != "" ){
	    			ComShowCodeMessage("BKG06060", sheetObj.CellValue(Row, "ncm_no"));	//Invalid NCM Code(?msg1)	    			
	    			sheetObj.CellValue2(Row, "ncm_no") = "";
	    			sheetObj.SelectCell(Row, "ncm_no"); // 셀 포커스 주기
	    			return false;
				}else{
					return true;
				}
		   		break;
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 var bkgNo = formObj.bkg_no.value;
    	 switch(sAction) {

			case IBSEARCH:      // 조회
				/*  BKG No/BL no 자리수 체크 - 각각 11자리 12자리가 안될 경우 메시지를 표시한다. "ERR_DATA", "Booking Number Or B/L Number" */
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
			break;

			case IBSAVE:        //저장
				/*
                 * 1. 메시지 [BKG00350] 를 표시한다. Yes를 선택하면 save를 호출한다.
                 * 3. 그리드의 행수를 체크한다. -행수가 1 이하이면 리턴 처리한다.
                 * 4. 변경된 값이 있는지 체크한다. -변경된 값이 없으면 리턴 처리한다.
                 * 5. BKG status가 Cancel(""X"")일 경우 메시지[BKG00433] 표시 후 리턴 처리한다.
                 * 6. BDR 및 CA 상태를 체크한다. - BDR 이후 CA 가 아니면 메세지[BKG00335] 표시 후 리턴 처리
                 * 7. BKG No/BL no 자리수 체크 - 각각 11자리 12자리가 안될 경우 메시지를 표시한다.
                 * 9. CM그리드 Package Qty, Code 체크 - Qty 및 Code 없을 경우 각각 메시지[BKG00504],[BKG00505]를 표시후 리턴한다.
                 * 10. CM그리드 M&D의 두번째 데이터 체크 - 값이 없을 경우 메세지[BKG01042]를 표시후 리턴한다.
                 * 11. HTS code 체크 - POD의 Country code가 ""US"" 이고 DEL의 Country code가 ""US""가 아닌 BKG일 경우 메세지 [BKG00334]를 표시 후 리턴 처리
                 * 12. NCM code 체크 - POR/POL/POD/DEL 에 BR 의 국가 코드가 있고 NCM CODE가 없을 경우 메세지 [BKG00788] 표시후 리턴
                 * 13. HS  또는 HTS code 체크 - Pre 또는 Post가 MYPKG인 경우 HS, HTS 둘다 없을 경우 메세지 [BKG01045] 표시후 리턴
                 * 14. CM Confirm이 되어 있는 Container 와 CM 합의 package, weight, measure 비교 - 두개의 값이 다른 경우 메세지[BKG01043]를 표시한다.
                 * 15. 14번에서 다른 값이 하나라도 있는 경우 저장여부 확인 메시지 [BKG01044] 표시하고 Yes 선택하면 Container 값 변경
                 * 16. All Confrim 체크 - [좌측 그리드에 전체가 선택되지 않은 경우] Confirm Flag에 CMRLSE으로 설정, [전체가 선택된 경우] Confirm Flag에 CMCFM으로 설정
                 * 17. Confirm Flag가 CMCFM일 경우 BKG와 CM에서 입력한 값을 비교 - 차이가 있을 경우 팝업(ESM_BKG_0958)을 호출한다. 팝업에서 Yes를 선택한 경우 BKG의 값을 CM의 합으로 변경한다.
                 * 18. T/VVD 의 POD 가 구주이고 (MDM_LOCATION 의 CONTI_CD 'E') CM CNTR 에 선택되지 않은 DG SEQ 가 있는 경우에 메시지[BKG01135] 출력
                 * 19. DG_SEQ 가 중복 선택 된 경우 : DG seq 1 is matched with more than 2 C/M.  It should be matched one by one 메시지[BKG01136] 출력
                 * 20. POD code가 MYPKG일 경우 :  CM 상에 HS 혹은 HTS 코드가 입력되어 있지 않으면 Save되지 않도록 Block 메시지 [BKG01045] 출력
                 * 20. POD code가 JP%일 경우 :  CM 상에 HS 혹은 HTS 코드가 입력되어 있지 않으면 Save되지 않도록 Block 메시지 [BKG08287] 출력
                 * 21. Description에 알파벳 3자리 이상 들어가지 않으면 저장 불가
				 */
			
			if(""!= ComGetObjValue(formObj.old_bkg_no) && ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
					
					ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
					ComSetFocus(formObj.bkg_no);
					return false;    				
				}
			
				if(document.form.isInquiry.value == "Y") return false;

				if(formObj.dirty_flag.value != 'Y')  {
					//alert("변경된 내용이 없습니다.");
					ComShowMessage(ComGetMsg("BKG00501"));
					return false;
				}
				
				if(confirm(ComGetMsg("BKG00350")) == false) return false;
				if(sheetObjects[0].TotalRows  == 0) return false;
			
			 
				if(formObj.bkg_sts_cd.value == 'X') {
					ComShowMessage(ComGetMsg("BKG00433"));
					return false;
				}

				if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N') {
					ComShowMessage(ComGetMsg("BKG00335"));
					return false;
				}

				if(formObj.bkg_no.value == '' || formObj.bkg_no.value.length < 11){
					ComShowMessage(ComGetMsg("BKG00463"));
					formObj.bkg_no.focus();
					return false;
				}

				if(formObj.bl_no.value == '' ){
					ComShowMessage(ComGetMsg("BKG00463"));
					formObj.bl_no.focus();
					return false;
				}
			
				
				/*
				sheetObjects[1].SpaceDupCheck = false;
				var dupRow = sheetObjects[1].ColValueDup("dcgo_seq", false);
				
				if(dupRow != -1){
					ComShowMessage(ComGetMsg("BKG01136", sheetObjects[1].CellValue(dupRow,"dcgo_seq")));
					return false;
				}				
				
				if(formObj.eur_flg.value == 'Y'){
					var cntrCnt = sheetObjects[0].RowCount;
					for(i=1;i<=cntrCnt;i++){
						var cntrNo = sheetObjects[0].CellValue(i, "cntr_no");
						var cntrArr1 = ComFindText(sheetObjects[1], "cntr_no", cntrNo);
						var cntrArr2 = ComFindText(sheetObjects[2], "cntr_no", cntrNo);
						
						if(cntrArr2.length > 0){
							if(cntrArr1.length < cntrArr2.length){
								ComShowMessage(ComGetMsg("BKG01135", cntrNo));
								return false;
							}
						}
					}
				}	
				*/
				
				var rcnt = sheetObj.RowCount;
				for(ix=1;ix<=rcnt;ix++){
					
					//삭제일 경우 Validate Skip
					if(sheetObj.CellValue(ix, "ibflag") == "D"){ // sheetObj.RowHidden(ix) 
						continue;
					}
					
					if(sheetObj.CellValue(ix, "pck_qty") == '') {
						ComShowMessage(ComGetMsg("BKG00504"));
						return false;
					}
					if(sheetObj.CellValue(ix, "pck_tp_cd") == '') {
						ComShowMessage(ComGetMsg("BKG00505"));
						return false;
					}
					if(sheetObj.CellValue(ix, "wgt_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Weight Unit Code");
						return false;
					}
					if(sheetObj.CellValue(ix, "meas_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Measure Unit Code");
						return false;
					}
					if(ComTrim(sheetObj.CellValue(ix, "cntr_mf_gds_desc")) == '') {
						ComShowMessage(ComGetMsg("BKG01042"));
						return false;
					}
					if(formObj.hts_flg.value == 'Y' && sheetObj.CellValue(ix, "hamo_trf_cd") == ''){
						ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
						return false;
					}					
					if(sheetObj.CellValue(ix, "hamo_trf_cd") != '' && (sheetObj.CellValue(ix, "hamo_trf_cd").length < 6 || sheetObj.CellValue(ix, "hamo_trf_cd").length > 10)) {
						ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
						return false;
					}
					if(sheetObj.CellValue(ix, "cmdt_hs_cd") != '' && (sheetObj.CellValue(ix, "cmdt_hs_cd").length < 6 || sheetObj.CellValue(ix, "cmdt_hs_cd").length > 10)) {
						ComShowMessage(ComGetMsg("BKG00334", 'HS'));
						return false;
					}
					
					// 2017.12.07 iylee POD가 US일 경우 HTS Code 입력 필수
					if(document.form.pod_cd.value.substring(0, 2)=="US"){
						if(ComIsEmpty(sheetObj.CellValue(ix, "hamo_trf_cd"))){
							ComShowMessage(ComGetMsg("BKG02225", sheetObj.CellValue(ix, "cntr_no")));
							//Check the HTS Code with shipper and correctly input in C/M column accordingly.
							return false;
						}
					}
					
					if( formObj.por_cd.value.substring(0, 2) == 'BR' 
						|| formObj.pol_cd.value.substring(0, 2) == 'BR') {	  // Orgin이 브라질인 경우					 
				    	if( sheetObj.CellValue(ix, "cntr_mf_wgt") != '' 
				    		&& (sheetObj.CellValue(ix, "cntr_mf_wgt") < 1000)) { // CNTR WGT이 1000 미만인 경우							
				    	
				    		/* 최초 한번 CNTR WGT에 대한 오류 확인 시 창이 Active 된 상태에서는
			    			      재 저장시 Weight에 대한 Validation 체크 로직을 Skip 함 */
				    		if( formObj.br_wgt_chk_flg.value == 'N') {	// 창 오픈 후 최초 Save 시만...			    			
				    			
				    			formObj.br_wgt_chk_flg.value = "Y";  
				    			
							    ComShowMessage(ComGetMsg("BKG08265"));
								return false;
				    		}
				    	}
					}
				
					
					if(sheetObj.CellValue(ix, "ncm_no") == '') {
						var por_cnty = (formObj.por_cd.value == '') ? '' : formObj.por_cd.value.substring(0, 2);
						var pol_cnty = (formObj.pol_cd.value == '') ? '' : formObj.pol_cd.value.substring(0, 2);
						var pod_cnty = (formObj.pod_cd.value == '') ? '' : formObj.pod_cd.value.substring(0, 2);
						var dev_cnty = (formObj.del_cd.value == '') ? '' : formObj.del_cd.value.substring(0, 2);
						if(por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || dev_cnty == 'BR'){					
							
							ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
							return false;
						}
					}
					if(sheetObj.CellValue(ix, "ncm_no") != '' && (sheetObj.CellValue(ix, "ncm_no").length < 4 || sheetObj.CellValue(ix, "ncm_no").length > 8)) {
						ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
						return false;
					}
					//alert("-->" + formObj.mypkg_flg.value);
//					if(sheetObj.CellValue(ix, "hamo_trf_cd") == '' && sheetObj.CellValue(ix, "cmdt_hs_cd") == '' && formObj.mypkg_flg.value == 'Y') {
//						
//						if(formObj.pol_cd.value != 'MYPKG' && formObj.pod_cd.value != 'MYPKG'){
//							ComShowMessage(ComGetMsg("BKG01045"));
//							return false;
//						}
//					}
					if(formObj.mypkg_flg.value == 'Y'){
						 if(sheetObjects[1].CellValue(ix, "hamo_trf_cd") == '' && sheetObjects[1].CellValue(ix, "cmdt_hs_cd") == '' ){ 
						    	ComShowMessage(ComGetMsg("BKG01045"));
								return false;
						    
						   }
						}
					//[CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block 
					if(sheetObj.CellValue(ix, "meas_qty") <= 0 &&  "BH"==formObj.del_cd.value.substring(0,2)) {
						// Bahrain destined BKG needs CBM information obligatorily.
						ComShowMessage(ComGetMsg("BKG95112"));
						return false;
					}
					
					
					// 국가코드가 'SY'인 경우 HS code 값 validation 체크
					if(sheetObj.CellValue(ix, "cmdt_hs_cd") == '' && 
					  (formObj.pol_cd.value.substring(0, 2) == 'SY' || formObj.del_cd.value.substring(0, 2) == 'SY')) {
						// HS code is mandatory for Syria. Please also insert the correct HS code in M&D without missing.
						ComShowMessage(ComGetMsg("BKG08226"));
						return false;
					}
					
					
					// 국가코드가 'TR'인 경우 HS code 값 validation 체크
					if(sheetObj.CellValue(ix, "cmdt_hs_cd") == '' && formObj.tr_flg.value == 'Y') {
						ComShowMessage(ComGetMsg("BKG08322"));
						return false;
					}
					
					// 국가코드가 'JP'인 경우 HS code 값 validation 체크
					if(sheetObj.CellValue(ix, "cmdt_hs_cd") == '' && formObj.pod_cd.value.substring(0, 2) == 'JP') {
						// Please, input HS code for shipment destined to Japan before saving it.
						ComShowMessage(ComGetMsg("BKG08287"));
						return false;
					}
					
					// 국가코드가 'LK'인 경우 HS code 값 validation 체크
					if(sheetObj.CellValue(ix, "cmdt_hs_cd") == '' && formObj.pod_cd.value.substring(0, 2) == 'LK') {
						// Please, input HS code for shipment destined to SRI LANKA before saving it.
						ComShowMessage(ComGetMsg("BKG95081"));
						return false;
					}
					
					// POR 과 POL 의 국가코드가 'IR'인 경우 HS code 값 validation 체크
					if (formObj.por_cd.value.substring(0, 2) == 'IR' || formObj.pol_cd.value.substring(0, 2) == 'IR') {
						// HS code 가 null 인 경우
						if(sheetObj.CellValue(ix, "cmdt_hs_cd") == ''){
							ComShowMessage(ComGetMsg("BKG02211", 'Iran-originated'));
							return false;
						} else {
							// 특정 HS code 가 입력 된 경우 save 불가
							var hsCdListCnt = sheetObjects[3].RowCount;
							if(hsCdListCnt < 0) return;
							
							var inpHsCd = sheetObj.CellValue(ix, "cmdt_hs_cd");
							for(k=1; k <= hsCdListCnt; k++){
	                            if(inpHsCd.length >= sheetObjects[3].CellValue(k, "attr_ctnt5").length){
	                            	if(inpHsCd.indexOf(sheetObjects[3].CellValue(k,"attr_ctnt5")) == 0){
	                            		ComShowMessage(ComGetMsg("BKG02210", inpHsCd));
	                            		return false;
	                            	}
	                            }
							}
						}
					}
					
					// POD 와 DEL 의 국가코드가 'IR'인 경우 HS code 값 validation 체크
					if (formObj.pod_cd.value.substring(0, 2) == 'IR' || formObj.del_cd.value.substring(0, 2) == 'IR') {
						
						// HS code 가 null 인 경우
						if(sheetObj.CellValue(ix, "cmdt_hs_cd") == ''){
							ComShowMessage(ComGetMsg("BKG02211", 'Iran-destined'));
							return false;
						} else {
							// 특정 HS code 가 입력 된 경우
							var hsCdListCnt = sheetObjects[3].RowCount;
							var warFlg = "N";
							if(hsCdListCnt < 0) return;
							
							var inpHsCd = sheetObj.CellValue(ix, "cmdt_hs_cd");
							for(k=1; k <= hsCdListCnt; k++){
	                            if(inpHsCd.length >= sheetObjects[3].CellValue(k, "attr_ctnt5").length){
	                            	if(inpHsCd.indexOf(sheetObjects[3].CellValue(k,"attr_ctnt5")) == 0){
	                            		if(sheetObjects[3].CellValue(k,"attr_ctnt6") == 'Y'){
	                            			// 경고 메시지 띄우고 save 중지
	                            			ComShowMessage(ComGetMsg("BKG02210", inpHsCd));
	                            			return false;
	                            		}else if(sheetObjects[3].CellValue(k,"attr_ctnt6") == 'N'){
	                            			// 경고 메시지만 띄우고 save 진행하기 위한 플래그 값 변경
	                            			warFlg = "Y";
	                            		}
	                            	}
	                            }
							} // end of for
						}
					}
					
					
					// POD 의 국가코드가 'RU'인 경우 HS code 값 validation 체크
					if (formObj.pod_cd.value.substring(0, 2) == 'RU') {
						 if(formObj.ru_flg.value == 'Y'){
						
							// 특정 HS code 가 입력 된 경우
							var hsCdListCnt = sheetObjects[3].RowCount;
	
							if(hsCdListCnt < 0) return;
							
							var inpHsCd = sheetObj.CellValue(ix, "cmdt_hs_cd");
							for(k=1; k <= hsCdListCnt; k++){
	                            if(inpHsCd.length >= sheetObjects[3].CellValue(k, "attr_ctnt5").length){
	                            	if(inpHsCd.indexOf(sheetObjects[3].CellValue(k,"attr_ctnt5")) == 0){
	                            		if(sheetObjects[3].CellValue(k,"attr_ctnt6") == 'Y'){
	                            			// 경고 메시지 띄우고 save 중지
	                            			ComShowMessage(ComGetMsg("BKG02222", inpHsCd));
	                            			return false;
	                            		}
	                            	}
	                            }
							} // end of for
						 }

					}
									
				} // end of FOR
				
				// 경고 메시지를 1번만 보여주기 위해서 for 문 밖에 메시지 호출
				if (warFlg == "Y"){
					// HS code 가 특정 값일 경우 메시지만 띄우고 save 진행
					ComShowMessage(ComGetMsg("BKG02212", 'Iran'));
				}

				
				var ncnt = sheetObjects[0].RowCount;
				for(nx=1;nx<=ncnt;nx++){
					if(sheetObjects[0].CellValue(nx, "bb_cgo_flg") == 'N'){
						var cntrNo = sheetObjects[0].CellValue(nx, "cntr_no");
						var cntrArr = ComFindText(sheetObj, "cntr_no", cntrNo);
						for(ia=0;ia<cntrArr.length;ia++){
							//alert(cntrNo + " = " + sheetObjects[0].CellValue(nx, "bb_cgo_flg") +" -> "+ sheetObj.CellValue(cntrArr[ia], "pck_qty"));
							if(sheetObj.CellValue(cntrArr[ia], "pck_qty") == 0) {
								ComShowMessage(ComGetMsg("BKG08004", cntrNo));
								return false;
							}
						}
					}

					if(sheetObjects[0].CellValue(nx, "mf_cfm_flg") == 1){
						if(sheetObjects[0].CellValue(nx, "pck_qty") != sheetObjects[0].CellValue(nx, "cm_pck_qty") ||
							sheetObjects[0].CellValue(nx, "cntr_wgt") != sheetObjects[0].CellValue(nx, "cm_cntr_wgt") ||
							sheetObjects[0].CellValue(nx, "meas_qty") != sheetObjects[0].CellValue(nx, "cm_meas_qty")){
							//ComShowMessage(ComGetMsg("BKG01043"));
							if(!confirm(ComGetMsg("BKG01043", sheetObjects[0].CellValue(nx, "cntr_no") ))) return false;
						}
					}
				}
				if(formObj.bkg_cfm_flg.value == "CMCFM"){
					//alert("->" + formObj.bkg_cfm_flg.value);
					var bkg_pck_qty   = ComTrimAll(formObj.bkg_pck_qty.value, ",");
					var bkg_pck_unit  = formObj.bkg_pck_unit.value;
					var bkg_wgt_qty   = ComTrimAll(formObj.bkg_wgt_qty.value, ",");
					var bkg_wgt_unit  = formObj.bkg_wgt_unit.value;
					var bkg_meas_qty  = ComTrimAll(formObj.bkg_meas_qty.value, ",");
					var bkg_meas_unit = formObj.bkg_meas_unit.value;
					var cm_pck_qty    = ComColumnSum(sheetObj, "pck_qty");//sheetObj.ComputeSum("|4|");
					var cm_pck_unit   = bkg_pck_unit;
					var cm_wgt_qty    = ComColumnSum(sheetObj, "cntr_mf_wgt");//sheetObj.ComputeSum("|7|");
					var cm_wgt_unit   = bkg_wgt_unit;
					var cm_meas_qty   = ComColumnSum(sheetObj, "meas_qty");//sheetObj.ComputeSum("|9|");
					var cm_meas_unit  = bkg_meas_unit;

//					alert("pck_qty : " + bkg_pck_qty + " = " + cm_pck_qty + "\n" +
//						  "act_wgt : " + bkg_wgt_qty + " = " + cm_wgt_qty + "\n" +
//						  "meas_qty : " + bkg_meas_qty + " = " +cm_meas_qty + "\n");
					if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty){
                        var url="ESM_BKG_0958.do" +
                                "?bkg_pck_qty=" + bkg_pck_qty +
                                "&bkg_pck_unit=" + bkg_pck_unit +
                                "&bkg_wgt_qty=" + bkg_wgt_qty +
                                "&bkg_wgt_unit=" + bkg_wgt_unit +
                                "&bkg_meas_qty=" + bkg_meas_qty +
                                "&bkg_meas_unit=" + bkg_meas_unit +
                                "&cm_pck_qty=" + cm_pck_qty +
                                "&cm_pck_unit=" + cm_pck_unit +
                                "&cm_wgt_qty=" + cm_wgt_qty +
                                "&cm_wgt_unit=" + cm_wgt_unit +
                                "&cm_meas_qty=" + cm_meas_qty +
                                "&cm_meas_unit=" + cm_meas_unit +
                                "&sub_title=C/M";
						//alert("*before* decision_flag : " + decision_flag);
						//ComOpenWindow(url, "ESM_BKG_0958", "width=700,height=240", true);
						ComOpenWindowCenter(url, "ESM_BKG_0958", 600, 300, true);
						//alert("*after* decision_flag : " + decision_flag);
						if(decision_flag==0){
							// nothing
						}else if(decision_flag==1){
							formObj.bkg_pck_qty.value  = cm_pck_qty;
							formObj.bkg_wgt_qty.value  = cm_wgt_qty;
							formObj.bkg_meas_qty.value = cm_meas_qty;
							
							var hasDiff = false;
							var col_val = '';
							for(rn=1;rn<=sheetObjects[0].RowCount;rn++){
								if(rn!=1){
									if(col_val != sheetObjects[0].CellValue(rn, "pck_tp_cd")){
										hasDiff = true;
										break;
									}
								}
								col_val = sheetObjects[0].CellValue(rn, "pck_tp_cd");
							}
							formObj.bkg_pck_unit.value = col_val;
							
							//formObj.bkg_pck_qty.value  = ComAddComma3(''+cm_pck_qty, "#,###");
							//formObj.bkg_wgt_qty.value  = ComAddComma3(''+cm_wgt_qty, "#,###.000");
							//formObj.bkg_meas_qty.value = ComAddComma3(''+cm_meas_qty, "#,###.000");
							/* change container qnt'y */
							//var cntrArr = ComFindText(sheetObjects[0], "cntr_no", formObj.cntr_no.value);
							//if(cntrArr.length > 0){
							//	sheetObjects[0].CellValue2(cntrArr[0], "pck_qty") = cm_pck_qty;
							//	sheetObjects[0].CellValue2(cntrArr[0], "cntr_wgt") = cm_wgt_qty;
							//	sheetObjects[0].CellValue2(cntrArr[0], "meas_qty") = cm_meas_qty;							
							//}
						}else {
							return false;
						}
					}
				}
				
		        // ASCII코드 값이 1-31, (단, 10(\r), 13(\n)은 제외)일 경우 경고창을 표시한다.
				var expStr = "";
		        var checkFlag = false;

		    	for(i=1;i<=sheetObjects[1].RowCount;i++){
			        var checkStr = sheetObjects[1].CellValue(i, "cntr_mf_mk_desc");

			        for(var j=0; j<checkStr.length; j++){
			        	var regStr = checkStr.charCodeAt(j);
			        	if(regStr != 10 && regStr != 13 && (1 <= regStr && regStr <= 31)){
			        		checkFlag = true;
			        	} else{
			        		expStr += checkStr.charAt(j);
			        	}
			        }

			        if(checkFlag){
			    		if (ComShowCodeConfirm("BKG08198")){
			    			sheetObjects[1].CellValue2(i, "cntr_mf_mk_desc") = expStr;
			    		}
			    		return true;
			        }
		    	}
		    	//적어도 3자리 알파벳이 들어가도록 validation 요청.
				for(var i = sheetObjects[1].HeaderRows; i < sheetObjects[1].Rows; i++){
		           var cntr_mf_gds_desc = sheetObjects[1].CellValue(i, "cntr_mf_gds_desc");
		           var cnt = 0;
		           for (var inx = 0; inx < cntr_mf_gds_desc.length; inx++) {
		             if ( ComIsAlphabet(cntr_mf_gds_desc.charAt(inx))) cnt++;
		             if ( cnt == 3 ) break;
		           }                              
		           if ( cnt < 3 ) {
		        	   ComShowCodeMessage('BKG95108'); //At least, 3 alphabet characters should be included in description column. please check it again.
		        	   return false;
		           }
				}
				
			break;
			
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;					
		}
        return true;
    }



	/*-------------------------------------------------------------------------------------------------------
	 * 이벤트 처리
	 *------------------------------------------------------------------------------------------------------*/

    function form1_blur(){
        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "bkg_no":

            break;
        }
    }

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
	
    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		/* 데이터 변경 여부 체크 */
		//document.form.dirty_flag.value = 'Y'

        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "cntr_no":

            break;
        }
    }


	// 조회 함수
	function t9sheet1_OnClick(sheetObj, row, col, val) {
        var col_name = sheetObj.ColSaveName(col);

		switch(col_name) {
			case "cntr_no":
				setCMInfo(row);
			break;

		} // end switch
	}


	function t9sheet1_OnChange(sheetObj, row, col, val){
		// 데이터 변경 여부 체크
		document.form.dirty_flag.value = 'Y'
		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}

        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "mf_cfm_flg":
				if(val==1) {
					if(document.form.pod_cd.value.substring(0, 2)=="BR"){
						for(var ix=1;ix <= sheetObjects[1].RowCount;ix++){
							if(sheetObjects[1].CellValue(ix, "cntr_no") == sheetObj.CellValue(row, "cntr_no")){
								if(sheetObjects[1].CellValue(ix, "meas_qty")==0||ComIsEmpty(sheetObjects[1].CellValue(ix, "ncm_no"))){
									ComShowCodeMessage("BKG95077");
									//CBM & NCM no is mandatory for Brazil manifest, please update it.
									sheetObj.CellValue2(row, col) = 0;
									return false;
								}	
							}
						}
					}

					if(document.form.pol_cd.value.substring(0,2)=="BR" 
						||document.form.pod_cd.value.substring(0,2)=="BR"){
						for(var ix=1;ix <= sheetObjects[1].RowCount;ix++){
							if(sheetObjects[1].CellValue(ix, "cntr_no") == sheetObj.CellValue(row, "cntr_no")){
								if(ComIsEmpty(sheetObjects[1].CellValue(ix, "wpm_trt_cd"))){
									sheetObj.CellValue2(row, col) = 0;
									ComShowCodeMessage("BKG95104");
									//The WPM (Wooden Packing Material) Treatment status should be manifested to Brazil customs for export/import cargo. please select WPM
									return false;
								}
								if(sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WC"
									||sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WP"
									||sheetObjects[1].CellValue(ix, "pck_tp_cd")=="WT"){
									if("A"==sheetObjects[1].CellValue(ix, "wpm_trt_cd")){
										sheetObj.CellValue2(row, col) = 0;
										ComShowCodeMessage("BKG95105");
										//If package type is WC or WP or WT, You cannot select ‘N/A’ in WPM field.
										return false;
									}
								}

								
							}
						}
					}
					
					// 2018.05.09 iylee US frob 또는 POD 가 US 나 CA 인 경우 HTS 필수 체크
					if(document.form.us_frob_flg.value == "Y"
						||(document.form.pod_cd.value.substring(0, 2)=="US" || document.form.pod_cd.value.substring(0, 2)=="CA")){
						for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
							if(sheetObjects[1].CellValue(ix, "cntr_no") == sheetObj.CellValue(row, "cntr_no")){
								if(ComIsEmpty(sheetObjects[1].CellValue(ix, "hamo_trf_cd"))){
									ComShowCodeMessage("BKG95078");
									sheetObj.CellValue2(row, col) = 0;
									//HTS Code is mandatory for US customs manifest, please update it..
									return false;
								}
							}
							
						}
					}
					
					// eu 28개국 발 인 경우 HS CODE필수
					if(document.form.hs_eu_flg.value == "Y"){
						for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
							if(sheetObjects[1].CellValue(ix, "cntr_no") == sheetObj.CellValue(row, "cntr_no")){
								if(ComIsEmpty(sheetObjects[1].CellValue(ix, "cmdt_hs_cd"))){
									ComShowCodeMessage("BKG95090");
									sheetObj.CellValue2(row, col) = 0;
									return false;
								}
							}
						}
					}
					
					// 국가코드가 'DE'인 경우 HS code 값 validation 체크
					if(document.form.de_flg.value == "Y"){
						for(ix=1;ix <= sheetObjects[1].RowCount;ix++){
							if(sheetObjects[1].CellValue(ix, "cntr_no") == sheetObj.CellValue(row, "cntr_no")){
								if(ComIsEmpty(sheetObjects[1].CellValue(ix, "cmdt_hs_cd"))){
									ComShowMessage(ComGetMsg("BKG02213", "Germany (Inbound, T/S)"));
									sheetObj.CellValue2(row, col) = 0;
									return false;
								}
							}
						}
					}
					
					document.form.mf_cfm_flg.value = 'Y';
					var cfmFlg = ComFindText(sheetObj, "mf_cfm_flg", 0);
					if(cfmFlg.length == 0){
						document.form.bkg_cfm_flg.value = "CMCFM";
					}
					// sync quantity
					var qty1 = ComColumnSumByCond(sheetObjects[1], "pck_qty", "cntr_no", sheetObj.CellValue(row, "cntr_no"), false);
					var qty2 = ComColumnSumByCond(sheetObjects[1], "cntr_mf_wgt", "cntr_no", sheetObj.CellValue(row, "cntr_no"), false);
					var qty3 = ComColumnSumByCond(sheetObjects[1], "meas_qty", "cntr_no", sheetObj.CellValue(row, "cntr_no"), false);
					if(sheetObj.CellValue(row, "pck_qty") != qty1 ||
						sheetObj.CellValue(row, "cntr_wgt") != qty2 ||
						sheetObj.CellValue(row, "meas_qty") != qty3 ||
						sheetObj.CellValue(row, "pck_tp_cd") == ''){
						if(confirm(ComGetMsg("BKG00787"))){
							sheetObj.CellValue2(row, "cm_pck_qty")  = qty1;
							sheetObj.CellValue2(row, "cm_cntr_wgt") = qty2;
							sheetObj.CellValue2(row, "cm_meas_qty") = qty3;
							sheetObj.CellValue2(row, "pck_qty")  = qty1;
							sheetObj.CellValue2(row, "cntr_wgt") = qty2;
							sheetObj.CellValue2(row, "meas_qty") = qty3;
							// syncPckUnit
							syncPckUnit(sheetObj.CellValue(row, "cntr_no"), "PK");
							// change current view
							if(document.form.cntr_no.value == sheetObj.CellValue(row, "cntr_no")){
								document.form.pck_qty.value  = ComAddComma3(sheetObj.CellValue(row, "cm_pck_qty"), "#,###");
								document.form.cntr_wgt.value = ComAddComma3(sheetObj.CellValue(row, "cm_cntr_wgt"), "#,###.000");
								document.form.meas_qty.value = ComAddComma3(sheetObj.CellValue(row, "cm_meas_qty"), "#,###.000");
							}
						}
					}
				}else{
					document.form.mf_cfm_flg.value = 'N';
					document.form.bkg_cfm_flg.value = "CMRLSE";
				}
				// changeEditable
				changeEditable();
			break;
			
		} // end switch
	}

	function t9sheet2_OnPopupClick(sheetObj, row, col){
		//alert(sheetObj.id + " -> " + sheetObj.ColSaveName(col));

        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "PCKPop":
				comBkgCallPop0696("callbackPckTp", sheetObj.CellValue(row, "pck_tp_cd"));
			break;

			case "MDPop":
				var frm2 = document.form2;
				var width = 400;
				var height = 410;
				var left = (screen.width-width)/2;
				var top = (screen.height-height)/2;
				var win = window.open("", "ESM_BKG_0706", "width="+width+",height="+height+",left="+left+",top="+top+",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
				frm2.mk_desc.value = sheetObj.CellValue(row, "cntr_mf_mk_desc");
				frm2.gds_desc.value = sheetObj.CellValue(row, "cntr_mf_gds_desc");
				frm2.func.value = "callbackMFDesc";
				frm2.action = "ESM_BKG_0706.do";
				frm2.method = "POST";
				frm2.target = "ESM_BKG_0706";
				frm2.submit();

			break;

			case "HTCPop":
				comBkgCallPop0607("callbackHTSCode", 'T', sheetObj.CellValue(row, "hamo_trf_cd"));
			break;

			case "CMDTPop":
				// BKG Commodity가 F.A.K/Console/Mixed Cargo 일때는 제외하고 BKG commodity 6자리를 넘겨서 Pop-Up(ESM_BKG_0607)을 호출한다.
				comBkgCallPop0607("callbackHSCode", 'H', sheetObj.CellValue(row, "cmdt_hs_cd"));
			break;

			case "NCMPop":
				// BKG Commodity가 F.A.K/Console/Mixed Cargo 일때는 제외하고 BKG commodity 6자리를 넘겨서 Pop-Up(ESM_BKG_0745)을 호출한다.
				var ncm_no = sheetObj.CellValue(row, "ncm_no");
				var sUrl = "ESM_BKG_0745_P.do?page_gubun=popup&ncm_no="+ncm_no;
	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 530, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(row, 'ncm_no') = rtnVal.cd;
	  				// 데이타 수정 여부 기록 
	  				document.form.dirty_flag.value = 'Y'
	  				setNcmMulti(row, rtnVal.cd);
	  			}
	  			
			break;

		} // end switch
	}

	function t9sheet2_OnChange(sheetObj, row, col, val){

		/* 데이터 변경 여부 체크 */
		document.form.dirty_flag.value = 'Y'

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}

        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "pck_tp_cd":
				syncPckUnit(sheetObj.CellValue(row, "cntr_no"), "PK");
				break;

			case "pck_qty":
			case "cntr_mf_wgt":
			case "meas_qty":
				syncQuantity(col_name);
				break;

			case "self":
				/* 1. 체크된 경우 선택된 행의 AMS Ref No.를 삭제한다. */
				if(val == 1) {
					sheetObj.CellValue2(row, "cntr_mf_no") = 'SELF';
					sheetObj.CellEditable(row, "cntr_mf_no") = false;
				} else {
					sheetObj.CellValue2(row, "cntr_mf_no") = '';
					sheetObj.CellEditable(row, "cntr_mf_no") = true;
				}
				break;
				
			case "ncm_no":
				
				if(doActionIBSheet(sheetObj, document.form, SEARCH01)){				
					if( sheetObj.CellValue(row, "ncm_no") == "" ){
						sheetObj.CellValue2(row, "ncm_multi_pop") 	= "0";
//		    			sheetObj.CellValue2(row, "ncm_multi_flg") 	= "N";
	//	    			sheetObj.CellValue2(row, "ncm_multi_no") 	= "";
//		    			sheetObj.CellBackColor(row,"ncm_no") 		= sheetObj.RgbColor(255, 255, 255);
					} else{
			    		sheetObj.CellValue2(row, "ncm_multi_pop") 		= "1";
//			    		sheetObj.CellValue2(row, "ncm_multi_flg") 		= "N";
	//		    		sheetObj.CellValue2(row, "ncm_multi_no") 		= sheetObj.CellValue(row, "ncm_no");
//			    		sheetObj.CellBackColor(row,"ncm_no") 			= sheetObj.RgbColor(255, 255, 255);
					}
					setNcmMulti(row, val);
				}
				break;
				
			case "cmdt_hs_cd": // Iran 으로 특정 HS code 입력시 프로세스 중지

				// POR 과 POL 의 국가코드가 'IR'인 경우 HS code 값 validation 체크
				if (document.form.por_cd.value.substring(0, 2) == 'IR' || document.form.pol_cd.value.substring(0, 2) == 'IR') {
					// HS code 가 null 인 경우
					if(sheetObj.CellValue(row, "cmdt_hs_cd") == ''){
						ComShowMessage(ComGetMsg("BKG02211", 'Iran-originated'));
						return false;
					} else {
						// 특정 HS code 가 입력 된 경우 save 불가
						var hsCdListCnt = sheetObjects[3].RowCount;
						if(hsCdListCnt < 0) return;
						
						var inpHsCd = sheetObj.CellValue(row, "cmdt_hs_cd");
						for(k=1; k <= hsCdListCnt; k++){
                            if(inpHsCd.length >= sheetObjects[3].CellValue(k, "attr_ctnt5").length){
                            	if(inpHsCd.indexOf(sheetObjects[3].CellValue(k,"attr_ctnt5")) == 0){
                            		ComShowMessage(ComGetMsg("BKG02210", inpHsCd));
                            		return false;
                            	}
                            }
						}
					}
				}
				
				// POD 와 DEL 의 국가코드가 'IR'인 경우 HS code 값 validation 체크
				if (document.form.pod_cd.value.substring(0, 2) == 'IR' || document.form.del_cd.value.substring(0, 2) == 'IR') {
					
					// HS code 가 null 인 경우
					if(sheetObj.CellValue(row, "cmdt_hs_cd") == ''){
						ComShowMessage(ComGetMsg("BKG02211", 'Iran-destined'));
						return false;
					} else {
						// 특정 HS code 가 입력 된 경우
						var hsCdListCnt = sheetObjects[3].RowCount;
						if(hsCdListCnt < 0) return;
						
						var inpHsCd = sheetObj.CellValue(row, "cmdt_hs_cd");
						for(k=1; k <= hsCdListCnt; k++){
                            if(inpHsCd.length >= sheetObjects[3].CellValue(k, "attr_ctnt5").length){
                            	if(inpHsCd.indexOf(sheetObjects[3].CellValue(k,"attr_ctnt5")) == 0){
                            		if(sheetObjects[3].CellValue(k,"attr_ctnt6") == 'Y'){
                            			// 경고 메시지 띄우고 save 중지
                            			ComShowMessage(ComGetMsg("BKG02210", inpHsCd));
                            			return false;
                            		}else if(sheetObjects[3].CellValue(k,"attr_ctnt6") == 'N'){
                            			// HS code 가 특정 값일 경우 메시지만 띄우고 save 진행
                            			ComShowMessage(ComGetMsg("BKG02212", 'Iran'));
                            		}
                            	}
                            } 
						} // end of for
					}
				}
				
				if(sheetObj.CellValue(row, "cmdt_hs_cd")!="" && sheetObj.CellValue(row, "cntr_mf_gds_desc")==""){
					var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0000_1GS.do","f_cmd="+SEARCH20+"&hts_cd="+sheetObj.CellValue(row,"cmdt_hs_cd"));
					var cdDesc = ComGetEtcData(sXml, "cd_desc");
					if(cdDesc!=""){
						sheetObj.CellValue2(row, "cntr_mf_gds_desc") = cdDesc;
					}
				}
				break;
				
		} // end switch
	}

	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function t9sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount > 0) {
			for(var row = sheetObj.HeaderRows ; row <= sheetObj.RowCount; row++) {
				if(sheetObj.CellValue(row, "cntr_mf_no") == 'SELF') {
					sheetObj.CellValue2(row, "self") = 1;
					sheetObj.CellEditable(row, "cntr_mf_no") = false;
				} else {
					sheetObj.CellValue2(row, "self") = 0;
					sheetObj.CellEditable(row, "cntr_mf_no") = true;
				}
				
				if( sheetObj.CellValue(row,"ncm_multi_flg") == "Y" ){
					sheetObj.CellBackColor(row,"ncm_no") = sheetObj.RgbColor(252, 196, 245);
				}
			}
		}

		// changeEditable
		changeEditable();
	}
	
	function t9sheet2_OnClick(sheetObj, row, col, val) {
        var col_name = sheetObj.ColSaveName(col);

		switch(col_name) {
		case "ncm_multi_pop":
//    		if( sheetObj.CellValue(row,"ncm_multi_pop") == "1" ){
    			var param = "";
				param = param + "?bl_no=" + document.form.bl_no.value;
				param = param + "&cntr_no=" + sheetObj.CellValue(row,"cntr_no");
				param = param + "&cntr_mf_seq=" + sheetObj.CellValue(row,"cntr_mf_seq");
				param = param + "&ncm_multi_no=" + sheetObj.CellValue(row,"ncm_multi_no");
				param = param + "&org_sheet=" + "1";
				param = param + "&org_row=" + row;
				param = param + "&org_ui_id=" + "ESM_BKG_0079_07";
				ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
				setNcmColor(row)
//    		}
    		break;

		} // end switch
	}


	/*---------------------------------------------------------------------------------------------------
	 * Functions
	 *--------------------------------------------------------------------------------------------------*/
	// Package, Weight, Measure 값 일치
	function syncQuantity(col_name){
		// sum
		var vSum = ComColumnSumByCond(sheetObjects[1], col_name, "cntr_no", document.form.cntr_no.value, false);
		// CM
		//var cmArr = ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		//for(rx=0;rx<cmArr.length;rx++){
		//	vSum += BkgParseFloat(sheetObjects[1].CellValue(cmArr[rx], col_name));
		//}
		
		// Set Value
		if(col_name=="pck_qty") {
			//document.form.pck_qty.value = ComAddComma3(''+vSum, "#,###");
			var bkg_pck_qty = ComTrimAll(document.form.pck_qty.value, ",");
			if(vSum != bkg_pck_qty) document.form.cm_pck_qty.style.color = "red";
			else  document.form.cm_pck_qty.style.color = "#606060";
			document.form.cm_pck_qty.value = ComAddComma3(''+vSum, "#,###");
			var cntrArr = ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].CellValue2(cntrArr[0], "cm_pck_qty") = vSum;
			}
		}
		if(col_name=="cntr_mf_wgt") {
			//document.form.cntr_wgt.value = ComAddComma3(''+vSum, "#,###.000");
			var bkg_cntr_wgt = ComTrimAll(document.form.cntr_wgt.value, ",");
			if(vSum != bkg_cntr_wgt) document.form.cm_cntr_wgt.style.color = "red";
			else  document.form.cm_cntr_wgt.style.color = "#606060";
			document.form.cm_cntr_wgt.value = ComAddComma3(''+vSum, "#,###.000");
			var cntrArr = ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].CellValue2(cntrArr[0], "cm_cntr_wgt") = vSum;
			}
		}
		if(col_name=="meas_qty") {
			//document.form.meas_qty.value = ComAddComma3(''+vSum, "#,###.000");
			var bkg_meas_qty = ComTrimAll(document.form.meas_qty.value, ",");
			if(vSum != bkg_meas_qty) document.form.cm_meas_qty.style.color = "red";
			else  document.form.cm_meas_qty.style.color = "#606060";
			document.form.cm_meas_qty.value = ComAddComma3(''+vSum, "#,###.000");
			var cntrArr = ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].CellValue2(cntrArr[0], "cm_meas_qty") = vSum;
			}
		}
	}

	// Package, Weight, Measure 값 일치
	function syncQuantityAll(){
		// CM
		//var cmArr = ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		//for(rx=0;rx<cmArr.length;rx++){
		//	vSum += BkgParseFloat(sheetObjects[1].CellValue(cmArr[rx], col_name));
		//}
		for(ix=1;ix<=sheetObjects[0].RowCount;ix++){
			
			document.form.cntr_no.value = sheetObjects[0].CellValue(ix,"cntr_no");
			if(sheetObjects[0].CellValue(ix,"mf_cfm_flg") != 1) {
				syncQuantity("pck_qty");
				syncQuantity("cntr_mf_wgt");
				syncQuantity("meas_qty");
			}
		}
	}
	
	/* grid1과 grid2의 컬럼 값을 동기화 한다. */
	function syncPckUnit(cntr_no, def) {
		var rflg = false;
		//var rcnt = sheetObjects[1].RowCount;
		//for(rn=1;rn<=rcnt;rn++){
		var col_val = '';
		var cmArr = ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		for(rn=0;rn<cmArr.length;rn++){
			if(rn!=0){
				if(col_val != sheetObjects[1].CellValue(cmArr[rn], "pck_tp_cd")){
					rflg = true;
					break;
				}
			}
			col_val =  sheetObjects[1].CellValue(cmArr[rn], "pck_tp_cd");
		}
		if(col_val == ''){
			//document.form.pck_tp_cd.value = def;
		}else{
			if(rflg){
				var idxArr = ComFindText(sheetObjects[0], "cntr_no", cntr_no);
				if(idxArr.length > 0) {
					sheetObjects[0].CellValue2(idxArr[0], "pck_tp_cd") = def;
				}
				document.form.pck_tp_cd.value = def;
			}else{
				var idxArr = ComFindText(sheetObjects[0], "cntr_no", cntr_no);
				if(idxArr.length > 0) {
					sheetObjects[0].CellValue2(idxArr[0], "pck_tp_cd") = col_val;
				}
				document.form.pck_tp_cd.value = col_val;
			}
		}
	}

	/* Cntr 그리드에서 컨테이너 선택시, Cntr 정보 및 CM grid 세팅 */
	function setCMInfo(row){
		if(row > 0) {
			// CopyRow To Form
			//alert("cntr_no -> " + sheetObjects[0].CellValue(row, "cntr_no"));
			ComCopyRowToForm(sheetObjects[0], row, document.form, "");
			document.form.pck_qty.value  = ComAddComma3(document.form.pck_qty.value, "#,###");
			document.form.cntr_wgt.value = ComAddComma3(document.form.cntr_wgt.value, "#,###.000");
			document.form.meas_qty.value = ComAddComma3(document.form.meas_qty.value, "#,###.000");			
			
			var sealNos = sheetObjects[0].CellValue(row, "cntr_seal_no");
			if(sealNos!=''){
				var seal_arr = (sealNos.indexOf(',') == -1) ? new Array(sealNos) : sealNos.split(',');
				ComArrayToOptions(seal_arr, document.form.cntr_seal_no);
			}	
			// retrieve CM
			ComShowAndHideSheet(sheetObjects[1], "cntr_no", sheetObjects[0].CellValue(row, "cntr_no"));
			ComShowAndHideSheet(sheetObjects[2], "cntr_no", sheetObjects[0].CellValue(row, "cntr_no"));
			
			var dcgoSeq =" ";
			var diffRmk =" ";
			
			var rowcnt = sheetObjects[2].RowCount;
			for(i=1;i<=rowcnt;i++){
				if(sheetObjects[2].RowHidden(i) == false){
					dcgoSeq = dcgoSeq + "|" + sheetObjects[2].CellValue(i, "dcgo_seq");
					diffRmk = diffRmk + "|" + sheetObjects[2].CellValue(i, "diff_rmk");
				}
			}
			
			if(dcgoSeq!=' '){
				sheetObjects[1].InitDataCombo(0,"dcgo_seq",  diffRmk, dcgoSeq);
			}else{
				sheetObjects[1].InitDataCombo(0,"dcgo_seq",  "", "");
			}
			
			// changeEditable
			changeEditable();
			// rearangeSeq
			setSeq();
			// calculate sum
			//sheetObjects[1].ShowSubSum("cntr_no", "pck_qty|cntr_mf_wgt|meas_qty")
			var cm_pck_qty  = 0;
			var cm_cntr_wgt	 = 0;
			var cm_meas_qty = 0;
			var rcnt = sheetObjects[1].RowCount;
			for(rn=1;rn<=rcnt;rn++){
				if(sheetObjects[1].RowHidden(rn) == false){
					cm_pck_qty  += BkgParseInt(sheetObjects[1].CellValue(rn, "pck_qty"));
					cm_cntr_wgt += BkgParseFloat(sheetObjects[1].CellValue(rn, "cntr_mf_wgt"));
					cm_meas_qty += BkgParseFloat(sheetObjects[1].CellValue(rn, "meas_qty"));
				}
			}
			// 부동소숫점 처리
			cm_cntr_wgt = Math.round(cm_cntr_wgt * 1000) / 1000;
			cm_meas_qty = Math.round(cm_meas_qty * 1000) / 1000;
			//			
			document.form.cm_pck_qty.value = ComAddComma3(''+cm_pck_qty, "#,###");
			var bkg_pck_qty = ComTrimAll(document.form.pck_qty.value, ",");
			if(cm_pck_qty != bkg_pck_qty) document.form.cm_pck_qty.style.color = "red";
			else  document.form.cm_pck_qty.style.color = "#606060";
			document.form.cm_cntr_wgt.value = ComAddComma3(''+cm_cntr_wgt, "#,###.000");
			var bkg_cntr_wgt = ComTrimAll(document.form.cntr_wgt.value, ",");
			if(cm_cntr_wgt != bkg_cntr_wgt) document.form.cm_cntr_wgt.style.color = "red";
			else  document.form.cm_cntr_wgt.style.color = "#606060";
			document.form.cm_meas_qty.value = ComAddComma3(''+cm_meas_qty, "#,###.000");
			var bkg_meas_qty = ComTrimAll(document.form.meas_qty.value, ",");
			if(cm_meas_qty != bkg_meas_qty) document.form.cm_meas_qty.style.color = "red";
			else  document.form.cm_meas_qty.style.color = "#606060";
			
			sheetObjects[1].SelectRow = 0;
		}
	}

	//
	function setQuantityFromPopup(flag){
		return flag
	}

	/* 특정컬럼(col_name)의 값이 주어진 값(col_value)과 일치하면, SetColunm에 정의된 컬럼의 값을 SetValue 값으로 변경 */
	function setColumnValue(sheetObj, col_name, col_value, setColumn, setValue){
		var idxArr = ComFindText(sheetObj, col_name, col_value);
		for(ir=0;ir<idxArr.length;ir++) {
			sheetObj.CellValue2(idxArr[ir], setColumn) = setValue;
		}
	}

	function changeEditable(){
		var dcFlg = (document.form.dcgo_flg != undefined && document.form.dcgo_flg.checked);
		var bbFlg = (document.form.bb_cgo_flg != undefined && document.form.bb_cgo_flg.checked);
		var akFlg = (document.form.awk_cgo_flg != undefined && document.form.awk_cgo_flg.checked);
		var rcFlg = (document.form.rc_flg != undefined && document.form.rc_flg.checked);
		var rdFlg = (document.form.rd_cgo_flg != undefined && document.form.rd_cgo_flg.checked);
		var hgFlg = (document.form.hngr_flg != undefined && document.form.hngr_flg.checked);
		document.form.dcgo_flg.disabled    = !dcFlg;
		document.form.bb_cgo_flg.disabled  = !bbFlg;
		document.form.awk_cgo_flg.disabled = !akFlg;
		document.form.rc_flg.disabled      = !rcFlg;
		document.form.rd_cgo_flg.disabled  = !rdFlg;
		document.form.hngr_flg.disabled    = !hgFlg;

		var rcnt = sheetObjects[1].RowCount;
		for(rn = 1; rn <= rcnt; rn++){
			sheetObjects[1].CellEditable(rn, "dcgo_flg") = dcFlg;
			sheetObjects[1].CellEditable(rn, "awk_cgo_flg") = akFlg;
			sheetObjects[1].CellEditable(rn, "hngr_flg") = hgFlg;
		}

		var cfmFlg = document.form.mf_cfm_flg.value;
		if(cfmFlg == 'Y' || cfmFlg == 1 || document.form.isInquiry.value == "Y"){
			sheetObjects[1].Editable = false;
			ComBtnDisable("btn_t9Add");
			ComBtnDisable("btn_t9Del");
			ComBtnDisable("btn_t9CopyMnd");
		}else{
			sheetObjects[1].Editable = true;
			ComBtnEnable("btn_t9Add");
			ComBtnEnable("btn_t9Del");
			ComBtnEnable("btn_t9CopyMnd");
		}

		if(document.form.corr_flg.value == 'Y' || document.form.isInquiry.value == "Y") {
			ComBtnDisable("btn_t9CMbyCntr");
		} else {
			ComBtnEnable("btn_t9CMbyCntr");
		}
	}

	function setSeq(){
		var rSeq = 1;
		var rCnt = sheetObjects[1].RowCount;
		for (rn = 1; rn <= rCnt; rn++) {
			var rsts = sheetObjects[1].RowStatus(rn);
			if(rsts != 'D' && sheetObjects[1].RowHidden(rn) == false){
				sheetObjects[1].CellValue2(rn, "seq") = rSeq++;
				sheetObjects[1].RowStatus(rn) = rsts;
			}
		}
	}

	function copyCm(fmCntr, toCntrArr){
		if(fmCntr == '' || toCntrArr == ''){
			return;
		}
		//alert(fmCntr + " => " + toCntrArr)
		var tgtCnt = toCntrArr.length;
		//alert("tgtCnt==>" + tgtCnt)
		var cArr = ComFindText(sheetObjects[1], "cntr_no", fmCntr);
		//alert("cArr==>" + cArr)
		for(ix=0;ix<tgtCnt;ix++){
			//alert("\ttgt" +ix+ ". "+ toCntrArr[ix]);
			for(ir=0;ir<cArr.length;ir++) {
				var nRow = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowHidden(nRow) = true;
				for(ic = 0; ic <=  sheetObjects[1].LastCol; ic++){
					if(sheetObjects[1].ColSaveName(ic) == "ibflag") continue;
					if(sheetObjects[1].ColSaveName(ic) == "cntr_no"){
						sheetObjects[1].CellValue2(nRow, ic) = toCntrArr[ix];
					}else{
						sheetObjects[1].CellValue2(nRow, ic) = sheetObjects[1].CellValue(cArr[ir], ic);
					}
				}
			}
		}
		// 데이타 수정 여부 기록 
		document.form.dirty_flag.value = 'Y'
	}
	
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}

	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][3];
		// syncPckUnit
		syncPckUnit(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_no"), 'PK');
		// 데이타 수정 여부 기록 
		document.form.dirty_flag.value = 'Y'
	}

	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_mk_desc") = mk_desc;
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_gds_desc") = gds_desc;
		// 데이타 수정 여부 기록 
		document.form.dirty_flag.value = 'Y'
	}

	function callbackHTSCode(returnValue){
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "hamo_trf_cd") = returnValue[0][3];
		// 데이타 수정 여부 기록 
		document.form.dirty_flag.value = 'Y'
	}

	function callbackHSCode(returnValue){
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_hs_cd") = returnValue[0][3];
		// 데이타 수정 여부 기록 
		document.form.dirty_flag.value = 'Y'
	}

	/* 탭이동 시 화면의 데이타 변경여부 체크 */
	function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				//ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
//			}
		}
	}

	function searchData(bkgNo){
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_t9Save");
			ComBtnDisable("btn_t9CMCopyCM");
			ComBtnDisable("btn_t9CMbyCntr");
			ComBtnDisable("btn_t9Add");
			ComBtnDisable("btn_t9Del");
			ComBtnDisable("btn_t9CopyMnd");
		}
	}

	/**
	 * HTML Control의 onblur이벤트 <br>
	 **/
	function obj_deactivate() {
		var formObj = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (srcName == "bkg_no" || srcName == "bl_no") {
			formObj.elements[srcName].value = srcValue.toUpperCase();
		}
	}
	

	function setNcmMulti(row, val) {
		var sheetObj = sheetObjects[1];
		var fNcmMultiStr = sheetObj.CellValue(row, "ncm_multi_no");
		var arrLeng = fNcmMultiStr.split(",").length;
		var chkFlg = "N"
			
		//ncm값 중복체크	
		for(var i=0;i<arrLeng;i++){
			if(fNcmMultiStr.split(",")[i] == val)
				chkFlg = "Y"
		}
		if(chkFlg == "Y"){
			ComShowCodeMessage("BKG00764","NCM code");
			sheetObj.ReturnCellData(row, "ncm_no");			
			return false;
		}
		
		//ncm_multi_no 값 setting
		if(ComIsEmpty(val)){	
			if(arrLeng == 1){
				sheetObj.CellValue2(row, "ncm_multi_no") = "";
			}else if(arrLeng > 1){
				sheetObj.CellValue2(row,"ncm_no") = fNcmMultiStr.split(",")[1];
				sheetObj.CellValue2(row, "ncm_multi_no") = fNcmMultiStr.split(",").slice(1,arrLeng);
			}
		}else{
			if(fNcmMultiStr == ""){
				sheetObj.CellValue2(row, "ncm_multi_no") = val;
			}else{	
				if(arrLeng == 1){
					sheetObj.CellValue2(row, "ncm_multi_no") = val;
				}else if(arrLeng > 1){
					sheetObj.CellValue2(row, "ncm_multi_no") = val + "," +fNcmMultiStr.split(",").slice(1,arrLeng);
				}
			}
			
		}
		setNcmColor(row);

	}
	
	function setNcmColor(row) {
		//Cell의 분홍색 지정 여부 판단
		var sheetObj = sheetObjects[1];
		var arrLeng = sheetObj.CellValue(row, "ncm_multi_no").split(",").length;
		if( arrLeng > 1 ){
			sheetObj.CellValue2(row,"ncm_multi_flg") = "Y";
			sheetObj.CellBackColor(row,"ncm_no") = sheetObj.RgbColor(252, 196, 245);
		} else{
			sheetObj.CellValue2(row,"ncm_multi_flg") = "N";
			sheetObj.CellBackColor(row,"ncm_no") = sheetObj.RgbColor(255, 255, 255);
		}
	}
	


	/* 개발자 작업  끝 */