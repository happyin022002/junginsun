/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0019.js
 *@FileTitle : Transportation Report & Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.14
 *@LastModifier : 최 선
 *@LastVersion : 1.1
 * 2006.11.07 조풍연
 * 1.0 최초생성
 *----------------------------------------------------------
 * History
 * 2010.12.14  최 선	1.1 [CHM-201007747] W/O CC 상 오류 수정요청
 * 2011.11.17 민정호  1.2 [CHM-201114481] [TRS] W/O preview 상에 표현가능한 e-mail, fax 정보 room 확장요청
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0072 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0072() {
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
var sheetObjects 	= new Array();
var sheetCnt 	= 0;
var Mincount 	= 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 	= sheetObjects[0];
	var sheetObject2 	= sheetObjects[1];
	var sheetObject3 	= sheetObjects[2];

	var formObj 		= document.form;
	 /*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve1":
				if(!validateForm(sheetObject1, formObj, IBSEARCH, srcName )){
					return false;
				}
				doActionIBSheet (sheetObject1, formObj, IBSEARCH, srcName  );
				break;
			case "btn_retrieve2":
				if(!validateForm(sheetObject1, formObj, IBSEARCH, srcName ))	return;
				doActionIBSheet (sheetObject2, formObj, IBSEARCH, "FAX"    );
				doActionIBSheet (sheetObject3, formObj, IBSEARCH, "EMAIL"  );
				break;
			case "btn_reset":
				resetForm(formObj);
				break;
			case "btn_save":
				if (sheetObject2.RowCount > 0) {
					doActionIBSheet (sheetObject2, formObj, IBSAVE  , "FAX"    );
				}
				
				if (sheetObject3.RowCount > 0) {
					doActionIBSheet (sheetObject3, formObj, IBSAVE  , "EMAIL"  );
				}
				break;
			case "btn_provider":
				com_OnPopupClick("service_provider");
				break;
			case "btn_control_office":
				com_OnPopupClick("control_office");
				break;
			case "btn_location":
				com_OnPopupClick("location");
				break;
            case "btn_fax_row_add":
                var row = sheetObject2.DataInsert(-1);
                sheetObject2.CellValue2(row, 'trs_chk') = '1';
                break;
           case "btn_eml_row_add":
                var row = sheetObject3.DataInsert(-1);
                sheetObject3.CellValue2(row, 'trs_chk') = '1';
                break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
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
	for(i=0; i<sheetObjects.length; i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
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
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
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
		case 1:      //MAIN SHEET OBJECT
	        with (sheetObj) {
	            // 높이 설정
	            style.height = GetSheetHeight(10);
	            //전체 너비 설정
	            SheetWidth = MainTable.clientWidth;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostName != "") InitHostInfo(location.hostname, location.port, page_path);

	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;

	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 9, 100);

	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(8, 0, 0, true);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false)

	            var HeadTitle1 = "|Service Provider|Service Provider|Control Office|Location|Creation Office|Creation User Name|Creation Date" ;

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtRadioCheck,   50,	daCenter,  true,	"ibcheck"		,	false,	"",		dfNone,	0,	true,	true,	 5);
	            InitDataProperty(0, cnt++ , dtData		,  100,	daCenter,  true,	"vndr_seq"		,	false,	"",		dfNone,	0,	true,	true,	20);
	            InitDataProperty(0, cnt++ , dtData		,  250,	daLeft  ,  true,	"vndr_nm"		,	false,	"",		dfNone,	0,	true,	true,	10);
	            InitDataProperty(0, cnt++ , dtData		,  125,	daCenter,  true,	"ctrl_ofc_cd"	,	false,	"",		dfNone,	0,	true,	true,	20);
	            InitDataProperty(0, cnt++ , dtData		,  125,	daCenter,  true,	"loc_cd"		,	false,	"",		dfNone,	0,	true,	true,	15);
	            InitDataProperty(0, cnt++ , dtData		,  125,	daCenter,  true,	"cre_ofc_cd"	,	false,	"",		dfNone,	0,	true,	true,	10);
	            InitDataProperty(0, cnt++ , dtData		,  125,	daCenter,  true,	"cre_usr_id"	,	false,	"",		dfNone,	0,	true,	true,	15);
	            InitDataProperty(0, cnt++ , dtData		,  125,	daCenter,  true,	"cre_dt"		,	false,	"",		dfNone,	0,	true,	true,	15);
		   }
			break;

		case 2:      //FAX SHEET OBJECT
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(7);
                    //전체 너비 설정
                    SheetWidth = FaxTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle1 = "||TRS|MDM|Fax No" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus	,   0,     daCenter,  true,    "ibflag"																						       );
                    InitDataProperty(0, cnt++ , dtCheckBox		,   30,    daCenter,  true,    "ibcheck",       	false,    "",         dfNone,         0,          true,       true,      5 );
                    InitDataProperty(0, cnt++ , dtCheckBox		,   50,    daCenter,  true,    "trs_chk",       	false,    "",         dfNone,         0,         false,      false,      20, false, false, false, false);
                    InitDataProperty(0, cnt++ , dtCheckBox		,   50,    daCenter,  true,    "mdm_chk",       	false,    "",         dfNone,         0,         false,      false,      20, false, false, false, false);
                    InitDataProperty(0, cnt++ , dtData			,   90,    daCenter,  true,    "wo_fax_no"	,       false,    "",         dfNone,         0,          true,       true,      20);
                    InitDataProperty(0, cnt++ , dtHidden		,   90,    daCenter,  true,    "vndr_seq"	,       false,    "",         dfNone,         0,          true,       true,      20);
                    InitDataProperty(0, cnt++ , dtHidden		,   90,    daCenter,  true,    "wo_cc_seq"	,       false,    "",         dfNone,         0,          true,       true,      20);
		   }
			break;

		case 3:      //EMAIL SHEET OBJECT
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(7);
                    //전체 너비 설정
                    SheetWidth = EmailTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle1 = "||TRS|MDM|E-Mail Address" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus	,   0,    daCenter,  true,    	"ibflag"																					  );
                    InitDataProperty(0, cnt++ , dtCheckBox		,   30,   daCenter,  true,    	"ibcheck"		,	false,    "",         dfNone,         0,         true,       true,      5 );
                    InitDataProperty(0, cnt++ , dtCheckBox		,   50,   daCenter,  true,    	"trs_chk"		,   false,    "",         dfNone,         0,         false,      false,     20, false, false, false, false);
                    InitDataProperty(0, cnt++ , dtCheckBox		,   50,   daCenter,  true,    	"mdm_chk"		,   false,    "",         dfNone,         0,         false,      false,     20, false, false, false, false);
                    InitDataProperty(0, cnt++ , dtData			,   90,   daCenter,  true,    	"wo_eml"		,	false,    "",         dfNone,         0,         true,       true,      200);
                    InitDataProperty(0, cnt++ , dtHidden		,   90,   daCenter,  true,    	"vndr_seq"		,	false,    "",         dfNone,         0,         true,       true,      20);
                    InitDataProperty(0, cnt++ , dtHidden		,   90,   daCenter,  true,    	"wo_cc_seq"		,	false,    "",         dfNone,         0,         true,       true,      20);
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, srcName) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	   case IBSEARCH:	//조회
	   		switch(srcName) {
	   			case "btn_retrieve1":
	   				sheetObj.RemoveEtcData();
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
	   				break;

	   			case "FAX":
	   				formObj.SELECTED_VNDR_SEQ.value		= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "vndr_seq"	);
	   				formObj.SELECTED_CTRL_OFC_CD.value	= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "ctrl_ofc_cd"	);
	   				formObj.SELECTED_LOC_CD.value		= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "loc_cd"		);

					formObj.f_cmd.value 				= SEARCH01;
					sheetObj.DoSearch4Post("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
	   				break;

	   			case "EMAIL":
	   				formObj.SELECTED_VNDR_SEQ.value		= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "vndr_seq"	);
	   				formObj.SELECTED_CTRL_OFC_CD.value	= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "ctrl_ofc_cd"	);
	   				formObj.SELECTED_LOC_CD.value		= sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "loc_cd"		);

					formObj.f_cmd.value 				= SEARCH02;
					sheetObj.DoSearch4Post("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
	   				break;
	   		}
			break;

		case IBSAVE	:	//저장 - sheetObj2 -> sheetObj3
			
			if( sheetObj.RowCount < 1 ){
				ComShowCodeMessage('TRS90387', srcName);	//search result is empty
				return false;
			}

			/* 1건도 선택된 데이터 없으면 삭제처리 로직 수행 */
			if(!validateForm(sheetObj, formObj, IBSAVE	, srcName ))	return false;	/* 저장된 Checked Row 확인할 필요없음.	*/

			var checkList 				= sheetObj.FindCheckedRow('ibcheck');
			var checkArray 				= checkList.split('|');
			
			if(checkArray == '') return false;

			if(!confirm('Are you sure to proceed for ' + srcName + ' ?'))	return false;
			////var saveSheetObjQueryString	= sheetObj.GetSaveString(false, false, "ibcheck");
			
			sheetObj.RemoveEtcData();
			formObj.f_cmd.value 				= MULTI;
			formObj.FAX_EMAIL_INDICATOR.value	= srcName;		/****	FAX, EMAIL	****/
			
			sheetObj.DoSave("ESD_TRS_0072GS.do", TrsFrmQryString(formObj), "ibcheck", false);

			break;
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == MULTI){
			ComShowCodeMessage('COM12116', 'Fax Save');
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet3_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == MULTI){
			ComShowCodeMessage('COM12116', 'Email Save');
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){
	switch(sAction) {
			case IBSEARCH:
				switch(srcName){
					case "btn_retrieve1":
						if( formObj.combo_svc_provider.value == "" && formObj.control_office_cd.value == "" && formObj.location_cd.value == "" ){
							ComShowCodeMessage('TRS90378');		//조회항목1개는 입력해야함.
							return false;
						}
					break;

					case "btn_retrieve2":
		   				var checkList = sheetObj.FindCheckedRow('ibcheck');
						if(checkList == ''){
							ComShowCodeMessage('TRS90382');		//하나선택해야함.
							return false;
						}
					break;
				}
				break;

			case IBSAVE:
				/***************************************************************
					Validation Rule 1	: Search Data MIN 1개 존재.
					Validation Rule 2	: MAX 3개 까지만 Check 가능.
					Validation Rule 3	:
				****************************************************************/
				var checkList 			= sheetObj.FindCheckedRow('ibcheck');
				var checkArray 			= checkList.split('|');
				var checkArrayLength	= checkArray.length;

				if(checkArrayLength > 7){
					ComShowCodeMessage('TRS90379');	//TRS90379 - 최대3개까지 선택가능, 2011/11/10 최대6개까지 선택가능
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
 * rep_commodity팝업호출
 */
function com_OnPopupClick(param)
{
	var cmdt_cd_val 	= "";   			//향후 사용가능 예정변수
	var rep_cmdt_cd_val = "";   			//향후 사용가능 예정변수
	var cmdt_desc_val 	= "";   			//향후 사용가능 예정변수
	var classId 		= "";
	var xx1				= "";  				//CONTI
	var xx2				= "";  				//SUB CONTI
	var xx3				= "";  				//COUNTRY
	var xx4				= "";  				//STATE
	var xx5				= "";  				//CONTROL OFFIC
	var xx6				= "";  				//LOC CODE
	var xx7				= "";  				//LOC NAME
	var xx8				= "";
	var xx9				= "";

	if(param == "service_provider"){
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, "setServiceProvider", '1,0,1,1,1,1,1,1,1,1,1,1');
	}else if(param == "control_office"){
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 768, 447, "setControlOffice", '1,0,1,1,1,1,1,1,1,1,1,1');
	}else if(param == "location"){
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 772, 450, "setLocation", '1,0,1,1,1,1,1,1,1,1,1,1');
	}
}

/**
 * Service Provider 팝업에서 선택된값 SET
 */
function setServiceProvider(rowArray) {
	formObj						= document.form;
	formObj.combo_svc_provider.value	= rowArray[0][2];
	formObj.svc_provider.value		= rowArray[0][4];
}

/**
 * Control Office 팝업에서 선택된값 SET
 */
function setControlOffice(rowArray) {
	formObj							= document.form;
	formObj.control_office_cd.value	= rowArray[0][3];
}

/**
 * Location 팝업에서 선택된값 SET
 */
function setLocation(rowArray) {
	formObj						= document.form;
	formObj.location_cd.value	= rowArray[0][3];
}

/**
* 조회조건 reset
*/
function resetForm(formObj)
{
	formObj.combo_svc_provider.value 	= "";
	formObj.svc_provider.value 			= "";
	formObj.control_office_cd.value = "";
	formObj.location_cd.value		= ""

	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

function sheet1_OnChange(sheetObj, row, col, value){
	
	var formObj         = document.form;
	var colName         = sheetObj.ColSaveName(col);
	
	var sheetObject2 	= sheetObjects[1];
	var sheetObject3 	= sheetObjects[2];	
	
	switch(colName){
		case 'ibcheck':     /* Click --> Detail Serarch */
				doActionIBSheet (sheetObject2, formObj, IBSEARCH, "FAX"    );
				doActionIBSheet (sheetObject3, formObj, IBSEARCH, "EMAIL"  );
			break;
	}
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
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}

//Service Provider
function  vender_blur(){
	
	var formObj = document.form;
	formObj.combo_svc_provider.value = formObj.vndr_sequence.value;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !=""){
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i);
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}
		
		if(error_val !="Y" ) {
			//vender value값을 가져온다(SHEET1)
			formObj.f_cmd.value = SEARCHLIST12;
			sheetObjects[0].DoRowSearch("ESD_TRS_0065GS.do", TrsFrmQryString(formObj), false);

			//1개의 파라미터의 값을 조회후 가져온다.
			var x1 = sheetObjects[0].EtcData('CNT_CD1');
			if(x1 !="" || x1 !="undefined") {
				formObj.vndr_nm.value =x1;
			} else {
				ComShowCodeMessage("TRS90076");
				formObj.vndr_sequence.focus();
				formObj.vndr_nm.value ="";
			}
		} else {
			ComShowCodeMessage("TRS90076");
			formObj.vndr_sequence.focus();
			formObj.vndr_nm.value ="";
		}
	} else {
		formObj.vndr_nm.value ="";
	}
}

function sheet2_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	
	switch(colName)
	{
		case('ibcheck'):
            var checkList = sheetObj.FindCheckedRow('ibcheck');
            var checkArray = checkList.split('|');

            if(checkArray.length == 5){
                sheetObj.CellValue2(row, col) = '0';
            }
        break;
    }
}

function sheet3_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	
	switch(colName)
	{
		case('ibcheck'):
            var checkList = sheetObj.FindCheckedRow('ibcheck');
            var checkArray = checkList.split('|');

            if(checkArray.length == 8){					// 최대 6개까지 email 입력 가능
                sheetObj.CellValue2(row, col) = '0';
            }
        break;
		case('wo_eml'):
			var eMailchk = new RegExp('^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,6}\\b');
			var aRray = new Array();
			if( value.split(',').length > 1 ) {
				aRray = value.split(',');
				for( var e = 0; e < aRray.length; e++ ) {
					if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
						ComShowCodeMessage('TRS90525');
						//sheetObj.CellValue2(row, 'wo_eml') = '';
					}
				}
			} else if( value.split(';').length > 1 ) {
				aRray = value.split(';');
				for( var e = 0; e < aRray.length; e++ ) {
					if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
						ComShowCodeMessage('TRS90525');
						//sheetObj.CellValue2(row, 'wo_eml') = '';
					}
				}
			} else {
				if(!eMailchk.test(value) && value != '') {
					ComShowCodeMessage('TRS90525');
					//sheetObj.CellValue2(row, 'wo_eml') = '';
				}
			}
		break;
    }
}