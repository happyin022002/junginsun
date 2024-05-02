/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : ESM_SPC_0090.js
*@FileTitle : SPACE MANAGEMENT PLAN (NEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.19 송민석
* 1.0 Creation
* 
* History
* 2018.03.19 송민석 [CSR #3462] 기존 H/O, RHQ, L/OFC 3단계로 진행 되던 업무를 H/O에서 통합 관리하도록 수정함 이에 ESM_SPC_0090을 copy해서 새로운 화면으로 만듬
* 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=90;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_SPC_0090 : ESM_SPC_0090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0090() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var comObjects   = new Array();
var sheetCnt     = 0;
var comboCnt     = 0;
var tmpRhqView = "N";

var backValue = "";
var editColor = null;
var hoColor = null;

var spc01 = null;
var spc08 = null;
var spc09 = null;
var serchTrdCd = null;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

//		case "btn_new":			
//			clearAll();
//			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_downexcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		case "btn_sub_trd_add":
			var acctCd = formObject.acct_cd.Code;
			acctCd = acctCd.replace(/,/gi,"");
			//실적이 아예 없는 화주일경우
			if(sheetObject.RowCount == 0){
				//한개의 Account만 선택했는지 체크. 한개만 선택했을 경우 length == 8
				if(acctCd.length == 8){
					//해당 Account정보를 가져온 후 Row를 깔아줌.
					doActionIBSheet(sheetObject, formObject, MULTI05);
					handlingSubTrdScAdd(sheetObject);
					sheetObject.RowDelete(sheetObject.HeaderRows, false);
					sheetObject.SelectCell(sheetObject.HeaderRows ,"sub_trd_cd");

				}else{
			    	ComShowMessage(getMsg("SPC90309"));
				}
			//기존 실적에서 Sub Trade 추가하는 경우	
			}else if(sheetObject.RowCount > 0){
				handlingSubTrdAdd(sheetObject);
			}
			break;
			
		case "btn_ofc_lane_add":
		case "btn_ofc_lane_add2":
			if(sheetObject.RowCount>0){
				handlingAdd(sheetObject,srcName);
			}
			break;
			
		case "btn_ofc_lane_del":
		case "btn_ofc_lane_del2":

			if(sheetObject.RowCount>0){
				handlingDel(sheetObject,srcName);
			}
			break;
		
		case "btn_reuse":
			if(sheetObject.RowCount>0){
				handlingReuse(sheetObject);
			}
			break;
			
		case "btn_creation":
			creationData();
			break;
        case "btn_copy":
            copyData();
            break;
			
		case "btn_regeneration":
			regenerationData();
			break;
		
		case "btn_import":
			var trade = formObject.trade.Code;
			var season = formObject.season.Code;
			var version = formObject.version.Code;
			if(trade == "" || season == "" || version == ""){
				ComShowMessage("Please Choose Trade, Season and Version first.");
				return;
			}
			
			var onlyRead = "Y";
			
			if((spc01 == "Y" || spc08 == "Y")
				&& document.form.version.Index == document.form.version.GetCount()-1){
				onlyRead = "N";
			}
			var param = "trade="+trade+"&cost_yrwk="+season+"&ver_seq="+version+"&only_read="+onlyRead+"&pop_yn=Y";
			
			var popup = window.showModalDialog(
							"ESM_SPC_0095.do?"+param,
							null,
							"dialogHeight:650px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
			
			if(popup!="" && popup!=undefined){		//new version
				if(formObject.version.Code != popup){
//					var rtn = getCodeList("Season", "trade="+formObject.trade.Code);
//					initData_season(rtn[0].split("|"), rtn[1].split("|"));
					initData_season();
					
				}
			}
			break;
			
		case "btn_amend":
			amendPopup();
			break;
			
		case "btn_season_grp":
			yieldGrpPopup();
			break;
			
		case "btn_confirm":
			confirmData();
			break;

		case "btn_rhq_add":
			handlingRHQAdd(sheetObject);
			break;
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e);
		}
	}
}



/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setComboObject(combo_obj) {
	comObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	SpcSearchOptionTrade("trade", false, false);
	SpcSearchOptionComCode("unit", "CD00897", false);
//	SpcSearchOptionAcctClss("acct_clss", false);
	
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	ComBtnDisable("btn_regeneration");
	ComBtnDisable("btn_confirm");
	ComBtnDisable("btn_import");
	ComBtnDisable("btn_amend");
	ComBtnDisable("btn_season_grp");
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_ofc_lane_add");
	ComBtnDisable("btn_ofc_lane_del");
	ComBtnDisable("btn_ofc_lane_add2");
	ComBtnDisable("btn_ofc_lane_del2");
	ComBtnDisable("btn_sub_trd_add");
	
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, SEARCHLIST02); //권한 조회
	
	formObj.trade.Code = "TPS";

	editColor = sheetObjects[0].RgbColor(255,255,153); //yellow
	hoColor = sheetObjects[0].RgbColor(255,100,100) //red
	
	if(spc01=="Y"){ //SPC01
		ComBtnEnable("btn_creation");
		ComBtnEnable("btn_regeneration");
	}else{ //최신season, 최신version
		ComBtnDisable("btn_creation");
//		formObj.season.Enable = false;
//		formObj.version.Enable = false;
	}

}



function initControl() {
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerForm('click', 'obj_click', form);
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init		
		initSheet1(sheetObj);
		break;
	}
}

/**
 * sheet1에서 조회후 타이틀 변경
 */
var sheet1 = new Object();
function initSheet1(sheetObj) {
	
	with (sheetObj) {
		// 높이 설정
		style.height = 400;//getSheetHeight(17);
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 9, 100);
		
		//var view_type = getRadioValue(document.form.view_type);
		var HeadTitle = "ACCT\nClass|ACCOUNT\n(Group)|ACCOUNT\n(Individual)|C.OFC|SC#|RFA#|MVC|Yield\nGroup";
		
		HeadTitle = HeadTitle + "|SUB\nTRADE|RHQ|PFMC\nAVG(1)|PFMC\nAVG|RHQ Load\nGuide|L.OFC";
		
		var unit = document.form.unit.value;
		//송민석
		//if(view_type == "H") {
		//  HeadTitle = HeadTitle + "|PFMC\nOFC(1)|PFMC\nOFC(2)|Ratio|Pro ratio(%)\nGuide|L.OFC Load\nGuide|Del|CMPB\n(PFMC)|cust_cnt_cd|cust_seq|trd_cd|rlane|strd_flg|strd_flg2|rhq_ho|ofc_ho|ibflag|real_Ibflag|cust_adj_qty_upd_flg|delt_flg|SC_RFA_FLG|g1_cng_usr|g2_cng_usr";
		//} else {
			HeadTitle = HeadTitle + "|L.OFC Load\nGuide|LANE|L.QTA|PFMC\nLANE(1)|PFMC\nLANE|Ratio|Pro ratio(%)\nGuide|Lane Load\nGuide|Del|CMPB\n(PFMC)|REMARK|cust_cnt_cd|cust_seq|trd_cd|ibflag|real_Ibflag|cust_adj_qty_upd_flg|delt_flg|SC_RFA_FLG|lane_ho|o_add|r_rmk|rev_lane_cust_cnt|org_rlane_cd";
		//}
			
		//송민석
		//if(view_type == "R"){
			HeadTitle = HeadTitle + "|g1_cng_usr|g2_cng_usr|g3_cng_usr|cng_ofc_list";
		//}else if(view_type == "L"){
		//	HeadTitle = HeadTitle + "|org_REMARK|g3_cng_usr|cng_ofc_list";
		//}
		var colnum = 37;
		//송민석
		//if(view_type == "R") colnum = colnum + 4; 
		//if(view_type == "L") colnum = colnum + 5;
		//송민석
		colnum = colnum + 6;
		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(colnum, 0, 0, false);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false);
		
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		var cnt = 0;
		
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		
		InitDataProperty(0, cnt++, dtData, 50, 	daCenter, 	true, "acct_clss_cd"   ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, 	true, "cust_grp_nm"    ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, 	true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50,  daCenter, 	true, "ctrt_ofc_cd"    ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 65,  daCenter, 	true, "sc_no"          ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80,  daCenter, 	true, "rfa_no"         ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40,  daCenter, 	true, "wk_mqc_qty"     ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 45,  daCenter, 	true, "cust_ctrl_cd"   ,	false, "", dfNone, 0, false, false);
		
		InitDataProperty(0, cnt++, dtData, 50,  daCenter, true, "sub_trd_cd"     ,	false, "", dfNone, 2, false, false);
		InitDataProperty(0, cnt++, dtData, 60,  daCenter, true, "sls_rhq_cd"     ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 60,  daCenter, true, "cust_qty"       ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 60,  daCenter, true, "smpl_cust_qty"  ,	false, "", dfNone, 0, false, false);
//송민석
//		if(view_type == "H") {
//			if(unit == "T"){
//				InitDataProperty(0, cnt++, dtData, 70,  daCenter, true, "cust_adj_qty"   ,	false, "", dfInteger, 0, true , false);
//			}else{
//				InitDataProperty(0, cnt++, dtData, 70,  daCenter, true, "cust_adj_qty"   ,	false, "", dfFloat, 1, true , false);
//			}
//		}else{
//			InitDataProperty(0, cnt++, dtData, 700,  daCenter, true, "cust_adj_qty"   ,	false, "", dfNone, 0, false , false);
//		}
			
      if(unit == "T"){
          InitDataProperty(0, cnt++, dtData, 70,  daCenter, true, "cust_adj_qty"   ,  false, "", dfInteger, 0, true , false);
      }else{
          InitDataProperty(0, cnt++, dtData, 70,  daCenter, true, "cust_adj_qty"   ,  false, "", dfFloat, 1, true , false);
      }			
			
		InitDataProperty(0, cnt++, dtData, 60,  daCenter, true, "sls_rgn_ofc_cd" ,	false, "", dfNone, 0, false, false);
		
//송민석		
//		if(view_type == "H") {
//			InitDataProperty(0, cnt++, dtData,   70,  daCenter, true, "strd_qty"       ,	false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtData,   70,  daCenter, true, "smpl_strd_qty"  ,	false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, true, "strd_pfmc_ratio",	false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtData,   80,  daCenter, true, "strd_pfmc_wt"   ,	false, "", dfNone, 0, false, false);
//			if(unit == "T"){
//				InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "strd_adj_qty"   ,	false, "", dfInteger, 0, true , false);
//			}else{
//				InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "strd_adj_qty"   ,	false, "", dfFloat, 1, true , false);
//			}
//		} else {
			//InitDataProperty(0, cnt++, dtData, 	 70, daCenter, true, "strd_adj_qty"    ,	false, "", dfNone, 0, false , false);
		
          if(unit == "T"){
              InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "strd_adj_qty"   , false, "", dfInteger, 0, true , false);
          }else{
              InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "strd_adj_qty"   , false, "", dfFloat, 1, true , false);
          }		
			InitDataProperty(0, cnt++, dtData,   60, daCenter, true, "rlane_cd"        ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,   50, daCenter, true, "load_qta"        ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true, "rlane_qty"       ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "smpl_rlane_qty"  ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rlane_pfmc_ratio",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,   80, daCenter, true, "rlane_pfmc_wt"   ,	false, "", dfNone, 0, false, false);
//			if(view_type == "R"){
				if(unit == "T"){
					InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "rlane_adj_qty"   ,	false, "", dfInteger, 0, true , false);
				}else{
					InitDataProperty(0, cnt++, dtData,   70, daCenter, true, "rlane_adj_qty"   ,	false, "", dfFloat, 1, true , false);
				}
//			}else if(view_type == "L"){
//				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "rlane_adj_qty"   ,	false, "", dfNone, 0, false, false);
//			}
		//}
		
		//송민석
		//if(view_type != "L" && document.form.incl_del.checked != true) {
		if( document.form.incl_del.checked != true) {
			InitDataProperty(0, cnt++, dtDelCheck, 40, daCenter, true, "del",	false, "", dfNone, 0, true, false);
		} else {
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "del",	false, "", dfNone, 0, true, false);
		}	
		//송민석
//		if(view_type == "H") {
//			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "strd_cmpb" ,	false, "", dfNone, 0, false, false);
//		} else {
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rlane_cmpb",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "spc_ctrl_mdl_rmk",	false, "", dfNone, 0, false, false);
//		}
		
		//저장을 위해 필요한 값
		InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cust_cnt_cd",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cust_seq",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "trd_cd",	false, "", dfNone, 0, false, false);
		//송민석
//		if(view_type == "H") {
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rlane_cd",	false, "", dfNone, 0, false, false);//HO에서의 대표 LANE
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "strd_flag",	false, "", dfNone, 0, false, false);//REV_LANE 테이블에 기존재하는지 여부. Y가 기존재
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "strd_flag2",	false, "", dfNone, 0, false, false);//REV_LANE 테이블에 기존재하는지 여부. Y가 기존재
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rhq_ho",	false, "", dfNone, 0, false, false);//최근 유의미한 수정을 한 사람이 본사소속인지의 여부
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "ofc_ho",	false, "", dfNone, 0, false, false);//최근 유의미한 수정을 한 사람이 본사소속인지의 여부
//		}
		InitDataProperty(0, cnt++, dtHiddenStatus, 50, 	daCenter, 	true, "ibflag");
		InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, "real_ibflag");
		InitDataProperty(0, cnt++, dtHidden, 50, 	daCenter, 	true, "cust_adj_qty_upd_flg");
		InitDataProperty(0, cnt++, dtHidden, 50, 	daCenter, 	true, "delt_flg");
		InitDataProperty(0, cnt++, dtHidden, 10, 	daCenter, 	true, "sc_rfa_flg");
		
		//송민석
		//if(view_type != "H"){
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, "lane_ho",	false, "", dfNone, 0, false, false);//최근 유의미한 수정을 한 사람이 본사소속인지의 여부
			InitDataProperty(0, cnt++, dtHidden, 30, 	daCenter, 	true, "o_add");
			InitDataProperty(0, cnt++, dtHidden, 30, 	daCenter, 	true, "r_rmk");
			InitDataProperty(0, cnt++, dtHidden, 30, 	daCenter, 	true, "rev_lane_cust_cnt");
			InitDataProperty(0, cnt++, dtHidden, 30, 	daCenter, 	true, "org_rlane_cd");
		//}
		//if(view_type == "L"){
		//	InitDataProperty(0, cnt++, dtHidden, 30, 	daCenter, 	true, "org_spc_ctrl_mdl_rmk");
		//}
		
		//history 및 guide 변경자의 소속 구분을 위해 추가. 2013.03.21
		//송민석
//		if(view_type == "H") {
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "g1_cng_usr",	false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "g2_cng_usr",	false, "", dfNone, 0, false, false);
//		}else{
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "g1_cng_usr",  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "g2_cng_usr",  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "g3_cng_usr",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cng_ofc_list",	false, "", dfNone, 0, false, false);
		//}
		InitDataValid(0, "sub_trd_cd", vtEngUpOther, "0123456789");
		InitDataValid(0, "sls_rhq_cd", vtEngUpOther, "0123456789");
		InitDataValid(0, "sls_rgn_ofc_cd", vtEngUpOther, "0123456789");
		//송민석
		//if(view_type == "R") {
			InitDataValid(0, "rlane_cd", vtEngUpOther, "0123456789");
		//}
		HeadRowHeight = 40;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, quite) {
	if (quite == undefined)
		quite = false;
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		
		var param = SpcFormString(formObj, 'ALL');
		
		serchTrdCd = ComGetObjValue(formObj.trade);
		
		var rtn = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + (SEARCHLIST01) + "&" + param);
		
		sheetObj.Reset();
		initSheet1(sheetObj, false);
		sheetObj.LoadSearchXml(rtn);
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
	
		formObj.f_cmd.value = MULTI;
		var SaveStr = ComGetSaveString(sheetObj, true, true);
		if(SaveStr == undefined || SaveStr.length <= 0 ) return;
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_SPC_0090GS.do", SaveStr + "&" + FormQueryString(formObj));
		
//		var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//		
//		if (backendJobKey != null && backendJobKey.length > 0) {
//			ComSetObjValue(formObj.backendjob_key, backendJobKey);
//			sheetObjects[0].RequestTimeOut = 3600; //초 - 1시간
//			backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
//		}
		
		sheetObj.LoadSaveXml(sXml);
		ComOpenWait(false);
		if(document.getElementById("sts").value == "Confirmed"){
			var trade = document.form.trade.Code;
			clearAll();
			document.form.trade.Code = trade;
		}else{
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.Down2Excel(-1, false, false, true);
		break;
		
	case SEARCH03: // 해당 season 의 실적 기준 - from, to, duration 조회
	               // 가장 최근 Confirm된 version의 적용주차(from,to) 도 함께 조회 : 새로운 version 을 컨펌할 때 입력 편하도록 보여줌
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value = SEARCH03;
		var param = SpcFormString(formObj, 'f_cmd,trade,season,version');
		
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", param);
		var from = ComGetEtcData(sXml, "from");
		var to = ComGetEtcData(sXml, "to");
		var cfmVerPeriod = ComGetEtcData(sXml, "cfm_ver_period");
		var duration = ComGetEtcData(sXml, "duration");
		if(from!=undefined && to!=undefined && duration!=undefined){
			formObj.perf_st_yrwk.value = from;
			formObj.perf_end_yrwk.value = to;
			formObj.duration.value = duration;
		}
		if(cfmVerPeriod!=undefined && cfmVerPeriod!=""){
			formObj.cfm_ver_prd_from.value = cfmVerPeriod.split("|")[0];
			formObj.cfm_ver_prd_to.value = cfmVerPeriod.split("|")[1];
		}else{
			formObj.cfm_ver_prd_from.value = "";
			formObj.cfm_ver_prd_to.value = "";
		}
		break;
		
	case SEARCHLIST02: // OFC KND, LVL, 권한 조회

		var rtn = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + SEARCHLIST02);
		spc01 = ComGetEtcData(rtn,"spc01");
		spc08 = ComGetEtcData(rtn,"spc08");
		spc09 = ComGetEtcData(rtn,"spc09");
		break;
		
	case SEARCH05:
		
		var param = "cost_yrwk=" + ComGetObjValue(formObj.season)
		          + "&ver_seq="  + ComGetObjValue(formObj.version)
                  + "&trade="    + ComGetObjValue(formObj.trade);
		
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", "f_cmd=" + (SEARCH05) + "&" + param);
		var chk = ComGetEtcData(sXml, "chk");
		
		if ( chk == "N" ) {
			// Amend 할 S/C, RFA 없음
			document.getElementById("btn_amend").style.color = "black";
		} else {
			document.getElementById("btn_amend").style.color = "red";
		}
		break;
		
	case MULTI05: //실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을경우
		var param = SpcFormString(formObj, 'ALL');
		var rtn = sheetObj.GetSearchXml("ESM_SPC_0090GS2.do", "f_cmd=" + (MULTI05) + "&" + param);
		sheetObj.Reset();
		initSheet1(sheetObj, false);
		sheetObj.LoadSearchXml(rtn);
		sheetObj.SelectCell(sheetObj.HeaderRows ,"sub_trd_cd");
		break;	
	}
}


function obj_change(){
	var formObj = document.form;
	obj = event.srcElement;   
	
	with(formObj){
		switch(obj.name) {

//			case "acct_clss":
//				var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&acct_clss="+document.form.acct_clss.value+"&season="+document.form.season.Code+"&version="+document.form.version.Code);
//				initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
//				break;
				
			case "unit":
				if(formObj.season.Code != "" && formObj.version.Code != ""){
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
				break;
				
		}
	}
}

function obj_click(){
	var formObj = document.form;
	obj = event.srcElement;      	

	//송민석
//	if(obj.name == "view_type"){
//		if(tmpRhqView == "" || tmpRhqView != obj.value){
//			if(formObj.season.Code != "" && formObj.version.Code != ""){
//				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//			}
//		}
//		tmpRhqView = obj.value;
//	}
	//Type 바뀔때 서브버튼명 변경
//송민석 수정
//	if(obj.name == "view_type"){
//		if(obj.value == "H"){
//			document.getElementById("btn_ofc_lane_add").innerHTML = "RHQ/OFC Add";
//			document.getElementById("btn_ofc_lane_del").innerHTML = "Sub Trade/RHQ/OFC Delete";
//		}else{
//			document.getElementById("btn_ofc_lane_add").innerHTML = "Lane Add";
//			document.getElementById("btn_ofc_lane_del").innerHTML = "Lane Delete";			
//			
//		}
//	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		var trade = formObj.trade.Code;
		if (trade == "") {
			ComShowMessage(getMsg("SPC90114", "Trade"));
			formObj.trade.focus();
			return false;
		}
		
		var season = formObj.season.Code;
		if (season == "") {
			ComShowMessage(getMsg("SPC90114", "Season"));
			formObj.season.focus();
			return false;
		}
		
		var version = formObj.version.Code;
		if (version == "") {
			ComShowMessage(getMsg("SPC90114", "Version"));
			formObj.version.focus();
			return false;
		}
		break;
		
	case SEARCH03:
		if(formObj.trade.Code == "" || formObj.season.Code == ""){
			formObj.perf_st_yrwk.value = "";
			formObj.perf_end_yrwk.value = "";
			formObj.duration.value = "";
			return false;
		}
		break;
		
	case IBSAVE:
		//1. Add 에 의해서 입력된 L.OFC 또는 LANE 에 빈 칸이 존재하는지 확인한다.
		//2-1. HO의 경우 Guide WK VOL >= subsum(Guide VOL(1)) check
		//2-2. RHQ의 경우 Guide Vol(1) >= subsum(Guide Vol(2)) check
		var view_type = "R";//getRadioValue(document.form.view_type);
		//송민석 수정
		//if(view_type=="H"){ //HO
		//alert( sheetObj.HeaderRows+sheetObj.RowCount)
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(ComTrim(sheetObj.CellValue(i, "sub_trd_cd")) == "" || sheetObj.CellValue(i, "sub_trd_cd") == " "){
					//ComShowMessage(getMsg("SPC90114", "Sub Trade"));
					ComShowMessage(getMsg("SPC10887", "Sub Trade"));
					return false;
				}
				//alert(sheetObj.CellValue(i, "sls_rgn_ofc_cd"))
				if(ComTrim(sheetObj.CellValue(i, "sls_rgn_ofc_cd")) == "" ){
					ComShowMessage(getMsg("SPC90114", "Office"));
					return false;
				}
				if(sheetObj.CellValue(i, "sls_rgn_ofc_cd")=="TTL"){
					if(Number(sheetObj.CellValue(i, "cust_adj_qty")) < Number(sheetObj.CellValue(i, "strd_adj_qty"))){
						ComShowMessage("Sum Of [GUIDE WK VOL(2)] must be smaller than [GUIDE WK VOL(1)]");
						sheetObj.SelectCell(i, "cust_adj_qty");
						return false;
					}
				}
			}
		//
		//}else if(view_type=="R"){
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	             if(ComTrim(sheetObj.CellValue(i, "sls_rhq_cd"))=="" && ( sheetObj.CellValue(i, "sub_trd_cd")!="SC TTL" && sheetObj.CellValue(i, "sub_trd_cd")!="RFA TTL") ){
	                    ComShowMessage(getMsg("SPC10887", "RHQ"));
	                    return false;
	                }
	             
				if(ComTrim(sheetObj.CellValue(i, "rlane_cd"))=="" && sheetObj.CellValue(i, "sls_rgn_ofc_cd")!="TTL"){
					ComShowMessage(getMsg("SPC10887", "Lane"));
					return false;
				}
			}
			// 2014.03.11 유저 요청에 의해 VALIDATION 제거
//			if(!checkRHQGuideSum(sheetObj)){
//				//Office별 guide 값이 Lane별 guide의 합과 일치해야 함
//				return false;;
//			}

//		}else if(view_type=="L"){
//			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
//				if(sheetObj.CellValue(i, "spc_ctrl_mdl_rmk")!=sheetObj.CellValue(i, "org_spc_ctrl_mdl_rmk")){
//					sheetObj.CellValue2(i, "real_ibflag") = "U";
//					sheetObj.CellValue2(i, "g3_cng_usr") = "USER";
//					var rhqEndRow = Number(sheetObj.GetMergedEndCell(i, "sls_rhq_cd").split(",")[0]);
//					sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "USER";
//					setCngOfcList(sheetObj, i);
//				}
//			}
//		}
		break;
	}
	return true;
}

/*
 * 선택된 하나의 Radio Object Value를 반환
 * @param     oRadio : object Radio
 * @return    String
 */
function getRadioValue(oRadio) {
	if (oRadio == null) return "";
	
	if (oRadio.length != null)
	{
		for(i=0; i<oRadio.length; i++)
		{
			if (oRadio[i].checked) return oRadio[i].value;
		} // end for
	} else  {
		if (oRadio.checked) return oRadio.value;
	} // end if
	return "";
}

/**
 * combo 잔상으로 인하여 추가한 코딩
 * @param combj
 * @param value
 * @param text
 */
function trade_OnFocus(combj, value, text){
    document.getElementById("unit").focus();
    document.getElementById("trade").focus(); 
}

 /*
  * Trade Combo 변경시 해당 Trade 의 Season 을 조회 한다.
  * @param     comObj
  * @param     value
  * @param     text
  */
function trade_OnChange(comObj, value, text ){
	var obj = document.getElementById("sts");
	obj.value = "";
	
	setTimeout(function(){initData_season()},10);
//	initData_season();

 } 

/**
 * Season Sheet Combo 를 초기화 한다.
 */
function initData_season(){
	var comboObj = document.getElementById("season");
	
	with(comboObj){
		var rtn = getCodeXmlList("Season", "trade="+document.form.trade.Code);
		
		SetTitle("Season|Pfmc Week");
		DropHeight  = 190;
		MultiSelect = false;
		SetColWidth("70|120");
		SetColAlign("center|left");
		ComXml2ComboItem(rtn, comboObj, "code", "code|text");
		document.form.season.Index = document.form.season.GetCount()-1;
		
		if(document.form.season.GetCount() == 0){
			document.form.version.Code = "";
			return;
		}
	}
}
/*
 * Season Sheet Combo 변경시 해당 Season 의 Version 을 재조회 한다.
 * @param     comObj
 * @param     value
 * @param     text
 */
function season_OnChange(comObj, value, text ){
	setTimeout(function(){seasonEvent(comObj, value)},10);
} 
/**
 * combo 잔상으로 인하여 추가한 코딩
 * @param combj
 * @param value
 * @param text
 */
function season_OnFocus(combj, value, text){
    document.getElementById("unit").focus();
    document.getElementById("season").focus(); 
}

function seasonEvent(comObj, value){
	var obj = document.getElementById("sts");
	obj.value = "";

	var rtn = getCodeXmlList("SeasonVersion", "trade="+document.form.trade.Code+"&season="+comObj.Code);
	initData_version(rtn);
	
	//해당 version 의 from, to, duration 조회 
	doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	setCustCtrlCd(sheetObjects[0]);
}
/*
 * Version Sheet Combo 를 초기화 한다.
 * @param     value
 */
function initData_version(value){
	var obj = document.getElementById("version");
	
	obj.SetTitle("Version|Status|Period|Exept. WK|Update date");
	obj.SetColWidth("60|100|110|100|110");
	obj.SetColAlign("center|left|left|left|left");
	obj.DropHeight = 190;
	obj.ShowCol(0);
	
	ComXml2ComboItem(value, obj, "code", "code|text");
	document.form.version.Index = document.form.version.GetCount()-1;
	
}

/*
 * Version Sheet Combo 변경시 해당 Version 의 Status 를 화면에 보여준다.
 * @param     comObj
 * @param     value
 * @param     text
 */
function version_OnChange(comObj, value, text ){
	setTimeout(function(){versionEvent(comObj, value, text)},10);
	
}
/**
 * combo 잔상으로 인하여 추가한 코딩
 * @param combj
 * @param value
 * @param text
 */
function version_OnFocus(combj, value, text){
    document.getElementById("unit").focus();
    document.getElementById("version").focus(); 
}

function versionEvent(comObj, value, text){
	var obj = document.getElementById("sts");
	
	if(value==""){
		obj.value = "";
	}else{
		if(text.indexOf("|")>=0){
			obj.value = text.split("|")[1];
		}else{
			obj.value = text.split(",")[1];
		}
	}
	
//	var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&acct_clss="+document.form.acct_clss.value+"&season="+document.form.season.Code+"&version="+document.form.version.Code);
    var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&season="+document.form.season.Code+"&version="+document.form.version.Code);
	initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
	
	if(obj.value == "Not Confirmed" && spc01 == "Y" && (document.form.login_ofc_cd.value=="SELCDO" || document.form.login_ofc_cd.value=="SELCTY") 
			&& document.form.version.Index == document.form.version.GetCount()-1){
		ComBtnEnable("btn_confirm");
	}else{
		ComBtnDisable("btn_confirm");
	}

	if(value != ""){
		ComBtnEnable("btn_regeneration");
		ComBtnEnable("btn_import");
		ComBtnEnable("btn_amend");
		ComBtnEnable("btn_season_grp");
	}else{
		ComBtnDisable("btn_regeneration");
		ComBtnDisable("btn_import");
		ComBtnDisable("btn_amend");
		ComBtnDisable("btn_season_grp");
	}
	
	checkAmendValue();
}


function initData_acctList(codes, names) {
	var sheetObj = document.getElementById("acct_cd");
	var cnt = 0;
	
	with (sheetObj) {
		RemoveAll();
		SetTitle("Code|Name");
		SetColWidth("80|250");
		SetColAlign("left|left");
		ShowCol = 0;
		MultiSelect = true;
//		MaxSelect = 1;
		DropHeight = 190;
		
		if (codes == undefined || codes == null) {
			return;
		}
		
		if (codes.length > 2) {
			InsertItem(-1, "|ALL", "");
		}
		
		var selectCode = "";
		for ( var i = 0; i < codes.length - 1; i++) {
			var txt = names[i].split("~");
//			if (txt[1] == "1") {
//				selectCode = codes[i];
//			}
			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
		}
		
//		if (selectCode != "") {
//			Code = selectCode;
//		} else {
//			Index = 0;
//		}
//		Enable = (GetCount() > 1);
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var view_type = "R";//getRadioValue(formObj.view_type);
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){


        if(sheetObj.CellValue(i, "sls_rgn_ofc_cd")=="TTL"){
            
            //송민석 수정
            //if(view_type=="H"){ // H/O type 
                if(sheetObj.CellValue(i, "sub_trd_cd") == "SC TTL" || sheetObj.CellValue(i, "sub_trd_cd") == "RFA TTL"){
                    sheetObj.CellEditable(i, "cust_adj_qty") = false;
                    sheetObj.CellEditable(i, "strd_adj_qty") = false;
                }
                sheetObj.CellEditable(i, "strd_adj_qty") = false;
            //}else{ // RHQ type
                sheetObj.CellEditable(i, "rlane_adj_qty") = false;
            //}
        }else{
            //송민석 수정
            //if(view_type=="R" && formObj.incl_del.checked==false){
            if(formObj.incl_del.checked==false){
                if(sheetObj.CellValue(i, "o_add") == "O" && sheetObj.CellValue(i, "rlane_adj_qty") == "0"){ //office add 한 데이터
                    sheetObj.CellEditable(i, "rlane_cd") = true;
                    sheetObj.CellBackColor(i, "rlane_cd") = sheetObj.RgbColor(255,128,128);//red
                    sheetObj.CellValue2(i, "org_rlane_cd") = sheetObj.CellValue(i, "rlane_cd");
                    sheetObj.CellValue2(i, "real_ibflag") = "U";
                }
                //HO 최초 저장 이전에는 RHQ 또는 L.OFC 를 저장하지 못하도록 한다.(customer별로)
                //송민석 수정
                //if(sheetObj.CellValue(i, "rev_lane_cust_cnt") != "0"){
                    sheetObj.CellBackColor(i, "spc_ctrl_mdl_rmk") = editColor;
                //}
            }
        }
        
//      if(view_type=="L"){
//          sheetObj.CellValue2(i, "org_spc_ctrl_mdl_rmk") = sheetObj.CellValue(i, "spc_ctrl_mdl_rmk");
//          if(formObj.version.Index == formObj.version.GetCount()-1
//                  && document.getElementById("sts").value=="Not Confirmed" && sheetObj.CellValue(i, "sls_rgn_ofc_cd")!="TTL"
//                  && formObj.incl_del.checked==false){
//              //HO 최초 저장 이전에는 RHQ 또는 L.OFC 를 저장하지 못하도록 한다.(customer별로)
//              if(sheetObj.CellValue(i, "rev_lane_cust_cnt") != "0"){
//                  sheetObj.CellBackColor(i, "spc_ctrl_mdl_rmk") = editColor;
//              }
//          }
//      }
        
        
        
        
        //송민석수정
        //if(view_type=="H"){
            if(sheetObj.CellEditable(i, "cust_adj_qty")){
                //본사 권한 아니면 disable
                if(spc08 == "N" && spc09 == "N"){
                    sheetObj.CellEditable(i, "cust_adj_qty") = false;
                }else{
//                    if(sheetObj.CellValue(i, "rhq_ho")=="Y"){
//                        sheetObj.CellBackColor(i, "cust_adj_qty") = hoColor;
//                    }else{
                        sheetObj.CellBackColor(i, "cust_adj_qty") = editColor;
//                    }
                }
            }
            if(sheetObj.CellEditable(i, "strd_adj_qty")){
                if(spc08 == "N" && spc09 == "N"){
                    sheetObj.CellEditable(i, "strd_adj_qty") = false;
                }else{
//                    if(sheetObj.CellValue(i, "ofc_ho")=="Y"){
//                        sheetObj.CellBackColor(i, "strd_adj_qty") = hoColor;
//                    }else{
                        sheetObj.CellBackColor(i, "strd_adj_qty") = editColor;
//                    }
                }
            }
        //}else{
            //HO 최초 저장 이전에는 RHQ 또는 L.OFC 를 저장하지 못하도록 한다.(customer별로)
            //송민석수정
            //if((view_type=="R" && spc08 == "N" && spc09 == "N")|| (view_type=="R" && sheetObj.CellValue(i, "rev_lane_cust_cnt") == "0")){
            if(( spc08 == "N" && spc09 == "N") ){
                sheetObj.CellEditable(i, "rlane_adj_qty") = false;
            }
            
            if(sheetObj.CellEditable(i, "rlane_adj_qty")){
//                if(sheetObj.CellValue(i, "lane_ho")=="Y"){
//                    sheetObj.CellBackColor(i, "rlane_adj_qty") = hoColor;
//                }else{
                    sheetObj.CellBackColor(i, "rlane_adj_qty") = editColor;
//                }
            }
        //}
      
	    
	}
	
	if(sheetObj.SearchRows>0){
		calcPfmcWgt(sheetObj, 'ALL', '');
	}
	
	// Trade에 따라서 SC_NO/RFA_NO를 보여줄지 컨트롤한다.
	if ( formObj.trade.Code == "TPS" ) {
		sheetObj.ColHidden("sc_no") = false;
		sheetObj.ColHidden("rfa_no") = true;
		sheetObj.ColHidden("wk_mqc_qty") = false;
	} else if ( formObj.trade.Code == "AES" || formObj.trade.Code == "IAS") {
		sheetObj.ColHidden("sc_no") = true;
		sheetObj.ColHidden("rfa_no") = false;
		sheetObj.ColHidden("wk_mqc_qty") = false;
	} else {
		sheetObj.ColHidden("sc_no") = true;
		sheetObj.ColHidden("rfa_no") = true;
		sheetObj.ColHidden("wk_mqc_qty") = true;
	}
	
	//최신 version만 데이터 수정 가능하도록 한다.
	if(formObj.version.Index == formObj.version.GetCount()-1){
		//if(((view_type=="H" || view_type=="R") && spc08=="N" && spc09=="N") || (view_type=="L" && document.getElementById("sts").value=="Confirmed")){
	    if((  spc08=="N" && spc09=="N") ){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_ofc_lane_add");
			ComBtnDisable("btn_ofc_lane_del");
            ComBtnDisable("btn_ofc_lane_add2");
            ComBtnDisable("btn_ofc_lane_del2");

			ComBtnDisable("btn_sub_trd_add");
			ComBtnDisable("btn_reuse");
			sheetObj.Editable = false;
		}else{
			if(formObj.incl_del.checked == false){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_ofc_lane_add");
				ComBtnEnable("btn_ofc_lane_del");
                ComBtnEnable("btn_ofc_lane_add2");
                ComBtnEnable("btn_ofc_lane_del2");
				ComBtnEnable("btn_sub_trd_add");
			}else{
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_ofc_lane_add");
				ComBtnDisable("btn_ofc_lane_del");
                ComBtnDisable("btn_ofc_lane_add2");
                ComBtnDisable("btn_ofc_lane_del2");
				ComBtnDisable("btn_sub_trd_add");
				sheetObj.Editable = false;
			}
			ComBtnEnable("btn_reuse");
		}
	}else{
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_ofc_lane_add");
		ComBtnDisable("btn_ofc_lane_del");
        ComBtnDisable("btn_ofc_lane_add2");
        ComBtnDisable("btn_ofc_lane_del2");
		ComBtnDisable("btn_sub_trd_add");
		ComBtnDisable("btn_reuse");
		sheetObj.Editable = false;
	}
	//Sub Trade Add는 H/O 조회 후에만 가능
	//송민석수정
	//if(view_type == "H"){
		document.getElementById("subTrdAdd").style.display = "inline";
	//}else{
		//document.getElementById("subTrdAdd").style.display = "none";
	//}

//송민석 수정
//	if((view_type=="H" || view_type=="R") && formObj.incl_del.checked==true){
//		document.getElementById("addDel").style.display = "none";
//		document.getElementById("reuse").style.display = "inline";
//	}else if(view_type=="L"){
//		document.getElementById("addDel").style.display = "none";
//		document.getElementById("reuse").style.display = "none";
//	}else{
//		document.getElementById("addDel").style.display = "inline";
//		document.getElementById("reuse").style.display = "none";
//	}
	if( formObj.incl_del.checked==true){
	    document.getElementById("addDel").style.display = "none";
	       document.getElementById("addDel2").style.display = "none";

	    document.getElementById("reuse").style.display = "inline";
	}else{
        document.getElementById("addDel").style.display = "inline";
        document.getElementById("addDel2").style.display = "inline";

        document.getElementById("reuse").style.display = "none";
	}
	
	//if(view_type=="R" && formObj.incl_del.checked==false){
	if(formObj.incl_del.checked==false){
		findRHQGuideSumMissmatch(sheetObj);
	}
}
// RHQ 항목에 COPY를 못하도록 하기 위해서 사용
// Defalue= "", Ctrl+V = "V"
var rhq_key_value = null;
function sheet1_OnKeyDown(sheetObj, Row,Col, KeyCode, Shift){
	rhq_key_value = "";
	if (sheetObj.ColSaveName(Col) == "sls_rhq_cd"){
		if(Shift == 2 && KeyCode==86 ){// shift = 2(Ctrl), 86 = V
			rhq_key_value = "V";
		}
	}
}

function sheet1_OnChange(sheetObj,row,col, value){
	var formObj = document.form;
	switch (sheetObj.ColSaveName(col)) {
	case "sub_trd_cd" :
		//입력한 Sub Trade의 유효성 체크
		if(value != ""){
			if(dupSubTrdChk(sheetObj, row, col)){
				var param ="trd_cd=" + formObj.trade.Code + "&sub_trd_cd=" + value;
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + (SEARCH06) + "&" + param);
				var subTrdChk = ComGetEtcData(sXml, "sub_trd_chk");
				if(subTrdChk=="N"){
					ComShowMessage(getMsg("SPC90199", "Sub Trade"));
					var StartRow = Number(sheetObj.GetMergedStartCell(row, "sub_trd_cd").split(",")[0]);
					var EndRow = Number(sheetObj.GetMergedEndCell(row, "sub_trd_cd").split(",")[0]);

					for(var i=StartRow; i<=EndRow; i++){
						sheetObj.CellValue2(i, col) = " ";
					}
					sheetObj.SelectCell(row, col);
				}
				
			}else{
				ComShowCodeMessage("SPC90135");
				var StartRow = Number(sheetObj.GetMergedStartCell(row, "sub_trd_cd").split(",")[0]);
				var EndRow = Number(sheetObj.GetMergedEndCell(row, "sub_trd_cd").split(",")[0]);

				for(var i=StartRow; i<=EndRow; i++){
					sheetObj.CellValue2(i, col) = " ";
				}
				sheetObj.SelectCell(row, col);
			}
		} else {
			sheetObj.CellValue2(row, col) = " ";
		}
		break;
	
	case "sls_rhq_cd" :
		//입력한 RHQ office의 유효성 체크
		if(value != "" && rhq_key_value != "V"){// 값이 있고 Ctrl+V를 하지 않았을 경우(머지 컬럼이라 복사시 문제점이 있음)
			if(dupRHQChk(sheetObj, row, col)){
				var param ="sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd");
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + (SEARCH05) + "&" + param);
				var rhqChk = ComGetEtcData(sXml, "rhq_chk");
				if(rhqChk=="N"){
					ComShowMessage(getMsg("SPC90199", "RHQ"));
					var StartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
					var EndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);

					for(var i=StartRow; i<=EndRow; i++){
						sheetObj.CellValue2(i, col) = " ";
					}
					sheetObj.SelectCell(row, col);
				}
				
			}else{
				ComShowCodeMessage("SPC90135");
				var StartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
				var EndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);

				for(var i=StartRow; i<=EndRow; i++){
					sheetObj.CellValue2(i, col) = " ";
				}
				sheetObj.SelectCell(row, col);
			}
		} else {
			sheetObj.CellValue2(row, col) = " ";
		}
		break;
	case "strd_qty" :
		handlingPfmc(sheetObj, row, col);
		//guide sum 계산
		var rtn = calcSumPerSC(sheetObj, row, "strd_qty");
		var rtnAry = rtn.split("|"); //scTotal, scEndRow
		
		sheetObj.CellValue2(rtnAry[1], "strd_qty") = rtnAry[0];

		break;
		
	case "cust_adj_qty":
		var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
		var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
		
		// 복사할 경우 첫번째 Row만들어가서 머지가 깨짐
//		if(sheetObj.CellValue(rhqStartRow, col)!=sheetObj.CellValue(rhqEndRow, col)){
//			//merge된 컬럼의 경우 각 row마다 onchange 이벤트 발생
//			break;
//		}
		for(var i=rhqStartRow; i<= rhqEndRow; i++){
			if(sheetObj.CellSearchValue(row, col) == value){
				if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, "real_ibflag")!="I"){
					sheetObj.CellValue2(i, "g1_cng_usr") = "";
					sheetObj.CellValue2(i, "cust_adj_qty_upd_flg") = "";
					//RHQ Load Guide는 안바뀌었지만 OFC Load Guide는 바뀌었을 수 있으므로 둘다 안바뀌었을때만 ibflag를 없애줌.
					if(sheetObj.CellValue(i, "strd_adj_qty") == sheetObj.CellSearchValue(i, "strd_adj_qty")){
						sheetObj.CellValue2(i, "real_ibflag") = "";
					}
				}
			} else {
				if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, "real_ibflag")!="I"){
					sheetObj.CellValue2(i, "g1_cng_usr") = "USER";
					sheetObj.CellValue2(i, "real_ibflag") = "U";
					sheetObj.CellValue2(i, "cust_adj_qty_upd_flg") = "Y";
				}
				sheetObj.CellValue(i, col) = sheetObj.CellValue(rhqStartRow, col);
				
			}
		}
		
		if(!checkUnitValue(sheetObj, row, col)){
			//merge되어 있으므로, merge된 모든 컬럼의 값을 이전 값으로 되돌린다.
			for(var i=rhqStartRow; i<=rhqEndRow; i++){
				sheetObj.CellValue2(i, col) = backValue;
			}
			break;
		}
		// Pro ratio(%) Guide를 변경한다.
		calcPfmcWgt(sheetObj, "HO", row);

//		RHQ Load Guide를 변경했을 경우 L.OFC Load Guide에 Ratio 기준으로 배부해 주는 로직 제거(2014.11.12 신혜성 부장님 요청)
//		if(sheetObj.CellSearchValue(row, col) == value){
//			//조회값으로 되돌리는 경우, strd_adj_qty 또한 마찬가지로 조회값으로 되돌린다.
//			sheetObj.CellValue2(row, col) = value;
//			var cnt=0;
//			for(var i=rhqStartRow; i<rhqEndRow; i++){
//				if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, "real_ibflag")!="I"){
//					sheetObj.CellValue2(i, "strd_adj_qty") = sheetObj.CellSearchValue(i, "strd_adj_qty");
//					sheetObj.CellValue2(i, "g2_cng_usr") = "";
//					sheetObj.CellValue2(i, "g1_cng_usr") = "";
//					sheetObj.CellValue2(i, "real_ibflag") = "";
//				}else if(sheetObj.CellValue(i, "real_ibflag")=="I"){
//					sheetObj.CellValue2(i, "g1_cng_usr") = "";
//				}else{
//					cnt++;
//				}
//			}
//			sheetObj.CellValue2(rhqEndRow, "strd_adj_qty") = sheetObj.CellValue(rhqEndRow, "cust_adj_qty");
//			sheetObj.CellValue2(rhqEndRow, "g1_cng_usr") = "";
//			if(cnt>0){	//delete건 
//				sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "USER";
//			}else{
//				sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "";
//			}
//		}else{
//			//HO 에서 Guide 1값 변경시 Guide 2값을 weight와 동일하게 셋팅해준다.(total까지)
//			for(var i=rhqStartRow; i<=rhqEndRow; i++){
//				if(!sheetObj.RowHidden(i)){
//					sheetObj.CellValue2(i, "g1_cng_usr") = "USER";
//					sheetObj.CellValue2(i, "g2_cng_usr") = "AUTO";
//					sheetObj.CellValue2(i, "strd_adj_qty") = sheetObj.CellValue(i, "strd_pfmc_wt");
//					if(sheetObj.CellValue(i, "real_ibflag")!="I" && sheetObj.CellValue(i, "real_ibflag")!="D"){
//						sheetObj.CellValue2(i, "real_ibflag") = "U";
//					}
//				}
//			}
//		}
//
		//sc total 계산
		var rtn = calcSumPerSC(sheetObj, row, "cust_adj_qty");
		var rtnAry = rtn.split("|"); //scTotal, scEndRow
		sheetObj.CellValue2(rtnAry[1], "cust_adj_qty") = rtnAry[0];
		break;
		
	case "strd_adj_qty":
		if(!checkUnitValue(sheetObj, row, col)){
			sheetObj.CellValue2(row, col) = backValue;
			break;
		}
		
		var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
		var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
		//RHQ Guide 변경하지 않은 경우에는, search value와 비교하여 같으면 null, 다르면 user.
		//RHQ Guide 변경시에는 OFC Guide는 Pro rata Guide와 비교하여 같으면 auto, 다르면 user.
		if(sheetObj.CellValue(row, "cust_adj_qty") == sheetObj.CellSearchValue(row, "cust_adj_qty")){
			if(sheetObj.CellSearchValue(row, col) == value){
					sheetObj.CellValue2(row, "g2_cng_usr") = "";
					sheetObj.CellValue2(row, "real_ibflag") = "";
			}else{
				sheetObj.CellValue2(row, "g2_cng_usr") = "USER";
				if(sheetObj.CellValue(row, "strd_flag2") != "Y"){
					sheetObj.CellValue2(row, "real_ibflag") = "I";
				}else{
					sheetObj.CellValue2(row, "real_ibflag") = "U";
				}
			}
		}else{
			sheetObj.CellValue2(row, "g2_cng_usr") = "USER";
			if(sheetObj.CellValue(row, "strd_flag2") != "Y"){
				sheetObj.CellValue2(row, "real_ibflag") = "I";
			}else{
				sheetObj.CellValue2(row, "real_ibflag") = "U";
			}
		}
		//rhqEndRow의 g2_cng_usr를 제어한다.
		var cnt1=0;
		var cnt2=0;
		for(var i=rhqStartRow; i<rhqEndRow; i++){
			if(sheetObj.CellValue(i, "g2_cng_usr")=="USER"){
				cnt1++;
			}
			if(sheetObj.CellValue(i, "g2_cng_usr")=="AUTO"){
				cnt2++;
			}
		}
		if(cnt1>0){
			sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "USER";
		}else if(cnt2>0){
			sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "AUTO";
		}else{
			sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "";
		}
		
		// RHQ total 값을 계산하여 넣어준다.
		var total = 0;
		for(var i=rhqStartRow; i<rhqEndRow; i++){
			total = total + Number(sheetObj.CellValue(i, "strd_adj_qty"));
		}
		sheetObj.CellValue2(rhqEndRow, "strd_adj_qty") = total;
		
		// SC total 값을 계산하여 넣어준다
		var rtn = calcSumPerSC(sheetObj, row, "strd_adj_qty");
		var rtnAry = rtn.split("|"); //scTotal, scEndRow
		sheetObj.CellValue2(rtnAry[1], "strd_adj_qty") = rtnAry[0];
		
//		if(sheetObj.CellValue(row, "real_ibflag")!="I"){
//			sheetObj.CellValue2(row, "real_ibflag") = "U";
//		}

		break;
		
	case "rlane_qty":
		handlingPfmc(sheetObj, row, col);
		
		break;
		
	case "rlane_adj_qty":
		if(!checkUnitValue(sheetObj, row, col)){
			sheetObj.CellValue2(row, col) = backValue;
			break;
		}
		var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
		var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);

		if(sheetObj.CellSearchValue(row, col) == value){
			sheetObj.CellValue2(row, "g3_cng_usr") = "";
		}else{
			sheetObj.CellValue2(row, "g3_cng_usr") = "USER";
		}
		//rhqEndRow의 g2_cng_usr를 제어한다.
		var cnt=0;
		for(var i=rhqStartRow; i<rhqEndRow; i++){
			if(sheetObj.CellValue(i, "g3_cng_usr")=="USER"){
				cnt++;
			}
		}
		if(cnt>0){
			sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "USER";
		}else{
			sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "";
		}
		
		setCngOfcList(sheetObj, row);
		
		var total = 0;
		for(var i=rhqStartRow; i<rhqEndRow; i++){
			total = total + Number(sheetObj.CellValue(i, "rlane_adj_qty"));
		}
		sheetObj.CellValue2(rhqEndRow, "rlane_adj_qty") = total;
		
		var rtn = calcSumPerSC(sheetObj, row, "rlane_adj_qty");
		var rtnAry = rtn.split("|"); //scTotal, scEndRow
		sheetObj.CellValue2(rtnAry[1], "rlane_adj_qty") = rtnAry[0];
		break;
		
		
	case "sls_rgn_ofc_cd":
		//입력한 office의 유효성 체크
		if(value != ""){
			if(dupOfcChk(sheetObj, row, col)){
				//spc08이 삭제한 office를 spc09가 row add하지 못하도록 수정.(2013-04-03)
				var param = "cost_yrwk=" + formObj.season.Code
					      + "&ver_seq="  + formObj.version.Code
					      + "&trd_cd="   + sheetObj.CellValue(row, "trd_cd")
					      + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
					      + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd")
					      + "&sls_rgn_ofc_cd=" + value
					      + "&cust_cnt_cd=" + sheetObj.CellValue(row, "cust_cnt_cd")
					      + "&cust_seq=" + sheetObj.CellValue(row, "cust_seq")
					      + "&ctrt_ofc_cd=" + sheetObj.CellValue(row, "ctrt_ofc_cd")
					      + "&sc_no="    + sheetObj.CellValue(row, "sc_no")
					      + "&rfa_no="    + sheetObj.CellValue(row, "rfa_no")
					      ;
				
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + (SEARCH01) + "&" + param);
				var ofcChk = ComGetEtcData(sXml, "ofc_chk");
//				var hoIntention = ComGetEtcData(sXml, "ho_intention");
				if(ofcChk=="N"){
					ComShowMessage(getMsg("SPC90199", "Office"));
					sheetObj.CellValue2(row, col) = "";
					sheetObj.SelectCell(row, col);
//				}else if(hoIntention=="Y" && spc08=="N"){
//					ComShowMessage("You can not add the office that is related with HQ's intention.");
//					sheetObj.CellValue2(row, col) = "";
//					sheetObj.SelectCell(row, col);
				}
			}else{
				ComShowCodeMessage("SPC90135");
				sheetObj.CellValue2(row, col) = "";
				sheetObj.SelectCell(row, col);
			}
			
		}
		break;
		
	case "rlane_cd":
		//입력한 lane의 유효성 체크
		if(value != ""){
		    
			if(dupLaneChk(sheetObj, row, col)){
				var param = "cost_yrwk=" + formObj.season.Code
					      + "&ver_seq="  + formObj.version.Code
					      + "&trd_cd="   + sheetObj.CellValue(row, "trd_cd")
					      + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
					      + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd")
					      + "&sls_rgn_ofc_cd=" + sheetObj.CellValue(row, "sls_rgn_ofc_cd")
					      + "&cust_cnt_cd=" + sheetObj.CellValue(row, "cust_cnt_cd")
					      + "&cust_seq=" + sheetObj.CellValue(row, "cust_seq")
					      + "&ctrt_ofc_cd=" + sheetObj.CellValue(row, "ctrt_ofc_cd")
					      + "&sc_no="    + sheetObj.CellValue(row, "sc_no")
					      + "&rfa_no="    + sheetObj.CellValue(row, "rfa_no")
					      + "&rlane_cd=" + value;
				//alert(param)
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + (SEARCH02) + "&" + param);
				var laneChk = ComGetEtcData(sXml, "lane_chk");
//				var hoIntention = ComGetEtcData(sXml, "ho_intention");
				if(laneChk=="N"){
					ComShowMessage(getMsg("SPC90199", "Lane"));
					sheetObj.CellValue2(row, col) = "";
					sheetObj.SelectCell(row, col);
//				}else if(hoIntention=="Y" && spc08=="N"){
//					ComShowMessage("You can not add the lane that is related with HQ's intention.");
//					sheetObj.CellValue2(row, col) = "";
//					sheetObj.SelectCell(row, col);
				}else{
					//lane change
					var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
					sheetObj.CellValue2(row, "g3_cng_usr") = "USER";
					sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "USER";
					setCngOfcList(sheetObj, row);
				}
			}else{
				ComShowCodeMessage("SPC90135");
				sheetObj.CellValue2(row, col) = "";
				sheetObj.SelectCell(row, col);
			}
		}
		break;
		
	case "del":
		var formObj = document.form;
//		var view_type = getRadioValue(document.form.view_type);
		var EndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
		
		// 0인 데이터들만 Del 되는것이라서 OFC/Lane Delete와 조금 다르게 처리함
		if (sheetObj.CellValue(row, col) == 1) {
		    //송민석수정
//			if(view_type == "H"){ 
//				//선택된 row는 hidden처리. strd_adj_qty는 0으로. real_ibflag는 d로. 그 이후에 계산되거나 영향받는 모든 경우, real_ibflag가 d인 것을 제외하는 로직이 들어가야 함. 숨긴애 빼고 ratio 다시 계산
//				sheetObj.CellValue2(row, "real_ibflag") = "D";
//				sheetObj.CellValue2(row, "g2_cng_usr")  = "USER";
//				sheetObj.CellValue2(EndRow, "g2_cng_usr") = "USER";
//			} else {
				sheetObj.CellValue2(row, "real_ibflag") = "D";
				sheetObj.CellValue2(row, "g3_cng_usr") = "USER";
				sheetObj.CellValue2(EndRow, "g3_cng_usr") = "USER";
//			}
		} else {
		    //송민석 수정
//			if(view_type == "H"){ 
//				//선택된 row는 hidden처리. strd_adj_qty는 0으로. real_ibflag는 d로. 그 이후에 계산되거나 영향받는 모든 경우, real_ibflag가 d인 것을 제외하는 로직이 들어가야 함. 숨긴애 빼고 ratio 다시 계산
//				sheetObj.CellValue2(row, "real_ibflag")  = "";
//				sheetObj.CellValue2(row, "g2_cng_usr")   = sheetObj.CellSearchValue(row, "g2_cng_usr");
//			} else {
				sheetObj.CellValue2(row, "real_ibflag")  = "";
				sheetObj.CellValue2(row, "g3_cng_usr")   = sheetObj.CellSearchValue(row, "g3_cng_usr");
//			}
		}
		
		break;
	}
}

function sheet1_OnBeforeEdit(sheetObj, Row, Col){
	backValue = sheetObj.CellValue(Row, Col);
}

function sheet1_OnDblClick(sheetObj,row,col){
	var formObj = document.form;
	var param = "cost_yrwk="      + formObj.season.Code
	          + "&ver_seq="       + formObj.version.Code
	          + "&duration="      + formObj.duration.value
	          + "&unit_cd="       + formObj.unit.value
	          + "&unit_text="     + formObj.unit[formObj.unit.selectedIndex].text
	          + "&trd_cd="        + sheetObj.CellValue(row, "trd_cd")
	          + "&sc_no="         + sheetObj.CellValue(row, "sc_no")
	          + "&rfa_no="        + sheetObj.CellValue(row, "rfa_no")
	          + "&perf_st_yrwk="  + formObj.perf_st_yrwk.value
	          + "&perf_end_yrwk=" + formObj.perf_end_yrwk.value
              + "&cust_cnt_cd="   + sheetObj.CellValue(row, "cust_cnt_cd")
              + "&cust_seq="      + sheetObj.CellValue(row, "cust_seq")
              + "&sc_rfa_flg="    + sheetObj.CellValue(row, "sc_rfa_flg")
	          ;
	switch (sheetObj.ColSaveName(col)) {
		case "cust_qty" :
		case "smpl_cust_qty" :
			if(sheetObj.CellValue(row, "sub_trd_cd") != "SC TTL" && sheetObj.CellValue(row, "sub_trd_cd") != "RFA TTL"){
				param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
				              + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd");
			}
			openAveragePfmcPopup(param);
			break;

		case "strd_qty" :
		case "smpl_strd_qty" :
			if(sheetObj.CellValue(row, "sub_trd_cd")!="SC TTL" && sheetObj.CellValue(row, "sub_trd_cd")!="RFA TTL"){
				param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
				              + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd");
				if(sheetObj.CellValue(row, "sls_rgn_ofc_cd")!="TTL"){
					param = param + "&sls_rgn_ofc_cd=" + sheetObj.CellValue(row, "sls_rgn_ofc_cd");
				}
			}
			openAveragePfmcPopup(param);
			break;
		
		case "rlane_qty" :
		case "smpl_rlane_qty" :
			if(sheetObj.CellValue(row, "sub_trd_cd")!="SC TTL" && sheetObj.CellValue(row, "sub_trd_cd")!="RFA TTL"){
				param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
				              + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd");
				if(sheetObj.CellValue(row, "sls_rgn_ofc_cd")!="TTL"){
					param = param + "&sls_rgn_ofc_cd=" + sheetObj.CellValue(row, "sls_rgn_ofc_cd")
					              + "&rlane_cd="       + sheetObj.CellValue(row, "rlane_cd");
				}
			}
			openAveragePfmcPopup(param);
			break;
			
		case "strd_cmpb":
			param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
                          + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd")
			              + "&sls_rgn_ofc_cd=" + sheetObj.CellValue(row, "sls_rgn_ofc_cd")
			              + "&cust_lgl_eng_nm=" + sheetObj.CellValue(row, "cust_lgl_eng_nm")
			              ;
			if(sheetObj.CellValue(row, "sls_rgn_ofc_cd")!="TTL"){
				openCmpbPopup(param);
			}
			break;
			
		case "rlane_cmpb":
			param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
			              + "&sls_rhq_cd=" + sheetObj.CellValue(row, "sls_rhq_cd")
			              + "&sls_rgn_ofc_cd=" + sheetObj.CellValue(row, "sls_rgn_ofc_cd")
			              + "&cust_lgl_eng_nm=" + sheetObj.CellValue(row, "cust_lgl_eng_nm")
			              + "&rlane_cd=" + sheetObj.CellValue(row, "rlane_cd")
			              ;
			if(sheetObj.CellValue(row, "sls_rgn_ofc_cd")!="TTL"){
				openCmpbPopup(param);
			}
			break;
	}
}

function openAveragePfmcPopup(param){
	window.showModalDialog(
			"ESM_SPC_0096.do?"+param,
			null,
	"dialogHeight:670px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
}

function openCmpbPopup(param){
	window.showModalDialog(
			"ESM_SPC_0097.do?"+param,
			null,
	"dialogHeight:570px;dialogWidth:720px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
}

function calcRatio(sheetObj, row, col){
	if(sheetObj.ColSaveName(col) == "strd_qty"){
		calcRatioStrd(sheetObj, row, col);
	}else if(sheetObj.ColSaveName(col) == "rlane_qty"){
		calcRatioRlane(sheetObj, row, col);
	}
}

function calcRatioStrd(sheetObj, row, col){
	var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
	
	for(var i=rhqStartRow; i<rhqEndRow; i++){
		if(sheetObj.CellValue(i, "cust_qty")==0){
			sheetObj.CellValue2(i, "strd_pfmc_ratio") = 0;
		}else{
			sheetObj.CellValue2(i, "strd_pfmc_ratio") = Math.round(Number(sheetObj.CellValue(i, col)) / Number(sheetObj.CellValue(i, "cust_qty")) * 100 * 100)/100 ;
		}
	}
	
	sheetObj.CellValue2(rhqEndRow, "strd_pfmc_ratio") = ""; //TTL Line
}
	
function calcRatioRlane(sheetObj, row, col){
	var lOfcStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rgn_ofc_cd").split(",")[0]);
	var lOfcEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rgn_ofc_cd").split(",")[0]);
	var total = 0;
	for(var i=lOfcStartRow; i<=lOfcEndRow; i++){
		if(!sheetObj.RowHidden(i)){
			total = total + Number(sheetObj.CellValue(i, "rlane_qty"));
		}
	}
	
	for(var i=lOfcStartRow; i<=lOfcEndRow; i++){
		if(total == 0){
			sheetObj.CellValue2(i, "rlane_pfmc_ratio") = 0;
		}else{
			sheetObj.CellValue2(i, "rlane_pfmc_ratio") = Math.round(Number(sheetObj.CellValue(i, "rlane_qty")) / total * 100 * 100)/100;
		}
	}
}

/**
 * strd_pfmc_wt/rlane_pfmc_wt을 자동계산 해 준다.
 * 특정 데이터에 대해서만 Weight 계산
 * 
 * @param sheetObj
 * @param division
 * @param row
 */
function calcPfmcWgt(sheetObj, division, row){
	if(division == "HO"){
		calcPfmcWgtStrd(sheetObj, row);
	}else if(division == "RHQ"){
		calcPfmcWgtRlane(sheetObj, row);
	}else{ //onSearchEnd 에서 호출. 전체 weight 계산
		calcPfmcAll(sheetObj);
	}
//	calcSumPerSC(sheetObj, row, col);
}

/**
 * 전체 PFMC Weighted 계산해야 함.(OnSearchEnd에서만 콜함)
 * HO 일땐 strd_pfmc_wt/ RHQ 일땐 rlane_pfmc_wt을 자동계산 해 준다.
 * 
 * @param sheetObj
 */
function calcPfmcAll(sheetObj){
	//전체 PFMC Weighted 계산해야 함.
	var i=sheetObj.HeaderRows;
	var rtnRow = "";
//	var view_type = getRadioValue(document.form.view_type);
	
	for(var j=sheetObj.HeaderRows; j<sheetObj.HeaderRows+sheetObj.RowCount; j++){
	    //송민석수정
//		if(view_type=="H"){
//			rtnRow = calcPfmcWgtStrd(sheetObj, i);
//		}else{
			rtnRow = calcPfmcWgtRlane(sheetObj, i);
//		}
		
		i = Number(rtnRow) + 1;
		if(i==Number(sheetObj.HeaderRows)+Number(sheetObj.RowCount)){
			break;
		}
	}	
}

/**
 * Pro ration(%) Guide를 계산해 준다.(strd_pfmc_wt)
 * 
 * @param sheetObj
 * @param row
 * @returns
 */
function calcPfmcWgtStrd(sheetObj, row){
	var ratioCol = "strd_pfmc_ratio";
	var wtCol    = "strd_pfmc_wt";
	var guideCol = "cust_adj_qty";
	
	var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqEndRow   = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
	
	var total = 0;
	for(var i=rhqStartRow; i<rhqEndRow; i++){
		if(document.form.unit.value=="T"){
			sheetObj.CellValue2(i, wtCol) = Math.round(Number(sheetObj.CellValue(i, guideCol)) * Number(sheetObj.CellValue(i, ratioCol)) / 100);
		}else{
			sheetObj.CellValue2(i, wtCol) = Math.round(Number(sheetObj.CellValue(i, guideCol)) * Number(sheetObj.CellValue(i, ratioCol)) / 100 * 2)/2;
		}
		total = total + Number(sheetObj.CellValue(i, wtCol));
	}
	
	//PFMC WGT 계산 후, sum이 Guide와 맞는지 확인하여. 차이나는 부분은 가장 portion이 큰 곳에서 맞춰준다.
	var diff = Number(sheetObj.CellValue(rhqEndRow, guideCol)) - total;
	
//	if(diff != 0){
//		var maxRow = findMaxPortionRow(sheetObj, rhqStartRow, rhqEndRow-1, ratioCol);
//		sheetObj.CellValue2(maxRow, wtCol) = Number(sheetObj.CellValue(maxRow, wtCol))+diff;
//	}

	var cnt=1;
	for(var i=0; i<rhqEndRow-rhqStartRow; i++){ //무한roof
		if(diff>0){
			var maxRow = findMaxCmpbRow(sheetObj, rhqStartRow, rhqEndRow-1, "strd_cmpb");
			sheetObj.CellValue2(maxRow, wtCol) = Number(sheetObj.CellValue(maxRow, wtCol))+diff;
			break;
		}else if(diff<0){
			var minRow = findMinCmpbRow(sheetObj, rhqStartRow, rhqEndRow-1, "strd");
			
			if(Number(sheetObj.CellValue(minRow, wtCol))+diff >= 0){
				sheetObj.CellValue2(minRow, wtCol) = Number(sheetObj.CellValue(minRow, wtCol))+diff;
				break;
			}else{
				diff = Number(sheetObj.CellValue(minRow, wtCol))+diff;
				sheetObj.CellValue2(minRow, wtCol) = 0;
				//다시 for문 수행
				cnt = cnt + 1;
			}
		}else{
			break;
		}
	}
		
	//맞춰진 total
	sheetObj.CellValue2(rhqEndRow, wtCol) = sheetObj.CellValue(rhqEndRow, guideCol);
	
	var rtn = calcSumPerSC(sheetObj, row, wtCol);
	var rtnAry = rtn.split("|"); //scTotal, scEndRow
	sheetObj.CellValue2(rtnAry[1], wtCol) = rtnAry[0];
	sheetObj.CellValue2(rtnAry[1], guideCol) = rtnAry[0];
	
	return rhqEndRow;
}

/**
 *  (rlane_pfmc_wt) 값을 자동 계산해 준다.
 * @param sheetObj
 * @param row
 * @returns {Number}
 */
function calcPfmcWgtRlane(sheetObj, row){
	var ratioCol = "rlane_pfmc_ratio";
	var wtCol    = "rlane_pfmc_wt";
	var guideCol = "strd_adj_qty";
	var rtnRow = 0;
	
	if(sheetObj.CellValue(row, "sls_rgn_ofc_cd")=="TTL"){

		var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
		var rhqEndRow   = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
		
		var total = 0;
		for(var i=rhqStartRow; i<rhqEndRow; i++){
			total = total + Number(sheetObj.CellValue(i, wtCol));
		}
		sheetObj.CellValue2(row, wtCol) = total;
		rtnRow = row;
	}else{
		var lOfcStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rgn_ofc_cd").split(",")[0]);
		var lOfcEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rgn_ofc_cd").split(",")[0]);
		
		var total = 0;
		
		for(var i=lOfcStartRow; i<=lOfcEndRow; i++){
			if(document.form.unit.value=="T"){
				sheetObj.CellValue2(i, wtCol) = Math.round(Number(sheetObj.CellValue(i, guideCol)) * Number(sheetObj.CellValue(i, ratioCol)) / 100);
			}else{
				sheetObj.CellValue2(i, wtCol) = Math.round(Number(sheetObj.CellValue(i, guideCol)) * Number(sheetObj.CellValue(i, ratioCol)) / 100 * 2)/2;
			}
			total = total + Number(sheetObj.CellValue(i, wtCol));
		}
		
		//PFMC WGT 계산 후, sum이 Guide와 맞는지 확인하여. 차이나는 부분은 가장 portion이 큰 곳에서 맞춰준다.
		var diff = Number(sheetObj.CellValue(lOfcEndRow, guideCol)) - total;
			
		var cnt=1;

		for(var i=0; i<=lOfcEndRow-lOfcStartRow; i++){ //무한roof
			if(diff>0){
				var maxRow = findMaxCmpbRow(sheetObj, lOfcStartRow, lOfcEndRow, "rlane_cmpb");
				sheetObj.CellValue2(maxRow, wtCol) = Number(sheetObj.CellValue(maxRow, wtCol))+diff;
				break;
			}else if(diff<0){
				var minRow = findMinCmpbRow(sheetObj, lOfcStartRow, lOfcEndRow, "rlane");
//				sheetObj.CellValue2(minRow, wtCol) = Number(sheetObj.CellValue(minRow, wtCol))+diff;
				if(Number(sheetObj.CellValue(minRow, wtCol))+diff >= 0){
					sheetObj.CellValue2(minRow, wtCol) = Number(sheetObj.CellValue(minRow, wtCol))+diff;
					break;
				}else{
					diff = Number(sheetObj.CellValue(minRow, wtCol))+diff;
					sheetObj.CellValue2(minRow, wtCol) = 0;
					//다시 for문 수행
					cnt = cnt + 1;
				}
			}else{
				break;
			}
		}
		
		rtnRow = lOfcEndRow;
	}
	
	var rtn = calcSumPerSC(sheetObj, row, wtCol);
	var rtnAry = rtn.split("|"); //scTotal, scEndRow
	sheetObj.CellValue2(rtnAry[1], wtCol) = rtnAry[0];
	
	return rtnRow;
}

//해당 그룹 내 cmpb가 가장 큰 row를 찾는다.
function findMaxCmpbRow(sheetObj, startRow, endRow, cmpbCol){
	for(var i=startRow; i<=endRow; i++){
		if(sheetObj.CellValue(i, "real_ibflag")!="D"){
			realStartRow = i;
			break;
		}
	}
	var maxRow = realStartRow;
	var maxCmpb = Number(sheetObj.CellValue(maxRow, cmpbCol));
	for(var i=realStartRow+1; i<=endRow; i++){
		if(!sheetObj.RowHidden(i)){
			var newCmpb = Number(sheetObj.CellValue(i, cmpbCol));
			if(newCmpb > maxCmpb){
				maxRow = i;
				maxCmpb = newCmpb;
			}
		}
	}
	return maxRow;
}

//해당 그룹 내 cmpb가 가장 작은 row를 찾는다.
function findMinCmpbRow(sheetObj, startRow, endRow, colPrefix){
	var realStartRow = "";
	var cmpbCol = colPrefix + "_cmpb";
	var wtCol = colPrefix + "_pfmc_wt";
	
	for(var i=startRow; i<=endRow; i++){
		if(sheetObj.CellValue(i, "real_ibflag")!="D" && Number(sheetObj.CellValue(i, wtCol))>0){
			realStartRow = i;
			break;
		}
	}
	var minRow = realStartRow;
	var minCmpb = Number(sheetObj.CellValue(minRow, cmpbCol));
	for(var i=realStartRow+1; i<=endRow; i++){
		if(!sheetObj.RowHidden(i) && Number(sheetObj.CellValue(i, wtCol))>0){
			var newCmpb = Number(sheetObj.CellValue(i, cmpbCol));
			if(newCmpb < minCmpb){
				minRow = i;
				minCmpb = newCmpb;
			}
		}
	}
	
	return minRow;
}

function calcSumPerSC(sheetObj, row, col){
	var scStartRow = 0;
	var scEndRow = 0;
	var scTotal = 0;
	
	if ( serchTrdCd == "AES" || serchTrdCd == "IAS"  ) {
		scStartRow = Number(sheetObj.GetMergedStartCell(row, "rfa_no").split(",")[0]);
		scEndRow = Number(sheetObj.GetMergedEndCell(row, "rfa_no").split(",")[0]);
	} else {
		scStartRow = Number(sheetObj.GetMergedStartCell(row, "sc_no").split(",")[0]);
		scEndRow = Number(sheetObj.GetMergedEndCell(row, "sc_no").split(",")[0]);
	}
	
	for(var i=scStartRow; i<scEndRow; i++){
		if(sheetObj.CellValue(i, "sls_rgn_ofc_cd")=="TTL"){
			scTotal = scTotal + Number(sheetObj.CellValue(i, col));
		}
	}
	var rtn = scTotal + "|" + scEndRow;
	return rtn;
}

function handlingPfmc(sheetObj, row, col){
	var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqTotal = 0;

	for(var i=rhqStartRow; i<rhqEndRow; i++){
		rhqTotal = rhqTotal + Number(sheetObj.CellValue(i, col));
	}
	
	//RHQ별 TOTAL 계산
	sheetObj.CellValue2(rhqEndRow, col) = rhqTotal;
	if(sheetObj.ColSaveName(col) != "rlane_qty"){
		//PFMC WK AVG 계산
		for(var i=rhqStartRow; i<=rhqEndRow; i++){
			sheetObj.CellValue2(i, "cust_qty") = rhqTotal;
			if(!sheetObj.RowHidden(i)){
				sheetObj.CellValue2(i, "real_ibflag") = "U";
			}
		}
	}
	
	//PFMC WK AVG 컬럼의 SC TTL 계산
	var rtn = calcSumPerSC(sheetObj, row, col);
	var rtnAry = rtn.split("|"); //scTotal, scEndRow
	if(sheetObj.ColSaveName(col) != "rlane_qty"){
		sheetObj.CellValue2(rtnAry[1], "cust_qty") = rtnAry[0];
	}
	sheetObj.CellValue2(rtnAry[1], col) = rtnAry[0];
	
	calcRatio(sheetObj, row, col);
	
	if(sheetObj.ColSaveName(col) != "rlane_qty"){
		calcPfmcWgt(sheetObj, "HO", row);
	}else{
		calcPfmcWgt(sheetObj, "RHQ", row);
	}
}

function checkUnitValue(sheetObj, row, col){
	var formObj = document.form;
	var unit = formObj.unit.value;
	
	var val = Number(sheetObj.CellValue(row, col));
	var checkVal = val*2 + "";
	if(unit == "F"){
		var rtn = ComIsNumber(checkVal);
		if(rtn == false){
			ComShowMessage("In case of FEU unit, you can only enter decimal point as 0.0 or 0.5");
			return rtn;
		}
	}
	return true;
}

/**
 * Sub Trd Add 시 처리
 * Row 추가후 데이터 copy 및 컬럼 제어
 * (Sub Trd 추가시 Office, TTL, SC/RFA TTL 세줄이 추가됨)
 * 
 * @param sheetObj 
 */
function handlingSubTrdScAdd(sheetObj){
	var formObj = document.form;
	var view_type = getRadioValue(document.form.view_type);
	var selectRow = sheetObj.SelectRow;
	var selectCol = sheetObj.SelectCol;
	
	//if(view_type == "H"){ //H/O
		// RHQ Add시
		if(sheetObj.ColSaveName(selectCol) == "sub_trd_cd"){
			var rowNum = Number(sheetObj.GetMergedEndCell(selectRow, "sub_trd_cd").split(",")[0]);
			// Row Add
			var newRow = sheetObj.DataInsert(rowNum);
			// Row Copy
			insertRow2(sheetObj, selectRow, newRow, view_type);
			// value 초기화
			sheetObj.CellValue2(newRow, "sub_trd_cd")       = " ";
			sheetObj.CellValue2(newRow, "sls_rhq_cd")       = " ";
			sheetObj.CellValue2(newRow, "cust_qty")         = "0";
			sheetObj.CellValue2(newRow, "smpl_cust_qty")    = "0";
			sheetObj.CellValue2(newRow, "cust_adj_qty")     = "0";
			sheetObj.CellEditable(newRow, "sub_trd_cd")     = true;
			sheetObj.CellEditable(newRow, "sls_rhq_cd")     = true;
			sheetObj.CellEditable(newRow, "cust_adj_qty")   = true;
			sheetObj.CellEditable(newRow, "sls_rgn_ofc_cd") = true;
			sheetObj.CellEditable(newRow, "strd_adj_qty")   = true;
			
	         //송민석 추가
            sheetObj.CellEditable(newRow, "rlane_cd")   = true;
            sheetObj.CellEditable(newRow, "rlane_adj_qty") = true;
            
			sheetObj.CellValue2(newRow, "real_ibflag")      = "I";
			sheetObj.CellValue2(newRow, "g1_cng_usr")       = "USER";
			sheetObj.CellValue2(newRow, "g2_cng_usr")       = "USER";
			
			// Row Add
			var newTotRow = sheetObj.DataInsert(newRow);
			// Row Copy
			insertRow2(sheetObj, rowNum, newTotRow, view_type);
			// value 초기화
			sheetObj.CellValue2(newTotRow, "sub_trd_cd")     = " ";
			sheetObj.CellValue2(newTotRow, "sls_rhq_cd")     = " ";
			sheetObj.CellValue2(newTotRow, "cust_qty")       = "0";
			sheetObj.CellValue2(newTotRow, "smpl_cust_qty")  = "0";
			sheetObj.CellValue2(newTotRow, "cust_adj_qty")   = "0";
			sheetObj.CellEditable(newTotRow, "sub_trd_cd")   = true;
			sheetObj.CellEditable(newTotRow, "sls_rhq_cd")   = true;
			sheetObj.CellEditable(newTotRow, "cust_adj_qty") = true;
			sheetObj.CellValue2(newTotRow, "sls_rgn_ofc_cd") = "TTL";
			sheetObj.CellValue2(newTotRow, "real_ibflag")    = "I";
			sheetObj.CellValue2(newTotRow, "g1_cng_usr")     = "USER";
			sheetObj.CellValue2(newTotRow, "g2_cng_usr")     = "USER";

			// Row Add
			var newScTotRow = sheetObj.DataInsert(newTotRow);
			// Row Copy
			insertRow2(sheetObj, rowNum, newScTotRow, view_type);
			// value 초기화
			if ( formObj.trade.Code == "TPS" ) {
				sheetObj.CellValue2(newScTotRow, "sub_trd_cd") = "SC TTL";
			} else if ( formObj.trade.Code == "AES" || formObj.trade.Code == "IAS") {
				sheetObj.CellValue2(newScTotRow, "sub_trd_cd") = "RFA TTL";
			} 
			sheetObj.CellValue2(newScTotRow, "sls_rhq_cd")     = "";
			sheetObj.CellValue2(newScTotRow, "cust_qty")       = "0";
			sheetObj.CellValue2(newScTotRow, "smpl_cust_qty")  = "0";
			sheetObj.CellValue2(newScTotRow, "cust_adj_qty")   = "0";
			sheetObj.CellValue2(newScTotRow, "sls_rgn_ofc_cd") = "TTL";
			sheetObj.CellValue2(newScTotRow, "real_ibflag")    = "";
			sheetObj.CellValue2(newScTotRow, "g1_cng_usr")     = "";
			sheetObj.CellValue2(newScTotRow, "g2_cng_usr")     = "";
			sheetObj.RowBackColor(newScTotRow) = sheetObj.RgbColor(180,252,131);

			sheetObj.selectCell(newRow, "sub_trd_cd");
			
		}else{
			ComShowMessage("Please click valid location to add Sub Trade.");
		}
	//}
}

/**
 * Sub Trd Add 시 처리
 * Row 추가후 데이터 copy 및 컬럼 제어
 * (Sub Trd 추가시 Office, TTL 두줄이 추가됨)
 * 
 * @param sheetObj 
 */
function handlingSubTrdAdd(sheetObj){
	var formObj = document.form;
	var view_type = "R"; //getRadioValue(document.form.view_type);
	var selectRow = sheetObj.SelectRow;
	var selectCol = sheetObj.SelectCol;
	//송민석 수정
	//if(view_type == "H"){ //H/O
		// RHQ Add시
		if(sheetObj.ColSaveName(selectCol) == "sub_trd_cd"){
			var rowNum = Number(sheetObj.GetMergedEndCell(selectRow, "sub_trd_cd").split(",")[0]);
			// Row Add
			var newRow = sheetObj.DataInsert(rowNum);
			// Row Copy
			insertRow2(sheetObj, selectRow, newRow, view_type);
			//송민석 추가
			sheetObj.CellValue2(newRow, "rlane_cd") = sheetObj.CellValue(selectRow, "rlane_cd");
			// value 초기화
			sheetObj.CellValue2(newRow, "sub_trd_cd")       = " ";
			sheetObj.CellValue2(newRow, "sls_rhq_cd")       = " ";
			sheetObj.CellValue2(newRow, "cust_qty")         = "0";
			sheetObj.CellValue2(newRow, "smpl_cust_qty")    = "0";
			sheetObj.CellValue2(newRow, "cust_adj_qty")     = "0";
			sheetObj.CellEditable(newRow, "sub_trd_cd")     = true;
			sheetObj.CellEditable(newRow, "sls_rhq_cd")     = true;
			sheetObj.CellEditable(newRow, "cust_adj_qty")   = true;
			sheetObj.CellEditable(newRow, "sls_rgn_ofc_cd") = true;
			sheetObj.CellEditable(newRow, "strd_adj_qty")   = true;
			//송민석 추가
	         sheetObj.CellEditable(newRow, "rlane_cd")   = true;
	         sheetObj.CellEditable(newRow, "rlane_adj_qty") = true;
 
			sheetObj.CellValue2(newRow, "real_ibflag")      = "I";
			sheetObj.CellValue2(newRow, "g1_cng_usr")       = "USER";
			sheetObj.CellValue2(newRow, "g2_cng_usr")       = "USER";
			

			 
			// Row Add
			var newTotRow = sheetObj.DataInsert(newRow);
			// Row Copy
			insertRow2(sheetObj, rowNum, newTotRow, view_type);
			// value 초기화
			sheetObj.CellValue2(newTotRow, "sub_trd_cd")     = " ";
			sheetObj.CellValue2(newTotRow, "sls_rhq_cd")     = " ";
			sheetObj.CellValue2(newTotRow, "cust_qty")       = "0";
			sheetObj.CellValue2(newTotRow, "smpl_cust_qty")  = "0";
			sheetObj.CellValue2(newTotRow, "cust_adj_qty")   = "0";
			sheetObj.CellEditable(newTotRow, "sub_trd_cd")   = true;
			sheetObj.CellEditable(newTotRow, "sls_rhq_cd")   = true;
			sheetObj.CellEditable(newTotRow, "cust_adj_qty") = true;
			sheetObj.CellValue2(newTotRow, "sls_rgn_ofc_cd") = "TTL";
			sheetObj.CellValue2(newTotRow, "real_ibflag")    = "I";
			sheetObj.CellValue2(newTotRow, "g1_cng_usr")     = "USER";
			sheetObj.CellValue2(newTotRow, "g2_cng_usr")     = "USER";

			sheetObj.selectCell(newRow, "sub_trd_cd");
			
		}else{
			ComShowMessage("Please click valid location to add Sub Trade.");
		}
	//}
}

/**
 * RHQ/OFC/Lane Add 시 처리
 * Row 추가후 데이터 copy 및 컬럼 제어
 * (RHQ 추가시 Office, TTL 두줄이 추가됨)
 * 
 * @param sheetObj 
 */
function handlingAdd(sheetObj,objName){
	var formObj = document.form;
	var view_type = getRadioValue(document.form.view_type);
	var selectRow = sheetObj.SelectRow;
	var selectCol = sheetObj.SelectCol;
	//alert(sheetObj.ColSaveName(selectCol))
	//송민석 수정
	//if(view_type == "H"){ //H/O
	if( objName=="btn_ofc_lane_add" ){
		// RHQ Add시
		if(sheetObj.ColSaveName(selectCol) == "sls_rhq_cd"){
			var rowNum = Number(sheetObj.GetMergedEndCell(selectRow, "sls_rhq_cd").split(",")[0]);
			// Row Add
			var newRow = sheetObj.DataInsert(rowNum);
			// Row Copy
			insertRow2(sheetObj, selectRow, newRow, view_type);
			// value 초기화
			sheetObj.CellValue2(newRow, "sls_rhq_cd")       = " ";
			sheetObj.CellValue2(newRow, "cust_qty")         = "0";
			sheetObj.CellValue2(newRow, "smpl_cust_qty")    = "0";
			sheetObj.CellValue2(newRow, "cust_adj_qty")     = "0";
			sheetObj.CellEditable(newRow, "sls_rhq_cd")     = true;
			sheetObj.CellEditable(newRow, "cust_adj_qty")   = true;
			sheetObj.CellEditable(newRow, "sls_rgn_ofc_cd") = true;
			sheetObj.CellEditable(newRow, "strd_adj_qty")   = true;
			sheetObj.CellValue2(newRow, "real_ibflag")      = "I";
			sheetObj.CellValue2(newRow, "g1_cng_usr")       = "USER";
			sheetObj.CellValue2(newRow, "g2_cng_usr")       = "USER";
			
			// Row Add
			var newTotRow = sheetObj.DataInsert(newRow);
			// Row Copy
			insertRow2(sheetObj, rowNum, newTotRow, view_type);
			// value 초기화
			sheetObj.CellValue2(newTotRow, "sls_rhq_cd")     = " ";
			sheetObj.CellValue2(newTotRow, "cust_qty")       = "0";
			sheetObj.CellValue2(newTotRow, "smpl_cust_qty")  = "0";
			sheetObj.CellValue2(newTotRow, "cust_adj_qty")   = "0";
			sheetObj.CellEditable(newTotRow, "sls_rhq_cd")   = true;
			sheetObj.CellEditable(newTotRow, "cust_adj_qty") = true;
			sheetObj.CellValue2(newTotRow, "sls_rgn_ofc_cd") = "TTL";
			sheetObj.CellValue2(newTotRow, "real_ibflag")    = "I";
			sheetObj.CellValue2(newTotRow, "g1_cng_usr")     = "USER";
			sheetObj.CellValue2(newTotRow, "g2_cng_usr")     = "USER";

			sheetObj.selectCell(newRow, "sls_rhq_cd");
			
		// Office Add 시
		}else if(sheetObj.ColSaveName(selectCol) == "sls_rgn_ofc_cd" && sheetObj.CellValue(selectRow, selectCol) != "TTL"){
			var newRow = sheetObj.DataInsert(selectRow);
			insertRow2(sheetObj, selectRow, newRow, view_type);
			sheetObj.CellEditable(newRow, "sls_rgn_ofc_cd") = true;
			sheetObj.CellEditable(newRow, "strd_adj_qty")   = true;
			sheetObj.CellValue2(newRow, "real_ibflag")      = "I";
			
			var rhqEndRow = Number(sheetObj.GetMergedEndCell(newRow, "sls_rhq_cd").split(",")[0]);
			sheetObj.CellValue2(newRow, "g2_cng_usr")    = "USER";
			sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "USER";
			
			sheetObj.selectCell(newRow, "sls_rgn_ofc_cd");
		}else{
			ComShowMessage("Please click valid location to add RHQ/office.");
		}
	}else{
	//}else{
		if(sheetObj.ColSaveName(selectCol) == "rlane_cd" && sheetObj.CellValue(selectRow, selectCol) != "TTL"){
			if(sheetObj.CellValue(selectRow, "rev_lane_cust_cnt") == "0"){
				ComShowMessage("Save H/O first.");
				return;
			}
			var newRow = sheetObj.DataInsert(selectRow);
			insertRow2(sheetObj, selectRow, newRow, view_type);
			sheetObj.CellEditable(newRow, selectCol) = true;
			sheetObj.CellEditable(newRow, "rlane_adj_qty") = true;
			sheetObj.CellValue2(newRow, "real_ibflag") = "I";
		}else{
			ComShowMessage("Please click valid location to add lane.");
		}
	}
	//}
}

/**
 * RHQ/OFC/Lane Delete 시 처리
 * Row의 상태를 D로 변경하고 RowHidden 시킨다.
 * 
 * @param sheetObj
 */
function handlingDel(sheetObj,srcName){
	var formObj = document.form;
	var view_type = getRadioValue(document.form.view_type);
	var selectRow = sheetObj.SelectRow;
	var selectCol = sheetObj.SelectCol;
	
	//if(view_type == "H"){ //H/O
	if( srcName == "btn_ofc_lane_del"){
		// Sub Trade Delete 시
		if(sheetObj.ColSaveName(selectCol) == "sub_trd_cd"){
			// TTL 데이터 부터 삭제
			var subTrdStartRow = Number(sheetObj.GetMergedStartCell(selectRow, "sub_trd_cd").split(",")[0]);
			var subTrdEndRow = Number(sheetObj.GetMergedEndCell(selectRow, "sub_trd_cd").split(",")[0]);
			if(ComShowConfirm("Do you want to delete this Sub Trade?")){
				for(var i=subTrdEndRow;  i>= subTrdStartRow; i--){
					if(sheetObj.CellValue(i, "real_ibflag") != "I"){
						sheetObj.CellValue(i, "cust_qty")     = 0; //event 발생시켜서 total을 0으로.
						sheetObj.CellValue(i, "strd_adj_qty") = 0; //event 발생시켜서 total을 0으로.
						sheetObj.CellValue(i, "strd_qty")     = 0; //event 발생시켜서 total을 0으로.
						sheetObj.CellValue2(i, "real_ibflag") = "D";
						sheetObj.CellValue2(i, "g1_cng_usr")  = "USER";
						sheetObj.CellValue2(i, "g2_cng_usr")  = "USER";
					}
				}
				
				//물량을 바꾸면서 real_ibflag가 D-> U로 바뀌는 경우가 발생하여 다시한번 real_ibflag를 D로 세팅해줌
				var subTrdStartRow1 = Number(sheetObj.GetMergedStartCell(selectRow, "sub_trd_cd").split(",")[0]);
				var subTrdEndRow1 = Number(sheetObj.GetMergedEndCell(selectRow, "sub_trd_cd").split(",")[0]);
				for(var i=subTrdEndRow1;  i>= subTrdStartRow1; i--){
					if(sheetObj.CellValue(i, "real_ibflag") == "I"){
						sheetObj.RowDelete(i, false);
					}else{
						sheetObj.CellValue2(i, "real_ibflag") = "D";
						sheetObj.CellValue2(i, "g1_cng_usr")  = "USER";
						sheetObj.CellValue2(i, "g2_cng_usr")  = "USER";
						sheetObj.RowHidden(i) = true;
					}	
				}
				
			}
		// RHQ Delete 시
		}else if(sheetObj.ColSaveName(selectCol) == "sls_rhq_cd"){
			// TTL 데이터 부터 삭제 (Office 부터 삭제를하면 삭제되는순간 Row nuber가 변경되어 엉둥한 값이 삭제됨)
			var rhqStartRow = Number(sheetObj.GetMergedStartCell(selectRow, "sls_rhq_cd").split(",")[0]);
			var rhqEndRow = Number(sheetObj.GetMergedEndCell(selectRow, "sls_rhq_cd").split(",")[0]);

			if(ComShowConfirm("Do you want to delete this RHQ?")){
				for(var i=rhqEndRow;  i>= rhqStartRow; i--){
					if(sheetObj.CellValue(i, "real_ibflag") != "I"){
						//선택된 row는 hidden처리. strd_adj_qty는 0으로. real_ibflag는 d로. 그 이후에 계산되거나 영향받는 모든 경우, real_ibflag가 d인 것을 제외하는 로직이 들어가야 함. 숨긴애 빼고 ratio 다시 계산
						sheetObj.CellValue(i, "strd_adj_qty") = 0; //event 발생시켜서 total을 0으로.
						sheetObj.CellValue(i, "strd_qty")     = 0; //event 발생시켜서 total을 0으로.
						sheetObj.CellValue2(i, "real_ibflag") = "D";
						sheetObj.CellValue2(i, "g1_cng_usr")  = "USER";
						sheetObj.CellValue2(i, "g2_cng_usr")  = "USER";
					}
				}
				
				//물량을 바꾸면서 real_ibflag가 D-> U로 바뀌는 경우가 발생하여 다시한번 real_ibflag를 D로 세팅해줌
				var rhqStartRow1 = Number(sheetObj.GetMergedStartCell(selectRow, "sls_rhq_cd").split(",")[0]);
				var rhqEndRow1 = Number(sheetObj.GetMergedEndCell(selectRow, "sls_rhq_cd").split(",")[0]);
				
				for(var i=rhqEndRow1;  i>= rhqStartRow1; i--){
					if(sheetObj.CellValue(i, "real_ibflag") == "I"){
						sheetObj.RowDelete(i, false);
					}else{
						sheetObj.CellValue2(i, "real_ibflag") = "D";
						sheetObj.CellValue2(i, "g1_cng_usr")  = "USER";
						sheetObj.CellValue2(i, "g2_cng_usr")  = "USER";
						sheetObj.RowHidden(i) = true;
					}	
				}
				
			}
			
		}else if(sheetObj.ColSaveName(selectCol) == "sls_rgn_ofc_cd" && sheetObj.CellValue(selectRow, selectCol) != "TTL"){
		// Office Delete 시
			if(ComShowConfirm("Do you want to delete this office?")){
				if(sheetObj.CellValue(selectRow, "real_ibflag")=="I"){
					sheetObj.RowDelete(selectRow, false);
				}else{
					//선택된 row는 hidden처리. strd_adj_qty는 0으로. real_ibflag는 d로. 그 이후에 계산되거나 영향받는 모든 경우, real_ibflag가 d인 것을 제외하는 로직이 들어가야 함. 숨긴애 빼고 ratio 다시 계산
					sheetObj.CellValue(selectRow, "strd_adj_qty") = 0; //event 발생시켜서 total을 0으로.
					sheetObj.CellValue(selectRow, "strd_qty") = 0; //event 발생시켜서 total을 0으로.
					sheetObj.CellValue2(selectRow, "real_ibflag") = "D";
					sheetObj.CellValue2(selectRow, "g2_cng_usr") = "USER";
					sheetObj.RowHidden(selectRow) = true;
				}
				
				var rhqStartRow = Number(sheetObj.GetMergedStartCell(selectRow, "sls_rhq_cd").split(",")[0]);
				var rhqEndRow = Number(sheetObj.GetMergedEndCell(selectRow, "sls_rhq_cd").split(",")[0]);
				
				var cnt=0;
				for(var i=rhqStartRow;  i< rhqEndRow; i++){
					if(sheetObj.CellValue(i, "g2_cng_usr") == "USER"){
						cnt++;
					}
				}
				if(cnt==0){
					sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "";
				}else{
					sheetObj.CellValue2(rhqEndRow, "g2_cng_usr") = "USER";
				}
				
			}
		}else{
			ComShowMessage("Please click valid location to delete Sub Trade/RHQ/office.");
		}
//	}else if(view_type == "R"){ //RHQ
	}else{
		if(sheetObj.ColSaveName(selectCol) == "rlane_cd" && sheetObj.CellValue(selectRow, "sls_rgn_ofc_cd") != "TTL"){
			if(sheetObj.CellValue(selectRow, "rev_lane_cust_cnt") == "0"){
				ComShowMessage("Save H/O first.");
				return;
			}
			if(ComShowConfirm("Do you want to delete this lane?")){
				if(sheetObj.CellValue(selectRow, "real_ibflag")=="I"){
					sheetObj.RowDelete(selectRow, false);
				}else{
					sheetObj.CellValue(selectRow, "rlane_adj_qty") = 0;
					sheetObj.CellValue(selectRow, "rlane_qty") = 0;
					sheetObj.CellValue2(selectRow, "real_ibflag") = "D";
					sheetObj.CellValue2(selectRow, "g3_cng_usr") = "USER";
					sheetObj.RowHidden(selectRow) = true;
				}
				
				//sc total 계산
				var rtn = calcSumPerSC(sheetObj, selectRow, "rlane_adj_qty");
				var rtnAry = rtn.split("|"); //scTotal, scEndRow
				sheetObj.CellValue2(rtnAry[1], "rlane_adj_qty") = rtnAry[0];
				
				var rhqStartRow = Number(sheetObj.GetMergedStartCell(selectRow, "sls_rhq_cd").split(",")[0]);
				var rhqEndRow = Number(sheetObj.GetMergedEndCell(selectRow, "sls_rhq_cd").split(",")[0]);
				
				var cnt=0;
				for(var i=rhqStartRow;  i< rhqEndRow; i++){
					if(sheetObj.CellValue(i, "g3_cng_usr") == "USER"){
						cnt++;
					}
				}
				if(cnt==0){
					sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "";
				}else{
					sheetObj.CellValue2(rhqEndRow, "g3_cng_usr") = "USER";
					setCngOfcList(sheetObj, selectRow);
				}
			}
		}else{
			ComShowMessage("Please click valid location to delete lane.");
		}
	}
}

function handlingReuse(sheetObj){
	var formObj = document.form;
	//var view_type = getRadioValue(document.form.view_type);

	if(formObj.incl_del.checked == false) return;
	//송민석
	//if(view_type == "L") return;
	
	var selectRow = sheetObj.SelectRow;
	var selectCol = sheetObj.SelectCol;
	
	if(sheetObj.CellBackColor(selectRow, selectCol) == sheetObj.RgbColor(192,192,192)){
		//reuse history를 위해 add하는 경우와 동일하게 cng_usr 사용
	    //송민석
//		if(view_type == "H"){
//			sheetObj.CellValue2(selectRow, "g2_cng_usr") = "USER";
//		}else if(view_type == "R"){
			sheetObj.CellValue2(selectRow, "g3_cng_usr") = "USER";
			sheetObj.CellValue2(selectRow, "cng_ofc_list") = sheetObj.CellValue(selectRow, "sls_rgn_ofc_cd");
//		}
		
		var param = "cost_yrwk=" 		+ formObj.season.Code
			      + "&ver_seq="  		+ formObj.version.Code
			      + "&trd_cd="   		+ sheetObj.CellValue(selectRow, "trd_cd")
			      + "&sub_trd_cd=" 		+ sheetObj.CellValue(selectRow, "sub_trd_cd")
			      + "&sls_rhq_cd=" 		+ sheetObj.CellValue(selectRow, "sls_rhq_cd")
			      + "&sls_rgn_ofc_cd=" 	+ sheetObj.CellValue(selectRow, "sls_rgn_ofc_cd")
			      + "&cust_cnt_cd=" 	+ sheetObj.CellValue(selectRow, "cust_cnt_cd")
			      + "&cust_seq=" 		+ sheetObj.CellValue(selectRow, "cust_seq")
			      + "&ctrt_ofc_cd=" 	+ sheetObj.CellValue(selectRow, "ctrt_ofc_cd")
			      + "&sc_no="    		+ sheetObj.CellValue(selectRow, "sc_no")
			      + "&rfa_no="    		+ sheetObj.CellValue(selectRow, "rfa_no")
			      //history 저장을 위한 인자
			      + "&cust_ctrl_cd="    + sheetObj.CellValue(selectRow, "cust_ctrl_cd")
			      + "&cust_adj_qty="    + sheetObj.CellValue(selectRow, "cust_adj_qty")
			      ;
		//송민석
//		if(view_type == "H"){
//			//history 저장을 위한 인자
//			param = param + "&g2_cng_usr=" 	  + sheetObj.CellValue(selectRow, "g2_cng_usr");
//		}
		//송민석
		//if(view_type == "R"){
			               //RHQ에서 REUSE시 RLANE_CD 인자 가지고감.
			param = param + "&rlane_cd="	  +sheetObj.CellValue(selectRow, "rlane_cd")
						  //history 저장을 위한 인자	
						  + "&rlane_adj_qty=" +sheetObj.CellValue(selectRow, "rlane_adj_qty") //어차피 0
			              + "&g3_cng_usr="	  +sheetObj.CellValue(selectRow, "g3_cng_usr");
		//}
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_SPC_0090GS.do", "f_cmd=" + (MULTI03) + "&" + param);
		ComOpenWait(false);
		if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
			ComShowMessage("Reused successfully.");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
}

function insertRow2(sheetObj, selectRow, newRow, view_type){
	sheetObj.CellValue2(newRow, "trd_cd") = sheetObj.CellValue(selectRow, "trd_cd"); //hidden
	sheetObj.CellValue2(newRow, "cust_cnt_cd") = sheetObj.CellValue(selectRow, "cust_cnt_cd"); //hidden
	sheetObj.CellValue2(newRow, "cust_seq") = sheetObj.CellValue(selectRow, "cust_seq"); //hidden
	sheetObj.CellValue2(newRow, "acct_clss_cd") = sheetObj.CellValue(selectRow, "acct_clss_cd");
	sheetObj.CellValue2(newRow, "cust_grp_nm") = sheetObj.CellValue(selectRow, "cust_grp_nm");
	sheetObj.CellValue2(newRow, "cust_lgl_eng_nm") = sheetObj.CellValue(selectRow, "cust_lgl_eng_nm");
	sheetObj.CellValue2(newRow, "ctrt_ofc_cd") = sheetObj.CellValue(selectRow, "ctrt_ofc_cd");
	sheetObj.CellValue2(newRow, "sc_no") = sheetObj.CellValue(selectRow, "sc_no");
	sheetObj.CellValue2(newRow, "rfa_no") = sheetObj.CellValue(selectRow, "rfa_no");
	sheetObj.CellValue2(newRow, "wk_mqc_qty") = sheetObj.CellValue(selectRow, "wk_mqc_qty");
	sheetObj.CellValue2(newRow, "cust_ctrl_cd") = sheetObj.CellValue(selectRow, "cust_ctrl_cd");
	sheetObj.CellValue2(newRow, "sub_trd_cd") = sheetObj.CellValue(selectRow, "sub_trd_cd");
	sheetObj.CellValue2(newRow, "sls_rhq_cd") = sheetObj.CellValue(selectRow, "sls_rhq_cd");
	sheetObj.CellValue2(newRow, "cust_qty") = sheetObj.CellValue(selectRow, "cust_qty");
	sheetObj.CellValue2(newRow, "smpl_cust_qty") = sheetObj.CellValue(selectRow, "smpl_cust_qty");
	sheetObj.CellValue2(newRow, "cust_adj_qty") = sheetObj.CellValue(selectRow, "cust_adj_qty");
	sheetObj.CellValue2(newRow, "sc_rfa_flg") = sheetObj.CellValue(selectRow, "sc_rfa_flg");
	

	
// 송민석
//	if(view_type == "R"){ //RHQ
		sheetObj.CellValue2(newRow, "sls_rgn_ofc_cd") = sheetObj.CellValue(selectRow, "sls_rgn_ofc_cd");
		sheetObj.CellValue2(newRow, "strd_adj_qty") = sheetObj.CellValue(selectRow, "strd_adj_qty");
//	}
}

function dupOfcChk(sheetObj, row, col){
	var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
	for(var i=rhqStartRow; i<rhqEndRow; i++){
		if(i==row) continue;
		if(!sheetObj.RowHidden(i)){
			if(sheetObj.CellValue(i, col) == sheetObj.CellValue(row, col)){
				ComShowMessage("There is duplicated data.");
				sheetObj.SelectCell(i, col);
				return false;
			}
		}
	}
	return true;
}
/**
 *  중복된 Sub Trade가 있는지 확인
 *  
 * @param sheetObj
 * @param row
 * @param col
 * @returns {Boolean}
 */
function dupSubTrdChk(sheetObj, row, col){
	var StartRow = "";
	var EndRow = "";
	if ( serchTrdCd == "AES" || serchTrdCd == "IAS"  ) {
		StartRow = Number(sheetObj.GetMergedStartCell(row, "rfa_no").split(",")[0]);
		EndRow = Number(sheetObj.GetMergedEndCell(row, "rfa_no").split(",")[0]);
	} else {
		StartRow = Number(sheetObj.GetMergedStartCell(row, "sc_no").split(",")[0]);
		EndRow = Number(sheetObj.GetMergedEndCell(row, "sc_no").split(",")[0]);
	}
	
	var cnt = 0;
	var subTrdEndRow = Number(sheetObj.GetMergedEndCell(row, "sub_trd_cd").split(",")[0]);

	for(var i=StartRow; i<EndRow; i++){
		var findTxt = sheetObj.FindText('sls_rgn_ofc_cd', "TTL", i);
		// Delete Row가 아니고, 변경한 RHQ의 TTL이 아니고 TTL을 못찾았을때를 제외하고 CNT를 증가
		// 즉 지금 변경된 RHQ를 제외한 다른 RHQ그룹을 검색해서 중복된 데이터가 있는지 확인
		if(!sheetObj.RowHidden(findTxt) && findTxt != -1 && subTrdEndRow!=findTxt){
			if(sheetObj.CellValue(findTxt, col) == sheetObj.CellValue(row, col)){
				cnt++;
			}
			i=findTxt;
		}
	}
	if (cnt>0){
		ComShowMessage("There is duplicated data.");
		sheetObj.SelectCell(i, col);
		return false;
	}
	return true;
}
/**
 *  중복된 RHQ가 있는지 확인
 *  
 * @param sheetObj
 * @param row
 * @param col
 * @returns {Boolean}
 */
function dupRHQChk(sheetObj, row, col){
	var StartRow = Number(sheetObj.GetMergedStartCell(row, "sub_trd_cd").split(",")[0]);
	var EndRow = Number(sheetObj.GetMergedEndCell(row, "sub_trd_cd").split(",")[0]);
	var cnt = 0;
	var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);

	for(var i=StartRow; i<EndRow; i++){
		var findTxt = sheetObj.FindText('sls_rgn_ofc_cd', "TTL", i);
		// Delete Row가 아니고, 변경한 RHQ의 TTL이 아니고 TTL을 못찾았을때를 제외하고 CNT를 증가
		// 즉 지금 변경된 RHQ를 제외한 다른 RHQ그룹을 검색해서 중복된 데이터가 있는지 확인
		if(!sheetObj.RowHidden(findTxt) && findTxt != -1 && rhqEndRow!=findTxt){
			if(sheetObj.CellValue(findTxt, col) == sheetObj.CellValue(row, col)){
				cnt++;
			}
			i=findTxt;
		}
	}
	if (cnt>0){
		ComShowMessage("There is duplicated data.");
		sheetObj.SelectCell(i, col);
		return false;
	}
	return true;
}

function dupLaneChk(sheetObj, row, col){
	var lOfcStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rgn_ofc_cd").split(",")[0]);
	var lOfcEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rgn_ofc_cd").split(",")[0]);
	for(var i=lOfcStartRow; i<=lOfcEndRow; i++){
		if(i==row) continue;
		if(!sheetObj.RowHidden(i)){
			if(sheetObj.CellValue(i, col) == sheetObj.CellValue(row, col)){
				ComShowMessage("There is duplicated data.");
				sheetObj.SelectCell(i, col);
				return false;
			}
		}
	}
	return true;
}

function confirmData() {
	var formObj = document.form;
	var firSts = formObj.version.GetText(1,1);
	var firStWk = "";
	var firExptWk ="";
	if(firSts == "Confirmed"){
		firStWk = formObj.version.GetText(1,2).split("~")[0];
        firExptWk = formObj.version.GetText(1,3) ;

	}
	if( firExptWk != ""){
	    var arr = firExptWk.split(",");
	    firExptWk = "";
	    for(var i = 0 ; i < arr.length;i++){
	        if( i != 0 ){
	            firExptWk = firExptWk+",";
	        }
	        firExptWk = firExptWk+"20"+arr[i];
	    }
	    
	}
	//빈칸없애야할지도.
	var param = "cfm_ver_prd_to="+document.form.cfm_ver_prd_to.value+"&src=CONFIRM"+"&fir_vir_st_wk="+firStWk+"&expt_yrwk="+firExptWk;
	//alert(param)
	var popup = window.showModalDialog("ESM_SPC_0099.do?"+param, window, "dialogWidth:400px;dialogHeight:160px;scroll:no");
	//alert(popup)
	if(popup!="" && popup!=undefined){
		var trade = formObj.trade.Code;
		var season = formObj.season.Code;
		var version = formObj.version.Code;
		var rtn   = popup.split("|");
		//confirm 서버 로직 타러 가야함.
		var sParam = "trade=" + trade
					+ "&cost_yrwk=" + season
					+ "&ver_seq=" + version
					+ "&from=" + rtn[0]
					+ "&to=" + rtn[1]
		            + "&expt_yrwk=" + rtn[2];
//alert(sParam)
		ComOpenWait(true);
		var sXml = sheetObjects[0].GetSaveXml("ESM_SPC_0090GS.do", "f_cmd=" + (MULTI01) + "&" + sParam);
		ComOpenWait(false);
		if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
			ComShowMessage("Confirmed successfully.");
		}else{
			ComShowCodeMessage('COM132101');
		}
		clearAll();
		formObj.trade.Code = trade;
	}
}

var trdCd = "";
function creationData() {
	var formObj = document.form;
	trdCd = formObj.trade.Code
	if(trdCd==""){
		ComShowMessage(getMsg("SPC90199", "Trade"));
		return;
	}
	var param = "src=CREATION";
	var popup = window.showModalDialog("ESM_SPC_0099.do?"+param, window, "dialogWidth:400px;dialogHeight:140px;scroll:no");
	
	if(popup!="" && popup!=undefined){
		var rtn   = popup.split("|");
		//creation 서버 로직 타러 가야함.
		var sParam = "from=" + rtn[0]
					+ "&to=" + rtn[1]
		            + "&expt_yrwk=" + rtn[2]
					+ "&trade=" + trdCd;
		ComOpenWait(true);
		var sXml = sheetObjects[0].GetSaveXml("ESM_SPC_0090GS.do?", "f_cmd=" + (MULTI02) + "&" + sParam + "&" + formObj.ctrl_grp_xml.value);
		
		
		var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
		
		if (backendJobKey != null && backendJobKey.length > 0) {
			ComSetObjValue(formObj.backendjob_key, backendJobKey);
			sheetObjects[0].RequestTimeOut = 3600; //초 - 1시간
			backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
		}
		
	}
}

function copyData() {
    var formObj = document.form;
    trdCd = formObj.trade.Code
    if(trdCd==""){
        ComShowMessage(getMsg("SPC90199", "Trade"));
        return;
    }
    var param = "src=COPY";
    var popup = window.showModalDialog("ESM_SPC_0099.do?"+param, window, "dialogWidth:400px;dialogHeight:160px;scroll:no");
    
    if(popup!="" && popup!=undefined){
        var rtn   = popup.split("|");
        //creation 서버 로직 타러 가야함.
        var trade = formObj.trade.Code;
        var season = formObj.season.Code;
        var version = formObj.version.Code;
        var rtn   = popup.split("|");
        //confirm 서버 로직 타러 가야함.
        var sParam = "trade=" + trade
                    + "&cost_yrwk=" + season
                    + "&ver_seq=" + version
                    + "&from=" + rtn[0]
                    + "&to=" + rtn[1]
  
        ComOpenWait(true);
        formObj.f_cmd.value = MULTI06;
        var sXml = sheetObjects[0].GetSaveXml("ESM_SPC_0090GS.do?", "f_cmd=" + (MULTI06) + "&" + sParam + "&" + formObj.ctrl_grp_xml.value);
        
        
        var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
        
        if (backendJobKey != null && backendJobKey.length > 0) {
            ComSetObjValue(formObj.backendjob_key, backendJobKey);
            sheetObjects[0].RequestTimeOut = 3600; //초 - 1시간
            backEndJobTimer = setInterval(getBackEndJobStatus, 5000);   //밀리초  - 10초
        }
        
    }
}

function regenerationData() {
	var formObj = document.form;
	trdCd = formObj.trade.Code
	if(trdCd==""){
		ComShowMessage(getMsg("SPC90199", "Trade"));
		return;
	}
	
	var seasonObj  = comObjects[1];	// Season Combo
	var seasonCode = seasonObj.Code;
	var prdTo      = seasonObj.GetText (seasonCode, 1);
	
	var param = "src=REGENERATION" + "&re_cre_prd_to=" + prdTo;
	
	var popup = window.showModalDialog("ESM_SPC_0099.do?"+param, window, "dialogWidth:400px;dialogHeight:140px;scroll:no");
	
	if(popup!="" && popup!=undefined){
		var rtn   = popup.split("|");
		
		// regeneration 서버 로직 타러 가야함.
		var sParam = "from=" + rtn[0]
					+ "&to=" + rtn[1]
					+ "&trade=" + trdCd
					+ "&cost_yrwk=" + formObj.season.Code
					+ "&ver_seq=" + formObj.version.Code;
		
		ComOpenWait(true);
		var sXml = sheetObjects[0].GetSaveXml("ESM_SPC_0090GS.do?", "f_cmd=" + (MULTI04) + "&" + sParam);
		
		var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
		
		if (backendJobKey != null && backendJobKey.length > 0) {
			ComSetObjValue(formObj.backendjob_key, backendJobKey);
			sheetObjects[0].RequestTimeOut = 3600; //초 - 1시간
			backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
		}
		
	}
}

function clearAll(){
	var formObj = document.form;
	sheetObjects[0].RemoveAll();
	comObjects[0].Code = "";
	comObjects[1].Code = "";
	comObjects[2].Code = "";
	comObjects[3].Code = "";
	formObj.incl_del.checked = false;
//	formObj.acct_clss.value = "";
	formObj.unit.value = "T";
	
	ComBtnDisable("btn_regeneration");
	ComBtnDisable("btn_confirm");
	ComBtnDisable("btn_import");
	ComBtnDisable("btn_amend");
	ComBtnDisable("btn_season_grp");
	ComBtnDisable("btn_save");
	
	//season 조회
//	var rtn = getCodeList("Season", "");
//	initData_season(rtn[0].split("|"), rtn[1].split("|"));
}

function checkRHQGuideSum(sheetObj){
	
	var i=sheetObj.HeaderRows;
	
	for(var j=sheetObj.HeaderRows; j<sheetObj.HeaderRows+sheetObj.RowCount; j++){
		var lOfcStartRow = Number(sheetObj.GetMergedStartCell(i, "sls_rgn_ofc_cd").split(",")[0]);
		var lOfcEndRow = Number(sheetObj.GetMergedEndCell(i, "sls_rgn_ofc_cd").split(",")[0]);
		var total = 0;
		
		for(var k=lOfcStartRow; k<=lOfcEndRow; k++){
			total = total + Number(sheetObj.CellValue(k, "rlane_adj_qty"));
		}
		if(Number(sheetObj.CellValue(lOfcEndRow, "strd_adj_qty")) < total){
			ComShowMessage("Sum Of [Lane Load Guide] must be smaller than [L.OFC Load Guide].\nPlease check again.");
			sheetObj.SelectCell(i, "rlane_adj_qty");
			return false;
		}
		
		i = Number(lOfcEndRow) + 1;
		if(i==Number(sheetObj.HeaderRows)+Number(sheetObj.RowCount)){
			break;
		}
	}
	return true;
}

function findRHQGuideSumMissmatch(sheetObj){
	var i=sheetObj.HeaderRows;
	var cnt = 0;
	
	for(var j=sheetObj.HeaderRows; j<sheetObj.HeaderRows+sheetObj.RowCount; j++){
		var lOfcStartRow = Number(sheetObj.GetMergedStartCell(i, "sls_rgn_ofc_cd").split(",")[0]);
		var lOfcEndRow = Number(sheetObj.GetMergedEndCell(i, "sls_rgn_ofc_cd").split(",")[0]);
		var total = 0;
		
		for(var k=lOfcStartRow; k<=lOfcEndRow; k++){
			total = total + Number(sheetObj.CellValue(k, "rlane_adj_qty"));
		}
		if(Number(sheetObj.CellValue(lOfcEndRow, "strd_adj_qty")) < total){
			if(sheetObj.CellValue(i, "sls_rgn_ofc_cd")!="TTL"){
				sheetObj.CellBackColor(i, "strd_adj_qty") = sheetObj.RgbColor(255,168,81); //orange
				cnt++;
			}
		}
		
		i = Number(lOfcEndRow) + 1;
		if(i==Number(sheetObj.HeaderRows)+Number(sheetObj.RowCount)){
			break;
		}
	}
	
	if(cnt>0){
		ComShowMessage("Sum Of [Lane Load Guide] must be smaller than [L.OFC Load Guide].\nPlease check again.")
	}
}

function sheet1_OnClick(sheetObj, row, col, value) {
	//remark 셀을 클릭했을때 MemoPad를 표시(L.OFC view이며 최신 version 경우 - 변경 가능. RHQ인 경우 - readOnly)
	//송민석
    //var view_type = getRadioValue(document.form.view_type);
	
	if (sheetObj.ColSaveName(col) == "spc_ctrl_mdl_rmk" && sheetObj.CellValue(row, "sls_rgn_ofc_cd") != "TTL") {
		//HO 최초 저장 이전에는 RHQ 또는 L.OFC 를 저장하지 못하도록 한다.(customer별로)
			// 	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)

	    //송민석
//		if(view_type=="L" && document.form.incl_del.checked==false && document.getElementById("sts").value=="Not Confirmed"){
//			if(sheetObj.CellValue(row, "rev_lane_cust_cnt") != "0"){
//				ComShowMemoPad(sheetObj, null, null, false, 500, null, 2000);
//			}else{
//				ComShowMessage("Save H/O first.");
//			}
//		}else if(view_type=="R" && document.form.incl_del.checked==false && sheetObj.CellEditable(row, "rlane_adj_qty")==true){
//			ComShowMemoPad(sheetObj, null, null, false, 500, null, 2000);
//		}else{
//			ComShowMemoPad(sheetObj, null, null, true, 500, null, 2000);
//		}
	    //송민석
	    if(document.form.incl_del.checked==false && sheetObj.CellEditable(row, "rlane_adj_qty")==true){
	        ComShowMemoPad(sheetObj, null, null, false, 500, null, 2000);
	    }
	}
}

function acct_cd_OnCheckClick(comboObj, index, code) {
	 if (code == "" || code == "All") {
		 var bChk = comboObj.CheckIndex(index);
		 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			 comboObj.CheckIndex(i) = bChk;
		 }
	 }else{
		 comboObj.CheckIndex(0) = false;
	 }
}

function setCngOfcList(sheetObj, row){
	var rhqStartRow = Number(sheetObj.GetMergedStartCell(row, "sls_rhq_cd").split(",")[0]);
	var rhqEndRow = Number(sheetObj.GetMergedEndCell(row, "sls_rhq_cd").split(",")[0]);
	var cngOfcList = "";
	for(var i=rhqStartRow; i<rhqEndRow; i++){
		if(sheetObj.CellValue(i, "g3_cng_usr") != ""){
			if(cngOfcList==""){
				cngOfcList = sheetObj.CellValue(i, "sls_rgn_ofc_cd");
			}else{
				cngOfcList = cngOfcList + "," + sheetObj.CellValue(i, "sls_rgn_ofc_cd");
			}
		}
	}
	sheetObj.CellValue2(rhqEndRow, "cng_ofc_list") = cngOfcList;
}

function enter(){
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if(keyValue != 13) return;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
*/     
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	ComOpenWait(true);
	var sXml = sheetObj.GetSearchXml("ESM_SPC_0090GS.do", "f_cmd=" + SEARCH04 + "&backendjob_key=" + formObj.backendjob_key.value);
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	var errMsg = ComGetEtcData(sXml, "jb_usr_err_msg");

	if (jobState == "3") {
		if(formObj.f_cmd.value == MULTI) {
			ComOpenWait(false);
			ComShowCodeMessage("COM130102", "Data");
			// BackEndJob을 종료시킴
			clearInterval(backEndJobTimer);
			if(document.getElementById("sts").value == "Confirmed"){
				var trade = document.form.trade.Code;
				clearAll();
				document.form.trade.Code = trade;
			}else{
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		} else if(formObj.f_cmd.value == MULTI06 ) {
			ComShowMessage("Data copy is completed.");
			clearInterval(backEndJobTimer);
			ComOpenWait(false);
			clearAll();
			document.form.trade.Code = trdCd;
		}else {
            ComShowMessage("Performance creation is completed.");
            clearInterval(backEndJobTimer);
            ComOpenWait(false);
            clearAll();
            document.form.trade.Code = trdCd;
        }
	} else if (jobState == "4") {
		ComShowMessage("BackEndJob Request Fail! - Error : " + errMsg);
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowMessage("Created BackEndJob File exist already!");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}   

/**
 * TRADE, SEASON 에 해당하는 CUSTOMER GROUP 정보를 보여준다.
 */
function setCustCtrlCd(sheetObj){
	var formObj = document.form;
	var arrData;
	
	var param = "trd_cd=" + formObj.trade.Code + "&cost_yrwk=" + formObj.season.Code;
	var rtn = getCodeXmlList("CustGrp", param);
	arrData = SpcXml2ComboItem(rtn, "code", "code|text");
	
	var cdDescTxt;
	if(arrData==undefined){
		cdDescTxt = "";
	}else{
		var cdDesc = arrData[1].replace(/\t/gi, " : ");
		var cdDescArr = cdDesc.split("|");
		for(var i=0; i<cdDescArr.length; i++){
			if(i==0){
				cdDescTxt = cdDescArr[i];
			}else{
				cdDescTxt = cdDescTxt + ", " + cdDescArr[i];
			}
		}
	}
	document.getElementById("ctrl_cd_desc").innerText = "* " + cdDescTxt;
}


/**
 * Yield Group 팝업 호출(ESM_SPC_0094)
 */
function yieldGrpPopup() {
	var formObj = document.form;
	var sheet1  = sheetObjects[0];
	
	var param = "cost_yrwk=" + ComGetObjValue(formObj.season)
	          + "&trd_cd="   + ComGetObjValue(formObj.trade)
	          + "&smp_main_popup=Y";
	
	ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=350,width=450,status=0");
}

/**
 * Amend 팝업 호출(ESM_SPC_0092)
 */
function amendPopup() {
	var formObj = document.form;
	var sheet1  = sheetObjects[0];
	
	var param = "trade="    + ComGetObjValue(formObj.trade)
	          + "&season="  + ComGetObjValue(formObj.season)
	          + "&version=" + ComGetObjValue(formObj.version);
	
	ComOpenWindow("ESM_SPC_0092.do?" + param, "Amend", "height=470,width=750,status=0");
}

/**
 * Amend 해야할 S/C, RFA 존재 여부 확인
 */
function checkAmendValue() {
	var formObj = document.form;
	var sheet1  = sheetObjects[0];
	
	var param = "trade="    + ComGetObjValue(formObj.trade)
	          + "&season="  + ComGetObjValue(formObj.season)
	          + "&version=" + ComGetObjValue(formObj.version);
	
	if (    ComGetObjValue(formObj.trade)   != ""
		 && ComGetObjValue(formObj.season)  != ""
	     && ComGetObjValue(formObj.version) != "" ) {
		doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
	} else {
		document.getElementById("btn_amend").style.color = "";
	}
}

/* 개발자 작업  끝 */