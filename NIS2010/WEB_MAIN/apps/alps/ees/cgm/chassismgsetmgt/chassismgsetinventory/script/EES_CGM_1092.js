/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1092.js
*@FileTitle : 체류 기간별 Chassis 수량집계 inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.17 조재성
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.13 신혜정 [CHM-201115037-01] Location 'USNYC' default 셋팅    
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1092 : EES_CGM_1092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1092() {
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
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * @param 없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
 */ 
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var sheetObject1 = sheetObjects[0];
      var sheetObject2 = sheetObjects[1];

      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

         	case "btn_retrieve":
        		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
        		}
        		formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.         		
                break;

            case "btn_new":
            	initControl();
                break;

            case "btn_downexcel":
            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break;

            case "btn_env_setting":
            	formObject.action = "EES_CGM_1094.do";
            	formObject.pgmNo.value = "EES_CGM_1094";
            	formObject.submit();
                break;
                
            case "btns_crnt_loc_cd":	// Location Popup
                var tmp = formObject.location.text;
            	if(tmp == "RCC"){
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
            	} else if(tmp == "LCC") {
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	} else if(tmp == "SCC") {
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	}
            	break;
            	
            case "btns_crnt_yd_cd":		// Yard
            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
            	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
            	break;
            	
            case "btns_vndr":
            	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "0,1,1,1,1,1", true, false);
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
 * IBSheet Object를 배열로 등록 <br>
 * @param  {object} sheet_obj	필수
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
  */
 function setSheetObject(sheet_obj){

    sheetObjects[sheetCnt++] = sheet_obj;
		
 }

 /**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
  */
 function loadPage() {
    for(i=0;i<sheetObjects.length;i++){

     		//khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);
     		//khlee-마지막 환경 설정 함수 추가
         ComEndConfigSheet(sheetObjects[i]);

    }
     
 }

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.05
 */     
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.WaitImageVisible = false;
  	// axon event 등록
    axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
  	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
  	axon_event.addListener('change', 'obj_change', 'vndr_seq');
  	axon_event.addListener('change', 'aciac_div_cd_change', 'aciac_div_cd');
  	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
  	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
  	axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd');
  	axon_event.addListenerForm('keyup', 'obj_keyup', form);    
    
    /**
     * 20091019 떨림현상 제거 start
     */ 
 	// Multi Combo 초기화
 	comboObjects[comboCnt++] = document.location;
 	comboObjects[comboCnt++] = document.aciac_div_cd;
 	comboObjects[comboCnt++] = document.chss_pool_cd;
 	comboObjects[comboCnt++] = document.group1;
 	comboObjects[comboCnt++] = document.eq_tpsz_cd;
	comboObjects[comboCnt++] = document.agmt_lstm_cd;
	comboObjects[comboCnt++] = document.chss_mvmt_sts_cd;
 	comboObjects[comboCnt++] = document.atch_bare;
 	comboObjects[comboCnt++] = document.dmg_snd;
 	
  	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
    }  
  	
  	// Active St. MultiCombo 값 초기화
  	var arrActive = new Array();
  	arrActive[0] = "A|Active";
  	arrActive[1] = "I|In-active";
  	makeComboObject(document.form.aciac_div_cd, arrActive, 1, 0, 0);
  	
  	//Group MultiCombo 값 초기화
  	var arrGroup = new Array();
  	arrGroup[0] = "1|Type/Size";
  	arrGroup[1] = "2|LCC[Loc]";
  	arrGroup[2] = "3|Office";
  	arrGroup[3] = "4|SCC[Loc]";
  	arrGroup[4] = "5|Yard";
  	arrGroup[5] = "6|Lease term";
  	arrGroup[6] = "7|Lessor";
  	arrGroup[7] = "8|Mvmt Status";
  	makeComboObject(document.form.group1, arrGroup, 1, 0, 1);
 	
  	// Attach/Bare 값 초기화
  	var arrActive = new Array();
  	arrActive[0] = "ATTACHED|Attached";
  	arrActive[1] = "BARE|Bare";
  	makeComboObject(document.form.atch_bare, arrActive, 1, 0, 1);
  	
  	// Damage/Sound 값 초기화
  	var arrActive = new Array();
  	arrActive[0] = "DAMAGE|Damage";
  	arrActive[1] = "SOUND|Sound";
  	makeComboObject(document.form.dmg_snd, arrActive, 1, 0, 1);
  	
  	/*
    // Location MultiCombo 값 설정
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

	// CP MultiCombo 값 설정
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);

	// Type Size MultiCombo 값 설정
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	
	// Lease Term MultiCombo 값 설정
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	
	// Movement Status MultiCombo 값 설정
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
	
	// LongstayEnv 헤더 값 설정
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC07);
	*/
  	
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	
	initControl();
    
    /**
     * 20091019 떨림현상 제거 end
     */
    aciac_div_cd_change();

    sheetObj.WaitImageVisible = true; 
}
 

  /**
   * Form의 Conrol 를 초기화 시킨다. <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.07.16
   */
 function initControl(){
  	 var formObj = document.form;
  	 var sheetObj = sheetObjects[0];
  	 
  	 // Form Object 초기화
  	 with(formObj){
  		 crnt_loc_cd.value  = "USNYC"; // USNYC default 셋팅
  		 crnt_yd_cd.value   = "";
  		 staying_days.value	= "";
  		 vndr_seq.value		= "";
  		 include_np.checked = false;
  		 include_status_lst.checked = false;
  		 include_out_gated.checked  = false; 
  	 }
  	 
  	 // MultiCombo 초기화
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].Text2 = "";
  	 }
  	 
  	 // Sheet Object 초기화
  	 sheetObj.RemoveAll();
  	 sheetObj.ColHidden("group1") = true;
	 
	 // 초기값 설정

  	 comboObjects[1].Index2 = 0;
	 comboObjects[2].Index2 = 0;
	 
	 formObj.staying_days.value = "0";
	 
	 comboObjects[3].Index = 1;		// change event 를 발생시키기 위해 Index 를 사용
	 //comboObjects[4].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
	 //comboObjects[5].Index = 2;		// change event 를 발생시키기 위해 Index 를 사용
    
	 //location popup선택 이벤트 처리.
	 comboObjects[0].Index2 = 0;	// change event 를 발생시키지 않기 위해 Index2 를 사용
	 document.group1.Code = "2"; 	// LCC
  	 
  	formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
 }


   /**
  * 시트 초기설정값, 헤더 정의 <br>
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
  * @return 없음
  * @author 조재성
  * @version 2009.07.21
	*/
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;
	 var sheetID = sheetObj.id;
     switch(sheetID) {

         case "sheet1":
             with (sheetObj) {

                 // 높이 설정
                 style.height = 390;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(2, 1, 6, 100);
                 
                 var HeadTitle1 = "|Seq.|Type/Size|Total|0 or Over|0 or Over|Today-15|Today-15|16-30|16-30|31-50|31-50|51-100|51-100|101-180|101-180|181 or Over|181 or Over";
                 var HeadTitle2 = "|Seq.|Type/Size|Total|13Oct08 or over|13Oct08 or over|13Oct08-28Sep08|13Oct08-28Sep08|27Sep08-13Sep08|27Sep08-13Sep08|12Sep08-24Aug08|12Sep08-24Aug08|23Aug08-05Jul08|23Aug08-05Jul08|04Jul08-16Apr08|04Jul08-16Apr08|15Apr08 or over|15Apr08 or over"; 
                 
                 var headCount = ComCountHeadTitle(HeadTitle1);
                 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true); 

				 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				 InitDataProperty(0, cnt++ , dtHiddenStatus,50,	daCenter,	true,	"hdnStatus");
				 InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter,	true,	"Seq");
				 InitDataProperty(0, cnt++ , dtData,	   	80, daCenter,	true,	"group1"						,	false,	"", dfNone, 0, 	false,	true); 
				 InitDataProperty(0, cnt++ , dtAutoSum,    	75, daRight,	true,	"chss_mvmt_dt_tot"				,   false,	"", dfNumber, 0,  false,	true);
				 InitDataProperty(0, cnt++ , dtAutoSum,  	58, daRight,    false,	"chss_mvmt_dt_0_or_over"		, 	false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_0_or_over_rate"	, 	false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,  	58, daRight,    false,	"chss_mvmt_dt_today_15"			, 	false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_today_15_rate"	,	false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,  	58, daRight,	false,	"chss_mvmt_dt_16_30"			,   false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,   	58, daRight,	false,	"chss_mvmt_dt_16_30_rate"		,   false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,  	58, daRight,    false,	"chss_mvmt_dt_31_50"			,   false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_31_50_rate"		,   false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_51_100"			,  	false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum, 	58, daRight,	false,	"chss_mvmt_dt_51_100_rate"		,   false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_101_180"			,  	false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,	  	58, daRight,	false,	"chss_mvmt_dt_101_180_rate"		,  	false,	"", dfNone, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,    	58, daRight,	false,	"chss_mvmt_dt_181_over"			,	false,	"", dfNumber, 0,  false,  true);
				 InitDataProperty(0, cnt++ , dtAutoSum,	  	73, daRight,	false,	"chss_mvmt_dt_181_over_rate"	,	false,	"", dfNone, 0,  false,  true);

				 CountPosition = 0;

                 EditableColorDiff = false;
            }
             break;

         case "sheet2": // t1sheet1 init
         	with (sheetObj) {

         		// 높이 설정
         		style.height = 80;

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

         		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         		InitColumnInfo(11, 0, 0, true);

         		// 해더에서 처리할 수 있는 각종 기능을 설정한다
         		InitHeadMode(true, true, true, true, false, false)
         		var HeadTitle = "|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";

         		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         		InitHeadRow(0, HeadTitle, true);

         		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         		InitDataProperty(0,	cnt++,	dtStatus,	50,		daCenter,	true,	"ibflag");
         	  //InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"stay_dys_inp_usr_id",	false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
         		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
         	}
         	break;                 
     }
 }

/**
 * Sheet관련 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
 */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

     	
       case IBSEARCH:      //조회
        // Form Object 값 설정
    	formObj.f_cmd.value = SEARCH;
 		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
 		
 		if(formObj.include_np.checked){
 			formObj.include_np.value = "Y";
 		} else {
 			formObj.include_np.value = "";
 		}
 		
 		if(formObj.include_status_lst.checked){
 			formObj.include_status_lst.value = "Y";
 		} else {
 			formObj.include_status_lst.value = "";
 		}
    
 		if(formObj.include_out_gated.checked){
 			formObj.include_out_gated.value = "Y";
 		} else {
 			formObj.include_out_gated.value = "";
 		}
 		
 		/* chungpa 20091125 radio에서 combo로 대체됨.
 		//attached / bare
    	if(formObj.rdo_atch_bare[0].checked)
    	{
    		formObj.atch_bare.value = formObj.rdo_atch_bare[0].value;
    	}else
    	{
    		formObj.atch_bare.value = formObj.rdo_atch_bare[1].value;
    	}
    	
    	//damage / sound
    	if(formObj.rdo_dmg_snd[0].checked)
    	{
    		formObj.dmg_snd.value = formObj.rdo_dmg_snd[0].value;
    	}else
    	{
    		formObj.dmg_snd.value = formObj.rdo_dmg_snd[1].value;
    	}
    	*/

    	
    	
 		// 조회실행
 		if(validateForm(sheetObj,formObj,sAction))
 		{
	 		sheetObj.WaitImageVisible=false;
	 		ComOpenWait(true);
 			
 			var sXml = sheetObj.GetSearchXml("EES_CGM_1092GS.do" , FormQueryString(formObj));
 			var strStayingDays = formObj.staying_days.value + " or Over";
 			
 			sheetObj.cellValue2(0,4) = strStayingDays;
 			sheetObj.cellValue2(0,5) = strStayingDays;
 			sheetObj.cellValue2(1,4) = strStayingDays;
 			sheetObj.cellValue2(1,5) = strStayingDays;
 			sheetObj.LoadSearchXml(sXml);
 			
	 		ComOpenWait(false);

 		}
        break;
   		
       case IBSEARCH_ASYNC01:	// Location Combo 조회
   		formObj.f_cmd.value = SEARCH;
   		formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 (Location)
   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));

   		var sStr = ComGetEtcData(sXml,"comboList");    			
   		var arrStr = sStr.split("@");

   		// combo control, 결과 문자열, Text Index, Code Index
	makeComboObject(formObj.location, arrStr, 1, 1, 0);
   		break;

       case IBSEARCH_ASYNC02:	// Yard 에 대한 Validation 체크 
	   	formObj.f_cmd.value = COMMAND01;
	   	formObj.yd_cd.value = formObj.crnt_yd_cd.value;
	   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
	   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
	   	
	   	if(sCheckResult == COM_VALIDATION_FALSE){
	   		ComShowCodeMessage('CGM10009','Yard');
	   		formObj.crnt_yd_cd.value = "";
	   		formObj.crnt_yd_cd.focus();
	   	}
	   	break;       		
	   	
       case IBSEARCH_ASYNC03:	// CP Combo 조회

		formObj.f_cmd.value = SEARCH02;
       	var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
       	ss = ComCgmXml2ComboString(sXml, "TOTAL");
       	var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
       	//IBSHEET GRID 밖에 있는 콤보
       	makeCPMultiCombo(formObj.chss_pool_cd, cols, 0, 0);
       	break;
       	
    	case IBSEARCH_ASYNC04:	// Type Size Combo 조회
    		formObj.f_cmd.value = SEARCH04;
    		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"comboList");
			var arrStr = sStr.split("@");
			
	  		makeComboObject(formObj.eq_tpsz_cd, arrStr, 0, 0, 0);
	  		//comboObjects[6].DeleteItem(1);
	       	break;  
	       	
    	case IBSEARCH_ASYNC05:	// Term Code Combo 조회
	       	formObj.f_cmd.value = SEARCH;
	       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	   			    			
	   		var sStr = ComGetEtcData(sXml,"comboList");    			
	   		var arrStr = sStr.split("@");

	  		makeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0, 0);
	  		comboObjects[5].DeleteItem(0);
	       	break;
	       	
    	case IBSEARCH_ASYNC06:	// Movement Status Combo 조회
        	formObj.f_cmd.value = SEARCH13;
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			    			
			var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols[0], cols[1], 0);
     	  	break;
     	  	
    	case IBSEARCH_ASYNC07:
    		sheetObj.RemoveAll();
    		formObj.f_cmd.value = SEARCH01;
 			var sXml = sheetObj.GetSearchXml("EES_CGM_1092GS.do" , FormQueryString(formObj));
 			sheetObj.LoadSearchXml(sXml);
 			break;
    	case IBSEARCH_ASYNC08:
	       	//formObj.f_cmd.value = SEARCH;
	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value = SEARCH17;
	    	var location = formObj.location.text;
	    	
	    	if(location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value = "RCC";
	    		formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_loc_cd.value;
	    	}else if(location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value = "LCC";
	    		formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
	    	}else if(location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value = "SCC";
	    		formObj.eq_orz_cht_scc_cd.value = formObj.crnt_loc_cd.value;
	    	}else
	    	{
	    		formObj.eq_orz_cht_chktype.value = "";
	    		formObj.eq_orz_cht_scc_cd.value = "";
	    	}
     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));    	   			    			
	   		// 데이터 건수
	        var dataCount = ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.crnt_loc_cd.value = "";
	        }
	        formObj.crnt_loc_cd.focus(); //validation후 focus는 location으로 가게 만든다. 
	   		break;
    		
    	case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.SpeedDown2Excel(-1);
            break;
            
    	case IBRESET:
    	  	var idx = 0
    		var sXml2 = document.form2.sXml.value;
    		var arrXml = sXml2.split("|$$|");

    		//Location
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
    		// combo control, 결과 문자열, Text Index, Code Index
	  		makeComboObject(formObj.location, arrStr1, 1, 1, 0);       
    		idx++;        		

	  		//Co-Op Pool
    		if ( arrXml[idx] == null ) {return;}
    		var cols1 = ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
    		//IBSHEET GRID 밖에 있는 콤보
    		makeCPMultiCombo(formObj.chss_pool_cd, cols1, 0, 0);
    		idx++;
    		
    		//Type/Size
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr2 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
    		makeComboObject(formObj.eq_tpsz_cd, arrStr2, 0, 0, 0);
	  		idx++;
	  		
    		//Lease Term
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr3 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
	  		makeComboObject(formObj.agmt_lstm_cd, arrStr3, 0, 0, 0);
	  		comboObjects[5].DeleteItem(0); // <= chungpa 20091229 확인 요망.
	  		idx++;
	  		
	  		//MVMT Status
    		if ( arrXml[idx] == null ) {return;}
			var cols2 = ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
     	  	idx++;
     	  	
     	  	//LongstayEnv 헤더 값 설정
    		sheetObjects[1].RemoveAll();
    		if ( arrXml[idx] == null ) {return;}
 			sheetObjects[1].LoadSearchXml(arrXml[idx]);
 			idx++;
 			
    		break;            
     }
 }

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.07.21
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
					crnt_loc_cd.focus();
					return false;
				} else {
					if(crnt_loc_cd.value.length != 5) // Location 자리수 고정 size=5
					{
						ComShowCodeMessage('CGM10044','Location(5)');
						crnt_loc_cd.focus();
						return false;
    				}else
    				{
					return true;
    				}
    			}
				
				break;
		}
		return true;
	}
}
 
/**
 * 콜백 함수. <br>
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */   
function callBackLocation(aryPopupData, row, col, sheetIdx){
     	 
    var formObj = document.form;
    var location = formObj.location.text;
    var crntLocCd = "";
    var i = 0;
    
    for(i = 0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][8];
    	}
     		
    	if(i < aryPopupData.length - 1){
    		crntLocCd = crntLocCd + ",";
     	}
    }
     	 
    formObj.crnt_loc_cd.value = crntLocCd;
     	 
}	 

/**
 * 콜백 함수. <br>
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */   
function callBackYard(aryPopupData, row, col, sheetIdx){
     	 
    var formObj = document.form;
    var crntYdCd = "";
    var i = 0;
    
    for(i = 0; i < aryPopupData.length; i++){
    	
    	crntYdCd = crntYdCd + aryPopupData[i][3];
    	
    	if(i < aryPopupData.length - 1){
    		crntYdCd = crntYdCd + ",";
     	}
    }
     	 
    formObj.crnt_yd_cd.value = crntYdCd;
     	 
}
	
/**
 * 콜백 함수. <br>
 * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */   
function callBackVendor(aryPopupData, row, col, sheetIdx){
    	 
   	var formObj = document.form;
    var vndrSeq = "";
    var i = 0;
    	 
    for(i = 0; i < aryPopupData.length; i++){
    	vndrSeq = vndrSeq + aryPopupData[i][2];
    		
    	if(i < aryPopupData.length - 1){
    		vndrSeq = vndrSeq + ",";
    	}
    }
    	 
    formObj.vndr_seq.value = vndrSeq;
    	 
}	
 
 /**
  * 콜백 함수. <br>
  * Total display 
  * @param  {Object} sheetObj		필수	 SheetObj
  * @param  {Int} row				필수 선택한 Row
  * @return 없음
  * @author 조재성
  * @version 2009.10.01
  */ 
 function sheet1_OnChangeSum(sheetObj, Row)
 {
 	with(sheetObj)
 	{
 		SumText(0, "Seq") = "";
 		SumText(0, "group1") = "Total/%";
 		//SumText(0, "TPSZ") = "Grand Total";
 		
 		CellAlign(Row, "group1") = daCenter;
 	}
 }

/**
 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.07.16
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		if(RowCount!='0') // 0이 아니면
		{
			SumText(0, "chss_mvmt_dt_0_or_over_rate") = (SumValue(0, "chss_mvmt_dt_0_or_over_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_today_15_rate") = (SumValue(0, "chss_mvmt_dt_today_15_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_16_30_rate") = (SumValue(0, "chss_mvmt_dt_16_30_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_31_50_rate") = (SumValue(0, "chss_mvmt_dt_31_50_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_51_100_rate") = (SumValue(0, "chss_mvmt_dt_51_100_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_101_180_rate") = (SumValue(0, "chss_mvmt_dt_101_180_rate")/RowCount).toFixed(2) +"%";
			SumText(0, "chss_mvmt_dt_181_over_rate") = (SumValue(0, "chss_mvmt_dt_181_over_rate")/RowCount).toFixed(2) +"%";
		}
		else
		{
			SumText(0, "chss_mvmt_dt_0_or_over_rate") = "0%";
			SumText(0, "chss_mvmt_dt_today_15_rate") = "0%";
			SumText(0, "chss_mvmt_dt_16_30_rate") = "0%";
			SumText(0, "chss_mvmt_dt_31_50_rate") = "0%";
			SumText(0, "chss_mvmt_dt_51_100_rate") = "0%";
			SumText(0, "chss_mvmt_dt_101_180_rate") = "0%";
			SumText(0, "chss_mvmt_dt_181_over_rate") = "0%";
		}
		
	}
}

 /**
  * Sheet2 의 OnSearchEnd 이벤트처리 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {string} ErrMsg		필수 String
  * @return 없음
  * @version 2009.07.24
  */ 
 function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 {
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];    	
    var formObj = document.form;
 	with(sheetObj)
 	{
 		//var HeadTitle1 = "|Seq.|Type/Size|Total|0 or Over|0 or Over|Today-15|Today-15|16-30|16-30|31-50|31-50|51-100|51-100|101-180|101-180|181 or Over|181 or Over";
        //var HeadTitle2 = "|Seq.|Type/Size|Total|13Oct08 or over|13Oct08 or over|13Oct08-28Sep08|13Oct08-28Sep08|27Sep08-13Sep08|27Sep08-13Sep08|12Sep08-24Aug08|12Sep08-24Aug08|23Aug08-05Jul08|23Aug08-05Jul08|04Jul08-16Apr08|04Jul08-16Apr08|15Apr08 or over|15Apr08 or over";
 		
 		if(RowCount=='0') // env setting값이 없으면 기본값으로 세팅한다. 
 		{
 			DataInsert(-1);
 			cellValue(1,"n1st_inq_fm_dys") = "0";
 			cellValue(1,"n1st_inq_to_dys") = "15";
 			cellValue(1,"n2nd_inq_fm_dys") = "16";
 			cellValue(1,"n2nd_inq_to_dys") = "30";
 			cellValue(1,"n3rd_inq_fm_dys") = "31";
 			cellValue(1,"n3rd_inq_to_dys") = "50";
 			cellValue(1,"n4th_inq_fm_dys") = "51";
 			cellValue(1,"n4th_inq_to_dys") = "100";
 			cellValue(1,"n5th_inq_fm_dys") = "101";
 			cellValue(1,"n5th_inq_to_dys") = "180";
 			RowStatus(1) = "R";
 		}
 		
 		// 헤더 0
		//sheetObject1.cellValue2(0,4) = "0 or Over";
 		//sheetObject1.cellValue2(0,5) = "0 or Over";
 		
 		sheetObject1.cellValue2(0,6) = cellValue(1,"n1st_inq_fm_dys") + "-" + cellValue(1,"n1st_inq_to_dys");
 		sheetObject1.cellValue2(0,7) = cellValue(1,"n1st_inq_fm_dys") + "-" + cellValue(1,"n1st_inq_to_dys");
 		
 		sheetObject1.cellValue2(0,8) = cellValue(1,"n2nd_inq_fm_dys") + "-" + cellValue(1,"n2nd_inq_to_dys");
 		sheetObject1.cellValue2(0,9) = cellValue(1,"n2nd_inq_fm_dys") + "-" + cellValue(1,"n2nd_inq_to_dys");
 		
 		sheetObject1.cellValue2(0,10) = cellValue(1,"n3rd_inq_fm_dys") + "-" + cellValue(1,"n3rd_inq_to_dys");
 		sheetObject1.cellValue2(0,11) = cellValue(1,"n3rd_inq_fm_dys") + "-" + cellValue(1,"n3rd_inq_to_dys");
 		
 		sheetObject1.cellValue2(0,12) = cellValue(1,"n4th_inq_fm_dys") + "-" + cellValue(1,"n4th_inq_to_dys");
 		sheetObject1.cellValue2(0,13) = cellValue(1,"n4th_inq_fm_dys") + "-" + cellValue(1,"n4th_inq_to_dys");
 		
 		sheetObject1.cellValue2(0,14) = cellValue(1,"n5th_inq_fm_dys") + "-" + cellValue(1,"n5th_inq_to_dys");
 		sheetObject1.cellValue2(0,15) = cellValue(1,"n5th_inq_fm_dys") + "-" + cellValue(1,"n5th_inq_to_dys");
 		
 		var tStr = parseInt(cellValue(1,"n5th_inq_to_dys"))+1;
 		sheetObject1.cellValue2(0,16) = tStr + " or Over";
 		sheetObject1.cellValue2(0,17) = tStr + " or Over";
            
     		

   
     		// 헤더 1
    	// 현재 날짜 가져오기
    	var sysDate   = new Date();
    	var year = sysDate.getFullYear();
    	var month = sysDate.getMonth()+1;
    	var date = sysDate.getDate();
    	var today = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
    	
    	var monthNames = new Array();
    	monthNames[0] = "Jan";
    	monthNames[1] = "Feb";
    	monthNames[2] = "Mar";
    	monthNames[3] = "Apr";
    	monthNames[4] = "May";
    	monthNames[5] = "Jun";
    	monthNames[6] = "Jul";
    	monthNames[7] = "Aug";
    	monthNames[8] = "Sep";
    	monthNames[9] = "Oct";
    	monthNames[10] = "Nov";
    	monthNames[11] = "Dec";

    	var tmp_1  = new Date();
    	var tmp_2  = new Date();
    	var tmp_3  = new Date();
    	var tmp_4  = new Date();
    	var tmp_5  = new Date();
    	var tmp_6  = new Date();
    	var tmp_7  = new Date();
    	var tmp_8  = new Date();
    	var tmp_9  = new Date();
    	var tmp_10  = new Date();
    	var tmp_11 = new Date();
    	var tmp2;
    	
    	tmp_1.setDate(sysDate.getDate()- parseInt(cellValue(1,"n1st_inq_fm_dys")) )
        year = tmp_1.getFullYear();
        month = tmp_1.getMonth();
        date = tmp_1.getDate();
        tmp2 = new String(year);
        var d_n1st_inq_to_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_2.setDate(sysDate.getDate()- parseInt(cellValue(1,"n1st_inq_to_dys")) )
        year = tmp_2.getFullYear();
        month = tmp_2.getMonth();
        date = tmp_2.getDate();
        tmp2 = new String(year);
        var d_n1st_inq_fm_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        var tmp_2 = new Date();
        tmp_3.setDate(sysDate.getDate()- parseInt(cellValue(1,"n2nd_inq_fm_dys")) )
        year = tmp_3.getFullYear();
        month = tmp_3.getMonth();
        date = tmp_3.getDate();
        tmp2 = new String(year);
        var d_n2nd_inq_to_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_4.setDate(sysDate.getDate()- parseInt(cellValue(1,"n2nd_inq_to_dys")) )
        year = tmp_4.getFullYear();
        month = tmp_4.getMonth();
        date = tmp_4.getDate();
        tmp2 = new String(year);
        var d_n2nd_inq_fm_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_5.setDate(sysDate.getDate()- parseInt(cellValue(1,"n3rd_inq_fm_dys")) )
        year = tmp_5.getFullYear();
        month = tmp_5.getMonth();
        date = tmp_5.getDate();
        tmp2 = new String(year);
        var d_n3rd_inq_to_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_6.setDate(sysDate.getDate()- parseInt(cellValue(1,"n3rd_inq_to_dys")) )
        year = tmp_6.getFullYear();
        month = tmp_6.getMonth();
        date = tmp_6.getDate();
        tmp2 = new String(year);
        var d_n3rd_inq_fm_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_7.setDate(sysDate.getDate()- parseInt(cellValue(1,"n4th_inq_fm_dys")) )
        year = tmp_7.getFullYear();
        month = tmp_7.getMonth();
        date = tmp_7.getDate();
        tmp2 = new String(year);
        var d_n4th_inq_to_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_8.setDate(sysDate.getDate()- parseInt(cellValue(1,"n4th_inq_to_dys")) )
        year = tmp_8.getFullYear();
        month = tmp_8.getMonth();
        date = tmp_8.getDate();
        tmp2 = new String(year);
        var d_n4th_inq_fm_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_9.setDate(sysDate.getDate()- parseInt(cellValue(1,"n5th_inq_fm_dys")) )
        year = tmp_9.getFullYear();
        month = tmp_9.getMonth();
        date = tmp_9.getDate();
        tmp2 = new String(year);
        var d_n5th_inq_to_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        
        tmp_10.setDate(sysDate.getDate()- parseInt(cellValue(1,"n5th_inq_to_dys")) )
        year = tmp_10.getFullYear();
        month = tmp_10.getMonth();
        date = tmp_10.getDate();
        tmp2 = new String(year);
        var d_n5th_inq_fm_dys = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
     		
		sheetObject1.cellValue2(1,4) = "0 or Over";
 		sheetObject1.cellValue2(1,5) = "0 or Over";
 		
 		sheetObject1.cellValue2(1,6) = d_n1st_inq_fm_dys + "-" + d_n1st_inq_to_dys;
 		sheetObject1.cellValue2(1,7) = d_n1st_inq_fm_dys + "-" + d_n1st_inq_to_dys;
 		
 		sheetObject1.cellValue2(1,8) = d_n2nd_inq_fm_dys + "-" + d_n2nd_inq_to_dys;
 		sheetObject1.cellValue2(1,9) = d_n2nd_inq_fm_dys + "-" + d_n2nd_inq_to_dys;
 		
 		sheetObject1.cellValue2(1,10) = d_n3rd_inq_fm_dys + "-" + d_n3rd_inq_to_dys;
 		sheetObject1.cellValue2(1,11) = d_n3rd_inq_fm_dys + "-" + d_n3rd_inq_to_dys;
 		
 		sheetObject1.cellValue2(1,12) = d_n4th_inq_fm_dys + "-" + d_n4th_inq_to_dys;
 		sheetObject1.cellValue2(1,13) = d_n4th_inq_fm_dys + "-" + d_n4th_inq_to_dys;
 		
 		sheetObject1.cellValue2(1,14) = d_n5th_inq_fm_dys + "-" + d_n5th_inq_to_dys;
 		sheetObject1.cellValue2(1,15) = d_n5th_inq_fm_dys + "-" + d_n5th_inq_to_dys;
 		
 		tmp_11.setDate(sysDate.getDate() - parseInt(cellValue(1,"n5th_inq_to_dys")) - 1 )
        year = tmp_11.getFullYear();
        month = tmp_11.getMonth();
        date = tmp_11.getDate();
        tmp2 = new String(year);
        var tStr2 = ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
 		sheetObject1.cellValue2(1,16) = tStr2 + " or Over";
 		sheetObject1.cellValue2(1,17) = tStr2 + " or Over";
 		
 		//폼에 입력
 		formObj.n1st_inq_fm_dys.value = cellValue(1,"n1st_inq_fm_dys"); 
 		formObj.n1st_inq_to_dys.value = cellValue(1,"n1st_inq_to_dys");
 		formObj.n2nd_inq_fm_dys.value = cellValue(1,"n2nd_inq_fm_dys"); 
 		formObj.n2nd_inq_to_dys.value = cellValue(1,"n2nd_inq_to_dys"); 
 		formObj.n3rd_inq_fm_dys.value = cellValue(1,"n3rd_inq_fm_dys"); 
 		formObj.n3rd_inq_to_dys.value = cellValue(1,"n3rd_inq_to_dys");
 		formObj.n4th_inq_fm_dys.value = cellValue(1,"n4th_inq_fm_dys");
 		formObj.n4th_inq_to_dys.value = cellValue(1,"n4th_inq_to_dys");
 		formObj.n5th_inq_fm_dys.value = cellValue(1,"n5th_inq_fm_dys"); 
 		formObj.n5th_inq_to_dys.value = cellValue(1,"n5th_inq_to_dys")
 	}
 }     
 
  /**
   * Sheet1 의 OnMouseDown 이벤트처리 <br>
   * @param  {Integer} Button	필수 Integer
   * @param  {integer} Shift	필수 Integer
   * @param  {Integer} X	필수 Integer
   * @param  {integer} Y	필수 Integer
   * @return 없음
   * @author 조재성
   * @version 2009.09.23
   */ 
   function sheet1_OnMouseDown (Button, Shift, X, Y){
  	 var sheetObj = sheetObjects[0];
  	 var formObj = document.form;
  	 if(sheetObj.rowcount + 2 == sheetObj.mouseRow)
  	 {
  		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
  		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
  		 //alert(groupValue1);
  		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
  	 }
  	 
   }
  /**
   * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
   * @author 조재성
   * @version 2009.07.28
   */      
  function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
  	
  	var eqKndCd			= EQ_KND_CD_CHASSIS;
  	var location		= comboObjects[0].Code;
  	var crntLocCd		= document.form.crnt_loc_cd.value;
  	var crntYdCd		= document.form.crnt_yd_cd.value;
  	var aciacDivCd		= comboObjects[1].Code;
  	var chssPoolCd		= comboObjects[2].Code;
  	var includeNp		= "";
  	if(document.form.include_np.checked){
  		includeNp = "Y";
  	}
	
  	var include_status_lst	= "";
	if(document.form.include_status_lst.checked){
		include_status_lst = "Y";
	}
	
	var include_out_gated = "";
	if(document.form.include_out_gated.checked){
		include_out_gated = "Y";
	}
	
	
	 
  	var stayingDays	= document.form.staying_days.value;
  	var group1 = comboObjects[3].Code;
  	var groupValue1 = sheetObj.cellValue(Row, "group1");
  	var s_group1 = "";
  	var s_group1_val = "";
  	var s2_group1 = "";
  	var s2_group1_val = "";

  	var s3_gtotal = "";
  	if(groupValue1.substring(0,9) == "Sub Total")
  	{

  	}else if(groupValue1 == "Total/%"){
  		s3_gtotal = "GTOTAL";
  	}else{
  		s2_group1 = "";
  		s2_group1_val = "";
  	}
  	var agmtLstmCd = comboObjects[5].Text;
  	var vndrSeq = document.form.vndr_seq.value;
  	var chssMvmtStsCd = comboObjects[6].Text;
  	var eqTpszCd = comboObjects[4].Text;
  	var colSaveName = sheetObj.ColSaveName(Col);
  	

 	var inqFmDys = '';
 	var inqToDys = '';
 	
 	if(parseInt(Col) == 3) // total
 	{

 	}else if(parseInt(Col) == 4 || parseInt(Col) == 5) // 0 or over
 	{
 		s_group1 = "TotalColumn";
 		s_group1_val = "";
 	}else if(parseInt(Col) == 6 || parseInt(Col) == 7) // 0 - 15
 	{
 		inqFmDys = document.form.n1st_inq_fm_dys.value;
 		inqToDys = document.form.n1st_inq_to_dys.value;
 	}else if(parseInt(Col) == 8 || parseInt(Col) == 9) // 16 - 30
 	{
 		inqFmDys = document.form.n2nd_inq_fm_dys.value;
 		inqToDys = document.form.n2nd_inq_to_dys.value;
 	}else if(parseInt(Col) == 10 || parseInt(Col) == 11) // 31 - 50
 	{
 		inqFmDys = document.form.n3rd_inq_fm_dys.value;
 		inqToDys = document.form.n3rd_inq_to_dys.value;
 	}else if(parseInt(Col) == 12 || parseInt(Col) == 13) // 51 - 100
 	{
 		inqFmDys = document.form.n4th_inq_fm_dys.value;
 		inqToDys = document.form.n4th_inq_to_dys.value;
 	}else if(parseInt(Col) == 14 || parseInt(Col) == 15) // 101 - 180
 	{
 		inqFmDys = document.form.n5th_inq_fm_dys.value;
 		inqToDys = document.form.n5th_inq_to_dys.value;
 	}else if(parseInt(Col) == 16 || parseInt(Col) == 17) // 181 or Over
 	{
 		inqFmDys = parseInt(document.form.n5th_inq_to_dys.value)+1;
 		inqToDys = ''   		
 	}
	
 	
 	
	//attached / bare
	var atch_bare = document.atch_bare.Code;
	/* chungpa 20091125 radio에서 combo로 대체됨.
	var atch_bare = "";
	if(document.form.rdo_atch_bare[0].checked)
	{
		atch_bare = document.form.rdo_atch_bare[0].value;
	}else
	{
		atch_bare = document.form.rdo_atch_bare[1].value;
	}*/

	//damage / sound
	var dmg_snd = document.dmg_snd.Code;
	/* chungpa 20091125 radio에서 combo로 대체됨.
	var dmg_snd = "";
	if(document.form.rdo_dmg_snd[0].checked)
	{
		dmg_snd = document.form.rdo_dmg_snd[0].value;
	}else
	{
		dmg_snd = document.form.rdo_dmg_snd[1].value;
	}*/

  	var param = "?program_id=1092";
  	param = param + "&inq_fm_dys=" + inqFmDys;
  	param = param + "&inq_to_dys=" + inqToDys;       	
  	param = param + "&eq_knd_cd=" + eqKndCd;
  	param = param + "&location=" + location;
  	param = param + "&crnt_loc_cd=" + crntLocCd;
  	param = param + "&crnt_yd_cd=" + crntYdCd;
  	param = param + "&aciac_div_cd=" + aciacDivCd;
  	param = param + "&chss_pool_cd=" + chssPoolCd;
  	param = param + "&include_np=" + includeNp;
  	param = param + "&include_status_lst=" + include_status_lst;
  	param = param + "&include_out_gated=" + include_out_gated;
  	param = param + "&staying_days=" + stayingDays;
  	param = param + "&eq_tpsz_cd=" + eqTpszCd;
  	param = param + "&group1=" + group1;
  	param = param + "&group_value1=" + groupValue1;
  	param = param + "&agmt_lstm_cd=" + agmtLstmCd;
  	param = param + "&vndr_seq=" + vndrSeq;
  	param = param + "&chss_mvmt_sts_cd=" + chssMvmtStsCd;
  	param = param + "&s_group1=" + s_group1;
  	param = param + "&s_group1_val=" + s_group1_val;
  	param = param + "&s2_group1=" + s2_group1;
  	param = param + "&s2_group1_val=" + s2_group1_val;
  	param = param + "&s3_gtotal=" + s3_gtotal;
  	param = param + "&atch_bare=" + atch_bare;
  	param = param + "&dmg_snd=" + dmg_snd;
  	
  	//var seq = sheetObj.cellValue(Row, "Seq");
  	if(Col >= 3) // && seq != '')
  	{
    	ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 550, "", "1,0", true, false);
    }else
    {
    	ComShowCodeMessage('CGM10016');
    }
   
  }      

/**
 * Location Multi-Combo 의 OnChange 이벤트처리 <br>
 * @param  {object} ComboObj	필수	 Sheet Object
 * @param  {int} 	Index_Code	필수
 * @param  {string} Text		필수
 * @return 없음
 * @version 2009.07.16
 */ 
function location_OnChange(ComboObj, Index_Code, Text){
	document.form.crnt_loc_cd.value = "";

	
  	/*arrGroup[1] = "2|LCC[Loc]";
  	arrGroup[2] = "3|Office";
  	arrGroup[3] = "4|SCC[Loc]";
  	arrGroup[4] = "5|Yard";
  	*/
  	
	if(Text == "RCC")
	{
		document.group1.Code = "2"; 	//LCC
	}else if(Text == "LCC")
	{
		document.group1.Code = "4";		//SCC
	}else if(Text == "SCC")	
	{
		document.group1.Code = "5";		//Yard
	}
	
}

/**
 * Group1 Multi-Combo 의 OnChange 이벤트처리 <br>
 * @param  {object} ComboObj	필수	 Sheet Object
 * @param  {int} 	Index_Code	필수
 * @param  {string} Text		필수
 * @return 없음
 * @version 2009.07.16
 */ 
function group1_OnChange(comboObj, Index_Code, Text){
	//Group MultiCombo 값 초기화
  	var arrGroup = new Array();
	var sheetObj = sheetObjects[0];
  	
  	// Sheet Object 타이틀 값 설정
  	sheetObj.RemoveAll();
  	sheetObj.cellValue2(0,"group1") = comboObj.Text;
  	sheetObj.cellValue2(1,"group1") = comboObj.Text;
  	
  	// Sheet Object Group 컬럼 숨기기
  	if(sheetObj.cellValue(0,"group1") == ""){
  		sheetObj.ColHidden("group1") = true;
  	} else {
  		sheetObj.ColHidden("group1") = false;
  	}
}

 /** 
  * Object 의 activate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.07.17
  */
 function obj_activate(){
   	ComClearSeparator(event.srcElement);
 } 
 
 /** 
  * Object 의 deactivate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.07.17
  */
 function obj_deactivate(){
	 
	//ComChkObjValid(event.srcElement);
 }
  
 /** 
  * Object 의 Keypress 이벤트에 대한 처리  <br>
  * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.07.17
  */ 
 function obj_keypress(){
   	obj = event.srcElement;
   	if(obj.dataformat == null) return;
   	 	
   	window.defaultStatus = obj.dataformat;

   	switch(obj.dataformat) {
   	 	case "ym": case "ymd":
   	 		ComKeyOnlyNumber(obj);
   	 		break;
   	 	case "int":
   	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
   	 		else ComKeyOnlyNumber(obj);
   	        break;
   	 	case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;    
   	    case "eng":
  	    	if(obj.name=="vndr_seq") 
  	    		ComKeyOnlyNumber(obj,",");
  	    	else 
  	    		ComKeyOnlyAlphabet();
   	        break;
   	    case "engup":
  	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
  	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
   	        else ComKeyOnlyAlphabet('upper');
   	        break;
   	    case "engdn":
   	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
   	        else ComKeyOnlyAlphabet('lower');
   	        break;
   	}
 } 
 /** 
  * aciac_div_cd 의 change 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.08.07
  */
  function aciac_div_cd_change(){
	  var formObj = document.form;
	  if(formObj.aciac_div_cd.Text != "Active")
	  {
		  form.include_status_lst.disabled = false;
	  }
	  else
	  {
		  form.include_status_lst.checked = false;
		  form.include_status_lst.disabled = true;
	  }
  }
  
 /** 
  * Object 의 change 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */  
 function obj_change(){
 	 var formObj = document.form;
 	 var sheetObj = sheetObjects[0]; 
 	 obj = event.srcElement;
 	 switch(obj.name){

 	   	case "vndr_seq":
 	   		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
 	   		var arrVndrSeq = vndrSeq.split(",");
 	   		
 	   		for(var i = 0; i < arrVndrSeq.length; i++){
 	   		// 입력오류 체크 (예> ,,)
 	 			if(arrVndrSeq[i] == ''){
 	 				ComShowCodeMessage('CGM10009','Lessor');
 	 				formObj.vndr_seq.value = "";
     	 				ComSetFocus(formObj.vndr_seq);
     	 				break;
     	 			}
     	   		}
     	   		break;
     	 }   
     }

   /** 
 * Object 의 obj_focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */  
function obj_focusout(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
	 	case "crnt_yd_cd":
	 		break;
	 }
}

 /** 
  * Combo Object 초기화  <br>
  * @param  {object} comboObj	필수 Combo Object
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */ 
 function initCombo(comboObj) {
 	switch(comboObj.id) {
    	case "location":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 100;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	            comboObj.UseAutoComplete = true;
  	        }
  	        
  	        break;
  	        
    	case "aciac_div_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 100;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	            comboObj.UseAutoComplete = true;
  	        }
  	        
  	        break;
  	        
    	case "chss_pool_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 100;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	            comboObj.UseAutoComplete = true;
  	        }
  	        
  	        break;
  	        
    	case "group1":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 170;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	            comboObj.UseAutoComplete = true;
  	        }
  	        
  	        break;    
  	        
    	case "eq_tpsz_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 150;
  	            MultiSelect = true;
  	            MaxSelect = 100;	    
  	            UseCode = true;
  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
  	        }
  	        
  	        break;
  	        
    	case "agmt_lstm_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 180;
  	            MultiSelect = true;
  	            MaxSelect = 100;	    
  	            UseCode = true;
  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
  	        }
  	        
  	        break;
  	        
    	case "chss_mvmt_sts_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 150;
  	            MultiSelect = true;
  	            MaxSelect = 100;	    
  	            UseCode = true;
  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
  	        }
  	        
  	        break;
    	case "atch_bare":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 170;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	        }  	        
  	        break;    
    	case "dmg_snd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 170;
  	            MultiSelect = false;
  	            MaxSelect = 1;	    
  	            UseCode = true;
  	            Enable = true;
  	        }  	        
  	        break;     	    
  	      
 	}
 }       

 /** 
  * Combo Object 에 값을 추가하는 처리 <br>
  * @param  {object} cmbObj	필수 Combo Object
  * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
  * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
  * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
  * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */ 
 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	
 	if(opt == 0) {
 		for (var i = 0; i < arrStr.length;i++ ) {
 			var arrCode = arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i = 0; i < arrStr.length;i++ ) {
 			var arrCode = arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	
 	cmbObj.Index2 = "" ;
 }   
 
 /** 
  * CP Combo Object 에 값을 추가하는 처리 <br>
  * @param  {object} cmbObj	필수 Combo Object
  * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
  * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
  * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */ 
 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
 
    	// LOOP를 돌리기 위해 데이타 갯수를 구함 
    	if(arrStr == undefined ){
    		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
    	} else {
        	var arrCode = arrStr[0].split("|");
      	var arrCode2 = arrStr[1].split("|");
          	
          	for (var i = 0; i < arrCode.length;i++ ) {
          		var arrCode3 = arrCode[i].split("|");
          		var arrCode4 = arrCode2[i].split("|");
          		if(i==0)
          		{
          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		else
          		{
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		
          	}
    	}

    	cmbObj.Index2 = "" ;
    } 

  /** 
   * 기본조건 입력 후 ENTER키 적용 <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.08.14
   */ 
   function enterFire() {
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
	 	 
   }    

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	 	 	case "crnt_loc_cd":
		 		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_loc_cd.value = "";
		 				ComSetFocus(formObj.crnt_loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.crnt_loc_cd.value != ''){
		    	 		if(formObj.crnt_loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
	 	   	case "crnt_yd_cd":
		   		var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
		   		if( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == '')) // 다중 yard code(,로 연결됨)이면 검사하지 않는다. 
		   		{
		   			break;
		   		}
		   		var arrCrntYdCd = crntYdCd.split(",");
		   		for(var i = 0; i < arrCrntYdCd.length; i++){
		   			// 입력오류 체크 (예> ,,)
		 			if(arrCrntYdCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Yard');
		 				formObj.crnt_yd_cd.value = "";
		 				ComSetFocus(formObj.crnt_yd_cd);
		 				break;
		 			}
		   		}
		   		
		 		//if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
		 		if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7){
		 			
		 			//chungpa 20091015 MULTI일경우 YD check안함
		 			//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	 	 		} 
	 	 		break;
    	 }
}   
	/* 개발자 작업  끝 */