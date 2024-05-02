/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1209.js
*@FileTitle :  Chassis Exception List Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.10.07 조경완
* 1.0 Creation
* CSR 선처리 2014-01-20 Jonghee HAN SCC외 ALL 관련 Validate logic 해제 
* 2014-04-04 Jonghee HAN Ticket ID : CHM-201429358 Title : ALPS CHSS-COPS-Chassis S/C Exception Creation-Inquiry 기능 
								Chassis Menu로 실행시 Retrieve, New and ExcelDown Button외 Hidden 처리 및  Inquiry Popup Button 추가	
* 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, 
*								PRI를 통한 Chassis S/C Exception Creation시 Validation Logic 복원
* 2014-04-07 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, 
*								S/C Exception 최초 생성시 Logic 및 Accept Cancel Check SQL 변경  
* 2014-04-08 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, 
*								S/C No가 없는 최초 Proposal 처리를 위해 Script 및 Message 내용 변경
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
	 * @class Dual Type Exception Creation : Dual Type Exception Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CGM_1209() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
		this.initControl			= initControl;
	}
	
	/* 개발자 작업	*/
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
		
	//Action 정의
	var IBSEARCH_INIT			= 100;
	var IBSEARCH_VER			= 101;
	var IBSEARCH_CUST			= 102;
	var IBSEARCH_CALC			= 103;
	var IBSEARCH_DUR			= 104;
	var IBSEARCH_CHKCONTI		= 105;
	var IBSEARCH_FILED			= 106;
	var IBSEARCH_SCNO_CUST		= 107;
	var IBSEARCH_SUB			= 108;
	var IBSEARCH_SC				= 109;
	var IBSEARCH_CHECK_DUP		= 110;
	var IBSEARCH_VER_CHECK		= 111;
	var IBSAVE_VERSTS			= 201;
	var IBSAVE_SC				= 202;
	var IBSAVE_SC_UPDATE		= 203;
	var IBSAVE_SCTARIFF_HISTORY	= 204;
	var	IBDELETE_SCTARIFF		= 301;
			
	//DATA 구분자 정의
	var ROWMARK		= "|";
	var FIELDMARK		= "=";

	//ROW 의 실제 삭제여부를 나타내는 변수
	//GROUP 의 하위 항목은 hidden 상태로 조회되기 때문에 실제 삭제와 구분하기 위해서 사용됨
	var HID_STATUS		= "hidden_status";

	//현재 ROW 가 수정가능한 상태인지를 나타내주는 컬럼(조회된 데이터는 초기에 Editable 불가하다.)
	var ROW_EDIT_STS	= "row_edit_status";
	
	//현재 버전 내용중에 이전버전에서 추가된 신규내용표시. 2011.12.16 KHH
	var NEW_FLG	= "new_flg";

	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;

	//발생된 OnChange 이벤트가 화면상에서 이루어진것이 아닐경우, 
	//즉 조회된 데이터로 각 콤보필드를 설정해줄때 발생된 것인지를 구분해주는 변수.(의도치 않은 행위를 막기 위해서 사용함)
	//이 변수의 설정은 Location 필드에서 한다.
	//2009.06.21 추가사항 .Continent 에 잘못된 값이 들어와서 하위 Country 를 초기화 시킬때, 
	//상위 Continent 필드의 초기화를 막아주기 위해서도 사용됨.
	var isValueSettingEvent	= false;
	
	//Row Copy 버튼 클릭시 자동으로 Row 가 생성되면서 선택위치가 변경된다.
	//선택위치 변경시 수정,입력,삭제된 S/C Exception Tariff 가 있는지 검사하는 함수를 호출하게 되는데, 여기에서 정상처리로 만들기 위해서 사용하는 변수
	var isCopySCExceptionTariff = false;
	
	//Rate Adjustment 필수항목여부를 체크할 때 Coverage 에 값 입력시 중복 호출되는 것을 막기 위함.
	var isRateCheckingCVRG		= "";	

	//중복체크 에러메시지
	var dupAlertMsg			= "";	 
	var dupAlertSubMsg			= "";
	
	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currGrpSeq				= "";
	var param_row;
	
	var chkEffDt = "";
	var chkExpDt = "";
	var preEffDt = "";
	
	var popUpFlg = "";
	
	/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (S) */
	var propStsCd = "";
	/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (E) */

	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		 var sheetSCObj	= sheetObjects[0];

		 /*******************************************************/
		 var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_AddGroup":
					if (ComIsBtnEnable(srcName))
						addGroup();
					break;

				case "btn_CopyGroup":
					if (ComIsBtnEnable(srcName)) 
						copyGroup();
					break;

				case "btn_DelGroup":
					if(sheetSCObj.FindCheckedRow("del_chk") == ""){
						ComShowMessage("You did'nt check any Rows!");
					}else if(ComShowConfirm('Do you want to delete it?')){
						delGroup();
					}
					break;
					
				case "btn_SaveGroup":
					if (ComIsBtnEnable(srcName)) 
						saveGroup(false, false);//(변경된 정보가 있는지 검사하지 않았음을 나타낸다, 그리드 입력가능/입력불가능 상태처리까지 진행함)
					break;
				case "btn_DownExcel":
					if (ComIsBtnEnable(srcName))
						 if (sheetSCObj.RowCount < 1) {
							 ComShowCodeMessage("CGM10012");
							 return;
						 }
						sheetSCObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
					break;
				/* 2014-04-04 Jonghee HAN Ticket ID : CHM-201429358 Title : ALPS CHSS-COPS-Chassis S/C Exception Creation-Inquiry 기능 
													Chassis Menu로 실행시 Retrieve, New and ExcelDown Button외 Hidden 처리 및  Inquiry Popup Button 추가 */	
				case "btn_ScInquiry":	
					
					/* CSR		: [CHM-201539416] SC EXEPTION 화면 변경
					 * reason	: winName 전달하지 않아도 상관없으며(공틍으로 화면명 표시됨), "/" 때문에 nonmodal 호출시 에러남
					 * update 	: 2015.12.17 KCY
					 */
//					var sWinName = "Chassis S/C Exception Inquiry";
					
					ComOpenWindowCenter("/hanjin/EES_CGM_1220.do", "", 1024, 700, true);
//					ComOpenWindowCenter("/hanjin/EES_CGM_1220.do", "", 1024, 700, false); // 테스트 위하여 임시로 Nonmodal로
					break;
					
				case "btn_New":
					if (ComIsBtnEnable(srcName)) 
						doActionNew();
					break;
															
				case "btn_Update":
					if (ComIsBtnEnable(srcName)) 
						doActionUpdate();
					break;
					
				case "btn_Request":
					if (ComIsBtnEnable(srcName)) 
						doActionRequest();
					break;
				
				case "btn_Request_cancel":
					if (ComIsBtnEnable(srcName)) 
						doActionRequestCancel();
					break;
				
				case "btn_Delete":
					if (ComIsBtnEnable(srcName)) 
						doActionDelete();
					break;
						
				case "btn_Accept":
					if (ComIsBtnEnable(srcName)) 
						doActionAccept();
					break;
						
				case "btn_AcceptCancel":
					if (ComIsBtnEnable(srcName)) 
						doActionAcceptCancel();						
					break;	
					
				case "btn_Close":
					if (ComIsBtnEnable(srcName)) 
						doActionClose();
					break;	
					
				case "btn_Retrieve":
					if (ComIsBtnEnable(srcName)){
						if(ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.proposalNo) != ""){
							doActionIBSheet(sheetSCObj, formObj, IBSEARCH_INIT);
							if(ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.proposalNo) != ""){
								doActionRetrieve(IBSEARCH);
							}
						}else{
							ComShowCodeMessage("CGM20077");
							return;
						}
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj		= document.form;
		var sheetSCObj		= sheetObjects[0];
		var sheetCMDTObj	= sheetObjects[5];
		
		for (i = 0 ; i < sheetObjects.length ; i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//1.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();		

		//2.호출자에 따라서 보여줄 버튼을 정한다.
//		displayBtnByCaller();
		
		//3.페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		
		//4.Proposal No 가 있을 경우에만 아래 내용을 조회한다.
		if (ComTrim(ComGetObjValue(formObj.proposalNo)) != "") {
			popUpFlg = "Y";
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_INIT);
			//4-1.S/C Exception 에 등록된 데이터를 조회한다.
			doActionRetrieve(IBSEARCH);
			
		}else{
			ComEnableObject(formObj.sCNo, true);
			ComEnableObject(formObj.proposalNo, true);
			formObj.sCNo.className		= "input";
			formObj.proposalNo.className		= "input";
//			editableGroup(true);
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_ScInquiry");
		}
		initControl();
//		else {
//			//4-2.Version 를 초기값으로 설정해준다.
//			addComboItem(formObj.version,"001=",true);
//			
//			//4-3.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
//			initBtnControl();
//		}
//		searchCustomerByTypeChange();
		
		
	}
	
	function initDisableObjects() {
		var formObj = document.form;
		
		with(formObj) {
			ComEnableManyObjects(false, sCNo, proposalNo, status, custCd, custNm, eff_dt, exp_dt);
			sCNo.className			= "input2";
			proposalNo.className	= "input2";
			status.className		= "input2";
			custCd.className		= "input2";
			custNm.className		= "input2";
			eff_dt.className		= "input2";
			exp_dt.className		= "input2";
		}		
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		sheetObj.ToolTipOption="balloon:true;width:50;";
		
		var cnt = 0;
		var sheetid = sheetObj.id;
		var formObj = document.form;
		switch(sheetid) {
			case "sheet1":
				with (sheetObj) {
					if(popUpFlg == "Y"){
						// 높이 설정
						style.height = 250;
					}else{
						// 높이 설정
						style.height = 400;

					}
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 7, 100);

					var HeadTitle1 = "||Seq.|SCC|Customer Code|Customer Name|CNTR/Cargo|Free Days|Commodity Code|Comodity Code Name|Remarks"
					var headCount = ComCountHeadTitle(HeadTitle1) + 9;
					formObj.sheet1_cnt.value = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
//					InitHeadMode(true, false, false, false, false, false);
					InitHeadMode(true, false, true, false, false, false);  // check box = ALL 추가, 신용찬					

					//단일 행만 선택하도록 설정
					MultiSelection = false;
					SelectionMode = smSelectionRow;
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					 //데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"loc_cd",					true,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,		110,	daCenter,	true,	"cust_cd",					false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			175,	daLeft,		true,	"cust_nm",					false,		"",		dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	"chss_cntr_cgo_tp_cd",		false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"ft_dys",					false,		"",		dfInteger,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,		120,	daCenter,	true,	"cmdt_cd",					false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			340,	daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"usa_sc_expt_rmk",			false,		"",		dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"prop_no",					false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sc_expt_ver_seq",			false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sc_expt_grp_seq",			false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"eff_dt",					false,		"",		dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"exp_dt",					false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"cust_cnt_cd",				false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"cust_seq",					false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sts",						false,		"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"cud_flg",					false,		"",		dfNone,		0,	false,	false);
					
					InitDataValid(0, "loc_cd", vtEngUpOnly);
					// 좌측 틀고정 컬럼 설정
//					FrozenCols = SaveNameCol(FT_FLG);

					ShowButtonImage = 2;
					CountPosition = 2;
			   }
				break;


		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg	= false;
	
		var sheetSCObj			= sheetObjects[0];
		
		switch(sAction) {
			
			//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
			//1.Tariff Type, 2.CNTR/CGO Type, 3.Continent, 4.Country, 5.Region
			case IBSEARCH_INIT:
				
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				if(ComGetObjValue(formObj.proposalNo) != ""){
					ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
				}
				if(ComGetObjValue(formObj.sCNo) != ""){
					ComSetObjValue(formObj.sc_no,		ComGetObjValue(formObj.sCNo));
				}
				ComSetObjValue(formObj.f_cmd,		COMMAND01);
	
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리 =========================================================================
				
				//3-2.CNTR/CGO Type
				cntrCgoList		= ComGetEtcData(sXml, "CNTRCGO");
				addCellComboItem(sheetObj, cntrCgoList, "chss_cntr_cgo_tp_cd", false, true);
				
				//3-6.S/C Duration
				ComSetObjValue(formObj.eff_dt,		handleNullString(ComGetEtcData(sXml, "EFF_DT")));
				ComSetObjValue(formObj.exp_dt,		handleNullString(ComGetEtcData(sXml, "EXP_DT")));
				
				//3-7.Accept, Accept Cancel 버튼 권한 조회
				ComSetObjValue(formObj.isAcceptAuth,	handleNullString(ComGetEtcData(sXml, "HAS_AUTH")));
				
				//3-8.Proposal No. 로 SC No. 와 Customer Cd 와 Customer Name 을 조회한다.
				ComSetObjValue(formObj.custCd,		handleNullString(ComGetEtcData(sXml, "CUST_CD"))); //CUST_CNT_CD + CUST_SEQ(6자리)
				ComSetObjValue(formObj.custNm,		handleNullString(ComGetEtcData(sXml, "CUST_NM")));
				ComSetObjValue(formObj.custSeq,		handleNullString(ComGetEtcData(sXml, "CUST_SEQ"))); //CUST_SEQ(입력된 실제값)
				//2014-04-07 S/C No가 없는 최초 Proposal 처리를 위해 Script 및 Message 내용 변경
//				if(handleNullString(ComGetEtcData(sXml, "SC_NO")) != "" && handleNullString(ComGetEtcData(sXml, "PROP_NO")) != ""){
				if(handleNullString(ComGetEtcData(sXml, "PROP_NO")) != ""){
					ComSetObjValue(formObj.sCNo,			handleNullString(ComGetEtcData(sXml, "SC_NO")));
					ComSetObjValue(formObj.proposalNo,			handleNullString(ComGetEtcData(sXml, "PROP_NO")));
				}else{
					ComShowCodeMessage("CGM20023", "Proposal No");
					ComSetObjValue(formObj.sCNo,			"");
					ComSetObjValue(formObj.proposalNo,		"");
					ComSetObjValue(formObj.sc_no,			"");
					ComSetObjValue(formObj.prop_no,			"");
					ComSetFocus(formObj.sCNo);
					return;
				}
				
				//3-9.Acutual Customer 조회
				actCustList	= handleNullString(ComGetEtcData(sXml, "CUST"));
				addCellComboItem(sheetObj,	actCustList,	"cust_cd",				false);
				
				//3-10.Commodity 조회
				cmdtList		= handleNullString(ComGetEtcData(sXml, "CMDT"));
				addCellComboItem(sheetObj,	cmdtList,		"cmdt_cd",				false);
				//========================================================================================
			
				break;
			

			case IBSEARCH:

				if (sheetObj.id == "sheet1") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.sc_expt_grp_seq, "");
					ComSetObjValue(formObj.f_cmd,			SEARCH);
					
					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
					
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					
					//3.조회후 결과처리
					//3-1.그리드를 초기화 시킨다.
					sheetObj.RemoveAll();
					
					//3-2.그리드에 조회된 결과를 Load 시켜준다.
					if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
						sheetObj.LoadSearchXml(sXml);
						ComSetObjValue(formObj.eff_dt,		handleNullString(ComGetEtcData(sXml, "EFF_DT")));
						ComSetObjValue(formObj.exp_dt,		handleNullString(ComGetEtcData(sXml, "EXP_DT")));
						
						//CHM-201640296 S/C EXCEPTION FREE TIME 기능 추가 : 기존 FT_FLG값이 없으면 적용 안함
						ComSetObjValue(formObj.ft_flg,		handleNullString(ComGetEtcData(sXml, "FT_FLG")) == "" ? "N" : handleNullString(ComGetEtcData(sXml, "FT_FLG")));

						preEffDt = formObj.eff_dt.value;
					}
				}
				
				break;
			
//			case IBSEARCH_DUR:
//
//				if (sheetObj.id == "sheet1") {
//					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
//					ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
//					ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
//					ComSetObjValue(formObj.f_cmd,			SEARCH07);
//					
//					//2.조회조건으로 조회실행
//					//*********************************************************************************
//					ComOpenWait(true);
//					sheetObj.WaitImageVisible = false;
//					//*********************************************************************************
//					
//					var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
//					
//					//*********************************************************************************
//					ComOpenWait(false);
//					//*********************************************************************************
//					//3-6.S/C Duration
//					
//					
//				}
//				
//				break;	
				
			//화면 Load 시 Version 정보를 조회한다.				
			case IBSEARCH_VER:	
			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd,			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var verList = handleNullString(ComGetEtcData(sXml, "VER"));
				
				ComClearCombo(formObj.version);
				if (verList != ""){
					addComboItem(formObj.version, verList,	false);
				}else{
					addComboItem(formObj.version, "001=",	true);
				}
				break;
				
			//Action이 발생하기 직전 현재상태의 Version 정보를 조회한다.				
			case IBSEARCH_VER_CHECK:	
			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd,			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(MAX VERSION, MAX VERSION STATUS)
				var verList = handleNullString(ComGetEtcData(sXml, "VER"));
				var val = getMaxVersion(verList);
				ComSetObjValue(formObj.max_ver, val);	//max_version 조회
				var val2 = getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
				
				chkEffDt = handleNullString(ComGetEtcData(sXml, "EFF_DT"));
				chkExpDt = handleNullString(ComGetEtcData(sXml, "EXP_DT"));
				/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (S) */
				propStsCd = ComTrim(handleNullString(ComGetEtcData(sXml, "PROP_STS_CD")));
				/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (E) */
				
				break;
			
			//Accept 버튼 클릭시 해당 S/C 가 Filed STS 인지 체크한다.
			case IBSEARCH_FILED:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,			SEARCH09);
				ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
							
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboDatas = ComGetEtcData(sXml, "FILED");
				ComSetObjValue(formObj.result, comboDatas);					
				break;
					
			
			//Save 버튼 클릭시 생성, 수정된 S/C Exception Tariff 를 DB 에 반영합니다.(한 건 단위로 실행된다)
			case IBSAVE_SC:		
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,			MULTI);
				
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				

				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "scGrp");
				}
				
				sParam += sParam1 + "&" + FormQueryString(formObj);

				//2.저장실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1209GS.do", sParam);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				

				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;

				
			//Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성 합니다.
			case IBSAVE_SC_UPDATE:
				//1.생성 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				
				ComSetObjValue(formObj.f_cmd,					MULTI02);
//				ComSetObjValue(formObj.prop_no,				sheetObj.CellValue(sheetObj.HeaderRows, PROP_NO));
				ComSetObjValue(formObj.sc_expt_prev_ver_seq,	formObj.sc_expt_ver_seq.value);
				ComSetObjValue(formObj.amdt_seq,	"");
				ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"T");
				
				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************	
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
					
				break;
				
				
			//S/C Exception Tariff History 팝업에서 선택한 버전의 S/C Exception Tariff 를 현재 버전에 생성 합니다.
			//만일, 현재 버전에 S/C Exception Tariff 가 존재한다면 모두 삭제한다.
			case IBSAVE_SCTARIFF_HISTORY:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,					MULTI03);
				ComSetObjValue(formObj.prop_no,				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq,		ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"T");
				
				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************	
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				
				break;
				
					
			//Accept 버튼 클릭시 Version 의 상태정보를 변경하고, 로그테이블에 입력한다.
			case IBSAVE_VERSTS:
				//1.Version 상태정보 변경 요청 전, 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,			SEARCH10);
				ComSetObjValue(formObj.prop_no,			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
					
				//2.입력조건으로 수정실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;	
				
				
			case IBDELETE:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,			SEARCH05);	
				ComSetObjValue(formObj.prop_no,			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;
				
			case IBSEARCH_ASYNC01:		 // 조회
				formObj.f_cmd.value = SEARCH20;
				var selRow = sheetObj.SelectRow;
				
				var param = "f_cmd=" + SEARCH20
						  + "&cmdt_cd=" + sheetObj.CellText(param_row, "cmdt_cd")
						  ;
			
				//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	
				var sXml = sheetObj.GetSearchXml("EES_CGM_1209GS.do",param);
				
				//ComOpenWait End
				ComOpenWait(false);
			
				var rtnName = ComGetEtcData(sXml, "rtnName");

				if ( rtnName != undefined && rtnName != '') {
					var rtnNameArr = rtnName.split("|");
					sheetObj.CellValue2( param_row , "cmdt_nm" ) = rtnNameArr[1];
					
				} else {
					ComShowCodeMessage( "CGM20042" , "Commodity code" );
					sheetObj.CellValue2( param_row , "cmdt_cd" ) = "";
					sheetObj.CellValue2( param_row , "cmdt_nm" ) = "";
				}
				break;
			case IBSEARCH_ASYNC02:		 // 조회
				formObj.f_cmd.value = SEARCH22;
				var selRow = sheetObj.SelectRow;
				var param = "f_cmd=" + SEARCH22
						  + "&cust_cnt_cd=" + sheetObj.CellText(param_row, "cust_cd").substring(0,2)
						  + "&cust_seq=" + ComLpad((sheetObj.CellText(param_row, "cust_cd").substring(2)),6,"0");
						  ;
				
				//MDM_CUSTOMER 존재 여부 확인
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do",param);
				
				var rtnName = ComGetEtcData(sXml, "CUST_NM");
				
				if ( rtnName != undefined && rtnName != '') {
					param = "f_cmd=" + SEARCH19
						  + "&prop_no=" + ComGetObjValue(formObj.prop_no)
						  + "&cust_cnt_cd=" + sheetObj.CellText(param_row, "cust_cd").substring(0,2)
						  + "&cust_seq=" + ComLpad((sheetObj.CellText(param_row, "cust_cd").substring(2)),6,"0")
						  ;

					
					//ComOpenWait Start
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					
					var sXml2 = sheetObj.GetSearchXml("EES_CGM_1209GS.do" , param);
					
					//ComOpenWait End
					ComOpenWait(false);
					
					var rtnFlag = ComGetEtcData(sXml2, "rtnValue");
					
					if(rtnFlag == "Y"){
						ComShowCodeMessage( "CGM20059" );
						sheetObj.CellValue2( param_row, "cust_cd" ) = "";
						sheetObj.CellValue2( param_row , "cust_nm" ) = "";
					}else{
						sheetObj.CellValue2( param_row , "cust_cd" ) = sheetObj.CellText(param_row, "cust_cd").substring(0,2)
															+ ComLpad((sheetObj.CellText(param_row, "cust_cd").substring(2)),6,"0");
						sheetObj.CellValue2( param_row , "cust_nm" ) = rtnName;
						sheetObj.CellValue2( param_row, "cust_cnt_cd" ) = sheetObj.CellText(param_row, "cust_cd").substring(0,2);
						sheetObj.CellValue2( param_row, "cust_seq" ) = ComLpad((sheetObj.CellText(param_row, "cust_cd").substring(2)),6,"0");
					}
				}else{
					ComShowCodeMessage( "CGM20042" , "Customer code" );
					sheetObj.CellValue2( param_row , "cust_cd" ) = "";
					sheetObj.CellValue2( param_row , "cust_nm" ) = "";
				}
				
			break;
				
		}
	}
	

	/**
	 * 그리드내 콤보필드에 데이터를 선택해준다.
	 */		
	function setCellComboItem(sheetObj, comboDatas, sComboKey, sComboRow) {
		var formObj		= document.form;
		
		if (comboDatas != undefined) {
			comboItem	= comboDatas.split(FIELDMARK);
			sVal		= comboItem[0];
		}
		else {
			sVal		= "";
		}
		
		sheetObj.CellValue(sComboRow, sComboKey) = sVal;
	}
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다.
	 */		
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
		var formObj			= document.form;
		var comboItem;
		var comboItems;
		var comboTxt		= "";
		var comboVal		= "";
		var comboInitTxt	= "";
		var comboInitVal	= "";
		
		//현재 ROW 를 결정한다.(Multi Coverage 에서는 여러줄에 복사를 할 경우 발생되는 문제점을 처리하기 위함) +++++++++++++++++++++++++++++++++
//		sRow = sheetObj.SelectRow;
//		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
//			sRow = ComGetObjValue(formObj.select_row);
//		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		
		
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems = comboDatas.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				
				//InitDataCombo 메소드를 태울 경우 선택값을 주지 않을 경우
				//Code, Value 가 콤보에 나타나 글자가 밀리는 현상을 방지하기 위함.
				if (!isCellCombo && i == 0) {
					comboInitTxt = comboItem[0];
					comboInitVal = comboItem[0];
				}
				
				if (ComTrim(comboItem[0]) != "") {
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					} else {
						//ACTUAL CUSTOMER 콤보설정일때
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";			
		}
		
		var colName = sComboKey;
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
			sheetObj.CellValue2(sRow,colName) = "";
		}
		else {
			sheetObj.InitDataCombo(0,colName, comboTxt, comboVal,comboInitTxt,comboInitVal);
		}
	}
		
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems = comboDatas.split(ROWMARK);	
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
			}
		}		
	}
		
	/**
	 * Max Version 
	 * 조회해서 그 결과를 반환한다.
	 */
	function getMaxVersion(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items = versions.split(ROWMARK);	
			for (var i = 0 ; i < ver_items.length ; i++) {
				ver_item = ver_items[i].split(FIELDMARK);
				val = ver_item[0];
				break;
			}
		}
		return val; 
	}
	/**
	 * Max Version Status 
	 * 조회해서 그 결과를 반환한다.
	 */
	function getMaxVersionStatus(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items = versions.split(ROWMARK);	
			for (var i = 0 ; i < ver_items.length ; i++) {
				ver_item = ver_items[i].split(FIELDMARK);
				val = ver_item[1];
				break;
			}
		}
		
		if (val.indexOf(":") != -1) {
			var stsArr = val.split(":");
			val = stsArr[0]; 
		}
		return val;
	}
	
	/**
	 * Multi Origin or Destination 각 Row 별로 Rate Adjustment 필수여부를 
	 * 조회해서 그 결과를 반환한다.
	 */
	function getRTMandatory() {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		
		with(sheetObj1) {
			var propNo = CellValue(SelectRow, PROP_NO);
			var verSeq = CellValue(SelectRow, VER_SEQ);
			var grpSeq = CellValue(SelectRow, GRP_SEQ);
		}
		
		var mark = "N";
		with(sheetObj2) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//삭제된 데이터에 대해서는 처리하지 않는다.		
				if (CellValue(row, HID_STATUS) != "Y") {				
					if (	propNo == CellValue(row, PROP_NO)
						 && verSeq == CellValue(row, VER_SEQ)
						 && grpSeq == CellValue(row, GRP_SEQ)	) {
						if (CellValue(row, RT_MANDATORY) == "Y") {
							mark = "Y";
						}
					}
				}
			}
		}
		return mark;
	}	 
	
	/**
	 * S/C Exception Tariff 의 Group Seq. 의 선택이 변경될 경우 해당 하위 항목들을 조회한다.
	 */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj	= document.form;
	}

	/*
	 * Group 정보를 추가한다.
	 */		
	function addGroup() {
		var formObj		= document.form;
		var sheetObj	= sheetObjects[0];

		//1.Row Add 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구 ==========================
//		var chkResult = isChangedSCExceptionTariff();
//		if (chkResult[0]) {
//			if (ComShowCodeConfirm("CGM10047")) {
//				//변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
//				if (!saveGroup(chkResult[0], true)) return;	
//			}
//			else {
//				//ComShowCodeMessage("DMT01115");
//				return;
//			}
//		}

		//==========================================================================================================================
		
		with(sheetObj) {
		
			propNo = ComGetObjValue(formObj.proposalNo);
			verSeq = ComParseInt(ComGetObjText(formObj.version));
			

			//===============================================================================================================
			//Row 를 생성하면 자동으로 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopySCExceptionTariff = true;
			var irow = DataInsert(-1);
			isCopySCExceptionTariff = false;
			
			// new row 글자색 지정 2011.12.14  김현화
			sheetObj.RowFontColor(irow) = RgbColor(0,0,255); 
			//===============================================================================================================
			
			CellValue2(LastRow, "prop_no") = propNo;
			CellValue2(LastRow, "sc_expt_ver_seq") = verSeq;
			CellValue2(LastRow, "sc_expt_grp_seq") = "";

			CellValue2(LastRow, "eff_dt") = ComGetObjValue(formObj.eff_dt);
			CellValue2(LastRow, "exp_dt") = ComGetObjValue(formObj.exp_dt);
			
			// Effective Date를 Current Date으로 Setting 2011.12.14  김현화
//			CellValue2(LastRow, EFF_DT) = getTodate();
//			CellValue2(LastRow, EXP_DT) = ComGetObjValue(formObj.sc_exp_dt);

		}
		
		
	}
			
	/**
	 * S/C Exception Tariff 의 하위 그리드내에 삭제되지 않은 마지막 Row 데이터의 지정된 Column 값을 반환하는 함수
	 */
	function fetchColumnValueOfLastRow(sheetObj, COL) {
		var lastColumnValue = "";
		
		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) != "D") {

					lastColumnValue = ComTrim(CellValue(row, COL));
					
					//Multi Coverage 에서 Rate Adjustment 가 필수항목일 경우 Country 값은 반드시 존재해야한다. 이때, 이 함수에서 Country 값을 읽어올때,
					//맨 마지막 행에 값이 없으면 그 상위 행에 값을 읽어오도록 처리함.(Multi Coverage 에서는 Row Add 시 빈 공란상태로 계속 추가가능하도록 구현되어 있기 때문에)
					if (COL != CVRG_CNT || lastColumnValue != "") break;
				}
			}
		}
		return lastColumnValue;
	}
	 
	/**
	 * Group 정보를 Copy 한다.
	 */		
	function copyGroup() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];

		//Copy 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("CGM20057", "copy");
			return;
		}
		//==========================================================================================================================
			
		with(sheetSCObj) {
			//===============================================================================================================
			//Row 를 복사하면 자동으로 복사된 행이 생성되고 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopySCExceptionTariff = true;
			var row = DataCopy();
			isCopySCExceptionTariff = false;
			//===============================================================================================================
			
			//복사한 Row 를 시스템에 반영하기 위해서 상태를 '입력' 으로 설정해준다.
			RowStatus(row) = "I";

			//Group Sequence 는 저장할 때 시스템쪽에서 자동으로 생성해서 입력해준다.
			CellValue(row, "sc_expt_grp_seq") = "";
		}
	}
		
	/**
	 * Delete 버튼 클릭시 선택되어진 Group 정보를 삭제한다.
	 * 그룹정보 삭제시 그 하위의 모든 정보들도 함께 삭제된다.
	 */		
	function delGroup() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];

		if (sheetSCObj.id == 'sheet1') {  
			if(sheetSCObj.FindCheckedRow("del_chk") != ""){
				ComRowHideDelete(sheetSCObj,"del_chk"); 
			}
		}
	}

	/**
	 * SAVE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수(매개변수는 변경된 정보가 있는지 없는지 나타낸다.)
	 */				
	function saveGroup(isChangedSCTariff, isOnlyRetrieve) {
		var sheetSCObj	= sheetObjects[0];
		var formObj		= document.form;
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================
		
		//Save 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("CGM20057", "save");
			return;
		}
		//==========================================================================================================================
		
		//S/C Tariff Exception 의 변경여부를 체크하지 않았다면 체크해준다. ==============================================================
		if (!isChangedSCTariff) {
			//chkResult => 0: 결과, 1: 발생된 Row, 2:입력,수정,삭제 구분, 3:에러메시지
			var chkResult = isChangedSCExceptionTariff();
			
			if (!chkResult[0] && preEffDt == formObj.eff_dt.value) {
				ComShowCodeMessage("CGM20058");
				return false;
			}
		}
		//===========================================================================================================================
		
		//입력하거나 수정하거나 삭제된 내용을 반영한다.
		if (validateForm()) {
			
			//Save 버튼 클릭시에는 무조건 'Temp.Save' 로 설정한다. =====================================================================
			ComSetObjValue(formObj.chss_expt_ver_sts_cd, "T");
			//======================================================================================================================
			
			//추가, 수정, 삭제된 S/C Exception Tariff 를 DB 에 반영한다. ==============================================================
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SC);
			//======================================================================================================================
			
			//저장 Action 이 정상실행시 Alert 창을 띄워주고, 조회를 실행한다. ============================================================
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("CGM00003");
				
				doActionRetrieve(IBSEARCH);
			}
			//======================================================================================================================
		}
		else {
			
			return false;
		}

		return true;
	}
		
	/**
	 * S/C Exception Tariff 의 하위항목들에 대한 삭제를 수행하는 함수(전체, 선택항목 삭제)
	 */	
	function delSubSCException(sheetObj, part) {
		
		with(sheetObj) {
			//S/C Exception Tariff 의 하위 항목의 그리드내에 있는 모든 데이터를 삭제한다.
			if (part == "All") {
				for (var row = LastRow ; row >= HeaderRows ; row--) {
					
					if (RowStatus(row) == "I") {
						RowDelete(row, false);
					}
					else {
						RowStatus(row) = "D";
						RowHidden(row) = true;
					}
				}
			}
			//S/C Exception Tariff 의 하위 항목의 그리드내에 있는 선택한 항목만을 삭제한다.
			else {
				if (RowStatus(SelectRow) == "I") {
					RowDelete(SelectRow, false);
				}
				else {
					RowStatus(SelectRow) = "D";
					RowHidden(SelectRow) = true;
				}
			}
		}
	}

	 
	/*
	 * S/C Exception Group 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableGroup(flag) {
		var sheetSCObj	= sheetObjects[0];
		var tmpStatus	= "";
		
//		with(sheetSCObj) {
//			for (var row = HeaderRows ; row <= LastRow ; row++) {
//				//================================================================
//				//아래 로직을 수행하는 동안 Row 의 상태가 자동으로 변경되는걸  
//				//방지하기 위해서 그 이전 상태값을 임시저장했다가 설정 후 원복해준다.
//				tmpStatus = sheetSCObj.RowStatus(row);
//				//================================================================
//				
//				CellEditable(row, TARIFF)		= flag;
//				CellEditable(row, EFF_DT)		= flag;
//				CellEditable(row, EXP_DT)		= flag;
//				CellEditable(row, CNTRCGO)		= flag;
//				CellEditable(row, CVRG_MULTI)	= flag;
//
//				if (flag && CellValue(row, CVRG_MULTI) == "M") {
//					CellEditable(row, CVRG_CNT) = false;
//					CellEditable(row, CVRG_RGN) = false;
//					CellEditable(row, CVRG_LOC) = false;
//				} 
//				else {
//					CellEditable(row, CVRG_CNT) = flag;
//					CellEditable(row, CVRG_RGN) = flag;
//					CellEditable(row, CVRG_LOC) = flag;
//				}
//
//				CellEditable(row, FT_FLG)		= flag;
//				CellEditable(row, FT_TIR)		= flag;
//
//				if (flag && "M" == CellValue(row, FT_TIR)) {
//					CellEditable(row, ADD_DYS)	= false;
//					CellEditable(row, TOT_DYS)	= false;				
//				}
//				else {
//					CellEditable(row, ADD_DYS)	= flag;
//					CellEditable(row, TOT_DYS)	= flag;				
//				}			
//
//				CellEditable(row, SAT_FLG)		= flag;
//				CellEditable(row, SUN_FLG)		= flag;
//				CellEditable(row, HOL_FLG)		= flag;
//				CellEditable(row, ORGDST_CTI)	= flag;
//				CellEditable(row, ORGDST_CNT)	= flag;
//				CellEditable(row, ORGDST_RGN)	= flag;
//				CellEditable(row, ORGDST_LOC)	= flag;
//
//				//BKG DEL(I) or POR(O) 필드의 활성화 여부는 Tariff 필드의 입력값에 따라서 달라진다.
//				if (flag) { 
//					changeBKGDELorPOR(sheetSCObj, row); 
//				}
//				else { 
//					CellEditable(row, BKGDEL_CNT) = false; 
//					CellEditable(row, BKGDEL_RGN) = false;
//					CellEditable(row, BKGDEL_LOC) = false;
//				}
//	
//				//CY/Door 필드의 활성화 여부는 Tariff 필드의 입력값에 따라서 달라진다.
//				if (flag) { 
//					changeCYDoor(sheetSCObj, row); 
//				}
//				else { 
//					CellEditable(row, CYDOOR)	= false; 
//				}
//				CellEditable(row, REMARK)		= flag;
//				
//				//각 ROW 의 Editable 한 상태값을 기억하기 위해서 저장함.
//				sheetSCObj.CellValue(row, ROW_EDIT_STS)	= flag ? "Y" : "N";
//				
//				//한 Row 에 대한 설정이 완료된 후 Row 의 상태를 원복시킨다. =============
//				sheetSCObj.RowStatus(row) = tmpStatus;
//				//================================================================
//			}
//		}
		
		//Group 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
	
		if (flag) {
			ComBtnEnable("btn_AddGroup");
			ComBtnEnable("btn_CopyGroup");
			ComBtnEnable("btn_DelGroup");
			ComBtnEnable("btn_SaveGroup");
			ComBtnEnable("btn_DownExcel");
//			ComBtnEnable("btn_ScInquiry");
			
		}
		else {
			ComBtnDisable("btn_AddGroup");
			ComBtnDisable("btn_CopyGroup");
			ComBtnDisable("btn_DelGroup");
			ComBtnDisable("btn_SaveGroup");
			ComBtnEnable("btn_DownExcel");
//			ComBtnEnable("btn_ScInquiry");
		}
	}
					
	/**
	 * S/C Proposal Creation 화면에서 호출되었는지를 구분해주는 함수
	 */		
	function isProposalCreationScreen() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (ComTrim(ComGetObjValue(formObj.isEditable)) == "Y") {
			return true;	
		} else {
			return false;
		}		
	}
			
	/**
	 * 메인 버튼에 대해서 주어진 조건에 따라 상태를 변경하는 함수 
	 */					
	function initBtnControl() {
		//New Button
		initBtnNew();		
		//Update Button
		initBtnUpdate();
		//Request Button
		initBtnRequest();
		//Request Cancel Button
		initBtnRequestCancel();
		//Delete Button
		initBtnDelete();
		//Accept Button
		initBtnAccept();
		//Accept Cancel Button
		initBtnAcceptCancel();
	}

	/**
	 * 조건에 따라서 UPDATE 버튼의 상태가 변경된다.
	 */		
	function initBtnNew() {
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			ComBtnEnable("btn_New");
		} else {
			ComBtnDisable("btn_New");
		}		
	}
	
	/**
	 * 조건에 따라서 UPDATE 버튼의 상태가 변경된다.
	 */		
	function initBtnUpdate() {
		var formObj = document.form;
				
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var curver = ComTrim(ComGetObjText(formObj.version));
			var maxver = ComTrim(formObj.version.options[0].text);
			var status = getVerStatus("Code");
			
			//Version 이 최종 Version 이면서 Status 가 Requested 또는 Live 일 때만 활성화
			if (curver == maxver && (status == "L")) {
				ComBtnEnable("btn_Update");		
			} else {
				ComBtnDisable("btn_Update");
			}
		} else {
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Update");
		}
	}
	
	/**
	 * 조건에 따라서 REQUEST 버튼의 상태가 변경된다.
	 */		
	function initBtnRequest() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//S/C Proposal Creation 화면에서 열릴 때에 Status가 공란 또는 Temp. Saved이면 활성화
			if (status == "" || status == "T")
				ComBtnEnable("btn_Request");
			else
				ComBtnDisable("btn_Request");
				
		} else {		
			ComBtnDisable("btn_Request");
		}
	}
	
	/**
	 * 조건에 따라서 REQUEST 버튼의 상태가 변경된다.
	 */		
	function initBtnRequestCancel() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//S/C Proposal Creation 화면에서 열릴 때에 Status가 공란 또는 Temp. Saved이면 활성화
			if (status == "R")
				ComBtnEnable("btn_Request_cancel");
			else
				ComBtnDisable("btn_Request_cancel");
				
		} else {		
			ComBtnDisable("btn_Request_cancel");
		}
	}
	
	/**
	 * 조건에 따라서 DELETE 버튼의 상태가 변경된다.
	 */		
	function initBtnDelete() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//Status 가  Requested
			if (status == "R" || status == "T")
				ComBtnEnable("btn_Delete");
			else
				ComBtnDisable("btn_Delete");
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Delete");
		}
	}

	/**
	 * 조건에 따라서 ACCEPT 버튼의 상태가 변경된다.
	 * 이 함수는 페이지가 Load 될 때 와 조회 후 호출된다.
	 */		
	function initBtnAccept() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//Status 가 Requested 일 때에 활성화
			if (status == "R") {
				//[11/13] 로직 추가 (로그인 점소가 Main과 Scope의 Approval Office인 User)(2009-11-30(월))
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_Accept");
				}
				else {
					ComBtnDisable("btn_Accept");
				}
			}
			else {
				ComBtnDisable("btn_Accept");
			}
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Accept");
		}
	}

	/**
	 * 조건에 따라서 ACCEPT CANCEL 버튼의 상태가 변경된다.
	 */		
	function initBtnAcceptCancel() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//해당 버튼 / 권한은 Pricing 담당자에게만 있음(SAOBB외 지역본부 이상)
			//버튼 권한은 S/C 시스템 승인권자와 동일
			//위 로직은 권한문제로 인해서 추후 구현해야 함.(2009-06-01)
			
			//Status 가 Accepted 일 때에 활성화
			if (status == "A") {
				//[11/13] 로직 추가 (로그인 점소가 Main과 Scope의 Approval Office인 User)(2009-11-30(월))
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_AcceptCancel");
				}
				else {
					ComBtnDisable("btn_AcceptCancel");
				}
			}
			else {
				ComBtnDisable("btn_AcceptCancel");
			}
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_AcceptCancel");
		}
	}
	
	/**
	 * S/C EXCEPTION 에 등록된  데이터 조회하는 동작을 정의하는 함수
	 */		
	function doActionRetrieve(sAction) {
		var formObj		= document.form;
		var sheetSCObj		= sheetObjects[0];

		//1.Proposal No. 에 대한 최상위 Version 정보를 조회한다.
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER);
		
		//2.최상위 Version 정보로 S/C Exception 정보를 조회한다.
		doActionRetrieveByVer(sAction);
		
	}
	 
	/**
	 * Version 정보가 변경될 경우 실행될 동작을 정의하는 함수
	 */		
	function doActionRetrieveByVer(sAction) {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];

		//1.조회전에 Status 필드를 초기화한다.
		ComSetObjValue(formObj.status, getVerStatus("Text"));
		
		//2.S/C별 DEM/DET 등록된 특별 계약 내용을 조회한다.
		doActionIBSheet(sheetSCObj, formObj, sAction);
		
		//--------------------------------------------------------------------
		currGrpSeq = sheetSCObj.CellValue(sheetSCObj.SelectRow, "sc_expt_grp_seq");
		//--------------------------------------------------------------------
		
		//2014-04-15 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, 
		//PRI를 통한 Chassis S/C Exception Creation시 Validation Logic 복원 : Effective date editable -> disable로 변경
//		ComEnableObject(formObj.eff_dt, false);
//		formObj.eff_dt.className		= "input2";
//		editableGroup(false);
		
		//3.S/C Exception Tariff 의 조회결과가 있다면 현재 선택된 Group Seq. 의 하위항목을 조회한다.
		if (sheetSCObj.RowCount > 0) {
			
			if (getVerStatus("Code") == "T" && ComGetObjValue(formObj.isEditable) == "Y"){
				//임시 저장 상태이고, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				ComEnableObject(formObj.eff_dt, false);
				formObj.eff_dt.className		= "input2";
				editableGroup(true);
			
			}else{
				ComEnableObject(formObj.eff_dt, false);
				formObj.eff_dt.className		= "input2";
				editableGroup(false);
			}
			
			
		}
		else {
			if (ComGetObjValue(formObj.isEditable) == "Y"){
				//조회된 결과가 없고 Version 이 1 이며, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				ComEnableObject(formObj.eff_dt, false);
				formObj.eff_dt.className		= "input2";
				editableGroup(true);
			}else{
				ComEnableObject(formObj.eff_dt, false);
				formObj.eff_dt.className		= "input2";
				editableGroup(false);
			}
			
		}
		
		//4.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
		initBtnControl();
		
//		//5.쉬트 정렬의 활성화/비활성화 시킨다.
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
//		}
		
	 }

   
	/**
	 * NEW 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionNew() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
				
		//Version 비활성화시 활성화시켜준다.(2009-11-13(금))
		with(formObj) {
			ComEnableManyObjects(true, version);
			version.className = "input";
		}
		
		if(popUpFlg == "Y"){
			//New 버튼 클릭시 화면 Load 시와 동일하게 동작한다.
			doActionRetrieve(IBSEARCH);
		}else {
			ComSetObjValue(formObj.proposalNo,					"");
			ComSetObjValue(formObj.sCNo,				"");
			
			ComSetObjValue(formObj.prop_no,					"");
			ComSetObjValue(formObj.sc_no,				"");
			ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"");
			ComSetObjValue(formObj.status,	"");
			ComSetObjValue(formObj.custCd,	"");
			ComSetObjValue(formObj.custNm,	"");
			ComSetObjValue(formObj.eff_dt,	"");
			ComSetObjValue(formObj.exp_dt,	"");
			
			ComBtnDisable("btn_Update");
			ComBtnDisable("btn_Request");
			ComBtnDisable("btn_Request_cancel");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_AcceptCancel");
			
			ComEnableObject(formObj.eff_dt, false);
			formObj.eff_dt.className		= "input2";
			
			ComClearCombo(formObj.version);
			sheetSCObj.RemoveAll();
			editableGroup(false);
			ComBtnDisable("btn_DownExcel");
//			ComBtnEnable("btn_ScInquiry");
		}
	}

	/**
	 * UPDATE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionUpdate() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}
		
		if(chkEffDt == formObj.eff_dt.value){
			ComShowCodeMessage("CGM20072");//New S/C Proposal is not amended yet. Please Amend the proposal first.
			return;
		}
		
		/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (S) */
		if(propStsCd != "I"){
			ComShowCodeMessage("CGM20072");//New S/C Proposal is not amended yet. Please Amend the proposal first.
			return;
		}
		/* 2014.06.24 Chang Young Kim Added In accordance with the "SRM-201445510" (E) */
		
		//==========================================================================================================================
		if (getVerStatus("Code") == "R") {
			if (!ComShowCodeConfirm("CGM20061")) { return; }
			
			//STS 컬럼을 공란으로 변경한다.
			ComClearObject(formObj.status);	
			
			//메인 메뉴버튼의 상태를 활성화 / 비활성화 시킨다.
			ComBtnDisable(	"btn_Update"		);
			ComBtnEnable(	"btn_Request"		);
			ComBtnDisable(	"btn_Delete"		);
			ComBtnDisable(	"btn_Accept"		);
			ComBtnDisable(	"btn_AcceptCancel"	);				
		}
		else if (getVerStatus("Code") == "L") {
			if (!ComShowCodeConfirm("CGM20062", ComGetObjText(formObj.version))) { return; }
			
			//현재 버전의  S/C Exception Tariff 정보를 신규 버전에 저장을 한다.
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SC_UPDATE);
			
			if (ComGetObjValue(formObj.result) == "Y") {
				ComSetObjValue(formObj.sc_expt_ver_seq,		"");
				//신규 버전의  S/C Exception Tariff 를 조회한다.
				doActionRetrieve(IBSEARCH);
			}
			else {
				ComShowCodeMessage("CGM20063", "update");
				return;
			}
		}
		
		//Update버튼 클릭시 Version 을 변경하지 못하도록 비활성화(2009-11-13(금))
		with(formObj) {
			ComEnableManyObjects(false, version);
			version.className = "input2";
		}

		//S/C Exception Tariff 의 모든 컬럼들을 입력가능하도록 활성화 시킨다.
		editableGroup(true);
		
//		//쉬트 정렬의 활성화/비활성화 시킨다.
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
//		}		
	}			

	/**
	 * REQUEST 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionRequest() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================

		//1.Request 버튼 클릭시 데이터가 있는지 검사한다.
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("CGM20057", "request");
			return;
		}
		
		//2.Request 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("CGM10047")) {
				//변경된 내용에 대한 SAVE 수행 후 변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveGroup(chkResult[0], true)) return;	
			}else{
				return;
			}
		}
		
		//3.Request 상태로 변경하기 위해 매개변수를 알맞게 설정해준다.
		ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"R");
		
		//4.Version 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//5.Request 가 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			doActionRetrieve(IBSEARCH);
			
			//하단 Request, Delete하고 난 다음에는 최종 Version이 조회되는데, 이때 Version 컬럼을 활성화해주세요.
			with(formObj) {
				ComEnableObject(version, true);
				version.className		= "input";
			}	
		}
	}
	
	/**
	 * REQUEST CANCEL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionRequestCancel() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================

		//1.Request 버튼 클릭시 데이터가 있는지 검사한다.
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("CGM20057", "request Cancel");
			return;
		}
		
		//3.Request 상태로 변경하기 위해 매개변수를 알맞게 설정해준다.
		ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"T");
		
		//4.Version 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//5.Request 가 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			doActionRetrieve(IBSEARCH);
			
			//하단 Request, Delete하고 난 다음에는 최종 Version이 조회되는데, 이때 Version 컬럼을 활성화해주세요.
			with(formObj) {
				ComEnableObject(version, true);
				version.className		= "input";
			}	
		}
	}
	
	/**
	 * DELETE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionDelete() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}				
		
		if (ComShowCodeConfirm("CGM20064")) {
			
			doActionIBSheet(sheetSCObj, formObj, IBDELETE);
			
			//저장 Action 이 정상실행시 조회를 실행한다.
			if (ComGetObjValue(formObj.result) == "Y") {
				
				ComShowCodeMessage("CGM20065", "deleted");
				// 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 
				// Delete후 재 조회시 문제 해결
				ComClearCombo(formObj.version);
				formObj.sc_expt_ver_seq.value ="";
				
				doActionRetrieve(IBSEARCH);
				
				//하단 Request, Delete하고 난 다음에는 최종 Version이 조회되는데, 이때 Version 컬럼을 활성화해주세요.
				with(formObj) {
					ComEnableObject(version, true);
					version.className		= "input";
				}				
			}

		}
	}	

	/**
	 * ACCEPT 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionAccept() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		
		//Accept 하기 전에 확인하고 처리하도록 변경(2009-08-03)
		if (!ComShowCodeConfirm("CGM20066", "Accept")) { return; }
		
		//S/C 가 Filed STS 인지를 조회한다.
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_FILED);
		//결과를 받는다.
		var result = ComGetObjValue(formObj.result);

		//2014-01-10 Jonghee HAN 
		//01-09 회의결과 S/C Amend waiting logic - 변경 : S/C Amend 여부와 상관없이 Accept하면 무조건 wait으로 변경
		//(작업 완료후 Live Data Maint) & 조회용으로 기능 변경 
		//2014-03-31 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청, PRI를 통한 Chassis S/C Exception Creation시 Validation Logic 복원
		//1.Accept 버튼 클릭시 해당 S/C 가 Filed STS 가 아닐 경우 Status 를 Accepted 로 변경		
		if (result == "N") {
			ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"A");
		}
		//2.Accept 버튼 클릭시 해당 S/C 가 Filed STS 일 경우 Status 를 Live 로 변경
		else {
			ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"L");
		}

		//3.Version 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//4.Accept 가 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	
	/**
	 * ACCEPT CANCEL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionAcceptCancel() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver	 = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("CGM20056","New");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		
		//Accept 하기 전에 확인하고 처리하도록 변경(2009-08-03)
		if (!ComShowCodeConfirm("CGM20066", "cancel acceptance")) { return; }
		
		//1.Accept Cancel 버튼 클릭시 Status 를 "Requested" 로 변경한다.
		ComSetObjValue(formObj.chss_expt_ver_sts_cd,	"R");
		
		//2.Version 의 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//3.Accept Cancel 이 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	
	/**
	 * CLOSE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionClose() {
		var formObj = document.form;
		
		//1.Close 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("CGM20067")) {
				self.close();
			}
			return;
		}
		
		self.close();
	}	
	
	 /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */	 
	function validateForm() {
		var formObj		= document.form;
		var sheetSCObj		= sheetObjects[0];
		
		
		//저장할 데이터가 없을 경우
		if (fetchRowCount(sheetSCObj) == 0 ) {
			ComShowCodeMessage("CGM20057", "Save");
			return false;
		}
		
		if(formObj.eff_dt.value == ""){
			ComShowCodeMessage("CGM20075");
			ComSetFocus(formObj.eff_dt);
			return false;
		}
		
		if(ComGetDaysBetween(formObj.eff_dt.value, formObj.exp_dt.value) < 0){
			ComShowCodeMessage("CGM20073");
			return false;
		}
		
		for(var i = 1; i < sheetSCObj.RowCount+1; i++){
			if(sheetSCObj.CellValue(i, "loc_cd") == ""){
				ComShowCodeMessage("CGM20074", i);
				sheetSCObj.SelectCell(i, "loc_cd");
				return false;
			}
		}
		
		var chkLoc = "";
		var chkCust = "";
		var chkType = "";
		var num = 0;
		var check = false;
		var check1 = false;
		var check2 = false;
		var check3 = false;
		var check4 = false; // free days 유무 판별
		for(var i = 1; i < sheetSCObj.RowCount+1; i++){
			if(sheetSCObj.CellValue(i, "cud_flg") == "D"){
				continue;
			}
			if(sheetSCObj.CellValue(i, "ft_dys") > 0 && !check4){
				check4 = true;
			}
			chkLoc = sheetSCObj.CellValue(i, "loc_cd");
			chkCust = sheetSCObj.CellValue(i, "cust_cd");
			chkType = sheetSCObj.CellValue(i, "chss_cntr_cgo_tp_cd");
			if(i != sheetSCObj.RowCount){
				for(j = i+1; j <sheetSCObj.RowCount+1; j++){
					if(chkLoc == sheetSCObj.CellValue(j, "loc_cd")){
						if(sheetSCObj.CellValue(i, "cust_cd") == sheetSCObj.CellValue(j, "cust_cd")
								&&sheetSCObj.CellValue(i, "cmdt_cd") == sheetSCObj.CellValue(j, "cmdt_cd")
								&&sheetSCObj.CellValue(i, "chss_cntr_cgo_tp_cd") == sheetSCObj.CellValue(j, "chss_cntr_cgo_tp_cd")){
							num = j;
							check = true;
							break;
						}
						
						if((sheetSCObj.CellValue(i, "cust_cd") == "ALL" && sheetSCObj.CellValue(j, "cust_cd") != 'ALL')||
								(sheetSCObj.CellValue(i, "cust_cd") != "ALL" && sheetSCObj.CellValue(j, "cust_cd") == 'ALL')){
							num = j;
							check1 = true;
							break;
						}
						
						if(chkCust == sheetSCObj.CellValue(j, "cust_cd")){
							if((sheetSCObj.CellValue(i, "chss_cntr_cgo_tp_cd") == "ALL" && sheetSCObj.CellValue(j, "chss_cntr_cgo_tp_cd") != 'ALL')
									||(sheetSCObj.CellValue(i, "chss_cntr_cgo_tp_cd") != "ALL" && sheetSCObj.CellValue(j, "chss_cntr_cgo_tp_cd") == 'ALL')){
								num = j;
								check2 = true;
								break;
							}
							
							if(chkType == sheetSCObj.CellValue(j, "chss_cntr_cgo_tp_cd")){
								if((sheetSCObj.CellValue(i, "cmdt_cd") == "ALL" && sheetSCObj.CellValue(j, "cmdt_cd") != 'ALL')
										||(sheetSCObj.CellValue(i, "cmdt_cd") != "ALL" && sheetSCObj.CellValue(j, "cmdt_cd") == 'ALL')){
									num = j;
									check3 = true;
									break;
								}
							}
						}
					}
				}
			}
			if(check){
				break;
			}
		}
		
		if(check){
			ComShowCodeMessage("CGM20060", num, "");
			sheetSCObj.SelectCell(num, "seq");
			return false;
		}
		
		if(check4 && formObj.ft_flg.value == "N"){
			ComShowCodeMessage("COM12114", "Use Free Days");
			formObj.ft_flg.focus();
			return false;
		}
		
		//CSR 선처리 2014-01-20 Jonghee HAN SCC외 ALL 관련 Validate logic 해제 
//		if(check1){
//			ComShowCodeMessage("CGM20071", num, "Customer Code");
//			sheetSCObj.SelectCell(num, "cust_cd");
//			return false;
//		}
//		
//		if(check2){
//			ComShowCodeMessage("CGM20071", num, "CNTR/Cargo");
//			sheetSCObj.SelectCell(num, "chss_cntr_cgo_tp_cd");
//			return false;
//		}
//		
//		if(check3){
//			ComShowCodeMessage("CGM20071", num, "Commodity Code");
//			sheetSCObj.SelectCell(num, "cmdt_cd");
//			return false;
//		}
		
		if(!ComShowCodeConfirm('CGM10047')){
			return false;
		}
		
		return true;
	}
	 
	/**
	 * S/C Exception Tariff 의 화면입력에 대한 기등록된 데이터에서 중복여부를 체크하는 함수
	 */		 
	 function dupValidate() {
//		var formObj			= document.form;
//		var sheetSCObj		= sheetObjects[0];
//		
// 
//		return false;
	}

	
	/**
	 * Actual Customer 에는 중복된 코드값이 있어서는 안된다.
	 */			
	function validateActualCustomer(selectedRow) {
		var sheetSCObj		= sheetObjects[0];	
		//중복체크
		var dupRows = sheetSCObj.ColValueDupRows("sc_expt_grp_seq" + "|" + "cust_cd", false, true);
		if (dupRows != "") {
			ComShowCodeMessage("CGM20060", sheetSCObj.CellValue(selectedRow, "Seq"), "Actual Customer");
			return false;
		}
		return true;
	}	
	
	/**
	 * Commodity 에는 중복된 코드값이 있어서는 안된다.
	 */
	function validateCommodity(selectedRow) {
		var sheetSCObj		= sheetObjects[0];

		//중복체크			
		var dupRows = sheetSCObj.ColValueDupRows("sc_expt_grp_seq" + "|" + "cmdt_cd", false, true);
		if (dupRows != "") {
			ComShowCodeMessage("CGM20060", sheetSCObj.CellValue(selectedRow, "Seq"), "Commodity");
			return false;
		}
		return true;
	}
	
	/**
	 * 주어진 Sheet 내 마지막 Row 데이터 중 주어진 컬럼이 Empty 인지를 체크하는 함수
	 * 선택항목이고, 입력된 데이터가 없을 경우에는 false 를 반환한다.
	 */			
	function isEmptyColumnOfLastRow(sheetObj, COL) {
		var isEmptyColumn = false;
		
		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) != "D") {
					if(COL == "cmdt_cd") {
						if (ComTrim(CellText(row, COL)) == "")
							isEmptyColumn = true;
					}else{
						if (ComTrim(CellValue(row, COL)) == "") 
							isEmptyColumn = true;
					}
					break;
				}
			}
		}

		return isEmptyColumn;
	}
			
	/**
	 * 주어진 Sheet 내 데이터가 존재하는지를 체크하는 함수 
	 */
	function fetchRowCount(sheetObj) {
		var totCount = 0;
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					totCount++
				}
			}
		}
		return totCount;	
	}
		
	/**
	 * 주어진 값이 '' 일 경우 ' ' 로 변경해주는 함수
	 */	
	function changeNullToSpace(str) {
		return ComTrim(str).length == 0 ? " " : ComTrim(str);
	}	
	
	/**
	 * 현재 버전의 Status Code 나 Text 를 반환한다.
	 */		
	function getVerStatus(type) {
		var formObj = document.form;
		var status = ComTrim(ComGetObjValue(formObj.version));		//화면 데이터
		if (status.indexOf(":") != -1) {
			var stsArr = status.split(":");
			if (type == "Code") { 
				return stsArr[0]; 
			}
			else { 
				return stsArr[1]; 
			}
		}

		return "";
	}
	
	/**
	 * S/C Exception Tariff History 조회를 위한 팝업을 띄우는 함수.
	 */
	function openWinSearchTariffHistory() {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		var sCNo		= ComTrim(ComGetObjValue(formObj.sCNo));
		var status		= ComTrim(ComGetObjValue(formObj.status));
		var propNo		= ComTrim(ComGetObjValue(formObj.proposalNo));
		var verSeq		= ComTrim(ComGetObjText(formObj.version));
		var count		= fetchRowCount(sheetSCObj);
		var caller		= ComTrim(ComGetObjValue(formObj.caller));
		
		if (caller == "2006" || caller == "2007" || caller == "3107") {
			isActBtnCopy = "N";
		}
		else if (status == "" || status == "Temp. Saved") {
			isActBtnCopy = "Y";
		}
		else {
			isActBtnCopy = "N";
		}
		
		var params = "sc_no=" + sCNo;
		params += "&prop_no=" + propNo;
		params += "&ver_seq=" + verSeq;
		params += "&status=" + status;
		params += "&rowcount=" + count + "";
		params += "&is_copy=" + isActBtnCopy;
		
		ComOpenPopup("EES_CGM_1210.do?" + params, 920, 455, "copyTariffHistory", "1,0,1,1,1,1,1", true);
	}
	
	/**
	 * S/C Exception Tariff History 에서 선택한 버전의 S/C Exception Tariff 를 현재 버전에 생성해주는 함수
	 */	
	function copyTariffHistory(aryPopupData) {
		var formObj		= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//S/C Exception Tariff History 팝업화면에서 선택한 버전
		ComSetObjValue(formObj.hist_prop_no,			aryPopupData[0]);
		ComSetObjValue(formObj.sc_expt_hist_ver_seq,	aryPopupData[1]);
		
		//현재 버전의 S/C Exception Tariff 정보가 있으면 모두 삭제하고, 
		//현재 버전에 S/C Exception Tariff History 팝업화면에서 선택한 버전의 S/C Exception Tariff 정보로 생성한다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF_HISTORY);
		
		if (ComGetObjValue(formObj.result) == "Y") {

			//신규 버전의  S/C Exception Tariff 를 조회한다.
			doActionRetrieve(IBSEARCH);
		}
		else {
			ComShowCodeMessage("DMT00008", "copy");
			return;
		}
	}
	
	/**
	 * 화면이 팝업으로 나타날때, 호출자에 따라서 display 할 버튼이 달라지도록 처리하는 함수
	 */	
	function displayBtnByCaller() {
		var formObj = document.form;
		
		switch(ComGetObjValue(formObj.caller)) {
			case "2006":
			case "2007":
			case "3107":
				btnNewLayer.style.display				= 'none';
				btnUpdateLayer.style.display			= 'none';
				btnSaveLayer.style.display			= 'none';
				btnDeleteLayer.style.display			= 'none';
				btnAcceptLayer.style.display			= 'none';
				btnAcceptCancelLayer.style.display	= 'none';
				
				//S/C Group
				btnAddSCLayer.style.display			= 'none';
				btnCopySCLayer.style.display			= 'none';
				btnSaveSCLayer.style.display			= 'none';
				btnDelSCLayer.style.display			= 'none';
				btnDownSCLayer.style.display			= 'inline';
				
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display  = 'none';
				btnDelMultiCoverageLayer.style.display  = 'none';
				
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display		= 'none';
				btnDelFreeTimeLayer.style.display		= 'none';
				
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display  = 'none';
				btnDelRateAdjustmentLayer.style.display  = 'none';
				
				//Customer
				btnAddCustomerLayer.style.display		= 'none';
				btnDelCustomerLayer.style.display		= 'none';
				
				//Commodity
				btnAddCommodityLayer.style.display	= 'none';
				btnDelCommodityLayer.style.display	= 'none';
				
				btnLineLayer.style.display				= 'none';
				btnCloseLayer.style.display			= 'inline';
				break;
				
			default:
				btnNewLayer.style.display				= 'inline';
				btnUpdateLayer.style.display			= 'inline';
				btnSaveLayer.style.display			= 'inline';
				btnDeleteLayer.style.display			= 'inline';
				btnAcceptLayer.style.display			= 'inline';
				btnAcceptCancelLayer.style.display	= 'inline';
				
				//S/C Group
				btnAddSCLayer.style.display			= 'inline';
				btnCopySCLayer.style.display			= 'inline';
				btnSaveSCLayer.style.display			= 'inline';
				btnDelSCLayer.style.display			= 'inline';
				btnDownSCLayer.style.display			= 'inline';
				
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display  = 'inline';
				btnDelMultiCoverageLayer.style.display  = 'inline';
				
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display		= 'inline';
				btnDelFreeTimeLayer.style.display		= 'inline';
				
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display  = 'inline';
				btnDelRateAdjustmentLayer.style.display  = 'inline';
				
				//Customer
				btnAddCustomerLayer.style.display		= 'inline';
				btnDelCustomerLayer.style.display		= 'inline';
				
				//Commodity
				btnAddCommodityLayer.style.display	= 'inline';
				btnDelCommodityLayer.style.display	= 'inline';
				
				btnLineLayer.style.display				= 'inline';
				btnCloseLayer.style.display			= 'inline';   
		}
	}

	/**
	 * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
	 */
	function handleNullString(sVal) {

		 if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

		 return ComTrim(sVal);
	 }
	
	/**
	 * 추가, 수정, 삭제된 항목이 있는지 검색하는 함수
	 */
	function isChangedSCExceptionTariff(initSheetNo) {
		var result = new Array(); 
		
		//초기값 설정
		result[0] = false;
		
		//검색을 실행할 쉬트번호가 매개변수로 넘어오지 않을경우에는 Group 쉬트부터 검색을 실행한다.
		if (initSheetNo == undefined) initSheetNo = 0;

		for (var sheetNo = initSheetNo ; sheetNo < sheetObjects.length ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					switch(RowStatus(row)) {
						case "I":
							result[0] = true;
							result[1] = row;
							result[2] = "추가";
							result[3] = "Row Number " + CellValue(row, "Seq") + "has been inserted. Please Check it again."
							return result;
							break;
							
						case "U":
							result[0] = true;
							result[1] = row;
							result[2] = "수정";
							result[3] = "Row Number " + CellValue(row, "Seq") + "has been changed. Please Check it again."
							return result;
							break;
							
						case "D":
							result[0] = true;
							result[1] = row;
							result[2] = "삭제";							
							result[3] = "Row Number " + CellValue(row, "Seq") + "has been deleted. Please Check it again.";
							return result;
							break;
					}
				}
			}
		}
		
		return result;
	}
	
	/*
	 * Coverage 값이 Empty 일 경우에는 Space 1칸으로 변환하여 반환하는 함수
	 */
	function convertEmptyToSpace(sVal) {
		
		if (sVal == "")
			return "' '";
		else
			return "'" + sVal + "'";
	}
	  
	/* current date */  
	function getTodate() {
		var today = new Date();
		var year = today.getYear();
		var month = today.getMonth() + 1;
		var day = today.getDate();
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var currDate = year +""+ month +""+  day;// 현재 날짜 생성
		return currDate;
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			for (var i = 1; i <= LastRow; i ++) {
				var celcnt = document.form.sheet1_cnt.value ;
//				if(CellValue(i, "new_flg") == "Y") {
//					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
//					for (var j = 1; j <= celcnt; j ++) {
//						sheetObj.CellFont("FontBold", i, j) = true;
//					}
//				}
				
				if(CellValue(i, "cust_cd")==""){
					CellValue2(i, "cust_cd") = "ALL";
				}
				
				if(CellValue(i, "chss_cntr_cgo_tp_cd")==""){
					CellValue2(i, "chss_cntr_cgo_tp_cd") = "ALL";
				}
				
				if(CellValue(i, "cmdt_cd")==""){
					CellValue2(i, "cmdt_cd") = "ALL";
				}
				
				if(CellValue(i, "cud_flg") == "D"){
					RowFontColor(i) = RgbColor(255,0,0);
					RowEditable(i) = false;
				}else if (CellValue(i, "cud_flg") == "I"){
					RowFontColor(i) = RgbColor(0,0,255);
					for (var j = 1; j <= celcnt; j ++) {
						CellFont("FontBold", i, j) = true;
					}
				}
				
				RowStatus(i) = "R";
			}
		}
	}
	
	/*
	 * Sheet5(Actual Customer) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		switch(sheetObj.ColSaveName(Col)) {
			case "cust_cd":
				var row_value = sheetObj.CellText(Row, Col);
				param_row = Row;
				if(row_value.length < 3) {
					ComShowCodeMessage( "CGM20042" , "Customer code" );
					sheetObj.CellValue2(Row, "cust_cd") = "";
					sheetObj.CellValue2(Row, "cust_nm") = "";
				} else{
					if(row_value == "ALL"){
						sheetObj.CellValue2(Row, "cust_nm") = "";
						sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
						sheetObj.CellValue2(Row, "cust_seq") = "";
						sheetObj.CellEditable(Row, "cmdt_nm") = false;
					}else{
						var cust_cnt_cd = row_value.substring(0,2);
						var cust_seq	= row_value.substring(2);
						if(isNaN(cust_seq)){
							ComShowCodeMessage( "CGM20042" , "Customer code" );
							sheetObj.CellValue2(Row, "cust_cd") = "";
							sheetObj.CellValue2(Row, "cust_nm") = "";
						}else{
							if (ComLpad(cust_seq,6,"0")!="000000"){
								sheetObj.CellValue2(Row, "cust_cd") = cust_cnt_cd+ComLpad(cust_seq,6,"0");
							}
							
							doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02);	//입력 코드 validation 체크
							sheetObj.CellEditable(Row, "cust_nm") = false;
						}
					}
				}
				
				break;
				
			case "cmdt_cd":
				var row_value = sheetObj.CellText(Row, Col);
				param_row = Row;
				if (row_value == "ALL") {
					sheetObj.CellValue2(Row, "cmdt_nm") = "";
					sheetObj.CellEditable(Row, "cmdt_nm") = false;
				} else {
					doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);	//입력 코드 validation 체크
					sheetObj.CellEditable(Row, "cmdt_nm") = false;
				}
				
				break;
			
			case "loc_cd":
				var param = "f_cmd=" + SEARCH
				param += "&loc_cd=" + sheetObj.CellValue(Row, "loc_cd");
				
				var sXml = sheetObj.getSearchXml("cgm_Check_LocationGS.do", param);
				// 데이터 건수
				var dataCount = ComGetTotalRows(sXml);
				if(dataCount==0){
					ComShowCodeMessage('CGM10009','location cd');
					sheetObj.Cellvalue2(Row, "loc_cd") = "";
					sheetObj.SelectCell(Row, "loc_cd");
				}
				
				break;
				
		}		
	}
	
	/**
	 * Form의 Conrol 를 초기화 시킨다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 
	 * @version 2013.03.21
	 */
	function initControl() {
		var formObj = document.form;
		
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm  ('blur',		'obj_blur',		document.form);	//- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	document.form);	//- 포커스 들어갈때
		axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
		axon_event.addListenerFormat('change',		'obj_change',	document.form);		//- 변경될때
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
		obj = event.srcElement;
		if(obj.dataformat == null) return;
		switch(obj.name) {
		case "eff_dt":
			ComClearSeparator(event.srcElement);
			break;	
		
		} 
		
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
				if(obj.name == "sCNo") {
					ComKeyOnlyAlphabet('uppernum');
				}else if(obj.name == "proposalNo") {
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
		var obj	  = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{	  
				case "sCNo" :
				case "proposalNo" :
					if(popUpFlg != "Y"){
						if(ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.proposalNo) != ""){
							doActionIBSheet(sheetObj, formObj, IBSEARCH_INIT);
							if(ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.proposalNo) != ""){
								doActionRetrieve(IBSEARCH);
							}
						}else{
							ComShowCodeMessage("CGM20077");
							return;
						}
					}
					break;
			}
		} 
	}
	/* 개발자 작업  끝 */