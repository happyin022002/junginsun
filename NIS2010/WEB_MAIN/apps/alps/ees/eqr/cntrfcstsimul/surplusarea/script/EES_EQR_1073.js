/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1073.js
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
     * @class EES_EQR_1073 : EES_EQR_1073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1073() { 
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
        var sheet1 = sheetObjects[shtCnt];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
            
            case "btn_Save":
                doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
                break;
                
            case "btn_New": // 초기화
                sheetObjects[0].RemoveAll();       
                sheetObjects[1].RemoveAll();  
                calcedTpsz = ""; // 계산된 tpsz 내역 초기화       
                formObject.loc_cd.value="";
                formObject.loc_type_code.value = "5";
                loc_type_code_onchange();
				formObject.show_history.checked = false;
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
    
                if (code_type == "2" || code_type == "3" || code_type == "8") { // RCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "rcc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "4" || code_type == "5") { // LCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "6") { // ECC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "7") { // SCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 407, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
                }   
                break;  
                
            case "btn_Bkg": // Booking by Yard 팝업
                if(sheetObjects[0].RowCount("R|I|U") > 0){
                    var param = "loc_type_code=" + formObject.loc_type_code.value                               // 숫자
                              + "&loc_cd="       + formObject.loc_cd.value                                      // loc_cd
                              + "&cntrTpsz="     + formObject.cntrTpsz.value                                    // 코드 (D)
                              + "&tpsztype="     + formObject.tpsztype.Text ;
                    if(formObject.show_history.checked){
                        param = param + "&show_history=checked" ;
                    } 
                    ComOpenPopup("/hanjin/EES_EQR_1074.do?"+ param,1015, 645, "", "1,0,1,1,1,1,1,1", true);
                }else{
                    ComShowCodeMessage("EQR01029", "first"); // 'Please retrieve {?msg1}.'
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
//        ComBtnDisable("btn_Save"); // Save 버튼 비활성
        
        
        var level_cd = document.form.level_cd.value;
//        alert('level_cd : '+ level_cd);
        /**
        ## 설명 -  MTY Inventory Simulation by Port & Yard의 User별 office level결정
          SELCOE         - 1, SELCOE는 Super-user
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
        	ComBtnDisable("btn_Bkg");
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        	ComBtnDisable("btn_Save");
        	ComBtnDisable("btn_downExcel");        	
        } else {
        	// 나머지는 level에 따라서 조회 자체에서 걸르게 된다는 전제로 일단 권한을 풀어준다.
        	editAuth = true;
        	ComBtnEnable("btn_Bkg");
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_New");
        	ComBtnEnable("btn_Save");
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
                   style.height = 585; // 585;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;    
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge;
                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                   InitHeadMode(false, false, false, true, false, false);
                   
                   var HeadTitle1 = "LOC|Section/type|code|grp_cd|sort";
                   var HeadTitle2 = "LOC|Section/type|code|grp_cd|sort";
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
                   //Rows = 36;
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 5;
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   //loc_cd|code|name|grp_cd|sort
                   InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     true,       "loc_cd",             false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtData,      170,   daLeft,       true,       "name",               false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "code",               false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "grp_cd",             false,  "",      dfNone,          0,     false,      false);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "sort",               false,  "",      dfNone,          0,     false,      false);

                   
                   for(i = 0; i < rptTtlArr.length; i++){
                       var calcLogic = "0*1";
                       if (form.tpsztype.Text != "") {
					   	   var arr_tpsz = form.tpsztype.Text.toLowerCase().split(",");
						   for (var t = 0; t < arr_tpsz.length; t++) {
						       calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|";
						   }
					   }
                       InitDataProperty(0, cnt++ , dtData,      60,   daRight,      false,      "ttl_"+rptTtlArr[i],             false,  calcLogic,      dfNumber,          0,     false,      false);
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
				   
                   for(i = 3; i < rptTtlArr.length; i++){   // 빨강색 Bold 표시 (현재,미래만)
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "d2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "d4_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "d5_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "d7_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "r2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "r5_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "r9_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "o2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "s2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "o4_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "s4_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "f2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "a2_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "f4_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "a4_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "f5_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      "a5_b_"+rptTtlArr[i],              false,  "",      dfNone,          0,     false,       false);
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
            
            case "sheet2":      // sheet2 MULTI 용 히든 시트
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

                   var HeadTitle = "ibflag|fcast_yrwk|yd_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|cntr_qty|tmp_sav_flg";

                   HeadTitleCnt = ComCountHeadTitle(HeadTitle);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,        false,       "ibflag");
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "fcast_yrwk",             false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "yd_cd",                  false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "invt_sim_tp_cd",         false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cfm_flg",                false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_tpsz_cd",           false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_qty",               false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "tmp_sav_flg",            false,  "",      dfNone,            0,     true,       true);
                   
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
                    calcedTpsz = ""; // 계산된 tpsz 내역 초기화
                    sheetObj.RemoveAll();
					sheetObjects[1].RemoveAll(); // 히든 시트 내용 삭제
					
                    formObj.f_cmd.value = SEARCH;

                    var sXml = sheetObj.GetSearchXml("EES_EQR_1073GS.do", FormQueryString(formObj));

                    rptTtl = ComRtrim(ComGetEtcData(sXml, "rpt_ttl"),",");
                    
					initSheet(sheetObj, 1);
                    sheetObj.LoadSearchXml(sXml);
                    
                    search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
                    
                    calcAllFormula(sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount);
                    
                    setGridHidden(formObj.tpsztype.Text); // TPSZ hidden 
                    sheetObjects[0].Redraw = true;
                    ComOpenWait(false);
                }
                break;
            case IBSAVE: // sheetObj 는 히든 시트 임 (sheetObjects[1])
                if (validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(true);
                    
                    // 히든 시트 sort ( BCImpl 에서 Sort 된 결과에 따라 처리 됨 )
                    sheetObj.ColumnSort("ibflag|fcast_yrwk|yd_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|tmp_sav_flg|cntr_qty");
                    
                    var sParam = sheetObj.GetSaveString();
                    var sXml = sheetObj.GetSaveXml("EES_EQR_1073GS.do", sParam + "&f_cmd=" + MULTI);
                    
                    if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") { // 저장 성공했으면
                        sheetObj.RemoveAll(); // 히든 시트 내용 삭제
                        ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
                    }else{
                        // 에러 메세지 java 에서 뱉음
                    }
                    ComOpenWait(false);
                }
                break;  
            case SEARCH02: // Location 유효성 조회
                var code_type = formObj.loc_type_code.value;
                var sParam = "f_cmd=" + SEARCH02 + "&loc_cd=" + formObj.loc_cd.value;
                var errMsgCd = ""; // 에러시 보여줄 메시지 코드
                if(code_type == "1"){ // ALL
                    return true;
                }else if (code_type == "2" || code_type == "3" || code_type == "8") { // RCC
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
                
                var sXml = sheetObj.GetSearchXml("EES_EQR_1073GS.do", sParam);
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
						
						// RCC_CD 가 USNYC, SGSIN 인 경우 Domestic In 숨김
						
						// RCC_CD 가  DEHAM, USNYC 인 경우 Sublease In 숨김
						
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
        
        calcTtlInventoryChild(sheetObj);  // [Inventory Plus/Minus 하위 값] 의 합을 구하여 TTL 그룹 에 반영함
        calcInventoryPlusMinus(sheetObj); // sheet 전체의 Inventory Plus, Inventory Minus 계산
    
        with (sheetObj) {
			// Row 별 색상 표시, 편집 가부 설정
            for(var i = startRow; i < endRow; i++){
                  
                if (CellValue(i, "grp_cd") == "1") {
                    RowBackColor(i) = sheetObj.RgbColor(255,255,255); //흰색
                    RowEditable(i) = false;
                } else if (CellValue(i, "grp_cd") == "2") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#F6FAFB"); // 푸른색 // 246,250,251
                    if(false){
						
					}else if(CellValue(i,"sort") > "0" && CellValue(i,"loc_cd").length == 7 && editAuth){
                        RowEditable(i) = true;
						//CellFontColor(i,"name") = RgbColor(0,0,255);
						
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
							rptTtlArr = rptTtl.split(",");
							
							for(var k=3; k<rptTtlArr.length; k++){
								var str_col = SaveNameCol("d2_"+rptTtlArr[k]); // first column
								var end_col = SaveNameCol("a5_"+rptTtlArr[k]); // last column
								RangeBackColor(i, str_col, i, end_col) = RgbColor(255,255,162);
							}
						}
                    }else{
                        RowEditable(i) = false;
                    }
                } else if (CellValue(i, "grp_cd") == "3") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#FFEAEA"); // 분홍색 // 255,234,234
                    if(CellValue(i,"sort") > "0" && CellValue(i,"loc_cd").length == 7 && editAuth 
					   && CellValue(i,"code") != "PL" ){ // MT Loading Plan 은 수정 X
                        RowEditable(i) = true;
						//CellFontColor(i,"name") = RgbColor(0,0,255);
						
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
                            rptTtlArr = rptTtl.split(",");
                            
                            for(var k=3; k<rptTtlArr.length; k++){
                                var str_col = SaveNameCol("d2_"+rptTtlArr[k]); // first column
                                var end_col = SaveNameCol("a5_"+rptTtlArr[k]); // last column
                                RangeBackColor(i, str_col, i, end_col) = RgbColor(255,255,162);
                            }
                        }
                    }else{
                        RowEditable(i) = false;
                    }
                } else if (CellValue(i, "grp_cd") == "4") {
                    RowBackColor(i) = sheetObj.RgbColor(255,255,255); //흰색
                    RowEditable(i) = false;
                } else if (CellValue(i, "grp_cd") == "5") {
                    RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 // 208,236,127
                    RowEditable(i) = false;
                } else {
                    RowEditable(i) = false;
                }
            }
            
			// 과거 주차 회색 표시, 메뉴얼 입력값 빨간색 볼드체
            if (rptTtl != "") {
                rptTtlArr = rptTtl.split(",");
				
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
       setTtlColumn();
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

    // 현재, 미래 주차에서, [Inventory Plus/Minus 하위 값] 의 합을 구하여 TTL 그룹 에 반영함
    // MG, MT In via VD, MT In via EN/TN, On-hire, Domestic In, Sublease In
    // OP, MT Out via VL, MT Out via EN/TN, Off-hire/Disposal, Domestic Out, Sublease Out
    // 조회후 한번만 호출 됨
    // 메뉴얼 수정 값이 있는 경우, 쿼리에서 TTL 값을 구하기 곤란한 것에 대한 보완
    function calcTtlInventoryChild(sheetObj){
    	if (rptTtl != "" && sheetObj.RowCount > 0) { // 조회된 데이터 있을 경우
            rptTtlArr = rptTtl.split(",");
            
            var ttl_str_row = sheetObj.GetColSameDataRange(sheetObj.HeaderRows,"loc_cd").split("|")[0]*1 // TTL 그룹의 첫 줄
            var ttl_end_row = sheetObj.GetColSameDataRange(sheetObj.HeaderRows,"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄            
            
            for(var i=ttl_str_row; i<=ttl_end_row; i++){
            	// [Inventory Plus/Minus 하위 값]
                if(sheetObj.CellValue(i,"sort") != null && sheetObj.CellValue(i,"sort") > "0" && (sheetObj.CellValue(i,"grp_cd") == "2" || sheetObj.CellValue(i,"grp_cd") == "3")){
                	
                	var tmpCode = sheetObj.CellValue(i,"code");
                	for (var k = 3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
    	            	for(var t = 0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
    	            		
                			var tmpSum = 0; 
    	                    var next_row = sheetObj.FindText("code",tmpCode,ttl_end_row*1+1);
    	                    while(next_row != -1){
    	                    	// 같은 code 를 가진 row 의 값을 합친다
    	                        tmpSum = tmpSum + sheetObj.CellValue(next_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) * 1;
    	                        next_row = sheetObj.FindText("code",tmpCode,next_row*1+1);
    	                    }
    	                    sheetObj.CellValue2(i, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) = tmpSum;
    	            	}	
                	}
				}
			}
		}
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
                if (sheetObj.CellValue(i, "code") == "FBB" && sheetObj.CellValue(i, "loc_cd") != "TTL") {
                    calcBalance(i, rptTtl, tpszs); // row 의 Initial Inventory 와 Balance 계산
                }else if (sheetObj.CellValue(i, "code") == "F1" && sheetObj.CellValue(i, "loc_cd") != "TTL") {
                    calcFormula(i, rptTtl, tpszs); // row 의 tpsz 의 formula 계산
                    calcTtlFormula(i, rptTtl, "ttl"); // row 의 ttl column 의 formula 계산
                    fomula_flag = true;
                }
            }
            
            calcTtlBalance(sheetObj.HeaderRows, rptTtl, tpszs); // TTL LOC의 미래 주차 Inventory , Final Balance 계산
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
                    CellValue2(f1_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ).toFixed(0);

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
		
            var str_row = GetColSameDataRange(row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row = GetColSameDataRange(row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_end_row = GetColSameDataRange(HeaderRows,"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄			
			
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
                        CellValue2(f2_row,tpszArr[t]+"_"+weekArr[k]) = f2Sum ;
                    }else{
                        // [F2] TTL column 의 Target Ratio Index 계산  = 보이는 tpsz들의 F2 들의 합 ( calcTotal에서 계산 됨 )
                    }
					
                    // [F3] TTL 의 Target Ratio vs OP 계산 = F2 / ( OP + DO + SO ) 올림
                    CellValue2(f3_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 / ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1);
                    
                    // [F1] Surplus MT 계산 = FBB - F2
                    CellValue2(f1_row,tpszArr[t]+"_"+weekArr[k]) = CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - CellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ;
                    
                    // [F4] MT Performance 계산 = FBB / ( OP + DO + SO )
                    CellValue2(f4_row,tpszArr[t]+"_"+weekArr[k]) = ( CellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 / ( CellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + CellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + CellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1);
                }
            }
        }
    }

    function calcBalance(row, weeks, tpszs){
        var sheetObj = sheetObjects[0];
        
        with (sheetObj) {
            var str_row = FindText("loc_cd",CellValue(row,"loc_cd")); // 해당 그룹의 첫 줄
            
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
                rptTtlArr = rptTtl.split(",");
            }else{
                return false;
            }
            
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    
                    // 미래 주차 부터는 앞 주의 Final Balance 를 Initial Inventory 로 함
                    if(weekArr[k] > rptTtlArr[3]){ // 미래주차
                        
						var pre_yrwk = ""; // 직전 주차
						if(k > 0){
                            pre_yrwk = weekArr[k-1];
                        }else{ // 직전 주차 별도로 구함
							if(weekArr[k] == rptTtlArr[4]){
								pre_yrwk = rptTtlArr[3];
							}else if(weekArr[k] == rptTtlArr[5]){
                                pre_yrwk = rptTtlArr[4];
                            }else if(weekArr[k] == rptTtlArr[6]){
                                pre_yrwk = rptTtlArr[5];
                            }else{
								return false; //직전 주차를 못구하면
							}
						}
						
                        if(CellValue(fbb_row,tpszArr[t]+"_"+pre_yrwk) > 0){ 
                            CellValue2(inn_row,tpszArr[t]+"_"+weekArr[k]) = CellValue(fbb_row,tpszArr[t]+"_"+pre_yrwk);
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
    
    function calcTtlBalance(row, weeks, tpszs){
        var sheetObj = sheetObjects[0];
        
        with (sheetObj) {
            var str_row = GetColSameDataRange(row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row = GetColSameDataRange(row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_end_row = GetColSameDataRange(HeaderRows,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
			
            var inn_row = FindText("code","INN",str_row); // Initial Inventory
            var fbb_row = FindText("code","FBB",str_row); // Final Balance
            
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
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                rptTtlArr = rptTtl.split(",");
            }else{
                return false;
            }
            
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    if(weekArr[k] > rptTtlArr[2]){ // 현재, 미래주차 
                    
                        if (tpszArr[t] != "ttl") {
                            var innSum = 0;
                            var fbbSum = 0;
                            var next_inn_row = FindText("code","INN",ttl_end_row*1+1);
                            while(next_inn_row != -1){
								innSum = innSum + CellValue(next_inn_row, tpszArr[t] + "_" + weekArr[k]) * 1;
								next_inn_row = FindText("code","INN",next_inn_row*1+1);
							}
							var next_fbb_row = FindText("code","FBB",ttl_end_row*1+1);
                            while(next_fbb_row != -1){
                                fbbSum = fbbSum + CellValue(next_fbb_row, tpszArr[t] + "_" + weekArr[k]) * 1;
                                next_fbb_row = FindText("code","FBB",next_fbb_row*1+1);
                            }

                            // [INN] 
                            CellValue2(inn_row,tpszArr[t]+"_"+weekArr[k]) = innSum;
                            // [FBB] 
                            CellValue2(fbb_row,tpszArr[t]+"_"+weekArr[k]) = fbbSum;
                        }
                    }
                }
            }
        }
    }   
	
    
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        with(sheetObj){
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                rptTtlArr = rptTtl.split(",");
            }else{
                return false;
			}

            var str_row = GetColSameDataRange(Row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row = GetColSameDataRange(Row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_str_row = GetColSameDataRange(HeaderRows,"loc_cd").split("|")[0]*1 // TTL 그룹의 첫 줄
            var ttl_end_row = GetColSameDataRange(HeaderRows,"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄

            var inn_row = FindText("code","INN",str_row);                 // Initial Inventory
            var inp_row = FindText("code","INP",str_row);                 // Inventory Plus
            var inm_row = FindText("code","INM",str_row);                 // Inventory Minus
            var fbb_row = FindText("code","FBB",str_row);                 // Final Balance

            // [Inventory Plus/Minus 하위 값 변경]
            if(CellValue(Row,"sort") > "0" && (CellValue(Row,"grp_cd") == "2" || CellValue(Row,"grp_cd") == "3")){

                if ( Value == '' ) {  //data format int형 널 방지
                    CellValue2(Row,Col) = 0;
                    Value = 0;
                }
                
                // Inventory Plus 하위 값 변경 - 재 합산 and 히든 시트에 복사
                if(CellValue(Row,"grp_cd") == "2"){
                    var tmpSum = 0;
                    for(var i=str_row; i<=end_row; i++){
                        if(CellValue(i,"grp_cd") == "2" && CellValue(i,"sort") > "0"){
                            tmpSum = tmpSum + CellValue(i,Col)*1;
                        }
                    }
                    CellValue2(inp_row,Col) = tmpSum;
                    
					if(CellValue(Row,"loc_cd").length == 7){ // Yard 이면
					    //CellFont("FontBold", Row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = true;       // Bold
                        //CellFontColor(next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = RgbColor(255,0,0); // Red
                        CellFont("FontBold", Row, Col) = true;       // Bold
                        CellFontColor(Row, Col) = RgbColor(255,0,0); // Red
						copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                    }
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
                    if(CellValue(Row,"loc_cd").length == 7){ // Yard 이면
                        CellFont("FontBold", Row, Col) = true;       // Bold
                        CellFontColor(Row, Col) = RgbColor(255,0,0); // Red
                        copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                    }
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
 
                var tmpSum = 0; 
                var next_row = FindText("code",code,ttl_end_row*1+1);
                while(next_row != -1){
                    tmpSum = tmpSum + CellValue(next_row, Col) * 1;
                    next_row = FindText("code",code,next_row*1+1);
                }
				CellValue2(FindText("code",code,HeaderRows),Col) = tmpSum;
				
				if(CellValue(Row,"grp_cd") == "2"){ // Inventory Plus
                    var tmpSumSum = 0;
					for(var i=ttl_str_row; i<=ttl_end_row; i++){
						if(CellValue(i,"grp_cd") == "2" && CellValue(i,"sort") > "0"){
							tmpSumSum = tmpSumSum + CellValue(i,Col)*1;
						}
					}
					var tmpSumRow = FindText("code","INP",HeaderRows); // TTL 그룹의 Inventory Plus
					CellValue2(tmpSumRow,Col) = tmpSumSum;
                }else if(CellValue(Row,"grp_cd") == "3"){ // Inventory Minus
                    var tmpSumSum = 0;
                    for(var i=ttl_str_row; i<=ttl_end_row; i++){
                        if(CellValue(i,"grp_cd") == "3" && CellValue(i,"sort") > "0"){
                            tmpSumSum = tmpSumSum + CellValue(i,Col)*1;
                        }
                    }
                    var tmpSumRow = FindText("code","INM",HeaderRows); // TTL 그룹의 Inventory Minus
                    CellValue2(tmpSumRow,Col) = tmpSumSum;
                }
				
                calcFormula(Row, weeks, tpsz);                           // Row 가 속한 그룹의 weeks 주차들의 tpsz 의 formula 재 계산
				calcTtlFormula(Row, weeks, "ttl");                       // Row 가 속한 그룹의 ttl colunm 의 formula 새로 계산
				calcTtlBalance(sheetObj.HeaderRows, weeks, tpsz);        // TTL LOC의 미래 주차 Inventory , Final Balance 계산
                calcTtlFormula(sheetObj.HeaderRows, weeks, tpsz+",ttl"); // TTL 그룹 formula 새로 계산
            }
        }
    }


    // 저장될 내용을 히든 시트에 복사
    function copy_save_data(sheetObj, Row, Col, Value){
        
        var fcast_yrwk     = sheetObj.ColSaveName(Col).split("_")[1];
        var yd_cd          = sheetObj.CellValue(Row,"loc_cd");
        var invt_sim_tp_cd = sheetObj.CellValue(Row,"code");
        var cfm_flg        = "Y"; // 예비적으로 만들어 둔 컬럼 
        var cntr_tpsz_cd   = sheetObj.ColSaveName(Col).split("_")[0].toUpperCase();   
        var cntr_qty       = Value;
        var tmp_sav_flg    = ""; // 예비적으로 만들어 둔 컬럼
                 
        with (sheetObjects[1]) {
           var dup = 0; 
           for(var i = 0; i <= LastRow; i++){
               if(   CellValue(i, "fcast_yrwk")     == fcast_yrwk 
                  && CellValue(i, "yd_cd")          == yd_cd 
                  && CellValue(i, "invt_sim_tp_cd") == invt_sim_tp_cd 
                  && CellValue(i, "cfm_flg")        == cfm_flg 
                  && CellValue(i, "cntr_tpsz_cd")   == cntr_tpsz_cd) { // 히든 시트에 이미 복사된게 있으면 이를 수정 
                  
                  CellValue(i, "cntr_qty")     = cntr_qty;
                  dup++;
               }
           }
           
           if (dup == 0) {
                var new_row = sheetObjects[1].DataInsert(-1);
                
                sheetObjects[1].CellValue2(new_row, "fcast_yrwk")     = fcast_yrwk;  
                sheetObjects[1].CellValue2(new_row, "yd_cd")          = yd_cd;       
                sheetObjects[1].CellValue2(new_row, "invt_sim_tp_cd") = invt_sim_tp_cd;
                sheetObjects[1].CellValue2(new_row, "cfm_flg")        = cfm_flg;     
                sheetObjects[1].CellValue2(new_row, "cntr_tpsz_cd")   = cntr_tpsz_cd;
                sheetObjects[1].CellValue2(new_row, "cntr_qty")       = cntr_qty;   
                sheetObjects[1].CellValue2(new_row, "tmp_sav_flg")    = tmp_sav_flg; 
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
			ComOpenWait(true);
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
			ComOpenWait(false);
        }
    }
    
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
        var sheetObj = sheetObjects[0]; 
        
        ComOpenWait(true);
        setTtlColumn(); // TTL column 의 calclogic 셋팅
        calcAllFormula(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount);
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i,"code")=="F1"){
                calcTtlFormula(i, rptTtl, "ttl"); // TTL LOC의 tpsz 의 formula 계산
            }
		}
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
        var sheetObj = sheetObjects[0];
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
    
    /* 개발자 작업  끝 */