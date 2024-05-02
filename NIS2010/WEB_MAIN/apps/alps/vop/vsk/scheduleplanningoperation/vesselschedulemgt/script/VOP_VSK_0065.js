/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0065.js
*@FileTitle : VSL SKD history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.29 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
=========================================================*/
/****************************************************************************************
 * 2010.07.22
 * <<20100722_01>> CHM-201004727-01
 * Period 제한 조건 변경
 ****************************************************************************************/
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
	 * @class vop_vsk_0065 : vop_vsk_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0065() {
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
	// 현재 포커스를 가지고 있는 객체명 변수
	var focusObj = null;

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	
	//각 Tab 별 조회 조건을 담는다.
	var glbFormDataTab1 = null;
	var glbFormDataTab2 = null;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
//		var sheetObject  = sheetObjects[0];   //t1sheet1
		var sheetObj = getCurrentSheet();
		 
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					document.form.page_no.value = 1;
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
					
				case "btn_t1Retrieve":
					document.form.page_no.value = 1;
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
					
				case "btn_t1New":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
 					
 				case "btn_t1DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;

				case "btn_t2Retrieve":
					document.form.page_no.value = 1;
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
					
				case "btn_t2New":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
 					
 				case "btn_t2DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;

				case "btn_vvd_search":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
					
				case "btn_slan_cd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;

				case "btn_port_cd":
					if(window.event.srcElement.style.cursor == "hand"){
						doActionIBSheet(sheetObj, formObj, COMMAND03);
					}
					break;
					
				case "btn_period":
					doActionIBSheet(sheetObj, formObj, COMMAND10);
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

		for(var k=0; k<tabObjects.length; k++){
			initTab(tabObjects[k],k+1);
		}
		
		glbFormDataTab1 = new Usr_Condi_FormData();
		glbFormDataTab2 = new Usr_Condi_FormData();
		
		initControl();
		
		//현재월의 첫날부터 현재일까지 셋팅.
		document.form.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
		document.form.to_dt.value = ComGetNowInfo();
		//날짜 초기 데이터 setting
		glbFormDataTab1.setFmDt(document.form.fm_dt.value);
		glbFormDataTab1.setToDt(document.form.to_dt.value);
		glbFormDataTab2.setFmDt(document.form.fm_dt.value);
		glbFormDataTab2.setToDt(document.form.to_dt.value);
		
		document.form.vsl_cd.focus();
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
					style.height = 424;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 2, document.form.pagerows.value );

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(18, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					var HeadTitle  = "Old|Old|Old|Old|Old|Old|Old|New|New|New|New|New|New|New|Status|Updated Date|Updated ID|Remark(s)";
					var HeadTitle1  = "VVD|Lane|Port|TMNL|ETA|ETB|ETD|VVD|Lane|Port|TMNL|ETA|ETB|ETD|Status|Updated Date|Updated ID|Remark(s)";                  
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [	ROW, 	COL,  	DATATYPE,		WIDTH,		DATAALIGN, 	COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"bfr_vsl_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"bfr_vsl_slan_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"bfr_vps_port_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"bfr_yd_cd",			false,		"",			dfNone,			0,			true,		true);	
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"bfr_vps_eta_dt",	false,		"",			dfUserFormat2,	0,			true,		true);	
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"bfr_vps_etb_dt",	false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"bfr_vps_etd_dt",	false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"aft_vsl_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"aft_vsl_slan_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"aft_vps_port_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"aft_yd_cd",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"aft_vps_eta_dt",	false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"aft_vps_etb_dt",	false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"aft_vps_etd_dt",	false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtCombo,		60,			daLeft,		true,		prefix+"vskd_cng_tp_cd",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"upd_dt",			false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			70,			daCenter,	true,		prefix+"upd_usr_id",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			200,		daCenter,	true,		prefix+"diff_rmk",			false,		"",			dfNone,			0,			true,		true);
					
					InitUserFormat2(0, prefix+"bfr_vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"bfr_vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"bfr_vps_etd_dt", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix+"aft_vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"aft_vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"aft_vps_etd_dt", "####-##-## ##:##", "-|:" );

					InitUserFormat2(0, prefix+"upd_dt", "####-##-##", "-" );
					
					FrozenCols = SaveNameCol(prefix+"bfr_vps_port_cd");
					CountFormat = "[SELECTDATAROW / TOTALROWS]"
				}
				break;
				
			case 2:      //t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 424;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 2, document.form.pagerows.value);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					var HeadTitle  = "VVD|Lane|Old|Old|Old|Old|Old|New|New|New|New|New";
					var HeadTitle1  = "VVD|Lane|ATA|ATB|ATD|Updated Date|Updated ID|ATA|ATB|ATD|Updated Date|Updated ID";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [	ROW, 	COL,  	DATATYPE,		WIDTH,		DATAALIGN, 	COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"vvd",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			50,			daCenter,	true,		prefix+"vsl_slan_cd",	false,		"",			dfNone,			0,			true,		true);	
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"old_ata",		false,		"",			dfUserFormat2,	0,			true,		true);	
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"old_atb",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"old_atd",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"old_cre",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"old_user_id",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"new_ata",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"new_atb",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"new_atd",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			100,		daCenter,	true,		prefix+"new_cre",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, 	cnt++ , dtData,			80,			daCenter,	true,		prefix+"new_user_id",	false,		"",			dfNone,			0,			true,		true);
					
					InitUserFormat2(0, prefix+"old_ata", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"old_atb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"old_atd", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"old_cre", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix+"new_ata", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"new_atb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"new_atd", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"new_cre", "####-##-## ##:##", "-|:" );
					
					FrozenCols = SaveNameCol(prefix+"old_ata");
					CountFormat = "[SELECTDATAROW / TOTALROWS]"
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
					InsertTab( cnt++ , "Coastal SKD" , -1 );
					InsertTab( cnt++ , "Actual SKD" , -1 );
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
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value = SEARCHLIST01;
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0065GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj,formObj,sXml);
					}else if ( sheetObj.id == "t2sheet1"){
						formObj.f_cmd.value = SEARCHLIST02;
						
						//::2014-02-19:://var fParam = "f_cmd=" + SEARCHLIST02 + "&pagerows=";
						var fParam = "f_cmd=" + SEARCHLIST02;
						
						if(checkVVDLen()){
							fParam = fParam + "&loc_cd=" + formObj.loc_cd.value
									+ "&vsl_cd=" + formObj.vsl_cd.value
									+ "&skd_voy_no=" + formObj.skd_voy_no.value
									+ "&skd_dir_cd=" + formObj.skd_dir_cd.value
									+ "&vsl_slan_cd=" + formObj.vsl_slan_cd.value
									+ "&vps_port_cd=" + formObj.vps_port_cd.value
									+ "&pagerows=" + formObj.pagerows.value
									+ "&page_no=" + formObj.page_no.value;
						}else{
							fParam = FormQueryString(formObj);
						}
						
						
						var sParam = fParam + "&" + ComGetPrefixParam(sheetID+"_");
						
						//alert(sParam);
						
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0065GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj,formObj,sXml);
					}
				}
				break;
				
			case SEARCH01:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0065GS.do", sParam);
					
					return sXml;
				}

			case COMMAND01:        	// VVD Search
				var vslCd = formObj.vsl_cd.value;
            	
            	if(vslCd == ""){
            		//sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
            		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		//sUrl = "/hanjin/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;

			case COMMAND02:      // Lane Pop-up
				//sUrl = "/hanjin/VOP_VSK_0202.do?op_=0202";
				sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
				break;

			case COMMAND03:      // Port Pop-up
				//sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
				sUrl = "/hanjin/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;

			case COMMAND10:        //btn_period
				var cal = new ComCalendarFromTo();
				cal.setEndFunction("returnPeriodHelp");	//Calendar 종료 시 호출할 Function 지정.
				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				break;

			case IBDOWNEXCEL:        	//엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBCLEAR:      // New
				clearAllData(sheetObj, formObj);
				break;
		}
	}



	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetId = sheetObj.id;
		
    	switch(sAction) {

			case IBSEARCH:      //조회
				if (sheetId == "t1sheet1"){
					if(ComIsNull(formObj.vsl_cd.value)){
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.focus();
						return false;
					}
				}else if(sheetId == "t2sheet1"){
					if(ComIsNull(formObj.vps_port_cd.value)){
						ComShowCodeMessage('VSK00027', "Port Code");
						formObj.vps_port_cd.focus();
						return false;
					}
					if(checkVVDLen()){
						formObj.fm_dt.value = "";
						formObj.to_dt.value = "";
					}
				}
			
				if(!(formObj.fm_dt.value=="" && formObj.to_dt.value=="")){
					if(formObj.fm_dt.value==""){
		    			ComShowCodeMessage("COM12114", "Period");
		    			formObj.fm_dt.focus();
		    			return false;
		    		}else if(formObj.to_dt.value==""){
		    			ComShowCodeMessage("COM12114", "Period");
		    			formObj.to_dt.focus();
		    			return false;
		    		}
				}
				
			break;
    	}

		return true;
	}
	
	function checkVVDLen(){
		var formObj = document.form;
		var vvd = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
		if(ComChkLen(ComTrim(vvd), 9)==2){
			return true;
		}else{
			return false;
		}
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
					if (sheetObj.id == "t1sheet1"){
						sheetObj.Redraw = false;
						
						var xmlChgStsCd = ComGetEtcData(sXml, "chg_sts_cd");		//Change Status Code
						var xmlChgStsNm = ComGetEtcData(sXml, "chg_sts_nm");
						
						xmlChgStsNm = ComReplaceStr(xmlChgStsNm, " calling", ""); //Change Status CodeName(code명이 길어서 줄임).
						sheetObj.InitDataCombo(0, prefix+"vskd_cng_tp_cd", xmlChgStsNm, xmlChgStsCd);
						
						if(formObj.page_no.value=="1"){
							sheetObj.LoadSearchXml(sXml, false);
						}else{
							sheetObj.LoadSearchXml(sXml, true);
						}
						sheetObj.Redraw = true;
					} else if (sheetObj.id == "t2sheet1") {
						sheetObj.Redraw = false;
						if(formObj.page_no.value=="1"){
							sheetObj.LoadSearchXml(sXml, false);
						}else{
							sheetObj.LoadSearchXml(sXml, true);
						}
						sheetObj.Redraw = true;
						
					}
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
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

	function t1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		var formObj = document.form;
  		formObj.page_no.value = PageNo;
  		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
	
	function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		var formObj = document.form;
  		formObj.page_no.value = PageNo;
  		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	//- form 전체 컨트롤 onkeydown 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	}
    
    function obj_focus(){
    	var eleObj = event.srcElement;
    	if(eleObj.name){
			focusObj = eleObj.name;
		}else{
			focusObj = "";
		}
    	
    	if(eleObj.options){
    		eleObj.focus();
    	}else{
    		eleObj.select();
    	}
    }
    
	function obj_change(){
		var formObj = document.form;
		
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
		            	var vslCd = formObj.vsl_cd.value;
		            	
		            	if(!ComIsNull(vslCd)){
		            		if(vslCd.length < 4){
		            			ComShowCodeMessage('VSK01018', vslCd);
		            			formObj.vsl_cd.value = "";
		        				formObj.vsl_cd.focus();
		        				return false;
		            		}
		            	}
		            	
		            	if(beforetab == 0){
		        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
		        		}
		        		else if(beforetab == 1){
		        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
		        		}
		            	
		            	if(formObj.vsl_cd.value.length == 4){
				    		formObj.skd_voy_no.focus();
				    	}
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	
	            case "skd_voy_no":
	            	var skdVoyNo = formObj.skd_voy_no.value;
	            	
	            	if(!ComIsNull(skdVoyNo)){
	            		if(skdVoyNo.length < 4){
	            			ComShowCodeMessage('VSK01018', skdVoyNo);
	            			formObj.skd_voy_no.value = "";
	        				formObj.skd_voy_no.focus();
	        				return false;
	            		}
	            	}

	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	            	
	            	if(formObj.skd_voy_no.value.length == 4){
			    		formObj.skd_dir_cd.focus();
			    	}
	            	break;
	            case "skd_dir_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	            	
	            	if(formObj.skd_dir_cd.value.length == 1){
			    		formObj.vsl_slan_cd.focus();
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
	            	
	            	if(beforetab == 0){
	        			glbFormDataTab1.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
	            	
	            	break;
	
	            case "vps_port_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        		}
	            	
	            	break;
                	
                case "fm_dt":
                	formObj.fm_dt.value = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
	            	if(beforetab == 0){
	        			glbFormDataTab1.setFmDt(formObj.fm_dt.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setFmDt(formObj.fm_dt.value);
	        		}
                	break;
                	
                case "to_dt":
                	formObj.to_dt.value = ComGetMaskedValue(formObj.to_dt.value, "ymd");
	            	if(beforetab == 0){
	        			glbFormDataTab1.setToDt(formObj.to_dt.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setToDt(formObj.to_dt.value);
	        		}
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
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
				
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
	    	case "vps_port_cd":
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
	
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break;

		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.vps_port_cd.focus();
		    	}
				break;

		    case "vps_port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.fm_dt.focus();
		    	}
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
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_slan_cd.value = rtnDatas[1];
					
					if(beforetab == 0){
	        			glbFormDataTab1.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
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
					formObj.loc_cd.value = rtnDatas[2];
					formObj.vps_port_cd.value = rtnDatas[2];
					
					if(beforetab == 0){
	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
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
	 * 달력 호출 후 날짜 입력 시 실행
	 * @param rtnObjs
	 * @return
	 */
	function returnPeriodHelp(rtnObjs){
		var formObj = document.form;
		
		if(beforetab == 0){
        	glbFormDataTab1.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab1.setToDt(formObj.to_dt.value);
		}
		else if(beforetab == 1){
        	glbFormDataTab2.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab2.setToDt(formObj.to_dt.value);
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
				VskEnableObjectControl(formObj.vps_port_cd,  true, false);
				VskEnableObjectControl(formObj.vsl_cd, true, true);
//				VskEnableObjectControl(formObj.skd_voy_no, false);
//				VskEnableObjectControl(formObj.skd_dir_cd, false);
//				
				VskEnableObjectControl(formObj.btn_port_cd, true);
//				VskEnableObjectControl(formObj.btn_period, true);
//				VskEnableObjectControl(formObj.btn_vvd, false);
//
//				VskEnableObjectControl(formObj.fm_dt, true, false);
//				VskEnableObjectControl(formObj.to_dt, true, false);
				
				formObj.vsl_cd.focus();
				
				break;
			case 1:      //tab2
				VskEnableObjectControl(formObj.vps_port_cd, true, true);
				VskEnableObjectControl(formObj.vsl_cd, true, false);
//				VskEnableObjectControl(formObj.skd_voy_no, false);
//				VskEnableObjectControl(formObj.skd_dir_cd, false);
//				
				VskEnableObjectControl(formObj.btn_port_cd, true);
//				VskEnableObjectControl(formObj.btn_period, true);
//				VskEnableObjectControl(formObj.btn_vvd, false);
//				
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				
				formObj.vps_port_cd.focus();
				
				break;
		}
		setConditionData(formObj, nItem);
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
				}else{
					formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value = ComGetNowInfo();
				}
				break;
			case 1:      //tab2
				if(glbFormDataTab2 != null){
					glbFormDataTab2.setAllFormData();
				}else{
					formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value = ComGetNowInfo();
				}
				break;
		}
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
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		
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
	
    /**
     * [New] Button Event : 화면을 초기화 한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	if(sheetObj.id == "t1sheet1"){
    		glbFormDataTab1 = new Usr_Condi_FormData();
    		glbFormDataTab1.setAllFormData();
		} else {
			glbFormDataTab2 = new Usr_Condi_FormData();
			glbFormDataTab2.setAllFormData();
		}
    	
    	sheetObj.RemoveAll();
    	
    	//현재월의 첫날부터 현재일까지 셋팅.
    	formObj.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
    	formObj.to_dt.value = ComGetNowInfo();
    	//날짜 초기 데이터 setting
    	glbFormDataTab1.setFmDt(formObj.fm_dt.value);
    	glbFormDataTab1.setToDt(formObj.to_dt.value);
    	glbFormDataTab2.setFmDt(formObj.fm_dt.value);
    	glbFormDataTab2.setToDt(formObj.to_dt.value);
    	
    	if(sheetObj.id == "t1sheet1"){
    		formObj.vsl_cd.focus();
		} else {
			formObj.vps_port_cd.focus();
		}
    }

	/*
	 * =====================================================================
	 * Form Condition Elements Getter/Setter
	 * =====================================================================
	 */
 	
 	function Usr_Condi_FormData(){
		this.vslCd = "";
		this.skdVoyNo = "";
		this.skdDirCd = "";
 		this.vslSlanCd = "";
		this.vpsPortCd = "";
		this.fmDt = "";
		this.toDt = "";
	}
	
	//Usr_Condi_FormData.Getter()
	Usr_Condi_FormData.prototype.getVslCd = function(){
		return this.vslCd;
	}
	Usr_Condi_FormData.prototype.getSkdVoyNo = function(){
		return this.skdVoyNo;
	}
	Usr_Condi_FormData.prototype.getSkdDirCd = function(){
		return this.skdDirCd;
	}
	Usr_Condi_FormData.prototype.getVslSlanCd = function(){
		return this.vslSlanCd;
	}
	Usr_Condi_FormData.prototype.getVpsPortCd = function(){
		return this.vpsPortCd;
	}
	Usr_Condi_FormData.prototype.getFmDt = function(){
		return this.fmDt;
	}
	Usr_Condi_FormData.prototype.getToDt = function(){
		return this.toDt;
	}

	//Usr_Condi_FormData.Setter()
	Usr_Condi_FormData.prototype.setVslCd = function(sVslCd){
		this.vslCd = sVslCd;
	}
	Usr_Condi_FormData.prototype.setSkdVoyNo = function(sSkdVoyNo){
		this.skdVoyNo = sSkdVoyNo;
	}
	Usr_Condi_FormData.prototype.setSkdDirCd = function(sSkdDirCd){
		this.skdDirCd = sSkdDirCd;
	}
	Usr_Condi_FormData.prototype.setVslSlanCd = function(sVslSlanCd){
		this.vslSlanCd = sVslSlanCd;
	}
	Usr_Condi_FormData.prototype.setVpsPortCd = function(sVpsPortCd){
		this.vpsPortCd = sVpsPortCd;
	}
	Usr_Condi_FormData.prototype.setFmDt = function(sFmDt){
		this.fmDt = sFmDt;
	}
	Usr_Condi_FormData.prototype.setToDt = function(sToDt){
		this.toDt = sToDt;
	}
	
	Usr_Condi_FormData.prototype.setAllFormData = function(){
		var formObj = document.form;

		formObj.vsl_cd.value = this.getVslCd();
		formObj.skd_voy_no.value = this.getSkdVoyNo();
		formObj.skd_dir_cd.value = this.getSkdDirCd();
		formObj.vsl_slan_cd.value = this.getVslSlanCd();
		formObj.vps_port_cd.value = this.getVpsPortCd();
		formObj.fm_dt.value = this.getFmDt();
		formObj.to_dt.value = this.getToDt();
	}
    
	/* 개발자 작업  끝 */