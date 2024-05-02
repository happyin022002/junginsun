/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0227.js
*@FileTitle : e-Booking And S/I Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.24 김기종
* 1.0 Creation
* 2011.09.01 변종건[CHM-201112930-01] [BKG] e-S/I 관련 시스템 (추가)보완 요청
* 2012.02.15 김보배 [CHM-201216103] [BKG] e-SI PFMC Report 수정 요청
* 2012.08.16 조정민 [CHM-201219605] [BKG] eSI PFMC 조회기간 제한 설정 요청
* 2013.02.12 김진주 [CHM-201322908] [eSI PFMC Report] S/I automation item 이름 변경 요청
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
     * @class ESM_BKG_0227 : ESM_BKG_0227 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0227() {
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

 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;


 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

 				case "btn_Retrieve":
 					setReportType(ComGetObjValue(formObject.report_type));
	 				if (ComGetObjValue(formObject.report_type)=="BR"){
	 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	 				}else if (ComGetObjValue(formObject.report_type)=="SR"){
	 					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	 				}else if (ComGetObjValue(formObject.report_type)=="CR"){	
	 					doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
	 				}else if (ComGetObjValue(formObject.report_type)=="DR"){	
	 					doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
	 				}
					break;
 				case "btn_SummaryById":
 					if(validateForm(sheetObjects[0],formObject,IBSEARCH)){
 						ComOpenWindowCenter2("/hanjin/ESM_BKG_0227_1.do", "Summary by ID", 800,610, true,"scrollbars=no,resizable=yes");
 					}
 					break;
 				case "btn_DownExcel":
	            	if (ComGetObjValue(formObject.report_type)=="BR"){
	            		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="SR"){
	            		doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="CR"){			
	            		doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="DR"){		
	            		doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
	            	}
					break;
	            case "btn_New":
	            	sheetObjects[0].RemoveAll();
	            	sheetObjects[1].RemoveAll();
	            	sheetObjects[2].RemoveAll();
	            	sheetObjects[3].RemoveAll();
 					ComResetAll();
 					setDuration('D');
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
         initControl();

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
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	
     	combo1 = comboObjects[0];
 		comboCnt = comboObjects.length;

 		// IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
 	    makeHtmlDuration("M");
 	    setReportType("BR");
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
 								style.height = 330;
 								//전체 너비 설정
 								SheetWidth = mainTable[0].clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msAll; //msPrevColumnMerge + msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|Region|Booking Office|Booking Office|Month|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L";
 								var HeadTitle2 = "|Region|GSO|Office|Month|TTL BKG|OFF|EDI|WEB|SIM|DSK|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL BKG|OFF|EDI|WEB|SIM|DSK|S/I auto|Web SI Auto|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL OBL|TTL SWB|OFF|PENDING|EDI|WEB OBL|WEB SWB|SWB E-mail|e-SVC%";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(false, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,	"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		true,	"region_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,	"gso",						false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				75,		daCenter,		true,	"ofc_cd",					false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,	"duration",					false,		"",		dfDateYm,				0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_ttl",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_nis",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_edi",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_web",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_sim",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_desktop",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_gtn",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_inttra",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_csm",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"bkg_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"bkg_portal",				false,		"",		dfNullFloat,				1,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"bkg_svc",					false,		"",		dfNullFloat,				1,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_ttl",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_nis",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_edi",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_web",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_sim",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_desktop",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_eml",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_uld",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_gtn",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_inttra",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_csm",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"si_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"si_portal",				false,		"",		dfNullFloat,				1,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"si_svc",					false,		"",		dfNullFloat,				1,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_obl",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_swb",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_nis",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_pending",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_edi",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_web_obl",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			60,		daRight,		false,	"bl_web_swb",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			60,		daRight,		false,	"bl_swb_email",				false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"bl_svc",					false,		"",		dfNullFloat,				1,		false,		true);
 								
 								FrozenCols = 5;
 								//CountPosition = 0;
 		
 						}
 						break;

 					case "sheet2":
 						with (sheetObj) {
 					 		
								// 높이 설정
								style.height = 330;
								//전체 너비 설정
								SheetWidth = mainTable[1].clientWidth;
								
								//Host정보 설정[필수][HostIp, Port, PagePath]
								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
								
								//전체Merge 종류 [선택, Default msNone]
								MergeSheet = msAll; //msPrevColumnMerge + msHeaderOnly;
								
								//전체Edit 허용 여부 [선택, Default false]
								Editable = false;
								
								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(2, 1, 3, 100);
								
								var HeadTitle1 = "|Region|Sales Office|Sales Office|Month|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L";
								var HeadTitle2 = "|Region|GSO|Office|Month|TTL BKG|OFF|EDI|WEB|SIM|DSK|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL BKG|OFF|EDI|WEB|SIM|DSK|S/I auto|Web SI Auto|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL OBL|TTL SWB|OFF|PENDING|EDI|WEB OBL|WEB SWB|SWB E-mail|e-SVC %";
								var headCount = ComCountHeadTitle(HeadTitle1);
		
								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
								InitColumnInfo(headCount, 0, 0, true);
								
								// 해더에서 처리할 수 있는 각종 기능을 설정한다
								InitHeadMode(false, true, false, true, false,false);
								
								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
								InitHeadRow(0, HeadTitle1, true);
								InitHeadRow(1, HeadTitle2, true);
								
								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,	"hdnStatus");
								InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		true,	"region_cd",				false,		"",		dfNone,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,	"gso",						false,		"",		dfNone,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtData,				75,		daCenter,		true,	"ofc_cd",					false,		"",		dfNone,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,	"duration",					false,		"",		dfDateYm,				0,		false,		true);
								
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_ttl",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_nis",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_edi",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_web",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_sim",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_desktop",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_gtn",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_inttra",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_csm",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"bkg_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"bkg_portal",				false,		"",		dfNullFloat,				1,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"bkg_svc",					false,		"",		dfNullFloat,				1,		false,		true);
								
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_ttl",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_nis",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_edi",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_web",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_sim",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_desktop",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_eml",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_uld",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_gtn",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_inttra",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_csm",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"si_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"si_portal",				false,		"",		dfNullFloat,				1,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"si_svc",					false,		"",		dfNullFloat,				1,		false,		true);
								
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_obl",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_swb",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_nis",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,	"bl_pending",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_edi",					false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_web_obl",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_web_swb",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoSum,			60,		daRight,		false,	"bl_swb_email",				false,		"",		dfInteger,					0,		false,		true);
								InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"bl_svc",					false,		"",		dfNullFloat,				1,		false,		true);

								FrozenCols = 5;
								CountPosition = 0;
 						}
 						break;

 						
 					case "sheet3":
 						with (sheetObj) {
 					 		
							// 높이 설정
							style.height = 330;
							//전체 너비 설정
							SheetWidth = mainTable[2].clientWidth;
							
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msPrevColumnMerge + msHeaderOnly;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = false;
							
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(2, 1, 3, 100);
							
							var HeadTitle1 = "|Contract No|C.Office|C.Office|L.Office|L.Office|Shipper Code|Shipper Code|Shipper Code|Month|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|S/I|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L|B/L";
							var HeadTitle2 = "|Contract No|C.CustName|C.ofc|Sales|Code |Code|Name|B.OFC|Month|TTL BKG|OFF|EDI|WEB|SIM|DSK|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL BKG|OFF|EDI|WEB|SIM|DSK|S/I auto|Web SI Auto|GTN|INT|CSM|SML Tools %|Portal %|e-SVC %|TTL OBL|TTL SWB|OFF|PENDING|EDI|WEB OBL|WEB SWB|SWB E-mail|e-SVC %";

							var headCount = ComCountHeadTitle(HeadTitle1);
	
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							InitHeadRow(1, HeadTitle2, true);
							
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,	"hdnStatus");
							InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,	"sc_rfa_no",				false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				80,		daLeft,		    true,	"cust_nm",			        false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,	"prop_ofc_cd",				false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		false,	"ob_sls_ofc_cd",			false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		false,	"ob_srep_cd",				false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				60,		daCenter,		true,	"region_cd",				false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,				150,	daLeft,			true,	"gso",						false,		"",		dfNone,					0,		true,		true);
							InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,	"ofc_cd",					false,		"",		dfNone,					0,		true,		true);
							InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,	"duration",					false,		"",		dfDateYm,				0,		true,		true);
							
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_ttl",					false,		"",		dfInteger,					0,		true,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_nis",					false,		"",		dfInteger,					0,		true,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_edi",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_web",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_sim",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_desktop",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_gtn",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_inttra",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bkg_csm",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"bkg_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"bkg_portal",				false,		"",		dfNullFloat,				1,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvgEx,		55,		daRight,		false,	"bkg_svc",					false,		"",		dfNullFloat,				1,		false,		true);
							
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_ttl",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_nis",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_edi",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_web",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_sim",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_desktop",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_eml",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_uld",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_gtn",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_inttra",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"si_csm",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvgEx,		80,		daRight,		false,	"si_hjstools",				false,		"",		dfNullFloat,				1,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvgEx,		60,		daRight,		false,	"si_portal",				false,		"",		dfNullFloat,				1,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvg,			55,		daRight,		false,	"si_svc",					false,		"",		dfNullFloat,				1,		false,		true);
							
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_obl",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_ttl_swb",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_nis",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,	"bl_pending",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_edi",					false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_web_obl",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,	"bl_web_swb",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,			60,		daRight,		false,	"bl_swb_email",				false,		"",		dfInteger,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoAvg,			55,		daRight,		false,	"bl_svc",					false,		"",		dfNullFloat,				1,		false,		true);

							
							CountPosition = 0;
							FrozenCols = 8;
 						}
 						break;

 					case "sheet4":
 							with (sheetObj) {
 		
 								// 높이 설정
 								style.height = 330;
 								//전체 너비 설정
 								SheetWidth = mainTable[3].clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|Booking No.|B/L No.|Office|Office|Office|Office|Shipper|Shipper|T/VVD|On Board|POR|POL|POD|DEL|BL Complete|BL Complete|Booking|Booking|Booking|S/I|S/I|S/I|B/L|B/L|B/L|||";
 								var HeadTitle2 = "|Booking No.|B/L No.|GSO|Sales|Code|Booking|Code|Name|T/VVD|On Board|POR|POL|POD|DEL|Date|By|Kind|Date|By|Kind|Date|By|Kind|Date|By|||";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"bkg_no",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"bl_no",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"gso",					false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"sal_ofc",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		false,		"ob_srep_cd",			false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					55,		daCenter,		true,		"ofc_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"cust_seq",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					200,	daLeft,			true,		"cust_nm",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"vvd_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"bl_obrd_dt",			false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"por_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"pol_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"pod_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"del_cd",				false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"bl_complete_dt",		false,		"",		dfDateYmd,				0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"bl_complete_usr_id",	false,		"",		dfNone,					0,		false,		true);
 								
 								
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"bk_kind",				false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"bk_dt",				false,		"",		dfDateYmd,				0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"bk_usr_id",			false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"si_kind",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"si_dt",				false,		"",		dfDateYmd,				0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"si_usr_id",			false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"bl_kind",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"bl_dt",				false,		"",		dfDateYmd,				0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"bl_usr_id",			false,		"",		dfNone,					0,		false,		true);
 								
 								InitDataProperty(0,		cnt++ , dtHidden,				60,		daCenter,		true,		"bk_usr_nm",			false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtHidden,				60,		daCenter,		true,		"si_usr_nm",			false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtHidden,				60,		daCenter,		true,		"bl_usr_nm",			false,		"",		dfNone,					0,		false,		true);
 								//CountPosition = 0;
 								FrozenCols = 3;
 						}
 						break;
 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0227_1GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 2) 
					ComXml2ComboItem(arrXml[2], formObj.bkg_cust_tp_cd, "val", "name");
				if (arrXml.length > 1) 
					ComXml2ComboItem(arrXml[1], formObj.region_cd, "val", "val|name");
				
				ComSetObjValue(formObj.bkg_cust_tp_cd,"S");
				formObj.region_cd.index = 0;
				//formObj.region_cd.InsertItem(0, '', '');
				break;
				
           case IBSEARCH:      //조회
        	   	if(validateForm(sheetObj,formObj,sAction)){
        	   		formObj.f_cmd.value = SEARCH;
	  	    		if (ComGetObjValue(formObj.report_type)=="BR" 
	  	    				|| ComGetObjValue(formObj.report_type)=="SR"
	  	    					|| ComGetObjValue(formObj.report_type)=="CR"){
	  	    			sheetObj.DoSearch("ESM_BKG_0227GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""));
	  	    				 	 	          	  
	  	          	}else{
	  	          		sheetObj.DoSearch("ESM_BKG_0227_1GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));	
	  	          	}
        	   	}	
                break;
                
           case IBDOWNEXCEL:      // 다운로드
  				sheetObj.SpeedDown2Excel(-1);
  				break;			
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
         	switch(sAction) {
		     	case IBSEARCH: // 조회시 확인
		     	
		     		if (ComGetObjValue(formObj.duration_opt) == "D" 
		     				|| ComGetObjValue(formObj.duration_opt) == "B"  ){
			     		if (!ComIsNull(formObj.duration_from_dt) 
	 			  			&& !ComIsNull(formObj.duration_to_dt) 
	 			  			&& ComGetDaysBetween(formObj.duration_from_dt.value, formObj.duration_to_dt.value) > 31){
			           		 
		         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
		         			formObj.duration_from_dt.focus();
		         			return false;
		         		}
		     		}
		     	
		     		if (ComGetObjValue(formObj.duration_opt) == "W"){
		     			var frm_wk = ComGetObjValue(formObj.duration_from_week);
		     			var to_wk = ComGetObjValue(formObj.duration_to_week);
		     			if(to_wk - frm_wk >= 4){
		         			ComShowCodeMessage("BKG95055","4");//Can’t input duration over {?msg1} weeks
		         			return false; 
		     			}
		     		}
		     	
		     	
		     		if (ComGetObjValue(formObj.vvd_cd) == ""){
		     			if (!ComChkValid(formObj)) return false;
		     		}
			  		if (ComGetObjValue(formObj.doc_tp_b) == ""
			  				&& ComGetObjValue(formObj.doc_tp_s) == ""
			  					&& ComGetObjValue(formObj.doc_tp_h) == ""){
			  				alert("Please select e-Service Type");
			  			return false;
			  		}
			  		break;
         	}	
         }		
         return true;
     }


	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			
			for (var col = SaveNameCol("bkg_ttl") ; col <= LastCol; col ++){
				var colName = ColSaveName(col);
				SumValue(0, colName) = EtcData(colName);
			}
			SumText(0, "region_cd") = "";
			SumText(0, "ofc_cd") = "Grand Total";
			
		}
		chkEsvcType();
	}
    
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			
			for (var col = SaveNameCol("bkg_ttl") ; col <= LastCol; col ++){
				var colName = ColSaveName(col);
				SumValue(0, colName) = EtcData(colName);
			}
			SumText(0, "region_cd") = "";
			SumText(0, "ofc_cd") = "Grand Total";
			
		}
		chkEsvcType();
	}
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			for (var col = SaveNameCol("bkg_ttl") ; col <= LastCol; col ++){
				var colName = ColSaveName(col);
				SumValue(0, colName) = EtcData(colName);
			}
			SumText(0, "sc_rfa_no") = "";
			SumText(0, "gso") = "Grand Total";
			
		}
		chkEsvcType();
	}
	function sheet4_OnSearchEnd(sheetObj, ErrMsg){
		comBkgIndicateLink(sheetObj,"bkg_no");
	}
	function sheet4_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
	// 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	function sheet4_OnMouseMove(Button, Shift, X, Y)
	{
		var sheetObj = sheetObjects[3];
		
		with(sheetObj)
  		{
			var row = MouseRow;
			var col = MouseCol;
			
			var colname = ColSaveName(col);
			
			
			switch(colname)
			{
				case "bk_usr_id":
					MousePointer = "Hand";
					window.status = MousePointer;
					MouseToolTipText = CellValue(row, "bk_usr_nm");
					/*
					if (row > 0 && row <= sheetObj.SearchRows && "" != CellValue(row, col))
						MouseToolTipText = CellValue(row, "bkg_usr_nm");
					else
						MouseToolTipText = "";*/
					break;
				case "si_usr_id":
					MousePointer = "Hand";
					window.status = MousePointer;
					MouseToolTipText = CellValue(row, "si_usr_nm");
					break;	
				case "bl_usr_id":
					MousePointer = "Hand";
					window.status = MousePointer;
					MouseToolTipText = CellValue(row, "bl_usr_nm");
					break;		
				default :
						MouseToolTipText = "";
			}
  		}
	}
	
	/**
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.DropHeight = 150;
     	
     }  
     
	/**
     * from,to 기간 선택 달력 띄우기
     */
  	function callDatePop(val){
  		var cal = new ComCalendarFromTo();
  		if (val == 'BKG_DATE'){
  			cal.select(form.duration_from_dt,  form.duration_to_dt,  'yyyy-MM-dd');
  		}
  		
  	}	
  
  	/**
     * from,to 기간 자동 세팅
     */
  	function setDuration(val){
  		var formObject = document.form;
  		makeHtmlDuration(val);
  		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
  	}
  	
  	/**
     * duration에 따른 html적용.
     */
  	
  	function makeHtmlDuration(val){
  		var formObject = document.form;
  		var html = "";
  		if (val == "M"){
  			html = "<td width=\"30\">Year&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "	<input type=\"text\" name=\"duration_year\" style=\"width:40;\" class=\"input1\"  dataformat=\"yy\" caption=\"Year\" maxlength=\"4\"  required >";
			html += "</td>";
			html += "&nbsp;<td width=\"40\">Month&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "<input type=\"text\" name=\"duration_month\" style=\"width:20;\" class=\"input1\"  dataformat=\"mm\" caption=\"Month\" maxlength=\"2\"  required>";
			html += "</td>";
  		}else if (val == "W"){	
	  		html = "<td width=\"30\">Year</td>";
	  		html += "	<input type=\"text\" name=\"duration_year\" style=\"width:40;\" class=\"input1\"  dataformat=\"yy\" caption=\"Year\" maxlength=\"4\"  required>";
			html += "</td>";
			html += "&nbsp;<td width=\"40\">Week&nbsp;</td>";
			html += "<td width=\"60\">";
			html +=	"<input type=\"text\" name=\"duration_from_week\" style=\"width:30;\" class=\"input1\"  dataformat=\"yy\" caption=\"Week\" maxlength=\"2\"  required>";
			html += "&nbsp;~&nbsp;";
			html +=	"<input type=\"text\" name=\"duration_to_week\" style=\"width:30;\" class=\"input1\"  dataformat=\"yy\" caption=\"Week\" maxlength=\"2\" required >";
			html +=	"</td>";
  		}else if (val == "D" || val == "B"){
  			html = "<td width=\"250\">";
  			html += "<input type=\"text\" name=\"duration_from_dt\" style=\"width:75;\" class=\"input1\"  dataformat=\"ymd\" caption=\"Start Date\" maxlength=\"10\"  required cofield=\"duration_to_dt\">";
  			html += "&nbsp;~&nbsp;";
  			html += "<input type=\"text\" name=\"duration_to_dt\" style=\"width:75;\" class=\"input1\"   dataformat=\"ymd\" caption=\"End Date\" maxlength=\"10\"  required cofield=\"duration_from_dt\">&nbsp;";
  			html += "<img class=\"cursor\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"  style=\"cursor:hand\" onClick=\"callDatePop('BKG_DATE')\">";
  			html += "</td>";
  		}
  		
  		
		duration.innerHTML =html;	
  		if (val == "D" || val == "B"){
  			/*
  			ComSetObjValue(formObject.duration_from_dt,ComGetNowInfo());
  	     	ComSetObjValue(formObject.duration_to_dt,ComGetNowInfo());
  	     	*/
  		}else if (val == "M"){
  			ComSetObjValue(formObject.duration_year,ComGetNowInfo().substr(0,4));
  			ComSetObjValue(formObject.duration_month,ComGetNowInfo().substr(5,2));
  		}else if (val == "M" || val == "W"){
  			ComSetObjValue(formObject.duration_year,ComGetNowInfo().substr(0,4));
  		}
  		setSheetDurationTitle(val);
  	}
  	
  	/**
     * sheet title month, week변경 설정.
     */
  	
  	function setSheetDurationTitle(duration){
  		var formObject = document.form;
  		var sheetObj;
  		var duration;
  		
  		if (ComGetObjValue(formObject.report_type)=="BR"){
  			sheetObj = sheetObjects[0];
		}else if (ComGetObjValue(formObject.report_type)=="SR"){
			sheetObj = sheetObjects[1];
		}else if (ComGetObjValue(formObject.report_type)=="CR"){
			sheetObj = sheetObjects[2];
		}else {
			return;
		}
  		
  		if (duration == "W"){
	  		sheetObj.CellValue2(0, "duration") = "Week";
	  		sheetObj.CellValue2(1, "duration") = "Week";
  		}else{
  			sheetObj.CellValue2(0, "duration") = "Month";
	  		sheetObj.CellValue2(1, "duration") = "Month";
  		}
  	}
  	
  	/**
     * report type에 따른 sheet 변경
     */
  	
  	function setReportType(val){
  		var formObject = document.form;
  		for(i=0;i<sheetLayer.length;i++){
  			sheetLayer[i].style.display ="none";
		}
  		var selLayer = 0;
  		if (val == "BR"){
  			selLayer = 0;
  			formObject.ctrt_ofc.readOnly = true;
  			formObject.ctrt_ofc.style.background = "#E8EFF9";
  			formObject.ctrt_ofc.value = "";
  		}else if (val == "SR"){
  			selLayer = 1;
  			formObject.ctrt_ofc.readOnly = true;
  			formObject.ctrt_ofc.style.background = "#E8EFF9";
  			formObject.ctrt_ofc.value = "";
  		}else if (val == "CR"){
  			selLayer = 2;
  			formObject.ctrt_ofc.readOnly = false;
  			formObject.ctrt_ofc.style.background = "#FFFFFF";
  		}else if (val == "DR"){
  			selLayer = 3;
  			formObject.ctrt_ofc.readOnly = true;
  			formObject.ctrt_ofc.style.background = "#E8EFF9";
  			formObject.ctrt_ofc.value = "";
  		}
  		sheetLayer[selLayer].style.display ="inline";
  		sheetObjects[selLayer].RemoveAll();
  		setSheetDurationTitle(ComGetObjValue(formObject.duration_opt));
  	}
 	/* 
 	 * e-SVC Type 에 따른 IBSheet hidden
 	 * */
     
     function chkEsvcType(){
    	 var formObject = document.form;
    	 
    	 if(formObject.doc_tp_b.checked){
    		 
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	    		sheetObjects[0].ColHidden("bkg_ttl") = false;
	      		sheetObjects[0].ColHidden("bkg_nis") = false;
	      		sheetObjects[0].ColHidden("bkg_edi") = false;
	      		sheetObjects[0].ColHidden("bkg_web") = false;
	      		sheetObjects[0].ColHidden("bkg_gtn") = false;
	      		sheetObjects[0].ColHidden("bkg_inttra") = false;
	      		sheetObjects[0].ColHidden("bkg_csm") = false;
	      		sheetObjects[0].ColHidden("bkg_desktop") = false;
	      		sheetObjects[0].ColHidden("bkg_svc") = false;  
	      		sheetObjects[0].ColHidden("bkg_sim") = false;  
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	      		sheetObjects[1].ColHidden("bkg_ttl") = false;
	      		sheetObjects[1].ColHidden("bkg_nis") = false;
	      		sheetObjects[1].ColHidden("bkg_edi") = false;
	      		sheetObjects[1].ColHidden("bkg_web") = false;
	      		sheetObjects[1].ColHidden("bkg_gtn") = false;
	      		sheetObjects[1].ColHidden("bkg_inttra") = false;
	      		sheetObjects[1].ColHidden("bkg_csm") = false;
	      		sheetObjects[1].ColHidden("bkg_desktop") = false;
	      		sheetObjects[1].ColHidden("bkg_svc") = false; 
	      		sheetObjects[0].ColHidden("bkg_sim") = false;  
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="CR"){
	      		sheetObjects[2].ColHidden("bkg_ttl") = false;
	      		sheetObjects[2].ColHidden("bkg_nis") = false;
	      		sheetObjects[2].ColHidden("bkg_edi") = false;
	      		sheetObjects[2].ColHidden("bkg_web") = false;
	      		sheetObjects[2].ColHidden("bkg_gtn") = false;
	      		sheetObjects[2].ColHidden("bkg_inttra") = false;
	      		sheetObjects[2].ColHidden("bkg_csm") = false;
	      		sheetObjects[2].ColHidden("bkg_desktop") = false;
	      		sheetObjects[2].ColHidden("bkg_svc") = false; 
	      		sheetObjects[0].ColHidden("bkg_sim") = false;  
    		 }
      		
    	 }else{
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	     		sheetObjects[0].ColHidden("bkg_ttl") = true;
	    		sheetObjects[0].ColHidden("bkg_nis") = true;
	    		sheetObjects[0].ColHidden("bkg_edi") = true;
	    		sheetObjects[0].ColHidden("bkg_web") = true;
	    		sheetObjects[0].ColHidden("bkg_gtn") = true;
	    		sheetObjects[0].ColHidden("bkg_inttra") = true;
	    		sheetObjects[0].ColHidden("bkg_csm") = true;
	    		sheetObjects[0].ColHidden("bkg_desktop") = true;
	    		sheetObjects[0].ColHidden("bkg_svc") = true;   
	      		sheetObjects[0].ColHidden("bkg_sim") = true;  
	    		}
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	    		sheetObjects[1].ColHidden("bkg_ttl") = true;
	    		sheetObjects[1].ColHidden("bkg_nis") = true;
	    		sheetObjects[1].ColHidden("bkg_edi") = true;
	    		sheetObjects[1].ColHidden("bkg_web") = true;
	    		sheetObjects[1].ColHidden("bkg_gtn") = true;
	    		sheetObjects[1].ColHidden("bkg_inttra") = true;
	    		sheetObjects[1].ColHidden("bkg_csm") = true;
	    		sheetObjects[1].ColHidden("bkg_desktop") = true;
	    		sheetObjects[1].ColHidden("bkg_svc") = true;   
	      		sheetObjects[0].ColHidden("bkg_sim") = true;  
    		 }
    		if (ComGetObjValue(formObject.report_type)=="CR"){
	    		sheetObjects[2].ColHidden("bkg_ttl") = true;
	    		sheetObjects[2].ColHidden("bkg_nis") = true;
	    		sheetObjects[2].ColHidden("bkg_edi") = true;
	    		sheetObjects[2].ColHidden("bkg_web") = true;
	    		sheetObjects[2].ColHidden("bkg_gtn") = true;
	    		sheetObjects[2].ColHidden("bkg_inttra") = true;
	    		sheetObjects[2].ColHidden("bkg_csm") = true;
	    		sheetObjects[2].ColHidden("bkg_desktop") = true;
	    		sheetObjects[2].ColHidden("bkg_svc") = true;   
	      		sheetObjects[0].ColHidden("bkg_sim") = true;  
    		}
     		
    	 }
    	 if(formObject.doc_tp_s.checked){
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	    		 sheetObjects[0].ColHidden("si_ttl") = false;
	    		 sheetObjects[0].ColHidden("si_nis") = false;
	    		 sheetObjects[0].ColHidden("si_edi") = false;
	    		 sheetObjects[0].ColHidden("si_eml") = false;
	    		 sheetObjects[0].ColHidden("si_uld") = false;
	    		 sheetObjects[0].ColHidden("si_web") = false;
	    		 sheetObjects[0].ColHidden("si_gtn") = false;
	    		 sheetObjects[0].ColHidden("si_inttra") = false;
	    		 sheetObjects[0].ColHidden("si_csm") = false;
	    		 sheetObjects[0].ColHidden("si_sim") = false;
	    		 sheetObjects[0].ColHidden("si_desktop") = false;
	    		 sheetObjects[0].ColHidden("si_svc") = false;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	    		 sheetObjects[1].ColHidden("si_ttl") = false;
	    		 sheetObjects[1].ColHidden("si_nis") = false;
	    		 sheetObjects[1].ColHidden("si_edi") = false;
	    		 sheetObjects[1].ColHidden("si_eml") = false;
	    		 sheetObjects[1].ColHidden("si_uld") = false;
	    		 sheetObjects[1].ColHidden("si_web") = false;
	    		 sheetObjects[1].ColHidden("si_gtn") = false;
	    		 sheetObjects[1].ColHidden("si_inttra") = false;
	    		 sheetObjects[1].ColHidden("si_csm") = false;
	    		 sheetObjects[1].ColHidden("si_sim") = false;
	    		 sheetObjects[1].ColHidden("si_desktop") = false;
	    		 sheetObjects[1].ColHidden("si_svc") = false;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="CR"){
	    		 sheetObjects[2].ColHidden("si_ttl") = false;
	    		 sheetObjects[2].ColHidden("si_nis") = false;
	    		 sheetObjects[2].ColHidden("si_edi") = false;
	    		 sheetObjects[2].ColHidden("si_eml") = false;
	    		 sheetObjects[2].ColHidden("si_uld") = false;
	    		 sheetObjects[2].ColHidden("si_web") = false;
	    		 sheetObjects[2].ColHidden("si_gtn") = false;
	    		 sheetObjects[2].ColHidden("si_inttra") = false;
	    		 sheetObjects[2].ColHidden("si_csm") = false;
	    		 sheetObjects[2].ColHidden("si_sim") = false;
	    		 sheetObjects[2].ColHidden("si_desktop") = false;
	    		 sheetObjects[2].ColHidden("si_svc") = false;
	    	}
    	 }else{
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	    		 sheetObjects[0].ColHidden("si_ttl") = true;
	    		 sheetObjects[0].ColHidden("si_nis") = true;
	    		 sheetObjects[0].ColHidden("si_edi") = true;
	    		 sheetObjects[0].ColHidden("si_eml") = true;
	    		 sheetObjects[0].ColHidden("si_uld") = true;
	    		 sheetObjects[0].ColHidden("si_web") = true;
	    		 sheetObjects[0].ColHidden("si_gtn") = true;
	    		 sheetObjects[0].ColHidden("si_inttra") = true;
	    		 sheetObjects[0].ColHidden("si_csm") = true;
	    		 sheetObjects[0].ColHidden("si_sim") = true;
	    		 sheetObjects[0].ColHidden("si_desktop") = true;
	    		 sheetObjects[0].ColHidden("si_svc") = true;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	    		 sheetObjects[1].ColHidden("si_ttl") = true;
	    		 sheetObjects[1].ColHidden("si_nis") = true;
	    		 sheetObjects[1].ColHidden("si_edi") = true;
	    		 sheetObjects[1].ColHidden("si_eml") = true;
	    		 sheetObjects[1].ColHidden("si_uld") = true;
	    		 sheetObjects[1].ColHidden("si_web") = true;
	    		 sheetObjects[1].ColHidden("si_gtn") = true;
	    		 sheetObjects[1].ColHidden("si_inttra") = true;
	    		 sheetObjects[1].ColHidden("si_csm") = true;
	    		 sheetObjects[1].ColHidden("si_sim") = true;
	    		 sheetObjects[1].ColHidden("si_desktop") = true;
	    		 sheetObjects[1].ColHidden("si_svc") = true;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="CR"){
	    		 sheetObjects[2].ColHidden("si_ttl") = true;
	    		 sheetObjects[2].ColHidden("si_nis") = true;
	    		 sheetObjects[2].ColHidden("si_edi") = true;
	    		 sheetObjects[2].ColHidden("si_eml") = true;
	    		 sheetObjects[2].ColHidden("si_uld") = true;
	    		 sheetObjects[2].ColHidden("si_web") = true;
	    		 sheetObjects[2].ColHidden("si_gtn") = true;
	    		 sheetObjects[2].ColHidden("si_inttra") = true;
	    		 sheetObjects[2].ColHidden("si_csm") = true;
	    		 sheetObjects[2].ColHidden("si_sim") = true;
	    		 sheetObjects[2].ColHidden("si_desktop") = true;
	    		 sheetObjects[2].ColHidden("si_svc") = true;
    		 }
    	 }
    	 if(formObject.doc_tp_h.checked){
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	    		 sheetObjects[0].ColHidden("bl_ttl_obl") = false;
	    		 sheetObjects[0].ColHidden("bl_ttl_swb") = false;
	    		 sheetObjects[0].ColHidden("bl_nis") = false;
	    		 sheetObjects[0].ColHidden("bl_pending") = false;
	    		 sheetObjects[0].ColHidden("bl_edi") = false;
	    		 sheetObjects[0].ColHidden("bl_web_obl") = false;
	    		 sheetObjects[0].ColHidden("bl_web_swb") = false;
	    		 sheetObjects[0].ColHidden("bl_swb_email") = false;
	    		 sheetObjects[0].ColHidden("bl_svc") = false;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	    		 sheetObjects[1].ColHidden("bl_ttl_obl") = false;
	    		 sheetObjects[1].ColHidden("bl_ttl_swb") = false;
	    		 sheetObjects[1].ColHidden("bl_nis") = false;
	    		 sheetObjects[1].ColHidden("bl_pending") = false;
	    		 sheetObjects[1].ColHidden("bl_edi") = false;
	    		 sheetObjects[1].ColHidden("bl_web_obl") = false;
	    		 sheetObjects[1].ColHidden("bl_web_swb") = false;
	    		 sheetObjects[1].ColHidden("bl_swb_email") = false;
	    		 sheetObjects[1].ColHidden("bl_svc") = false;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="CR"){
	    		 sheetObjects[2].ColHidden("bl_ttl_obl") = false;
	    		 sheetObjects[2].ColHidden("bl_ttl_swb") = false;
	    		 sheetObjects[2].ColHidden("bl_nis") = false;
	    		 sheetObjects[2].ColHidden("bl_pending") = false;
	    		 sheetObjects[2].ColHidden("bl_edi") = false;
	    		 sheetObjects[2].ColHidden("bl_web_obl") = false;
	    		 sheetObjects[2].ColHidden("bl_web_swb") = false;
	    		 sheetObjects[2].ColHidden("bl_swb_email") = false;
	    		 sheetObjects[2].ColHidden("bl_svc") = false;
    		 }
    	 }else{
    		 if(ComGetObjValue(formObject.report_type)=="BR"){
	    		 sheetObjects[0].ColHidden("bl_ttl_obl") = true;
	    		 sheetObjects[0].ColHidden("bl_ttl_swb") = true;
	    		 sheetObjects[0].ColHidden("bl_nis") = true;
	    		 sheetObjects[0].ColHidden("bl_pending") = true;
	    		 sheetObjects[0].ColHidden("bl_edi") = true;
	    		 sheetObjects[0].ColHidden("bl_web_obl") = true;
	    		 sheetObjects[0].ColHidden("bl_web_swb") = true;
	    		 sheetObjects[0].ColHidden("bl_swb_email") = true;
	    		 sheetObjects[0].ColHidden("bl_svc") = true;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="SR"){
	    		 sheetObjects[1].ColHidden("bl_ttl_obl") = true;
	    		 sheetObjects[1].ColHidden("bl_ttl_swb") = true;
	    		 sheetObjects[1].ColHidden("bl_nis") = true;
	    		 sheetObjects[1].ColHidden("bl_pending") = true;
	    		 sheetObjects[1].ColHidden("bl_edi") = true;
	    		 sheetObjects[1].ColHidden("bl_web_obl") = true;
	    		 sheetObjects[1].ColHidden("bl_web_swb") = true;
	    		 sheetObjects[1].ColHidden("bl_swb_email") = true;
	    		 sheetObjects[1].ColHidden("bl_svc") = true;
    		 }
    		 if (ComGetObjValue(formObject.report_type)=="CR"){
	    		 sheetObjects[2].ColHidden("bl_ttl_obl") = true;
	    		 sheetObjects[2].ColHidden("bl_ttl_swb") = true;
	    		 sheetObjects[2].ColHidden("bl_nis") = true;
	    		 sheetObjects[2].ColHidden("bl_pending") = true;
	    		 sheetObjects[2].ColHidden("bl_edi") = true;
	    		 sheetObjects[2].ColHidden("bl_web_obl") = true;
	    		 sheetObjects[2].ColHidden("bl_web_swb") = true;
	    		 sheetObjects[2].ColHidden("bl_swb_email") = true;
	    		 sheetObjects[2].ColHidden("bl_svc") = true;
    		 }
    	 } 
    	 
     }
     function formQueryString(){
    	 var formObj = document.form;
    	 formObj.f_cmd.value = SEARCH;   
    	 return FormQueryString(formObj);
     }
 	 
	/* 개발자 작업  끝 */