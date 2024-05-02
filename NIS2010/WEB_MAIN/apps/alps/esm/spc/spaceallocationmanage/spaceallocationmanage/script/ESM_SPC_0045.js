/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0045.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.24 한상훈
* 1.0 Creation
* Revision History
* 2011.05.03 [CHM-201110568] 이석준
* 			 initControl 생성,axon_event 추가
*            VVD Input 입력시 관련 conditiojn data 일괄 셋팅  
* 2011.08.11 [CHM-201112741-01] Control by HO/RHQ 화면 보완 - [Down Excel]버튼 클릭시 해당탭의 내용이 다운되도록 변경, 이전은 첫번째 시트만 됨.
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
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
     * @class ESM_SPC_0045 : ESM_SPC_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0045() {
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
    
    // 공통전역변수
    var sheetObjects = new Array();
    var comObjects   = new Array();
    var sheetCnt   = 0;
    var comboCnt   = 0;
    var tabObjects = new Array();
    var tabCnt     = 0 ;
    var beforetab  = 0;
    //조회해서 나온 vvd값
    var ret_vvd;
    //조회해서 나온 relation vvd값
    var ret_minvvd;
    var ret_maxvvd;
    //조회해서 나오 relation의 Array값
    var minArr = new Array();
    var maxArr = new Array();
    //vvd를 조회했는지 체크
    var ret_check = false;

    // vvd input에 의해서 event가 발생했는지 여부 check
    var in_vvd_chk = false;
    //sheetResizeFull = true;
    var sheetResizeCount = 2;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = ''; 
    var init_week = ''; 

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject  = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	/*******************************************************/
    	var formObject = document.form;
    	
    	//try {
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
    				formObject.vvd.options.value = "";

					formObject.year1.value = init_year;
		    		formObject.week1.value = init_week;
		    		SpcSearchOptionWeek("week1",false,document.form.year1.value);
    				break;
    			
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    		} // end switch
    	//} catch(e) {
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
    	SpcSearchOptionYear("year1");
    	SpcSearchOptionWeek("week1");
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound",false,true,false);
    	var tdisp = false;
    	
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
    		if(i > 0){
    			tdisp = tabLayer[i-1].style.display;
    			tabLayer[i-1].style.display = "block";
    		}
    		initSheet(sheetObjects[i],i+1);
    		if(i > 0){
    			tabLayer[i-1].style.display = tdisp;
    		}
    		
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
    	var sheetResizeFull = true;
    	document_onresize();
    	
    	for(k=0;k<tabObjects.length;k++){
    		initTab(tabObjects[k],k+1);
    	}
    	
    	// 탭관련 설정
    	if(document.getElementById("lane").Enable == false) document.getElementById("lane").tabIndex = 1;
    	// focus설정
    	document.form.year1.focus();
    	
    	/*
    	if(!isDevMode){
    		document.form.year1.value = "2007";
    		document.form.week1.value = "25";
    		document.form.bound.value = "W";
    		comObjects[0].Code="AUSIA";
    	}
    	*/
		init_year = document.form.year1.value;	//년 초기화용
		init_week = document.form.week1.value;	//주차 초기화용    
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
    				style.height = getSheetHeight(19);
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge;
    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = false;
    				FocusEditMode = default_edit_mode;
    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 9, 100);
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(10, 0, 0, true);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false)
    				var HeadTitle1 = "Port|BSA|IOC|Load|Discharge|Onboard|Loadable|";
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				
    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "port"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daRight ,  true ,     "bsa"            ,     false,         "",   dfInteger,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "ioc"            ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "lod_cur_teu_qty",     false,         "",   dfInteger,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "dis_teu_cur_qty",     false,         "",   dfInteger,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "teu_onboard"    ,     false,         "",   dfInteger,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "loadable"       ,     false,         "|bsa|-|teu_onboard|-|on_hc_ttl|",   dfInteger,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtHidden,  90,   daRight ,  false,     "on_hc_ttl"       ,     false,         "",   dfFloat,      0,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtHidden,  45,   daRight ,  true ,     "src_knd"        ,     false,         "",   dfNone   ,      0,     true,       true,          30);
    				InitDataProperty(0, cnt++ , dtData  ,   1,   daLeft  ,  false,     ""               ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
    				HeadRowHeight = 20 ;
    				
    				InitTreeInfo("src_knd", "sLevel", RgbColor(0,0,255), false);
    				CountPosition = 0;
    			}
    			break;
    		
    		case 2:      //sheet1 init
    			with (sheetObj) {
    				// 높이 설정
    				//style.height = 320;
    				style.height = getSheetHeight(19);
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge;
    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = false;
    				FocusEditMode = default_edit_mode;
    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 9, 100);
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(9, 0, 0, true);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false)
    				var HeadTitle1 = "Port|BSA|IOC|Load|Discharge|Onboard|Loadable";
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				
    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "port"           ,     false,         "",   dfNone   ,      0,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daRight ,  true ,     "bsa"            ,     false,         "",   dfInteger,      0,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "ioc"            ,     false,         "",   dfNone   ,      0,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "lod_cur_teu_qty",     false,         "",   dfFloat  ,      1,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "dis_teu_cur_qty",     false,         "",   dfFloat  ,      1,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "teu_onboard"    ,     false,         "",   dfFloat  ,      1,     true,       true,        30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtData  ,  90,   daRight ,  false,     "loadable"       ,     false,         "|bsa|-|teu_onboard|",   dfFloat,      1,     true,       true,          30, 	false, 		false);
    				InitDataProperty(0, cnt++ , dtHidden,  45,   daRight ,  true ,     "src_knd"        ,     false,         "",   dfNone   ,      0,     true,       true,        30);
    				InitDataProperty(0, cnt++ , dtData,     1,   daLeft  ,  false,     ""               ,     false,         "",   dfNone   ,      0,     true,       true,        30, 	false, 		false);
    				HeadRowHeight = 20 ;
    				
    				InitTreeInfo("src_knd", "sLevel", RgbColor(0,0,255), false);
    				CountPosition = 0;
    			}
    			break;
    	}
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(checkModifiedSheet(sheetObj)) {
    				// 두개 이상의 Sheet를 동시에 체크해야 하여 하나라도 수정된 Sheet가 존재하는 경우를 체크하고자 하는경우 사용
    				if(ComShowConfirm (getMsg("SPC90001")) != 1){
    					return;
    				}
    			}
    			
    			if(!validateForm1(sheetObj,formObj, sAction)){
    				return false;
    			}
    			
    			var sheetObj  = sheetObjects[0];
    			var sheetObj1 = sheetObjects[1];
    			formObj.f_cmd.value = SEARCHLIST02;
    			ret_check = true;
    			
    			var param = SpcFormString(formObj,"f_cmd,lane,vvd,void_flg");
    			
    			//var datas = sheetObjects[beforetab].GetSearchXml("ESM_SPC_0045GS.do", FormQueryString(formObj));
    			var datas = sheetObjects[beforetab].GetSearchXml("ESM_SPC_0045GS.do", param);
    			var xmls  = datas.split("[+]");
    			
    			for(var i = 0 ; i < xmls.length ; i++) {
    				sheetObjects[i].LoadSearchXml(xmls[i]);
    			}
    			
    			var val = "";
    			for(var i=0;i<formObj.dataSelect.length;i++) {
    				if(formObj.dataSelect[i].checked) {
    					if(i==0)val = "F";
    					else if(j==1) val = "B";
    					else if(j==2) val = "V";
    					else if(j==3) val = "A";
    					else if(j==4) val = "W";
    					else if(j==5) val = "M";
    				}
    			}
    			changeSelecteData(sheetObj, val);
    			
    			for(var j=0;j<formObj.dataSelect1.length;j++) {
    				if(formObj.dataSelect1[j].checked) {
    					if(j==0)val = "F";
    					else if(j==1) val = "B";
    					else if(j==2) val = "V";
    					else if(j==3) val = "A";
    					else if(j==4) val = "W";
    					else if(j==5) val = "M";
    				}
    			}
    			changeSelecteData1(sheetObj1, val);
    			break;
    		
    		case IBDOWNEXCEL:        //엑셀 다운로드
				var sheetObj  = sheetObjects[0];
				var sheetObj1 = sheetObjects[1];
				
    			if(beforetab == 0)
    				sheetObj.SpeedDown2Excel(-1);
    			else if(beforetab == 1){
    				sheetObj1.SpeedDown2Excel(-1);
    			}
    			break;
    	}
    }
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
    	tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt  = 0 ;
    				InsertTab( cnt++ , "By Teu"     , -1 );
    				InsertTab( cnt++ , "By Weight " , -1 );
    			}
    			break;
    	}
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
    	var objs = document.all.item("tabLayer");
    	for(var i = 0 ; i < objs.length ; i++) {
    		objs[i].style.display = "none";
    	}
    	objs[nItem].style.display = "Inline";
    	beforetab = nItem;
    }
    
    function getEtcDataFromXml(xml, str){
    	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
    	pos = xml.indexOf(">", pos + 1);
    	if(pos < 0) return "";
    	var epos = xml.indexOf("</ETC>", pos + 1);
    	var rtn = "";
    	if(epos < 0){
    		rtn = xml.substring(pos + 1);
    	} else {
    		rtn = xml.substring(pos + 1, epos);
    	}
    	log("rtn : " + rtn);
    	return rtn;
    }
    
    // lane값 변동시 vvd가져오기
    function lane_OnChange(){ 
//    	if (in_vvd_chk !=true) in_vvd_chk = false; // in_vvd에서 넘어온 event에 대해서는 그대로 true로 check를 반환하기 위함.
    	getVVD("");
    }
    
    /*
     * vvd가져오기
     */
    function getVVD(vvd){
    	var rtn;
    	var ret_vvd;
    	var ret_minvvd;
    	var ret_maxvvd;
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	var year1    = formObj.year1.value;
    	var week1    = formObj.year1.value;
    	var lane     = formObj.lane.Code;
    	var bound    = formObj.bound.value;
    	formObj.f_cmd.value  = SEARCHLIST01;
    	formObj.re_vvd.value = "";
    	
    	for(var i=0; i<formObj.vvd.length; i++){
    		formObj.vvd.options[i]= new Option("", "");
    	}
    	if(year1 != "" && week1 != "" && lane != "" && bound != ""){
    		var param = SpcFormString(formObj,"f_cmd,year1,week1,lane,bound");
    		//rtn = sheetObj.GetSearchXml("ESM_SPC_0045GS.do", FormQueryString(formObj));
    		rtn = sheetObj.GetSearchXml("ESM_SPC_0045GS.do", param);
    		ret_vvd    = getEtcDataFromXml(rtn, "vvd");
    		ret_relvvd = getEtcDataFromXml(rtn, "relvvd");  
    		setVVD(formObj, sheetObj, ret_vvd, ret_relvvd, vvd);
    	}
    	if (in_vvd_chk == false) { // VVD Input이외의 evnet에서 이 function을 태웠으면 VVD Input의 field을 공백 처리
    		formObj.in_vvd.value = "";
    	}
    	in_vvd_chk = false; // 초기화
    }
    
    function changeVVD(){
    	var formObj = document.form;
    	var vvd_index = formObj.vvd.options.selectedIndex;
    	var vvd = formObj.vvd.options[vvd_index].relVVD;
    	if(vvd != undefined){
    		formObj.re_vvd.value = vvd;
    	}
//    	formObj.in_vvd.value = "";
    	
    }
    
    /*
     * vvd, relation vvd setting
     */
    function setVVD(formObj, sheetObj, strVvd, strRelvvd){
    	var vvdArr = strVvd.split("|");
    	var relArr = strRelvvd.split("|");
    	var vvd_index = formObj.vvd.options.selectedIndex;
    	
    	// select vvd option 기존데이터 삭제
    	for (var i = 0; i < formObj.vvd.length; i++){
    		formObj.vvd.remove(i);
    	}
    	
    	// select vvd option 새로 생성
    	for(var j=0; j< vvdArr.length; j++){
    		formObj.vvd.options[j]= new Option(vvdArr[j], vvdArr[j]);
    		formObj.vvd.options[j].relVVD = relArr[j];
    	}
    	formObj.re_vvd.value = relArr[0];
    	
    	// vvd에 포커스 주기
    	document.form.vvd.focus();
    }
    
    function sheet1_OnSearchEnd(sheetObj , ErrMsg){
    	if(ErrMsg == ""){
    		for(var i = 1 ; i < sheetObjects.length ; i++){
    			sheetObjects[i].RemoveAll();
    		}
    	}
    }
    
    /*
     * 체크박스 선택시 fcast,bkg,allocation row을 보여줄지 여부
     */
    function changeTitle2(){
    	var sheetObj = sheetObjects[0];
    	var val = event.srcElement.value;
    	changeSelecteData(sheetObj, val);
    }
    
    function changeSelecteData(sheetObj, val){
    	var formObj = document.form;
    	var sel     = formObj.dataSelect;
    	var frow    = -1;
    	var show    = false;
    	
    	for(var i = 0 ; i < sel.length ; i++){
    		if(val != "" && val != sel[i].value){
    			sel[i].checked = false;
    		}
    		frow = sheetObj.FindText("src_knd", sel[i].value);
    		show = sel[i].checked;
    		sheetObj.RowHidden(frow)   = !show;
    		sheetObj.RowExpanded(frow) = show;
    	}
    }
    
    function changeTitle1(){
    	var sheetObj1 = sheetObjects[1];
    	var val = event.srcElement.value;
    	changeSelecteData1(sheetObj1, val);
    }
    
    function changeSelecteData1(sheetObj1, val){
    	var formObj = document.form;
    	var sel     = formObj.dataSelect1;
    	var frow    = -1;
    	var show    = false;
    	
    	for(var i = 0 ; i < sel.length ; i++){
    		if(val != "" && val != sel[i].value){
    			sel[i].checked = false;
    		}
    		frow = sheetObj1.FindText("src_knd", sel[i].value);
    		show = sel[i].checked;
    		sheetObj1.RowHidden(frow)   = !show;
    		sheetObj1.RowExpanded(frow) = show;
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm1(sheetObj,formObj){
    	with(formObj){
    		var lane_value   = comObjects[0].Code;
    		var bound_value  = formObj.bound.value;
    		var re_vvd_value = formObj.re_vvd.value;
    		var vvd_value    = formObj.vvd.options.value;
    		
    		if(lane_value == ""){
    			ComShowMessage(getMsg("SPC90114", "Lane"));
    			comObjects[0].Code = "";
    			//lane combo에 대한 Focus가 잡히지 않아서 강제로 적용함
    			formObj.year1.focus();
    			comObjects[0].focus();
    			//formObj.lane.focus();
    			return false;
    		}
    		
    		if(bound_value == ""){
    			ComShowMessage(getMsg("SPC90114", "Bound"));
    			formObj.bound.focus();
    			return false;
    		}
    		
    		if(vvd_value == ""){
    			ComShowCodeMessage("COM12174", "VVD", "9");
    			formObj.vvd.focus();
    			return false;
    		}
    		
    		//if(re_vvd==""){
    		//	ComShowMessage(getMsg("SPC90114","Relation VVD"));
    		//	formObj.re_vvd.focus();
    		//	return false;
    		//}
    	}
    	return true;
    }

	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 이석준
	 * @version 2011.05.03
	 */
	function initControl() {
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
//		axon_event.addListenerFormat ('focus',    'obj_activate', formObj);
//		axon_event.addListenerForm   ('keyup',    'obj_keyup',    formObj);
//		axon_event.addListenerForm   ('blur',     'obj_deactivate', formObj);
		axon_event.addListenerForm   ('change',   'obj_change',formObj);
	}   
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 이석준
	 * @version 2010.12.02
	 */
	function obj_keypress() {
		var formObj = document.form;
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".-"); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement,"-"); 
			break;
			case "engup":
				switch(event.srcElement.name){
					case "in_vvd":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
//					case "cust_cnt_cd":	
//						//영문대문자만입력하기		    	        
//						ComKeyOnlyAlphabet('upper'); 
//					break;
				}
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}	
    
	/** 
	 * 업무 자바스크립트 OnChange 이벤트 처리<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 이석준
	 * @version 2009.04.27
	 */
	function obj_change() {
		
		var sheetObject = sheetObjects[0];
		var formObj = document.form;	
        switch(event.srcElement.name){
       
            case "in_vvd":  
            	in_vvd_chk = true;
            	var rtn = getVVDInfo(formObj.in_vvd.value);

            	var tmp_vvd        = getEtcDataFromXml(rtn, "vvd").split("|");
            	var tmp_cost_yrwk  = getEtcDataFromXml(rtn, "costYrwk").split("|");
            	var tmp_rlane_cd   = getEtcDataFromXml(rtn, "rlaneCd").split("|");
            	
            	
            	if (tmp_vvd[0] == "") {
            		ComShowMessage(getMsg("SPC90199", "VVD Input"));
            		formObj.in_vvd.value ="";
            		formObj.in_vvd.focus();
            		return;
            	} else {
	            	formObj.year1.value = tmp_cost_yrwk[0].substring(0,4);
	            	formObj.week1.value = tmp_cost_yrwk[0].substring(4,6);	            	
	            	formObj.lane.Code   = tmp_rlane_cd[0];
	            	formObj.bound.value = tmp_vvd[0].substring(8);
	            	in_vvd_chk = true; // lane값이 변해서 get vvd를 타기때문에 초기화된 in_vvd_chk를 다시 in_vvd에서 호출된것으로 바꾸어줌
	            	getVVD(tmp_vvd[0]); // VVD Input의 event때문에 호출하였음.
            	}
           	break;
            case "year1":
            	in_vvd_chk = false;
            	getVVD('');
            break;
            case "week1":
            	in_vvd_chk = false;
            	getVVD("week1",'');
            break;
            case "bound":
            	in_vvd_chk = false;
            	getVVD("bound",'');
            break;
            case "vvd":
            	in_vvd_chk = false;
            	changeVVD(formObj.vvd.value);
            break;
        }	    
	}
	
    /*
     * vvd가져오기
     */
    function getVVDInfo(vvd){
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value  = SEARCHLIST03;
        var in_vvd = vvd;
    	var param = SpcFormString(formObj,"f_cmd,in_vvd");
    		
    	//rtn = sheetObj.GetSearchXml("ESM_SPC_0045GS.do", FormQueryString(formObj));
    	rtn = sheetObj.GetSearchXml("ESM_SPC_0045GS.do", param);
    	return rtn;
    }	
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week1",false,document.form.year1.value);
    	
    }
    
    function setVoidFlg(){
    	if(document.form.f_void_flg.checked){
    		document.form.void_flg.value = "Y";
    	}else{
    		document.form.void_flg.value = "N";
    	}
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
	/* 개발자 작업  끝 */