/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1075.js
*@FileTitle : Booking Receipt Notice And Draft B/L Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.24 김영출
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.27 전성진 [CHM-201006057] Booking Receipt Notice "Full Return Date" 표기 관련 : Return CY 입력불가 해제
* 2010.10.29 이일민 [CHM-201006561] BKG CCT 팝업 화면에 Empty P/UP Date 항목 추가
* 2012.11.15 김보배 [CHM-201221357] [BKG] Split 01-Booking Receipt Notice & Draft B/L Set Up 화면 보완 요청
* 2012.12.17 김보배 [CHM-201221885] [BKG] Split 01-Draft BL Contents 내용 Set up 기능 요청
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
     * @class ESM_BKG_1075 : ESM_BKG_1075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1075() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//var comboObjects = new Array();
	//var comboCnt = 0;
	//var org_cnt_cd_str = '';
	//var org_cnt_nm_str = 'ALL';
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrieve":
					if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_rowadd":
					if(ComIsBtnEnable("btn_rowadd")){
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					}
				break;																	
	
				case "btn_rowdel":
					if(ComIsBtnEnable("btn_rowdel")){
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					}

				break;																																				

            } // end switch
    	}catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
    	}
    }

	/* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 */
	//function setComboObject(combo_obj){
	//   comboObjects[comboCnt++] = combo_obj;
	//}

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
		// IBMultiCombo초기화
		//for(var j=0;j<comboObjects.length;j++){
		//	initCombo(comboObjects[j],j+1);
		//}
		// IBSheet 초기화
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// set init-data for sheets
		//if(document.form.ofc_cd.value != ''){
		//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//}
		// add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
	}
	
	/**
	 * 초기 initCombo 설정하기 
	 */
	function initCombo(comboObj, comboNo) {
		//comboObj.RemoveAll(); 
		//comboObj.UseEdit = true;
		
		//comboObj.InsertItem(0, "  |ALL", "  ");
		
		//alert(org_cnt_nm_str);
		var arrData = org_cnt_nm_str.split("|");
		var arrTemp = null;
		for (i=0;i<arrData.length;i++) {
			if(arrData[i] == ''){
				continue;
			}else{
				arrTemp = arrData[i].split("\t");
				comboObj.InsertItem(i, arrTemp[0]+"|"+arrTemp[1], arrTemp[0]);
			}
		}
		
		//comboObj.Code = "  ";
	}

   /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Sel.|Item|BKG OFC|Customer Code|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Draft B/L|Draft B/L|Draft B/L|Draft B/L|Draft B/L|Draft B/L|Loading Confirmation";
					var HeadTitle2 = "|Sel.|Item|BKG OFC|Customer Code|M'ty P/Up CY|Return CY|Port|Rail Receiving|Documentation|Customs|Remark(P.S)|Call Sign|MRN|CRN|Exchange Rate|Remark|Content|Remark";

					var headCount = ComCountHeadTitle(HeadTitle2);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                                        
                    //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  20,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++, dtDummyCheck,    30,    daCenter,  true,     "sel");
                    InitDataProperty(0, cnt++, dtHidden,        30,    daCenter,  true,     "itm_seq");
                    InitDataProperty(0, cnt++, dtData,          55,    daLeft,    true,     "bkg_ofc_cd",      false,    "",         dfNone,     0,          false,      true,     6);
                    InitDataProperty(0, cnt++, dtData,          100,   daLeft,    true,     "cust_cd",         false,    "",         dfNone,     0,          false,      true,     8);
                    InitDataProperty(0, cnt++, dtCheckBox,      80,    daCenter,  true,     "mty_pkup_yd_flg", false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      70,    daCenter,  true,     "full_rtn_yd_flg", false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      50,    daCenter,  true,     "port_coff_flg",   false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      90,    daCenter,  true,     "rail_rcv_flg",    false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      100,   daCenter,  true,     "doc_coff_flg",    false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      60,    daCenter,  true,     "cust_coff_flg",   false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtData,          250,   daLeft,    true,     "rct_ntc_rmk",     false,    "",         dfNone,     0,          true,       true,     1300);
                    InitDataProperty(0, cnt++, dtCheckBox,      60,    daCenter,  true,     "call_sgn_flg",    false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      60,    daCenter,  true,     "mrn_flg",         false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      60,    daCenter,  true,     "crn_flg",         false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtCheckBox,      90,    daCenter,  true,     "xch_rt_flg",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtData,          250,   daLeft,    true,     "diff_rmk",        false,    "",         dfNone,     0,          true,       true,     1300);
                    InitDataProperty(0, cnt++, dtData,          300,   daLeft,    true,     "eml_ctnt",        false,    "",         dfNone,     0,          true,       true,      500);
                    InitDataProperty(0, cnt++, dtData,          150,   daLeft,    true,     "lodg_cfm_rmk",    false,    "",         dfNone,     0,          true,       true,     1300);
					
					//InitDataCombo(0, "bkg_ofc_cd",  org_cnt_cd_str, org_cnt_cd_str, "", "", 0);
					
            	}
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_1075GS.do", FormQueryString(formObj));
					// 데이터 변경 여부 체크
					formObj.dirty_flag.value = 'N';
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					//sheetObj.DoSave("ESM_BKG_1075GS.do", FormQueryString(formObj), -1, false, true);
					var sParam = "f_cmd=7&" + sheetObj.GetSaveString();
					
					var rXml = sheetObj.GetSaveXml("ESM_BKG_1075GS.do", sParam);
					//alert(rXml);
					var rMsg = ComResultMessage(rXml);
					//alert(rMsg);
					if(rMsg == ''){
						sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						ComShowMessage(ComGetMsg("BKG00166"));
						// 데이터 변경 여부 체크
						formObj.dirty_flag.value = 'N';
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false;
					}
                }else{
					return false;					
				}
			break;

			case IBINSERT:      //조회
				var newRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(newRow, "bkg_ofc_cd") = formObj.bkg_ofc_cd.value;
				sheetObj.CellValue2(newRow, "cust_cd") =  formObj.cust_cd.value;
				// 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
			break;
			
			case IBDELETE:        //저장
				var selRows = sheetObj.FindCheckedRow("sel");
				if(selRows == ''){
					ComShowMessage(ComGetMsg("COM12189"));
					return false;
				}
				var idxArr = selRows.split("|");
				for(ix=0;ix<idxArr.length;ix++){
					if(idxArr[ix] == '') continue;
					sheetObj.RowStatus(idxArr[ix]) = 'D';
					sheetObj.RowHidden(idxArr[ix]) = true;
				}
				// 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
			break;

        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

			case IBSEARCH:
				/*
				if(ComIsEmpty(formObj.cust_cd.value)){
					ComShowMessage(ComGetMsg("BKG00545", "CUST_CD"));
					formObj.cust_cd.focus();
					return false;
				}
				if(formObj.cust_cd.value.length < 3){
					ComShowMessage(ComGetMsg("BKG00545", "CUST_CD"));
					formObj.cust_cd.focus();
					return false;
				}
				*/
			break;

            case IBSAVE:
//				if(formObj.dirty_flag.value != 'Y'){
				if(formObj.dirty_flag.value == 'N' || sheetObj.GetSaveString() == ""){
					ComShowMessage(ComGetMsg("BKG00737"));
					return false;
				}
				var rIdx = sheetObj.HeaderRows;
				var rCnt = sheetObj.RowCount;
				var rowCnt = rIdx + rCnt;
//				alert("rIdx:" + rIdx + "|rCnt:" + rCnt);
				var bkg_ofc_cd = '';
				var cust_cd =  '';

				for(var i=0 ;i<=rowCnt ;i++ ){
					if(sheetObj.RowStatus(i) != "" && sheetObj.CellValue(i, "rct_ntc_rmk") != "") {
						sheetObj.CellValue2(i, "rct_ntc_rmk") = sheetObj.CellValue(i, "rct_ntc_rmk").toUpperCase();
					}
				}
				
				for(ir=0 ;ir<rCnt ;ir++ ){
					bkg_ofc_cd = sheetObj.cellValue(rIdx, "bkg_ofc_cd");
					cust_cd = sheetObj.cellValue(rIdx, "cust_cd");
					//alert("* " +rIdx+ " : org_cnt_cd=" +org_cnt_cd+ ", cust_cd=" + cust_cd);
					if(ComIsEmpty(bkg_ofc_cd)){
						ComShowMessage(ComGetMsg("BKG00545", "OFC_CD"));
						sheetObj.SelectCell(rIdx, "bkg_ofc_cd");
						return false;
					}
					/*
					if(org_cnt_cd.length != 2){
						ComShowMessage(ComGetMsg("BKG00545", "ORG_CNT_CD"));
						sheetObj.SelectCell(rIdx, "org_cnt_cd");
						return false;
					}
					if(ComIsEmpty(cust_cd)){
						ComShowMessage(ComGetMsg("BKG00545", "CUST_CD"));
						sheetObj.SelectCell(rIdx, "cust_cd");
						return false;
					}
					*/
					if(cust_cd != '' && cust_cd.length < 3){
						ComShowMessage(ComGetMsg("BKG00545", "CUST_CD"));
						sheetObj.SelectCell(rIdx, "cust_cd");
						return false;
					}
					rIdx++;
					
										
				}
			break;
        }

        return true;
    }
     

	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}

    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }
	
	function form1_keypress(){
		//
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}	
	}

    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		// 데이터 변경 여부 체크
		//document.form.dirty_flag.value = 'Y';

    }

	function sheet1_OnChange(sheetObj, row, col, val) {
		
		// 데이터 변경 여부 체크
		document.form.dirty_flag.value = 'Y';

		/* ColSaveName */
		var col_save_name = sheetObj.ColSaveName(col);
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		
		if(col_save_name == 'eml_ctnt'){
			return;
		}else {
			/* 대문자 */
			if(data_type == dtData) {
				sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
			}
		}
		
	}

	function comObj1_OnChange(comObj, index, text){
		//alert(index + " = " + text);
		//ComSetObjValue(document.form.org_cnt_cd, index);
	}	
	
	/**
     * 시트를 클릭했을 때 처리
     */
	function sheet1_OnClick(sheetObj, row, col) {
	    	
		var colSaveName = sheetObj.ColSaveName(col);
	        
		
		switch(colSaveName) {
			case "rct_ntc_rmk" :
				
				document.form.dirty_flag.value = 'Y';
	    		/* 긴 문자열 MemoPad 처리*/
    			sheetObj.CellEditable(row, col) = false;
    			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
    			sheetObj.CellEditable(row, col) = true;
    		break;
		}
	}
    
	/* 개발자 작업  끝 */