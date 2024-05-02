/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_0021.js
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2011.11.29 [CHM-201114860-01] 김민아 [OPF] CBF Inquiry Excel Download 기능개선요청
 * 2011.12.12 [CHM-201114818-01] Split 03-특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
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
	 * @class VOP_OPF_0021 : VOP_OPF_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_OPF_0021() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

	/* 개발자 작업	*/
	
	// 공통전역변수
	var tabObjects   = new Array();
	var tabCnt       = 0;
	var beforetab    = 1;
	
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	var headerList   = new Array();
	var stwgNmList;
	
	var comboObjects = new Array();
	var comboCnt     = 0;
	
	var IBSEARCH02   = 30;
	var IBSEARCH03   = 33;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var sheetObj2 = sheetObjects[1]; // t2sheet1
		var sheetObj3 = sheetObjects[2]; // t2sheet2
		var sheetObj4 = sheetObjects[3]; // t2sheet3
		
		var tabObj    = tabObjects[0];
		var formObj   = document.form;

		var selTabIdx = tabObj.SelectedIndex;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {	
				case "btn_Retrieve":
					doActionIBSheet(sheetObj1, formObj, IBSEARCH);
					
					doActionIBSheet(sheetObj2, formObj, IBSEARCH02);
					doActionIBSheet(sheetObj4, formObj, IBSEARCH02);
					doActionIBSheet(sheetObj3, formObj, IBSEARCH03);
		
					break;
					
				case "btn_BookingClosingStatus":
					openBCSPopup(formObj);
					break;
	
				case "btn_WeightGroup":
					openBGPopup(formObj);
					break;
	
				case "btn_DownExcel1":
					sheetObj1.SpeedDown2Excel(-1);
					break;
	
				case "btn_DownExcel2":
					sheetObj2.SpeedDown2Excel(-1);
					break;
	
				case "btn_DownExcel3":
					sheetObj3.SpeedDown2Excel(-1);
					break;
					
				case "btn_DownExcel4":
					sheetObj4.SpeedDown2Excel(-1);
					break;
	
				case "btn_New":
					ComResetAll();
					resetForCondition(formObj, "vvd");
					
					//초기 포커스 위치
					ComSetFocus(formObj.vsl_cd);
					break;
	
				case "btn_Print":
					ComOpenPopup("/hanjin/VOP_OPF_1021.do?" + FormQueryString(formObj), 540, 540, "setCallBackPort", "0,0,1,1,1,1,1", true);
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
	
			} // end switch
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}

	/** 
	 * Weight Group (Creation) 버튼 클릭시 팝업호출
	 */
	function openBGPopup(formObj) {	
		var vSlanCd     = ComGetObjValue(formObj.slan_cd);
		var vSkdDirCd   = ComGetObjValue(formObj.skd_dir_cd);
		
		var vYdCd       = formObj.yd_cd.text;
		var vPolCd      = vYdCd.substr(0, 5);
	
		sUrl = "/hanjin/VOP_OPF_2021.do?slan_cd=" + vSlanCd + "&skd_dir_cd=" + vSkdDirCd + "&pol_cd=" + vPolCd;
		ComOpenPopupWithTarget(sUrl, 700, 535, "yd_cd:yd_cd", "0,0", true);
	}
	 
	/** 
	 * Booking Closing Status 버튼 클릭시 팝업호출
	 */
	function openBCSPopup(formObj) {	
		var vslCd     = ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo  = ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd  = ComGetObjValue(formObj.skd_dir_cd);
		
		var ydCd      = formObj.yd_cd.text;
		var polCd     = ydCd.substring(0, 5);
	
		var paramStr = "";
		paramStr += 'vsl_cd=' + vslCd + skdVoyNo + skdDirCd + '&pol_cd=' + polCd;
		
		ComOpenWindowCenter("/hanjin/ESM_BKG_0587POP.do?pgmNo=ESM_BKG_0587&" + paramStr, "VOP_OPF_0019", 1025, 675, true);
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
		//IBMultiCombo초기화
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
			initSheet(sheetObjects[i], i + 1, new Array('SML','CYL','YML','KNL','SEN'));	
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//버튼 비활성화
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_DownExcel1");
		ComBtnDisable("btn_DownExcel2");
		ComBtnDisable("btn_DownExcel3");
	    ComBtnDisable("btn_DownExcel4");
	    
		//Axon Event Listener 등록
		initControl();
	
		//초기 포커스 위치
		ComSetFocus(document.form.vsl_cd);
	}
	 
	/**
	 * IBCOMBO 초기화. <br>
	 **/
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "yd_cd":
				var i = 0;
				with (comboObj) {
					DropHeight      = 230;
				}
				break;

			case "crr_cd":
				with (comboObj) {
					DropHeight      = 230;
					UseCode         = false;
					Enable          = false;
										
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;
				
			case "pod_cd":
				with (comboObj) {
					DropHeight      = 230;
					Enable          = false;
					
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;
				
			case "mlb_cd":
				with (comboObj) {
					Width           = 50;
					DropHeight      = 230;
					Enable          = false;
										
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;	
		}
	
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);
		axon_event.addListenerForm  ('click',    'obj_click',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
	 
	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}
	
	// 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else ComSetNextFocus(obj);
			
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
	function obj_blur() {
		var formObj  = document.form;
		
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//VVD Info 가져오기
						searchVVDInfo();
					}		
					
					break;
					
				default:
					break;
			}
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
			
			ComSetObjValue(formObj.cbf_ind_flg,    "");
			ComSetObjValue(formObj.cbf_bkg_sts_cd, "");
			
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");	
			
			for (var comboCt=1; comboCt<comboObjects.length; comboCt++) {	
				comboObjects[comboCt].RemoveAll();
				comboObjects[comboCt].InsertItem(0, 'ALL', ' ');
				comboObjects[comboCt].Text2 = "ALL";
				
				comboObjects[comboCt].Enable = false;
			}
		}
		
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();			
		}
		
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_DownExcel1");
		ComBtnDisable("btn_DownExcel2");
		ComBtnDisable("btn_DownExcel3");
		ComBtnDisable("btn_DownExcel4");
	}
	
	/**
	 * POL 콤보 데이터 선택시. <br>
	 **/
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj  = document.form;
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
	
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
				
				sheetObj1.WaitImageVisible = false;
				
				//1. CBF, Booking Status 상태 조회
				formObj.f_cmd.value = SEARCH07;
				
				//파라미터 명시적인 생성
	 			var formParams2 = "";
	     		formParams2 += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
	     		formParams2 += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
	     		formParams2 += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
	     		formParams2 += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
	     		formParams2 += "&yd_cd="      +comboObjects[0].Code; 
				
				var sXml = sheetObj1.GetSearchXml("VOP_OPF_0019GS.do", formParams2);

				var sCbf = ComGetEtcData(sXml, "sCbf");

				if (sCbf != undefined) {
					var arrCbf = sCbf.split("|");
					if ((arrCbf[0] != null) && (arrCbf[0] != '')) {
						ComSetObjValue(formObj.cbf_ind_flg, arrCbf[0]=='null'?"":arrCbf[0]);
					} else {
						ComSetObjValue(formObj.cbf_ind_flg, "");
					}
					if ((arrCbf[1] != null) && (arrCbf[1] != '')) {
						ComSetObjValue(formObj.cbf_bkg_sts_cd, arrCbf[1]=='null'?"":arrCbf[1]);
					} else {
						ComSetObjValue(formObj.cbf_bkg_sts_cd, "");
					}
					if ((arrCbf[2] != null) && (arrCbf[2] != '')) {
						ComSetObjValue(formObj.upd_usr_id, arrCbf[2]=='null'?"":arrCbf[2]);
					} else {
						ComSetObjValue(formObj.upd_usr_id, "");
					}
					if ((arrCbf[3] != null) && (arrCbf[3] != '')) {
						ComSetObjValue(formObj.upd_dt, arrCbf[3]=='null'?"":arrCbf[3]);
					} else {
						ComSetObjValue(formObj.upd_dt, "");
					}
				}
				
				//2. OPR, POD, MLB 콤보 생성
				formObj.f_cmd.value = SEARCH11;
				var sXml = sheetObj1.GetSearchXml("VOP_OPF_0021GS.do", FormQueryString(formObj));
	
				var sOpr  = ComGetEtcData(sXml, "sOpr");	
				var isOpr = false;
				var isCt  = 0;
				if (sOpr != undefined) {
					var arrOpr = sOpr.split("|");					
					for (var i = 0; i < arrOpr.length; i++) {
						if(ComTrim(arrOpr[i]) != '') {
							comboObjects[1].InsertItem(i+1, arrOpr[i], arrOpr[i]);
							isCt++;
						}
					}
					
					if(isCt>0) {
						comboObjects[1].Enable = true;
						
						//3. 동적해더 구성
						sheetObj1.Reset();
						ComConfigSheet(sheetObj1);						
						initSheet(sheetObj1, 1, arrOpr);						
						ComEndConfigSheet(sheetObj1);
						
						sheetObj2.Reset();
						ComConfigSheet(sheetObj2);						
						initSheet(sheetObj2, 2, arrOpr);						
						ComEndConfigSheet(sheetObj2);
						
						sheetObj3.Reset();
						ComConfigSheet(sheetObj3);						
						initSheet(sheetObj3, 3, arrOpr);						
						ComEndConfigSheet(sheetObj3);
						
						isOpr = true;
					}
				}
	
				var sPod = ComGetEtcData(sXml, "sPod");	
				if (sPod != undefined) {
					var arrPod = sPod.split("|");	
					var podCd = ""; //yd_code + clpt_ind_seq
					for (var i = 0; i < arrPod.length; i++) {
						podCd = arrPod[i];
						if(podCd != '') podCd = podCd.substring(0, podCd.length-1); 
						comboObjects[2].InsertItem(i+1, podCd, arrPod[i]);
					}
					
					if(arrPod.length>0) comboObjects[2].Enable = true;
				}
	
				var sMlb = ComGetEtcData(sXml, "sMlb");	
				isCt = 0;
				if (sMlb != undefined) {
					var arrMlb = sMlb.split("|");					
					for (var i = 0; i < arrMlb.length; i++) {
						if(ComTrim(arrMlb[i]) != '') {
							comboObjects[3].InsertItem(i+1, arrMlb[i], arrMlb[i]);
							isCt++;
						}
					}
					
					if(isCt>0) comboObjects[3].Enable = true;
				}
				
				sheetObj1.WaitImageVisible = true;
				
				if(isOpr) {
					//ComBtnEnable("btn_Retrieve");
					ComBtnEnable("btn_Print");
				}
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_BookingClosingStatus");
			}
		}
	}
	 
	/**
	 * OPR 콤보 데이터 선택시. <br>
	 **/
	function crr_cd_OnChange(comboObj, Code, Text) {
		var formObj  = document.form;
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
		
		var headerList = new Array();
		
		if(Code != '') {
			headerList[0] = Text;		
		} else {
			for(var comboCt=1; comboCt<comboObj.GetCount(); comboCt++) {
				headerList[comboCt-1] = comboObj.GetText(comboCt, 0);
			}
		}
		
		if(headerList.length > 0) {
			sheetObj1.Reset();
			ComConfigSheet(sheetObj1);						
			initSheet(sheetObj1, 1, headerList);						
			ComEndConfigSheet(sheetObj1);
			
			sheetObj2.Reset();
			ComConfigSheet(sheetObj2);						
			initSheet(sheetObj2, 2, headerList);						
			ComEndConfigSheet(sheetObj2);
			
			sheetObj3.Reset();
			ComConfigSheet(sheetObj3);						
			initSheet(sheetObj3, 3, headerList);						
			ComEndConfigSheet(sheetObj3);
		}
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
					case "yd_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
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
					resetForCondition(formObj, "vvd");
					
					break;
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
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo, cgoOprList) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		var formObj = document.form;
	
		switch (sheetID) {	
			case "t1sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 340;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);
					
					//동적 해더 구성						
					var HeadTitle1 = "|  |  |  |  | ";
					var HeadTitle2 = "|POD >>|TMNL|BS CD|Weight Group >>|Weight Group <<";	
					var cgoOprVal  = "";
					for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
						cgoOprVal = cgoOprList[cgoOprCt];
						HeadTitle1 = HeadTitle1 + "|OPR|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal;
						HeadTitle2 = HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'|TEU";
					}
					HeadTitle1 = HeadTitle1 + "|Total|Total|Total|Total|Total|Total|Total|Full Units Av.Weight|Full Units Av.Weight||";
					HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'|TTL|TEU|20|40||";
		
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false);
					
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	false,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			62, 	daLeft, 	true, 	"pod", 			false,"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd",	false,"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData,	 		37, 	daLeft, 	true, 	"mlb", 			false,"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 			104, 	daLeft, 	true, 	"fm", 			false,"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData,	 		104, 	daLeft, 	false, 	"wg", 			false,"", dfNone, 0, true, true);
		
					for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
						InitDataProperty(0, cnt++, dtHidden, 	0, 		daCenter, 	false, "opr" + cgoOprCt, 				false, "", dfNone, 			0, 	true, true);
						InitDataProperty(0, cnt++, dtData, 		61, 	daRight, 	false, "opr" + cgoOprCt + "_qty_2", 	false, "", dfNullInteger, 	0,	true, true);
						InitDataProperty(0, cnt++, dtData, 		61, 	daRight, 	false, "opr" + cgoOprCt + "_qty_2h", 	false, "", dfNullInteger, 	0,	true, true);
						InitDataProperty(0, cnt++, dtData, 		61, 	daRight, 	false, "opr" + cgoOprCt + "_qty_4", 	false, "", dfNullInteger, 	0,	true, true);
						InitDataProperty(0, cnt++, dtData, 		61, 	daRight, 	false, "opr" + cgoOprCt + "_qty_4h", 	false, "", dfNullInteger, 	0,	true, true);
						InitDataProperty(0, cnt++, dtData, 		61, 	daRight, 	false, "opr" + cgoOprCt + "_qty_45", 	false, "", dfNullInteger, 	0,	true, true);
						InitDataProperty(0, cnt++, dtData, 		60, 	daRight, 	false, "opr" + cgoOprCt + "_teu", 		false, "", dfNullInteger, 	0, 	true, true);
					}
		
					InitDataProperty(0, cnt++, dtData, 61, daRight, false, 	"tot_qty_2",	false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 61, daRight, false,	"tot_qty_2h", 	false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 61, daRight, false, 	"tot_qty_4",	false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 61, daRight, false,	"tot_qty_4h", 	false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 61, daRight, false,	"tot_qty_45", 	false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daRight, false, 	"tot_ttl",		false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 60, daRight, false, 	"tot_teu",		false, "", dfNullInteger, 0, true, true);
		
					InitDataProperty(0, cnt++, dtData, 		61, daRight, 	false, 	"av_wgt_2",		false, "", dfNullFloat, 1, true, true);
					InitDataProperty(0, cnt++, dtData, 		61, daRight, 	false, 	"av_wgt_4",		false, "", dfNullFloat, 1, true, true);
					
					InitDataProperty(0, cnt++, dtHidden, 	50, daCenter, 	false,	"upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 	50, daCenter, 	false, 	"upd_dt");
					
					ColHidden("mlb") = true;
					ColHidden("wg")  = true;
		
					SelectHighLight = false;
				}
				break;
		
			case "t2sheet1": // sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 362;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 15, 100);		
					
					//동적 해더 구성
					var HeadTitle0 = "|  |  | ";
					var HeadTitle1 = "|  |  | ";
					var HeadTitle2 = "|POD >>|TMNL|BS CD";
					
					var cgoOprVal  = "";
					for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
						cgoOprVal = cgoOprList[cgoOprCt];
						
						HeadTitle0 = HeadTitle0 + "|OPR|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
						HeadTitle0 = HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
						HeadTitle0 = HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
						HeadTitle0 = HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
						HeadTitle0 = HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "";						
						
						
						HeadTitle1 = HeadTitle1 + "|OPR|STWG|STWG|STWG|STWG|STWG";
						HeadTitle1 = HeadTitle1 + "|DG|DG|DG|DG|DG";
						HeadTitle1 = HeadTitle1 + "|RF|RF|RF|RF|RF";
						HeadTitle1 = HeadTitle1 + "|AK|AK|AK|AK";
						HeadTitle1 = HeadTitle1 + "|BB|BB";
												
						
						HeadTitle2 = HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
						HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'";
						HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'";
						HeadTitle2 = HeadTitle2 + "|20'|40'|40HC|45'";
						HeadTitle2 = HeadTitle2 + "|20'|40'";						
					}
					
					HeadTitle0 = HeadTitle0 + "|OPR|TOT|TOT|TOT|TOT|TOT";
					HeadTitle0 = HeadTitle0 + "|TOT|TOT|TOT|TOT|TOT";
					HeadTitle0 = HeadTitle0 + "|TOT|TOT|TOT|TOT|TOT";
					HeadTitle0 = HeadTitle0 + "|TOT|TOT|TOT|TOT";
					HeadTitle0 = HeadTitle0 + "|TOT|TOT";					
					
					HeadTitle1 = HeadTitle1 + "|OPR|STWG|STWG|STWG|STWG|STWG";
					HeadTitle1 = HeadTitle1 + "|DG|DG|DG|DG|DG";
					HeadTitle1 = HeadTitle1 + "|RF|RF|RF|RF|RF";
					HeadTitle1 = HeadTitle1 + "|AK|AK|AK|AK";
					HeadTitle1 = HeadTitle1 + "|BB|BB";					
					
					HeadTitle2 = HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|40'";					
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 1, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false);
		
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
					
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	true,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			64, 	daLeft, 	true, 	"pod", 		  false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd",  false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData,	 		60, 	daLeft, 	true, 	"mlb",	 	  false, "", dfNone, 		0, true, true);
					
					for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
						InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	false,	"opr" + cgoOprCt, 	    false, "", dfNone, 		0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"stwg_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"stwg_2h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"stwg_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"stwg_4h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"stwg_45_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_2h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_4h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_45_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
		
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_2h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_4h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_45_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
		
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_4h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_45_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
		
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"bb_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"bb_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						
					}
					
					InitDataProperty(0, cnt++, dtHidden, 	0,  daCenter, 	false, "opr"+ (cgoOprList.length + 2), 	    false, "", dfNone, 			0, true, true);
					
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "stwg_20_tot",						false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "stwg_2h_tot",						false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "stwg_40_tot",						false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "stwg_4h_tot",						false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "stwg_45_tot",						false, "", dfNullInteger, 	0, true, true);
					
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "dg_20_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "dg_2h_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "dg_40_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "dg_4h_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "dg_45_tot",							false, "", dfNullInteger, 	0, true, true);
		
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "rf_20_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "rf_2h_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "rf_40_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "rf_4h_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "rf_45_tot",							false, "", dfNullInteger, 	0, true, true);
					
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "ak_20_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "ak_40_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "ak_4h_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "ak_45_tot",							false, "", dfNullInteger, 	0, true, true);
		
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "bb_20_tot",							false, "", dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "bb_40_tot",							false, "", dfNullInteger, 	0, true, true);
					
					ColHidden("mlb") = true;
							
					SetMergeCell(0, 1, 2, 2);
					
					ImageList(0) = "img/btng_minus.gif";
					ImageList(1) = "img/btng_plus.gif";
		
					SelectHighLight = false;			
				}
				break;		
		
			case "t2sheet2":
				with (sheetObj) {
					//높이 설정
					style.height = 342;
					//전체 너비 설정
					SheetWidth = subTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//동적 해더 구성
					//Stowage Request 유형 갯수 가져오기
					//-----------------------------------------------------------------------------------------
					formObj.f_cmd.value = SEARCH16;
					var headerXml = "";
					var stwgStr   = "";
					if(ComGetObjValue(formObj.vsl_cd) != '') {
						headerXml = sheetObj.GetSearchXml("VOP_OPF_2019GS.do", FormQueryString(formObj));
						stwgStr = ComGetEtcData(headerXml, "stwgCdList");
					}
					//-----------------------------------------------------------------------------------------
					
					var stwgList = stwgStr.split("|");					
					
					var headTitles = new Array();	//해더 1,2,3 레벨
					var stParams   = new Array();	//Stowage 파라미터 목록
					var stFields   = new Array();	//OPR별 Stowage 목록
					var stFiledCt  = 0;
					var stDup      = false;
					var stCt       = 0;
					
					//Stowage Code & Description 정보 저장
					var stwgNmCt = 0;
					stwgNmList = new Array();
					
					headTitles[0] = "|  |  | ";						
					if(ComTrim(stwgStr) != "") {
						headTitles[1] = "|  |  | ";
						headTitles[2] = "|POD >>|TMNL|BS CD";
						
						var colCt = 0;
						for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
							cgoOprVal = cgoOprList[cgoOprCt];
							
							headTitles[0] += "|OPR";	
							headTitles[1] += "|OPR";
							headTitles[2] += "|OPR";
							
							stFields[cgoOprCt] = new Array();
							stFiledCt = 0;
							
							for (; colCt < stwgList.length;) {
								var stwgCd = stwgList[colCt].split("+")[1];
								
								stwgNmList[stwgNmCt++] = stwgList[colCt].split("+")[1]+"+"+stwgList[colCt].split("+")[2];
								
								if(cgoOprVal == stwgList[colCt].split("+")[0]) {
									headTitles[0] += "|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"";						
									headTitles[1] += "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd;
									headTitles[2] += "|20'|20HC|40'|40HC|45'";
									
									//파라미터 생성
									stDup = false;
									for(var stCts=0; stCts<stParams.length; stCts++) {
										if(stwgCd == stParams[stCts]) stDup = true;
									}
									if(!stDup) stParams[stCt++] = stwgCd;
									
									//OPR별 ST 구성
									stFields[cgoOprCt][stFiledCt++] = stwgCd;
								} else {
									break;
								}
								
								colCt++;
							}
						}
					} else {
						headTitles[1]  = "|POD >>|TMNL|BS CD";
						for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
							cgoOprVal = cgoOprList[cgoOprCt];
							
							headTitles[0] += "|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"";
							headTitles[1] += "|OPR|20'|20HC|40'|40HC|45'";
						}
					}
					
					//파라미터 셋팅				
					cgoOprCt = 0;
					for(stCt=0; stCt<15; stCt++) {
						if(stCt<stParams.length) {
							ComSetObjValue(eval("formObj.st_"+(stCt+1)), stParams[stCt]);
							
							//파라미터에 따른 리턴 필더 구성
							for(var cgoOprCt2=0; cgoOprCt2<stFields.length; cgoOprCt2++) {
								for(stFiledCt=0; stFiledCt<stFields[cgoOprCt2].length; stFiledCt++) {
									if(stParams[stCt] == stFields[cgoOprCt2][stFiledCt]) stFields[cgoOprCt2][stFiledCt] = stCt+1;
								}
							}
						} else {
							ComSetObjValue(eval("formObj.st_"+(stCt+1)), "");
						}
					}
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(headTitles.length, 1, 15, 100);	
					
					var headCount = ComCountHeadTitle(headTitles[0]);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false);
					
					//해더 초기생성
					for(var headCt=0; headCt<headTitles.length; headCt++) {			
						InitHeadRow(headCt, headTitles[headCt], true);
					}
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	true,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			64, 	daLeft, 	true, 	"pod", 			false,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd",	false,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData,	 		60, 	daLeft, 	false, 	"mlb", 			false,	"", dfNone, 0, true, true);
					
					if(ComTrim(stwgStr) != "") {
						for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
							cgoOprVal = cgoOprList[cgoOprCt-1];
							
							InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "opr" + cgoOprCt, false, "", dfNone, 0, true, true);
							
							for ( colCt = 1; stFields[cgoOprCt-1] != null && colCt <= stFields[cgoOprCt-1].length; colCt++) {					
								var fieldIdx = stFields[cgoOprCt-1][colCt-1];
								
								InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ fieldIdx + "_20_opr" + cgoOprCt, false, "", dfNullInteger,0, true, true);
								InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ fieldIdx + "_2h_opr" + cgoOprCt, false, "", dfNullInteger,0, true, true);
								InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ fieldIdx + "_40_opr" + cgoOprCt, false, "", dfNullInteger,0, true, true);
								InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ fieldIdx + "_4h_opr" + cgoOprCt, false, "", dfNullInteger,0, true, true);
								InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ fieldIdx + "_45_opr" + cgoOprCt, false, "", dfNullInteger,0, true, true);
							}
						}
					} else {
						for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
							InitDataProperty(0, cnt++, dtHidden, 	0, 	daCenter, 	false, "opr" + cgoOprCt,		false, "", dfNone, 			0, true, true);
							InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "st1_20_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
							InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "st1_2h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
							InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "st1_40_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
							InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "st1_4h_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
							InitDataProperty(0, cnt++, dtData, 		49, daRight, 	false, "st1_45_opr" + cgoOprCt, false, "", dfNullInteger,	0, true, true);
						}
					}
					
					ColHidden("mlb") = true;
					
					if(ComTrim(stwgStr) != "") {
						SetMergeCell(0, 1, 2, 2);
					}
		
					ImageList(0) = "img/btng_minus.gif";
					ImageList(1) = "img/btng_plus.gif";
		
					SelectHighLight = false;
		
				}
				break;
				
			case "t2sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);
		
					var HeadTitle1 = "|No.|BKG No.|CNTR No.|POD|TMNL|BS\nCD|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|SG|Reefer\nTemp.(°C)|Commodity|OverAll(cm)|OverAll(cm)|OverAll(cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|CBF DP CD||||||||||CBF IND FLG|Booking Status|RD ST|HIDDEN|SLAN CD|";
					var HeadTitle2 = "|No.|BKG No.|CNTR No.|POD|TMNL|BS\nCD|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|SG|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)||||||||||||||||";
		
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	true, 	"No.");
					InitDataProperty(0, cnt++, dtData, 			96, 	daLeft, 	true, 	"bkg_no", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			86, 	daLeft, 	true, 	"cntr_no", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	"mlb_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	"crr_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	"cntr_tpsz_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	"dcgo_flg", 			false, "", dfNone, 		0, false, false, -1,	false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	"rc_flg",				false, "", dfNone, 		0, false, false, -1, 	false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	"awk_cgo_flg", 			false, "", dfNone, 		0, false, false, -1,	false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	"bb_cgo_flg", 			false, "", dfNone, 		0, false, false, -1,	false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	"stwg_cgo_flg", 		false, "", dfNone, 		0, false, false, -1,	false, false, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	false, 	"cntr_seq", 			false, "", dfInteger, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	false, 	"cgo_seq", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	"cntr_grs_wgt", 		false, "", dfNullFloat, 3, false, false);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	"cgo_grs_wgt", 			false, "", dfNullFloat, 3, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	"imdg_clss_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"imdg_un_no", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	"prp_shp_nm", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	"hzd_desc", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	"imdg_subs_rsk_lbl_cd", false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	"imdg_mrn_polut_cd", 	false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	"pck_grp_cd", 			false, "", dfNone, 		0, false, false);	
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	"lmt_qty_flg", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	"expt_qty_flg", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"fdo_temp", 			false, "", dfNullFloat, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, 	"hzd_ctnt", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			75, 	daCenter, 	true, 	"cdo_temp", 			false, "", dfNullFloat, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	"cbf_cmdt_nm", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	"dim_len", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	"dim_wdt", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	"dim_hgt", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	"ovr_fwd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	"ovr_aft", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	"ovr_lft", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	"ovr_rgt", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	"ovr_hgt", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daCenter, 	true, 	"crn_pst_sts_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"stwg_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"spcl_cgo_auth_flg", 	false, "", dfNone,	 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	"apro_ref_no", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	"cbf_rmk", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"cbf_dp_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"upd_dt");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"vsl_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"skd_voy_no");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"skd_dir_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"bkg_shpr_ownr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"crr_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"yd_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"cbf_smry_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"cbf_ind_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"cbf_bkg_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"rd_st");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"hid");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"slan_cd");
					InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, 	true, 	"hseq");
		
					ColHidden("hseq") = true;
		
					HighLightAfterSort = 1;// 소트 이후 기존에 선택하고 있던 데이터를 찾아감.
		
					ImageList(0) = "img/alps/button/btns_multisearch.gif";
					ImageList(1) = "img/alps/button/btng_minus.gif";
		
					HeadRowHeight   = 20;
					SelectHighLight = true;
				}
				break;
	
		}
	}

	/**
	 * t1sheet1 조회후 처리
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		with (sheetObj) {
			if (RowCount > 0) {
				//Grand Total이 0인 컬럼은 숨김
				var grandRow = FindText("fm", "Grand Total");				
				for(var colCt=SaveNameCol("opr1_qty_2"); grandRow!=-1 && colCt<SaveNameCol("tot_qty_2"); colCt++) {
					//if(CellValue(grandRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//소계행 색상 변경
				var subRow = FindText("fm", "Sub Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					RowBackColor(checkRow)   = RgbColor(247, 225, 236);
					
					subRow = FindText("fm", "Sub Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}				
				
				//2011.11.17 이준범
				//조회시 sub total 숨김
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
						RowHidden(checkRow) = true;
					}
				}
				
				//Grand행 색상 변경
				RowBackColor(grandRow)   = RgbColor(247, 225, 236);
				RowBackColor(++grandRow) = RgbColor(247, 225, 236);	
				
				//MLB, WG 컬럼 숨기기
				ColHidden("mlb") = true;
				ColHidden("wg")  = true;
				
				//POD 펼치기 방향표시 설정
				CellValue2(1,1) = CellValue(1,1).replaceStr("<", ">");
				CellValue2(1,3) = CellValue(1,3).replaceStr("<", ">");
				CellValue2(1,4) = CellValue(1,4).replaceStr("<", ">");
		
				//기본 접힌 형태 구성
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
					if (CellValue(checkRow, "fm") == "Full Total" || CellValue(checkRow, "fm") == "Empty Total" || 
						CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight"  || 
						(CellValue(checkRow, "pod") == "Grand Total" && CellValue(checkRow, "fm") == "Full"  && CellValue(checkRow, "wg") == "Total") || 
						(CellValue(checkRow, "pod") == "Grand Total" && CellValue(checkRow, "fm") == "Empty" && CellValue(checkRow, "wg") == "Total") || 
						CellValue(checkRow, "fm") == "Grand Total"  || CellValue(checkRow, "fm") == "Grand Weight") {
					} else {
						RowHidden(checkRow) = true;
					}	
				}
				
				//엑셀 다운 버튼 활성화
				ComBtnEnable("btn_DownExcel1");
			} else {
				ComBtnDisable("btn_DownExcel1");
			}
			
			Redraw = true; 
		}
	}

	/**
	 * t2sheet1 조회후 처리
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount > 0) {
				//G.Total이 0인 컬럼은 숨김
				var gRow = FindText("pod", "G.Total");				
				for(var colCt=SaveNameCol("dg_20_opr1"); gRow!=-1 && colCt<=SaveNameCol("bb_40_opr1"); colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//접은 상태 만들기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = true;	
				}
				
				//MLB 컬럼 숨기기
				ColHidden("mlb") = true;
				
				//POD 펼치기 방향표시 설정
				CellValue2(2, 1)  = CellValue(2, 1).replaceStr("<", ">");
				
				//G.Total행 색상 변경
				RowBackColor(gRow) = RgbColor(247, 225, 236);
				
				//엑셀 다운 버튼 활성화
				ComBtnEnable("btn_DownExcel2");
			} else {
				ComBtnDisable("btn_DownExcel2");
			}
		}
	}

	/**
	 * t2sheet2 조회후 처리
	 */
	function t2sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount > 0) {
				//G.Total이 0인 컬럼은 숨김
				var gRow = FindText("pod", "G.Total");				
				for(var colCt=SaveNameCol("st1_20_opr1"); gRow!=-1 && colCt<=LastCol; colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//접은 상태 만들기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = true;	
				}
				
				//MLB 컬럼 숨기기
				ColHidden("mlb") = true;
				
				//POD 펼치기 방향표시 설정
				CellValue2(HeaderRows-1, 1)  = CellValue(HeaderRows-1, 1).replaceStr("<", ">");
				
				//G.Total행 색상 변경
				RowBackColor(gRow) = RgbColor(247, 225, 236);
				
				//엑셀 다운 버튼 활성화
				ComBtnEnable("btn_DownExcel3");				
			} else {
				ComBtnDisable("btn_DownExcel3");
			}
		}
	}
	 
 /**
	 * t2sheet3 조회후 처리
	 */
	function t2sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount > 0) {
				//엑셀 다운 버튼 활성화
				ComBtnEnable("btn_DownExcel4");
			} else {
				ComBtnDisable("btn_DownExcel4");
			}
		}
	}

	// 업무 자바스크립트 OnClick 이벤트 처리
	function obj_click() {
		var formObj   = document.form;
		var t1sheetObj1  = sheetObjects[0];
		var t2sheetObj1  = sheetObjects[1];
		var t2sheetObj2  = sheetObjects[2];
		
		switch (event.srcElement.name) {
			case "dcgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked = false;
				}
				break;
			case "rc_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked = false;
				}
				break;
			case "awk_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked = false;
				}
				break;
			case "bb_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked = false;
				}
				break;
			case "stwg_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked = false;
				}
				break;
			case "all_flg":
				if (formObj.all_flg.checked) {
					formObj.dcgo_flg.checked     = false;
					formObj.rc_flg.checked       = false;
					formObj.awk_cgo_flg.checked  = false;
					formObj.bb_cgo_flg.checked   = false;
					formObj.stwg_cgo_flg.checked = false;
				}
				break;
				
			case "t1sheet1_sum_flg":
				//2011.11.17 이준범
				//Sub Sum 체크 박스 , 소계행 콘트롤	
				with (t1sheetObj1) {
					for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
						
						if (!formObj.t1sheet1_sum_flg.checked){
							if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
								RowHidden(checkRow) = true;
							}
						} else {
							if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
								RowHidden(checkRow) = false;
							}
						}
					}
				}
				break;
			case "t2sheet1_sum_flg":
				with (t2sheetObj1) {
					if ( !ColHidden("mlb") ) {
						for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
							if (!formObj.t2sheet1_sum_flg.checked){
								if (CellValue(checkRow, "mlb") == "S.Total") {								
									RowHidden(checkRow) = true;
								}
							} else {
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = false;
								}
							}
						}
					}
				}
				break;
			case "t2sheet2_sum_flg":
				with (t2sheetObj2) {
					if ( !ColHidden("mlb") ) {
						for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
							if (!formObj.t2sheet2_sum_flg.checked){
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = true;
								}
							} else {
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = false;
								}
							}
						}
					}
				}
				break;				
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		var comboObj = comboObjects[1];
	
		switch (sAction) {
	
			case IBSEARCH: //Volume Summary
				if (!validateForm(sheetObj, formObj, sAction)) return;						
				
				//1. OPR 파라미터 구성
				var paramQty = "";	
				var qtyVal   = "";
				for(var qtyCt=1; qtyCt<=5; qtyCt++) {
					if(qtyCt < comboObj.GetCount()) {
						if(comboObj.Text == 'ALL') qtyVal = comboObj.GetText(qtyCt, 0);
						else if(qtyCt == 1) qtyVal = comboObj.Text;
						else qtyVal = "";
					} else {
						qtyVal = "";
					}
					
					paramQty = paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
				}
				
				//2. Volume Summary 조회
				sheetObj.Redraw = false; 
				formObj.f_cmd.value = SEARCH;						
				sheetObj.DoSearch("VOP_OPF_0021GS.do", FormQueryString(formObj) + paramQty);
				
				break;
	
			case IBSEARCH02: //Special Cargo Summary
				switch (sheetObj.id) {
					case "t2sheet1":
						if (!validateForm(sheetObj, formObj, sAction)) return;
						
						//1. OPR 파라미터 구성
						var paramQty = "";	
						var qtyVal   = "";
						for(var qtyCt=1; qtyCt<=5; qtyCt++) {
							if(qtyCt < comboObj.GetCount()) {
								if(comboObj.Text == 'ALL') qtyVal = comboObj.GetText(qtyCt, 0);
								else if(qtyCt == 1) qtyVal = comboObj.Text;
								else qtyVal = "";
							} else {
								qtyVal = "";
							}
							
							paramQty = paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
						}
			
						formObj.f_cmd.value = SEARCH02;						
						sheetObj.DoSearch("VOP_OPF_0021GS.do", FormQueryString(formObj) + paramQty);		
						
						break;
		
					case "t2sheet3":
						if (!validateForm(sheetObj, formObj, sAction)) return;
						
						//1. OPR 파라미터 구성
						var paramQty = "";	
						var qtyVal   = "";
						for(var qtyCt=1; qtyCt<=5; qtyCt++) {
							if(qtyCt < comboObj.GetCount()) {
								if(comboObj.Text == 'ALL') qtyVal = comboObj.GetText(qtyCt, 0);
								else if(qtyCt == 1) qtyVal = comboObj.Text;
								else qtyVal = "";
							} else {
								qtyVal = "";
							}
							
							paramQty = paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
						}
			
						formObj.f_cmd.value = SEARCH11;
						
						//파라미터 명시적인 생성
			 			var formParams = "";
			     		formParams += "f_cmd="        +ComGetObjValue(formObj.f_cmd);
			     		formParams += "&pagerows="    +ComGetObjValue(formObj.pagerows);
			     		formParams += "&all_flg="     +ComGetObjValue(formObj.all_flg);
			     		formParams += "&dcgo_flg="    +ComGetObjValue(formObj.dcgo_flg);
			     		formParams += "&rc_flg="      +ComGetObjValue(formObj.rc_flg);
			     		formParams += "&awk_cgo_flg=" +ComGetObjValue(formObj.awk_cgo_flg);
			     		formParams += "&bb_cgo_flg="  +ComGetObjValue(formObj.bb_cgo_flg);
			     		formParams += "&stwg_cgo_flg="+ComGetObjValue(formObj.stwg_cgo_flg);
			     		formParams += "&mlb_cd="      +ComGetObjValue(formObj.mlb_cd);
			     		formParams += "&pod_cd="      +ComGetObjValue(formObj.pod_cd);
			     		formParams += "&vsl_cd="      +ComGetObjValue(formObj.vsl_cd);
			     		formParams += "&skd_voy_no="  +ComGetObjValue(formObj.skd_voy_no);
			     		formParams += "&skd_dir_cd="  +ComGetObjValue(formObj.skd_dir_cd); 
			     		formParams += "&yd_cd="       +ComGetObjValue(formObj.yd_cd);
									
						sheetObj.DoSearch("VOP_OPF_0019GS.do", formParams + paramQty);
						
						break;
	
				}
				break;
	
			case IBSEARCH03:
				if (!validateForm(sheetObj, formObj, sAction)) return;
	
				//1. OPR 파라미터 구성
				var paramQty = "";	
				var qtyVal   = "";
				for(var qtyCt=1; qtyCt<=5; qtyCt++) {
					if(qtyCt < comboObj.GetCount()) {
						if(comboObj.Text == 'ALL') qtyVal = comboObj.GetText(qtyCt, 0);
						else if(qtyCt == 1) qtyVal = comboObj.Text;
						else qtyVal = "";
					} else {
						qtyVal = "";
					}
					
					paramQty = paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
				}
	
				formObj.f_cmd.value = SEARCH13;
				
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj) + paramQty);
	
				break;	
		}
	}
	
	/**
	 * Sheet1 MLB 컬럼 확장
	 * @param sheetObj
	 * @param what
	 */
	function spreadMlbCols(sheetObj, gbn) {
		with(sheetObj) {
			//@@20140729 Weight Group 
			var podVal = "", mlbVal = "", fmVal = "", wgVal = "";
			var colVal1 = CellValue(1, 1);	//pod
			var colVal2 = CellValue(1, 2);	//pod_yd_cd
			var colVal3 = CellValue(1, 3);	//mlb
			var colVal4 = CellValue(1, 4);	//fm
			var colVal5 = CellValue(1, 5);	//wg
			var foldYn = false;
			
			Redraw = false;
			
			if(colVal1.indexOf(">") != -1) {	//접힌 상태일때					
				CellValue2(1,1)  = colVal1.replaceStr(">", "<");
			} else {
				foldYn = true;
				CellValue2(1,1)  = colVal1.replaceStr("<", ">");
			}
			ColHidden("mlb") = foldYn;
			
			//alert('colVal1:'+colVal1.indexOf(">")+', colVal4:'+colVal4.indexOf("<"));
			//Weight Group 컬럼이 펼쳐져 있는 경우
            if(colVal4.indexOf("<") != -1) {
            	//alert("1>>>"+foldYn);
            	for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) {		
					podVal = CellValue(rowCt, "pod");
					mlbVal = CellValue(rowCt, "mlb");
					fmVal  = CellValue(rowCt, "fm");
	                wgVal  = CellValue(rowCt, "wg"); 
	                
	                //아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
	            	if (                           mlbVal == "Sub WG"                                       ||	//Sub WG 모두 숨긴다.
					   (podVal == "Grand Total" &&                    fmVal == "Empty" && wgVal == "Total")) 	//Grand Total 부분의 Empty 항목의 Total항목을  숨긴다.
					{
						RowHidden(rowCt) = !foldYn;
					}
	            	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	//Sub WG 가 아닌 항목중에서 Full이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight") ||  //Sub WG 가 아닌 항목중에서 Empty이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(                      fmVal == "Total"      || fmVal == "Total Weight"               ) ||  //Total, Total Weight 항목을 모두 보이기
						(                      fmVal == "Full Total" || fmVal == "Empty Total"                ) ||  //Full Total, Empty Total 항목을 모두 보이기
						(podVal == "Grand Total" &&                     fmVal == "Empty" && wgVal == ""))	        //Grand Total의 Empty항목의 "" 을 보이기
					{
						RowHidden(rowCt) = foldYn;
					}
	            	
	            	if ((podVal == "Grand Total" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight")) {	//Grand Total의 Full항목의 Total, Total Weight항목을 제외한 모든 항목 보이기
	            		RowHidden(rowCt) = false;
	            	} 
            	}
            //Weight Group 컬럼이 닫혀있는 경우
            } else {
            	//alert("2>>>"+foldYn);
				//1. MLB 컬럼을 펼침/닫기한다.
				for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) {		
					podVal = CellValue(rowCt, "pod");
					mlbVal = CellValue(rowCt, "mlb");
					fmVal  = CellValue(rowCt, "fm");
	                wgVal  = CellValue(rowCt, "wg");   
	                //@@20140729 mlb값이 없기 때문에 FM이 Total Weight 더라도 해당로우는 보이지 않음 > 조회데이타 확인
                	if ((podVal != "Grand Total" &&                       fmVal == "Full"  && wgVal == "Total") ||
						(podVal != "Grand Total" &&                       fmVal == "Empty" && wgVal == "Total") ||
						(                           mlbVal != ""       && fmVal == "Total"                     ) ||
						(                           mlbVal != ""       && fmVal == "Total Weight"              ))
					{
						RowHidden(rowCt) = foldYn;
					}
                	
                	if (foldYn && (fmVal == "Total" || fmVal == "Total Weight")) {	//Total, Total Weight 항목 모두 숨기기(접을 경우에만)
	            		RowHidden(rowCt) = true;
	            	}
				}	
            }
		
			Redraw = true; 
		}
	}
	 
	/**
	 * Sheet1 Weight Group 컬럼 확장
	 * @param sheetObj
	 * @param what
	 */
	function spreadWGCols(sheetObj) {
		with(sheetObj) {
			var podVal = "", mlbVal = "", fmVal = "", wgVal = "";
			var colVal1 = CellValue(1, 1);
			var colVal2 = CellValue(1, 2);
			var colVal3 = CellValue(1, 3);
			var colVal4 = CellValue(1, 4);
			var colVal5 = CellValue(1, 5);
			var foldYn = false;
			
			Redraw = false;
			
			if(colVal4.indexOf(">") != -1) {
				//CellValue2(1,3)  = colVal3.replaceStr(">", "<");
				CellValue2(1,4)  = colVal4.replaceStr(">", "<");
			} else {
				foldYn = true;
				//CellValue2(1,3)  = colVal3.replaceStr("<", ">");
				CellValue2(1,4)  = colVal4.replaceStr("<", ">");
			}
			ColHidden("wg") = foldYn;
			//alert("2>>>"+foldYn+", colVal1:"+colVal1);
			//alert(colVal1.indexOf(">"));
			for (var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) { 
				podVal = CellValue(rowCt, "pod");
				mlbVal = CellValue(rowCt, "mlb");
				fmVal  = CellValue(rowCt, "fm");
                wgVal  = CellValue(rowCt, "wg");                    
                
                if(colVal1.indexOf(">") != -1) {	//MLB가 접힌 상태일때 -> @@POD가 접힌상태임!!
                	//아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
                	if ((podVal == "Grand Total" && fmVal == "Full" && wgVal == "Total") ||		//Grand Total 부분의 Full 항목의 Total 항목만 숨긴다.
                		(                           fmVal == "Full Total"              ) ||		//모든 Full Total 항목을 숨긴다.
                		(                           fmVal == "Empty Total"             )) 		//모든 Empty Total 항목을 숨긴다.
                	{				 
						RowHidden(rowCt) = !foldYn;
					}
					if (                           mlbVal == "Sub WG"                                                                 ||	//Sub WG 모두 보이기
					   (podVal == "Grand Total" &&                    fmVal == "Full" && wgVal != "Total" && wgVal != "Total Weight")) 		//Grand Total 부분의 Full 항목의 Total, Total Weight 이외 항목들을 보이기
					{
						RowHidden(rowCt) = foldYn;
					}
                } else {							//MLB가 펼쳐진 상태 -> @@POD가 펼친상태임!!
                	//아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
                	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal == "Total")  ||	//Sub WG 가 아닌 항목중에서 Full/Total만 숨긴다.
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal == "Total")     	//Sub WG 가 아닌 항목중에서 Empty/Total만 숨긴다.
                	   )
					{
						RowHidden(rowCt) = !foldYn;
					}
					if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	//Sub WG 가 아닌 항목중에서 Full이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight") ||	//Sub WG 가 아닌 항목중에서 Empty이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(                      fmVal == "Total"      || fmVal == "Total Weight"               )   //Total, Total Weight 항목을 모두 보이기
//						(                      fmVal == "Full Total" || fmVal == "Empty Total"                ) ||  //Full Total, Empty Total 항목을 모두 보이기
//						(podVal == "Grand Total" &&                     fmVal == "Empty" && wgVal == "")
					   )
					{
						RowHidden(rowCt) = foldYn;
					}
                }
			}	
		
			sheetObj.Redraw = true; 
		}
	}

	/**
	 * t1sheet1_OnMouseDown
	 */
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			if((MouseCol == SaveNameCol("pod") ) && MouseRow == (HeaderRows-1)) {
				spreadMlbCols(sheetObj);
			} else if((MouseCol == SaveNameCol("fm") || MouseCol == SaveNameCol("wg")) && MouseRow == (HeaderRows-1)) {
				spreadWGCols(sheetObj); 
			}
		}
	}

	/**
	 * t2sheet1_OnMouseDown
	 */
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		
		 var formObj    = document.form;
		 
		 with(sheetObj) {
			if(MouseCol == SaveNameCol("pod") && MouseRow == (HeaderRows-1)) {
				Redraw = false;
				
				var foldYn = false;		
				var colVal = CellValue(2, 1);
				if(colVal.indexOf(">") != -1) {
					CellValue2(2, 1) = colVal.replaceStr(">", "<");				
				} else {
					foldYn = true;
					CellValue2(2, 1)  = colVal.replaceStr("<", ">");				
				}
				ColHidden("mlb") = foldYn;
				
				//MLB별 접기,펼치기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					//2011.11.17 이준범
					//Sub Sum 체크 박스 , 소계행 콘트롤	
					if (ColHidden("mlb")){
						if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
					} else {
						if (!formObj.t2sheet1_sum_flg.checked){
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = true;
						} else {
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
						}
					}

					if (CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = foldYn;

				}
				
				var subRow = FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					if(foldYn) RowBackColor(checkRow++) = RgbColor(255,255,255);
					else RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					
					subRow = FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}
				
				Redraw = true;
			}
		}
	}

	/**
	 * t2sheet3_OnMouseDown
	 */
	function t2sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		
		 var formObj    = document.form;
		 
		 with (sheetObj) {
			if(MouseCol == SaveNameCol("pod") && MouseRow == (HeaderRows-1)) {
				Redraw = false;
				
				var foldYn = false;		
				var colVal = CellValue(HeaderRows-1, 1);
				if(colVal.indexOf(">") != -1) {
					CellValue2(HeaderRows-1, 1) = colVal.replaceStr(">", "<");				
				} else {
					foldYn = true;
					CellValue2(HeaderRows-1, 1)  = colVal.replaceStr("<", ">");				
				}
				ColHidden("mlb") = foldYn;
				
				//MLB별 접기,펼치기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					//2011.11.17 이준범
					//Sub Sum 체크 박스 , 소계행 콘트롤	
					if (ColHidden("mlb")){
						if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
					} else {
						if (!formObj.t2sheet2_sum_flg.checked){
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = true;
						} else {
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
						}
					}					
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = foldYn;	
				}
				
				var subRow = FindText("mlb", "S.Total");
				
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					if(foldYn) RowBackColor(checkRow++) = RgbColor(255,255,255);
					else RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					
					subRow = FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}
				
				Redraw = true;
			}
		}
	}
	 
	/**
     * Sheet1 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
    	with (sheetObj) {
	     	if (MouseRow == (HeaderRows-1) && (MouseCol == SaveNameCol("pod") || MouseCol == SaveNameCol("fm") || MouseCol == SaveNameCol("wg"))) {
	     		MousePointer = "Hand";
	     	} else {
	     		MousePointer = "Default";
	     	}
    	}
    }
     
    /**
     * Sheet2 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
      	with (sheetObj) {
  	     	if (MouseRow == (HeaderRows-1) && MouseCol == SaveNameCol("pod")) {
  	     		MousePointer = "Hand";
  	     	} else {
  	     		MousePointer = "Default";
  	     	}
      	}
    }
     
    /**
     * Sheet3 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t2sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
      	with (sheetObj) {
  	     	if (MouseRow == (HeaderRows-1) && MouseCol == SaveNameCol("pod")) {
  	     		MousePointer = "Hand";
  	     	} else {
  	     		MousePointer = "Default";
  	     	}
  	     	
  	     	if (MouseRow == 1 && MouseCol > SaveNameCol("mlb")) {
  	     		for(var i=0; i<stwgNmList.length; i++) {
  	     			if(CellText(MouseRow, MouseCol) == stwgNmList[i].split("+")[0]) {
  	     				MouseToolTipText = stwgNmList[i].split("+")[1];
  	     				
  	     				break;
  	     			}
  	     		}
  	     	}
      	}
    }
     
    /**
     * t2sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet3_OnClick(sheetObj, Row, Col, Val) {
      	with(sheetObj) {
      		if(SaveNameCol("prp_shp_nm") == Col || SaveNameCol("hzd_desc") == Col) {
      			if(Val != '') ComShowMemoPad(sheetObj, Row, Col, true, 250, 100);
      		}
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
	
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {	
			case IBSEARCH:
				//폼 개체 안에 모든 컨트롤의 Validation을 확인
				if (!ComChkValid(formObj, true, false, false))
					return false;

				if (comboObjects[0].Code == "") {					
					ComShowCodeMessage("COM130404", "POL", "POL");					
					formObj.yd_cd.focus();
					
					return false;
				}
		
				break;
		}
	
		return true;
	}

/* 개발자 작업  끝 */