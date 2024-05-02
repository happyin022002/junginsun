/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0029.js
*@FileTitle : 주간 대상항차 생성/조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
*=========================================================
* History
* 2008.02.15 PEJ   N200801154874 주간 대상항차 기준 변경 관련 요청
*                  변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
* 2009.05.14 배진환 N200905120702 setPeriod 변경
* 2009.10.23 김기대 New FrameWork 적용 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.03.04 이행지 CHM-201002932 chkValidSearch메소드 수정-Week, Month체크시 해당부분만 체크하도록
* 2010.04.14 이행지 FormQueryString => 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 김기종 CSR No. CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
* 2011.02.07 최성민 CHM-201108533-01 Validation 소스 정리
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.04.18 이행지 [CHM-201110235-01] Target VVD 메뉴 내 버튼명 변경(Auto Creation-> BSA&VVD Creation) 및 위치변경, OPR 컬럼추가
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청  -  BSA&VVD Creation, Create T/S Q'ty를 BackEndJob으로 변환
* 2012.07.18 이석준 [CHM-201219046-01] [COA] Target VVD 배치 기능 추가 
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2014.04.04 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
*=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends
	 * @class ESM_COA_0029 : ESM_COA_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_COA_0029() {
	    this.processButtonClick		= processButtonClick;
	    this.chgTrade               = chgTrade;
	    this.popVvdCheck            = popVvdCheck;
	    this.setPeriod              = setPeriod;
	    this.loadPage 				= loadPage;
	    this.initSheet 				= initSheet;
	    this.setSheetObject 		= setSheetObject;
	    this.sheet1_OnChange 		= sheet1_OnChange;
	    this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
	    this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
	    this.doActionIBSheet 		= doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.validateForm2          = validateForm2;
	    this.chkValidSearch         = chkValidSearch;
	    this.setFmToDate            = setFmToDate;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	var popup;
	var ibStatus ;
	var sheet_height = 20; // sheet의 height

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 설  명 : 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <b>Example : </b>
	 * <pre>
	 *    processButtonClick()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;

				case "btn_Rowadd":
					doActionIBSheet(sheetObject, formObject, IBINSERT);
					break;

				case "btn_Save":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
					break;

				case "btn_Auto":
					doActionIBSheet(sheetObject, formObject, IBBATCH);
					break;

				case "btn_Tsqty":
					doActionIBSheet(sheetObject, formObject, IBRESET);
					break;

				case "btn_Creation":
					doActionIBSheet(sheetObject, formObject, IBCREATE);
					break;

				case "btn_Skdinquiry":
					var vsl_cd  = "";
					var classId = "COM_ENS_0B1";
					var param = "";

					if( sheetObject.RowCount > 0){
						if(sheetObject.SelectRow > 1){
							vsl_cd = ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "vsl_cd")) + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "skd_voy_no")) + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "dir_cd"));
						}else{
							//[COM12113] : VVD 를(을) 선택하세요.
							ComShowMessage(ComGetMsg("COM12113", "VVD", ""));
							return false;
						}
						param = '?vvd_cd='+vsl_cd+'&classId='+classId;
						ComOpenPopup("/hanjin/COM_ENS_0B1.do"+param, 620, 400, "", "0,0,1,1,1,1,1,1,1,1", false);
					} else {
						ComShowCodeMessage("COA10040");
					}

					break;

				case "btn_Vvdcheck":
					if(!validateForm(sheetObject, formObject, IBSEARCH)) return false;
					popVvdCheck();
					break;

				case "btn_Monthvvd":
					if(!validateForm(sheetObject, formObject, IBSEARCH_ASYNC02)) return false;
					
					// 암호를 입력후 일치하면 수행하도록한다.
					popup = window.showModalDialog("ESM_COA_3001.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");

					if(popup == "6475"){
						popup = "";						
						popMonthVVDIF();
					}
					break;

				case "btn_Downexcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;

				case "bu_zoom_in":
					sheet_height = getSheetHeightCnt(sheetObject, "MAX", 1);
					sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
					div_zoom_in.style.display = "none";
					div_zoom_out.style.display = "inline";
					parent.syncHeight();
					break;

				case "bu_zoom_out":
					sheet_height = getSheetHeightCnt(sheetObject, "MIN", 0);
					sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
					div_zoom_in.style.display = "inline";
					div_zoom_out.style.display = "none";
					parent.syncHeight();
					break;

				case "btn_Apply_bsa":
					doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111"));
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);

		loadingMode = true;
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k], comboObjects[k].id);
        }
        loadingMode = false;

	}

   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2011.01.25
	*/
	function initCombo(comboObj, comboId) {
		switch(comboObj.id) {
	     	case "f_seltrade":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 3;
	     			UseAutoComplete = false;
	     			ValidChar(2, 1);	//영문대문자+숫자
	     			InsertItem(0, 'All', '');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_selrlane":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 5;
	     			UseAutoComplete = false;
	     			ValidChar(2, 1);	//영문대문자+숫자
	     			InsertItem(0, 'All', '');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_selslane":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 3;
	     			UseAutoComplete = false;
	     			ValidChar(2, 1);	//영문대문자+숫자
	     			InsertItem(0, 'All', '');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_seldir":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 1;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문만 입력
	     			InsertItem(0, 'All', '');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_selioc":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 1;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문만 입력
	     			InsertItem(0, 'All', '');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_hul_bnd_cd":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 1;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문만 입력
	     			Index = 0;
	     		}
	     		break;
	     }
     }

	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj, sheetNo, tpszValue)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @param {String}	Trade  - Trade
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var formObj = document.form;

		switch(sheetNo) {
			case 1:      //sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;                     //전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);     //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
					Editable = true;                                        //전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);                             //행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
					InitHeadMode(true, true, false, true, false, false);     // 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle0 = "Del.|SEL|BSA\nFLAG|STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|Trade Dir.|OPR\n(Operation)|IOC|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Weekly|Weekly|Monthly\nStatus|old|old" ;
					var HeadTitle1 = "Del.|SEL|BSA\nFLAG|STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|Trade Dir.|OPR\n(Operation)|IOC|Port|ETD|S.Lane\n 1st Port ETD|Status|Auto/Mnl|Monthly\nStatus|old|old" ;
					var headCount = ComCountHeadTitle(HeadTitle1);
					InitColumnInfo(headCount, 8, 0, true);                   //컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitHeadRow(0, HeadTitle0, true);                        //해더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, false);                       //해더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]

					//데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter,  true,  "ibDel");
					InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter,  true,  "ibSel");
					InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter,  true,  "bsa_zr_flg");
					InitDataProperty(0, cnt++, dtStatus, 30, daCenter,  true,  "ibflag");
					InitDataProperty(0, cnt++, dtSeq, 30, daCenter,  true,  "",            false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter,  true,  "cost_yrmon",  true,  "", dfDateYm, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter,  true,  "sls_yrmon",   true,  "", dfDateYm, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter,  true,  "cost_wk",     true,  "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 70, daCenter,  true,  "trd_cd",      true,  "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo, 70, daCenter,  true,  "sub_trd_cd",  false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo, 50, daCenter,  true,  "slan_cd",     false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo, 60, daCenter,  true,  "rlane_cd",    true,  "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo, 40, daCenter,  true,  "vsl_lane_tp_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter,  true,  "vsl_cd",      true,  "", dfNone, 0, false, true, 4, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter,  true,  "skd_voy_no",  true,  "", dfNone, 0, false, true, 4, true);
					InitDataProperty(0, cnt++, dtCombo, 40, daCenter,  true,  "dir_cd",      true,  "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 75, daCenter,  true,  "hul_bnd_cd",      false,  "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 80, daCenter,  true,  "vop_cd",      false,  "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 40, daCenter,  true,  "ioc_cd",      true,  "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 70, daCenter,  true,  "lst_lodg_port_cd", true,  "", dfNone, 0, false, true, 5, true);
					InitDataProperty(0, cnt++, dtData, 120, daCenter,  true,  "lst_lodg_port_etd_dt", false, "", dfUserFormat2, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 120, daCenter,  true,  "n1st_lodg_port_etd_dt", false, "", dfUserFormat2, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter,  true,  "wky_tgt_flg", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo, 80, daCenter,  true,  "wky_mnl_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 70, daCenter,  true,  "mon_tgt_flg", false, "", dfNone, 0, false, true);
					

					InitDataProperty(0, cnt++, dtHidden, 70, daCenter,  true,  "old_cost_wk");
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter,  true,  "old_bsa_zr_flg");
					//InitDataProperty(0, cnt++, dtData, 60, daCenter,  true,  "cost_wk",     true,  "", dfNone, 0, true, true);

					HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;
					InitDataValid(0, "vsl_cd", vtEngUpOnly);
					InitDataValid(0, "skd_voy_no", vtNumericOnly);
					InitDataValid(0, "lst_lodg_port_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, "wky_tgt_flg", vtCharOnly, "YESNO");
					InitDataValid(0, "mon_tgt_flg", vtCharOnly, "YESNO");
					InitUserFormat2(0, "lst_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:");
					InitUserFormat2(0, "n1st_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:");

					InitDataCombo(0, "wky_mnl_flg", " |Pre_Manual|Fix_Auto|Fix_Manual", " |P|A|M");
				}
				break;
		}
	}

	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setSheetObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	 /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

     /**
	 * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
	 */
	function setIBMultiCombo(sheetObj, sXml, objName){
		if (sXml == undefined || sXml == ""){
			return;
		}
		var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
		sheetObj.InitDataCombo(0, objName, arrData[1], arrData[0], "", "");

	}

	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, formObj, sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리
		ibStatus = sAction;

		switch(sAction) {
			case IBCLEAR:          //조회
	        	formObj.f_year.value = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");

		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = document.form.sXml.value;

				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if(State == "S"){
					ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}
				var arrXml = sXml.split("|$$|");

				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";

				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "code");
				/*
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "code");
				*/
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_selslane, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_seldir, "code", "code");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_selioc, "code", "code");
				if (arrXml.length > 5)
					ComCoaSetIBCombo(sheetObj, arrXml[5], "trd_cd", true, 0);
				if (arrXml.length > 6)
					ComCoaSetIBCombo(sheetObj, arrXml[6], "sub_trd_cd", true, 0);
				if (arrXml.length > 7)
					ComCoaSetIBCombo(sheetObj, arrXml[7], "slan_cd", true, 0);
				if (arrXml.length > 8)
					ComCoaSetIBCombo(sheetObj, arrXml[8], "rlane_cd", true, 0);
				if (arrXml.length > 9)
					ComCoaSetIBCombo(sheetObj, arrXml[9], "vsl_lane_tp_cd", true, 0);
				if (arrXml.length > 10)
					ComCoaSetIBCombo(sheetObj, arrXml[10], "dir_cd", true, 0);
				if (arrXml.length > 11)
					ComCoaSetIBCombo(sheetObj, arrXml[11], "ioc_cd", true, 0);
				if (arrXml.length > 12)
					ComXml2ComboItem(arrXml[12], formObj.f_hul_bnd_cd, "code", "name");
				document.form.sXml.value="";
				ComOpenWait(false);
				break;
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj, formObj, sAction)) return false;

				ComOpenWait(true);
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0', 'left');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0', 'left');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0', 'left');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0', 'left');

				/*--------------------------------------------*/
				formObj.f_cmd.value = SEARCHLIST11;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj));

				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "slan_cd", true, 0);
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "rlane_cd", true, 0);
				/*--------------------------------------------*/

				formObj.f_cmd.value = SEARCHLIST01;
				var sParam = coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date');
				sheetObj.DoSearch4Post("ESM_COA_0029GS.do", sParam);
				/*--------------------------------------------*/
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}

				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				
				//////////////////////////////
				// BSA 호출용
 				var sParamSheet = sheetObj.GetSaveString();  	
 				//alert(sParamSheet);
				//////////////////////////////
  				  				
				sheetObj.DoSave("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'), -1, false);				
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				

				//////////////////////////////
				// BSA 호출용
				formObj.f_cmd.value = MULTI06;
 				var sParam = coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date');
				if (sParamSheet != "") {
  					sParam += "&" + sParamSheet;
  				}
 				var sXml = sheetObj.GetSaveXml("ESM_COA_0029GS.do", sParam);
				//////////////////////////////			
				ComOpenWait(false);
 				
				break;

			case IBBATCH:      //수동 배치
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
								
				if (!ComShowCodeConfirm("COA10025")) {
					return false;
				}
				
				ComOpenWait(true);
				setFmToDate(); // 구간 Setting
				formObj.f_cmd.value = MULTI03;
				formObj.button_key.value = sAction;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 7200; //초 - 2시간
					backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
				}				
				break;

//			case IBCREATE:
//				if(!validateForm(sheetObj, formObj, sAction)) {
//					return false;
//				}
//
//				/////////////////////////////////////////////
//				// 암호를 입력후 일치하면 수행하도록한다.
//				popup = window.showModalDialog("ESM_COA_3001.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");
//
//				if(popup != "6475"){
//					return false;
//				}
//				
//				popup = "";
//				popup = window.showModalDialog("ESM_COA_0113.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");
//				formObj.f_type_cd.value = popup;
//				/////////////////////////////////////////////
//				
//				formObj.f_cmd.value = MULTI02;
//				// [COA10020] : 정보를 생성하시겠습니까?
//				if (ComShowConfirm(ComGetMsg("COA10020"))==false) return false;
//				ComOpenWait(true);
//				formObj.button_key.value = sAction;
//				var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'));
//				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//				
//				if (backendJobKey != null && backendJobKey.length > 0) {
//					ComSetObjValue(formObj.backendjob_key, backendJobKey);
//					sheetObj.RequestTimeOut = 7200; //초 - 2시간
//					backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
//				}		
//				break;
				

			case IBCREATE:
				if(!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}

				/////////////////////////////////////////////
				// 암호를 입력후 일치하면 수행하도록한다.
				popup = window.showModalDialog("ESM_COA_3001.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");

				if(popup != "6475"){
					return false;
				}
				
				popup = "";
				popup = window.showModalDialog("ESM_COA_0113.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");
				formObj.f_type_cd.value = popup;
				/////////////////////////////////////////////
				
				if(formObj.f_type_cd.value != "COA"){
					var tTrade = ComReplaceStr(document.getElementById("f_seltrade").Code,"All","");
					var tRlane = ComReplaceStr(document.getElementById("f_selrlane").Code,"All","");
					var tDir =   ComReplaceStr(document.getElementById("f_seldir").Code,"All","");
					var tVslCd = formObj.f_vsl_cd.value;
					var tSkdVoyNo = formObj.f_skd_voy_no.value;
					var tSkdDirCd = formObj.f_dir_cd.value;
					
					if((tVslCd == "" || tSkdVoyNo == "" || tSkdDirCd == "") && (tTrade == "" || tRlane == "" || tDir == "")){
						ComShowMessage('Please select "Trade" / "R/Lane" / "Direction" or input "VVD"');
						return false;
					}
				}
				
				formObj.f_cmd.value = MULTI02;
				// [COA10020] : 정보를 생성하시겠습니까?
				if (ComShowConfirm(ComGetMsg("COA10020"))==false) return false;
				ComOpenWait(true);
				formObj.button_key.value = sAction;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'));
				var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
				    
				switch(BatchStatus){
					case "4": // 작업 submit	
						sheetObj.RemoveAll();  
				        ComBtnDisable("btn_Creation");
						monitoringBatchJob();
						break;
					case "P"://해당 작업이 진행 중 
						ComShowCodeMessage("COA00003", "Target VVD Creation");
						ComOpenWait(false);  
						break;
					default: break;							
				}   
				break;
							
			case IBRESET:      //수동 배치 - TS/QTY 생성
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
								
				if (!ComShowCodeConfirm("COA10020")) {
					return false;
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI04;
				formObj.button_key.value = sAction;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 7200; //초 - 2시간
					backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
				}				
				break;

			case IBINSERT:                  // 입력
				//sheetObj.DataCopy();      //행 복사
				if(sheetObj.SelectRow>0 && sheetObj.CellValue(sheetObj.SelectRow, "cost_yrmon") != ""){
					sheetObj.DataInsert(-1);
					sheetObj.CellValue(sheetObj.SelectRow, "cost_yrmon") = sheetObj.CellValue(sheetObj.SelectRow-1, "cost_yrmon");
					sheetObj.CellValue(sheetObj.SelectRow, "cost_wk") = sheetObj.CellValue(sheetObj.SelectRow-1, "cost_wk");
					sheetObj.CellValue(sheetObj.SelectRow, "wky_tgt_flg") = "NO";
					sheetObj.CellValue(sheetObj.SelectRow, "mon_tgt_flg") = "NO";
					sheetObj.CellValue(sheetObj.SelectRow, "delt_flg") = "NO";
				}
				break;

			case IBSEARCH_ASYNC01:          // BSA Flag 가 선택 된 항차에 대해서 BSA 0 으로 만들어 준다.
				if(sheetObj.RowCount <1){
					ComShowMessage(sheetObj.MessageText("NoData"));
					return false;
				}

				if(!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}

				// [COA10032] : 선택된 항차의 BSA 값을 0으로 만드시겠습니까?
				if (ComShowConfirm(ComGetMsg("COA10036"))==false) return false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI05;
				sheetObj.DoSearch4Post("ESM_COA_0029GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date'));
				ComOpenWait(false);

				//--------------------------------------------------
				var err_cd  = sheetObj.EtcData("err_cd");
				var err_msg = sheetObj.EtcData("err_msg");

				// 30초 이상 수행될시 eventResponse에 EtcData 를 가져올 수 없어서
				// undefined 일 경우 화면에 메세지를 보여주지 않고 종료.
				if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined){
					return false;
				}

				if (err_cd == "00000") {
					ComShowMessage(ComGetMsg('COA10018', 'Apply BSA 0'));
				}
				sheetObj.EtcData("err_cd")  = "";
				sheetObj.EtcData("err_msg") = "";
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
					sheetObj.Down2Excel(0, false, false, true);
					break;
					case "DY":
					sheetObj.Down2Excel(-1, false, false, true);
					break;
					case "AN":
					sheetObj.SpeedDown2Excel(0, false, false);
					break;
					case "DN":
					sheetObj.SpeedDown2Excel(-1, false, false);
					break;
				}
				break;
				/*
			case IBSEARCH_ASYNC02:
				if(!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}

				var display       = "0,1";
				var f_cost_yr     = document.form.f_year.value   ;
				var f_cost_fm_mon = document.form.f_fm_mon.value;
				var f_cost_to_mon = document.form.f_to_mon.value;

				var getMthdArg    = "f_cost_yr="+f_cost_yr+"&f_cost_fm_mon="+f_cost_fm_mon
				ComOpenPopup("ESM_COA_0112.do?"+getMthdArg, 800, 500, "Month VVD I/F", display, false, false);
				break;
				 */
		}
	}

	/**
	 * 설  명 : 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - 조회 후 메시지
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		// TS/QTY 생성후 메시지를 뿌려준다.
		//		if(ibStatus == IBRESET){
		//			if(ErrMsg == ""){
		//				ComShowMessage(ComGetMsg("COA10006"));
		//			}
		//		}
	}

	/**
	 * 설  명 : 저장 함수를 이용하여 저장이 완료되고 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSaveEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - 저장 후 메시지
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg == ""){
			// [COA10006] : 작업이 완료되었습니다.
			ComShowMessage(ComGetMsg("COA10006"));
		}
	}

	/**
	 *  설  명 : 셀의 값이 바뀌었을 때 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj, Row, Col, Val)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {Long}	Row  - 해당 셀의 Row Index
	 * @param {Long}	Col  - 해당 셀의 Column Index
	 * @param {String}	Val  - 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, value){
		var formObj = document.form;
		var param;
		if(sheetObj.ColSaveName(Col) == "trd_cd"){
			param = param+"&f_cmd="+SEARCHLIST11;
			param = param+"&f_seltrade="+sheetObj.CellValue(Row, Col);

			var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", param);

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, 0, Row);
			if (arrXml.length > 1)
				ComCoaSetIBCombo(sheetObj, arrXml[1], "slan_cd", true, 0, Row);
			if (arrXml.length > 2)
				ComCoaSetIBCombo(sheetObj, arrXml[2], "rlane_cd", true, 0, Row);

		}
	}

	/**
	 *  설  명 : 배치용 From~To Date 계산 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setFmToDate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setFmToDate() {
		var formObj = document.form;
		var period = div_period.innerHTML;

		with(formObj) {
			period = div_period.innerHTML.replace(/-|\(|\)/g, '').split('~');
			fm_date.value = ComTrim(period[0]);
			to_date.value = ComTrim(period[1]);
		}
	}

	 /**
     * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
     */
    function f_seltrade_OnChange(obj) {
    	if (loadingMode == true) return;
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(obj.Text != ""){
        	formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "code");
			formObj.f_selrlane.Index = 0;

        }
    }

	/**
	 * 설  명 : VVD Check List PopUp 화면을 오픈한다.<br>
	 * <b>Example : </b>
	 * <pre>
	 *    popVvdCheck()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function popVvdCheck(){
		var formObj = document.form;
		var param = "?" + coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date');
		ComOpenWindow2('ESM_COA_0142.do'+param, '', 'width=900, height=500, menubar=0, status=1, scrollbars=0, resizable=0');
	}


	/**
	 *  설  명 :  month, week가 변경되었을때 Period를 변경한다. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setPeriod(obj)
	 * </pre>
	 * @param (object) obj - Document Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setPeriod(obj){
    	 ComCoaSetPeriod(obj);
	}


	///////////////////////////////////////////////////////////////

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj, document.form, IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
   	 * @author 최성민
   	 * @version 2011.02.07
     */
	function validateForm(sheetObj, formObj, sAction){
		switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	  		 break;

	 		case IBSAVE: //Save
				if (!sheetObj.IsDataModified) {
					ComShowCodeMessage("COA00007");
					return false;
				}
		  		 break;

	 		case IBDOWNEXCEL: //엑셀다운로드
	  		 break;

	 		case IBBATCH: // batch
	 			if(!formObj.f_chkprd[0].checked){
					// [COM12114] : W/M 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}

	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	 			
				if((formObj.f_to_wk.value - formObj.f_fm_wk.value) > 15){
					// [COA10003] : BSA 는(은) 16주 만 처리할수 있습니다.
					ComShowCodeMessage("COA10003", "BSA & VVD Creation", "15 Weeks");
					formObj.f_to_wk.focus();
					return false;
				}
				
	  		 break;

	 		case IBCREATE: // create
	 			if(!formObj.f_chkprd[0].checked){
					// [COM12114] : W/M 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}

	 			if(!chkValidSearch()) {
	 				return false;
	 			}

				if((formObj.f_to_wk.value - formObj.f_fm_wk.value) > 53){
					// [COA10003] : BSA 는(은) 16주 만 처리할수 있습니다.
					ComShowCodeMessage("COA10003", "Target VVD Creation", "53 Weeks");
					formObj.f_to_wk.focus();
					return false;
				}
				
	  		 break;

	 		case IBRESET: // Create T/S Q`ty
	 			if(!formObj.f_chkprd[0].checked){
					// [COM12114] : W/M 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}

	 			if(!chkValidSearch()) {
	 				return false;
	 			}

					if((formObj.f_to_wk.value - formObj.f_fm_wk.value) > 16){
						// [COA10003] : BSA 는(은) 16주 만 처리할수 있습니다.
						ComShowCodeMessage("COA10003", "Create T/S Qty", "16 Weeks");
						formObj.f_to_wk.focus();
						return false;
					}
	  		 break;

	 		case IBSEARCH_ASYNC01: // Apply BSA 0
	 			if(!formObj.f_chkprd[0].checked){
					// [COM12114] : W/M 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}

	 			if(!chkValidSearch()) {
	 				return false;
	 			}

					if((formObj.f_to_wk.value - formObj.f_fm_wk.value) > 16){
						// [COA10003] : BSA 는(은) 16주 만 처리할수 있습니다.
						ComShowCodeMessage("COA10003", "Apply BSA 0", "16 Weeks");
						formObj.f_to_wk.focus();
						return false;
					}
	  		 break;

	 		case IBSEARCH_ASYNC02: // Month VVD I/F
				if(!formObj.f_chkprd[1].checked) {
					// [COM12114] : From Month 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}

	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	  		 break;
		}
		return true;
	}

    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     * @returns 없음
   	 * @author 최성민
   	 * @version 2011.02.07
     */
	function chkValidSearch(){
		var formObj = document.form;
		var checkFlg = true;

 		with(formObj){
 			if (f_year.value == "") {
 				ComShowCodeMessage("COM12114", "Year");
 			    f_year.focus();
 			    checkFlg = false;
 			} else if(!ComIsDate(f_year, "yyyy")){
  		    	ComShowCodeMessage("COA10009", "Year", "YYYY");
 			    f_year.focus();
 			    checkFlg = false;
  		    } else if (f_chkprd[0].checked){
     			if (f_fm_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     			    f_fm_wk.focus();
     			    checkFlg = false;
     			} else if (f_to_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_fm_wk)){
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('COA10009', 'Week', 'WW');
     				f_fm_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_to_wk)) {
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('COA10009', 'Week', 'WW');
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if (f_fm_wk.value > f_to_wk.value) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("COA10011", "Week", "From", "To");
     			    f_to_wk.focus();
     			    checkFlg = false;
     			}
 			} else if (f_chkprd[1].checked){
     			if (f_fm_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_fm_mon.focus();
     			    checkFlg = false;
     			} else if (f_to_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_to_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_fm_mon)){
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('COA10009', 'Month', 'MM');
     				f_fm_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_to_mon)) {
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('COA10009', 'Month', 'MM');
     				f_to_mon.focus();
     			    checkFlg = false;
     			} else if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("COA10011", "Month", "From", "To");
     			    f_to_mon.focus();
     			    checkFlg = false;
     			}
 			}
 		}
 		return checkFlg;
     }
	
    
    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobStatus();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2011.06.01
     */     
    function getBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	ComOpenWait(true);
    	formObj.f_cmd.value = SEARCH11;
    	var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj));
    	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
    	
    	if (jobState == "3") {
    		getBackEndJobSearch();
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "4") {
    		ComShowCodeMessage("COA00001");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "5") {
    		ComShowCodeMessage("COA00002");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	}
    }   
    
    /**
     * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobSearch();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2011.06.01
     */       
    function getBackEndJobSearch() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH12;    	
    	var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj));
    	var err_cd = ComGetEtcData(sXml, "err_cd");
    	var err_msg = ComGetEtcData(sXml, "err_msg");
    	var rtn_vsl_cd = ComGetEtcData(sXml, "vsl_cd"); 
		var button_id = "";
		
		if(formObj.button_key.value == IBBATCH) {
			button_id = "BATCH";
		} else if (formObj.button_key.value == IBCREATE){
			button_id = "CREATE";
		} else {
			button_id = "TS QTY";
		}
		
		ComOpenWait(false);
		if (button_id == "CREATE"){
			// 30초 이상 수행될시 eventResponse에 EtcData 를 가져올 수 없어서
			// undefined 일 경우 화면에 메세지를 보여주지 않고 종료.
			if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined){
				return ;
			}

			if(err_cd == "00000"){
				if(rtn_vsl_cd == "" || rtn_vsl_cd == null || rtn_vsl_cd =="null" || rtn_vsl_cd == undefined || rtn_vsl_cd == "undefined"){
					// [COA10006] : 작업이 완료되었습니다.
					ComShowMessage(ComGetMsg("COA10006"));
				}else{
					// [COA10022] : 저장된 Vessel정보에 [vessel 정보] 데이터가 있습니다. 확인하여 주시기 바랍니다.
					ComShowMessage(ComGetMsg("COA10022", rtn_vsl_cd));
				}

				// Weekly Creation시에만  보여준다.
				if(formObj.f_type_cd.value == "COA"){
					popVvdCheck();
				}
			}
			sheetObj.EtcData("err_cd")  = "";
			sheetObj.EtcData("err_msg") = "";
		} else {
			if (err_cd == "00000") {
				ComShowMessage(ComGetMsg('COA10018', button_id));
			} else if (err_cd == "00028") {
				ComShowMessage("ERROR(COA00028): " + err_msg);
			} else{
				ComShowMessage("ERROR(COA00028): " + err_msg);
			}	
		}
	}
    
    /**
     * Month VVD I/F 팝업을 호출한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      popMonthVVDIF();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2011.06.01
     */       
    function popMonthVVDIF() {    	
		var display       = "0,1";
		var f_cost_yr     = document.form.f_year.value   ;
		var f_cost_fm_mon = document.form.f_fm_mon.value;
		var f_cost_to_mon = document.form.f_to_mon.value;

		var getMthdArg    = "f_cost_yr="+f_cost_yr+"&f_cost_fm_mon="+f_cost_fm_mon
		ComOpenPopup("ESM_COA_0112.do?"+getMthdArg, 800, 500, "Month VVD I/F", display, false, false);		
	}
    

    /**
     * batch job monitoring <br>     
     * 상태코드 <br>
     * status	1	RUNNING <br>
     * status	3	STARTING <br>
     * status	4	SUCCESS <br>
     * status	5	FAILURE <br>
     * status	6	TERMINATED <br>
     * status	7	ON_ICE <br>
     * status	8	INACTIVE <br>
     * status	9	ACTIVATED <br>
     * status	10	RESTART <br>
     * status	11	ON_HOLD <br>
     * status	12	QUE_WAIT <br>
     * 
     * @return 없음
     * @author 최성민
     * @version 2014.04.05
     */ 
    function monitoringBatchJob(){
    	//개발시에는 모니터링을 하지 않는다.
    	if(location.hostname == "localhost"){
    		return;
    	}
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH01;
    	var sXml = sheetObj.GetSearchXml("ESM_COA_0029GS.do", coaFormQueryString(formObj));
    	var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
    	if( BatchStatus == "P" ){
    		setTimeout(monitoringBatchJob,5000);
    	}else{
    		ComBtnEnable("btn_Creation");
    		ComShowCodeMessage('COA10018',"Target VVD Creation"); 
    		ComOpenWait(false);
    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	}
    }
 
