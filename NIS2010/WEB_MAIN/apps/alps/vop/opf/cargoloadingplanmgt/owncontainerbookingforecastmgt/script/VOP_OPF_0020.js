/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0020.js
 *@FileTitle : CBF for Partner Line’s Booking (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.06.09 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ---------------IN---*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

	/**
	 * @extends
	 * @class vop_opf_0020 : vop_opf_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_0020() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}

	/* 개발자 작업	*/

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var prefix1 = "t1sheet1_";
	var prefix2 = "t2sheet1_";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {	
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var sheetObj2 = sheetObjects[1]; // t2sheet1
		
		var tabObj    = tabObjects[0];
		var comboObj  = comboObjects[0];

		var formObj   = document.form;
		
		var selTabIdx = tabObj.SelectedIndex;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH); // tab1
					break;
					
				case "btn_New":
					ComResetAll();
					comboObj.RemoveAll();
					
					//버튼 비활성화
					ComBtnDisable("btn_LoadFile");
					ComBtnDisable("btn_SummaryPreview");
					ComBtnDisable("t1btn_RowAdd");
					ComBtnDisable("t1btn_RowInsert");
					ComBtnDisable("t1btn_Delete");
					ComBtnDisable("t1btn_LoadFileTemplate");
					ComBtnDisable("t1btn_WGPCalcu");
					ComBtnDisable("t2btn_RowAdd");
					ComBtnDisable("t2btn_CntrAdd");
					ComBtnDisable("t2btn_CgoAdd");
					ComBtnDisable("t2btn_RowCopy");
					ComBtnDisable("t2btn_Delete");
					ComBtnDisable("t2btn_LoadFileTemplate");
				
					//초기 포커스 위치
					ComSetFocus(formObj.vsl_cd);

					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);					
					break;
					
				case "btn_vvd":
					var vslCd = ComGetObjValue(formObj.vsl_cd);
					var sUrl = "";
	
					if (vslCd == "") {
						sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 335, 425, "setCallBackVVD", "0,0", true);
					}
					break;
	
				case "btn_opr":
					ComOpenPopupWithTarget('/hanjin/COM_ENS_0N1.do', 420, 450, "crr_cd:crr_cd", "1,0,1,1,1", true);
					break;
	
				case "btn_LoadFile":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBLOADEXCEL);
					
					break;
	
				case "btn_SummaryPreview":
					openSPPopup(formObj);
					break;
	
				case "t1btn_RowAdd":
					var row = sheetObj1.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
		 			
					sheetObj1.CellValue2(row, prefix1+"vsl_cd")            = ComGetObjValue(formObj.vsl_cd);
					sheetObj1.CellValue2(row, prefix1+"skd_voy_no")        = ComGetObjValue(formObj.skd_voy_no);
					sheetObj1.CellValue2(row, prefix1+"skd_dir_cd")        = ComGetObjValue(formObj.skd_dir_cd); 			
					sheetObj1.CellValue2(row, prefix1+"bkg_shpr_ownr_flg") = "N";
					sheetObj1.CellValue2(row, prefix1+"crr_cd")            = ComGetObjValue(formObj.crr_cd);
					sheetObj1.CellValue2(row, prefix1+"yd_cd")             = formObj.yd_cd.text;
					sheetObj1.CellValue2(row, prefix1+"pol_clpt_ind_seq")  = comboObj.Code.substring(comboObj.Code.length-1, comboObj.Code.length);
					sheetObj1.CellValue2(row, prefix1+"slan_cd")           = ComGetObjValue(formObj.slan_cd);
					sheetObj1.CellValue2(row, prefix1+"cbf_dp_cd")         = "V";
	
					sheetObj1.SelectCell(row, prefix1+"pod_cd");
		 			
					break;
	
				case "t1btn_RowInsert":
					var row = sheetObj1.DataInsert();
					
					sheetObj1.CellValue2(row, prefix1+"vsl_cd")            = ComGetObjValue(formObj.vsl_cd);
					sheetObj1.CellValue2(row, prefix1+"skd_voy_no")        = ComGetObjValue(formObj.skd_voy_no);
					sheetObj1.CellValue2(row, prefix1+"skd_dir_cd")        = ComGetObjValue(formObj.skd_dir_cd); 			
					sheetObj1.CellValue2(row, prefix1+"bkg_shpr_ownr_flg") = "N";
					sheetObj1.CellValue2(row, prefix1+"crr_cd")            = ComGetObjValue(formObj.crr_cd);
					sheetObj1.CellValue2(row, prefix1+"yd_cd")             = formObj.yd_cd.text;
					sheetObj1.CellValue2(row, prefix1+"pol_clpt_ind_seq")  = comboObj.Code.substring(comboObj.Code.length-1, comboObj.Code.length);
					sheetObj1.CellValue2(row, prefix1+"slan_cd")           = ComGetObjValue(formObj.slan_cd);
					sheetObj1.CellValue2(row, prefix1+"cbf_dp_cd")         = "V";
					
					sheetObj1.SelectCell(row, prefix1+"pod_cd");					
		 			
					break;
	
				case "t1btn_RowCopy":
					var row = sheetObj1.DataCopy();
					sheetObj1.CellValue2(row, prefix1+"cbf_smry_seq") = "";
					
					sheetObj1.SelectCell(row, prefix1+"pod_cd");
					
					break;
	
				case "t1btn_Delete":
					ComRowHideDelete(sheetObj1, prefix1+"del_chk");

					break;
	
				case "t2btn_RowAdd":
					var row = sheetObj2.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
					
					sheetObj2.CellValue2(row, prefix2+"cntr_seq")          = 1;
					sheetObj2.CellValue2(row, prefix2+"cgo_seq")           = 1;
					sheetObj2.CellValue2(row, prefix2+"vsl_cd")            = ComGetObjValue(formObj.vsl_cd);
					sheetObj2.CellValue2(row, prefix2+"skd_voy_no")        = ComGetObjValue(formObj.skd_voy_no);
					sheetObj2.CellValue2(row, prefix2+"skd_dir_cd")        = ComGetObjValue(formObj.skd_dir_cd);
					sheetObj2.CellValue2(row, prefix2+"bkg_shpr_ownr_flg") = "N";
					sheetObj2.CellValue2(row, prefix2+"crr_cd")            = ComGetObjValue(formObj.crr_cd);
					sheetObj2.CellValue2(row, prefix2+"yd_cd")             = formObj.yd_cd.text;	
					sheetObj2.CellValue2(row, prefix2+"pol_clpt_ind_seq")  = comboObj.Code.substring(comboObj.Code.length-1, comboObj.Code.length);
					sheetObj2.CellValue2(row, prefix2+"slan_cd")           = ComGetObjValue(formObj.slan_cd);
					sheetObj2.CellValue2(row, prefix2+"cbf_dp_cd")         = "S";
		 			
					sheetObj2.SelectCell(row, prefix2+"prnr_bkg_ref_no");
					
					break;
	
				case "t2btn_CntrAdd":
					if (sheetObj2.RowCount > 0) {
						var row = sheetObj2.DataCopy();
						//1. Container 번호 초기화
						sheetObj2.CellValue2(row, prefix2+"prnr_cntr_ref_no") = "";
						//2. Container Seq 증가
						sheetObj2.CellValue2(row, prefix2+"cntr_seq") = parseInt(sheetObj2.CellValue(row, prefix2+"cntr_seq")) + 1;
						sheetObj2.CellValue2(row, prefix2+"cgo_seq")  = 1;
						//3. Cargo 정보 삭제
						for(var colCt=sheetObj2.SaveNameCol(prefix2+"cntr_grs_wgt"); colCt<=sheetObj2.SaveNameCol(prefix2+"cbf_rmk"); colCt++) {
							sheetObj2.CellValue2(row, colCt) = "";
						}
						//4. CBF Seq 초기화
						sheetObj2.CellValue2(row, prefix2+"cbf_smry_seq") = "";
						
						//5. Container 번호로 포커스
						sheetObj2.SelectCell(row, prefix2+"prnr_cntr_ref_no");
					}

					break;
	
				case "t2btn_CgoAdd":
					if (sheetObj2.RowCount > 0) {
						var row = sheetObj2.DataCopy();
						//1. Container Seq 증가
						sheetObj2.CellValue2(row, prefix2+"cgo_seq") = parseInt(sheetObj2.CellValue(row, prefix2+"cgo_seq")) + 1;
						
						//2. Cargo 정보 삭제
						for(var colCt=sheetObj2.SaveNameCol(prefix2+"cntr_grs_wgt"); colCt<=sheetObj2.SaveNameCol(prefix2+"cbf_rmk"); colCt++) {
							sheetObj2.CellValue2(row, colCt) = "";
						}
						//3. CBF Seq 초기화
						sheetObj2.CellValue2(row, prefix2+"cbf_smry_seq") = "";
						
						//4. Group Weight로 포커스
						sheetObj2.SelectCell(row, prefix2+"cntr_grs_wgt");
					}
					
					break;
	
				case "t2btn_RowCopy":
					var row = sheetObj2.DataCopy();
					sheetObj2.CellValue2(row, prefix2+"cbf_smry_seq") = "";
					
					sheetObj2.SelectCell(row, prefix2+"prnr_bkg_ref_no");
					
					break;
	
				case "t2btn_Delete":
					ComRowHideDelete(sheetObj2, prefix2+"del_chk");
					
					break;
	
				case "t1btn_LoadFileTemplate":
					sheetObj1.DirectDown2Excel("apps/alps/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/jsp/VOP_OPF_0020.xml");
	
					break;
					
				case "t2btn_LoadFileTemplate":
					sheetObj2.DirectDown2Excel("apps/alps/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/jsp/VOP_OPF_0020_01.xml", "", 0, true);
	
					break;
	
				case "t1btn_WGPCalcu":
					//Weight Group 계산
					if (validateForm(sheetObj1, formObj, IBSEARCH)) {
						calculateWGP(sheetObj1, formObj, true);
					}
	
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
	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj  = document.form;
		if (rtnObjs) {
			var rtnDatas = rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
	
					// 포커스 이동
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}
	
	/**
	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVVD(obj) {
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		if (obj) {
			var rtnDatas = obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					
					//VVD Info 가져오기
					searchVVDInfo();
				}
			}
		}
	}
	
	/** 
	 * Summary Preview 버튼 클릭시 팝업호출
	 */
	function openSPPopup(formObj) {	
		var vslCd     = ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo  = ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd  = ComGetObjValue(formObj.skd_dir_cd);
		var ydCd      = comboObjects[0].Code;
		var ydNm      = ComGetObjValue(formObj.yd_nm);
		var crrCd     = ComGetObjValue(formObj.crr_cd);
	
		var vslSlanCd = ComGetObjValue(formObj.slan_cd);
	
		var paramStr = "";
		paramStr += 'vsl_cd=' + vslCd + '&skd_voy_no=' + skdVoyNo + '&skd_dir_cd=' + skdDirCd;
		paramStr += '&yd_cd=' + ydCd + '&yd_nm=' + ydNm + '&cbf_ind_flg=F';
		paramStr += "&vsl_slan_cd=" + vslSlanCd + "&crr_cd=" + crrCd + "&bkg_shpr_ownr_flg=N";	
		
		ComOpenWindowCenter("VOP_OPF_2019.do?" + paramStr, "win2", "1000", "620", false, "yes");
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
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {	
		comboObjects[comboCnt++] = combo_obj;	
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		// IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//IBTab 초기화
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		//IBSheet 초기화
		for (i = 0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//버튼 비활성화
		ComBtnDisable("btn_LoadFile");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("t1btn_RowAdd");
		ComBtnDisable("t1btn_RowInsert");
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_LoadFileTemplate");
		ComBtnDisable("t1btn_WGPCalcu");
		ComBtnDisable("t2btn_RowAdd");
		ComBtnDisable("t2btn_CntrAdd");
		ComBtnDisable("t2btn_CgoAdd");
		ComBtnDisable("t2btn_RowCopy");
		ComBtnDisable("t2btn_Delete");
		ComBtnDisable("t2btn_LoadFileTemplate");
		
		//Axon Event Listener 등록
		initControl();
	}
	 
    /**
     * sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t1sheet1_OnLoadFinish(sheetObj) {
    	//Sheet Combo 초기화
    	initSheetCombos(sheetObj);
    }
	 
	//Sheet Combo 초기화
	function initSheetCombos(sheetObj) {
		var sheetObj1 = sheetObj;
		var sheetObj2 = sheetObjects[1];
		var formObj   = document.form;
		
		//시트에서 사용하는 콤보 목록 모두 가져오기 : TP, FM, CGO, IMO, POSTEXTD, STWG
		sheetObj1.WaitImageVisible = false;
		formObj.f_cmd.value = SEARCHLIST03;
		var sXml = sheetObj1.GetSearchXml("VOP_OPF_0020GS.do", FormQueryString(formObj));
		sheetObj1.WaitImageVisible = true;
		
		var arrXml = sXml.split("|$$|");
		
		//TP
		var arrCombo1 = ComXml2ComboString(arrXml[0], "val", "name");
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j]	+ "\t" + arrName[j];
				else itemNm = itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj1.InitDataCombo(0, prefix1+"cntr_tpsz_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
			sheetObj2.InitDataCombo(0, prefix2+"cntr_tpsz_cd", " |" + itemNm, " |" + arrCombo1[0]);
		}
		
		//FM
		var arrCombo2 = ComXml2ComboString(arrXml[1], "val", "name");
		if (arrCombo2 != null) {
			var arrVal  = arrCombo2[0].split("|");
			var arrName = arrCombo2[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm = itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj1.InitDataCombo(0, prefix1+"full_mty_cd", " |" + itemNm, " |" + arrCombo2[0]);
		}
		
		//CGO
		var arrCombo3 = ComXml2ComboString(arrXml[2], "intg_cd_val_ctnt", "intg_cd_val_ctnt");
		
		//IMO
		var arrCombo4 = ComXml2ComboString(arrXml[3], "val", "name");
		if (arrCombo4 != null) {
			var arrVal  = arrCombo4[0].split("|");
			var arrName = arrCombo4[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm = itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			
			sheetObj2.InitDataCombo(0, prefix2+"imdg_mrn_polut_cd", " |Y", " |Y");	// MP
			sheetObj2.InitDataCombo(0, prefix2+"lmt_qty_flg",       " |Y", " |Y");	// LQ
			sheetObj2.InitDataCombo(0, prefix2+"expt_qty_flg",      " |Y", " |Y");	// EQ
		}
		
		//POSTEXTD
		var arrCombo5 = ComXml2ComboString(arrXml[4], "val", "name");		
		if (arrCombo5 != null) {
			sheetObj2.InitDataCombo(0, prefix2+"crn_pst_sts_cd", " |" + arrCombo5[1], " |" + arrCombo5[0]);
		}
		
		//STWG
		var arrCombo6 = ComXml2ComboString(arrXml[5], "val", "name");		
		if (arrCombo6 != null) {
			var arrVal  = arrCombo6[0].split("|");
			var arrName = arrCombo6[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm = itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj2.InitDataCombo(0, prefix2+"stwg_cd", " |" + itemNm, " |" + arrCombo6[0]);
		}
		
		//초기 포커스 위치
		ComSetFocus(document.form.vsl_cd);	
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 */
	function initControl() {
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ('keyup',    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
	 
	/**
	 * VVD  데이터 수정시. <br>
	 **/
	function obj_change() {
		var formObj  = document.form;		
		
		with (event.srcElement) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					
					//관련항목 초기화					
					//resetForCondition(formObj, "vvd");
					
					break;
			}
		}
	}
	 
	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}
	 
	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else if(obj.name != 'crr_cd') ComSetNextFocus(obj);
			
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}
	
	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	var beforeCrrCd;
	var beforeActiveObj = null;
	function obj_blur() {
		pastEventNum = 0;
		var formObj  = document.form;
		
		var tabObj    = tabObjects[0];
		var selTabIdx = tabObj.SelectedIndex;
		
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//VVD Info 가져오기
						searchVVDInfo();
					}		
					
					break;
					
				case "crr_cd":	
					if(beforeCrrCd != value) {
						if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
							if (ComShowCodeConfirm("OPF50003")) {
								//재조회는 이전값으로 한다.
								ComSetObjValue(event.srcElement, beforeCrrCd);
								
								//저장						
								doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);							
								
								ComSetFocus(event.srcElement);
								
								return;
							}
						}
			    		if(value != '' && document.activeElement.id != 'crr_cd' && beforeActiveObj != document.activeElement.id) {	
			    			beforeActiveObj = document.activeElement.id;		    			
			    	      	
			    	      	var sheetObj  = sheetObjects[(selTabIdx==1?0:1)];
			    	      	
			    	      	var sParam = Array();
			    	  	  	sParam[0] = "crr_cd="+value;
			    	  	  	sParam[1] = "f_cmd="+SEARCH01;
	
			    	  	  	if(sParam.join("").length > 18) {  
			    	  	  		sheetObj.WaitImageVisible = false;
			    	  	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
			    	  	    	sheetObj.WaitImageVisible = true;
			    	  	    	
			    	  	    	var crrData = ComOpfXml2Array(sXml, "crr_cd");
			    	  	      	
			    	  		   	if(crrData == null) {
			    	  			    ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
	
			    	  			    ComSetObjValue(event.srcElement, ""); 	
			    	 	 		    ComSetFocus(event.srcElement);
			    	  		   	} 
			    	  	  	} else {  	  		
			    	  	  		ComChkObjValid(obj, true);
			    	  	  	}
			    		}
			    		
			    		beforeCrrCd = value;
					}
			    		
		        	break;
					
				default:
					break;
			}
		}
		
		beforeActiveObj = null;
	}

	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {	
		switch (event.srcElement.dataformat) {
			case "engup":
				switch (event.srcElement.name) {
					case "vsl_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "skd_voy_no":
						//숫자입력하기
						ComKeyOnlyNumber(event.srcElement);
						break;
					case "skd_dir_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "crr_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					default:
						//공통기준:영문, 숫자만을 인식
						ComKeyOnlyAlphabet("num");
						break;
				}
				break;
	
			default:
				//공통기준:영문, 숫자만을 인식
				ComKeyOnlyAlphabet("num");
				break;
		}
	}
	 
	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var comboObj = comboObjects[0];
		
		//관련항목 초기화
		resetForCondition(formObj, "vvd");
	
		formObj.f_cmd.value = SEARCH05;
		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));		
	
		var vvdData = ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
		if (vvdData == null) {
			ComShowCodeMessage("OPF50004", 'Data');
			
			//관련항목 초기화
			resetForCondition(formObj, "vvd");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			
			//포커스 이동
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);
			
			//POL 가져오기
			formObj.f_cmd.value = SEARCH01;
			
			//파라미터 명시적인 생성
 			var formParams = "";
     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd);     		
			
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", formParams);
			var sPol = ComGetEtcData(sXml, "sPol");
			
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				var polCd = ""; //yd_code + clpt_ind_seq
				
				for (var cCt=0; cCt<arrPol.length; cCt++) {
					polCd = arrPol[cCt];
					if(polCd != '') polCd = polCd.substring(0, polCd.length-1); 
					comboObj.InsertItem(cCt, polCd, arrPol[cCt]);
				}
			}
			
			//포커스 이동
			ComSetFocus(formObj.yd_cd);
		}
		sheetObj.WaitImageVisible = true;
	}
	
	/**
	 * VVD/POL 변경시 관련항목 초기화 <br>
	 **/
	function resetForCondition(formObj, what) {
		var comboObj = comboObjects[0];
		
		//VVD
		if(what.indexOf("vvd") != -1) {
			if(what.indexOf("pol") == -1) {
				ComSetObjValue(formObj.vsl_eng_nm, "");
				ComSetObjValue(formObj.slan_cd,    "");
				ComSetObjValue(formObj.slan_nm,    "");			
				
				comboObj.RemoveAll();
			}
			ComSetObjValue(formObj.loc_nm,     "");
			ComSetObjValue(formObj.yd_nm,      "");
			ComSetObjValue(formObj.eta,        "");
			
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");
			
			ComSetObjValue(formObj.crr_cd,     "");
		}
		
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
		
		ComBtnDisable("btn_Save");
		
		ComBtnDisable("btn_LoadFile");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("t1btn_RowAdd");
		ComBtnDisable("t1btn_RowInsert");
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_LoadFileTemplate");
		ComBtnDisable("t1btn_WGPCalcu");
		
		ComBtnDisable("t2btn_RowAdd");
		ComBtnDisable("t2btn_CntrAdd");
		ComBtnDisable("t2btn_CgoAdd");
		ComBtnDisable("t2btn_RowCopy");
		ComBtnDisable("t2btn_Delete");
		ComBtnDisable("t2btn_LoadFileTemplate");
	}

	/**
	 * IBCOMBO 초기화. <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "yd_cd":
				with (comboObj) {
					BackColor   = "#CCFFFF";
					DropHeight  = 200;
					MultiSelect = false;
					MaxSelect   = 1;
				}
				break;
		}
	}
	 
	/**
	 * POL 콤보 데이터 선택시. <br>
	 **/
	var beforeYdCd;
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj   = document.form;
		
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		
		var comboObj  = comboObjects[0];
		
		if (sheetObj1.IsDataModified || sheetObj2.IsDataModified) {
			if (ComShowCodeConfirm("OPF50003")) {
				var tabObj    = tabObjects[0];
				var selTabIdx = tabObj.SelectedIndex;
				
				//저장						
				doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
				
				//이전 상태로 복구
				comboObj.Text2 = beforeYdCd;
				
				return;
			}
		}
		
		//이전 POL 값 유지
		beforeYdCd = Text;
	
		//관련항목 초기화
		resetForCondition(formObj, "vvd-pol");
		
		if(Code != '') {		
			//POL Info 가져오기
			formObj.f_cmd.value = SEARCH02;
			sheetObj1.WaitImageVisible = false;
			
			//파라미터 명시적인 생성
 			var formParams = "";
     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
     		formParams += "&yd_cd="      +comboObjects[0].Code; 
			
			var sXml = sheetObj1.GetSearchXml("VOP_OPF_0019GS.do", formParams);
			sheetObj1.WaitImageVisible = true;
	
			var sPol = ComGetEtcData(sXml, "sPol");
	
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
			}
			
			//POD 가져오기
			var polCd = Text.substring(0, 5);
			
			var sParam = Array();
			sParam[0] = "vsl_cd="     + ComGetObjValue(formObj.vsl_cd);
			sParam[1] = "skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
			sParam[2] = "skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
			sParam[3] = "f_cmd="      + SEARCH10;
			
			sheetObj1.WaitImageVisible = false;
			var sXml = sheetObj1.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&"));
			sheetObj1.WaitImageVisible = true;
			
			var arrCombo = ComXml2ComboString(sXml, "loc_cd", "loc_nm");
			
			if (arrCombo != null && arrCombo.length > 0) {
				var locCds      = ComOpfXml2Array(sXml, "loc_cd");
				var clptSeqs    = ComOpfXml2Array(sXml, "clpt_seq");
				var clptIndSeqs = ComOpfXml2Array(sXml, "clpt_ind_seq");
				var podCombo  = new Array();
				var podCombo1 = new Array();
				var podCombo2 = new Array();
				var podCombo3 = new Array();

				var polClptSeq = "0";
				var newPodIdx  = 0;
				for ( var arrIdx1 = 0; arrIdx1 < locCds.length; arrIdx1++) {
					if (locCds[arrIdx1] == polCd) polClptSeq = clptSeqs[arrIdx1];
				}
				for ( var arrIdx2 = 0; arrIdx2 < locCds.length; arrIdx2++) {
					if (locCds[arrIdx2] != null && locCds[arrIdx2] != '') {
						if (parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
							podCombo[newPodIdx]  = locCds[arrIdx2];
							podCombo1[newPodIdx] = locCds[arrIdx2]+clptIndSeqs[arrIdx2];
							
							newPodIdx++;
						}
					}
				}

				podCombo2 = podCombo.join('|');
				podCombo3 = podCombo1.join('|');
				sheetObj1.InitDataCombo(0, prefix1+"pod_cd", " |" + podCombo2, " |" + podCombo3);
				sheetObj2.InitDataCombo(0, prefix2+"pod_cd", " |" + podCombo2, " |" + podCombo3);
			} else {
				sheetObj1.InitDataCombo(0, prefix1+"pod_cd", "", "");
				sheetObj2.InitDataCombo(0, prefix2+"pod_cd", "", "");
			}
			
			ComSetFocus(formObj.crr_cd);
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
	
		switch (sheetNo) {
			case 1: // sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 340;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle = "|No.||POD|BS CD|CNTR No.|CGO OPR|TP|WGP|F/E|Q'ty|CN GR WT (kg)|||||||||||CBF DP CD|HIDDEN";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix1 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	true, 	prefix1 + "No.");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	false, 	prefix1 + "del_chk", 			false, 	"", dfNone, 	0, true, 	true);
					InitDataProperty(0, cnt++, dtCombo, 		65, 	daCenter, 	true, 	prefix1 + "pod_cd", 			true, 	"", dfNone, 	0, true, 	true, 	5);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "mlb_cd", 			false, 	"", dfNone, 	0, true, 	true);
					InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, 	prefix1 + "prnr_cntr_ref_no", 	false, 	"", dfNone, 	0, true, 	true, 	13);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	prefix1 + "crr_cd", 			false, 	"", dfNone, 	0, false, 	false, 	4);
					InitDataProperty(0, cnt++, dtCombo, 		100, 	daCenter, 	true, 	prefix1 + "cntr_tpsz_cd", 		true, 	"", dfNone, 	0, true, 	true, 	4);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	prefix1 + "cntr_wgt_grp_cd", 	false, 	"", dfNone, 	0, false, 	false);
					InitDataProperty(0, cnt++, dtCombo, 		100, 	daCenter, 	true, 	prefix1 + "full_mty_cd", 		true, 	"", dfNone, 	0, true, 	true, 	1);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	prefix1 + "cntr_qty", 			true, 	"", dfNone, 	0, true, 	true, 	6);
					InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	true, 	prefix1 + "cntr_grs_wgt", 		false, 	"", dfFloat, 	3, true, 	true, 	11);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "upd_dt");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "vsl_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "skd_voy_no");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "skd_dir_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "yd_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "pol_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "bkg_shpr_ownr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_smry_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "slan_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_dp_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "hid");
		
					// 대문자 처리
					InitDataValid(0, prefix1 + "prnr_cntr_ref_no", vtEngUpOther, "1234567890-");
					InitDataValid(0, prefix1 + "crr_cd",           vtEngUpOnly);
					InitDataValid(0, prefix1 + "cntr_qty",         vtNumericOnly);
	
					HeadRowHeight = 20;
				}
				break;
	
			case 2: // sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 340;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);
		
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
		
					var HeadTitle1 = "|No.||BKG Ref. No.|CNTR No.|POD|BS\nCD|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|OverAll (cm)|OverAll (cm)|OverAll (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL Ref. No.|Remark(s)||||||||||||";
					var HeadTitle2 = "|No.||BKG Ref. No.|CNTR No.|POD|BS\nCD|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL Ref. No.|Remark(s)||||||||||||";
		
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	true, 	prefix2 + "No.");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk", 				false, "", dfNone, 			0, true, 	true);
					InitDataProperty(0, cnt++, dtData, 			90, 	daLeft, 	true, 	prefix2 + "prnr_bkg_ref_no", 		true,  "", dfNone, 			0, true, 	true, 30);
					InitDataProperty(0, cnt++, dtData, 			86, 	daLeft, 	true, 	prefix2 + "prnr_cntr_ref_no", 		false, "", dfNone, 			0, true, 	true, 30);
					InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	true, 	prefix2 + "pod_cd", 				true,  "", dfNone, 			0, true, 	true, 5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "mlb_cd", 				false, "", dfNone, 			0, true, 	true);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "crr_cd", 				false, "", dfNone, 			0, false, 	false, 4);
					InitDataProperty(0, cnt++, dtCombo, 	    40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd", 			true,  "", dfNone, 			0, true, 	true, 4);

					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter,   true, 	prefix2 + "dcgo_flg", 				false, "", dfNone, 			0, true, 	true, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "rc_flg", 				false, "", dfNone, 			0, true, 	true, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "awk_cgo_flg", 			false, "", dfNone, 			0, true, 	true, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "bb_cgo_flg", 			false, "", dfNone, 			0, true, 	true, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "stwg_cgo_flg", 			false, "", dfNone, 			0, true, 	true, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	prefix2 + "cntr_seq", 				true,  "", dfNullInteger, 	0, true, 	true, 4);
					InitDataProperty(0, cnt++, dtData, 			45, 	daCenter, 	false, 	prefix2 + "cgo_seq", 				true,  "", dfNullInteger, 	0, true, 	true, 4);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	prefix2 + "cntr_grs_wgt", 			false, "", dfNullFloat, 	3, true, 	true, 9);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	prefix2 + "cgo_grs_wgt", 			false, "", dfNullFloat, 	3, true, 	true, 9);

					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "imdg_clss_cd", 			false, "", dfNone, 			0, false, 	false, 3);
					
					InitDataProperty(0, cnt++, dtPopupEdit, 	50, 	daCenter, 	true, 	prefix2 + "imdg_un_no", 			false, "", dfNone, 			0, false, 	false, 4, true);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	prefix2 + "imdg_subs_rsk_lbl_cd", 	false, "", dfNone, 			0, false, 	false);
					InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix2 + "imdg_mrn_polut_cd", 		false, "", dfNone, 			0, false, 	false, 10);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "pck_grp_cd", 			false, "", dfNone, 			0, false, 	false, 1);
					InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix2 + "lmt_qty_flg", 			false, "", dfNone, 			0, false, 	false, 1);
					InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix2 + "expt_qty_flg", 			false, "", dfNone,		 	0, false, 	false, 1);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "fdo_temp", 				false, "", dfNullFloat, 	2, false, 	false, 3);
					InitDataProperty(0, cnt++, dtData, 			75, 	daCenter, 	true, 	prefix2 + "cdo_temp", 				false, "", dfNullFloat, 	1, false, 	false, 3);
		
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	prefix2 + "cbf_cmdt_nm", 			false, "", dfNone, 			0, false, 	false, 100);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	prefix2 + "dim_len", 				false, "", dfNumber, 	    2, false, 	false, 7);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	prefix2 + "dim_wdt", 				false, "", dfNumber, 	    2, false, 	false, 7);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	prefix2 + "dim_hgt", 				false, "", dfNumber, 	    2, false, 	false, 7);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	true, 	prefix2 + "fwrd_ovr_dim_len", 		false, "", dfNullInteger, 	0, false, 	false, 3);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	true, 	prefix2 + "bkwd_ovr_dim_len", 		false, "", dfNullInteger, 	0, false, 	false, 3);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	true, 	prefix2 + "lf_sd_ovr_dim_len", 		false, "", dfNullInteger, 	0, false, 	false, 3);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	true, 	prefix2 + "rt_sd_ovr_dim_len", 		false, "", dfNullInteger, 	0, false, 	false, 3);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	true, 	prefix2 + "hgt_ovr_dim_len", 		false, "", dfNullInteger, 	0, false, 	false, 3);
		
					InitDataProperty(0, cnt++, dtCombo, 		45, 	daLeft, 	true, 	prefix2 + "crn_pst_sts_cd", 		false, "", dfNone, 			0, false, 	false);
					InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	true, 	prefix2 + "stwg_cd", 			    false, "", dfNone, 			0, false, 	false, 4);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	prefix2 + "apro_ref_no", 			false, "", dfNone, 			0, true, 	true, 50);
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	prefix2 + "cbf_rmk", 				false, "", dfNone, 			0, true, 	true, 1000);
		
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "upd_dt");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "vsl_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "skd_voy_no");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "skd_dir_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "bkg_shpr_ownr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "yd_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "pol_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_smry_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_dp_cd");
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,   false,	prefix2 + "prp_shp_nm");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "hid");
		
					// 대문자 처리
					//InitDataValid(0, prefix2 + "prnr_bkg_ref_no",  vtEngOther,   "1234567890-");		
					//InitDataValid(0, prefix2 + "cbf_cmdt_nm",      vtEngOther,   "1234567890");
					InitDataValid(0, prefix2 + "prnr_cntr_ref_no", vtEngUpOther, "1234567890-");
					InitDataValid(0, prefix2 + "apro_ref_no",      vtEngOther,   "1234567890-");		
					//InitDataValid(0, prefix2 + "cbf_rmk",          vtEngOther,   "1234567890/*:, ");
		
					// 숫자 처리
					InitDataValid(0, prefix2 + "imdg_un_no",       vtNumericOther, ".");
		
					ImageList(0) = "img/alps/button/btns_multisearch.gif";
					ImageList(1) = "img/alps/button/btng_minus.gif";

					FocusEditMode = -1;
					HeadRowHeight = 20;
				}
				break;
	
		}
	}
	 
	/**
	 * t1sheet1 조회후 처리
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		
		var tabObj    = tabObjects[0];		
		var selTabIdx = tabObj.SelectedIndex;
		
		with (sheetObj) {
			if(RowCount > 0) {
				ColumnSort(prefix1+"upd_dt");
				
				ComSetObjValue(formObj.upd_usr_id, CellValue(LastRow, prefix1+"upd_usr_id"));
				ComSetObjValue(formObj.upd_dt,     CellValue(LastRow, prefix1+"upd_dt"));
				
				ColumnSort(prefix1+"pod_cd|"+prefix1+"cntr_tpsz_cd|"+prefix1+"prnr_cntr_ref_no");
				
				ComBtnEnable("btn_SummaryPreview");	
			}
		}
		
		sheetObj.HeadCheck(0, 2) = false;
		
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_LoadFile");
		ComBtnEnable("t1btn_RowAdd");
		ComBtnEnable("t1btn_RowInsert");
		ComBtnEnable("t1btn_Delete");
		ComBtnEnable("t1btn_LoadFileTemplate");
		ComBtnEnable("t1btn_WGPCalcu");
	}
	 
	/**
	 * t1sheet1 엑셀 업로드후 처리
	 */
	function t1sheet1_OnLoadExcel(sheetObj) {
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		//로드된 데이타 기본정보 셋팅
		if (sheetObj.RowCount > 0) {
			sheetObj.Redraw = false;
			for (var rowCt = sheetObj.HeaderRows; rowCt <= sheetObj.LastRow; rowCt++) {
				if (sheetObj.RowStatus(rowCt) != "D") {
					sheetObj.CellValue2(rowCt, prefix1+"crr_cd")            = ComGetObjValue(formObj.crr_cd);
					sheetObj.CellValue2(rowCt, prefix1+"vsl_cd")            = ComGetObjValue(formObj.vsl_cd);
					sheetObj.CellValue2(rowCt, prefix1+"skd_voy_no")        = ComGetObjValue(formObj.skd_voy_no);
					sheetObj.CellValue2(rowCt, prefix1+"skd_dir_cd")        = ComGetObjValue(formObj.skd_dir_cd);	 							
					sheetObj.CellValue2(rowCt, prefix1+"yd_cd")             = formObj.yd_cd.text;
					sheetObj.CellValue2(rowCt, prefix1+"pol_clpt_ind_seq")  = comboObj.Code.substring(comboObj.Code.length-1, comboObj.Code.length);
					sheetObj.CellValue2(rowCt, prefix1+"pod_clpt_ind_seq")  = sheetObj.CellValue(rowCt, prefix1+"pod_clpt_ind_seq") + "1";
					sheetObj.CellValue2(rowCt, prefix1+"bkg_shpr_ownr_flg") = "N";								
					sheetObj.CellValue2(rowCt, prefix1+"cbf_dp_cd")         = "V";
					sheetObj.CellValue2(rowCt, prefix1+"hid")               = "V";
					
					for (var colCt = 0; colCt <= sheetObj.LastCol; colCt++) {
						sheetObj.SelectCell(rowCt, colCt);
					}
				}
			}
			sheetObj.Redraw = true;
		}
	}
	 
	/**
	 * t2sheet1 조회후 처리
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		
		var tabObj    = tabObjects[0];		
		var selTabIdx = tabObj.SelectedIndex;
		
		with (sheetObj) {
			if(RowCount > 0) {
				ColumnSort(prefix2+"upd_dt");
				
				if(ComGetObjValue(formObj.upd_dt) != '') {
					var updDt1 = ComGetObjValue(formObj.upd_dt);
					var updDt2 = CellValue(LastRow, prefix2+"upd_dt");
					updDt1 = updDt1.replaceStr("-", "").replaceStr(" ", "").replaceStr(":", "");
					updDt2 = updDt2.replaceStr("-", "").replaceStr(" ", "").replaceStr(":", "");
					
					if(parseInt(updDt1) < parseInt(updDt2)) {
						ComSetObjValue(formObj.upd_usr_id, CellValue(LastRow, prefix2+"upd_usr_id"));
						ComSetObjValue(formObj.upd_dt,     CellValue(LastRow, prefix2+"upd_dt"));
					}
				} else {
					ComSetObjValue(formObj.upd_usr_id, CellValue(LastRow, prefix2+"upd_usr_id"));
					ComSetObjValue(formObj.upd_dt,     CellValue(LastRow, prefix2+"upd_dt"));
				}
				
				ColumnSort(prefix2+"pod_cd|"+prefix2+"mlb_cd|"+prefix2+"cntr_tpsz_cd"+prefix2+"cntr_seq|"+prefix2+"cgo_seq|"+prefix2+"prnr_bkg_ref_no|"+prefix2+"prnr_cntr_ref_no");
				
				//Cargo별 편집 항목 설정
				for (var rowCt = HeaderRows; rowCt <= LastRow; rowCt++) {
					isEditCol(sheetObj, rowCt);
					
					RowStatus(rowCt) = "R";
				}
				
				ComBtnEnable("btn_SummaryPreview");	
			}
		}
		
		sheetObj.HeadCheck(0, 2) = false;
		sheetObj.HeadCheck(1, 2) = false;
		
		ComBtnEnable("t2btn_RowAdd");
		ComBtnEnable("t2btn_CntrAdd");
		ComBtnEnable("t2btn_CgoAdd");
		ComBtnEnable("t2btn_RowCopy");
		ComBtnEnable("t2btn_Delete");
		ComBtnEnable("t2btn_LoadFileTemplate");
	}
	 
	/**
	 * t2sheet1 엑셀 업로드후 처리
	 */
	function t2sheet1_OnLoadExcel(sheetObj) {alert("#01");
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		//로드된 데이타 기본정보 셋팅
		if (sheetObj.RowCount > 0) {
			sheetObj.Redraw = false;
			for (var rowCt = sheetObj.HeaderRows; rowCt <= sheetObj.LastRow; rowCt++) {
				if (sheetObj.RowStatus(rowCt) != "D") {
					sheetObj.CellValue2(rowCt, prefix2+"crr_cd")            = ComGetObjValue(formObj.crr_cd);
					sheetObj.CellValue2(rowCt, prefix2+"vsl_cd")            = ComGetObjValue(formObj.vsl_cd);
					sheetObj.CellValue2(rowCt, prefix2+"skd_voy_no")        = ComGetObjValue(formObj.skd_voy_no);
					sheetObj.CellValue2(rowCt, prefix2+"skd_dir_cd")        = ComGetObjValue(formObj.skd_dir_cd);	 							
					sheetObj.CellValue2(rowCt, prefix2+"yd_cd")             = formObj.yd_cd.text;	 
					sheetObj.CellValue2(rowCt, prefix2+"pol_clpt_ind_seq")  = comboObj.Code.substring(comboObj.Code.length-1, comboObj.Code.length);
					sheetObj.CellValue2(rowCt, prefix2+"pod_clpt_ind_seq")  = sheetObj.CellValue(rowCt, prefix2+"pod_clpt_ind_seq") + "1";
					sheetObj.CellValue2(rowCt, prefix2+"bkg_shpr_ownr_flg") = "N";	 							
					sheetObj.CellValue2(rowCt, prefix2+"cbf_dp_cd")         = "S";
					sheetObj.CellValue2(rowCt, prefix2+"hid")               = "S";
					
					//Un No. 관련 항목 업로드에서 제외
					sheetObj.CellValue2(rowCt, prefix2+"imdg_un_no")           = "";
					sheetObj.CellValue2(rowCt, prefix2+"imdg_clss_cd")         = "";
					sheetObj.CellValue2(rowCt, prefix2+"prp_shp_nm")		   = "";
					sheetObj.CellValue2(rowCt, prefix2+"imdg_subs_rsk_lbl_cd") = "";
					sheetObj.CellValue2(rowCt, prefix2+"pck_grp_cd")           = "";
					
					for (var colCt = 0; colCt <= sheetObj.LastCol; colCt++) {
						if(colCt>=sheetObj.SaveNameCol(prefix2+"imdg_mrn_polut_cd") && 
						   colCt<=sheetObj.SaveNameCol(prefix2+"stwg_cd")           && 
						   colCt!=sheetObj.SaveNameCol(prefix2+"pck_grp_cd")) 
						{
							sheetObj.CellEditable(rowCt, colCt) = true;
						}
						sheetObj.SelectCell(rowCt, colCt);
					}
					
					//Cargo별 편집 항목 설정
					isEditCol(sheetObj, rowCt);
				}
			}
			sheetObj.Redraw = true;
		}	
	}
	 
	/**
	 * Cargo별 편집 항목 설정
	 */
	function isEditCol(sheetObj, row) {		
		with(sheetObj) {
			var dcgoFlg    = CellValue(row, prefix2+"dcgo_flg");
			var rcFlg      = CellValue(row, prefix2+"rc_flg");
			var awkCgoFlg  = CellValue(row, prefix2+"awk_cgo_flg");
			var bbCgoFlg   = CellValue(row, prefix2+"bb_cgo_flg");
			var stwgCgoFlg = CellValue(row, prefix2+"stwg_cgo_flg");
			
			var dgBool = false;
			var rfBool = false;
			var abBool = false;
			var akBool = false;
			var stBool = false;
			var alBool = false;
			
			if(dcgoFlg == '1' || dcgoFlg == 'Y') {
				dgBool = true;
				alBool = true;
			}
			if(rcFlg == '1' || rcFlg == 'Y') {
				rfBool = true;
				alBool = true;
			}
			if(awkCgoFlg == '1' || awkCgoFlg == 'Y' || bbCgoFlg == '1' || bbCgoFlg == 'Y') {
				abBool = true;
				alBool = true;
				if(awkCgoFlg == '1' || awkCgoFlg == 'Y') akBool = true;
			}
			if(stwgCgoFlg == '1' || stwgCgoFlg == 'Y') {
				stBool = true;
				alBool = true;
			}
			
			//DG
			if(!dgBool) {
				CellValue2(row, prefix2+"imdg_clss_cd")         = "";
				CellValue2(row, prefix2+"imdg_un_no")           = "";
				CellValue2(row, prefix2+"imdg_subs_rsk_lbl_cd") = "";
				CellValue2(row, prefix2+"imdg_mrn_polut_cd")    = "";
				CellValue2(row, prefix2+"pck_grp_cd")           = "";
				CellValue2(row, prefix2+"lmt_qty_flg")          = "";
				CellValue2(row, prefix2+"expt_qty_flg")         = "";
				CellValue2(row, prefix2+"fdo_temp")             = "";
				CellValue2(row, prefix2+"prp_shp_nm")           = "";
			}
			CellEditable(row, prefix2+"imdg_un_no")           = dgBool;
			CellEditable(row, prefix2+"imdg_mrn_polut_cd")    = dgBool;
			CellEditable(row, prefix2+"lmt_qty_flg")          = dgBool;
			CellEditable(row, prefix2+"expt_qty_flg")         = dgBool;
			CellEditable(row, prefix2+"fdo_temp")             = dgBool;
			
			//RF
			if(!rfBool) {
				CellValue2(row, prefix2+"cdo_temp")             = "";
			}
			CellEditable(row, prefix2+"cdo_temp")             = rfBool;
			
			//AK, BB
			if(!abBool) {
				CellValue2(row, prefix2+"dim_len")              = "";
				CellValue2(row, prefix2+"dim_wdt")              = "";
				CellValue2(row, prefix2+"dim_hgt")              = "";
			}
			CellEditable(row, prefix2+"dim_len")              = abBool;
			CellEditable(row, prefix2+"dim_wdt")              = abBool;
			CellEditable(row, prefix2+"dim_hgt")              = abBool;
			
			//AK
			if(!akBool) {
				CellValue2(row, prefix2+"fwrd_ovr_dim_len")     = "";
				CellValue2(row, prefix2+"bkwd_ovr_dim_len")     = "";
				CellValue2(row, prefix2+"lf_sd_ovr_dim_len")    = "";
				CellValue2(row, prefix2+"rt_sd_ovr_dim_len")    = "";
				CellValue2(row, prefix2+"hgt_ovr_dim_len")      = "";
				CellValue2(row, prefix2+"crn_pst_sts_cd")       = "";
			}
			CellEditable(row, prefix2+"fwrd_ovr_dim_len")     = akBool;
			CellEditable(row, prefix2+"bkwd_ovr_dim_len")     = akBool;
			CellEditable(row, prefix2+"lf_sd_ovr_dim_len")    = akBool;
			CellEditable(row, prefix2+"rt_sd_ovr_dim_len")    = akBool;
			CellEditable(row, prefix2+"hgt_ovr_dim_len")      = akBool;
			CellEditable(row, prefix2+"crn_pst_sts_cd")       = akBool;
			
			//ST
			if(!stBool) {
				CellValue2(row, prefix2+"stwg_cd")              = "";
			}
			CellEditable(row, prefix2+"stwg_cd")              = stBool;	
			
			//공통
			if(!alBool) {
				CellValue2(row, prefix2+"cbf_cmdt_nm")       = "";
			}
			CellEditable(row, prefix2+"cbf_cmdt_nm")          = alBool;
		}
	}
	 
	/**
	 * Weight Group 상태 결정
	 */
	function fixWeightGroup(formObj, sheetObj, row, weitImgFlg) {			
		with(sheetObj) {	
			Redraw = false;
			if (RowStatus(row) != "D" && RowStatus(row) != "R") {
				var cntrGrsWgtVal  = CellValue(row, prefix1+"cntr_grs_wgt");	
				var cntrQtyVal     = CellValue(row, prefix1+"cntr_qty");	
				var fullMtyCdVal   = CellValue(row, prefix1+"full_mty_cd");	
				var cntrTpszCdVal  = CellValue(row, prefix1+"cntr_tpsz_cd");
				var cntrTpszCdVal2 = cntrTpszCdVal.substring(1, 2);
				
				//(1. FM이 F인 경우)와 (2. Container 수량이 존재하는 것)과 (3. TP가 해당유형인 건)에 대해서만 계산한다.
				if (fullMtyCdVal == 'F' && (cntrQtyVal != "" && cntrQtyVal != "0")
						                && (cntrTpszCdVal2 == "2" || cntrTpszCdVal2 == "3" || cntrTpszCdVal2 == "4" || cntrTpszCdVal2 == "5" || cntrTpszCdVal2 == "7")
				) {
					//4. Gross Weight가 0인 경우 무조건 'Ultra Light'으로 지정
					if (cntrGrsWgtVal == "0") {
						if(CellValue(row, prefix1+"cntr_wgt_grp_cd") != "Ultra Light") CellValue2(row, prefix1+"cntr_wgt_grp_cd") = "Ultra Light";
					} else {
						ComSetObjValue(formObj.cntr_grs_wgt, cntrGrsWgtVal);
						ComSetObjValue(formObj.cntr_tpsz_cd, cntrTpszCdVal);
						ComSetObjValue(formObj.cntr_qty,     cntrQtyVal);
						
						WaitImageVisible = weitImgFlg;						
						formObj.f_cmd.value = SEARCH19;
						var sXml = GetSearchXml("VOP_OPF_0020GS.do", FormQueryString(formObj));					
						var sWGP = ComGetEtcData(sXml, "sWGP");						
						WaitImageVisible = true;
		
						if (typeof sWGP == "undefined" || sWGP == "") {	
							if(CellValue(row, prefix1+"cntr_wgt_grp_cd") != '') CellValue2(row, prefix1+"cntr_wgt_grp_cd") = "";
						} else {
							if(CellValue(row, prefix1+"cntr_wgt_grp_cd") != sWGP) CellValue2(row, prefix1+"cntr_wgt_grp_cd") = sWGP;
						}
					}
				} else {
					if(CellValue(row, prefix1+"cntr_wgt_grp_cd") != '') CellValue2(row, prefix1+"cntr_wgt_grp_cd") = "";
				}
			}
			Redraw = true;
		}
	}
	 
	/**
	 * Weight Group 계산
	 */
	function calculateWGP(sheetObj, formObj, weitImgFlg) {
		//1. 계산에 필요한 필수항목 체크
		var sParam = ComGetSaveString(sheetObj, false, true);
 		if (sParam == "") return;
		//2. Container Qty 수량을 체크한다.
		if (validateForm(sheetObj, formObj, IBROWSEARCH)) {	 			
			for (var rowCt = sheetObj.HeaderRows; rowCt <= sheetObj.LastRow; rowCt++) {
				fixWeightGroup(formObj, sheetObj, rowCt, weitImgFlg);
			}
		}
	}
	 
	/**
	 * Sheet1 OnChange Event
	 */
	function t1sheet1_OnChange(sheetObj, row, col, value) {			
		with(sheetObj) {
			if (ColSaveName(col) == prefix1+"full_mty_cd"  || 
				ColSaveName(col) == prefix1+"cntr_tpsz_cd" || 
				ColSaveName(col) == prefix1+"cntr_qty"     || 
				ColSaveName(col) == prefix1+"cntr_grs_wgt") {
		
				fixWeightGroup(document.form, sheetObj, row, false);		
			}
		}
	}
	 
	/**
	 * Sheet2 OnChange Event
	 */
	function t2sheet1_OnChange(sheetObj, row, col, value) {
		 with(sheetObj) {
			if (ColSaveName(col) == prefix2+"dcgo_flg"     || 
				ColSaveName(col) == prefix2+"rc_flg"       || 
				ColSaveName(col) == prefix2+"awk_cgo_flg"  || 
				ColSaveName(col) == prefix2+"bb_cgo_flg"   ||
				ColSaveName(col) == prefix2+"stwg_cgo_flg") 
			{		
				isEditCol(sheetObj, row);		
			} else if (row >= HeaderRows && ColSaveName(col) == prefix2+"imdg_un_no") {
				var len = EditValue.length;
				if (len >=4) {
					checkUNNo(sheetObj, row, col);
				} else {
					if(CellValue(row, col) != "") {
						ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
						CellValue2(row, prefix2+"imdg_un_no")         = "";
						
						SelectCell(row, col);
					}
					// Sheet Row 초기화
					CellValue2(row, prefix2+"imdg_clss_cd")         = "";
					CellValue2(row, prefix2+"prp_shp_nm")			= "";
					CellValue2(row, prefix2+"imdg_subs_rsk_lbl_cd") = "";
					CellValue2(row, prefix2+"pck_grp_cd")           = "";
				}
			}
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, col, row) {
	 	sheetObj.ShowDebugMsg = false;
	 	switch (sAction) {
	 		case IBSEARCH: //조회
	 			if (!validateForm(sheetObj, formObj, sAction)) return false;
	 			
	 			sheetObj.Redraw = false;
	 		
		 		var prefixs = new Array(prefix1, prefix2);
		 		formObj.f_cmd.value = SEARCHLIST01;
	 			var sXml = sheetObj.GetSearchXml("VOP_OPF_0020GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs));
			
	 			var arrXml = sXml.split("|$$|");
	 			
	 			if (arrXml.length > 1) {
	 				for ( var i = 0; i < arrXml.length; i++) {
	 					sheetObjects[i].LoadSearchXml(arrXml[i]);
	 				}
	 			}
	 			
	 			sheetObj.Redraw = true;

	 			break;
	 		
	 		case IBSAVE: //저장
		 		var sParam = ComGetSaveString(sheetObjects);
		 		if (sParam == "") return;
		 		
		 		if (validateForm(sheetObj, formObj, sAction)) {	 
		 			//Weight Group 계산1 - Container Qty '0' 수량 체크
		 			if (!validateForm(sheetObj, formObj, IBROWSEARCH)) return;
		 			
		 			//Weight Group 계산2
			 		calculateWGP(sheetObjects[0], formObj, false);			 		
			 		sParam = ComGetSaveString(sheetObjects);
			 		
			 		sheetObj.Redraw = false;
			 		
		 			formObj.f_cmd.value = MULTI;	
		 			sParam += "&" + FormQueryString(formObj);	 			
		 			var sXml = sheetObj.GetSaveXml("VOP_OPF_0020GS.do", sParam);
		 			sheetObj.LoadSaveXml(sXml);
		 			
		 			//재조회
		 			doActionIBSheet(sheetObj, formObj, IBSEARCH); 
		 			
		 			sheetObj.Redraw = true;
		 		}
	
		 		break;	

	 		case IBLOADEXCEL: // 엑셀 로드
	 			switch (sheetObj.id) {
	 				case "t1sheet1":
	 					
	 					sheetObj.WaitImageVisible = false;
	 					formObj.f_cmd.value = SEARCH06;
	 					var sXml = sheetObj.GetSearchXml("VOP_OPF_0020GS.do", FormQueryString(formObj));
	 					sheetObj.WaitImageVisible = true;
	 					var sCBFCount = ComGetEtcData(sXml, "sPCBFCount");
	 					
	 					var mappingCol = "1=>3|2=>4|3=>5|4=>7|5=>9|6=>10|7=>11";
	 					
	 					sheetObj.Redraw = false;
	 					if (sCBFCount > 0) {
			 				if (ComShowCodeConfirm("OPF50019")) {
			 					sheetObj.CheckAll(prefix1+"del_chk") = 1;
			 					var rslt = sheetObj.LoadExcel(true, 1, "", 2, -1, "", true, false, mappingCol);
			 					if(rslt) {
			 						//기존 데이타 삭제상태로 변경			 						
			 						ComRowHideDelete(sheetObj, prefix1+"del_chk");			 						
			 					} else {
			 						sheetObj.CheckAll(prefix1+"del_chk") = 0;
			 					}
			 					sheetObj.HeadCheck(0, 2) = false;
			 				}
			 			} else {		
			 				sheetObj.CheckAll(prefix1+"del_chk") = 1;
			 				var rslt = sheetObj.LoadExcel(true, 1, "", 2, -1, "", true, false, mappingCol);
			 				if(rslt) {
			 					//기존 데이타 삭제상태로 변경			 						
			 					ComRowHideDelete(sheetObj, prefix1+"del_chk");	
			 				} else {
			 					sheetObj.CheckAll(prefix1+"del_chk") = 0;
			 				}
			 				sheetObj.HeadCheck(0, 2) = false;
			 			}	 					
	 					sheetObj.Redraw = true;
	 					
	 					break;
	 				case "t2sheet1":
	 					sheetObj.WaitImageVisible = false;
	 					formObj.f_cmd.value = SEARCH07;
	 					var sXml = sheetObj.GetSearchXml("VOP_OPF_0020GS.do", FormQueryString(formObj));
	 					sheetObj.WaitImageVisible = true;
	 					var sCBFCount = ComGetEtcData(sXml, "sPCBFCount");
	 					
	 					var mappingCol = "1=>3|2=>4|3=>5|4=>6|5=>8|6=>9|7=>10|8=>11|9=>12|10=>13|11=>14|12=>15|13=>16|14=>17|15=>18|16=>19|17=>20|18=>21|19=>22|20=>23|21=>24|22=>25|23=>26|24=>27|25=>28|26=>29|27=>30|28=>31|29=>32|30=>33|31=>34|32=>35|33=>36|34=>37|35=>38|36=>39";
	 					
	 					sheetObj.Redraw = false;
	 					if (sCBFCount > 0) {
	 						if (ComShowCodeConfirm("OPF50019")) {
	 							sheetObj.CheckAll(prefix2+"del_chk") = 1; 							
	 							var rslt = sheetObj.LoadExcel(true, 1, "", 2, -1, "", true, false, mappingCol);
	 							if(rslt) {
	 								//기존 데이타 삭제상태로 변경
	 								ComRowHideDelete(sheetObj, prefix2+"del_chk");
	 							} else {
	 								sheetObj.CheckAll(prefix2+"del_chk") = 0;
	 							}
	 							sheetObj.HeadCheck(0, 2) = false;
	 							sheetObj.HeadCheck(1, 2) = false;
	 						}
			 			} else {
			 				sheetObj.CheckAll(prefix2+"del_chk") = 1; 	
			 				var rslt = sheetObj.LoadExcel(true, 1, "", 2, -1, "", true, false, mappingCol);
			 				if(rslt) {
 								//기존 데이타 삭제상태로 변경
 								ComRowHideDelete(sheetObj, prefix2+"del_chk");
 							} else {
 								sheetObj.CheckAll(prefix2+"del_chk") = 0;
 							}
 							sheetObj.HeadCheck(0, 2) = false;
 							sheetObj.HeadCheck(1, 2) = false;
			 			}	 					
	 					sheetObj.Redraw = true;
			 			
			 			break;
	 			}
	 			break;
	 	}
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Volume/Weight", -1);
				InsertTab(cnt++, "Special Cargo", -1);
			}
			break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		// --------------- 요기가 중요 ----------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		//1.기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
		switch (sAction) {
	
			case IBSEARCH:
				if (comboObjects[0].Code == "") {
					ComShowCodeMessage("COM130404", "POL", "POL");
					formObj.yd_cd.focus();
					return false;
				}
				
				//폼 개체 안에 모든 컨트롤의 Validation을 확인
				if (!ComChkValid(formObj, true, false, false))
					return false;
	
				break;
	
			case IBROWSEARCH:	
				var sheetObj1 = sheetObjects[0];				
				
				//Volume Container Qty '0' 수량 체크
				if (sheetObj1.RowCount > 0) {
					for (var rowCt = sheetObj1.HeaderRows; rowCt <= sheetObj1.LastRow; rowCt++) {
						if(sheetObj1.RowStatus(rowCt) != 'D') {
							if ((parseInt(sheetObj1.CellValue(rowCt, prefix1+"cntr_qty"))) == 0) {
								ComShowCodeMessage("OPF50009", "Q'ty");	//'Please input {?msg1}.'
								
								tabObjects[0].SelectedIndex = 0;
								sheetObj1.SelectCell(rowCt, prefix1+"cntr_qty");
								
								return false;
							}
						}
					}
				}
				break;
				
			case IBSAVE:
				var sheetObj1 = sheetObjects[0];
				var sheetObj2 = sheetObjects[1];
				
				//Volume 중복 체크
				for (var rowCt1 = sheetObj1.HeaderRows; rowCt1 < sheetObj1.LastRow; rowCt1++) {
					if(sheetObj1.RowStatus(rowCt1) != 'D') {
						var prnrCntrRefNo1 = sheetObj1.CellValue(rowCt1, prefix1+"prnr_cntr_ref_no");
						var cntrQty1       = sheetObj1.CellValue(rowCt1, prefix1+"cntr_qty");

						for (var rowCt2 = rowCt1 + 1; rowCt2 <= sheetObj1.LastRow; rowCt2++) {
							if(sheetObj1.RowStatus(rowCt2) != 'D') {
								var prnrCntrRefNo2 = sheetObj1.CellValue(rowCt2, prefix1+"prnr_cntr_ref_no");
								var cntrQty2       = sheetObj1.CellValue(rowCt2, prefix1+"cntr_qty");
								if (prnrCntrRefNo1 != "" && prnrCntrRefNo2 != "" && cntrQty1 != "" && cntrQty2 != "" && (prnrCntrRefNo1 == prnrCntrRefNo2)) {
									ComShowCodeMessage("OPF50005", "CNTR No.");
									
									tabObjects[0].SelectedIndex = 0;
									sheetObj1.SelectCell(rowCt2, prefix1+"prnr_cntr_ref_no", true);
									return false;
								}
							}
						}
					}
				}
				
				//Special Cargo 유형 필수항목 체크
				for (var rowCt = sheetObj2.HeaderRows; rowCt < sheetObj2.LastRow; rowCt++) {
					if(sheetObj2.RowStatus(rowCt) != 'D') {
						if ((sheetObj2.CellValue(rowCt, prefix2+"dcgo_flg") != "1")    && (sheetObj2.CellValue(rowCt, prefix2+"rc_flg") != "1")     &&
							(sheetObj2.CellValue(rowCt, prefix2+"awk_cgo_flg") != "1") && (sheetObj2.CellValue(rowCt, prefix2+"bb_cgo_flg") != "1") &&
							(sheetObj2.CellValue(rowCt, prefix2+"stwg_cgo_flg") != "1")) 
						{
							ComShowCodeMessage("OPF50009", "Special Cargo Type");	//'Please input {?msg1}.'
							
							tabObjects[0].SelectedIndex = 1;
							sheetObj2.SelectCell(rowCt, prefix2+"dcgo_flg");
							return false;
						}
					}
				}
				//Special 중복 체크(BKG No. + Container Seq. + Cargo Seq. && BKG No. + MLB)
				for (var rowCt1 = sheetObj2.HeaderRows; rowCt1 < sheetObj2.LastRow; rowCt1++) {
					if(sheetObj2.RowStatus(rowCt1) != 'D') {
						var prnrBkgRefNo1 = sheetObj2.CellValue(rowCt1, prefix2+"prnr_bkg_ref_no");
						var cntrSeq1      = sheetObj2.CellValue(rowCt1, prefix2+"cntr_seq");
						var cgoSeq1       = sheetObj2.CellValue(rowCt1, prefix2+"cgo_seq");
						var uniqA         = prnrBkgRefNo1 + cntrSeq1 + cgoSeq1;
						
						var mlbCd1        = sheetObj2.CellValue(rowCt1, prefix2+"mlb_cd");

						for (var rowCt2 = rowCt1 + 1; rowCt2 <= sheetObj2.LastRow; rowCt2++) {
							if(sheetObj2.RowStatus(rowCt2) != 'D') {
								var prnrBkgRefNo2 = sheetObj2.CellValue(rowCt2, prefix2+"prnr_bkg_ref_no");
								var cntrSeq2      = sheetObj2.CellValue(rowCt2, prefix2+"cntr_seq");
								var cgoSeq2       = sheetObj2.CellValue(rowCt2, prefix2+"cgo_seq");
								var uniqB         = prnrBkgRefNo2 + cntrSeq2 + cgoSeq2;
								
								var mlbCd2        = sheetObj2.CellValue(rowCt2, prefix2+"mlb_cd");
								
								//BKG No. + Container Seq. + Cargo Seq.
								if (uniqA == uniqB) {
									ComShowCodeMessage("OPF50005", "BKG Ref. No. + CNTR SEQ + CGO SEQ");
									
									tabObjects[0].SelectedIndex = 1;
									sheetObj2.SelectCell(rowCt2, prefix2+"prnr_bkg_ref_no", true);
									return false;
								}
								//BKG No. + MLB
								if (prnrBkgRefNo1 == prnrBkgRefNo2 && (mlbCd1 != '' && mlbCd2 != '' && mlbCd1 == mlbCd2)) {
									ComShowCodeMessage("OPF50005", "BKG Ref. No. + MLB");
									
									tabObjects[0].SelectedIndex = 1;
									sheetObj2.SelectCell(rowCt2, prefix2+"mlb_cd", true);
									return false;
								}
							}
						}
					}
				}
				//Stwage 필수항목 체크
				for (var rowCt = sheetObj2.HeaderRows; rowCt < sheetObj2.LastRow; rowCt++) {
					if(sheetObj2.RowStatus(rowCt) != 'D') {
						if ((sheetObj2.CellValue(rowCt, prefix2+"stwg_cgo_flg") == "1") && (sheetObj2.CellValue(rowCt, prefix2+"stwg_cd") == "")) {
							ComShowCodeMessage("OPF50009", "STWG");
							
							tabObjects[0].SelectedIndex = 1;
							sheetObj2.SelectCell(rowCt, prefix2+"stwg_cd");
							return false;
						}
					}
				}
		
				break;
		}
		return true;
	}
	 
	/**
	 * Sheet1 OnKeyUp Event 처리
	 * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
	 * 
	 */
	function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		with (sheetObj) {
			var len = EditValue.length;
			if (ColSaveName(Col) == prefix2+"imdg_un_no") {
				if (len == 4 && KeyCode != 229 && KeyCode != 67 && KeyCode != 17) {
					sheetObj.SelectCell(Row, prefix2+"imdg_mrn_polut_cd");
				}
			}
		}
	}

	/**
	 * UN No. Validation
	 */
	function checkUNNo(sheetObj, Row, Col) {
		var formObj = document.form;
		
		var imdgUnNo = sheetObj.CellValue(Row, prefix2+"imdg_un_no");
	
		sheetObjects[1].WaitImageVisible = false;
		formObj.f_cmd.value = SEARCH01;	
		var sXml = sheetObjects[1].GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj) + "&imdg_un_no=" + imdgUnNo);
		sheetObjects[1].WaitImageVisible = true;
	
		var sTotal = ComOpfGetTotalValue(sXml);
		
		// Sheet Row 초기화
		sheetObj.CellValue2(Row, prefix2+"imdg_un_no")           = "";
		sheetObj.CellValue2(Row, prefix2+"imdg_clss_cd")         = "";
		sheetObj.CellValue2(Row, prefix2+"prp_shp_nm")			 = "";
		sheetObj.CellValue2(Row, prefix2+"imdg_subs_rsk_lbl_cd") = "";
		sheetObj.CellValue2(Row, prefix2+"pck_grp_cd")           = "";
	
		if (sTotal == "0") {
			ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
			sheetObj.SelectCell(Row, Col);			
		} else {
			ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo, 940, 397, "setCallBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
		}
	}

	/**
	 * Sheet2 Popup Click Event 처리
	 * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
	 * 
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row, Col) {
		with (sheetObj) {
			var formObj   = document.form;
			var imdgUnNo  = sheetObj.CellValue(Row, prefix2+"imdg_un_no");
			
			ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo, 940, 397, "setCallBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
		}
	}

	/**
	 * Sheet1 OnPopupClick ImdgUnNoSeq 이벤트 처리에 대한 CallBack 함수 
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param seetIdx 
	 * @return
	 */
	function setCallBackUNNo(aryPopupData, row, col, seetIdx) {	
		var sheetObj = sheetObjects[1];
		
		sheetObj.CellValue2(row, prefix2+"imdg_un_no")           = aryPopupData[0][2];
		sheetObj.CellValue2(row, prefix2+"imdg_clss_cd")         = aryPopupData[0][4];
		//sheetObj.CellValue2(row, prefix2+"prp_shp_nm")			 = aryPopupData[0][6];
		sheetObj.CellValue2(row, prefix2+"imdg_subs_rsk_lbl_cd") = aryPopupData[0][8];
		sheetObj.CellValue2(row, prefix2+"pck_grp_cd")           = aryPopupData[0][9];
	}

/* 개발자 작업  끝 */