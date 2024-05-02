/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0018.js
*@FileTitle : Owner’s Account
*@LastModifyDate : 2012.06.12
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2009.04.28 정윤태
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 2011.03.18 유재민 [CHM-201109295-01] Location 조회불가건 수정 보완 요청 
* 2012.06.12 전상화 [CHM-201218274] Owner's Account 총액 기능 개발 
* 2013.01.23 이수진 [CHM-201322477] OWNERS ACCOUNT 접수확인 항목 개발 요청 (조건항목에 Receipt 항목 추가)
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
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
     * @class Ship Yard Select – Pop up : Ship Yard Select – Pop up 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0018() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet_OnLoadFinish		= sheet_OnLoadFinish;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl			= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.checkVvdCode			= checkVvdCode;
    	this.checkApDesc			= checkApDesc;
    	this.checkCell				= checkCell;
    	this.validateForm 			= validateForm;
    	this.setVslCd				= setVslCd;
    	this.setLocCd				= setLocCd;
    	this.initConfirm			= initConfirm;
    	this.setImageButton			= setImageButton;
    	this.sheet_OnSearchEnd		= sheet_OnSearchEnd;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.setPlusSum				= setPlusSum;
    	this.setMinusSum			= setMinusSum;
    	this.sheet_OnChange			= sheet_OnChange;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.sheet_OnClick			= sheet_OnClick;
    	this.sheet1_OnClick			= sheet1_OnClick;
    	this.sheet_OnMouseMove		= sheet_OnMouseMove;
    	this.sheet_OnBeforeEdit		= sheet_OnBeforeEdit;
    	this.sheet_OnAfterEdit		= sheet_OnAfterEdit;
    	this.sheet1_OnBeforeEdit	= sheet1_OnBeforeEdit;
    	this.sheet1_OnAfterEdit		= sheet1_OnAfterEdit;
    	this.setCellEditable		= setCellEditable;
    	this.speedDown2Excel		= speedDown2Excel;
    	this.setCellEditable2		= setCellEditable2;
    	this.obj_activate			= obj_activate;
    }
    
    /* 개발자 작업	*/

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

	var amountSum_Owner_01 =0;
	var amountSum_Local_01 =0;

	  		
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
		            if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
			 		break;
			 		
            	case "btn_autoFilter":
		            if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH, "autoFilter");
			 		break;
			 		
    			case "btn_new":
    				if(!initConfirm()) return;
    		 		ComResetAll();
                    break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

    			case "btn_saveToFile":
    				if(!initConfirm()) return;
    				
    				if(sheetObjects[0].RowCount == 0) {
    		 			ComShowCodeMessage("FMS00016");
    		 			return;
    		 		}
    				
    				sheetObjects[0].ColHidden("apply") = true;
    				
    				sheetObjects[0].SpeedDown2Excel(-1);
    				sheetObjects[1].SpeedDown2Excel(-1);
    				
    				sheetObjects[0].ColHidden("apply") = false;
    				
    				//speedDown2Excel(sheetObject, 1);
    				//speedDown2Excel(sheetObject1, 2);
                    break;
                    
    			case "btn_effDt1":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.eff_dt1, 'yyyy-MM-dd');
                    break;
                    
    			case "btn_effDt2":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.eff_dt2, 'yyyy-MM-dd');
                    break;
                    
    			case "btn_vslPop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0022");
					break;
					
    			case "btn_locPop":
    				ComOpenPopup("COM_ENS_051.do", 720, 430, "setLocCd", "1,0,1,1,1", false, false, null, null, null, "com_ens_051");
					break;
					
    			case "btn_vslCdClr":
     				form.vsl_cd.value = "";
     				form.vsl_eng_nm.value = "";
     				break;
     				
     			case "btn_locCdClr":
     				form.loc_cd.value = "";
     				form.loc_nm.value = "";
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
        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        sheetObjects[0].ExtendLastCol = false;
        sheetObjects[1].ExtendLastCol = false;
        
    	initControl();
    }
     
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet_OnLoadFinish(sheetObj) { 
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
		
		sheetObj.WaitImageVisible = true;   
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) { 
    	sheetObj.WaitImageVisible = false;
    	
        doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
		
		sheetObj.WaitImageVisible = true;   
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

    				// 높이 설정
                    style.height = 280;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone] // msPrevColumnMerge + msHeaderOnly
                    MergeSheet =  msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, true, false, true, false,false)
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "|Seq|Match|Type|VVD Cd|USD|Amount|LCL|Amount|Original Slip No.|Description|Eff. date|Ex. Rate|Acct code|Cntr code|Approval|Manhour|Apply|Receipt||||||||||";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    cnt = 0;
                    InitDataProperty(0, cnt++, dtStatus,	30,    daCenter,  	true,	"ibflag");
//                    InitDataProperty(0, cnt++, dtHiddenStatus,	30,    daCenter,  	true,	"ibflag");
                    InitDataProperty(0, cnt++, dtSeq,			30,    daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++, dtCheckBox,     	45,    daCenter,  	true,   "stl_flg");
                    InitDataProperty(0, cnt++, dtCombo,      	89,    daCenter,  	false,  "flet_ppay_rlt_cd",     false,	"",	dfNone);
                    InitDataProperty(0, cnt++, dtData,      	83,    daCenter,  	false,  "vvd_cd",     			true,  	"",	dfEngUpKey,	0, true, true, 	 10);
                    InitDataProperty(0, cnt++, dtData,      	40,    daCenter,  	false,  "n1st_curr_cd",     	false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	89,    daRight,  	true,  	"n1st_amt",     		false,  "",	dfFloat,   	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	40,    daCenter,  	false,	"n2nd_curr_cd",     	false,	"",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	89,    daRight,  	false,  "n2nd_amt",     		false,  "",	dfFloat,	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	170,   daCenter,  	false,  "org_slp_no",     		false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	215,   daLeft,  	false,  "ap_desc",     			true,	"",	dfNone,		0, true, true, 250);
                    InitDataProperty(0, cnt++, dtData,      	75,    daCenter,  	false,  "eff_dt",    			false,  "",	dfDateYmd,	0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	52,    daRight,  	false,  "act_xch_rt_amt",     	false,  "",	dfFloat,	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	70,    daCenter,  	false,  "acct_cd",     			false,  "", dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	70,    daCenter,  	false,	"ctr_cd",     			false,	"",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	60,    daCenter,  	false,  "apro_flg",     		false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	60,    daCenter,  	false,	"man_hr_flg",     		false,	"",	dfNone,	   	0, false, false);
                    InitDataProperty(0, cnt++, dtImage,     	66,    daCenter,  	true,   "apply",  				false,  "",	dfNone,	   	0, false, false);
                    InitDataProperty(0, cnt++, dtCombo,     	66,    daCenter,  	true,   "flet_rct_flg",  		false,  "",	dfNone,	   	0, true, true);
                                        
                    // ---------------------------------------------------------------------
                    InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_tp_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_func_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_team_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_iss_dt",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_ser_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_seq_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"vsl_cd",     			false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"skd_voy_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"skd_dir_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"rev_dir_cd",     		false,	"",	dfNone,		0, false, false);
    	    		// ---------------------------------------------------------------------
	                
      	    		ImageList(0) = "img/btn_apply.gif";
    	    		
    				SetSortDialog(false);
    				InitDataValid(0, "vvd_cd", vtEngUpOther, "0123456789");
    				InitDataCombo(0, "flet_rct_flg", "Y|N", "Y|N");
               	}
    			break;

    		case 2:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone] // msPrevColumnMerge + msHeaderOnly
                    MergeSheet =  msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, true, false, true, false,false)
                    InitHeadMode(true, true, false, true, false, false);
                    
                    var HeadTitle = "|Seq|Match|Type|VVD Cd|USD|Amount|LCL|Amount|Original Slip No.|Description|Eff. date|Ex. Rate|Acct code|Cntr code|Approval|Manhour|Receipt||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    cnt = 0;
                    InitDataProperty(0, cnt++, dtHiddenStatus,	30,    daCenter,  	true,	"ibflag");
                    InitDataProperty(0, cnt++, dtSeq,			30,    daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++, dtCheckBox,     	45,    daCenter,  	true,   "stl_flg");
                    InitDataProperty(0, cnt++, dtCombo,      	89,    daCenter,  	false,  "flet_ppay_rlt_cd",     false,	"",	dfNone);
                    InitDataProperty(0, cnt++, dtData,      	83,    daCenter,  	false,  "vvd_cd",     			true,  	"",	dfEngUpKey,	0, true, true, 	 10);
                    InitDataProperty(0, cnt++, dtData,      	40,    daCenter,  	false,  "n1st_curr_cd",     	false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	89,    daRight,  	true,  	"n1st_amt",     		false,  "",	dfFloat,   	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	40,    daCenter,  	false,	"n2nd_curr_cd",     	false,	"",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	89,    daRight,  	false,  "n2nd_amt",     		false,  "",	dfFloat,	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	170,   daCenter,  	false,  "org_slp_no",     		false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	215,   daLeft,  	false,  "ap_desc",     			true,	"",	dfNone,		0, true,  true, 250);
                    InitDataProperty(0, cnt++, dtData,      	75,    daCenter,  	false,  "eff_dt",    			false,  "",	dfDateYmd,	0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	52,    daRight,  	false,  "act_xch_rt_amt",     	false,  "",	dfFloat,	2, false, false);
                    InitDataProperty(0, cnt++, dtData,      	70,    daCenter,  	false,  "acct_cd",     			false,  "", dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	70,    daCenter,  	false,	"ctr_cd",     			false,	"",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	60,    daCenter,  	false,  "apro_flg",     		false,  "",	dfNone,		0, false, false);
                    InitDataProperty(0, cnt++, dtData,      	60,    daCenter,  	false,	"man_hr_flg",     		false,	"",	dfNone,	   	0, false, false);
                    InitDataProperty(0, cnt++, dtCombo,     	66,    daCenter,  	true,   "flet_rct_flg",  		false,  "",	dfNone,	   	0, true, true);
                    
                    // ---------------------------------------------------------------------
                    InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_tp_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_func_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_team_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_iss_dt",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_ser_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"slp_seq_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"vsl_cd",     			false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"skd_voy_no",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"skd_dir_cd",     		false,	"",	dfNone,		0, false, false);
    	    		InitDataProperty(0, cnt++, dtHidden,      	30,    daCenter,  	false,	"rev_dir_cd",     		false,	"",	dfNone,		0, false, false);
    	    		// ---------------------------------------------------------------------
	                
	                SetSortDialog(false);
                    InitDataValid(0, "vvd_cd", vtEngUpOther, "0123456789");
                    InitDataCombo(0, "flet_rct_flg", "Y|N", "Y|N");
               }
               break;
        }
    }

    /**
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 	 **/
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "-";
 	
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
 		axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
 		
 		//2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'engnum_keypress', 'loc_cd'); //loc_cd는 engnum_press로
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); // Vessel Code 입력 시 영문 대문자/숫자만 입력하기
        
 		axon_event.addListenerForm  ('keypress'        , 'eng_keypress'  , form); 	//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
 		axon_event.addListenerForm  ('change'          , 'obj_change'    , form); 	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
 		axon_event.addListenerFormat('focus'           , 'obj_activate'  , form);
 	}

    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm,row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      // 조회
        		if(objNm == "vsl_cd") {
        			formObj.f_cmd.value = SEARCH01;
    	    		
    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");

    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vsl_eng_nm.value = vslEngNm;
    	   				form.btn_vslCdClr.checked = true;
    				} else {
    					form.btn_vslCdClr.checked = false;
    					formObj.vsl_cd.value = "";
    					// 존재하지 않는 Vessel Code입니다
    					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
    	   			
        		} else if(objNm == "loc_cd") {
        			formObj.f_cmd.value = SEARCH03;

    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var locNm = ComGetEtcData(sXml, "locNm");
    	   			
    	   			if(typeof locNm != "undefined" && locNm != "" ) {
    	   				formObj.loc_nm.value = locNm;
    	   				form.btn_locCdClr.checked = true;
    				} else {
    					form.btn_locCdClr.checked = false;
    					formObj.loc_cd.value = "";
    					// 존재하지 않는 Location Code입니다
    					ComAlertFocus(formObj.loc_cd, ComGetMsg("FMS00006", "KK Code"));
    					return;
    				}
    	   			
        		} else {
        			if(validateForm(sheetObj,formObj,sAction,objNm)) {
        				if(objNm == "autoFilter") {
        					formObj.f_cmd.value = SEARCH01;
        					formObj.searchType.value = "A";
        				} else {
        					formObj.f_cmd.value = SEARCH;
        					formObj.searchType.value = "S";
        				}
    			       	 
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0018GS.do", FormQueryString(formObj));
	       	   	  		var arrXml = sXml.split("|$$|");
	       	   	  		
	       	   	  		if (arrXml.length > 0) { 
	       	   	  			sheetObjects[0].LoadSearchXml(arrXml[0]);
	       	   	  	         amountSum_Owner_01 =0;
						 	  for(var i=1; i<=sheetObjects[0].LastRow; i++) {
			       	   		  amountSum_Owner_01  +=  parseFloat(sheetObjects[0].CellValue(i,"n1st_amt"));			       	  
				       	   	}	
	       	   	  		}
	       	   	  		
	       	   	  		if (arrXml.length > 1) {
	       	   	  			sheetObjects[1].LoadSearchXml(arrXml[1]);
	       	   	  		} else {
	       	   	  			sheetObjects[1].LoadSearchXml(arrXml[0]);
	       	   	  		}  
	       	   	              amountSum_Local_01=0;
		       	   	  		for(var i=1; i<=sheetObjects[1].LastRow; i++) {
				       	   	   amountSum_Local_01  += parseFloat(sheetObjects[1].CellValue(i,"n1st_amt"));
				       	   	}
		             	
			       	setCellEditable(sheetObjects[0]);
       	   	  		setCellEditable(sheetObjects[1]);
       	   	  	
       	   	  		
        			}
        			
        			 form.amountSum_Owner_01.value = ComAddComma(amountSum_Owner_01.toFixed(2));
		          	 form.amountSum_Local_01.value=  ComAddComma(amountSum_Local_01.toFixed(2));
		             	 
        		}
        		break;

        	case IBSAVE:        // 저장
	        	if(validateForm(sheetObj,formObj,sAction)) {
		        	formObj.f_cmd.value = MULTI;
	        	
			  	  	var sParam = "";
			  	  	var sParamSheet1 = sheetObjects[0].GetSaveString();
			  	  	var sParamSheet2 = sheetObjects[1].GetSaveString();
				  	sParam += FormQueryString(formObj) + "&" + sParamSheet1 + "&" + sParamSheet2;
				  	
				  	var sXml = sheetObj.GetSaveXml("ESM_FMS_0018GS.do", sParam);
				  	var arrXml = sXml.split("|$$|");
	   	   	  		
				  	if (arrXml.length > 0) {
				  		sheetObjects[0].LoadSaveXml(arrXml[0]);
				  	}
				  	if (arrXml.length > 1) {
				  		sheetObjects[1].LoadSaveXml(arrXml[1]);
				  	} else {
				  		sheetObjects[1].LoadSaveXml(arrXml[0]);
				  	}
				  	
				  	setImageButton(sheetObj);
				  	
				  	form.plusSum.value = "0";
				  	form.minusSum.value = "0";
				  	
				  	setCellEditable(sheetObjects[0]);
				  	setCellEditable(sheetObjects[1]);
	        	}
    			break;
    			
        	case IBROWSEARCH:   // 공통 코드 조회	
	   			CoFmsGetCombo("GRID", formObj, sheetObj, "CD01751", "flet_ppay_rlt_cd", "flet_ppay_rlt_cdText", "Y");
    			break;
        }
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Effective Date의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	if((event.srcElement.name == "effDt1") ||
    	   (event.srcElement.name == "effDt2")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력가능하게 처리한다.<br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력가능하게 처리한다.<br>
     **/
   //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
    function eng_keypress() {
		//영대문자 자동변환
		ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     } 
     
    /**
     * HTML Control의 onchange이벤트에서 Vessel Code, Location변경 시 Validtion을 체크하다.<br>
     **/
    function obj_change() {
    	if((event.srcElement.name == "vsl_cd")) {
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    		
    		form.vsl_eng_nm.value = "";
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
    	} else if((event.srcElement.name == "loc_cd")) { 
    		form.loc_nm.value = "";
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"loc_cd");
     	}
    }

    /**
     * VVD Code의 Validation을 체크한다.
     */
    function checkVvdCode(sheetObj, formObj, row) {
    	formObj.f_cmd.value = SEARCH06;
		var vvdCd = sheetObj.CellValue(row, "vvd_cd");
		
		if(vvdCd.trim() == "") {
			// VVD Code은(는) 필수 입력항목입니다
			ComShowCodeMessage("FMS00004", "VVD Code");
			sheetObj.SelectCell(row,"vvd_cd");
			return false;
		}
		
		var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do?vvd_cd="+vvdCd, FormQueryString(formObj));
		if(CoFmsShowXmlMessage(sXml) != "") {
			sheetObj.CellValue2(row,"vvd_cd") = " ";
			//sheetObj.CellValue2(row,"vvd_cd1") = " ";
			alert(CoFmsShowXmlMessage(sXml));
			sheetObj.SelectCell(row,"vvd_cd");
			return false;
		}
		
		return true;
    }

    /**
     * Description 입력여부를 체크한다.<br>
     */
    function checkApDesc(sheetObj, formObj, row) {
    	var apDesc = sheetObj.CellValue(row, "ap_desc");
    	// Description을 입력하지 않은 경우 Validation체크 시 Focus가 이동하면 Merge가 깨지므로 스페이스로 처리한다.
		if(apDesc.trim() == "") {
			sheetObj.CellValue(row,"ap_desc")  = " ";
			
			// Description은(는) 필수 입력항목입니다
			ComShowCodeMessage("FMS00004", "Description");
			sheetObj.SelectCell(row,"ap_desc");
			return false;
		}
		
		return true;
    }
   
    /**
     * VVD Code와 Description입력여부를 체크한다.<br>
     */
    function checkCell(sheetObj, formObj) {
    	var ibflag;
    	for(var row=1; row<=sheetObj.LastRow; row++) {
			ibflag = sheetObj.CellValue(row, "ibflag");
			if(ibflag == "U") {
				if(!checkApDesc(sheetObj, formObj, row)) {
					return false;
				}
				
				if(!checkVvdCode(sheetObj, formObj, row)) {
					return false;
				}
			}
		}

    	return true;
    }
     
    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction,objNm){
        if(sAction == IBSAVE) {
        	if((sheetObjects[0].isDataModified == false)&& (sheetObjects[1].isDataModified == false)) {
        		ComShowCodeMessage("FMS00007");
	     		return false;
        	}
        	
	     	if((formObj.plusSum.value.replace(/,/,'')*1) != (formObj.minusSum.value.replace(/,/,'')*-1)) {
	     		ComShowCodeMessage("FMS01149");
	     		return false;
	     	}
    		 
	    	if(!checkCell(sheetObjects[0], formObj)) {
	     		return false;
	     	}
	     	if(!checkCell(sheetObjects[1], formObj)) {
	     		return false;
	     	}
    	 } else {
	    	if (!ComChkValid(formObj)) return false;

	    	if(objNm == "autoFilter") {
	    		if(formObj.vsl_cd.value == "") {
	    			// Vessel Code은(는) 필수 입력항목입니다
	    			ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00004", "Vessel Code"));
	    			return false;
	    		}
	    	}
    	 }
    	
         return true;
    }

    /**
	 * Vessel Code 팝업창에서 선택한 Vessel정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		form.btn_vslCdClr.checked = true;
	}

    /**
	 * Location Code 팝업창에서 선택한 Location정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setLocCd(aryPopupData) {
		form.loc_cd.value = aryPopupData[0][3];
		form.loc_nm.value = aryPopupData[0][4];
		form.btn_locCdClr.checked = true;
	}

    /**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
    	if(sheetObjects[0].isDataModified || sheetObjects[1].isDataModified) {
    		// 입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?
    		okYn = ComShowCodeConfirm("FMS00002");
    	}
    	
    	return okYn;
    }

    /**
     * Sheet에 이미지 버튼을 삽입 및 VVD CD, Original Slip No.의 폰트를 변경한다.<br>
     */
    function setImageButton(sheetObj) {

        for(var row=1; row<=sheetObj.LastRow; row++) {
			sheetObj.CellImage(row,"apply") = 0;
			sheetObj.CellFont("FontName", row, "vvd_cd") = "Courier New";
			sheetObj.CellFont("FontName", row, "org_slp_no") = "Courier New";
    	}
    }
     
    /**
     * Sheet에 OnSearchEnd 이벤트 발생시 Apply이미지 버튼을 적용시킨다.<br>
     */
    function sheet_OnSearchEnd(sheetObj, ErrMsg) {
    	      	
    	setImageButton(sheetObj)
    	form.plusSum.value = "0";
 	}
    
    /**
     * Sheet1에 OnSearchEnd 이벤트 발생시 VVD CD, Original Slip No.의 폰트를 변경한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 form.minusSum.value = "0";
    	 
    	 for(var row=1; row<=sheetObj.LastRow; row++) {
  			sheetObj.CellFont("FontName", row, "vvd_cd") = "Courier New";
  			sheetObj.CellFont("FontName", row, "org_slp_no") = "Courier New";
      	}
 	}

    /**
     * Sheet의 총 Amount값을 구한다.<br>
     */
    function setPlusSum(sheetObj, row) {
    	var plusSum = 0;

    	if(sheetObj.CellValue(row, "stl_flg") == "1") {
    		plusSum = form.plusSum.value.replace(/,/g,'')*1 + sheetObj.CellValue(row, "n1st_amt")*1;
    	} else {
    		plusSum = form.plusSum.value.replace(/,/g,'')*1 - sheetObj.CellValue(row, "n1st_amt")*1;
    	}
    	form.plusSum.value = ComAddComma(CoFmsRound(plusSum, 2));
    
    }

    /**
     * Sheet1의 총 Amount값을 구한다.<br>
     */
    function setMinusSum(sheetObj, row) {
    	var minusSum = 0;

    	if(sheetObj.CellValue(row, "stl_flg") == "1") {
    		minusSum = form.minusSum.value.replace(/,/g,'')*1 + sheetObj.CellValue(row, "n1st_amt")*1;
    	} else {
    		minusSum = form.minusSum.value.replace(/,/g,'')*1 - sheetObj.CellValue(row, "n1st_amt")*1;
    	}
    	form.minusSum.value = ComAddComma(CoFmsRound(minusSum, 2));
    }
    
    /**
     * Sheet의 OnChange 이벤트 발생시 VVD Code의 Validation체크 및 Match의 체크여부에 따라 Type의 활성화 상태를 설정한다.<br>
     */
    function sheet_OnChange(sheetObj, row, col, value) {
    	// VVD Code의 Validation을 체크한다.
    	
    	if(col == 4) {
     		var vvdCd = sheetObj.CellValue(row, "vvd_cd");

     		if(vvdCd.trim() != "") {
     			if(!checkVvdCode(sheetObj, this.form, row)) {
     				return;
     			}
     		}
     	}
    	
    	// 1. Match의 체크여부에 따라 Type의 활성화 상태를 설정한다.
    	// 2. Match가 체크된 항목의 총 Amount값을 구한다.
     	
     	if(col == 2) {
        	if(sheetObj.CellValue(row, "stl_flg") == 1) {
        		sheetObj.CellValue2(row, "flet_ppay_rlt_cd") = "";
        	}
        	
        	setPlusSum(sheetObj, row);
        	
        	setCellEditable2(sheetObj, row);
        }

        if(col == 3) {
        	if(sheetObj.CellValue(row, "flet_ppay_rlt_cd") != "") {
        		sheetObj.CellValue2(row, "stl_flg") = 0;
        	}
        }
    }
    
    /**
     * Sheet1의 OnChange 이벤트 발생시 VVD code의 Vaildation을 체크한다.<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value) {
    	if(col == 4) {
    		var vvdCd = sheetObj.CellValue(row, "vvd_cd");
    		if(vvdCd.trim() != "") {
    			checkVvdCode(sheetObj, this.form, row);
    		}
     	} 
    	
        if(col == 2) {
        	if(sheetObj.CellValue(row, "stl_flg") == 1) {
        		sheetObj.CellValue2(row, "flet_ppay_rlt_cd") = "";
        	}
        	
        	setMinusSum(sheetObj, row);
        	
        	setCellEditable2(sheetObj, row);
        }
        
        if(col == 3) {
        	if(sheetObj.CellValue(row, "flet_ppay_rlt_cd") != "") {
        		sheetObj.CellValue2(row, "stl_flg") = 0;
        	}
        }
    }

    /**
     * Sheet의 OnClick 이벤트 발생시 FMS Approval이 'N'인 경우 Apply버튼 클릭시 Manhour List 팝업창을 띄운다.<br>
     */
    function sheet_OnClick(sheetObj, row, col, value) {
    	 if(col == 17) {
    		 if(sheetObj.CellValue(row, "apro_flg") == "N") {
    			 if(   sheetObj.CellValue(row, "stl_flg") == 0
    				&& sheetObj.CellValue(row, "flet_ppay_rlt_cd") == "O") {
		    		 var slpTpCd = sheetObj.CellValue(row, "slp_tp_cd");
		    		 var slpFuncCd = sheetObj.CellValue(row, "slp_func_cd");
		    		 var slpTeamCd = sheetObj.CellValue(row, "slp_team_cd");
		    		 var slpIssDt = sheetObj.CellValue(row, "slp_iss_dt");
		    		 var slpSerNo = sheetObj.CellValue(row, "slp_ser_no");
		    		 var slpSeqNo = sheetObj.CellValue(row, "slp_seq_no");
		    		 var orgSlpNo = sheetObj.CellValue(row, "org_slp_no");
		    		 var vvdCd = sheetObj.CellValue(row, "vvd_cd");
		    		 var effDt = sheetObj.CellValue(row, "eff_dt");
		    		 var apDesc = sheetObj.CellValue(row, "ap_desc");
		
		    		 var param = "?slpTpCd=" + slpTpCd + "&slpFuncCd=" + slpFuncCd +
		    		 			 "&slpTeamCd=" + slpTeamCd + "&slpIssDt=" + slpIssDt +
		    		 			 "&slpSerNo=" + slpSerNo + "&slpSeqNo=" + slpSeqNo +
		    		 			 "&orgSlpNo=" + orgSlpNo + "&vvdCd=" + vvdCd +
		    		 			 "&effDt=" + effDt + "&apDesc=" + apDesc;

		    		 ComOpenWindowCenter("ESM_FMS_0007.do" + param, "ESM_FMS_0007", 1024, 495);
    			 }
    		 }
    	 }
    }
     
    /**
     * Sheet1의 OnClick 이벤트 발생시 FMS Approval이 'N'인 경우 Manhour List 팝업창을 띄울수 있도록 설정한다.<br>
     */
    function sheet1_OnClick(sheetObj, row, col, value) {

    	if(col == 2) {
	   		 if(sheetObj.CellValue(row, "apro_flg") == "N") {
	   			 setCellEditable2(sheetObj, row);
	   		 }
    	}
    }
     
    /**
     * Sheet의 OnMouseMove 이벤트 발생시 FMS Approval이 'Y'인 경우 마우스커서 모양을 Default로 변경한다.<br>
     */
    function sheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {

    	if(sheetObj.MouseCol == 17) {
    		if(sheetObj.CellValue(sheetObj.MouseRow, "apro_flg") == "N") {
    			// Match가 체크 되어 있으면 Apply 버튼 비활성화
    			if(sheetObj.CellValue(sheetObj.MouseRow, "stl_flg") == 1) {
    				sheetObj.DataLinkMouse("apply") = false;
    			} else {
    				// Type이 O/A인 경우에만 Apply 버튼 활성화 아니면 비활성화
    				if(sheetObj.CellValue(sheetObj.MouseRow, "flet_ppay_rlt_cd") == "O") {
    					sheetObj.DataLinkMouse("apply") = true;
    				} else {
    					sheetObj.DataLinkMouse("apply") = false;
    				}
    			}
    		} else {
    			sheetObj.DataLinkMouse("apply") = false;
    		}
    	} else {
    		sheetObj.DataLinkMouse("apply") = false;
    	}
    }
    
    /**
     * Sheet의 OnBeforeEdit 이벤트 발생시 Description에 스페이스만 들어가 있는 경우 편집전 스페이스를 제거한다.<br>
     */
    function sheet_OnBeforeEdit(sheetObj,row,col) {

    	if(col == 3) {
    	    if (sheetObj.CellValue(row,"ap_desc") == " ") {
    		    sheetObj.CellValue(row,"ap_desc") = "";
    		}
    	}
        
        if(col == 4) {
    	    if (sheetObj.CellValue(row,"vvd_cd") == " ") {
    		    sheetObj.CellValue(row,"vvd_cd") = "";
    		}
    	}
    }
    
    /**
     * Sheet의 OnAfterEdit 이벤트 발생시 Description에 데이터가 없는 경우 Sheet가 깨지므로 임시로 스페이스로 설정한다.<br>
     */
    function sheet_OnAfterEdit(sheetObj,row,col) {

    	if(col == 3) {
    	    if (sheetObj.CellValue(row,"ap_desc") == "") {
    	    	sheetObj.CellValue2(row,"ap_desc") = " ";
    		}
    	}
    	
    	if(col == 4) {
    	    if (sheetObj.CellValue(row,"vvd_cd") == "") {
    	    	sheetObj.CellValue2(row,"vvd_cd") = " ";
    		}
    	}
    }
    
    /**
     * Sheet1의 OnBeforeEdit 이벤트 발생시 Description에 스페이스만 들어가 있는 경우 편집전 스페이스를 제거한다.<br>
     */
    function sheet1_OnBeforeEdit(sheetObj,row,col) {

    	if(col == 3) {
    	    if (sheetObj.CellValue(row,"ap_desc") == " ") {
    		    sheetObj.CellValue(row,"ap_desc") = "";
    		}
    	}
        
        if(col == 4) {
    	    if (sheetObj.CellValue(row,"vvd_cd") == " ") {
    		    sheetObj.CellValue(row,"vvd_cd") = "";
    		}
    	}
    }
    
    /**
     * Sheet1의 OnAfterEdit 이벤트 발생시 Description에 데이터가 없는 경우 Sheet가 깨지므로 임시로 스페이스로 설정한다.<br>
     */
    function sheet1_OnAfterEdit(sheetObj,row,col) {

    	if(col == 3) {
    	    if (sheetObj.CellValue(row,"ap_desc") == "") {
    	    	sheetObj.CellValue2(row,"ap_desc") = " ";
    		}
    	}

    	if(col == 4) {
    	    if (sheetObj.CellValue(row,"vvd_cd") == "") {
    	    	sheetObj.CellValue2(row,"vvd_cd") = " ";
    		}
    	}
    }
     
    /**
     * csr_slp_flg(apro_flg)가 'Y'인 경우 수정불가로 설정한다.
     */
    function setCellEditable(sheetObj) {

    	for(var i=1; i<=sheetObj.LastRow; i++) {
     		if(sheetObj.CellValue(i, "apro_flg") == "Y") {
     			sheetObj.CellEditable(i, "stl_flg") = false;
     			sheetObj.CellEditable(i, "flet_ppay_rlt_cd") = false;
     			sheetObj.CellEditable(i, "ap_desc") = false;
     			sheetObj.CellEditable(i, "vvd_cd") = false;
     		} else {
     			setCellEditable2(sheetObj, i);
     		}
     	}
    }

    /**
     * 2Row를 1Row로 엑셀출력하기 위해 임시Sheet에 데이터를 넣고 출력한다.<br>
     */
    function speedDown2Excel(sheetObj, sheetNo) {
    	if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
    	
    	var targetSheetObj;
    	
    	if(sheetNo == 1) {
    		targetSheetObj = sheetObjects[2];
    	} else if(sheetNo == 2) {
    		targetSheetObj = sheetObjects[3];
    	}
    	
    	for(var i=2; i<=sheetObj.LastRow; i+=2) {
    		var row = targetSheetObj.DataInsert();
    		if(sheetObj.CellValue(i,"stl_flg") == 1) {
    			targetSheetObj.CellValue2(row,"stl_flg") = "Y";
    		} else {
    			targetSheetObj.CellValue2(row,"stl_flg") = "N";
    		}
    		targetSheetObj.CellText(row,"flet_ppay_rlt_cd") = sheetObj.CellText(i,"flet_ppay_rlt_cd");
    		targetSheetObj.CellValue2(row,"acct_cd") = sheetObj.CellValue(i,"acct_cd");
    		targetSheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(i,"ctr_cd");
    		targetSheetObj.CellValue2(row,"eff_dt") = sheetObj.CellValue(i,"eff_dt");
    		targetSheetObj.CellValue2(row,"n1st_curr_cd") = sheetObj.CellValue(i,"n1st_curr_cd");
    		targetSheetObj.CellValue2(row,"n1st_amt") = sheetObj.CellValue(i,"n1st_amt");
    		targetSheetObj.CellValue2(row,"n2nd_curr_cd") = sheetObj.CellValue(i,"n2nd_curr_cd");
    		targetSheetObj.CellValue2(row,"n2nd_amt") = sheetObj.CellValue(i,"n2nd_amt");
    		targetSheetObj.CellValue2(row,"act_xch_rt_amt") = sheetObj.CellValue(i,"act_xch_rt_amt");
    		targetSheetObj.CellValue2(row,"apro_flg") = sheetObj.CellValue(i,"apro_flg");
    		targetSheetObj.CellValue2(row,"ap_desc") = sheetObj.CellValue(i+1,"ap_desc");
    		targetSheetObj.CellValue2(row,"vvd_cd") = sheetObj.CellValue(i+1,"vvd_cd");
    		targetSheetObj.CellValue2(row,"org_slp_no") = sheetObj.CellValue(i+1,"org_slp_no");
    		targetSheetObj.CellValue2(row,"man_hr_flg") = sheetObj.CellValue(i+1,"man_hr_flg");
    	}
    	
    	targetSheetObj.SpeedDown2Excel(-1);
    	
    	targetSheetObj.RemoveAll();
    }
    
    /**
     * Match체크여부에 따라 Type, Description, VVD Code의 활성화여부를 설정한다.<br>
     */
    function setCellEditable2(sheetObj, row) {
    	
    	if(sheetObj.CellValue(row, "stl_flg") == "1") {
		 	sheetObj.CellEditable(row, "flet_ppay_rlt_cd") = false;
  			sheetObj.CellEditable(row, "ap_desc") = false;
  			sheetObj.CellEditable(row, "vvd_cd") = false;
		 } else {
			sheetObj.CellEditable(row, "flet_ppay_rlt_cd") = true;
   			sheetObj.CellEditable(row, "ap_desc") = true;
   			sheetObj.CellEditable(row, "vvd_cd") = true;
		 }
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     */
    function obj_activate() {
        ComClearSeparator(event.srcElement);
    }

    /**
     * sheet1의 OnScroll 이벤트 발생시 sheet2의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[1].LeftCol = newLeftCol;
    }
    
    /**
     * sheet2의 OnScroll 이벤트 발생시 sheet1의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet1_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[0].LeftCol = newLeftCol;
    }
 	/* 개발자 작업  끝 */