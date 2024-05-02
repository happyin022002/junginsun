/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_DMT_3014.js
*@FileTitle : Approval for Charge Inactivation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2011.07.13 Kim Hyun Hwa
* 1.0 Creation
* 2012.09.04 김현화 [CHM-201219794-01]apro_ofc_cd, usr_ofc_cd를 로그인 office에서 User id 소속 Office로 변경함.
* 2013.04.01 임창빈 [ALPS 통합 로그] java.sql.SQLSyntaxErrorException: ORA-00936: missing expression
*            [원인] 사용자 Office Code가 DMT Office가 아닌 경우 로써, DMT Office Code를 Null로 조회시 발생하는 현상
*            [조치] 
*            1.조회시 필수 항목에 대한 Null 값을 확인하도록 로직 추가.
*            2.New 버튼 클릭시 DMT Office 정보로를 계속 추가하는 현상 제거.
*            3.Grid 내 데이터가 없는 상태에서 Delete 버튼 클리시 Server 호출 방지.
*            4.Request Period 정보 없이 조회시 확인 로직 추가.
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
     * @class EES_DMT_3014 : EES_DMT_3014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3014() {
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
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var ROWMARK     = "|";
 var FIELDMARK   = "=";
 
// var IBSEARCH_OFC    	 = 202;
 var IBSEARCH_TARIFF 	 = 203;
 var IBSEARCH_DELPROCSTS = 204;
 var IBSEARCH_DELTPATH   = 205;
 var IBSEARCH_INCSUBOFC  = 206;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         // var sheetObj1 = sheetObjects[1];
          /*******************************************************/
          var formObj = document.form;

     	try {
     	     var srcObj = window.event.srcElement;
      		 var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
			    case "btn_new":
//					sheetObjects[0].RemoveAll();
//				    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
				    doInit();

				break;
            	case "btns_calendar": //달력 버튼
            	if(srcObj.style.cursor == "hand") {
				     var cal = new ComCalendarFromTo();
					 cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
            	}	 
				break;
				
				case "btn_retrieve":
					doActionRetrieve();
				break;
				
				case "btn_approval":
					doActionApproval();
				break;

				case "btn_reject":
					doActionReject();
				break;
 
				case "btn_excel":
					doActionDownExcel();
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
  	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
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
	 	for(var k=0;k<comboObjects.length;k++){
	 		initCombo(comboObjects[k],k+1);
	 		
	 	}
	 	
	 	initControl();
 	
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_OFC);	 	//User Office Code 조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_TARIFF);		//Tariff
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_DELPROCSTS);	//DEL Process Status
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_DELTPATH);		//로그인 사용자의 승인권한단계 조회

		// DMT Office : 로그인 OFC 의 산하 점소 모두 조회되도록 수정함.
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

	    //사용자 Office 의 현재 날짜로 초기화한다.
	    initRequestPeriod();
		// 승인권한 여부에 따른 버튼 제어
		initBtnByAuth();
	    // 로그인 OFC 를 DMT Office 에 기본선택.
	    initSetDMTOffice();

	    var ofc = document.form.usr_ofc_cd.value;
	    var rhq = document.form.usr_rhq_ofc_cd.value;
	    if (ofc == 'HAMRUO' ||ofc == 'NYCRAO'||ofc == 'SINRSO'||ofc == 'SHARCO'){
	    	document.form.apro_ofc_cd.value = rhq ;
	    }
	}
	
	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
	    axon_event.addListenerForm  ('blur'     , 'obj_blur',   document.form ); //- 포커스 나갈때
	}
	
	/*
	 * 권한에 따른 Approval, Reject 버튼 상태제어
	 */
	function initBtnByAuth() {
		var formObj = document.form;
		
		if (ComGetObjValue(formObj.chg_delt_path_cd) != "") {
	        ComBtnEnable("btn_approval");
	        ComBtnEnable("btn_reject");
		}
		else {
			ComBtnDisable("btn_approval");
			ComBtnDisable("btn_reject");			
		}
	}
      
  	//업무 자바스크립트 OnKeyPress 이벤트 처리
   	function obj_keypress() {
       	 switch(event.srcElement.dataformat){
            	case "engup":
   		    	// 영문 소문자를 제외한 모든 문자
            		DmtComKeyOnlyAlphabet('upperall');
   		        break;
             	case "engup2":
    		    	// 영문대+숫자+예외문자
             		DmtComKeyOnlyAlphabet('uppernum', ',');
    		        break;
             	case "int":
        	        //숫자 만입력하기
        	        ComKeyOnlyNumber(event.srcElement);
        	        break;
             	default:
    	         	// 숫자만입력하기(정수,날짜,시간)
    	            ComKeyOnlyNumber(event.srcElement);
        	 }	        
       	 }

      
	function obj_blur(){
        // 입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        if ( ( obj.name == 'fm_dt' || obj.name == 'to_dt') 
       		 && document.form.fm_dt.value != "" && document.form.to_dt.value != ""  ) {
            ComChkObjValid(obj);
        }
	} 	

	
    function obj_focus(){
    	var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }

	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
		//doInit();
	}
	
	// 조회가 완료되면 Event가 발생한다.
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 2; i <= LastRow; i ++) {
    			
    			// 승인권한이 있는 Deletion 요청건만 활성화 시켜서, 선택가능하도록 해준다.
    			if (CellValue(i, "chg_delt_usr_yn") == "Y") {
    				RowEditable(i) = true;
    				
    				//승인권한단계를 설정한다.
    				CellValue2(i, "chg_delt_path_cd") = ComGetObjValue(document.form.chg_delt_path_cd);
    				RowStatus(i) = "R";
    			}
    			else {
    				RowEditable(i) = false;
    			}
				
				if (CellValue(i, "delt_spec_rsn_rmk_yn") == "Y") {
					CellFontUnderline(i, "delt_spec_rsn_rmk_yn") = true;
				}
		   }
    	}
	}	
	
	/**
   	 * Combo 기본 설정 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;

   	    switch(comboObj.id) {  
   	    	//DMT Office
   	    	case "dmt_ofc_cd": 
   	    		with (comboObj) { 
   	    			MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					
  					ValidChar(2, 2);	// 영어대문자 사용
   		    	}
   			break; 
   				
   	        //Tariff Type
            case "cboTariff":
                with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = true; 
                    SetColAlign("left|left");        
                    SetColWidth("55|330");
                    DropHeight = 160;
                    ValidChar(2,0);     //영문 대문자
                    IMEMode = 0;
                    MaxLength = 4;
                }
            break;  
            
   	        //DEL Process Status
            case "cboChgDelProcSts":
                with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = true; 
                    SetColAlign("left|left");        
                    SetColWidth("20|140");
                    DropHeight = 190;
                    ValidChar(2,0);     //영문 대문자
                    IMEMode = 0;
                    MaxLength = 4;
                }
            break;
   	     }
   	}
   	 
    // IBMultiCombo Office 초기화
//   	function initComboValue_dmt_ofc_cd() {
//    		comboObjects[0].Enable = true;
//    		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
//  	}
  
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 400;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 10, 100);

					var HeadTitle1 = "||Seq.|Inactive STS|STS|BKG No.|VVD CD|Cntr No.|T/S|Office|Inactive Request|Inactive Request|Inactive Request|Inactive Request|Inactive Request|Inactive Request|From YD|To YD|Fm|To|Tariff|F/T|Over|From Dt|To Dt|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|G/B|SOC|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No|ISS DT|INV CUR|Billing AMT|A/R";
					var HeadTitle2 = "||Seq.|Inactive STS|STS|BKG No.|VVD CD|Cntr No.|T/S|Office|User|Office|Date|Reason|Specific Reason|Detail Reason|From YD|To YD|Fm|To|Tariff|F/T|Over|From Dt|To Dt|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|G/B|SOC|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No|ISS DT|INV CUR|Billing AMT|A/R";

					var hiddenCount = 11;
					var headCount = ComCountHeadTitle(HeadTitle1) + hiddenCount;
					
					
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);
            
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);    

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ ,  dtHiddenStatus, 30,	daCenter,	true,	"ibflag");
				//	InitDataProperty(0, cnt++ ,  dtRadioCheck,	 30,	daCenter,	true,	"chk",					false,	"",	dfNone,      0,	true,	true);
                    InitDataProperty(0, cnt++,   dtDummyCheck, 	 30,	daCenter, 	true,	"chk",                  		false,	"",	dfNone,      0,	true,	true);
					InitDataProperty(0, cnt++ ,  dtSeq,			 30,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ ,  dtData,		 90,	daCenter,	true,	"chg_delt_proc_sts",    		false,	"",	dfNone,      0,	false,	false);
					InitDataProperty(0, cnt++ ,  dtData,		 30,	daCenter,	true,	"dmdt_chg_sts_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 85,	daLeft,	    true,	"bkg_no",						false,  "",	dfNone,	     0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,	    true,	"vvd_cd",						false,  "",	dfNone,	     0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtData,		 85,	daLeft,		true,	"cntr_no",	            		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"cntr_tpsz_cd",       			false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daLeft,		true,	"ofc_cd",	            		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daLeft,		true,	"rqst_usr_id",	        		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daLeft,		true,	"rqst_ofc_cd",	        		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"rqst_dt",	            		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"dmdt_chg_delt_rsn_cd",			false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 100,	daCenter,	true,	"dmdt_chg_delt_spec_rsn_cd",	false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 90,	daCenter,	true,	"delt_spec_rsn_rmk_yn",			false,	"",	dfNone,      0,	false,	false);					
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"fm_mvmt_yd_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"to_mvmt_yd_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"fm_mvmt_sts_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"to_mvmt_sts_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,  	daCenter,	true,	"dmdt_trf_cd",	        		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daRight,	true,	"ft_dys",	            		false,	"",	dfInteger,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daRight,	true,	"fx_ft_ovr_dys",	    		false,	"",	dfInteger,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"fm_mvmt_dt",	        		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"to_mvmt_dt",	        		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"ft_cmnc_dt",	        		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"ft_end_dt",	        		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"bzc_trf_curr_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daRight,	true,	"org_chg_amt",	        		false,	"",	dfNullFloat, 0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daRight,	true,	"sc_rfa_expt_amt",	    		false,	"",	dfNullFloat, 0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daRight,	true,	"aft_expt_dc_amt",	    		false,	"",	dfNullFloat, 0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daRight,	true,	"bil_amt",	            		false,	"",	dfNullFloat, 0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daLeft,		true,	"gen_bal",	            		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"soc_flg",	            		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"li",	                		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"ch",	                		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"d_o",	                		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"rlse_ofc",          			false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"clt_ofc_cd",          			false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"ofc_trns_flg",        			false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 50,	daCenter,	true,	"roll_ovr",	            		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 70,	daCenter,	true,	"dmdt_inv_no",	        		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 65,	daLeft,		true,	"iss_dt",	            		false,	"",	dfDateYmd,   0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 60,	daCenter,	true,	"inv_curr_cd",	        		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 80,	daRight,	true,	"cntr_inv_amt",	        		false,	"",	dfNullFloat, 0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtData,		 20,	daCenter,	true,	"dmdt_ar_if_cd",	    		false,	"",	dfNone,      0,	false,	true);
					InitDataProperty(0, cnt++ ,  dtHidden,		 0,  	daLeft,		true,	"svr_id",	            		false,	"",	dfNone,      0,	false,	false);
					InitDataProperty(0, cnt++ ,  dtHidden,		 0,	    daLeft,		true,	"cntr_cyc_no",	        		false,	"",	dfNone,      0,	false,	false);
					InitDataProperty(0, cnt++ ,  dtHidden,		 0,	    daLeft,		true,	"dmdt_chg_loc_div_cd",			false,	"",	dfNone,      0,	false,	false);
					InitDataProperty(0, cnt++ ,  dtHidden,		 0,		daCenter,	true,	"chg_seq",						false,  "",	dfNone,	     0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"delt_seq",						false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"corr_rmk",						false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"delt_rsn_desc",    			false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"chg_delt_usr_yn",    			false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"chg_delt_path_cd",    			false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"chg_delt_sts_cd",    			false,	"",	dfNone,      0,	false,  false);
					InitDataProperty(0, cnt++ ,  dtHidden,       0,		daCenter,	true,	"delt_spec_rsn_rmk_seq",  		false,	"",	dfNone,      0,	false,  false);
					
		            ToolTipOption = "balloon:true; width:600; backcolor:#ffffff; forecolor:#14358B; icon:0; title:";
		            
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("rqst_usr_id");		            
             }
                 break;
         
         } // switch end
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
    	 
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
//	         case IBSEARCH_OFC:      //user ofc 조회	
//	        	 	//1.조회조건 설정
//			        ComSetObjValue(formObj.f_cmd, SEARCH22); 
//				
//	                //2.조회조건으로 조회실행			        
//				 	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
//
//					//3.조회후 결과처리
//					var usrid_ofc = ComGetEtcData(sXml, "OFC_CD");
//			
//					ComSetObjValue(formObj.apro_ofc_cd, usrid_ofc);
//					ComSetObjValue(formObj.usr_ofc_cd, usrid_ofc);
//			 break;
					
	         case IBSEARCH_TARIFF:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCHLIST); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 comboItems = ComGetEtcData(sXml, "common_tariff_cd").split(ROWMARK);
	        	 addComboItem(comboObjects[1], comboItems);
	         break;
	         
	         case IBSEARCH_DELPROCSTS:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCH03); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 comboItems = ComGetEtcData(sXml, "chg_delt_proc_sts").split(ROWMARK);
	        	 addComboItem(comboObjects[2], comboItems);
	         break;
					
	         case IBSEARCH_DELTPATH:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCH04); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	        	 
	        	 //3.조회후 결과처리
	        	 ComSetObjValue(formObj.chg_delt_path_cd, ComGetEtcData(sXml, "CHG_DELT_PATH_CD"));
	         break;
	         
	         case IBSEARCH_ASYNC01:      //조회	
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, COMMAND22); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 comboItems = ComGetEtcData(sXml, "OFC_CD").split(ROWMARK);
	        	 addComboItem(comboObjects[0], comboItems);
		     break;
				
             case IBSEARCH:      //조회
        	   //0.입력조회조건 유효성 체크
        	   if (!validateForm(sheetObj,formObj,sAction)) return;
        	   
        	   //1.조회조건 설정
        	   ComSetObjValue(formObj.f_cmd, 			 SEARCH02);
        	   ComSetObjValue(formObj.dmdt_trf_cd,		 comboObjects[1].Code)	// Tariff Type
        	   ComSetObjValue(formObj.chg_delt_proc_sts, comboObjects[2].Code)	// DEL Process Status
            	
        	   var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(""));
        	   var arrXml = sXml.split("|$$|");
				
        	   sheetObjects[0].LoadSearchXml(arrXml[0], false);
             break;

             case IBSAVE:        //저장 (Approval, Reject)
          		// 입력값에 대한 Validation Check
          		if (!validateForm(sheetObj, formObj, sAction)) return;
          		
         	   //1. 저장조건 설정          		
          		ComSetObjValue(formObj.f_cmd, MULTI01);

		       	//2.저장실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************		       	
            	var sXml = sheetObj.GetSaveXml("EES_DMT_3014GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, "chk"), "sheet1_"));
				sheetObj.LoadSaveXml(sXml);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.저장 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {				
					// 자동조회 실행
					doActionRetrieve();
				}
		     break;
		     
             case IBSEARCH_INCSUBOFC:	// Include Sub Office
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, COMMAND01); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));            	 
            	 
	        	 //3.조회후 결과처리            	 
	        	 var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	        	 if (subOfcCds != undefined && subOfcCds != '') {
	        		// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
	        		var arrOfcCd = subOfcCds.split(',');
	        		var str = '';
	        		for (var i=0; i<arrOfcCd.length; i++) {
	        			var idx = comboObjects[0].FindIndex(arrOfcCd[i], 0);
	        			if (idx != -1)
	        				str = str + ',' + arrOfcCd[i];
	        		}
	        		str = str.substring(1);
	        		
	        		// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
	        		var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	        		if(comboObjects[0].Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
	        			str = usrOfcCd + ',' + str;
	        		}
	        		comboObjects[0].Code = str;
	        	 }
             break;
         }
     }

 	function doInit() {
		var formObj = document.form;
		with (formObj) {

    		sheetObjects[0].RemoveAll();
    		ComSetObjValue(formObj.bkg_no,   "");

			//사용자 Office 의 현재 날짜로 초기화한다.
			initRequestPeriod();
    		// Tariff Type
    		comboObjects[1].Code = -1;
    		// DEL Process Status
    		comboObjects[2].Code = -1;
       		// 승인권한 여부에 따른 버튼 제어
    		initBtnByAuth();
    	    // 로그인 OFC 를 DMT Office 에 기본선택.
    	    initSetDMTOffice();    		
		}
	}  
   
 	/*
 	 * Retrieve 버튼 클릭시 이벤트 처리
 	 */
 	function doActionRetrieve() {
 		var formObj = document.form;
 		
 		// Retrieve 실행
 		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 	}
 	
 	/*
 	 * Approval 버튼 클릭시 이벤트 처리
 	 */
 	function doActionApproval() {
 		var formObj = document.form;
 		
  		// DMT00135 : Do you want to {?msg1}?
  		if (!ComShowCodeConfirm("DMT00135", "Approval")) return;
  		
 		// Approval 실행
  		setChgDeltStsCd("A");	// Approval
 		doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 	}
 	
 	/*
 	 * Reject 버튼 클릭시 이벤트 처리
 	 */ 	
 	function doActionReject() {
 		var formObj = document.form;
 		
  		// DMT00135 : Do you want to {?msg1}?
  		if (!ComShowCodeConfirm("DMT00135", "Reject")) return;
  		
 		// Reject 실행
  		setChgDeltStsCd("J");	// Reject
 		doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
 	}
 	
 	/*
 	 * Down Excel 버튼 클릭시 이벤트 처리
 	 */
 	function doActionDownExcel() {
 		sheetObjects[0].SpeedDown2Excel(-1);
 	}
 	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj, formObj, sAction){
         with(formObj) {
        	 switch(sAction) {
	         	case IBSEARCH:
		        	 
					if(ComGetLenByByte(ComGetObjValue(formObj.dmt_ofc_cd)) < 3) {
						ComShowCodeMessage('COM12113', 'DMT Office.');
						ComSetFocus(formObj.dmt_ofc_cd);
	 					return false;
					}
		        	
					if(ComGetLenByByte(ComGetObjValue(formObj.fm_dt)) < 8) {
						ComShowCodeMessage('COM12132');
						ComSetFocus(formObj.fm_dt);
	 					return false;
					}
					
					if(ComGetLenByByte(ComGetObjValue(formObj.to_dt)) < 8) {
						ComShowCodeMessage('COM12132');
						ComSetFocus(formObj.to_dt);
	 					return false;
					}
					
					break;
					
		         case IBSAVE:
		        	var sheetObj1 = sheetObjects[0];
		        	var chkRow = sheetObj1.FindCheckedRow("chk");

					if(chkRow == "") {
						ComShowCodeMessage('DMT00009');
						return false;
					}

					break;
					
		         case IBDELETE:
		        	var sheetObj1 = sheetObjects[0];
		        	var chkRow = sheetObj1.FindCheckedRow("chk");

					if(chkRow == "") {
						ComShowCodeMessage('DMT00009');
						return false;
					}

		        	 break;
					
        	 } // switch end
         } // with end
        	 
         return true;
     }
     
   	/*
   	 * 각 공통팝업창 호출 함수 
   	 */
   	function openPopup(flag, arg) {
   		
   		var sheetObj = sheetObjects[0];
   		var formObj	= document.form;
   		var sUrl	= '';
   		var sWidth	= '';
   		var sHeight	= '';
   		var paramVal = '';
   		var sScroll = 'no';
   		
   		with(sheetObj) {
 	  		switch(flag) {
 	  
 	  			case 'bkg_no':		// BKG No. 멀티입력 팝업 호출
 	
 	  				// 멀티입력 팝업 타이틀 세부 내용 지정
 	  				var returntitle = '';
 	  				if(flag == 'bkg_no')
 	  					returntitle = 'BKG No.';
 	 	  				
 	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
 	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
 				break;
 					
 				case 'chg_inq':		// Charge Inquiry by Cntr 팝업 호출
	 				var chkRow = SelectRow;
					sUrl = "EES_DMT_3006P.do";
	    			
		  			var svrId 		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			paramVal		= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
	
	  				sUrl	= sUrl + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '630';
	 		  		if(sUrl != '') {
	 		  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
	 		  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
			  		}				
				break;
				
 				case 'delt_spec_rsn_rmk':
					//sUrl = "EES_DMT_7019P.do";
 					sUrl = "EES_DMT_3104.do";
	    			
		  			var svrId 		= CellValue(SelectRow , "svr_id");
		  			var cntrNo		= CellValue(SelectRow , "cntr_no");
		  			var cntrCycNo	= CellValue(SelectRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(SelectRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(SelectRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(SelectRow , "chg_seq");
		  			var chgOfcCd    = CellValue(SelectRow , "ofc_cd");
		  			var deltSeq     = CellValue(SelectRow , "delt_seq");
		  			
		  			var paramVal    = "?";
		  			paramVal += "sys_area_grp_id="      + svrId;
		  			paramVal += "&cntr_no="             + cntrNo;
		  			paramVal += "&cntr_cyc_no="         + cntrCycNo;
		  			paramVal += "&dmdt_trf_cd="         + trfCd;
		  			paramVal += "&dmdt_chg_loc_div_cd=" + chgLocDivCd;
		  			paramVal += "&chg_seq="             + chgSeq;
		  			paramVal += "&chg_ofc_cd="          + chgOfcCd;
		  			paramVal += "&delt_seq="            + deltSeq;
		  			paramVal += "&prnt_mnu_id="         + "EES_DMT_3014";
		  			if ( CellValue(SelectRow , "chg_delt_usr_yn") != "Y" ){
		  				paramVal += "&save_flg="            + "N";
		  			} else {
		  				paramVal += "&save_flg="            + "A";
		  			}
		  			
	  				sUrl	= sUrl + paramVal;
	          		//sWidth	= "380";
	          		//sHeight	= "265";
              		sWidth	= '770';
              		sHeight	= '720';   	  				

// 		  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
 		  			//ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
// 		  			ComOpenPopup(sUrl, sWidth, sHeight, "", "1,0,1,1,1,1,1", false);

 		  	  		if(sUrl != '') {
 		  	  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
 		  	  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, 'no');
 		  	  			
 		  	  			if(returnValue == "Y") {
 		  	 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
 		  	 			}
 		  	  		}
 				break;
 	
 	  		} // switch - end
   		} // with(sheetObj) - end
   	}
   	
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
     
	/** OnMouseMove 이벤트 발생시 호출  */ 
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;   
		var sText = "";
        //풍선도움말 만들기
		//var sText = sheetObj.CellText(Row,Col);
		if (Col=="12"){
			sText =  sheetObj.CellText(Row,"corr_rmk");

		}else{
     		sText= "";
		}
		
		if(sText != "") {
			sheetObj.MouseToolTipText = sText;
		}else{
			sheetObj.MouseToolTipText = "";
		}
			
	}
	
    /**	 
	 * 클릭한 경우, 첨부파일 다운로드 페이지 팝업.
	 */		 
	function sheet1_OnClick(sheetObj, Row, Col) {
		
		with(sheetObj) {
			
			switch (ColSaveName(Col)) {
				case "delt_spec_rsn_rmk_yn":
					if (CellValue(Row, Col) == "Y") {
						// 권한체크 (승인및거절 권한이 있는 사용자만 파일다운로드를 실행할 수 있다.)
//						if (CellValue(Row, "chg_delt_usr_yn") == "Y") {
							openPopup('delt_spec_rsn_rmk');
//						}
//						else {
//							//DMT01145 : 'You have no authority to {?msg1}!';
//							ComShowCodeMessage("DMT01145", "view the detail reason");
//							return;
//						}
					}					
				break;
			}
		}
	}	
	
    /**	 
	 * 더블클릭한 경우 Charge Inquiry by Cntr 팝업.
	 */		 
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		openPopup('chg_inq');
	}	
	
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);        
        }           
    }	
	/**
	 * 로그인 OFC 를 DMT Office 에 기본선택해준다.
	 */ 	
    function initRequestPeriod() {
		var formObj = document.form;
		
		//사용자 Office 의 현재 날짜를 조회한다.
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj); 
		//조회한 날짜를 화면의 필드에 매핑 시킨다.
		ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //1개월 이전 날짜.
		ComSetObjValue(formObj.to_dt,   ofcCurrDate);  //오늘 날짜.    	
    }
	/**
	 * 로그인 OFC 를 DMT Office 에 기본선택해준다.
	 */
	function initSetDMTOffice() {
		var formObj = document.form;
		
	    // 로그인 OFC 를 DMT Office 에 기본선택해준다.
	    formObj.dmt_ofc_cd.Code = ComGetObjValue(formObj.usr_ofc_cd);
	}
	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[0];
		
		if (formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if (ComIsEmpty(comboObj.Code)) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			
			var ofcCd = replaceOfficeCode(ComGetObjValue(comboObj));
			
			ComSetObjValue(formObj.ofc_cd,     ofcCd);
			ComSetObjValue(formObj.tmp_ofc_cd, ComGetObjValue(comboObj));
			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_INCSUBOFC);
			
		}
		else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}	
	
	// 특정 Office 일 경우 변환해주는 함수
	//NYCRAO – NYCRA, HAMRUO – HAMRU, SHARCO – SHARC, SINRSO – SINRS
	function replaceOfficeCode(ofcCd) {
		
		var arrOfcCd1 = Array();
		arrOfcCd1[0] = "NYCRAO";
		arrOfcCd1[1] = "HAMRUO";
		arrOfcCd1[2] = "SHARCO";
		arrOfcCd1[3] = "SINRSO";
		
		var arrOfcCd2 = Array();
		arrOfcCd2[0] = "NYCRA";
		arrOfcCd2[1] = "HAMRU";
		arrOfcCd2[2] = "SHARC";
		arrOfcCd2[3] = "SINRS";
		
		for (var i=0; i<arrOfcCd1.length; i++) {
			if (ofcCd.indexOf(arrOfcCd1[i]) != -1) {
				ofcCd = ofcCd.replace(arrOfcCd1[i], arrOfcCd2[i]);
			}
		}

		return ofcCd;
	}
	
	// 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
 	function dmt_ofc_cd_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;

   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}	
 	
 	/*
 	 * 조회결과에서 선택된 행에 주어진 값을 설정한다.
 	 */  	
 	function setChgDeltStsCd(chgDeltStsCd) {

 		with(sheetObjects[0]) {
	 		var chkRow = FindCheckedRow("chk");
	 		if (chkRow != "") {
	 			  //가져온 행을 배열로 반든다.
	 			  var arrRow = chkRow.split("|");
	 			  for (idx=0; idx<arrRow.length-1; idx++) { 
	 				  CellValue2(arrRow[idx], "chg_delt_sts_cd") = chgDeltStsCd;
	 			  }
	 		}
 		}
 	} 	
 	
	/* 개발자 작업  끝 */