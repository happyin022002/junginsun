/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0967.js
*@FileTitle  : ESM_BKG_0967
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_BKG_0967 : ESM_BKG_0967 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var cntrCgoSeq=new Array(); // Cntr Cgo Seq 배열
var viewText=new Array();
viewText[0]="Feeder Name / Lloyd No"; 
viewText[1]="Barge Name / Lloyd No"; 
var viewText1=new Array();
viewText1[0]="On-Carriage Date<br> (YYYY-MM-DD)"; 
viewText1[1]="Pre-Carriage Date<br> (YYYY-MM-DD)"; 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn1_Retrieve":
			doActionIBSheet(sheetObjects[0],formObj,SEARCH03); 
			break;
		case "btn1_Save(CNTR)":
			formObj.save_type.value="1";
			doActionIBSheet(sheetObjects[0],formObj,MODIFY01); 
			break;
		case "btn1_Save(BKG)":
			formObj.save_type.value="2";
			doActionIBSheet(sheetObjects[0],formObj,MODIFY01);
			break;
		case "btn_popup1": // Forward 팝업
			var sUrl="/opuscntr/ESM_BKG_0969.do";
			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0969", 700, 400, true);
			if (rtnVal != null) {
				formObj.frm_anr_fwrd_id.value=rtnVal.cd;
				formObj.frm_fwrd_nm.value=rtnVal.nm;
			}
			break;
		case "btn_popup2": // UN number 팝업
			var sUrl="/opuscntr/ESM_BKG_0977.do";
			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0977", 1000, 400, true);
			//alert("rtnVal.cd : " + rtnVal.cd + "\n rtnVal.nm : " + rtnVal.nm.substring(0,3));
			if (rtnVal != null) {
				formObj.frm_imdg_un_no.value=rtnVal.cd;
				//formObj.frm_anr_spcl_tp_id.value = rtnVal.nm.substring(0,3);
				formObj.frm_anr_spcl_tp_id.value=rtnVal.nm;
			}
			break;
		case "btn_popup3": // Feeder 팝업
			comBkgCallPop1097("setFdrVslPopup");
			break;
		case "btn_popup4": // Un No 팝업
			var sUrl="ESM_BKG_0204.do?imdg_un_no=" + formObj.frm_imdg_un_no.value + "&bkg_no=" + formObj.frm_bkg_no.value;
			ComOpenPopup(sUrl, 920, 450, "setUnNo", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");

			break;
		case "btn1_DownExcel":
			break;
		case "btn1_back":
			var currIdx=getCurrIdxOfCntrCgoSeq();
			var totCnt=cntrCgoSeq.length;
			var disValue=currIdx;
			var setValue=cntrCgoSeq[currIdx - 1];			
			if(setValue != undefined && disValue >= 1 && disValue <= totCnt) {
				formObj.dis_cntr_cgo_seq.value=disValue + " / " + totCnt;
				formObj.cntr_cgo_seq.value=setValue;
			}
            doActionIBSheet(sheetObjects[0],formObj,SEARCH03); 
			break;
		case "btn1_next":
			var currIdx=getCurrIdxOfCntrCgoSeq();
			var totCnt=cntrCgoSeq.length;
			var disValue=currIdx + 2;
			var setValue=cntrCgoSeq[currIdx + 1];
			if(setValue != undefined && disValue >= 1 && disValue <= totCnt) {
				formObj.dis_cntr_cgo_seq.value=disValue + " / " + totCnt;
				formObj.cntr_cgo_seq.value=setValue;
			}
            doActionIBSheet(sheetObjects[0],formObj,SEARCH03); 
			break;
		case "btn_calendar" :
            var cal=new ComCalendar();
            cal.select(formObj.frm_crr_dt, 'yyyy-MM-dd');
            break;
		case "btn_close":
			closePage();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/** 
 * page 종료시
 * @return
 */
function closePage() {
	var formObj=document.form;
	window.returnValue=formObj.page_save_yn.value;
	ComClosePopup(); 
}

/**
 * cntrCgoSeq배열에 있는 현재 index를 리턴한다.
 * @return
 */
function getCurrIdxOfCntrCgoSeq() {
	var formObj=document.form;
	var currIdx=0;
	for(var i=0; i < cntrCgoSeq.length; i++) {
		//alert(i + " : " + cntrCgoSeq[i] + "\nformObj.p_cntr_cgo_seq.value : " + formObj.p_cntr_cgo_seq.value)
		if(cntrCgoSeq[i] == formObj.cntr_cgo_seq.value) {
			currIdx=i;
			break;
		}
	}
	return currIdx;
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(dType) {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    formObj.frm_ack_rcv_sts_cd.value= opener.document.form.ack_rcv_sts_cd_name.value;
    formObj.frm_ack_rcv_sts_cd.style.backgroundColor = opener.document.form.ack_rcv_sts_cd_name.style.backgroundColor;

	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	// Declaration Setting
	if(dType == "D") {
		formObj.d_type1[0].checked=true;
	} else if(dType == "T") {
		formObj.d_type1[1].checked=true;
	} else if(dType == "L") {
		formObj.d_type1[2].checked=true;
	} else if(dType == "P") {
		formObj.d_type1[3].checked=true;
	} else if(dType == "O") {
		formObj.d_type1[4].checked=true;
	} else if(dType == "DO") {
		formObj.d_type1[0].checked=true;
		formObj.d_type1[4].checked=true;
	} else if(dType == "PL") {
		formObj.d_type1[2].checked=true;
		formObj.d_type1[3].checked=true;
	}
	// 화면 필드 초기화
	fileldInit(formObj.ofcCd.value);
	var comboObjMaxLen=comboObjects.length;
	for (i=0; i < comboObjMaxLen; i++) {
		// IBCombo 초기화
		initCombo(comboObjects[i], i + 1);
	}
	// 해당 Bl에 속한 컨테이너와 리스트를 조회한다.(콤보 셋팅을 위해)  
	doActionIBSheet(sheetObjects[0],formObj,SEARCH01); 
	// 부모창에서 넘오온 Cgo seq를 셋팅한다.
	formObj.cntr_cgo_seq.value=formObj.p_cntr_cgo_seq.value; 
	var currIdx=getCurrIdxOfCntrCgoSeq();
	var totCnt=cntrCgoSeq.length;
	var disValue=currIdx+1;
	var setValue=cntrCgoSeq[currIdx];
	if(disValue >= 1 && disValue <= totCnt) {
		formObj.dis_cntr_cgo_seq.value=disValue + " / " + totCnt;
		formObj.cntr_cgo_seq.value=setValue;
	}
	// Danger cargo 정보를 컨테이너 단위로 조회한다. 
	doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
	if(formObj.call_gubun.value == "ESM_BKG_0965") {
		// ESM_BKG_0965에서 호출시 Carriage Date 필드 타이블 변경 (On-Carriage Date or Pre-Carriage) 
		if(dType == "D" || dType == "O" || dType == "DO" || dType == "T") {
			// On-Carriage Date
			layoutView1.innerHTML=viewText1[0];
		} else {
			// Pre-Carriage
			layoutView1.innerHTML=viewText1[1];
		}
	}
}
/**
 * 필드 활성화 / 비활성화 Log-In ID에 따라서
 * 
 * @param usrId
 * @return
 */
function fileldInit(ofcCd) {
}
/**
 * Combo Object 초기화
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1":
	    with(sheetObj){
      
      if (location.hostname != "")
      var HeadTitle1="|EUR_DG_DECL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|PORT_CD|BL_NO|CNTR_NO|CNTR_CGO_SEQ|POL_CD|POD_CD|CNTR_TPSZ_CD"+
      "|CELL_PSN_NO|ANR_ROLE_DIV_CD|ANR_FWRD_ID|ANR_FWRD_NM|ANR_CRR_TP_CD|CRR_DT|SVC_RQST_NO|FDR_SVC_RQST_NO|IMDG_PCK_GRP_CD|IMDG_CLSS_CD"+
      "|IMDG_UN_NO|IMDG_UN_NO_SEQ|ANR_SPCL_TP_ID|FLSH_PNT_CDO_TEMP|NET_WGT|GRS_WGT|MFAG_NO|PRP_SHP_NM|HZD_DESC|BRTH_YD_CD|BRTH_YD_NM"+
      "|IMDG_LMT_QTY_FLG|PCK_QTY|PCK_TP_CD|EUR_PCK_DESC|OUT_IMDG_PCK_QTY1|OUT_IMDG_PCK_CD1|EUR_OUTR_PCK_DESC|IN_IMDG_PCK_QTY1|IN_IMDG_PCK_CD1"+
      "|EUR_INR_PCK_DESC|EMS_NO|DCGO_PCK_GRP_CD1|EUR_DCGO_MRN_POLUT_CD|DIFF_RMK|HCDG_FLG|EMER_RSPN_GID_NO|NET_EXPLO_WGT|FDR_VVD_ID|FDR_VSL_NM"+
      "|FDR_VSL_LLOYD_NO|VSL_LODG_DT|XTD_STAY_PRMT_NO|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|IMDG_SUBS_RSK_LBL_CD1|IMDG_SUBS_RSK_LBL_CD2"+
      "|IMDG_SUBS_RSK_LBL_CD3|IMDG_SUBS_RSK_LBL_CD4|CGO_OPR_CD|APLY_NO|CRR_CD|EDW_UPD_DT|CNTR_REF_NO|DCGO_REF_NO|EMER_CNTC_PHN_NO"+
      "|EMER_CNTC_PSON_NM|BKG_NO|CNTR_TPSZ_ISO_CD|IMDG_COMP_GRP_CD|FWRD_NM|CNTR_NO_OLD|cstms_err_msg";
      var headCount=ComCountHeadTitle(HeadTitle1);
      (headCount, 0, 0, true);

      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"eur_dg_decl_tp_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"vsl_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"skd_voy_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"skd_dir_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"port_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"bl_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_cgo_seq" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"pol_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"pod_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_tpsz_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cell_psn_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"anr_role_div_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"anr_fwrd_id" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"anr_fwrd_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"anr_crr_tp_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"crr_dt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"svc_rqst_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"fdr_svc_rqst_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_pck_grp_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_clss_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_un_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_un_no_seq" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"anr_spcl_tp_id" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"flsh_pnt_cdo_temp" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"net_wgt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"grs_wgt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"mfag_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"prp_shp_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"hzd_desc" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"brth_yd_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"brth_yd_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_lmt_qty_flg" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"pck_qty" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"pck_tp_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"eur_pck_desc" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"out_imdg_pck_qty1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"out_imdg_pck_cd1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"eur_outr_pck_desc" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"in_imdg_pck_qty1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"in_imdg_pck_cd1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"eur_inr_pck_desc" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"ems_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"dcgo_pck_grp_cd1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"eur_dcgo_mrn_polut_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"diff_rmk" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"hcdg_flg" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"emer_rspn_gid_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"net_explo_wgt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"fdr_vvd_id" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"fdr_vsl_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"fdr_vsl_lloyd_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"vsl_lodg_dt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"xtd_stay_prmt_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cre_usr_id" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cre_dt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"upd_usr_id" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"upd_dt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_subs_rsk_lbl_cd1" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_subs_rsk_lbl_cd2" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_subs_rsk_lbl_cd3" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_subs_rsk_lbl_cd4" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cgo_opr_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"aply_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"crr_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"edw_upd_dt" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_ref_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"dcgo_ref_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"emer_cntc_phn_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"emer_cntc_pson_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"bkg_no" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_tpsz_iso_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"imdg_comp_grp_cd" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"fwrd_nm" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cntr_no_old" },
                   {Type:"Text", Hidden:0, Width:90, Align:"Center", SaveName:"cstms_err_msg" }  ];
      InitColumns(cols);
      SetSheetHeight(150);
      SetEditable(1);
      InitViewFormat(0, "crr_dt", "yyyymmdd");
      }
	  break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case SEARCH01: // Container Combo setting
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			if (sXml.length > 0) {
				ComBkgXml2ComboItem(sXml, comboObjects[0], "cntr_no", "cntr_no");
				comboObjects[0].SetSelectCode(formObj.p_cntr_no.value);// 부모창에서 받은 cntr_no를 초기값으로 셋팅한다.
				//formObj.cntr_cgo_seq.value = formObj.p_cntr_cgo_seq.value;
			}
			break;
		case SEARCH02:
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			var strCntrCgoSeq=ComBkgXml2ComboString(sXml, "cntr_cgo_seq", "cntr_cgo_seq");
			if(strCntrCgoSeq != undefined && strCntrCgoSeq != "") {
				cntrCgoSeq=strCntrCgoSeq[0].split("|");
				//alert("cntrCgoSeq.length : " + cntrCgoSeq.length);
				if(cntrCgoSeq.length > 0) {
					formObj.dis_cntr_cgo_seq.value="1 / " + cntrCgoSeq.length;
					formObj.cntr_cgo_seq.value=cntrCgoSeq[0];
				}
			}
			break;
		case SEARCH03:
			//sheetObj.ShowDebugMsg = true;
			formObj.f_cmd.value=SEARCH03;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(sheetObj.LastRow() > 0) IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				if(formObj.call_gubun.value == "ESM_BKG_0965") {
					formObj.frm_crr_dt.value=ComGetMaskedValue(formObj.frm_crr_dt.value, "ymd");
				}
				formObj.frm_net_explo_wgt.value=ComGetMaskedValue(formObj.frm_net_explo_wgt.value, "float");
				formObj.frm_out_imdg_pck_qty1.value=ComGetMaskedValue(formObj.frm_out_imdg_pck_qty1.value, "float");
				formObj.frm_in_imdg_pck_qty1.value=ComGetMaskedValue(formObj.frm_in_imdg_pck_qty1.value, "float");
				formObj.frm_net_wgt.value=ComGetMaskedValue(formObj.frm_net_wgt.value, "float");
				formObj.frm_grs_wgt.value=ComGetMaskedValue(formObj.frm_grs_wgt.value, "float");
			}
			//alert(">> [" + formObj.frm_imdg_lmt_qty_flg.value + "]");
			if(formObj.frm_eur_dcgo_mrn_polut_cd.value == "") {
				formObj.frm_eur_dcgo_mrn_polut_cd.value="";
			}
			if(formObj.frm_imdg_lmt_qty_flg.value == "") {
				formObj.frm_imdg_lmt_qty_flg.value="N";
			}
			if(formObj.frm_hcdg_flg.value == "") {
				formObj.frm_hcdg_flg.value="N";
			}
//			if(formObj.frm_brth_yd_cd.value == "") {
//				formObj.frm_brth_yd_cd.value=formObj.p_berth_cd.value;
//			}
//			if(formObj.frm_brth_yd_nm.value == "") {
//				formObj.frm_brth_yd_nm.value=formObj.p_berth_nm.value;
//			}
			var classCd=formObj.frm_imdg_clss_cd.value;
			formObj.frm_net_explo_wgt.className="input";
			formObj.frm_net_explo_wgt.dataformat="singledFloat"
			formObj.frm_net_explo_wgt.readOnly=false;
			var cgoOprCd=formObj.frm_cgo_opr_cd.value;
			if(cgoOprCd == "NYK") {
				formObj.frm_cntr_no.className="input2";
				formObj.frm_cntr_no.readOnly=true;
				ComBtnEnable("btn1_Save(BKG)");
			} else {
				formObj.frm_cntr_no.className="input";
				formObj.frm_cntr_no.readOnly=false;
                ComBtnDisable("btn1_Save(BKG)");
			}
			// 필드타이틀 변경
			if(formObj.call_gubun.value == "ESM_BKG_0965") {
				mandantoryChangByCarriageType();				
			}
			break;
		case SEARCH04 : // Berth Code로 Name을 조회한다.
			formObj.f_cmd.value=SEARCH04;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var yardName=ComGetEtcData(sXml, "yardName");
//			formObj.frm_brth_yd_nm.value=(yardName == undefined) ? "" : yardName;
			break;
		case SEARCH05 : // Forward Code로 Name을 조회한다.
			formObj.f_cmd.value=SEARCH05;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			var anrFwrdName=ComGetEtcData(sXml, "anrFwrdName");
			//alert("anrFwrdName : " + anrFwrdName );
			formObj.frm_fwrd_nm.value=(anrFwrdName == undefined) ? "" : anrFwrdName;
			break;
		case SEARCH06 : // UN NO로 NAME을 조회한다.
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			var imdgUnNoDesc=ComGetEtcData(sXml, "imdgUnNoDesc");
			formObj.frm_anr_spcl_tp_id.value=(imdgUnNoDesc == undefined) ? "" : imdgUnNoDesc;
			break;
		case MODIFY01 : // Save(the Container) or Save(the Whole BKG)
			if(!validateForm(sheetObj,formObj,sAction))return;
			var saveType=formObj.save_type.value;
			var msg="";
			if(saveType == "1") {
				//msg = "Container-Cago-Cago Seq 단위로 저장됩니다. 계속하시겠습니까?";
				msg="Container-Cago-Cago Seq";
			} else {
				//msg = "BL 단위로 저장됩니다. 계속하시겠습니까?";
				msg="B/L No";
			}
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			removeCommaOfNum();
			formObj.f_cmd.value=MODIFY01;
			var sParam=sheetObjects[0].GetSaveString();
			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}
            if(!ComShowConfirm(ComGetMsg("BKG06102", msg))) {
                return false;
            }
			sParam += "&" + FormQueryString(formObj);			
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0967GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			// 저장후 save Flag 셋팅
			formObj.page_save_yn.value="Y";
			break;
		case SEARCH07: // Feeder Name, Lloyd No Combo setting
			formObj.f_cmd.value=SEARCH07;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0967GS.do", FormQueryString(formObj));
			if (sXml.length > 0) {
				comboObjects[2].SetDropHeight(300);
				comboObjects[2].SetTitle("Feeder Name|Lloy No");
				ComBkgXml2ComboItem(sXml, comboObjects[2], "feeder_name", "feeder_lloyd_no");
//no support[check again]CLT 				comboObjects[2].ShowCol=1; 
			}
			break;
	} // end switch()
	fileldInit(formObj.ofcCd.value);
}
/**
 * Feeder Name, Lloyd No 리스트 콤보 변경시 이벤트
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function feeder_lloyd_list_OnChange(comboObj,value,text) {
	/*
	var formObj=document.form;
	var colArr=text.split("|");
	formObj.frm_fdr_vsl_nm.value=colArr[0];
	formObj.frm_fdr_vsl_lloyd_no.value=colArr[1];
	*/
}
/**
 * 컨테이너 리스트 콤보 변경시 이벤트
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cntr_list_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, newtext , newcode) {
	var formObj=document.form;
	formObj.cntr_no.value=newtext;
	doActionIBSheet(sheetObjects[0],formObj,SEARCH02); // CGO SEQ 조회
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case MODIFY01 :
			if(!ComChkObjValid(formObj.frm_cell_psn_no)) return false;
			if(formObj.frm_net_explo_wgt.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_net_explo_wgt.value,",", ""), 15, 3)) {
				ComShowCodeMessage("BKG00651", "Net Explosive Weight / KG");
				ComSetFocus(formObj.frm_net_explo_wgt);
				return false;
			}
			if(formObj.frm_flsh_pnt_cdo_temp.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_flsh_pnt_cdo_temp.value,",", ""), 5, 2)) {
				ComShowCodeMessage("BKG00651", "Flash Point");
				ComSetFocus(formObj.frm_flsh_pnt_cdo_temp);
				return false;
			}
			if(formObj.frm_net_wgt.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_net_wgt.value,",", ""), 15, 3)) {
				ComShowCodeMessage("BKG00651", "Net Weight");
				ComSetFocus(formObj.frm_net_wgt);
				return false;
			}
			if(formObj.frm_grs_wgt.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_grs_wgt.value,",", ""), 15, 3)) {
				ComShowCodeMessage("BKG00651", "Gross Weight");
				ComSetFocus(formObj.frm_grs_wgt);
				return false;
			}
			if(formObj.frm_out_imdg_pck_qty1.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_out_imdg_pck_qty1.value,",", ""), 9, 3)) {
				ComShowCodeMessage("BKG00651", "Outer Package Qty");
				ComSetFocus(formObj.frm_out_imdg_pck_qty1);
				return false;
			}
			if(formObj.frm_in_imdg_pck_qty1.value.length > 0 && !checkFloatType(ComReplaceStr(formObj.frm_in_imdg_pck_qty1.value,",", ""), 9, 3)) {
				ComShowCodeMessage("BKG00651", "Inner Package Qty");
				ComSetFocus(formObj.frm_in_imdg_pck_qty1);
				return false;
			}
			if(formObj.call_gubun.value == "ESM_BKG_0965") {
				var cType=formObj.frm_anr_crr_tp_cd.value;
				if(cType == "V") { // Marintim
					if(formObj.frm_fdr_svc_rqst_no.value == "") {
						ComShowCodeMessage("BKG01101", "SSR for Feeder transshipment");
						ComSetFocus(formObj.frm_fdr_svc_rqst_no);
						return false;
					}
					if(formObj.frm_fdr_vvd_id.value == "") {
						ComShowCodeMessage("BKG01101", "Feeder VVD");
						ComSetFocus(formObj.frm_fdr_vvd_id);   
						return false;
					}
					if(formObj.frm_fdr_vsl_nm.value == "") {
						ComShowCodeMessage("BKG01101", "Feeder Name");
						ComSetFocus(formObj.frm_fdr_vsl_nm);   
						return false;
					}
					if(formObj.frm_fdr_vsl_lloyd_no.value == "") {
						ComShowCodeMessage("BKG01101", "Lloyd No");
						ComSetFocus(formObj.frm_fdr_vsl_lloyd_no);   
						return false;
					}
				}
			}
			break;
	}
	return true;
}
/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
//	if(srcName == "frm_brth_yd_cd") { // Berth Code 필드값 변경시
//		//alert("frm_brth_yd_cd");
//		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
//	} else 
	    if(srcName == "frm_fwrd_cd") { // Forward Code 필드값 변경시
		doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
	} else if(srcName == "frm_anr_crr_tp_cd") { // Carriage Type 필드값 변경시
		mandantoryChangByCarriageType();
	}
	if(formObj.call_gubun.value == "ESM_BKG_0965") { // ANRBS화면에서  call한 경우
		if(srcName == "frm_imdg_un_no") { // Un No. 필드값 변경시
			doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
		}
	}
}
/**
 * 필드타이틀 변경 및 CarriageType이 Marintim일 경우 필수 필드 변경
 * @return
 */
function mandantoryChangByCarriageType() {
	var formObj=document.form;
	var cType=formObj.frm_anr_crr_tp_cd.value;
	// 필드 타이틀 변경
	if(cType == "B") { //Barge
		layoutView.innerHTML=viewText[1];
	} else {
		layoutView.innerHTML=viewText[0];
	}
	// Marintim일 경우 필수 필드 변경
	if(cType == "V") { // Marintim 일경우
		formObj.frm_fdr_svc_rqst_no.className="input1";
		formObj.frm_fdr_svc_rqst_no.readOnly=false;
		formObj.frm_fdr_vvd_id.className="input1";
		formObj.frm_fdr_vvd_id.readOnly=false;
		formObj.frm_fdr_vsl_nm.className="input1";
		formObj.frm_fdr_vsl_nm.readOnly=true;
		formObj.frm_fdr_vsl_lloyd_no.className="input1";
		formObj.frm_fdr_vsl_lloyd_no.readOnly=true;
		layoutView3.style.display="inline";
	} else {
		formObj.frm_fdr_svc_rqst_no.className="input2";
		formObj.frm_fdr_svc_rqst_no.readOnly=true;
		formObj.frm_fdr_svc_rqst_no.value="";
		formObj.frm_fdr_vvd_id.className="input2";
		formObj.frm_fdr_vvd_id.readOnly=true;
		formObj.frm_fdr_vvd_id.value="";
		formObj.frm_fdr_vsl_nm.className="input2";
		formObj.frm_fdr_vsl_nm.readOnly=true;
		formObj.frm_fdr_vsl_nm.value="";
		formObj.frm_fdr_vsl_lloyd_no.className="input2";
		formObj.frm_fdr_vsl_lloyd_no.readOnly=true;
		formObj.frm_fdr_vsl_lloyd_no.value="";
		layoutView3.style.display="none";
	}
}
/**
 * 저장 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    var formObj=document.form;
	if (ErrMsg == "") {
		ComShowCodeMessage('BKG00102');
		formObj.cntr_no.value = formObj.frm_cntr_no.value;
	} 
}
 /**
  * Un No 팝업 콜백 함수
  * @param rowArray
  * @return
  */
function setUnNo(rowArray) {
	var formObj=document.form;
	var colArray=rowArray[0];
	document.getElementById("frm_imdg_un_no").value=colArray[2];
	document.getElementById("frm_imdg_un_no_seq").value=colArray[3];
	document.getElementById("frm_imdg_clss_cd").value=colArray[4];
	document.getElementById("frm_imdg_comp_grp_cd").value=colArray[5];
	document.getElementById("frm_imdg_pck_grp_cd").value=colArray[6];
	document.getElementById("frm_prp_shp_nm").value=colArray[7];
	document.getElementById("frm_hzd_desc").value=colArray[9];
	document.getElementById("frm_ems_no").value=colArray[17];
}

function setCallBackFwrd(rowArray){
	document.getElementById("frm_anr_fwrd_id").value=rowArray.cd;
	document.getElementById("frm_fwrd_nm").value=rowArray.nm;
}
function setCallBackSpclTpId(rowArray){
	document.getElementById("frm_anr_spcl_tp_id").value=rowArray.nm;
}
function setFdrVslPopup(rowArray) {
	document.getElementById("frm_fdr_vsl_nm").value=rowArray.fdr_vsl_nm;
	document.getElementById("frm_fdr_vsl_lloyd_no").value=rowArray.fdr_vsl_lloyd_no;
}
function removeComma(val){
	ret = val.split(",").join("");
	return ret;
}
function removeCommaOfNum(){
	sheetObjects[0].SetCellValue(1, "net_explo_wgt", removeComma(sheetObjects[0].GetCellValue(1,"net_explo_wgt")), 0);
	sheetObjects[0].SetCellValue(1, "out_imdg_pck_qty1", removeComma(sheetObjects[0].GetCellValue(1,"out_imdg_pck_qty1")), 0);
	sheetObjects[0].SetCellValue(1, "flsh_pnt_cdo_temp", removeComma(sheetObjects[0].GetCellValue(1,"flsh_pnt_cdo_temp")), 0);
	sheetObjects[0].SetCellValue(1, "in_imdg_pck_qty1", removeComma(sheetObjects[0].GetCellValue(1,"in_imdg_pck_qty1")), 0);
	sheetObjects[0].SetCellValue(1, "net_wgt", removeComma(sheetObjects[0].GetCellValue(1,"net_wgt")), 0);
	sheetObjects[0].SetCellValue(1, "grs_wgt", removeComma(sheetObjects[0].GetCellValue(1,"grs_wgt")), 0);
}
