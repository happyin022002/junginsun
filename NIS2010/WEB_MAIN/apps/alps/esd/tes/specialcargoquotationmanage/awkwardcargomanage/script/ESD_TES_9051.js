/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9051.js
*@FileTitle : AWK Cargo Tariff Excel Upload-Addon
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
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
	 * @author SM LINE
	 */
	
	/**
	 * @extends
	 * @class ESD_TES_9051 : ESD_TES_9051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_9051() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_loadexcel":
					// eBilling - B
//					if (window.dialogArguments.document.form.edi_flg.value == 'Y'){
//						return false;
//					}
//					// eBilling - E
//
//					if (!chkOprShtData()){
//						return false;
//					}
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
					if (!chkDupRow(sheetObject)){
						return false;
					}
        	        break;

         	    case "btn_popsave":
         	    	for(var i = 0; i < sheetObject.RowCount; i++) {
    					if (sheetObject.CellValue(i+2, "vrfy_rslt") != "SUCCESS") {
    						ComShowMessage(ComGetMsg('TES10088'));
    						return;
    					}
        	        }
         	    	
        	        if(sheetObject.RowCount > 0){
        	            doActionIBSheet(sheetObject,formObj,IBSAVE);
                    }
        	        break;
        	        
         	    case "btn_del":
         	    	sheetObject.RowDelete(sheetObject.SelectRow, false);
         	    	break;
        	        
         	    case "btn_verify":
					if (!chkDupRow(sheetObject)){
						return false;
					}
					
					if (sheetObject.RowCount > 0){
						doActionIBSheet(sheetObject,formObj,SEARCH02);
						
						if ((formObj.chk_flg.value) != "N"){							
							if (sheetObject.RowCount > 0){
								doActionIBSheet(sheetObject,formObj,SEARCH01);			
							}							
							if (sheetObject.RowCount > 0){
								doActionIBSheet(sheetObject,formObj,IBSEARCH);
							}
						}
					}				
					
//					alert("yyy : "+sheetObject.EtcData("vrfy_rslt"));
//						delBlkRows(sheetObject);
//						if (ComGetObjValue(formObj.manual_input_yn) != "Y"){ 
//							// 자동 mode
//							
//							//2008-07-11 추가 start - CHK Digit 후 CNTR 오류 check 초기화됨 그래서 CNTR 오류 다시 check 
//							val_chk(sheetObject);
//		                    chkDupRow(sheetObject);
//		                    rmvInvRow(sheetObject);
//		                    getMinMaxFilepuploadDate(sheetObject);
//		                    //2008-07-11 추가 end
//		                    
//							if (!verify_done){
//								if (formObj.vndr_seq.value==undefined || formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='' || 
//									formObj.yd_cd.value==undefined || formObj.yd_cd.value==null || formObj.yd_cd.value.trim()=='') 
//								{
//									ComShowMessage(ComGetMsg('TES23050','VNDR Code/YD_CD')); //ComShowMessage('VNDR Code/YD_CD에 오류가 발생하여 더 이상 진행할 수 없습니다. ');
//									return false;
//								}
//								if (formObj.fm_prd_dt.value==undefined || formObj.fm_prd_dt.value==null || formObj.fm_prd_dt.value.trim()=='' ||
//									formObj.to_prd_dt.value==undefined || formObj.to_prd_dt.value==null || formObj.to_prd_dt.value.trim()=='')
//								{
//									ComShowMessage(ComGetMsg('TES24016')); //ComShowMessage('Period 시작일과 종료일을 입력하십시오.');
//								}
//								if (rmvInvRow(sheetObject)){
//									doActionIBSheet(sheetObject,formObj,IBSEARCH);
//								} 
//							} else {
//								ComShowMessage(ComGetMsg('TES23052')); //ComShowMessage('['+sheetObject.RowCount+'] verify 완료 상태');
//							}
//						} else {
//							// 수동 mode
//							for (var i=1; sheetObject!=null && i<=sheetObject.RowCount; i++){
//								// 수동 mode시 verify마다 초기화하고 다시 전부 검사한다...
//								sheetObject.CellValue2(i,'valid_chk') = '';
//								sheetObject.CellValue2(i,'dup_chk_conf') = '';
//								sheetObject.RowFontColor(i) = sheetObject.RgbColor(0, 0, 0);
//							}
//							val_chk(sheetObject);
//							chkDupRow(sheetObject);
//							if (rmvInvRow(sheetObject)){
//								getMinMaxFilepuploadDate(sheetObject);
//								if (sheetObject.RowCount > 0){
//									doActionIBSheet(sheetObject,formObj,IBSEARCH);
//								} else {
//									ComShowMessage(ComGetMsg('TES23051')); //ComShowMessage('verify할 data가 없습니다.');
//									break;
//								}
//							}
//						}
//					}
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
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
//		doActionIBSheet(sheetObj,formObj,IBSEARCH); 
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
	
				// 높이 설정
				style.height = 400;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
//				InitHeadMode(false, false, true, false, false, false);
				InitHeadMode(true, true, false, true, false, false);
//				SelectionMode = smSelectionList;
	
				var HeadTitle1 = "||FROM|FROM|TO|TO|Unit Cost Manual|Unit Cost Manual|Unit Cost Manual|||Service Provider|Tariff Condition|Tariff Condition|Remark|Verify Result";
	            var HeadTitle2 = "||FM Port|TML|TO Port|TML|Curr|20'|40'|||Service Provider|ID|Condition Desc|Remark|Verify Result"; 
	            var headCount = ComCountHeadTitle(HeadTitle1);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 5, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false)
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            
//	            var prefix="sheet1_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,   30,  	daCenter,  false,       "ibflag",	   			false,      "",     dfNone,      	0,      true,  true );
	            InitDataProperty(0, cnt++ , dtHidden,	120,		daCenter,	true,		"chk_flg",				false,		"",		dfNone,			0,		false,	false);
	            InitDataProperty(0, cnt++ , dtData,		85,			daCenter,	true,		"fm_loc_cd",			true,		"",		dfEngUpKey,		0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		55,			daCenter,	true,		"fm_nod_yd_no",			false,		"",		dfNone,			0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		85,			daCenter,	true,		"to_loc_cd",			true,		"",		dfEngUpKey,		0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		55,			daCenter,	true,		"to_nod_yd_no",			false,		"",		dfNone,			0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		75,			daCenter,	true,		"man_locl_curr_cd",		false,		"",		dfNone,			0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		75,			daRight,	true,		"man_locl_amt_20ft",	false,		"",		dfNullFloat,	2,		true,	true, 15);
	            InitDataProperty(0, cnt++ , dtData,		75,			daRight,	true,		"man_locl_amt_40ft",	false,		"",		dfNullFloat,	2,		true,	true, 15);
	            InitDataProperty(0, cnt++ , dtHidden,	70,			daRight,	true,		"man_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,	false, 15);
                InitDataProperty(0, cnt++ , dtHidden,	70,			daRight,	true,		"man_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,	false, 15);                
	            InitDataProperty(0, cnt++ , dtData,		130,		daCenter,	true,		"vndr_nm",				false,		"",		dfNone,			0,		false,	false);
	            InitDataProperty(0, cnt++ , dtData,		40,			daLeft,		true,		"cond_no",				true,		"",		dfNone,			0,		true,	true);
	            InitDataProperty(0, cnt++ , dtData,		300,		daLeft,		true,		"cond_desc",			false,		"",		dfNone,			0,		false,	false);
	            InitDataProperty(0, cnt++ , dtData,		120,		daRight,	true,		"calc_rmk",				false,		"",		dfNone,			0,		false,	false);
	            InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,		"vrfy_rslt",			false,		"",		dfNone,			0,		false,	false);
			}   
			break;
		}
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {
	 	var sheetObj = sheetObjects[0];
	     switch(sAction) {
			case SEARCH01: //조회
			formObj.f_cmd.value = SEARCH01;
			var usdStr = ""; 
			// loop
			for(var i = 0; i < sheetObj.RowCount; i++) {
				usdStr  = "man_locl_amt_20ft="    + sheetObj.CellValue(i+2, "man_locl_amt_20ft")
						+ "&man_locl_amt_40ft="   + sheetObj.CellValue(i+2, "man_locl_amt_40ft")
						+ "&man_locl_curr_cd="    + sheetObj.CellValue(i+2, "man_locl_curr_cd")
						+ "&Row="         		  + (i+2)
						+ "&f_cmd="               + formObj.f_cmd.value ;
				
				var sXml = sheetObj.GetSearchXml("ESD_TES_9051GS.do", usdStr);
				sheetObj.CellValue2(i+2, "man_usd_amt_20ft") = ComGetEtcData(sXml, "man_usd_amt_20ft");
				sheetObj.CellValue2(i+2, "man_usd_amt_40ft") = ComGetEtcData(sXml, "man_usd_amt_40ft");
			}
			
			break;
			
			case SEARCH02: //조회
			formObj.f_cmd.value = SEARCH02;
			var authStr = ""; 
			// loop
			for(var i = 0; i < sheetObj.RowCount; i++) {
				authStr = "fm_yd_cd="      + sheetObj.CellValue(i+2, "fm_loc_cd")+ sheetObj.CellValue(i+2, "fm_nod_yd_no")
						+ "&to_yd_cd="      + sheetObj.CellValue(i+2, "to_loc_cd")+ sheetObj.CellValue(i+2, "to_nod_yd_no")
						+ "&lg_ofc_cd="	   + formObj.lg_ofc_cd.value
						+ "&Row="          + (i+2)
						+ "&f_cmd="        + formObj.f_cmd.value ;
				
				var sXml = sheetObj.GetSearchXml("ESD_TES_9051GS.do", authStr);
				
				sheetObj.CellValue2(i+2, "chk_flg") = ComGetEtcData(sXml, "chk_flg");
				formObj.chk_flg.value               = ComGetEtcData(sXml, "chk_flg");
				
				if(ComGetEtcData(sXml, "chk_flg") != "Y") {
					ComShowCodeMessage('TES90112', sheetObj.CellValue(i+2, "fm_loc_cd")+ sheetObj.CellValue(i+2, "fm_nod_yd_no"),sheetObj.CellValue(i+2, "to_loc_cd")+ sheetObj.CellValue(i+2, "to_nod_yd_no") ); //No authority to create data for From [{?msg1}] To [{?msg2}]
					return false;
				}
			}
			
//			sheetObj.LoadSearchXml(sXml);
			
			break;
			
			case IBSEARCH: //조회
				formObj.f_cmd.value = SEARCH;
				var condStr = ""; 
				// loop
				for(var i = 0; i < sheetObj.RowCount; i++) {
					condStr = "fm_loc_cd="    + sheetObj.CellValue(i+2, "fm_loc_cd")
							+ "&fm_nod_yd_no="+ sheetObj.CellValue(i+2, "fm_nod_yd_no")
							+ "&to_loc_cd="   + sheetObj.CellValue(i+2, "to_loc_cd")
							+ "&to_nod_yd_no="+ sheetObj.CellValue(i+2, "to_nod_yd_no")
							+ "&cond_no="	  + sheetObj.CellValue(i+2, "cond_no")
							+ "&Row="         + (i+2)
							+ "&f_cmd="       + formObj.f_cmd.value ;
					
					var sXml = sheetObj.GetSearchXml("ESD_TES_9051GS.do", condStr);
					sheetObj.CellValue2(i+2, "vrfy_rslt") = ComGetEtcData(sXml, "vrfy_rslt");
					
					if(ComGetEtcData(sXml, "vrfy_rslt") != "SUCCESS") {
						sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(255, 0, 0);
					} else {
						sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(0, 0, 0);
					}
				}
				
//				sheetObj.LoadSearchXml(sXml);
				
				break;
				
			case IBSAVE:
				if(sheetObj.RowCount < 1){
					ComShowCodeMessage('TES10028'); //There is no contents to save.
					return;
				}
				
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					var sParam = ComGetSaveString(sheetObj, false);
					if (sParam == ""){
						ComOpenWait(false);
						ComShowCodeMessage('TES10028'); //There is no data to Save.\n\n Please check again.
						return;
					} else {
						formObj.f_cmd.value = MULTI01;
						sParam = sParam + "&" + "f_cmd=" + formObj.f_cmd.value ;
					}
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSaveXml("ESD_TES_9051GS.do", sParam);
					ComOpenWait(false);		

					var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if(nodeText == "S"){
						ComShowCodeMessage('TES90104'); //Data saved successfully
					}
					window.close();
				}
				break;
			
			case IBLOADEXCEL:
                sheetObj.LoadExcel(-1); // false -> 엑셀로부터 무조건 읽어오기
                break;	
		  }
	}  
	 
	function sheet1_OnClick(sheetObj, row, col, value) {
		if (sheetObj.ColSaveName(col) == "calc_rmk") {
			ComShowMemoPad(sheetObj, null, null, true, 300, 120, 600);
		}
	}
	
  	function chkDupRow(sheetObject){
		var idx = 0;
		var Rows = "";
		Rows = sheetObject.ColValueDupRows("fm_loc_cd|fm_nod_yd_no|to_loc_cd|to_nod_yd_no|cond_no", false);
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=""){
			arr_rows = Rows.split(',');
		}
		if(arr_rows != null){
    		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    			sheetObject.RowFontColor(arr_rows[i]) = sheetObject.RgbColor(255, 0, 0);
    			sheetObject.RowBackColor(arr_rows[i]) = sheetObject.RgbColor(192,192,192);
    		}
    		ComShowCodeMessage('TES24030', 'Data');
    		return false;
		}
		return true;
	}

  	function sheetObject_OnSearchEnd(sheetObject, ErrMsg){

		if (sheetObject.RowCount > 0){
				//alert("xxx : "+sheetObject.EtcData("vrfy_rslt"));
				vrfyRslt = sheetObject.EtcData("vrfy_rslt");
				sheet.RemoveEtcData();
				//insCnt += opener_obj.document.t1sheet1.RowCount;
				//insCnt += opener_obj.document.t2sheet1.RowCount;
				vrfyRst = (vrfyRst!=undefined&&vrfyRst!=null&vrfyRst!=''?vrfyRst:0);
				
				window.focus();
				ComShowMessage(ComGetMsg('TES23058',vrfyRst)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
				window.close();
		}
	}
  	
  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var headCnt = sheetObj.HeaderRows;
   		for(var i=headCnt; i<=sheetObj.LastRow; i++){
   			if(sheetObj.CellValue(i, "ibflag") != "D"){
   				if(sheetObj.CellValue(i, "fm_loc_cd") == "" || sheetObj.CellValue(i, "to_loc_cd") == ""){
       				ComShowCodeMessage('TES22037', '[Port Code]'); //Port Code is Mandatory item.
       				return false;
       			}
       			if(sheetObj.CellValue(i, "man_usd_amt_20ft") == ""){
       				 ComShowCodeMessage("TES22037", "[20ft Unit Cost Manual Amount]"); //20ft Unit Cost Manual Amount is Mandatory item.
       				return false;
       			}
       			if(sheetObj.CellValue(i, "man_usd_amt_40ft") == ""){
       				ComShowCodeMessage("TES22037", "[40ft Unit Cost Manual Amount]"); //40ft Unit Cost Manual Amount is Mandatory item.
       				return false;
           		}
   			}	
   		}
       	return true;
    } 	
	
/* 개발자 작업 끝 */