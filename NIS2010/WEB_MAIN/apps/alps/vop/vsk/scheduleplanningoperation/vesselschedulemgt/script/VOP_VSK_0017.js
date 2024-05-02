/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0017.js
*@FileTitle : Daily Berth Window
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.25 유혁
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 [CHM-201109291-01] Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.04.20 진마리아 [CHM-201110283-01] Daily Berth Window 로직 변경 요청
* 2011.06.16 진마리아 [CHM-201111613-01] Daily Berth Window의 Mail 전송 버튼에 대한 검증 로직 변경
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
     * @class LRS Creation : LRS Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.initCombo            	= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var originalVVDYard		= null;
	var currentVVDYard		= null;
	
//	var glbYdNmArr = null;
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];   //t1sheet1
        var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrieve":
					formObj.page_no.value = "1";
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
	
				case "btn_save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;

				case "btn_group":
					var sUrl = "/hanjin/VOP_VSK_0228.do";
					ComOpenPopupWithTarget(sUrl, 406, 470, "", "0,0", true);
					setLaneGrpNmCombo();
					break;

				case "btn_send_gwmail":
					doActionIBSheet(sheetObject, formObj, COMMAND03);
					break;
					
				case "btn_send_mail":
					doActionIBSheet(sheetObject, formObj, COMMAND04);
					break;

				case "btn_send_edi":
					/*
					 * PORT CODE 가 KR 로 시작하면서 YARD CODE 가 KRPUSY0 이 아닌 건만 전송.
					 */
					doActionIBSheet(sheetObject, formObj, MULTI02);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
					break;

				case "btn_port":
					doActionIBSheet(sheetObject, formObj, COMMAND01);
					break;

				case "btn_lane":
					doActionIBSheet(sheetObject, formObj, COMMAND02);
					break;
					
				case "btn_period":
					var cal = new ComCalendarFromTo();
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
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
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
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
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
        
        initControl();
        
        setDirectionCombo();
        setLaneGrpCombo();
        
//        document.form.fm_dt.value = ComGetDateAdd(null, "M", -1);
//		document.form.to_dt.value = ComGetNowInfo();
        document.form.fm_dt.value = ComGetNowInfo();
        document.form.to_dt.value = ComGetDateAdd(null, "D", 7);
        	
		document.form.vps_port_cd.focus();
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
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS]
                    InitRowInfo( 2, 1, 2, document.form.pagerows.value);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(98, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false, false);

                    var HeadTitle  = "|CHK|Lane|VVD|TMNL|TMNL|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD|Coastal SKD||Updated|Updated|TMNL Using Code|TMNL Using Code|Cargo Vol.|Cargo Vol.|Cargo Working Time|Cargo Working Time|Free Time|Remark(s)" +
                    		"|UVI No.|PLISM TRS Code|PLISM TRS Code|PLISM TRS Code||||";
					var HeadTitle1  = "|CHK|Lane|VVD|Code|Pier No.|Pre VVD|Pre Port|Pre ETD|ETA|ETB|ETD|Nxt VVD|Nxt Port|Nxt ETA||ID|Date|VSL|Voy. No|I/B|O/B|COMM Date|COMP Date|Free Time|Remark(s)" +
							"|UVI No.|TMNL|VSL|Voy. No||||";
					
                 
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);


                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, 	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,  false,   	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,			46,		daCenter,	true,		prefix+"del_chk",			false,		"",			dfNone,			0,			true,		true);	
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"slan_cd",			false,		"",			dfNone,			0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix+"vvd",				false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		prefix+"yd_cd",				false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		prefix+"skd_brth_no",		false,		"",			dfNone,			0,			true,		true);
					
					
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		prefix+"pre_vvd",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		prefix+"pre_port_cd",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			110,	daCenter,	true,		prefix+"pre_etd_dt",		false,		"",			dfUserFormat2,	0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,				110,	daCenter,	true,		prefix+"vps_eta_dt",		false,		"",			dfUserFormat2,	0,			true,		true);	
					InitDataProperty(0, cnt++ , dtData,				110,	daCenter,	true,		prefix+"vps_etb_dt",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				110,	daCenter,	true,		prefix+"vps_etd_dt",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		prefix+"nxt_vvd",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		prefix+"nxt_port_cd",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			110,	daCenter,	true,		prefix+"nxt_eta_dt",		false,		"",			dfUserFormat2,	0,			false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,			125,	daCenter,	true,		prefix+"vsl_svc_tp_cd",		false,		"",			dfNone,			0,			true,		true,		2);

//					InitDataProperty(0, cnt++ , dtData,				40,		daLeft,		true,		prefix+"rev_flg",			false,		"",			dfNone,			0,			false,		false);

					
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix+"upd_usr_id",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				110,	daCenter,	true,		prefix+"upd_dt_txt",		false,		"",			dfUserFormat2,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"tml_vsl_cd",		false,		"",			dfNone,			0,			true,		true,		4);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"tml_voy_no",		false,		"",			dfNone,			0,			true,		true,		7);
					InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"ib_cgo_qty",		false,		"",			dfInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"ob_cgo_qty",		false,		"",			dfInteger,		0,			true,		true);
//					InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"cgo_ttl",			false,		"",			dfInteger,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"crn_wrk_cmnc_dt",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"crn_wrk_cmpl_dt",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				110,	daCenter,	true,		prefix+"free_tm_dt",		false,		"",			dfUserFormat2,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				140,	daLeft,		true,		prefix+"win_rmk",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix+"uq_vsl_id_no",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		prefix+"plism_yd_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"plism_vsl_cd",		false,		"",			dfNone,			0,			true,		true,		4);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"plism_voy_no",		false,		"",			dfNone,			0,			true,		true,		2);
					
					InitDataProperty(0, cnt++ , dtHidden,			125,		daCenter,	true,		prefix+"usr_nm",		false,		"",			dfNone,			0,			true,		true,		2);
					InitDataProperty(0, cnt++ , dtHidden,			125,		daCenter,	true,		prefix+"mphn_no",		false,		"",			dfNone,			0,			true,		true,		2);
					InitDataProperty(0, cnt++ , dtHidden,			125,		daCenter,	true,		prefix+"fax_no",		false,		"",			dfNone,			0,			true,		true,		2);
					InitDataProperty(0, cnt++ , dtHidden,			125,		daCenter,	true,		prefix+"usr_eml",		false,		"",			dfNone,			0,			true,		true,		2);

					
					
					
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_dir_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "vps_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "clpt_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skd_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "call_yd_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etd_dt");
					
					
					setHiddenInitDataProperty(sheetObj, cnt++, "init_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etb_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_etd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_desc");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_dlay_rsn_loc_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "shp_call_no_upd_dt");
//					setHiddenInitDataProperty(sheetObj, cnt++, "tml_vsl_cd");
					
//					setHiddenInitDataProperty(sheetObj, cnt++, "tml_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "ft_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_cng_sts_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_port_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_port_ind_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_voy_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_skd_dir_cd");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "turn_clpt_ind_seq");
					setHiddenInitDataProperty(sheetObj, cnt++, "crn_wrk_cmnc_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "crn_wrk_cmpl_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "phs_io_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "skd_brth_no");
					setHiddenInitDataProperty(sheetObj, cnt++, "init_skd_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "ofc_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "noon_rpt_inp_flg");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "dep_rpt_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "act_inp_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "prt_chk_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_usr_id");
					setHiddenInitDataProperty(sheetObj, cnt++, "cre_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "upd_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "edi_snd_knt");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_tp_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_skp_rsn_offr_rmk");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "ttl_dlay_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "ts_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "usd_flg");
					setHiddenInitDataProperty(sheetObj, cnt++, "vps_rmk");
					setHiddenInitDataProperty(sheetObj, cnt++, "bfr_act_flg");
					
					setHiddenInitDataProperty(sheetObj, cnt++, "lnk_spd");
					setHiddenInitDataProperty(sheetObj, cnt++, "sea_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "port_buf_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "tztm_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "act_wrk_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "lnk_dist");
					setHiddenInitDataProperty(sheetObj, cnt++, "mnvr_out_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "mnvr_in_hrs");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_eta_dy");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etb_dy");
					setHiddenInitDataProperty(sheetObj, cnt++, "pf_etd_dy");
					setHiddenInitDataProperty(sheetObj, cnt++, "nxt_port_cd");
					setHiddenInitDataProperty(sheetObj, cnt++, "nxt_eta_dt");
					setHiddenInitDataProperty(sheetObj, cnt++, "vsl_eng_nm");
					
					InitUserFormat2(0, prefix+"pre_etd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"nxt_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"upd_dt_txt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"free_tm_dt", "####-##-## ##:##", "-|:" );
					
					InitDataValid(0, prefix+"tml_vsl_cd", vtEngUpOther, "0123456789");
//					InitDataValid(0, prefix+"tml_voy_no", vtNumericOnly);
					InitDataValid(0, prefix+"skd_brth_no", vtEngOther, "0123456789.");
					InitDataValid(0, prefix+"vps_rmk", vtEngOther, "0123456789,./?!-_~;:");
					InitDataValid(0, prefix+"plism_vsl_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix+"plism_voy_no", vtNumericOnly);
					
					ColHidden(prefix+"uq_vsl_id_no") = true;
					ColHidden(prefix+"plism_yd_cd") = true;
					ColHidden(prefix+"plism_vsl_cd") = true;
					ColHidden(prefix+"plism_voy_no") = true;
					
					
					FrozenCols = SaveNameCol(prefix+"yd_cd");
					
//					CountPosition = "0";
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
			   }
               break;

        }
    }
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {
   	    	case "yd_cd":
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("35|360");
  					DropHeight = 160;
   		    	}
   	    		break;
	    	case "skd_dir_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("40");
  					DropHeight = 160;
   		    	}
   	    		break;
	    	case "lane_grp":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("100");
  					DropHeight = 160;
   		    	}
	    		break;
	    	case "lane_grp_nm":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");
  					SetColWidth("60");
  					DropHeight = 160;
   		    	}
	    		break;
   	    }
   	}
   	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;

			case SEARCH01:      //Yard Code 조회
				formObj.f_cmd.value = SEARCH01;
		    	
		    	var prefix = sheetObj.id + "_";
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0017GS.do", sParam);
				
				return sXml;
				
				break;
			case SEARCH02:      //Direction 조회
				formObj.f_cmd.value = SEARCH02;
		    	
		    	var prefix = sheetObj.id + "_";
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0017GS.do", sParam);
				
				return sXml;
				
				break;
			case SEARCH03:      //UserLaneGroup 조회
				formObj.f_cmd.value = SEARCH03;
		    	
		    	var prefix = sheetObj.id + "_";
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0017GS.do", sParam);
				
				return sXml;
				
				break;

			case IBSAVE:        //저장
		    	// PLISM TRS Code 값이 Actual SKD이 입력이 되어도 수정하여 저장 가능하도록 변경.
				// saveStatusControl 기능 사용하지 않음
//				saveStatusControl(sheetObj);
				
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = MULTI;
					
					var sParam = ComGetSaveString(sheetObjects, false);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0017GS.do", sParam);
					ComOpenWait(false);
					
					
					//::2013-12-13:://
//				    var reversedPortInfo = ComGetEtcData(sXml, "ReversedPortInfo");
//				    
//				    if(reversedPortInfo != null && reversedPortInfo != ""){
//				    ComShowCodeMessage("VSK00108", reversedPortInfo);
//				    }

				    /////////////////////////////////////////////////////////////////////
					
					sheetObj.LoadSaveXml(sXml);
					
//					//SAVE OK 일 경우 저장된 내용 다시 조회.
//					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
//					if(nodeText == "OK"){
//						doActionSearch(sheetObj, formObj, SEARCH);
//					}
				}

				break;

			case MULTI02:        //EDI 전송
				if(validateForm(sheetObj,formObj,sAction)){
					if(ComShowCodeConfirm("VSK01020")){
						
						//2009 10 08 Send EDI 추가 개발 
						//2013.02.13 LANE INFORMATION 의무발송 사항이므로 CONFIRM 확인창 삭제처리함//
						var usrInfo = "Y";
						////if(ComShowCodeConfirm("VSK00090")){
						////	usrInfo = "Y";
						////}
						
						var prefix = sheetObj.id + "_";
						var headCnt = sheetObj.HeaderRows;
						var rowCnt = sheetObj.RowCount;
						var totalCnt = headCnt+rowCnt;
						
						for(var i=headCnt; i<totalCnt; i++){
							if(sheetObj.CellValue(i,prefix+"del_chk") == "1"){
//								sheetObj.CellValue(i,prefix+"ibflag") = "U";
								sheetObj.RowStatus(i) = "U";
							}
						}
	
						formObj.f_cmd.value = MULTI02;
						formObj.usrInfo.value = usrInfo;
	
						var SaveStr = ComGetSaveString(sheetObjects);
				     	var sXml = sheetObj.GetSaveXml("VOP_VSK_0017GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSaveXml(sXml);
						
						//SAVE OK 일 경우 저장된 내용 다시 조회.
//						var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
//						if(nodeText == "OK"){
//							doActionSearch(sheetObj, formObj, SEARCH);
//						}
					}
				}

				break;

			case IBDOWNEXCEL:      // 엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
                break;

			case COMMAND01:        //Port Pop-up
				sUrl = "/hanjin/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
				ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
                break;

			case COMMAND02:        //Lane Pop-up
				sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.slan_cd.value;
				ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
                break;

			case COMMAND03:        //GW MAIL 전송
				sendGroupwareMail(sheetObj, formObj);
                break;
                
			case COMMAND04:
				sendMail(sheetObj, formObj);
				break;
				
			default:
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
		var checkCnt = 0;
		
    	switch(sAction) {
			case IBSEARCH:      //조회
				if(ComIsNull(formObj.vps_port_cd.value)){
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.focus();
					return false;
				} else if(ComIsNull(formObj.fm_dt.value)){
					ComShowCodeMessage('VSK00027', "Period(From)");
					formObj.fm_dt.focus();
					return false;
				} else if(ComIsNull(formObj.to_dt.value)){
					ComShowCodeMessage('VSK00027', "Period(To)");
					formObj.to_dt.focus();
					return false;
				}
				// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
				if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
					ComShowCodeMessage("VSK00105", "1 year");
					return false;
				}
				
				/* date format validation check logic ::2013-04-23 */
				var start_date 	= formObj.fm_dt.value;
				var end_date 	= formObj.to_dt.value;
				if(!ComIsDate(start_date))	return false;
				if(!ComIsDate(end_date))	return false;
				////////////////////////////////////////////////////				
				
				break;
				
			case SEARCH01:      //Yard Code 조회
				if(ComIsNull(formObj.vps_port_cd.value)){
					getComboObject("yd_cd").removeAll();
					return false;
				}else if(formObj.vps_port_cd.value.length < 5){
					ComShowCodeMessage('VSK00021', "Port:"+formObj.vps_port_cd.value);
					formObj.vps_port_cd.value = "";
					formObj.loc_cd.value = "";
					getComboObject("yd_cd").removeAll();
					formObj.vps_port_cd.focus();
					return false;
				}
				break;
				
			case IBSAVE:      	//저장
				var preTemp = "";
			    var nxtTemp = "";
				
				if(totCnt > headCnt){
					for(var i=headCnt; i<=totCnt; i++){
						//Update 건만 검사.
						if(sheetObj.RowStatus(i) == "U"){
							//ETA 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//ETB 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//ETD 날짜 포맷 검사.
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							

							if(sheetObj.CellValue(i, prefix+"pre_etd_dt") >= sheetObj.CellValue(i, prefix+"vps_eta_dt") && sheetObj.CellValue(i, prefix+"pre_etd_dt") != ""){
								sheetObj.CellBackColor(i, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 0, 0);
								preTemp = preTemp + sheetObj.CellValue(i, prefix+"vvd") +" :  "+ sheetObj.CellValue(i, prefix+"pre_vvd") +", "+ sheetObj.CellValue(i, prefix+"pre_port_cd") +"("+ sheetObj.CellValue(i, prefix+"pre_etd_dt")+")\n";
								
								
							} 
							if(sheetObj.CellValue(i, prefix+"vps_eta_dt") >= sheetObj.CellValue(i, prefix+"vps_etb_dt")){
								ComShowCodeMessage("VSK00098", i-headCnt+1, sheetObj.CellValue(i, prefix+"vvd"));
								sheetObj.SelectCell(i, prefix+"vps_etb_dt");
								return false;
							} 
							if(sheetObj.CellValue(i, prefix+"vps_etb_dt") >= sheetObj.CellValue(i, prefix+"vps_etd_dt")){
								ComShowCodeMessage("VSK00098", i-headCnt+1, sheetObj.CellValue(i, prefix+"vvd"));
								sheetObj.SelectCell(i, prefix+"vps_etd_dt");
								return false;
							} 
							if(sheetObj.CellValue(i, prefix+"vps_etd_dt") >= sheetObj.CellValue(i, prefix+"nxt_eta_dt") && sheetObj.CellValue(i, prefix+"nxt_eta_dt") != ""){
								sheetObj.CellBackColor(i, prefix+"vps_etd_dt") = sheetObj.RgbColor(255, 0, 0);
								nxtTemp =  nxtTemp + sheetObj.CellValue(i, prefix+"vvd") +" :  "+ sheetObj.CellValue(i, prefix+"nxt_vvd") +", "+ sheetObj.CellValue(i, prefix+"nxt_port_cd") +"("+ sheetObj.CellValue(i, prefix+"nxt_eta_dt")+")\n";
								
							}
						}
					} // end for
					
					
					if(preTemp != "" || nxtTemp != ""){
						if(preTemp != "" && nxtTemp == ""){
							preTemp = "<Previous VVD, Port>\n" + preTemp;
							ComShowCodeMessage("VSK01021",preTemp);
		//					alert(preTemp); 
						}else if(preTemp == "" && nxtTemp != ""){
							nxtTemp = "<Next VVD, Port>\n" + nxtTemp;
							ComShowCodeMessage("VSK01021",nxtTemp);
						}else{
							preTemp = "<Previous VVD, Port>\n" + preTemp;
							nxtTemp = "<Next VVD, Port>\n" + nxtTemp;
							ComShowCodeMessage("VSK01021",preTemp,nxtTemp);
						}
					}
				}
				break;
				
			case MULTI02:      	//EAI 전송
				if(ComIsNull(formObj.vps_port_cd.value)){
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.focus();
					return false;
				}
				
				if(rowCnt < 1){
					ComShowCodeMessage('VSK00043');
					return false;
				}
				
				for(var i=headCnt; i<=totCnt; i++){
					if(sheetObj.CellValue(i,prefix+"del_chk") == "1"){
						//Check 건만 검사.
						checkCnt++;
						
						//ETA < ETB < ETD 순서를 유지.
						if(sheetObj.CellValue(i, prefix+"vps_eta_dt") >= sheetObj.CellValue(i, prefix+"vps_etb_dt")){
							ComShowCodeMessage("VSK00098", i+1, sheetObj.CellValue(i, prefix+"vvd"));
							sheetObj.SelectCell(i, prefix+"vps_etb_dt");
							return false;
						} else {
							if(sheetObj.CellValue(i, prefix+"vps_etb_dt") >= sheetObj.CellValue(i, prefix+"vps_etd_dt")){
								ComShowCodeMessage("VSK00098", i+1, sheetObj.CellValue(i, prefix+"vvd"));
								sheetObj.SelectCell(i, prefix+"vps_etd_dt");
								return false;
							}
						}
					}
				}
				
				if(checkCnt == 0){
					ComShowCodeMessage('VSK00020');
					return false;
				}
				
				break;
    	}

        return true;
    }
    
    /**
     * 해당 목록을 조회
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj, sAction){
    	formObj.f_cmd.value = SEARCH;
    	
    	var prefix = sheetObj.id + "_";
		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0017GS.do", sParam);
		ComOpenWait(false);
		showSheetData(sheetObj, formObj, sXml);
		
//		initButton();

		//All Check 초기화
		sheetObj.CheckAll(prefix+"del_chk") = 0;
    }
    
    /**
     * 조회 후 처리로직.
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = 0;
    	
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					
					var ydCds = " |"+ComGetEtcData(sXml, "yd_cd");
					var ydNms = " |"+ComGetEtcData(sXml, "yd_nm");
					var ydTxts = "";
//					glbYdNmArr = (" |"+ComGetEtcData(sXml, "yd_nm")).split("|");
					
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						var ydCdArr = ydCds.split("|");
						var ydNmArr = ydNms.split("|");
						var ydCnt = ydCdArr.length;
						ydTxts = ydCdArr[0] + "\t" + ydNmArr[0];
						for(var i=1; i<ydCnt; i++){
							ydTxts = ydTxts + "|" + ydCdArr[i] + "\t" + ydNmArr[i];
						}
						
						sheetObj.InitDataCombo(0, prefix+"yd_cd", ydTxts, ydCds, "");
						sheetObj.InitDataCombo(0, prefix+"plism_yd_cd", ydTxts, ydCds, "");
					}
					
					if(formObj.page_no.value=="1"){
						sheetObj.LoadSearchXml(sXml, false);
					}else{						
						sheetObj.LoadSearchXml(sXml, true);
					}
					
					rowCnt = sheetObj.RowCount;
					
					for(var i=0; i<rowCnt; i++) {
						//마지막 Actual 이전의 Port는 모두 수정 불가.
			    		if(sheetObj.CellValue(i+headCnt, prefix+"bfr_act_flg") == "X"){
//			    			sheetObj.RowEditable(i+headCnt) = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etb_dt") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etd_dt") = false;
			    			
			    			sheetObj.CellEditable(i+headCnt, prefix+"yd_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"skd_brth_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_vsl_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_voy_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ib_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ob_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"free_tm_dt") = false;

			    			// PLISM TRS Code 값이 Actual SKD이 입력이 되어도 수정하여 저장 가능하도록 변경.
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_yd_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_vsl_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_voy_no") = true;
			    		} else if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "A"){
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
			    			
			    			sheetObj.CellEditable(i+headCnt, prefix+"yd_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"skd_brth_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_vsl_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_voy_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ib_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ob_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"free_tm_dt") = false;
			    			// PLISM TRS Code 값이 Actual SKD이 입력이 되어도 수정하여 저장 가능하도록 변경.
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_yd_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_vsl_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_voy_no") = true;
			    		} else if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "B") {
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etb_dt") = false;
			    			
			    			sheetObj.CellEditable(i+headCnt, prefix+"yd_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"skd_brth_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_vsl_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_voy_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ib_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ob_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"free_tm_dt") = false;
			    			// PLISM TRS Code 값이 Actual SKD이 입력이 되어도 수정하여 저장 가능하도록 변경.
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_yd_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_vsl_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_voy_no") = true;
			    		} else if(sheetObj.CellValue(i+headCnt, prefix+"port_skd_sts_cd") == "D") {
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_eta_dt") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etb_dt") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"vps_etd_dt") = false;
			    			
			    			sheetObj.CellEditable(i+headCnt, prefix+"yd_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"skd_brth_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_vsl_cd") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"tml_voy_no") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ib_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"ob_cgo_qty") = false;
			    			sheetObj.CellEditable(i+headCnt, prefix+"free_tm_dt") = false;
			    			// PLISM TRS Code 값이 Actual SKD이 입력이 되어도 수정하여 저장 가능하도록 변경.
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_yd_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_vsl_cd") = true;
			    			sheetObj.CellEditable(i+headCnt, prefix+"plism_voy_no") = true;
			    		}
			    		if(i>1){
							if(sheetObj.CellValue(i+headCnt, prefix+"pre_etd_dt") >= sheetObj.CellValue(i+headCnt, prefix+"vps_eta_dt") && sheetObj.CellValue(i+headCnt, prefix+"pre_etd_dt") != ""){
								sheetObj.CellBackColor(i+headCnt, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 0, 0);
							} 
							if(sheetObj.CellValue(i+headCnt, prefix+"vps_eta_dt") >= sheetObj.CellValue(i+headCnt, prefix+"vps_etb_dt")){
								sheetObj.CellBackColor(i+headCnt, prefix+"vps_etb_dt") = sheetObj.RgbColor(255, 0, 0);
								sheetObj.SelectCell(i+headCnt, prefix+"vps_etb_dt");
							} 
							if(sheetObj.CellValue(i+headCnt, prefix+"vps_etb_dt") >= sheetObj.CellValue(i+headCnt, prefix+"vps_etd_dt")){
								sheetObj.CellBackColor(i+headCnt, prefix+"vps_etd_dt") = sheetObj.RgbColor(255, 0, 0);
								sheetObj.SelectCell(i+headCnt, prefix+"vps_etd_dt");
							} 
							if((sheetObj.CellValue(i+headCnt, prefix+"vps_etd_dt") >= sheetObj.CellValue(i+headCnt, prefix+"nxt_eta_dt")) && sheetObj.CellValue(i+headCnt, prefix+"nxt_eta_dt") != ""){
								sheetObj.CellBackColor(i+headCnt, prefix+"vps_etd_dt") = sheetObj.RgbColor(255, 0, 0);
							}
			    		}
					}
		    		
					sheetObj.Redraw = true;
				}else{
					sheetObj.LoadSearchXml(sXml);
					formObj.vps_port_cd.focus();
					formObj.vps_port_cd.select();
				}
			}
		}
    }
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
    
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		var formObj = document.form;
		formObj.page_no.value = PageNo;
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
	
	function sheet1_OnClick(sheetObj, Row, Col) {
		var prefix = sheetObj.id + "_";
		var formObj = document.form;
		var headCnt = sheetObj.HeaderRows;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"win_rmk"){
					
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, prefix+"vps_rmk"));
				if(sheetObj.CellValue(Row, prefix+"bfr_act_flg") == "X"){
					sUrl = sUrl + "&readonly=true";
				}
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
				if(rVal || rVal == ""){
					sheetObj.CellValue2(Row, prefix+"vps_rmk") = rVal;
					sheetObj.CellValue2(Row, prefix+"win_rmk") = rVal.replace(/\n/g, "").replace(/\r/g, "");
				}
			}
			
			if(colName == prefix+"yd_cd") {		
					originalVVDYard = sheetObj.CellValue(Row, prefix+"vvd")+ sheetObj.CellValue(Row, prefix+"yd_cd"); 
			}
		}
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var prefix = sheetObj.id + "_";
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"yd_cd"){
				currentVVDYard = sheetObj.CellValue(Row, prefix+"vvd") + sheetObj.CellValue(Row, prefix+"yd_cd"); 
				for(var i=headCnt; i<=sheetObj.LastRow; i++){
					var compareVVDYard = sheetObj.CellValue(i, prefix+"vvd") + sheetObj.CellValue(i, prefix+"yd_cd");
					if(currentVVDYard == compareVVDYard && i != Row){
						ComShowCodeMessage("VSK57024");
						sheetObj.CellValue2(Row, prefix+"yd_cd") = originalVVDYard.substring(9,16);
					}
				}
//				var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
//				sheetObj.CellValue2(Row, prefix+"yd_nm") = glbYdNmArr[idx];
			}else if(colName == prefix+"ib_cgo_qty" || colName == prefix+"ob_cgo_qty"){
				var ibCgoQty = sheetObj.CellValue(Row, prefix+"ib_cgo_qty");
				var obCgoQty = sheetObj.CellValue(Row, prefix+"ob_cgo_qty");
				
				sheetObj.CellValue2(Row, prefix+"cgo_ttl") = Number(ibCgoQty) + Number(obCgoQty);
			}else if(colName == prefix+"vps_eta_dt"							// ETA, ETB, ETD 변경 시
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				
				//ETA, ETB, ETD 날짜 포맷 검사.
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}
			}
			
			if(colName == prefix+"vps_eta_dt"){
				if(sheetObj.CellValue(Row, prefix+"pre_etd_dt") >= sheetObj.CellValue(Row, prefix+"vps_eta_dt") && sheetObj.CellValue(Row, prefix+"pre_etd_dt") != ""){
					sheetObj.CellBackColor(Row, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 0, 0);
//					sheetObj.RowStatus(Row) = "";

				}else{
					sheetObj.CellBackColor(Row, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 255, 255);
				}			
			}
			
			if(colName == prefix+"vps_etb_dt"){
				if(sheetObj.CellValue(Row, prefix+"vps_eta_dt") <= sheetObj.CellValue(Row, prefix+"vps_etb_dt")){
					sheetObj.CellBackColor(Row, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 255, 255);
				}
				if(sheetObj.CellValue(Row, prefix+"vps_etb_dt") <= sheetObj.CellValue(Row, prefix+"vps_etd_dt")){
					sheetObj.CellBackColor(Row, prefix+"vps_eta_dt") = sheetObj.RgbColor(255, 255, 255);
				}
			}
			
			if(colName == prefix+"vps_etd_dt"){
				if(sheetObj.CellValue(Row, prefix+"vps_etd_dt") >= sheetObj.CellValue(Row, prefix+"nxt_eta_dt") && sheetObj.CellValue(Row, prefix+"nxt_eta_dt") != ""){
					sheetObj.CellBackColor(Row, prefix+"vps_etd_dt") = sheetObj.RgbColor(255, 0, 0);
				}else{
					sheetObj.CellBackColor(Row, prefix+"vps_etd_dt") = sheetObj.RgbColor(255, 255, 255);
				}
			}
			
		}
	}
	
	/**
	 * Sheet1의 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		userHideColumnControl(sheetObj);
	}
	
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function lane_grp_OnChange(comboObj, Code, Text) {
		if(Code == "L"){
			document.all.item("div_lane").style.display = "inline";
			document.all.item("div_grp").style.display = "none";
		}else if(Code == "G"){
			document.all.item("div_grp").style.display = "inline";
			document.all.item("div_lane").style.display = "none";
			
			setLaneGrpNmCombo();
		}
	}
	
	function yd_cd_OnChange(comboObj, Code, Text) {
		var sheetObj = sheetObjects[0];
		sheetObj.RemoveAll();
	}
	
	function yd_cd_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj = sheetObjects[0];
			var formObj = document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	
	function skd_dir_cd_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj = sheetObjects[0];
			var formObj = document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	
	function lane_grp_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj = sheetObjects[0];
			var formObj = document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	}
    
    function obj_focus(){
    	if(event.srcElement.options){
    		event.srcElement.focus();
    	}else{
    		event.srcElement.select();
    	}
    }
    
	function obj_change(){
		var formObj = document.form;
	    var sheetObj = sheetObjects[0];
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	            case "vps_port_cd":
	            	formObj.loc_cd.value = formObj.vps_port_cd.value;
	            	if(validateForm(sheetObj, formObj, SEARCH01)){
		            	var sXml = doActionIBSheet(sheetObj,formObj,SEARCH01);
		            	
		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.vps_port_cd.value = "";
							userHideColumnControl(sheetObj);
							formObj.vps_port_cd.focus();
						}else{
							userHideColumnControl(sheetObj);
							
							setYdCdCombo(sXml);
							formObj.yd_cd.focus();
						}
	            	}else{
	            		userHideColumnControl(sheetObj);
	            		formObj.vps_port_cd.focus();
	            	}
	            	
	            	sheetObj.RemoveAll();
	            	break;
	            case "fm_dt":
                	formObj.fm_dt.value = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
                	break;
                	
                case "to_dt":
                	formObj.to_dt.value = ComGetMaskedValue(formObj.to_dt.value, "ymd");
                	break;
	            	
	        } // end switch
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

		    case "vps_port_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;

		    case "slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "fm_dt":
		    	ComKeyOnlyNumber(formObj.fm_dt);
				break;
				
		    case "to_dt":
		    	ComKeyOnlyNumber(formObj.to_dt);
				break;

		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "vps_port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.yd_cd.focus();
		    	}
				break; 
		    case "slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.fm_dt.focus();
		    	}
				break;
		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
    
	
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	    
	/**
	 * [Port] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value = rtnDatas[2];
					formObj.loc_cd.value = rtnDatas[2];
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value = "";
						formObj.vps_port_cd.focus();
					}else{
						setYdCdCombo(sXml);
						sheetObj.RemoveAll();
						formObj.yd_cd.focus();
					}
				}
			}
		}
	}
    
	/**
	 * [Lane Code] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.slan_cd.value = rtnDatas[1];
				}
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Etc Function
	 * =====================================================================
	 */

	
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
	
	/**
	 * Direction Combo를 Setting.
	 * @return
	 */
	function setDirectionCombo(){
		var sheetObj = sheetObjects[0];
		var prefix = sheetObj.id + "_";
    	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH02);
    	
    	var sDirCd = "ALL|"+ComGetEtcData(sXml, "direction_cd");
    	var dirCdArr = sDirCd.split("|");
    	
    	appendMultiComboItem(getComboObject("skd_dir_cd"), dirCdArr, dirCdArr, "ALL");
	}
	
	/**
	 * Lane Code(LaneGrp) Combo를 Setting.
	 * @return
	 */
	function setLaneGrpCombo(){
		var txtArr = new Array();
		txtArr[0] = "Lane";
		txtArr[1] = "Group";
		
		var cdArr = new Array();
		cdArr[0] = "L";
		cdArr[1] = "G";
		
		appendMultiComboItem(getComboObject("lane_grp"), cdArr, txtArr, "L");
	}
	
	/**
	 * Lane Grp Nm Code(LaneGrpNm) Combo를 Setting.
	 * @return
	 */
	function setLaneGrpNmCombo(){
		var sheetObj = sheetObjects[0];
		var prefix = sheetObj.id + "_";
    	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH03);
    	
    	var usrLaneGrp = ComGetEtcData(sXml, "usr_lane_grp");
		if(usrLaneGrp != null && usrLaneGrp != undefined && usrLaneGrp != ""){
			var cdArr = usrLaneGrp.split("|");
		
			var firstCd = "";
			if(cdArr != null && cdArr != undefined && cdArr.length > 0){
				firstCd = cdArr[0];
			}
			
			appendMultiComboItem(getComboObject("lane_grp_nm"), cdArr, cdArr, firstCd);
		}else{
			ComShowCodeMessage("VSK00043");
			getComboObject("lane_grp_nm").RemoveAll();
		}
	}
	
	/**
	 * Yard Code Combo를 Setting.
	 * @param sXml
	 * @return
	 */
	function setYdCdCombo(sXml){
		var ydKind = ComGetEtcData(sXml, "yd_kind");
		var ydCode = ComGetEtcData(sXml, "yd_cd");
		var ydNm = ComGetEtcData(sXml, "yd_nm");
		var ydTxt = new Array();
		
		if(ydKind != null && ydKind != undefined && ydKind != ""){
			var ydKindArr = ydKind.split("|");
			var ydCodeArr = ydCode.split("|");
			var ydNmArr = ydNm.split("|");
			var ydCnt = ydKindArr.length;
			
			ydTxt[0] = ydKindArr[0] + "|" + ydNmArr[0];
			for(var i=1; i<ydCnt; i++){
				ydTxt[i] = ydKindArr[i] + "|" + ydNmArr[i];
			}
			
			appendMultiComboItem(getComboObject("yd_cd"), ydCodeArr, ydTxt, "");
		}
	}
	
	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
		
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionTxts[i], optionCds[i]);
		}
    	
		comboObj.Code2 = selCode;
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
	
	/**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var prefix = sheetObj.id + "_";
    	var chkPort = ComGetEtcData(sXml, "check_port");
		
		if(chkPort == "X"){
			return true;
		}else{
			//해당 Port({?msg1})가 존재하지 않습니다.
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			
			formObj.loc_cd.value = "";
		}
		
		return false;
    }
    
    /**
     * 메일 전송.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendGroupwareMail(sheetObj, formObj){
    	
    	if(sheetObj.SearchRows==0){
    		return false;
    	}
    	
    	var title = "Port Schedule[" + formObj.vps_port_cd.value + "]";
    	formObj.gw_subject.value = title;
    	var contents = getGWMailTextContents(sheetObj, formObj); 
    	formObj.gw_contents.value = contents;
    	ComOpenGroupwareMail(sheetObj, formObj);
    }
    
    /**
     * 메일 전송.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendMail(sheetObj, formObj){
    	
    	if(sheetObj.SearchRows==0){
    		return false;
    	}
    	
    	var title = "Port Schedule[" + formObj.vps_port_cd.value + "]";
    	var contents = getGWMailTextContents(sheetObj, formObj); 
    	
    	formObj.com_subject.value = title;
    	formObj.com_content.value = contents;

    	ComSendMailModal();
    }
    
    /**
     * Groupware(Mail)에 들어갈 내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailTextContents(sheetObj, formObj){
    	var contents = "<BODY>\n";
    	contents = contents + "<div style='font-size: 20px;font-family: Consolas' align='center'>\n";
    	contents = contents + "Port Schedule\n";
    	contents = contents + "</div><BR>\n";
    	contents = contents + "<div style='font-size: 14px;font-family: Consolas'>\n";
    	contents = contents + getGWMailTextDetailContents(sheetObj);
    	contents = contents + "</div><BR>\n";
    	contents = contents + "<div style='font-size: 16px;font-family: Arial'>\n";
    	contents = contents + "Remark\n";
    	contents = contents + "</div></BODY>";
    	
    	return contents;
    }
    
    /**
     * Groupware(Mail)에 들어갈 상세내용을 Text 형식으로 반환한다.
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailTextDetailContents(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var totCnt = sheetObj.LastRow;
    	var rowCnt = sheetObj.RowCount;
    	var contents = "";
    	var idx = 0;
    	
    	if(rowCnt > 0){
//			Seq		Lane	VVD		P/F		ETA		ETB		ETD		Pier	(CCT)	Cargo Vol(I/B O/B).		TMNL Voy	Next Port(ETA)
    		contents = contents + ComRpad("Seq", 4, "&nbsp;");
    		contents = contents + ComRpad("Lane", 5, "&nbsp;");
    		contents = contents + ComRpad("VVD", 12, "&nbsp;");
    		contents = contents + ComRpad("P/F", 8, "&nbsp;");
    		contents = contents + ComRpad("ETA", 20, "&nbsp;");
    		contents = contents + ComRpad("ETB", 20, "&nbsp;");
    		contents = contents + ComRpad("ETD", 20, "&nbsp;");
    		contents = contents + "Pier";
    		contents = contents + "<BR>\n";
    		contents = contents + ComRpad("-", 130, "-");
    		contents = contents + "<BR>\n";
    		
    		for(var i=headCnt; i<=totCnt; i++){
    			if(sheetObj.CellValue(i, prefix+"del_chk")){
    				idx++;
//	    			Seq		Lane	VVD		P/F		ETA		ETB		ETD		Pier	(CCT)	Cargo Vol(I/B O/B).		TMNL Voy	Next Port(ETA)
	    			contents = contents + ComRpad(idx, 4, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"slan_cd"), 5, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"vsl_cd"), 5, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"skd_voy_no"), 5, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"skd_dir_cd"), 2, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"pf_etb_dy"), 4, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellValue(i, prefix+"pf_etd_dy"), 4, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_eta_dt"), 20, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etb_dt"), 20, "&nbsp;");
	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"vps_etd_dt"), 20, "&nbsp;");
	    			contents = contents + sheetObj.CellText(i, prefix+"skd_brth_no");
	    			contents = contents + "<BR>\n";
    			}
    		}// end for
    		
    		contents = contents + ComRpad("-", 130, "-");
    		contents = contents + "<BR>\n";
    	}
    	
    	return contents;
    }
    
    /**
     * Mail에 들어갈 내용을 HTML 형식으로 반환한다.
     * @param sheetObj
     * @return
     */
    function setEmailContents(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var lastRow = sheetObj.LastRow;
    	var lastCol = sheetObj.LastCol;
    	
    	var contents = "";
    	
    	if(rowCnt > 0){
    		for(var i=0; i<=lastRow; i++){
    			if(i < headCnt){
    				//Header Setting.
//    				contents = contents + "	<TR bgcolor='#B5B5FF'>\n";
    				contents = contents + "	<TR>\n";
    			}else{
    				//Body Setting.
    				contents = contents + "	<TR>\n";
    			}
    			for(var j=0; j<=lastCol; j++){
    				if(sheetObj.ColHidden(j) == false){
    					if(i == 0 && sheetObj.id == "sheet1"){
    						//Header Setting.
    						if(sheetObj.CellValue(i, j) == sheetObj.CellValue(i+1, j)){
    							contents = contents + "		<TD rowspan=2>" + sheetObj.CellValue(i, j) + "</TD>\n";
    						}else{
    							contents = contents + "		<TD>" + sheetObj.CellValue(i, j) + "</TD>\n";
    						}
    					}else if(i == 1 && sheetObj.id == "sheet1"){
    						//Header Setting.
    						if(sheetObj.CellValue(i, j) != sheetObj.CellValue(i-1, j)){
    							contents = contents + "		<TD>" + sheetObj.CellValue(i, j) + "</TD>\n";
    						}
    					}else{
    						//Body Setting.
	    					var cellValue = "";
	    					if(sheetObj.CellValue(i, j) == ""){
	    						cellValue = "&nbsp;";
	    					}else{
	    						if(sheetObj.ColSaveName(j) == prefix+"vps_eta_dt"
	    								|| sheetObj.ColSaveName(j) == prefix+"vps_etb_dt"
	    								|| sheetObj.ColSaveName(j) == prefix+"vps_etd_dt"){
	    							if(sheetObj.CellValue(i, j) != "" && sheetObj.CellValue(i, j).length == 12){
	    								cellValue = ComGetMaskedValue(sheetObj.CellValue(i, j), "ymdhm");	
	    							}else{
	    								cellValue = sheetObj.CellValue(i, j);
	    							}
	    						}else{
	    							cellValue = sheetObj.CellValue(i, j);
	    						}
	    					}
	    					contents = contents + "		<TD>" + cellValue + "</TD>\n";
    					}
    				}
    			}
				contents = contents + "	</TR>\n";
    		}
    	}
    	
    	return contents;
    }
    
    /**
     * KRPUS 가 입력 될 경우에만 Plism Column 보이도록.
     * 
     * @param sheetObj
     * @return
     */
    function userHideColumnControl(sheetObj){
    	var prefix = sheetObj.id + "_";
		var formObj = document.form;
		
		/*
		 * Plism Column 보이는 조건변경 (KRPUS => KR로 시작하는 Port)
		 */
		if(formObj.vps_port_cd.value.substring(0, 2) == "KR"){
			sheetObj.ColHidden(prefix+"uq_vsl_id_no") = true;
			sheetObj.ColHidden(prefix+"plism_yd_cd") = false;
			sheetObj.ColHidden(prefix+"plism_vsl_cd") = false;
			sheetObj.ColHidden(prefix+"plism_voy_no") = false;
		}else if(formObj.vps_port_cd.value.indexOf("GB") == 0){
			sheetObj.ColHidden(prefix+"uq_vsl_id_no") = false;
			sheetObj.ColHidden(prefix+"plism_yd_cd") = true;
			sheetObj.ColHidden(prefix+"plism_vsl_cd") = true;
			sheetObj.ColHidden(prefix+"plism_voy_no") = true;
		}else{
			sheetObj.ColHidden(prefix+"uq_vsl_id_no") = true;
			sheetObj.ColHidden(prefix+"plism_yd_cd") = true;
			sheetObj.ColHidden(prefix+"plism_vsl_cd") = true;
			sheetObj.ColHidden(prefix+"plism_voy_no") = true;
		}
    }
    
    /**
     * Actual Data Update 안되도록 status 재설정.
     * 
     * @param sheetObj
     * @return
     */
    function saveStatusControl(sheetObj){
    	var prefix = sheetObj.id + "_";
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totRow = sheetObj.LastRow;

    	if(rowCnt > 0){
    		for(var i=headCnt; i<=totRow; i++){
    			if(sheetObj.CellValue(i, prefix+"bfr_act_flg") == "X"
    				|| sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "D"){
    				if(sheetObj.RowStatus(i) != "R"){
    					sheetObj.RowStatus(i) = "R";
    				}
    			}
    		}
    	}
    }
