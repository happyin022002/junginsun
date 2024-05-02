/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : fns_joo_0087.js
 *@FileTitle : Intergrated Loging Summary Report 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.01.19
 *@LastModifier : 김영오
 *@LastVersion : 1.0
 * 2012.01.19 김영오
 * 1.0 Creation
 * 
 * 
* -------------------------------------------------------
* Ticket ID : CHM-201217087-01
* Title : [ALPS JOO] Basic Info 및 통합선복조회 신규개발 및 미반영건 수정 요청
* 개발자 : 조병연
* 
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* - IBSheet에서 jo_aloc_adj_rmk_yn 이부분을 Hidden으로 수정


Date : 2012.07.19. 
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description : 
	1. Support & Administration > Joint Operation > TDR/RDR > Integrated Loading Summary Report 에
	   Lane 조회 조건 수정 (PopUp -> Select Box)


Date : 2012.07.23. 
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description : 
	1. Support & Administration > Joint Operation > TDR/RDR > Integrated Loading Summary Report 에
	   Lane 조회 조건 수정 (PopUp -> Select Box)
	   
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
     * @class FNS_JOO_0087 : FNS_JOO_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0087() {
    	
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl        	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
        this.eng_keypress			= eng_keypress;
        this.vsl_cd_change			= vsl_cd_change;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.setVslCd				= setVslCd;
        this.eff_dt_change			= eff_dt_change;
        this.slp_tp_click			= slp_tp_click;
        this.setPrepayments			= setPrepayments;
        this.setCharterersExp		= setCharterersExp;
        this.setOffhireExp			= setOffhireExp;
        this.setOwnersAccount		= setOwnersAccount;
        this.setBodBor				= setBodBor;
        this.setButton				= setButton;
        this.preWorkCheck			= preWorkCheck;
        this.initConfirm			= initConfirm;
        this.saveReadOnly			= saveReadOnly;
        this.setEffectiveDate		= setEffectiveDate;
        this.setCsrDate				= setCsrDate;
        this.formReset				= formReset;
        this.initCheckBox			= initCheckBox;
        this.rowRemove				= rowRemove;
        this.setCsrHeadInfomation 	= setCsrHeadInfomation;
        this.sheet1_OnChange		= sheet1_OnChange;
        this.checkAccountCode       = checkAccountCode;
        this.sheet1_OnClick			= sheet1_OnClick;
        this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
        this.sheet1_OnValidation	= sheet1_OnValidation;
        this.saveConfirm			= saveConfirm;
        this.setTotalAmount			= setTotalAmount;
        this.checkKeyNumber			= checkKeyNumber;
        this.setMakeTaxEvidence		= setMakeTaxEvidence;
        this.setMakeSlipMstData		= setMakeSlipMstData;
        this.checkAcctCdVvdLevel	= checkAcctCdVvdLevel;
        this.checkAcctCdVvdLevelMdt = checkAcctCdVvdLevelMdt;
        this.setEvidenceType		= setEvidenceType;
        this.setInitVatApply		= setInitVatApply;
        this.checkBalance			= checkBalance;
        this.setCellFont			= setCellFont;
        this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
        this.initRdConfig			= initRdConfig;
        this.rdOpen					= rdOpen;
    }
    
    

   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var prefix = "sheet1_";
	
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
                 case "btn_Retrieve":
                      doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                      break;

                 case "btn_downexcel":
                      var paramObj = new Object();
                      paramObj.cols = 10;
                      var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);
                      sheetObjects[0].Down2Excel(-1, false,false, true, "", url);
                      break;

                 case "btns_calendar_from": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_fr, 'yyyy-MM-dd');
                     break;

                case "btns_calendar_to": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_to, 'yyyy-MM-dd');
                     break;
					 					 
                case "btn_save": //저장
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					break;
					 
				case "btn_new":
					UF_reset();
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
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
      function setComboObject(combo_obj) {
         comboObjects[comboCnt++] = combo_obj;
      }

      function t3sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
          document.form.rlane_cd.focus();
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
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
		 
		 var formObject = document.form;
		 var param = "";
		 var sXml = "";
         var code = "CD02169";
         formObject.f_cmd.value = SEARCH01;
         param = FormQueryString(formObject)+"&super_cd1="+code;
         sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0087GS.do", param);
         ComXml2ComboItem(sXml, formObject.joRgnCdCombo, "code", "name");
		 
         
          	
         initControl();
		 
		 var toDay = ComGetNowInfo("ymd");
		 formObject.pre_fr.value = ComGetDateAdd(toDay, "M", -3);
		 //ComGetDateAdd(toDay, "Y", -1);
		 
        // Tab Object 초기화
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		tabObjects[0].SelectedIndex = 0; 
     }
      /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * @param {ibsheet} sheetObj    IBSheet Object

       * @param {int}     sheetNo     sheetObjects 배열에서 순번
       **/
      function initControl() {
          var formObject = document.form;
          axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);
          axon_event.addListenerForm  ('keydown', "fnOnKeyDown",  formObject);

          axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
          axon_event.addListenerForm  ('change'  , 'fnObjChange', formObject );
          axon_event.addListenerForm  ('keyup'   , "fnObjKeyUp",  formObject);

          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_from_back"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_from_next"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_to_back"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_to_next"       );
          axon_event.addListener      ('click',   'fnDocClick', "srch_rlane_cd"             );
    	  axon_event.addListener('click', 'additional_cd_click', 'additional_cd');
	
          axon_event.addListenerFormat('deactivate',  'fnDeactivate',  formObject);
          axon_event.addListenerFormat('activate',  'fnActivate',  formObject);
          
   
    	
          
      }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // t3sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 410;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "|Rev/Exp|Rep.\nCarrier|VVD|Port|ETD|Allocation|Allocation|Total Used|Total Used|Additional Slot\n(TEU)|Additional Slot\n(TEU)|Additional Slot\n(TEU)|Additional Slot\n(TEU)|Loading Detail(Unit)|Loading Detail(Unit)|Loading Detail(Unit)|Loading Detail(Unit)|Loading Detail(Unit)|Loading Detail(Unit)|Over Used\n(Long-Leg)|Over Used\n(Long-Leg)|Over Used\n(Short-Leg)|Over Used\n(Short-Leg)|Over Used\n(Short-Leg)|RF|RF|Empty|Empty|RDR\nRemark|Allocation\nAdjustment||||||||||||||||||";
                     var HeadTitle3 = "|Rev/Exp|Rep.\nCarrier|VVD|Port|ETD|TEU|WT|TEU|WT|20HC|40HC|45'|AK Void|20'|20HC|40'|40HC|45'|TOTAL\n(TEU)|TEU|WT|TEU|WT|SECTOR|O|I|TEU|WT|RDR\nRemark|Allocation\nAdjustment||||||||||||||||||";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     //InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,     "Status");
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix+"ibflag");
                     InitDataProperty(0, cnt++ , dtData,    60,    daCenter,    true,     prefix + "re_divr_cd",            	false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    60,    daCenter,    true,     prefix + "jo_crr_cd",            	false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    80,    daCenter,    true,     prefix + "vvd",            		false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    60,    daCenter,    true,     prefix + "port_cd",            	false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    75,    daCenter,    true,     prefix + "vps_etd_dt",            	false,    "",    dfNone, 0, false, false);
                    
					 InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "alloc_teu",      			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "alloc_wt", 	   			false,    "",    dfNumber, 0, false, true);
                  
				     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "actu_teu",  	   			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "actu_wt",        			false,    "",    dfNumber, 0, false, true);
                  
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "add_20hc_teu",      		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "add_40hc_teu",      		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "add_45_teu",       		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "ak_jo_void_teu_qty",       false,    "",    dfNumber, 0, false, true);

                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "full_20",        			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "full_20hc",        		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "full_40",         			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "full_40hc",      			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "full_45",      			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "total_teu",      			false,    "",    dfNumber, 0, false, true);
                 
				     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "over_long_teu",      		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "over_long_wt",       		false,    "",    dfNumber, 0, false, true);
                  
				     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "jo_shrt_leg_rmk_teu_qty",  false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "jo_shrt_leg_rmk_wgt",      false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    100,    daCenter,    false,    prefix + "jo_shrt_leg_rmk_sctr_nm", false,    "",    dfNone, 0, false, true);
                   
				     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "rf_o",      				false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "rf_i",      				false,    "",    dfNumber, 0, false, true);
                   
				     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     false,    prefix + "mt_teu",       			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtData,    60,     daRight,     true,     prefix + "mt_wt",        			false,    "",    dfNumber, 0, false, true);
                   
				     InitDataProperty(0, cnt++ , dtData,    70,     daCenter,    true,     prefix + "remark_yn",      			false,    "",    dfNone, 0, true, true);
					 
				     //InitDataProperty(0, cnt++ , dtCombo,   100,    daCenter,    true,     prefix + "jo_aloc_adj_rmk_yn",     	false,    "",    dfNone, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,   100,    daCenter,    true,     prefix + "jo_aloc_adj_rmk_yn",     	false,    "",    dfNone, 0, true, true);
                 	 					 					 
					 //Hidden : 저장 목록 비즈니스로직에서 처리할때 구분 값
					 InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  	prefix +"iud_flag",  				false,    "",    dfNone, 0, false, true);
					 //메모장 최초 호출 인지 체크하는 flag
					 InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  	prefix +"memo_flag1",  				false,    "",    dfNone, 0, false, true);
					 InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  	prefix +"memo_flag2",  				false,    "",    dfNone, 0, false, true);
					 //Hidden :실제 DB에 저장되는 필드
					 //1번 팝업
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_rf_ocn_qty",     		false,    "",    dfNumber, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_rf_ipt_qty",     		false,    "",    dfNumber, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_void_teu_qty",     	false,    "",    dfNumber, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,  80,     daCenter,    true,      prefix + "remark",      			false,    "",    dfNone, 0, true, true);
					 //2번팝업
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_aloc_adj_teu_qty",   	false,    "",    dfNone, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_aloc_adj_wgt",     	false,    "",    dfNone, 0, true, true);
					 InitDataProperty(0, cnt++ , dtHidden,  150,    daCenter,    true,      prefix + "jo_aloc_adj_rmk",     	false,    "",    dfNone, 0, true, true);
					 
					 //Hidden : 메모장 로드 시 사용자 입력값 저장	
					 //1번 팝업	
					 InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_jo_shrt_leg_rmk_teu_qty",  false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_jo_shrt_leg_rmk_wgt",  false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtHidden,  80,     daCenter,    false,   prefix + "hid_jo_shrt_leg_rmk_sctr_nm",  false,    "",    dfNone, 0, false, true);
					 InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_ak_jo_void_teu_qty",  false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_rf_o",      			false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_rf_i",      			false,    "",    dfNumber, 0, false, true);
					 //2번팝업
					 InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_alloc_teu",      		false,    "",    dfNumber, 0, false, true);
                     InitDataProperty(0, cnt++ , dtHidden,  80,     daRight,     false,   prefix + "hid_alloc_wt",      		false,    "",    dfNumber, 0, false, true);

				 InitDataCombo(0, prefix+"jo_aloc_adj_rmk_yn" , " |Yes|No", " |Yes|No");
				 }
             break;

             case 2:      // t3sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 410;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "|TDR|Port|ETD|Carrier|Allocation|Allocation|Actual Used|Actual Used|Over Used|Over Used|20'|20'|40'|40'|20'HC|20'HC|40'HC|40'HC|45'|45'|AK|AK|RF|RF|EMPTY|EMPTY|Source";
                     var HeadTitle3 = "|TDR|Port|ETD|Carrier|TEU|WT|TEU|WT|TEU|WT|Full|Empty|Full|Empty|Full|Empty|Full|Empty|Full|Empty|UNIT|VOID|20'|40'|TEU|WEIGHT|Source";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		prefix+"ibflag");

                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    true,     "vvd",            false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,    true,     "vps_port_cd",    false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    true,     "vps_etd_dt",     false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "opr_cd",         false,    "",    dfNone);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_teu",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_wgt",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_slot", false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_wgt",  false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_slot",      false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_wgt",       false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_20",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_20",          false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_40",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_40",          false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_20",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_20",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_40",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_40",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_45",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_45",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_unit",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_void",        false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_20_qty",      false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_40_qty",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "mt_teu",         false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "mt_wt",          false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,     true,    "source",         false,    "",    dfNone);
                 }
             break;
			 
             case 3:      // t3sheet3 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 410;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "|V.V.D|Port|ETD|Carrier|Allocation|Allocation|Actual Used|Actual Used|Over Used|Over Used|20'|20'|40'|40'|20'HC|20'HC|40'HC|40'HC|45'|45'|AK|AK|RF|RF|EMPTY|EMPTY|Source";
                     var HeadTitle3 = "|V.V.D|Port|ETD|Carrier|TEU|WT|TEU|WT|TEU|WT|Full|Empty|Full|Empty|Full|Empty|Full|Empty|Full|Empty|UNIT|VOID|20'|40'|TEU|WEIGHT|Source";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		prefix+"ibflag");

                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    true,     "vvd",            false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,    true,     "vps_port_cd",    false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    true,     "vps_etd_dt",     false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "opr_cd",         false,    "",    dfNone);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_teu",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_wgt",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_slot", false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_wgt",  false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_slot",      false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_wgt",       false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_20",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_20",          false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_40",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_40",          false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_20",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_20",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_40",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_40",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_45",       false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_45",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_unit",        false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_void",        false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_20_qty",      false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_40_qty",      false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "mt_teu",         false,    "",    dfNumber);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "mt_wt",          false,    "",    dfNumber);

                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,     true,    "source",         false,    "",    dfNone);
                 }
             break;
         }
     }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회                       
            	//필수입력 체크 .. 사용안한다고해서 주석처리
				//if (formObj.re_divr_cd.Code == " ") {
                //     ComShowCodeMessage("JOO00115", "Rev/Exp");
                //     formObj.re_divr_cd.focus();
                //     return false;
                //}
				
				//if (formObj.oprCdCombo.Code == "") {
                //     ComShowCodeMessage("JOO00115", "Carrier");
                //     formObj.oprCdCombo.focus();
                //     return false;
                //}
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
//				if (formObj.joRgnCdCombo.Code == "") {
//                     ComShowCodeMessage("JOO00115", "Region");
//                     formObj.joRgnCdCombo.focus();
//                     return false;
//                }
				sheetObjects[0].RemoveAll();
                formObj.f_cmd.value = SEARCHLIST01;
                
               // ComOpenWait(true);		
                sheetObj.DoSearch("FNS_JOO_0087GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
               // ComOpenWait(false);
               
                break;
			
			case IBSAVE:       //저장
				
				formObj.f_cmd.value = MULTI;
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				if (SaveStr == ""){
					ComShowCodeMessage("JOO00036");
					return false;
				}
				
				if (!ComShowCodeConfirm("JOO00046")){
					return false;
				}
				
				var SaveStr = ComGetSaveString(sheetObj);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0087GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
				
				//저장후 재 조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				ComOpenWait(false);
                break;
				
            case IBCLEAR:
                var param = "";
                var sXml = "";

                var code   =  "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml  = sheetObj.GetSearchXml("FNS_JOO_0087GS.do", param);

                formObj.f_cmd.value = SEARCHLIST03;
                param = FormQueryString(formObj);
                sXml = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                var comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
                var comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
                formObj.oprCdCombo.RemoveAll();
                formObj.oprCdCombo.InsertItem(-1, "ALL", "");		//최초 all기능 제거
                for (var w=0; w<comboCodeList.length-1; w++) {
                    formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                }
                formObj.oprCdCombo.Index2 = 0;
				
				sheetObjects[0].ColHidden(prefix +"full_20") = true;
				sheetObjects[0].ColHidden(prefix +"full_20hc") = true;
				sheetObjects[0].ColHidden(prefix +"full_40") = true;
				sheetObjects[0].ColHidden(prefix +"full_40hc") = true;
				sheetObjects[0].ColHidden(prefix +"full_45") = true;
				sheetObjects[0].ColHidden(prefix +"total_teu") = true;				
                break;
 
            case IBSEARCH_ASYNC01:
                var code            =  formObj.rlane_cd.value;
                formObj.f_cmd.value = SEARCH07;
                var param           =  FormQueryString(formObj)+"&code="+code;
                var sXml            =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                var sTotal          =  ComGetTotalRows(sXml);
                if (sTotal == "0") {
                    ComShowCodeMessage("JOO00110");
                    formObj.rlane_cd.value = '';
                    formObj.rlane_cd.focus();
                    //fnDeactivate 덕분에...아래와 같이 코딩함
                } else {
                    formObj.rlane_cd.value = code;
                }
                break;
				
            case IBSEARCH_ASYNC02:
            	                 
                formObj.code.value =formObj.vvd.value;
                	
                formObj.f_cmd.value = SEARCH20;
                var param           =  FormQueryString(formObj);
                                
                var sXml            =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                var sTotal          =  ComGetTotalRows(sXml);
				
                if (sTotal == "0") {
                    ComShowCodeMessage("JOO00189");
                    formObj.vvd.value = '';
                    formObj.vvd.focus();
                    //fnDeactivate 덕분에...아래와 같이 코딩함
                } else {
                    //formObj.vvd.value = code;
					//[CoJoo.js -> JooXmlToArray] 조회결과 xml을 입력받아 Array로 결과값 반환 함수 호출 
					//arrResult[0][1] : Lane
					//arrResult[0][5] : Region 
					var arrResult = JooXmlToArray(sXml);
					
					 formObj.rlane_cd.Code = arrResult[0][1];
					
					formObj.region.value = ("'" + ComReplaceStr(arrResult[0][5], ",", "', '") + "'");
            		formObj.joRgnCdCombo.Code  = arrResult[0][5];
            		
            		
                }
                break;
        }
    }

    /**
    * Combo 기본 설정
    * Combo의 항목을 설정한다.
    * @param comboObj
    * @param comboIndex Number
    */
    function initCombo(comboObj, comboNo ) {
    	
    	var formObj = document.form;
    	
        switch(comboObj.id) {
            case "oprCdCombo":
                with (comboObj) {
                    MultiSelect = true;
                    DropHeight = 200;
                }
                break;
			case "joRgnCdCombo":
                comboObj.MultiSelect = true;
                comboObj.DropHeight = 200;
                break;
				
			case "re_divr_cd":
				with (comboObj) {
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left");
					SetColWidth("60");
					DropHeight = 160;
					ValidChar(2, 0);//영문대문자만 입력가능
					MaxLength = 7;
				}
				var comboItems = "ALL, |Revenue,R|Expense,E";
				UF_addComboItem(comboObj, comboItems.split("|"));
				comboObj.Text2 = "ALL";
				break;
			
			case "skd_dir_cd":
				with (comboObj) {
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left");
					DropHeight = 160;
					ValidChar(2, 0);//영문대문자만 입력가능
					MaxLength = 3;
				}
				var comboItems = "ALL, |E,E|W,W|S,S|N,N";
				UF_addComboItem(comboObj, comboItems.split("|"));
				comboObj.Text2 = "ALL";
				break;
				
			case "rlane_cd":
				with (comboObj) {
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left");
					SetColWidth("50");
					DropHeight = 160;
					ValidChar(2, 1);//영문대문자+숫자만 입력가능
					MaxLength = 5;
				}
								
				formObj.f_cmd.value = SEARCH16; 				
 				var sXml = sheetObjects[0].GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
                 
				break;
				
        }
    }


    /**
     * oprCdCombo의 MultiSelection OnCheckClick 이벤트 처리
     *  - MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
     *  - 'ALL'을 선택하면 다른 Item의 Check해제
     *  - Item을 선택했을 경우 SQL의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
     */
    function oprCdCombo_OnCheckClick(comboObj, index, code) {
        var formObject = document.form
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;
            if (formObject.opr_cd == "[object]") formObject.opr_cd.value = "";

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                // Submit할 내용도 Clear
                formObject.opr_cd.value = "";

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                // Submit할 내용 Define
                formObject.opr_cd.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
            }
        }
    }

      /**
       * Period NAVI 처리 이벤트
       * @param void
       * @return void
       */

       function fnDocClick(){
           var obj = event.srcElement;
           var formObj = document.form;
           switch (obj.name){
               case "srch_rlane_cd"://Lane 팝업 조회
                    var lane_cd = formObj.rlane_cd.value;
                    var param = "?mode=svc&lane_cd="+lane_cd;
                    ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 820, 460, 'getCOM_ENS_081_1', '1,0,1,1,1,1,1,1');
                    break;
           }
       }
       
       function getCOM_ENS_081_1(aryPopupData){
           with(document.form){
                 rlane_cd.value  = aryPopupData[0][3];
           }
       }

        /**
         * <pre>
         *    form Element의 KeyPress Event 발생시 처리.
         *
         * </pre>
         * @return
         */
        function fnObjKeyPress(){
            var obj = event.srcElement;
            var formObj = document.form;
            var attr    = obj.getAttribute("dataformat");

            switch (attr){
                case  'ymd':
                      ComKeyOnlyNumber( obj );
                      break;
                case  'engup':
                      ComKeyOnlyAlphabet( 'upper' );
                      break;
                case  'uppernum':
                       ComKeyOnlyAlphabet( 'uppernum' );
                       break;
            }
            
        }
         
      	/**
      	 * form Element의 change Event 발생시 처리. <br>
      	 **/
     	function fnObjChange()
      	{	     
      		//ComChkObjValid(event.srcElement);
      		var obj      = event.srcElement; 
      		var formObj  = document.form; 
      		var sheetObj = sheetObjects[0]; 
      	
      		
      		switch(obj.name)
      		{      
      		case "rlane_cd":
      	    	oprCdCombo_clear();      	    	
      	    	oprCdCombo_Inquiry(document.form.oprCdCombo);
      			break;
      		}
      	}
      
        
         //Lane 변경시 Carrier 초기화
         function oprCdCombo_clear(){
        	document.form.oprCdCombo.Index2 = -1;
        	document.form.oprCdCombo.RemoveAll();
         	document.form.opr_cd.value = "";

         	sheetObjects[0].RemoveAll();
         }
         
         function oprCdCombo_Inquiry(comboObj, code){
          	var formObj = document.form;
          	
          	if (formObj.pre_fr.value.length < 10){
          		ComShowCodeMessage("JOO00019", "Period");
          		formObj.pre_fr.focus();
          		return;
          	}

          	if (formObj.pre_to.value.length < 10){
          		ComShowCodeMessage("JOO00019", "Period");
          		formObj.pre_to.focus();
          		return;
          	}
          
          	
          	if ( code == null
          		|| code.length < 5 ){
          		ComShowCodeMessage("JOO00019", "Lane");
          		formObj.rlane_cd.focus();
          		return;
          	}
          	
             	
          	if (comboObj.GetCount() == 0){
          		comboObj.Enable = false;	
          		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj ,"oprCdCombo");
          		comboObj.Enable = true;	
          	}
          	
         
          	
          }
         
         // 조회조건필드인 Carrier 데이터 조회
         function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
             sheetObj.ShowDebugMsg = false;

             switch(sAction) {

                case IBSEARCH:
         			if (sComboObj.id == "oprCdCombo") {
         				//콤보필드를 초기화시킨다.
         				sComboObj.RemoveAll();
         									
         				formObj.f_cmd.value = SEARCH02;
         				var sXml = sheetObj.GetSearchXml("FNS_JOO_0056GS.do", FormQueryString(formObj));
         				
                         var comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
                         var comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
                         formObj.oprCdCombo.RemoveAll();
                         formObj.oprCdCombo.InsertItem(-1, "[ALL]", "");
                         for (var w=0; w<comboCodeList.length-1; w++) {
                             formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                         }
                         formObj.oprCdCombo.Index2 = 0;
         			}
         			
         	        break;
             }
         }
         
           /**
            * <pre>
            *     form element의 dataformat을 이용한 입력 Validate 처리,
            *     focus 잃었을때발생.
            * </pre>
            *
            * @return void
            */
           function fnDeactivate(){
                var obj = event.srcElement;
                var formObj = document.form;
                var attr   =  obj.getAttribute("dataformat");

                switch(obj.name){
                    case 'pre_fr':
                          ComAddSeparator(obj );
                          break;
                    case 'pre_to':
                          ComAddSeparator(obj );
                          break;
                  /*  case 'rlane_cd':
                        if( obj.value == ""){return;}
                        if( !ComChkObjValid(obj  )){
                             ComSetFocus(obj);
                             return;
                        }
                        break;
                 */
                }
           }

            /**
             * <pre>
             *     form element의 dataformat을 이용한 입력 Validate 처리,
             *     focus 얻었을때발생.
             * </pre>
             *
             * @return void
             */
            function fnActivate(){
                var obj = event.srcElement;
                var formObj = document.form;
                var attr   =  obj.getAttribute("dataformat");
                switch(attr){
                    case 'ymd':
                         ComClearSeparator(obj );
                         break;

                }
                ComSetFocus(obj);
            }
       /**
        *
        * <pre>
        *    Form Clear 처리
        * </pre>
        *
        * @param
        * @return
        * @author jang kang cheol
        */
       function fnFormClear(){
           var formObj = document.form;
           
            ComClearObject(formObj.rlane_cd  );
           if( sheetObjects[0].RowCount > 0) {
               sheetObjects[0].RemoveAll();
           }
       }
	   
     function fnObjKeyUp(){
         var formObj = document.form;
         var obj     = event.srcElement;
                 
         switch (obj.name){
           case  'rlane_cd':
                 if( sheetObjects[0].RowCount > 0) {
                       sheetObjects[0].RemoveAll();
                 }
                 var maxlength = obj.getAttribute("maxlength");
                 if( obj.value.length != maxlength   ){
                     return;
                 }else{
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                 }
                 break;
				 
           case  'vvd':
                 if( sheetObjects[0].RowCount > 0) {
                       sheetObjects[0].RemoveAll();
                 }
                 var maxlength = obj.getAttribute("maxlength");
                 if( obj.value.length != maxlength   ){
                     return;
                 }else{
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC02);
                 }
                 break;
         }
     }
	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction){
                 case IBSEARCH:
                     if(!ComChkValid(  formObj )){
                         return false;
                     }
                     break;
         }
         return true;
     }
	 
	 /**
     * joRgnCdCombo MultiSelection OnCheckClick 이벤트 처리
     *  - MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
     *  - Item을 선택했을 경우 SQL의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
     */
    function joRgnCdCombo_OnCheckClick(comboObj, index, code) {
        var formObject = document.form
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            formObject.region.value = "";

        } else {
            // Submit할 내용 Define
            formObject.region.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
        }
    }
	
	/**
	 * 화면 초기화
	 */
	function UF_reset(){
		
		for(var i=0; i<comboObjects.length; i++){
			if (i == 1){
				comboObjects[i].Index2 = -1;
			}else{
				comboObjects[i].Index2 = (comboObjects[i].GetCount() == 0? -1 : 0);
			}
		}		
		 
		 var param = "";
		 var sXml = "";
         var code = "CD02169";
         document.form.f_cmd.value = SEARCH01;
         param = FormQueryString(document.form)+"&super_cd1="+code;
         sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0087GS.do", param);
         ComXml2ComboItem(sXml, document.form.joRgnCdCombo, "code", "name");
                  
		var toDay = ComGetNowInfo("ymd");
		
		document.form.vvd.value = "";
	//	document.form.rlane_cd.value = "";
		document.form.additional_cd[0].checked = true;	
		document.form.pre_fr.value = ComGetDateAdd(toDay, "M", -3);
		document.form.pre_to.value = document.form.dt2.value;
		document.form.tab_gubun.value = "R";
		
		sheetObjects[0].RemoveAll();	
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();	
//		comboObjects[2].Text2 = "";
		sheetObjects[0].ColHidden(prefix +"load_20") = true;
		sheetObjects[0].ColHidden(prefix +"load_40") = true; 
		sheetObjects[0].ColHidden(prefix +"load_40_hc") = true;
		sheetObjects[0].ColHidden(prefix +"load_45") = true;
		sheetObjects[0].ColHidden(prefix +"load_total") = true;
		
		document.getElementById("additional_cd_line").style.display="";
		tabLayer[0].style.display = "";
		tabLayer[1].style.display = "none";
		tabLayer[2].style.display = "none";
		tabLayer[1].style.display = "none";
		tabLayer[2].style.display = "none";
    	tabLayer[0].style.display = "Inline";
		tabLayer[0].style.zIndex = tabLayer[0].style.zIndex -1 ;	
		
		// add 2012.07.25.
		document.form.skd_dir_cd.Index2 = 0;
						
    	document.form.rlane_cd.RemoveAll();
    	document.form.code.value ='';
     	document.form.f_cmd.value = SEARCH16; 				
		var sXml = sheetObjects[0].GetSearchXml("JOOCommonGS.do", FormQueryString(document.form));       		
		ComXml2ComboItem(sXml, document.form.rlane_cd,"code","code");
    }
   
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
		//탭 변경 이벤트 임시로 주석처리
        /*
		var objs = document.all.item("tabLayer");
    	objs[beforetab].style.display = "none";
    	objs[nItem].style.display = "Inline";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
		
		if (nItem == 0){
			document.getElementById("additional_cd_line").style.display="";
			document.form.tab_gubun.value = "R";
		} else if (nItem == 1){
			document.getElementById("additional_cd_line").style.display="none";
			document.form.tab_gubun.value = "T";
			tabLayer[0].style.display = "none";
		} else if (nItem == 2){
			document.getElementById("additional_cd_line").style.display="none";
			document.form.tab_gubun.value = "B";
		}
		*/
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
                    InsertTab( cnt++ , "RDR" , -1 );
                    InsertTab( cnt++ , "TDR" , -1 );
                    InsertTab( cnt++ , "Booking Date" , -1 );
                }
                break;
        }
    }
	
	/**
	 * Additional Slot 라디오 버튼 클릭 이벤트
	 */
	function additional_cd_click(){
		if (document.form.additional_cd[0].checked){
			sheetObjects[0].ColHidden(prefix +"full_20") = true;
			sheetObjects[0].ColHidden(prefix +"full_20hc") = true;
			sheetObjects[0].ColHidden(prefix +"full_40") = true;
			sheetObjects[0].ColHidden(prefix +"full_40hc") = true;
			sheetObjects[0].ColHidden(prefix +"full_45") = true;
			sheetObjects[0].ColHidden(prefix +"total_teu") = true;
		} else {
			sheetObjects[0].ColHidden(prefix +"full_20") = false;
			sheetObjects[0].ColHidden(prefix +"full_20hc") = false;
			sheetObjects[0].ColHidden(prefix +"full_40") = false;
			sheetObjects[0].ColHidden(prefix +"full_40hc") = false;
			sheetObjects[0].ColHidden(prefix +"full_45") = false;
			sheetObjects[0].ColHidden(prefix +"total_teu") = false;
		}
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
	 * 조회완료 후 처리 이벤트
	 * @param {Object} sheetObj
	 * @param {Object} ErrMsg
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++){
			sheetObj.CellEditable(i,prefix +'remark_yn') = false;
			sheetObj.CellEditable(i,prefix +'jo_aloc_adj_rmk_yn') = true;
		}
	}
	function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
	    switch (sheetObj.ColSaveName(Col)) {
			case prefix+"jo_aloc_adj_rmk_yn":
		        var alloAdjustment = sheetObj.CellValue(Row, prefix+"jo_aloc_adj_rmk_yn");		        
				if (alloAdjustment == "Yes") {
					Joo0087_02ShowMemoPad(sheetObj, Row, sheetObj.SaveNameCol("jo_aloc_adj_rmk_yn"));
				}
				break;
	    }
	}	
	/**
	 * @param {Object} sheetObj
	 * @param {Object} Row
	 * @param {Object} Col
	 * @param {Object} Value
	 */
	function t3sheet1_OnClick(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		sheetObj.ShowDebugMsg = false;				 
		switch (sheetObj.ColSaveName(Col)) {
			case prefix+"remark_yn":
		        var rdrRemark = sheetObj.CellValue(Row, prefix+"remark_yn");		        
				if (rdrRemark == "Yes") {
					Joo0087_01ShowMemoPad(sheetObj, Row, sheetObj.SaveNameCol("remark_cont"));
				}
				break;
			
			case prefix+"jo_aloc_adj_rmk_yn":
		        var alloAdjustment = sheetObj.CellValue(Row, prefix+"jo_aloc_adj_rmk_yn");		        
				if (alloAdjustment == "Yes") {
					Joo0087_02ShowMemoPad(sheetObj, Row, sheetObj.SaveNameCol("jo_aloc_adj_rmk_yn"));
				}
				break;
	    }
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//메모장1
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
     /**
      * 공통js의 ComShowMemoPad를 ReDefine
      */
    function Joo0087_01ShowMemoPad(sheetObj, row, col) {
        //함수의 인자 default 값 설정하기
        var iWidth = 400;
        var iHeight = 311;
        //전역변수에 값setting
        memoSheet = sheetObj;
        memoRow = row;
        memoCol = col;

        //메모를 위한 IBSheet 정보 받기
        if (!ComIsNumber(col)) ccolol = sheetObj.SaveNameCol(col);

        //메모패드 만들기
        if (!Joo0087_01initMemoPad()) return;

        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 1112;
        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row) + sheetObj.RowHeight(row) + 2;
        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.

        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
        if (top.document != document && window.frameElement.scrolling == "no") {
            //높이초과
            if (iTop + iHeight  > document.body.clientHeight) {
                iBottom = iTop + sheetObj.RowHeight(row) - (sheetObj.RowHeight(row) * 2);
                if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;
                iTop = iBottom-iHeight;
                if (iTop <0) iTop = 0
            }

            //넓이초과
            if (iLeft + iWidth  > document.body.clientWidth) {
                iLeft = document.body.clientWidth - iWidth;
                if (iLeft<0) iLeft = 0;
            }
        }

        var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 26;
        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = true;

        var _divMemo = document.getElementById(MEMO_DIV_NAME);
        _divMemo.style.width = iWidth;
        _divMemo.style.height = iHeight;
        _divMemo.style.top = iTop;
        _divMemo.style.left = iLeft;
        _divMemo.style.visibility = "visible";
        _divMemo.focus();

        ComSetFocus(_frameDoc.getElementById("_memoInput1_"));
		
		_frameDoc.getElementById("_MemoText_").value = memoSheet.CellValue(row, prefix +"remark");
		
		
		if (memoSheet.CellValue(row, prefix +"memo_flag1") == "Y") {
			//메모장1 로드 시 그리드값 셋팅하기	(사용자가 입력한 값)
			_frameDoc.getElementById("_memoInput1_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_jo_shrt_leg_rmk_teu_qty")));
			_frameDoc.getElementById("_memoInput2_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_jo_shrt_leg_rmk_wgt")));
			_frameDoc.getElementById("_memoInput3_").value = memoSheet.CellValue(row, prefix +"hid_jo_shrt_leg_rmk_sctr_nm");
			_frameDoc.getElementById("_memoInput4_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_rf_o")));
			_frameDoc.getElementById("_memoInput5_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_rf_i")));
			_frameDoc.getElementById("_memoInput6_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_ak_jo_void_teu_qty")));
		} else {
			//메모장1 로드 시 그리드값 셋팅하기	(최초 로드 시 화면 값 그대로)
			_frameDoc.getElementById("_memoInput1_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_shrt_leg_rmk_teu_qty")));
			_frameDoc.getElementById("_memoInput2_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_shrt_leg_rmk_wgt")));
			_frameDoc.getElementById("_memoInput3_").value = memoSheet.CellValue(row, prefix +"jo_shrt_leg_rmk_sctr_nm");
			_frameDoc.getElementById("_memoInput4_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_rf_ocn_qty")));
			_frameDoc.getElementById("_memoInput5_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_rf_ipt_qty")));
			_frameDoc.getElementById("_memoInput6_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_void_teu_qty")));
		}
    }
	
    /**
     * 공통js의 initMemoPad를 ReDefine
     */
    function Joo0087_01initMemoPad() {

        //메모용 Div가 없으면 생성한다.
        if (document.getElementById(MEMO_DIV_NAME) != null) return true;

        //메모용 Div 만들기
        var _divMemo=document.createElement("<div id='" + MEMO_DIV_NAME + "' style='position:absolute; visibility:hidden'/>");
        document.body.insertBefore(_divMemo);

        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        var _frameMemo = document.createElement("<iframe id='" + MEMO_FRAME_NAME + "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%'/>");
        _divMemo.appendChild(_frameMemo);

        var _frameDoc = _frameMemo.contentWindow.document;
        
        //iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _frameDiv = _frameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad01(true);' style='border:1.2px solid #aaa; padding:1px; background-color:#E6EFF6;'/>");
        _frameDoc.appendChild(_frameDiv);
        
        var _upperDiv = "upper";

        var _frameDiv1 = _frameDoc.createElement("<span style='width:311px;'/>");
        _frameDiv.appendChild(_frameDiv1);
        //Div안에 Textarea 만들기
        _frameDiv1.appendChild(_frameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME + "' style='border:#7F9DB9 1px solid; color:#4f4f4f; width:100%'/>"));

        var _frameDiv2 = _frameDoc.createElement("<span style='padding:10px; width:85px;'/>");
        _frameDiv.appendChild(_frameDiv2);
        //Div안에 Input 만들기
        var _frameP10 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:700; color:#4f4f4f;'/>");
        _frameP10.innerHTML = "Short-Leg</br>&nbsp Remark";
        _frameDiv2.appendChild(_frameP10);
        var _frameP11 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP11.innerText = "  ▷  TEU";
        _frameDiv2.appendChild(_frameP11);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput1_' tabindex='1' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='5' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP12 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP12.innerText = "  ▷  WT";
        _frameDiv2.appendChild(_frameP12);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput2_' tabindex='2' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46&&event.keyCode!=110&&event.keyCode!=190)return false;' onfocusout='this.value=parent.ComAddComma2(this.value, \"#,###.00\");' maxlength='8' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP13 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP13.innerText = "  ▷  SECTOR";
        _frameDiv2.appendChild(_frameP13);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput3_' tabindex='3' onkeypress='if((event.keyCode>47 && event.keyCode<58))return false;' onfocusout='this.value=this.value.toUpperCase()'  maxlength='20' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:left; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP20 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:900; color:#4f4f4f;'/>");
        _frameP20.innerText = "RF";
        _frameDiv2.appendChild(_frameP20);
        var _frameP21 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP21.innerText = "  ▷  O";
        _frameDiv2.appendChild(_frameP21);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput4_' tabindex='4' onkeypress='if((event.keyCode<48||event.keyCode>57)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=45) return false;' onfocusout='this.value=parent.ComGetMaskedValue(parent.ComAddComma(this.value),\"int\");' maxlength='5' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP22 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP22.innerText = "  ▷  I";
        _frameDiv2.appendChild(_frameP22);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput5_' tabindex='5' onkeypress='if((event.keyCode<48||event.keyCode>57)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=45) return false;' onfocusout='this.value=parent.ComGetMaskedValue(parent.ComAddComma(this.value),\"int\");' maxlength='5' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP30 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:900; color:#4f4f4f;'/>");
        _frameP30.innerHTML = "Void";
        _frameDiv2.appendChild(_frameP30);
        var _frameP31 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP31.innerText = "  ▷  TEU";
        _frameDiv2.appendChild(_frameP31);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput6_' tabindex='6' onkeypress='if((event.keyCode<48||event.keyCode>57)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=45) return false;' onfocusout='this.value=parent.ComGetMaskedValue(parent.ComAddComma(this.value),\"int\");' maxlength='5' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));

        var _centerTag = _frameDoc.createElement("<div style='height:20px; text-align:center; vertical-align:middle;'/>");
        //Apply 버튼 만들기
        var _button1 = _frameDoc.createElement("<span id='btn_apply' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.Joo0087_01SetMemoValue(document.getElementById(\"" + MEMO_TEXT_NAME + "\").value," + 4000 + ");'/>");
        _button1.innerText = "Apply";
        _centerTag.appendChild(_button1);
        //Close 버튼 만들기
        var _button2 = _frameDoc.createElement("<span id='btn_close' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.ComHideMemoPad01(true)'/>");
        _button2.innerText = "Close";
        _centerTag.appendChild(_button2);
        _frameDiv.appendChild(_centerTag);
		
		
		

        //메모용 iFrame 자동 닫기 처리
        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad01") < 0) {
            //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
            window.popupMemoOldEventListener = document.onmouseup;
            if (window.popupMemoOldEventListener != null) {
                //기존에 document.onmouseup에  정의된 함수가 있는 경우
                //document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad01();");
            } else {
                //기존에 document.onmouseup에  정의된 함수가 없는 경우
                document.onmouseup = ComHideMemoPad01;
            }

            //ActiveX에 포커스가 갔을때 메모DiV 닫기
            var objs = document.getElementsByTagName("OBJECT")
            window.popupMemoOldObjEventListener = new Array(objs.length);
            for(var i = 0 ; i < objs.length ; i++){
                window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
                if (window.popupMemoOldObjEventListener[i] != null) {
                    //기존에 document.onmouseup에  정의된 함수가 있는 경우
                    objs[i].onfocus = new Function("window.popupMemoOldObjEventListener[" + i + "](); ComHideMemoPad01();");
                } else {
                    //기존에 document.onmouseup에  정의된 함수가 없는 경우
                    objs[i].onfocus = ComHideMemoPad01;
                }
            }
        }
        return true;
    }

    /**
     * 공통js의 setMemoValue를 ReDefine
     */
    function Joo0087_01SetMemoValue(sValue, iMax) {
        try {
            if (sValue.length > iMax) {
                ComShowMessage("characters long");
                return;
            } else {
                if (memoSheet == null) return;

                var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
                if (!_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly) {
                    memoSheet.CellValue(memoRow, memoCol) = sValue;
                }

				var actuTeu = memoSheet.CellValue(memoRow, prefix +"actu_teu");
				var allocTeu = memoSheet.CellValue(memoRow, prefix +"alloc_teu");
				
                var joShrtLegRmkTeuQty = ComNullToZero(_frameDoc.getElementById("_memoInput1_").value.trim());
                var joShrtLegRmkWgt = ComNullToZero(_frameDoc.getElementById("_memoInput2_").value.trim());
                var joShrtLegRmkSctrNm = _frameDoc.getElementById("_memoInput3_").value.trim();
                var joRfOcnQty = ComNullToZero(_frameDoc.getElementById("_memoInput4_").value.trim());
                var joRfIptQty = ComNullToZero(_frameDoc.getElementById("_memoInput5_").value.trim());
                var joVoidTeuQty = ComNullToZero(_frameDoc.getElementById("_memoInput6_").value.trim());
				
				//memoSheet.CellValue(memoRow, prefix +"jo_rf_ocn_qty") = parseInt(joRfOcnQty) + parseInt(memoSheet.CellValue(memoRow, prefix +"hid_jo_rf_ocn_qty"));				
				
				//메인 그리드로 값 보내기    
				//memoSheet.CellValue(memoRow, prefix +"jo_shrt_leg_rmk_teu_qty") = joShrtLegRmkTeuQty;	//화면에 보여주는값(TEU)
				//memoSheet.CellValue(memoRow, prefix +"jo_shrt_leg_rmk_wgt") = joShrtLegRmkWgt;			//화면에 보여주는값(WT)
				//memoSheet.CellValue(memoRow, prefix +"jo_shrt_leg_rmk_sctr_nm") = joShrtLegRmkSctrNm;	//화면에 보여주는값(SELECTION)				
				//memoSheet.CellValue(memoRow, prefix +"rf_o") = joRfOcnQty;								//화면에 보여주는값(RF_O)
                //memoSheet.CellValue(memoRow, prefix +"rf_i") = joRfIptQty;								//화면에 보여주는값(RF_I)
                //memoSheet.CellValue(memoRow, prefix +"ak_jo_void_teu_qty") = joVoidTeuQty;				//화면에 보여주는값(AK_VOID)
				
				memoSheet.CellValue(memoRow, prefix +"jo_rf_ocn_qty") = joRfOcnQty;						//실제 저장되는값(RF_O)
                memoSheet.CellValue(memoRow, prefix +"jo_rf_ipt_qty") = joRfIptQty;						//실제 저장되는값(RF_I)
                memoSheet.CellValue(memoRow, prefix +"jo_void_teu_qty") = joVoidTeuQty;					//실제 저장되는값(AK_VOID)
				
				memoSheet.CellValue(memoRow, prefix +"remark") = _frameDoc.getElementById("_MemoText_").value.trim();
				memoSheet.CellValue(memoRow, prefix +"remark_yn") = "Yes";
				memoSheet.CellValue(memoRow, prefix +"iud_flag") = "I"; 
				
				//사용자가 입력한 값 저장 - 다시 불러올때 사용
				memoSheet.CellValue(memoRow, prefix +"hid_jo_shrt_leg_rmk_teu_qty") 	= joShrtLegRmkTeuQty;
				memoSheet.CellValue(memoRow, prefix +"hid_jo_shrt_leg_rmk_wgt") 		= joShrtLegRmkWgt;
				memoSheet.CellValue(memoRow, prefix +"hid_jo_shrt_leg_rmk_sctr_nm") 	= joShrtLegRmkSctrNm;
				memoSheet.CellValue(memoRow, prefix +"hid_rf_o") 						= joRfOcnQty;
				memoSheet.CellValue(memoRow, prefix +"hid_rf_i") 						= joRfIptQty;
				memoSheet.CellValue(memoRow, prefix +"hid_ak_jo_void_teu_qty") 			= joVoidTeuQty;
				
				//메모장 최초 호출 인지 체크하는 flag
				memoSheet.CellValue(memoRow, prefix +"memo_flag1") 			= "Y";
                ComHideMemoPad01(true);
            }
        } catch(err) {
            ComFuncErrMsg(err.message);
        }
    }

	/**
	 * 표시된 MemoPad를 강제로 닫을때 이 함수를 사용한다. <br>
     * @param {bool} 	bFocus	선택,닫은 후 처음열었던 IBSheet로 포커스를 설정할지 여부, default=false
     * @see #ComShowMemoPad
     * @return 없음<br>
	 */
	function ComHideMemoPad01(bFocus) {
		try {
			if (document.getElementById(MEMO_DIV_NAME) != null || memoSheet != null) {
				document.getElementById(MEMO_DIV_NAME).style.visibility = "hidden";
			}      
				var sheetObj = memoSheet;
				memoSheet = null;
		        if (bFocus) {
			        sheetObj.focus();	//포커스 하는 순간 이 함수가 또 호출되므로 sheetObj 변수로 다시 받았음
					sheetObj.SelectCell(memoRow, memoCol, false);
		        }
        } catch(err) { ; }
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//메모장2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     /**
      * 공통js의 ComShowMemoPad를 ReDefine
      */
	var MEMO_FRAME_NAME2 = "_iFrameMemo2_";
	var MEMO_DIV_NAME2 = "_DivMemo2_";
	var MEMO_TEXT_NAME2 = "_MemoText2_";
	var memoSheet=null, memoRow2, memoCol2;
	
    function Joo0087_02ShowMemoPad(sheetObj, row, col) {
        //함수의 인자 default 값 설정하기
        var iWidth = 308;
        var iHeight = 311;
        //전역변수에 값setting
        memoSheet = sheetObj;
        memoRow2 = row;
        memoCol2 = col;

        //메모를 위한 IBSheet 정보 받기
        if (!ComIsNumber(col)) ccolol = sheetObj.SaveNameCol(col);

        //메모패드 만들기
        if (!Joo0087_02initMemoPad()) return;

        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 1112;
        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row) + sheetObj.RowHeight(row) + 2;
        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.

        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
        if (top.document != document && window.frameElement.scrolling == "no") {
            //높이초과
            if (iTop + iHeight  > document.body.clientHeight) {
                iBottom = iTop + sheetObj.RowHeight(row) - (sheetObj.RowHeight(row) * 2);
                if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;
                iTop = iBottom-iHeight;
                if (iTop <0) iTop = 0
            }

            //넓이초과
            if (iLeft + iWidth  > document.body.clientWidth) {
                iLeft = document.body.clientWidth - iWidth;
                if (iLeft<0) iLeft = 0;
            }
        }

        var _frameDoc = document.getElementById(MEMO_FRAME_NAME2).contentWindow.document;
        _frameDoc.getElementById(MEMO_TEXT_NAME2).style.fontFamily  = sheetObj.SheetFontName;
        _frameDoc.getElementById(MEMO_TEXT_NAME2).style.fontSize  = 11;
        //_frameDoc.getElementById(MEMO_TEXT_NAME2).style.height = iHeight - 26;
        _frameDoc.getElementById(MEMO_TEXT_NAME2).style.height = iHeight - 60;		
        _frameDoc.getElementById(MEMO_TEXT_NAME2).readOnly = false;

        var _divMemo = document.getElementById(MEMO_DIV_NAME2);
        _divMemo.style.width = iWidth;
        _divMemo.style.height = iHeight;
        _divMemo.style.top = iTop;
        _divMemo.style.left = iLeft;
        _divMemo.style.visibility = "visible";
        _divMemo.focus();
        ComSetFocus(_frameDoc.getElementById("_amemoInput1_"));
		
			_frameDoc.getElementById("_MemoText2_").value = memoSheet.CellValue(row, prefix +"jo_aloc_adj_rmk");
		if (memoSheet.CellValue(row, prefix +"memo_flag2") == "Y") {	
			//메모장2 로드 시 그리드값 셋팅하기	(사용자가 입력한 값)		
			//_frameDoc.getElementById("_amemoInput1_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_alloc_teu")));
			//_frameDoc.getElementById("_amemoInput2_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"hid_alloc_wt")));
		} else {
			//메모장1 로드 시 그리드값 셋팅하기	(화면값 그대로)
			//_frameDoc.getElementById("_amemoInput1_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_aloc_adj_teu_qty")));
			//_frameDoc.getElementById("_amemoInput2_").value = parseInt(ComNullToZero(memoSheet.CellValue(row, prefix +"jo_aloc_adj_wgt")));			
		}
    }

    /**
     * 공통js의 initMemoPad를 ReDefine
     */
    function Joo0087_02initMemoPad() {
        //메모용 Div가 없으면 생성한다.
        if (document.getElementById(MEMO_DIV_NAME2) != null) return true;

        //메모용 Div 만들기
        var _divMemo=document.createElement("<div id='" + MEMO_DIV_NAME2 + "' style='position:absolute; visibility:hidden'/>");
        document.body.insertBefore(_divMemo);

        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        var _frameMemo = document.createElement("<iframe id='" + MEMO_FRAME_NAME2 + "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%'/>");
        _divMemo.appendChild(_frameMemo);

        var _frameDoc = _frameMemo.contentWindow.document;

        //iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _frameDiv = _frameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad02(true);' style='border:1.2px solid #aaa; padding:1px; background-color:#E6EFF6;'/>");
        _frameDoc.appendChild(_frameDiv);

        var _frameDiv2 = _frameDoc.createElement("<span style='padding:10px; height:1px; width:395px;'/>");
        _frameDiv.appendChild(_frameDiv2);
	 
		//var _frameP11 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        //_frameP11.innerText = "  ▷  TEU";
        //_frameDiv2.appendChild(_frameP11);
        //_frameDiv2.appendChild(_frameDoc.createElement("<input id='_amemoInput1_' tabindex='1' dataformat='float';' maxlength='5' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:50px'/>"));
        //var _frameP12 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        //_frameP12.innerText = "  ▷  WT";
        //_frameDiv2.appendChild(_frameP12);
        //_frameDiv2.appendChild(_frameDoc.createElement("<input id='_amemoInput2_' tabindex='2' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46&&event.keyCode!=110&&event.keyCode!=190)return false;' onfocusout='this.value=parent.ComAddComma2(this.value, \"#,###.00\");' maxlength='8' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:50px'/>"));
        //var _frameP13 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        
        var _frameP31 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP31.innerText = "  ▷  Remark";
        _frameDiv2.appendChild(_frameP31);
		
		 var _frameDiv1 = _frameDoc.createElement("<span style='height:75px; width:111px;'/>");
        //Div안에 Textarea 만들기
        _frameDiv2.appendChild(_frameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME2 + "' style='border:#7F9DB9 1px solid; color:#4f4f4f; height:72px; width:280px;	'/>"));

		
		var _centerTag = _frameDoc.createElement("<div style='height:20px; text-align:center; vertical-align:middle;'/>");
        //Apply 버튼 만들기
        var _button1 = _frameDoc.createElement("<span id='btn_apply' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.Joo0087_02SetMemoValue(document.getElementById(\"" + MEMO_TEXT_NAME2 + "\").value," + 4000 + ");'/>");
        _button1.innerText = "Apply";
        _centerTag.appendChild(_button1);
        //Close 버튼 만들기
        var _button2 = _frameDoc.createElement("<span id='btn_close' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.ComHideMemoPad02(true)'/>");
        _button2.innerText = "Close";
        _centerTag.appendChild(_button2);
        _frameDiv.appendChild(_centerTag);

        //메모용 iFrame 자동 닫기 처리
        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad02") < 0) {
            //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
            window.popupMemoOldEventListener = document.onmouseup;
            if (window.popupMemoOldEventListener != null) {
                //기존에 document.onmouseup에  정의된 함수가 있는 경우
                //document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad02();");
            } else {
                //기존에 document.onmouseup에  정의된 함수가 없는 경우
                document.onmouseup = ComHideMemoPad02;
            }

            //ActiveX에 포커스가 갔을때 메모DiV 닫기
            var objs = document.getElementsByTagName("OBJECT")
            window.popupMemoOldObjEventListener = new Array(objs.length);
            for(var i = 0 ; i < objs.length ; i++){
                window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
                if (window.popupMemoOldObjEventListener[i] != null) {
                    //기존에 document.onmouseup에  정의된 함수가 있는 경우
                    objs[i].onfocus = new Function("window.popupMemoOldObjEventListener[" + i + "](); ComHideMemoPad02();");
                } else {
                    //기존에 document.onmouseup에  정의된 함수가 없는 경우
                    objs[i].onfocus = ComHideMemoPad02;
                }
            }
        }
        return true;
    }


    /**
     * 공통js의 setMemoValue를 ReDefine
     */
    function Joo0087_02SetMemoValue(sValue, iMax) {
        try {
            if (sValue.length > iMax) {
                ComShowMessage("characters long");
                return;
            } else {
                if (memoSheet == null) return;

                var _frameDoc = document.getElementById(MEMO_FRAME_NAME2).contentWindow.document;
                if (!_frameDoc.getElementById(MEMO_TEXT_NAME2).readOnly) {
                    memoSheet.CellValue(memoRow2, memoCol2) = sValue;
                }
                var joShrtLegRmkTeuQty = ComNullToZero(_frameDoc.getElementById("_amemoInput1_").value.trim());
                var joShrtLegRmkWgt = ComNullToZero(_frameDoc.getElementById("_amemoInput2_").value.trim());
				var joAlocAdjRmk = _frameDoc.getElementById("_MemoText2_").value.trim();
				
				//memoSheet.CellValue(memoRow2, prefix +"over_long_teu") = parseInt(ComNullToZero(actuTeu.trim())) - parseInt(ComNullToZero(allocTeu.trim()));	  //화면에 보여주는값
				
				memoSheet.CellValue(memoRow2, prefix +"jo_aloc_adj_teu_qty") = joShrtLegRmkTeuQty;	//실제 저장되는값(TEU)
                memoSheet.CellValue(memoRow2, prefix +"jo_aloc_adj_wgt") = joShrtLegRmkWgt;			//실제 저장되는값(WT)
				memoSheet.CellValue(memoRow2, prefix +"jo_aloc_adj_rmk") = joAlocAdjRmk;			//실제 저장되는값(Rmark)
				memoSheet.CellValue(memoRow2, prefix +"jo_aloc_adj_rmk_yn") = "Yes";
				memoSheet.CellValue(memoRow2, prefix +"iud_flag") = "I";
				
				//사용자가 입력한 값 저장 - 다시 불러올때 사용
				memoSheet.CellValue(memoRow2, prefix +"hid_alloc_teu") = joShrtLegRmkTeuQty;
				memoSheet.CellValue(memoRow2, prefix +"hid_alloc_wt") = joShrtLegRmkWgt;
				
				//메모장 최초 호출 인지 체크하는 flag
				memoSheet.CellValue(memoRow, prefix +"memo_flag2") 			= "Y";				
                ComHideMemoPad02(true);
            }
        } catch(err) {
            ComFuncErrMsg(err.message);
        }
    }

	/**
	 * 표시된 MemoPad를 강제로 닫을때 이 함수를 사용한다. <br>
     * @param {bool} 	bFocus	선택,닫은 후 처음열었던 IBSheet로 포커스를 설정할지 여부, default=false
     * @see #ComShowMemoPad
     * @return 없음<br>
	 */
	function ComHideMemoPad02(bFocus) {
		try {
			if (document.getElementById(MEMO_DIV_NAME2) != null || memoSheet != null) {
				document.getElementById(MEMO_DIV_NAME2).style.visibility = "hidden";
			}	        
			var sheetObj = memoSheet;
			memoSheet = null;
			
	        if (bFocus) {
		        sheetObj.focus();	//포커스 하는 순간 이 함수가 또 호출되므로 sheetObj 변수로 다시 받았음
				sheetObj.SelectCell(memoRow2, memoCol2, false);
	        }			
        } catch(err) { ; }
	}
	
	function oprCdCombo_OnFocus(comboObj){
		var code =  document.form.rlane_cd.Code;
	
		oprCdCombo_clear();      	    	
	    oprCdCombo_Inquiry(document.form.oprCdCombo, code);
	}
	
	function rlane_cd_OnChange(comboObj, code, text){
		
		sheetObjects[0].RemoveAll();
		
	    
	}
	
	/* 개발자 작업  끝 */