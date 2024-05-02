/*
 * =========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : Weekly Sales Report By Office 2
 2
'프로그램 ID  : ESM_COA_0071.js
'프로그램 명  : Weekly Sales Report By Office 2
'프로그램개요 : Weekly Sales Report By Office 2
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.11.29
 * =========================================================
 * History
 * 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
 *    변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
 * 2008.02.26 PEJ N200802220016 COA 조회 기간 관련 수정 요청
 *    변경사항 : 2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
 * 2009.02.04 김태윤 N200901190016 - COA_조직개편 관련 기능 수정 changeCostYrmon추가, chgOffice수정
 * 2009.03.10 임옥영 R200903100006   COA Office Report-Graph 오류 RD_path 주석처리 
 * 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
 * 2009.10.21 김기식 Alps전환작업 
 * 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
 * 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
 * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
 * 2011.05.11 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
 * 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
 * =========================================================
 */

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0071 : ESM_COA_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0071() {
	this.processButtonClick = processButtonClick;
	this.initSheet = initSheet;
	this.loadPage = loadPage;
	this.setSheetObject = setSheetObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.clearDatePeriod = clearDatePeriod;
	this.chgOffice = chgOffice;
	this.changeCostYrmon = changeCostYrmon;
	this.setPeriod = setPeriod;
	this.cobTrade_OnChange = cobTrade_OnChange;
	this.f_sub_trd_cd_OnChange = f_sub_trd_cd_OnChange;
	this.doActionIBSheet = doActionIBSheet;
	this.rdOpen = rdOpen;
	this.chkValidSearch = chkValidSearch;
	this.validateForm = validateForm;
}
﻿
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
      
    /**  
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var formObject = document.form;
        var sheetObject = sheetObjects[0];
        
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
                case "btn_retrieve":
                    formObject.f_cmd.value = SEARCHLIST01;
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                
                case "btn_new":
                    sheetObject.RemoveAll();
                    formObject.reset();
                    break;
                
                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
     * 멀티콤보 처리
     * - Tab 기본 설정
     * - 탭의 항목을 설정한다.
     */
	function initCombo(comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300;
			Index = 0;
			
			if(comboObj.id == "f_ofc_cd"){
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    		MaxLength = 6;
	    	} else if(comboObj.id == "f_cob_trade"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 3;
	    	} else if(comboObj.id == "f_cob_subtrade"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 2;
	    	} else if(comboObj.id == "f_cob_lane"){
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    		MaxLength = 5;
	    	} else if(comboObj.id == "f_cob_bound"){
	    		ValidChar(2,0); // 영어대문자 사용
	    		MaxLength = 1;
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
        
        switch(sheetNo) {
            case 1:      //t1Sheet1 init
                with (sheetObj) {
                    style.height=0;
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                                           //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1,4, 100);                                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo( 9, 0, 2, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false);         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = "DIVISION|DIVISION|CM ($1000)|CMB|GREV (1000F)|GRPB|LOAD (TEU)|BSA (TEU)|L/F" ;
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadColumn(0, "Accumulated\nY.T.D|Accumulated\nY.T.D|Accumulated\nY.T.D|Accumulated\nY.T.D|Accumulated\nY.T.D"); //해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
                    InitHeadColumn(1, "PFMC|QTA|Attainment|Previous yr|Change");
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtData,     80,     daCenter,   true,   "a1",   false,      "",     dfNone,         0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     100,    daCenter,   false,  "a2",   false,      "",     dfNone,         0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     75,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     75,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     80,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     75,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     75,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     75,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,    false,  "",     false,      "",     dfInteger,      0,      true,   true);
                    
                    CellBackColor(1,"a1") = RgbColor(222, 251, 248);   // ENIS
                    CellBackColor(1,"a2") = CellBackColor(1,"a1");
                    CellBackColor(2,"a2") = CellBackColor(1,"a1");
                    CellBackColor(4,"a2") = CellBackColor(1,"a1");
                    
                    RowBackColor(3) = RgbColor(251, 230, 230);
                    RowBackColor(5) = RgbColor(251, 230, 230);
                    
                    //CountPosition = 0 ;
                }
                break;
        }
    }

    /**
     * Object 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 var formObject = document.form;  
    	loadingMode = true;
    	rdObjects[0].HideToolbar();
    	sheetObjects[0].Visible = false;
    	
    	//화면 초기화시에 RD를 로딩하기 위한 처리
        //---------------------------------------------------
        formObject.f_cmd.value = SEARCH;
        formObject.f_fm_mon.value = "00";
        formObject.f_to_mon.value = "00";
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        formObject.f_fm_mon.value = "";
        formObject.f_to_mon.value = "";
        //---------------------------------------------------

 		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
 		for (k = 0; k < comboObjects.length; k++) {
 			initCombo(comboObjects[k], k + 1);
 		}
 		
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        loadingMode = false;
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
     * 
     */ 
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
//        sheetObj.RowBackColor(3) = RgbColor(251, 230, 230);
//        sheetObj.RowBackColor(5) = RgbColor(251, 230, 230);
    }

    
    /**
     * Seq를 선택하면 Date Period를 clear한다.
     */
    function clearDatePeriod(){
        document.form.f_fm_wk.value = "";
        document.form.f_to_wk.value = "";
        document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
    }
     /**
      * Office Level 변경시 Office combo변경
      */
     function f_ofc_lvl_OnChange(obj, code){
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
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0071GS2.do", coaFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_ofc_cd, "code", "code");
 			formObj.f_ofc_cd.Index=0;
         }

    }

     /*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){
        if(val != '') chgOffice(document.form.f_ofc_lvl);
    }
    //changeCostYrmon
    
    /**
     * month week가 변경되었을때 date period를 변경한다.
     */
    function setPeriod(obj){
    	ComCoaSetPeriod(obj);
    }
    /**
     * trade변경시 R.Lane combo변경
     */
	function f_cob_trade_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST11;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0071GS2.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			loadingMode = true;
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_cob_subtrade, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_cob_lane, "code", "code");
			formObj.f_cob_subtrade.Index = 0;
			formObj.f_cob_lane.Index = 0;
			loadingMode = false;
			
		}
	}
	
	/**
	* ifram을 이용하여 R.Lane 표시
    */
	function f_cob_subtrade_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST12;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0071GS2.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_cob_lane, "code", "code");
			formObj.f_cob_lane.Index = 0;
		}
	}
	
	/**
     *
     */
    function rdOpen(rdObject,formObject, xml) {
        var Rdviewer = rdObject ;
        
        Rdviewer.AutoAdjust = 0; // 0:ZoomRatio에 맞춤, 1:화면사이즈맞춤, 2:가로비율에 맞춤
        Rdviewer.ZoomRatio = 90;
        Rdviewer.HideToolbar();
        Rdviewer.HideStatusbar();
        Rdviewer.ViewShowMode(2);        
        
        Rdviewer.setbackgroundcolor(255,255,255);
        Rdviewer.SetPageLineColor(255,255,255);
        Rdviewer.SetRData(xml);
        Rdviewer.FileOpen( RD_path + "apps/alps/esm/coa/multidimensionrpt/salesrpt/report/ESM_COA_0071.mrd", "");
    }
    
    /**
     *  Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var rdObject = rdObjects[0];
        
        switch(sAction) {
        	case IBCLEAR:          //조회
        	
	        	formObj.f_year.value = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0071GS2.do", coaFormQueryString(formObj));
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml = sXml.split("|$$|");
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        		        
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_ofc_lvl, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_ofc_cd, "code", "code");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_cob_trade, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_cob_subtrade, "code", "code");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], formObj.f_cob_lane, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], formObj.f_cob_bound, "code", "code");
				
				
				ComOpenWait(false);
				break;
				
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
                formObj.f_cmd.value = SEARCHLIST01;
                var xml = sheetObj.GetSearchXml("ESM_COA_0071GS.do", coaFormQueryString(formObj));
                sheetObj.LoadSearchXml(xml);
                var rdXml = sheetObj.EtcData("rdXml");
                sheetObj.RemoveEtcData();
                rdOpen(rdObject,formObj,rdXml) ;
                ComOpenWait(false);

                break;
        }
    }
    
    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;
        var rtnValue = false;
        
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
	                ComShowCodeMessage("COA10011","Month","From","To");
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
            if (f_cmd.value == SEARCHLIST01){
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
    			
                if(f_fm_mon.value != "" && f_to_mon.value != ""){
                    if((ComParseInt(f_to_mon.value) - ComParseInt(f_fm_mon.value))>= 3){
                        // [COA10003] : Month 는(은) 3달만 처리할수 있습니다.
                         ComShowMessage(ComGetMsg("COA10003", "Month", "3 Month"));
                         f_to_mon.focus();
                         return false;
                    }
                }
                if(f_fm_wk.value != "" && f_to_wk.value != ""){
                    if((ComParseInt(f_to_wk.value) - ComParseInt(f_fm_wk.value))>=10){
                        // [COA10003] : Week 는(은) 10주 만 처리할수 있습니다.
                         ComShowMessage(ComGetMsg("COA10003", "Week", "10 Week"));
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
                
    			if(!chkValidSearch()){
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