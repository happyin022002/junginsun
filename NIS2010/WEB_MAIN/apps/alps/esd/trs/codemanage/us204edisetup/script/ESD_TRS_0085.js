/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0085.js
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2013-04-19
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2013-04-19 조인영
* History
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


function ESD_TRS_0085() {
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
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	/*******************************************************/	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;

			case "btn_new":
				fn_reset();
				break;
					
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
				
			case 'btn_provider':
				com_OnPopupClick("service_provider");
				break;

		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0085GS.do", TrsFrmQryString(formObj));

			break;

		case IBSAVE	:
			
			var checkList = sheetObj.FindCheckedRow('ib_chk');
			if(checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
//			sheetObj.RemoveEtcData();
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0085GS.do", TrsFrmQryString(formObj), 'ib_chk');
			break;
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	var formObject = document.form;
	var sheetObject= sheetObjects[0];

	initControl();
	doActionIBSheet(sheetObject, formObject, IBSEARCH);

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
	var formObject = document.form;
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
				style.height = 300;
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 20, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Sel|Seq.|S/P Code|S/P Name|TP-ID|Use Flag|SCAC|Update Office|Update User|Update Date";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtRadioCheck, 	 40,   daCenter,  true,   "ib_chk");
				InitDataProperty(0, cnt++ , dtDataSeq,    	 40,   daCenter,  true,	  "seq");
				InitDataProperty(0, cnt++ , dtData,       	 80,   daCenter,  true,   "vndr_seq",			false,		"",			dfNone,         0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 200,   daCenter,  true,   "vndr_lgl_eng_nm",		false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 100,   daCenter,  true,   "edi_rcvr_nm",		false,		"",			dfNone,				0,       true,		true,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtCheckBox,       80,   daCenter,  true,   "edi_rcvr_nm_use_flg");
				InitDataProperty(0, cnt++ , dtData,        	 100,   daCenter,  true,   "usa_edi_cd",		false,		"",			dfNone,				0,       false,		false,		50,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 100,   daCenter,  true,   "cre_ofc_cd",		false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 100,   daCenter,  true,   "upd_usr_id",		false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	 100,   daCenter,  true,   "upd_dt",		false,		"",			dfDateYmd,				0,       false,		false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,  true,   "ibflag");
				
				InitDataValid(0, "edi_rcvr_nm", vtEngUpOnly);
			}
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
	} 
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI){
			ComShowCodeMessage('COM130102', 'Data');
		}
	}
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
}
 
/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Master sheet

	formObject.combo_svc_provider.value = '';
	formObject.svc_provider.value = '';
}	

/**
 * service_provider 팝업호출
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
	}
}

/**
 * Service Provider 팝업에서 선택된값 SET
 */
function setServiceProvider(rowArray) {
	formObj						= document.form;
	var sheetObj              = sheetObjects[0];
	formObj.combo_svc_provider.value	= rowArray[0][2];
	formObj.svc_provider.value		= rowArray[0][4];
	getUSVendorSeq(sheetObj, formObj, formObj.combo_svc_provider.value);
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
				getUSVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}

function getUSVendorSeq(sheetObj, formObj, vndr_seq){

	if(formObj.combo_svc_provider.value == '') {
		formObj.svc_provider.value = '';
		return false;
	}
	   formObj.f_cmd.value = SEARCH01;
	   formObj.combo_svc_provider.value = get_only_num(vndr_seq);
	   sheetObj.RemoveEtcData();
	   sheetObj.DoRowSearch("ESD_TRS_0085GS.do", TrsFrmQryString(formObj));
	   var vendorNoList = sheetObj.EtcData('vndr_no');
	   var vendorNmList = sheetObj.EtcData('vndr_nm_eng');
	   if (vendorNoList == undefined || vendorNoList == ''){
		   formObj.combo_svc_provider.value = '';
		   formObj.svc_provider.value = '';
		   ComShowCodeMessage("TRS90076");
		   return false;
	   }
	   formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0') ;
	   formObj.svc_provider.value = vendorNmList;
	   return true;
	 }

function obj_keypress(){
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;

    switch(obj.dataformat) {
        case "engup":
            if(obj.name=="combo_svc_provider"){
				ComKeyOnlyNumber(obj);
			} else {
				ComKeyOnlyAlphabet('uppernum');
			}
            break;
    }
}
