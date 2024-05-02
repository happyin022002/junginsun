/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0245.js
*@FileTitle : Port Skip Recorder for Statistics
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.26 Jung Jinwoo
* 1.0 Creation
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
	 * @class vop_vsk_0245 : vop_vsk_0245 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0245() {
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
		var sheetObject1 = sheetObjects[0];
		 /*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_ok":
					var prefix = sheetObj.id + "_";
					for(var i=0; i<sheetObject1.LastRow+1; i++){
//						alert(sheetObject1.CellValue(i, prefix+"port_skp_rsn_cd"));
						if(sheetObject1.CellValue(i, prefix+"port_skp_rsn_cd") == "" || sheetObject1.CellValue(i, prefix+"port_skp_rsn_cd") == null){
							ComShowCodeMessage("VSK57027", sheetObject1.CellValue(i, prefix+"vps_port_cd"));
							return false;
						}
					}
					
					var row = sheetObject1.SelectRow;
					var col = sheetObject1.SelectCol;
					
					doReturnValue(sheetObject1, row, col);
					break;

				case "btn_close":
					window.close();
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
		
		parentSkipPort(sheetObjects[0], "OPEN");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
					style.height = 122;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(23, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					var HeadTitle1 = "|VVD|Skip\nPort Code|T/S\nPort Code|Report|Carrier|Force Majeure|Reason|Reason|Reason|Reason";
					var HeadTitle2 = "|VVD|Skip\nPort Code|T/S\nPort Code|Report|Carrier|Force Majeure|Port|Code|Hours|Remark(s)";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					/*
					 * ts_port_cd : VSK_PORT_SKP_HIS.TS_PORT_CD
					 * usd_flg : VSK_PORT_SKP_HIS.USD_FLG
					 * port_skp_tp_cd : VSK_PORT_SKP_HIS.PORT_SKP_TP_CD
					 * 
					 * VSK_PORT_SKP_HIS 삭제 : 2009.06.25
					 */

					//데이터속성    [	ROW, COL,  DATATYPE,   			WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,   	true,   	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	 			80,		daCenter,		true,		prefix+"vvd",		false,	"",		dfNone,			0,			false,		true);

					InitDataProperty(0, cnt++ , dtData,	 			80,		daCenter,		true,		prefix+"vps_port_cd",		false,	"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,		true,		prefix+"ts_port_list",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,		true,		prefix+"usd_flg",			false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,		true,		prefix+"crr_cd",			false,	"",		dfNone,			0,			false,		true);

					InitDataProperty(0, cnt++ , dtCombo,			90,		daCenter,		true,		prefix+"port_skp_tp_cd",	false,	"",		dfNone,			0,			true,		true);

					InitDataProperty(0, cnt++ , dtCombo,			75,		daCenter,		true,		prefix+"rsn_port_list",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			70,		daCenter,		true,		prefix+"port_skp_rsn_cd",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				65,		daCenter,		true,		prefix+"delay_date",		false,	"",		dfFloat,		1,			true,		true,		4);
					InitDataProperty(0, cnt++ , dtData,				95,		daLeft,			true,		prefix+"win_rmk",			false,	"",		dfNone,			0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,			true,		prefix+"vps_rmk",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"vsl_cd",			false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"skd_voy_no",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"skd_dir_cd",		false,	"",		dfNone,			0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"ts_port_cd",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"ts_skd_voy_no",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"ts_skd_dir_cd",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"ts_clpt_ind_seq",	false,	"",		dfNone,			0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"rsn_port_cd",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"rsn_skd_voy_no",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"rsn_skd_dir_cd",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,		prefix+"rsn_clpt_ind_seq",	false,	"",		dfNone,			0,			true,		true);
					
//					InitDataCombo(0, prefix+"usd_flg", "YES|NO", "Y|N");
					InitDataCombo(0, prefix+"port_skp_tp_cd", "YES|NO", "F|I");
					
					ShowButtonImage = 2;
					ImageList(0) = "img/btns_search.gif";
					PopupButtonImage(0, prefix+"vps_rmk") = 0;
					
					CountPosition = 0;
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH;
					
					var sParam = ComGetSaveString(sheetObjects);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0245GS.do", sParam);
					
					setHtmlSheet(sXml, sheetObj);
				}

				break;

		}
	}



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
	
    /**
     * 조회 후 처리로직.
     * @param xmlStr
     * @param sheetObj
     * @return
     */
	function setHtmlSheet(sXml, sheetObj){
		if(sXml == null  || sXml == "") return;

		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		var idx = 0;
		var code = " |" + ComGetEtcData(sXml, "code");
		var code_desc = " |" + ComGetEtcData(sXml, "code_desc");
			
		for(var i=headCnt; i<=totCnt; i++){
			var tsPortCd = " |" + ComGetEtcData(sXml, "ts_port_cd"+idx);
			var tsPortInfo = " \t \t \t |" + ComGetEtcData(sXml, "ts_port_info"+idx);
			
			var reasonPortCd = " |" + ComGetEtcData(sXml, "reason_port_cd"+idx);
			var reasonPortInfo = " \t \t \t |" + ComGetEtcData(sXml, "reason_port_info"+idx);
			
//			sheetObj.CellComboItem(i, prefix+"ts_port_list", tsPortInfo, ComReplaceStr(tsPortInfo, "\t", ""), 2);
			sheetObj.CellComboItem(i, prefix+"rsn_port_list", reasonPortInfo, ComReplaceStr(reasonPortInfo, "\t", ""), 2);
				
			sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
			sheetObj.CellComboItem(i, prefix+"port_skp_rsn_cd", code_desc, code);
			
			idx++;
		}
		parentSkipPort(sheetObj, "");
	}
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	
	function sheet1_OnClick(sheetObj, Row, Col) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"win_rmk"){
//				ComShowMemoPad(sheetObj, Row, Col, false, 120, 160);
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, prefix+"vps_rmk"));
//				if(sheetObj.CellEditable(Row, prefix+"win_rmk") == false){
//					sUrl = sUrl + "&readonly=true";
//				}
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal == ""){
					sheetObj.CellValue2(Row, prefix+"vps_rmk") = rVal;
					sheetObj.CellValue2(Row, prefix+"win_rmk") = rVal.replace(/\n/g, "").replace(/\r/g, "");
				}
			}
		}
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
//			if(colName == prefix+"ts_port_list"){
//				var arrSelText = selectPortCell(sheetObj, Row, Col);
//				
//				sheetObj.CellValue2(Row, prefix+"ts_skd_voy_no") = arrSelText[0];
//				sheetObj.CellValue2(Row, prefix+"ts_skd_dir_cd") = arrSelText[1];
//				sheetObj.CellValue2(Row, prefix+"ts_port_cd") = arrSelText[2];
//				sheetObj.CellValue2(Row, prefix+"ts_clpt_ind_seq") = arrSelText[3];
//			}else 
			if(colName == prefix+"rsn_port_list"){
				var arrSelText = selectPortCell(sheetObj, Row, Col);
				
				sheetObj.CellValue2(Row, prefix+"rsn_skd_voy_no") = arrSelText[0];
				sheetObj.CellValue2(Row, prefix+"rsn_skd_dir_cd") = arrSelText[1];
				sheetObj.CellValue2(Row, prefix+"rsn_port_cd") = arrSelText[2];
				sheetObj.CellValue2(Row, prefix+"rsn_clpt_ind_seq") = arrSelText[3];
			}
		}
	}
	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		
	}
	
	/**
	 * 선택된 T/S Port 및 Reason Port 의 정보를 배열형식으로 리턴.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function selectPortCell(sheetObj, Row, Col){
		var sText = sheetObj.GetComboInfo(Row, Col, "Text");
		var arrText = sText.split("|");
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var arrSelText = arrText[idx].split("\t");
		
		return arrSelText;
	}
		
	/**
	 * 입력받은 ROW의 VVD 정보를 부모창에 리턴한다.
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function doReturnValue(sheetObj, Row, Col){
		comPopupOK();
	}
	
	/**
	 * 부모창의 Skip Port 정보를 가져온다.
	 * @param currSheetObj
	 * @param flag
	 * @return
	 */
	function parentSkipPort(sheetObj, flag){
		var opner = window.dialogArguments;
		var pSheetObj = getParentSheet();
		var pPrefix = pSheetObj.id+"_";
		var pSelRow = pSheetObj.SelectRow;
		
		var prefix = sheetObj.id+"_";
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		
		var skipRows = getSkipPortRows(pSheetObj);
		
		var usdFlg = "N";
		var portSkpTpCd = "I";
		
		if(flag == "OPEN"){
			// Pop up Open 시 Combo Data 가져오기 위한 parameter 값 Setting.
			if(skipRows){
				if(skipRows.length > 0){
					for(var i=0; i<skipRows.length; i++){
						sheetObj.DataInsert(-1);
						
						sheetObj.CellValue2(sheetObj.LastRow, prefix+"vsl_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"vsl_cd");
						sheetObj.CellValue2(sheetObj.LastRow, prefix+"skd_voy_no") = pSheetObj.CellValue(skipRows[i], pPrefix+"skd_voy_no");
						sheetObj.CellValue2(sheetObj.LastRow, prefix+"skd_dir_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"skd_dir_cd");
					}
				}
			}
		}
		else{
			if(skipRows){
				if(skipRows.length > 0){
					for(var i=0; i<skipRows.length; i++){
//						if(pSheetObj.CellValue(skipRows[i], pPrefix+"usd_flg") == "Y"){
//							usdFlg = "Y";
//						}else{
//							usdFlg = "N";
//						}
						if(pSheetObj.CellValue(skipRows[i], pPrefix+"port_skp_tp_cd") == "F"){
							portSkpTpCd = "F";
						}else{
							portSkpTpCd = "I";
						}
						sheetObj.CellValue2(i+headCnt, prefix+"vvd") = pSheetObj.CellValue(skipRows[i], pPrefix+"vvd");
					
						sheetObj.CellValue2(i+headCnt, prefix+"vps_port_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"vps_port_cd");
						var tsPortVal = pSheetObj.CellValue(skipRows[i], pPrefix+"ts_skd_voy_no") 
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"ts_skd_dir_cd")
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"ts_port_cd")
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"ts_clpt_ind_seq");
//						sheetObj.CellValue2(i+headCnt, prefix+"ts_port_list") = tsPortVal;		// 새로 조회한 경우, Skip 에 대한 T/S Port 정보가 Port Code 밖에 없기 때문에 정확한 Port 를 선택해서 보여 줄 수가 없음(임창빈 수석이 정확하지 않아도 된다고 함 - 2010.02.02).

						sheetObj.CellValue2(i+headCnt, prefix+"usd_flg") = usdFlg;

						sheetObj.CellValue2(i+headCnt, prefix+"crr_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"crr_cd");

						sheetObj.CellValue2(i+headCnt, prefix+"port_skp_tp_cd") = portSkpTpCd;

						var rsnPortVal = pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_skd_voy_no") 
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_skd_dir_cd")
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk")
									+ pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_clpt_ind_seq");
						sheetObj.CellValue2(i+headCnt, prefix+"rsn_port_list") = rsnPortVal;	// 새로 조회한 경우, Skip 에 대한 Reason Port 정보가 Port Code 밖에 없기 때문에 정확한 Port 를 선택해서 보여 줄 수가 없음(임창빈 수석이 정확하지 않아도 된다고 함 - 2010.02.02).
						sheetObj.CellValue2(i+headCnt, prefix+"port_skp_rsn_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"port_skp_rsn_cd");
						sheetObj.CellValue2(i+headCnt, prefix+"delay_date") = pSheetObj.CellValue(skipRows[i], pPrefix+"ttl_dlay_hrs");
						sheetObj.CellValue2(i+headCnt, prefix+"win_rmk") = pSheetObj.CellValue(skipRows[i], pPrefix+"vps_rmk").replace(/\n/g, "").replace(/\r/g, "");;
						sheetObj.CellValue2(i+headCnt, prefix+"vps_rmk") = pSheetObj.CellValue(skipRows[i], pPrefix+"vps_rmk");
						
						sheetObj.CellValue2(i+headCnt, prefix+"vsl_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"vsl_cd");
						sheetObj.CellValue2(i+headCnt, prefix+"skd_voy_no") = pSheetObj.CellValue(skipRows[i], pPrefix+"skd_voy_no");
						sheetObj.CellValue2(i+headCnt, prefix+"skd_dir_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"skd_dir_cd");
						
						sheetObj.CellValue2(i+headCnt, prefix+"ts_port_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"ts_port_cd");
						sheetObj.CellValue2(i+headCnt, prefix+"ts_skd_voy_no") = pSheetObj.CellValue(skipRows[i], pPrefix+"ts_skd_voy_no");
						sheetObj.CellValue2(i+headCnt, prefix+"ts_skd_dir_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"ts_skd_dir_cd");
						sheetObj.CellValue2(i+headCnt, prefix+"ts_clpt_ind_seq") = pSheetObj.CellValue(skipRows[i], pPrefix+"ts_clpt_ind_seq");
						sheetObj.CellValue2(i+headCnt, prefix+"rsn_port_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk");
						sheetObj.CellValue2(i+headCnt, prefix+"rsn_skd_voy_no") = pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_skd_voy_no");
						sheetObj.CellValue2(i+headCnt, prefix+"rsn_skd_dir_cd") = pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_skd_dir_cd");
						sheetObj.CellValue2(i+headCnt, prefix+"rsn_clpt_ind_seq") = pSheetObj.CellValue(skipRows[i], pPrefix+"rsn_clpt_ind_seq");
					}
				}
			}
		}
	}
	
	/**
	 * 부모창의 활성화된 Sheet 정보를 가져온다.
	 * @return
	 */
	function getParentSheet(){
		var opner = window.dialogArguments;
		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 1){
				for(var i=0; i<opner.sheetObjects.length; i++){
					//0015 화면만 적용.
					if(opner.document.form.rdo_tran[0].checked){
						return opner.sheetObjects[0];
					}else{
						return opner.sheetObjects[1];
					}
				}
			}else{
				return opner.sheetObjects[0];
			}
		}
		
		return opner.sheetObjects[0];
	}
	
	/**
	 * Skip이거나 선택한 Row의 정보를 담아 리턴.
	 * @param sheetObj
	 * @return
	 */
	function getSkipPortRows(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		var rowCnt = sheetObj.RowCount;
		var totCnt = sheetObj.LastRow;
		var prefix = sheetObj.id + "_";
		
		var skipRows = new Array();
		var idx = 0;
		
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"
				|| i == sheetObj.SelectRow){
				skipRows[idx] = i;
				idx++;
			}
		}
		
		return skipRows;
	}
	/* 개발자 작업  끝 */