/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1001.js
*@FileTitle : OP/MG Forecast Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
    // 공통전역변수
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var IBSEARCH01=29;
    var IBSEARCH02=30;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
    var focFlag1=true;	//스크롤 제어용
    var focFlag2=true;
    var mainXml="";
    var saveFlag="0";		//세이브 버튼 및 시트 수정  제어용(0,1,2,3)
    var comboObjects=new Array();
    var comboCnt=0 ;
    var tmpWk="";
	var popupEditFlg="N"; // +Other 가 popup 화면에 의하여 변경 되었는지 판단
	var refe2kind=""; // BKG,COP
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
    var searchDivideFlag=false;
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
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
			case "btn_new":		//조회조건 초기화
				sheetObjects[0] = sheetObjects[0].Reset();
				initSheet(sheetObjects[0],1);     // 해더 타이틀까지 새로하기 위함
				
				sheetObjects[1].RemoveAll();
				initSheet2(sheetObjects[1]);      //초기 sheet2 디지인 세팅
				
				sheetObjects[2] = sheetObjects[2].Reset();
				initSheet(sheetObjects[2],3);     // 해더 타이틀까지 새로하기 위함
				
				formObject.reset();
                document.form.cntrTpsz.selectedIndex=1; // Dry 선택
                tpszChange('D'); // Dry 선택
				document.form.init_flag.value="INIT";
				ComSetFocus(document.form.loc_cd);
				break;
    		case "btn_Retrieve":
    		    searchDivideFlag=true;
    			if (doActionIBSheet(sheetObjects[0], formObject, IBSEARCH)) {
					doActionIBSheet(sheetObjects[1], formObject, SEARCH04);
				}
                //initSheet(sheetObjects[2],3); // 해더 타이틀까지 새로하기 위함
    			break;
			case "btn_save":
    			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
    			break;
    		case "btn_downExcel":
				sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObjects[0]), SheetDesign:1,Merge:1 });
 				sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObjects[1]), SheetDesign:1,Merge:1 });
 				sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObjects[2]), SheetDesign:1,Merge:1 });
    			break;
			case "btn_loc_cd":	//Location 조회 팝업
				var code_type=formObject.loc_grp_cd.value;
				if(code_type == "E") {
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
				}else if(code_type == "S") {	
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
    		    }else if(code_type == "L"){
    		    	ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
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
        axon_event.addListenerForm('change','form_change',form);
    }    
	
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
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
     * @version 2009.01.01
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
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            sheetObjects[i].SetVisible(1);
        }
        initControl();
        document.form.init_flag.value='INIT';

		for(p=0;p< comboObjects.length;p++){
            initCombo(comboObjects[p],p+1);
        }
		document.form.cntrTpsz.selectedIndex=1; // Dry 선택
        tpszChange('D'); // Dry 선택
        ComSetFocus(document.form.loc_cd);
        // 0주차로 스크롤 이동 ()  
      //no support[check again]CLT  sheetObjects[0].SetHighLeftCol(58);
        //sheetObjects[0].LeftCol = 40;  
	}
	
    var leftHeaders0 = [{Text:"Inventory|MG FCST|MG PFMC|Repo In|OW&On-hire|+ Others|OP FCST|OP PFMC|Repo Out|Balance(FCST)|Balance(PFMC)", Align:"Left"}];
    var leftHeadersTitle = [{Text:"OP|MG|Repo Out", Align:"Left"},{Text:"OP|MG|Repo Out", Align:"Left"}];
    var leftHeadersTitle1 = [{Text:"OP|OP|OP|OP|MG", Align:"Left"}, {Text:"TTL|MT Picked Up|Full Gate-in|The rest|MG", Align:"Left"}];
    
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
	    var shtID=sheetObj.id;
        if(( comboObjects[0].GetSelectText()== null || comboObjects[0].GetSelectText()== "")){
            tpszArr=tpszallText.split("|");
        } else {
            tpszArr=(comboObjects[0].GetSelectText()).split(",") ;
        }
	    switch(shtID) {
	    	case "sheet1":      //sheet1 init
	    	    with(sheetObj){	            
			          headTitle1="Title|Title"
			          +"|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)"
			          +"|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)"
			          +"|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)"
			          +"|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)"
			          +"|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)"
			          +"|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)"
			          +"|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)"
			          +"|w1_wk|w2_wk|w3_wk|w4_wk|w5_wk|w6_wk|w7_wk"
			          +"|w1_f|w2_f|w3_f|w4_f|w5_f|w6_f|w7_f"
			          +"|w4_ef|w5_ef|w6_ef|w7_ef"
			          +"|dp_seq|loc_cd|loc_grp_cd|mty_bal_tp_cd|ibflag";
			          headTitle2="Title|Title"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
			          +"|w1_wk|w2_wk|w3_wk|w4_wk|w5_wk|w6_wk|w7_wk"
			          +"|w1_f|w2_f|w3_f|w4_f|w5_f|w6_f|w7_f"
			          +"|w4_ef|w5_ef|w6_ef|w7_ef"
			          +"|dp_seq|loc_cd|loc_grp_cd|mty_bal_tp_cd|ibflag";
			          var headCnt=headTitle2.split("|").length;
			          HeadTitleCnt=headCnt;
			          SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:7, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			          var headers = [ { Text:headTitle1, Align:"Center"},{ Text:headTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"title",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"item",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"w1_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w2_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w3_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w4_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w5_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w6_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"w7_img",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_ttl",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w5_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w6_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w7_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w1_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w2_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w3_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w4_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w5_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w6_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w7_f",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w4_ef",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w5_ef",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w6_ef",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"w7_ef",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"loc_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mty_bal_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetImageList(0,"img/btns_search_off.gif");
			          SetImageList(1,"img/btns_search.gif");//popupicon이미지
			          SetImageList(2,"img/btns_note.gif");//MG/OPLOG이미지
			          InitHeadColumn(leftHeaders0,sheetObj);
			          SetSheetHeight(350);
	          		}
	    		break;
             case "sheet2":      //sheet2 init
            	    with(sheetObj){
		               headTitle1="Title|Title"
		               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
		               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
		               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
		               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
		               +"|wky_sim_tp_cd|dp_seq";
		               headTitle2="Title|Title|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5|wky_sim_tp_cd|dp_seq";
		               var headCnt=headTitle2.split("|").length;
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:5, FrozenCol:0, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		               var headers = [ { Text:headTitle1, Align:"Center"},
		                               { Text:headTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"title",          KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"item",           KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"r9_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"o5_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"wky_sim_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(0);
		               InitHeadColumn(leftHeadersTitle,sheetObj);
		               initSheet2(sheetObj);
		               SetSheetHeight(200);//122;
               		}
                break;  
            case "sheet3":      //sheet3 init
                with(sheetObj){
		              headTitle1="Title|Title||Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)"
		              +"|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)"
		              +"|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)"
		              +"|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)"
		              +"|code|w1_wk|w2_wk|w3_wk|w4_wk";
		              headTitle2="Title|Title||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
		              +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
		              +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
		              +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5"
		              +"|code|w1_wk|w2_wk|w3_wk|w4_wk";
		              var headCnt=headTitle2.split("|").length;
		              SetConfig( { SearchMode:2, MergeSheet:7, Page:7, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:headTitle1, Align:"Center"}, { Text:headTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"title",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_ttl",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_d7",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_r9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_s2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_s4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_a2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_a4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_f5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_o5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_ttl",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_d7",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_r9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_s2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_s4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_a2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_a4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_f5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_o5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_ttl",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_d7",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_r9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_s2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_s4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_a2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_a4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_f5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_o5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_ttl",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_d7",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_r9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_s2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_s4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_a2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_a4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_f5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_o5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"code",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w1_wk",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w2_wk",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w3_wk",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"w4_wk",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(0);
		              InitHeadColumn(leftHeadersTitle1,sheetObj);
		              SetMergeCell(0, 0, 2, 2); // 헤더 강제 merge
		              initSheet3(sheetObj);
		              SetSheetHeight(200);//162
              		}
                break;
	    }
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
		sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	       case IBSEARCH: // 메인 sheet 조회
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   if ( !ComIsDate(formObj.fcast_yrwk.value, "yw") ) {
	    		   ComShowMessage(msgs["CIM30003"]);
	    		   formObj.fcast_yrwk.focus();
	    		   return;
	    	   }
	    	   sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 
	    	   //sheetObj.RenderSheet(0);
               sheetObjects[0].RemoveAll();
               formObj.f_cmd.value=SEARCH03;
               formObj.init_flag.value="search";
         	   mainXml=sheetObj.GetSearchData("EES_EQR_1001GS.do" , FormQueryString(form));
         	   //sheetObjects[0] = sheetObjects[0].Reset();
         	   //initSheet(sheetObjects[0],1);
         	   sheetObjects[0].LoadSearchData(mainXml,{Sync:1} );
       			// LCC QTY를 먼저 입력하지 않으면, ECC/SCC 를 입력하지 못하도록 SAVE버튼, GRID 를 비활성화
       			// 2013년,   으로 기능 제거  
        	   /*
	    	   saveFlag=ComGetEtcData(mainXml,"save_flag");
	    	   if(saveFlag == "T"){
	    		   ComBtnEnable("btn_save");
	    		   sheetObj.SetEditable(1);
	    	   }else{
	    		   ComBtnDisable("btn_save");
	    		   sheetObj.SetEditable(0);
	    		   ComShowCodeMessage("EQR01003");
	    	   }
	    	   */
        	   // 
	    	   saveFlag=ComGetEtcData(mainXml,"save_flag");
	    	   if(saveFlag == "0") {
	    		   ComBtnEnable("btn_save");
	    		   sheetObj.SetEditable(1);
	    	   }else{  // 1,2,3 인 경우(수정 불가)
	    		   /*
	    		   msgs['EQR01136']='Impossible to update past week's data.';   
	    		   msgs['EQR01137']='FCAST cannot be updated this time. \n Plz contact CDO-EQ for FCST Revision.';     
	    		   msgs['EQR01138']='FCST revision for accuracy evaluation only available by 17:00, Friday.';
	    		   */ 	    		   
	    		   if(saveFlag == "1")      ComShowCodeMessage("EQR01136");  // 과거주(Location의 LOCAL TIME) 인 경우
	    		   else if(saveFlag == "2") ComShowCodeMessage("EQR01137");  // 이번주(Location의 LOCAL TIME) 인 경우
	    		   else if(saveFlag == "3") ComShowCodeMessage("EQR01138");  // 미래주차(current) 이지만 금요일 17:00시 지남
	    		   ComBtnDisable("btn_save");
	    		   sheetObj.SetEditable(0);
	    	   }	    	   	   
			   //sheetObj.RenderSheet(1);
	    	   ComOpenWait(false);
			   return true;
	    	   break;
            case SEARCH04: // Reference1 조회
               sheetObj.RemoveAll();
               sheetObj.SetWaitImageVisible(0);
               ComOpenWait(true); 
               sheetObj.RenderSheet(0);
               formObj.f_cmd.value=SEARCH04;
               sXml=sheetObj.GetSearchData("EES_EQR_1001GS.do" , FormQueryString(form));
               sheetObj.LoadSearchData(sXml,{Sync:1} );
			   ComOpenWait(false); 
               sheetObj.RenderSheet(1);
               break;	
			case SEARCH05: // Reference2 조회
               sheetObj.SetWaitImageVisible(0);
               ComOpenWait(true); 
               sheetObj.RenderSheet(0);
               formObj.f_cmd.value=SEARCH05;		   
				if (refe2kind == "BKG") {//BKG 클릭한거면
 					sXml=sheetObj.GetSearchData("EES_EQR_1001GS.do", FormQueryString(formObj) + "&kind=" + refe2kind);
					if(parseInt(ComGetTotalRows(sXml)) == 4){//조회 결과가 4줄이 맞으면
						sheetObj.RowDelete(5,false);
						sheetObj.RowDelete(4,false);
						sheetObj.RowDelete(3,false);
						sheetObj.RowDelete(2,false);
						sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
						var weekStr1=sheetObj.GetCellValue(2,"w1_wk").substr(4,2) + " Week(0)";
						var weekStr2=sheetObj.GetCellValue(2,"w2_wk").substr(4,2) + " Week(+1)";
						var weekStr3=sheetObj.GetCellValue(2,"w3_wk").substr(4,2) + " Week(+2)";
						var weekStr4=sheetObj.GetCellValue(2,"w4_wk").substr(4,2) + " Week(+3)";
						for(var i=3; i<21; i++){
							sheetObj.SetCellValue(0,i,weekStr1,0);
							sheetObj.SetCellValue(0,i+(18*1),weekStr2,0);
							sheetObj.SetCellValue(0,i+(18*2),weekStr3,0);
							sheetObj.SetCellValue(0,i+(18*3),weekStr4,0);
						}
					}
				} else if(refe2kind == "COP"){//COP 클릭한거면
 					sXml=sheetObj.GetSearchData("EES_EQR_1001GS.do", FormQueryString(formObj) + "&kind=" + refe2kind);
					if (parseInt(ComGetTotalRows(sXml)) == 1) {//조회 결과가 1줄이 맞으면
						sheetObj.RowDelete(6, false);
						sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
						var weekStr1=sheetObj.GetCellValue(6,"w1_wk").substr(4,2) + " Week(0)";
						var weekStr2=sheetObj.GetCellValue(6,"w2_wk").substr(4,2) + " Week(+1)";
						var weekStr3=sheetObj.GetCellValue(6,"w3_wk").substr(4,2) + " Week(+2)";
						var weekStr4=sheetObj.GetCellValue(6,"w4_wk").substr(4,2) + " Week(+3)";
                        for(var i=3; i<21; i++){
                            sheetObj.SetCellValue(0,i,weekStr1,0);
							sheetObj.SetCellValue(0,i+(18*1),weekStr2,0);
							sheetObj.SetCellValue(0,i+(18*2),weekStr3,0);
							sheetObj.SetCellValue(0,i+(18*3),weekStr4,0);
                        }
					}
				}
				//sheetObj.InitHeadColumn("title", "OP|OP|OP|OP|MG", daCenter);
				//sheetObj.InitHeadColumn("item", "TTL|MT Picked Up|Full Gate-in|The rest|MG", daCenter);
				InitHeadColumn(leftHeadersTitle1,sheetObj);
				initSheet3(sheetObj);
			   ComOpenWait(false); 
               sheetObj.RenderSheet(1);
               break;   
			case SEARCH06: // 직전 주차 조회
			   formObj.f_cmd.value=SEARCH06;
                sXml=sheetObj.GetSearchData("EES_EQR_1001GS.do" , FormQueryString(form)+"&week="+tmpWk);
			   var beforeweek=ComGetEtcData(sXml,"beforeweek");
			   return beforeweek;
               break;
			case IBSEARCH02: // location focusOut
				var flag=false;
				formObj.inquiryLevel.value=formObj.loc_grp_cd.value;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_EQR_1001GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if (document.form.loc_grp_cd.value == "E") {
							ComShowCodeMessage("EQR01006");
						}else if (document.form.loc_grp_cd.value == "S") {
							ComShowCodeMessage("EQR01007");
						}else if (document.form.loc_grp_cd.value == "L") {
							ComShowCodeMessage("EQR01005");
						}
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.fcast_yrwk);
				}				
				break;		    	   
	       case IBSAVE: // 메인 sheet 저장
	    	   if(validateForm(sheetObj,formObj,sAction))
    		   if (!ComShowCodeConfirm("COM130101")) return;
	    	   formObj.f_cmd.value=MULTI01;
	    	   for ( var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.rowCount; i++ ) {
	    	       // MG Fcst, OW&OnHire, OP Fcst 만 저장 대상 로우, 그 외는 트랜잭션 제외
	    		   if ( i != 3 && i != 6 && i != 8) {
	    			   sheetObj.SetRowStatus(i,"R");
	    		   }else if(sheetObj.GetCellValue(i,"w4_ef")!="Y"
	    			   && sheetObj.GetCellValue(i,"w5_ef")!="Y"
	    				   && sheetObj.GetCellValue(i,"w6_ef")!="Y"
	    					   && sheetObj.GetCellValue(i,"w7_ef")!="Y"){
				   	   sheetObj.SetRowStatus(i,"R");
				   }
	    	   }
	    	   sheetObj.RenderSheet(0);
			   var result=false;
	    	   if ( sheetObj.GetSaveString() == '' ) {
 	    		   ComShowMessage(sheetObj.MessageText("UserMsg13"));	//There is no contents to save
	    	   } else {
	    		   sheetObj.DoSave("EES_EQR_1001GS.do",FormQueryString(formObj),"ibflag",false);
	    	   }
	    	   sheetObj.RenderSheet(1);
			   break;
	    }
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(formObj){
			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
    		   return false;
			} else {			
				if (!ComChkValid(formObj)) return false;	
				return true;		
			}
	    }
	    return true;
	}
	/**
	 * 화면 폼입력시 널입력시 0으로 변환
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if ( document.form.init_flag.value != 'INIT' ) {
			//
	    	if (sheetObject.GetCellEditable(Row, Col)) {// 편집가능으로 설정된 Cell 일 경우
	    		if ( sheetObject.GetCellValue(Row,Col) == '' ) {	//data format int형 널 방지
		    		sheetObject.SetCellValue(Row,Col,0,0);
		    	}
	    	}
    	}
    }
	/**
	 * sheet1 초기 디자인 세팅
	 */
	function initSheet1(sheetObj){
		if(sheetObj.RowCount()> 0){
		}else{
			return false;
		}
		for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
			if (    sheetObj.GetCellValue(i, "dp_seq") == "2" // MG FCST
				||	sheetObj.GetCellValue(i, "dp_seq") == "5" // OW&On-hire
					||	sheetObj.GetCellValue(i, "dp_seq") == "7") { // OP FCST
                sheetObj.SetRowEditable(i,1);
 				sheetObj.SetCellFontColor(i,"title","#0000FF");
 				sheetObj.SetCellFontColor(i,"item","#0000FF");
			}else{
				sheetObj.SetRowEditable(i,0);
			}
		}
		setLeftFontColor(sheetObj);
		chgBackColor(sheetObj);
	}
	/**
     * sheet2 초기 디자인 세팅
     */
    function initSheet2(sheetObj){
        for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
            sheetObj.SetCellBackColor(i,"title","#FFFFFF");
			sheetObj.SetCellAlign(i,"title","Center");
             sheetObj.SetCellFont("FontBold", i,"title",1);
		}
	}
	/**
     * sheet3 초기 디자인 세팅
     */
    function initSheet3(sheetObj){
        for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
            sheetObj.SetCellBackColor(i,"title","#FFFFFF");
            sheetObj.SetCellAlign(i,"title","Center");
             sheetObj.SetCellFont("FontBold", i,"title",1);
			sheetObj.SetCellBackColor(i,"item","#FFFFFF");
            sheetObj.SetCellAlign(i,"item","Center");
             sheetObj.SetCellFont("FontBold", i,"item",1);
        }
         sheetObj.SetCellFontUnderline(2,"title",1);
         sheetObj.SetCellFontUnderline(6,"title",1);
    }
    /**
     * left폰트 변경
     */
	function setLeftFontColor(sheetObj) {
		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j ==0 || j ==1) {
			   		sheetObj.SetCellAlign(i,j,"Center");
 				   	sheetObj.SetCellFont("FontBold", i,j,1);
		   		}
		   	}
		}
	}
    /**
     * sheet1 배경색 변경
     */
	function chgBackColor(sheetObj) {
	   	for ( var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++ ) {
	   		sheetObj.SetRowStatus(i,"R");
	   		sheetObj.SetCellEditable(i,"w1_ttl",0);
	   		sheetObj.SetCellEditable(i,"w2_ttl",0);
	   		sheetObj.SetCellEditable(i,"w3_ttl",0);
			sheetObj.SetCellEditable(i,"w4_ttl",0);
            sheetObj.SetCellEditable(i,"w5_ttl",0);
            sheetObj.SetCellEditable(i,"w6_ttl",0);
			sheetObj.SetCellEditable(i,"w7_ttl",0);
		   	for ( var j=2; j<HeadTitleCnt; j++ ) {
				if(sheetObj.ColSaveName(j).substr(3,3) == "ttl"
				    || sheetObj.ColSaveName(j).substr(3,3) == "img"){ // ttl column 및 icon column 회색 표시
					if  ( i==11 || i==12) { 
                            //no support[check again]CLT sheetObj.SetCellBackColor(i,j,sheetObj.WebColor2SysColor("#D0EC7F"));
						sheetObj.SetCellBackColor(i,j,"#D0EC7F");
                        } else {
                            //sheetObj.SetCellBackColor(i,j,"#F0F0F0");
                        }
				}else{
			   		if(sheetObj.ColSaveName(j).substr(1,1) == "1"
					    || sheetObj.ColSaveName(j).substr(1,1) == "2"
					    || sheetObj.ColSaveName(j).substr(1,1) == "3"){ // 1 ~ 3 주차 회색 표시
			   			if  ( i==11 || i==12) { 
//no support[check again]CLT 	                        sheetObj.SetCellBackColor(i,j,sheetObj.WebColor2SysColor("#D0EC7F"));
			   				sheetObj.SetCellBackColor(i,j,"#D0EC7F");
	                    } else {
	                        //sheetObj.SetCellBackColor(i,j,"#F0F0F0");
	                    }
			   		} else { // 나머지 주차 및 타이틀란 컬러 표시 
			   			if ( i>=3 && i <=7) {
//no support[check again]CLT 	                        sheetObj.SetCellBackColor(i,j,sheetObj.WebColor2SysColor("#F6FAFB"));
			   				//sheetObj.SetCellBackColor(i,j,"#F6FAFB");
	                    } else if  ( i>=8 && i <=10) { 
//no support[check again]CLT 	                        sheetObj.SetCellBackColor(i,j,sheetObj.WebColor2SysColor("#FFEAEA"));
	                    	//sheetObj.SetCellBackColor(i,j,"#FFEAEA");
	                    } else if  ( i==11 || i==12) { 
//no support[check again]CLT 	                        sheetObj.SetCellBackColor(i,j,sheetObj.WebColor2SysColor("#D0EC7F"));
	                    	sheetObj.SetCellBackColor(i,j,"#D0EC7F");
	                    } else {
	                        //sheetObj.SetCellBackColor(i,j,"#FFFFFF");
	                    }
					}
				}
		   	}
	   	}
	}
    /**
     * sheet1 손가락 모양으로 마우스 커서 변경
     */
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y) {
	    var col=sheetObj.MouseCol();
	    var i=sheetObj.MouseRow();
	    
	    if (sheetObj.ColSaveName(col) != "-1") {
		    if ( document.form.init_flag.value != 'INIT' ) { 
	 			if ( sheetObj.ColSaveName(col).substr(3,3) == "img" && i >= sheetObj.HeaderRows() && sheetObj.GetCellImage(i,col) > 0) { // 해당조건에 맞게 마우스 커서 변경
					sheetObj.SetMousePointer("Hand");// 손가락 모양으로 마우스 커서 변경
				}
		    }
	    }
	}
	/**
     * sheet1 손가락 모양으로 마우스 커서 변경
     */
    function sheet3_OnMouseMove(sheetObj,Button, Shift, X, Y) {
        var col=sheetObj.MouseCol();
        var i=sheetObj.MouseRow();
        if ( document.form.init_flag.value != 'INIT' ) { 
            if ( col == 0 && i > 1 && i < 7 ) { // 해당조건에 맞게 마우스 커서 변경
                sheetObj.SetMousePointer("Hand");// 손가락 모양으로 마우스 커서 변경
            }
        }
    }
	/**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	if(searchDivideFlag == false){return;}
	   if( sheetObj.RowCount() < 1){
	          //InitHeadColumn(leftHeaders0,sheetObj);
	    } else {
	          //InitHeadText(leftHeaders0,sheetObj);
	   }    	   
    	   
        sheetObj.SetEditable(1);
		sheetObj.SetEditableColor("#000000");
        //no support[check again]CLT sheetObj.UnEditableColor="#000000";
        //sheetObj.SelectHighLight = false;
        //if(ErrMsg)
		  //alert(ErrMsg);
        if(sheetObj.RowCount("R")>1){
            for(var j=2;j<HeadTitleCnt;j++){
            	var weekStr=sheetObj.GetCellValue(2,sheetObj.ColSaveName(j).substr(0,2)+"_wk"); // 6자리 주차
                if(sheetObj.ColSaveName(j).substr(0,2)=="w1"){
                    weekStr=weekStr.substr(4,2)+" Week (-3)" ;
				}else if(sheetObj.ColSaveName(j).substr(0,2)=="w2"){
                    weekStr=weekStr.substr(4,2)+" Week (-2)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w3"){
                    weekStr=weekStr.substr(4,2)+" Week (-1)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w4"){
                    weekStr=weekStr.substr(4,2)+" Week (0)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w5"){
                    weekStr=weekStr.substr(4,2)+" Week (+1)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w6"){
                    weekStr=weekStr.substr(4,2)+" Week (+2)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w7"){
                    weekStr=weekStr.substr(4,2)+" Week (+3)" ;
                }
				sheetObj.SetCellValue(0,j,weekStr ,0);
				if(sheetObj.ColSaveName(j)=="w7_o5")
				    break;
            }
			for(var i=1; i<=7; i++){
 				sheetObj.SetCellImage(3,"w"+i+"_img",2);// 로그 팝업 이미지
 				sheetObj.SetCellImage(8,"w"+i+"_img",2);
 				if(i<=3 && sheetObj.GetCellValue(2,"w"+i+"_f")=="Y"){
 					sheetObj.SetCellImage(5,"w"+i+"_img",1);// 조회 팝업 이미지
 					sheetObj.SetCellImage(7,"w"+i+"_img",1);
 					sheetObj.SetCellImage(10,"w"+i+"_img",1);
				}else if(i>3){
 					sheetObj.SetCellImage(5,"w"+i+"_img",1);// 조회 팝업 이미지
 	                sheetObj.SetCellImage(7,"w"+i+"_img",1);
 	                sheetObj.SetCellImage(10,"w"+i+"_img",1);
				}
			}
			calcBalance();
			calcAllTotal();
			initSheet1(sheetObj);
		}
    }
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	   if( sheetObj.RowCount() < 1){
	        InitHeadColumn(leftHeadersTitle,sheetObj);
	    } else {
	    	InitHeadText(leftHeadersTitle,sheetObj);
	   }
        // sheet2 의 합계 구하기 
        calcTotalSheet2();
    }
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
 	   if( sheetObj.RowCount() < 1){
	        InitHeadColumn(leftHeadersTitle1,sheetObj);
	    } else {
	    	InitHeadText(leftHeadersTitle1,sheetObj);
	   }

        // sheet3 의 합계 구하기 
        calcTotalSheet3();
    }
	function calcAllTotal(){
		var sheetObj=sheetObjects[0];
		for (var week=1; week <= 7; week++) {
			for (var row=sheetObj.HeaderRows(); row < sheetObj.HeaderRows()+ sheetObj.RowCount(); row++) {
                calcTotal(week,row);
			}
		}
	}
	function calcTotal(week,row){
		//sheet1 해당 week, 해당 row 의 합계 구하기
        var sheetObj=sheetObjects[0];
		if(week < 1 || week > 7 || row < sheetObj.HeaderRows()|| row > sheetObj.HeaderRows()+ sheetObj.RowCount()){
			return false;
		}
		var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.split(",");
        var tmpSum=0;
        for (var j=0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
        	tmpSum=tmpSum + parseInt(sheetObj.GetCellValue(row,"w" + week + "_" + arr_tpsz[j].toLowerCase()));
        }
        sheetObj.SetCellValue(row,"w"+week+"_ttl",tmpSum,0);
        if(row == 11 || row == 12){ // Balance 인 경우, 색상 지정
            if(tmpSum < 0){ // 마이너스는 빨간색
                 sheetObj.SetCellFontColor(row,"w"+week+"_ttl","#FF0000");
            }else{ // 파란색
                 sheetObj.SetCellFontColor(row,"w"+week+"_ttl","#0000FF");
            }
        }
     }
	function calcTotalSheet2(){
		// sheet2 의 합계 구하기 
		sheetObj=sheetObjects[1];		
        var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.split(",");
        var tmpSum=0;
        for(var row=sheetObj.HeaderRows(); row < sheetObj.HeaderRows()+ sheetObj.RowCount(); row++){
            tmpSum=0;
            for (var j=0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
            	tmpSum=tmpSum + parseInt(sheetObj.GetCellValue(row,arr_tpsz[j].toLowerCase()+"_qty"));
            }
            sheetObj.SetCellValue(row,"ttl",tmpSum,0);
        }
	}
	function calcTotalSheet3(){
        // sheet3 의 합계 구하기 
		sheetObj=sheetObjects[2];       
        var tpsz_cd=tpsztype.GetSelectText();
        var arr_tpsz=tpsz_cd.split(",");
        var tmpSum1=0;
        var tmpSum2=0;
        var tmpSum3=0;
        var tmpSum4=0;        
        for(var row=sheetObj.HeaderRows(); row < sheetObj.HeaderRows()+ sheetObj.RowCount(); row++){
            tmpSum1=0;
            tmpSum2=0;
            tmpSum3=0;
            tmpSum4=0;            
            for (var j=0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
            	tmpSum1=tmpSum1 + parseInt(sheetObj.GetCellValue(row,"w1_"+arr_tpsz[j].toLowerCase()));
            	tmpSum2=tmpSum2 + parseInt(sheetObj.GetCellValue(row,"w2_"+arr_tpsz[j].toLowerCase()));
            	tmpSum3=tmpSum3 + parseInt(sheetObj.GetCellValue(row,"w3_"+arr_tpsz[j].toLowerCase()));
            	tmpSum4=tmpSum4 + parseInt(sheetObj.GetCellValue(row,"w4_"+arr_tpsz[j].toLowerCase()));
            }
            sheetObj.SetCellValue(row,"w1_ttl",tmpSum1,0);
            sheetObj.SetCellValue(row,"w2_ttl",tmpSum2,0);
            sheetObj.SetCellValue(row,"w3_ttl",tmpSum3,0);
            sheetObj.SetCellValue(row,"w4_ttl",tmpSum4,0);
        }
    }
	function calcBalance(){
		for(var week=1; week<=7; week++){
			calcBalanceFcst(week,"d2");
			calcBalanceFcst(week,"d4");
			calcBalanceFcst(week,"d5");
			calcBalanceFcst(week,"d7");
			calcBalanceFcst(week,"r2");
			calcBalanceFcst(week,"r5");
			calcBalanceFcst(week,"r9");
			calcBalanceFcst(week,"o2");
			calcBalanceFcst(week,"s2");
			calcBalanceFcst(week,"o4");
			calcBalanceFcst(week,"s4");
			calcBalanceFcst(week,"f2");
			calcBalanceFcst(week,"a2");
			calcBalanceFcst(week,"f4");
			calcBalanceFcst(week,"a4");
			calcBalanceFcst(week,"f5");
			calcBalanceFcst(week,"o5");
		}
		for(var week=1; week<=3; week++){
            calcBalancePfmc(week,"d2");
            calcBalancePfmc(week,"d4");
            calcBalancePfmc(week,"d5");
            calcBalancePfmc(week,"d7");
            calcBalancePfmc(week,"r2");
            calcBalancePfmc(week,"r5");
            calcBalancePfmc(week,"r9");
            calcBalancePfmc(week,"o2");
            calcBalancePfmc(week,"s2");
            calcBalancePfmc(week,"o4");
            calcBalancePfmc(week,"s4");
            calcBalancePfmc(week,"f2");
            calcBalancePfmc(week,"a2");
            calcBalancePfmc(week,"f4");
            calcBalancePfmc(week,"a4");
            calcBalancePfmc(week,"f5");
            calcBalancePfmc(week,"o5");
        }
	}
	/**
     * 
     * 
     */
    function calcBalanceFcst(week,tpsz){ // week:1~7 ,tpsz:d2~,
        var sheetObj=sheetObjects[0];
		if(week < 1 || week >7 ){
			return false;
		}
		if(week!=1 && sheetObj.GetCellValue(2,"w"+week+"_f")=="Y"){
				// 앞 주의 Balance(FCST) 를 Inventory 로 함
			sheetObj.SetCellValue(2,"w"+week+"_"+tpsz,sheetObj.GetCellValue(11,"w"+(week-1)+"_"+tpsz),0);
			}
			//inventory + MG + Repo in + OW&OnHire + (+)Others - OP - Repo out
		var tmpTotal=parseInt(sheetObj.GetCellValue(2,"w"+week+"_"+tpsz)) // Inventory
		+ parseInt(sheetObj.GetCellValue(3,"w"+week+"_"+tpsz)) // MG FCST
		+ parseInt(sheetObj.GetCellValue(5,"w"+week+"_"+tpsz)) // Repo In
		+ parseInt(sheetObj.GetCellValue(6,"w"+week+"_"+tpsz)) // OW&On-Hire
		+ parseInt(sheetObj.GetCellValue(7,"w"+week+"_"+tpsz)) // +Others
		- parseInt(sheetObj.GetCellValue(8,"w"+week+"_"+tpsz)) // OP FCST
		- parseInt(sheetObj.GetCellValue(10,"w"+week+"_"+tpsz)) // Repo Out
						 ;
			sheetObj.SetCellValue(11,"w"+week+"_"+tpsz,tmpTotal);// Balance(FCST)
			if(tmpTotal < 0){ // 마이너스는 빨간색
 				sheetObj.SetCellFontColor(11,"w"+week+"_"+tpsz,"#FF0000");
			}else{ // 파란색
 				sheetObj.SetCellFontColor(11,"w"+week+"_"+tpsz,"#0000FF");
			}
	}
	function calcBalancePfmc(week,tpsz){ // week:1~3 중 과거 주차일 경우 ,tpsz:d2...,
        var sheetObj=sheetObjects[0];
        if(week < 1 || week >3 || sheetObj.GetCellValue(2,"w"+week+"_f")!="N"){
            return false;
        }
            //inventory + MG + Repo in + OW&OnHire + (+)Others - OP - Repo out
        var tmpTotal=parseInt(sheetObj.GetCellValue(2,"w"+week+"_"+tpsz)) // Inventory
        + parseInt(sheetObj.GetCellValue(4,"w"+week+"_"+tpsz)) // MG PFMC
        + parseInt(sheetObj.GetCellValue(5,"w"+week+"_"+tpsz)) // Repo In
        + parseInt(sheetObj.GetCellValue(6,"w"+week+"_"+tpsz)) // OW&On-Hire
        + parseInt(sheetObj.GetCellValue(7,"w"+week+"_"+tpsz)) // +Others
        - parseInt(sheetObj.GetCellValue(9,"w"+week+"_"+tpsz)) // OP PFMC
        - parseInt(sheetObj.GetCellValue(10,"w"+week+"_"+tpsz)) // Repo Out
                         ;
            sheetObj.SetCellValue(12,"w"+week+"_"+tpsz,tmpTotal);// Balance(PFMC)
			if(tmpTotal < 0){ // 마이너스는 빨간색
                 sheetObj.SetCellFontColor(12,"w"+week+"_"+tpsz,"#FF0000");
            }else{ // 파란색
                 sheetObj.SetCellFontColor(12,"w"+week+"_"+tpsz,"#0000FF");
            }
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnClick(sheetObj, row, col, value) {
    	var dp_seq=sheetObj.GetCellValue(row,"dp_seq");
 		if ( document.form.init_flag.value != 'INIT' || true) {
 	    	switch (sheetObj.ColSaveName(col)) {
 	    		case "w1_img" :   		
				case "w2_img" : 
				case "w3_img" : 
				case "w4_img" : 
				case "w5_img" : 
				case "w6_img" : 
				case "w7_img" :
 				    if(sheetObj.GetCellImage(row,col)=="-1" || sheetObj.GetCellImage(row,col)=="0"){ // popup 이미지 없거나, off 이면
						break;
					}
					var fcast_yrwk="";
					var inp_yrwk="";
					var repo_pln_yrwk="";
					var popSaveFlag=saveFlag ;
				    if(sheetObj.ColSaveName(col).substr(1,1) >= 4){  // 4 : Current Week ~ 미래주차를 확인
				    	fcast_yrwk=sheetObj.GetCellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
				    	inp_yrwk=sheetObj.GetCellValue(row,"w3_wk");
				    	repo_pln_yrwk=sheetObj.GetCellValue(row,"w4_wk");
				    }else{  // 과거주차 는 history 만 조회됨.
				    	fcast_yrwk=sheetObj.GetCellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
						//repo_pln_yrwk = sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
				    	repo_pln_yrwk=sheetObj.GetCellValue(row,"w4_wk");
				    	if( sheetObj.GetCellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk").substr(4,5) == '01' ){
				    		tmpWk=sheetObj.GetCellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
							inp_yrwk=doActionIBSheet(sheetObjects[1],form,SEARCH06);
						}else{
							inp_yrwk=parseInt(sheetObj.GetCellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk"))-1;
						}
						popSaveFlag="";
					}
					var searchFlag=0;
					var index=document.form.cntrTpsz.selectedIndex;
                    if ( document.form.cntrTpsz.options[index].value == "D" )      searchFlag=0; // DRY 선택
                    else if ( document.form.cntrTpsz.options[index].value == "R" ) searchFlag=1; // SPCL 선택
                    else if ( document.form.cntrTpsz.options[index].value == "O" ) searchFlag=1; // SPCL 선택
                    else if ( document.form.cntrTpsz.options[index].value == "F" ) searchFlag=1; // SPCL 선택
                    else searchFlag=2; // ALL 선택  
 	    			if ( dp_seq == 9 ) {  //repo out  		
	    				var param="loc_cd=" + document.form.loc_cd.value
				 				   +"&fcast_yrwk=" + fcast_yrwk
				 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
 	    						   +"&inp_yrwk=" + inp_yrwk
 	    						   +"&save_flag=" + popSaveFlag
 	    						   +"&f_cmd=" + SEARCH
								   +"&tpsz_flag=" + tpsztype.GetSelectText();//현재 선택된 tpsz(콤마로 구분)
 	    			 	ComOpenPopup("/opuscntr/EES_EQR_1047.do?"+ param,1000, 700, "setOwOnHireValue", "1,0,1,1,1,1,1,1", true);
 	    			}else if ( dp_seq == 4 ) {    //Repo. In 	    				
	 	    			var param="loc_cd=" + document.form.loc_cd.value
		 				   +"&fcast_yrwk=" + fcast_yrwk
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk //ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&f_cmd=" + SEARCH;
    					ComOpenPopup("/opuscntr/EES_EQR_1044.do?"+ param,1015, 705, "setOwOnHireValue", "1,0,1,1,1,1,1,1", true);
 	    			}else if ( dp_seq == 2 ) {    // MG Forecast Log 팝업 오픈
	 	    			var param="loc_cd=" + document.form.loc_cd.value
	 	    			+"&inp_yrwk=" + inp_yrwk //sheetObj.GetCellValue(row,"inp_yrwk")
	 	    			+"&fcast_yrwk=" + fcast_yrwk //ComTrimAll(sheetObj.GetCellValue(row,"yyyy_ww"), "-", "")
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk //ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&tp_cd=" + sheetObj.GetCellValue(row,"mty_bal_tp_cd")
		 				   +"&search_flag=" + searchFlag
		 				   +"&f_cmd=" + INIT ;
    					ComOpenPopup("/opuscntr/EES_EQR_1043.do?"+ param, 1015, 705, "MG/OP Forecast", "1,0,1,1,1,1,1,1", true);
 	    			}else if ( dp_seq == 7 ) {    // OP Forecast Log 팝업 오픈
	 	    			var param="loc_cd=" + document.form.loc_cd.value
	 	    			   +"&inp_yrwk=" + inp_yrwk 
	 	    			   +"&fcast_yrwk=" + fcast_yrwk // ComTrimAll(sheetObj.GetCellValue(row,"yyyy_ww"), "-", "")
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk//ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&tp_cd=" + sheetObj.GetCellValue(row,"mty_bal_tp_cd")
		 				   +"&search_flag=" + searchFlag
		 				   +"&f_cmd=" + INIT ;
 	    				ComOpenPopup("/opuscntr/EES_EQR_1043.do?"+ param, 1015, 705, "MG/OP Forecast", "1,0,1,1,1,1,1,1", true);
 	    			} else if ( dp_seq == 6 ) {  //+ Others,- Others
 	    				var repo_flag="MINUS";
 	    				if ( dp_seq == 6 ) { //+ Others
 	    					repo_flag="PLUS";
 	    				}
 	    		 		var param="loc_cd=" + document.form.loc_cd.value
				 				   +"&fcast_yrwk=" + fcast_yrwk
				 				   +"&tp_cd=" + sheetObj.GetCellValue(row,"mty_bal_tp_cd")
				 				   +"&inp_yrwk=" + inp_yrwk 
				 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
				 				   +"&save_flag=" + popSaveFlag
				 				   +"&repo_flag=" + repo_flag
								   +"&search_flag=" + searchFlag;
 	    		 		ComOpenPopup("/opuscntr/EES_EQR_1046.do?"+ param,700, 490, "", "1,0,1,1,1,1,1,1", true);
 	    			}
 	       			break;
 	    	}
     	} 
    }
	function sheet3_OnClick(sheetObj, row, col, value){
		var formObj=document.form;
		if (col == 0) {
			if (document.form.init_flag.value != "INIT") {
				if(row==6){
					refe2kind="COP";
					doActionIBSheet(sheetObj, formObj, SEARCH05);
				}else if(row>1 && row<6){
					refe2kind="BKG";
					doActionIBSheet(sheetObj, formObj, SEARCH05);
				}
			}
		}
	}
//	/**
//     * 셀에 키입력 했을때 발생하는 이벤트 <br>
//     * @param {ibsheet} sheetObj    IBSheet Object
//     * @param {ibsheet} row         sheetObj의 선택된 Row
//     * @param {ibsheet} col         sheetObj의 선택된 Col
//     **/
//     function sheet1_OnAfterEdit(sheetObj, Row, Col){
//	    if(sheetObj == sheetObjects[0]){
//            
//			if (sheetObj.ColSaveName(Col).substr(3,3) != "img") {  //image_button 아닐때
//                if ( sheetObj.CellValue(Row,Col) == '' ) {  //data format int형 널 방지
//                    sheetObj.CellValue2(Row,Col) = 0;
//                }
//            }
//			
//			if(sheetObj.CellSearchValue(Row,Col) != sheetObj.CellValue(Row,Col)){ // 값이 변경된 경우만
//			    var sName = sheetObj.ColSaveName(Col);
//	            if(parseInt(sName.substr(1,1)) > 3 && parseInt(sName.substr(1,1)) < 8){
//					sheetObj.CellValue(Row,sName.substr(0,2)+"_ef") = "Y"; // 주차별 edited 판단을 위한 flag
//	            }
//				
//				var week = sName.substr(1,1);
//				var tpsz = sName.substr(3,2);
//				
//				calcTotal(week, Row);  // 편집행 합계 재계산
//				for(var i=week; i<=7; i++){
//					calcBalanceFcst(i,tpsz); // 뒷 주차도 다시 계산
//					calcTotal(i, 2);   //Inventory
//					calcTotal(i, 11);  //Balance(FCST)
//	                calcTotal(i, 12);  //Balance(PFMC)
//				}
//			}
//	    }
//	 }
	function sheet1_OnChange(sheetObj, Row, Col, Value){ // Ctrl+V 입력 위해 OnChange 사용
		// sheet1 의 값이 변경된 경우 호출
		if (sheetObj.CellSearchValue(Row, Col) != sheetObj.GetCellValue(Row, Col) // 초기 조회시 제외
				&& sheetObj.GetCellValue(Row,"dp_seq")!=""                            // Balance 제외
			&& sheetObj.ColSaveName(Col).substr(3,3) != "img"                  // icon column 제외
			&& sheetObj.ColSaveName(Col).substr(3,3) != "ttl"                  // ttl column 제외
			&& sheetObj.ColSaveName(Col).substr(3,2) != "ef" ) {               // edit flag 제외
			if (sheetObj.ColSaveName(Col).substr(1, 1) == "4" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "5" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "6" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "7") { // 1~3 과거 주차 제외
				if ( sheetObj.GetCellValue(Row,Col) == '' ) {  //data format int형 널 방지
	                    sheetObj.SetCellValue(Row,Col,0,0);
	                }
                var sName=sheetObj.ColSaveName(Col);
                if( ( parseInt(sName.substr(1,1)) > 3 && parseInt(sName.substr(1,1)) < 8)
                		&&( sheetObj.GetCellValue(Row,"dp_seq")==2        // MG FCST
                				|| sheetObj.GetCellValue(Row,"dp_seq")==5     // OW&On-Hire
                				|| sheetObj.GetCellValue(Row,"dp_seq")==7)	){ // OP FCST
					sheetObj.SetCellValue(Row,sName.substr(0,2)+"_ef","Y");// 주차별 edited 판단을 위한 flag
	                var week=sName.substr(1,1);
	                var tpsz=sName.substr(3,2);
	                calcTotal(week, Row);  // 편집행 합계 재계산
	                for(var i=week; i<=7; i++){
	                    calcBalanceFcst(i,tpsz); // 뒷 주차도 다시 계산
	                    calcTotal(i, 2);   //Inventory
	                    calcTotal(i, 11);  //Balance(FCST)
	                    calcTotal(i, 12);  //Balance(PFMC)
	                }
				}
            }
		}
     }
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == '' ) {	//success
    		ComShowMessage(ComGetMsg("COM130102", "Data"));
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				sheetObj.SetCellValue(i,"ibflag","R");// ibflag 초기화
				sheetObj.SetCellValue(i,"w4_ef","");// edit flag 초기화
				sheetObj.SetCellValue(i,"w5_ef","");
				sheetObj.SetCellValue(i,"w6_ef","");
				sheetObj.SetCellValue(i,"w7_ef","");
			}
    	} else {	//error message 발생시 초기 데이타 세팅
    		sheetObj.LoadSearchData(mainXml,{Sync:1} );
    	}
    	sheetObj.RenderSheet(1);
    	sheetObj.SetShowMsgMode(0);
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
            comboObjects[0].SetSelectCode(consTpsz);
            break;
        case "D":
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszDry);
            break;
        case "R":
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszRfr);
            break;
        case "O":
        	comboObjects[0].SetSelectCode(-1);
            comboObjects[0].SetSelectCode(consTpszOt);
            break;
        case "F":
        	comboObjects[0].SetSelectCode(-1);
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
        if(ComGetBtnDisable(srcName)) return false;
        if (srcName == "cntrTpsz"){
            var index=document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
        }
    }
	function tpsztype_OnChange(){
		sheetObjects[0].RenderSheet(0);
		sheetObjects[1].RenderSheet(0);
		sheetObjects[2].RenderSheet(0);
		
		setGridHidden(tpsztype.GetSelectText());
		calcAllTotal();    // sheet1 TTL 재 계산
		calcTotalSheet2(); // sheet2 TTL 재 계산
		calcTotalSheet3(); // sheet3 TTL 재 계산
		sheetObjects[2].RenderSheet(1);
		sheetObjects[1].RenderSheet(1);
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
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
	    var arr_tpsz=tpsz_cd.split(",");
	    for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size	   
	        for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
	            if(consTpszArr[i] == arr_tpsz[j]){
	                sheetObj.SetColHidden("w1_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w2_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w3_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w4_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w5_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w6_"+consTpszArr[i].toLowerCase(),0);
		            sheetObj.SetColHidden("w7_"+consTpszArr[i].toLowerCase(),0);
					sheetObj2.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",0);
					sheetObj3.SetColHidden("w1_"+consTpszArr[i].toLowerCase(),0);
					sheetObj3.SetColHidden("w2_"+consTpszArr[i].toLowerCase(),0);
                    sheetObj3.SetColHidden("w3_"+consTpszArr[i].toLowerCase(),0);
                    sheetObj3.SetColHidden("w4_"+consTpszArr[i].toLowerCase(),0);
					break;
	            }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
					sheetObj.SetColHidden("w1_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w2_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w3_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w4_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w5_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w6_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj.SetColHidden("w7_"+consTpszArr[i].toLowerCase(),1);
	                sheetObj2.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",1);
                    sheetObj3.SetColHidden("w1_"+consTpszArr[i].toLowerCase(),1);
                    sheetObj3.SetColHidden("w2_"+consTpszArr[i].toLowerCase(),1);
                    sheetObj3.SetColHidden("w3_"+consTpszArr[i].toLowerCase(),1);
                    sheetObj3.SetColHidden("w4_"+consTpszArr[i].toLowerCase(),1);
				}
			}       
	    }
	}
	/**
     * 팝업에서 선택한 OW&On-hire total값 Setting.
    */
    function setOwOnHireValue(saveName,value){
		var week=sheetObjects[0].ColSaveName(sheetObjects[0].GetSelectCol()).substr(0,2);
        var realSaveName=week+"_"+saveName.substr(0,2);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),realSaveName,ComAddComma(value),0);
    }
	/* 개발자 작업  끝 */   
