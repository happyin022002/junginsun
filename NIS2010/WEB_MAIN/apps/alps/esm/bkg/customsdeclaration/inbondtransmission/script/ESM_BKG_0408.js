/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0408.js
 *@FileTitle : P/MIB Generate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.07.20 김도완
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
 * @class ESM_BKG-0408 : ESM_BKG-0408 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0408() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1SelRow = 0;

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

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;

                case "btn_Mi_History":
                	//ComOpenWindow2("ESM_BKG_0819.do?pgmNo=ESM_BKG_0819", "ESM_BKG_0819", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
                	
    				sUrl = "ESM_BKG_0819.do?";
    				sParam = "";
    				ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0819", 1000, 590, false);
                    break;

				case "btn_Save":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    break;
					
				case "btn_DownExcel1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
                    break;	
				case "btn_DownExcel2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND01);
                    break;

				case "btn_PMibAssign":
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
                    break;
                    
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI02);
					break;

				case "btn_EntryTypeSetUp":
					//ComOpenWindow2("ESM_BKG_0540.do?pgmNo=ESM_BKG_0540", "ESM_BKG_0540", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
    				sUrl = "ESM_BKG_0540.do?";
    				sParam = "pgmNo=ESM_BKG_0540";
    				ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0540", 1000, 680, false);

					break;
				case "btn_Bl_Inquiry1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND02);
                    break;	
				case "btn_Bl_Inquiry2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND02);
                    break;	
				case "btn_Cntr_Inquiry1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND03);
                    break;	
				case "btn_Cntr_Inquiry2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND03);
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
        initControl();

        //US AMS Main Menu : VVD 입력시
    	if (!ComIsNull(document.form.vvd)) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    	
    }
    
	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		// hub수정권한을 조회한다
   		doActionIBSheet(sheetObjects[0], formObj, COMMAND20);
        document.form.vvd.focus();
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
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	
     	var formObject = document.form;
     	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
         //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
         //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
         axon_event.addListenerFormat('keypress',       'obj_KeyPress2',    formObject); //- 키보드 입력할때
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
         axon_event.addListener('click', 'chkClick', 'form'); 
         //axon_event.addListener('change', 'chkClick', 'form');
         axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
                    style.height = 112;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|Sel.|Seq.|HUB|DEL|Customs|In-bond Type|P/MIB NO.|Total B/L|In-Bond B/L|Local Clearance|||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix= "sheet1_";

                    //데이터속성   	 [ROW, COL, DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	130,	daCenter,	false,	prefix +"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	prefix +"chk",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,	false,	prefix +"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix +"hub_loc_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix +"del_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix +"cstms_loc_cd",		false,			"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix +"ibd_tp_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	prefix +"ibd_trsp_no",		false,			"",      dfNone,			0,		false,		true);
					//InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix +"IRGHUB",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		130,	daCenter,	true,	prefix +"total_bl_cnt",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		130,	daCenter,	true,	prefix +"inbond_bl_cnt",	false,			"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daCenter,	true,	prefix +"local_bl_cnt",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"lcl_flg",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"vvd",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"pod_cd",			false,			"",      dfNone,			0,		false,		true);
					
					//InitDataCombo(0, prefix +"ibd_tp_cd", "61(IT)|62(T&E)|63(IE)", "61|62|63");
					CountPosition = 0;
               }
                break;
                
            case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 272;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    
                    var HeadTitle1 = "|Sel.|Seq.|B/L No.|DEL|L.USA|HUB|Entry\nType|In-bond\nType|P/MIB No.|TOTAL\nPackage|C|Customs|R/D\nTerm|R/D\nTerm|Consignee/Notify|Consignee/Notify|||||||||" ;
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix = "";

                  //데이터속성   	 [ROW, COL, DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	130,	daCenter,	false,	prefix +"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	prefix +"chk",				false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,	false,	prefix +"seq");
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix +"bl_no",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix +"del_cd",			false,	"",      dfNone,			0,		false,		true);
										
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix +"usa_lst_loc_cd",	false,	"",      dfEngUpKey,		0,		true,		true, 	5);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix +"hub_loc_cd",		false,	"",      dfEngUpKey,		0,		true,		true, 	5);					
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	prefix +"cstms_clr_tp_cd",	false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix +"ibd_trsp_tp_cd",	false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix +"ibd_trsp_no",		false,	"",      dfNone,			0,		false,		true);
									
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix +"pck_qty",			false,	"",      dfNullInteger,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"dspo_cd",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix +"cstms_loc_cd",		false,	"",      dfEngUpKey,		0,		true,		true,	5);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"rcv_term_cd",		false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"de_term_cd",		false,	"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix +"cust_seq",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	prefix +"cust_nm",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"lcl_flg",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"vvd",				false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"pod_cd",			false,	"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cstms_clr_tp_cd_chg",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"ibd_trsp_tp_cd_chg",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_usa",					false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_entry",				false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_tp",					false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_hub",					false,	"",      dfNone,			0,		true,		true);
										
					InitDataCombo(0, prefix +"ibd_trsp_tp_cd", 	"61(IT)|62(T&E)|63(IE)", 	"61|62|63");
					InitDataCombo(0, prefix +"cstms_clr_tp_cd", "P/MIB|Local", 				"I|L");
					InitDataValid(0, prefix +"usa_lst_loc_cd", vtEngUpOther," ");
					InitDataValid(0, prefix +"hub_loc_cd", vtEngUpOnly);
					InitDataValid(0, prefix +"cstms_loc_cd", vtEngUpOnly);
					CountPosition = 0;
               }
                break;
                
            case 3:      //sheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 272;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    
                    var HeadTitle1 = "|Sel.|Seq.|B/L No.|DEL|L.USA|HUB|Entry\nType|In-bond\nType|P/MIB No.|TOTAL\nPackage|C|Customs|R/D\nTerm|R/D\nTerm|Consignee/Notify|Consignee/Notify|||||||||" ;
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix = "";

                    //데이터속성   	 [ROW, COL, DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	130,	daCenter,	false,	prefix +"ibflag");
  					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	prefix +"chk",				false,	"",      dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,	false,	prefix +"seq");
  					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix +"bl_no",			false,	"",      dfNone,			0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix +"del_cd",			false,	"",      dfNone,			0,		false,		true);
  										
  					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix +"usa_lst_loc_cd",	false,	"",      dfEngUpKey,		0,		true,		true, 	5);
  					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix +"hub_loc_cd",		false,	"",      dfEngUpKey,		0,		true,		true,	5);					
  					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	prefix +"cstms_clr_tp_cd",	false,	"",      dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix +"ibd_trsp_tp_cd",	false,	"",      dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix +"ibd_trsp_no",		false,	"",      dfNone,			0,		false,		true);
  									
  					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix +"pck_qty",			false,	"",      dfNullInteger,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"dspo_cd",			false,	"",      dfNone,			0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix +"cstms_loc_cd",		false,	"",      dfEngUpKey,		0,		true,		true,	5);
  					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"rcv_term_cd",		false,	"",      dfNone,			0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix +"de_term_cd",		false,	"",      dfNone,			0,		false,		true);
  					
  					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix +"cust_seq",			false,	"",      dfNone,			0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	prefix +"cust_nm",			false,	"",      dfNone,			0,		false,		true);
  					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"lcl_flg",			false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"vvd",				false,	"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix +"pod_cd",			false,	"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cstms_clr_tp_cd_chg",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"ibd_trsp_tp_cd_chg",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_usa",					false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_entry",				false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_tp",					false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"old_hub",					false,	"",      dfNone,			0,		true,		true);
  										
  					InitDataCombo(0, prefix +"ibd_trsp_tp_cd", 	"61(IT)|62(T&E)|63(IE)", 	"61|62|63");
  					InitDataCombo(0, prefix +"cstms_clr_tp_cd", "P/MIB|Local", 				"I|L");
					InitDataValid(0, prefix +"usa_lst_loc_cd", vtEngUpOther," ");
					InitDataValid(0, prefix +"hub_loc_cd", vtEngUpOnly);
					InitDataValid(0, prefix +"cstms_loc_cd", vtEngUpOnly);
  					CountPosition = 0;
               }
                break;
            case 4:      //sheet4 init
            with (sheetObj) {

                // 높이 설정
                style.height = 40;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "||HUB|DEL|P/MIB NO.||";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                var prefix= "";

                //데이터속성   	 [ROW, COL, DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	130,	daCenter,	false,	prefix +"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	false,	prefix +"chk",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix +"hub",		false,			"",      dfNone,			0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix +"del",			false,			"",      dfNone,			0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	prefix +"pmib_no",		false,			"",      dfNone,			0,		false,		true);
				
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix +"vvd",				false,			"",      dfNone,			0,		false,		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix +"pod",			false,			"",      dfNone,			0,		false,		true);
				
				CountPosition = 0;
           }
            break;

        }
    }

     
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,row) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
	        case COMMAND20:
	    		
	        	formObj.f_cmd.value = INIT;
					
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0408GS.do", FormQueryString(formObj));
				var hubModifyYn = ComGetEtcData(sXml, "hubModifyYn");
				var cstmsModifyYn = ComGetEtcData(sXml, "cstmsModifyYn");
				
				//alert("hubModifyYn : " + hubModifyYn);
				formObj.hubModifyYn.value = hubModifyYn;
				formObj.cstmsModifyYn.value = cstmsModifyYn;
	
				break;
		
	        case IBSEARCH:      //조회
	        	
		  		if (validateForm(sheetObj, formObj, sAction))
		  		{
		  			formObj.f_cmd.value = SEARCH;	  			
		  			
		  			sheetObj.DoSearch("ESM_BKG_0408GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		  	   	  	
		  		}
		  		
		  		break;
		  		
	
	    	case SEARCH01:      // Double Click 조회
	    		
	    		var sheetObject2 = sheetObjects[1];
	    		formObj.f_cmd.value = SEARCH01;
	    		sheet1SelRow = row;
	
	    		formObj.h_vvd.value = sheetObj.CellValue(row, "sheet1_vvd");
	    		formObj.h_pod.value = sheetObj.CellValue(row, "sheet1_pod_cd");
	    		formObj.h_hub.value = sheetObj.CellValue(row, "sheet1_hub_loc_cd");
	    		formObj.h_del.value = sheetObj.CellValue(row, "sheet1_del_cd");
	    		formObj.h_cstms.value = sheetObj.CellValue(row, "sheet1_cstms_loc_cd");
	    		
	    		//sheetObjects[1].DoSearch("ESM_BKG_0408GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"));
	    		
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0408GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if(arrXml.length > 0)
					sheetObjects[1].LoadSearchXml(arrXml[0]);
				if(arrXml.length > 1)
					sheetObjects[2].LoadSearchXml(arrXml[1]);
				
				var sheet2RowCnt = sheetObjects[1].RowCount;
				var sheet2RowCnt2 = sheetObjects[2].RowCount;
				var hubModifyYn = formObj.hubModifyYn.value;
				var cstmsModifyYn = formObj.cstmsModifyYn.value;
				//alert("hubModifyYn : " + hubModifyYn);
				
				for(var i = 1; i <= sheet2RowCnt; i++) { // hub, customs 필드 Editable 설정
					if(hubModifyYn == "Y") {
						sheetObjects[1].CellEditable(i, "hub_loc_cd") = true;
					} else {
						sheetObjects[1].CellEditable(i, "hub_loc_cd") = false;
					}
					if(cstmsModifyYn == "Y") {
						sheetObjects[1].CellEditable(i, "cstms_loc_cd") = true;
					} else {
						sheetObjects[1].CellEditable(i, "cstms_loc_cd") = false;
					}
					
				}
				for(var i = 1; i <= sheet2RowCnt2; i++) { // hub, customs 필드 Editable 설정
					if(hubModifyYn == "Y") {
						sheetObjects[2].CellEditable(i, "hub_loc_cd") = true;
					} else {
						sheetObjects[2].CellEditable(i, "hub_loc_cd") = false;
					}
					if(cstmsModifyYn == "Y") {
						sheetObjects[2].CellEditable(i, "cstms_loc_cd") = true;
					} else {
						sheetObjects[2].CellEditable(i, "cstms_loc_cd") = false;
					}
					
				}
	    		break;
	
	    	case SEARCH02:      // PMIB NO Assign
		    	if (validateForm(sheetObj, formObj, sAction))
		  		{
		    		var sheetObject2 = sheetObjects[1];	    		
		    		var sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + SEARCH02+"&"+ComGetSaveString(sheetObjects[1]);
		    		
		    		//BKG00672 Are you sure to Assign?
		    		if (!ComShowCodeConfirm("BKG00672")) return;
		    		var topSheetSelectedRow = sheetObj.SelectRow;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0408GS.do", sParam);
					
					var s4 = sheetObjects[3];
					
					s4.LoadSearchXml(sXml);
					
					if(s4.RowCount > 0){
						ComShowCodeMessage('BKG06022');
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						sheetObj.SelectRow = topSheetSelectedRow;
						doActionIBSheet(sheetObj, document.form, SEARCH01, topSheetSelectedRow);
					}
		  		}
	    		break;
		
	        case IBSAVE:        //저장
	          	if(validateForm(sheetObj,formObj,sAction)){
	          		
		    		formObj.f_cmd.value = MULTI;
		    		
		    		//var sParam = ComGetSaveString(sheetObj) + 
		    		var sParam = "&f_cmd=" + MULTI+"&"+ComGetSaveString(sheetObjects[1])+
		    					"&"+ComGetSaveString(sheetObjects[2]);
		    		var sXml = sheetObj.GetSaveXml("ESM_BKG_0408GS.do", sParam);
					
					//sheetObj.LoadSaveXml(sXml);
					if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0)				
					{
						ComShowCodeMessage('BKG06022');
						/*
						 * 20100410 
						 * 저장 후 재조회 로직을 주석처리함(정민정 과장 요청)
						 */
//						doActionIBSheet(sheetObj, document.form, IBSEARCH);
//						sheetObj.SelectRow = sheet1SelRow;
//						doActionIBSheet(sheetObj, document.form, SEARCH01, sheet1SelRow);
					}else{
						ComShowCodeMessage('BKG00110');
					}
	          		
	          	}
	
	            break;
	        case COMMAND01:        //EXCEL DOWN 1, 2
		      	if(validateForm(sheetObj,formObj,sAction)){
		      		sheetObj.SpeedDown2Excel(-1);
		      	}
		
		        break;
	        
	        case MULTI02:      // Transmit.
		        if(validateForm(sheetObj,formObj,sAction)){
	
		    		formObj.f_cmd.value = MULTI02;
		    		 
		    		var sParam = "&f_cmd=" + MULTI02+"&"+ComGetSaveString(sheetObjects[0])+
		    					"&"+ComGetSaveString(sheetObjects[1]);
	
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true,true);
		    		var sXml = sheetObj.GetSaveXml("ESM_BKG_0408GS.do", sParam);
		    		if (ComBkgErrMessage(sheetObj, sXml)) {
			    		var key = ComGetEtcData(sXml, "KEY");
						intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		    		} else {
		    			ComOpenWait(false);
		    		}
		      	}
	        	break;
	        case COMMAND02:        //B/L Inquiry
		      	if(validateForm(sheetObj,formObj,sAction)){
		      		var selRow = sheetObj.SelectRow;
		      		var bl_no = sheetObj.CellValue(selRow, "bl_no");
		      		var param ="bl_no="+bl_no; 
					
		      		ComOpenWindowCenter("ESM_BKG_0034.do?pgmNo=ESM_BKG_0034-03&"+param, "ESM_BKG_0034", 1024, 660, true);
		      	}
	
	        	break;
	        case COMMAND03:        //CNTR Inquiry
		      	if(validateForm(sheetObj,formObj, COMMAND02)){
		      		var selRow = sheetObj.SelectRow;
		      		var bl_no = sheetObj.CellValue(selRow, "bl_no");
		      		var param ="bl_no="+bl_no; 
					
	        		ComOpenWindow2("ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&"+param, "ESM_BKG_0036", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,width=836,height=500");
		      	}
		
	        	break;
        }
    }


    /**
     * BackEndJob 실행결과조회.
     */
    function doActionValidationResult(sheetObj, sKey) {
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0408GS.do?f_cmd=" + SEARCH03
    			+ "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
    	
    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('BKG00101');
    		doActionIBSheet(sheetObj, document.form, SEARCH01, sheet1SelRow);	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		// 에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
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
                    InsertTab( cnt++ , "In-Bond B/L" , -1 );
                    InsertTab( cnt++ , "Local Clearance" , -1 );

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
	    	beforetab= nItem;
		

    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case SEARCH02:
				var ibd_trsp_no = "";
				var chked = 0;
				var prefix = "sheet1_";
				for(var i = 1; i < sheetObj.RowCount+1; i++){
					if(sheetObj.CellValue(i, prefix+"chk") == 1){

//						ibd_trsp_no = sheetObj.CellValue(i, prefix+"ibd_trsp_no");
//						if(ibd_trsp_no != ""){
//							ComShowCodeMessage("BKG01110"); //P/MIB No. already exist.
//							return false;
//						}
						if(sheetObj.CellValue(i, prefix+"inbond_bl_cnt") == "" ||
								sheetObj.CellValue(i, prefix+"inbond_bl_cnt") == " "){
							ComShowCodeMessage("BKG01111"); //Only In-Bond B/L can be assigned.
							return false;
						}
						chked++;
					}
				}
				
				for(var i = 1; i < sheetObjects[1].RowCount+1; i++){
					if(sheetObjects[1].CellValue(i, "chk") == 1){
//						ibd_trsp_no = sheetObjects[1].CellValue(i, "ibd_trsp_no");
//						if(ibd_trsp_no != ""){
//							ComShowCodeMessage("BKG01110"); //P/MIB No. already exist.
//							return false;
//						}
						
						if(sheetObjects[1].CellValue(i, "hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //HUB City 정보가 없습니다
							return false;
						}
						chked++;
					}
				}
				
				for(var i = 1; i < sheetObjects[2].RowCount+1; i++){
					if(sheetObjects[2].CellValue(i, "chk") == 1){
						ComShowCodeMessage("BKG01111"); //Only In-Bond B/L can be assigned.
						return false;
					}
				}
				if(chked == 0){
					ComShowCodeMessage("BKG00249"); //No Selected Row
					return false;
				}
				return true;
				break;	
			case IBSAVE:
				var ibd_trsp_no = "";
				var chked = 0;
				var prefix = "";
				var localChangeCnt = 0;
				for(var i = 1; i < sheetObjects[1].RowCount+1; i++){
					if(sheetObjects[1].RowStatus(i) == "U"){
						if(sheetObjects[1].CellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //HUB City 정보가 없습니다
							return false;
						}
						if(sheetObjects[1].CellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[1].CellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[1].CellValue(i, prefix+"usa_lst_loc_cd") == ""){
								
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						if(sheetObjects[1].CellValue(i, "cstms_clr_tp_cd_chg") == "Y" &&
								sheetObjects[1].CellValue(i, "cstms_clr_tp_cd") == "L")
						{
							localChangeCnt++;
						}
						chked++;
					}
				}
				for(var i = 1; i < sheetObjects[2].RowCount+1; i++){
					if(sheetObjects[2].RowStatus(i) == "U"){
						if(sheetObjects[2].CellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //HUB City 정보가 없습니다
							return false;
						}
						if(sheetObjects[2].CellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[2].CellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[2].CellValue(i, prefix+"usa_lst_loc_cd") == ""){
								
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						if(sheetObjects[2].CellValue(i, "cstms_clr_tp_cd_chg") == "Y" &&
								sheetObjects[2].CellValue(i, "cstms_clr_tp_cd") == "L")
						{
							if(! ComShowCodeConfirm("BKG01108")) return false;
						}
						chked++;
					}
				}
				if(localChangeCnt > 0){
					if(! ComShowCodeConfirm("BKG01108")) return false;
				}
				if (sheetObjects[1].IsDataModified == false){
					if (sheetObjects[2].IsDataModified == false){
						ComShowCodeMessage("BKG00233"); //변경된 내역이 없습니다.					
						return false;
					}
				}
				
				return true;
				break;	
			case COMMAND01:
				if(sheetObj.RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				return true;
				break;	
			case MULTI02:
				var ibd_trsp_no = "";
				var chked = 0;
				var prefix = "sheet1_";
				for(var i = 1; i < sheetObj.RowCount+1; i++){
					if(sheetObj.CellValue(i, prefix+"chk") == 1){
						if(sheetObjects[1].CellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //HUB City 정보가 없습니다
							return false;
						}
						chked++;
					}
				}
				prefix = "";
				for(var i = 1; i < sheetObjects[1].RowCount+1; i++){
					if(sheetObjects[1].CellValue(i, prefix+"chk") == 1){
						if(sheetObjects[1].CellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //HUB City 정보가 없습니다
							return false;
						}
						if(sheetObjects[1].CellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[1].CellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[1].CellValue(i, prefix+"usa_lst_loc_cd") == ""){
								
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						// length check, if the result is not 2, then alert it.
						if(ComChkLen(sheetObjects[1].CellValue(i, prefix+"ibd_trsp_no"), 11) != 2){
							ComShowCodeMessage("BKG01068"); // Missing P/MIB Type
							return false;
						}
						chked++;
					}
				}
				var chked2 = 0;
				for(var i = 1; i < sheetObjects[2].RowCount+1; i++){
					if(sheetObjects[2].CellValue(i, prefix+"chk") == 1){						
						chked2++;
					}
				}
				if(chked == 0 && chked2 > 0){
					ComShowCodeMessage("BKG06089"); //Can't transmit in case of local b/l.
					return false;
				}
				if(chked == 0){
					ComShowCodeMessage("BKG00149"); //해당 B/L 을 선택해 주세요.
					return false;
				}
				return true;
				break;		
			case COMMAND02:
				if(sheetObj.RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				return true;
				break;
        }

        return true;
    }
     

	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("Y" == CellValue(i, "sheet1_lcl_flg")) /* LCL Flag의 변수 모호하다. 실제 Partial Flag로 Partial 여부를 나타 낸다.*/
					CellFontColor(i, "sheet1_ibd_trsp_no") = RgbColor(255, 0, 0);		// 글자는 붉은색
				
				if(eval(CellValue(i, "sheet1_local_bl_cnt")) > 0)
					CellFontColor(i, "sheet1_local_bl_cnt") = RgbColor(255, 0, 0);		// 글자는 붉은색
			}
			sheetObjects[1].removeAll();
			sheetObjects[2].removeAll();
		}
	}

	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("Y" == CellValue(i, "lcl_flg"))
					//CellFontColor(i, "ibd_trsp_no") = RgbColor(255, 0, 0);		// 글자는 붉은색
					CellFontColor(i, "bl_no") = RgbColor(255, 0, 0);		// 글자는 붉은색
				
			}
		}
	}

	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("Y" == CellValue(i, "lcl_flg"))
					//CellFontColor(i, "ibd_trsp_no") = RgbColor(255, 0, 0);		// 글자는 붉은색
					CellFontColor(i, "bl_no") = RgbColor(255, 0, 0);		// 글자는 붉은색
				
			}
		}
	}
	
	function sheet1_OnDblClick(SheetObj, Row, Col){
		doActionIBSheet(SheetObj,document.form, SEARCH01, Row);
	}
	

	/**
	 * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
	 * @author 김도완.
	 * CoBkg.js를 같이 사용하지 못하는 예외상황이 발생하여 따로 구현함.
	 * ymd에 대한 포맷에 대한 처리가 예외적.
	*/
	function obj_KeyPress2(){
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		
		switch(event.srcElement.dataformat) {
	   	case "ymd":
	   		ComKeyOnlyNumber(event.srcElement);
	   		if (srcValue.length == 4) {
	   			event.srcElement.value = srcValue.substring(0,4) + "-"
	   		}
	   		if (srcValue.length == 7) {
	   			event.srcElement.value = srcValue.substring(0,7) + "-"
	   		}
	       	break;
	   	case "ymdhm":
	   		ComKeyOnlyNumber(event.srcElement);
	   		if (srcValue.length == 4) {
	   			document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
	   		}
	   		if (srcValue.length == 7) {
	   			document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
	   		}
	   		if (srcValue.length == 10) {
	   			document.form.elements[srcName].value = srcValue.substring(0,10) + " "
	   		}
	   		if (srcValue.length == 13) {
	   			document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
	   		}
	       	break;
	   	case "ym":
	   	case "yw":
	   	case "jumin":
	   	case "saupja":	//숫자 + "-"
	   		ComKeyOnlyNumber(event.srcElement, "-"); break;
	   	case "hms":
	   	case "hm":		//숫자 + ":"
	   		ComKeyOnlyNumber(event.srcElement, ":"); 
	       	if (srcValue.length == 2) {
	       		event.srcElement.value = srcValue.substring(0,2) + ":"
	   		}
	   		break;
	   		
	   	case "yy":		//숫자 + "0"
	   		ComKeyOnlyNumber(event.srcElement, "0"); break;
	       case "int":		//숫자
	           ComKeyOnlyNumber(event.srcElement);	break;
	       case "float":	//숫자+"."
	           ComKeyOnlyNumber(event.srcElement, "."); break;
	       case "eng":		//영문 + 숫자
	       	// 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
	           ComKeyOnlyAlphabet('uppernum'); break;  
	       case "engup":	//영문대문자
	           ComKeyOnlyAlphabet('upper'); break;
	       case "engdn":	//영문소문자
	           ComKeyOnlyAlphabet('upper'); break;
	       case "engupspace": //영문대문자 + Space
	           if(event.keyCode != 32) {
	           	ComKeyOnlyAlphabet('uppernum');
	           }
	       	break;
	       case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	               event.keyCode = keyValue + 65 - 97;
	           }
	       	break;
	       default: 		//영문 + 숫자
	       	ComKeyOnlyAlphabet('uppernum'); break;
	   }
	}
	
	var curRow = 1;
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol = sheetObj.SaveNameCol("sheet1_chk");
		if(iCol == sheetObj.MouseCol){
			if (Shift == "1" ) {
				for (var i=curRow; i<=sheetObj.MouseRow -1; i++) {
					sheetObj.CellValue2(i, "sheet1_chk") = "1";
				}
			}
		}
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var iCol = sheetObj.SaveNameCol("sheet1_chk");
		
		if((sheetObj.MouseRow == 0 && Col == iCol && Row == sheetObj.RowCount) 
			||
		   (sheetObj.MouseRow != 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[1].RowCount > 0)
					sheetObjects[1].CheckAll2("chk") = 0;
				if(sheetObjects[2].RowCount > 0)
					sheetObjects[2].CheckAll2("chk") = 0;
			}
		}
	
	}

	var t1curRow = 1;
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol = sheetObj.SaveNameCol("chk");
		if(iCol == sheetObj.MouseCol){
			if (Shift == "1") {
				for (var i=t1curRow; i<=sheetObj.MouseRow -1; i++) {
					sheetObj.CellValue2(i, "chk") = "1";
				}
			}
		}
	}

	function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
		var iCol = sheetObj.SaveNameCol("chk");
		
		if(iCol == Col){
			t1curRow = Row;
			/*
			if(Value == 0){
				if(sheetObjects[0].RowCount > 0)
					sheetObjects[0].CheckAll2("sheet1_chk") = 0;
			}
			*/
		}
	}

	var t2curRow = 1;
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol = sheetObj.SaveNameCol("chk");
		if(iCol == sheetObj.MouseCol){
			if (Shift == "1") {
				for (var i=t2curRow; i<=sheetObj.MouseRow -1; i++) {
					sheetObj.CellValue2(i, "chk") = "1";
				}
			}
		}
	}

	function t2sheet1_OnClick(sheetObj, Row, Col, Value) {
		var iCol = sheetObj.SaveNameCol("chk");
		if(iCol == Col){
			t2curRow = Row;
			/*
			if(Value == 0){
				if(sheetObjects[0].RowCount > 0)
					sheetObjects[0].CheckAll2("sheet1_chk") = 0;
			}
			*/
		}
	}

	/**
	 * In-Bond B/L tab - sheet data 변경시 event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		// Entry Type 변경 Flag Setting
		var iCol = sheetObj.SaveNameCol("cstms_clr_tp_cd");
		if(Col == iCol){
			if(sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") == ""){
				
				sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") = "Y";
			}else{
				
				sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") = "";
			}
		}
		
		// In-bond Type 변경 Flag Setting
		iCol = sheetObj.SaveNameCol("ibd_trsp_tp_cd");
		if(Col == iCol){
			if(sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") == ""){
				
				sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") = "Y";
			}else{
				
				sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") = "";
			}
		}

		iCol = sheetObj.SaveNameCol("chk");
		if((sheetObj.MouseRow == 0 && Col == iCol && Row == sheetObj.RowCount) 
			||
		   (sheetObj.MouseRow != 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[0].RowCount > 0)
					sheetObjects[0].CheckAll2("sheet1_chk") = 0;
			}
		}
	}

	/**
	 * Local Clearance tab - sheet data 변경시 event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
		// Entry Type 변경 Flag Setting
		var iCol = sheetObj.SaveNameCol("cstms_clr_tp_cd");
		if(Col == iCol){
			if(sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") == "")
				sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") = "Y";
			else
				sheetObj.CellValue(Row, "cstms_clr_tp_cd_chg") = "";
		}
		if(sheetObj.CellValue(Row, "cstms_clr_tp_cd") == "I"){
			sheetObj.CellValue2(Row, "cstms_loc_cd") = sheetObj.CellValue(Row, "hub_loc_cd");
		}
		
		// In-bond Type 변경 Flag Setting
		iCol = sheetObj.SaveNameCol("ibd_trsp_tp_cd");
		if(Col == iCol){
			if(sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") == ""){
				
				sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") = "Y";
			}else{
				
				sheetObj.CellValue(Row, "ibd_trsp_tp_cd_chg") = "";
			}
		}
		
		iCol = sheetObj.SaveNameCol("chk");
		if((sheetObj.MouseRow == 0 && Col == iCol && Row == sheetObj.RowCount) 
			||
		   (sheetObj.MouseRow != 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[0].RowCount > 0)
					sheetObjects[0].CheckAll2("sheet1_chk") = 0;
			}
		}
	}

/* 개발자 작업 끝 */