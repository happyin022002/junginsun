/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0003.js
*@FileTitle : Queue list Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : yoo
*@LastVersion : 1.0
* 2016.06.23 yoo
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
     * @class EES_DOD_0003 : EES_DOD_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DOD_0003() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject         = setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
//    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
//	var loadingMode = false;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject	 = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var sheetObject2 = sheetObjects[2];
    	
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {
	          	case "btn_customer":
	          		goCustomer();
	          		break;
	          		
            	case "btn_retrieve":
	             	doActionIBSheet(sheetObject, formObject, IBSEARCH);
	             	break;

    			case "btn_downexcel":
    				sheetObject2.RemoveAll(); //반드시 초기화 해야한다. 아님 계속 뒤에 붙인다.
    				sheetObject.ExcelPrint = "";
    	            for (i=0; i<sheetObject.RowCount; i++){
    	                sheetObject2.DataInsert(-1);
    	            }
    				sheetObject.Copy2SheetCol(sheetObject2);
    				sheetObject2.DataInsert(-1);
    				var currRow = sheetObject2.LastRow;
    				sheetObject2.CellText(currRow,"tro_ib_cfm_ofc_cd") = "Total";
    				sheetObject2.CellValue2(currRow, "curr_cd")  = sheetObject.CellValue(1,"str_ttl_curr_cd");
    				sheetObject2.CellValue2(currRow, "ttl_amt")  = sheetObject.CellValue(1,"str_ttl_amt");
    				sheetObject2.InitDataProperty(0, 1, dtData, 30, daRight, false, "seq", false, "", dfNone, 2, false, false);
    				sheetObject2.InitDataProperty(0, 19, dtData, 100, daRight, false, "gen_trf_amt", false, "", dfNone, 2, false, false);
    				sheetObject2.InitDataProperty(0, 20, dtData, 100, daRight, false, "spcl_trf_amt", false, "", dfNone, 2, false, false);
    				sheetObject2.InitDataProperty(0, 21, dtData, 100, daRight, false, "dc_amt", false, "", dfNone, 2, false, false);
    				sheetObject2.InitDataProperty(0, 23, dtData, 60, daCenter, false, "atch_file_lnk_cnt", false, "", dfNone, 2, false, false);
    				sheetObject2.CellValue2(currRow, "seq")  = '';
    				sheetObject2.CellValue2(currRow, "gen_trf_amt")  = '';
    				sheetObject2.CellValue2(currRow, "spcl_trf_amt")  = '';
    				sheetObject2.CellValue2(currRow, "dc_amt")  = '';
    				sheetObject2.CellValue2(currRow, "atch_file_lnk_cnt")  = '';
    				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    				break;

     			case "btn_new":
	        		if(!initConfirm()) {
	        			return;
	        		}
	        		ComResetAll();
	        		doInit();
	        		
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

    /**
    * IBSheet Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }    

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
//    	loadingMode = true;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
//		loadingMode = false;
		for(var k=0;k<comboObjects.length;k++){
//			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 600; //Combo 리스트에 나오는 라인 수 조정
		}

		initControl();

		if(document.form.ofc_cd.value == "GOASC"){
			ComBtnEnable("btn_save");
		}else{
			ComBtnDisable("btn_save");
		}
    }

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerForm  ('change', 'obj_change', document.form);
    }
    
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;

      	doInit();
      	sheetObjects[0].WaitImageVisible = true;   
	}     
    
	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
		
		ofc_flg_click();
		
		ttl_usd_locl_amt.innerHTML = "";
	}
	
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[0];


		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND02);
			ComEnableObject(formObj.chk_sub_ofc, true);
		}
	}
	
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
	   	 sheetObj.ShowDebugMsg = false;
	   	 sheetObj.WaitImageVisible = false;
	   	 
	   	 formObj.f_cmd.value = formCmd;
	   	 var sXml = sheetObj.GetSearchXml("DODCommonFinderGS.do", FormQueryString(formObj));
	   	 
	  	 switch(formCmd) {
	   	 	
	   	 	case COMMAND01:	// RHQ
	   	 		with (comboObj) { 
		    	 		RemoveAll();
						MultiSelect = false;
						SetColWidth("45");
						ValidChar(2);	// 영대문자만 사용
						//MaxLength = 6;
	   	 		}
	   	 		var data = ComGetEtcData(sXml, "office");
   	 			if (data != undefined && data != '') {
   	 				var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				break;
				
	   	 	case COMMAND02: // Office
	   	 		with (comboObj) { 
		    	 		RemoveAll();
						MultiSelect = true;
						SetColWidth("95");
						ValidChar(2, 2); // 영대문자, 특수문자만 가능
	   	 		}
				var data = ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					var idx = 0;
					
					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
					if(data.indexOf(usrOfcCd) == -1) {
						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
						idx = 1;
					}
					
		    	    var comboItems = data.split("|");
		    	    for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
		         	}
	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
				}
	    	    break;
		    	    
	   	 	case COMMAND03:	// Incl. Sub Office
	   	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	   	 		if (subOfcCds != undefined && subOfcCds != '') {
	   	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
						
						if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
							subOfcCds = usrOfcCd + ',' + subOfcCds;
		    	   			
						comboObj.Code = subOfcCds;
	   	 		}
	   	 		break;
	   	 }
	}
	
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
        var okYn = true;
     	if(sheetObjects[0].isDataModified) {     		
     		var okYn = confirm(ComGetMsg('DOD00003'));
     	}
     	return okYn;
    }
    
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				if(obj.name=="vndr_seq"){
					//ComKeyOnlyNumber(obj,",");
					ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
				} else {
					ComKeyOnlyNumber(obj);
				}
				break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	}
    
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {

			case "del_cd":		// DEL CODE VALIDATION
				var formObjects = document.form;
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH08 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "DEL"));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			
			case "s_cust_cd":		// Customer VAILIDATION
				if(obj.value.trim() == ""){
					document.form.s_cust_nm.value = "";
					return;
				}
				var param = "f_cmd=" + SEARCH02 + "&s_value=" + obj.value.substr(0,2) + ComLpad(obj.value.substr(2), 6, "0");
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
						obj.value = "";
						obj.focus();
						return;
					}
				}
				var param = "f_cmd=" + SEARCH + "&cust_cd=" + obj.value.substr(0,2) +"&cust="+ obj.value.substr(2);
				var sXml = sheetObjects[1].GetSearchXml("COM_ENS_041GS.do", param);
				var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
				if(rtnArr != null && rtnArr.length > 1){
					document.form.s_cust_cd.value = rtnArr[0];
					document.form.s_cust_nm.value = rtnArr[1];
					
				} else {
					ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
					document.form.s_cust_cd.value = "";
					document.form.s_cust_nm.value = "";
					obj.focus();
				}
			break;
			
			case "bkg_no":		// BKG_NO VAILIDATION
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH03 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "BKG No."));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			
			case "cntr_no":		// CNTR_NO VAILIDATION
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH04 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "CNTR No."));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			
			case "cntr_rtn_yd_cd":		// RTN CY CODE VALIDATION
				var formObjects = document.form;
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH09 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "Return CY"));
						obj.value = "";
						obj.focus();
					}
				}
			break;
		}		
	} 	
	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		switch (sheetObj.ColSaveName(Col)) {
			case "selChk":
				var selBkgNo = sheetObj.CellValue(Row, "bkg_no");
				if(Value == 0) {
					for(var i = 1; i < sheetObj.Rows; i++){
						if(selBkgNo == sheetObj.CellValue(i, "bkg_no") && Row != i){
							sheetObj.CellValue2(i, "selChk") = 1;
						}
					}
				}
				break;
				
			case "atch_file_lnk_cnt":
				dodFileUploadPopUp(sheetObj, Row, "CHG", "Y", "");
				break;
				
			default:
				break;
		}
	}
	

    /**
     * IBSheet Object에서 입력값이 변경된 경우
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
//		var ttlAmt = "";
//		if(sheetObj.ColSaveName(Col) == "dc_amt") {// Discount컬럼에 값이 변경되면
//			alert(Col);
//			ttlAmt = sheetObj.CellValue(Row, "ttl_amt");
//
//			if(sheetObj.CellValue(Row, "spcl_trf_amt") > 0) {
//				ttlAmt = sheetObj.CellValue(Row, "spcl_trf_amt");
////				ttlAmt = ( parseFloat(ttlAmt) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt")) ) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
//				ttlAmt = parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
//			}else{// Special Tariff가 존재하지 않으면 General Tariff에서 차감
//				ttlAmt = sheetObj.CellValue(Row, "gen_trf_amt");
//				ttlAmt = parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
//			}
//			
//			if(ttlAmt == 0 || ttlAmt < 0) {
////				ComShowCodeMessage('DOD00036');					
////				sheetObj.CellValue(Row, "dc_amt") = "";
//				sheetObj.CellValue2(Row, "ttl_amt") = "";
//			}else if(ttlAmt > 0){
//				if(sheetObj.CellValue(Row, "spcl_trf_amt") == 0 && sheetObj.CellValue(Row, "gen_trf_amt") == 0) {
//					ComShowCodeMessage('DOD00016');					
//					sheetObj.CellValue2(Row, "dc_amt") = "";
//					sheetObj.CellValue2(Row, "ttl_amt") = "";
//				}else{
//					sheetObj.CellValue2(Row, "ttl_amt") = ttlAmt;
//				}
//			}
//		} else if(sheetObj.ColSaveName(Col) == "svc_fee_amt") {// Correction Fee컬럼에 값이 변경되면
//			alert(Col);
//			ttlAmt = sheetObj.CellValue(Row, "ttl_amt");
//
//			if(sheetObj.CellValue(Row, "spcl_trf_amt") > 0) {
//				ttlAmt = sheetObj.CellValue(Row, "spcl_trf_amt");
//				ttlAmt = ( parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt")) ) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt"));
//				
//			}else{// Special Tariff가 존재하지 않으면 General Tariff에서 차감
//				ttlAmt = sheetObj.CellValue(Row, "gen_trf_amt");
//				ttlAmt = ( parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt")) ) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt"));
//
//			}
//			
//			if(ttlAmt < 0) {						
////				ComShowCodeMessage('DOD00004');					
//				sheetObj.CellValue2(Row, "svc_fee_amt") = "";
//				sheetObj.CellValue2(Row, "ttl_amt") = "";
//				
//			}else{
//				sheetObj.CellValue2(Row, "ttl_amt") = ttlAmt;
//				
//			}
//			
//		} else if(sheetObj.ColSaveName(Col) == "cust_cd_seq") {
//			var custCdSeq = sheetObj.CellValue(Row, "cust_cd_seq");
//			
//			if(checkINVCustomer(sheetObj, Row, custCdSeq)) {				
//				changeINVCustomer(sheetObj, Row, custCdSeq);
//			}
//		}
	}
	
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[0]; 
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObj.Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND03);
			
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
   function initSheet(sheetObj,sheetNo) {
       var cnt = 0;
       if (sheetNo == 1 || sheetNo == 3) {
    	   with (sheetObj) {
    		   if (sheetNo == 3){
    			   style.height = 0;
    		   } else {
    			   style.height = GetSheetHeight(20);
    		   }

	   			//전체 너비 설정
	   			SheetWidth = mainTable.clientWidth;
	   			
	   			//Host정보 설정[필수][HostIp, Port, PagePath]
	   			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	   			
	   			//전체Merge 종류 [선택, Default msNone]
	   			MergeSheet = msHeaderOnly;
	   			
	   			//전체Edit 허용 여부 [선택, Default false]
	   			Editable = true;
	   			
	   			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	   			InitRowInfo( 1, 1, 3, 100);
	   			
	   			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	   			InitColumnInfo(41, 0, 0, true);
	   			
	   			// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
	   			InitHeadMode(true, true, true, true, false,false)
	   			
	   			var HeadTitle = "|SEQ||Office|BKG No.|TRO Date|CNTR No.|TP/SZ|BKG POD|RTN CY|RTN Date|INV CUST|INV CUST Name|ZIP Code|Special CUST Code|Special CUST Name|RFA No.|S/C No.|CUR|General Tariff|Special Tariff|Discount|Final AMT|File|Internal Remark||";
	   			
	   			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	   			InitHeadRow(0, HeadTitle, true);
	   			
	   			// 컬럼 고정
	   			sheetObj.FrozenCols = 8;
	   			
	   			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	   			InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,  "ibflag");
	   			InitDataProperty(0, cnt++,	dtSeq,			 30,	daCenter,	false,	"seq",					false,    		"",       dfNone,    0,     true,       true);
	   			InitDataProperty(0, cnt++ , dtHidden,  	 30,	daCenter,	false,  "selChk");
	   			InitDataProperty(0, cnt++ , dtData,    		 50,	daCenter,  	false,	"tro_ib_cfm_ofc_cd",	false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"bkg_no",				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"tro_ib_cfm_dt",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"cntr_no",	 			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"cntr_tpsz_cd",			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"del_cd", 				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"cntr_rtn_yd_cd", 		false,          "",      dfNone,     0,     false,      false,	7);
	   			InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"cntr_rtn_dt", 			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,     	 110,	daCenter,  	false,	"cust_cd_seq",			false,          "",      dfNone,     0,     false,      false, 8);
	   			InitDataProperty(0, cnt++ , dtData,      	 100,	daLeft,  	false,	"cust_lgl_eng_nm", 		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 80,	daCenter,  	false,	"zip_cd", 		        false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,  "spcl_cd_seq",			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 120,	daLeft,  	false,	"spcl_cust_lgl_eng_nm", false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"rfa_no",				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"sc_no",				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"curr_cd",	 			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 100,	daRight,  	false,	"gen_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 100,	daRight,  	false,	"spcl_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 100,	daRight,  	false,	"dc_amt",	 			false,          "",      dfFloat,	 2,     false,       false);
	   			InitDataProperty(0, cnt++ , dtData,      	 100,	daRight,  	false,	"ttl_amt", 				false,          "",      dfFloat,	 2,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,     	 60,	daCenter,  	false,	"atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtData,      	 180,	daLeft,  	false,	"dc_rmk",				false,          "",      dfNone,     0,     false,       false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 180,	daLeft,  	false,	"xter_rmk",				false,          "",      dfNone,     0,     false,       false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 180,	daLeft,  	false,	"cust_ref_rmk",			false,          "",      dfNone,     0,     false,       false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"drp_off_chg_trf_seq",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"drp_off_chg_trf_spcl_seq",	false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"cust_cnt_cd",			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"cust_seq",				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"tmp_cust_cnt_cd",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"tmp_cust_seq",			false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,     	 30,	daCenter,  	false,	"tmp_cust_cd_seq",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 100,	daLeft,  	false,	"tmp_cust_lgl_eng_nm", 	false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,  "spcl_cust_cnt_cd",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,  "spcl_cust_seq",		false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"bl_no",				false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,        40,	daCenter,  	false,	"atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,        40,	daCenter,  	false,	"str_ttl_curr_cd",	 	false,          "",      dfNone,     0,     false,      false);
	   			InitDataProperty(0, cnt++ , dtHidden,        40,	daCenter,  	false,	"str_ttl_amt",	 	false,          "",      dfNone,     0,     false,      false);
	
	   			ShowButtonImage = 2;
	   	        InitDataValid(0, "cust_cd_seq", vtEngUpOther, "0123456789");
   	        }
			
       } else if (sheetNo == 2){
    	   with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false,false)
				
				var HeadTitle = "||Office|BKG No.|TRO Date|CNTR No.|TP/SZ|BKG DEL|RTN CY|RTN Date|Cust Code|Cust Name|Special Cust Code|Special Cust Name|RFA No.|S/C No.|CUR|General Tariff|Special Tariff|Discount|Final AMT|Remark|genTrfSeq|spclTrfSeq|c_cd|c_seq|s_cd|s_seq|inv_src_no|dod_drp_off_chg_seq";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,  "ibflag");
    	   }
        }
    }
   
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Col, Row) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //Retrieve
				/*
				if(!validateForm(sheetObj, formObj, sAction)) {
					return;	
				}
				*/
				
				// DOD Office Validate & Parameter Sending 
                var ofcCd = comboObjects[0].text;
                formObj.ofc_cd.value = ofcCd;
                if(ComIsEmpty(ofcCd)) {
                	ComShowCodeMessage('COM12113', "DOD Office");
         			return false;
                }
                
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("EES_DOD_0003GS.do", FormQueryString(formObj));
				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
			
		}
	}

	function sheet1_OnSearchEnd(sheetObj, errMsg) {

		for(var i = 1; i < sheetObj.Rows; i++){
			if(sheetObj.CellValue(i, "spcl_trf_amt") != "0"){
				sheetObj.CellValue2(i, "ttl_amt") = sheetObj.CellValue(i, "spcl_trf_amt");
			}else{
				sheetObj.CellValue2(i, "ttl_amt") = sheetObj.CellValue(i, "gen_trf_amt");
			}
		}
		
		var str_ttl_curr_n_amt = '';
		if (sheetObj.SearchRows > 0){
			str_ttl_curr_n_amt = "Total("+sheetObjects[0].CellValue(1,"str_ttl_curr_cd")+") : " + dod_chkAmtFmt(sheetObjects[0].CellValue(1,"str_ttl_amt"));
			ttl_usd_locl_amt.innerHTML = str_ttl_curr_n_amt; 
		} else {
			str_ttl_curr_n_amt = '';
		}
		ttl_usd_locl_amt.innerHTML = str_ttl_curr_n_amt;
	}
	
    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function sheet1_OnMouseMove(sheetObj, button, shift, x, y){
 		with(sheetObj){

 			if(ColSaveName(MouseCol) == "atch_file_lnk_cnt" || ColSaveName(MouseCol) == "cust_cd_seq") {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
 	
	/**
	 * Customer popup
	 */
	function goCustomer(){
		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustomer", "1,0,1,1,1,1,1", true);
	}
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 : Special Customer
  	 */
    function getCustomer(aryPopupData) {
    	document.form.s_cust_cd.value = aryPopupData[0][3];
    	document.form.s_cust_nm.value = aryPopupData[0][4];
    }
	
   
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 : INV Customer
  	 */
    function getINVCustomer(aryPopupData, Row) {
    	var custCdSeq = aryPopupData[0][3];
    	sheetObjects[0].CellValue2(Row, 'cust_cd_seq') = custCdSeq;
    	sheetObjects[0].CellValue2(Row, 'cust_lgl_eng_nm') = aryPopupData[0][4];
    	
//    	alert(custCdSeq.substr(0, 2) + " + " + custCdSeq.substr(2, custCdSeq.length));
    	sheetObjects[0].CellValue2(Row, 'cust_cnt_cd') = custCdSeq.substr(0, 2);
    	sheetObjects[0].CellValue2(Row, 'cust_seq') = custCdSeq.substr(2, custCdSeq.length);
    	
    	sheetObjects[0].CellValue2(Row, 'zip_cd') = aryPopupData[0][8];
    }
	/* 개발자 작업  끝 */