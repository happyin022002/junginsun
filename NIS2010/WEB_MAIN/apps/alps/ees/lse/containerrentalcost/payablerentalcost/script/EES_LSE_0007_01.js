/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0007_01.js
*@FileTitle : Container Rental Charge Creation Audit & Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.30 노정용
* 1.0 Creation
* 2011.03.29 나상보
* Ticket No :CHM-201109721-01
* 개발자 : 나상보
* Title  : [LSE] Payable에서 Select 보턴 기능 Upgrade 요청
* Description : 1.shift + click으로 여러 건 선택 가능하도록 수정
	      		2.체크되지 않은 항목은 체크되게, 기 체크된 항목은 체크 해제하도록 수정
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
	 * @class EES_LSE_0007_01 : EES_LSE_0007_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0007_01() { 
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var orgCntrTpSzCd = "";
	var orgInvNo      = "";
	var orgAgmtNo     = "";
	var arrInvNo      = "";
	var arrChgSeq     = "";
	var arrAgmtCtyNo  = "";
	var arrAgmtSeq    = "";
	var vChgTypes     = "PDM|LON|LOF|PUC|PCR|DOC|DCR|DPP|OTH";
	var vChgType1     = "CRD";
	var vCntrTpSz1    = "BX";
	var vCntrTpSz2    = "XX";
	var vCrdSeq       = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Reject":
					if ( ComShowCodeConfirm("COM130101", "Reject Audit") ) {
						doActionIBSheet(sheetObject2, formObj, IBSAVE);
					}
					break;

				case "btn_Confirm":
					if ( ComShowCodeConfirm("COM130101", "Confirm Audit") ) {
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
					}
					break;

				case "btn_Close":
					window.close();
					break;

				case "btn_t1RowAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;

				case "btn_t1RowDelete":
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
					break;

				case "btn_t2Move":
					doActionIBSheet(sheetObject2, formObj, IBCOPYROW);
					break;

				case "btn_t3Move":
					doActionIBSheet(sheetObject3, formObj, IBCOPYROW);
					break;

				case "btn_t4Move":
					doActionIBSheet(sheetObject4, formObj, IBCOPYROW);
					break;

				case "btn_t2DownExcel":
					sheetObject2.SpeedDown2Excel(-1)
					break;

				case "btn_t3DownExcel":
					sheetObject3.SpeedDown2Excel(-1)
					break;

				case "btn_t4DownExcel":
					sheetObject4.SpeedDown2Excel(-1)
					break;
			} // end switch
		} catch(e) {
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

		for ( var i = 0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		for ( var k = 0 ; k < tabObjects.length ; k++ ) {
			initTab(tabObjects[k],k+1);
		}

		ComAddSeparator(form.chg_cost_yrmon, "ym");
		doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
//		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		
		// 2014.12.10
        var opener = window.dialogArguments;
        var openerSheet = opener.document.form.sheet1;
        var selRows = openerSheet.FindCheckedRow("chkbox");
        selRows = selRows.split("|");  // 1|

        for(var idx=0; idx < selRows.length -1; idx++){
	        if(openerSheet.CellValue(selRows[idx], "chg_sts_cd") == "I"){
	        	ComBtnDisable("btn_Reject");
	        	ComBtnDisable("btn_Confirm");
	        }
		}

	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;
		var formObj = document.form;

		switch (sheetid) {
			case "t1sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 280;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|sel|Seq.|CNTR No.|TP/SZ|Invoice\nNo.|AGMT No.|Contract No.|Audit\nStatus|Original\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|Credit\nAmount|Credit No.||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	25,		daCenter,	true,	"chkbox");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq",				false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_no",			true,	"",	dfNone, 	0,	false,		true,	11);
					InitDataProperty(0, cnt++ , dtCombo,		55,		daCenter,	true,	"cntr_tpsz_cd",		true,	"",	dfNone, 	0,	false,		false);

					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	"inv_no",			true,	"",	dfNone, 	0,	false,		true,	20);
					InitDataProperty(0, cnt++ , dtCombo,		75,		daCenter,	true,	"agmt_no",			true,	"",	dfNone, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_aud_sts_cd",	false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"pay_chg_sts_cd",	false,	"",	dfNone, 	0,	false,		false);

					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"lse_pay_chg_tp_cd",true,	"",	dfNone, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"onh_dt",			false,	"",	dfDateYmd, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"onh_loc_cd",		false,	"",	dfNone, 	0,	false,		true,	5);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"offh_dt",			false,	"",	dfDateYmd, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"offh_loc_cd",		false,	"",	dfNone, 	0,	false,		true,	5);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"cost_dys",			false,	"",	dfInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"chg_free_dys",		false,	"",	dfInteger, 	0,	false,		true,	3);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"bil_dys",			false,	"",	dfInteger, 	0,	false,		true,	3);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"pd_rt_amt",		false,	"",	dfFloat, 	2,	false,		true,	13);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"ttl_cost_amt",		false,	"",	dfFloat, 	2,	false,		true,	13);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_onh_dt",		false,	"",	dfDateYmd, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"dscr_onh_loc_cd",	false,	"",	dfNone, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_offh_dt",		false,	"",	dfDateYmd, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"dscr_offh_loc_cd",	false,	"",	dfNone, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"dscr_rt_amt",		false,	"",	dfFloat, 	2,	false,		true,	13);

					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dscr_cost_amt",	false,	"",	dfFloat, 	2,	false,		true,	13);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"cr_amt",			false,	"",	dfFloat, 	2,	false,		true,	13);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cr_no",			false,	"",	dfNone, 	0,	false,		true,	20);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_seq",			false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_cty_cd",		true,	"",	dfNone, 	0,	false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_seq",			true,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"dtl_seq",			false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_cost_yrmon",	false,	"",	dfNone, 	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"lse_pay_chg_tp_nm",false,	"",	dfNone, 	0,	false,		false);

					InitDataValid(0, "cntr_no",	    		vtEngUpOther, "1234567890");
					InitDataValid(0, "onh_loc_cd",			vtEngUpOther, "1234567890");
					InitDataValid(0, "offh_loc_cd",			vtEngUpOther, "1234567890");
					InitDataValid(0, "dscr_onh_loc_cd",		vtEngUpOther, "1234567890");
					InitDataValid(0, "dscr_offh_loc_cd",	vtEngUpOther, "1234567890");
					InitDataValid(0, "cr_no",	    		vtEngOther, "1234567890,-_");
					
					WaitImageVisible = false;
				}
				break;

			case "t2sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 280;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Audit Reason|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit\nAmount|Credit No.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice||||||||Diff. AMT";
					var HeadTitle2 = "||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Audit Reason|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit\nAmount|Credit No.|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount||||||||Diff. AMT";

					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	25,		daCenter,	true,	"chkbox");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq",				false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"inv_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"agmt_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_aud_sts_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"audit_rsn",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lse_pay_chg_tp_cd",false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"onh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"onh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"offh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"offh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"cost_dys",			false,	"",	dfNullInteger, 	0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"chg_free_dys",		false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"bil_dys",			false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"pd_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"ttl_cost_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"cr_amt",			false,	"",	dfNullFloat, 	2,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"dscr_onh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_onh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"dscr_offh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_offh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"dscr_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dscr_cost_amt",	false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_seq",			false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"dtl_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_cost_yrmon",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pay_chg_sts_cd",	false,	"",	dfNone, 		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"lse_pay_chg_tp_nm",true,	"",	dfNone, 		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"diff_cost_amt",	false,	"|dscr_cost_amt|-|ttl_cost_amt|",	dfNullFloat, 	2,	false,		true);
				}
				break;

			case "t3sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 280;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit\nAmount|Credit No.|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	25,		daCenter,	true,	"chkbox");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq",				false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"inv_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"agmt_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_aud_sts_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lse_pay_chg_tp_cd",false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"onh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"onh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"offh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"offh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"cost_dys",			false,	"",	dfNullInteger, 	0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"chg_free_dys",		false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"bil_dys",			false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"pd_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"ttl_cost_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"cr_amt",			false,	"",	dfNullFloat, 	2,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"dscr_onh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"dscr_onh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"dscr_offh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"dscr_offh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"dscr_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"dscr_cost_amt",	false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_seq",			false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"dtl_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_cost_yrmon",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pay_chg_sts_cd",	false,	"",	dfNone, 		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"lse_pay_chg_tp_nm",false,	"",	dfNone, 		0,	false,		false);
				}
				break;

			case "t4sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 280;	

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle1 = "||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit\nAmount|Credit No.|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);
									
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
									
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
									
					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	25,		daCenter,	true,	"chkbox");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq",				false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"inv_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"agmt_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_aud_sts_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lse_pay_chg_tp_cd",false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"onh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"onh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"offh_dt",			false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"offh_loc_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"cost_dys",			false,	"",	dfNullInteger, 	0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"chg_free_dys",		false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"bil_dys",			false,	"",	dfNullInteger, 	0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"pd_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"ttl_cost_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"cr_amt",			false,	"",	dfNullFloat, 	2,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cr_no",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_onh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"dscr_onh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"dscr_offh_dt",		false,	"",	dfDateYmd, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"dscr_offh_loc_cd",	false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"dscr_rt_amt",		false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dscr_cost_amt",	false,	"",	dfNullFloat, 	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"agmt_seq",			false,	"",	dfNone, 		0,	false,		true);

					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"dtl_seq",			false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"chg_cost_yrmon",	false,	"",	dfNone, 		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pay_chg_sts_cd",	false,	"",	dfNone, 		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"lse_pay_chg_tp_nm",false,	"",	dfNone, 		0,	false,		false);
				}
				break;
			}
	 	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBCREATE:	//Container Type/Size Grid Combo Item Setting
				arrInvNo      = ComGetObjValue(formObj.inv_no).split("|");
				arrChgSeq     = ComGetObjValue(formObj.chg_seq).split("|");
				arrAgmtCtyNo  = ComGetObjValue(formObj.agmt_cty_cd).split("|");
				arrAgmtSeq    = ComGetObjValue(formObj.agmt_seq).split("|");

				//sheetObj.WaitImageVisible = false;

				/* Container Type/Size */
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					orgCntrTpSzCd = ComGetEtcData(sXml, "cntr_tpsz_cd");

					if ( orgCntrTpSzCd != "" ) {
	        			sheetObj.InitDataCombo(0, "cntr_tpsz_cd", " |"+orgCntrTpSzCd+"|"+vCntrTpSz1+"|"+vCntrTpSz2, " |"+orgCntrTpSzCd+"|"+vCntrTpSz1+"|"+vCntrTpSz2);
	        		}
				}
				
				/* Invoice No. */
				var invNo = "";
				for ( var i = 0 ; i < arrInvNo.length ; i++ ) {
					if ( i == 0 ) {
						invNo = arrInvNo[i];
					} 

					else {
						var appdFlag = true;
						for ( var j = 0 ; j < i ; j++ ) {
							if ( arrInvNo[i] == arrInvNo[j] ) {
								appdFlag = false;
							}
						}
						if ( appdFlag ) {
							invNo = invNo + "|" + arrInvNo[i];
						}
					}
				}
				sheetObj.InitDataCombo(0, "inv_no",  " |"+invNo, " |"+invNo);

				/* Pay Charge Type */
				sheetObj.InitDataCombo(0, "lse_pay_chg_tp_cd", " |"+vChgType1+"|"+vChgTypes, " |"+vChgType1+"|"+vChgTypes);

				/* Agreement No. */
				for (var i = 0 ; i < arrAgmtCtyNo.length ; i++ ) {
					if ( i == 0 ) {
						orgAgmtNo = arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
					} else {
						orgAgmtNo = orgAgmtNo + "|" + arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
					}
				}
				sheetObj.InitDataCombo(0, "agmt_no", " |"+orgAgmtNo, " |"+orgAgmtNo);

				//sheetObj.WaitImageVisible = true;
				break;

			case IBSEARCH:      //조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("EES_LSE_0007_01GS.do" , FormQueryString(formObj));
					//sheetObj.WaitImageVisible = true;
					var arrXml = sXml.split("|$$|");
					if ( arrXml.length > 0 ) {
						if ( ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S" ) {
							if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
							if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
							if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
							if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);

							computeSum(sheetObjects[0]);
							computeSum(sheetObjects[1]);
							computeSum(sheetObjects[2]);
							computeSum(sheetObjects[3]);
						}
					}

					if ( sheetObjects[0].RowCount > 0 ) {
						for ( var i = sheetObjects[0].HeaderRows ; i <= sheetObjects[0].LastRow ; i++ ) {
							if ( sheetObjects[0].CellValue(i, "pay_chg_sts_cd") == "C" ) {
								sheetObjects[0].CellEditable(i, "chkbox") = false; 
							}
						}
					}

					// Discrepancy Data 중 틀린 부분 표시
					var msgDisc = "";
					if ( sheetObjects[1].RowCount > 0 ) {
						var rgbCd  = sheetObjects[1].RgbColor(255, 0, 0);
						for ( var i = sheetObjects[1].HeaderRows ; i <= sheetObjects[1].LastRow ; i++ ) {
							if ( sheetObjects[1].CellValue(i, "onh_dt") != sheetObjects[1].CellValue(i, "dscr_onh_dt") ) {
								sheetObjects[1].CellFont("FontColor", i, "onh_dt")        = rgbCd;
								sheetObjects[1].CellFont("FontColor", i, "dscr_onh_dt")   = rgbCd;
								sheetObjects[1].CellFont("FontBold", i, "onh_dt")         = true;
								sheetObjects[1].CellFont("FontBold", i, "dscr_onh_dt")    = true;
								msgDisc = "On-hire Date";
								sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
							}

							if ( sheetObjects[1].CellValue(i, "offh_dt") != sheetObjects[1].CellValue(i, "dscr_offh_dt") ) {
								sheetObjects[1].CellFont("FontColor", i, "offh_dt")       = rgbCd;
								sheetObjects[1].CellFont("FontColor", i, "dscr_offh_dt")  = rgbCd;
								sheetObjects[1].CellFont("FontBold", i, "offh_dt")        = true;
								sheetObjects[1].CellFont("FontBold", i, "dscr_offh_dt")   = true;
								if (msgDisc == "") msgDisc = "Off-hire Date";
								else msgDisc = msgDisc + ", Off-hire Date";
								sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
							}

							if ( sheetObjects[1].CellValue(i, "pd_rt_amt") != sheetObjects[1].CellValue(i, "dscr_rt_amt") ) {
								sheetObjects[1].CellFont("FontColor", i, "pd_rt_amt")     = rgbCd;
								sheetObjects[1].CellFont("FontColor", i, "dscr_rt_amt")   = rgbCd;
								sheetObjects[1].CellFont("FontBold", i, "pd_rt_amt")      = true;
								sheetObjects[1].CellFont("FontBold", i, "dscr_rt_amt")    = true;
								if (msgDisc == "") msgDisc = "Rate";
								else msgDisc = msgDisc + ", Rate";
								sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
							}

							if ( sheetObjects[1].CellValue(i, "ttl_cost_amt") != sheetObjects[1].CellValue(i, "dscr_cost_amt") ) {
								sheetObjects[1].CellFont("FontColor", i, "ttl_cost_amt")  = rgbCd;
								sheetObjects[1].CellFont("FontColor", i, "dscr_cost_amt") = rgbCd;
								sheetObjects[1].CellFont("FontBold", i, "ttl_cost_amt")   = true;
								sheetObjects[1].CellFont("FontBold", i, "dscr_cost_amt")  = true;
								if (msgDisc == "") msgDisc = "Amount";
								else msgDisc = msgDisc + ", Amount";
								sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
							}
							msgDisc = "";
						}
					}

					ComOpenWait(false);
					//sheetObj.WaitImageVisible = true;
				}
				break;

			case IBBATCH:      //조회-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "t1sheet1") {
						formObj.f_cmd.value = COMMAND01;
						sheetObjects[0].WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 10000;
							timer1 = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;

			case IBSAVE:        //저장
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "t1sheet1" ) {
						var sParam = "f_cmd=" + MULTI;
						sParam = sParam + "&chg_cost_yrmon=" + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", "");
						sParam = sParam + "&chg_seq=" + ComGetObjValue(formObj.chg_seq)
						sParam = sParam + "&agmt_cty_cd=" + ComGetObjValue(formObj.agmt_cty_cd)
						sParam = sParam + "&agmt_seq=" + ComGetObjValue(formObj.agmt_seq)
						sParam = sParam + "&" + LseGetAllSaveText(sheetObj, true, "ibflag", "t1sheet1_");
						var sXml = sheetObj.GetSaveXml("EES_LSE_0007_01GS.do", sParam);
						sheetObj.LoadSaveXml(sXml);
					} else if ( sheetObj.id == "t2sheet1" ) {
						ComSetObjValue(formObj.f_cmd, MULTI01);
						//sheetObj.DoSave("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						var sXml = sheetObj.GetSaveXml("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveXml(sXml);
					}
				}
				break;

			case IBINSERT:      // 입력
				var rowIdx = sheetObj.DataInsert(-1);
				sheetObj.CellComboItem(rowIdx, "agmt_no", " ", " ");
				sheetObj.CellValue(rowIdx, "cntr_no")			= getCrdCntrNo(sheetObj, rowIdx);
				sheetObj.CellValue(rowIdx, "chg_cost_yrmon")	= ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", "");
				sheetObj.CellValue(rowIdx, "cntr_aud_sts_cd")	= "L";
				sheetObj.CellValue(rowIdx, "lse_pay_chg_tp_cd")	= vChgType1;
				sheetObj.CellValue(rowIdx, "pay_chg_sts_cd")	= "A";

				break;

			case IBDELETE:      // 입력
				ComRowHideDelete(sheetObj, "chkbox");
				computeSum(sheetObj);
				break;

			case IBCOPYROW:
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);

				var sXml = makeSearchXml(sheetObj, "chkbox", "cntr_no|cntr_tpsz_cd|inv_no|agmt_no|lse_ctrt_no|cntr_aud_sts_cd|lse_pay_chg_tp_cd|onh_dt|onh_loc_cd|offh_dt|offh_loc_cd|cost_dys|chg_free_dys|bil_dys|pd_rt_amt|ttl_cost_amt|cr_amt|cr_no|dscr_onh_dt|dscr_onh_loc_cd|dscr_offh_dt|dscr_offh_loc_cd|dscr_rt_amt|dscr_cost_amt|chg_seq|agmt_cty_cd|agmt_seq|dtl_seq|chg_cost_yrmon|pay_chg_sts_cd|lse_pay_chg_tp_nm", true, 1000);

				for ( var idx = 0 ; idx < sXml.length ; idx++ ) {
					var beforeRowCount = sheetObjects[0].HeaderRows + sheetObjects[0].RowCount;
					sheetObjects[0].LoadSearchXml(sXml[idx], true);
					var afterRowCount = sheetObjects[0].HeaderRows + sheetObjects[0].RowCount;

					// 1. Discrepancy / Hanjin Only / Lessor Only => Coincidence 이동 Data 는 Edit 불가.
					// 2. Lessor Only 에서 이동한 Data 중 CNTR TP/SZ 가 없는 경우 'XX' 로 Setting.
					// 3. Lessor Only 에서 이동한 Data 중 Charge Type 이 없는 경우 Cell Edit 가능.
					if ( sheetObj.id == "t4sheet1" ) {
						for ( var jdx = beforeRowCount ; jdx < afterRowCount ; jdx++ ) {
							if ( sheetObjects[0].CellValue(jdx, "cntr_tpsz_cd") == "" ) {
								sheetObjects[0].CellValue(jdx, "cntr_tpsz_cd") = vCntrTpSz2;
							}
							if ( sheetObjects[0].CellValue(jdx, "lse_pay_chg_tp_cd") == "" ) {
								sheetObjects[0].CellComboItem(jdx, "lse_pay_chg_tp_cd", " |"+vChgTypes, " |"+vChgTypes);
								sheetObjects[0].CellEditable(jdx, "lse_pay_chg_tp_cd") = true;
							}
							if ( sheetObjects[0].CellValue(jdx, "dscr_cost_amt") < 0 ) {
								sheetObjects[0].CellValue(jdx, "cr_amt") = sheetObjects[0].CellValue(jdx, "dscr_cost_amt");
								sheetObjects[0].CellValue(jdx, "cr_no")  = sheetObjects[0].CellValue(jdx, "inv_no");
								sheetObjects[0].CellValue(jdx, "dscr_cost_amt") = 0.0;
							}
						}
					}
				}

				// Coincidence Tab 합계 계산.
				computeSum(sheetObj);
				computeSum(sheetObjects[0]);

				ComOpenWait(false);

				// Coincidence Tab 으로 이동
				tabObjects[0].SelectedIndex = 0;
				sheetObjects[0].SelectCell(sheetObjects[0].LastRow, "seq");
				break;
		}
	}

	/**
    * IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
    * 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
    * 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
    * bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sXml = makeSearchXml(sheetObj, "chkBox","trd_cd|rlane_cd|dir_cd");
    * </pre>
    * @param {ibsheet} 		sheet_obj   필수,IBSheet Object ID
    * @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
    * @param {string}  		saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
    * @param {bool}    		bRowDel     선택,대상행삭제여부, default=false
    * @param {int}    		pageRowCnt  페이징 처리 시 1페이지의 Row 갯수
    * @return string, Sheet의 데이터를 조회XML로 구성한 문자열
    */
    function makeSearchXml(sheetObj, col, saveColName, bRowDel, pageRowCnt) {
        try {
            //함수 인자 유효성 확인
            if ( typeof sheetObj != "object" || sheetObj.tagName != "OBJECT" ) {
                ComShowMessage("ComMakeSearchXml 함수의 sheetObj 인자는 IBSheet가 아닙니다.");
                return "";
            }

            var sColOrder = "";

            if ( saveColName != undefined && saveColName != null && saveColName != "" ) {
                sColOrder = " COLORDER='" + saveColName + "' ";
            }

            var arrCol    = saveColName.split("|");
    		var aryTD     = new Array(arrCol.length);
    		var sColSep   = "^|^";

    		var findRows  = sheetObj.FindCheckedRow(col);

    		if ( findRows != "" ) {
        		findRows       = findRows.substring(0, findRows.length-1); //맨끝의 "|"제거
        		var arrRow     = findRows.split("|");
        		var totPageCnt = Math.ceil(arrRow.length / pageRowCnt);
                var arrXml     = new Array(totPageCnt);

        		for ( var i = 0 ; i < totPageCnt ; i++ ) {
        			var allXml = "";
        			var trCnt  = 0;

        			if ( i < totPageCnt-1 ) {
        				trCnt = pageRowCnt;
        			} else {
        				trCnt = arrRow.length - i*pageRowCnt;
        			}
        			var aryTR  = new Array(trCnt);

        			allXml = "<?xml version='1.0'  ?>\n"
                           + "<SHEET>\n"
                           + "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";

            		for ( var ir = (i*pageRowCnt) ; ir < (i*pageRowCnt + trCnt) ; ir++ ) {
            			if ( sheetObj.id == "t2sheet1" ) {
	            			if ( sheetObj.CellValue(arrRow[ir], "dscr_cost_amt") < 0 ) {
								sheetObj.CellValue2(arrRow[ir], "cr_amt") = sheetObj.CellValue(arrRow[ir], "dscr_cost_amt");
								sheetObj.CellValue2(arrRow[ir], "cr_no")  = sheetObj.CellValue(arrRow[ir], "inv_no");
								sheetObj.CellValue2(arrRow[ir], "dscr_cost_amt") = 0.0;
							}
            			} else if ( sheetObj.id == "t3sheet1" ) {
            				// Hanjin Only Tab 에서 이동하는 Data 는 Hanjin 정보로 Lessor 의 정보생성.
    						sheetObj.CellValue2(arrRow[ir], "dscr_onh_dt")      = sheetObj.CellValue(arrRow[ir], "onh_dt");
    						sheetObj.CellValue2(arrRow[ir], "dscr_offh_dt")     = sheetObj.CellValue(arrRow[ir], "offh_dt");
    						sheetObj.CellValue2(arrRow[ir], "dscr_onh_loc_cd")  = sheetObj.CellValue(arrRow[ir], "onh_loc_cd");
    						sheetObj.CellValue2(arrRow[ir], "dscr_offh_loc_cd") = sheetObj.CellValue(arrRow[ir], "offh_loc_cd");
    						sheetObj.CellValue2(arrRow[ir], "dscr_rt_amt")      = sheetObj.CellValue(arrRow[ir], "pd_rt_amt");
    						sheetObj.CellValue2(arrRow[ir], "dscr_cost_amt")    = sheetObj.CellValue(arrRow[ir], "ttl_cost_amt");
            			} else if ( sheetObj.id == "t4sheet1" ) {
            				sheetObj.CellValue2(arrRow[ir], "lse_pay_chg_tp_nm") = sheetObj.CellValue(arrRow[ir], "lse_pay_chg_tp_cd");

    						var agmtNo    = sheetObj.CellValue(arrRow[ir], "agmt_no");
    						var agmtCtyCd = agmtNo.substr(0, 3);
    						var agmtSeq   = ComParseInt(agmtNo.substr(3))+"";
    						var chgSeq    = "";
    						for ( var j = 0 ; j < arrAgmtSeq.length ; j++ ) {
    							if ( agmtSeq == arrAgmtSeq[j] ) {
    								sheetObj.CellValue2(arrRow[ir], "chg_seq") = arrChgSeq[j];
    							}
    						}
            			}
            			
            			for ( var ic = 0 ; ic < arrCol.length ; ic++ ) {
            				//TD-셀의 값을 변수에 저장한다.
            				aryTD[ic] = String(sheetObj.CellValue(arrRow[ir], arrCol[ic]));
            			}

            			aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
            		}

            		allXml += aryTR.join("\n");
                    allXml += "  </DATA>\n"
                 	       +  "</SHEET>";

                    arrXml[i] = allXml;
        		}

        		if (bRowDel) {
        			sheetObj.Redraw = false;
                    sheetObj.RedrawSum = false;

                    for ( var ir = arrRow.length-1 ; ir >= 0 ; ir-- ) {
                    	sheetObj.RowDelete(arrRow[ir],false);
                    }
                    sheetObj.RedrawSum = true;
                    sheetObj.Redraw = true;
        		}
        	}

            return arrXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;

					InsertTab( cnt++ , "Coincidence" , -1 );
					InsertTab( cnt++ , "Discrepancy" , -1 );
					InsertTab( cnt++ , "SMLine Only" , -1 );
					InsertTab( cnt++ , "Lessor Only" , -1 );
				}
				break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		//doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if ( sheetObj.EtcData("TRANS_RESULT_KEY") == "S" ) {
			window.close();
			var opener = window.dialogArguments;
			var func   = "opener."+ComGetObjValue(formObj.func)+"();";
			eval(func);
		}
	}

	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		
		switch (colName) {
			case "cntr_no" :
				// 1. Container No.가 입력될 경우 TP/SZ 조회하여 Setting.
				// 2. 입력되지 않으면 TP/SZ 초기화.
				// 3. Charge Type 이 "CRD" 일 경우에는 Container No. OnChange Event 수행 안됨.
				if ( ComTrim(Value) != "" ) {
					setCntrTpSzAsyncData(sheetObj, Row, Col, Value);
				} else {
					sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
				}
				break;
/*
			case "bil_dys" :
			case "pd_rt_amt" :
				if ( sheetObj.CellValue(Row, "lse_pay_chg_tp_cd") == "PDM" ) {
					sheetObj.CellValue(Row, "ttl_cost_amt") = sheetObj.CellValue(Row, "bil_dys") * sheetObj.CellValue(Row, "pd_rt_amt");
				}
				break;
*/
			case "inv_no":
				// 1. Invoice No. Value 가 변경되면 해당 Invoice 와 관련된 Agreement 만 Combo 에 Setting.
				var agmtNo = "";
				for ( var i = 0 ; i < arrInvNo.length ; i++ ) {
					if ( Value == arrInvNo[i] ) {
						if ( agmtNo == "" ) {
							agmtNo = arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
						} else {
							agmtNo = agmtNo + "|" + arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
						}
					}
				}
				sheetObj.CellComboItem(Row, "agmt_no", " |"+agmtNo, " |"+agmtNo);
				break;
	
			case "agmt_no":
				// 1. Agreement 가 선택되면, Hidden Field 에 값 Setting.
				var agmtCtyCd = Value.substr(0, 3);
				var agmtSeq   = ComLtrim(Value.substr(3), "0");
				for ( var i = 0 ; i < arrAgmtSeq.length ; i++ ) {
					if ( agmtSeq == arrAgmtSeq[i] ) {
						sheetObj.CellValue2(Row, "agmt_cty_cd") = agmtCtyCd;
						sheetObj.CellValue2(Row, "agmt_seq")    = agmtSeq;
						sheetObj.CellValue2(Row, "chg_seq")     = arrChgSeq[i];
					}
				}
				break;

			case "lse_pay_chg_tp_cd":
				if ( Value == vChgType1 ) {
					// 1. Charge Type 이 "CRD" 일 경우 CNTR_TPSZ 는 "BX"로 Setting 후 Edit 불가.
					// 2. Container No. 는 자동채번되어 Setting 되며 Edit 불가.
					sheetObj.CellValue2(Row, "cntr_no")			= getCrdCntrNo(sheetObj, Row);
					sheetObj.CellValue(Row, "cntr_tpsz_cd")		= vCntrTpSz1;
					sheetObj.CellValue(Row, "cost_dys")			= 0;
					sheetObj.CellValue(Row, "chg_free_dys")		= 0;
					sheetObj.CellValue(Row, "bil_dys")			= 0;
					sheetObj.CellValue(Row, "pd_rt_amt")		= 0.0;
					sheetObj.CellValue(Row, "ttl_cost_amt")		= 0.0;
					sheetObj.CellValue(Row, "cr_amt")			= 0.0;
					sheetObj.CellValue(Row, "dscr_onh_dt")		= "";
					sheetObj.CellValue(Row, "dscr_onh_loc_cd")	= "";
					sheetObj.CellValue(Row, "dscr_offh_dt")		= "";
					sheetObj.CellValue(Row, "dscr_offh_loc_cd")	= "";
					sheetObj.CellValue(Row, "dscr_rt_amt")		= 0.0;
					sheetObj.CellValue(Row, "dscr_cost_amt")	= 0.0;
					sheetObj.CellEditable(Row, "cntr_no")		= false;
					sheetObj.CellEditable(Row, "cntr_tpsz_cd")	= false;
					sheetObj.CellEditable(Row, "cost_dys")		= false;
					sheetObj.CellEditable(Row, "chg_free_dys")	= false;
					sheetObj.CellEditable(Row, "bil_dys")		= false;
					sheetObj.CellEditable(Row, "pd_rt_amt")		= false;
					sheetObj.CellEditable(Row, "ttl_cost_amt")	= false;
					sheetObj.CellEditable(Row, "dscr_rt_amt")	= false;
					sheetObj.CellEditable(Row, "dscr_cost_amt")	= false;
				} else if ( ComTrim(Value) != "" ) {
					// 1. OnChange Event 가 발생한 Row 가 Row Add 로 입력된 Row 일 경우에만 Edit 가능.
					// 2. Charge Type 이 "CRD" 가 아닐 경우 CNTR No. 가 "CRD"로 시작한다면 CNTR No. 와 TP/SZ 초기화.
					if ( sheetObj.CellValue(Row, "pay_chg_sts_cd") == "A" ) {
						if ( sheetObj.CellValue(Row, "cntr_no") != "" && sheetObj.CellValue(Row, "cntr_no").substr(0, 3) == "CRD" ) {
							sheetObj.CellValue(Row, "cntr_no")		= "";
							sheetObj.CellValue(Row, "cntr_tpsz_cd")	= "";
						}
						sheetObj.CellEditable(Row, "cntr_no")		= true;
						//sheetObj.CellEditable(Row, "cntr_tpsz_cd")	= true;
						sheetObj.CellEditable(Row, "cost_dys")		= true;
						sheetObj.CellEditable(Row, "chg_free_dys")	= true;
						sheetObj.CellEditable(Row, "bil_dys")		= true;
						sheetObj.CellEditable(Row, "pd_rt_amt")		= true;
						sheetObj.CellEditable(Row, "ttl_cost_amt")	= true;
						sheetObj.CellEditable(Row, "dscr_rt_amt")	= true;
						sheetObj.CellEditable(Row, "dscr_cost_amt")	= true;
					}
				}
				break;

			case "onh_loc_cd":
			case "offh_loc_cd":
			case "dscr_onh_loc_cd":
			case "dscr_offh_loc_cd":
				if ( Value != "" ) {
					setLocationAsyncData(sheetObj, Row, Col, Value);
				}
				break;

			case "ttl_cost_amt":
			case "dscr_cost_amt":
				if ( Value < 0 ) {
					sheetObj.CellValue2(Row, Col) = Value * -1;
				}
				computeSum(sheetObj);
				break;

			case "cr_amt":
				if ( Value > 0 ) {
					sheetObj.CellValue2(Row, Col) = Value * -1;
				}
				computeSum(sheetObj);
				break;
		}
	}

	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if ( sheetObj.EtcData("TRANS_RESULT_KEY") == "S" ) {
			window.close();
			var opener = window.dialogArguments;
			var func   = "opener."+ComGetObjValue(formObj.func)+"();";
			eval(func);
		}
	}

	/**
	 * Sheet 내 금액 합계 구하기.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function computeSum(sheetObj) {
		var formObj = document.form;

		var amt  = 0;
		var cAmt = 0;
		var pAmt = 0;

		if ( sheetObj.id == "t1sheet1") {
			sheetObj.ReNumberSeq(); 

			// t1sheet1 Sheet 내 전체 Row의 금액 계산
			amt  = parseFloat(sheetObj.ComputeSum("|dscr_cost_amt|")*100);
			cAmt = parseFloat(sheetObj.ComputeSum("|cr_amt|")*100);

			// Delete 된 Row의 금액 계산
			var delRows = sheetObj.FindStatusRow("D");
			var arrDelRow = delRows.split(";");
			var delCostAmt = 0;
			var delCrAmt   = 0;
			for ( var i = 0 ; i < arrDelRow.length-1 ; i++ ) {
				delCostAmt = delCostAmt + sheetObj.CellValue(arrDelRow[i], "dscr_cost_amt")*100;
				delCrAmt   = delCrAmt   + sheetObj.CellValue(arrDelRow[i], "cr_amt")*100;
			}

			// 전체금액 - Delete 금액 Setting : TTL_COST_AMT는 (+)금액, CR_AMT는 (-)금액으로 입력됨.
			ComSetObjValue(formObj.t1pAmt, (amt/100+cAmt/100-delCostAmt/100-delCrAmt/100).toFixed(2));
			ComSetObjValue(formObj.t1cAmt, (cAmt/100-delCrAmt/100).toFixed(2));
			ComSetObjValue(formObj.t1Amt,  (amt/100-delCostAmt/100).toFixed(2));

			// 금액 Format.
			ComAddSeparator(form.t1pAmt, "float");
			ComAddSeparator(form.t1cAmt, "float");
			ComAddSeparator(form.t1Amt,  "float");
		} else if ( sheetObj.id == "t2sheet1") {
			if ( sheetObj.RowCount > 0 ) {
				// t2sheet1 Sheet 내 전체 Row의 금액 계산
				amt  = parseFloat(sheetObjects[1].ComputeSum("|dscr_cost_amt|"));
				cAmt = parseFloat(sheetObjects[1].ComputeSum("|cr_amt|"));

				// 금액 Setting : TTL_COST_AMT는 (+)금액, CR_AMT는 (-)금액으로 입력됨.
				ComSetObjValue(formObj.t2pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t2cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t2Amt,  amt.toFixed(2));

				// 금액 Format.
				ComAddSeparator(form.t2pAmt, "float");
				ComAddSeparator(form.t2cAmt, "float");
				ComAddSeparator(form.t2Amt,  "float");
			} else {
				ComSetObjValue(formObj.t2pAmt, "");
				ComSetObjValue(formObj.t2cAmt, "");
				ComSetObjValue(formObj.t2Amt,  "");
			}
		} else if ( sheetObj.id == "t3sheet1") {
			if ( sheetObj.RowCount > 0 ) {
				// t3sheet1 Sheet 내 전체 Row의 금액 계산
				amt  = parseFloat(sheetObjects[2].ComputeSum("|ttl_cost_amt|"));
				cAmt = parseFloat(sheetObjects[2].ComputeSum("|cr_amt|"));

				// 금액 Setting : TTL_COST_AMT는 (+)금액, CR_AMT는 (-)금액으로 입력됨.
				ComSetObjValue(formObj.t3pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t3cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t3Amt,  amt.toFixed(2));

				// 금액 Format.
				ComAddSeparator(form.t3pAmt, "float");
				ComAddSeparator(form.t3cAmt, "float");
				ComAddSeparator(form.t3Amt,  "float");
			} else {
				ComSetObjValue(formObj.t3pAmt, "");
				ComSetObjValue(formObj.t3cAmt, "");
				ComSetObjValue(formObj.t3Amt,  "");
			}
		} else if ( sheetObj.id == "t4sheet1") {
			if ( sheetObj.RowCount > 0 ) {
				// t3sheet1 Sheet 내 전체 Row의 금액 계산
				amt  = parseFloat(sheetObjects[3].ComputeSum("|dscr_cost_amt|"));
				cAmt = parseFloat(sheetObjects[3].ComputeSum("|cr_amt|"));

				// 금액 Setting : TTL_COST_AMT는 (+)금액, CR_AMT는 (-)금액으로 입력됨.
				ComSetObjValue(formObj.t4pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t4cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t4Amt,  amt.toFixed(2));

				// 금액 Format.
				ComAddSeparator(form.t4pAmt, "float");
				ComAddSeparator(form.t4cAmt, "float");
				ComAddSeparator(form.t4Amt,  "float");
			} else {
				ComSetObjValue(formObj.t4pAmt, "");
				ComSetObjValue(formObj.t4cAmt, "");
				ComSetObjValue(formObj.t4Amt,  "");
			}
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSAVE:
				if ( sheetObj.id == "t1sheet1" ) {
					for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
						if ( ComTrim(sheetObj.CellValue(i, "cntr_no")) == "" ) {
							ComShowCodeMessage("LSE01064");
							sheetObj.SelectCell(i, "cntr_no");
							return false;
						}
	
						if ( ComTrim(sheetObj.CellValue(i, "cntr_tpsz_cd")) == "" ) {
							ComShowCodeMessage("LSE01015");
							sheetObj.SelectCell(i, "cntr_tpsz_cd");
							return false;
						}
	
						if ( ComTrim(sheetObj.CellValue(i, "inv_no")) == "" ) {
							ComShowCodeMessage("LSE01104");
							sheetObj.SelectCell(i, "inv_no");
							return false;
						}
	
						if ( ComTrim(sheetObj.CellValue(i, "agmt_no")) == "" ) {
							ComShowCodeMessage("LSE01006");
							sheetObj.SelectCell(i, "agmt_no");
							return false;
						}
	
						if ( ComTrim(sheetObj.CellValue(i, "lse_pay_chg_tp_cd")) == "" ) {
							ComShowCodeMessage("LSE01132");
							sheetObj.SelectCell(i, "lse_pay_chg_tp_cd");
							return false;
						}
					}
				}
				break;
		}
		return true;
	}

	/**
	 * Sheet Object 내 Location Code 변경 시 Validation 처리 부분<br>
	 * 
	 * @param sheetObj
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param Value
	 */
	function setLocationAsyncData(sheetObj, Row, Col, Value) {
		with(sheetObj) {
			if ( CellValue(Row,Col) != "" ) {
				var param = "f_cmd="  + SEARCH05
						 + "&loc_cd=" + Value
						 + "&loc_tp=" + "SCC";
				//WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
				//WaitImageVisible = true;

				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
						if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
							var vSccCd = ComGetEtcData(sXml, "scc_cd");
						} else {
							ComShowCodeMessage("LSE01037");
							CellValue2(Row,Col) = "";
						}
					} else {
						ComShowCodeMessage("LSE01037");
						CellValue2(Row,Col) = "";
						SelectCell(Row,Col);
					}
				}
			}
		}
	}

	/**
	 * Sheet Object 내 Location Code 변경 시 Validation 처리 부분<br>
	 * 
	 * @param sheetObj
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param Value
	 */
	function setCntrTpSzAsyncData(sheetObj, Row, Col, Value) {
		with(sheetObj) {
			if ( CellValue(Row,Col) != "" ) {
				var param = "f_cmd="  + SEARCH17
						 + "&cntr_no=" + Value;
				//WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
				//WaitImageVisible = true;

				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					if ( ComGetEtcData(sXml, "cntr_tpsz_cd") != undefined ) {
						if ( ComGetEtcData(sXml, "cntr_tpsz_cd") != "" ) {
							sheetObj.CellValue(Row, "cntr_tpsz_cd") = ComGetEtcData(sXml,"cntr_tpsz_cd");
						} else {
							sheetObj.CellValue(Row, "cntr_tpsz_cd") = "XX";
						}
					} else {
						sheetObj.CellValue(Row, "cntr_tpsz_cd") = "XX";
					}
				} else {
					sheetObj.CellValue(Row, "cntr_tpsz_cd") = "XX";
				}
			}
		}
	}

	/**
	 * Credit Charge Type 의 CNTR No. 구하기.
	 * @param sheetObj
	 * @param Row
	 * @return vCrdCntrNo
	 */
	function getCrdCntrNo(sheetObj, Row) {
		var formObj		= document.form;
		var vCrdMaxSeq	= 0;
		var vCrdCntrNo  = "CRD" + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", "").substr(2);
		for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
			if ( sheetObj.CellValue(i, "lse_pay_chg_tp_cd") == "CRD" && i != Row ) {
				var vCrdSeq = ComParseInt(ComLtrim(sheetObj.CellValue(i, "cntr_no").substr(7), "0"));
				if ( vCrdMaxSeq < vCrdSeq ) {
					vCrdMaxSeq = vCrdSeq;
				}
			}
		}
		vCrdCntrNo = vCrdCntrNo + ComLpad((vCrdMaxSeq+1)+"", 4, "0");
		return vCrdCntrNo;
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;

		var sXml = sheetObj.GetSearchXml("EES_LSE_0007_01GS.do", FormQueryString(formObj));
		//sheetObj.WaitImageVisible = true;
		
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND03;

		var sXml = sheetObj.GetSearchXml("EES_LSE_0007_01GS.do", FormQueryString(form));

		var arrXml = sXml.split("|$$|");
		if ( arrXml.length > 0 ) {
			if ( ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S" ) {
				if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
				if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
				if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);

				computeSum(sheetObjects[0]);
				computeSum(sheetObjects[1]);
				computeSum(sheetObjects[2]);
				computeSum(sheetObjects[3]);
			}
		}

		if ( sheetObjects[0].RowCount > 0 ) {
			for ( var i = sheetObjects[0].HeaderRows ; i <= sheetObjects[0].LastRow ; i++ ) {
				if ( sheetObjects[0].CellValue(i, "pay_chg_sts_cd") == "C" ) {
					sheetObjects[0].CellEditable(i, "chkbox") = false; 
				}
			}
		}

		// Discrepancy Data 중 틀린 부분 표시 2015.04.06
		var msgDisc = "";
		if ( sheetObjects[1].RowCount > 0 ) {
			var rgbCd  = sheetObjects[1].RgbColor(255, 0, 0);
			for ( var i = sheetObjects[1].HeaderRows ; i <= sheetObjects[1].LastRow ; i++ ) {
				if ( sheetObjects[1].CellValue(i, "onh_dt") != sheetObjects[1].CellValue(i, "dscr_onh_dt") ) {
					sheetObjects[1].CellFont("FontColor", i, "onh_dt")        = rgbCd;
					sheetObjects[1].CellFont("FontColor", i, "dscr_onh_dt")   = rgbCd;
					sheetObjects[1].CellFont("FontBold", i, "onh_dt")         = true;
					sheetObjects[1].CellFont("FontBold", i, "dscr_onh_dt")    = true;
					msgDisc = "On-hire Date";
					sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
				}

				if ( sheetObjects[1].CellValue(i, "offh_dt") != sheetObjects[1].CellValue(i, "dscr_offh_dt") ) {
					sheetObjects[1].CellFont("FontColor", i, "offh_dt")       = rgbCd;
					sheetObjects[1].CellFont("FontColor", i, "dscr_offh_dt")  = rgbCd;
					sheetObjects[1].CellFont("FontBold", i, "offh_dt")        = true;
					sheetObjects[1].CellFont("FontBold", i, "dscr_offh_dt")   = true;
					if (msgDisc == "") msgDisc = "Off-hire Date";
					else msgDisc = msgDisc + ", Off-hire Date";
					sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
				}

				if ( sheetObjects[1].CellValue(i, "pd_rt_amt") != sheetObjects[1].CellValue(i, "dscr_rt_amt") ) {
					sheetObjects[1].CellFont("FontColor", i, "pd_rt_amt")     = rgbCd;
					sheetObjects[1].CellFont("FontColor", i, "dscr_rt_amt")   = rgbCd;
					sheetObjects[1].CellFont("FontBold", i, "pd_rt_amt")      = true;
					sheetObjects[1].CellFont("FontBold", i, "dscr_rt_amt")    = true;
					if (msgDisc == "") msgDisc = "Rate";
					else msgDisc = msgDisc + ", Rate";
					sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
				}

				if ( sheetObjects[1].CellValue(i, "ttl_cost_amt") != sheetObjects[1].CellValue(i, "dscr_cost_amt") ) {
					sheetObjects[1].CellFont("FontColor", i, "ttl_cost_amt")  = rgbCd;
					sheetObjects[1].CellFont("FontColor", i, "dscr_cost_amt") = rgbCd;
					sheetObjects[1].CellFont("FontBold", i, "ttl_cost_amt")   = true;
					sheetObjects[1].CellFont("FontBold", i, "dscr_cost_amt")  = true;
					if (msgDisc == "") msgDisc = "Amount";
					else msgDisc = msgDisc + ", Amount";
					sheetObjects[1].CellValue2( i, "audit_rsn")    = msgDisc;
				}
				msgDisc = "";
			}
		}

		ComOpenWait(false);
	}
	
	function sheetMultiSelect(sheetObj, Row, Col){
        with(sheetObj) {
            // row클릭시 해당 Check Box도 체크
            // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
            var sRowStr = GetSelectionRows("/");
            var arr = sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i<arr.length; i++) {
                    if (CellEditable(arr[i], "chkbox")) {
                        if(CellValue(arr[i], "chkbox") == "0"){
                        	CellValue2(arr[i], "chkbox") = "1";    // 선택된 행의 CheckBox 체크
                        }else{
                        	CellValue2(arr[i], "chkbox") = "0";    // 선택된 행의 CheckBox가 이미 체크되어있으면 체크해제
                        }
                    }
                }
            }
        }
	}
	
	function t1sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		   sheetMultiSelect(sheetObj, Row, Col);
	   }
	
    /**
    * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
    * @param {sheetObj} String : 해당 IBSheet셀 명
    * @param {Row} Long : 해당 셀의 Row Index
    * @param {Col} Long : 해당 셀의 Column Index
    * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
    * @param {CellX} Long : 해당셀의 X좌표
    * @param {CellY} Long : 해당셀의 Y좌표
    * @param {CellW} Long : 해당셀의 가로 넓이값
    * @param {CellH} Long : 해당셀의 세로 높이값
    */
   function t2sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	   sheetMultiSelect(sheetObj, Row, Col);
   }
   
   /**
    * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
    * @param {sheetObj} String : 해당 IBSheet셀 명
    * @param {Row} Long : 해당 셀의 Row Index
    * @param {Col} Long : 해당 셀의 Column Index
    * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
    * @param {CellX} Long : 해당셀의 X좌표
    * @param {CellY} Long : 해당셀의 Y좌표
    * @param {CellW} Long : 해당셀의 가로 넓이값
    * @param {CellH} Long : 해당셀의 세로 높이값
    */
   function t3sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	   sheetMultiSelect(sheetObj, Row, Col);
   }
   
   /**
    * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
    * @param {sheetObj} String : 해당 IBSheet셀 명
    * @param {Row} Long : 해당 셀의 Row Index
    * @param {Col} Long : 해당 셀의 Column Index
    * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
    * @param {CellX} Long : 해당셀의 X좌표
    * @param {CellY} Long : 해당셀의 Y좌표
    * @param {CellW} Long : 해당셀의 가로 넓이값
    * @param {CellH} Long : 해당셀의 세로 높이값
    */
   function t4sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	   sheetMultiSelect(sheetObj, Row, Col);
   }
	/* 개발자 작업  끝 */