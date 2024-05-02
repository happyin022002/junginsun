
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0018.js
*@FileTitle : Other SO 생성화면 스크립트
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.20
*@LastModifier : 금병주
*@LastVersion : 1.1
* 2009-10-01 kimjin
* 1.0 최초 생성
* 
* ----------------------------------------------------------
* History
* 2011.08.31 유선오   1.1 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.10.19 유선오   1.2 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.10.25 유선오   1.3 [CHM-201112874] [TRS] OTHER/SO Creation 화면 상 오류 수정요청 
* 2011.10.25 이수진   1.4 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청
* 2012.01.20 금병주   1.5 [CHM-201215842] [TRS] Other S/O 상 Cost month 입력 Validation 추가
* 2012.08.06 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/


/**
 * @class ESD_TRS_0018 : OTHER SO Creation
 */
function ESD_TRS_0018() {
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

var initFlag = false;
var sheetObjects = new Array();
var sheetCnt = 0;
var ctMode = 0; //COST MODE, TRANS MODE 조합, 1-단일운송,DOOR제외, 2-복합운송,DOOR제외, 3-단일운송,DOOR, 4-복합운송,DOOR
var prefix = 'surcharge_';

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

			case "btn_reset":
				loadPage2();
				resetForm(formObject);
				break;

			case "btn_add":
				document.all.TRSP_SO_COST_MONTH.value = document.all.trsp_otr_cost_mon_dt.value.substring(2,6);
				loadPage2();
				if(!validateForm(sheetObject,formObject, IBINSERT )) {
					return false;
				}
					

				addSingleUnit();
				break;

			case 'btng_socreation':
				
				doActionIBSheet(sheetObject,formObject, IBSAVE);
				
				// S/O 생성 후 목록에서 사라진 뒤에도 W/O Preview 버튼 클릭으로 W/O issue가 가능하므로
				// 그 때 S/O의 Office 코드를 검증하기 위해 추가
				var soInfoSheetObj = sheetObjects[4];
				var cty_cd = soInfoSheetObj.CellValue(1, 'trsp_so_ofc_cty_cd');
				var seq_no = soInfoSheetObj.CellValue(1, 'trsp_so_seq');
				
				var trsp_so_no = cty_cd + seq_no;
		 
				formObject.trsp_so_no.value = trsp_so_no; // S/O의 Office 코드를 검증하기 위해 추가
				
				break;

			case 'btng_wopreview':
				gotoPreview(sheetObject,formObject);
				break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none"){
					document.all.MiniLayer.style.display = "none";
					sheetObject.style.height = 370;
				}
				else {
					document.all.MiniLayer.style.display = "";
					sheetObject.style.height = 240;
				}
				break;

			case "btng_provider":
				rep_OnPopupClick();
				break;
			
			case "btn_fm_node":
				openHireYardPopup('fm_node');
				break;

			case "btn_via_node":
				if(ctMode == 1 || ctMode == 3) return;
				openHireYardPopup('via_node');
				break;

			case "btn_to_node":
				openHireYardPopup('to_node');
				break;
			
			case "btn_dr_node":
				if(ctMode == 1 || ctMode == 2) return;
				openHireYardPopup('dr_node');
				break;

			case 'btn_act_cus':
				if(ctMode == 1 || ctMode == 2) return;
				popActualCustomer(sheetObject,formObject);
				break;
			
			case 'btng_fillineq':
				popEqFileImport(sheetObject, formObject);
				break;

			case 'btng_rateapply':
				getRateApply(sheetObject, formObject);
				break;

			case 'btng_commodity':
				popCommodity();
				break;

			case 'btng_customer':
				popCustomer();
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
	for(i=0;i<1;i++){
	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
//	IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
}
 
 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
function loadPage2() {
	if(initFlag){
		return;
	}
	for(i=1;i<sheetObjects.length;i++){
	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initFlag = true;
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
				style.height = 240;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(64, 4, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle1 = "STS||EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|SML/\nCNT|Cust\nCode|Cost\nMonth|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Distance|Distance|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Toll|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|SEN W/O|Reason|Nego Remark.|Rate Apply\nResult";
				var HeadTitle2 = "STS||EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|SML/\nCNT|Cust\nCode|Cost\nMonth|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Km|R.Link|Actual\nCustomer|Door Delivery\nAddress|Provider Code|Provider Name|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Toll|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|SEN W/O|Reason|Nego Remark.|Rate Apply\nResult";
				

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++,  dtCheckBox,   30,   daCenter,  true,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      			false,          "",      dfNone,      0,     true,       true,          11);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "eq_tpsz_cd",      		false,          "",      dfNone,      0,     false,       false,          4);

				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_bnd_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cgo_tp_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cntr_wgt",      		false,          "",      dfFloat,     0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "wgt_meas_ut_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd", false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      false,          "",      dfNone,      0,     false,       false,          2);

				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "cmdt_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				
				//InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_nomi_trkr_ind_cd",false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtCombo,	  50, 	daCenter,  true,    "cust_nomi_trkr_ind_cd",false,          "",      dfNone,      0,     false, 	  false,          4);
				
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_cnt_cd_seq",      false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_otr_cost_mon_dt", false,          "",      dfNone,      0,     false,       false,          4);
								
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      	false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "fm_yard_value",      	false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      	false,          "",      dfNone,      0,     false,       false,          5);

				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "via_yard_value",      	false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",      	false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "to_yard_value",      	false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      	false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "dr_yard_value",      	false,          "",      dfNone,      0,     false,       false,          2);
				
				//2012.06.12 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++,  dtData,  	  50, 	daRight,  true, 	"ttl_dist", 			false, 			"", 	 dfInteger,   0, 	 false, false);
				InitDataProperty(0, cnt++,  dtData,  	  50, 	daCenter, true, 	"lnk_dist_div_cd", 		false, 			"", 	 dfNone, 	  0, 	 false, false);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter, true,   	"act_cust_cnt_cd_seq",  false,          "",      dfNone,      0,     false,       false,          8);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter, true,   	"dor_de_addr",      	false,          "",      dfNone,      0,     false,       false,          200);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter, true,   	"vndr_seq",      		false,          "",      dfNone,      0,     false,       false,          6);
				InitDataProperty(0, cnt++ , dtData,       90,   daLeft,   true,   	"vndr_desc",      		false,          "",      dfNone,      0,     false,       false,          50);
				InitDataProperty(0, cnt++ , dtCombo,      90,   daCenter, true,    	"curr_cd",      		false,          "",      dfNone,      0,     true,       true,          3);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,  true,    	"bzc_amt",      		false,          "",      dfFloat,     2,    false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,  true,    	"nego_amt",      		false,          "",      dfFloat,     2,    true,       true,          13);

				InitDataProperty(0, cnt++ , dtData,       90,   daRight,  true,    	"fuel_scg_amt",      	false,          "",      dfFloat,     2,    false,       false,         13);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,  true,    	"toll_fee_amt",      	false,          "",      dfFloat,     2,    false,       false,         13);
				InitDataProperty(0, cnt++ , dtPopup,	  90,   daRight,  true,    	"etc_add_amt",      	false,          "",      dfFloat,     2,    true,       true,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,  true,    	"total_amt",      		false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|toll_fee_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,       100,   daCenter,true,    	"ref_bkg_no",      		false,          "",      dfNone,      2,     true,       true,          12);
//				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "ref_bkg_no_split",      false,          "",      dfNone,     2,     true,       true,          2);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      		false,          "",      dfNone,      0,     true,       true,          12);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "sen_wo_no",      		false,          "",      dfNone,      0,     true,       true,          12);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "trsp_purp_rsn",   		true,          "",       dfNone,      2,     true,       true,          1000);
				InitDataProperty(0, cnt++ , dtData,       90,   daLeft,    true,   	"nego_rmk",      		false,          "",      dfNone,      0,     true,       true,          1000);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "rate_apply",      		false,         "",       dfNone,      2,    false,       false,          10);
				InitDataProperty(0, cnt++,  dtSeq,		   0,   daCenter,  true,    "surcharge_key");
				InitDataProperty(0, cnt++,  dtSeq,		   0,   daCenter,  true,    "inv_xch_rt");
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_cnt_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_seq",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_rt_tp_cd",   false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_wy_tp_cd",   false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_ofc_cty_cd", false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_cnt_cd",      false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_addr_seq",    false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_nomi_trkr_flg",   false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fctry_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_phn_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_fax_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fm_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "to_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "via_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "dor_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "wtr_rcv_term_cd");  // 추가
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "wtr_de_term_cd");
						
//				InitDataValid (0, "eq_no", vtEngUpOther,"1234567890");
//				InitDataValid (0, "eq_tpsz_cd", vtEngUpOther,"1234567890");
//				formObject.InitDataValid (0, "cust_cnt_cd", vtEngUpOther,"1234567890");
//				formObject.InitDataValid (0, "cust_seq", vtEngUpOther,"1234567890");
			
				ColHidden('ibflag')				= true;
				ColHidden('surcharge_key')		= true;
				ColHidden('inv_xch_rt')			= true;

				InitDataCombo(0, 'curr_cd', " |"+default_currText, " |"+default_currCode);
				InitDataCombo(0, 'cust_nomi_trkr_ind_cd',    "SML|CNT|CPT|HPT",    "HJS|CNT|CPT|HPT");
				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
		   }
		   break;
		
		case 2:      //sheet1 init
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
				InitColumnInfo(57, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++,  dtCheckBox,   30,   daCenter,  true,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      				true,          	"",      dfNone,      0,     true,       true,          11);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "eq_tpsz_cd",      			false,          "",      dfNone,      0,     false,       false,          4);

				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_bnd_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cgo_tp_cd",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cntr_wgt",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "wgt_meas_ut_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd",     false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      	false,          "",      dfNone,      0,     false,       false,          2);

				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cmdt_cd",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_nomi_trkr_ind_cd",    false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_cnt_cd_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_otr_cost_mon_dt",     false,          "",      dfNone,      0,     false,       false,          4);
								
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "fm_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);

				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "via_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "to_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "dr_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "act_cust_cnt_cd_seq",      false,          "",      dfNone,      0,     false,       false,          8);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "dor_de_addr",      		false,          "",      dfNone,      0,     false,       false,          200);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_seq",      			false,          "",      dfNone,      0,     false,       false,          6);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_desc",      			false,          "",      dfNone,      0,     false,       false,          50);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "curr_cd",      			false,          "",      dfNone,      0,     false,       false,          3);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "bzc_amt",      			false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "nego_amt",      			false,          "",      dfFloat,     2,     false,       false,          13);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "fuel_scg_amt",      		false,          "",      dfFloat,     2,     false,       false,         13);
				InitDataProperty(0, cnt++ , dtData,		  90,   daCenter,  true,    "etc_add_amt",      		false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,		  90,   daCenter,  true,    "toll_fee_amt",      		false,          "",      dfFloat,     2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "total_amt",      			false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|toll_fee_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "ref_bkg_no",      			false,          "",      dfNone,      2,     true,        true,          12);
//				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "ref_bkg_no_split",      false,          "",      dfNone,      2,     true,       true,          2);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      			false,          "",      dfNone,      0,     true,        true,          12);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "trsp_purp_rsn",       		true,          "",      dfNone,       2,     true,        true,          1000);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "rate_apply",      			false,          "",      dfNone,      2,     false,       false,          10);
				InitDataProperty(0, cnt++,  dtHidden,	   0,    daCenter,  true,   "inv_xch_rt");
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_cnt_cd",     			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_seq",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_rt_tp_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_wy_tp_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_ofc_cty_cd",     false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_seq",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_cnt_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_seq",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_addr_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_nomi_trkr_flg",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fctry_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_phn_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_fax_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fm_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "to_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "via_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "dor_nod_cd");
				
		   }
		   break;

		   case 3:      //sheet1 init
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
				InitColumnInfo(58, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++,  dtCheckBox,   30,   daCenter,  true,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      				true,          	"",      dfNone,      0,     true,       true,          11);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "eq_tpsz_cd",      			false,          "",      dfNone,      0,     false,       false,          4);

				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_bnd_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cgo_tp_cd",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cntr_wgt",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "wgt_meas_ut_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd",     false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      	false,          "",      dfNone,      0,     false,       false,          2);

				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cmdt_cd",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_nomi_trkr_ind_cd",    false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cust_cnt_cd_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "trsp_otr_cost_mon_dt",     false,          "",      dfNone,      0,     false,       false,          4);
								
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "fm_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);

				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "via_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "to_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      		false,          "",      dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "dr_yard_value",      		false,          "",      dfNone,      0,     false,       false,          2);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "act_cust_cnt_cd_seq",      false,          "",      dfNone,      0,     false,       false,          8);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "dor_de_addr",      		false,          "",      dfNone,      0,     false,       false,          200);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_seq",      			false,          "",      dfNone,      0,     false,       false,          6);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_desc",      			false,          "",      dfNone,      0,     false,       false,          50);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "curr_cd",      			false,          "",      dfNone,      0,     false,       false,          3);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "bzc_amt",      			false,          "",      dfFloat,      2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "nego_amt",      			false,          "",      dfFloat,      2,     false,       false,          13);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "fuel_scg_amt",      		false,          "",      dfFloat,      2,     false,       false,         13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "toll_fee_amt",      		false,          "",      dfFloat,      2,     false,       false,         13);
				InitDataProperty(0, cnt++ , dtData,		  90,   daCenter,  true,    "etc_add_amt",      		false,          "",      dfFloat,      2,     false,       false,          13);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "total_amt",      			false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|toll_fee_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "ref_bkg_no",      			false,          "",      dfNone,      2,     true,       true,          12);
//				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "ref_bkg_no_split",      false,          "",      dfNone,      2,     true,       true,          2);

				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      			false,          "",      dfNone,      0,     true,       true,          12);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "trsp_purp_rsn",       		true,          "",       dfNone,      2,     true,       true,          1000);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "rate_apply",      			false,          "",      dfNone,      2,     false,       false,          10);
				InitDataProperty(0, cnt++,  dtHidden,	   0,   daCenter,  true,    "inv_xch_rt");
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_cnt_cd",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_seq",      			false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_rt_tp_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_wy_tp_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_ofc_cty_cd",     false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "trsp_agmt_seq",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_cnt_cd",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_seq",      		false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "act_cust_addr_seq",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     50,   daCenter,  true,    "cust_nomi_trkr_flg",      	false,          "",      dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fctry_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_nm");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_phn_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "cntc_pson_fax_no");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "fm_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "to_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "via_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "dor_nod_cd");
				
		   }
		   break;

		   case 4:      //sheet1 init
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(69, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "STS||unique_cd|Cost Mded|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;

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
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_step_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt'			    ,false,"",dfNone,0,true,true);
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
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'wo_grs_wgt_meas_ut_cd'  ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'ovr_wgt_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
//				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no_split'        ,false,"",dfNone,0,true,true);
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
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_grs_wgt_meas_ut_cd'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
//				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'	,false,"",dfNone,0,true,true);
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
		   }
			break;

			case 5:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				cnt = 0;
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable3.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(4, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "sts|svc_ord|seq";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,   150,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++,  dtData,		150,	daCenter,	false,  "trsp_so_ofc_cty_cd", 	false,  "", dfNone,		0,	false,  false,  20);
				InitDataProperty(0, cnt++ , dtData,     150,	daCenter,	false,  "trsp_so_seq", 			false,  "", dfNone,		0,	false,  false,  20);
				InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,  "vndr_seq",      		false,          "",      dfNone,      0,     false,       false,          6);
		   }
		   break;

		   case 6:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				cnt = 0;
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable3.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(23, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,   150,	daCenter,	false,	 "ibflag");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "inv_xch_rt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_trsp_agmt_ofc_cty_cd");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_trsp_agmt_seq");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_trsp_agmt_rt_tp_cd");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_way_type");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_trsp_agmt_rt_tp_nm");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_sp_type");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_cust_nomi_trkr_flg");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_cust_cnt_cd");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_cust_seq");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_cust_cnd_cd_seq");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_local_curr_cd");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_basic_rt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_fuel_scg_rt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_scg2_rt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_over_wgt_scg_rt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_local_curr_tot_amt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_usd_curr_tot_amt");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_rtn_cd");
				InitDataProperty(0, cnt++,  dtHidden,	  0,    daCenter,   false,   "po_rtn_msg");
				InitDataProperty(0, cnt++ , dtData,       30,   daCenter,   true,    "po_wtr_rcv_term_cd");  // 추가   
				InitDataProperty(0, cnt++ , dtData,       30,   daCenter,   true,    "po_wtr_de_term_cd");
		   }
		   break;
		   
		   case 7:      //상단 Actual Customer의 code 입력 자동 조회 기능을 위한 시트
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
					InitColumnInfo( 4, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

	                var HeadTitle = "Sts||Act Customer\nName|Address" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtStatus,	0,	daCenter,		false,    "ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,	daCenter,	false,    "ibcheck",			false,		"",		dfNone,		0,	true,	false	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,	false,    "fctry_nm",			false,		"",		dfNone,		0,	false,	false	);
					InitDataProperty(0, cnt++ , dtData,	 150,		daCenter,	false,    "fctry_addr",			false,		"",		dfNone,		0,	false,	false	);
					ColHidden('ibflag')			= true;
			   }
				break;
		   
	}
}

/**
 * W/O Preview로 이동하기
 */
function gotoPreview(sheetObj,formOb)
{
	var sheetObj1 = sheetObjects[4];

	if(sheetObj1.RowCount < 1){
		ComShowCodeMessage('TRS90110');
		return false;
	}

	if(!confirm(ComGetMsg('TRS90227',sheetObj1.RowCount))) {
				return false;
	}

	if(sheetObj1.RowCount > 0){
		var cty_cd = '';
		var seq_no = '';
		var vndr_seq = '';

		for(var i=1; i<sheetObj1.RowCount+1; i++)
		{
			if(i!=1){
				cty_cd += ',';
				seq_no += ',';
				vndr_seq += ',';
			}
			cty_cd += sheetObj1.CellValue(i, 'trsp_so_ofc_cty_cd');
			seq_no += sheetObj1.CellValue(i, 'trsp_so_seq');
			vndr_seq += sheetObj1.CellValue(i, 'vndr_seq');

			if(sheetObj1.CellValue(i, 'vndr_seq') == undefined || ComTrim(sheetObj1.CellValue(i, 'vndr_seq')) == ''){
				ComShowCodeMessage('TRS90099');
				return false;
			}
		}
		
		document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
		document.woForm.trsp_so_seq.value = seq_no;
		document.woForm.vndr_seq.value = vndr_seq;
		document.woForm.trsp_so_no.value = document.form.trsp_so_no.value;
		// W/O 컨펌 시 S/O와 ofc코드가 일치하는지 확인하기 위해 전송
		document.woForm.submit();
	}
	return;
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
		switch(sAction) {

		   case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_TRS_0018GS.do");
				break;

			case IBSAVE:        //저장
			  if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}

			  var sheetObj1 = sheetObjects[1];
				
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');
				
				for(var k=0; k<checkArray.length-1; k++)
				{
					var row = checkArray[k];
					if(sheetObj.CellValue(row, 'rate_apply') == ''){
						ComShowCodeMessage('COM12114', 'Rate Apply');
						sheetObj.SelectCell(row, 'rate_apply');
						return false;
					}
					
					// CHM-201536387 ALPS Auth 사후 결재 기능 개발
					if(!(sheetObj.CellValue(row, 'nego_amt') == 0 || sheetObj.CellValue(row, 'nego_amt') == '') && ComTrim(sheetObj.CellValue(row, 'nego_rmk')) == ''){
						ComShowCodeMessage('TRS90386', 'Please input Nego. Remark');
						sheetObj.SelectCell(row, "nego_rmk" );
						return false;
					}
				}
				
				if(checkArray.length<sheetObj.RowCount && !confirm('There are remaining S/O creation candidates.\nAre you sure to proceed?')) return false;
				
				addSurchargeData(); // 선택된 row의 fuel surcharge를 surcharge sheet에 추가한다.
				
				var surchargeQuery = '&'+sheetObjects[3].GetSaveString(true, false);
				sheetObj.RemoveEtcData();
				formObj.f_cmd.value = ADD;
				formObj.TRSP_SO_TP_CD.value = 'O';
				formObj.TRSP_SO_STS_CD.value = 'C'; //SO -C, WO - I

				var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
				var sheetObj2 = sheetObjects[4];
				sheetObj2.DoSearch4Post("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj)+surchargeQuery, '', true);
				break;

		  case IBDOWNEXCEL:    //엑셀 다운로드
			  sheetObj.Down2Excel(-1, false, false, true);

			  break;

		   case IBINSERT:      // 입력
				sheetObj.DataInsert();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
			case IBINSERT:      // add
				if(formObj.otherso_qty.value == '')
				{
					ComShowCodeMessage('COM12114', 'QTY');
					formObj.otherso_qty.focus();
					return false;
				}else if(formObj.trs_cost_md_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Cost Mode');
					formObj.trs_cost_md_cd.focus();
					return false;
				}else if(formObj.trs_md_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Trans Mode');
					formObj.trs_md_cd.focus();
					return false;
				}else if((formObj.trs_cost_md_cd.options[1].selected ||
					formObj.trs_cost_md_cd.options[2].selected ||
					formObj.trs_cost_md_cd.options[3].selected ||
					formObj.trs_cost_md_cd.options[4].selected)&&
					formObj.trs_bnd_cd.options[0].selected){
					ComShowCodeMessage('COM12114', 'Bound');
					formObj.trs_bnd_cd.focus();
					return false;
				}else if(formObj.trs_cago_tp_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Cargo Type');
					formObj.trs_cago_tp_cd.focus();
					return false;
				}else if(formObj.trs_cago_tp_cd.options[1].selected &&
					formObj.cntr_wgt.value == '')
				{
					ComShowCodeMessage('COM12114', 'Weight');
					formObj.cntr_wgt.focus();
					return false;
				}else if(formObj.trs_cago_tp_cd.options[1].selected &&
					formObj.trs_wgt_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Weight Unit');
					formObj.trs_wgt_cd.focus();
					return false;
				}else if(formObj.trs_cago_tp_cd.options[1].selected &&
					formObj.commodity_cd.value == '')
				{
					ComShowCodeMessage('COM12114', 'Commodity Code');
					popCommodity();
					return false;
				}else if(formObj.trs_cnt_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'SML/CNT');
					formObj.trs_cnt_cd.focus();
					return false;
				}else if((formObj.trs_cost_md_cd.value=='ER' || formObj.trs_cost_md_cd.value=='CN' || formObj.trs_cost_md_cd.value=='CF' ) &&
							formObj.trs_cnt_cd.value != 'HJS'){
					ComShowCodeMessage('COM12114', 'COST MODE AND SML/CNT');
					formObj.trs_cnt_cd.focus();
					return false;
				}else if(formObj.trs_cnt_cd.options[2].selected &&
					formObj.input_cust_cd.value == '')
				{
					ComShowCodeMessage('COM12114', 'Customer Code');
					popCustomer();
					return false;
				}else if(formObj.trsp_otr_cost_mon_dt.value.length != 6)
				{
					ComShowCodeMessage('COM12114', 'Cost Month');
					formObj.trsp_otr_cost_mon_dt.focus();
					return false;
				}else if(formObj.combo_svc_provider.value == '')
				{
					ComShowCodeMessage('COM12114', 'Service Provider');
					formObj.combo_svc_provider.focus();
					return false;
				}else if(formObj.search_fm_loc.value == '' || document.search_fm_yard.Code == '')
				{
					ComShowCodeMessage('COM12114', 'From');
					formObj.search_fm_loc.focus();
					return false;
				}else if(formObj.search_to_loc.value == '' || document.search_to_yard.Code == '')
				{
					ComShowCodeMessage('COM12114', 'To');
					formObj.search_to_loc.focus();
					return false;
				}else if(formObj.otherso_reason.value == '')
				{
					ComShowCodeMessage('COM12114', 'Reason');
					formObj.otherso_reason.focus();
					return false;
				}
	
			
				var fmNode  = formObj.search_fm_loc.value + document.search_fm_yard.Code;
				var viaNode = formObj.search_via_loc.value + document.search_via_yard.Code;
				var toNode = formObj.search_to_loc.value + document.search_to_yard.Code;
				var doorNode = formObj.search_dr_loc.value + document.search_dr_yard.Code;

				switch(ctMode)
				{
					case 1:
						if(fmNode == toNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And To yard');
							formObj.search_fm_loc.focus();
							return false;
						}
						break;

					case 2:
						if(formObj.search_via_loc.value == '' || document.search_via_yard.Code == '')
						{
							ComShowCodeMessage('COM12114', 'Via');
							formObj.search_via_loc.focus();
							return false;
						}else if(fmNode == toNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And To yard');
							formObj.search_fm_loc.focus();
							return false;
						}else if(fmNode == viaNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And Via yard');
							formObj.search_fm_loc.focus();
							return false;
						}else if(viaNode == toNode)
						{
							ComShowCodeMessage('COM12115', 'Via yard And To yard');
							formObj.search_via_loc.focus();
							return false;
						}
						break;
					case 3:
						if(formObj.search_dr_loc.value == '' || document.search_dr_yard.Code == '')
						{
							ComShowCodeMessage('COM12114', 'Door');
							formObj.search_dr_loc.focus();
							return false;
						}else if(formObj.act_cust_cd.value == '')
						{
							ComShowCodeMessage('COM12114', 'Actual Customer');
							formObj.act_cust_cd.focus();
							return false;
						}else if(formObj.door_delv_addr.value == '')
						{
							ComShowCodeMessage('COM12114', 'Door Delivery Address');
							formObj.door_delv_addr.focus();
							return false;
						}else if(fmNode == doorNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And Door yard');
							formObj.search_fm_loc.focus();
							return false;
						}else if(toNode == doorNode)
						{
							ComShowCodeMessage('COM12115', 'Door yard And To yard');
							formObj.search_dr_loc.focus();
							return false;
						}
						break;
					case 4:
						if(formObj.search_via_loc.value == '' || document.search_via_yard.Code == '')
						{
							ComShowCodeMessage('COM12114', 'Via');
							formObj.search_via_loc.focus();
							return false;
						}else if(formObj.search_dr_loc.value == '' || document.search_dr_yard.Code == '')
						{
							ComShowCodeMessage('COM12114', 'Door');
							formObj.search_dr_loc.focus();
							return false;
						}else if(formObj.act_cust_cd.value == '')
						{
							ComShowCodeMessage('COM12114', 'Actual Customer');
							formObj.act_cust_cd.focus();
							return false;
						}else if(formObj.door_delv_addr.value == '')
						{
							ComShowCodeMessage('COM12114', 'Door Delivery Address');
							formObj.door_delv_addr.focus();
							return false;
						}else if(fmNode == viaNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And Via yard');
							formObj.search_fm_loc.focus();
							return false;
						}else if(viaNode == toNode)
						{
							ComShowCodeMessage('COM12115', 'Via yard And To yard');
							formObj.search_via_loc.focus();
							return false;
						}else if(fmNode == doorNode)
						{
							ComShowCodeMessage('COM12115', 'From yard And Door yard');
							formObj.search_fm_loc.focus();
							return false;
						}else if(toNode == doorNode)
						{
							ComShowCodeMessage('COM12115', 'Door yard And To yard');
							formObj.search_dr_loc.focus();
							return false;
						}else if(viaNode == doorNode)
						{
							ComShowCodeMessage('COM12115', 'Via yard And Door yard');
							formObj.search_via_loc.focus();
							return false;
						}
						break;
				}
				break;

				case IBSAVE:
					var checkList = sheetObj.FindCheckedRow('ibcheck');
					var checkArray = checkList.split('|');
					for(var k=0; k<checkArray.length-1; k++)
					{
						var row = checkArray[k];
						var cost_cd = sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd');
/* 1달간 eq_no mandatory 항목에서 제외

						if(sheetObj.CellValue(row, 'eq_no').length < 1 ){
							ComShowCodeMessage('COM12114', 'EQ NO');
							sheetObj.SelectCell(row, 'eq_no');
							return false;
						}
*/
						if(sheetObj.CellValue(row, 'eq_tpsz_cd').length < 1 ){
							ComShowCodeMessage('COM12114', 'EQ Type size Code');
							sheetObj.SelectCell(row, 'eq_tpsz_cd');
							return false;
						}

						if(sheetObj.CellValue(row, 'vndr_seq') == undefined || ComTrim(sheetObj.CellValue(row, 'vndr_seq')) == '' ){
							ComShowCodeMessage('TRS90099');
							sheetObj.SelectCell(row, 'vndr_seq');
							return false;
						}else if(sheetObj.CellValue(row, 'curr_cd') == undefined || ComTrim(sheetObj.CellValue(row, 'curr_cd')) == '' ){
							ComShowCodeMessage('TRS90228');
							sheetObj.SelectCell(row, 'curr_cd');
							return false;
						}else if(sheetObj.CellValue(row, 'total_amt') == undefined || Number(sheetObj.CellValue(row, 'total_amt')) == 0 ){
							ComShowCodeMessage('TRS90222');
							sheetObj.SelectCell(row, 'total_amt');
							return false;
						}
						
						if(sheetObj.CellValue(row, 'eq_no').length < 1 && sheetObj.CellValue(row, 'eq_tpsz_cd').length > 1){
							ComShowCodeMessage('COM12114', 'EQ NO');
							sheetObj.SelectCell(row, 'eq_no');
							return false;
						}
					}
					if(formObj.trsp_otr_cost_mon_dt.value > formObj.chkYM.value){
						//현재 가져온 일시 보다 더 클 경우  warning 메시지 뿌려주고 값 초기화 하기 2012.01.20 kbj
						ComShowCodeMessage('TRS90412');
						formObj.trsp_otr_cost_mon_dt.value = ''
						formObj.trsp_otr_cost_mon_dt.focus();
						return false;
					} 
				break;
	}
	return true;
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
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}


/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	var yard_obj = null;
	var formObj = document.form;

	obj.value = obj.value.toUpperCase();

	if(obj.name == 'search_fm_loc'){
		yard_obj = document.search_fm_yard;
		if(formObj.trs_cost_md_cd.value == 'CN'){
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		}else if(formObj.trs_cost_md_cd.value == 'CF'){
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		}
	}else if(obj.name == 'search_via_loc'){
		yard_obj = document.search_via_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	}else if(obj.name == 'search_to_loc'){
		yard_obj = document.search_to_yard;
		if(formObj.trs_cost_md_cd.value == 'CN'){
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		}else if(formObj.trs_cost_md_cd.value == 'CF'){
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		}
	}else if(obj.name == 'search_dr_loc'){
		yard_obj = document.search_dr_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	}else{
		formObj.TRSP_SO_EQ_KIND.value = '';
	}

	var locValue = obj.value;

	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}

	if(obj.name == 'search_dr_loc') {
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}else{
		getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
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
			case 'search_fm_loc':
			case 'search_via_loc':
			case 'search_to_loc':
			case 'search_dr_loc':
				getComboList(obj);
				break;
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
			case 'commodity_cd':
				getTextCmdtCd(sheetObj, formObj, obj.value);
				break;
			case 'input_cust_cd':
				formObj.input_cust_cd.value  = formObj.input_cust_cd.value.toUpperCase();
				getTextCustCd(sheetObj, formObj, obj.value);
				break;
		}
	}
}

/**
* 공통 Node popup
*/
function openHireYardPopup( btn_obj )
{
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_061_1";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var returnFunction = 'setFmNode';
	if(btn_obj == 'via_node') returnFunction = 'setViaNode';
	else if(btn_obj == 'to_node') returnFunction = 'setToNode';
	else if(btn_obj == 'dr_node') returnFunction = 'setDoorNode';

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 423, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
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
* fmNode를 팝업을 통해 세팅
*/
function setFmNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_fm_loc.value = loc;
	getComboList(document.form.search_fm_loc);
	document.search_fm_yard.CODE = yard;
}

/**
* viaNode를 팝업을 통해 세팅
*/
function setViaNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_via_loc.value = loc;
	getComboList(document.form.search_via_loc);
	document.search_via_yard.CODE = yard;
}

/**
* toNode를 팝업을 통해 세팅
*/
function setToNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_to_loc.value = loc;
	getComboList(document.form.search_to_loc);
	document.search_to_yard.CODE = yard;
}

/**
* doorNode를 팝업을 통해 세팅
*/
function setDoorNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_dr_loc.value = loc;
	getComboList(document.form.search_dr_loc);
	document.search_dr_yard.CODE = yard;
}

/**
 * ADD버튼 클릭시 single 단위로 ADD하기
 **/
function addSingleUnit()
{
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	//2012.06.12 Distance 관련 추가 SHIN DONG IL 
	var fm_nod_cd	= formObj.search_fm_loc.value;
	var fm_nod_yard = document.search_fm_yard.Code;
	var to_nod_cd	= formObj.search_to_loc.value;
	var to_nod_yard = document.search_to_yard.Code;
	var dor_nod_cd = formObj.search_dr_loc.value; 
	var dor_nod_yard = document.search_dr_yard.Code;
	var via_nod_cd = formObj.search_via_loc.value;
	var via_nod_yard = document.search_via_yard.Code;
	var trsp_bnd_cd = formObj.trs_bnd_cd.value; // bound cd
	var trsp_crr_mod_cd = formObj.trs_md_cd.value; // trans mode
	var trsp_cost_dtl_mod_cd = formObj.trs_cost_md_cd.value; // cost mode


	if(trsp_cost_dtl_mod_cd=="DOOR"){
		trsp_cost_dtl_mod_cd="DR";
	}
	
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
 	 
 	var ttl_dist = sheetObj.EtcData("ttl_dist");
 	var lnk_dist_div_cd = sheetObj.EtcData("lnk_dist_div_cd");
	
	sheetObj.RemoveEtcData();
	//2012.06.12 Distance 관련 추가 SHIN DONG IL 	끝

	var row = 1;
	for(var i=0; i< formObj.otherso_qty.value; i++)
	{
		sheetObj.DataInsert(-1);
		row = sheetObj.RowCount+1;
		sheetObj.CellValue2(row, 'trsp_bnd_cd') = formObj.trs_bnd_cd.value; // bound cd
		sheetObj.CellValue2(row, 'cgo_tp_cd') = formObj.trs_cago_tp_cd.value; // cago type cd
		sheetObj.CellValue2(row, 'cntr_wgt') = formObj.cntr_wgt.value; // container weight
		sheetObj.CellValue2(row, 'wgt_meas_ut_cd') = formObj.trs_wgt_cd.value; // weight measure unit cd
		sheetObj.CellValue2(row, 'cmdt_cd') = formObj.commodity_cd.value; // commodity cd
		sheetObj.CellValue2(row, 'cust_nomi_trkr_ind_cd') = formObj.trs_cnt_cd.value; // cust nominate tracker flag
		//160322 CNT 세분화
		sheetObj.CellValue2(row, 'cust_nomi_trkr_flg') = (formObj.trs_cnt_cd.value=='HJS'?'N':'Y'); // cust nominate tracker flag
		sheetObj.CellValue2(row, 'cust_cnt_cd_seq') = formObj.input_cust_cd.value; // cust cnt cd seq
		sheetObj.CellValue2(row, 'cust_cnt_cd') = formObj.input_cust_cd.value.substring(0,2); // cust cnt cd
		sheetObj.CellValue2(row, 'cust_seq') = get_only_num(formObj.input_cust_cd.value); // cust seq
		sheetObj.CellValue2(row, 'trsp_otr_cost_mon_dt') = formObj.TRSP_SO_COST_MONTH.value; // cost month
		sheetObj.CellValue2(row, 'fctry_nm') = formObj.fctry_nm.value; // factory name
		sheetObj.CellValue2(row, 'cntc_pson_nm') = formObj.cntc_pson_nm.value; // container person name
		sheetObj.CellValue2(row, 'cntc_pson_phn_no') = formObj.cntc_pson_phn_no.value; // container person phone no
		sheetObj.CellValue2(row, 'cntc_pson_fax_no') = formObj.cntc_pson_fax_no.value; // container person fax no
		sheetObj.CellValue2(row, 'eq_knd_cd') = formObj.TRSP_EQ_KND_CD.value; // container person fax no

		sheetObj.CellValue2(row, 'trsp_cost_dtl_mod_cd') = formObj.trs_cost_md_cd.value; // cost mode
		sheetObj.CellValue2(row, 'trsp_crr_mod_cd') = formObj.trs_md_cd.value; // trans mode
		sheetObj.CellValue2(row, 'vndr_seq') = formObj.combo_svc_provider.value; // Service Provider code
		sheetObj.CellValue2(row, 'vndr_desc') = formObj.svc_provider.value; // Service Provider description
		if(formObj.trs_cost_md_cd.value=="ER"){
		    sheetObj.CellEditable(row,"ref_bkg_no")=false;
			sheetObj.CellEditable(row,"ref_bl_no")=false;
		}
		sheetObj.CellValue2(row, 'trsp_purp_rsn') = formObj.otherso_reason.value; // Reason
		sheetObj.CellValue2(row, 'fm_loc_value') = formObj.search_fm_loc.value; // from location
		sheetObj.CellValue2(row, 'fm_yard_value') = document.search_fm_yard.Code; // from yard
		sheetObj.CellValue2(row, 'fm_nod_cd') = formObj.search_fm_loc.value+document.search_fm_yard.Code;
		sheetObj.CellValue2(row, 'to_loc_value') = formObj.search_to_loc.value; // to location
		sheetObj.CellValue2(row, 'to_yard_value') = document.search_to_yard.Code; // to yard
		sheetObj.CellValue2(row, 'to_nod_cd') = formObj.search_to_loc.value+document.search_to_yard.Code;
		
		sheetObj.CellValue2(row, 'ttl_dist') = ttl_dist; // to yard
		sheetObj.CellValue2(row, 'lnk_dist_div_cd') = lnk_dist_div_cd;

		switch(ctMode)
		{
			case 2:
				sheetObj.CellValue2(row, 'via_loc_value') = formObj.search_via_loc.value; // via location
				sheetObj.CellValue2(row, 'via_yard_value') = document.search_via_yard.Code; // via yard
				sheetObj.CellValue2(row, 'via_nod_cd') = formObj.search_via_loc.value+document.search_via_yard.Code;
				break;
			case 3:
				sheetObj.CellValue2(row, 'dr_loc_value') = formObj.search_dr_loc.value; // door location
				sheetObj.CellValue2(row, 'dr_yard_value') = document.search_dr_yard.Code; // door yard
				sheetObj.CellValue2(row, 'dor_nod_cd') = formObj.search_dr_loc.value+document.search_dr_yard.Code;
				sheetObj.CellValue2(row, 'act_cust_cnt_cd_seq') = formObj.act_cust_cd.value; // Actual Customer
				sheetObj.CellValue2(row, 'act_cust_cnt_cd') = formObj.act_cust_cd.value.substring(0,2); // Actual Customer
				sheetObj.CellValue2(row, 'act_cust_seq') = get_only_num(formObj.act_cust_cd.value); // Actual Customer
				sheetObj.CellValue2(row, 'dor_de_addr') = formObj.door_delv_addr.value; // door delivery
				sheetObj.CellValue2(row, 'act_cust_addr_seq') = formObj.act_cust_addr_seq.value; // addr seq
				break;
			case 4:
				sheetObj.CellValue2(row, 'via_loc_value') = formObj.search_via_loc.value; // via location
				sheetObj.CellValue2(row, 'via_yard_value') = document.search_via_yard.Code; // via yard
				sheetObj.CellValue2(row, 'via_nod_cd') = formObj.search_via_loc.value+document.search_via_yard.Code;
				sheetObj.CellValue2(row, 'dr_loc_value') = formObj.search_dr_loc.value; // door location
				sheetObj.CellValue2(row, 'dr_yard_value') = document.search_dr_yard.Code; // door yard
				sheetObj.CellValue2(row, 'dor_nod_cd') = formObj.search_dr_loc.value+document.search_dr_yard.Code;
				sheetObj.CellValue2(row, 'act_cust_cnt_cd_seq') = formObj.act_cust_cd.value; // Actual Customer
				sheetObj.CellValue2(row, 'act_cust_cnt_cd') = formObj.act_cust_cd.value.substring(0,2); // Actual Customer
				sheetObj.CellValue2(row, 'act_cust_seq') = get_only_num(formObj.act_cust_cd.value); // Actual Customer
				sheetObj.CellValue2(row, 'dor_de_addr') = formObj.door_delv_addr.value; // door delivery
				sheetObj.CellValue2(row, 'act_cust_addr_seq') = formObj.act_cust_addr_seq.value; // addr seq
				break;
		}
	}
}

/**
 * Additional Amount를 클릭했을때 popup창을 띄워준다.
 **/
function sheet_OnPopupClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col);
	switch(colName) {
		case 'etc_add_amt':
			popSurchargeInputInquiry(sheetObj, row, col);
			break;
	}
}

/**
* 조회조건 reset
*/
function resetForm(formObj)
{
	formObj.reset();
	formObj.otherso_qty.value = '';
	formObj.trs_cost_md_cd.options[0].selected = true;
	formObj.trs_md_cd.options[0].selected = true;
	
	formObj.combo_svc_provider.value = '';
	formObj.svc_provider.value='';

	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	document.search_dr_yard.RemoveAll();

	formObj.act_cust_cd.value = '';
	formObj.search_act_cust.value = '';
	
	formObj.door_delv_addr.value = '';
	formObj.otherso_reason.value = '';
}

/**
* COST MODE, TRANS MODE 변경시 조회조건 reset
*/
function resetSearchCondition(selObj)
{
	var formObj = document.form;

	formObj.combo_svc_provider.value = '';
	formObj.svc_provider.value='';

	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	document.search_dr_yard.RemoveAll();

	formObj.act_cust_cd.value = '';
	formObj.search_act_cust.value = '';
	
	formObj.door_delv_addr.value = '';
	formObj.otherso_reason.value = '';

	var costMode = formObj.trs_cost_md_cd.value;
	var tranMode = formObj.trs_md_cd.value;

	//COST MODE에 따라 조회조건 활성/불활성화를 세팅하기 위한 네종류 조건 확인
	if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 1;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 2;
	else if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 3;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 4;
	
	setKindEnabled();	// 조회조건 활성/불활성화

	if(selObj.name == 'trs_cost_md_cd'){
		sheetObjects[0].RemoveAll(); // cost mode 변경시 쉬트 내용 모두 삭제
	}
	
	// EQ_KND_CD - U:CONTAINER, Z:CHASSIS, G:GENSET
	if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' )
	{
		document.form.TRSP_EQ_KND_CD.value = 'U';
	}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
		document.form.TRSP_EQ_KND_CD.value = 'Z';
	}else if(costMode=='GN' || costMode=='GF'){
		document.form.TRSP_EQ_KND_CD.value = 'G';
	}else{
		document.form.TRSP_EQ_KND_CD.value = '';
	}

	if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS')
	{
		document.form.trs_cago_tp_cd.value = 'F';
		document.form.trs_cnt_cd.value = '';
	}else if(costMode=='ER' || costMode=='CN' || costMode=='CF' )
	{
		document.form.trs_cago_tp_cd.value = 'M';
		document.form.trs_cnt_cd.value = 'HJS';
	}else
	{
		document.form.trs_cago_tp_cd.value = '';
		document.form.trs_cnt_cd.value = '';
	}
}

/**
 * COST MODE, TRANS MODE 선택에 따른 조회조건 enabled처리
 **/
function setKindEnabled()
{
	var sheetObj = sheetObjects[0];
	var obj = document.form;

	switch(ctMode)
	{
		case 1:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = true;
			document.search_via_yard.Enable = false;
			document.search_dr_yard.Enable = false;
			obj.act_cust_cd.disabled = true;
			obj.door_delv_addr.disabled = true;
			obj.search_act_cust.disabled = true;
			obj.btn_act_cus.style.visibility = "hidden";
			break;
		case 2:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = true;
			document.search_via_yard.Enable = true;
			document.search_dr_yard.Enable = false;
			obj.act_cust_cd.disabled = true;
			obj.door_delv_addr.disabled = true;
			obj.search_act_cust.disabled = true;
			obj.btn_act_cus.style.visibility = "hidden";
			break;
		case 3:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = false;
			document.search_via_yard.Enable = false;
			document.search_dr_yard.Enable = true;
			obj.act_cust_cd.disabled = false;
			obj.door_delv_addr.disabled = false;
			obj.search_act_cust.disabled = false;
			obj.btn_act_cus.style.visibility = "visible";
			break;
		case 4:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = false;
			document.search_via_yard.Enable = true;
			document.search_dr_yard.Enable = true;
			obj.act_cust_cd.disabled = false;
			obj.door_delv_addr.disabled = false;
			obj.search_act_cust.disabled = false;
			obj.btn_act_cus.style.visibility = "visible";
			break;
	}
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
 * file import popup
 **/
function popEqFileImport(sheetObject, formObject)
{
	if(sheetObject.RowCount == 0){ 
		ComShowCodeMessage('TRS90132');
		return false;
	}

	var myOption = "width=500,height=355,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0950.do';
//	myWin = window.open(url, "popEqFileImport", myOption);

    myWin = ComOpenWindow('ESD_TRS_0950.do', 'popEqFileImport', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:500px;dialogHeight:385px', true);

//	myWin.focus();
}

/**
 * file import popup으로부터 data 전송받기
 **/
function importEqNo(popSheetObj, obj)
{
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[2];
	var checkList = popSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var row = 0;
	var value = '';
	var costMode = document.form.trs_cost_md_cd.value;

	if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' )
	{
		document.form.f_cmd.value = SEARCH04;
	}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
		document.form.f_cmd.value = SEARCH05;
	}else if(costMode=='GN' || costMode=='GF'){
		document.form.f_cmd.value = SEARCH06;
	}

	var queryStr = popSheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr==''){
		return false;
	}

	sheetObj2.DoSearch4Post("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(document.form), '', false);
	
	for(var i=0; i<checkArray.length-1; i++){
		if(popSheetObj.CellValue(checkArray[i], 'verify_result') != 'OK'){
			var new_row = sheetObj2.DataInsert(-1);
			sheetObj2.CellValue2(new_row, 'eq_no') = popSheetObj.CellValue(checkArray[i], 'eq_no');
		}
	}

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=2; k<sheetObj.RowCount+2; k++)
	{
		if(sheetObj.CellValue(k, 'eq_no')=='') emptyEqArray[cnt++] = k;
	}

	cnt=0; // insert된 data의 갯수를 센다.
	var tempEqNo = '';

	var loopLength = Math.min(sheetObj2.RowCount ,emptyEqArray.length);

	for(var k=0; k<loopLength;k++)
	{
		sheetObj.CellValue2(emptyEqArray[k], 'eq_no')			= sheetObj2.CellValue(k+1, 'eq_no');
		sheetObj.CellValue2(emptyEqArray[k], 'eq_tpsz_cd')		= sheetObj2.CellValue(k+1, 'eq_tpsz_cd');
	}

//	obj.close();
}

/**
 * rate apply popup
 **/
function getRateApply(sheetObj, formObj){
	
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');

	var rateSheetObj = sheetObjects[5];
	formObj.f_cmd.value = SEARCH16;
	rateSheetObj.RemoveAll();
	var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
	rateSheetObj.DoSearch4Post("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj), '', false);
	var find_row = null;

	for(var i=0; i<checkArray.length-1; i++){
		find_row = rateSheetObj.FindText('inv_xch_rt', sheetObj.CellValue(checkArray[i], 'inv_xch_rt'));
		sheetObj.CellValue2(checkArray[i], 'trsp_agmt_ofc_cty_cd') = rateSheetObj.CellValue(find_row, "po_trsp_agmt_ofc_cty_cd");
		sheetObj.CellValue2(checkArray[i], 'trsp_agmt_seq') = rateSheetObj.CellValue(find_row, "po_trsp_agmt_seq");       
		sheetObj.CellValue2(checkArray[i], 'trsp_agmt_rt_tp_cd') = rateSheetObj.CellValue(find_row, "po_trsp_agmt_rt_tp_cd");  
		sheetObj.CellValue2(checkArray[i], 'trsp_agmt_wy_tp_cd') = rateSheetObj.CellValue(find_row, "po_way_type");            
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_trsp_agmt_rt_tp_nm");  
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_sp_type");             
		sheetObj.CellValue2(checkArray[i], 'cust_nomi_trkr_flg') = rateSheetObj.CellValue(find_row, "po_cust_nomi_trkr_flg");  
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_cust_cnt_cd");         
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_cust_seq");            
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_cust_cnd_cd_seq");     
		if (rateSheetObj.CellValue(find_row, "po_local_curr_cd") != '')
        {
            sheetObj.CellValue2(checkArray[i], 'curr_cd') = rateSheetObj.CellValue(find_row, "po_local_curr_cd");       
		}
        sheetObj.CellValue2(checkArray[i], 'bzc_amt') = rateSheetObj.CellValue(find_row, "po_basic_rt");            
		sheetObj.CellValue2(checkArray[i], 'fuel_scg_amt') = rateSheetObj.CellValue(find_row, "po_fuel_scg_rt");       
		sheetObj.CellValue2(checkArray[i], 'toll_fee_amt') = rateSheetObj.CellValue(find_row, "po_scg2_rt");
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_over_wgt_scg_rt");     
		sheetObj.CellValue2(checkArray[i], 'total_amt') = rateSheetObj.CellValue(find_row, "po_local_curr_tot_amt");  
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_usd_curr_tot_amt");    
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_rtn_cd");              
//		sheetObj.CellValue2(checkArray[i], '') = rateSheetObj.CellValue(find_row, "po_rtn_msg");
		
		sheetObj.CellValue2(checkArray[i], 'wtr_rcv_term_cd') = rateSheetObj.CellValue(find_row, "po_wtr_rcv_term_cd");
		sheetObj.CellValue2(checkArray[i], 'wtr_de_term_cd') = rateSheetObj.CellValue(find_row, "po_wtr_de_term_cd");
		
		if(rateSheetObj.CellValue(find_row, "po_local_curr_cd") == undefined || 
			ComTrim(rateSheetObj.CellValue(find_row, "po_local_curr_cd")) == '') {
			sheetObj.CellValue2(checkArray[i], 'rate_apply') = 'AGMT Not Found';
		}else{
			sheetObj.CellValue2(checkArray[i], 'rate_apply') = 'Y';
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;

	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet4_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;

	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == ADD){
			ComShowCodeMessage('TRS90107');
			sheetObjects[0].RemoveAll();
			sheetObjects[3].RemoveAll();
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet5_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;

	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH16){
			ComShowCodeMessage('COM12116', 'Rate Apply');
		}
	}
}


/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
*/
function sheet5_OnSaveEnd(sheetObj,errMsg){
	if(errMsg!=null && errMsg != ''){
		ComShowMessage(errMsg);
	}
}

/**
 * sheet click시 일어나는 이벤트
 **/
function sheet_OnClick(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	
	switch(colName){
		case 'eq_tpsz_cd':
			if(sheetObj.CellValue(row,'eq_no') == '' ||
				(sheetObj.CellValue(row,'eq_no') != '' && sheetObj.CellValue(row,'eq_tpsz_cd') == ''))
					sheetObj.CellEditable(row,'eq_tpsz_cd') = true;
			else if(sheetObj.CellValue(row,'eq_no') != '' && sheetObj.CellValue(row,'eq_tpsz_cd') != '')sheetObj.CellEditable(row,'eq_tpsz_cd') = false;
			break;
	}
}


function sheet_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;

	switch(colName)
	{
		case('eq_no'):
			var costMode = formObj.trs_cost_md_cd.value;
			if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' )
			{
				value = cntrCheckDigit(value);
				formObj.f_cmd.value = SEARCH10;
			}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
				formObj.f_cmd.value = SEARCH11;
			}else if(costMode=='GN' || costMode=='GF'){
				formObj.f_cmd.value = SEARCH12;
			}
			sheetObj.CellValue2(row, col) = value.toUpperCase();

			var urlStr = 'ibflag=R&eq_no='+value+'&row='+row+'&col=eq_tpsz_cd';

			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
			if (sheetObj.CellValue(row, colName) == ''){
				ComShowCodeMessage('TRS00412');
			}
			
			sheetObj.CellValue2(row, 'ibcheck')='1';
			
			break;

		case 'eq_tpsz_cd':
			sheetObj.RemoveEtcData();
			value = value.toUpperCase();
			var costMode = formObj.trs_cost_md_cd.value;

			if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' )
			{
				formObj.f_cmd.value = SEARCH14;
			}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
				formObj.f_cmd.value = SEARCH12;
			}else if(costMode=='GN' || costMode=='GF'){
				formObj.f_cmd.value = SEARCH13;
			}

			formObj.EQ_TPSZ_CD.value = value;

			sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj) , false );
			sheetObj.cellValue2(row, 'eq_tpsz_cd') = value;
			if (sheetObj.EtcData("eq_tpsz_cd") == undefined || sheetObj.EtcData("eq_tpsz_cd") == ''){
				ComShowCodeMessage('COM12114', 'Type size Code');
				sheetObj.CellValue2( row, col) = '';
				return;
			}
			break;

		case('etc_add_amt'):
			if(value== '' || Number(value)==0){
				var surcharge_sheetObj = sheetObjects[3];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');

				// 이전에 세팅됐던 값은 지워버린다.
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
				}
			}else{
				var surcharge_sheetObj = sheetObjects[3];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');
				var sum = 0;
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
						sum += Number(surcharge_sheetObj.CellValue(a, prefix+'scg_amt'));
				}

				if(sum != Number(deleteComma(value))){
					ComShowCodeMessage('COM12114', 'Additional Etc Amount');
					sheetObj.CellValue2(row, 'etc_add_amt') = 0;
					for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
					{
						if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
					}
				}
			}
			break;

//		case('ref_bkg_no'):
//			formObj.f_cmd.value = SEARCH13;	
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName;
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			break;
//		case('ref_bkg_no_split'):
//			formObj.f_cmd.value = SEARCH14;	
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName+'&bkg_no='+sheetObj.CellValue(row,'bkg_no');
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			break;
//		case('ref_bl_no'):
//			formObj.f_cmd.value = SEARCH15;
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName;
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			break;

		case('curr_cd'):
			if(value == 'JPY' || value == 'KRW') {
				setDecimalType(sheetObj, row);
			}else{
				setFloatingType(sheetObj, row);
			}
			break;
		
		case('fm_loc_value'):
		case('fm_yard_value'):
			sheetObj.CellValue2(row, 'fm_nod_cd') = sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
			break;
		case('to_loc_value'):
		case('to_yard_value'):
			sheetObj.CellValue2(row, 'to_nod_cd') = sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
			break;
		case('via_loc_value'):
		case('via_yard_value'):
			sheetObj.CellValue2(row, 'via_nod_cd') = sheetObj.CellValue(row, 'via_loc_value')+sheetObj.CellValue(row, 'via_yard_value');
			break;
		case('dor_loc_value'):
		case('dor_yard_value'):
			sheetObj.CellValue2(row, 'dor_nod_cd') = sheetObj.CellValue(row, 'dor_loc_value')+sheetObj.CellValue(row, 'dor_yard_value');
			break;
	}
}


/**
 * Actual Customer popup
 **/
function popActualCustomer(sheetObject, formObject)
{
	var myOption = "dialogWidth:800px; dialogHeight:506px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0914.screen';
	window.showModalDialog(url, window, myOption);
}

/**
 * Actual Customer popup으로부터 data 전송받기
 **/
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm)
{
	var formObj = document.form;
	
	formObj.act_cust_cd.value = act_cust_cd;
	formObj.search_act_cust.value = factory_nm;
	formObj.door_delv_addr.value = (factory_addr==undefined?'':factory_addr);
	formObj.act_cust_addr_seq.value = (act_cust_addr_seq==undefined?'':act_cust_addr_seq);
	winObj.close();
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col)
{ var surcharge_sheetObj = sheetObjects[3];
  var weightUnitParam = "";
  var agmt_flg = "N";
	//------------------- 부모창 시트의 SCOWAL항목의 무게 단위를 팝업창으로 로드 ----------------------
	var scg_row_cnt = surcharge_sheetObj.RowCount;
	for(i=1;i<=scg_row_cnt;i++){ //부모창의 surcharge_sheetObj의 모든 행에 대해 for문으로 돌리면서 
		var scg_unq_cd = surcharge_sheetObj.CellValue(i,prefix+'unique_cd');
		if(scg_unq_cd == row-1){ //부모창 시트의 unique_cd가 메인 시트에서 선택한 row의 값과 동일한 것을 찾고
			var scg_lgs_cd = surcharge_sheetObj.CellValue(i,prefix+'lgs_cost_cd');
			if(scg_lgs_cd=="SCOWAL"){ //그중 lgs_cost_cd 가 SCOWAL인 것을 찾아서
				weightUnitParam = surcharge_sheetObj.CellValue(i,prefix+'wo_grs_wgt_meas_ut_cd');
			}
		}
	}
	//----------------------------------------------------------------------			
	if(sheetObj.CellValue( row , "toll_fee_amt" )!=0){
		agmt_flg ="Y";
	} 
				
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'surcharge_key');
	url += '&open_mode=modify';
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&sheet_arr_no=3';
	url += '&agmt_flg='+agmt_flg;
	url += '&cgo_tp_cd='+sheetObj.CellValue(row, 'cgo_tp_cd');
	url += '&wo_grs_wgt_meas_ut_cd='+weightUnitParam; //시트의 무게 단위를 팝업창으로 전송
	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

/**
 * Surcharge Input Inquiry popup으로부터 data 전송받기
 **/
function setSurchargeInputInquiry(winObj, sheetObj, formObj, totalSum)
{
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;

	sheetObjects[0].CellValue(row, 'etc_add_amt') = totalSum;
	// 이전에 세팅됐던 값은 지워버린다.
	for(var a=sheetObjects[3].RowCount; a>0 ;a--)
	{
		if( sheetObjects[3].CellValue(a, prefix+'unique_cd') == unique_cd) sheetObjects[3].RowDelete(a, false);
	}
	var queryStr = sheetObj.GetSaveString(true, true);
	if(queryStr !=''){
		var url = '?prefix='+prefix;
		sheetObjects[3].DoSearch4Post("ESD_TRS_0969.screen"+url, queryStr,'', true);
	}
	winObj.close();
}


/**
 * main sheet에서 저장될 Fuel surcharge를 surcharge sheet에 추가한다.
 **/
function addSurchargeData()
{
	var mainSheetObj = sheetObjects[0];
	var surchargeSheetObj = sheetObjects[3];
	var checkList = mainSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	for(var k=0; k<checkArray.length-1; k++)
	{
		var main_row = checkArray[k];
		var fuelSurcharge = mainSheetObj.CellValue(main_row, 'fuel_scg_amt');
		var tollFeeSurcharge = mainSheetObj.CellValue(main_row, 'toll_fee_amt');
		var cgo_tp_cd = mainSheetObj.CellValue(main_row, 'cgo_tp_cd');
		if (cgo_tp_cd == 'F') cgo_tp_cd = 'C';
		else cgo_tp_cd = 'M';

		if(Number(fuelSurcharge) != 0){
			var surcharge_row = surchargeSheetObj.DataInsert(-1);
			var trans_md = mainSheetObj.CellValue(main_row, 'trsp_crr_mod_cd');
			
			//trans mode 는 6개의 코드만 사용한다.
			if(trans_md == 'RW') trans_md = 'WR';
			else if(trans_md == 'TW') trans_md = 'WT';
			else if(trans_md == 'TR') trans_md = 'RT';
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'unique_cd') = mainSheetObj.CellValue(main_row, 'surcharge_key');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'lgs_cost_cd') = 'S'+cgo_tp_cd+'FU'+trans_md;
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'scg_amt') = fuelSurcharge;
		}
		
		if(Number(tollFeeSurcharge) != 0){
			var surcharge_row = surchargeSheetObj.DataInsert(-1);
			
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_ofc_cty_cd') = mainSheetObj.CellValue(main_row, 'trsp_so_ofc_cty_cd');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_seq') = mainSheetObj.CellValue(main_row, 'trsp_so_seq');

			surchargeSheetObj.CellValue2(surcharge_row, prefix+'unique_cd') = mainSheetObj.CellValue(main_row, 'surcharge_key');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'lgs_cost_cd') = 'S'+cgo_tp_cd+'TLAL';
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'scg_amt') = mainSheetObj.CellValue(main_row, 'toll_fee_amt');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_agmt_bfr_extd_flg') = "Y";
		}
	}
}

/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
*/
function sheet_OnSaveEnd(sheetObj,errMsg){
	if(errMsg!=null && errMsg != ''){
		ComShowMessage(errMsg);
	}
}

//'포커스주기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

function removeBar(str) {
    var value = "";
    for ( var i = 0; i < str.length; i++ ) {
    var ch = str.charAt(i);
    if ( ch != '-' ) value = value + ch;
    }
    return value;
}

// commodity popup
function popCommodity(){
	ComOpenPopup('/hanjin/COM_ENS_011.do', 772, 413, 'setCommodity', '1,0,1,1,1,1,1,1,1,1,1,1');
}

// commodity code 가져오기
function setCommodity(rowArray) {
	var formObj = document.form;

	if(rowArray.length>0)
	{
		formObj.commodity_cd.value = rowArray[0][3];
		formObj.commodity_nm.value = rowArray[0][4];
	}

}

/**
 * customer popup
 */
function popCustomer(){
	ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 415, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * customer 팝업에서 값 가져오기
 */
function setCustomerPop(rowArray){
	var formObj = document.form;
	var colArray = '';
	
	if(rowArray.length>0)
	{
		formObj.input_cust_cd.value = rowArray[0][3];
		formObj.input_cust_nm.value = rowArray[0][4];
	}
	// cust_cnt_cd : formObj.input_cust_cd.value.substring(0,2);
	// cust_seq : get_only_num(formObj.input_cust_cd.value);
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
 * Customer Code 입력 이벤트 처리
 */
function setCntCombo(obj){
	var formObj = document.form;
	if(obj.value == ''){
		formObj.input_cust_nm.value = '';
		formObj.trs_cnt_cd.options[1].selected = true;
	}else{
		formObj.trs_cnt_cd.options[2].selected = true;
	}
}

/**
 * Cost Month 입력 이벤트 처리
 */
function checkCostMonth(obj){
	obj.value = get_only_num(obj.value);
	if(obj.value.length != 4){
		ComShowCodeMessage('COM12114', 'Month');
		obj.focus();
		return;
	}else if(isNaN(Number(obj.value.substring(2,4)))) {
		ComShowCodeMessage('COM12114', 'Month');
		obj.focus();
		return;
	}else if(Number(obj.value.substring(2,4)) > 12) {
		ComShowCodeMessage('COM12114', 'Month');
		obj.focus();
		return;
	}else if(Number(obj.value.substring(2,4)) < 1) {
		ComShowCodeMessage('COM12114', 'Month');
		obj.focus();
		return;
	}
}

/**
 * 조회조건 reset
 */
function setDecimalType(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'total_amt', dtNull, daNull, 'total_amt', '|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|', dfInteger, 0);

	sheetObj.CellValue2(row, 'bzc_amt')					=  chkAmtPos_JPY(sheetObj.CellValue(row, 'bzc_amt'));     
	sheetObj.CellValue2(row, 'nego_amt')				=  chkAmtPos_JPY(sheetObj.CellValue(row, 'nego_amt'));    
	sheetObj.CellValue2(row, 'fuel_scg_amt')			=  chkAmtPos_JPY(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')				=  chkAmtPos_JPY(sheetObj.CellValue(row, 'etc_add_amt')); 
	sheetObj.CellValue2(row, 'total_amt')				=  chkAmtPos_JPY(sheetObj.CellValue(row, 'total_amt'));   

	var surcharge_sheetObj = sheetObjects[3];
	var sur_key = sheetObj.CellValue(row, 'surcharge_key');

	for(var i=1; i<surcharge_sheetObj.RowCount+1; i++){
		if(sur_key == surcharge_sheetObj.CellValue(i, prefix+'unique_cd')){
			
			surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt', dtNull, daNull, prefix+'scg_amt', '', dfInteger, 0);
			surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt', dtNull, daNull, prefix+'n3pty_amt', '', dfInteger, 0);
			
			surcharge_sheetObj.CellValue2(i, prefix+'scg_amt')		= chkAmtPos_JPY(surcharge_sheetObj.CellValue(i, prefix+'scg_amt'));
			surcharge_sheetObj.CellValue2(i, prefix+'n3pty_amt')	= chkAmtPos_JPY(surcharge_sheetObj.CellValue(i, prefix+'n3pty_amt'));
			
		}
	}
}

/**
 * 조회조건 reset
 */
function setFloatingType(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'total_amt', dtNull, daNull, 'total_amt', '|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|', dfFloat, 2);

	sheetObj.CellValue2(row, 'bzc_amt')					= chkAmtPos(sheetObj.CellValue(row, 'bzc_amt'));
	sheetObj.CellValue2(row, 'nego_amt')				= chkAmtPos(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'fuel_scg_amt')			= chkAmtPos(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')				= chkAmtPos(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'total_amt')				= chkAmtPos(sheetObj.CellValue(row, 'total_amt'));

	var surcharge_sheetObj = sheetObjects[3];
	var sur_key = sheetObj.CellValue(row, 'surcharge_key');

	for(var i=1; i<surcharge_sheetObj.RowCount+1; i++){
		if(sur_key == surcharge_sheetObj.CellValue(i, prefix+'unique_cd')){
			
			surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt', dtNull, daNull, prefix+'scg_amt', '', dfFloat, 2);
			surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt', dtNull, daNull, prefix+'n3pty_amt', '', dfFloat, 2);
			
			surcharge_sheetObj.CellValue2(i, prefix+'scg_amt')		= chkAmtPos(surcharge_sheetObj.CellValue(i, prefix+'scg_amt'));
			surcharge_sheetObj.CellValue2(i, prefix+'n3pty_amt')	= chkAmtPos(surcharge_sheetObj.CellValue(i, prefix+'n3pty_amt'));
			
		}
	}
}


function sheet_OnSelectMenu(sheetObj, MenuString){

	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}

function BlurDate(obj){
   if (obj.value == ""){
	   return;
   }

   if ( !ComIsDate(obj,"ym") ){
		errMsg = ComGetMsg("TRS90376");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	}
}


