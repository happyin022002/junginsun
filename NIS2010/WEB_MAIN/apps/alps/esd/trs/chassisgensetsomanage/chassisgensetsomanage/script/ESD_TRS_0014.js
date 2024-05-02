/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0014.js
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.04 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.03.15 최 선   1.1 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

 
/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0014 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0014() {
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

/* 공통전역변수 */
//var calPop = new calendarPopupGrid();

var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var seqNo = 1;
var nodeSearchFlag = false;
var checkedChassis = 'chassis';
var checkedHire = 'D';

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
	   //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
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
	   case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 240;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(36, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "STS||Bundle\nSeq.|Bundle\nKind|EQ No|EQ\nTP/SZ|From|From|To|To|Trans. Mode|Distance(Km)|Lessor"
							+ "|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date"
							+ "|Internal Remark|Reference\nCNTR No|Reference\nTP\SZ|Reference\nBKG No"
							+ "|Reference\nB/L No|Outgate Date|Outgate Date|Ingate Date|Ingate Date"
							+ "|Remark\n(Special Instruction)|Verify\nResult|row no";


				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,   30,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++,  dtCheckBox, 30,	daCenter,	false,  "ibcheck");
				InitDataProperty(0, cnt++ , dtData,     70,	daCenter,	true,   "trsp_so_cmb_seq",false,	"",	dfNone,		0,  false,	false,	10);
				InitDataProperty(0, cnt++ , dtCombo,    100,daCenter,	false,   "trsp_so_cmb_tp_cd",false,	"",	dfNone,		0,  false,	false,	10);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,  "eq_no",			false,  "", dfEngUpKey,	0,  true,   true,   10);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"eq_tpsz_cd",		true,   "", dfEngUpKey,	0,  false,   false, 3);
				InitDataProperty(0, cnt++ , dtData,     60,	daCenter,	false,  "fm_loc_value",     true,   "", dfEngUpKey,	0,  true,   true,   5);
				InitDataProperty(0,	cnt++,	dtData,		40,	daLeft,		false,	"fm_yard_value",	true,	"",	dfNone,		0,	true,	true,	2);
				InitDataProperty(0, cnt++ , dtData,     60,	daCenter,	false,	"to_loc_value",     true,   "", dfEngUpKey, 0,  true,   true,   5);
				InitDataProperty(0,	cnt++,	dtData,		40,	daLeft,		false,	"to_yard_value",	true,	"",	dfNone,		0,	true,	true,	2);
				InitDataProperty(0, cnt++ , dtCombo,    110,daCenter,	false,  "trsp_crr_mod_cd",  true,   "", dfNone,		0,  true,   true,   2);
				//2012.06.11 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData,   	90,  daRight,   false, 	"ttl_dist", 		false, "", dfInteger, 	0, 	false, 	false);
				
				InitDataProperty(0, cnt++ , dtData,     80, daCenter,	false,	"vndr_abbr_nm",     false,  "", dfNone,		0,  false,  false,  5);
				InitDataProperty(0, cnt++ , dtData,     80, daCenter,	false,  "lstm_cd",			false,  "", dfNone,		0,  false,  false,  4);
				InitDataProperty(0, cnt++ , dtData,     80, daCenter,	false,	"ownr_co_cd",		false,  "", dfNone,		0,  false,  false,  5);
				InitDataProperty(0, cnt++ , dtData,     80, daCenter,	false,  "usr_co_cd",		false,  "", dfNone,		0,  false,  false,  4);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"mvmt_sts_cd",		false,  "", dfNone,		0,  false,  false,  5);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,  "lst_sts_yd_cd",    false,  "", dfNone,		0,  false,  false,  4);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"mvmt_dt",			false,  "", dfNone,		0,  false,  false,  8);
				InitDataProperty(0, cnt++ , dtData,     150,daCenter,	false,	"inter_rmk",		false,  "", dfNone,		0,  true,   true,   1000);
				
				InitDataProperty(0, cnt++ , dtData,     120,daCenter,	false,	"cntr_no",			false,  "", dfNone,		0,  true,   true,   14);
				InitDataProperty(0, cnt++ , dtData,     80,	daCenter,	false,	"cntr_tpsz_cd",		false,  "", dfNone,		0,  true,   true,   4);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"ref_bkg_no",		false,  "", dfNone,		0,  true,   true,   11);
				InitDataProperty(0, cnt++ , dtData,     120,daCenter,	false,	"ref_bl_no",		false,  "", dfNone,		0,  true,   true,   12);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"org_gate_out_date",false,  "", dfDateYmd,	0,  true,   true,   8);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"org_gate_out_time",false,  "", dfTimeHms,	0,  true,   true,   8);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"dest_gate_in_date",false,  "", dfDateYmd,	0,  true,   true,   8);
				InitDataProperty(0, cnt++ , dtData,     100,daCenter,	false,	"dest_gate_in_time",false,  "", dfTimeHms,	0,  true,   true,   8);
				
				InitDataProperty(0, cnt++ , dtData,     150,daCenter,	false,	"spcl_instr_rmk",   false,  "", dfNone,		0,  true,   true,   1000);
				InitDataProperty(0, cnt++ , dtData,     50, daCenter,	false,	"verify_result",    false,  "", dfNone,		0,	false,  false,  20);
				InitDataProperty(0, cnt++ , dtDataSeq,  50, daCenter,	false,	"sheet_row");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	"vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	"mvmt_sts_nm");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	"org_gate_out_dt");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	"dest_gate_in_dt");
				
				InitDataProperty(0, cnt++,  dtHidden,  	0, 	daCenter, 	false, "lnk_dist_div_cd", 	false, "", dfNone, 		1, false, false);
				
				InitDataCombo(0, 'trsp_crr_mod_cd', " |"+trsp_crr_mod_cdText, " |"+trsp_crr_mod_cdCode);
				InitDataCombo(0, 'trsp_so_cmb_tp_cd', " |"+trsp_so_cmb_tp_cdText, " |"+trsp_so_cmb_tp_cdCode);
				ColHidden('sheet_row') = true;
				ColHidden('ibflag') = true;
		   }
		   break;

		case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				cnt = 0;
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "sts|svc_ord|seq";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,   150,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++,  dtData,		150,	daCenter,	false,  "trsp_so_ofc_cty_cd", false,  "", dfNone,		0,	false,  false,  20);
				InitDataProperty(0, cnt++ , dtData,     150,	daCenter,	false,  "trsp_so_seq", false,  "", dfNone,		0,	false,  false,  20);
		   }
		   break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
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

			case "btn_retrieve":
				if(formObject.kind_manual[0].checked){
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				}	

				break;

			case "btn_reset":
				resetForm(formObject);
				break;

			case "btn_rowadd":
				formObject.dist_div_cd.value=="F"
				addBundleUnit();
				formObject.dist_div_cd.value=="G"
				break;
			
			case "btng_rowadd":
				formObject.dist_div_cd.value=="F"
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				formObject.dist_div_cd.value=="G"
				break;

			case "search_hiredate":
				var cal2 = new ComCalendarFromTo();
				cal2.displayType = "date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
	            break;

			case "btng_delete":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_unbundling":
				unBundle(sheetObject, formObject);
				break;

			case "btng_bundling":
				itemBundling(sheetObject, formObject);
				break;

			case "btng_socreation":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'C');
			break;

			case "btng_woissue":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'I');
			break;

			case "btng_fillineq":
				if(formObject.kind_manual[0].checked)
				popEqFileImport(sheetObject, formObject);
			break;

			case "btng_multipleapply":
				popMultiApply(sheetObject);
			break;

			case "btns_search":
				if(nodeSearchFlag) openHireYardPopup('getCOM_ENS_061_1'); 
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

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction, trspSoStsCD) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	   case IBSEARCH:	  //조회
			
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:		//SO Creation, WO Issue

			var sheetObj2 = sheetObjects[1];
			
			if(trspSoStsCD == 'C'){
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');

				setGateOutDate(sheetObj, checkArray);

				sheetObj.RemoveEtcData();
				
				var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
				if(queryStr=='') return false;

				formObj.f_cmd.value = SEARCH03;
				var searchXml = sheetObj.GetSaveXml("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj));
				sheetObj.LoadSearchXml(searchXml, false, -1, true);
				
				if (!getVerifyColumn(sheetObj) && !confirm(ComGetMsg('TRS90346')))
				{
					var checkList = sheetObj.FindCheckedRow('ibcheck');
					var checkArray = checkList.split('|');

					for(var k=0; k<checkArray.length-1; k++)
					{
						if( sheetObj.CellValue(checkArray[k], 'verify_result') != ''){
							sheetObj.CellValue2(checkArray[k], 'ibcheck')=0;
						}
					}
					return;
				}
				formObj.f_cmd.value = ADD;
				formObj.TRSP_SO_TP_CD.value = 'H';
				formObj.TRSP_SO_STS_CD.value = trspSoStsCD; //SO -C, WO - I

				queryStr = sheetObj.GetSaveString(false, false, "ibcheck");

				sheetObj2.DoSearch4Post("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj), '', true);

			}if(trspSoStsCD == 'I'){
				
				if(sheetObj2.RowCount < 1){
					ComShowCodeMessage('TRS90110');
					return false;
				}

				if(!confirm(ComGetMsg('TRS90227',sheetObj2.RowCount))) {
					return false;
				}

				var cty_cd = '';
				var seq_no = '';

				for(var i=1; i<sheetObj2.RowCount+1; i++)
				{
					if(i!=1){
						cty_cd += ',';
						seq_no += ',';
					}
					cty_cd += sheetObj2.CellValue(i, 'trsp_so_ofc_cty_cd');
					seq_no += sheetObj2.CellValue(i, 'trsp_so_seq');
				}

				document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
				document.woForm.trsp_so_seq.value = seq_no;
				
				document.woForm.submit();
				return;
			}
			
			break;

		case IBDELETE:
			deleteCheckedRow(sheetObj);
			break;
		case IBINSERT:	  //입력
			var Row = sheetObj.DataInsert(-1);
			break;
		case IBCLEAR:	   //Clear
			sheetObj.RemoveAll();
			break;
		case IBDOWNEXCEL:  //엑셀내려받기
			sheetObj.Down2Excel(0,false,false,true);
			break;

		case IBLOADEXCEL:        //엑셀 업로드
		  sheetObj.LoadExcel();
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
		if(formObj.f_cmd.value = ADD){
			var checkList = sheetObjects[0].FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObjects[0].RowDelete(checkArray[k], false);
			}
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case IBSEARCH:
		var lvfrmDate = doSepRemove(doSepRemove(formObj.fmdate.value, " "), "-");
		var lvtoDate = doSepRemove(doSepRemove(formObj.todate.value, " "), "-");

		if( lvfrmDate == "" ) { //한쪽 날짜가 빠진 경우
			errMsg = ComGetMsg("TRS90119");		   
			ComShowMessage(errMsg);
			formObj.fmdate.focus();
			return false;
		}else if(lvtoDate == "" ) { //한쪽 날짜가 빠진 경우
			errMsg = ComGetMsg("TRS90121");
			ComShowMessage(errMsg);
			formObj.todate.focus();
			return false;
		}else if( lvfrmDate != "" && lvtoDate != "" ) { //날짜 체크하는 부분
			if( !doDatecheck(lvfrmDate) ) {
				errMsg = ComGetMsg("TRS90072");
				ComShowMessage(errMsg);
				formObj.fmdate.focus();
				return false;
			} else if( !doDatecheck(lvtoDate) ) {
				errMsg = ComGetMsg("TRS90073");
				ComShowMessage(errMsg);
				formObj.todate.focus();
				return false;
			}
		
			if( dateCalcuration(lvfrmDate, lvtoDate) < 0 ) {
				errMsg = ComGetMsg("TRS90118");
				ComShowMessage(errMsg);
				return false;
			}
		}
		
		break;
		case IBSAVE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			var fmNode = '';
			var toNode = '';

			for(var k=0; k<checkArray.length-1; k++)
			{
				var row = checkArray[k];
				fmNode = sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
				toNode = sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
				if(fmNode == toNode)
				{
					ComShowCodeMessage('COM12115', 'From Node and To Node');
					sheetObj.SelectCell(row, 'fm_loc_value');
					return false;
				}
			}

			var src_row = 0;
			var tgt_row = 0;

			var src_eq_no = null;
			var tgt_eq_no = null;

			var src_fm_loc_value = null;
			var tgt_fm_loc_value = null;

			var src_fm_yard_value = null;
			var tgt_fm_yard_value = null;

			for(var k=0; k<checkArray.length-2; k++)
			{
				src_row = checkArray[k];
				src_eq_no = sheetObj.CellValue(src_row, 'eq_no');
				src_fm_loc_value = sheetObj.CellValue(src_row, 'fm_loc_value');
				src_fm_yard_value = sheetObj.CellValue(src_row, 'fm_yard_value');

				if( src_eq_no != ''){
					for(var j=k+1; j<checkArray.length-1; j++){
						tgt_row = checkArray[j];
						tgt_eq_no = sheetObj.CellValue(tgt_row, 'eq_no');
						tgt_fm_loc_value = sheetObj.CellValue(tgt_row, 'fm_loc_value');
						tgt_fm_yard_value = sheetObj.CellValue(tgt_row, 'fm_yard_value');

						if(tgt_eq_no != '' &&
							src_eq_no == tgt_eq_no &&
							src_fm_loc_value == tgt_fm_loc_value &&
							src_fm_yard_value == tgt_fm_yard_value ){
							ComShowCodeMessage('COM12115', 'EQ No AND From Node');
							sheetObj.SelectCell(tgt_row, 'eq_no');
							return false;
						}
					}
				}
			}
			break;
	}
	return true;
}

function deleteCheckedRow(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=checkArray.length-2; k>=0; k--)
	{
		sheetObj.RowDelete(checkArray[k], false);
	}
}

/**
 * kind 조회조건 처리
 **/
function setKindEnabled(){
		var sheetObj = sheetObjects[0];
		var obj = document.form; 
		var k_c = obj.kind_chassis;
		var k_h = obj.kind_hire;
		var k_m = obj.kind_manual;
		var k_b = obj.kind_bundle;
		
		if(sheetObj.RowCount>0 && checkedChassis == 'chassis' && k_c[1].checked)
		{
			if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?'))
			{
				sheetObj.RemoveAll();
				checkedChassis = 'genset';
			}else{
				k_c[0].checked = true;
				checkedChassis = 'chassis';
				return;
			}
		}else if(sheetObj.RowCount>0 &&checkedChassis == 'genset' && k_c[0].checked)
		{
			if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?'))
			{
				sheetObj.RemoveAll();
				checkedChassis = 'chassis';
			}else{
				k_c[1].checked = true;
				checkedChassis = 'genset';
				return;
			}
		}else if(sheetObj.RowCount == 0)
		{
			if (k_c[0].checked) checkedChassis = 'chassis';
			else if(k_c[1].checked) checkedChassis = 'genset';
		}

		var k_h_value = '';
		for(var i=0;i<k_h.length;i++)
		{
			if(k_h[i].checked)
			{
				k_h_value = k_h[i].value;
				break;
			}
		}

		if(sheetObj.RowCount>0 && checkedHire != k_h_value)
		{
			if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?'))
			{
				sheetObj.RemoveAll();
				checkedHire = k_h_value;
			}else{
				for(var i=0; i<k_h.length;i++)
				{
					if(k_h[i].value == checkedHire)
					{
						k_h[i].checked = true;
						return;
					}
				}
			}
		}else{
			checkedHire = k_h_value;
		}

		k_h[0].disabled = false;
		k_h[1].disabled = false;
		k_h[2].disabled = false;

		k_m[0].disabled = false;
		k_m[1].disabled = false;

		k_b[0].disabled = false;
		k_b[1].disabled = false;
		k_b[2].disabled = false;

		if(k_c[0].checked)
		{
			k_m[0].disabled = false;
			k_m[1].disabled = false;
		}else if(k_c[1].checked)
		{
			k_m[0].disabled = false;
			k_m[1].disabled = true;
		}

		if( k_c[0].checked && k_h[0].checked )
		{
			k_m[0].disabled = false;
			k_m[1].disabled = true;
		}else if(k_c[0].checked && k_h[1].checked)
		{
			k_m[0].disabled = false;
			k_m[1].disabled = false;
		}else if(k_c[0].checked && k_h[2].checked)
		{
			k_m[0].disabled = false;
			k_m[1].disabled = true;
		}
		
		if(k_m[1].disabled) k_m[0].checked = true;

		if(k_c[1].checked && k_m[0].checked)
		{
			k_b[0].disabled = false;
			k_b[1].disabled = true;
			k_b[2].disabled = true;
		}

		if(k_b[1].disabled) k_b[0].checked = true;

		setRestEnabled();	 
 }


/**
 * 나머지 조회조건 처리
 **/
function setRestEnabled()
{
	var obj = document.form;

	/* QTY enable / On Hire Creation Date / On Hire Yard */
	if(obj.kind_manual[0].checked)
	{
		obj.todate.disabled = true;
		obj.fmdate.disabled = true;
		obj.hire_loc.disabled = true;
		document.hire_yd.Enable = false;
		nodeSearchFlag = false;
	}else
	{
		obj.todate.disabled = false;
		obj.fmdate.disabled = false;
		obj.hire_loc.disabled = false;
		document.hire_yd.Enable = true;
		nodeSearchFlag = true;
	}

	if(obj.kind_bundle[0].checked)
	{
		obj.bundle_unit.disabled = true;
		obj.bundle_set.disabled = true;
		obj.unit_qty.disabled = false;
	}else{
		obj.bundle_unit.disabled = false;
		obj.bundle_set.disabled = false;
		obj.unit_qty.disabled = true;
	}
	
}

/**
 * sheet click시 일어나는 이벤트
 **/
function sheet_OnClick(sheetObj, row, col, value)
{
	if(sheetObj.ReadDataProperty(row, col, 0)==6) 
	{	
		return;
	}
	var colName = sheetObj.ColSaveName(col);

	var k_h_value = '';
	var k_h = document.form.kind_hire;
	for(var i=0;i<k_h.length;i++)
	{
		if(k_h[i].checked)
		{
			k_h_value = k_h[i].value;
			break;
		}
	}
	
	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
		document.form.TRSP_SO_EQ_KIND.value = k_h_value;
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value = 'Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value = 'N';
	}
	
	switch(colName){

		case 'fm_yard_value':
			
			getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
			break;
		case 'to_yard_value':
			getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
			break;

		case 'eq_tpsz_cd':
			if(sheetObj.CellValue(row,'eq_no') == '' ) sheetObj.CellEditable(row,'eq_tpsz_cd') = true;
			else if(sheetObj.CellValue(row,'eq_no') != '')sheetObj.CellEditable(row,'eq_tpsz_cd') = false;
			break;
	}

	document.form.TRSP_SO_EQ_KIND.value = k_h_value;
}

function sheet_OnKeyDown(sheetObj, row, col, keycode, Shift) 
{
	var colName = sheetObj.ColSaveName(col);
	if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'eq_no') == '' ) sheetObj.CellEditable(row,'eq_tpsz_cd') = true;
	else if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'eq_no') != '')sheetObj.CellEditable(row,'eq_tpsz_cd') = false;
}

/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function sheet_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	var k_h_value = '';
	var k_h = document.form.kind_hire;
	for(var i=0;i<k_h.length;i++)
	{
		if(k_h[i].checked)
		{
			k_h_value = k_h[i].value;
			break;
		}
	}

	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
		document.form.TRSP_SO_EQ_KIND.value = k_h_value;
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value = 'Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value = 'N';
	}

	switch(colName){
		case 'delflag':
		case 'ibcheck':
			toggleCheckBundle(sheetObj, row, col);
			break;

		case 'fm_loc_value':
			var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_loc_value").toUpperCase(), " ");
			sheetObj.CellValue2(row, "fm_loc_value") = lvfm;

			if( doengnumcheck(lvfm) ) {
				if( lvfm.length == 5 ) {
					getYardSheetCombo1(sheetObj, document.form, row, col, "fm_yard_value", lvfm); //Varidation check
					if( sheetObj.CellValue(row, "fm_loc_value") != "") {
						getYardSheetCombo(sheetObj, document.form, row, "fm_yard_value", lvfm);
					} else {
						sheetObj.CellComboItem(row, "fm_yard_value", "", "");
						sheetObj.CellValue2(row, "fm_yard_value") = "";					
					}
				} else {
					if( lvfm.length == 0 ) {
						sheetObj.CellComboItem(row, "fm_yard_value", "", "");
						sheetObj.CellValue2(row, "fm_yard_value") = "";
					} else {
						errMsg = ComGetMsg("TRS90122");
						ComShowMessage(errMsg);
						sheetObj.CellValue2(row,"fm_loc_value") = "";
						sheetObj.SelectCell(row,"fm_loc_value");
						sheetObj.CellComboItem(row, "fm_yard_value", "", "");
						sheetObj.CellValue2(row, "fm_yard_value") = "";
					}
				}
			} else {
				sheetObj.CellValue2(row,"fm_loc_value") = "";
				sheetObj.SelectCell(row,"fm_loc_value");
				sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			}
			
			if(formObject.dist_div_cd.value=="G"){ //Grid OnChange Event일때만  Distance를 조회한다.
				distance_cal(sheetObj, row);
			}
			
			break;
			
		case 'to_loc_value':
			sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
			sheetObj.CellValue2(row, 'ibcheck')='1';
			
			if(formObject.dist_div_cd.value=="G"){ //Grid OnChange Event일때만  Distance를 조회한다.
				distance_cal(sheetObj, row);
			}
			
			break;
			
		case 'fm_yard_value':
		case 'to_yard_value':
		case 'trsp_crr_mod_cd':	
			if(formObject.dist_div_cd.value=="G"){ //Grid OnChange Event일때만  Distance를 조회한다.
				distance_cal(sheetObj, row);
			}			
		break;	
		
		
		
		case 'eq_no':
			if(value == '') return;

			sheetObj.CellValue2(row, colName) = '';

			sheetObj.InitCellProperty(row, 'fm_yard_value', dtData);
			sheetObj.InitCellProperty(row, 'to_yard_value', dtData);

			sheetObj.CellValue2(row, colName) = value;
			if(formObject.kind_chassis[0].checked){
				formObject.f_cmd.value = SEARCH01;
			}else{
				formObject.f_cmd.value = SEARCH02;
			}
			var queryString = "row="+row+"&eq_no="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);

			sheetObj.DoRowSearch("ESD_TRS_0014GS.do", queryString , false );
			if (ComTrim(sheetObj.cellValue(row, 'eq_tpsz_cd')) == ''){
				ComShowCodeMessage('COM12161', value);
				sheetObj.SelectCell(row, colName);
			}
			
			sheetObj.CellValue2(row, 'fm_yard_value') = '';
			sheetObj.CellValue2(row, 'fm_loc_value') = '';

			if(!checkEqTypeSizeByBundle(sheetObj)){
				sheetObj.cellValue2(row, 'eq_no') = '';
				sheetObj.cellValue2(row, 'eq_tpsz_cd') = '';
				sheetObj.cellValue2(row, 'vndr_abbr_nm') = '';
				sheetObj.cellValue2(row, 'lstm_cd') = '';
				sheetObj.cellValue2(row, 'ownr_co_cd') = '';
				sheetObj.cellValue2(row, 'usr_co_cd') = '';
				sheetObj.cellValue2(row, 'mvmt_sts_cd') = '';
				sheetObj.cellValue2(row, 'lst_sts_yd_cd') = '';
				sheetObj.cellValue2(row, 'mvmt_dt') = '';
				return;
			}
			sheetObj.CellValue2(row, 'ibcheck')='1';
			break;
		case 'eq_tpsz_cd':
			sheetObj.RemoveEtcData();
			value = value.toUpperCase();

			if(formObject.kind_chassis[0].checked) {
				formObject.f_cmd.value = SEARCH12;
			}else if(formObject.kind_chassis[1].checked){
				formObject.f_cmd.value = SEARCH13;
			}

			formObject.EQ_TPSZ_CD.value = value;
			sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObject) , false );

			if (sheetObj.EtcData("eq_tpsz_cd") == undefined || sheetObj.EtcData("eq_tpsz_cd") == ''){
				ComShowCodeMessage('COM12114', 'Type size Code');
				sheetObj.CellValue2( row, col) = '';
				return;
			}

			sheetObj.cellValue2(row, 'eq_tpsz_cd') = value;

			if(!checkEqTypeSizeByBundle(sheetObj)){
				sheetObj.cellValue2(row, 'eq_tpsz_cd') = '';
			}
			break;
		case 'org_gate_out_date':

			if(value != '' && sheetObj.CellValue(row, 'org_gate_out_time')==''){
				sheetObj.CellValue2(row, 'org_gate_out_time') = '000000';
			}else if(value == ''){
				sheetObj.CellValue2(row, 'org_gate_out_time') = '';
			}
			break;
		case 'dest_gate_in_date':
			if(value != '' && sheetObj.CellValue(row, 'dest_gate_in_time')==''){
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '000000';
			}else if(value == ''){
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '';
			}
			break;
	}

	document.form.TRSP_SO_EQ_KIND.value = k_h_value;

}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	if(ComTrim(obj.value) == ''){
		document.hire_yd.RemoveAll();
		return;
	}

	/** ON HIRE에 따른 설정값 세팅 **/
	var k_h_value = '';
	var k_h = document.form.kind_hire;
	for(var i=0;i<k_h.length;i++)
	{
		if(k_h[i].checked)
		{
			k_h_value = k_h[i].value;
			break;
		}
	}
	formObj.TRSP_SO_EQ_KIND.value = k_h_value;
	
	getYardCombo(document.hire_yd, sheetObjects[0], formObj, obj.value);
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	if(event.keyCode == 13){   getComboList(obj); }
}

/**
 * Bundle seq no 반환
 **/
function getSeqNo()
{
	return seqNo++;
}

/**
 * 체크박스 클릭시 번들끼리 묶어주기
 **/
function toggleCheckBundle(sheetObj, row, col)
{
	var value = sheetObj.cellValue(row, col);
	var bundle_seq = sheetObj.cellValue(row, 'trsp_so_cmb_seq');
	if(bundle_seq == '') return;

	for(var i=1; i<sheetObj.RowCount+1; i++)
	{
		if(bundle_seq == sheetObj.cellValue(i, 'trsp_so_cmb_seq'))
		{
			sheetObj.cellValue2(i, col) = value;
		}
	}
}

/**
 * retrieve 버튼 클릭시 bundle 단위로 묶기
 **/
function retrieveBundleUnit(sheetObj)
{
	var formObj = document.form;
	var unit = document.form.bundle_unit.value;
	var set = document.form.bundle_set.value;
	var itemCnt = sheetObj.RowCount;


	if(set=='' || itemCnt< unit ) return;

	var share = Math.floor(Number(itemCnt) / Number(unit));
	if(share > set) share = set; //set 된 갯수를 맞춘다.

	var cnt=1;
	for(var i=0; i<share; i++)
	{
		var seq = getSeqNo();
		for(var j=0; j<unit; j++)
		{
			if(formObj.kind_bundle[1].checked){
				sheetObj.cellValue2(cnt, 'trsp_so_cmb_tp_cd') = 'BS';
			}else if(formObj.kind_bundle[2].checked){
				sheetObj.cellValue2(cnt, 'trsp_so_cmb_tp_cd') = 'BF';
			}
			sheetObj.cellValue2(cnt++, 'trsp_so_cmb_seq') = seq;
		}
	}
}

/**
 * ADD버튼 클릭시 single 단위로 ADD하기
 **/
function addSingleUnit()
{
	var obj = document.form;
	var sheetObj = sheetObjects[0];
	if(obj.unit_qty.value =='')
	{
		ComShowCodeMessage('COM12114', 'QTY');
		return;
	}
	for(var i=0; i< obj.unit_qty.value; i++)
	{
		sheetObj.DataInsert(-1);
	}
}

/**
 * ADD버튼 클릭시 bundle 단위로 ADD하기
 **/
function addBundleUnit()
{
	var obj = document.form;
	var sheetObj = sheetObjects[0];

	if(obj.kind_bundle[0].checked)
	{
		addSingleUnit();
		return;
	}

	if(!obj.kind_manual[0].checked || !(obj.kind_bundle[1].checked || obj.kind_bundle[2].checked)) return;
	if(obj.bundle_set.value=='')
	{
		ComShowCodeMessage('COM12114', 'SET');
		return;
	}
	
	var unit = obj.bundle_unit.value;
	var set = obj.bundle_set.value;

	for(var i=0; i < set; i++)
	{
		var seq = getSeqNo();
		for(var j=0; j<unit; j++)
		{
			sheetObj.DataInsert(-1);
			sheetObj.cellValue2(sheetObj.SelectRow, 'trsp_so_cmb_seq') = seq;
			if(obj.kind_bundle[1].checked){
				sheetObj.cellValue2(sheetObj.SelectRow, 'trsp_so_cmb_tp_cd') = 'BS';
			}else if(obj.kind_bundle[2].checked){
				sheetObj.cellValue2(sheetObj.SelectRow, 'trsp_so_cmb_tp_cd') = 'BF';
			}
		}
	}
}

/**
 * bundle 풀기
 **/
function unBundle(sheetObj, formObj)
{
	if(formObj.kind_chassis[1].checked) return;

	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		var bundle_seq = sheetObj.cellValue(row, 'trsp_so_cmb_seq');
		if(bundle_seq != '') sheetObj.cellValue2(row, 'trsp_so_cmb_seq') = '';
		sheetObj.cellValue2(row, 'trsp_so_cmb_tp_cd') = '';
		sheetObj.CellBackColor(checkArray[k], 'trsp_so_cmb_seq') = 15723503;
		
	}
}

/**
 * sheet에 있는 item을 bundling 하기
 **/
function itemBundling(sheetObj, formObj)
{
	if(formObj.kind_chassis[1].checked){
		ComShowCodeMessage('TRS90064');
		return;
	}

	if(formObj.kind_bundle[0].checked){
		ComShowCodeMessage('TRS90324');
		return;
	}

	if(!checkEqTypeSize(sheetObj)) return;

	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	
	var unit = document.form.bundle2_unit.value;
	var checkLength = checkArray.length-1;

	if(checkLength<unit)
	{
		ComShowCodeMessage('TRS90125');
		return;
	}

	unBundle(sheetObj, formObj);

	var share = Math.floor(Number(checkLength) / Number(unit));

	cnt = 0;
	for(var i=0; i<share; i++)
	{
		var seq = getSeqNo();
		for(var j=0; j<unit; j++)
		{
			sheetObj.CellBackColor(checkArray[cnt], 'trsp_so_cmb_seq') = 15723503;
			if(formObj.kind_bundle[1].checked){
				sheetObj.cellValue2(checkArray[cnt], 'trsp_so_cmb_tp_cd') = 'BS';
			}else if(formObj.kind_bundle[2].checked){
				sheetObj.cellValue2(checkArray[cnt], 'trsp_so_cmb_tp_cd') = 'BF';
			}
			sheetObj.cellValue2(checkArray[cnt++], 'trsp_so_cmb_seq') = seq;
			
		}
	}

	for(var i=cnt; i<checkLength; i++){
		sheetObj.CellBackColor(checkArray[i], 'trsp_so_cmb_seq') = sheetObj.RgbColor(238,255,226);
	}

	cnt=1;
	for(var i=0; i< share*unit; i++)
	{
		if(cnt != checkArray[i]){
			sheetObj.DataMove(cnt++, checkArray[i]);
		}else{
			cnt++;
		}
	}
}


/**
 * check된 리스트중에 eq type size가 중복된것이 있는지 확인한다. 
 **/
function checkEqTypeSize(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var src_type_size = '';

	for(var k=1; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		if(sheetObj.cellValue(checkArray[0], 'eq_tpsz_cd') != sheetObj.cellValue(row, 'eq_tpsz_cd'))
		{
			ComShowCodeMessage('COM12114', 'EQ Type Size');
			return false;
		}
	}
	return true;
}

/**
 * check된 리스트중에 eq type size가 중복된것이 있는지 확인한다. 
 **/
function checkEqTypeSizeByBundle(sheetObj)
{
	var row = sheetObj.SelectRow;
	var value = sheetObj.CellValue(row, 'eq_tpsz_cd');
	var bun_seq = sheetObj.CellValue(row, 'trsp_so_cmb_seq');
	
	if (bun_seq == '') return true;
	for(var k=1; k<sheetObj.RowCount+1; k++)
	{
		if(sheetObj.cellValue(k, 'trsp_so_cmb_seq') == '') continue;

		if( k != row && 
			bun_seq == sheetObj.cellValue(k, 'trsp_so_cmb_seq') &&  
			sheetObj.cellValue(k, 'eq_tpsz_cd') != '' &&
			value != sheetObj.cellValue(k, 'eq_tpsz_cd') )
		{
			ComShowCodeMessage('COM12114', 'EQ Type Size');
			return false;
		}
	}
	return true;
}

/**
 * number check
 **/
function checkNumber(obj, delflag)
{
	if(!ComIsNumber(obj))
	{
		ComShowCodeMessage('COM12122', obj.name);
		if (delflag) obj.value = '';
	}
}

/**
* S/O Creation시 2주이내에 create됐는지 여부 확인
*/
function getVerifyColumn(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var returnFlag = true;

	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		var eq_no = sheetObj.CellValue(row, 'eq_no');
		if(sheetObj.EtcData(eq_no) != '' &&  sheetObj.EtcData(eq_no) != undefined)
		{
//			sheetObj.CellValue2(row, 'ibcheck') = false;
			sheetObj.CellValue2(row, 'verify_result') = sheetObj.EtcData(eq_no);
			sheetObj.RowBackColor(row) = sheetObj.RgbColor(238,255,226);
			returnFlag = false;
		}
	}

	return returnFlag;
}

/**
* 조회조건 reset
*/
function resetForm(formObj)
{
	formObj.kind_chassis[0].checked = true;
	formObj.kind_hire[0].checked = true;
	formObj.kind_manual[0].checked = true;
	formObj.kind_bundle[0].checked = true;
	formObj.bundle_unit.options[0].selected=true;
	formObj.bundle_set.value='';
	formObj.unit_qty.value='';
	formObj.todate.value=today;
	formObj.fmdate.value=beforeOneMonth;
	formObj.hire_loc.value='';
	document.hire_yd.RemoveAll();
	setKindEnabled();
}


/**
* 공통 Node popup
*/
function openHireYardPopup(objName)
{	
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId =objName;
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
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 430, objName, '1,0,1,1,1,1,1,1,1,1,1,1');

}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;

	if(myWin != null) myWin.close();
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
* Location : 팝업에서 단일 선택을 한경우..
*/
function getCOM_ENS_061_1(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);
	document.form.hire_loc.value = loc;
	getComboList(document.form.hire_loc);
	document.hire_yd.CODE = yard;
}

/**
* MULTIAPPLY 팝업창
*/
function popMultiApply(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	var myOption = "width=500,height=220,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0015.screen';
	myWin = window.open(url, "popMultiApply", myOption);
}

/**
* MULTIAPPLY 팝업창에서 APPLY를 눌러서 적용하기
*/
function setPopupValue(fm_loc, fm_yd, to_loc, to_yd, trans_md, remark, popObj)
{
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		
		if(ComTrim(fm_loc) != '') sheetObj.cellValue2(row, 'fm_loc_value') = fm_loc;
		if(ComTrim(fm_yd) != '') {
			sheetObj.InitCellProperty(row, 'fm_yard_value', dtData);
			sheetObj.cellValue2(row, 'fm_yard_value') = fm_yd;
		}
		if(ComTrim(to_loc) != '') sheetObj.cellValue2(row, 'to_loc_value') = to_loc;
		if(ComTrim(to_yd) != '') {
			sheetObj.InitCellProperty(row, 'to_yard_value', dtData);
			sheetObj.cellValue2(row, 'to_yard_value') = to_yd;
		}
		if(ComTrim(trans_md) != '') sheetObj.cellValue2(row, 'trsp_crr_mod_cd') = trans_md;
		if(ComTrim(remark) != '') sheetObj.cellValue2(row, 'inter_rmk') = remark;
		
		formObj.dist_div_cd.value = "F";
		distance_cal(sheetObj, row);
		formObj.dist_div_cd.value = "G";
	}
	popObj.close();
}


function popEqFileImport(sheetObject, formObject)
{
//	var myOption = "width=500,height=360,menubar=0,status=0,scrollbars=0,resizable=0";
//	var url = 'ESD_TRS_0911.do';
//	myWin = window.open(url, "popEqFileImport", myOption);
//	myWin.focus();
	
	var myOption = "dialogWidth:500px; dialogHeight:380px; help:no; status:no; resizable:no; scroll=no; ";
	window.showModalDialog("ESD_TRS_0911.do", window, myOption);
}


function importEqNo(popSheetObj, obj)
{
	var sheetObj = sheetObjects[0];
	var checkList = popSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var row = 0;
	var value = '';

	if(document.form.kind_chassis[0].checked){
		document.form.f_cmd.value = SEARCH06;
	}else{
		document.form.f_cmd.value = SEARCH07;
	}

	var queryStr = popSheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr==''){
		obj.close();
		return false;
	}
	sheetObj.DoSearch4Post("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(document.form), '', true);

	obj.close();
}


function setGateOutDate(sheetObj, checkArray){

	var row = 0;
	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		if(sheetObj.CellValue(row, 'org_gate_out_date') == '') {
			sheetObj.CellValue2(row, 'org_gate_out_dt') = '';
		}else{
			if(sheetObj.CellValue(row, 'org_gate_out_time') == '') {
				sheetObj.CellValue2(row, 'org_gate_out_time') = '000000';
			}
			sheetObj.CellValue2(row, 'org_gate_out_dt') = 
					sheetObj.CellValue(row, 'org_gate_out_date')
				+	sheetObj.CellValue(row, 'org_gate_out_time');
		}

		if(sheetObj.CellValue(row, 'dest_gate_in_date') == '') {
			sheetObj.CellValue2(row, 'dest_gate_in_dt') = '';
		}else{
			if(sheetObj.CellValue(row, 'dest_gate_in_time') == '') {
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '000000';
			}
			sheetObj.CellValue2(row, 'dest_gate_in_dt') = 
					sheetObj.CellValue(row, 'dest_gate_in_date')
				+	sheetObj.CellValue(row, 'dest_gate_in_time');
		}
	}
}


/**
* 2012.06.05 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
* PRD의 데이터를 조회하여 Distance를  계산한다. 
*/
function  distance_cal(sheetObj, row) {

	var fm_nod_cd	= sheetObj.CellValue(row, "fm_loc_value")
	var fm_nod_yard = sheetObj.CellValue(row, "fm_yard_value");
	var to_nod_cd	= sheetObj.CellValue(row, "to_loc_value");
	var to_nod_yard = sheetObj.CellValue(row, "to_yard_value");
	var dor_nod_cd = "";
	var dor_nod_yard = "";
	var via_nod_cd = "";
	var via_nod_yard = "";
	var trsp_bnd_cd = "";
	var trsp_crr_mod_cd = sheetObj.CellValue(row, "trsp_crr_mod_cd");
	var trsp_cost_dtl_mod_cd = "CY";
	
 	var queryString ="f_cmd="+SEARCH22
		            +"&fm_nod_cd="+fm_nod_cd
		            +"&fm_nod_yard="+fm_nod_yard
		            +"&to_nod_cd="+to_nod_cd
		            +"&to_nod_yard="+to_nod_yard
		            +"&dor_nod_cd="+dor_nod_cd
		            +"&dor_nod_yard="+ dor_nod_yard
		            +"&via_nod_cd="+via_nod_cd
		            +"&via_nod_yard="+ via_nod_yard
		            +"&trsp_bnd_cd="+ trsp_bnd_cd
		            +"&trsp_crr_mod_cd="+trsp_crr_mod_cd
		            +"&trsp_cost_dtl_mod_cd="+trsp_cost_dtl_mod_cd
		            ;
 	// sheetObj.GetSearchXml("ESD_TRS_0002GS.do", queryString);
 	sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
 	 
	sheetObj.CellValue2(row, "ttl_dist") = sheetObj.EtcData("ttl_dist");
	sheetObj.CellValue2(row, "lnk_dist_div_cd") = sheetObj.EtcData("lnk_dist_div_cd");
	
	sheetObj.RemoveEtcData();
	 	
}
