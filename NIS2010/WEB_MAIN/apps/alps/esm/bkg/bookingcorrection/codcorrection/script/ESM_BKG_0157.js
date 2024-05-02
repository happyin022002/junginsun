/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0157.js
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
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
     * @class ESM_BKG_0157 : ESM_BKG_0157 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0157() {
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
						if (validateForm(sheetObject,formObject,IBSEARCH)){
							doActionIBSheet(sheetObject,formObject,IBSEARCH); 
						}
                    break; 
					case "btn_Duration":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
					break;

					case "btn_DownExcel":
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

					case "btn_CodInquiry":
						if (!ComIsEmpty(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_no"))){
							bkg0156PopUp(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_no"),sheetObject.CellValue(sheetObject.SelectRow,prefix1+"cod_rqst_seq"));
						}
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
		 
        initDate(document.form);
		axon_event.addListenerFormat('keydown',	'bkg0157_keydown', document.form); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','bkg0157_keypress',document.form); 
		axon_event.addListenerForm('beforedeactivate', 'bkg0157_obj_deactivate',  document.form); //- 포커스 나갈때
	    axon_event.addListenerFormat('beforeactivate',   'bkg0157_obj_activate',    document.form); //- 포커스 들어갈때
		 
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetId = sheetObj.id;

		switch(sheetId) {
			case "sheet1":      //sheet1 init
				with (sheetObj) {

                    // 높이 설정
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
					// SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D
                    InitHeadMode(false, false, false, true, false,false);

                    var HeadTitle1 = "|Seq.|Booking No.|R|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|OLD Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|NEW Booking Route|CNTR\nQ'ty|Approval Result";
                    var HeadTitle2 = "|Seq.|Booking No.|R|POR|POL|POD|DEL|PRE|POST|T/VVD|POR|POL|POD|DEL|PRE|POST|T/VVD|CNTR\nQ'ty|Approval Result";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,		true,		prefix1+"seq",		    false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					90,  	daCenter,		true,		prefix1+"bkg_no",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				    30,		daCenter,		true,		prefix1+"cod_rqst_seq", false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_por",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_pol",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_pod",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_del",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_pre",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"old_post",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix1+"old_t_vvd",	false,			"",      dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_por",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_pol",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_pod",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_del",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_pre",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		prefix1+"new_post",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		prefix1+"new_t_vvd",	false,			"",      dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		prefix1+"cntr_qty",		false,			"",      dfNullInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		prefix1+"approval_result",			false,			"",      dfNone,			0,		false,		false);
					
					ColumnSort(prefix1+"approval_result");
				}
				break;



        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = sheetObj.id+"_"; 
        switch(sAction) {
			 case IBSEARCH:      //조회  
				formObj.f_cmd.value = SEARCH; 
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0157GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix)); 
					sheetObj.Redraw = false;   
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true; 
                break;
			 case IBSEARCHAPPEND:	//조회(페이징처리)
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_BKG_0157GS.do", CondParam, "iPage="+ PageNo, true);
				break;
			 case IBDOWNEXCEL:      // 엑셀다운   
				sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,arrPreFix+"cod_rqst_seq|");
				break;
		}   
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
         /*if (ComIsEmpty(dur_from)||ComIsEmpty(dur_to)){
			 ComShowCodeMessage("BKG00702");
			 return false;
         }else if(ComIsEmpty(bkg_ofc_cd)){
			  return false;
		 }*/

	   }
        return true;
    }

	/*
	* ESM_BKG_0156호출
	*/
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH){
		with (sheetObj){
			if (!ComIsEmpty(CellValue(Row,prefix1+"bkg_no"))){
				bkg0156PopUp(CellValue(Row,prefix1+"bkg_no"),CellValue(Row,prefix1+"cod_rqst_seq"));
			}
		}
	}

	/**
	 * Sheet의 OnScrollNext Event 처리부분.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	
	 /**
      *  화면 날짜 입력폼 초기화 처리
      */
     function initDate(formObj){
    	 with(formObj){
    		 dur_from.value=ComGetDateAdd(ComGetNowInfo(),"D", -15);
    		 dur_to.value=ComGetNowInfo();
    	 }
     }

    /*
	 * KeyPress Event 처리
	 */
    function bkg0157_keypress(){
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
 	function bkg0157_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		if ( vKeyCode == 13 ) {
			if (validateForm(sheetObjects[0],formObj,IBSEARCH)){
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH); 
			}
 		}
 	}
	 /*
	 * Activate Event 처리
	 */
	function bkg0157_obj_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "dur_from":
	    		ComClearSeparator(event.srcElement);
    			break; 
			case "dur_to":
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    			 
    	}
    }
	
	/*
	 * Deactivate Event 처리
	 */
    function bkg0157_obj_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "dur_from":
	    		ComAddSeparator(event.srcElement);
    			break; 
			case "dur_to":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }
	
	/*
	* ESM_BKG_156 화면 호출
	*/
	function bkg0156PopUp(bkgNo,codRqstSeq){

//    	var sUrl = "/hanjin/alpsMain.screen";
//    	sUrl += "?parentPgmNo=ESM_BKG_M001";
//    	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0156_Q.do";
//    	sUrl += "&pgmNo=ESM_BKG_0156_Q";
//    	sUrl += "&bkg_no="+bkgNo;
//    	sUrl += "&cod_rqst_seq="+codRqstSeq;
//		sUrl +="&popFlg=S";
//    	
//    	ComOpenWindowCenter(sUrl, "ESM_BKG_0156_Q", 1024, 730, true); 	
		var param="?mainPage=false&bkg_no="+bkgNo;
		param+="&cod_rqst_seq="+codRqstSeq;
		param+="&popFlg=S";
		param+="&pgmNo=ESM_BKG_0156_Q";
 		ComOpenWindowCenter("/hanjin/ESM_BKG_0156_P.do"+param, "ESM_BKG_0156", 1024, 730, true, "yes");
	}

	/* 개발자 작업  끝 */