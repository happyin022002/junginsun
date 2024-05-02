/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0062.js
*@FileTitle : Inquiry By Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.09.08 송호진
* 1.0 Creation
*=========================================================
* History
* 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
* 2008.02.26 PEJ N200802220016 COA 조회 기간 관련 수정 요청
*    변경사항 : 2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
* 2008.03.21 PEJ R200803125390 P/L 화면 보완 요청_1,2번항목
*                Week선택시에Month, Week를 입력할수 있도록 변경[060,062,070]
* 2008.05.30 PEJ N200805260011 COA Report REV 산출 수정 요청
* 2008.05.30 박상희 N200811060006 Week Display Option 추가
* 2009.02.04 김태윤 N200901190016 - COA_조직개편 관련 기능 수정 changeCostYrmon추가, chgOffice수정
* 2009.02.13 박상희 N200902050040 - 팝업(079 ->061),스크롤바
* 2009.04.02 임옥영 N200903120100 - COA_Multi-dimension report 조회권한 변경, 디자인 수정
* 2009.05.08 박상희 N200904170011 Report Item 추가(2) : CM COST, OP COST 추가
* 2009.05.11 박상희 N200904170011 - OPB total 관련 searchend 수정
* 2009.05.14 박상희 N200904170011 - bound disp. & wk disp. 체크시 Route Detail 팝업에도 반영
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.09.15 송호진 ALPS F/W 적용
* 2009.10.14 송호진 initPeriod3_ofc -> coaPeriod3 수정
* 2009.10.27 송호진 ESM_COA_0061 호출 Argument 수정
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.02.01 윤진영 CHM-200901765 TAA_NO 추가
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> coaFormQueryString 변경
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.13 김민아 [CHM-201110694-01] COA Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2011.06.01 최윤성 [CHM-201111117-01] Split 04-Split 03-ALPS Error 처리 요청 - 폼입력값에 대한 체크 로직 추가(Year, Mon, Week)
* 2012.01.02 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2015.04.27 손진환 [CHM-201535625] Inquiry by Lane - 검색 조건 유효성 검사 추가
*=========================================================*/
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
     * @class ESM_COA_0062 : ESM_COA_0062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0062() {
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
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    //var selectVal;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        /**
         * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
         */
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
            var srcName = window.event.srcElement.getAttribute("name");

            try {
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;

                    case "btn_downexcel":
                        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                        break;

                    case "btng_routedetail":
                        openRouteDetail();
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage(title, col_nm) {
            var formObject = document.form;

            loadingMode = true;
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

            // 멀티콤보 처리
            //---------------------------------------------
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode = false;

            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i+1, title, col_nm);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            //---------------------------------------------
            formObject.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
            formObject.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
            formObject.f_year.focus();
        }

        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj, sheetNo, title, col_nm) {
            var cnt = 0;
            var colCnt = 0;
            var formObj = document.form;

            switch(sheetNo) {
                case 1:      //sheet1 init
                    with (sheetObj) {
                        var colWidth1 = 110;


                        if(formObj.f_bkg_disp.checked) colCnt = colCnt + 1;
                        if(formObj.f_wk_sts.checked) colCnt = colCnt + 3;

                        SheetWidth = mainTable.clientWidth;                     //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;                              //전체Merge 종류 [선택, Default msNone]
                        Editable = false;                                       //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 1, 1, 9, 50);                              //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(20+colCnt, 0, 0, true);                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, false, false, true, false,false);   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        var HeadTitle  = "" ;

                        if(formObj.f_wk_sts.checked) {
                            HeadTitle  = "R.MONTH|S.MONTH|WEEK|";
                        }
                        HeadTitle   = HeadTitle   + "TRADE|R.LANE|";
                        HeadTitle   = HeadTitle   + "BOUND|";
                        HeadTitle   = HeadTitle   + "TRADE DIR|";
                        if(formObj.f_bkg_disp.checked) {
                            HeadTitle  = HeadTitle  + "BKG No|" ;
                        }

                        if(formObj.f_view_tpsz[0].checked) {
                            HeadTitle  = HeadTitle + "TP/SZ|LOAD|REV|CM COST|CM|CM2 COST|CM2|OP COST|BKG OP|RPB(BOX)||CM CPB(BOX)|CMB(BOX)||OP CPB(BOX)|OPB(BOX)" ;
                        }else{
                            HeadTitle  = HeadTitle + "TP/SZ|LOAD|REV|CM COST|CM|CM2 COST|CM2|OP COST|BKG OP|RPB(TEU)||CM CPB(TEU)|CMB(TEU)||OP CPB(TEU)|OPB(TEU)" ;
                        }
                        InitHeadRow(0, HeadTitle, true);                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        if(formObj.f_wk_sts.checked){
                        InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true, "cost_yrmon",  false, "", dfNone,      0,  false,  false);
                        InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true, "sls_yrmon",   false, "", dfNone,      0,  false,  false);
                        InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true, "cost_wk",     false, "", dfNone,      0,  false,  false);
                        }
                        InitDataProperty(0, cnt++ , dtData,     70,         daCenter, true, "trd_cd",      false, "", dfNone,      0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true, "rlane_cd",    false, "", dfNone,      0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true, "dir_cd",    false, "", dfNone,      0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true, "trd_dir_cd",    false, "", dfNone,      0,  true,   true);
                        if(formObj.f_bkg_disp.checked){
                        InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true, "bkg_no",      false, "", dfNone,      0,  true,   true);
                        }
                        InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "spcl_cntr_tpsz_cd",  false, "", dfNone,      0,  true,   true);
                        InitDataProperty(0, cnt++ , dtAutoSum,  80,         daRight,  true,  "load",       false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  80,         daRight,  true,  "rev",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmc",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm",         false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "own_fdr_amt",false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm2",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opc",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op",         false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "g_rpb",      false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm_cost",    false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmcost",     false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmb",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op_cost",    false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opcost",     false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opb",        false, "", dfFloatOrg,  2,  false,  false);

                        CountPosition  = 0 ;
                        style.height = GetSheetHeight(17) ;
                        // Profit Level에 따라서 컬럼을 보여준다
                        //------------------------------------
                        ColHidden("cm_cost") 		= true;
                        ColHidden("op_cost") 		= true;
                        
                        if(document.getElementById("f_pro_lvl").Code != "M") {
                 			ColHidden("own_fdr_amt")	= true;
                 			ColHidden("cm2") 			= true;                  			
                        }
                        changeViewColumn();
                        viewBound();
                        viewTrdDir();
                    }
                    break;
            }
        }


        /**
         * sheet를 초기화 시킨다.
         */
        function initHeader(sheetObj, formObj){
          // Header 정보를 변경하기 위해 sheet를 초기화 한다.
          //--------------------------------------------------
          // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.        	
          sheetObj.Redraw = false;
          sheetObj.RemoveAll();
          sheetObj.Reset();
          initSheet(sheetObj, 1, formObj.header.value, formObj.headerNM.value);
          sheetObj.Redraw = true;
          //--------------------------------------------------
        }

        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initCombo(comboObj, comboId) {
            with (comboObj) {
                if (comboId ==  "f_sls_ofc_cd") {
                    MaxLength = 6;
                    ValidChar(2, 1);
                } else if (comboId ==  "f_trd_cd") {
                    MaxLength = 3;
                    ValidChar(2, 0);
                } else if (comboId ==  "f_rlane_cd") {
                    MaxLength = 5;
                    ValidChar(2, 1);
                    Text2 = "All";
                } else if (comboId ==  "f_skd_dir_cd") {
                    MaxLength = 1;
                    ValidChar(2, 0);
                } else if (comboId == "f_key_acct_group_cd") {
                    SetColAlign("left");
                    SetColWidth("300")
                    Text2 = "All";
                } else if (comboId ==  "f_key_acct_indvl_cd") {
                    MaxLength = 8;
                    ValidChar(2, 1);
                    SetColAlign("left|left");
                    SetColWidth("100|300")
                    Text2 = "All";
                } else if (comboId ==  "f_cmdt_cd") {
                    MaxLength = 4;
                    ValidChar(2, 1);
                    SetColAlign("left|left");
                    SetColWidth("40|350")
                    Text2 = "All";
                } else if (comboId ==  "f_usa_bkg_mod_cd") {    // US Mode
                    ValidChar(2, 1);
                } else if (comboId ==  "f_cntr_tpsz_cd") {    // Type/Size
                	MaxLength = 4;
                    ValidChar(2, 1);
                }
                IMEMode = 0;
                DropHeight = 200;
                Index = 0;
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }

        /**
    	* Route detail정보를 팝업창에서 띄워준다.
    	*/
	    function openRouteDetail() {
			if (!validateForm(sheetObjects[0], document.form, IBSEARCH))
				return false;

			if (sheetObjects[0].RowCount > 0) {//sheet1에 데이터가 있을때
				var cond = '';
				var obj1 = sheetObjects[0];
				var row = obj1.SelectRow;
				var formObj = document.form;
				var dir_cd = "";
				var dir_sts = (formObj.f_dir_sts.checked ? "Y" : "N");
				if (dir_sts == "Y") {
					dir_cd = obj1.CellValue(row, "dir_cd");
				} else {
					dir_cd = ComGetObjValue(formObj.f_skd_dir_cd);
					dir_cd = dir_cd=="All"?"":dir_cd;
				}
				
				formObj.f_cmd.value = "";

				cond = cond + "&s_trd_cd=" + obj1.CellValue(row, "trd_cd") + "&s_dir_sts=" + (formObj.f_dir_sts.checked ? "Y" : "N") + "&s_dir_cd=" + dir_cd 
				            + "&s_rlane_cd=" + obj1.CellValue(row, "rlane_cd") + "&s_cntr_tpsz_cd=" + obj1.CellValue(row, "spcl_cntr_tpsz_cd") 
				            + "&s_wk_sts=" + (formObj.f_wk_sts.checked ? "Y" : "N") + "&s_wk_cd=" + obj1.CellValue(row, "cost_wk")
				            + "&f_bkg_sts=" + (formObj.f_bkg_sts.checked ? "Y" : "N");

				// 20100414 이중환, FormQueryString -> coaFormQueryString 변경
				ComOpenWindow('ESM_COA_0147.do?' + coaFormQueryString(document.form) + cond, 'AA', 'width=1010,height=450,menubar=0,status=1,scrollbars=0,resizable=1');
			} else {
				ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
			}
		}

        /**
         * Seq를 선택하면 Date Period를 clear한다.
         */
        function clearDatePeriod(){
            document.form.txtWeek.value = "";
            // document.getElementById("txtWeek").className = "noact";
            document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
        }

        /**
         * month, week가 변경되었을때 Period를 변경한다.
         */
        function setPeriod(obj){
        	 ComCoaSetPeriod(obj);
        }

        /**
         * 검색시 필수입력사항 체크
         */
        function chkValidSearch(){
            var formObj = document.form;

                with(formObj){
                    if (f_year.value == "") {
                        ComShowMessage(ComGetMsg("COM12114", "Year", ""));
                        f_year.focus();
                        return false;
                    }
//        FROM MONTH를 변경했을 경우를 위해 2007.08.17 BY LHI
                    if (f_fm_mon.value != "" && f_to_mon.value == ""){
//                        ComShowMessage(ComGetMsg("COM12114", "month", ""))
//                        f_to_mon.focus();
                        return false;
                    }
                    if (f_fm_mon.value == "" && f_to_mon.value != "") {
                        ComShowMessage(ComGetMsg("COM12114", "month", ""));
                        f_fm_mon.focus();
                        return false;
                    }
//        FROM MONTH를 변경했을 경우를 위해 2007.08.17 BY LHI
                    if (f_fm_mon.value != "" && f_to_mon.value != ""){
            			if (f_fm_mon.value > f_to_mon.value) {
            			    // [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
            			    ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
            			    f_to_mon.focus();
            			    return false;
            			}
                    }
//        FROM MONTH를 변경했을 경우를 위해 2007.08.17 BY LHI
                    if (f_fm_wk.value != "" && f_to_wk.value == ""){
//                        ComShowMessage(ComGetMsg("COM12114", "week", ""));
//                        f_to_wk.focus();
                        return false;
                    }
                    if (f_fm_wk.checked.value == "" && f_to_wk.value != ""){
                        ComShowMessage(ComGetMsg("COM12114", "week", ""));
                        f_fm_wk.focus();
                        return false;
                    }
                    // [CHM-201535625] Inquiry by Lane - 검색 조건 유효성 검사 추가
                    if( f_bkg_disp.checked == true ){
                    	if( f_chkprd[0].checked == true ) {
                    		//ComShowMessage( f_fm_wk.value + " / " + f_to_wk.value + " / " + ComGetObjValue(formObj.f_trd_cd) );
                    		if(ComParseInt(ComGetObjValue(f_to_wk))-ComParseInt(ComGetObjValue(f_fm_wk)) >= 4){
                                // [COA10003] : Week 는(은) 4wk 만 처리할수 있습니다.
                                ComShowMessage(ComGetMsg("COA10003", "Week", "4wk"));
                                ComSetFocus(f_to_wk);
                                return false;
                            }
  
                    	}
                    	
                    	if( f_chkprd[1].checked == true ) {
                    		//ComShowMessage( f_fm_mon.value + " / " + f_to_mon.value + " / " + ComGetObjValue(formObj.f_trd_cd) );
                     		if(ComParseInt(ComGetObjValue(f_to_mon))-ComParseInt(ComGetObjValue(f_fm_mon)) >= 1){
                                // [COA10003] : Month 는(은) 1Month 만 처리할수 있습니다.
                                ComShowMessage(ComGetMsg("COA10003", "Month", "1Month"));
                                ComSetFocus(f_to_mon);
                                return false;
                            }
                    	}
                    	
                      	if(getIbComboObjValue(formObj.f_trd_cd) == "" ){
                      		// [COM12114] : Trade 를(을) 확인하세요.
	                		ComShowMessage(ComGetMsg('COM12114','Trade'));
	                		ComSetFocus(f_trd_cd);
	                		return false;
                		}
                      	
                		if(getIbComboObjValue(formObj.f_rlane_cd) == ""){
                			// [COM12114] : Lane 를(을) 확인하세요.
	                		ComShowMessage(ComGetMsg('COM12114','Lane'));
	                		ComSetFocus(f_rlane_cd);
	                		return false;
                		}
                    }
                    
//        FROM WEEK를 변경했을 경우를 위해 2007.08.17 BY LHI
                    if (f_fm_wk.value != "" && f_to_wk.value != ""){
            			if (f_fm_wk.value > f_to_wk.value) {
            			    // [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
            			    ComShowMessage(ComGetMsg("COA10011","Week","From","To"));
            			    f_to_wk.focus();
            			    return false;
            			}
                    }
                    if(f_fm_mon.value == "" && f_fm_wk.value == ""){
        //              ComShowMessage(ComGetMsg("COM12138", "month", "week"));
                        return false;
                    }
                    
                    if(!isValidYear(f_year,false,true)) return false;
            		if(!isValidMonth(f_fm_mon,false,true)) return false;
            		if(!isValidMonth(f_to_mon,false,true)) return false;
            		if(!isValidWeek(f_fm_wk,false,true)) return false;
            		if(!isValidWeek(f_to_wk,false,true)) return false;
                }
            return true;
        }

        /**
         * Group combo 변경시 sheet의 Header정보를 변경시킨다.
         */
        function chgHeader(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            doActionIBSheet(sheetObj,formObj,IBRESET);
        }

         /**
     	 * Profit Level 변경시 컬럼을변경
     	 */
     	function f_pro_lvl_OnChange(obj, code) {
            var sheetObj = sheetObjects[0];
            
     		if (loadingMode == true)
     			return;
     		changeViewColumn();
     		
     		if(code == "M") {
     			sheetObj.ColHidden("own_fdr_amt")	= false;
     			sheetObj.ColHidden("cm2") 			= false;
     		} else {
     			sheetObj.ColHidden("own_fdr_amt")	= true;
     			sheetObj.ColHidden("cm2") 			= true;     			
     		}
     	}
     	/**
     	 * Profit View 변경시  컬럼을변경
     	 */
     	function f_pro_vw_OnChange(obj, code) {
     		if (loadingMode == true)
     			return;
     		changeViewColumn();
     	}
     	/**
     	 * Office View 변경시  컬럼을변경
     	 */
     	function f_ofc_vw_OnChange(obj, code) {
     		if (loadingMode == true)
     			return;
     		changeViewColumn();
     	}

        /**
         * Profit Level에 따라서 컬럼을 보여준다
         */
        function changeViewColumn(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;
            if (ComGetObjValue(formObj.f_pro_lvl) != "") {
            	if (ComGetObjValue(formObj.f_pro_lvl) == "O" && ComGetObjValue(formObj.f_pro_vw) == "R") {
                    sheetObj.ColHidden("opc")        = false;
                    sheetObj.ColHidden("op")         = false;
                    sheetObj.ColHidden("opcost")     = false;
                    sheetObj.ColHidden("opb")        = false;
                } else {
                    sheetObj.ColHidden("opc")        = true;
                    sheetObj.ColHidden("op")         = true;
                    sheetObj.ColHidden("opcost")     = true;
                    sheetObj.ColHidden("opb")        = true;
                }
        		if (ComGetObjValue(formObj.f_pro_vw) == "R") {
                    sheetObj.CellValue(0, "cm")      = "BKG CM";
                } else {
                    sheetObj.CellValue(0, "cm")      = "CM";
                }
            }
        }

        /**
         * Bound 컬럼의 view 유무에 따라서 sheet를 보여준다.
         */
        function viewBound(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            if(formObj.f_dir_sts.checked){
                sheetObj.ColHidden("dir_cd")     = false;
            } else {
                sheetObj.ColHidden("dir_cd")     = true;
            }
            sheetObj.RemoveAll();
        }
        
        /**
         * Trade Dir 컬럼의 view 유무에 따라서 sheet를 보여준다.
         */
        function viewTrdDir(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            if(formObj.f_trd_sts.checked){
                sheetObj.ColHidden("trd_dir_cd")     = false;
            } else {
                sheetObj.ColHidden("trd_dir_cd")     = true;
            }
            sheetObj.RemoveAll();
        }

        /**
         * BKG Display 선택여부에 때라서 sheet를 초기화한다.
         */
        function viewBkgNo(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;
            // Header 정보를 변경하기 위해 sheet를 초기화 한다.
            initHeader(sheetObj, formObj);
        }

        /**
         * Box/TEU 에 때라서 header정보를 변경하고 재조회한다.
         */
        function changeType() {
			var sheetObj = sheetObjects[0];
			var formObj = document.form;

			initHeader(sheetObj, formObj);
			// if(formObj.f_year.value !="" && (formObj.f_to_mon.value != "" || formObj.f_to_wk.value != "")){
			// doActionIBSheet(sheetObj,formObj,IBSEARCH);
			// }
		}

	     // 콤보 처리
	     // --------------------------------------------------------------------
	     /**
	      * key acctount group 변경시 key acctount indvl combo변경
	      */
	     function f_key_acct_group_cd_OnChange(obj, code){
	     	if (loadingMode == true) return;

	         var formObj = document.form;
	         var sheetObj = sheetObjects[0];
	         if(obj.Text != ""){
	         	formObj.f_cmd.value = SEARCHLIST10;
	 			var sXml = sheetObj.GetSearchXml("ESM_COA_0062GS.do", coaFormQueryString(formObj));
	 			var arrXml = sXml.split("|$$|");
	 			if (arrXml.length > 0)
	 			ComXml2ComboItem(arrXml[0], formObj.f_key_acct_indvl_cd, "code", "code|name");
	 			formObj.f_key_acct_indvl_cd.Index = 0;
	         }
	     }
	     /**
	      * Office Level 변경시 Office combo변경
	      */
	     function f_rhq_cd_OnChange(obj, code){
	     	 if (loadingMode == true) return;
	     	 chgOffice(obj);
	     }

        /**
         * 본부 콤보변경시...
         */
        function chgOffice(obj){
        	 var formObj = document.form;
             var sheetObj = sheetObjects[0];

             if(obj.Text != ""){
             	formObj.f_cmd.value = SEARCHLIST13;
     			var sXml = sheetObj.GetSearchXml("ESM_COA_0062GS.do", coaFormQueryString(formObj));
     			var arrXml = sXml.split("|$$|");
     			if (arrXml.length > 0)
     			ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
     			formObj.f_sls_ofc_cd.Index=0;
             }
        }

         /*
         * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
         */
        function changeCostYrmon(val){
            if(val != '') chgOffice(document.form.f_rhq_cd);
        }
        //changeCostYrmon

        /**
         * trade변경시 R.Lane combo변경
         */
        function f_trd_cd_OnChange(obj) {
        	if (loadingMode == true) return;
        	var formObj = document.form;
            var sheetObj = sheetObjects[0];
            if(obj.Text != ""){
            	formObj.f_cmd.value = SEARCHLIST11;
    			var sXml = sheetObj.GetSearchXml("ESM_COA_0062GS.do", coaFormQueryString(formObj));
    			var arrXml = sXml.split("|$$|");
    			if (arrXml.length > 0)
    			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
    			formObj.f_rlane_cd.Index = 0;
            }
        }

        /**
         * S/C, RFA 팝업창 띄우기
         */
        function comPopupLoc(flag, value) {
            var display = "1,0,1,1,1,1,1,1";
            var cont_tp = "";
            var cont_no = "";
            var param = "";
            var targetFun = "";

            if(value != ""){
                cont_tp = value.substring(0,3);
                cont_no = value.substring(3);
            }
            param = "?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
            if(flag == 1){
                targetFun = "getCOM_ENS_021_1";
            }
//            else{
//                targetFun = "getCOM_ENS_021_2";
//            }
            ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);    // radio PopUp
        }

        /**
         * S/C 검색결과를 반환한다.
         */
        function getCOM_ENS_021_1(rowArray) {
            var colArray = rowArray[0];
            document.all.f_sc_no.value = colArray[2];
        }

//        /**
//         * RFA 검색결과를 반환한다.
//         */
//        function getCOM_ENS_021_2(rowArray) {
//            var colArray = rowArray[0];
//            document.all.f_rfa_no.value = colArray[2];
//        }

        /**
         * Shipper PopUp 화면을 열어 준다
         *
         */
        function ShipperPopUp(){
            var formObj = document.form;
            var param = "";
            var tmp = formObj.txtShipper.value;

            formObj.f_cmd.value = "";
            if(tmp.length == 0){
    			param = "?f_cust_cnt_cd=&f_cust_seq="
            }
            if(tmp.length >0 && tmp.length< 3){
                param = "?f_cust_cnt_cd=" + tmp +"&f_cust_seq=";
            } else if(tmp.length>2) {
                param = "?f_cust_cnt_cd=" + tmp.substring(0,2);
                param = param + "&f_cust_seq=" + tmp.substring(2);
            }

            ComOpenWindow2('ESM_COA_0144.do'+param, '', 'width=600,height=450,menubar=0,status=0,scrollbars=0,resizable=0');

        }

        function viewWeek(){
            var sheetObj = sheetObjects[0];
            var formObj = document.form;

            // Header 정보를 변경하기 위해 sheet를 초기화 한다.
            initHeader(sheetObj, formObj);

        }

        function sheet1_OnSearchEnd(sheetObj, errMsg){
            if(eval(sheetObj.SumValue(0, "load")) > 0){

                sheetObj.SumValue(0, "g_rpb")  = eval(sheetObj.SumValue(0, "rev")     + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost") + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost") + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")      + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opb")    = eval(sheetObj.SumValue(0, "op")      + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
//                sheetObj.SumValue(0, "opb")    = eval("(" + sheetObj.SumValue(0, "cm")+ "-" + sheetObj.SumValue(0, "op_cost")+ ")/" + sheetObj.SumValue(0, "load")).toFixed(2);
            } else {
                sheetObj.SumValue(0, "g_rpb") = "0";
                sheetObj.SumValue(0, "cmcost") = "0";
                sheetObj.SumValue(0, "opcost") = "0";
                sheetObj.SumValue(0, "cmb") = "0";
                sheetObj.SumValue(0, "opb") = "0";

            }

        }

        /**
         * BKG NO가 있을경우 Inquiry by BKG화면을 열어준다.
         */
        function sheet1_OnDblClick(sheetObj, row, col, value){
            var formObj = document.form;
            var param = "";

            if(formObj.f_bkg_disp.checked){
                var param =  "?f_pro_vw="+ComGetObjValue(formObj.f_pro_vw)
                        +"&f_pro_lvl="+ComGetObjValue(formObj.f_pro_lvl)
                        +"&f_s_bkg_no="+sheetObj.CellValue(row, "bkg_no")
                        +"&pgmNo=ESM_COA_0061";

                ComOpenWindow('ESM_COA_0061POP.do'+param, 'Inquiry By BKG', "width=1050,height=850,menubar=0,status=1,scrollbars=1,resizable=1");
            }
        }

        /**
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            	case IBCLEAR:          //조회
		        	formObj.f_year.value = ComGetNowInfo("yy");
			        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
			        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");

			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);

					var sXml = document.form.sXml.value;
					document.form.sXml.value = "";
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					var arrXml = sXml.split("|$$|");
					if (ComGetEtcData(arrXml[0], "ofc_cd") == undefined){
						ComShowMessage(OBJECT_ERROR);
						ComOpenWait(false);
						return;
					}
					formObj.f_ofc_cd.value = ComGetEtcData(arrXml[0], "ofc_cd");
			        formObj.f_ofc_lvl.value = ComGetEtcData(arrXml[0], "ofc_lvl");
					formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
			        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
			        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
			        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";

					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
					if (arrXml.length > 1)
						ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
					if (arrXml.length > 2)
						ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");
					if (arrXml.length > 3)
						ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
					if (arrXml.length > 4)
						ComXml2ComboItem(arrXml[4], formObj.f_sls_ofc_cd, "code", "code");
					if (arrXml.length > 5)
						ComXml2ComboItem(arrXml[5], formObj.f_trd_cd, "code", "code");
					if (arrXml.length > 6)
						ComXml2ComboItem(arrXml[6], formObj.f_rlane_cd, "code", "code");

					if (arrXml.length > 7)
						ComXml2ComboItem(arrXml[7], formObj.f_skd_dir_cd, "code", "code");
					if (arrXml.length > 8)
						ComXml2ComboItem(arrXml[8], formObj.f_key_acct_group_cd, "code", "name");
					if (arrXml.length > 9)
						ComXml2ComboItem(arrXml[9], formObj.f_key_acct_indvl_cd, "code", "code|name");
					if (arrXml.length > 10)
						ComXml2ComboItem(arrXml[10], formObj.f_cmdt_cd, "code", "code|name");
					if (arrXml.length > 11)
						ComXml2ComboItem(arrXml[11], formObj.f_usa_bkg_mod_cd, "code", "code");
					if (arrXml.length > 12)
						ComXml2ComboItem(arrXml[12], formObj.f_cntr_tpsz_cd, "code", "code");
					if (arrXml.length > 13)
						ComXml2ComboItem(arrXml[13], formObj.f_trd_dir_cd, "code", "code");

					ComOpenWait(false);
					break;
                case IBSEARCH:      //조회
                    if(!validateForm(sheetObj, formObj, sAction)) return false;
                    // 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;
                    formObj.f_shpr.value = formObj.txtShipper.value;

                    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                    sheetObj.DoSearch4Post("ESM_COA_0062GS.do", coaFormQueryString(formObj));
                    ComOpenWait(false);
                    break;

                case IBRESET:      //
                	// 업무처리중 버튼사용 금지 처리
					//sheetObj.WaitImageVisible = false;
					//ComOpenWait(true);
                    formObj.f_cmd.value = SEARCH01;
                    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                    sheetObj.DoSearch4Post("ESM_COA_0062GS.do", coaFormQueryString(formObj));
                    formObj.header.value   = sheetObj.EtcData("header");
                    formObj.headerNM.value = sheetObj.EtcData("headerNM");
                    sheetObj.RemoveEtcData();
                    //ComOpenWait(false);
                    // Header 정보를 변경하기 위해 sheet를 초기화 한다.
                    //--------------------------------------------------
                    initHeader(sheetObj, formObj);
                    break;

                case IBDOWNEXCEL:        //엑셀 다운로드
                    //sheetObj.Down2Excel(-1, false, false, true);
                    //sheetObj.SpeedDown2Excel(-1, true, true);
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

            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            with(formObj){
                if (f_year.value == "") {
                    ComAlertFocus(f_year, ComGetMsg("COA10002", "Year", ""));
                    return false;
                }
    			if(f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == ""){
    			    // [COM12114] : Month 를(을) 확인하세요.
    			    ComShowMessage(ComGetMsg("COM12114", "Month"));
    			    f_fm_mon.focus();
    			    return false;
    			}
    			if(f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == ""){
    			    // [COM12114] : Week 를(을) 확인하세요.
    			    ComShowMessage(ComGetMsg("COM12114", "Week"));
    			    f_fm_wk.focus();
    			    return false;
    			}
    			if(!isValidYear(f_year,false,true)) return false;
    			if(!chkValidSearch()) return false;
    			if((f_chkprd[1].checked && f_year.value == "2007" && ComParseInt(f_fm_mon.value) < 7) ||
    			   (f_chkprd[0].checked && f_year.value == "2007" && ComParseInt(f_fm_wk.value) < 27)){
    			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    			    ComShowMessage(ComGetMsg("COA10037"));
    			    return false;
    			}
            }
           return true;
        }
        
        function getIbComboObjValue(obj){
            if (obj.Code == "All" ){
                return "";
            }
            return obj.Code;
        }

    //--------------------------------------------------------------------

	/* 개발자 작업  끝 */