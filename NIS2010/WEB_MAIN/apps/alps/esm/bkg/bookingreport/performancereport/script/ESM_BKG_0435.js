/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0435.js
 *@FileTitle : bookringreport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.10
 *@LastModifier : 정선용
 *@LastVersion : 1.0
 * 2009.06.10 정선용
 * 1.0 Creation
 * 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
 * 2012.11.21 조정민 [CHM-201220634] SI TURN TIME REPORT 계산식 변경 및 TURN TIME 항목 추가 요청
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
 * @class esm_bkg_0435 : esm_bkg_0435 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function esm_bkg_0435() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.setTabObject 			= setTabObject;
		this.setComboObject 		= setComboObject;
	}
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var prefix = "sheet1_";
	
	var comboCnt = 0; //2011.09.05 jsy
 	var comboObjects = new Array(); //2011.09.05 jsy
 	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_Retrieve":
					if (tabObjects[0].SelectedIndex == 0){
						formObject.f_cmd.value = SEARCH02;
						if(formObject.dp_tp.value=="L"){
							prefix = "sheet1_"
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}else{
							prefix = "sheet2_"
							doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
						}
					}else if (tabObjects[0].SelectedIndex == 1){
						prefix = "sheet3_"
						formObject.f_cmd.value = SEARCH03;
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);	
					}else if (tabObjects[0].SelectedIndex == 2){
						prefix = "sheet4_"
						formObject.f_cmd.value = SEARCH04;
						doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);	
					}
					break;	
				case "btn_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
					break;
				case "btn_DownExcel":
					if (tabObjects[0].SelectedIndex == 0){
						if(formObject.dp_tp.value=="L"){
							doActionIBSheet(sheetObjects[0], document.form, "btn_DownExcel");
						}else{
							doActionIBSheet(sheetObjects[1], document.form, "btn_DownExcel");
						}
					}else{
						doActionIBSheet(sheetObjects[2], document.form, "btn_DownExcel");
					}
					break;
				case "btn_DtlDownExcel":
					prefix = "sheet3_"
					doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);	
					doActionIBSheet(sheetObjects[2], document.form, "btn_DownExcel");
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 
 	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		  //MultiCombo초기화 --jsy 2011.09.05
 	    for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
		document.form.fm_dt.value = getCalculatedDate(0, 0, -1, "-");
		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
  		ComEnableManyObjects(false, document.form.tvvd , document.form.sr_no);
		setSheetVisble(0);
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		initControl();
		document.getElementById("mainTable2").style.display = "";
	}
	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form;
				initComboEditable(comboObj, comboId);
 	}
 	//콤보 멀티 셀렉트 및 수정 여부 초기 설정
	 function initComboEditable(combo, comboId){
 	 	with (combo) {
        	if(comboId == "dpcs_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
	        	}else{
		 			DropHeight = 150;
		 	 		MultiSelect = false;
		 	 		UseEdit = false;
	        	}
 
	 	 	}
	 }
	 
	 function dpcs_ofc_cd_OnChange(comboObj) {
	    	var formObj = document.form;
	    	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
	    	var param = FormQueryString(formObj);
	    	
	        if(comboObj.Text == 'PKGSA'){
	        	param = param + "&cm_code=CD03249";
	        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	        	var arrXml = sXml.split("|$$|");
	        	if (arrXml[0].length > 0) {
	        		ComXml2ComboItem(arrXml[0], formObj.rgn_ofc_cd, "val", "val|name");
	        	}

			    formObj.elements["rgn_ofc_cd"].Index = 0;
	        }else{
	        	param = param + "&cm_code=CD03250";
	        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	        	var arrXml = sXml.split("|$$|");
	        	if (arrXml[0].length > 0) {
	        		ComXml2ComboItem(arrXml[0], formObj.rgn_ofc_cd, "val", "val|name");
	        	}
			    formObj.elements["rgn_ofc_cd"].Index = 0;
	        }
	    }
	  	
	function initControl() {
		/* KeyPress Event 받아서 format 변환 */
		DATE_SEPARATOR = "-";
		var formObject = document.form;
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');//Enter key 처리
		axon_event.addListenerForm('change', 'objChange', formObject );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListenerForm  ('click',    'obj_click',      formObject); 
	}
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var formObj = document.form;
        switch (event.srcElement.getAttribute("name")) {
            case "fm_dt":
                ComAddSeparator(event.srcElement);
            break;
            case "to_dt":
                ComAddSeparator(event.srcElement);
            break;
        }
    }
    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "fm_dt":
                ComClearSeparator(event.srcElement);
            break;
            case "to_dt":
                ComClearSeparator(event.srcElement);
            break;
        }
    }
    
	function sheet1_OnLoadFinish(sheetObj) {
        sheetObj.WaitImageVisible = false;
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	    sheetObj.WaitImageVisible = true; 
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
			case 1: //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(30, 0, 0, true);

					
					prefix = "sheet1_";
					var HeadTitle1 = "Seq.|Region|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|"
									+"Input leg|Input leg|Input leg|Input leg|Input leg|Input leg|Input leg|"
									+"Rate leg|Rate leg|Rate leg|Rate leg|Rate leg|Rate leg|Rate leg|"
									+"Audit leg|Audit leg|Audit leg|Audit leg|Audit leg|Audit leg|Audit leg|";
					var HeadTitle2 = "Seq.|Region|SI|PIC|Turn Time|Actual|Idling|Standard|OverTime|SI|PIC|Turn Time|Actual|Idling|Standard|OverTime|SI|PIC|Turn Time|Actual|Idling|Standard|OverTime|SI|PIC|Turn Time|Actual|Idling|Standard|OverTime|";
//					var headCount = ComCountHeadTitle(HeadTitle);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "rgn_ofc_cd", false, "", dfNone, 0, false, true);
//					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, true);
//					InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "sr_amd_tp_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ttl_sr", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ttl_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_act_tt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_idl_tt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_biz_tt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_ovt_tt", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "id_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "id_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "idl_to_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_biz_tm", false, "", dfNone, 0, false, true);
					
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "rd_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "rd_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "idl_to_rd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_biz_tm", false, "", dfNone, 0, false, true);					
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ad_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ad_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "idl_to_ad", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_ovt", false, "", dfNone, 0, false, true);

				}
				break;
			case 2: //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(22, 0, 0, true);

					
					prefix = "sheet2_";
					var HeadTitle1 = "Seq.|Region|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|Average STT in total(hh:mm:ss)|"
									+"Input leg|Input leg|Input leg|Input leg|Input leg|"
									+"Rate leg|Rate leg|Rate leg|Rate leg|Rate leg|"
									+"Audit leg|Audit leg|Audit leg|Audit leg|Audit leg|";
					var HeadTitle2 = "Seq.|Region|SI|PIC|Turn Time|Actual|Standard|SI|PIC|Turn Time|Actual|Standard|SI|PIC|Turn Time|Actual|Standard|SI|PIC|Turn Time|Actual|Standard|";
//					var headCount = ComCountHeadTitle(HeadTitle);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "rgn_ofc_cd", false, "", dfNone, 0, false, true);
//					InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, true);
//					InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "sr_amd_tp_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ttl_sr", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ttl_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_act_tt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ttl_biz_tt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "id_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "id_pic", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_biz_tm", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "rd_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "rd_pic", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_biz_tm", false, "", dfNone, 0, false, true);
										
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ad_sr_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ad_pic", false, "", dfNone, 0, false, true);	
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_tt" ,  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_biz_tm", false, "", dfNone, 0, false, true);
					
					
				}
				break;
			case 3: //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(54, 0, 0, true);

					
					prefix = "sheet3_";
					var HeadTitle1 =  "Seq.|SI NO|BKG No|Kind|T.VVD|BKG Ofc|POL|POD|Via|CM|HBL|Region|SI Receive|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|"
										+"Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|"
										+"Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|"
										+"Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|"
										+"pnd_flg|sr_crnt_info_cd|sr_crnt_sts_cd|bl_do_inp_flg|bl_rt_flg|bl_aud_flg|bl_draft_fax_out_flg|sr_wrk_sts_cd|xter_sndr_id|";
					var HeadTitle2 = "Seq.|SI NO|BKG No|Kind|T.VVD|BKG Ofc|POL|POD|Via|CM|HBL|Region|SI Receive|SI Start Due|Input Start|Input End|Biz. Hour \nElapsed-Input|Over Time\n Input|Actual \nElapsed Input|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"Rate Start|Rate End|Biz. Hour \nElapsed-Rate|Over Time\n Rate|Actual \nElapsed Rate|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"QA Start|QA End|Biz. Hour \nElapsed-QA|Over Time\n QA|Actual \nElapsed QA|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"Holiday(s)|Pending Start|Pending End|Pending \nElapsed|Return Start|Return to RTN|Return \nElapsed|"
										+"pnd_flg|sr_crnt_info_cd|sr_crnt_sts_cd|bl_do_inp_flg|bl_rt_flg|bl_aud_flg|bl_draft_fax_out_flg|sr_wrk_sts_cd|xter_sndr_id|";
//					var headCount = ComCountHeadTitle(HeadTitle);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "sr_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "bkg_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "sr_amd_tp_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "tvvd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "pol_cd", false, "", dfNone, 0, false, true);	
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "pod_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "sr_knd_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "cm_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "hbl_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "rgn_ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "fnt_ofc_trns_dt", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "sr_due_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "id_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "id_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rd_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rd_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_act_tm", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "ad_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "ad_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "hol_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "pn_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "pn_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "pn_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rt_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rt_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rt_act_tm", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "pnd_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_crnt_info_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_crnt_sts_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_doc_inp_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_rt_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_aud_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_draft_fax_out_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_wrk_sts_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "xter_sndr_id", false, "", dfNone, 0, false, true);		

				}
				break;
				
			case 4: //sheet4 init
				with (sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(54, 0, 0, true);
	
					prefix = "sheet4_";
					var HeadTitle1 =  "Seq.|SI NO|BKG No|Kind|T.VVD|BKG Ofc|POL|POD|Via|CM|HBL|Region|SI Receive|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|Input Part|"
										+"Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|Rate Section|"
										+"Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|Audit Part|"
										+"Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|Non-Working Time|"
										+"pnd_flg|sr_crnt_info_cd|sr_crnt_sts_cd|bl_do_inp_flg|bl_rt_flg|bl_aud_flg|bl_draft_fax_out_flg|sr_wrk_sts_cd|xter_sndr_id|";
					var HeadTitle2 = "Seq.|SI NO|BKG No|Kind|T.VVD|BKG Ofc|POL|POD|Via|CM|HBL|Region|SI Receive|SI Start Due|Input Start|Input End|Biz. Hour \nElapsed-Input|Over Time\n Input|Actual \nElapsed Input|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"Rate Start|Rate End|Biz. Hour \nElapsed-Rate|Over Time\n Rate|Actual \nElapsed Rate|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"QA Start|QA End|Biz. Hour \nElapsed-QA|Over Time\n QA|Actual \nElapsed QA|Idling Biz. \n Hour Elapsed|Idling \n Over Time|Idling Actual \n Time Elapsed|"
										+"Holiday(s)|Pending Start|Pending End|Pending \nElapsed|Return Start|Return to RTN|Return \nElapsed|"
										+"pnd_flg|sr_crnt_info_cd|sr_crnt_sts_cd|bl_do_inp_flg|bl_rt_flg|bl_aud_flg|bl_draft_fax_out_flg|sr_wrk_sts_cd|xter_sndr_id|";
	//				var headCount = ComCountHeadTitle(HeadTitle);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "sr_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "bkg_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "sr_amd_tp_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "tvvd", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "pol_cd", false, "", dfNone, 0, false, true);	
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "pod_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "sr_knd_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "cm_cnt", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "hbl_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "rgn_ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "fnt_ofc_trns_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "sr_due_dt", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "id_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "id_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "id_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rd_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rd_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_act_tm", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rd_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "ad_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "ad_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_biz_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_ovt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_wrk_tm_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_ovt_idle_hrs", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "ad_sr_idle_hrs", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "hol_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "pn_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "pn_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "pn_act_tm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rt_st_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "rt_end_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rt_act_tm", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "pnd_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_crnt_info_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_crnt_sts_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_doc_inp_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_rt_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_aud_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "bl_draft_fax_out_flg", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "sr_wrk_sts_cd", false, "", dfNone, 0, false, true);		
					InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, prefix + "xter_sndr_id", false, "", dfNone, 0, false, true);		
	
				}
				break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case IBCLEAR:
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0435GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
                ComXml2ComboItem(arrXml[0], formObj.rgn_ofc_cd, "val", "val|name");
                ComXml2ComboItem(arrXml[1], formObj.sr_amd_tp_cd, "val", "name");
                ComXml2ComboItem(arrXml[2], formObj.dpcs_ofc_cd, "val", "name");
                formObj.rgn_ofc_cd.Index = 0;
                formObj.sr_amd_tp_cd.Index = 0;
			    if(formObj.usr_ofc_cd.value == "PKGSA"){
			    	formObj.elements["dpcs_ofc_cd"].Index =0 ;
            	}else if(formObj.usr_ofc_cd.value == "SZPSC" || formObj.usr_ofc_cd.value == "ZHOSO" ||
           			     formObj.usr_ofc_cd.value == "CANSO" || formObj.usr_ofc_cd.value == "FOCSO" ||
           			     formObj.usr_ofc_cd.value == "XMNSC" || formObj.usr_ofc_cd.value == "HKGSC" ){
            		formObj.elements["dpcs_ofc_cd"].Index =1 ;
            	}
                break;
                
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction))
					return
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);  //대기이미지 표시
				sheetObj.RemoveAll();
				sheetObj.Redraw = false;
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0435GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(searchXml);
				sheetObj.Redraw = true;
				ComOpenWait(false); //대기이미지 숨김
				break;
			case "btn_DownExcel":
				sheetObj.SpeedDown2Excel(1);
				break;
		}
	}	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: //조회
            	if(ComGetObjValue(formObj.dpcs_ofc_cd) == ""){
            		ComShowCodeMessage("BKG01101", "Doc OFC")
                    formObj.dpcs_ofc_cd.focus();
                    return false;
            	}
				if (formObj.chk_rdo.value == 'P' &&( fm_dt.value == '' || formObj.to_dt.value == '')) {
					ComShowCodeMessage("BKG00499");//Period are mandatory items.
					formObj.fm_dt.focus();
					//ComAlertFocus(formObj.fm_dt, ComShowCodeMessage("BKG00499"));//Period are mandatory items.
					return false;
				}
				else if(tabObjects[0].SelectedIndex != 0 && formObj.rgn_ofc_cd.Code == 'A' 
					&& ComGetDaysBetween(formObj.fm_dt.value,formObj.to_dt.value) > 14 ) {
					ComShowCodeMessage("COM132001","Duration","14 days");
                    return false
				}
				else if(ComGetDaysBetween(formObj.fm_dt.value,formObj.to_dt.value) > 31) {
					ComShowCodeMessage("COM132001","Duration","1Month");
                    return false
				} 
				break;				
		}
		return true;
	}
	/**
	 * Remark Image Setting
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) { 
//			for ( var i = 1; i <= sheetObj.LastRow; i++) {
//				CellImage(i, 12) = 0;
//			}
		}
		
	}
	
	function getGetSheetRowParam(sheetObj, Row, prefix, param){
		var sParam = "?";
		with (sheetObj) {
			for(i=0;i<param.length;i++){
				sParam += "&"+param[i]+"=" + CellValue(Row,prefix+param[i]);  
			}	
		}
		return sParam;
	}
	/**
	 * 날짜 계산 함수
	 */
	function getCalculatedDate(iYear, iMonth, iDay, seperator) {
		//현재 날짜 객체를 얻어옴
		var gdCurDate = new Date();
		//현재 날짜에 날짜 계산
		gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
		gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
		gdCurDate.setDate(gdCurDate.getDate() + iDay);
		//실제 사용할 연,월,일 변수 받기
		var giYear = gdCurDate.getFullYear();
		var giMonth = gdCurDate.getMonth() + 1;
		var giDay = gdCurDate.getDate();
		//월,일의 자릿수를 2자리로 맞춘다.
		giMonth = "0" + giMonth;
		giMonth = giMonth.substring(giMonth.length - 2, giMonth.length);
		giDay = "0" + giDay;
		giDay = giDay.substring(giDay.length - 2, giDay.length);
		//alert(giYear + seperator + giMonth + seperator + giDay);
		//display 형태 맞추기
		return giYear + seperator + giMonth + seperator + giDay;
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
                    InsertTab( cnt++ , "Summary" , -1 );
                    InsertTab( cnt++ , "Detail" , -1 );
                    InsertTab( cnt++ , "Detail SS" , -1 );
                    //BaseColor = "243,242,248";       
                }
             break;

         }
    }
     function tab1_OnClick(tabObj, nItem){
    	 	setSheetVisble(nItem);
     }
     
     function setSheetVisble(inx){
    	for(var k=0; k< mainTable.length; k++){
 		    mainTable[k].style.display ="none";
 		}
 		mainTable[inx].style.display ="";
     }
     function objChange(){
    	 var objName =event.srcElement.name;
    	 var objValue = event.srcElement.value;
    	 var formObj = document.form;
    	 switch (objName) {
    	 case"dp_tp":
    		 if (tabObjects[0].SelectedIndex == 0){
	    		 if(objValue == 'L'){
	    			 document.getElementById("mainTable1").style.display = "";
	    			 document.getElementById("mainTable2").style.display = "none";
	    		 }else{
	    			 document.getElementById("mainTable1").style.display = "none";
	    			 document.getElementById("mainTable2").style.display = "";
	    		 }
    		 }
    		 break;
    	 }
     }
     
     
     /*
      *  Search Option or Item Option Modify
      */
     function sheet3_OnDblClick(sheetObj,rowIdx,colIdx) {     	
        var param = "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no")
	        + "&ui_id=ESM_BKG_0435"
	        + "&grp_cd=''"
	        + "&sr_kind="+sheetObj.CellValue(rowIdx, prefix+"sr_amd_tp_cd")
	        + "&sr_no="+sheetObj.CellValue(rowIdx, prefix+"sr_no")
	        + "&pnd_flg="+sheetObj.CellValue(rowIdx, prefix+"pnd_flg")
	        + "&src_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_knd_cd")
	        + "&sr_crnt_info_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_crnt_info_cd")
	        + "&sr_crnt_sts_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_crnt_sts_cd")
	        + "&bl_doc_inp_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_doc_inp_flg")
	        + "&bl_rt_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_rt_flg")
	        + "&bl_aud_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_aud_flg")
	        + "&bl_drft_fax_out_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_drft_fax_out_flg")
        	+ "&sr_wrk_sts_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_wrk_sts_cd")
        	+ "&xter_sndr_id="+sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") //2011.08.16 jsy
        	+ "&row_idx="+rowIdx;
        popWinObj = ComOpenWindowCenter2("/hanjin/ESM_BKG_0422.do"+param, "Queue Detail", 1020,630,false,"scrollbars=no,resizable=yes");
       	
     }
      
      function obj_click() {
  		var formObj = document.form;        
  		with(formObj) {
  			switch(event.srcElement.name){
  	            case "chk_rdo":
  	            	if (event.srcElement.value == "P") {
  	            		ComEnableManyObjects(false, tvvd , sr_no);
  	            		ComEnableManyObjects(true, fm_dt , to_dt);
  	            		ComClassNameManyObjects_loc("input1", fm_dt, to_dt);
  	            		document.form.fm_dt.value = getCalculatedDate(0, 0, -1, "-");
  	            		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
  	            		document.form.sr_no.value = "";
  	            		document.form.tvvd.value = "";
  	            	} else if (event.srcElement.value == "V") {
  	            		ComEnableManyObjects(false, fm_dt , to_dt, sr_no);
  	            		ComEnableManyObjects(true, tvvd);
  	            		ComClassNameManyObjects_loc("input1", tvvd);
  	            		document.form.fm_dt.value = "";
  	            		document.form.to_dt.value = "";
  	            		document.form.sr_no.value = "";
  	            	} else if (event.srcElement.value == "S") {
  	            		ComEnableManyObjects(false, tvvd , fm_dt , to_dt);
  	            		ComEnableManyObjects(true, sr_no);
  	            		ComClassNameManyObjects_loc("input1", sr_no);
  	            		document.form.fm_dt.value = "";
  	            		document.form.to_dt.value = "";
  	            		document.form.tvvd.value = "";
  	            	}


  	            	break;
  			}
  		}
      }
      
      function ComClassNameManyObjects_loc(p_className, objs) {
          try {
              var args = arguments;
              if (args.length < 2) return;
              for(var i=1; i<args.length; i++) {
                  if (args[i].tagName != undefined) {
                  	args[i].className = p_className;
                  }
              }
          } catch(err) { ComFuncErrMsg(err.message); }
      }      
      
      
      
      /* 개발자 작업  끝 */