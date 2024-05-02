/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0019.js
*@FileTitle : Vessel SKD & Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.13 김기종
* 1.0 Creation
==========================================================
 History
* 2013.03.25 김태경 [CHM-20132554] Vessel Schedule  Inquiry 조회 보완 요청 - Multi Lane 클릭시 복수의 Lane 을 선택 할수 있도록 보완
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
     * @class esm_bkg_0019 : esm_bkg_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0019() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initComboSetVal		= initComboSetVal;
    	this.checkKeyInSlanCd	    = checkKeyInSlanCd;
    	this.callDatePop			= callDatePop;
    	this.setCallBack0B2         = setCallBack0B2;
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
    	var sheetObject = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
 			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_select":
					//@ 2014.10.07  추가 된 칼럼으로 기존에 리턴 받아서 처리하던 화면에서 버그 발생을 피하기 위해,
					//               callParentFunc2 JSP에 추가 함  
					//comPopupOK();
					callParentFunc2();
					break;	
				case "btn_0B2pop":
					openWindowVvd(formObject);
					break;
				case "btn_close":
					window.close();
					break;
				case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);						
 					break;
 			} // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e);
     		}
     	}
    }
     
    function openWindowVvd(formObj) {
    	var formObj = document.form;
  		var param = "";
  	    param += "vvd_cd="+ComGetObjValue(formObj.vsl_cd);
  	    param += "&lane_cd="+ComGetObjValue(formObj.slan_cd);
  	    param += "&loc_cd="+ComGetObjValue(formObj.vps_port_pol);
      
  		ComOpenPopup('/hanjin/COM_ENS_0B2.do?'+param , 780, 465, 'getCOM_ENS_0B2', '1,0,1,1,1,1,1,1', true);
 	}
     
    /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
  	}

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
 	    
        // IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
 	    
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		initControl();
		
		/*if (formObj.vsl_cd.value != "" 
		 	&& formObj.vps_port_pol.value !="" 
		 		&& formObj.vps_port_pod.value !=""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}*/ 	    
	}
	 
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;
    	if (formObj.vsl_cd.value != "" 
 		 		&& formObj.vps_port_pol.value !="" 
 		 		&& formObj.vps_port_pod.value !=""){
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}	 
    }
     
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
		var formObject = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
	    //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
	    axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- 키보드 입력할때
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
	    
	    //영어대문자 사용, 숫자 + 특수포함 시
	    document.form.slan_cd.ValidChar(2,3);
	}
	 
	/**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
    function initCombo(comboObj) {
     	comboObj.DropHeight = 150;  
     	
     	// combo 별 Multi Select 기능 
     	with (comboObj) {
     		if(comboObj.id == "slan_cd"){
     	 		MultiSelect = true;
    	 	 	UseEdit = false;
     	 	} else {
     	 		MultiSelect = false;
     	 		UseAutoComplete = true; 
     	 		UseEdit = false;	 	 			
     	 	}
    	}
    }  
      
	/**
      * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
      */
    function obj_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){    	
	    	case "pf_etd_from_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "pf_etd_to_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "pf_etb_from_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "pf_etb_to_dt":
	    		ComClearSeparator(event.srcElement);
    			break;	
    		default:
    			break;
    			//return;
    			//ComAddSeparator(event.srcElement);
    			//ComChkObjValid(event.srcElement);
    	}
    }
    
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     */
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){    	
	    	case "pf_etd_from_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "pf_etd_to_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "pf_etb_from_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "pf_etb_to_dt":
	    		ComAddSeparator(event.srcElement);
    			break;	
    		default:
    			break;
    			//ComAddSeparator(event.srcElement);
    			//ComChkObjValid(event.srcElement);
    	}
    }
    
	/**
	 * Lane 콤보에 입력값이 부정확할 경우 메시지처리.
	 **/
	function checkKeyInSlanCd(obj){
		var formObject = document.form;
		if (obj.text != ''){
			if (obj.FindIndex(obj.text,0) == -1 && obj.text.length < 4 ){
				ComShowMessage('no matched lane!');
				obj.text= "";
				obj.focus();
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
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);
                     
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Sel.||Lane|Carrier Code|Vessel Name|VVD|POL|Terminal|CCT|CCT|ETB|ETB|ETD|ETD|POD|Terminal|ETB|ETB|T/Time|Remark|Update Time|Update Time|clpt_ind_seq|clpt_seq|pod_clpt_ind_seq|pod_clpt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,	40,   daCenter,    false,  	"radio", 			false,    "",      dfNone, 		0, 	   true, 		true);
                    InitDataProperty(0, cnt++ , dtHidden, 		0, 	  daCenter,    false,	"check", 			false, 	  "", 	   dfNone, 		0, 	   true, 		true);
          			InitDataProperty(0, cnt++ , dtData,      	50,   daCenter,    false,   "lane",         	false,    "",      dfNone, 		0,     false,       true);
          			InitDataProperty(0, cnt++ , dtData,			100,  daCenter,	   false,	"crr_cd",			false,	  "",	   dfNone,		0,	   false,		true);
          			InitDataProperty(0, cnt++ , dtData,			120,  daLeft,	   false,	"vsl_eng_nm",		false,	  "",	   dfNone,		0,	   false,		true);
                    InitDataProperty(0, cnt++ , dtData, 		80,   daCenter,    false,   "vvd",          	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	60,   daCenter,    false,   "pol",          	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	80,   daCenter,    false,   "terminal",     	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData, 		70,   daCenter,    false,   "cct_dt",       	false,    "",      dfDateYmd, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daCenter,    false,   "cct_tm",         	false,    "",      dfTimeHm,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,    false,   "etb_dt",       	false,    "",      dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daCenter,    false,   "etb_tm",         	false,    "",      dfTimeHm,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,    false,   "etd_dt",         	false,    "",      dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daCenter,    false,   "etd_tm",         	false,    "",      dfTimeHm,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData, 		60,   daCenter,    false,   "pod",          	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	80,   daCenter,    false,   "terminal2",     	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,    false,   "etb2_dt",         	false,    "",      dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daCenter,    false,   "etb2_tm",         	false,    "",      dfTimeHm,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	70,  daCenter,    false,   "t_time",	      	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	180,  daLeft,    false,   "vps_rmk",   	   	false,    "",      dfNone, 		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	70,   daCenter,    false,   "update_dt",	 	false,    "",      dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daCenter,    false,   "update_tm",	 	false,    "",      dfTimeHm,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       70,   daCenter,    false,   "clpt_ind_seq",		false,    "",      dfNone,		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,    false,   "clpt_seq",	 		false,    "",      dfNone,		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       70,   daCenter,    false,   "pod_clpt_ind_seq",	false,    "",      dfNone,		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,    false,   "pod_clpt_seq",	 	false,    "",      dfNone,		0,     false,       true);
 					ShowButtonImage = 2;
                }
            	break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0019GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""));
				}	
				break;
				
			case IBCLEAR:      //조회
				formObj.f_cmd.value = SEARCH01;
			 	formObj.slan_cd.UseEdit = true;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0019GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem(sXml, formObj.slan_cd, "vsl_slan_cd", "vsl_slan_nm");
				break;	
				
			case IBSEARCHAPPEND:  // 페이징 조회                
                formObj.f_cmd.value = SEARCH;              
                sheetObj.DoSearch4Post("ESM_BKG_0019GS.do", FormQueryString(formObj), "iPage=" + PageNo, true);  
                break;	
                
			case "btn_confirm":
				callPopupOK(sheetObject);
				break;

			case "btn_close":
				window.close();				
				break;
				
			case "btn_0B2pop":
				window.close();
				break;	
				
			case "btns_calendar1":
	   	        var cal = new calendarPopup();
	       		cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
	   	        break;
	
	   	    case "btns_calendar2":
	   	        var cal = new calendarPopup();
	       		cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
	   	        break;
	   	        
	   	    case IBDOWNEXCEL:      // 입력
				sheetObj.SpeedDown2Excel(-1);
				break;	    
        }
    }
     
  	/**
     * ETD,ETB 기간 선택 달력 띄우기
     */
  	function callDatePop(val){
  		var cal = new ComCalendarFromTo();
  		if (val == 'ETD'){
  			cal.select(form.pf_etd_from_dt,  form.pf_etd_to_dt,  'yyyy-MM-dd');
  		}else{
  			cal.select(form.pf_etb_from_dt,  form.pf_etb_to_dt,  'yyyy-MM-dd');
  		}
  	}
  
  	function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 
  	 
  	/**
  	 * Vessel SKD & Code Inquiry부분.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function getCOM_ENS_0B2(aryPopupData) {
  		var formObject = document.form;
  		formObject.vsl_cd.value = aryPopupData[0][7];
  	} 
  	
    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if (!ComChkValid(formObj)) return false;
        	if (formObj.vsl_cd.value == "" 
        		 	&& formObj.vps_port_pol.value=="" 
        		 	&& formObj.vps_port_pod.value ==""){        	
        		//ComShowMessage('VVD,POL,POD 항목 중 하나는 필수 입력사항입니다!');
        		if (sAction == IBSEARCH){
        			ComShowCodeMessage('BKG00626', 'POL or POD or VVD');
        			formObj.vps_port_pol.focus();
        			//ComShowMessage(msgs['BKG00829']);
        		}
        		return false;
        	}
        	/*
        	if (!ComIsNull(formObj.pf_etd_from_dt) 
	  			&& !ComIsNull(formObj.pf_etd_to_dt) 
	  			&& ComGetDaysBetween(formObj.pf_etd_from_dt.value, formObj.pf_etd_to_dt.value) > 31){
           		 
     			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
     			formObj.fr_dt.focus();
     			return false;
     		}
        	if (!ComIsNull(formObj.pf_etb_from_dt) 
 	  			&& !ComIsNull(formObj.pf_etb_to_dt) 
 	  			&& ComGetDaysBetween(formObj.pf_etb_from_dt.value, formObj.pf_etb_to_dt.value) > 31){
            		 
      			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
      			formObj.fr_dt.focus();
      			return false;
      		}*/        	 
        }
        return true;
    }
     
	/* 개발자 작업  끝 */