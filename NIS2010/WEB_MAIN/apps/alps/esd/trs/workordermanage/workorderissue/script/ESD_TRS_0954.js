/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0023.js
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-17
*@LastModifier : Bong-jun
*@LastVersion : 1.13
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0954 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0954() {
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
var prefix = 'surcharge_';
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];

	 /*******************************************************/
	 var formObject = document.form;


	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_ok":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				
				var checkArray = checkList.split('|');
				
				for(var i=0; i<checkArray.length-1; i++){
					if(sheetObjects[0].CellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){
						if(sheetObjects[0].CellValue(checkArray[i], 'bsz_bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'biller_cd') == '' ){
							ComShowCodeMessage('COM12114', 'Bill Case and 3rd Party');
							return false;
						}
					}else{
						if(sheetObjects[0].CellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'biller_cd') == '' ){
							ComShowCodeMessage('COM12114', '3rd Party');							
							return false;
						}
					}					
				}
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				window.close();
			  break;

			case "btn_close":
				  window.close();
			  break;

			case "btng_save":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}			

				var checkArray = checkList.split('|');
				
				for(var i=0; i<checkArray.length-1; i++){
					if(sheetObjects[0].CellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){
						if(sheetObjects[0].CellValue(checkArray[i], 'bsz_bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'biller_cd') == '' ){
							ComShowCodeMessage('COM12114', 'Bill Case and 3rd Party');
							return false;
						}
					}else{
						if(sheetObjects[0].CellValue(checkArray[i], 'bill_case') == '' || sheetObjects[0].CellValue(checkArray[i], 'biller_cd') == '' ){
							ComShowCodeMessage('COM12114', '3rd Party');							
							return false;
						}
					}
					if(sheetObjects[0].CellValue(checkArray[i], 'n3pty_amt') <= 0 ){
						ComShowMessage('Amount is more than 0.\n\n Please check profit.');							
						return false;
					}
				}
				doActionIBSheet(sheetObject,formObject,IBSAVE);
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
		ComConfigSheet(sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
// 테스트시 주석처리 09.08.20
	var bzc_sheetObj = opener.sheetObjects[0];
	var surcharge_sheetObj = sheetObjects[1];
	var formObj = document.form;

	sheetObjects[0].WaitImageVisible = false;
	formObj.f_cmd.value = SEARCH04;
	sheetObjects[0].DoSearch4Post("ESD_TRS_0023GS.do", TrsFrmQryString(formObj));
	sheetObjects[0].InitDataCombo(0, 'bsz_bill_case', sheetObjects[0].EtcData('bil_cs_nm'), sheetObjects[0].EtcData('bil_cs_cd'));
	if(formObj.open_mode.value == 'search'){
		doActionIBSheet(surcharge_sheetObj, formObj, 'SEARCH_BY_SHEET');
		if(surcharge_sheetObj.RowCount < 1){	
			doActionIBSheet(surcharge_sheetObj, formObj, IBSEARCH);
		}
	}else if(formObj.open_mode.value == 'modify'){
		doActionIBSheet(surcharge_sheetObj, formObj, 'SEARCH_BY_SHEET');
		if(surcharge_sheetObj.RowCount < 1){
			doActionIBSheet(surcharge_sheetObj, formObj, IBSEARCH);
		}
	}
	readSurchargeSheet(sheetObjects[0], surcharge_sheetObj, bzc_sheetObj);
	if(sheetObjects[0].CellValue(sheetObjects[0].RowCount, 'lgs_cost_full_nm') == 'Basic Amount'){
		if(document.form.sheet_arr_no.value  == 3){
			sheetObjects[0].RowEditable(sheetObjects[0].RowCount) = false;
		}else if(document.form.open_mode.value == 'search'){
			sheetObjects[0].Editable = false;
		}else{
			sheetObjects[0].CellEditable(sheetObjects[0].RowCount, 'bsz_bill_case') = true;
		}		
	}else{
		if(document.form.open_mode.value == 'search'){
			sheetObjects[0].Editable = false;
		}
	}
				checkTPBIf(); 

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

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
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
    //?????? ???
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
 * 로그인한 사용자의 OFC CD Default Currency를 설정한다.
 */
function initCurrency(){
//	var sheetObj = sheetObjects[0];
//	var formObj = document.form;
//
//	formObj.f_cmd.value = SEARCH12;
//	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
}

/**
 * 기존 저장된 3rd Party Currency를 설정한다.
 */
function callCurrency(){
//	var sheetObj = sheetObjects[0];
//	var formObj = document.form;
//
//	formObj.f_cmd.value = SEARCH17;
//	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var formObj = document.form;

	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
				style.height=GetSheetHeight(6);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "|TRS code|Billing Case|Amount|3rd Party|3rd Party|Remarks" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDummyCheck, 30,  daCenter,  false,    "ibcheck",     false,          "",       dfNone,   		0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       150,  daCenter,  false,	"lgs_cost_full_nm",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  false,    "bsz_bill_case",     false,          "",       dfNone,   		0,     false,      false);
				if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  false,    "n3pty_amt",     false,          "",       dfInteger,  		0,     true,      true, 13);
				}else{
					InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  false,    "n3pty_amt",     false,          "",       dfFloat,   		2,     true,      true, 15);
				}			
				InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  false,    "bill_case",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtPopup,      80,  daCenter,  false,    "biller_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,       150,  daCenter,  false,   "n3pty_desc",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"lgs_cost_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"unique_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"cust_cnt_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"cust_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"n3pty_vndr_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"n3pty_ofc_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,   true,	"ibflag");
				
				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]				
				InitDataCombo(0, 'bill_case', bill_caseText, bill_caseCode);
				ColHidden('ibflag')					= true;
			}
			break;

		case 2: //surcharge sheet
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(56, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"ibcheck");
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'unique_cd'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_seq'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_full_nm'       ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'trsp_step_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt'		        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_no'		        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'grs_wgt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no_split'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'		            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scg_amt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incur_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_no'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_bil_flg'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             ,false,"",dfNone,0,true,true);
		   		InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_curr_cd'          ,false,"",dfNone,0,true,true);
		   }
		   break;
		   
		 case 3:      //t1sheet1 init
			with (sheetObj) {
				style.height=0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "|Billing Case|Amount|Remarks|Billing Case|" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDummyCheck, 30,  daCenter,  false,    "ibcheck",     false,          "",       dfNone,   		0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      80,  daCenter,  false,    "inv_bsz_bill_case",     false,          "",       dfNone,   		0,     false,      false);
				if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  false,    "inv_bsz_n3pty_amt",     false,          "",       dfInteger,  		0,     true,      true);
				}else{
					InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  false,    "inv_bsz_n3pty_amt",     false,          "",       dfFloat,   		2,     true,      true);
				}							
				InitDataProperty(0, cnt++ , dtData,       150,  daCenter,  false,   "inv_bsz_n3pty_desc",     false,          "",       dfNone,   		0,     true,      true);				
				InitDataProperty(0, cnt++ , dtData,     0,   daCenter,  false,	"inv_bsz_cust_cnt_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,     0,   daCenter,  false,	"inv_bsz_cust_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,     0,   daCenter,  false,	"inv_bsz_n3pty_vndr_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,     0,   daCenter,  false,	"inv_bsz_n3pty_ofc_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,   true,	"ibflag");
				
				ColHidden('ibflag')					= true;
			}
			break;
			
		  case 4:      //t1sheet1 init
			with (sheetObj) {
				style.height=0;
				//전체 너비 설정
				SheetWidth = 0;
				
//         		style.height=GetSheetHeight(10);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 2,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				
				var HeadTitle = "SO OFC|SO SEQ|IF_FLG";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_so_ofc'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
                InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_so_seq'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
                InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_flg'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
			}
			break;     
	}
}

// Sheet관련 프로세스 처리
// N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var TPB_sheetObj = sheetObjects[3];

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0918GS.do", TrsFrmQryString(formObj));
			break;

		case IBSAVE:      //저장
           if (	TPB_sheetObj.CellValue(1, 'if_flg') == 'Y' ) {
 			ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
             break;
           }
			setSurchargeSheet(sheetObj, sheetObjects[1]);
			setBasicSheet(sheetObj, opener.sheetObjects[0]);
			set3rdPartyBilling(sheetObjects[1], formObj);
//			setBasicSheet2(sheetObj, opener.sheetObjects[0]);  ---- 리셋 기능 필요시 추가 개발 진행필요 09.11.18
			break;

		case 'SEARCH_BY_SHEET':
			var queryStr = '';
			var colName = '';
			var sheetObj_surcharge = opener.sheetObjects[formObj.sheet_arr_no.value];
			for(var row=1; row<sheetObj_surcharge.RowCount+1; row++){
//				if(formObj.unique_cd.value == sheetObj_surcharge.CellValue(row, prefix+'unique_cd')){  --- 23.js에서 unique_cd 생성에 문제 있음 확인 필요 so_seq와 일치하므로 일단 대체함
				if(formObj.unique_cd.value == sheetObj_surcharge.CellValue(row, prefix+'trsp_so_seq')){
					for(var i=0; i<= sheetObj_surcharge.LastCol; i++){
						colName = sheetObj_surcharge.ColSaveName(i);
						queryStr += '&'+colName +'='+sheetObj_surcharge.CellValue(row, colName);
					}
				}
			}
			sheetObj.DoSearch4Post("ESD_TRS_0969.screen", queryStr+'&'+TrsFrmQryString(formObj),'', false);
			break;
	}
}

/**
 * Surcharge Input Inquiry popup으로부터 data 전송받기
 **/
function set3rdPartyBilling(pop_sheetObj, formObj)
{
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;
	var surcharge_sheetObj = opener.sheetObjects[formObj.sheet_arr_no.value];
	var main_sheetObj = opener.sheetObjects[0];

	// 이전에 세팅됐던 값은 지워버린다.
	for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
	{
		if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
	}
	
	var queryStr = pop_sheetObj.GetSaveString(true, true, 'ibcheck');
//	if(queryStr=='') return false;
	var url = '?prefix='+prefix;
	
	surcharge_sheetObj.DoSearch4Post("ESD_TRS_0969.screen"+url, queryStr,'', true);
	
	main_sheetObj.CellValue(formObj.main_row.value, 'n3pty_bil_flg')='Y';
	main_sheetObj.CellValue2(formObj.main_row.value, 'n3pty_curr_cd') 
		= surcharge_sheetObj.CellValue(formObj.main_row.value, prefix+'n3pty_curr_cd');
	ComShowCodeMessage('COM12116', 'Save');
	window.close();
}

/**
 * surcharge sheet를 읽어 main sheet에 넣는다.
 */
function readSurchargeSheet(mainSheetObj, surchargeSheetObj, bzc_sheetObj){

	var formObj = document.form;
	var queryStr = surchargeSheetObj.GetSaveString(true, false);	 
	var queryStr2 = '';
	
	if(document.form.open_mode.value == 'search' || document.form.sheet_arr_no.value  == 3){
		formObj.f_cmd.value = SEARCH05;
		sheetObjects[2].DoSearch4Post("ESD_TRS_0023GS.do", TrsFrmQryString(formObj));
		queryStr2 = sheetObjects[2].GetSaveString(true, false)
	}else{
		queryStr2 = '&po_basic_rt='+bzc_sheetObj.CellValue(document.form.main_row.value, 'po_basic_rt');
		queryStr2 += '&n3pty_bzc_amt='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_amt');
		queryStr2 += '&n3pty_bzc_vndr_seq='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_vndr_seq');
		queryStr2 += '&n3pty_bzc_ofc_cd='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_ofc_cd');
		queryStr2 += '&n3pty_bzc_desc='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_desc');
		queryStr2 += '&n3pty_bzc_cust_seq='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_cust_seq');
		queryStr2 += '&n3pty_bzc_cust_cnt_cd='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd');
		queryStr2 += '&n3pty_bzc_tp_cd='+bzc_sheetObj.CellValue(document.form.main_row.value, 'n3pty_bzc_tp_cd');
	}
	
	mainSheetObj.DoSearch4Post("ESD_TRS_0971.screen", queryStr+queryStr2, TrsFrmQryString(formObj), true);

	if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
		for(var i=1; i< mainSheetObj.RowCount+1; i++){
			mainSheetObj.CellValue2(i, 'n3pty_amt') = chkAmtPos_JPY(mainSheetObj.CellValue(i, 'n3pty_amt'));
		}
	}
}

/**
 * popup click 이벤트
 */
function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);
	switch(colName)
	{
		case('biller_cd'):
			if(sheetObj.CellValue(row, 'bill_case') == 'CS'){
				ComOpenPopup('/hanjin/COM_ENS_041.do', 780, 460, 'getCustomerPop', '1,0,1,1,1,1,1,1',true, false,row,col);
			}else if(sheetObj.CellValue(row, 'bill_case') == 'SP'){
				ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 440, 'getVndrSeq', '1,0,1,1,1,1,1,1',true, false,row,col);
			}else if(sheetObj.CellValue(row, 'bill_case') == 'HJ'){
				ComOpenPopup('/hanjin/COM_ENS_091.do', 780, 540, 'getStaffPop', '1,0,1,1,1,1,1,1',true, false,row,col);
			}
		break;
	}
}

/**
 * OnChange click 이벤트
 */
function sheet1_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{
		case('bill_case'):
			sheetObj.CellValue2(row, 'biller_cd') = '';
			sheetObj.CellValue2(row, 'cust_cnt_cd') = '';
			sheetObj.CellValue2(row, 'cust_seq') = '';
			sheetObj.CellValue2(row, 'n3pty_vndr_seq') = '';
			sheetObj.CellValue2(row, 'n3pty_ofc_cd') = '';
		break;
	}

	switch(colName)
	{
		case('n3pty_amt'):
		case('biller_cd'):
		case('n3pty_desc'):
			sheetObj.CellValue2(row, 'ibcheck') = 1;
		break;
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;
	var bil_curr_cd = null;
	var n3pty_curr_cd = null;
	
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
		formObj.f_cmd.value = '';
	}else{
		/* 로그인한 사용자의 OFFICE CD에 해당되는 CURRENCY로 설정한다. */
		if(formObj.f_cmd.value == SEARCH12){
			bil_curr_cd = sheetObj.EtcData('bil_curr_cd');
		}else if(formObj.f_cmd.value == SEARCH17){
			n3pty_curr_cd = sheetObj.EtcData('n3pty_curr_cd');
		}
		var selectObj = formObj.apply_currency;
			for(var i=0; i<selectObj.length; i++){
				if( selectObj.options[i].value == bil_curr_cd){
					selectObj.options[i].selected = true;
					selectedIdx = i;
					break;
				}else if(selectObj.options[i].value == n3pty_curr_cd){
					selectObj.options[i].selected = true;
					selectedIdx = i;
					break;
				}
			}
			formObj.f_cmd.value = '';
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	
	
}

/**
 * customer 팝업에서 값 가져오기
 */
function getCustomerPop(rowArray, row, col){
	var formObj = document.form;
	var colArray = '';
	if(rowArray.length>0)
	{
		colArray = rowArray[0][3];
	}
	sheetObjects[0].CellValue(row, 'biller_cd') = colArray;
	sheetObjects[0].CellValue2(row, 'cust_cnt_cd') = colArray.substring(0,2);
	sheetObjects[0].CellValue2(row, 'cust_seq') = get_only_num(colArray);
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getVndrSeq(rowArray, row, col) {

	var formObj = document.form;
	var colArray = '';

	if(rowArray.length>0)
	{
		colArray = get_only_num(rowArray[0][2]);
	}
	
	sheetObjects[0].CellValue(row, 'biller_cd') = colArray;
	sheetObjects[0].CellValue2(row, 'n3pty_vndr_seq') = colArray;
}

/**
 * staff 팝업에서 값 가져오기
 */
function getStaffPop(rowArray, row, col){
	var formObj = document.form;
	var colArray = '';

	if(rowArray.length>0)
	{
		colArray = rowArray[0][3];
	}
	sheetObjects[0].CellValue(row, 'biller_cd') = colArray;
	sheetObjects[0].CellValue2(row, 'n3pty_ofc_cd') = colArray;
}

/**
 * 숫자만 사용가능
 */
function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i=0; i<str.length; i++){
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
		returnNum += str.charAt(i);
	}

	return returnNum;
}

/**
 * Surcharge sheet로 값 이동
 */
function setSurchargeSheet(mainSheet, surchargeSheet){
	
	var checkList = mainSheet.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	var cnt=0;
	var index = 0;
	var formObj = document.form;
	var invSurchgSheet = opener.sheetObjects[3];
	
	for(var i=0; i<checkArray.length-1; i++)
	{		
		
		if(sheetObjects[0].CellValue(checkArray[i], 'lgs_cost_full_nm') == 'Basic Amount'){			
			return false;
		}
		index = surchargeSheet.FindText(prefix+'lgs_cost_cd', mainSheet.CellValue(checkArray[i],'lgs_cost_cd'));
		
		surchargeSheet.CellValue2(index, prefix+'unique_cd') = formObj.unique_cd.value;
		surchargeSheet.CellValue2(index, prefix+'n3pty_amt') = mainSheet.CellValue(checkArray[i],'n3pty_amt');
		surchargeSheet.CellValue2(index, prefix+'n3pty_desc') = mainSheet.CellValue(checkArray[i],'n3pty_desc');
		surchargeSheet.CellValue2(index, prefix+'cust_cnt_cd') = mainSheet.CellValue(checkArray[i],'cust_cnt_cd');
		surchargeSheet.CellValue2(index, prefix+'cust_seq') = mainSheet.CellValue(checkArray[i],'cust_seq');
		surchargeSheet.CellValue2(index, prefix+'n3pty_vndr_seq') = mainSheet.CellValue(checkArray[i],'n3pty_vndr_seq');
		surchargeSheet.CellValue2(index, prefix+'n3pty_ofc_cd') = mainSheet.CellValue(checkArray[i],'n3pty_ofc_cd');
		surchargeSheet.CellValue2(index, prefix+'n3pty_curr_cd') = document.form.apply_currency.value;
		surchargeSheet.CellValue2(index, prefix+'n3pty_bil_flg') = 'Y';
		
	}
}

/**
 * Basic sheet로 값 이동
 */
function setBasicSheet(mainSheet, basicSheet){
	var checkList = mainSheet.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var formObj = document.form;
	var row = sheetObjects[0].RowCount;
	if(sheetObjects[0].CellValue(row, 'lgs_cost_full_nm') == 'Basic Amount' && sheetObjects[0].CellValue(row, 'ibcheck') == true){
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_amt') = mainSheet.CellValue(mainSheet.RowCount,'n3pty_amt');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_vndr_seq') = mainSheet.CellValue(mainSheet.RowCount,'n3pty_vndr_seq');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_ofc_cd') = mainSheet.CellValue(mainSheet.RowCount,'n3pty_ofc_cd');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_desc') = mainSheet.CellValue(mainSheet.RowCount,'n3pty_desc');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_cust_seq') = mainSheet.CellValue(mainSheet.RowCount,'cust_seq');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd') = mainSheet.CellValue(mainSheet.RowCount,'cust_cnt_cd');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_tp_cd') = mainSheet.CellValue(mainSheet.RowCount,'bsz_bill_case');
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_curr_cd') = document.form.apply_currency.value;
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bil_flg') = 'Y';				
	}		
}

/**
 * Basic sheet로 값 이동
 */
function setBasicSheet2(mainSheet, basicSheet){
	var checkList = mainSheet.FindCheckedRow('ibcheck');
	if(checkList != ''){
		return false;
	}
	var formObj = document.form;
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_amt') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_vndr_seq') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_ofc_cd') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_desc') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_cust_seq') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_cust_cnt_cd') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_tp_cd') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bzc_curr_cd') = '';
		basicSheet.CellValue2(document.form.main_row.value, 'n3pty_bil_flg') = '';				
}

function checkTPBIf() {

	var formObj = document.form;
	var sheetObj = sheetObjects[3];
		formObj.f_cmd.value = SEARCH04;
		sheetObj.DoSearch4Post("ESD_TRS_0918GS.do", TrsFrmQryString(formObj));
//	var if_flg = sheetObj.CellValue(1, 'if_flg')
	var if_flg = sheetObj.EtcData('if_flg')
	
	if (if_flg=='Y'){
			ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
	}
 return if_flg;
}
