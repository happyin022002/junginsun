/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4016.js
 *@FileTitle : Upload Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.07.20 김재연
 * 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2012.03.19 서미진 [CHM-201216863] PSA GROUP 추가
* 2013.03.07 전윤주 [CHM-201323465] Reefer condition 추가
* 2013.04.17 전윤주 [CHM-201324203] Surcharge Table의 Contract Date 항목 추가 요청
* 2013.08.19 전윤주 [CHM-201326381] Weight 컬럼 소수점 3자리로 변경
* 2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
* 2013.10.01 전윤주 [CHM-201326929] BL Printing시 숨길 수 있는 Hide 항목 추가    
* 2014.02.19 전윤주 [CHM-201428968] Surcharge effective/expiration date 입력 시 경고 팝업 추가 요청 
* 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
* 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가  
* 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
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
	 * @class ESM_PRI_4016 : ESM_PRI_4016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_4016() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var errFlg = false;	// Check 버튼동작후 flag 값 세팅
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.28
     */
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
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
    		
    		switch(srcName) {
	    		case "btn_template":
					downform.submit();
					break;
					
	    		case "btn_openfile":
	    			sheetObject1.LoadExcel(-1);
					break;
				
	    		case "btn_check":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_close":
					dialogArguments.reloadExcelCopy();
					self.close();
					break;
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.28
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.28
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        pageOnLoadFinish();
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.07.28
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
     	var sheetID = sheetObj.id;

        switch(sheetID) {
        	case "sheet1":      //t1sheet1 init
		        with (sheetObj) {
		        	// 높이 설정
					style.height = 260;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "|Seq|Scope|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|PSA\nGroup|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Contract\nDate|Hide|State|State|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|RF\nCondition|Food\nGrade|Arrival\nDate|US Service\nMode|Del\nMark|Remark(s)||||||||";
					var HeadTitle2 = "|Seq|Scope|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|PSA\nGroup|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Contract\nDate|Hide|Country|State |Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|RF\nCondition|Food\nGrade|Arrival\nDate|US Service\nMode|Del\nMark|Remark(s)||||||||";
					var headCount = ComCountHeadTitle(HeadTitle2);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					
					InitDataProperty(0, cnt++, dtDataSeq,   40, daCenter,  	true, "seq");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "svc_scp_cd");
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, 	true, "por_def_cd", 		false, 	"", dfEngUpKey, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, 	true, "pol_def_cd", 		false, 	"", dfEngUpKey, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, 	true, "pod_def_cd", 		false, 	"", dfEngUpKey, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, 	true, "del_def_cd", 		false, 	"", dfEngUpKey, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "rat_ut_cd", 			true,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	60, daCenter, 	true, "prc_cgo_tp_cd", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	60, daCenter, 	true, "scg_imdg_clss_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtComboEdit, 60, daCenter,   true, "psa_no", 			false,  "", dfNone, 0, true, true);    
					InitDataProperty(0, cnt++, dtCombo, 	60, daCenter, 	true, "curr_cd", 			true, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		100,daRight, 	true, "scg_amt", 			true, 	"", dfFloat, 2, true, true, 11);
					InitDataProperty(0, cnt++, dtCombo, 	80, daCenter, 	true, "pay_term_cd", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		70, daCenter, 	true, "eff_dt", 			true, 	"", dfDateYmd, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		70, daCenter, 	true, "exp_dt", 			false, 	"", dfDateYmd, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		70, daCenter, 	true, "ctrt_dt", 			false, 	"", dfDateYmd, 0, true, true);
//					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "act_rat_flg", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCheckBox, 	70, daCenter, 	true, "prn_hdn_flg", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter,   true, "cnt_cd",             false,  "", dfEngUpKey, 0, true, true, 2);
					InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter,   true, "ste_cd",             false,  "", dfEngUpKey, 0, true, true, 3);
					
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "cnl_tz_cd", 			false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		90, daRight, 	true, "min_cgo_wgt", 		false, 	"", dfNullFloat, 3, true, true);
					InitDataProperty(0, cnt++, dtData, 		90, daRight, 	true, "max_cgo_wgt", 		false, 	"", dfNullFloat, 3, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daRight, 	true, "org_trsp_mod_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "dest_trsp_mod_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "prc_rcv_term_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "prc_de_term_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	90, daRight, 	true, "prc_hngr_bar_tp_cd", false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "sub_trd_cd", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "vsl_slan_cd", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	70, daCenter, 	true, "dir_call_flg", 		false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtPopupEdit, 70, daCenter, 	true, "tml_cd", 			false, 	"", dfEngUpKey, 0, true, true);
					InitDataProperty(0, cnt++, dtPopupEdit, 80, daCenter, 	true, "cmdt_cd", 			false, 	"", dfNone, 0, true, true, 6, true);
					InitDataProperty(0, cnt++, dtCombo, 	90, daRight, 	true, "io_ga_cd", 			false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtPopupEdit, 70, daCenter, 	true, "ts_port_cd", 		false, 	"", dfEngUpKey, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtCombo, 	110,daRight, 	true, "soc_flg", 			false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	90, daCenter, 	true, "scg_grp_cmdt_cd", 	false, 	"", dfNone, 0, true, true);					
					InitDataProperty(0, cnt++, dtCombo,     60, daCenter,   true, "rc_air_cond_tp_cd",  false,  "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo,     60, daCenter,   true, "fd_grd_flg",         false,  "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData,         70, daCenter,   true, "arr_dt",				false,  "", dfDateYmd, 0, true, true);
					InitDataProperty(0, cnt++, dtCombo, 	90, daCenter, 	true, "usa_svc_mod_cd", 	false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtCheckBox, 	80, daCenter, 	true, "wdr_flg", 			false, 	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 		90, daLeft, 	true, "scg_rmk", 			false, 	"", dfNone, 0, false, false);
		
					//InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "svc_scp_cd");
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "chg_cd");
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "scg_seq");
					InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "por_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pol_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pod_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "del_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "scg_rqst_sts_cd", false, "", dfNone, 0, false, false);

					// 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정
					InitDataValid(0, "por_def_cd", 	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					InitDataValid(0, "pol_def_cd", 	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					InitDataValid(0, "pod_def_cd", 	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력
					InitDataValid(0, "del_def_cd", 	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력
					InitDataValid(0, "ts_port_cd", 	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력
					InitDataValid(0, "tml_cd", 		vtEngUpOther, "012456789");         // 영문대문자와 숫자만 입력
					InitDataValid(0, "cmdt_cd", 	vtNumericOnly); // 숫자만 입력
					InitDataValid(0, "cnt_cd",      vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력
					InitDataValid(0, "ste_cd",      vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					
					InitDataCombo(0, "org_trsp_mod_cd", orgTrspModCdText, orgTrspModCdValue);
					InitDataCombo(0, "dest_trsp_mod_cd", destTrspModCdText, destTrspModCdValue);
					InitDataCombo(0, "usa_svc_mod_cd", usaSvcModCdText, usaSvcModCdValue);
					InitDataCombo(0, "prc_rcv_term_cd", prcRcvTermCdText, prcRcvTermCdValue);
					InitDataCombo(0, "prc_de_term_cd", prcDeTermCdText, prcDeTermCdValue);
					InitDataCombo(0, "prc_hngr_bar_tp_cd", prcHngrBarTpCdText, prcHngrBarTpCdValue);
					InitDataCombo(0, "pay_term_cd", payTermCdText, payTermCdValue);
					InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
					InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
					InitDataCombo(0, "scg_imdg_clss_cd", scgImdgClssCdText, scgImdgClssCdValue);
					InitDataCombo(0, "curr_cd", currCdText, currCdValue);
					InitDataCombo(0, "dir_call_flg", dirCallFlgText, dirCallFlgValue);
					InitDataCombo(0, "soc_flg", socFlgText, socFlgValue);
					InitDataCombo(0, "io_ga_cd", ioGaCdText, ioGaCdValue);
					InitDataCombo(0, "sub_trd_cd", subTrdCdText, subTrdCdValue);
					InitDataCombo(0, "psa_no", psaCdText, psaCdValue);
					InitDataCombo(0, "rc_air_cond_tp_cd", rfCondCdText, rfCondCdValue);
//					InitDataCombo(0, "act_rat_flg", actRatFlgText, actRatFlgValue);
					InitDataCombo(0, "fd_grd_flg", fdGrdFlgText, fdGrdFlgValue); 
					
					AutoRowHeight = false;
					WaitImageVisible = false;
		    	}
		    	break; 
    	
	        case "sheet2":
				with (sheetObj) {
		
					// 높이 설정
					style.height = 80;
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
					InitRowInfo(1, 1, 3, 100);
		
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|flt_ptc_tp_cd|pct_bse_cd|por|pol|pod|del|rcv_de_term|imdg|canal|cgo_wgt|trns_mod|hngr_bar|sub|slan|dir_call|tml|cmdt|gauge|ts_port|soc|gri_cmdt|usa_svc|psa_no_mng_flg|rc_air_cond_tp_use_flg|ctrt_dt_use_flg|prn_hdn_use_flg|fd_grd_use_flg|ste_use_flg|arr_dt_use_flg";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus, 60, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "flt_pct_tp_cd", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pct_bse_cd", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "por_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "del_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rcv_de_term_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "imdg_clss_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cnl_tz_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cgo_wgt_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "trns_mod_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "hngr_bar_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "sub_trd_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "slan_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "dir_call_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "tml_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "io_ga_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ts_port_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "soc_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gri_cmdt_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "usa_svc_mod_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "psa_no_mng_flg", false, "", dfNone, 0, true, true); 
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rc_air_cond_tp_use_flg", false, "", dfNone, 0, true, true); 
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ctrt_dt_use_flg", false, "", dfNone, 0, true, true); 
//					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "act_rat_use_flg", false, "", dfNone, 0, true, true); 
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "prn_hdn_use_flg", false, "", dfNone, 0, true, true); 
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "fd_grd_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ste_use_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "arr_dt_use_flg", false, "", dfNone, 0, true, true);
					
					AutoRowHeight = false;
					WaitImageVisible = false;
				}
				break;
			
            case "sheet3": //중복검사 위한 temp sheet
	            with (sheetObj) {
	            	// 높이 설정
					style.height = 200;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
//					var HeadTitle1 = "Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Effective\nDate|Expiration\nDate|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|GRI\nCommodity|US Service\nMode|Del\nMark";
//					var HeadTitle2 = "Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Effective\nDate|Expiration\nDate|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|GRI\nCommodity|US Service\nMode|Del\nMark";
					
					var HeadTitle1 = "Seq|Scope|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|PSA\nGroup|Cur.|Pay Term|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|RF Condition|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|Contract\nDate|Food Grade|State|State|Arrival\nDate|Status";
					var HeadTitle2 = "Seq|Scope|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|PSA\nGroup|Cur.|Pay Term|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|RF Condition|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|Contract\nDate|Food Grade|Country|State|Arrival\nDate|Status";
//					var HeadTitle2 = "Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|GRI\nCommodity|US Service\nMode|Del\nMark";
					var headCount = ComCountHeadTitle(HeadTitle2);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
						
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 40, daCenter,  	true, "seq");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "svc_scp_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "por_def_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "pol_def_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "pod_def_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "del_def_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "rat_ut_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "prc_cgo_tp_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "scg_imdg_clss_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "psa_no");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "curr_cd");
					InitDataProperty(0, cnt++, dtData, 80, daCenter, 	true, "pay_term_cd");

					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "cnl_tz_cd");
					InitDataProperty(0, cnt++, dtData, 90, daRight, 	true, "min_cgo_wgt");
					InitDataProperty(0, cnt++, dtData, 90, daRight, 	true, "max_cgo_wgt");
					InitDataProperty(0, cnt++, dtData, 70, daRight, 	true, "org_trsp_mod_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "dest_trsp_mod_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "prc_rcv_term_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "prc_de_term_cd");
					InitDataProperty(0, cnt++, dtData, 90, daRight, 	true, "prc_hngr_bar_tp_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "sub_trd_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "vsl_slan_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "dir_call_flg");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "tml_cd");
					InitDataProperty(0, cnt++, dtData, 80, daCenter, 	true, "cmdt_cd");
					InitDataProperty(0, cnt++, dtData, 90, daRight, 	true, "io_ga_cd");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "ts_port_cd");
					InitDataProperty(0, cnt++, dtData, 110,daRight, 	true, "soc_flg");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "scg_grp_cmdt_cd");
					InitDataProperty(0, cnt++, dtData, 60, daCenter, 	true, "rc_air_cond_tp_cd");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "usa_svc_mod_cd");
					InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter,true, "wdr_flg");
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "eff_dt", false, 	"", dfDateYmd);
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "exp_dt", false, 	"", dfDateYmd);
					InitDataProperty(0, cnt++, dtData, 70, daCenter, 	true, "ctrt_dt", false, "", dfDateYmd);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "fd_grd_flg");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "cnt_cd");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "ste_cd");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, 	true, "arr_dt", false, "", dfDateYmd);
					InitDataProperty(0, cnt++, dtCombo, 90, daCenter, true, "scg_rqst_sts_cd", false, "", dfNone, 0, false, false);
	        	}
	        	break;
	        	
            case "sheet4" :  // hidden
		        with (sheetObj) {
		            // 높이 설정
		            // 전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            // 전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            // 전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            var HeadTitle = "status";
		            var headCount = ComCountHeadTitle(HeadTitle);
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 6, 100);
		
		            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
		
		            Visible = false;
		        }
		        break;
        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.07.28
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	try{
    		switch (sAction) {
    		
			case IBCLEAR: // 화면 로딩시 
				// Lane combo
				formObj.f_cmd.value = COMMAND06;
				formObj.cd.value = formObj.svc_scp_cd.value;
				sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObj, sXml, "vsl_slan_cd", true, 0, '', '', true);
				
				// Surcharge Group Commodity
//				formObj.f_cmd.value = COMMAND10;
//				sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
//				alert(sXml)
				formObj.f_cmd.value = COMMAND10;                                                                                                                                                                                                                                                                                                                                                                                                        
				sXml = sheetObjects[1].GetSearchXml("ESM_PRI_4003GS.do",                                                                                                                                                                                                                                                                                                                                                                                   
						FormQueryString(formObj)); 
				setIBCombo(sheetObj, sXml, "scg_grp_cmdt_cd", true, 0);
				break;
			
			case IBSEARCH: //조회
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
		
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("ESM_PRI_4016GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
		
			case IBSEARCH_ASYNC01: //Check
				ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
					return false;
        		}
				ComOpenWait(false);
				break;
				
			case IBSAVE: //생성
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI01;
		
				var sParam = "";
				var sParamSheet2 = sheetObjects[0].GetSaveString(true);
				if (sParamSheet2 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				}

				formObj.f_cmd.value = MULTI01;
				sXml = sheetObjects[0].GetSaveXml("ESM_PRI_4016GS.do", FormQueryString(formObj) + sParam);
				var sFlag = ComGetEtcData(sXml, "FLAG");
				var sDupIdx = ComGetEtcData(sXml, "DUP_INDEX");
				
				if(sFlag == "N") {
					ComShowCodeMessage("PRI02017", sDupIdx);
					sheetObj.Editable = true;
					ComBtnDisable("btn_save");
	  				ComBtnEnable("btn_check");
				}else{
					sheetObjects[1].LoadSaveXml(sXml);
				}
				
				ComOpenWait(false);
				break;
			}   			
			
//				ComOpenWait(true);
//				if (!validateForm(sheetObj, formObj, sAction)) {
//					ComOpenWait(false);
//					return false;
//				}
//				
//				formObj.f_cmd.value = MULTI01;
//		
//				var sParam = "";
//				var sParamSheet2 = sheetObjects[0].GetSaveString();
//				if (sParamSheet2 != "") {
//					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
//				}
//				
//				//sParam += "&" + FormQueryString(formObj);
//				formObj.f_cmd.value = SEARCH04;
//				var sXml = sheetObjects[0].getSearchXml("ESM_PRI_4016GS.do", FormQueryString(formObj) + sParam);
//				
//				var sFlag = ComGetEtcData(sXml, "FLAG");
//				var sDupIdx = ComGetEtcData(sXml, "DUP_INDEX");
//				
//				if(sFlag == "N") {
//					ComShowCodeMessage("PRI02017", sDupIdx);
//					sheetObj.Editable = true;
//					ComBtnDisable("btn_save");
//	  				ComBtnEnable("btn_check");
//				} else {
//					formObj.f_cmd.value = MULTI01;
//					sXml = sheetObjects[0].GetSaveXml("ESM_PRI_4016GS.do", FormQueryString(formObj) + sParam);
//					sheetObjects[0].LoadSaveXml(sXml);
//				}
//				ComOpenWait(false);
//				break;
//    		}    		
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == IBCLEAR  ) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    	

	}
     
	/**
	 * sheet2에서 OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.20
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg) {
		 if (errMsg == "") {
			setSheetHeader(sheetObj);
		}
	}
	
	/**
	 * sheet1에서 OnChange 이벤트 발생시 호출되는 function <br>
	 * Multi ComboBox 선택 시 Validation 조회 및 Description의 내용을 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.20
	 */
	 function sheet1_OnChange(sheetObj, Row, Col, Value) {
	 	var formObj = document.form;
	 	var sName = sheetObj.ColSaveName(Col);
	 	var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
	 	var sChgCd = sheetObj.CellValue(Row, "chg_cd");

	 	switch (sName) {

	 	case "por_def_cd":
	 		checkLocation(sheetObj, Row, "por_tp_cd", "por_def_cd", true, true, true, true);
	 		break;

	 	case "pol_def_cd":
	 		checkLocation(sheetObj, Row, "pol_tp_cd", "pol_def_cd", true, true, true, true);
	 		break;

	 	case "pod_def_cd":
	 		checkLocation(sheetObj, Row, "pod_tp_cd", "pod_def_cd", true, true, true, true);
	 		break;

	 	case "del_def_cd":
	 		checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd", true, true, true, true);
	 		break;
	 		
	 	case "cnt_cd":                                                                                                                                                                                                                                                                                                                                                                                                                              
			checkLocation(sheetObj, Row, "", "cnt_cd");  
			sheetObj.CellValue2(Row, "ste_cd") = ""; 
			break;
			
	 	case "ste_cd":                                                                                                                                                                                                                                                                                                                                                                                                                              
			checkState(sheetObj, Row, Value);                                                                                                                                                                                                                                                                                                                                                                                
			break;

	 	case "ts_port_cd":
	 		checkTSPort(sheetObj, Row, Value);
	 		break;
	 	
	 	case "tml_cd":
			checkTerminalCode(sheetObj, Row, Value);
			break;
			
	 	case "cmdt_cd":
	 		checkCommodity(sheetObj, Row, Value);
	 		break;

	 	case "rat_ut_cd":
	 		checkPerType(sheetObj, Row, Value);
	 		break;

	 	case "prc_cgo_tp_cd":
	 		checkCargoType(sheetObj, Row, Value);
	 		break;

	 	case "scg_amt":
	 		if (Value == 0) {
	 			sheetObj.InitCellProperty(Row, Col, dtData, daRight, "scg_amt", "", dfInteger);
	 		} else {
	 			sheetObj.InitCellProperty(Row, Col, dtData, daRight, "scg_amt", "", dfFloat, 2, 11);
	 		}
	 		break;
	 		
	 	case "eff_dt":
			checkDatePeriod(sheetObj, Row, "eff_dt");
			break;
			
		case "exp_dt":
			checkDatePeriod(sheetObj, Row, "exp_dt");
			break;
			
		case "psa_no":
			var combo_pas_no = "" ;
			var sCd = sheetObj.GetComboInfo(0,"psa_no","Code")+"|";
			
			if(sCd.indexOf("|"+Value+"|") < 0){
				sheetObj.CellValue2(Row, "psa_no") = "";    
			}
			break;			
	 	}
	}
    
	/**
   	 * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 
   	 * </pre>
   	 * @param {ibsheet} sheetObj 필수 IBSheet Object
   	 * @param {Long} Row 필수 해당 셀의 Row Index
   	 * @param {Long} Col 필수 해당 셀의 Column Index
   	 * @param {Integer} KeyCode 필수 키보드의 아스키 값
   	 * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
   	 * @return 없음
   	 * @author 김재연
   	 * @version 2009.07.20
   	 */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
            while (true) {
                if (Col > sheetObj.LastCol) {
                    Row++;
                    Col = 1;
                }
                if (Row > sheetObj.LastRow) {
                    Row = sheetObj.HeaderRows;
                }
                if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
                    sheetObj.SelectCell(Row, Col, false);
                    break;
                }
                Col++;
            }
        }
    }
	     
	/**
	 * sheet1에서 OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * 해당 popup 화면을 호출한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.20
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
	    var colName = sheetObj.ColSaveName(Col);
	  	var formObj = document.form;
	  	var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
	  	var sChgCd = sheetObj.CellValue(Row, "chg_cd");
	  	var tpCd = "";
	  	
	  	if (colName == "por_def_cd") { //POR
	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;

	  			if (rtnVal.cd.length == 5) { //Location Type을 변경한다
	  				tpCd = "L";
	  			} else if (rtnVal.cd.length == 4) { //Location Type을 변경한다
	  				tpCd = "G";
	  			}
	  			sheetObj.CellValue2(Row, "por_tp_cd") = tpCd;
	  		}
	  	} else if (colName == "pol_def_cd") { //POL
	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;

	  			if (rtnVal.cd.length == 5) { //Location Type을 변경한다
	  				tpCd = "L";
	  			} else if (rtnVal.cd.length == 4) { //Location Type을 변경한다
	  				tpCd = "G";
	  			}
	  			sheetObj.CellValue2(Row, "pol_tp_cd") = tpCd;
	  		}
	  	} else if(colName == "pod_def_cd") { //POD
	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;

	  			if (rtnVal.cd.length == 5) { //Location Type을 변경한다
	  				tpCd = "L";
	  			} else if (rtnVal.cd.length == 4) { //Location Type을 변경한다
	  				tpCd = "G";
	  			}
	  			sheetObj.CellValue2(Row, "pod_tp_cd") = tpCd;
	  		}
	  	} else if(colName == "del_def_cd") { //DEL
	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;

	  			if (rtnVal.cd.length == 5) { //Location Type을 변경한다
	  				tpCd = "L";
	  			} else if (rtnVal.cd.length == 4) { //Location Type을 변경한다
	  				tpCd = "G";
	  			}
	  			sheetObj.CellValue2(Row, "del_tp_cd") = tpCd;
	  		}
	  	} else if (colName == "cnt_cd") { //Country Code                                                                                                                                                                                                                                                                                                                                                                                                             
			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SCG                                                                                                                                                                                                                                                                                                                                                                                       
			+ "&location_cmd=C&svc_scp_cd=" + sSvcScpCd + "&chg_cd="                                                                                                                                                                                                                                                                                                                                                                     
			+ sChgCd;                                                                                                                                                                                                                                                                                                                                                                                                                       
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);                                                                                                                                                                                                                                                                                                                                                                      
			if (rtnVal != null) {                                                                                                                                                                                                                                                                                                                                                                                                                           
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;                                                                                            
			}                                                                                                                                                                                                                                                                                                                                                                                                                                               
		} else if (colName == "ste_cd") { //State Code                                                                                                                                                                                                                                                                                                                                                                                                             
			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SCG                                                                                                                                                                                                                                                                                                                                                                                       
			+ "&location_cmd=T&svc_scp_cd=" + sSvcScpCd + "&chg_cd="                                                                                                                                                                                                                                                                                                                                                                     
			+ sChgCd;                                                                                                                                                                                                                                                                                                                                                                                                                       
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);                                                                                                                                                                                                                                                                                                                                                                      
			if (rtnVal != null) {                                                                                                                                                                                                                                                                                                                                                                                                                           
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;  
				sheetObj.CellValue2(Row, "cnt_cd") = rtnVal.cnt_cd;  
			}                                                                                                                                                                                                                                                                                                                                                                                                                                               
		} else if(colName == "ts_port_cd") { //ts port
	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=L";
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;
	  		}
	  	} else if(colName == "tml_cd") { //Terminal Code
			var tmlCd = sheetObj.CellValue(Row, Col);
			var display = '0,0,1,1,1,1,1,1,1,1,1,1';
			var param = '?mode=yard&node_cd='+tmlCd;
			ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'callBackTerminalCode', display, true);
	  	} else if (colName == "cmdt_cd") { //commodity
	  		var sUrl = "/hanjin/ESM_PRI_4027.do?grp_cd="+PRI_SCG+"&commodity_cmd=C&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 700, 330, true);
	  		if (rtnVal != null) {
	  			sheetObj.CellValue2(Row, Col) = rtnVal.cd;

	  			if (rtnVal.cd.length == 6) {
	  				tpCd = "C";
	  			}

	  			sheetObj.CellValue2(Row, "prc_cmdt_tp_cd") = tpCd;
	  		}
	  	}
	}
    
	/**
	 * Terminal Code 조회 popup 화면이 닫힐때 호출되는 function <br>
	 * popup에서 내려받은 코드를 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {String} locTp 필수 location 구분코드(사용않음)
	 * @param {array} rArray 코드값 array
	 * @return 없음
	 * @author 김재연
	 * @version 2009.06.04
	 */
	function callBackTerminalCode(rowArray){
		 var colArray = rowArray[0];
	     if(rowArray != null) {
	    	 sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "tml_cd") = colArray[3];
	     } else {
	    	 sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "tml_cd") = "";
	     }
	} 
	 
    /**
     * sheet1에서 OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 김재연
     * @version 2009.07.20
     */  
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
	 	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	 	var colname = sheetObj.ColSaveName(Col);
	 	
	 	switch (colname) {
	 	
		 	case "scg_rmk":
		 		ComShowMemoPad(sheetObj);
		 		break;
	 	}
	}
	
	 /**
     * sheet1에서 LoadExcel 이벤트 발생시 호출되는 function <br>
     * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
 	function sheet1_OnLoadExcel(sheetObj){
    	setSheetDisplay(sheetObj);
    	ComBtnDisable("btn_save");
 	}
 	
    /**
     * sheet1에서 OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
 			//ComPriSaveCompleted();
 			dialogArguments.reloadExcelCopy();
			self.close();
 		}
	}
  	
    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	 toggleButtons("CLEAR");
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
         toggleButtons("INIT");
    }

    /**
     * sheet의 header를 설정하는 function <br>
     * 데이터가 있는 cell만 보이게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSheetHeader(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 	
	function setSheetHeader(sheetObj) {
		setFltPctTpCd(sheetObj.CellValue(1, "flt_pct_tp_cd"));
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "por_use_flg"), "por_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "pol_use_flg"), "pol_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "pod_use_flg"), "pod_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "del_use_flg"), "del_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "rcv_de_term_use_flg"), "prc_rcv_term_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "rcv_de_term_use_flg"), "prc_de_term_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "imdg_clss_use_flg"), "scg_imdg_clss_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "cnl_tz_flg"), "cnl_tz_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "cgo_wgt_use_flg"), "min_cgo_wgt");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "cgo_wgt_use_flg"), "max_cgo_wgt");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "trns_mod_use_flg"), "org_trsp_mod_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "trns_mod_use_flg"), "dest_trsp_mod_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "hngr_bar_use_flg"), "prc_hngr_bar_tp_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "sub_trd_use_flg"), "sub_trd_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "slan_use_flg"), "vsl_slan_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "dir_call_use_flg"), "dir_call_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "tml_use_flg"), "tml_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "cmdt_use_flg"), "cmdt_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "io_ga_use_flg"), "io_ga_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "ts_port_use_flg"), "ts_port_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "soc_use_flg"), "soc_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "gri_cmdt_use_flg"), "scg_grp_cmdt_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "usa_svc_mod_use_flg"), "usa_svc_mod_cd");				
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "psa_no_mng_flg"), "psa_no");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "rc_air_cond_tp_use_flg"), "rc_air_cond_tp_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "ctrt_dt_use_flg"), "ctrt_dt");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "act_rat_use_flg"), "act_rat_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "prn_hdn_use_flg"), "prn_hdn_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "fd_grd_use_flg"), "fd_grd_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "ste_use_flg"), "cnt_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "ste_use_flg"), "ste_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "arr_dt_use_flg"), "arr_dt");
	}
	
	/**
     * sheet의 column을 hidden 여부를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "io_ga_use_flg"), "io_ga_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param (string) value 필수
     * @param (string) colName 필수
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 	
	function setSheetColumnHidden(sheetObj, value, colName) {
		if(value == "Y") {
			sheetObj.ColHidden(colName) = false;
		} else {
			sheetObj.ColHidden(colName) = true;
		}
	}
	
	/**
     * flc_pct_tp_cd에 따라 타이틀의 명과 column의 속성을 변경하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setFltPctTpCd(sheetObj.CellValue(1, "flt_pct_tp_cd"))
     * </pre>
     * @param (string) code 필수
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 	
	function setFltPctTpCd(code) {
    	 if (code == 'F') {
			sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("curr_cd"), dtCombo, 60, daCenter, true, "curr_cd", true, "", dfNone, 0, true, true);
			sheetObjects[0].CellValue(0, "scg_amt") = "Amount"
			sheetObjects[0].CellValue(1, "scg_amt") = "Amount"
			sheetObjects[0].ColHidden("curr_cd") = false;
		} else {
			sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("curr_cd"), dtCombo, 60, daCenter, true, "curr_cd", false, "", dfNone, 0, false, false);
			sheetObjects[0].CellValue(0, "scg_amt") = "Percentage %"
			sheetObjects[0].CellValue(1, "scg_amt") = "Percentage %"
			sheetObjects[0].ColHidden("curr_cd") = true;
		}
	}
	
	/**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd");
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		
		if(ComIsNull(locCd)) {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return;
		}
		
		// Location Group
		if (locCd.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L";
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		// Location Group
		else if (locCd.length == 4) {
			formObj.f_cmd.value = COMMAND11;
			formObj.cd.value = locCd;
			var param = "&etc1=" + sheetObj.CellValue(Row, "svc_scp_cd") + "&etc2=" + sheetObj.CellValue(Row, "chg_cd");
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "G";
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		// Country
		else if (locCd.length == 2) {
			formObj.f_cmd.value = SEARCH07;
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "C";
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		// Region
		else if (locCd.length == 3) {
			formObj.f_cmd.value = COMMAND08;
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "R";
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return false;
 		}
		return true;
	}
	
	/**                                                                                                                                                                                                                                                                                                                                                                                                                                                             
     * state code 유효성 확인하는 function <br>                                                                                                                                                                                                                                                                                                                                                                                                                      
     * <br><b>Example :</b>                                                                                                                                                                                                                                                                                                                                                                                                                                             
     * <pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                            
     *    checkState(sheetObj, Row, "ste_cd");                                                                                                                                                                                                                                                                                                                                                                                                      
     * </pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                           
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트                                                                                                                                                                                                                                                                                                                                                                                                         
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index                                                                                     
     * @param (string) state code 체크할 cell name                                                                                                                                                                                                                                                                                                                                                                                                              
     * @return 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                     
     * @author 전윤주                                                                                                                                                                                                                                                                                                                                                                                                                                                   
     * @version 2014.04.10                                                                                                                                                                                                                                                                                                                                                                                                                                              
     */                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	function checkState(sheetObj, Row, Value) {	
		var combo_cnt_cd= sheetObj.CellValue(Row, "cnt_cd");
		var ui_id= "4003";
		
		if(ComIsNull(Value)) {                                                                                                                                                                                                                                                                                                                                                                                                                                  
			return;                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}		
		if(combo_cnt_cd !="") {
			if (Value.length == 2||Value.length == 3) {
				var formObj = document.form;
				formObj.f_cmd.value = SEARCH03;		
				var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", FormQueryString(formObj) + "&combo_cnt_cd=" + combo_cnt_cd + "&ste_cd=" + Value+ "&ui_id=" + ui_id);                                                                                                                                                                                                                                                                                                                                                                   
				var arrDesc = ComPriXml2Array(sXml, "ste_cd");                                                                                                                                                                                                                                                                                                                                                                                         
				if(arrDesc == null || arrDesc.length < 1) {
					sheetObj.CellValue2(Row, "cnt_cd") = "";
					sheetObj.CellValue2(Row, "ste_cd") = "";                                                                                                                                                                                                                                                                                                                                                                                            
				}                                                                                                                                                                                                                                                                                                                                                                                                                                               
			} else {
				sheetObj.CellValue2(Row, "cnt_cd") = "";
				sheetObj.CellValue2(Row, "ste_cd") = "";                                                                                                                                                                                                                                                                                                                                                                                                    
			}		                                                                                                                                                                                                                                                                                                                                                                                                                                       
		} else {
			ComShowCodeMessage("PRI01042", "Country");
			sheetObj.CellValue2(Row, "ste_cd") = "";
			sheetObj.SelectCell(Row, "cnt_cd", true);

		}				
	}   
	
	/**
     * ts_port_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTSPort(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function checkTSPort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = Value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.CellValue2(Row, "ts_port_cd") = "";
			}
		} else {
			sheetObj.CellValue2(Row, "ts_port_cd") = "";
		}
	}
	
	/**
     * cmdt_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function checkCommodity(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
	
		if(Value.length == 6) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_4027GS.do", FormQueryString(formObj) + "&cmdt_cd=" + Value);
			var arrDesc = ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			if (arrDesc == null || arrDesc.length < 1) {
				sheetObj.Cellvalue2(Row, "cmdt_cd") = "";
				sheetObj.SelectCell(Row, "cmdt_cd");
			} else {
				sheetObj.Cellvalue2(Row, "cmdt_cd") = Value;
			}
		} else {
			sheetObj.Cellvalue2(Row, "cmdt_cd") = "";
			sheetObj.SelectCell(Row, "cmdt_cd");
		}
	}
	
	/**
     * rat_ut_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkPerType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */
     function checkPerType(sheetObj, Row, Value) {
  		var validPerClass = "A,F,O,Q,S,P";
  		if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK" && 
 				(ComIsNull(Value) || (validPerClass.indexOf(Value.charAt(0)) < 0 && Value != "20" && Value != "40" && Value != "HC" && Value != "BX"))) {
  			ComShowCodeMessage("PRI02011");
     		sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
         }
  	}
	
	/**
     * prc_cgo_tp_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCargoType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function checkCargoType(sheetObj, Row, Value) {
		if(Value == "AK") {
            var validPerClass = "A,F,O,Q,S,P";
            var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");

            if((validPerClass.indexOf(ratUtCd.charAt(0)) < 0 && ratUtCd != "20" && ratUtCd != "40" && ratUtCd != "HC" && ratUtCd != "BX") || ComIsNull(ratUtCd)) {
            	ComShowCodeMessage("PRI02011");
                sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
            }
        } else if (Value == "DG") {
 			sheetObj.CellEditable(Row, "scg_imdg_clss_cd") = true;
 			sheetObj.CellEditable(Row, "psa_no") 		= true;	
 		} else {
 			sheetObj.CellValue2(Row, "scg_imdg_clss_cd") = "";
 			sheetObj.CellEditable(Row, "scg_imdg_clss_cd") = false;
			sheetObj.CellValue2(Row, "psa_no") 			= "";
			sheetObj.CellEditable(Row, "psa_no") 		= false;
 		}
	}
	
	/**
	 * eff_dt와 exp_dt의 Validation을 확인하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {String} colName 필수 Onclick 이벤트가 발생한 해당 셀의 Column Name
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.20
	 */
	function checkDatePeriod(sheetObj, Row, colName) {
		var effDt = sheetObj.CellValue(Row, "eff_dt");
		var expDt = sheetObj.CellValue(Row, "exp_dt");
		
		if(ComIsNull(effDt) || ComIsNull(expDt)) {
			return;
		}
		
		//alert("eff_dt : "+sheetObj.CellValue(Row, "eff_dt")+"\nexp_dt : "+sheetObj.CellValue(Row, "exp_dt"));
		if(ComChkPeriod(sheetObj.CellValue(Row, "eff_dt"), sheetObj.CellValue(Row, "exp_dt")) < 1) {
			ComShowCodeMessage('PRI00306');
			sheetObj.CellValue2(Row, colName) = "";
			sheetObj.SelectCell(Row, colName);
		}
	}
	
	/**
     * tml_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function checkTerminalCode(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		var formObj = document.form;
		
		if (Value.length == 7) {
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObjects[0].GetSearchXml("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
			var arrDesc = ComPriXml2Array(sXml, "yd_cd");
			
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.CellValue2(Row, "tml_cd") = "";
			}
		} else {
			sheetObj.CellValue2(Row, "tml_cd") = "";
		}
	}
		
	/**
     * location code 를 리셋하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.CellValue2(Row, cellTpCdNm) = "";
		sheetObj.CellValue2(Row, cellDefCdNm) = "";
	}
	
	/**
     * sheet의 column별 validation을 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {object} formObj 필수 HTML태그 form 오브젝트
     * @return validCnt
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validateCheckSheet(sheetObj, formObj) {
		var validCnt = 0;
		var topRow = sheetObj.HeaderRows;
		var lastRow = sheetObj.LastRow;
		var baseColor = sheetObj.RgbColor(255, 255, 255);
		var validColor = sheetObj.RgbColor(255, 0, 0);

		for(var i=topRow; i<=lastRow; i++) {
//     		sheetObj.CellValue(i, "svc_scp_cd") = formObj.svc_scp_cd.value;
     		sheetObj.CellValue(i, "chg_cd") = formObj.chg_cd.value;
     		sheetObj.CellValue(i, "scg_rqst_sts_cd") = "N";
     		

     		//alert(sheetObj.CellValue(i, "por_def_cd"));
     		if(!validCheckLocation(sheetObj, i, "por_tp_cd", "por_def_cd")) {
     			sheetObj.CellBackColor(i, "por_def_cd") = validColor;
     			validCnt++;
     		}
     		
     		if(!validCheckLocation(sheetObj, i, "pol_tp_cd", "pol_def_cd")) {
     			sheetObj.CellBackColor(i, "pol_def_cd") = validColor;
     			validCnt++;
     		}
     		
     		if(!validCheckLocation(sheetObj, i, "pod_tp_cd", "pod_def_cd")) {
     			sheetObj.CellBackColor(i, "pod_def_cd") = validColor;
     			validCnt++;
     		}
     		
     		if(!validCheckLocation(sheetObj, i, "del_tp_cd", "del_def_cd")) {
     			sheetObj.CellBackColor(i, "del_def_cd") = validColor;
     			validCnt++;
     		}

     		// Sub-trade
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "sub_trd_cd"), "sub_trd_cd")) {
     			sheetObj.CellBackColor(i, "sub_trd_cd") = validColor;
     			validCnt++;
     		}

     		// Lane
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "vsl_slan_cd"), "vsl_slan_cd")) {
     			sheetObj.CellBackColor(i, "vsl_slan_cd") = validColor;
     			validCnt++;
     		}
     		
     		// T/S Port
     		if(!validCheckTSPort(sheetObj, i, sheetObj.CellValue(i, "ts_port_cd"))) {
     			sheetObj.CellBackColor(i, "ts_port_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Direct Call
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "dir_call_flg"), "dir_call_flg")) {
     			sheetObj.CellBackColor(i, "dir_call_flg") = validColor;
     			validCnt++;
     		}
     		
     		// Terminal
     		if(!validCheckTerminalCode(sheetObj, i, sheetObj.CellValue(i, "tml_cd"), "tml_cd")) {
     			sheetObj.CellBackColor(i, "tml_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Trans Mode Origin
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "org_trsp_mod_cd"), "org_trsp_mod_cd")) {
     			sheetObj.CellBackColor(i, "org_trsp_mod_cd") = validColor;
     			validCnt++;
     		}

     		// Trans Mode Dest
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "dest_trsp_mod_cd"), "dest_trsp_mod_cd")) {
     			sheetObj.CellBackColor(i, "dest_trsp_mod_cd") = validColor;
     			validCnt++;
     		}
     		
     		// US Service Mode
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "usa_svc_mod_cd"), "usa_svc_mod_cd")) {
     			sheetObj.CellBackColor(i, "usa_svc_mod_cd") = validColor;
     			validCnt++;
     		}
     		
     		// R/D Term Origin
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_rcv_term_cd"), "prc_rcv_term_cd")) {
     			sheetObj.CellBackColor(i, "prc_rcv_term_cd") = validColor;
     			validCnt++;
     		}
     		
     		// R/D Term Dest
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_de_term_cd"), "prc_de_term_cd")) {
     			sheetObj.CellBackColor(i, "prc_de_term_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Bar Type
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_hngr_bar_tp_cd"), "prc_hngr_bar_tp_cd")) {
     			sheetObj.CellBackColor(i, "prc_hngr_bar_tp_cd") = validColor;
     			validCnt++;
     		}

     		// Min Weight
     		if(!validCheckMinCargoWeight(sheetObj, i, sheetObj.CellValue(i, "min_cgo_wgt"))) {
     			sheetObj.CellBackColor(i, "min_cgo_wgt") = validColor;
     			validCnt++;
     		}

     		// Max Weight
     		if(!validCheckMaxCargoWeight(sheetObj, i, sheetObj.CellValue(i, "max_cgo_wgt"))) {
     			sheetObj.CellBackColor(i, "max_cgo_wgt") = validColor;
     			validCnt++;
     		}

     		// Commodity
     		if(!validCheckCommodity(sheetObj, i, sheetObj.CellValue(i, "cmdt_cd"))) {
     			sheetObj.CellBackColor(i, "cmdt_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Shipper's Own Container(S.O.C)
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "soc_flg"), "soc_flg")) {
     			sheetObj.CellBackColor(i, "soc_flg") = validColor;
     			validCnt++;
     		}
     		
     		// In/Out Gauge
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "io_ga_cd"), "io_ga_cd")) {
     			sheetObj.CellBackColor(i, "io_ga_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Per(Rating Unit)
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "rat_ut_cd"))) {
     			sheetObj.CellBackColor(i, "rat_ut_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Cargo Type
     		if(!validCheckCargoType(sheetObj, i, sheetObj.CellValue(i, "prc_cgo_tp_cd"), "prc_cgo_tp_cd")) {
     			sheetObj.CellBackColor(i, "prc_cgo_tp_cd") = validColor;
     			validCnt++;
     		}
     		
     		// IMDG Class
     		if(!validCheckImdgClss(sheetObj, i, sheetObj.CellValue(i, "scg_imdg_clss_cd"))) {
     			sheetObj.CellBackColor(i, "scg_imdg_clss_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Cur
     		if(formObj.flt_pct_tp_cd.value == "F" && !validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))) {
     			sheetObj.CellBackColor(i, "curr_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Amount
     		if(!validCheckSurchargeAmount(sheetObj, i, sheetObj.CellValue(i, "scg_amt"))) {
     			sheetObj.CellBackColor(i, "scg_amt") = validColor;
     			validCnt++;
     		}
     		
     		// Pay Term
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")) {
     			sheetObj.CellBackColor(i, "pay_term_cd") = validColor;
     			validCnt++;
     		}
     		
     		// Effective Date
     		if(!validCheckEffectiveDate(sheetObj, i, sheetObj.CellValue(i, "eff_dt"))) {
     			sheetObj.CellBackColor(i, "eff_dt") = validColor;
     			validCnt++;
     		}
     		
     		// Expire Date
     		if(!validCheckExpireDate(sheetObj, i, sheetObj.CellValue(i, "exp_dt"))) {
     			sheetObj.CellBackColor(i, "exp_dt") = validColor;
     			validCnt++;
     		}
     		
     		// PSA Group
     		if(!validCheckPsaNo(sheetObj, i, sheetObj.CellValue(i, "psa_no"))) {
     			sheetObj.CellBackColor(i, "psa_no") = validColor;
     			validCnt++;
     		}
     		     		
     	   // Reefer Cargo Type 
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "rc_air_cond_tp_cd"), "rc_air_cond_tp_cd")) {
     			sheetObj.CellBackColor(i, "rc_air_cond_tp_cd") = validColor;
     			validCnt++;
     		}
     		
     	   // Contract Date
     		if( sheetObj.CellValue(i, "ctrt_dt") != "" && !validCheckContractDate(sheetObj, i, sheetObj.CellValue(i, "ctrt_dt"))) {
     			sheetObj.CellBackColor(i, "ctrt_dt") = validColor;
     			validCnt++;
     		}
     		
//     	   // Autorating Flag
//     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "act_rat_flg"), "act_rat_flg")) {
//     			sheetObj.CellBackColor(i, "act_rat_flg") = validColor;
//     			validCnt++;
//     		}
     		
     	  // Food Grade
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "fd_grd_flg"), "fd_grd_flg")) {
     			sheetObj.CellBackColor(i, "fd_grd_flg") = validColor;
     			validCnt++;
     		}

     	  // State Code
     		if(!validCheckState(sheetObj, i, sheetObj.CellValue(i, "ste_cd"), "ste_cd")) {
     			sheetObj.CellBackColor(i, "ste_cd") = validColor;
     			validCnt++;
     		}
     		
     	  // Arrival Date
     		if( sheetObj.CellValue(i, "arr_dt") != "" && !validCheckContractDate(sheetObj, i, sheetObj.CellValue(i, "arr_dt"))) {
     			sheetObj.CellBackColor(i, "arr_dt") = validColor;
     			validCnt++;
     		}
		}

        //document.body.scroll = "no";
		return validCnt;
	}
	
	/**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckLocation(sheetObj, i, "del_tp_cd", "del_def_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		
		if(ComIsNull(locCd)) {
			return true;
		}
		
		// Location
		if(locCd.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = locCd;
			var sXml = sheetObjects[3].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L";
				return true;
			} else {
				sheetObj.CellValue2(Row, cellTpCdNm) = "";
				return false;
			}
		}
		// Location Group
		else if(locCd.length == 4) {
			formObj.f_cmd.value = COMMAND11;
			formObj.cd.value = locCd;
			var param = "&etc1="+sheetObj.CellValue(Row, "svc_scp_cd")+"&etc2="+sheetObj.CellValue(Row, "chg_cd");
			var sXml = sheetObjects[3].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "G";
				return true;
			} else {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "";
				return false;
			}
		}
		// Country
		else if(locCd.length == 2) {
			formObj.f_cmd.value = SEARCH07;
			formObj.cd.value = locCd;
			var sXml = sheetObjects[3].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "C";
				return true;
			} else {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "";
				return false;
			}
		}
		// Region
		else if(locCd.length == 3) {
			formObj.f_cmd.value = COMMAND08;
			formObj.cd.value = locCd;
			var sXml = sheetObjects[3].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "R";
				return true;
			} else {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "R";
				return false;
			}
		} else {
			return false;
 		}
		return true;
	}
	
	/**
     * 유효성 확인하는 function <br>
     * 필수입력 항목인데 입력되지 않았을때 오류 리턴 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @param (string) CellName 필수 이벤트가 발생한 해당 셀의 Name
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.CellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	
	/**
     * ts_port_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTSPort(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckTSPort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		var formObj = document.form;
		if(Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = Value;
			var sXml = sheetObjects[3].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc != null && arrDesc.length > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	/**
     * ste_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckState(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 전윤주
     * @version 2014.04.15
     */ 
	function validCheckState(sheetObj, Row, Value) {

		if(ComIsNull(Value) && ComIsNull(sheetObj.CellValue(Row, "cnt_cd"))) { //country와 state에 값이 없으면 통과
			return true;
		}

		var combo_cnt_cd= sheetObj.CellValue(Row, "cnt_cd");
		var ui_id= "4003";		

		if (Value.length == 2||Value.length == 3) {
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH03;		
			var sXml = sheetObjects[3].GetSearchXml("ESM_PRI_4026GS.do", FormQueryString(formObj) + "&combo_cnt_cd=" + combo_cnt_cd + "&ste_cd=" + Value+ "&ui_id=" + ui_id);                                                                                                                                                                                                                                                                                                                                                                   
			var arrDesc = ComPriXml2Array(sXml, "ste_cd");    
			
			if(arrDesc != null && arrDesc.length > 0) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
		return true;
	}	
	
	/**
     * min_cgo_wgt 의 validation check function <br>
     * min_cgo_wgt의 최대값과 최소값 숫자여부를 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckMinCargoWeight(sheetObj, i, sheetObj.CellValue(i, "min_cgo_wgt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckMinCargoWeight(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}
		
		if(parseInt(Value) < 0) {
			return false;
		}
		
		if(parseInt(Value) >= 10000) {
			return false;
		}
		return true;
	}
	
	/**
     * max_cgo_wgt 의 validation check function <br>
     * max_cgo_wgt의 최대값과 최소값 숫자여부를 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckMinCargoWeight(sheetObj, i, sheetObj.CellValue(i, "min_cgo_wgt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckMaxCargoWeight(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}
		
		if(parseInt(Value) < 0) {
			return false;
		}
		
		if(parseInt(Value) >= 10000) {
			return false;
		}
		return true;
	}
	
	/**
     * cmdt_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckCommodity(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		var formObj = document.form; 
		if(Value.length == 6) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[3].GetSearchXml("ESM_PRI_4027GS.do", FormQueryString(formObj) + "&cmdt_cd=" + Value);
			var arrDesc = ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			if (arrDesc != null && arrDesc.length > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
     * rat_ut_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckCargoType(sheetObj, Row, Value) {
		var validPerClass = "A,F,O,Q,S,P";
		var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");
		
        if(Value == "AK" && (validPerClass.indexOf(sheetObj.CellValue(Row, "rat_ut_cd").charAt(0)) < 0 && ratUtCd != "20" && ratUtCd != "40" && ratUtCd != "HC" && ratUtCd != "BX")) {
       		return false;
        }
        return true;
	}
	
	/**
     * scg_imdg_clss_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckImdgClss(sheetObj, i, sheetObj.CellValue(i, "scg_imdg_clss_cd"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckImdgClss(sheetObj, Row, Value) {
		if(ComIsNull(Value) && ComTrim(sheetObj.CellText(Row, "scg_imdg_clss_cd")) != "") {
			return false;
		} 
		if(ComIsNull(Value)) {
			return true;
		}
		if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") != "DG") {
			return false;
		}
		return true;
	}
	
	/**
     * psa_no 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckPsaNo(sheetObj, i, sheetObj.CellValue(i, "psa_no"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 서미진
     * @version 2012.03.19
     */ 
	function validCheckPsaNo(sheetObj, Row, Value) {
		if(ComIsNull(Value) && ComTrim(sheetObj.CellText(Row, "psa_no")) != "") {
			return false;
		} 
		if(ComIsNull(Value)) {
			return true;
		}
		if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") != "DG") {
			return false;
		}
		return true;
	}	
	
	/**
     * curr_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckCurrency(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		
		if(!validCheckCommonCode(sheetObj, Row, Value, "curr_cd")) {
			return false;
		}
    	return true;
	}
	
	/**
     * scg_amt 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckSurchargeAmount(sheetObj, i, sheetObj.CellValue(i, "scg_amt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckSurchargeAmount(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}
		
		if(ComIsContainsChars(Value, ".")) {
			var temp = Value.split(".");
			if(temp[0].length > 9) {
				return false;
			}
			if(temp[1].length > 2) {
				return false;
			}
		} else {
			if(Value.length > 9) {
				return false;
			}
		}
		return true;
	}
	
	/**
     * eff_dt 의 validation check function <br>
     * 날짜타입이 맞는지 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckEffectiveDate(sheetObj, i, sheetObj.CellValue(i, "eff_dt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckEffectiveDate(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!ComIsDate(Value, "ymd")) {
			return false;
		}
		return true;
	}
	
	/**
     * exp_dt 의 validation check function <br>
     * 날짜타입이 맞는지 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckEffectiveDate(sheetObj, i, sheetObj.CellValue(i, "exp_dt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckExpireDate(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(!ComIsDate(Value, "ymd")) {
			return false;
		}
		
		if(!ComIsNull(sheetObj.CellValue(Row, "eff_dt")) && ComChkPeriod(sheetObj.CellValue(Row, "eff_dt"), Value) < 1) {
			return false;
		}
		return true;
    }
	
	/**
     * ctrt_dt 의 validation check function <br>
     * 날짜타입이 맞는지 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckContractDate(sheetObj, i, sheetObj.CellValue(i, "ctrt_dt"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.20
     */ 
	function validCheckContractDate(sheetObj, Row, Value) {		
		if(!ComIsDate(Value, "ymd")) {
			return false;
		}
		return true;
	}
     
    /**
     * tml_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
 	function validCheckTerminalCode(sheetObj, Row, Value) {
 		if(ComIsNull(Value)) {
 			return true;
 		}
 		
 		var formObj = document.form;
 		if (Value.length == 7) {
 			formObj.f_cmd.value = SEARCH;
 			var sXml = sheetObjects[3].GetSearchXml("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
 			var arrDesc = ComPriXml2Array(sXml, "yd_cd");
 			
 			if(arrDesc == null || arrDesc.length < 1) {
 				return false;
 			}
 		} else {
 			return false;
 		}
 		return true;
 	}
    /**
     * sheet에서 첫번째 오류 체크 행에 포커스를 위치하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setFirstValidCell(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */
    function setFirstValidCell(sheetObj) {
    	var topRow = sheetObj.TopRow;
		var lastRow = sheetObj.LastRow;
		var lastCol = sheetObj.LastCol;
		
    	for(var i=topRow; i<=lastRow; i++) {
			for(var j=0; j<=lastCol; j++) {
  				if(sheetObj.CellBackColor(i, j) == sheetObj.RgbColor(255,0,0)) {
                    sheetObj.SelectCell(i, j, false);
                    return;
                }
			}
		}
    }
    
    /**
     * sheet 의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */  
	function setSheetDisplay(sheetObj) {
    	var topRow = sheetObj.TopRow
		var lastRow = sheetObj.LastRow;
		
		for(var i=topRow; i<=lastRow; i++) {
			if(sheetObjects[1].CellValue(1, "por_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "por_def_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "pol_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "pol_def_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "pod_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "pod_def_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "del_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "del_def_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "imdg_clss_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "scg_imdg_clss_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "sub_trd_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "sub_trd_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "slan_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "vsl_slan_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "ts_port_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "ts_port_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "dir_call_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "dir_call_flg") = "";
    		}
			if(sheetObjects[1].CellValue(1, "tml_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "tml_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "trns_mod_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "org_trsp_mod_cd") = "";
    			sheetObjects[0].CellValue2(i, "dest_trsp_mod_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "usa_svc_mod_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "usa_svc_mod_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "rcv_de_term_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "prc_rcv_term_cd") = "";
    			sheetObjects[0].CellValue2(i, "prc_de_term_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "hngr_bar_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "prc_hngr_bar_tp_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "cgo_wgt_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "min_cgo_wgt") = "";
    			sheetObjects[0].CellValue2(i, "max_cgo_wgt") = "";
    		}
			if(sheetObjects[1].CellValue(1, "cmdt_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "cmdt_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "gri_cmdt_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "scg_grp_cmdt_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "soc_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "soc_flg") = "";
    		}
			if(sheetObjects[1].CellValue(1, "io_ga_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "io_ga_cd") = "";
    		}
			if(sheetObjects[1].CellValue(1, "psa_no_mng_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "psa_no") = "";
    		}
			if(sheetObjects[1].CellValue(1, "rc_air_cond_tp_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "rc_air_cond_tp_cd") = "";
    		}
			
			if(sheetObjects[1].CellValue(1, "ctrt_dt_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "ctrt_dt") = "";
    		}
			
//			if(sheetObjects[1].CellValue(1, "act_rat_use_flg") == "N") {
//    			sheetObjects[0].CellValue2(i, "act_rat_flg") = "";
//    		}
			
			if(sheetObjects[1].CellValue(1, "prn_hdn_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "prn_hdn_flg") = "";
    		}
			
			if(sheetObjects[1].CellValue(1, "fd_grd_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "fd_grd_flg") = "";
    		}	
			
			if(sheetObjects[1].CellValue(1, "ste_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "cnt_cd") = "";
    			sheetObjects[0].CellValue2(i, "ste_cd") = "";
    		}	
			
			if(sheetObjects[1].CellValue(1, "arr_dt_use_flg") == "N") {
    			sheetObjects[0].CellValue2(i, "arr_dt") = "";
    		}
			
			// Cargo Type
			if(sheetObj.CellValue(i, "prc_cgo_tp_cd") == "DG") {
				sheetObj.CellEditable(i, "scg_imdg_clss_cd") = true;
				sheetObj.CellEditable(i, "psa_no") = true;
			} else {
				sheetObj.CellValue(i, "scg_imdg_clss_cd") = "";
				sheetObj.CellEditable(i, "scg_imdg_clss_cd") = false;
				sheetObj.CellValue(i, "psa_no") = "";
				sheetObj.CellEditable(i, "psa_no") = false;
			}
			// Amount
			if(sheetObj.CellValue(i, "scg_amt") != 0) {
				sheetObj.InitCellProperty(i, "scg_amt", dtData, daRight, "scg_amt", "", dfNullFloat, 2, 11);
			} else {
				sheetObj.InitCellProperty(i, "scg_amt", dtData, daRight, "scg_amt", "", dfNullInteger);
			}
		}
		sheetObj.ColBackColor("scg_rmk") = sheetObj.RgbColor(255,255,255);
	}
     
  	/**
      * Array sort 시 numner를 sort하기 위하여 호출하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *    sortNumber()
      * </pre>
      * @param {int} a 비교할 첫번째값
      * @param {int} b 비교할 두번째값
      * @return int
      * @author 공백진
      * @version 2009.06.04
      */      
     function sortNumber(a,b){
    	 return a - b;
     }     
     

	/**
     * sheet의 row 중복을 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.06.04
     */ 
     
     function checkSheetRowDup(sheetObj) {
    	var tempSheet = sheetObjects[2];
		var srcCols = "";
		var destCols = "";
		srcCols += "seq|svc_scp_cd|por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|";
		srcCols += "min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|";
		srcCols += "cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|wdr_flg|eff_dt|exp_dt|psa_no|rc_air_cond_tp_cd|ctrt_dt|fd_grd_flg|cnt_cd|ste_cd|arr_dt";
         
		destCols += tempSheet.SaveNameCol("seq")+"|"+tempSheet.SaveNameCol("svc_scp_cd")+"|"+tempSheet.SaveNameCol("por_def_cd")+"|"+tempSheet.SaveNameCol("pol_def_cd")+"|"+tempSheet.SaveNameCol("pod_def_cd")+"|"+tempSheet.SaveNameCol("del_def_cd")+"|";
		destCols += tempSheet.SaveNameCol("rat_ut_cd")+"|"+tempSheet.SaveNameCol("prc_cgo_tp_cd")+"|"+tempSheet.SaveNameCol("scg_imdg_clss_cd")+"|"+tempSheet.SaveNameCol("curr_cd")+"|"+tempSheet.SaveNameCol("pay_term_cd")+"|";
		destCols += tempSheet.SaveNameCol("cnl_tz_cd")+"|"+tempSheet.SaveNameCol("min_cgo_wgt")+"|"+tempSheet.SaveNameCol("max_cgo_wgt")+"|"+tempSheet.SaveNameCol("org_trsp_mod_cd")+"|"+tempSheet.SaveNameCol("dest_trsp_mod_cd")+"|";
		destCols += tempSheet.SaveNameCol("prc_rcv_term_cd")+"|"+tempSheet.SaveNameCol("prc_de_term_cd")+"|"+tempSheet.SaveNameCol("prc_hngr_bar_tp_cd")+"|"+tempSheet.SaveNameCol("sub_trd_cd")+"|"+tempSheet.SaveNameCol("vsl_slan_cd")+"|";
		destCols += tempSheet.SaveNameCol("dir_call_flg")+"|"+tempSheet.SaveNameCol("tml_cd")+"|"+tempSheet.SaveNameCol("cmdt_cd")+"|"+tempSheet.SaveNameCol("io_ga_cd")+"|"+tempSheet.SaveNameCol("ts_port_cd")+"|";
		destCols += tempSheet.SaveNameCol("soc_flg")+"|"+tempSheet.SaveNameCol("scg_grp_cmdt_cd")+"|"+tempSheet.SaveNameCol("usa_svc_mod_cd")+"|"+tempSheet.SaveNameCol("wdr_flg")+"|"+tempSheet.SaveNameCol("eff_dt")+"|"+tempSheet.SaveNameCol("exp_dt")+"|"+tempSheet.SaveNameCol("psa_no")+"|"+tempSheet.SaveNameCol("rc_air_cond_tp_cd")+"|"+tempSheet.SaveNameCol("ctrt_dt")+"|";
		destCols += tempSheet.SaveNameCol("fd_grd_flg")+"|"+tempSheet.SaveNameCol("cnt_cd")+"|"+tempSheet.SaveNameCol("ste_cd")+"|"+tempSheet.SaveNameCol("arr_dt");
		tempSheet.RemoveAll();
		//중복체크할  컬럼만 copy
		sheetObj.Copy2SheetCol(tempSheet, srcCols, destCols, -1, -1, -1, 1);
		
		 // 영역의 데이터를 구분자 "|"와 "^"로 구분하여 String형태로 가져온다.
//		var comPareStr = tempSheet.GetRangeText(2,2,tempSheet.LastRow,tempSheet.LastCol - 2,"|","^");
		var comPareStr = tempSheet.GetRangeText(2,1,tempSheet.LastRow,tempSheet.LastCol ,"|","^");
		var arrBase = comPareStr.split("^");
		var arrDest = arrBase;
		var srcEffDt="";
		var srcExpDt="";
    	var trgtEffDt = "";
    	var trgtExpDt = "";
   	
		for (var i = 0; i < arrBase.length  ; i++){			
			srcEffDt = tempSheet.CellValue(i + 2, "eff_dt");
			srcExpDt = tempSheet.CellValue(i + 2, "exp_dt");

			for (var j = 0; j < arrDest.length ; j++){				

				if (tempSheet.CellValue(i + 2, "seq")!= tempSheet.CellValue(j + 2, "seq")						
						&& arrBase[i] == arrDest[j]){		        	
					trgtEffDt = tempSheet.CellValue(j + 2, "eff_dt");
					trgtExpDt = tempSheet.CellValue(j + 2, "exp_dt");
					// 항목이 중복된 Row의 날짜가 겹치는지 확인하여 메세지를 보여준다.
					
		        	if(ComIsNull(srcExpDt) && ComIsNull(trgtExpDt)) {
						if(srcEffDt == trgtEffDt) {
							ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
						}
						
		        		if (srcEffDt  <= trgtEffDt){
		        			ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
		        		}						
		        	} else if(ComIsNull(srcExpDt)) {
		        		if(trgtEffDt <= srcEffDt && srcEffDt <= trgtExpDt) {
		        			ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
		        		}
		        	} else if(ComIsNull(trgtExpDt)) {
		        	
		        		if(srcEffDt <= trgtEffDt && trgtEffDt <= srcExpDt) {
		        			ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
		        		}
		        		
		        		if (trgtEffDt <= srcEffDt){
		        			ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
		        		}
		        		
		        	} else {
		        		if((srcEffDt >= trgtEffDt && srcEffDt <= trgtExpDt) ||(srcExpDt >= trgtEffDt && srcExpDt <= trgtExpDt) || (srcEffDt <= trgtEffDt && srcExpDt >= trgtExpDt)) {
							ComShowCodeMessage("PRI02016", sheetObj.CellValue(i + 2, "seq"), sheetObj.CellValue(j + 2, "seq"));
							return false;
						}
		        	}
				}						
			}
		}
    	 return true;
     }     
     
//	function checkSheetRowDup1(sheetObj) {
//    	 var dupRows = sheetObj.ColValueDupRows("por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|" +
// 				"min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|" +
// 				"cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|wdr_flg", false, true);
//		
//		 if (dupRows == null || dupRows == "") {
//             return true;
//         }
//
//         var arrTemp = dupRows.split("|");
//         var arrBaseRowOri = arrTemp[0].split(",");
//         var arrDesRow = arrTemp[1].split(",");        
//         var arrBaseRow = arrBaseRowOri.concat(arrDesRow).sort(sortNumber);
//         var tempSheet = sheetObjects[2];
//         var srcCols = "";
//	 	 var destCols = "";
//	 	 
//	 	srcCols += "seq|por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|";
//        srcCols += "min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|";
//        srcCols += "cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|wdr_flg|eff_dt|exp_dt";
//         
//        destCols += tempSheet.SaveNameCol("seq")+"|"+tempSheet.SaveNameCol("por_def_cd")+"|"+tempSheet.SaveNameCol("pol_def_cd")+"|"+tempSheet.SaveNameCol("pod_def_cd")+"|"+tempSheet.SaveNameCol("del_def_cd")+"|";
//        destCols += tempSheet.SaveNameCol("rat_ut_cd")+"|"+tempSheet.SaveNameCol("prc_cgo_tp_cd")+"|"+tempSheet.SaveNameCol("scg_imdg_clss_cd")+"|"+tempSheet.SaveNameCol("curr_cd")+"|"+tempSheet.SaveNameCol("pay_term_cd")+"|";
//        destCols += tempSheet.SaveNameCol("cnl_tz_cd")+"|"+tempSheet.SaveNameCol("min_cgo_wgt")+"|"+tempSheet.SaveNameCol("max_cgo_wgt")+"|"+tempSheet.SaveNameCol("org_trsp_mod_cd")+"|"+tempSheet.SaveNameCol("dest_trsp_mod_cd")+"|";
//        destCols += tempSheet.SaveNameCol("prc_rcv_term_cd")+"|"+tempSheet.SaveNameCol("prc_de_term_cd")+"|"+tempSheet.SaveNameCol("prc_hngr_bar_tp_cd")+"|"+tempSheet.SaveNameCol("sub_trd_cd")+"|"+tempSheet.SaveNameCol("vsl_slan_cd")+"|";
//        destCols += tempSheet.SaveNameCol("dir_call_flg")+"|"+tempSheet.SaveNameCol("tml_cd")+"|"+tempSheet.SaveNameCol("cmdt_cd")+"|"+tempSheet.SaveNameCol("io_ga_cd")+"|"+tempSheet.SaveNameCol("ts_port_cd")+"|";
//        destCols += tempSheet.SaveNameCol("soc_flg")+"|"+tempSheet.SaveNameCol("scg_grp_cmdt_cd")+"|"+tempSheet.SaveNameCol("usa_svc_mod_cd")+"|"+tempSheet.SaveNameCol("wdr_flg")+"|"+tempSheet.SaveNameCol("eff_dt")+"|"+tempSheet.SaveNameCol("exp_dt");
//         
//         for(var i=0; i<arrBaseRow.length; i++) {
//        	 tempSheet.RemoveAll();
//        	 sheetObj.Copy2SheetCol(tempSheet, srcCols, destCols, arrBaseRow[i], arrBaseRow[i], -1, 2);
//        	 
//        	 for(var j=0; j<arrDesRow.length; j++) {
//        		 tempSheet.RowDelete(3,false);
//        		 sheetObj.Copy2SheetCol(tempSheet, srcCols, destCols, arrDesRow[j], arrDesRow[j], -1, 2);
//	        	 if (tempSheet.CellValue(2 ,"seq") >= tempSheet.CellValue(3,"seq") ){
//	        		 continue;
//	        	 }
//	        	 // 중복체크할 항목을 설정한다
//	        	 var dupRows2 = tempSheet.ColValueDupRows("por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|" +
//			 				"min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|" +
//			 				"cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|wdr_flg", false, true);
//		         if (dupRows2 == null || dupRows2 == "") {
//		             continue;
//		         }
//		         
//		         var srcEffDt = tempSheet.CellValue(2, "eff_dt");
//		         var srcExpDt = tempSheet.CellValue(2, "exp_dt");
//		         var trgtEffDt = tempSheet.CellValue(tempSheet.LastRow, "eff_dt");
//				 var trgtExpDt = tempSheet.CellValue(tempSheet.LastRow, "exp_dt");
//
//				 if((srcEffDt >= trgtEffDt && srcEffDt <= trgtExpDt) ||(srcExpDt >= trgtEffDt && srcExpDt <= trgtExpDt) || (srcEffDt <= trgtEffDt && srcExpDt >= trgtExpDt)) {
//					ComShowCodeMessage("PRI02016", sheetObj.CellValue(arrBaseRow[i], "seq"), sheetObj.CellValue(arrDesRow[j], "seq"));
//					return false;
//				 }
//	         }
//         }
//         return true;
//	}
	
    /**
     * button의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) 필수 button 설정 mode
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
	function toggleButtons(mode) {
		switch (mode) {
			case "CLEAR":
				ComBtnDisable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_close");
				break;
			case "INIT":
				ComBtnEnable("btn_openfile");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_close");
				break;
			case "READONLY":
				ComBtnEnable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_close");
				break;
		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	  		case IBSEARCH_ASYNC01: // 체크
	  			
		  		if(!sheetObj.IsDataModified) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			
	  			var topRow = sheetObj.TopRow;
	  			var lastRow = sheetObj.LastRow;
	  			var lastCol = sheetObj.LastCol;
	  			
		  		//셀 바탕색 초기화
		  		for(var i=topRow; i<=lastRow; i++) {
		  			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255);
		  		}
		  		
		  		//데이타 유효성 체크
	  			var validCnt = validateCheckSheet(sheetObjects[0], formObj);
		  		
		  		if(validCnt > 0) {
		  			errFlg = true;
		  			ComBtnDisable("btn_save");
		  			setFirstValidCell(sheetObj);
		  			return false;
		  		} else {
		  			errFlg = false;
		  			//모든셀 readonly 처리할것
		  			sheetObjects[0].Editable = false;
		  			ComBtnEnable("btn_save");
		  		}
		  		return true;
		  		break;
		  		
	  		case IBSAVE:
	  			// Amount 값에 0이 존재하면 저장할지 확인한다
				var isConfirm = false;
	  			var topRowSheet1 = sheetObjects[0].TopRow;
	  			var lastRowSheet1 = sheetObjects[0].LastRow;
	  			
				for(var i=topRowSheet1; i<=lastRowSheet1; i++) {
					if(sheetObjects[0].CellValue(i, "scg_amt") == 0) {
						if(ComShowCodeConfirm('PRI02003', sheetObjects[0].CellText(0, "scg_amt"))) {
							isConfirm = true;
							break;
						} else {
							sheetObjects[0].SelectCell(i, "scg_amt");
							return false;
						}
					}
				}
				
                // 입력한 effective date, expiration date 점검 [CHM-201428968/ 방지경]
				
				for(var i=topRowSheet1; i<=lastRowSheet1; i++) {					
					if(  sheetObjects[0].CellValue(i, "exp_dt") != ""
					  && sheetObjects[0].CellValue(i, "exp_dt") < (ComGetNowInfo("ymd", "-").replace(/-/gi, "")-1)) {
						if(ComShowCodeConfirm('PRI02021')) {                                                                                                                                                                                                                                                                                                                                                                                    
							isConfirm = true;                                                                                                                                                                                                                                                                                                                                                                                               
							break;                                                                                                                                                                                                                                                                                                                                                                                                          
						} else {                                                                                                                                                                                                                                                                                                                                                                                                                
							sheetObjects[0].SelectCell(i, "exp_dt");                                                                                                                                                                                                                                                                                                                                                                       
							return false;                                                                                                                                                                                                                                                                                                                                                                                                   
						}                                                                                                                                                                                                                                                                                                                                                                                                                       
					}                                                                                                                                                                                                                                                                                                                                                                                                                               
				}
				for(var i=topRowSheet1; i<=lastRowSheet1; i++) {					
					if(  sheetObjects[0].CellValue(i, "eff_dt") != ""
					  && sheetObjects[0].CellValue(i, "eff_dt") < ComGetNowInfo("ymd", "-").replace(/-/gi, "")) {
						if(ComShowCodeConfirm('PRI02020')) {                                                                                                                                                                                                                                                                                                                                                                                    
							isConfirm = true;                                                                                                                                                                                                                                                                                                                                                                                               
							break;                                                                                                                                                                                                                                                                                                                                                                                                          
						} else {                                                                                                                                                                                                                                                                                                                                                                                                                
							sheetObjects[0].SelectCell(i, "eff_dt");                                                                                                                                                                                                                                                                                                                                                                       
							return false;                                                                                                                                                                                                                                                                                                                                                                                                   
						}                                                                                                                                                                                                                                                                                                                                                                                                                       
					}                                                                                                                                                                                                                                                                                                                                                                                                                               
				}
		
				if(!isConfirm) { //이미 확인을 했으면 그냥 진행
					if (!ComPriConfirmSave()) { //앞에서 확인팝업 안떴으면 저장할지 여부 확인
						return false;
					}
				}
				
	  			if(!sheetObjects[0].IsDataModified) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			
	  			//중복체크
	  			if(!checkSheetRowDup(sheetObjects[0])) {
	  				sheetObjects[0].Editable = true;
	  				ComBtnDisable("btn_save");
	  				ComBtnEnable("btn_check");
	  				return false;
	  			}
	  			return true;
	  			break;
    	}		
        return true;
    }

/* 개발자 작업  끝 */