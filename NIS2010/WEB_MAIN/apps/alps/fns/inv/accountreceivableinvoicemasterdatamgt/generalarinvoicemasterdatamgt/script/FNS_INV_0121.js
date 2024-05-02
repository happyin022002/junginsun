/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0121.jsp
*@FileTitle : Revenue & Processing VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 1.0 Creation
* 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
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
     * @class fns_inv_0121 : fns_inv_0121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0121() {
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
	
	//IBMultiCombo
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            var srcObj = window.event.srcElement;


           switch(srcName) {
	        	case "btns_calendar1": //달력 버튼
		     		if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendar();
			            cal.setDisplayType('month');
			            cal.select(form.r_yrmon_fm, 'yyyy-MM');
		     		}
				break;
			
	        	case "btns_calendar2": //달력 버튼
		     		if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendar();
			            cal.setDisplayType('month');
			            cal.select(form.r_yrmon_to, 'yyyy-MM');
		     		}
				break;

	        	case "btns_calendar3": //달력 버튼
		     		if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendar();
			            cal.setDisplayType('month');
			            cal.select(form.p_yrmon_fm, 'yyyy-MM');
		     		}
				break;
			
	        	case "btns_calendar4": //달력 버튼
		     		if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendar();
			            cal.setDisplayType('month');
			            cal.select(form.p_yrmon_to, 'yyyy-MM');
		     		}
				break;				

                case "btn_Retrieve":
                	if(ComGetObjValue(formObject.option_value) == "REV"){
                		doActionIBSheet(sheetObject1,formObject,IBSEARCH);	
                	}else{
                		doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                	}
                    break;

                case "btn_New":
					initControl();
                    break;

                case "btn_DownExcel":
					if(ComGetObjValue(formObject.option_value) == "REV"){
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else{
						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					}
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

    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    function loadPage() {

    	var formObj = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        
  		ComSetObjValue(formObj.option_value, "REV");

  		setDefaultDateValue();
  		
  		initAxonControl();
  		
		//Combo 초기화
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//DATA 초기화
		var formObj = document.form;
    	doActionIBCombo(sheetObjects[1], formObj, comboObjects[0], COMMAND02);
    	doActionIBCombo(sheetObjects[1], formObj, comboObjects[1], COMMAND02);
    	comboObjects[1].Index = "0";
    }
    
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
		
		//DATA 초기화
		var formObj = document.form;
		
		for(var k=0;k<comboObjects.length;k++){
	        comboObjects[k].RemoveAll(); 
		}
    	doActionIBCombo(sheetObjects[1], formObj, comboObjects[0], COMMAND02);
    	doActionIBCombo(sheetObjects[1], formObj, comboObjects[1], COMMAND02);
    	comboObjects[1].Index = "0";

	}
	
	function initSearchControls(){
		setDefaultDateValue();
		setDefaultValue();
		setDefaultDisplay();
	}
	function initResultControls() {
		if(document.form.option_value.value == "REV"){
			sheetObjects[0].RemoveAll();
		}else{
			sheetObjects[1].RemoveAll();	
		}
		
	}
	
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    switch(comboObj.id) {  
   	    	case "bc_div_cd": 
   	    		with (comboObj) { 
					MultiSelect = true;
					SetColAlign("left");        
					SetColWidth("80");
					DropHeight = 160;
   		    	}
   	    		break; 
   				
   	    	case "vvd_tp":
   	    		with (comboObj) { 
   					MultiSelect = false;
					SetColAlign("left");        
					SetColWidth("80");
					DropHeight = 160;
   		    	}
   				break;
   	    }
   	}	

    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
					// 높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|Rev Month|VVD|S/LANE|R/LANE|REV PORT|COM_LVL|COM_FLAG|VOY_TP|DEL|CRE_USER|CRE_DT|EVNT_DT";
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE,	SAVENAME,  		KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0,	cnt++ ,	dtData,		70,		daCenter,	true,		"rev_yrmon",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,	daCenter,	true,		"vvd",				false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"slan_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"rlane_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"rev_port_cd",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"vvd_com_lvl",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"com_vvd_flg",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"voy_tp_cd",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"delt_flg",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,	daCenter,	true,		"cre_usr_id",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,	daCenter,	true,		"cre_dt",			false,		"",			dfDateYmd,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		120,	daCenter,	true,		"eai_evnt_dt",		false,		"",			dfNone,			0,			false);
					                                                                                                                     	

               }
			break;

             case 2:      //sheet2 init
             with (sheetObj) {
					// 높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|Closing Month|Rev Month|VVD|VVD Type|IOC DIV|B/C|R/LANE|CRE_DATE|VST_DT|VED_DT";
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE,	SAVENAME,  		KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"exe_yrmon",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"rev_yrmon",		false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"vvd",				false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"estm_vvd_tp_cd",	false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		70,			daCenter,	true,		"estm_ioc_div_cd",	false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		60,			daCenter,	true,		"estm_bc_div_cd",	false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		80,			daCenter,	true,		"rlane_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		150,		daCenter,	true,		"cre_dt",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"vst_dt",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"ved_dt",			false,		"",			dfNone,			0,			false);
					                                                                                                                     	

            }
			break;			
        }
    }

	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg = false;
    	sheetObj.WaitImageVisible = false;
   	 
    	
    	formObj.f_cmd.value = formCmd;
		switch(comboObj.id) {
	        case "bc_div_cd":
	        	formObj.code.value = "CD00705";
	        	var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));

	        	var data = ComGetEtcData(sXml, "COMMON_CD");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					addComboItem(comboObj,comboItems);
				}
				break;
	        case "vvd_tp":
	        	formObj.code.value = "CD00835";
	        	var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));

	        	var data = ComGetEtcData(sXml, "COMMON_CD");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					addComboItem(comboObj,comboItems);
				}
				break;
        }
        sheetObj.WaitImageVisible = true;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var formObj = document.form;
 		
 		switch(comboObj.id) {
 			case "bc_div_cd":
 				comboObj.InsertItem(0, "All", "ALL");
	  			comboObj.CheckIndex(0) = true;
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split("=");
		  			comboObj.InsertItem(i+1, comboItem[1], comboItem[0]);
		  			comboObj.CheckIndex(i+1) = true;
		  	   	}
		  		break;
 			case "vvd_tp":
 				comboObj.InsertItem(0, "All", "ALL");
	  			for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split("=");
		  			comboObj.InsertItem(i+1, comboItem[1], comboItem[0]);
		  	   	}
		  		break;
 		}
 	}           
    function doActionIBSheet(sheetObj,formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        			
			case IBSEARCH:      //조회
				ComSetObjValue(formObj.f_cmd, SEARCH);
			
				if(ComGetObjValue(formObj.option_value) == "REV"){
					ComSetObjValue(formObj.yrmon_fm, ComGetObjValue(formObj.r_yrmon_fm));
					ComSetObjValue(formObj.yrmon_to, ComGetObjValue(formObj.r_yrmon_to));
					ComSetObjValue(formObj.del_cd, ComGetObjValue(formObj.r_del_cd));
					ComSetObjValue(formObj.s_vvd_cd, ComGetObjValue(formObj.r_s_vvd_cd));
					ComSetObjValue(formObj.s_slan_cd, ComGetObjValue(formObj.r_s_slan_cd));
					ComSetObjValue(formObj.s_rlane_cd, ComGetObjValue(formObj.r_s_rlane_cd));
				}else{
					ComSetObjValue(formObj.yrmon_fm, ComGetObjValue(formObj.p_yrmon_fm));
					ComSetObjValue(formObj.yrmon_to, ComGetObjValue(formObj.p_yrmon_to));
					ComSetObjValue(formObj.s_vvd_cd, ComGetObjValue(formObj.p_s_vvd_cd));
					ComSetObjValue(formObj.s_rlane_cd, ComGetObjValue(formObj.p_s_rlane_cd));
					ComSetObjValue(formObj.s_estm_bc_div_cd, ComGetObjValue(formObj.bc_div_cd));
					ComSetObjValue(formObj.s_estm_vvd_tp_cd, ComGetObjValue(formObj.vvd_tp));
				}
				
				if(validateForm(sheetObj,formObj,sAction) == false) return false; 

                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                sheetObj.DoSearch("FNS_INV_0121GS.do", FormQueryString(formObj));
                //ComOpenWait End
                ComOpenWait(false);

                if(ComGetObjValue(formObj.option_value) == "REV"){
                	if(ComGetObjValue(formObj.r_s_vvd_cd) != ""){
    					formObj.r_yrmon_fm.className = "input2";
    					formObj.r_yrmon_to.className = "input2";
    					formObj.r_yrmon_fm.readOnly = true;
    					formObj.r_yrmon_to.readOnly = true;
    					ComEnableObject(formObj.btns_calendar1, false);
    					ComEnableObject(formObj.btns_calendar2, false);

    	    		}else if(ComGetObjValue(formObj.r_yrmon_fm) != ""){
    					formObj.r_yrmon_fm.className = "input1";
    					formObj.r_yrmon_to.className = "input1";
    					formObj.r_yrmon_fm.readOnly = false;
    					formObj.r_yrmon_to.readOnly = false;
    					ComEnableObject(formObj.btns_calendar1, true);
    					ComEnableObject(formObj.btns_calendar2, true);
    	    		}
                	
                }else{
                	if(ComGetObjValue(formObj.p_s_vvd_cd) != ""){
    					formObj.p_yrmon_fm.className = "input2";
    					formObj.p_yrmon_to.className = "input2";
    					formObj.p_yrmon_fm.readOnly = true;
    					formObj.p_yrmon_to.readOnly = true;
    					ComEnableObject(formObj.btns_calendar3, false);
    					ComEnableObject(formObj.btns_calendar4, false);
    	    		}else if(ComGetObjValue(formObj.p_yrmon_fm) != ""){
    					formObj.p_yrmon_fm.className = "input1";
    					formObj.p_yrmon_to.className = "input1";
    					formObj.p_yrmon_fm.readOnly = false;
    					formObj.p_yrmon_to.readOnly = false;
    					ComEnableObject(formObj.btns_calendar3, true);
    					ComEnableObject(formObj.btns_calendar4, true);

    	    		}
                }
                break;
   			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'CheckBox');
				break;
        }
                
    }
    
	//멀티콤보 클릭 이벤트
	function bc_div_cd_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	    
	
	function setMultiCombo(comboObj, index, code) {
		//All 인 경우
	    if(index==0) {
	    	//checked
	    	if(comboObj.CheckIndex(index)) {
	    		for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	    			comboObj.checkIndex(i) = true;
	    		}

	    	} else {
	    		for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	    			comboObj.checkIndex(i) = false;
	    		}
	    	}
		//All 이 아닌 경우
	    } else {
	    	var checkCnt = 0;
    		for(var i = 1 ; i < comboObj.GetCount () ; i++) {
    			if(comboObj.checkIndex(i)) {
    				checkCnt++;
    			}
    		}
    		if(checkCnt == comboObj.GetCount ()-1) {
    			comboObj.checkIndex(0) = true;
    		}else{
    			comboObj.checkIndex(0) = false;
    		}
	    }
	}
    function changeOption(){
    	var formObj = document.form;
    	var divShowRev = document.getElementById("showREV");
    	var divShowPRD = document.getElementById("showPRD");
    	
    	if(ComGetObjValue(formObj.option_value) == "PRD"){
    		ComSetObjValue(formObj.option_value, ComGetObjValue(formObj.p_option_value));
    		ComSetObjValue(formObj.r_option_value, ComGetObjValue(formObj.p_option_value))
    		divShowRev.style.display = "block";
    		divShowPRD.style.display = "none";

    	}else if(ComGetObjValue(formObj.option_value) == "REV"){

	    	ComSetObjValue(formObj.option_value, ComGetObjValue(formObj.r_option_value));
    		ComSetObjValue(formObj.p_option_value, ComGetObjValue(formObj.r_option_value))
    		
    		divShowRev.style.display = "none";
    		divShowPRD.style.display = "block";

    	}
    }
    
    function validateForm(sheetObj,formObj,sAction){
    	if(ComGetObjValue(formObj.option_value) == "REV"){
    		if(ComGetObjValue(formObj.s_vvd_cd) == "" ){
    			if(ComGetObjValue(formObj.yrmon_fm) == ""){
    				ComShowCodeMessage("COM130201" , "From Month");
    				return false;
    			}else if(ComGetObjValue(formObj.yrmon_to) == ""){
    				ComShowCodeMessage("COM130201" , "To Month");
    				return false;
    			}
    		}
    	}else if(ComGetObjValue(formObj.option_value) == "PRD"){
    		if(ComGetObjValue(formObj.s_vvd_cd) == "" ){
    			if(ComGetObjValue(formObj.yrmon_fm) == ""){
    				ComShowCodeMessage("COM130201" , "From Month");
    				return false;
    			}else if(ComGetObjValue(formObj.yrmon_to) == ""){
    				ComShowCodeMessage("COM130201" , "To Month");
    				return false;
    			}
    		}
    		if(ComGetObjValue(formObj.s_estm_bc_div_cd) == ""){
    			ComShowCodeMessage("COM12113" , "B/C");
    			return false;
    		}
    	}
		if(ComGetObjValue(formObj.yrmon_fm) != "" && ComGetObjValue(formObj.yrmon_to) != ""){
			var diff_day = ComGetDaysBetween(ComGetObjValue(formObj.yrmon_fm),ComGetObjValue(formObj.yrmon_to));
			if(diff_day > 365) {
				ComShowCodeMessage("COM132001","Month","1 year" );// '{?msg1} exceeds maximum duration {?msg2}.';
				return false;
			}
		}
		
    	return true;
    }
    
 	function setDefaultDateValue() {
 		var formObj = document.form;
 		today= new Date();
 		
 		var year  =today.getYear();
 		var mon  =today.getMonth()+1;
 		 
 		formObj.yrmon_fm.value = year+"-"+ComLpad(mon,2,"0");
		formObj.yrmon_to.value = year+"-"+ComLpad(mon,2,"0");

		if(ComGetObjValue(formObj.option_value) == "REV"){
			formObj.r_yrmon_fm.value = year+"-"+ComLpad(mon,2,"0");
			formObj.r_yrmon_to.value = year+"-"+ComLpad(mon,2,"0");
			formObj.p_yrmon_fm.value = year+"-"+ComLpad(mon,2,"0");
			formObj.p_yrmon_to.value = year+"-"+ComLpad(mon,2,"0");
		}else{
			formObj.r_yrmon_fm.value = year+"-"+ComLpad(mon,2,"0");
			formObj.r_yrmon_to.value = year+"-"+ComLpad(mon,2,"0");
			formObj.p_yrmon_fm.value = year+"-"+ComLpad(mon,2,"0");
			formObj.p_yrmon_to.value = year+"-"+ComLpad(mon,2,"0");
		}
 	}  
 	
 	function setDefaultValue(){
 		var formObj = document.form;
 		
 		//hidden value init
 		ComSetObjValue(formObj.yrmon_fm,	"");
 		ComSetObjValue(formObj.yrmon_to,	"");
 		ComSetObjValue(formObj.del_cd,		"");
 		ComSetObjValue(formObj.s_vvd_cd,	"");
 		ComSetObjValue(formObj.s_slan_cd,	"");
 		ComSetObjValue(formObj.s_rlane_cd,	"");
 		ComSetObjValue(formObj.s_estm_bc_div_cd,	"");
 		ComSetObjValue(formObj.s_estm_vvd_tp_cd,	"");
 		
 		if(ComGetObjValue(formObj.option_value) == "REV"){
 			//del
 			formObj.r_del_cd.selectedIndex = 0;
 			//vvd
 	 		ComSetObjValue(formObj.r_s_vvd_cd,	"");
 			//s/lane
 	 		ComSetObjValue(formObj.r_s_slan_cd,	"");
 			//r/lane
 	 		ComSetObjValue(formObj.r_s_rlane_cd,	"");

		}else{
 			//b/c
 			//formObj.p_s_estm_bc_div_cd.selectedIndex = 0;
 			//vvd
 	 		ComSetObjValue(formObj.p_s_vvd_cd,	"");
 			//type
 	 		//formObj.p_s_estm_vvd_tp_cd.selectedIndex = 0;
 			//r/lane
 	 		ComSetObjValue(formObj.p_s_rlane_cd,	"");
		}
 	}
 	
 	function setDefaultDisplay(){
 		var formObj = document.form;
 		if(ComGetObjValue(formObj.option_value) == "REV"){
			formObj.r_yrmon_fm.className = "input1";
			formObj.r_yrmon_to.className = "input1";
			formObj.r_yrmon_fm.readOnly = false;
			formObj.r_yrmon_to.readOnly = false;
			ComEnableObject(formObj.btns_calendar1, true);
			ComEnableObject(formObj.btns_calendar2, true);
 		}else{
			formObj.p_yrmon_fm.className = "input1";
			formObj.p_yrmon_to.className = "input1";
			formObj.p_yrmon_fm.readOnly = false;
			formObj.p_yrmon_to.readOnly = false;
			ComEnableObject(formObj.btns_calendar3, true);
			ComEnableObject(formObj.btns_calendar4, true);
 			
 		}
 	}
 	
 	
    function initAxonControl() {
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
    }
    
    
    /**
    * HTML Control Foucs in
    */
   function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
       
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
   }	
   
   //포커스가 나갈 때
   function obj_blur(){
	   var obj = event.srcElement;
	   var formObj = document.form;
	   
	   if(ComGetObjValue(formObj.option_value) == "REV"){
		   if(obj.name == 'r_s_vvd_cd') {
			   if(formObj.r_s_vvd_cd.value == ""){
					formObj.r_yrmon_fm.className = "input1";
					formObj.r_yrmon_to.className = "input1";
					formObj.r_yrmon_fm.readOnly = false;
					formObj.r_yrmon_to.readOnly = false;
					ComEnableObject(formObj.btns_calendar1, true);
					ComEnableObject(formObj.btns_calendar2, true);
			   }
		   }else{
			   ComChkObjValid(obj);
		   }
	   }else{
		   if(obj.name == 'p_s_vvd_cd') {
			   if(formObj.p_s_vvd_cd.value == ""){
					formObj.p_yrmon_fm.className = "input1";
					formObj.p_yrmon_to.className = "input1";
					formObj.p_yrmon_fm.readOnly = false;
					formObj.p_yrmon_to.readOnly = false;
					ComEnableObject(formObj.btns_calendar3, true);
					ComEnableObject(formObj.btns_calendar4, true);
			   }
		   }else{
			   ComChkObjValid(obj);
		   }
	   }

   }  
   
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
		    	// 영문대+숫자 
        		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
		}
    }
	/* 개발자 작업  끝 */