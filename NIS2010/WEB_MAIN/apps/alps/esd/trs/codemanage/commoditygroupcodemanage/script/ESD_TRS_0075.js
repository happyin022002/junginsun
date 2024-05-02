/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0075 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0075() {
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
		 var sheetObject3 = sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;


    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btn_retrieve1":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_delete1":	
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;
        	    case "btn_retrieve2":
    	            doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_save1":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

				//전체저장
        	    case "btng_save2":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
    	            doActionIBSheet3(sheetObject3,formObject,IBSAVE);

        	        break;

                case "btng_apply":
                     doActionIBSheet3(sheetObject2,formObject,IBINSERT);
                    break;

                case "btng_update":
                     doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

                case "btng_update2":
                     doActionIBSheet1(sheetObject1,formObject,IBSAVE);
                    break;

                case "btn_reset":
                     fn_reset();
                    break;

                case "btn_reset1":
                     fn_reset_01();
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
            ComConfigSheet(sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		//var formObject = document.form;
		//formObject.sheet3.ColHidden(1) = true;	// 마지막컬럼인인 특정셋팅 컬럼인지는 모르겠으나 히든설정이 안되는것도 있음(수정바람~~!)

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
	    //???? ????
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
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
	    //?????? ???
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	    //???????
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
            case 1:   //sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(5);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 6, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	 InitHeadMode(true, true, false, false, false,false)

                    var HeadTitle = "STS||Service Provider|Service Provider|Commodity Group|Commodity Group|del_YN|Save";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,				KEYFIELD,	CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtDelCheck,		30,    daCenter,  false,    "check");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  false,    "ibflag",				false,      "",			dfNone,			0,		 true,      true,		0,			false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtRadioCheck,	20,	   daCenter,  false,    "radio",				false,      "",			dfNone,			0,		 true,      true,		0,			false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,		60,    daCenter,  false,    "vndr_seq",				true,		"",         dfNone,         0,       false,     true,		6,			false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtPopup,		145,    daLeft,	false,    "vndr_nm",		        false,		"",			dfNone,         0,       false,     true,		100,		false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,		40,    daCenter, false,    "trsp_grp_cmdt_cd",		true,		"",   dfNone,         0,       false,     true,		4,			false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,		130,    daLeft,		false,    "trsp_cmdt_grp_nm",     false,		"",	dfNone,         0,       true,		true,		100,		false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtCombo,		20,    daCenter,	false,    "delt_flg",     false,		"",			dfNone,         0,       true,		true,		2,		false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtHidden,		10,    daLeft,    false,    "save",					false,		"",			dfNone,         0,       true,		true,		100,		false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtHidden,		10,    daLeft,    false,    "update",					false,		"",			dfNone,         0,       true,		true,		100,		false,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtHidden,		10,    daLeft,    false,    "dupl",					false,		"",			dfNone,         0,       true,		true,		100,		false,	 true,	   "",	  false);

					var delFlag_cdText = "LIVE|DEL";
					var delFlag_cdCode = "N|Y";

					InitDataCombo(0, 'delt_flg', " |"		+delFlag_cdText,	" |"+delFlag_cdCode);


                }
                break;
             case 2:   //sheet2 init
                with (sheetObj) {

                    style.height=GetSheetHeight(5);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Del.|STS|Commodity|Commodity|Created Date|User ID|VNDR SEQ|Trsp Grp CMDT Cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "part");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "cmdt_cd",			false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daLeft,    false,    "cmdt_nm",			false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "cre_dt",				false,          "",       dfDateYmd,		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "cre_usr_id",			false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  false,    "vndr_seq",			false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  false,    "trsp_grp_cmdt_cd",   false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,	  60,    daLeft,    false,    "deleteval",					false,		"",			dfNone,         0,       true,		true,		100,		false,	 true,	   "",	  false);


                }
                break;

             case 3:   //sheet3 init
                with (sheetObj) {

                    style.height=GetSheetHeight(12);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = " |Rep. Commodity|Rep. Commodity|Commodity|Commodity";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,			KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "check");
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "rep_cmdt_cd",    false,          "",       dfNone,   		4,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,    false,    "rep_cmdt_nm",    false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "cmdt_cd",		false,          "",       dfNone,   		6,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daLeft,    false,    "cmdt_nm",		false,          "",       dfNone,   		0,     false,      false);

                }
                break;

             case 4:   //sheet4 init
                with (sheetObj) {

                    style.height=0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Del.|STS|Commodity|Commodity|Created Date|User ID|VNDR SEQ|Trsp Grp CMDT Dd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "");
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "cmdt_cd",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daLeft,    false,    "cmdt_nm",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "cre_dt",				false,          "",       dfDateYmd,		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "cre_usr_id",			false,          "",       dfNone,   		0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "vndr_seq",			false,          "",       dfNone,   		0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "trsp_grp_cmdt_cd",   false,          "",       dfNone,   		0,     true,      true);

                }
                break;

        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var formObject = document.form;
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0075GS.do", TrsFrmQryString(formObj));
				formObject.sheet2.RemoveAll();

                break;
            case IBSAVE:        //저장

				var sheet1_count =formObject.sheet1.RowCount;
				
				if(sheet1_count>0){
					formObj.f_cmd.value = MULTI;
					var savexml = sheetObj.DoSave("ESD_TRS_0075GS.do", TrsFrmQryString(formObj),-1,false);
				}
                break;  

           case IBINSERT:
                var Row = sheetObj.DataInsert();
				formObject.sheet1.CellValue2(Row, "save") = "N"; 
				formObject.sheet1.SelectCell(Row, "vndr_seq");
				formObject.sheet1.CellValue2(Row, "radio") = "1";
		   		//hidden값에 대문자값을 셋팅
				document.form.cre_usr_id.value  = document.form.cre_usr_id.value.toUpperCase();
				document.form.upd_usr_id.value  = document.form.upd_usr_id.value.toUpperCase();
				
                break;

           case IBDELETE:       
                sheet1_delete(sheetObj,formObj);
              break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                break;
            case IBSAVE:        //저장
				part_save();
                break;

           case IBINSERT:
                var Row = sheetObj.DataInsert();
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                break;
            case IBSAVE:        //저장
				
                break;

           case IBINSERT:
                var Row = sheetObj.DataInsert();
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet3(sheetObj,formObj,sAction) {
		var formObject = document.form;
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_TRS_0075_01GS.do", TrsFrmQryString(formObj));
                break;

            case IBSAVE:        //저장

				var sheet4_count =formObject.sheet4.RowCount;
				
				if(sheet4_count>0){
					formObj.f_cmd.value = MULTI01;
					var savexml = sheetObj.DoSave("ESD_TRS_0075GS.do", TrsFrmQryString(formObj),-1,false);
				}
				//part_save;
				tot_save();
                break;

           case IBINSERT:
				apply_send(sheetObj,formObj);
                break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }


	/**
	 * VNDR_check.
	 */
	function vndr_check(obj){

		var formObject = document.form;
		var inputStr=obj.value;
		var value=obj.value;
		var charval = "Y";

		for (var i = 0; i < inputStr.length; i++)
		{
			 var oneChar = inputStr.charAt(i)
			 if (oneChar != "")
			 {
				   if ( (oneChar >= "0" && oneChar <= "9" )){
				   }else {
					   charval ="N";
					   break;
				   }
			 }else{
				charval ="N";
				break;
			 }

		}

		if(charval=="Y"){
			if(value !=""){
				formObject.f_cmd.value = SEARCH04;
				var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
				formObject.sheet1.DoRowSearch("ESD_TRS_0075GS.do", queryString);
				if(!check_vndr(formObject.sheet1.EtcData('CNT_CD'),obj)){
					formObject.vndr_cd.value="";
					formObject.vndr_nm.value="";
					formObject.vndr_cd.focus();
				}
			}else{
				formObject.vndr_nm.value="";
			}
		}else{
			formObject.vndr_cd.value="";
			formObject.vndr_nm.value="";
			formObject.vndr_cd.focus();
			var errMessage = ComGetMsg('COM12130','Number type','','');  
			ComShowMessage(errMessage);
		}

	}


	/**
	 * VNDR 입력시 존재여부체크 
	 *
	 */
	function check_vndr(value, obj)
	{
		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','VNDR','','');  
			ComShowMessage(errMessage);
			return false;
		}else{
			formObject.vndr_nm.value=value;
			return true;
		}
	}



	/**
	 * VNDR Commoodity Group_check.
	 */
	function vndr_nm_check(obj){

		var formObject = document.form;
		var value=obj.value;

		if(value !=""){
			formObject.f_cmd.value = SEARCH05;
			var queryString = "vndr_nm="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch("ESD_TRS_0075GS.do", queryString);
			if(!check_vndr_commodity(formObject.sheet1.EtcData('CNT_CD'),formObject.sheet1.EtcData('VNDR_NM'),obj)){
				formObject.vndr_nm.value="";
				formObject.vndr_cd.value="";
				formObject.vndr_nm.focus();
			}
		}

	}


	/**
	 * VNDR Commoodity Group 입력시 존재여부체크 
	 *
	 */
	function check_vndr_commodity(value,value1, obj){

		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','VNDR Commoodity Group','','');  
			ComShowMessage(errMessage);
			return false;
		}else{
			formObject.vndr_nm.value=value;
			return true;
		}
	}


	/**
	 * rep_commodity_check.
	 */
	function rep_commodity_check(obj){

		var formObject = document.form;
		var value=obj.value;

		if(value !=""){
			formObject.f_cmd.value = SEARCH02;
			var queryString = "rep_cmdt_cd="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch("ESD_TRS_0075_01GS.do", queryString);
			if(!check_rep(formObject.sheet1.EtcData('CNT_CD'),obj)){
				formObject.rep_cmdt_cd.value="";
				formObject.rep_cmdt_cd.focus();
			}
		}else{
			formObject.rep_cmdt_nm.value="";
		}

	}


	/**
	 * Rep. Commodity 입력시 존재여부체크 
	 *
	 */
	function check_rep(value, obj)
	{
		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','Rep. Commodity','','');  
			ComShowMessage(errMessage);
			return false;
		}else{
			formObject.rep_cmdt_nm.value=value;
			return true;
		}
	}

	/**
	 * commodity_check.
	 */
	function commodity_check(obj){

		var formObject = document.form;
		var value=obj.value;

		if(value !=""){
			formObject.f_cmd.value = SEARCH03;
			var queryString = "cmdt_cd="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch("ESD_TRS_0075_01GS.do", queryString);
			if(!check_commodity(formObject.sheet1.EtcData('CNT_CD'),obj)) {
				formObject.cmdt_cd.value="";
				formObject.cmdt_cd.focus();
			}
		}else{
			formObject.cmdt_nm.value="";
		}

	}


	/**
	 * Commodity 입력시 존재여부체크 
	 *
	 */
	function check_commodity(value, obj)
	{
		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','Commodity','','');  
			ComShowMessage(errMessage);
			return false;
		}else{
			formObject.cmdt_nm.value=value;
			return true;
		}
	}


	/**
	 * 포커스 전체선택하기
	 */
	function fun_Focus(obj){
		obj.select();
	}



	/**
	 * rep_commodity팝업호출
	 */
	function rep_OnPopupClick()
	{

			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_rep";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
	
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 772, 413, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

	}
	  
	/**
	 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_rep(rowArray) {

		var formObject = document.form;
		
		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[4];
			var colArray3 = colArray[3];
			document.form.rep_cmdt_cd.value = colArray2;	
			document.form.rep_cmdt_nm.value = colArray3;
		}

	}



	/**
	 * commodity팝업호출
	 */
	function commodity_OnPopupClick()
	{

			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_commodity";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
	
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 772, 413, 'getCOM_ENS_commodity', '1,0,1,1,1,1,1,1,1,1,1,1');

	}
	  
	/**
	 * commodity팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_commodity(rowArray) {

		var formObject = document.form;
		
		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			document.form.cmdt_cd.value = colArray2;	
			document.form.cmdt_nm.value = colArray3;
		}

	}

	/**
	 * commodity팝업호출
	 */
	function vndr_OnPopupClick()
	{

		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_vndr";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_vndr', '1,0,1,1,1,1,1,1,1,1,1,1');

	}

	  
	/**
	 * commodity팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_vndr(rowArray) {

		var formObject = document.form;
		
		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			document.form.vndr_cd.value = colArray2;	
			document.form.vndr_nm.value = colArray3;
		}

	}


	/**
	 * Location 이나 Contry Code 입력시 이벤트처리 
	 *
	 */
	function sheet1_OnChange(sheetObj, row, col, value){

		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		var loop_val ="N";
		var charval ="Y";

		var inputStr = delSpace(value);

		switch(colName){
			case 'vndr_seq':
				var sheet1_vndr_seq=formObject.sheet1.CellValue(row, "vndr_seq");
				var inputStr=sheet1_vndr_seq;

				for (var i = 0; i < inputStr.length; i++)
				{
					 var oneChar = inputStr.charAt(i)
					 if (oneChar != "")
					 {
						   if ( (oneChar >= "0" && oneChar <= "9" )){
						   }else {
							   charval ="N";
							   break;
						   }
					 }else{
						charval ="N";
						break;
					 }

				}

				var b_vndr_seq =   formObject.sheet1.CellValue(row, "vndr_seq");
				var b_trsp_grp_cmdt_cd =   formObject.sheet1.CellValue(row, "trsp_grp_cmdt_cd");
				var bigyo_1 =b_vndr_seq+b_trsp_grp_cmdt_cd;
				formObject.sheet1.CellValue2(row, "dupl") = bigyo_1;

				var b_dupl = formObject.sheet1.ColValueDup("dupl");

				if(b_dupl>0){
					var errMessage = ComGetMsg('COM12115','Vender and Commodity','','');  
					ComShowMessage(errMessage);
					formObject.sheet1.CellValue2(row, col)="";
					formObject.sheet1.SelectCell(row, col);
					return false;
				}


				if(charval !="N"){
					if(sheet1_vndr_seq!=""){
						formObject.f_cmd.value = SEARCH04;
						var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
						sheetObj.DoRowSearch("ESD_TRS_0075GS.do", queryString);
						if(!check_sheet_vndr(formObject.sheet1.EtcData('CNT_CD'),row, col)){
							formObject.sheet1.CellValue2(row, col)="";
							formObject.sheet1.SelectCell(row, col);
							return false;
						}
					}
				}

			
			break;

			case 'trsp_grp_cmdt_cd':

				var b_vndr_seq =   formObject.sheet1.CellValue(row, "vndr_seq");
				var b_trsp_grp_cmdt_cd =   formObject.sheet1.CellValue(row, "trsp_grp_cmdt_cd");
				var bigyo_1 =b_vndr_seq+b_trsp_grp_cmdt_cd;
				formObject.sheet1.CellValue2(row, "dupl") = bigyo_1;

				var b_dupl = formObject.sheet1.ColValueDup("dupl");

				if(b_dupl>0){
					var errMessage = ComGetMsg('COM12115','Vender and Commodity','','');  
					ComShowMessage(errMessage);
					formObject.sheet1.CellValue2(row, col)="";
					formObject.sheet1.SelectCell(row, col);
					return false;
				}

			break;

			case 'trsp_cmdt_grp_nm':

				row_status = formObject.sheet1.RowStatus(row);
				if(row_status =="I"){
				}else{
					formObject.sheet1.RowStatus(row) ="U";
					formObject.sheet1.CellValue2(row, "update") = "U";
					
				}

			break;

			case 'radio':

				var sheet1_vndr_seq=formObject.sheet1.CellValue(row, "vndr_seq");
				var sheet1_trsp_grp_cmdt_cd=formObject.sheet1.CellValue(row, "trsp_grp_cmdt_cd");
				var update = formObject.sheet1.CellValue(row, "update");

				row_status = formObject.sheet1.RowStatus(row);

				if(row_status =="I" || update =="U"){
				}else{
					//formObject.sheet1.RowStatus(row) ="R";
				}

				var sheet4_count =formObject.sheet4.RowCount;
				var p = sheet4_count+1;
				var s = 1;

				var cmdt_cd = "";
				var cmdt_nm = "";
				var cre_dt = "";
				var cre_usr_id = "";
				var vndr_seq = "";
				var trsp_grp_cmdt_cd = "";
				var bigyo_t1="";
				var bigyo_t2="";
				bigyo_t1 =sheet1_vndr_seq+sheet1_trsp_grp_cmdt_cd;

				formObject.sheet2.RemoveAll();

				formObject.f_cmd.value = SEARCH06;
				var vndr_seq_val = formObject.sheet1.CellValue(row, "vndr_seq");
				var trsp_grp_cmdt_cd_val = formObject.sheet1.CellValue(row, "trsp_grp_cmdt_cd");
				var queryString = "trsp_grp_cmdt_cd="+trsp_grp_cmdt_cd_val+"&"+"vndr_seq="+vndr_seq_val+"&"+TrsFrmQryString(formObject);
				formObject.sheet2.DoSearch4Post("ESD_TRS_0075GS.do", queryString);

				var sheet2_count =formObject.sheet2.RowCount;
				var k = sheet2_count+1;

				if(sheet4_count >0){
					for(var t = 1; t < p; t++) {
						sheet4_vndr_seq = formObject.sheet4.CellValue(t, "vndr_seq");
						sheet4_trsp_grp_cmdt_cd = formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");
						bigyo_t2 =sheet4_vndr_seq+sheet4_trsp_grp_cmdt_cd;
						if(bigyo_t1 == bigyo_t2){

							var cmdt_cd = formObject.sheet4.CellValue(t, "cmdt_cd");
							var cmdt_nm = formObject.sheet4.CellValue(t, "cmdt_nm");
							var cre_dt = formObject.sheet4.CellValue(t, "cre_dt");
							var cre_usr_id = formObject.sheet4.CellValue(t, "cre_usr_id");
							var vndr_seq = formObject.sheet4.CellValue(t, "vndr_seq");
							var trsp_grp_cmdt_cd = formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");

							formObject.sheet2.DataInsert(k);
							formObject.sheet2.CellValue2(k, "cmdt_cd") = cmdt_cd;
							formObject.sheet2.CellValue2(k, "cmdt_nm") = cmdt_nm;
							formObject.sheet2.CellValue2(k, "cre_dt") = cre_dt;
							formObject.sheet2.CellValue2(k, "cre_usr_id") = cre_usr_id;
							formObject.sheet2.CellValue2(k, "vndr_seq") = vndr_seq;
							formObject.sheet2.CellValue2(k, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd;

							formObject.sheet2.RowStatus(k) ="R";
							formObject.sheet2.RowBackColor(k)=formObject.sheet2.RgbColor(238,255,226);


							k=k+1;

						}else{
						}
					}
				}
				
			break;

		}
	}
	
	
	/**
	 * VNDR 입력시 존재여부체크 
	 *
	 */
	function check_sheet_vndr(value, row, col)
	{
		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','VNDR','','');  
			ComShowMessage(errMessage);
			return false;
		}else{
			formObject.vndr_nm.value=value;
			formObject.sheet1.CellValue2(row, col+1) = value;
			//formObject.sheet1.SelectCell(row, col+1);
			return true;
		}
	}


	/**
	 * 문자열 사이의 공백을 제거
	 */
	function delSpace(str)
	{
		var trimstr = str;
		for (var i=0; i< str.length;i++)
		{
			trimstr = trimstr.replace(' ' ,'');
		}
		return trimstr;
	}

	/**
	 * sheet1에 대한 팝업처리
	 */
	function sheet1_OnPopupClick(sheetObj, row, col)
	{
			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_0C1";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";

			formObject.hid_row.value=row;   //row값을 hidden값으로 넣음
			formObject.hid_col.value=col;   //col값을 hidden값으로 넣음

		if ( sheetObj.ColSaveName(col) == "vndr_nm" )
		{
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1,1,1,1,1');
		}else{
		}
	}

	
	  
	/**
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_0C1(rowArray) {

		var formObject = document.form;

		//팝업에서 멀티로 선택시에 대비해서 만들어놓았음!!!
		
		for(var i=0; i<rowArray.length; i++)
		{
			//if(i ==rowArray.length-1) gubun ='';
			var colArray = rowArray[0];
			var row_val = formObject.hid_row.value;   //row값을 hidden값으로 넣음
			var col_val = formObject.hid_col.value;   //col값을 hidden값으로 넣음
			var in_val_1 = colArray[2];
			var in_val_2 = colArray[4];

			formObject.sheet1.CellValue2(row_val, col_val-1) = in_val_1;
			formObject.sheet1.CellValue2(row_val, col_val) = in_val_2;
						
		}

	}


	/**
	 * 한글체크
	 */
	function han_check(inputStr,val){

		var formObject = document.form;
		var onecharval=inputStr.value;
		var gubun=val;

		for (var i = 0; i < onecharval.length; i++)
		{
			 var oneChar = onecharval.charAt(i)
			 if (oneChar != "")
			 {

				if ( hanCheck(oneChar) ) {

					if(gubun=="A"){
						formObject.vndr_commoodity_cd.value="";
					}else if(gubun=="B"){
						formObject.vndr_commoodity_nm.value="";
					}else{

					}
				}
			 }else{
				 break;
			 }
		}
	}
	

	/**
	 * 한글 여부 체크.
	 * 입력 문자열이 한글이면 true, 한글이 아니면 false.
	 */
	function hanCheck(str)
	{
		var str1 = getByteLenval(str);
		if(str.length*2 == str1) // 한글이면
			return true;
		else    // 한글이 아니면
			return false;
	}


	
	/**
	 * 입력받은 String의 Byte Size를 구한
	 */
	function getByteLenval(str)
	{
		var len = 0;

			if( str == null ) return 0;
			for( var i = 0 ; i < str.length ; i++ )
			{
				var c = escape(str.charAt(i));
				if ( c.length == 1 ) len ++;
				else if( c.indexOf("%u") != -1 ) len += 2;
				else if( c.indexOf("%") != -1 ) len += c.length/3;
			}
			return len;
	} 


	/**
	 * apply버튼을 누를시 적용 로직
	 */
	function apply_send(sheetObj,formObj){

		var formObject = document.form;
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var vndr_seq = "";
		var trsp_grp_cmdt_cd = "";
		var cre_dt = formObject.cre_dt.value;
		var cre_usr_id = formObject.cre_usr_id.value;
		var sheet2_count =formObject.sheet2.RowCount;
		var sheet4_count =formObject.sheet4.RowCount;
		var bigyo_row_1 ="";
		var bigyo_row_2 ="";
		var loop_val ="Y";
		var row_status="";

		var xxx=formObject.sheet1.FindCheckedRow("radio");   //체크된 행의 번호를 알아온다.
		var x = xxx;



		if(xxx==""){
			var errMessage = ComGetMsg('COM12114','VNDR sheet-[Check]');  
			ComShowMessage(errMessage);
		}else{
			x =  delbar(x);
			vndr_seq = formObject.sheet1.CellValue(x, "vndr_seq");
			formObject.hid_vndr_seq.value=vndr_seq;
			trsp_grp_cmdt_cd = formObject.sheet1.CellValue(x, "trsp_grp_cmdt_cd");

			if(vndr_seq =="" || trsp_grp_cmdt_cd==""){
				var errMessage = ComGetMsg('COM12114','VNDR /VNDR Commoodity');  
				ComShowMessage(errMessage);
			}else{

				checkRows = sheetObj.CheckedRows("check");

				if(checkRows == 0) {
					var errMessage = ComGetMsg('COM12114','Rep. Commodity-[Check]');  
					ComShowMessage(errMessage);
					return;
				}
				else {
					var idx = 0;
					var cmdt_cd = "";
					var cmdt_nm = "";
					var k = sheet2_count+1;
					var s1 = sheet2_count+1;
					var s2 = sheet4_count+1;
					var p = sheet4_count+1;

					rArray = new Array(checkRows);
					for(var i = 0; i < rows; i++) {
						if(sheetObj.CellValue(i, "check") == 1) {
							cmdt_cd = sheetObj.CellValue(i, "cmdt_cd");
							cmdt_nm = sheetObj.CellValue(i, "cmdt_nm");

							bigyo_row_1 = cmdt_cd + vndr_seq + trsp_grp_cmdt_cd;

							for(var t = 1; t < p; t++) {
								
								bigyo_row_2 = formObject.sheet4.CellValue(t, "cmdt_cd")+zeroInsert(formObject.sheet4.CellValue(t, "vndr_seq"))+formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");
								
								if(bigyo_row_1 == bigyo_row_2){
									loop_val ="N";
									//break;
								}else{
									//loop_val ="Y";
								}
							}

							for(var t = 1; t < s1; t++) {

								bigyo_row_2 = formObject.sheet2.CellValue(t, "cmdt_cd")+zeroInsert(formObject.sheet2.CellValue(t, "vndr_seq"))+formObject.sheet2.CellValue(t, "trsp_grp_cmdt_cd");

								if(bigyo_row_1 == bigyo_row_2){
									loop_val ="N";
									//break;
								}else{
									//loop_val ="Y";
								}
							}

							if(loop_val =="Y"){
								formObject.sheet2.DataInsert(k);
								formObject.sheet2.CellValue2(k, "cmdt_cd") = cmdt_cd;
								formObject.sheet2.CellValue2(k, "cmdt_nm") = cmdt_nm;
								formObject.sheet2.CellValue2(k, "cre_dt") = cre_dt;
								formObject.sheet2.CellValue2(k, "cre_usr_id") = cre_usr_id;
								formObject.sheet2.CellValue2(k, "vndr_seq") = vndr_seq;
								formObject.sheet2.CellValue2(k, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd;
								formObject.sheet2.CellValue2(k, "deleteval") = "Y";

								formObject.sheet4.DataInsert(s2);
								formObject.sheet4.CellValue2(s2, "cmdt_cd") = cmdt_cd;
								formObject.sheet4.CellValue2(s2, "cmdt_nm") = cmdt_nm;
								formObject.sheet4.CellValue2(s2, "cre_dt") = cre_dt;
								formObject.sheet4.CellValue2(s2, "cre_usr_id") = cre_usr_id;
								formObject.sheet4.CellValue2(s2, "vndr_seq") = vndr_seq;
								formObject.sheet4.CellValue2(s2, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd; 

								formObject.sheet2.RowStatus(k) ="R";	
								formObject.sheet2.RowBackColor(k)=formObject.sheet2.RgbColor(238,255,226);
								
								k=k+1;
								s2=s2+1;
							}else{
								//향후 적용가능한 구문!!!
								//var errMessage = ComGetMsg('COM12114','Rep. Commodity data');  
								//ComShowMessage(errMessage);
								//break;
							}
						}
						loop_val ="Y";
					}

				}//if(checkRows == 0) {
			}
		}//if(xxx==""){
	 }


	 function apply_loop(){

		formObject.sheet2.DataInsert(k);
		formObject.sheet2.CellValue2(k, "cmdt_cd") = cmdt_cd;
		formObject.sheet2.CellValue2(k, "cmdt_nm") = cmdt_nm;
		formObject.sheet2.CellValue2(k, "cre_dt") = cre_dt;
		formObject.sheet2.CellValue2(k, "cre_usr_id") = cre_usr_id;
		formObject.sheet2.CellValue2(k, "vndr_seq") = vndr_seq;
		formObject.sheet2.CellValue2(k, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd;
		formObject.sheet2.CellValue2(k, "deleteval") = "Y";

		formObject.sheet4.DataInsert(s2);
		formObject.sheet4.CellValue2(s2, "cmdt_cd") = cmdt_cd;
		formObject.sheet4.CellValue2(s2, "cmdt_nm") = cmdt_nm;
		formObject.sheet4.CellValue2(s2, "cre_dt") = cre_dt;
		formObject.sheet4.CellValue2(s2, "cre_usr_id") = cre_usr_id;
		formObject.sheet4.CellValue2(s2, "vndr_seq") = vndr_seq;
		formObject.sheet4.CellValue2(s2, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd; 

		formObject.sheet2.RowStatus(k) ="R";	
		formObject.sheet2.RowBackColor(k)=formObject.sheet2.RgbColor(238,255,226);
		
		k=k+1;
		s2=s2+1;

	 }

	 	
	/**
	 * 문자열 사이의 공백을 제거
	 */
	function delbar(str)
	{
		var trimstr = str;
		for (var i=0; i< str.length;i++)
		{
			trimstr = trimstr.replace('|' ,'');
		}
		return trimstr;
	}


	/**
	 * sheet1의 삭제버튼처리
	 */
	function sheet1_delete(sheetObj,formObj){

		var formObject = document.form;
		var bigyo_row_1 ="";
		var bigyo_row_2 ="";
		var vndr_seq = "";
		var trsp_grp_cmdt_cd = "";
		var sheet2_count =formObject.sheet2.RowCount;
		var sheet4_count =formObject.sheet4.RowCount;


		//기존쉬트 sheet2-sheet4에 저장되어있는 값이 있을경우 삭제하는 로직입니다.
		//화면상에서만 삭제하는 로직입니다.
		var xxx=formObject.sheet1.FindCheckedRow("radio");   //체크된 행의 번호를 알아온다.
		var x = xxx;

		if(xxx==""){
			//var errMessage = ComGetMsg('COM12139','VNDR sheet-[Check]','','');  
			//ComShowMessage(errMessage);
		}else{
			x =  delbar(x);
			vndr_seq = formObject.sheet1.CellValue(x, "vndr_seq");
			trsp_grp_cmdt_cd = formObject.sheet1.CellValue(x, "trsp_grp_cmdt_cd");
			
			var idx = 0;
			var cmdt_cd = "";
			var cmdt_nm = "";
			var k = sheet2_count+1;
			var s = sheet4_count+1;
			var p = sheet4_count+1;
			

			bigyo_row_1 = vndr_seq + trsp_grp_cmdt_cd;

			for(var t = 1; t < p; t++) {
				bigyo_row_2 = formObject.sheet4.CellValue(t, "vndr_seq")+formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");

				if(bigyo_row_1 == bigyo_row_2){
					formObject.sheet4.RowDelete(t, false);
					t=t-1;
				}
			}

			for(var t = 1; t < k; t++) {
				bigyo_row_2 = formObject.sheet2.CellValue(t, "vndr_seq")+formObject.sheet2.CellValue(t, "trsp_grp_cmdt_cd");

				if(bigyo_row_1 == bigyo_row_2){
					formObject.sheet2.RowStatus(t) ="D";
				}
			}

			//기존쉬트 sheet1에 저장되어있는 값이 있을경우 삭제하는 로직입니다.
			//삭제하는 분기로직입니다.
			var vndr_seq = formObject.sheet1.CellValue(x, "vndr_seq");
			var trsp_grp_cmdt_cd = formObject.sheet1.CellValue(x, "trsp_grp_cmdt_cd");
			var save_check = formObject.sheet1.CellValue(x, "save");

			if(save_check == "N"){
				formObject.sheet1.RowDelete(x, false);   //화면상에서만 처리하는 부분!!!
			}else{
				//실제적으로 비지니스로직을 태워야 하는부분입니다.
				formObj.f_cmd.value = MULTI01;
				formObject.sheet1.RowStatus(x) = "D";
				var queryString = "vndr_seq="+vndr_seq+"&trsp_grp_cmdt_cd="+trsp_grp_cmdt_cd+"&"+TrsFrmQryString(formObject);
				//formObject.sheet2.DoSave("ESD_TRS_0075_01GS.do", queryString);
				var SaveStr = formObject.sheet2.GetSaveString(false, false); 
				var sXml = formObject.sheet2.GetSaveXml("ESD_TRS_0075_01GS.do", queryString+"&"+SaveStr);
				formObject.sheet2.LoadSaveXml(sXml,false); 

				formObj.f_cmd.value = MULTI;
				formObject.sheet1.RowStatus(x) = "D";
				var queryString = "vndr_seq="+vndr_seq+"&trsp_grp_cmdt_cd="+trsp_grp_cmdt_cd+"&"+TrsFrmQryString(formObject);
				//formObject.sheet1.DoSave("ESD_TRS_0075GS.do", queryString);

				var SaveStr = formObject.sheet1.GetSaveString(false, false); 
				var sXml = formObject.sheet1.GetSaveXml("ESD_TRS_0075GS.do", queryString+"&"+SaveStr);
				formObject.sheet1.LoadSaveXml(sXml,false); 

			}

			for(var t = 1; t < k; t++) {
				bigyo_row_2 = formObject.sheet2.CellValue(t, "vndr_seq")+formObject.sheet2.CellValue(t, "trsp_grp_cmdt_cd");
				if(bigyo_row_1 == bigyo_row_2){
					formObject.sheet2.RowDelete(t, false);
					t=t-1;
				}
			}

		}//if(xxx==""){

	}


	/**
	 * 전체저장버튼을 누를시..
	 */
	function tot_save(){
				
		var formObject = document.form;
		var val="";
		var xxx=formObject.sheet1.FindCheckedRow("radio");   //체크된 행의 번호를 알아온다.
		var x = xxx;
		x =  delbar(x);
		var vndr_seq = "";
		var trsp_grp_cmdt_cd = "";
		var cmdt_cd = "";

		vndr_seq = formObject.sheet1.CellValue(x, "vndr_seq");
		trsp_grp_cmdt_cd = formObject.sheet1.CellValue(x, "trsp_grp_cmdt_cd");
		cmdt_cd = formObject.sheet1.CellValue(x, "cmdt_cd");

		formObject.sheet1.RemoveAll();
		formObject.sheet2.RemoveAll();
		formObject.sheet4.RemoveAll();

		formObject.f_cmd.value = SEARCH;
		var value="";
		var value1="";
		var queryString = "value="+value+"&"+"value1="+value1+"&"+TrsFrmQryString(formObject);
		formObject.sheet1.DoSearch4Post("ESD_TRS_0075GS.do", queryString);

		formObject.sheet1.CellValue2(x, "radio") ="1";

		formObject.f_cmd.value = SEARCH06;
		var queryString = "trsp_grp_cmdt_cd="+trsp_grp_cmdt_cd+"&"+"vndr_seq="+vndr_seq+"&"+TrsFrmQryString(formObject);
		formObject.sheet2.DoSearch4Post("ESD_TRS_0075GS.do", queryString);

		formObject.sheet1.SelectCell(x, 0, false);

	}


	/**
	 * 부분저장버튼을 누를시..(하단쉬트삭제버튼)
	 */
	function part_save(){

		var formObject = document.form;
		var val="";
		var xxx=formObject.sheet2.FindCheckedRow("part");   //체크된 행의 번호를 알아온다.
		var x = xxx;
		x =  delbar(x);
		x_1 = x;
		var bigyo_row_1 ="";
		var bigyo_row_2 ="";
		var vndr_seq = "";
		var trsp_grp_cmdt_cd = "";
		var cmdt_cd = "";
		var sheet2_count =formObject.sheet2.RowCount;
		var sheet4_count =formObject.sheet4.RowCount;
		var idx = 0;
		var cmdt_cd = "";
		var cmdt_nm = "";
		var k = sheet2_count+1;
		var p = sheet4_count+1;
		var p2 = sheet4_count+1;

		var yyy=formObject.sheet1.FindCheckedRow("radio");   //체크된 행의 번호를 알아온다.
		var y = yyy;
		y =  delbar(y);
		var sheet1_vndr_seq = "";
		var sheet1_trsp_grp_cmdt_cd = "";
		var sheet1_cmdt_cd = "";

		sheet1_vndr_seq = formObject.sheet1.CellValue(y, "vndr_seq");
		sheet1_trsp_grp_cmdt_cd = formObject.sheet1.CellValue(y, "trsp_grp_cmdt_cd");
		sheet1_cmdt_cd = formObject.sheet1.CellValue(y, "cmdt_cd");



		for(var p = 1; p < k; p++) {

			if(formObject.sheet2.CellValue(p, "part") == 1) {

				//sheet2의 값을 읽어서 sheet4번과 비교하기위한 구문[1]
				vndr_seq = formObject.sheet2.CellValue(p, "vndr_seq");
				trsp_grp_cmdt_cd = formObject.sheet2.CellValue(p, "trsp_grp_cmdt_cd");
				cmdt_cd = formObject.sheet2.CellValue(p, "cmdt_cd");

				bigyo_row_1 = vndr_seq + trsp_grp_cmdt_cd + cmdt_cd;

				for(var t = 1; t < p2; t++) {
					bigyo_row_2 = formObject.sheet4.CellValue(t, "vndr_seq")+formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd")+formObject.sheet4.CellValue(t, "cmdt_cd");
					if(bigyo_row_1 == bigyo_row_2){
						formObject.sheet4.RowDelete(t, false);
						t=t-1;
					}
				}
			}
		}

		formObject.f_cmd.value = MULTI02;
		var queryString = "val="+val+"&"+TrsFrmQryString(formObject);
		var SaveStr = formObject.sheet2.GetSaveString(false, false); 
		formObject.sheet2.DoSave("ESD_TRS_0075_01GS.do", queryString,-1,false);

		//var SaveStr = formObject.sheet2.GetSaveString(false, false); 
		//var sXml = formObject.sheet2.GetSaveXml("ESD_TRS_0075_01GS.do", queryString+"&"+SaveStr);
		//formObject.sheet2.LoadSaveXml(sXml,false); 

		formObject.sheet2.RemoveAll();

		formObject.f_cmd.value = SEARCH06;
		var queryString = "trsp_grp_cmdt_cd="+sheet1_trsp_grp_cmdt_cd+"&"+"vndr_seq="+sheet1_vndr_seq+"&"+TrsFrmQryString(formObject);
		formObject.sheet2.DoSearch4Post("ESD_TRS_0075GS.do", queryString);

		var sheetObj = formObject.sheet2;
		part_save_after(sheetObj, x_1);

	}


	/**
	 * 부분저장버튼을 누른후..(하단쉬트삭제버튼)
	 *
	 */
	function part_save_after(sheetObj, row){

		var formObject = document.form;
		var xxx=formObject.sheet1.FindCheckedRow("radio");   //체크된 행의 번호를 알아온다.
		var x = xxx;
		x =  delbar(x);
		var sheet1_vndr_seq=formObject.sheet1.CellValue(x, "vndr_seq");
		var sheet1_trsp_grp_cmdt_cd=formObject.sheet1.CellValue(x, "trsp_grp_cmdt_cd");
		var bigyo_1="";
		var bigyo_2="";
		bigyo_1=sheet1_vndr_seq+sheet1_trsp_grp_cmdt_cd;
		//formObject.sheet1.RowStatus(row) ="R";

		var sheet4_count =formObject.sheet4.RowCount;
		var p = sheet4_count+1;
		var s = 1;

		var cmdt_cd = "";
		var cmdt_nm = "";
		var cre_dt = "";
		var cre_usr_id = "";
		var vndr_seq = "";
		var trsp_grp_cmdt_cd = "";
		var rows = sheetObj.Rows;

		var sheet2_count =formObject.sheet2.RowCount;
		var k = sheet2_count+1;
		var sheet4_vndr_seq="";
		var sheet4_trsp_grp_cmdt_cd="";

		checkRows = sheetObj.CheckedRows("part");

		rArray = new Array(checkRows);
		if(sheet4_count >0){
			for(var t = 1; t < p; t++) {
				sheet4_vndr_seq = formObject.sheet4.CellValue(t, "vndr_seq");
				sheet4_trsp_grp_cmdt_cd = formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");
				bigyo_2=sheet4_vndr_seq+sheet4_trsp_grp_cmdt_cd;
				if(bigyo_1 == bigyo_2){

					var cmdt_cd = formObject.sheet4.CellValue(t, "cmdt_cd");
					var cmdt_nm = formObject.sheet4.CellValue(t, "cmdt_nm");
					var cre_dt = formObject.sheet4.CellValue(t, "cre_dt");
					var cre_usr_id = formObject.sheet4.CellValue(t, "cre_usr_id");
					var vndr_seq = formObject.sheet4.CellValue(t, "vndr_seq");
					var trsp_grp_cmdt_cd = formObject.sheet4.CellValue(t, "trsp_grp_cmdt_cd");

					formObject.sheet2.DataInsert(k);
					formObject.sheet2.CellValue2(k, "cmdt_cd") = cmdt_cd;
					formObject.sheet2.CellValue2(k, "cmdt_nm") = cmdt_nm;
					formObject.sheet2.CellValue2(k, "cre_dt") = cre_dt;
					formObject.sheet2.CellValue2(k, "cre_usr_id") = cre_usr_id;
					formObject.sheet2.CellValue2(k, "vndr_seq") = vndr_seq;
					formObject.sheet2.CellValue2(k, "trsp_grp_cmdt_cd") = trsp_grp_cmdt_cd;

					formObject.sheet2.RowStatus(k) ="R";	
					formObject.sheet2.RowBackColor(k)=formObject.sheet2.RgbColor(238,255,226);


					k=k+1;

				}else{
				}
			}//for(var t = 1; t < p; t++) {
		}//if(sheet4_count >0){
	}


		
	/**
	 * sheet2에 대한 onchange 이벤트처리 
	 *
	 */
	function sheet2_OnChange(sheetObj, row, col, value){

		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		var loop_val ="N";

		var inputStr = delSpace(value);

		switch(colName){

			case 'part':
				formObject.sheet2.RowStatus(row) ="D";				
			break;

		}
	}

		
	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}else{
			doActionIBSheet(sheetObject,formObject,SEARCH);
		}
	}
	

	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet2_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}

	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet3_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}


	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet4_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}


	/**
	 * 리셋펑션
	 */
	function fn_reset(){

		var formObject = document.form;	

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		
		formObject.vndr_cd.value="";
		formObject.vndr_nm.value="";
		formObject.vndr_commoodity_cd.value="";
		formObject.vndr_commoodity_nm.value="";

		formObject.rep_cmdt_cd.value="";
		formObject.rep_cmdt_nm.value="";
		formObject.cmdt_cd.value="";
		formObject.cmdt_nm.value="";

	}

	function fn_reset_01(){

		var formObject = document.form;	

		alert(ComTrimAll(formObject.amt.value,","));

	}

	function zeroInsert(str){

		var zero = "";

		for(var i=0;i<6-str.length;i++){
			zero += "0";
		}

		return zero + str;
	}
