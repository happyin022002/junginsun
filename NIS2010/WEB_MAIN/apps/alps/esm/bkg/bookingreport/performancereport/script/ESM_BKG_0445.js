/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0445.js
*@FileTitle : SI Split Candidate
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.05.18 김기종
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
     * @class ESM_BKG_0445 : ESM_BKG_0445 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0445() {
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
    var arrWindow = new Array(null,null); 
    var sheetCnt = 0;
    var prefix="";
    var popWinObj;
    var rdObjects = new Array();
    var rdCnt = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_close":
					callBackOpener();
					window.close();
					break;
				case "btn_Split":
					callSplitPop(sheetObjects[1],ComFindText(sheetObjects[1], "origin", 1));
					break;
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
				case "btn_Duplicate":
					callDupChkPop();
					break;	
				case "btn_CancelCandidate":
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
					break;	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
    function loadPage() {
    	try {
    		for (i = 0; i < sheetObjects.length; i++) {
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i], i + 1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		//sheetObjects[0].ExtendLastCol = false;
    		sheetObjects[1].ExtendLastCol = false;
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	} catch (e) {
			if (e == "[object Error]") {
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;

    	switch (sheetNo) {
    	case 1: //sheet1 init
    		
			with (sheetObj) {

				// 높이 설정
				style.height = 160;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
	
				var HeadTitle  = "seq.|Split\nMaster|BKG|U/L\nSTS|VVD|POL|ETD|History at 1st e-SI Arrival|History at 1st e-SI Arrival|History at 1st e-SI Arrival|Current Data|Current Data|Current Data|Current Data|Current Data|Current Data|Current Data|Current Data|Read|sr_knd_cd|sr_no|sr_amd_tp_cd|sr_amd_seq|xter_rqst_no|xter_rqst_seq|doc_tp_cd|sr_crnt_sts_cd|sr_wrk_sts_cd|meas_ut_cd|net_wgt_ut_cd|pck_tp_cd|cntr_desc|Split|STS";
				var HeadTitle2 = "seq.|Split\nMaster|BKG|U/L\nSTS|VVD|POL|ETD|BKG EQ|CNTR#|Rec. Time|BKG EQ|CNTR#|PCS|Weight|Measure|SI Remark|SI Remark|SRC|Read|sr_knd_cd|sr_no|sr_amd_tp_cd|sr_amd_seq|xter_rqst_no|xter_rqst_seq|doc_tp_cd|sr_crnt_sts_cd|sr_wrk_sts_cd|meas_ut_cd|net_wgt_ut_cd|pck_tp_cd|cntr_desc|Split|STS";
	
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true,false);
				InitHeadRow(1, HeadTitle2, true,false);
				
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtDataSeq, 		30, 	daCenter, 		true, 		prefix+"Seq", 			false, 			"", 	dfNone, 		0, 		false, 		false);
				
				InitDataProperty(0, cnt++, 	dtRadioCheck, 	50,  	daCenter, 		true,  		prefix+"origin",            false, 			"", 	 dfNone,        0, 		true,  		true );
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		prefix+"bkg_no",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,		true,		prefix+"bkg_upld_sts_cd",	false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"vvd_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"pol_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"vps_etd_dt",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		prefix+"origin_bkg_qty",	false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		prefix+"origin_cntr_cnt",	false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix+"rqst_dt",			false,			"",      dfNone,		0,		false,		true);
				
				InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		prefix+"bkg_qty",			false,			"",      dfFloat,		2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		prefix+"cntr_cnt",			false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			85,		daRight,		true,		prefix+"pck_qty",			false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			85,		daRight,		true,		prefix+"net_wgt",			false,			"",      dfFloat,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			85,		daRight,		true,		prefix+"meas_qty",			false,			"",      dfFloat,		3,		false,		true);
				
				
				InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,			true,		prefix+"xter_rmk_all",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,			true,		prefix+"xter_rmk",			false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,		true,		prefix+"xter_sndr_id",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,    	35,  	daCenter, 		true, 		prefix+"read",              false, 			"", 	 dfNone,        0, 		false, 		false);
				
				
				
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_knd_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,			true,		prefix+"sr_no",				false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_amd_tp_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_amd_seq",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"xter_rqst_no",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"xter_rqst_seq",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"doc_tp_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_crnt_sts_cd",	false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_wrk_sts_cd",		false,			"",      dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"meas_ut_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"net_wgt_ut_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"pck_tp_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,			true,		prefix+"cntr_desc",			false,			"",      dfNone,		0,		false,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"split_sts_cd",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"xter_bkg_rqst_sts_cd",false,		"",      dfNone,		0,		false,		true);
				
				CountPosition = 0;
				SelectHighLight = true;
				SelectBackColor = RgbColor(0,255,0);
				ImageList(0) = "/hanjin/img/btns_note.gif";
				ImageList(1) = "/hanjin/img/blank.gif";
				
			}
			break;
			
    	case 2: //sheet2 init
		
			with (sheetObj) {
	
				// 높이 설정
				style.height = 300;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
	
				var HeadTitle  = "|seq.|Split\nCFM|Master|BKG NO|DOC\nType|E-SI|E-SI|E-SI|E-SI|E-SI|E-SI|Sail Date|U/L\nSTS|CNTR#|PCS|Weight|Measure|VVD|SI Remark|SI Remark|SRC|Read|CNTR\nNos..on S/I|Hold\nEDI|BKG\nValid|sr_knd_cd|sr_no|sr_amd_tp_cd|sr_amd_seq|meas_ut_cd|net_wgt_ut_cd|pck_tp_cd";
				var HeadTitle2 = "|seq.|Split\nCFM|Master|BKG NO|DOC\nType|S/I Ref.No|Split|STS|Ver.|Rec. Time|POL|Sail Date|U/L\nSTS|CNTR#|PCS|Weight|Measure|VVD|SI Remark|SI Remark|SRC|Read|CNTR\nNos..on S/I|Hold\nEDI|BKG\nValid|sr_knd_cd|sr_no|sr_amd_tp_cd|sr_amd_seq|meas_ut_cd|net_wgt_ut_cd|pck_tp_cd";
	
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true,false);
				InitHeadRow(1, HeadTitle2, true,false);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix+"ibflag");
			    InitDataProperty(0, cnt++, 	dtDataSeq, 		30, 	daCenter, 		true, 		prefix + "Seq");
			    InitDataProperty(0, cnt++, 	dtCheckBox, 	40,  	daCenter, 		true,  		prefix+"sel",               false, 			"", 	dfNone,        	0, 		true,  		true );
			    
			    InitDataProperty(0, cnt++, 	dtRadioCheck, 	50,  	daCenter, 		true,  		prefix+"origin",               false, 			"", 	dfNone,     0, 		true,  		true );
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		prefix+"bkg_no",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		prefix+"doc_tp_cd",			false,			"",      dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		prefix+"xter_rqst_no",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		prefix+"split_sts_cd",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		prefix+"xter_bkg_rqst_sts_cd",false,		"",      dfNone,		0,		false,		true);
				
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		prefix+"xter_rqst_seq",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		prefix+"rqst_dt",			false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"pol_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"rqst_dep_dt",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"bkg_upld_sts_cd",	false,			"",      dfNone,		0,		false,		true);
				
				
				InitDataProperty(0, cnt++ , dtAutoSum,		45,		daCenter,		true,		prefix+"cntr_cnt",			false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtAutoSum,		55,		daRight,		true,		prefix+"pck_qty",			false,			"",      dfInteger,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		true,		prefix+"net_wgt",			false,			"",      dfFloat,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		true,		prefix+"meas_qty",			false,			"",      dfFloat,		3,		false,		true);
				
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"vvd_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,			true,		prefix+"xter_rmk_all",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			150,	daLeft,			true,		prefix+"xter_rmk",			false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"xter_sndr_id",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtImage,    	35,  	daCenter, 		true, 		prefix+"read",              false, 			"", 	 dfNone,        0, 		false, 		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,			true,		prefix+"cntr_desc",			false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		prefix+"edi_hld_flg",		false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		prefix+"bkg_valid_flg",		false,			"",      dfNone,		0,		false,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_knd_cd",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,			true,		prefix+"sr_no",				false,			"",      dfNone,		0,		false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_amd_tp_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"sr_amd_seq",		false,			"",      dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"meas_ut_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"net_wgt_ut_cd",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		prefix+"pck_tp_cd",			false,			"",      dfNone,		0,		false,		false);
				
				ImageList(0) = "/hanjin/img/btns_note.gif";
				ImageList(1) = "/hanjin/img/blank.gif";
				SelectionMode = 0;
			}
			break;
    	}
    }
   //Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
	   
		switch (sAction) {
			case IBCLEAR: //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObjects[1].RemoveAll();
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0445GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 1) 
					sheetObjects[1].LoadSearchXml(arrXml[1]);
				ComOpenWait(false);
				break;
			case IBSEARCH: //조회
				formObj.f_cmd.value = SEARCH;
				if (ComGetObjValue(formObj.xter_sndr_id) == "") return;
				
				sheetObj.WaitImageVisible = false;
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0445GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) 
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) 
					sheetObjects[1].LoadSearchXml(arrXml[1]);
				
				ComOpenWait(false);
				break;
			
			case IBSAVE:
				
				if (chkValidSplitCancelRow(sheetObj) == false){
					ComShowCodeMessage('BKG95031','Split Cancel Row');
					return;
				}
				if (ComShowCodeConfirm("BKG00575") == false){
					return;
				}
				formObj.f_cmd.value = MULTI;
				var SaveStr = sheetObj.GetSaveString(false);
				if (sheetObj.IsDataModified && SaveStr == "") return;
				
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0445GS.do?f_cmd="+MULTI, SaveStr);
				
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComShowCodeMessage("BKG00590");
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}else{
					ComShowCodeMessage('BKG00110','Split Cancel');
					return;
				}
				break;		
				
		}
	}
     function chkValidSplitCancelRow(sheetObj){
    	 with (sheetObj) { 
    		 for(var iRow=2;iRow<=LastRow ;iRow++){
    			if (CellValue(iRow, prefix+"sel") == "1" 
    				&& (CellValue(iRow, prefix+"split_sts_cd") == "S" || CellValue(iRow, prefix+"split_sts_cd") == "F" )){ 
	     			return true;
    			}
    		 }	
    	 }
    	 return false;
     }
     
     function f_isNullBlank(val){
  	   if (typeof(val) == "undefined"){
  		   return  "";
  	   }
  	   return val;
     }
     
      /**
       * Sheet 조회완료 후 이벤트 발생
       */
      function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	  var xter_sndr_id = sheetObjects[0].CellValue(sheetObjects[0].LastRow,prefix+"xter_sndr_id"); 
    	  var xter_rqst_no = sheetObjects[0].CellValue(sheetObjects[0].LastRow,prefix+"xter_rqst_no"); 
    	  var xter_rqst_seq = sheetObjects[0].CellValue(sheetObjects[0].LastRow,prefix+"xter_rqst_seq"); 
    	  
     	  with (sheetObj) {
               for (var i = HeaderRows ; i < LastRow; i++) {
                   CellImage(i,prefix+"read"      ) = 0;
                   sheet2_SetRowColor(sheetObj,i);
               }
               FrozenCols = SaveNameCol(prefix+"rqst_dep_dt");
               CellValue2(LastRow, prefix + "Seq") = "";
               CellValue2(LastRow, prefix + "bkg_upld_sts_cd") = "Total";
               SumText(0,prefix + "cntr_cnt") = 0;
	      	   SumText(0,prefix + "pck_qty") = 0;
	      	   SumText(0,prefix + "meas_qty") = 0.000;
	      	   SumText(0,prefix + "net_wgt") = 0.000;
           }
      } 
      function sheet2_SetRowColor(sheetObj,row){
    	  var bColor = sheetObjects[0].RgbColor(0, 0, 255);
    	  var rColor = sheetObjects[0].RgbColor(255, 0, 0);
    	  
    	  with (sheetObj) {
    		  
    	    if (CellValue(row, prefix+"bkg_upld_sts_cd") == "R" || CellValue(row, prefix+"bkg_upld_sts_cd") == "D") {
				RowFontColor(row) = rColor; 
			} else if (CellValue(row, prefix+"bkg_upld_sts_cd") == "N" || CellValue(row, prefix+"bkg_upld_sts_cd") == "P") {
				RowFontColor(row) = bColor;
			} else{
				RowFontColor(row) = RgbColor(0, 0, 0);
			}
    	  }  
      }
      /*
       * OPEN POP WINDOW CHECK
       */
	  function openPopWindowCheck(){
		 for (var idx=0; idx< arrWindow.length ; idx++) {
			 if(arrWindow[idx] == null || arrWindow[idx].closed) 
				 return idx;
		 }
		 
		 return 99;
	  }
	  /*
      *  get Sheet row value
      */
	  function getGetSheetRowParam(sheetObj, Row, prefix, param){
	 		var sParam = "?";
	 		with (sheetObj) {
	 			for(i=0;i<param.length;i++){
	 				sParam += "&"+param[i]+"=" + CellValue(Row,prefix+param[i]);  
	 			}	
	 		}
	 		return sParam;
	 	}
      
      function validateForm(){
    	  var formObj = document.form;
        	
      	  if (ComFindText(sheetObjects[1], "origin", 1) < 1){
      		  ComShowCodeMessage("BKG01164");
      		  return false;
          }
      	
          if (sheetObjects[1].RowCount("U") < 2 ){
  	          ComShowCodeMessage("BKG00155");
  	          return false;
          }
          var message = "";
          with (sheetObjects[1]) {
	          for(var iRow=HeaderRows+1;iRow<=LastRow ;iRow++){
	  			if (CellValue(iRow, prefix+"sel") == "1"){ 
	  				var seq = CellValue(iRow, "seq") ;
	  				message = "S/I Ref.No : " + CellValue(iRow, "xter_rqst_no") +"\n";
	  				message += "Ver.	  : " + CellValue(iRow, "xter_rqst_seq")+"\n\n";

	  				if (CellValue(iRow, "bkg_upld_sts_cd") == "D") {
	  					ComShowMessage(message+msgs['BKG00471']);
	  					SelectCell(iRow,prefix+"sel");
	  					return false;
	  				}
	  				if (CellValue(iRow, "bkg_upld_sts_cd") == "R") {
	  					ComShowMessage(message+msgs['BKG00473']);
	  					SelectCell(iRow,prefix+"sel");
	  					return false;
	  				}
	  				if (CellValue(iRow, "bkg_upld_sts_cd") == "F") {
	  					ComShowMessage(message+msgs['BKG02049']);
	  					SelectCell(iRow,prefix+"sel");
	  					return false;
	  				}
	  			}
	  		  }	
          }
          return true;
      }
      /*
       * Booking Split 조회 팝업
       */
      function callSplitPop(sheetObj,rowIdx) {
      	
          if (validateForm() == false) return false;
          
          var winIdx = openPopWindowCheck();
          var param   = new Array("bkg_no","vvd_cd");
   		  var sParam = getGetSheetRowParam(sheetObj, rowIdx ,prefix,param);
   		  
   		  sParam += "&splitcount="+sheetObjects[1].RowCount("U") ;
   		 
   		  ComOpenPopup("/hanjin/ESM_BKG_0099.do" + sParam+ "&pgmNo=ESM_BKG_0099&openerPgmNo=ESM_BKG_0445&popUpFlag=Y", 1024, 700, "", "0,1,1,1,1", true);
      } 
       /*
        * Booking Container Dup Check Result 조회 팝업
        */
       function callDupChkPop() {
    	   	if (validateForm() == false){ 
    	   		return;
    	   	}
    	   	
    	   	//if (ComShowCodeConfirm("BKG01165") ==false) return;
    	   			
           	var winIdx = openPopWindowCheck();
           	
           	var sParam = sheetObjects[1].GetSaveString(false); 
           	ComOpenWindowCenter("/hanjin/ESM_BKG_0449.do?f_cmd="+SEARCH+"&" + sParam+ "&pgmNo=ESM_BKG_0449", "ESM_BKG_0449", 800, 550, true, "yes");
       } 
       
       function initRdConfig(rdObject){
	    	var Rdviewer = rdObject ;
	    	Rdviewer.style.height = 0;
	
	    	Rdviewer.setbackgroundcolor(128,128,128);
	    	Rdviewer.SetPageLineColor(128,128,128);
	    	Rdviewer.AutoAdjust = true;
	    	Rdviewer.ViewShowMode(0);
	    }

	   function rdOpen(sheetObj,Row){
	   		var Rdviewer = rdObjects[0];
	   		var formObj = document.form;
	   		
	   		var rdParam = "/rv " + "frm1_sender_id["+sheetObj.CellValue(Row, prefix+"xter_sndr_id")+"] frm1_rqst_no["+sheetObj.CellValue(Row, prefix+"xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.CellValue(Row, prefix+"xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.CellValue(Row, prefix+"bkg_no")+"]";
	   		var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
	   		var rdFile = null;
	   		
	   		if ( sheetObj.CellValue(Row, prefix+"doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
	   		else rdFile = "ESM_BKG_0230S.mrd";
	   		
	   		formObj.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/"+rdFile;
	   		formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
	   		
	   		var iWidth = 1000;
	   		var	iHeight= 600;
	   		var leftpos = (screen.width - iWidth) / 2;
	   		if (leftpos < 0)
	   			leftpos = 0;
	   		var toppos = (screen.height - iHeight) / 2;
	   		if (toppos < 0)
	   			toppos = 0;
	   		ComOpenRDPopup('resizable=yes,width='+iWidth+',height='+iHeight+',left='+ leftpos + ',top=' + toppos);
   	}
        
    /*
     *  Sheet Click Event
     */
    function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
    	 var chkFlag = false;
    	 with (sheetObj) { 
    		
	        if (ColSaveName(colIdx) == prefix+"read" && CellValue(rowIdx, prefix+"xter_sndr_id") != ""){
				rdOpen(sheetObj,rowIdx);
			}
	        if (ColSaveName(colIdx) == prefix+"xter_rmk") {
	    		ComShowMemoPad(sheetObj, null,sheetObj.SaveNameCol(prefix+"xter_rmk_all"), true, null, null, 1000);
	    	}
	        if (ColSaveName(colIdx) == prefix+"origin" ) {
	        	sheetObjects[1].Redraw = false;
	        	doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
	        	sheetObjects[1].DataInsert(0);	
	        	/*
	        	if (ComFindText(sheetObjects[1], "origin", 1) < 1 && ComFindText(sheetObjects[1], "bkg_no", CellValue(rowIdx, prefix+"bkg_no")) < 1){
	        		sheetObjects[1].DataInsert(0);	
	        	}else if (sheetObjects[1].RowCount == 1 && ComFindText(sheetObjects[1], "bkg_no", CellValue(rowIdx, prefix+"bkg_no")) > 0){
	        		sheetObjects[1].DataInsert(0);	
	        		chkFlag = true;
	        	}else{
	        		ComMakeEmptyRow(sheetObjects[1], sheetObjects[1].HeaderRows, "ibflag,Seq,sel,origin");
	        	}*/
	        	
        		for(var col=0;col<=LastCol ;col++){
        			var colName  = ColSaveName(col);
        			
    				if (colName == "xter_rqst_no" || colName == "split_sts_cd" || colName == "xter_bkg_rqst_sts_cd" 
    					|| colName == "xter_rqst_seq" || colName == "rqst_dt"  || colName == "pol_cd" 
    						|| colName == "xter_rmk" || colName == "xter_rmk_all" ||  colName == "xter_sndr_id" ){
    					
    				}else{
    					sheetObjects[1].CellFontColor(sheetObjects[1].HeaderRows,colName) = RgbColor(0, 0, 255);
        				sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows,colName) = CellValue(rowIdx,colName);
    				}
        		}	
        		sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows,prefix+"sel") = 1;
        		sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows,prefix+"origin") = 1;
        		sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows,prefix+"ibflag") = "U";
        		sheetObjects[1].CellValue2(sheetObjects[1].LastRow, prefix + "Seq") = "";
        		sheetObjects[1].CellImage(sheetObjects[1].HeaderRows,prefix+"read"      ) = 1;
        		setSumSplitChkBkg(sheetObjects[1]);
        		
        		sheet2_SetRowColor(sheetObjects[1],sheetObjects[1].HeaderRows);
        		sheetObjects[1].Redraw = true;
	        }
    	 }
    } 
    /*
      *  Sheet Click Event
    */ 
    function sheet2_OnClick(sheetObj,rowIdx,colIdx,val) {
    	
    	if (sheetObj.ColSaveName(colIdx) == prefix+"origin" ) {
    		sheetObj.CellValue2(rowIdx,prefix+"sel") = 1;  
    	}
    	if (sheetObj.ColSaveName(colIdx) == prefix+"sel" ) {
    		if (sheetObj.CellValue(rowIdx,prefix+"origin") == 1){
    			sheetObj.CellValue2(rowIdx,prefix+"sel") = 0;  
    		}
    	}
        if (sheetObj.ColSaveName(colIdx) == prefix+"read"  && sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") != ""){
 			rdOpen(sheetObj,rowIdx);
 		}
        if (sheetObj.ColSaveName(colIdx) == prefix+"xter_rmk") {
    		ComShowMemoPad(sheetObj, null,sheetObj.SaveNameCol(prefix+"xter_rmk_all"), true, null, null, 1000);
    	}
        if (sheetObj.ColSaveName(colIdx) == prefix+"cntr_desc") {
    		ComShowMemoPad(sheetObj, null,sheetObj.SaveNameCol(prefix+"cntr_desc"), true, null, null, 1000);
    	}
        
        
     }  
      /*
       * sheet1 OnChange 함수
       */
      function sheet2_OnChange(sheetObj,Row, Col, Value) {
    	   if (sheetObj.ColSaveName(Col) == prefix+"sel" || sheetObj.ColSaveName(Col) == prefix+"origin") {
           		setSumSplitChkBkg(sheetObj);
           }
      }
      
      
     function setSumSplitChkBkg(sheetObj){
    	 var  cntr_cnt = 0; var pck_qty = 0; var meas_qty = 0 ; var net_wgt  = 0;
    	 
    	 with (sheetObj) { 
    		 for(var iRow=2;iRow<=LastRow ;iRow++){
    			if (CellValue(iRow, prefix+"sel") == "1" && CellValue(iRow, prefix+"origin") != "1" ){ 
	     			cntr_cnt += BkgParseInt(CellValue(iRow, prefix+"cntr_cnt"));
	     			pck_qty += BkgParseInt(CellValue(iRow, prefix+"pck_qty"));
	     			meas_qty += BkgParseFloat(CellValue(iRow, prefix+"meas_qty"));
	     			net_wgt +=BkgParseFloat(CellValue(iRow, prefix+"net_wgt"));
    			}
    		 }	
    		 SumText(0,prefix + "cntr_cnt") = ComAddComma(cntr_cnt);
    		 SumText(0,prefix + "pck_qty") = ComAddComma(pck_qty);
    		 SumText(0,prefix + "meas_qty") = ComAddComma3(meas_qty,"#,###.000");
    		 SumText(0,prefix + "net_wgt") = ComAddComma3(net_wgt,"#,###.000");
    		 CellValue2(LastRow, prefix + "Seq") = "";
    		 
    	 }
     }
     function setCallBackReslult0999(splitActionflag){
    	 ComSetObjValue(document.form.splitActionflag,"true");
    	 ComBtnDisable("btn_Split");
    	 //btn_Retrieve.fireEvent("onclick");
     }
     
	 function callBackOpener(){
		var opener = window.dialogArguments; 
	  	if (ComGetObjValue(document.form.openerPgmNo) == "ESM_BKG_0421" && ComGetObjValue(document.form.splitActionflag) == "true" ){
			opener.btn_Retrieve.fireEvent("onclick");
	  	}else if (opener.document.location.href.indexOf("ESM_BKG_0228") > 0 && ComGetObjValue(document.form.splitActionflag) == "true" ){
	  		opener.sheetObjects[0].CellValue2(ComFindText(opener.sheetObjects[0], "sheet1_sel",1), "sheet1_split_sts_cd") = "F";
	  	}
	 } 
	 
	/* 개발자 작업  끝 */