/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0443.js
*@FileTitle : ESM_BKG-0443
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.06.20 김보배 [CHM-201218454] [BKG] [ROCS] 타 VVD에 기존재하는 CRN 생성 방지 Validation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0443() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	 
    }
    /* 개발자 작업 */
 // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    var row_seq = "";
    
    var searched_vvd_flg = "Y";	  //combo vvd onchang를 실행하기 위한 구분자
    var searched_crn_flg = "";   // Retrieve 여부 flag
    	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
 		
 	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	    var sheetObject1 = sheetObjects[0];

 	    /*******************************************************/
 	    var formObject = document.form;
         
 		try {
 			var srcName = window.event.srcElement.getAttribute("name");
             
 			switch(srcName) {
 			    case "btn_new":
				initForm(formObject);
				break;
				
 				case "btn_retrieve": 	
 					formObject.ibflag.value = "";
 					formObject.f_flag.value = "SEARCH";  					
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
				      
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;  
				case "btn_list":
					doActionIBSheet(sheetObject1, formObject, COMMAND01);
					break;  
				case "btn_changeCrn":
					doActionIBSheet(sheetObject1, formObject, COMMAND02);
					break;  	
				case "btns_calendar": //달력버튼
	       	 		// 조회전 일땐 사용못하게 ...
	       	 		var cal = new ComCalendar();
	       	 		cal.select(formObject.frm_dem_free_dt ,'yyyy-MM-dd');
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	//IBMultiCombo초기화  // Add. 2015.04.20
        for(var k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],comboObjects[k].id);
        }
        
    	//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat('keypress',       'obj_keypress',    document.form); //- 키보드 입력할때    
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObj); //- 포커스 나갈때
    	axon_event.addListenerFormat('focus',   'obj_activate',    formObj); //- 포커스 들어갈때
    	
    	//initSheetData(sheetObjects[0], formObj); // 2015.03.25 주석으로 처리
    	
    	//formObj.frm_cstms_decl_usr_id.value = formObj.f_user_id.value;
     	ComBtnDisable("btn_changeCrn");
    	
    	// Add. 2015.03.25
     	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	sheetObjects[2].RemoveAll();
    	sheetObjects[2].DataInsert(-1);
    	
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
    				style.height = 100;
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
    						
    				//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
    				var HeadTitle1 = "|vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|user_ofc_cd|pod_clpt_ind_seq";
    				var headCount = ComCountHeadTitle(HeadTitle1);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0,		cnt++ , dtData,				   100, daCenter,		true,		"vsl_call_ref_no", false, "", dfNone, 0, false, false);    						
					InitDataProperty(0,		cnt++ , dtData,				    80,	daLeft,			true,		"vvd_number", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vsl_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_voy_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,				    50,	daLeft,			true,		"skd_dir_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,				   100,	daLeft,			true,		"vsl_eng_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"dem_free_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"brth_ctnt", false, "", dfNone, 0, false, false);
					
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"ntfy_ltr_ctnt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					60,	daLeft,			true,		"cstms_decl_usr_id", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					70,	daLeft,			true,		"cre_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					70,	daLeft,			true,		"vps_eta_dt", false, "", dfNone, 0, false, false);    						    					
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"user_ofc_cd", false, "", dfNone, 0, false, false);
					
					// 2015.04.20
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"pod_clpt_ind_seq", false, "", dfNone, 0, false, false);
					
					CountPosition = 0;

				}
    			break;
    			
    		case "sheet2":
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 100;
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
    				
    				//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
    				var HeadTitle1 = "|vvd_number|pod_clpt_ind_seq|vps_eta_dt|vsl_eng_nm";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false);
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
    				InitDataProperty(0,		cnt++ , dtData,			100,	daLeft,		true,		"vvd_number", false, "", dfNone, 0, false, false);
    				InitDataProperty(0,		cnt++ , dtData,			100,	daLeft,		true,		"pod_clpt_ind_seq", false, "", dfNone, 0, false, false);
    				InitDataProperty(0,		cnt++ , dtData,			100,	daLeft,		true,		"vps_eta_dt", false, "", dfNone, 0, false, false);
    				InitDataProperty(0,		cnt++ , dtData,			100,	daLeft,		true,		"vsl_eng_nm", false, "", dfNone, 0, false, false);
    			}
    			break;
    			
    		case "sheet3":
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 100;
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
    						
    				//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
    				var HeadTitle1 = "|vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|user_ofc_cd|pod_clpt_ind_seq";
    				var headCount = ComCountHeadTitle(HeadTitle1);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0,		cnt++ , dtData,				   100, daCenter,		true,		"vsl_call_ref_no", false, "", dfNone, 0, false, false);    						
					InitDataProperty(0,		cnt++ , dtData,				    80,	daLeft,			true,		"vvd_number", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vsl_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_voy_no", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,				    50,	daLeft,			true,		"skd_dir_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,				   100,	daLeft,			true,		"vsl_eng_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"dem_free_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"brth_ctnt", false, "", dfNone, 0, false, false);
					
					InitDataProperty(0,		cnt++ , dtData,					80,	daLeft,			true,		"ntfy_ltr_ctnt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					60,	daLeft,			true,		"cstms_decl_usr_id", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					70,	daLeft,			true,		"cre_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0,		cnt++ , dtData,					70,	daLeft,			true,		"vps_eta_dt", false, "", dfNone, 0, false, false);    						    					
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"user_ofc_cd", false, "", dfNone, 0, false, false);
					
					InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"pod_clpt_ind_seq", false, "", dfNone, 0, false, false);
					
					CountPosition = 0;

				}
    			break;


    	}
    }
    /**
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {        	         
       	sheetObj.ShowDebugMsg = false;
        
       	switch(sAction) {
	       	case SEARCH05:     // when "onchange" function is active from VVD CD, retrieve information of VVD from VSK module  
	   			// Add. 2015.04.20
	   			//alert("search05");
	   			
	   			formObj.frm_vvd_number.value = formObj.combo_vvd_cd.text.trim();
	   			formObj.f_cmd.value = SEARCH05;
	   			
	   			formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
	   			formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	   			formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
	   			formObj.frm_pod_clpt_ind_seq.value = "";
	   			
	   			var sXml =  sheetObj.GetSearchXml("ESM_BKG_0443GS.do", FormQueryString(formObj));
	   			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
		        
	   			if(State == "S"){
	   				
	   				sheetObj.LoadSearchXml(sXml);
	       			
	   				if(sheetObj.RowCount >0){
	   					formObj.combo_pod_seq.RemoveAll();
	   					formObj.combo_vvd_cd.RemoveAll();
	   					
	   					// double calling seq - combo setting 
	   					ComXml2ComboItem(sXml, formObj.combo_pod_seq, "pod_clpt_ind_seq", "pod_clpt_ind_seq");
   	 	    			
	   					formObj.frm_vsl_eng_nm.value = sheetObj.CellValue(1,"vsl_eng_nm");
	       				formObj.combo_pod_seq.Code2 = sheetObj.CellValue(1,"pod_clpt_ind_seq");  // onchange이벤트를 타지 않게 하기 위해 
	   					formObj.frm_vps_eta_dt.value =sheetObj.CellValue(1,"vps_eta_dt");
	   					
	   					formObj.combo_vvd_cd.InsertItem(0,formObj.frm_vvd_number.value, formObj.frm_vvd_number.value);
	   					formObj.combo_vvd_cd.Index2 = 0;
	   					
	   					formEtcErase();
	   					
	   					formObj.combo_vvd_cd.focus();

	   					searched_vvd_flg = "Y";
		   				
	   				}else{       					
	   					ComShowCodeMessage('BKG00945',formObj.frm_vvd_number.value );	// "POD is not calling port of vessel({?msg1})"
	   					
	   					var pre_vvd_cd = formObj.frm_vvd_number.value;
	   					
	   					formObj.reset();
	   					formObj.combo_vvd_cd.RemoveAll();
	   					formObj.combo_pod_seq.RemoveAll();
	   					
	   					formObj.combo_vvd_cd.InsertItem(0, pre_vvd_cd, pre_vvd_cd);
	   					formObj.combo_vvd_cd.Index2 = 0;
	   					
	   					searched_vvd_flg = "";
	   				}
	   				
	   				sheetObjects[0].RemoveAll();
	   				
	   				sheetObjects[2].RemoveAll();
	   				sheetObjects[2].DataInsert(-1);
	   				
	   			}

	   			break;
	   			
       		case IBSEARCH:
       			// SEARCH05 통해서 Y라고 setting된 VVD만
       			//alert("IBSEARCH : "+ searched_vvd_flg);
       			
       			if(searched_vvd_flg=="Y" || form.combo_vvd_cd.text ==""){
       				
	       			formObj.frm_vvd_number.value = formObj.combo_vvd_cd.text.trim();
	       			
	       			if (!ComIsNull(formObj.frm_vvd_number)){
	   	 	    		formObj.frm_pod_clpt_ind_seq.value = formObj.combo_pod_seq.text.trim();
	   	 	    	}
	       			
	       			if(!validateForm(sheetObj,formObj,sAction)) {
	       	    		return false;
					}  
	       	    	
	       	    	sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					
					formObj.f_cmd.value = SEARCH;
						
					formObj.vsl_cd.value		  = formObj.frm_vvd_number.value.substring(0,4);
	   	 	    	formObj.skd_voy_no.value 	  = formObj.frm_vvd_number.value.substring(4,8);
	   	 	    	formObj.skd_dir_cd.value 	  = formObj.frm_vvd_number.value.substring(8);
	   	 	    	formObj.frm_crn_number.value  = formObj.frm_vsl_call_ref_no.value;
	   	 	    	
	   	 	    	var sXml =  sheetObj.GetSearchXml("ESM_BKG_0443GS.do", FormQueryString(formObj));
	   	 	    	var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	   	 	    		
	   	 	    	if(State == "S"){
	   	 	    		
	   	 	    		sheetObj.LoadSearchXml(sXml);
	   	 	    		
	   	 	    		if(sheetObj.RowCount > 0){
	   	 	    			formObj.combo_vvd_cd.RemoveAll();
	   	 	    			formObj.combo_pod_seq.RemoveAll();
   	 	    		    
	   	 	    			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
	   	 	    			
	   	 	    			// VVD SETTING
	   	 	    			ComXml2ComboItem(sXml, formObj.combo_vvd_cd, "vvd_number", "vvd_number");
	   	 	    			formObj.combo_vvd_cd.Index2 = 0;			// onchange이벤트를 타지 않게 하기 위해 
	   	 	    			
		   	 	    		for (var i=1 ; i<=sheetObj.RowCount ; i++){
				   	 			if(formObj.combo_vvd_cd.text == sheetObj.CellValue(i,"vvd_number") ){
				   	  	    		
				   	 				var comboTxt;
				   	  	    		
				   	 				if(sheetObj.CellValue(i,"pod_clpt_ind_seq") ==""){
				   	  	    			comboTxt = "1";
				   	  	    		}else{
				   	  	    			comboTxt =sheetObj.CellValue(i,"pod_clpt_ind_seq");
				   	  	    		}
				   	  	    		
				   	  	    		formObj.combo_pod_seq.InsertItem(i-1, comboTxt, comboTxt);
				   	  	    		formObj.combo_pod_seq.text = comboTxt;
				   	  	    		
				   	  	    	}
				   	  	    }
		   	 	    		
		   	 	    		row_seq ="1";
		   	 	    		searched_crn_flg = "Y";
		   	 	    		searched_vvd_flg = "Y"; 
		   	 	    		
		   	 	    		sheetObjects[2].RemoveAll();
		   	 	    		sheetObjects[2].DataInsert(-1);
		   					ComBtnEnable("btn_changeCrn");
		   	 	    		
	   	 	    		}else {
	   	 	    			var pre_vvd_cd = formObj.frm_vvd_number.value;
		   	 	    		var pre_crn_no = formObj.frm_vsl_call_ref_no.value;
		   	 	    		var pre_pod_seq = formObj.frm_pod_clpt_ind_seq.value;
		   	 	    		
		   	 	    		if(searched_vvd_flg != "Y"){
			   	 	    		formObj.reset();
			   	 	    		formObj.combo_vvd_cd.RemoveAll();
			   	 	    		formObj.combo_pod_seq.RemoveAll();
		    				
			   	 	    		formObj.frm_vsl_call_ref_no.value = pre_crn_no;
			   	 	    		formObj.combo_vvd_cd.InsertItem(0, pre_vvd_cd, pre_vvd_cd);
			   	 	    		formObj.combo_vvd_cd.Index2 = 0;
		   	 	    		}
		   	 	    		searched_crn_flg ="";
		   	 	    		
		   	 	    		sheetObjects[1].RemoveAll();
		   	 	    		formEtcErase();
		   	 	        
		   	 	        	sheetObjects[2].RemoveAll();
		   	 	    		sheetObjects[2].DataInsert(-1);
		   	 	    		ComBtnDisable("btn_changeCrn");
		   	          		
	   	 	    		}
	 	    		}
	   	 	     	 	    	
					ComOpenWait(false);

       			}
				
				
				/*if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}   
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
       	 	    if(formObj.f_flag.value == "SEARCH")
       	 	    {
       	 	    	if(!validateForm(sheetObj,formObj,sAction)) {
       	 	    		return false;
       	 	    	}
       	 	    	//VVD 등록여부 Chekc 먼저]
       	 	    	if(formObj.frm_vvd_number.value != "")
       	 	    	{
       	 	    		formObj.f_cmd.value = SEARCH01;
       	 	    		formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
       	 	    		formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
       	 	    		formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);					 
       	 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );	 	    	    
       	 	    		ComEtcDataToForm(formObj, sheetObj);
       	 	    	}
       	 	    	
       	 	    	formObj.f_cmd.value = SEARCH;       	 	    	
       	 	    	formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
       	 	    	formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
       	 	    	formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
       	 	        formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
					sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
					 
					if(sheetObj.RowCount == 1){
						
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
						
						formObj.ibflag.value = formObj.frm_vsl_call_ref_no.value;
					}  
       	 	    }
       	 	    if(formObj.f_flag.value == "SEARCH01")//vvd 이벤트
       	 	    {       	 	        
       	 	    	formObj.f_cmd.value = SEARCH01;
	 	    		formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
	 	    		formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	 	    		formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);					 
	 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );	 	    	    
	 	    		ComEtcDataToForm(formObj, sheetObj);
	 	    		 
       	 	    	if(formObj.frm_vvd_number.value != "")
       	 	    	{       	 	    	    
       	 	    		formObj.f_cmd.value = SEARCH;
       	 	    		formObj.vsl_cd.value     = formObj.frm_vvd_number.value.substring(0,4);
       	 	    		formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
       	 	    		formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
       	 	    		formObj.frm_crn_number.value = "";
       	 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );				         
       	 	    		if(sheetObj.RowCount == 1){       	 	    			 
       	 	    			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");							 
       	 	    		}           	 	    		 
       	 	    	}
       	 	    	 
       	 	    }
       	 	    if(formObj.f_flag.value == "SEARCH02")//crn_number
       	 	    {
       	 	    	
       	 	    	if(!validateForm(sheetObj,formObj,sAction)) {
       	 	    		return false;
       	 	    	}
       	 	    	formObj.f_cmd.value = SEARCH03;
       	 	    	formObj.vsl_cd.value = "";
       	 	    	formObj.skd_voy_no.value = "";
       	 	    	formObj.skd_dir_cd.value = "";
       	 	    	formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
       	 	    	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
				     
       	 	    	if(sheetObj.RowCount == 1){
       	 	    		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");	
       	 	    		//if(sheetObj.CellValue(0,"frm_vsl_call_ref_no"))
       	 	    	} 
				
       	 	    	formObj.f_cmd.value = SEARCH02;
       	 	    	formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
       	 	    	formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
       	 	    	formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
       	 	    	 
       	 	        if(sheetObj.CellValue(1, "ibflag") == "R")
       	 	        {
       	 	        	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );       	 	    	 
       	 	        	//신규 CRN 번호
       	 	        	if(sheetObj.RowCount == 0){       	 	        		 
       	 	        	    formObj.frm_vvd_number.value = "";
       	 	        	    formObj.frm_vsl_eng_nm.value = "";
       	 	        	    formObj.frm_cstms_decl_usr_id.value = "";
       	 	        	    init_combobox("frm_brth_ctnt","  ");
       	 	        		formObj.frm_cstms_decl_usr_id.value = formObj.f_user_id.value;
       	 	        	}
       	 	        }       	 	               	 	    	
       	 	    }
       	 	    if ( formObj.frm_vsl_call_ref_no.value != "" && formObj.frm_vvd_number.value != "" )
       	 	    {
       	 	    	ComBtnEnable("btn_changeCrn");
       	 	    } else {
       	 	    	ComBtnDisable("btn_changeCrn");
       	 	    }
       	 	    ComOpenWait(false);
   				*/
   			break;
       	 	
   			case IBSAVE:   
   				
   				formObj.frm_vvd_number.value = formObj.combo_vvd_cd.text.trim();
		       	formObj.frm_pod_clpt_ind_seq.value = formObj.combo_pod_seq.text.trim();
		       	
		       	formObj.frm_vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
   	    	 	formObj.frm_skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
   	    	 	formObj.frm_skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);   	    	 	       	       	 	  
   	    	 	formObj.frm_pod_clpt_ind_seq.value = formObj.combo_pod_seq.text.trim();
		       	
   	    	 	formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
	 	    	formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	 	    	formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
	 	    	   
	 	    	formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
	 	    	
   				if(!validateForm(sheetObj,formObj,sAction)) {
   					return false;
				} 
   				
   				if(sheetObj.RowCount >0){
   					sheetObj.CellValue(row_seq,"vvd_number") 		  = formObj.frm_vvd_number.value;
   					
   					sheetObj.CellValue(row_seq,"vps_eta_dt") 		  = formObj.frm_vps_eta_dt.value;
   					sheetObj.CellValue(row_seq,"dem_free_dt") 		  = formObj.frm_dem_free_dt.value;
   					sheetObj.CellValue(row_seq,"brth_ctnt") 		  = formObj.frm_brth_ctnt.value;
   					sheetObj.CellValue(row_seq,"ntfy_ltr_ctnt") 	  = formObj.frm_ntfy_ltr_ctnt.value;
   					sheetObj.CellValue(row_seq,"cre_dt")		  	  = formObj.frm_cre_dt.value;
   					sheetObj.CellValue(row_seq,"cstms_decl_usr_id")   = formObj.frm_cstms_decl_usr_id.value;
   					
   					//pod_clpt_ind_seq 컬럼을 DB에 추가해서 기존 데이터들은 null 이다. 이 경우는 change로 인식 하지 않도록 처리
   					if(sheetObj.CellValue(row_seq,"pod_clpt_ind_seq") !=""){
   						sheetObj.CellValue(row_seq,"pod_clpt_ind_seq")	  = formObj.frm_pod_clpt_ind_seq.value;
   					}
   					
   					/*if(sheetObj.CellValue(row_seq, "ibflag") == "R"){
   						ComShowCodeMessage('BKG40083');
   						return false;
   					}else if(sheetObj.CellValue(row_seq,"ibflag") == "U"){
   						
   						*/
   						if(!ComShowConfirm(ComGetMsg("BKG00350"))){      		   					 
   	   		   				return false;
   						}
   						
   						IBS_CopyFormToRow(formObj, sheetObjects[2], 1, "frm_");
   					//}
   				}else{
   					if(!ComShowConfirm(ComGetMsg("BKG00350"))){      		   					 
	   		   				return false;
					}
   					
   					IBS_CopyFormToRow(formObj, sheetObjects[2], 1, "frm_");
   				}
   					   	 	    
   				formObj.f_cmd.value = MULTI;
				
   				var sParam = ComGetSaveString(sheetObjects[2]);
   				sParam += "&" + FormQueryString(formObj);
   				
   				var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0443GS.do", sParam);
   	 	    	var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
   	 	    	

   	 	    	var resultVal = ComGetEtcData(sXml, "err_msg");
   	 	    	
   	 	    	if (State == "S") {
   	 	    		
   	 	    		var msg_cd = resultVal.split("&")[0] ;
   	 	    		var msg_val = resultVal.split("&")[1] ;
   	 	    		
   	 	    		if(msg_cd == "SUCCESS"){
   	 	    			ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!

        	    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
        	    	
   	 	    		}else if(msg_cd == "BKG06160" || msg_cd == "BKG06161" || msg_cd == "BKG06142"){
   	 	    			ComShowCodeMessage(msg_cd,msg_val);	// "POD is not calling port of vessel({?msg1})"
   					
   	 	    		}
   	 	    		
   	 	    		
   	 	    	} else{
   	 	    		ComShowMessage(ComResultMessage(sXml));
   	 	    	}
   	 	    	sheetObjects[2].removeAll();
   	 	    	sheetObjects[2].DataInsert(-1);
   	 	    
   	 	    	ComOpenWait(false);
   				
   				/*formObj.f_cmd.value = SEARCH03;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
   				formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
   	 	    	formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
   	 	    	formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
   	 	    	formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
   	 	    	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
			    
	   	 	    if(sheetObj.EtcData("err_msg") == "BKG06142") {	
	   	 	    	formObj.frm_vsl_call_ref_no.value = "";
	   	 	    	ComOpenWait(false);
	    			return;
	    		}
	   	 	    
   	 	    	if(sheetObj.RowCount == 1){
   	 	    		//IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
   	 	    		 
   	 	    	    if(formObj.frm_vsl_call_ref_no.value.length == 0)
   	 	    	    	formObj.frm_vsl_call_ref_no.value = sheetObj.CellValue(1,"vsl_call_ref_no");
   	 	    	    if(formObj.frm_vvd_number.value.length == 0)
	 	    	    	formObj.frm_vvd_number.value = sheetObj.CellValue(1,"vvd_number");
   	 	    	    if(formObj.frm_vsl_eng_nm.value.length == 0)
	 	    	    	formObj.frm_vsl_eng_nm.value = sheetObj.CellValue(1,"vsl_eng_nm");
	 	    	    if(formObj.frm_vps_eta_dt.value.length == 0)
 	    	    	   formObj.frm_vps_eta_dt.value = sheetObj.CellValue(1,"vps_eta_dt");
	 	    	    if(formObj.frm_dem_free_dt.value.length == 0)
  	 	    	    	formObj.frm_dem_free_dt.value = sheetObj.CellValue(1,"dem_free_dt");
  	 	    	    if(formObj.frm_ntfy_ltr_ctnt.value.length == 0)
	 	    	    	formObj.frm_ntfy_ltr_ctnt.value = sheetObj.CellValue(1,"ntfy_ltr_ctnt");  	 	    	    
  	 	    	    if(formObj.frm_cstms_decl_usr_id.value.length == 0)
	 	    	    	formObj.frm_cstms_decl_usr_id.value = sheetObj.CellValue(1,"cstms_decl_usr_id");
	 	    	    if(formObj.frm_cre_dt.value.length == 0)
	 	    	    	formObj.frm_cre_dt.value = sheetObj.CellValue(1,"cre_dt");
   	 	    	} 
   	 	        
   	 	        formObj.f_cmd.value = SEARCH01;
	    		formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
	    		formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	    		formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);					 
	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );	 	    		
	    		ComEtcDataToForm(formObj, sheetObj);

	    		if(sheetObj.EtcData("frm_vsl_eng_nm") == "")
	    		{
	    			ComOpenWait(false);
	    			formObj.frm_vvd_number.focus();
	    			return;
	    		}
	    		
	    		if(sheetObj.EtcData("err_msg") == "BKG00547")
	    		{	ComOpenWait(false);
	    			return;
	    		}
	    		
	    		if(!validateForm(sheetObj,formObj,sAction)) {
	    			ComOpenWait(false);
					return false;
				}  
	    			
   	   			formObj.f_cmd.value = SEARCH02;
   	       	 	formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
   	       	 	formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
   	       	 	formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
   	       	 	    
   	       	 	formObj.frm_vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
   	    	 	formObj.frm_skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
   	    	 	formObj.frm_skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);   	    	 	       	       	 	  
   	       	 	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
   	       	    
   					// 데이타 유무 체크
   					if(sheetObj.RowCount == 0){					
   		   				if(ComShowConfirm(ComGetMsg("BKG00350"))){      		   					 
   		   					IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
   		   					//sheetObj.CellValue2(1, "ibflag") = "I";	
   		   					sheetObj.RowStatus(1) = "I";
   		   					var rowCnt = sheetObj.RowCount;
   		   					for(var i=1; i<=rowCnt; i++) {						
   		   							sheetObj.CellValue2(i,"brth_ctnt") = formObj.frm_brth_ctnt.value;   						
   		   					}
   		   					formObj.f_cmd.value = MULTI;   					
   		   			        sheetObj.DoSave("ESM_BKG_0443GS.do", FormQueryString(formObj));
   		   				}					
   					}
   					else
   					{			
   						IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
   						//sheetObj.CellValue2(1, "ibflag") = "U";	
   						sheetObj.RowStatus(1) = "U";
   						sheetObj.CellValue2(1,"brth_ctnt") = formObj.frm_brth_ctnt.value; 					
   						formObj.f_cmd.value = MULTI;   					 
   	   			        sheetObj.DoSave("ESM_BKG_0443GS.do", FormQueryString(formObj));
   					}
   					//formObj.f_cmd.value = SEARCH;
       	 	    	//formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
       	 	    	//formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
       	 	    	//formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
       	 	        //formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
					//sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
					 
					//if(sheetObj.RowCount == 1){
						//IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");							 
					//}  
				
   				ComOpenWait(false);*/
   			break;  
   			case COMMAND01:      //LIST
   				// 2015.04.20 Add
   				formObj.frm_vvd_number.value = formObj.combo_vvd_cd.text;
   				formObj.frm_pod_clpt_ind_seq.value = formObj.combo_pod_seq.text;
   				//end
   				
				var sUrl = "/hanjin/ESM_BKG_0444.do?pgmNo=ESM_BKG_0444&crn_no="+formObj.frm_vsl_call_ref_no.value+"&vvd_no="+formObj.frm_vvd_number.value+"&pop_up=Y";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0444", 1024, 630, true);
			break;
			
   			case COMMAND02:      //Change CRN
  		    	// 2015.04.20 Add
   				formObj.frm_vvd_number.value = formObj.combo_vvd_cd.text.trim();
   				formObj.frm_pod_clpt_ind_seq.value = formObj.combo_pod_seq.text.trim();
   				//end
   				
   				var sUrl = "/hanjin/ESM_BKG_1094.do?pgmNo=ESM_BKG_1094&crn_no="+formObj.frm_vsl_call_ref_no.value+"&vvd_no="+formObj.frm_vvd_number.value+"&pod_clpt_ind_seq="+formObj.frm_pod_clpt_ind_seq.value;
   				ComOpenWindowCenter(sUrl, "ESM_BKG_1094", 300, 210, true);
		break;			
   			
   		}
    }   
    
    // 시트 데이터 초기화
    function initSheetData(sheetObj, formObj) {
    		 
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);	
    		
    	IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");		
    }
 
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
        	case IBSEARCH: // 조회
        		if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
     				ComShowCodeMessage('BKG00538');
     				formObj.combo_vvd_cd.focus();
     				return false;
     			}
     			
        		if (formObj.frm_vsl_call_ref_no.value.length > 0 && formObj.frm_vsl_call_ref_no.value.length < 13) {
     		    	ComShowCodeMessage('BKG00537');
     				formObj.frm_vsl_call_ref_no.focus();
     				return false;
     			}   
        		
        		if (ComIsNull(formObj.frm_vvd_number) && ComIsNull(formObj.frm_vsl_call_ref_no)) {
					ComShowCodeMessage('BKG00626','CRN Number or VVD');
					formObj.combo_vvd_cd.focus();
					return false;	
				}
        		
        		if(!ComIsNull(formObj.frm_vvd_number) && formObj.combo_pod_seq.text !="1" && formObj.combo_pod_seq.text!="2"){
        			ComShowCodeMessage('BKG02223');
        			return false;
        		}
        		
     			return true;
     			break;
     			
     		case IBSAVE: // 저장
     			if (ComIsNull(formObj.frm_vvd_number) || formObj.frm_vvd_number.value.length < 9)
     			{
     				ComShowCodeMessage('BKG00754');
     				formObj.combo_vvd_cd.focus();
     				return false;
     			}
     			
     			if (formObj.frm_vps_eta_dt.value.trim().length == 0)
     			{	ComShowCodeMessage('BKG00626','ETA Date');
     				return false;
     			}
     			
     			if (ComIsNull(formObj.frm_vsl_call_ref_no) || formObj.frm_vsl_call_ref_no.value.length < 13)
     			{
     				ComShowCodeMessage('BKG00626','CRN');
     				formObj.frm_vsl_call_ref_no.focus();
     				return false;
     			}
     			
     			if (ComIsNull(formObj.frm_pod_clpt_ind_seq))
     			{
     				ComShowCodeMessage('BKG00626','POD Calling Seq');
     				formObj.combo_pod_seq.focus();
     				return false;
     			}else if (formObj.frm_pod_clpt_ind_seq.value !="1" && formObj.frm_pod_clpt_ind_seq.value !="2"){
     				ComShowCodeMessage('BKG02223');
     				formObj.combo_pod_seq.focus();
     				return false;
     			}
     			/* -- 필요할 경우 추가하려고  만들어 놓음
     			if (ComIsNull(formObj.frm_dem_free_dt))
     			{
     				ComShowCodeMessage('BKG00626','Dem Free Time');
     				formObj.frm_dem_free_dt.focus();
     				return false;
     			}
     			if (ComIsNull(formObj.frm_ntfy_ltr_ctnt))
     			{
     				ComShowCodeMessage('BKG00626', 'N/L Text');
     				formObj.frm_ntfy_ltr_ctnt.focus();
     				return false;
     			}
     			if (ComIsNull(formObj.frm_brth_ctnt))
     			{
     				ComShowCodeMessage('BKG00887', 'Berth Code');
     				formObj.frm_brth_ctnt.focus();
     				return false;
     			}
     			*/
     			
     			if(searched_crn_flg == "Y"){
	     			if(sheetObj.CellValue(row_seq,"vsl_call_ref_no") != formObj.frm_vsl_call_ref_no.value){
	   					ComShowCodeMessage('BKG06159', formObj.frm_vvd_number.value);
	   		     		return false;
	   				}
	   				
	     			if(sheetObj.CellValue(row_seq,"vvd_number") != formObj.frm_vvd_number.value ) {
	     				ComShowCodeMessage('BKG06163', "VVD");
	   		     		return false;
	   				}
	     			
	     			if(sheetObj.CellValue(row_seq,"pod_clpt_ind_seq") != formObj.frm_pod_clpt_ind_seq.value ) {
	     				ComShowCodeMessage('BKG06163', "POD Calling Seq");
	   		     		return false;
	   				}
	   			}
     			
     			return true;
     			break;
        }	
    }
         
    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
    function obj_keypress() {
           	
    	switch(event.srcElement.dataformat){
            case "uppernum":
                //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                ComKeyOnlyAlphabet('uppernum');
                break;
           	default:
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
        }
   	 	var formObject = document.form;        
   	    var srcName = window.event.srcElement.getAttribute("name");
   	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
   	    var srcValue = window.event.srcElement.getAttribute("value");
   	    var crn_number = formObject.frm_vsl_call_ref_no.value;
   	    var vvd_cd     = formObject.frm_vvd_number.value;
   	    
           	    
//           	    if(window.event.keyCode == 13)
//           	    {              	    		 
//           	    	if (srcName == "frm_vvd_number" && vvd_cd.length > 0)
//           	    	{           	    			 
//           	    		formObject.f_flag.value = "SEARCH01";  
//           	    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);            	    			
//           	    	}   
//           	    	if (srcName == "frm_vsl_call_ref_no" && crn_number.length > 0)
//           	    	{           	    			 
//           	    		formObject.f_flag.value = "SEARCH02";  
//           	    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);           	    			 
//           	    	}             	    	
//           	    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//            	    	ComSetNextFocus();        	    		
//            	    }  
//            	     
//           	    }           	 	
            }
    /**
     * 
     * @param combo_id
     * @param combo_value
     * @return
     */
    function init_combobox(combo_id,combo_value)
    {
    	  
    	var combox = document.getElementById(combo_id);
    	 
    	if(combox == null)
    	{
    		return;
    	}
    	for(ix=0;ix < combox.length;ix++)
    	{
    		if(combox.options[ix].value = combo_value )
    		{
    			combox.options[ix].selected = true;
    			return;
    		}        		
    	}
    }

    /**
     * 
     * @param formObj
     * @return
     */  
    function initForm(formObj){    	 
        formObj.frm_vsl_call_ref_no.value = "";
        formObj.frm_vvd_number.value = "";
        formObj.frm_vsl_eng_nm.value = "";
        formObj.frm_vps_eta_dt.value = "";
        formObj.frm_dem_free_dt.value = "";
        formObj.frm_ntfy_ltr_ctnt.value = "";
        formObj.frm_cstms_decl_usr_id.value = "";
 		formObj.frm_cre_dt.value = "";
        init_combobox("frm_brth_ctnt","  ");
       
        
        //initSheetData(sheetObjects[0], formObj); // 2015.03.25 주석으로 처리
        formObj.frm_vsl_call_ref_no.focus();
        formObj.ibflag.value = "";
        
        // Add. 2015.04.20
        formObj.frm_cstms_decl_usr_id.value = "";
        
        formObj.combo_vvd_cd.RemoveAll();
        formObj.combo_vvd_cd.Code = ""; 
        formObj.combo_pod_seq.RemoveAll();
        
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[2].DataInsert(-1);	
        
        row_seq = "";
        searched_crn_flg ="";
        searched_vvd_flg = "Y"; 
        ComBtnDisable("btn_changeCrn");
        
        // End.
        
    }

	/**
	* HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	**/          
	function obj_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){
			case "frm_dem_free_dt":
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
	 **/
	function obj_deactivate(){
		 
	    //입력Validation 확인하기
		switch(event.srcElement.name){
		
	    	case "frm_dem_free_dt":
	    		ComAddSeparator(event.srcElement);
				break;
	    	 
			default:
				break;
				//ComAddSeparator(event.srcElement);
				//ComChkObjValid(event.srcElement);
		}
		
	}
		 
	function retrieve(crnNo)
	{
		document.form.frm_vsl_call_ref_no.value = crnNo;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
		
	
    function formEtcErase(){
    	var formObj = document.form;
	
		formObj.frm_dem_free_dt.value = "";
		init_combobox("frm_brth_ctnt","  ");
	    formObj.frm_ntfy_ltr_ctnt.value = "";
 		formObj.frm_cstms_decl_usr_id.value = "";
 		formObj.frm_cre_dt.value = "";	
    }
    
	/**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     * @version 2015.04.20
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }
    
    /**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 * @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	 * @param {String} comboId 필수,combo ID
 	 * @return 없음. 
 	 * @version 2015.04.20
  	 */
	function initCombo(comboObj, comboId) {
		
		var cnt = 0;	
  		
		switch(comboId) {
			case "combo_vvd_cd":
				with (comboObj) {
					RemoveAll(); 
					MultiSelect = false;
					UseEdit = true; 
					ValidChar(2, 1);		//영어 대문자, 숫자 입력 가능
					IMEMODE = 0;			//IMEMODE = 영문
					MaxLength = 9;
					UseCode = true;	
					BackColor = "#CCFFFD";
				}
  			break;
			case "combo_pod_seq":
				with (comboObj){
					RemoveAll(); 
				
					MultiSelect = false;
					UseEdit = true; // true; 
					ValidChar(2, 1);		//영어 대문자, 숫자 입력 가능
					IMEMODE = 0;			//IMEMODE = 영문
					UseCode = true;	
					
					MaxLength = 1;
					/*InsertItem(cnt ++, "",			  "0");
					InsertItem(cnt ++, "1",			  "1");
					InsertItem(cnt ++, "2",			  "2");
					Code = "0";*/
				}
			break;
		}
	}
	
	
	/**
     * Multi Combo의 값을 변경하는 경우 이벤트 처리
     * @param Object  comboObj   Multi-Combo Object
     * @param Integer value      Multi-Combo의 인덱스값
     * @param String  text       Multi-Combo의 Text값
     * @return void
     * @version 2015.04.20
     **/
    function combo_vvd_cd_OnChange(comboObj, value, text){
    	
    	var formObj = document.form;
    	var combo_in_vvd = ""; //combo안에 존재하는 VVD를 확인하는 flag
    	var del_cnt =0;
    	var comboTxt = ""; 
    	//alert("in combo vvd")
    	// 조회조건의 끝 공백을 제거
    	document.getElementById("combo_vvd_cd").text = document.getElementById("combo_vvd_cd").text.trim(); 
    	
	    for (var i=1; i<=sheetObjects[0].RowCount; i++){
	    	if(formObj.combo_vvd_cd.text == sheetObjects[0].CellValue(i,"vvd_number")){
	    		combo_in_vvd="Y";
	    		
	   	    	formObj.frm_vps_eta_dt.value		= sheetObjects[0].CellValue(i,"vps_eta_dt");
	   	    	formObj.frm_dem_free_dt.value		= sheetObjects[0].CellValue(i,"dem_free_dt");
	   		    formObj.frm_brth_ctnt.value			= sheetObjects[0].CellValue(i,"brth_ctnt");
	   	 	    formObj.frm_ntfy_ltr_ctnt.value		= sheetObjects[0].CellValue(i,"ntfy_ltr_ctnt");
	   	 	    formObj.frm_cstms_decl_usr_id.value	= sheetObjects[0].CellValue(i,"cstms_decl_usr_id");
		 	    formObj.frm_cre_dt.value			= sheetObjects[0].CellValue(i,"cre_dt");
		 	    
		 	    row_seq = i;
		 	    
		 	    if (del_cnt==0){
	   	 	    	formObj.combo_pod_seq.RemoveAll();
	   	 	    }
	   	 	    
		 	    //CHM-201534307 적용 전 데이터는 pod_clpt_ind_seq=null이기 때문에 필요한 로직
		 	    if(sheetObjects[0].CellValue(i,"pod_clpt_ind_seq") ==""){
	  	    			comboTxt = "1";
	  	    	}else{
	  	    			comboTxt =sheetObjects[0].CellValue(i,"pod_clpt_ind_seq");
	  	    	}
	   	 	    formObj.combo_pod_seq.InsertItem(del_cnt, comboTxt, comboTxt);
	   	 	    formObj.combo_pod_seq.Index2=0;

	   	 	    del_cnt=del_cnt+1;
	   	 	    //ComBtnEnable("btn_changeCrn");
	   	 	    
		 	    break;
	    		
	    	}
	    }
	    
	    //alert(searched_crn_flg +' + ' + combo_in_vvd);
	    
	    if (searched_crn_flg =="Y" && combo_in_vvd==""){
    		searched_crn_flg =""; // SEARCH05를 실행 시키기 위해서
    		ComBtnDisable("btn_changeCrn");
    	}
	    
	    // Vessel 정보만 체크하기 위해서
    	if (text.length == 9 && searched_crn_flg == "" && combo_in_vvd =="") {
    		doActionIBSheet(sheetObjects[1], document.form, SEARCH05);
    		formObj.frm_vsl_call_ref_no.focus();
    	}
    	
    	// reset flag
    	combo_in_vvd ="";
    }
    
    /**
     * Multi Combo의 값을 변경하는 경우 이벤트 처리
     * @param Object  comboObj   Multi-Combo Object
     * @param Integer value      Multi-Combo의 인덱스값
     * @param String  text       Multi-Combo의 Text값
     * @return void
     * @version 2015.04.20
     **/
    function combo_pod_seq_OnChange(comboObj, value, text){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	if(sheetObjects[1].RowCount > 0) {
    		for (var i=0; i<=sheetObjects[1].RowCount; i++){
    			
    			if(sheetObjects[1].CellValue(i, "pod_clpt_ind_seq") == document.getElementById("combo_pod_seq").text
	    				&& sheetObjects[1].CellValue(i,"vvd_number") == document.getElementById("combo_vvd_cd").text){
	    			formObj.frm_vps_eta_dt.value = sheetObjects[1].CellValue(i,"vps_eta_dt");
	       		}	
	    	}
    	}
    }
    