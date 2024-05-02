/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0107.js
*@FileTitle : Office Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.14 최우석
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
     * @class fns_inv_0078 : fns_inv_0078 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0078() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.obj_keypress			= obj_keypress;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
     * 
     * @return 없음
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
     		var srcName = window.event.srcElement.getAttribute("name");
     			switch(srcName) {
     				case "btn_retrive":
     					doActionIBSheet(sheetObject,formObject,IBSEARCH);
     					break;

     				case "btn_new":
     					ComResetAll();
     					doActionIBSheet(sheetObject,formObject,IBRESET);
     					break;

     				case "btn_downExcel":
     					sheetObject1.SpeedDown2Excel(1);
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     * 
     * @return 없음
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
//			sheetObjects[i].ExtendLastCol = false;
    	}
    	
    	initControl();
    }

    /**
     * 시트 초기설정값, 헤더 정의<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     * 
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:      //t1sheet1 init
    			with (sheetObj) {
    				//높이 설정
    				style.height = 480;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);                     
                     
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "AR OFC|Sales OFC|H/Q|Region Code|Center Code|AP Cur|AR Cur|Credit Term|Credit Term|Rep. Customer|INV Prefix|SUB-AGT|AGT MK|SO MK|ASA Credit|Fixed Ex.Rate\n(USD:LCL)|DEL";
                    var HeadTitle2 = "AR OFC|Sales OFC|H/Q|Region Code|Center Code|AP Cur|AR Cur|O/B|I/B|Rep. Customer|INV Prefix|SUB-AGT|AGT MK|SO MK|ASA Credit|Fixed Ex.Rate\n(USD:LCL)|DEL";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++, dtDataSeq, 40,    	daCenter,  	true,    "seq",     			false,      "",      dfInteger,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_ofc_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    70,    	daCenter,  	true,    "ofc_cd",     			false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_hd_qtr_ofc_cd",   	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    80,    	daCenter,  	true,    "finc_rgn_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    80,    	daCenter,  	true,    "ar_ctr_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "bil_curr_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_curr_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    40,    	daRight,  	true,    "ob_cr_term_dys",     	false,      "",      dfInteger,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    40,    	daRight,  	true,    "ib_cr_term_dys",     	false,      "",      dfInteger,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    90,    	daCenter,  	true,    "rep_type",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    70,    	daCenter,  	true,    "inv_pfx_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    60,    	daCenter,  	true,    "sub_agn_flg",     	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_agn_stl_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "so_if_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    70,    	daRight,  	true,    "asa_cr_term_dys",    	false,      "",      dfInteger,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    90,    	daRight,  	true,    "fx_curr_rt",     		false,      "",      dfFloat,		3,	false,	false,	0);
                    InitDataProperty(0, cnt++, dtData,    30,    	daCenter,  	true,    "delt_flg",     		false,      "",      dfNone,		0,	false,	false,	0);
                    
                    SetSortDialog(false);
    			}
    			break;
    		case 2:      //t1sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 0;
	                //전체 너비 설정
	                SheetWidth = 0;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);                     
	                 
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                var HeadTitle1 = "AR OFC|Sales OFC|H/Q|Region Code|Center Code|AP Cur|AR Cur|Credit Term(O/B)|Credit Term(I/B)|Rep. Customer|INV Prefix|SUB-AGT|AGT MK|SO MK|ASA Credit|Fixed Ex.Rate\n(USD:LCL)|DEL";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	                 
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                 
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                //InitDataProperty(0, cnt++, dtDataSeq, 40,    	daCenter,  	true,    "seq",     			false,      "",      dfInteger,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_ofc_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    70,    	daCenter,  	true,    "ofc_cd",     			false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_hd_qtr_ofc_cd",   	false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    80,    	daCenter,  	true,    "finc_rgn_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    80,    	daCenter,  	true,    "ar_ctr_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "bil_curr_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_curr_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    40,    	daRight,  	true,    "ob_cr_term_dys",     	false,      "",      dfInteger,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    40,    	daRight,  	true,    "ib_cr_term_dys",     	false,      "",      dfInteger,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    90,    	daCenter,  	true,    "rep_type",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    70,    	daCenter,  	true,    "inv_pfx_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    60,    	daCenter,  	true,    "sub_agn_flg",     	false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "ar_agn_stl_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    50,    	daCenter,  	true,    "so_if_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    70,    	daRight,  	true,    "asa_cr_term_dys",    	false,      "",      dfInteger,		0,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    90,    	daRight,  	true,    "fx_curr_rt",     		false,      "",      dfFloat,		3,	false,	false,	0);
	                InitDataProperty(0, cnt++, dtData,    30,    	daCenter,  	true,    "delt_flg",     		false,      "",      dfNone,		0,	false,	false,	0);
	                
	                SetSortDialog(false);
				}
				break;
         }
    }
     
    /**
  	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다.<br>
  	 *
  	 * @param {object} sheetObj
  	 * @param {int} sheetNo
  	 * @return 없음
  	 * @see #loadPage
  	 **/
  	function initControl() {
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerForm('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  	}

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
	    	case IBSEARCH:      //조회
	    		formObj.f_cmd.value = SEARCH;
//	    		sheetObj.DoSearch("FNS_INV_0107GS.do", FormQueryString(formObj));
	    		var sXml = sheetObj.GetSearchXml("FNS_INV_0107GS.do", FormQueryString(formObj));
   	   	  		var arrXml = sXml.split("|$$|");
   	   	  		if (arrXml.length > 0) {
	   	  			sheetObjects[0].LoadSearchXml(arrXml[0]);
	   	  			sheetObjects[1].LoadSearchXml(arrXml[0]);
	   	  		}
	    		break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool;
     */
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 dataformat Validation을 체크한다.<br>
     *
     * @return bool
     * @see #initControl
     */
	function obj_keypress(){
		if(event.srcElement.dataformat == "int") {
			ComKeyOnlyNumber(event.srcElement);
		} else if(event.srcElement.dataformat == "engup") {
	 		ComKeyOnlyAlphabet('upper');
		}
		
		if(window.event.keyCode == 13) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
	/* 개발자 작업  끝 */