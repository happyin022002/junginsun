/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0231.js
*@FileTitle : Agreement Inquiry by Route 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 민정호
*@LastVersion : 1.3
* 2010.03.18 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.05.26 김종호   1.1 기능 구현
* 2010.10.08 최 선     1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.05.11 민정호   1.3 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 2011.06.29 민정호   1.4 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
* 2011.11.23 김영철  [CHM-201114499] [TRS] Agreement Inquiry by Route 에 필요한 변수 변경
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
* 2014.04.10 김현화 [CHM-201429759] AGMT Approval Date 및 Date Gap 추가 
* 2014.05.13 김현화 [CHM-201430151] 조회조건 추가
*   (1. Service Provider 조건 입력시 Locatio 조건 필수값에서 제외.
*    2. Approval Date 조건 추가. (입력한 날보다 크거나 같은 값 )
* 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
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
 * @class ESD_TRS_0231 : ESD_TRS_0231 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0231() {
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

//공통전역변수
var sheetObjects     = new Array();
var comboObjects 	 = new Array();		// 민정호-추가
var sheetCnt         = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;    

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/	
    var sheetObject = sheetObjects[0]; 
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		/* [1.1.조회로직] */
		case "btn_retrieve":
			formObject.cur_page_cnt.value = 1;
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;
			/* [1.2.minimize버튼-화면최소화] */
		case "btn_minimize":
			Mincount = (Mincount+1)%2;
			Minimize(Mincount);
			break;

			/* [2.1.엑셀다운로드 버튼] */
		case "btng_downexcel":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
			
		case "btns_frmnode": //FromNode Popup창
			openHireYardPopup('getFromNode');
			break;

		case "btns_vianode": //ViaNode Popup창
			openHireYardPopup('getViaNode');
			break;

		case "btns_tonode": //ToNode Popup창
			openHireYardPopup('getToNode');
			break;

		case "btns_dornode": //DoorLocation Popup창
			openHireYardPopup('getDorLoc');
			break;

//		case "btn_eqtpsz":
//			rep_Multiful_inquiry(srcName);
//			break;
			
		case "btn_serviceprovider":
			rep_OnPopupClick();
			break;
			
		case "reward":
			var ipageNo = formObject.cur_page_cnt.value;
			ipageNo--;

			if(Number(ipageNo) < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}  
			formObject.cur_page_cnt.value = ipageNo;
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;

		case "forward":
			var ipageNo = formObject.cur_page_cnt.value;
			var totpage = formObject.tot_page_cnt.value;
			ipageNo++;  
			if( (Number(ipageNo) > Number(formObject.tot_page_cnt.value)) || totpage < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}
			formObject.cur_page_cnt.value = ipageNo;
			doActionIBSheet(sheetObject,formObject,'IBSEARCH');
			break;

		case "btns_calendar1": 	// 추가-민정호
			var cal = new ComCalendar();
			cal.select(formObject.effective_date, 'yyyy-MM-dd');
			break;   
			
		case "btns_calendar2": 	// 2014.05.12 추가
			var cal = new ComCalendar();
			cal.select(formObject.approval_date, 'yyyy-MM-dd');
			break; 	

			/* [1.4.상단의 Agreement No.버튼] */
		case "btn_agmtno":		// 추가-민정호
			openAgmtNo();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('TRS90404');
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
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
	
    /* IBMultiCombo 초기화 */
 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
 		initCombo(comboObjects[k], k+1);
 	}
 	
	getTypeSizeCombo(document.combo1);
//	initControl();
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var sheetObject = sheetObjects[0];
	var cnt = 0;
	switch(sheetNo) {
	case 1: //sheet_main init
		with (sheetObj) {
		style.height    = 330; // 높이 설정
		SheetWidth      = mainTable.clientWidth; //전체 너비 설정
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
		MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
		Editable = true; //전체Edit 허용 여부 [선택, Default false]
		InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitColumnInfo(47, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)
		var HeadTitle1 = "Seq|Count|SCG\nCount||Service Porvider|Service Porvider|ofc_cty_cd|agmt_seq|Agreement\n No.|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|From|Via|Door|To|EQ Type\n/Size|Feeder Term|Feeder Term|No of\nChassis|Weight\nTier|UOM|Trans Mode|Currency|Basic Rate|Basic Rate|Reverse|Effective Date|Effective Date|AGMT Approval\nDate|Update\nDate|Update\nUser|Date\nGap|Confirm\n(Manager Level)|Confirm\nUser|Delete" ;
		var HeadTitle2 = "Seq|Count|SCG\nCount||Code|Name|ofc_cty_cd|agmt_seq|Agreement\n No.|Cost\nMode|Cargo\nType|CNT\nType|cust_cnt_cd|cust_seq|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|Via|Door|To|EQ Type\n/Size|Receiving|Delivery|No of\nChassis|Weight\nTier|UOM|Trans Mode|Currency|One Way|Round Trip|Reverse|From|To|AGMT Approval\nDate|Update\nDate|Update\nUser|Date\nGap|Confirm\n(Manager Level)|Confirm\nUser|Delete" ;

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		//데이터속성  	  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtSeq,        30,  daCenter, true,  "seq",       false,    "",  dfNone,     0,     true,   true,   0,     false,   true,  "", false);
		InitDataProperty(0, cnt++ , dtPopup,      50,  daCenter, true,  "cnt",  	 false,    "",  dfNone,     0,     true,   true,   10,    false,   true,  "", false);			
		InitDataProperty(0, cnt++ , dtPopup,      50,  daCenter, true,  "scg_cnt",   false,    "",  dfNone,     0,     true,   true,   10,    false,   true,  "", false);
		InitDataProperty(0, cnt++ , dtHidden,     50,  daCenter, true,  "chk",  	 false,    "",  dfNone,     0,     false,  false,  10,    false,   true,  "", false);						
		InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,  "vndr_seq",  false,    "",  dfNone,     0,     false,  false,  10,    false,   true,  "", false);
		InitDataProperty(0, cnt++ , dtData,       120, daLeft,   true,  "vndr_nm",   false,    "",  dfNone,     0,     false,  false,  10,    false,   true,  "", false);
		InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter, true,  "trsp_agmt_ofc_cty_cd", false, "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter, true,  "trsp_agmt_seq",        false, "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);	  
		InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,  "agmt_no",           	false, "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,  "trsp_cost_mod_cd",  	false, "",  dfNone,     0,     false,  false,   2,   false,   true,  "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
		InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,  "cgo_tp_cd",         false,    "",  dfNone,     0,     false,  false,   2,   false,   true,  "Cargo Type-F:Full, E:Empty",    false);
		InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true,  "cust_nomi_trkr_ind_cd",false, "",  dfNone,     0,     false,  false,   2,   false,   false, "",    false);
		InitDataProperty(0, cnt++ , dtHidden,     70,  daCenter, true,  "cust_cnt_cd",       false,    "",  dfEngUpKey, 0,     false,  false,   8,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtHidden,     70,  daCenter, true,  "cust_seq",          false,    "",  dfEngUpKey, 0,     false,  false,   8,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "customer_cd",       false,    "",  dfEngUpKey, 0,     false,  false,   8,   false,   true,  "Customer Code for this agreement",    false);
		InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,  "cmdt_grp_cd",       false,    "",  dfEngUpKey, 0,     false,  false,   6,   false,   true,  "Commodity Group that this rate is being applied",   false);
		InitDataProperty(0, cnt++ , dtData,       90,  daCenter, true,  "rail_svc_tp_cd",    false,    "",  dfNone,     0,     false,  false,  50,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "fm_nod_cd",         false,    "",  dfEngUpKey, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "via_nod_cd",        false,    "",  dfEngUpKey, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "dor_nod_cd",        false,    "",  dfEngUpKey, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "to_nod_cd",         false,    "",  dfEngUpKey, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       55,  daCenter, true,  "trsp_agmt_eq_tp_sz_cd", false,  "",  dfNone,       0, false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtCombo,      62,  daCenter, true,  "wtr_rcv_term_cd",       false,  "",  dfNone,       0, false,  false,   1,   false,   true,  "Receving-I:FIO, T:Trackle Term, Y:CY Term, V:VD Term",    false);
		InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,  "wtr_de_term_cd",        false,  "",  dfNone,       0, false,  false,   1,   false,   true,  "Delivery-O:FIO, T:Trackle Term, Y:CY Term, V:VD Term",    false);
		InitDataProperty(0, cnt++ , dtData,       60,  daRight,  true,  "trsp_agmt_bdl_qty",     false,  "",  dfNullInteger,0, false,  false,   3,   false,   true,  "Input number of bundled chassis",   false);
		InitDataProperty(0, cnt++ , dtData,       60,  daRight,  true,  "to_wgt",                false,  "",  dfNone,       0, false,  false,   9,   false,   true,  "The final value of weight tier should be 'Max'",    false);
		InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,  "wgt_meas_ut_cd",   false,     "",  dfNone,     0,     false,  false,   3,   false,   true,  "Unit of measure for weight",    false);
		InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,  "agmt_trsp_tp_cd",  false,     "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,  "curr_cd",          false,     "",  dfNone,     0,     false,  false,  10,   false,   true,  "",	false);
		InitDataProperty(0, cnt++ , dtPopup,      70,  daRight,  true,  "trsp_one_wy_rt",   false,     "",  dfNone,     0,      true,   true,  10,   false,   true,  "",	false);
		InitDataProperty(0, cnt++ , dtPopup,      70,  daRight,  true,  "trsp_rnd_rt",      false,     "",  dfNone,     0,      true,   true,  10,   false,   true,  "", 	false);

		InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,  "trsp_rvs_aply_flg", false,    "",  dfNone,     0,     false,  false, 	8,   false,  false,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,  "eff_fm_dt",         false,    "",  dfDateYmd,  0,     false,  false, 	8,   false,  false,  "",    false);
	    InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,  "eff_to_dt",         false,    "",  dfDateYmd,  0,     false,  false, 	8,   false,  false,  "",    false);
	    //2014.04.11 추가
	    InitDataProperty(0, cnt++ , dtData,       110,  daCenter,true,  "agmt_apro_dt",  	 false,    "",  dfDateYmd,  0,     false,  false, 	8,   false,  false,  "",    false);
	    InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,  "upd_dt",        	 false,    "",  dfDateYmd,  0,     false,  false, 	8,   false,  false,  "",    false);
	    InitDataProperty(0, cnt++ , dtData,       80,  daLeft, 	 true,  "upd_usr_nm",        false,    "",  dfNone,  	0,     false,  false, 	8,   false,  false,  "",    false);
	    InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,  "dt_gap",        	 false,    "",  dfNone,     0,     false,  false, 	8,   false,  false,  "",    false);
		InitDataProperty(0, cnt++ , dtData,      100,  daCenter, true,  "cfm_flg",  		 false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtData,       80,  daLeft,   true,  "cfm_usr_nm",  		 false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", 	false);	
	    
		InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter, true,  "delt_flg",                false, "",dfNone,     0,    false,  false,  10,   false,   true,  "", 	false);		    
		InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter, true,  "trsp_agmt_rt_tp_ser_no",  false, "",dfNone,     0,    false,  false,  10,   false,   true,  "", 	false);
		InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter, true,  "ctrt_ofc_cd",             false, "",dfNone,     0,    false,  false,  10,   false,   true,  "", 	false);
		
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "fm_nod_cd_nm",         false,    "",  dfNone, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "via_nod_cd_nm",        false,    "",  dfNone, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "dor_nod_cd_nm",        false,    "",  dfNone, 0,     false,  false,   5,   false,   true,  "",    false);
		InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,  "to_nod_cd_nm",         false,    "",  dfNone, 0,     false,  false,   5,   false,   true,  "",    false);
		
		InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"HJS|CNT|CPT|HPT|MIC",		"HJS|CNT|CPT|HPT|MIC");
		
		ColHidden("cnt") = true;
		ColHidden("scg_cnt") = true;
		}
		break;
	case 2 :
		with (sheetObj) {
			style.height = 0; // 높이 설정
			SheetWidth = 0; //전체 너비 설정
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
			MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
			Editable = false; //전체Edit 허용 여부 [선택, Default false]
			InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitColumnInfo(1, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle0 = "tpsz";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle0, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "tpsz", false, "", dfNone, 0, false, false);						
		}		
		break;
	} //end-switch
}

/**
* Sheet관련 프로세스 처리
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case "IBSEARCH":
		if(!inputcheck()) return;		
		
		if(!nodecheck()) return;		

		if(validateForm(sheetObj,formObj,sAction)){
			
			var agmt_gb = formObj.fm_effective_agmt.value;
			
			if( agmt_gb == "C" ) {
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_TRS_0231GS.do", TrsFrmQryString(formObj));
			}else{
				if(!agreementcheck()) return;
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("ESD_TRS_0231GS.do", TrsFrmQryString(formObj));
			}						
		}
		break;
		
	case IBDOWNEXCEL:
		sheetObj.Down2Excel(-1, false, false, true);    	   
		break;
	}
}

// Service Provider 또는 AGMT No. 둘 중의 하나 존재 여부 체크
function agreementcheck(){
	var formObj = document.form;
	var fm_agmtno = formObj.fm_agmtno.value;
	var fm_vndr_prmry_seq = formObj.fm_vndr_prmry_seq.value;	
	
	if( fm_agmtno == "" && fm_vndr_prmry_seq == ""){
		ComShowCodeMessage('TRS90386','Please input the Service Provider Or the Agreement No.');
		formObj.fm_agmtno.focus();
		return false;
	}
	return true;
}

function inputcheck(){

	var formObj = document.form;
	var search_fm_loc = formObj.search_fm_loc.value;
	var search_via_loc = formObj.search_via_loc.value;
	var search_door_loc = formObj.search_door_loc.value;
	var search_to_loc = formObj.search_to_loc.value;	
	var costmode			= formObj.costmode.value;
	var cargo				= formObj.cargo.value;
	var fm_vndr_prmry_seq	= formObj.fm_vndr_prmry_seq.value;
	var fm_agmt_trsp_tp_cd	= formObj.fm_agmt_trsp_tp_cd.value;
	var eqtype				= formObj.eqtype.value;
	var eqtpsz				= formObj.eqtpsz.value;
	var fm_agmtno			= formObj.fm_agmtno.value;

			
	if(search_fm_loc == "" && search_via_loc == "" && search_door_loc == "" && search_to_loc == "" &&
	   costmode == "" && cargo == "" && fm_vndr_prmry_seq == "" &&
	   fm_agmt_trsp_tp_cd == undefined && eqtype == 'U' && eqtpsz == '' && fm_agmtno != ''){
		ComShowCodeMessage('TRS90386', 'More condition needs to be inserted. Pls input node info. more than one to retrieve the data.');
		return false;
	}else{
		return true;
	}
	
}



/**
* 조회 조건 노드 입력 체크
*/
function nodecheck(){
	var formObj = document.form;
	var search_fm_loc = formObj.search_fm_loc.value;
	var search_via_loc = formObj.search_via_loc.value;
	var search_door_loc = formObj.search_door_loc.value;
	var search_to_loc = formObj.search_to_loc.value;
	var fm_cnt = 0;
	var via_cnt = 0;
	var door_cnt = 0;
	var to_cnt = 0;
	var total_cnt = 0;
	var fm_vndr_prmry_seq	= formObj.fm_vndr_prmry_seq.value;
	
	if( search_fm_loc != "" ) fm_cnt = 1; else fm_cnt = 0;
	if( search_via_loc != "" ) via_cnt = 1; else via_cnt = 0;
	if( search_door_loc != "" ) door_cnt = 1; else door_cnt = 0;
	if( search_to_loc != "" ) to_cnt = 1; else to_cnt = 0;
	total_cnt = fm_cnt + via_cnt + door_cnt + to_cnt;
	
	if( total_cnt < 2 && fm_vndr_prmry_seq == ""){
	   ComShowCodeMessage('TRS90386', 'Please input at least more than two among From/Via/Door/To node.!');
	   return false;
	}
	return true;
}


/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 424, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

///**
// * rep_commodity팝업호출
// */
//function rep_Multiful_inquiry(objName)	{
//	var formObject = document.form;
//	var cmdt_cd_val ="";   //향후 사용가능 예정변수
//	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
//	var cmdt_desc_val ="";   //향후 사용가능 예정변수
//	var classId ="getTRS_ENS_906";
//	var xx1=objName;  //CONTI
//	var xx2="";  //SUB CONTI
//	var xx3="";  //COUNTRY
//	var xx4="";  //STATE
//	var xx5="";  //CONTROL OFFIC
//	var xx6="";  //LOC CODE
//	var xx7="";  //LOC NAME
//	var xx8="";
//	var xx9="";
//
//	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
//	ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
//}

///**
// * Location : 팝업에서 단일 선택을 한경우..
// */
//function getTRS_ENS_906(rowArray, x1) {
//	var formObject = document.form;
//	if(x1 == 'btn_eqtpsz'){
//		formObject.eqtpsz.value = rowArray;
////		checkDigit();
//	}
//}

/**
 * Minimize 이벤트 관련
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(21);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(15);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		//날짜 Validation 추가 2013.11.20 조인영
		var effective_date_trim = ComTrimAll(ComTrimAll(formObj.effective_date.value, " "), "-");
		if( effective_date_trim != "" ) { //날짜 체크하는 부분
			if( !ComIsDate(effective_date_trim) ) {
				ComShowCodeMessage("TRS90070");
				formObj.effective_date.focus();
				return false;
			}
		}
	}

	return true;
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
 * Via Node 팝업에 대한 리턴값
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}


/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;

	for (var i = 0; i < lvobj.length; i++)
	{
		var oneChar = lvobj.charAt(i)
		if (oneChar != "")
		{
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
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
	}else{
		ComShowCodeMessage('COM12130','NODE','');
		obj.value = "";
		obj.focus();
		return false;
	}

	if( lvobj == "" ) {
	
		obj.value = "";
	
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj = document.search_via_yard;
		else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;
	
		var locValue = obj.value;
	
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
	
	} else if( lvobj.length != 5 ) {
	
		ComShowCodeMessage('TRS90074')
	
		if(sep=="F"){
			formObj.search_fm_loc.select();
			formObj.search_fm_loc.focus();
		}else if(sep=="V"){
			formObj.search_via_loc.select();
			formObj.search_via_loc.focus();
		}else if(sep=="T"){
			formObj.search_to_loc.select();
			formObj.search_to_loc.focus();
		}else if(sep=="D"){
			formObj.search_door_loc.select();
			formObj.search_door_loc.focus();
		}else{
	
		}
	}else{
		if( sep == 'F' ){
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
	}
}

/**
 * 대문자 변환
 */
function upperCase(obj){
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
}

/**
 * 포커스 전체선택하기
 */
function fun_Focus(obj){
	obj.select();
}

/**
 * 팝업창 오픈
 */
function sheet_main_OnPopupClick(sheetObj, row, col) {
	sheet_main_popup(sheetObj, row, col);
}

 /**
 * S/P 정보를 조회
 */
 function  vender_blur(){
 	var formObj = document.form;
 	var error_val = "";
 	var lvobj = formObj.fm_vndr_prmry_seq.value;
 	if(lvobj !=""){
 		for (var i = 0; i < lvobj.length; i++)
 		{
 			var oneChar = lvobj.charAt(i)
 			if (oneChar != "")
 			{
 				if (  (oneChar >= "0" && oneChar <= "9" )  ){
 				}else {
 					error_val ="Y";
 					break;
 				}
 			}
 		}
 	}
 	if(error_val =="Y" ){
 		return;
 	}
    formObj.sheet_main.RemoveEtcData();
 	formObj.f_cmd.value = SEARCH07;
 	sheetObjects[0].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
 	x1 = formObj.sheet_main.EtcData('VNDR_NM');
 	if(x1 !="" && x1 != undefined){ //
 		formObj.fm_vndr_prmry_nm.value = x1;
 	}else{
 		formObj.fm_vndr_prmry_nm.value = "";
 	}
 }
 
 /*
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
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
	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* Service Provider 팝업호출 : 팝업에서 단일 선택을 한경우..
*/
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];
		formObj.fm_vndr_prmry_seq.value =colArray2;
		formObj.fm_vndr_prmry_nm.value =colArray4;
	}
}

/**
 * 조회후 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_main_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj = document.form;
	var cmd = formObj.f_cmd.value;
	var cur_page = formObj.cur_page_cnt.value;
	if( (cmd == SEARCH01 || cmd == SEARCH02) && sheetObj.RowCount > 0 && cur_page == "1") {
		var tot_cnt = sheetObj.EtcData('TOT_CNT');
    	formObj.tot_page_cnt.value = tot_cnt;
	}
}

/**
 * 화면 Reset
 */
function reset_all(){	 
	var formObject = document.form;
		formObject.tot_page_cnt.value="0";
		formObject.cur_page_cnt.value="1";
		formObject.sheet_main.RemoveEtcData();
		formObject.sheet_main.RemoveAll();	
}

 /**
 * Onkeydown 이벤트 관련
 */
 function gotopage(){
	 var formObject = document.form;
	 var tot_page = "";
	 var cur_page = "";
	 cur_page = formObject.cur_page_cnt.value;
	 tot_page = formObject.tot_page_cnt.value;
	 if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
		 var errMessage = ComGetMsg('TRS90351','','','');  
		 ComShowMessage(errMessage);
		 return;
	 }
	 doActionIBSheet(sheetObjects[0],formObject,"IBSEARCH"); 
 }

 
//#################################################################################
 
  /**
  * EQ 조회
  **/
  function getTypeSizeList(sheetObj, formObject)
  {
  	 sheetObj.WaitImageVisible  = false;
  	 formObject.f_cmd.value = SEARCH03;
  	 var queryString = TrsFrmQryString(formObject);
  	 sheetObj.DoRowSearch("ESD_TRS_0231GS.do", queryString);
  	 sheetObj.WaitImageVisible  = true;
  	 return sheetObj.EtcData('TPSZ');
  }  
  
  /**
  * EQ 조회
  **/  
function getTypeSizeCombo(comboObj)
{
	  var formObj = document.form;
	  var TySzList = getTypeSizeList(sheetObjects[1], formObj);	  
	  var TySzArray = new Array();	  	 
	  TySzArray = TySzList.split("|");
	  comboObj.RemoveAll();
	  comboObj.InsertItem(0, "ALL", "ALL");
	  for(var i=1; i<TySzArray.length+1; i++)
	  {
		  comboObj.InsertItem(i, TySzArray[i-1], TySzArray[i-1]);
	  }	  
	  comboObj.Index=0;	  
}
    
function openAgmtNo() {
	var formObject = document.form;
	var Option = "width=700,height=400,menubar=0,status=0,scrollbars=0,resizable=0";
	var agmt_no = formObject.fm_agmtno.value;   
	var param ="?agmt_no="+agmt_no;
	window.open('/hanjin/ESD_TRS_0233.do' + param, "popupAgmtHdrList", Option);
}

/*
* Agreement No조회 팝업에서  Agreement No를 리턴받는 함수
*/
function getAgmtNo( value, vndr_seq, vndr_nm, row ){
	var formObject = document.form;
	formObject.fm_agmtno.value = value;  
//	doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
}

/**
 * MultiCombo object initial property //LHS
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo (comboObj, comboNo) {
	 switch(comboObj.id) {
   	 case "combo1":
		with(comboObj) {
			//BackColor = "cyan";
			DropHeight = 150;
			MultiSelect = true;
			UseAutoComplete = true;
			MultiSeparator = ",";
			Style = 0;
			ValidChar(2,3);
		}
	break;
	 }      	
}

/**
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}

function sheet1_OnLoadFinish(sheetObj) {
	 comboObjects[0].CheckIndex(0) = true;
}

/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}


/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}
		formObj.eqtpsz.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.eqtpsz.value = "";
	}else{
	    formObj.eqtpsz.value = ComGetObjValue(comboObj);
	}
}


/**
 * combo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}
	}
}
 
 function doSearchEnter() {
 	if( event.keyCode == 13 ) {
 	}
 } 
 
 function sheet_main_OnPopupClick (sheetObj , row , col )
 {
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);
	
	switch(colName)
	{	 
		case('cnt'):
			openRateHistory(sheetObj, row);
		break;	 		
		case('scg_cnt'):						
			if(sheetObj.CellValue(row, 'chk') == 'Y'){
				//ESD_TRS_0223에서 호출			
				//ESD_TRS_0234 호출
				
				var myWindow = null;
				var url = null;
				
				url = '?agmt_no='+sheetObj.CellValue(row, "agmt_no");
				url += '&vndr_seq='+sheetObj.CellValue(row, "vndr_seq");
				url += '&trsp_rail_scg_cd='+'FSG';
//				url += '&agmt_rout_all_flg='+sheetObj.CellValue(row, "agmt_rout_all_flg");
				url += '&agmt_rout_all_flg='+'1';				
				
				url += '&fm_nod_cd='+sheetObj.CellValue(row, "fm_nod_cd")+sheetObj.CellValue(row, "fm_nod_yard");
				url += '&to_nod_cd='+sheetObj.CellValue(row, "to_nod_cd")+sheetObj.CellValue(row, "to_nod_yard");
				
				url += '&cgo_tp_cd='+sheetObj.CellValue(row, "cgo_tp_cd");					
				url += '&eff_fm_dt='+sheetObj.CellValue(row, "eff_fm_dt");
				url += '&eff_to_dt='+sheetObj.CellValue(row, "eff_to_dt");
				url += '&effective_date='+document.form.effective_date.value;	
				url += '&gubun='+document.form.gubun.value;
				url += '&delete_yn='+document.form.delete_yn.value;
				
				myWindow = window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=450");
				myWindow.focus();																										
			}else{				
				//ESD_TRS_0229에서 호출
				//ESD_TRS_0230호출				
				openSurchargeRateHistory(sheetObj, row);				
			}
		break;	 	
	}
	sheet_main_popup(sheetObj, row, col);
 }
 
 
 function openSurchargeRateHistory(sheetObject, row)
 {
	 var formObj = document.form;
	 var resultcheck = 0;

//	 var agmt_no 			= formObj.fm_agmtno.value;
	 var agmt_no			= sheetObject.CellValue(row, 'agmt_no');	 
//	 var trsp_agmt_rt_tp_cd = formObj.fm_trsp_agmt_rt_tp_cd.value;
	 var trsp_agmt_rt_tp_cd = 'P';
	 
	 var trsp_cost_mod_cd 	= sheetObject.CellValue(row, 'trsp_cost_mod_cd');
	 var agmt_trsp_tp_cd  	= sheetObject.CellValue(row, 'agmt_trsp_tp_cd'); //최초 데이타생성한 ofc
	 var cgo_tp_cd 			= sheetObject.CellValue(row, 'cgo_tp_cd');
	 var cust_cd     		= sheetObject.CellValue(row, 'cust_cd');
	 var cmdt_grp_cd 		= sheetObject.CellValue(row, 'cmdt_grp_cd');
	 var rail_svc_tp_cd 	= sheetObject.CellValue(row, 'rail_svc_tp_cd');
	 var fm_nod_cd 			= sheetObject.CellValue(row, 'fm_nod_cd');
	 var fm_nod_yd 			= sheetObject.CellValue(row, 'fm_nod_yd');
	 var via_nod_cd 		= sheetObject.CellValue(row, 'via_nod_cd');
	 var via_nod_yd 		= sheetObject.CellValue(row, 'via_nod_yd');
	 var dor_nod_cd 		= sheetObject.CellValue(row, 'dor_nod_cd');
	 var dor_nod_yd 		= sheetObject.CellValue(row, 'dor_nod_yd');
	 var to_nod_cd  		= sheetObject.CellValue(row, 'to_nod_cd');
	 var to_nod_yd  		= sheetObject.CellValue(row, 'to_nod_yd');
     if(fm_nod_cd.length == 7){
    	 fm_nod_cd = sheetObject.CellValue(row, 'fm_nod_cd').substring(0,5);
    	 fm_nod_yd = sheetObject.CellValue(row, 'fm_nod_cd').substring(5,7);
     }     
     
     if(via_nod_cd.length == 7){
    	 via_nod_cd = sheetObject.CellValue(row, 'via_nod_cd').substring(0,5);
    	 via_nod_yd = sheetObject.CellValue(row, 'via_nod_cd').substring(5,7);
     }     

     if(dor_nod_cd.length == 7){
    	 dor_nod_cd = sheetObject.CellValue(row, 'dor_nod_cd').substring(0,5);
    	 dor_nod_yd = sheetObject.CellValue(row, 'dor_nod_cd').substring(5,7);
     }     

     if(to_nod_cd.length == 7){
    	 to_nod_cd = sheetObject.CellValue(row, 'to_nod_cd').substring(0,5);
    	 to_nod_yd = sheetObject.CellValue(row, 'to_nod_cd').substring(5,7);
     }    
	 
	 var trsp_scg_cd  			= sheetObject.CellValue(row, 'trsp_scg_cd');
	 var agmt_route_all_flg  	= sheetObject.CellValue(row, 'agmt_route_all_flg');
	      
     if(trsp_cost_mod_cd == undefined) trsp_cost_mod_cd = '';
     if(agmt_trsp_tp_cd == undefined) agmt_trsp_tp_cd = ''	;
     if(cgo_tp_cd == undefined) cgo_tp_cd = ''          	;
     if(cust_cd == undefined) cust_cd = ''            		;
     if(cmdt_grp_cd == undefined) cmdt_grp_cd = ''        	;
     if(rail_svc_tp_cd == undefined) rail_svc_tp_cd = ''	;
     if(fm_nod_cd == undefined) fm_nod_cd = ''          	;
     if(fm_nod_yd == undefined) fm_nod_yd = ''          	;
     if(via_nod_cd == undefined) via_nod_cd = ''         	;
     if(via_nod_yd == undefined) via_nod_yd = ''         	;
     if(dor_nod_cd == undefined) dor_nod_cd = ''         	;
     if(dor_nod_yd == undefined) dor_nod_yd = ''         	;
     if(to_nod_cd == undefined) to_nod_cd = ''          	;
     if(to_nod_yd == undefined) to_nod_yd = ''          	;
     if(trsp_scg_cd == undefined) trsp_scg_cd = ''			;
     if(agmt_route_all_flg == undefined) agmt_route_all_flg = '';
	 
     formObj.fm_eq_knd_cd.value = formObj.eqtype.value;
     formObj.fm_eqtpsz.value = sheetObject.CellValue(row, 'trsp_agmt_eq_tp_sz_cd');
     formObj.fm_eqtpsz.value = 'ALL';
     
     fm_nod_yd = '';
     via_nod_yd = '';
     dor_nod_yd = '';
     to_nod_yd = '';
     agmt_route_all_flg = 'Y';
     
     formObj.agmt_no.value = agmt_no  ;								// 추가-민정호
     formObj.trsp_agmt_rt_tp_cd.value = trsp_agmt_rt_tp_cd  ;		// 추가-민정호	  
	 formObj.chk_trsp_cost_mod_cd.value = trsp_cost_mod_cd  ;
	 formObj.chk_agmt_trsp_tp_cd.value = agmt_trsp_tp_cd    ;
	 formObj.chk_cgo_tp_cd.value = cgo_tp_cd          		;
	 formObj.chk_cust_cd.value = cust_cd            		;
	 formObj.chk_cmdt_grp_cd.value = cmdt_grp_cd        	;
	 formObj.chk_rail_svc_tp_cd.value = rail_svc_tp_cd     	;
	 formObj.chk_fm_nod_cd.value = fm_nod_cd          		;
	 formObj.chk_fm_nod_yd.value = fm_nod_yd          		;
	 formObj.chk_via_nod_cd.value = via_nod_cd         		;
	 formObj.chk_via_nod_yd.value = via_nod_yd         		;
	 formObj.chk_dor_nod_cd.value = dor_nod_cd         		;
	 formObj.chk_dor_nod_yd.value = dor_nod_yd         		;
	 formObj.chk_to_nod_cd.value = to_nod_cd          		;
	 formObj.chk_to_nod_yd.value = to_nod_yd          		;	 		 
	 formObj.chk_trsp_scg_cd.value = trsp_scg_cd			;
	 formObj.chk_agmt_route_all_flg.value = agmt_route_all_flg;
	 	 		 
	 resultcheck = 1;
	 	 
	 if(resultcheck == 1){
		 var myOption = "width=980,height=530,menubar=0,status=0,scrollbars=0,resizable=0";
		 var param = "?gubun2=0231&route_gubun=route&"+TrsFrmQryString(formObj);
		 		 
		 myWin = window.open('/hanjin/ESD_TRS_0230.do' + param, "Hispopup", myOption);  		
	 }else if(resultcheck == 0){
		 ComShowCodeMessage('TRS90215');
	 }else if(resultcheck > 1){
		 ComShowCodeMessage('TRS90357');
	 }
 }
 
 /*
  * Rate History 
  * 
  */
 
 function openRateHistory(sheetObject, row)
 {
	 var formObj = document.form;
     
	 var agmt_no			= sheetObject.CellValue(row, 'agmt_no');
     var trsp_agmt_rt_tp_cd = 'P';    
          
     var trsp_cost_mod_cd 	= sheetObject.CellValue(row, 'trsp_cost_mod_cd');
     var agmt_trsp_tp_cd  	= sheetObject.CellValue(row, 'agmt_trsp_tp_cd'); //理쒖큹 ?곗씠??앹꽦??ofc
     var cgo_tp_cd 			= sheetObject.CellValue(row, 'cgo_tp_cd');
     var cust_cd     		= sheetObject.CellValue(row, 'cust_cd');
     var cmdt_grp_cd 		= sheetObject.CellValue(row, 'cmdt_grp_cd');
     var rail_svc_tp_cd 	= sheetObject.CellValue(row, 'rail_svc_tp_cd');     
     var fm_nod_cd 			= sheetObject.CellValue(row, 'fm_nod_cd');
     var fm_nod_yd 			= sheetObject.CellValue(row, 'fm_nod_yd');
     var via_nod_cd 		= sheetObject.CellValue(row, 'via_nod_cd');
     var via_nod_yd 		= sheetObject.CellValue(row, 'via_nod_yd');
     var dor_nod_cd 		= sheetObject.CellValue(row, 'dor_nod_cd');
     var dor_nod_yd 		= sheetObject.CellValue(row, 'dor_nod_yd');
     var to_nod_cd  		= sheetObject.CellValue(row, 'to_nod_cd');
     var to_nod_yd  		= sheetObject.CellValue(row, 'to_nod_yd');
     var trsp_dist_tp_cd 	= sheetObject.CellValue(row, 'trsp_dist_tp_cd');
     var trsp_agmt_dist  	= sheetObject.CellValue(row, 'trsp_agmt_dist');
     var dist_meas_ut_cd 	= sheetObject.CellValue(row, 'dist_meas_ut_cd');
         
     if(fm_nod_cd.length == 7){
    	 fm_nod_cd = sheetObject.CellValue(row, 'fm_nod_cd').substring(0,5);
    	 fm_nod_yd = sheetObject.CellValue(row, 'fm_nod_cd').substring(5,7);    	 
     }          
     
     if(via_nod_cd.length == 7){
    	 via_nod_cd = sheetObject.CellValue(row, 'via_nod_cd').substring(0,5);
    	 via_nod_yd = sheetObject.CellValue(row, 'via_nod_cd').substring(5,7);
     }     

     if(dor_nod_cd.length == 7){
    	 dor_nod_cd = sheetObject.CellValue(row, 'dor_nod_cd').substring(0,5);
    	 dor_nod_yd = sheetObject.CellValue(row, 'dor_nod_cd').substring(5,7);
     }     

     if(to_nod_cd.length == 7){
    	 to_nod_cd = sheetObject.CellValue(row, 'to_nod_cd').substring(0,5);
    	 to_nod_yd = sheetObject.CellValue(row, 'to_nod_cd').substring(5,7);
     }          
          
     if(cust_cd == undefined) cust_cd = '';
     if(trsp_agmt_dist == undefined) trsp_agmt_dist = '';          
     formObj.fm_eq_knd_cd.value = formObj.eqtype.value;
     formObj.fm_eqtpsz.value = sheetObject.CellValue(row, 'trsp_agmt_eq_tp_sz_cd');
                   
     formObj.agmt_no.value = agmt_no  ;								// 추가-민정호
     formObj.trsp_agmt_rt_tp_cd.value = trsp_agmt_rt_tp_cd  ;		// 추가-민정호
     formObj.chk_trsp_cost_mod_cd.value = trsp_cost_mod_cd  ;
     formObj.chk_agmt_trsp_tp_cd.value = agmt_trsp_tp_cd    ;
     formObj.chk_cgo_tp_cd.value = cgo_tp_cd          		;
     formObj.chk_cust_cd.value = cust_cd					;
     formObj.chk_cmdt_grp_cd.value = cmdt_grp_cd        	;
     formObj.chk_rail_svc_tp_cd.value = rail_svc_tp_cd     	;
     formObj.chk_fm_nod_cd.value = fm_nod_cd          		;
     formObj.chk_fm_nod_yd.value = fm_nod_yd          		;
     formObj.chk_via_nod_cd.value = via_nod_cd         		;
     formObj.chk_via_nod_yd.value = via_nod_yd         		;
     formObj.chk_dor_nod_cd.value = dor_nod_cd         		;
     formObj.chk_dor_nod_yd.value = dor_nod_yd         		;
     formObj.chk_to_nod_cd.value = to_nod_cd          		;
     formObj.chk_to_nod_yd.value = to_nod_yd          		;
     formObj.chk_trsp_dist_tp_cd.value = trsp_dist_tp_cd    ;
     formObj.chk_trsp_agmt_dist.value = trsp_agmt_dist		;
     formObj.chk_dist_meas_ut_cd.value = dist_meas_ut_cd    ;
                   
	var myOption = "width=980,height=530,menubar=0,status=0,scrollbars=0,resizable=0";
	var param = "?route_gubun=route&"+TrsFrmQryString(formObj);
	
	myWin = window.open('/hanjin/ESD_TRS_0227.do' + param, "Hispopup", myOption);	
 }
  
  
  /**
   * 팝업창 오픈
   */
function sheet_main_popup(sheetObj, row, col) {
	
  	var formObject = document.form;
  	formObject.fm_rail_svc_tp_cd.value = sheetObj.CellValue(row, "rail_svc_tp_cd");
  	formObject.fm_pop_agmt_trsp_tp_cd.value = sheetObj.CellValue(row, "agmt_trsp_tp_cd");
  	formObject.fm_trsp_agmt_ofc_cty_cd.value = sheetObj.CellValue(row, "trsp_agmt_ofc_cty_cd");
  	formObject.fm_trsp_agmt_seq.value = sheetObj.CellValue(row, "trsp_agmt_seq");
  	formObject.fm_trsp_agmt_rt_tp_ser_no.value = sheetObj.CellValue(row, "trsp_agmt_rt_tp_ser_no");
  	formObject.fm_vndr_seq.value = sheetObj.CellValue(row, "vndr_seq");
  	formObject.fm_ctrt_ofc_cd.value = sheetObj.CellValue(row, "ctrt_ofc_cd");
  	formObject.fm_eq_knd_cd.value = formObject.eqtype.value;
  	formObject.fm_trsp_agmt_eq_tp_sz_cd.value = sheetObj.CellValue(row, "trsp_agmt_eq_tp_sz_cd");
  	formObject.fm_cgo_tp_cd.value = sheetObj.CellValue(row, "cgo_tp_cd");
  	formObject.fm_fm_nod_cd.value = sheetObj.CellValue(row, "fm_nod_cd");
  	formObject.fm_via_nod_cd.value = sheetObj.CellValue(row, "via_nod_cd");
  	formObject.fm_dor_nod_cd.value = sheetObj.CellValue(row, "dor_nod_cd");
  	formObject.fm_to_nod_cd.value = sheetObj.CellValue(row, "to_nod_cd");
  	formObject.fm_trsp_agmt_bdl_qty.value = sheetObj.CellValue(row, "trsp_agmt_bdl_qty");
  	formObject.fm_wgt_meas_ut_cd.value = sheetObj.CellValue(row, "wgt_meas_ut_cd");
  	formObject.fm_curr_cd.value = sheetObj.CellValue(row, "curr_cd");

  	if(sheetObj.ColSaveName(col) == "trsp_one_wy_rt") {
  		formObject.fm_way.value = "ONE";
  		formObject.fm_basic_rt.value = sheetObj.CellValue(row, "trsp_one_wy_rt");
  		ComPostOpenWindow("ESD_TRS_0235.do", "OpenScg", "width=500,height=410,menubar=0,status=1,scrollbars=0,resizable=0");
  		formObject.target = 'OpenScg';
  		formObject.submit();
  	}else if(sheetObj.ColSaveName(col) == "trsp_rnd_rt"){
  		formObject.fm_way.value = "RND";
  		formObject.fm_basic_rt.value = sheetObj.CellValue(row, "trsp_rnd_rt");
  		ComPostOpenWindow("ESD_TRS_0235.do", "OpenScg", "width=500,height=410,menubar=0,status=1,scrollbars=0,resizable=0");
  		formObject.target = 'OpenScg';
  		formObject.submit();
  	}
}
   
function effective_agmt_change() {
	var formObject = document.form;
	var agmt_gb = formObject.fm_effective_agmt.value;
	var objs = document.all.item("effLayer");
	if( agmt_gb == "C" ) {
		formObject.effective_date.value = formObject.hid_effective_date.value;
		formObject.effective_date.disabled = true;
		formObject.fm_vndr_prmry_seq.className	= "input";		
		formObject.fm_agmtno.className	= "input";
		formObject.effective_date.className	= "input";
		objs.style.display = "none";
		sheetObjects[0].ColHidden("cnt") = true;
		sheetObjects[0].ColHidden("scg_cnt") = true;
	}else{
		formObject.effective_date.value = formObject.hid_effective_date.value;
		formObject.effective_date.disabled = false;
		formObject.fm_vndr_prmry_seq.className	= "input1";		
		formObject.fm_agmtno.className	= "input1";
		formObject.effective_date.className	= "input1";
		objs.style.display = "inline";
		sheetObjects[0].ColHidden("cnt") = false;
		sheetObjects[0].ColHidden("scg_cnt") = false;
	}
}

function loadInitialCombo() {
	var fmLoc = eval(document.form.search_fm_loc).value;
	if(fmLoc.length >= 5){
		getComboList(eval(document.form.search_fm_loc), document.search_fm_yard, 'F');
		getComboList(eval(document.form.search_via_loc), document.search_via_yard, 'V');
		getComboList(eval(document.form.search_door_loc), document.search_door_yard, 'D');
		getComboList(eval(document.form.search_to_loc), document.search_to_yard, 'T');
	}
}

/**
 * MouseMove 시 ToolTip 설정
 */
function sheet_main_OnMouseMove(sheetObj, Button, Shift, X, Y){
    
    with(sheetObj) {
    	sheetObj.ToolTipOption="balloon:false;width:410;backcolor:#ffffe0;forecolor:#0000ff;icon:0;";
    	var tip = "";
    	
		if (  ColSaveName(MouseCol) == "fm_nod_cd" || ColSaveName(MouseCol) == "via_nod_cd" || ColSaveName(MouseCol) == "dor_nod_cd" || ColSaveName(MouseCol) == "to_nod_cd") {
			tip += CellValue(MouseRow, ColSaveName(MouseCol) + "_nm");	
		}
		MouseToolTipText = tip;
	}
}