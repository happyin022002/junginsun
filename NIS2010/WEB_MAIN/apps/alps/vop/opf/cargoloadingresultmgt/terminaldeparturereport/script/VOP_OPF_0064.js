/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0064.js
*@FileTitle : VSL Condition Statistics
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.24 김종옥
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
     * @class VOP_OPF_0064 : VOP_OPF_0064 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0064() {
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
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1  = sheetObjects[0];   
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

				case "btn_Retrieve":
	   		    	if(!ComChkValid(formObject)){
	   		    		return false;
	   		    	}					
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
					var rVal = ComOpenPopupWithTarget(sUrl, 425, 520, "", "0,0", true);
					if(rVal){
						formObject.loc_cd.value = rVal;
						loc_cd_onchange();
					} 
					break;
					
	            case "vsl_cd_pop":
	            	var vsl_cd = formObject.vsl_cd.value;
	            	ComOpenPopup("VOP_VSK_0219.do?vsl_cd="+vsl_cd, 460, 500, "event_vsl_cd_pop", "0,0", true);
	            	break;					
					
				case "btn_slan_cd_pop":
					var slan_cd = formObject.slan_cd.value;
					ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "slan_cd_pop_event", "0,0", true);
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
				    
				case "rh_reason":
					var rhReasonFlg = false;
					if(document.form.rh_reason.checked)
						rhReasonFlg = false;
					else
						rhReasonFlg = true;
					
					//sheetObject1.Redraw = false;
					for (i=0; i<=sheetObject1.LastCol; i++) {
						if (sheetObject1.CellValue(0,i).indexOf("R/H Reason") >= 0) sheetObject1.ColHidden(i) = rhReasonFlg;
					}
					//sheetObject1.Redraw = true;
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
                if(obj.name=="slan_cd" || obj.name=="vsl_cd") {
                	ComKeyOnlyAlphabet('uppernum');
                } else {
                	ComKeyOnlyAlphabet('upper');
                }
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
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     */ 
    function obj_keyup(){
		obj = event.srcElement;
		var formObj = document.form;
 
		switch(obj.name) {    	

			case "slan_cd":
				if( formObj.slan_cd.value.length == 3 ){
					change_event();
				}
				break;

			case "vsl_cd":
				if( formObj.vsl_cd.value.length == 4 ){
					change_event();
				}
				break;
				
			case "loc_cd":
				if( formObj.loc_cd.value.length == 5 ){
					loc_cd_onchange();
				}
				break;				
				
		}	
    }
    
 	/**
 	 * Form 내의 Object Deactivate 이벤트시 처리.
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
				
    		case "slan_cd":
    			if( formObj.slan_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("slan_cd");
    					return false;
    				}
    			}
    			break;
    			
    		case "vsl_cd":
    			if( formObj.vsl_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("vsl_cd");
    					return false;
    				}
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
        	}else if(elementObj.name=="vsl_cd"){
    			gubun = "vslCd";
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
     * vsl_cd Data PopUp Value 입력 함수.
     */
    function event_vsl_cd_pop(aryPopupData) {
    	document.form.vsl_cd.value = aryPopupData[0][1];
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
                     //MergeSheet = msHeaderOnly;
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(3, 1, 3, 100);

                     var HeadTitle1 = "|Lane|VVD|Port|ATA|ATB|ATD|Draft|Draft|Draft|Draft|Ballast|Ballast|Stability|Stability|";
					 HeadTitle1 += "Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker Supply\nIn Port|Bunker Supply\nIn Port|Bunker Supply\nIn Port|Bunker Supply\nIn Port|";
					 HeadTitle1 += "Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|";
					 HeadTitle1 += "Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port";
					
					 var HeadTitle2 = "|Lane|VVD|Port|ATA|ATB|ATD|Arrival|Arrival|Departure|Departure|Arr|Dept|Arr|Dept|";
					 HeadTitle2 += "Arrival|Arrival|Arrival|Arrival|Departure|Departure|Departure|Departure|";
					 HeadTitle2 += "F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO";
					
					 var HeadTitle3 = "|Lane|VVD|Port|ATA|ATB|ATD|AFT|FWD|AFT|FWD|Arr|Dept|Arr|Dept|";
					 HeadTitle3 += "F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO";
															
					 var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true); 
                     InitHeadRow(2, HeadTitle3, true);
                     
                     var prefix="sheet1_";                                         
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                     InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"lane",   	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix+"vvd",    	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"port",    	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix+"eta",    	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix+"etb",    	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix+"etd",    	false,		"",	dfNone,		0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"ada",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"adf",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"dda",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"ddf",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"ba",     	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bd",     	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"sa",     	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"sd",     	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"afo",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"ado",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"alsfo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"alsdo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"dfo",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"ddo",    	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"dlsfo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"dlsdo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bsfo",   	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bsdo",   	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bslsfo", 	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bslsdo", 	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcfo",   	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcdo",   	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bclsfo", 	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bclsdo", 	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcdfo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcddo",  	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcdlsfo",	false,		"",	dfInteger,	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		prefix+"bcdlsdo",	false,		"",	dfInteger,	0,		true,		true);

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
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0064GS.do", sParam);
					if(sXml.length>0){ 
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;
	
			case IBCLEAR:
				setObjValue("loc_cd", "");
				comboObjects[0].RemoveAll();
				initCombo(comboObjects[0], 1);
				setObjValue("vsl_cd", "");
				setObjValue("slan_cd", ""); 
				set_from_date();
				sheetObj.RemoveAll();
				break;				
				
			case IBROWSEARCH:	
				if(gubun=="slanCd"){
					formObj.f_cmd.value = COMMAND12;
					var lanXml = sheetObjects[1].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
					var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
		    		  
					if(isNull(strLanCdDesc)){
						ComShowCodeMessage("OPF50004", "Data");
						setObjValue("slan_cd", "");
						setFocus("slan_cd");
	
						return false;
					}
				}else if(gubun=="vslCd"){
					formObj.f_cmd.value = COMMAND16;
					var vslXml = sheetObj.GetSearchXml("VOP_VSK_0219GS.do?vsl_cd="+formObj.vsl_cd.value , FormQueryString(formObj));
					var strVslCd = ComGetEtcData(vslXml, "vsl_eng_nm");
  
					if(isNull(strVslCd)){
						ComShowCodeMessage("OPF50004", "Data");
	 					setObjValue("vsl_cd", "");
	 					setFocus("vsl_cd");		    			  
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
			if(isNull(formObj.slan_cd.value)){
				ComShowCodeMessage("OPF50009", "Lane");
				formObj.slan_cd.focus();
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

	/* 개발자 작업  끝 */