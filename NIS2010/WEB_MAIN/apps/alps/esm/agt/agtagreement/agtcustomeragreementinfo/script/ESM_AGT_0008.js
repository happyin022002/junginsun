// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var IBREQUEST = 21;
var IBAPPROVAL = 22;
var IBREJECT = 23;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				 case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_request":
				    doActionIBSheet(sheetObject,formObject,IBREQUEST);
				    break;

				case "btn_approval":
				    doActionIBSheet(sheetObject,formObject,IBAPPROVAL);
				    break;

				case "btn_reject":
				    doActionIBSheet(sheetObject,formObject,IBREJECT);
				    break;

				case "btn_uploadexcel":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btng_rowcopy":
					doActionIBSheet(sheetObject,formObject,IBCOPYROW);
					break;

				case "btng_rowadd":
				    doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
	function loadPage( grpTpCode, grpTpText, facDivCode, facDivText, facTpCode, rcvTermCode, delTermCode ) {

		for(i=0;i<sheetObjects.length;i++){
		    //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1, grpTpCode, grpTpText, facDivCode, facDivText, facTpCode, rcvTermCode, delTermCode );
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
//		sheetObjects[0].Visible = false ;
	}

   /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet( sheetObj, sheetNo, grpTpCode, grpTpText, facDivCode, facDivText, facTpCode, rcvTermCode, delTermCode ) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(16) ; // 높이 설정
					SheetWidth = mainTable.clientWidth; //전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
					Editable = true; //전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(60, 5 , 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false, false) ; // 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle  = "Del.|STS|CHK|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|SCOPE|EFF DT|EXP DT|SC No.|RFA No.|Commodity TP|Commodity|Commodity|Type|CHG Type|Rate|Special Rate1|Special Rate1|Special Rate2|Special Rate2|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|CHG|Status|Request ID|Approval ID|Approval DT|Remarks";
					var HeadTitle1 = "Del.|STS|CHK|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|SCOPE|EFF DT|EXP DT|SC No.|RFA No.|Commodity TP|Commodity|Commodity|Type|CHG Type|Rate|CNTR TP|Rate|CNTR TP|Rate|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|CHG|Status|Request ID|Approval ID|Approval DT|Remarks";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,    WIDTH,  DATAALIGN,   COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "delchk",               false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",               false,     "",       dfNone,          0,      false,      true);
					InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,   true,    "check",                false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "",                     false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_fwrd_cnt_cd_seq",     true,      "",       dfNone,          0,      false,      true,       8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     true,    "frt_fwrd_cnt_nm",      false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "shpr_cnt_cd_seq",         false,     "",       dfNone,          0,      true,       true,       8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     true,    "shpr_cnt_nm",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "por_grp_tp_cd",        false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daCenter,   true,    "por_rout_cd",          false,     "",       dfNone,          0,      true,       true,     100);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pol_grp_tp_cd",        false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daCenter,   true,    "pol_rout_cd",          false,     "",       dfNone,          0,      true,       true,     100);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pod_grp_tp_cd",        false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daCenter,   true,    "pod_rout_cd",          false,     "",       dfNone,          0,      true,       true,     100);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "del_grp_tp_cd",        false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daCenter,   true,    "del_rout_cd",          false,     "",       dfNone,          0,      true,       true,     100);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,   true,    "bkg_rcv_term_cd",      false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,   true,    "bkg_de_term_cd",       false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "fac_sgl_flg",          false,     "",       dfNone,          0,      true,       true);

					// 2008.02.19(sunganj) D.F(Double Factor) 추가
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "fac_dbl_flg",          false,     "",       dfNone,          0,      true,       true);

					InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "grs_net_div_cd",       false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   true,    "svc_scp_cd",           false,     "",       dfNone,          0,      true,       true,       3);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fm_eff_dt",            false,     "",       dfDateYmd,       0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "to_eff_dt",            false,     "",       dfDateYmd,       0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "sc_no",                false,     "",       dfNone,          0,      true,       true,      20);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "rfa_no",               false,     "",       dfNone,          0,      true,       true,      11);
					InitDataProperty(0, cnt++ , dtCombo,     100,    daCenter,   true,    "cmdt_tp_cd",           false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "cmdt_cd",              false,     "",       dfNone,          0,      true,       true,       6);
					InitDataProperty(0, cnt++ , dtData,      140,    daLeft,     true,    "cmdt_nm",              false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,     135,    daLeft,     true,    "fac_div_cd",           false,     "",       dfNone,          0,      true,       true);
					//InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,   false,    "fac_tp_cd",            false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,   true,    "fac_tp_cd",            false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bkg_fac_rt",           false,     "",       dfFloat,         3,      true,       true,       15);

					//2008.03.11(sunganj) Double Rate(Special Rate) 추가
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daLeft,     true,    "fac_spcl_cntr_tp_ctnt1",false,     "",       dfNone,          0,      true,       true,       50);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_cntr_rt1",     false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtPopupEdit, 100,    daLeft,     true,    "fac_spcl_cntr_tp_ctnt2",false,     "",       dfNone,          0,      true,       true,       50);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_cntr_rt2",     false,     "",       dfFloat,         3,      true,       true,       15);

					//2009-04-13 (kevin) CURR_CD 추가
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "curr_cd",              false,     "",       dfNone,          0,      true,       true);

					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bkg_fac_bl_amt",       false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_bx_rt",            false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_teu_rt",           false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_feu_rt",           false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_rf_teu_rt",        false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_rf_feu_rt",        false,     "",       dfFloat,         3,      true,       true,       15);

					// 2008.01.25(sunganj) Container Type 2개 추가 : STEU, SFEU
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_teu_rt",      false,     "",       dfFloat,         3,      true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_feu_rt",      false,     "",       dfFloat,         3,      true,       true,       15);

					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     true,    "fac_chg_ctnt",         false,     "",       dfNone,          0,      true,       true,       50);
					InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "comm_proc_sts_cd",     false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     true,    "fac_rqst_usr_id",      false,     "",       dfNone,          0,      false,      false,      20);
					InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     true,    "fac_apro_usr_id",      false,     "",       dfNone,          0,      false,      false,      20);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fac_apro_dt",          false,     "",       dfDateYmd,       0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     true,    "comm_proc_rslt_rsn",   false,     "",       dfNone,          0,      true,        true,    1000);

					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_rt_seq",           false,     "",       dfNone,          0,      false,      true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_ofc_cd",           false,     "",       dfNone,          0,      false,      true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_rqst_usr_eml",     false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_apro_usr_eml",     false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_rqst_usr_name",    false,     "",       dfNone,          0,      false,      true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "cre_usr_id",           false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "cre_dt",               false,     "",       dfNone,          0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "upd_usr_id",           false,     "",       dfNone,          0,      false,      true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "upd_dt",               false,     "",       dfNone,          0,      false,      true);

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0,"por_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pol_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pod_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"del_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"bkg_rcv_term_cd",rcvTermCode,rcvTermCode);
					InitDataCombo (0,"bkg_de_term_cd",delTermCode,delTermCode);
					InitDataCombo (0,"fac_sgl_flg","Y|N","Y|N", "N");
					InitDataCombo (0,"fac_dbl_flg","Y|N","Y|N", "N");
					InitDataCombo (0,"grs_net_div_cd","Y|N","Y|N", "N");
					InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");
					InitDataCombo (0,"curr_cd","USD|EUR","USD|EUR","USD");
					InitDataCombo (0,"fac_div_cd",facDivText,facDivCode);
					InitDataCombo (0,"fac_tp_cd",facTpCode,facTpCode);
                    InitDataCombo (0,"comm_proc_sts_cd","New|Requested|Approved|Rejected","RN|RR|AS|RE");

                    InitDataValid(0, "por_rout_cd", vtEngUpOther, "0123456789*,");	// 영대문자, 숫자, *, 콤마(,) 만 입력되도록 설정
                    InitDataValid(0, "pol_rout_cd", vtEngUpOther, "0123456789*,");	// 영대문자, 숫자, *, 콤마(,) 만 입력되도록 설정
                    InitDataValid(0, "pod_rout_cd", vtEngUpOther, "0123456789*,");	// 영대문자, 숫자, *, 콤마(,) 만 입력되도록 설정
                    InitDataValid(0, "del_rout_cd", vtEngUpOther, "0123456789*,");	// 영대문자, 숫자, *, 콤마(,) 만 입력되도록 설정
                    InitDataValid(0, "svc_scp_cd", vtEngUpOther, "*");	// 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "frt_fwrd_cnt_cd_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정
                    InitDataValid(0, "shpr_cnt_cd_seq", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    //InitDataValid(0, "cmdt_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "cmdt_cd", vtNumericOther, "*");	// 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "fac_chg_ctnt", vtEngUpOther, ","); // 영대문자, 콤마(,) 만 입력되도록 설정

					//CountPosition  = 0 ;
					//style.height = GetSheetHeight(16) ;
					RangeBackColor(1,32,1,35) = RgbColor(222, 251, 248);   // ENIS
    				//HeadRowHeight = 20 ;
    				//HeadRowHeight = 21;
				}
				break;
		}
	}

   /**
	 * Sheet관련 프로세스 처리
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        var newRow = -1;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = SEARCH;
//				alert("ESM_AGT_008GS.do?" + agtQryStr(formObj));
				sheetObj.DoSearch4Post("ESM_AGT_0008GS.do", agtQryStr(formObj));
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
//				alert(sheetObj.CellValue(sheetObj.SelectRow, "por_grp_tp_cd"));
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0008GS.do", agtQryStr(formObj));
				
				if(sheetObj.RowCount == 0){
					return false;
				}else{				
					for(var i=2; i< sheetObj.RowCount+2; i++){
						if(sheetObj.CellValue(i,"ibflag")!="R"){
							break;
						}
						return false;
					}
				}
				
//				formObj.f_cmd.value = SEARCH;
//				alert("ESM_AGT_008GS.do?" + agtQryStr(formObj));
//				sheetObj.DoSearch4Post("ESM_AGT_0008GS.do", agtQryStr(formObj));
				break;

			case IBREQUEST:      //REQUEST
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = MULTI01;
                var cnt = checkData("RR");
                if( cnt > 0 ) {
                    if(ComShowConfirm(ComGetMsg("AGT10023", "Request "+cnt, "request?", "")) == 1) {
                        openStaffInfo(cnt);
                    }
                } else {
                    ComShowCodeMessage("AGT10022", "request.", "", "");
                }
				//sheetObj.DoSave("ESM_AGT_008GS.do", agtQryStr(formObj));
				
				if(sheetObj.RowCount == 0){
					return false;
				}else{
					for(var i=2; i< sheetObj.RowCount+2; i++){
						if(sheetObj.CellValue(i,"ibflag")!="R"){
							break;
						}
						return false;
					}
				}
				
//                formObj.f_cmd.value = SEARCH;
//				alert("ESM_AGT_008GS.do?" + agtQryStr(formObj));
//				sheetObj.DoSearch4Post("ESM_AGT_0008GS.do", agtQryStr(formObj));
				break;

			case IBAPPROVAL:      //APPROVAL
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = MULTI02;
                var cnt = checkData("AS");
                if( cnt > 0 ) {
                    if(ComShowConfirm(ComGetMsg("AGT10023", "Approval "+cnt, "approval?", "")) == 1) {
                        sheetObj.DoSave("ESM_AGT_0008GS.do", agtQryStr(formObj), "check", false);
                    }
                } else {
                    ComShowMessage(ComGetMsg("AGT10022", "approval.", "", ""));
                }
				//sheetObj.DoSave("ESM_AGT_008GS.do", agtQryStr(formObj));
				break;

			case IBREJECT:        //REJECT
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = MULTI03;
                var cnt = checkData("RE");
                if( cnt > 0 ) {
                    if(ComShowConfirm(ComGetMsg("AGT10023", "Reject "+cnt, "reject?", "")) == 1) {
                        sheetObj.DoSave("ESM_AGT_0008GS.do", agtQryStr(formObj), "check", false);
                    }
                } else {
                    ComShowMessage(ComGetMsg("AGT10022", "reject.", "", ""));
                }
				//sheetObj.DoSave("ESM_AGT_008GS.do", agtQryStr(formObj));
				break;

		   case IBLOADEXCEL:      //엑셀 업로드
			  sheetObj.LoadExcel();
			  break;

			case IBDOWNEXCEL:    //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;

			case IBINSERT:       //입력
//        		if(!chkValidSearch()) return false;
				
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}

        		var form1 = document.hiddenF;

				newRow = sheetObj.DataInsert();
				sheetObj.CellValue(newRow, "fac_ofc_cd") = formObj.fac_ofc_cd.value; // 조회 조건의 Office를 fac_ofc_cd로 설정한다.
				sheetObj.CellValue(newRow, "shpr_cnt_cd_seq") = "*";
				sheetObj.CellValue(newRow, "por_rout_cd") = "*";
				sheetObj.CellValue(newRow, "pol_rout_cd") = "*";
				sheetObj.CellValue(newRow, "pod_rout_cd") = "*";
				sheetObj.CellValue(newRow, "del_rout_cd") = "*";
				sheetObj.CellValue(newRow, "svc_scp_cd") = "*";
				sheetObj.CellValue(newRow, "fm_eff_dt") = "20000101";
				sheetObj.CellValue(newRow, "to_eff_dt") = "29991231";
				sheetObj.CellValue(newRow, "sc_no") = "*";
				sheetObj.CellValue(newRow, "rfa_no") = "*";
				sheetObj.CellValue(newRow, "cmdt_cd") = "*";
				//sheetObj.CellValue(newRow, "cmdt_nm") = "*";
				sheetObj.CellValue(newRow, "comm_proc_sts_cd") = "RN";
				sheetObj.CellEditable(newRow, "check") = false;

				setFacDivCd( sheetObj, newRow, "fac_div_cd" );
        		form1.fac_ofc_cd.value = formObj.fac_ofc_cd.value;
        		form1.newRow.value = newRow;
        		form1.f_cmd.value = SEARCH02;
                form1.target = "frmHidden";
                form1.action = "ESM_AGT_0008FR.do";
                form1.submit();


				break;

			case IBCOPYROW:     //행 복사
				newRow = sheetObj.DataCopy();
				setCellData( sheetObj, newRow );
				setCellEditable( sheetObj, newRow );
				setFacDivCd( sheetObj, newRow, "fac_div_cd" );
				checkSglFlg( sheetObj, newRow );
				break;

		}

		//Status에 따른 컬럼별 편집모드 설정
		var mod = formObj.mod.value;
		var rows = sheetObj.RowCount + 2;

		for(var i=2; i<rows; i++){
			sts = sheetObj.CellValue(i,"comm_proc_sts_cd");
			div = sheetObj.CellValue(i,"fac_div_cd");

			sf  = sheetObj.CellValue(i,"fac_sgl_flg");
			df  = sheetObj.CellValue(i,"fac_dbl_flg");
			//ar  = sheetObj.CellValue(i,"grs_net_div_cd");

			if((mod == "Y" && (sts == "RR" || sts == "RN")) || (mod == "N" && sts == "RN")){
				//Approval권한이 있고 NEW이거나 REQUEST일때 편집모드, Approval권안이 없고 NEW일때 편집모드 가능
				sheetObj.CellEditable(i, "shpr_cnt_cd_seq")    = true;
				sheetObj.CellEditable(i, "shpr_cnt_nm")     = true;
				sheetObj.CellEditable(i, "por_grp_tp_cd")   = true;
				sheetObj.CellEditable(i, "por_rout_cd")     = true;
				sheetObj.CellEditable(i, "pol_grp_tp_cd")   = true;
				sheetObj.CellEditable(i, "pol_rout_cd")     = true;
				sheetObj.CellEditable(i, "pod_grp_tp_cd")   = true;
				sheetObj.CellEditable(i, "pod_rout_cd")     = true;
				sheetObj.CellEditable(i, "del_grp_tp_cd")   = true;
				sheetObj.CellEditable(i, "del_rout_cd")     = true;
				sheetObj.CellEditable(i, "bkg_rcv_term_cd") = true;
				sheetObj.CellEditable(i, "bkg_de_term_cd")  = true;
				//sheetObj.CellEditable(i, "fac_sgl_flg")     = true;
				//sheetObj.CellEditable(i, "fac_dbl_flg")     = true;
				sheetObj.CellEditable(i, "grs_net_div_cd")  = true;
				sheetObj.CellEditable(i, "svc_scp_cd")      = true;
				sheetObj.CellEditable(i, "fm_eff_dt")       = true;
				sheetObj.CellEditable(i, "to_eff_dt")       = true;
				sheetObj.CellEditable(i, "sc_no")           = true;
				sheetObj.CellEditable(i, "rfa_no")          = true;
				sheetObj.CellEditable(i, "cmdt_tp_cd")      = true;
				sheetObj.CellEditable(i, "cmdt_cd")         = true;
				sheetObj.CellEditable(i, "cmdt_nm")         = true;
				sheetObj.CellEditable(i, "fac_div_cd")      = true;

				// DF, SF 중 둘중 하나가 Y이면 나머지는 편집불가
				if(sf == "Y"){
				    sheetObj.CellEditable(i, "fac_dbl_flg") = false;
				}else{
				    sheetObj.CellEditable(i, "fac_dbl_flg") = true;
				}

				if(df == "Y"){
				    sheetObj.CellEditable(i, "fac_sgl_flg") = false;
				}else{
				    sheetObj.CellEditable(i, "fac_sgl_flg") = true;
				}


				if ( div == "BA" || div == "BF" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = true;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = false;
	                sheetObj.CellEditable(i, "fac_bx_rt") = false;
	                sheetObj.CellEditable(i, "fac_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = false;

    				sheetObj.CellEditable(i, "curr_cd") = false;
	            } else if( div == "BS" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = true;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = false;
	                sheetObj.CellEditable(i, "fac_bx_rt") = false;
	                sheetObj.CellEditable(i, "fac_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = true;

    				sheetObj.CellEditable(i, "curr_cd") = false;
	            } else if( div == "BL" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = true;
	                sheetObj.CellEditable(i, "fac_bx_rt") = false;
	                sheetObj.CellEditable(i, "fac_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = false;

    				sheetObj.CellEditable(i, "curr_cd") = true;
	            } else if( div == "CA" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = false;
	                sheetObj.CellEditable(i, "fac_bx_rt") = true;
	                sheetObj.CellEditable(i, "fac_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = false;

    				sheetObj.CellEditable(i, "curr_cd") = true;
	            } else if( div == "CS" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = false;
	                sheetObj.CellEditable(i, "fac_bx_rt") = false;
	                sheetObj.CellEditable(i, "fac_teu_rt") = true;
	                sheetObj.CellEditable(i, "fac_feu_rt") = true;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = true;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = true;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = false;

    				sheetObj.CellEditable(i, "curr_cd")         = true;
                } else if( div == "DR" ) {
	                sheetObj.CellEditable(i, "bkg_fac_rt") = false;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = true;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt1") = true;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = true;
	                sheetObj.CellEditable(i, "fac_spcl_cntr_rt2") = true;
	                sheetObj.CellEditable(i, "bkg_fac_bl_amt") = false;
	                sheetObj.CellEditable(i, "fac_bx_rt") = false;
	                sheetObj.CellEditable(i, "fac_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_teu_rt") = false;
	                sheetObj.CellEditable(i, "fac_rf_feu_rt") = false;
	                sheetObj.CellEditable(i, "fac_chg_ctnt") = true;

    				sheetObj.CellEditable(i, "curr_cd") = false;
	            }//if ( div == "BA" || div == "BF" ) {
	            /*
            	if(ar == "Y"){ 
					//FAC Agreement 입력시 "All in rate" 컬럼을 "Y"로 선택하면 Type 부분 수정가능하도록 변경
	            	sheetObj.CellEditable(i, "fac_div_cd") = true;
	            	
	            }
	            */
			}else{
				//편집불가모드
				sheetObj.CellEditable(i, "shpr_cnt_cd_seq")    = false;
				sheetObj.CellEditable(i, "shpr_cnt_nm")     = false;
				sheetObj.CellEditable(i, "por_grp_tp_cd")   = false;
				sheetObj.CellEditable(i, "por_rout_cd")     = false;
				sheetObj.CellEditable(i, "pol_grp_tp_cd")   = false;
				sheetObj.CellEditable(i, "pol_rout_cd")     = false;
				sheetObj.CellEditable(i, "pod_grp_tp_cd")   = false;
				sheetObj.CellEditable(i, "pod_rout_cd")     = false;
				sheetObj.CellEditable(i, "del_grp_tp_cd")   = false;
				sheetObj.CellEditable(i, "del_rout_cd")     = false;
				sheetObj.CellEditable(i, "bkg_rcv_term_cd") = false;
				sheetObj.CellEditable(i, "bkg_de_term_cd")  = false;
				sheetObj.CellEditable(i, "fac_sgl_flg")     = false;
				sheetObj.CellEditable(i, "fac_dbl_flg")     = false;
				sheetObj.CellEditable(i, "grs_net_div_cd")  = false;
				sheetObj.CellEditable(i, "svc_scp_cd")      = false;
				sheetObj.CellEditable(i, "fm_eff_dt")       = false;
				sheetObj.CellEditable(i, "to_eff_dt")       = false;
				sheetObj.CellEditable(i, "sc_no")           = false;
				sheetObj.CellEditable(i, "rfa_no")          = false;
				sheetObj.CellEditable(i, "cmdt_tp_cd")      = false;
				sheetObj.CellEditable(i, "cmdt_cd")         = false;
				sheetObj.CellEditable(i, "cmdt_nm")         = false;
				sheetObj.CellEditable(i, "fac_div_cd")      = false;

				sheetObj.CellEditable(i, "curr_cd")         = false;
			}//if((mod == "Y" && (sts == "RR" || sts == "RN")) || (mod == "N" && sts == "RN")){
				
		}//for(var i=0; i<rows; i++)
			 

	}

	/**
	 * Request Click Event 처리
	 */
    function openStaffInfo( cnt ) {

        document.form.cnt.value = cnt; // Request Count를 셋팅한다.

	    var cust_cd = "";
		var width = 858;
		var height = 554;
		var func = "doRequest";
        var url = "/hanjin/COM_ENS_092.do";

        ComOpenPopup(url, width, height, func, 'none', true);
    }

	/**
	 * Request Click Event 처리
	 */
    function doRequest( rowArray ) {

        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var gubun = ';';
        formObj.recipients_eml.value = ""; // 초기화
        formObj.recipients_name.value = ""; // 초기화
        
    	for(var i=0; i<rowArray.length; i++)
    	{
    		
    		if(i == rowArray.length-1) gubun = '';

    		var colArray = rowArray[i];
    		
    		if(colArray[1] == "1"){
	    	   	formObj.recipients_eml.value += colArray[4] + gubun;
	        	formObj.recipients_name.value += colArray[3] + gubun;
    		}
    	}
        if( formObj.recipients_eml.value.length <= 0) {
            ComShowCodeMessage("AGT10033", "", "", "");
            return false;
        }
	    sheetObj.DoSave("ESM_AGT_0008GS.do", agtQryStr(formObj), "check", false);
    }

    /**
     * 행추가
     */
	function checkData( gubun ){

		var sheetObj = sheetObjects[0];
		var cnt = 0;
		if( gubun == "RE" ) {    // Reject일 경우
			
		    for(var i=1; i<sheetObj.Rows; i++) {
		    	
    		    var check = sheetObj.CellValue(i, "check");
    		    
    		    var sts_cd = sheetObj.CellValue(i, "comm_proc_sts_cd");

    		    if( check == 1 && (sts_cd == "RR" || sts_cd == "AS") ) {
    		        cnt++;
    		    }
		    }

		} else {   // Request/Approval일 경우

		    var sts = "";

		    if( gubun == "RR" ) {
		        sts = "RN";
		    } else if( gubun == "AS" ) {
		        sts = "RR";
		    }

		    for(var i=1; i<sheetObj.Rows; i++) {

    		    var check = sheetObj.CellValue(i, "check");
    		    var sts_cd = sheetObj.CellValue(i, "comm_proc_sts_cd");

    		    if( check == 1 && sts_cd == sts ) {
    		        cnt++;
    		    }

		    }
		}
		return cnt;
	}

    /**
     * 행추가
     */
	function addRowData(){
		var sheetObj = sheetObjects[0];
		var ff_cnt_cd = document.form.cntCd.value;
		var newRow = document.form.newRow.value;
		var ff_cust_nm = "";
        if(ff_cnt_cd != null && ff_cnt_cd.length > 0) {
            ff_cnt_cd = ff_cnt_cd + "999999";
            ff_cust_nm = "REP. CUSTOMER";

    		sheetObj.CellValue2(sheetObj.SelectRow, "frt_fwrd_cnt_cd_seq") = ff_cnt_cd;
    		sheetObj.CellValue2(sheetObj.SelectRow, "frt_fwrd_cnt_nm") = ff_cust_nm;
        }
        setCellEditable( sheetObj, sheetObj.SelectRow );
	}

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;

//        formObj.fac_ofc_cd.value = formObj.fac_ofc_cd.value.toUpperCase();

		if (formObj.fac_ofc_cd.value == "") {
		    ComShowCodeMessage("AGT10001", "Office", "", "");
		    formObj.fac_ofc_cd.focus();
			return false;
		}


		return true;
    }


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){

		with(formObj){
		    if(!chkValidSearch()) return false;
		}

		return true;
	}

	/**
	 * Grid 입력값에 대한 OnChange Event 처리
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {

	    with(sheetObj) {

	        var saveNm = ColSaveName(Col);

            if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
                saveNm=="pod_grp_tp_cd" || saveNm=="del_grp_tp_cd" )
            {
                if(Value == 5) {
                    CellValue2(Row, Col+1) = "";
                    //sheet1_OnPopupClick(sheetObj, Row, Col+1);
                } else {
	                CellValue2(Row, Col+1) = "*";
                }
//                alert(sheetObj.CellValue(Row, "por_grp_tp_cd"));

	        } else if( saveNm == "cmdt_tp_cd" ) {

	            CellValue2(Row, Col+1) = "*";
	            CellValue2(Row, Col+2) = "";

	        } else if( saveNm == "fac_div_cd" ) {

                setFacDivCd( sheetObj, Row, Col );

            } else if ( saveNm == "grs_net_div_cd" ) {

                if( Value == "Y" ) {
                    CellValue(Row, "fac_div_cd") = "BA";
                    CellEditable(Row, "fac_div_cd") = true;
                } else {
                   CellValue(Row, "fac_div_cd") = "BF";
                   CellEditable(Row, "fac_div_cd") = true;
                }

            } else if( ColSaveName(Col) == "frt_fwrd_cnt_cd_seq" ) {

                var form1 = document.hiddenF;

                if( ComTrim(Value) != "" ) {

                   if( checkCustomer(Value) == false ) {
        			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, Col+1) = "";
                       SelectCell(Row, Col);
                   } else {

                       var seq = ComTrim(Value).substring(2);

                       if( seq == 999999 ) {

                           CellValue2(Row, Col+1) = "REP. CUSTOMER";

                       } else {
                           form1.f_cmd.value = SEARCH01;
                           form1.cust_cd.value = ComTrim(Value);
                           form1.row.value = Row;
                           form1.colNm1.value = ColSaveName(Col);
                           form1.colNm2.value = ColSaveName(Col+1);

                           DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       }
                   }

                } else {
                   CellValue2(Row, Col+1) = "";
                }

            } else if( ColSaveName(Col) == "shpr_cnt_cd_seq" ) {

                var form1 = document.hiddenF;

                if( ComTrim(Value) != "" && ComTrim(Value) != "*" ) {

                   if( checkCustomer(Value) == false ) {
        			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, Col+1) = "";
                       SelectCell(Row, Col);
                   } else {

                       var seq = ComTrim(Value).substring(2);

                       if( seq == 999999 ) {

                           CellValue2(Row, Col+1) = "REP. CUSTOMER";

                       } else {
                           form1.f_cmd.value = SEARCH01;
                           form1.cust_cd.value = ComTrim(Value);
                           form1.row.value = Row;
                           form1.colNm1.value = ColSaveName(Col);
                           form1.colNm2.value = ColSaveName(Col+1);

                           DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       }
                   }

                } else {
                   CellValue2(Row, Col+1) = "";
                }
            }

            if( saveNm=="por_rout_cd" || saveNm=="pol_rout_cd" ||
                saveNm=="pod_rout_cd" || saveNm=="del_rout_cd" )
            {
                checkSglFlg( sheetObj, Row );
            }

            // DF == 'Y' 이면 SF == 'Y' 이다.
            if( ColSaveName(Col) == "fac_dbl_flg" ) {
                if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                    //CellValue(Row, "fac_sgl_flg") = "Y";
                    CellEditable(Row, "fac_sgl_flg") = false;
                }else {
                    CellEditable(Row, "fac_sgl_flg") = true;
                }
            }

            // SF 수정시 DF == 'Y' 이면 SF는 항상 'Y'이다.
            if( ColSaveName(Col) == "fac_sgl_flg" ) {
                if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                    //CellValue(Row, "fac_sgl_flg") = "Y";
                    CellEditable(Row, "fac_dbl_flg") = false;
                }else{
                    CellEditable(Row, "fac_dbl_flg") = true;
                }
            }
	    }
	}

	/**
	 * Grid에서 OnPopupClick Event 처리
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {

        var saveNm = sheetObj.ColSaveName(Col);
		var width = 775;
		var height = 482;

    	if ( saveNm=="frt_fwrd_cnt_cd_seq" || saveNm=="shpr_cnt_cd_seq" ) {

    	    var cust_cd = "";
    		var func = "sheet1_setFFCntSeq";
            var display = "1,0,1";
            var url = "COM_ENS_041.do";
            ComOpenPopup(url, width, height, func, display, true, false,Row, Col, 0);

    	} else if( saveNm=="por_rout_cd" || saveNm=="pol_rout_cd" || saveNm=="pod_rout_cd" || saveNm=="del_rout_cd" ) {

    	    var grp_tp = sheetObj.CellValue(Row, Col-1);
//    	    alert(grp_tp);
    		var func = "sheet1_setSheetData2";
            var display = "1,0,1";
            var url = "";
            var rout_ref_div_cd = "";
            var params = "";
            var fac_ofc_cd = "";
            var frt_fwrd_cnt_cd_seq = "";
            var fac_rt_seq = "";
            var row_type = "";
            var rout_info_cd = "";

            if( saveNm=="por_rout_cd" ) {
                rout_ref_div_cd = "PORL";
            } else if( saveNm=="pol_rout_cd" ) {
                rout_ref_div_cd = "POLL";
            } else if( saveNm=="pod_rout_cd" ) {
                rout_ref_div_cd = "PODL";
            } else if( saveNm=="del_rout_cd" ) {
                rout_ref_div_cd = "DELL";
            }

            if( grp_tp == "1" ) {
                width = 306;
    		    height = 382;
                url = "COM_ENS_0H1.do";
            } else if( grp_tp == "2" ) {
                width = 406;
    		    height = 382;
                url = "COM_ENS_0I1.do";
            } else if( grp_tp == "3" ) {
                width = 566;
    		    height = 484;
                url = "COM_ENS_0M1.do";
            } else if( grp_tp == "4" ) {
                width = 526;
    		    height = 454;
                url = "COM_ENS_0J1.do";
            } else if( grp_tp == "5" ) {
                width = 306;
    		    height = 390;
    		    display = "0,1,1";
    		    func = "sheet1_setSheetData4";
                fac_ofc_cd = document.form.fac_ofc_cd.value;
                frt_fwrd_cnt_cd_seq = sheetObj.CellValue(Row, "frt_fwrd_cnt_cd_seq");
                fac_rt_seq = sheetObj.CellValue(Row, "fac_rt_seq");
                row_type = sheetObj.RowStatus(Row);
                rout_info_cd = ComTrim(sheetObj.CellValue(Row, Col));
                params = "?row_type="+row_type+"&fac_ofc_cd="+fac_ofc_cd + "&frt_fwrd_cnt_cd_seq="+frt_fwrd_cnt_cd_seq + "&fac_rt_seq="+fac_rt_seq + "&rout_ref_div_cd="+rout_ref_div_cd + "&rout_info_cd="+rout_info_cd+"&sheet=35";
                url = "ESM_AGT_0035.do"+params;
            } else if( grp_tp == "5" ) {
                url = "COM_ENS_051.do";
            } else {
                if( saveNm == "por_rout_cd" ) {
                    ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
                } else if( saveNm == "pol_rout_cd" ) {
                    ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
                } else if( saveNm == "pod_rout_cd" ) {
                    ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
                } else if( saveNm == "del_rout_cd" ) {
                    ComShowMessage(ComGetMsg("COM12113", "DEL TYPE", "", ""));
                }
                sheetObj.SelectCell ( Row, Col-1 );
                return false;
            }

            ComOpenPopup(url, width, height, func, display, true, false, Row, Col);

    	} else if(saveNm == "cmdt_cd") {

    		var func = "";
            var display = "1,0,1";
            var url = "";
//            var cmdt_tp = ComTrim(sheetObj.CellValue(Row, Col-1));
//            alert("cmdt_tp_cd");
//            alert((sheetObj.CellValue(Row, "cmdt_tp_cd")));
            var cmdt_tp = ComTrim(sheetObj.CellValue(Row, "cmdt_tp_cd"));
            if(cmdt_tp == "2") {
                width = 506;
    		    height = 430;
    		    func = "sheet1_setSheetData";
                url = "COM_ENS_0K1.do";
            } else if(cmdt_tp == "3") {
                width = 775;
    		    height = 482;
    		    func = "sheet1_setSheetData3";
                url = "COM_ENS_011.do";
            } else {
                ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                sheetObj.SelectCell ( Row, Col-1 );
                return false;
            }

            ComOpenPopup(url, width, height, func, display, true, false, Row, Col);
            //ComOpenPopup('/hanjin/COM_ENS_0M1.do?cnt_cd=123&classId=cls', 565, 480, 'setCntInfoInSheet', "1,0,1,1,1,1,1", true, false, 3, 10, 0);


    	} else if(saveNm == "fac_spcl_cntr_tp_ctnt1" || saveNm == "fac_spcl_cntr_tp_ctnt2" ) {

    	    var url = "ESM_AGT_0101.do";
    	    var width = 330;
    	    var height = 390;
    	    var func = "getESM_AGT_0101";
    	    var display = "0,1,1,1,1";    // Row PopUp

    	    var classId = "ESM_AGT_0101";
    	    var sheet = "1";
    	    var chkStr = display.substring(0,3) ;
    	    var fac_spcl_cntr_tp_ctnt = "";

    	     fac_spcl_cntr_tp_ctnt = ComTrim(sheetObj.CellValue(Row, Col));

    	    var param = '?sheet='+sheet+'&classId='+classId+'&fac_spcl_cntr_tp_ctnt='+fac_spcl_cntr_tp_ctnt;


    	    if(chkStr == "0,1") {
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    	    	ComOpenPopup(url + param, width, height, func, display, true, false, Row, Col);
    	    }else {
    	      	ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	    }
    	}
    }

	/**
	 * 저장 버튼 클릭시 유효성검증 프로세스 처리
	 */
	function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;
	    var val = ComTrim(Value);
	    var subValue = "";

	    if(f_cmd == MULTI) { // 저장시에만 체크한다.

        	with(sheetObj) {

        	    var saveNm = ColSaveName(Col);
                var ibStatus = RowStatus(Row);

                if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {

            	    if( saveNm=="frt_fwrd_cnt_cd_seq" ) {
                        if( checkCustomer(val) == false ) {
            			    ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
            			    ValidateFail = true;
                            SelectCell(Row, Col);
                        }
            	    }

            	    if( saveNm=="shpr_cnt_cd_seq" ) {
            	        if( val.length > 0 && val != "*" ) {
                            if( checkCustomer(val) == false ) {
                			    ComShowMessage(ComGetMsg("AGT10017", "Shipper", "", ""));
                			    ValidateFail = true;
                                SelectCell(Row, Col);
                            }
            	        }
            	    }

            	    if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
            	        saveNm=="pod_grp_tp_cd" || saveNm=="del_grp_tp_cd" || saveNm=="cmdt_tp_cd" )
            	    {
            	        if( val.length > 0 && val != "*" ) {
            	            subValue = ComTrim(CellValue(Row, Col+1));
            	            if( subValue == "" || subValue == "*") {
            	                if(saveNm=="por_grp_tp_cd") {
            	                    ComShowMessage(ComGetMsg("AGT10001", "POR", "", ""));
            	                } else if(saveNm=="pol_grp_tp_cd") {
            	                    ComShowMessage(ComGetMsg("AGT10001", "POL", "", ""));
            	                } else if(saveNm=="pod_grp_tp_cd") {
            	                    ComShowMessage(ComGetMsg("AGT10001", "POD", "", ""));
            	                } else if(saveNm=="del_grp_tp_cd") {
            	                    ComShowMessage(ComGetMsg("AGT10001", "DEL", "", ""));
            	                } else if(saveNm=="cmdt_tp_cd") {
            	                    ComShowMessage(ComGetMsg("AGT10001", "Commodity", "", ""));
            	                }
                                ValidateFail = true;
                                SelectCell( Row, Col+1 );
            	            } else {
            	                if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
            	                    saveNm=="pod_grp_tp_cd" || saveNm=="del_grp_tp_cd" )
            	                {
            	                    if(checkSubLength( sheetObj, Row, Col, val ) == false) {
            	                        ValidateFail = true;
            	                        SelectCell( Row, Col+1 );
            	                    }
            	                }
            	            }
            	        }
            	    }
            	    if( saveNm=="fac_div_cd" ) {
            	        /*
            	         * 요율 및 Container 값이 0인 경우도 저장 가능하도록 한다.
                        if(checkFacDivCd( sheetObj, Row, Col, val ) == false) {
                            ValidateFail = true;
                        }
                        */
                        setFacTpCd( sheetObj, Row, Col );
            	    }

            	    if( saveNm == "fac_chg_ctnt"  ) {
            	        var fac_div_cd = CellValue(Row, "fac_div_cd");
                	    if( fac_div_cd == "BS" || fac_div_cd == "DR") { // fac_div_cd 이 'BS', 'DR' 인 경우 Charge를 체크 한다.
                	        if( val != "" ) {
                                if(checkCHG( sheetObj, Row, "fac_chg_ctnt" ) == false) {
                                    ValidateFail = true;
                                    SelectCell( Row, Col );
                                }
                	        }
                        }

                        if( fac_div_cd == "DR") {
                            if(checkManCHG( sheetObj, Row, "fac_chg_ctnt" ) == false) {
                                ValidateFail = true;
                                SelectCell( Row, Col );
                            }
                        }
            	    }
                }
        	}
	    }
	}

    /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setFFCntSeq(rowArray, row, col) {
        var sheetObj = sheetObjects[0];

    	var colArray = rowArray[0];
    	var cnt_cd = colArray[3].substring(0, 2);
    	var cust_seq = colArray[3].substring(2);
    	
    	if(sheetObj.ColSaveName(col) == "frt_fwrd_cnt_cd_seq"){
    		sheetObj.CellValue2(row, "frt_fwrd_cnt_cd_seq") = cnt_cd + ComLpad(cust_seq, 6);
    		sheetObj.CellValue2(row, "frt_fwrd_cnt_nm") = colArray[4];
    	}else if(sheetObj.ColSaveName(col)=="shpr_cnt_cd_seq"){
    		sheetObj.CellValue2(row, "shpr_cnt_cd_seq") = cnt_cd + ComLpad(cust_seq, 6);
    		sheetObj.CellValue2(row, "shpr_cnt_nm") = colArray[4];
    	}
    }

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
    function sheet1_setSheetData(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];
     	sheetObj.CellValue(row, col) = colArray[3];
		sheetObj.CellValue(row, parseInt(col)+1) = colArray[4];
    }

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
    function sheet1_setSheetData2(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];
		sheetObj.CellValue(row, col) = colArray[3];
     	//alert(sheetObj.CellValue(row, col));
    }

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
    function sheet1_setSheetData3(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

     	sheetObj.CellValue(row, col) = colArray[2];
     	sheetObj.CellValue(row, parseInt(col)+1) = colArray[3];
    }

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
    function sheet1_setSheetData4(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];

	    var arrayLen = rowArray.length;
	    var cellVal = "";
		for(var i = 0; i<arrayLen; i++){
		    if(cellVal.length > 0) {
		       cellVal = cellVal + "," + rowArray[i][4];
		    } else {
		        cellVal = rowArray[i][4];
		    }
		}

		sheetObj.CellValue(row, col) = cellVal;
    }

    /**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
    function getESM_AGT_0101(rowArray, row, col) {
    	
	    var sheetObj = sheetObjects[0];

	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    
	    //alert(arrayLen);
		for(var i = 0; i<arrayLen; i++){
		    if(cellVal.length > 0) {
		       cellVal = cellVal + "," + rowArray[i][3];
		    } else {
		        cellVal = rowArray[i][3];
		    }
		}

		//alert(row + ' ' + col);
		sheetObj.CellValue(row, col) = cellVal;
    }

	/**
	 * Office 조회 팝업 열기
	 */
	function openWindowOffice(formObj) {
		var url = "COM_ENS_071.do";
		var width = 775;
		var height = 460;
		var func = "setOffice";
		var display = "1,0,1";
		ComOpenPopup(url, width, height, func, display, true, false);
	}

	/**
	 * Office 조회 후 값 Return 받아 셋팅한다.
	 */
	function setOffice(rowArray, row, col) {
		var colArray = rowArray[0];

		document.form.fac_ofc_cd.value = colArray[3];
	}

	/**
	 * fac_tp_cd 셋팅
	 */
	function setFacTpCd( sheetObj, Row, Col ) {

	    with(sheetObj) {

	        var value = CellValue(Row, Col);

            if ( value == "BA" || value == "BL" || value == "CA" ) {
                CellValue2(Row, "fac_tp_cd") = "ALL";
            } else if( value == "BF" ) {
                 CellValue2(Row, "fac_tp_cd") = "OFT";
            } else if( value == "BS" || value == "CS") {
                CellValue2(Row, "fac_tp_cd") = "SPC";
            }
	    }
	}

	/**
	 * Type(fac_div_cd) 입력시 Format 적용
	 */
	function setFacDivCd( sheetObj, Row, Col ) {

	    with(sheetObj) {

	        var value = CellValue(Row, Col);

	        if ( value == "BA" || value == "BF" ) {

                if( value == "BA" ) {
                    CellValue2(Row, "fac_tp_cd") = "ALL";
                } else {
                    CellValue2(Row, "fac_tp_cd") = "OFT";
                }

                CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                CellValue2(Row, "bkg_fac_bl_amt") = 0;
                CellValue2(Row, "fac_bx_rt") = 0;
                CellValue2(Row, "fac_teu_rt") = 0;
                CellValue2(Row, "fac_feu_rt") = 0;
                CellValue2(Row, "fac_rf_teu_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = 0;
                CellValue2(Row, "fac_chg_ctnt") = "";

                CellEditable(Row, "bkg_fac_rt") = true;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                CellEditable(Row, "bkg_fac_bl_amt") = false;
                CellEditable(Row, "fac_bx_rt") = false;
                CellEditable(Row, "fac_teu_rt") = false;
                CellEditable(Row, "fac_feu_rt") = false;
                CellEditable(Row, "fac_rf_teu_rt") = false;
                CellEditable(Row, "fac_rf_feu_rt") = false;
                CellEditable(Row, "fac_chg_ctnt") = false;
                CellEditable(Row, "fac_spcl_teu_rt") = false;
                CellEditable(Row, "fac_spcl_feu_rt") = false;

                CellEditable(Row, "curr_cd") = false;

            } else if( value == "BS" ) {

                CellValue2(Row, "fac_tp_cd") = "SPC";

                CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                CellValue2(Row, "bkg_fac_bl_amt") = 0;
                CellValue2(Row, "fac_bx_rt") = 0;
                CellValue2(Row, "fac_teu_rt") = 0;
                CellValue2(Row, "fac_feu_rt") = 0;
                CellValue2(Row, "fac_rf_teu_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = 0;

                CellEditable(Row, "bkg_fac_rt") = true;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                CellEditable(Row, "bkg_fac_bl_amt") = false;
                CellEditable(Row, "fac_bx_rt") = false;
                CellEditable(Row, "fac_teu_rt") = false;
                CellEditable(Row, "fac_feu_rt") = false;
                CellEditable(Row, "fac_rf_teu_rt") = false;
                CellEditable(Row, "fac_rf_feu_rt") = false;
                CellEditable(Row, "fac_chg_ctnt") = true;
                CellEditable(Row, "fac_spcl_teu_rt") = false;
                CellEditable(Row, "fac_spcl_feu_rt") = false;

                CellEditable(Row, "curr_cd") = false;

            } else if( value == "BL" ) {

	            CellValue2(Row, "fac_tp_cd") = "ALL";

	            CellValue2(Row, "bkg_fac_rt") = 0;
                CellValue2(Row, "fac_bx_rt") = 0;
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                CellValue2(Row, "fac_teu_rt") = 0;
                CellValue2(Row, "fac_feu_rt") = 0;
                CellValue2(Row, "fac_rf_teu_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = 0;
                CellValue2(Row, "fac_chg_ctnt") = "";

                CellEditable(Row, "bkg_fac_bl_amt") = true;
                CellEditable(Row, "bkg_fac_rt") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                CellEditable(Row, "fac_bx_rt") = false;
                CellEditable(Row, "fac_teu_rt") = false;
                CellEditable(Row, "fac_feu_rt") = false;
                CellEditable(Row, "fac_rf_teu_rt") = false;
                CellEditable(Row, "fac_rf_feu_rt") = false;
                CellEditable(Row, "fac_chg_ctnt") = false;
                CellEditable(Row, "fac_spcl_teu_rt") = false;
                CellEditable(Row, "fac_spcl_feu_rt") = false;

                CellEditable(Row, "curr_cd") = true;

            } else if( value == "CA" ) {

                CellValue2(Row, "fac_tp_cd") = "ALL";
                
                CellValue2(Row, "bkg_fac_rt") = 0;
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                CellValue2(Row, "bkg_fac_bl_amt") = 0;
                CellValue2(Row, "fac_teu_rt") = 0;
                CellValue2(Row, "fac_feu_rt") = 0;
                CellValue2(Row, "fac_rf_teu_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = 0;
                CellValue2(Row, "fac_chg_ctnt") = "";

                CellEditable(Row, "bkg_fac_rt") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                CellEditable(Row, "bkg_fac_bl_amt") = false;
                CellEditable(Row, "fac_bx_rt") = true;
                CellEditable(Row, "fac_teu_rt") = false;
                CellEditable(Row, "fac_feu_rt") = false;
                CellEditable(Row, "fac_rf_teu_rt") = false;
                CellEditable(Row, "fac_rf_feu_rt") = false;
                CellEditable(Row, "fac_chg_ctnt") = false;
                CellEditable(Row, "fac_spcl_teu_rt") = false;
                CellEditable(Row, "fac_spcl_feu_rt") = false;

                CellEditable(Row, "curr_cd") = true;

            } else if( value == "CS" ) {

                CellValue2(Row, "fac_tp_cd") = "SPC";

                CellValue2(Row, "bkg_fac_rt") = 0;
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                CellValue2(Row, "bkg_fac_bl_amt") = 0;
                CellValue2(Row, "fac_bx_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = "";

                CellEditable(Row, "bkg_fac_rt") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                CellEditable(Row, "bkg_fac_bl_amt") = false;
                CellEditable(Row, "fac_bx_rt") = false;
                CellEditable(Row, "fac_teu_rt") = true;
                CellEditable(Row, "fac_feu_rt") = true;
                CellEditable(Row, "fac_rf_teu_rt") = true;
                CellEditable(Row, "fac_rf_feu_rt") = true;
                CellEditable(Row, "fac_chg_ctnt") = false;
                CellEditable(Row, "fac_spcl_teu_rt") = true;
                CellEditable(Row, "fac_spcl_feu_rt") = true;

                CellEditable(Row, "curr_cd") = true;

            } else if( value == "DR" ) {

                CellValue2(Row, "fac_tp_cd") = "SPC";

                CellValue2(Row, "bkg_fac_rt") = 0;
                CellValue2(Row, "bkg_fac_bl_amt") = 0;
                CellValue2(Row, "fac_bx_rt") = 0;
                CellValue2(Row, "fac_rf_feu_rt") = "";

                CellEditable(Row, "bkg_fac_rt") = false;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = true;
                CellEditable(Row, "fac_spcl_cntr_rt1") = true;
                CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = true;
                CellEditable(Row, "fac_spcl_cntr_rt2") = true;
                CellEditable(Row, "bkg_fac_bl_amt") = false;
                CellEditable(Row, "fac_bx_rt") = false;
                CellEditable(Row, "fac_teu_rt") = false;
                CellEditable(Row, "fac_feu_rt") = false;
                CellEditable(Row, "fac_rf_teu_rt") = false;
                CellEditable(Row, "fac_rf_feu_rt") = false;
                CellEditable(Row, "fac_chg_ctnt") = true;
                CellEditable(Row, "fac_spcl_teu_rt") = false;
                CellEditable(Row, "fac_spcl_feu_rt") = false;

                CellEditable(Row, "curr_cd") = false;
            }
	    }
	}

	/**
	 * Type(fac_div_cd) 에 따른 데이타 입력 체크
	 */
	function checkFacDivCd( sheetObj, Row, Col ) {

	    with(sheetObj) {

	        var value = CellValue(Row, Col);

	        if ( value == "BA" || value == "BF" ) { // 반드시 입력

                var bkg_fac_rt = ComTrim(CellValue(Row, "bkg_fac_rt"));
                if(isNaN(bkg_fac_rt)) bkg_fac_rt = "0.000";

                if( Math.floor(bkg_fac_rt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "Rate", "", ""));
                    SelectCell( Row, "bkg_fac_rt" );
                    return false;
                }

            } else if( value == "BS" ) { // 반드시 입력

                var bkg_fac_rt = ComTrim(CellValue(Row, "bkg_fac_rt"));
                var fac_chg_ctnt = ComTrim(CellValue(Row, "fac_chg_ctnt"));

                if(isNaN(bkg_fac_rt)) bkg_fac_rt = "0.000";

                if( Math.floor(bkg_fac_rt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "Rate", "", ""));
                    SelectCell( Row, "bkg_fac_rt" );
                    return false;
                }

                if( fac_chg_ctnt == "" ) {
                    ComShowMessage(ComGetMsg("AGT10001", "CHG", "", ""));
                    SelectCell( Row, "fac_chg_ctnt" );
                    return false;
                } else {
                    if(checkCHG( sheetObj, Row, "fac_chg_ctnt" ) == false) {
                        return false;
                    }
                }

            } else if ( value == "BL" ) { // 반드시 입력

                var bkg_fac_bl_amt = ComTrim(CellValue(Row, "bkg_fac_bl_amt"));
                if(isNaN(bkg_fac_bl_amt)) bkg_fac_bl_amt = "0.000";

                if( Math.floor(bkg_fac_bl_amt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "BL AMT", "", ""));
                    SelectCell( Row, "bkg_fac_bl_amt" );
                    return false;
                }

            } else if( value == "CA" ) { // 반드시 입력

                var fac_bx_rt = ComTrim(CellValue(Row, "fac_bx_rt"));

                if(isNaN(fac_bx_rt)) fac_bx_rt = "0.000";

                if( Math.floor(fac_bx_rt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "Box AMT", "", ""));
                    SelectCell( Row, "fac_bx_rt" );
                    return false;
                }

            } else if( value == "CS" ) { // 셋중에 하나는 반드시 입력

                var fac_teu_rt = ComTrim(CellValue(Row, "fac_teu_rt"));
                var fac_feu_rt = ComTrim(CellValue(Row, "fac_feu_rt"));
                var fac_rf_teu_rt = ComTrim(CellValue(Row, "fac_rf_teu_rt"));
                var fac_rf_feu_rt = ComTrim(CellValue(Row, "fac_rf_feu_rt"));

                if(isNaN(fac_teu_rt)) fac_teu_rt = "0.000";
                if(isNaN(fac_feu_rt)) fac_feu_rt = "0.000";
                if(isNaN(fac_rf_teu_rt)) fac_rf_teu_rt = "0.000";
                if(isNaN(fac_rf_feu_rt)) fac_rf_feu_rt = "0.000";

                if( Math.floor(fac_teu_rt) > 0 || Math.floor(fac_feu_rt) > 0
                 || Math.floor(fac_rf_teu_rt) > 0 || Math.floor(fac_rf_feu_rt) > 0)
                {
                    var flg = true;
                    if( Math.floor(fac_teu_rt) < 0 ) {
                        flg = false;
                    }
                    if( Math.floor(fac_feu_rt) < 0 ) {
                        flg = false;
                    }
                    if( Math.floor(fac_rf_teu_rt) < 0 ) {
                        flg = false;
                    }
                    if( Math.floor(fac_rf_feu_rt) < 0 ) {
                        flg = false;
                    }
                    if(!flg) {
                        ComShowMessage(ComGetMsg("AGT10017", "TEU AMT or FEU AMT or RTEU AMT or RFEU AMT", "", ""));
                        SelectCell( Row, "fac_teu_rt" );
                        return false;
                    }
                } else {
                    ComShowMessage(ComGetMsg("AGT10017", "TEU AMT or FEU AMT or RTEU AMT or RFEU AMT", "", ""));
                    SelectCell( Row, "fac_teu_rt" );
                    return false;
                }
            } else if( value == "DR" ) { // 둘다 입력 체크

                var fac_spcl_cntr_tp_ctnt1  = ComTrim(CellValue(Row, "fac_spcl_cntr_tp_ctnt1"));
                var fac_spcl_cntr_rt1       = ComTrim(CellValue(Row, "fac_spcl_cntr_rt1"));
                var fac_spcl_cntr_tp_ctnt2  = ComTrim(CellValue(Row, "fac_spcl_cntr_tp_ctnt2"));
                var fac_spcl_cntr_rt2       = ComTrim(CellValue(Row, "fac_spcl_cntr_rt2"));
                var fac_chg_ctnt            = ComTrim(CellValue(Row, "fac_chg_ctnt"));

                if(isNaN(fac_spcl_cntr_rt1)) fac_spcl_cntr_rt1 = "0.000";
                if(isNaN(fac_spcl_cntr_rt2)) fac_spcl_cntr_rt2 = "0.000";

                if(fac_spcl_cntr_tp_ctnt1 != "") {
                    if( Math.floor(fac_spcl_cntr_rt1) <= 0  )
                    {
                        ComShowMessage(ComGetMsg("AGT10017", "SPECIAL RATE1", "", ""));
                        SelectCell( Row, "fac_spcl_cntr_rt1" );
                            return false;
                    }
                }

                if(fac_spcl_cntr_tp_ctnt2 != "") {
                    if( Math.floor(fac_spcl_cntr_rt2) <= 0  )
                    {
                        ComShowMessage(ComGetMsg("AGT10017", "SPECIAL RATE2", "", ""));
                        SelectCell( Row, "fac_spcl_cntr_rt2" );
                            return false;
                    }
                }

                if( fac_chg_ctnt == "" ) {
                    ComShowMessage(ComGetMsg("AGT10001", "CHG", "", ""));
                    SelectCell( Row, "fac_chg_ctnt" );
                    return false;
                } else {
                    if(checkCHG( sheetObj, Row, "fac_chg_ctnt" ) == false) {
                        return false;
                    }
                }


            } else {
                ComShowMessage(ComGetMsg("AGT10017", "TEU AMT or FEU AMT or RTEU AMT or RFEU AMT", "", ""));
                SelectCell( Row, "fac_teu_rt" );
                return false;
            }
        }
    }


	/**
	 * CHG 체크
	 */
	function checkCHG( sheetObj, Row, ColNm ) {
	    with(sheetObj) {
	        var value = ComTrim(CellValue(Row, ColNm));

	        var chg_arr = value.split(',');

	        if(chg_arr.length > 0) {
	            for(var i=0; i<chg_arr.length; i++) {
    	            if(chg_arr[i] == "") { // 계산시 문제 발생 가능하므로 ComTrim하지 않고 체크한다.
                        ComShowMessage(ComGetMsg("AGT10017", "CHG", "(ex:OFT,OTH,DTH)", ""));
                        SelectCell( Row, ColNm );
    	                return false;
    	            } else {
    	                if(chg_arr[i].length > 3) {
                            ComShowMessage(ComGetMsg("AGT10020", "(ex:OFT,OTH,DTH)", "", ""));
                            SelectCell( Row, ColNm );
                            return false;
    	                }
    	            }
	            }
	        }
	    }

	    return true;
	}

	/**
	 * CHG 체크
	 */
	function checkManCHG( sheetObj, Row, ColNm ) {
	    with(sheetObj) {
	        var value = ComTrim(CellValue(Row, ColNm));

	        if(value.length <= 0) {
	            ComShowMessage(ComGetMsg("AGT10017", "CHG", "(ex:OFT,OTH,DTH)", ""));
                SelectCell( Row, ColNm );
                return false;
	        }
	    }

	    return true;
	}

	/**
	 * 입력 길이 체크
	 */
	function checkSubLength( sheetObj, Row, Col, Value ) {

	    with(sheetObj) {

    	    Value = ComTrim(Value);

    	    var saveNm = ColSaveName(Col);
    	    var subValue = ComTrim(CellValue(Row, Col+1));

    	    if(Value == "1") {
    	        if(subValue.length > 1) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "1", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "1", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "1", ""));
                    } else if(saveNm=="del_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "DEL", "1", ""));
                    }
                    return false;
    	        }
    	    } else if(Value == "2" || Value == "3") {
    	        if(subValue.length > 2) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "2", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "2", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "2", ""));
                    } else if(saveNm=="del_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "DEL", "2", ""));
                    }
                    return false;
    	        }
    	    } else if( Value == "4") {
    	        if(subValue.length > 3) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "3", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "3", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "3", ""));
                    } else if(saveNm=="del_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "DEL", "3", ""));
                    }
                    return false;
    	        }
    	    } else if(Value == "5") {

    	        var glc_arr = subValue.split(',');
    	        var glc_cd = "";

    	    	if(glc_arr.length > 0) {
    	            for(var i=0; i<glc_arr.length; i++) {
    	                glc_cd = ComTrim(glc_arr[i]);
        	            if(glc_cd == "") {
                            ComShowMessage(ComGetMsg("AGT10017", "G.Location", "", ""));
        	                return false;
        	            } else {
        	                if(glc_cd.length > 6) {
        	                    ComShowMessage(ComGetMsg("COM12173", "G.Location", "6", ""));
                                return false;
        	                }
        	            }
    	            }
    	        }
    	    } else if(Value == "6") {
    	        if(subValue.length > 5) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "5", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "5", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "5", ""));
                    } else if(saveNm=="del_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "DEL", "5", ""));
                    }
                    return false;
    	        }
    	    }
	    }

	    return true;
	}

	/**
	 * Grid에서 Sgl Flg 설정 처리
	 */
    function checkSglFlg( sheetObj, Row ) {
        with (sheetObj) {

            var por_cd = ComTrim(CellValue(Row, "por_rout_cd"));
            var pol_cd = ComTrim(CellValue(Row, "pol_rout_cd"));
            var pod_cd = ComTrim(CellValue(Row, "pod_rout_cd"));
            var del_cd = ComTrim(CellValue(Row, "del_rout_cd"));

            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd == pol_cd && pod_cd == del_cd )
            {
                CellValue2(Row, "fac_sgl_flg") = "N";
                CellEditable(Row, "fac_sgl_flg") = false;
            } else {
                CellEditable(Row, "fac_sgl_flg") = true;
            }

            // 2008.02.19-sunganj : DF 항목 추가
            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd != pol_cd && pod_cd != del_cd )
            {
                CellValue2(Row, "fac_dbl_flg") = "Y";
                CellEditable(Row, "fac_dbl_flg") = true;
            } else {
                CellEditable(Row, "fac_dbl_flg") = false;
            }

        }
    }

    	/**
	 * 행복사시 Grid CellEditable 설정
	 */
	function setCellData( sheetObj, newRow ) {
	    with(sheetObj) {
            CellValue2(newRow, "comm_proc_sts_cd") = "RN";
            CellValue2(newRow, "fac_rqst_usr_id") = "";
            CellValue2(newRow, "fac_apro_usr_id") = "";
            CellValue2(newRow, "comm_proc_rslt_rsn") = "";
            CellValue2(newRow, "fac_rt_seq") = "";
            CellValue2(newRow, "fac_rqst_usr_eml") = "";
            CellValue2(newRow, "fac_apro_usr_eml") = "";
            CellValue2(newRow, "fac_rqst_usr_name") = "";
            CellValue2(newRow, "cre_usr_id") = "";
            CellValue2(newRow, "cre_dt") = "";
            CellValue2(newRow, "upd_usr_id") = "";
            CellValue2(newRow, "upd_dt") = "";
	    }
	}

	/**
	 * 행복사시 Grid CellEditable 설정
	 */
	function setCellEditable( sheetObj, newRow ) {
	    with(sheetObj) {
            CellEditable(newRow, "delchk") = true;
            CellEditable(newRow, "check") = false;
            CellEditable(newRow, "frt_fwrd_cnt_cd_seq") = true;
            CellEditable(newRow, "shpr_cnt_cd_seq") = true;
            CellEditable(newRow, "por_grp_tp_cd") = true;
            CellEditable(newRow, "por_rout_cd") = true;
            CellEditable(newRow, "pol_grp_tp_cd") = true;
            CellEditable(newRow, "pol_rout_cd") = true;
            CellEditable(newRow, "pod_grp_tp_cd") = true;
            CellEditable(newRow, "pod_rout_cd") = true;
            CellEditable(newRow, "del_grp_tp_cd") = true;
            CellEditable(newRow, "del_rout_cd") = true;
            CellEditable(newRow, "bkg_rcv_term_cd") = true;
            CellEditable(newRow, "bkg_de_term_cd") = true;
            CellEditable(newRow, "fac_sgl_flg") = true;
            CellEditable(newRow, "fac_dbl_flg") = true;
            CellEditable(newRow, "grs_net_div_cd") = true;
            CellEditable(newRow, "svc_scp_cd") = true;
            CellEditable(newRow, "fm_eff_dt") = true;
            CellEditable(newRow, "to_eff_dt") = true;
            CellEditable(newRow, "sc_no") = true;
            CellEditable(newRow, "rfa_no") = true;
            CellEditable(newRow, "cmdt_tp_cd") = true;
            CellEditable(newRow, "cmdt_cd") = true;
            CellEditable(newRow, "fac_div_cd") = true;
            CellEditable(newRow, "bkg_fac_rt") = true;
            CellEditable(newRow, "fac_spcl_cntr_tp_ctnt1") = true;
            CellEditable(newRow, "fac_spcl_cntr_rt1") = true;
            CellEditable(newRow, "fac_spcl_cntr_tp_ctnt2") = true;
            CellEditable(newRow, "fac_spcl_cntr_rt2") = true;
            CellEditable(newRow, "fac_bx_rt") = true;
            CellEditable(newRow, "fac_teu_rt") = true;
            CellEditable(newRow, "fac_feu_rt") = true;
            CellEditable(newRow, "fac_rf_teu_rt") = true;
            CellEditable(newRow, "fac_rf_feu_rt") = true;
            CellEditable(newRow, "fac_chg_ctnt") = true;
            CellEditable(newRow, "comm_proc_rslt_rsn") = true;
	    }
	}
	function stsCd_OnChange(){
		var sheetObject = sheetObjects[0];
		sheetObject.RemoveAll();
	}
