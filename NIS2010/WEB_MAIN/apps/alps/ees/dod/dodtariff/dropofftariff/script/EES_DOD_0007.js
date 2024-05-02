/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0007.js
*@FileTitle : Tariff Registration Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 신영재
*@LastVersion : 1.0
* 2015.11.03 신영재
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
     * @class ees_dod_0007 : ees_dod_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dod_0007() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.doActionIBSheet2       = doActionIBSheet2;
    }
    
   	/* 개발자 작업	*/
    
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
       /*******************************************************/
       var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {

            	case "btn_retrieve":
            		
            		
            		if(beforetab == 0) { // general tab
            		doActionIBSheet(sheetObject, formObject, SEARCH);
            		}else if (beforetab ==1){ // special tab 
            		doActionIBSheet2(sheetObject2,formObject,SEARCH);
            		}
	             	break;
	             	
            	case "btn_new":
    	            
            		ComResetAll();
            		ControlOfcCd(); // SELOPE 인 경우 다시 초기화 해주어야함
            		if(beforetab == 0) { // general tab
            			formObject.s_trf_div_cd.value = "G"
                	}else if (beforetab == 1){ // special tab 
                		formObject.s_trf_div_cd.value = "S"
                	}
            		
            		
             		break;
       

            	case "btn_confirm":
            		if(beforetab == 0) {  // general tab
                 	doActionIBSheet(sheetObject, formObject, MULTI);
            		}else if (beforetab ==1){ // special tab 
                	doActionIBSheet2(sheetObject2,formObject,MULTI);
                		}
            		break;
            		
            	case "btn_calendar":  // 캘린더 호출
            		//alert("calendar");
				//	if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(formObject.s_frm_eff_dt, formObject.s_to_eff_dt, 'yyyy-MM-dd');
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 // IBTab 초기화
        for(k=0;k<tabObjects.length;k++){
           initTab(tabObjects[k],k+1);
        }
		for(i=0;i<sheetObjects.length;i++){
		
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			   
			//Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
		//	sheetObjects[0].ExtendLastCol = false;
			
			//html컨트롤 이벤트초기화
			initControl();
			
		}
		//alert("EES_DOD_0007");
		ControlOfcCd();
    }

    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj) {
    	tabObjects[tabCnt++] = tab_obj;
    }
    		
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
    	switch (tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt = 0;
    			InsertTab(cnt++, "Region/Country", -1);
    			InsertTab(cnt++, "Special Customer", -1);
    		}
    		break;
    	}
    }
    	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
    	var objs = document.all.item("tabLayer");
    	var formObj = document.form;

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
//
//    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
//    	//------------------------------------------------------//
    	beforetab = nItem;
    	if(beforetab == 0){  //general tab
    		formObj.s_trf_div_cd.value = "G"  
    		//	alert(formObj.s_trf_div_cd.value);
    	}else if(beforetab == 1){ // special tab 
    		formObj.s_trf_div_cd.value = "S"
    			//alert(formObj.s_trf_div_cd.value);
    	}
    }
    		
    function initControl(){

		axon_event.addListenerFormat("keypress", "obj_KeyPress", form);
		axon_event.addListenerForm("change","obj_OnChange", form);
		axon_event.addListenerFormat ("beforeactivate", "obj_activate", form);
		axon_event.addListenerForm ("beforedeactivate", "obj_deactivate", form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		
    	
    }
    
	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}
	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
	}
	
	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	function obj_blur() {
		var formObj  = document.form;
		
		with (event.srcElement) {	
			switch (name) {	
				case "":
							
					
					break;
					
				default:
					break;
			}
		}
	}
		
    /**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// Enter키를 눌렀을때 Tab키처럼 작동
			EditEnterBehavior = "tab";

			WaitImageVisible = false;
			CountPosition = 2;

			switch (shtObj.id) {

	

			case "sheet1":
				var cnt = 0;
				// 높이 설정
				style.height = GetSheetHeight(19);

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
				InitRowInfo(1, 1, 18, 500);

				// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(true, true, true, true, false, false);

				// 컬럼 헤더타이틀
				var HeadTitle  = "|SEQ||Tariff Seq|Effective|Expire|Country|BKG-POD|POD|RTN-Location|Yard|Origin" +
				                  "|TP/SZ|CUR|Amount|Exemption|Request User|Request Date" +
				                  "|Confirm User|Confirm Date|File|Remark|Status|";    

			

				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true); // 갯수 설정 ? 14 --?

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE,      WIDTH,   DATAALIGN, COLMERGE, SAVENAME,                           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]
				InitDataProperty(0, cnt++, dtDataSeq,         30,    daCenter,    true,    "seq",                                 false,    "",      dfNone,    0,     false,      false);    // 전체 seq
				InitDataProperty(0, cnt++, dtDummyCheck,   30,    daCenter,    true,    "chk");
				InitDataProperty(0, cnt++, dtHidden,         50,    daCenter,    true,    "drp_off_chg_trf_seq",              false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "drp_off_chg_trf_eff_dt",              false,    "",      dfDateYmd,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "drp_off_chg_trf_exp_dt",              false,    "",      dfDateYmd,    0,     false,      false);
				InitDataProperty(0, cnt++, dtHidden,         65,    daCenter,    true,    "drp_off_chg_trf_cnt_cd",      		   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "del_cd",     						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtHidden,       45,    daCenter,    true,    "pod_cd",      						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "cntr_rtn_loc_cd",   			       false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "cntr_rtn_yd_sfx_cd",     			   false,    "",      dfNone,    0,     false,      false);

				InitDataProperty(0, cnt++, dtCombo,         65,    daCenter,    true,    "pol_conti_cd",      				   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "cntr_tpsz_cd",    					   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "curr_cd",     						   false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daRight,    true,    "drp_off_chg_trf_amt",     			   false,    "",      dfFloat,    2,     false,      false);
				InitDataProperty(0, cnt++, dtCheckBox,         100,    daCenter,    true,    "drp_off_chg_trf_expt_flg",        false,    "",      dfNone,    0,     false,      false, -1 , false,true,"",false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "upd_usr_id",    					   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "upd_dt",     						   false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtHidden,         100,    daCenter,    true,    "drp_off_chg_trf_cfm_usr_id",   		   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,    daCenter,    true,    "drp_off_chg_trf_cfm_dt", 			       false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtPopupEdit,     60,	daCenter,  	false,	"atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         250,    daLeft,    true,    "drp_off_chg_trf_rmk",    			   false,    "",      dfNone,    0,     true,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,    daCenter,    true,    "drp_off_chg_trf_cfm_flg",    			   false,    "",      dfNone,    0,     true,      false);

				InitDataProperty(0, cnt++, dtHidden,        40,	daCenter,  	false,	"atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
				
				ShowButtonImage = 2;
				
				InitDataCombo(0, "pol_conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
		//		HeadRowHeight = 20;//19; // 18;
		//		SelectHighLight = false;

			//	ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";

				// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
				//EditableColorDiff = false;

				break;
				
				
			case "sheet2":
				var cnt = 0;
				// 높이 설정
				style.height = GetSheetHeight(19);

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
				InitRowInfo(1, 1, 18, 500);

				// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(true, true, true, true, false, false);

				// 컬럼 헤더타이틀
				var HeadTitle  = "|SEQ||Tariff Seq.|Effective|Expire|Country|BKG-POD|RTN-Location|Yard|Origin" +
				                  "|TP/SZ|Customer Code|Customer Name|RFA No.|S/C No.|Exemption|CUR|Amount|Request User|Requst Date" +
				                  "|Confirm User|Confirm Date|File|Remark|Status|";    

			

				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true); // 갯수 설정 ? 0, 0, false --> 14, 0 , false --> 14 th column 까지 다 보임

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE,      WIDTH,   DATAALIGN, COLMERGE, SAVENAME,                           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]
				InitDataProperty(0, cnt++, dtDataSeq,       30,    daCenter,    true,    "seq",                                 false,    "",      dfNone,    0,     false,      false);    // 전체 seq
				InitDataProperty(0, cnt++, dtDummyCheck,   30,    daCenter,    true,    "chk");
				InitDataProperty(0, cnt++, dtHidden,       90,    daCenter,    true,    "drp_off_chg_trf_seq",              false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "drp_off_chg_trf_eff_dt",              false,    "",      dfDateYmd,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "drp_off_chg_trf_exp_dt",              false,    "",      dfDateYmd,    0,     false,      false);
				InitDataProperty(0, cnt++, dtHidden,         65,    daCenter,    true,    "drp_off_chg_trf_cnt_cd",      		   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "del_cd",     						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "cntr_rtn_loc_cd",   			       false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "cntr_rtn_yd_sfx_cd",     			   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtCombo,         65,    daCenter,    true,    "pol_conti_cd",      				   false,    "",      dfNone,    0,     false,      false);
				
				
				
				
				InitDataProperty(0, cnt++, dtData,         65,    daCenter,    true,    "cntr_tpsz_cd",    					   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "spcl_cust_cnt_seq",     						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         250,    daLeft,    true,    "spcl_cust_nm",     						   false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "rfa_no",     						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "sc_no",     						   false,    "",      dfNone,    0,     false,      false);
				
				
				InitDataProperty(0, cnt++, dtCheckBox,      100,    daCenter,    true,    "drp_off_chg_trf_expt_flg",   	   false,    "",      dfNone,    0,     false,      false, -1 , false,  true,  "",  false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "curr_cd",     						   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daRight,    true,    "drp_off_chg_trf_amt",     			   false,    "",      dfFloat,    2,     false,      false);
				
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "upd_usr_id",    					   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "upd_dt",     						   false,    "",      dfNone,    0,     false,      false);
				
				InitDataProperty(0, cnt++, dtHidden,         100,    daCenter,    true,    "drp_off_chg_trf_cfm_usr_id",   		   false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,    daCenter,    true,    "drp_off_chg_trf_cfm_dt", 			       false,    "",      dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++, dtPopupEdit,     60,	daCenter,  	false,	"atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
				InitDataProperty(0, cnt++, dtData,         250,    daLeft,    true,    "drp_off_chg_trf_rmk",    			   false,    "",      dfNone,    0,     true,      false);
				InitDataProperty(0, cnt++, dtHidden,         50,    daCenter,    true,    "drp_off_chg_trf_cfm_flg",    			   false,    "",      dfNone,    0,     true,      false);

				InitDataProperty(0, cnt++, dtHidden,        40,	daCenter,  	false,	"atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
				
				ShowButtonImage = 2;
				
				InitDataCombo(0, "pol_conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
		//		HeadRowHeight = 20;//19; // 18;
		//		SelectHighLight = false;

			//	ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";

				// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
				//EditableColorDiff = false;

				break;
		}
	}
}
	

	// Sheet관련 프로세스 처리 (General)
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case SEARCH:    
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_DOD_0007GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				
				break;
				
			case MULTI:
			
				formObj.f_cmd.value = MULTI; // HTMLACTION ==> sheet1_
				var saveString = ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet1_");
				var xmlStr = sheetObj.GetSaveXml("EES_DOD_0007GS.do",FormQueryString(formObj) + "&" + saveString);
				 if(ComGetEtcData(xmlStr, "TRANS_RESULT_KEY")=="S"){
					 ComShowCodeMessage('DOD00009');
					 
					 doActionIBSheet(sheetObj,formObj,SEARCH);
				 }
				 break;
				

		}
	}


	// Sheet2 관련 프로세스 처리 (Special) 
	function doActionIBSheet2 (sheetObj, formObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case SEARCH:   
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_DOD_0007GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				
				break;
				
			case MULTI:
				
				formObj.f_cmd.value = MULTI01; // HTMLACTION ==> sheet2_ 
				var saveString = ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet2_");
				 var xmlStr = sheetObj.GetSaveXml("EES_DOD_0007GS.do",FormQueryString(formObj) + "&" + saveString);
				 if(ComGetEtcData(xmlStr, "TRANS_RESULT_KEY")=="S"){
					 ComShowCodeMessage('DOD00009');
					 
					 doActionIBSheet2(sheetObj,formObj,SEARCH);
					 	 }
				 break;
				

		}
	}
	  function ControlOfcCd(){
		  var formObj = document.form;
		  if (formObj.login_ofc_cd.value == "SELOPE"){  //로그인한 ID 가 본사 장비팀인경우
			  formObj.login_ofc_cd.readOnly = false;   // 화면에 나오는 login office 의 readonly 풀고, 입력 가능하도록 수정
			  formObj.login_ofc_cd.className = "input"; 
			  //formObj.login_ofc_cd.value = "";
			  //formObj.s_ofc_cd.value = ""; // hidden 으로 들어가있는 ofc_cd 의 값도 초기화 (VO 로 넘어가는 실제 값)
		  }
	  }
	  
	// login_ofc_cd 값이 바뀌면 hidden 의 ofc_cd 값도 바꿔줌(VO 로 넘어가는 실제 값)
	  function obj_OnChange(){
		  var elementName = window.event.srcElement.getAttribute("name");
		  var obj = event.srcElement;
		  var formObj = document.form;
		  switch(elementName){
		  	case "login_ofc_cd":
		  		formObj.s_ofc_cd.value = formObj.login_ofc_cd.value;
		  		return;
		  		
		  		//아래로직 삭제
		  		if(obj.value.trim() == ""){
		  			return;
		  		}
		  		
		  	    var param = "f_cmd=" + SEARCH01 + "&s_value=" + obj.value;
		  	    var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
		  	    
		  	    var count = ComGetEtcData(sXml, "count");
		  	    var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		  	    if(result == "S"){
		  	     if(parseInt(count) == 0) {  // 사용 불가로 나올 시 
		  	      ComShowMessage(ComGetMsg("COM12114", "Office Code"));
		  	      obj.value = "";
		  	      obj.focus();
		  	      formObj.s_ofc_cd.value = "";
		  	     }else{
		  	    	formObj.s_ofc_cd.value = formObj.login_ofc_cd.value;
			  	//	alert(formObj.s_ofc_cd.value);	
		  	   // s_ofc_cd 를 바꾸는데 event 가 발생, 하지만 발생한 event 의 name 이 login_ofc_cd 로 남아있어서
		  	   // 본 case 문을 다시 타므로 아래와 같이 강제 assign
			  		window.event.srcElement.setAttribute("name","s_ofc_cd");  
		  	     }
		  	    }
		  	   break;

		  	case "s_cnt_cd" :
		  		if(obj.value.trim() == ""){
		  			return;
		  		}
		  	    var param = "f_cmd=" + SEARCH11 + "&s_value=" + obj.value;
		  	    var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
		  	    
		  	    var count = ComGetEtcData(sXml, "count");
		  	    var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		  	    
		  	    
		  	    if(result == "S"){
		  	     if(parseInt(count) == 0) {
		  	      ComShowMessage(ComGetMsg("COM12114", "Country Code"));
		  	      obj.value = "";
		  	      obj.focus();
		  	     }
		  	    }
		  	   break;
		  	   
		  	case "s_rtn_loc_cd":
				if(obj.value.trim() == ""){
					return;
				}
				
				var param = "f_cmd=" + SEARCH08 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "RTN-Location"));
						obj.value = "";
						obj.focus();							
					}
				}
		
				break;	  
		  }	
	  }
	  
	  function obj_KeyPress(){ // s_cnt_cd , login_ofc_cd 대문자로 강제함
		  obj = event.srcElement;
		  if(obj.dataformat == null) return;
		  window.defaultStatus = obj.dataformat;
		  
		  switch(obj.dataformat){
		  case  "engup" :
		  	ComKeyOnlyAlphabet('upper');
		   	break;
			case "ymd":
				var f = event.srcElement.value;
				if(f.value != null){
					sVal1 = f.value.replace(/\/|\-|\./g, "");		
					if(sVal1.length > 0 && !ComIsNumber(sVal1)){
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;
						return false;
					}
				}
				
				break;
		  	
		  }
	  }
	

		function pointAutoMove(val) {
			if ( val.length == 8  ) {
				document.form.s_frm_eff_dt.focus();
			}
		}	
	  
	//업무 자바스크립트 OnFocus 이벤트 처리
	  function obj_activate() {
	  //마스크 구분자 없애기
	     // ComClearSeparator (event.srcElement);
	  }

	  //업무 자바스크립트 Onblur 이벤트 처리
	  function obj_deactivate(){
			var f = document.form.s_frm_eff_dt;
			var t = document.form.s_to_eff_dt;
			sVal1 = f.value.replace(/\/|\-|\./g, "");
			sVal2 = t.value.replace(/\/|\-|\./g, "");		
			switch (event.srcElement.dataformat) {
			case "ymd":
				if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 's_frm_eff_dt') {
					event.srcElement.value = "";
					ComShowCodeMessage("DOD00019", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;
					return false;
				}			
				if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 's_to_eff_dt') {				
					event.srcElement.value = "";
					ComShowCodeMessage("DOD00019", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;
					return false;
				}
				break;
			}
		}
		
		/**
	     * sheet1 OnClick Event 처리
	     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
	     * 
	     */
	    function sheet1_OnClick(sheetObj, Row, Col, Val) {
	     	with(sheetObj) {
	     		switch(Col){

	     			case SaveNameCol("atch_file_lnk_cnt"):
	     				if(sheetObj.CellValue(Row, "drp_off_chg_trf_seq") == ''){
	     					return; // 생성된 tariff가 없으면 파일첨부할 수 없음.
	     				}
	     			
	    				dodFileUploadPopUp(sheetObj, Row, "TRF", "Y", "");
	    				break;
	     		}

	     	}
	    }
	    
	    /**
	     * sheet2 OnClick Event 처리
	     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
	     * 
	     */
	    function sheet2_OnClick(sheetObj, Row, Col, Val) {
	     	with(sheetObj) {
	     		switch(Col){

	     			case SaveNameCol("atch_file_lnk_cnt"):
	     				if(sheetObj.CellValue(Row, "drp_off_chg_trf_seq") == ''){
	     					return; // 생성된 tariff가 없으면 파일첨부할 수 없음.
	     				}
	     			
	    				dodFileUploadPopUp(sheetObj, Row, "TRF", "Y", "");
	    				break;
	     		}

	     	}
	    }
