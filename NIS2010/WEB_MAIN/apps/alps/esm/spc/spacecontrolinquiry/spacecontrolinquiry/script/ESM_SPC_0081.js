/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0081.js
*@FileTitle : Loading by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.08.26 김민아
* 1.0 Creation 
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
* 2010.12.20 이준범 [CHM-201007668-01] 정렬기준 변경
* 2011.03.03 이석준 [CHM-201109016-01] BSA Input Button 추가및 버튼 클릭시 PopUp(ESM_SPC_0084)
* 1)보완사항
*  - initDataValue_operator(), subtrade_OnChange() 추가
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Lane 조회조건 추가 및 Full TEU/Mty TEU 각각의 항목 옆에 Full WGT/Mty WGT 항목 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업  
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
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
     * @class ESM_SPC_0081 : ESM_SPC_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0081() {
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
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    var init_duration = '';
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	// try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
   	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
    	            
				case "btn_new":
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
					resetAll();

       				formObject.year.value = init_year;
					formObject.week.value = init_week;  
					formObject.duration.value = init_duration; 
					SpcSearchOptionWeek("week",false,document.form.year.value);
					
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    		
					break;
					
        	    case "btn_downexcel":
   	            	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
        	        break;
        	        
    			case "btn_bsa":
    				var sUrl = "/hanjin/ESM_SPC_0084.do";
  		          ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
    				break;    	
			} // end switch
		//}catch(e) {
		//	if( e == "[object Error]") {
		//		ComShowCodeMessage("COM12111");
		//	} else {
		//		ComShowMessage(e);
		//	}
		//}
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
       
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subtrade").Enable = false;
    	
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week");
     	SpcSearchOptionDuration("duration", 15, 1);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
     	SpcSearchOptionBound("bound",false,true,false,false);
     	
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetResizeFull = true;
		document_onresize();
		
		// Operator Combo 초기화
    	var rtn = getCodeList("Operator", "");
    	initData_operator(rtn[0].split("|"), rtn[1].split("|"));
    	
    	document.form.year.focus();

    	init_year = document.form.year.value; // 년 초기화용
    	init_week = document.form.week.value; // 주차 초기화용
    	init_duration = document.form.duration.value; // 기간 초기화용
    	
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = true;
    	document.getElementById("subtrade").Enable = true;
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
                    // 높이 설정
                    style.height = getSheetHeight(20) ;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    FocusEditMode = default_edit_mode;
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0 , 0, false);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false, false) ;
                    
                    var HeadTitle = "Carrier|Week|Trade|Sub-Trade|Lane|VVD|Bound|BSA|F/M|20F|2H|40F|4H|45F|Full TEU|Full WGT|Mty TEU|Mty WGT|POL|POD";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,    90,    daCenter,   true,    "OPR_CD",	false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daCenter,   true,    "COST_WK",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daCenter,   true,    "TRD_CD",	false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,   true,    "SUB_TRD_CD",false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,   true,    "RLANE_CD",	false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    90,    daCenter,   true,    "VVD",		false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    45,    daCenter,   true,    "DIR_CD",	false,          "",       dfNone,       0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "BASIC_SLOT",false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    45,    daCenter,   true,    "CNTR_TYPE",	false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "CNTR_20",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "CNTR_20H",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "CNTR_40",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "CNTR_40H",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "CNTR_45",	false,          "",       dfInteger,    0,     true,       true);

                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "FULL_TEU",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    55,    daRight,    true,    "FULL_WGT",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daRight,    true,    "MTY_TEU",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    55,    daRight,    true,    "MTY_WGT",	false,          "",       dfInteger,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,   true,    "POL",		false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,   true,    "POD",		false,          "",       dfNone,       0,     true,       true);

               }
                break;
        }
    }
	
    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, quite) {
    	if(quite == undefined) quite = false;
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
            case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                sheetObj.ReDraw=false;
                
                formObj.f_cmd.value = SEARCHLIST;
                var param = SpcFormString(formObj,'f_cmd,year,week,duration,trade,subtrade,rlane_cd,rhq,bound,operator');
                sheetObj.DoSearch4Post("ESM_SPC_0081GS.do", param );
                
                sheetObj.ReDraw=true;     
                break;
			case IBDOWNEXCEL:        //엑셀 다운로드              
				sheetObj.Down2Excel(-1, false, false, true);
              	break;
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var year = formObj.year.value;
        if(year == ""){
        	ComShowMessage(getMsg("SPC90114","Year")); 
            formObj.year.focus();
            return false;
        }
        
        var week = formObj.week.value;
        if(week == ""){
        	ComShowMessage(getMsg("SPC90114","Week")); 
            formObj.week.focus();
            return false;
        }
        
        var duration = formObj.duration.value;
        if(duration == ""){
        	ComShowMessage(getMsg("SPC90114","Duration")); 
            formObj.duration.focus();
            return false;
        }
        
        var trade = formObj.trade.value;
        if(trade == "" || comObjects[0].Code == ""){
        	ComShowMessage(getMsg("SPC90114","Trade")); 
            formObj.trade.focus();
            return false;
        }
        
        var rhq = formObj.rhq.value;
        if(rhq == ""){
        	ComShowMessage(getMsg("SPC90114","RHQ")); 
            formObj.rhq.focus();
            return false;
        }
        
        return true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function initDataValue_operator(){
	    var sheetObj = document.getElementById("operator");
	    with(sheetObj){
	        Index2 = 0;
	    }
	}

    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initData_operator(codes, names){
    	var sheetObj = document.getElementById("operator");
    	var cnt      = 0;

    	with(sheetObj){
    		RemoveAll();
    		SetTitle("Carrier");
    		//SetColWidth("60|250");
    		SetColAlign("left");
    		//ShowCol     = 0;
    		MultiSelect = false;
    		MaxSelect   = 1;
    		DropHeight  = 190;
    		
    		if(codes == undefined || codes == null){
    			return;
    		}
    		
    		if(codes.length > 2){
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for(var i = 0 ; i < codes.length - 1 ; i++){
    			var txt = names[i].split("~");
    			if(txt[1] == "1"){
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		}
    		
    		if(selectCode != ""){
    			Code = selectCode;
    		} else {
    			Index = 0;
    		}
    		Enable = (GetCount() > 1);
    		Enable = !(Index > 1);
    	}
    }
    
    /*
     * Trade OnChange시
     */  	 
    function trade_OnChange_t(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//     	if(value == "" ) return;
    	var repTrade = comObj.GetText(value,0);  
    	comObjects[1].Code2 = ""; //sub trade
    	comObjects[2].Code2 = ""; // lane
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("rlane_cd",true,false,'',value,'',true);	// 0207 SHKIM
    }
    /*
     * Sub Trade OnChange시
     */
    function subtrade_OnChange_t(comObj,value,text ){  
//    	if(text == '||ALL'){   optionAllReset2("subtrade",document.form.trade.Code,"true"); return; } // 0207 SHKIM
    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
   	 
   	 	if(value == "") return;
     	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    		comObjects[2].Code2 = '';
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = '';
    	}
    }
    
    /*
     * lane OnChange시
     */     
    function rlane_cd_OnChange_t(comObj,value,text ){
    	if(value == "" ) return;
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].Code2 = arrLane[0];
    		comObjects[1].Code2 = arrLane[1];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[1].Code2 = comObj.GetText(value,1);  
    	}
    }

    function initDataValue_trade(){
      	var sheetObj = document.getElementById("trade");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }
      
      function initDataValue_subtrade(){
      	var sheetObj = document.getElementById("subtrade");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }
      
      function initDataValue_rlane_cd(){
      	var sheetObj = document.getElementById("rlane_cd");
      	with(sheetObj){
      		Index2 = 0;
      	}
      }  
      
      /**
       * Start Week 의 year 변경시
       * Start Week 의 year 변경시 주차 변경
       */
      function checkWeek(){
      	SpcSearchOptionWeek("week",false,document.form.year.value);
      }         
      /**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
 	 /*
 	  * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
 	  */
 	 function trade_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("trade").focus(); 
 	 }

 	 function subtrade_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("subtrade").focus(); 
 	 }
 	 
 	 function rlane_cd_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("rlane_cd").focus(); 
 	 }
 	 
 	 function trade_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){trade_OnChange_t(combj,value,text)},10);
 	 }

 	 function subtrade_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){subtrade_OnChange_t(combj,value,text)},10);
 	 }
 	 function rlane_cd_OnChange(combj, value, text){
 		 var formObj = document.form;
 		 setTimeout(function(){rlane_cd_OnChange_t(combj,value,text)},10);
 	 }
	/* 개발자 작업  끝 */