/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0044.js
 *@FileTitle : Receivable Invoice - Container List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.09
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.09.09 장준우
 * 1.0 Creation
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
	 * @class EES_LSE_0044 : EES_LSE_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0044() {
		this.processButtonClick 	= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.sheet1_OnLoadFinish 	= sheet1_OnLoadFinish;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnChange 		= sheet1_OnChange;
		this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;
		this.sheet1_OnValidation 	= sheet1_OnValidation;
		this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
		this.openPopup 				= openPopup;
		this.setPopData_DeliveryLoc = setPopData_DeliveryLoc;
		this.validateForm 			= validateForm;
		this.getCreditCntrNo		= getCreditCntrNo;
	}

	var vRcvRntlNo = "";
	var vInvAgmtNo = "";
	var vInvLstmCd = "";

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
        var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

           	switch(srcName) {
           		case "btn_Retrieve":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					}
                	break;

				case "btn_RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBINSERT);
 					}
                	break;

				case "btn_Delete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");

 						var vTtlInvAmt = 0;
						for(var i = sheetObject1.HeaderRows; i <= sheetObject1.RowCount; i++) {
							if(sheetObject1.RowStatus(i) != "D") {
								vTtlInvAmt += Number(sheetObject1.CellValue(i, "cost_amt"));
								vTtlInvAmt += Number(sheetObject1.CellValue(i, "cr_amt"));
							}
						}
						ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));
 					}
                    break;

                case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;

				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
                    break;

                case "btn_Close":
                	if(formObj.edit_mode.value == "T") {
	                	var opener = window.dialogArguments;
						opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, IBSEARCH_ASYNC09);
						opener.clearForm("inv_isu_dt");
                	}
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
    	var formObj = document.form;

		//전역변수 설정
		vRcvRntlNo = ComGetObjValue(formObj.rcv_rntl_seq);
		vInvAgmtNo = ComGetObjValue(formObj.inv_agmt_seq);
		vInvLstmCd = ComGetObjValue(formObj.inv_lstm_cd);

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

		doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }


  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
		var formObj = document.form;

        switch(sheetID) {
             case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 215;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = (formObj.edit_mode.value == "T");

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    //================================================================================ 보관작업[2010.05.02]
					/*
                    var HeadTitle = "|Sel.|Seq.|* CNTR No.|TP/SZ|AGMT No.|AGMT No.|Term|* Out date|* Out Loc|Rtn date|Rtn Loc|Used\ndays|Charge\nType|Rate|Charge\nAmount|Credit\nAmount|Free\ndays||||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
			        InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,	daCenter,	false,	"seq_no");

					InitDataProperty(0, cnt++ , dtData,      	90, daCenter,  	false,  "cntr_no", 			false,  "", dfEngUpKey,	  	0,  false, 	true, 	11);
					InitDataProperty(0, cnt++ , dtCombo,     	40, daCenter,  	false,  "cntr_tpsz_cd",		false,  "", dfEngUpKey,	  	0, 	false, 	true,	4);

					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"agmt_cty_cd",		false,	"",	dfNone,        	0,	false,	false);

					if(Editable == true) {
					InitDataProperty(0, cnt++ , dtCombo ,		60,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,        	0,	false,	true,	6);
					InitDataProperty(0, cnt++ , dtCombo,		40,	daCenter,	false,	"lstm_cd",			false,	"",	dfNone,        	0,	false,	false);
					} else {
					InitDataProperty(0, cnt++ , dtData ,		60,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,        	0,	false,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"lstm_cd",			false,	"",	dfNone,        	0,	false,	false);
					}

					InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"onh_dt",			false,	"",	dfDateYmd,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtPopupEdit,	70,	daCenter,	false,	"onh_loc_cd",		false,	"",	dfEngUpKey,		0,	true,	true, 	5);
					InitDataProperty(0,	cnt++,	dtData,			75,	daCenter,	false,	"offh_dt",			false,	"",	dfDateYmd,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtPopupEdit,	60,	daCenter,	false,	"offh_loc_cd",		false,	"",	dfEngUpKey,		0,	true,	true, 	5);

		            InitDataProperty(0,	cnt++,	dtData,			55,	daRight,	false,	"bil_dys",			false,	"",	dfInteger,		0,	true,	true, 	4);
		            InitDataProperty(0,	cnt++,	dtCombo,		50,	daCenter,	false,	"lse_rcv_chg_tp_cd",false,	"",	dfNone,			0,	false,	true);
		            InitDataProperty(0,	cnt++,	dtData,			50,	daRight,	false,	"chg_rt_amt",		false,	"",	dfFloat,		2,	false,	true,	10);
		            InitDataProperty(0,	cnt++,	dtData,			75,	daRight,	false,	"cost_amt",			false,	"",	dfFloat,		2,	true,	true,	10);
		            InitDataProperty(0,	cnt++,	dtData,			75,	daRight,	false,	"cr_amt",			false,	"",	dfFloat,		2,	true,	true,	10);
		            InitDataProperty(0,	cnt++,	dtData,			45,	daRight,	false,	"free_dys",			false,	"",	dfInteger,		0,	true,	true, 	4);

		            InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"cost_yrmon",   	false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"rcv_rntl_seq",		false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"rcv_rntl_dtl_seq",	false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"lse_rcv_chg_cre_cd",false,	"",	dfNone);

					InitDataCombo(0, "lse_rcv_chg_tp_cd", "CRD|PDM|DPP|PUC|PCR|LON|LOF", "CRD|PDM|DPP|PUC|PCR|LON|LOF");
					InitDataCombo(0, "rcv_rntl_seq",  vRcvRntlNo, vRcvRntlNo);
					InitDataCombo(0, "agmt_seq",	  vInvAgmtNo, vInvAgmtNo);
					InitDataCombo(0, "lstm_cd",  	  vInvLstmCd, vInvLstmCd);

					var vRcvRntlNo = "";
					InitDataValid(0, "cntr_no",			vtEngUpOther, "0123456789");
					InitDataValid(0, "onh_loc_cd",		vtEngUpOnly);
					InitDataValid(0, "offh_loc_cd",		vtEngUpOnly);

					CellFontColor(0,"cntr_no") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0,"onh_dt") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0,"onh_loc_cd") = LSE_MANDATORY_FONT_COLOR;
					*/
					//===================================================================================================
					var HeadTitle = "|Sel.|Seq.|* CNTR No.|TP/SZ|AGMT No.|AGMT No.|Term|Out date|Out Loc|Rtn date|Rtn Loc|Used\ndays|Charge\nType|Rate|Charge\nAmount|Credit\nAmount|Free\ndays||||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
			        InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,	daCenter,	false,	"seq_no");

					InitDataProperty(0, cnt++ , dtData,      	90, daCenter,  	false,  "cntr_no", 			false,  "", dfEngUpKey,	  	0,  false, 	true, 	11);
					InitDataProperty(0, cnt++ , dtCombo,     	40, daCenter,  	false,  "cntr_tpsz_cd",		false,  "", dfEngUpKey,	  	0, 	false, 	true,	4);

					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"agmt_cty_cd",		false,	"",	dfNone,        	0,	false,	false);

					if(Editable == true) {
					InitDataProperty(0, cnt++ , dtCombo ,		60,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,        	0,	false,	true,	6);
					InitDataProperty(0, cnt++ , dtCombo,		40,	daCenter,	false,	"lstm_cd",			false,	"",	dfNone,        	0,	false,	false);
					} else {
					InitDataProperty(0, cnt++ , dtData ,		60,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,        	0,	false,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"lstm_cd",			false,	"",	dfNone,        	0,	false,	false);
					}

					InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"onh_dt",			false,	"",	dfDateYmd,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtPopupEdit,	70,	daCenter,	false,	"onh_loc_cd",		false,	"",	dfEngUpKey,		0,	false,	false, 	5);
					InitDataProperty(0,	cnt++,	dtData,			75,	daCenter,	false,	"offh_dt",			false,	"",	dfDateYmd,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtPopupEdit,	60,	daCenter,	false,	"offh_loc_cd",		false,	"",	dfEngUpKey,		0,	false,	false, 	5);

		            InitDataProperty(0,	cnt++,	dtData,			55,	daRight,	false,	"bil_dys",			false,	"",	dfInteger,		0,	false,	false, 	4);
		            InitDataProperty(0,	cnt++,	dtCombo,		50,	daCenter,	false,	"lse_rcv_chg_tp_cd",false,	"",	dfNone,			0,	false,	false);
		            InitDataProperty(0,	cnt++,	dtData,			50,	daRight,	false,	"chg_rt_amt",		false,	"",	dfFloat,		2,	false,	false,	10);
		            InitDataProperty(0,	cnt++,	dtData,			75,	daRight,	false,	"cost_amt",			false,	"",	dfFloat,		2,	false,	false,	10);
		            InitDataProperty(0,	cnt++,	dtData,			75,	daRight,	false,	"cr_amt",			false,	"",	dfFloat,		2,	false,	true,	10);
		            InitDataProperty(0,	cnt++,	dtData,			45,	daRight,	false,	"free_dys",			false,	"",	dfInteger,		0,	false,	false, 	4);

		            InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"cost_yrmon",   	false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"rcv_rntl_seq",		false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"rcv_rntl_dtl_seq",	false,	"",	dfNone);
		            InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"lse_rcv_chg_cre_cd",false,	"",	dfNone);

					InitDataCombo(0, "lse_rcv_chg_tp_cd", "CRD|PDM|DPP|PUC|PCR|LON|LOF", "CRD|PDM|DPP|PUC|PCR|LON|LOF");
					InitDataCombo(0, "rcv_rntl_seq",  vRcvRntlNo, vRcvRntlNo);
					InitDataCombo(0, "agmt_seq",	  vInvAgmtNo, vInvAgmtNo);
					InitDataCombo(0, "lstm_cd",  	  vInvLstmCd, vInvLstmCd);

					var vRcvRntlNo = "";
					InitDataValid(0, "cntr_no",			vtEngUpOther, "0123456789");
					InitDataValid(0, "onh_loc_cd",		vtEngUpOther, "0123456789");
					InitDataValid(0, "offh_loc_cd",		vtEngUpOther, "0123456789");

					CellFontColor(0,"cntr_no") = LSE_MANDATORY_FONT_COLOR;

					SelectBackColor = LSE_SELECT_BACK_COLOR;
					//SelectionMode = 0;
					//MultiSelection = true;
 					CountPosition = 0;
				}
				break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCREATE: 	//Container Type/Size Grid Combo Item Setting
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;

				if(sXml != "") {
					sheetObj.InitDataCombo(0, "cntr_tpsz_cd", ComGetEtcData(sXml, "cntr_tpsz_nm"), ComGetEtcData(sXml, "cntr_tpsz_cd"));
				}
				break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("EES_LSE_0044GS.do",FormQueryString(formObj));
				}
				break;

			case IBINSERT:			// 입력
				if(validateForm(sheetObj, formObj, sAction)) {
					var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(Row,"agmt_cty_cd") = "HHO";
		            sheetObj.CellValue2(Row,"cost_yrmon") = ComGetObjValue(formObj.cost_yrmon);
		            sheetObj.CellValue2(Row,"lse_rcv_chg_cre_cd") = "A";
		            sheetObj.CellValue2(Row,"rcv_rntl_seq") = vRcvRntlNo.split("|")[0];
					sheetObj.SelectCell(Row,"agmt_seq");

					sheetObj.CellEditable(Row, "cntr_no") = false;
					sheetObj.CellEditable(Row, "cntr_tpsz_cd") = false;
					sheetObj.CellEditable(Row, "cost_amt") = false;
					sheetObj.CellValue2(Row,"cntr_no") = getCreditCntrNo(sheetObj, Row);
					sheetObj.CellValue2(Row,"cntr_tpsz_cd") = "BX";
				}
				break;

			case IBSAVE:		//저장
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("EES_LSE_0044GS.do", FormQueryString(formObj), -1, false);
				}
				break;

        }
    }

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "cntr_no":
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH02
 								 + "&cntr_no="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_0027GS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "cntr_no") != undefined) {
				 				if (ComGetEtcData(sXml, "cntr_no") != "") {
				 					CellValue2(Row,"cntr_no") 	   = ComGetEtcData(sXml, "cntr_no");
				 					CellValue2(Row,"cntr_tpsz_cd") = ComGetEtcData(sXml, "cntr_tpsz_cd");
		 						}
 							} else {
 								CellValue2(Row,"cntr_tpsz_cd") = "D2";
 							}
 						}
					}
					break;
				case "agmt_seq":
					var index = GetComboInfo(Row, "agmt_seq", "SelectedIndex");
					CellValue2(Row,"lstm_cd") 	   = vInvLstmCd.split("|")[index];
					CellValue2(Row,"rcv_rntl_seq") = vRcvRntlNo.split("|")[index];
					break;

				case "onh_loc_cd":		// Grid Location Code Check
				case "offh_loc_cd":		// Grid Location Code Check
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH05
 								 + "&loc_cd=" + CellValue(Row,Col)
 								 + "&loc_tp=SCC";
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "scc_cd") != undefined) {
				 				if (ComGetEtcData(sXml, "scc_cd") != "") {
				 					CellValue2(Row,Col) = ComGetEtcData(sXml, "scc_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01037");
		 							CellValue2(Row,Col) = "";
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								CellValue2(Row,Col) = "";
 								SelectCell(Row,Col);
 							}
 						}
					}
					break;

				case "cost_amt":
					if(Value < 0) {
						CellValue(Row,Col) = 0;
					}

					var vTtlInvAmt = 0;
					for(var i = HeaderRows; i <= RowCount; i++) {
						if(RowStatus(i) != "D") {
							vTtlInvAmt += Number(CellValue(i, "cost_amt"));
							vTtlInvAmt += Number(CellValue(i, "cr_amt"));
						}
					}
					ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));

					break;

				case "cr_amt":
					if(Value > 0) {
						CellValue(Row,Col) = -Number(Value);
					}

					var vTtlInvAmt = 0;
					for(var i = HeaderRows; i <= RowCount; i++) {
						if(RowStatus(i) != "D") {
							vTtlInvAmt += Number(CellValue(i, "cost_amt"));
							vTtlInvAmt += Number(CellValue(i, "cr_amt"));
						}
					}
					ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));

					break;

				case "bil_dys":
				case "free_dys":
					if(Value < 0) {
						CellValue2(Row,Col) = 0;
					}
					break;

				case "lse_rcv_chg_tp_cd":
					var vEditable = /CRD|PDM/.test(Value);

					if(Value == "CRD") {
						CellEditable(Row, "cntr_no") = false;
						CellEditable(Row, "cntr_tpsz_cd") = false;
						CellEditable(Row, "cost_amt") = false;
						CellValue2(Row,"cntr_no") = getCreditCntrNo(sheetObj, Row);
						CellValue2(Row,"cntr_tpsz_cd") = "BX";
						CellValue(Row, "cost_amt") = 0;
					} else {
						CellEditable(Row, "cntr_no") = true;
						CellEditable(Row, "cntr_tpsz_cd") = true;
						CellEditable(Row, "cost_amt") = true;
						CellValue2(Row,"cntr_no") = "";
						CellValue2(Row,"cntr_tpsz_cd") = "D2";
						//CellValue(Row, "cr_amt") = 0;
					}

					if(vEditable == false) {
						CellValue2(Row, "bil_dys")  = 0;
						CellValue2(Row, "free_dys") = 0;
					}

					CellEditable(Row, "bil_dys")  = vEditable;
					CellEditable(Row, "free_dys") = vEditable;
					SelectCell(Row, "cntr_no");
					break;
			}
 		}
 	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "offh_loc_cd":	// Delivery Location Pop-up
				case "onh_loc_cd":
					openPopup("1", Row, Col);
					break;
			}
 		}
    }

    /**
     * 저장처리 전에 유효성 검사를 할수 있도록 발생하는 Event
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		//저장처리 전에 유효성 검사를 할수 있도록 발생하는 이벤트
			if(RowStatus(Row) == "D") return;

    		//필수입력 항목 체크처리
			if(CellValue(Row, "cntr_no") == "") {
				ComShowCodeMessage("LSE01064");
				ValidateFail = true;
		        SelectCell(Row, "cntr_no");
				return;
			}
			//================================================================================ 보관작업[2010.05.02]
			/*
			if(CellValue(Row, "onh_dt") == "") {
				ComShowCodeMessage("LSE01063");
				ValidateFail = true;
		        SelectCell(Row, "onh_dt");
				return;
			}
			if(CellValue(Row, "onh_loc_cd") == "") {
				ComShowCodeMessage("LSE01046");
				ValidateFail = true;
		        SelectCell(Row, "onh_loc_cd");
				return;
			}
			*/
			//===================================================================================================
    	}
    }

	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		//doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	with(sheetObj) {
			for(var i = HeaderRows; i <= SearchRows; i++) {
				if(formObj.edit_mode.value == "T") {
					var vChargeType = CellValue(i, "lse_rcv_chg_tp_cd");

					if(/PDM/.test(vChargeType) == false) {
						CellEditable(i, "bil_dys")  = false;
						CellEditable(i, "free_dys") = false;
					}
				}

				if(CellValue(i, "cntr_tpsz_cd") == "") {
					CellText(i, "cntr_tpsz_cd") = "BX";
				}
			}
    	}
    }

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', true, false, Row, Col, 0);
    	}
    	return;
    }

  	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				CellValue2(Row, Col) = aryPopupData[0][10]; //SCC
			}
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    			case IBINSERT:		//추가
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}

	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}

        return true;
	}

	/**
	 * Credit Charge Type 의 CNTR No. 구하기.
	 * @param sheetObj
	 * @param rowIdx
	 * @return vCrdCntrNo
	 */
	function getCreditCntrNo(sheetObj, rowIdx) {
		var formObj		= document.form;
		var vCrdMaxSeq	= 0;
		var vCrdCntrNo  = "CRD" + ComReplaceStr(ComGetObjValue(formObj.cost_yrmon), "-", "").substr(2);
		for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
			if ( sheetObj.CellValue(i, "lse_rcv_chg_tp_cd") == "CRD" && i != rowIdx ) {
				var vCrdSeq = ComParseInt(ComLtrim(sheetObj.CellValue(i, "cntr_no").substr(7), "0"));
				if ( vCrdMaxSeq < vCrdSeq ) {
					vCrdMaxSeq = vCrdSeq;
				}
			}
		}
		vCrdCntrNo = vCrdCntrNo + ComLpad((vCrdMaxSeq+1)+"", 4, "0");

		return vCrdCntrNo;
	}
	/* 개발자 작업  끝 */