/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1073.js
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
     * @class EES_EQR_1073 : EES_EQR_1073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
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
        var sheet1=sheetObjects[shtCnt];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
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
                calcedTpsz=""; // 계산된 tpsz 내역 초기화       
                formObject.loc_cd.value="";
                formObject.loc_type_code.value="5";
                loc_type_code_onchange();
				formObject.show_history.checked=false;
                formObject.show_detail.checked=false;
                formObject.cntrTpsz.selectedIndex=1;   // Dry 선택
                tpszChange('D');                         // Dry 선택
                break;  
            case "btn_downExcel":
                ComOpenWait(true);
                 if(sheetObjects[0].RowCount() < 1){//no data	
                 	ComShowCodeMessage("COM132501");
                 }else{	
                	 sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                 }	
                ComOpenWait(false);
                break;
            case "btn_loc_cd":    //Location By 조회 팝업
                var code_type=formObject.loc_type_code.value;
                if (code_type == "2" || code_type == "3") { // RCC
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 407, "rcc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "4" || code_type == "5") { // LCC
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 407, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "6") { // ECC
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 407, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
                }else if (code_type == "7") { // SCC
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 407, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
                }   
                break;  
            case "btn_Bkg": // Booking by Yard 팝업
                if(sheetObjects[0].RowCount("R|I|U") > 0){
                    var param="loc_type_code=" + formObject.loc_type_code.value                               // 숫자
                              + "&loc_cd="       + formObject.loc_cd.value                                      // loc_cd
                              + "&cntrTpsz="     + formObject.cntrTpsz.value                                    // 코드 (D)
                              + "&tpsztype="     + formObject.tpsztype.GetSelectText();
                    if(formObject.show_history.checked){
                        param=param + "&show_history=checked" ;
                    } 
                    ComOpenPopup("/opuscntr/EES_EQR_1074.do?"+ param,1015, 645, "", "1,0,1,1,1,1,1,1", true);
                }else{
                    ComShowCodeMessage("EQR01029", "first"); // 'Please retrieve {?msg1}.'
                }
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
//         axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');                          //LOC_CD keyup 이벤트 처리
         axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate이벤트에 코드 처리
//         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
//         axon_event.addListener('blur', 'obj_blur', 'loc_cd');                                 //Location  blur 이벤트 처리
//         axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //알파벳 대문자,숫자만 입력허용
//         axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd');                        //RCC 변경시 이벤트 처리
         axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');          //Location by 변경시 이벤트 처리
//         axon_event.addListenerForm('change','form_change',form);
         loc_type_code_onchange();   
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
        	editAuth=false;
        	ComBtnDisable("btn_Bkg");
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        	ComBtnDisable("btn_Save");
        	ComBtnDisable("btn_downExcel");        	
        } else {
        	// 나머지는 level에 따라서 조회 자체에서 걸르게 된다는 전제로 일단 권한을 풀어준다.
        	editAuth=true;
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
        var cnt=0;
        var shtID=sheetObj.id;
        if(rptTtl != ""){
            rptTtlArr=rptTtl.split(",");
        }
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                
	              var HeadTitle1="LOC|Section/type|code|grp_cd|sort";
	              var HeadTitle2="LOC|Section/type|code|grp_cd|sort";
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
	              (HeadTitleCnt, 0, 0, true);
	              sheetObj.FrozenCols=5;
	
	              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"name",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"code",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sort",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                    for(i=0; i < rptTtlArr.length; i++){
	              var calcLogic="0*1";
	              if (form.tpsztype.GetSelectText()!= "") {
		              var arr_tpsz=form.tpsztype.GetSelectText().toLowerCase().split(",");
		              for (var t=0; t < arr_tpsz.length; t++) {
		            	  calcLogic=calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[i] + "|";
		              }
		              cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_"+rptTtlArr[i],  KeyField:0,   CalcLogic:calcLogic,Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d7_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r9_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a2_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a4_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f5_"+rptTtlArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		              for(i=3; i < rptTtlArr.length; i++){   // 빨강색 Bold 표시 (현재,미래만)
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
	              SetAutoRowHeight(0);// 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
	              //SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
	              SetExtendLastCol(1);
	              SetSheetHeight(585);// 585;
              }
            break;
            case "sheet2":      // sheet2 MULTI 용 히든 시트
                with(sheetObj){
		              var HeadTitle="ibflag|fcast_yrwk|yd_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|cntr_qty|tmp_sav_flg";
		              HeadTitleCnt=ComCountHeadTitle(HeadTitle);
		              (HeadTitleCnt, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fcast_yrwk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"invt_sim_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cfm_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"tmp_sav_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetVisible(false);
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
                    sheetObjects[0].RenderSheet(0);
                    calcedTpsz=""; // 계산된 tpsz 내역 초기화
                    sheetObj.RemoveAll();
					sheetObjects[1].RemoveAll(); // 히든 시트 내용 삭제
                    formObj.f_cmd.value=SEARCH;
                     var sXml=sheetObj.GetSearchData("EES_EQR_1073GS.do", FormQueryString(formObj));
                    rptTtl=ComRtrim(ComGetEtcData(sXml, "rpt_ttl"),",");
//					if(ComGetEtcData(sXml, "auth_chk") == "Y"){ // 로그인한 user 의 편집 권한
//						editAuth = true;
//						ComBtnEnable("btn_Save");
//					}else{
//						editAuth = false;
//						ComBtnDisable("btn_Save");
//					}
					initSheet(sheetObj, 1);
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    search_end(sheetObj, sheetObj.HeaderRows, sheetObj.HeaderRows + sheetObj.RowCount("R"));
                    calcAllFormula(sheetObj.HeaderRows(), sheetObj.HeaderRows()+ sheetObj.RowCount());
                    setGridHidden(formObj.tpsztype.GetSelectText()); // TPSZ hidden
                    sheetObjects[0].RenderSheet(1);
                    ComOpenWait(false);
                }
                break;
            case IBSAVE: // sheetObj 는 히든 시트 임 (sheetObjects[1])
                if (validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(true);
                    // 히든 시트 sort ( BCImpl 에서 Sort 된 결과에 따라 처리 됨 )
                    sheetObj.ColumnSort("ibflag|fcast_yrwk|yd_cd|invt_sim_tp_cd|cfm_flg|cntr_tpsz_cd|tmp_sav_flg|cntr_qty");
                    var sParam=sheetObj.GetSaveString();
                     var sXml=sheetObj.GetSaveData("EES_EQR_1073GS.do", sParam + "&f_cmd=" + MULTI);
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
                var code_type=formObj.loc_type_code.value;
                var sParam="f_cmd=" + SEARCH02 + "&loc_cd=" + formObj.loc_cd.value;
                var errMsgCd=""; // 에러시 보여줄 메시지 코드
                if(code_type == "1"){ // ALL
                    return true;
                }else if (code_type == "2" || code_type == "3") { // RCC
                    sParam += "&loc_grp_cd="+"R";
                    errMsgCd="EQR01004"; // 'RCC code is invalid.'
                }else if (code_type == "4" || code_type == "5") { // LCC
                    sParam += "&loc_grp_cd="+"L";
                    errMsgCd="EQR01005"; // 'LCC code is invalid.'
                }else if (code_type == "6") { // ECC
                    sParam += "&loc_grp_cd="+"E";
                    errMsgCd="EQR01006"; // 'ECC code is invalid.'
                }else if (code_type == "7") { // SCC
                    sParam += "&loc_grp_cd="+"S";
                    errMsgCd="EQR01007"; // 'SCC code is invalid.'
                }else{
                    return false;
                }   
                 var sXml=sheetObj.GetSearchData("EES_EQR_1073GS.do", sParam);
                var rccChk=ComGetEtcData(sXml, "rcc_chk");
                if(rccChk == "F"){
                   ComShowCodeMessage(errMsgCd);
                   formObj.loc_cd.value="";
                   formObj.loc_cd.focus();
				   formObj.rcc_cd.value=""; // RCC_CD 
                   return false;
                }else{
				   formObj.rcc_cd.value=rccChk; // RCC_CD 
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
					if(sheetObj.RowCount()== 0){
						ComShowCodeMessage("EQR01107"); // 'There is no data to save.'
						return false;
					}
					break;		
            }
        }
        return true;
    }
   function showDetail(){
       var sheetObj=sheetObjects[0];
       var formObj=document.form;
       if (rptTtl != "") {
           rptTtlArr=rptTtl.split(",");
           if(formObj.show_detail.checked == true){
               for (var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+sheetObj.RowCount(); i++) {
            	   if(sheetObj.GetCellValue(i,"sort") > 0){
                        sheetObj.SetRowHidden(i,0);
                        // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
                        if(sheetObj.GetCellValue(i,"code") == "PL"){
                            var tmpSum=0;
                            for(var k=0; k<rptTtlArr.length; k++){
                            	tmpSum=tmpSum + sheetObj.GetCellValue(i,"ttl_"+rptTtlArr[k])*1;
                            }
                            if(tmpSum == 0){
                                sheetObj.SetRowHidden(i,1);
                            }
                        }
                        // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (E)
						// RCC_CD 가 USNYC, SGSIN 인 경우 Domestic In 숨김
						// RCC_CD 가  DEHAM, USNYC 인 경우 Sublease In 숨김
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
    /**
    * 시트 조회 후
    */    
   function search_end(sheetObj, startRow, endRow) {
        var formObj=document.form;
        if(formObj.show_detail.checked == false){ 
            showDetail(); 
        }
        calcTtlInventoryChild(sheetObj);  // [Inventory Plus/Minus 하위 값] 의 합을 구하여 TTL 그룹 에 반영함
        calcInventoryPlusMinus(sheetObj); // sheet 전체의 Inventory Plus, Inventory Minus 계산
        with (sheetObj) {
			// Row 별 색상 표시, 편집 가부 설정
            for(var i=startRow; i < endRow; i++){
            	if (GetCellValue(i, "grp_cd") == "1") {
                    SetRowBackColor(i,"#FFFFFF");//흰색
                    SetRowEditable(i,0);
            	} else if (GetCellValue(i, "grp_cd") == "2") {
                    //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#F6FAFB"));// 푸른색 // 246,250,251
                    if(false){
                    }else if(GetCellValue(i,"sort") > "0" && GetCellValue(i,"loc_cd").length == 7 && editAuth){
                        SetRowEditable(i,1);
						//CellFontColor(i,"name") = "#0000FF";
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
							rptTtlArr=rptTtl.split(",");
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
                    //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#FFEAEA"));// 분홍색 // 255,234,234
            		if(GetCellValue(i,"sort") > "0" && GetCellValue(i,"loc_cd").length == 7 && editAuth
            				&& GetCellValue(i,"code") != "PL" ){ // MT Loading Plan 은 수정 X
                        SetRowEditable(i,1);
						//CellFontColor(i,"name") = "#0000FF";
						if (rptTtl != "") { // 편집 가능 영역 노란색 표시
                            rptTtlArr=rptTtl.split(",");
                            for(var k=3; k<rptTtlArr.length; k++){
                                var str_col=SaveNameCol("d2_"+rptTtlArr[k]);
                                var end_col=SaveNameCol("f5_"+rptTtlArr[k]);
                                SetRangeBackColor(i, str_col, i, end_col,"#FFFFA2");
                            }
                        }
                    }else{
                        SetRowEditable(i,0);
                    }
            	} else if (GetCellValue(i, "grp_cd") == "4") {
                    SetRowBackColor(i,"#FFFFFF");//흰색
                    SetRowEditable(i,0);
            	} else if (GetCellValue(i, "grp_cd") == "5") {
                    //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#D0EC7F"));// 연두색 // 208,236,127
                    SetRowEditable(i,0);
                } else {
                    SetRowEditable(i,0);
                }
            }
			// 과거 주차 회색 표시, 메뉴얼 입력값 빨간색 볼드체
            if (rptTtl != "") {
                rptTtlArr=rptTtl.split(",");
                for(var j=5; j<=LastCol(); j++){
                    if(   ColSaveName(j).split("_")[1] == rptTtlArr[0]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[1]
                       || ColSaveName(j).split("_")[1] == rptTtlArr[2]){ // 과거 주차 회색 표시
                        //no support[check again]CLT ColBackColor(j)=UnEditableColor; 
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
       setTtlColumn();
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
    // 현재, 미래 주차에서, [Inventory Plus/Minus 하위 값] 의 합을 구하여 TTL 그룹 에 반영함
    // MG, MT In via VD, MT In via EN/TN, On-hire, Domestic In, Sublease In
    // OP, MT Out via VL, MT Out via EN/TN, Off-hire/Disposal, Domestic Out, Sublease Out
    // 조회후 한번만 호출 됨
    // 메뉴얼 수정 값이 있는 경우, 쿼리에서 TTL 값을 구하기 곤란한 것에 대한 보완
    function calcTtlInventoryChild(sheetObj){
    	if (rptTtl != "" && sheetObj.RowCount()> 0) { // 조회된 데이터 있을 경우
            rptTtlArr=rptTtl.split(",");
            var ttl_str_row=sheetObj.GetColSameDataRange(sheetObj.HeaderRows(),"loc_cd").split("|")[0]*1 // TTL 그룹의 첫 줄
            var ttl_end_row=sheetObj.GetColSameDataRange(sheetObj.HeaderRows(),"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄
            for(var i=ttl_str_row; i<=ttl_end_row; i++){
            	// [Inventory Plus/Minus 하위 값]
            	if(sheetObj.GetCellValue(i,"sort") != null && sheetObj.GetCellValue(i,"sort") > "0" && (sheetObj.GetCellValue(i,"grp_cd") == "2" || sheetObj.GetCellValue(i,"grp_cd") == "3")){
            		var tmpCode=sheetObj.GetCellValue(i,"code");
                	for (var k=3; k < rptTtlArr.length; k++) { // 현재, 미래 주차만
    	            	for(var t=0; t < consTpszArr.length; t++){ // 모든 TPSZ 에 대해서
                			var tmpSum=0; 
    	                    var next_row=sheetObj.FindText("code",tmpCode,ttl_end_row*1+1);
    	                    while(next_row != -1){
    	                    	// 같은 code 를 가진 row 의 값을 합친다
    	                    	tmpSum=tmpSum + sheetObj.GetCellValue(next_row, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k]) * 1;
    	                        next_row=sheetObj.FindText("code",tmpCode,next_row*1+1);
    	                    }
    	                    sheetObj.SetCellValue(i, consTpszArr[t].toLowerCase()+"_"+rptTtlArr[k],tmpSum,0);
    	            	}	
                	}
				}
			}
		}
	}    	
    // TTL column 의 calclogic 을 셋팅 함
    function setTtlColumn(){
        var sheetObj=sheetObjects[0];
        if (rptTtl != "") {
            rptTtlArr=rptTtl.split(",");
            var tpsz_cd=form.tpsztype.GetSelectText();
            var arr_tpsz=tpsz_cd.toLowerCase().split(",");
			for (var k=0; k < rptTtlArr.length; k++) {
				var calcLogic="0*1";
				if (tpsz_cd != "") {
					for (var t=0; t < arr_tpsz.length; t++) {
						calcLogic=calcLogic + "+|" + arr_tpsz[t] + "_" + rptTtlArr[k] + "|";
					}
				}
			    for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
					// F3, F4 는 calclogic 합계 제외
			    	if (sheetObj.GetCellValue(i, "code")=="F3" || sheetObj.GetCellValue(i, "code")=="F4"){
                        // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
                         sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k],{ Type:"Data",Align:"Right",Format:"dfNumber",PointCount:0} );
                        sheetObj.SetCellValue(i,"ttl_"+rptTtlArr[k],"",0);
	                }else{
                        // InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
                         sheetObj.InitCellProperty(i, "ttl_"+rptTtlArr[k],{ Type:"Data",Align:"Right",Format:"dfNumber",PointCount:0} );
                    }
				}
            }
        }
    }
    // startRow 부터 endRow 까지, 전체 weeks 의 formula 를 계산함 (보이는 tpsz만)
    function calcAllFormula(startRow, endRow){
        var sheetObj=sheetObjects[0];
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
            var fomula_flag=false;
            for (var i=startRow; i < endRow; i++) {
            	if (sheetObj.GetCellValue(i, "code") == "FBB" && sheetObj.GetCellValue(i, "loc_cd") != "TTL") {
                    calcBalance(i, rptTtl, tpszs); // row 의 Initial Inventory 와 Balance 계산
            	}else if (sheetObj.GetCellValue(i, "code") == "F1" && sheetObj.GetCellValue(i, "loc_cd") != "TTL") {
                    calcFormula(i, rptTtl, tpszs); // row 의 tpsz 의 formula 계산
                    calcTtlFormula(i, rptTtl, "ttl"); // row 의 ttl column 의 formula 계산
                    fomula_flag=true;
                }
            }
            calcTtlBalance(sheetObj.HeaderRows(), rptTtl, tpszs); // TTL LOC의 미래 주차 Inventory , Final Balance 계산
            if (fomula_flag) { // formula 계산 대상이 있으면 
                calcTtlFormula(sheetObj.HeaderRows(), rptTtl, tpszs+",ttl"); // TTL LOC의 tpsz 의 formula 계산
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
        var sheetObj=sheetObjects[0];
        with(sheetObj){
        	var str_row=FindText("loc_cd",GetCellValue(row,"loc_cd")); // 해당 그룹의 첫 줄
            var op_row=FindText("code","OP",str_row);  // OP
            var do_row=FindText("code","DO",str_row);  // Domestic Out
            var so_row=FindText("code","SO",str_row);  // Sublease Out
            var fbb_row=FindText("code","FBB",str_row); // Final Balance
            var f1_row=FindText("code","F1",str_row);  // Surplus MT
            var f2_row=FindText("code","F2",str_row);  // Target Volume
            var f3_row=FindText("code","F3",str_row);  // Target Ratio Index
            var f4_row=FindText("code","F4",str_row);  // MT Performance
            if(f1_row == "-1" || f2_row == "-1" || f3_row == "-1" || f4_row == "-1"){ // formula 계산 대당이 없으면
                return false;
            }
            var weekArr="";
            if(weeks != ""){
                weekArr=weeks.split(",");
            }else{
                return false;
            }
            var tpszArr="";
            if(tpszs != ""){
                tpszArr=tpszs.toLowerCase().split(",");
            }else{
                return false;
            }
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    // [F2] Target Ratio Index 계산  = ( OP + DO + SO ) * F3
                	SetCellValue(f2_row,tpszArr[t]+"_"+weekArr[k],Math.ceil( ( GetCellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + GetCellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) * GetCellValue(f3_row,tpszArr[t]+"_"+weekArr[k])*1),0);// 올림
                    // [F1] Surplus MT 계산 = FB - F2
                	SetCellValue(f1_row,tpszArr[t]+"_"+weekArr[k],( GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - GetCellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ).toFixed(0),0);
                    // [F4] MT Performance 계산 = FB / ( OP + DO + SO )
                	SetCellValue(f4_row,tpszArr[t]+"_"+weekArr[k],( GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 / ( GetCellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + GetCellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1),0);
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
        var sheetObj=sheetObjects[0];
        with (sheetObj) {
//            var str_row = GetMergedStartCell(row,"loc_cd").split(",")[0]*1; // 해당 그룹의 첫 줄
//            var end_row = GetMergedEndCell(row,"loc_cd").split(",")[0]*1;   // 해당 그룹의 마지막 줄 
//            var ttl_end_row = GetMergedEndCell(HeaderRows,"loc_cd").split(",")[0]*1; // TTL 그룹의 마지막 줄 
            var str_row=GetColSameDataRange(row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row=GetColSameDataRange(row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_end_row=GetColSameDataRange(HeaderRows(),"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄
            var op_row=FindText("code","OP",str_row);  // OP
            var do_row=FindText("code","DO",str_row);  // Domestic Out
            var so_row=FindText("code","SO",str_row);  // Sublease Out
            var fbb_row=FindText("code","FBB",str_row); // Final Balance
            var f1_row=FindText("code","F1",str_row);  // Surplus MT
            var f2_row=FindText("code","F2",str_row);  // Target Volume
            var f3_row=FindText("code","F3",str_row);  // Target Ratio Index
            var f4_row=FindText("code","F4",str_row);  // MT Performance
            if(f1_row == "-1" || f2_row == "-1" || f3_row == "-1" || f4_row == "-1"){ // formula 계산 대당이 없으면
                return false;
            }
            var weekArr="";
            if(weeks != ""){
                weekArr=weeks.split(",");
            }else{
                return false;
            }
            var tpszArr="";
            if(tpszs != ""){
                tpszArr=tpszs.toLowerCase().split(",");
            }else{
                return false;
            }
            var f2Sum=0;
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
					if (tpszArr[t] != "ttl") {
                        f2Sum=0;
                        var next_f2_row=FindText("code","F2",ttl_end_row*1+1);
                        while(next_f2_row != -1){
                        	f2Sum=f2Sum + GetCellValue(next_f2_row, tpszArr[t] + "_" + weekArr[k]) * 1;
                            next_f2_row=FindText("code","F2",next_f2_row*1+1);
                        }
                        // [F2] TTL 의 Target Ratio Index 계산  = F2들의 합
                        SetCellValue(f2_row,tpszArr[t]+"_"+weekArr[k],f2Sum ,0);
                    }else{
                        // [F2] TTL column 의 Target Ratio Index 계산  = 보이는 tpsz들의 F2 들의 합 ( calcTotal에서 계산 됨 )
                    }
                    // [F3] TTL 의 Target Ratio vs OP 계산 = F2 / ( OP + DO + SO ) 올림
					SetCellValue(f3_row,tpszArr[t]+"_"+weekArr[k],( GetCellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 / ( GetCellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1),0);
                    // [F1] Surplus MT 계산 = FBB - F2
					SetCellValue(f1_row,tpszArr[t]+"_"+weekArr[k],GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 - GetCellValue(f2_row,tpszArr[t]+"_"+weekArr[k])*1 ,0);
                    // [F4] MT Performance 계산 = FBB / ( OP + DO + SO )
					SetCellValue(f4_row,tpszArr[t]+"_"+weekArr[k],( GetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k])*1 / ( GetCellValue(op_row,tpszArr[t]+"_"+weekArr[k])*1  + GetCellValue(do_row,tpszArr[t]+"_"+weekArr[k])*1 + GetCellValue(so_row,tpszArr[t]+"_"+weekArr[k])*1 ) ).toFixed(1),0);
                }
            }
        }
    }
    function calcBalance(row, weeks, tpszs){
        var sheetObj=sheetObjects[0];
        with (sheetObj) {
        	var str_row=FindText("loc_cd",GetCellValue(row,"loc_cd")); // 해당 그룹의 첫 줄
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
                rptTtlArr=rptTtl.split(",");
            }else{
                return false;
            }
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    // 미래 주차 부터는 앞 주의 Final Balance 를 Initial Inventory 로 함
                    if(weekArr[k] > rptTtlArr[3]){ // 미래주차
						var pre_yrwk=""; // 직전 주차
						if(k > 0){
                            pre_yrwk=weekArr[k-1];
                        }else{ // 직전 주차 별도로 구함
							if(weekArr[k] == rptTtlArr[4]){
								pre_yrwk=rptTtlArr[3];
							}else if(weekArr[k] == rptTtlArr[5]){
                                pre_yrwk=rptTtlArr[4];
                            }else if(weekArr[k] == rptTtlArr[6]){
                                pre_yrwk=rptTtlArr[5];
                            }else{
								return false; //직전 주차를 못구하면
							}
						}
						if(GetCellValue(fbb_row,tpszArr[t]+"_"+pre_yrwk) > 0){
							SetCellValue(inn_row,tpszArr[t]+"_"+weekArr[k],GetCellValue(fbb_row,tpszArr[t]+"_"+pre_yrwk),0);
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
    function calcTtlBalance(row, weeks, tpszs){
        var sheetObj=sheetObjects[0];
        with (sheetObj) {
//            var str_row = GetMergedStartCell(row,"loc_cd").split(",")[0]*1; // 해당 그룹의 첫 줄
//            var end_row = GetMergedEndCell(row,"loc_cd").split(",")[0]*1;   // 해당 그룹의 마지막 줄
//            var ttl_end_row = GetMergedEndCell(HeaderRows,"loc_cd").split(",")[0]*1; // TTL 그룹의 마지막 줄  
            var str_row=GetColSameDataRange(row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row=GetColSameDataRange(row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_end_row=GetColSameDataRange(HeaderRows(),"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var inn_row=FindText("code","INN",str_row); // Initial Inventory
            var fbb_row=FindText("code","FBB",str_row); // Final Balance
            var weekArr="";
            if(weeks != ""){
                weekArr=weeks.split(",");
            }else{
                return false;
            }
            var tpszArr="";
            if(tpszs != ""){
                tpszArr=tpszs.toLowerCase().split(",");
            }else{
                return false;
            }
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                rptTtlArr=rptTtl.split(",");
            }else{
                return false;
            }
            for(var k=0; k<weekArr.length; k++){
                for(var t=0; t<tpszArr.length; t++){
                    if(weekArr[k] > rptTtlArr[2]){ // 현재, 미래주차 
                        if (tpszArr[t] != "ttl") {
                            var innSum=0;
                            var fbbSum=0;
                            var next_inn_row=FindText("code","INN",ttl_end_row*1+1);
                            while(next_inn_row != -1){
                            	innSum=innSum + GetCellValue(next_inn_row, tpszArr[t] + "_" + weekArr[k]) * 1;
								next_inn_row=FindText("code","INN",next_inn_row*1+1);
							}
							var next_fbb_row=FindText("code","FBB",ttl_end_row*1+1);
                            while(next_fbb_row != -1){
                            	fbbSum=fbbSum + GetCellValue(next_fbb_row, tpszArr[t] + "_" + weekArr[k]) * 1;
                                next_fbb_row=FindText("code","FBB",next_fbb_row*1+1);
                            }
                            // [INN] 
                            SetCellValue(inn_row,tpszArr[t]+"_"+weekArr[k],innSum,0);
                            // [FBB] 
                            SetCellValue(fbb_row,tpszArr[t]+"_"+weekArr[k],fbbSum,0);
                        }
                    }
                }
            }
        }
    }   
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        with(sheetObj){
            if(rptTtl != ""){ // sheet 에 조회된 주차 전체 
                rptTtlArr=rptTtl.split(",");
            }else{
                return false;
			}
//            var str_row = GetMergedStartCell(Row,"loc_cd").split(",")[0]*1; // 해당 그룹의 첫 줄
//            var end_row = GetMergedEndCell(Row,"loc_cd").split(",")[0]*1;   // 해당 그룹의 마지막 줄    
//            var ttl_str_row = GetMergedStartCell(HeaderRows,"loc_cd").split(",")[0]*1; // TTL 그룹의 첫 줄   
//            var ttl_end_row = GetMergedEndCell(HeaderRows,"loc_cd").split(",")[0]*1;   // TTL 그룹의 마지막 줄      
            var str_row=GetColSameDataRange(Row,"loc_cd").split("|")[0]*1 // 해당 그룹의 첫 줄
            var end_row=GetColSameDataRange(Row,"loc_cd").split("|")[1]*1 // 해당 그룹의 마지막 줄
            var ttl_str_row=GetColSameDataRange(HeaderRows(),"loc_cd").split("|")[0]*1 // TTL 그룹의 첫 줄
            var ttl_end_row=GetColSameDataRange(HeaderRows(),"loc_cd").split("|")[1]*1 // TTL 그룹의 마지막 줄
            var inn_row=FindText("code","INN",str_row);                 // Initial Inventory
            var inp_row=FindText("code","INP",str_row);                 // Inventory Plus
            var inm_row=FindText("code","INM",str_row);                 // Inventory Minus
            var fbb_row=FindText("code","FBB",str_row);                 // Final Balance
            // [Inventory Plus/Minus 하위 값 변경]
            if(GetCellValue(Row,"sort") > "0" && (GetCellValue(Row,"grp_cd") == "2" || GetCellValue(Row,"grp_cd") == "3")){
                if ( Value == '' ) {  //data format int형 널 방지
                    SetCellValue(Row,Col,0,0);
                    Value=0;
                }
                // Inventory Plus 하위 값 변경 - 재 합산 and 히든 시트에 복사
                if(GetCellValue(Row,"grp_cd") == "2"){
                    var tmpSum=0;
                    for(var i=str_row; i<=end_row; i++){
                    	if(GetCellValue(i,"grp_cd") == "2" && GetCellValue(i,"sort") > "0"){
                    		tmpSum=tmpSum + GetCellValue(i,Col)*1;
                        }
                    }
                    SetCellValue(inp_row,Col,tmpSum,0);
                    if(GetCellValue(Row,"loc_cd").length == 7){ // Yard 이면
					    //CellFont("FontBold", Row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = true;       // Bold
                        //CellFontColor(next_bold_row, ColSaveName(j).split("_")[0]+"_"+ColSaveName(j).split("_")[2]) = "#FF0000"; // Red
                         SetCellFont("FontBold", Row, Col,1);// Bold
                         SetCellFontColor(Row, Col,"#FF0000");// Red
						copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                    }
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
                    if(GetCellValue(Row,"loc_cd").length == 7){ // Yard 이면
                         SetCellFont("FontBold", Row, Col,1);// Bold
                         SetCellFontColor(Row, Col,"#FF0000");// Red
                        copy_save_data(sheetObj, Row, Col, Value); // 히든 시트에 복사
                    }
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
                var tmpSum=0; 
                var next_row=FindText("code",code,ttl_end_row*1+1);
                while(next_row != -1){
                	tmpSum=tmpSum + GetCellValue(next_row, Col) * 1;
                    next_row=FindText("code",code,next_row*1+1);
                }
				SetCellValue(FindText("code",code,HeaderRows()),Col,tmpSum,0);
				if(GetCellValue(Row,"grp_cd") == "2"){ // Inventory Plus
                    var tmpSumSum=0;
					for(var i=ttl_str_row; i<=ttl_end_row; i++){
						if(GetCellValue(i,"grp_cd") == "2" && GetCellValue(i,"sort") > "0"){
							tmpSumSum=tmpSumSum + GetCellValue(i,Col)*1;
						}
					}
					var tmpSumRow=FindText("code","INP",HeaderRows()); // TTL 그룹의 Inventory Plus
					SetCellValue(tmpSumRow,Col,tmpSumSum,0);
				}else if(GetCellValue(Row,"grp_cd") == "3"){ // Inventory Minus
                    var tmpSumSum=0;
                    for(var i=ttl_str_row; i<=ttl_end_row; i++){
                    	if(GetCellValue(i,"grp_cd") == "3" && GetCellValue(i,"sort") > "0"){
                    		tmpSumSum=tmpSumSum + GetCellValue(i,Col)*1;
                        }
                    }
                    var tmpSumRow=FindText("code","INM",HeaderRows()); // TTL 그룹의 Inventory Minus
                    SetCellValue(tmpSumRow,Col,tmpSumSum,0);
                }
                calcFormula(Row, weeks, tpsz);                           // Row 가 속한 그룹의 weeks 주차들의 tpsz 의 formula 재 계산
				calcTtlFormula(Row, weeks, "ttl");                       // Row 가 속한 그룹의 ttl colunm 의 formula 새로 계산
				calcTtlBalance(sheetObj.HeaderRows(), weeks, tpsz);        // TTL LOC의 미래 주차 Inventory , Final Balance 계산
                calcTtlFormula(sheetObj.HeaderRows(), weeks, tpsz+",ttl"); // TTL 그룹 formula 새로 계산
            }
        }
    }
    // 저장될 내용을 히든 시트에 복사
    function copy_save_data(sheetObj, Row, Col, Value){
        var fcast_yrwk=sheetObj.ColSaveName(Col).split("_")[1];
        var yd_cd=sheetObj.GetCellValue(Row,"loc_cd");
        var invt_sim_tp_cd=sheetObj.GetCellValue(Row,"code");
        var cfm_flg="Y"; // 예비적으로 만들어 둔 컬럼 
        var cntr_tpsz_cd=sheetObj.ColSaveName(Col).split("_")[0].toUpperCase();
        var cntr_qty=Value;
        var tmp_sav_flg=""; // 예비적으로 만들어 둔 컬럼
        with (sheetObjects[1]) {
           var dup=0; 
           for(var i=0; i <= LastRow(); i++){
        	   if(   GetCellValue(i, "fcast_yrwk")     == fcast_yrwk
        			   && GetCellValue(i, "yd_cd")          == yd_cd
        			   && GetCellValue(i, "invt_sim_tp_cd") == invt_sim_tp_cd
        			   && GetCellValue(i, "cfm_flg")        == cfm_flg
        			   && GetCellValue(i, "cntr_tpsz_cd")   == cntr_tpsz_cd) { // 히든 시트에 이미 복사된게 있으면 이를 수정
                  SetCellValue(i, "cntr_qty",cntr_qty);
                  dup++;
               }
           }
           if (dup == 0) {
                var new_row=sheetObjects[1].DataInsert(-1);
                sheetObjects[1].SetCellValue(new_row, "fcast_yrwk",fcast_yrwk,0);
                sheetObjects[1].SetCellValue(new_row, "yd_cd",yd_cd,0);
                sheetObjects[1].SetCellValue(new_row, "invt_sim_tp_cd",invt_sim_tp_cd,0);
                sheetObjects[1].SetCellValue(new_row, "cfm_flg",cfm_flg,0);
                sheetObjects[1].SetCellValue(new_row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
                sheetObjects[1].SetCellValue(new_row, "cntr_qty",cntr_qty,0);
                sheetObjects[1].SetCellValue(new_row, "tmp_sav_flg",tmp_sav_flg,0);
           }
        }
    }
   /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
      with (sheetObj) {
            if(ColSaveName(Col)=="name"){
            	if(GetCellValue(Row,"sort")=="0"){
            		var tmpName=GetCellValue(Row,"name");
                    var plus=tmpName.substr(tmpName.length-3,3);
                    if(plus == "(+)"){
                        for(var i=Row+1; i<=sheetObj.LastRow(); i++){
                        	if(GetCellValue(Row,"grp_cd")==GetCellValue(i,"grp_cd")){
                                SetRowHidden(i,0);
                                // MT Loading Plan 의 Row 전체 합이 0 이면 row 숨김 (S)
                                if(sheetObj.GetCellValue(i,"code") == "PL"){
                                    var tmpSum=0;
                                    for(var k=0; k<rptTtlArr.length; k++){
                                    	tmpSum=tmpSum + sheetObj.GetCellValue(i,"ttl_"+rptTtlArr[k])*1;
                                    }
                                    if(tmpSum == 0){
                                        sheetObj.SetRowHidden(i,1);
                                    }
                                }
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
    * Location Type Code  변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
   function loc_type_code_onchange() {
        if(document.form.loc_type_code.value == "1"){ // ALL 선택            
            ComEnableObject(document.form.btn_loc_cd,  false);  // Location by 돋보기창 비활성화
            document.form.loc_cd.className="input2";
            document.form.loc_cd.readOnly=true;
            document.form.loc_cd.value="";
        }else{ // ALL 이 아닌 경우
            ComEnableObject(document.form.btn_loc_cd,  true);
            document.form.loc_cd.className="input1";
            document.form.loc_cd.readOnly=false;
            document.getElementById("loc_cd").focus();
        }
   }
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function obj_keypress() {
        var formObject=document.form;
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
         var formObject=document.form;
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
        var cnt=0 ;
        switch(comboNo) {       
            // Type Size
            case 1:
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
    	comboObjects[0].SetSelectCode(-1);
        switch (key) {
        case "":
            comboObjects[0].SetSelectCode(consTpsz);
            break;
        case "D":
            comboObjects[0].SetSelectCode(consTpszDry);
            break;
        case "R":
            comboObjects[0].SetSelectCode(consTpszRfr);
            break;
        case "O":
            comboObjects[0].SetSelectCode(consTpszOt);
            break;
        case "F":
            comboObjects[0].SetSelectCode(consTpszFr);
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
        var sheetObj=sheetObjects[0]; 
        //ComOpenWait(true);
        setTtlColumn(); // TTL column 의 calclogic 셋팅
        calcAllFormula(sheetObj.HeaderRows(), sheetObj.HeaderRows()+sheetObj.RowCount());
		for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i,"code")=="F1"){
                calcTtlFormula(i, rptTtl, "ttl"); // TTL LOC의 tpsz 의 formula 계산
            }
		}
        //ComOpenWait(false);
    }
    // 과거 3주, 2주, 1주 내용을 숨기거나 보임
    function showHistory(){
       setGridHidden(form.tpsztype.GetSelectText());
    }
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj=sheetObjects[0];
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
    /* 개발자 작업  끝 */
