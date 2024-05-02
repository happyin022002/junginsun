/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0058.js
*@FileTitle : VSL SKD Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.26 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.07.11 황태진 CHM-201325672동일 port끼리 reverse call 가능하도록 수정
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
	 * @class VOP_VSK_0058 : VOP_VSK_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_VSK_0058() {
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

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var glbSkdPortFlgs = new Array();		//Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
	var gblCngStsCd = "";					//Sheet1의 skd_cng_sts_cd 변경 시 phase in, phase out 만 저장되도록 하기 위해 선택했을 당시의 값을 임시로 저장.
	var glbColCnt = 0;
	
	//Color 전역변수
	var glbDelayFontColor = null;
	var glbAdvanceFontColor = null;


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
	
					case "btn_add_call":
						doActionIBSheet(sheetObject,formObject,COMMAND04);
						break;
						
					case "btn_add_call_cancel":
						doActionIBSheet(sheetObject,formObject,COMMAND05);
						break;										
					
					case "btn_skip_call":
						doActionIBSheet(sheetObject,formObject,COMMAND06);
						break;
	
					case "btn_skip_call_cancel":
						doActionIBSheet(sheetObject,formObject,COMMAND07);
						break;

					case "btn_reverse_call":
						doActionIBSheet(sheetObject,formObject,COMMAND08);
						break;
						
						
						
					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
						
					case "btn_vvd":
						doActionIBSheet(sheetObject,formObject,COMMAND02);
						break;
	
					case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
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
		
		glbDelayFontColor = sheetObjects[0].RgbColor(255, 0, 0);
		glbAdvanceFontColor = sheetObjects[0].RgbColor(0, 0, 255);
		
		initControl();
		
		initButton(sheetObjects[0]);
		
		initLoadDirection(sheetObjects[0]);
		
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
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 342;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|VVD|Port|TMNL Code|Turn|T/P Voy|T/P Dir|ETA|ETB|ETD|Delay Date|Change Status|Remark(s)";
					var HeadHiddenTitle = "|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|CLPT_IND_SEQ|VSL_SLAN_CD|PORT_SKD_STS_CD|TURN_PORT_IND_CD" +
//							"|TURN_SKD_VOY_NO|TURN_SKD_DIR_CD" +
							"|TURN_CLPT_IND_SEQ|SKD_RMK" +
							"|CRE_DT|UPD_DT|SLAN_CD|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT|TS PORT|USD_FLG|PORT_SKP_TP_CD" +
							"|PORT_SKP_RSN_OFFR_RMK|PORT_SKP_RSN_CD|TTL_DLAY_HRS|DELAY_FLG|ACT_INP_FLG";
					//ETC INFO
					HeadHiddenTitle = HeadHiddenTitle + "|TMP_CNG_STS_CD|NEW_CLPT_IND_SEQ|VPS_RMK|BFR_ACT_FLG" +
							"|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ";
					HeadTitle1 = HeadTitle1 + HeadHiddenTitle;
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					glbColCnt = headCount;

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,		prefix+"ibflag");
					InitDataProperty(0,	cnt++,	dtData,			30,		daCenter,	true,		prefix+"clpt_seq",			false,		"",		dfNone,			0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,		prefix+"vvd",				false,		"",		dfNone,			0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,		prefix+"vps_port_cd",		false,		"",		dfEngUpKey,		0,		false,	false,		5);
					InitDataProperty(0,	cnt++,	dtCombo,		70,		daCenter,	true,		prefix+"tml_cd",			false,		"",		dfNone,			0,		true,	true);
					
					InitDataProperty(0,	cnt++,	dtCombo,		50,		daCenter,	true,		prefix+"turn_port_flg",		false,		"",		dfNone,			0,		true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"turn_skd_voy_no",	false,		"",		dfNone,			0,		false,	false		,4);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		prefix+"turn_skd_dir_cd",	false,		"",		dfEngUpKey,		0,		false,	false		,1);
					InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,		prefix+"vps_eta_dt",		false,		"",		dfUserFormat2,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,		prefix+"vps_etb_dt",		false,		"",		dfUserFormat2,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,		prefix+"vps_etd_dt",		false,		"",		dfUserFormat2,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	true,		prefix+"dlay_date_text",	false,		"",		dfNone,			0,		false,	false);
					
					InitDataProperty(0,	cnt++,	dtCombo,		100,	daCenter,	false,		prefix+"skd_cng_sts_cd",	false,		"",		dfNone,			0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		false,		prefix+"win_rmk",			false,		"",		dfNone,			0,		false,	false);

					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skd_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_port_ind_cd");
//					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_voy_no");
//					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "slan_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "usd_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_offr_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "ttl_dlay_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "delay_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "act_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "tmp_cng_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "new_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "vps_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "bfr_act_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "rsn_clpt_ind_seq");
					
					
					InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N", "N");

					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
//					InitUserFormat2(0, prefix+"vps_eta_dt", "############", "" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					
					InitDataValid(0, prefix+"turn_skd_voy_no", vtNumericOnly);
					InitDataValid(0, prefix+"vps_port_cd", vtEngUpOther, "0123456789");
					
					ColHidden(prefix+"turn_skd_voy_no") = true;
					ColHidden(prefix+"turn_skd_dir_cd") = true;
					
					// 포커스 선택 모드를 설정하거나 확인한다.
					SelectionMode = 3;
					
					CountPosition = "0";
				}
				break;
				
		}
	}
	
	/**
	 * Hidden Col Setting...
	 * 
	 * @param sheetObj
	 * @param Col
	 * @param colName
	 * @return
	 */
	function setHiddenInitDataProperty(sheetObj, Col, colName){
		var prefix = sheetObj.id+"_";
		with (sheetObj) {
			//데이터속성    [	ROW, 	COL,  	DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, 	Col, 	dtHidden,				0,		daCenter,	true,		prefix+colName,		false,		"",			dfNone,			0,			false,		false);
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetID = sheetObj.id;
		
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,IBSEARCH)){
					formObj.f_cmd.value = SEARCH;
					formObj.rtv_flg.value = "N";
					
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0058GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}

				break;
				
			case SEARCH01:
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0058GS.do", sParam);
					
					return sXml;
				}
				
				break;
//			case SEARCH03:
			case SEARCH07:
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH07;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0058GS.do", sParam);
					
					return sXml;
				}
				
				break;
			case SEARCH10:		//Vsl_Cd Check
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH10;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0058GS.do", sParam);
					
					return sXml;
				}
				
				break;

			case COMMAND02:        	// VVD Search
				var vslCd = formObj.vsl_cd.value;
            	
            	if(vslCd == ""){
            		//sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
            		sUrl = "/hanjin/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		//sUrl = "/hanjin/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;

			case COMMAND04:        	// Add Call
				var posFlg = isAddPositionFlag(sheetObj);		// position flag(before/after)
				sUrl = "/hanjin/VOP_VSK_0215.do?pos_flg=" + posFlg;
				var rtnObj = ComOpenPopup(sUrl, 400, 370, "", "0,0", true);
				returnAddCallHelp(sheetObj, rtnObj);
				break;

			case COMMAND05:        	// Add Call Cancel
				addCallCancel(sheetObj);
				break;

			case COMMAND06:        	// Skip Call
				sUrl = "/hanjin/VOP_VSK_0245.do";
        		ComOpenPopup(sUrl, 550, 280, "returnSkipCallHelp", "none", true);
				break;

			case COMMAND07:        	// Skip Call Cancel
				skipCallCancel(sheetObj);
				break;

			case COMMAND08:        	// Reverse Call
				reverseCallControl(sheetObj);
				break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;

					var sParam = ComGetSaveString(sheetObjects, false);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0058GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
					
					//SAVE OK 일 경우 저장된 내용 다시 조회.
					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				break;

//			case IBINSERT:      // 입력
//				break;
		}
	}



	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = sheetObj.LastRow;
		
    	switch(sAction) {

			case IBSEARCH:      //조회
				if(sheetObj.id == "sheet1"){
					if(ComIsNull(formObj.vsl_cd.value)){
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.focus();
						return false;
					} else if (formObj.vsl_cd.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.value = "";
						formObj.vsl_cd.focus();
						return false;
					} else if(ComIsNull(formObj.skd_voy_no.value)){
						ComShowCodeMessage('VSK00027', "Voyage No.");
					 	formObj.skd_voy_no.focus();
						return false;
					} else if (formObj.skd_voy_no.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Voyage No.");
						formObj.skd_voy_no.value = "";
						formObj.skd_voy_no.focus();
						return false;
					} else if(ComIsNull(formObj.skd_dir_cd.value)){
						ComShowCodeMessage('VSK00027', "Direction Code");
						formObj.skd_dir_cd.focus();
						return false;
					}
				}
				break;

			case COMMAND01:      	//vsl_slan_cd onChange Event
				if(!ComIsNull(formObj.vsl_slan_cd.value)){
					if(formObj.vsl_slan_cd.value.length < 3){
						ComShowCodeMessage("VSK01018", "[Lane Code]");
//						ComClearCombo(formObj.pf_svc_tp_cd);
						formObj.vsl_slan_cd.value = "";
						
						return false;
					}
				} else {
//					ComClearCombo(formObj.pf_svc_tp_cd);
					
					return false;
				}
				
				break;

			case IBSAVE:      //저장
				for(var i=headCnt; i<=totCnt; i++){
					//Port Code Check...
					if(sheetObj.CellValue(i, prefix+"vps_port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "[Port Code]");
						sheetObj.SelectCell(i, prefix+"vps_port_cd");
						return false;
					}
					
					//Terminal Code Check...
					var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
					if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
						if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							if(sheetObj.CellValue(i, prefix+"tml_cd") == ""){
								ComShowCodeMessage("VSK00027", "Terminal Code");
								sheetObj.SelectCell(i, prefix+"tml_cd");
								return false;
							}else{
								if(sheetObj.CellValue(i, prefix+"tml_cd").length < 2){
									ComShowCodeMessage("VSK00027", "Terminal Code");
									sheetObj.SelectCell(i, prefix+"tml_cd");
									return false;
								}
							}
						}
					}
					
					//Save 시 turn_skd_voy_no, turn_skd_dir_cd 가 Null 이면 입력하도록 유도(입력가능하게 해당 Column 을 보여줌).
					if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
						if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
							ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
							
							//turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
							turnEditChange(sheetObj);
							
							sheetObj.ColHidden(prefix+"turn_skd_voy_no") = false;
							sheetObj.ColHidden(prefix+"turn_skd_dir_cd") = false;
							
							sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
							
							return false;
						}
					}
					
					//ETA 날짜 포맷 검사.
					if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
						return false;
					}
					//ETB 날짜 포맷 검사.
					if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
						return false;
					}
					//ETD 날짜 포맷 검사.
					if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
						return false;
					}
					
					//ETA < ETB < ETD < Next ETA 순서를 유지.
					if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
						if(sheetObj.CellValue(i, prefix+"vps_eta_dt") < sheetObj.CellValue(i, prefix+"vps_etb_dt")){
							if(sheetObj.CellValue(i, prefix+"vps_etb_dt") < sheetObj.CellValue(i, prefix+"vps_etd_dt")){
								if(i<totCnt){
									for(var k=i+1; k<=totCnt; k++){
										if(sheetObj.CellValue(k, prefix+"skd_cng_sts_cd") != "S"){
											if(sheetObj.CellValue(i, prefix+"vps_etd_dt") < sheetObj.CellValue(k, prefix+"vps_eta_dt")){
												//pass
											}else{
												ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
												sheetObj.SelectCell(i, prefix+"vps_etd_dt");
												return false;
											}
										}
									} // end for
								}
							} else {
								ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
								sheetObj.SelectCell(i, prefix+"vps_etb_dt");
								return false;
							}
						} else {
							ComShowCodeMessage("VSK00032", sheetObj.CellValue(i, prefix+"vps_port_cd"));
							sheetObj.SelectCell(i, prefix+"vps_eta_dt");
							return false;
						}
					}
				} // end for
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
    	var headCnt = sheetObj.HeaderRows;
    	
    	if(sheetObj.ColHidden(prefix+"turn_skd_voy_no") == false) sheetObj.ColHidden(prefix+"turn_skd_voy_no") = true;
		if(sheetObj.ColHidden(prefix+"turn_skd_dir_cd") == false) sheetObj.ColHidden(prefix+"turn_skd_dir_cd") = true;
    	
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					
					try{
						var chgStsCds = ComGetEtcData(sXml, "chg_sts_cd");		//Change Status Code
						var chgStsNms = ComReplaceStr(ComGetEtcData(sXml, "chg_sts_nm"), " calling", ""); //Change Status CodeName(code명이 길어서 줄임).
						
						sheetObj.InitDataCombo(0, prefix+"skd_cng_sts_cd", " |"+chgStsNms, " |"+chgStsCds);
						
						sheetObj.LoadSearchXml(sXml);
						
						formObj.vsl_slan_cd.value = sheetObj.CellValue(headCnt, prefix+"vsl_slan_cd");
						formObj.cre_dt.value = sheetObj.CellValue(headCnt, prefix+"cre_dt");
				    	formObj.upd_dt.value = sheetObj.CellValue(headCnt, prefix+"upd_dt");
						
						initPortDataFlg(sheetObj);
						
						
						//TMNL Setting.
						var ydCds = ComGetEtcData(sXml, "tml_cd").split("|");
						if(ydCds != null && ydCds != undefined && ydCds != ""){
							for(var i=0 ; i < ydCds.length ; i++ ) {
								sheetObj.CellComboItem(i+headCnt, prefix+"tml_cd", ydCds[i], ydCds[i]);
								sheetObj.CellValue2(i+headCnt, prefix+"tml_cd") = ydCds[i];
								
								var turnPortIndCd = sheetObj.CellValue(i+headCnt, prefix+"turn_port_ind_cd");
								if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//					    			TURN_PORT_IND_CD가 (D, V, F)일 경우는 ETA, ETB, ETD만 수정가능.
//			 						Yard 변경가능하게 추가요청(임창빈 수석 - 2009.11.16)
//									sheetObj.CellEditable(i+headCnt, prefix+"tml_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"turn_port_flg") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"skd_cng_sts_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_rmk") = false;
					    		}
								
					    		//FontColor Setting...
					    		if(sheetObj.CellValue(i+headCnt, prefix+"delay_flg") == "B"){
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_eta_dt") = glbAdvanceFontColor;
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_etb_dt") = glbAdvanceFontColor;
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_etd_dt") = glbAdvanceFontColor;
					    		}else if(sheetObj.CellValue(i+headCnt, prefix+"delay_flg") == "R"){
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_eta_dt") = glbDelayFontColor;
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_etb_dt") = glbDelayFontColor;
					    			sheetObj.CellFontColor(i+headCnt, prefix+"vps_etd_dt") = glbDelayFontColor;
					    		}
								
					    		//Actual SKD이 입력된 스케줄에 대해서는 변경 불가.
								if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "A"){
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;

					    			sheetObj.CellEditable(i+headCnt, prefix+"tml_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"turn_port_flg") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"skd_cng_sts_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_rmk") = false;
					    		} else if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "B") {
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etb_dt") = false;

					    			sheetObj.CellEditable(i+headCnt, prefix+"tml_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"turn_port_flg") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"skd_cng_sts_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_rmk") = false;
					    		} else if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "D") {
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etb_dt") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etd_dt") = false;

					    			sheetObj.CellEditable(i+headCnt, prefix+"tml_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"turn_port_flg") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"skd_cng_sts_cd") = false;
					    			sheetObj.CellEditable(i+headCnt, prefix+"vps_rmk") = false;
					    		}
					    		
					    		//Skip 한 Port 는 수정 불가
					    		if(sheetObj.CellValue(i+headCnt, prefix+"skd_cng_sts_cd") == "S"){
					    			sheetObj.RowEditable(i+headCnt) = false;
					    			fontColorChangeBySkip(sheetObj, i+headCnt);
					    		}
							}
						}
						// clpt_seq 새로 부여.
						resetClptSeq(sheetObj);

						formObj.skd_rmk.value = sheetObj.CellValue(headCnt, prefix+"skd_rmk");
						
						sheetObj.SelectCell(headCnt, 1);
//						ComBtnEnable("btn_add_call");
//						ComBtnEnable("btn_skip_call");
					}catch(e){
						ComShowMessage(e);
					}
					
					sheetObj.Redraw = true;
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}else{
				sheetObj.LoadSearchXml(sXml);
			}
		}
    }
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */

	function sheet1_OnClick(sheetObj, Row, Col) {
		if(Row > 0 && Col > 0){
//			setElementData(sheetObj, Row, Col);

			var prefix = sheetObj.id + "_";
			var formObj = document.form;
			var headCnt = sheetObj.HeaderRows;
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"win_rmk"){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, prefix+"vps_rmk"));
//				if(sheetObj.RowEditable(Row) == false){
				if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X" 
					|| sheetObj.CellValue(Row, prefix+"port_skd_sts_cd") == "D"
					|| sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
					sUrl = sUrl + "&readonly=true";
				}
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal == ""){
					sheetObj.CellValue2(Row, prefix+"vps_rmk") = rVal;
					sheetObj.CellValue2(Row, prefix+"win_rmk") = rVal.replace(/\n/g, "").replace(/\r/g, "");
				}
			}
		}
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var headCnt = sheetObj.HeaderRows;
		var sXml = null;
		var prefix = sheetObj.id + "_";
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
//			if(colName == prefix+"vps_port_cd"){							//Port 변경 시
//				glbSkdPortFlgs[Row-headCnt] = "N";
//				
//				//Termanal Code 조회
//				formObj.loc_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd");
//				
//				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
//				
//				if(isCheckPort(sheetObj, Row, sXml)){
//					if(sXml != null && sXml != undefined && sXml != ""){
//						var rootNode = VskGetXmlRootNode(sXml);
//						var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
//						if(dataNode){
//							var totValue = dataNode.value;
//	
//							if(totValue > 0){
//								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
//							}else{
//								sheetObj.CellComboItem(Row, prefix+"tml_cd", "", "");
////								sheetObj.CellValue2(Row, prefix+"tml_cd") = "";
//							}
//						}
//					}
//					glbSkdPortFlgs[Row-headCnt] = "Y";
//				}else{
//					glbSkdPortFlgs[Row-headCnt] = "N";
//				}
//			}else 
			if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				if(cngStsCd != "" && cngStsCd != "I" && cngStsCd != "O"){
					ComShowCodeMessage("VSK00078");
					sheetObj.CellValue2(Row, prefix+"skd_cng_sts_cd") = gblCngStsCd;
				}else{
					gblCngStsCd = sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd");
				}
			}else if(colName == prefix+"turn_port_flg"){
				//turn_port_flg 을 'Y'로 변경 시 해당 VVD 의 Turnning 정보를 입력해 준다.
				//'N'으로 변경 시는 Turnning 정보를 삭제해 준다.
				//모든 turnning 정보가 삭제되어도 상관없음(김기원 K - 2009.10.21).
				var turnPortFlg = sheetObj.CellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){
					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
					
					for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd && (i+headCnt) != Row){
							if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
								sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_voy_no");
								sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_dir_cd");
								break;
							}
						}
					}
					
					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = true;
					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = true;
				}else{
					sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = "";
					sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = "";
					
					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = false;
					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = false;
				}
			}
		}
	}

	
	/**
	 * sheet1의 선택된 셀이 바뀌었을때 발생하는 Event
	 * 
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		
		if(NewRow >= sheetObj.HeaderRows && NewCol > 0){
			var formObj = document.form;
			var headCnt = sheetObj.HeaderRows;
			var sXml = null;
			var prefix = sheetObj.id + "_";
			
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
				if(!sheetObj.CellEditable(NewRow, NewCol)){
					return;
				}
				
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
					formObj.loc_cd.value = sheetObj.CellValue(NewRow, prefix+"vps_port_cd");
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					glbSkdPortFlgs[NewRow-headCnt] = "Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblCngStsCd = sheetObj.CellValue(NewRow, NewCol);
			}
			
			var turnPortIndCd = sheetObj.CellValue(NewRow, prefix+"turn_port_ind_cd");
			if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
				ComBtnDisable("btn_skip_call");
				ComBtnDisable("btn_add_call");
				ComBtnDisable("btn_skip_call_cancel");
				ComBtnDisable("btn_add_call_cancel");
			}else{
				//Skip Call 확인
				if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "S"){
					ComBtnEnable("btn_skip_call_cancel");
				} else {
					ComBtnDisable("btn_skip_call_cancel");
				}
				
				//Add Call 확인
//				if(sheetObj.CellValue(NewRow, prefix+"ibflag") == "I"){
				if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "A"){
					ComBtnEnable("btn_add_call_cancel");
				} else {
					ComBtnDisable("btn_add_call_cancel");
				}
				
				//Phase Out 확인
//				if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "O"){
//					ComBtnEnable("btn_p_out_cancel");
//				} else {
//					ComBtnDisable("btn_p_out_cancel");
//				}
				
				//port_skd_sts_cd로 입력여부 판단.
				if(isSkipPortSts(sheetObj, NewRow)){
					//SKIP된 ROW에 커서 이동시 SKIP CALL 버튼은 비활성화(임창빈 수석 2009.08.10)
					if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "S"){
						ComBtnDisable("btn_skip_call");
					}else{
						ComBtnEnable("btn_skip_call");
					}
					
//					if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "O"){
//						ComBtnDisable("btn_p_out");
//					}else{
//						ComBtnEnable("btn_p_out");
//					}
				}else{
					ComBtnDisable("btn_skip_call");
//					ComBtnDisable("btn_p_out");
				}
				
				// Add Call 제한 풀어줌.(2010.04.09 김기원 C)
//				if(isAddPortSts(sheetObj, NewRow)){
					ComBtnEnable("btn_add_call");
//				}else{
//					ComBtnDisable("btn_add_call");
//				}
			}
			
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	
	/**
	 * Sheet1의 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
	}
	
	/**
	 * Sheet1의 눌려진 마우스가 올라올 때 발생하는 Event
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y){
		//Row 다중선택 확인하여 선택된 Row가 2줄인지 확인하여 Reverse Call Button Control
		btnReverseCallControl(sheetObj);
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	//- form 전체 컨트롤 onkeydown 이벤트에 코드 처리
	}
    
	function obj_change(){
		var formObj = document.form;
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcValue = window.event.srcElement.getAttribute("value");
	        switch(srcName) {
	
	            case "vsl_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	
	            	if(isCheckVslCd(sheetObj, formObj)){
		            	if(srcValue.length == 4){
				    		formObj.skd_voy_no.focus();
				    	}
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;

	            case "skd_voy_no":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 4){
			    		formObj.skd_dir_cd.focus();
			    	}
	            	break;
	            case "skd_dir_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 1){
			    		formObj.vsl_slan_cd.focus();
			    	}
	            	break;
	
	            case "vsl_slan_cd":
	            	/*
	            	 * 1. Lane Code 3자리 이하이면 null처리.
	            	 * 2. 3자리 이상이면 SC를 호출
	            	 */
//	            	if(validateForm(sheetObject, formObject, COMMAND01)){
//		            	var sXml = doActionIBSheet(sheetObject, formObject, COMMAND01);
//		            	setHtmlComboSinc(sXml, formObject.pf_svc_tp_cd);
//	            	}
	            	
//	            	isRmkModFlg = "Y";
	            	
	            	break;
	            	
	            case "skd_rmk":
//	            	isRmkModFlg = "Y";
	            	break;
	                
	        } // end switch isRmkModFlg
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

		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;

		    case "skd_rmk":
		    	if(formObj.skd_rmk.value.length > 4000){
		    		ComShowCodeMessage("VSK01019", "[Remark]");
		    		return false;
		    	}
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

//		    case "vsl_slan_cd":
//		    	if(eleObj.value.length == 3){
//		    		formObj.skd_rmk.focus();
//		    	}
				break;
		}
	}
	
	function obj_focus(){
		var eleObj = event.srcElement;
		
		if(eleObj.name){
			focusObj = eleObj.name;
		}else{
			focusObj = "";
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
				}
			}
    	}
    }
	
	/**
	 * [Add Call] Button Click 후 Pop-up에서 호출.
	 * @param rtnObj
	 * @return
	 */
	function returnAddCallHelp(sheetObj, rtnObj){
		if(rtnObj){
			addCallControl(sheetObj, rtnObj);
		}
	}
	
	/**
	 * Port Skip Recorder for Statistics (Pop-Up)에서 받은 데이타 처리.
	 * [Skip Call] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnSkipCallHelp(rtnObjs){
		if(rtnObjs.length > 0){
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			var prefix = sheetObj.id+"_";
			var headCnt = sheetObj.headerRows;
			var totCnt = sheetObj.LastRow;
			var currRow = 0;
			var idx = 0;
		
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S" || i == sheetObj.SelectRow){
					var rtnDatas = rtnObjs[idx];
					if(rtnDatas != null && rtnDatas != undefined && rtnDatas.length > 0){
						sheetObj.CellValue2(i, prefix+"ts_port_cd") = rtnDatas[15];				// ts_port_cd
						sheetObj.CellValue2(i, prefix+"usd_flg") = rtnDatas[4];					// Report(DB:USD_FLG)
						sheetObj.CellValue2(i, prefix+"port_skp_tp_cd") = rtnDatas[6];			// Force Majeure(DB:PORT_SKP_TP_CD)
						sheetObj.CellValue2(i, prefix+"port_skp_rsn_offr_rmk") = rtnDatas[19];	// rsn_port_cd
						sheetObj.CellValue2(i, prefix+"port_skp_rsn_cd") = rtnDatas[8];			// 
						sheetObj.CellValue2(i, prefix+"ttl_dlay_hrs") = rtnDatas[9];			// Hours(DB:TTL_DLAY_HRS)
						sheetObj.CellValue2(i, prefix+"vps_rmk") = rtnDatas[11];					// vps_rmk
						
						sheetObj.CellValue2(i, prefix+"ts_skd_voy_no") = rtnDatas[16];			// ts_skd_voy_no
						sheetObj.CellValue2(i, prefix+"ts_skd_dir_cd") = rtnDatas[17];			// ts_skd_dir_cd
						sheetObj.CellValue2(i, prefix+"ts_clpt_ind_seq") = rtnDatas[18];		// ts_clpt_ind_seq
						sheetObj.CellValue2(i, prefix+"rsn_skd_voy_no") = rtnDatas[20];			// rsn_skd_voy_no
						sheetObj.CellValue2(i, prefix+"rsn_skd_dir_cd") = rtnDatas[21];			// rsn_skd_dir_cd
						sheetObj.CellValue2(i, prefix+"rsn_clpt_ind_seq") = rtnDatas[22];		// rsn_clpt_ind_seq
					}
					idx++;
				}
				
			}
			skipCallControl(sheetObj);
		}
		
	}
	
	/*
	 * =====================================================================
	 * Button Event
	 * =====================================================================
	 */

	
	/**
	 * [Add Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallControl(sheetObj, rowData){
		var formObj = document.form;
		var sRow = sheetObj.SelectRow;
		var prefix = sheetObj.id + "_";
		
		var pos = rowData.position;

		sheetObj.Redraw = false;
		
		if(pos == "before"){
			// Actual Port 이전에 AddCall 할 경우 Validation.
			if(!isAddCallActualPort(sheetObj, sRow-1, rowData.port_cd)){
				sheetObj.Redraw = true;
				return;
			}
			
			//선택한 Row 이전에 ADD
			sheetObj.DataInsert(sRow-1);
			//Color Setting.
//			sheetObj.RowBackColor(sRow) = sheetObj.RowBackColor(sRow+1);
	
			sheetObj.CellValue2(sRow, prefix+"vvd") = sheetObj.CellValue(sRow+1, prefix+"vvd");
			sheetObj.CellValue2(sRow, prefix+"vsl_cd") = sheetObj.CellValue(sRow+1, prefix+"vsl_cd");
			sheetObj.CellValue2(sRow, prefix+"skd_voy_no") = sheetObj.CellValue(sRow+1, prefix+"skd_voy_no");
			sheetObj.CellValue2(sRow, prefix+"skd_dir_cd") = sheetObj.CellValue(sRow+1, prefix+"skd_dir_cd");
			sheetObj.CellValue2(sRow, prefix+"vsl_slan_cd") = sheetObj.CellValue(sRow+1, prefix+"vsl_slan_cd");
				
			sheetObj.CellValue2(sRow, prefix+"vps_port_cd") = rowData.port_cd;
//			Pop-up 미구현(YD_CD, ETA 추후 추가)
//			sheetObj.CellValue2(sRow, prefix+"tml_cd") = rowData.yd_cd;
			sheetObj.CellValue2(sRow, prefix+"vps_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow, prefix+"vps_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow, prefix+"vps_etd_dt") = rowData.etd;
			if(rowData.turn_ind == "0"){
				sheetObj.CellValue(sRow, prefix+"turn_port_flg") = "Y";
			}
			
			formObj.loc_cd.value = rowData.port_cd;
			
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "A";
			
			sheetObj.SelectCell(sRow, sheetObj.SelectCol);
		}else{
			// Actual Port 이전에 AddCall 할 경우 Validation.
			if(!isAddCallActualPort(sheetObj, sRow, rowData.port_cd)){
				sheetObj.Redraw = true;
				return;
			}
			
			//선택한 Row 이후에 ADD
			sheetObj.DataInsert(sRow);
			//Color Setting.
//			sheetObj.RowBackColor(sRow+1) = sheetObj.RowBackColor(sRow);
			
			sheetObj.CellValue2(sRow+1, prefix+"vvd") = sheetObj.CellValue(sRow, prefix+"vvd");
			sheetObj.CellValue2(sRow+1, prefix+"vsl_cd") = sheetObj.CellValue(sRow, prefix+"vsl_cd");
			sheetObj.CellValue2(sRow+1, prefix+"skd_voy_no") = sheetObj.CellValue(sRow, prefix+"skd_voy_no");
			sheetObj.CellValue2(sRow+1, prefix+"skd_dir_cd") = sheetObj.CellValue(sRow, prefix+"skd_dir_cd");
			sheetObj.CellValue2(sRow+1, prefix+"vsl_slan_cd") = sheetObj.CellValue(sRow, prefix+"vsl_slan_cd");
				
			sheetObj.CellValue2(sRow+1, prefix+"vps_port_cd") = rowData.port_cd;
//			Pop-up 미구현(YD_CD, ETA 추후 추가)
//			sheetObj.CellValue2(sRow+1, prefix+"tml_cd") = rowData.yd_cd;
			sheetObj.CellValue2(sRow+1, prefix+"vps_eta_dt") = rowData.eta;
			sheetObj.CellValue2(sRow+1, prefix+"vps_etb_dt") = rowData.etb;
			sheetObj.CellValue2(sRow+1, prefix+"vps_etd_dt") = rowData.etd;
			if(rowData.turn_ind == "0"){
				sheetObj.CellValue(sRow+1, prefix+"turn_port_flg") = "Y";
			}
			
			formObj.loc_cd.value = rowData.port_cd;
			
			sheetObj.CellValue2(sRow+1, prefix+"skd_cng_sts_cd") = "A";
			
			sheetObj.SelectCell(sRow+1, sheetObj.SelectCol);
		}
		
		
		resetClptSeq(sheetObj);		// clpt_seq 새로 부여.
		resetClptIndSeq(sheetObj);	// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
		initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
		
		sheetObj.Redraw = true;
		
		ComBtnEnable("btn_add_call_cancel");
	}
	
	/**
	 * [Add Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallCancel(sheetObj){
		var sRow = sheetObj.SelectRow;
		var prefix = sheetObj.id + "_";
		
		sheetObj.Redraw = false;
		
//		if(sheetObj.CellValue(sRow, prefix+"ibflag") == "I"){
		if(sheetObj.RowStatus(sRow) == "I"){
			sheetObj.RowDelete(sRow, false);
		}else if(sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd") == "A"){
//			sheetObj.CellValue2(sRow, prefix+"ibflag") = "D";
			sheetObj.RowStatus(sRow) = "D";
			sheetObj.RowHidden(sRow) = true;
		}
		
		resetClptSeq(sheetObj);		// clpt_seq 새로 부여.
		resetClptIndSeq(sheetObj);	// clpt_ind_seq 새로 부여(new_clpt_ind_seq 에 셋팅)
		initPortDataFlg(sheetObj);	// Terminal 재조회 Flag 초기화.
		
		sheetObj.Redraw = true;
		
		ComBtnDisable("btn_add_call_cancel");
	}
	
	/**
	 * [Skip Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallControl(sheetObj){

		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var headRow = sheetObj.HeaderRows;
		var formObj = document.form;
		
//		var isColHidden = true;
		
//		VSK_PORT_DIST
//		var sXml = doCallBaseInfo(sheetObj, sRow, "SKIP");
		
//		sheetObj.Redraw = false;
		
		try{
		
			//Dist 및 Sea Time 을 새로 셋팅함.
//			setBaseInfo(sheetObj, sXml, sRow, "SKIP");
			
			/*
			 * Hidden Col이 있으면 임시로 펼친다.
			 * Skip 된 Row 는 font color를 back color로 변경해야 하는데 
			 * 숨겨진 필드가 있으면 변경이 안되므로 
			 * 숨겨진 필드가 있으면 임시로 펼친 후 로직이 다 실행되면 다시 닫는다. 
			 */
//			if(sheetObj.id == "sheet1"){
//				isColHidden = sheetObj.ColHidden(prefix+"lnk_dist");
//			}else{
//				isColHidden = sheetObj.ColHidden(prefix+"ib_cgo_qty");
//			}
	
//			if(isColHidden){
//				showFieldControl(sheetObj, formObj, true);
//			}
			
			//현재 상태값을 임시공간에 담아둔다.
			sheetObj.CellValue2(sRow, prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd");
			//현재 상태값을 Skip으로 변경.
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = "S";
			
			//Skip 한 Port Edit 불가.
			sheetObj.RowEditable(sRow) = false;
			
			fontColorChangeBySkip(sheetObj, sRow);
			
			//skip 한 Row 부터 스케줄 다시 생성.
//			if(sRow == headRow){
//				calcSchedule(sheetObj, sRow+1, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
//			}else{
//				calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
//			}
			
//			if(isColHidden){
//				showFieldControl(sheetObj, formObj, false);
//			}
			
//			//Bunker Additional Cost
//			if(sRow > headRow && sRow < sheetObj.RowCount+headRow){
//				var preEtdDt = sheetObj.CellValue(sRow-1, prefix+"vps_etd_dt");
//				var nxtEtaDt = sheetObj.CellValue(sRow, prefix+"vps_eta_dt");
//				
//				var dateObj = new Usr_CalcTimeSet(preEtdDt);
//				var timeDiff = dateObj.getTimeDiff(nxtEtaDt);
//
//				var bnkUnitQty = sheetObj.CellValue(sRow-1, prefix+"bnk_unit_qty");
//				var bnkUnitAmt = sheetObj.CellValue(sRow-1, prefix+"bnk_unit_amt");
//				
//				var bnkTotQty = Number(bnkUnitQty) * Number(timeDiff);
//				var bnkTotAmt = Number(bnkTotQty) * Number(bnkUnitAmt);
//				
//				//현재 Bunker 양을 구함.
//				sheetObj.CellValue2(sRow-1, prefix+"bnk_tot_qty") = bnkTotQty;
//				//현재 Bunker Cost를 구함.
//				sheetObj.CellValue2(sRow-1, prefix+"bnk_tot_amt") = bnkTotAmt;
//				
//				//Skip 이후의 ETA를 찾아서 시간차이를 다시 구함.
//				nxtEtaDt = sheetObj.CellValue(sRow+1, prefix+"vps_eta_dt");
//				timeDiff = dateObj.getTimeDiff(nxtEtaDt);
//				
//				var addBnkCsmQty = Number(bnkUnitQty) * Number(timeDiff);
//				var addBnkCostAmt = Number(addBnkCsmQty) * Number(bnkUnitAmt);
//				
//				sheetObj.CellValue2(sRow-1, prefix+"add_bnk_csm_qty") = bnkTotQty - addBnkCsmQty;
//				sheetObj.CellValue2(sRow-1, prefix+"add_bnk_cost_amt") = bnkTotAmt - addBnkCostAmt;
//			}
//			sheetObj.Redraw = true;
		}catch(e) {
//			sheetObj.Redraw = true;
			
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
		
		ComBtnEnable("btn_skip_call_cancel");
	}
	
	/**
	 * [Skip Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallCancel(sheetObj){
		
		var sRow = sheetObj.SelectRow;
		var prefix = sheetObj.id + "_";
		
		if(sheetObj.CellValue(sRow, prefix+"skd_cng_sts_cd") == "S"){
//			var sXml = doCallBaseInfo(sheetObj, sRow, "SKIP_CANCEL");
			
//			sheetObj.Redraw = false;
			
			//Dist 및 Sea Time 을 새로 셋팅함.
//			setBaseInfo(sheetObj, sXml, sRow, "SKIP_CANCEL");
			
			/*
			 * Hidden Col이 있으면 임시로 펼친다.
			 * Skip Cancel된 Row 는 font color를 원래의 color(black)로 변경해야 하는데 
			 * 숨겨진 필드가 있으면 변경이 안되므로 
			 * 숨겨진 필드가 있으면 임시로 펼친 후 로직이 다 실행되면 다시 닫는다. 
			 */
//			var isColHidden = true;
//			if(sheetObj.id == "sheet1"){
//				isColHidden = sheetObj.ColHidden(prefix+"lnk_dist");
//			}else{
//				isColHidden = sheetObj.ColHidden(prefix+"ib_cgo_qty");
//			}
			
			//임시공간에 있던 상태값을 다시 원래 상태값으로 되돌린다.
			sheetObj.CellValue2(sRow, prefix+"skd_cng_sts_cd") = sheetObj.CellValue(sRow, prefix+"tmp_cng_sts_cd");
			sheetObj.CellValue2(sRow, prefix+"port_skp_tp_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"port_skp_rsn_cd") = "";
			sheetObj.CellValue2(sRow, prefix+"port_skp_rsn_offr_rmk") = "";
			sheetObj.CellValue2(sRow, prefix+"win_rmk") = "";
			sheetObj.CellValue2(sRow, prefix+"vps_rmk") = "";
			sheetObj.CellValue2(sRow, prefix+"ttl_dlay_hrs") = "";



			
			//Skip Cancel 한 Port Edit 가능하게.
			sheetObj.RowEditable(sRow) = true;
			
			// sheet1, sheet2 공통
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_eta_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etb_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etd_dt");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"delay_date");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_dist");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_spd");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"tztm_hrs");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"act_wrk_hrs");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"port_buf_hrs");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"sea_buf_hrs");
	
			//sheet2 전용
//			if(glbSheetFlg == "sheet2"){
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"time_diff");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_in_hrs");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_out_hrs");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"crn_knt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_prod_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ib_cgo_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ob_cgo_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_csm_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_cost_amt");
////				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_qty");
////				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_qty");
////				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_amt");
////				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_amt");
//			}
			
			//skip 한 Row 부터 스케줄 다시 생성.
//			if(sRow == sheetObj.HeaderRows){
//				calcSchedule(sheetObj, sRow, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
//			}else{
//				calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
//			}
			
			//임시로 펼쳤던 Col이 있으면 닫는다.
//			if(isColHidden){
//				showFieldControl(sheetObj, document.form, false);
//			}
//			sheetObj.Redraw = true;
		
			ComBtnDisable("btn_skip_call_cancel");
		}
	}
	
	/**
	 * [Reverse Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function reverseCallControl(sheetObj){
		if(!rowDataChange(sheetObj)){
			return false;
		}
		
//		ComBtnDisable("btn_reverse_call");
	}
    
    /**
     * [Reverse Call] Button Disabled Control...
     * @param sheetObj
     * @return
     */
    function btnReverseCallControl(sheetObj){
		var strSelRow = sheetObj.GetSelectionRows("|");
		var btnName = "btn_reverse_call";
		
		if(strSelRow != null && strSelRow != undefined && strSelRow != ""){
			var selRows = strSelRow.split("|");
			if(selRows.length == 2){
				var formObj = document.form;
				var prefix = sheetObj.id + "_";
				
				//port_skd_sts_cd 의 값이 A, B, D 중 하나라도 들어오면 Reverse 안됨.
				//Reverse Call 제한 풀어줌.(2010.04.09 김기원 C)
//				if(isSkipBtnSts(sheetObj, selRows[0]) && isSkipBtnSts(sheetObj, selRows[1])){
					var vvd1 = sheetObj.CellValue(selRows[0], prefix+"vvd");
					var vvd2 = sheetObj.CellValue(selRows[1], prefix+"vvd");
					
					//vvd가 다르면 Reverse 안됨.
					if(vvd1 == vvd2){
						ComBtnEnable(btnName);
					}else{
						ComBtnDisable(btnName);
					}
//				}else{
//					ComBtnDisable(btnName);
//				}
			}else{
				ComBtnDisable(btnName);
			}
		}else{
			ComBtnDisable(btnName);
		}
    }
	
	/*
	 * =====================================================================
	 * 
	 * =====================================================================
	 */

	
    /**
     * 입력받은 param 의 해당 폼데이타 처리.
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function setFormData(sheetObj, Row, Col){
    	var formObj = document.form;
    	var prefix = sheetObj.id + "_";
    	
    	formObj.cre_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"cre_dt"));
    	formObj.upd_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"upd_dt"));
    }
    
    /**
     * Turnning Port의 Direction Code 목록을 Setting.
     * @param sheetObj
     * @return
     */
    function initLoadDirection(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH07);
    	
    	var sDirCds = ComGetEtcData(sXml, "direction_cd");
    	
    	sheetObj.InitDataCombo(0, prefix+"turn_skd_dir_cd", sDirCds, sDirCds, "", " ");
    }
    
	/**
	 * 버튼 초기화.
	 * @return
	 */
    function initButton(sheetObj){
    	var formObj = document.form;

    	ComBtnDisable("btn_add_call");
    	ComBtnDisable("btn_add_call_cancel");
    	ComBtnDisable("btn_skip_call");
    	ComBtnDisable("btn_skip_call_cancel");
    	ComBtnDisable("btn_reverse_call");
    	
//    	ComBtnDisable("btn_row_hide_1");
//    	ComBtnDisable("btn_skip_call_1");
//    	ComBtnDisable("btn_add_call_1");
//    	ComBtnDisable("btn_reverse_call_1");
//    	ComBtnDisable("btn_row_hide_cancel_1");
//    	ComBtnDisable("btn_skip_call_cancel_1");
//    	ComBtnDisable("btn_add_call_cancel_1");
//    	ComBtnDisable("btn_reverse_call_change_1");
//    	
//    	ComBtnDisable("btn_settlement");
//    	ComEnableObject(formObj.btn_sim_no, false);
    }
	
    /**
     * Terminal 재조회 방지위한 초기 데이타 처리.
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    	var totCnt = sheetObj.RowCount;
    	
    	for(var i=0; i<totCnt; i++){
    		glbSkdPortFlgs[i] = "N";
    	}
    }
    

    
    /**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param sRow
     * @param sXml
     * @return
     */
    function isCheckPort(sheetObj, sRow, sXml){
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
    
    /**
     * Add Call 하려는 Port 이후의 스케줄에 같은 Actual 인 Port 가 존재하면 Add Call 막음.
     * 
     * @param sheetObj
     * @param sRow
     * @return
     */
    function isAddCallActualPort(sheetObj, Row, portCd){
    	var prefix = sheetObj.id + "_";
    	var headRow = sheetObj.HeaderRows;
    	var totCnt = sheetObj.LastRow;
    	
    	for(var i=Row+1; i<=totCnt; i++){
    		// Skip 은 비교대상에서 제외.
    		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    			if(sheetObj.CellValue(i, prefix+"vps_port_cd") == portCd){
    				var actInpFlg = sheetObj.CellValue(i, prefix+"act_inp_flg");
    				if(actInpFlg == "Y"){
    					ComShowCodeMessage("VSK00001");
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * Reverse Call 하려는 Port 내의 스케줄에 같은 Actual 인 Port 가 존재하면 Reverse Call 막음.
     * 
     * @param sheetObj
     * @param Rows
     * @return
     */
    function isReverseCallActualPort(sheetObj, Rows){
    	var prefix = sheetObj.id + "_";
    	var headRow = sheetObj.HeaderRows;
    	var totCnt = sheetObj.LastRow;
    	
    	var fPortCd = sheetObj.CellValue(Rows[0], prefix+"vps_port_cd");
    	var sPortCd = sheetObj.CellValue(Rows[1], prefix+"vps_port_cd");

    	var fTmlCd = sheetObj.CellValue(Rows[0], prefix+"tml_cd");
    	var sTmlCd = sheetObj.CellValue(Rows[1], prefix+"tml_cd");

    	var fActInpFlg = sheetObj.CellValue(Rows[0], prefix+"act_inp_flg");
		var sActInpFlg = sheetObj.CellValue(Rows[1], prefix+"act_inp_flg");
		
		var fIbFlg = sheetObj.RowStatus(Rows[0]);
		var sIbFlg = sheetObj.RowStatus(Rows[1]);
	
		
    	if(Number(Rows[1]) - Number(Rows[0]) == 1){
    		// 인접한 Row 를 Reverse 할 경우.

    		if(fActInpFlg == "Y" || sActInpFlg == "Y"){
				// CHM-201325672 [VOP-VSK] VSL SKD Update (CCA) – 동일 port끼리 reverse call /터미널 코드 추가 체크 
    			if(fPortCd == sPortCd && fTmlCd == sTmlCd  ){
					ComShowCodeMessage("VSK00023");
					return false;
				}
    		}
    		
    		// 선택한 2 Port 모두 조회된 Port 일 경우.
    		if(fIbFlg == "U" && sIbFlg == "U"){
				// CHM-201325672 [VOP-VSK] VSL SKD Update (CCA) – 동일 port끼리 reverse call /터미널 코드 추가 체크 
				if(fPortCd == sPortCd && fTmlCd == sTmlCd ){
					ComShowCodeMessage("VSK00024");
					return false;
				}
    		}
    		
    	}else{
    		// 인접하지 않은 Row 를 Reverse 할 경우.
    		// 첫번째 Port Check.
    		for(var i=ComParseInt(Rows[0])+1; i<=Rows[1]; i++){
    			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    				// CHM-201325672 [VOP-VSK] VSL SKD Update (CCA) – 동일 port끼리 reverse call /터미널 코드 추가 체크 
    				if(sheetObj.CellValue(i, prefix+"vps_port_cd") == fPortCd && sheetObj.CellValue(i, prefix+"tml_cd") == fTmlCd  ){
	        			var actInpFlg = sheetObj.CellValue(i, prefix+"act_inp_flg");
	        			// From clpt_seq + 1 와 To clpt_seq 사이에 From Port와 같고, 조회된 동일 Port가 있는지 확인.
	    				if(fActInpFlg == "Y" || actInpFlg == "Y"){
	    					ComShowCodeMessage("VSK00023");
	    					return false;
	    				}
	    				
	    				// From clpt_seq + 1 와 To clpt_seq 사이에 From Port와 같고, 조회된 동일 Port가 있는지 확인.
	    	    		if(sheetObj.CellValue(i, prefix+"ibflag") == "U"){
    						ComShowCodeMessage("VSK00024");
    						return false;
	    	    		}
	    			}
    			}
    		}
    		
    		// 두번째 Port Check.
    		for(var i=Rows[0]; i<Rows[1]; i++){
    			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    				// CHM-201325672 [VOP-VSK] VSL SKD Update (CCA) – 동일 port끼리 reverse call /터미널 코드 추가 체크 
	    			if(sheetObj.CellValue(i, prefix+"vps_port_cd") == sPortCd  && sheetObj.CellValue(i, prefix+"tml_cd") == sTmlCd ){
	        			var actInpFlg = sheetObj.CellValue(i, prefix+"act_inp_flg");
	        			//
	    				if(sActInpFlg == "Y" || actInpFlg == "Y"){
	    					ComShowCodeMessage("VSK00023");
	    					return false;
	    				}
	    				
	    				// From clpt_seq 와 To clpt_seq - 1 사이에 To Port와 같고, 조회된 동일 Port가 있는지 확인.
	    	    		if(sheetObj.CellValue(i, prefix+"ibflag") == "U"){
    						ComShowCodeMessage("VSK00024");
    						return false;
	    	    		}
	    			}
    			}
    		}
    	}
    	
    	return true;
    }
    
    /**
	 * Sheet의 Terminal Combo Data Setting...
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param sXml
	 * @return
	 */
	function setYardCombo(sheetObj, Row, Col, sXml){
		var xmlEtcData = ComGetEtcData(sXml, "yd_kind");
		
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			sheetObj.CellComboItem(Row, sheetObj.id+"_tml_cd", xmlEtcData, xmlEtcData);
		}
	}
	
	/**
	 * Sheet의 Terminal Combo Data Setting...
	 * @param xmlStr
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var prefix = sheetObj.id + "_";
		var ydKindCode = " |" + ComGetEtcData(xmlStr, "yd_kind");
		var ydNm = " |" + ComGetEtcData(xmlStr, "yd_nm");
		var ydTxt = "";
		
		if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
			var ydKindCodeArr = ydKindCode.split("|");
			var ydNmArr = ydNm.split("|");
			var ydCnt = ydKindCodeArr.length;
			
			ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
			for(var i=1; i<ydCnt; i++){
				ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
			}
			
			sheetObj.CellComboItem(Row, prefix+"tml_cd", ydTxt, ydKindCode);
// 			sheetObj.CellValue2(Row, prefix+"tml_cd") = ydNmArr[0];
		}
	}
	
	/**
     * CLPT_SEQ 순차적으로 다시 생성
     * @param sheetObj
     * @return
     */
    function resetClptSeq(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var prefix = sheetObj.id + "_";
    	var idx = 0;
    	var vIbFlag = "";
    	
    	for(var i=0; i<rowCnt; i++){
//    		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//    			idx++;
//    			sheetObj.CellValue2(i+headCnt, prefix+"clpt_seq") = idx;
//    			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
//    		}
    		
    		if(sheetObj.RowStatus(i+headCnt) != "D"){
    			vIbFlag = sheetObj.RowStatus(i+headCnt);
    			idx++;
    			sheetObj.CellValue2(i+headCnt, prefix+"clpt_seq") = idx;
    			sheetObj.RowStatus(i+headCnt) = vIbFlag;
    		}
    	}
    }
    
    /**
     * CLPT_IND_SEQ 다시 생성
     * @param sheetObj
     * @return
     */
    function resetClptIndSeq(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var prefix = sheetObj.id + "_";
    	var idx = 0;
    	var vIbFlag = "";
    	var preVvd = "";
    	var curVvd = "";
    	
    	for(var i=0; i<rowCnt; i++){
    		idx = 0;
//    		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
    		if(sheetObj.RowStatus(i+headCnt) != "D"){
	    		for(var j=0; j<=i; j++){
//	    			if(sheetObj.CellValue(j+headCnt, prefix+"ibflag") != "D"){
	    			if(sheetObj.RowStatus(j+headCnt) != "D"){
	    				if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == sheetObj.CellValue(j+headCnt, prefix+"vvd")){
	    					if(sheetObj.CellValue(i+headCnt, prefix+"vps_port_cd") == sheetObj.CellValue(j+headCnt, prefix+"vps_port_cd")){
	    						idx++;
	    					}
	    				}
	    			}
	    		}//end for
//	    		vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//    			sheetObj.CellValue2(i+headCnt, prefix+"new_clpt_ind_seq") = idx;
//    			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
	    		
	    		vIbFlag = sheetObj.RowStatus(i+headCnt);
    			sheetObj.CellValue2(i+headCnt, prefix+"new_clpt_ind_seq") = idx;
    			sheetObj.RowStatus(i+headCnt) = vIbFlag;
    		}
    	}
    }
    
    /**
     * SKIP CALL 입력여부 판단.
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipBtnSts(sheetObj, Row){
    	var prefix = sheetObj.id + "_";
    	
    	//Virtual Port Add Call 막음.
		var turnPortSts = sheetObj.CellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.CellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		//Actual 이 들어온 이전 Port 모두 막음.
		if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		
		//Skip 이 되어 있는 Port 막음.
		if(sheetObj.CellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
			return false;
		}
		
		return true;
    }
    
    /**
     * port_skd_sts_cd 로 SKIP CALL 입력여부 판단.
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipPortSts(sheetObj, Row){
		var portSts = sheetObj.CellValue(Row, sheetObj.id+"_port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}
		
		return true;
    }
    
    /**
     * port_skd_sts_cd 로 ADD CALL 입력여부 판단.
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddPortSts(sheetObj, Row){
    	if(Row != sheetObj.LastRow){
    		var portSts = sheetObj.CellValue(Row+1, sheetObj.id+"_port_skd_sts_cd");
    		if(portSts == "A" || portSts == "B" || portSts == "D"){
    			return false;
    		}
    	}
		
		return true;
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
    
    /**
     * Add Call 시 position(befor or after) flag 설정.
     * @param sheetObj
     * @return
     */
    function isAddPositionFlag(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var sRow = sheetObj.SelectRow;
    	
    	if(sheetObj.LastRow == sRow){
    		//Virtual Port Add Call 막음.
			var turnPortSts = sheetObj.CellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts = sheetObj.CellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
			}
    	}else{
    		//Virtual Port Add Call 막음.
    		var turnPortSts = sheetObj.CellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts = sheetObj.CellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
				
				var afTurnPortSts = sheetObj.CellValue(sRow+1, prefix+"turn_port_ind_cd");
				if(afTurnPortSts == "F" || afTurnPortSts == "V" || afTurnPortSts == "D"){
					return "A";
				}
			}
    	}
		
		//Actual 이 들어온 Port 막음.
		var portSts = sheetObj.CellValue(sRow, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return "B";
		}else if(sheetObj.CellValue(sRow, prefix+"act_inp_flg") == "Y"){
			return "B";
		}
		
//		// Actual 이 들어온 이전 Port 모두 막음.
//		if(sheetObj.CellValue(sRow, prefix+"bfr_act_flg") == "X"){
//			return "B";
//		}
		return "";
    }
	
	/**
	 * Skip 상태인 Row의 Font Color Setting.
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		
		// sheet1
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"dlay_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_rmk");
		
//		cellFontToBackColor(sheetObj, sRow, prefix+"delay_date");
//		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_dist");
//		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_spd");
//		cellFontToBackColor(sheetObj, sRow, prefix+"tztm_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"act_wrk_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"port_buf_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"sea_buf_hrs");
	}
	
	/**
	 * Sheet의 Font Color를 Back Color로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function cellFontToBackColor(sheetObj, Row, Col){
		sheetObj.CellFontColor(Row, Col) = sheetObj.CellBackColor(Row, Col);
	}
	
	/**
	 * Sheet의 Font Color를 기본 Font Color로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToOriginColor(sheetObj, Row, Col){
		sheetObj.CellFontColor(Row, Col) = sheetObj.RgbColor(0, 0, 0);
	}
	
	/**
	 * 선택된 2개의 Row의 데이타를 맞바꾼다.
	 * @param sheetObj
	 * @return
	 */
	function rowDataChange(sheetObj){
		var prefix = sheetObj.id + "_";
		var sRow = sheetObj.SelectRow;
		var headCnt = sheetObj.HeaderRows;
		
		var selRows = sheetObj.GetSelectionRows("|").split("|");
		if(selRows.length != 2){
			return false;
		}

		// Actual Data Reverse Call 시 Validation.
		if(!isReverseCallActualPort(sheetObj, selRows)){
			return false;
		}
		
		var chgStsCd1 = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
		var chgStsCd2 = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");
		
		//Column Count
		var colCnt = sheetObj.LastCol;
		var tempData = "";
		// 선택된 2개 Row 의 Data 를 바꾼다.
		for(var i=0; i<colCnt; i++){
			if(sheetObj.ColSaveName(i) == prefix+"tml_cd"){
				var sText1 = sheetObj.GetComboInfo(selRows[0], i, "Text");
				var sText2 = sheetObj.GetComboInfo(selRows[1], i, "Text");
				var sCode1 = sheetObj.GetComboInfo(selRows[0], i, "Code");
				var sCode2 = sheetObj.GetComboInfo(selRows[1], i, "Code");
				var sVal1 = sheetObj.CellValue(selRows[0], i);
				var sVal2 = sheetObj.CellValue(selRows[1], i);
				sheetObj.CellComboItem(selRows[0], i, sText2, sCode2);
				sheetObj.CellComboItem(selRows[1], i, sText1, sCode1);
				sheetObj.CellValue2(selRows[0], i) = sVal2;
				sheetObj.CellValue2(selRows[1], i) = sVal1;
			}else{
				tempData = sheetObj.CellValue(selRows[0], i);
				sheetObj.CellValue2(selRows[0], i) = sheetObj.CellValue(selRows[1], i);
				sheetObj.CellValue2(selRows[1], i) = tempData;
			}
		}
		
		// P/F Date 삭제.
		sheetObj.CellValue2(selRows[0], prefix+"pf_eta_dt") = "";
		sheetObj.CellValue2(selRows[0], prefix+"pf_etb_dt") = "";
		sheetObj.CellValue2(selRows[0], prefix+"pf_etd_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_eta_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_etb_dt") = "";
		sheetObj.CellValue2(selRows[1], prefix+"pf_etd_dt") = "";
		
		sheetObj.SelectCell(selRows[1], sheetObj.SelectCol);
		
		//clpt_seq 새로 부여.
		resetClptSeq(sheetObj);
		resetClptIndSeq(sheetObj);
		
//		sheetObj.Redraw = true;
		
		return true;
	}
    
    /**
     * 조회 조건이 아닌 모든 데이타 초기화.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearDescData(sheetObj, formObj, sData){
    	formObj.cre_dt.value = "";
//    	formObj.cre_usr_id.value = "";
    	formObj.upd_dt.value = "";
//    	formObj.upd_usr_id.value = "";
    	
    	formObj.vsl_slan_cd.value = "";
    	
    	if(sData != "skd_rmk"){
    		formObj.skd_rmk.value = "";
    	}
    	
    	sheetObj.RemoveAll();
//    	sheetObj.DataInsert(-1);
    	
    	//All Check 초기화
//    	sheetObj.CheckAll(sheetObj.id+"_del_chk") = 0;
    	
    	initButton(sheetObj);
    }
    
    /**
     * turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
     * 
     * @param sheetObj
     * @return
     */
    function turnEditChange(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		
		//turn_port_flg 가 'Y' 이면서 turn_skd_voy_no 및 turn_skd_dir_cd 가 Null 인 건을 찾아 Edit 가능하게 변경.
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
//				if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
					sheetObj.CellEditable(i, prefix+"turn_skd_voy_no") = true;
					sheetObj.CellEditable(i, prefix+"turn_skd_dir_cd") = true;
//				}
			}
		}
    }
    
    /**
     * ETA, ETB, ETD 정합성(날짜 포맷) 체크
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function isDateValid(sheetObj, Row, Col){
    	var prefix = sheetObj.id + "_";
    	var colName = sheetObj.ColSaveName(Col);
    	var errMsg = "";
    	
    	if(colName == prefix+"vps_eta_dt"){
    		//ETA 에러 메세지
    		errMsg = "(ETA-"+sheetObj.CellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etb_dt"){
			//ETB 에러 메세지
    		errMsg = "(ETB-"+sheetObj.CellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etd_dt"){
			//ETD 에러 메세지
    		errMsg = "(ETD-"+sheetObj.CellValue(Row, Col)+")";
    	}

		//ETA, ETB, ETD 날짜 포맷 검사.
		if(sheetObj.CellValue(Row, Col).length < 12){
			ComShowCodeMessage("VSK01018", errMsg);
			sheetObj.SelectCell(Row, Col);
			return false;
		}else{
			if(!ComIsDate(sheetObj.CellValue(Row, Col).substring(0,8))){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
			if(!ComIsTime(sheetObj.CellValue(Row, Col).substring(8,12), "hm")){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
		}
    	
    	return true;
    }
    
    
	/* 개발자 작업  끝 */