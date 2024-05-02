/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0017.js
*@FileTitle : ERP Interface - OW Master / Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.12 이호선
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
     * @class ees_mst_0017 : ees_mst_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
    }

/* 개발자 작업	*/
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

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
				case "btn_retrieve":
				    if (formObject.de_yrmon.value.length < 7) {
			    	   ComShowCodeMessage("MST00001","Delivery Month");
			      	   return;
			    	}
			        if (formObject.type[0].checked == true){
			        	sheetObject2.RemoveAll();
			        	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			        }
			        else {
			        	sheetObject1.RemoveAll();
			        	doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			        }
				break;

				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					tabObjects[0].selectedIndex = 0;
					formObject.type[0].checked = true;
					formObject.if_cd.value = "0";
					formObject.de_yrmon.value = "";

			        //첫번째 IBShseet의 데이터만 먼저 조회한다.
				    var today = new Date();
				    if (today.getMonth() < 9){
				    	formObject.de_yrmon.value = String(today.getYear())+ "-0" + String(today.getMonth()+1);
				    } else {
				    	formObject.de_yrmon.value = String(today.getYear())+ "-" + String(today.getMonth()+1);
				    }
					sheetObject1.HeadCheck(0,"sel") = false;
					sheetObject2.HeadCheck(0,"sel") = false;
				break;

				case "btn_save":
			        if (formObject.type[0].checked == true){
			        	//선택된것만 저장 대상으로 선별한다.
		        		var iCheckRow = sheetObject1.FindCheckedRow("sel");

		        		//가져온 행을 배열로 반든다.
		        		var arrRow = iCheckRow.split("|");
		        		for(var i = 1; i <= sheetObject1.RowCount; i++){
		        			sheetObject1.RowStatus(i) = "R";
		        		}

		        		for (idx=0; idx<arrRow.length-1; idx++){
		        			sheetObject1.RowStatus(arrRow[idx]) = "U";
		        		}
			        	doActionIBSheet(sheetObject1,document.form,IBSAVE);
			        }
			        else{
			        	//선택된것만 저장 대상으로 선별한다.
		        		var iCheckRow = sheetObject2.FindCheckedRow("sel");

		        		//가져온 행을 배열로 반든다.
		        		var arrRow = iCheckRow.split("|");
		        		for(var i = 1; i <= sheetObject2.RowCount; i++){
		        			sheetObject2.RowStatus(i) = "R";
		        		}

		        		for (idx=0; idx<arrRow.length-1; idx++){
		        			sheetObject2.RowStatus(arrRow[idx]) = "U";
		        		}
			        	doActionIBSheet(sheetObject2,document.form,IBSAVE);
			        }
				break;

				case "btn_t1downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
				break;

				case "btn_t2downexcel":
					sheetObject2.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
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

        //탭 초기화하기
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        //IBSheet 초기화하기
        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

	     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		 axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
		 axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
		 axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때
		 axon_event.addListenerForm('click',	'obj_click',	    form); //- 키 눌렸을때

        //첫번째 IBShseet의 데이터만 먼저 조회한다.
	    /* var today = new Date();
	     if (today.getMonth() < 9){
	         document.form.de_yrmon.value = String(today.getYear())+ "-0" + String(today.getMonth()+1);
	     } else {
	    	 document.form.de_yrmon.value = String(today.getYear())+ "-" + String(today.getMonth()+1);
	     }*/
		 document.form.de_yrmon.value = "";
		 document.form.de_yrmon.focus();
    }

   	//Axon 이벤트 처리2. 이벤트처리함수
   	function obj_deactivate(){
   	    ComChkObjValid(event.srcElement);
   	}

   	function obj_activate(){
   	    ComClearSeparator(event.srcElement);
   	}

  	/**
 	* Key-Change Event 처리
	*/
	function obj_click() {
		var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		var formObj  = document.form;
		if (obj.name == "type") {
			if (formObj.type[0].checked == true){
				tabObjects[0].selectedIndex = 0;
			} else {
				tabObjects[0].selectedIndex = 1;
			}
		}
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
            case "t1sheet1":      // t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 380;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    var HeadTitle1 = "||Lot No.|TP/SZ|S/N Range|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|Spec No.|AGMT No.|Manufacturer|M/Facture Place|Creation Date|Result|A|B|C|D|E";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,    40,   daCenter,  false,   "sel");
                    InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,   "lot_no",      		  false,  "",       dfNone,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        45,   daCenter,  false,   "cntr_tpsz_cd",       false,  "",       dfNone,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        130,  daCenter,  false,   "ser_range",    	  false,  "",       dfNone,  	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        40,  	daRight,  false,   "cntr_qty",        	  false,  "",       dfNullInteger,   0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        80,   daRight,  false,   "cntr_aqz_amt",       true,   "",       dfNullFloat,     2,   true,		true);
                    InitDataProperty(0, cnt++, dtCombo,       115,  daCenter,  false,   "acct_qty_mzd_cd",    true,   "",       dfNone,     0,   true,		true);
                    InitDataProperty(0, cnt++, dtData,        120,  daLeft,  false,   "cntr_invst_no", 	  true,   "",       dfNone,     0,   true,		true, 20);
                    InitDataProperty(0, cnt++, dtPopup,        70,   daCenter,  false,   "cntr_curr_cd",   	  true,  "",       dfNone,     0,   true,		true);
                    InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "cntr_spec_no",       false,  "",       dfNone,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "agmt_no",     		  false,  "",       dfNone,   	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        100,   daCenter,  false,   "vndr_abbr_nm",   	  false,  "",       dfNone,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        100,   daCenter,  false,   "lot_loc_cd",     	  false,  "",       dfNone,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        100,   daCenter,  false,   "cre_dt",   		  false,  "",       dfDateYmd,  0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        90,  daCenter,  false,   "fa_if_grp_sts_cd",   false,  "",       dfDateYmd,  0,   false,		false);

                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "agmt_cty_cd",      false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "agmt_seq",         false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "fa_if_dt",         false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "lot_seq",          false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "lot_pln_yr",       false,  "",       dfNone,     0,   true,      true);

                    InitDataCombo(0, "acct_qty_mzd_cd", "General Asset|Financial Lease|Deferred Purchase", "0|1|2");
                    InitDataValid(0, "cntr_invst_no", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ "); //영문과 숫자
                }
                break;

            case "t1sheet2":      // t1sheet1 init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 150;

	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;

	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 10, 100);

	                var HeadTitle1 = "||Lot No.|TP/SZ|S/N Range|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|Spec No.|AGMT No.|Manufac turer|M/Facture Place|Creation Date|Result|A|B|C|D|E";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  true,    "ibflag");
	                InitDataProperty(0, cnt++, dtCheckBox,    40,   daCenter,  false,   "sel");
	                InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,   "lot_no",      		  false,  "",       dfNone,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        45,   daCenter,  false,   "cntr_tpsz_cd",       false,  "",       dfNone,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        130,  daCenter,  false,   "ser_range",    	  false,  "",       dfNone,  	0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        40,  	daRight,  false,   "cntr_qty",        	  false,  "",       dfNullInteger,   0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        60,   daRight,  false,   "cntr_aqz_amt",       true,   "",       dfNullFloat,     2,   true,		true);
	                InitDataProperty(0, cnt++, dtCombo,       115,  daCenter,  false,   "acct_qty_mzd_cd",    true,   "",       dfNone,     0,   true,		true);
	                InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,   "cntr_invst_no", 	  true,   "",       dfNone,     0,   true,		true);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "cntr_curr_cd",   	  true,  "",       dfNone,     0,   true,		true);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "cntr_spec_no",       false,  "",       dfNone,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "agmt_no",     		  false,  "",       dfNone,   	0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "vndr_abbr_nm",   	  false,  "",       dfNone,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "lot_loc_cd",     	  false,  "",       dfNone,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,   "cre_dt",   		  false,  "",       dfDateYmd,  0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        90,  daCenter,  false,   "fa_if_grp_sts_cd",   false,  "",       dfDateYmd,  0,   false,		false);

	                InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "agmt_cty_cd",      false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "agmt_seq",         false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "fa_if_dt",         false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "lot_seq",          false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "lot_pln_yr",       false,  "",       dfNone,     0,   true,      true);

	                InitDataCombo(0, "acct_qty_mzd_cd", "General Asset|Financial Lease|Deferred Purchase", "0|1|2");
	            }
            break;

            case "t2sheet1":      // t2sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 380;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    var HeadTitle1 = "||Term Change Seq.|TP/SZ|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|AGMT No.|Creation Date|Created By|Result|A|B|C";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,0,     daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,    40,    daCenter,  false,   "sel");
                    InitDataProperty(0, cnt++, dtData,        110,    daCenter,  false,   "term_cng_seq",      false,  "",       dfNone,  	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        45,    daCenter,  false,   "cntr_tpsz_cd",      false,  "",       dfNone,  	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        40,    daRight,  false,   "cntr_qty",          false,  "",       dfNullInteger,     0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        80,    daRight,  false,   "cntr_aqz_amt",  	  true,   "",       dfNullFloat,     2,   true,		true);
                    InitDataProperty(0, cnt++, dtCombo,       115,    daCenter,  false,   "acct_qty_mzd_cd",   true,   "",       dfNone,     0,   true,		true);
                    InitDataProperty(0, cnt++, dtData,       125,    daLeft,  false,   "cntr_invst_no",     true,   "",       dfNone,     0,   true,		true, 20);
                    InitDataProperty(0, cnt++, dtPopup,       70,    daCenter,  false,   "cntr_curr_cd",      false,  "",       dfNone,     0,   true,		false);
                    InitDataProperty(0, cnt++, dtData,        80,    daCenter,  false,   "agmt_no",  	      false,  "",       dfNone,  	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        90,    daCenter,  false,   "cre_dt",   	      false,  "",       dfNone,   	0,   false,		false);
                    InitDataProperty(0, cnt++, dtData,        70,    daCenter,  false,   "cre_usr_id",  	  false,  "",       dfNone,     0,   false,		false,	10,		false,	true,	"",	false);
                    InitDataProperty(0, cnt++, dtData,        60,    daCenter,  false,   "fa_if_grp_sts_cd",  false,  "",       dfNone,  	0,   false,		false);

                    InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "agmt_cty_cd",       false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "agmt_seq",          false,  "",       dfNone,     0,   true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "fa_if_dt",          false,  "",       dfNone,     0,   true,      true);

                    InitDataCombo(0, "acct_qty_mzd_cd", "General Asset|Financial Lease|Deferred Purchase", "0|1|2");
                    InitDataValid(0, "cntr_invst_no", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ "); //영문과 숫자

                    //PopupImage  =  "img/btns_search.gif";
                    //ShowButtonImage = 1;
                }
                break;

            case "t2sheet2":      // t2sheet1 init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 150;

	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;

	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 10, 100);

	                var HeadTitle1 = "|Sel.|Term Change Seq.|TP/SZ|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|AGMT No.|Creation Date|Created By|Result|A|B|C";

	                var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

	              // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,0,     daCenter,  true,    "ibflag");
	                InitDataProperty(0, cnt++, dtCheckBox,    40,    daCenter,  false,   "sel");
	                InitDataProperty(0, cnt++, dtData,        110,    daCenter,  false,   "term_cng_seq");
	                InitDataProperty(0, cnt++, dtData,        45,    daCenter,  false,   "cntr_tpsz_cd",      false,  "",       dfNone,  	0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        40,    daRight,  false,   "cntr_qty",          false,  "",       dfNullInteger,     0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        80,    daRight,  false,   "cntr_aqz_amt",  	  true,   "",       dfNullFloat,     2,   true,		true);
	                InitDataProperty(0, cnt++, dtCombo,       115,    daCenter,  false,   "acct_qty_mzd_cd",   true,   "",       dfNone,     0,   true,		true);
	                InitDataProperty(0, cnt++, dtData,       125,    daCenter,  false,   "cntr_invst_no",     true,   "",       dfNone,     0,   true,		true);
	                InitDataProperty(0, cnt++, dtPopup,       70,    daCenter,  false,   "cntr_curr_cd",      false,  "",       dfNone,     0,   true,		false);
	                InitDataProperty(0, cnt++, dtData,        80,    daCenter,  false,   "agmt_no",  	      false,  "",       dfNone,  	0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        90,    daCenter,  false,   "cre_dt",   	      false,  "",       dfNone,   	0,   false,		false);
	                InitDataProperty(0, cnt++, dtData,        70,    daCenter,  false,   "cre_usr_id",  	  false,  "",       dfNone,     0,   false,		false,	10,		false,	true,	"",	false);
	                InitDataProperty(0, cnt++, dtData,        670,    daCenter,  false,   "fa_if_grp_sts_cd",  false,  "",       dfNone,  	0,   false,		false);

	                InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "agmt_cty_cd",       false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "agmt_seq",          false,  "",       dfNone,     0,   true,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     85,    daCenter,  true,    "fa_if_dt",          false,  "",       dfNone,     0,   true,      true);

	                InitDataCombo(0, "acct_qty_mzd_cd", "General Asset|Financial Lease|Deferred Purchase", "0|1|2");

	                //PopupImage  =  "img/btns_search.gif";
	                //ShowButtonImage = 1;
	             }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
			        if (formObj.type[0].checked == true)
			            formObj.hid_type.value = "0"
			        else
			        	formObj.hid_type.value = "1";

			        sheetObj.WaitImageVisible=false;
			        ComOpenWait(true);
			        formObj.f_cmd.value = SEARCH;
					if (sheetObj.id == "t1sheet1")
						sheetObj.DoSearch("EES_MST_0017GS.do", FormQueryString(formObj));
					else if (sheetObj.id == "t2sheet1")
						sheetObj.DoSearch("EES_MST_0017GS.do", FormQueryString(formObj));
					ComOpenWait(false);

					for (var i = 1; i <= sheetObj.RowCount; i++){
						sheetObj.MinimumValue(i, "cntr_aqz_amt") = 0;
						var grpstscd = sheetObj.CellValue(i, "fa_if_grp_sts_cd");

						if (grpstscd == "Sending" || grpstscd == "Completed" || grpstscd == "Error"){
							sheetObj.CellEditable(i,"sel") = false;
						}
					}
				}
			break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					formObj.f_cmd.value = MULTI;
					if(ComShowCodeConfirm("COM130101")){
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
					    sheetObj.DoSave("EES_MST_0017GS.do", FormQueryString(formObj), -1, false);
					    ComOpenWait(false);
					}

					doActionIBSheet(sheetObj,document.form,IBSEARCH);
				}
			break;

			case IBINSERT:      // 입력
			break;
        }
    }

    function obj_keypress(){

        obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;

        switch(obj.dataformat) {
            case "ym":
                if(obj.name=="de_yrmon") ComKeyOnlyNumber(this, "-");
            break;
        }
    }

 	function obj_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		if (obj.name == "de_yrmon") {
	  		if (vKeyCode == 13) {
			    if (formObj.de_yrmon.value.length < 6) {
			    	ComShowCodeMessage("MST00001","Delivery Month");
			      	return;
			    }
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();

				if (formObj.type[0].checked == true)
				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH)
				else
				   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	  		}
 		}
 	}

    /*
    * Calendar Display
    */
    function popCalendar(type){
   	 var formObj = document.form;
        var cal = new ComCalendar();
        cal.setDisplayType('month');
        cal.select(formObj.de_yrmon, "yyyy-MM");
    }

 	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[1];
		if ( aryPopupData.length > 0 ) {
			sheetObj.CellValue(Row,Col) = aryPopupData[0][2];
		}
	}

	function setPopData_Currency1(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			sheetObj.CellValue(Row,Col) = aryPopupData[0][2];
		}
	}

    /**
     * 아이비시트 팝업 클릭시 이벤트
     */
    function t2sheet1_OnPopupClick(sheetObj, Row,Col,Value){
    	 if (sheetObj.ColSaveName(Col) == "cntr_curr_cd"){
        	 var param = "cnt_cd=&curr_cd="+sheetObj.CellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/hanjin/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 500, 420, 'setPopData_Currency', '0,0,1', true, true, Row, "cntr_curr_cd", 1);
    	 }
    }

    function t1sheet1_OnPopupClick(sheetObj, Row,Col,Value){
     	 if (sheetObj.ColSaveName(Col) == "cntr_curr_cd"){
         	 var param = "cnt_cd=&curr_cd="+sheetObj.CellValue(Row,Col)+"&curr_desc=";
         	 ComOpenPopup('/hanjin/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 500, 420, 'setPopData_Currency1', '0,0,1', true, true, Row, "cntr_curr_cd", 1);
     	 }
    }

    function t1sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
			var sMsg = ComGetMsg("MST01025", "", "", "");
			ComShowMessage (sMsg);
        }
    }

    function t2sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
			var sMsg = ComGetMsg("MST01025", "", "", "");
			ComShowMessage (sMsg);
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "OW Master" , -1 );
                    InsertTab( cnt++ , "Term Change Master" , -1 );
                }
            break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , tabIndex){
       	var formObj = document.form;
    	if (tabIndex == "0" && formObj.type[0].checked == false)
    		formObj.type[0].checked = true
    	else if (tabIndex == "1" && formObj.type[1].checked == false)
    		formObj.type[1].checked = true;

        var objs = document.all.item("tabLayer");

        objs[tabIndex].style.display = "Inline";
        objs[beforetab].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[tabIndex].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= tabIndex;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }

    function setsheetRowColorBlack1(cnt){
   	 	 var formObj = document.form;
	   	 for (var i = 1; i <= 15; i++){
	   	    sheetObjects[2].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(0, 0, 0);
	   	 }
    }

    function setsheetRowColorBlack2(cnt){
  	 	 var formObj = document.form;
	   	 for (var i = 1; i <= 12; i++){
	   	    sheetObjects[3].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(0, 0, 0);
	   	 }
    }

    function setsheetRowColorRed1(cnt){
	   	 var formObj = document.form;
	   	 for (var i = 1; i <= 15; i++){
	   		sheetObjects[2].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(255, 0, 0);
	   	 }
    }

    function setsheetRowColorRed2(cnt){
	   	 var formObj = document.form;
	   	 for (var i = 1; i <= 12; i++){
	   		sheetObjects[3].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(255, 0, 0);
	   	 }
    }