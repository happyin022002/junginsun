﻿﻿﻿﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2208.js
*@FileTitle : RFA Proposal Creation - Rate [Load Excel] (H Type)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 박근환
*@LastVersion : 1.0
* 2016.04.14 박근환
* 1.0 Creation
=========================================================
* History
* [CHM-201640671] RFA 효율화를 위한 요청 (1차)
* [CHM-201641745] [RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
* [CHM-201641821] [Master RFA] 1차 개발 에러 처리용 + 보완 처리
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2208() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업 */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var bIsReqUsr = false;
    var bIsAproUsr = false;
    var timerID = "";
    var jobKey = "";
    
    var v_origin = "O";
    var v_destination = "D";
	var isClear = true;
    
	// T/F 전환을 위한 기준 추가 필드
    var ratePortArray = new Array();    

    var sChgCdVisiable = "";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

        var sheetObject1 = sheetObjects[0];

        /** **************************************************** */
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch (srcName) {
            
			case "btn_template":
				downform.submit();
				break;

            case "btn_openfile":
                var strFilePath = sheetObject1.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
                if (strFilePath != "<USER_CANCEL>") {
                    sheetObject1.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32");
                }
                if (sheetObject1.RowCount > 0) {
                    toggleButtons("LOAD");
                    // Load Excel 시 Cell 비활성 초기화
                    for (var i = sheetObject1.HeaderRows; sheetObject1.RowCount > 0 && i <= sheetObject1.LastRow; i++) {                       
                        cellEditable(i, "org_rout_pnt_loc_def_cd", true, false);
                        cellEditable(i, "org_rcv_de_term_nm", true, false);
                        cellEditable(i, "org_rout_via_port_def_cd", true, false);
                        cellEditable(i, "dest_rout_via_port_def_cd", true, false);
                        cellEditable(i, "dest_rout_pnt_loc_def_cd", true, false);
                        cellEditable(i, "dest_rcv_de_term_nm", true, false);                        
                        cellEditable(i, "app_bkg_dir_call_flg", true, false);
                        cellEditable(i, "app_bkg_ts_port_def_cd", true, false);
                        cellEditable(i, "app_bkg_slan_cd", true, false);
                        cellEditable(i, "app_bkg_vvd_cd", true, false);
                        cellEditable(i, "chg_rule_def_cd", false, true);
                        cellEditable(i, "bkg_rat_ut_cd_bl", false, true);
                        cellEditable(i, "bkg_rat_ut_cd_cm", false, true);
                        cellEditable(i, "bkg_rat_ut_cd_bx", false, true);
                        cellEditable(i, "conv_bkg_dir_call_flg", false, true);
                        cellEditable(i, "conv_bkg_ts_port_def_cd", false, true);
                        cellEditable(i, "conv_bkg_slan_cd", false, true);
                        cellEditable(i, "conv_bkg_vvd_cd", false, true);
                        cellEditable(i, "pay_term_cd", false, true);
                        cellEditable(i, "bkg_yd_cd", false, true);
                        cellEditable(i, "bkg_min_cgo_wgt", false, true);
                        cellEditable(i, "bkg_max_cgo_wgt", false, true);
                    }
                } else {
                    toggleButtons("INIT");
                }
                if (strFilePath != "<USER_CANCEL>") {
                	ComShowCodeMessage("PRI01045","Loading file");
                }                
                break;

			case "btn_downexcel":				
				if (formObject.prop_no.value == "" || formObject.amdt_seq.value == "" || formObject.svc_scp_cd.value == "") {
					return;
				}
				
	            if (sheetObject1.RowCount <= 0) {
	                return false;
	            }
	
				doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
				break;
				
            case "btn_check":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
                break;

            case "btn_save":
                doActionIBSheet(sheetObject1, document.form, IBSAVE);
                break;

            case "btn_close":
                window.close();
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetObject(sheet_obj) {
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function loadPage() {
        for (i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects[i]);            
            sheetObjects[i].UnEditableColor = sheetObjects[i].RgbColor(128,128,128);
        }

        bIsReqUsr = document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
        bIsAproUsr = document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;

        toggleButtons("INIT");

        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC19);        
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch (sheetNo) {
	        case 1: // sheet1 init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 440;
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
	
	                var HeadTitle1 = "|Commodity Group|Commodity Group|Route\nID.|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination" + 
	                	"|APP|APP|APP|APP|Amount|Amount|Amount|Amount|Amount|Amount|Amount|Amount|Amount|Conversion|Conversion|Conversion|Conversion|Conversion|Conversion|Conversion|Conversion" + 
	                	"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20";
	                var HeadTitle2 = "|Code|Description|Route\nID.|Code|Description|Term|Code|Code|Code|Description|Term|Direct\nCall|T/S\nPort|Lane|VVD" + 
	                	"|Code|Application|Cur.|Dry 20'|Dry 40'|Dry 40HC|BL|CM|BX|Direct\nCall|T/S\nPort|Lane|VVD|Pay\nTerm|Node|Weight\n(Ton < = )|Weight\n( > Ton)" + 
	                	"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20";
	                var headCount = ComCountHeadTitle(HeadTitle2);
	
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, false);
	
	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");	                
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false, 6);	                
	                InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, false, false, 5);            
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "org_rcv_de_term_nm", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "dest_rcv_de_term_nm", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "app_bkg_dir_call_flg", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "app_bkg_ts_port_def_cd", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "app_bkg_slan_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "app_bkg_vvd_cd", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "chg_rule_def_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "rt_appl_tp_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "curr_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "rate_dry20", false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "rate_dry40", false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "rate_dry40hc", false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_rat_ut_cd_bl", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_rat_ut_cd_cm", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_rat_ut_cd_bx", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "conv_bkg_dir_call_flg", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "conv_bkg_ts_port_def_cd", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "conv_bkg_slan_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "conv_bkg_vvd_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "pay_term_cd", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_yd_cd", false, "", dfNone, 0, true, true);	                
	                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_min_cgo_wgt", false, "", dfNullFloat, 2, true, true, 4);
	                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_max_cgo_wgt", false, "", dfNullFloat, 2, true, true, 4);
	                
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "cmdt_dp_seq");	                
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "note_conv_mapg_id");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "note_conv_seq");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "note_conv_tp_cd");  
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "eff_dt");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "exp_dt");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "mst_rfa_rout_id");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "src_info_cd");
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "n1st_cmnc_amdt_seq");	                
	                InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "chg_rule_tp_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "note_conv_chg_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "note_conv_rule_cd");		            
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "app_bkg_vsl_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "app_bkg_skd_voy_no");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "app_bkg_skd_dir_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "app_bkg_ts_port_tp_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "conv_bkg_vsl_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "conv_bkg_skd_voy_no");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "conv_bkg_skd_dir_cd");
		            InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "conv_bkg_ts_port_tp_cd");
		            
	                InitDataCombo(0, "app_bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
		            InitDataCombo(0, "conv_bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
		            InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);
		            InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText + "|Subject", rtApplTpCdComboValue + "|S", "", "", 0, "", "", rtApplTpCdComboText); 
//		            InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);
	                InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue); 	                	                
	                InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue); 
	                
	                ShowButtonImage = 2;
	                ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
	                InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
	                
	                sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
	            }
	            break;          

        }
    }

    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (!isClear && KeyCode == 9) {
            while (true) {
                Col++;
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
            }
        }
    }

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        // Origin Code 체크Check        
        if (colName == "org_rout_pnt_loc_def_cd") {
            if (Value.length == 5) {
                formObj.f_cmd.value = SEARCH05;
                var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
                } else {
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
                    sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else if (Value.length == 4) {
                formObj.f_cmd.value = SEARCH11;
                var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
                } else {
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
                    sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
                    sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else {
                sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
                sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
                sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
                return false;
            }
            //Destination Code 체크Check        
            } else if (colName == "dest_rout_pnt_loc_def_cd") {
            if (Value.length == 5) {
                formObj.f_cmd.value = SEARCH05;
                var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
                } else {
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
                    sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else if (Value.length == 4) {
                formObj.f_cmd.value = SEARCH11;
                var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
                var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
                } else {
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
                    sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
                    sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                    return false;
                }
            } else {
                sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
                sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
                sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
                return false;
            }
            // Amount > Dry 20' Check
        } else if (colName == "rate_dry20") {
        	if (sheetObj.CellValue(Row, "rate_dry20") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry20")) <= 0.00) {
        		sheetObj.CellValue2(Row, "rate_dry20") = 0;
        	} else if (sheetObj.CellValue(Row, "rate_dry20") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry20")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "rate_dry20") = 9999999.00;
        	}
        	// Amount > Dry 40' Check
        } else if (colName == "rate_dry40") {
        	if (sheetObj.CellValue(Row, "rate_dry40") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry40")) <= 0.00) {
        		sheetObj.CellValue2(Row, "rate_dry40") = 0;
        	} else if (sheetObj.CellValue(Row, "rate_dry40") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry40")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "rate_dry40") = 9999999.00;
        	}
        	// Amount > Dry 40HC' Check
        } else if (colName == "rate_dry40hc") {
        	if (sheetObj.CellValue(Row, "rate_dry40hc") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry40hc")) <= 0.00) {
        		sheetObj.CellValue2(Row, "rate_dry40hc") = 0;
        	} else if (sheetObj.CellValue(Row, "rate_dry40hc") != "" && parseFloat(sheetObj.CellValue(Row, "rate_dry40hc")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "rate_dry40hc") = 9999999.00;
        	}
        	// Amount > BL Check
        } else if (colName == "bkg_rat_ut_cd_bl") {
        	if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_bl") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_bl")) <= 0.00) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_bl") = 0;
        	} else if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_bl") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_bl")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_bl") = 9999999.00;
        	}
        	// Amount > CM Check
        } else if (colName == "bkg_rat_ut_cd_cm") {
        	if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_cm") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_cm")) <= 0.00) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_cm") = 0;
        	} else if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_cm") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_cm")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_cm") = 9999999.00;
        	}
        	// Amount > BX Check
        } else if (colName == "bkg_rat_ut_cd_bx") {
        	if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_bx") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_bx")) <= 0.00) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_bx") = 0;
        	} else if (sheetObj.CellValue(Row, "bkg_rat_ut_cd_bx") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_rat_ut_cd_bx")) >= 9999999.99) {
        		sheetObj.CellValue2(Row, "bkg_rat_ut_cd_bx") = 9999999.00;
        	}
        	// Weight Check
        } else if (colName == "bkg_min_cgo_wgt") {
        	if (sheetObj.CellValue(Row, "bkg_min_cgo_wgt") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_min_cgo_wgt")) <= 0.00) {
        		sheetObj.CellValue2(Row, "bkg_min_cgo_wgt") = "";
        	} else if (sheetObj.CellValue(Row, "bkg_min_cgo_wgt") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_min_cgo_wgt")) >= 99.99) {
        		sheetObj.CellValue2(Row, "bkg_min_cgo_wgt") = 99.00;
        	}
        } else if (colName == "bkg_max_cgo_wgt") {
        	if (sheetObj.CellValue(Row, "bkg_max_cgo_wgt") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_max_cgo_wgt")) <= 0.00) {
        		sheetObj.CellValue2(Row, "bkg_max_cgo_wgt") = "";
        	} else if (sheetObj.CellValue(Row, "bkg_max_cgo_wgt") != "" && parseFloat(sheetObj.CellValue(Row, "bkg_max_cgo_wgt")) >= 99.99) {
        		sheetObj.CellValue2(Row, "bkg_max_cgo_wgt") = 99.00;
        	}
        }
        
        // Sheet 상에서 직접 수정을 한 경우 Save 버튼 비활성화 시킨다.
        ComBtnDisable("btn_save");
    }

	/**
	 * OnDblClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
//        if (colName == "prc_cmdt_def_nm") {
//            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
//            sUrl += "&grp_cd=" + PRI_RP_SCP + "&commodity_cmd=CRG&prc_cmdt_tp_cd=C";
//            sUrl += "&prc_cmdt_def_nm=" + sheetObj.CellValue(Row, Col);
//
//            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
//            if (rtnVal != null){
//                sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = rtnVal.cd;
//                sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = rtnVal.nm;
//        }
        
        // Origin Description Double Clieck 
        if (colName == "org_rout_pnt_loc_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=O";
            sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
            if (rtnVal != null){
                sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = rtnVal.cd;
                sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = rtnVal.nm;
            }
        // Destination Description Double Clieck 
        } else if (colName == "dest_rout_pnt_loc_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=D";
            sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
            if (rtnVal != null){
                sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = rtnVal.cd;
                sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = rtnVal.nm;
            }
        // APP > T/S Port Double Clieck 
        } else if (colName == "app_bkg_ts_port_def_cd") {
			var sUrl = "/hanjin/ESM_PRI_4026.do?";
			sUrl +=  "&location_cmd=L";
				
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "app_bkg_ts_port_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "app_bkg_ts_port_tp_cd") = rtnVal.tp;			
			}
		// APP > T/S Port Double Clieck 	
        } else if (colName == "app_bkg_slan_cd") {
			var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
				
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "app_bkg_slan_cd") = rtnVal.toString();
			}
		// APP > VVD Double Clieck 	
        } else if (colName == "app_bkg_vvd_cd") {
        	var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "app_bkg_vvd_cd") = rtnVal.toString();
				sheetObj.SelectCell(Row, "app_bkg_vvd_cd");
			}
		// Conversion > T/S Port Double Clieck 
        } else if (colName == "conv_bkg_ts_port_def_cd") {
			var sUrl = "/hanjin/ESM_PRI_4026.do?";
			sUrl +=  "&location_cmd=L";
				
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "conv_bkg_ts_port_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "conv_bkg_ts_port_tp_cd") = rtnVal.tp;			
			}	
		// Conversion > Lane Double Clieck 
        } else if (colName == "conv_bkg_slan_cd") {
			var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
				
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "conv_bkg_slan_cd") = rtnVal.toString();
			}
		// Conversion > VVD Double Clieck 
        } else if (colName == "conv_bkg_vvd_cd") {
        	var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "conv_bkg_vvd_cd") = rtnVal.toString();
				sheetObj.SelectCell(Row, "conv_bkg_vvd_cd");
			}
		// Conversion > Node Double Clieck 
        } else if (colName == "bkg_yd_cd") {
			var bkgYdCd = sheetObj.CellValue(Row, "bkg_yd_cd");
			var display = '0,0,1,1,1,1,1,1,1,1,1,1';
			var param = '?mode=yard&node_cd='+bkgYdCd;
			//공통사용 팝업 호출
			ComPriOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'callBackTerminalCode', display, true);
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
	        sheetObj.ShowDebugMsg = false;
	        switch (sAction) {
	
	        case IBSEARCH_ASYNC19: // PORT 조회를 위한 
	            var sXml = "";  
	            formObj.f_cmd.value = SEARCH23;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ratePortArray = ComPriXml2Array(sXml, "loc_cd");
	            break;	  	            
	            
			case IBSEARCH_ASYNC02: // Open File
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					var sFileNm = strFilePath.substring(0, strFilePath.lastIndexOf("."));
					if (sFileNm.substring(sFileNm.length - 1, sFileNm.length) == "V") {
						ComShowCodeMessage("PRI01117");
						return;
					}
					
					sheetObj.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObj.RowCount > 0) {
					toggleButtons("LOAD");
				} else {
					toggleButtons("INIT");
				}
		        
		     	break;
	
			case IBDOWNEXCEL: // Down Excel
				if (sheetObj.id == "sheet1") {					
					sheetObj.Down2Excel(0, false, false, true, "", "", false, false, "", false, "0|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52");
				}

				break;
				
	        case IBSEARCH_ASYNC01: // Check
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	
	            break;
	
	        case IBSAVE: // Save
	        	ComOpenWait(true);
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }

	            if (!ComPriConfirmSave()) {
	                return false;
	            }
           
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2208GS.do", sParam);
	            jobKey = ComGetEtcData(sXml, "JOB_KEY");
	            
				if (sXml.indexOf("ERROR") >= 0) {
					sheetObj.LoadSaveXml(sXml);
					return false;
				} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
					ComShowCodeMessage("PRI00201");
					return false;
				} else {
					timerID = setInterval(getJobStatus, 2000);
				}
				ComOpenWait(false);
	            break;
	
	        case IBCLEAR: // 화면 로딩시
	            var sXml = "";
	            
	            //공통 Term Origin
	            formObj.f_cmd.value = SEARCH19;	            
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD03501");	            
	            setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);
	
	            //공통 Term Destination
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD03500");
	            setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);
	
	            break;
	
	        }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
    }
	 
	function getJobStatus() {
		var jobStatus = null;
		
		form.f_cmd.value = SEARCHLIST18;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
		jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");
		
		if (jobStatus == "3") {
			clearInterval(timerID);
			
            opener.saveCurRowPos();
            opener.reloadPagePostTr();
            
            ComPriSaveCompleted();
            
            window.close();
		} else if (jobStatus == "4") {
			clearInterval(timerID);
			
			ComShowCodeMessage("PRI00201");
			return false;
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 박성수
     * @version 2009.08.27
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC01: // Check
            if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
            if (sheetObj.RowCount <= 0) {
                return false;
            }
            if (formObj.prc_prop_sts_cd.value != "I") {
                return false;
            }

            isClear = true;
         
            var sheetObject2 = sheetObjects[1];

            ComOpenWait(true);
            clearTooltip();

            var cmdtSeq = null;            
            var cmdtCode = null;
            var cmdtDesc = null;
            var routeId = null;            
            var orgPntCode  = null;
            var orgPntDesc  = null;
            var orgPntTerm  = null;            
            var orgViaCode = null;
            var destViaCode = null;
            var destPntCode  = null;
            var destPntDesc  = null;
            var destPntTerm  = null;
            var appDirCall = null;
            var appTsPort = null;
            var appLane = null;
            var appVVD = null;            
            var amtCode = null;
            var amtApp = null;
            var amtCur = null;                       
            var amtDry20 = 0;
            var amtDry40 = 0;
            var amtDry40hc = 0;
            var amtBL = 0;
            var amtCM = 0;
            var amtBX = 0;            
            var convDirCall = null;
            var convTsPort = null;
            var convLane = null;
            var convVVD = null;
            var convPayTerm = null;
            var convNode = null;
            var convWgtTonDown = null;
            var convWgtTonUp = null;            
            var sysGuid = "";
            var duplicateCheck = null;
            var duplicateCheckList = new Array();
            var duplicateCheckCount = 0;
            
            // Duplicate Check. (Origin|O.via|D.via|Destination|APP)
            sheetObj.SpaceDupCheck = false;
        	var rowM1 = sheetObj.ColValueDupRows("org_rout_pnt_loc_def_cd|org_rcv_de_term_nm" +
    		 		"|org_rout_via_port_def_cd|dest_rout_via_port_def_cd|dest_rout_pnt_loc_def_cd|" +
    		 		"|dest_rcv_de_term_nm|app_bkg_dir_call_flg|app_bkg_ts_port_def_cd|app_bkg_slan_cd|app_bkg_vvd_cd", false, true);
    		
        	if (rowM1 != "") {
        		// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
        		// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
        		var rowDupKeyList = rowM1.split("|");	        		
        		var rowArr = rowDupKeyList[0].split(",");
        		var rowObj = rowDupKeyList[1].split(",");
        		
        		for(var i=0; i<rowArr.length; i++) {
     				add2Tooltip(rowArr[i], "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));	
     				add2Tooltip(rowArr[i], "org_rout_pnt_loc_def_nm", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "org_rcv_de_term_nm", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "org_rout_via_port_def_cd", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "dest_rout_via_port_def_cd", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "dest_rout_pnt_loc_def_nm", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "dest_rcv_de_term_nm", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "app_bkg_dir_call_flg", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "app_bkg_ts_port_def_cd", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "app_bkg_slan_cd", ComGetMsg("PRI00302"));
     				add2Tooltip(rowArr[i], "app_bkg_vvd_cd", ComGetMsg("PRI00302"));
        		}
        		isClear = false;
        	}
        	
        	var convCheckStr = new Array();
        	var convCheckEnd = new Array();
        	var convCheckSeq = 0;
        	
        	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
        		if ("OFT" == sheetObj.CellValue(i, "chg_rule_def_cd")) {
        			convCheckStr[convCheckSeq] = i;
        			convCheckSeq++;
        		}
        	}
        	
        	convCheckSeq = 0;
        	
        	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
            	if ("OFT" == sheetObj.CellValue(i, "chg_rule_def_cd") && 2 != i) {
            		convCheckEnd[convCheckSeq] = i - 1;
            		convCheckSeq++;
        		} else if (i == n - 1) {
        			convCheckEnd[convCheckSeq] = n - 1;
        		}
        	}
        	
        	// Duplicate Check. (Amount[Code|Application]|Conversion[Direct Call|T/S Port|Lane|VVD|Pay Term|Node|Weight|Weight])
        	for (var k = 0; k < convCheckStr.length; k++) {
        		var rowM2 = sheetObj.ColValueDupRows("chg_rule_def_cd|rt_appl_tp_cd|" +
        		 		"|conv_bkg_dir_call_flg|conv_bkg_ts_port_def_cd|conv_bkg_slan_cd|conv_bkg_vvd_cd" +
        		 		"|pay_term_cd|bkg_yd_cd|bkg_max_cgo_wgt|bkg_min_cgo_wgt", false, true, convCheckStr[k], convCheckEnd[k]);
        		
            	if (rowM2 != "") {
            		// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
            		// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
            		var rowDupKeyList = rowM2.split("|");	        		
            		var rowArr = rowDupKeyList[0].split(",");
            		var rowObj = rowDupKeyList[1].split(",");
            		
            		for(var i=0; i<rowArr.length; i++) {
         				add2Tooltip(rowArr[i], "chg_rule_def_cd", ComGetMsg("PRI00302"));	
         				add2Tooltip(rowArr[i], "rt_appl_tp_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "conv_bkg_dir_call_flg", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "conv_bkg_ts_port_def_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "conv_bkg_slan_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "conv_bkg_vvd_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "pay_term_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "bkg_yd_cd", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "bkg_max_cgo_wgt", ComGetMsg("PRI00302"));
         				add2Tooltip(rowArr[i], "bkg_min_cgo_wgt", ComGetMsg("PRI00302"));
            		}
            		isClear = false;
            	}
        	}
        	
        	// Amount[Code] 값 없는 행 지우기
            for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {   
            	// Code의 공백 제거하고도 값이 없는 경우만 행 지운다.
//            	if (sheetObj.CellValue(i, "chg_rule_def_cd") == "" || sheetObj.CellValue(i, "rt_appl_tp_cd") == "") {
            	if (sheetObj.CellValue(i, "chg_rule_def_cd") == "" && sheetObj.CellText(i, "chg_rule_def_cd").replace(/\s/gi, '') == "") {
            		sheetObj.RowDelete(i, false);
            		i--;
            	}
			}
            
            for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {                
                // Commodity Check.
            	cmdtSeq = sheetObj.CellValue(i, "cmdt_dp_seq");
                cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
                cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");   
                
                // Origin Point Check.
                orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
                orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
                orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
                
                // Origin Via Check.
                orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");

                // Destination Via Check.
                destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
                                
                // Destination Point Check.
                destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
                destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
                destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
              
                // APP Check.
                appDirCall = sheetObj.CellValue(i, "app_bkg_dir_call_flg");
                appTsPort = sheetObj.CellValue(i, "app_bkg_ts_port_def_cd");
                appLane = sheetObj.CellValue(i, "app_bkg_slan_cd");
                appVVD = sheetObj.CellValue(i, "app_bkg_vvd_cd");
                                               
                // Amount Check.
                amtCode = sheetObj.CellValue(i, "chg_rule_def_cd");
                amtApp = sheetObj.CellValue(i, "rt_appl_tp_cd");
                amtCur = sheetObj.CellValue(i, "curr_cd");
                amtDry20 = sheetObj.CellValue(i, "rate_dry20");
                amtDry40 = sheetObj.CellValue(i, "rate_dry40");
                amtDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
                amtBL = sheetObj.CellValue(i, "bkg_rat_ut_cd_bl");
                amtCM = sheetObj.CellValue(i, "bkg_rat_ut_cd_cm");
                amtBX = sheetObj.CellValue(i, "bkg_rat_ut_cd_bx");
                
                if (orgPntCode != "" && orgViaCode != "" && destViaCode != "" && destPntCode != "" && amtCode == "OFT") {
                	// Origin Code Check
                	if (orgPntCode != "") {
                        if (orgPntCode.length != 4 && orgPntCode.length != 5) {
                            add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            sheetObj.SelectCell(i, "org_rout_pnt_loc_def_cd");
                            isClear = false;
                        }
                    }
                	
                	// Origin Via Check
                    if (orgViaCode != "") {
                        if (orgViaCode.length != 4 && orgViaCode.length != 5) {
                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            sheetObj.SelectCell(i, "org_rout_via_port_def_cd");
                            isClear = false;
                        }
                    }
                    
                    // Destination Via Check
                    if (destViaCode != "") {
                        if (destViaCode.length != 4 && destViaCode.length != 5) {
                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            sheetObj.SelectCell(i, "dest_rout_via_port_def_cd");
                            isClear = false;
                        }
                    }
                    
                    // Destination Code Check
                    if (destPntCode != "") {
                        if (destPntCode.length != 4 && destPntCode.length != 5) {
                            add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            sheetObj.SelectCell(i, "dest_rout_pnt_loc_def_cd");
                            isClear = false;
                        }
                    }
                }
                
                if (orgPntCode == "" && amtCode == "OFT") {
                    // Origin Point Mendatory Check.                   
                    add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Code"));
                    sheetObj.SelectCell(i, "org_rout_pnt_loc_def_cd");
                    isClear = false;
                } 
                if (orgViaCode == "" && amtCode == "OFT") {
                    // Origin Via Mendatory Check.                	
            		add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
            		sheetObj.SelectCell(i, "org_rout_via_port_def_cd");
            		isClear = false;
                } 
                if (destViaCode == "" && amtCode == "OFT") {
                    // Destination Via Mendatory Check.                	
            		add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
            		sheetObj.SelectCell(i, "dest_rout_via_port_def_cd");
            		isClear = false;
                }
                if (destPntCode == "" && amtCode == "OFT") {
                    // Destination Point Mendatory Check.
                    add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
                    sheetObj.SelectCell(i, "dest_rout_pnt_loc_def_cd");
                    isClear = false;                    
                } 
                if (orgPntCode != "" && orgViaCode != "" && destViaCode != "" && destPntCode != "" && amtCode != "OFT") {
                    add2Tooltip(i, "chg_rule_def_cd", ComGetMsg("PRI00315"));
                    sheetObj.SelectCell(i, "chg_rule_def_cd");
                    isClear = false;
                }
                
                // Origin Term & Dest Term
                if(amtCode == "OFT") {
                	var orgTermList = (sheetObj.GetComboInfo(i,"org_rcv_de_term_nm", "Text") + sheetObj.GetComboInfo(i,"org_rcv_de_term_nm", "Code")).split("|");
                	var destTermList = (sheetObj.GetComboInfo(i,"dest_rcv_de_term_nm", "Text") + sheetObj.GetComboInfo(i,"dest_rcv_de_term_nm", "Code")).split("|");
                	var orgTermDiv = false;
                	var destTermDiv = false;
                	
                	// Origin Term Code Check
                	for (var j = 1; j < orgTermList.length; j++) {
                		if (orgTermList[j] == orgPntTerm && orgPntTerm != "") {                    		
                			orgTermDiv = true;
                		}
                	}
                	
                	if (orgTermDiv == false) {
                		add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
                		isClear = false;
                	}
                	
                	// Destination Term Code Check
                	for (var j = 1; j < destTermList.length; j++) {
                		if (destTermList[j] == destPntTerm && destPntTerm != "") {
                			destTermDiv = true;
                		}
                	}
                	
                	if (destTermDiv == false) {
                		add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
                		isClear = false;
                	}
                }
                
                // Amount > Code Check 
            	if (amtCode == "") {
            		add2Tooltip(i, "chg_rule_def_cd", ComGetMsg("PRI00316", "Amount Code"));
            		sheetObj.SelectCell(i, "chg_rule_def_cd");
            		isClear = false;
            	}
                
            	// Amount > Application Check 
            	if (amtApp == "") {
            		add2Tooltip(i, "rt_appl_tp_cd", ComGetMsg("PRI00316", "Amount Application"));
            		sheetObj.SelectCell(i, "rt_appl_tp_cd");
            		isClear = false;
            	}
               
            	// Amount > Application : Fix Amount 
                if (amtApp == "F") {
                    if (amtCur == "") {
                    	add2Tooltip(i, "curr_cd", ComGetMsg("PRI00316", "Amount Cur."));
                    	sheetObj.SelectCell(i, "curr_cd");
                    	isClear = false;
                    }
                    
                    if (amtDry20 == "" && amtDry40 == "" && amtDry40hc == "" && amtBL == "" && amtCM == "" && amtBX == "") {
                    	add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00335", "Amount Dry 20'"));
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00335", "Amount Dry 40'"));
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00335", "Amount Dry 40HC'"));
                        add2Tooltip(i, "bkg_rat_ut_cd_bl", ComGetMsg("PRI00335", "Amount BL"));
                        add2Tooltip(i, "bkg_rat_ut_cd_cm", ComGetMsg("PRI00335", "Amount CM"));
                        add2Tooltip(i, "bkg_rat_ut_cd_bx", ComGetMsg("PRI00335", "Amount BX"));
                        sheetObj.SelectCell(i, "rate_dry20");
                        isClear = false;
                    }
                // Amount > Application : Subject Not
                } else if (amtApp != "S") {
                	if (amtCur != "" || amtDry20 != "" || amtDry40 != "" || amtDry40hc != "" || amtBL != "" || amtCM != "" || amtBX != "") {
                		add2Tooltip(i, "curr_cd", ComGetMsg("PRI00330", "Amount Cur."));
                    	add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00330", "Amount Dry 20'"));
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00330", "Amount Dry 40'"));
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00330", "Amount Dry 40HC'"));
                        add2Tooltip(i, "bkg_rat_ut_cd_bl", ComGetMsg("PRI00330", "Amount BL"));
                        add2Tooltip(i, "bkg_rat_ut_cd_cm", ComGetMsg("PRI00330", "Amount CM"));
                        add2Tooltip(i, "bkg_rat_ut_cd_bx", ComGetMsg("PRI00330", "Amount BX"));
                        sheetObj.SelectCell(i, "curr_cd");
                        isClear = false;
                	}
                }

                // Amount > Dry 20' Check 
                if (amtDry20 != "") {
                    if (amtDry20 != "" && parseFloat(amtDry20) <= 0.00) {
                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00321", "Amount Dry 20'", "0"));
                        sheetObj.SelectCell(i, "rate_dry20");
                        isClear = false;
                    } else if (amtDry20 != "" && parseFloat(amtDry20) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00336", "Amount Dry 20'", "9999999.99"));
                        sheetObj.SelectCell(i, "rate_dry20");
                        isClear = false;
                    }
                }
                	
                // Amount > Dry 40' Check 
                if (amtDry40 != "") {
                    if (amtDry40 != "" && parseFloat(amtDry40) <= 0.00) {
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00321", "Amount Dry 40'", "0"));
                        sheetObj.SelectCell(i, "rate_dry40");
                        isClear = false;
                    } else if (amtDry40 != "" && parseFloat(amtDry40) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00336", "Amount Dry 40'", "9999999.99"));
                        sheetObj.SelectCell(i, "rate_dry40");
                        isClear = false;
                    }
                }

                // Amount > Dry 40HC Check 
                if (amtDry40hc != "") {
                    if (amtDry40hc != "" && parseFloat(amtDry40hc) <= 0.00) {
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00321", "Amount Dry 40HC'", "0"));
                        sheetObj.SelectCell(i, "rate_dry40hc");
                        isClear = false;
                    } else if (amtDry40hc != "" && parseFloat(amtDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00336", "Amount Dry 40HC'", "9999999.99"));
                        sheetObj.SelectCell(i, "rate_dry40hc");
                        isClear = false;
                    }
                }

                // Amount > BL Check 
                if (amtBL != "") {
                    if (amtBL != "" && parseFloat(amtBL) <= 0.00) {
                        add2Tooltip(i, "bkg_rat_ut_cd_bl", ComGetMsg("PRI00321", "Amount BL", "0"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_bl");
                        isClear = false;
                    } else if (amtBL != "" && parseFloat(amtBL) >= 9999999.99) {
                        add2Tooltip(i, "bkg_rat_ut_cd_bl", ComGetMsg("PRI00336", "Amount BL", "9999999.99"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_bl");
                        isClear = false;
                    }
                }

                // Amount > CM Check 
                if (amtCM != "") {
                    if (amtCM != "" && parseFloat(amtCM) <= 0.00) {
                        add2Tooltip(i, "bkg_rat_ut_cd_cm", ComGetMsg("PRI00321", "Amount CM", "0"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_cm");
                        isClear = false;
                    } else if (amtCM != "" && parseFloat(amtCM) >= 9999999.99) {
                        add2Tooltip(i, "bkg_rat_ut_cd_cm", ComGetMsg("PRI00336", "Amount CM", "9999999.99"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_cm");
                        isClear = false;
                    }
                }

                // Amount > BX Check 
                if (amtBX != "") {
                    if (amtBX != "" && parseFloat(amtBX) <= 0.00) {
                        add2Tooltip(i, "bkg_rat_ut_cd_bx", ComGetMsg("PRI00321", "Amount BX", "0"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_bx");
                        isClear = false;
                    } else if (amtBX != "" && parseFloat(amtBX) >= 9999999.99) {
                        add2Tooltip(i, "bkg_rat_ut_cd_bx", ComGetMsg("PRI00336", "Amount BX", "9999999.99"));
                        sheetObj.SelectCell(i, "bkg_rat_ut_cd_bx");
                        isClear = false;
                    }
                }      
                
                // Conversion Check.
                convDirCall = sheetObj.CellValue(i, "conv_bkg_dir_call_flg");                
                convTsPort = sheetObj.CellValue(i, "conv_bkg_ts_port_def_cd");
                convLane = sheetObj.CellValue(i, "conv_bkg_slan_cd");
                convVVD = sheetObj.CellValue(i, "conv_bkg_vvd_cd");
                convPayTerm = sheetObj.CellValue(i, "pay_term_cd");
                convNode = sheetObj.CellValue(i, "bkg_yd_cd");
                convWgtTonDown = sheetObj.CellValue(i, "bkg_min_cgo_wgt");
                convWgtTonUp = sheetObj.CellValue(i, "bkg_max_cgo_wgt");

                // Note Conversion Mapping ID 생성
                if (orgPntCode != "" && destPntCode != "" ) {
	                sysGuid = getSYSGUID();
	                if (sysGuid == "" || sysGuid.length < 16) {
	                	return false;
	                }
                }
	            sheetObj.CellValue2(i, "note_conv_mapg_id") = sysGuid;
	            
                // App Direct Call Check
                if (appDirCall != "" || appDirCall.length == 1){
                    if (appDirCall == "Y"){
            			sheetObj.CellValue2(i, "app_bkg_ts_port_def_cd") = "";
            			sheetObj.CellEditable(i, "app_bkg_ts_port_def_cd") = false;

            		} else {
            			sheetObj.CellEditable(i, "app_bkg_ts_port_def_cd") = true;
            		}
                }
                
                // App T/S Port Check
                if (appTsPort != "" || appTsPort.length == 5){
        			formObj.f_cmd.value = COMMAND24;
        			var sParam = FormQueryString(formObj);
        			sParam += "&etc1="+PRI_RP_SCP+"&cd="+appTsPort;
        		
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
      				
      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(i, "app_bkg_ts_port_def_cd") = arrData[0];
    					sheetObj.CellValue2(i,"app_bkg_ts_port_tp_cd") = "L";
    					 						
    					//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
    					sheetObj.CellEditable(i, "app_bkg_dir_call_flg") = false;   					
    				}else{
    					add2Tooltip(i, "app_bkg_ts_port_def_cd", ComGetMsg("PRI00315"));
      					sheetObj.CellValue2(i,"app_bkg_ts_port_tp_cd") = "";
      					sheetObj.SelectCell(i,"app_bkg_ts_port_def_cd");
      					sheetObj.CellEditable(i, "app_bkg_dir_call_flg") = true;
      					isClear = false;
    				}	  				
        		}
                
                // App Lane Check
                if (appLane != "" || appLane.length == 3){
        			formObj.f_cmd.value = COMMAND26;
        			var sParam = FormQueryString(formObj);
        			sParam += "&cd="+appLane;
        			
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(i, "app_bkg_slan_cd") = arrData[0];
    				}else{
    					add2Tooltip(i, "app_bkg_slan_cd", ComGetMsg("PRI00315"));
      					sheetObj.SelectCell(i,"app_bkg_slan_cd");
      					isClear = false;
    				}	  				
        		}else{	 	
    					sheetObj.CellValue2(i, "app_bkg_slan_cd") = "";
    					sheetObj.SelectCell(i, "app_bkg_slan_cd");  				
        		}
                
                // App VVD Check
                if (appVVD != "" && appVVD.length == 9){    				
    				var vslCd 		= appVVD.substring(0,4);
    				var skdVoyNo 	= appVVD.substring(4,8);
    				var skdDirCd 	= appVVD.substring(8,9);
    						
        			var sParam = "f_cmd="+COMMAND27;
        			sParam += "&cd="+vslCd;
        			sParam += "&etc1="+skdVoyNo;
        			sParam += "&etc2="+skdDirCd;
      
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
      					sheetObj.CellValue2(i, "app_bkg_vvd_cd") 		= arrData[0];
    					sheetObj.CellValue2(i, "app_bkg_vsl_cd") 		= vslCd;
    					sheetObj.CellValue2(i, "app_bkg_skd_voy_no")	= skdVoyNo;
    					sheetObj.CellValue2(i, "app_bkg_skd_dir_cd")	= skdDirCd;
    					}else{
    					add2Tooltip(i, "app_bkg_vvd_cd", ComGetMsg("PRI00315"));
    					sheetObj.CellValue2(i, "app_bkg_vsl_cd") 		= "";
    					sheetObj.CellValue2(i, "app_bkg_skd_voy_no")	= "";
    					sheetObj.CellValue2(i, "app_bkg_skd_dir_cd")	= "";
    					sheetObj.SelectCell(i, "app_bkg_vvd_cd");
                		isClear = false;
    					}
        		} else{	
        			sheetObj.CellValue2(i, "app_bkg_vvd_cd") 		= "";
    				sheetObj.CellValue2(i, "app_bkg_vsl_cd") 		= "";
    				sheetObj.CellValue2(i, "app_bkg_skd_voy_no")	= "";
    				sheetObj.CellValue2(i, "app_bkg_skd_dir_cd")	= "";
        			sheetObj.SelectCell(i, "app_bkg_vvd_cd");	
        		}
                
                // Amount Code Check
                if (amtCode != null && amtCode != "" && amtCode.length == 3) {    				
    				var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
    				var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
    				
    				if (sCode.indexOf(amtCode) < 0) {
    					formObj.f_cmd.value = COMMAND09;
    					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + amtCode);
    					
    					var arrData = ComPriXml2Array(sXml, "cd|nm");
    					if (arrData != null && arrData.length > 0) {
    						sCode += "|" + Value;
    						sText += "|" + Value;
    						sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
    						
    						ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
    					} else {
    						sheetObj.CellValue2(i, "chg_rule_def_cd") = "";
    					}
    				}
    				
    				insertChargeRuleType(sheetObj, i);
    			}
                
                // Amount Application Check
                if (amtApp != null && amtApp != "" && amtApp.length == 1) { 
                	var chgRuleDefCd = 	sheetObj.CellValue(i, "chg_rule_def_cd");
        			
        			if (amtApp == "F") {    
    					sheetObj.CellEditable(i, "curr_cd")				= true;    	          		
    					sheetObj.CellEditable(i, "rate_dry20")			= true;
    					sheetObj.CellEditable(i, "rate_dry40")			= true;
    					sheetObj.CellEditable(i, "rate_dry40hc")		= true;
                        if(amtCode != "OFT") {
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_bl")	= true;
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_cm")	= true;
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_bx")	= true;
                        } else {
                        	sheetObj.CellEditable(i, "rt_appl_tp_cd")	= false;
                        }                       
    				} else if (amtApp != "S") {
    					sheetObj.CellEditable(i, "curr_cd") 			= false;
    					sheetObj.CellEditable(i, "rate_dry20")			= false;
    					sheetObj.CellEditable(i, "rate_dry40")			= false;
    					sheetObj.CellEditable(i, "rate_dry40hc")		= false;
                        if(amtCode != "OFT") {
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_bl")	= false;
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_cm")	= false;
                        	sheetObj.CellEditable(i, "bkg_rat_ut_cd_bx")	= false;
                        } else {
                        	sheetObj.CellEditable(i, "rt_appl_tp_cd")	= false;
                        }                       
    				}    				
                }
                
                // Amount Cur. Check
                if ( amtCur != "" || amtCur.length == 3 ) {
                	var chgRuleDefCd = sheetObj.CellValue(i, "chg_rule_def_cd");
        			if(chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD"){
         				if (amtCur != "USD" && amtCur != "EUR" && amtCur != "GBP" && amtCur != "INR" && amtCur != "NOK"){         					
         					add2Tooltip(i, "curr_cd", ComGetMsg("PRI01074", "USD, EUR, GBP, INR, NOK"));
         					sheetObj.SelectCell(Row, "curr_cd");
         	    		}
        			}
                }
    				
                // Conversion Direct Call Check
                if (convDirCall != "" || convDirCall.length == 1){
                    if (convDirCall == "Y"){
            			sheetObj.CellValue2(i, "conv_bkg_ts_port_def_cd") = "";
            			sheetObj.CellEditable(i, "conv_bkg_ts_port_def_cd") = false;
            		} else {
            			sheetObj.CellEditable(i, "conv_bkg_ts_port_def_cd") = true;
            		}
                }
                
                // Conversion T/S Port Check
                if (convTsPort != "" || convTsPort.length == 5){
        			formObj.f_cmd.value = COMMAND24;
        			var sParam = FormQueryString(formObj);
        			sParam += "&etc1="+PRI_RP_SCP+"&cd="+convTsPort;
        		
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
      				
      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(i, "conv_bkg_ts_port_def_cd") = arrData[0];
    					sheetObj.CellValue2(i,"conv_bkg_ts_port_tp_cd") = "L";
    					 						
    					//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
    					sheetObj.CellEditable(i, "conv_bkg_dir_call_flg") = false;
    					
    				}else{
    					add2Tooltip(i, "conv_bkg_ts_port_def_cd", ComGetMsg("PRI00315"));
      					sheetObj.CellValue2(i,"conv_bkg_ts_port_tp_cd") = "";
      					sheetObj.SelectCell(i,"conv_bkg_ts_port_def_cd");
      					sheetObj.CellEditable(i, "conv_bkg_dir_call_flg") = true;
      					isClear = false;
    				}	  				
        		}
                
                // Conversion Lane Check
                if (convLane != "" || convLane.length == 3){
        			formObj.f_cmd.value = COMMAND26;
        			var sParam = FormQueryString(formObj);
        			sParam += "&cd="+convLane;
        			
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(i, "conv_bkg_slan_cd") = arrData[0];
    				}else{
    					add2Tooltip(i, "conv_bkg_slan_cd", ComGetMsg("PRI00315"));
      					sheetObj.SelectCell(i,"conv_bkg_slan_cd");
      					isClear = false;
    				}	  				
        		}else{	 	
    					sheetObj.CellValue2(i, "conv_bkg_slan_cd") = "";
    					sheetObj.SelectCell(i, "conv_bkg_slan_cd");  				
        		}
                
                // Conversion VVD Check
                if (convVVD != "" && convVVD.length == 9){        		
    				var vslCd 		= convVVD.substring(0,4);
    				var skdVoyNo 	= convVVD.substring(4,8);
    				var skdDirCd 	= convVVD.substring(8,9);
    						
        			var sParam = "f_cmd="+COMMAND27;
        			sParam += "&cd="+vslCd;
        			sParam += "&etc1="+skdVoyNo;
        			sParam += "&etc2="+skdDirCd;
      
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
      					sheetObj.CellValue2(i, "conv_bkg_vvd_cd") 		= arrData[0];
    					sheetObj.CellValue2(i, "conv_bkg_vsl_cd") 		= vslCd;
    					sheetObj.CellValue2(i, "conv_bkg_skd_voy_no")	= skdVoyNo;
    					sheetObj.CellValue2(i, "conv_bkg_skd_dir_cd")	= skdDirCd;
    					}else{
    					add2Tooltip(i, "conv_bkg_vvd_cd", ComGetMsg("PRI00315"));
    					sheetObj.CellValue2(i, "conv_bkg_vsl_cd") 		= "";
    					sheetObj.CellValue2(i, "conv_bkg_skd_voy_no")	= "";
    					sheetObj.CellValue2(i, "conv_bkg_skd_dir_cd")	= "";
    					sheetObj.SelectCell(i, "conv_bkg_vvd_cd");
                		isClear = false;
    					}
        		} else{	
        			sheetObj.CellValue2(i, "conv_bkg_vvd_cd") 		= "";
    				sheetObj.CellValue2(i, "conv_bkg_vsl_cd") 		= "";
    				sheetObj.CellValue2(i, "conv_bkg_skd_voy_no")	= "";
    				sheetObj.CellValue2(i, "conv_bkg_skd_dir_cd")	= "";
        			sheetObj.SelectCell(i, "conv_bkg_vvd_cd");	
        		}
                
                // Conversion Node Check
                if (convNode != "" || convNode.length == 7){    
                	formObj.f_cmd.value = SEARCH;
        			var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do", FormQueryString(formObj)+"&node_cd="+convNode);
        			var arrDesc = ComPriXml2Array(sXml, "yd_cd");        		
        			if(arrDesc == null || arrDesc.length < 1) {
        				add2Tooltip(i, "bkg_yd_cd", ComGetMsg("PRI00315"));
        				isClear = false;
        			}
                } else {
        			sheetObj.CellValue2(i, "bkg_yd_cd") = "";
        		}
                
                // Conversion Weight Ton <=
                if (convWgtTonDown != "") {
                // [CHM-201641821] RFA 1차 오류 수정 및 보완
//                    if (convWgtTonDown != "" && parseFloat(convWgtTonDown) <= 0.00) {
                    if (parseFloat(convWgtTonDown) <= 0.00) {
                        add2Tooltip(i, "bkg_min_cgo_wgt", ComGetMsg("PRI00321", "Conversion Weight (Ton <= )", "0"));
                        sheetObj.SelectCell(i, "bkg_min_cgo_wgt");
                        isClear = false;
                    } else if (convWgtTonDown != "" && parseFloat(convWgtTonDown) >= 99.99) {
                        add2Tooltip(i, "bkg_min_cgo_wgt", ComGetMsg("PRI00336", "Conversion Weight (Ton <= )", "99.99"));
                        sheetObj.SelectCell(i, "bkg_min_cgo_wgt");
                        isClear = false;
                    }
                }
                
                // Conversion Weight > Ton 
                if (convWgtTonUp != "") {
               	//  [CHM-201641821] RFA 1차 오류 수정 및 보완
//                    if (convWgtTonUp != "" && parseFloat(convWgtTonUp) <= 0.00) { 
                    if (parseFloat(convWgtTonUp) <= 0.00) {
                        add2Tooltip(i, "bkg_max_cgo_wgt", ComGetMsg("PRI00321", "Conversion Weight ( > Ton)", "0"));
                        sheetObj.SelectCell(i, "bkg_max_cgo_wgt");
                        isClear = false;
                    } else if (convWgtTonUp != "" && parseFloat(convWgtTonUp) >= 99.99) {
                        add2Tooltip(i, "bkg_max_cgo_wgt", ComGetMsg("PRI00336", "Conversion Weight ( > Ton)", "99.99"));
                        sheetObj.SelectCell(i, "bkg_max_cgo_wgt");
                        isClear = false;
                    }
                }  
            
                // max값 보다 min값이 크면 오류
                if ((Number(convWgtTonDown) > Number(convWgtTonUp) && convWgtTonDown != "" && convWgtTonUp != "")) {
                	add2Tooltip(i, "bkg_min_cgo_wgt", ComGetMsg("PRI00321", "Weight ( > Ton)", "Weight (Ton <= )"));
                	add2Tooltip(i, "bkg_max_cgo_wgt", ComGetMsg("PRI00321", "Weight ( > Ton)", "Weight (Ton <= )"));
                	isClear = false;
                }
                
                sheetObj.CellValue2(i, "note_conv_tp_cd") = "R";
                sheetObj.CellValue2(i, "eff_dt") = formObj.eff_dt.value;
                sheetObj.CellValue2(i, "exp_dt") = formObj.exp_dt.value;
                sheetObj.CellValue2(i, "src_info_cd") = "NW";
                sheetObj.CellValue2(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
            }  
                      
            formObj.f_cmd.value = SEARCH01;
            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
            var sXml = sheetObject2.GetSearchXml("ESM_PRI_2208GS.do", sParam);
            var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");

            if (arrErr != null && arrErr.length > 0) {
                isClear = false;
                var msg = ComGetMsg("PRI00315");
                for (var i = 0; i < arrErr.length; i++) {
                    add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
                }
            }
            
            ComOpenWait(false);
            document.body.scroll = "no";
            
            if (isClear) {            	
                toggleButtons("CHECK");
                return true;
            } else {
                toggleButtons("LOAD");
                return false;
            }
            break;

        case IBSAVE: // 저장
            return true;
            break;
        }
    }

    function clearTooltip() {
        var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows+sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                    sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }

    function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];

        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }
    
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function toggleButtons(step) {
        switch (step) {
        case "INIT":
            ComBtnEnable("btn_openfile");
//            ComBtnDisable("btn_downexcel");
            ComBtnDisable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "LOAD":
            ComBtnEnable("btn_openfile");
//            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "CHECK":
            ComBtnEnable("btn_openfile");
//            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_check");
            ComBtnEnable("btn_save");
            break;
        }
    }
	 
		
	function searchCYPortLocation( sheetObj, row, colName,org_dest_tp_cd , locType, ficRtTpCd){
		//먼저 call port flag가 'Y'인지 검사를 해서 'Y'가 아니라면 못들어 간다.
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sender = sheetObj;
		var sParam = FormQueryString(formObj);		
		var loc_cd = sheetObj.CellValue(row, colName);
		sParam += "&loc_type_cd="+locType+"&loc_cd=" + loc_cd+"&org_dest_tp_cd="+org_dest_tp_cd;
		var sXml = sender.getSearchXml("ESM_PRI_2028GS.do", sParam);
		var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
		var arrDesc = ComPriXml2Array(sXml, "loc_cd|call_port_flg");
		if(arrDesc!=null && arrDesc.length>0){
			if( ficRtTpCd == "A"){
				var locCd = arrDesc[0][0];
				var callPortFlg = arrDesc[0][1];
				if (callPortFlg == "Y") {
					return false;
				}	
			}else{
				var flg = false;
				for (var i = 0; i < arrDesc.length; i++) {
					var locCd = arrDesc[i][0];
					var callPortFlg = arrDesc[i][1];

					if (callPortFlg == "N") {
						flg = true;
						break;
					}
				}
				if( flg ){
					return false;
				}
			}
		}
		return true;
	}	 	 

	
	function checkRoute(sheetObj, row, inOrgDestTpCd) {
		if (inOrgDestTpCd == v_origin) {
			var org_rout_pnt_loc_def_cd = sheetObj.CellValue(row, "org_rout_pnt_loc_def_cd");
			var org_rcv_de_term_nm = sheetObj.CellValue(row, "org_rcv_de_term_nm");
			if (org_rout_pnt_loc_def_cd != '') {
				if (org_rout_pnt_loc_def_cd.length == 5) {
					if (ratePortArray.toString().indexOf(org_rout_pnt_loc_def_cd) == -1) {
						add2Tooltip(row, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI07013"));
						isClear = false;
					}
				} else {
					var locType = 'G';
					var ficRtTpCd = 'G';
					var value = 'org_rout_pnt_loc_def_cd';
					var org_dest_tp_cd = 'O';
					if (!searchCYPortLocation(sheetObj, row, value, org_dest_tp_cd, locType, ficRtTpCd)) {
						add2Tooltip(row, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI07013"));
						isClear = false;
					}
				}
			}
			if (org_rcv_de_term_nm != '') {
				if (org_rcv_de_term_nm == 'D') {
					add2Tooltip(row, "org_rcv_de_term_nm", ComGetMsg("PRI07021"));
					isClear = false;
				}
			}
		} else if (inOrgDestTpCd == v_destination) {
			var dest_rout_pnt_loc_def_cd = sheetObj.CellValue(row, "dest_rout_pnt_loc_def_cd");
			var dest_rcv_de_term_nm = sheetObj.CellValue(row, "dest_rcv_de_term_nm");
			if (dest_rout_pnt_loc_def_cd != '') {
				if (dest_rout_pnt_loc_def_cd.length == 5) {
					if (ratePortArray.toString().indexOf(dest_rout_pnt_loc_def_cd) == -1) {
						add2Tooltip(row, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI07013"));
						isClear = false;
					}
				} else {
					var locType = 'G';
					var ficRtTpCd = 'G';
					var value = 'dest_rout_pnt_loc_def_cd';
					var org_dest_tp_cd = 'D';
					if (!searchCYPortLocation(sheetObj, row, value, org_dest_tp_cd, locType, ficRtTpCd)) {
						add2Tooltip(row, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI07013"));
						isClear = false;
					}
				}
			}
			if (dest_rcv_de_term_nm != '') {
				if (dest_rcv_de_term_nm == 'D') {
					add2Tooltip(row, "dest_rcv_de_term_nm", ComGetMsg("PRI07021"));
					isClear = false;
				}
			}
		}
	}
	
	function cellEditable(row, col, edit1, edit2) {
		var sheetObj = sheetObjects[0];
		
        if (sheetObj.CellValue(row, "org_rout_pnt_loc_def_cd") != "" && sheetObj.CellValue(row, "dest_rout_pnt_loc_def_cd") != "" && sheetObj.CellValue(row, "chg_rule_def_cd") != "") {
        	sheetObj.CellEditable(row, col) = edit1;
        } else {
        	sheetObj.CellEditable(row, col) = edit2;
        }
	}
	
    /**
     * CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	checkMandatoryValidation(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */ 	
  	function checkMandatoryValidation(sheetObj, Row) {
     	
  		var rowCount = sheetObj.RowCount; 		
  		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
  		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
 			
 			if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ARB") {
 			if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} 
 		
 		return true;
  	}
  	
  	/**
     * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
     * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
     * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
     * <br><b>Example :</b>
     * <pre>
     *	insertChargeRuleType(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */	
	function insertChargeRuleType(sheetObj, Row) {
		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
		
		if(chgRuleDefCd != "OFT") {
			if(chgRuleDefCd != "APP" && chgRuleDefCd != "RAS") {			
				//CHARGE
				sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
				sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
				sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
			} else {
				//RULE
				sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
				sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
				sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
			}
		} else {
			//RULE
			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "APP";
			sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "S";
			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";			
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
	 * @author 최성민
	 * @version 2010.04.23
	 */
	function callBackTerminalCode(rowArray){
		 var colArray = rowArray[0];
	     if(rowArray != null) {
	    	 sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bkg_yd_cd") = colArray[3];
	     } else {
	    	 sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bkg_yd_cd") = "";
	     }
	}
	
	/**
	 * SYS_GUID()값을 리턴하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return sValue EtcData
	 * @author 최성민
	 * @version 2009.08.13
	 */       
	function getSYSGUID() {
		var formObj = document.form;
	 	formObj.f_cmd.value = COMMAND38;
		var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		var sValue = ComGetEtcData(sXml,"SYS_GUID");
		return sValue;
	}	
	