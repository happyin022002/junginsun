// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/*
 * IBSheet Action 추가
 */
var IBRATESEARCH = 20; //요율정보 조회

/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3];

    	 /*******************************************************/
    	 var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject4,formObject,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObject1.RemoveAll();
    				sheetObject2.RemoveAll();
    				sheetObject3.RemoveAll();
    				sheetObject4.RemoveAll();
    				formObject.reset();
    				break;

				 case "btn_close":
					self.close();
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
	function loadPage(grpTpCode, grpTpText, facDivCode, facDivText) {
		var formObject = document.form;
		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i+1, grpTpCode, grpTpText, facDivCode, facDivText);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		formObject.bl_no.value = formObject.hdn_bl_no.value;
		formObject.bkg_no.value = formObject.hdn_bkg_no.value;
		doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
	}

    /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo, grpTpCode, grpTpText, facDivCode, facDivText) {

		var cnt = 0;

		switch(sheetNo) {

		    case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(6) ;
					//전체 너비 설정
					SheetWidth = 120;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false) ;

					var HeadTitle = "CHG|AMT";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,   true,    "chg_cd",     false,          "",       dfNone,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      70,    daRight,    true,    "bkg_chg_amt",     false,          "",       dfFloat,        2,     true,       true);

                    RangeBackColor(0,0,0,1) = RgbColor(222, 251, 248);   // ENIS

                    CountPosition  = 0;
				}

				break;

			case 2:      //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(6) ;
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(24, 1 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "CA\nSEQ|BL AMT|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|Prev AMT|Calc Date|Reason|Status|Remark|AR IF DT";
					var HeadTitle1 = "CA\nSEQ|BL AMT|Commission|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|Commission|Prev AMT|Calc Date|Reason|Status|Remark|AR IF DT";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,         			KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "fac_seq",         	false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,   true,    "bl_comm_amt",     	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      100,    daRight,   true,    "act_comm_amt",    	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_bx_qty",      	false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "fac_bx_rt",       	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_teu_qty",     	false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "fac_teu_rt",      	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_feu_qty",     	false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "fac_feu_rt",      	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_rf_teu_qty",  	false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "fac_rf_teu_rt",   	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_rf_feu_qty",  	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "fac_rf_feu_rt",   	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       80,    daRight,   true,    "cntr_comm_amt",   	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,   true,    "act_pre_comm_amt",	false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "cre_dt",          	false,          "",       dfDateYmd,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      200,    daLeft,    true,    "fac_rmk",         	false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "comm_proc_sts_cd",	false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      260,    daLeft,    true,    "comm_proc_rslt_rsn",	false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "fac_if_dt",           false,          "",       dfDateYmd,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "fac_ofc_cd",     		false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_cnt_cd",    		false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_cust_seq",  		false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_rt_seq",    		false,          "",       dfNone,          0,     true,       true);

					RangeBackColor(1,2,1,13) = RgbColor(222, 251, 248);   // ENIS

					CountPosition  = 0 ;

					HeadRowHeight  = 10;
				}
				break;

			case 3:      //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(3) ;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(34, 2 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV TERM|DEL TERM|S.F.|All in Rate|SCOPE|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|CHG";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,    WIDTH,  DATAALIGN,   COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   false,    "seq",                     false,     "",       dfNone,          0,      false,       false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "frt_fwrd_cnt_seq",     false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "frt_fwrd_cnt_nm",      false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "shpr_cnt_seq",         false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_cnt_nm",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "por_grp_tp_cd",        false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,    "por_rout_cd",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,       90,   daCenter,   false,    "pol_grp_tp_cd",        false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,    "pol_rout_cd",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pod_grp_tp_cd",        false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,    "pod_rout_cd",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "del_grp_tp_cd",        false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,    "del_rout_cd",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "bkg_rcv_term_cd",      false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "bkg_de_term_cd",       false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   false,    "fac_sgl_flg",          false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "grs_net_div_cd",       false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "svc_scp_cd",           false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fm_eff_dt",            false,     "",       dfDateYmd,       0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "to_eff_dt",            false,     "",       dfDateYmd,       0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "sc_no",                false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no",               false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,     100,    daCenter,   false,    "cmdt_tp_cd",           false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "cmdt_cd",              false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      140,    daLeft,     false,    "cmdt_nm",              false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,     135,    daCenter,   false,    "fac_div_cd",           false,     "",       dfNone,          0,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "bkg_fac_rt",           false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "bkg_fac_bl_amt",       false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "fac_bx_rt",            false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "fac_teu_rt",           false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "fac_feu_rt",           false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "fac_rf_teu_rt",        false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "fac_rf_feu_rt",        false,     "",       dfFloat,         3,      false,      false);
					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     false,    "fac_chg_ctnt",         false,     "",       dfNone,          0,      false,      false);

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0,"por_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pol_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pod_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"del_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"fac_div_cd",facDivText,facDivCode);
					InitDataCombo (0,"fac_sgl_flg","Y|N","Y|N", "N");
					InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");

					CountPosition  = 0 ;
				}

				break;
			case 4:      //sheet3 init
				with (sheetObj) {
					// 높이 설정
//					style.height = GetSheetHeight(3) ;
					//전체 너비 설정
//					SheetWidth = mainTable2.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 2 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
//					InitHeadMode(true, true, false, true, false,false) ;

//					var HeadTitle = "SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,        30,    daCenter,   false,   "vsl_dep_dt",                 false,    "",         dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "bkg_no",   			  false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "bl_no",    false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "shpr_cnt_seq",        false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_nm",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "frt_fwrd_cnt_seq",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "frt_fwrd_nm",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "comm_vsl",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "bkg_por_cd",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_pol_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_pod_cd",           false,    "",         dfDateYmd,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_del_cd",           false,    "",         dfDateYmd,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fmc_no",              false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,     100,    daCenter,   false,    "sc_no",          false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no",             false,    "",         dfNone,          0,     false,      false);
					
					CountPosition  = 0 ;
				}

				break;

		}
	}

    /*
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:		//조회
    			if(!validateForm(sheetObj,formObj,sAction)) {
    			    return false;
    			}
                formObj.f_cmd.value = SEARCH;
                
                var sheetObj1 = sheetObjects[0];
    	        var sheetObj2 = sheetObjects[1];
    	        var sheetObj4 = sheetObjects[3];
    	        
//                formObj.hdn_bl_no.value = formObj.bl_no.value.toUpperCase();
//                formObj.hdn_bkg_no_tmp.value = formObj.bkg_no_tmp.value.toUpperCase();

    			sheetObj4.DoSearch4Post("ESM_AGT_0015GS.do", agtQryStr(formObj));
    			
    			formObj.vsl_dep_dt.value = sheetObj4.CellValue(1, "vsl_dep_dt");
                formObj.shpr_cnt_seq.value = sheetObj4.CellValue(1, "shpr_cnt_seq");
                formObj.shpr_nm.value = sheetObj4.CellValue(1, "shpr_nm");
                formObj.frt_fwrd_cnt_seq.value = sheetObj4.CellValue(1, "frt_fwrd_cnt_seq");
                formObj.frt_fwrd_nm.value = sheetObj4.CellValue(1, "frt_fwrd_nm");
                formObj.comm_vsl.value = sheetObj4.CellValue(1, "comm_vsl");
                formObj.bkg_por_cd.value = sheetObj4.CellValue(1, "bkg_por_cd");
                formObj.bkg_pol_cd.value = sheetObj4.CellValue(1, "bkg_pol_cd");
                formObj.bkg_pod_cd.value = sheetObj4.CellValue(1, "bkg_pod_cd");
                formObj.bkg_del_cd.value = sheetObj4.CellValue(1, "bkg_del_cd");
                formObj.fmc_no.value = sheetObj4.CellValue(1, "fmc_no");
                formObj.sc_rfa_no.value = sheetObj4.CellValue(1, "sc_no")+"/"+sheetObj4.CellValue(1, "rfa_no");
                
//       	        if(formObj.bl_no.value == null || formObj.bl_no.value == "") {
//       	            formObj.bl_no.value = formObj.hdn_bl_no.value;
//       	        }
//       	        if(formObj.bkg_no_tmp.value == null || formObj.bkg_no_tmp.value == "") {
//       	            formObj.bkg_no_tmp.value = formObj.hdn_bkg_no_tmp.value;
//       	        }
       	        
       	        formObj.f_cmd.value = SEARCH01;
       	        sheetObj1.DoSearch4Post("ESM_AGT_0015GS.do", agtQryStr(formObj));
             
       	        formObj.f_cmd.value = SEARCH02;
       	        sheetObj2.DoSearch4Post("ESM_AGT_0015GS.do", agtQryStr(formObj));
    			break;

		   case IBRATESEARCH:      //조회
    			formObj.f_cmd.value = SEARCH03;
    			var sheetObj3 = sheetObjects[2];
    			sheetObj3.DoSearch4Post("ESM_AGT_0015GS2.do", agtQryStr(formObj));
				break;

        }
    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){

        var formObj = document.form;

        var bl_no = formObj.bl_no.value;
        var bkg_no = formObj.bkg_no.value;

        if( bl_no == "" && bkg_no == "" ) {

        	ComShowMessage(ComGetMsg("COM12138", "B/L", "Booking No", ""));
            formObj.bl_no.focus();
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
    
    function sheet4_OnSearchEnd(ErrMsg){
    	var formObject = document.form;
    	if(sheetObjects[3].RowCount == 0){
    		sheetObjects[3].CellValue(1, "vsl_dep_dt") = "";
    	}
    }
 
    /**
     * Grid에서 OnDblClick Event 처리
     */
    function sheet2_OnDblClick(sheetObj, Row, Col) {
    	
    	var sheetObject2 = sheetObjects[2];
        var formObj = document.form;
        formObj.fac_ofc_cd.value = sheetObjects[1].CellValue(Row, "fac_ofc_cd");
        formObj.frt_fwrd_cnt_cd.value = sheetObjects[1].CellValue(Row, "agmt_cnt_cd");
        formObj.frt_fwrd_cust_seq.value = sheetObjects[1].CellValue(Row, "agmt_cust_seq");
        formObj.fac_rt_seq.value = sheetObjects[1].CellValue(Row, "agmt_rt_seq");
        doActionIBSheet(sheetObjects[2], formObj, IBRATESEARCH);

    }