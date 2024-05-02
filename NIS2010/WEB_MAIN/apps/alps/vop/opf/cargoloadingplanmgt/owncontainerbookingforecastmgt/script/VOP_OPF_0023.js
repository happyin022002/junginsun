/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0023.js
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.13
 *@LastModifier : 김도현
 *@LastVersion : 1.0
 * 2015.10.13 김도현
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
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
	 * @class vop_opf_0022 : vop_opf_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_0022() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.validateForm       = validateForm;
	}

	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var formObj   = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {	
				case "btn_RowAdd":
					var row = sheetObjects[0].DataInsert(-1);
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObjects[0],prefix1+"del_chk");
					break;
				case "btn_Save":
					if(!ComShowCodeConfirm('OPF50001', '')) return;
					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					break;
				case "btn_close":
//					window.dialogArguments.preview_pop1();
					window.close();
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {	
		//IBSheet 초기화
		for (i = 0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);	
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//Axon Event Listener 등록
		initControl();
	
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
		
		var compareCnt = false;
 		if(sheetObjects[0].RowCount > 0){
 			for(var i=sheetObjects[0].HeaderRows ; i <= sheetObjects[0].LastRow ; i++){
				if(sheetObjects[0].CellValue(i,'sheet1_imdg_un_no') == formObj.param_imdg_un_no.value
					&& 	sheetObjects[0].CellText(i,'sheet1_imdg_clss_cd') == formObj.param_imdg_clss_cd.value
					&& 	sheetObjects[0].CellText(i,'sheet1_imdg_subs_rsk_lbl_cd') == formObj.param_imdg_subs_rsk_lbl_cd.value
					){
					compareCnt = true;
				}
 			}
 		}
 	 		
		if(!compareCnt){
			var row = sheetObjects[0].DataInsert(-1);
			var formObj   = document.form;
			sheetObjects[0].CellValue2(row,'sheet1_imdg_un_no') = formObj.param_imdg_un_no.value;
			sheetObjects[0].CellValue2(row,'sheet1_imdg_clss_cd') = formObj.param_imdg_clss_cd.value;
			sheetObjects[0].CellValue2(row,'sheet1_imdg_subs_rsk_lbl_cd') = formObj.param_imdg_subs_rsk_lbl_cd.value;
			sheetObjects[0].CellValue2(row,'sheet1_mrn_polut_flg') = formObj.param_mrn_polut_flg.value;
			sheetObjects[0].CellValue2(row,'sheet1_imdg_lmt_qty_flg') = formObj.param_imdg_lmt_qty_flg.value;
		}
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
 
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: // t1sheet1 init - Carrier
			with (sheetObj) {
				//높이 설정
				style.height = 250;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(0, 1, 2, 100);

				var HeadTitle1 = "||UN NO.|Class|SRL1|MP|LQ|1|2|3|4|5|6|7|8|9|10";
//				var HeadTitle2 = "||UN NO.|Class|MP|LQ|1|2|3|4|5|6|7|8|9|10";
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
//				InitHeadRow(1, HeadTitle2, true);

				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix1 + "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix1 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1	, false, false, false, false);
//				InitDataProperty(0, cnt++, dtPopup, 		65, 	daRight, 	true, 	prefix1 + "imdg_un_no"			,false	,""		,dfNone	,0	,true	,true	,5);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "imdg_un_no"			,false	,""		,dfNone	,0	,true	,true	,4);
				InitDataProperty(0, cnt++, dtCombo, 		65, 	daRight, 	true, 	prefix1 + "imdg_clss_cd"		,false	,""		,dfNone	,0	,false	,false	,5);
				InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix1 + "imdg_subs_rsk_lbl_cd",false	,""		,dfNone	,0	,false	,false	,3);
				InitDataProperty(0, cnt++, dtCombo, 		65, 	daRight, 	true, 	prefix1 + "mrn_polut_flg"		,false	,""		,dfNone	,0	,true	,true	,5);
				InitDataProperty(0, cnt++, dtCombo, 		65, 	daRight, 	true, 	prefix1 + "imdg_lmt_qty_flg"	,false	,""		,dfNone	,0	,true	,true	,5);
				
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "cbf_smry_seq"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "cbf_smry_dcgo_seq"	,false	,""		,dfNone	,0	,false	,false);

				HeadRowHeight = 20;
				
				// 대문자 처리
//				InitDataValid(0, prefix1 + "pod_stwg_cd", vtEngUpOther, "1234567890-");	 
//				InitDataValid(0, prefix1 + "bkg_20ft_qty", vtNumericOnly);	 
				
				InitDataCombo(0, prefix1 + "mrn_polut_flg", "N|Y", "N|Y");
				InitDataCombo(0, prefix1 + "imdg_lmt_qty_flg", "N|Y", "N|Y");
				
				ColHidden(prefix1 + "vsl_cd") = true;
				ColHidden(prefix1 + "skd_voy_no") = true;
				ColHidden(prefix1 + "skd_dir_cd") = true;
				ColHidden(prefix1 + "yd_cd") = true;
				ColHidden(prefix1 + "pol_clpt_ind_seq") = true;
				ColHidden(prefix1 + "crr_cd") = true;
				ColHidden(prefix1 + "pod_cd") = true;
				ColHidden(prefix1 + "blck_stwg_cd") = true;
				ColHidden(prefix1 + "cbf_smry_seq") = true;
				ColHidden(prefix1 + "cbf_smry_dcgo_seq") = true;
			}
			break;
		}
	}
	
	/**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {	
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
					
					formObj.f_cmd.value = SEARCH08;
					
					//파라미터 명시적인 생성
					var formParams = "";
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&yd_cd="            	+ComGetObjValue(formObj.yd_cd);
					formParams += "&pol_clpt_ind_seq="  +ComGetObjValue(formObj.pol_clpt_ind_seq);
					formParams += "&pod_cd="            +ComGetObjValue(formObj.pod_cd);
					formParams += "&blck_stwg_cd="      +ComGetObjValue(formObj.blck_stwg_cd);
					formParams += "&cbf_spcl_smry_seq=" +ComGetObjValue(formObj.cbf_spcl_smry_seq);

					var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
					var arrXml = sXml.split("|$$|");
					
					var arrCt = arrXml.length;
					if (arrXml != null && arrCt > 0) {
						sheetObjects[0].LoadSearchXml(arrXml[0]);
					}
				}
	
				break;
					
			case IBSAVE: // Save
//				if (!validateForm(sheetObj, formObj, sAction)) return false;
				
				formObj.f_cmd.value = MULTI;
				
				//파라미터 명시적인 생성
				var formParams = "";
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				formParams += "&condition_gb="  	+ComGetObjValue(formObj.condition_gb);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
				formParams += "&yd_cd="            	+ComGetObjValue(formObj.yd_cd);
				formParams += "&pol_clpt_ind_seq="  +ComGetObjValue(formObj.pol_clpt_ind_seq);
				formParams += "&pod_cd="            +ComGetObjValue(formObj.pod_cd);
				formParams += "&blck_stwg_cd="      +ComGetObjValue(formObj.blck_stwg_cd);
				formParams += "&cbf_spcl_smry_seq=" +ComGetObjValue(formObj.cbf_spcl_smry_seq);

				sheetObj.DoSave("VOP_OPF_0022GS.do", formParams, -1, false);
				
				break;
		}
	}
	
	/*******************************************************************************
	 * Validation 시작 *
	 ******************************************************************************/
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
	
		case IBSEARCH:			
			break;
		case IBSAVE:
			break;
		}
	
		return true;
	}

  /**
   * sheet1에서 Popup 이벤트를 발생시킴.
   */
  function t1sheet1_OnPopupClick (sheetObj , row , col ){
	  var formObj = document.form;
	  var colName = sheetObjects[0].ColSaveName(col);
	  switch(colName){
	  	case('sheet1_imdg_un_no'):
		   	ComOpenPopup("ESM_BKG_0204.do?imdg_un_no="+sheetObjects[0].CellValue(row, "sheet1_imdg_un_no")+"&bkg_no=", 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
	  }
  }
  
  /**
   * UN No. 리턴값 설정
   */
  function getCOM_UNNO_POPUP(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var sRow = sheetObjects[0].SelectRow;
		sheetObjects[0].CellValue2(sRow,'sheet1_imdg_un_no') = colArray[2];
		sheetObjects[0].CellValue2(sRow,'sheet1_imdg_clss_cd') = colArray[4];
		sheetObjects[0].CellValue2(sRow,'sheet1_imdg_subs_rsk_lbl_cd') = colArray[9];
  }
		
	/**
	 * UnNo Class Combo Sheet 셋팅. <br>
	 **/    
  function setSheet_UnNo_Class_combo(sheetObj, row) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH10;
		formObj.imdg_subs_rsk_lbl_cd.value = "";
		
		var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");
		var arrCombo1 = ComXml2ComboString(arrXml[0], "imdg_clss_cd", "imdg_clss_cd");
		var selectClassCd;
		
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0){ 
					itemNm = itemNm + arrVal[j];
					selectClassCd = arrVal[j];
				}else{
					itemNm = itemNm + "|" + arrVal[j];
				}
			}
			
			sheetObj.InitDataCombo(0, prefix1+"imdg_clss_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
			// Fist Code Setting.
			sheetObj.CellValue2(row,'sheet1_imdg_clss_cd') = selectClassCd;
		}
  }
  
	/**
	 * UnNo Class Combo Sheet 셋팅. <br>
	 **/    
  function setSheet_UnNo_Imdg_subs_rsk_lbl_cd_combo(sheetObj, row) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH10;
		formObj.imdg_subs_rsk_lbl_cd.value = "Y";
		
		var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");
		var arrCombo1 = ComXml2ComboString(arrXml[0], "imdg_subs_rsk_lbl_cd", "imdg_subs_rsk_lbl_cd");
		var selectImdg_subs_rsk_lbl_cd;
		
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0){ 
					itemNm = itemNm + arrVal[j];
					selectImdg_subs_rsk_lbl_cd = arrVal[j];
				}else{
					itemNm = itemNm + "|" + arrVal[j];
				}
				
			}
			sheetObj.InitDataCombo(0, prefix1+"imdg_subs_rsk_lbl_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
			// Fist Code Setting.
			sheetObj.CellValue2(row,'sheet1_imdg_subs_rsk_lbl_cd') = selectImdg_subs_rsk_lbl_cd;
		}
  }
  
  /**
   * Sheet 변경시 셋팅. <br>
   **/    
	function t1sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	 	switch(colName) {
			case "sheet1_imdg_un_no":
	 			formObj.imdg_un_no.value 		 = sheetObj.CellValue(row, "sheet1_imdg_un_no");
	             if (sheetObj.CellValue(row, col).length == "4") {
	            	 sheetObj.CellEditable(row, "sheet1_imdg_clss_cd") = true; 
	            	 sheetObj.CellEditable(row, "sheet1_imdg_subs_rsk_lbl_cd") = true; 
	            	 setSheet_UnNo_Class_combo(sheetObj, row);
	            	 setSheet_UnNo_Imdg_subs_rsk_lbl_cd_combo(sheetObj, row);
	             }
	 		break;
	 		
	 	}
	}  

	
/* 개발자 작업 끝 */