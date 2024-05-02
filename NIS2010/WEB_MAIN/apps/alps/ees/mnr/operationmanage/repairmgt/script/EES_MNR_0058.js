/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0058.js
 *@FileTitle : M&R Extra Expense W/O Creation
 *Open Issues :
 *Change history :
   1. 2015.06.05  SELPPS 도 SELCON 가 동일한 권한 부여, 신용찬,
	  CHM-201536194, 구매팀 M&R Extra WO 발행 및 인보이스 생성 권한 요청
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 정영훈
 *@LastVersion : 1.0
 * 2009.06.06 정영훈
 * 1.0 Creation
 * 2013.06.25 [CHM-201325409] SYDSC에서 MNR Management Fee를 입력할 수 있도록 기능 Hard coding 요청
 * 2015.06.10 [CHM-201536194] 신용찬, 06-05, 구매팀 M&R Extra WO 발행 및 인보이스 생성 권한 요청
 *            SELPPS 도 Seal Purchasing 이 보이도록 수정
=========================================================*/
/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends
	 * @class ees_mnr_0058 : ees_mnr_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0058() {
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
/* ********* General Functions ************* */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var costDtlCode = "";
	var costDtlDesc = "";
	var OrgCostType = "";

	var mnrHngrBarTpCode = "";
	var mnrHngrBarTpDesc = "";
	var nowLoad = 0;

	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;
	var arrDataSearchDbXml;

	var frontMnrOrdSeq="";

	//HG가 두개로 나누어져 5자리만 비교
	var costCdSubstr = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do?req_ofc=" + currOfcCd, 720, 380, 'setParam', '0,0', true);
				break;

			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
				break;

			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;

			case "btn_W/O_Creation":
				//MEXBA-MEXSC 변경에 따른 신규 데이타 생성 막음
				if(currOfcCd == "MEXBA"){
					ComShowCodeMessage("MNR00357");
					break;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;

			case "btn_W/O_Send":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;

			case "btn_delete":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCHAPPEND);
				break;

			// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S]
			case "btn_loadExcel":
				doLoadExcel(sheetObjects[0], formObject);
				break;
			// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E]
			case "btn_RowAdd":
				doRowAdd(sheetObjects[0], formObject);
				break;

			case "btn_RowDel":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
				}
				break;

			case "btn_excelDown":
				sheetObjects[0].SpeedDown2Excel(-1);
				break;

			case "btn_File_Add":
				file_Insert(sheetObjects[1]);
				break;

			case "btn_File_Del":
				file_Remove(sheetObjects[1]);
				break;

			} // end switch
		}catch(e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			if(sheetObjects[i].id.substring(0,2) == "sheet2" ){
				DLCSheets[DLCSheetCnt++] = sheetObjects[i];
			}
		}

		initCombo();
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		ComBtnDisable("btn_W/O_Send");
		MnrWaitControl(false);

		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S]
//		document.getElementById("installForm").style.display = "none";
//		document.getElementById("removalForm").style.display = "none";
//		ComBtnDisable("btn_loadExcel");
		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E]
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

	/**
	 * IBUpload Object를 초기화
	 * @param uploadObj
	 * @param uploadNo
	 * @return
	 */
	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}

	/**
	 * 멀티 콤보형식 초기화
	 * @return
	 */
	function initCombo() {
		var formObject = document.form
		with (formObject.combo_vndr_seq) {

			MultiSeparator = "|";
			SetTitle("S/P Name|S/P Code|AGMT No|Office Code|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code");
			SetColAlign("left|left|center|center|left|center|left|left|left");
			SetColWidth("180|70|75|85|70|148|110|135|0");
			DropHeight = 160;
		}

		with (formObject.combo_cost_cd) {
			MultiSeparator = "|";

			SetColAlign("left");
			SetColWidth("180");
			DropHeight = 160;
		}

		with (formObject.combo_eq_knd_cd) {
			MultiSeparator = "|";
			SetTitle("Code|Name");

			SetColAlign("left|left");
			SetColWidth("90|180");
			DropHeight = 160;

			Enable = false;
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
		case 1:      // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 200;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				var HeadTitle1 = "|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Unit Price| Q'ty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Amount|Hanger Offer INFO|Remark(s)"
					+ "|bzc_amt|file_seq|cost_cd|mnr_rt_tp_cd|eq_no_check_yn|recent_rpr_qty|mnr_hngr_flg_yd_cd|mnr_hngr_rck_cd|mnr_hngr_flg_dt|eq_tpsz_cd|eq_knd_cd|mnr_org_hngr_bar_tp_cd";
				var HeadTitle2 = "|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Unit Price| Q'ty|Sound         |Repairable    |Missing    |Disposal   |Amount|Hanger Offer INFO|Remark(s)"
					+ "|bzc_amt|file_seq|cost_cd|mnr_rt_tp_cd|eq_no_check_yn|recent_rpr_qty|mnr_hngr_flg_yd_cd|mnr_hngr_rck_cd|mnr_hngr_flg_dt|eq_tpsz_cd|eq_knd_cd|mnr_org_hngr_bar_tp_cd";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//	InitHeadMode(true, true, true, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]dtSeq
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "sheet1_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+	"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,   true,           "del_chk",              	false,	"",		dfNone,		0, 	true,	true);
				InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,		    "Seq");
				InitDataProperty(0, cnt++ , dtCombo,		260,	daLeft,		true,	prefix+	"cost_dtl_cd",	        	false,	"",		dfNone,		0,  true,	true);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+	"eq_no",					false,	"",		dfNone,		0,	true,	true, 11);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+	"mnr_expn_dtl_nm",			false,	"",		dfNone,		0,	true,	true, 100);
				InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	prefix+	"mnr_hngr_bar_tp_cd",		false,	"",		dfNone,		0,  true,	true);
				InitDataProperty(0, cnt++ , dtCombo,		140,	daLeft,		true,	prefix+	"mnr_hngr_trf_cd",			false,	"",		dfNone,		0,  true,	true);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	prefix+	"mnr_hngr_trf_otr_desc",	false,	"",		dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,	prefix+	"spr_prt_uc_amt",			false,	"",		dfFloat,	2,	true,	true, 13);
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+	"rpr_qty",			    	false,	"",		dfInteger,	0,	true,	true, 6);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+	"act_invt_qty",			    false,	"",		dfInteger,	0,	true,	true, 6);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+	"mnr_hngr_dmg_qty",			false,	"",		dfInteger,	0,	true,	true, 6);
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+	"mnr_lost_hngr_qty",		false,	"",		dfInteger,	0,	true,	true, 6);
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+	"mnr_disp_hngr_qty",		false,	"",		dfInteger,	0,	true,	true, 6);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,	prefix+	"cost_amt",					false,	"",		dfFloat,	2,	true,	true, 13);
				InitDataProperty(0, cnt++ , dtPopup,		110,	daLeft,  	true,   prefix+ "mnr_hngr_dtl_offr_desc",   false,  "",     dfNone,     0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,			195,	daLeft,		true,	prefix+	"ord_dtl_rmk",	        	false,	"",		dfNone,		0,	true,	true, 4000);

				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"bzc_amt",	            	false,	"",		dfFloat,	2,	true,	true, 13);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"file_seq",	            	false,	"",		dfFloat,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"cost_cd",	            	false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"mnr_rt_tp_cd",	        	false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"eq_no_check_yn",			false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"recent_rpr_qty",			false,	"",		dfNone,		0,	true,	true, 13);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"mnr_hngr_flg_yd_cd",		false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"mnr_hngr_rck_cd",			false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"mnr_hngr_flg_dt",			false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"eq_tpsz_cd",				false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"eq_knd_cd",				false,	"",		dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+	"mnr_org_hngr_bar_tp_cd",	false,	"",		dfNone,		0,  true,	true);

				InitDataValid(   0,	prefix+	"eq_no",  			    vtEngUpOther, 	"0123456789");

				PopupImage  =  "/hanjin/img/btns_search.gif";
				ShowButtonImage = 2;

				SelectHighLight = false;

				CountPosition = 0;
			}
			break;

		case 2:      // sheet2 init
			with(sheetObj) {
				// 높이 설정
				var prefix = "";

				style.height = 122;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 10, 100);

				var HeadTitle1 = "|Evidence Attachment|Evidence Attachment|Evidence Attachment";
				var HeadTitle2 = "|Seq.|File|Download";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 prefix + "del_chk")
				InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  	false,   prefix + "org_file_nm",	true,	"",      dfNone,	0,     false,	true,	50);
				InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,   prefix + "file_dw",   		false,	"",      dfNone,	0,     false,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,   prefix + "file_path_nm",	false,	"",      dfNone,	0,     true,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,   prefix + "file_path",   	false,	"",      dfNone,	0,     true,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_seq",		false,	"",      dfNone,	0,     true,	true);
				InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	 prefix + "file_dtl_seq",	false,	"",		 dfNone,	0,	   false,	false);

				CountPosition = 0;

				ImageList(0)= "/hanjin/img/ico_attach.gif";
				ShowButtonImage = 1;
			}
			break;

		case 3:      // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host 정보 설정 [필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				var HeadTitle1 = "MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
					+ "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
					+ "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
					+ "|FILE_SEQ|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
				var headCount = ComCountHeadTitle(HeadTitle1);

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "sheet3_";
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_ofc_cty_cd",	false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_seq",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"eq_knd_cd",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_grp_tp_cd",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wo_tp_cd",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_cd",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"trsm_mod_cd",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ofc_cty_cd",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_seq",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ver_no",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"curr_cd",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_agmt_amt",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wrk_amt",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"inv_amt",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_iss_ofc_cd",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_snd_dt",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_ofc_cd",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vndr_seq",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_tp_cd",	false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vsl_cd",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_voy_no",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_dir_cd",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_brth_dt",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_yd_cd",	false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_dt",		false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_hdr_rmk",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"file_seq",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_inp_dt",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_usr_id",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_dt",				false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_usr_id",			false,	"",		dfNone,		0,	true,true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_dt",				false,	"",		dfNone,		0,	true,true);

//				SelectionMode   = smSelectionRow;
//				SelectHighLight = true;
//				SelectFontBold  = false;
//				SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
//
//				CountPosition = 0;
			}
			break;
		}
	}

	/**
     * Sheet 관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		case IBCLEAR:
			doIBCLEAR(sheetObj, formObj, sAction);
			break;

		case IBSEARCH:      //조회
			var isSearchOk = true;
			if(sheetObj.IsDataModified == true){
				if(!ComShowCodeConfirm("MNR00007"))
				{
					isSearchOk = false;
				}
			}

			if(isSearchOk){
				if(checkWorkOrderNo(sheetObj, formObj, sAction))
				{
					doIBSEARCH(sheetObj, formObj, sAction);
				}
			}
			break;

		case IBSAVE:        //저장
			doIBSAVE(sheetObj, formObj, sAction);
			break;

		case COMMAND01:     //W/O Doc Send
			var strMnrOrdSeq = formObj.mnr_ord_seq.value;

			if(strMnrOrdSeq != "" && strMnrOrdSeq != "NEW" )
			{
				ComOpenPopup("EES_MNR_0036.do?wo_no="+strMnrOrdSeq, 900, 600, 'setDocSendParam', '0,1', true);
			}
			break;

		case IBSEARCHAPPEND:        //삭제
			doIBREMOVE(sheetObj, formObj, sAction);
			break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with (formObj) {
			if (!ComChkObjValid(formObj)) {
				return false;
			}
		}
		return true;
	}

/* ********* Event Functions Start ************* */
	/**
	 * COMBO 변경 이벤트(Agreement No 변경시 발생하는 이벤트)
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	function combo_vndr_seq_OnChange(indexCode, Text){
		var formObj = document.form;
		var strEtc =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  8 );
		var spltEtc =strEtc.split("^");
		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.curr_cd.value =  spltEtc[0];

		var strAgmtNo =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  2 );
		if(strAgmtNo.length > 3)
		{
			formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3);
			formObj.agmt_seq.value=strAgmtNo.substring(3);
		}

		var strAgmtVerNo=spltEtc[1];
		if ( ComIsNumber(strAgmtVerNo))
		{
			formObj.agmt_ver_no.value = strAgmtVerNo;
		}
		var arr = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  5 ).split("~");
		var tmpEffFrom = "";
		var tmpEffTo   = "";

		if(arr==""){
			tmpEffFrom = "";
			tmpEffTo   = "";
		}else{
			tmpEffFrom = arr[0];
			tmpEffTo   = arr[1];
		}

		formObj.eff_dt.value = tmpEffFrom.trim();
		formObj.exp_dt.value = tmpEffTo.trim();
		formObj.combo_eq_knd_cd.Code2 =  spltEtc[2];
		combo_cost_cd_Initialize(formObj.combo_eq_knd_cd.Code);
		
		/* 
		 * combo_cost_cd_Initialize -> combo_cost_cd_OnChange -> sheet1_cost_dtl_cd_Initialize -> sheetObjects[0].RemoveAll()
		 * 로직 흐름으로 인해 절대 들어갈 수 없음
		 * 
		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
			// msgs['MNR00080'] = 'Cost code and cost detail code are unmatched. Do you still want to initialize it ?';
			if(ComShowCodeConfirm("MNR00080")){
				sheet1_cost_dtl_cd_Initialize(Text);
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}else{
				formObj.combo_cost_cd.Code2 = OrgCostType;
				if(formObj.combo_cost_cd.Code==""){  //이전에 다른 EQ Type의 데이터가 있을때
					sheet1_cost_dtl_cd_Initialize(Text);
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
				}
			}
		}
		*/
		
		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S]
		//U	Container
		spltEtc[2] == "U" ? ComBtnEnable("btn_loadExcel"):ComBtnDisable("btn_loadExcel");
		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E]

		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}

	/**
	 * COMBO 변경 이벤트
	 * Cost Type 변경시 Sheet 의 컬럼 Display 설정
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	function combo_cost_cd_OnChange(indexCode, Text){
		setSheetColumnDisplay(Text);  //Cost Type 콤보값에 따라 Sheet 의 컬럼 Display 설정
		var cnt = 10;
		//행거바 설치용 자리수 변경 3자리로 협의
		if(Text == 'MRDRHA' || Text == 'MRDRHD'){
			sheetObjects[0].InitDataProperty(0, cnt++ , dtData,	120,daRight,	true,	"sheet1_rpr_qty",			false,	"",		dfInteger,	0,	true,	true, 3);
			sheetObjects[0].InitDataProperty(0, cnt++ ,	dtData,	80,	daRight,	true,	"sheet1_act_invt_qty",		false,	"",		dfInteger,	0,	true,	true, 3);
			sheetObjects[0].InitDataProperty(0, cnt++ , dtData,	80,	daRight,	true,	"sheet1_mnr_hngr_dmg_qty",	false,	"",		dfInteger,	0,	true,	true, 3);
			sheetObjects[0].InitDataProperty(0, cnt++ ,	dtData,	70,	daRight,	true,	"sheet1_mnr_lost_hngr_qty",	false,	"",		dfInteger,	0,	true,	true, 3);
			sheetObjects[0].InitDataProperty(0, cnt++, 	dtData,	70,	daRight,	true,	"sheet1_mnr_disp_hngr_qty",	false,	"",		dfInteger,	0,	true,	true, 3);
		} else {
			sheetObjects[0].InitDataProperty(0, cnt++ , dtData,	60,	daRight,	true,	"sheet1_rpr_qty",			false,	"",		dfInteger,	0,	true,	true, 6);
			sheetObjects[0].InitDataProperty(0, cnt++ ,	dtData,	80,	daRight,	true,	"sheet1_act_invt_qty",		false,	"",		dfInteger,	0,	true,	true, 6);
			sheetObjects[0].InitDataProperty(0, cnt++ , dtData,	80,	daRight,	true,	"sheet1_mnr_hngr_dmg_qty",	false,	"",		dfInteger,	0,	true,	true, 6);
			sheetObjects[0].InitDataProperty(0, cnt++ ,	dtData,	70,	daRight,	true,	"sheet1_mnr_lost_hngr_qty",	false,	"",		dfInteger,	0,	true,	true, 6);
			sheetObjects[0].InitDataProperty(0, cnt++, 	dtData,	70,	daRight,	true,	"sheet1_mnr_disp_hngr_qty",	false,	"",		dfInteger,	0,	true,	true, 6);
		}

		var formObj = document.form;
		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheet1_cost_dtl_cd_Initialize(Text);
				sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}
		} else {
			sheet1_cost_dtl_cd_Initialize(Text);
			sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
		}



		OrgCostType = formObj.combo_cost_cd.Code;
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");

		costCdSubstr = formObj.combo_cost_cd.Code;
		if(costCdSubstr.length >= 5){
			costCdSubstr = costCdSubstr.substr(0,5);
		}

		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S]
		if(costCdSubstr == 'MRDRH' ){
			ComBtnEnable("btn_loadExcel");
		}else{
			ComBtnDisable("btn_loadExcel");
		}
		// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E]
	}

   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount > 0){
			var sDate = ComGetNowInfo("ymd");
			var formObj = document.form;

			for(i = sheetObj.LastRow-1 ; i >= sheetObj.HeaderRows ; i--){
				if(sheetObj.CellValue(i,"sheet1_mnr_hngr_rck_cd")=="O"){
					sheetObj.CellEditable(i, "sheet1_cost_dtl_cd") = false;
					sheetObj.CellValue2(i,"sheet1_mnr_hngr_bar_tp_cd")="S";
					sheetObj.CellEditable(i, "sheet1_mnr_hngr_bar_tp_cd") = false;
				} else {
					sheetObj.CellEditable(i, "sheet1_cost_dtl_cd") = true;
					sheetObj.CellEditable(i, "sheet1_mnr_hngr_bar_tp_cd") = true;
				}

				sheetObj.CellValue2(i,"sheet1_mnr_hngr_flg_dt")=sDate;
				sheetObj.CellValue2(i,"sheet1_eq_knd_cd")=formObj.combo_eq_knd_cd.Code;
			}
		}
    }

	/**
	 * 저장후 결과메세지 표시
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") {
				if(strMnrOrdSeq == "" || strMnrOrdSeq == "NEW" )
				{
					ComShowCodeMessage("MNR00073");
				} else {
					ComShowCodeMessage("MNR00222");
				}
			} else {
				ComShowCodeMessage("MNR00074",ErrMsg);
			}
		} else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "") {
				ComShowCodeMessage("MNR00082",ErrMsg);
			} else {
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
	}

	/**
	 * Sheet1 의 Cell 값 변경시 발생하는 이벤트
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad == 0){

			var formObj = document.form;
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");

			// sheet1_cost_dtl_cd = Extra Expense Type
			if(sheetObj.ColSaveName(Col) == "sheet1_cost_dtl_cd"){
				sheetObj.CellValue2(Row,"sheet1_mnr_rt_tp_cd") = Value;
				sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value);

				// M1 | Hanger Bar(Square) Purchasing(511511)
				// MD | Hanger Bar(Round) Purchasing(511511)
				if(Value == "M1" || Value == "MD"){
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_dtl_offr_desc") = true;
				} else {
					sheetObj.CellValue2(Row,"sheet1_mnr_hngr_dtl_offr_desc") = "";
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_dtl_offr_desc") = false;
				}

				// RD | Bar Removal  on Permanent Hanger Rack
				// BD | Rack & Bar Removal on Temporary Hanger Rack
				// ED | Bar Removal Only on Temporary Hanger Rack
				if(Value == "RD" || Value == "BD" || Value == "ED"){
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = false;
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = false;
					sheetObj.CellEditable(Row,"sheet1_rpr_qty") = false;
				} else {
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = true;
					sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = true;
					sheetObj.CellEditable(Row,"sheet1_rpr_qty") = true;
				}
			}
			// sheet1_rpr_qty = Installation Bar Qty, "MRDRH" means Installation or Removal
			else if(sheetObj.ColSaveName(Col) == "sheet1_rpr_qty" && costCdSubstr !="MRDRH"){
				if(sheetObj.CellValue(Row,"sheet1_cost_dtl_cd") == "M1" || sheetObj.CellValue(Row,"sheet1_cost_dtl_cd") == "MD"){
					sheetObj.CellValue2(Row,"sheet1_mnr_hngr_dtl_offr_desc") = "";
				}
				doCalculate(sheetObj, Row, Col, Value);
			}
			// sheet1_spr_prt_uc_amt = Unit Price 
			else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_uc_amt" && costCdSubstr !="MRDRH"){
				doCalculate(sheetObj, Row, Col, Value);
			}
			// sheet1_eq_no = EQ No. 
			else if(sheetObj.ColSaveName(Col) == "sheet1_eq_no" && costCdSubstr != "MRDRH"){

				var checkEqn = sheetObjects[0].CellValue(Row,"sheet1_eq_no");

				if(checkEqn == ""){
					return;
				} else {
					sheetObjects[0].CellValue2(Row,"sheet1_eq_no")=checkEqn.toUpperCase();
					checkEqn=checkEqn.toUpperCase();

					var sEqType = formObj.combo_eq_knd_cd.Code;
					var sEqNo  = checkEqn;
					var sDate = ComGetNowInfo("ymd");
					var sCostType = "";
					if(formObj.combo_eq_knd_cd.Code == "U"){
						sCostType = "MRDRRC";
					} else if(formObj.combo_eq_knd_cd.Code == "G"){
						sCostType = "MRGSRC";
					} else {
						sCostType = "MRZSRC";
					}

					var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sDate,sCostType);
					var retArr =  MnrXmlToArray(sXml);
					if(retArr == null){
						ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
						sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
						sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
						return;
					}
				}

			} else if(sheetObj.ColSaveName(Col) == "sheet1_eq_no" && costCdSubstr == "MRDRH"){
				var checkEqn = sheetObjects[0].CellValue(Row,"sheet1_eq_no");

				if(checkEqn == ""){
					return;
				} else {
					sheetObjects[0].CellValue2(Row,"sheet1_eq_no")=checkEqn.toUpperCase();
					checkEqn=checkEqn.toUpperCase();

					var sEqType = formObj.combo_eq_knd_cd.Code;
					var sEqNo  = checkEqn;
					var sDate = ComGetNowInfo("ymd");
					var sCostType = "";
					if(formObj.combo_eq_knd_cd.Code == "U"){
						sCostType = "MRDRRC";
					} else if(formObj.combo_eq_knd_cd.Code == "G"){
						sCostType = "MRGSRC";
					} else {
						sCostType = "MRZSRC";
					}

					var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sDate,sCostType);
					var retArr =  MnrXmlToArray(sXml);
					var mnr_hngr_bar_tp_cd="";
					var rpr_qty="";
					var recent_rpr_qty="";
					var mnr_hngr_rck_cd="";
					//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
					//|33 total_loss_date|34 rpr_cost_amt|35 dpp_amt|36 mnr_hngr_trf_cd|37 mnr_hngr_trf_otr_desc|38 act_invt_qty|39 mnr_hngr_dmg_qty|40 mnr_lost_hngr_qty|41 mnr_disp_hngr_qty
					if(retArr != null){
						if(costCdSubstr == "MRDRH" ){
							if(retArr[0][17]==""){ // hngr_rck_cd
								mnr_hngr_rck_cd="R";
							} else {
								mnr_hngr_rck_cd=retArr[0][17];
							}

							if(retArr[0][24]==""){ // bar_tp_cd
								mnr_hngr_bar_tp_cd="S";
							} else {
								mnr_hngr_bar_tp_cd=retArr[0][24];
							}

							rpr_qty = "0";		//일단 보류
							recent_rpr_qty = retArr[0][22]; // bar_atch_knt

							//선행 체크 작업 Perment가 아니라면 중복 설치 중복 제거는 되지 않는다.
							if(formObj.combo_cost_cd.Code=="MRDRHA"){
								if(retArr[0][22] != "0"){ // bar_atch_knt
									// msgs['MNR00354'] = '{?msg1} Hanger bar was already Installed,Please remove first';
									ComShowCodeMessage("MNR00354",checkEqn);
									sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return;
								}
							} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
								if(retArr[0][22] == "0"){ // bar_atch_knt
									// msgs['MNR00355'] = '{?msg1} Hanger bar was already Removed,Please install first';
									ComShowCodeMessage("MNR00355",checkEqn);
									sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return;
								}
							}

							var costDtlCd = sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd");

							if(mnr_hngr_rck_cd=="O"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="RA";
								}else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="RD";
								}
								//Perment는 Square
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_bar_tp_cd")="S";
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = false;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = false;
							} else if(mnr_hngr_rck_cd=="R"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="BA";
								} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="BD";
								}
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							} else if(mnr_hngr_rck_cd=="D"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="EA";
								} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="ED";
								}
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							} else {
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							}

							if(formObj.combo_cost_cd.Code=="MRDRHA"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")=="RA"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="BA";
									} else {
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="EA";
									}
								}

								sheetObjects[0].CellValue2(Row,"sheet1_rpr_qty") = rpr_qty;
							} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")=="RD"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="BD";
									} else {
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="ED";
									}
								}

								sheetObjects[0].CellValue2(Row,"sheet1_rpr_qty") = recent_rpr_qty;
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_trf_cd") = retArr[0][36];
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_trf_otr_desc") = retArr[0][37];

							}
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_flg_yd_cd")=retArr[0][18];
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_rck_cd")=mnr_hngr_rck_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_eq_tpsz_cd")=retArr[0][31];
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_bar_tp_cd")=mnr_hngr_bar_tp_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_org_hngr_bar_tp_cd")=mnr_hngr_bar_tp_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_recent_rpr_qty")=recent_rpr_qty;
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_flg_dt")=sDate;
							sheetObjects[0].CellValue2(Row,"sheet1_eq_knd_cd")=formObj.combo_eq_knd_cd.Code;

							if(sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "RD" || sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "BD" || sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "ED"){
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = false;
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = false;
								sheetObj.CellEditable(Row,"sheet1_rpr_qty") = false;
							} else {
								if(mnr_hngr_rck_cd!="O"){
									sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = true;
								}
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = true;
								sheetObj.CellEditable(Row,"sheet1_rpr_qty") = true;
							}
						}
					} else {
						// msgs['MNR00165'] = '{?msg1} doesn\'t exist, Please check again.';
						ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
						sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
						sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
						return;
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_mnr_hngr_trf_cd"){
				if(Value == "OT"){
					sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_trf_otr_desc") = true;
				} else {
					sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_trf_otr_desc") = false;
					sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_trf_otr_desc") = "";
				}
			}

		}
	}

	/**
	 * Sheet1 의 Extra Expense Type 값 변경시 발생하는 이벤트
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value){

		var formObj = document.form;
		// Combo Cost Type : "Hanger Rack/Bar Installation" or "Hanger Rack/Bar Removal"
		if(formObj.combo_cost_cd.Code=="MRDRHA" || formObj.combo_cost_cd.Code=="MRDRHD"){
			// Combo Cost Type : "Hanger Rack/Bar Installation"
			if(formObj.combo_cost_cd.Code=="MRDRHA"){
				if(sheetObj.CellValue(Row,  "sheet1_mnr_hngr_rck_cd")!="O" && Value=="RA" && sheetObj.CellValue(Row,  "sheet1_eq_no")!=""){
					// msgs['MNR00331'] = 'Cannot select Permanent Hanger Rack_Single';
					ComShowCodeMessage("MNR00331");
					if(sheetObj.CellValue(Row,  "sheet1_mnr_hngr_rck_cd")=="R"){
						sheetObj.CellValue2(Row,"sheet1_cost_dtl_cd")="BA";		// BA | Temporary Hanger Single Rack & Bar Installation
					}else{
						sheetObj.CellValue2(Row,"sheet1_cost_dtl_cd")="EA";		// EA | Temporary Hanger Double Rack & Bar Installation
					}
				}
			}else if(formObj.combo_cost_cd.Code=="MRDRHD"){
				if(sheetObj.CellValue(Row,  "sheet1_mnr_hngr_rck_cd")!="O" && Value=="RD" && sheetObj.CellValue(Row,  "sheet1_eq_no")!=""){
					// msgs['MNR00331'] = 'Cannot select Permanent Hanger Rack_Single';
					ComShowCodeMessage("MNR00331");
					if(sheetObj.CellValue(Row,  "sheet1_mnr_hngr_rck_cd")=="R"){
						sheetObj.CellValue2(Row,"sheet1_cost_dtl_cd")="BD";		// BD |  Rack & Bar Removal on Temporary Hanger Rack
					}else{
						sheetObj.CellValue2(Row,"sheet1_cost_dtl_cd")="ED";		// ED |  Bar Removal Only on Temporary Hanger Rack
					}
				}
			}
		} else {
			MnrWaitControl(true);
			nowLoad = 1;
			formObj.f_cmd.value = SEARCH01;
			var sParam = "";
			var aryPrefix = new Array("sheet1_");

			sParam += ComGetPrefixParam(aryPrefix)
			+ "&f_cmd=101"
			+ "&ibflag=X"
			+ "&del_chk=0"
			+ "&cost_dtl_cd="+ sheetObj.CellValue(Row, Col)
			+ "&agmt_ofc_cty_cd="+ (formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 2 )).substring(0, 3)
			+ "&cost_cd="+ formObj.combo_cost_cd.Code
			+ "&mnr_rt_tp_cd="+ sheetObj.CellValue(Row, Col)
			+ "&agmt_seq=" + formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 2 ).substring(3)
			+ "&agmt_ver_no=" + formObj.agmt_ver_no.value;

			var sXml   = sheetObj.GetSearchXml("EES_MNR_0058GS.do", sParam);
			var comboLst = getDataString(sXml, "sheet1_rpr_qty", "sheet1_agmt_rt_amt");

			if (typeof(comboLst)== "undefined" )
			{
				//sheetObjects[0].CellValue(Row, "sheet1_eq_no") = "";
				sheetObjects[0].CellValue(Row, "sheet1_bzc_amt") = "";
				sheetObjects[0].CellValue(Row, "sheet1_rpr_qty") = "1";
				sheetObjects[0].CellValue(Row, "sheet1_spr_prt_uc_amt") = "";
				sheetObjects[0].CellValue(Row, "sheet1_cost_amt") = "";
				MnrWaitControl(false);
				ComBtnDisable("btn_W/O_Send");
				nowLoad = 0;
				return;
			}

			if (comboLst != null)
			{
				var rprqty = comboLst.substring(0, comboLst.indexOf('|'));
				var amt = comboLst.substring(comboLst.indexOf('|') + 1);

				if((rprqty <= 0)||(amt <= 0)){
					nowLoad = 0;
					MnrWaitControl(false);
					ComBtnDisable("btn_W/O_Send");
					return;
				}else{
					var bzcAmt = parseFloat(amt)/parseFloat(rprqty);
					sheetObjects[0].CellValue(Row, "sheet1_eq_no") = "";
					sheetObjects[0].CellValue(Row, "sheet1_bzc_amt") = bzcAmt;
					sheetObjects[0].CellValue(Row, "sheet1_rpr_qty") = "1";
					sheetObjects[0].CellValue(Row, "sheet1_spr_prt_uc_amt") = bzcAmt;
					sheetObjects[0].CellValue(Row, "sheet1_cost_amt") = bzcAmt*1;
				}
			}
			nowLoad = 0;
			MnrWaitControl(false);
		}
		ComBtnDisable("btn_W/O_Send");
	}

	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "sheet1_mnr_hngr_dtl_offr_desc") return;
		if(sheetObj.CellValue(Row, "sheet1_rpr_qty") == "0") return;


		var strCostDtlCD = ComTrimAll(sheetObj.CellValue(Row, "sheet1_cost_dtl_cd")," ");

		if(strCostDtlCD == "M1" || strCostDtlCD == "MD")
		{
			var param ='?rpr_qty=' + sheetObj.CellValue(Row, "sheet1_rpr_qty") + '&';
			param += 'sheet_id=' + '0' + '&';
			param += 'presetData=' +  sheetObj.CellValue(Row, "sheet1_mnr_hngr_dtl_offr_desc") + '&';
			param += 'targetRow=' +  Row;

			ComOpenPopup('EES_MNR_OFCINFOMULTI.do' + param, 400, 440, 'getMnr_ofcInfoMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
		}
    }

	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";

		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;

		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;

		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}

	/**
	 * 파일 선택하기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		var formObj = document.form;
		var upObj = uploadObjects[0];
		var prefix = "";

		var fileName = sheetObj.OpenFileDialog("파일선택");
		if(fileName.indexOf("\\") !=-1) {
			formObj.f_gubuns.value = "DTL";
			sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;
			upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
			var ret = upObj.AddFile(fileName);
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, Col)= fileName;
			sheetObj.CellValue2(Row, prefix+ "file_dw")= '1';
			var file_seq = sheetObj.CellValue(Row, prefix+ "file_seq");
			var file_dtl_seq = sheetObj.CellValue(Row, prefix+ "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting
			if(file_seq != "" && uploadFileSeq != "") ibflag='U';

			if(uploadFileSeq != "") {
				file_seq = uploadFileSeq;
			}

			var sParam = "f_cmd="+COMMAND01;
			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경

			upObj.ExtendParam = sParam;

			var sXml = upObj.DoUpload(true);

			uploadFileSeq = ComGetEtcData(sXml,"seqValue");

			if(uploadFileSeq != "" && uploadFileSeq != undefined){
				var fileXml = SearchFileUpload(sheetObj,uploadFileSeq);
				sheetObj.LoadSearchXml(fileXml);
				var sheet1_file_seq=formObj.file_seq.value;

				if( sheet1_file_seq == "0" || sheet1_file_seq == "" || uploadFileSeq == sheet1_file_seq ){
					formObj.file_seq.value=uploadFileSeq;
					ComBtnDisable("btn_W/O_Send");
				}else{
					ComBtnDisable("btn_W/O_Creation");
				}
			}else{
				ComBtnDisable("btn_W/O_Send");
			}

		}else{
			sheetObj.RowDelete(sheetObj.SelectRow,false);
		}

		formObj.f_gubuns.value = "";
	}

	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	function sheet3_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet3_";
		if(sheetObj.RowCount <= 0)
		{
			nowLoad = 0;
			doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComShowCodeMessage("MNR00005", "W/O No.");

			ComSetFocus(formObj.mnr_ord_seq);
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Send");
			return false;
		}

		formObj.combo_vndr_seq.UseCode = false;
		var agree_no = sheetObjects[2].CellValue(1, prefix+ "agmt_ofc_cty_cd")
		               + ComLpad(sheetObjects[2].CellValue(1, prefix+ "agmt_seq"),6,"0");
		formObj.combo_vndr_seq.Index = formObj.combo_vndr_seq.FindIndex(agree_no,2);
		formObj.combo_vndr_seq.UseCode = true;

		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.combo_eq_knd_cd.Code2 = sheetObjects[2].CellValue(1, prefix+ "eq_knd_cd");
		formObj.curr_cd.value   = sheetObjects[2].CellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[2].CellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[2].CellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[2].CellValue(1, prefix+ "agmt_ver_no");
		formObj.file_seq.value=sheetObjects[2].CellValue(1, prefix+ "file_seq");
		formObj.showDate.value=sheetObjects[2].CellValue(1, prefix+ "cre_dt");

		var costcd = sheetObjects[2].CellValue(1, prefix+ "cost_cd");

		combo_cost_cd_Initialize(formObj.combo_eq_knd_cd.Code);
		formObj.combo_cost_cd.Code = costcd;
		formObj.ord_hdr_rmk.value=sheetObjects[2].CellValue(1, prefix+ "ord_hdr_rmk");

		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
			if(i>0)break;
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}
		var prefix = "sheet1_";
		var ArrCostDtlDesc=costDtlDesc.split("|");
		var ArrMnrHngrBarTpCdDesc=mnrHngrBarTpDesc.split("|");
		for(var i=sheetObjects[0].HeaderRows;i<=sheetObjects[0].RowCount;i++)
		{
			var idx   = sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
			var idx2   = sheetObjects[0].GetComboInfo(i, prefix+ "mnr_hngr_bar_tp_cd", "SelectedIndex");
			sheetObjects[0].CellText(i, prefix+ "cost_dtl_cd")=ArrCostDtlDesc[idx];
			sheetObjects[0].CellText(i, prefix+ "mnr_hngr_bar_tp_cd")=ArrMnrHngrBarTpCdDesc[idx2];
		}
		var fileSeq = formObj.file_seq.value;
		if(fileSeq != "" || fileSeq != undefined){
			var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
			sheetObjects[1].LoadSearchXml(fileXml);
		}

		nowLoad = 0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
	}

/* ********* Event Functions End ************* */



/* ********* User Functions ************* */
	/**
	 * 콤보 값조회(Agreement No) 초기화
	 * @return
	 */
	function combo_vndr_seq_Initialize(){
		var formObj = document.form;
		var sXml = MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult = MnrXmlToArray(sXml);

		if(arrResult != null){
			for(var i = 0; i < arrResult.length;i ++){
				var tempComboText = arrResult[i][8]       //8 vndr_nm|
				                 + "|" + arrResult[i][1]  //1 vndr_seq|
				                 + "|" + arrResult[i][9]  //9 agmt_no|
				     			 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   //3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
				                 + "|" + arrResult[i][2] //2 agmt_ref_no|
				                 + "|" + arrResult[i][25]   //25 trf_no|
				                 + "|" + arrResult[i][14] //14 curr_cd|
				                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
	                             + "^" + arrResult[i][28]   //28eq_knd_cd|
				                  ;

				formObj.combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]);
			}
		} else {
			ComShowCodeMessage("MNR00056");
		}
		formObj.combo_vndr_seq.Code="";
	}

	/**
	 * 콤보 값조회 초기화 (Cost Type)
	 *
	 * Cost Type Combo Setting
	 * MRDRHA|Hanger Rack/Bar Installation
	 * MRDRHD|Hanger Rack/Bar Removal
	 * MRDROT|Other
	 * MRRUSP|Reefer Spare Part Purchase
	 *
	 * @param eqtype
	 * @return
	 */
	function combo_cost_cd_Initialize(eqtype){
		var formObj = document.form;
		formObj.combo_cost_cd.Code2="-1";
		formObj.combo_cost_cd.RemoveAll();
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",eqtype, "CUSTOM6") //Cost Type
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{
					var tempText = comboList[i][j].split("|");

					if(i==0)
					{
						if(tempText[0]=="MRRFPM"){  //PM
							// PUSSC, 2014-04-21, YONGCHAN SHIN
							if(currOfcCd=="PUSBO" || currOfcCd =="PUSSC" || currOfcCd =="SELSC"){
								formObj.combo_cost_cd.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}else{
							formObj.combo_cost_cd.InsertItem(j, tempText[1] ,tempText[0]);
						}
					}
				}
				if(i==0)
				{
					formObj.combo_cost_cd.DeleteItem("MRRUSP");  //MRRUSP일때 안보여지게
				}

			}
		}
		formObj.combo_cost_cd.Code = OrgCostType;
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}

	/**
	 * Sheet 의 콤보값조회 초기화 (Extra Expense Type Sheet Combo)
	 * @param costtype
	 * @return
	 */
	function sheet1_cost_dtl_cd_Initialize(costtype){

		if(nowLoad==0)
		{
			sheetObjects[0].RemoveAll();
			sheetObjects[0].InitDataCombo(0, "sheet1_cost_dtl_cd", "", "", "" );
			sheetObjects[0].Editable = true;
		}


		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		costDtlCode = "";
		costDtlDesc = "";
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{
					var tempText = comboList[i][j].split("|");

					if(i==0)
					{											
						if(formObj.combo_eq_knd_cd.Code == "U"){
							if(tempText[0]=="MC"){  //VSL reefer monitoring
								// ADD PUSSC, 2014-04-21, YONGCHAN SHIN
								if(currOfcCd=="PUSBO" || currOfcCd =="PUSSC"|| currOfcCd =="SELSC"){
									costDtlCode = costDtlCode + tempText[0] + "|";
									costDtlDesc = costDtlDesc + tempText[1] + "|";
								}
							}else if(tempText[0]=="M7"){  //COA Fee
								if(currOfcCd=="SELCON"){
									costDtlCode = costDtlCode + tempText[0] + "|";
									costDtlDesc = costDtlDesc + tempText[1] + "|";
								}
							}else if(tempText[0]=="MF"){ //New CNTR Survey for Reefer
								if(currOfcCd=="SELCON" || currOfcCd=="SELPPS"){
									costDtlCode = costDtlCode + tempText[0] + "|";
									costDtlDesc = costDtlDesc + tempText[1] + "|";
								}
							}else if(tempText[0]=="ME"){  //Management fee (511511)
								//2013-06-25 Jonghee HAN "ME" Expense Cost Type using allow to SYDSC
								if(currOfcCd=="SELSC" || currOfcCd =="SYDSC"){
									costDtlCode = costDtlCode + tempText[0] + "|";
									costDtlDesc = costDtlDesc + tempText[1] + "|";
								}
							}else{
								costDtlCode = costDtlCode + tempText[0] + "|";
								costDtlDesc = costDtlDesc + tempText[1] + "|";
							}
						}else{
							costDtlCode = costDtlCode + tempText[0] + "|";
							costDtlDesc = costDtlDesc + tempText[1] + "|";
						}
					}
				}
				if(i==0)
				{
					costDtlCode = costDtlCode.substring(0, costDtlCode.length - 1);
					costDtlDesc = costDtlDesc.substring(0, costDtlDesc.length - 1);
					sheetObjects[0].InitDataCombo(0, "sheet1_cost_dtl_cd", costDtlDesc, costDtlCode, costDtlCode.substring(0,costDtlCode.indexOf("|")) );
				}
			}

		}
	}

	/**
	 * Sheet 의 콤보값조회 초기화 {MNR_HNGR_BAR_TP_CD Sheet Combo}
	 * @param costtype
	 * @return
	 */
	function sheet1_mnr_hngr_bar_tp_cd_Initialize(costtype){
		if(nowLoad==0)sheetObjects[0].RemoveAll();

		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		mnrHngrBarTpCode = "";
		mnrHngrBarTpDesc = "";
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{
					var tempText = comboList[i][j].split("|");

					if(i==0)
					{
						mnrHngrBarTpCode = mnrHngrBarTpCode + tempText[0] + "|";
						mnrHngrBarTpDesc = mnrHngrBarTpDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					mnrHngrBarTpCode = mnrHngrBarTpCode.substring(0, mnrHngrBarTpCode.length - 1);
					mnrHngrBarTpDesc = mnrHngrBarTpDesc.substring(0, mnrHngrBarTpDesc.length - 1);
					sheetObjects[0].InitDataCombo(0, "sheet1_mnr_hngr_bar_tp_cd", mnrHngrBarTpDesc, mnrHngrBarTpCode, mnrHngrBarTpCode.substring(0,mnrHngrBarTpCode.indexOf("|")) );
				}
			}
		}
	}


	/**
	 * 로드시 초기화
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBCLEAR(sheetObj, formObj, sAction){
		//사용 변수 선언
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboDefault = "";

		MnrWaitControl(true);
		formObj.f_gubuns.value = "";
		formObj.mnr_ord_seq.value = "NEW";
		MnrFormSetReadOnly(formObj,false,"mnr_ord_seq");

		formObj.showDate.value = ComGetNowInfo();

		formObj.cost_ofc_cd.value = currOfcCd;
		formObj.pic_eng_nm.value="";
		formObj.eff_dt.value = "";
		formObj.exp_dt.value = "";

		formObj.curr_cd.value = "";
		formObj.cost_cd.value = "";
		formObj.combo_vndr_seq.Code2="-1";
		formObj.combo_vndr_seq.RemoveAll();
		formObj.combo_cost_cd.Code2="-1";
		formObj.combo_cost_cd.RemoveAll();
		formObj.combo_eq_knd_cd.Code2="-1";
		formObj.combo_eq_knd_cd.RemoveAll();
		formObj.ord_hdr_rmk.value="";

		var sCondition = new Array (
			//MultiCombo
			new Array("MnrGenCd","","CUSTOM9"),
			//쉬트 콤보
			new Array("MnrGenCd","CD00092", "COMMON")
		)
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);

		//*** EQ_TYPE
		if(comboList[0] != null){
			for(var j = 0; j < comboList[0].length;j++){
				var tempText = comboList[0][j].split("|");
				formObj.combo_eq_knd_cd.InsertItem(j, comboList[0][j] ,tempText[0]);
			}
		}
		formObj.combo_eq_knd_cd.Code = "";

		//Tariff Type
		if(comboList[1] != null){
			for(var j = 0; j < comboList[1].length;j++){
				var tempText = comboList[1][j].split("|");

				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				if(j == 0){
					sheetComboDefault = tempText[0];
				}
			}

			sheetComboCode = 	MnrDelLastDelim(sheetComboCode);
	     	sheetComboText = 	MnrDelLastDelim(sheetComboText);

			sheetObjects[0].InitDataCombo (0, "sheet1_mnr_hngr_trf_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
		}

		//Vender 정보 초기화
		combo_vndr_seq_Initialize();

		sheetObjects[0].RemoveAll();
		sheetObjects[0].Editable = true;
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();

		OrgCostType = "";
		costCdSubstr = "";
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Send");
	}

	/**
	 * 조회
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSEARCH(sheetObj, formObj, sAction){

		nowLoad = 1;
		formObj.f_gubuns.value = "";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(strMnrOrdSeq.length > 3)
		{
			strMnrOrdSeq=strMnrOrdSeq.substring(3);
			if(!ComIsNumber(strMnrOrdSeq))
			{
				ComShowCodeMessage("MNR00003");
				ComSetObjValue(formObj.mnr_ord_seq, "");
				ComSetFocus(formObj.mnr_ord_seq);
				return false;
			}
		}else{
			ComShowCodeMessage("MNR00003");
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComSetFocus(formObj.mnr_ord_seq);
			return false;
		}
		MnrWaitControl(true);

		formObj.f_cmd.value = SEARCH;
		var sParam = "";
		var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");

		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);

		var sXml   = sheetObj.GetSearchXml("EES_MNR_0058GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");

		for ( var i = 1; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[i].Redraw = false;
			sheetObjects[i].WaitImageVisible = false;
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}

		MnrFormSetReadOnly(formObj,true,"mnr_ord_seq");
	}

	/**
	 * 저장
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSAVE(sheetObj, formObj, sAction) {
		if(nowLoad != 0) return;
		if(formObj.combo_vndr_seq.Index == "-1"){
			ComShowCodeMessage("MNR00036","Agreement No");
			ComSetFocus(formObj.combo_vndr_seq);
			return false;
		}

		var Row = sheetObj.ColValueDup("sheet1_eq_no");
		if(Row > 0 && costCdSubstr == "MRDRH"){
			ComShowCodeMessage("MNR00006", "EQ No");
			sheetObj.SelectCell(Row, "sheet1_eq_no", true);
			return false;
		}
		if(formObj.combo_cost_cd.Index == "-1"){
			ComShowCodeMessage("MNR00205");
			ComSetFocus(formObj.combo_cost_cd);
			return false;
		}
		//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
		var rCnt = sheetObj.RowCount;
		if(rCnt <= 0)
		{
			//a[미선택][MNR00072] - Work Order를 생성할 Data를 선택하라는 메시지 표시
			ComShowCodeMessage("MNR00072");
			return false;
		}

		for(var i = sheetObj.HeaderRows;i < sheetObj.LastRow;i++)
		{
			var strCostDtlCD = ComTrimAll(sheetObj.CellValue(i, "sheet1_cost_dtl_cd")," ");
			//Hanger Bar(Square/Round) Purchasing(511511) 의 경우 Hanger Offer Info에 대한 입력 여부 체크
			if(strCostDtlCD == "M1" || strCostDtlCD == "MD")
			{
				if(sheetObj.CellValue(i, "sheet1_mnr_hngr_dtl_offr_desc") == ""){
					ComShowCodeMessage("MNR00353");
					sheetObj.SelectCell(i, "sheet1_mnr_hngr_dtl_offr_desc",true);
					return false;
				}
			}

			//Hanger Rack/Bar Removal 갯수의 합 체크
			if(formObj.combo_cost_cd.Code == "MRDRHD")
			{
				var rprQty = parseInt(sheetObj.CellValue(i,"sheet1_rpr_qty"));
				var actInvtQty = parseInt(sheetObj.CellValue(i,"sheet1_act_invt_qty"));
				var mnrHngrDmgQty = parseInt(sheetObj.CellValue(i,"sheet1_mnr_hngr_dmg_qty"));
				var mnrLostHngrQty = parseInt(sheetObj.CellValue(i,"sheet1_mnr_lost_hngr_qty"));
				var mnrDispHngrQty = parseInt(sheetObj.CellValue(i,"sheet1_mnr_disp_hngr_qty"));

			    if(rprQty != (actInvtQty + mnrHngrDmgQty + mnrLostHngrQty + mnrDispHngrQty)){
					ComShowCodeMessage("MNR00356");
					sheetObj.SelectCell(i, "sheet1_act_invt_qty",true);
					return false;
				}
			}

			//2. 해당 Cost Detail Type 빈값일 경우
			if(strCostDtlCD == "")
			{
				ComShowCodeMessage("MNR00172","Extra Expense Type");
				sheetObj.SelectCell(i, "sheet1_cost_dtl_cd",true);
				return false;
			}

			//3. 해당 Cost Detail Type이 Hanger Installation OR Hanger Uninstallation일 경우
			if(costCdSubstr == "MRDRH")
			{
				// EQ No를 Mandatory에 대한 체크를 수행 한다.
				var strEqNo =ComTrimAll(sheetObj.CellValue(i, "sheet1_eq_no")," ");
				if(strEqNo=="")
				{
					ComShowCodeMessage("MNR00084");
					sheetObj.SelectCell(i, "sheet1_eq_no",true);
					return false;
				}

				// Hanger Bar Type를 Mandatory에 대한 체크를 수행 한다.
				var CostDtlCd=sheetObj.CellValue(i, "sheet1_cost_dtl_cd");
				if(CostDtlCd=="RA" || CostDtlCd=="BA")
				{
					var strMnrHngrBarTpCd =ComTrimAll(sheetObj.CellValue(i, "sheet1_mnr_hngr_bar_tp_cd")," ");
					if(strMnrHngrBarTpCd=="")
					{
						ComShowCodeMessage("MNR00036","Hanger Bar Type");
						sheetObj.SelectCell(i, "sheet1_mnr_hngr_bar_tp_cd",true);
						return false;
					}
				}
			}

			//4. 해당 Item 빈값일 경우
			var strMnrExpnDtlNm = ComTrimAll(sheetObj.CellValue(i, "sheet1_mnr_expn_dtl_nm")," ");
			var strEqNo = ComTrimAll(sheetObj.CellValue(i, "sheet1_eq_no")," ");
			if(strMnrExpnDtlNm == "" && strEqNo == "" && formObj.combo_cost_cd.Code!="MRZSTP") //Brand일때 제외
			{
				ComShowCodeMessage("MNR00172","Description");
				sheetObj.SelectCell(i, "sheet1_mnr_expn_dtl_nm",true);
				return false;
			}

			//5. 해당 Amount 빈값일 경우
			var strCostAmt = ComTrimAll(sheetObj.CellValue(i, "sheet1_cost_amt")," ");
			if(strCostAmt == "0")
			{
				ComShowCodeMessage("MNR00175","Amount");
				sheetObj.SelectCell(i, "sheet1_spr_prt_uc_amt",true);
				return false;
			}
		}

		MnrWaitControl(true);

		formObj.vndr_seq.value  = formObj.combo_vndr_seq.Code;
		formObj.eq_knd_cd.value = formObj.combo_eq_knd_cd.Code;
		formObj.cost_cd.value	= formObj.combo_cost_cd.Code;

		formObj.f_cmd.value = MULTI;

		var aryPrefix = new Array("sheet1_", "sheet2_");
		var sParam = ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
			return false;

		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);

		//Row Delete 처리해서  데이터가 없을때 삭제처리
		if(sheetObj.Rowcount == "1" && sheetObj.CellValue(sheetObj.Rowcount, "sheet1_ibflag")=="D"){
			doIBREMOVE(sheetObj, formObj, sAction);
			return false;
		}

		var sXml = sheetObj.GetSaveXml("EES_MNR_0058GS.do", sParam);
		sheetObjects[0].LoadSaveXml(sXml);
		var f_gubuns=formObj.f_gubuns.value;

		if(MnrComGetErrMsg(sXml) == null && f_gubuns==""){
			var mnrOrdSeq = ComGetEtcData(sXml, "mnr_ord_seq");
			formObj.mnr_ord_seq.value=mnrOrdSeq;
			MnrFormSetReadOnly(formObj,true,"mnr_ord_seq");
			doIBSEARCH(sheetObj, formObj, IBSEARCH);
		} else {
			formObj.f_gubuns.value = "";
		}
		return true;
	}

	/**
	 * 삭제
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBREMOVE(sheetObj, formObj, sAction) {
		formObj.f_cmd.value = REMOVE;
		//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
		var rCnt=sheetObjects[2].RowCount;
		if(rCnt<=0)
		{
			//a[미선택][MNR00072] - Work Order를 생성할 Data를 선택하라는 메시지 표시
			ComShowCodeMessage("MNR00081");
			return false;
		}

		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(strMnrOrdSeq.length > 3)
		{
			strMnrOrdSeq = strMnrOrdSeq.substring(3);
			if(!ComIsNumber(strMnrOrdSeq))
			{
				ComShowCodeMessage("MNR00081");

				return false;
			}
		}else{
			ComShowCodeMessage("MNR00081");
			return false;
		}
		if(!ComShowCodeConfirm("MNR00026"))
		{
			return false;
		}
		MnrWaitControl(true);

		formObj.f_cmd.value = REMOVE;
		formObj.vndr_seq.value=formObj.combo_vndr_seq.Code;
		formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
		formObj.cost_cd.value=formObj.combo_cost_cd.Code;

		var aryPrefix = new Array("sheet1_", "sheet2_");
		var sParam = ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
		{
			MnrWaitControl(false);
			return false;
		}

		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);

		var sXml = sheetObj.GetSaveXml("EES_MNR_0058GS.do", sParam);

		sheetObjects[0].LoadSaveXml(sXml);

		if(MnrComGetErrMsg(sXml) == null){
			var mnrOrdSeq = ComGetEtcData(sXml, "mnr_ord_seq");
			ComShowCodeMessage("MNR00082");
			doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
		}
		return true;
	}

	// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S]
	/**
	 * Sheet 의 excel load 추가
	 */
	function doLoadExcel(sheetObj, formObj){
		
		if(formObj.combo_vndr_seq.Index == "-1"){
			ComShowCodeMessage("MNR00143","Agreement No");
			ComSetFocus(formObj.combo_vndr_seq);
			return false;
		}

		if(formObj.combo_cost_cd.Index == "-1"){
			ComShowCodeMessage("MNR00205");
			return;
		}

		if((sheetObj.RowCount) > 0  && nowLoad == 0){
			if(confirm("Do you still want to initialize it ?")){
				sheet1_cost_dtl_cd_Initialize(formObj.combo_cost_cd.Code);
				sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}else{
				return;
			}
		}
		
		var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
		sheetObj.LoadExcel(0,1,strFilePath,2,-1,"",true, false,"1=>4|2=>17");
	}

	/**
	 * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event
	 * @param sheetObj
	 */
	function sheet1_OnLoadExcel(sheetObj) {
		
		var formObj = document.form;
		var strErrEqNo = "";
		var arrErrEqNo = new Array();
		var arrIdx = 0;
		var strTotErrMsg = "Error Message\n\n";
		
		// sheetObj.WaitImageVisible = false;
		// loadingMode = true;
//		MnrWaitControl(true);
		
		for(var idx = sheetObj.HeaderRows; idx < sheetObj.LastRow ; idx++) {
			
			sheetObj.CellValue2(idx, "sheet1_mnr_hngr_trf_cd") = "CB";
			sheetObj.CellValue2(idx, "sheet1_cost_cd") = formObj.combo_cost_cd.Code;
			sheetObj.CellValue2(idx, "sheet1_eq_no_check_yn") ="N"; //빈값이 CHECK 완료된거임
			
			strErrEqNo = sheet1_LoadEndSetValue(sheetObj, idx, sheetObj.SaveNameCol("sheet1_eq_no"), sheetObj.CellValue(idx,"sheet1_eq_no"));
			
			if(!ComIsEmpty(strErrEqNo)) {
				arrErrEqNo[arrIdx] = strErrEqNo;
				
				sheetObj.CellFont ("FontColor", idx, "sheet1_eq_no") = sheetObjects[0].RgbColor(255,0,0);
				sheetObj.CellFont ("FontColor", idx, "sheet1_ord_dtl_rmk") = sheetObjects[0].RgbColor(255,0,0);
				sheetObj.CellValue2(idx, "sheet1_ord_dtl_rmk") = strErrEqNo.split("^")[1];
				
				arrIdx++;
			}
			
		}
		
		if(arrErrEqNo.length > 0) {
			
			ComBtnDisable("btn_W/O_Creation");
			sheetObj.Editable = false;
			
			for(var jdx = 0; jdx < arrErrEqNo.length; jdx++) {
				strTotErrMsg += arrErrEqNo[jdx].split("^")[0] + " => " + arrErrEqNo[jdx].split("^")[1] + "\n";
			}
			
			strTotErrMsg += "\nPlease Reload Excel File!";
			
			ComShowMessage(strTotErrMsg);
		}
		
		// sheetObj.WaitImageVisible = true;
//		MnrWaitControl(false);
	}
	
	/**
	 * 엑셀 로드후 EQ No.로 한줄씩 데이터를 가져오면서 Validation까지 수행
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return String strErr // "eq_no, reason"
	 */
	function sheet1_LoadEndSetValue(sheetObj, Row, Col, Value) {
		if(nowLoad == 0) {

			var formObj = document.form;
			var strErr =  "";
			
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");

			// sheet1_eq_no = EQ No. 
			if(sheetObj.ColSaveName(Col) == "sheet1_eq_no" && costCdSubstr == "MRDRH") {
				var checkEqn = sheetObjects[0].CellValue(Row,"sheet1_eq_no");

				if(checkEqn == ""){
					return checkEqn + "^EQ No. is empty.";
				} else {
					sheetObjects[0].CellValue2(Row,"sheet1_eq_no")=checkEqn.toUpperCase();
					checkEqn=checkEqn.toUpperCase();

					var sEqType = formObj.combo_eq_knd_cd.Code;
					var sEqNo  = checkEqn;
					var sDate = ComGetNowInfo("ymd");
					var sCostType = "";
					if(formObj.combo_eq_knd_cd.Code == "U"){
						sCostType = "MRDRRC";
					} else if(formObj.combo_eq_knd_cd.Code == "G"){
						sCostType = "MRGSRC";
					} else {
						sCostType = "MRZSRC";
					}

					var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sDate,sCostType);
					var retArr =  MnrXmlToArray(sXml);
					var mnr_hngr_bar_tp_cd="";
					var rpr_qty="";
					var recent_rpr_qty="";
					var mnr_hngr_rck_cd="";
					//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
					//|33 total_loss_date|34 rpr_cost_amt|35 dpp_amt|36 mnr_hngr_trf_cd|37 mnr_hngr_trf_otr_desc|38 act_invt_qty|39 mnr_hngr_dmg_qty|40 mnr_lost_hngr_qty|41 mnr_disp_hngr_qty
					if(retArr != null){
						if(costCdSubstr == "MRDRH" ){
							if(retArr[0][17]==""){ // hngr_rck_cd
								mnr_hngr_rck_cd="R";
							} else {
								mnr_hngr_rck_cd=retArr[0][17];
							}

							if(retArr[0][24]==""){ // bar_tp_cd
								mnr_hngr_bar_tp_cd="S";
							} else {
								mnr_hngr_bar_tp_cd=retArr[0][24];
							}

							rpr_qty = "0";		//일단 보류
							recent_rpr_qty = retArr[0][22]; // bar_atch_knt

							//선행 체크 작업 Perment가 아니라면 중복 설치 중복 제거는 되지 않는다.
							if(formObj.combo_cost_cd.Code=="MRDRHA"){
								if(retArr[0][22] != "0"){ // bar_atch_knt
									// msgs['MNR00354'] = '{?msg1} Hanger bar was already Installed,Please remove first';
//									ComShowCodeMessage("MNR00354",checkEqn);
//									sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
//									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return checkEqn + "^Already Installed";
								}
							} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
								if(retArr[0][22] == "0"){ // bar_atch_knt
									// msgs['MNR00355'] = '{?msg1} Hanger bar was already Removed,Please install first';
//									ComShowCodeMessage("MNR00355",checkEqn);
//									sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
//									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return checkEqn + "^Already Removed";
								}
							}

							var costDtlCd = sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd");

							if(mnr_hngr_rck_cd=="O"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="RA";
								}else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="RD";
								}
								//Perment는 Square
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_bar_tp_cd")="S";
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = false;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = false;
							} else if(mnr_hngr_rck_cd=="R"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="BA";
								} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="BD";
								}
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							} else if(mnr_hngr_rck_cd=="D"){
								if(formObj.combo_cost_cd.Code=="MRDRHA"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="EA";
								} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
									sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")="ED";
								}
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							} else {
								sheetObjects[0].CellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd") = true;
								sheetObjects[0].CellEditable(Row, "sheet1_cost_dtl_cd") = true;
							}

							if(formObj.combo_cost_cd.Code=="MRDRHA"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")=="RA"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="BA";
									} else {
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="EA";
									}
								}

								sheetObjects[0].CellValue2(Row,"sheet1_rpr_qty") = rpr_qty;
							} else if(formObj.combo_cost_cd.Code=="MRDRHD"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd")=="RD"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="BD";
									} else {
										sheetObj.CellValue(Row,"sheet1_cost_dtl_cd")="ED";
									}
								}

								sheetObjects[0].CellValue2(Row,"sheet1_rpr_qty") = recent_rpr_qty;
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_trf_cd") = retArr[0][36];
								sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_trf_otr_desc") = retArr[0][37];

							}
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_flg_yd_cd")=retArr[0][18];
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_rck_cd")=mnr_hngr_rck_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_eq_tpsz_cd")=retArr[0][31];
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_bar_tp_cd")=mnr_hngr_bar_tp_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_org_hngr_bar_tp_cd")=mnr_hngr_bar_tp_cd;
							sheetObjects[0].CellValue2(Row,"sheet1_recent_rpr_qty")=recent_rpr_qty;
							sheetObjects[0].CellValue2(Row,"sheet1_mnr_hngr_flg_dt")=sDate;
							sheetObjects[0].CellValue2(Row,"sheet1_eq_knd_cd")=formObj.combo_eq_knd_cd.Code;

							if(sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "RD" || sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "BD" || sheetObjects[0].CellValue(Row,"sheet1_cost_dtl_cd") == "ED"){
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = false;
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = false;
								sheetObj.CellEditable(Row,"sheet1_rpr_qty") = false;
							} else {
								if(mnr_hngr_rck_cd!="O"){
									sheetObj.CellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd") = true;
								}
								sheetObj.CellEditable(Row,"sheet1_mnr_hngr_trf_cd") = true;
								sheetObj.CellEditable(Row,"sheet1_rpr_qty") = true;
							}
						}
					} else {
						// msgs['MNR00165'] = '{?msg1} doesn\'t exist, Please check again.';
//						ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
//						sheetObjects[0].CellValue2(Row,"sheet1_eq_no")="";
//						sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
						return checkEqn + "^Doesn\'t exist";
					}
				}
			}
			return strErr;
		}
	}
	// 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E]

	/**
	 * Sheet 의 Row 추가
	 */
	function doRowAdd(sheetObj, formObj){
		if(formObj.combo_vndr_seq.Index == "-1"){
			// msgs['MNR00143'] = 'Please select upper {?msg1}.';
			ComShowCodeMessage("MNR00143","Agreement No");
			ComSetFocus(formObj.combo_vndr_seq);
			return false;
		}

		if(formObj.combo_cost_cd.Index == "-1"){
			// msgs['MNR00205'] = 'Please select cost type.';
			ComShowCodeMessage("MNR00205");
		} else {
			var row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(row, "sheet1_cost_dtl_cd") = "";
			sheetObj.CellValue2(row, "sheet1_mnr_hngr_bar_tp_cd") = "";
			if(costCdSubstr == "MRDRH" ){
				sheetObj.CellValue2(row, "sheet1_rpr_qty") = 0;
				sheetObj.CellValue2(row, "sheet1_recent_rpr_qty") = 0;
			}else{
				sheetObj.CellValue2(row, "sheet1_rpr_qty") = 1;
			}

			sheetObj.CellValue2(row, "sheet1_cost_cd") = formObj.combo_cost_cd.Code;
			sheetObj.CellValue2(row, "sheet1_eq_no_check_yn") ="N"; //빈값이 CHECK 완료된거임
			sheetObj.SelectCell(row, "sheet1_cost_dtl_cd",true);

		}
	}

	/**
	 * IBSheet의 file upload 할 Row를 추가한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Insert(sheetObj){
//		MnrWaitControl(true);

		uploadFileSeq = sheetObj.CellValue(2,"file_seq");

		if(uploadFileSeq == undefined){
			uploadFileSeq = "";
		}

		var row =sheetObj.DataInsert(-1);
		sheet2_OnPopupClick(sheetObj,row,2);
	}

	/**
	 * IBSheet의 file upload 할 Row를 삭제한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/

	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			if(sheetObj.RowCount ==1 )
			{
				document.form.file_seq.value="0";
				MnrWaitControl(false);
				ComBtnDisable("btn_W/O_Send");

			}
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}

	/**
	 * Sheet 의 셀값 변경시 계산
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function doCalculate(sheetObj,Row, Col, Value){
		var formObj = document.form;
		var bzcAmt =  MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty = MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_rpr_qty"));

		sheetObjects[0].CellValue(Row, "sheet1_cost_amt") = parseFloat(qty) * parseFloat(bzcAmt);				//Hanger Bar Qty
	}

	/**
	 * 조회된 xml 을 String 으로 전환
	 * @param xmlStr
	 * @param codeCol
	 * @param textCol
	 * @return
	 */
	function getDataString(xmlStr, codeCol, textCol) {
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}

			var colListIdx = Array();
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1] = i;
				}
			}

			var retStr = "";

			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

				retStr = MnrNullToZero(arrData[colListIdx[0]]) + '|'  + MnrNullToZero(arrData[colListIdx[1]]);
			}

		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return retStr;
	}

	/**
	 * 조회시 sheet 에 수정된 내용이 있는지 확인
	 */
	function checkSheetStatus(sheetObj){
		var flag = true;
		var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
		if(sRow != "") // sheet 수정내용 있음
		{
			flag = false;
		}
		return flag
	}

	/**
	 * 조회시 필수 체크
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function checkWorkOrderNo(sheetObj, formObj, sAction){
		var flag=true;
		if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
		{
			ComShowCodeMessage("MNR00172",'W/O No');
			ComSetFocus(formObj.mnr_ord_seq);

			flag=false;
		}
		return flag
	}

	/**
	 * EES_MNR_0036 팝업의 값을 받는  함수
	 * @param Array[]	array 	리턴받은 데이터
	 */
	function setDocSendParam(array) {
	}

	/**
	 * OFF 멀티 팝업의 값을 받는 함수
	 */
	function getMnr_ofcInfoMulti(retStr,sheet_id,row){
		var formObj = document.form;
		var targetSheet = sheetObjects[sheet_id];
		targetSheet.CellValue(row, "sheet1_mnr_hngr_dtl_offr_desc")  = retStr;
	}

	/**
	 * EES_MNR_0211 팝업의 값을 받는 함수
	 * @param array
	 * @return
	 */
	function setParam(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(',');

		formObj.mnr_ord_seq.value = arr[4];

		if(formObj.mnr_ord_seq.value.length > 3){
			doIBSEARCH(sheetObjects[2], formObj, IBSEARCH);
		}
	}

	/**
	 * Cost Type 콤보값에 따라 Sheet 의 컬럼 Display 설정
	 * @param costType
	 * @return
	 */
	function setSheetColumnDisplay(costType) {
		//Container - Hanger
		if(costType=="MRDROT"){
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_dtl_offr_desc") = false;		//hanger pharase offer info
		} else {
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_dtl_offr_desc") = true;		//hanger pharase offer info
		}

		if (costType=="MRDRHA" || costType=="MRDRHD") {
			sheetObjects[0].ColHidden("sheet1_eq_no")=false;				//EQ No
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_bar_tp_cd")=false;	//Hanger Bar Type
			sheetObjects[0].ColHidden("sheet1_rpr_qty")=false;				//Hanger Bar Qty
			sheetObjects[0].ColHidden("sheet1_mnr_expn_dtl_nm")= true;		//Description
			sheetObjects[0].ColHidden("sheet1_spr_prt_uc_amt")=true;		//Unit Price
			sheetObjects[0].CellValue(0,"sheet1_rpr_qty")="Installation Bar Qty";
			sheetObjects[0].CellValue(1,"sheet1_rpr_qty")="Installation Bar Qty";

			sheetObjects[0].ColHidden("sheet1_mnr_hngr_trf_cd")= false;			//Tariff Type
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_trf_otr_desc")=false;	//Other Tariff Desc

			if(costType=="MRDRHD"){
				sheetObjects[0].ColHidden("sheet1_act_invt_qty")=false;			//Sound
				sheetObjects[0].ColHidden("sheet1_mnr_hngr_dmg_qty")=false;		//Repairable
				sheetObjects[0].ColHidden("sheet1_mnr_lost_hngr_qty")=false;	//missing
				sheetObjects[0].ColHidden("sheet1_mnr_disp_hngr_qty")=false;	//disposal
			} else {
				sheetObjects[0].ColHidden("sheet1_act_invt_qty")=true;			//Sound
				sheetObjects[0].ColHidden("sheet1_mnr_hngr_dmg_qty")=true;		//Repairable
				sheetObjects[0].ColHidden("sheet1_mnr_lost_hngr_qty")=true;		//missing
				sheetObjects[0].ColHidden("sheet1_mnr_disp_hngr_qty")=true;		//disposal
			}

			sheetObjects[0].ColWidth("sheet1_rpr_qty")= 100;
		} else {
			//Chassis - Pre-Maintenance
			if(costType=="MRZSPR") {
				sheetObjects[0].ColHidden("sheet1_eq_no")=false;	//EQ No
			} else {
				sheetObjects[0].ColHidden("sheet1_eq_no")=true;		//EQ No
			}

			if(costType=="MRDROT" || costType=="MRZSOT" || costType=="MRGSOT" || costType=="MRZSTP" || costType=="MRZSTR") { //other일때 와 Tire Purchase, Tire Replace일때  qty 보여줌 0331
				sheetObjects[0].ColHidden("sheet1_rpr_qty")=false;
			} else {
				sheetObjects[0].ColHidden("sheet1_rpr_qty")=true;
			}

			sheetObjects[0].ColHidden("sheet1_mnr_hngr_bar_tp_cd")=true;	//Hanger Bar Type
			sheetObjects[0].ColHidden("sheet1_mnr_expn_dtl_nm")= false;		//Description
			sheetObjects[0].ColHidden("sheet1_spr_prt_uc_amt")=false;		//Unit Price
			sheetObjects[0].CellValue(0,"sheet1_rpr_qty")="Q'ty";
			sheetObjects[0].CellValue(1,"sheet1_rpr_qty")="Q'ty";
			sheetObjects[0].ColWidth("sheet1_rpr_qty")= 60;
			sheetObjects[0].ColHidden("sheet1_act_invt_qty")=true;			//Sound
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_dmg_qty")=true;		//Repairable
			sheetObjects[0].ColHidden("sheet1_mnr_lost_hngr_qty")=true;		//missing
			sheetObjects[0].ColHidden("sheet1_mnr_disp_hngr_qty")=true;		//disposal
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_trf_cd")= true;		//Tariff Type
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_trf_otr_desc")=true;	//Other Tariff Desc
		}

		//Chassis - The Pachase
		if(costType=="MRZSTP"){
			sheetObjects[0].CellValue(0,"sheet1_mnr_expn_dtl_nm")="Brand";
			sheetObjects[0].CellValue(1,"sheet1_mnr_expn_dtl_nm")="Brand";
		}else{
			sheetObjects[0].CellValue(0,"sheet1_mnr_expn_dtl_nm")="Description";
			sheetObjects[0].CellValue(1,"sheet1_mnr_expn_dtl_nm")="Description";
		}
	}

		/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch
		var formObject = document.form;
		axon_event.addListenerForm  ('blur',     	'obj_deactivate', 	formObject); 	//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    	'obj_activate',		formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 	'obj_change',		formObject); 	//- 변경될때.
		axon_event.addListener('change',	 		'obj_change1',		'ord_hdr_rmk');	//- 변경될때.
	}

	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}

	/**
     * HTML Control의 onfocus이벤트에서 Validation을 체크한다. <br>
     **/
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
		keys = event.keyCode;

		if(obj.dataformat == null )
		{
			if(obj.name!="ord_hdr_rmk")
			{
				return;
			}
		}

		window.defaultStatus = obj.dataformat;
		var formObj  = document.form;

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
			case "mnr_ord_seq":
				var strMnrOrdSeqAll  = formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail = "";
				if(strMnrOrdSeqAll=="NEW")
				{
					formObj.mnr_ord_seq.value="";
				}
				if(strMnrOrdSeqAll.length > 3)
				{
					if(keys == 13)
					{
						ComSetFocus(formObj.combo_vndr_seq);
						return;
					}
				}
				break;
			}
		}

		switch(obj.dataformat) {
		case "ymd":
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
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "engnum":
			ComKeyOnlyAlphabet("num","32|64");
			break;
		}
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
			case "mnr_ord_seq":
				var strMnrOrdSeqAll  = formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail = strMnrOrdSeqAll.substring(3);
				if(!ComIsNumber(strMnrOrdSeqTail))
				{
					formObj.mnr_ord_seq.value = strMnrOrdSeqAll.substring(0,3);
				}
				doActionIBSheet(sheetObj, formObj , IBSEARCH);
				break;
			}

		} else {
			switch(obj.id) {
			case "ord_hdr_rmk":
				ComBtnDisable("btn_W/O_Send");
				ComBtnEnable("btn_W/O_Creation");
				break;
			}
		}
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change1(){
		ComBtnDisable("btn_W/O_Send");
		ComBtnEnable("btn_W/O_Creation");
	}

/* 개발자 작업  끝 */