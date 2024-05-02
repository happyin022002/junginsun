/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0225.js
 *@FileTitle : bookringreport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.03
 *@LastModifier : Jung sun yong
 *@LastVersion : 1.0
 * 1.0 Creation
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.11.25 금병주 [CHM-201114704-01] SI 자동화 컬럼 추가분 ALPS에 표시요청
 * 2011.12.19 정선용 [SRM-201122341] SI Automation Receiving Lsit 기능 & DPCS 기능 보완 요청
 * 2012.01.02 정선용 [CHM-201115195] SI Automation Receiving Lsit 기능 & DPCS 기능 보완 요청
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */
/**
 * @extends 
 * @class esm_bkg_0225 : esm_bkg_0225 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function esm_bkg_0225() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.setComboObject 		= setComboObject;
	}
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var prefix = "";
	var comboCnt = 0;
 	var comboObjects = new Array();
 	var arrWindow = new Array(null, null);
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
//		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_Retrieve":

						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

					break;
				case "btn_New":
					sheetObject1.RemoveAll();
					formObject.reset();
					break;
				case "btn_Delete":

						doActionIBSheet(sheetObjects[0], document.form, IBDELETE);

					break;
				
				case "btn_Save":

						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

					break;	
				/*case "btn_Bkg_Change":
					if (tabObjects[0].SelectedIndex == 1){
						doActionIBSheet(sheetObjects[1], document.form, MODIFY);
					}
					break;*/
				case "btn_Eml_Ctnt_View":
					if (CheckRowGrid(sheetObjects[0],prefix + "Sel") == false) return;
					
					var sRow = sheetObjects[0].FindCheckedRow(prefix + "Sel");
					var Row = sRow.split("|");
					goEmlCtntPop(sheetObjects[0],Row[0]);
					break;	
					
				case "btn_InputRemark":
					remarkPopup(sheetObjects[0], 'form', '');
					break;
//				case "btn_GotoBKGMatch":
//					remarkPopup(sheetObjects[0], 'new', '');
//					break;
				case "btn_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
					break;
					
				case "btn_si_info_Save":
					doActionIBSheet(sheetObjects[0], document.form, MODIFY);
				break;						
					
				case "btn_DownExcel": 
		        	ComOpenWait(true); 
		        	sheetObjects[0].Down2Excel(-1);
		        	ComOpenWait(false); 
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
 
		  //MultiCombo초기화 
 	    for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
		document.form.from_dt.value = getCalculatedDate(0, 0, -1, "-");
		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
 
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		ComBtnDisable("btn_si_info_Save");
		
	}
	
	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
				initComboEditable(comboObj, comboId)
 	}
 	//콤보 멀티 셀렉트 및 수정 여부 초기 설정
	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	
//	 	 		if(comboId == "pfm_by_queue_cd" ){
//	 	 			DropHeight = 150;
//		 	 		MultiSelect = false;
//		 	 		UseEdit = false;	 	 				
//	 	 			BackColor = "#ccfffd";	 	 		
//	 	 		}else if (comboId == "doc_part"){
//	 	 			DropHeight = 150;
//		 	 		MultiSelect = true;
//		 	 		UseEdit = false;
//	 	 		}else{ 
//	 	 			DropHeight = 150;
//		 	 		MultiSelect = false;
//		 	 		UseEdit = false;	 	 				 	 			
//	 	 		}
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
		
        ComSetObjValue(formObject.from_dt,ComGetNowInfo());
 		ComSetObjValue(formObject.to_dt,ComGetNowInfo());
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
    
//	function sheet1_OnLoadFinish(sheetObj) {
//        sheetObj.WaitImageVisible = false;
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//	    sheetObj.WaitImageVisible = true; 
//	}
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
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 9, 100);
//					prefix = "sheet1_";
					prefix = "";
					//2011.11.25 decoding 추가 kbj
					var HeadTitle1 = "|Sel|Seq.|Attach|SiTxt|His|SI No.|STS|BKG No.|Valid\nBKG|Queue Status|URG|SR Kind|Split|Split|Decoding|Decoding|Decoding|Mail Subject (After Transfer)|Mail Subject (After Transfer)|Mail Subject (After Transfer)" +
							"|Before Edit Customer's Original Mail|Before Edit Customer's Original Mail|Before Edit Customer's Original Mail|Before Edit Customer's Original Mail|Before Edit Customer's Original Mail|Remark" +
							"|View Mail\nContents|atch_file_path_ctnt|fax_log_ref_no|STS|bkg_no_mtch_sts_cd|sr_knd_cd|sr_fax_rslt_cd|sr_mtch_sts_cd|queue_sts_cd|org_bkg_no|split|||||||||";
	
					//2011.11.25 phase,methd,status 추가 kbj
					var HeadTitle2 = "|Sel|Seq.|Attach|SiTxt|His|SI No.|STS|BKG No.|Valid\nBKG|Queue Status|URG|SR Kind|Cnt|Ttl|Phase|Method|Status|Email Trans Time|Subject with Tag\n(by HJS)|Office" +
							"|Original Subject|Sender|Customer Addr|Sent Time|GMT Time|Remark" +
							"|View Mail\nContents|atch_file_path_ctnt|fax_log_ref_no|STS|bkg_no_mtch_sts_cd|sr_knd_cd|sr_fax_rslt_cd|sr_mtch_sts_cd|queue_sts_cd|org_bkg_no|split|||||||||";
					
					var headCount = ComCountHeadTitle(HeadTitle2);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
					InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, true, prefix + "Sel");
					InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtImage, 40, daCenter, true, prefix + "atch_file_knt", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtImage, 35,  daCenter, true, prefix+"si_txt",        false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtImage, 40, daCenter, true, prefix + "bkg_sr_proc_his", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "sr_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, 	daCenter, true, prefix + "sr_fax_rslt_nm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daLeft, true, prefix + "bkg_no", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "bkg_no_mtch_sts_nm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 100, daLeft, true, prefix + "sr_crnt_sts_nm", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtCombo, 100, daLeft, true, prefix + "sr_urg_cd", false, "", dfNone, 0, true, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtCombo, 100, daLeft, true, prefix + "sr_amd_tp_cd", false, "", dfNone, 0, true, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix + "bl_split_no", false, "", dfNone, 0, true, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix + "bl_split_ttl_knt", false, "", dfNone, 0, true, true); //add 2011.08.09
					
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "sol_aply_phs_no", false, "", dfNone, 0, true, true); //add 2011.11.25
					InitDataProperty(0, cnt++, dtData, 60, daLeft, true, prefix + "si_rqst_cng_bse_cd", false, "", dfNone, 0, true, true); //add 2011.11.25
					InitDataProperty(0, cnt++, dtData, 60, daLeft, true, prefix + "si_doc_read_scs_flg", false, "", dfNone, 0, true, true); //add 2011.11.25
					
					InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, prefix + "sr_trns_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 120, daLeft, false, prefix + "eml_subj_ctnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "rcv_ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 110, daLeft, false, prefix + "eml_org_subj_ctnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "mtch_usr_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 130, daLeft, false, prefix + "fnt_ofc_eml", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, prefix + "rcv_dt", false, "", dfUserFormat2, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, prefix + "gmt_rcv_dt", false, "", dfUserFormat2, 0, false, true);  //add 2011.08.09
					InitDataProperty(0, cnt++, dtImageText, 150, daLeft, true, prefix + "rcv_rmk", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix + "view_mail", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "atch_file_path_ctnt");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "fax_log_ref_no");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "sr_fax_rsld_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_mtch_sts_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "sr_knd_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "sr_fax_rslt_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "sr_mtch_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "sr_crnt_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "org_bkg_no");
					InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, prefix + "split_sts_cd", false, "", dfNone, 0, false, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtHidden, 10, daLeft, true, prefix + "max_seq", false, "", dfNone, 0, false, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtHidden, 10, daLeft, true, prefix + "sr_amd_seq", false, "", dfNone, 0, false, true); //add 2011.08.09
					InitDataProperty(0, cnt++, dtHidden, 10, daLeft, true, prefix + "xter_sndr_id", false, "", dfNone, 0, false, true); //add 2011.08.09
					
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_bkg_no");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_sr_amd_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_sr_urg_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_split_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_bl_split_no");
					InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_bl_split_ttl_knt");
					
					ImageList(0)= "/hanjin/img/ico_attach.gif";
					ImageList(1) = "/hanjin/img/btns_search.gif";
					ImageList(2) = "/hanjin/img/btn_file.gif"; // si_txt
					DataLinkMouse(prefix + "atch_file_knt") = true;
					DataLinkMouse(prefix + "bkg_sr_proc_his") = true;
					ToolTipOption = "balloon:true;width:1000;icon:1;title:File Name";
					InitUserFormat2(0, prefix + "rcv_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, prefix + "gmt_rcv_dt", "####-##-## ##:##", "-|:");
					InitDataImage(0, prefix + "rcv_rmk", daRight);
					FrozenCols = 9;
				}
				break;	
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case SEARCH01: //open
//				if (!validateForm(sheetObj, formObj, sAction))
//					return;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0225GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				/*S/R Kind*/
				ComXml2ComboItem(arrXml[0], formObj.sr_knd_combo_cd, "val", "name");
				/*I/F Status*/
				ComXml2ComboItem(arrXml[1], formObj.sr_if_status_cd, "val", "name");
				/*Urgency*/
				ComXml2ComboItem(arrXml[2], formObj.sr_urgency_cd, "val", "name");
				/*valid Bkg*/
				ComXml2ComboItem(arrXml[3], formObj.sr_bkg_sts_cd, "val", "desc");
				formObj.sr_knd_combo_cd.Code = 'L';
				formObj.sr_if_status_cd.Code = ' ';
				formObj.sr_bkg_sts_cd.Code = ' ';
				formObj.sr_urgency_cd.Code = ' ';
				
//				var arrXml2 = sXml.split("|$$|");
				var sr_amd_tp_cd_ib_combo = ComReplaceStr(arrXml[0], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
				ComSetIBCombo(sheetObj,  sr_amd_tp_cd_ib_combo, "sr_amd_tp_cd" ,false,"","","","cd");
				
				var sr_urgency_cd_ib_combo = ComReplaceStr(arrXml[2], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
				ComSetIBCombo(sheetObj,  sr_urgency_cd_ib_combo, "sr_urg_cd" ,false,"","","","cd");
							
//				formObj.dpcs_wrk_prt_cd.value = ComGetEtcData(searchXml,"usrRptCd");
//				formObj.dpcs_wrk_svr_cd.value = ComGetEtcData(searchXml,"usrSvrCd");	
				
				break;	
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction))
					return;
//				if (tabObjects[0].SelectedIndex == 0){
//					formObj.f_cmd.value = SEARCHLIST01;
//				}else if (tabObjects[0].SelectedIndex == 1){
					formObj.f_cmd.value = SEARCHLIST02;
//				}	
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);  //대기이미지 표시
				sheetObj.RemoveAll();
				sheetObj.Redraw = false;
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0225GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(searchXml);
//				if (ComGetEtcData(searchXml,"IS_EML_RCV_FAIL_FLG") == "Y"){
//					tabObjects[0].TabBackColor(1) = "Red";
//				}else{
//					tabObjects[0].TabBackColor(1) = "206,220,246";
//				}
				sheetObj.Redraw = true;
				ComOpenWait(false); //대기이미지 숨김
				break;
			case IBDELETE: // 삭제
				var ISSel = false;
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, 1) == '1') {
						sheetObj.CellValue(i, 0) = 'D';
						ISSel = true;
						break;
					}
				}
				
				if (chkDeleteRow(sheetObj) == false) return;
				if (ISSel) {
					if (!ComShowCodeConfirm("BKG00535")) {//Are you sure to delete?
						return;
					}
				} else {
					ComShowCodeMessage("BKG00567");//Please Select a Row
					return;
				}
//				if (tabObjects[0].SelectedIndex == 0){
//					formObj.f_cmd.value = MULTI;
//				}else if (tabObjects[0].SelectedIndex == 1){
					formObj.f_cmd.value = MULTI02;
//				}	
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				sheetObj.DoSave("ESM_BKG_0225GS.do", sParam);
				break;
			case IBSAVE: // Remark Save
//				if (tabObjects[0].SelectedIndex == 0){
//					formObj.f_cmd.value = MULTI;
//				}else if (tabObjects[0].SelectedIndex == 1){
					formObj.f_cmd.value = MULTI02;
//				}	
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				sheetObj.DoSave("ESM_BKG_0225GS.do", sParam);
				break;
			/*	
			case MODIFY: 
				if (tabObjects[0].SelectedIndex == 1){
					formObj.f_cmd.value = MULTI03;
				}	
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				sheetObj.DoSave("ESM_BKG_0225GS.do", sParam);
				break;*/
				
			case MODIFY: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
//				if (tabObjects[0].SelectedIndex == 1){
					formObj.f_cmd.value = MULTI03;
//				}	
				var SaveStr = sheetObj.GetSaveString(false);
				
				var sParam = FormQueryString(formObj) + "&" + SaveStr;
//				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0225GS.do?f_cmd="+MULTI03, SaveStr);
				sheetObj.LoadSaveXml(searchXml);
				if(sheetObj.EtcData("TRANS_RESULT_KEY") == 'S') {
					retriveFnc();
				};
				break;				
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: //조회
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
				}
				break;
			case MODIFY: //수정
				var sRow = sheetObj.FindStatusRow("U");
				var arrRow = sRow.split(";");
				for (idx = 0; idx < arrRow.length - 1; idx++) {
					var row = arrRow[idx];
					if(sheetObj.CellValue(row, "split_sts_cd") == 'S') {
						if(sheetObj.CellValue(row, "bl_split_no") == '' || sheetObj.CellValue(row, "bl_split_ttl_knt") == '') {
							ComBtnDisable("btn_si_info_Save");
							ComShowCodeMessage("BKG00884"); //"Booking number split is not available"
							return;	
						}
						
					} else {
						if(ComIsEmpty(sheetObj.CellValue(row, "bl_split_no")) == false || ComIsEmpty(sheetObj.CellValue(row, "bl_split_ttl_knt")) == false) {
							ComBtnDisable("btn_si_info_Save");
							ComShowCodeMessage("BKG00884"); //"Booking number split is not available"
							return;	
						}
					}
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
			for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				CellImage(i,SaveNameCol(prefix+"bkg_sr_proc_his")) = 1;
				if (CellValue(i,SaveNameCol(prefix+"atch_file_knt")) == "0"){
					CellImage(i, SaveNameCol(prefix+"atch_file_knt")) = -1;
				}else{
					CellImage(i,SaveNameCol(prefix+"atch_file_knt")) = 0;
					CellImage(i,SaveNameCol(prefix+"si_txt")) = 2;
				}
				
				if (CellValue(i, SaveNameCol(prefix+"bkg_no_mtch_sts_cd")) == "F"){
					CellFontColor(i, SaveNameCol(prefix+"bkg_no_mtch_sts_nm")) = RgbColor(255, 0, 0);
					//CellEditable(i,prefix+"bkg_no") = true;
				}else{
					//CellEditable(i,prefix+"bkg_no") = false;
				}
				if (CellValue(i, SaveNameCol(prefix+"sr_fax_rslt_cd")) != "10"){
					CellFontColor(i, SaveNameCol(prefix+"sr_fax_rslt_nm")) = RgbColor(255, 0, 0);
				}
				
				comBkgIndicateLink(sheetObj,prefix+"eml_subj_ctnt");
			}
		}
		sheetObj.WaitImageVisible = false;
	}	
 
	
	function sheet1_OnClick(sheetObj, Row, Col, value) {
		with (sheetObj) {
			if (ColSaveName(Col) == prefix+"eml_subj_ctnt"
					|| ColSaveName(Col) == prefix+"atch_file_knt") {
				goEmlCtntPop(sheetObj,Row);
			}
			if (ColSaveName(Col) == prefix+"si_txt" ) {
				goSiTxtPop(sheetObj,Row);
			}
			
			if (ColSaveName(Col) == "rcv_rmk") {
				ComShowMemoPad(sheetObj, null, null, null, null, null, 1000);
			}
			if (ColSaveName(Col) == "bkg_sr_proc_his") {
				goSrProcHisPop(sheetObj,Row);
			}
			
		}
	}
	function goSrProcHisPop(sheetObj,Row){
		
		if (sheetObj.CellValue(Row,prefix+"sr_no") == "") return;
		var sParam = "";
		var param   = new Array("sr_no","fax_log_ref_no");
		sParam = getGetSheetRowParam(sheetObj, Row ,prefix, param);
		ComOpenWindowCenter("/hanjin/ESM_BKG_0451.do" + sParam, "ESM_BKG_0451", 750, 380, false);
	}	
	function goEmlCtntPop(sheetObj,Row){
		
		if (sheetObj.CellValue(Row,prefix+"eml_subj_ctnt") == "") return;
		var sParam = "";
		var param   = new Array("sr_knd_cd","sr_no","fax_log_ref_no","bkg_no");
		sParam = getGetSheetRowParam(sheetObj, Row ,prefix, param);
		ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447", 750, 480, false);
	}
	function goSiTxtPop(sheetObj,Row){
		
		if (sheetObj.CellValue(Row,prefix+"eml_subj_ctnt") == "") return;
		var sParam = "";
		var param   = new Array("sr_knd_cd","sr_no","fax_log_ref_no","bkg_no");

		sParam = getGetSheetRowParam(sheetObj, Row ,prefix, param);
		ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam+"&conv_pdf_flg=Y", "ESM_BKG_0447", 750, 480, false);
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
	
	function chkDeleteRow(sheetObj) {
		var formObj = document.form;
		//var Row = sheetObj.SelectRow;
		var sRow = sheetObj.FindCheckedRow(prefix + "Sel");
		
		if (sRow == "") {
			return;
		}
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		Row = arrRow[0]
		       
		var srNo = sheetObj.CellValue(Row, prefix + "sr_no");
		var mtchUsrId = sheetObj.CellValue(Row, prefix + "sr_trns_usr_id");
		var mtchUsrNm = sheetObj.CellValue(Row, prefix + "sr_trns_usr_nm");
		var srMtchStsCd = sheetObj.CellValue(Row, prefix + "sr_mtch_sts_cd");
		
		/*'Waiting'*/
		if (srMtchStsCd == "W"){
			return true;
		}
		if (srMtchStsCd != "P"){
			ComShowCodeMessage("BKG08038", mtchUsrNm);
			return false;
		}
		/*'Processing'*/
		if (srMtchStsCd == "P") {
			ComShowCodeMessage("BKG08119"); //Failed to delete. Already transferred to DC.
			return false;
		}
		/*if (srMtchStsCd == "P" && formObj.usr_id.value != mtchUsrId) {
			if (ComGetObjValue(formObj.usr_grp_cd) == "U"){
				return true;
			}
			ComShowCodeMessage("BKG08038", mtchUsrNm);//","This queue can be deleted by 'User Name'++>" + ls_user_name + "!!")
			return false;
		}	*/
		return true;
	}
	
	function remarkPopup(sheetObj, type, param) {
		var formObj = document.form;
		var Row = sheetObj.SelectRow;
		var srNo = sheetObj.CellValue(Row, prefix + "sr_no");
		var sndrFaxNo = sheetObj.CellValue(Row, prefix + "sndr_fax_no_ctnt");
		var bkgSrKndCd = sheetObj.CellValue(Row, prefix + "sr_knd_cd");
		var totPgKnt = sheetObj.CellValue(Row, prefix + "ttl_pg_knt");
		var transferer = sheetObj.CellValue(Row, prefix + "rcv_ofc_cd") + "/" + sheetObj.CellValue(Row, prefix + "rcm_nm");
		var rcvRmk = sheetObj.CellValue(Row, prefix + "rcv_rmk");
		var mtchUsrId = sheetObj.CellValue(Row, prefix + "sr_trns_usr_id");
		var mtchUsrNm = sheetObj.CellValue(Row, prefix + "sr_trns_usr_nm");
		var srMtchStsCd = sheetObj.CellValue(Row, prefix + "sr_mtch_sts_cd");
		var downloadLocation = sheetObj.CellValue(Row, prefix + "img_file_real_path");
		var downloadFileName = sheetObj.CellValue(Row, prefix + "img_file_nm");
		var imgFilePathCtnt = sheetObj.CellValue(Row, prefix+"img_file_path_ctnt");
		var rcvOfcCd = sheetObj.CellValue(Row, prefix+"rcv_ofc_cd");
		var faxLogRefNo = sheetObj.CellValue(Row, prefix+"fax_log_ref_no");
		
		if (type == 'tif') {
			var url = "/hanjin/FileDownload?downloadLocation=" + downloadLocation + "&downloadFileName=" + downloadFileName;
			var host = location.host;
			if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
				url = "http://alpsdev.smlines.com:9300/"+url;
			}
			//나중 삭제 ------
//			url = "/hanjin/FileDownload?downloadLocation=D://WorkSpace//NIS2010//WEB_MAIN//dpcs//@DUS105842700ANR107140001.tif&downloadFileName=/@DUS105842700ANR107140001.tif";
//에러남			url = "/hanjin/FileDownload?downloadLocation=//@DUS105842700ANR107140001.tif&downloadFileName=/@DUS105842700ANR107140001.tif";
			
			//--------------
			hiddenFrame.location.href = url;
		} else if (type == 'grid') {
			var param = "?sr_no=" + srNo + "&rcv_rmk=" + rcvRmk;
			ComOpenWindow2("/hanjin/ESM_BKG_0988.do" + param, "open0988", "statebar=no,width=600,height=220,left=200,top=0");
		} else if (type == 'form') {
			if (sheetObj.RowCount > 0) {
				var param = "?sr_no=" + srNo + "&rcv_rmk=" + rcvRmk;
				ComOpenWindow2("/hanjin/ESM_BKG_0988.do" + param, "open0988", "statebar=no,width=600,height=220,left=200,top=0");
			}
		} else if (type == 'new') {
			if (srMtchStsCd == "T") {
				ComShowCodeMessage("BKG08037");//SR already transferred to Doc Center
				return;
			} else {
				if (sheetObj.RowCount > 0) {
					if (srMtchStsCd == "P" && formObj.usr_id.value != mtchUsrId) {
						ComShowCodeMessage("BKG08038", mtchUsrNm);//Processing by {?msg1}
						return;
					}
					var param2 = "?sr_no=" + srNo + "&bkg_sr_knd_cd=" + bkgSrKndCd + "&fax_log_ref_no=" + faxLogRefNo;
					
					ComOpenWindowCenter("/hanjin/ESM_BKG_0489.do" + param2, "ESM_BKG_0489", 1000, 640, true);
					//ComOpenWindow2("/hanjin/ESM_BKG_0489.do" + param2,"ESM_BKG_0489", "statebar=no,width=1030,height=520,left=200,top=0");
				}
			}
		}
	}
	
	
	
	
	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
//		if( sheetObj.ColSaveName(Col) == "bl_split_no" ) {
//			if(ComIsEmpty(sheetObj.CellValue(Row, "bl_split_no")) == false &&
//			   ComIsNumber(sheetObj.CellValue(Row, "bl_split_no")) ==false	){
//				ComBtnDisable("btn_si_info_Save");
//				ComShowCodeMessage("BKG00884");
//				return;
//			}
//		}
//		if( sheetObj.ColSaveName(Col) == "bl_split_ttl_knt" ) {
//			if(ComIsEmpty(sheetObj.CellValue(Row, "bl_split_ttl_knt")) == false &&
//			   ComIsNumber(sheetObj.CellValue(Row, "bl_split_ttl_knt")) ==false	){
//				ComBtnDisable("btn_si_info_Save");
//				ComShowCodeMessage("BKG00884");
//				return;
//			}
//		}		
//		
		if(ComIsEmpty(sheetObj.CellValue(Row, "bl_split_no")) == false  &&
				   ComIsEmpty(sheetObj.CellValue(Row, "bl_split_ttl_knt")) == false  &&
				   ComIsNumber(sheetObj.CellValue(Row, "bl_split_no")) ==true &&
				   ComIsNumber(sheetObj.CellValue(Row, "bl_split_ttl_knt")) ==true ) {
		   sheetObj.CellValue2(Row, "split_sts_cd") = "S";	   
	   } else {
		   sheetObj.CellValue2(Row, "split_sts_cd") = "";	   
	   }
 
		if(sheetObj.ColSaveName(Col) == "bkg_no" || 
		   sheetObj.ColSaveName(Col) == "sr_urg_cd" ||
		   sheetObj.ColSaveName(Col) == "sr_amd_tp_cd" ||
		   sheetObj.ColSaveName(Col) == "bl_split_no" ||
		   sheetObj.ColSaveName(Col) == "bl_split_ttl_knt" 
		   )
		{
			ComBtnEnable("btn_si_info_Save");	
		}
	}
	
	function retriveFnc() {
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var chkBkgNo = sheetObjects[0].CellValue(row, "bkg_no");
    	var phs_no = sheetObjects[0].CellValue(row, "sol_aply_phs_no");
    	var bkg_no_mtch_sts_cd = sheetObjects[0].CellValue(row, "bkg_no_mtch_sts_cd");
    	var sr_crnt_sts_cd = sheetObjects[0].CellValue(row, "sr_crnt_sts_cd");

    	var max_seq = sheetObjects[0].CellValue(row, "max_seq");
    	
    	if(bkg_no_mtch_sts_cd=='F'){
    		ComShowCodeMessage("BKG08219");//"The booking No is not avilable in ALPS.  Please check and correct."
    		return;
    	}
    	if(sr_crnt_sts_cd =='XX'){
    		ComShowCodeMessage("BKG08220");//"This SI was stopped due to receiving next SI. Please ignore this and process next one."
    		return;
    	}
    	
    	if(phs_no != '2') {
    		if ( chkBkgNo != "" ) {
    			ComBkgCall0079(chkBkgNo); // bkg main 화면 호출
    		}
    	} else if(phs_no == '2' && max_seq > 0) {                          // e-bkg 화면 호출 
    		
    		
    		var param = "?rqst_no="
    			+ encodeURIComponent(sheetObj.CellValue(row, "sr_no"))
    			+ "&rqst_seq="
    			+ encodeURIComponent(sheetObj.CellValue(row, "max_seq"))
    			+ "&sender_id="
    			+ encodeURIComponent(sheetObj.CellValue(row, "xter_sndr_id"))
    			+ "&bkg_no="
    			+ encodeURIComponent(sheetObj.CellValue(row, "bkg_no")) 
    			+ "&fax_log_ref_no="
    			+ encodeURIComponent(sheetObj.CellValue(row, "fax_log_ref_no"))
//    			+ "&conv_atch_file_path_ctnt="
//    			+ encodeURIComponent(sheetObj.CellValue(row, "conv_atch_file_path_ctnt"))
//    			+ "&conv_eml_atch_file_nm="
//    			+ encodeURIComponent(sheetObj.CellValue(row, "conv_eml_atch_file_nm"))			
    			+ "&sr_knd_cd="
    			+ encodeURIComponent(sheetObj.CellValue(row, "sr_knd_cd"))			
    			
    			;
		    	var date = new Date();
		    	var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
		    			+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
		    			+ "" + date.getSeconds();
		    	var winIdx = openUploadWindowCheck();
		    	if (winIdx == 99) {
		    		ComShowMessage(msgs['BKG95043']);
		    		return false;
		    	} else {
		    		arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0229.do"
		    				+ param, "PopupEsmBkg0229" + toDay, 1025, 720, false, "yes");
		    	}
		    	
 
    	}
    	
    	
    }

    function openUploadWindowCheck() {
    	for ( var idx = 0; idx < arrWindow.length; idx++) {
    		if (arrWindow[idx] == null || arrWindow[idx].closed)
    			return idx;
    	}

    	return 99;
    }
	/* 개발자 작업  끝 */