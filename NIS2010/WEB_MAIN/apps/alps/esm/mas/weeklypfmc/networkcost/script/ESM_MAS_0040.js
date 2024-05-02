/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0040.js
*@FileTitle : MAS_Port Tariff 관련 스크립트
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2009.04.01 김종열 CSR No.N200903170121  Port Tariff(PA)기능 변경으로 btn_create 추가
                                          -조회(searchPortTariffList)와 생성(createPortTariff) 분리
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>masFormQueryString 변경 
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.05.06 이행지 CHM-201003663-Port tariff vessel class 변경
* 2010.05.20 이행지 CHM-201003663-M:2010-05, W:2010-18  => M:2010-07,W:2010-27 부터 VSL_CLSS_CAPA 적용하도록
* 2010.06.23 이행지 CHM-201003663-M:2010-07, W:2010-27  => M:2010-08,W:2010-31 부터 VSL_CLSS_CAPA 적용하도록
* 2010.07.29 이윤정 CHM-201005034-M:2010-08, W:2010-31  => M:2010-10,W:2010-40 부터 VSL_CLSS_CAPA 적용하도록
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.06.16 최성민 [CHM-201111497-01] MAS 운항일수 산정 로직 변경 - 스크립트 오류수정
* 2011.07.01 이석준 [CHM-201111498-01] Port Tariff를 VVD별로 PSO와 I/F를 통해 단가 생성토록 수정
* 2012.06.25 이석준 [CHM-201218363-01] Creation Message를 hardcoding에서 message처리토록 수정
* 2012.11.13 원종규 [CHM-201221358] Port tariff 기간 조회 시 팝업 관련 수정 요청: 주차 변경시 VALIDATION MSG 무한루프 현상 
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.05.07 최성민 [CHM-201324181] [MAS] Port tariff 로직 수정
* =========================================================
*/ 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0040 : ESM_MAS_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0040() {
    this.processButtonClick     = processButtonClick   ;  
    this.setYrWk                = setYrWk              ;
    this.setYrMon               = setYrMon             ;
    this.setPeriod              = setPeriod            ;
    this.set_Zoom               = set_Zoom             ;
    this.loadPage               = loadPage             ;
    this.initSheet              = initSheet            ;
    this.setSheetObject         = setSheetObject       ;
    this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd   ;
    this.sheet1_OnSaveEnd       = sheet1_OnSaveEnd     ;
    this.sheet1_OnChange        = sheet1_OnChange      ;
    this.doActionIBSheet        = doActionIBSheet      ;
    this.validateForm           = validateForm         ;
    this.isValidNode            = isValidNode          ;
    this.Dup_CheckForm          = Dup_CheckForm        ;
    this.Null_CheckForm         = Null_CheckForm       ;
    this.ComAddSeparator_Local  = ComAddSeparator_Local;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height = 20; // sheet의 height
var zoomFlag = "close"; // Zoom Flag

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

var sRow = 0;

var pop_rtn_value = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Create":
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;

                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_Save":
                	
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btn_rowadd":		// 현재 사용하지 않음.
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                case "bu_zoom_in":
                    sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
                    sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
                    zoomFlag = "open";
                    set_Zoom();
                    break;
                    
                case "bu_zoom_out":
                    sheetObject.style.height = sheetObject.GetSheetHeight(13);
                    zoomFlag = "close";
                    set_Zoom();
                    break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013','25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */
    function setYrWk(fYear,prevWeek){
        var formObj = document.form;
        with(formObj){
            var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;
            f_yearweek.dataformat = "yw";
            //if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            //if(!ComAddSeparator(f_yearweek)) return false;
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            f_yearweek.select();
            // 기간 표시
            setPeriod(f_yearweek);
        }
        fnYearWeekSet(document.getElementById("f_yearweek"));
    }

    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */
    function setYrMon(){
        var formObj = document.form;
        with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm");
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
            var nowYrMon = nowYear + nowMon;
            f_yearweek.value = nowYrMon;
            f_yearweek.dataformat = "ym";
            //isValidYYYYMM(f_yearweek,true,'-',true);
            if(!ComAddSeparator(f_yearweek)) return false;
            f_yearweek.select();
            // 기간 표시
            setPeriod(f_yearweek);
        }
        fnYearWeekSet(document.getElementById("f_yearweek"));
    }

    function fnYearWeekSet(obj){
        if ( document.form.f_yrtype[0].checked ) {
            obj.value = ComGetMaskedValue(obj.value,"ym");
        } else {
            obj.value = ComGetMaskedValue(obj.value,"yw");
        }
        setPeriod(obj);
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
        var formObj = document.form;
        if (formObj.f_yrtype[0].checked) {
        	sheetObjects[0].ColHidden("cost_wk") = true;
        }
        ComMasSetPeriod2(obj);
    }

    //화면의 Zoom 처리
    function set_Zoom() {
        if (zoomFlag == "open") {
            div_zoom_in.style.display  = "none";
            div_zoom_out.style.display = "inline";
            if (parent && parent.syncHeight) {
            	parent.syncHeight();
            }
        } else if (zoomFlag == "close") {
            div_zoom_in.style.display  = "inline";
            div_zoom_out.style.display = "none";
            if (parent && parent.syncHeight) {
            	parent.syncHeight();
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
        
        initControl();
    }
     
     /**
      * Axon 이벤트를 처리하기 위하여 EVENT를 CATCH 한다. <br>
      */
     function initControl() {
         //Axon 이벤트 처리1. 이벤트 catch
         axon_event.addListenerForm('blur', 'obj_blur', form); 
         axon_event.addListenerForm('focus', 'obj_focus', form);
     } 
     
 	/**
      * OnBlur 이벤트 발생시 호출되는 function <br>
      * format 및 validation 확인 <br>
      * <br><b>Example :</b>
      * <pre>
      *	
      * </pre>
      * @return 없음
      * @author 원종규
      * @version 2012.11.12
      */
   	function obj_blur() { 
    	  
   	 switch(event.srcElement.name) { 
   	 
   	 	case "f_yearweek":
	   		if(!ComAddSeparator(event.srcElement)) return false;   		
	   		setPeriod(event.srcElement);	   		
	   		break;	
   	 }   	 
   	}
      
	/**
   * OnFocus 이벤트 발생시 호출되는 function <br>
   * <br><b>Example :</b>
   * <pre>
   *	
   * </pre>
   * @return 없음
   * @author 원종규
   * @version 2012.11.12
   */
 	function obj_focus() {
		
		switch(event.srcElement.name) {
		
			case "f_yearweek":
		   		ComClearSeparator(event.srcElement,'','-');  
		   		event.srcElement.select();
		   		break;
		   		
		} 
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
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msNone;                                //전체Merge 종류 [선택, Default msNone]
                    InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(16, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, true, true, true,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|SEL||Status|YYYY-MM|Week|S.Lane|Vessel|Voyage|Dir.|Trade Dir.|TTL Exp.|TTL Exp(PSO)|Additional Cost|Final Cost|TTL Exp(Previous VVD)";                   
                    InitHeadRow(0, HeadTitle, false);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    Editable = true; 
//                  //데이터속성                [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC,     DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,  SORTENABLE, TOOLTIP,    ALLCHECK,   SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHiddenStatus,     50,     daCenter,   false,      "ibflag");
                    InitDataProperty(0,     cnt++,  dtCheckBox, 	    50,     daCenter,   false,      "chk_flag"             );
                    InitDataProperty(0,     cnt++,  dtHidden   , 	    50,     daCenter,   false,      "pso_max_seq"             ); // PSO에서 MAX SEQ값.
                    InitDataProperty(0,     cnt++,  dtCombo,     		50,     daCenter,   false,      "cost_sts",             false,      "",             dfNone,         0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,   		    100,     daCenter,   true,      "cost_yrmon",           false,      "",             dfDateYm,       0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,  		    60,     daCenter,   true,       "cost_wk",              false,      "",             dfNone,         0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,  		    100,     daCenter,   true,      "slan_cd",              false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,   		    100,     daCenter,   true,      "vsl_cd",               false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,    		    100,     daCenter,   true,      "skd_voy_no",           false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,   		    60,     daCenter,   true,       "skd_dir_cd",           false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,   		    80,     daCenter,   true,       "hul_bnd_cd",           false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    150,    daRight,    true,       "pso_cost_org_amt",     false,      "",             dfFloatOrg,     2,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    150,    daRight,    true,       "pso_cost_pso_ttl_amt", false,      "",             dfFloatOrg,     2,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    150,    daRight,    true,       "pso_cost_add_amt",     false,      "",             dfFloatOrg,     2,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    150,    daRight,    true,       "pso_cost_ttl_amt",     false,      "",             dfFloatOrg,     2,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    150,    daRight,    true,       "pre_vvd_amt",          false,      "",             dfFloatOrg,     2,          false,      false);
                    
                    InitDataCombo (0, "cost_sts", "C|E|T|N", "C|E|T|N");
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "slan_cd", vtEngOnly);                 // slan_cd
//                    InitDataValid(0, "port", vtEngUpOnly);                  // port
//                    InitDataValid(0, "cy", vtEngUpOther, "0123456789");     // cy

                    CountPosition  = 2 ;
                    style.height = GetSheetHeight(19) ;
                }
                break;

        }
    }

//  //1컬럼이 숨겨진 여부를 확인하여 숨겨진 경우 표시되도록 설정한다.
//  if (mySheet.ColHidden(3)) {
//    mySheet.ColHidden(3) = false
//  }
//
//  //1컬럼의 SaveName이 "cost_wk"인 경우
//  mySheet.ColHidden("cost_wk") = false

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";

        // YYYY-MM 선택시 WEEK정보가 보이지 않도록 변경 2010.03.11
        var formObj = document.form;
        if ( formObj.f_yrtype[0].checked ) {
        	sheetObjects[0].ColHidden("cost_wk") = true;
        } else if ( formObj.f_yrtype[1].checked ) {
        	sheetObjects[0].ColHidden("cost_wk") = false;
        }
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	if (Col == "chk_flag"){
          ComSyncAllCheck(sheetObj, "chk_flag", Value);
    	}
    }

    /**
     * sheet1을 더블클릭하여 상세조회한다
     */
     function sheet1_OnDblClick(sheetObj , row, col){
    	 var formObj = document.form;
    	 var monWeek = "";

    	 if ( formObj.f_yrtype[0].checked ) {
    		 monWeek = ComGetMaskedValue(formObj.f_yearweek.value,"ym");
         } else {
        	 monWeek = ComGetMaskedValue(formObj.f_yearweek.value,"yw");
         }
    	  	 
    	 var param =  "slan_cd="+sheetObj.CellValue(row,"slan_cd")
    	            + "&vsl_cd="+sheetObj.CellValue(row,"vsl_cd")+"&skd_voy_no="+sheetObj.CellValue(row,"skd_voy_no")+"&skd_dir_cd="+sheetObj.CellValue(row,"skd_dir_cd")
    	            + "&f_yrtype="+ComGetObjValue(formObj.f_yrtype)+"&f_yearweek="+monWeek
    	            + "&f_selrlane="+ComGetObjValue(formObj.f_selrlane);    	   	 
    	 
    	 pop_rtn_value = ComOpenPopup("/hanjin/ESM_MAS_0181.do?"+param, 850, 500, "actionAfter0181", "0,0", true);
    	 
    	 if (pop_rtn_value==undefined || pop_rtn_value==null) {
    		 pop_rtn_value = "false|0";
    	 }
    		 var pop_value = pop_rtn_value.split("|");
  
    	 
    		 if (pop_value[0] == "true") { // popup에서 저장 한 적이 있으면...
    			 sheetObj.CellValue2(row,"pso_cost_ttl_amt") = pop_value[1];
//    		 doActionIBSheet(sheetObj, document.form, IBSEARCH);
    		 }     
    	 }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리
		
    	var yearweek = formObj.f_yearweek.value.replace("-","");
    	var yearmonwk = eval(yearweek) ;

        switch(sAction) {

			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0040GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], formObj.f_selslane, "code", "name");
					formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"),ComGetEtcData(arrXml[0],"prevWeek"))};
				}
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");

		        setYrMon();  // 월/주 입력 창에 금월 셋팅
		
				ComOpenWait(false);
				break;	

        	case IBCREATE:      //생성
                ComAddSeparator_Local(formObj.f_yearweek, "-");
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
				ComOpenWait(true);
				
				var iCheckRow = sheetObj.CheckedRows("chk_flag");
				
				if (iCheckRow ==0 ) {
				    ComShowCodeMessage("MAS00011");
					ComOpenWait(false);
					break;
				}
				
                formObj.f_cmd.value = MULTI02;
                //addDash(formObj.f_yearweek,4);

                if ( formObj.f_yrtype[0].checked ) { //YYYY-MM
                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"ym");
                	if ( yearmonwk < 201010 ){
                		ComShowCodeMessage("MAS10057");
                		ComOpenWait(false);
                		break;
                	}
                } else {//YYYY-WW
                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"yw");
	            	if ( yearmonwk < 201040 ){
                		ComShowCodeMessage("MAS10057");
	            		ComOpenWait(false);
	            		break;
	            	}
                }
                
                                
                var sParam = ComGetSaveString(sheetObj, false);
				sParam += "&" + masFormQueryString(formObj);
                
//                sheetObj.DoSearch4Post("ESM_MAS_0040GS.do", masFormQueryString(formObj));
                
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0040GS.do", sParam);
				sheetObjects[0].LoadSearchXml(sXml);
				ComOpenWait(false);
				var statusCode = ComGetEtcData(sXml, "BatchStatus" );
				switch(statusCode){
					case "4"://작업실행완료						
						ComShowMessage(ComGetMsg("MAS10066", "Port Expense Calculation", "10")); 
						break;
					case "5":// Error 발생
						ComShowMessage("Port Expense Simulation Excution");
						break;
					case "6"://해당 작업이 진행 중 
						ComShowCodeMessage("MAS00003", "Port Expense Simulation");
						break;
					default: break;							
				}                

				if (statusCode =="4"){
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST01;
					sheetObj.DoSearch4Post("ESM_MAS_0040GS.do", masFormQueryString(formObj));
					ComOpenWait(false);
				}
                
                break;

            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;

				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                if ( formObj.f_yrtype[0].checked ) {
                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"ym");
                } else {
                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"yw");
                }

                if  (formObj.f_yrtype[0].checked){
                    sheetObj.ColHidden("cost_wk") = true;
                }else if (formObj.f_yrtype[1].checked){
                    sheetObj.ColHidden("cost_wk") = false;
                };
                                
                sheetObj.DoSearch4Post("ESM_MAS_0040GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                ComAddSeparator_Local(formObj.f_yearweek, "-");

                if(!validateForm(sheetObj,formObj,sAction)) return false;

    				ComOpenWait(true);

    				 formObj.f_cmd.value = MULTI01;
    				 
    				// PSO DATA중 0인 값을 MAS로 SAVE하려는지 확인
     				var pso_save_flag = true;
    				//cre_usr_id가 Null인것은 IB Flag를 'I'로 강제 setting
    				for(var i=sheetObj.HeaderRows;i<=(sheetObj.RowCount + sheetObj.HeaderRows -1);i++) {
    					if (sheetObj.CellValue(i,"pso_cost_pso_ttl_amt") == 0 && sheetObj.CellValue(i,"chk_flag")==1 ) { // 0값이 존재하는 Port가 있으면 message를 뿌려준다.
    						pso_save_flag = false;
    						break;
    					}
    				}    	
    				
    				if (pso_save_flag){ // Save 해도 되면 
	    				// create status를 가진 것 중 check flag="Y" 인것을 찾아서 표시해준다.
	    				var chk_cnt = getMasDataList(sheetObj);
	    				
//	    				if (chk_msg !="" || chk_msg ==null){
	    				if (chk_cnt >0){
	    					
//	    					chk_msg += "====================\n";    
	    					chk_msg = "Overwrite MAS Data for "+chk_cnt+" VVDs?\n";
	    				  if (ComShowConfirm(chk_msg)){
	    					sheetObj.DoSave("ESM_MAS_0040GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
	    				  }
	    				} else {
	    					sheetObj.DoSave("ESM_MAS_0040GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
	    				}
    				} else {
    					ComShowMessage(ComGetMsg("MAS10060"));
    				}
                                   
                    ComOpenWait(false);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
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
            if(f_yearweek.value == "") {
                if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }
            if(f_yearweek.value.replace("-","").length != 6) {
                if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }

            if(f_yrtype[0].checked == true){
               //if(!isValidYYYYMM(f_yearweek, false, '-', false)) return false;
               //if(ComIsDate(f_yearweek)) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "ym")) return false;
            }else{
               //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
              //if(ComIsDate(f_yearweek, "yw")) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            }
        }

        return true;
    }

    /**
     * port, cy의 유효성 결과값 반환 (ESM_MAS_5127에서 호출함.)
     */
    function isValidNode(result){
        var sheetObj = sheetObjects[0];

        if(!result){
            ComShowMessage(ComGetMsg("COM12114","Port, CY",""));
//          sheetObj.CellValue(sRow, "port") = "";
//          sheetObj.CellValue(sRow, "cy") = "";
            sheetObj.SelectCell(sRow, "cy");
        }
    }

//    /**
//    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//    */
//    function Dup_CheckForm(sheetObj,formObj,sAction){
//        var rtn = true;
//        with(formObj){
//            var dr = sheetObj.ColValueDup("cost_yrmon|slan_cd|skd_dir_cd|clss_capa|port|cy|locl_curr_cd");
//            if(dr>0){//중복된 값이 있는경우
//                ComShowMessage(ComGetMsg('COM12115', 'DATA'));
//                sheetObj.SelectCell(dr,"cost_yrmon|slan_cd|skd_dir_cd|clss_capa|port|cy|locl_curr_cd");
//                rtn = false;
//            }
////          if(locl_curr_cd==null){
////              ComShowMessage(ComGetMsg('MAS10002', 'Local Curr.'));
////          }
//        }
//        return rtn;
//    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리, 현재 사용하지 않음.
     */
    function Null_CheckForm(sheetObj,formObj,sAction){
        var rt = false;
        if(ComIsNull(sheetObj.CellValue(0 ,"locl_curr_cd"))) {
            ComShowMessage(ComGetMsg('MAS10002', 'locl_curr_cd'));
            ComSetFocus(formObj.locl_curr_cd);
            rt = false;
        } else {
            rt = true;
        }
        return rt;
    }

    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /* 
       다시한번 동일 주차에 대해 재Creation 이후 혹은 재Creation 없이 전체 save
       하고자 할경우에는 메뉴얼로 수정/저장 되어 PSO금액과 다른 MAS 저장값이 
       존재한다는 것을 POP-UP 창으로 알려주어 User가 인식하게끔 해준다.      
    */
    function getMasDataList(sheetObj){
    	var check_flag;
    	var tariff_sts;
    	var rtn_msg="";
	    var rtn_cnt = 0;
    	for(var i=sheetObj.HeaderRows;i <(sheetObj.SearchRows+sheetObj.HeaderRows);i++) {
    		check_flag = sheetObj.CellValue(i,"chk_flag");
    		tariff_sts = sheetObj.CellValue(i,"cost_sts");
    		
    		if (check_flag == 1 && tariff_sts == "C"){
//    			rtn_msg = rtn_msg + sheetObj.CellValue(i,"vsl_cd")+sheetObj.CellValue(i,"skd_voy_no")+sheetObj.CellValue(i,"skd_dir_cd")+"\n";
    			rtn_cnt++;
    		}
    	}
    	return rtn_cnt;
    }
    
    function callModification(){
    	var formObj = document.form;
    	var rtn_value = "";
    	
    	if ( formObj.f_yrtype[0].checked ) {
    		ComShowMessage(ComGetMsg('MAS10026', 'YYYY-WW'));
    		return;
    	}else{ 
    		rtn_value = ComOpenPopup("/hanjin/ESM_MAS_0185.do?&f_yearweek="+formObj.f_yearweek.value, 850, 560, "actionAfter0185", "0,0", true);
    	}
    	
    	if (rtn_value==undefined || rtn_value==null) {
    		rtn_value = "N";
	   	}
    	if(rtn_value == "Y"){
    		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	}
    }