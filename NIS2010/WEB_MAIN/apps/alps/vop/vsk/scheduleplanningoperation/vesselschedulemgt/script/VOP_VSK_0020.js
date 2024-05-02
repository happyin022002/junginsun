/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0020.js
*@FileTitle : VSL SKD Inquiry by Port to Port
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.06.23 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2012.11.26 진마리아 CHM-201221516-01 Port to Port SKD Inquiry 조회기간 연장 (3개월)
* 2013.03.06 정상기    CHM-201323398    [VOP-VSK] Port to Port Sked Inquiry period default 값 변경
* 2015.09.04 이병훈 [CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
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
	 * @class vop_vsk_0020 : vop_vsk_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0020() {
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
	var sheetCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
		 var sheetObject = sheetObjects[0];
		 
		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_pol":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
					
				case "btn_pod":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
					
				case "btn_lane_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;
					
				case "btn_period":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
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

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);

		}
		
		initControl();
		
		//현재월의 첫날부터 현재일까지 셋팅.
		////::2013-03-05::document.form.fm_dt.value = ComGetNowInfo("ym") + "-01";
		////::2013-03-05::document.form.to_dt.value = ComGetNowInfo();
		
		//현재일자~+30일로 셋팅 ::2013-03-05
		document.form.fm_dt.value = ComGetNowInfo();
		document.form.to_dt.value = ComGetDateAdd(document.form.fm_dt.value, "d", "30", "-", true);	//ComGetDateAdd(sDate, sFlag, iVal, sDelim, isFull)//	

		
		document.form.pol_port.focus();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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

		switch(sheetID) {
			case "sheet1":      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 460;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 3, 100);

					var HeadTitle1 = "Seq.|VVD|Lane\nCode|POL|POL|POL|POL|POD|POD|POD|POD|Delay\nDate|Carrier\nCode|pol_yard_nm|pod_yard_nm";
					var HeadTitle2 = "Seq.|VVD|Lane\nCode|TMNL Code|ETA|ETB|ETD|TMNL Code|ETA|ETB|ETD|Delay\nDate|Carrier\nCode|pol_yard_nm|pod_yard_nm";
					var HeadHiddenTitle = "";
					
					HeadTitle1 = HeadTitle1 + HeadHiddenTitle;
					HeadTitle2 = HeadTitle2 + HeadHiddenTitle;
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
						
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,	true,		prefix+"clpt_seq");
					InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	true,		prefix+"vvd",			false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		prefix+"vsl_slan_cd",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		prefix+"pol_tml_cd",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pol_eta",		false,		"",		dfUserFormat2,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pol_etb",		false,		"",		dfUserFormat2,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pol_etd",		false,		"",		dfUserFormat2,	0,			false,		true);

					InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		prefix+"pod_tml_cd",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pod_eta",		false,		"",		dfUserFormat2,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pod_etb",		false,		"",		dfUserFormat2,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		prefix+"pod_etd",		false,		"",		dfUserFormat2,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		40, 	daCenter,	true,		prefix+"delay_date",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"carrier_cd",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,		prefix+"pol_yard_nm",	false,		"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,		prefix+"pod_yard_nm",	false,		"",		dfNone,			0,			false,		true);

//					FitColWidth("3|9|4|11|11|11|11|11|11|||7|");
					DataRowMerge(0) = true;
					
					InitUserFormat2(0, prefix+"pol_eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pol_etb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pol_etd", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix+"pod_eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pod_etb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pod_etd", "####-##-## ##:##", "-|:" );

				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetID = sheetObj.id;
		
		switch(sAction) {

		   case IBSEARCH:      //조회

				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0020GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}	
							
				break;

			case SEARCH01:		//
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0020GS.do", sParam);
					
					return sXml;
				}
						 
				break;

			case IBDOWNEXCEL:        	//엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case COMMAND01:      // Port(POL) Pop-up
				//sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
				sUrl = "/hanjin/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 510, "returnPolHelp", "0,0", true);
				break;

			case COMMAND02:      // Port(POD) Pop-up
				//sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
				sUrl = "/hanjin/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 510, "returnPodHelp", "0,0", true);
				break;

			case COMMAND03:      // Lane Pop-up
				//sUrl = "/hanjin/VOP_VSK_0202.do?op_=0202";
				sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
				break;
		}
	}



	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {

		case IBSEARCH:      //조회
			
			if(ComIsNull(formObj.pol_port.value)){
				ComShowCodeMessage('VSK00027', "POL");
				formObj.pol_port.focus();
				return false;
			} else if (ComIsNull(formObj.pod_port.value)) {
				ComShowCodeMessage('VSK00027', "POD");
				formObj.pod_port.focus();
				return false;
			} else if (ComIsNull(formObj.fm_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(From)");
				formObj.fm_dt.focus();
				return false;
			} else if (ComIsNull(formObj.to_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(To)");
				formObj.to_dt.focus();
				return false;
			}
			// 검색 기간 Check(1개월 이내에서만 검색 가능하게). ==> 3개월로 Validation Rule 변경(2012.11.23)
			if(!VskCheckSpecificMonthPeriod(formObj.fm_dt, formObj.to_dt, 3)){
				ComShowCodeMessage("VSK00105", "3 months");
				return false;
			}
			
			/* date format validation check logic ::2013-04-23 */
			var start_date 	= formObj.fm_dt.value;
			var end_date 	= formObj.to_dt.value;
			if(!ComIsDate(start_date))	return false;
			if(!ComIsDate(end_date))	return false;
			////////////////////////////////////////////////////			
			
			break;
    	}

		return true;
	}
		
	/**
	 * 조회 후 처리로직.
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix = sheetObj.id + "_";
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					
					var xmlPolKind = ComGetEtcData(sXml, "pol_yd_kind");
					var xmlPodKind = ComGetEtcData(sXml, "pod_yd_kind");
					
					sheetObj.InitDataCombo(0, prefix+"pol_tml_cd", xmlPolKind, xmlPolKind);
					sheetObj.InitDataCombo(0, prefix+"pod_tml_cd", xmlPodKind, xmlPodKind);
					
					sheetObj.LoadSearchXml(sXml);
					
					sheetObj.Redraw = true;
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}
		}
	}
	
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	}
    
	function obj_change(){
		var formObj = document.form;
		
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "pol_port":
	            	var polCd = formObj.pol_port.value;
	            	if(polCd != ""){
		            	formObj.loc_cd.value = polCd;
						
						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.pol_port.value = "";
							formObj.pol_port.focus();
						}else{
							formObj.pod_port.focus();
						}
	            	}
	            	break;
	
	            case "pod_port":
	            	var podCd = formObj.pod_port.value;
	            	if(podCd != ""){
		            	formObj.loc_cd.value = podCd;
						
						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.pod_port.value = "";
							formObj.pod_port.focus();
						}else{
							formObj.vsl_slan_cd.focus();
						}
	            	}
	            	break;
	
	            case "vsl_slan_cd":
	            	/*
	            	 * 1. Lane Code 3자리 이하이면 null처리.
	            	 */
	            	var vslSlanCd = formObj.vsl_slan_cd.value;
	            	
	            	if(!ComIsNull(vslSlanCd)){
	            		if(vslSlanCd.length < 3){
	            			ComShowCodeMessage('VSK01018', vslSlanCd);
	            			formObj.vsl_slan_cd.value = "";
	        				formObj.vsl_slan_cd.focus();
	        				return false;
	            		}
	            	}
	            	
	            	break;
                	
                case "fm_dt":
                	formObj.fm_dt.value = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
                	break;
                	
                case "to_dt":
                	formObj.to_dt.value = ComGetMaskedValue(formObj.to_dt.value, "ymd");
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
		switch (event.srcElement.name) {
		    case "pol_port":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "pod_port":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "fm_dt":
		    	ComKeyOnlyNumber(formObj.fm_dt);
				break;
				
		    case "to_dt":
		    	ComKeyOnlyNumber(formObj.to_dt);
				break;
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "pol_port":
		    	if(eleObj.value.length == 5){
		    		formObj.pod_port.focus();
		    	}
				break; 
		    case "pod_port":
		    	if(eleObj.value.length == 5){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break;
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.fm_dt.focus();
		    	}
				break;
		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
    
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
		    
	/**
	 * [Port(POL)] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPolHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pol_port.value = rtnDatas[2];
					formObj.loc_cd.value = rtnDatas[2];
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.pol_port.value = "";
						formObj.pol_port.focus();
					}else{
						formObj.pod_port.focus();
					}
				}
			}
		}
		
	}
		    
	/**
	 * [Port(POD)] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPodHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = null;
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pod_port.value = rtnDatas[2];
					formObj.loc_cd.value = rtnDatas[2];
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.pod_port.value = "";
						formObj.pod_port.focus();
					}else{
						formObj.vsl_slan_cd.focus();
					}
				}
			}
		}
	}
	
	/**
	 * [Lane Code] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = null;
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_slan_cd.value = rtnDatas[1];
				}
			}
		}
		
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
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param sRow
     * @param sXml
     * @return
     */
    function isCheckPortSheet(sheetObj, sRow, sXml){
    	var prefix = sheetObj.id + "_";
    	var chkPort = ComGetEtcData(sXml, "check_port");
    	
		if(chkPort == "X"){
			return true;
		}else{
			//해당 Port({?msg1})가 존재하지 않습니다.
			ComShowCodeMessage("VSK00029", sheetObj.CellValue(sRow, prefix+"vps_port_cd"));
			
			sheetObj.CellValue2(sRow, prefix+"vps_port_cd") = "";
			sheetObj.SelectCell(sRow, prefix+"vps_port_cd");
		}
		
		return false;
    }

    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        if(sheetObj.RowCount > 0){
        	//마우스 위치를 행과 컬럼과 값 가져오기
            var Row = sheetObj.MouseRow;
            var Col = sheetObj.MouseCol;
            var prefix = sheetObj.id+"_";
            
            if (Row > 1 && Col == 3) {
        		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, prefix+"pol_yard_nm");
        		sheetObj.MousePointer = "Hand";
            } else if (Row > 1 && Col == 7) {
        		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, prefix+"pod_yard_nm");
        		sheetObj.MousePointer = "Hand";
            } else {
        		sheetObj.MouseToolTipText = "";
            	sheetObj.MousePointer = "Default";	
            }
        }
    }
    
	/* 개발자 작업  끝 */