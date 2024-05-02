/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0967.js
 *@FileTitle : ESM_BKG_0967
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.31 경종윤
 * 1.0 Creation
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
 * @class ESM_BKG_0967 : ESM_BKG_0967 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0967() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var cntrCgoSeq = new Array(); // Cntr Cgo Seq 배열

var viewText = new Array();
viewText[0] = "Feeder Name / Lloyd No"; 
viewText[1] = "Barge Name / Lloyd No"; 

var viewText1 = new Array();
viewText1[0] = "On-Carriage Date<br> (YYYY-MM-DD)"; 
viewText1[1] = "Pre-Carriage Date<br> (YYYY-MM-DD)"; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn1_Retrieve":
			doActionIBSheet(sheetObjects[0],formObj,SEARCH03); 
			break;
		case "btn1_Save(CNTR)":
			formObj.save_type.value = "1";
			doActionIBSheet(sheetObjects[0],formObj,MODIFY01); 
			break;

		case "btn1_Save(BKG)":
			formObj.save_type.value = "2";
			doActionIBSheet(sheetObjects[0],formObj,MODIFY01);
			break;

		case "btn1_GWMail":
			doActionIBSheet(sheetObjects[0],formObj,COMMAND01); 
			break;

		case "btn_popup1": // Forward 팝업
			var sUrl = "/hanjin/ESM_BKG_0969.do";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0969", 600, 400, true);
			if (rtnVal != null) {
				formObj.frm_anr_fwrd_id.value = rtnVal.cd;
				formObj.frm_fwrd_nm.value = rtnVal.nm;
			}
			break;

		case "btn_popup2": // UN number 팝업
			var sUrl = "/hanjin/ESM_BKG_0977.do";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0977", 600, 400, true);
			
			
			//alert("rtnVal.cd : " + rtnVal.cd + "\n rtnVal.nm : " + rtnVal.nm.substring(0,3));
			
			
			if (rtnVal != null) {
				formObj.frm_imdg_un_no.value = rtnVal.cd;
				//formObj.frm_anr_spcl_tp_id.value = rtnVal.nm.substring(0,3);
				formObj.frm_anr_spcl_tp_id.value = rtnVal.nm;
			}
			
			
			break;
			
		case "btn_popup3": // Feeder 팝업
			var sUrl = "/hanjin/ESM_BKG_1097.do";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1097", 600, 400, true);
			if (rtnVal != null) {
				formObj.frm_fdr_vsl_lloyd_no.value = rtnVal.cd;
				formObj.frm_fdr_vsl_nm.value = rtnVal.nm;
			}
			break;
			
		case "btn_popup4": // Un No 팝업
			var sUrl = "ESM_BKG_0204.do?imdg_un_no=" + formObj.frm_imdg_un_no.value + "&bkg_no=" + formObj.frm_bkg_no.value;
//			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1097", 600, 400, true);
//			if (rtnVal != null) {
//				formObj.frm_fdr_vsl_lloyd_no.value = rtnVal.cd;
//				formObj.frm_fdr_vsl_nm.value = rtnVal.nm;
//			}
			
			ComOpenPopup(sUrl, 920, 450, "setUnNo", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			//ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + formObject.imdg_un_no.value + "&bkg_no=" + formObject.bkg_no.value, 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			break;
			
		case "btn1_DownExcel":
			//alert(srcName);
			break;
			
		case "btn1_back":
			var currIdx = getCurrIdxOfCntrCgoSeq();
			
			var totCnt = cntrCgoSeq.length;
			
			var disValue = currIdx;
			var setValue = cntrCgoSeq[currIdx - 1];
			     
			//alert("currIdx : " + currIdx + "\ntotCnt : " + totCnt + "\ndisValue : " + disValue + "\nsetValue : " + setValue);			
			if(setValue != undefined && disValue >= 1 && disValue <= totCnt) {
				formObj.dis_cntr_cgo_seq.value = disValue + " / " + totCnt;
				formObj.cntr_cgo_seq.value = setValue;
			}
			
			
			break;
		case "btn1_next":
			var currIdx = getCurrIdxOfCntrCgoSeq();
			
			var totCnt = cntrCgoSeq.length;
			
			var disValue = currIdx + 2;
			var setValue = cntrCgoSeq[currIdx + 1];
			
			//alert("currIdx : " + currIdx + "\ntotCnt : " + totCnt + "\ndisValue : " + disValue + "\nsetValue : " + setValue);
			if(setValue != undefined && disValue >= 1 && disValue <= totCnt) {
				formObj.dis_cntr_cgo_seq.value = disValue + " / " + totCnt;
				formObj.cntr_cgo_seq.value = setValue;
			}
			
			break;
			
		case "btn_calendar" :
            var cal = new ComCalendar();
            cal.select(formObj.frm_crr_dt, 'yyyy-MM-dd');
            break;
		case "btn_Close":
			closePage();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/** 
 * page 종료시
 * @return
 */
function closePage() {
	var formObj = document.form;
	window.returnValue=formObj.page_save_yn.value;
	self.close();
}

/**
 * cntrCgoSeq배열에 있는 현재 index를 리턴한다.
 * @return
 */
function getCurrIdxOfCntrCgoSeq() {
	var formObj = document.form;
	var currIdx = 0;
	
	for(var i = 0; i < cntrCgoSeq.length; i++) {
		
		//alert(i + " : " + cntrCgoSeq[i] + "\nformObj.p_cntr_cgo_seq.value : " + formObj.p_cntr_cgo_seq.value)
		
		if(cntrCgoSeq[i] == formObj.cntr_cgo_seq.value) {
			currIdx = i;
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
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(dType) {
	var formObj = document.form;
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	axon_event.addListenerForm('change', 'obj_change', document.form); // change

	// Declaration Setting
	if(dType == "D") {
		formObj.d_type1[0].checked = true;
	} else if(dType == "T") {
		formObj.d_type1[1].checked = true;
	} else if(dType == "L") {
		formObj.d_type1[2].checked = true;
	} else if(dType == "P") {
		formObj.d_type1[3].checked = true;
	} else if(dType == "O") {
		formObj.d_type1[4].checked = true;
	} else if(dType == "DO") {
		formObj.d_type1[0].checked = true;
		formObj.d_type1[4].checked = true;
	} else if(dType == "PL") {
		formObj.d_type1[2].checked = true;
		formObj.d_type1[3].checked = true;
	}
	
	// 화면 필드 초기화
	fileldInit(formObj.ofcCd.value);

	var comboObjMaxLen = comboObjects.length;
	for (i = 0; i < comboObjMaxLen; i++) {
		// IBCombo 초기화
		initCombo(comboObjects[i], i + 1);
	}
	
	// 해당 Bl에 속한 컨테이너와 리스트를 조회한다.(콤보 셋팅을 위해)  
	doActionIBSheet(sheetObjects[0],formObj,SEARCH01); 
	
	// 부모창에서 넘오온 Cgo seq를 셋팅한다.
	formObj.cntr_cgo_seq.value = formObj.p_cntr_cgo_seq.value; 
	
	var currIdx = getCurrIdxOfCntrCgoSeq();
	var totCnt = cntrCgoSeq.length;
	var disValue = currIdx+1;
	var setValue = cntrCgoSeq[currIdx];
	        
	//alert("currIdx : " + currIdx + "\ntotCnt : " + totCnt + "\ndisValue : " + disValue + "\nsetValue : " + setValue);
	
	if(disValue >= 1 && disValue <= totCnt) {
		formObj.dis_cntr_cgo_seq.value = disValue + " / " + totCnt;
		formObj.cntr_cgo_seq.value = setValue;
	}

	// Danger cargo 정보를 컨테이너 단위로 조회한다. 
	doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
	
	if(formObj.call_gubun.value == "ESM_BKG_0965") {
		// ESM_BKG_0965에서 호출시 Carriage Date 필드 타이블 변경 (On-Carriage Date or Pre-Carriage) 
		if(dType == "D" || dType == "O" || dType == "DO" || dType == "T") {
			// On-Carriage Date
			layoutView1.innerHTML = viewText1[0];
		} else {
			// Pre-Carriage
			layoutView1.innerHTML = viewText1[1];
		}
		
		// Feeder Name, Lloyd No Combo setting
		//doActionIBSheet(sheetObjects[0],formObj,SEARCH07);
		
	}
	
	

}

/**
 * 필드 활성화 / 비활성화 Log-In ID에 따라서
 * 
 * @param usrId
 * @return
 */
function fileldInit(ofcCd) {
	
	var formObj = document.form;
	
	if(ofcCd == "LEHSC") {
		
		formObj.frm_brth_yd_cd.disabled = true;
		formObj.frm_brth_yd_cd.className = "input2";
		formObj.frm_brth_yd_cd.value = "";
		formObj.frm_brth_yd_nm.disabled = true;
		formObj.frm_brth_yd_nm.className = "input2";
		formObj.frm_brth_yd_nm.value = "";

	}
	
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
	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 150;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|bkg_no|CNTR_NO|CNTR_CGO_SEQ|CNTR_TPSZ_CD|CNTR_TPSZ_ISO_CD|DCGO_MRN_POLUT_CD|IMDG_CLSS_CD|IMDG_SUBS_RSK_LBL_CD1|IMDG_SUBS_RSK_LBL_CD2|IMDG_SUBS_RSK_LBL_CD3|IMDG_SUBS_RSK_LBL_CD4|IMDG_LMT_QTY_FLG|EMER_RSPN_GID_NO|HCDG_FLG|IMDG_UN_NO|imdg_un_no_seq|imdg_comp_grp_cd" +
					"|IN_IMDG_PCK_QTY1|IN_IMDG_PCK_CD1|FLSH_PNT_CDO_TEMP|EUR_INR_PCK_DESC|IMDG_PCK_GRP_CD|OUT_IMDG_PCK_QTY1|OUT_IMDG_PCK_CD1|EMS_NO|EUR_OUTR_PCK_DESC|NET_WGT|MFAG_NO" +
					"|CELL_PSN_NO|GRS_WGT|EUR_PCK_DESC|PRP_SHP_NM|HZD_DESC|BRTH_YD_CD|BRTH_YD_NM|FWRD_NM|ANR_FWRD_ID|CRR_DT|XTD_STAY_PRMT_NO|DIFF_RMK|ANR_SPCL_TP_ID|ANR_CRR_TP_CD" +
					"|FDR_SVC_RQST_NO|FDR_VSL_NM|FDR_VSL_LLOYD_NO|FDR_VVD_ID|ACK_RSLT_ID|CSTMS_ERR_MSG|net_explo_wgt";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	 true, 	"ibflag");			
//			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eur_dg_decl_tp_cd"	); 
//			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "vsl_cd"				);
//			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "skd_voy_no"			);
//			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "skd_dir_cd"			);
//			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "port_cd"			);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkg_no"				);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_no"  			);       
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_cgo_seq"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_tpsz_cd"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_tpsz_iso_cd"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "dcgo_mrn_polut_cd"  );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_clss_cd"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_subs_rsk_lbl_cd1"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_subs_rsk_lbl_cd2"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_subs_rsk_lbl_cd3"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_subs_rsk_lbl_cd4"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_lmt_qty_flg"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "emer_rspn_gid_no"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "hcdg_flg"			);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_un_no"         );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_un_no_seq"     );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_comp_grp_cd"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "in_imdg_pck_qty1"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "in_imdg_pck_cd1"    );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "flsh_pnt_cdo_temp"  );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eur_inr_pck_desc"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "imdg_pck_grp_cd"    );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "out_imdg_pck_qty1"  );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "out_imdg_pck_cd1"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ems_no"            	);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eur_outr_pck_desc"  );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "net_wgt"            );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "mfag_no"            );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cell_psn_no"        );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "grs_wgt"            );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eur_pck_desc"       );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "prp_shp_nm"         );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "hzd_desc"           );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "brth_yd_cd "        );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "brth_yd_nm"			);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fwrd_nm"            );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "anr_fwrd_id"        );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "crr_dt" 			, false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "xtd_stay_prmt_no"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "diff_rmk"           );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "anr_spcl_tp_id"     );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "anr_crr_tp_cd"      );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fdr_svc_rqst_no"    );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fdr_vsl_nm"         );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fdr_vsl_lloyd_no"   );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fdr_vvd_id"         );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ack_rcv_sts_cd"     );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cstms_err_msg"      );
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "net_explo_wgt"      );
			
			InitViewFormat(0, "crr_dt", "yyyymmdd");
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	
	
	switch (sAction) {
		case SEARCH01: // Container Combo setting
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			if (sXml.length > 0) {
				ComBkgXml2ComboItem(sXml, comboObjects[0], "cntr_no", "cntr_no");
				comboObjects[0].Code = formObj.p_cntr_no.value; // 부모창에서 받은 cntr_no를 초기값으로 셋팅한다.
				
				//formObj.cntr_cgo_seq.value = formObj.p_cntr_cgo_seq.value;
				
				
			}
			break;
			
		case SEARCH02:
			
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			
			var strCntrCgoSeq = ComBkgXml2ComboString(sXml, "cntr_cgo_seq", "cntr_cgo_seq");
			
			
			if(strCntrCgoSeq != undefined && strCntrCgoSeq != "") {
				cntrCgoSeq = strCntrCgoSeq[0].split("|");
				
				//alert("cntrCgoSeq.length : " + cntrCgoSeq.length);
				if(cntrCgoSeq.length > 0) {
					formObj.dis_cntr_cgo_seq.value = "1 / " + cntrCgoSeq.length;
					formObj.cntr_cgo_seq.value = cntrCgoSeq[0];
					
				}
			}
			
			break;
			
		case SEARCH03:
			//sheetObj.ShowDebugMsg = true;
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSearchXml(sXml);
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				
				if (sXml.length > 0) {
					ComBkgXml2ComboItem(sXml, comboObjects[1], "cstms_err_msg", "cstms_err_msg");
					comboObjects[1].Index = 0;
				}

				
				if(formObj.call_gubun.value == "ESM_BKG_0965") {
					formObj.frm_crr_dt.value = ComGetMaskedValue(formObj.frm_crr_dt.value, "ymd");
				}
			}
			
			//alert(">> [" + formObj.frm_imdg_lmt_qty_flg.value + "]");
			
			if(formObj.frm_dcgo_mrn_polut_cd.value == "") {
				formObj.frm_dcgo_mrn_polut_cd.value = "";
			}
			
			if(formObj.frm_imdg_lmt_qty_flg.value == "") {
				formObj.frm_imdg_lmt_qty_flg.value = "N";
			}
			
			if(formObj.frm_hcdg_flg.value == "") {
				formObj.frm_hcdg_flg.value = "N";
			}

			if(formObj.frm_brth_yd_cd.value == "") {
				formObj.frm_brth_yd_cd.value = formObj.p_berth_cd.value;
			}
			if(formObj.frm_brth_yd_nm.value == "") {
				formObj.frm_brth_yd_nm.value = formObj.p_berth_nm.value;
			}
			
			var classCd = formObj.frm_imdg_clss_cd.value;
			
			//alert("classCd : " + classCd + "\n classCd.substring(0,1) : " + classCd.substring(0,1));
			
			if(classCd.substring(0,1)== "1") {
				formObj.frm_net_explo_wgt.className = "input";
				formObj.frm_net_explo_wgt.readOnly = false;
			} else {
				formObj.frm_net_explo_wgt.value = "";
				formObj.frm_net_explo_wgt.className = "input2";
				formObj.frm_net_explo_wgt.readOnly = true;
			}
			
			// 필드타이틀 변경
			if(formObj.call_gubun.value == "ESM_BKG_0965") {
				mandantoryChangByCarriageType();				
			}
			
			//alert("formObj.frm_ack_rcv_sts_cd.value : " + formObj.frm_ack_rcv_sts_cd.value);
			
			setSentStatusFiledColor();
			
			break;
			
		case SEARCH04 : // Berth Code로 Name을 조회한다.
			
			formObj.f_cmd.value = SEARCH04;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var yardName = ComGetEtcData(sXml, "yardName");
			
			formObj.frm_brth_yd_nm.value = (yardName == undefined) ? "" : yardName;
			
			break;
			
		case SEARCH05 : // Forward Code로 Name을 조회한다.

			formObj.f_cmd.value = SEARCH05;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			var anrFwrdName = ComGetEtcData(sXml, "anrFwrdName");
			
			//alert("anrFwrdName : " + anrFwrdName );
			
			formObj.frm_fwrd_nm.value = (anrFwrdName == undefined) ? "" : anrFwrdName;
			
			break;
			
		case SEARCH06 : // UN NO로 NAME을 조회한다.

			formObj.f_cmd.value = SEARCH06;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			var imdgUnNoDesc = ComGetEtcData(sXml, "imdgUnNoDesc");
			
			//alert("imdgUnNoDesc : " + imdgUnNoDesc );
			
//			formObj.frm_imdg_un_no_desc.value = (imdgUnNoDesc == undefined) ? "" : imdgUnNoDesc;
			formObj.frm_anr_spcl_tp_id.value = (imdgUnNoDesc == undefined) ? "" : imdgUnNoDesc;
			
			break;

		case COMMAND01 : // g/w mail
			
			var contents = "";
			contents += "Test";
			contents += "----------------------------------------------------------------<br>";
			contents += "Declaration:"+ formObj.d_type.value +"<br>";
			contents += "VVD:"+ formObj.vvd_cd.value +"<br>";
			contents += "PORT:"+ formObj.port_cd.value +"<br>";
			contents += "B/L No.:"+ formObj.bl_no.value +"<br>";
			contents += "Container No.:"+ formObj.frm_cntr_no.value +"<br>";
			formObj.gw_contents.value = contents;
			formObj.gw_subject.value = "Notice of Dangerous cargo Information Amendment.";
			
			ComOpenGroupwareMail(sheetObj,formObj);

			break;
			
		case MODIFY01 : // Save(the Container) or Save(the Whole BKG)

			if(!validateForm(sheetObj,formObj,sAction))return;

			var saveType = formObj.save_type.value;

			var msg = "";
			if(saveType == "1") {
				//msg = "Container-Cago-Cago Seq 단위로 저장됩니다. 계속하시겠습니까?";
				msg = "Container-Cago-Cago Seq";
			} else {
				//msg = "BL 단위로 저장됩니다. 계속하시겠습니까?";
				msg = "B/L No";
			}
			
			if(!ComShowConfirm(ComGetMsg("BKG06102", msg))) {
            	return false;
            }
			
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			
			formObj.f_cmd.value = MODIFY01;

			var sParam = sheetObjects[0].GetSaveString();

			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}

			sParam += "&" + FormQueryString(formObj);
			
			//alert("sParam : " + sParam);

			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0967GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);

			// 저장후 save Flag 셋팅
			formObj.page_save_yn.value = "Y";
			break;
			
		case SEARCH07: // Feeder Name, Lloyd No Combo setting
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			if (sXml.length > 0) {
				comboObjects[2].DropHeight = 300;
				comboObjects[2].SetTitle("Feeder Name|Lloy No");

				ComBkgXml2ComboItem(sXml, comboObjects[2], "feeder_name", "feeder_lloyd_no");
				comboObjects[2].ShowCol = 1; 
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
	var formObj = document.form;
	var colArr = text.split("|");
	formObj.frm_fdr_vsl_nm.value = colArr[0];
	formObj.frm_fdr_vsl_lloyd_no.value = colArr[1];
	*/
}

/**
 * 컨테이너 리스트 콤보 변경시 이벤트
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cntr_list_OnChange(comboObj,value,text) {
	var formObj = document.form;
	formObj.cntr_no.value = text;
	doActionIBSheet(sheetObjects[0],formObj,SEARCH02); // CGO SEQ 조회
}


/**
 * Sent Status 컬러 변경
 * 
 * @return
 */
function setSentStatusFiledColor() {
	var formObj = document.form;
	var sentStatus = formObj.frm_ack_rcv_sts_cd.value
	var obj = formObj.frm_ack_rcv_sts_cd;

	obj.style.color = "white";
	
	if (sentStatus == "") { // empty
		formObj.frm_ack_rcv_sts_cd.value = "Empty Message not sent";
		obj.style.backgroundColor = "gray";
	} else if (sentStatus == "P") {
		formObj.frm_ack_rcv_sts_cd.value = "Processing";
		obj.style.backgroundColor = "gray";
	} else if (sentStatus == "A") {
		formObj.frm_ack_rcv_sts_cd.value = "Sent, Accepted";
		obj.style.backgroundColor = "blue";
	} else if (sentStatus == "C") {
		formObj.frm_ack_rcv_sts_cd.value = "Sent, Wrong but Acceptable";
		obj.style.backgroundColor = "yellowgreen";
	} else if (sentStatus == "R") {
		formObj.frm_ack_rcv_sts_cd.value = "Sent, Not Acceptable";
		obj.style.backgroundColor = "red";
	}

}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch (sAction) {
		case MODIFY01 :
			
			
			if(!ComChkObjValid(formObj.frm_cell_psn_no)) return false;
			
			
			// Class가 3이고 Flash Point가  Null인 경우
				if(formObj.frm_imdg_clss_cd.value == "3" && formObj.frm_flsh_pnt_cdo_temp.value.trim() == "" ) {
	        		ComShowCodeMessage("BKG00540", "[Container No. : " + formObj.frm_cntr_no.value + "]");
	        		formObj.frm_flsh_pnt_cdo_temp.focus();
	        		return false;
				}

			
			if(formObj.frm_flsh_pnt_cdo_temp.value.length > 0 && !checkFloatType(formObj.frm_flsh_pnt_cdo_temp.value, 5, 2)) {
				ComShowCodeMessage("BKG00651", "Flash Point");
				ComSetFocus(formObj.frm_flsh_pnt_cdo_temp);
				return false;
			}
			
			if(formObj.frm_net_wgt.value.length > 0 && !checkFloatType(formObj.frm_net_wgt.value, 15, 3)) {
				ComShowCodeMessage("BKG00651", "Net Weight");
				ComSetFocus(formObj.frm_net_wgt);
				return false;
			}
			
			if(formObj.frm_grs_wgt.value.length > 0 && !checkFloatType(formObj.frm_grs_wgt.value, 15, 3)) {
				ComShowCodeMessage("BKG00651", "Gross Weight");
				ComSetFocus(formObj.frm_grs_wgt);
				return false;
			}

			if(formObj.frm_out_imdg_pck_qty1.value.length > 0 && !checkFloatType(formObj.frm_out_imdg_pck_qty1.value, 9, 3)) {
				ComShowCodeMessage("BKG00651", "Outer Package Qty");
				ComSetFocus(formObj.frm_out_imdg_pck_qty1);
				return false;
			}

			if(formObj.frm_in_imdg_pck_qty1.value.length > 0 && !checkFloatType(formObj.frm_in_imdg_pck_qty1.value, 9, 3)) {
				ComShowCodeMessage("BKG00651", "Inner Package Qty");
				ComSetFocus(formObj.frm_in_imdg_pck_qty1);
				return false;
			}

			if(formObj.call_gubun.value == "ESM_BKG_0965") {
				var cType = formObj.frm_anr_crr_tp_cd.value;
				
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

function obj_KeyUp() {
	var formObj = document.form;
	var srcName = event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "bkg_no" || srcName == "bl_no") {
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			formObj.f_cmd.value = INIT;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0967GS.do", FormQueryString(formObj));
			//ComXml2ComboItem(sXml, formObj.cntr_list, "cntr_cgo_seq", "cntr_no");
			ComBkgXml2ComboItem(sXml, formObj.cntr_list, "cntr_cgo_seq", "cntr_no", true);
		}
	}
}

/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	

	if(srcName == "frm_brth_yd_cd") { // Berth Code 필드값 변경시
		//alert("frm_brth_yd_cd");
		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);

	} else if(srcName == "frm_fwrd_cd") { // Forward Code 필드값 변경시
		doActionIBSheet(sheetObjects[0], formObj, SEARCH05);

	} else if(srcName == "frm_anr_crr_tp_cd") { // Carriage Type 필드값 변경시
		mandantoryChangByCarriageType();
	}
	
	if(formObj.call_gubun.value == "ESM_BKG_0965") { // ANRSO화면에서  call한 경우
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
	var formObj = document.form;
	var cType = formObj.frm_anr_crr_tp_cd.value;
	
	// 필드 타이틀 변경
	if(cType == "B") { //Barge
		layoutView.innerHTML = viewText[1];
	} else {
		layoutView.innerHTML = viewText[0];
		
	}

	// Marintim일 경우 필수 필드 변경
	if(cType == "V") { // Marintim 일경우
		formObj.frm_fdr_svc_rqst_no.className = "input1";
		formObj.frm_fdr_svc_rqst_no.readOnly = false;
		formObj.frm_fdr_vvd_id.className = "input1";
		formObj.frm_fdr_vvd_id.readOnly = false;
		formObj.frm_fdr_vsl_nm.className = "input1";
		formObj.frm_fdr_vsl_nm.readOnly = true;
		formObj.frm_fdr_vsl_lloyd_no.className = "input1";
		formObj.frm_fdr_vsl_lloyd_no.readOnly = true;
		layoutView3.style.display = "inline";
		
	} else {
		formObj.frm_fdr_svc_rqst_no.className = "input2";
		formObj.frm_fdr_svc_rqst_no.readOnly = true;
		formObj.frm_fdr_svc_rqst_no.value = "";

		formObj.frm_fdr_vvd_id.className = "input2";
		formObj.frm_fdr_vvd_id.readOnly = true;
		formObj.frm_fdr_vvd_id.value = "";

		formObj.frm_fdr_vsl_nm.className = "input2";
		formObj.frm_fdr_vsl_nm.readOnly = true;
		formObj.frm_fdr_vsl_nm.value = "";

		formObj.frm_fdr_vsl_lloyd_no.className = "input2";
		formObj.frm_fdr_vsl_lloyd_no.readOnly = true;
		formObj.frm_fdr_vsl_lloyd_no.value = "";
		
		layoutView3.style.display = "none";
	}

}



/**
 * 저장 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	
	if (ErrMsg == "") {
		ComShowCodeMessage('BKG00102');
		return false;
	} 
}

 /**
  * Un No 팝업 콜백 함수
  * @param rowArray
  * @return
  */
function setUnNo(rowArray) {
	
	var formObj = document.form;
	var colArray = rowArray[0];

	document.getElementById("frm_imdg_un_no").value = colArray[2];
	document.getElementById("frm_imdg_un_no_seq").value = colArray[3];
	document.getElementById("frm_imdg_clss_cd").value = colArray[4];
	document.getElementById("frm_imdg_comp_grp_cd").value = colArray[5];
	document.getElementById("frm_imdg_pck_grp_cd").value = colArray[6];
	document.getElementById("frm_ems_no").value = colArray[16];
	
}





