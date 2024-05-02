/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0387.js
*@FileTitle : Next VVD Assign I (by VVD POD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.02.17 이일민 [SRM-201113256] Next VVD Assign - Cancel Assign 기능 수정
* 2011.02.04 정선용 [CHM-201109108] next vvd  assign 시 special cargo에 대한 alert msg 삭제 요청
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
     * @class ESM_BKG_0387 : ESM_BKG_0387 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0387() {
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
	var prefix1="sheet1_";
	var prefix2="sheet2_";
	var prefix3="t1sheet1_";
	var prefix4="t2sheet1_";
	var prefix5="sheet3_";
	
	var closedVvds= "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
    
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/         
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];          
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						btnEnable(true);
						ComClearObject(formObject.vsl_nm); 
						ComClearObject(formObject.eta); 
						ComClearObject(formObject.etd); 
						ComSetObjValue(formObject.total20,"0");
						ComSetObjValue(formObject.total40,"0");
						ComSetObjValue(formObject.selBKG20,"0");
						ComSetObjValue(formObject.selBKG40,"0");
						ComSetObjValue(formObject.selVVD20,"0");
						ComSetObjValue(formObject.selVVD40,"0");
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
						sheetObjects[3].RemoveAll();
						tabObjects[0].SelectedIndex=0;
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					}
					break;	

                case "btn_new":
					initForm();
				    ComClearObject(formObject.etb_from);
					ComClearObject(formObject.etb_to);
					btnEnable(true);
					break;

				case "btn_downexcel":
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회
						doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
					}  
					break;

				case "btn_cancelassign":
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회
						if (CheckRowGrid(sheetObjects[2],prefix3+"chk")){ 
							btnEnable(false);
							doActionIBSheet(sheetObjects[2],formObject,COMMAND03);
						}						
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						if (CheckRowGrid(sheetObjects[3],prefix4+"chk")){ 
							btnEnable(false);
							doActionIBSheet(sheetObjects[3],formObject,COMMAND03);
						}
					}  
					break;

				case "btn_vvdassign":
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회
						if (CheckRowGrid(sheetObjects[1],prefix2+"chk")){
							btnEnable(false);
							doActionIBSheet(sheetObjects[2],formObject,COMMAND04);
						}						
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						if (CheckRowGrid(sheetObjects[1],prefix2+"chk")){ 
							btnEnable(false);
							doActionIBSheet(sheetObjects[3],formObject,COMMAND04);
						}
					} 
					break;
               
				case "btn_duration":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.etb_from, formObject.etb_to,'yyyy-MM-dd');
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

//		tabObjects[0].TabEnable(0) = true;
//		tabObjects[0].TabEnable(1) = true; 
		tabObjects[0].SelectedIndex = 0;
		initForm(); 
		axon_event.addListenerFormat('keypress','bkg0387_keypress',document.form); 
		axon_event.addListenerForm  ('beforedeactivate', 'bkg0387_deactivate',  document.form);
		axon_event.addListenerFormat('beforeactivate',   'bkg0387_activate',    document.form);
		axon_event.addListenerForm('click', 'bkg0387_click', document.form);
		//doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
    }
	
	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
	// 송유성 팀장님 test 중
//		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,COMMAND05);   
//		sheetObj.WaitImageVisible = true;   
	}   

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|1st VVD|ETB|TMNL";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,		30,		daCenter,	false,	prefix1+"chk",			false,          "",      dfNone,			0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,	prefix1+"former_vvd",	false,          "",      dfNone,			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,	prefix1+"etb",			false,          "",      dfNone,			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,	prefix1+"pod_yd_cd",	false,          "",      dfNone,			0,     false,       false,	7);
                }
                break;

			case 2:      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Next VVD|LANE|OOP|ETD|ETA|Relay TMNL|Relay Seq|Next TMNL|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,	true,	prefix2+"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,		30,		daCenter,	false,	prefix2+"chk",			false,	"",	dfNone,      	0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	false,	prefix2+"next_vvd",		false,	"",	dfNone,			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				45,		daCenter,	false,	prefix2+"slan_cd",		false,	"",	dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				45,		daCenter,	false,	prefix2+"op_cd",		false,	"",	dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	prefix2+"etd",			false,	"",	dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	prefix2+"eta",			false,	"",	dfNone,   	 	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	prefix2+"relay_tmnl",	false,	"",	dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	false,	prefix2+"relay_seq",	false,	"",	dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	prefix2+"next_tmnl",	false,	"",	dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	false,	prefix2+"next_seq",		false,	"",	dfNone,      	0,     false,       false);
                }
                break;

			case 3:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 182;
					//전체 너비 설정
					SheetWidth = mainTable11.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|Sel.|Next Port|20'|40'|Next VVD|OOP|ETB|ETD|Special";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    30,		daCenter,	true,	prefix3+"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,      	40,		daCenter,	false,  prefix3+"chk",			false,          "",      dfNone,      	0,     true,      true,	    1);
					InitDataProperty(0, cnt++ , dtData,      		180,	daCenter,	false,  prefix3+"next_port",	false,          "",      dfNone,      	0,     false,     false,	7);
					InitDataProperty(0, cnt++ , dtData,      		90,		daRight,	false,  prefix3+"fit20",		false,          "",      dfNullInteger, 0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		90,		daRight,	false,  prefix3+"fit40",		false,          "",      dfNullInteger, 0,     false,     false);					
					InitDataProperty(0, cnt++ , dtData,      		110,	daCenter,	false,  prefix3+"next_vvd",		false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		90,		daCenter,	false,  prefix3+"op_cd",		false,          "",      dfNone,      	0,     false,     false,	2);
					InitDataProperty(0, cnt++ , dtData,      		110,	daCenter,	false,  prefix3+"etb",			false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		115,	daCenter,	false,  prefix3+"etd",			false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		140,	daCenter,	false,  prefix3+"spcl",			false,          "",      dfNone,      	0,     false,     false,	1);
					
					CountPosition = 0;
                }
				break;

			case 4:      //t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 182;
					//전체 너비 설정
					SheetWidth = mainTable21.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(24, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|Sel.|B/L No.|BKG No.|CNTR No.|TP|Weight|Weight|POL|DEL|Next Port|Next Port|Former VVD|ETB|TMNL|Next VVD|OOP|ETD|D/G|R/F|A/K|S/T|";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    30,		daCenter,	true,	prefix4+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	    	40,		daCenter,	false,  prefix4+"chk",				false,          "",      dfNone,      0,     true,        true);					
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,  prefix4+"bl_no",			false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,  prefix4+"bkg_no",			false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,  prefix4+"cntr_no",			false,          "",      dfNone,      0,     false,       false);					
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,  prefix4+"cntr_tpsz_cd",		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	false,  prefix4+"cntr_wgt",			false,          "",      dfNullFloat, 2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				25,		daCenter,	false,  prefix4+"wgt_ut_cd",		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,  prefix4+"pol_cd",			false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,  prefix4+"del_cd",			false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,  prefix4+"next_port",		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,  prefix4+"next_port_yard",	false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,  prefix4+"former_vvd",		false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,  prefix4+"etb",				false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,  prefix4+"tmnl",				false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,  prefix4+"next_vvd",			false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,  prefix4+"op_cd",			false,          "",      dfNone,      0,     false,       false);					
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,  prefix4+"etd",				false,          "",      dfNone,      0,     false,       false);						
					InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	false,  prefix4+"dcgo_flg",			false,          "",      dfNone,      0,     true,        true);
					InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	false,  prefix4+"rc_flg",			false,          "",      dfNone,      0,     true,        true);
					InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	false,  prefix4+"awk_cgo_flg",		false,          "",      dfNone,      0,     true,        true);
					InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	false,  prefix4+"st",				false,          "",      dfNone,      0,     true,        true);					
					InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	false,  prefix4+"rmk",				false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,  prefix4+"next_tmnl",		false,          "",      dfNone,      0,     false,       false);
										
					InitDataCombo(0, prefix4+"dcgo_flg", "Y|N", "Y|N");
					InitDataCombo(0, prefix4+"rc_flg", "Y|N", "Y|N");
					InitDataCombo(0, prefix4+"awk_cgo_flg", "Y|N", "Y|N");
					InitDataCombo(0, prefix4+"st", "Y|N", "Y|N");					
					ShowButtonImage = 2;
                }
				break;
			  
			case 5:
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable3.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|Chk|BKG No.|POL|OP_CD|Former VVD|Next VVD|Relay Port|Relay Seq|Next TMNL|Before TMNL|Next Seq|Old Next VVD";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,     cnt++ , dtHiddenStatus,	    40,		daCenter,		true,		prefix5+"ibflag");
					InitDataProperty(0,		cnt++ , dtCheckBox,		    40,		daCenter,		false,		prefix5+"chk",				false,      "",     dfNone,     0,      true,       true);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"bkg_no",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix5+"pol_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix5+"op_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"former_vvd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"next_vvd",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"relay_port",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"relay_seq",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"next_tmnl",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"before_tmnl",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"next_seq",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix5+"old_next_vvd",		false,		"",		dfNone,		0,		false,		false);
                }
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_","sheet2_","t1sheet1_","t2sheet1_");		 
		var preFix = sheetObj.id+"_"; 
        switch(sAction) {
           case IBSEARCH:      //조회
           		ComOpenWait(true);
           		sheetObj.WaitImageVisible=false;
                formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0387GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.Redraw = false; 
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true;  
				ComSetObjValue(formObj.oldRelayPort,formObj.relay_port.value);  				
				break;

//		   case IBSAVE:        //저장
//		   		sheetObj.WaitImageVisible=false;
//		   		ComOpenWait(true);
//				formObj.f_cmd.value = MULTI; 
//				var params = FormQueryString(formObj);
//            	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
//				var sXml = sheetObj.GetSaveXml("ESM_BKG_0387GS.do", params);
//				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
//				
//            	sheetObj.LoadSearchXml(sXml);
//				 
//                break;
		   case IBDOWNEXCEL:      // 엑셀다운  
		   		sheetObj.WaitImageVisible=false;
		   		ComOpenWait(true);
			    var rowSkip="";
				for(var i=1;i<sheetObj.Rows;i++){
					if (typeof(sheetObj.CellValue(i,preFix+"chk").length) !="undefined"){
						if (i==sheetObj.Rows-1){
							rowSkip+=i;
						}else{
							rowSkip+=i+"|";
						}
					} 
				}
				 
				sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,preFix+"chk|",rowSkip);
				break;
				
			case COMMAND01:			//grid_Former change
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND01; 
				tabObjects[0].SelectedIndex=0;
				var params = FormQueryString(formObj);
				sheetObj.WaitImageVisible = false;
				var params = FormQueryString(formObj);
            	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true))+ "&" + ComGetPrefixParam(new Array("t1sheet1_","t2sheet1_"));
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0387GS.do", params); 
				var arrXml = sXml.split("|$$|");
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				
				sheetObjects[2].WaitImageVisible = false; 
				for(var i = 0; i < arrXml.length; i++){ 
					sheetObjects[i+2].Redraw = false;    
					if(i > 0) {
						//sheetObjects[i+2].WaitImageVisible = false;	
					}  
					sheetObjects[i+2].LoadSearchXml(arrXml[i]); 
					sheetObjects[i+2].Redraw = true;
				}
				
				ComSetObjValue(formObj.selBKG20,"0");
				ComSetObjValue(formObj.selBKG40,"0");
				ComSetObjValue(formObj.selVVD20,"0");
				ComSetObjValue(formObj.selVVD40,"0");
				
				ComSetObjValue(formObj.vsl_nm,ComGetEtcData(arrXml[0],"vs_nm")); 
				ComSetObjValue(formObj.eta,ComGetEtcData(arrXml[0],"eta")); 
				ComSetObjValue(formObj.etd,ComGetEtcData(arrXml[0],"etd")); 
				
				fitSum(formObj,sheetObjects[2]);
				setRmkBackColor(); 
				break;
				
			case COMMAND02:			//NEXT VVD SELECTION				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND02;  
				var params = FormQueryString(formObj);
            	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
				params = params + "&" + ComGetPrefixParam(new Array("sheet2_"));
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0387GS.do", params);
				
            	sheetObjects[1].Redraw = false; 
				sheetObjects[1].LoadSearchXml(sXml); 
				sheetObjects[1].Redraw = true;  		
				break;
				
			case COMMAND03:			//btn_cancelassign
				sheetObj.WaitImageVisible=false;
				// T/S close by bayplan check
//				if(!checkTsCloseByBayPlan()){
//					return false;
//				}
				
				formObj.f_cmd.value = COMMAND03; 
				var params = FormQueryString(formObj)+"&closed_vvds="+closedVvds;
				var sBkgNo=""; 
			    var idx=1;
				var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
				var arrRow = sRow.split("|"); 
				if (arrRow.length==1) return;
				sheetObjects[4].RemoveAll(); 
				for(var iRow=0;iRow<arrRow.length-1;iRow++){ 
					if (sBkgNo !=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no")){
						sBkgNo=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no"); 
						sheetObjects[4].DataInsert(-1);
						sheetObjects[4].CellValue(idx,prefix5+"next_vvd") = "SMXX0001E";
						sheetObjects[4].CellValue(idx,prefix5+"former_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"former_vvd");  
						sheetObjects[4].CellValue(idx,prefix5+"bkg_no") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no");
						sheetObjects[4].CellValue(idx,prefix5+"pol_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"pol_cd");
						sheetObjects[4].CellValue(idx,prefix5+"old_next_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd");
						idx++;
					}
				}
				tabObjects[0].SelectedIndex=1;

				ComOpenWait(true);
				var sXml = sendAction(sheetObjects[4],params,"C");
				ComOpenWait(false);
				
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComBkgSaveCompleted();
				}												
				break;
				
			case COMMAND04:			//btn_assign				
				sheetObj.WaitImageVisible=false;
				
				// T/S close by bayplan check
				if(!checkTsCloseByBayPlan()){
					return false;
				}
				
				// POL 이 KR 이 있는 경우만 하단의 로직을 실행 2014.05.20 //MDS
				var krRows = sheetObjects[1].FindCheckedRow(prefix2+"chk");
				var krRow  = krRows.split("|")[0];
				if(krRow != -1){
					var krVvdCd  = sheetObjects[1].CellValue(krRow,prefix2+"next_vvd");	
					var krPodLoc = sheetObjects[1].CellValue(krRow,prefix2+"next_tmnl").substr(0,5);
						
					if(krVvdCd.length > 0 && krPodLoc.length > 0 && krPodLoc.substr(0,2)=="KR"){
						var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH15+"&vvd_cd="+krVvdCd+"&pod_loc="+krPodLoc);
						var krDlCnt = ComGetEtcData(sXml, "kr_cstms_dl_cnt");
						if(krDlCnt!="" && krDlCnt.length>0 && krDlCnt>0){
							ComShowCodeMessage("BKG08312", krVvdCd);
						}
					}
				}

				formObj.f_cmd.value = COMMAND04; 
				var params = FormQueryString(formObj)+"&closed_vvds="+closedVvds;
				ComOpenWait(true);
				var sXml = sendAction(sheetObjects[4],params,"A");
				ComOpenWait(false);
				/* 기존 Assign 된 VVD 와 동일 VVD 를 Assign 할경우 
				 * skip 하고 Save Message 2010.05.03 임종한 과장님 요청
				 */
				if(sheetObjects[4].Rowcount == 0 && sXml == undefined ){  //Row가 0 이고 undefined 로 넘어올경우 
					var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
					var arrRow = sRow.split("|");
					
//					var sRow1=sheetObjects[1].FindCheckedRow(prefix2+"chk");
//					var arrRow1 = sRow1.split("|");
//					AsVvd=sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_vvd");
					
					/* 멀티 체크를 하여 Assign 하기 때문에 기존 동일 Assign 한 VVD 와 혼재 되어 있어  Row 가 0 인경우를 체크 함 */
					if(sheetObjects[4].RowCount == 0){
						for(var i = 0; i<arrRow.length-1; i++){
								sheetObjects[3].RowFontColor(arrRow[i])=sheetObjects[3].RgbColor(0, 051, 255);
								sheetObjects[3].CellFont("FontBold",arrRow[i],2,arrRow[i],21) = true;
//								sheetObjects[3].CellValue2(arrRow[i],prefix4+"next_vvd")=sVvd;
						}
					}else{
						for(var idx=0;idx<arrRow.length-1;idx++){							
							if(bkgNo ==sheetObjects[3].CellValue(arrRow[idx],prefix4+"bkg_no")){
								sheetObjects[3].RowFontColor(arrRow[idx])=sheetObjects[3].RgbColor(0, 051, 255);
								sheetObjects[3].CellFont("FontBold",arrRow[idx],2,arrRow[idx],21) = true;
								sheetObjects[3].CellValue2(arrRow[idx],prefix4+"next_vvd")=sVvd;
								sheetObjects[3].CellValue2(arrRow[idx],prefix4+"tmnl")=sTmnl;
							}
						}
					}	
					ComBkgSaveCompleted(); //성공 메시지
				}
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComBkgSaveCompleted();
				}											
				break;
				
			 case COMMAND05:			//Relay Port
			 	sheetObj.WaitImageVisible=false;
			 	ComOpenWait(true);
				formObj.f_cmd.value = COMMAND05; 
				var params = FormQueryString(formObj);  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0387GS.do", params);
			 	ComOpenWait(false);
			 	
				ComSetObjValue(formObj.relay_port,ComGetEtcData(sXml,"relayPort"));
				ComSetObjValue(formObj.baseRelayPort,ComGetEtcData(sXml,"relayPort"));
				if (!ComIsEmpty(ComGetEtcData(sXml,"etbFrom"))){
					ComSetObjValue(formObj.etb_from,ComGetEtcData(sXml,"etbFrom"));
					ComSetObjValue(formObj.etb_to,ComGetEtcData(sXml,"erbTo"));
					if (ComGetEtcData(sXml,"nextVvd")=="A"){
						formObj.next_vvd_select[0].checked=true;
					}else if (ComGetEtcData(sXml,"nextVvd")=="Y"){
						formObj.next_vvd_select[1].checked=true;
					}else if (ComGetEtcData(sXml,"nextVvd")=="N"){
						formObj.next_vvd_select[2].checked=true;
					}
				}
								 
				//formObj.relay_port.value=ComGetEtcData(sXml,"relayPort");
            	// formObj.baseRelayPort.value=ComGetEtcData(sXml,"relayPort");				 
				break; 
        }
        ComOpenWait(false);
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
                    InsertTab( cnt++ , "By VVD & POD" , -1 );
                    InsertTab( cnt++ , "By Booking" , -1 );
                }
            break;
        }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
		var sRow="";
		var arrRow="";
		if (beforetab ==0){
			//CellCheckAll(sheetObjects[3],false,prefix4+"chk"); 
			//ComSetObjValue(document.form.selBKG20,"0");
			//ComSetObjValue(document.form.selBKG40,"0");
			sRow=sheetObjects[2].FindCheckedRow(prefix3+"chk");
			arrRow = sRow.split("|");  
			if (arrRow.length==1) return; 
			sheetObjects[2].SelectCell(arrRow[0], 0, false);
		}else if (beforetab ==1){
			//CellCheckAll(sheetObjects[2],false,prefix3+"chk");
			//ComSetObjValue(document.form.selVVD20,"0");
			//ComSetObjValue(document.form.selVVD40,"0");
			sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
			arrRow = sRow.split("|");  
			if (arrRow.length==1) return; 
			sheetObjects[3].SelectCell(arrRow[0], 0, false);
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
        		case IBSEARCH: {
					if(ComIsEmpty(relay_port)){
						ComShowCodeMessage("BKG00704");
						return false;
					}
					if(ComIsEmpty(former_vvd)&&(ComIsEmpty(etb_from)||ComIsEmpty(etb_to))){
						ComShowCodeMessage("BKG00704");
						return false;
					}
					if (ComGetDaysBetween(etb_from.value, etb_to.value) > 30) {
						//ComShowCodeMessage("BKG02016"); 
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						etb_from.focus();
						return false;
					}
					break;
        		}
        	}
		}
        return true;
    }

    /*
	 * 두번째 탭에 있는 시트 더블 클릭처리 함수
	 */
	function t2sheet1_OnDblClick(sheetObj, Row, Col){
		with(sheetObj){
			sheetObj.WaitImageVisible=false;
			var formObject = document.form;
			var sName = ColSaveName(Col);
			var param="?bkg_no="+CellValue(Row,prefix4+"bkg_no");
			param+="&relay_port="+ComGetObjValue(formObject.oldRelayPort);
			param+="&pgmNo=ESM_BKG_0903";
			if(sName == prefix4+"bl_no"){
				ComOpenWindowCenter("/hanjin/ESM_BKG_0903.do"+param, "myWin", 500,278, true);
			}
		}
	}
	
	/*
	*두번째 탭에 있는 시트 mouseMove처리 함수
	*/
	function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			var sName = ColSaveName(MouseCol);
			if(sName == prefix4+"bl_no"){
				MousePointer = "Hand"; 
			}else{
				MousePointer = "Default"; 
			}
		}
	}
	
	/*
	* Sheet1 OnClick 함수
	*/
	function sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.CellValue(Row,prefix1+"chk")=="0"){
			sheetObj.CellValue2(Row,prefix1+"chk")="1";
		} 
		if (sheetObj.ColSaveName(Col) !=prefix1+"chk"){
			sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix1+"chk"), sheetObj.CellValue(Row,prefix1+"chk"));
		}
	}
	
	/*
	* Sheet2 OnClick 함수
	*/
	function sheet2_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.CellValue(Row,prefix2+"chk")=="0"){
			sheetObj.CellValue2(Row,prefix2+"chk")="1";
		} 
		if (sheetObj.ColSaveName(Col) !=prefix2+"chk"){
			sheet2_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix2+"chk"), sheetObj.CellValue(Row,prefix2+"chk"));
		}		
	}
		
	/*
	* t1sheet1 OnClick 함수
	*/
	function t1sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.ColSaveName(Col) !=prefix3+"chk" && sheetObj.CellValue(Row,prefix3+"chk")=="0"){
			sheetObj.CellValue2(Row,prefix3+"chk")="1";
		}else if (sheetObj.ColSaveName(Col) !=prefix3+"chk" && sheetObj.CellValue(Row,prefix3+"chk")=="1"){
			sheetObj.CellValue2(Row,prefix3+"chk")="0";
		}

		if (sheetObj.ColSaveName(Col) !=prefix3+"chk"){
			t1sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix3+"chk"), sheetObj.CellValue(Row,prefix3+"chk"));
		}
	}

	/*
	* t2sheet1 OnClick 함수
	*/
	function t2sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.ColSaveName(Col) !=prefix4+"chk" && sheetObj.CellValue(Row,prefix4+"chk")=="0"){
			sheetObj.CellValue2(Row,prefix4+"chk")="1";
		}else if (sheetObj.ColSaveName(Col) !=prefix4+"chk" && sheetObj.CellValue(Row,prefix4+"chk")=="1"){
			sheetObj.CellValue2(Row,prefix4+"chk")="0";
		}
		if (sheetObj.ColSaveName(Col) !=prefix4+"chk") {
			t2sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix4+"chk"), sheetObj.CellValue(Row,prefix4+"chk"));
		}		
	}

	/*
	* Sheet1 OnChange 함수
	*/
    function sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObject = document.form; 
		with(sheetObj){
			WaitImageVisible=false;
			ComOpenWait(true);
			var sName = ColSaveName(Col); 
			if(sName == prefix1+"chk" && Value && !ComIsEmpty(formObject.relay_port)){
				sheetObjects[1].RemoveAll();
				sheetObjects[4].RemoveAll(); 
				doActionIBSheet(sheetObj,formObject,COMMAND01);
				btnEnable(true);
			}			
		}
		ComOpenWait(false);
		
	/* IBSheet 에서 Auto 로 첫번째 row 선택 되어 Remark 가 있을 경우
	 * Row 단위로 RgbColor 변경 부분이 적용이 되지 않아 강제로 Header Row 선택 */ 	
		sheetObjects[3].SelectCell(0,1);
		sheetObjects[2].SelectCell(0,1);
	}

	/*
	* Sheet2 OnChange 함수
	*/
    function sheet2_OnChange(sheetObj,Row, Col, Value){
//		with(sheetObj){
//			var sName = ColSaveName(Col); 
//			var sBkgNo=""; 
//			var idx=1;
//			sheetObj.WaitImageVisible=false;
//			if(sName == prefix2+"chk" && Value){
//				var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
//				var arrRow = sRow.split("|"); 
//				if (arrRow.length==1) return;
//				sheetObjects[4].RemoveAll(); 
//				for(var iRow=0;iRow<arrRow.length-1;iRow++){
//					if (sBkgNo !=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no")){
//						sBkgNo=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no"); 
//						sheetObjects[4].DataInsert(-1);
//						sheetObjects[4].CellValue(idx,prefix5+"next_vvd") = CellValue(Row,prefix2+"next_vvd");
////						sheetObjects[4].CellValue(idx,prefix5+"former_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"former_vvd");
//						sheetObjects[4].CellValue(idx,prefix5+"former_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd");
//						sheetObjects[4].CellValue(idx,prefix5+"bkg_no") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no");
//						sheetObjects[4].CellValue(idx,prefix5+"pol_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"pol_cd");
//						sheetObjects[4].CellValue(idx,prefix5+"op_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"op_cd");
//						sheetObjects[4].CellValue(idx,prefix5+"op_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"op_cd");
//						idx++;
//					}
//				}
//				tabObjects[0].SelectedIndex=1;
//			}
//		}

		sheetObjects[4].RemoveAll(); 
		
		var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
		var arrRow = sRow.split("|"); 
		var sBkgNo=" "; 
		var idx=1;
		for(var iRow=0;iRow<arrRow.length-1;iRow++){
			if (sBkgNo !=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no")){
				sBkgNo=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no"); 	
				sheetObjects[4].DataInsert(-1);			
				sheetObjects[4].CellValue(idx,prefix5+"next_vvd") = sheetObjects[1].CellValue(Row,prefix2+"next_vvd");			
				sheetObjects[4].CellValue(idx,prefix5+"former_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"former_vvd");
				sheetObjects[4].CellValue(idx,prefix5+"bkg_no") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no");			
				sheetObjects[4].CellValue(idx,prefix5+"pol_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"pol_cd");	
				sheetObjects[4].CellValue(idx,prefix5+"op_cd") = sheetObjects[1].CellValue(Row,prefix2+"op_cd");
				sheetObjects[4].CellValue2(idx,prefix5+"relay_tmnl") = sheetObjects[1].CellValue(Row,prefix2+"relay_tmnl");
				sheetObjects[4].CellValue2(idx,prefix5+"relay_seq") = sheetObjects[1].CellValue(Row,prefix2+"relay_seq");
				sheetObjects[4].CellValue2(idx,prefix5+"next_tmnl") = sheetObjects[1].CellValue(Row,prefix2+"next_tmnl");
				sheetObjects[4].CellValue2(idx,prefix5+"before_tmnl") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_tmnl");
				sheetObjects[4].CellValue2(idx,prefix5+"next_seq") = sheetObjects[1].CellValue(Row,prefix2+"next_seq");
				sheetObjects[4].CellValue(idx,prefix5+"old_next_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd");
				idx++;
			}
		}
		btnEnable(true);
    }

	/*
	* t1sheet1 OnChange 함수
	*/
    function t1sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObject = document.form;
		var sName = sheetObj.ColSaveName(Col);  
		if(sName == prefix3+"chk" && Value && !ComIsEmpty(formObject.relay_port)){ 
			SheetRowRadioCheck(sheetObj,Row,Col,Value); 
			Sheet1ToSheet2Chk(sheetObj,sheetObjects[3],Row,Value);
			ComSetObjValue(formObject.selVVD20,sheetObj.CellValue(Row,prefix3+"fit20")); 
			ComSetObjValue(formObject.selVVD40,sheetObj.CellValue(Row,prefix3+"fit40")); 
			ComSetObjValue(formObject.nextVvdFor,"t1sheet1_"); 
			doActionIBSheet(sheetObjects[1],formObject,COMMAND02);	
		}else if(sName == prefix3+"chk" && !Value && !ComIsEmpty(formObject.relay_port)){ 
			SheetRowRadioCheck(sheetObj,Row,Col,Value); 
			Sheet1ToSheet2Chk(sheetObj,sheetObjects[3],Row,Value);
			ComSetObjValue(formObject.selVVD20,"0");
			ComSetObjValue(formObject.selVVD40,"0");
			sheetObjects[1].RemoveAll();
		}				
		btnEnable(true);		 
	}

	/*
	* t2sheet1 OnChange 함수
	*/
    function t2sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObject = document.form;
		var sName = sheetObj.ColSaveName(Col); 
		 
		if(sName == prefix4+"chk" && Value && !ComIsEmpty(formObject.relay_port)){
			var sRow1=sheetObjects[2].FindCheckedRow(prefix3+"chk");
		    var arrRow1 = sRow1.split("|");
			Sheet2ToSheet1Chk(sheetObj,sheetObjects[2],Row,Value);
			if (arrRow1.length>1){
				if (sheetObj.CellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
					ComSetObjValue(formObject.selBKG20,ComParseInt(formObject.selBKG20)+1); 
				}else {
					ComSetObjValue(formObject.selBKG40,ComParseInt(formObject.selBKG40)+1);
				}
			}
		}else if(sName == prefix4+"chk" && !Value && !ComIsEmpty(formObject.relay_port) 
			&& (ComParseInt(formObject.selBKG20) >0 ||ComParseInt(formObject.selBKG40) >0)){
			if (sheetObj.CellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
				ComSetObjValue(formObject.selBKG20,ComParseInt(formObject.selBKG20)-1); 
			}else{
				ComSetObjValue(formObject.selBKG40,ComParseInt(formObject.selBKG40)-1);
			}
			var sRow2=sheetObjects[3].FindCheckedRow(prefix4+"chk");
	        var arrRow2 = sRow2.split("|");  
			if (arrRow2.length==1){
				sheetObjects[2].CheckAll2(prefix3+"chk")="0";
				sheetObjects[1].RemoveAll();
				ComSetObjValue(formObject.selVVD20,"0");
				ComSetObjValue(formObject.selVVD40,"0"); 
			}else{
				//doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
			}
		}

		sheetObjects[4].RemoveAll(); 
		
		var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
		var arrRow = sRow.split("|");
		var sRow2 = sheetObjects[1].FindCheckedRow(prefix2+"chk"); 
		var arrRow2;
		var sBkgNo=" "; 
		var idx=1;
		for (var iRow=0;iRow<arrRow.length-1;iRow++) {
			if (sBkgNo !=sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no")) {
				sBkgNo = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no"); 	
				sheetObjects[4].DataInsert(-1);			
				sheetObjects[4].CellValue2(idx,prefix5+"bkg_no") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no");			
				sheetObjects[4].CellValue2(idx,prefix5+"pol_cd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"pol_cd");	
				sheetObjects[4].CellValue2(idx,prefix5+"former_vvd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"former_vvd");
				sheetObjects[4].CellValue2(idx,prefix5+"old_next_vvd") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd");
				sheetObjects[4].CellValue2(idx,prefix5+"before_tmnl") = sheetObjects[3].CellValue(arrRow[iRow],prefix4+"tmnl");
				if (sRow2) {
					arrRow2 = sRow2.split("|");
					if (arrRow2 && 0<arrRow2.length) {
						sheetObjects[4].CellValue2(idx,prefix5+"next_vvd") = sheetObjects[1].CellValue(arrRow2[0],prefix2+"next_vvd");
						sheetObjects[4].CellValue2(idx,prefix5+"op_cd") = sheetObjects[1].CellValue(arrRow2[0],prefix2+"op_cd");
						sheetObjects[4].CellValue2(idx,prefix5+"next_tmnl") = sheetObjects[1].CellValue(arrRow2[0],prefix2+"next_tmnl");
						sheetObjects[4].CellValue2(idx,prefix5+"next_seq") = sheetObjects[1].CellValue(arrRow2[0],prefix2+"next_seq");
					}
				}
				idx++;			
			}
		}
		btnEnable(true);
	}

	/*
	* Form 초기화 
	*/
	function initForm(){
		var formObject = document.form;
		 formObject.etb_from.value=ComGetNowInfo();
		 formObject.etb_to.value=ComGetNowInfo();
		 //ComClearObject(formObject.relay_port);
		 formObject.relay_port.value=formObject.baseRelayPort.value;
		 ComClearObject(formObject.oldRelayPort);
		 ComClearObject(formObject.former_vvd);
		 ComClearObject(formObject.pol_cd);  
		 ComClearObject(formObject.next_vvd);
		 ComClearObject(formObject.pod_cd);
		 ComClearObject(formObject.next_port); 
		 ComClearObject(formObject.vsl_nm); 
		 ComClearObject(formObject.eta); 
		 ComClearObject(formObject.etd); 

		 ComClearObject(formObject.nextVvdFor);
		 
		 ComSetObjValue(formObject.total20,"0");
		 ComSetObjValue(formObject.total40,"0");
		 ComSetObjValue(formObject.selBKG20,"0");
		 ComSetObjValue(formObject.selBKG40,"0");
		 ComSetObjValue(formObject.selVVD20,"0");
		 ComSetObjValue(formObject.selVVD40,"0");

		 formObject.rc_flg.checked=false;
		 formObject.dcgo_flg.checked=false;
		 formObject.awk_cgo_flg.checked=false;
		 formObject.rd_cgo_flg.checked=false;
		 formObject.next_vvd_select[0].checked=true;
		 
		 sheetObjects[0].RemoveAll();
		 sheetObjects[1].RemoveAll();
		 sheetObjects[2].RemoveAll();
		 sheetObjects[3].RemoveAll();
		 sheetObjects[4].RemoveAll();
		 tabObjects[0].SelectedIndex=0;
		 btnEnable(true); 		  
	}
	
	/*
	* Tab안에 있는 Sheet2 Cell팝업 클릭 이벤트
	*/
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		var bkgNo = sheetObj.CellValue(Row,prefix4+"bkg_no");
		var param="?bkg_no="+bkgNo+"&pgmNo=ESM_BKG_0079";
		with(sheetObj){			
			var sName = ColSaveName(Col);			 
			switch(sName){
				case prefix4+"dcgo_flg":
					//freezing관련 작업
//					ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
					comBkgCallPopBkgDetail(bkgNo);
					break;
					
				case prefix4+"rc_flg":
					//freezing관련 작업
//					ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
					comBkgCallPopBkgDetail(bkgNo);
					break;
				
				case prefix4+"awk_cgo_flg":
					//freezing관련 작업
//					ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
					comBkgCallPopBkgDetail(bkgNo);
					break;
					
				case prefix4+"st":
					//freezing관련 작업
//					ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
					comBkgCallPopBkgDetail(bkgNo);
					break;					
			}
		}
	}

	/*
	 * KeyPress Event 처리
	 */
    function bkg0387_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;		            
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
	}

	/*
	 * Activate Event 처리
	 */
	function bkg0387_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){ 
	    	case "etb_from":
	    		ComClearSeparator(event.srcElement);
    			break;    			
	    	case "etb_to":
	    		ComClearSeparator(event.srcElement);
    			break;     			
    		default:
    			break;   			 
    	}
    }
	 
	/*
	 * Deactivate Event 처리
	 */
	function bkg0387_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "etb_from":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "etb_to":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }
	
	/*
	* 컨테이너별 합계를 구하는 함수
	*/
	function fitSum(formObj,sheetObj){
		var fit20=0;
		var fit40=0;
		 
		with(sheetObj){
			for(var iRow=1;iRow<Rows;iRow++){
				if (!ComIsEmpty(CellValue(iRow,prefix3+"fit20"))){
					fit20+=ComParseInt(CellValue(iRow,prefix3+"fit20"));
					fit40+=ComParseInt(CellValue(iRow,prefix3+"fit40"));
				}				
			}
			ComSetObjValue(formObj.total20,fit20);
			ComSetObjValue(formObj.total40,fit40);
		}		
	}

    /*
	* 그리드 에서 여러 행에 대한 체크박스를 라디오버튼 처리
	*/
	function SheetRowRadioCheck(sheetObj,Row,Col,Value){
		 sheetObj.CheckAll2(Col)=0;
         sheetObj.CellValue2(Row,Col)=Value;
    }
	
	/*
	* Tab1 시트에서 nextPort체크시 Tab2시트에 해당하는 NextPort체크
	*/
	function Sheet1ToSheet2Chk(sheetObj1,sheetObj2,Row,Value){ 
		var formObject=document.form; 
		sheetObj2.CheckAll2(prefix4+"chk")="0"; 
		ComSetObjValue(formObject.selBKG20,"0"); 
		ComSetObjValue(formObject.selBKG40,"0"); 
		for(var iRow=1;iRow<sheetObj2.Rows;iRow++){
			if (sheetObj1.CellValue(Row,prefix3+"next_port")==(sheetObj2.CellValue(iRow,prefix4+"next_port")+sheetObj2.CellValue(iRow,prefix4+"next_port_yard")) ){
				sheetObj2.CellValue2(iRow,prefix4+"chk")=Value;
				if (Value){
					if (sheetObj2.CellValue(iRow,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
						ComSetObjValue(formObject.selBKG20,ComParseInt(formObject.selBKG20)+1); 
					}else {
						ComSetObjValue(formObject.selBKG40,ComParseInt(formObject.selBKG40)+1);
					}
				}
			}
		}
	}

	/*
	* Tab2 시트에서 nextPort체크시 Tab1시트에 해당하는 NextPort체크
	*/
	function Sheet2ToSheet1Chk(sheetObj2,sheetObj1,Row,Value){ 
		var formObject=document.form; 
		var sRow1=sheetObj1.FindCheckedRow(prefix3+"chk");
		var arrRow1 = sRow1.split("|"); 
		
		var sRow2=sheetObj2.FindCheckedRow(prefix4+"chk");
	    var arrRow2 = sRow2.split("|"); 
		if (arrRow1.length==1){ 
			if (arrRow2.length==1) return; 
			for(var iRow=0;iRow<arrRow2.length-1;iRow++){
				sheetObj2.CellValue2(arrRow2[iRow],prefix4+"chk")="1";
				if (sheetObj2.CellValue(arrRow2[iRow],prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
						ComSetObjValue(formObject.selBKG20,ComParseInt(formObject.selBKG20)+1); 
				}else {
					ComSetObjValue(formObject.selBKG40,ComParseInt(formObject.selBKG40)+1);
				}
			}
			 
			for(var iRow=1;iRow<sheetObj1.Rows;iRow++){
				if (sheetObj1.CellValue(iRow,prefix3+"next_port")==(sheetObj2.CellValue(Row,prefix4+"next_port")+sheetObj2.CellValue(Row,prefix4+"next_port_yard")) ){
					sheetObj1.CellValue2(iRow,prefix3+"chk")=Value; 
					sheetObj2.CellValue2(Row,prefix4+"chk")=Value; 
					
					if (Value){
						ComSetObjValue(formObject.selVVD20,sheetObj1.CellValue(iRow,prefix3+"fit20")); 
						ComSetObjValue(formObject.selVVD40,sheetObj1.CellValue(iRow,prefix3+"fit40")); 
						ComSetObjValue(formObject.nextVvdFor,"t1sheet1_"); 
					}
					 
					doActionIBSheet(sheetObjects[1],formObject,COMMAND02);	
				}
			} 
		}else if (arrRow2.length>1){ 
			nextVVDCheck(sheetObjects[3],Row,sheetObjects[3].CellValue(Row,prefix4+"next_port")+sheetObjects[3].CellValue(Row,prefix4+"next_port_yard")); 
		}
	}

	/*
	* 시트에서 nextVVD값이 다른것을 체크 확인
	*/
	function nextVVDCheck(sheetObj,Row,nextPort){
		var formObject=document.form;
		var sRow=sheetObj.FindCheckedRow(prefix4+"chk");
		var arrRow = sRow.split("|"); 
		if (arrRow.length==1) return;
		for(var iRow=0;iRow<arrRow.length-1;iRow++){
			if ((sheetObj.CellValue(arrRow[iRow],prefix4+"next_port")+sheetObj.CellValue(arrRow[iRow],prefix4+"next_port_yard")) !=nextPort){
				sheetObj.CellValue2(Row,prefix4+"chk")="0";
				if (sheetObj.CellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
					ComSetObjValue(formObject.selBKG20,ComParseInt(formObject.selBKG20)-1); 
				}else {
					ComSetObjValue(formObject.selBKG40,ComParseInt(formObject.selBKG40)-1);
				}
				ComShowCodeMessage("BKG00215");
				break;
			}
		}
	}
	 
	/**
	 * fnAutoratingRfaAvailable  
	 * AutoratingRfa 유효성 체크
	 * @param v_bkg_no 
	 * @param v_rfa_no 
	 * @param v_date
	 * @return boolean
	 */    
	function fnSearchBkgVvdCheck(sheetObj,v_bkg_no) {
	 	var input_text = v_bkg_no ;
	 	var param = param + "&f_cmd=" + SEARCH03 + "&input_text=" + input_text;
	 	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	 	var output_text = ComGetEtcData(sXml, "output_text");
	 	if ('Y' == output_text) {	
	 		ComShowCodeMessage("BKG08153"); 	 		
	 	}else{
	 		//
	 	}
	 	return true;
	}
	 
	/*
	* sheet Row별 Assian 처리
	*/
	function sendAction(sheetObj,params,assignFlag){
		var bRtn=true;
		var iRtn=0;
		var bfalg=false;
		var sXml="";
		var sVvd="";
		var sTmnl="";
		var sNextPort="";
		var sNextYd="";
		var sBeforeTmnl="";
		var saveParams=""
		if (assignFlag=="C"){
			/* 임종한 과장님 요청 VVD Cancel 시 HJXX 를 넣지 않는다 
			 * 2010.04.22 김태경
			 * */
//			sVvd="SMXX0001E";
			sVvd="";
		}else{
			var sRow1=sheetObjects[1].FindCheckedRow(prefix2+"chk");
			var arrRow1 = sRow1.split("|");
			sVvd=sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_vvd");
			sTmnl=sheetObjects[1].CellValue(arrRow1[0],prefix2+"relay_tmnl");
			/* Next Port Yard Setting 을 위해 */
			sNextPort=sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_tmnl").substring(0,5);
			sBeforeTmnl =sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_tmnl");
			if((sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_tmnl")).length == 5){
				sNextYd="";
			}else{
				sNextYd=sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_tmnl").substring(5,7);
			}
		}
		/* 기존 Assign 된 VVD 와 동일 VVD 를 Assign 할경우 
		 * skip 하고 Save Message 2010.05.03 임종한 과장님 요청
		 * Sheet5번을 넘겨줄때 이미 Assign 된 정보는 삭제하여 Assign 시 Skip 할수 있도록 한다
		 */
		for(var iRow = sheetObj.LastRow; iRow>=sheetObj.HeaderRows; iRow--){
			if((sheetObjects[4].CellValue(iRow,prefix5+"former_vvd") == sheetObjects[4].CellValue(iRow,prefix5+"next_vvd"))
					&& (sheetObjects[4].CellValue(iRow,prefix5+"next_tmnl") == sheetObjects[4].CellValue(iRow,prefix5+"before_tmnl"))){
				var findRow = sheetObjects[3].FindText(prefix4 + "bkg_no",sheetObjects[4].CellValue(iRow,prefix5+"bkg_no"));
				sheetObjects[4].RowDelete(iRow,false);
			}
		}
		// Row 가 없을 경우 Return 시킴
		if(sheetObjects[4].Rowcount == 0) return;
		
		for(var iRow=1;iRow<sheetObjects[4].Rowcount+1;iRow++){		
//			if(fnSearchBkgVvdCheck(sheetObj, sheetObj.CellValue(iRow,prefix5+"bkg_no"))){
				sheetObj.CellValue2(iRow,prefix5+"chk")="1";
				saveParams = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				sXml = sheetObj.GetSaveXml("ESM_BKG_0387GS.do", saveParams);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if (State=="S"){
					sheetObj.CellValue2(iRow,prefix5+"chk")="0";  
					if (iRow==sheetObj.Rows-1) bfalg=true;
					iRtn=sheetBackColor(iRtn,sheetObj.CellValue(iRow,prefix5+"bkg_no"),bfalg,sVvd,sTmnl,sNextPort,sNextYd,sBeforeTmnl); 
				}else{
					bRtn=false;
					sheetObj.LoadSearchXml(sXml); 
					break;
				}
//			}
		}
		return sXml;
	}
    
	/*
	* 처리된 Sheet 폰트 색상처리
	*/
	function sheetBackColor(iRtn,bkgNo,flag,sVvd,sTmnl,sNextPort,sNextYd,sBeforeTmnl){
		var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
		var arrRow = sRow.split("|");  
		if(iRtn == undefined) return;
		for(var idx=iRtn;idx<arrRow.length-1;idx++){
			if(bkgNo ==sheetObjects[3].CellValue(arrRow[idx],prefix4+"bkg_no")){
				sheetObjects[3].RowFontColor(arrRow[idx])=sheetObjects[3].RgbColor(0, 051, 255);
				sheetObjects[3].CellFont("FontBold",arrRow[idx],2,arrRow[idx],21) = true;
				sheetObjects[3].CellValue2(arrRow[idx],prefix4+"next_vvd")=sVvd;
				sheetObjects[3].CellValue2(arrRow[idx],prefix4+"tmnl")=sTmnl;
				sheetObjects[3].CellValue2(arrRow[idx],prefix4+"next_port")=sNextPort;
				sheetObjects[3].CellValue2(arrRow[idx],prefix4+"next_tmnl")=sBeforeTmnl;
				if(sNextYd.length > 0){
					sheetObjects[3].CellValue2(arrRow[idx],prefix4+"next_port_yard")=sNextYd;
				}
				if (flag) {
					sheetObjects[3].SelectCell((ComParseInt(arrRow[idx])+1),0);
				}else{
					sheetObjects[3].SelectCell(arrRow[idx],0);
				}
			}
			else{
				return idx;
			}
		}
	}

	/*
	* Remark값이 있는 셀 색상설정
	*/
	function setRmkBackColor(){
		if (sheetObjects[3].Rows<2) return; 
		for(var idx=1;idx<sheetObjects[3].Rows;idx++){
			var vvdRows1,vvdRows2;
			/* By Booking Color 변경 */
			if (sheetObjects[3].CellValue(idx,prefix4+"rmk")=="Y"){
				sheetObjects[3].RowBackColor(idx)=sheetObjects[3].RgbColor(204, 255, 252);
				/* By VVD & POD Color 변경 */
				vvdRows1 = ComFindText(sheetObjects[2],prefix3+"next_port",sheetObjects[3].CellValue(idx,prefix4+"next_tmnl"));
				vvdRows2 = ComFindText(sheetObjects[2],prefix3+"next_vvd",sheetObjects[3].CellValue(idx,prefix4+"next_vvd"));
				if (vvdRows1 && vvdRows2 && 0<vvdRows1.length && 0<vvdRows2.length) {
					for (var idx2=0; idx2<vvdRows1.length; idx2++) {
						for (var idx3=0; idx3<vvdRows2.length; idx3++) {
							if (vvdRows1[idx2]==vvdRows2[idx3]) {
//if (!ComIsEmpty(sheetObjects[2].CellValue(vvdRows1[idx2],prefix3+"next_vvd")) && !ComIsEmpty(sheetObjects[3].CellValue(idx,prefix4+"next_vvd")))
//{
								sheetObjects[2].RowBackColor(vvdRows1[idx2]) = sheetObjects[2].RgbColor(204, 255, 252);
//}
							}
						}
					}
				}
			} 
		}
	}
	
	/*
	* 버튼 활성비활성 처리
	*/
	function btnEnable(flag){
		if (flag){
			ComBtnEnable("btn_cancelassign");
			ComBtnEnable("btn_vvdassign");
		}else{
			ComBtnDisable("btn_cancelassign");
			ComBtnDisable("btn_vvdassign");
		}
	}

	/*
	* Click Event처리
	*/
	function bkg0387_click(){
		var formObject = document.form; 
		switch(event.srcElement.name){ 
	    	case "rc_flg":
				formObject.dcgo_flg.checked=false;
				formObject.awk_cgo_flg.checked=false;
				formObject.rd_cgo_flg.checked=false; 
    			break;
	    	case "dcgo_flg":
	    		formObject.rc_flg.checked=false;
				formObject.awk_cgo_flg.checked=false;
				formObject.rd_cgo_flg.checked=false;  
    			break; 
			case "awk_cgo_flg":
	    		formObject.rc_flg.checked=false;
				formObject.dcgo_flg.checked=false;
				formObject.rd_cgo_flg.checked=false;  
    			break; 
			case "rd_cgo_flg":
	    		formObject.rc_flg.checked=false;
				formObject.dcgo_flg.checked=false;
				formObject.awk_cgo_flg.checked=false;
    			break; 
    	}  
	}

	/*
	* t2sheet1 OnMouseDown 이벤트처리
	*/
	function t2sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y) {
		if (Shift==1){
			with(sheetObj){
				var sRow=FindCheckedRow(prefix4+"chk");
			    var arrRow = sRow.split("|");
				if (arrRow.length==1) return;
				var iStart=arrRow[0];
				var iEnd=MouseRow;
				var nextVvd=CellValue(iStart,prefix4+"next_vvd");
				 
				for(var idx=iStart;idx<iEnd;idx++){
					if (CellValue(idx,prefix4+"next_vvd")==nextVvd){
						CellValue2(idx,prefix4+"chk")=1;
					}					
				}
			}
		}			
	}
	
	function checkTsCloseByBayPlan(){
		closedVvds = "";		
		var sRow1=sheetObjects[1].FindCheckedRow(prefix2+"chk");
		var arrRow1 = sRow1.split("|");
		var param = "f_cmd="+SEARCH01+"&new_vvd=" + sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_vvd")

		var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
		var arrRow = sRow.split("|"); 
		
		var cnt = 0;
		for(var iRow=0;iRow<arrRow.length-1;iRow++){
			if(sheetObjects[1].CellValue(arrRow1[0],prefix2+"next_vvd")
						!= sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd")){
				param = param + "&bkg_no="+sheetObjects[3].CellValue(arrRow[iRow],prefix4+"bkg_no")
							  + "&next_vvd="+sheetObjects[3].CellValue(arrRow[iRow],prefix4+"next_vvd")
								+"&ibflag=R";;
				cnt++;				
			}
		}

		if(cnt==0) return true;
		
		ComOpenWait(true);
		var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_1157GS.do?"+param);
		ComOpenWait(false);		

		closedVvds = ComGetEtcData(sXml, "closedVvds");
		if(closedVvds != null && closedVvds.length > 0){
			ComShowCodeMessage("BKG08253",closedVvds);
		}
		return true;
	}
	/* 개발자 작업  끝 */