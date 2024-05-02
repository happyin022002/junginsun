/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0116.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.10 강동윤
* 1.0 Creation
* 2011.03.03 정선용 [ESM_BKG_0116_01] IBSheet에 WGT,MEASURE 항목의 경우 소수점 셋째자리까지 변경 요청 .000 으로 표시
* 2012.06.25 김기택 [CHM-201218292-01] C/M 화면 다운로드 데이터 양식 수정(B/L No, TP/SZ, Seal No 컬럼 분리)
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
     * @class ESM_BKG_0116 : ESM_BKG_0116 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0116() {
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
 var combo1 = null;
 var comboCnt = 0;
 
 var tabItem 	= 0;
 var seqSheet1  = 0;
 var seqSheet2  = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;


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
 		
 		        //khlee-시작 환경 설정 함수 이름 변경
 					ComConfigSheet (sheetObjects[i] );
 					initSheet(sheetObjects[i],i+1);
 		        //khlee-마지막 환경 설정 함수 추가
 					ComEndConfigSheet(sheetObjects[i]);
 				}
 				
 				doActionIBSheet(sheetObjects[0],document.form,COMMAND01);	
 				
 				for(k=0;k<tabObjects.length;k++){
 					initTab(tabObjects[k],k+1);
 				}
 				
 				//MultiCombo초기화 
 		 	    for(var k=0;k<comboObjects.length;k++){
 		 	    	initCombo(comboObjects[k],comboObjects[k].id);
 		 	    }
 				 				
 				initControl();
 				
 				document.form.vvd.focus();
     }

      /**
       * 콤보 초기설정값
       * @param {IBMultiCombo} comboObj  comboObj
       */
       function initCombo(comboObj, comboId) {
     	  comboObj.MultiSelect = false;
     	  comboObj.UseCode = true;
     	  //comboObj.LineColor = "#ffffff";
     	  //comboObj.SetColAlign("left|left");
     	  comboObj.MultiSeparator = ",";
     	  comboObj.DropHeight = 150;      	

     	  UseAutoComplete = true; // 편집시 자동 코드 검색
       }  
     
     /**
       * 조회조건 입력할 때 처리
       */
      function obj_KeyUp() {
 	     var formObject = document.form;
 	     var srcName = window.event.srcElement.getAttribute("name");
 	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	     var srcValue = window.event.srcElement.getAttribute("value");
 	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
 	     	ComSetNextFocus();
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
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	} 
      
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var cnt2= 0;
         var sheetID = sheetObj.id;

         switch(sheetID) {
             case "t1sheet1":      //t1sheet1 init -C/M SCREEN
 					with (sheetObj) {
             // 높이 설정
             style.height = 330;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msPrevColumnMerge;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(23, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						//InitHeadMode(true, true, false, true, false,false);
 						InitHeadMode(false, false);

 						var HeadTitle1 = "B/L No.|Seq.|Description|Package|Package|Weight(KGS)|Measure(CBM)|R/D|R/D|D/G|A/K|H/G|A/S|Mark & No.|S.Rep.|Shipper|BKG Staff|HTS CD|P.O No.|CMDT|POL";

 						// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);

 						//InitDataProperty(0, cnt2++ , dtHiddenStatus,		40,		daCenter,		true,		"ibflag");
 						//InitDataProperty(0, cnt2++ , dtHidden,				20,		daCenter,		true,		"MDST");		// 마스터(M)/디테일(D)/서브토탈(S)/토탈(T) 구분 
 						InitDataProperty(0, cnt2++ , dtData,				100,		daCenter,	true,		"bl_no",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		true,		"Seq",					false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				120,	daLeft,			false,		"cntr_mf_gds",			false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt2++ , dtData,				70,		daRight,		false,		"pck_qty",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"Package2",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				80,		daRight,		false,		"cntr_mf_wgt",			false,		"",		dfFloat,			3,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				90,		daRight,		false,		"meas_qty",				false,		"",		dfFloat,			3,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"rcv_term_cd",			false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"de_term_cd",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"dcgo_flg",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"awk_cgo_flg",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"hngr_flg",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				30,		daCenter,		false,		"adv_shtg_cd",			false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt2++ , dtData,				70,		daLeft,			false,		"cntr_mf_gds_desc",		false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				60,		daCenter,		false,		"ob_srep_cd",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				150,	daLeft,			false,		"cust_cnt_cd",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				80,		daCenter,		false,		"doc_usr_id",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				80,		daCenter,		false,		"hamo_trf_cd",			false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt2++ , dtData,				100,	daCenter,		false,		"po_no",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				100,	daCenter,		false,		"cmdt_hs_cd",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtData,				50,		daCenter,		false,		"pol_cd",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt2++ , dtHidden,				20,		daCenter,		true,		"bkg_no");
 						InitDataProperty(0, cnt2++ , dtHidden,				20,		daCenter,		true,		"link"); 						
						
 						CountPosition = 0;
 				}
 				break;
				
				case "t1sheet2":      //t1sheet2 init- C/M EXCEL
                	with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") 
                        InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(25, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    InitHeadMode(false, false);
                    
                    var HeadTitle1 = "B/L No.|TP/SZ|Seal No.|Seq.|Description|Package|Package|Weight(KGS)|Measure(CBM)|R/D|R/D|D/G|A/K|H/G|A/S|Mark & No.|S.Rep.|Shipper|BKG Staff|HTS CD|P.O No.|CMDT|POL";
                    
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //InitDataProperty(0, cnt2++ , dtHiddenStatus,		40,		daCenter,		true,		"ibflag");
                    //InitDataProperty(0, cnt2++ , dtHidden,				20,		daCenter,		true,		"MDST");		// 마스터(M)/디테일(D)/서브토탈(S)/토탈(T) 구분 
                    InitDataProperty(0, cnt2++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
                    //tp sz
                    InitDataProperty(0, cnt2++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);
                    //seal no
                    InitDataProperty(0, cnt2++, dtData, 100, daCenter, true, "cntr_seal_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, true, "Seq", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 120, daLeft, false, "cntr_mf_gds", false, "", dfNone, 0, false, false);
                    
                    InitDataProperty(0, cnt2++, dtData, 70, daRight, false, "pck_qty", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "Package2", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 80, daRight, false, "cntr_mf_wgt", false, "", dfFloat, 3, false, false);
                    InitDataProperty(0, cnt2++, dtData, 90, daRight, false, "meas_qty", false, "", dfFloat, 3, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, false);
                    
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "de_term_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "dcgo_flg", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "awk_cgo_flg", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "hngr_flg", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 30, daCenter, false, "adv_shtg_cd", false, "", dfNone, 0, false, false);
                    
                    InitDataProperty(0, cnt2++, dtData, 70, daLeft, false, "cntr_mf_gds_desc", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 60, daCenter, false, "ob_srep_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 150, daLeft, false, "cust_cnt_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 80, daCenter, false, "doc_usr_id", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 80, daCenter, false, "hamo_trf_cd", false, "", dfNone, 0, false, false);
                    
                    InitDataProperty(0, cnt2++, dtData, 100, daCenter, false, "po_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 100, daCenter, false, "cmdt_hs_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtData, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt2++, dtHidden, 20, daCenter, true, "bkg_no");
                    InitDataProperty(0, cnt2++, dtHidden, 20, daCenter, true, "link");
                    
                    CountPosition = 0;
                }
                break;

 				case "t2sheet1":      //t2sheet1 init- FAX
 					with (sheetObj) {
             // 높이 설정
             style.height = 330;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msPrevColumnMerge;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = true;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(17, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false)

 						var HeadTitle1 = "|B/L No.|To|Attention|Fax.|Container No.|Container No.|Seal|POD|Description|Package|Weight\n(KGS)|Measure\n(CBM)|EX Ref No.";

 						// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);


 						// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						//InitDataProperty(0,	cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
						InitDataProperty(0,	cnt++ , dtData,				40,		daCenter,		true,		"Chk");
 						InitDataProperty(0, cnt++ , dtData,				100,	daCenter,		true,		"bl_no",					false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				200,	daLeft,			true,		"To",					false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			true,	"Attention",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"FaxNo",					false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		false,	"ContainerNo",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				30,		daCenter,		true,	"ContainerNo2",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"Seal",						false,		"",		dfNone,			0,		false,		false);
 						                                                          	
 						InitDataProperty(0, cnt++ , dtData,				60,		daCenter,		true,	"POD",						false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				130,	daLeft,			true,	"Description",				false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				70,		daRight,		true,	"Package",					false,		"",		dfNullInteger,	0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				80,		daRight,		true,	"Weight",					false,		"",		dfFloat,	3,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,				90,		daRight,		true,	"Measure",					false,		"",		dfFloat,	3,		false,		false);                                                                       	
 						
 						InitDataProperty(0, cnt++ , dtData,				100,		daCenter,		false,	"EXRefNo",					false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,		true,	"bkg_no");
 						InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,		true,	"chk_tp"); 						
 						InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,		true,	"link");  						
 			
 						//WordWrap = true;
 						
 						CountPosition = 0;
 				}
 				break;

         }
     }
      
   // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
      function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  	         var sheetObject1 = sheetObjects[0]; // C/M_Screen
  	         var sheetObject2 = sheetObjects[1]; // C/M_File

  	         var sheetObject3 = sheetObjects[2]; // FAX
           /*******************************************************/

      	try {
  				var srcName = window.event.srcElement.getAttribute("name");

  				switch(srcName) {
  					
  					case "btn_Retrieve":
//  						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  						
  						if (tabItem == 0){
  							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  						}else{ //FAX
  							doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
  						}
  					break;
  					
  					case "btn_SaveExcel":
  						if (tabItem == 1){ //FAX
  							
  							sheetObject3.SpeedDown2Excel(-1);
  						}else{ // C/M File
  						
						//Header Merge 삭제 부분
//	                      for (var i = sheetObjects[1].LastRow; i >= sheetObjects[1].HeaderRows; i--) {
//	                      
//	                          if (ComIsEmpty(sheetObjects[1].CellValue(i, "pod_cd"))) {
//	                              sheetObjects[1].RowDelete(i, false);
//	                          }
//	                      }
  							sheetObject2.SpeedDown2Excel(-1);
  						}
  					break;
  					
  					case "btn_New":
  						ComResetAll();  
  					break;
  					
  					case "btn_CheckAll":
  						checkAll("1");  
  					break;
  					
  					case "btn_UncheckAll":
  						checkAll("0");   
  					break;
  					
  					case "btn_Print":
  						goPrint("CM");   
  					break;
  					
  					case "btn_Print2":
  						goPrint("FAX");   
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

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
	 					if(!validateForm(sheetObj,formObj,sAction)) return;
	 					
						sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
 						
						formObj.f_cmd.value = SEARCH;   
						
						if (tabItem == 0){
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0116GS.do",FormQueryString(formObj));
							
							
	                        var arrXml = sXml.split("|$$|")
	                        
	                        for (var inx = 0; inx < arrXml.length; inx++) {
	                        	sheetObjects[inx].LoadSearchXml(arrXml[inx]);
	                        }
	                        
  						}else{ //FAX
  							sheetObj.DoSearch("ESM_BKG_0116GS.do",FormQueryString(formObj));
  						}
						


						ComOpenWait(false);			
						
 					break;
 					
 					case COMMAND01:      // INIT
						
						formObj.f_cmd.value = INIT;   
   	        	    	
						var searchXml = sheetObj.GetSearchXml("ESM_BKG_0116GS.do", FormQueryString(formObj));
						
						var sXml = searchXml.split("|$$|");
										
						//R Term
						ComBkgXml2ComboItem(sXml[0], formObj.rcv_term_cd, "val", "desc");
						//D Term
						ComBkgXml2ComboItem(sXml[1], formObj.de_term_cd, "val", "desc");
						
					break;

 					
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
      function validateForm(sheetObj,formObj,sAction){
        
    	  if (formObj.vvd.value == '' || formObj.vvd.value.length != 9){
   		  
	   		  ComShowCodeMessage("BKG00007");//VVD is not available !    		  
	   		  formObj.vvd.focus();    		  
	   		  return false;
	   	  }else{
	   		  
	   		  formObj.vsl_cd.value     = formObj.vvd.value.substring(0,4);
	   		  formObj.skd_voy_no.value = formObj.vvd.value.substring(4,8);
	   		  formObj.skd_dir_cd.value = formObj.vvd.value.substring(8);
	   		  
	   		  //alert( formObj.vsl_cd.value + "_" + formObj.skd_voy_no.value + "_" + formObj.skd_dir_cd.value);
	   	  }
	   	  
	   	  if (formObj.pol_cd.value == '' && formObj.pod_cd.value == ''){
	   		  
	   		  ComShowCodeMessage("BKG00137");//POL/POD is not available		  
	   		  formObj.pol_cd.focus();    		  
	   		  return false;
	   	  }
	   	  
	   	  if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value == ''){
	   		  
	   		  ComShowCodeMessage("BKG00458");//invalid customer code   		  
	   		  formObj.cust_cnt_cd.focus();
	   		  return false;
	   	  }
	   	  
	   	  if (formObj.cust_cnt_cd.value == '' && formObj.cust_seq.value != ''){
	   		  
	   		  ComShowCodeMessage("BKG00458");//invalid customer code		  
	   		  formObj.cust_seq.focus();
	   		  return false;
	   	  }
	   	  
	   	  if (formObj.pol_nod_cd.value != ''){
  		  
	   		  formObj.pol_yd_cd.value = formObj.pol_cd.value + formObj.pol_nod_cd.value;
	  	  }
	  	  
	  	  if (formObj.pod_nod_cd.value != ''){
	  		  
	  		  formObj.pod_yd_cd.value = formObj.pod_cd.value + formObj.pod_nod_cd.value;
	  	  }
	    	 
          return true;
      }


     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;

     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {

                     var cnt  = 0 ;
                     InsertTab( cnt++ , "C/M" , -1 );
                     InsertTab( cnt++ , "Fax" , -1 );
                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {

         var objs = document.all.item("tabLayer");

 	    	objs[nItem].style.display = "Inline";
 	    	objs[beforetab].style.display = "none";
 	    	
 	    	tabItem = nItem;
 	    	
 	    	document.form.tab_tp.value = tabItem;
 	    	
 	    	/*
 	 			if(nItem==0 &&tabLoad[0]!=1)
 					frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
 				else if(nItem==1 &&tabLoad[1]!=1)
 					frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
 	    	*/


 	    	//--------------- 요기가 중요 --------------------------//
 	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	    	//------------------------------------------------------//
 	    	beforetab= nItem;


     }

    
 	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var formObj = document.form;
 		
 		with(sheetObj)
 		{
 			formObj.tot_package.value = ComAddComma(CellValue(LastRow, 3));
 			formObj.tot_weight.value  = ComAddComma(CellValue(LastRow, 5));
 			formObj.tot_Measure.value = ComAddComma(CellValue(LastRow, 6));
 			
 			var redColor = RgbColor(255, 0, 0);
 			var blueColor = RgbColor(0, 0, 255);
 			
 			for (var i = 1; i <= LastRow; i ++)
 			{ 
 				if (CellValue(i,"link") == "OK"){
 					 				
	 				CellFontColor(i, "bl_no") = blueColor;
	 	      		CellFontUnderline(i, "bl_no") = true;
 				}
 			}
 		}
 	}
 	
 	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			var redColor = RgbColor(255, 0, 0);
 			var blueColor = RgbColor(0, 0, 255);
 			
 			for (var i = 1; i <= LastRow; i ++)
 			{ 
 				CellFontColor(i, "bl_no") = blueColor;
 	      		CellFontUnderline(i, "bl_no") = true;
 			}
 		}
 	}
    
 	/*
	 *  Search Option or Item Option Modify
	 * */
 	function t1sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	    
		if( colIdx == sheetObj.SaveNameCol("bl_no")){
					var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
					ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,true,"scrollbars=yes,resizable=yes");
					
		}else if( colIdx == sheetObj.SaveNameCol("misi")){
					var param= "?bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
					ComOpenWindowCenter2("/hanjin/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
//					ComOpenWindow("/hanjin/ESM_BKG_0109.do"+param, "BL Preview", "width=1024,height=740,scrollbars=yes,resizable=yes");
		}
 	}	
	
	 /*
	 *  Search Option or Item Option Modify
	 * */
 	function t2sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	    
		if( colIdx == sheetObj.SaveNameCol("bl_no")){
					var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
					ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,true,"scrollbars=yes,resizable=yes");
					
		}else if( colIdx == sheetObj.SaveNameCol("misi")){
					var param= "?bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");					
					ComOpenWindowCenter2("/hanjin/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
//						ComOpenWindow("/hanjin/ESM_BKG_0109.do"+param, "BL Preview", "width=1024,height=740,scrollbars=yes,resizable=yes");
		}
 	}	  
 	/*
 	 // grid click Event 처리
 	function t1sheet1_OnClick(sheetObj,Row, Col, Value)
 	{
 		sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 21) + " / " + seqSheet1 + " ]";
 	}
 	
 // grid click Event 처리
 	function t2sheet1_OnClick(sheetObj,Row, Col, Value)
 	{
 		sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 16) + " / " + seqSheet2 + " ]";
 	}
	*/

 	//CHECK BOX >>> CHECKALL,UNCHECKALL
 	function checkAll(value)
 	{
 		var sheetObj = sheetObjects[2];

 		for (var i = 1 ; i <= sheetObj.LastRow; i ++)
 		{ 		
 			if (sheetObj.CellValue(i, "chk_tp") == "C")
 			{
 				sheetObj.CellValue2(i, "Chk") = value;
 			}
 		}
 	}
 	
 	//PRINT >>> Call RD
 	function goPrint(tp)
 	{		
 		if (tp == "CM"){
 			
	 		var sheetObj= sheetObjects[0];
	 		
	 		var formObj = document.form;
	 		
	 		var rdPath  = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0779.mrd";
	 		//var rdParam = "/rv VVD[] POL[] POD[] RD[] BKG_OFFICD[] BKG_STAFF[] CNTR_NO[] BKG_NO[] SALES_REP[] SHIPPER[] OPTION[VVD-CDLC0037E/POL-KRPUS/POD-KRPUS] WHERE[AND A.VSL_CD = 'CDLC' AND A.SKD_VOY_NO = '0037' AND A.SKD_DIR_CD = 'E' AND A.POL_CD = 'KRPUS']";
	
	 		var option  = "";
	 		var where   = "";
	 		
	 		if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
	 		
	 		option = "OPTION[VVD-" + formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value + "/POL-" + formObj.pol_cd.value;
	 		
	 		where  = "WHERE[AND D.VSL_CD = '" + formObj.vsl_cd.value + "' AND D.SKD_VOY_NO = '" + formObj.skd_voy_no.value + "' AND D.SKD_DIR_CD = '" + formObj.skd_dir_cd.value + "' "
	 		
	 		if (formObj.pol_cd.value != ""){
	 			
	 			option = option + "/POL-" + formObj.pol_cd.value; 
	 			where  = where + " AND D.POL_CD = '" + formObj.pol_cd.value + "'";
	 		}
	 		
	 		if (formObj.pod_cd.value != ""){
	 			
	 			option = option + "/POD-" + formObj.pod_cd.value; 
	 			where  = where + " AND D.POD_CD = '" + formObj.pod_cd.value + "'";
	 		}
	 		
	 		if (formObj.rcv_term_cd.Text != "" || formObj.de_term_cd.Text != ""){
	 			
	 			option = option + "/R/D-" + formObj.rcv_term_cd.value + "/" + formObj.de_term_cd.value; 
	 			
	 			if (formObj.rcv_term_cd.value != ""){
	 				
	 				where  = where + " AND A.RCV_TERM_CD = '" + formObj.rcv_term_cd.value + "'";
	 			}
	 			
	 			if (formObj.de_term_cd.value != ""){
	 				
	 				where  = where + " AND A.DE_TERM_CD = '" + formObj.de_term_cd.value + "'";
	 			}
	 		}
	 		
	 		if (formObj.bkg_ofc_cd.value != ""){
	 			
	 			option = option + "/BKG Office-" + formObj.bkg_ofc_cd.value; 
	 			where  = where + " AND A.BKG_OFC_CD  = '" + formObj.bkg_ofc_cd.value + "'";
	 		}
	 		
	 		if (formObj.cre_usr_id.value != ""){
	 			
	 			option = option + "/BKG Staff-" + formObj.cre_usr_id.value;
	 			
	 			where  = where + " AND A.CRE_USR_ID  = '" + formObj.cre_usr_id.value + "'";
	 		}
	 		
	 		if (formObj.bkg_no.value != ""){
	 			
	 			option = option + "/BKG No.-" + formObj.bkg_no.value; 
	 			where  = where + " AND A.BKG_NO  = '" + formObj.bkg_no.value + "'";
	 		}
	 		
	 		if (formObj.bl_no.value != ""){
	 			
	 			option = option + "/B/L No.-" + formObj.bl_no.value; 
	 			where  = where + " AND A.BL_NO  = '" + formObj.bl_no.value + "'";
	 		}
	 		
	 		if (formObj.cntr_no.value != ""){
	 			
	 			option = option + "/CNTR No.-" + formObj.cntr_no.value; 
	 			where  = where + " AND C.CNTR_NO  = '" + formObj.cntr_no.value + "'";
	 		}
	 		
	 		if (formObj.ob_srep_cd.value != ""){
	 			
	 			option = option + "/Sales Rep.-" + formObj.ob_srep_cd.value; 
	 			where  = where + " AND A.OB_SREP_CD = '" + formObj.ob_srep_cd.value + "'";
	 		}
	 		
	 		if (formObj.cust_cnt_cd.value != "" || formObj.cust_seq.value != ""){
	 			
	 			option = option + "Shipper-" + formObj.cust_cnt_cd.value + formObj.cust_seq.value; 
	 			where  = where + " AND E.CUST_CNT_CD(+) = '" + formObj.cust_cnt_cd.value + "'";
	 			where  = where + " AND E.CUST_SEQ(+) = '" + formObj.cust_seq.value + "'";
	 		}
	 		
	 		option = option + "]";
	 		where  = where + "]";
	 		//alert("/rv " + option + " " + where);
	 		formObj.com_mrdTitle.value 		= "C/M Print by VVD";
	 		formObj.com_mrdBodyTitle.value 	= "C/M Print by VVD";
	 		formObj.com_mrdPath.value 		= rdPath;
	 		formObj.com_mrdArguments.value 	= "/rv " + option + " " + where;
	
	 		ComOpenRDPopup();
 		}else{ //FAX
 			
 			var sheetObj= sheetObjects[2];
	 		
	 		var formObj = document.form;
	 		
	 		var rdPath  = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0780.mrd";
	 		
	 		var bkg_nos = "";
	 		var usr_id  = formObj.usr_id.value;
	 		
	 		var firstChk = true;
	 		
	 		if (sheetObj.SelectRow == -1){
	 			
	 			alert(" Please Retrieve");
	 			return;
	 		}
	 		
	 		for (var i = 1 ; i <= sheetObj.LastRow ; i++){
	 			
	 			if (sheetObj.CellValue(i, "Chk") == "1"){
	 				
	 				if (firstChk){
	 				    
	 					bkg_nos += sheetObj.CellValue(i, "bkg_no"); 
	 					
	 					firstChk = false;
	 				}else{
	 					
	 					bkg_nos += "," + sheetObj.CellValue(i, "bkg_no");
	 					
	 				}	 					 			
	 			}
	 		}
	 		
	 		firstChk = true;
	 		
	 		var nowBkg_no = "";
	 		var befBkg_no = "";
	 		
	 		tempArr = bkg_nos.split(",");
	 		
	 		bkg_nos = "";
	 		
	 		for (var i = 0 ; i < tempArr.length ; i++){
	 			
	 			nowBkg_no = tempArr[i];
	 			
	 			if (i != 0){
	 				
	 				befBkg_no = tempArr[i-1];
	 			}
	 			
	 			if (befBkg_no != nowBkg_no){
	 				
	 				if (firstChk){
		 				
	 					bkg_nos += "'" + tempArr[i] + "'"; 
	 					
	 					firstChk = false;
	 				}else{
	 					
	 					bkg_nos += ",'" + tempArr[i] + "'"; 
	 				}	
	 			}
	 		}
	 		
	 		formObj.com_mrdTitle.value 		= "C/M Print by VVD";
	 		formObj.com_mrdBodyTitle.value 	= "C/M Print by VVD";
	 		formObj.com_mrdPath.value 		= rdPath;
	 		formObj.com_mrdArguments.value 	= "/rv BKG_NOS[" + bkg_nos + "] USR_ID[" + usr_id + "]";
	 		
	 		ComOpenRDPopup();
 		}
 	}
 	
 	function t2sheet1_OnChange(sheetObj, row, col, value) {		
 		 		
 		if (col == 0){
 
 			for (var i = 1 ; i <= sheetObj.LastRow ; i++){
 				
 				if (sheetObj.CellValue(row,"bl_no") == sheetObj.CellValue(i,"bl_no")){
 					 					
 					sheetObj.CellValue2(i, "Chk") = value;
 				}
 			}
 		}
    }
 	
	/* 개발자 작업  끝 */