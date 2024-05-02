/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1012.js
*@FileTitle : MT Inventory Simulation by Yard
*Open Issues :
*Change history : * 2014.02.05 신용찬 [CHM-201428796] SELCTY --> SELCOE 로 변경 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 문동선
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1012 : EES_EQR_1012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1012() { 
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
        this.setTabObject           = setTabObject;
        this.sheet2_OnPopupClick = sheet2_OnPopupClick;    
    }
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    
    var rptTtl = "";
    var rptTtlArr = new Array();
    var calcedTpsz = ""; // formula 계산된 tpsz 를 저장하는 변수
    
    var comboObjects = new Array();
    var comboCnt = 0 ;
    
	var editAuth = false; // 로그인 한 user 의 편집 권한
    
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //  
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|S2|S4";    // OT  TYPE SIZE 
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
        var sheet2 = sheetObjects[shtCnt];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                break;
            
            case "btn_Save":
                doActionIBSheet(sheetObjects[2],formObject,IBSAVE);
                break;
                
            case "btn_New": // 초기화
                sheetObjects[0].RemoveAll();       
                sheetObjects[1].RemoveAll();  
				sheetObjects[2].RemoveAll(); 
				sheetObjects[3].RemoveAll();  
                calcedTpsz = ""; // 계산된 tpsz 내역 초기화       
				formObject.show_history.checked = false;
                formObject.show_detail.checked = false;
				formObject.trade.Code = "";
				formObject.subtrade.Code = "";
				formObject.lane.Code = "";
				formObject.subconti.Code = "";
                formObject.cntrTpsz.selectedIndex = 1;   // Dry 선택
                tpszChange('D');                         // Dry 선택
                break;  

            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"Head",false,"");
				sheetObjects[1].Down2Excel(-1,true,true,true,"","",false,false,"Location",true,"");
                ComOpenWait(false);
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
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
         axon_event.addListenerForm('change','form_change',form);
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
//        ComBtnDisable("btn_Save"); // Save 버튼 비활성
		

        var level_cd = document.form.level_cd.value;

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
        	editAuth = false;
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        	ComBtnDisable("btn_Save");
        	ComBtnDisable("btn_downExcel");        	
        } else {
        	// 나머지는 level에 따라서 조회 자체에서 걸르게 된다는 전제로 일단 권한을 풀어준다.
        	editAuth = true;
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_New");
        	ComBtnEnable("btn_Save");
        	ComBtnEnable("btn_downExcel");        	
        }         
        
		var formObj = document.form;	
		//Trade, Sub Trade, Lane Multi Select ComboBox
		//[elemName, isAll, isRepTrade, del, isSelect, isPus, isMulti]
	    searchOptionTrade("trade", true, true,"","","",false);

		formObj.trade.Code ="";
	    formObj.subtrade.Code ="";
	    formObj.lane.Code = "";
		setSubcontiEnable();

		doActionIBSheet(sheetObjects[1],formObj,SEARCH04); // Sub-Conti 콤보 조회

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
            case "sheet1":      // sheet1 
            with (sheetObj) {
                   // 높이 설정
                   style.height = 150;
                   //전체 너비 설정
                   SheetWidth = 979;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = false;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 5, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, true, false,false)

                   var HeadTitle1 = "Name|code";
				   var HeadTitle2 = "Name|code";
				   for (var i = 3; i < rptTtlArr.length; i++) { // 현재,미래
				       HeadTitle1 += "|"+rptTtlArr[i]+"|"+rptTtlArr[i]+"|"+rptTtlArr[i]+"|"+rptTtlArr[i] ;
					   HeadTitle2 += "|TEU|L/F|M/Ton|L/F";
				   }

                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,     115,   daLeft,        true,      "name",             false,  "",      dfNone,    0,     false, false);
                   InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,      true,      "code",             false,  "",      dfNone,    0,     false, false);
				   for(var i = 3; i < rptTtlArr.length; i++){   // 현재,미래
                       InitDataProperty(0, cnt++ , dtData,    58,   daRight,      false,      "qty_"+rptTtlArr[i],   false,  "",        dfNullInteger, 0, false, false);
                       InitDataProperty(0, cnt++ , dtData,    45,   daRight,      false,      "lf_"+rptTtlArr[i],    false,  "",        dfNone,        0, false, false);
                       InitDataProperty(0, cnt++ , dtData,    67,   daRight,      false,      "wgt_"+rptTtlArr[i],   false,  "",        dfNullInteger, 0, false, false);
                       InitDataProperty(0, cnt++ , dtData,    45,   daRight,      false,      "wgtlf_"+rptTtlArr[i], false,  "",        dfNone,        0, false, false);
                   }
				   
				   CountPosition = 0;
				   WaitImageVisible=false;
                   SelectHighLight = false; //HighLight를 설정하지 않음
                   
				   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
            }
            break;
			
            case "sheet2":      //sheet2 init
            with (sheetObj) {
                   // 높이 설정
                   style.height = 405; // 585;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge + msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, true, false, false);
                   
                   var HeadTitle1 = "LCC|SCC|Section/type|code|grp_cd|sort";
                   var HeadTitle2 = "LCC|SCC|Section/type|code|grp_cd|sort";
                   for(var i = 0; i < rptTtlArr.length; i++){
                       //for(var j = 0; j < 17; j++){
                       for(var j = 0; j < 18; j++){                    	   
                           HeadTitle1 += "|" + rptTtlArr[i];
                       }
                       HeadTitle2 += "|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|A5";
                   }
				   for(var i = 3; i < rptTtlArr.length; i++){
                       //for(var j = 0; j < 16; j++){
                       for(var j = 0; j < 17; j++){                    	  
                           HeadTitle1 += "|" + rptTtlArr[i];
                       }
                       HeadTitle2 += "|d2_b|d4_b|d5_b|d7_b|r2_b|r5_b|r9_b|o2_b|s2_b|o4_b|s4_b|f2_b|a2_b|f4_b|a4_b|f5_b|a5_b";
                   }
                   
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 5;
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     true,       "lcc_cd",             false,  "",      dfNone,          0,     false,      false);
				   InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     true,       "scc_cd",             false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtData,      170,   daLeft,       true,       "name",               false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "code",               false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "grp_cd",             false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "sort",               false,  "",      dfNone,          0,     false,      false);

                   for(var i = 0; i < rptTtlArr.length; i++){
                       var calcLogic = "0*1";
					   var allLogic  = "0*1";
					   
                       if (form.tpsztype.Text != "") {
					   	   var arr_tpsz = form.tpsztype.Text.toLowerCase().split(",");
						   for (var t = 0; t < arr_tpsz.length; t++) {
						       calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|"; // 보이는 tpsz 의 합
						   }
						   
						   for (var t = 0; t < consTpszArr.length; t++) {
	                           allLogic = allLogic + "+|" + consTpszArr[t].toLowerCase() + "_" + rptTtlArr[i] + "|";    // 모든 tpsz 의 합
	                       }
					   }
                       InitDataProperty(0, cnt++ , dtData,      60,   daRight,      false,      "ttl_"+rptTtlArr[i],    false,  calcLogic, dfInteger,  0, false, false); // 보이는 tpsz 의 합
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);  // 맨앞 D2 유지해야 함. search_end 메서드에서 사용
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d4_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d5_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "d7_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r5_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "r9_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "o2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "s2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "o4_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "s4_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a2_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f4_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a4_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "f5_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6); // 맨 끝 F5 유지해야 함. search_end 메서드에서 사용
                       InitDataProperty(0, cnt++ , dtData,      50,   daRight,      false,      "a5_"+rptTtlArr[i],     false,  "",        dfInteger,  0, true,  true, 6);
                   }
				   
                   for(var i = 3; i < rptTtlArr.length; i++){   // 빨강색 Bold 표시 (현재,미래만)
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "d2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "d4_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "d5_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "d7_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "r2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "r5_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "r9_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "o2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "s2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "o4_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "s4_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "f2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "a2_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "f4_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "a4_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "f5_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
                       InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "a5_b_"+rptTtlArr[i],   false,  "",        dfNone,     0, false, false);
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
            
            case "sheet3":      // sheet3 MULTI 용 히든 시트
            with (sheetObj) {
                   // 높이 설정
                   style.height = 0;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msNone;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(1, 1, 10, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, false, false,false)

                   var HeadTitle = "ibflag|fcast_yrwk|port_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|cntr_qty|tmp_sav_flg";

                   HeadTitleCnt = ComCountHeadTitle(HeadTitle);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,        false,       "ibflag");
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "fcast_yrwk",             false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "port_cd",                false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "invt_sim_tp_cd",         false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cfm_flg",                false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_tpsz_cd",           false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_qty",               false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "tmp_sav_flg",            false,  "",      dfNone,            0,     true,       true);
                   
                   CountPosition = 0;
            }
			break;
			
			case "sheet4":      // sheet4 , MT Out via VL 분배 계산용 임시 sheet (과거 3주의 합) 
            with (sheetObj) {
				   // 높이 설정
                   style.height = 0;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 10, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, false, false,false)

                   var HeadTitle = "lcc_cd|scc_cd|code|ttl_past|d2_past|d4_past|d5_past|d7_past|r2_past|r5_past|r9_past|o2_past|s2_past|o4_past|s4_past|f2_past|a2_past|f4_past|a4_past|f5_past|a5_past";
				   
				   var HeadTitle1 = "lcc_cd|scc_cd|code|ttl_past|past|past|past|past|past|past|past|past|past|past|past|past|past|past|past|past|past";
				   var HeadTitle2 = "lcc_cd|scc_cd|code|ttl|d2|d4|d5|d7|r2|r5|r9|o2|s2|o4|s4|f2|a2|f4|a4|f5|a5";
				   
				   for(var i = 3; i < rptTtlArr.length; i++){
                       //for(var j = 0; j < 16; j++){
                       for(var j = 0; j < 17; j++){                    	   
                           HeadTitle1 += "|" + rptTtlArr[i];
                       }
                       HeadTitle2 += "|d2|d4|d5|d7|r2|r5|r9|o2|s2|o4|s4|f2|a2|f4|a4|f5|a5";
                   }

                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
				   InitHeadRow(1, HeadTitle2, true);
				   
				   var allLogic = "0*1";
				   for (var t = 0; t < consTpszArr.length; t++) {
				       allLogic =  allLogic + "+|" + consTpszArr[t].toLowerCase()+"_past"+ "|";    // 모든 tpsz 의 합
				   }
                   InitDataProperty(0, cnt++ , dtData,     0,   daCenter,     false,      "lcc_cd",      false,  "",       dfNone,     0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daCenter,     false,      "scc_cd",      false,  "",       dfNone,     0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daCenter,     false,      "code",        false,  "",       dfNone,     0, false, false);
                   
				   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "ttl_past",    false,  allLogic, dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d4_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d5_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d7_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r5_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r9_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "o2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "s2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "o4_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "s4_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a2_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f4_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a4_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f5_past",     false,  "",       dfInteger,  0, false, false);
                   InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a5_past",     false,  "",       dfInteger,  0, false, false);
				   
				   for(var i = 3; i < rptTtlArr.length; i++){   // 비율별로 Spasce Available for MT 분배
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d4_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d5_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "d7_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r5_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "r9_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "o2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "s2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "o4_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "s4_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a2_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f4_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a4_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "f5_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                       InitDataProperty(0, cnt++ , dtData,     0,   daRight,      false,      "a5_s_"+rptTtlArr[i],   false,  "",        dfInteger,     0, false, false);
                   }
				   
				   CountPosition = 0;
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
                    sheetObjects[1].Redraw = false;
                    calcedTpsz = ""; // 계산된 tpsz 내역 초기화
					sheetObjects[0].RemoveAll(); // VVD 시트 내용 삭제
					sheetObjects[1].RemoveAll(); // PORT 시트 내용 삭제
					sheetObjects[2].RemoveAll(); // 히든 시트 내용 삭제
					sheetObjects[3].RemoveAll(); // 히든 시트 내용 삭제
					
                    formObj.f_cmd.value = SEARCH;
                    
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1012GS.do", FormQueryString(formObj));
                    
					var arrXml = sXml.split("|$$|");   // 프레임웤에서 시트와 시트사이에 사용하는 문자
	                if (arrXml[0].length > 0) sXml1 = arrXml[0];  
	                if (arrXml[1].length > 0) sXml2 = arrXml[1];
					
					rptTtl = ComRtrim(ComGetEtcData(sXml1, "rpt_ttl"),",");
					rptTtlArr = rptTtl.split(",");

                    initSheet(sheetObjects[0], 1); // 상단 VVD 시트
					initSheet(sheetObjects[1], 2); // 하단 PORT 시트
					initSheet(sheetObjects[3], 4); // MT out via VL 분배 계산을 위한 히든 시트
                    sheetObjects[0].LoadSearchXml(sXml1); // 상단 VVD 시트
					sheetObjects[1].LoadSearchXml(sXml2); // 하단 PORT 시트
                    
                    search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
                    
                    calcAllFormula(sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount);
                    
                    setGridHidden(formObj.tpsztype.Text); // TPSZ hidden 
                    sheetObjects[0].Redraw = true;
                    sheetObjects[1].Redraw = true;
                    ComOpenWait(false);
                }
                break;
            
			case IBSAVE: // sheetObj 는 히든 시트 임 (sheetObjects[2])
                if (validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(true);
                    
                    // 히든 시트 sort ( BCImpl 에서 Sort 된 결과에 따라 처리 됨 )
                    sheetObj.ColumnSort("ibflag|fcast_yrwk|port_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|tmp_sav_flg|cntr_qty");
                    
                    var sParam = sheetObj.GetSaveString();
                    var sXml = sheetObj.GetSaveXml("EES_EQR_1012GS.do", sParam + "&f_cmd=" + MULTI);
                    
                    if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") { // 저장 성공했으면
                        sheetObj.RemoveAll(); // 히든 시트 내용 삭제
                        ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
                    }else{
                        // 에러 메세지 java 에서 뱉음
                    }
                    ComOpenWait(false);
                }
                break;  
            
			case SEARCH04: // Sub-Conti 콤보 조회
				var sXml = sheetObj.GetSearchXml("EES_EQR_1012GS.do", "f_cmd="+SEARCH04+"&trade="+formObj.trade.Code);
                ComXml2ComboItem(sXml, formObj.subconti, "code", "code|name");
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
                    
					// Trade
					if(formObj.trade.Code==""){
						ComShowCodeMessage("EQR01102","Trade"); // 'Please select {?msg1}.'
						return false;
					}
					// S.Trade
					if(formObj.subtrade.Code==""){
						ComShowCodeMessage("EQR01102","Sub Trade"); // 'Please select {?msg1}.'
						return false;
					}
					// Sub-conti
					if(formObj.subconti.enable && formObj.subconti.Code==""){
						ComShowCodeMessage("EQR01102","Sub-Conti"); // 'Please select {?msg1}.'
						return false;
					}
                
                    break;
				case IBSAVE:
					if(sheetObj.RowCount == 0){
						ComShowCodeMessage("EQR01107"); // 'There is no data to save.'
						return false;
					}
					break;	
            }
        }
        return true;
    }

   function showDetail(){
       var sheetObj = sheetObjects[1];
       var formObj  = document.form;
       if (rptTtl != "") {
           
           if(formObj.show_detail.checked == true){
               for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
                   if(sheetObj.CellValue(i,"sort") > 0){
                        sheetObj.RowHidden(i) = false;                        
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

   var past3total = 0; 
    /**
    * 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
        var formObj  = document.form;
        
        if(formObj.show_detail.checked == false){ 
            showDetail(); 
        }
		if (rptTtl == "") {
		    return false;
		}
		
		calcInventoryPlusMinus(sheetObj); // sheet 전체의 Inventory Plus, Inventory Minus 계산
		
        with (sheetObj) {
			// Row 별 색상 표시, 편집 가부 설정
            for(var i = startRow; i < endRow; i++){
                  
                if (CellValue(i, "grp_cd") == "1") {
                    RowBackColor(i) = sheetObj.RgbColor(255,255,254); //흰색
                    RowEditable(i) = false;
                } else if (CellValue(i, "grp_cd") == "2") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#F6FAFB"); // 푸른색 // 246,250,251
                    if(CellValue(i,"sort") > "0" && editAuth){
					    RowEditable(i) = true;
						//CellFontColor(i,"name") = RgbColor(0,0,255);
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
                            for(var k=3; k<rptTtlArr.length; k++){
                                var str_col = SaveNameCol("d2_"+rptTtlArr[k]);
                                var end_col = SaveNameCol("a5_"+rptTtlArr[k]); 
                                RangeBackColor(i, str_col, i, end_col) = RgbColor(255,255,162);
                            }
                        }
                    }else{
                        RowEditable(i) = false;
                    }
                } else if (CellValue(i, "grp_cd") == "3") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#FFEAEA"); // 분홍색 // 255,234,234
					
					if (CellValue(i, "code") == "RL") {// MT Out via VL 인 경우 히든 시트에 합계 입력
					    var newRow = sheetObjects[3].DataInsert(-1);
						sheetObjects[3].CellValue2(newRow,"lcc_cd") = CellValue(i,"lcc_cd");
						sheetObjects[3].CellValue2(newRow,"scc_cd") = CellValue(i,"scc_cd");
						sheetObjects[3].CellValue2(newRow,"code") = CellValue(i,"code");
						
						for(var t = 0; t < consTpszArr.length; t++){
							var tmpSum = 0;
							for (var k = 0; k < 3; k++) {
							    tmpSum = tmpSum + CellValue(i,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k])*1;
							}
							if(consTpszArr[t].substr(1,1) != "2"){
								tmpSum = tmpSum * 2; // TEU 단위 임
							}
							sheetObjects[3].CellValue2(newRow,consTpszArr[t].toLowerCase()+"_past") = tmpSum; //tpsz 별 3주 합을 히든 시트에 입력
						}
					}
					if(CellValue(i,"sort") > "0" && editAuth && CellValue(i,"code") != "PL" ){ // MT Loading Plan 은 수정 X
                        RowEditable(i) = true;
						//CellFontColor(i,"name") = RgbColor(0,0,255);
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
                            for(var k=3; k<rptTtlArr.length; k++){
                                var str_col = SaveNameCol("d2_"+rptTtlArr[k]);
                                var end_col = SaveNameCol("a5_"+rptTtlArr[k]); 
                                RangeBackColor(i, str_col, i, end_col) = RgbColor(255,255,162);
                            }
                        }
						
						
                    }else{
                        RowEditable(i) = false;
                    }
                } else if (CellValue(i, "grp_cd") == "4") { // Balance
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 // 208,236,127
                    RowEditable(i) = false;
                } else {
                    RowEditable(i) = false;
                }
            }
            
			// 과거 주차 회색 표시, 메뉴얼 입력값 빨간색 볼드체
            if (rptTtl != "") {
				
                for(var j = 5; j<=LastCol; j++){ 
                    if(   ColSaveName(j).split("_")[1] == rptTtlArr[0]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[1]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[2]){ // 과거 주차 회색 표시
                        ColBackColor(j) = UnEditableColor; 
						
                    }else if( ColSaveName(j).split("_")[1] == "b"){ // 메뉴얼 입력값은 빨간색 Bold 표시
						var next_bold_row = FindText(j,"Y",HeaderRows); // bold flag 가 Y 인 줄 찾기
                        while(next_bold_row != -1){
							CellFont("FontBold", next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = true;       // Bold
                            CellFontColor(next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = RgbColor(255,0,0); // Red
                            next_bold_row = FindText(j,"Y",next_bold_row*1+1);     // 다음 줄 찾기
                        }
					}
                }
			}
       }
	   
	   // VVD 시트 L/F 에 % 표시
	   var bkgRow  = sheetObjects[0].FindText("code","BKG");
	   var avalRow = sheetObjects[0].FindText("code","AVAL");
	   for (var k = 3; k < rptTtlArr.length; k++) {
			sheetObjects[0].CellValue2(bkgRow, "lf_"+rptTtlArr[k])    = ComRtrim(sheetObjects[0].CellValue(bkgRow, "lf_"+rptTtlArr[k]),"%") + "%";
			sheetObjects[0].CellValue2(bkgRow, "wgtlf_"+rptTtlArr[k]) = ComRtrim(sheetObjects[0].CellValue(bkgRow, "wgtlf_"+rptTtlArr[k]),"%") + "%";
			sheetObjects[0].CellValue2(avalRow, "lf_"+rptTtlArr[k])   = ComRtrim(sheetObjects[0].CellValue(avalRow, "lf_"+rptTtlArr[k]),"%") + "%";
			sheetObjects[0].CellValue2(avalRow, "wgtlf_"+rptTtlArr[k])= ComRtrim(sheetObjects[0].CellValue(avalRow, "wgtlf_"+rptTtlArr[k]),"%") + "%";
	   }
	   
       setTtlColumn();    // ttl column 합계 셋팅
	   calcDistribute();  // BSA 를 과거 실적 비율로 분배함 
	   calcTotalMtPlan(); // Port 시트의 MT Out via VL 총 합을 VVD 시트에 반영함
   }

   // Inventory Plus 와 Inventory Minus 를 계산한다
   // 조회후 한번만 호출 됨
   // 
   function calcInventoryPlusMinus(sheetObj){
   	if (rptTtl != "" && sheetObj.RowCount > 0) { // 조회된 데이터 있을 경우
           rptTtlArr = rptTtl.split(",");
           
           // [ Inventory Plus ]
   		var next_inp_row = sheetObj.FindText("code","INP",sheetObj.HeaderRows*1); // Inventory Plus 줄
           while(next_inp_row != -1){
               var inp_grp_str = next_inp_row + 1 ; // Inventory Plus 에 속한 첫줄 : MG
               var inp_grp_end = sheetObj.GetColSameDataRange(next_inp_row,"grp_cd").split("|")[1]*1 ; // Inventory Plus 에 속한 끝줄 : Sublease In
           	
               for (var k = 3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
               	   for(var t = 0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
               		   // Inventory Plus 에 속한 값의 합을 넣음
               		   sheetObj.CellValue2(next_inp_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) = sheetObj.ComputeSum("|"+ consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k] +"|", inp_grp_str, inp_grp_end);
               	   }
               }
               
               next_inp_row = sheetObj.FindText("code","INP",next_inp_row*1+1); // 다음 Inventory Plus 줄
           }
           
           // [ Inventory Minus ]
   		var next_inm_row = sheetObj.FindText("code","INM",sheetObj.HeaderRows*1); // Inventory Minus 줄
           while(next_inm_row != -1){
               var inm_grp_str = next_inm_row + 1 ; // Inventory Minus 에 속한 첫줄 : OP
               var inm_grp_end = sheetObj.GetColSameDataRange(next_inm_row,"grp_cd").split("|")[1]*1 ; // Inventory Minus 에 속한 끝줄 : Sublease Out
           	
               for (var k = 3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
               	for(var t = 0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
               		// Inventory Minus 에 속한 값의 합을 넣음
               		sheetObj.CellValue2(next_inm_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) = sheetObj.ComputeSum("|"+ consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k] +"|", inm_grp_str, inm_grp_end);
               	}
               }
               
               next_inm_row = sheetObj.FindText("code","INM",next_inm_row*1+1); // 다음 Inventory Minus 줄
           }        
                   
   	}
   }   
   
    // TTL column 의 calclogic 을 셋팅 함
    function setTtlColumn(){
        var sheetObj = sheetObjects[1];

        if (rptTtl != "") {
            
            var tpsz_cd  = form.tpsztype.Text;
            var arr_tpsz = tpsz_cd.toLowerCase().split(",");

			for (var k = 0; k < rptTtlArr.length; k++) {
				var calcLogic = "0*1";
				if (tpsz_cd != "") {
					for (var t = 0; t < arr_tpsz.length; t++) {
						calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[k] + "|";
					}
				}
			    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                    // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
                    sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k], dtData, daRight, "ttl_"+rptTtlArr[k], calcLogic, dfNumber, 0);
				}
            }
        }
    }
	
	// 과거 3주의 실적 비율을 토대로  Space Available for MT 를 분배 한다
	function calcDistribute(){
		var avalRow   = sheetObjects[0].FindText("code","AVAL");    // AVAL 의 row
		var bsaRow    = sheetObjects[0].FindText("code","BSA");     // BSA 의 row
		
		var pastTotal = 0;
		if(sheetObjects[3].RowCount > 0){
			pastTotal = sheetObjects[3].ComputeSum("|ttl_past|")*1; // 과거 3주의 총합
		}
		if(pastTotal != 0 && avalRow != -1 && bsaRow != -1){
			
			for (var k = 3; k < rptTtlArr.length; k++) {
			     var teuQty  =  sheetObjects[0].CellValue(avalRow,"qty_"+rptTtlArr[k])*1; // TEU
			     var wgtQty  =  Math.floor(sheetObjects[0].CellValue(avalRow,"wgt_"+rptTtlArr[k])*1 / 2.2); // (Mton/2.2), 내림
			     
				 var vvdQty = 0; // 분배할 TEU
				 if(sheetObjects[0].CellValue(bsaRow,"wgt_"+rptTtlArr[k])!="0" && teuQty > wgtQty ){
				 	vvdQty = wgtQty;
				 }else{
				 	vvdQty = teuQty;
				 }
				 var restDist = vvdQty;
				 for(var i=sheetObjects[3].HeaderRows; i<sheetObjects[3].HeaderRows+sheetObjects[3].RowCount; i++){
                     
					 // 해당 SCC 에서 분배될 양은
					 var sccDist = Math.floor((sheetObjects[3].CellValue(i, "ttl_past")*1 * vvdQty ) / pastTotal );
					 restDist = restDist - sccDist;
					 
					 for(var t=0; t<consTpszArr.length; t++){
					 	 
					     var tpszDist = 0;
					     if (consTpszArr[t].substr(1,1)=="2") { // 20 피트
						 	 tpszDist = Math.floor((sheetObjects[3].CellValue(i, consTpszArr[t].toLowerCase() + "_past")*1 * vvdQty ) / pastTotal);
							 sccDist = sccDist - tpszDist;
						 }else{ // 40 피트
						 	 tpszDist = Math.floor(((sheetObjects[3].CellValue(i, consTpszArr[t].toLowerCase() + "_past")*1 * vvdQty ) / pastTotal)/2);
							 sccDist = sccDist - tpszDist*2;
						 }
						 sheetObjects[3].CellValue2(i,consTpszArr[t].toLowerCase()+"_s_"+rptTtlArr[k]) = tpszDist;
					 }
					 // sccDsit 에 남은 양은 다 D2 에
					 sheetObjects[3].CellValue2(i,"d2_s_"+rptTtlArr[k]) = sheetObjects[3].CellValue(i,"d2_s_"+rptTtlArr[k])*1 + sccDist;
				 }
				 // restDsit 에 남은 양은 roof 돌면서 값 있는 SCC 의 d2 에 1씩
				 while(restDist > 0){
					 for(var i=sheetObjects[3].HeaderRows; i<sheetObjects[3].HeaderRows+sheetObjects[3].RowCount; i++){
					 	 if(sheetObjects[3].CellValue(i, "ttl_past") != "0" && restDist > 0){
						 	 sheetObjects[3].CellValue2(i,"d2_s_"+rptTtlArr[k]) = sheetObjects[3].CellValue(i,"d2_s_"+rptTtlArr[k])*1 + 1;
							 restDist = restDist -1;
						 }
					 }
				 }
			}
		}else{ // 과거 실적 전혀 없으면 0
			for (var k = 3; k < rptTtlArr.length; k++) {
			    for (var i = sheetObjects[3].HeaderRows; i < sheetObjects[3].HeaderRows + sheetObjects[3].RowCount; i++) {
				    for (var t = 0; t < consTpszArr.length; t++) {
					    sheetObjects[3].CellValue2(i,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) = 0;
					}
				}
			}
		}
		
		// Port 시트에 값 넣기
		for (var k = 3; k < rptTtlArr.length; k++) {
			for (var i = sheetObjects[3].HeaderRows; i < sheetObjects[3].HeaderRows + sheetObjects[3].RowCount; i++) {
				var lccRow = sheetObjects[1].FindText("lcc_cd",sheetObjects[3].CellValue(i,"lcc_cd"),sheetObjects[1].HeaderRows);
				var sccRow = sheetObjects[1].FindText("scc_cd",sheetObjects[3].CellValue(i,"scc_cd"),lccRow);
				var rlRow  = sheetObjects[1].FindText("code","RL",sccRow);
				var inmRow = sheetObjects[1].FindText("code","INM",sccRow);
				
				for (var t = 0; t < consTpszArr.length; t++) {
					if( sheetObjects[1].CellValue(rlRow,consTpszArr[t].toLowerCase()+"_b_"+rptTtlArr[k]) != "Y"){
						// 분배 계산한 값으로 Port 시트에 반영
						sheetObjects[1].CellValue2(rlRow,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) 
								= sheetObjects[3].CellValue(i,consTpszArr[t].toLowerCase()+"_s_"+rptTtlArr[k]); 
								
						// Inventory Minus 재 계산
						var sccEndRow = sheetObjects[1].GetColSameDataRange(sccRow,"scc_cd").split("|")[1]*1; // 해당 SCC 그룹의 마지막 줄
						var tmpSum = 0;
	                    for(var j=sccRow; j<=sccEndRow; j++){
	                        if(sheetObjects[1].CellValue(j,"grp_cd") == "3" && sheetObjects[1].CellValue(j,"sort") > "0"){
	                            tmpSum = tmpSum + sheetObjects[1].CellValue(j,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k])*1;
	                        }
	                    }
	                    sheetObjects[1].CellValue2(inmRow,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) = tmpSum;		
								
					}else{
						// 메뉴얼 값 유지
					}
				}
			}
		}
	}
	
	// Port 시트의 MtPlan 의 TEU 총 합을 구하여 VVD 시트에 반영함 
	function calcTotalMtPlan(){
		var bsaRow  = sheetObjects[0].FindText("code","BSA");
		var bkgRow  = sheetObjects[0].FindText("code","BKG");
		var plRow   = sheetObjects[0].FindText("code","PL");
		var ttlRow  = sheetObjects[0].FindText("code","TTL");
		
		for (var k = 3; k < rptTtlArr.length; k++) {
			var tmpSum = 0;
			var rlRow  = sheetObjects[1].FindText("code","RL",sheetObjects[1].HeaderRows);
			
			while (rlRow != -1) {
				for (var t = 0; t < consTpszArr.length; t++) {
					if (consTpszArr[t].substr(1, 1) == "2") { // 20피트
						tmpSum = tmpSum + sheetObjects[1].CellValue(rlRow, consTpszArr[t].toLowerCase() + "_" + rptTtlArr[k]) * 1;
					}else {
						tmpSum = tmpSum + sheetObjects[1].CellValue(rlRow, consTpszArr[t].toLowerCase() + "_" + rptTtlArr[k]) * 2;
					}
				}
				rlRow  = sheetObjects[1].FindText("code","RL",rlRow+1);
			}
			// MT Plan 줄
			sheetObjects[0].CellValue2(plRow, "qty_"+rptTtlArr[k])   = tmpSum;
			sheetObjects[0].CellValue2(plRow, "lf_"+rptTtlArr[k])    = Math.ceil((tmpSum / sheetObjects[0].CellValue(bsaRow, "qty_"+rptTtlArr[k])*1 ) * 100) + "%";
			sheetObjects[0].CellValue2(plRow, "wgt_"+rptTtlArr[k])   = Math.round(tmpSum * 2.2); //Math.ceil((tmpSum * 2.2) * 100)/100; 
			sheetObjects[0].CellValue2(plRow, "wgtlf_"+rptTtlArr[k]) = Math.ceil(((tmpSum * 2.2) / sheetObjects[0].CellValue(bsaRow, "wgt_"+rptTtlArr[k])*1) * 100) + "%";
			// TTL 줄
			sheetObjects[0].CellValue2(ttlRow, "qty_"+rptTtlArr[k])   = sheetObjects[0].CellValue(bkgRow, "qty_"+rptTtlArr[k])*1 + sheetObjects[0].CellValue(plRow, "qty_"+rptTtlArr[k])*1;
			sheetObjects[0].CellValue2(ttlRow, "lf_"+rptTtlArr[k])    = Math.ceil((sheetObjects[0].CellValue(ttlRow, "qty_"+rptTtlArr[k])*1 / sheetObjects[0].CellValue(bsaRow, "qty_"+rptTtlArr[k])*1) * 100 ) + "%";
			sheetObjects[0].CellValue2(ttlRow, "wgt_"+rptTtlArr[k])   = sheetObjects[0].CellValue(bkgRow, "wgt_"+rptTtlArr[k])*1 + sheetObjects[0].CellValue(plRow, "wgt_"+rptTtlArr[k])*1;
			sheetObjects[0].CellValue2(ttlRow, "wgtlf_"+rptTtlArr[k]) = Math.ceil((sheetObjects[0].CellValue(ttlRow, "wgt_"+rptTtlArr[k])*1 / sheetObjects[0].CellValue(bsaRow, "wgt_"+rptTtlArr[k])*1) * 100 ) + "%";
		}
	}

    // startRow 부터 endRow 까지, 전체 weeks 의 formula 를 계산함 (보이는 tpsz만)
    function calcAllFormula(startRow, endRow){
        var sheetObj = sheetObjects[1];
        
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
            for (var i = startRow; i < endRow; i++) {
                if (sheetObj.CellValue(i, "code") == "FBB") {
                    calcBalance(i, rptTtl, tpszs); // row 의 Initial Inventory 와 Balance 계산
                }
            }
        }
    }
    

    function calcBalance(row, weeks, tpszs){
        var sheetObj = sheetObjects[1];
        
        with (sheetObj) {
            var str_row = FindText("scc_cd",CellValue(row,"scc_cd")); // 해당 그룹의 첫 줄
            
            var inn_row = FindText("code","INN",str_row); // Initial Inventory
            var inp_row = FindText("code","INP",str_row); // Inventory Plus
            var inm_row = FindText("code","INM",str_row); // Inventory Minus
            var fbb_row = FindText("code","FBB",str_row); // Final Balance
            
            var weekArr = "";
            if(weeks != ""){ // 계산 하고자 하는 주차
                weekArr = weeks.split(",");
            }else{
                return false;
            }
            var tpszArr = "";
            if(tpszs != ""){ // 계산 하고자 하는 TPSZ
                tpszArr = tpszs.toLowerCase().split(",");
            }else{
                return false;
            }
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                //rptTtlArr = rptTtl.split(",");
            }else{
                return false;
            }
            
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    
                    // 미래 주차 부터는 앞 주의 Final Balance 를 Initial Inventory 로 함
                    if(weekArr[k] > rptTtlArr[3]){ // 미래주차
                        if(CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k-1]) > 0){ 
                            CellValue2(inn_row,tpszArr[t]+"_"+weekArr[k]) = CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k-1]);
                        }else{ // 단, 마이너스 이면 0 으로 함
                            CellValue2(inn_row,tpszArr[t]+"_"+weekArr[k]) = 0;
                        }
                    }
                    // 현재, 미래 주차의 Final Balance 계산 
                    if(weekArr[k] > rptTtlArr[2]){ // 현재, 미래주차
                        // [FBB] Final Balance 계산 = Initial Inventory + Inventory Plus - Inventory Minus
                        CellValue2(fbb_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(inn_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(inp_row,tpszArr[t]+"_"+weekArr[k])*1 - CellValue(inm_row,tpszArr[t]+"_"+weekArr[k])*1 ) ;
                    }
                }
            }
        }
    }
	
    
    function sheet2_OnChange(sheetObj, Row, Col, Value){
        with(sheetObj){
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                //rptTtlArr = rptTtl.split(",");
            }else{
                return false;
			}

            var str_row = GetMergedStartCell(Row,"scc_cd").split(",")[0]*1; // 해당 그룹의 첫 줄
            var end_row = GetMergedEndCell(Row,"scc_cd").split(",")[0]*1;   // 해당 그룹의 마지막 줄    
            var inn_row = FindText("code","INN",str_row);                 // Initial Inventory
            var inp_row = FindText("code","INP",str_row);                 // Inventory Plus
            var inm_row = FindText("code","INM",str_row);                 // Inventory Minus
            var fbb_row = FindText("code","FBB",str_row);                 // Final Balance
            
			var ttl_str_row = GetMergedStartCell(HeaderRows,"scc_cd").split(",")[0]*1;   // TTL 그룹의 마지막 줄   
            var ttl_end_row = GetMergedEndCell(HeaderRows,"scc_cd").split(",")[0]*1;   // TTL 그룹의 마지막 줄               

            // [Inventory Plus/Minus 하위 값 변경]
            if(CellValue(Row,"sort") > "0" && (CellValue(Row,"grp_cd") == "2" || CellValue(Row,"grp_cd") == "3")){

                // Inventory Plus 하위 값 변경 - 재 합산 and 히든 시트에 복사
                if(CellValue(Row,"grp_cd") == "2"){
                    var tmpSum = 0;
                    for(var i=str_row; i<=end_row; i++){
                        if(CellValue(i,"grp_cd") == "2" && CellValue(i,"sort") > "0"){
                            tmpSum = tmpSum + CellValue(i,Col)*1;
                        }
                    }
                    CellValue2(inp_row,Col) = tmpSum;
                    
                    CellFont("FontBold", Row, Col) = true;       // Bold
                    CellFontColor(Row, Col) = RgbColor(255,0,0); // Red
					copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                }else             
                // Inventory Minus 하위 값 변경 - 재 합산 and 히든 시트에 복사
                if(CellValue(Row,"grp_cd") == "3"){
                    var tmpSum = 0;
					
                    for(var i=str_row; i<=end_row; i++){
                        if(CellValue(i,"grp_cd") == "3" && CellValue(i,"sort") > "0"){
                            tmpSum = tmpSum + CellValue(i,Col)*1;
                        }
                    }
                    CellValue2(inm_row,Col) = tmpSum;
					
                    CellFont("FontBold", Row, Col) = true;       // Bold
                    CellFontColor(Row, Col) = RgbColor(255,0,0); // Red
                    copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                }
                
				var code  = CellValue(Row,"code");
                var tpsz  = ColSaveName(Col).split("_")[0];
                var week  = ColSaveName(Col).split("_")[1];
                var weeks = ""; // 영향을 받는 주차
                
				switch( week ){ // 수정된 주차
					case rptTtlArr[3]: // 현재 주차 ~
					   weeks = rptTtlArr[3]+","+rptTtlArr[4]+","+rptTtlArr[5]+","+rptTtlArr[6];
					   break;
                    case rptTtlArr[4]: // 미래 1주 ~
                       weeks = rptTtlArr[4]+","+rptTtlArr[5]+","+rptTtlArr[6];
                       break;
                    case rptTtlArr[5]: // 미래 2주 ~
                       weeks = rptTtlArr[5]+","+rptTtlArr[6];
                       break;
                    case rptTtlArr[6]: // 미래 3주 ~ 
                       weeks = rptTtlArr[6];
                       break;         
                }
				
				calcBalance(Row,weeks,tpsz); // Row 그룹의 Initial Inventory, Final Balance 구하기
				if(CellValue(Row,"code")=="RL"){
					calcTotalMtPlan(); // VVD 시트의 MT Plan 값 재 계산				
				}
            }
        }
    }

    // 저장될 내용을 히든 시트에 복사
    function copy_save_data(sheetObj, Row, Col, Value){
        
        var fcast_yrwk     = sheetObj.ColSaveName(Col).split("_")[1];
        var port_cd        = sheetObj.CellValue(Row,"scc_cd");
        var invt_sim_tp_cd = sheetObj.CellValue(Row,"code");
        var cfm_flg        = "Y"; // 예비적으로 만들어 둔 컬럼 
        var cntr_tpsz_cd   = sheetObj.ColSaveName(Col).split("_")[0].toUpperCase();   
        var cntr_qty       = Value;
        var tmp_sav_flg    = ""; // 예비적으로 만들어 둔 컬럼
                 
        with (sheetObjects[2]) {
           var dup = 0; 
           for(var i = 0; i <= LastRow; i++){
               if(   CellValue(i, "fcast_yrwk")     == fcast_yrwk 
                  && CellValue(i, "port_cd")        == port_cd 
                  && CellValue(i, "invt_sim_tp_cd") == invt_sim_tp_cd 
                  && CellValue(i, "cfm_flg")        == cfm_flg 
                  && CellValue(i, "cntr_tpsz_cd")   == cntr_tpsz_cd) { // 히든 시트에 이미 복사된게 있으면 이를 수정 
                  
                  CellValue(i, "cntr_qty")     = cntr_qty;
                  dup++;
               }
           }
           
           if (dup == 0) {
                var new_row = sheetObjects[2].DataInsert(-1);
                
                sheetObjects[2].CellValue2(new_row, "fcast_yrwk")     = fcast_yrwk;  
                sheetObjects[2].CellValue2(new_row, "port_cd")        = port_cd;       
                sheetObjects[2].CellValue2(new_row, "invt_sim_tp_cd") = invt_sim_tp_cd;
                sheetObjects[2].CellValue2(new_row, "cfm_flg")        = cfm_flg;     
                sheetObjects[2].CellValue2(new_row, "cntr_tpsz_cd")   = cntr_tpsz_cd;
                sheetObjects[2].CellValue2(new_row, "cntr_qty")       = cntr_qty;   
                sheetObjects[2].CellValue2(new_row, "tmp_sav_flg")    = tmp_sav_flg; 
           }
        }
    }
    
	
   /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
      with (sheetObj) {

            if(ColSaveName(Col)=="name"){
                if(CellValue(Row,"sort")=="0"){
                    var tmpName = CellValue(Row,"name");
                    var plus = tmpName.substr(tmpName.length-3,3);
                    if(plus == "(+)"){
                        for(var i=Row+1; i<=sheetObj.LastRow; i++){
                            if(CellValue(Row,"grp_cd")==CellValue(i,"grp_cd")){
                                RowHidden(i) = false;
                                
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
        
        switch(comboObj.name) {       
            // Type Size
            case "tpsztype":
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
            document.form.tpsztype.Code = consTpsz;                     
            break;
        case "D":
            document.form.tpsztype.Code = consTpszDry;                
            break;
        case "R":
            document.form.tpsztype.Code = consTpszRfr;
            break;
        case "O":
            document.form.tpsztype.Code = consTpszOt;
            break;
        case "F":
            document.form.tpsztype.Code = consTpszFr;
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
			ComOpenWait(true);
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
			ComOpenWait(false);
        }
    }
    
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
        var sheetObj = sheetObjects[1]; 
        
        ComOpenWait(true);
        setTtlColumn(); // TTL column 의 calclogic 셋팅
        calcAllFormula(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount); // 아직 계산되지 않은 TPSZ 의 Balance 계산
        ComOpenWait(false);
    }

    // 과거 3주, 2주, 1주 내용을 숨기거나 보임
    function showHistory(){
       setGridHidden(form.tpsztype.Text);
    }
    
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj = sheetObjects[1];
        var arr_tpsz = tpsz_cd.split(",");
        
        if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
        
        if(document.form.show_history.checked == true){ // Past 3 weeks history 체크박스
            for (var k = 0; k < 3; k++) { // 과거 주차
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    sheetObj.ColHidden("ttl_"+rptTtlArr[k])= false;
                }  
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
        }else{
            for (var k = 0; k < 3; k++) { // 과거 주차
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k])= true;
                    sheetObj.ColHidden("ttl_"+rptTtlArr[k])= true;
                }  
            }
            for (var k = 3; k < rptTtlArr.length; k++) { // 현재, 미래 주차
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
    }    

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 *
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author
 * @version
 */
function trade_OnChange(comboObj, code, text) {
	if (code != "") {
		searchOptionSubTrade("subtrade", true, true, "", "", code, "", true);
	}else{
		document.form.subtrade.RemoveAll();
		document.form.lane.RemoveAll();
	}
	doActionIBSheet(sheetObjects[1],document.form,SEARCH04); // Sub-Conti 콤보 조회
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}

function subtrade_OnChange(comboObj, value, text) {
	if (value != "") {
		searchOptionLane("lane", true, true, "", document.form.trade.Code, value, true, "", true);
	} else {
		document.form.lane.RemoveAll();
	}
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}

function lane_OnChange(comboObj, value, text) {
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}

// Sub-Conti 콤보의 활성화를 세팅함
function setSubcontiEnable(){
	// Trade 가 I시작(IAS,IES,IMS) 이면 Sub-Conti 활성화
	var formObj =  document.form;
	
	if(formObj.lane.Code != ""){
	    if( formObj.lane.Code.substr(0,1)=="I" || formObj.lane.Code.search(",I")!=-1 ){
			formObj.subconti.enable  = true;
		}else{
			formObj.subconti.enable  = false;
			formObj.subconti.Code = "";
		}	
	}else if(formObj.subtrade.Code != ""){
        if( formObj.subtrade.Code.substr(0,1)=="I" || formObj.subtrade.Code.search(",I")!=-1 ){
            formObj.subconti.enable  = true;
        }else{
            formObj.subconti.enable  = false;
            formObj.subconti.Code = "";
        }   
    }else if(formObj.trade.Code != ""){
        if( formObj.trade.Code.substr(0,1)=="I" || formObj.trade.Code.search(",I")!=-1 ){
            formObj.subconti.enable  = true;
        }else{
            formObj.subconti.enable  = false;
            formObj.subconti.Code = "";
        }   
    }else{
		formObj.subconti.enable  = false;
	}
}
    
    /* 개발자 작업  끝 */