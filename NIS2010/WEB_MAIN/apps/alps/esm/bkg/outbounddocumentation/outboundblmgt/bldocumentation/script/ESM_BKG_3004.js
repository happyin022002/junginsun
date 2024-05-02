/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_3004.js
*@FileTitle : Manage Interface
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 김태경
*@LastVersion : 1.0
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
     * @class esm_bkg_3004 : esm_bkg_3004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_3004() {
        this.processButtonClick   = processButtonClick;
        this.setSheetObject       = setSheetObject;
        this.loadPage             = loadPage;
        this.initSheet            = initSheet;
        this.initControl          = initControl;
        this.doActionIBSheet      = doActionIBSheet;
        this.setTabObject         = setTabObject;
        this.validateForm         = validateForm;
    }

    /* 개발자 작업    */

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var prefix ="";

	var intervalId;
	var intervalTime = 3000;
	var processCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	 var sheetObj = sheetObjects[0];
    	 var formObj  = document.form;

    	try{
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    			case "btns_calendar1":
    				//cal = new calendarPopupFromTo();
    				var cal = new ComCalendarFromTo();
    				cal.displayType = "date";
    				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');						
    			  break;
    		
    			case "btn_retrieve":
  
	    			if (!validateForm(sheetObjects[beforetab],formObj,IBSEARCH)) return false;
    				doActionIBSheet(sheetObjects[beforetab],formObj,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObjects[beforetab].RemoveAll();
    				formObj.reset();
    				break;
    			
    			case "btn_transmit":
    				
    				if (beforetab == 0) {
    					ibtask = MULTI01;
    				} else if (beforetab == 1) {
    					ibtask = MULTI02;
    				} else if (beforetab === 2) {
    					ibtask = MULTI03;
    				} else if (beforetab == 3) {
    					ibtask = MULTI04;
    				} else if (beforetab == 4) {
    					ibtask = MULTI05;
    				}
    				doActionIBSheet(sheetObjects[beforetab], formObj, ibtask)
    				break;
    		}
    	}catch(e){
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
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
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	 for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
    	 initControl();
    }
     
     function initControl() {
     	var formObject = document.form;

         axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
         axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
         axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ('change', 'bkg_change', formObject);
     }
              
/*********************** KEY EVENT START ********************/ 	 
function bkg_keypress(){
    switch(event.srcElement.dataformat){
    	case "ymd":
    		//number
    		ComKeyOnlyNumber(event.srcElement, "-");
    		break;
    	case "engup":
    		//영문대문자
			ComKeyOnlyAlphabet('upper');
			break;
    	case "engupnum":
    		//숫자+"영문대분자"입력하기
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "num":
    	  	//숫자 입력하기
    	  	ComKeyOnlyNumber(event.srcElement);
    	  	break;
    	case "custname":
    	  	//영문,숫자,공백,기타문자(.,등)
    	  	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
    	  	break;	            
      	default:
      		break;
    }
}  
       /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:	  //IBSheet1 init
    			with (sheetObj) {

    				//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(7, 8, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle0 = "|Sel|BKG NO|VVD|POL|POD|VPS ETD" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);
    				prifix ="t1sheet1_";
    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,  20,	daCenter,  true,	prifix+"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtCheckBox,  40,	daCenter,  true,	prifix+"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prifix+"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"vvd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pol_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	80,		daCenter,	true,	prifix+"vps_etd_dt",	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				style.height = GetSheetHeight(20) ;
    			//	DataLinkMouse = true;
    		   }
    			break;
    			
    			
    		case 2:	  //IBSheet1 init
    			with (sheetObj) {

    				//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(7, 8, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle0 = "|Sel|BKG NO|VVD|POL|POD|VPS ETD" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);

    				prifix ="t2sheet1_";
    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,  20,	daCenter,  true,	prifix+"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtCheckBox,  40,	daCenter,  true,	prifix+"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prifix+"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"vvd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pol_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	80,		daCenter,	true,	prifix+"vps_etd_dt",	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				style.height = GetSheetHeight(20) ;
    		   }
    			break;
    			
    		case 3:	  //IBSheet1 init
    			with (sheetObj) {

    				//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(7, 8, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle0 = "|Sel|BKG NO|VVD|POL|POD|VPS ETD" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);

    				prifix ="t3sheet1_";
    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,  20,	daCenter,  true,	prifix+"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtCheckBox,  40,	daCenter,  true,	prifix+"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prifix+"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"vvd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pol_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prifix+"pod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	80,		daCenter,	true,	prifix+"vps_etd_dt",	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				style.height = GetSheetHeight(20) ;
    		   }
    			break;
    			
    		case 4:	  //IBSheet1 init
    			with (sheetObj) {

    				//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				//Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(23, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle1 = "|Sel.|Seq.|Booking No.|B/L No.|Customer Code|Name|Group EDI ID|EDI Ref|EDI Receive|Receiver Name|VVD|POR|POL|POD|DEL|Sent Time|Sent ID|Sent Status|ACK|Sent Nm||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    prifix ="t4sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prifix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prifix+"slct_flg",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		prifix+"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prifix+"bkg_no",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		prifix+"bl_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prifix+"cust_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		false,		prifix+"cust_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prifix+"group_edi_id",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prifix+"edi_ref",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prifix+"rcv_id",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		false,		prifix+"receiver_name",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prifix+"vvd",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		prifix+"por_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		prifix+"pol_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prifix+"pod_cd",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prifix+"del_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prifix+"sent_dt",			false,			"",      dfDateYmd,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prifix+"snd_usr_id",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prifix+"sent_status",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prifix+"ack",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		prifix+"snd_usr_nm");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		prifix+"group_id");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		prifix+"ref_code");
		
					ShowButtonImage = 2;
					sheetObj.FrozenCols = 5;
					style.height = GetSheetHeight(20) ;
    		   }
    			break;
    			
    		case 5:	  //IBSheet1 init
    			with (sheetObj) {

    				//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(15, 8, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);

    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

    			//	DataLinkMouse = true;
    		   }
    			break;
    	}
    }

     
        
      // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false ;
    	switch (sAction) {
    		case IBSEARCH: // 조회
	    		try {
	                formObj.f_cmd.value = SEARCH01;
					if (beforetab == 0) {
		                var rXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam("t1sheet1_"));
		                var arrXml = rXml.split("|$$|");
						sheetObjects[0].LoadSearchXml(arrXml[0]);
    				} else if (beforetab == 1) {
    					var rXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam("t2sheet1_"));
		                var arrXml = rXml.split("|$$|");
    					sheetObjects[1].LoadSearchXml(arrXml[0]);
    				} else if (beforetab === 2) {
    					var rXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam("t3sheet1_"));
		                var arrXml = rXml.split("|$$|");
    					sheetObjects[2].LoadSearchXml(arrXml[0]);
    				} else if (beforetab == 3) {
    					formObj.f_cmd.value = SEARCH02;
    		        	var rXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam("t4sheet1_"));
    		            var arrXml = rXml.split("|$$|");
    					sheetObjects[3].LoadSearchXml(arrXml[0]);
    				} else if (beforetab == 4) {
    					sheetObjects[4].LoadSearchXml(arrXml[0]);
    				}
					
					}finally{
						ComOpenWait(false);
					}
    			break;
    			
    		case MULTI01: // 
    			formObj.f_cmd.value = MULTI01;
    			var sXml = sheetObj.GetSaveXml("ESM_BKG_3004GS.do", FormQueryString(formObj)  + "&" +  sheetObj.GetSaveString(false,true,1));
    			
    			if ("ERROR"==sXml.substring(1,6)){
    				ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
    			} else {
    				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
    				if ("S"==State) {
    					ComShowCodeMessage("BKG06082");
    					return;
    				}
    			}
    			break;	
    			
    		case MULTI02: // 
    			formObj.f_cmd.value = MULTI02;
    			var sXml = sheetObj.GetSaveXml("ESM_BKG_3004GS.do", FormQueryString(formObj)  + "&" +  sheetObj.GetSaveString(false,true,1));
    			
    			if ("ERROR"==sXml.substring(1,6)){
    				ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
    			} else {
    				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
    				if ("S"==State) {
    					ComShowCodeMessage("BKG06082");
    					return;
    				}
    			}
    			break;
    		case MULTI03: // 
    			formObj.f_cmd.value = MULTI03;
    			var sXml = sheetObj.GetSaveXml("ESM_BKG_3004GS.do", FormQueryString(formObj)  + "&" +  sheetObj.GetSaveString(false,true,1));
    			
    			if ("ERROR"==sXml.substring(1,6)){
    				ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
    			} else {
    				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
    				if ("S"==State) {
    					ComShowCodeMessage("BKG06082");
    					return;
    				}
    			}
    			break;	 
    		case MULTI04: // 
    			formObj.f_cmd.value = MULTI04;
    			try{
		    			ComOpenWait(true);
						var params = FormQueryString(formObj);
						params = params + "&" + sheetObjects[3].GetSaveString(false,true,1);
						
						var sXml = sheetObj.GetSaveXml("ESM_BKG_3004GS.do", params);
				    	var arrXml = sXml.split("|$$|");
						if (ComGetEtcData(arrXml[0], "jobID")) {
							ComSetObjValue(formObj.key, ComGetEtcData(arrXml[0], "jobID"));
				            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
						} else {  //backendJob 호출 실패
							ComOpenWait(false);
						}
    			}finally{
					ComOpenWait(false);
				}
    			break;
    			
    		case SEARCH03: // BackEndJob 상태 조회(루프)
	    		try{
	    			ComOpenWait(true);
	    			formObj.f_cmd.value = SEARCH03;
			    	params = FormQueryString(formObj);
			    	var sXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", params);
			    	var arrXml = sXml.split("|$$|");
					var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
					if ("3"==jobState) {  // BackEndJob 성공
						clearInterval(intervalId);
			            doActionIBSheet(sheetObj, document.form, SEARCH04);  // BackEndJob 결과 조회
					} else if ("4"==jobState) {  // BackEndJob 실패
						clearInterval(intervalId);
						ComOpenWait(false);
						ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
					} else if ("5"==jobState) {  // 이미 BackEndJob 결과 파일을 읽었습니다.
						clearInterval(intervalId);
						ComOpenWait(false);
					}
	    		}finally{
					ComOpenWait(false);
				}
					break;

	    	case SEARCH04: // BackEndJob 결과 조회
		    	try{
	    			ComOpenWait(true);
		    		formObj.f_cmd.value = SEARCH04;
			    	params = FormQueryString(formObj);
			    	var sXml = sheetObj.GetSearchXml("ESM_BKG_3004GS.do", params);
			    	var arrXml = sXml.split("|$$|");
			    	if ("Y"==ComGetEtcData(arrXml[0], "result")) {
			    		clearInterval(intervalId);
						ComOpenWait(false);
						ComShowCodeMessage("BKG00204");
					} else if ("N"!=ComGetEtcData(arrXml[0], "result")) {  // BackEndJob 9분30초 경과
						ComShowMessage(ComGetEtcData(arrXml[0], "result"));
						ComOpenWait(false);
					} else { // EDI 전송 중 Exception 발생
						clearInterval(intervalId);
						ComOpenWait(false);
						ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
					}
			    	break;
		    	}finally{
					ComOpenWait(false);
				}
    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var result = true;
    	if(sAction == IBSEARCH) {
    		// 검색 조건 입력 여부
    		if( ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) &&(ComIsEmpty(formObj.fm_dt) && ComIsEmpty(formObj.to_dt))) {
    			result = false ;
    		}
    		if(result == false){
    			ComShowMessage(ComGetMsg('BKG00545'));
    		}
    	}
    	return result;
    }

    function isInputField(formObj){
    	var result    = false ;
    	var fieldType = null ;
    	for(i=0; i<formObj.length; i++){
    		fieldType = formObj[i].type

    		if((fieldType=="checkbox" || fieldType=="radio")){
    			if(formObj[i].checked){
    				result = true ;
    				break ;
    			}
    		}
    		else if(fieldType!="hidden" && !formObj[i].readOnly){
    			if(!ComIsEmpty(formObj[i])){
    				result = true ;
    				break ;
    			}
    		}
    	}

    	if(!result){
    		ComShowMessage(ComGetMsg('BKG00104')) ;
            formObj.bkg_no.focus() ;
    	}
    	return result ;
    }

    function sheet1_OnSearchEnd(sheetObj) {
    	var totalCnt = sheetObj.CellValue(3, "totcnt");
    	
    	if(sheetObj.TotalRows > 0){
    		sheetObj.TotalRows = totalCnt;
    	}
    	ComAddSeparator(document.form.fm_dt, "-");
    	ComAddSeparator(document.form.to_dt, "-");
    }


    function ComChkObjValid(obj, len, msg) {
    	var result = true ;
    	if(getLenByByte(obj.value)!==len){
    		ComShowMessage(ComGetMsg('BKG00404', msg, len));
            obj.focus() ;
            result = false ;
    	}
    	return result ;
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

         var cnt  = 0 ;

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    InsertTab( cnt++, "BKG - INV" , -1 );
                    InsertTab( cnt++, "BKG - COA" , -1 );
                    InsertTab( cnt++, "BKG - SCE" , -1 );
                    InsertTab( cnt++, "BKG - 310 EDI" , -1 );
//                    InsertTab( cnt++, "BKG - FAX/EML" , -1 );
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

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab = nItem;
    }
     
 	
     // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
     function openAddPaste(bkgNo){
     	var formObj = document.form;
     	var bkg_no = formObj.bkg_no.value;
     	var _Width = '400';
 		var _Height = '420';
     	var newWin = ComOpenWindow("ESM_BKG_9457.do?bkg_no="+formObj.bkg_no.value, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
     }
 	
     // Pop UP 에서 입력된 No 를 전달 받는다.
     function addValueNo(multi_value){
     	var multis = multi_value.split('\n');
      	multi_value = '';
     	for(var i = 0 ; i < multis.length ; i++){
 			if(i == 0){
 				multi_value = multis[i];
 			}else{
 				multi_value = multi_value + ',' + multis[i];
 			}
    		}
     	if(multi_value != ''){
     		document.getElementById('bkg_no').value = multi_value;	
     	}
 	}

   //BackEndJob 상태 조회용 루프 함수
     function callIntervalBackEndJob() {
     	if (600==processCnt++) {  //intervalTime(3초) * 600 = 30분
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		return;
     	}
     	doActionIBSheet(sheetObjects[beforetab], document.form, SEARCH03);
     }