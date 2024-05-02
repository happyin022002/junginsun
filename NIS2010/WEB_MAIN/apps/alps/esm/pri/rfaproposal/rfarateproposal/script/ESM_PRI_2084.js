/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2084.js
*@FileTitle : Amendment History - Rate (Commodity Note)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.21 박성수
* 1.0 Creation
=========================================================
* History
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2084() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업 */

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var bIsReqUsr = false;
    var bIsAproUsr = false;
    
    var exTransaction = false;
    
    var sChgCdVisiable = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
	
			case "btn_close":
				window.close();
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
	
	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
			ComEndConfigSheet(sheetObjects[i]);
		}
		
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
        case 1:  // Grid 1
            with (sheetObj) {
                // 높이 설정
                style.height = 102;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Commodity Group|Actual Customer|1|2|3|4";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 450, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
        		InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ac_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                
                Ellipsis = true;
                ShowButtonImage = 0;
                CountPosition = 0;
                UnEditableColor = RgbColor(255, 255, 255);
            }
            break;
		
		case 2: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 62;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|cmdt_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_note_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "note_ctnt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "note_conv_mapg_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCheckBox, 75, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false, -1, false, true, "", false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
	
                ShowButtonImage = 0;
                CountPosition = 0;
                AutoRowHeight = false;
                UnEditableColor = RgbColor(255, 255, 255);

			}
			break;
			
        case 3:      //t1sheet1 init
     		with (sheetObj) {
                // 높이 설정
                style.height = 170; 
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
                     	"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 5, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
	            InitDataProperty(0, cnt++ , dtData,	   			40,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     true,       true);
	            InitDataProperty(0, cnt++ , dtCombo,    		75,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,        		35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	2,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtCombo,      		75,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
	            
	            InitDataProperty(0, cnt++ , dtData,   			35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  			35,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
	            InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
	            InitDataProperty(0, cnt++ , dtData,				60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtCombo,			35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
	            
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtCombo,			150,  daCenter,  true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtCombo,   	 		55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
	            
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");    
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_cmdt_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_tp_cd");
	            
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_vsl_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_voy_no");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_dir_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
	            
	            InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");										
	            InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
	            InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);   
                InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue); 
                InitDataCombo(0, "bkg_esvc_tp_cd", bkgEsvcTpCdComboText, bkgEsvcTpCdComboValue);    
                
		 		ShowButtonImage = 0;	// Edit 가능할때 팝업 이미지 표시
		 		CountPosition = 0;		// Total 숨김
		 		UnEditableColor = RgbColor(255, 255, 255);
    		}
         	break;

		}
	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			var cmdtHdrSeq = sheetObj.CellValue(NewRow, "cmdt_hdr_seq");
			formObj.cmdt_hdr_seq.value = cmdtHdrSeq;
			
			formObj.ta_note_ctnt.value = "";
			ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", "X");
			for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
				if (sheetObjects[1].CellValue(i, "cmdt_hdr_seq") == cmdtHdrSeq && sheetObjects[1].RowStatus(i) != "D") {
					sheetObjects[1].RowHidden(i) = false;
					if (sheetObjects[1].CellValue(i, "amdt_seq") == formObj.amdt_seq.value) {
						sheetObjects[1].SelectRow = i;
						formObj.ta_note_ctnt.value = sheetObjects[1].CellValue(i, "note_ctnt");
						
						ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", sheetObjects[1].CellValue(i, "note_conv_mapg_id"));
					}
				} else {
					sheetObjects[1].RowHidden(i) = true;
				}
			}
		}
		
		sheetObjects[1].Redraw = true;
		sheetObjects[2].Redraw = true;
		
		changeSelectBackColor4Rate(sheetObj);
	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			formObj.ta_note_ctnt.value = sheetObj.CellValue(NewRow, "note_ctnt");
			
			ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", sheetObjects[1].CellValue(NewRow, "note_conv_mapg_id"));

			for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {
      			// State 색 구분
      			setStateColor(sheetObjects[2], i);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObjects[2], i);
	 		}
		}
		
		changeSelectBackColor4Rate(sheetObj);
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {		
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            var sXml = "";
	            
	            sheetObjects[2].Redraw = false;
				sXml = dialogArguments.getSheetXml(14);
				sheetObjects[2].LoadSearchXml(sXml);
	            
				sheetObjects[1].Redraw = false;
				sXml = dialogArguments.getSheetXml(5);
				sheetObjects[1].LoadSearchXml(sXml);
				sheetObjects[1].ColumnSort("cmdt_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
				setSheetStyle(sheetObjects[1], -1);
				
				sXml = dialogArguments.getSheetXml(0);
				sheetObjects[0].LoadSearchXml(sXml);
				setHdrLineStyle(sheetObjects[0]);
				
				sheetObjects[0].SelectRow = formObj.select_row.value;
				sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
				
	         	break; 	
		
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
		
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            
        case IBSEARCH: // 조회
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }

	/**
	 * Sheet에서 조회 후, 색상이나 Strike등의 스타일을 처리하는 함수.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetStyle(sheetObj, idx) {
    	if (sheetObj.RowCount <= 0) {
    		return;
    	}
    	
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	dialogArguments.setLineStyle(sheetObj, i);
            }
        } else {
        	dialogArguments.setLineStyle(sheetObj, idx);
        }
    }

    function setHdrLineStyle(sheetObj) {
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
    	
		for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (sheetObj.RowStatus(i) == "D") {
				sheetObj.RowHidden(i) = true;
			}
			
			if (parseInt(sheetObj.CellValue(i, "nd_cnt")) == 0) {
				sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = true;
			} else {
				sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = false;
			}
			if (parseInt(sheetObj.CellValue(i, "na_cnt")) > 0) {
				sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
			} else {
				sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
			}
		}
    }
    
  	/**
  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State 색 구분
 		var pinkColor = sheetObj.RgbColor(255,192,203);
 		
		if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 		}
		
		if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
 		} 		
 	
 	}
 	
  	/**
  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 색 구분
 		var sCodeColor = sheetObj.RgbColor(255,200,200);
 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
	 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
 		} 
 	}
    
 	