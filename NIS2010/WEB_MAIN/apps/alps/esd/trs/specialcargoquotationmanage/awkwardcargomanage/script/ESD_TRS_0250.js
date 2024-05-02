/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0250.js
*@FileTitle : AWK Cargo Shuttle Basic Tariff Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.05 이혜민
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
	 * @class ESD_TRS_0250 : ESD_TRS_0250 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function ESD_TRS_0250() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;     

    var currCd = "";
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject1 = sheetObjects[0];
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Calendar":
						var cal = new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.year_month, 'yyyy-MM');
					break;
				
				case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);   
					break;
					
				case "btn_Save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);   
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);   
					break;
					
				case "btn_His":
					var selcRow = sheetObject1.SelectRow;	
					var fm_loc_cd = sheetObject1.CellValue(selcRow, "fm_loc_cd");
					var fm_nod_yd_no = sheetObject1.CellValue(selcRow, "fm_nod_yd_no");
					var to_loc_cd = sheetObject1.CellValue(selcRow, "to_loc_cd");
					var to_nod_yd_no = sheetObject1.CellValue(selcRow, "to_nod_yd_no");
					var io_ga_cd = sheetObject1.CellValue(selcRow, "io_ga_cd");
					var trsp_crr_mod_cd = sheetObject1.CellValue(selcRow, "trsp_crr_mod_cd");
					var cond_no = sheetObject1.CellValue(selcRow, "cond_no");
					var sUrl = "/hanjin/ESD_TRS_0251.do?fm_loc_cd="+fm_loc_cd+"&fm_nod_yd_no="+fm_nod_yd_no+"&to_loc_cd="+to_loc_cd+"&to_nod_yd_no="+to_nod_yd_no+"&io_ga_cd="+io_ga_cd+"&trsp_crr_mod_cd="+trsp_crr_mod_cd+"&cond_no="+cond_no+"&trsp_awk_cgo_trf_tp_cd=S";
					ComOpenPopupWithTarget(sUrl, 1020, 575, "", "0,0", true);
					break;	

				case "btn_port":	//Location 조회 팝업
					if(formObject.btn_port.className == ""){
						break;
					}					
					var cnt_cd = "";
					var port_cd = formObject.port_cd.value;
			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.port_cd.value = rVal;
					}					
					break;
				
				case "btn_trfCond":	//tariff condition 조회 팝업	
					var sUrl = "/hanjin/ESD_TES_0057.do?ui_id=ESD_TRS_0250";
					var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
					if(rVal){
						formObject.cond_desc.value = rVal.cond_desc;
						formObject.cond_no.value = rVal.cond_no;
					}
					break;	
					
				case "btn_rowadd":
					var Row = sheetObject1.DataInsert();
					sheetObject1.CellEditable(Row,"chk_flg") = true;
					sheetObject1.CellEditable(Row,"fm_loc_cd") = true;
					sheetObject1.CellEditable(Row,"fm_nod_yd_no") = true;
					sheetObject1.CellEditable(Row,"to_loc_cd") = true;
					sheetObject1.CellEditable(Row,"to_nod_yd_no") = true;
					sheetObject1.CellEditable(Row,"io_ga_cd") = true;
					sheetObject1.CellEditable(Row,"trsp_crr_mod_cd") = true;
					sheetObject1.CellEditable(Row,"man_locl_curr_cd") = true;
					sheetObject1.CellEditable(Row,"man_locl_amt_20ft") = true;
					sheetObject1.CellEditable(Row,"man_locl_amt_40ft") = true;
					sheetObject1.CellEditable(Row,"cond_desc") = true;
					
					sheetObject1.CellValue(Row, "trsp_awk_cgo_trf_tp_cd") = "S";
					sheetObject1.CellValue(Row, "cond_no") = "0";
					sheetObject1.CellValue(Row, "chk_auth_yn") = "Y";
					sheetObject1.CellValue(Row, "act_yd_ofc_auth_yn") = "Y";
					sheetObject1.InitCellProperty(Row , "fm_nod_yd_no", dtCombo);
					sheetObject1.InitCellProperty(Row , "to_nod_yd_no", dtCombo);
					
					break;

				case "btn_rowdelt":
					if(chkDelt(sheetObject1, formObject)){
						ComRowHideDelete(sheetObject1,"chk_flg");
					}
					break;
					
				case "btn_rowcopy":
					var selcRow = sheetObject1.SelectRow;
					if(sheetObject1.CellValue(selcRow, "act_yd_ofc_auth_yn") == "N" || sheetObject1.CellValue(selcRow, "chk_auth_yn") == "N"){
						ComShowCodeMessage('TRS90512'); //No authority to Row copy.
					}else if(sheetObject1.CellValue(selcRow, "io_ga_cd") == "A" && sheetObject1.CellValue(selcRow, "trsp_crr_mod_cd") == "TD" ){
						ComShowCodeMessage('TRS90518'); //Default Data cant be copied.
					}else{
						var Row = sheetObject1.DataInsert();
						sheetObject1.CellValue2(Row, "fm_loc_cd") = sheetObject1.CellValue(selcRow, "fm_loc_cd");
						sheetObject1.CellValue2(Row, "fm_nod_yd_no") = sheetObject1.CellValue(selcRow, "fm_nod_yd_no");
						sheetObject1.CellValue2(Row, "to_loc_cd") = sheetObject1.CellValue(selcRow, "to_loc_cd");
						sheetObject1.CellValue2(Row, "to_nod_yd_no") = sheetObject1.CellValue(selcRow, "to_nod_yd_no");
						sheetObject1.CellValue2(Row, "io_ga_cd") = sheetObject1.CellValue(selcRow, "io_ga_cd");
						sheetObject1.CellValue2(Row, "trsp_crr_mod_cd") = sheetObject1.CellValue(selcRow, "trsp_crr_mod_cd");
						sheetObject1.CellValue2(Row, "man_locl_curr_cd") = sheetObject1.CellValue(selcRow, "man_locl_curr_cd");
						sheetObject1.CellValue2(Row, "man_locl_amt_20ft") = sheetObject1.CellValue(selcRow, "man_locl_amt_20ft");
						sheetObject1.CellValue2(Row, "man_locl_amt_40ft") = sheetObject1.CellValue(selcRow, "man_locl_amt_40ft");
						sheetObject1.CellValue2(Row, "man_usd_amt_20ft") = sheetObject1.CellValue(selcRow, "man_usd_amt_20ft");
						sheetObject1.CellValue2(Row, "man_usd_amt_40ft") = sheetObject1.CellValue(selcRow, "man_usd_amt_40ft");
						sheetObject1.CellValue2(Row, "auto_usd_amt_20ft") = sheetObject1.CellValue(selcRow, "auto_usd_amt_20ft");
						sheetObject1.CellValue2(Row, "auto_usd_amt_40ft") = sheetObject1.CellValue(selcRow, "auto_usd_amt_40ft");
						sheetObject1.CellValue2(Row, "sum_usd_amt_20ft") = sheetObject1.CellValue(selcRow, "sum_usd_amt_20ft");
						sheetObject1.CellValue2(Row, "sum_usd_amt_40ft") = sheetObject1.CellValue(selcRow, "sum_usd_amt_40ft");
						sheetObject1.CellValue2(Row, "calc_rmk") = sheetObject1.CellValue(selcRow, "calc_rmk");
						sheetObject1.CellValue2(Row, "usd_xch_dt") = sheetObject1.CellValue(selcRow, "usd_xch_dt");
						sheetObject1.CellValue2(Row, "cond_desc") = sheetObject1.CellValue(selcRow, "cond_desc");
						sheetObject1.CellValue2(Row, "cond_no") = sheetObject1.CellValue(selcRow, "cond_no");
						sheetObject1.CellValue2(Row, "trsp_awk_cgo_trf_tp_cd") = "S";
						sheetObject1.CellValue2(Row, "chk_auth_yn") = "Y";
						sheetObject1.CellValue2(Row, "act_yd_ofc_auth_yn") = "Y";
						sheetObject1.CellValue2(Row, "ibflag") = "I";
						sheetObject1.CellEditable(Row,"chk_flg") = true;
						sheetObject1.CellEditable(Row,"fm_loc_cd") = true;
						sheetObject1.CellEditable(Row,"fm_nod_yd_no") = true;
						sheetObject1.CellEditable(Row,"to_loc_cd") = true;
						sheetObject1.CellEditable(Row,"to_nod_yd_no") = true;
						sheetObject1.InitCellProperty(Row , "fm_nod_yd_no", dtCombo);
						sheetObject1.InitCellProperty(Row , "to_nod_yd_no", dtCombo);
						sheetObject1.CellEditable(Row,"io_ga_cd") = true;
						sheetObject1.CellEditable(Row,"trsp_crr_mod_cd") = true;
						sheetObject1.CellEditable(Row,"man_locl_curr_cd") = true;
						sheetObject1.CellEditable(Row,"man_locl_amt_20ft") = true;
						sheetObject1.CellEditable(Row,"man_locl_amt_40ft") = true;
						sheetObject1.CellEditable(Row,"cond_desc") = true;
					}
					break;	
			} // end switch		
		}catch(e) {
			if( e == "[object Error]") {
				alert(OBJECT_ERROR);
			} else {
				alert(e);
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
    	var sheetObject1 = sheetObjects[0];
 		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            initControl(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        setYearMonth();
        initCurrCd(sheetObject1);
    }

    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 390;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "FLAG|chk_auth_yn|trsp_awk_cgo_trf_tp_cd||FROM|FROM|TO|TO|IN/OOG|Trans\nMode|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (USD)|Unit Cost Manual (USD)|Unit Cost Auto (USD)|Unit Cost Auto (USD)|Total Handling Cost (USD)|Total Handling Cost (USD)|Tariff Condition|Tariff Condition|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|trsp_act_cost_seq|act_yd_ofc_auth_yn";
                    var HeadTitle2 = "FLAG|chk_auth_yn|trsp_awk_cgo_trf_tp_cd||Port|Tmnl|Port|Tmnl|IN/OOG|Trans\nMode|Curr|20'|40'|20'|40'|20'|40'|20'|40'|ID|Condition Desc|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|trsp_act_cost_seq|act_yd_ofc_auth_yn";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		"chk_auth_yn");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		"trsp_awk_cgo_trf_tp_cd");
					InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	true,		"chk_flg",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				75,		daCenter,	true,		"fm_loc_cd",			true,		"",		dfEngUpKey,		0,		false,		false, 5);
	                InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"fm_nod_yd_no",			true,		"",		dfNone,			0,		false,		false);
	                InitDataProperty(0, cnt++ , dtData,				75,		daCenter,	true,		"to_loc_cd",			true,		"",		dfEngUpKey,		0,		false,		false, 5);
	                InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"to_nod_yd_no",			true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			65,		daCenter,	true,		"io_ga_cd",				true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			70,		daCenter,	true,		"trsp_crr_mod_cd",		true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		"man_locl_curr_cd",		false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				75,		daRight,	true,		"man_locl_amt_20ft",	false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				75,		daRight,	true,		"man_locl_amt_40ft",	false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		"man_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		"man_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		"auto_usd_amt_20ft",	false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		"auto_usd_amt_40ft",	false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				80,	 	daRight,	true,		"sum_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				80,	 	daRight,	true,		"sum_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"cond_no",				false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtPopup,			300,	daLeft,		true,		"cond_desc",			false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				105,	daLeft,		true,		"calc_rmk",				false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	true,		"lst_upd_usr_id",		false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		"lst_upd_dt",			false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,			40,	 	daCenter,	true,		"usd_xch_dt",			false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,			40,	 	daCenter,	true,		"spcl_cgo_ref_seq",		false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		"trsp_act_cost_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		"act_yd_ofc_auth_yn");

                    CellValue2(2, "trsp_awk_cgo_trf_tp_cd") = "S";
                    InitDataCombo(0, "trsp_crr_mod_cd", "Truck|Water", "TD|WD");
                    InitDataCombo(0, "io_ga_cd", "IN|OOG|Default", "I|O|A");
                    ShowButtonImage = 1;
                    WaitImageVisible = false;
				}
				break;
        }
    }

    function initCurrCd(sheetObj){
	 	var sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
	    var currCd  = ComGetEtcData(sXml,"curr_cd");
	    currCd = " |" + currCd;
	    sheetObj.InitDataCombo(0, "man_locl_curr_cd", currCd, currCd);
    }
         
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var sheetObject1 = sheetObjects[0];
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //조회
				formObj.f_cmd.value = SEARCH;
				formObj.yd_cd.value = formObj.port_cd.value;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				// 권한제어
				afterSearch(sheetObject1);
				ComOpenWait(false);
				break;

			case IBCLEAR:		// 초기화
				formObj.yd_cd.value = "";
				formObj.port_cd.value = "";
				formObj.cond_no.value = "";
				formObj.cond_desc.value = "";
				formObj.curr_cd.value = "";
				formObj.usd_amt.value = "";
				formObj.lcl_amt.value = "";
				formObj.usd_xch_dt.value = "";
				sheetObj.RemoveAll();
				break;
			
			case IBSAVE: //저장
				if(sheetObj.RowCount < 1){
					ComShowCodeMessage('TRS90504'); //There is no contents to save.
					return;
				}
				if(chkSaveAuth(sheetObject1)){
					if(validateForm(sheetObj,formObj,sAction)){
						if(chkDupRow(sheetObject1)){
							ComOpenWait(true);
							calcAppExtCost(sheetObject1);
							var sParam = ComGetSaveString(sheetObject1, false);
							if (sParam == ""){
								ComOpenWait(false);
								ComShowCodeMessage('TRS90504'); //There is no contents to save.
								return;
							} else {
								formObj.f_cmd.value = MULTI;
								sParam = sParam + "&" + FormQueryString(formObj) ;
							}
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSaveXml("ESD_TRS_0250GS.do", sParam);
							ComOpenWait(false);
							sheetObj.LoadSaveXml(sXml);
							// SAVE OK 일 경우 저장된 내용 다시 조회.
							var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
							if(nodeText == "S"){
								ComShowCodeMessage('TRS90511'); //Data saved successfully
								doActionIBSheet(sheetObject1,formObj,IBSEARCH);
							}
						}
					}	
				}	
				break;	
			
			case SEARCH01:		//Port Code 체크
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do", sParam);
				return sXml;
				break;
			
			case SEARCH02:		//Port에 맞는 Terminal 조회
				formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do", sParam);
				return sXml;
				break;	
				
			case SEARCH03:		//Currency 조회
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do", sParam);
				return sXml;
				break;	
				
			case SEARCH04:		//Year, Month 조회
				formObj.f_cmd.value = SEARCH04;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do",sParam);
				return sXml;
				break;
			
			case SEARCH05:		//해당 월 환율적용하여 local amt를 usd amt로 변환
				formObj.f_cmd.value = SEARCH05;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do",sParam);
				var usd_amt = ComGetEtcData(sXml,"usd_amt");
				return usd_amt;
				break;
				
			case SEARCH06:		//sheet에 입력한 Port+Tml Cd 입력 권한 체크
				formObj.f_cmd.value = SEARCH06;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0250GS.do",sParam);
				return sXml;
				break;	
        }
    }

    function initControl() {
    	formObj = document.form;
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    }

	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.year_month.focus();
		    	}
				break; 
		}
	}
    	
	function obj_change(){
		var formObj = document.form;
		
	    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	    var sheetObject1 = sheetObjects[0];
	    /** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "port_cd":
            		formObj.yd_cd.value = "";
	            	formObj.yd_cd.value = formObj.port_cd.value;
	            	var ydCd = formObj.yd_cd.value;
	            	if(ydCd != ""){
						var sXml = doActionIBSheet(sheetObject1, formObj, SEARCH01);
						if(!isCheckPortForm(sheetObject1, formObj, sXml)){
							formObj.port_cd.value = "";
							formObj.port_cd.focus();
						}
	            	}
	            	break;
	        } 
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(e);
			} else {
				alert(e);
			}
		}
	}
    	
    function obj_keypress(){
	  	 var obj = event.srcElement;
	  	 if(obj.dataformat == null) return;
	  	 window.defaultStatus = obj.dataformat;
	  	 
	   	 switch(obj.dataformat) {
	   	 	case "ym": case "ymd":
	   	 		ComKeyOnlyNumber(obj);
	   	 		break;
	   	 }
    }

	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
    	
    function validateForm(sheetObj,formObj,sAction){
    	var headCnt = sheetObj.HeaderRows;
   		for(var i=headCnt; i<=sheetObj.LastRow; i++){
   			if(sheetObj.CellValue(i, "ibflag") != "D"){
	   			if(sheetObj.CellValue(i, "fm_loc_cd") == "" || sheetObj.CellValue(i, "to_loc_cd") == ""){
	   				ComShowCodeMessage('TRS90519', '[Port Code]'); //Port Code is Mandatory item.
	   				return false;
	   			}
	   			if(sheetObj.CellValue(i, "man_locl_amt_20ft") == "" && sheetObj.CellValue(i, "auto_usd_amt_20ft") == ""){
	   				ComShowCodeMessage("TRS90519", "[20ft Unit Cost Manual Amount]"); //20ft Unit Code Manual Amount is Mandatory item.
	   				return false;
	   			}
	   			if(sheetObj.CellValue(i, "man_locl_amt_40ft") == "" && sheetObj.CellValue(i, "auto_usd_amt_40ft") == ""){
	   				ComShowCodeMessage("TRS90519", "[40ft Unit Cost Manual Amount]"); //40ft Unit Code Manual Amount is Mandatory item.
	   				return false;
	       		}
	   			if(sheetObj.CellValue(i, "cond_no") == "0" && sheetObj.CellValue(i, "io_ga_cd") != "A"){
	   				ComShowCodeMessage('TRS90519', '[Tariff Condition]'); //Tariff Condition is Mandatory item.
	   				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 217, 250);
	   				return false;
	   			}
   			}	
   		}
       	return true;
    } 	
   
  	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		var sXml1 = null;
		var colName = sheetObj.ColSaveName(Col);
		formObj.select_row.value = sheetObj.SelectRow;
		formObj.select_col.value = sheetObj.SelectCol;
		if(colName == "fm_loc_cd"){
			if(sheetObj.CellValue(Row, "fm_loc_cd") == ""){
				sheetObj.CellValue(Row, "fm_nod_yd_no") = "";
			}else{
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, "fm_loc_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
					sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH02);
					setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
						}
				}else{
					sheetObj.CellValue2(Row, "fm_loc_cd") = "";
					sheetObj.SelectCell(Row, "fm_loc_cd");
				}
			}	
		}else if(colName == "to_loc_cd"){
			if(sheetObj.CellValue(Row, "to_loc_cd") == ""){
				sheetObj.CellValue(Row, "to_nod_yd_no") = "";
			}else{
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, "to_loc_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
					sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH02);
					setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
						}
				}else{
					sheetObj.CellValue2(Row, "to_loc_cd") = "";
					sheetObj.SelectCell(Row, "to_loc_cd");
				}
			}	
		}else if(colName == "fm_nod_yd_no"){
			if(sheetObj.CellValue(Row, "fm_loc_cd")!= "" && sheetObj.CellValue(Row, "to_loc_cd")!= "" && sheetObj.CellValue(Row, "to_nod_yd_no")!= ""){
				formObj.fm_yd_cd.value = "";
				formObj.fm_yd_cd.value = sheetObj.CellValue(Row, "fm_loc_cd")+ sheetObj.CellValue(Row, "fm_nod_yd_no");
				formObj.to_yd_cd.value = "";
				formObj.to_yd_cd.value = sheetObj.CellValue(Row, "to_loc_cd")+ sheetObj.CellValue(Row, "to_nod_yd_no");
				var flg = doActionIBSheet(sheetObj, formObj, SEARCH06);
				flg = ComGetEtcData(flg, "chk_flg");
				if(flg == "N"){
					ComShowCodeMessage('TRS90515', formObj.fm_yd_cd.value, formObj.to_yd_cd.value); //No authority to create data for From [{?msg1}] To [{?msg2}]
					sheetObj.CellValue2(Row, "fm_loc_cd")= "";
					sheetObj.CellValue2(Row, "fm_nod_yd_no")= "";
					sheetObj.CellValue2(Row, "to_loc_cd")= "";
					sheetObj.CellValue2(Row, "to_nod_yd_no")= "";
				}
			}
		}else if(colName == "to_nod_yd_no"){
			if(sheetObj.CellValue(Row, "to_loc_cd")!= "" && sheetObj.CellValue(Row, "fm_loc_cd")!= "" && sheetObj.CellValue(Row, "fm_nod_yd_no")!= ""){
				formObj.fm_yd_cd.value = "";
				formObj.fm_yd_cd.value = sheetObj.CellValue(Row, "fm_loc_cd")+ sheetObj.CellValue(Row, "fm_nod_yd_no");
				formObj.to_yd_cd.value = "";
				formObj.to_yd_cd.value = sheetObj.CellValue(Row, "to_loc_cd")+ sheetObj.CellValue(Row, "to_nod_yd_no");
				var flg = doActionIBSheet(sheetObj, formObj, SEARCH06);
				flg = ComGetEtcData(flg, "chk_flg");
				if(flg == "N"){
					ComShowCodeMessage('TRS90515', formObj.fm_yd_cd.value, formObj.to_yd_cd.value); //No authority to create data for From [{?msg1}] To [{?msg2}]
					sheetObj.CellValue2(Row, "fm_loc_cd")= "";
					sheetObj.CellValue2(Row, "fm_nod_yd_no")= "";
					sheetObj.CellValue2(Row, "to_loc_cd")= "";
					sheetObj.CellValue2(Row, "to_nod_yd_no")= "";
				}
			}
		}else if(colName == "cond_desc"){
			if(sheetObj.CellValue(Row, "cond_desc") == ""){
				sheetObj.CellValue2(Row, "cond_no") = "0";
			}
		}else if(colName == "man_locl_curr_cd"){
			sheetObj.CellValue2(Row, "man_locl_amt_20ft") = "";
			sheetObj.CellValue2(Row, "man_locl_amt_40ft") = "";
			sheetObj.CellValue2(Row, "man_usd_amt_20ft") = "";
			sheetObj.CellValue2(Row, "man_usd_amt_40ft") = "";
		}else if(colName == "man_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, "man_locl_amt_20ft") == ""){
				sheetObj.CellValue2(Row, "man_usd_amt_20ft") = "";
			}else{
				if(sheetObj.CellValue(Row, "man_locl_curr_cd") == ""){
					ComShowCodeMessage('TRS90516'); //Please enter Currency first.;
					sheetObj.CellValue2(Row, "man_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, "man_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, "man_locl_curr_cd");
    				formObj.usd_amt.value = doActionIBSheet(sheetObj, formObj, SEARCH05);
    				checkUsdConvert();
				}
			}
		}else if(colName == "man_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, "man_locl_amt_40ft") == ""){
				sheetObj.CellValue(Row, "man_usd_amt_40ft") = "";
			}else{
				if(sheetObj.CellValue(Row, "man_locl_curr_cd") == ""){
					ComShowCodeMessage('TRS90516'); //Please enter Currency first.;
					sheetObj.CellValue(Row, "man_locl_amt_40ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, "man_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, "man_locl_curr_cd");
    				formObj.usd_amt.value = doActionIBSheet(sheetObj, formObj, SEARCH05);
    				checkUsdConvert();
				}
			}
		}else if(colName == "io_ga_cd"){
			if(sheetObj.CellValue(Row, "io_ga_cd") == "A"){
				ComShowCodeMessage('TRS90517'); //Not available to select [Default] for new data.
				sheetObj.CellValue2(Row, "io_ga_cd") = "I";
			} 
		}
	}
      	
  	function chkDupRow(sheetObject1){
		var idx = 0;
		var Rows = sheetObject1.ColValueDupRows("fm_loc_cd|fm_nod_yd_no|to_loc_cd|to_nod_yd_no|io_ga_cd|trsp_crr_mod_cd|cond_no", false);
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=''){
			arr_rows = Rows.split(',');
		}
		if(arr_rows != null){
    		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    			sheetObject1.RowFontColor(arr_rows[i]) = sheetObject1.RgbColor(255, 0, 0);
    		}
    		ComShowCodeMessage('TRS90520', 'Data');
    		return false;
		}
		return true;
	}
 
  	function sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "cond_desc"){
			var sUrl = "/hanjin/ESD_TES_0057.do?tml_awk_cgo_trf_tp_cd=S";
			var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
			if(rVal){
				sheetObj.CellValue2(Row, "cond_desc") = rVal.cond_desc;
				sheetObj.CellValue2(Row, "cond_no") = rVal.cond_no;
			}
		}
	}
      	
  	function sheet1_OnClick(sheetObj, row, col, value) {
		var headCnt = sheetObj.HeaderRows;
		if (sheetObj.ColSaveName(col) == "calc_rmk") {
			if(sheetObj.CellValue(row, "chk_auth_yn") == "N" || sheetObj.CellValue(row, "act_yd_ofc_auth_yn") == "N"){
				ComShowMemoPad(sheetObj, null, null, true, 300, 120, 600);
			}else{
				ComShowMemoPad(sheetObj, null, null, false, 300, 120, 600);
			}
  		}
  	}

    function isCheckPortForm(sheetObj, formObj, sXml){
    	var chkPort = ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("TRS90387","[Port Code]"); //This is invalid [Port Code].
			return false;
		}
    }
        
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var tmlCd = ComGetEtcData(xmlStr,"tml_cd");
			tmlCd = "|"+tmlCd;
		if(sheetObj.ColSaveName(Col) == "fm_loc_cd"){
			sheetObj.CellComboItem(Row, "fm_nod_yd_no", tmlCd, tmlCd);
		}else if(sheetObj.ColSaveName(Col) == "to_loc_cd"){
			sheetObj.CellComboItem(Row, "to_nod_yd_no", tmlCd, tmlCd);
		}
	}
    	
	function checkUsdConvert(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		tmp = formObj.usd_amt.value.split('|');
		// unit cost manual 20ft일 경우
		if(tmp[1] == "11"){                               
			sheetObj.CellValue2(tmp[0], "man_usd_amt_20ft") = tmp[2];
			sheetObj.CellValue2(tmp[0], "usd_xch_dt") = tmp[3];
		// unit cost manual 40ft일 경우
		}else if(tmp[1] == "12"){                               
			sheetObj.CellValue2(tmp[0], "man_usd_amt_40ft") = tmp[2];
			sheetObj.CellValue2(tmp[0], "usd_xch_dt") = tmp[3];
    	}
	}
    	
	function setYearMonth(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
		var ym = ComGetEtcData(sXml,"year_month");
		formObj.year_month.value = ym;
	}
    	
	function getChkFlgRow(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "chk_flg") == "1"){
			    var ckrow = i;
			}
		}
		return ckrow;
	}
    
  	function chkSaveAuth(sheetObj) {
		var headCnt = sheetObj.HeaderRows;
		var Row = sheetObj.RowCount;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i , "chk_auth_yn")== "Y" && sheetObj.CellValue(i , "act_yd_ofc_auth_yn")=="Y"){
				return true;
			}
		}
		ComShowCodeMessage('TRS90513'); //No authority to save
		return false;
  	}
	
	function afterSearch(sheetObj){
		var formObj = document.form;
		var headCnt = sheetObj.HeaderRows;
		var Row = sheetObj.RowCount;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			//저장된거면서 수정권한이 있는 거
			if(sheetObj.CellValue(i, "ibflag") != "I" && sheetObj.CellValue(i, "chk_auth_yn") == "Y"){
				sheetObj.CellEditable(i,"chk_flg") = true;
				sheetObj.CellEditable(i,"man_locl_curr_cd") = true;
				sheetObj.CellEditable(i,"man_locl_amt_20ft") = true;
				sheetObj.CellEditable(i,"man_locl_amt_40ft") = true;
				if(sheetObj.CellValue(i, "io_ga_cd") == "A" && sheetObj.CellValue(i, "trsp_crr_mod_cd") == "TD"){
					sheetObj.CellEditable(i, "chk_flg") = false;
				}
			//배치돌린값이면서 수정권한이 있는거	
			}else if(sheetObj.CellValue(i, "ibflag") == "I" && sheetObj.CellValue(i, "act_yd_ofc_auth_yn") == "Y"){
				sheetObj.CellEditable(i,"chk_flg") = true;
				sheetObj.CellEditable(i,"man_locl_curr_cd") = true;
				sheetObj.CellEditable(i,"man_locl_amt_20ft") = true;
				sheetObj.CellEditable(i,"man_locl_amt_40ft") = true;
				sheetObj.CellEditable(i,"cond_desc") = true;
				//Default 값일 경우 
				if(sheetObj.CellValue(i, "io_ga_cd") == "A" && sheetObj.CellValue(i, "trsp_crr_mod_cd") == "TD"){
					sheetObj.CellEditable(i, "chk_flg") = false;
					sheetObj.CellEditable(i,"cond_desc") = false;
				}
			}
		}
	}
	
	function chkDefaultCond(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "ibflag") != "D"){
				if(sheetObj.CellValue(i, "cond_no") == "0" && sheetObj.CellValue(i, "io_ga_cd") != "A"){
	   				ComShowCodeMessage('TRS90519', '[Tariff Condition]'); //Tariff Condition is Mandatory item.
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 217, 250);
					return false;
				}
			}	
		}
		return true;
	}
    	
	function createCondNo(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "cond_no") == ""){
				sheetObj.CellValue(i, "cond_no") = "0";
			}
		}
	}
    
	/**
	 * OOG: Special Cargo 관련된 사항에만 권한 관리 -> 생성/수정/삭제
	 * -> OOG관련 SRC가 많아지면 COTRS.JS로 빼는것을 고려하여 올린다. - FEEDERAGE를 조만간 추가할 것으로 잡혀있으니 나중에 추가시 COTRS에도 반영한다.  
	 **/
	function trs_isAwkSpclAuthOfc(ofc) {
		var auth_ofc = new Array('SELCGS','SELCMB');
		for (var i=0; ofc!=undefined && ofc!=null && ofc!='' && auth_ofc!=null && i<auth_ofc.length; i++){
			if (auth_ofc[i]!=undefined && auth_ofc[i]==ofc){
				return true;
			}
		}
		return false;
	}
	
	function chkDelt(sheetObj, formObj){
		var headCnt = sheetObj.HeaderRows;
//		if(formObj.lg_ofc_cd.value != "SELCGS"){
		if(!trs_isAwkSpclAuthOfc(formObj.lg_ofc_cd.value)){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i, "chk_flg") == "1" && sheetObj.CellValue(i, "spcl_cgo_ref_seq") != ""){
					var fm_yd_cd = sheetObj.CellValue(i, "fm_loc_cd") + sheetObj.CellValue(i, "fm_nod_yd_no");
					var to_yd_cd = sheetObj.CellValue(i, "to_loc_cd") + sheetObj.CellValue(i, "to_nod_yd_no");
					ComShowCodeMessage('TRS90514',fm_yd_cd ,to_yd_cd ); //Not Available to delete From [{?msg1}] and To [{?msg2}] is used as Actual Cost.
					sheetObj.CellValue(i, "chk_flg") = "0";
					return false;
				}
			}
		}
		return true;
	}
    	
	function calcAppExtCost(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "ibflag") == "I" || sheetObj.CellValue(i, "ibflag") == "U"){
				//20ft
				if(sheetObj.CellValue(i, "man_usd_amt_20ft") != ""){
					sheetObj.CellValue(i, "sum_usd_amt_20ft") = sheetObj.CellValue(i, "man_usd_amt_20ft");
				}else if(sheetObj.CellValue(i, "auto_usd_amt_20ft") != ""){
					sheetObj.CellValue(i, "sum_usd_amt_20ft") = sheetObj.CellValue(i, "auto_usd_amt_20ft");
				}
				//40ft
				if(sheetObj.CellValue(i, "man_usd_amt_40ft") != ""){
					sheetObj.CellValue(i, "sum_usd_amt_40ft") = sheetObj.CellValue(i, "man_usd_amt_40ft");
				}else if(sheetObj.CellValue(i, "auto_usd_amt_40ft") != ""){
					sheetObj.CellValue(i, "sum_usd_amt_40ft") = sheetObj.CellValue(i, "auto_usd_amt_40ft");
				}
			}
		}	
	}
    	
	/* 개발자 작업  끝 */