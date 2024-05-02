
/*=========================================================
	 *Copyright(c) 2017 
	 *@FileName : BCM_CMS_0307.js
	 *@FileTitle : KeyMan List조회 화면
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2017.07.04
	 *@LastModifier : 임진영
	 *@LastVersion : 1.0
	 =========================================================*/

/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     * @extends 
     * @class BCM_CMS_0307  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function BCM_CMS_0307() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.sheet1_OnClick = sheet1_OnClick;
		this.sheet1_OnKeyUp = sheet1_OnKeyUp;
		this.setComboObject = setComboObject;
	}
	/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// MultiComboBox관련 변수
	var comboCnt = 0;
	var comboObjects = new Array();
	var bMultiComboDataAdded = false;
	var bMultiComboDataAdded2 = false;
	var prefix = "sheet1_";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
		var comboObject1 = comboObjects[0];
		/** **************************************************** */
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_Create":
					form.ibflag.value="I";
					ComOpenPopup('/hanjin/BCM_CMS_0308.do?' + param, 800, 380, '', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_BKGList":
					sheet1_OnDblClick(sheetObject1, sheetObject1.SelectRow, 1)
					break;
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;
				case "btn_bdrdate":
					var cal = new ComCalendar();
					cal.select(formObject.bdr_dt, 'yyyy-MM-dd');
					break;
				case "btn_period":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
					break;
				case "btn_com_ens_041":
					   var param="";
		    		   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
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
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// MultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		initControl();
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
	}
	
	function initControl() {
		var formObject = document.form;
		axon_event.addListenerForm  ("change", 			"form_onChange", 		formObject);
		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); // -
		// 키보드// 입력할때
		axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', formObject); // -
		// 포커스// 나갈때
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); // -
		// 포커스// 들어갈때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	
	function bkg_keypress() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch (event.srcElement.dataformat) {
			case "ymd":
				// number
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			case "engup":
				// 영문대문자
				ComKeyOnlyAlphabet('upper');
				break;
			case "engupnum":
				// 숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "num":
				// 숫자 입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
	       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
	       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
	     			event.keyCode = keyValue + 65 - 97;
	     		}
	           break;
			default:
		}
	}
	/**
	 * HTML Control의 onBlur을 제어한다.
	 */
	function bkg_deactivate() {
		var formObj = document.form;
		switch (event.srcElement.getAttribute("name")) {
			case "bdr_dt":
				ComAddSeparator(event.srcElement);
				break;
			case "from_dt":
				ComAddSeparator(event.srcElement);
				break;
			case "to_dt":
				ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 */
	function bkg_activate() {
		// 입력Validation 확인하기
		switch (event.srcElement.name) {
			case "bdr_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "from_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "to_dt":
				ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				formObj.f_cmd.value = SEARCH;
				formObj.cust_seq.value=formObj.cust_cd.value.substring(2,8);
				formObj.cust_cnt_cd.value=formObj.cust_cd.value.substring(0,2);
				
				//form.cust_cd.value=aryPopupData[0][3];
				var sXml = sheetObj.GetSearchXml("BCM_CMS_0307GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				sheetObjects[0].Redraw = false;
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[0].Redraw = true;
				// if ("sheet1" == sheetObj.id)
				// sheetObj.DoSearch("ESM_BKG_0071GS.do",FormQueryString(formObj) +
				// "&" + ComGetPrefixParam("sheet1_"));
				break;
			case SEARCH01: // 조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0071GS.do", FormQueryString(formObj));
				// alert(sXml);
				var arrXml = sXml.split("|$$|");
				// var arrData = ComXml2ComboItem(sXml, formObj.slan_cd,
				// "vsl_slan_cd", "vsl_slan_nm");
				var arrData = ComXml2ComboItem(arrXml[0], formObj.slan_cd, "vsl_slan_cd", "vsl_slan_cd");
				// debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
				var p_skd_dir_cd = "<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
				var arrData = ComXml2ComboItem(p_skd_dir_cd, formObj.skd_dir_cd, "val", "name");
				break;
			case SEARCH09:      //Customer Code check
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH09;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
			        var result=ComGetEtcData(sXml, "result");
			        ;
			        if(result=="" ){
			        	ComShowCodeMessage("COM130402", "Customer Code");
			        	formObj.cust_cnt_cd.value="";
			        	formObj.cust_seq.value="";
			        	formObj.cust_cd.value="";
			        }
					ComOpenWait(false);
				}
			break;
		}
	}
	/**
	 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboid) {
		var formObject = document.form
		switch (comboid) {
			case "slan_cd":
				with (comboObj) {
					// BackColor = "#CCFFFD";
					DropHeight = 100;
					MultiSelect = false;
					UseEdit = true;
					MaxSelect = 1;
					ColCnt = 1;
					UseCode = true;
				}
				break;
		}
	}
	// 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
	/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다. 입력값을 upper로 변경하여 재등록 한다.
	 * 
	 * @param comboObj
	 * @return
	 */
	function slan_cd_OnChange(comboObj) {
		var formObject = document.form;
		// 사용자 입력값을 uppercase로 변경
		var comboText = comboObj.Text.toUpperCase();
		// 이전에 등록되었으면 삭제
		if (bMultiComboDataAdded) {
			comboObj.DeleteItem(0);
			bMultiComboDataAdded = false;
		}
		// 선택 또는 입력한 값이 콤보에 있으면 리턴
		if (comboObj.FindIndex(comboText, 0) != -1) {
			return;
		}
		comboObj.InsertItem(0, comboText, comboText);
		bMultiComboDataAdded = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수)
		comboObj.Text2 = comboText; // 입력값이 선택되게 한다.
	}
	
	var custCntCd3 = "";
	var custSeq3 = "";
	/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다. 입력값을 upper로 변경하여 재등록 한다.
	 * 
	 * @param comboObj
	 * @return
	 */
	function skd_dir_cd_OnChange(comboObj) {
		var formObject = document.form;
		// 사용자 입력값을 uppercase로 변경
		var comboText = comboObj.Text.toUpperCase();
		// 이전에 등록되었으면 삭제
		if (bMultiComboDataAdded2) {
			comboObj.DeleteItem(0);
			bMultiComboDataAdded2 = false;
		}
		// 선택 또는 입력한 값이 콤보에 있으면 리턴
		if (comboObj.FindIndex(comboText, 0) != -1) {
			return;
		}
		comboObj.InsertItem(0, comboText, comboText);
		bMultiComboDataAdded2 = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수)
		comboObj.Text2 = comboText; // 입력값이 선택되게 한다.
	}

	function sheet1_OnClick(sheetObj, Row, Col, Value){
	    //-클릭한 곳의 데이터를 팝업으로 넘긴다.
	    //-넘길데이터의 목록
	    clickParam = "1=1";
	    clickParam = "&row="+Row;
	    
	    clickParam += "&keyman_seq="+sheetObj.CellValue(Row,"sheet1_keyman_seq");

	}
	/*
	 * 그리드 더블클릭 이벤트 처리
	 */
	/**
	* 더블클릭 이벤트 발생시
	**/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){
	    var colName = sheetObj.ColSaveName(Col);

	    if( sheetObj.CellValue(Row,"t2sheet1_"+"is_validated") == "Y"
	        && colName == "t2sheet1_" + "diff_rmk"){
	        ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200 );
	    }else{
	        fncT2SetDataClick();
	    }
	}
	
	/**
	 * Set Data 버튼을 클릭할경우 발생
	 * @return
	 */
	var clickSheetObj = sheetObjects[0];
	var clickRow = 0;
	var clickParam = "";
	var clickBkg = "";
	var clickBlNo = "";
	function fncT2SetDataClick(){
	    var goUrl = "";
	    goUrl = "/hanjin/BCM_CMS_0308.do?";
	    form.ibflag.value="U";
	    ComOpenWindowCenter(goUrl+encodeURI(clickParam),"BCM_CMS_0308",800,380,true);

	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (ComIsNull(formObj.cust_cd) && ComIsNull(formObj.fst_name) && ComIsNull(formObj.last_name) && ComIsNull(formObj.srep_cd)) {
					ComShowCodeMessage("CCD00043", "Customer Code, Last Name, S.Rep");
					formObj.cust_cd.focus();
					return false;
				}
				break;
			case IBSAVE:
				var prefix = "sheet1_";
				for ( var i = sheetObj.HeaderRows; i <= sheetObj.RowCount + sheetObj.HeaderRows - 1; i++) {
					var vUsrId = sheetObj.CellValue(i, prefix + "usr_id");
					if (sheetObj.CellValue(i, prefix + "ibflag") != "R") {
						if (ComIsNull(vUsrId)) {
							ComShowCodeMessage('BKG00768', 'User ID');
							return false;
						}
					}
				}
				break;
		}
		return true;
	}
	/**
	 * 화면 yyyyMMd 날짜 체크
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;// null이면 체크 안함
		return ComIsDate(dateobj.value);
	}
	/**
	 * 화면 skf폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function dateCheckUsa(dateobj) {
		var arrMon = {
			Jan :'01',
			Feb :'02',
			Mar :'03',
			Apr :'04',
			May :'05',
			Jun :'06',
			Jul :'07',
			Aug :'08',
			Sep :'09',
			Oct :'10',
			Nov :'11',
			Dec :'12'
		}
		var date = dateobj.value;
		if (date == "")
			return true;// null이면 체크 안함
		// 			
		var reg = /(^\d{2})([A-Za-z]{3})(\d{2})/; // 정규식
		if (reg.test(date)) {// 일월년 형식입력 확인
			var day = RegExp.$1;
			var mon = RegExp.$2;
			var year = RegExp.$3;
			if (arrMon[mon] == undefined) {// 월이 잘 못 입력됐을 경우.
				return false;
			}
			if (year >= 50) {// 50년보다 크면 1950 아니면 21세기
				if (ComIsDate('19' + year + arrMon[mon] + day))
					return true;
			} else {
				if (ComIsDate('20' + year + arrMon[mon] + day))
					return true;
			}
		}// 일월년 형식입력 확인 끝
		return false;
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = "sheet1_";
		var formObject = document.form;
		if (sheetObj.ColSaveName(Col) == prefix + "usr_id") {
			formObject.ch_usr_id.value = Value;
			doActionIBSheet(sheetObj, formObject, SEARCH01, Row, Col);
		}
	}
	function isNullEtcData(xmlStr) {
		var rtn = false;
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null)
			return true;
		var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if (etcDataNode == null)
			return true;
		var etcNodes = etcDataNode.childNodes;
		if (etcNodes == null)
			return true;
		if (etcNodes.length == 0)
			rtn = true;
		return rtn;
	}
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 410;
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
					var HeadTitle = "|First Name|Last Name|Mr/Ms|Job Title|S.Rep|Customer|work Fax#|keyman_seq|In charge of|Department|Significance|Birthday|Wedding Anniversary|Single/Married|Spouse Name|Email|Character|Work Phone|Mobile Phone|Home Phone|Cust Cnt Code|Cust seq";
					var headCount = ComCountHeadTitle(HeadTitle);
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, prefix + "ibflag");
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "fst_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "last_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "per_title", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "job_title", false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "srep_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 200, daCenter, true, prefix + "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix + "fax_ph_num", false, "", dfNone, 0, false, false);
					//hidden DATA
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "keyman_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "pager_pin", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "occupation", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "eye_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "birth_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "wed_anvrsry_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "hair_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "spouse_name", false, "", dfNone, 0, false, false);
					
					
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "email_addr", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "con_manager_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   100, daCenter, true, prefix + "work_ph_num", false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cell_ph_num", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "home_ph_num", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cust_cnt_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cust_seq", false, "", dfNone, 0, false, false);
					//InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "", false, "", dfNone, 0, false, false);

				}
				break;
		}
	}
	
	
	
	/**
	 * Carrier Code Pop up to read from. <br>
	 */ 
	function setCallBack0B2(aryPopupData) {
		var form=document.form;
		form.cust_seq.value=aryPopupData[0][3].substring(2,8);
		form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
		form.cust_cd.value=aryPopupData[0][3];
	}
	
	function form_onChange(evt,el) {
	  	var formObj = document.form;
	  	var xml = "";
	  	var srcName;
	  	var srcValue;
		var srcObj;
	  	if (el) {
	  		srcObj = el;
	  		srcName = el.getAttribute("name");
	  		srcValue = el.getAttribute("value");
	  		
	  	} else {
	  		srcObj = window.event.srcElement;
	  		srcName = srcObj.getAttribute("name");
	  		srcValue = srcObj.getAttribute("value");
	  		if(srcName != "cust_cd" && formObj.ibflag.value != 'I'){
	  			formObj.ibflag.value					="U";
	  		}
	  	}
	  	switch(srcName) {
	  		case "cust_cd":
		  		if(formObj.cust_cd.value.length>2){	   
		  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
		  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
	           		if(formObj.cust_seq.value.match(/[^0-9]{1}/)){
	           			  ComShowCodeMessage("CCD00039", "Customer Code");
	           			  formObj.cust_cd.value='';
	           			  return false;
	           		}  
	           		var custlpad="";
	           		if (formObj.cust_seq.value.length <6 ){
	           			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
	           				 custlpad=custlpad+"0" ;
	           			}
	           			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
	           		}
	           		doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
	    			if(formObj.cust_cd.value.length==0){
	//            			document.form.cust_cd.focus();
	        		}else{
	    				formObj.ibflag.value="U";
	    				//formObj.cust_cd.readOnly=true;		
	//            				document.form.cust_lgl_eng_nm.focus();
	    				//doActionIBSheet(sheetObject1, formObj, SEARCH);
	        		}
	    		}
		  		break;
	  	}

	}
	

	/* 개발자 작업 끝 */