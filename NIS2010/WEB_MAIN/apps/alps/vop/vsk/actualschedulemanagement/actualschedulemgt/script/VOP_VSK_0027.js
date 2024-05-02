/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0027.js
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.03 정진우
* 1.0 Creation
* 
* History
* 2010.12.23 진마리아 선CSR Actual SKD Input Ratio Report 로직 변경
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.08.09 김민아    CHM-201112647-01 Actual SKD input Ratio Tab 및 조회 로직 변경 요청
* 2013.09.05 정상기    CHM-201326469 [VSK] Actual SKD Input Ratio Report - 조회조건 OPR code 추가
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
     * @class vop_vsk_0027.jsp : vop_vsk_0027.jsp 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0027() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.initCombo            	= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	// 현재 포커스를 가지고 있는 객체명 변수
	var focusObj = null;

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// EDI(Tab - 5)
//	var glbSaveRcvDt = "";
//	var glbSaveRcvSeq = "";
	
	/**
     * Object태그를 이용하여 IBMultiCombo 개체를 생성한다. 추가적으로 setComboObject자바스크립트 함수를 호출하고, IBMultiCombo의 모든 Event Catch 태그도 포함한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;script language="javascript"&gt;ComComboObject('combo1', 1, 100, 0, 2);&lt;/script&gt;
     *     &lt;script language="javascript"&gt;ComComboObject('combo1', 2, 150, 1);&lt;/script&gt;
     * </pre>
     * @param {string} comboid      필수,IBCombo Object ID 문자열
     * @param {int}    iColCnt      선택,콤보리스트에 컬럼의 개수로 최소 1이상, default=1
     * @param {int}    iWidth       선택,Object의 넓이, default=150
     * @param {int}    iStyle       선택,편집가능불가능여부 (0=편집가능, 1=편집불가능), default=0
     * @param {int}    iCss       	선택,스타일 처리 (input=0 input1=1 input1_1=2 input2=3 input2_1=4)
     * @param {int}    iShowCol     선택,멀티 컬럼일때 보여주고 싶은 컬럼의 인덱스, default=0
     * @param {int}    iEdit       	선택,에디터 상태에서 콤보리스트에 없는 값의 유지 여부 , default=false
     * @param {int}    iTab       	선택,탭오더의 설정
     * @return 없음
     * 
     * function ComComboObject(comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab)
     * ComComboObject('vskd_port_rhq_cd',1,60,1,0);
     */
	var comboObjects = new Array();
	var comboCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	tabLoad[2]= 0;
	tabLoad[3]= 0;
	tabLoad[4]= 0;
	
	//각 Tab 별 조회 조건을 담는다.
	var glbFormDataTab1 = null;
	var glbFormDataTab2 = null;
	var glbFormDataTab3 = null;
	var glbFormDataTab4 = null;
	var glbFormDataTab5 = null;
	
	//각 Tab 별 sls_ofc_cd Combo List 를 담는다.
	var glbSlsOfcArrTab1 = null;
	var glbSlsOfcArrTab2 = null;
	var glbSlsOfcArrTab3 = null;
	var glbSlsOfcArrTab4 = null;
	var glbSlsOfcArrTab5 = null;
	
	var gblSubTotalColor = null;
	var glbGrandTotalColor = null;
	
	//Color 전역변수
	var glbGreyColor = null;


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
		var sheetObj = getCurrentSheet();
		var formObj = document.form;

     	try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_t1Retrieve":
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
					formObj.page_no.value = "1";
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
 				case "btn_t1RLaneRegist":
 					doActionIBSheet(sheetObj, formObj, COMMAND01);
 					break;
 					
 				case "btn_t2Retrieve":
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
 					formObj.page_no.value = "1";
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
 				case "btn_t2New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 					
 				case "btn_t2DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;

 				case "btn_t3Retrieve":
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
 					formObj.page_no.value = "1";
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
 				case "btn_t3New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 					
 				case "btn_t3DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
 					
 				case "btn_t4Retrieve":
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
 					formObj.page_no.value = "1";
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
 				case "btn_t4New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 					
 				case "btn_t4DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
 					
 				case "btn_t5Retrieve":
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
 					formObj.page_no.value = "1";
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
 				case "btn_t5New":
 					doActionIBSheet(sheetObj, formObj, IBCLEAR);
 					break;
 					
 				case "btn_t5Retry":
 					doActionIBSheet(sheetObj, formObj, IBSAVE);
 					break;
 					
 				case "btn_t5DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;

				case "btn_port":
					doActionIBSheet(sheetObj, formObj, COMMAND11);
 					break;

				case "btn_cal1":
					doActionIBSheet(sheetObj, formObj, COMMAND12);
 					break;
 					
				case "btn_cal2":
					doActionIBSheet(sheetObj, formObj, COMMAND14);
 					break;

				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND13);
 					break;

				case "btn_retrieve":
					
					/* date format validation check logic ::2013-04-23 */
					var start_date 	= formObj.fm_dt.value;
					var end_date 	= formObj.to_dt.value;
					if(!ComIsDate(start_date))	return;
					if(!ComIsDate(end_date))	return;
					////////////////////////////////////////////////////
					
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;
 					
				case "btns_search_crr":
					var sUrl = "/hanjin/COM_ENS_0N1.do";
					ComOpenPopupWithTarget(sUrl, 426, 450, "3:crr_cd", "1,0,1,1,1", true);
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
	 * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
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

		for(var i=0; i<sheetObjects.length; i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		for(var k=0; k<tabObjects.length; k++){
			initTab(tabObjects[k],k+1);
		}
		
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		//CTRL Combo Setting.
		doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
		
		setScsFlgCombo();
		
		glbFormDataTab1 = new Usr_Condi_FormData();
		glbFormDataTab2 = new Usr_Condi_FormData();
		glbFormDataTab3 = new Usr_Condi_FormData();
		glbFormDataTab4 = new Usr_Condi_FormData();
		glbFormDataTab5 = new Usr_Condi_FormData();
		
		glbSubTotalColor = sheetObjects[0].RgbColor(247, 225, 236); 
		glbGrandTotalColor = sheetObjects[0].RgbColor(247, 225, 236);
		glbGreyColor = sheetObjects[0].RgbColor(219, 219, 219);
		glbOverDaysColor = sheetObjects[0].RgbColor(247, 225, 236);

		initControl();
    }


    /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 390;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(6, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false);

					var HeadTitle = "Revenue Lane for Audit 1|Revenue Lane for Audit 1|Revenue Lane for Audit 1| Revenue Lane for Audit 2| Revenue Lane for Audit 2| Revenue Lane for Audit 2";
					var HeadTitle2 = "No.|Lane Code|Lane Name|No.|Lane Code|Lane Name";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	false,    	prefix+"seq1",      	false,      "",      dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,		prefix+"vsl_slan_cd1",  false,      "",      dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		320,	daLeft,		false,		prefix+"vsl_slan_nm1",  false,      "",      dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	false,    	prefix+"seq2",      	false,      "",      dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,		prefix+"vsl_slan_cd2",  false,      "",      dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		320,	daLeft,		false,		prefix+"vsl_slan_nm2",  false,      "",      dfNone, 			0,     false,       false);
					
					CountPosition = "0";
				}
				break;


			case 2:      //t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 390;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false);

//					var HeadTitle = "CTRL HQ|CTRL Office|Port|Target Lane\nCount|Target VVD\nCount|Port Calling\nCount|Inputted\nCount|Over Input\nCount|Input\nRatio|Overdue\nRatio|Observance\nRatio";
					var HeadTitle1 = "CTRL HQ|CTRL Office|Port|Count|Count|Count|Count|Count|Ratio|Ratio|Ratio";
					var HeadTitle2 = "CTRL HQ|CTRL Office|Port|Target Lane|Target VVD|Port Calling|Inputted|Over Input|Input|Overdue|Observance";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		prefix+"rhq",      			false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,    	prefix+"ctrl_ofc",      	false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		prefix+"port_cd",     		false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"target_lane_cnt",   false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"target_vvd_cnt",  	false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"ttl_port_cnt",  	false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"inputted_cnt",  	false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"over_input_cnt",  	false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"input_rto",  		false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"overdue_rto",  		false,      "",      	dfNone, 			0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"observance_rto", 	false,      "100-|" + prefix+"overdue_rto|" ,      	dfNone, 			0,     false,       false);
 						
					CountPosition = "0";
				}
				break;

			case 3:      //t3sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 367;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 14, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(18, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					var HeadTitle = "Seq.|Lane|Office|Port|TMNL|VVD|ETA|ATA|Reported Date|Over days|ETB|ATB|Reported Date|Over days|ETD|ATD|Reported Date|Over days";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);


					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,    	40,		daCenter,	true,    	prefix+"seq");
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		prefix+"vsl_slan_cd",	false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		prefix+"sls_ofc_cd",	false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	false,		prefix+"vps_port_cd",	false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	false,		prefix+"tml_cd",		false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		prefix+"vvd",  			false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"vps_eta_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"act_arr_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"rpt_ata",		false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,		prefix+"ata_over_days",	false,		"",      dfNullFloat, 		4,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"vps_etb_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"act_brth_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"rpt_atb",		false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,		prefix+"atb_over_days",	false,		"",      dfNullFloat, 		4,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"vps_etd_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"act_dep_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"rpt_atd",		false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,		prefix+"atd_over_days",	false,		"",      dfNullFloat, 		4,     true,       true);

					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_arr_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"rpt_ata", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_brth_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"rpt_atb", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_dep_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"rpt_atd", "####-##-## ##:##", "-|:");
 						
//					CountPosition = "0";
					
					FrozenCols = SaveNameCol(prefix+"vps_eta_dt");
                }
				break; 
                 
			case 4:      //t4sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 390;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					var HeadTitle = "Seq.|Lane|Port|TMNL|VVD|ETA|ETB|ETD|ATA|ATB|ATD";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,   	40,		daCenter,	true,    	prefix+"seq");
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,		prefix+"vsl_slan_cd",	false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		prefix+"vps_port_cd",	false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,		prefix+"tml_cd",		false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"vvd",			false,		"",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		prefix+"vps_eta_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		prefix+"vps_etb_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		prefix+"vps_etd_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		prefix+"act_arr_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		prefix+"act_brth_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"act_dep_dt",	false,		"",      dfUserFormat2, 	0,     true,       true);

					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_arr_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_brth_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_dep_dt", "####-##-## ##:##", "-|:");

					CountPosition = "0";
				}
				break; 
				
			case 5:      //t5sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 390;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(30, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					var HeadTitle1 = "|CHK|Lane|Port|TMNL|SML|SML|SML|SML|Receiving Date|Result|F/F|F/F|F/F|F/F|F/F|F/F|F/F|F/F";
					var HeadTitle2 = "|CHK|Lane|Port|TMNL|VVD|ATA|ATB|ATD|Receiving Date|Result|Sender ID|IMO No.|Call Sign|Ref.Code|VVD|ATA|ATB|ATD";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	46,		daCenter,	true,    	prefix+"chk_flg",			true);
					InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	true,		prefix+"vsl_slan_cd", 		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"vps_port_cd",		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"tml_cd",    		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"vvd",   			false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"act_arr_dt",   		false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"act_brth_dt",   	false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"act_dep_dt",   		false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"cre_dt",   			false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			260,	daLeft,		true,		prefix+"rslt_msg",   		false,		"",      	dfNone, 		0,     		false,       false);

					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"sndr_trd_prnr_id",	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"lloyd_no",   		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"call_sgn_no",   	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"shp_call_no",   	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"edi_vvd",   		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"edi_act_arr_dt",   	false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"edi_act_brth_dt",   false,		"",      	dfUserFormat2, 	0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"edi_act_dep_dt",   	false,		"",      	dfUserFormat2, 	0,     		false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"rcv_seq",   		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"edi_vsl_nm",   		false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"edi_skd_voy_no",   	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"edi_skd_dir_nm",   	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"yd_cd",   			false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"scs_flg",  			false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"rcv_dt",   			false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"clpt_ind_seq",   	false,		"",      	dfNone, 		0,     		false,       false);
//					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"sndr_trd_prnr_id",  false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"rcvr_trd_prnr_id",  false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"edi_msg_tp_id",   	false,		"",      	dfNone, 		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"edi_msg_proc_id",   false,		"",      	dfNone, 		0,     		false,       false);

					InitUserFormat2(0, prefix+"edi_act_arr_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"edi_act_brth_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"edi_act_dep_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_arr_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_brth_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"act_dep_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix+"cre_dt", "####-##-## ##:##", "-|:");
					
					CountPosition = "2";
					
					FrozenCols = SaveNameCol(prefix+"vvd");
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
					InsertTab( cnt++ , "R/Lane" , -1 );
					InsertTab( cnt++ , "Input Ratio" , -1 );
					InsertTab( cnt++ , "Detail" , -1 );
					InsertTab( cnt++ , "Uncompleted Report" , -1 );
					InsertTab( cnt++ , "EDI SKD Monitoring" , -1 );
				}
				break;
		}
	}
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) { 
	    	case "vskd_port_rhq_cd": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
	    	case "sls_ofc_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
   	    	case "tml_cd":
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("70|300");
  					DropHeight = 160;
  					Enable = false;
   		    	}
   	    		break;
   	    	case "scs_flg":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("60");
  					DropHeight = 80;
  					Enable = false;
   		    	}
   	    		break;
   	     }
   	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)){
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value = SEARCHLIST01;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t2sheet1"){
						formObj.f_cmd.value = SEARCHLIST02;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t3sheet1"){
						formObj.f_cmd.value = SEARCHLIST03;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t4sheet1"){
						formObj.f_cmd.value = SEARCHLIST04;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						
						showSheetData(sheetObj, formObj, sXml);
					}
					else if ( sheetObj.id == "t5sheet1"){
						formObj.f_cmd.value = SEARCHLIST05;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t5sheet1_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
						ComOpenWait(false);
						
						//All Check 초기화
						sheetObj.CheckAll(sheetObj.id+"_chk_flg") = 0;
						
						showSheetData(sheetObj, formObj, sXml);
					}
				}
				break;
				
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH10;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
					
					return sXml;
				}
				break;

			case COMMAND01:      // R/Lane Regist
				sUrl = "/hanjin/VOP_VSK_0234.do";
        		ComOpenPopup(sUrl, 720, 450, "returnRLaneRegist", "none", true);
				break;

			case COMMAND02:      // Open
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
				
				var rhqCdArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				var rhqDescArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				
				//CTRL Combo Setting.
				appendMultiComboItem(getComboObject("vskd_port_rhq_cd"), rhqCdArr, rhqDescArr, "", "DEF");
//				appendMultiComboItem(getComboObject("scs_flg"), "ALL", "", "", "DEF");
				break;

			case COMMAND03:      // Control Office
				formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
				
				return sXml;
//				var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
//				var ctrlOfcArr = null;
//				if(sCtrlOfc != null && sCtrlOfc != undefined){
//					ctrlOfcArr = ("ALL|"+sCtrlOfc).split("|");	//
//				}
//				
//				//CTRL Combo Setting.
//				appendMultiComboItem(getComboObject("sls_ofc_cd"), ctrlOfcArr, ctrlOfcArr, "", "DEF");
				break;

			case COMMAND04:      //vps_port_cd
				if(validateForm(sheetObj, formObj, sAction)){
					var sXml = null;
					if (sheetObj.id == "t5sheet1"){
						formObj.f_cmd.value = SEARCH04;
						var sParam = FormQueryString(formObj);
						sXml = sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
					}else{
						formObj.f_cmd.value = SEARCH03;
						var sParam = FormQueryString(formObj);
						sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
					}
					
					return sXml;
				}else{
					return "";
				}
				break;
				
			case COMMAND11:      // btn_port
				if(beforetab > 0){
					//sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
					//sUrl = "/hanjin/VOP_VSK_0043.do?f_cmd=" + COMMAND13;
					sUrl = "/hanjin/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
					ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
				}
				break;
				
			case COMMAND12:      // btn_cal1
				var cal = new ComCalendar();
				cal.select(formObj.fm_dt, 'yyyy-MM-dd');
				break;
				
			case COMMAND14:      // btn_cal2
				var cal = new ComCalendar();
				cal.select(formObj.to_dt, 'yyyy-MM-dd');
				break;
				
			case COMMAND13:      // btn_vvd
				if(beforetab != 0){
					var vsl_cd = formObj.vsl_cd.value;
	            	
	            	if(vsl_cd == ""){
	            		//sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
	            		//sUrl = "/hanjin/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
	            		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y"; //[CHM-201109577-01]
	            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
	            	}else{
	            		//sUrl = "/hanjin/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		//sUrl = "/hanjin/VOP_VSK_0230.do?f_cmd=" + COMMAND17 + "&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
	            	}
				}
				break;

			case IBSAVE:        //Retry
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI05;
					
					setSavePointKey(sheetObj, formObj);
					
					var sParam = ComGetSaveString(sheetObj, false, false, sheetObj.id+"chk_flg");
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0027GS.do", sParam);
					ComOpenWait(false);
					
					sheetObj.LoadSaveXml(sXml);
					//SAVE OK 일 경우 저장된 내용 다시 조회.
					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				
				break;

			case IBCLEAR:        //NEW
				clearAllData(sheetObj, formObj);
				break;

			case IBDOWNEXCEL:        	//엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
				
				////////////::jskjskjsk:://///////////////////////////////////
			case SEARCH04: // Carrier Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH04;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			
			var crr_cd = ComGetEtcData(sXml, "crr_cd");
			if(crr_cd==null){
				ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
				formObj.crr_cd.value = "";
				formObj.crr_cd.focus();
			}
			break;
		}
	}



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction){
		var sheetId = sheetObj.id;
		switch(sAction) {
			case IBSEARCH:      //조회
				
				// fm_dt가 to_dt보다 앞선일자가 아니면 오류
				if(!checkPeriod(formObj.fm_dt, formObj.to_dt)){
					ComShowCodeMessage("VSK00025", "End date", "start date");
					return false;
				}
				
				if (sheetId == "t1sheet1"){
					// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}else if(sheetId == "t2sheet1"){
					if(ComIsNull(formObj.fm_dt)){
						ComShowCodeMessage('VSK00027', "From date");
						formObj.fm_dt.focus();
						return false;
					}else if(ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "To date");
						formObj.to_dt.focus();
						return false;
					}
					// 검색 기간 Check(1년 이내에서만 검색 가능하게).
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
						ComShowCodeMessage("VSK00105", "1 year");
						return false;
					}
				}else if(sheetId == "t3sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
//					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
//						ComShowCodeMessage("VSK00105", "1 month");
//						return false;
//					}
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
						ComShowCodeMessage("VSK00105", "1 year");
						return false;
					}
				}else if(sheetId == "t4sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}else if(sheetId == "t5sheet1"){
					if(ComIsNull(formObj.fm_dt) || ComIsNull(formObj.to_dt)){
						ComShowCodeMessage('VSK00027', "From, To date");
						formObj.btn_cal1.focus();
						return false;
					}
					// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}
				
    			if(document.form.crr_cd.value != '' && document.form.crr_cd.value.length < 3){
	            	//{?msg1} must be at least {?msg2} characters long.
    				ComShowCodeMessage('COM12174','Carrier','3');
    				document.form.crr_cd.value	= "";
    				return;
    			}
				
				break;
				
			case COMMAND04:      //Port
				if (sheetObj.id == "t5sheet1"){
					if(ComIsNull(formObj.vps_port_cd) || formObj.vps_port_cd.value.length < 2 ){
						return false;
					}
				}else{
					if(ComIsNull(formObj.vps_port_cd) || formObj.vps_port_cd.value.length < 5 ){
						return false;
					}
				}
				
				break;

			case IBSAVE:        //Retry
				break;
		}

		return true;
	}
	
	function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
//					sheetObj.Redraw = false;
					if(sheetObj.id == "t5sheet1"){
//					if(beforetab == 4){
						if(VskIsNull(formObj.rcv_dt.value) && VskIsNull(formObj.rcv_seq.value)){
							// 조회 일 경우
							if(formObj.page_no.value=="1"){
								sheetObj.LoadSearchXml(sXml, false);
							}else{						
								sheetObj.LoadSearchXml(sXml, true);
							}
							
							var totCnt = sheetObj.LastRow;
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.CellValue(i, prefix+"scs_flg") == "Y"){
									sheetObj.CellEditable(i, prefix+"chk_flg") = false;
								}
							}
						}else{
							var totCnt = sheetObj.LastRow;
							var saveIdx = 0;	// 저장한 RowCount
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.CellValue(i, prefix+"rcv_dt") == formObj.rcv_dt.value && sheetObj.CellValue(i, prefix+"rcv_seq") == formObj.rcv_seq.value){
									saveIdx = i;
									break;
								}
							}
							sheetObj.RowDelete(saveIdx, false);				// 기존 Row 삭제
							sheetObj.LoadSearchXml(sXml, true, saveIdx);	// 저장한 Row 의 결과를 기존 Row 의 위치에 Add 시킴.
							// 
							if(sheetObj.CellValue(saveIdx, prefix+"scs_flg") == "Y"){
								sheetObj.CellEditable(saveIdx, prefix+"chk_flg") = false;
							}
							// 저장(Retry) 후 조회일 경우
							formObj.rcv_dt.value = "";
							formObj.rcv_seq.value = "";
						}
					}else{
						if(formObj.page_no.value=="1"){
							sheetObj.LoadSearchXml(sXml, false);
						}else{						
							sheetObj.LoadSearchXml(sXml, true);
						}
						var totCnt = sheetObj.LastRow;
						if(sheetObj.id == "t4sheet1"){
	//						ATA,ATB,ATD 미입력시 Grid 화면에 회색으로 처리
							for(var i=headCnt; i<=totCnt; i++){
								if(sheetObj.CellValue(i, prefix+"act_arr_dt") == ""){
									sheetObj.CellBackColor(i, prefix+"act_arr_dt") = glbGreyColor;
								}
								if(sheetObj.CellValue(i, prefix+"act_brth_dt") == ""){
									sheetObj.CellBackColor(i, prefix+"act_brth_dt") = glbGreyColor;
								}
								if(sheetObj.CellValue(i, prefix+"act_dep_dt") == ""){
									sheetObj.CellBackColor(i, prefix+"act_dep_dt") = glbGreyColor;
								}
							}
						}
					}
//					sheetObj.Redraw = true;
				}else{
//					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
//					sheetObj.Redraw = true;
				}
			}
		}
	}

	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */

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
		beforetab = nItem;
		
		//해당 Tab의 조회 조건 Status 및 Data Setting.
		setConditionControl(nItem);
	}


	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	
	function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		scrollSearch(sheetObj, PageNo);
	}
	
	function t3sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		scrollSearch(sheetObj, PageNo);
	}
	
	function t4sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		scrollSearch(sheetObj, PageNo);
	}
	
	function t5sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		scrollSearch(sheetObj, PageNo);
	}
	
    /**
     * OnScrollNext 이벤트 발생시 호출하는 function
     * 이후 페이지 조회 
     * @param sheetObj
     * @param pageNo
     */
	function scrollSearch(sheetObj, pageNo){
		var formObj = document.form;
		formObj.page_no.value = pageNo;
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}

 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var headCnt = sheetObj.HeaderRows;
 		with(sheetObj)
 		{
 			if(RowCount > 0){
 				for(var i=0; i<RowCount; i++){
 	 				if(CellValue(i+HeaderRows, id+"_port_cd") == "Sub Total"){
 	 					RowBackColor(i+HeaderRows) = glbSubTotalColor;
// 	 		 			RowMerge(i+HeaderRows) = true;
 	 				}
 	 			}
 				var grandTotalRow = parseInt(TotalRows)+parseInt(HeaderRows)-1;
 				if(grandTotalRow==LastRow){
 					RowBackColor(LastRow) = glbGrandTotalColor;
 				}
 			}
 			
// 			ColBackColor(sheetObj.id+"_rhq") = RgbColor(229, 234, 255);
// 			RowMerge(LastRow) = true;
 		}
 	}
 	
 	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var headCnt = sheetObj.HeaderRows;
 		with(sheetObj)
 		{
 			if(RowCount > 0){
 				for(var i=0; i<RowCount; i++){
 	 				if(Number(CellValue(i+HeaderRows, id+"_atd_over_days")) > 0){
 	 					RowBackColor(i+HeaderRows) = glbOverDaysColor;
 	 				}
 	 			}
 			}
 		}
 	}

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 1){
			var sXml = doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			
			var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab2 = ("ALL|"+sCtrlOfc).split("|");	//
			}
			
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab2, glbSlsOfcArrTab2, "", "DEF");
			
			glbFormDataTab2.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 2){
			var sXml = doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			
			var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab3 = ("ALL|"+sCtrlOfc).split("|");	//
			}
			
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab3, glbSlsOfcArrTab3, "", "DEF");
			
			glbFormDataTab3.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 3){
			var sXml = doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			
			var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab4 = ("ALL|"+sCtrlOfc).split("|");	//
			}
			
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab4, glbSlsOfcArrTab4, "", "DEF");
			
			glbFormDataTab4.setVskdPortRhqCd(Index_Code);
		}
		else if(beforetab == 4){
			var sXml = doActionIBSheet(sheetObjects[beforetab], document.form, COMMAND03);
			
			var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
			if(sCtrlOfc != null && sCtrlOfc != undefined){
				glbSlsOfcArrTab5 = ("ALL|"+sCtrlOfc).split("|");	//
			}
			
			//CTRL Combo Setting.
			appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab5, glbSlsOfcArrTab5, "", "DEF");
			
			glbFormDataTab5.setVskdPortRhqCd(Index_Code);
		}
	}
	
	function sls_ofc_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setSlsOfcCd(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setSlsOfcCd(Index_Code);
		}
	}
	
	function tml_cd_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setTmlCd(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setTmlCd(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setTmlCd(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setTmlCd(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setTmlCd(Index_Code);
		}
	}
	
	function scs_flg_OnChange(comboObj, Index_Code, Text) {
		if(beforetab == 0){
			glbFormDataTab1.setScsFlg(Index_Code);
		}
		else if(beforetab == 1){
			glbFormDataTab2.setScsFlg(Index_Code);
		}
		else if(beforetab == 2){
			glbFormDataTab3.setScsFlg(Index_Code);
		}
		else if(beforetab == 3){
			glbFormDataTab4.setScsFlg(Index_Code);
		}
		else if(beforetab == 4){
			glbFormDataTab5.setScsFlg(Index_Code);
		}
	}
 	

	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change'		, 'obj_change'		, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress'	, 'obj_keypress'	, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup'		, 'obj_keyup'		, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('activate'	, 'obj_activate'	, form);
    	axon_event.addListenerForm('blur'		, 'obj_blur'		, form);
    	axon_event.addListenerForm('keydown'	, 'ComKeyEnter'		, form);
    	axon_event.addListenerForm('keydown'	, 'obj_keydown'		, form); 	// - form 전체 컨트롤 onkeydownup 이벤트에 코드 처리
	}
    
	function obj_change(){
		var eleObj 		= event.srcElement;
		var formObj 	= document.form;
		var sheetObj 	= getCurrentSheet();
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
	        switch(srcName) {	
	            case "vps_port_cd":
	            	if(sheetObj.id == "t5sheet1"){
	            		if(eleObj.value.length > 1){
				    		formObj.country_cd.value = eleObj.value;
			            	var sXml = doActionIBSheet(sheetObj, formObj, COMMAND04);
			            	setTmlCdCombo(sXml);
				            formObj.tml_cd.focus();
				    	}else{
				    		formObj.vps_port_cd.value = "";
		            		getComboObject("tml_cd").RemoveAll();
		            		formObj.vps_port_cd.focus();
				    	}
//	            	}else{
//	            		2010.03.25 국가코드로 조회 가능해야 하므로 Port 정합성 로직 제거.
//	            		if(eleObj.value.length == 5){
//				    		formObj.loc_cd.value = eleObj.value;
//			            	var sXml = doActionIBSheet(sheetObj, formObj, COMMAND04);
//			            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
//			            		formObj.vps_port_cd.value = "";
//			            		formObj.vps_port_cd.focus();
//			            	}else{
//			            		formObj.tml_cd.focus();
//			            	}
//				    	}else{
//				    		formObj.vps_port_cd.value = "";
//		            		getComboObject("tml_cd").RemoveAll();
//		            		formObj.vps_port_cd.focus();
//				    	}
	            	}
	            	
	            	if(sheetObj.id == "t1sheet1"){
	            		glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab1.setTmlCd(getComboObject("tml_cd").Code);
	            	}else if(sheetObj.id == "t2sheet1"){
	            		glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab2.setTmlCd(getComboObject("tml_cd").Code);
	            	}else if(sheetObj.id == "t3sheet1"){
	            		glbFormDataTab3.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab3.setTmlCd(getComboObject("tml_cd").Code);
	            	}else if(sheetObj.id == "t4sheet1"){
	            		glbFormDataTab4.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab4.setTmlCd(getComboObject("tml_cd").Code);
	            	}else if(sheetObj.id == "t5sheet1"){
	            		glbFormDataTab5.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab5.setTmlCd(getComboObject("tml_cd").Code);
	            	}
	            	break;
	            	
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	
            		if(beforetab == 0){
	        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVslCd(formObj.vsl_cd.value);
	        		}
	            	
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "skd_voy_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "skd_dir_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "lloyd_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setLloydNo(formObj.lloyd_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setLloydNo(formObj.lloyd_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            case "call_sgn_no":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setCallSgnNo(formObj.call_sgn_no.value);
	        		}
//	            	clearAllFormData(formObj, "S");
	            	break;
	            	
	            	//::jskjskjsk:://///////////////////////////////////////////
	            case "crr_cd":
	    			if(document.form.crr_cd.value != '' && document.form.crr_cd.value.length < 3){
		            	//{?msg1} must be at least {?msg2} characters long.
	    				ComShowCodeMessage('COM12174','Carrier','3');
	    				document.form.crr_cd.value	= "";
	    				return;
	    			}
    				doActionIBSheet(sheetObj, formObj, SEARCH04);
	            	break;	            	
	            	
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function obj_keypress(){
		var formObj = document.form;
		var srcName = event.srcElement.name;
		
		switch (srcName) {
	    	case "vps_port_cd":
	    		ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(formObj.skd_voy_no);
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
            	break;

		    case "opt_hrs":
		    	ComKeyOnlyNumber(formObj.opt_hrs);
            	break;

	    	case "crr_cd":
	    		ComKeyOnlyAlphabet('uppernum');
				break;
            	
		    case "fm_dt":
		    case "to_dt":
		    	ComKeyOnlyNumber(event.srcElement);
		    	break;
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		var sheetObj = getCurrentSheet();
		
		switch (eleObj.name) {
	    	case "vps_port_cd":
	    		if(eleObj.value.length == 5){
	    			formObj.tml_cd.focus();
		    	}
				break;
	    	case "vsl_cd":
	    		if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break;
	    	case "skd_voy_no":
	    		if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;
		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		if(srcName){
			focusObj = srcName;
		}else{
			focusObj = "";
		}
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
//				if(beforetab == 4){
					ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
					event.srcElement.select();
//				}
				break;
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
//				if(beforetab == 4){
					ComChkObjValid(event.srcElement);
//				}
				break;
		}
	}
	
	function obj_keydown(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(focusObj=="vsl_cd"){
			var ctrl = event.ctrlKey;
			var code = event.keyCode;
			if(ctrl && code == 86){ 
				var clipData = window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData = clipData.toUpperCase();
					formObj.vsl_cd.value = clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value = clipData.substring(4, 8);
						formObj.skd_dir_cd.value = clipData.substring(8, 9);
					}
				}
				event.returnValue = false;
			}
		}
	}
 	
    
    
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	
	/**
	 * [R/Lane Regist] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
 	function returnRLaneRegist(rtnObjs){
		var formObj = document.form;
		var sheetObj = null;
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
//					formObj.sim_dt.value = rtnDatas[1];
//					formObj.sim_no.value = rtnDatas[2];
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
		var sheetObj = getCurrentSheet();
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value = rtnDatas[2];
					formObj.loc_cd.value = rtnDatas[2];
					formObj.country_cd.value = rtnDatas[2];
					
					sXml = doActionIBSheet(sheetObj, formObj, COMMAND04);
					if(sheetObj.id == "t5sheet1"){
//	            		if(isCheckPortForm(sheetObj, formObj, sXml)){
	            			setTmlCdCombo(sXml);
		            		formObj.tml_cd.focus();
//		            	}else{
//		            		formObj.vps_port_cd.value = "";
//		            		getComboObject("tml_cd").RemoveAll();
//		            		formObj.vps_port_cd.focus();
//		            	}
	            	}else{
		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
		            		formObj.vps_port_cd.value = "";
		            		formObj.vps_port_cd.focus();
		            	}else{
		            		formObj.tml_cd.focus();
		            	}
	            	}
					
					if(beforetab == 0){
	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab1.setTmlCd(getComboObject("tml_cd").Code);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab2.setTmlCd(getComboObject("tml_cd").Code);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab3.setTmlCd(getComboObject("tml_cd").Code);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab4.setTmlCd(getComboObject("tml_cd").Code);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVpsPortCd(formObj.vps_port_cd.value);
	        			glbFormDataTab5.setTmlCd(getComboObject("tml_cd").Code);
	        		}
					
//					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
//					if(!isCheckPortForm(sheetObj, formObj, sXml)){
//						formObj.vps_port_cd.value = "";
//						formObj.vps_port_cd.focus();
//					}else{
//						formObj.fm_dt.focus();
//					}
				}
			}
		}
	}
    
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj = document.form;
    	
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value = rtnDatas[1];
					
					if(beforetab == 0){
	        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setVslCd(formObj.vsl_cd.value);
	        		}
				}
			}
    	}
    }

    /**
     * VVD Code Help (Pop-Up)에서 받은 데이타 처리.
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj = document.form;
		
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value = rtnDatas[2];
					formObj.skd_dir_cd.value = rtnDatas[3];
					
					if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 2){
	        			glbFormDataTab3.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab3.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 3){
	        			glbFormDataTab4.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab4.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 4){
	        			glbFormDataTab5.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab5.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
				}
			}
    	}
    }

	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
 	
 	/**
 	 * 조회 조건 상태 Setting.
 	 * Tab 이동 시 사용
 	 * 
 	 * @param nItem
 	 * @return
 	 */
 	function setConditionControl(nItem){
 		var formObj = document.form;
 		switch(nItem) {
			case 0:      //tab1
//				ComEnableManyObjects(false, formObj.vps_port_cd, formObj.fm_dt, formObj.to_dt, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);
				VskEnableObjectControl(formObj.vps_port_cd,  false);
				VskEnableObjectControl(formObj.vsl_cd, false);
				VskEnableObjectControl(formObj.skd_voy_no, false);
				VskEnableObjectControl(formObj.skd_dir_cd, false);
				VskEnableObjectControl(formObj.lloyd_no, false);
				VskEnableObjectControl(formObj.call_sgn_no, false);
				getComboObject("vskd_port_rhq_cd").Enable = false;
				getComboObject("sls_ofc_cd").Enable = false;
				getComboObject("tml_cd").Enable = false;
				getComboObject("scs_flg").Enable = false;
//				comboObjects[2].Enable = false;
				
				VskEnableObjectControl(formObj.btn_port, false);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, false);

//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
				
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], true);
				
//				formObj.fm_dt.className = "input2";
//				formObj.to_dt.className = "input2";
				
				break;
			case 1:      //tab2
			case 2:      //tab3
			case 3:      //tab4
				VskEnableObjectControl(formObj.vps_port_cd,  true);
				VskEnableObjectControl(formObj.vsl_cd, true);
				VskEnableObjectControl(formObj.skd_voy_no, true);
				VskEnableObjectControl(formObj.skd_dir_cd, true);
				VskEnableObjectControl(formObj.lloyd_no, false);
				VskEnableObjectControl(formObj.call_sgn_no, false);
				getComboObject("vskd_port_rhq_cd").Enable = true;
				getComboObject("sls_ofc_cd").Enable = true;
				getComboObject("tml_cd").Enable = false;
				getComboObject("scs_flg").Enable = false;
//				comboObjects[2].Enable = true;
				
				VskEnableObjectControl(formObj.btn_port, true);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, true);
				
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
				
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], true);
				
//				formObj.fm_dt.className = "input1_1";
//				formObj.to_dt.className = "input1_1";
				
				break;
			case 4:      //tab2
				VskEnableObjectControl(formObj.vps_port_cd,  true);
				VskEnableObjectControl(formObj.vsl_cd, true);
				VskEnableObjectControl(formObj.skd_voy_no, true);
				VskEnableObjectControl(formObj.skd_dir_cd, true);
				VskEnableObjectControl(formObj.lloyd_no, true);
				VskEnableObjectControl(formObj.call_sgn_no, true);
				getComboObject("vskd_port_rhq_cd").Enable = true;
				getComboObject("sls_ofc_cd").Enable = true;
				getComboObject("tml_cd").Enable = true;
				getComboObject("scs_flg").Enable = true;
//				comboObjects[2].Enable = true;
				
				VskEnableObjectControl(formObj.btn_port, true);
				VskEnableObjectControl(formObj.btn_cal1, true);
				VskEnableObjectControl(formObj.btn_cal2, true);
				VskEnableObjectControl(formObj.btn_vvd, true);
				
				VskEnableObjectControl(formObj.fm_dt, true, true);
				VskEnableObjectControl(formObj.to_dt, true, true);
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[0], false);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[1], false);
				VskEnableObjectControl(formObj.vsl_svc_tp_cd[2], false);
				
//				formObj.fm_dt.className = "input1_1";
//				formObj.to_dt.className = "input1_1";
				
				break;
		}
		setConditionData(formObj, nItem);
 	}
 	
 	/**
 	 * 현재 활성화된 Sheet를 찾아 반환한다.
 	 * @return sheetObj
 	 */
 	function getCurrentSheet(){
 		var sheetObj = null;
 		
 		//tab당 sheet가 1개씩이므로...
 		sheetObj = sheetObjects[beforetab];
 		
 		return sheetObj;
 	}
 	
 	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
		comboObj.RemoveAll();
		
		if(optionCdArr != null){
			if(sFlag == "DEF"){
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}else{
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}
	    	
			comboObj.Code2 = selCode;
		}
	}
	
	/**
	 * sheet5 저장 시 EDI Key 값을 보관한다.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function setSavePointKey(sheetObj, formObj){
		var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = sheetObj.LastRow;
    	
    	if(totCnt >= headCnt){
    		for(var i=headCnt; i<=totCnt; i++){
        		if(sheetObj.CellValue(i, prefix+"chk_flg")){
        			formObj.rcv_dt.value = sheetObj.CellValue(i, prefix+"rcv_dt");
        			formObj.rcv_seq.value = sheetObj.CellValue(i, prefix+"rcv_seq");
        			break;
        		}
        	}
    	}
	}
	
	/**
	 * Tab 변경 시 해당 Tab의 조회조건들을 Setting.
	 * 
	 * @param formObj
	 * @param nItem
	 * @return
	 */
	function setConditionData(formObj, nItem){
		switch(nItem) {
			case 0:      //tab1
				if(glbFormDataTab1 != null){
					glbFormDataTab1.setAllFormData();
					getComboObject("vskd_port_rhq_cd").Code2 = glbFormDataTab1.getVskdPortRhqCd();
					getComboObject("sls_ofc_cd").Code2 = glbFormDataTab1.getSlsOfcCd();
					getComboObject("tml_cd").Code2 = glbFormDataTab1.getTmlCd();
					getComboObject("scs_flg").Code2 = glbFormDataTab1.getScsFlg();
					
					//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value = ComGetNowInfo();
					}
				}else{
					formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value = ComGetNowInfo();
				}
				break;
			case 1:      //tab2
				if(glbFormDataTab2 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab2, glbSlsOfcArrTab2, "", "DEF");
					glbFormDataTab2.setAllFormData();
					getComboObject("tml_cd").Code2 = glbFormDataTab2.getTmlCd();
					getComboObject("scs_flg").Code2 = glbFormDataTab2.getScsFlg();
					
					//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value = ComGetNowInfo();
					}
				}
				break;
			case 2:      //tab3
				if(glbFormDataTab3 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab3, glbSlsOfcArrTab3, "", "DEF");
					glbFormDataTab3.setAllFormData();
					getComboObject("tml_cd").Code2 = glbFormDataTab3.getTmlCd();
					getComboObject("scs_flg").Code2 = glbFormDataTab3.getScsFlg();
					
					//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value = ComGetNowInfo();
					}
				}
				break;
			case 3:      //tab4
				if(glbFormDataTab4 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab4, glbSlsOfcArrTab4, "", "DEF");
					glbFormDataTab4.setAllFormData();
					getComboObject("tml_cd").Code2 = glbFormDataTab4.getTmlCd();
					getComboObject("scs_flg").Code2 = glbFormDataTab4.getScsFlg();
					
					//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value = ComGetNowInfo();
					}
				}
				break;
			case 4:      //tab5
				if(glbFormDataTab5 != null){
					appendMultiComboItem(getComboObject("sls_ofc_cd"), glbSlsOfcArrTab5, glbSlsOfcArrTab5, "", "DEF");
					glbFormDataTab5.setAllFormData();
					
					//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 7 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value = ComGetNowInfo();//ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value = ComGetNowInfo();
					}
				}
				break;
		}
	}
	
	/**
	 * Tml Cd Combo를 Setting.
	 * @return
	 */
	function setTmlCdCombo(sXml){
		if(sXml == null || sXml == undefined || sXml == ""){
			return;
		}
		
//		var ydKind = " |" + ComGetEtcData(sXml, "yd_kind");
		var ydCd = ComGetEtcData(sXml, "yd_cd");
		var ydNm = ComGetEtcData(sXml, "yd_nm");

		var ydTxtArr = new Array();
//		var ydKindArr = ydKind.split("|");
		var ydCdArr = ydCd.split("|");
		var ydNmArr = ydNm.split("|");
//		var ydCnt = ydKindArr.length;
		var ydCnt = ydCdArr.length;
		
//		ydTxtArr[0] = ydKindArr[0] + "|" + ydNmArr[0];
		ydTxtArr[0] = ydCdArr[0] + "|" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
//			ydTxtArr[i] = ydKindArr[i] + "|" + ydNmArr[i];
			ydTxtArr[i] = ydCdArr[i] + "|" + ydNmArr[i];
		}
//		appendMultiComboItem(getComboObject("tml_cd"), ydKindArr, ydTxtArr, ydKindArr[1], "DEF");
		appendMultiComboItem(getComboObject("tml_cd"), ydCdArr, ydTxtArr, "", "DEF");
	}
	
	/**
	 * Result Code(scs_flg) Combo를 Setting.
	 * @return
	 */
	function setScsFlgCombo(){
		var txtArr = new Array();
		txtArr[0] = "ALL";
		txtArr[1] = "OK";
		txtArr[2] = "Fail";
		
		var cdArr = new Array();
		cdArr[0] = "ALL";
		cdArr[1] = "Y";
		cdArr[2] = "N";
		
		appendMultiComboItem(getComboObject("scs_flg"), cdArr, txtArr, "ALL", "DEF");
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
	
	/**
     * [New] Button Event : 화면을 초기화 한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	
    	if(beforetab == 0){
        	glbFormDataTab1 = new Usr_Condi_FormData();
        	glbFormDataTab1.setAllFormData();
		}
		else if(beforetab == 1){
			glbSlsOfcArrTab2 = null;
			getComboObject("sls_ofc_cd").RemoveAll();
			
        	glbFormDataTab2 = new Usr_Condi_FormData();
        	glbFormDataTab2.setAllFormData();
        	
        	//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value = ComGetNowInfo();
			}
		}
		else if(beforetab == 2){
			glbSlsOfcArrTab3 = null;
			getComboObject("sls_ofc_cd").RemoveAll();
			
        	glbFormDataTab3 = new Usr_Condi_FormData();
        	glbFormDataTab3.setAllFormData();
        	
        	//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value = ComGetNowInfo();
			}
			
//			formObj.opt_hrs.value = "0";
		}
		else if(beforetab == 3){
			glbSlsOfcArrTab4 = null;
			getComboObject("sls_ofc_cd").RemoveAll();
			
        	glbFormDataTab4 = new Usr_Condi_FormData();
        	glbFormDataTab4.setAllFormData();
        	
        	//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 30 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value = ComGetNowInfo();
			}
		}
		else if(beforetab == 4){
			glbSlsOfcArrTab5 = null;
			getComboObject("sls_ofc_cd").RemoveAll();
			getComboObject("tml_cd").RemoveAll();
			
        	glbFormDataTab5 = new Usr_Condi_FormData();
        	glbFormDataTab5.setAllFormData();
        	
        	//New버튼 클릭이나 최초 탭 선택시 from: sysdate - 7 , to : Sysdate로 표시 (임창빈 수석 2009.08.10)
        	if(ComIsNull(formObj.fm_dt)){
				formObj.fm_dt.value = ComGetNowInfo();//ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
			}
			if(ComIsNull(formObj.to_dt)){
				formObj.to_dt.value = ComGetNowInfo();
			}
		}
    	
    	sheetObj.RemoveAll();
    	
//    	showFieldControl(sheetObj, formObj, false);
//    	
//    	initButton(sheetObj);
//    	
//    	formObj.vsl_cd.focus();
    }
    

	
	/**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	if(sXml == null || sXml == undefined || sXml == "") return false;
    	
    	var prefix = sheetObj.id + "_";
    	var chkPort = ComGetEtcData(sXml, "check_port");
		
		if(chkPort == "X"){
			return true;
		}else{
			//해당 Port({?msg1})가 존재하지 않습니다.
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			
			formObj.loc_cd.value = "";
		}
		
		return false;
    }
    
    /**
     * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH10);
		
		var chkVslCd = ComGetEtcData(sXml, "vsl_chk");
		
		if(chkVslCd == "Y"){
    		//MDM_VSL_CNTR 에 Vessel Code가 존재
    		return true;
    	}else{
    		sheetObj.LoadSearchXml(sXml);
    		formObj.vsl_cd.value = "";
    		return false;
    	}
	}

	/*
	 * =====================================================================
	 * Form Condition Elements Getter/Setter
	 * =====================================================================
	 */
 	
 	function Usr_Condi_FormData(){
 		this.VskdPortRhqCd = "";
 		this.slsOfcCd = "";
		this.vpsPortCd = "";
		this.tmlCd = "";
		this.scsFlg = "";
		this.vslCd = "";
		this.skdVoyNo = "";
		this.skdDirCd = "";
		this.lloydNo = "";
		this.callSgnNo = "";
	}
	
	//Usr_Condi_FormData.Getter()
	Usr_Condi_FormData.prototype.getVskdPortRhqCd = function(){
		return this.vskdPortRhqCd;
	}
	Usr_Condi_FormData.prototype.getSlsOfcCd = function(){
		return this.slsOfcCd;
	}
	Usr_Condi_FormData.prototype.getVpsPortCd = function(){
		return this.vpsPortCd;
	}
	Usr_Condi_FormData.prototype.getTmlCd = function(){
		return this.tmlCd;
	}
	Usr_Condi_FormData.prototype.getScsFlg = function(){
		return this.scsFlg;
	}
	Usr_Condi_FormData.prototype.getVslCd = function(){
		return this.vslCd;
	}
	Usr_Condi_FormData.prototype.getSkdVoyNo = function(){
		return this.skdVoyNo;
	}
	Usr_Condi_FormData.prototype.getSkdDirCd = function(){
		return this.skdDirCd;
	}
	Usr_Condi_FormData.prototype.getLloydNo = function(){
		return this.lloydNo;
	}
	Usr_Condi_FormData.prototype.getCallSgnNo = function(){
		return this.callSgnNo;
	}

	//Usr_Condi_FormData.Setter()
	Usr_Condi_FormData.prototype.setVskdPortRhqCd = function(sVskdPortRhqCd){
		this.vskdPortRhqCd = sVskdPortRhqCd;
	}
	Usr_Condi_FormData.prototype.setSlsOfcCd = function(sSlsOfcCd){
		this.slsOfcCd = sSlsOfcCd;
	}
	Usr_Condi_FormData.prototype.setVpsPortCd = function(sVpsPortCd){
		this.vpsPortCd = sVpsPortCd;
	}
	Usr_Condi_FormData.prototype.setTmlCd = function(sTmlCd){
		this.tmlCd = sTmlCd;
	}
	Usr_Condi_FormData.prototype.setScsFlg = function(sScsFlg){
		this.scsFlg = sScsFlg;
	}
	Usr_Condi_FormData.prototype.setVslCd = function(sVslCd){
		this.vslCd = sVslCd;
	}
	Usr_Condi_FormData.prototype.setSkdVoyNo = function(sSkdVoyNo){
		this.skdVoyNo = sSkdVoyNo;
	}
	Usr_Condi_FormData.prototype.setSkdDirCd = function(sSkdDirCd){
		this.skdDirCd = sSkdDirCd;
	}
	Usr_Condi_FormData.prototype.setLloydNo = function(sLloydNo){
		this.lloydNo = sLloydNo;
	}
	Usr_Condi_FormData.prototype.setCallSgnNo = function(sCallSgnNo){
		this.callSgnNo = sCallSgnNo;
	}
	
	Usr_Condi_FormData.prototype.setAllFormData = function(){
		var formObj = document.form;
		
		if(ComIsNull(this.getVskdPortRhqCd())){
			getComboObject("vskd_port_rhq_cd").Code2 = "ALL";
		}else{
			getComboObject("vskd_port_rhq_cd").Code2 = this.getVskdPortRhqCd();
		}
		if(ComIsNull(this.getSlsOfcCd())){
			getComboObject("sls_ofc_cd").Code2 = "ALL";
		}else{
			getComboObject("sls_ofc_cd").Code2 = this.getSlsOfcCd();
		}
		if(ComIsNull(this.getTmlCd())){
			getComboObject("tml_cd").Code2 = "ALL";
		}else{
			getComboObject("tml_cd").Code2 = this.getTmlCd();
		}
		if(ComIsNull(this.getScsFlg())){
			getComboObject("scs_flg").Code2 = "ALL";
		}else{
			getComboObject("scs_flg").Code2 = this.getScsFlg();
		}
		
		formObj.vps_port_cd.value = this.getVpsPortCd();
		formObj.vsl_cd.value = this.getVslCd();
		formObj.skd_voy_no.value = this.getSkdVoyNo();
		formObj.skd_dir_cd.value = this.getSkdDirCd();
		formObj.lloyd_no.value = this.getLloydNo();
		formObj.call_sgn_no.value = this.getCallSgnNo();
	}
 	
	/* 개발자 작업  끝 */