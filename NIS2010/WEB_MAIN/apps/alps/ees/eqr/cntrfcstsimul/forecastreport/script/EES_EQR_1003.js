/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1003.js
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
* 1. 2013.12.03 신용찬  NEW 버튼 추가
*               신용찬  INVENTORY 에서 LAND INVENTORY 연결 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1003 : EES_EQR_1003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1003() { 
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
    
    var comboObjects = new Array();
    var comboCnt = 0 ;
    
    var mouseFlag = true;
    
    var weekTpArr = new Array("p2","p1","c0","f1","f2","f3","f4","f5","f6","f7","f8","f9");
	
	// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //     
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|S2|O4|S4|O5"; // OT  TYPE SIZE 
    var tpszotCode  = "O2|S2|O4|S4|O5";
    var tpszfrText  = "F2|A2|F4|A4|F5|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|A2|F4|A4|F5|A5"; 
    
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,O5,F2,A2,F4,A4,F5,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,S2,O4,S4,O5";
    var consTpszFr    = "F2,A2,F4,A4,F5,A5";
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
                doActionIBSheet(sheetObjects[0],formObject,SEARCH13);
                break;
                
			case "btn_new":
				init_form(); //화면 초기화.
				break;
			
            case "btn_save":
                doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
                break;
            case "btn_downExcel":
                ComOpenWait(true);
//                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"tree|c0_img|f1_img|f2_img|f3_img|f4_img|f5_img|f6_img|f7_img");
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"tree|p2_img|p1_img|c0_img|f1_img|f2_img|f3_img|f4_img|f5_img|f6_img|f7_img|f8_img|f9_img");
                ComOpenWait(false);
                break;
                
            case "btn_loc_cd":    //Location By 조회 팝업
        
                if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
                    var code_type = formObject.loc_type_code.value;
        
                    if(code_type.substr(0,1) == "E") {
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "R") {    
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "rcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "L"){
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }
                    //obj_blur();
                }
                
                break;  
                
            case "btn_loc_cd_second":    //Location 조회 팝업

                if(document.form.loc_cd.value != "" && document.form.div_flag[1].checked == true) {    
                    var code_type = formObject.loc_tp_cd_second.value;
        
                    if(code_type.substr(0,1) == "E") {
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "L") {    
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "S"){
                        ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }
                    //obj_blur();
                }
                
                break; 
            
            case "btn_OrgChart":
                ComOpenPopup("/hanjin/EES_EQR_1007.do", 400, 440, "", "1,0,1,1,1,1,1,1", true);
                break;      
            
            case "btn_LtStatus":
                ComOpenPopup("/hanjin/EES_EQR_1006.do?pop_mode=Y", 1007, 645, "", "1,0,1,1,1,1,1,1", true);
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
         axon_event.addListener('keyup', 'sub_loc_cd_onkeyUp', 'sub_loc_cd');                  //LOC_CD keyup 이벤트 처리
         axon_event.addListener('keyup', 'loc_cd_second_onkeyUp', 'loc_cd_second');            //LOC_CD keyup 이벤트 처리
         axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate이벤트에 코드 처리
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
         axon_event.addListener('blur', 'obj_blur', 'sub_loc_cd');                             //Location  blur 이벤트 처리
         axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //알파벳 대문자,숫자만 입력허용
         axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd');                        //RCC 변경시 이벤트 처리
         axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');          //Location by 변경시 이벤트 처리
         axon_event.addListener('change', 'loc_tp_cd_second_onchange', 'loc_tp_cd_second');    //Location 변경시 이벤트 처리
         
         axon_event.addListenerForm('change','form_change',form);
        
         loc_cd_onchange();  // RCC 이벤트 호출하여 라디오버튼을 통제(비활성화)   
         
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
//            sheetObjects[i].Visible = true;
        }
        initControl();
        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
        tpszChange('D'); // Dry 선택
        
        var level_cd = document.form.level_cd.value;
        
        // level_cd = 1 (SELCDO 만 수정가능, 저장 가능)
        // level_cd = 2 (수정 가능, 저장 불가능)
        // level_cd = 3 (수정 불가, 저장 불가)
//        if(level_cd != "1") {
//            ComBtnDisable("btn_save");      // SAVE 버튼 잠금
//            ComBtnDisable("btn_LtStatus");  // LT Status 버튼 잠금 (EES_EQR_1006)
//            sheetObjects[0].Editable = false;
//            sheetObjects[1].Editable = false;
//        }
        if(level_cd == "2" || level_cd == "3") {  // 
            ComBtnDisable("btn_save");      // SAVE 버튼 잠금
            ComBtnDisable("btn_LtStatus");  // LT Status 버튼 잠금 (EES_EQR_1006)
            sheetObjects[0].Editable = true;  // grid edit 가능
            sheetObjects[1].Editable = false;
        }
        
//        else if(level_cd == "3") {  // 
//            ComBtnDisable("btn_save");      // SAVE 버튼 잠금
//            ComBtnDisable("btn_LtStatus");  // LT Status 버튼 잠금 (EES_EQR_1006)
//            sheetObjects[0].Editable = false;
//            sheetObjects[1].Editable = false;
//        }        
        
        for(var k = 8; k < weekTpArr.length; k++){ // f6,f7,f8,f9 히든
            sheetObjects[0].ColHidden(weekTpArr[k]+"_img")= true;
            sheetObjects[0].ColHidden(weekTpArr[k]+"_ttl")= true;
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
                   Editable = true;
                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(2, 1, 22, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, false, false, false, false,false);
				   
                   var HeadTitle1 = "GRP|LOC|T|Section/type|ori_loc_cd|ori_ori_loc_cd|ori_ori_ori_loc_cd|code";
                   var HeadTitle2 = "GRP|LOC|T|Section/type|ori_loc_cd|ori_ori_loc_cd|ori_ori_ori_loc_cd|code";
                   var HeadTitleWeekArr = new Array("-2 week","-1 week","Current week","+1 week","+2 week","+3 week","+4 week","+5 week","+6 week","+7 week","+8 week","+9 week");
				   for(var i = 0; i < HeadTitleWeekArr.length; i++){
                       //for(var j = 0; j < 18; j++){
                       //for(var j = 0; j < 19; j++){   // 타입사이즈 O5 추가            
                       for(var j = 0; j < 20; j++){   // 타입사이즈 A5 추가            	   
                           HeadTitle1 += "|" + HeadTitleWeekArr[i];
                       }
                       //HeadTitle2 += "||D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|TTL";
                       HeadTitle2 += "||D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|TTL"; // 타입사이즈 O5 추가    
                   }
                   for(var i = 0; i < weekTpArr.length; i++){
                       //for(var j = 0; j < 18; j++){
                       //for(var j = 0; j < 19; j++){   // 타입사이즈 O5 추가     
                       for(var j = 0; j < 20; j++){   // 타입사이즈 A5 추가     	   
                           HeadTitle1 += "|" + weekTpArr[i];
                       }
//                       HeadTitle2 += "|wk|wk_f|d2_d|d4_d|d5_d|d7_d|r2_d|r5_d|r9_d|o2_d|s2_d|o4_d|s4_d|f2_d|a2_d|f4_d|a4_d|f5_d";
                       HeadTitle2 += "|wk|wk_f|d2_d|d4_d|d5_d|d7_d|r2_d|r5_d|r9_d|o2_d|s2_d|o4_d|s4_d|o5_d|f2_d|a2_d|f4_d|a4_d|f5_d|a5_d"; // 타입사이즈 O5 A5추가 
                   }
                   
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
				   
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 8;

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtHidden,   0,   daCenter,     true,       "loc_grp_cd",         false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtData,    62,   daCenter,     true,       "loc_cd",             false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtData,    15,   daCenter,     true,       "tree",               false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtData,   125,   daLeft,       true,       "name",               false,  "",      dfNone,          0,     true,      true);
                   
                   InitDataProperty(0, cnt++ , dtHidden,   0,   daRight,      false,      "ori_loc_cd",         false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,   0,   daRight,      false,      "ori_ori_loc_cd",     false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,   0,   daRight,      false,      "ori_ori_ori_loc_cd", false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,   0,   daRight,      false,      "code",               false,  "",      dfNone,          0,     true,      true);
                   for (i = 0; i < weekTpArr.length; i++) { // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7,f8,f9 
                        InitDataProperty(0, cnt++, dtImageText, 20, daCenter, true, weekTpArr[i] + "_img", false, "", dfNone, 0, false, false);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_d2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_d4", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_d5", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_d7", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_r2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_r5", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_r9", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_o2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_s2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_o4", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_s4", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_o5", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_f2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_a2", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_f4", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_a4", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_f5", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 40, daRight, false, weekTpArr[i] + "_a5", false, "", dfNumber, 0, true, true);
                        InitDataProperty(0, cnt++, dtData, 46, daRight, false, weekTpArr[i] + "_ttl", false, "", dfNumber, 0, false, false);
                    }
                    for(i = 0; i < weekTpArr.length; i++){ // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i],                    false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_f",               false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_d2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_d4_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_d5_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_d7_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_r2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_r5_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_r9_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_o2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_s2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_o4_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_s4_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_o5_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_f2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_a2_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_f4_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_a4_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_f5_d",            false,  "",      dfNone,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtHidden,      0,   daRight,      false,      weekTpArr[i]+"_a5_d",            false,  "",      dfNone,          0,     true,       true);
                   }
                   
                   ImageList(0) = "img/btns_search_off.gif";
                   ImageList(1) = "img/btns_search.gif";     // popup icon 이미지
                   ImageList(2) = "img/btns_note.gif";  
                   
				   WaitImageVisible=false;
                   CountPosition = 0;        
                   AutoRowHeight = false;    // 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
                   
				   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
				   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
				   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지

            }
            break;
			
			case "sheet2":      // sheet2 init Multi 용 히든 시트
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

                   var HeadTitle = "week|loc_grp_cd|loc_cd|sim_tp_cd|cntr_tpsz|cntr_qty|ibflag";
                   HeadTitleCnt = ComCountHeadTitle(HeadTitle);
                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "week",             false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "loc_grp_cd",       false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "loc_cd",           false,  "",      dfNone,            0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "sim_tp_cd",        false,  "",      dfNone,            0,     false,      false);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_tpsz",        false,  "",      dfNone,            0,     false,      false);
                   InitDataProperty(0, cnt++ , dtData,       0,   daCenter,        true,        "cntr_qty",         false,  "",      dfNone,            0,     false,      false);
                   InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,        false,       "ibflag");
                   
                   CountPosition = 0;
            }
            break;
        }
    }
    
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {
           case IBSAVE:        //저장
                   ComOpenWait(true); 
                   formObj.f_cmd.value = MULTI01;
                   sheetObj.DoSave("EES_EQR_1003GS.do",FormQueryString(formObj),"ibflag",false);
                   sheetObjects[1].RemoveAll();
                   ComOpenWait(false); 
                   break;
           
           case SEARCH13:        //조회
                
                if(document.form.div_flag[0].checked == true) {
                   if(formObj.sub_loc_cd.value != "" && !doActionIBSheet(sheetObjects[0], document.form, SEARCH02)){
                       return false;
                   }
                }else {
                   if(formObj.loc_cd_second.value != "" && !doActionIBSheet(sheetObjects[0], document.form, SEARCH03)){
                       return false;
                   }                   
                } 
				
				ComOpenWait(true); 
                sheetObjects[0].Redraw = false;
				formObj.f_cmd.value = SEARCH03;
                var sXml = sheetObj.GetSearchXml("EES_EQR_1003GS.do",FormQueryString(formObj));
                //sheetObjects[0].RemoveAll();
                sheetObjects[0].LoadSearchXml(sXml);

                search_end(sheetObjects[0], 2, sheetObjects[0].LastRow);
                calcAverage(sheetObjects[0].HeaderRows, sheetObjects[0].HeaderRows+sheetObjects[0].RowCount);
				calcAllTotal(sheetObjects[0].HeaderRows, sheetObjects[0].HeaderRows+sheetObjects[0].RowCount);
                calcAllBalance(sheetObjects[0].HeaderRows, sheetObjects[0].HeaderRows+sheetObjects[0].RowCount);
                
				sheetObjects[0].Redraw = true;
                ComOpenWait(false);                
                break;
                      
           case SEARCH02:      // Location By 입력값 검증 조회
                       
               formObj.f_cmd.value = SEARCH02;
               
               sheetObj.WaitImageVisible=false;
               var sXml = sheetObj.GetSearchXml("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
               var sCheck = ComGetEtcData(sXml, "check");
                
                if (sCheck != "T") {
                    if (document.form.sub_loc_cd.value != "") {
                        if (document.form.loc_type_code.value == "ES") {
                            ComShowCodeMessage("EQR90203");
                        }else if (document.form.loc_type_code.value == "LE" || document.form.loc_type_code.value == "LS") {
                            ComShowCodeMessage("EQR90202");
                        }else if (document.form.loc_type_code.value == "RE" || document.form.loc_type_code.value == "RS") {
                            ComShowCodeMessage("EQR90201");
                        }
                        
                        document.form.sub_loc_cd.value = "";
                        ComSetFocus(document.form.sub_loc_cd);
                        return false;
                    } else {
                        ComSetFocus(document.form.sub_loc_cd);
                    }
                }
                return true;
               break;                   
               
           case SEARCH03:      // Location 조회
               
               formObj.f_cmd.value = SEARCH02; // 위와 동일함(주의)
               
               sheetObj.WaitImageVisible=false;
               var sXml = sheetObj.GetSearchXml("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
               var sCheck = ComGetEtcData(sXml, "check");
                
                if (sCheck != "T") {
                    if (document.form.loc_cd_second.value != "") {
                        if ( formObj.loc_tp_cd_second.value == 'E' ) {
                            ComShowCodeMessage("EQR90203");
                        } else if ( formObj.loc_tp_cd_second.value == 'L' ) {
                            ComShowCodeMessage("EQR90202");
                        } else if  ( formObj.loc_tp_cd_second.value == 'S' ) { // LCC 단위검색
                            ComShowCodeMessage("EQR90204");
                        }
                        
                        document.form.loc_cd_second.value = "";
                        ComSetFocus(document.form.loc_cd_second);
                        return false;
                    } else {
                        ComSetFocus(document.form.loc_cd_second);
                    }
                }
                return true;
               break;    
        }
    }
      
    /**
    * 모든 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
   	   var level_cd = document.form.level_cd.value;
       with (sheetObj) {
           for(var i = startRow; i <= endRow; i++){
                  
				 //if(  level_cd != 1 // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
//				 if(  level_cd == 3 // level_cd = 3 만 grid 편집 금지.  
//				     ||CellValue(i,"loc_grp_cd")=="R"
//				     ||CellValue(i,"loc_cd")=="TOTAL" 
//                     ||CellValue(i,"code")=="IN"
//                     ||CellValue(i,"code")=="RI"
//                     ||CellValue(i,"code")=="PI"
//                     ||CellValue(i,"code")=="OT"
//					 ||CellValue(i,"code")=="IC"
//					 ||CellValue(i,"code")=="BA"
//					 ||CellValue(i,"code")=="SP"
//					 ||CellValue(i,"code")=="ST"
//					 ||CellValue(i,"code")=="RO"
//					 ||CellValue(i,"code")=="EF"
//				  ){               
//                      RowEditable(i) = false;
//                  } 
				 if(   
					       CellValue(i,"loc_grp_cd")=="R"
					     ||CellValue(i,"loc_cd")=="TOTAL" 
	                     ||CellValue(i,"code")=="IN"
	                     ||CellValue(i,"code")=="RI"
	                     ||CellValue(i,"code")=="PI"
	                     ||(CellValue(i,"code")=="OT" && CellValue(i,"loc_grp_cd")=="L")
						 ||CellValue(i,"code")=="IC"
						 ||CellValue(i,"code")=="BA"
						 ||CellValue(i,"code")=="SP"
						 ||CellValue(i,"code")=="ST"
						 ||CellValue(i,"code")=="RO"
						 ||CellValue(i,"code")=="EF"
				  ){               
	                  RowEditable(i) = false;
	              }else if(   (CellValue(i,"loc_grp_cd")=="E" || CellValue(i,"loc_grp_cd")=="S")
	            	       &&  CellValue(i,"code")=="OT"
	              ) {
	            	  RowEditable(i) = true;
	              } 				 
				  
                  if(   CellValue(i, "loc_grp_cd") != "R" 
                	 && CellValue(i, "loc_cd") != "TOTAL" 
                	 && CellValue(i, "code") != "IN" 
                	 && CellValue(i, "code") != "IC" 
                	 && CellValue(i, "code") != "BA" 
                	 && CellValue(i, "code") != "SP" 
                	 && CellValue(i, "code") != "ST"
                  ){
//                      if(   CellValue(i, "loc_grp_cd") != "R" 
//                     	 && CellValue(i, "loc_cd") != "TOTAL" 
//                     	 && CellValue(i, "code") != "IN" 
//                     	 && CellValue(i, "code") != "OT" 
//                     	 && CellValue(i, "code") != "IC" 
//                     	 && CellValue(i, "code") != "BA" 
//                     	 && CellValue(i, "code") != "SP" 
//                     	 && CellValue(i, "code") != "ST"
//                       ){                	  
                      for(var j = 188; j < LastCol; j++){
                          if(ColSaveName(j).substr(5,2)=="_d"){
                              if(CellValue(i, j) == "Y"){ // _d 로 끝나는 cell value = 'Y' 이면 적색/bold 표시
                                  var colName = ColSaveName(j).substr(0,5);
                                  CellFont("FontBold", i, colName, i, colName) = true;
                                  CellFontColor(i, colName) = RgbColor(255,0,0);
                              }else if(CellValue(i, j) == "X") { // _d 로 끝나는 cell value = 'X' 이면 파란색/bold 표시
                                  var colName = ColSaveName(j).substr(0,5);
                                  CellFont("FontBold", i, colName, i, colName) = true;
                                  CellFontColor(i, colName) = RgbColor(0,0,255);                          
                              } 
                          }
                      }
                  }
                  
				  if(CellValue(i, "code") == "RI" || 
				     CellValue(i, "code") == "PI" || 
				     CellValue(i, "code") == "OT" || 
				     CellValue(i, "code") == "IF"
				  ){
                      RowBackColor(i) = sheetObj.WebColor2SysColor("#F6FAFB"); // 푸른색
                      
                      // Current Week ~ +3Week 
                      // SELCOE 는 Reposition In, Other, Repo Out 팝업 모두 열림
                      if(  (   CellValue(i, "loc_cd") != "TOTAL" 
                    	    && CellValue(i, "loc_grp_cd") != "R"
                    	   )
                           && 
                           (
                        	   CellValue(i, "code")=="RI"
                        	 ||CellValue(i, "code")=="PI"
							 ||
							 (  CellValue(i, "code")=="OT"
							  &&CellValue(i,"loc_grp_cd")=="L"
							 )
							 &&
							 (level_cd=="1" || level_cd=="2" || level_cd=="3")
						   )
					  ){ // OT : loc_grp_cd 가 L 이면 아이콘 만듬
                          for(var k=2; k<weekTpArr.length; k++){ // c0, f1 ~ f7
                              sheetObj.CellImage(i,weekTpArr[k]+"_img") = 1; // 조회 팝업 이미지
                          } 
                      }
                      
                      // -2Week, -1Week, 모든 사용자 
                      // Reposition In, Other 팝업 모두 열림
                      if((CellValue(i, "loc_cd") != "TOTAL" && CellValue(i, "loc_grp_cd") != "R") && 
                         (CellValue(i, "code")=="RI"|| (CellValue(i, "code")=="OT") && CellValue(i,"loc_grp_cd")=="L")){ 
                          for(var k=0; k<2; k++){ // c0, f1 ~ f7
                              sheetObj.CellImage(i,weekTpArr[k]+"_img") = 1; // 조회 팝업 이미지
                          } 
                      }                      
                  }else if(   CellValue(i, "code") == "OF" 
                	       || CellValue(i, "code") == "RO")
                  {
                      RowBackColor(i) = sheetObj.WebColor2SysColor("#FFEAEA"); // 분홍색
                      
                      // Reposition Out 에 돋보기 이미지 추가(현재+미래, RCC 아니고, TOTAL 아니면 출현)
                      if(    CellValue(i, "loc_cd") != "TOTAL" 
                    	  && CellValue(i, "loc_grp_cd") != "R"
                    	  && CellValue(i, "code")=="RO" 
                    	  && (level_cd=="1" || level_cd=="2" || level_cd=="3")
                      ){ 
                            for(var k=2; k<weekTpArr.length; k++){ // c0, f1 ~ f7
                                sheetObj.CellImage(i,weekTpArr[k]+"_img") = 1; // 조회 팝업 이미지
                            } 
                        }         
                      
                      // -2Week, -1Week, 모든 사용자 
                      // Repo Out 팝업 모두 열림
                      if((CellValue(i, "loc_cd") != "TOTAL" && CellValue(i, "loc_grp_cd") != "R") && CellValue(i, "code")=="RO" ){ 
                            for(var k=0; k<2; k++){ // c0, f1 ~ f7
                                sheetObj.CellImage(i,weekTpArr[k]+"_img") = 1; // 조회 팝업 이미지
                            } 
                        }  
                  }else if(CellValue(i, "code") == "IN"){
                      RowBackColor(i) = sheetObj.RgbColor(255,255,255); //흰색
                  }else if(CellValue(i, "code") == "IC"){
                      RowBackColor(i) = sheetObj.RgbColor(240,240,240); //회색
                  // Sales Forecast  
                  }else if(CellValue(i, "code") == "EF"){
                	  if(document.form.show_detail.checked) {
                		  sheetObj.RowHidden(i) = false;
                	  } else {
                		  sheetObj.RowHidden(i) = true;
                	  }
                	  
                	  // Sales Forecast 에 돋보기 이미지 (현재+미래, RCC 아니고, TOTAL 아니면 출현)
                	  //if((CellValue(i, "loc_cd") != "TOTAL" && CellValue(i, "loc_grp_cd") != "R") && (CellValue(i, "code")=="EF") && document.form.level_cd.value=="1") { 
                      if((CellValue(i, "loc_cd") != "TOTAL" && CellValue(i, "loc_grp_cd") != "R") && (CellValue(i, "code")=="EF") ) { 
                		  for(var k=0; k<weekTpArr.length; k++){ // c0, f1 ~ f7
                			  sheetObj.CellImage(i,weekTpArr[k]+"_img") = 1; // 조회 팝업 이미지
                		  }
                	  }
                  }
                  
				  
				  if(CellValue(i, "code") == "IC"){ // 과거 일 때만 보임
                      for(var t=0; t<consTpszArr.length; t++) { 
                          for(var k=2; k<weekTpArr.length; k++){ // c0 ~ f7
                              sheetObj.CellValue2(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase()) = "";
                          }
                      }
                  }else if(CellValue(i, "code") == "PI"){ // 과거 일 때는 안 보임
                      for(var t=0; t<consTpszArr.length; t++) { 
                          sheetObj.CellValue2(i,"p2_"+consTpszArr[t].toLowerCase()) = "";
                          sheetObj.CellValue2(i,"p1_"+consTpszArr[t].toLowerCase()) = "";
                      }
                  }
				  
                  if(CellValue(i,"code")=="PI" && document.form.f_version.value=="A"){
                     RowHidden(i)=true;
                  }
                  
          }
          
          for(var k=0; k<weekTpArr.length; k++){
              sheetObj.ColBackColor(weekTpArr[k]+"_img") = sheetObj.RgbColor(240,240,240);
              sheetObj.ColBackColor(weekTpArr[k]+"_ttl") = sheetObj.RgbColor(193,196,232);
          }
		  for(var t=0; t<consTpszArr.length; t++) { //cntr 전체 tpsz
		  	  sheetObj.ColBackColor("p2_"+consTpszArr[t].toLowerCase()) = sheetObj.RgbColor(240,240,240);
			  sheetObj.ColBackColor("p1_"+consTpszArr[t].toLowerCase()) = sheetObj.RgbColor(240,240,240);
		  }
		  for(var i=HeaderRows; i<=HeaderRows+RowCount; i++){
		  	  if(CellValue(i, "code") == "SP" || CellValue(i, "code") == "ST"){
                  RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 
              }else if(CellValue(i, "code") == "BA"){
                  RowBackColor(i) = sheetObj.WebColor2SysColor("#FFFFA0"); // 노란색 
			  }
		  }
          sheetObj.CellFont("FontBold", 2, "tree", sheetObj.LastRow, "tree") = true;
          sheetObj.CellFont("FontSize", 2, "tree", sheetObj.LastRow, "tree") = 10;
       }
   }
   

    function calcAllTotal(startRow, endRow){
        var sheetObj = sheetObjects[0];
        
        for(var i=startRow; i<=endRow; i++){
            if(sheetObj.CellValue(i,"code")!="BA" && sheetObj.CellValue(i,"code")!="SP" && sheetObj.CellValue(i,"code")!="ST"){
                for(var k=0; k<weekTpArr.length; k++){
                    calcTotal(i,weekTpArr[k]);
                }
            }
        }
    }   
   
    function calcTotal(row, week){
        var sheetObj = sheetObjects[0];
        
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
        
        var tmpTotal = 0;
        for(var t=0; t<arr_tpsz.length; t++){
            tmpTotal = tmpTotal + parseInt(sheetObj.CellValue(row,week+"_"+arr_tpsz[t].toLowerCase()));
        }
        sheetObj.CellValue2(row,week+"_ttl") = tmpTotal;        
    }
    
    
    function calcAllBalance(startRow, endRow){
        var sheetObj = sheetObjects[0];
        
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
        
        for(var i=startRow; i<=endRow; i++){
            if(sheetObj.CellValue(i,"code")=="IN"){
                for(var k=0; k<weekTpArr.length; k++){
                    for(var t=0; t<arr_tpsz.length; t++){
                        calcBalance(i,weekTpArr[k],arr_tpsz[t]);
                    }
                    calcBalance(i,weekTpArr[k],"ttl");
                }
            }
        }
    }
    
    /*
     * 해당 Inventory Row, week, tpsz 의 Balance 를 구한다
     */
    function calcBalance(inRow, week, tpszl){ // Inventory Row, week, tpsz
        var sheetObj = sheetObjects[0];
        
        var version = document.form.f_version.value;
        
        tpsz = tpszl.toLowerCase();
        
		if(sheetObj.CellValue(inRow,"code") != "IN"){ // 행번호로 계산 하므로 inRow 를 IN 에 맞춰야 함
            for(var i=inRow; i>0; i--){
	            if(sheetObj.CellValue(i,"code") == "IN"){
	                inRow = i;
	                break;
	            }
	        }
        }        
        //weekTpArr // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7,f8,f9
        
        // f1 주차 부터는 앞주차의 Balance 를 Inventory 로 가져옴 
        if(week.substr(0,1)=="f"){ // p2, p1, c0 제외
            // 앞 주의 Balance(FCST) 를 Inventory 로 함
            if(week == "f1")
                sheetObj.CellValue2(inRow,week+"_"+tpsz) = sheetObj.CellValue(inRow+9,"c0_"+tpsz);
            else // f2~f9
                sheetObj.CellValue2(inRow,week+"_"+tpsz) = sheetObj.CellValue(inRow+9,"f"+(week.substr(1,1)*1-1)+"_"+tpsz);    
        }
        
        // Balance 계산
        // Actual : IN + RI + OT + IF - OF - RO
        // Plan   : IN + RI + PI + OT + IF - OF - RO
        var tmpTotal = 0 ; 
        if(version == "P" && sheetObj.CellValue(inRow+2,week+"_"+tpsz)!=""){ // Plan
            tmpTotal = parseInt(sheetObj.CellValue(inRow  ,week+"_"+tpsz)) // Inventory
                     + parseInt(sheetObj.CellValue(inRow+1,week+"_"+tpsz)) // Reposition In
                     + parseInt(sheetObj.CellValue(inRow+2,week+"_"+tpsz)) // Planned Repo-In
                     + parseInt(sheetObj.CellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
                     + parseInt(sheetObj.CellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
                     - parseInt(sheetObj.CellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
                     // SALES PROJ 줄이 들어감으로 인해 +1
                     - parseInt(sheetObj.CellValue(inRow+7,week+"_"+tpsz)) // Reposition Out
                     ;
        }else{ // Actual
            tmpTotal = parseInt(sheetObj.CellValue(inRow  ,week+"_"+tpsz)) // Inventory
                     + parseInt(sheetObj.CellValue(inRow+1,week+"_"+tpsz)) // Reposition In
                     + parseInt(sheetObj.CellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
                     + parseInt(sheetObj.CellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
                     - parseInt(sheetObj.CellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
                     - parseInt(sheetObj.CellValue(inRow+7,week+"_"+tpsz)) // Reposition Out
                     ;
        }
        
        sheetObj.CellValue2(inRow+9,week+"_"+tpsz) = tmpTotal;              // Balance       
        
        if(tmpTotal < 0){ // 마이너스는 빨간색
            sheetObj.CellFontColor(inRow+9,week+"_"+tpsz) = sheetObj.RgbColor(255,0,0);
        }else{ // 파란색
            sheetObj.CellFontColor(inRow+9,week+"_"+tpsz) = sheetObj.RgbColor(0,0,0);
        }
        
        // EQ Supply Ratio (PFMC) 계산
        // [Inventory + MG + Repo-in + Others(LT/ST/OW)]/OP 
        var tmpEsp = 0;
        if(parseInt(sheetObj.CellValue(inRow+5,week+"_"+tpsz))==0){ // OP Forecast
            sheetObj.CellValue2(inRow+10,week+"_"+tpsz) = "";        // EQ Supply Ratio (PFMC)
        }else{
            tmpSrp = (   parseInt(sheetObj.CellValue(inRow  ,week+"_"+tpsz)) // Inventory
                       + parseInt(sheetObj.CellValue(inRow+1,week+"_"+tpsz)) // Reposition In
                       + parseInt(sheetObj.CellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
                       + parseInt(sheetObj.CellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
                     ) / parseInt(sheetObj.CellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
                   ;
            sheetObj.CellValue2(inRow+10,week+"_"+tpsz) = tmpSrp.toFixed(1); // 소수점 1째 자리로 반올림
        }
    }
  
  // 6, f7, f8, f9 주차 IF, OF, RO 초기 값인 전 3주의 평균 구하기
  function calcAverage(startRow, endRow){
  	 var sheetObj = sheetObjects[0];
	 // consTpszArr
	 for (var i = startRow; i <= endRow; i++) {
	 	if(sheetObj.CellValue(i,"code")=="IF"||sheetObj.CellValue(i,"code")=="OF"||sheetObj.CellValue(i,"code")=="RO"){
		 	for (var t = 0; t < consTpszArr.length; t++) { //cntr 전체 tpsz
				//for (var k = 6; k < weekTpArr.length; k++) { // f4, f5, f6, f7, f8, f9
				for (var k = 8; k < weekTpArr.length; k++) { // f6, f7, f8, f9	
				    if(sheetObj.CellValue(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase()+"_d")=="N"){ // 메뉴얼 입력 값 없으면
					    var tmpAvg =(  sheetObj.CellValue(i,weekTpArr[k-3]+"_"+consTpszArr[t].toLowerCase())*1
									 + sheetObj.CellValue(i,weekTpArr[k-2]+"_"+consTpszArr[t].toLowerCase())*1
									 + sheetObj.CellValue(i,weekTpArr[k-1]+"_"+consTpszArr[t].toLowerCase())*1
									) / 3 ;
					    sheetObj.CellValue2(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase()) =  tmpAvg.toFixed(0); // 정수로 반올림
                    }				
				}
			}
		}
	 }
  }
    
   
     /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
      var level_cd = document.form.level_cd.value;
	  with (sheetObj) {
		    if(  (level_cd == 1  || level_cd == 2 || level_cd == 3 ) //  level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
			     && ColSaveName(Col).length == 5 
			     && ColSaveName(Col) != "loc_cd" 
			     && CellValue(Row, ColSaveName(Col).substr(0,5)+"_d") == "Y" 
			     && CellValue(Row, "loc_grp_cd") != "R" 
			     && CellValue(Row, "loc_cd") != "TOTAL" 
			     && ( CellValue(Row, "code") == "IF" || CellValue(Row, "code") == "OF" || CellValue(Row, "code") == "RO" || (CellValue(Row, "code") == "OT" && (CellValue(Row,"loc_grp_cd")=="E" || CellValue(Row,"loc_grp_cd")=="S")) )
			){
	  	    	
                show_del_btn(sheetObj, Row, Col);
            }
	  	    
	  	    // INVENTORY 클릭시 INVENTORY 화면으로 팝업연결
	 		if(CellValue(Row, "code") == "IN" && CellValue(Row, "loc_cd") != "TOTAL"){
	 			inv_popUp(sheetObj, Row, Col);
	 		}	  	    

            if (ColSaveName(Col).substr(3,3) == "img") {
            	
                if(CellImage(Row,Col)=="-1" || CellImage(Row,Col)=="0"){ // popup 이미지 없거나, off 이면
                  return false;
                }
                
                // -2week, -1week
    	 		if (ColSaveName(Col).substr(0,2) == "p1" || ColSaveName(Col).substr(0,2) == "p2") {
    	 			if(CellValue(Row,"code")=="RI"){
		                var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
		                           +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))                     
		                           +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
		                           +"&tp_cd=W"
                                   +"&f_cmd=" + SEARCH
		                   ;
		                // popup page separator
		                var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
		                
		                ComOpenWindowCenter("/hanjin/EES_EQR_1081.do?"+ param, "EES_EQR_1081"+page_sep, 1015, 735); 
		                
    	 			}else if(CellValue(Row,"code")=="OT"){ 
		                var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
                        +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))                     
                        +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
                        +"&tp_cd=W"
                        +"&f_cmd=" + SEARCH
                        	;
		                // popup page separator
		                var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
             
		                ComOpenWindowCenter("/hanjin/EES_EQR_1083.do?"+ param, "EES_EQR_1083"+page_sep, 1015, 735); 
    	 				
    	 			}else if(CellValue(Row,"code")=="RO"){ // Reposition Out 팝업
		                var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
                        +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))                     
                        +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
                        +"&tp_cd=W"
                        +"&f_cmd=" + SEARCH
                        	;
		                // popup page separator
		                var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
             
		                ComOpenWindowCenter("/hanjin/EES_EQR_1082.do?"+ param, "EES_EQR_1082"+page_sep, 1015, 735); 

                    }else if(CellValue(Row,"code")=="EF"){	//  Sales Forecast Detail 팝업
    			    	
    			    	var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
    			    				+"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
				    			    +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")
				    			    +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
				    			    +"&pop_mode=Y" + "&f_cmd=" + SEARCH ;
    			    	
    			    	ComOpenPopup("/hanjin/EES_EQR_1004.do?"+ param, 1070, 705, "Sales Forecast Detail", "1,0,1,1,1,1,1,1", true);
                    }
    	 		}else {  // Current Week, +1week, +2week, +3week                
                    if(CellValue(Row,"code")=="RI"){
			  	         
		                var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
		                   +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
		                   +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")                            
		                   +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
		                   +"&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
		                   +"&row="+Row
		                   +"&f_cmd=" + SEARCH
		                   +"&level_cd=" + document.form.level_cd.value
		                   ;
		                var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
		                 
		                //유저요청에 의해 다중팝업이 가능하도록 변경, 2013-01-16, 송현애 과장 요청
		                //ComOpenPopup("/hanjin/EES_EQR_1048.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
		                ComOpenWindowCenter("/hanjin/EES_EQR_1048.do?"+ param, "EES_EQR_1048"+page_sep, 1015, 735);            
				     
                    }else if(CellValue(Row,"code")=="PI"){  // Planned In
                        var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
                           +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
                           +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")                            
                           +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
                           +"&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
                           +"&row="+Row
                           +"&f_cmd=" + SEARCH
                           +"&level_cd=" + document.form.level_cd.value
				    	   +"&tpsz_flag=" + document.form.tpsztype.Text;
                           ;
                        var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
                        
                         //유저요청에 의해 다중팝업이 가능하도록 변경, 2013-01-16, 송현애 과장 요청
                        //ComOpenPopup("/hanjin/EES_EQR_1048.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
                        ComOpenWindowCenter("/hanjin/EES_EQR_1040.do?"+ param, "EES_EQR_1048"+page_sep, 1015, 735);   
                        
                    }else if(CellValue(Row,"code")=="OT"){ // ON-HIRE APPROVAL 팝업오픈
                    
				    	var param = "pop_mode=Y"
				    	          + "&yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) 
				    	          + "&tpsz_flag=" + document.form.tpsztype.Text
				    	          + "&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
                                  + "&row="+Row ;
				    	// LCC_CD 
				    	if (sheetObj.CellValue(Row, "loc_grp_cd") == "L") {
				    		param += "&lcc_cd=" + sheetObj.CellValue(Row, "loc_cd").substr(0, 5);
				    	}else{
				    		return false;
				    	}
                        var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
                        
                        ComOpenWindowCenter("/hanjin/EES_EQR_1041.do?"+ param, "EES_EQR_1041"+page_sep, 1015, 655);
                        
                    }else if(CellValue(Row,"code")=="RO"){ // Reposition Out 팝업
			  	         
		                var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
		                   +"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
		                   +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")                            
		                   +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
		                   +"&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
		                   +"&row="+Row
		                   +"&f_cmd=" + SEARCH
		                   +"&level_cd=" + document.form.level_cd.value
		                   ;
		                var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
		                
		                ComOpenWindowCenter("/hanjin/EES_EQR_1049.do?"+ param, "EES_EQR_1049"+page_sep, 1015, 735);            
		                
                    }else if(CellValue(Row,"code")=="EF"){	//  Sales Forecast Detail 팝업
    			    	
    			    	var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
    			    				+"&fcast_yrwk=" + sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
				    			    +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")
				    			    +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
				    			    +"&pop_mode=Y" + "&f_cmd=" + SEARCH ;
    			    	
    			    	ComOpenPopup("/hanjin/EES_EQR_1004.do?"+ param, 1070, 705, "Sales Forecast Detail", "1,0,1,1,1,1,1,1", true);
                    }
    	 		}
              
          }
          if(ColSaveName(Col) == "tree"){
              var addRow = (parseInt(((Row-2)/12))+1)*12+2        //선택한 세트 아래에 삽입하기 위한 row 계산
              var locGrpCd = "";
              if (CellValue(Row, "loc_grp_cd") == "R"){
                  locGrpCd = "L";
              }else if (CellValue(Row, "loc_grp_cd") == "L"){
                  locGrpCd = "E";
              }else if (CellValue(Row, "loc_grp_cd") == "E"){
                  locGrpCd = "S";
              }

              if(locGrpCd == "") return;  // SCC 는 +- 작동하지 않음(중요).
              
              var locCd = CellValue(Row, "loc_cd").substr(0,5);
              if(CellValue(Row, Col) == "+"){
                  if(CellValue(Row, "loc_cd").substr(0,5) != CellValue(addRow, "ori_loc_cd") || CellValue(addRow, "loc_grp_cd") != locGrpCd){    //최초 클릭시만 조회
                      var formObj = document.form;
                        formObj.f_cmd.value = SEARCH03;
                        var endRow = 0;
                      if(locGrpCd == "L" || locGrpCd == "E" || locGrpCd == "S"){    //loc_grp_cd가 L이거나 E이거나 S일 때만 조회(R일 때는 최초 조회함)
                            ComOpenWait(true); 
                            Redraw = false;
							
						    var param = "f_cmd="             + formObj.f_cmd.value
                                      + "&pagerows="         + formObj.pagerows.value
                                      + "&level_cd="         + formObj.level_cd.value
                                      + "&ofc_cd="           + formObj.ofc_cd.value
									  + "&loc_tp_cd_second=" + formObj.loc_tp_cd_second.value
                                      + "&loc_grp_cd="       + locGrpCd
                                      + "&loc_cd="           + locCd
                                      + "&ori_loc_cd="       + CellValue(Row, "ori_loc_cd")
                                      + "&ori_ori_loc_cd="   + CellValue(Row, "ori_ori_loc_cd")
                                      + "&div_flag=0"  // 왼쪽 +클릭을 의미함 (중요)
                                      ;
									  
                            var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1003GS.do", param + "&fcast_yrwk="+formObj.fcast_yrwk.value);
                            sheetObjects[0].LoadSearchXml(sXml, true, addRow);
                            endRow = parseInt(ComGetTotalRows(sXml));
                            
                            search_end(sheetObjects[0], addRow, addRow+endRow);          
                            calcAverage(addRow, addRow+endRow);
							calcAllTotal(addRow, addRow+endRow);
                            calcAllBalance(addRow, addRow+endRow);
                            
							Redraw = true;
                            ComOpenWait(false); 
                      }
                  }
                  for(var i = addRow-12; i < addRow; i++){
                      CellValue2(i, Col) = "-";
                      CellFont("FontBold", i, "tree", i, "tree") = true;
                      CellFont("FontSize", i, "tree", i, "tree") = 13;
                  }
              }else if(CellValue(Row, Col) == "-"){    //실제로 펼쳐진 경우에만 감춤 // 재 검토 하자 mds
                  for(var i = Row; i <= LastRow; i++){
                      if((CellValue(i, "loc_grp_cd") == locGrpCd && CellValue(i, "ori_loc_cd") == locCd) || 
                              ((locGrpCd == "E") && (CellValue(i, "loc_grp_cd") == "S" && CellValue(i, "ori_ori_loc_cd") == locCd)) || 
                              ((locGrpCd == "L") && (CellValue(i, "loc_grp_cd") == "E" && CellValue(i, "ori_ori_loc_cd") == locCd) || (CellValue(i, "loc_grp_cd") == "S" && CellValue(i, "ori_ori_ori_loc_cd") == locCd))){
                            sheetObjects[0].RowDelete(i, false);    
                            i--;
                      }
                  }
                  for(var i = addRow-12; i < addRow; i++){
                      CellValue2(i, Col) = "+";
                      CellFont("FontBold", i, "tree", i, "tree") = true;
                      CellFont("FontSize", i, "tree", i, "tree") = 10;
                  }
              }
          }
		  
      }
  }
   
   
    
    /**
      * 모든 시트의 값 변경 시 저장할 내용을 sheet7에 복사
      */
    function copy_save_data(sheetObj, Row, Col, Value){
          with (sheetObjects[1]) {
              var week       = sheetObj.CellValue(Row, sheetObj.ColSaveName(Col).substr(0,2)); // week
              var locGrpCd   = sheetObj.CellValue(Row, "loc_grp_cd");
              var locCd      = sheetObj.CellValue(Row, "loc_cd").substr(0,5);
              var simTpCd    = sheetObj.CellValue(Row, "code");
              var cntrTpsz   = sheetObj.ColSaveName(Col).substr(3,2);
              var dup        = 0;

              for(var i = 0; i <= LastRow; i++){
                  if(CellValue(i, "week") == week && CellValue(i, "loc_grp_cd") == locGrpCd && CellValue(i, "loc_cd") == locCd && CellValue(i, "sim_tp_cd") == simTpCd && CellValue(i, "cntr_tpsz") == cntrTpsz){
                      CellValue(i, "cntr_qty")     = Value;
                      dup++;
                  }
              }
              if(dup == 0){
                  DataInsert(-1);
                  CellValue(LastRow, "week")         = week;
                  CellValue(LastRow, "loc_grp_cd")   = locGrpCd;
                  CellValue(LastRow, "loc_cd")       = locCd;
                  CellValue(LastRow, "sim_tp_cd")    = simTpCd;
                  CellValue(LastRow, "cntr_tpsz")    = cntrTpsz;
                  CellValue(LastRow, "cntr_qty")     = Value;
              }
          }
    }	

    /**
     * 모든 sheet 클릭시 이벤트 발생
     */
    function click_del_btn(sheetObj, Row, Col){
         with (sheetObj) {
             ComOpenWait(true);
             var formObj = document.form;
               formObj.f_cmd.value = SEARCH01;
               
             var param = "f_cmd="          + formObj.f_cmd.value
	                   + "&pagerows="      + formObj.pagerows.value
	                   + "&loc_grp_cd="    + CellValue(Row, "loc_grp_cd")
	                   + "&loc_cd="        + CellValue(Row, "loc_cd").substr(0,5)
	                   + "&week="          + CellValue(Row, sheetObj.ColSaveName(Col).substr(0,2))
	                   + "&cntr_tpsz="     + ColSaveName(Col).substr(3,2)
	                   + "&sim_tp_cd="     + CellValue(Row, "code");
             var sXml = GetSearchXml("EES_EQR_1003GS.do", param);
             if(ComGetEtcData(sXml, "cntr_qty") != null && ComGetEtcData(sXml, "cntr_qty") != "" && ComGetEtcData(sXml, "cntr_qty") != "0"){
                 CellValue2(Row, Col) = ComGetEtcData(sXml, "cntr_qty");
             }else{
                 CellValue2(Row, Col) = 0;
             }
             copy_save_data(sheetObj, Row, Col, "D");
             ComOpenWait(false);
         }
    }

   /**
	* 모든 sheet 클릭시 이벤트 발생
	*/
	function show_del_btn(sheetObj, Row, Col){
	   if(mouseFlag){
	       sheetObj.InitColumnPopup(Col, 1, "Return", "");
	       sheetObj.ShowColumnPopup(Row, Col, false);
	   }
	   sheetObj.InitColumnPopup(Col, 0, "", "");
	}	

    /**
     * sheet6 값 변경 시 이벤트 발생
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
         with (sheetObj) {
             if(Value == "Return"){
                 CellValue2(Row, ColSaveName(Col).substr(0,5)+"_d") = "N";
                 CellFont("FontBold", Row, Col, Row, Col) = false;
                 CellFontColor(Row, Col) = RgbColor(0,0,0);
                 click_del_btn(sheetObj, Row, Col);
             }else{
			 	 if ( sheetObj.CellValue(Row,Col) == '' ) {  //data format int형 널 방지
                    sheetObj.CellValue2(Row,Col) = 0;
                 }
                 if(Value != ''){
				 	 CellValue2(Row, ColSaveName(Col).substr(0,5)+"_d") = "Y";
	                 CellFont("FontBold", Row, Col, Row, Col) = true;
	                 CellFontColor(Row, Col) = RgbColor(255,0,0);
	                 if(CellValue(Row,"code")=="IF" || CellValue(Row,"code")=="OF" || CellValue(Row,"code")=="RO" || CellValue(Row,"code")=="OT"){
					      copy_save_data(sheetObj, Row, Col, Value);
					 }
				 }
             }
			 calcAfterEdit(Row, ColSaveName(Col).substr(0,2), ColSaveName(Col).substr(3,2));
         }
     }
  function calcAfterEdit(Row, week, tpsz){
  	switch(week){
		case "c0":
		    calcTotal(Row, "c0");
		    calcBalance(Row, "c0", tpsz);
		    calcBalance(Row, "c0", "ttl");  
		case "f1":
		    calcTotal(Row, "f1");
            calcBalance(Row, "f1", tpsz);
            calcBalance(Row, "f1", "ttl");  
		case "f2":
		    calcTotal(Row, "f2");
            calcBalance(Row, "f2", tpsz);
            calcBalance(Row, "f2", "ttl");  
		case "f3":
		    calcTotal(Row, "f3");
            calcBalance(Row, "f3", tpsz);
            calcBalance(Row, "f3", "ttl");  
		case "f4":
		    calcTotal(Row, "f4");
            calcBalance(Row, "f4", tpsz);
            calcBalance(Row, "f4", "ttl");  
		case "f5":
		    calcTotal(Row, "f5");
            calcBalance(Row, "f5", tpsz);
            calcBalance(Row, "f5", "ttl");  
		case "f6":
		    calcTotal(Row, "f6");
            calcBalance(Row, "f6", tpsz);
            calcBalance(Row, "f6", "ttl");  
		case "f7":
		    calcTotal(Row, "f7");
            calcBalance(Row, "f7", tpsz);
            calcBalance(Row, "f7", "ttl");  
		case "f8":
		    calcTotal(  Row, "f8");
            calcBalance(Row, "f8", tpsz);
            calcBalance(Row, "f8", "ttl");  
		case "f9":
		    calcTotal(  Row, "f9");
            calcBalance(Row, "f9", tpsz);
            calcBalance(Row, "f9", "ttl");              
		  break;
	}
  }   
  
   /**
   * 모든 sheet 클릭시 이벤트 발생
   */
  function inv_popUp(sheetObj, Row, Col){
       with (sheetObj) {
           var locTypeCode = "";
           var inquiryLevel = "";
           if(CellValue(Row, "loc_grp_cd") == "R"){
               locTypeCode = "3";
               inquiryLevel = "R";
           }else if(CellValue(Row, "loc_grp_cd") == "L"){
               locTypeCode = "4";
               inquiryLevel = "L";
           }else if(CellValue(Row, "loc_grp_cd") == "L"){
               locTypeCode = "6";
               inquiryLevel = "E";
           }else{
               locTypeCode = "7";
               inquiryLevel = "S";
           }
           var param = "eqr_loc_type_code=" + locTypeCode
               +"&eqr_loc_cd=" + CellValue(Row, "loc_cd").substr(0,5);
                  +"&location=" + CellValue(Row, "loc_cd").substr(0,5);
                  +"&inquiryLevel=" + inquiryLevel;
           ComOpenPopup("/hanjin/EES_CIM_0008.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
       }
  }

  /**
   * shee6 클릭시 이벤트 발생
   */
  function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y)  {
       if(Button==1) {   // 왼쪽버튼
           mouseFlag = true; 
       }else if(Button==2) {  // 오른쪽 버튼
           mouseFlag = false; 
       }   
  }
   
   /**
    * Location 변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
   function loc_cd_onchange() {
        if(document.form.loc_cd.value == ""){ // ALL 선택            
            document.form.div_flag[0].disabled = true;
            document.form.div_flag[1].disabled = true; 
              
            ComEnableObject(document.form.sub_loc_cd,  false);  // Location by 입력창 비활성화
            ComEnableObject(document.form.btn_loc_cd,  false);  // Location by 돋보기창 비활성화
            
            ComEnableObject(document.form.loc_cd_second,      false); // Location 입력창 비활성화
            ComEnableObject(document.form.btn_loc_cd_second,  false); // Location 돋보기창 비활성화       
                        
        }else{ // ALL 이 아닌 경우
            document.form.div_flag[0].disabled = false;
            document.form.div_flag[1].disabled = false;                   
            
            changeInputStatus(); // radio 클릭 상태에 따른 상태변경
        }
        
        // location 선택창 비우기 혹은 RCC 복사
        loc_type_code_onchange();
        loc_tp_cd_second_onchange();
   }
    
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function loc_type_code_onchange() {
        
        // LOCATION BY 입력값 초기화 혹은 RCC 값 입력
         if(document.form.loc_type_code.value != "RE" && document.form.loc_type_code.value != "RS"){ // RCC(by ECC) 혹은 RCC(by SCC)
            document.form.sub_loc_cd.value = "";
            if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
                document.getElementById("sub_loc_cd").focus();
            }             
         }else{ 
             document.form.sub_loc_cd.value = document.form.loc_cd.value;        
         }
    }
    
    /**
     * Location 변경시 이벤트 처리
     */
    function loc_tp_cd_second_onchange() {
         document.form.loc_cd_second.value = "";

        if(document.form.loc_cd.value != "" && document.form.div_flag[1].checked == true) {
            document.getElementById("loc_cd_second").focus();
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
            case "sub_loc_cd":
                ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
                break;
                
            case "loc_cd_second":
                ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
                break;                
        }
    }
     
     /**
      * Location  blur 이벤트 처리
      * Location  blur 코드 적합성 체크
      */    
     function sub_loc_cd_onkeyUp() {
         var formObject = document.form;
        if ( formObject.sub_loc_cd.value.length == 5 ) { 
            if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && document.form.sub_loc_cd.value != "") {
                 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
            }
        }
     }
     
     /**
      * Location  blur 이벤트 처리
      * Location  blur 코드 적합성 체크
      */    
     function loc_cd_second_onkeyUp() {
         var formObject = document.form;
        if ( formObject.loc_cd_second.value.length == 5 ) { 
            if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && document.form.loc_cd_second.value != "") {
                 doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
            }
        }
     }     
     
    /**
     * Radio Button 클릭시 이벤트 발생
     */
    function changeInputStatus() {
        if(document.form.div_flag[0].checked == true) {
            ComEnableObject(document.form.sub_loc_cd,         true);            
            ComEnableObject(document.form.loc_cd_second,        false);
            ComEnableObject(document.form.btn_loc_cd,            true);         // Location by 돋보기창 활성화
            ComEnableObject(document.form.btn_loc_cd_second,  false);  // Location 돋보기창 비활성화
            
            document.form.loc_cd_second.value="";
            document.getElementById("sub_loc_cd").className = "input";
            document.getElementById("sub_loc_cd").focus();
            
            loc_type_code_onchange(); //Location by 변경시 이벤트 처리
            
        }else {  // 두번째 라디오 선택(Location)
            ComEnableObject(document.form.sub_loc_cd,         false);
            ComEnableObject(document.form.loc_cd_second,        true);
            ComEnableObject(document.form.btn_loc_cd,            false);         // Location by 돋보기창 활성화
            ComEnableObject(document.form.btn_loc_cd_second,  true);  // Location 돋보기창 활성화
            
            document.form.sub_loc_cd.value="";
            document.getElementById("loc_cd_second").className = "input";
            document.getElementById("loc_cd_second").focus();
        }
        
        
    }     
    
	
   /**
    * 1048 팝업에서 선택한 repo in total값 Setting.
    * 1040 팝업에서 선택한 planned repo in total값 Setting.
    */
    function setRepoInValue(week, sheet_row, tpsz, value){
        // 의도적으로 event 발생시킴
        sheetObjects[0].CellValue(sheet_row, week+"_"+tpsz) =  ComAddComma(value);
    }    
    
    /**
     * 1049 팝업에서 선택한 repo in total값 Setting.
     */
     function setRepoOutValue(week, sheet_row, tpsz, value){

         // 의도적으로 event 발생시킴
         sheetObjects[0].CellValue(sheet_row, week+"_"+tpsz) =  ComAddComma(value);
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
        
        if ( srcName == "f_version"){
            var version = document.form.f_version.value;
            if(version == "P"){ // version Plan (P) // f4, f5, f6, f7, f8, f9 - Planned Repo-In 보임 
                //for(var k = 6; k < weekTpArr.length; k++){ // f4,f5,f6,f7,f8,f9 히든
                for(var k = 8; k < weekTpArr.length; k++){ // f6,f7,f8,f9 히든
                    sheetObjects[0].ColHidden(weekTpArr[k]+"_img")= false;
                    sheetObjects[0].ColHidden(weekTpArr[k]+"_ttl")= false;
                }
                for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].HeaderRows+sheetObjects[0].RowCount;i++){
                    if(sheetObjects[0].CellValue(i,"code")=="PI"){
                        sheetObjects[0].RowHidden(i) = false;
                    }
                }
            }else{ // version Actual (A) // f6, f7, f8, f9 - Planned Repo-In 숨김
                //for(var k = 6; k < weekTpArr.length; k++){ // f4,f5,f6,f7,f8,f9 히든
                for(var k = 8; k < weekTpArr.length; k++){ // f6,f7,f8,f9 히든
                    sheetObjects[0].ColHidden(weekTpArr[k]+"_img")= true;
                    sheetObjects[0].ColHidden(weekTpArr[k]+"_ttl")= true;
                }
                for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].HeaderRows+sheetObjects[0].RowCount;i++){
                    if(sheetObjects[0].CellValue(i,"code")=="PI"){
                        sheetObjects[0].RowHidden(i) = true;
                    }
                }
            }
            setGridHidden(form.tpsztype.Text);
            calcAllBalance(sheetObjects[0].HeaderRows, sheetObjects[0].HeaderRows+sheetObjects[0].RowCount);
        }
    }
    
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
        var sheetObj = sheetObjects[0]; 
		var tpsz_cd = form.tpsztype.Text;
		var arr_tpsz = tpsz_cd.split(",");
		
		ComOpenWait(true);
		calcAllTotal(sheetObjects[0].HeaderRows, sheetObjects[0].HeaderRows+sheetObjects[0].RowCount);
		for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].HeaderRows+sheetObjects[0].RowCount; i++){
            if (sheetObj.CellValue(i, "code") == "IN") {
				for (var k = 0; k < weekTpArr.length; k++) {
					for(var t = 0; t < arr_tpsz.length; t++){
					   if(sheetObj.CellValue(i+9, weekTpArr[k]+"_"+arr_tpsz[t].toLowerCase()) == "")
					       calcBalance(i, weekTpArr[k], arr_tpsz[t].toLowerCase());
					}
					calcBalance(i, weekTpArr[k], "ttl");
				}
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
        var version = document.form.f_version.value;

        if(version == "P"){ // version Plan (P)        
            for(var k = 0; k < weekTpArr.length; k++){ // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7,f8,f9 로 루프
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.ColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase())= false;
                            break;
                        }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.ColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase())= true;
                        }
                    }       
                }  
            }
        }else{ // version Actual (A)
            for(var k = 0; k < 8; k++){ // p2,p1,c0,f1,f2,f3,f4,f5 로 루프
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.ColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase())= false;
                            break;
                        }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.ColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase())= true;
                        }
                    }       
                }  
            }
            for(var k = 8; k < weekTpArr.length; k++){ // f6,f7,f8,f9 히든
                for(var i=0;i<consTpszArr.length;i++){ // 전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ // 선택된 Container Type/Size
                        sheetObj.ColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase())= true;
                    }       
                }
            }
        }
    }    
    
    /**
     * New 버튼 클릭시 화면 초기화.
     */
    function init_form() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	// RCC 초기화
    	formObj.loc_cd.value = "";
    	loc_cd_onchange();  // RCC 선택값에 의한 LOCATION 초기화
    	
    	// VERSION 초기화
    	formObj.f_version.value = "A";
    	
    	//CNTR TY/SZ DRY로 설정
    	formObj.cntrTpsz.selectedIndex = 1; // Dry 선택
    	tpszChange("D");

    	// GRID 초기화
    	sheetObj.RemoveAll();

    }    
	
    /**
     * Detail 버튼 클릭 시 hidden상태인 Sales Prjoection 정보 보여주기.
     * 
     */
    function showDetail() {
    	var sheetObj = sheetObjects[0];
    	var formObject = document.form;
    	// row를 hidden으로 detail 정보를 가지고 있다가 버튼을 누르면 hidden으로 된 detail정보를 모두 조회.
    	if(formObject.show_detail.checked) {
    		for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
    			if(sheetObj.CellValue(i, "code") == "EF") {
    				sheetObj.RowHidden(i) = false;
    			}
    		}
		// 체크를 해지하면 반전.
    	} else {
    		for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
    			if(sheetObj.CellValue(i, "code") == "EF") {
    				sheetObj.RowHidden(i) = true;
    			}
    		}
    	}
    }
    
    /* 개발자 작업  끝 */