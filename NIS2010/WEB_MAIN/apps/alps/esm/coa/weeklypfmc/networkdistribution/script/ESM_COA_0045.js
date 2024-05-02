/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0045.js
*@FileTitle : HJS Sales/Slot Cht-out
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2006-11-28 Kim Jong Beom 최초 생성
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.19 이행지 Ticket ID:CHM-201002364 Vessel Pool 및 OP4 logic 보완 요청
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2013.08.12 최성민 [CHM-201326152] [COA] HJS Sales / Slot Cht out 화면 R.Month와 Week 정보 추가
*  
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0045 : ESM_COA_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0045() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.validateSheet      = validateSheet      ;
    this.validateCond       = validateCond       ;
    this.setPeriod          = setPeriod          ;
    this.chkValidSearch     = chkValidSearch     ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
  var sheetObject = sheetObjects[0];
  var formObject = document.form;
  
  try {
    var srcName = window.event.srcElement.getAttribute("name");
    
    switch(srcName) {
    
      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;
      
      case "btn_Downexcel":
          doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
          break;

      case "btn_Creation":
          doActionIBSheet(sheetObject,formObject,IBCREATE);
          //// 재 조회
          //doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;

    } // end switch
  } catch(e) {
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
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	loadingMode = true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode = false;
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	with (comboObj) {
		DropHeight = 300;
		Index = 0;
	}
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
  switch(sheetNo) {
      case 1:      //sheet1 init
        var head1 = "|All Network cost by VVD";
        var head2 = "|Network cost for HJS Sales";
        var head3 = "|Network cost for space charter-out";
        var head4 = "|Total" 
                  + "|Port Expense"         
                  + "|Canal Transit Fee"         
                  + "|Bunker"         
                  + "|Crew Expense"         
                  + "|Insurance"         
                  + "|Lubricant Expense"         
                  + "|Store Supply Expense"         
                  + "|Vessel M&R"         
                  + "|Depreciations"         
                  + "|Telecom Expense"         
                  + "|Other Operation Fixed Exp"         
                  + "|Time Charterage"
                  + "|Space Charterage";
        var tmp1 = ""; 
        var tmp2 = ""; 
        var tmp3 = ""; 
        var headText1 = ""; 
        var headText2 = ""; 

        for (var i=0; i<14; i++) {
          tmp1 = tmp1 + head1;
          tmp2 = tmp2 + head2;
          tmp3 = tmp3 + head3;
        }
        headText1 = tmp1 + tmp2 + tmp3;
        for (var j=0; j<3; j++) {
          headText2 = headText2 + head4;
        }

        var LOGIC_amt_1_tot = "|amt_1_01|+|amt_1_02|+|amt_1_03|+|amt_1_04|+|amt_1_05|+"
                            + "|amt_1_06|+|amt_1_07|+|amt_1_08|+|amt_1_09|+|amt_1_10|+"
                            + "|amt_1_11|+|amt_1_12|+|amt_1_13|";
        var LOGIC_amt_2_tot = "|amt_2_01|+|amt_2_02|+|amt_2_03|+|amt_2_04|+|amt_2_05|+"
                            + "|amt_2_06|+|amt_2_07|+|amt_2_08|+|amt_2_09|+|amt_2_10|+"
                            + "|amt_2_11|+|amt_2_12|+|amt_2_13|";
        var LOGIC_amt_3_tot = "|amt_3_01|+|amt_3_02|+|amt_3_03|+|amt_3_04|+|amt_3_05|+"
                            + "|amt_3_06|+|amt_3_07|+|amt_3_08|+|amt_3_09|+|amt_3_10|+"
                            + "|amt_3_11|+|amt_3_12|+|amt_3_13|";
                   
        with (sheetObj) {
          style.height = GetSheetHeight(19) ;
          
          //전체 너비 설정
          SheetWidth = mainTable.clientWidth;
          
          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          
          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msHeaderOnly;
          
           //전체Edit 허용 여부 [선택, Default false]
          Editable = false;
          
          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(2, 1, 9, 100);
          
          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(62, 0, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var HeadTitle0 = "R.Month|Week|Trade|Lane|Vessel|Voy.|BD|Trade Dir.|OPR|OPR2|V.Capa.|BSA.Capa.|Type|Lane Type|Final\nHJS BSA|CHT OUT|HJS(%)|CHT(%)|Unit Cost\nPer Slot|Space Charter\nRevenue"
                         + headText1;
          var HeadTitle1 = "R.Month|Week|Trade|Lane|Vessel|Voy.|BD|Trade Dir.|OPR|OPR2|V.Capa.|BSA.Capa.|Type|Lane Type|Final\nHJS BSA|CHT OUT|HJS(%)|CHT(%)|Unit Cost\nPer Slot|Space Charter\nRevenue"
                         + headText2;
          
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle0, true);
          InitHeadRow(1, HeadTitle1, false);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
          InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "cost_yrmon",    	false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "cost_wk",         	false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "trd_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "rlane_cd",         false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "vsl_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "skd_voy_no",       false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    35, daCenter, true, "dir_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "hul_bnd_cd",           false, "", dfNone,    0, false, false);

          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vop_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vsl_oshp_cd",      false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 50, daRight,  true, "vsl_capa",         false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 65, daRight,  true, "bsa_capa",         false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "bsa_op_nm",        false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "op_lane_tp_cd",    false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 60, daRight,  true, "fnl_hjs_bsa_capa", false, "", dfInteger, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 60, daRight,  true, "co_bsa_capa",      false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    60, daRight,  true, "hjs_bsa_rto",      false, "", dfFloatOrg,   2, false, false);
          InitDataProperty(0, cnt++, dtData,    60, daRight,  true, "chtr_bsa_rto",     false, "", dfFloatOrg,   2, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 60, daRight,  true, "ts_uc_amt",        false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  true, "spc_income",       false, "", dfFloatOrg, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_tot",        false, LOGIC_amt_1_tot, dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_01",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_02",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_03",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_04",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_05",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_06",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_07",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_08",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_09",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_10",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_11",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_12",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_13",         false, "", dfFloatOrg, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_tot",        false, LOGIC_amt_2_tot, dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_01",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_02",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_03",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_04",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_05",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_06",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_07",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_08",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_09",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_10",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_11",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_12",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_13",         false, "", dfFloatOrg, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_tot",        false, LOGIC_amt_3_tot, dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_01",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_02",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_03",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_04",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_05",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_06",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_07",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_08",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_09",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_10",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_11",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_12",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_3_13",         false, "", dfFloatOrg, 0, false, false);

          RangeBackColor(1, 14, 1, 27) = RgbColor(222, 251, 248);
          RangeBackColor(1, 28, 1, 41) = RgbColor(255, 248, 251);
          RangeBackColor(1, 42, 1, 55) = RgbColor(222, 251, 248);

          
          HeadRowHeight = 10;
          CountPosition  = 0 ;
        }
        break;
  
  }
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 */
function f_seltrade_OnChange(obj,value,text) {
	var formObj = document.form;
	if ("All"!=value) {
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST01;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0045GS2.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
		formObj.f_selrlane.Index = 0;
	} else {
		formObj.f_selrlane.RemoveAll();
		formObj.f_selrlane.InsertItem(0, "All", "All");
		formObj.f_selrlane.Index = 0;
	}
}
    
/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComCoaSetPeriod(obj);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {
	    case IBCLEAR:          //조회
		    sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_COA_0045GS2.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			var prevWeek = "";
			if (0 < arrXml.length) {
				ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
				prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
			}
			if (1 < arrXml.length)
				ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
			if (2 < arrXml.length)
				ComXml2ComboItem(arrXml[2], formObj.f_selioc, "code", "name");
			
			formObj.f_year.focus();
			formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		    formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		    formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		    formObj.f_fm_wk.value = formObj.f_to_wk.value = prevWeek;
		    setPeriod(formObj.f_to_wk);
			ComOpenWait(false);
			break;	

		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
			if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
			if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
			if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch4Post("ESM_COA_0045GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
            ComOpenWait(false);
            break;
        
        case IBDOWNEXCEL:   //엑셀 다운로드
            //sheetObj.Down2Excel(-1, false, false, true);
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
        
        case IBCREATE:      //생성
			if(!validateForm(sheetObj,formObj,sAction)) return false;
            if (ComShowConfirm(ComGetMsg('COA10020')) == true) {
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSearch4Post("ESM_COA_0045GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                ComOpenWait(false);
                var err_cd = sheetObj.EtcData("err_cd");
                var err_msg = sheetObj.EtcData("err_msg");
                
                if (err_cd == "00000") {
                    ComShowMessage(ComGetMsg('COA10018','CREATION'));
                } else if(err_cd == "CHK05"  || err_cd == "CHK11") {
                    // HJS Sales/Slot Cht-out 생성시 Missing 이 있을때 
                      strUrl = "?f_stryear="+formObj.f_year.value;
                      strUrl += "&f_strfmmonth="+formObj.f_fm_mon.value;
                      strUrl += "&f_strtomonth="+formObj.f_to_mon.value;                    
                      strUrl += "&f_strfmweek="+formObj.f_fm_wk.value;
                      strUrl += "&f_strtoweek="+formObj.f_to_wk.value ;                   
                      if(formObj.f_chkprd[0].checked){
                        strUrl += "&f_strchkprd="+"W"    // W:Week, M: Month                
                      } else {
                        strUrl += "&f_strchkprd="+"M"    // W:Week, M: Month                
                      }       
                      if (formObj.f_seltrade.Code == "All"){
                    	  strUrl += "&f_strtrade=";
                      }else{
                    	  strUrl += "&f_strtrade="+formObj.f_seltrade.Code;
                      }
                      if (formObj.f_selrlane.Code == "All"){
                    	  strUrl += "&f_strlane=";
                      }else{
                    	  strUrl += "&f_strlane="+formObj.f_selrlane.Code;
                      }
                      strUrl += "&f_strvessel="+formObj.f_vsl_cd.value;
                      strUrl += "&f_strvoyage="+formObj.f_skd_voy_no.value;
                      strUrl += "&f_strdir="+formObj.f_dir_cd.value;
                      strUrl += "&f_strtype="+"3";
                      strUrl += "&f_strprcnm="+"HJS Sales/Slot Cht-out";
                      
                      ComOpenWindow2("ESM_COA_0114.do" + strUrl,'', "width=800,height=340,menubar=0,status=0,scrollbars=0,resizable=1");
                } else if(err_cd == "COA00023") {
                    // Network cost 에 Missing 이 있을때 
                      ComShowMessage(err_msg); 
                }
                sheetObj.EtcData("err_cd") = "";
                sheetObj.EtcData("err_msg") = "";

                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
                if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
                if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
                if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESM_COA_0045GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                ComOpenWait(false);
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
            // [COM12114] : Year 를(을) 확인하세요.
            ComShowMessage(ComGetMsg("COM12114", "Year"));
            f_year.focus();
            return false;
        }
        if((f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == "") 
           && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
            ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
            return false;
        }
        if((f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == "") 
           && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
            ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
            return false;
        }
        //if(!isValidYear(f_year,false,true)) return false;
        if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
        if(!chkValidSearch()) return false;
        if(f_fm_mon.value == "" && f_fm_wk.value == ""){
            // [COM12138] : Month 과 Week 중 하나는 입력하세요.
            ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
            return false;
        }

        if(f_chkprd[0].checked){
            if(f_fm_wk.value == "") {
                ComShowMessage(ComGetMsg("COM12114","From Week",""));
                f_fm_wk.focus();
                return false;
            }

            if(f_fm_wk.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","From Week",""));
                f_fm_wk.focus();
                return false;
            }

            if(f_to_wk.value == "") {
                ComShowMessage(ComGetMsg("COM12114","To Week",""));
                f_to_wk.focus();
                return false;
            }

            if(f_to_wk.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","To Week",""));
                f_to_wk.focus();
                return false;
            }
        }
        else{
            if(f_fm_mon.value == "") {
                ComShowMessage(ComGetMsg("COM12114","From Month",""));
                f_fm_mon.focus();
                return false;
            }

            if(f_fm_mon.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","From Month",""));
                f_fm_mon.focus();
                return false;
            }

            if(f_to_mon.value == "") {
                ComShowMessage(ComGetMsg("COM12114","To Month",""));
                f_to_mon.focus();
                return false;
            }

            if(f_to_mon.value.length != 2) {
                ComShowMessage(ComGetMsg("COM12114","To Month",""));
                f_to_mon.focus();
                return false;
            }
        }
    }
    return true;
}

/**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
function validateSheet(sheetObj) {
	with(sheetObj){
	}

	return true;
}

/**
 * 화면 조회값에 대한 유효성검증 프로세스 처리
 */
function validateCond(formObj,sAction) {
	with(formObj){
	  // msg1 + '  를(을) 확인하세요.';
	  if (ComTrim(f_year.value) == "") {
      ComShowMessage(ComGetMsg('COM12114','Year'));
      f_year.focus();
      return false;
	  }

    //생성시에 만 사용...
    if (sAction == IBCREATE) { 
      // msg1 + ' 의 ' + msg2 + ' 를(을) 입력하세요.';
  	  if (ComTrim(f_sweek.value) == "") {
        ComShowMessage(ComGetMsg('COM12130','Week','First Element'));
        f_sweek.focus();
        return false;
  	  }
  	  if (ComTrim(f_eweek.value) == "") {
        ComShowMessage(ComGetMsg('COM12130','Week','Second Element'));
        f_eweek.focus();
        return false;
  	  }
//      // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + '와 같아야 합니다.';
//  	  if (ComParseInt(formObj.f_sweek.value) != ComParseInt(formObj.f_eweek.value)) {
//        ComShowMessage(ComGetMsg('COA10012','Week', 'First Element', 'Second Element'));
//        formObj.f_sweek.focus();
//        return false;
//  	  }
    }

	  // msg1 + '  과 ' + msg2 + '중 하나는 입력하세요.';
	  if (ComTrim(txtSMonth.value) == "" && ComTrim(f_sweek.value) == "") {
      ComShowMessage(ComGetMsg('COM12138','Month','Week'));
      txtSMonth.focus();
      return false;
	  }
    // msg1 + ' 의 ' + msg2 + ' 를(을) 입력하세요.';
	  if (ComTrim(txtSMonth.value) != "" && ComTrim(txtEMonth.value) == "") {
      ComShowMessage(ComGetMsg('COM12130','Month','Second Element'));
      txtEMonth.focus();
      return false;
	  }
	  if (ComTrim(f_sweek.value) != "" && ComTrim(f_eweek.value) == "") {
      ComShowMessage(ComGetMsg('COM12130','Week','Second Element'));
      f_eweek.focus();
      return false;
	  }
	  // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
		if (ComTrim(txtSMonth.value) != "" && ComTrim(txtEMonth.value) != "") {
	    if(ComParseInt(txtSMonth.value) > ComParseInt(txtEMonth.value)){
        ComShowMessage(ComGetMsg('COA10011','Month','First Element','Second Element'));
        txtSMonth.focus();
        return false;
	    }
		}
		if (ComTrim(f_sweek.value) != "" && ComTrim(f_eweek.value) != "") {
	    if(ComParseInt(f_sweek.value) > ComParseInt(f_eweek.value)){
        ComShowMessage(ComGetMsg('COA10011','Week','First Element','Second Element'));
        f_sweek.focus();
        return false;
	    }
		}
    // msg1 + ' 는(은) ' + msg2 + '자리가 되어야 합니다.';
		if (ComTrim(f_vessel.value) != "" && ComTrim(f_vessel.value).length != 4){
      ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
      f_vessel.focus();
      return false;
		}
		if (ComTrim(f_voyage.value) != "" && ComTrim(f_voyage.value).length != 4){
      ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
      f_voyage.focus();
      return false;
		}
	}

	return true;
}

/**
 * 검색시 필수입력사항 체크
*/
function chkValidSearch(){
    var formObj = document.form;
	
	with(formObj){
		// Year Check..
		if (f_year.value == "") {
			// [COM12114] : Year 를(을) 확인하세요.
			ComShowCodeMessage("COM12114", "Year");
			f_year.focus();
			return false;
		}
		
		if(!ComIsDate(f_year, "yyyy")){
			// [COA10009] = 'Please enter Year correctly.\n\n Format : YYYY
			ComShowCodeMessage('COA10009','Year','YYYY');
			f_year.focus();
			return false;
		}
		
		// Week Check..
		if(f_chkprd[0].checked){
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_to_wk.focus();
				return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_fm_wk.focus();
				return false;
			}
			if (f_fm_wk.value > f_to_wk.value) {
				// [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("COA10011","Week","From","To");
				f_to_wk.focus();
				return false;
			}
			if(!ComIsWeek(f_fm_wk)){
				// [COA1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Week','WW');
				f_fm_wk.focus();
				return false;
			}
			if(!ComIsWeek(f_to_wk)) {
				// [COA1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Week','WW');
				f_to_wk.focus();
				return false;
			}
		}
		// Month Check..
		else {
			if (f_fm_mon.value != "" && f_to_mon.value == ""){
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month")
				f_to_mon.focus();
				return false;
			}
			if (f_fm_mon.value == "" && f_to_mon.value != "") {
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month");
				f_fm_mon.focus();
				return false;
			}
			if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
				// [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("COA10011","Month","From","To");
				f_to_mon.focus();
				return false;
			}
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				//ComShowCodeMessage("COM12138", "month", "week");
				return false;
			}
			if(!ComIsMonth(f_fm_mon)){
				// [COA1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Month','MM');
				f_fm_mon.focus();
				return false;
			}
			if(!ComIsMonth(f_to_mon)) {
				// [COA1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Month','MM');
				f_to_mon.focus();
				return false;
			}
		}
	}
	return true;
}

/**
 * 조회 후
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet1_OnSearchEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if(formObj.f_op_view.value == "OP4"){
		sheetObj.ColHidden("op_lane_tp_cd") = false;
	}else{
		sheetObj.ColHidden("op_lane_tp_cd") = true;
	}
}