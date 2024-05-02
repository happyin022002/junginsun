/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1074.js
*@FileTitle : MT Inventory Simulation by Yard - Booking by Yard 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.11 문동선
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1074 : EES_EQR_1074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1074() { 
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    
    var rptTtl = "";
    var rptTtlArr = new Array();
    
    var comboObjects = new Array();
    var comboCnt = 0 ;
    
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

            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"");
                ComOpenWait(false);
                break;
				
			case "btn_close":
                window.close();
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
		
		// popup 
		document.form.loc_type_code.value = document.form.p_loc_type_code.value;
		document.form.cntrTpsz.value      = document.form.p_cntrTpsz.value;
		document.form.tpsztype.Text       = document.form.p_tpsztype.value; 
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); // 조회
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
                   style.height = 465;
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
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                   InitHeadMode(false, false, false, true, false,false);
                   
                   var HeadTitle1 = "LOC|Section\nType|code|grp_cd|sort";
                   var HeadTitle2 = "LOC|Section\nType|code|grp_cd|sort";
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
                   //Rows = 36;
                   InitHeadRow(0, HeadTitle1, true);
                   InitHeadRow(1, HeadTitle2, true);
                   sheetObj.FrozenCols = 5;
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   //loc_cd|code|name|grp_cd|sort
                   InitDataProperty(0, cnt++ , dtData,       65,   daCenter,     true,       "loc_cd",             false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtData,       55,   daLeft,       true,       "name",               false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "code",               false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "grp_cd",             false,  "",      dfNone,          0,     true,      true);
                   InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,     false,      "sort",               false,  "",      dfNone,          0,     true,      true);

                   
                   for(i = 0; i < rptTtlArr.length; i++){
                       var calcLogic = "0*1";
                       if (form.tpsztype.Text != "") {
					   	   var arr_tpsz = form.tpsztype.Text.toLowerCase().split(",");
						   for (var t = 0; t < arr_tpsz.length; t++) {
						       calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|";
						   }
					   }
                       InitDataProperty(0, cnt++ , dtData,      47,   daRight,      false,      "ttl_"+rptTtlArr[i],             false,  calcLogic, dfInteger,        0,     false,      false);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "d2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "d4_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "d5_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "d7_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "r2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "r5_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "r9_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "o2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "s2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "o4_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "s4_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "f2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "a2_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "f4_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "a4_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "f5_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
                       InitDataProperty(0, cnt++ , dtData,      42,   daRight,      false,      "a5_"+rptTtlArr[i],              false,  "",      dfInteger,          0,     true,       true);
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
                    sheetObj.Redraw = false;
                    
                    formObj.f_cmd.value = SEARCH;
                    
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1074GS.do", FormQueryString(formObj));
                    rptTtl = ComRtrim(ComGetEtcData(sXml, "rpt_ttl"),",");
                    initSheet(sheetObj, 1);
                    sheetObj.LoadSearchXml(sXml);
                    
					search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
					sheetObj.LeftCol = 0; // 맨 앞으로 스크롤 이동
					
                    setGridHidden(formObj.tpsztype.Text); // TPSZ hidden 
                    sheetObj.Redraw = true;
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
            switch(sAction) {
                case IBSEARCH:
                    // LOC 조회 조건
                    if(formObj.loc_type_code.value != "1" && formObj.loc_cd.value == ""){ // ALL 선택 아닌데, loc_cd 값이 없으면
                        ComShowCodeMessage("EQR01101", "Location Code"); // 'Please input {?msg1}.'
                        ComSetFocus(formObj.loc_cd);
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

   /**
    * 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
        with (sheetObj) {
            if (rptTtl != "") {
                rptTtlArr = rptTtl.split(",");
            
                for(var j = 5; j<=LastCol; j++){
                    if(   ColSaveName(j).split("_")[1] == rptTtlArr[0]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[1]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[2]){
                       //|| ColSaveName(j).split("_")[0] == "ttl"){
                        
                        ColBackColor(j) = UnEditableColor; 
                       }
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
			
			var tpsz_cd = form.tpsztype.Text;
			var arr_tpsz = tpsz_cd.toLowerCase().split(",");
			
			for (var k = 0; k < rptTtlArr.length; k++) {
				var calcLogic = "0*1";  
				if(tpsz_cd != ""){
					for (var t = 0; t < arr_tpsz.length; t++) {
						calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[k] + "|";
					}
				}
				var colNum = sheetObj.SelectCol;
			    for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
					sheetObj.InitCellProperty(i, "ttl_" + rptTtlArr[k], dtData, daRight, "ttl_" + rptTtlArr[k], calcLogic, dfNumber, 0);
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
        setTtlColumn();
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