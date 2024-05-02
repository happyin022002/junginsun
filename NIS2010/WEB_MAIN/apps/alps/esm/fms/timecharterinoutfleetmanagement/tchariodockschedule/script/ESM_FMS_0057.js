/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0057.js
*@FileTitle : D/Dock Schedule Review - Graph
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.30 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
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
     * @class esm_fms_0057 : esm_fms_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0057() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setFormYardName		= setFormYardName;
    }
    
   	/* 개발자 작업	*/


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
	             	
	             	if (!duration_change()) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
					
					ComResetAll();
					inputReadOnly("New");

                break;
                
				case "btn_SavetoFile":
					sheetObject.Down2Excel(0);
                break;
	
				case "btn_Print":
					if(validateForm(sheetObject,formObject)){

						//Print Button 클릭시 필요한 파라미터 생성
						getPrintParam(formObject);
						//RD Open
						rdOpen(rdObjects[0],formObject);

					}
                break;
                    
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
					break;
                    
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 430,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
					break;
                    
				case "btn_ownerpop":
					ComOpenPopup("ESM_FMS_0083.do", 500, 375,"setOwner", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0083");
					break;
					
				case "btn_yard":
     				ComOpenPopup("ESM_FMS_0082.do", 300, 340, "setFormYardName", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0082");
     				break;

     			case "btn_fr_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('year');
					cal.select(form.fr_duration, 'yyyy');
     				
					break;					

     			case "btn_to_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('year');
					cal.select(form.to_duration, 'yyyy');

					break;
					
     			case "btn_ydClr":
     				form.shpYdNm.value = "";
     				form.ydSeq.value = "";
     				break;

     			case "btn_ownrclr":
     				form.ownr_nm.value = "";
     				form.ownr_seq.value = "";
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
     * Print Button 클릭시 필요한 파라미터 생성 <br>
     * @param {Form Object} formObject     	form name
     **/
    function getPrintParam(formObject) {

		formObject.flet_dck_svey_tp_nm.value = formObject.flet_dck_svey_tp_cd.options[formObject.flet_dck_svey_tp_cd.selectedIndex].text;
		formObject.reflection_nm.value = formObject.reflection_cd.options[formObject.reflection_cd.selectedIndex].text;
		
	}
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

    	form.vsl_cd.readOnly = readOnly;
    	form.lane_cd.readOnly = readOnly;
    	form.flet_ctrt_tp_cd.disabled = readOnly;
    	form.vsl_dznd_capa_fr.readOnly = readOnly;
    	form.vsl_dznd_capa_to.readOnly = readOnly;
    	form.flet_dck_svey_tp_cd.disabled = readOnly;
		form.fr_duration.readOnly = readOnly;
		form.to_duration.readOnly = readOnly;
    	form.reflection_cd.disabled = readOnly;
    	
    	document.images["btn_vslpop"].name = img+"btn_vslpop";
    	document.images["btn_lanepop"].name = img+"btn_lanepop";
    	document.images["btn_ownerpop"].name = img+"btn_ownerpop";
    	document.images["btn_fr_duration"].name = img+"btn_fr_duration";
    	document.images["btn_to_duration"].name = img+"btn_to_duration";
    	
    	form.btn_vslpop.style.cursor = cursor;
    	form.btn_lanepop.style.cursor = cursor;
    	form.btn_ownerpop.style.cursor = cursor;
    	form.btn_fr_duration.style.cursor = cursor;
    	form.btn_to_duration.style.cursor = cursor;

    }
    
	/**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
	}

    /**
	 * Lane Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.lane_cd.value = aryPopupData[0][3];
	}
    
    /**
	 * Owner 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setOwner(aryPopupData){
		form.ownr_seq.value = aryPopupData[0][3];
		form.ownr_nm.value = aryPopupData[0][4];
        form.btn_ownrclr.checked = true;
	}
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value = "";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    
    /**
     * LaneCd변경 시 해당 Lane Code 체크. <br>
     **/
    function lane_cd_change() {
    	if (form.lane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'lane_cd');
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


        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();

		//RD
		initRdConfig(rdObjects[0]);

    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
        
        //Contract Type의 TO 삭제
        removeContractTP();
		
		sheetObj.WaitImageVisible = true;   
    }
	
	/**
     * 페이지에 있는 RD Object를 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
     * @param {rdObject} rdObject    RD Object
     **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
//		Rdviewer.AutoAdjust = true;
//		Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 0;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        //2010.11.24 이상민 vsl_cd 는 eng_press -> engnum_press
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Vessel Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기
        
        axon_event.addListener  ('keypress', 'eng_keypress' , 'lane_cd');			//- Lane Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'lane_cd_change', 'lane_cd');			//- Lane Code 입력 후 Name 정보 가져오기

        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_fr');	//- Vessel Size 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_to');	//- Vessel Size 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Duration 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Duration 입력 후 From~To 비교

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        
        //Contract Type의 TO 삭제
        //removeContractTP();

    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
			case "fr_duration":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			case "to_duration":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;

			case "vsl_dznd_capa_fr":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			case "vsl_dznd_capa_to":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			default:
				//ComAddSeparator(event.srcElement);
				ComChkObjValid(event.srcElement);
    	}
    }

	/**
     * Vessel Size 입력 후 From~To 비교
     **/
    function vsl_size_change() {

		var formObj = document.form;
		var vsl_dznd_capa_fr = formObj.vsl_dznd_capa_fr.value;
		var vsl_dznd_capa_to = formObj.vsl_dznd_capa_to.value;
		
		if (vsl_dznd_capa_fr != '' && vsl_dznd_capa_to != '') {
			if (parseFloat(vsl_dznd_capa_fr) > parseFloat(vsl_dznd_capa_to)) {
				ComAlertFocus(formObj.vsl_dznd_capa_fr, ComGetMsg('FMS01714'));
				formObj.vsl_dznd_capa_to.value = '';
			}
		}
	}	

	/**
     * Duration 입력 후 From~To 비교
     **/
    function duration_change() {

		var formObj = document.form;
		var fr_duration = formObj.fr_duration.value;
		var to_duration = formObj.to_duration.value;
		
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
				return false;
			}
			
		}

		return true;

	}	

	/**
     * Contract Type의 TO 삭제
     **/
    function removeContractTP() {
		for (i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
			if (document.form.flet_ctrt_tp_cd.options[i].value == "TO") {
				document.form.flet_ctrt_tp_cd.remove(i);
				break;
			}
		}
		
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
                    style.height = 350;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "Seq|TEU|Vessel\nCode|Last Dock Duration|Last Dock Duration|Last\nLOC|Last Ship Yard|Last Dock Type|Next Dock Duration|Next Dock Duration|Next\nLOC|Next Ship Yard|Next Dock Type|Class Recommendation|Class Recommendation";
					var HeadTitle2 = "Seq|TEU|Vessel\nCode|From|To|Last\nLOC|Last Ship Yard|Last Dock Type|From|To|Next\nLOC|Next Ship Yard|Next Dock Type|From|To";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,    40,    daCenter,  true,    "Seq");
                    InitDataProperty(0, cnt++ , dtData,	  40,    daCenter,  true,    "vsl_dznd_capa",     	 	false,          "",      dfNone,    0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   60,    daCenter,  true,    "vsl_cd",    				false,          "",      dfNone,    0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   80,    daCenter,  false,   "last_dck_fm_dt",     	 	false,          "",      dfDateYmd, 0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData,   80,    daCenter,  false,   "last_dck_to_dt",      	false,          "",      dfDateYmd, 0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   50,    daCenter,  true,    "last_dck_loc_cd",     	false,          "",      dfNone,    0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   110,   daCenter,  true,    "last_ship_yard",     		false,          "",      dfNone,    0,     false,		false);
					InitDataProperty(0, cnt++ , dtCombo,  127,   daLeft,  	true,    "last_flet_dck_svey_tp_cd",false,          "",      dfNone,  	0,     false,		false);

					InitDataProperty(0, cnt++ , dtData,   75,    daCenter,  false,   "next_dck_fm_dt",     		false,          "",      dfDateYmd, 0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   75,    daCenter,  false,   "next_dck_to_dt",     	 	false,          "",      dfDateYmd, 0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   50,    daCenter,  true,    "next_dck_loc_cd",     	false,          "",      dfNone,	2,     false,		false);
					InitDataProperty(0, cnt++ , dtData,   110,   daCenter,  true,    "next_ship_yard",     		false,          "",      dfNone,    0,     false,		false);
					InitDataProperty(0, cnt++ , dtCombo,  127,   daLeft,  	true,    "next_flet_dck_svey_tp_cd",false,          "",      dfNone,    0,     false,		false);
                                                                                                                                 
					InitDataProperty(0, cnt++ , dtData,   80,    daCenter,  false,   "rec_dck_fm_dt",    		false,          "",      dfDateYmd, 0,     false,		false);				
					InitDataProperty(0, cnt++ , dtData,   80,    daCenter,  false,   "rec_dck_to_dt",    		false,          "",      dfDateYmd, 0,     false,		false);				
					
               }

                break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){

	        		formObj.f_cmd.value = SEARCH;

	        	   	sheetObj.DoSearch("ESM_FMS_0057GS.do", FormQueryString(formObj));

       	   	  		//inputReadOnly("Search");
	  	   	  	}	

                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					CoFmsGetCombo("FORM", formObj, sheetObj, "CD01748:CD01513","flet_dck_svey_tp_cd:flet_ctrt_tp_cd", "flet_dck_svey_tp_cdText:flet_ctrt_tp_cdText");
					getDockTPCombo(sheetObj);					

	    		} else if (Col == "vsl_cd") {
					
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "lane_cd") {
					
					formObj.f_cmd.value = SEARCH05;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName != "undefined" && cdName != "" ) {
					} else {
						formObj.lane_cd.value = "";
						ComAlertFocus(formObj.lane_cd, ComGetMsg("FMS01237"));
						return;
					}
				}	
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }

	/**
     * D/Dock TP의 Combo 정보 구하기
     **/
    function getDockTPCombo(sheetObj) {
    	var obj = document.form.flet_dck_svey_tp_cd;

		var comboCode = '';
		var comboText = '';
		
		for (i=0;i<obj.length;i++) {
			if (obj.options[i].value != "") {
				comboCode += obj.options[i].value + "|"
				comboText += obj.options[i].text + "|"
			}
		}

        sheetObj.InitDataCombo(0, "last_flet_dck_svey_tp_cd", comboText.substring(0,comboText.length-1), comboCode.substring(0,comboCode.length-1));
        sheetObj.InitDataCombo(0, "next_flet_dck_svey_tp_cd", comboText.substring(0,comboText.length-1), comboCode.substring(0,comboCode.length-1));
		
	}	
    
    /**
	 * Yard 팝업창에서 선택한 Ship Yard Name과 시퀀스를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFormYardName(aryPopupData){
		form.ydSeq.value = aryPopupData[0][3];
		form.shpYdNm.value = aryPopupData[0][4];
		form.btn_ydClr.checked = true;
	}
    
	function rdOpen(rdObject,formObject){
		var Rdviewer = rdObject ;

		queryStr = RD_FormQueryString(formObject,1);
		
		var rdParam = '/rv '+queryStr;

		rdParam += " sqlQuery["+getSqlQuery(formObject)+"]";

		var rdFile = 'ESM_FMS_058.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/'+rdFile, RDServer + rdParam + " /rop /rprintnexit ");

		
	}	
    /**
     * Print Button 클릭시 필요한 파라미터 생성 <br>
     * @param {Form Object} formObject     	form name
     **/
    function getSqlQuery(formObject) {

        var sqlStr =  "  select  vsl_cd,																																			            \n"
                   +  "          slan_cd,                                                                                                                                                       \n"
                   +  "          vsl_dznd_capa,                                                                                                                                                 \n"
                   +  "          last_dck_fm_dt,                                                                                                                                                \n"
                   +  "          last_dck_to_dt,                                                                                                                                                \n"
                   +  "          last_dck_loc_cd,                                                                                                                                               \n"
                   +  "          last_flet_dck_svey_tp_cd,                                                                                                                                      \n"
                   +  "          next_dck_fm_dt,                                                                                                                                                \n"
                   +  "          next_dck_to_dt,                                                                                                                                                \n"
                   +  "          next_dck_loc_cd,                                                                                                                                               \n"
                   +  "          next_flet_dck_svey_tp_cd,                                                                                                                                      \n"
                   +  "          rec_dck_fm_dt,                                                                                                                                                 \n"
                   +  "          rec_dck_to_dt                                                                                                                                                  \n"
                   +  "  from    (                                                                                                                                                              \n"
                   +  "          select a.vsl_cd,                                                                                                                                               \n"
                   +  "                  d.slan_cd,                                                                                                                                             \n"
                   +  "                  b.vsl_dznd_capa,                                                                                                                                       \n"
                   +  "                  a.dck_fm_dt last_dck_fm_dt,                                                                                                        \n"
                   +  "                  a.dck_to_dt last_dck_to_dt,                                                                                                        \n"
                   +  "                  a.dck_loc_cd last_dck_loc_cd,                                                                                                                          \n"
                   +  "                  cd1.intg_cd_val_dp_desc last_flet_dck_svey_tp_cd,                                                                                                      \n"
                   +  "                  na.next_dck_fm_dt next_dck_fm_dt,                                                                                                  \n"
                   +  "                  na.next_dck_to_dt next_dck_to_dt,                                                                                                  \n"
                   +  "                  na.next_dck_loc_cd,                                                                                                                                    \n"
                   +  "                  cd2.intg_cd_val_dp_desc next_flet_dck_svey_tp_cd,                                                                                                      \n"
                   +  "                  nc.dck_fm_dt rec_dck_fm_dt,                                                                                                        \n"
                   +  "                  nc.dck_to_dt rec_dck_to_dt                                                                                                         \n"
                   +  "           from 	 fms_dck_skd a, fms_contract b,                                                                                                                     	\n"
                   +  "                  (select vsl_cd, flet_ctrt_no                                                                                                                       	\n"
                   +  "                  from (                                                                                                                                             	\n"
                   +  "                          select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     	\n"
                   +  "                          from fms_contract                                                                                                                          	\n"
                   +  "                          where flet_ctrt_tp_cd <> 'TO'                                                                                                              	\n"
                   +  "                      )                                                                                                                                              	\n"
                   +  "                  where row_num = 1                                                                                                                                  	\n"
                   +  "                  union all                                                                                                                                          	\n"
                   +  "                  select vsl_cd, flet_ctrt_no                                                                                                                        	\n"
                   +  "                  from (                                                                                                                                             	\n"
                   +  "                          select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     	\n"
                   +  "                          from fms_id_vsl a                                                                                                                          	\n"
                   +  "                          where not exists (select null from fms_contract where vsl_cd = a.vsl_cd)                                                                   	\n"
                   +  "                      )                                                                                                                                              	\n"
                   +  "                  where row_num = 1                                                                                                                                  	\n"
                   +  "                  ) c,                                                                                                                                               	\n"
                   +  "                  (select vsl_cd, slan_cd                                                                                                                            	\n"
                   +  "                   from (                                                                                                                                            	\n"
                   +  "                      select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                               		\n"
                   +  "                      from vsk_vsl_port_skd                                                                                                                      		\n"
                   +  "                      where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                         		\n"
                   +  "                  )                                                                                                                                              		\n"
                   +  "                   where lane_num = 1) d,                                                                                                                            	\n"
                   +  "                  (select a.vsl_cd, a.dck_fm_dt,                                                                                                                     	\n"
                   +  "                          b.dck_fm_dt next_dck_fm_dt, b.dck_to_dt next_dck_to_dt, b.dck_loc_cd next_dck_loc_cd, b.flet_dck_svey_tp_cd next_flet_dck_svey_tp_cd       	\n"
                   +  "                   from   (                                                                                                                                          	\n"
                   +  "                          select vsl_cd, dck_fm_dt, row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num                                            	\n"
                   +  "                          From fms_dck_skd                                                                                                                           	\n"
                   +  "                          where dck_sel_cd = 'E') a,                                                                                                                 	\n"
                   +  "                         (                                                                                                                                           	\n"
                   +  "                          select vsl_cd, dck_fm_dt, dck_to_dt, dck_loc_cd, flet_dck_svey_tp_cd,                                                                      	\n"
                   +  "                                  row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num                                                              	\n"
                   +  "                          From fms_dck_skd                                                                                                                           	\n"
                   +  "                          where dck_sel_cd = 'E') b                                                                                                                  	\n"
                   +  "                   where a.vsl_cd = b.vsl_cd                                                                                                                         	\n"
                   +  "                   and   a.row_num = b.row_num-1) na,                                                                                                                	\n"
                   +  "                  (select vsl_cd, dck_fm_dt, dck_to_dt                                                                                                               	\n"
                   +  "                   from   fms_dck_skd                                                                                                                                	\n"
                   +  "                   where dck_sel_cd = 'C') nc, com_intg_cd_dtl cd1, com_intg_cd_dtl cd2                                                                              	\n";

			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                          \n"
						+ "			 	where flet_mgmt_ownr_vndr_seq = "+formObject.ownr_seq.value+") e                                                                                        \n";
			} 

			sqlStr += "					where a.vsl_cd = c.vsl_cd(+)                                                                                                                            \n"
					+ "					and   a.vsl_cd = d.vsl_cd(+)                                                                                                                            \n"
					+ "					and   b.flet_ctrt_no(+) = c.flet_ctrt_no                                                                                                                \n"
                    + "                 and   a.vsl_cd = na.vsl_cd(+)                                                                                                                          	\n"
                    + "                 and   a.dck_fm_dt = na.dck_fm_dt(+)                                                                                                                    	\n"
                    + "                 and   a.vsl_cd = nc.vsl_cd(+)                                                                                                                          	\n"
                    + "                 and   a.flet_dck_svey_tp_cd = cd1.intg_cd_val_ctnt(+)                                                                                                  	\n"
                    + "                 and   na.next_flet_dck_svey_tp_cd = cd2.intg_cd_val_ctnt(+)                                                                                            	\n"
                    + "                 and   cd1.intg_cd_id = 'CD01748'                                                                                                                    	\n"
                    + "                 and   cd2.intg_cd_id(+) = 'CD01748'                                                                                                                 	\n";

			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                        \n";
			}

			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                  \n";
			}  

			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                  \n";
			}

			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                        \n";
			} 

			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq = e.vndr_seq                                                                                                                                   \n";
			}

			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                          \n"
					+ "			and   a.dck_sel_cd = 'E'                                                                                                                                        \n"
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                \n";

			if (formObject.reflection_cd.value == "I") { 
				sqlStr += "		and a.phs_out_dt <= '"+formObject.to_duration.value+"'||'1231' and a.phs_in_dt >= '"+formObject.fr_duration.value+"'                                          \n";
			} else {
				sqlStr += "		and a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')\n";
			}

            sqlStr += "          union all                                                                                                                                                      \n"
                    + "          select a.vsl_cd,                                                                                                                                               \n"
                    + "                 d.slan_cd,                                                                                                                                              \n"
                    + "                 b.vsl_dznd_capa,                                                                                                                                        \n"
                    + "                 null last_dck_fm_dt,                                                                                                                                    \n"
                    + "                 null last_dck_to_dt,                                                                                                                                    \n"
                    + "                 null last_dck_loc_cd,                                                                                                                                   \n"
                    + "                 null last_flet_dck_svey_tp_cd,                                                                                                                          \n"
                    + "                 null next_dck_fm_dt,                                                                                                                                    \n"
                    + "                 null next_dck_to_dt,                                                                                                                                    \n"
                    + "                 null next_dck_loc_cd,                                                                                                                                   \n"
                    + "                 null next_flet_dck_svey_tp_cd,                                                                                                                          \n"
                    + "                 a.dck_fm_dt rec_dck_fm_dt,                                                                                                          \n"
                    + "                 a.dck_to_dt rec_dck_to_dt                                                                                                           \n"
                    + "           from fms_dck_skd a, fms_contract b,                                                                                                                    		\n"
                    + "                (select vsl_cd, flet_ctrt_no                                                                                                                       		\n"
                    + "                 from (                                                                                                                                             		\n"
                    + "                         select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     		\n"
                    + "                         from fms_contract                                                                                                                          		\n"
                    + "                         where flet_ctrt_tp_cd <> 'TO'                                                                                                              		\n"
                    + "                     )                                                                                                                                              		\n"
                    + "                 where row_num = 1                                                                                                                                  		\n"
                    + "                 union all                                                                                                                                               \n"
                    + "                 select vsl_cd, flet_ctrt_no                                                                                                                             \n"
                    + "                 from (                                                                                                                                                  \n"
                    + "                              select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                     \n"
                    + "                              from fms_id_vsl a                                                                                                                          \n"
                    + "                              where not exists (select null from fms_contract where vsl_cd = a.vsl_cd)                                                                   \n"
                    + "                          )                                                                                                                                              \n"
                    + "                 where row_num = 1                                                                                                                                  \n"
                    + "                 ) c,                                                                                                                                               \n"
                    + "                 (select vsl_cd, slan_cd                                                                                                                            \n"
                    + "                  from (                                                                                                                                            \n"
                    + "                              select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                               \n"
                    + "                              from vsk_vsl_port_skd                                                                                                                      \n"
                    + "                              where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                         \n"
                    + "                          )                                                                                                                                              \n"
                    + "                  where lane_num = 1) d                                                                                                                             \n";

			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                          \n"
						+ "				where flet_mgmt_ownr_vndr_seq = "+formObject.ownr_seq.value+") e                                                                                        \n";
			} 
			sqlStr += "			where a.vsl_cd = c.vsl_cd(+)                                                                                                                                    \n"
					+ "			and   a.vsl_cd = d.vsl_cd(+)                                                                                                                                    \n"
					+ "			and   b.flet_ctrt_no(+) = c.flet_ctrt_no                                                                                                                        \n";
			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                        \n";
			}

			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                  \n";
			}  

			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                  \n";
			}

			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                        \n";
			} 

			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq = e.vndr_seq                                                                                                                                   \n";
			}

			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                          	 \n"
					+ "			and   a.dck_sel_cd = 'C'                                                                                                                                        	 \n"
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                	 \n"
                    + "         and   not exists (select null from fms_dck_skd where vsl_cd = a.vsl_cd and dck_sel_cd = 'E')                                                           				 \n"
                    + "         and   a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')\n"
                    + "  )     ";                                                                                                                                     

		return sqlStr;
		
	}

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "vsl_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "last_dck_loc_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "next_dck_loc_cd", "Courier New"); 	
	}	

	/* 개발자 작업  끝 */    