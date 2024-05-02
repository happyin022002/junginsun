/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1012.js
*@FileTitle : MT Inventory Simulation by Yard
*Open Issues :
*Change history : * 2014.02.05  [CHM-201428796] SELCTY --> SELCOE 로 변경 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1012 : EES_EQR_1012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1012() { 
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
        this.setTabObject=setTabObject;
        this.sheet2_OnPopupClick=sheet2_OnPopupClick;    
    }
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var rptTtl="";
    var rptTtlArr=new Array();
    var calcedTpsz=""; // formula 계산된 tpsz 를 저장하는 변수
    var comboObjects=new Array();
    var comboCnt=0 ;
	var editAuth=false; // 로그인 한 user 의 편집 권한
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //  
    var tpszallText="D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode="D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText="D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode="D2|D4|D5|D7";
    var tpszrfrText="R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode="R2|R5|R9";
    var tpszotText="O2|O4|S2|S4";    // OT  TYPE SIZE 
    var tpszotCode="O2|O4|S2|S4";
    var tpszfrText="F2|F4|F5|A2|A4"; // FR  TYPE SIZE 
    var tpszfrCode="F2|F4|F5|A2|A4"; 
    var consTpsz="D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr=consTpsz.split(',');
    var consTpszDry="D2,D4,D5,D7";
    var consTpszRfr="R2,R5,R9";
    var consTpszOt="O2,O4,S2,S4";
    var consTpszFr="F2,F4,F5,A2,A4";
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt=0;
        var sheet2=sheetObjects[shtCnt];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
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
                calcedTpsz=""; // 계산된 tpsz 내역 초기화       
				formObject.show_history.checked=false;
                formObject.show_detail.checked=false;
				formObject.trade.SetSelectCode("");
				formObject.subtrade.SetSelectCode("");
				formObject.lane.SetSelectCode("");
				formObject.subconti.SetSelectCode("");
                formObject.cntrTpsz.selectedIndex=1;   // Dry 선택
                tpszChange('D');                         // Dry 선택
                break;  
            case "btn_downExcel":
                ComOpenWait(true);
                sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false,SheetName:"Head"});
                sheetObjects[1].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false,SheetName:"Location"});
                ComOpenWait(false);
                break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
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
       sheetObjects[sheetCnt++]=sheet_obj;
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
        comboObjects[comboCnt++]=combo_obj;
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
        document.form.cntrTpsz.selectedIndex=1; // Dry 선택
        tpszChange('D'); // Dry 선택
//        ComBtnDisable("btn_Save"); // Save 버튼 비활성
        var level_cd=document.form.level_cd.value;
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
        	editAuth=false;
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        	ComBtnDisable("btn_Save");
        	ComBtnDisable("btn_downExcel");        	
        } else {
        	// 나머지는 level에 따라서 조회 자체에서 걸르게 된다는 전제로 일단 권한을 풀어준다.
        	editAuth=true;
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_New");
        	ComBtnEnable("btn_Save");
        	ComBtnEnable("btn_downExcel");        	
        }         
		var formObj=document.form;	
		//Trade, Sub Trade, Lane Multi Select ComboBox
		//[elemName, isAll, isRepTrade, del, isSelect, isPus, isMulti]
	    searchOptionTrade("trade", true, true,"","","",false);
		trade.SetSelectCode("");
	    subtrade.SetSelectCode("");
	    lane.SetSelectCode("");
		setSubcontiEnable();
		doActionIBSheet(sheetObjects[1],formObj,SEARCH04); // Sub-Conti 콤보 조회
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        if(rptTtl != ""){
            rptTtlArr=rptTtl.split(",");
        }
        switch(shtID) {
            case "sheet1":      // sheet1 
                with(sheetObj){
                
              var HeadTitle1="Name|code";
              var HeadTitle2="Name|code";
              for (var i=3; i < rptTtlArr.length; i++) { // 현재,미래
              HeadTitle1 += "|"+rptTtlArr[i]+"|"+rptTtlArr[i]+"|"+rptTtlArr[i]+"|"+rptTtlArr[i] ;
              HeadTitle2 += "|TEU|L/F|M/Ton|L/F";
              }
              HeadTitleCnt=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:"name",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    for(var i = 3; i < rptTtlArr.length; i++){   // 현재,미래
              cols.push({Type:"Int",       Hidden:0,  Width:58,   Align:"Right",   ColMerge:0,   SaveName:"qty_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"lf_"+rptTtlArr[i],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Int",       Hidden:0,  Width:67,   Align:"Right",   ColMerge:0,   SaveName:"wgt_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"wgtlf_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              }
         
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SelectHighLight=false; //HighLight를 설정하지 않음
             // SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
             // SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
             // SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
              SetSheetHeight(350);
              SetSheetWidth(550);
              }


            break;
            case "sheet2":      //sheet2 init
                with(sheetObj){
                
	              var HeadTitle1="LCC|SCC|Section/type|code|grp_cd|sort";
	              var HeadTitle2="LCC|SCC|Section/type|code|grp_cd|sort";
	              for(var i=0; i < rptTtlArr.length; i++){
		              for(var j=0; j < 17; j++){
		            	  HeadTitle1 += "|" + rptTtlArr[i];
		              }
		              HeadTitle2 += "|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	              }
              
	              for(var i=3; i < rptTtlArr.length; i++){
		              for(var j=0; j < 16; j++){
		            	  HeadTitle1 += "|" + rptTtlArr[i];
		              }
		              HeadTitle2 += "|d2_b|d4_b|d5_b|d7_b|r2_b|r5_b|r9_b|o2_b|s2_b|o4_b|s4_b|f2_b|a2_b|f4_b|a4_b|f5_b";
	              }
              
              
	              HeadTitleCnt=ComCountHeadTitle(HeadTitle1);
	             // (HeadTitleCnt, 0, 0, true);
	              //sheetObj.FrozenCols=5;
	
	              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"name",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"code",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sort",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              for(var i = 0; i < rptTtlArr.length; i++){
			              var calcLogic = "0*1";
			              var allLogic  = "0*1";
			              if (!tpsztype.SetSelectText("")) {
				              var arr_tpsz = tpsztype.GetSelectText().toLowerCase().split(",");
				              for (var t = 0; t < arr_tpsz.length; t++) {
				            	  calcLogic = calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|"; // 보이는 tpsz 의 합
				              }
				              
				              for (var t = 0; t < consTpszArr.length; t++) {
				            	  allLogic = allLogic + "+|" + consTpszArr[t].toLowerCase() + "_" + rptTtlArr[i] + "|";    // 모든 tpsz 의 합
				              }
					              cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_"+rptTtlArr[i],  KeyField:0,   CalcLogic:calcLogic,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d7_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r9_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					              for(var i = 3; i < rptTtlArr.length; i++){   // 빨강색 Bold 표시 (현재,미래만)
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d4_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d5_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d7_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r5_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r9_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o4_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s4_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a2_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f4_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a4_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f5_b_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						         }
				         
			              
			              }
			          }
		              
		              InitColumns(cols);
		  			
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetCountPosition(0);
		              SetAutoRowHeight(0);// 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
		              //SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
		              //SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
		              //SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
		              
		              //SetExtendLastCol(0);
		              SetSheetHeight(585);// 585;
		              //SetSheetWidth(800)
              }


            break;
            case "sheet3":      // sheet3 MULTI 용 히든 시트
                with(sheetObj){
              var HeadTitle="ibflag|fcast_yrwk|port_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|cntr_qty|tmp_sav_flg";
              HeadTitleCnt=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fcast_yrwk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"invt_sim_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cfm_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"tmp_sav_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetVisible(0);
              SetEditable(1);
              SetCountPosition(0);
                    }


			break;
			case "sheet4":      // sheet4 , MT Out via VL 분배 계산용 임시 sheet (과거 3주의 합) 
			    with(sheetObj){
		        
		      var HeadTitle="lcc_cd|scc_cd|code|ttl_past|d2_past|d4_past|d5_past|d7_past|r2_past|r5_past|r9_past|o2_past|s2_past|o4_past|s4_past|f2_past|a2_past|f4_past|a4_past|f5_past";
		      var HeadTitle1="lcc_cd|scc_cd|code|ttl_past|past|past|past|past|past|past|past|past|past|past|past|past|past|past|past|past";
		      var HeadTitle2="lcc_cd|scc_cd|code|ttl|d2|d4|d5|d7|r2|r5|r9|o2|s2|o4|s4|f2|a2|f4|a4|f5";
		      for(var i=3; i < rptTtlArr.length; i++){
		      for(var j=0; j < 16; j++){
		      HeadTitle1 += "|" + rptTtlArr[i];
		      }
		      HeadTitle2 += "|d2|d4|d5|d7|r2|r5|r9|o2|s2|o4|s4|f2|a2|f4|a4|f5";
		      }
		      HeadTitleCnt=ComCountHeadTitle(HeadTitle1);
		      var allLogic="0*1";
		      for (var t=0; t < consTpszArr.length; t++) {
		      allLogic=allLogic + "+|" + consTpszArr[t].toLowerCase()+"_past"+ "|";    // 모든 tpsz 의 합
		      }

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"scc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"code",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"ttl_past",           KeyField:0,   CalcLogic:allLogic,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d4_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d5_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d7_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r5_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r9_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o4_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s4_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a2_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f4_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a4_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f5_past",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            for(var i = 3; i < rptTtlArr.length; i++){   // 비율별로 Spasce Available for MT 분배
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d4_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d5_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"d7_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r5_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"r9_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"o4_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"s4_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a2_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f4_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"a4_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      cols.push({Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"f5_s_"+rptTtlArr[i], KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      }
		 
		      InitColumns(cols);
		      SetVisible(0);
		      SetEditable(1);
		      SetCountPosition(0);
		            }


            break;
        }
    }
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // 조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(true);
					//sheetObjects[0].RenderSheet(0);
                   // sheetObjects[1].RenderSheet(0);
                    calcedTpsz=""; // 계산된 tpsz 내역 초기화
					sheetObjects[0].RemoveAll(); // VVD 시트 내용 삭제
					sheetObjects[1].RemoveAll(); // PORT 시트 내용 삭제
					sheetObjects[2].RemoveAll(); // 히든 시트 내용 삭제
					sheetObjects[3].RemoveAll(); // 히든 시트 내용 삭제
                    formObj.f_cmd.value=SEARCH;
                    var sXml=sheetObj.GetSearchData("EES_EQR_1012GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");   // 프레임웤에서 시트와 시트사이에 사용하는 문자
	                if (arrXml[0].length > 0) sXml1=arrXml[0];  
	                if (arrXml[1].length > 0) sXml2=arrXml[1];
					rptTtl=ComRtrim(ComGetEtcData(sXml1, "rpt_ttl"),",");
					rptTtlArr=rptTtl.split(",");
//					if(ComGetEtcData(sXml1, "auth_chk") == "Y"){ // 로그인한 user 의 편집 권한
//						editAuth = true;
//						ComBtnEnable("btn_Save");
//					}else{
//						editAuth = false;
//						ComBtnDisable("btn_Save");
//					}
					sheetObjects[0] = sheetObjects[0].Reset();
					sheetObjects[1] = sheetObjects[1].Reset();
					sheetObjects[3] = sheetObjects[3].Reset();
                    initSheet(sheetObjects[0], 1); // 상단 VVD 시트
					initSheet(sheetObjects[1], 2); // 하단 PORT 시트
					initSheet(sheetObjects[3], 4); // MT out via VL 분배 계산을 위한 히든 시트
                    sheetObjects[0].LoadSearchData(sXml1,{Sync:1} );
					sheetObjects[1].LoadSearchData(sXml2,{Sync:1} );
                    search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
                    calcAllFormula(sheetObj.HeaderRows(), sheetObj.HeaderRows()+ sheetObj.RowCount());
                    setGridHidden(tpsztype.GetSelectText()); // TPSZ hidden
                   // sheetObjects[0].RenderSheet(1);
                   // sheetObjects[1].RenderSheet(1);
                    ComOpenWait(false);
                }
                break;
			case IBSAVE: // sheetObj 는 히든 시트 임 (sheetObjects[2])
                if (validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(true);
                    // 히든 시트 sort ( BCImpl 에서 Sort 된 결과에 따라 처리 됨 )
                    sheetObj.ColumnSort("ibflag|fcast_yrwk|port_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|tmp_sav_flg|cntr_qty");
                    var sParam=sheetObj.GetSaveString();
                    var sXml=sheetObj.GetSaveData("EES_EQR_1012GS.do", sParam + "&f_cmd=" + MULTI);
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
				var sXml=sheetObj.GetSearchData("EES_EQR_1012GS.do", "f_cmd="+SEARCH04+"&trade="+trade.GetSelectCode());
                ComXml2ComboItem(sXml, subconti, "code", "code|name");
                break;    
        }
    }
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
       // with(formObj){
            switch(sAction) {
                case IBSEARCH:
					// Trade
					if(trade.GetSelectCode()==""){
						ComShowCodeMessage("EQR01102","Trade"); // 'Please select {?msg1}.'
						return false;
					}
					// S.Trade
					if(subtrade.GetSelectCode()==""){
						ComShowCodeMessage("EQR01102","Sub Trade"); // 'Please select {?msg1}.'
						return false;
					}
					// Sub-conti
					if(subconti.enable && subconti.GetSelectCode()==""){
						ComShowCodeMessage("EQR01102","Sub-Conti"); // 'Please select {?msg1}.'
						return false;
					}
                    break;
				case IBSAVE:
					if(sheetObj.RowCount()== 0){
						ComShowCodeMessage("EQR01107"); // 'There is no data to save.'
						return false;
					}
					break;	
            }
       // }
        return true;
    }
   function showDetail(){
       var sheetObj=sheetObjects[1];
       var formObj=document.form;
       if (rptTtl != "") {
           if(formObj.show_detail.checked == true){
               for (var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+sheetObj.RowCount(); i++) {
if(sheetObj.GetCellValue(i,"sort") > 0){
                        sheetObj.SetRowHidden(i,0);
//                        // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
//                        if(sheetObj.CellValue(i,"code") == "PL"){
//                            var tmpSum = 0;
//                            for(var k=0; k<rptTtlArr.length; k++){
//                                tmpSum = tmpSum + sheetObj.CellValue(i,"ttl_"+rptTtlArr[k])*1;
//                            }
//                            if(tmpSum == 0){
//                                sheetObj.RowHidden(i) = true;
//                            }
//                        }
                        // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (E)
}else if(sheetObj.GetCellValue(i,"sort") == "0"){
var tmpName=sheetObj.GetCellValue(i,"name");
                        sheetObj.SetCellValue(i,"name",tmpName.substr(0,tmpName.length-3)+"(-)",0);
                   }
               }
           }else{
               for (var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+sheetObj.RowCount(); i++) {
if(sheetObj.GetCellValue(i,"sort") > 0){
                        sheetObj.SetRowHidden(i,1);
}else if(sheetObj.GetCellValue(i,"sort") == "0"){
var tmpName=sheetObj.GetCellValue(i,"name");
                        sheetObj.SetCellValue(i,"name",tmpName.substr(0,tmpName.length-3)+"(+)",0);
                   }
               }
           }
       }
   }   
   var past3total=0; 
    /**
    * 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
        var formObj=document.form;
        if(formObj.show_detail.checked == false){ 
            showDetail(); 
        }
		if (rptTtl == "") {
		    return false;
		}
		calcInventoryPlusMinus(sheetObj); // sheet 전체의 Inventory Plus, Inventory Minus 계산
        with (sheetObj) {
			// Row 별 색상 표시, 편집 가부 설정
            for(var i=startRow; i < endRow; i++){
            	if (GetCellValue(i, "grp_cd") == "1") {
                    SetRowBackColor(i,"#FFFFFE");//흰색
                    SetRowEditable(i,0);
            	} else if (GetCellValue(i, "grp_cd") == "2") {
            		SetRowBackColor(i,sheetObj.WebColor2SysColor("#F6FAFB"));// 푸른색 // 246,250,251
            		if(GetCellValue(i,"sort") > "0" && editAuth){
					    SetRowEditable(i,1);
						//CellFontColor(i,"name") = "#0000FF";
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
                            for(var k=3; k<rptTtlArr.length; k++){
                                var str_col=SaveNameCol("d2_"+rptTtlArr[k]);
                                var end_col=SaveNameCol("f5_"+rptTtlArr[k]);
                                SetRangeBackColor(i, str_col, i, end_col,"#FFFFA2");
                            }
                        }
                    }else{
                        SetRowEditable(i,0);
                    }
				} else if (GetCellValue(i, "grp_cd") == "3") {
							SetRowBackColor(i,sheetObj.WebColor2SysColor("#FFEAEA"));// 분홍색 // 255,234,234
						if (GetCellValue(i, "code") == "RL") {// MT Out via VL 인 경우 히든 시트에 합계 입력
						    var newRow=sheetObjects[3].DataInsert(-1);
							sheetObjects[3].SetCellValue(newRow,"lcc_cd",GetCellValue(i,"lcc_cd"),0);
							sheetObjects[3].SetCellValue(newRow,"scc_cd",GetCellValue(i,"scc_cd"),0);
							sheetObjects[3].SetCellValue(newRow,"code",GetCellValue(i,"code"),0);
							for(var t=0; t < consTpszArr.length; t++){
								var tmpSum=0;
								for (var k=0; k < 3; k++) {
									tmpSum=tmpSum + GetCellValue(i,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k])*1;
								}
								if(consTpszArr[t].substr(1,1) != "2"){
									tmpSum=tmpSum * 2; // TEU 단위 임
								}
								sheetObjects[3].SetCellValue(newRow,consTpszArr[t].toLowerCase()+"_past",tmpSum,0);//tpsz 별 3주 합을 히든 시트에 입력
							}
						}
						if(GetCellValue(i,"sort") > "0" && editAuth && GetCellValue(i,"code") != "PL" ){ // MT Loading Plan 은 수정 X
	                        SetRowEditable(i,1);
							//CellFontColor(i,"name") = "#0000FF";
							if (rptTtl != "") { // 편집 가능 영역 노란색 표시
	                            for(var k=3; k<rptTtlArr.length; k++){
	                                var str_col=SaveNameCol("d2_"+rptTtlArr[k]);
	                                var end_col=SaveNameCol("f5_"+rptTtlArr[k]);
	                                SetRangeBackColor(i, str_col, i, end_col,"#FFFFA2");
	                            }
	                        }
	                    }else{
	                        SetRowEditable(i,0);
	                    }
				} else if (GetCellValue(i, "grp_cd") == "4") { // Balance
					SetRowBackColor(i,sheetObj.WebColor2SysColor("#D0EC7F"));// 연두색 // 208,236,127
                    SetRowEditable(i,0);
                } else {
                    SetRowEditable(i,0);
                }
            }
			// 과거 주차 회색 표시, 메뉴얼 입력값 빨간색 볼드체
            if (rptTtl != "") {
                for(var j=5; j<=LastCol(); j++){
                    if(   ColSaveName(j).split("_")[1] == rptTtlArr[0]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[1]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[2]){ // 과거 주차 회색 표시
                    	ColBackColor(j)=UnEditableColor; 
                    }else if( ColSaveName(j).split("_")[1] == "b"){ // 메뉴얼 입력값은 빨간색 Bold 표시
						var next_bold_row=FindText(j,"Y",HeaderRows()); // bold flag 가 Y 인 줄 찾기
                        while(next_bold_row != -1){
                        	SetCellFont("FontBold", next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2],1);// Bold
                        	SetCellFontColor(next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2],"#FF0000");// Red
                            next_bold_row=FindText(j,"Y",next_bold_row*1+1);     // 다음 줄 찾기
                        }
					}
                }
			}
       }
	   // VVD 시트 L/F 에 % 표시
	   var bkgRow=sheetObjects[0].FindText("code","BKG");
	   var avalRow=sheetObjects[0].FindText("code","AVAL");
	   for (var k=3; k < rptTtlArr.length; k++) {
		sheetObjects[0].SetCellValue(bkgRow, "lf_"+rptTtlArr[k],ComRtrim(sheetObjects[0].GetCellValue(bkgRow, "lf_"+rptTtlArr[k]),"%") + "%",0);
		sheetObjects[0].SetCellValue(bkgRow, "wgtlf_"+rptTtlArr[k],ComRtrim(sheetObjects[0].GetCellValue(bkgRow, "wgtlf_"+rptTtlArr[k]),"%") + "%",0);
		sheetObjects[0].SetCellValue(avalRow, "lf_"+rptTtlArr[k],ComRtrim(sheetObjects[0].GetCellValue(avalRow, "lf_"+rptTtlArr[k]),"%") + "%",0);
		sheetObjects[0].SetCellValue(avalRow, "wgtlf_"+rptTtlArr[k],ComRtrim(sheetObjects[0].GetCellValue(avalRow, "wgtlf_"+rptTtlArr[k]),"%") + "%",0);
	   }
       setTtlColumn();    // ttl column 합계 셋팅
	   calcDistribute();  // BSA 를 과거 실적 비율로 분배함 
	   calcTotalMtPlan(); // Port 시트의 MT Out via VL 총 합을 VVD 시트에 반영함
   }
   // Inventory Plus 와 Inventory Minus 를 계산한다
   // 조회후 한번만 호출 됨
   // 
   function calcInventoryPlusMinus(sheetObj){
   	if (rptTtl != "" && sheetObj.RowCount()> 0) { // 조회된 데이터 있을 경우
           rptTtlArr=rptTtl.split(",");
           // [ Inventory Plus ]
   		var next_inp_row=sheetObj.FindText("code","INP",sheetObj.HeaderRows()*1); // Inventory Plus 줄
           while(next_inp_row != -1){
               var inp_grp_str=next_inp_row + 1 ; // Inventory Plus 에 속한 첫줄 : MG
               var inp_grp_end=sheetObj.GetColSameDataRange(next_inp_row,"grp_cd").split("|")[1]*1 ; // Inventory Plus 에 속한 끝줄 : Sublease In
               for (var k=3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
               	for(var t=0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
               		// Inventory Plus 에 속한 값의 합을 넣음
               		sheetObj.SetCellValue(next_inp_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k],sheetObj.ComputeSum("|"+ consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k] +"|", inp_grp_str, inp_grp_end),0);
               	}
               }
               next_inp_row=sheetObj.FindText("code","INP",next_inp_row*1+1); // 다음 Inventory Plus 줄
           }
           // [ Inventory Minus ]
   		var next_inm_row=sheetObj.FindText("code","INM",sheetObj.HeaderRows()*1); // Inventory Minus 줄
           while(next_inm_row != -1){
               var inm_grp_str=next_inm_row + 1 ; // Inventory Minus 에 속한 첫줄 : OP
               var inm_grp_end=sheetObj.GetColSameDataRange(next_inm_row,"grp_cd").split("|")[1]*1 ; // Inventory Minus 에 속한 끝줄 : Sublease Out
               for (var k=3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
               	for(var t=0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
               		// Inventory Minus 에 속한 값의 합을 넣음
               		sheetObj.SetCellValue(next_inm_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k],sheetObj.ComputeSum("|"+ consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k] +"|", inm_grp_str, inm_grp_end),0);
               	}
               }
               next_inm_row=sheetObj.FindText("code","INM",next_inm_row*1+1); // 다음 Inventory Minus 줄
           }        
   	}
   }   
    // TTL column 의 calclogic 을 셋팅 함
    function setTtlColumn(){
        var sheetObj=sheetObjects[1];
        if (rptTtl != "") {
            var tpsz_cd=tpsztype.GetSelectText();
            var arr_tpsz=tpsz_cd.toLowerCase().split(",");
			for (var k=0; k < rptTtlArr.length; k++) {
				var calcLogic="0*1";
				if (tpsz_cd != "") {
					for (var t=0; t < arr_tpsz.length; t++) {
						calcLogic=calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[k] + "|";
					}
				}
			    for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
                    // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
			    	sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k],{ Type:"Data",Align:"Right",Format:"dfNumber",PointCount:0} );
				}
            }
        }
    }
	// 과거 3주의 실적 비율을 토대로  Space Available for MT 를 분배 한다
	function calcDistribute(){
		var avalRow=sheetObjects[0].FindText("code","AVAL");    // AVAL 의 row
		var bsaRow=sheetObjects[0].FindText("code","BSA");     // BSA 의 row
		var pastTotal=0;
		if(sheetObjects[3].RowCount()> 0){
			pastTotal=sheetObjects[3].ComputeSum("|ttl_past|")*1; // 과거 3주의 총합
		}
		if(pastTotal != 0 && avalRow != -1 && bsaRow != -1){
			for (var k=3; k < rptTtlArr.length; k++) {
var teuQty=sheetObjects[0].GetCellValue(avalRow,"qty_"+rptTtlArr[k])*1; // TEU
var wgtQty=Math.floor(sheetObjects[0].GetCellValue(avalRow,"wgt_"+rptTtlArr[k])*1 / 2.2); // (Mton/2.2), 내림
				 var vvdQty=0; // 분배할 TEU
if(sheetObjects[0].GetCellValue(bsaRow,"wgt_"+rptTtlArr[k])!="0" && teuQty > wgtQty ){
				 	vvdQty=wgtQty;
				 }else{
				 	vvdQty=teuQty;
				 }
				 var restDist=vvdQty;
				 for(var i=sheetObjects[3].HeaderRows(); i<sheetObjects[3].HeaderRows()+sheetObjects[3].RowCount(); i++){
					 // 해당 SCC 에서 분배될 양은
var sccDist=Math.floor((sheetObjects[3].GetCellValue(i, "ttl_past")*1 * vvdQty ) / pastTotal );
					 restDist=restDist - sccDist;
					 for(var t=0; t<consTpszArr.length; t++){
					     var tpszDist=0;
					     if (consTpszArr[t].substr(1,1)=="2") { // 20 피트
tpszDist=Math.floor((sheetObjects[3].GetCellValue(i, consTpszArr[t].toLowerCase() + "_past")*1 * vvdQty ) / pastTotal);
							 sccDist=sccDist - tpszDist;
						 }else{ // 40 피트
tpszDist=Math.floor(((sheetObjects[3].GetCellValue(i, consTpszArr[t].toLowerCase() + "_past")*1 * vvdQty ) / pastTotal)/2);
							 sccDist=sccDist - tpszDist*2;
						 }
						 sheetObjects[3].SetCellValue(i,consTpszArr[t].toLowerCase()+"_s_"+rptTtlArr[k],tpszDist,0);
					 }
					 // sccDsit 에 남은 양은 다 D2 에
sheetObjects[3].SetCellValue(i,"d2_s_"+rptTtlArr[k],sheetObjects[3].GetCellValue(i,"d2_s_"+rptTtlArr[k])*1 + sccDist,0);
				 }
				 // restDsit 에 남은 양은 roof 돌면서 값 있는 SCC 의 d2 에 1씩
				 while(restDist > 0){
					 for(var i=sheetObjects[3].HeaderRows(); i<sheetObjects[3].HeaderRows()+sheetObjects[3].RowCount(); i++){
if(sheetObjects[3].GetCellValue(i, "ttl_past") != "0" && restDist > 0){
sheetObjects[3].SetCellValue(i,"d2_s_"+rptTtlArr[k],sheetObjects[3].GetCellValue(i,"d2_s_"+rptTtlArr[k])*1 + 1,0);
							 restDist=restDist -1;
						 }
					 }
				 }
			}
		}else{ // 과거 실적 전혀 없으면 0
			for (var k=3; k < rptTtlArr.length; k++) {
			    for (var i=sheetObjects[3].HeaderRows(); i < sheetObjects[3].HeaderRows()+ sheetObjects[3].RowCount(); i++) {
				    for (var t=0; t < consTpszArr.length; t++) {
					    sheetObjects[3].SetCellValue(i,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k],0,0);
					}
				}
			}
		}
		// Port 시트에 값 넣기
		for (var k=3; k < rptTtlArr.length; k++) {
			for (var i=sheetObjects[3].HeaderRows(); i < sheetObjects[3].HeaderRows()+ sheetObjects[3].RowCount(); i++) {
var lccRow=sheetObjects[1].FindText("lcc_cd",sheetObjects[3].GetCellValue(i,"lcc_cd"),sheetObjects[1].HeaderRows());
var sccRow=sheetObjects[1].FindText("scc_cd",sheetObjects[3].GetCellValue(i,"scc_cd"),lccRow);
				var rlRow=sheetObjects[1].FindText("code","RL",sccRow);
				var inmRow=sheetObjects[1].FindText("code","INM",sccRow);
				for (var t=0; t < consTpszArr.length; t++) {
if( sheetObjects[1].GetCellValue(rlRow,consTpszArr[t].toLowerCase()+"_b_"+rptTtlArr[k]) != "Y"){
						// 분배 계산한 값으로 Port 시트에 반영
						sheetObjects[1].GetCellValue(rlRow,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k])
=sheetObjects[3].GetCellValue(i,consTpszArr[t].toLowerCase()+"_s_"+rptTtlArr[k]);
						// Inventory Minus 재 계산
						var sccEndRow=sheetObjects[1].GetColSameDataRange(sccRow,"scc_cd").split("|")[1]*1; // 해당 SCC 그룹의 마지막 줄
						var tmpSum=0;
	                    for(var j=sccRow; j<=sccEndRow; j++){
if(sheetObjects[1].GetCellValue(j,"grp_cd") == "3" && sheetObjects[1].GetCellValue(j,"sort") > "0"){
tmpSum=tmpSum + sheetObjects[1].GetCellValue(j,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k])*1;
	                        }
	                    }
	                    sheetObjects[1].SetCellValue(inmRow,consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k],tmpSum,0);
					}else{
						// 메뉴얼 값 유지
					}
				}
			}
		}
	}
	// Port 시트의 MtPlan 의 TEU 총 합을 구하여 VVD 시트에 반영함 
	function calcTotalMtPlan(){
		var bsaRow=sheetObjects[0].FindText("code","BSA");
		var bkgRow=sheetObjects[0].FindText("code","BKG");
		var plRow=sheetObjects[0].FindText("code","PL");
		var ttlRow=sheetObjects[0].FindText("code","TTL");
		for (var k=3; k < rptTtlArr.length; k++) {
			var tmpSum=0;
			var rlRow=sheetObjects[1].FindText("code","RL",sheetObjects[1].HeaderRows());
			while (rlRow != -1) {
				for (var t=0; t < consTpszArr.length; t++) {
					if (consTpszArr[t].substr(1, 1) == "2") { // 20피트
tmpSum=tmpSum + sheetObjects[1].GetCellValue(rlRow, consTpszArr[t].toLowerCase() + "_" + rptTtlArr[k]) * 1;
					}else {
tmpSum=tmpSum + sheetObjects[1].GetCellValue(rlRow, consTpszArr[t].toLowerCase() + "_" + rptTtlArr[k]) * 2;
					}
				}
				rlRow=sheetObjects[1].FindText("code","RL",rlRow+1);
			}
			// MT Plan 줄
			sheetObjects[0].SetCellValue(plRow, "qty_"+rptTtlArr[k],tmpSum,0);
sheetObjects[0].SetCellValue(plRow, "lf_"+rptTtlArr[k],Math.ceil((tmpSum / sheetObjects[0].GetCellValue(bsaRow, "qty_"+rptTtlArr[k])*1 ) * 100) + "%",0);
			sheetObjects[0].SetCellValue(plRow, "wgt_"+rptTtlArr[k],Math.round(tmpSum * 2.2),0);//Math.ceil((tmpSum * 2.2) * 100)/100;
sheetObjects[0].SetCellValue(plRow, "wgtlf_"+rptTtlArr[k],Math.ceil(((tmpSum * 2.2) / sheetObjects[0].GetCellValue(bsaRow, "wgt_"+rptTtlArr[k])*1) * 100) + "%",0);
			// TTL 줄
sheetObjects[0].SetCellValue(ttlRow, "qty_"+rptTtlArr[k],sheetObjects[0].GetCellValue(bkgRow, "qty_"+rptTtlArr[k])*1 + sheetObjects[0].GetCellValue(plRow, "qty_"+rptTtlArr[k])*1,0);
sheetObjects[0].SetCellValue(ttlRow, "lf_"+rptTtlArr[k],Math.ceil((sheetObjects[0].GetCellValue(ttlRow, "qty_"+rptTtlArr[k])*1 / sheetObjects[0].GetCellValue(bsaRow, "qty_"+rptTtlArr[k])*1) * 100 ) + "%",0);
sheetObjects[0].SetCellValue(ttlRow, "wgt_"+rptTtlArr[k],sheetObjects[0].GetCellValue(bkgRow, "wgt_"+rptTtlArr[k])*1 + sheetObjects[0].GetCellValue(plRow, "wgt_"+rptTtlArr[k])*1,0);
sheetObjects[0].SetCellValue(ttlRow, "wgtlf_"+rptTtlArr[k],Math.ceil((sheetObjects[0].GetCellValue(ttlRow, "wgt_"+rptTtlArr[k])*1 / sheetObjects[0].GetCellValue(bsaRow, "wgt_"+rptTtlArr[k])*1) * 100 ) + "%",0);
		}
	}
    // startRow 부터 endRow 까지, 전체 weeks 의 formula 를 계산함 (보이는 tpsz만)
    function calcAllFormula(startRow, endRow){
        var sheetObj=sheetObjects[1];
        var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.toLowerCase().split(","); // 보여지는 tpsz
        if (rptTtl != "") {
            var tpszs="";
            for(var t=0; t<arr_tpsz.length; t++){ // 보여지는 tpsz 가 계산 된적 있는지 확인
                if (calcedTpsz.indexOf(arr_tpsz[t]) == '-1') { // 계산 된적 없으면
                    tpszs=tpszs.concat(arr_tpsz[t] + ",");
                    calcedTpsz=calcedTpsz.concat(arr_tpsz[t]);
                }
            }
            tpszs=ComRtrim(tpszs, ",");
            for (var i=startRow; i < endRow; i++) {
            	if (sheetObj.GetCellValue(i, "code") == "FBB") {
                    calcBalance(i, rptTtl, tpszs); // row 의 Initial Inventory 와 Balance 계산
                }
            }
        }
    }
    function calcBalance(row, weeks, tpszs){
        var sheetObj=sheetObjects[1];
        with (sheetObj) {
var str_row=FindText("scc_cd",GetCellValue(row,"scc_cd")); // 해당 그룹의 첫 줄
            var inn_row=FindText("code","INN",str_row); // Initial Inventory
            var inp_row=FindText("code","INP",str_row); // Inventory Plus
            var inm_row=FindText("code","INM",str_row); // Inventory Minus
            var fbb_row=FindText("code","FBB",str_row); // Final Balance
            var weekArr="";
            if(weeks != ""){ // 계산 하고자 하는 주차
                weekArr=weeks.split(",");
            }else{
                return false;
            }
            var tpszArr="";
            if(tpszs != ""){ // 계산 하고자 하는 TPSZ
                tpszArr=tpszs.toLowerCase().split(",");
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
if(GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k-1]) > 0){
SetCellValue(inn_row,tpszArr[t]+"_"+weekArr[k],GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k-1]),0);
                        }else{ // 단, 마이너스 이면 0 으로 함
                            SetCellValue(inn_row,tpszArr[t]+"_"+weekArr[k],0,0);
                        }
                    }
                    // 현재, 미래 주차의 Final Balance 계산 
                    if(weekArr[k] > rptTtlArr[2]){ // 현재, 미래주차
                        // [FBB] Final Balance 계산 = Initial Inventory + Inventory Plus - Inventory Minus
SetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k],( GetCellValue(inn_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(inp_row,tpszArr[t]+"_"+weekArr[k])*1 - GetCellValue(inm_row,tpszArr[t]+"_"+weekArr[k])*1 ) ,0);
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
            var str_row=GetMergedStartCell(Row,"scc_cd").split(",")[0]*1; // 해당 그룹의 첫 줄
            var end_row=GetMergedEndCell(Row,"scc_cd").split(",")[0]*1;   // 해당 그룹의 마지막 줄
            var inn_row=FindText("code","INN",str_row);                 // Initial Inventory
            var inp_row=FindText("code","INP",str_row);                 // Inventory Plus
            var inm_row=FindText("code","INM",str_row);                 // Inventory Minus
            var fbb_row=FindText("code","FBB",str_row);                 // Final Balance
			var ttl_str_row=GetMergedStartCell(HeaderRows(),"scc_cd").split(",")[0]*1;   // TTL 그룹의 마지막 줄
            var ttl_end_row=GetMergedEndCell(HeaderRows(),"scc_cd").split(",")[0]*1;   // TTL 그룹의 마지막 줄
            // [Inventory Plus/Minus 하위 값 변경]
            if(GetCellValue(Row,"sort") > "0" && (GetCellValue(Row,"grp_cd") == "2" || GetCellValue(Row,"grp_cd") == "3")){
                // Inventory Plus 하위 값 변경 - 재 합산 and 히든 시트에 복사
            	if(GetCellValue(Row,"grp_cd") == "2"){
                    var tmpSum=0;
                    for(var i=str_row; i<=end_row; i++){
                    	if(GetCellValue(i,"grp_cd") == "2" && GetCellValue(i,"sort") > "0"){
                    		tmpSum=tmpSum + GetCellValue(i,Col)*1;
                        }
                    }
                    SetCellValue(inp_row,Col,tmpSum,0);
                    SetCellFont("FontBold", Row, Col,1);// Bold
                    SetCellFontColor(Row, Col,"#FF0000");// Red
					copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                }else             
                // Inventory Minus 하위 값 변경 - 재 합산 and 히든 시트에 복사
if(GetCellValue(Row,"grp_cd") == "3"){
                    var tmpSum=0;
                    for(var i=str_row; i<=end_row; i++){
if(GetCellValue(i,"grp_cd") == "3" && GetCellValue(i,"sort") > "0"){
tmpSum=tmpSum + GetCellValue(i,Col)*1;
                        }
                    }
                    SetCellValue(inm_row,Col,tmpSum,0);
                    SetCellFont("FontBold", Row, Col,1);// Bold
                    SetCellFontColor(Row, Col,"#FF0000");// Red
                    copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                }
var code=GetCellValue(Row,"code");
                var tpsz=ColSaveName(Col).split("_")[0];
                var week=ColSaveName(Col).split("_")[1];
                var weeks=""; // 영향을 받는 주차
				switch( week ){ // 수정된 주차
					case rptTtlArr[3]: // 현재 주차 ~
					   weeks=rptTtlArr[3]+","+rptTtlArr[4]+","+rptTtlArr[5]+","+rptTtlArr[6];
					   break;
                    case rptTtlArr[4]: // 미래 1주 ~
                       weeks=rptTtlArr[4]+","+rptTtlArr[5]+","+rptTtlArr[6];
                       break;
                    case rptTtlArr[5]: // 미래 2주 ~
                       weeks=rptTtlArr[5]+","+rptTtlArr[6];
                       break;
                    case rptTtlArr[6]: // 미래 3주 ~ 
                       weeks=rptTtlArr[6];
                       break;         
                }
				calcBalance(Row,weeks,tpsz); // Row 그룹의 Initial Inventory, Final Balance 구하기
if(GetCellValue(Row,"code")=="RL"){
					calcTotalMtPlan(); // VVD 시트의 MT Plan 값 재 계산				
				}
            }
        }
    }
    // 저장될 내용을 히든 시트에 복사
    function copy_save_data(sheetObj, Row, Col, Value){
        var fcast_yrwk=sheetObj.ColSaveName(Col).split("_")[1];
var port_cd=sheetObj.GetCellValue(Row,"scc_cd");
var invt_sim_tp_cd=sheetObj.GetCellValue(Row,"code");
        var cfm_flg="Y"; // 예비적으로 만들어 둔 컬럼 
        var cntr_tpsz_cd=sheetObj.ColSaveName(Col).split("_")[0].toUpperCase();
        var cntr_qty=Value;
        var tmp_sav_flg=""; // 예비적으로 만들어 둔 컬럼
        with (sheetObjects[2]) {
           var dup=0; 
           for(var i=0; i <= LastRow(); i++){
if(   GetCellValue(i, "fcast_yrwk")     == fcast_yrwk
&& GetCellValue(i, "port_cd")        == port_cd
&& GetCellValue(i, "invt_sim_tp_cd") == invt_sim_tp_cd
&& GetCellValue(i, "cfm_flg")        == cfm_flg
&& GetCellValue(i, "cntr_tpsz_cd")   == cntr_tpsz_cd) { // 히든 시트에 이미 복사된게 있으면 이를 수정
                  SetCellValue(i, "cntr_qty",cntr_qty);
                  dup++;
               }
           }
           if (dup == 0) {
                var new_row=sheetObjects[2].DataInsert(-1);
                sheetObjects[2].SetCellValue(new_row, "fcast_yrwk",fcast_yrwk,0);
                sheetObjects[2].SetCellValue(new_row, "port_cd",port_cd,0);
                sheetObjects[2].SetCellValue(new_row, "invt_sim_tp_cd",invt_sim_tp_cd,0);
                sheetObjects[2].SetCellValue(new_row, "cfm_flg",cfm_flg,0);
                sheetObjects[2].SetCellValue(new_row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
                sheetObjects[2].SetCellValue(new_row, "cntr_qty",cntr_qty,0);
                sheetObjects[2].SetCellValue(new_row, "tmp_sav_flg",tmp_sav_flg,0);
           }
        }
    }
   /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
      with (sheetObj) {
            if(ColSaveName(Col)=="name"){
if(GetCellValue(Row,"sort")=="0"){
var tmpName=GetCellValue(Row,"name");
                    var plus=tmpName.substr(tmpName.length-3,3);
                    if(plus == "(+)"){
                        for(var i=Row+1; i<=sheetObj.LastRow(); i++){
if(GetCellValue(Row,"grp_cd")==GetCellValue(i,"grp_cd")){
                                SetRowHidden(i,0);
//                                // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
//                                if(sheetObj.CellValue(i,"code") == "PL"){
//                                    var tmpSum = 0;
//                                    for(var k=0; k<rptTtlArr.length; k++){
//                                        tmpSum = tmpSum + sheetObj.CellValue(i,"ttl_"+rptTtlArr[k])*1;
//                                    }
//                                    if(tmpSum == 0){
//                                        sheetObj.RowHidden(i) = true;
//                                    }
//                                }
                                // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (E)
                            }else{
                                break;
                            }
                        }
                        SetCellValue(Row,"name",tmpName.substr(0,tmpName.length-3)+"(-)",0);
                    }else if(plus == "(-)"){
                        for(var i=Row+1; i<=sheetObj.LastRow(); i++){
if(GetCellValue(Row,"grp_cd")==GetCellValue(i,"grp_cd")){
                                SetRowHidden(i,1);
                            }else{
                                break;
                            }
                        }
                        SetCellValue(Row,"name",tmpName.substr(0,tmpName.length-3)+"(+)",0);
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
        var cnt=0 ;
        switch(comboObj.options.id) {       
            // Type Size
            case "tpsztype":
                with (comboObj) {               
                    SetDropHeight(12 * 20);
                    var menuname=tpszallText.split('|'); 
                    var menucode=tpszallCode.split('|'); 
                    SetMultiSelect(1);
                    SetMaxSelect(menuname.length);
                    SetMultiSeparator(",");
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
            tpsztype.SetSelectCode(consTpsz);
            break;
        case "D":
            tpsztype.SetSelectCode(consTpszDry);
            break;
        case "R":
            tpsztype.SetSelectCode(consTpszRfr);
            break;
        case "O":
            tpsztype.SetSelectCode(consTpszOt);
            break;
        case "F":
            tpsztype.SetSelectCode(consTpszFr);
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
        var srcName=ComGetEvent("name");
        if ( srcName == "cntrTpsz"){
			ComOpenWait(true);
            var index=document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
			ComOpenWait(false);
        }
    }
    function tpsztype_OnChange(){
        setGridHidden(tpsztype.GetSelectText());
        var sheetObj=sheetObjects[1]; 
        ComOpenWait(true);
        setTtlColumn(); // TTL column 의 calclogic 셋팅
        calcAllFormula(sheetObj.HeaderRows(), sheetObj.HeaderRows()+sheetObj.RowCount()); // 아직 계산되지 않은 TPSZ 의 Balance 계산
        ComOpenWait(false);
    }
    // 과거 3주, 2주, 1주 내용을 숨기거나 보임
    function showHistory(){
       setGridHidden(tpsztype.GetSelectText());
    }
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj=sheetObjects[1];
        var arr_tpsz=tpsz_cd.split(",");
        if(rptTtl != ""){
            rptTtlArr=rptTtl.split(",");
        }
        if(document.form.show_history.checked == true){ // Past 3 weeks history 체크박스
            for (var k=0; k < 3; k++) { // 과거 주차
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    sheetObj.SetColHidden("ttl_"+rptTtlArr[k],0);
                }  
            }
            for (var k=0; k < rptTtlArr.length; k++) { // 주차만큼반복
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k],0);
                            break;
                        }else if(j == arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k],1);
                        }
                    }       
                }  
            }
        }else{
            for (var k=0; k < 3; k++) { // 과거 주차
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k],1);
                    sheetObj.SetColHidden("ttl_"+rptTtlArr[k],1);
                }  
            }
            for (var k=3; k < rptTtlArr.length; k++) { // 현재, 미래 주차
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k],0);
                            break;
                        }else if(j == arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_"+rptTtlArr[k],1);
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
function trade_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, text , code) {
	if (code != "") {
		searchOptionSubTrade("subtrade", true, true, "", "", code, "", true);
	}else{
		subtrade.RemoveAll();
		lane.RemoveAll();
	}
	
	doActionIBSheet(sheetObjects[1],document.form,SEARCH04); // Sub-Conti 콤보 조회
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}



function subtrade_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, text , value ) {
	if (value != "") {
		searchOptionLane("lane", true, true, "", trade.GetSelectCode(), value, true, "", true);
	} else {
		document.form.lane.RemoveAll();
	}
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}


function lane_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, text , value) {
	setSubcontiEnable(); // Sub-Conti 콤보의 활성화를 세팅함
}


// Sub-Conti 콤보의 활성화를 세팅함
function setSubcontiEnable(){
	// Trade 가 I시작(IAS,IES,IMS) 이면 Sub-Conti 활성화
	var formObj=document.form;
	if(lane.GetSelectCode()!= ""){
	    if( lane.GetSelectCode().substr(0,1)=="I" || lane.GetSelectCode().search(",I")!=-1 ){
			subconti.enable=true;
		}else{
			subconti.enable=false;
			subconti.SetSelectCode("");
		}	
	}else if(subtrade.GetSelectCode()!= ""){
        if( subtrade.GetSelectCode().substr(0,1)=="I" || subtrade.GetSelectCode().search(",I")!=-1 ){
            subconti.enable=true;
        }else{
            subconti.enable=false;
            subconti.SetSelectCode("");
        }   
    }else if(trade.GetSelectCode()!= ""){
        if( trade.GetSelectCode().substr(0,1)=="I" || trade.GetSelectCode().search(",I")!=-1 ){
            subconti.enable=true;
        }else{
            subconti.enable=false;
            subconti.SetSelectCode("");
        }   
    }else{
		subconti.enable=false;
	}
}
    /* 개발자 작업  끝 */
