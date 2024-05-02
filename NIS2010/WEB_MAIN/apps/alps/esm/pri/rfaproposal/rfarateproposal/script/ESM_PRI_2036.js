﻿﻿﻿﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2036.js
*@FileTitle : RFA Proposal Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.24 박성수
* 1.0 Creation
=========================================================
* History
* 2015.09.24 전지예 [CHM-201537758] RFA module상 기능개선 및 추가 function 개발요청 관련
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
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
    function ESM_PRI_2036() {
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
			
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
	
			case "btn_acceptall":
				doActionIBSheet(sheetObject1, document.form, IBSAVE);
				break;
	
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
		
		bIsReqUsr = document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr = document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
		
		// Rate 탭의 Accept All일 경우
		if(document.form.is_accept_all.value == "Y") {
			sheetObjects[0].style.height = "520";
		}
		
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_acceptall");
    	} else {
    		disableButton("btn_acceptall");
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
			// Rate
		case 1: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 310;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Seq.|prop_no|amdt_seq|Scope|cmdt_hdr_seq|Commodity Group|Actual Customer|Commodity Note|route seq.|Origin|O.Via|D.Via|Destination|Proposal|GRI|Route Note|";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtData,    30, daCenterTop, true, "blet_dp_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 110, daLeftTop, true, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 100, daLeftTop, true, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 100, daLeftTop, true, "cnote_ctnt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 95, daLeftTop, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenterTop, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenterTop, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);				
				InitDataProperty(0, cnt++, dtData, 95, daLeftTop, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeftTop, false, "rt_ctnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daRightTop, false, "gri_ctnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeftTop, false, "rnote_ctnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "fic_rt_tp_cd", false, "", dfNone, 0, false, false);
	
                ShowButtonImage = 2;
                AutoRowHeight = true;
                WordWrap = true;
                
                /*
                if (document.form.gen_spcl_rt_tp_cd.value == "G") {
                	ColHidden("cust_lgl_eng_nm") = true;
                	ColWidth("prc_cmdt_def_nm") =  160;
                	ColWidth("cnote_ctnt") =  150;
                }
                */
			}
			break;

			// Arbitrary
		case 2: // sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 155;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "state|Seq.|Type|Point|Description||Term|Base\nPort|Trans\nMode|Per|CGO\nType|Actual\nCustomer|Customer Name|Cur.|Proposal|G/L|Diff|Weight\n(Ton<=)|Weight\n(<Ton)|C.Offer|Final|EFF Date|EXP Date|Source|Status|||||||||||||";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,	daCenter,		false,	"ibflag");
				InitDataProperty(0, cnt++, dtDataSeq,		30,	daCenter,		false,	"seq");
				InitDataProperty(0, cnt++, dtCombo,		70,	daCenter,		true,	"org_dest_tp_cd",				false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtData,			57,	daCenter, 	false,	"rout_pnt_loc_def_cd",		false,	"",	dfEngUpKey,		0,		false,	false,	5,	true);
				InitDataProperty(0, cnt++, dtData,    		100,	daLeft,			false,	"rout_pnt_loc_def_nm",	false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"rcv_de_term_cd");
				InitDataProperty(0, cnt++, dtData,			55,	daCenter,		false,	"rcv_de_term_nm",			false,	"",	dfEngUpKey,		0,		false,	false);
				InitDataProperty(0, cnt++, dtData,			57,	daCenter,		false,	"bse_port_def_cd",			false,	"",	dfEngUpKey,		0,		false,	false,	5);
				InitDataProperty(0, cnt++, dtCombo,		70,	daCenter,		false,	"prc_trsp_mod_cd",			false,	"",	dfEngUpKey,		0,		false,	false);
				InitDataProperty(0, cnt++, dtCombo,		38,	daCenter,		false,	"rat_ut_cd",						false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtCombo,		47,	daCenter,		false,	"prc_cgo_tp_cd",				false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtData,			70,	daCenter,		false, 	"cust_cnt_cd",					false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		true,	"cust_nm");
				InitDataProperty(0, cnt++, dtCombo,		43,	daCenter,		false,	"curr_cd",							false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtData,			68,	daRight,		false,	"prop_frt_rt_amt",			false,	"",	dfFloat,				2,		false,	false,	9);
				InitDataProperty(0, cnt++, dtHidden,		68,	daRight,		false,	"fic_gline_rt_amt",			false,	"",	dfFloat,				2,		false,	false,	9);
				InitDataProperty(0, cnt++, dtData,			68,	daRight,		false,	"diff_with_gl",					false,	"",	dfNone,			2,		false,	false,	9);
				InitDataProperty(0, cnt++, dtData,			55,	daRight,		true,	"min_cgo_wgt",				false,	"",	dfNullFloat,		2,		false,	false,	6);
				InitDataProperty(0, cnt++, dtData,			55,	daRight,		true,	"max_cgo_wgt",				false,	"",	dfNullFloat,		2,		false,	false,	6);
				InitDataProperty(0, cnt++, dtData,			68,	daRight,		false,	"coffr_frt_rt_amt",			false,	"",	dfNullFloat,		2,		false,	false,	9);
				InitDataProperty(0, cnt++, dtData,			68,	daRight,		false,	"fnl_frt_rt_amt",				false,	"",	dfNullFloat,		2,		false,	false);
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"eff_dt",							false,	"",	dfDateYmd,		0,		false,	false);
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"exp_dt",							false,	"",	dfDateYmd,		0,		false,	false);
				InitDataProperty(0, cnt++, dtCombo,		90,	daCenter,		false,	"src_info_cd",					false,	"",	dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++, dtCombo,		80,	daCenter,		false,	"prc_prog_sts_cd", 			false,	"",	dfNone,			0,		false,	false);
				
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"prop_no");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"amdt_seq");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"svc_scp_cd");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"add_chg_tp_cd");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"add_chg_seq");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,	"n1st_cmnc_amdt_seq");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"rout_pnt_loc_tp_cd");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"bse_port_tp_cd");
				
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"base_port_list");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"optm_trsp_mod_flg");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"fic_rout_cmb_tp_cd");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"fic_rt_use_sts_cd");
				InitDataProperty(0, cnt++, dtHidden,		0,		daCenter,		false,  	"fic_gline_upd_dt");

				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
				InitDataCombo(0, "curr_cd", currCdText, currCdValue,"USD");
				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
				InitDataCombo(0, "org_dest_tp_cd", orgDestTpCdText, orgDestTpCdValue);
				
                ShowButtonImage = 2;
                AutoRowHeight = true;
                WordWrap = true;
                
			}
			break;
			
			// Special Notes
		case 3: // sheet3 init
			with (sheetObj) {
				// 높이 설정
				style.height = 155;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Seq.|Contents|EFF Date|EXP Date|Source|Status" + "|1|2|3|4|5|6|7|8|9|10|11|12|13";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
                // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,	daCenter,		false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,		50,	daCenter, 	false,	"seq");
				InitDataProperty(0, cnt++ , dtData,			550,		daLeft,		false,	"note_ctnt",   					false,	"",	dfNone,			0,			false,	false,	50);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"eff_dt",		  					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"exp_dt",   	   					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		80, 	 daCenter, 	false,	"src_info_cd", 					false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		80,    daCenter, 	false,	"prc_prog_sts_cd", 			false,	"",	dfNone,			0,			false,	false);

				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		false,	"dp_seq",							false,	"",	dfNullInteger);
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"note_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"note_ctnt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"note_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"svc_scp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"prop_no");    
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"amdt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"note_conv_mapg_id");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"note_conv_flg");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"n1st_cmnc_amdt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"temp_note_conv_mapg_id"); //amend cancel 시 임시로 사용
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"bef_eff_dt");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"bef_exp_dt");

				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
				
                ShowButtonImage = 2;
                AutoRowHeight = true;
                WordWrap = true;
                
			}
			break;
			
			// Location Group
		case 4: // sheet4 init
			with (sheetObj) {
				// 높이 설정
				style.height = 85;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);
				
				var HeadTitle = "|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Detail Seq.|" +
										"Group Code|Location Code|Description|EFF Date|EXP Date|Source|Status|n1st_cmnc_amdt_seq";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
                // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,	daCenter,		false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,		40,	daCenter, 	false,	"seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"prop_no");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"amdt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"svc_scp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"grp_loc_dtl_seq");
				
				InitDataProperty(0, cnt++ , dtData,			120, daCenter,		false,	"prc_grp_loc_cd");
				InitDataProperty(0, cnt++ , dtData,			120,  daCenter, 	false,	"loc_cd", 							false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtData,			220,  daCenter, 	false,	"loc_nm", 						false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"eff_dt",		  					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"exp_dt",   	   					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		100,  daCenter, 	false,	"src_info_cd", 					false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		100,  daCenter, 	false,	"prc_prog_sts_cd", 			false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0, 	 daCenter,	false,	"n1st_cmnc_amdt_seq");

				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
				
                ShowButtonImage = 2;
                AutoRowHeight = true;
                WordWrap = true;
                
			}
			break;
			
			// Commodity Group
		case 5: // sheet5 init
			with (sheetObj) {
				// 높이 설정
				style.height = 85;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);
				
                var HeadTitle = "|Seq.|prop_no|amdt_seq|svc_scp_cd|Group Code|CMDT Type|CMDT Code|Description|EFF Date|EXP Date" +
        								"|Source|Status|grp_cmdt_seq|grp_cmdt_dtl_seq|n1st_cmnc_amdt_seq";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
                // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,	daCenter,		false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,		50,	daCenter, 	false,	"seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"prop_no");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"amdt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"svc_scp_cd");
				
				InitDataProperty(0, cnt++ , dtData,			100,  daCenter, 	false,	"prc_grp_cmdt_cd",		  	false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		100,  daCenter, 	false,	"prc_cmdt_tp_cd",		  	false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtData,			80,    daCenter, 	false,	"prc_cmdt_def_cd",		  	false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtData,			220,  daCenter, 	false,	"prc_cmdt_def_nm",		  	false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"eff_dt",		  					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,      daCenter, 	false,	"exp_dt",   	   					false,	"",	dfDateYmd,		0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		80, 	 daCenter, 	false,	"src_info_cd", 					false,	"",	dfNone,			0,			false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		80,    daCenter, 	false,	"prc_prog_sts_cd", 			false,	"",	dfNone,			0,			false,	false);
				
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"grp_cmdt_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"grp_cmdt_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		0, 	daCenter,		false,	"n1st_cmnc_amdt_seq");
				
				InitDataCombo(0,"prc_cmdt_tp_cd", prcCmdtTpCdText, prcCmdtTpCdValue);
				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
				InitDataValid(0, "prc_cmdt_def_cd", vtNumericOnly);
				
                ShowButtonImage = 2;
                AutoRowHeight = true;
                WordWrap = true;
                
			}
			break;
		}
	}
	
//	/**
//	 * OnDblClick 이벤트 발생시 호출되는 function <br>
//	 * <br><b>Example :</b>
//	 * <pre>
//	 *
//	 * </pre>
//	 * @param {ibsheet} sheetObj 필수 IBSheet Object
//	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
//	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
//	 * @return 없음
//	 * @author 박성수
//	 * @version 2009.05.01
//	 */
//	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
//		var formObj = document.form;
//		
//		if (Col >= 6 && Col <= 8) {
//			window.close();
//			opener.moveRowPosTo(sheetObj.CellValue(Row, "cmdt_hdr_seq"));
//		} else if (Col >= 10 && Col <= 13) {
//			window.close();
//			opener.moveRowPosTo(sheetObj.CellValue(Row, "cmdt_hdr_seq"), sheetObj.CellValue(Row, "rout_seq"));
//		} else if (Col >= 14) {
//			window.close();
//			opener.moveRowPosTo(sheetObj.CellValue(Row, "cmdt_hdr_seq"), sheetObj.CellValue(Row, "rout_seq"), sheetObj.CellValue(Row, "rt_seq"));
//		}
//	}
	
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
			
	        case IBSAVE: // Accept All
	        	ComOpenWait(true);
	            
	        	if (!ComShowCodeConfirm("PRI01035")) {
	        		return false;
	        	}
	        	
	        	var sParam = "";
	        	
	        	// Accept All
				if(document.form.is_accept_all.value == "Y") {
					formObj.f_cmd.value = MODIFY02;
					sParam = FormQueryString(formObj);
					
				// Summary일 경우
				} else {
					formObj.f_cmd.value = MODIFY01;
					sParam = FormQueryString(formObj);
					
					// Rate
					var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					if (sParamSheet1 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					
					// Arbitrary Origin & Dest
					var sParamSheet2 = getArbitraryParam(sheetObjects[1], formObj);
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					// Special Note
					var sParamSheet3 = sheetObjects[2].GetSaveString();
					if (sParamSheet3 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
					}
					// Location Group
					var sParamSheet4 = sheetObjects[3].GetSaveString();
					if (sParamSheet4 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
					}
					// Commodity Group
					var sParamSheet5 = sheetObjects[4].GetSaveString();
					if (sParamSheet5 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
					}
				}
            	
            	var sXml = sheetObj.GetSaveXml("ESM_PRI_2036GS.do", sParam);
            	sheetObj.LoadSaveXml(sXml);
	            
            	ComOpenWait(false);
	            break;
	            
			case IBSEARCH: // 조회
				formObj.f_cmd.value = SEARCH01;

	        	// Accept All
				if(document.form.is_accept_all.value == "Y") {
					formObj.f_cmd.value = SEARCH02;
				}
				
	     		var sXml = sheetObj.getSearchXml("ESM_PRI_2036GS.do", FormQueryString(formObj));
	     		var arrXml = sXml.split("|$$|");
	     		
	     		if (arrXml.length > 0) {
	     			// Rate
	     			sheetObjects[0].LoadSearchXml(arrXml[0]);
	     			
	     			// Summary일 경우
	     			if(formObj.is_accept_all.value != "Y") {
	     				// Arbitrary
	     				sheetObjects[1].LoadSearchXml(arrXml[1]);
	     				
	     				// Special Note
	     				sheetObjects[2].LoadSearchXml(arrXml[2]);
	     				
	     				// Location Group
	     				sheetObjects[3].LoadSearchXml(arrXml[3]);
	     				
	     				// Commodity Group
	     				sheetObjects[4].LoadSearchXml(arrXml[4]);
	     			}
	     		}
	            
	         	break;	
		
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
//                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
	}
	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 승인 완료 후 호출 창에 action을 취해준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 전지예
     * @version 2015.10.27
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	
    	//저장 후 후처리 - 부모창으로 성공시 전달함.
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
        	ComShowCodeMessage("PRI00108");
        	
            // Accept All일 경우
            if(formObj.is_accept_all.value != null && formObj.is_accept_all.value != "" && formObj.is_accept_all.value == "Y") {
            	window.close();
            	
            	opener.saveCurRowPos();
            	opener.reloadPagePostTr();
            } else {
            	window.returnValue = "Y";
            	window.close();
            }
        } else {
        	 window.returnValue = "N";
             window.close();
        }
    }
    
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 
     * @version 2015.09.11
     */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		
		if (ErrMsg == "") {
			if (sheetObj.RowCount > 0) {
				setSheetDisplay(sheetObj);
				
				// 승인 대상 트랜잭션 발생
				for(var i = 1; i <= sheetObj.RowCount; i++) {
					if(sheetObj.CellValue(i ,"prc_prog_sts_cd") == 'A') {
						sheetObj.CellValue2(i, "ibflag") = "R";
					} else {
						sheetObj.CellValue2(i, "ibflag") = "U";
					}
				}
				
			}
		}
	}
	
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 
     * @version 2015.09.11
     */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		
		if (ErrMsg == "") {
			if (sheetObj.RowCount > 0) {
				setSheetDisplay(sheetObj);
				
				// 승인 대상 트랜잭션 발생
				for(var i = 1; i <= sheetObj.RowCount; i++) {
					if(sheetObj.CellValue(i ,"prc_prog_sts_cd") == 'A') {
						sheetObj.CellValue2(i, "ibflag") = "R";
					} else {
						sheetObj.CellValue2(i, "ibflag") = "U";
					}
				}
				
			}
		}
	}
	
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 
     * @version 2015.09.11
     */
	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
		var amdt_seq = document.form.amdt_seq.value;
		var sts = document.form.prc_prop_sts_cd.value; // process 진행 상태 코드
		
		if (ErrMsg == "") {
			if (sheetObj.RowCount > 0) {
				
				if(amdt_seq!=0) {
					for(i=1 ; i < sheetObj.Rows; i++){
						if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
							sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
						}
						else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
							sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
						}
					}
				}
				
				// 승인 대상 트랜잭션 발생
				for(var i = 1; i <= sheetObj.RowCount; i++) {
					if(sheetObj.CellValue(i ,"prc_prog_sts_cd") == 'A') {
						sheetObj.CellValue2(i, "ibflag") = "R";
					} else {
						sheetObj.CellValue2(i, "ibflag") = "U";
					}
				}
				
			}
		}
	}
	
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 
     * @version 2015.09.11
     */
	function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
		
		if (ErrMsg == "") {
			if (sheetObj.RowCount > 0) {
				setSheetDisplay(sheetObj);
				
				// 미승인 Special Note 개수 집계
				for(var i = 1; i <= sheetObj.RowCount; i++) {
					if(sheetObj.CellValue(i ,"prc_prog_sts_cd") == 'A') {
						sheetObj.CellValue2(i, "ibflag") = "R";
					} else {
						sheetObj.CellValue2(i, "ibflag") = "U";
					}
				}
				
			}
		}
	}
	
	/**
     * sheet 의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function setSheetDisplay(sheetObj) {
		var amdtSeq = document.form.amdt_seq.value;
		var rCnt = sheetObj.RowCount;
		
		for(var i=1 ; i<=rCnt; i++) {
			calcProposalAmt(sheetObj, i);
			
			if(amdtSeq != 0) {
				if(sheetObj.CellValue(i ,"amdt_seq") != amdtSeq) { //이전회차는 줄긋는다. 
					sheetObj.CellFont("FontStrikethru", i, "seq", i, "prc_prog_sts_cd") = true;
				} else {
					if(sheetObj.CellValue(i, "prc_prog_sts_cd") == "I" || sheetObj.CellValue(i, "prc_prog_sts_cd") == "A") {
						sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol) = sheetObj.RgbColor(0,0,255); //파란색
					} else if(sheetObj.CellValue(i, "") == "D") {
						sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
					}
				}
			}
		}
	}

    /**
     * Propocal Amount 계산 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		calcProposalAmt(sheetObj, Row)
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function calcProposalAmt(sheetObj, Row){
    	
    	var strPropFrtRtAmt = "";
		var strFicGlineRtAmt = "";
		var numPropFrtRtAmt = 0;
		var numFicGlineRtAmt = 0;
		
		if("S"==sheetObj.CellValue(Row, "fic_rt_use_sts_cd")){
    		
    		strPropFrtRtAmt = sheetObj.CellValue(Row, "prop_frt_rt_amt");
			if(strPropFrtRtAmt){
				numPropFrtRtAmt = Number(strPropFrtRtAmt);
			}
			
			strFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
			if(strFicGlineRtAmt){
				numFicGlineRtAmt = Number(strFicGlineRtAmt);
			}
			
			// 부동소수점 제어를 위해 정수형 변경후 처리
			numPropFrtRtAmt = numPropFrtRtAmt * 100;
			numFicGlineRtAmt = numFicGlineRtAmt * 100;
			
			numPropFrtRtAmt = numPropFrtRtAmt.toFixed();
			numFicGlineRtAmt = numFicGlineRtAmt.toFixed();
			
			sheetObj.CellValue2(Row, "diff_with_gl") =  ComAddComma2(((numPropFrtRtAmt - numFicGlineRtAmt)/100).toString(), '#,###.00');
			
		}else{
			sheetObj.CellValue2(Row, "diff_with_gl") = "N/A";
		}
    }
    
    /**
     * Arbitrary의 전체 accpet 대상에 대해서 Accpet를 처리를 하기 위한 param값 취득 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptAllRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @return param
     * @author 전지예
     * @version 2015.10.27
     * ESM_PRI_2003_12.js의 acceptAllRows 참조
     */
  	function getArbitraryParam(sheetObj, formObj) {
		var amdtSeq = formObj.amdt_seq.value;
		var effDt = formObj.eff_dt.value;
		var propStsCd = formObj.prc_prop_sts_cd.value;
  		
		var trgtArr = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);

		if(trgtArr.length == 0) { // accept 대상에 해당하는 것이 없다.
//			ComShowCodeMessage("PRI00331", "Accept");
			return null;
		}
		
		for(var i=trgtArr.length-1; i>=0; i--) {
			if(sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") == "A" || sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") == "R") { //Accept 항목과 Return은 제외한다
				trgtArr.splice(i, 1);
			}
		}
		
		if(trgtArr.length == 0) { // 이미 모두 accept 되었다
//			ComShowCodeMessage("PRI00329");
			return null;
		}
		
		var rCnt = trgtArr.length;
		
		for(var i=0; i<rCnt; i++) {
  			if(propStsCd == "Q") { //현재 진행 상태가 Request 일때는 Propsal 금액을 Final에 입력 
  				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt"); //Sales.Rep의 금액을 승인
  			}
  			if(propStsCd == "R") { //현재 진행 상태가 Return 일때는 Counter Offer 금액을 Final에 입력
  				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt"); //Counter Offer의 금액을 승인
  			}
  			sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "A"; //Accept로 변경 
  		}
		
		var sParamSheet = sheetObj.GetSaveString();
		if(sParamSheet == "") {
			var topRow = sheetObj.TopRow;
			var lastRow = sheetObj.LastRow;
			
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return null;
		}
		
		return sParamSheet;
	}