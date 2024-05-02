/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0937 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0937() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btng_apply":
        	        break;

        	    case "btn_close":
        	        window.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // 바로 조회화면을 보기 위해 추가, 로직 추가 후 삭제
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);

		//html컨트롤 이벤트초기화
		initControl();
        
  }

	/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	    //입력Validation 확인하기
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end
	
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
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0 , 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

                    var HeadTitle0 = "Package|Package|Weight|Weight|Center of Gravity|Commodity|Commodity|Sling\nPoint|Cargo Packing\nDetail|Total Dimension (cm)|Total Dimension (cm)|Total Dimension (cm)"
                                    +"|Void Space\n(FEU)|Loading\nMethod|Shipping Crane\n(K.Ton)|Secure & Dunnage|Special Request|Remark";

                    var HeadTitle1 = "||||Center of Gravity|||Sling\nPoint|Cargo Packing\nDetail|Length|Width|Height"
                                    +"|Void Space\n(FEU)|Loading\nMethod|Shipping Crane\n(K.Ton)|Secure & Dunnage|Special Request|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   true,    "pck_qty",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "pck_tp_cd",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight ,   true,    "grs_wgt",     false,          "",       dfFloat,         3,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "wgt_ut_cd",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   true,    "grav_ctr_desc",     false,          "",       dfNone,          0,     true,       true);
                                                                               
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   true,    "cmdt_cd",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      150,    daCenter,   true,    "cmdt_nm",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   true,    "slng_pnt_flg",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,   true,    "pck_dtl_desc",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daRight ,   true,    "dim_len",     false,          "",       dfInteger,       0,     true,       true);                                                                                
                    InitDataProperty(0, cnt++ , dtData,       50,    daRight ,   true,    "dim_wdt",     false,          "",       dfInteger,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daRight ,   true,    "dim_hgt",     false,          "",       dfInteger,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daRight ,   true,    "void_slt_knt",     false,          "",       dfFloat,         1,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "cgo_lodg_mzd_cd",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "shp_crn_wgt",     false,          "",       dfNone,          0,     true,       true);
                                                                                                                                             
                    InitDataProperty(0, cnt++ , dtData,      150,    daCenter,   true,    "scr_dng_ctnt",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      200,    daCenter,   true,    "spcl_rqst_desc",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      200,    daCenter,   true,    "brk_cgo_rmk",     false,          "",       dfNone,          0,     true,       true);
                    RangeBackColor(1, 9, 1, 11) = RgbColor(222, 251, 248);   // ENIS   
                    WordWrap = true;

               }
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))
                {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESD_TRS_0937GS.do", TrsFrmQryString(formObj));
                }

                break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
              break;

        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
