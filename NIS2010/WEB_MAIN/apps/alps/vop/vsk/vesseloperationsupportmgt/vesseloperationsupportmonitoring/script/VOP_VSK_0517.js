/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0517.js
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
     * @class VOP_VSK_0517 : VOP_VSK_0517 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0517() {
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
        var sheetObject1  = sheetObjects[0];   //t1sheet1
        var sheetObject2  = sheetObjects[1];   //임시 시트
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
					
				case "btn_Monitoring_Port":
					sUrl = "/hanjin/VOP_VSK_0033.do";
//					ComOpenWindow("VOP_VSK_0033.do", "", "width=1000,height=560", true);
					ComOpenPopup(sUrl, 722, 490, "getMonitoringPortHelp", "0,0", true);
					break;
					
				case "btn_Excel":
					sheetObject1.Down2Excel(-1);
					break;
					
				case "btn_loc_cd":	//Location 조회 팝업
					var cnt_cd = "";
					var loc_cd = formObject.loc_cd.value;

			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.loc_cd.value = rVal;
						loc_cd_onchange();
					} 
					break;
					
	            case "btns_calendar": //달력버튼
	                var cal = new ComCalendar();
	                cal.select(formObject.sel_date, 'yyyy-MM-dd');
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
 				
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initCombo(comboObjects[0]);
        
        initControl();
        
        //Total 헤드 색 지정
        sheetObjects[0].CellBackColor(0, 19) = sheetObjects[0].RgbColor(108, 194, 213);
        sheetObjects[0].CellBackColor(1, 19) = sheetObjects[0].RgbColor(108, 194, 213);
        sheetObjects[0].CellBackColor(1, 20) = sheetObjects[0].RgbColor(108, 194, 213);
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var i=0;
   	    switch(comboObj.id) {
			case "rhq":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.BackColor = "#CCFFFD";
					InsertItem(i++,  "ALL",  "^");
					InsertItem(i++,  "PHXRA", "PHXRA");
					InsertItem(i++,  "HAMRU", "HAMRU");
					InsertItem(i++,  "SHARC", "SHARC");
					InsertItem(i++,  "SINRS", "SINRS");
					InsertItem(i++,  "SELSC", "SELSC");
					InsertItem(i++,  "TYOSC", "TYOSC");
					InsertItem(i++,  "VVOIA", 	"VVOIA");
					comboObj.Code = "^";
	        	}
				break;
		}
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
                    style.height = 402;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    //MergeSheet = msAll;
                    //MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 3, 100);

					var HeadTitle1 = "|RHQ|PORT|Port Information Update Ratio|Port Information Update Ratio|Port Information Update Ratio|Port Information Update Ratio|Port Information Update Ratio|Port Information Update Ratio|Port Information Update Ratio|";
					    HeadTitle1 += "TMNL Information Update Ratio|TMNL Information Update Ratio|TMNL Information Update Ratio|TMNL Information Update Ratio|TMNL Information Update Ratio|TMNL Information Update Ratio|";
						HeadTitle1 += "Berth Window|Berth Window|Total Update Ratio|Total Update Ratio";
					
					var HeadTitle2 = "|RHQ|PORT|Maneuvering|Maneuvering|Non Working|Trucking|Trucking|Railroad|Railroad|G/Crane|G/Crane|F/Crane|F/Crane|G/Structure|G/Structure|1st|2nd|1st|2nd";
					var HeadTitle3 = "|RHQ|PORT|1st|2nd|Yearly|1st|2nd|1st|2nd|1st|2nd|1st|2nd|1st|2nd|1st|2nd|1st|2nd";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false);

                    var prefix="sheet1_";
                    //데이터속성            [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	    daCenter,		true,		prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"rhq",     	  false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"port",    	  false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"manu_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"manu_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix+"nonw_1st2",		false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"nonw_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"truc_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"truc_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"rail_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"rail_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"gcrn_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"gcrn_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"fcrn_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"fcrn_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"gstr_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		false,		prefix+"gstr_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			52,		daCenter,		true,		prefix+"bwin_1st2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			52,		daCenter,		true,		prefix+"bwin_2nd2",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,		true,		prefix+"tot_1st", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,		true,		prefix+"tot_2nd", 		false,		"",				dfNone,				0,		true,		true);

                    CountPosition = 0;
 				}
 		}
	}


    /** 
     * initControl()
     */ 
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', ''); //loc_cd 변경 Event
    	axon_event.addListenerFormat ('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    	axon_event.addListener('keydown',  'ComKeyEnter',   'form');
    }
    
    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
    	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
        
    	switch(event.srcElement.name){ 	    	
    		case "sel_date":
    			ComClearSeparator(event.srcElement);
    			break;
    	}
    }

    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
     	var elementObj = event.srcElement;
    	
        //입력Validation 확인 및 마스킹 처리
        //ComChkObjValid(event.srcElement);
    	switch(elementObj.name){ 	    	
    		case "sel_date":
    			if(!ComChkObjValid(elementObj)){
    				elementObj.value="";
    				elementObj.focus();
    			}
    			break;

    		case "loc_cd":
    			if(!isNull(elementObj.value)){
    				if(elementObj.maxLength != elementObj.value.length){
    					elementObj.focus();
    				}
    			}
    			break;
    			
    	}	
    }

    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
     	    case "engup":
     	        ComKeyOnlyAlphabet('upper');
     	        break;
     	    case "uppernum":
    	        ComKeyOnlyAlphabet('uppernum');
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
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keyup(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;

     	switch(obj.dataformat) {

     	    case "engup":
     	        if(document.form.loc_cd.value.length == 5 ){    	        	
     	        	loc_cd_onchange();
     	        }
     	        break;
     	    case "engdn":
     	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
     	        else ComKeyOnlyAlphabet('lower');
     	        break;
     	}
    } 
    
    /** 
     * Port Code 5자리 체크
     */ 
	function loc_cd_onchangeMax5(){
		var formObj = document.form;

		if(formObj.loc_cd.value != ""){
			//alert("LOC_CD = "+formObj.loc_cd.value);
			if(formObj.loc_cd.value.length < 5 ){
				ComShowCodeMessage("VSK50014");
				ComAlertFocus(formObj.loc_cd, "");
				return ;
			}
		}
	}
	
	//Port Code 변경 이벤트
	function loc_cd_onchange(){

	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_VSK_0517GS.do", FormQueryString(formObj));
		var sRhqVal = ComGetEtcData(sRhqXml, "cmbVal");
		var sRhqName = ComGetEtcData(sRhqXml, "cmbName");
	
		if( sRhqVal != "")
		{
			var arrRhqVal = sRhqVal.split("|");
			var arrRhqName = sRhqName.split("|");
			
			for(var i=0; i<arrRhqVal.length ; i++)
			{
				rhqChangeFlg = false;
				comboObjects[0].Code2 = arrRhqVal[0];
			}
		}else{
			//[2010.03.15] 김기용 차장 요청으로 Port초기화함.
			ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
			ComClearObject(formObj.loc_cd);
			comboObjects[0].Code2 = "^";
		}
	}
	
	//RHQ 변경 이벤트
    function rhq_OnChange(comObj,index,text)
    {
    	var formObj = document.form;
		formObj.loc_cd.value = "";
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj,formObj,sAction)){
 					formObj.f_cmd.value = SEARCH;
 					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml = sheetObj.GetSearchXml("VOP_VSK_0517GS.do", sParam);
 					if(sXml.length>0){ 
 						sheetObj.LoadSearchXml(sXml);
 					}
 				}	
 				break;
 	
			case IBCLEAR:
				formObj.loc_cd.value = "";
				comboObjects[0].RemoveAll();
		        initCombo(comboObjects[0], 1);
				formObj.sel_date.value = formObj.nowDate.value;            		
				sheetObj.RemoveAll();
				break;
 					
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 if(ComIsEmpty(formObj.sel_date.value)){
				ComShowCodeMessage("COM12114", "Date");
				ComAlertFocus(formObj.sel_date, "");
				return false;
         	}
         }

         return true;
     }


	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		if(sheetObj.RowCount > 0){
			
			/**
			var color1 = RgbColor(229, 234, 255);		// 하늘색?
			var color2 = RgbColor(247, 225, 236);		// 분홍색
			var color3 = RgbColor(108, 194, 213);		// 연한파랑색
			var color4 = RgbColor(235, 124, 152);		// 연한빨강색
			**/
			
			sheetObj.ColBackColor(1) = sheetObj.RgbColor(229, 234, 255);
			sheetObj.ColBackColor(2) = sheetObj.RgbColor(229, 234, 255);
			
			//Sub Total RGB 설정
			for(var i=0 ; i<= sheetObj.RowCount+2 ; i++){
				if(sheetObj.CellValue(i, "sheet1_port") == "Sub Total"){
					sheetObj.CellFont("FontBold", i,2) = true;
					for(var j=2 ; j<21 ; j++){
						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
					}
				}
			}
			
			//Total RGB 설정
			var allRowCount = sheetObj.RowCount+2;
			for(var j=1 ; j<21 ; j++){
				sheetObj.CellFont("FontBold", allRowCount, j) = true;
				sheetObj.CellBackColor(allRowCount, j) = sheetObj.RgbColor(247, 225, 236);
			}
		}
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