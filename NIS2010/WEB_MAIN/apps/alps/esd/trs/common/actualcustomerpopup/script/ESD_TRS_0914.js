
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0914 : Booking 
 */
function ESD_TRS_0914() {
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
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_close":
				window.close();
			break;

			case "btn_ok":
				applyActualCustomer();
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
	
	if(ComTrim(document.form.dor_nod_cd.value) != ''){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}else if(ComTrim(document.form.act_cust_cd.value) != ''){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	document.form.INIT_FLAG.value   = 'N';  /* 초기화 이후 'N'으로 세팅한다.    2007-11-23  */

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
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon  --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
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
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
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
				style.height = GetSheetHeight(6);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Sts|SEQ|Customer Code|Customer Name" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,		0,		daCenter,		false,    "ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,	  30,		daCenter,		false,    "ac_seq",				false,		"",			dfNone,			0,			false,		false	);
				InitDataProperty(0, cnt++ , dtData,	 170,		daCenter,			false,    "act_cust_cd",		false,		"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 130,		daLeft,			false,    "cust_lgl_eng_nm",	false,		"",			dfNone,			0,			false,			false	);

                /* 2007-11-23 USA/AISA ACTUAL CUSTOMER 컬럼추가   */
				InitDataProperty(0, cnt++ , dtHidden,	 130,		daCenter,			false,    "trsp_act_cust_no",	false,		"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 130,		daCenter,			false,    "act_cust_cnt_cd",	false,		"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 130,		daCenter,			false,    "act_cust_seq"   ,	false,		"",			dfNone,			0,			false,			false	);
				
				ColHidden('ibflag')			= true;
		   }
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(6);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo( 10, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

                var lv_conti_cd       = document.form.CONTI_CD.value;
                if(lv_conti_cd == 'E')
                {
                    var HeadTitle = "Sts||Factory Name|Contact\nPIC Name|Address|Zip Code|Tel No.|Fax No.|Remark" ;
                }else{
                    var HeadTitle = "Sts||Act Customer\nName|Contact\nPIC Name|Address|Zip Code|Tel No.|Fax No.|Remark" ;
                }

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,	0,	daCenter,		false,    "ibflag");
				InitDataProperty(0, cnt++ , dtRadioCheck,	30,	daCenter,	false,    "ibcheck",			false,		"",		dfNone,		0,	true,	false	);
				InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,	false,    "fctry_nm",			false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,	false,    "cntc_pson_nm",		false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	 150,		daCenter,	false,    "fctry_addr",			false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	  60,		daCenter,	false,    "act_cust_pst_cd",	false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,	false,    "cntc_pson_phn_no",	false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,	false,    "cntc_pson_fax_no",	false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,	  50,		daCenter,	false,    "cntc_pson_req_rmk",	false,		"",		dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtHidden, 100,		daCenter,	false,    "act_cust_addr_seq",	false,		"",		dfNone,		0,	false,	false	);
				ColHidden('ibflag')			= true;
		   }
			break;
	}
}

// first Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	var lv_conti_cd       = formObj.CONTI_CD.value;
	var lv_door_node_cd   = formObj.dor_nod_cd.value;
	
	switch(sAction) {
	   case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction,lv_conti_cd)) return;
            
            /* DOOR NODE LENGTH CHECK */	   
        	if( (lv_door_node_cd == null || lv_door_node_cd == '' ) ||
        	    (lv_door_node_cd.length != 2 && lv_door_node_cd.length != 5 && lv_door_node_cd.length != 7) 
        	  )
        	{
        	    ComShowCodeMessage('TRS90122');    //TRS90122:The location code has been incorrectly inputted.
        	    return ;
        	}

			formObj.f_cmd.value = SEARCH07;
			sheetObj.DoSearch4Post("ESD_TRS_0914GS.do", TrsFrmQryString(formObj));
			break;
	}
}

// second Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction, row) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	   case IBSEARCH: //조회
			formObj.ACT_CUST_CNT_CD.value      = sheetObjects[0].CellValue(row, 'act_cust_cnt_cd')  ;
			formObj.ACT_CUST_SEQ.value         = sheetObjects[0].CellValue(row, 'act_cust_seq')     ;
			formObj.USA_TRSP_ACT_CUST_NO.value = sheetObjects[0].CellValue(row, 'trsp_act_cust_no') ;    //미주+아주 ACTUAL CUSTOMER : 2007-11-23

			formObj.f_cmd.value                = SEARCH08;
			sheetObj.DoSearch4Post("ESD_TRS_0914GS.do", TrsFrmQryString(formObj));
		break;
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH07 && sheetObj.RowCount > 0){
			doActionIBSheet2(sheetObjects[1],formObj, IBSEARCH, 1);
		}else if(formObj.f_cmd.value == SEARCH07 && sheetObj.RowCount == 0){
			sheetObjects[1].RemoveAll();
		}
	}
}



// second sheet 관련 이벤트 처리.
//function sheet1_OnDblClick(sheetObj, row, col){
//	doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH, sheetObj.SelectRow);
//}

// 사용자의 혼동을 방지하기 위해 onClick으로 교체
function sheet1_OnClick(sheetObj, row, col){
	doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH, sheetObj.SelectRow);
	sheetObjects[0].SelectCell(row,col,false); //선택 셀에 focus 재부여
	
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction,sContiCd){

	switch(sAction){
		case IBSEARCH:
		
		   /* 구주의 경우 Customer Code 검색필수조건 체크 */
           if(sContiCd == 'E')
           {
			//if(!checkLoc(formObj.dor_nod_cd)){
			//	return false;
			//}else if(!checkCustCd(formObj.act_cust_cd)){
			//	return false;
			//}else if(ComTrim(formObj.dor_nod_cd.value)     == '' &&
			//		 ComTrim(formObj.act_cust_cd.value) == '' &&
			//		 ComTrim(formObj.act_cust_nm.value) == ''){
            //    ComShowCodeMessage('COM12114', 'retrieve condition');
			//	return false;
			//}
           }
			
			if(  (formObj.dor_nod_cd.value  == null || ComTrim(formObj.dor_nod_cd.value)  == '') && 
			     (formObj.act_cust_cd.value == null || ComTrim(formObj.act_cust_cd.value) == '') && 
			     (formObj.fctry_nm.value    == null || ComTrim(formObj.fctry_nm.value)    == '')   )
			{
                ComShowCodeMessage('COM12114', 'retrieve condition');
				return false;
			}
						
			break;
	}
	return true;
}



/**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem)
{
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;
	}
	else
	{
		objs.style.display = "inline";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;
	}
}

/**
 * Location 조회 조건 체크
 */
function checkLoc(obj)
{
	if(obj.value.length != 0 && obj.value.length != 2 && obj.value.length != 5 && obj.value.length != 7 )
	{
	    var lv_init_flag  = document.form.INIT_FLAG.value;
		if(lv_init_flag != 'Y')    ComShowCodeMessage('COM12114', 'Location');
		obj.focus;
		return false;
	}
	obj.value = obj.value.toUpperCase();
	return true;
}

/**
 * Customer 조회 조건 체크
 */
function checkCustCd(obj)
{
	if(obj.value.length < 2 )
	{
	    var lv_init_flag  = document.form.INIT_FLAG.value;
		if(lv_init_flag != 'Y')    ComShowCodeMessage('COM12114', 'Customer Code');
		obj.focus;
		return false;
	}
	
	obj.value = obj.value.toUpperCase();
	return true;
}


/**
 * main page에 결과 리턴 main page에 applyAtualCustomer function이 정의되어 있어야 함.
 */
function applyActualCustomer()
{
    var sheetObj        = sheetObjects[0];
	var sheetObj1       = sheetObjects[1];
	var formObj         = document.form;
	var addr            = '';
	var addr_seq        = '';
	var act_cust_pst_cd = '';
	
	var mst_selected_row = '';

	if(sheetObj.RowCount < 1){
		ComShowCodeMessage('COM12114', 'First Sheet');
		return false;
	}

    if(sheetObj1.RowCount == 0)
    {
		ComShowCodeMessage('TRS90393');   //TES21905:No Data Found
		return false;
    }
    
	if(sheetObj1.RowCount > 0)
	{
		var checkList = sheetObj1.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}else{
		    mst_selected_row        = sheetObj.SelectRow;

		    act_cust_cd             = sheetObj.CellValue (mst_selected_row           , 'act_cust_cd'         ); /* act_cust_cnt_cd + act_cust_seq */
		    act_cust_cnt_cd         = sheetObj.CellValue (mst_selected_row           , 'act_cust_cnt_cd'     );
		    act_cust_seq            = sheetObj.CellValue (mst_selected_row           , 'act_cust_seq'        );		    
		    act_cust_nm             = sheetObj.CellValue (mst_selected_row           , 'cust_lgl_eng_nm'     );

		    factory_nm              = sheetObj1.CellValue(checkArray  , 'fctry_nm'            );
			factory_zip_code		= sheetObj1.CellValue(checkArray  , 'act_cust_pst_cd'     );
			factory_addr			= sheetObj1.CellValue(checkArray  , 'fctry_addr'          );
			act_cust_addr_seq		= sheetObj1.CellValue(checkArray  , 'act_cust_addr_seq'   );		    
            factory_tel_no          = sheetObj1.CellValue(checkArray  , 'cntc_pson_phn_no'    );
            factory_fax_no          = sheetObj1.CellValue(checkArray  , 'cntc_pson_fax_no'    );
            pic_nm                  = sheetObj1.CellValue(checkArray  , 'cntc_pson_nm'        );
		}
	}
	var sel_row = (sheetObj.SelectRow < 1 ? 1 : sheetObj.SelectRow);
	var cust_cd = sheetObj.CellValue(sel_row, 'cust_cnt_cd');
	var opener_obj = window.dialogArguments;
	opener_obj.applyAtualCustomer(self.window, formObj.ROW.value , act_cust_cd    , act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm);
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'dor_nod_cd':
			case 'act_cust_cd':
				value_upper(obj);
			case 'fctry_nm':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
		}
	}
}
