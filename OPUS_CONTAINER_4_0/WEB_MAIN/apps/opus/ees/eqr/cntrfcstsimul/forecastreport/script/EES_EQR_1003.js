/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1003.js
*@FileTitle : Forecast Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
    var comboObjects=new Array();
    var comboCnt=0 ;
    var mouseFlag=true;
    var weekTpArr=new Array("p2","p1","c0","f1","f2","f3","f4","f5","f6","f7");
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
    var tpszallText="D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode="D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText="D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode="D2|D4|D5|D7";
    var tpszrfrText="R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode="R2|R5|R9";
    var tpszotText="O2|O4|S2|S4"; // OT  TYPE SIZE 
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
                sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(                sheetObjects[0]), SheetDesign:1,Merge:1 });
                ComOpenWait(false);
                break;
            case "btn_loc_cd":    //Location By 조회 팝업
                if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
                    var code_type=formObject.loc_type_code.value;
                    if(code_type.substr(0,1) == "E") {
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "R") {    
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "rcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "L"){
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "lcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
                    }
                    //obj_blur();
                }
                break;  
            case "btn_loc_cd_second":    //Location 조회 팝업
                if(document.form.loc_cd.value != "" && document.form.div_flag[1].checked == true) {    
                    var code_type=formObject.loc_tp_cd_second.value;
                    if(code_type.substr(0,1) == "E") {
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "L") {    
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }else if(code_type.substr(0,1) == "S"){
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd_second", "0,1,1,1,1,1", true);
                    }
                    //obj_blur();
                }
                break; 
            case "btn_OrgChart":
                ComOpenPopup("/opuscntr/EES_EQR_1007.do", 480, 440, "", "0,1,1,1,1,1", true);
                break;      
            case "btn_LtStatus":
                ComOpenPopup("/opuscntr/EES_EQR_1006.do?pop_mode=Y", 1007, 645, "", "1,0,1,1,1,1,1,1", true);
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
         //axon_event.addListener('keyup', 'sub_loc_cd_onkeyUp', 'sub_loc_cd');                  //LOC_CD keyup 이벤트 처리
         //axon_event.addListener('keyup', 'loc_cd_second_onkeyUp', 'loc_cd_second');            //LOC_CD keyup 이벤트 처리
         //axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
         //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate이벤트에 코드 처리
         //axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
         //axon_event.addListener('blur', 'obj_blur', 'sub_loc_cd');                             //Location  blur 이벤트 처리
         //axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //알파벳 대문자,숫자만 입력허용
         //axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd');                        //RCC 변경시 이벤트 처리
         //axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');          //Location by 변경시 이벤트 처리
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
//            sheetObjects[i].Visible = true;
        }
        initControl();        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex=1; // Dry 선택
        tpszChange('D'); // Dry 선택
        var level_cd=document.form.level_cd.value;
        // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
        if(level_cd != "1") {
            ComBtnDisable("btn_save");      // SAVE 버튼 잠금
            ComBtnDisable("btn_LtStatus");  // LT Status 버튼 잠금 (EES_EQR_1006)
            sheetObjects[0].SetEditable(0);
            sheetObjects[1].SetEditable(0);
        }
        sheetObjects[0].RenderSheet(0);
        for(var k=6; k < weekTpArr.length; k++){ // f4,f5,f6,f7 히든
            sheetObjects[0].SetColHidden(weekTpArr[k]+"_img",1);
            sheetObjects[0].SetColHidden(weekTpArr[k]+"_ttl",1);
        }
        sheetObjects[0].RenderSheet(1);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                             
              var HeadTitle1="GRP|LOC|T|Section/type|ori_loc_cd|ori_ori_loc_cd|ori_ori_ori_loc_cd|code";
              var HeadTitle2="GRP|LOC|T|Section/type|ori_loc_cd|ori_ori_loc_cd|ori_ori_ori_loc_cd|code";
              var HeadTitleWeekArr=new Array("-2 week","-1 week","Current week","+1 week","+2 week","+3 week","+4 week","+5 week","+6 week","+7 week");
              for(var i=0; i < HeadTitleWeekArr.length; i++){
	              for(var j=0; j < 18; j++){
	            	  HeadTitle1 += "|" + HeadTitleWeekArr[i];
	              }
	              HeadTitle2 += "||D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|TTL";
              }
              for(var i=0; i < weekTpArr.length; i++){
	              for(var j=0; j < 18; j++){
	            	  HeadTitle1 += "|" + weekTpArr[i];
	              }
	              HeadTitle2 += "|wk|wk_f|d2_d|d4_d|d5_d|d7_d|r2_d|r5_d|r9_d|o2_d|s2_d|o4_d|s4_d|f2_d|a2_d|f4_d|a4_d|f5_d";
              }
              HeadTitleCnt=ComCountHeadTitle(HeadTitle1);
              //(HeadTitleCnt, 0, 0, true);
              //sheetObj.FrozenCols=8;

              SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:1000, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"tree",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"name",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"ori_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"ori_ori_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"ori_ori_ori_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                    for (i = 0; i < weekTpArr.length; i++) { // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7
                    	cols.push({Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:weekTpArr[i]+"_img",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d5",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d7",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r5",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r9",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_o2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_s2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_o4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_s4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_a2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_a4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f5",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Float",     Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_ttl",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    }
                    for(i = 0; i < weekTpArr.length; i++){ // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i],          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d4_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d5_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_d7_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r5_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_r9_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_o2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_s2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_o4_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_s4_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_a2_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f4_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_a4_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:weekTpArr[i]+"_f5_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    }
         
                    InitColumns(cols);

                    SetEditable(1);
                    SetImageList(0,"img/btns_search_off.gif");
                    SetImageList(1,"img/btns_search.gif");//popupicon이미지
                    SetImageList(2,"img/btns_note.gif");
                    SetWaitImageVisible(0);
                    SetCountPosition(0);
                    SetAutoRowHeight(0);// 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
                    //no support[check again]CLT 				   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                  //no support[check again]CLT                     SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                    //no support[check again]CLT 				   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
                    SetColHidden("p2_img",1);
                    SetColHidden("p1_img",1);
                    SetExtendLastCol(0);
                    SetSheetHeight(585);
                    
              	}
            break;
			case "sheet2":      // sheet2 init Multi 용 히든 시트
			    with(sheetObj){
		        
			      var HeadTitle="week|loc_grp_cd|loc_cd|sim_tp_cd|cntr_tpsz|cntr_qty|ibflag";
			      HeadTitleCnt=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sim_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetCountPosition(0);
			      //SetSheetHeight(0);
			      SetVisible(0);
		            }
			    
            break;
        }
    }
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSAVE:        //저장
                   ComOpenWait(true); 
                   formObj.f_cmd.value=MULTI01;
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
                sheetObjects[0].RemoveAll();
                formObj.f_cmd.value=SEARCH03;
                ComOpenWait(true);
                var sXml=sheetObj.GetSearchData("EES_EQR_1003GS.do",FormQueryString(formObj));   
                sheetObjects[0] = sheetObjects[0].Reset();
 	    	    initSheet(sheetObjects[0],1);
                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                sheetObjects[0].RenderSheet(0);		
                search_end(sheetObjects[0], 2, sheetObjects[0].LastRow());
                calcAverage(sheetObjects[0].HeaderRows(), sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount());
				calcAllTotal(sheetObjects[0].HeaderRows(), sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount());
                calcAllBalance(sheetObjects[0].HeaderRows(), sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount());
				sheetObjects[0].RenderSheet(1);
                ComOpenWait(false);                
                break;
           case SEARCH02:      //조회
               formObj.f_cmd.value=SEARCH02;
               sheetObj.SetWaitImageVisible(0);
               var sXml=sheetObj.GetSearchData("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
               var sCheck=ComGetEtcData(sXml, "check");
                if (sCheck != "T") {
                    if (document.form.sub_loc_cd.value != "") {
                        if (document.form.loc_type_code.value == "ES") {
                            ComShowCodeMessage("EQR90203");
                        }else if (document.form.loc_type_code.value == "LE" || document.form.loc_type_code.value == "LS") {
                            ComShowCodeMessage("EQR90202");
                        }else if (document.form.loc_type_code.value == "RE") {
                            ComShowCodeMessage("EQR90201");
                        }
                        document.form.sub_loc_cd.value="";
                        ComSetFocus(document.form.sub_loc_cd);
                        return false;
                    } else {
                        ComSetFocus(document.form.sub_loc_cd);
                    }
                }
                return true;
               break;                   
           case SEARCH03:      // Location 조회
               formObj.f_cmd.value=SEARCH02; // 위와 동일함(주의)
               sheetObj.SetWaitImageVisible(0);
               var sXml=sheetObj.GetSearchData("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
               var sCheck=ComGetEtcData(sXml, "check");
                if (sCheck != "T") {
                    if (document.form.loc_cd_second.value != "") {
                        if ( formObj.loc_tp_cd_second.value == 'E' ) {
                            ComShowCodeMessage("EQR90203");
                        } else if ( formObj.loc_tp_cd_second.value == 'L' ) {
                            ComShowCodeMessage("EQR90202");
                        } else if  ( formObj.loc_tp_cd_second.value == 'S' ) { // LCC 단위검색
                            ComShowCodeMessage("EQR90204");
                        }
                        document.form.loc_cd_second.value="";
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
   	   var level_cd=document.form.level_cd.value;
       with (sheetObj) {
           for(var i=startRow; i <= endRow; i++){
				  if(level_cd != 1 // level_cd=1 (SELCDO 만 수정가능, 나머지는 수정 불가)
						  ||GetCellValue(i,"loc_grp_cd")=="R"||GetCellValue(i,"loc_cd")=="TOTAL"
							  ||GetCellValue(i,"code")=="IN"||GetCellValue(i,"code")=="RI"||GetCellValue(i,"code")=="PI"||GetCellValue(i,"code")=="OT"
								  ||GetCellValue(i,"code")=="IC"||GetCellValue(i,"code")=="BA"||GetCellValue(i,"code")=="SP"||GetCellValue(i,"code")=="ST" ){
                      SetRowEditable(i,0);
                  } 
				  if(GetCellValue(i, "loc_grp_cd") != "R" && GetCellValue(i, "loc_cd") != "TOTAL" && GetCellValue(i, "code") != "IN" && GetCellValue(i, "code") != "OT" && GetCellValue(i, "code") != "IC" && GetCellValue(i, "code") != "BA" && GetCellValue(i, "code") != "SP" && GetCellValue(i, "code") != "ST"){
                      for(var j=188; j < LastCol(); j++){
                          if(ColSaveName(j).substr(5,2)=="_d"){
                        	  if(GetCellValue(i, j) == "Y"){ // _d 로 끝나는 cell value='Y' 이면 적색/bold 표시
                                  var colName=ColSaveName(j).substr(0,5);
                                   SetCellFont("FontBold", i, colName, i, colName,1);
                                   SetCellFontColor(i, colName,"#FF0000");
                        	  }else if(GetCellValue(i, j) == "X") { // _d 로 끝나는 cell value='X' 이면 파란색/bold 표시
                                  var colName=ColSaveName(j).substr(0,5);
                                   SetCellFont("FontBold", i, colName, i, colName,1);
                                   SetCellFontColor(i, colName,"#0000FF");
                              } 
                          }
                      }
                  }
				  if(GetCellValue(i, "code") == "RI" || GetCellValue(i, "code") == "PI" || GetCellValue(i, "code") == "OT" || GetCellValue(i, "code") == "IF"){
                      //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#F6FAFB"));// 푸른색
					  SetRowBackColor(i,"#F6FAFB");// 푸른색
					  if((GetCellValue(i, "loc_cd") != "TOTAL" && GetCellValue(i, "loc_grp_cd") != "R")
							  && (GetCellValue(i, "code")=="RI"||GetCellValue(i, "code")=="PI"
								  ||(GetCellValue(i, "code")=="OT"&&GetCellValue(i,"loc_grp_cd")=="L")&&document.form.level_cd.value=="1")){ // OT : loc_grp_cd 가 L 이고, user 가 SELCDO 일 때만 아이콘 만듬
                          for(var k=2; k<weekTpArr.length; k++){ // c0, f1 ~ f7
                               sheetObj.SetCellImage(i,weekTpArr[k]+"_img",1);// 조회 팝업 이미지
                          } 
                      }
				  }else if(GetCellValue(i, "code") == "OF" || GetCellValue(i, "code") == "RO"){
                      //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#FFEAEA"));// 분홍색
					  SetRowBackColor(i,"#FFEAEA");// 분홍색
//                  }else if(CellValue(i, "code") == "BA" || CellValue(i, "code") == "SP" || CellValue(i, "code") == "ST"){
//                      RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 
				  }else if(GetCellValue(i, "code") == "IN"){
                      SetRowBackColor(i,"#FFFFFF");//흰색
				  }else if(GetCellValue(i, "code") == "IC"){
                      SetRowBackColor(i,"#F0F0F0");//회색
                  }
				  if(GetCellValue(i, "code") == "IC"){ // 과거 일 때만 보임
                      for(var t=0; t<consTpszArr.length; t++) { 
                          for(var k=2; k<weekTpArr.length; k++){ // c0 ~ f7
                              sheetObj.SetCellValue(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase(),"",0);
                          }
                      }
				  }else if(GetCellValue(i, "code") == "PI"){ // 과거 일 때는 안 보임
                      for(var t=0; t<consTpszArr.length; t++) { 
                          sheetObj.SetCellValue(i,"p2_"+consTpszArr[t].toLowerCase(),"",0);
                          sheetObj.SetCellValue(i,"p1_"+consTpszArr[t].toLowerCase(),"",0);
                      }
                  }
				  if(GetCellValue(i,"code")=="PI" && document.form.f_version.value=="A"){
                     SetRowHidden(i,1);
                  }
          }
          for(var k=0; k<weekTpArr.length; k++){
              sheetObj.SetColBackColor(weekTpArr[k]+"_img","#F0F0F0");
              sheetObj.SetColBackColor(weekTpArr[k]+"_ttl","#C1C4E8");
          }
		  for(var t=0; t<consTpszArr.length; t++) { //cntr 전체 tpsz
		  	  sheetObj.SetColBackColor("p2_"+consTpszArr[t].toLowerCase(),"#F0F0F0");
			  sheetObj.SetColBackColor("p1_"+consTpszArr[t].toLowerCase(),"#F0F0F0");
		  }
		  for(var i=HeaderRows(); i<=HeaderRows()+RowCount(); i++){
			  if(GetCellValue(i, "code") == "SP" || GetCellValue(i, "code") == "ST"){
                  //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#D0EC7F"));// 연두색
			  }else if(GetCellValue(i, "code") == "BA"){
                  //no support[check again]CLT SetRowBackColor(i,sheetObj.WebColor2SysColor("#FFFFA0"));// 노란색
			  }
		  }
           sheetObj.SetCellFont("FontBold", 2, "tree", sheetObj.LastRow(), "tree",1);
           sheetObj.SetCellFont("FontSize", 2, "tree", sheetObj.LastRow(), "tree",10);
       }
   }
    function calcAllTotal(startRow, endRow){
        var sheetObj=sheetObjects[0];
        for(var i=startRow; i<=endRow; i++){
        	if(sheetObj.GetCellValue(i,"code")!="BA" && sheetObj.GetCellValue(i,"code")!="SP" && sheetObj.GetCellValue(i,"code")!="ST"){
                for(var k=0; k<weekTpArr.length; k++){
                    calcTotal(i,weekTpArr[k]);
                }
            }
        }
    }   
    function calcTotal(row, week){
        var sheetObj=sheetObjects[0];
        var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.split(",");
        var tmpTotal=0;
        for(var t=0; t<arr_tpsz.length; t++){
        	tmpTotal=tmpTotal + parseInt(sheetObj.GetCellValue(row,week+"_"+arr_tpsz[t].toLowerCase()));
        }
        sheetObj.SetCellValue(row,week+"_ttl",tmpTotal,0);
    }
    function calcAllBalance(startRow, endRow){
        var sheetObj=sheetObjects[0];
        var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.split(",");
        for(var i=startRow; i<=endRow; i++){
        	if(sheetObj.GetCellValue(i,"code")=="IN"){
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
        var sheetObj=sheetObjects[0];
        var version=document.form.f_version.value;
        tpsz=tpszl.toLowerCase();
        if(sheetObj.GetCellValue(inRow,"code") != "IN"){ // 행번호로 계산 하므로 inRow 를 IN 에 맞춰야 함
            for(var i=inRow; i>0; i--){
            	if(sheetObj.GetCellValue(i,"code") == "IN"){
	                inRow=i;
	                break;
	            }
	        }
        }        
        //weekTpArr // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7
        // f1 주차 부터는 앞주차의 Balance 를 Inventory 로 가져옴 
        if(week.substr(0,1)=="f"){ // p2, p1, c0 제외
            // 앞 주의 Balance(FCST) 를 Inventory 로 함
            if(week == "f1")
            	sheetObj.SetCellValue(inRow,week+"_"+tpsz,sheetObj.GetCellValue(inRow+8,"c0_"+tpsz),0);
            else // f2~f7
            	sheetObj.SetCellValue(inRow,week+"_"+tpsz,sheetObj.GetCellValue(inRow+8,"f"+(week.substr(1,1)*1-1)+"_"+tpsz),0);
        }
        // Balance 계산
        // Actual : IN + RI + OT + IF - OF - RO
        // Plan   : IN + RI + PI + OT + IF - OF - RO
        var tmpTotal=0 ; 
		if(version == "P" && sheetObj.GetCellValue(inRow+2,week+"_"+tpsz)!=""){ // Plan
			tmpTotal=parseInt(sheetObj.GetCellValue(inRow  ,week+"_"+tpsz)) // Inventory
			+ parseInt(sheetObj.GetCellValue(inRow+1,week+"_"+tpsz)) // Reposition In
			+ parseInt(sheetObj.GetCellValue(inRow+2,week+"_"+tpsz)) // Planned Repo-In
			+ parseInt(sheetObj.GetCellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
			+ parseInt(sheetObj.GetCellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
			- parseInt(sheetObj.GetCellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
			- parseInt(sheetObj.GetCellValue(inRow+6,week+"_"+tpsz)) // Reposition Out
                     ;
        }else{ // Actual
			tmpTotal=parseInt(sheetObj.GetCellValue(inRow  ,week+"_"+tpsz)) // Inventory
			+ parseInt(sheetObj.GetCellValue(inRow+1,week+"_"+tpsz)) // Reposition In
			+ parseInt(sheetObj.GetCellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
			+ parseInt(sheetObj.GetCellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
			- parseInt(sheetObj.GetCellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
			- parseInt(sheetObj.GetCellValue(inRow+6,week+"_"+tpsz)) // Reposition Out
                     ;
        }
        sheetObj.SetCellValue(inRow+8,week+"_"+tpsz,tmpTotal,0);// Balance
        if(tmpTotal < 0){ // 마이너스는 빨간색
             sheetObj.SetCellFontColor(inRow+8,week+"_"+tpsz,"#FF0000");
        }else{ // 파란색
             sheetObj.SetCellFontColor(inRow+8,week+"_"+tpsz,"#000000");
        }
        // EQ Supply Ratio (PFMC) 계산
        // [Inventory + MG + Repo-in + Others(LT/ST/OW)]/OP 
        var tmpEsp=0;
        if(parseInt(sheetObj.GetCellValue(inRow+5,week+"_"+tpsz))==0){ // OP Forecast
            sheetObj.SetCellValue(inRow+9,week+"_"+tpsz,"",0);// EQ Supply Ratio (PFMC)
        }else{
			tmpSrp=(   parseInt(sheetObj.GetCellValue(inRow  ,week+"_"+tpsz)) // Inventory
			+ parseInt(sheetObj.GetCellValue(inRow+1,week+"_"+tpsz)) // Reposition In
			+ parseInt(sheetObj.GetCellValue(inRow+3,week+"_"+tpsz)) // Other(LT/ST/OW)
			+ parseInt(sheetObj.GetCellValue(inRow+4,week+"_"+tpsz)) // MG Forecast
			) / parseInt(sheetObj.GetCellValue(inRow+5,week+"_"+tpsz)) // OP Forecast
                   ;
            sheetObj.SetCellValue(inRow+9,week+"_"+tpsz,tmpSrp.toFixed(1),0);// 소수점 1째 자리로 반올림
        }
    }
  // f4, f5, f6, f7 주차 IF, OF, RO 초기 값인 전 3주의 평균 구하기
  function calcAverage(startRow, endRow){
  	 var sheetObj=sheetObjects[0];
	 // consTpszArr
	 for (var i=startRow; i <= endRow; i++) {
		 if(sheetObj.GetCellValue(i,"code")=="IF"||sheetObj.GetCellValue(i,"code")=="OF"||sheetObj.GetCellValue(i,"code")=="RO"){
		 	for (var t=0; t < consTpszArr.length; t++) { //cntr 전체 tpsz
				for (var k=6; k < weekTpArr.length; k++) { // f4, f5, f6, f7
					if(sheetObj.GetCellValue(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase()+"_d")=="N"){ // 메뉴얼 입력 값 없으면
						var tmpAvg=(  sheetObj.GetCellValue(i,weekTpArr[k-3]+"_"+consTpszArr[t].toLowerCase())*1
								+ sheetObj.GetCellValue(i,weekTpArr[k-2]+"_"+consTpszArr[t].toLowerCase())*1
								+ sheetObj.GetCellValue(i,weekTpArr[k-1]+"_"+consTpszArr[t].toLowerCase())*1
									) / 3 ;
					    sheetObj.SetCellValue(i,weekTpArr[k]+"_"+consTpszArr[t].toLowerCase(),tmpAvg.toFixed(0),0);// 정수로 반올림
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
      var level_cd=document.form.level_cd.value;
	  with (sheetObj) {
	  	    if(  level_cd == 1 // level_cd=1 (SELCDO 만 수정가능, 나머지는 수정 불가)
	  	    		&& ColSaveName(Col).length == 5 && ColSaveName(Col) != "loc_cd" && GetCellValue(Row, ColSaveName(Col).substr(0,5)+"_d") == "Y" && GetCellValue(Row, "loc_grp_cd") != "R" && GetCellValue(Row, "loc_cd") != "TOTAL"
	  	    			&& ( GetCellValue(Row, "code") == "IF" || GetCellValue(Row, "code") == "OF" || GetCellValue(Row, "code") == "RO" )){
               show_del_btn(sheetObj, Row, Col);
            }
	  	    // INVENTORY 클릭시 INVENTORY 화면으로 팝업연결
	  	    if(GetCellValue(Row, "code") == "IN" && GetCellValue(Row, "loc_cd") != "TOTAL"){
	 			inv_popUp(sheetObj, Row, Col);
	 		}	  	    
            if (ColSaveName(Col).substr(3,3) == "img") {
                if(GetCellImage(Row,Col)=="-1" || GetCellImage(Row,Col)=="0"){ // popup 이미지 없거나, off 이면
                  return false;
                }
                if(GetCellValue(Row,"code")=="RI"){
                	var param="loc_cd=" + sheetObj.GetCellValue(Row,"loc_cd").substr(0,5)
                	+"&fcast_yrwk=" + sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
		               +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")                            
		               +"&loc_grp_cd=" + sheetObj.GetCellValue(Row,"loc_grp_cd")
		               +"&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
		               +"&row="+Row
		               +"&f_cmd=" + SEARCH
		               +"&level_cd=" + document.form.level_cd.value
		               ;
                	var page_sep=sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.GetCellValue(Row,"loc_cd").substr(0,5);
		            //에 의해 다중팝업이 가능하도록 변경, 2013-01-16,   
		            //ComOpenPopup("/opuscntr/EES_EQR_1048.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
		            ComOpenWindowCenter("/opuscntr/EES_EQR_1048.do?"+ param, "EES_EQR_1048"+page_sep, 1015, 735);            
                }else if(GetCellValue(Row,"code")=="PI"){
                	var param="loc_cd=" + sheetObj.GetCellValue(Row,"loc_cd").substr(0,5)
                	+"&fcast_yrwk=" + sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
                       +"&repo_pln_yrwk=" + ComTrimAll(document.form.fcast_yrwk.value, "-", "")                            
                       +"&loc_grp_cd=" + sheetObj.GetCellValue(Row,"loc_grp_cd")
                       +"&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
                       +"&row="+Row
                       +"&f_cmd=" + SEARCH
                       +"&level_cd=" + document.form.level_cd.value
					   +"&tpsz_flag=" + tpsztype.GetSelectText();
                       ;
                       var page_sep=sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.GetCellValue(Row,"loc_cd").substr(0,5);
                     //에 의해 다중팝업이 가능하도록 변경, 2013-01-16,   
                    //ComOpenPopup("/opuscntr/EES_EQR_1048.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
                    ComOpenWindowCenter("/opuscntr/EES_EQR_1040.do?"+ param, "EES_EQR_1048"+page_sep, 1015, 735);   
                }else if(GetCellValue(Row,"code")=="OT"){ // ON-HIRE APPROVAL 팝업오픈
					var param="pop_mode=Y"
						+ "&yrwk=" + sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2))
					          + "&tpsz_flag=" + tpsztype.GetSelectText()
					          + "&dp_seq=" +  sheetObj.ColSaveName(Col).substr(0,2) // week 의미
                              + "&row="+Row ;
					// LCC_CD 
					if (sheetObj.GetCellValue(Row, "loc_grp_cd") == "L") {
						param += "&lcc_cd=" + sheetObj.GetCellValue(Row, "loc_cd").substr(0, 5);
					}else{
						return false;
					}
					var page_sep=sheetObj.GetCellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.GetCellValue(Row,"loc_cd").substr(0,5);
                    ComOpenWindowCenter("/opuscntr/EES_EQR_1041.do?"+ param, "EES_EQR_1041"+page_sep, 1015, 655);   
                }
          }
          if(ColSaveName(Col) == "tree"){
              var addRow=(parseInt(((Row-2)/11))+1)*11+2        //선택한 세트 아래에 삽입하기 위한 row 계산
              var locGrpCd="";
              if (GetCellValue(Row, "loc_grp_cd") == "R"){
                  locGrpCd="L";
              }else if (GetCellValue(Row, "loc_grp_cd") == "L"){
                  locGrpCd="E";
              }else if (GetCellValue(Row, "loc_grp_cd") == "E"){
                  locGrpCd="S";
              }
              if(locGrpCd == "") return;  // SCC 는 +- 작동하지 않음().
              var locCd=GetCellValue(Row, "loc_cd").substr(0,5);
              if(GetCellValue(Row, Col) == "+"){
            	  if(GetCellValue(Row, "loc_cd").substr(0,5) != GetCellValue(addRow, "ori_loc_cd") || GetCellValue(addRow, "loc_grp_cd") != locGrpCd){    //최초 클릭시만 조회
                      var formObj=document.form;
                        formObj.f_cmd.value=SEARCH03;
                        var endRow=0;
                      if(locGrpCd == "L" || locGrpCd == "E" || locGrpCd == "S"){    //loc_grp_cd가 L이거나 E이거나 S일 때만 조회(R일 때는 최초 조회함)
                            ComOpenWait(true); 
                            RenderSheet(0);
						    var param="f_cmd="             + formObj.f_cmd.value
                                      + "&pagerows="         + formObj.pagerows.value
                                      + "&level_cd="         + formObj.level_cd.value
                                      + "&ofc_cd="           + formObj.ofc_cd.value
									  + "&loc_tp_cd_second=" + formObj.loc_tp_cd_second.value
                                      + "&loc_grp_cd="       + locGrpCd
                                      + "&loc_cd="           + locCd
                                      + "&ori_loc_cd="       + GetCellValue(Row, "ori_loc_cd")
                                      + "&ori_ori_loc_cd="   + GetCellValue(Row, "ori_ori_loc_cd")
                                      + "&div_flag=0"  // 왼쪽 +클릭을 의미함 ()
                                      ;
                             var sXml=sheetObjects[0].GetSearchData("EES_EQR_1003GS.do", param + "&fcast_yrwk="+formObj.fcast_yrwk.value);
                            sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:1} );
                            endRow=parseInt(ComGetTotalRows(sXml));
                            search_end(sheetObjects[0], addRow, addRow+endRow);          
                            calcAverage(addRow, addRow+endRow);
							calcAllTotal(addRow, addRow+endRow);
                            calcAllBalance(addRow, addRow+endRow);
							RenderSheet(1);
                            ComOpenWait(false); 
                      }
                  }
                  for(var i=addRow-11; i < addRow; i++){
                      SetCellValue(i, Col,"-",0);
                      SetCellFont("FontBold", i, "tree", i, "tree",1);
                      SetCellFont("FontSize", i, "tree", i, "tree",13);
                  }
              }else if(GetCellValue(Row, Col) == "-"){    //실제로 펼쳐진 경우에만 감춤 // 재 검토 하자 mds
                  for(var i=Row; i <= LastRow(); i++){
                	  if((GetCellValue(i, "loc_grp_cd") == locGrpCd && GetCellValue(i, "ori_loc_cd") == locCd) ||
                			  ((locGrpCd == "E") && (GetCellValue(i, "loc_grp_cd") == "S" && GetCellValue(i, "ori_ori_loc_cd") == locCd)) ||
                			  ((locGrpCd == "L") && (GetCellValue(i, "loc_grp_cd") == "E" && GetCellValue(i, "ori_ori_loc_cd") == locCd) || (GetCellValue(i, "loc_grp_cd") == "S" && GetCellValue(i, "ori_ori_ori_loc_cd") == locCd))){
                            sheetObjects[0].RowDelete(i, false);
                            i--;
                      }
                  }
                  for(var i=addRow-11; i < addRow; i++){
                      SetCellValue(i, Col,"+",0);
                      SetCellFont("FontBold", i, "tree", i, "tree",1);
                      SetCellFont("FontSize", i, "tree", i, "tree",10);
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
        	  var week=sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col).substr(0,2)); // week
        	  var locGrpCd=sheetObj.GetCellValue(Row, "loc_grp_cd");
        	  var locCd=sheetObj.GetCellValue(Row, "loc_cd").substr(0,5);
        	  var simTpCd=sheetObj.GetCellValue(Row, "code");
              var cntrTpsz=sheetObj.ColSaveName(Col).substr(3,2);
              var dup=0;
              for(var i=0; i <= LastRow(); i++){
            	  if(GetCellValue(i, "week") == week && GetCellValue(i, "loc_grp_cd") == locGrpCd && GetCellValue(i, "loc_cd") == locCd && GetCellValue(i, "sim_tp_cd") == simTpCd && GetCellValue(i, "cntr_tpsz") == cntrTpsz){
                      SetCellValue(i, "cntr_qty",Value);
                      dup++;
                  }
              }
              if(dup == 0){
                  DataInsert(-1);
                  SetCellValue(LastRow(), "week",week);
                  SetCellValue(LastRow(), "loc_grp_cd",locGrpCd);
                  SetCellValue(LastRow(), "loc_cd",locCd);
                  SetCellValue(LastRow(), "sim_tp_cd",simTpCd);
                  SetCellValue(LastRow(), "cntr_tpsz",cntrTpsz);
                  SetCellValue(LastRow(), "cntr_qty",Value);
              }
          }
    }	
    /**
     * 모든 sheet 클릭시 이벤트 발생
     */
    function click_del_btn(sheetObj, Row, Col){
         with (sheetObj) {
             ComOpenWait(true);
             var formObj=document.form;
               formObj.f_cmd.value=SEARCH01;
             var param="f_cmd="          + formObj.f_cmd.value
	                   + "&pagerows="      + formObj.pagerows.value
	                   + "&loc_grp_cd="    + GetCellValue(Row, "loc_grp_cd")
	                   + "&loc_cd="        + GetCellValue(Row, "loc_cd").substr(0,5)
	                   + "&week="          + GetCellValue(Row, sheetObj.ColSaveName(Col).substr(0,2))
	                   + "&cntr_tpsz="     + ColSaveName(Col).substr(3,2)
	                   + "&sim_tp_cd="     + GetCellValue(Row, "code");
             var sXml=GetSearchData("EES_EQR_1003GS.do", param);
             if(ComGetEtcData(sXml, "cntr_qty") != null && ComGetEtcData(sXml, "cntr_qty") != "" && ComGetEtcData(sXml, "cntr_qty") != "0"){
                 SetCellValue(Row, Col,ComGetEtcData(sXml, "cntr_qty"),0);
             }else{
                 SetCellValue(Row, Col,0,0);
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
                 SetCellValue(Row, ColSaveName(Col).substr(0,5)+"_d","N",0);
                 SetCellFont("FontBold", Row, Col, Row, Col,0);
                 SetCellFontColor(Row, Col,"#000000");
                 click_del_btn(sheetObj, Row, Col);
             }else{
            	 if ( sheetObj.GetCellValue(Row,Col) == '' ) {  //data format int형 널 방지
                    sheetObj.SetCellValue(Row,Col,0,0);
                 }
                 if(Value != ''){
				 	 SetCellValue(Row, ColSaveName(Col).substr(0,5)+"_d","Y",0);
 	                 SetCellFont("FontBold", Row, Col, Row, Col,1);
 	                 SetCellFontColor(Row, Col,"#FF0000");
 	                 if(GetCellValue(Row,"code")=="IF" || GetCellValue(Row,"code")=="OF" || GetCellValue(Row,"code")=="RO"){
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
		  break;
	}
  }   
   /**
   * 모든 sheet 클릭시 이벤트 발생
   */
  function inv_popUp(sheetObj, Row, Col){
       with (sheetObj) {
           var locTypeCode="";
           var inquiryLevel="";
           if(GetCellValue(Row, "loc_grp_cd") == "R"){
               locTypeCode="3";
               inquiryLevel="R";
           }else if(GetCellValue(Row, "loc_grp_cd") == "L"){
               locTypeCode="4";
               inquiryLevel="L";
           }else if(GetCellValue(Row, "loc_grp_cd") == "L"){
               locTypeCode="6";
               inquiryLevel="E";
           }else{
               locTypeCode="7";
               inquiryLevel="S";
           }
           var param="eqr_loc_type_code=" + locTypeCode
           +"&eqr_loc_cd=" + GetCellValue(Row, "loc_cd").substr(0,5);
           +"&location=" + GetCellValue(Row, "loc_cd").substr(0,5);
                  +"&inquiryLevel=" + inquiryLevel;
           ComOpenPopup("/opuscntr/EES_CIM_0008.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
       }
  }
  /**
   * shee6 클릭시 이벤트 발생
   */
  function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y)  {
       if(Button==1) {   // 왼쪽버튼
           mouseFlag=true; 
       }else if(Button==2) {  // 오른쪽 버튼
           mouseFlag=false; 
       }   
  }
   /**
    * Location 변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
   function loc_cd_onchange() {
        if(document.form.loc_cd.value == ""){ // ALL 선택            
            document.form.div_flag[0].disabled=true;
            document.form.div_flag[1].disabled=true; 
            ComEnableObject(document.form.sub_loc_cd,  false);  // Location by 입력창 비활성화
            ComEnableObject(document.form.btn_loc_cd,  false);  // Location by 돋보기창 비활성화
            ComEnableObject(document.form.loc_cd_second,      false); // Location 입력창 비활성화
            ComEnableObject(document.form.btn_loc_cd_second,  false); // Location 돋보기창 비활성화       
        }else{ // ALL 이 아닌 경우
              document.form.div_flag[0].disabled=false;
              document.form.div_flag[1].disabled=false;                   
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
         if(document.form.loc_type_code.value != "RE"){
             document.form.sub_loc_cd.value="";
            if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
                document.getElementById("sub_loc_cd").focus();
            }             
         }else{ 
             document.form.sub_loc_cd.value=document.form.loc_cd.value;        
         }
    }
    /**
     * Location 변경시 이벤트 처리
     */
    function loc_tp_cd_second_onchange() {
         document.form.loc_cd_second.value="";
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
        var formObject=document.form;
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
         var formObject=document.form;
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
         var formObject=document.form;
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
            document.getElementById("sub_loc_cd").className="input";
            document.getElementById("sub_loc_cd").focus();
            loc_type_code_onchange(); //Location by 변경시 이벤트 처리
        }else {  // 두번째 라디오 선택(Location)
            ComEnableObject(document.form.sub_loc_cd,         false);
            ComEnableObject(document.form.loc_cd_second,        true);
            ComEnableObject(document.form.btn_loc_cd,            false);         // Location by 돋보기창 활성화
            ComEnableObject(document.form.btn_loc_cd_second,  true);  // Location 돋보기창 활성화
            document.form.sub_loc_cd.value="";
            document.getElementById("loc_cd_second").className="input";
            document.getElementById("loc_cd_second").focus();
        }
    }     
   /**
    * 1048 팝업에서 선택한 repo in total값 Setting.
    * 1040 팝업에서 선택한 planned repo in total값 Setting.
    */
    function setRepoInValue(week, sheet_row, tpsz, value){
        // 의도적으로 event 발생시킴
        sheetObjects[0].SetCellValue(sheet_row, week+"_"+tpsz,ComAddComma(value));
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
        switch (key) {        
        case "":        	
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpsz, true);
            break;
        case "D":        	
        	comboObjects[0].SetSelectCode(-1);        	
            comboObjects[0].SetSelectCode(consTpszDry, true);            
            break;
        case "R":        	
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszRfr, true);
            break;
        case "O":        	
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszOt, true);
            break;
        case "F":        	
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszFr, true);
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
            var index=document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
        }
        if ( srcName == "f_version"){
        	sheetObjects[0].RenderSheet(0);
            var version=document.form.f_version.value;
            if(version == "P"){ // version Plan (P) // f4, f5, f6, f7, Planned Repo-In 보임 
                for(var k=6; k < weekTpArr.length; k++){ // f4,f5,f6,f7 히든
                    sheetObjects[0].SetColHidden(weekTpArr[k]+"_img",0);
                    sheetObjects[0].SetColHidden(weekTpArr[k]+"_ttl",0);
                }
                for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();i++){
                	if(sheetObjects[0].GetCellValue(i,"code")=="PI"){
                        sheetObjects[0].SetRowHidden(i,0);
                    }
                }
            }else{ // version Actual (A) // f4, f5, f6, f7, Planned Repo-In 숨김
                for(var k=6; k < weekTpArr.length; k++){ // f4,f5,f6,f7 히든
                    sheetObjects[0].SetColHidden(weekTpArr[k]+"_img",1);
                    sheetObjects[0].SetColHidden(weekTpArr[k]+"_ttl",1);
                }
                for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();i++){
                	if(sheetObjects[0].GetCellValue(i,"code")=="PI"){
                        sheetObjects[0].SetRowHidden(i,1);
                    }
                }
            }
            setGridHidden(tpsztype.GetSelectText());
            calcAllBalance(sheetObjects[0].HeaderRows(), sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount());
            sheetObjects[0].RenderSheet(1);
        }
    }
    function tpsztype_OnChange(){
    	sheetObjects[0].RenderSheet(0);
        setGridHidden(tpsztype.GetSelectText());        
        var sheetObj=sheetObjects[0]; 
		var tpsz_cd=tpsztype.GetSelectText();
		var arr_tpsz=tpsz_cd.split(",");
		ComOpenWait(true);
		calcAllTotal(sheetObjects[0].HeaderRows(), sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount());
		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount(); i++){
			if (sheetObj.GetCellValue(i, "code") == "IN") {
				for (var k=0; k < weekTpArr.length; k++) {
					for(var t=0; t < arr_tpsz.length; t++){
						if(sheetObj.GetCellValue(i+8,weekTpArr[k]+"_"+arr_tpsz[t].toLowerCase()) == "")
					       calcBalance(i, weekTpArr[k], arr_tpsz[t].toLowerCase());
					}
					calcBalance(i, weekTpArr[k], "ttl");
				}
			}
		}
		ComOpenWait(false);
		sheetObjects[0].RenderSheet(1);
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
        var version=document.form.f_version.value;
        if(version == "P"){ // version Plan (P)        
            for(var k=0; k < weekTpArr.length; k++){ // p2,p1,c0,f1,f2,f3,f4,f5,f6,f7 로 루프
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.SetColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase(),0);
                            break;
                        }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.SetColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase(),1);
                        }
                    }       
                }  
            }
        }else{ // version Actual (A)
            for(var k=0; k < 6; k++){ // p2,p1,c0,f1,f2,f3 로 루프
                for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                        if(consTpszArr[i] == arr_tpsz[j]){
                            sheetObj.SetColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase(),0);
                            break;
                        }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                            sheetObj.SetColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase(),1);
                        }
                    }       
                }  
            }
            for(var k=6; k < weekTpArr.length; k++){ // f4,f5,f6,f7 히든
                for(var i=0;i<consTpszArr.length;i++){ // 전체의 Container Type/Size       
                    for(var j=0;j<arr_tpsz.length;j++){ // 선택된 Container Type/Size
                        sheetObj.SetColHidden(weekTpArr[k]+"_"+consTpszArr[i].toLowerCase(),1);
                    }       
                }
            }
        }
    }    
    /**
     * New 버튼 클릭시 화면 초기화.
     */
    function init_form() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	// RCC 초기화
    	formObj.loc_cd.value="";
    	loc_cd_onchange();  // RCC 선택값에 의한 LOCATION 초기화
    	// VERSION 초기화
    	formObj.f_version.value="A";
    	//CNTR TY/SZ DRY로 설정
    	formObj.cntrTpsz.selectedIndex=1; // Dry 선택
    	tpszChange("D");
    	// GRID 초기화
    	sheetObj.RemoveAll();
    }    
    /* 개발자 작업  끝 */