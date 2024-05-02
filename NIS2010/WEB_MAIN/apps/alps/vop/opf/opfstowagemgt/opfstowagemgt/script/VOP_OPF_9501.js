/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_9501.js
*@FileTitle : Bay Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2009.07.20 김도현
* 1.0 Creation
=========================================================
*=========================================================*/
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
     * @class VOP_OPF_9501 : VOP_OPF_9501 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_9501() {
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
	
    //VVD CD 관련 항목들
    var strVVDOptions = "vsl_cd|skd_voy_no|skd_dir_cd";

 	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  
		var sheetObject1  = sheetObjects[0];   //t1sheet1
		var sheetObject2  = sheetObjects[1];   //t1sheet2
		var sheetObject3  = sheetObjects[2];   //t1sheet3
		var sheetObject4  = sheetObjects[3];   //t1sheet4
		var sheetObject5  = sheetObjects[4];   //t1sheet4
  
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_New":
					initClear("NEW");
					break;

		        case "btns_period": // From 달력버튼
		        	var cal = new ComCalendarFromTo();
		        	cal.select(formObject.eta_fr_dt, formObject.eta_to_dt, 'yyyy-MM-dd');
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
		
		var formObj = document.form;
	    formObj.eta_fr_dt.value = frDt;
	    formObj.eta_to_dt.value = toDt;
		
		initControl();
	}
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
   		axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리    	 
        axon_event.addListenerFormat('focus',     'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        axon_event.addListenerFormat('blur',	  'obj_blur',	    form); 
        axon_event.addListenerForm  ("keyup",    'obj_keyup',      form);
    	axon_event.addListener  ('keypress', 'eng_keypress', 'slan_cd'); //Code 입력 시 영문 대문자만 입력하기
    	axon_event.addListener  ('change', 'change_event', 'slan_cd');   //Input Box 이벤트
    	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', form);
    }
     
     /**
      * OnBlur
      */
     function obj_deactivate(){
     	ComChkObjValid(event.srcElement);
     }     

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "engup":
    			switch(event.srcElement.name){
    				case "cntr_id":		    	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자/숫자 입력하기
    					break;	    	
    			}
    			break;    			
    		case "ymd":	
    	    		ComKeyOnlyNumber();
    			break;    			

    		default:    	    	
    			ComKeyOnlyAlphabet("num");					//공통기준:영문, 숫자만을 인식
	    		break;
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문 대문자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
		//영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
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
	    		setFocus(elementObj.name);
	    		return false;
	    	}

    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun = "slanCd";
        	}

    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    
    function obj_change(){
    }
    
  	/**
     * VVD 정보 관련 항목 셋팅 : VVD
     */
    function setVVDInfo(formObj, sXml) {
    	var vvdData = ComOpfXml2Array(sXml, strVVDOptions);
 	   	if(vvdData == null) {
 		    ComShowCodeMessage("COM12114", "VVD CD");
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 1) {
 	   			ComShowCodeMessage("COM12114", "VVD CD");
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		}else{
 	   			setBayList_Combo(""); //BayList 콤보 세팅
 	   		}
 	   	}
    }

    /**
     * 선택된 Object의 초기화와 포커스 이동
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs = nameVars.split("|");
    	
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		
    		if(type == 'sheet') sheetObj.CellValue2(etcVal, prefixs[0]+nameArrs[objIdx]) = "";
    		else {
    			if(eval("document.form."+nameArrs[objIdx]).type == 'hidden') {
    				setObjValue(nameArrs[objIdx],"");
    			} else {
    				ComClearObject(eval("document.form."+nameArrs[objIdx]));
    			}
    		}
    		
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, nameArrs[objIdx]);
    			else {
    				setFocus(nameArrs[objIdx]);
    			}
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
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
    }  
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
			var formObj = document.form;
			ComSetNextFocus(obj);
    	}
    }
    
    // 업무 자바스크립트 OnBlur 이벤트 처리
    function obj_blur() {
    	
    	switch(event.srcElement.name){ 
//	    	case "cntr_id":
//	    		var formObj = document.form;
//		    	if (formObj.eta_fr_dt.value == "" || formObj.eta_to_dt.value == "") {
//					ComShowCodeMessage("COM130404", "Period", "Period");
//					formObj.eta_fr_dt.focus();
//					return false;
//				}
//	    		initClear("CNTR");
//	    		formObj.vvd_port_gb.value = "VVD";
//	        	searchVVDInfo();
//	        	break;
    	}
    }
  
    function obj_keyup(){
    	var eleObj = event.srcElement;
    	var formObj = document.form;

    	switch (eleObj.name) {
    	case "cntr_id":
    		if(eleObj.value.length == 11){
	    		initClear("CNTR");
	    		formObj.vvd_port_gb.value = "VVD";
	        	searchVVDInfo();
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
            //style.height = 222;
    		//style.height = 200;
            style.height = 290;
            style.width  = 590;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            // Row 선택 시 색상표시 안함
            SelectHighLight = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 0, 100);
			var HeadTitle1 = "||||||||||||||||||||"; 
									
			var headCount = ComCountHeadTitle(HeadTitle1);
			sheet1HeadTitleCnt = headCount;

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false )

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, false, true);
            
            HeadRowHeight = 20;
            
            var prefix="sheet1_";
            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtData,			28,		daCenter,	true,	"on_tr_nm_f", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_0",		false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_1", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_2", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_3", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_4", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_5", 	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_6",		false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_7",		false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_8",		false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_9",		false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_10",	false,		"",		dfNone,		0,	true,	true);                    
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_11",	false,		"",		dfNone,		0,	true,	true);                    
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_12",  	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_13",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_14",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_15",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_16",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_17",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"on_row_18",	false,		"",		dfNone,		0,	true,	true);
            InitDataProperty(0, cnt++ , dtData,			28,		daCenter,	true,	"on_tr_nm_b", 	false,		"",		dfNone,		0,	true,	true);
            CountPosition = 0;                                         
			}
				
				break;

    	case "sheet2":
				with (sheetObj) {
                // 높이 설정
                style.height = 20;
                style.width  = 534;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                // Row 선택 시 색상표시 안함
                SelectHighLight = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 0, 100);
				var HeadTitle1 = "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"; 
										
				var headCount = ComCountHeadTitle(HeadTitle1);
				sheet2HeadTitleCnt = headCount;

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false )

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, false, true);
                
                HeadRowHeight = 20;
                
                var prefix="sheet2_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_0",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_1",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_2",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_3",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_4",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_5",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_6",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_7",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_8",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_9",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_10",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_11",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_12",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_13",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_14",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_15",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_16",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_17",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_18",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_19",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_20",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_21",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_22",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_23",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_24",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_25",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_26",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_27",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_28",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_29",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_30",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_31",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_32",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_33",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_34",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_35",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_36",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_37",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_38",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_39",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_40",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_41",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_42",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_43",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_44",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_45",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_46",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_47",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_48",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_49",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_50",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_51",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_52",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_53",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_54",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_55",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_56",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_57",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_58",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_59",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_60",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_61",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_62",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_63",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_64",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_65",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_66",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_67",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_68",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_69",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_70",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_71",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_72",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_73",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_74",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			7,		daCenter,	true,	"htch_cvr_75",		false,		"",		dfNone,		0,	true,	true);
                
                CountPosition = 0;                                         
				}
				
				break;

    	case "sheet3":
				with (sheetObj) {
                // 높이 설정
	            //style.height = 262;
    			//style.height = 200;
	            style.height = 290;
                style.width  = 590;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                // Row 선택 시 색상표시 안함
                SelectHighLight = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 0, 100);
				var HeadTitle1 = "||||||||||||||||||||"; 
										
				var headCount = ComCountHeadTitle(HeadTitle1);
				sheet3HeadTitleCnt = headCount;

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false )

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, false, true);
                
                HeadRowHeight = 20;
                
                var prefix="sheet3_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,			28,		daCenter,	true,	"under_tr_nm_f", 	false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_0",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_1", 		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_2", 		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_3", 		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_4", 		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_5", 		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_6",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_7",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_8",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_9",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_10",		false,		"",		dfNone,		0,	true,	true);                    
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_11",		false,		"",		dfNone,		0,	true,	true);                    
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_12",  	false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_13",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_14",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_15",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_16",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_17",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daLeft,		true,	"under_row_18",		false,		"",		dfNone,		0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,			28,		daCenter,	true,	"under_tr_nm_b", 	false,		"",		dfNone,		0,	true,	true);
                CountPosition = 0;                                         
				}
				
				break;

    	case "sheet4":
				with (sheetObj) {
		            // 높이 설정
		            style.height = 50;
		            style.width  = 70;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
	                // Row 선택 시 색상표시 안함
	                SelectHighLight = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 0, 100);
					var HeadTitle1 = "|"; 
											
					var headCount = ComCountHeadTitle(HeadTitle1);
					sheet4HeadTitleCnt = headCount;
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
//		            InitHeadMode(true, true, true, true, false )
		            InitHeadMode(true, true, false, true, false, false)
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, false, true);
		            
		            HeadRowHeight = 20;
		            
		            var prefix="sheet4_";
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,	"port_color", 	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"port_nm",		false,		"",		dfNone,		0,	true,	true);
		            CountPosition = 0;                                         
		    	}
				
				break;
				

    	case "sheet5":
				with (sheetObj) {
		            // 높이 설정
		            style.height = 0;
//		            style.width  = 70;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
	                // Row 선택 시 색상표시 안함
	                SelectHighLight = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 0, 100);
					var HeadTitle1 = "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"; 
											
					var headCount = ComCountHeadTitle(HeadTitle1);
					sheet4HeadTitleCnt = headCount;
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
//		            InitHeadMode(true, true, true, true, false )
		            InitHeadMode(true, true, false, true, false, false)
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, false, true);
		            
		            HeadRowHeight = 20;
		            
		            var prefix="sheet5_";
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"vsl_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"voy_no",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"dir_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"port_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"id",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"call_ind",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"bay",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"roww",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"tier",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"opr_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"fe",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"por",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pol",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pod",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pod2",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"fpod",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"fdest",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"sztp",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"sztp_iso",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"weight",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"delv_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"group_cd",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"special",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"temp",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg2",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg3",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg4",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"unno",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovh",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovf",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ova",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovp",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovs",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovh_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovp_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovs_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ovf_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ova_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"remark",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"remark2",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cod",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cod_rsn",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pre_position",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_port",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_rsn",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_acct",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_res",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_type",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"shift_loc",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"bl_no",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"booking_no",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"hi1",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"hi2",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cargo_type",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cntr_type",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cntr_size",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pcod",			false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ondeck_chk",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"hatch",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"act_slot",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"slot_over",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"status",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"wgt_group",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"plan_type",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"update_user",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"update_time",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"co_loaded",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"dg_remark",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pod_iso",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pod2_iso",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"pol_iso",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"packing_grp",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"flashpoint",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"co_packing_grp",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"co_flashpoint",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cargo_length",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cargo_breadth",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cargo_height",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cargo_unit",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg_seq",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"imdg_grp",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"co_imdg_seq",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"co_imdg_grp",	false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"deck_psn",		false,		"",		dfNone,		0,	true,	true);
		            InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"cntr_psn",		false,		"",		dfNone,		0,	true,	true);
		            CountPosition = 0;                                         
		    	}
				
				break;
				
 			}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBSEARCH:      //조회
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH;
				ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
                ComOpenWait(false);
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				sheetObjects[3].LoadSearchXml(arrXml[3]);
				sheetObjects[4].LoadSearchXml(arrXml[4]);
			}
			
			break;

		case SEARCH01:      //상세조회
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH04;
				ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
                ComOpenWait(false);
				var arrXml = sXml.split("|$$|");
				sheetObjects[4].LoadSearchXml(arrXml[0]);
				
				//Sheet에서 html로 이동시킨다.
				ComOpfCopyRowToForm(sheetObjects[4], formObj, sheetObjects[4].LastRow, "frm_");
			}
			
			break;
		
		
		
		}
	}
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
				var formObj = document.form;	 	 						
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<sheet1HeadTitleCnt; j++ ) {
	 	 				
 	 					sheetObj.FocusStyle = fsRaised;
 	 					
	 	 				if(sheetObj.CellValue(i,j).length > 11){
	 	 					var cntr_info = sheetObj.CellValue(i,j);
	 	 					var cntr_info_split = cntr_info.split('_');
	 	 					
	 	 					sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(cntr_info_split[2], cntr_info_split[3], cntr_info_split[4]);
	 	 					CellFontColor(i, j) = sheetObj.RgbColor(255, 255, 255);
	 	 					
	 	 					if(cntr_info_split[05] == 'CNTR'){
//	 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(cntr_info_split[2], cntr_info_split[3], cntr_info_split[4]);
//	 	 						CellFontColor(i, j) = sheetObj.RgbColor(255, 255, 255);
	 	 			 			formObj.frm_id.value = cntr_info_split[1];
	 	 					}
	 	 				}else{
		 	 				if(sheetObj.CellValue(i, j) == "0" || sheetObj.CellValue(i, j) == "99"){
		 	 					sheetObj.CellValue2(i,j)  = "";
		 	 				}

		 	 				if(ComTrim(sheetObj.CellValue(i, j)) == "X"){
	 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
	 	 						sheetObj.CellValue2(i,j)  =  "   "+ComTrim(sheetObj.CellValue(i,j));
	 	 					}else if(ComTrim(sheetObj.CellValue(i, j)) == "▣"){
	 	 						CellFontColor(i, j) = sheetObj.RgbColor(255, 0, 0);
	 	 						sheetObj.CellValue2(i,j)  =  "  "+ComTrim(sheetObj.CellValue(i,j));
	 	 					}else if(ComTrim(sheetObj.CellValue(i, j)) == "."){
	 	 						sheetObj.CellValue2(i,j)  =  "   "+ComTrim(sheetObj.CellValue(i,j));
	 	 					}
	 	 				}
 	 				}
 	 			}
 	 			// 시트 선 숨김.
 	 			//sheetObjects[0].GridLine = glNone;
 	 			// 시트 선색상 흰색.
 	 			sheetObjects[0].InLineColor = RgbColor(255,255,255);
 	 			sheetObjects[0].OutLineColor = RgbColor(255,255,255);

 	 			// Row건수에 따라 시트높이 재조정
 	 			sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(sheetObj.RowCount);
 	 			
 	 		}
		}
    	
	}
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<sheet2HeadTitleCnt; j++ ) {
	 	 				if(sheetObj.CellValue(i, j) == "O"){
	 	 					sheetObj.CellValue2(i,j)  = "";
	 	 					sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(1, 0, 0);
	 	 				}else if(sheetObj.CellValue(i, j) == "X"){
	 	 					sheetObj.CellValue2(i,j)  = "";
	 	 				}
 	 				}
 	 			}
 	 		}
 	 		
 			// 시트 선색상 흰색.
 			sheetObjects[1].InLineColor = RgbColor(255,255,255);
 			sheetObjects[1].OutLineColor = RgbColor(255,255,255);
 	 		
		}
    	
	}
    
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
				var formObj = document.form;
				
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<sheet3HeadTitleCnt; j++ ) {
	 	 				
 	 					sheetObj.FocusStyle = fsRaised;
 	 					
	 	 				if(sheetObj.CellValue(i,j).length > 11){
	 	 					var cntr_info = sheetObj.CellValue(i,j);
	 	 					var cntr_info_split = cntr_info.split('_');
	 	 					
	 	 					sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(cntr_info_split[2], cntr_info_split[3], cntr_info_split[4]);
	 	 					CellFontColor(i, j) = sheetObj.RgbColor(255, 255, 255);
	 	 					
	 	 					if(cntr_info_split[05] == 'CNTR'){
//	 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(cntr_info_split[2], cntr_info_split[3], cntr_info_split[4]);
//	 	 						CellFontColor(i, j) = sheetObj.RgbColor(255, 255, 255);
	 	 			 			formObj.frm_id.value = cntr_info_split[1];
	 	 					}
	 	 				}else{
		 	 				if(sheetObj.CellValue(i, j) == "0" || sheetObj.CellValue(i, j) == "99"){
		 	 					sheetObj.CellValue2(i,j)  = "";
		 	 				}

		 	 				if(ComTrim(sheetObj.CellValue(i, j)) == "X"){
	 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
	 	 						sheetObj.CellValue2(i,j)  = "   "+ComTrim(sheetObj.CellValue(i,j));
	 	 					}else if(ComTrim(sheetObj.CellValue(i, j)) == "▣"){
	 	 						CellFontColor(i, j) = sheetObj.RgbColor(255, 0, 0);
	 	 						sheetObj.CellValue2(i,j)  = "  "+ComTrim(sheetObj.CellValue(i,j));
	 	 					}else if(ComTrim(sheetObj.CellValue(i, j)) == "."){
	 	 						sheetObj.CellValue2(i,j)  =  "   "+ComTrim(sheetObj.CellValue(i,j));	 	 						
	 	 					}
	 	 				}
 	 				}
 	 			}
 	 			// 시트 선 숨김.
 	 			//sheetObjects[2].GridLine = glNone;
 	 			// 시트 선색상 흰색.
 	 			sheetObjects[2].InLineColor = RgbColor(255,255,255);
 	 			sheetObjects[2].OutLineColor = RgbColor(255,255,255);
 	 			
 	 			// Row건수에 따라 시트높이 재조정
 	 			sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(sheetObj.RowCount);
 	 			
 	 		}
		}
	}      
    
    function sheet4_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<sheet4HeadTitleCnt; j++ ) {
	 	 				
//	 	 				if(sheetObj.CellValue(i,j).length > 5){
	 	 					var cntr_info = sheetObj.CellValue(i,"port_color")
	 	 					var cntr_info_split = cntr_info.split('_');

	 	 					sheetObj.CellBackColor(i, "port_color") = sheetObj.RgbColor(cntr_info_split[0], cntr_info_split[1], cntr_info_split[2]);
	 	 					CellFontColor(i, "port_color") = sheetObj.RgbColor(cntr_info_split[0], cntr_info_split[1], cntr_info_split[2]);
//	 	 				}
 	 				}
 	 			}
 	 			// 시트 선 숨김.
 	 			sheetObjects[3].GridLine = glNone;
 	 			// 시트 선색상 흰색.
 	 			sheetObjects[3].InLineColor = RgbColor(255,255,255);
 	 			sheetObjects[3].OutLineColor = RgbColor(255,255,255);
 	 			
 	 			// Row건수에 따라 시트높이 재조정
 	 			sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(sheetObj.RowCount);
 	 		}
		}
	}    
    
    function sheet5_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			var formObj = document.form;
			// 상세정보
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				var cntr_info = sheetObj.CellValue(i,"id");
 	 				if(formObj.frm_id.value == cntr_info){
 	 					//Sheet에서 html로 이동시킨다.
 	 					ComOpfCopyRowToForm(sheetObj, formObj, i, "frm_");
 	 				}
 	 			}
 	 		}
		}
	}    
    
    /**
     * IBSheet1 Object를 마우스로 클릭한경우
     */
    function sheet1_OnClick(sheetObj,Row, Col, Value) {
		var formObj = document.form;
		var cntr_info = sheetObj.CellValue(Row,Col);
		
		// sheet3 선택색상 초기화.
		if(formObj.sheet3_old_row.value != "" && formObj.sheet3_old_col.value != ""){
			sheetObjects[2].CellBackColor(formObj.sheet3_old_row.value , formObj.sheet3_old_col.value) = sheetObj.RgbColor(formObj.bg_colr_r.value, formObj.bg_colr_g.value, formObj.bg_colr_b.value);
			
			// sheet3 선택 CNTR 색상삭제.
			formObj.sheet3_old_row.value = '';
			formObj.sheet3_old_col.value = '';
		}
		
		// sheet1 선택색상 초기화.
		if(formObj.sheet1_old_row.value != "" && formObj.sheet1_old_col.value != ""){
			sheetObj.CellBackColor(formObj.sheet1_old_row.value , formObj.sheet1_old_col.value) = sheetObj.RgbColor(formObj.bg_colr_r.value, formObj.bg_colr_g.value, formObj.bg_colr_b.value);
		}
		
		if(cntr_info.length > 11){			
			var cntr_info_split = cntr_info.split('_');
			
 			formObj.frm_id.value = cntr_info_split[1];
			// 선택 CNTR 색상셋팅.
			formObj.sheet1_old_row.value = Row;
			formObj.sheet1_old_col.value = Col;
			formObj.bg_colr_r.value = cntr_info_split[2];
			formObj.bg_colr_g.value = cntr_info_split[3];
			formObj.bg_colr_b.value = cntr_info_split[4];

			// 상세정보
 	 		if(sheetObjects[4].RowCount > 0){
 	 			for(var i=sheetObjects[4].HeaderRows ; i <= sheetObjects[4].LastRow ; i++){
 	 				var cntr_info = sheetObjects[4].CellValue(i,"id");
 	 				if(formObj.frm_id.value == cntr_info){
 	 					//Sheet에서 html로 이동시킨다.
 	 					ComOpfCopyRowToForm(sheetObjects[4], formObj, i, "frm_");
 	 				}
 	 			}
 	 		}
			
		}else{
			// CNTR Information 삭제
 			formObj.frm_cntr_psn.value = '';
 			formObj.frm_deck_psn.value = '';
 			formObj.frm_id.value = '';
 			formObj.frm_pol.value = '';
 			formObj.frm_pod.value = '';
 			formObj.frm_opr_cd.value = '';
 			formObj.frm_weight.value = '';
 			formObj.frm_sztp.value = '';
 			formObj.frm_cargo_type.value = '';
 			formObj.frm_sztp_iso.value = '';
 			formObj.frm_fe.value = '';
 			formObj.frm_pod2.value = '';
 			formObj.frm_wgt_group.value = '';
 			formObj.frm_por.value = '';
 			formObj.frm_fpod.value = '';
 			formObj.frm_temp.value = '';
 			formObj.frm_fdest.value = '';
 			formObj.frm_delv_cd.value = '';
 			formObj.frm_bl_no.value = '';
 			formObj.frm_booking_no.value = '';
 			formObj.frm_imdg.value = '';
 			formObj.frm_unno.value = '';
 			formObj.frm_ovh_slot.value = '';
 			formObj.frm_ovh.value = '';
 			formObj.frm_ovf_slot.value = '';
 			formObj.frm_ovf.value = '';
 			formObj.frm_ova_slot.value = '';
 			formObj.frm_ova.value = '';
 			formObj.frm_ovp_slot.value = '';
 			formObj.frm_ovp.value = '';
 			formObj.frm_ovs_slot.value = '';
 			formObj.frm_ovs.value = '';
 			
			// 선택 CNTR 색상삭제.
			formObj.sheet1_old_row.value = '';
			formObj.sheet1_old_col.value = '';
			formObj.sheet3_old_row.value = '';
			formObj.sheet3_old_col.value = '';
			formObj.bg_colr_r.value = '';
			formObj.bg_colr_g.value = '';
			formObj.bg_colr_b.value = '';
		}
    }
    
    /**
     * IBSheet3 Object를 마우스로 클릭한경우
     */
    function sheet3_OnClick(sheetObj,Row, Col, Value) {
    	
		var formObj = document.form;
		var cntr_info = sheetObj.CellValue(Row,Col);
		
		// sheet1 선택색상 초기화.
		if(formObj.sheet1_old_row.value != "" && formObj.sheet1_old_col.value != ""){
			sheetObjects[0].CellBackColor(formObj.sheet1_old_row.value , formObj.sheet1_old_col.value) = sheetObj.RgbColor(formObj.bg_colr_r.value, formObj.bg_colr_g.value, formObj.bg_colr_b.value);

			// sheet1 선택 CNTR 색상삭제.
			formObj.sheet1_old_row.value = '';
			formObj.sheet1_old_col.value = '';
		}
		
		// sheet3 선택색상 초기화.
		if(formObj.sheet3_old_row.value != "" && formObj.sheet3_old_col.value != ""){
			sheetObj.CellBackColor(formObj.sheet3_old_row.value , formObj.sheet3_old_col.value) = sheetObj.RgbColor(formObj.bg_colr_r.value, formObj.bg_colr_g.value, formObj.bg_colr_b.value);
		}
		
		if(cntr_info.length > 11){
			var cntr_info_split = cntr_info.split('_');
 			formObj.frm_id.value = cntr_info_split[1];
			// 선택 CNTR 색상셋팅.
			formObj.sheet3_old_row.value = Row;
			formObj.sheet3_old_col.value = Col;
			formObj.bg_colr_r.value = cntr_info_split[2];
			formObj.bg_colr_g.value = cntr_info_split[3];
			formObj.bg_colr_b.value = cntr_info_split[4];
			
			// 상세정보
 	 		if(sheetObjects[4].RowCount > 0){
 	 			for(var i=sheetObjects[4].HeaderRows ; i <= sheetObjects[4].LastRow ; i++){
 	 				var cntr_info = sheetObjects[4].CellValue(i,"id");
 	 				if(formObj.frm_id.value == cntr_info){
 	 					//Sheet에서 html로 이동시킨다.
 	 					ComOpfCopyRowToForm(sheetObjects[4], formObj, i, "frm_");
 	 				}
 	 			}
 	 		}
			
		}else{
			// CNTR Information 삭제
 			formObj.frm_cntr_psn.value = '';
 			formObj.frm_deck_psn.value = '';
 			formObj.frm_id.value = '';
 			formObj.frm_pol.value = '';
 			formObj.frm_pod.value = '';
 			formObj.frm_opr_cd.value = '';
 			formObj.frm_weight.value = '';
 			formObj.frm_sztp.value = '';
 			formObj.frm_cargo_type.value = '';
 			formObj.frm_sztp_iso.value = '';
 			formObj.frm_fe.value = '';
 			formObj.frm_pod2.value = '';
 			formObj.frm_wgt_group.value = '';
 			formObj.frm_por.value = '';
 			formObj.frm_fpod.value = '';
 			formObj.frm_temp.value = '';
 			formObj.frm_fdest.value = '';
 			formObj.frm_delv_cd.value = '';
 			formObj.frm_bl_no.value = '';
 			formObj.frm_booking_no.value = '';
 			formObj.frm_imdg.value = '';
 			formObj.frm_unno.value = '';
 			formObj.frm_ovh_slot.value = '';
 			formObj.frm_ovh.value = '';
 			formObj.frm_ovf_slot.value = '';
 			formObj.frm_ovf.value = '';
 			formObj.frm_ova_slot.value = '';
 			formObj.frm_ova.value = '';
 			formObj.frm_ovp_slot.value = '';
 			formObj.frm_ovp.value = '';
 			formObj.frm_ovs_slot.value = '';
 			formObj.frm_ovs.value = '';
 			
			// 선택 CNTR 색상삭제.
			formObj.sheet1_old_row.value = '';
			formObj.sheet1_old_col.value = '';
			formObj.sheet3_old_row.value = '';
			formObj.sheet3_old_col.value = '';
			formObj.bg_colr_r.value = '';
			formObj.bg_colr_g.value = '';
			formObj.bg_colr_b.value = '';
		}
    }

	/*******************************************************************************
	 * Validation 시작 *
	 ******************************************************************************/
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
	
		case IBSEARCH:
	    	if (formObj.cntr_id.value == "") {
				ComShowCodeMessage("COM130404", "CNTR No.", "CNTR No.");
				formObj.cntr_id.focus();
				return false;
			}
			
	    	if (formObj.eta_fr_dt.value == "" || formObj.eta_to_dt.value == "") {
				ComShowCodeMessage("COM130404", "Period", "Period");
				formObj.eta_fr_dt.focus();
				return false;
			}
			
			if (comboObjects[0].Code == "") {
				ComShowCodeMessage("COM130404", "VVD", "VVD");
				formObj.vvd.focus();
				return false;
			}
			
			if (comboObjects[1].Code == "") {
				ComShowCodeMessage("COM130404", "PORT", "PORT");
				formObj.port_cd.focus();
				return false;
			}
			
			if (comboObjects[2].Code == "") {
				ComShowCodeMessage("COM130404", "BAY", "BAY");
				formObj.bay_idx.focus();
				return false;
			}
			
			break;
		}
	
		return true;
	}
    
  	/**
     * VVD 및 PORT Combo정보 조회
     */
  	
    function searchVVDInfo() {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
		
		if(formObj.vvd_port_gb.value == "VVD"){
			ComXml2ComboItem(sRhqXml, comboObjects[0], "vvd|on_board_msg", "vvd|on_board_msg");
			formObj.vvd.Index = 0;

			// 해당 CNTR No.가 BAY_PLAN에 없는경우.
			if(formObj.vvd.Index < 0){
	    		ComShowCodeMessage("OPF50048",document.form.cntr_id.value);
	    		return false;
			}				
			
		}
    }
    
  	
    function searchPortInfo() {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		var arrXml = formObj.vvd.Text.split("-");
		formObj.vsl_cd.value = arrXml[0];
		formObj.skd_voy_no.value = arrXml[1];
		formObj.skd_dir_cd.value = arrXml[2];
    	
    	formObj.vvd_port_gb.value = "PORT";
		
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[1], "vsl_cd|skd_voy_no|skd_dir_cd|call_ind", "port_cd|vps_eta_dt|on_board_msg|call_ind");
		formObj.port_cd.Index = 0;
    }
    
    /**
     * BayList 콤보 가져옴
     */
	function setBayList_Combo(){

	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH03;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[2], "bay_idx", "bay_idx");
	}

    /**
     * BayIdx 콤보 가져옴
     */
	function setBayIdx_Combo(){

		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_9501GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[3], "bay_idx", "bay_idx");

		comboObjects[3].Index = 0;	
		comboObjects[2].Code = comboObjects[3].Code;
	}
    
    /**
     * VVD Combo 변경시 해당 Port Combo 조회
     */
    function vvd_OnChange(comb, Index_Code, Text){
    	searchPortInfo();
    }
    
    /**
     * Port Combo 변경시 해당 Container Bay Index 조회
     */
    function port_cd_OnChange(comb, Index_Code, Text){
    	var formObj = document.form;
    	
		var arrXml = Text.split("|");
		if(arrXml.length != 1){
			formObj.call_ind.value = arrXml[3];
		}else{
			var arrXml = Text.split(",");
			formObj.call_ind.value = arrXml[3];
		}
    	
    	initClear("PORT");
    	setBayIdx_Combo(); //BayIdx 콤보 세팅
    	
    	if(comboObjects[2].Index < 0){
    		ComShowCodeMessage("OPF50048",document.form.cntr_id.value);
    		return false;
    	}
    }

	/**
     * BAY Combo 변경시 Retrieve.
     */
    function bay_idx_OnChange(comb, Index_Code, Text){
    	initClear("");
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    /**
     * Port Combo 변경시 해당 Container Bay List 조회
     */
    function cntr_bay_idx_OnChange(comb, Index_Code, Text){
    	initClear("BAY");
    	setBayList_Combo(); //BayList 콤보 세팅
    }

    function initClear(clearGb){
    	var formObj = document.form;
    	
		// CNTR Information 삭제
		setObjValue("frm_cntr_psn", "");
		setObjValue("frm_deck_psn", "");
		setObjValue("frm_id", "");
		setObjValue("frm_pol", "");
		setObjValue("frm_pod", "");
		setObjValue("frm_opr_cd", "");
		setObjValue("frm_weight", "");
		setObjValue("frm_sztp", "");
		setObjValue("frm_cargo_type", "");
		setObjValue("frm_sztp_iso", "");
		setObjValue("frm_fe", "");
		setObjValue("frm_pod2", "");
		setObjValue("frm_wgt_group", "");
		setObjValue("frm_por", "");
		setObjValue("frm_fpod", "");
		setObjValue("frm_temp", "");
		setObjValue("frm_fdest", "");
		setObjValue("frm_delv_cd", "");
		setObjValue("frm_bl_no", "");
		setObjValue("frm_booking_no", "");
		setObjValue("frm_imdg", "");
		setObjValue("frm_unno", "");
		setObjValue("frm_ovh_slot", "");
		setObjValue("frm_ovh", "");
		setObjValue("frm_ovf_slot", "");
		setObjValue("frm_ovf", "");
		setObjValue("frm_ova_slot", "");
		setObjValue("frm_ova", "");
		setObjValue("frm_ovp_slot", "");
		setObjValue("frm_ovp", "");
		setObjValue("frm_ovs_slot", "");
		setObjValue("frm_ovs", "");
		
		// 선택 CNTR 색상삭제.
		setObjValue("sheet1_old_row", "");
		setObjValue("sheet1_old_col", "");
		setObjValue("sheet3_old_row", "");
		setObjValue("sheet3_old_col", "");
		setObjValue("bg_colr_r", "");
		setObjValue("bg_colr_g", "");
		setObjValue("bg_colr_b", "");
		
		if(clearGb == "NEW"){
			setObjValue("cntr_id", "");

			setObjValue("vvd_port_gb", "");
			setObjValue("vsl_cd", "");
			setObjValue("skd_voy_no", "");
			setObjValue("skd_dir_cd", "");

			// 검색조건 - Combo
			comboObjects[0].RemoveAll();	// VVD
			comboObjects[1].RemoveAll();	// Port
			comboObjects[2].RemoveAll();	// Bay
			comboObjects[3].RemoveAll();	// Bay List
		}
		
		if(clearGb == "CNTR"){
			setObjValue("vvd_port_gb", "");
			setObjValue("vsl_cd", "");
			setObjValue("skd_voy_no", "");
			setObjValue("skd_dir_cd", "");

			// 검색조건 - Combo
			comboObjects[0].RemoveAll();	// VVD
			comboObjects[1].RemoveAll();	// Port
			comboObjects[2].RemoveAll();	// Bay
			comboObjects[3].RemoveAll();	// Bay List
		}
		
		if(clearGb == "VVD"){
			// 검색조건 - Combo
			comboObjects[1].RemoveAll();	// Port
			comboObjects[2].RemoveAll();	// Bay
			comboObjects[3].RemoveAll();	// Bay List
		}
		
		if(clearGb == "PORT"){
			// 검색조건 - Combo
			comboObjects[2].RemoveAll();	// Bay
			comboObjects[3].RemoveAll();	// Bay List
		}

		// 시트.
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
    }

	/* 개발자 작업  끝 */