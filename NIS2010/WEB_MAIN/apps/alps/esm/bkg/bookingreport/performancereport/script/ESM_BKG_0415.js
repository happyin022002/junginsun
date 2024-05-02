/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0415.js
 *@FileTitle : bookringreport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.06.10 강동윤
 * 1.0 Creation 
* 2012.01.06 정선용 [CHM-201115386] DPCS System 보완 요청
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
 * @class esm_bkg_0415 : esm_bkg_0415 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function esm_bkg_0415() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.setTabObject 			= setTabObject;
	}
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var prefix = "sheet1_";
	
	var comboCnt = 0;
 	var comboObjects = new Array();
 	
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
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			
			switch (srcName) {
				case "btn_Retrieve":

					if (!validateForm(sheetObjects[0], document.form, IBSEARCH))
						return;
					
					if (tabObjects[0].SelectedIndex == 0){
						doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}else if (tabObjects[0].SelectedIndex == 1){
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
					}else if (tabObjects[0].SelectedIndex == 2){
						doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
					}
					break;
			    case "btn_DownExcel_Summary":
			    	if (tabObjects[0].SelectedIndex == 0){
			    		sheetObject1.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	}else if (tabObjects[0].SelectedIndex == 1){
			    		sheetObject2.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	}else if (tabObjects[0].SelectedIndex == 2){
			    		sheetObject3.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	}
			    	break;	
			    case "btn_DownExcel_dtl":
			    	sheetObject4.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	break;
			    	
			    case "btn_period":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
	function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	function initCombo(comboObj, comboId) {
        var formObject = document.form
        with (comboObj) {
        	if(comboId == "dpcs_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
        	}else{
	            MultiSelect = false;//comboId=="region";
	            UseEdit = false;
	            DropHeight = 200;
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
        		ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
        	}

		    formObj.elements["region"].Index = 0;
        }else{
        	param = param + "&cm_code=CD03250";
        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
        	var arrXml = sXml.split("|$$|");
        	if (arrXml[0].length > 0) {
        		ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
        	}
		    formObj.elements["region"].Index = 0;
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
		//MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k],comboObjects[k].id);
        }  
		document.form.from_dt.value = getCalculatedDate(0, 0, -1, "-");
		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		tab1_OnClick(tabObjects[0], 0)
		initControl();
	}
	function initControl() {
		/* KeyPress Event 받아서 format 변환 */
		DATE_SEPARATOR = "-";
		var formObject = document.form;
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');//Enter key 처리
	}
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var formObj = document.form;
        switch (event.srcElement.getAttribute("name")) {
            case "from_dt":
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
            case "from_dt":
                ComClearSeparator(event.srcElement);
            break;
            case "to_dt":
                ComClearSeparator(event.srcElement);
            break;
        }
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
					style.height = 215;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					prefix = "sheet1_";
					var HeadTitle1 = "Seq.|USER|Name|Evnt\n Count|B/L\n Count|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process" +
							"|Original SI Process|Original SI Process|Original SI Process|Amend|Amend|Amend|Amend|Rider&H/BL|Rider&H/BL|Rider&H/BL|Rider&H/BL|Other(AES,..)|Other(AES,..)|Other(AES,..)|H/BL\n(Mail+Fax)|CM\nCount|CNTR\nCount";
					var HeadTitle2 = "Seq.|USER|Name|Evnt\n Count|B/L\n Count|Orig.\nS/I Total|Aver.\nTime(Sec.)|Point|EDI SI\nCount|Elapse\nTime(Sec.)|EML SI\nCount|Elapse\nTime(Sec.)|FAX SI" +
					"|Elapse\nTime(Sec.)|Sea SI|Elapse\nTime(Sec.)|Amend\nCount|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|Point|Count|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|Point|Count|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|H/BL\n(Mail+Fax)|CM\nCount|CNTR\nCount";
			
					var headCount = ComCountHeadTitle(HeadTitle2);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40,  daCenter, true,  "Seq"                    ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    90,  daLeft,   true,  "user_id"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    110, daLeft,   true,  "user_nm"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, true,  "his_count"               ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, true,  "bl_cnt"                 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, false, "tot_ori_si_cnt"         ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daRight, false, "avg_ori_time"           ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_point"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_edi_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_edi_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60,  daCenter,   false, "tot_ori_email_si_cnt"   ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight,   false, "tot_ori_email_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_fax_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_fax_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_sea_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_sea_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_amend_cnt"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_amend_time"         ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_amend_avg_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_amend_point"        ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_rider_hbl_cnt"      ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_rider_hbl_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_rider_hbl_avg_time" ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_rider_hbl_point"    ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_order_cnt"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_order_time"         ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_order_avg_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_hbl_mail_fax_cnt"   ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_cm_cnt"             ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_cntr_cnt"           ,false, "", dfNone, 0, false, false);
				}
				break;
			case 2: //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 215;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 9, 100);
					prefix = "sheet2_";
					var HeadTitle1 = "Seq.|USER|Name|Event\nCount|B/L\n Count|Orig.\nS/I Count|Elapse\nTime(Sec.)|Orig.\nPoint|S/C" +
									"|RFA|TAA|Self.\nAudit|Pre\nRating|Amend\nCount|Add Point|TTL Point|Aver.\n Time(Sec.)|TTL\n Time(Sec.) ";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true,  "Seq"                  ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "user_id"              ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,   100, daLeft, false, "user_nm"              ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "his_count"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "bl_cnt"               ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_si_cnt"       ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_usr_ori_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_pnt"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "usr_sc_flg_bkg"       ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "usr_rfa_flg_bkg"      ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "usr_taa_flg_bkg"      ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "usr_self_flg_bkg"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "usr_pre_flg_bkg"      ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_amend_cnt"        ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "add_point"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "ttt_point"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "aver_time"            ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tt_time"              ,false, "", dfInteger, 0, false, false);
					FrozenCols = 9;
				}
				break;	
			case 3: //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 215;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					prefix = "sheet1_";
					var HeadTitle1 = "Seq.|USER|Name|Evnt\n Count|B/L\n Count|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process|Original SI Process" +
							"|Original SI Process|Original SI Process|Original SI Process|Amend|Amend|Amend|Amend|Rider&H/BL|Rider&H/BL|Rider&H/BL|Rider&H/BL|Other(AES,..)|Other(AES,..)|Other(AES,..)|H/BL\n(Mail+Fax)|CM\nCount|CNTR\nCount|Advance Manifest\nCount";
					var HeadTitle2 = "Seq.|USER|Name|Evnt\n Count|B/L\n Count|Orig.\nS/I Total|Aver.\nTime(Sec.)|Point|EDI SI\nCount|Elapse\nTime(Sec.)|EML SI\nCount|Elapse\nTime(Sec.)|FAX SI" +
					"|Elapse\nTime(Sec.)|Sea SI|Elapse\nTime(Sec.)|Amend\nCount|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|Point|Count|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|Point|Count|Elapse\nTime(Sec.)|Aver.\n Time(Sec.)|H/BL\n(Mail+Fax)|CM\nCount|CNTR\nCount|Advance Manifest\nCount";
			
					var headCount = ComCountHeadTitle(HeadTitle2);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq, 40,  daCenter, true,  "Seq"                    ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    90,  daLeft,   true,  "user_id"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    110, daLeft,   true,  "user_nm"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, true,  "his_count"               ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, true,  "bl_cnt"                 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daCenter, false, "tot_ori_si_cnt"         ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70,  daRight, false, "avg_ori_time"           ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_point"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_edi_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_edi_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60,  daCenter,   false, "tot_ori_email_si_cnt"   ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight,   false, "tot_ori_email_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_fax_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_fax_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_ori_sea_si_cnt"     ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_ori_sea_time"       ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_amend_cnt"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_amend_time"         ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_amend_avg_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_amend_point"        ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_rider_hbl_cnt"      ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_rider_hbl_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_rider_hbl_avg_time" ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_rider_hbl_point"    ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "tot_order_cnt"          ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_order_time"         ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight, false, "tot_order_avg_time"     ,false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_hbl_mail_fax_cnt"   ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_cm_cnt"             ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "tot_cntr_cnt"           ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    90, daCenter, true,  "tot_cstms_mf_tp_cd_cnt" ,false, "", dfNone, 0, false, false);
				}
				break;	
			case 4: //detail sheet
				with (sheetObj) {
					// 높이 설정
		            style.height = 197;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "Seq|Pic User ID|User Name|User Group|Region|BKG No|S/I No|SI Kind|Urgent|SRC|RTN Freq|Amend Freq|VVD|POL|DEL|||CNTR CNT|CM CNT|H BL CNT|SELF AUDIT|RATE TYPE";
		            var headCount = ComCountHeadTitle(HeadTitle);		            
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtSeq,		 50,	daCenter,	 false,	  "seq_no");
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "pic_usr_id",        false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "usr_nm",     false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,      false,   "usr_group",        false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "region_nm",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "bkg_no",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "si_no",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "si_knd",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "sr_urg_nm",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "src",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "rtn_freq",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "amd_freq",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "vvd_cd",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "pol",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "del",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHidden,    80,   daLeft,  	 false,   "region",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHidden,    80,   daLeft,  	 false,   "urgent",       false,   "",      dfNone,         0,     true,       true);
		            
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "cntr_cnt",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "cm_cnt",       false,   "",      dfNone,         0,     true,       true);
		            
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "h_bl",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "self_audit",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "rate_type",       false,   "",      dfNone,         0,     true,       true);
				}
				break;				
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case IBCLEAR:      // List by Queue조회
				formObj.f_cmd.value = INIT;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0415GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				/* doc part */
			    ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
			    formObj.elements["region"].Index = 0;
				/* doc office */
			    ComXml2ComboItem(arrXml[1], formObj.dpcs_ofc_cd, "val", "val|name");
			    if(formObj.usr_ofc_cd.value == "PKGSA"){
			    	formObj.elements["dpcs_ofc_cd"].Index =0 ;
            	}else if(formObj.usr_ofc_cd.value == "SZPSC" || formObj.usr_ofc_cd.value == "ZHOSO" ||
          			     formObj.usr_ofc_cd.value == "CANSO" || formObj.usr_ofc_cd.value == "FOCSO" ||
          			     formObj.usr_ofc_cd.value == "XMNSC" || formObj.usr_ofc_cd.value == "HKGSC" ){
            		formObj.elements["dpcs_ofc_cd"].Index =1 ;
            	}
			  
				break;    
			case SEARCH01: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				formObj.f_cmd.value = SEARCH01;
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0415GS.do", FormQueryString(formObj));
				
				formObj.usr_grp_cd.value = ComGetEtcData(searchXml,"usrGrpCd");
				formObj.dpcs_wrk_prt_cd.value = ComGetEtcData(searchXml,"usrRptCd");
				formObj.dpcs_wrk_svr_cd.value = ComGetEtcData(searchXml,"usrSvrCd");	
				
				sheetObj.LoadSearchXml(searchXml);
				
				break;	
			case IBSEARCH: //조회
//				if (!validateForm(sheetObj, formObj, sAction))
//					return;
			
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value = SEARCHLIST01;
					formObj.pfm_by_queue_cd.value = 'I';
				}else if (sheetObj.id == "sheet2"){
					formObj.f_cmd.value = SEARCHLIST02;
					formObj.pfm_by_queue_cd.value = 'R';
				}else if (sheetObj.id == "sheet3"){
					formObj.f_cmd.value = SEARCHLIST03;
					formObj.pfm_by_queue_cd.value = 'A';
				}		
				sheetObjects[3].RemoveAll(); 	
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);  //대기이미지 표시
				sheetObj.RemoveAll();
				sheetObj.Redraw = false;
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0415GS.do", FormQueryString(formObj));// + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(searchXml);
				sheetObj.Redraw = true;
				ComOpenWait(false); //대기이미지 숨김
				break;
		}
	}
	
	 // Sheet2 관련 프로세스 처리
    function doActionIBSheet4(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시 
               formObj.f_cmd.value = SEARCH01;
               sheetObj.RemoveAll();
               //------------------------------------------------------------------------------------------
               sheetObj.DoSearch("ESM_BKG_0415GS.do", FormQueryString(formObj)  );
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
            	
				if (formObj.from_dt.value == '' || formObj.to_dt.value == '') {
					ComShowCodeMessage("BKG00499");//Period are mandatory items.
					formObj.from_dt.focus();
					//ComAlertFocus(formObj.from_dt, ComShowCodeMessage("BKG00499"));//Period are mandatory items.
					return false;
				}
				/*else if(formObj.from_dt.value > formObj.to_dt.value ){
					ComShowCodeMessage("BKG00818");
					return false;
				}*/
				else if(ComGetDaysBetween(formObj.from_dt.value,formObj.to_dt.value) > 31 ) {
					ComShowCodeMessage("COM132001","Duration","1Month");
                    return false
				}else if ( ComIsNull(formObj.from_mt)) {
 					ComShowCodeMessage('BKG00626','Period');
 					formObj.from_mt.focus();
 					return false;	
				}else if ( ComIsNull(formObj.to_mt)) {
	 					ComShowCodeMessage('BKG00626','Period');
	 					formObj.to_mt.focus();
	 					return false;	
					}	
				break;
		}
		return true;
	}
	
	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		var formObj = document.form;
		var grp = formObj.pfm_by_queue_cd.value;
		if(grp=='I') {
			formObj.sel_group.value  = 'ID';
		} else if(grp=='R') {
			formObj.sel_group.value  = 'RD';
		}else if(grp=='A') {
			formObj.sel_group.value  = 'AD';
		}
		formObj.list_atnd_usr_id.value = sheetObj.CellValue(rowIdx, "user_id");
		doActionIBSheet4(sheetObjects[3],formObj, IBSEARCH);  
	}		
	
	function sheet2_OnDblClick(sheetObj,rowIdx,colIdx) {
		var formObj = document.form;
		var grp = formObj.pfm_by_queue_cd.value;
		if(grp=='I') {
			formObj.sel_group.value  = 'ID';
		} else if(grp=='R') {
			formObj.sel_group.value  = 'RD';
		} else if(grp=='A') {
			formObj.sel_group.value  = 'AD';
			
		}
		formObj.list_atnd_usr_id.value = sheetObj.CellValue(rowIdx, "user_id");
		doActionIBSheet4(sheetObjects[3],formObj, IBSEARCH);  //sheetObjects[1]->sheet2
	}		
	
	function sheet3_OnDblClick(sheetObj,rowIdx,colIdx) {
		var formObj = document.form;
		var grp = formObj.pfm_by_queue_cd.value;
		if(grp=='I') {
			formObj.sel_group.value  = 'ID';
		} else if(grp=='R') {
			formObj.sel_group.value  = 'RD';
		} else if(grp=='A') {
			formObj.sel_group.value  = 'AD';
			
		}
		formObj.list_atnd_usr_id.value = sheetObj.CellValue(rowIdx, "user_id");
		doActionIBSheet4(sheetObjects[3],formObj, IBSEARCH);
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
                    InsertTab( cnt++ , "Input" , -1 );
                    InsertTab( cnt++ , "Rate" , -1 );
                    InsertTab( cnt++ , "QA" , -1 );
                }
             break;

         }
    }
     function tab1_OnClick(tabObj, nItem){
    	 var formObj = document.form;
    	 setSheetVisble(nItem);
    	 	if (tabObj.SelectedIndex == 1){
    	 		formObj.pfm_by_queue_cd.value = 'R';
    	 	}else if (tabObj.SelectedIndex == 0){
    	 		formObj.pfm_by_queue_cd.value = 'I';
    	 	}else if (tabObj.SelectedIndex == 2){
    	 		formObj.pfm_by_queue_cd.value = 'A';
    	 	}
    	 	sheetObjects[3].RemoveAll(); 	
     }
     
     function setSheetVisble(inx){
 		for(var k=0; k< mainTable.length; k++){
 		    mainTable[k].style.display ="none";
 		}
 		mainTable[inx].style.display ="";
     }
	/* 개발자 작업  끝 */