/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EES_MNR_0262.js
 *@FileTitle : Write off Request
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.12.06
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2012.12.06 조경완
 * 1.0 Creation
 * ------------------------------------------------------------
 * 2013.08.07 조경완 [CHM-201326069-01] [MNR-자체개선] Write off Request 기능 보완
 * 2013-10-01 Jonghee HAN [CHM-201326903] Write-off request 신청 office 기준 변경 요청
 * 2013-11-01 Jonghee HAN [CHM-201327244] ALPS-MNR-TOTAL LOSS-WRITE OFF REQUST시 "Save" Button Click 시 경고 메시지 요청 MNR00395로 변경
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
	 * @class ees_mnr_0262 : ees_mnr_0262 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0262() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq = "";
	//History Seq 저장변수
	var historyMnrStsRefNo = "";
	var sSaveRtnXml = "";
	//저장타입
	var saveType = 1;
	//현재구동여부
	var nowLoad=0;
	
	var rqstFlg = "";
	var searchFlg = "";
	var ttlLssDtlRsnRmk = "";
	var dpcCltFaldRsnRmk = "";
	var rcvrActHisRmk = "";
	var cltAmt = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];

		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObject1,document.form,IBCLEAR,0);
				break;
	
			case "btn_Save":
				//MEXBA-MEXSC 변경에 따른 신규 데이타 생성 막음
				if(currOfcCd == "MEXBA"){
					ComShowCodeMessage("MNR00357");		
					break; 
				}
				doActionIBSheet(sheetObject1,document.form,IBSAVE,1);
				break;
	
			case "btn_Request":
				doActionIBSheet(sheetObject1,document.form,IBSAVE,2);
				break;
			case "btn_Delete":    
				doActionIBSheet(sheetObject1,document.form,IBSEARCHAPPEND); 
				break;
	
				//TLL No. PopUp
			case "ttl_lss_no_popup":
				if(!formObject.search_ttl_lss_no.readOnly) { 
					ComOpenPopup('/hanjin/EES_MNR_0195.do', 725, 440, 'setEES_MNR_0195', '0,1,1,1,1,1,1,1,1,1,1,1', true);
				}
				break;

				/** (Tab) D.V Expense (S) **/
			case "btn_RowAdd2":
				history_Insert(sheetObject4);
				break;
	
			case "btn_RowDel2":
				history_Remove(sheetObject4);
				break;
	
			case "btn_FileAdd":
				file_Insert(sheetObject5);
				break;
	
			case "btn_FileDel":
				file_Remove(sheetObject5); 
				break;
				
			case "btn_FileAdd1":
				file_Insert(sheetObject2);
				break;
	
			case "btn_FileDel1":
				file_Remove(sheetObject2); 
				break;
	
			} 
		}catch(e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
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
		//버튼 설정
		MnrWaitControl(true);
		nowLoad=1;
		//Axon이벤트 초기화
		initControl();
	
		//IBMultiCombo 초기화
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
	
		//IBSheet 초기화
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		//IBTab 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
	
		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
//		
//		doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
//		//로그인 Office의 지역이 US인지 체크
//		var sParam = 'f_cmd=' + SEARCH01 + '&rqst_ofc_cd=' + currOfcCd;
//		var sXml = sheetObjects[0].GetSearchXml("EES_MNR_0095GS.do", sParam);
//		currOfcUS = ComGetEtcData(sXml, "chkUS");
		
	}
	
	/**
	 * IBCombo 기본 설정
	 * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initCombo(comboObj, comboNo) {
		var cnt  = 0 ;
		var formObject = document.form
	
		switch(comboNo) {
		case 1: 
		case 2:
		case 3: 
		case 4: 
			with (comboObj) { 
				SetColAlign("left");         
				DropHeight = 160;  
			}
			break;
		} 
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
		case "h1sheet1":
			with (sheetObj) {
				//높이 설정
				style.height = 200;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
	
				var HeadTitle1 = "|Sel|EQ Type|EQ No|TP/SZ|Term|Lessor|Yard|Invoice No|CURR|D/V\nAMT|*Collected\nAMT|AMT of Loss|By Requester|||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"eq_knd_cd",			false,	"",	dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,	"rqst_eq_no",			false,	"",	dfNone,			0,	false,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",				false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			170,		daCenter,	true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"ttl_lss_yd_cd",		false,	"",	dfNone,			0,	false,	true,	7);
                InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"inv_no",				false,	"",	dfNone,			0,	false,	true,	20);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"dpc_val_amt",			false,	"",	dfNullFloat,	2,	false,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"wrtf_clt_amt",			false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"amt_loss",				false,	"",	dfNullFloat,	2,	false,	true,   13);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"upd_usr_id",			false,	"",	dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,  	false,  "ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,  	false,  "ttl_lss_seq");
				InitDataProperty(0, cnt++ , dtHidden,	 	0,		daLeft,		true,  	"wrtf_no");
				
				CountPosition = 2; 
			}
			break;
	
		case "t1sheet1":
			with (sheetObj) {
				var prefix = "";
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 13, 100);
	
				var HeadTitle1 = "|Sub Reason|Sub Reason|Sub Reason||||";
				var HeadTitle2 = "|Sel|File|DownLoad||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true); 
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
				InitDataProperty(0, cnt++ , dtPopup,      	100,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
				InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);
				InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
                
				CountPosition = 0;
				
				ImageList(0)= "/hanjin/img/ico_attach.gif";
				
				ShowButtonImage = 1;    
			}
			break;
	
		case "t1sheet2": // 3rd Party
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 13, 100);

				var HeadTitle1 = "|Office|PIC|Status|Date|Remarks|||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"ofc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"usr_nm",			false,	"",	dfNone,			0,	false,	false,	14);
				InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"apro_sts_nm",		false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"apro_dt",			false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"apro_rmk",			false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	"row_seq",   		false,  "", dfNone, 		0,  true,   true);
                InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	"apro_usr_id",   	false,  "", dfNone, 		0,  true,   true);
                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"apsts_cd",			false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"apro_step_seq",	false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"ofc_tp_cd",		false,	"",	dfNone,			0,	false,	false);
                
                CountPosition = 0;
			}
			break;
	
		case "t2sheet1": // Disposal
			with (sheetObj) {
				// 높이 설정
				style.height = 142;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Date|Remark(s)|Creation Office|Creation User";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 3, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	"mnr_sts_dt",	false,	"",	dfDateYmd,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,	"mnr_sts_rmk",	false,	"",	dfNone,		0,	true,	true,	4000);
				InitDataProperty(0, cnt++ , dtData,     	100,	daCenter,	true,	"rqst_ofc_cd",	false,	"",	dfNone,  	0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	true,	"cre_usr_id",	false,	"",	dfNone,		0,	false,	false);
	
				//Hidden
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_ref_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_grp_tp_cd");
	
				PopupImage = "/hanjin/img/btns_calendar.gif";
				ShowButtonImage = 2;
				CountPosition = 0;
			}
			break;
	
		case "t2sheet2":
			with (sheetObj) {
				var prefix = "";   
	
				// 높이 설정
				style.height = 142; 
				// 전체 너비 설정
				//SheetWidth = mainTable.clientWidth;
				SheetWidth = 280;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;	
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 13, 100);
	
				var HeadTitle1 = "|Evidence Attachment|Evidence Attachment|Evidence Attachment";
				var HeadTitle2 = "|Sel|File|Download";
	
				var headCount = ComCountHeadTitle(HeadTitle1);									
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true); 
				InitHeadRow(1, HeadTitle2, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
				InitDataProperty(0, cnt++ , dtPopup,      	120,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
				InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
				InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);										
				InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
	
				CountPosition = 0;
	
				ImageList(0)= "/hanjin/img/ico_attach.gif";
	
				ShowButtonImage = 1;    
			}
			break;
		}
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
				InsertTab( cnt++ , "About Write Off", -1 );
				InsertTab( cnt++ , "TTL History", -1 );

			}
			break;
		}
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
		axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
		axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
		axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
	}
	
	/**
	 * IBUpload Object 기본설정
	 */
	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
	function setPopUpParam_COM_ENS_071(array) {
	
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];

	}   
	
	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
	 * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_focus(){
		ComClearSeparator(event.srcElement);
	}
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
		window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			break;
	
		case "engup":
			if(obj.name=="search_ttl_lss_no"){
				ComKeyOnlyAlphabet('uppernum','45'); //"-"         
			} else {
				ComKeyOnlyAlphabet('uppernum');	
			}          
			break;
		} 
	}
	
	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{	     
		ComChkObjValid(event.srcElement);
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
			case "respb_ofc_cd":   
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;  
			}       
		} 
	}    
	
	/**
	 * 초기화 이벤트 OnLoad 가 끝나면 초기화 이벤트 실행
	 * 
	 * @param {Sheet}sheetObj 프로세스 처리될 시트오브젝트
	 */
	function t1sheet1_OnLoadFinish(sheetObj) {
		 doActionIBSheet(sheetObjects[1], document.form, IBCLEAR, 0);
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		
		if(nItem == beforetab){
			objs[nItem].style.display = "Inline";
		}else{
			objs[nItem].style.display = "Inline";
			objs[beforetab].style.display = "none";
		}

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab= nItem;
		
		var fileSeq = document.form.file_seq.value;
		var subFileSeq = document.form.sub_file_seq.value;
		var mnrStsRefNo = document.form.mnr_sts_ref_no.value;
		var wrtfNo = document.form.wrtf_no.value;
		
		if(beforetab == 0){
			//Approval Step 리스트 조회
			if(sheetObjects[2].RowCount == 0 && searchFlg == "Y"){
				var sXml = MnrApprovalStepSearch(sheetObjects[2], currOfcCd, wrtfNo);
				sheetObjects[2].LoadSearchXml(sXml);
					
			}

			//파일 리스트 조회
			if(subFileSeq != "" && subFileSeq != null){
				var subFileXml = SearchFileUpload(sheetObjects[1],subFileSeq);
				if(!MnrIsEmptyXml(subFileXml)){
					sheetObjects[1].LoadSearchXml(subFileXml);
				}
			}
		}else if(beforetab == 1){
			//파일 리스트 조회
			if(fileSeq != "" && fileSeq != null){
	
				var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[4].LoadSearchXml(fileXml);
				}
			}
			
			//History 리스트 조회
			if(mnrStsRefNo != "" && mnrStsRefNo != null){
				historyMnrStsRefNo = mnrStsRefNo;
				var sXml = MnrStatusHistorySearch(sheetObjects[3], mnrStsRefNo);
				sheetObjects[3].LoadSearchXml(sXml);
			}
		}
	}
	
	/** 
	 * COMBO 변경 이벤트
	 *     Main Reason 변경시 Sub Reason 조회 및 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function ttl_lss_rsn_cd_OnChange(comboObj,Index_Code, Text){
		//Sub Reason 초기화
		var ttlLssDtlRsnCdObj = document.form.ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll();	
		ttlLssDtlRsnCdObj.Code = "";  
	
		//Main Reason 체크
		if(Index_Code == "A" || Index_Code == "") {return;} 
	
		//Sub Reason 조회 및 설정
		ttlLssDtlRsnCdObj.RemoveAll();	
		var sCondition = new Array (
				new Array("MnrGenCd",Index_Code, "COMMON") 		
		)             
		sheetObjects[0].WaitImageVisible = false;
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].WaitImageVisible = true;
		for(var j = 0; j < comboList[0].length;j++){ 
			var tempText = comboList[0][j].split("|");    
			ttlLssDtlRsnCdObj.InsertItem(j, tempText[1] ,tempText[0]);
		}
		ttlLssDtlRsnCdObj.Index = 0;  
	}
	
	/** 
	 * COMBO 변경 이벤트
	 *     Sub Reason 변경시 SCAC Code disable 설정(Trucker 일 경우만 입력 가능 설정) 
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */	
	function ttl_lss_dtl_rsn_cd_OnChange(comboObj,Index_Code, Text){	
		sheetObjects[2].Redraw = false;
		if(("Trucker" == ComTrim(Text)) && ("Y" == currOfcUS)){
			for(var i=sheetObjects[2].HeaderRows; i<=sheetObjects[2].LastRow-1; i++){	
				sheetObjects[2].CellEditable(i, "usa_edi_cd") = true;
				sheetObjects[2].CellBackColor(i, "usa_edi_cd") = -1;
			}
		}else{	
			// Trucker 가 아닐경우, SCAC Code null 처리
			for(var i=sheetObjects[2].HeaderRows; i<=sheetObjects[2].LastRow-1; i++){	
				sheetObjects[2].CellValue(i, "usa_edi_cd") = "";
				sheetObjects[2].CellEditable(i, "usa_edi_cd") = false;				
				sheetObjects[2].CellBackColor(i, "usa_edi_cd") = -1;
			}
		}
		sheetObjects[2].Redraw = true;
	}
	
	/**
	 * 조회후 Header 값 설정 및 형식 변경 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {		
			for(var i = 1;i<sheetObj.RowCount+1; i++){
				if(sheetObj.CellValue(i, "wrtf_no") != ""){
					sheetObj.CellValue2(i, "del_chk") = 1;
				}
				sheetObj.CellBackColor(i,"wrtf_clt_amt") = sheetObj.RgbColor(153, 255, 255);
			}
			
			setCalculateTotalSum();
			
			var fileSeq = document.form.file_seq.value;
			var subFileSeq = document.form.sub_file_seq.value;
			var mnrStsRefNo = document.form.mnr_sts_ref_no.value;
			var wrtfNo = document.form.wrtf_no.value;
			
			if(beforetab == 0){
				searchFlg = "Y";
				//Approval Step 리스트 조회
				var sXml = MnrApprovalStepSearch(sheetObjects[2], currOfcCd, wrtfNo);
				if(ComGetTotalRows(sXml)>0){
					sheetObjects[2].LoadSearchXml(sXml);
				}

				
				
				//파일 리스트 조회
				if(subFileSeq != "" && subFileSeq != null){
					var subFileXml = SearchFileUpload(sheetObjects[1],subFileSeq);
					if(!MnrIsEmptyXml(subFileXml)){
						sheetObjects[1].LoadSearchXml(subFileXml);
					}
				}
			}else if(beforetab == 1){
				//파일 리스트 조회
				if(fileSeq != "" && fileSeq != null){
		
					var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
					if(!MnrIsEmptyXml(fileXml)){
						sheetObjects[4].LoadSearchXml(fileXml);
					}
				}
				
				//History 리스트 조회
				if(mnrStsRefNo != "" && mnrStsRefNo != null){
					historyMnrStsRefNo = mnrStsRefNo;
					var sXml = MnrStatusHistorySearch(sheetObjects[3], mnrStsRefNo);
					sheetObjects[3].LoadSearchXml(sXml);
				}
			}
			
		}
	}
	 
	 /**
	  * 조회후 Header 값 설정 및 형식 변경 
	  * @param	{IBSheet}	sheetObj	시트오브젝트
	  * @param	{String}	ErrMsg		에러메세지
	  */
	function t1sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			document.form.wrtf_rqst_ofc_cd.value = currOfcCd;
			if(sheetObj.CellValue(1, "apsts_cd") == "S"){
				ComBtnEnable("btn_Delete");
				if(sheetObj.CellValue(1, "apro_usr_id") == usrId){
					ComBtnEnable("btn_Request");
				}
			}else{
				ComBtnDisable("btn_Delete");
			}
//	 		var check = false;
			for(var i = 1;i<sheetObj.RowCount+1; i++){
				if(i == 1){
					sheetObj.CellBackColor(i,"apro_rmk") = sheetObj.RgbColor(153, 255, 255);
					sheetObj.CellEditable(i, "apro_rmk") = true;
				}else{
					sheetObj.CellEditable(i, "apro_rmk") = false;
				}
//		 		if(i != 1){
//					if(sheetObj.CellValue(i, "ofc_tp_cd") == "BB"||sheetObj.CellValue(i, "ofc_tp_cd") == ""){
//						check = true;
//					}
//				}
			}
			
			ComBtnEnable("btn_Save");

		}
	}
	
	/**
	 * Loss Total : DV의 Pay Amount의 합계
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var calFlag=false;

		if(sheetObjects[0].RowCount > 0)
		{
			calFlag=true;
		}

		
		if(calFlag==true){
		    var dvAmtTotal=0;
		    var recoveryAmtTotal=0;
		        								
            if(sheetObjects[0].RowCount >0)	{			
				for(var j=sheetObjects[0].HeaderRows ;j<=sheetObjects[0].LastRow;j++){		
					if(sheetObjects[0].CellValue(j,"ibflag")!="D" ){
						if(sheetObjects[0].CellValue(j,"dpc_val_amt")!="") {		
							dvAmtTotal = getFloatSumData(dvAmtTotal,sheetObjects[0].CellValue(j,"dpc_val_amt"));
						}
						if(sheetObjects[0].CellValue(j,"wrtf_clt_amt")!=""){
							recoveryAmtTotal = getFloatSumData(recoveryAmtTotal,sheetObjects[0].CellValue(j,"wrtf_clt_amt"));
						} 
					}
			    }
            }
         					 	  			      
            var tempStr = ComAddComma2((dvAmtTotal + ""), "#,###"); 
			eval("document.form.dvAmtTtl.value = tempStr;");
					
			tempStr = ComAddComma2((recoveryAmtTotal + ""), "#,###");		 
			eval("document.form.recveryAmtTtl.value = tempStr;");
			
			tempStr = ComAddComma2((getFloatSubstractData(dvAmtTotal,recoveryAmtTotal) + ""), "#,###");   	
			eval("document.form.lossAmtTtl.value = tempStr;"); 	
		}	
	}	
		
	/**
	 * parseFloat 버그로 함수로 뺌 <br>	
	 * @param a  더할값 		
	 * @param b  더할값		
	 * @return sumResult  결과값 			
	 */	 		
	function getFloatSumData(a,b){				
		var aFloat = parseFloat(a + "");										
		var bFloat = parseFloat(b + ""); 						  	
		var sumResult = parseFloat(aFloat + bFloat).toFixed(2);		   	 	   								   	  		     		
		return  parseFloat(sumResult + "");			
	}
	 
	/**
	 * parseFloat 버그로 함수로 뺌 <br>	
	 * @param a  뺄값 		
	 * @param b  뺄값		
	 * @return sumResult  결과값 			
	 */	 		
	function getFloatSubstractData(a,b){				
		var aFloat = parseFloat(a + "");										
		var bFloat = parseFloat(b + ""); 						  	
		var subResult = parseFloat(aFloat - bFloat).toFixed(2);		   	 	   								   	  		     		
		return  parseFloat(subResult + "");			
	}
	 
	/** 
	 * Collected AMT 에 따른 AMT of Loss 를 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function h1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			
			if(colname == "wrtf_clt_amt") {
				var amt_loss = 0;
				amt_loss = getFloatSubstractData(sheetObj.CellValue(Row, "dpc_val_amt"),sheetObj.CellValue(Row, "wrtf_clt_amt"));
				sheetObj.CellValue2(Row, "amt_loss") = ComAddComma2((amt_loss + ""), "#,###");
				
				setCalculateTotalSum();
				if(Value == ""){
					sheetObj.CellValue2(Row, "del_chk") = 0;
					sheetObj.CellValue2(Row, "amt_loss") = sheetObj.CellValue(Row, "dpc_val_amt");
				}else{
					sheetObj.CellValue2(Row, "del_chk") = 1;
				}
			}
		}
	}
	 
	 /** 
	  * Collected AMT 에 따른 Check box 를 설정한다.
	  * 
	  * @param	{IBSheet}	sheetObj	시트오브젝트
	  * @param	{Int}		Row			Row
	  * @param	{String}	Col			Column
	  * @param	{String}	Val			Value
	  */
	 function h1sheet1_OnClick(sheetObj,Row,Col,Value) {
		 with(sheetObj) {
			 var colname = ColSaveName(Col);
	 			
			 if(colname == "wrtf_clt_amt") {
				sheetObj.CellValue2(Row, "del_chk") = 1;
			 }
		 }
	 }
	 

	/**
	 * Sheet1관련 프로세스 처리
	 * 
	 * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
	 * @param {Form}formObj 프로세스 처리될 폼오브젝트
	 * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		// 초기화
		case IBCLEAR:
			// 버튼 , 프로그레스바 설정 시작
			sheetObj.WaitImageVisible = false;
			MnrWaitControl(true);

			//조건부 콤보데이타 초기화
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll();	
			}
	
			// 모든 쉬트를 초기화
			for (i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].RemoveAll();
			}
					
			var sCondition = new Array (		 		 
				//MultiCombo  
				new Array("MnrGenCd","","CUSTOM9")
				    
			)				 			
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
										
			var comboDefValue = "";		
			//*** EQ_TYPE	
			if(comboList[0] != null){	
				formObj.eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');        
				for(var j = 1; j < comboList[0].length + 1;j++){ 
					var tempText = comboList[0][j - 1].split("|");	  
					formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}			    
			} 
			formObj.eq_knd_cd.Code = 'ALL'; 

			//초기값 설정
			formObj.wrtf_no.value		= "";					//Write Off No
			formObj.search_ttl_lss_no.value		= "";				//TLL No
			formObj.search_ttl_lss_no.readOnly 	= false;
			formObj.respb_ofc_cd.value			= ""; 					//Responsible\nOFC
			formObj.rqst_ofc_cd.value			= currOfcCd; 			//REQ OFC
			formObj.rqst_dt.value				= "";	//REQ DT
			formObj.eq_knd_cd.Index = 0;
			formObj.in_rqst_eq_no.value 			= "";
			formObj.ttl_lss_rsn_cd.value 		= "";
			formObj.ttl_lss_dtl_rsn_cd.value    = "";
			formObj.ttl_lss_dt.value			= "";	//TLL DT
			formObj.ttl_lss_dtl_rsn_rmk.value   = "";
			formObj.dpc_clt_fald_rsn_rmk.value   = "";
			formObj.rcvr_act_his_rmk.value   = "";
			
			formObj.dvAmtTtl.value = "";
			formObj.recveryAmtTtl.value = "";
			formObj.lossAmtTtl.value = "";


			formObj.search_ttl_lss_no.focus();
			uploadFileSeq = "";
			historyMnrStsRefNo = "";
			saveType = 1;
	
			// 버튼 , 프로그레스바 설정 끝
			MnrWaitControl(false);
			sheetObj.WaitImageVisible = true;
			nowLoad=0;

			break;
	
			//조회
		case IBSEARCH:      
			if(validateForm(sheetObj,formObj,sAction)) {
				//모든 쉬트를 초기화
				for (i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				
				sheetObj.WaitImageVisible = true;
				formObj.f_cmd.value = SEARCH;
				formObj.ttl_lss_no.value = formObj.search_ttl_lss_no.value;				
				
				var sXml = sheetObj.GetSearchXml("EES_MNR_0262GS.do", FormQueryString(formObj));			
				if(ComGetTotalRows(sXml)>0){
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){
						formObj.respb_ofc_cd.value = ComGetEtcData(sXml,"respb_ofc_cd");
						formObj.rqst_dt.value = ComGetEtcData(sXml,"rqst_dt");
						formObj.ttl_lss_rsn_cd.value = ComGetEtcData(sXml,"ttl_lss_rsn_cd");
						formObj.ttl_lss_dtl_rsn_cd.value = ComGetEtcData(sXml,"ttl_lss_dtl_rsn_cd");
						formObj.ttl_lss_dt.value = ComGetEtcData(sXml,"ttl_lss_dt");
						formObj.search_ttl_lss_no.value = ComGetEtcData(sXml,"ttl_lss_no");
						formObj.ttl_lss_no.value = formObj.search_ttl_lss_no.value;
						
						if(ComGetEtcData(sXml,"wrtf_no") == ""){
							formObj.wrtf_no.value = "NEW";
						}else{
							formObj.wrtf_no.value = ComGetEtcData(sXml,"wrtf_no");
						}
						formObj.ttl_lss_dtl_rsn_rmk.value = ComGetEtcData(sXml,"ttl_lss_dtl_rsn_rmk");
						formObj.dpc_clt_fald_rsn_rmk.value = ComGetEtcData(sXml,"dpc_clt_fald_rsn_rmk");
						formObj.rcvr_act_his_rmk.value = ComGetEtcData(sXml,"rcvr_act_his_rmk");
						formObj.wrtf_sts_cd.value = ComGetEtcData(sXml,"wrtf_sts_cd");
						
						formObj.file_seq.value = ComGetEtcData(sXml,"file_seq");
						formObj.sub_file_seq.value = ComGetEtcData(sXml,"sub_file_seq");
						formObj.mnr_sts_ref_no.value = ComGetEtcData(sXml,"mnr_sts_ref_no");
						
						sheetObj.LoadSearchXml(sXml);
						rqstFlg = "";
					}
				}else{
					if(rqstFlg == "Y"){
						doActionIBSheet(sheetObj,formObj,IBCLEAR,0);
						rqstFlg = "";
					}else{
						ComShowCodeMessage("MNR00377");
						doActionIBSheet(sheetObj,formObj,IBCLEAR,0);
					}
				}
				
			}
			break;
	
			//저장
		case IBSAVE:        
			if(nowLoad != 0) return;
			nowLoad=1;
			
			MnrWaitControl(true);
			if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
				formObj.f_cmd.value = MULTI;
				
				var sParam1 = sheetObjects[0].GetSaveString(true, true);
				sParam1 = ComSetPrifix(sParam1,"h1sheet1_");
				if(sParam1=="")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}

	
				var sParam2 = sheetObjects[2].GetSaveString(true, true);
						
				if(sParam2=="" && sheetObjects[2].RowCount > 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				if(uploadFileSeq != ""){
					formObj.sub_file_seq.value = uploadFileSeq;
				}

				else if (beforetab ==1){
					var mnrStsRefNo = "";
				}
				
				formObj.work_type.value = "SAVE";
				var sParam  = FormQueryString(formObj)+"&"+ sParam1 +"&"+ sParam2;
	
				if (sParam == "")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				sParam += "&" + FormQueryString(formObj);
				//ComDebug(sParam);
//				alert(uploadFileSeq);
				sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0262GS.do", sParam);	//Total Loss No 를 return 받는다.
				formObj.wrtf_no.value = ComGetEtcData(sSaveRtnXml,"wrtf_no");	
					
				// 2013-10-01 Jonghee HAN [CHM-201326903] Write-off request 신청 office 기준 변경 요청
				// 2013-11-01 Jonghee HAN [CHM-201327244] ALPS-MNR-TOTAL LOSS-WRITE OFF REQUST시 "Save" Button Click 시 경고 메시지 요청 MNR00395로 변경
				if(sActionIdx == 1){
					if (ComShowCodeConfirm("MNR00395"))
					{
						//Request 버튼 실행.
//						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 2);
						sActionIdx = 2;
					} 
				}
				
				if (sActionIdx == 2){
					formObj.work_type.value = "REQUEST";
					
					var sParam1 = sheetObjects[0].GetSaveString(true, true);
					sParam1 = ComSetPrifix(sParam1,"h1sheet1_");
					if(sParam1=="")
					{
						nowLoad=0;
						MnrWaitControl(false);
						return;
					}
	
					var sParam2 = sheetObjects[2].GetSaveString(true, true);
						
					if(sParam2=="" && sheetObjects[2].RowCount > 0)
					{
						nowLoad=0;
						MnrWaitControl(false);
						return;
					}
					formObj.sub_file_seq.value = uploadFileSeq;

					if (beforetab ==1){
						var mnrStsRefNo = "";
					}
					var sParam  = FormQueryString(formObj)+"&"+ sParam1 +"&"+ sParam2;
	
					if (sParam == "")
					{
						nowLoad=0;
						MnrWaitControl(false);
						return;
					}
					sParam += "&" + FormQueryString(formObj);

					sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0262GS.do", sParam);	//Total Loss No 를 return 받는다.
	
				}
				if(ComGetEtcData(sSaveRtnXml,"TRANS_RESULT_KEY")=="S"){
					ComShowCodeMessage("MNR00023"); 
					formObj.wrtf_no.value = ComGetEtcData(sSaveRtnXml,"wrtf_no");
					rqstFlg = "Y";
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
			}
			nowLoad=0;
			MnrWaitControl(false);
			break;
		
			//삭제  
        case IBSEARCHAPPEND:               
        	if(validateForm(sheetObj,formObj,sAction)) { 
        		MnrWaitControl(true);
				actionType = "IBSEARCHAPPEND";
        		formObj.f_cmd.value = REMOVE;		  
        		var sParam1 = sheetObjects[0].GetSaveString(true, true);
				sParam1 = ComSetPrifix(sParam1,"h1sheet1_");
			    sParam = sParam1 + "&" + FormQueryString(formObj);
			    sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0262GS.do", sParam);	
			 	
				if(ComGetEtcData(sSaveRtnXml,"TRANS_RESULT_KEY")=="S"){
					ComShowCodeMessage("MNR00020");
				}
				
			    formObj.eq_knd_cd.Code = 'ALL'; 

				//초기값 설정
				formObj.wrtf_no.value		= "";					//Write Off No
				formObj.search_ttl_lss_no.value		= "";				//TLL No
				formObj.search_ttl_lss_no.readOnly 	= false;
				formObj.respb_ofc_cd.value			= ""; 					//Responsible\nOFC
				formObj.rqst_ofc_cd.value			= currOfcCd; 			//REQ OFC
				formObj.rqst_dt.value				= "";	//REQ DT
				formObj.eq_knd_cd.Index = 0;
				formObj.in_rqst_eq_no.value 			= "";
				formObj.ttl_lss_rsn_cd.value 		= "";
				formObj.ttl_lss_dtl_rsn_cd.value    = "";
				formObj.ttl_lss_dt.value			= "";	//TLL DT
				formObj.ttl_lss_dtl_rsn_rmk.value   = "";
				formObj.dpc_clt_fald_rsn_rmk.value   = "";
				formObj.rcvr_act_his_rmk.value   = "";
				
				//total AMT초기화
				eval("document.form.dvAmtTtl.value = '';");
				eval("document.form.recveryAmtTtl.value = '';");
				eval("document.form.lossAmtTtl.value = '';");

				formObj.search_ttl_lss_no.focus();
				uploadFileSeq = "";
				historyMnrStsRefNo = "";
				saveType = 1;				
				
				// 모든 쉬트를 초기화	
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}	  
				MnrWaitControl(false);
        	}	
            break;	
			// Row 입력
		case IBINSERT:
			if(validateForm(sheetObj,formObj,sAction)) {
				var Row = sheetObj.DataInsert(-1);
				
				//Total Loss No 설정
				sheetObj.CellValue2(Row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
				//mnr_inv_tp_cd 설정
				if(sheetObj.id == 't1sheet1') {
					sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DV";
					sheetObj.CellValue2(Row, "ttl_lss_dtl_sts_cd") = "";
				} else if (sheetObj.id == 't2sheet1') {
					sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "TP";
				} else if (sheetObj.id == 't3sheet1') {
					sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DS";
				} else if (sheetObj.id == 't4sheet1') {
					sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "SC";
				} else if (sheetObj.id == 't5sheet1') {
					sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "IR";
					sheetObj.CellValue2(Row, "ttl_lss_plc_nm") = "";
						
				}	
				//그리드 콤보 값 초기화
				sheetObj.CellValue2(Row, "curr_cd") 			= "USD";	//CURR
			}
			break;
	
			//Row 삭제
		case IBDELETE:
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id=="t1sheet1")
				{
					var tabSheetIndex=1; //D.V Expense텝에 sheetObjects 처음 인덱스
		 			for(var i=sheetObjects[tabSheetIndex].HeaderRows; i<=sheetObjects[tabSheetIndex].LastRow; i++) 
					{
		 				if(sheetObjects[tabSheetIndex].CellValue(i,"del_chk")==1)
		 				{
		 					//D.V Expense 텝의  선택된 EQ No.
		 					var rqstEqNo=sheetObjects[tabSheetIndex].CellValue(i,"rqst_eq_no")
		 					
		 					
		 					//3rd Party,Disposal,Scrapping,Insurance 텝에서 rqstEqNo변수와 관련되거 체크
		 					for(var j=tabSheetIndex+1; j<=tabSheetIndex+4;j++)
				 			{
			 					var row=sheetObjects[j].FindText("rqst_eq_no", rqstEqNo);
			 					if(row > 0)
			 					{
				 					sheetObjects[j].CellValue(row,"del_chk")="1";
				 					ComRowHideDelete(sheetObjects[j], "del_chk");
			 					}
				 			}
		 				}
					}
		 			ComRowHideDelete(sheetObjects[tabSheetIndex], "del_chk");
				}else{
					ComRowHideDelete(sheetObj, "del_chk");
				}
			}    
			break;
	
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction,sActionIdx){
		with(formObj){
			//행추가시 		
			if (sAction == IBINSERT) {	
				var dvTabRowCnt = sheetObjects[1].RowCount - sheetObjects[1].RowCount("D");
				var chkTabRowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
				if(dvTabRowCnt <= chkTabRowCnt){	
					ComShowCodeMessage("MNR00339");  		
					return false;	   								
				}	  	 
			}
			// 조회시 체크
			else if (sAction == IBSEARCH) {
				// Dataformat
				if (!ComChkValid(formObj)) {
					return false;
				}
				
				if(ComTrim(ComGetObjValue(formObj.search_ttl_lss_no)) == "" && ComTrim(ComGetObjValue(formObj.in_rqst_eq_no)) == ""){
					ComShowCodeMessage("MNR00003","TTL NO or EQ NO");   
					return false;							
				}
				
			}
			//저장(요청)시
			else if(sAction == IBSAVE) {
				if(!checkMandatory(formObj.ttl_lss_dtl_rsn_rmk, "Detail Reason of Total Loss")) {return false;}
				if(!checkMandatory(formObj.dpc_clt_fald_rsn_rmk, "Reason of Collection Failure/DV Discount")) {return false;}
				if(!checkMandatory(formObj.rcvr_act_his_rmk, "Recovery Action History/Counter Measure")) {return false;}
				
				if(sActionIdx == 1){
					var check = false;
					
					for(var i = 1; i<sheetObjects[0].RowCount+1; i++){
						if(sheetObjects[0].CellValue(i, "del_chk") == 1){
							if(sheetObjects[0].CellValue(i, "wrtf_clt_amt") == ""){
								ComShowCodeMessage("MNR00003","Row["+ i + "]Collected AMT");
								sheetObjects[0].SelectCell(i, "wrtf_clt_amt");
								return false;
							}
							check = true;
							sheetObjects[0].CellValue(i, "ibflag") = "U";
						}
					}
					
					if(check == false){
						ComShowCodeMessage("MNR00380");
						return false;
					}
					
					
					for(var i = 0; i < 3; i++){
						if(sheetObjects[i].IsDataModified){
							check = true;
						}
					}
	
					if(check == false){
						if(formObj.ttl_lss_dtl_rsn_rmk.value == ttlLssDtlRsnRmk 
								&& formObj.dpc_clt_fald_rsn_rmk.value == dpcCltFaldRsnRmk 
								&& formObj.rcvr_act_his_rmk.value == rcvrActHisRmk){
							ComShowCodeMessage("MNR00369");
							return false;
						}
					}
						
					if(sheetObjects[2].CellValue(1, "apro_rmk") == ""){
						ComShowCodeMessage("MNR00003","Remarks");
						tab1_OnChange(tabObjects[0] , 0);
						sheetObjects[2].SelectCell(1, "apro_rmk");
						return false;
					}
					
					for(var i = 1; i<sheetObjects[2].RowCount+1; i++){
						if(sheetObjects[2].CellValue(i, "ofc_cd") == ""){
							ComShowCodeMessage("MNR00393", "Approval Step");
							return false;
						}
					}
					
					if(!ComShowCodeConfirm("MNR00160")){
						return false;
					}
				}else if(sActionIdx == 2){
					var check = false;
					
					for(var i = 1; i<sheetObjects[0].RowCount+1; i++){
						if(sheetObjects[0].CellValue(i, "del_chk") == 1){
							if(sheetObjects[0].CellValue(i, "wrtf_clt_amt") == ""){
								ComShowCodeMessage("MNR00003","Row["+ i + "]Collected AMT");
								sheetObjects[0].SelectCell(i, "wrtf_clt_amt");
								return false;
							}
							check = true;
							sheetObjects[0].CellValue(i, "ibflag") = "U";
						}
					}
					
					for(var i = 0; i < 3; i++){
						if(sheetObjects[i].IsDataModified){
							check = true;
						}
					}
						
					if(sheetObjects[2].CellValue(1, "apro_rmk") == ""){
						ComShowCodeMessage("MNR00003","Remarks");
						tab1_OnChange(tabObjects[0] , 0);
						sheetObjects[2].SelectCell(1, "apro_rmk");
						return false;
					}
					
					for(var i = 1; i<sheetObjects[2].RowCount+1; i++){
						if(sheetObjects[2].CellValue(i, "ofc_cd") == ""){
							ComShowCodeMessage("MNR00393", "Approval Step");
							return false;
						}
					}
					
					if(!ComShowCodeConfirm("MNR00212")){
						return false;
					}
				}
				
				
			}
			//삭제시	 
			else if(sAction == IBSEARCHAPPEND) {  
				var check = false;
				for(var i = 1; i < sheetObj.RowCount+1; i++){
					if(sheetObj.CellValue(i, "wrtf_no")!= ""){
						check = true;
					}
				}
				
				if(check==false){
					ComShowCodeMessage("MNR00378");  		
					return false;
				}
				
				if (!ComShowCodeConfirm("MNR00275","Write Off","Delete")){return false;} 
			}
		}
		return true;
	}


	/**
	 * EES_MNR_0195 Popup의 값을 받은 함수      
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
		var formObj = document.form; 
	
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.search_ttl_lss_no.value = aryPopupData[0][4];
			formObj.ttl_lss_no.value = aryPopupData[0][4];
		}
//	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH); 
	}

	/**
	 * IBSheet의 file upload 할 Row를 추가한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Insert(sheetObj){ 
		uploadFileSeq = sheetObj.CellValue(2,"file_seq");
	
		if(uploadFileSeq == undefined){ 	 
			uploadFileSeq = "";	
		}
	
		for(var j = 2; j <= sheetObj.LastRow;j++){ 
			if (sheetObj.CellValue(j,"org_file_nm") == ""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(j,"org_file_nm");  
				return;      
			} 	
		} 
		var row = sheetObj.DataInsert(-1); 
	}
	
	/**
	 * IBSheet의 file upload 할 Row를 삭제한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Remove(sheetObj) { 		  
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);	         	 		
		} else {			      
			ComShowCodeMessage("MNR00150");   	   
		}	 
	}	
	
	 /**
	  * 파일 선택하기 <br>
	  * @param {ibsheet} sheetObj    IBSheet Object
	  * @param {ibsheet} Row     	sheetObj의 선택된 Row
	  * @param {ibsheet} Col     	sheetObj의 선택된 Col
	  **/
	function t1sheet1_OnPopupClick(sheetObj,Row,Col){
		var upObj = uploadObjects[0];         
		var prefix = "";			
		var fileName = sheetObj.OpenFileDialog("파일선택");
		
		var badFile = false;
		if(fileName.indexOf("\\") == -1) {  
			badFile = true;		
		} else {
			var relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1); 
			var fileType = 	relativePath.substr(relativePath.lastIndexOf(".") + 1);
			fileType = fileType.toUpperCase();
			//GIF, BMP, TIFF, JPG 
			//if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG"){
			badFile = false; 	
			//} 
		}
		
		if(!badFile) {  
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
			sParam+= "&mnr_grp_tp_cd=WTF";       // MNR Work Group Type Code				
			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
		
			upObj.ExtendParam = sParam;
		
			var sXml = upObj.DoUpload(true);
		
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
		
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[1],uploadFileSeq);
				sheetObjects[1].LoadSearchXml(fileXml);   				
			}	  
		} else {
			ComShowCodeMessage("MNR00217");     	 
		}
	}
		
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function t1sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
		
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function t2sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
	
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
	
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
	
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
	
	/**
	 * 저장시 필수 체크
	 * @param	{Element}	obj	체크할 Form Element
	 */
	function checkMandatory(obj, name) {
		if(ComIsEmpty(ComGetObjValue(obj))) {  
			ComShowCodeMessage("MNR00003", name);
			
			obj.focus();
			return false;
		}
		return true;
	}

	/**
	 * Total Loss History 의 Row 추가
	 * 
	 * @param sheetObj
	 * @return
	 */
	function history_Insert(sheetObj) {
		var Row = sheetObj.DataInsert(-1);
		if(historyMnrStsRefNo=="" || historyMnrStsRefNo==null){
			sheetObj.CellValue(Row, "mnr_sts_ref_no") = "NEW";	
		} else {
			sheetObj.CellValue(Row, "mnr_sts_ref_no") = historyMnrStsRefNo;
		}
		sheetObj.CellValue(Row, "mnr_grp_tp_cd") = "SCR";
		sheetObj.CellValue(Row, "mnr_sts_dt") = ComGetNowInfo("ymd");
		sheetObj.CellValue(Row, "rqst_ofc_cd") = currOfcCd;
		sheetObj.CellValue(Row, "cre_usr_id") = usrId;

	}

	/**
	 * Total Loss History 의 Row 삭제
	 * 
	 * @param sheetObj
	 * @return
	 */
	function history_Remove(sheetObj) {
		ComRowHideDelete(sheetObj, "del_chk");
	}