/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0341.js
*@FileTitle : Transportation Invoice Charge -Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-15
*@LastModifier : Sung-Gil Hyun
*@LastVersion : 1.0
* 2015-5-15 Sung-Gil Hyun
* 1.0 최초 생성
*  
=========================================================*/

	function ESD_EAS_0341() {
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
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var formObj = "";

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject = sheetObjects[0];
		
		 /** *************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
				break;
				
			case "btng_eacif":
				var check = sheetObject.CheckedRows("chk");
				if(check > 0){
					eac_if(sheetObject, sheetObject.FindCheckedRow("chk"))
				}else{
					ComShowCodeMessage('EAS00009'); //At least one row needs to be selected
				}
				break;
			case "btng_close":
				self.close();
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	 
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
	 * 기능을 추가한다
	 */

	function loadPage() {
		formObj = document.form;													
		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet(sheetObjects[i]);
			ComConfigSheetEas(sheetObjects[i])
			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);
		}

	    // 화면 Combo 설정
	    getEasIbComboList(formObj.s_trsp_so_tp_cd , s_trsp_so_tp_cdCode , s_trsp_so_tp_cdText , 'ALL'); // Service Order Type 
	    getEasIbComboList(formObj.s_expn_aud_sts_cd , s_expn_aud_sts_cdCode , s_expn_aud_sts_cdText , 'ALL'); // Audist Status 
	    getEasIbComboList(formObj.s_trsp_cost_dtl_mod_cd , s_trsp_cost_dtl_mod_cdCode , s_trsp_cost_dtl_mod_cdText , 'ALL'); // Cost Mode
	    getEasIbComboList(formObj.s_trsp_crr_mod_cd , s_trsp_crr_mod_cdCode , s_trsp_crr_mod_cdText , 'ALL'); // Trans Mode 
	    getEasIbComboList(formObj.s_aud_itm_cd , 'DA|DF|NT|OT|EX' , 'Difference All|Diff Amount|No Tariff|Non-Opt. Route|Exceed Average' , 'ALL');  // Difference 
	    
	    // IBMultiCombo 설정
	    for(var k = 0; k < comboObjects.length; k++){
	    	initCombo(comboObjects[k], k + 1);
	    	comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
	    }
	    formObj.s_trsp_so_tp_cd.Enable    = false;  // S/O Type 비활성화
	    formObj.s_expn_aud_sts_cd.Enable    = false;  // Audit Result 비활성화
	    
		//initControl();
	    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
  	function initControl() {
// axon_event.addListenerFormat('keypress', 'obj_keypress', form);
// axon_event.addListenerForm ('keyup', 'obj_keyup', form);
  	}

	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
	 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {
	 	var cnt = 0;
	 	switch(sheetNo) {
	    	case 1:      // sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(20);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    // 전체Edit 허용 여부 [선택, Default false]
				    Editable = true;
				    
				    //Ellipsis = true; 
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 14, 10);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle = "|SEL|SEQ.|RHQ|W/O\nOffice|Invoice\nOffice|BKG No.|CNTR No.|CNTR\nTP/SZ|Trans\nMode|W/O No.|S/O No.|Term|Cur.|W/O Amount|Inv Amount" +
							"|Reflect\nEx. Rate|Diff Amount|Diff\nRatio(%)||Tariff|Opt\nRoute|Exceed\nAverage|Nego Amt|Nego Reason|W/O Additional|W/O Additional|W/O Additional\nOther Reason|INV Additional|INV Additional|INV Additional\nOther Reason|EAC I/F" +
							"|trsp_so_tp_cd|inv_vndr_seq|inv_no|cgo_tp_cd|trsp_cost_dtl_mod_cd|trsp_bnd_cd|inv_cfm_dt|aud_sts_flg|wo_iss_dt|wo_iss_pre_mon|fm_nod_cd|to_nod_cd|via_nod_cd|dor_nod_cd|trsp_so_ofc_cty_cd|trsp_so_seq|locl_cre_dt";
					
					var HeadCount = ComCountHeadTitle(HeadTitle);

					InitColumnInfo(HeadCount, 9, 0, true);
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//HeadRowHeight = 12;
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox, 	50, 	daCenter, 	true, 	"chk", 					false, 	  "", 	   dfNone,  		0, 			true, 		  true);
					InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq",					false, 	  "", 	   dfNone,  		0, 			false, 		  false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "rhq_ofc_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "wo_ofc_cd",            false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "inv_ofc_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "bkg_no",        		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "eq_no",         		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "eq_tpsz_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "trsp_crr_mod_cd",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "wo_no",          		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "so_no",                false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "bkg_rcvde_term_cd",    false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,   "curr_cd",              false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
				    InitDataProperty(0, cnt++ , dtAutoSum,      90,  	daRight,    true,   "wo_amt",               false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
				    InitDataProperty(0, cnt++ , dtAutoSum,      90,  	daRight,    true,   "inv_amt",              false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "curr_cng_flg",         false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtAutoSum,      100,  	daRight,    true,   "inv_diff_amt",         false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daRight,    true,   "inv_diff_pct",         false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,   "inv_diff_amt_flg",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "no_agmt_flg",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "no_optm_rout_flg",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtAutoSum, 		100,  	daRight,    true,   "exceed_avg_diff_amt",  false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "nego_amt",       		false,    "",      dfNullFloat,     0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "nego_rmk",       		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "etc_scg_nm",       	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "etc_scg_amt",       	false,    "",      dfNullFloat,     0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "otr_rmk",       		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "inv_etc_scg_nm",       false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "inv_etc_scg_amt",      false,    "",      dfNullFloat,     0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "inv_otr_rmk",       	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "eac_if_flg",       	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daLeft,     true,   "trsp_so_tp_cd",        false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "inv_vndr_seq",         false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "inv_no",           	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "cgo_tp_cd",            false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "trsp_cost_dtl_mod_cd", false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "trsp_bnd_cd",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "inv_cfm_dt",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "aud_sts_flg",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "wo_iss_dt",            false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "wo_iss_pre_mon",       false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "fm_nod_cd",            false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "to_nod_cd",            false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "via_nod_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       50,  	daCenter,   true,   "dor_nod_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       90,  	daCenter,   true,   "trsp_so_ofc_cty_cd",   false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       90,  	daCenter,   true,   "trsp_so_seq",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       90,  	daCenter,   true,   "locl_cre_dt",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
	    	}
				break;
	    	}
		}	
	
	 /* Sheet관련 프로세스 처리 */
		function doActionIBSheet(sheetObj,formObj,sAction) {
			sheetObj.ShowDebugMsg = false;
			switch(sAction) {
			    case IBSEARCH:
			    		sheetObj.RemoveAll();
						formObj.f_cmd.value = SEARCHLIST02;
						sheetObj.DoSearch4Post("ESD_EAS_0340GS.do", FormQueryString(formObj));
					break;	
				}

		}
	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[0];
	    	switch(comboObj.id) {
		    case "s_rhq_ofc_cd":  
		    	break;
		 
	    	}
	    }
	    	
		// 공통테이블에 등록된 코드값을 조회 한다.
		function searchCommonCombo(codeKey,comboObj){
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				formObj.code_key.value = codeKey
				sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}    

		function sheet1_OnChange(sheetObj, row, col, value){

		}
		
		/**
		 * Grid click Event
		 */
		function sheet1_OnClick(sheetObj, Row,Col,Value){
			var colname = sheetObj.ColSaveName(Col);
			switch (colname) {
				case "nego_rmk":
				case "otr_rmk":
				case "inv_otr_rmk":
					ComShowMemoPad(sheetObj, Row, Col, true, 400);
				break;
			} 
		}

		/**
		 * 화면 로딩시 콤보조회
		 */
		function sheet1_OnLoadFinish(sheetObj){
		
		}
		
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){
			doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
		}	
		
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
		
			formObj = document.form;
			var result = true ;
			
			switch(sAction) {
				case IBSEARCH:

				break;
			}
			
			return result;
		}
		
		/**
		 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인
		 * 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
		 */ 
		function initCombo(comboObj, comboNo) {
			switch(comboObj.id){
				case "s_trsp_so_tp_cd":
					formObj.s_trsp_so_tp_cd.DeleteItem("H");
					formObj.s_trsp_so_tp_cd.DeleteItem("S");
					formObj.s_trsp_so_tp_cd.DeleteItem("O");
					
					formObj.s_trsp_so_tp_cd.Code = formObj.trsp_so_tp_cd.value
					break;
				case "s_trsp_cost_dtl_mod_cd" :
					formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HD");
					formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HF");
					formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HN");
					formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("GN");
					formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("GF");
					
					formObj.s_trsp_cost_dtl_mod_cd.Code = formObj.trsp_cost_dtl_mod_cd.value;
					break;
				case "s_trsp_crr_mod_cd" :
					formObj.s_trsp_crr_mod_cd.Code = formObj.trsp_crr_mod_cd.value;
					break;
				case "s_expn_aud_sts_cd" :
					formObj.s_expn_aud_sts_cd.Code = formObj.expn_aud_sts_cd.value;
					break;
				case "s_aud_itm_cd" :
					formObj.s_aud_itm_cd.Code = formObj.aud_itm_cd.value;
					break;
			}
		}

		/**
	     * ibsheet 컬럼에 밑줄 넣기 Event
	     * @param sheetObj
	     * @param ErrMsg
	     * @return
	     */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			sheetObj.ColFontUnderline("so_no")				 = true;
			sheetObj.ColFontUnderline("no_agmt_flg")		 = true;
			sheetObj.ColFontUnderline("no_optm_rout_flg") 	 = true;
			sheetObj.ColFontUnderline("exceed_avg_diff_amt") = true;
			sheetObj.ColFontUnderline("bkg_no") = true;
			sheetObj.ColFontUnderline("etc_scg_nm")	 = true;
			sheetObj.ColFontUnderline("inv_etc_scg_nm")	 = true;
		}

		/**
	     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
	     * @param sheetObj
	     * @param Row
	     * @return
	     */
	    function sheet1_OnDblClick(sheetObj,Row,Col) {
	    	var ColName = sheetObj.ColSaveName(Col);
	    	
	    	switch(ColName){
	    		case "so_no" :
	    			sono_OnPopupClick(sheetObj,Row);
	    			break;
	    			
	    		case "no_agmt_flg" :
	    			noTariff_OnPopupClick(sheetObj,Row);
	    			break;
	    			
	    		case "no_optm_rout_flg" :
	    			route_OnPopupClick(sheetObj,Row);
	    			break;
	  
	    		case "exceed_avg_diff_amt" :
	    			amt_OnPopupClick(sheetObj,Row);
	    			break;
	    			
	    		case "bkg_no" :
	    			bkg_OnPopupClick(sheetObj,Row);
	    			break;
	    		case "etc_scg_nm" :
	    			if (sheetObj.CellValue(Row, Col).length > 0 ) {
	    				popSurchargeInputInquiry(sheetObj, Row, Col, 'search2', 'WO');
	    			}
	    			break;
	    		case "inv_etc_scg_nm" :
	    			if (sheetObj.CellValue(Row, Col).length > 0 ) {
	    				popSurchargeInputInquiry(sheetObj, Row, Col, 'search2', 'IV');
	    			}
	    			break;
	    	}
	    }

	    /**
		 * S/O_no 팝업호출
		 */
		function sono_OnPopupClick(sheetObject, row) {
			var sParam = Array();
			sParam[0] = "sowonumber="+ sheetObject.CellValue(row, "so_no");
			sParam[1] = "s_rail_cd="+ sheetObject.CellValue(row, "trsp_so_tp_cd");
			
			if (sheetObject.CellValue(row, "trsp_so_tp_cd") == 'R') {
				sParam[2] = "s_so_ofc_cd="+ sheetObject.CellValue(row, "wo_ofc_cd");
			}

			ComOpenWindowCenter("ESD_TRS_0019.do?"+sParam.join("&"), "so_inquiry", "1030", "690", true, "no");
		}

	    /**
	     * No_Tariff 팝업호출
	     */
	    function noTariff_OnPopupClick(sheetObject, row) {
			var sParam = Array();
			sParam[0] = "from="+ sheetObject.CellValue(row,"fm_nod_cd").substring(0,5);
			sParam[1] = "to="+ sheetObject.CellValue(row,"to_nod_cd").substring(0,5);
			sParam[2] = "via="+ sheetObject.CellValue(row,"via_nod_cd").substring(0,5);
			sParam[3] = "door="+ sheetObject.CellValue(row,"dor_nod_cd").substring(0,5);
			sParam[4] = "vndr_seq="+ formObj.s_dis_inv_vndr_seq.value;
			sParam[5] = "vndr_nm=" + formObj.s_dis_inv_vndr_nm.value;
			sParam[6] = "locl_cre_dt="+ sheetObject.CellValue(row,"locl_cre_dt");
			sParam[7] = "effective_agmt=A";

			ComOpenWindowCenter("ESD_TRS_0231.do?"+sParam.join("&"), "trs_agmt", "1030", "590", true, "no");
	    }

	    /**
	     * Non_Opt_Route 팝업호출
	     */
	    function route_OnPopupClick(sheetObject, row) {
			var sParam = Array();
			sParam[0] = "sel_wo_cre_ofc_cd="+ sheetObject.CellValue(row, "wo_ofc_cd");
			sParam[1] = "sel_from_date="+ sheetObject.CellValue(row, "inv_cfm_dt");
			sParam[2] = "sel_to_date="+ sheetObject.CellValue(row, "inv_cfm_dt");
			sParam[3] = "sel_bnd_cd="+ sheetObject.CellValue(row, "trsp_bnd_cd");
			sParam[4] = "sel_trsp_mod_cd="+ sheetObject.CellValue(row, "trsp_crr_mod_cd");
			sParam[5] = "sel_ofc_cd="+ sheetObject.CellValue(row, "wo_ofc_cd");
			sParam[6] = "sel_op_tp=SINGLE";
			sParam[7] = "sel_date=inv";
			sParam[8] = "sel_so_no="+ sheetObject.CellValue(row, "so_no");
			sParam[9] = "sel_bkg_no="+ sheetObject.CellValue(row, "bkg_no");

	    	var rhq_ofc = sheetObject.CellValue(row, "rhq_ofc_cd");
	    	if(rhq_ofc == "NYCRA"){
	    		ComOpenWindowCenter("ESD_TRS_0109.do?"+sParam.join("&"), "opt_route", "1030", "590", true, "no");
	    	}else{
	    		ComOpenWindowCenter("ESD_SCE_0171.do?"+sParam.join("&"), "opt_route", "1030", "590", true, "no");
	    	}
	    }
	    
	    /**
		 * BKG 팝업호출
		 */
		function bkg_OnPopupClick(sheetObject, row) {
			var sParam = Array();
			sParam[0] = "openTab=B8";
			sParam[1] = "bkg_no="+ sheetObject.CellValue(row, "bkg_no");
			bkg_no = sheetObject.CellValue(row, "bkg_no");
			if (bkg_no != "" && bkg_no != null) {
				// B8 Charge Tab ( from ESM_BKG_0079 : Booking Creation )
				ComOpenWindowCenter("ESM_BKG_0079.do?"+sParam.join("&"), "bkg_inquiry", "1024", "650", true, "no");
			}
		}
	    
	    /**
	     * Exceed Average Diff Amt 팝업호출
	     */
	    function amt_OnPopupClick(sheetObject, row) {
			var sParam = Array();
			sParam[0] = "sel_rhq_ofc_cd="+ sheetObject.CellValue(row, "rhq_ofc_cd");
			sParam[1] = "sel_wo_ofc_cd="+ sheetObject.CellValue(row, "wo_ofc_cd");
			sParam[2] = "wo_iss_pre_mon="+ sheetObject.CellValue(row, "wo_iss_pre_mon");
			sParam[3] = "sel_trsp_so_tp_cd="+ sheetObject.CellValue(row, "trsp_so_tp_cd");
			sParam[4] = "sel_trsp_cost_dtl_mod_cd="+ sheetObject.CellValue(row, "trsp_cost_dtl_mod_cd");
			sParam[5] = "sel_trsp_crr_mod_cd="+ sheetObject.CellValue(row, "trsp_crr_mod_cd");
			sParam[6] = "sel_trsp_bnd_cd="+ sheetObject.CellValue(row, "trsp_bnd_cd");
			sParam[7] = "sel_fm_nod_cd="+ sheetObject.CellValue(row, "fm_nod_cd");
			sParam[8] = "sel_to_nod_cd="+ sheetObject.CellValue(row, "to_nod_cd");
			sParam[9] = "sel_via_nod_cd="+ sheetObject.CellValue(row, "via_nod_cd");
			sParam[10] = "sel_dor_nod_cd="+ sheetObject.CellValue(row, "dor_nod_cd");

			var p_if_trsp_so_tp_cd = formObj.s_trsp_so_tp_cd.Code;
			if(p_if_trsp_so_tp_cd == "R"){
				ComShowCodeMessage('EAS90106'); // US Rail은 평균단가를 조회 할 수 없습니다.
				return false;
			}
			ComOpenWindowCenter("ESD_EAS_0306.do?"+sParam.join("&"), "exceed_avg", "1030", "590", true, "no");
	    }

		/**
		 * EAC I/F
		 */		
		function eac_if(sheetObject,Row){
			var p_sys_div_cd = "TRS";
			var p_sys_if_cd = "TRS";
			var p_vndr_seq = formObj.s_inv_vndr_seq.value;
			var	 p_inv_no    = formObj.s_inv_no.value;
			var	 p_if_inv_no = formObj.s_inv_no.value;
			var	 p_if_inv_vndr_seq = formObj.s_inv_vndr_seq.value;
			var	 p_if_trsp_so_tp_cd = formObj.s_trsp_so_tp_cd.Code;
			var	 p_expn_aud_sts_cd = formObj.s_expn_aud_sts_cd.Code;

			var	 p_hjl_inv_no = formObj.s_hjl_inv_no.value;
			
			if (p_expn_aud_sts_cd == 'A' || p_expn_aud_sts_cd == 'E' ) {
				//Coincidence, Potential EAC 일 경우만 EAC로 I/F 가능
			}else{
				ComShowCodeMessage('EAS90108');
				return;
			}
			
			var chkRowArr = Row.split("|");
			var	 p_eq_knd = "U";
			var p_eq_no = "";
			var p_tp_sz = "";
			var p_ofc_cd = "";
			var p_wo_no = "";
			var p_bkg_no = "";
			var p_if_so_no = "";
			var p_cur_cd = "";
			var p_inv_amt = "";
			var p_inv_iss_dt = "";
			for(i=0; i<chkRowArr.length-1; i++){
				if ((sheetObject.CellValue(chkRowArr[i], "bkg_no")).length > 0) {
					p_bkg_no		= p_bkg_no +"," + sheetObject.CellValue(chkRowArr[i], "bkg_no");
				}
				p_eq_no 		= p_eq_no +"," + sheetObject.CellValue(chkRowArr[i], "eq_no");
				p_tp_sz   		= p_tp_sz +"," + sheetObject.CellValue(chkRowArr[i], "eq_tpsz_cd");
				p_wo_no 		= p_wo_no+","+ sheetObject.CellValue(chkRowArr[i], "wo_no");
				p_ofc_cd 		= p_ofc_cd +"," + sheetObject.CellValue(chkRowArr[i], "wo_ofc_cd");
				p_if_so_no	= p_if_so_no +"," + sheetObject.CellValue(chkRowArr[i], "so_no");
				p_cur_cd    = sheetObject.CellValue(chkRowArr[i], "curr_cd");
				p_inv_amt   = sheetObject.CellValue(chkRowArr[i], "inv_amt");
				p_inv_iss_dt = sheetObject.CellValue(chkRowArr[i], "inv_cfm_dt");
			}
			if (p_bkg_no.length > 0) {
				p_bkg_no = fn_DeDuplication(p_bkg_no);
			}
            var arr_bkg_no = p_bkg_no.split(",");
            if (arr_bkg_no.length > 1) {
            	ComShowCodeMessage('EAS90107'); // Please, select same BKG No.
            	return;
            }
			p_eq_no		= p_eq_no.substring(1);
			p_tp_sz 		= p_tp_sz.substring(1);
            p_wo_no		= fn_DeDuplication(p_wo_no);
            p_ofc_cd		= fn_DeDuplication(p_ofc_cd);
            p_if_so_no	= p_if_so_no.substring(1);

			var sParam = Array();
			sParam[0] = "p_sys_div_cd="+ p_sys_div_cd;
			sParam[1] = "p_sys_if_cd="+ p_sys_if_cd;
			sParam[2] = "p_eq_no="+ p_eq_no;
			sParam[3] = "p_tp_sz="+ p_tp_sz;
			sParam[4] = "p_eq_knd="+ p_eq_knd;
			sParam[5] = "p_ofc_cd="+ p_ofc_cd;
			sParam[6] = "p_vndr_seq="+ p_vndr_seq;
			sParam[7] = "p_wo_no="+ p_wo_no;
			sParam[8] = "p_inv_no="+ p_inv_no;
			sParam[9] = "p_bkg_no="+ p_bkg_no;
			sParam[10] = "p_if_so_no="+ p_if_so_no;
			sParam[11] = "p_if_inv_no="+ p_if_inv_no;
			sParam[12] = "p_if_inv_vndr_seq="+ p_if_inv_vndr_seq;
			sParam[13] = "p_if_trsp_so_tp_cd="+ p_if_trsp_so_tp_cd;
			sParam[14] = "p_cur_cd="+ p_cur_cd;
			sParam[15] = "p_inv_amt="+ p_inv_amt;
			sParam[16] = "p_inv_iss_dt="+ p_inv_iss_dt;
			sParam[17] = "p_hjl_inv_no="+ p_hjl_inv_no;
			
			ComOpenWindowCenter("ESD_EAS_0224.do?"+sParam.join("&"), "EacIf", "1024", "620", true, "no");
		}
		
		/**
		 * EAC transfer 팝업호출 및 저장 후 eac_no 선택한 Row에 셋팅.
		 */		
		function fn_setEacNo(eac_no){
			if (eac_no.length == 14) {
				var sRow = sheetObjects[0].FindCheckedRow("chk");					
				var arrRow = sRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++){ 
					sheetObjects[0].CellValue2(arrRow[idx],'eac_if_flg') = "Y";
					sheetObjects[0].CellEditable(arrRow[idx], "chk") = false;
					sheetObjects[0].CellValue2(arrRow[idx], "chk") = "";
					formObj.t_eac_if_flg.value = "Y";
				}
			}
		}	 
		
		/**
		 * EAC I/F시 Parent 화면의 상태값 변경
		 */	
		function unLoadEac(){
			if(formObj.t_eac_if_flg.value == "") return;
			var parentObj = window.dialogArguments;
			parentObj.fn_setEacIfFlg();
		}
		
		/**
		 * Surcharge Input Inquiry popup
		 **/	
		function popSurchargeInputInquiry(sheetObj, row, col, mode,step)
		{
			var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";
			var url = 'ESD_TRS_0918.screen';
			url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
			url += '&open_mode='+mode;
			url += '&step_cd='+step;
			url += '&main_row='+row;
			url += '&ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
			url += '&so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
			url += '&sheet_arr_no=1';
			url += '&curr_cd='+sheetObj.CellValue(row, 'curr_cd');

			myWin = window.open(url, "popSurchargeInputInquiry", myOption);
			myWin.focus();
		}