/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_0131.js
*@FileTitle : Charge Summary Report - BL Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용                                                                                                                                                                                                                                                                                                                                                                                 
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
	 * @class ESM_PRI_0131 : ESM_PRI_0131 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_0131() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
			case "btn_Downexcel":
    	    	sheetObject.SpeedDown2Excel(-1, false, false);
    	        break;
			
			case "btn_Close":
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObj,formObj,IBSEARCH); 
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 460;
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
				InitRowInfo(1, 1, 15, 100);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
	
				var HeadTitle = "Month|Week|Trade|Sub-Trade|Scope|RHQ|C.OFC|Dir\n(Bound)|Lane|Trunk VVD|Booking No.|Contract No.|Customer\ncode|Customer Description|TEU|FEU|POR|POL\nCountry|POL|POD\nCountry|POD|DEL|R/D\nTerm|Surcharge\nType|Payment|Surcharge\nCode|Mandatory\nRating|Per|Cargo Type|Cur.|Tariff Total|Rating Total|Collection Ratio(%)";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true, 		"cost_yrmon");
				InitDataProperty(0, cnt++, 	dtData,			80,		daCenter, 	true,		"cost_wk");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true, 		"trd_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true,  		"sub_trd_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true,  		"svc_scp_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true,  		"region");
				InitDataProperty(0, cnt++,	dtData,			80,		daCenter, 	true,		"ctrt_ofc_cd");
	            InitDataProperty(0, cnt++,	dtData,			80,		daCenter, 	true,		"dir_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter, 	true,   	"rlane_cd");
				InitDataProperty(0, cnt++, 	dtData, 		90, 	daCenter,  	true,   	"vvd_cd");
				InitDataProperty(0, cnt++, 	dtData, 		110, 	daCenter,  	true,   	"bkg_no");
				InitDataProperty(0, cnt++, 	dtData, 		100, 	daCenter,  	true,   	"ctrt_no");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"cust_cd");
				InitDataProperty(0, cnt++, 	dtData, 		220, 	daLeft,  	true,   	"cust_lgl_eng_nm");
				InitDataProperty(0, cnt++, 	dtData, 		65, 	daCenter,  	true,   	"teu");
	            InitDataProperty(0, cnt++ , dtData,			65,		daCenter, 	true,		"feu");
	            InitDataProperty(0, cnt++ , dtData,			80,		daCenter,  	true,		"bkg_por_cd");
	            InitDataProperty(0, cnt++ , dtData,			70,		daCenter,  	true,		"pol_cnt_cd");
	            InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"bkg_pol_cd");
	            InitDataProperty(0, cnt++, 	dtData, 		70, 	daCenter, 	true,   	"pod_cnt_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"bkg_pod_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"bkg_del_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"rd_term_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"rep_chg_cd");
				InitDataProperty(0, cnt++, 	dtData, 		80, 	daCenter,  	true,   	"frt_term_cd");
				InitDataProperty(0, cnt++ , dtData,			80,	 	daCenter,  	true,	    "chg_cd");
				InitDataProperty(0, cnt++ , dtData,			80,	 	daCenter,  	true,	    "mdtr_cd");
	            InitDataProperty(0, cnt++ , dtData,			80,	 	daCenter,  	true,	    "per_cd");
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cgo_cate_cd");
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"curr_cd");  
				InitDataProperty(0, cnt++, 	dtAutoSumEx, 	90, 	daRight,   	true,   	"trf_usd_chg_amt",     false,  "",   dfFloat, 2);
				InitDataProperty(0, cnt++, 	dtAutoSumEx, 	90, 	daRight, 	true,   	"rat_chg_amt", false,  "",   dfFloat, 2);
				InitDataProperty(0, cnt++, 	dtData, 		100, 	daRight, 	true,   	"clt_ratio", 	   false , "|rat_chg_amt|/|trf_usd_chg_amt|*100", dfNullFloat, 1);
				
				WaitImageVisible = false;
			}
			break;
		}
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {
		var sheetObject = sheetObjects[0];
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH: //조회
				try {
					ComOpenWait(true);
		            formObj.f_cmd.value = COMMAND01;
		            var sParam = FormQueryString(formObj);
		            var sXml = sheetObj.GetSearchXml("ESM_PRI_0131GS.do", sParam);
		            var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
		            if (backendJobKey.length > 0) {
		            	
		                formObj.jb_id.value = backendJobKey;
		                sheetObj.RequestTimeOut = 10000;
		                timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
		            }else{
		                ComOpenWait(false);
		            }
		        }catch(e){
		            ComOpenWait(false);
		        }
			break;
		}
	}
	 
	/** 
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다. <br>
	 */ 
	function getBackEndJobStatus() {
		var sheetObj = sheetObjects[0];
		var form = document.form;
	    try {
	        form.f_cmd.value = SEARCH;
	        var sXml = sheetObj.GetSearchXml("ESM_PRI_0131GS.do", FormQueryString(form));
	        var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	        if (jobState == "3") {
	            getBackEndJobLoadFile();
	            clearInterval(timer);
	        } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
	            ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
	            clearInterval(timer);	
	            ComOpenWait(false);	
	        } else if (jobState == "5") {
	            ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
	            clearInterval(timer);
	            ComOpenWait(false);	
	        }
	    }catch(e){
	        ComOpenWait(false);
	    }
	}

	/** 
	* BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital) <br>
	*/ 
	function getBackEndJobLoadFile() {
		var form = document.form;
		var sheetObj = sheetObjects[0];
		try {
			form.f_cmd.value = SEARCHLIST;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0131GS.do", FormQueryString(form));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);	
		}catch(e){
			ComOpenWait(false);		
		}
	}
	 
/* 개발자 작업 끝 */