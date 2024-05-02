	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0095.js
	 *@FileTitle : Total Loss Request
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.16
	 *@LastModifier : WanGyu Kim
	 *@LastVersion : 1.0
	 * 2009.09.16 WanGyu Kim
	 * 2009.11.01 YoungBueb Kwon 
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * 2011.06.09 김민수 [CHM-201111285-01] [MNR] Total Loss 의 하단 Grid 의 D.V Expense , 3rd Party , Disposal 만 존재하게 하고, Scrapping ,Insurance 탭 삭제 요청
	 * 2011.06.23 김종옥 [CHM-201111741-01] Save 후 Request 진행 여부 확인 체크 
	 * 2011.08.09 신혜정 [CHM-201112812-01] TOTAL LOSS REQUEST 시 REASON 옵션 변경
	 * 2012.04.17 신혜정 [CHM-201217355] 3rd Party 리스트내 SCAC Code 항목 추가
	 *                                   [Save], [Request]시 Sub Reason 이 Trucker 일 경우 필수 항목 체크
	 * 2012.05.02 신혜정 [CHM-201217379] Disposal 리스트내 buyer Code, buyer name 항목 추가                                  
	 * 2012.06.26 김창헌 [CHM-201218561-01] 3rd Party 탭에서 SCAC Code를 입력 가능한 조건 추가
	 * 2013.07.23 조경완 [CHM-201325776-01] ALPS MNR-Total - Total Loss Request시에 TLL DATE에 대한 Validation 구현 요청
	 * 2014-02-24 Jonghee HAN [CHM-201429040] Total loss request 시 Currency 수정 제한 요청
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
	 * @class ees_mnr_0095 : ees_mnr_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0095() {
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
	//Total Loss By Accident일 경우 Y
	var page_separator = "";
	
	
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
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];
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
				//RES Office. PopUp
			case "respb_ofc_cd_popup":
				ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_COM_ENS_071', '1,0', true);
				break;						
	
				//TLL DT Calendar
			case "ttl_lss_dt_cal":
				var cal = new ComCalendar();
				cal.select(formObject.ttl_lss_dt, 'yyyy-MM-dd');
				break;
				
				//Accident DT(선박사고) Calendar
			case "acc_dt_cal":
				var cal = new ComCalendar();
				cal.select(formObject.acc_dt, 'yyyy-MM-dd');
				break;
	
				/** (Tab) D.V Expense (S) **/
			case "btn_t1EQAdd":
				ComOpenPopup('/hanjin/EES_MNR_0097.do', 800, 460, 'setEES_MNR_0097', '1,0', true);
				break;
				
			case "btn_t1RowAdd":
				doActionIBSheet(sheetObject2,document.form,IBINSERT);
				break;
	
			case "btn_t1RowDel":
				doActionIBSheet(sheetObject2,document.form,IBDELETE);
				break;
				/** (Tab) D.V Expense (E) **/
	
				/** (Tab) 3rd Party (S) **/
			case "btn_t2RowAdd":
				doActionIBSheet(sheetObject3,document.form,IBINSERT);
				break;
	
			case "btn_t2RowDel":
				doActionIBSheet(sheetObject3,document.form,IBDELETE);
				break;
				/** (Tab) 3rd Party (E) **/
	
				/** (Tab) Disposal (S) **/
			case "btn_t3RowAdd":
				doActionIBSheet(sheetObject4,document.form,IBINSERT);
				break;
	
			case "btn_t3RowDel":
				doActionIBSheet(sheetObject4,document.form,IBDELETE);
				break;
				/** (Tab) Disposal (E) **/
	
				/** (Tab) Scrapping (S) **/
			case "btn_t4RowAdd":
				doActionIBSheet(sheetObject5,document.form,IBINSERT);
				break;
	
			case "btn_t4RowDel":
				doActionIBSheet(sheetObject5,document.form,IBDELETE);
				break;
				/** (Tab) Scrapping (E) **/
	
				/** (Tab) Insurance (S) **/
			case "btn_t5RowAdd":
				doActionIBSheet(sheetObject6,document.form,IBINSERT);
				break;
	
			case "btn_t5RowDel":
				doActionIBSheet(sheetObject6,document.form,IBDELETE);
				break;
				/** (Tab) Insurance (E) **/
	
			case "btn_RowAdd2":
				history_Insert(sheetObject7);
				break;
	
			case "btn_RowDel2":
				history_Remove(sheetObject7);
				break;
	
			case "btn_FileAdd":
				file_Insert(sheetObjects[7]);
				break;
	
			case "btn_FileDel":
				file_Remove(sheetObjects[7]); 
				break;
				
			case "btn_vvd_search":
				var vslCd = formObject.acc_vsl_cd.value;
            	var sUrl = "";
            	
            	if(vslCd == ""){
            		sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + vslCd + "&inc_del_vsl_pop=Y";
            		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
            	}else{
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
            	}
				break;
				
			case "btn_port":
				sUrl = "/hanjin/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
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
	
		// IBSheet 초기화
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		// IBTab 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
	
		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
		
		//로그인 Office의 지역이 US인지 체크
		var sParam = 'f_cmd=' + SEARCH01 + '&rqst_ofc_cd=' + currOfcCd;
		var sXml = sheetObjects[0].GetSearchXml("EES_MNR_0095GS.do", sParam);
		currOfcUS = ComGetEtcData(sXml, "chkUS");
		
		
//		if(document.location.href.split("?")[0].match("EES_MNR_0099.do")){
//			page_separator = "Y" // Total Loss By Accident
//			document.form.page_separator.value = "Y";
//			
//			ByAccident.style.visibility = "visible";
//			document.form.acc_flg.value = "Y";
//			
//			document.form.ttl_lss_rsn_cd.Code	  = "TRS";
////			document.form.ttl_lss_dtl_rsn_cd.Code = "AAC";
//			
//			document.form.acc_dt.value   		  = ComGetNowInfo("ymd");	//Accident DT(선박 사고 날짜)
//			
//		}
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
		case "sheet1":
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
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "||||||||||||||||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"respb_ofc_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_ofc_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"rqst_dt");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_sts_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_rsn_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dtl_rsn_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"ttl_lss_dt");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_dt");
				InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"acc_flg");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_vsl_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_skd_voy_no");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_skd_dir_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"acc_port_cd");
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"file_seq");	                
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"mnr_sts_ref_no");	     
				InitDataProperty(0, cnt++ , dtData,			30,	daLeft,		true,	"respb_ofc_nm");
				CountPosition = 0;
			}
			break;
	
		case "t1sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Invoice No.|CURR|Pay Amount|EQ Status|Remark";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 21, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	true,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true,	7);
				InitDataProperty(0, cnt++ , dtData,			95,		daRight,	true,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	false,	false); // 2014-02-24 by Jonghee HAN D.V Expense Currency 변경 못하도록 변경
				InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	false,	false,	13);
				InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		true,	"ttl_lss_dtl_sts_cd",	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true,	4000);
				//Hidden
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
				
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
				
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"disp_no",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"inv_rgst_no");
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);

				InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);
				InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"buyer_code",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"buyer_name",			false,	"",	dfNone,			0,	false,	false);				

				//데이터 Validation
				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
				MessageText("Sum") = "Total";
				CountPosition = 0;
			}
			break;
	
		case "t2sheet1": // 3rd Party
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);

				var HeadTitle1 = "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Payer Code|Payer Name|SCAC Code|CURR|3rd Amount|Issue Date|Remark";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 15, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	true,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true,	7);
				InitDataProperty(0, cnt++ , dtData,			0,		daRight,	true,	"dpc_val_amt",			false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtCombo,		100,	daLeft,		true,	"ttl_lss_n3pty_tp_cd",	true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"payer_code",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"payer_name",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",				true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtPopupEditFormat,80, 	daCenter,  	true,   "ttl_lss_bil_dt",     	true,   "", dfDateYmd,		0,	true,	true); 
				//InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"n3pty_no",				false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true,	4000);
				//Hidden 
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_cnt_cd");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_prnr_seq");
				
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_incm_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"disp_no",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
					
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		85,		daCenter,	true,	"buyer_code",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"buyer_name",			false,	"",	dfNone,			0,	false,	false);				
				
				//데이터 Validation	
				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "usa_edi_cd", vtEngUpOther,"0123456789");
				
				ImageList(0) = "/hanjin/img/btns_search.gif";
  				ImageList(1) = "/hanjin/img/btns_calendar.gif";
				
				PopupButtonImage(0, "payer_code") = 0;
  				PopupButtonImage(0, "ttl_lss_bil_dt") = 1; 
  				  														 
				ShowButtonImage = 2;  		  				 
				MessageText("Sum") = "Total";
				ColHidden("dpc_val_amt")=true;
				CountPosition = 0;
			}
			break;
	
		case "t3sheet1": // Disposal
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|Buyer Code|Buyer Name|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 12, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,			35, 	daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	true,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
                InitDataProperty(0, cnt++ , dtPopup,		85,		daCenter,	true,	"buyer_code",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"buyer_name",		false,	"",	dfNone,			0,	false,	false);				
                InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"disp_no",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,	true,	"ttl_lss_bil_amt",	false,	"",	dfNullFloat,	2,	false,	false,	13);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	120,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);
				//Hidden
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		95,		daRight,	true,	"ttl_lss_expn_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",				true,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",			false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",		false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	"csr_no");
					
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"usa_edi_cd",			true,	"",	dfNone,			0,	true,	true, 4);
				
				//데이터 Validation
				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
				MessageText("Sum") = "Total";
				
				PopupImage  =  "img/btns_search.gif"; 
				ShowButtonImage = 2;

				CountPosition = 0;
			}
			break;
	
		case "t4sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 10, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	true,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"csr_no",			false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	160,	daRight,	true,	"ttl_lss_incm_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	150,	daRight,	true,	"ttl_lss_expn_amt",	false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);
				//Hidden
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"inv_no",			true,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"dpc_val_amt",		true,	"",	dfNullFloat,	2,	true,	true,	13);
				
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ar_chk_no",		false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"ttl_lss_plc_nm",	false,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	"ttl_lss_bil_amt",	true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daCenter,	true,	"cr_end_dt",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
				//데이터 Validation
				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
				MessageText("Sum") = "Total";
				CountPosition = 0;
			}
			break;
	
		case "t5sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Notification Date|Remark";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 5, 0, 0, true);
							
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	true,	"del_chk",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,			35,	daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtCombo,		70,	daLeft,		true,	"eq_knd_cd",		true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	true,	"rqst_eq_no",		true,	"",	dfNone,			0,	true,	true,	14);
				InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"lstm_cd",			true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"ttl_lss_yd_cd",	true,	"",	dfNone,			0,	true,	true,	7);
				InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"dpc_val_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"inv_no",			true,	"",	dfNone,			0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtCombo,		50,	daCenter,	true,	"curr_cd",			true,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtCombo,		90,	daCenter,	true,	"ttl_lss_plc_nm",	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	95,	daRight,	true,	"ttl_lss_expn_amt",	true,	"",	dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtPopupEdit,	115,daCenter,	true,	"cr_end_dt",	    false,	"",	dfDateYmd,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			50,	daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	true,	true,	4000);
				//Hidden
				InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"ttl_lss_no");
				InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"ttl_lss_dtl_seq");
				InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"mnr_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,		90,	daCenter,	true,	"csr_no");
				InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		true,	"ttl_lss_bil_dt",		false,	"",	dfNone,			0,	false,	false);
						
				//데이터 Validation
				InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");  
				InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");  
				MessageText("Sum") = "Total";
				ColHidden("dpc_val_amt")=true;
				PopupImage  =  "img/btns_calendar.gif"; 
				ShowButtonImage = 2;
				CountPosition = 0;
			}
			break;
	
		case "sheet2":
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
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle1 = "|Sel|Date|Remark(s)|Creation Office|Creation User";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 3, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",		false,	"",	dfNone,		0,	true,	true);
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
	
		case "sheet3":
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
				InitHeadMode(true, true, false, true, false,false);
	
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
				InsertTab( cnt++ , "D.V Expense", -1 );
				InsertTab( cnt++ , "3rd Party", -1 );
				InsertTab( cnt++ , "Disposal", -1 );
				//InsertTab( cnt++ , "Scrapping", -1 );
				//InsertTab( cnt++ , "Insurance", -1 );
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
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab= nItem;
		if(nowLoad!=1)
		{
			setCalculateTotalSum();
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
		if(Index_Code == "TRU"){ // Total Loss By Accident에서 Main Reason이 Uncollected Cargo일 경우 VVD와 Port를 입력받지 않는다.
			document.form.acc_vsl_cd.readOnly = true;
			document.form.acc_vsl_cd.className = "input2";
			document.form.acc_skd_voy_no.readOnly = true;
			document.form.acc_skd_voy_no.className = "input2";
			document.form.acc_skd_dir_cd.readOnly = true;
			document.form.acc_skd_dir_cd.className = "input2";
			
			document.form.acc_port_cd.readOnly = true;
			document.form.acc_port_cd.className = "input2";
			
			document.form.acc_vsl_cd.value = "";
			document.form.acc_skd_voy_no.value = "";
			document.form.acc_skd_dir_cd.value = "";
			document.form.acc_port_cd.value = "";
			
		} else {
			document.form.acc_vsl_cd.readOnly = false;
			document.form.acc_vsl_cd.className = "input1";
			document.form.acc_skd_voy_no.readOnly = false;
			document.form.acc_skd_voy_no.className = "input1";
			document.form.acc_skd_dir_cd.readOnly = false;
			document.form.acc_skd_dir_cd.className = "input1";
			
			document.form.acc_port_cd.readOnly = false;
			document.form.acc_port_cd.className = "input1";
		}
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
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			var formObj = document.form;
			tabObjects[0].SelectedIndex=0;
			//TLL No 형식변경
			formObj.search_ttl_lss_no.readOnly = true;
			formObj.search_ttl_lss_no.className = "input2";
	
			//Header 값 설정
			var respbOfcCd		= sheetObj.CellValue(sheetObj.HeaderRows, "respb_ofc_cd");			//Responsible\nOFC
			var respbOfcNm		= sheetObj.CellValue(sheetObj.HeaderRows, "respb_ofc_nm");			//Responsible\nOFC
			var rqstOfcCd		= sheetObj.CellValue(sheetObj.HeaderRows, "rqst_ofc_cd");			//REQ OFC
			var rqstDt			= sheetObj.CellValue(sheetObj.HeaderRows, "rqst_dt"); 				//REQ DT
			var ttlLssStsCd		= sheetObj.CellValue(sheetObj.HeaderRows, "ttl_lss_sts_cd");		//Status
			var ttlLssRsnCd		= sheetObj.CellValue(sheetObj.HeaderRows, "ttl_lss_rsn_cd");		//Main Reason
			var ttlLssDtlRsnCd	= sheetObj.CellValue(sheetObj.HeaderRows, "ttl_lss_dtl_rsn_cd");	//Sub Reason
			var ttlLssDt		= sheetObj.CellValue(sheetObj.HeaderRows, "ttl_lss_dt");			//TLL DT
			var aproOfcCd		= sheetObj.CellValue(sheetObj.HeaderRows, "apro_ofc_cd");			//APP OFC
			var fileSeq 		= sheetObj.CellValue(sheetObj.HeaderRows, "file_seq");				//File Seq
			var mnrStsRefNo		= sheetObj.CellValue(sheetObj.HeaderRows, "mnr_sts_ref_no");		//mnr_sts_ref_no
			var accDt			= sheetObj.CellValue(sheetObj.HeaderRows, "acc_dt");				//Accident DT(사고 날짜)
			var accVslCd		= sheetObj.CellValue(sheetObj.HeaderRows, "acc_vsl_cd");			//Accident Vessel Code(사고가 난 Vessel Code)
			var accSkdVoyNo		= sheetObj.CellValue(sheetObj.HeaderRows, "acc_skd_voy_no");		//Accident Schedule Voyage Number(사고 난 선박의 skd_voy_no)
			var accSkdDirCd		= sheetObj.CellValue(sheetObj.HeaderRows, "acc_skd_dir_cd");		//Accident Schedule Direction Code(사고 난 선박의 skd_dir_cd)
			var accPortCd		= sheetObj.CellValue(sheetObj.HeaderRows, "acc_port_cd");			//Accident Port(사고 난 포트)
			formObj.respb_ofc_cd.value		= respbOfcCd;		//Responsible\nOFC
			formObj.respb_ofc_nm.value		= respbOfcNm;		//Responsible\nOFC NM
			formObj.rqst_ofc_cd.value		= rqstOfcCd;		//REQ OFC
			formObj.rqst_dt.value 			= rqstDt; 			//REQ DT
			formObj.ttl_lss_sts_cd.Code		= ttlLssStsCd; 		//Status
			formObj.ttl_lss_rsn_cd.Code		= ttlLssRsnCd; 		//Main Reason
			formObj.ttl_lss_dtl_rsn_cd.Code	= ttlLssDtlRsnCd;	//Sub Reason
			formObj.ttl_lss_dt.value		= ttlLssDt;			//TLL DT
			formObj.apro_ofc_cd.value		= aproOfcCd;		//APP OFC
			formObj.file_seq.value	    	= fileSeq;		    //File Seq
			formObj.ttl_lss_no.value	    = formObj.search_ttl_lss_no.value;  //ttl_lss_no
			formObj.acc_dt.value	 	    = accDt; 			//Accident DT(선박 사고 날짜)
			formObj.acc_vsl_cd.value	    = accVslCd; 		//Accident Vessel Code(사고가 난 Vessel Code)
			formObj.acc_skd_voy_no.value    = accSkdVoyNo; 		//Accident Schedule Voyage Number(사고 난 선박의 skd_voy_no)
			formObj.acc_skd_dir_cd.value    = accSkdDirCd; 		//Accident Schedule Direction Code(사고 난 선박의 skd_dir_cd)
			formObj.acc_port_cd.value	    = accPortCd; 		//Accident Port(사고 난 포트)
			
			uploadFileSeq=fileSeq; //File Seq
			
			//파일 리스트 조회 
			if(fileSeq != "" && fileSeq != null){ 
				var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[7].LoadSearchXml(fileXml);	
				}
			}
			//History 리스트 조회
			if(mnrStsRefNo != "" && mnrStsRefNo != null){
				historyMnrStsRefNo = mnrStsRefNo;
				var sXml = MnrStatusHistorySearch(sheetObjects[6], mnrStsRefNo);
				sheetObjects[6].LoadSearchXml(sXml);
			}
			//Status 에 따른 버튼설정
			if(ttlLssStsCd == 'HR') {
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Request");
				ComBtnDisable("btn_t1EQAdd");
				ComBtnDisable("btn_t1RowDel");
				ComBtnDisable("btn_t2RowDel");
				ComBtnDisable("btn_t3RowDel");
				ComBtnDisable("btn_t4RowDel");
				ComBtnDisable("btn_t5RowDel");
				ComBtnDisable("btn_RowAdd2");
				ComBtnDisable("btn_RowDel2");
				ComBtnDisable("btn_FileAdd");
				ComBtnDisable("btn_FileDel");
			} else {
				ComBtnEnable("btn_Save");
				ComBtnEnable("btn_Delete");
				ComBtnEnable("btn_Request");
				ComBtnEnable("btn_t1EQAdd");
				ComBtnEnable("btn_t1RowDel");
				ComBtnEnable("btn_t2RowDel");
				ComBtnEnable("btn_t3RowDel");
				ComBtnEnable("btn_t4RowDel");
				ComBtnEnable("btn_t5RowDel");
				ComBtnEnable("btn_RowAdd2");
				ComBtnEnable("btn_RowDel2");
				ComBtnEnable("btn_FileAdd");
				ComBtnEnable("btn_FileDel");
			}
	
		} else {
			doActionIBSheet(sheetObj,document.form,IBCLEAR,1);
		}
	}
	
	/** 
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}
	
	/** 
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 
		sheetObjects[2].Redraw = false;
		if(("Trucker" == ComTrim(document.form.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){
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
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}
	
	/** 
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}
	
	/** 
	 * 조회후 합계값 설정 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
	}
	
	/** 
	 * 쉬트 팝업 클릭시 발생하는 이벤트 
	 *     Payer Code,Responsible\nOFC 의 팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "ttl_lss_bil_dt"){
			var cal = new ComCalendarGrid();	   	   
        	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		} else {				
			var ttlLssN3ptyTpCd = sheetObj.CellValue(Row, "ttl_lss_n3pty_tp_cd");
			//service provider
			if(ttlLssN3ptyTpCd == "S") {
				ComOpenPopup("/hanjin/COM_ENS_0C1.do", 700, 450, 'setServiceProvider', '1,0', true); 
			//coustomer
			} else if(ttlLssN3ptyTpCd == "C") {
	
				ComOpenPopup("/hanjin/COM_ENS_041.do", 770, 520, 'setCustomer', '1,0', true); 
	
			} else if(ttlLssN3ptyTpCd == "O") {
				ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 450, 'setCOM_ENS_071', '1,0', true); 
			}
		}
	}
	 
	/** 
	 * 쉬트 실랙트시 발생하는 이벤트 
	 *     Payer Code 의 팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var ttlLssN3ptyTpCd = sheetObj.CellValue(NewRow, "ttl_lss_n3pty_tp_cd");
		//service provider
		if(ttlLssN3ptyTpCd == "O") {
			sheetObj.CellEditable(NewRow, "payer_code") =false;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =true;
		}else if(ttlLssN3ptyTpCd == "N") {
			sheetObj.CellEditable(NewRow, "payer_code") =false;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
		}else{
			
			sheetObj.CellEditable(NewRow, "payer_code") =true;
			sheetObj.CellEditable(NewRow, "respb_ofc_cd") =false;
		}
		if(("Trucker" == ComTrim(document.form.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){
			sheetObj.CellEditable(NewRow, "usa_edi_cd") = true;
			sheetObj.CellBackColor(NewRow, "usa_edi_cd") = -1;
		}else{
			sheetObj.CellEditable(NewRow, "usa_edi_cd") = false;
			sheetObj.CellBackColor(NewRow, "usa_edi_cd") = -1;
		}		
	}
	 
	/** 
	 * 쉬트 실랙트시 발생하는 이벤트 
	 *    Disposal Plan Amt 수정가능여부
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var ttlLssBilAmt = sheetObj.CellValue(NewRow, "ttl_lss_bil_amt");
		//service provider
		if(ttlLssBilAmt == "" || ttlLssBilAmt == "0") {
			sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =true;
		}else{	
			sheetObj.CellEditable(NewRow, "ttl_lss_incm_amt") =false;
		}		
	}	
	
	/** 
	 * 쉬트 팝업 클릭시 발생하는 이벤트 
	 *     Buyer Code 의 팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t3sheet1_OnPopupClick(sheetObj, Row,Col){
		if(sheetObj.ColSaveName(Col) == "buyer_code"){
			// buyer code 조회 팝업 띄우기(service provider)
			ComOpenPopup("/hanjin/COM_ENS_0C1.do", 700, 450, 'setServiceProviderBuyer', '1,0', true);
		}
	}
	
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type	
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}	
			//Yard Cd
			else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
			}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			
			if (colname == "dpc_val_amt"){
				sheetObj.CellValue(Row,"ttl_lss_bil_amt") =  sheetObj.CellValue(Row,"dpc_val_amt");
			}
		}
	}
	
	 
	/** 
	 * 	셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 *     Payer Type 을 변경함에 따라 Payer Code와 Payer Name을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				//중복인지 체크 
				var chkRow = sheetObj.ColValueDup("rqst_eq_no");
				if(chkRow > 0 && sheetObj.RowStatus(chkRow) != "D"){		 
					ComShowCodeMessage("MNR00006",sheetObj.CellValue(Row,"rqst_eq_no"));
					sheetObj.CellValue2(Row, "rqst_eq_no")=""; 
					sheetObj.SelectCell(Row, "rqst_eq_no", true);       
					return false;    
				//DV에 존재 하는 EQ인지 체크 
				} else {		
					var chkFlag = false;
					for(var j = sheetObjects[1].HeaderRows; j <= sheetObjects[1].LastRow; j++) {	
						if(sheetObjects[1].RowStatus(j) != "D" && (sheetObjects[1].CellValue(j,"rqst_eq_no") == sheetObj.CellValue(Row,"rqst_eq_no"))){  
							//DV에 존재 하는 EQ이면 true
							chkFlag = true;		
						}				      
					}			
								
					if(!chkFlag){					
						ComShowCodeMessage("MNR00339");
						sheetObj.CellValue2(Row, "rqst_eq_no")="";	 	
						sheetObj.SelectCell(Row, "rqst_eq_no", true);			
						return false;			
					} 			
				}	
				setEqNoInfo(sheetObj,Row,Col);
			}
			//RES_OFC
			else if(colname == 'respb_ofc_cd') {
				setOfficeInfo(sheetObj,Row, Col, Value);
			}
			
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Payer Type
			else if(colname=='ttl_lss_n3pty_tp_cd'){
				var payerCode = sheetObj.CellValue(Row, "payer_code");
				if(payerCode != '') {
					//데이터가 초기화됩니다.그래도 변경하시겠습니까?
					if(!ComShowCodeConfirm("MNR00192")) { 
							sheetObj.ReturnCellData(Row,Col);
					return;
					}
					
				}
				if(Value=="O")
				{
					sheetObj.CellValue(Row, "mnr_prnr_seq") = "";
					sheetObj.CellValue(Row, "payer_name") = "";		
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellEditable(Row, "payer_code") = false;
				}else if(Value=="N") {
					sheetObj.CellValue(Row, "mnr_prnr_seq") = "";
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";		
					sheetObj.CellEditable(Row, "payer_code") = false;
				}else{
					sheetObj.CellValue(Row, "mnr_prnr_seq") = "";
					sheetObj.CellValue(Row, "payer_code") = "";
					sheetObj.CellValue(Row, "payer_name") = "";		
					sheetObj.CellEditable(Row, "payer_code") = true;
				}
			}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
		}
	}	
	
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Disposal Amt
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Disposal Plan Amt
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
		}
	}
	
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Scrapping Income AMT
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
			//Scrapping Cost AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
	
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Request AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
		/** 
		 * 셀의 팝업 클릭시 Event
		 *     Notification Date을 재설정한다.
		 * 
		 * @param	{IBSheet}	sheetObj	시트오브젝트
		 * @param	{Int}		Row			Row
		 * @param	{String}	Col			Column
		 * @param	{String}	Val			Value
		 */
	    function t5sheet1_OnPopupClick(sheetObj, Row,Col,Value){
	    	
			 var formObject = document.form;
			   with(sheetObj) {
					var sName = ColSaveName(Col);
		        	switch (sName) {
						case "cr_end_dt":
						 var cal = new ComCalendarGrid("myCal");
					      cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
						break;
					}
		 		}
		}	 
	 
	/** 
	 * 쉬트 팝업 클릭시 발생하는 이벤트 
	 *     Date 의 달력팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) != "mnr_sts_dt") return;
		var cal = new ComCalendarGrid();       
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');  
	}
	
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		 var formObj=document.form;
		if (ErrMsg == "") {
			//Remove
			if(formObj.f_cmd.value == REMOVE)
			{
				ComShowCodeMessage("MNR00020"); 
			} 
			//Request
			else if(saveType == 2) {
				ComShowCodeMessage("MNR00154", "requested");
				saveType = 1;
				doActionIBSheet(sheetObjects[1], document.form, IBCLEAR, 0);
				nowLoad=0;
				MnrWaitControl(false);
				return;
			}
			//Save
			else {
				ComShowCodeMessage("MNR00153");
			}
			
			if(formObj.f_cmd.value != REMOVE)
			{
				formObj.f_cmd.value="";
				document.form.search_ttl_lss_no.value = sheetObj.EtcData("totalLossNo");
				document.form.ttl_lss_no.value = sheetObj.EtcData("totalLossNo");
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
		} 
		else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
		nowLoad=0;
		MnrWaitControl(false);
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
	
			//Loading 시 
			if(sActionIdx == 0) {
				//조건부 콤보데이타 조회 및 설정(Status, Main Reason, APP OFC)
				var sCondition = new Array (
						new Array("MnrGenCd","CD00039", "COMMON") 	//Status				
						,new Array("MnrGenCd","TR", "COMMON")		//Main Reason
						,new Array("MnrGenCd","HOOFC", "COMMON") 	//HOOFC
						,new Array("MdmCurrency","", "COMMON")		//Currency			
						,new Array("MnrGenCd","CD00071", "COMMON")  //Status 이전 CD00042
						,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
						,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
						,new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//쉬트 설정
				var sheetComboText = "";
				var sheetComboCode = "";
				var sheetComboCodeText = "";
				var sheetComboDefault = "";
				for(var i = 0; i < comboList.length;i++){
					//쉬트콤보별 초기화
					sheetComboText = "";
					sheetComboCode = "";
					sheetComboCodeText = "";
					sheetComboDefault = ""; 
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");   
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j ==0){	
								sheetComboDefault = tempText[0];      	
							}
							//Status 
							if(i==0) {
								formObj.ttl_lss_sts_cd.InsertItem(j, tempText[1] ,tempText[0]);
							}
							//Main Reason
							else if (i==1) {
//								if(document.location.href.split("?")[0].match("EES_MNR_0099.do")){
//									if(tempText[0] == "TRS"){
//										formObj.ttl_lss_rsn_cd.InsertItem(0, tempText[1] ,tempText[0]);										
//									}
//									if(tempText[0] == "TRU"){
//										formObj.ttl_lss_rsn_cd.InsertItem(1, tempText[1] ,tempText[0]);
//									}
//								} else {
//									if(tempText[0] != "TRS" && tempText[0] != "TRU"){
//										if(j==0){
//											formObj.ttl_lss_rsn_cd.InsertItem(0, '');	// Main Reason 디폴트 공백 추가
//										}
//
//											formObj.ttl_lss_rsn_cd.InsertItem(j+1, tempText[1] ,tempText[0]);	
//									}
//										
//								}
								
								if(j==0){
									formObj.ttl_lss_rsn_cd.InsertItem(0, '');	// Main Reason 디폴트 공백 추가
								}

									formObj.ttl_lss_rsn_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
								
							}
							//APP OFC
							else if (i==2) {
								formObj.apro_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
							}
						}
						//탭별 쉬트 콤보 설정
						for(var k=1; k<6; k++) {
							if(i == 3) {
								sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
							} else if(i == 4) {
								if( k==1) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 5) {
								if(k == 2) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 6) {
								if(k == 5) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 7){
								sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							}
						}	
					}
				}
			}
	
			//초기값 설정
			formObj.search_ttl_lss_no.value		= "";					//TLL No
			formObj.ttl_lss_no.value			= "NEW";				//TLL No
			formObj.search_ttl_lss_no.readOnly 	= false;
			formObj.search_ttl_lss_no.className	= "input1";
			formObj.respb_ofc_cd.value			= currOfcCd; 					//Responsible\nOFC
			formObj.rqst_ofc_cd.value			= currOfcCd; 			//REQ OFC
			formObj.rqst_dt.value				= ComGetNowInfo("ymd");	//REQ DT
			formObj.ttl_lss_sts_cd.Code 		= ""; 					//Status           	
			formObj.ttl_lss_sts_cd.Enable		= false;           	 
			formObj.ttl_lss_rsn_cd.Index=0;
			formObj.ttl_lss_dt.value			= ComGetNowInfo("ymd");	//TLL DT
			formObj.apro_ofc_cd.Code			= "SELCON";		 		//APP OFC
			
			//total AMT초기화
			for(var i=1;i<=5;i++)
			{
				eval("document.form.t"+ i + "LossTotal.value ='';");
				eval("document.form.t"+ i + "RecPlnTotal.value ='';");
				eval("document.form.t"+ i + "BalanceTotal.value ='';");
			}
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
				// 모든 쉬트를 초기화
				for (i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
	
				sheetObj.WaitImageVisible = true;
				formObj.f_cmd.value = SEARCH;      
	
				//다중조회
				var sXml = sheetObj.GetSearchXml("EES_MNR_0095GS.do", FormQueryString(formObj));
				
				
				var arrXml = sXml.split("|$$|");
	
				for(var i = 0; i < arrXml.length; i++){
					sheetObjects[i].LoadSearchXml(arrXml[i]);
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

				var currTabIndex=tabObjects[0].SelectedIndex;
				
				tabObjects[0].SelectedIndex=0;
				var sParam1 = sheetObjects[1].GetSaveString(true, true);
				if(sParam1=="")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SelectedIndex=1;
				// Sub Reason 이 Trucker 일때, SCAC Code 필수 체크
				if(("Trucker" == ComTrim(formObj.ttl_lss_dtl_rsn_cd.Text)) && ("Y" == currOfcUS)){
					sheetObjects[2].InitDataProperty(0, 12, dtData, 80, daCenter, true, "usa_edi_cd", true, "", dfNone, 0, true, true, 4);
				}else{	
					sheetObjects[2].InitDataProperty(0, 12, dtData, 80, daCenter, true, "usa_edi_cd", false, "", dfNone, 0, false, false, 4); 				
				}		
				
				var sParam2 = sheetObjects[2].GetSaveString(true, true);
				sheetObjects[2].InitDataProperty(0, 12, dtData, 80, daCenter, true, "usa_edi_cd", true, "", dfNone, 0, true, true, 4);				
				
				if(sParam2=="" && sheetObjects[2].RowCount > 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SelectedIndex=2;
				var sParam3 = sheetObjects[3].GetSaveString(true, true);
				if(sParam3=="" && sheetObjects[3].RowCount > 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SelectedIndex=3;
				var sParam4 = sheetObjects[4].GetSaveString(true, true);
				if(sParam4=="" && sheetObjects[4].RowCount > 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				if(sheetObjects[4].IsDataModified){
					for(var i=sheetObjects[4].HeaderRows ;i<=sheetObjects[4].LastRow;i++)
					{
		
						//2. 해당 칼럼이 빈값일 경우
						var checkValue1 =ComTrimAll(sheetObjects[4].CellValue(i, "ttl_lss_incm_amt")," ");
						var checkValue2 =ComTrimAll(sheetObjects[4].CellValue(i, "ttl_lss_expn_amt")," ");
						if(checkValue1=="" && checkValue2=="")
						{
							MnrWaitControl(false);
							ComShowCodeMessage("MNR00172","at least one item amoung Scrapping Income AMT or Scrapping Cost Amt");
							sheetObjects[4].SelectCell(i, "ttl_lss_incm_amt",true);
							nowLoad=0;
							return false; 
						}
						
					}
				}
				
				tabObjects[0].SelectedIndex=4;
				var sParam5 = sheetObjects[5].GetSaveString(true, true);
				if(sParam5=="" && sheetObjects[5].RowCount > 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				var sParam6 = sheetObjects[6].GetSaveString(true, true);
//				if(sParam6=="")
//				{
//					return;
//				}
				sParam6 = ComSetPrifix(sParam6,"statusHistory_");
				
				tabObjects[0].SelectedIndex=currTabIndex
				formObj.file_seq.value = uploadFileSeq;
				var mnrStsRefNo = "";
				var ttlLssNo = formObj.ttl_lss_no.value;
				if(ttlLssNo != "NEW") {
					formObj.mnr_sts_ref_no.value = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_sts_ref_no");
				} else {
					formObj.mnr_sts_ref_no.value = mnrStsRefNo;
				}
				//Save
				if(sActionIdx == 1) {  
					saveType = 1;
					formObj.ttl_lss_sts_cd.Code2 = "HS";
				} 
				//Request
				else if (sActionIdx == 2) {
					saveType = 2;
					formObj.ttl_lss_sts_cd.Code2 = "HR";
					setRowStausByRequest();  //저장이벤트 발생을 위한 상태변경
				}
				var sParam  = FormQueryString(formObj)+"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6;
	
				if (sParam == "")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				sParam += "&" + FormQueryString(formObj);
				//ComDebug(sParam);
				sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0095GS.do", sParam);	//Total Loss No 를 return 받는다.
				sheetObjects[0].LoadSaveXml(sSaveRtnXml);  								//저장 성공확인 메세지를 위한 Load
				
				//[CHM-201111741-01 김종옥] Request 바로 실행 유/무 확인
				if(sActionIdx == 1){
					if (ComShowCodeConfirm("MNR00275","Total Loss Request","Request"))
					{
						//Request 버튼 실행.
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 2);
					} 
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
			    sParam = FormQueryString(formObj); 
			    sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0095GS.do", sParam);	
			 	
									
				//초기값 설정
				formObj.search_ttl_lss_no.value		= "";					//TLL No
				formObj.ttl_lss_no.value			= "NEW";				//TLL No
				formObj.search_ttl_lss_no.readOnly 	= false;
				formObj.search_ttl_lss_no.className	= "input1";
				formObj.rqst_ofc_cd.value			= currOfcCd; 			//REQ OFC
				formObj.rqst_dt.value				= ComGetNowInfo("ymd");	//REQ DT
				formObj.ttl_lss_sts_cd.Code 		= ""; 					//Status           	
				formObj.ttl_lss_sts_cd.Enable		= false;           	 
				formObj.ttl_lss_rsn_cd.Code 		= ""; 					//Main Reason 
				formObj.ttl_lss_dt.value			= ComGetNowInfo("ymd");	//TLL DT
				formObj.acc_dt.value				= ComGetNowInfo("ymd");	//Accident DT(선박사고 날짜)
				formObj.apro_ofc_cd.Code			= "SELCON";		 		//APP OFC
				//total AMT초기화
				for(var i=1;i<=5;i++)
				{
					eval("document.form.t"+ i + "LossTotal.value ='';");
					eval("document.form.t"+ i + "RecPlnTotal.value ='';");
					eval("document.form.t"+ i + "BalanceTotal.value ='';");
				}
				formObj.search_ttl_lss_no.focus();
				uploadFileSeq = "";
				historyMnrStsRefNo = "";
				saveType = 1;				
				
				
				// 모든 쉬트를 초기화	
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}	  
				sheetObjects[0].LoadSaveXml(sSaveRtnXml);   //저장 성공확인 메세지를 위한 Load
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
	 

	 
	//ResponsibleOFC Check
	function respb_ofc_cd_Check(){
		nowLoad=1;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.respb_ofc_cd.value," ")!="")
		{
			var retArray=null;
			retArray = MnrGeneralCodeCheck(sheetObj,"OFC",formObj.respb_ofc_cd.value);  
			if(retArray == null){           
				ComShowCodeMessage("MNR00165",formObj.respb_ofc_cd.value,"OFFICE"); 
				formObj.respb_ofc_cd.value="";
				formObj.respb_ofc_nm.value="";
				ComSetFocus(formObj.respb_ofc_cd);
				nowLoad=0;
				return false;
			} else {	  
				var retArray=retArray[0].split("|");
				formObj.respb_ofc_cd.value=retArray[0];
				formObj.respb_ofc_nm.value=retArray[1];
			}
		} else { // 2015.06.15 CHM-201536250 : Total Loss Performance 데이터 검증 요청 입력시 mandatory로 변경
			ComShowCodeMessage("MNR00003","Responsible OFC");
			formObj.respb_ofc_cd.focus();
			return false;
		}
		nowLoad=0;
		return true;
	}
	
	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
		
		retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);      
		if(retArray == null){        
			return false;
		} else {    
			return true;    
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
			}
			//저장(요청)시
			else if(sAction == IBSAVE) {
				// Total Loss History 필수 입력 
				var rowCnt = sheetObjects[6].RowCount("R")+sheetObjects[6].RowCount("I")+sheetObjects[6].RowCount("U");
				if(rowCnt < 1){    
					ComShowCodeMessage("MNR00336");    		
					return false; 
				}
				
				//responsible Office check 2015.06.15 필수조건으로 추가  
				if(!checkMandatory(formObj.respb_ofc_cd)) {return false;}
				if(!respb_ofc_cd_Check()) {return false;}
				//Total Loss 상태값 체크
				if(!checkTotalLossfStatus()) {return false;}
				//필수
				if(!checkMandatory(formObj.ttl_lss_rsn_cd)) {return false;}
				if(!checkMandatory(formObj.ttl_lss_dtl_rsn_cd)) {return false;}
				if(!checkMandatory(formObj.ttl_lss_dt)) {return false;}
				
				// CHM-201538460, 선박의 사고에 따른 장비관리의 효율성을 위하여 추가 화면 개발: Accident DT, VVD, Port 조건 추가 -start
				if("Y" == formObj.page_separator.value){
					if(!checkMandatory(formObj.acc_dt)) {return false;}
					if(document.form.ttl_lss_rsn_cd.Code != "TRU"){
						if(!checkMandatory(formObj.acc_vsl_cd)) {return false;}
						if(!checkMandatory(formObj.acc_skd_voy_no)) {return false;}
						if(!checkMandatory(formObj.acc_skd_dir_cd)) {return false;}	
					}
				}
				// CHM-201538460, 선박의 사고에 따른 장비관리의 효율성을 위하여 추가 화면 개발: Accident DT, VVD, Port 조건 추가 -end
				
				
				var betDays = ComGetDaysBetween(formObj.ttl_lss_dt, ComGetNowInfo("ymd"));
				if(betDays < 0){
					ComShowCodeMessage("MNR00391");
					formObj.ttl_lss_dt.focus();
					return false;
				}else{
					if(betDays > 100 ){
						ComShowCodeMessage("MNR00392");
						formObj.ttl_lss_dt.focus();
						return false;
					}
				}
				
				if(!checkMandatory(formObj.apro_ofc_cd)) {return false;}
				//그리드 존재유무 
				if(!checkIsDetailRow(sActionIdx)) {return false;}
				//각시트별 중복체크
				for (var i=1; i<6; i++){
					var Row = sheetObjects[i].ColValueDup("rqst_eq_no",false);
					if(sheetObjects[i].IsDataModified){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + "th sheet of " + Row + " row ");
							sheetObjects[i].SelectCell(Row, "rqst_eq_no", true);  
							return false;
						}
					}
				}
	
			}
			//삭제시	 
			else if(sAction == IBSEARCHAPPEND) {  
				if(MnrNullToBlank(ComGetObjValue(formObj.search_ttl_lss_no)) == "" ||
				   MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00260");    		
					return false;	 
				}  		
				
				if (!ComShowCodeConfirm("MNR00275","Total Loss Request","Delete")){return false;} 
			}
		}
		return true;
	}

	
	/* ********* User Functions ************* */
	/**
	 * EES_MNR_0195 Popup의 값을 받은 함수      
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
		var formObj = document.form; 
	
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.search_ttl_lss_no.value = aryPopupData[0][4];
			formObj.ttl_lss_no.value = aryPopupData[0][4];
		}
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH); 
	}      
	
	/**
	 * Loss Total : DV의 Pay Amount의 합계
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].SelectedIndex + 1;
        var sheetIndex=1;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount > 0)
			{
				calFlag=true;
				break;
			}
		}
		if(calFlag==true)
		{
		    var tLossTotal=0;
		    var thrdAmtTotal=0;
		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;	
   					         								
            for(var i=sheetIndex;i<sheetIndex + 5;i++)	
            {		
			    if(sheetObjects[i].RowCount >0)					
			    {			
					for(var j=sheetObjects[i].HeaderRows ;j<=sheetObjects[i].LastRow;j++)
					{		
						//삭제 되거나  SEQ가 NULL(0)인 데이타 제외하고 계산
						if(sheetObjects[i].CellValue(j,"ibflag")!="D" && sheetObjects[i].CellValue(j,"seq")!="0")
						{				
							if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DV"){		
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="") 		
									tLossTotal = getFloatSumData(tLossTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="TP"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="") 
									thrdAmtTotal = getFloatSumData(thrdAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="DS"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_bil_amt")!="")  
									disposalAmtTotal = getFloatSumData(disposalAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")  
									disposalPlanAmtTotal = getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="SC"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_incm_amt")!="")  
									scrapIncomeAmtTotal = getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="") 
									scrapCostAmtTotal = getFloatSumData(scrapCostAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].CellValue(j,"mnr_inv_tp_cd")=="IR"){
								if(sheetObjects[i].CellValue(j,"ttl_lss_expn_amt")!="") 
									requestAmtTotal = getFloatSumData(requestAmtTotal,sheetObjects[i].CellValue(j,"ttl_lss_bil_amt"));
							}
						}
					}	
			    }	
            }	
         					 	  			      
            var tempStr = ComAddComma2((tLossTotal + ""), "#,###"); 
			eval("document.form.t"+ tabIndex + "LossTotal.value = tempStr;"); 
								
			//2010-03-19 : Recovery Plan Total(tRecPlnTotal) 을 minus(-) 로 표현
		    var tRecPlnTotal = parseFloat(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)).toFixed(2));				
			tempStr = ComAddComma2((tRecPlnTotal + ""), "#,###");		 
			eval("document.form.t"+ tabIndex + "RecPlnTotal.value = tempStr;");
								
			//2010-03-19 : Recovery Plan Total(tRecPlnTotal) 을 minus(-) 로 수정함에 따라  Loss Total(tLossTotal)을 minus(-) 하지않고 plus(+) 로 변경하여 Balance Total(tBalanceTotal) 값을 도출함.
		    var tBalanceTotal = getFloatSumData(tRecPlnTotal,tLossTotal); 	
			tempStr = ComAddComma2((tBalanceTotal + ""), "#,###");   	
			eval("document.form.t"+ tabIndex + "BalanceTotal.value = tempStr;"); 	
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
	 * (Responsible Office) 존재여부 체크    처리 부분<br>
	 * @param 
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Row 의 CellValue
	 */
	/**  
	 * ofc_cd 존재여부 체크    
	 */  	
	function setOfficeInfo(sheetObj,Row, Col, Value)
	{
		var retArray =  null;        
		if (Value!="")
		{
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",Value);      
			if(retArray == null)
			{           
				ComShowCodeMessage("MNR00165",Value,"OFFICE");  
				sheetObj.CellValue2(Row,Col)="";
				sheetObj.SelectCell(Row,Col,true);
			}   
		}
	}
	 
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[2].SelectRow;
			var vndrSeq = aryPopupData[0][2];
			var vndrNm  = aryPopupData[0][4];
			sheetObjects[2].CellValue(Row, "payer_code") = vndrSeq;
			sheetObjects[2].CellValue(Row, "payer_name") = vndrNm;
			sheetObjects[2].CellValue(Row, "mnr_prnr_seq") = vndrSeq;
		}
	}

	/**
	 * (Service Provider Buyer) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setServiceProviderBuyer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].SelectRow;
			var vndrSeq = aryPopupData[0][2];
			var vndrNm  = aryPopupData[0][4];
			sheetObjects[3].CellValue(Row, "buyer_code") = vndrSeq;
			sheetObjects[3].CellValue(Row, "buyer_name") = vndrNm;
		}
	}	
	
 	/**
	 * COM_ENS_071 의 값을 받은 함수      
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj = document.form;	
    	 var Row=sheetObjects[2].SelectRow;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[2].CellValue(Row, "respb_ofc_cd") 		= aryPopupData[0][3];
		 }      
    } 	 
	 
	/**
	 * (Customer) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function setCustomer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row =sheetObjects[2].SelectRow;
			var custCd 			= aryPopupData[0][3];
			var custNm 			= aryPopupData[0][4];
			var mnrPrnrCntCd	= custCd.substring(0,2);
			var mnrPrnrSeq   	= custCd.substring(2);
			sheetObjects[2].CellValue(Row, "payer_code") 		= custCd;
			sheetObjects[2].CellValue(Row, "payer_name") 		= custNm;
			sheetObjects[2].CellValue(Row, "mnr_prnr_cnt_cd")	= mnrPrnrCntCd;
			sheetObjects[2].CellValue(Row, "mnr_prnr_seq") 		= mnrPrnrSeq;
		}
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
	function sheet3_OnPopupClick(sheetObj,Row,Col){
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
			sParam+= "&mnr_grp_tp_cd=SCR";       // MNR Work Group Type Code				
			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
	
			upObj.ExtendParam = sParam;
	
			var sXml = upObj.DoUpload(true);
	
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
	
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[7],uploadFileSeq);
				sheetObjects[7].LoadSearchXml(fileXml);   				
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
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
	
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
	
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
	
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
	
	/**
	 * Total Loss 상태값을 체크하여 요청(Request)인 경우 false를 
	 * 그외의 경우는 true를 리턴한다.
	 * @return  {Boolean}    true/false
	 */
	function checkTotalLossfStatus() {
		var ttlLssStsCd = document.form.ttl_lss_sts_cd.Code; //ttl_lss_sts_cd
		if(ttlLssStsCd == "HR"){
			ComShowCodeMessage("MNR00208","Total Loss", "Request ");
			return false;
		}
		return true;
	}
	
	/**
	 * 저장시 필수 체크
	 * @param	{Element}	obj	체크할 Form Element
	 */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {  
			ComShowCodeMessage("MNR00003");
			obj.focus();
			return false;
		}
		return true;
	}
	
	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(sActionIdx){
		var cnt = 0;
		for (var i=1; i<6; i++) {
			var rowCnt = 0;
																
			//Request (sActionIdx = 2) ,Save (sActionIdx = 1)
			rowCnt = sheetObjects[i].RowCount("R")+sheetObjects[i].RowCount("I")+sheetObjects[i].RowCount("U");
										
			if(rowCnt > 0) {
				cnt++;
			}
		}
		if(cnt<1) {
			ComShowCodeMessage("MNR00172"," EQ Information");
			return false
		}
	
		return true;
	}
	
	/**
	 * Requust버튼 클릭시 저장이벤트를 강제 발생시키기 위해 
	 * 존재하는 최초의 1개의 Row상태값만을 'U'로 변경시킴
	 */
	function setRowStausByRequest(){
		for (var i=1; i<sheetObjects.length - 2; i++) {
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount > 0) {
				for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
					if(sheetObjects[i].RowStatus(j)== "R") {
						sheetObjects[i].RowStatus(j) = "U";
						return;
					}
				}
			}
		}
	}
	
	/**
	 * EQ No 값을 변경함에 따라 TP/SZ, DV.Value, Lessor 값을 재설정한다.
	 *  
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		//EQ_TYPE 선택유무 체크 
		var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){	
			ComShowCodeMessage("MNR00119"); 
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;	   	 
		} 
		//EQ No 존재유무 체크
		var rqstEqNo 		= sheetObj.CellValue(Row, "rqst_eq_no"); 
		var eqKndCd 		= sheetObj.CellValue(Row, "eq_knd_cd");
		var totalLossDate	= ComGetNowInfo("ymd");
		var retArray = MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);      
		if(retArray == null){ 	          
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");          				
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return; 	     	          
		} 
		//EQ No 관련 항목 조회
		var formObj = document.form;
		var sCostType = "";
		if(eqKndCd == "U"){
			sCostType = "MRDRRC";	
		} else if(eqKndCd == "G"){
			sCostType = "MRGSRC";		
		} else {
			sCostType = "MRZSRC";   
		}	   	 	
		var sXml = MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml); 
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt  						
		if(retArr == null){    
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");  
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd 	= retArr[0][31];	//TP/SZ
		var dpcValAmt	= retArr[0][10];	//DV.Value
		var lessorNm	= retArr[0][16];	//Lessor
		var lstmCd		= retArr[0][19];	//Term
		var ydCd		= retArr[0][18];	//Yard
		
		
		//EQ No 관련 항목 설정
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = eqTpszCd;	//TP/SZ
		sheetObj.CellValue2(Row,"lstm_cd") 		= lstmCd;  	//Term
		sheetObj.CellValue2(Row,"ttl_lss_yd_cd")= ydCd;  	//Yard
		if(sheetObj.id == "t1sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt")		= dpcValAmt;	//DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") 		= lessorNm;  	//Lessor
			sheetObj.CellValue(Row,"ttl_lss_bil_amt")  = dpcValAmt;  	//Pay Amount
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellValue(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
				sheetObj.CellValue(Row, "inv_no") = invNo;
//			}
		}else if(sheetObj.id == "t2sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") 	= dpcValAmt; 	//DV.Value 
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellValue(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"T";
				sheetObj.CellValue(Row, "inv_no") = invNo;
//			}
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") 	= dpcValAmt; 	//DV.Value
		} 
	}
	 
	/**
	 * EQ No 존재하지 않을 때, 관련정보 삭제
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; //TP/SZ
	
		if(sheetObj.id == "t1sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") = "";   //Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value 
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
		} 
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
	
	
	/**
	 * Vessel Code Data를 가져온다
	 * 
	 * @param obj
	 * @return
	 */
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.acc_vsl_cd.value = rtnDatas[1];
				}
			}
    	}
    }

    
    /**
	 * VVD 데이터를 가져온다.
	 * 
	 * @param obj
	 * @return
	 */
	function getVvdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.acc_skd_voy_no.value = rtnDatas[2];
					document.form.acc_skd_dir_cd.value = rtnDatas[3];
				}
			}
    	}
    }
	
	/**
	 * [Port] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj = document.form;
		formObj.acc_port_cd.value = rtnObjs[0][2];
	}
	
	