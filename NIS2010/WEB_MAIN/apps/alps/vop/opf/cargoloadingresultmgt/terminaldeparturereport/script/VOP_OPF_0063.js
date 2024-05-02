/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0063.js
*@FileTitle : Terminal Performance Port / Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.21 김종옥
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
     * @class VOP_OPF_0063 : VOP_OPF_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0063() {
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
    var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 

	var page_no = 1;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObject1 = sheetObjects[0];
        //var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

       try {
	   		var srcName = window.event.srcElement.getAttribute("name");
	   		switch(srcName) {
   				case "radio_carr_cd":
  					if(formObject.radio_carr_cd[0].checked){
  						if (formObject.carr_cd.value != "SML"){
  							sheetObjects[0].RemoveAll();
  						}
  						formObject.carr_cd.value = "SML";
   					}else if(formObject.radio_carr_cd[1].checked){
  						if (formObject.carr_cd.value != "O"){
  							sheetObjects[0].RemoveAll();
  						}
   						formObject.carr_cd.value = "O";
   					}else if(formObject.radio_carr_cd[2].checked){
  						if (formObject.carr_cd.value != ""){
  							sheetObjects[0].RemoveAll();
  						}
   						formObject.carr_cd.value = "";
   					}
  					break;
   				
	   			case "btn_Retrieve":
	   				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	   				break;
	   	
	   			case "btn_next":
	   				doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
	   				break;

	   			case "btn_New":
	   				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
	   				break;
	   				
	   			case "btn_Excel":
	   				sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "Port");
	   				//sheetObject2.Down2Excel(-1,true,true,true,"","",false,false, "Lane");
	   				break;
	   				
	   			case "btn_loc_cd":	//Location 조회 팝업
	   				var loc_cd = formObject.loc_cd.value;
	   		    	var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+loc_cd;
	   				var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
	   				if(rVal){
	   					formObject.loc_cd.value = rVal;
	   					loc_cd_onchange();
	   				} 
	   				break;
	   				
	    		case "btn_slan_cd_pop":
	    			var slan_cd = formObject.slan_cd.value;
	    			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "slan_cd_pop_event", "0,0", true);
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
//		for(k=0;k<tabObjects.length;k++){
//	    	initTab(tabObjects[k],k+1);
//    	}

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
    	
    	document.form.pagerows.value = "2000";
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
   	    	case "rhq":
	   			with (comboObj) {
	   				MultiSelect = false;
	   				UseAutoComplete = false;
	   				SetColAlign("left");
	   				SetColWidth("30");
	   				DropHeight = 160;
	   				ValidChar(2, 0);// 영문대문자만 입력가능
	   				MaxLength = 5;
	   				var i = 0;
	   				InsertItem(i++, "All", " ");
	   				InsertItem(i++, "HAMRU", "HAMRU");
	   				InsertItem(i++, "NYCRA", "NYCRA");
	   				InsertItem(i++, "SELIB", "SELIB");
	   				InsertItem(i++, "TYOIB", "TYOIB");
	   				InsertItem(i++, "SHARC", "SHARC");
	   				InsertItem(i++, "SINRS", "SINRS");
	   				InsertItem(i++,  "VVOIA", 	"VVOIA");
	   			}
   			// Login Office 의 RHQ가 있으면 그것으로 하고 아니면 첫번째 RHQ를 default로 한다.
   			var dfltInx = comboObj.FindIndex(rhqOfcCd, 0);
   			comboObj.Text2 = (dfltInx == "-1"?"All":dfltInx);
   			break;
   	    
			case "yd_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					//comboObj.BackColor = "#CCFFFD";					
					InsertItem(i++,  "All",  " ");
					comboObj.Text = "All";
	        	}
				break;
			case "dir_cd":
				with(comboObj) {
					comboObj.DropHeight=125;
					InsertItem(i++,  "All", " ");
					InsertItem(i++,  "E", "E");
					InsertItem(i++,  "W", "W");
					InsertItem(i++,  "S", "S");
					InsertItem(i++,  "N", "N");
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

    	axon_event.addListener('change', 'from_date_onchange', 'from_date', '');
    	axon_event.addListener('change', 'to_date_onchange', 'to_date', '');
    	axon_event.addListener('change', 'manu_in_time_onchange', 'manu_in_time', '');
    	axon_event.addListener('change', 'slan_cd_onchange', 'slan_cd', '');
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
            case "float":
            	ComKeyOnlyNumber(event.srcElement, ".");
                break;
            default:
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement, ".");
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
			case "loc_cd":
				if( formObj.loc_cd.value.length == 5 ){
					loc_cd_onchange();
				}
				break;
				
			case "slan_cd":
				if( formObj.slan_cd.value.length == 3 ){
					change_event();
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
					comboObjects[1].RemoveAll();  //YD_CD 콤보 초기화
					comboObjects[1].InsertItem(0, "All","");
					comboObjects[1].Text = "All";
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
    			
       		case "manu_in_time":
       			if( formObj.manu_in_time.value != ""){
       				if(!ComChkObjValid(obj)){
                    	setObjValue("manu_in_time", "");
                    	setFocus("manu_in_time");
                        return false;
       				}
       			}
           	    break;    			
    	}
    }     

   	
   	//Port Code 변경 이벤트 및  YD_CD 콤보 생성
   	function loc_cd_onchange(){
   		sheetObjects[0].RemoveAll();
   		
   		comboObjects[1].RemoveAll();  //YD_CD 콤보 초기화

   		var formObj = document.form;
   		formObj.f_cmd.value = SEARCH01;
   		var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0057GS.do", FormQueryString(formObj));

		if(ComGetTotalRows(sRhqXml) == 0){
			ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "Data"));
			setObjValue("loc_cd", "");
			setFocus("loc_cd");
		}else{
			comboObjects[1].DropHeight=200;
			ComXml2ComboItem(sRhqXml, comboObjects[1], "yd_cd", "yd_cd|yd_nm");

			//2011.01.25 P.H.D. 추가 => Port 변경시 RHQ를 조회한다.
	   		formObj.f_cmd.value = SEARCH01;
			sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0095GS.do", FormQueryString(formObj)+"&port_cd="+formObj.loc_cd.value);
			if(ComGetEtcData(sRhqXml, "PORT_CD") == ""){		
				ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "'Port Code'"));
				formObj.loc_cd.value = "";
			}else{
				var rhqOfcCd = ComGetEtcData(sRhqXml, "RHQ_OFC_CD");
				formObj.rhq.Code2 = rhqOfcCd == "" ? " " : rhqOfcCd; 
				ComKeyEnter('lengthnextfocus');
			}
		}
		comboObjects[1].InsertItem(0, "All","");
		comboObjects[1].Text = "All";
		
		if(formObj.loc_cd.value == ""){
			comboObjects[1].RemoveAll();  //YD_CD 콤보 초기화
   			comboObjects[1].InsertItem(0, "All","");
   			comboObjects[1].Text = "All";
		}
   	}
   	
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[0];
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
    	sheetObjects[0].RemoveAll();
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

             case "t1sheet1":
                 with (sheetObj) {
                	 // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    	//전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

 					 var HeadTitle1 = "|RHQ|Port|Lane|VVD CD|P/F SKD|P/F SKD|Actual SKD|Actual SKD|Actual SKD|ARR|ARR|Port Time|Port Time|DEP\nDelay\n(HRS)|Tugs|Tugs|Cargo Moves|Cargo Moves|R/H|R/H|Total\n(Moves)|Hatch\n(Moves)|Berth\nPROD|Working HRS|Working HRS|Gang HRS|Gang HRS|Working PROD|Working PROD|Gang PROD|Gang PROD|G/Crane\n(Avg used)";
 					 var HeadTitle2 = "|RHQ|Port|Lane|VVD CD|ETB|ETD|ATA|ATB|ATD|Delay\n(HRS)|Wait\n(HRS)|Delay\n(HRS)|Work\n(HRS)|DEP\nDelay\n(HRS)|In|Out|Full\n(Moves)|Empty\n(Moves)|Moves|Ratio(%)|Total\n(Moves)|Hatch\n(Moves)|Berth\nPROD|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)|G/Crane\n(Avg used)";
					 var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                     
                     HeadRowHeight = 30;
                     var rowCnt = 0;
                     var prefix="t1sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt,cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
					InitDataProperty(rowCnt,cnt++,	dtData,			60,		daCenter,	true,	prefix+"rhq",          	    false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			60,		daCenter,	true,	prefix+"port",          	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daCenter,	true,	prefix+"lane",          	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			80,		daCenter,	true,	prefix+"vvd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"etb",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"etd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"ata",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"atb",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"atd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"arr_delay",     	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"arr_wait",      	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"port_delay",    	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"port_work",     	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"dep_delay",     	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"tug_in",        	false,		"",	dfNullInteger,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"tug_out",       	false,		"",	dfNullInteger,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"cgo_fl",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"cgo_mt",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"rh_mvs",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			60,		daRight,	true,	prefix+"rh_ratio",      	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"tot_mvs",       	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"hatch",         	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"berth_prod",       	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_gross",    	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_net",      	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_gross",    	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_net",      	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_prd_gross",	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_prd_net",  	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_prd_gross",	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_prd_net",   	false,		"",	dfNullFloat,	2,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"avg_gang",      	false,		"",	dfNullFloat,	2,	true,	true);
					TotalRows = 2000;
					//SetSortDialog(false);
					//CountPosition = 0;	
					//CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
                 }
                 break;

             case "t2sheet1":
                 with (sheetObj) {
 					 // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    	//전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

 					 var HeadTitle1 = "|Lane|VVD CD|P/F SKD|P/F SKD|Actual SKD|Actual SKD|Actual SKD|ARR|ARR|Port Time|Port Time|DEP\nDelay\n(HRS)|Tugs|Tugs|Cargo Moves|Cargo Moves|R/H|R/H|Total\n(Moves)|Working HRS|Working HRS|Gang HRS|Gang HRS|Working PROD|Working PROD|Gang PROD|Gang PROD";
 					 var HeadTitle2 = "|Lane|VVD CD|ETB|ETD|ATA|ATB|ATD|Delay\n(HRS)|Wait\n(HRS)|Delay\n(HRS)|Work\n(HRS)|DEP\nDelay\n(HRS)|In|Out|Full\n(Moves)|Empty\n(Moves)|Moves|Ratio(%)|Total\n(Moves)|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)|Gross\n(HRS)|Net\n(HRS)";
 										
 					 var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                     
                     HeadRowHeight = 30;
                     var rowCnt = 0;

                     var prefix="t2sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt,cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
					InitDataProperty(rowCnt,cnt++,	dtData,			80,		daCenter,	true,	prefix+"lane",          	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			90,		daCenter,	true,	prefix+"vvd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"etb",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"etd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"ata",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"atb",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			100,	daCenter,	true,	prefix+"atd",           	false,		"",	dfNone,	0,		true,		true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"arr_delay",     	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"arr_wait",      	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"port_delay",    	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"port_work",     	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"dep_delay",     	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"tug_in",        	false,		"",	dfNullInteger,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"tug_out",       	false,		"",	dfNullInteger,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"cgo_fl",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"cgo_mt",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"rh_mvs",        	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			60,		daRight,	true,	prefix+"rh_ratio",      	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			54,		daRight,	true,	prefix+"tot_mvs",       	false,		"",	dfNullFloat,	0,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_gross",    	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_net",      	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_gross",    	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_net",      	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_prd_gross",	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"work_prd_net",  	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_prd_gross",	false,		"",	dfNullFloat,	1,	true,	true);
					InitDataProperty(rowCnt,cnt++,	dtData,			50,		daRight,	true,	prefix+"gang_prd_net",   	false,		"",	dfNullFloat,	1,	true,	true);
					
					//SetSortDialog(false);
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
 					formObj.page_no.value = "1";
 					//var arr = new Array("t1sheet1_", "t2sheet1_");
 					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
 					sheetObj.DoSearch("VOP_OPF_0063GS.do", sParam, "", false);
// 					var arr = new Array("t1sheet1_");
// 		        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(arr);
// 					var sXml = sheetObj.GetSearchXml("VOP_OPF_0063GS.do", sParam);
// 					var arrXml = sXml.split("|$$|");
// 					for(var i=0 ; i<arrXml.length; i++) { 
// 						sheetObjects[i].LoadSearchXml(arrXml[i]);
// 					}
 				}	
 				break;
 				
 			case IBROWSEARCH:
 				if(validateForm(sheetObj, formObj, IBSEARCH)){
 					formObj.f_cmd.value = SEARCH;
 					if (sheetObj.RowCount > 0){
 						formObj.page_no.value = Number(formObj.page_no.value) + 1;
 					}
 					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
 					sheetObj.DoSearch("VOP_OPF_0063GS.do", sParam, "", true);
 				}	  				
 				break;
 	
 			case IBCLEAR:
 	   			// Login Office 의 RHQ가 있으면 그것으로 하고 아니면 첫번째 RHQ를 default로 한다.
 	   			var dfltInx = comboObjects[0].FindIndex(rhqOfcCd, 0);
 	   			comboObjects[0].Text2 = (dfltInx == "-1"?"All":dfltInx); 				
 				setObjValue("loc_cd", ""); 				
 				comboObjects[1].RemoveAll();
         		initCombo(comboObjects[1], 1);
         		set_from_date();
         		setObjValue("manu_in_time", "0.0");
 				setObjValue("slan_cd", ""); 
 				comboObjects[2].Text = "All";
 				formObj.radio_carr_cd[0].checked = true;
 				sheetObjects[0].RemoveAll();
 				//sheetObjects[1].RemoveAll();
 				break;				
 				
 			case IBROWSEARCH:	
 				if(gubun=="slanCd"){
 					formObj.f_cmd.value = COMMAND12;
 					var lanXml = sheetObjects[0].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
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
                     InsertTab( cnt++ , "Port" , -1 );
                     InsertTab( cnt++ , "Lane" , -1 );

                 }
              break;

          }
     }


     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {

         var objs = document.all.item("tabLayer");

 	    	objs[nItem].style.display = "Inline";
 	    	objs[beforetab].style.display = "none";

 	    	//--------------- 요기가 중요 --------------------------//
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	//------------------------------------------------------//
 	    	beforetab= nItem;

     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 
//           	if(!isNull(formObj.loc_cd.value)){
//				if( formObj.loc_cd.value.length != 5 ){
//					setFocus("loc_cd");
//					return false;
//				}
// 			}
			
 			if(!isNull(formObj.slan_cd.value)){
				if( formObj.slan_cd.value.length != 3 ){
					setFocus("slan_cd");
					return false;
				}
 			}
 			
 			if(isNull(formObj.rhq.Code)){
//				ComShowCodeMessage("OPF50009", "RHQ");
//				formObj.rhq.focus();
//				return false;
			}else if(isNull(formObj.from_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.from_date.focus();
				return false;
			}else if(isNull(formObj.to_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.to_date.focus();
				return false;
			}else if(isNull(formObj.manu_in_time.value)){
				ComShowCodeMessage("OPF50009", "Manu. in Time");
				formObj.manu_in_time.focus();
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



     
     // [t1sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 		function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 	 		if(sheetObj.RowCount > 0){
 	 			//Sub Total RGB 설정
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				if(sheetObj.CellValue(i, "t1sheet1_vvd") == "S.Sum" || sheetObj.CellValue(i, "t1sheet1_vvd") == "S.Avg"){
 	 					sheetObj.CellFont("FontBold", i,"t1sheet1_vvd") = true;
 	 					for(var j=2 ; j<32 ; j++){
// 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(232, 231, 236);
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 	 					}
 	 				}
 	 			 	
 	 				if(sheetObj.CellValue(i, "t1sheet1_lane") == "S.Sum" || sheetObj.CellValue(i, "t1sheet1_lane") == "S.Avg"){
 	 					sheetObj.CellFont("FontBold", i,"t1sheet1_lane") = true;
 	 					for(var j=1 ; j<32 ; j++){
// 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(240, 240, 240);
 	 					}
 	 				}

 	 				if(sheetObj.CellValue(i, "t1sheet1_port") == "G.Sum" || sheetObj.CellValue(i, "t1sheet1_port") == "G.Avg"){
 	 					sheetObj.CellFont("FontBold", i,"t1sheet1_port") = true;
 	 					for(var j=1 ; j<32 ; j++){
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(255, 250, 210);
 	 					}
 	 				}
 	 			}
 	 			
// 	 			//Grand Total RGB 설정
// 	 			var allRowCount = sheetObj.LastRow;
// 	 			for(var j=1 ; j<=31 ; j++){
// 	 				sheetObj.CellFont("FontBold", allRowCount, j) = true;
// 	 				sheetObj.CellBackColor(allRowCount, j) = sheetObj.RgbColor(247, 225, 236);
// 	 			}
 	 		}     			
 		}
 		
     // [t2sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 		function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 	 		if(sheetObj.RowCount > 0){
 	 			//Sub Total RGB 설정
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				if(sheetObj.CellValue(i, "t2sheet1_vvd") == "S.Sum" || sheetObj.CellValue(i, "t2sheet1_vvd") == "S.AVG"){
 	 					sheetObj.CellFont("FontBold", i,"t2sheet1_vvd") = true;
 	 					for(var j=2 ; j<28 ; j++){
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(232, 231, 236);
 	 					}
 	 				}
 	 			 	
 	 				if(sheetObj.CellValue(i, "t2sheet1_port") == "G.Sum"){
 	 					sheetObj.CellFont("FontBold", i,"t2sheet1_port") = true;
 	 					for(var j=1 ; j<28 ; j++){
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 	 					}
 	 				}
 	 			}
 	 			
 	 			//Grand Total RGB 설정
 	 			var allRowCount = sheetObj.LastRow;
 	 			for(var j=1 ; j<=28 ; j++){
 	 				sheetObj.CellFont("FontBold", allRowCount, j) = true;
 	 				sheetObj.CellBackColor(allRowCount, j) = sheetObj.RgbColor(247, 225, 236);
 	 			}
 	 		}     			
 		}
				

 		function t1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow){
 			alert(CondParam+"/"+PageNo+"/"+OnePageRow);
 			var formObj = document.form;
			if(validateForm(sheetObj, formObj, IBSEARCH)){
				formObj.f_cmd.value = SEARCH;
				formObj.page_no.value = Number(formObj.page_no.value) + 1;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
				sheetObj.DoSearch("VOP_OPF_0063GS.do", sParam, "", true);
			}	 			
 		}
 		
 		function rhq_OnChange(comboObj, Code, Text){
 			sheetObjects[0].RemoveAll();
 		}

 		function yd_cd_OnChange(comboObj, Code, Text){
 			sheetObjects[0].RemoveAll();
 		}

 		function dir_cd_OnChange(comboObj, Code, Text){
 			sheetObjects[0].RemoveAll();
 		}
 		
 		function from_date_onchange    (){sheetObjects[0].RemoveAll();}
 		function to_date_onchange      (){sheetObjects[0].RemoveAll();}
 		function manu_in_time_onchange (){sheetObjects[0].RemoveAll();}
 		function slan_cd_onchange      (){sheetObjects[0].RemoveAll();}
 		
	/* 개발자 작업  끝 */