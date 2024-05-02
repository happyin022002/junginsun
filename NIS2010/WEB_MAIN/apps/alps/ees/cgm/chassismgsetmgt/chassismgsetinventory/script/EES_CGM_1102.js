/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1102.js
*@FileTitle : Chassis Variation Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.31 조재성
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
 * @class EES_CGM_1102 : EES_CGM_1102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_1102() {
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
 * @version 2009.07.31
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
 				if(formObject.doc_type[0].checked==true) // summary
 				{
            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            		}
 				}else //detail
 				{
            		if(validateForm(sheetObject2,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject2, formObject, IBSEARCH);
            		}
 				}
            	formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.             	
                break;

            case "btn_new":
            	initControl();
                break; 

            case "btn_downexcel":
 				if(formObject.doc_type[0].checked==true) // summary
 				{
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 				}else 
 				{
 					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
 				}
 				
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
				
		case "btns_Calendar2" :		// Agreement Date (To Date)
//				var cal = new ComCalendar();
			var cal = new ComCalendarFromTo();
//	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
    		cal.select(formObject.inq_fm_dys,  formObject.inq_to_dys,  'yyyy-MM-dd');
// 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
 * @version 2009.08.10
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
 * @version 2009.07.31
 */
function loadPage() 
{
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
 * @version 2009.08.10
 */     
function sheet1_OnLoadFinish(sheetObj) {
    var formObject = document.form;    	
    sheetObj.WaitImageVisible = false;
 
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	axon_event.addListener('click', 'doc_type_change', 'doc_type');
	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
	axon_event.addListener('keyup', 'enterFire', 'inq_fm_dys');
	axon_event.addListener('keyup', 'enterFire', 'inq_to_dys');
	axon_event.addListenerForm('keyup', 'obj_keyup', form);	 
	
 	// Multi Combo 초기화
 	comboObjects[comboCnt++] = document.location;
  	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
    }
  	/*
    // Location MultiCombo 값 설정
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);	
	*/
  	
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	 
	// Sheet Object 초기화
    initControlWithParam();
    sheetObjects[0].RemoveAll();    	
    
    sheetObj.WaitImageVisible = true; 
}

/**
  * Form의 Conrol 를 PRAM으로 초기화 시킨다. <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.08.10
  */
function initControlWithParam(){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
  	 
    // 초기값 설정
    comboObjects[0].DeleteItem("SCC"); //document. RCC/LCC만.
    if(formObj.location_param.value != "")
    {
    	comboObjects[0].Text2 = formObj.location_param.value;
    }else
   	{
    	comboObjects[0].Index2 = 0;
   	}
    formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
    formObj.crnt_loc_cd.value  = "USNYC"; // USNYC default 셋팅
}
   
/**
  * Form의 Conrol 를 초기화 시킨다. <br>
  * @param  없음
  * @return 없음
  * @author 김창식
  * @version 2009.07.16
  */
function initControl(){
	var formObj = document.form;
  	var sheetObj = sheetObjects[0];
  	var sheetObj2 = sheetObjects[1];
  	 
  	// Form Object 초기화
  	with(formObj){
  		 crnt_loc_cd.value  = "USNYC"; // USNYC default 셋팅
  		 include_np.checked = false;
         include_en.checked = false;
         inq_fm_dys.value = "";
         inq_to_dys.value = "";
         doc_type[0].checked=true;
    }
  	 
  	// MultiCombo 초기화
  	for(var i=0; i<comboObjects.length; i++){
  		comboObjects[i].Text2 = "";
  	}
  	 
  	// Sheet Object 초기화
  	sheetObj.RemoveAll();
  	sheetObj2.RemoveAll();
  	
	// 초기값 설정
  	comboObjects[0].DeleteItem("SCC"); //document. RCC/LCC만.
	comboObjects[0].Index2 = 0;	// change event 를 발생시키지 않기 위해 Index2 를 사용
	
	// sheet위치도 원위치로 해준다. 
	doc_type_change();
	
	formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
}

/**
  * 시트 초기설정값, 헤더 정의 <br>
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
  * @return 없음
  * @author 조재성
  * @version 2009.07.30
  */
function initSheet(sheetObj,sheetNo) 
{
	  var cnt = 0;
	  var sheetID = sheetObj.id;
      switch(sheetID) {
        	
      case "sheet1":
        with (sheetObj) {

            // 높이 설정
            style.height = 422;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            //MergeSheet = msNone;
            MergeSheet = msAll;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 6, 100);
            
            //var HeadTitle = "Seq.|LCC|Reason|Total|20'|40'|45'";
            var HeadTitle = "LCC|Reason|Total|20'|40'|45'";
            var headCount = ComCountHeadTitle(HeadTitle);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false) 
             
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);


			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtDataSeq,	100,   daCenter,	false,   "Seq");
			InitDataProperty(0, cnt++ , dtData,  	150,   daCenter,  	true,   "location",				false,	"",      dfNone,      	0,     false,	true);
			InitDataProperty(0, cnt++ , dtData,   	190,   daCenter,  	false,  "eq_aset_sts_cd",  		false,  "",      dfNone,     	0,     false,   true);
			InitDataProperty(0, cnt++ , dtData,  	180,   daRight,     false,  "eq_aset_sts_cd_total",	false,  "",      dfNone,      	0,     false,   true);
			InitDataProperty(0, cnt++ , dtData,  	150,   daRight,  	false,  "eq_tp_sz_20", 			false,  "",      dfNone,  		0,     false,   true);
			
			InitDataProperty(0, cnt++ , dtData,		150,   daRight,  	false,  "eq_tp_sz_40", 			false,  "",      dfNone,      	0,     false,   true);
			InitDataProperty(0, cnt++ , dtData,		130,   daRight,  	false,  "eq_tp_sz_45", 			false,  "",      dfNone,     	0,     false,   true);


			CountPosition = 0;
            
			EditableColorDiff = false;
       }
       break;
       
    case "sheet2":
        with (sheetObj) {

            // 높이 설정
            style.height = 302;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 6, 100);
            
            var HeadTitle1 = "|Seq.|Chassis No.|Type/Size|Office|Previous Status|Previous Status|Previous Status|Previous Status|After Status|After Status|After Status|After Status";
            var HeadTitle2 = "|Seq.|Chassis No.|Type/Size|Office|Status|Event Date|LCC|Yard|Status|Event Date|LCC|Yard";
            
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false) 

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,   daCenter,  	true,    "hdnStatus");
            InitDataProperty(0, cnt++ , dtDataSeq, 		70,   daCenter,  	true,    "Seq");
            InitDataProperty(0, cnt++ , dtData,			100,  daCenter,  	true,    "eq_no",				false,	"",      dfNone,      	0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,			90,   daCenter,  	true,    "eq_tpsz_cd",   		false,	"",    	 dfNone,   		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,			80,   daCenter,		true,    "onh_ofc_cd",   	 	false,	"",      dfNone,   		0,     true,       true);
			
            InitDataProperty(0, cnt++ , dtData,			60,   daCenter,  	false,   "pre_eq_aset_sts_cd",	false,	"",      dfNone, 		0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,			85,   daCenter,  	false,   "pre_sts_event_dt",  	false,	"",      dfDateYmd,     0,     true,       true);
            //InitDataProperty(0, cnt++ , dtData,			75,   daCenter,  	false,   "pre_cre_dt",			false,	"",      dfDateYmd,  	0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,			80,   daCenter,  	false,   "pre_sts_event_loc_cd",false,	"",      dfNone,     	0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,			90,   daCenter,  	false,   "pre_sts_evnt_yd_cd",  false,	"",      dfNone,     	0,     true,       true);
			
            InitDataProperty(0, cnt++ , dtData,			60,   daCenter,   	false,   "eq_aset_sts_cd",    	false,	"",      dfNone,     	0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,    	 	85,   daCenter,  	false,   "sts_event_dt",   		false,	"",      dfDateYmd,  	0,     true,       true);
            //InitDataProperty(0, cnt++ , dtData,    	 	75,   daCenter,  	false,   "cre_dt",  			false,	"",      dfDateYmd, 	0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,  		80,   daCenter,  	false,   "sts_event_loc_cd",    false,	"",      dfNone, 		0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,    	 	70,   daCenter,  	false,   "sts_evnt_yd_cd",  	false,	"",      dfNone, 		0,     true,       true);

			CountPosition = 0;
			EditableColorDiff = false;
       }
       break;               

    case "sheet3": // chungpa 20091130 Hidden Sheet를 이용하여 윈도우 깜박임 없앰.
        with (sheetObj) {
            // 높이 설정

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

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
 * @version 2009.07.30
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
     	case IBSEARCH:      //조회
        	// Form Object 값 설정
     		if(formObj.include_np.checked){
 				formObj.include_np.value = "Y";
 			} else {
 				formObj.include_np.value = "";
 			}

 			if(formObj.include_en.checked){
 				formObj.include_en.value = "Y";
 			} else {
 				formObj.include_en.value = "";
 			}	 	
 			
 			if(validateForm(sheetObj,formObj,sAction))
 			{
 				if(formObj.include_en.checked== false) // EN UNCHECKED
 				{
	 				if(formObj.doc_type[0].checked==true) // sheet 1
	 				{
	 			 		sheetObj.WaitImageVisible=false;
	 			 		ComOpenWait(true);

		 				formObj.f_cmd.value = SEARCH;
			 			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			 			var sXml = sheetObj.GetSearchXml("EES_CGM_1102GS.do" , FormQueryString(formObj));
		 				sheetObj.LoadSearchXml(sXml);
		 				
				 		ComOpenWait(false);

	 				}else // sheet 2
	 				{
	 			 		sheetObj.WaitImageVisible=false;
	 			 		ComOpenWait(true);
	 					
		 				formObj.f_cmd.value = SEARCH;
			 			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			 			var sXml = sheetObj.GetSearchXml("EES_CGM_1103GS.do" , FormQueryString(formObj));
		 				sheetObj.LoadSearchXml(sXml);

		 				ComOpenWait(false);
		 				
	 				}
 				}else // EN CHECKED : 조회 시간이 대단히 길기 때문에 BACK END JOB으로 대체한다. 
 				{
	 				if(formObj.doc_type[0].checked==true) // sheet 1
	 				{
						formObj.f_cmd.value = SEARCH01;
			 			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			 			
			 			sheetObj.WaitImageVisible = false; 	//chungpa 20091023 화면 focusing	    	
						ComOpenWait(true);					//chungpa 20091023 화면 focusing
						
						var sXml = sheetObj.GetSearchXml("EES_CGM_1102GS.do" , FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey");
						
						ComOpenWait(true);					//chungpa 20091023 화면 focusing
						if(backEndJobKey.length > 0)
						{
							formObj.back_end_job_key.value = backEndJobKey;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 400000;
							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}		 				
	 				}else // sheet 2
	 				{
						formObj.f_cmd.value = SEARCH01;
			 			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			 			
			 			sheetObj.WaitImageVisible = false; 	//chungpa 20091023 화면 focusing	    	
						ComOpenWait(true);					//chungpa 20091023 화면 focusing
						
						var sXml = sheetObj.GetSearchXml("EES_CGM_1103GS.do" , FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey");
						
						ComOpenWait(true);					//chungpa 20091023 화면 focusing
						if(backEndJobKey.length > 0)
						{
							formObj.back_end_job_key.value = backEndJobKey;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 400000;
							timer=setInterval(getBackEndJobDtlStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}
	 				} 					
 				}
 				
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
 * @version 2009.08.10
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
    				}
				}

 		 		if(inq_fm_dys.value == ''){
        				ComShowCodeMessage('CGM10004','Period ');
        				inq_fm_dys.focus();
        				
        				return false;
        		}	
 		 		if(inq_to_dys.value == ''){
        				ComShowCodeMessage('CGM10004','Period ');
        				inq_to_dys.focus();
        				
        				return false;
        		}
 		 		var dt_str = ComReplaceStr(document.form.inq_fm_dys.value,"-","");
     			var dt_end = ComReplaceStr(document.form.inq_to_dys.value,"-","");
     	        	
   
     	    	if(dt_str != '' && dt_end != ''){
 	    		if(dt_end < dt_str){
 	    			ComShowCodeMessage('COM12133','To date','From date','greater');
 	    			inq_fm_dys.value='';
 	    			
 	    			inq_fm_dys.focus();
 	    			return false;
 	    		}
 	    	}
			break;
        }
	}
    return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.08.10
 */
function validateFormNoPopup(sheetObj,formObj,sAction){
    with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					//ComShowCodeMessage('CGM10004','Location');
					crnt_loc_cd.focus();
					return false;
					}
 		 		if(inq_fm_dys.value == ''){
        				//ComShowCodeMessage('CGM10004','Period ');
        				inq_fm_dys.focus();
        				
        				return false;
        			}	
 		 		if(inq_to_dys.value == ''){
        				//ComShowCodeMessage('CGM10004','Period ');
        				inq_to_dys.focus();
        				
        				return false;
        			}
 		 		 var dt_str = ComReplaceStr(document.form.inq_fm_dys.value,"-","");
     			 var dt_end = ComReplaceStr(document.form.inq_to_dys.value,"-","");
 	        	

 	    		if(dt_str != '' && dt_end != ''){
 	    			if(dt_end < dt_str){
 	    				//ComShowCodeMessage('COM12133','To date','From date','greater');
 	    				inq_fm_dys.value='';
 	    				
 	    				inq_fm_dys.focus();
 	    				return false;
 	    			}
 	    		}

				break;
            }
	}
    return true;
}     
/**
 * 콜백 함수. <br>
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 김창식
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

function sheet1_OnChangeSum(sheetObj, Row )
{
	with(sheetObj)
	{
		//SumText(0,"Seq") = "";
		//SumText(0,"location") = "Grand Total";
		
		//CellAlign(Row, "location") = daCenter;
	}
} 

/**
 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.11.13
 */ 	
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	orderTitle();
	
	with(sheetObj)
	{
		
		//계산후 값을 적용한다. 
		var color1 = RgbColor(255, 220, 220);
		var color2 = RgbColor(220, 220, 255);
		for(var i = 1; i <= LastRow; i ++)
		{
			if( cellValue(i,"eq_aset_sts_cd") == "Sub. Total")
			{
				CellBackColor(i, "eq_aset_sts_cd") = color1;
				CellBackColor(i, "eq_aset_sts_cd_total") = color1;
				CellBackColor(i, "eq_tp_sz_20") = color1;
				CellBackColor(i, "eq_tp_sz_40") = color1;
				CellBackColor(i, "eq_tp_sz_45") = color1;
			}
			
			if( cellValue(i,"location") == "Sts. Total")
			{
				//CellBackColor(i, "location") = color2;
				CellBackColor(i, "eq_aset_sts_cd") = color2;
				CellBackColor(i, "eq_aset_sts_cd_total") = color2;
				CellBackColor(i, "eq_tp_sz_20") = color2;
				CellBackColor(i, "eq_tp_sz_40") = color2;
				CellBackColor(i, "eq_tp_sz_45") = color2;
			}
			
			if( cellValue(i,"eq_aset_sts_cd") == "G. Total")
			{
				CellBackColor(i, "eq_aset_sts_cd") = color1;
				CellBackColor(i, "eq_aset_sts_cd_total") = color1;
				CellBackColor(i, "eq_tp_sz_20") = color1;
				CellBackColor(i, "eq_tp_sz_40") = color1;
				CellBackColor(i, "eq_tp_sz_45") = color1;				
			}
		}
	}
}

 /**
  * Sheet1 의 OnSearchEnd 이벤트처리 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {string} ErrMsg		필수 String
  * @return 없음
  * @version 2009.11.13
  */ 	
 function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 {
 	orderTitle();
 }
 
 /**
  * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
  * @author 조재성
  * @version 2009.07.28
  */      
 function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	 var formObj = document.form;

     if(formObj.doc_type[0].checked==true) // Summary
     {
    	 
     }else //Detail
     {
    	if(Row > 1)
    	{
			if(sheetObj.cellValue(Row, "eq_no") == null || sheetObj.cellValue(Row, "eq_no") == "")
			{
				return;
			}
			var eqNo			= sheetObj.cellValue(Row, "eq_no");
			
			
			var param = "?pgmNo=EES_CGM_1003&eq_no=" + eqNo;
			var seq = sheetObj.cellValue(Row, "Seq");
			if(seq != ''){
				//기존 ComOpenPopup('/hanjin/EES_CGM_1003.do' + param, 1100, 500, "", "1,0", true, false);
				
		  		var pgmNo = 'EES_CGM_1003';
		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			}
    	}
     }
 }           

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */
function domFunFocusDel(a)
{
  	var formObj = document.form;
    obj = event.srcElement;
    if(obj.name=="evnt_dt_str"  ){
 			
    	document.form.evnt_dt_str.value = ComReplaceStr(document.form.evnt_dt_str.value,"-","");
    }
    if(obj.name=="evnt_dt_end"  ){
 			
      		document.form.evnt_dt_end.value = ComReplaceStr(document.form.evnt_dt_end.value,"-","");
    }
  	
    //ComShowMessage("domFunFocusDel");
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
}
/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.31
 */
function obj_activate(){
   	ComClearSeparator(event.srcElement);
} 
 
/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.31
 */
function obj_deactivate(){
    var formObj = document.form;
    obj = event.srcElement;

    if(obj.name=="inq_fm_dys"  ){
        with(formObj){
            var creDtFr = ComReplaceStr(inq_fm_dys.value,"-","");
        }
        ComChkObjValid(event.srcElement);
    }
   	if(obj.name=="inq_to_dys"  ){
   		with(formObj){
       		 var creDtFr = ComReplaceStr(inq_to_dys.value,"-","");
        }
        ComChkObjValid(event.srcElement);
    }    	
}
  
/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
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
	 	case "crnt_loc_cd":

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
 * Summary/Detail Change <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.14
 */ 
function doc_type_change() {
    var formObj = document.form;
	
	document.getElementById('summaryLayer').style.display = "none";
	document.getElementById('detailLayer').style.display = "none";
	
	//챠트
	if(formObj.doc_type[0].checked==true)
	{
		//document.getElementById('chartLayer').style.visibility = 'hidden';
		//document.getElementById('sheetLayer').style.visibility = 'visible';
		document.getElementById('summaryLayer').style.display = "";
		//sheet 초기화
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}else //그래프
	{
		//document.getElementById('sheetLayer').style.visibility = 'hidden';
		//document.getElementById('chartLayer').style.visibility = 'visible';
		document.getElementById('detailLayer').style.display = "";
		//sheet 초기화
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    }
}      
   
/** 
 * 기본조건 입력 후 ENTER키 적용 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.09.28
 */ 
function enterFire() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if(event.keyCode == 13)
	{
		if(validateForm(sheetObj,formObj,IBSEARCH) != false) 
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
    	 }
}   
/**
 * cube로 검색된 결과에, subtotal, grand total title명 붙여주기. 
 * @author 조재성 2009.10.19
 */
function orderTitle()
{
    var formObj = document.form;
    var sheetObj1 = sheetObjects[0];
    var sheetObj2 = sheetObjects[1];
    
    
	if(formObj.doc_type[0].checked==true) // sheet 1
	{
		
		//location에 따른 컬럼 타이틀 적용
		if(comboObjects[0].Code == 'RCC')
			sheetObj1.cellValue(0, "location") = 'LCC[Location]';
		else
			sheetObj1.cellValue(0, "location") = 'SCC[Location]';
		
		if(sheetObj1.rowCount > 0)
		{
			for(var i=1; i< sheetObj1.rowCount+1; i++)
			{
				if(sheetObj1.cellValue(i,"location")=="" && sheetObj1.cellValue(i,"eq_aset_sts_cd")!= "")
				{
					sheetObj1.cellValue(i,"location") = "Sts. Total";
				}else if(sheetObj1.cellValue(i,"location")!="" && sheetObj1.cellValue(i,"eq_aset_sts_cd")== "")
				{
					sheetObj1.cellValue(i,"eq_aset_sts_cd") = "Sub. Total";
				}else if(sheetObj1.cellValue(i,"location")=="" && sheetObj1.cellValue(i,"eq_aset_sts_cd")== "")
				{
					sheetObj1.cellValue(i,"eq_aset_sts_cd") = "G. Total";
					//sheetObj1.RowDelete(i, false); // G.Total은 삭제
				}
			}
		}		
	}else{
		//location에 따른 컬럼 타이틀 적용
		if(comboObjects[0].Code == 'RCC')
		{
			sheetObj2.cellValue(1, "pre_sts_event_loc_cd") = 'LCC';
			sheetObj2.cellValue(1, "sts_event_loc_cd") = 'LCC';
		}
		else
		{
			sheetObj2.cellValue(1, "pre_sts_event_loc_cd") = 'SCC';
			sheetObj2.cellValue(1, "sts_event_loc_cd") = 'SCC';
		}			
	}
	
}
 
/**
 * BackEedJob 관련 Error 처리결과를 메세지로 보여준다.
 * @param errCode
 * @author 조재성
 * @version 20091019
 */
function comShowBackEndErrorMsg(errCode) {
    ComShowCodeMessage(errCode);
 	clearInterval(timer);
 	ComOpenWait(false);
}
/**
 * BackEndJob 처리 함수 Status='3' 이 될때까지 확인한다.
 * @param	{없음}	void 
 * @return	{없슴} 	void 
 * @author 조재성 
 * @version 20091019
 */
function getBackEndJobStatus() {
    var sheetObj = sheetObjects[2]; // chungpa 20091130 Hidden Sheet를 이용하여 윈도우 깜박임 없앰.
    var formObj = document.form;
    formObj.f_cmd.value = SEARCH02;
    
 	var sXml = "";
	sXml = sheetObj.GetSearchXml("EES_CGM_1102GS.do", FormQueryString(formObj));
 	var arrXml = sXml.split("|$$|");
 	var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
 	
 	//ComDebug("chungpa ID: "+formObj.back_end_job_key.value+"   jobState: "+ jobState);
 	
 	if(jobState == "3") {
 	 	getBackEndJobResult();
  	    clearInterval(timer);
    } else if(jobState == "4") {
  	    // BackEndJob을 실패 하였습니다.
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing    	
    } else if(jobState == "5") {
  	    // 이미 BackEndJob 결과 파일을 읽었습니다.
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing    
    }  
}

 /**
  * Detail BackEndJob 처리 함수 Status='3' 이 될때까지 확인한다.
  * @param	{없음}	void 
  * @return	{없슴} 	void 
  * @author 조재성 
  * @version 20091019
  */
 function getBackEndJobDtlStatus() {
    var sheetObj = sheetObjects[2]; // chungpa 20091130 Hidden Sheet를 이용하여 윈도우 깜박임 없앰.
    var formObj = document.form;
    formObj.f_cmd.value = SEARCH02;
    
 	var sXml = "";
	sXml = sheetObj.GetSearchXml("EES_CGM_1103GS.do", FormQueryString(formObj));
 	var arrXml = sXml.split("|$$|");
 	var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
 	
 	//ComDebug("chungpa ID: "+formObj.back_end_job_key.value+"   jobState: "+ jobState);
 	
 	if(jobState == "3") {
 	 	getBackEndJobDtlResult();
  	    clearInterval(timer);
    } else if(jobState == "4") {
  	    // BackEndJob을 실패 하였습니다.
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing   
    } else if(jobState == "5") {
  	    // 이미 BackEndJob 결과 파일을 읽었습니다.
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing  
    } 
 }
/**
 * BackEndJob 결과 처리 함수
 * @param	{없음}	void 
 * @return	{없슴} 	void 
 * @author 조재성 
 * @version 20091019
 */     
function getBackEndJobResult() {
    var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.f_cmd.value = SEARCH03;
 	var sXml = "";
	ComOpenWait(false);	//chungpa 20091023 화면 focusing
	sXml = sheetObj.GetSearchXml("EES_CGM_1102GS.do", FormQueryString(formObj),-1,false);
	var arrXml = sXml.split("|$$|");
	if(arrXml.length > 0) {
		sheetObj.LoadSearchXml(arrXml[0]);
	}
	
	if (sheetObj.RowCount <= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		//끝.
	}   

}

 /**
  * BackEndJob 결과 처리 함수
  * @param	{없음}	void 
  * @return	{없슴} 	void 
  * @author 조재성 
  * @version 20091019
  */     
 function getBackEndJobDtlResult() {
     var formObj = document.form;
 	var sheetObj = sheetObjects[1];
 	
 	formObj.f_cmd.value = SEARCH03;
  	var sXml = "";
	ComOpenWait(false);	//chungpa 20091023 화면 focusing
	
 	sXml = sheetObj.GetSearchXml("EES_CGM_1103GS.do", FormQueryString(formObj),-1,false);
 	var arrXml = sXml.split("|$$|");
 	if(arrXml.length > 0) {
 		sheetObj.LoadSearchXml(arrXml[0]);
 		orderTitle();
 	}
 	
 	if (sheetObj.RowCount <= 0 ) {
 		// There is no related data!
 		ComCodeMsgByNoRelatedData();
 		return;
 	} else {
 		//끝.
 	}   

 } 
	/* 개발자 작업  끝 */