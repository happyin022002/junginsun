/*
=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : Weekly Sales Report By Office 1
'프로그램 ID  : ESM_COA_0070.js
'프로그램 명  : Weekly Sales Report By Office 1
'프로그램개요 : Weekly Sales Report By Office 1
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.11.27
 * =========================================================
 * History
 * 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
 *                Year, Month, Week관련 화면변경에 따른 Script변경
 * 2008.02.26 PEJ N200802220016 COA 조회 기간 관련 수정 요청
 *                2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
 * 2008.03.07 PEJ N200802260011 STP Income 화면 수정 요청 
 *                화면에 Income/Cost 각각을 선택적으로 볼수 있는 옵션 추가 및 VVD 항차별로 조회할수 있도록 검색조건추가를 위해 
 *                데이터를 추가적으로 넘겨주기 위해서 소스 변경
 * 2008.03.21 PEJ R200803125390 P/L 화면 보완 요청_1,2번항목  
 *                Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
 * 2008.04.07 PEJ N200804020018 COA Report 수정 요청  
 *                1. Inquiry by Customized Condition
 *                 - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
 *                    (첨부파일 참조)　
 *                 - 화면 하단에 아래 메세지 수정 및 추가
 *                    ▶ Please reset the report form - in the event that an error occurs.
 *                    ▶ If you want to check all costs related to the booking, please include 
 *                        the BKG number when retrieving the data and double click it.
 *                2. Office Report vs QTA
 *                 - 기간 표시 (타화면 참조)
 *                3. Inquiry by BKG
 *                 - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망
 * 2008.06.10 PEJ N200805307020 Split 01-COA_화면 개발 및 수정 
 * 2008.10.20 전윤주 N200810200014 Office Report vs QTA에서 엑셀 다운로드시 상위 Grid만 다운로드
 * 2008.11.14 박상희 N200811140011 Office Report vs QTA 내 STP 및 Branch CM/OP 관련컬럼 Null 처리
 * 2008.11.20 전윤주 N200811060003 COA_Report 기능 개선(2)Week Display 추가
 * 2008.12.15 박상희 N200811270017 COA_Office Report vs QTA 내 STP 관련 소스 수정
 * 2008.12.16 박상희 N200811270017 BKG OPB 의 SUM 계산수식 수정
 * 2009.01.12 박상희 N200901070020 5주까지만 데이터 조회가 가능하도록 수정
 * 2009.02.03 박상희 N200901210013 Office구조 변경 관련 적용
 * 2009.02.12 박상희 N200902050040 Reefer PFMC & QTA만 조회하는 Option 추가
 * 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
 * 2009.09.29 김기식 Alps전환작업 
 * 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
 * 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
 * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
 * 2011.05.11 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
 * 2011.06.22 이행지 [CHM-201111643-01][COA]달성율(%) 산출 로직 변경_Office Report vs QTA - OP 컬럼 소계식 수정
 * 2011.09.22 전윤주 [CHM-201113484-01] getComboObjValue로 변환되지 않아서 sheet 깨짐 현상 발생 부분 수정
 *                 컬럼 계산 식 중 분모가 0 이되는 부분에 예외처리 에러 있어 수정
 * 2012.04.24 이석준 [CHM-201217454] Office report vs QTA 메뉴의 Special 적용 대상 변경
 * 2012.12.18 최윤성 [CHM-201222075-01] [COA] Account별 QTA 조회 기능 추가
 * 2013.01.10 최윤성 [CHM-201322438-01] [COA] Office Report-vs QTA 화면에서 엑셀 다운 시 G.customer 컬럼 hidden 기능 보완
 * 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
 * 2013.03.15 서미진 [CHM-201323234] 조회 가능 주차를 최대 15주까지 확장
 * 2013.06.03 성미영 [CHM-201324894] Split 01-[COA] COA Report내 "IAS Region " / "Bound2" 추가 
 * 2013.06.24 성미영 [CHM-201325332] [COA] 본사 조직 변경 관련 COA 변경 사항
 * 2013.07.10 성미영 [CHM-201325516] Split 01-[COA] Customer Segmentation 관련 변경사항 MDM DB 변경 
 * 2014.06.10 최성민 [CHM-201430587] [COA] Office Report vs QTA 옵션 변경
 * 2014.06.19 최덕우 [CHM-201430667] [COA] Office Report vs QTA내 "Main / Sector" 컬럼 추가 요청
 * 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
 * =========================================================  */



/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends  
 * @class ESM_COA_0070 : ESM_COA_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0070() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.reInitSheet = reInitSheet;
	this.initTab = initTab;
	this.setSheetObject = setSheetObject;
	this.setTabObject = setTabObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet3_OnSearchEnd = sheet3_OnSearchEnd;
	this.sheet4_OnSearchEnd = sheet4_OnSearchEnd;
	this.tab1_OnChange = tab1_OnChange;
	this.toggle_prev = toggle_prev;
	this.toggle_next = toggle_next;
	this.InvOnChange = InvOnChange;
	this.chgHeader = chgHeader;
	//this.viewSheet = viewSheet;
	this.viewOffice = viewOffice;
	this.viewBound = viewBound;
	this.clearDatePeriod = clearDatePeriod;
	this.chgOfficeLevel = chgOfficeLevel;
	this.chgOffice = chgOffice;
	this.f_trd_cd_OnChange = f_trd_cd_OnChange;
	this.setPeriod1 = setPeriod1;
	this.setPeriod = setPeriod;
	this.openSTPIncome = openSTPIncome;
	this.changeCostYrmon = changeCostYrmon;
	this.doActionIBSheet = doActionIBSheet;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.chkValidSearch = chkValidSearch;
	this.validateForm = validateForm;
	this.ShipperPopUp = ShipperPopUp;
	this.comPopupLoc = comPopupLoc;
	this.f_key_acct_group_cd_OnChange = f_key_acct_group_cd_OnChange;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNo = 1;
var baseHeight = 11;

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var TmrID;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var fYear = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        var sheetObject5 = sheetObjects[4];
        var sheetObject6 = sheetObjects[5];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
                    toggle_next(sheetObject1,div_sheet1,div_toggle_prev1,div_toggle_next1);
                    toggle_next(sheetObject2,div_sheet2,div_toggle_prev2,div_toggle_next2);
                    toggle_next(sheetObject3,div_sheet3,div_toggle_prev3,div_toggle_next3);
                    toggle_next(sheetObject4,div_sheet4,div_toggle_prev4,div_toggle_next4);
                    toggle_next(sheetObject5,div_sheet5,div_toggle_prev5,div_toggle_next5);
                    toggle_next(sheetObject6,div_sheet6,div_toggle_prev6,div_toggle_next6);
//                    document.getElementById("div_title").innerHTML = "<div id='div_title'> - VS Pre. Week</div>";
//                    document.getElementById("div_title2").innerHTML = "<div id='div_title2'> - VS QTA</div>";
                    
                    
    				if(tabObjects[0].SelectedIndex==0){
                       doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				}else if(tabObjects[0].SelectedIndex==1){
    					if(formObject.f_year.value<2014){
    						doActionIBSheet2(sheetObject5,formObject,SEARCH02);
    					}else{
    						doActionIBSheet2(sheetObject3,formObject,IBSEARCH);
    					}
    				}
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    break;
                    

                case "btn_downexcel2":
                    doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
                    break;


                case "btn_new":
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
                    sheetObject3.RemoveAll();
                    sheetObject4.RemoveAll();
                    sheetObject5.RemoveAll();
                    sheetObject6.RemoveAll();
                    formObject.reset();
                    break;

                case "bu_next1":
                    toggle_next(sheetObject1,div_sheet1,div_toggle_prev1,div_toggle_next1);
                    break;

                case "bu_next2":
                    toggle_next(sheetObject2,div_sheet2,div_toggle_prev2,div_toggle_next2);
                    break;

                case "bu_next3":
                    toggle_next(sheetObject3,div_sheet3,div_toggle_prev3,div_toggle_next3);
                    break;

                case "bu_next4":
                    toggle_next(sheetObject4,div_sheet4,div_toggle_prev4,div_toggle_next4);
                    break;
                    
                case "bu_next5":
                    toggle_next(sheetObject5,div_sheet5,div_toggle_prev5,div_toggle_next5);
                    break;
                    
                case "bu_next6":
                    toggle_next(sheetObject6,div_sheet6,div_toggle_prev6,div_toggle_next6);
                    break;

                case "bu_prev1": //next
                    sheetNo == 1
                    toggle_prev(sheetObject1,div_sheet1,div_toggle_prev1,div_toggle_next1);
                    break;
                case "bu_prev2": //next
                    sheetNo == 2
                    toggle_prev(sheetObject2,div_sheet2,div_toggle_prev2,div_toggle_next2);
                    break;
                case "bu_prev3": //next
                    sheetNo == 3
                    toggle_prev(sheetObject3,div_sheet3,div_toggle_prev3,div_toggle_next3);
                    break;
                case "bu_prev4": //next
                    sheetNo == 4
                    toggle_prev(sheetObject4,div_sheet4,div_toggle_prev4,div_toggle_next4);
                    break;
                    
                case "bu_prev5": //next
                    sheetNo == 5
                    toggle_prev(sheetObject5,div_sheet5,div_toggle_prev5,div_toggle_next5);
                    break;
                    
                case "bu_prev6": //next
                    sheetNo == 6
                    toggle_prev(sheetObject6,div_sheet6,div_toggle_prev6,div_toggle_next6);
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
	function loadPage() {
    	 var formObject = document.form; 
		loadingMode = true;
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);

		for (k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}

		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//viewSheet();
	
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		
		initControl();
		
	
		loadingMode = false;

		tabObjects[0].SelectedIndex = 1;
		
		formObject.f_ias_rgn_cd.Enable = false;		
	}
     /**
     * 멀티콤보 처리
     * - Tab 기본 설정
     * - 탭의 항목을 설정한다.
     */
	function initCombo(comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300;
			Index = 0;
			
			
			
			if(comboObj.id == "f_pro_vw"){
	    		Code2 = "R";
	    	} else if(comboObj.id == "f_ofc_lvl1"){
	    		Code2 = "2";
	    	}  else if(comboObj.id == "f_ofc_lvl2"){
	    		Code2 = "5";
	    	} else if(comboObj.id == "f_ofc_cd"){
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    		MaxLength = 6;
	    	} else if(comboObj.id == "f_trd_cd"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 3;
	    	} else if(comboObj.id == "f_sub_trd_cd"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 2;
	    	} else if(comboObj.id == "f_ias_rgn_cd"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 2;
	    	} else if(comboObj.id == "f_hul_bnd_cd"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 3;
	    	} else if(comboObj.id == "f_rlane_cd"){
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    		MaxLength = 5;
	    	} else if(comboObj.id == "f_skd_dir_cd"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 1;
	    	} else if (comboObj.id ==  "f_key_acct_group_cd") {
                SetColAlign("left");
                SetColWidth("300")
                Text2 = "All";
                IMEMode = 0;
                DropHeight = 200;
                Index = 0;
            } else if (comboObj.id ==  "f_ra_acct_group_cd") {		// RA(Group)
                SetColAlign("left");
                SetColWidth("300")
                Text2 = "All";
                IMEMode = 0;
                DropHeight = 200;
                Index = 0;
            } else if (comboObj.id ==  "f_ofc_team_cd") {
                SetColAlign("left");
                SetColWidth("80")
                Text2 = "All";
                IMEMode = 0;
                DropHeight = 200;
                Index = 0;
            } else if (comboObj.id ==  "f_rhq_cd") {
                SetColAlign("left");
                SetColWidth("80")
                Text2 = "All";
                IMEMode = 0;
                DropHeight = 200;
                Index = 0;
            }
		}
	} 
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var header = " | ";
        var suffix1 = "";
        var suffix2 = "";
        var perfix = "Seq.";
        var label1 = "";
        var formObj = document.form;
        var currWeek = "";
        var prevWeek = formObj.f_pre_week.value;
        var rptItem = formObj.f_rpt_item.value;
        var tCnt = 0;
        var saveNM1 = "";
        var saveNM2 = "";
        var saveCD = "";
        var tmpCD = "";
        var tmpSZ = "";
        var colSize = "";

        
		if(tabObjects[0].SelectedIndex==0){
           currWeek = formObj.f_wk.value;
		}else if(tabObjects[0].SelectedIndex==1){
           currWeek = formObj.f_fm_wk.value;
		}
		

		
        // Report Select box변경시 Header 항목이 변경된다.
        //----------------------------------------------------------------------
        if(rptItem == "1"){
            if(formObj.f_ofc_sts.checked){
                 saveNM1 = saveNM1 + "Office|Office|";
                 saveNM2 = saveNM2 + "Level1|Level2|";
                 tmpCD   = tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ   = tmpSZ   + "50|50|";
            }
            saveNM1 = saveNM1 + "Trade|";	
            saveNM2 = saveNM2 + "Trade|";
            tmpCD   = tmpCD   + "trd_cd|";
            tmpSZ   = tmpSZ   + "50|";
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_rgn_sts.checked) {
                saveNM1 = saveNM1 + "IAS Region|";
                saveNM2 = saveNM2 + "IAS Region|";
                tmpCD   = tmpCD   + "ias_rgn_cd|";
                tmpSZ   = tmpSZ   + "80|";
            }
            if(formObj.f_dir_sts.checked) {
                saveNM1 = saveNM1 + "Bound|";
                saveNM2 = saveNM2 + "Bound|";
                tmpCD   = tmpCD   + "dir_cd|";
                tmpSZ   = tmpSZ   + "50|";
            }
            if(tabObjects[0].SelectedIndex==1 & formObj.f_hul_bnd_sts.checked) {
                saveNM1 = saveNM1 + "Trade Dir.|";
                saveNM2 = saveNM2 + "Trade Dir.|";
                tmpCD   = tmpCD   + "hul_bnd_cd|";
                tmpSZ   = tmpSZ   + "70|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_secter_sts.checked) {
                saveNM1 = saveNM1 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                saveNM2 = saveNM2 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                tmpCD   = tmpCD   + "pol_cd|pod_cd|mn_sctr_flg|";
                tmpSZ   = tmpSZ   + "60|60|80|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_r_month_sts.checked) {
                saveNM1 = saveNM1 + "R.Month|";
                saveNM2 = saveNM2 + "R.Month|";
                tmpCD   = tmpCD   + "cost_yrmon|";
                tmpSZ   = tmpSZ   + "60|";
            }
            if(tabObjects[0].SelectedIndex==1 & formObj.f_wk_sts.checked) {
                saveNM1 = saveNM1 + "Week|";
                saveNM2 = saveNM2 + "Week|";
                tmpCD   = tmpCD   + "wk_sts|";
                tmpSZ   = tmpSZ   + "50|";
            }
            saveCD  = tmpCD.split("|");
            colSize = tmpSZ.split("|");
            tCnt = saveCD.length-1;
        } else if(rptItem == "2") {
            if(formObj.f_ofc_sts.checked){
                 saveNM1 = saveNM1 + "Office|Office|";
                 saveNM2 = saveNM2 + "Level1|Level2|";
                 tmpCD   = tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ   = tmpSZ   + "50|50|";
            }
            

            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_rgn_sts.checked) {
	            saveNM1 = saveNM1 + "Trade|IAS Region|Sub-Trade|";
	            saveNM2 = saveNM2 + "Trade|IAS Region|Sub-Trade|";
	            tmpCD   = tmpCD   + "trd_cd|ias_rgn_cd|sub_trd_cd|";
	            tmpSZ   = tmpSZ   + "50|80|70|";
            } else {
	            saveNM1 = saveNM1 + "Trade|Sub-Trade|";
	            saveNM2 = saveNM2 + "Trade|Sub-Trade|";
	            tmpCD   = tmpCD   + "trd_cd|sub_trd_cd|";
	            tmpSZ   = tmpSZ   + "50|70|";
            }
            
            
            
            if(formObj.f_dir_sts.checked) {
                saveNM1 = saveNM1 + "Bound|";
                saveNM2 = saveNM2 + "Bound|";
                tmpCD   = tmpCD   + "dir_cd|";
                tmpSZ   = tmpSZ   + "50|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_hul_bnd_sts.checked) {
                saveNM1 = saveNM1 + "Trade Dir.|";
                saveNM2 = saveNM2 + "Trade Dir.|";
                tmpCD   = tmpCD   + "hul_bnd_cd|";
                tmpSZ   = tmpSZ   + "70|";
            }            
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_secter_sts.checked) {
                saveNM1 = saveNM1 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                saveNM2 = saveNM2 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                tmpCD   = tmpCD   + "pol_cd|pod_cd|mn_sctr_flg|";
                tmpSZ   = tmpSZ   + "60|60|80|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_r_month_sts.checked) {
                saveNM1 = saveNM1 + "R.Month|";
                saveNM2 = saveNM2 + "R.Month|";
                tmpCD   = tmpCD   + "cost_yrmon|";
                tmpSZ   = tmpSZ   + "60|";
            }
            if(tabObjects[0].SelectedIndex==1 & formObj.f_wk_sts.checked) {
                saveNM1 = saveNM1 + "Week|";
                saveNM2 = saveNM2 + "Week|";
                tmpCD   = tmpCD   + "wk_sts|";
                tmpSZ   = tmpSZ   + "50|";
            }
            saveCD  = tmpCD.split("|");
            colSize = tmpSZ.split("|");
            tCnt = saveCD.length-1;

        } else if(rptItem == "3") {
            if(formObj.f_ofc_sts.checked){
                 saveNM1 = saveNM1 + "Office|Office|";
                 saveNM2 = saveNM2 + "Level1|Level2|";
                 tmpCD   = tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ   = tmpSZ   + "50|50|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_rgn_sts.checked) {
	            saveNM1 = saveNM1 + "Trade|IAS Region|Sub-Trade|Lane|";
	            saveNM2 = saveNM2 + "Trade|IAS Region|Sub-Trade|Lane|";
	            tmpCD   = tmpCD   + "trd_cd|ias_rgn_cd|sub_trd_cd|rlane_cd|";
	            tmpSZ   = tmpSZ   + "50|80|70|80|";
            } else {
                saveNM1 = saveNM1 + "Trade|Sub-Trade|Lane|";
                saveNM2 = saveNM2 + "Trade|Sub-Trade|Lane|";
                tmpCD   = tmpCD   + "trd_cd|sub_trd_cd|rlane_cd|";
                tmpSZ   = tmpSZ   + "50|70|80|";
            }
            
            
            if(formObj.f_dir_sts.checked) {
                saveNM1 = saveNM1 + "Bound|";
                saveNM2 = saveNM2 + "Bound|";
                tmpCD   = tmpCD   + "dir_cd|";
                tmpSZ   = tmpSZ   + "50|";
            }
            if(tabObjects[0].SelectedIndex==1 & formObj.f_hul_bnd_sts.checked) {
                saveNM1 = saveNM1 + "Trade Dir.|";
                saveNM2 = saveNM2 + "Trade Dir.|";
                tmpCD   = tmpCD   + "hul_bnd_cd|";
                tmpSZ   = tmpSZ   + "70|";
            }            
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_ias_secter_sts.checked) {
                saveNM1 = saveNM1 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                saveNM2 = saveNM2 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                tmpCD   = tmpCD   + "pol_cd|pod_cd|mn_sctr_flg|";
                tmpSZ   = tmpSZ   + "60|60|80|";
            }
            
            if(tabObjects[0].SelectedIndex==1 & formObj.f_r_month_sts.checked) {
                saveNM1 = saveNM1 + "R.Month|";
                saveNM2 = saveNM2 + "R.Month|";
                tmpCD   = tmpCD   + "cost_yrmon|";
                tmpSZ   = tmpSZ   + "60|";
            }
            if(tabObjects[0].SelectedIndex==1 & formObj.f_wk_sts.checked) {
                saveNM1 = saveNM1 + "Week|";
                saveNM2 = saveNM2 + "Week|";
                tmpCD   = tmpCD   + "cost_wk|";
                tmpSZ   = tmpSZ   + "50|";
            }
            saveCD  = tmpCD.split("|");
            colSize = tmpSZ.split("|");
            tCnt = saveCD.length-1;
        } else if(rptItem == "4") {
			if(tabObjects[0].SelectedIndex==0){
                if(formObj.f_ofc_sts.checked){
                     saveNM1 = saveNM1 + "Office|Office|";
                     saveNM2 = saveNM2 + "Level1|Level2|";
                     tmpCD   = tmpCD   + "ofc_lvl1|ofc_lvl2|";
                     tmpSZ   = tmpSZ   + "50|50|";
                }

                saveNM1 = saveNM1 + "Trade|Sub-Trade|Lane|VVD|";
                saveNM2 = saveNM2 + "Trade|Sub-Trade|Lane|VVD|";
                tmpCD   = tmpCD   + "trd_cd|sub_trd_cd|rlane_cd|vvd|";
                tmpSZ   = tmpSZ   + "50|70|80|100|";
                
                
                if(formObj.f_dir_sts.checked) {
                    saveNM1 = saveNM1 + "Bound|";
                    saveNM2 = saveNM2 + "Bound|";
                    tmpCD   = tmpCD   + "dir_cd|";
                    tmpSZ   = tmpSZ   + "50|";
                }
                saveCD  = tmpCD.split("|");
                colSize = tmpSZ.split("|");
                tCnt = saveCD.length-1;
			}else if(tabObjects[0].SelectedIndex==1){
                if(formObj.f_ofc_sts.checked){
                     saveNM1 = saveNM1 + "Office|Office|";
                     saveNM2 = saveNM2 + "Level1|Level2|";
                     tmpCD   = tmpCD   + "ofc_lvl1|ofc_lvl2|";
                     tmpSZ   = tmpSZ   + "50|50|";
                }
                
                if(formObj.f_ias_rgn_sts.checked) {
    	            
                    saveNM1 = saveNM1 + "R.Month|Week|Trade|IAS Region|Sub-Trade|Lane|VVD|";
                    saveNM2 = saveNM2 + "R.Month|Week|Trade|IAS Region|Sub-Trade|Lane|VVD|";
                    tmpCD   = tmpCD   + "cost_yrmon|cost_wk|trd_cd|ias_rgn_cd|sub_trd_cd|rlane_cd|vvd|";
                    tmpSZ   = tmpSZ   + "60|40|50|80|70|80|100|";
    	            
                } else {
                    saveNM1 = saveNM1 + "R.Month|Week|Trade|Sub-Trade|Lane|VVD|";
                    saveNM2 = saveNM2 + "R.Month|Week|Trade|Sub-Trade|Lane|VVD|";
                    tmpCD   = tmpCD   + "cost_yrmon|cost_wk|trd_cd|sub_trd_cd|rlane_cd|vvd|";
                    tmpSZ   = tmpSZ   + "60|40|50|70|80|100|";
                }                
                
                if(formObj.f_dir_sts.checked) {
                    saveNM1 = saveNM1 + "Bound|";
                    saveNM2 = saveNM2 + "Bound|";
                    tmpCD   = tmpCD   + "dir_cd|";
                    tmpSZ   = tmpSZ   + "50|";
                } 
                if(formObj.f_hul_bnd_sts.checked) {
                    saveNM1 = saveNM1 + "Trade Dir.|";
                    saveNM2 = saveNM2 + "Trade Dir.|";
                    tmpCD   = tmpCD   + "hul_bnd_cd|";
                    tmpSZ   = tmpSZ   + "70|";
                }   
                
                if(formObj.f_ias_secter_sts.checked) {
                    saveNM1 = saveNM1 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                    saveNM2 = saveNM2 + "Revenue\nPOL|Revenue\nPOD|Main/Sector|";
                    tmpCD   = tmpCD   + "pol_cd|pod_cd|mn_sctr_flg|";
                    tmpSZ   = tmpSZ   + "60|60|80|";
                }
                
                saveCD  = tmpCD.split("|");
                colSize = tmpSZ.split("|");                
                tCnt = saveCD.length-1;
			}
			
        }
        
        //----------------------------------------------------------------------
        // Week 관련 타이틀 세팅
        if(currWeek != ""){
            if(ComParseInt(currWeek.substring(1)) == 1 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))     suffix1 = "st";
            else if(ComParseInt(currWeek.substring(1)) == 2 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))suffix1 = "nd";
            else if(ComParseInt(currWeek.substring(1)) == 3 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))suffix1 = "rd";
            else suffix1 = "th";
            
            if(ComParseInt(prevWeek.substring(5)) == 1 && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))      suffix2 = "st";
            else if(ComParseInt(prevWeek.substring(5)) == 2  && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))suffix2 = "nd";
            else if(ComParseInt(prevWeek.substring(5)) == 3  && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))suffix2 = "rd";
            else suffix2 = "th";
            header = prevWeek.substring(2,4)+"/"+prevWeek.substring(4) + suffix2 +"|"+ formObj.f_year.value.substring(2)+"/"+currWeek + suffix1;
            label1 = ComParseInt(currWeek) + suffix1;
        }
        document.getElementById("div_label1").innerHTML = "<div id='div_label1'>Weekly Sales Report - <font color='#FF008F'>"+label1+"</font></div>";
        //----------------------------------------------------------------------
        
        switch(sheetNo) {
           case 1:      //sheet1 init
                with (sheetObj) {
                    var HeadTitle = "";
                    var HeadTitle1 = "";
                    var fixd_cnt = 0;
                    
                    if(getComboObjValue(formObj.f_pro_vw) == "P"){ //
                    	if (getComboObjValue(formObj.f_pro_lvl) == "M"){ //CM2일 경우.
                          HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM2 Total|CM2 Total|CM2 Total|RPB|RPB|RPB|CMB(CM2) Total|CMB(CM2) Total|CMB(CM2) Total|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ;
                    	} else {
                    	  HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM|CM|CM|RPB|RPB|RPB|CMB|CMB|CMB|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ;
                    	}
                        HeadTitle1 = saveNM2 + header+"|Change(%)|"+header+"|Change(%)|"+header+"|Change(%)|"+header+"|Change|"+header+"|Change|"+header+"|Change|"+header+"|Change|"  ;
                        fixd_cnt = 21;
                    } else {                                               
                        HeadTitle  = saveNM1 +  "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|BKG CM|BKG CM|BKG CM|" ;
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){       
                        HeadTitle  = HeadTitle +  "OTH ABC(By SVC OFC)|OTH ABC(By SVC OFC)|" +
                                                "STP REV|STP REV|Balance(by SVC OFC)|Balance(by SVC OFC)|" +
                                                "OTH ABC(CONT OFC)|OTH ABC(CONT OFC)|STP Cost|STP Cost|" +
                                                "Balance(CONT OFC)|Balance(CONT OFC)|STP Profit|STP Profit|" +
                                                "Branch CM|Branch CM|Branch CM|" ;
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OP|BKG OP|BKG OP|";
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle  = HeadTitle + "OP|OP|OP|"; //Contract&OP
                        HeadTitle  = HeadTitle + "RPB|RPB|RPB|BKG CMB|BKG CMB|BKG CMB|";
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OPB|BKG OPB|BKG OPB|";
                        HeadTitle  = HeadTitle + "BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ;
                        
                        HeadTitle1 = saveNM2 + header+"|Change(%)|"+header+"|Change(%)|"+header+"|Change(%)|";
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){ 
                        HeadTitle1 = HeadTitle1 + header+ "|"+header+"|"+header+"|"+ header+"|"+header+"|"+header+"|"+header+"|"+header+"|Change(%)|";
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + header+"|Change(%)|";
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle1 = HeadTitle1 + header+"|Change(%)|"; //Contract&OP
                        HeadTitle1 = HeadTitle1 + header+"|Change|"+header+"|Change|";
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + header+"|Change|";
                        HeadTitle1 = HeadTitle1 + header+ "|Change|" + header + "|Change|" ;
                        fixd_cnt = 21;
                        if(getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 6;
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 3;
                        if(getComboObjValue(formObj.f_ofc_vw) == "C")  fixd_cnt = fixd_cnt + 17;
//                        else fixd_cnt = 41;
                    }
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);          //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                           //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_load",      false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_load",      false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "load_chng",      false,      "",         dfFloatOrg,      2,      true,       true);
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_rev",       false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_rev",       false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "rev_chng",       false,      "",         dfFloatOrg,      2,      true,       true);
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_cm",        false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_cm",        false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "cm_chng",        false,      "",         dfFloatOrg,      2,      true,       true);
                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){ //Contract
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_oth_abc_svc",  false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_oth_abc_svc",  false,      "",         dfFloatOrg,      0,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_stp_rev",   false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_stp_rev",   false,      "",         dfFloatOrg,      0,      true,       true);

                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_balance_svc",  false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_balance_svc",  false,      "",         dfFloatOrg,      0,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_oth_abc_cont", false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_oth_abc_cont", false,      "",         dfFloatOrg,      0,      true,       true);
                        
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_stp_cost",  false,      "",         dfFloatOrg,      0,      true,       true);//|prev_cm|+|prev_stp_net|
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_stp_cost",  false,      "",         dfFloatOrg,      0,      true,       true);//|curr_cm|+|curr_stp_net|
                            
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_balance_cont",  false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_balance_cont",  false,      "",         dfFloatOrg,      0,      true,       true);
                        
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_stp_profit",   false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_stp_profit",   false,      "",         dfFloatOrg,      0,      true,       true);
                        
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_branchCM",  false,      "",         dfFloatOrg,      0,      true,       true);//|prev_cm|+|prev_stp_net|
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_branchCM",  false,      "",         dfFloatOrg,      0,      true,       true);//|curr_cm|+|curr_stp_net|
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "branchCM_chng",  false,      "",         dfFloatOrg,      0,      true,       true);//|curr_cm|+|curr_stp_net|
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O") {
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_bkg_op",   false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_bkg_op",   false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "bkg_op_chng",   false,      "",         dfFloatOrg,      2,      true,       true);
                        }
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O"){
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_op",   false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_op",   false,      "",         dfFloatOrg,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "op_chng",   false,      "",         dfFloatOrg,      0,      true,       true);
                        }
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_rpb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_rpb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "rpb_chng",       false,      "",         dfFloatOrg,      2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_cmb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_cmb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "cmb_chng",       false,      "",         dfFloatOrg,      2,      true,       true);
                        if(getComboObjValue(formObj.f_pro_lvl) == "O"){
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_opb",   false,      "|prev_bkg_op|/|prev_load|",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_opb",   false,      "|curr_bkg_op|/|curr_load|",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "opb_chng",   false,      "IF(|prev_opb|>0, (|curr_opb|/|prev_opb|-1)*100, 0)",         dfFloatOrg,      2,      true,       true);
                        }
                            
                    } else {
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_rpb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_rpb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "rpb_chng",       false,      "",         dfFloatOrg,      2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_cmb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_cmb",       false,      "",         dfFloatOrg,      2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "cmb_chng",       false,      "",         dfFloatOrg,      2,      true,       true);
                    }                    

                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_bsa_capa",  false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_bsa_capa",  false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "bsa_capa_chng",  false,      "",         dfFloatOrg,      2,      true,       true);

                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "prev_lf",  false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      100, daRight,            false,      "curr_lf",  false,      "",         dfFloatOrg,      2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    100, daRight,            false,      "lf_chng",  false,      "",         dfFloatOrg,      2,      true,       true);

                    ImageList(0) = "/hanjin/img/button/btns_positivechange.gif";
                    ImageList(1) = "/hanjin/img/button/btns_negativechange.gif";

                    InitDataImage(0, "load_chng", daLeft);
                    InitDataImage(0, "rev_chng", daLeft);
                    InitDataImage(0, "cm_chng", daLeft);
                    InitDataImage(0, "rpb_chng", daLeft);
                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit
                        InitDataImage(0, "stp_income_chng", daLeft);
                        InitDataImage(0, "stp_net_chng", daLeft);
                    }
                    
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(baseHeight) ;
                    viewBound();
                    viewOffice();
                }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
                    var fixd_cnt = 0;
                    SheetWidth = mainTable.clientWidth;                                 //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);   //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                          //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                                   //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                        fixd_cnt = 15;
                    } else {
                        fixd_cnt = 12;
                    }
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);                                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);              // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = saveNM1 + "REV Increase/Decrease|REV Increase/Decrease|REV Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Load Share(%)|Load Share(%)|Load Share(%)|BKG CM Share(%)|BKG CM Share(%)|BKG CM Share(%)" ;
                    var HeadTitle1 = saveNM2 + "by Load|by RPB|Change|by Load|by CPB|Change|"+header+"|Change|"+header+"|Change" ;
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                        HeadTitle  = HeadTitle  + "|BKG OP Share(%)|BKG OP Share(%)|BKG OP Share(%)";
                        HeadTitle1 = HeadTitle1 + "|"+ header+"|Change";
                        
                    }
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "by_load_grev",   false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "by_rpb_grev",    false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "",               false,      "|by_load_grev|+|by_rpb_grev|",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "by_load_cost",   false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "by_cpb_cost",    false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "",               false,      "|by_load_cost|+|by_cpb_cost|",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "prev_load_share",false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "curr_load_share",false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "load_share",     false,      "|curr_load_share|-|prev_load_share|",dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "prev_cm_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "curr_cm_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "cm_share",       false,      "|curr_cm_share|-|prev_cm_share|",    dfFloatOrg,  2,  true,       true);
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "prev_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "curr_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "op_share",       false,      "|curr_op_share|-|prev_op_share|",    dfFloatOrg,  2,  true,       true);
                    }

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(baseHeight) ;
                }
                break;
            case 3:      //sheet3 init
                with (sheetObj) {
                    var HeadTitle = "";
                    var HeadTitle1 = "";
                    var fixd_cnt = 0;
                	
                    if(formObj.f_view_cust.value == "Y" && formObj.f_gcust_sts.checked){
                		saveNM1  = saveNM1 + "G.Customer|G.Customer|";
                		saveNM2  = saveNM2 + "Code|Name|";
                    	fixd_cnt = fixd_cnt + 2;
                	}
                    
                    if(getComboObjValue(formObj.f_pro_vw) == "P"){
                    	HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM|CM|CM|RPB|RPB|RPB|CMB|CMB|CMB|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ; //23
                        HeadTitle1 = saveNM2 + "Load QTA|Load PFMC|Load Change(%)|F.Rev QTA|F.Rev PFMC|F.Rev Change(%)|CM QTA|CM PFMC|CM Change(%)|RPB QTA|RPB PFMC|RPB Change|CMB QTA|CMB PFMC|CMB Change|BSA Capa QTA|BSA Capa PFMC|BSA Capa Change|L/F(%) QTA|L/F(%) PFMC|L/F(%) Change(%) " ;//23
                        fixd_cnt = fixd_cnt + 21;
                    } else if (getComboObjValue(formObj.f_pro_vw) == "R"){
                    	HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|BKG CM|BKG CM|BKG CM|"; //11
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){ SAQ->SQM   
//                              HeadTitle  = HeadTitle + "OTH ABC\n(By SVC OFC)|STP REV|Balance\n(by SVC OFC)|OTH ABC\n(CONT OFC)|STP Cost|Balance\n(CONT OFC)|STP Profit|Branch CM|Branch CM|"; //9
//                        }
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OP|BKG OP|BKG OP|"; //3 SAQ->SQM
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle  = HeadTitle + "OP|OP|"; //2
                        HeadTitle  = HeadTitle + "RPB|RPB|RPB|BKG CMB|BKG CMB|BKG CMB|"; //6
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OPB|BKG OPB|BKG OPB|"; //3 SAQ->SQM
                        HeadTitle  = HeadTitle + "BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ; //6
                        
                        HeadTitle1 = saveNM2 + "Load QTA|Load PFMC|Load Change(%)|F.Rev QTA|F.Rev PFMC|F.Rev Change(%)|BKG CM QTA|BKG CM PFMC|BKG CM Change(%)|"; //11
                        
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){ SAQ->SQM   
//                            HeadTitle1 = HeadTitle1 + "OTH ABC\n(By SVC OFC) PFMC|STP REV PFMC|Balance\n(by SVC OFC) PFMC|OTH ABC\n(CONT OFC) PFMC|STP Cost PFMC|Balance\n(CONT OFC) PFMC|STP Profit PFMC|Branch CM PFMC|Branch CM Change(%)|";//9
//                        }
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + "BKG OP QTA|BKG OP PFMC|BKG OP Change(%)|"; //3 SAQ->SQM
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle1 = HeadTitle1 + "OP PFMC|OP Change(%)|"; //2
                        HeadTitle1 = HeadTitle1 + "RPB QTA|RPB PFMC|RPB Change|BKG CMB QTA|BKG CMB PFMC|BKG CMB Change|"; //6
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + "BKG OPB QTA|BKG OPB PFMC|BKG OPB Change|"; //3 SAQ->SQM
                        HeadTitle1 = HeadTitle1 +"BSA Capa QTA|BSA Capa PFMC|BSA Capa Change|L/F(%) QTA|L/F(%) PFMC|L/F(%) Change(%) " ; //6
                        
                        fixd_cnt = fixd_cnt + 21; //9 6 2
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C")  fixd_cnt = fixd_cnt + 9; SAQ->SQM
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 3; SAQ->SQM
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 2; SAQ->SQM
//                        else fixd_cnt = 30;
                    }
                    
                    
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);  //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                           //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    
                    if(formObj.f_view_cust.value == "Y" && formObj.f_gcust_sts.checked){
                    	InitDataProperty(0, cnt++,  dtData,       120,     daCenter,   false,      "cust_id",      false,      "",     dfNone,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtData,       120,     daLeft,     false,      "cust_nm",      false,      "",     dfNone,      0,      true,       true);
                    }
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_load",     false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_load",     false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "load_chng",    false,      "",     dfFloatOrg,  2,      true,       true);

                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rev",      false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rev",      false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rev_chng",     false,      "",     dfFloatOrg,  2,      true,       true);

                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cm",       false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cm",       false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cm_chng",      false,      "",     dfFloatOrg,  2,      true,       true);

                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_stp",      false,      "",     dfNullInteger,       0,      true,       true);
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_stp_net",  false,      "",     dfNullInteger,       0,      true,       true);
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_branchCM", false,      "",     dfNullInteger,       0,      true,       true);
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){//Contract  SAQ->SQM
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "oth_abc_svc",        false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_rev",            false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "balance_svc",        false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "oth_abc_cont",       false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_cost",           false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "balance_cont",       false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_profit",         false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_branchCM",       false,      "",     dfFloatOrg,       2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtImageText,    135,     daRight,    false,      "coa_branch_chng",    false,      "",     dfFloatOrg,       2,      true,       true);
//                        }
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O"){ //BKG OP SAQ->SQM
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_bkg_op",   false,      "",     dfFloatOrg,  2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_bkg_op",   false,      "",     dfFloatOrg,  2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "op_chng",      false,      "",     dfFloatOrg, 2,      true,       true);
//                        }
//                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //OP SAQ->SQM
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_op",            false,      "",         dfFloatOrg,  2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "coa_op_chng",       false,      "",         dfFloatOrg,  2,      true,       true);
//                        }
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rpb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cmb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
                        
//                        if(getComboObjValue(formObj.f_pro_lvl) == "O"){ //OPB
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_opb",      false,      "",     dfFloatOrg,  2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_opb",      false,      "",     dfFloatOrg,  2,      true,       true);
//                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "opb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
//                        }
                    } else {
                        
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rpb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cmb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
                    }
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_bsa_capa",  false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_bsa_capa",  false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "bsa_capa_chng", false,      "",    dfFloatOrg, 2,      true,       true);
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_lf",   false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_lf",   false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "lf_chng",  false,      "",    dfFloatOrg, 2,      true,       true);

                    ImageList(0) = "/hanjin/img/button/btns_positivechange.gif";
                    ImageList(1) = "/hanjin/img/button/btns_negativechange.gif";
                    InitDataImage(0, "load_chng", daLeft);
                    InitDataImage(0, "rev_chng", daLeft);
                    InitDataImage(0, "cm_chng", daLeft);
                    InitDataImage(0, "rpb_chng", daLeft);
//                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit SAQ->SQM
//                    InitDataImage(0, "stp_chng", daLeft);
//                    InitDataImage(0, "stp_net_chng", daLeft);
//                    }
                    
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(baseHeight) ;
                }
                break;
            case 4:      //sheet4 init
                with (sheetObj) {
                    var fixd_cnt = 0;
                    SheetWidth = mainTable.clientWidth;                                 //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);   //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                          //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                                   //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
//                        fixd_cnt = 15;
//                    } else {
                        fixd_cnt = 12;
//                    }
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);                                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);              // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = saveNM1 + "REV Increase/Decrease|REV Increase/Decrease|REV Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Load Share(%)|Load Share(%)|Load Share(%)|BKG CM Share(%)|BKG CM Share(%)|BKG CM Share(%)" ;
                    var HeadTitle1 = saveNM2 + "by Load|by RPB|Change|by Load|by CPB|Change|QTA|PFMC|Change|QTA|PFMC|Change" ;
//                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
//                        HeadTitle  = HeadTitle  + "|BKG OP Share(%)|BKG OP Share(%)|BKG OP Share(%)";
//                        HeadTitle1 = HeadTitle1 + "|QTA|PFMC|Change";
//                        
//                    }
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_load_grev",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_rpb_grev",   false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "",              false,      "|by_load_grev|+|by_rpb_grev|",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_load_cost",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_cpb_cost",   false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "",              false,      "|by_load_cost|+|by_cpb_cost|",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "qta_load_share",false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "coa_load_share",false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "load_share",    false,      "|coa_load_share|-|qta_load_share|",dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "qta_cm_share",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "coa_cm_share",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "cm_share",      false,      "|coa_cm_share|-|qta_cm_share|",    dfFloatOrg,  2,      true,       true);
//                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
//                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "qta_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
//                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "coa_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
//                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "op_share",       false,      "|coa_op_share|-|qta_op_share|",    dfFloatOrg,  2,  true,       true);
//                    }
                    style.height = GetSheetHeight(baseHeight) ;
                }
                break;
                
            case 5:      //sheet5 init
                with (sheetObj) {
                    var HeadTitle = "";
                    var HeadTitle1 = "";
                    var fixd_cnt = 0;
                	
                    if(formObj.f_view_cust.value == "Y" && formObj.f_gcust_sts.checked){
                		saveNM1  = saveNM1 + "G.Customer|G.Customer|";
                		saveNM2  = saveNM2 + "Code|Name|";
                    	fixd_cnt = fixd_cnt + 2;
                	}
                    
                    if(getComboObjValue(formObj.f_pro_vw) == "P"){
                    	HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM|CM|CM|RPB|RPB|RPB|CMB|CMB|CMB|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ; //23
                        HeadTitle1 = saveNM2 + "Load QTA|Load PFMC|Load Change(%)|F.Rev QTA|F.Rev PFMC|F.Rev Change(%)|CM QTA|CM PFMC|CM Change(%)|RPB QTA|RPB PFMC|RPB Change|CMB QTA|CMB PFMC|CMB Change|BSA Capa QTA|BSA Capa PFMC|BSA Capa Change|L/F(%) QTA|L/F(%) PFMC|L/F(%) Change(%) " ;//23
                        fixd_cnt = fixd_cnt + 21;
                    } else if (getComboObjValue(formObj.f_pro_vw) == "R"){
                    	HeadTitle  = saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|BKG CM|BKG CM|BKG CM|"; //11
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){   
                              HeadTitle  = HeadTitle + "OTH ABC\n(By SVC OFC)|STP REV|Balance\n(by SVC OFC)|OTH ABC\n(CONT OFC)|STP Cost|Balance\n(CONT OFC)|STP Profit|Branch CM|Branch CM|"; //9
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OP|BKG OP|BKG OP|"; //3
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle  = HeadTitle + "OP|OP|"; //2
                        HeadTitle  = HeadTitle + "RPB|RPB|RPB|BKG CMB|BKG CMB|BKG CMB|"; //6
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle  = HeadTitle + "BKG OPB|BKG OPB|BKG OPB|"; //3
                        HeadTitle  = HeadTitle + "BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ; //6
                        
                        HeadTitle1 = saveNM2 + "Load QTA|Load PFMC|Load Change(%)|F.Rev QTA|F.Rev PFMC|F.Rev Change(%)|BKG CM QTA|BKG CM PFMC|BKG CM Change(%)|"; //11
                        
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){   
                            HeadTitle1 = HeadTitle1 + "OTH ABC\n(By SVC OFC) PFMC|STP REV PFMC|Balance\n(by SVC OFC) PFMC|OTH ABC\n(CONT OFC) PFMC|STP Cost PFMC|Balance\n(CONT OFC) PFMC|STP Profit PFMC|Branch CM PFMC|Branch CM Change(%)|";//9
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + "BKG OP QTA|BKG OP PFMC|BKG OP Change(%)|"; //3
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") HeadTitle1 = HeadTitle1 + "OP PFMC|OP Change(%)|"; //2
                        HeadTitle1 = HeadTitle1 + "RPB QTA|RPB PFMC|RPB Change|BKG CMB QTA|BKG CMB PFMC|BKG CMB Change|"; //6
                        if(getComboObjValue(formObj.f_pro_lvl) == "O")HeadTitle1 = HeadTitle1 + "BKG OPB QTA|BKG OPB PFMC|BKG OPB Change|"; //3
                        HeadTitle1 = HeadTitle1 +"BSA Capa QTA|BSA Capa PFMC|BSA Capa Change|L/F(%) QTA|L/F(%) PFMC|L/F(%) Change(%) " ; //6
                        
                        fixd_cnt = fixd_cnt + 21; //9 6 2
                        if(getComboObjValue(formObj.f_ofc_vw) == "C")  fixd_cnt = fixd_cnt + 9;
                        if(getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 6;
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O") fixd_cnt = fixd_cnt + 2;
//                        else fixd_cnt = 30;
                    }
                    
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);  //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                           //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    
                    if(formObj.f_view_cust.value == "Y" && formObj.f_gcust_sts.checked){
                    	InitDataProperty(0, cnt++,  dtData,       120,     daCenter,   false,      "cust_id",      false,      "",     dfNone,      0,      true,       true);
                        InitDataProperty(0, cnt++,  dtData,       120,     daLeft,     false,      "cust_nm",      false,      "",     dfNone,      0,      true,       true);
                    }
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_load",     false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_load",     false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "load_chng",    false,      "",     dfFloatOrg,  2,      true,       true);

                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rev",      false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rev",      false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rev_chng",     false,      "",     dfFloatOrg,  2,      true,       true);

                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cm",       false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cm",       false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cm_chng",      false,      "",     dfFloatOrg,  2,      true,       true);

                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_stp",      false,      "",     dfNullInteger,       0,      true,       true);
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_stp_net",  false,      "",     dfNullInteger,       0,      true,       true);
//                        InitDataProperty(0, cnt++,  dtData,      100,     daRight,    false,      "coa_branchCM", false,      "",     dfNullInteger,       0,      true,       true);
                        if(getComboObjValue(formObj.f_ofc_vw) == "C"){//Contract
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "oth_abc_svc",        false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_rev",            false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "balance_svc",        false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "oth_abc_cont",       false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_cost",           false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "balance_cont",       false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "stp_profit",         false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_branchCM",       false,      "",     dfFloatOrg,       2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    135,     daRight,    false,      "coa_branch_chng",    false,      "",     dfFloatOrg,       2,      true,       true);
                        }
                        if(getComboObjValue(formObj.f_pro_lvl) == "O"){ //BKG OP
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_bkg_op",   false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_bkg_op",   false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "op_chng",      false,      "",     dfFloatOrg, 2,      true,       true);
                        }
                        if(getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //OP
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_op",            false,      "",         dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "coa_op_chng",       false,      "",         dfFloatOrg,  2,      true,       true);
                        }
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rpb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cmb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
                        
                        if(getComboObjValue(formObj.f_pro_lvl) == "O"){ //OPB
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_opb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_opb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "opb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
                        }
                    } else {
                        
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_rpb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "rpb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
    
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_cmb",      false,      "",     dfFloatOrg,  2,      true,       true);
                        InitDataProperty(0, cnt++,  dtImageText,    120,     daRight,    false,      "cmb_chng",     false,      "",     dfFloatOrg,  2,      true,       true);
                    }
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_bsa_capa",  false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_bsa_capa",  false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "bsa_capa_chng", false,      "",    dfFloatOrg, 2,      true,       true);
                    
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "qta_lf",   false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "coa_lf",   false,      "",    dfFloatOrg, 2,      true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      120,     daRight,    false,      "lf_chng",  false,      "",    dfFloatOrg, 2,      true,       true);

                    ImageList(0) = "/hanjin/img/button/btns_positivechange.gif";
                    ImageList(1) = "/hanjin/img/button/btns_negativechange.gif";
                    InitDataImage(0, "load_chng", daLeft);
                    InitDataImage(0, "rev_chng", daLeft);
                    InitDataImage(0, "cm_chng", daLeft);
                    InitDataImage(0, "rpb_chng", daLeft);
                    if(getComboObjValue(formObj.f_pro_vw) == "R"){ //Office Profit
                    InitDataImage(0, "stp_chng", daLeft);
                    InitDataImage(0, "stp_net_chng", daLeft);
                    }
                    
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(baseHeight) ;
                }
                break;
            case 6:      //sheet6 init
                with (sheetObj) {
                    var fixd_cnt = 0;
                    SheetWidth = mainTable.clientWidth;                                 //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);   //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                          //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                                   //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                        fixd_cnt = 15;
                    } else {
                        fixd_cnt = 12;
                    }
                    InitColumnInfo(fixd_cnt + tCnt, tCnt, 0, true);                                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);              // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = saveNM1 + "REV Increase/Decrease|REV Increase/Decrease|REV Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Load Share(%)|Load Share(%)|Load Share(%)|BKG CM Share(%)|BKG CM Share(%)|BKG CM Share(%)" ;
                    var HeadTitle1 = saveNM2 + "by Load|by RPB|Change|by Load|by CPB|Change|QTA|PFMC|Change|QTA|PFMC|Change" ;
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                        HeadTitle  = HeadTitle  + "|BKG OP Share(%)|BKG OP Share(%)|BKG OP Share(%)";
                        HeadTitle1 = HeadTitle1 + "|QTA|PFMC|Change";
                        
                    }
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    for(j=0; j<tCnt; j++){
                    InitDataProperty(0, cnt++,  dtData,         colSize[j], daCenter,            true,       saveCD[j],         false,      "",         dfNone,       0,      true,       true);
                    }
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_load_grev",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_rpb_grev",   false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "",              false,      "|by_load_grev|+|by_rpb_grev|",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_load_cost",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "by_cpb_cost",   false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "",              false,      "|by_load_cost|+|by_cpb_cost|",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "qta_load_share",false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "coa_load_share",false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "load_share",    false,      "|coa_load_share|-|qta_load_share|",dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "qta_cm_share",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "coa_cm_share",  false,      "",     dfFloatOrg,  2,      true,       true);
                    InitDataProperty(0, cnt++,      dtAutoSum,      90, daRight,    false,  "cm_share",      false,      "|coa_cm_share|-|qta_cm_share|",    dfFloatOrg,  2,      true,       true);
                    if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "qta_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "coa_op_share",  false,      "",     dfFloatOrg,  2,  true,       true);
                    InitDataProperty(0, cnt++,  dtAutoSum,      90, daRight,    false,      "op_share",       false,      "|coa_op_share|-|qta_op_share|",    dfFloatOrg,  2,  true,       true);
                    }
                    style.height = GetSheetHeight(baseHeight) ;
                }
                break;    
        }
       
    }

    /**
     * sheet의 데이터를 로드한다.
     */
    function reInitSheet(sheetObj, sheetNo, loadXml){
        try{
            // sheet 초기화
            sheetObj.Redraw = false;
            sheetObj.Visible = false;
            sheetObj.RemoveAll();
            sheetObj.Reset();
            ComConfigSheet(sheetObj);
            initSheet(sheetObj, sheetNo);
            ComEndConfigSheet(sheetObj);
            sheetObj.Visible = true;
            sheetObj.Redraw = true;

        }catch(e){
            ComShowMessage("\n function name : reInitSheet"
                + "\n message       : " + e.message
                + "\n name          : " + e.name
                + "\n number        : " + e.number
                + "\n filename      : " + e.filename
                + "\n linenumber    : " + e.linenumber +"\n");
        }
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++, "   VS Pre Week   " , -1 );
                    InsertTab( cnt++, "     VS QTA      " , -1 );
                }
             break;
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;

    }
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * sheet1조회 후 로직 처리 : total 값을 재계산하여 입력한다.
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        var sheetObj3 = sheetObjects[2];
        var formObj = document.form;

        if(eval(sheetObj.SumValue(0, "prev_load")) > 0){
            sheetObj.SumValue(0, "load_chng") = eval("((" + sheetObj.SumValue(0,"curr_load")+ "/" + sheetObj.SumValue(0, "prev_load") + ")-1)*100").toFixed(2);
            sheetObj.SumValue(0, "prev_rpb") = eval("(" + sheetObj.SumValue(0,"prev_rev")+ "/" + sheetObj.SumValue(0, "prev_load") + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "load_chng") = "0";
            sheetObj.SumValue(0, "prev_rpb") = "0";
        }
        if(eval(sheetObj.SumValue(0, "prev_rev")) > 0){
            sheetObj.SumValue(0, "rev_chng") = eval("((" + sheetObj.SumValue(0,"curr_rev")+ "/" + sheetObj.SumValue(0, "prev_rev") + ")-1)*100").toFixed(2);
        } else {
            sheetObj.SumValue(0, "rev_chng") = "0";
        }
        
        if(getComboObjValue(formObj.f_pro_vw) == "R"){
//            if(eval(sheetObj.SumValue(0, "prev_stp_income")) > 0){
//                sheetObj.SumValue(0, "stp_income_chng") = eval("((" + sheetObj.SumValue(0,"curr_stp_income")+ "/" + sheetObj.SumValue(0, "prev_stp_income") + ")-1)*100").toFixed(2);
//            } else {
//                sheetObj.SumValue(0, "stp_income_chng") = "0";
//            }
    
            
//            if(eval(sheetObj.SumValue(0, "prev_stp_net")) > 0){
//                sheetObj.SumValue(0, "stp_net_chng") = eval("((" + sheetObj.SumValue(0,"curr_stp_net")+ "/" + sheetObj.SumValue(0, "prev_stp_net") + ")-1)*100").toFixed(2);
//            } else {
//                sheetObj.SumValue(0, "stp_net_chng") = "0";
//            }
            
            if(eval(sheetObj.SumValue(0, "prev_branchCM")) > 0){
                sheetObj.SumValue(0, "branchCM_chng") = eval("((" + sheetObj.SumValue(0,"curr_branchCM")+ "/" + sheetObj.SumValue(0, "prev_branchCM") + ")-1)*100").toFixed(2);
            } else {
                sheetObj.SumValue(0, "branchCM_chng") = "0";
            }
            if(getComboObjValue(formObj.f_pro_lvl) == "O"){
                if(eval(sheetObj.SumValue(0, "prev_bkg_op")) > 0){
                    sheetObj.SumValue(0, "bkg_op_chng") = eval("((" + sheetObj.SumValue(0,"curr_bkg_op")+ "/" + sheetObj.SumValue(0, "prev_bkg_op") + ")-1)*100").toFixed(2);
                } else {
                    sheetObj.SumValue(0, "bkg_op_chng") = "0";
                }
                if(eval(sheetObj.SumValue(0, "prev_op")) > 0){
                    sheetObj.SumValue(0, "op_chng") = eval("((" + sheetObj.SumValue(0,"curr_op")+ "/" + sheetObj.SumValue(0, "prev_op") + ")-1)*100").toFixed(2);
                } else {
                    sheetObj.SumValue(0, "op_chng") = "0";
                }
                
                if(eval(sheetObj.SumValue(0, "prev_load")) > 0){
                    sheetObj.SumValue(0, "prev_opb") = eval("(" + sheetObj.SumValue(0,"prev_op")+ "/" + sheetObj.SumValue(0, "prev_load") + ")").toFixed(2);
                } else {
                    sheetObj.SumValue(0, "prev_opb") = "0";
                }              
                if(eval(sheetObj.SumValue(0, "curr_load")) > 0){
                    sheetObj.SumValue(0, "curr_opb") = eval("(" + sheetObj.SumValue(0,"curr_op")+ "/" + sheetObj.SumValue(0, "curr_load") + ")").toFixed(2);
                } else {
                    sheetObj.SumValue(0, "curr_opb") = "0";
                }              
                
                
                sheetObj.SumValue(0, "opb_chng") = eval(sheetObj.SumValue(0,"curr_opb")+ " - " + sheetObj.SumValue(0, "prev_opb"));
            }
        }

        if(eval(sheetObj.SumValue(0, "prev_cm")) > 0){
            sheetObj.SumValue(0, "cm_chng") = eval("((" + sheetObj.SumValue(0,"curr_cm")+ "/" + sheetObj.SumValue(0, "prev_cm") + ")-1)*100").toFixed(2);
        } else {
            sheetObj.SumValue(0, "cm_chng") = "0";
        }

        if(eval(sheetObj.SumValue(0, "curr_load")) > 0){
            sheetObj.SumValue(0, "curr_rpb") = eval("(" + sheetObj.SumValue(0,"curr_rev")+ "/" + sheetObj.SumValue(0, "curr_load") + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "curr_rpb") = "0";
        }        
        sheetObj.SumValue(0, "rpb_chng") = eval(sheetObj.SumValue(0,"curr_rpb")+ " - " + sheetObj.SumValue(0, "prev_rpb"));
        
        if(eval(sheetObj.SumValue(0, "prev_load")) > 0){
            sheetObj.SumValue(0, "prev_cmb") = eval(sheetObj.SumValue(0,"prev_cm")+"/"+sheetObj.SumValue(0, "prev_load")).toFixed(2);
        } else {
            sheetObj.SumValue(0, "prev_cmb") = "0";
        }
        if(eval(sheetObj.SumValue(0, "curr_load")) > 0){
            sheetObj.SumValue(0, "curr_cmb") = eval(sheetObj.SumValue(0,"curr_cm")+"/"+sheetObj.SumValue(0, "curr_load")).toFixed(2);
        } else {
            sheetObj.SumValue(0, "curr_cmb") = "0";
        }           
        sheetObj.SumValue(0, "cmb_chng") = eval(sheetObj.SumValue(0,"curr_cmb")+ " - " + sheetObj.SumValue(0, "prev_cmb"));
        sheetObj.SumValue(0, "bsa_capa_chng") = eval(sheetObj.SumValue(0,"curr_bsa_capa")+ " - " + sheetObj.SumValue(0, "prev_bsa_capa"));
        
        
        if(eval(sheetObj.SumValue(0, "curr_bsa_capa"))>0){
            sheetObj.SumValue(0, "curr_lf") = eval("("+sheetObj.SumValue(0, "curr_load")+"/"+sheetObj.SumValue(0, "curr_bsa_capa")+")*100").toFixed(2);
        }else{
            sheetObj.SumValue(0, "curr_lf") = "0";
        }
        if(eval(sheetObj.SumValue(0, "prev_bsa_capa"))>0){
            sheetObj.SumValue(0, "prev_lf") = eval("("+sheetObj.SumValue(0, "prev_load")+"/"+sheetObj.SumValue(0, "prev_bsa_capa")+")*100").toFixed(2);
        }else{
            sheetObj.SumValue(0, "prev_lf") = "0";
        }
        sheetObj.SumValue(0, "lf_chng") = eval(sheetObj.SumValue(0,"curr_lf") +"-"+ sheetObj.SumValue(0, "prev_lf"));
        
        if(getComboObjValue(formObj.f_ofc_lvl1) == "1" && getComboObjValue(formObj.f_ofc_cd) == "" && !formObj.f_ofc_sts.checked){
            sheetObj.ColHidden("prev_bsa_capa") = false;
            sheetObj.ColHidden("curr_bsa_capa") = false;
            sheetObj.ColHidden("bsa_capa_chng") = false;
            sheetObj.ColHidden("prev_lf") = false;
            sheetObj.ColHidden("curr_lf") = false;
            sheetObj.ColHidden("lf_chng") = false;
        } else {
            sheetObj.ColHidden("prev_bsa_capa") = true;
            sheetObj.ColHidden("curr_bsa_capa") = true;
            sheetObj.ColHidden("bsa_capa_chng") = true;
            sheetObj.ColHidden("prev_lf") = true;
            sheetObj.ColHidden("curr_lf") = true;
            sheetObj.ColHidden("lf_chng") = true;
        }
    }
    /**
     * sheet2조회 후 로직 처리 : total 값을 재계산
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	
    	var formObj = document.form;
        
        sheetObj.SumValue(0, "load_share") = ComParseInt(sheetObj.SumValue(0, "curr_load_share")) - ComParseInt(sheetObj.SumValue(0, "prev_load_share"));
        sheetObj.SumValue(0, "cm_share") = ComParseInt(sheetObj.SumValue(0, "curr_cm_share")) - ComParseInt(sheetObj.SumValue(0, "prev_cm_share"));
        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
            sheetObj.SumValue(0, "op_share") = ComParseInt(sheetObj.SumValue(0, "curr_op_share")) - ComParseInt(sheetObj.SumValue(0, "prev_op_share"));
        }
    }

    /**
     * sheet3조회 후 로직 처리 : total 값을 재계산하여 입력한다.
     */
    function sheet3_OnSearchEnd(sheetObj, errMsg){
        
        var formObj = document.form;
        
        if(eval(sheetObj.SumValue(0, "qta_load")) > 0){
            sheetObj.SumValue(0, "load_chng") = eval("(" + sheetObj.SumValue(0,"coa_load")+ "/" + sheetObj.SumValue(0, "qta_load") + ")*100").toFixed(2);
        } else {
            sheetObj.SumValue(0, "load_chng") = "0";
        }
        if(eval(sheetObj.SumValue(0, "qta_rev")) > 0){
            sheetObj.SumValue(0, "rev_chng") = eval("(" + sheetObj.SumValue(0,"coa_rev")+ "/" + sheetObj.SumValue(0, "qta_rev") + ")*100").toFixed(2);
        } else {
            sheetObj.SumValue(0, "rev_chng") = "0";
        }
        
        if(eval(sheetObj.SumValue(0, "qta_cm")) > 0){
            sheetObj.SumValue(0, "cm_chng") = eval("(" + sheetObj.SumValue(0,"coa_cm")+ "/" + sheetObj.SumValue(0, "qta_cm") + ")*100").toFixed(2);
        } else {
            sheetObj.SumValue(0, "cm_chng") = "0";
        }
        if(parseInt(sheetObj.SumValue(0, "qta_load")) > 0){
            sheetObj.SumValue(0,"qta_cmb") = eval(sheetObj.SumValue(0,"qta_cm")+"/"+sheetObj.SumValue(0, "qta_load")).toFixed(2);
        } else {
            sheetObj.SumValue(0,"qta_cmb") = "0";
        }
        if(parseInt(sheetObj.SumValue(0, "coa_load")) > 0){
            sheetObj.SumValue(0,"coa_cmb") = eval(sheetObj.SumValue(0,"coa_cm")+"/"+sheetObj.SumValue(0, "coa_load")).toFixed(2);
        } else {
            sheetObj.SumValue(0,"coa_cmb") = "0";
        }
        
        if(eval(sheetObj.SumValue(0, "qta_cmb")) > 0){
            sheetObj.SumValue(0, "cmb_chng") = eval("(" + sheetObj.SumValue(0,"coa_cmb")+ "-" + sheetObj.SumValue(0, "qta_cmb") + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "cmb_chng") = "0";
        }
        
        if(eval(sheetObj.SumValue(0, "qta_load")) > 0){
            sheetObj.SumValue(0, "qta_rpb") = eval("(" + sheetObj.SumValue(0,"qta_rev")+ "/" + sheetObj.SumValue(0, "qta_load") + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "qta_rpb") = "0";
        }
        if(eval(sheetObj.SumValue(0, "coa_load")) > 0){
            sheetObj.SumValue(0, "coa_rpb") = eval("(" + sheetObj.SumValue(0,"coa_rev")+ "/" + sheetObj.SumValue(0, "coa_load") + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "coa_rpb") = "0";
        }         
        sheetObj.SumValue(0, "rpb_chng") = eval(sheetObj.SumValue(0,"coa_rpb")+ "-" + sheetObj.SumValue(0, "qta_rpb"));
        
        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C"){ //Office Profit, Contract
            if(eval(sheetObj.SumValue(0, "qta_cm")) > 0){
//                sheetObj.SumValue(0, "coa_branch_chng") = eval("(" + sheetObj.SumValue(0,"coa_branchCM")+ "/" + sheetObj.SumValue(0, "qta_cm") + ")*100").toFixed(2); SAQ->SQM
            } else {
//                sheetObj.SumValue(0, "coa_branch_chng") = "0"; SAQ->SQM
            }
        }
        
        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O" ){ //Office Profit, OP
//            if(eval(sheetObj.SumValue(0, "qta_bkg_op")) > 0){ SAQ->SQM
//                sheetObj.SumValue(0, "op_chng") = eval("(" + sheetObj.SumValue(0,"coa_bkg_op")+ "/" + sheetObj.SumValue(0, "qta_bkg_op") + ")*100").toFixed(2);
//            } else {
//                sheetObj.SumValue(0, "op_chng") = "0";
//            }
//            if(parseInt(sheetObj.SumValue(0, "qta_load")) > 0){ SAQ->SQM
//                sheetObj.SumValue(0,"qta_opb") = eval(sheetObj.SumValue(0,"qta_bkg_op")+"/"+sheetObj.SumValue(0, "qta_load")).toFixed(2);
//            } else {
//                sheetObj.SumValue(0,"qta_opb") = "0";
//            }
//            if(parseInt(sheetObj.SumValue(0, "coa_load")) > 0){ SAQ->SQM
//                sheetObj.SumValue(0,"coa_opb") = eval(sheetObj.SumValue(0,"coa_bkg_op")+"/"+sheetObj.SumValue(0, "coa_load")).toFixed(2);
//            } else {
//                sheetObj.SumValue(0,"coa_opb") = "0";
//            }
//            if(eval(sheetObj.SumValue(0, "qta_opb")) > 0){ SAQ->SQM
//                sheetObj.SumValue(0, "opb_chng") = eval("(" + sheetObj.SumValue(0,"coa_opb")+ "-" + sheetObj.SumValue(0, "qta_opb") + ")").toFixed(2);
//            } else {
//                sheetObj.SumValue(0, "opb_chng") = "0";
//            }
//            if(parseInt(sheetObj.SumValue(0, "qta_bkg_op")) > 0){ SAQ->SQM
//                sheetObj.SumValue(0,"coa_op_chng") = eval("(" + sheetObj.SumValue(0,"coa_op")+"/"+sheetObj.SumValue(0, "qta_bkg_op")+ ")*100").toFixed(2);
//            } else {
//                sheetObj.SumValue(0,"coa_op_chng") = "0";
//            }
        }
        
        if(parseInt(sheetObj.SumValue(0, "qta_bsa_capa"))>0){
            sheetObj.SumValue(0, "qta_lf") = eval("("+sheetObj.SumValue(0, "qta_load")+"/"+sheetObj.SumValue(0, "qta_bsa_capa")+")*100").toFixed(2);
        }else{
            sheetObj.SumValue(0, "qta_lf") = "0";
        }
        
        if(parseInt(sheetObj.SumValue(0, "coa_bsa_capa"))>0){
            sheetObj.SumValue(0, "coa_lf") = eval("("+sheetObj.SumValue(0, "coa_load")+"/"+sheetObj.SumValue(0, "coa_bsa_capa")+")*100").toFixed(2);
        }else{
            sheetObj.SumValue(0, "coa_lf") = "0";
        }       
        sheetObj.SumValue(0, "lf_chng") = eval(sheetObj.SumValue(0,"coa_lf")+"-"+ sheetObj.SumValue(0, "qta_lf"));
        
        if(getComboObjValue(formObj.f_ofc_lvl1) == "1" && getComboObjValue(formObj.f_ofc_cd) == "" && !formObj.f_ofc_sts.checked && !formObj.f_rf_sts.checked){
            sheetObj.ColHidden("qta_bsa_capa")  = false;
            sheetObj.ColHidden("coa_bsa_capa")  = false;
            sheetObj.ColHidden("bsa_capa_chng") = false;
            
            sheetObj.ColHidden("qta_lf")        = false;
            sheetObj.ColHidden("coa_lf")        = false;
            sheetObj.ColHidden("lf_chng")       = false;
        } else {
            sheetObj.ColHidden("qta_bsa_capa")  = true;
            sheetObj.ColHidden("coa_bsa_capa")  = true;
            sheetObj.ColHidden("bsa_capa_chng") = true;
            
            sheetObj.ColHidden("qta_lf")        = true;
            sheetObj.ColHidden("coa_lf")        = true;
            sheetObj.ColHidden("lf_chng")       = true;
        }
        
        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C" && formObj.f_rf_sts.checked){ //Office Profit, Contract, not Reefer
//            sheetObj.ColHidden("coa_branchCM")     = true;
//            sheetObj.ColHidden("coa_branch_chng")  = true;
//            
//            sheetObj.ColHidden("oth_abc_svc")  = true;
//            sheetObj.ColHidden("stp_rev")      = true;
//            sheetObj.ColHidden("balance_svc")  = true;
//            sheetObj.ColHidden("oth_abc_cont") = true;
//            sheetObj.ColHidden("stp_cost")     = true;
//            sheetObj.ColHidden("balance_cont") = true;
//            sheetObj.ColHidden("stp_profit")   = true;
        } else {
//            sheetObj.ColHidden("coa_branchCM")     = false;
//            sheetObj.ColHidden("coa_branch_chng")  = false;
//            
//            sheetObj.ColHidden("oth_abc_svc")  = false;
//            sheetObj.ColHidden("stp_rev")      = false;
//            sheetObj.ColHidden("balance_svc")  = false;
//            sheetObj.ColHidden("oth_abc_cont") = false;
//            sheetObj.ColHidden("stp_cost")     = false;
//            sheetObj.ColHidden("balance_cont") = false;
//            sheetObj.ColHidden("stp_profit")   = false;
        }
        
//        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O" && formObj.f_rf_sts.checked){ SAQ->SQM
//            sheetObj.ColHidden("coa_op")        = true;
//            sheetObj.ColHidden("coa_op_chng")   = true;
//        } else {
//            sheetObj.ColHidden("coa_op")        = false;
//            sheetObj.ColHidden("coa_op_chng")   = false;
//        }
        
        // Customer 부분에 값이 존재 할 경우 Capa 와 LF 숨김
        if(    formObj.f_view_cust.value == "Y" &&
        	   (getComboObjValue(formObj.f_key_acct_group_cd) != ""
    		|| getComboObjValue(formObj.f_ra_acct_group_cd)  != ""
    		|| formObj.f_otr_key_acct.checked
    		|| formObj.f_otr_regional_acct.checked)
    		|| formObj.f_gcust_sts.checked) {
        	
        	sheetObj.ColHidden("qta_bsa_capa")  = true;
            sheetObj.ColHidden("coa_bsa_capa")  = true;
            sheetObj.ColHidden("bsa_capa_chng") = true;
            
            sheetObj.ColHidden("qta_lf")        = true;
            sheetObj.ColHidden("coa_lf")        = true;
            sheetObj.ColHidden("lf_chng")       = true;
    	}
    }
    
    /**
     * sheet3조회 후 로직 처리 : total 값을 재계산하여 입력한다.
     */
    function sheet4_OnSearchEnd(sheetObj, errMsg){
    	var formObj = document.form;
    	
        sheetObj.SumValue(0, "load_share") = ComParseInt(sheetObj.SumValue(0, "coa_load_share")) - ComParseInt(sheetObj.SumValue(0, "qta_load_share"));
        sheetObj.SumValue(0, "cm_share")   = ComParseInt(sheetObj.SumValue(0, "coa_cm_share")) - ComParseInt(sheetObj.SumValue(0, "qta_cm_share"));
//        if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit SAQ->SQM
//            sheetObj.SumValue(0, "op_share")   = ComParseInt(sheetObj.SumValue(0, "coa_op_share")) - ComParseInt(sheetObj.SumValue(0, "qta_op_share"));
//        }
    }

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer");
		var formObj = document.form;


		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
		if(nItem == 0){
			tr0.style.display = "block";
			tr1.style.display = "none";
			tr2.style.display = "none";
			tr3[0].style.display = "none";
			tr3[1].style.display = "none";
			
            formObj.div_nm.value = "div_period1";
			if(formObj.f_wk.value != ""){
			    setPeriod1(formObj.f_wk);
			} else {
			    document.getElementById("div_period1").innerHTML = "<div id='div_period'>&nbsp;</div>";
			}
			formObj.f_pro_lvl.InsertItem(-1,"CM2","M");
			td_lvl1.style.display = "block";
			td_lvl2.style.display = "block";
		}else if(nItem == 1){
			tr0.style.display = "none";
			tr1.style.display = "block";		
			tr2.style.display = "block";
			tr3[0].style.display = "block";
			tr3[1].style.display = "block";
			
            formObj.div_nm.value = "div_period";
           
            if(formObj.f_fm_wk.value != ""){
			    setPeriod(formObj.f_to_wk);
			} else if (formObj.f_fm_mon.value != "") {
			    setPeriod(formObj.f_to_mon);
			} else {
				document.getElementById("div_period").innerHTML = "<div id='div_period'>&nbsp;</div>";
			}
            formObj.f_pro_lvl.DeleteItem("M");
            td_lvl1.style.display = "none";
			td_lvl2.style.display = "none";
		}
		viewCustomer();
		chgOffice(formObj.f_ofc_lvl1);
//		viewBound();
//		viewOffice();
	}
	
	/**
     * sheet를 확장한다.
     */
    function toggle_prev(sheetObj, divObj, prevBtnObj, nextBtnObj){
        sheetObj.style.height = sheetObj.GetSheetHeight(21);

        prevBtnObj.style.display = "none";
        nextBtnObj.style.display = "inline";
        parent.syncHeight();
    }

    /**
     * sheet를 원상태로 변경한다.
     */
    function toggle_next(sheetObj, divObj, prevBtnObj, nextBtnObj){
        sheetObj.style.height = sheetObj.GetSheetHeight(baseHeight);

        prevBtnObj.style.display = "inline";
        nextBtnObj.style.display = "none";
        parent.syncHeight();
    }

	/**
	 * Step 단계별로 클릭 시 화면 display
	 */
	function InvOnChange( dst , m  ){
		document.getElementById(dst).style.display=m;
	}

    /**
     * Report 콤보 변경시 마다 Header 목록을 변경한다.
     */
    function chgHeader(){
//        for(k=0;k<sheetObjects.length;k++){
//            // Header 정보를 변경하기 위해 sheet를 초기화 한다.
//            //--------------------------------------------------
//            // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
//            sheetObjects[k].Redraw = false;
//            sheetObjects[k].Visible = false;
//            sheetObjects[k].RemoveAll();
//            sheetObjects[k].Reset();
//
//            comConfigSheet(sheetObjects[k]);
//            initSheet(sheetObjects[k], k+1);
//            ComEndConfigSheet(sheetObjects[k]);
//
//            sheetObjects[k].Visible = true;
//            sheetObjects[k].Redraw = true;
//            //--------------------------------------------------
//        }
//        viewSheet();
    	viewCustomer();
    }

    /**
     * pro_vw,ofc_vw가 P, C일때만 STP Income을 보여준다.
     */
//    function viewSheet(){
//        var formObj = document.form;
//        var sheetObj = sheetObjects[0];
//        var sheetObj3 = sheetObjects[2];
//        var rptItem = formObj.f_rpt_item.value;
//
//        if(getComboObjValue(formObj.f_pro_vw)=="R" ){
//        if(getComboObjValue(formObj.pro_vw)=="R" && getComboObjValue(formObj.ofc_vw) == "C"){
//            sheetObj.ColHidden("prev_stp_income") = false;
//            sheetObj.ColHidden("curr_stp_income") = false;
//            sheetObj.ColHidden("stp_income_chng") = false;
//            sheetObj.ColHidden("prev_stp_net") = false;
//            sheetObj.ColHidden("curr_stp_net") = false;
//            sheetObj.ColHidden("stp_net_chng") = false;
//            sheetObj.ColHidden("prev_branchCM") = false;
//            sheetObj.ColHidden("curr_branchCM") = false;
//            sheetObj.ColHidden("branchCM_chng") = false;
//
//            sheetObj3.ColHidden("qty_stp") = false;
//            sheetObj3.ColHidden("coa_stp") = false;
//            sheetObj3.ColHidden("stp_chng") = false;
//            sheetObj3.ColHidden("qta_stp_net") = false;
//            sheetObj3.ColHidden("coa_stp_net") = false;
//            sheetObj3.ColHidden("stp_net_chng") = false;
//            sheetObj3.ColHidden("qta_branchCM") = false;
//            sheetObj3.ColHidden("coa_branchCM") = false;
//            sheetObj3.ColHidden("branchCM_chng") = false;
//            sheetObj.CellBackColor(0,"prev_cmb")       = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"curr_cmb")       = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"cmb_chng")       = sheetObj.RgbColor(170,210,130) ;
//
//            sheetObj.CellBackColor(0,"prev_rpb")       = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"curr_rpb")       = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"rpb_chng")       = sheetObj.HeadBackColor ;
//
//            sheetObj.CellBackColor(0,"prev_bsa_capa")  = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"curr_bsa_capa")  = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"bsa_capa_chng")  = sheetObj.RgbColor(170,210,130) ;
//
//            sheetObj.CellBackColor(0,"prev_lf")        = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"curr_lf")        = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"lf_chng")        = sheetObj.HeadBackColor ;
//            
//            
//            sheetObj3.CellBackColor(0,"qta_cmb")        = sheetObj3.RgbColor(170,210,130) ;
//            sheetObj3.CellBackColor(0,"coa_cmb")        = sheetObj3.RgbColor(170,210,130);
//            sheetObj3.CellBackColor(0,"cmb_chng")       = sheetObj3.RgbColor(170,210,130);
//            
//            sheetObj3.CellBackColor(0,"qta_rpb")       = sheetObj3.HeadBackColor ;
//            sheetObj3.CellBackColor(0,"coa_rpb")       = sheetObj3.HeadBackColor;
//            sheetObj3.CellBackColor(0,"rpb_chng")      = sheetObj3.HeadBackColor;
//
//            sheetObj3.CellBackColor(0,"qta_bsa_capa")  = sheetObj3.RgbColor(170,210,130);
//            sheetObj3.CellBackColor(0,"coa_bsa_capa")  = sheetObj3.RgbColor(170,210,130);
//            sheetObj3.CellBackColor(0,"bsa_capa_chng") = sheetObj3.RgbColor(170,210,130);
//            
//            sheetObj3.CellBackColor(0,"qta_lf")        = sheetObj3.HeadBackColor;            
//            sheetObj3.CellBackColor(0,"coa_lf")        = sheetObj3.HeadBackColor;            
//            sheetObj3.CellBackColor(0,"lf_chng")       = sheetObj3.HeadBackColor; 
            
            //Profit Level Hidden           
//            td_lvl1.style.display = "block";
//			td_lvl2.style.display = "block";
            
//        }else{
            //Profit Level Display 
//            td_lvl1.style.display = "block";
//			td_lvl2.style.display = "block";
			
//            sheetObj.ColHidden("prev_stp_income") = true;
//            sheetObj.ColHidden("curr_stp_income") = true;
//            sheetObj.ColHidden("stp_income_chng") = true;
//            sheetObj.ColHidden("prev_stp_net") = true;
//            sheetObj.ColHidden("curr_stp_net") = true;
//            sheetObj.ColHidden("stp_net_chng") = true;
//            sheetObj.ColHidden("prev_branchCM") = true;
//            sheetObj.ColHidden("curr_branchCM") = true;
//            sheetObj.ColHidden("branchCM_chng") = true;
//
//            sheetObj3.ColHidden("qty_stp") = true;
//            sheetObj3.ColHidden("coa_stp") = true;
//            sheetObj3.ColHidden("stp_chng") = true;
//            sheetObj3.ColHidden("qta_stp_net") = true;
//            sheetObj3.ColHidden("coa_stp_net") = true;
//            sheetObj3.ColHidden("stp_net_chng") = true;
//            sheetObj3.ColHidden("qta_branchCM") = true;
//            sheetObj3.ColHidden("coa_branchCM") = true;
//            sheetObj3.ColHidden("branchCM_chng") = true;
//
//            sheetObj.CellBackColor(0,"prev_cmb")       = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"curr_cmb")       = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"cmb_chng")       = sheetObj.HeadBackColor ;
//
//            sheetObj.CellBackColor(0,"prev_rpb")       = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"curr_rpb")       = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"rpb_chng")       = sheetObj.RgbColor(170,210,130) ;
//
//            sheetObj.CellBackColor(0,"prev_bsa_capa")  = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"curr_bsa_capa")  = sheetObj.HeadBackColor ;
//            sheetObj.CellBackColor(0,"bsa_capa_chng")  = sheetObj.HeadBackColor ;
//
//            sheetObj.CellBackColor(0,"prev_lf")        = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"curr_lf")        = sheetObj.RgbColor(170,210,130) ;
//            sheetObj.CellBackColor(0,"lf_chng")        = sheetObj.RgbColor(170,210,130) ;
//
//
//
//            sheetObj3.CellBackColor(0,"qta_cmb") = sheetObj3.HeadBackColor ;
//            sheetObj3.CellBackColor(0,"coa_cmb") = sheetObj3.HeadBackColor;
//            sheetObj3.CellBackColor(0,"cmb_chng") = sheetObj3.HeadBackColor;
//
//            sheetObj3.CellBackColor(0,"qta_rpb") = sheetObj3.RgbColor(170,210,130) ;
//            sheetObj3.CellBackColor(0,"coa_rpb") = sheetObj3.RgbColor(170,210,130);
//            sheetObj3.CellBackColor(0,"rpb_chng") = sheetObj3.RgbColor(170,210,130);
//            
//            sheetObj3.CellBackColor(0,"qta_bsa_capa")   = sheetObj3.HeadBackColor;            
//            sheetObj3.CellBackColor(0,"coa_bsa_capa")   = sheetObj3.HeadBackColor;            
//            sheetObj3.CellBackColor(0,"bsa_capa_chng")  = sheetObj3.HeadBackColor;   
//                     
//            sheetObj3.CellBackColor(0,"qta_lf")         = sheetObj3.RgbColor(170,210,130);            
//            sheetObj3.CellBackColor(0,"coa_lf")         = sheetObj3.RgbColor(170,210,130);            
//            sheetObj3.CellBackColor(0,"lf_chng")        = sheetObj3.RgbColor(170,210,130);            
//
//        }
//    }
    
    /**
     * 
     */
    function viewOffice(){
        var formObj = document.form;
        
//        if(tabObjects[0].SelectedIndex==0){
//            var sheetObj1 = sheetObjects[0];
//            var sheetObj2 = sheetObjects[1];
//            
//            if(formObj.ofc_sts.checked){
//                sheetObj1.ColHidden("ofc_lvl1")     = false;
//                sheetObj1.ColHidden("ofc_lvl2")     = false;
//                sheetObj2.ColHidden("ofc_lvl1")     = false;
//                sheetObj2.ColHidden("ofc_lvl2")     = false;
//            } else {
//                sheetObj1.ColHidden("ofc_lvl1")     = true;
//                sheetObj1.ColHidden("ofc_lvl2")     = true;
//                sheetObj2.ColHidden("ofc_lvl1")     = true;
//                sheetObj2.ColHidden("ofc_lvl2")     = true;
//            }     
//            sheetObj1.RemoveAll();
//            sheetObj2.RemoveAll();
//		}else if(tabObjects[0].SelectedIndex==1){
//            var sheetObj1 = sheetObjects[2];
//            var sheetObj2 = sheetObjects[3];
//            
//            if(formObj.ofc_sts.checked){
//                sheetObj1.ColHidden("ofc_lvl1")     = false;
//                sheetObj1.ColHidden("ofc_lvl2")     = false;
//                sheetObj2.ColHidden("ofc_lvl1")     = false;
//                sheetObj2.ColHidden("ofc_lvl2")     = false;
//            } else {
//                sheetObj1.ColHidden("ofc_lvl1")     = true;
//                sheetObj1.ColHidden("ofc_lvl2")     = true;
//                sheetObj2.ColHidden("ofc_lvl1")     = true;
//                sheetObj2.ColHidden("ofc_lvl2")     = true;
//            }     
//            sheetObj1.RemoveAll();     
//            sheetObj2.RemoveAll();     
//		}           
    }
    
    /**
     * Bound 컬럼의 view 유무에 따라서 sheet를 보여준다.
     */
    function viewBound(){
        var formObj = document.form;
        
//        if(tabObjects[0].SelectedIndex==0){
//            var sheetObj1 = sheetObjects[0];
//            var sheetObj2 = sheetObjects[1];
//            
//            if(formObj.dir_sts.checked){
//                sheetObj1.ColHidden("dir_cd")     = false;
//                sheetObj2.ColHidden("dir_cd")     = false;
//            } else {
//                sheetObj1.ColHidden("dir_cd")     = true;
//                sheetObj2.ColHidden("dir_cd")     = true;
//            }     
//            sheetObj1.RemoveAll();
//            sheetObj2.RemoveAll();
//		}else if(tabObjects[0].SelectedIndex==1){
//            var sheetObj1 = sheetObjects[2];
//            var sheetObj2 = sheetObjects[3];
//            
//            if(formObj.dir_sts.checked){
//                sheetObj1.ColHidden("dir_cd")     = false;
//                sheetObj2.ColHidden("dir_cd")     = false;
//            } else {
//                sheetObj1.ColHidden("dir_cd")     = true;
//                sheetObj2.ColHidden("dir_cd")     = true;
//            }     
//            sheetObj1.RemoveAll();     
//            sheetObj2.RemoveAll();     
//		}        
    }
    
    /**
     * Seq를 선택하면 Date Period를 clear한다.
     */
    function clearDatePeriod(){
        document.form.f_wk.value = "";
//        document.getElementById("f_wk").className = "noact";
        document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
    }
     /**
      * Office Level 변경시 Office combo변경
      */
     function f_ofc_lvl1_OnChange(obj, code){
     	 if (loadingMode == true) return;  
     	 chgOffice(obj);
     	 viewCustomer();
     }
     
     /**
      * Office Leve2 변경시 Office combo변경
      */
     function f_ofc_lvl2_OnChange(obj, code){
     	 viewCustomer();
     }
     
    /**
     * 본부 콤보변경시...
     */
    function chgOffice(obj){
    	 var formObj = document.form;
         var sheetObj = sheetObjects[0];
         
         if(obj.Text != ""){
         	formObj.f_cmd.value = SEARCHLIST13;
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_ofc_cd, "code", "code");
 			formObj.f_ofc_cd.Index=0;
         }
         
    }
     
    /**
     * trade변경시 R.Lane combo변경
     */
	function f_trd_cd_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST11;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
			formObj.f_sub_trd_cd.Index = 0;
			formObj.f_rlane_cd.Index = 0;
			
	      	if (obj.Text == "IAS" ) {
	      		if(formObj.f_dir_cd.className != "input2"){
	      			formObj.f_ias_rgn_cd.Enable = true;
	      		}else{
	      			formObj.f_ias_rgn_cd.Enable = false;
					formObj.f_ias_rgn_cd.Index = 0;	
	      		}
	         }else{
	        	 	formObj.f_ias_rgn_cd.Enable = false;
					formObj.f_ias_rgn_cd.Index = 0;	  		
	         }
			
		}
	}
    
     /**
      * ifram을 이용하여 Sub Trade 표시
      */      
     function f_sub_trd_cd_OnChange(obj) {
     	if (loadingMode == true) return;
     	var formObj = document.form;
     	var sheetObj = sheetObjects[0];
     	if(obj.Text != ""){
     		formObj.f_cmd.value = SEARCHLIST17;
     		var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
     		var arrXml = sXml.split("|$$|");
     		if (arrXml.length > 0)
     			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
     		formObj.f_rlane_cd.Index = 0;
     	}
     }     

      /**
       * IAS Region  콤보를 클릭할 때 Trade체크
       */
      function f_ias_rgn_cd_OnChange(comboObj, index, code) {
     	 var formObj = document.form;

//      	if (formObj.f_trd_cd.value != "IAS"  ) {
//      		formObj.f_ias_rgn_cd.Enable = false;
//      		formObj.f_ias_rgn_cd.Index = 0;
//         }else{
//         	formObj.f_ias_rgn_cd.Enable = true;
//         }
      }      

       /**
        * Core Customer 변경시 H/O Team , RHQ Team 변경
        */
   	function f_key_acct_group_cd_OnChange(obj) {
 		if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        if(formObj.f_ra_acct_group_cd.Text!="All" && formObj.f_key_acct_group_cd.Text!="All"){
        	formObj.f_ra_acct_group_cd.Index2 = 0;
        }
        if(obj.Text != "All"){
        	formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 1;
			if(formObj.f_ofc_team_cd.Text==""){
				formObj.f_ofc_team_cd.Index2 = 0;
			}
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_rhq_cd, "code", "code|name");
			formObj.f_rhq_cd.Index2 = 1;
			if(formObj.f_rhq_cd.Text==""){
				formObj.f_rhq_cd.Index2 = 0;
			}
        }else if(obj.Text == "All"){
        	formObj.f_cmd.value = SEARCHLIST16;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 0;
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_rhq_cd, "code", "code|name");
			formObj.f_rhq_cd.Index2 = 0;
        }
        viewCustomer();
   	}
   	
    /**
     * H/O Team 변경시 Core Customer, Regional Customer combo변경
     */
    function f_ofc_team_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        if(formObj.f_ofc_team_cd.GetCount()>3){
	        if(obj.Text != ""){
	        	formObj.f_cmd.value = SEARCHLIST14;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_key_acct_group_cd, "code", "name");
				formObj.f_key_acct_group_cd.Index2 = 0;
				if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ra_acct_group_cd, "code", "name");
				formObj.f_ra_acct_group_cd.Index2 = 0;
	        }
        }
        viewCustomer();
    }
   	
    /**
     * RHQ Team 변경시 Core Customer, Regional Customer combo변경
     */
    function f_rhq_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        if(formObj.f_ofc_team_cd.GetCount()>3){
	        if(obj.Text != ""){
	        	formObj.f_cmd.value = SEARCHLIST14;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_key_acct_group_cd, "code", "name");
				formObj.f_key_acct_group_cd.Index2 = 0;
				if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ra_acct_group_cd, "code", "name");
				formObj.f_ra_acct_group_cd.Index2 = 0;
	        }
        }
        viewCustomer();
    }
    

    /**
     * RA(Group) 변경시 RA indvl combo변경
     */
    function f_ra_acct_group_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

    	 var formObj = document.form;
         var sheetObj = sheetObjects[1];
         if(formObj.f_ra_acct_group_cd.Text!="All" && formObj.f_key_acct_group_cd.Text!="All"){
         	formObj.f_key_acct_group_cd.Index2 = 0;
         }
         if(obj.Text != "All"){
         	formObj.f_cmd.value = SEARCHLIST10;
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
 			formObj.f_ofc_team_cd.Index2 = 1;
 			if(formObj.f_ofc_team_cd.Text==""){
 				formObj.f_ofc_team_cd.Index2 = 0;
 			}
 			if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], formObj.f_rhq_cd, "code", "code|name");
 			formObj.f_rhq_cd.Index2 = 1;
 			if(formObj.f_rhq_cd.Text==""){
 				formObj.f_rhq_cd.Index2 = 0;
 			}
 			
         }else if(obj.Text == "All"){
        	formObj.f_cmd.value = SEARCHLIST16;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 0;
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_rhq_cd, "code", "code|name");
			formObj.f_rhq_cd.Index2 = 0;
        }
         viewCustomer();
    }
       
      
  	/**
  	 * Profit View 변경시  컬럼을변경
  	 */
//  	function f_pro_vw_OnChange(obj, code) {
//  		if (loadingMode == true)
//  			return;
//  		//viewSheet();
//  	}
  	/**
  	 * Office View 변경시  컬럼을변경
  	 */
  	function f_ofc_vw_OnChange(obj, code) {
  		if (loadingMode == true)
  			return;
  		//viewSheet();
  		if(tabObjects[0].SelectedIndex==1 && code == "L" && document.form.f_year.value >= 2014){
  			document.form.f_rf_sts.checked = false;
  			document.form.f_sc_sts.checked = false;
  			spcl2.style.display = "none";
  		}else if(tabObjects[0].SelectedIndex==1 && code == "C"){
  			spcl2.style.display = "block";
  		}
  	}
  	
  	/**
     * month week가 변경되었을때 date period를 변경한다.
     */
    function setPeriod1(obj){
    	 if (loadingMode == true)
 			return;
    	 var formObj = document.form; 
         with(formObj){
			if (f_year2.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
			    //ComShowMessage(getMsg("COM12114", "Year"));
			    //f_year.focus();
				return false;
			}
			if(!ComIsDate(f_year2, "yyyy")){
 		    // [COA1009] = Year 값을 확인하십시오.
 		    	ComShowCodeMessage('COA10009','Year','YYYY');
 		    	f_year2.focus();
 		    	return false;
 		    }
			if (f_wk.value == "") {
			    // [COM12114] : Week 를(을) 확인하세요.
			    //ComShowMessage(getMsg("COM12114", "Week"));
			    //f_wk.focus();
				return false;
			}
			ComSetObjValue(f_yearweek,f_year2.value+f_wk.value);
        }
        ComCoaSetPeriod5(obj,"div_period1");
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
    	 if (loadingMode == true)
  			return;

        var formObj = document.form;

        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value = "";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }

        if(chkValidSearch()){
        	ComCoaSetPeriod(obj);
        }
        
        if(formObj.f_year.value>=2014 && tabObjects[0].SelectedIndex==1){

  	  		formObj.f_ias_secter_sts.disabled = false;
		   // reInitSheet(sheetObjects[2], 3);
		   // reInitSheet(sheetObjects[3], 4);
        	  
        	td_lvl1.style.display = "none";
			td_lvl2.style.display = "none";
			sheetObjects[2].Visible = true; 
			sheetObjects[3].Visible = true;
			sheetObjects[4].Visible = false; 
			sheetObjects[5].Visible = false;
			document.getElementById('orgSht1').style.display="block";
			document.getElementById('orgSht2').style.display="block";
			document.getElementById('orgSht3').style.display="block";
			document.getElementById('orgSht4').style.display="block";
			document.getElementById('copySht1').style.display="none";
			document.getElementById('copySht2').style.display="none";
			document.getElementById('copySht3').style.display="none";
			document.getElementById('copySht4').style.display="none";
			
        }else if(formObj.f_year.value<2014 && tabObjects[0].SelectedIndex==1){	 
			//IAS Sector 는 2014년 이후부터 조회가능
  	  		formObj.f_ias_secter_sts.disabled = true;
      	  	if (formObj.f_ias_secter_sts.checked){
      	  		formObj.f_ias_secter_sts.checked = false; 
      	  		document.getElementById("f_trd_cd").Enable = true;
      	  		tr_ias_sector.style.display = "none";
      	  		spcl2.style.display = "block";
      	  		formObj.f_pol_cd.value = "";
      	  		formObj.f_pod_cd.value = "";
      	  	}

		   // reInitSheet(sheetObjects[4], 5);
		   // reInitSheet(sheetObjects[5], 6);
		    
        	td_lvl1.style.display = "block";	
			td_lvl2.style.display = "block";
			sheetObjects[2].Visible = false; 
			sheetObjects[3].Visible = false;
			sheetObjects[4].Visible = true; 
			sheetObjects[5].Visible = true;
			document.getElementById('orgSht1').style.display="none";
			document.getElementById('orgSht2').style.display="none";
			document.getElementById('orgSht3').style.display="none";
			document.getElementById('orgSht4').style.display="none";
			document.getElementById('copySht1').style.display="block";
			document.getElementById('copySht2').style.display="block";
			document.getElementById('copySht3').style.display="block";
			document.getElementById('copySht4').style.display="block";
		
      	   
        }else{
        	td_lvl1.style.display = "block";	
			td_lvl2.style.display = "block";
        }
    }
    
   /* 팝업 */
	function openSTPIncome(){
		var fm = document.form;
		var year = "";
		var week = "";
		var flag = true;
		
		if(tabObjects[0].SelectedIndex==0){
    		if (fm.f_year2.value == "") {
    			flag = false;
    			// [COM12114] : Year 를(을) 확인하세요.
    			ComShowMessage(ComGetMsg("COM12114", "Year"));
    			fm.f_year2.focus();
    		} else if (fm.f_wk.value == "") {
    			flag = false;
    			// [COM12114] : Week 를(을) 확인하세요.
    			ComShowMessage(ComGetMsg("COM12114", "Week"));
    			fm.f_wk.focus();
    		}
		    year = fm.f_year2.value;
		    week = fm.f_wk.value;
		} else {
    		if (fm.f_year.value == "") {
    			flag = false;
    			// [COM12114] : Year 를(을) 확인하세요.
    			ComShowMessage(ComGetMsg("COM12114", "Year"));
    			fm.f_year.focus();
    		} else if (fm.f_fm_wk.value == "") {
    			flag = false;
    			// [COM12114] : Week 를(을) 확인하세요.
    			ComShowMessage(ComGetMsg("COM12114", "Week"));
    			fm.f_wk.focus();
    		}
		    year = fm.f_year.value;
		    week = fm.f_fm_wk.value;
		    
		}
		
		if(ComParseInt(getComboObjValue(fm.f_ofc_lvl1)) < 4 ) {//Sales Offic, Sub Ofc1, Sub Ofc2 level만 조회 가능
			flag = false;
		    ComShowMessage(ComGetMsg("COM12114", "OFC Level") + "\n"  +ComGetMsg("COA10034"));
		    fm.f_ofc_lvl1.focus();	
		} else if(getComboObjValue(fm.f_ofc_cd) == "") {//office code가 선택된 경우에만 조회 가능
			flag = false;
			ComShowMessage(ComGetMsg("COM12114", "OFC"));
			fm.f_ofc_cd.focus();	
		}
        if(flag){
    		var cond = "?f_year="      + year
    			     + "&f_wk="      + week
    			     + "&f_ofc_lvl1="     + getComboObjValue(fm.f_ofc_lvl1)
    			     + "&f_ofc_cd=" + getComboObjValue(fm.f_ofc_cd)
    			     + "&f_vsl_cd="     + fm.f_vsl_cd.value
    			     + "&f_skd_voy_no=" + fm.f_skd_voy_no.value
    			     + "&f_dir_cd="     + fm.f_dir_cd.value;
    		
    		ComOpenWindow('ESM_COA_0135.do' + cond, 'STP_Income'
					, 'width=850,height=680,menubar=0,status=1,scrollbars=0,resizable=0');
   		
        }		
	}

	/*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){
        if(val != '') chgOffice(document.form.f_ofc_lvl1);
    }   
    
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObj2 = sheetObjects[1];
        var sheetObj3 = sheetObjects[2];
        var sheetObj4 = sheetObjects[3];
        var sheetObj5 = sheetObjects[4];
        var sheetObj6 = sheetObjects[5];

        switch(sAction) {
        	case IBCLEAR:          //조회
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml = sXml.split("|$$|");
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        fYear = ComGetEtcData(arrXml[0], "fYear"); 
		        
		        formObj.f_year.value = fYear;
		        formObj.f_year2.value = fYear;
		        formObj.f_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        document.getElementById("div_period1").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        		        
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_ofc_lvl1, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_ofc_cd, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_ofc_lvl2, "code", "name");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 8)
					ComXml2ComboItem(arrXml[8], formObj.f_skd_dir_cd, "code", "code");
				if (arrXml.length > 9)
					ComXml2ComboItem(arrXml[9], formObj.f_key_acct_group_cd, "code", "name");
				if (arrXml.length > 10)
					ComXml2ComboItem(arrXml[10], formObj.f_ra_acct_group_cd, "code", "name");
				if (arrXml.length > 11)
					ComXml2ComboItem(arrXml[11], formObj.f_sub_trd_cd, "code", "name");
				if (arrXml.length > 12)
					ComXml2ComboItem(arrXml[12], formObj.f_ias_rgn_cd, "code", "name");
				if (arrXml.length > 13)
					ComXml2ComboItem(arrXml[13], formObj.f_hul_bnd_cd, "code", "name");
				if (arrXml.length > 14)
					ComXml2ComboItem(arrXml[14], formObj.f_ofc_team_cd, "code", "name");
				if (arrXml.length > 15)
					ComXml2ComboItem(arrXml[15], formObj.f_rhq_cd, "code", "name");

				ComOpenWait(false);
				break;
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS.do", coaFormQueryString(formObj));
                formObj.f_pre_week.value = searchEtcData("f_pre_week", sXml, "1");
                var sXml1 =  searchEtcData("sXml1", sXml, "1");
                var sXml2 =  searchEtcData("sXml2", sXml, "1");
                
			    reInitSheet(sheetObj, 1, sXml1);
			    reInitSheet(sheetObj2, 2, sXml2);
			    sheetObj.LoadSearchXml(sXml1);
			    sheetObj2.LoadSearchXml(sXml2);
			    ComOpenWait(false);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                if(tabObjects[0].SelectedIndex==0){
                    var excelType = selectDownExcelMethod(sheetObj);
                    switch (excelType) {
                        case "AY":
                            sheetObj.Down2Excel(0, false, false, true);
                            //sheetObj2.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj.Down2Excel(-1, false, false, true);
                            //sheetObj2.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj.SpeedDown2Excel(0, false, false);
                            //sheetObj2.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj.SpeedDown2Excel(-1, false, false);
                            //sheetObj2.SpeedDown2Excel(-1, false, false);
                            break;
                    }               
                    break;
                } else if(tabObjects[0].SelectedIndex==1 && formObj.f_year.value >= 2014){
                    var excelType = selectDownExcelMethod(sheetObj3);
                    switch (excelType) {
                        case "AY":
                            sheetObj3.Down2Excel(0, false, false, true);
                            //sheetObj4.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj3.Down2Excel(-1, false, false, true);
                            //sheetObj4.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj3.SpeedDown2Excel(0, false, false);
                           // sheetObj4.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj3.SpeedDown2Excel(-1, false, false);
                            //sheetObj4.SpeedDown2Excel(-1, false, false);
                            break;
                    } 
                    break;
                } else if(tabObjects[0].SelectedIndex==1 && formObj.f_year.value < 2014){
                    var excelType = selectDownExcelMethod(sheetObj5);
                    switch (excelType) {
                        case "AY":
                            sheetObj5.Down2Excel(0, false, false, true);
                            //sheetObj6.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj5.Down2Excel(-1, false, false, true);
                            //sheetObj6.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj5.SpeedDown2Excel(0, false, false);
                            //sheetObj6.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj5.SpeedDown2Excel(-1, false, false);
                            //sheetObj6.SpeedDown2Excel(-1, false, false);
                            break;
                    } 
                    break;
                }

        }
    }

    function doActionIBSheet2(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg = false;

        var sheetObj2 = sheetObjects[1];
        var sheetObj3 = sheetObjects[2];
        var sheetObj4 = sheetObjects[3];
        var sheetObj5 = sheetObjects[4];
        var sheetObj6 = sheetObjects[5];
        
        switch(sAction) {
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
                checkCustomer();
                // 업무처리중 버튼사용 금지 처리
				//sheetObj.WaitImageVisible = false;
				//ComOpenWait(true);
                
                var sXml = "";
                if(formObj.f_ias_secter_sts.checked) {
                    formObj.f_cmd.value = SEARCHLIST04;
                    sXml = sheetObj.GetSearchXml("ESM_COA_0070GSIASS.do", coaFormQueryString(formObj));
                } else {
                    formObj.f_cmd.value = SEARCHLIST02;
                    sXml = sheetObj.GetSearchXml("ESM_COA_0070GS2.do", coaFormQueryString(formObj));                	
                }
                
                formObj.f_pre_week.value = searchEtcData("f_pre_week", sXml, "1");
                var sXml3 =  searchEtcData("sXml3", sXml, "1");
                var sXml4 =  searchEtcData("sXml4", sXml, "1");

			    reInitSheet(sheetObj3, 3, sXml);
			    reInitSheet(sheetObj4, 4, sXml4);
			    sheetObj3.LoadSearchXml(sXml);
			    sheetObj4.LoadSearchXml(sXml4);
			    //ComOpenWait(false);	    
                break;
                
            case SEARCH02:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
                checkCustomer();
                // 업무처리중 버튼사용 금지 처리
				//sheetObj.WaitImageVisible = false;
				//ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST03;
                var sXml = sheetObj.GetSearchXml("ESM_COA_0070GS4.do", coaFormQueryString(formObj));
                formObj.f_pre_week.value = searchEtcData("f_pre_week", sXml, "1");
                var sXml5 =  searchEtcData("sXml5", sXml, "1");
                var sXml6 =  searchEtcData("sXml6", sXml, "1");
			    reInitSheet(sheetObj5, 5, sXml);
			    reInitSheet(sheetObj6, 6, sXml6);
			    sheetObj5.LoadSearchXml(sXml);
			    sheetObj6.LoadSearchXml(sXml6);
			    //ComOpenWait(false);	    
                break;
                     

//            case IBDOWNEXCEL:        //엑셀 다운로드
//                sheetObj3.SpeedDown2Excel(-1, false, false, "","", true);
//                sheetObj4.SpeedDown2Excel(-1, false, false, "","", true);
//                break;
                

            case IBDOWNEXCEL:        //엑셀 다운로드
                if(tabObjects[0].SelectedIndex==0){
                    var excelType = selectDownExcelMethod(sheetObj);
                    switch (excelType) {
                        case "AY":
                            sheetObj2.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj2.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj2.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj2.SpeedDown2Excel(-1, false, false);
                            break;
                    }               
                    break;
                } else if(tabObjects[0].SelectedIndex==1 && formObj.f_year.value >= 2014){
                    var excelType = selectDownExcelMethod(sheetObj3);
                    switch (excelType) {
                        case "AY":
                            sheetObj4.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj4.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj4.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj4.SpeedDown2Excel(-1, false, false);
                            break;
                    } 
                    break;
                } else if(tabObjects[0].SelectedIndex==1 && formObj.f_year.value < 2014){
                    var excelType = selectDownExcelMethod(sheetObj5);
                    switch (excelType) {
                        case "AY":
                            sheetObj6.Down2Excel(0, false, false, true);
                            break;
                        case "DY":
                            sheetObj6.Down2Excel(-1, false, false, true);
                            break;
                        case "AN":
                            sheetObj6.SpeedDown2Excel(0, false, false);
                            break;
                        case "DN":
                            sheetObj6.SpeedDown2Excel(-1, false, false);
                            break;
                    } 
                    break;
                }

        }

    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;

            with(formObj){
            	if(f_year.value == ""){
	                ComShowMessage(ComGetMsg("COM12114","Year",""));
	                f_year.focus();
	                return false;
	            }
	            if(!ComIsDate(f_year, "yyyy")){
	 		    // [COA1009] = Year 값을 확인하십시오.
	 		    	ComShowCodeMessage('COA10009','Year','YYYY');
	 		    	f_year.focus();
	 		    	return false;
	 		    }
	            
	            if(f_chkprd[0].checked){
	            	if (f_to_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "week", ""));
		                f_to_wk.focus();
		                return false;
		            }
		            if (f_fm_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "Week", ""));
		                f_fm_wk.focus();
		                return false;
		            }
		            if(!ComIsWeek(f_fm_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_fm_wk.focus();
						return false;
					}
					if(!ComIsWeek(f_to_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_to_wk.focus();
						return false;
					}
	            }else{
	            	if (f_to_mon.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "month", ""))
		                f_to_mon.focus();
		                return false;
		            }   
		            if (f_fm_mon.value == "" ) {
		                ComShowMessage(ComGetMsg("COM12114", "Month", ""));
		                f_fm_mon.focus();
		                return false;
		            }
		            if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
		                ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
		                return false;
		            }
		            if(!ComIsMonth(f_fm_mon.value)){ 
						ComShowMessage(ComGetMsg("COM12114", "Month"));
						f_fm_mon.focus();
						return false;
					}
					if(!ComIsMonth(f_to_mon.value)){
						ComShowMessage(ComGetMsg("COM12114", "Month"));
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
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            
            if(parseInt(f_ofc_lvl1.value) > parseInt(f_ofc_lvl2.value)){
                ComShowMessage(ComGetMsg("COM12114","Level 2"));
                f_ofc_lvl2.focus();
                return false;
            }
            if(tabObjects[0].SelectedIndex==0){
    			if (f_year2.value == "") {
    			    // [COM12114] : Year 를(을) 확인하세요.
    			    ComShowMessage(ComGetMsg("COM12114", "Year"));
    			    f_year2.focus();
    				return false;
    			}
    			if (f_wk.value == "") {
    			    // [COM12114] : Week 를(을) 확인하세요.
    			    ComShowMessage(ComGetMsg("COM12114", "Week"));
    			    f_wk.focus();
    				return false;
    			}
    			if(f_year2.value == "2007" && ComParseInt(f_wk.value) < 27){
    			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    			    ComShowMessage(ComGetMsg("COA10037"));
    			    return false;
    			}    			
    		}else if(tabObjects[0].SelectedIndex==1){
    			if (f_year.value == "") {
    			    // [COM12114] : Year 를(을) 확인하세요.
    			    ComShowMessage(ComGetMsg("COM12114", "Year"));
    			    f_year.focus();
    				return false;
    			}
    			if(f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == ""){
    			    ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
    			    return false;
    			}
    			if(f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == ""){
    			    ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
    			    return false;
    			}
    			if(f_chkprd[1].checked && f_fm_mon.value != "" && f_fm_wk.value != ""){
        			if (ComParseInt(f_to_mon.value)-ComParseInt(f_fm_mon.value)!=0) {
        			    // [COA10003] : Month 는(은) 1th 만 처리할수 있습니다.
        			    ComShowMessage(ComGetMsg("COA10003", "Month", "1th"));
        			    f_to_mon.focus();
        				return false;
        			}
    			}
    			if(f_chkprd[0].checked && f_fm_wk.value != "" && f_to_wk.value != ""){
        			if (ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value)>14) {
        			    // [COA10003] : Week 는(은) 15wk 만 처리할수 있습니다.
        			    ComShowMessage(ComGetMsg("COA10003", "Week", "15wk"));
        			    f_to_wk.focus();
        				return false;
        			}
    			}
    			if((f_chkprd[1].checked && f_year.value == "2007" && ComParseInt(f_fm_mon.value) < 7) || 
    			   (f_chkprd[0].checked && f_year.value == "2007" && ComParseInt(f_fm_wk.value) < 27)){
    			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    			    ComShowMessage(ComGetMsg("COA10037"));
    			    return false;
    			}
    		}
    		
        }

        return true;
    }

     function getComboObjValue(obj){
 	 	if (ComGetObjValue(obj) == "All") return "";
 	 	return ComGetObjValue(obj);
 	 } 
     
     /**
      * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     initControl()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이석준
      * @version 2009.04.17
      */ 	    
      function initControl() {
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)                   
    	  axon_event.addListenerForm('click', 'obj_OnClick', document.form);
        
      }    
      
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_deactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */   
      function obj_OnClick() {
          var formObj = document.form;
          var sheetObj = sheetObjects[0]; 
          var eleName = event.srcElement.name;
          viewCustomer();
          switch(eleName){
          case "f_rf_sts":
        	  if (formObj.f_sc_sts.checked){
        		  formObj.f_rf_sts.checked = false;
        		  ComShowMessage(ComGetMsg("COA10065"));
        	  }
        	  break;
          case "f_sc_sts":
        	  if (formObj.f_rf_sts.checked){
        		  formObj.f_sc_sts.checked = false;
        		  ComShowMessage(ComGetMsg("COA10065"));
        	  }
         	 break;
          case "f_otr_key_acct":
        	  if (formObj.f_otr_regional_acct.checked){
        		  formObj.f_otr_key_acct.checked = false;
        		  ComShowMessage(ComGetMsg("COA10067"));
        	  }
         	 break;

          case "f_otr_regional_acct":
        	  if (formObj.f_otr_key_acct.checked){
        		  formObj.f_otr_regional_acct.checked = false;
        		  ComShowMessage(ComGetMsg("COA10067"));
        	  }
         	 break;

          case "f_ias_secter_sts":
        	  var tTrdCd = document.getElementById("f_trd_cd");
        	  
        	  if (formObj.f_ias_secter_sts.checked){
        		  tTrdCd.Code = "IAS";
        		  tTrdCd.Enable = false;
        		  tr_ias_sector.style.display = "block";
        		  spcl2.style.display = "none";
        	  } else {
        		  tTrdCd.Enable = true;
        		  tr_ias_sector.style.display = "none";
        		  spcl2.style.display = "block";
        		  formObj.f_pol_cd.value = "";
        		  formObj.f_pod_cd.value = "";
        		  
        	  }
         	 break;	 
         	 
         	

          case "f_chkprd":
          case "f_wk_sts":
        	  viewCustomer();
        	  break;
          default:
          }     
      }
      
      /**
       * 특정 조건에서만 By Customer 부분을 보여준다.
       */
      function viewCustomer() {
    	  var formObj = document.form;
    	  var rptItem = formObj.f_rpt_item.value;
    	  var ofcLvl1 = getComboObjValue(formObj.f_ofc_lvl1);
    	  var ofcLvl2 = getComboObjValue(formObj.f_ofc_lvl2);
    	  

    	  // VS QTA 탭이면서 W/M 이 Month 일 경우
    	  // Report 의 값이 VVD 가 아닐 경우
    	  // Office Level 1 의 값이 HeadOffice 이거나  Regional Group 일 경우
    	  // Office Level 2 의 값이 Regional Group 일 경우
    	  // Week Display 가 체크가 안되어 있을 경우
    	  // 위 사항이 모두 충족 될때만 만 By Customer 부분을 보여줌
    	  if((    beforetab == 1
    	      && formObj.f_chkprd[1].checked
    	      && (rptItem != "4" || rptItem != "3") 
    	      && (ofcLvl1 == "1" || ofcLvl1 == "2")
    	      && (ofcLvl2 == "1" || ofcLvl2 == "2")
    	      && !formObj.f_wk_sts.checked
    	      && !formObj.f_ofc_sts.checked
    	      && !formObj.f_excl_sts.checked
    	      && !formObj.f_r_month_sts.checked
    	      && !formObj.f_rf_sts.checked
    	      && !formObj.f_sc_sts.checked
    	      && !formObj.f_hul_bnd_sts.checked
    	      && !formObj.f_ias_rgn_sts.checked
    	      && formObj.f_ofc_lvl1.Index == 0
    	      && formObj.f_ofc_cd.Index == 0
    	      && formObj.f_ofc_lvl2.Index == 0
    	      && formObj.f_year.value >= 2014
    	  	) ||
    	  	(    		 beforetab == 1
    	    	      && formObj.f_chkprd[1].checked
    	    	      && (rptItem != "4" ) 
    	    	      && (ofcLvl1 == "1" || ofcLvl1 == "2")
    	    	      && (ofcLvl2 == "1" || ofcLvl2 == "2")
    	    	      && !formObj.f_wk_sts.checked
    	    	      && formObj.f_year.value < 2014
    	  	)
    	  ) {

    		  // Login Office 가 SELCDA, SELCCM, CLTCO 에게만 해당 탭 보여지도록 함
    		  if( formObj.l_ofc_cd.value == "SELCSG" || formObj.l_ofc_cd.value == "SELCMS" || formObj.l_ofc_cd.value == "CLTCO" ){
    			  if(formObj.f_ias_secter_sts.checked) {
    				  tr4.style.display = "none"; // Customer
    			  } else {
    				  tr4.style.display = "block"; // Customer
    			  }
    			  if(formObj.f_year.value >= 2014){
	    			  if(  getComboObjValue(formObj.f_key_acct_group_cd) == ""
	    				&& getComboObjValue(formObj.f_ofc_team_cd) == ""
	    				&& getComboObjValue(formObj.f_ra_acct_group_cd) == ""
	    				&& getComboObjValue(formObj.f_rhq_cd) == ""
	    				&& !formObj.f_otr_key_acct.checked
	    				&& !formObj.f_otr_regional_acct.checked
	    				&& !formObj.f_gcust_sts.checked
	    			  ){
	    				  formObj.f_ofc_lvl1.Enable = true;
	        			  formObj.f_ofc_cd.Enable = true;
	        			  formObj.f_ofc_lvl2.Enable = true; 
	    				  formObj.f_rlane_cd.Enable = true;
	        			  formObj.f_hul_bnd_cd.Enable = true;
	        			  formObj.f_vsl_cd.readOnly = false;
	        			  formObj.f_vsl_cd.className = "input";
	        			  formObj.f_skd_voy_no.readOnly = false;
	      				  formObj.f_skd_voy_no.className = "input";
	      				  formObj.f_dir_cd.readOnly = false;
	    				  formObj.f_dir_cd.className = "input";
	    				  if(formObj.f_rpt_item.options.length==2){
	    					  var new_option = new Option("Lane","3");
	    					  formObj.f_rpt_item.options.add(new_option, formObj.f_rpt_item.options.length);
	    					  var new_option2 = new Option("VVD","4");
	    					  formObj.f_rpt_item.options.add(new_option2, formObj.f_rpt_item.options.length);
	      					}
	  				  }else{
	  					formObj.f_ofc_lvl1.Enable = false;
	    				formObj.f_ofc_lvl1.Index = 0;
	    				formObj.f_ofc_cd.Enable = false;
	  				  	formObj.f_ofc_cd.Index = 0;
	  				  	formObj.f_ofc_lvl2.Enable = false;
	    				formObj.f_ofc_lvl2.Index = 0;
	  					formObj.f_rlane_cd.Enable = false;
	    				formObj.f_rlane_cd.Index = 0;
	  				  	formObj.f_hul_bnd_cd.Enable = false;
	    				formObj.f_hul_bnd_cd.Index = 0;
	    				formObj.f_vsl_cd.value = "";
	    				formObj.f_skd_voy_no.value = "";
	    				formObj.f_vsl_cd.value = "";
	    				formObj.f_vsl_cd.readOnly = true;
	    				formObj.f_vsl_cd.className = "input2";
	    				formObj.f_skd_voy_no.readOnly = true;
	    				formObj.f_skd_voy_no.className = "input2";
	    				formObj.f_dir_cd.value = "";
	    				formObj.f_dir_cd.readOnly = true;
	    				formObj.f_dir_cd.className = "input2";
	    				if(formObj.f_rpt_item.options.length==4){
		    				formObj.f_rpt_item.options[3]=null;
		    				formObj.f_rpt_item.options[2]=null;
	    				}
	  				  }
    			  }  
    		  } else {
    			  tr4.style.display = "none";
    			  formObj.f_ofc_lvl1.Enable = true;
    			  formObj.f_ofc_cd.Enable = true;
    			  formObj.f_ofc_lvl2.Enable = true; 
				  formObj.f_rlane_cd.Enable = true;
    			  formObj.f_hul_bnd_cd.Enable = true; 
    			  formObj.f_vsl_cd.readOnly = false;
    			  formObj.f_vsl_cd.className = "input";
    			  formObj.f_skd_voy_no.readOnly = false;
  				  formObj.f_skd_voy_no.className = "input";
  				  formObj.f_dir_cd.readOnly = false;
				  formObj.f_dir_cd.className = "input";
				  if(formObj.f_rpt_item.options.length==2){
					  var new_option = new Option("Lane","3");
					  formObj.f_rpt_item.options.add(new_option, formObj.f_rpt_item.options.length);
					  var new_option2 = new Option("VVD","4");
					  formObj.f_rpt_item.options.add(new_option2, formObj.f_rpt_item.options.length);
  					}
    		  }
    	  } else {
    		  tr4.style.display = "none";
    		  formObj.f_ofc_lvl1.Enable = true;
			  formObj.f_ofc_cd.Enable = true;
			  formObj.f_ofc_lvl2.Enable = true; 
			  formObj.f_rlane_cd.Enable = true;
			  formObj.f_hul_bnd_cd.Enable = true;
			  formObj.f_vsl_cd.readOnly = false;
			  formObj.f_vsl_cd.className = "input";
			  formObj.f_skd_voy_no.readOnly = false;
			  formObj.f_skd_voy_no.className = "input";
			  formObj.f_dir_cd.readOnly = false;
			  formObj.f_dir_cd.className = "input";
			  if(formObj.f_rpt_item.options.length==2){
				  var new_option = new Option("Lane","3");
				  formObj.f_rpt_item.options.add(new_option, formObj.f_rpt_item.options.length);
				  var new_option2 = new Option("VVD","4");
				  formObj.f_rpt_item.options.add(new_option2, formObj.f_rpt_item.options.length);
					}
    	  }
      }
      
      /**
       * Customer 부분의 값을 Check.
       */
      function checkCustomer() {
    	  var formObj = document.form;
    	  
    	  if(   (tr4.style.display == "block") &&
    			(getComboObjValue(formObj.f_key_acct_group_cd) != ""
	    	  || getComboObjValue(formObj.f_ra_acct_group_cd)  != ""
	    	  || formObj.f_otr_key_acct.checked
	    	  || formObj.f_otr_regional_acct.checked)
	    	  || formObj.f_gcust_sts.checked) {
			  formObj.f_view_cust.value = "Y";
		  } else {
			  formObj.f_view_cust.value = "N";  
		  }
      }

      /**
       * sheet5조회 후 로직 처리 : total 값을 재계산하여 입력한다.
       */
      function sheet5_OnSearchEnd(sheetObj, errMsg){
          
          var formObj = document.form;
          
          if(eval(sheetObj.SumValue(0, "qta_load")) > 0){
              sheetObj.SumValue(0, "load_chng") = eval("(" + sheetObj.SumValue(0,"coa_load")+ "/" + sheetObj.SumValue(0, "qta_load") + ")*100").toFixed(2);
          } else {
              sheetObj.SumValue(0, "load_chng") = "0";
          }
          if(eval(sheetObj.SumValue(0, "qta_rev")) > 0){
              sheetObj.SumValue(0, "rev_chng") = eval("(" + sheetObj.SumValue(0,"coa_rev")+ "/" + sheetObj.SumValue(0, "qta_rev") + ")*100").toFixed(2);
          } else {
              sheetObj.SumValue(0, "rev_chng") = "0";
          }
          
          if(eval(sheetObj.SumValue(0, "qta_cm")) > 0){
              sheetObj.SumValue(0, "cm_chng") = eval("(" + sheetObj.SumValue(0,"coa_cm")+ "/" + sheetObj.SumValue(0, "qta_cm") + ")*100").toFixed(2);
          } else {
              sheetObj.SumValue(0, "cm_chng") = "0";
          }
          if(parseInt(sheetObj.SumValue(0, "qta_load")) > 0){
              sheetObj.SumValue(0,"qta_cmb") = eval(sheetObj.SumValue(0,"qta_cm")+"/"+sheetObj.SumValue(0, "qta_load")).toFixed(2);
          } else {
              sheetObj.SumValue(0,"qta_cmb") = "0";
          }
          if(parseInt(sheetObj.SumValue(0, "coa_load")) > 0){
              sheetObj.SumValue(0,"coa_cmb") = eval(sheetObj.SumValue(0,"coa_cm")+"/"+sheetObj.SumValue(0, "coa_load")).toFixed(2);
          } else {
              sheetObj.SumValue(0,"coa_cmb") = "0";
          }
          
          if(eval(sheetObj.SumValue(0, "qta_cmb")) > 0){
              sheetObj.SumValue(0, "cmb_chng") = eval("(" + sheetObj.SumValue(0,"coa_cmb")+ "-" + sheetObj.SumValue(0, "qta_cmb") + ")").toFixed(2);
          } else {
              sheetObj.SumValue(0, "cmb_chng") = "0";
          }
          
          if(eval(sheetObj.SumValue(0, "qta_load")) > 0){
              sheetObj.SumValue(0, "qta_rpb") = eval("(" + sheetObj.SumValue(0,"qta_rev")+ "/" + sheetObj.SumValue(0, "qta_load") + ")").toFixed(2);
          } else {
              sheetObj.SumValue(0, "qta_rpb") = "0";
          }
          if(eval(sheetObj.SumValue(0, "coa_load")) > 0){
              sheetObj.SumValue(0, "coa_rpb") = eval("(" + sheetObj.SumValue(0,"coa_rev")+ "/" + sheetObj.SumValue(0, "coa_load") + ")").toFixed(2);
          } else {
              sheetObj.SumValue(0, "coa_rpb") = "0";
          }         
          sheetObj.SumValue(0, "rpb_chng") = eval(sheetObj.SumValue(0,"coa_rpb")+ "-" + sheetObj.SumValue(0, "qta_rpb"));
          
          if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C"){ //Office Profit, Contract
              if(eval(sheetObj.SumValue(0, "qta_cm")) > 0){
                  sheetObj.SumValue(0, "coa_branch_chng") = eval("(" + sheetObj.SumValue(0,"coa_branchCM")+ "/" + sheetObj.SumValue(0, "qta_cm") + ")*100").toFixed(2);
              } else {
                  sheetObj.SumValue(0, "coa_branch_chng") = "0";
              }
          }
          
          if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O" ){ //Office Profit, OP
              if(eval(sheetObj.SumValue(0, "qta_bkg_op")) > 0){
                  sheetObj.SumValue(0, "op_chng") = eval("(" + sheetObj.SumValue(0,"coa_bkg_op")+ "/" + sheetObj.SumValue(0, "qta_bkg_op") + ")*100").toFixed(2);
              } else {
                  sheetObj.SumValue(0, "op_chng") = "0";
              }
              if(parseInt(sheetObj.SumValue(0, "qta_load")) > 0){
                  sheetObj.SumValue(0,"qta_opb") = eval(sheetObj.SumValue(0,"qta_bkg_op")+"/"+sheetObj.SumValue(0, "qta_load")).toFixed(2);
              } else {
                  sheetObj.SumValue(0,"qta_opb") = "0";
              }
              if(parseInt(sheetObj.SumValue(0, "coa_load")) > 0){
                  sheetObj.SumValue(0,"coa_opb") = eval(sheetObj.SumValue(0,"coa_bkg_op")+"/"+sheetObj.SumValue(0, "coa_load")).toFixed(2);
              } else {
                  sheetObj.SumValue(0,"coa_opb") = "0";
              }
              if(eval(sheetObj.SumValue(0, "qta_opb")) > 0){
                  sheetObj.SumValue(0, "opb_chng") = eval("(" + sheetObj.SumValue(0,"coa_opb")+ "-" + sheetObj.SumValue(0, "qta_opb") + ")").toFixed(2);
              } else {
                  sheetObj.SumValue(0, "opb_chng") = "0";
              }
              if(parseInt(sheetObj.SumValue(0, "qta_bkg_op")) > 0){
                  sheetObj.SumValue(0,"coa_op_chng") = eval("(" + sheetObj.SumValue(0,"coa_op")+"/"+sheetObj.SumValue(0, "qta_bkg_op")+ ")*100").toFixed(2);
              } else {
                  sheetObj.SumValue(0,"coa_op_chng") = "0";
              }
          }
          
          if(parseInt(sheetObj.SumValue(0, "qta_bsa_capa"))>0){
              sheetObj.SumValue(0, "qta_lf") = eval("("+sheetObj.SumValue(0, "qta_load")+"/"+sheetObj.SumValue(0, "qta_bsa_capa")+")*100").toFixed(2);
          }else{
              sheetObj.SumValue(0, "qta_lf") = "0";
          }
          
          if(parseInt(sheetObj.SumValue(0, "coa_bsa_capa"))>0){
              sheetObj.SumValue(0, "coa_lf") = eval("("+sheetObj.SumValue(0, "coa_load")+"/"+sheetObj.SumValue(0, "coa_bsa_capa")+")*100").toFixed(2);
          }else{
              sheetObj.SumValue(0, "coa_lf") = "0";
          }       
          sheetObj.SumValue(0, "lf_chng") = eval(sheetObj.SumValue(0,"coa_lf")+"-"+ sheetObj.SumValue(0, "qta_lf"));
          
          if(getComboObjValue(formObj.f_ofc_lvl1) == "1" && getComboObjValue(formObj.f_ofc_cd) == "" && !formObj.f_ofc_sts.checked && !formObj.f_rf_sts.checked){
              sheetObj.ColHidden("qta_bsa_capa")  = false;
              sheetObj.ColHidden("coa_bsa_capa")  = false;
              sheetObj.ColHidden("bsa_capa_chng") = false;
              
              sheetObj.ColHidden("qta_lf")        = false;
              sheetObj.ColHidden("coa_lf")        = false;
              sheetObj.ColHidden("lf_chng")       = false;
          } else {
              sheetObj.ColHidden("qta_bsa_capa")  = true;
              sheetObj.ColHidden("coa_bsa_capa")  = true;
              sheetObj.ColHidden("bsa_capa_chng") = true;
              
              sheetObj.ColHidden("qta_lf")        = true;
              sheetObj.ColHidden("coa_lf")        = true;
              sheetObj.ColHidden("lf_chng")       = true;
          }
          
          if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C" && formObj.f_rf_sts.checked){ //Office Profit, Contract, not Reefer
              sheetObj.ColHidden("coa_branchCM")     = true;
              sheetObj.ColHidden("coa_branch_chng")  = true;
              
              sheetObj.ColHidden("oth_abc_svc")  = true;
              sheetObj.ColHidden("stp_rev")      = true;
              sheetObj.ColHidden("balance_svc")  = true;
              sheetObj.ColHidden("oth_abc_cont") = true;
              sheetObj.ColHidden("stp_cost")     = true;
              sheetObj.ColHidden("balance_cont") = true;
              sheetObj.ColHidden("stp_profit")   = true;
          } else {
              sheetObj.ColHidden("coa_branchCM")     = false;
              sheetObj.ColHidden("coa_branch_chng")  = false;
              
              sheetObj.ColHidden("oth_abc_svc")  = false;
              sheetObj.ColHidden("stp_rev")      = false;
              sheetObj.ColHidden("balance_svc")  = false;
              sheetObj.ColHidden("oth_abc_cont") = false;
              sheetObj.ColHidden("stp_cost")     = false;
              sheetObj.ColHidden("balance_cont") = false;
              sheetObj.ColHidden("stp_profit")   = false;
          }
          
          if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_ofc_vw) == "C" && getComboObjValue(formObj.f_pro_lvl) == "O" && formObj.f_rf_sts.checked){
              sheetObj.ColHidden("coa_op")        = true;
              sheetObj.ColHidden("coa_op_chng")   = true;
          } else {
              sheetObj.ColHidden("coa_op")        = false;
              sheetObj.ColHidden("coa_op_chng")   = false;
          }
          
          // Customer 부분에 값이 존재 할 경우 Capa 와 LF 숨김
          if(    formObj.f_view_cust.value == "Y" &&
          	   (getComboObjValue(formObj.f_key_acct_group_cd) != ""
      		|| getComboObjValue(formObj.f_ra_acct_group_cd)  != ""
      		|| formObj.f_otr_key_acct.checked
      		|| formObj.f_otr_regional_acct.checked)
      		|| formObj.f_gcust_sts.checked) {
          	
          	sheetObj.ColHidden("qta_bsa_capa")  = true;
              sheetObj.ColHidden("coa_bsa_capa")  = true;
              sheetObj.ColHidden("bsa_capa_chng") = true;
              
              sheetObj.ColHidden("qta_lf")        = true;
              sheetObj.ColHidden("coa_lf")        = true;
              sheetObj.ColHidden("lf_chng")       = true;
      	}
      }
      
      /**
       * sheet6조회 후 로직 처리 : total 값을 재계산하여 입력한다.
       */
      function sheet6_OnSearchEnd(sheetObj, errMsg){
      	var formObj = document.form;
      	
          sheetObj.SumValue(0, "load_share") = ComParseInt(sheetObj.SumValue(0, "coa_load_share")) - ComParseInt(sheetObj.SumValue(0, "qta_load_share"));
          sheetObj.SumValue(0, "cm_share")   = ComParseInt(sheetObj.SumValue(0, "coa_cm_share")) - ComParseInt(sheetObj.SumValue(0, "qta_cm_share"));
          if(getComboObjValue(formObj.f_pro_vw) == "R" && getComboObjValue(formObj.f_pro_lvl) == "O"){ //Office Profit
              sheetObj.SumValue(0, "op_share")   = ComParseInt(sheetObj.SumValue(0, "coa_op_share")) - ComParseInt(sheetObj.SumValue(0, "qta_op_share"));
          }
      }
      

  	/**
  	* location code 공통 팝업 오픈
  	*/
  	function openLocationCode(funtionNm){
  		//org To일때 팝업오픈, getF_por, getF_del	
  		ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);  	
  	}
  	
  	/**
  	* location code 공통 팝업에서 opener 함수호출
  	*/
    function getPOL(rowArray) {
    	var formObj = document.form;
		var colArray = rowArray[0];
		formObj.f_pol_cd.value = colArray[3];
		formObj.f_pod_cd.focus();
	}

  	/**
  	* location code 공통 팝업에서 opener 함수호출
  	*/
	function getPOD(rowArray) {
    	var formObj = document.form;
		var colArray = rowArray[0];
		formObj.f_pod_cd.value = colArray[3];
	}


    /**
     * Location Check
     */
    function checkLoc_onKeyUp(obj, val) {
    	if(val.length == 5) {
    		 ComCoaCheckLocCd("LOC_CD",obj);  
    	}  
    }

    /**
     * Location Validation Check
     */ 
    function isValidLocation(obj,rtnValue) {
    	var formObj = document.form;
        if(rtnValue == "false") {
            ComShowMessage(ComGetMsg('COA10040'));
            obj.focus();
            obj.value = "";
        } else {
        	formObj.f_pod_cd.focus();
        }
    }
