/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1070.js
*@FileTitle : History Report - Surplus Area
*Open Issues :
*Change history :
*@LastModifyDate : * 2014.02.05 신용찬 [CHM-201428796] SELCTY --> SELCOE 로 변경 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 문동선
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1070 : EES_EQR_1070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1070() { 
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
        this.setTabObject           = setTabObject;
        this.sheet1_OnPopupClick = sheet1_OnPopupClick;    
    }
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    var yyyyMm = "";
    
	var rptTtl = "";
    var rptTtlArr = new Array();
	var calcedTpsz = ""; // formula 계산된 tpsz 를 저장하는 변수
	
    var comboObjects = new Array();
    var comboCnt = 0 ;
    
    var mouseFlag = true;
    
    var weekTpArr = new Array("p2","p1","c0","f1","f2","f3","f4","f5","f6","f7");
	
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|S2|S4"; // OT  TYPE SIZE 
    var tpszotCode  = "O2|O4|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|F4|F5|A2|A4|A5";	
	
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";
	// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheet1 = sheetObjects[shtCnt];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
				
			case "btn_New": // 초기화
                sheetObjects[0].RemoveAll();       
				calcedTpsz = ""; // 계산된 tpsz 내역 초기화       
				formObject.fm_yrwk.value="";
				formObject.to_yrwk.value="";
				formObject.loc_type_code.value = "5";
				loc_type_code_onchange();
				formObject.show_detail.checked = false;
				formObject.cntrTpsz.selectedIndex = 1;   // Dry 선택
                tpszChange('D');                         // Dry 선택
                break;	

            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"");
                ComOpenWait(false);
                break;
                
            case "btn_loc_cd":    //Location By 조회 팝업
                var code_type = formObject.loc_type_code.value;
    
				if (code_type == "2" || code_type == "3") { // RCC
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "rcc_cd:loc_cd", "0,1,1,1,1,1", true);
				}else if (code_type == "4" || code_type == "5") { // LCC
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
				}else if (code_type == "6") { // ECC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "7") { // SCC
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
				}	
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
     * 초기 이벤트 등록 
     */
    function initControl() {
         axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');                          //LOC_CD keyup 이벤트 처리
         axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate이벤트에 코드 처리
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
         axon_event.addListener('blur', 'obj_blur', 'loc_cd');                                 //Location  blur 이벤트 처리
         axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //알파벳 대문자,숫자만 입력허용
         axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd');                        //RCC 변경시 이벤트 처리
         axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');          //Location by 변경시 이벤트 처리
         axon_event.addListenerForm('change','form_change',form);
        
         loc_type_code_onchange();   
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
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 
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
        initControl();
        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
        tpszChange('D'); // Dry 선택
        
        var level_cd = document.form.level_cd.value;
        //alert('level_cd : '+ level_cd);
	      /**
	      ## 설명 -  MTY Inventory Simulation by Port & Yard의 User별 office level결정
	        SELCOE          - 1, SELCOE는 Super-user
	        HQ 혹은 지역본부 - 2, 지역본부: 자기 지역 산하의 데이터만 조회&입력&수정 가능
	        서남아          - 3, 입력/수정 불가(또는 SHAAS와 마찬가지로 접근 불가)한 서남아
	                              ofc: 'BAHBA','KWIBA','DOHBA','BDOBA','BLWBA,BTMBA','JKTBA','SRGBA','SUBBA','PENBS','PGUBS','PKGBB','CEBBA,MNLBA','MNLBB','SINBB','BKKBB','SGZBA','DADBA','HANBS,HPOBO','SGNBB'
	        서남아 예외처리  - 4, SHAAS는 원천적으로 해당 메뉴 접근 불가
	        미주 예외처리    - 5, ATLSC와 PHXSC는 미주는 센터에서 본부를 대신하여 업무를 수행함에 RHQ와 동일한 권한을 부여함
	        그외 일반 지점   - 6, Office 단위: 자기 LCC 지역 단위의 데이터까지만 조회&입력&수정 가능
	      **/        
		if (level_cd=='3' || level_cd=='4'){
			// 원천적으로 막는다.
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_New");
			ComBtnDisable("btn_downExcel");        	
		} else {
			// 나머지는 level에 따라서 조회 자체에서 걸르게 된다는 전제로 일단 권한을 풀어준다.
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_downExcel");        	
		}               
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var shtID = sheetObj.id;
		
		if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
    
        switch(shtID) {
            
            case "sheet1":      //sheet1 init
            with (sheetObj) {
                   // 높이 설정
                   style.height = 585;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = false;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, false, false,false);
				   
                   var HeadTitle1 = "LOC|Section/type|code|grp_cd|sort";
                   var HeadTitle2 = "LOC|Section/type|code|grp_cd|sort";
                   for(var i = 0; i < rptTtlArr.length; i++){
                       //for(var j = 0; j < 17; j++){
                       for(var j = 0; j < 18; j++){                    	   
                           HeadTitle1 += "|" + rptTtlArr[i];
                       }
                       HeadTitle2 += "|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|A5";
                   }
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 5;
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     true,       "loc_cd",             false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtData,      170,   daLeft,       true,       "name",               false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "code",               false,  "",      dfNone,          0,     true,      true);
				   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "grp_cd",             false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "sort",               false,  "",      dfNone,          0,     true,      true);
                   for(i = 0; i < rptTtlArr.length; i++){
				   	   var calcLogic = "0*1";
                       if (form.tpsztype.Text != "") {
					   	   var arr_tpsz = form.tpsztype.Text.toLowerCase().split(",");
                           for (var t=0; t < arr_tpsz.length; t++) {
                               calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|";
                           }
                       }
                       InitDataProperty(0, cnt++ , dtData,      60,   daRight,      false,      "ttl_"+rptTtlArr[i],             false,  calcLogic,  dfNumber,       0,     false,      false);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d4_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d5_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d7_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r5_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r9_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "o2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "s2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "o4_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "s4_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a2_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f4_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a4_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f5_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a5_"+rptTtlArr[i],              false,  "",      dfNumber,          0,     true,       true);
                   }
                   
				   WaitImageVisible=false;
                   CountPosition = 0;        
                   AutoRowHeight = false;    // 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
                   
				   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
				   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
				   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
				   
				   ExtendLastCol = false; 
            }
            break;
        }
    }
    
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg = false;  
        switch (sAction) {
		
			case IBSEARCH: // 조회
				if (validateForm(sheetObj, formObj, sAction)) {
				    
					ComOpenWait(true);
					sheetObjects[0].Redraw = false;
					calcedTpsz = ""; // 계산된 tpsz 내역 초기화
					sheetObj.RemoveAll();
					
					formObj.f_cmd.value = SEARCH;
					
					var mainXml = sheetObj.GetSearchXml("EES_EQR_1070GS.do", FormQueryString(formObj));
					rptTtl = ComRtrim(ComGetEtcData(mainXml, "rpt_ttl"),",");
					initSheet(sheetObj, 1);
					sheetObj.LoadSearchXml(mainXml);
					
					search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
					
					calcAllFormula(sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount);
					
					setGridHidden(formObj.tpsztype.Text); // TPSZ hidden 
					sheetObjects[0].Redraw = true;
					ComOpenWait(false);
				}
				break;
				
			case SEARCH02: // Location 유효성 조회
				var code_type = formObj.loc_type_code.value;
				var sParam = "f_cmd=" + SEARCH02 + "&loc_cd=" + formObj.loc_cd.value;
			    var errMsgCd = ""; // 에러시 보여줄 메시지 코드
		        if(code_type == "1"){ // ALL
		            return true;
		        }else if (code_type == "2" || code_type == "3") { // RCC
                    sParam += "&loc_grp_cd="+"R";
					errMsgCd = "EQR01004"; // 'RCC code is invalid.'
                }else if (code_type == "4" || code_type == "5") { // LCC
                    sParam += "&loc_grp_cd="+"L";
					errMsgCd = "EQR01005"; // 'LCC code is invalid.'
                }else if (code_type == "6") { // ECC
                    sParam += "&loc_grp_cd="+"E";
					errMsgCd = "EQR01006"; // 'ECC code is invalid.'
                }else if (code_type == "7") { // SCC
                    sParam += "&loc_grp_cd="+"S";
					errMsgCd = "EQR01007"; // 'SCC code is invalid.'
                }else{
			        return false;
			    }   
				
                var sXml = sheetObj.GetSearchXml("EES_EQR_1070GS.do", sParam);
			    var rccChk = ComGetEtcData(sXml, "rcc_chk");
			   
			    if(rccChk == "F"){
                   ComShowCodeMessage(errMsgCd);
				   formObj.loc_cd.value = "";
				   formObj.loc_cd.focus();
				   formObj.rcc_cd.value = ""; // RCC_CD 
				   return false;
			    }else{
				   formObj.rcc_cd.value = rccChk; // RCC_CD 
				   return true;
				}
			   
                break;    
        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			
			switch(sAction) {
				case IBSEARCH:
				    // Period 조회 조건
		            if(formObj.fm_yrwk.value == ""
                       || formObj.fm_yrwk.value.length != 6
                       || !ComIsWeek(formObj.fm_yrwk.value.substr(4,2))){
                        
                        ComShowCodeMessage("EQR01101", "From Period (YYYYWW)"); // 'Please input {?msg1}.'
						ComSetFocus(formObj.fm_yrwk);
                        return false;
                    }
                    if(formObj.to_yrwk.value == ""
                       || formObj.to_yrwk.value.length != 6
                       || !ComIsWeek(formObj.to_yrwk.value.substr(4,2))){

                        ComShowCodeMessage("EQR01101", "To Period (YYYYWW)"); // 'Please input {?msg1}.'
                        ComSetFocus(formObj.to_yrwk);
                        return false;
                    }
                    if(formObj.fm_yrwk.value > formObj.to_yrwk.value){
                        ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.'
                        ComSetFocus(formObj.to_yrwk);
                        return false;
                    }
                    if((((formObj.to_yrwk.value.substr(0,4)*1-formObj.fm_yrwk.value.substr(0,4)*1)*52)
                        +(formObj.to_yrwk.value.substr(4,2)*1-formObj.fm_yrwk.value.substr(4,2)*1)) > 19){ // 10
                        ComShowCodeMessage("EQR01106", "20 Weeks"); // 'Maximum period is {?msg1}.'
                        ComSetFocus(formObj.to_yrwk);
                        return false;
                    }
					// 과거만 조회 할 수 있음
					if(formObj.fm_yrwk.value >= formObj.curr_yrwk.value){
						ComShowCodeMessage("EQR01101", "past week"); // 'Please input {?msg1}.'
						ComSetFocus(formObj.fm_yrwk);
                        return false;
					}
					if(formObj.to_yrwk.value >= formObj.curr_yrwk.value){
                        ComShowCodeMessage("EQR01101", "past week"); // 'Please input {?msg1}.'
                        ComSetFocus(formObj.to_yrwk);
                        return false;
                    }
					
					// LOC 조회 조건
					if(formObj.loc_type_code.value != "1" && formObj.loc_cd.value == ""){ // ALL 선택 아닌데, loc_cd 값이 없으면
					    ComShowCodeMessage("EQR01101", "Location Code"); // 'Please input {?msg1}.'
						ComSetFocus(formObj.loc_cd);
                        return false;
					}
					
					if(!doActionIBSheet(sheetObj,formObj,SEARCH02)){ // Location 유효성 조회
                        return false;
                    }
				
			        break;
			}
        }
        return true;
    }

   function showDetail(){
       var sheetObj = sheetObjects[0];
	   var formObj  = document.form;
	   if (rptTtl != "") {
	       rptTtlArr = rptTtl.split(",");
		   
	       if(formObj.show_detail.checked == true){
			   for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
			   	   if(sheetObj.CellValue(i,"sort") > 0){
	                    sheetObj.RowHidden(i) = false;
						
						// MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
						if(sheetObj.CellValue(i,"code") == "PL"){
						    var tmpSum = 0;
				            for(var k=0; k<rptTtlArr.length; k++){
				                tmpSum = tmpSum + sheetObj.CellValue(i,"ttl_"+rptTtlArr[k])*1;
				            }
				            if(tmpSum == 0){
				                sheetObj.RowHidden(i) = true;
				            }
						}
						// MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (E)
				   }else if(sheetObj.CellValue(i,"sort") == "0"){
	                    var tmpName = sheetObj.CellValue(i,"name");
	                    sheetObj.CellValue2(i,"name") = tmpName.substr(0,tmpName.length-3)+"(-)";           
	               }
			   }
		   }else{
		   	   for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
	               if(sheetObj.CellValue(i,"sort") > 0){
	                    sheetObj.RowHidden(i) = true;              
	               }else if(sheetObj.CellValue(i,"sort") == "0"){
	                    var tmpName = sheetObj.CellValue(i,"name");
	                    sheetObj.CellValue2(i,"name") = tmpName.substr(0,tmpName.length-3)+"(+)";           
	               }
	           }
		   }
	   }
   }   

    /**
    * 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
   	    var formObj  = document.form;
		
		if(formObj.show_detail.checked == false){ 
			showDetail(); 
		}
	
		with (sheetObj) {
            for(var i = startRow; i < endRow; i++){
                  
				if (CellValue(i, "grp_cd") == "1") {
				    RowBackColor(i) = sheetObj.RgbColor(255,255,255); //흰색
				
				} else if (CellValue(i, "grp_cd") == "2") {
					RowBackColor(i) = sheetObj.WebColor2SysColor("#F6FAFB"); // 푸른색
					
				} else if (CellValue(i, "grp_cd") == "3") {
				    RowBackColor(i) = sheetObj.WebColor2SysColor("#FFEAEA"); // 분홍색
				    
				} else if (CellValue(i, "grp_cd") == "4") {
				     RowBackColor(i) = sheetObj.RgbColor(255,255,255); //흰색
				    
				} else if (CellValue(i, "grp_cd") == "5") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 
                    
                }
          }
       }
	   setTtlColumn();
   }

    // TTL column 의 calclogic 을 셋팅 함
    function setTtlColumn(){
        var sheetObj = sheetObjects[0];

        if (rptTtl != "") {
            rptTtlArr = rptTtl.split(",");
            
            var tpsz_cd  = form.tpsztype.Text;
            var arr_tpsz = tpsz_cd.toLowerCase().split(",");

            for (var k = 0; k < rptTtlArr.length; k++) {
                var calcLogic = "0*1";
                if (tpsz_cd != "") {
                    for (var t = 0; t < arr_tpsz.length; t++) {
                        calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[k] + "|";
                    }
                }
                sheetObj.SelectCell(1, "ttl_" + rptTtlArr[k]);
                
                for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                    // F3, F4 는 calclogic 합계 제외
                    if (sheetObj.CellValue(i, "code")=="F3" || sheetObj.CellValue(i, "code")=="F4"){
                        // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
                        sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k], dtData, daRight, "ttl_"+rptTtlArr[k], "", dfNumber, 0);
                        sheetObj.CellValue2(i,"ttl_"+rptTtlArr[k]) = "";
                    }else{
                        // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
                        sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k], dtData, daRight, "ttl_"+rptTtlArr[k], calcLogic, dfNumber, 0);
                    }
                }
            }
        }
    }
   
	// startRow 부터 endRow 까지, 전체 weeks 의 formula 를 계산함 (보이는 tpsz만)
    function calcAllFormula(startRow, endRow){
        var sheetObj = sheetObjects[0];
        
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.toLowerCase().split(","); // 보여지는 tpsz
        
		if (rptTtl != "") {
			var tpszs = "";
			for(var t=0; t<arr_tpsz.length; t++){ // 보여지는 tpsz 가 계산 된적 있는지 확인
				if (calcedTpsz.indexOf(arr_tpsz[t]) == '-1') { // 계산 된적 없으면
					tpszs = tpszs.concat(arr_tpsz[t] + ",");
					calcedTpsz = calcedTpsz.concat(arr_tpsz[t]);
				}
			}
			tpszs = ComRtrim(tpszs, ",");
			var fomula_flag = false;
			for (var i = startRow; i < endRow; i++) {
				if (sheetObj.CellValue(i, "code") == "F1" && sheetObj.CellValue(i, "loc_cd") != "TTL") {
					calcFormula(i, rptTtl, tpszs); // row 의 tpsz 의 formula 계산
					calcTtlFormula(i, rptTtl, "ttl"); // row 의 ttl column 의 formula 계산
					fomula_flag = true;
				}
			}
			if (fomula_flag) { // formula 계산 대상이 있으면 
				calcTtlFormula(sheetObj.HeaderRows, rptTtl, tpszs+",ttl"); // TTL LOC의 tpsz 의 formula 계산
			}
		}
    }
	
	
   /**
   * row 가 속한 그룹의 weeks 의 , tpszs 의 
   * Surplus MT , Target Volume, Target Ratio Index, MT Performance 를 계산한다.
   * row   : 계산 하는 LOC 에 속한 row
   * weeks : 계산 하는 주차가 , 로 연결된 문장
   * tpszs : 계산 하는 TPSZ가 , 로 연결된 문장
   */
    function calcFormula(row, weeks, tpszs){ 
		var sheetObj = sheetObjects[0];
		
		with(sheetObj){
			var str_row = FindText("loc_cd",CellValue(row,"loc_cd")); // 해당 그룹의 첫 줄
			
			var op_row  = FindText("code","OP",str_row);  // OP
			var do_row  = FindText("code","DO",str_row);  // Domestic Out
			var so_row  = FindText("code","SO",str_row);  // Sublease Out
			var fbb_row = FindText("code","FBB",str_row); // Final Balance
			var f1_row  = FindText("code","F1",str_row);  // Surplus MT
			var f2_row  = FindText("code","F2",str_row);  // Target Volume
			var f3_row  = FindText("code","F3",str_row);  // Target Ratio Index
			var f4_row  = FindText("code","F4",str_row);  // MT Performance
			
			if(f1_row == "-1" || f2_row == "-1" || f3_row == "-1" || f4_row == "-1"){ // formula 계산 대당이 없으면
				return false;
			}
			
			var weekArr = "";
			if(weeks != ""){
				weekArr = weeks.split(",");
			}else{
				return false;
			}
			var tpszArr = "";
			if(tpszs != ""){
                tpszArr = tpszs.toLowerCase().split(",");
            }else{
				return false;
			}
			
			for(var k=0; k<weekArr.length; k++){
				for(var t=0; t<tpszArr.length; t++){
					// [F2] Target Ratio Index 계산  = ( OP + DO + SO ) * F3
					CellValue2(f2_row,tpszArr[t]+"_"+weekArr[k]) = Math.ceil( ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) * CellValue(f3_row,tpszArr[t]+"_"+weekArr[k])*1); // 올림
					
					// [F1] Surplus MT 계산 = FB - F2
					CellValue2(f1_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ).toFixed(0)

					// [F4] MT Performance 계산 = FB / ( OP + DO + SO )
					CellValue2(f4_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 / ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1);
			    }
			}
		}
	}   
	
   /**
   * F3 값이 없는 경우의 formular 계산 (TTL loc 그룹, TTL column )
   * 해당 row 가 속한 그룹의, weeks 의 , tpszs 의 
   * Surplus MT , Target Volume, Target Ratio Index, MT Performance 를 계산한다.
   * row   : 계산 하는 LOC 에 속한 row
   * weeks : 계산 하는 주차가 , 로 연결된 문장
   * tpszs : 계산 하는 TPSZ가 , 로 연결된 문장
   */
	function calcTtlFormula(row, weeks, tpszs){
		var sheetObj = sheetObjects[0];
        
        with (sheetObj) {
			var str_row = FindText("loc_cd",CellValue(row,"loc_cd")); // 해당 그룹의 첫 줄
            var ttl_end_row = GetMergedEndCell(HeaderRows,"loc_cd").split(",")[0]; // 해당 그룹의 마지막 줄
			
            var op_row  = FindText("code","OP",str_row);  // OP
            var do_row  = FindText("code","DO",str_row);  // Domestic Out
            var so_row  = FindText("code","SO",str_row);  // Sublease Out
            var fbb_row = FindText("code","FBB",str_row); // Final Balance
            var f1_row  = FindText("code","F1",str_row);  // Surplus MT
            var f2_row  = FindText("code","F2",str_row);  // Target Volume
            var f3_row  = FindText("code","F3",str_row);  // Target Ratio Index
            var f4_row  = FindText("code","F4",str_row);  // MT Performance
			
			if(f1_row == "-1" || f2_row == "-1" || f3_row == "-1" || f4_row == "-1"){ // formula 계산 대당이 없으면
                return false;
            }
			
			var weekArr = "";
            if(weeks != ""){
                weekArr = weeks.split(",");
            }else{
                return false;
            }
            var tpszArr = "";
            if(tpszs != ""){
                tpszArr = tpszs.toLowerCase().split(",");
            }else{
                return false;
            }
			
            var f2Sum = 0;
			for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
					
					if (tpszArr[t] != "ttl") {
						f2Sum = 0;
						var next_f2_row = FindText("code","F2",ttl_end_row*1+1);
                        while(next_f2_row != -1){
                            f2Sum = f2Sum + CellValue(next_f2_row, tpszArr[t] + "_" + weekArr[k]) * 1;
                            next_f2_row = FindText("code","F2",next_f2_row*1+1);
                        }
						// [F2] TTL 의 Target Ratio Index 계산  = F2들의 합
                        CellValue2(f2_row,tpszArr[t]+"_"+weekArr[k]) = ( f2Sum ).toFixed(0);
					}else{
						// [F2] TTL column 의 Target Ratio Index 계산  = 보이는 tpsz들의 F2 들의 합 ( calcTotal에서 계산 됨 )
					}
					
					// [F3] TTL 의 Target Ratio vs OP 계산 = F2 / ( OP + DO + SO ) 올림
					CellValue2(f3_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 / ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1);
					
                    // [F1] Surplus MT 계산 = FB - F2
                    CellValue2(f1_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ).toFixed(0)
                    
                    // [F4] MT Performance 계산 = FB / ( OP + DO + SO )
                    CellValue2(f4_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 / ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1);
                }
            }
		}
	}
	
   /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
	  with (sheetObj) {

            if(ColSaveName(Col)=="name"){
				if(CellValue(Row,"sort")=="0"){
					var tmpName = CellValue(Row,"name");
					var plus = tmpName.substr(tmpName.length-3,3);
					if(plus == "(+)"){
						for(var i=Row+1; i<=sheetObj.LastRow; i++){
							if(CellValue(Row,"grp_cd")==CellValue(i,"grp_cd")){
								RowHidden(i) = false;
								
								// MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
		                        if(sheetObj.CellValue(i,"code") == "PL"){
		                            var tmpSum = 0;
		                            for(var k=0; k<rptTtlArr.length; k++){
		                                tmpSum = tmpSum + sheetObj.CellValue(i,"ttl_"+rptTtlArr[k])*1;
		                            }
		                            if(tmpSum == 0){
		                                sheetObj.RowHidden(i) = true;
		                            }
		                        }
								// MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (E)
							}else{
								break;
							}
						}
						CellValue2(Row,"name") = tmpName.substr(0,tmpName.length-3)+"(-)";
					}else if(plus == "(-)"){
                        for(var i=Row+1; i<=sheetObj.LastRow; i++){
                            if(CellValue(Row,"grp_cd")==CellValue(i,"grp_cd")){
                                RowHidden(i) = true;
                            }else{
                                break;
                            }
                        }
                        CellValue2(Row,"name") = tmpName.substr(0,tmpName.length-3)+"(+)";
                    }
				}
			}
       }
  }
  
   /**
    * Location Type Code  변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
   function loc_type_code_onchange() {
        if(document.form.loc_type_code.value == "1"){ // ALL 선택            
            ComEnableObject(document.form.btn_loc_cd,  false);  // Location by 돋보기창 비활성화
            document.form.loc_cd.className = "input2";
			document.form.loc_cd.readOnly  = true;
			document.form.loc_cd.value     = "";
        }else{ // ALL 이 아닌 경우
            ComEnableObject(document.form.btn_loc_cd,  true);
			document.form.loc_cd.className = "input1";
            document.form.loc_cd.readOnly  = false;
			document.getElementById("loc_cd").focus();
        }
   }
    
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function obj_keypress() {
        var formObject = document.form;
        switch (event.srcElement.name) {
			case "loc_cd":
                ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
                break;
			
        }
    }

     /**
      * Location  blur 이벤트 처리
      * Location  blur 코드 적합성 체크
      */    
     function loc_cd_onkeyUp() {
         var formObject = document.form;
        if ( formObject.loc_cd.value.length == 5 ) { 
            if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && document.form.loc_cd.value != "") {
                 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
            }
        }
     }

    /**
     * 설  명 :  Combo 기본 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     initCombo(comboObj,comboNo)
     * </pre>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;
        
        switch(comboNo) {       
            // Type Size
            case 1:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
                    var menuname = tpszallText.split('|'); 
                    var menucode = tpszallCode.split('|'); 
                    
                    MultiSelect = true;
                    MaxSelect = menuname.length;
                    MultiSeparator = ",";
                    
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }
    
    /**
     * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     tpszChange('')
     * </pre>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
            comboObjects[0].Code = consTpsz;                              
            break;
        case "D":
            comboObjects[0].Code = consTpszDry;                
            break;
        case "R":
            comboObjects[0].Code = consTpszRfr;
            break;
        case "O":
            comboObjects[0].Code = consTpszOt;
            break;
        case "F":
            comboObjects[0].Code = consTpszFr;
            break;
        }
    }
    
    /**
     * 설  명 : Form Object의 Change Event <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_change()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_change(){
        var srcName = window.event.srcElement.getAttribute("name");

        if ( srcName == "cntrTpsz"){
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
        }
    }
    
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
        var sheetObj = sheetObjects[0]; 
		
		ComOpenWait(true);
		setTtlColumn(); // TTL column 의 calclogic 셋팅
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            if(sheetObj.CellValue(i,"code")=="F1"){
                calcTtlFormula(i, rptTtl, "ttl"); // TTL LOC의 tpsz 의 formula 계산
            }
        }
		ComOpenWait(false);
    }
    
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj = sheetObjects[0];
        var arr_tpsz = tpsz_cd.split(",");
        
        if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
        
        for (var k = 0; k < rptTtlArr.length; k++) { // 주차만큼반복
            for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                    if(consTpszArr[i] == arr_tpsz[j]){
                        sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k])= false;
                        break;
                    }else if(j == arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                        sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k])= true;
                    }
                }       
            }  
        }
    }    
	
    /* 개발자 작업  끝 */