/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0057.js
*@FileTitle : Cargo Handling Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.05 김종옥
* 1.0 Creation
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
     * @class VOP_OPF_0057 : VOP_OPF_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0057() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

    	var sheetObject1 = sheetObjects[0];
    	var formObject = document.form;

	   	try {
	   		var srcName = window.event.srcElement.getAttribute("name");
	   		switch(srcName) {
	   			case "btn_Retrieve":
	   				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	   				break;
	   	
	   			case "btn_New":
	   				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
	   				break;
	   				
	   			case "btn_Excel":
	   				sheetObject1.Down2Excel(-1);
	   				break;
	   				
	   			case "btn_loc_cd":	//Location 조회 팝업
	   				var loc_cd = formObject.loc_cd.value;
	   		    	var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+loc_cd;
	   				var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
	   				if(rVal){
	   					formObject.loc_cd.value = rVal;
	   					loc_cd_onchange();
	   				} 
	   				class_name();
	   				break;
	   				
	    		case "btn_slan_cd_pop":
	    			var slan_cd = formObject.slan_cd.value;
	    			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "slan_cd_pop_event", "0,0", true);
	    			class_name();
	    			break;
	    			
	   	        case "from_calendar": // From 달력버튼
	   	            var cal = new ComCalendar();
	   	            cal.select(formObject.from_date, 'yyyy-MM-dd');
	   	            break;
	
	   	        case "to_calendar": // From 달력버튼
	   	            var cal = new ComCalendar();
	   	            cal.select(formObject.to_date, 'yyyy-MM-dd');
	   	            break;
	
	   	        case "from_to_calendar": // From 달력버튼
                	var cal = new ComCalendarFromTo();
                	cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Combo Object를 배열로 등록
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
    		ComConfigSheet (sheetObjects[i] );
   			initSheet(sheetObjects[i],i+1);
   			ComEndConfigSheet(sheetObjects[i]);
        }
    	
 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }  

    	//From Date 날짜 세팅
    	set_from_date();
    	
    	initControl();
    }

    //From Date 날짜 세팅
    function set_from_date(){
    	var formObj = document.form;
    	var vNowDate = formObj.now_date.value;
    	var vlastDay = formObj.last_day.value;
    	formObj.from_date.value = ComGetDateAdd(vNowDate, "M", -1).substr(0, 8)+"01";
    	formObj.to_date.value = vlastDay.substr(0,4)+"-"+vlastDay.substr(4,2)+"-"+vlastDay.substr(6,2); 
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.id) {
			case "yd_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.BackColor = "#CCFFFD";
					InsertItem(i++,  "All",  "");
					comboObj.Text = "All";
	        	}
				break;
		}
	}
	
	/** 
     * initControl()
     */ 
	function initControl() {
 		//axon_event.addListener    ('keydown',  'ComKeyEnter', 'form');
 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
 		axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		
    	axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
    	axon_event.addListenerFormat('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_blur', form);
	}

    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     */ 
    function obj_keypress(){
        obj = event.srcElement;
        if(obj.dataformat == null) return;
        	 	
        window.defaultStatus = obj.dataformat;
        
        switch(obj.dataformat) {
            case "engup":
            	if(obj.name=="slan_cd") ComKeyOnlyAlphabet('uppernum');
                else ComKeyOnlyAlphabet('upper');
                break;
            case "engdn":
                if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
                else ComKeyOnlyAlphabet('lower');
                break;
            case "ymd":
            	ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
        }
    }
    
    /** 
     * Object 의 KeyUp 이벤트에 대한 처리  <br>
     */     
	function obj_keyup(){
		obj = event.srcElement;
		var formObj = document.form;

		switch(obj.name) {    	
			case "loc_cd":
				if( formObj.loc_cd.value.length == 5 ){
					loc_cd_onchange();
					class_name();
				}else{
					class_name_all();
				}
				break;
				
			case "slan_cd":
				if( formObj.slan_cd.value.length == 3 ){
					change_event();
					class_name();
				}else{
					class_name_all();
				}
				break;

       	}
    }
	
	function class_name(){
		var formObj = document.form;
		if(formObj.loc_cd.value == "" && formObj.slan_cd.value == ""){
			formObj.loc_cd.className = "input1";
			formObj.slan_cd.className = "input1";
		}else if(formObj.loc_cd.value == ""){
			formObj.loc_cd.className = "input";
			formObj.slan_cd.className = "input1";
		}else if(formObj.slan_cd.value == ""){
			formObj.loc_cd.className = "input1";
			formObj.slan_cd.className = "input";
		}
	}
	
	function class_name_all(){
		var formObj = document.form;
		if(formObj.loc_cd.value == "" && formObj.slan_cd.value == ""){
			formObj.loc_cd.className = "input1";
			formObj.slan_cd.className = "input1";
		}
	}
	
 	/**
 	 * Form 내의 Object OnBLur 이벤트시 처리.
 	 * 
 	 * @return void
 	 */        
     function obj_deactivate(){ 
   	     obj = event.srcElement;
         var formObj = document.form;
 		 switch(obj.name) {
             case "loc_cd":
                 if( formObj.loc_cd.value != ""){
                     if(!ComChkObjValid(obj)){       
                    	 setFocus("loc_cd");
                         return false;
                     }
                 }else{
                	 comboObjects[0].RemoveAll();  //YD_CD 콤보 초기화
                	 comboObjects[0].InsertItem(0, "All","");
                	 comboObjects[0].Text = "All";                	 
                 }
                 break;
 		 }
     } 
	
    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "from_date":
       			ComClearSeparator(event.srcElement);
       			break;
       		case "to_date":
       			ComClearSeparator(event.srcElement);
       			break;
       	}
    }
    
    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;

    	switch(obj.name) {
    		case "slan_cd":
    			if( formObj.slan_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("slan_cd");
    					return false;
    				}
    			}
    			break; 

			case "from_date":
    			if( formObj.from_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_date", "");
                    	setFocus("from_date");
                    	return false;
                    }else{
                    	if( formObj.to_date.value != ""){
                    		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
                    			ComAlertFocus(formObj.from_date, ComGetMsg("OPF50021"));
                    			setObjValue("from_date", "");
                    			return false;
                    		}
                    	}
                    }
                }
    			break;
    		case "to_date":
    			if( formObj.to_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_date", "");
                    	setFocus("to_date");
                    	return false;
                    }else{
                    	if( formObj.from_date.value != ""){
                    		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
                    			ComAlertFocus(formObj.to_date, ComGetMsg("OPF50021"));
                    			setObjValue("to_date", "");
                    			return false;
                    		}
                    	}
                    }
                }
    			break;
    	}

    }    

    //Port Code 변경 이벤트 및  YD_CD 콤보 생성
   	function loc_cd_onchange(){
   		comboObjects[0].RemoveAll();  //YD_CD 콤보 초기화

   		var formObj = document.form;
   		formObj.f_cmd.value = SEARCH01;
   		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_0057GS.do", FormQueryString(formObj));

		if(ComGetTotalRows(sRhqXml) == 0){
			ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "Data"));
			setObjValue("loc_cd", "");
			setFocus("loc_cd");			
		}else{
			comboObjects[0].DropHeight=200;
			ComXml2ComboItem(sRhqXml, comboObjects[0], "yd_cd", "yd_cd|yd_nm");
		}
		comboObjects[0].InsertItem(0, "All","");
		comboObjects[0].Text = "All";
		
		if(formObj.loc_cd.value == ""){
			comboObjects[0].RemoveAll();  //YD_CD 콤보 초기화
   			comboObjects[0].InsertItem(0, "All","");
   			comboObjects[0].Text = "All";
		}
   	}
   	
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[1];
    	var gubun = "";

    	if(!isNull(elementObj.value)){
    		// Object의 Length Check..
	    	if(elementObj.maxLength != elementObj.value.length){
	    		ComShowCodeMessage("OPF50007",elementObj.caption,elementObj.maxLength);
	    		elementObj.focus();
	    		return false;
	    	}

    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun = "slanCd";
        	}
    		
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }   	
   	
    /**
     * slan_cd Data PopUp Value 입력 함수.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value = aryPopupData[0][1];
    }
   	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;
   		switch(sheetID) {

   			case "sheet1":
   				with (sheetObj) {
    										// 높이 설정
   					style.height = 440;
   					//전체 너비 설정
   					SheetWidth = mainTable.clientWidth;
   					
   					//Host정보 설정[필수][HostIp, Port, PagePath]
   					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
   					
   					//전체Merge 종류 [선택, Default msNone]
   					MergeSheet = msPrevColumnMerge + msHeaderOnly;
   					
   					//전체Edit 허용 여부 [선택, Default false]
   					Editable = false;
   					
   					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
   					InitRowInfo(3, 1, 3, 100);

   					var HeadTitle1 = "|Port|Lane|VVD CD|CGO OPR|Discharged|Discharged|Discharged|Discharged|Discharged|Discharged|Discharged|Discharged|Discharged|Discharged|Loaded|Loaded|Loaded|Loaded|Loaded|Loaded|Loaded|Loaded|Loaded|Loaded|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Weight|Weight|Weight|Weight|Weight";
   					var HeadTitle2 = "|Port|Lane|VVD CD|CGO OPR|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty|20|20HC|40|40HC|45";
   					var HeadTitle3 = "|Port|Lane|VVD CD|CGO OPR|20|20HC|40|40HC|45|20|20HC|40|40HC|45|20|20HC|40|40HC|45|20|20HC|40|40HC|45|20|20HC|40|40HC|45|20|20HC|40|40HC|45|20|20HC|40|40HC|45";
   					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);
                    
                    HeadRowHeight = 10;
                    
                    var rowCnt = 0;
                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(rowCnt,cnt++ , dtHiddenStatus,	40,	daCenter,	true,		prefix+"ibflag");
   					InitDataProperty(rowCnt,cnt++,	dtData,		72,		daCenter,	true,		prefix+"port",			false,		"",	dfNone,		0,	true,		true);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daCenter,	true,		prefix+"lane",			false,		"",	dfNone,		0,	true,		true);
   					InitDataProperty(rowCnt,cnt++,	dtData,		70,		daCenter,	true,		prefix+"vvd",			false,		"",	dfNone,		0,	true,		true);
   					InitDataProperty(rowCnt,cnt++,	dtData,		60,		daCenter,	true,		prefix+"opr",			false,		"",	dfNone,		0,	true,		true);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_fl_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_fl_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_fl_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_fl_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_fl_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_et_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_et_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_et_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_et_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ds_et_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_fl_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_fl_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_fl_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_fl_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_fl_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_et_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_et_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_et_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_et_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"ld_et_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_fl_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_fl_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_fl_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_fl_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_fl_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_et_20",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_et_2h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_et_40",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_et_4h",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	false,		prefix+"tl_et_45",		false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	true,		prefix+"wt_20",			false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	true,		prefix+"wt_2h",			false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	true,		prefix+"wt_40",			false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	true,		prefix+"wt_4h",			false,		"",	dfInteger,	0,	true,		true, -1, false, false);
   					InitDataProperty(rowCnt,cnt++,	dtData,		50,		daRight,	true,		prefix+"wt_45",			false,		"",	dfInteger,	0,	true,		true, -1, false, false);

   					//CountPosition = 0;
   				}
   				break;
   		}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
		        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0057GS.do", sParam);
					if(sXml.length>0){ 
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;
	
			case IBCLEAR:
				setObjValue("loc_cd", "");
				comboObjects[0].RemoveAll();
        		initCombo(comboObjects[0], 1);
				setObjValue("slan_cd", ""); 
				set_from_date();
				formObj.opr_cd[0].checked = true;
				formObj.option_cd[0].checked = true;
				sheetObj.RemoveAll();
				break;				
				
			case IBROWSEARCH:	
				if(gubun=="slanCd"){
					//formObj.f_cmd.value = SEARCH02;
					//var lanXml = sheetObjects[1].GetSearchXml("VOP_VSK_0202GS.do?op=0202&vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
					formObj.f_cmd.value = COMMAND12;
					var lanXml = sheetObjects[1].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
					var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
		    		  
					if(isNull(strLanCdDesc)){
						ComShowCodeMessage("OPF50004", "Data");
						setObjValue("slan_cd", "");
						setFocus("slan_cd");
	
						return false;
					}
				}
				break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	
 			if(!isNull(formObj.loc_cd.value)){
				if( formObj.loc_cd.value.length != 5 ){
					setFocus("loc_cd");
					return false;
				}
 			}
			
 			if(!isNull(formObj.slan_cd.value)){
				if( formObj.slan_cd.value.length != 3 ){
					setFocus("slan_cd");
					return false;
				}
 			}
 			
			if(ComIsEmpty(formObj.loc_cd.value) && ComIsEmpty(formObj.slan_cd.value)){
				ComShowCodeMessage("OPF50009", "Port or Lane");
				ComAlertFocus(formObj.loc_cd, "");
				return false;
	      	}else if(isNull(formObj.from_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.from_date.focus();
				return false;
	      	}else if(isNull(formObj.to_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.to_date.focus();
				return false;
	      	}
        }

        return true;
    }

    // [t1sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			/**
			var color1 = RgbColor(229, 234, 255);		// 하늘색?
			var color2 = RgbColor(247, 225, 236);		// 분홍색
			var color3 = RgbColor(108, 194, 213);		// 연한파랑색
			var color4 = RgbColor(235, 124, 152);		// 연한빨강색
			**/			
			//sheetObj.ColBackColor(1) = sheetObj.RgbColor(232, 231, 236);
			
 			//Sub Total RGB 설정
 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 				if(sheetObj.CellValue(i, "sheet1_opr") == "S.Total"){
 					sheetObj.CellFont("FontBold", i,"sheet1_opr") = true;
 					for(var j=4 ; j<=39 ; j++){
 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(232, 231, 236);
 					}
 				}
 			 	
 				if(sheetObj.CellValue(i, "sheet1_lane") == "Total"){
 					sheetObj.CellFont("FontBold", i,"sheet1_lane") = true;
 					for(var j=2 ; j<=39 ; j++){
 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 					}
 				}
 				
 				if(sheetObj.CellValue(i, "sheet1_port") == "G.Total"){
 					sheetObj.CellFont("FontBold", i,"sheet1_port") = true;
 					for(var j=1 ; j<=39 ; j++){
 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 					}
 				} 				
 			}
 			
 			//Grand Total RGB 설정
 			var allRowCount = sheetObj.LastRow;
			for(var j=1 ; j<=39 ; j++){
				sheetObj.CellFont("FontBold", allRowCount, j) = true;
				sheetObj.CellBackColor(allRowCount, j) = sheetObj.RgbColor(247, 225, 236);
			}
		}    	
    }
    
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    	eval("document.form."+name).select();
    }    
    
    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }    
