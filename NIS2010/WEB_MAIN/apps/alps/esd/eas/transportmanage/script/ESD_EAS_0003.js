/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_003.js
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-10
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-12-10 Kim Jun Ho
* 1.0 
=========================================================*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */


/*
 * @extends Bkg
 * @class ESD_EAS_0003 : Booking 
 */
function ESD_EAS_0003() {
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
var Mincount 	= 0;


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
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
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
     //Axon 
//             axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//             axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//             axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//             axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//             axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//             axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//             axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
 }


 //Axon --- start
 /**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
  **/
 function engnum_keypress() {

//             ComKeyOnlyAlphabet('uppernum');
 }

 /**
  * BKG Creation manual <br>
  **/
 function manual_click() {
     //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//             form.boo_bkg_no.readOnly =!form.manual.checked;
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
//             return ComChkObjValid(event.srcElement);
 }

 /**
  * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
  **/
 function obj_focus(){
//             ComClearSeparator(event.srcElement);
 }

 /**
  * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
  **/
 function obj_keypress(){

//             ComKeyOnlyNumber(event.srcElement);
 }

 //Axon 이벤트 처리2. 이벤트처리함수 --- end
 
 /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	var formObject = document.form;

	/*******************************************************/	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
	
			case "btn_retrieve":
				if (formObject.btns_radio_kind[0].checked == true ) {
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "btn_retrieve"  );
				} else {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "btn_retrieve"  );
				}
				break;

			case "btn_new":

				fn_reset();
				break;
					
			case "btn_downexcel":
				if (formObject.btns_radio_kind[0].checked == true ) {
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				} else {
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				}
				break;
				
			case "so_month":
				if ( formObject.btns_radio_date[0].checked == true ) {
					formObject.so_month.value="";
				}else {
					formObject.so_month.disabled = true;
				}
				break;
				
			case "fm_so_date":
				if ( formObject.btns_radio_date[1].checked == true ) {
					formObject.fm_so_date.value="";
				}else {
					formObject.fm_so_date.disabled = true;
					formObject.to_so_date.disabled = true;
				}
				break;
			
			case "to_so_date":
				if ( formObject.btns_radio_date[1].checked == true ) {
					formObject.to_so_date.value="";
				}else {
					formObject.fm_so_date.disabled = true;
					formObject.to_so_date.disabled = true;
				}
				break;
				
			case 'btns_calendar':
				if( formObject.btns_radio_date[1].checked == true ) {
					getCalendar();
				}
				break;
			
		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111"));
		} else {
			ComShowMessage(e);
		}
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:
				
			if(!validateForm(sheetObj, formObj, IBSEARCH	, "btn_retrieve" ))	return false;
				
			document.form.so_ofc_cd.value = document.form.so_ofc_cd.value.toUpperCase();

			if( formObj.btns_radio_kind[0].checked == true ){
				sheetObjects[0].RemoveAll();  //Supplement S/O sheet
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_EAS_0003GS.do", EasFrmQryString(formObj));
			} else {
			    sheetObjects[1].RemoveAll();  //Other S/O sheet
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_EAS_0003GS.do", EasFrmQryString(formObj));
			}
			break;

		//ExcelDownload			
		case IBDOWNEXCEL:
		    sheetObj.Down2Excel(-1, false, false, true);
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
		case 1:      //sheet1 init
			with (sheetObj) {
			
                // 높이 설정
                 style.height = GetSheetHeight(15) ;
                //전체 너비 설정
                SheetWidth = mainTable1.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 9, 100);
	
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(41, 4, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);

                var HeadTitle  = "EQ No.|TP/SZ|Bound|BKG\nTerm|Cost\nMode|Trans\nMode|";
               	HeadTitle += "From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc|Door Loc|";
               	HeadTitle += "Actual\nCustomer|Door Delivery\nAddress|";
               	HeadTitle += "Service Provider|Service Provider|BKG No|BL No|T.VVD|S/O No|W/O No|W/O\nCreation Date|";
               	HeadTitle += "Invoice No|Invoice\nConfirm Date|Reason|";
               	HeadTitle += "Amount Kind|Default\nS/P|S/P\nType|Agmt Rate TP|Oneway\nRoundTrip|Currency|Basic|Nego|Fuel|Additional|Total";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
	
                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                
				InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "eq_no"					,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //01
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "eq_tpsz_cd"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //02
				InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "io_bound"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //03
				InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "bkg_term"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //04
				InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,    "trsp_cost_dtl_mod_cd"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //05
                InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,    "trsp_crr_mod_cd"		,   false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //06
				InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,    "fm_loc"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //07
                InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true,    "fm_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //08
                InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,    "via_loc"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //09
                InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true,    "via_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //10
                InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,	"to_loc"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //11
                InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true,    "to_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //12
                InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true,    "dor_loc"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //13
                InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true,    "dor_zone"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //14
				InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "cust_val"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //15
                InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "dor_de_addr"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "vndr_seq"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,   100	,   daLeft	,  true,    "vndr_nm"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "bkg_sq"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //19
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "bl_no"					,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //20
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "truck_vvd"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //21
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "so_number"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //22
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "wo_number"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //23
                InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "cre_dt"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //24
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "inv_no"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //25
                InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "inv_cfm_dt"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //26
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true,    "spl_iss_rsn"			,	false,  "",	dfNone		,   0,  false ,	false,		100,	false,		false,	   "",	  false	);  //27
                InitDataProperty(0, cnt++ , dtData			,   80	,   daLeft  ,  false,   "amount_kind"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //28
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "trsp_dflt_vndr_flg"	,	false,  "",	dfNone		,	2,  false,	false,		100,	false,		false,	   "",	  false	);  //29
				InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "sp_type"			 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //30
				InitDataProperty(0, cnt++ , dtCombo			,   90	,   daCenter,  false,   "agmt_rate_type_nm" 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //31
				InitDataProperty(0, cnt++ , dtCombo			,   90	,   daCenter,  false,   "way_type"			 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //32
                InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "curr_cd"				,	false,  "",	dfNone		,	2,  false ,	false,		100,	false,		false,	   "",	  false	);  //33
                InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "bzc_amt"				,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //34
                InitDataProperty(0, cnt++ , dtData			,	90	,   daRight	,  false,	"nego_amt"			    ,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //35
                InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "fuel_scg_amt"			,   false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //36
                InitDataProperty(0, cnt++ , dtData			,	90	,   daRight	,  false,	"etc_add_amt"			,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //37
                InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "total_amt"				,   false,  "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|", dfNullFloat, 2, false, false, 10 , false,		true,	   "",	  false	);  //38

				InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "basis_no"				,	false,  "",	dfNone		,   2,	false,	false,		100,	false,		false,	   "",	  false	);  //37
				InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "basis_no2"				,	false,  "",	dfNone		,   2,	false,	false,		100,	false,		false,	   "",	  false	);  //38
				InitDataProperty(0, cnt++,  dtHidden		,  	30	,   daCenter,  false,   "ibcheck"                                                                                                                    	);  //39


				InitDataCombo(0, "way_type", " |"+way_typeText, " |"+way_typeCode);
				InitDataCombo(0, "agmt_rate_type_nm", " |"+agmt_rate_type_nmText, " |"+agmt_rate_type_nmCode);
	
				ColHidden('ibflag')				= true;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(15) ;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(36, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle1 = "SO No.|EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|SML/\nCNT|Cust\nCode|Cost\nMonth|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason";
				var HeadTitle2 = "SO No.|EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|SML/\nCNT|Cust\nCode|Cost\nMonth|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Actual\nCustomer|Door Delivery\nAddress|Provider Code|Provider Name|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason";
				

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  true,    "so_no",				false,  		"",		 dfNone,   	  0,  	 false,		  false,		  11);  
                InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      			false,          "",      dfNone,      0,     false,       false,          11);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "eq_tpsz_cd",       	false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_bnd_cd",      	false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cgo_tp_cd",      		false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daRight,  true,     "cntr_wgt",      		false,          "",      dfFloat,     2,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "wgt_meas_ut_cd",       false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd", false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cmdt_cd",      		false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_nomi_trkr_flg_nm",false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_cnt_cd_seq",      false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_otr_cost_mon_dt", false,          "",      dfNone,      0,     false,       false,           4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "fm_yard_value",      	false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "via_yard_value",      	false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",     	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "to_yard_value",      	false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "dr_yard_value",      	false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "act_cust_cnt_cd_seq",  false,          "",      dfNone,      0,     false,       false,           8);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "dor_de_addr",      	false,          "",      dfNone,      0,     false,       false,         200);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_seq",      		false,          "",      dfNone,      0,     false,       false,           6);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_desc",      		false,          "",      dfNone,      0,     false,       false,          50);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "curr_cd",      		false,          "",      dfNone,      0,     false,       false,           3);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "bzc_amt",      		false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "nego_amt",      		false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "fuel_scg_amt",      	false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,	  	  90,   daCenter,  true,    "etc_add_amt",      	false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "total_amt",      		false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,       100,  daCenter,  true,    "ref_bkg_no",      		false,          "",      dfNone,      2,     false,       false,          11);
				
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      		false,          "",      dfNone,      0,     false,       false,          12);
				InitDataProperty(0, cnt++ , dtData,      300,   daLeft,    true,    "trsp_purp_rsn",   		false,          "",      dfNone,      2,     false,       false,        1000);


				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++,  dtHidden,   30,   daCenter,  true,    "ibcheck");

//				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "sen_wo_no",      false,          "",      dfNone,      0,     true,       true,          12);
//				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "rate_apply",      false,         "",      dfNone,      2,    false,     false,          10);
//				InitDataProperty(0, cnt++,  dtSeq,		   0,   daCenter,  true,    "surcharge_key");

				ColHidden('ibflag')				= true;
//				ColHidden('surcharge_key')		= true;
//				ColHidden('inv_xch_rt')			= true;

				//InitDataCombo(0, 'curr_cd', " |"+default_currText, " |"+default_currCode);
//				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
				
			}
			break;

	}
}




/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){
    var formObject = document.form;	
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	switch(sAction) {
		case IBSEARCH:
			switch(srcName){
				case "btn_retrieve":

					if ( formObject.btns_radio_date[0].checked == true ) {
						var check_so_month 	= formObject.so_month.value ;
						if(check_so_month == '' || check_so_month == null || check_so_month == 'YYYYMM') 
						{	
							ComShowCodeMessage("EAS90009");
							fn_reset();
							return false;
						}
						formObject.fm_so_date.value="YYYYMMDD";
						formObject.to_so_date.value="YYYYMMDD";						
						
						
					} else if( formObject.btns_radio_date[1].checked == true ) {
						var check_fm_so_date = formObject.fm_so_date.value ;
						var check_to_so_date = formObject.to_so_date.value ;
						if((check_fm_so_date == '' || check_fm_so_date == null || check_fm_so_date == 'YYYYMMDD') || (check_to_so_date == '' || check_to_so_date == null || check_to_so_date == 'YYYYMMDD')) 
						{
							ComShowCodeMessage("EAS90010");
							fn_reset();
							return false;
						}
						formObject.so_month.value="YYYYMM";				
						
					}
					
//					if(formObject.so_ofc_cd.value == '') {
//						var errMsg = ComGetMsg("EAS90004" , 'S/O Office');
//						ComShowMessage(errMsg);
//						return false;
//					}
					
				break;
			}
			break;
	}
	return true;
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Supplement S/O sheet
	sheetObjects[1].RemoveAll();  //Other S/O sheet

	formObject.so_ofc_cd.value="";
	formObject.bound.value="A";
	formObject.so_month.value="YYYYMM";
	formObject.fm_so_date.value="YYYYMMDD";
	formObject.to_so_date.value="YYYYMMDD";
	formObject.btns_radio_date[0].checked = true
	formObject.btns_radio_kind[0].checked = true
}	

function fun_Focus(obj)
{
	var val = obj.value;
	obj.value = val;
	obj.select();
}

/**
 * 라디오버튼을 누를시 period
 */
function change_period(){
	var formObject = document.form;
	var val="";	

	if ( formObject.btns_radio_date[0].checked == true ) {
		formObject.hid_period.value="M";   //S/O Month  
		formObject.so_month.disabled = false;
		formObject.fm_so_date.disabled = true;
		formObject.to_so_date.disabled = true;
		
	}else if( formObject.btns_radio_date[1].checked == true ) {
		formObject.hid_period.value="D";   //S/O Date
		formObject.fm_so_date.disabled = false;
		formObject.to_so_date.disabled = false;
		formObject.so_month.disabled = true;
		
	}else{
		formObject.hid_period.value="M";
	}
}

/**
 * 라디오버튼을 누를시 kind
 */
function change_val(){
	
	var formObject = document.form;

	if ( formObject.btns_radio_kind[0].checked == true ) {
		document.all.suppleLayer.style.display = "inline";
		document.all.otherLayer.style.display = "none";

	}else if( formObject.btns_radio_kind[1].checked == true ) {
		document.all.suppleLayer.style.display = "none";
		document.all.otherLayer.style.display = "inline";
	}
}

/**
 * Calendar Popup
 */
function getCalendar(){
	var cal2 = new ComCalendarFromTo();
	cal2.displayType = "date";
	cal2.select(document.form.fm_so_date, document.form.to_so_date, 'yyyyMMdd');
}


