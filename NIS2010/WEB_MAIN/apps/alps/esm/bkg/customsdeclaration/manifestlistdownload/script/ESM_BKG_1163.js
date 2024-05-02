/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESM_BKG_1163.js
 *@FileTitle : Russia Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.15
 *@LastModifier : 신규정
 *@LastVersion : 1.0
 *2015.12.15 신규정
 *1.0 Creation
 * -------------------------------------------------------
 * History
 * 2013.10.14 김보배 [CHM-201326451] Russia/Manifest 기능 보완 요청

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
     * @extends 
     * @class ESM_BKG_1163  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

	function ESM_BKG_1163() {
		this.processButtonClick	= processButtonClick;
		this.setSheetObject		= setSheetObject;
		this.loadPage			= loadPage;
		this.initSheet			= initSheet;
		this.initControl		= initControl;
		this.doActionIBSheet	= doActionIBSheet;
		this.validateForm		= validateForm;
		this.sheet1_OnClick		= sheet1_OnClick;
		this.sheet1_OnKeyUp		= sheet1_OnKeyUp;
		this.setComboObject		= setComboObject;
	}
	
	/* 개발자 작업	*/
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
		
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var rowsPerPage = 50;
	
	var prefix = "";//IBSheet 구분자
	 
	// var grp_cd ="";//Current Queue 조회를 위한 전역변수  
	// var queueMap = new Array();
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
	var comboObjects = new Array();
	
	
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
 	}
	
	/*********************** EDTITABLE MULIT COMBO END********************/ 
 
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
		//MultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
	 	    
		for(i=0;i<rdObjects.length;i++){
			initRdConfig(rdObjects[i],i+1);
		}
		
		// 화면에서 필요한 이벤트
    	axon_event.addListenerForm ('change', 'obj_change',  document.form); 
    	axon_event.addListenerForm("click", "obj_click", document.form);
	 	    
		initControl();
		initRdConfig(rdObjects[0]);
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboId) {
		var formObject = document.form
		initComboEditable(comboObj, comboId)
	}
	 	
	//콤보 멀티 셀렉트 및 수정 여부 초기 설정
	function initComboEditable(combo, comboId){
		with (combo) {
			if(comboId == "order_by" ){
				//alert(comboId);
				MultiSelect = true;
				UseAutoComplete = true; 
				UseEdit = false;	 
				DropHeight = 150;
			}else{
				DropHeight = 150;
				MultiSelect = false;
				UseEdit = false;	 	 			
			}
		}
	}
    
	function initControl() {
		var formObject = document.form;

		axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
//        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
//        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}     
    
    
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);

		Rdviewer.style.height = 0;
	}

    
    

/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
		switch(event.srcElement.dataformat){
			case "ymd":
		        //number
		        ComKeyOnlyNumber(event.srcElement, "-");
		        break;
	    	
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet('upper');
				break;
			
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum');
				break;
				
			case "num":
				//숫자 입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "custname":
				//숫자 입력하기
				ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
				break;	            

			default:
		}
	}


/*********************** KEY EVENT END ********************/

  
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick  = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var comboObject1 = comboObjects[0]; 
		var rdObject = rdObjects[0];

		/*******************************************************/
		var formObject = document.form;

		try {
			
			var srcName = window.event.srcElement.getAttribute("name");
	     		
			switch(srcName) {
				case "btn_Retrieve":
					//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html"); 
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,MULTI01);
					break;
				
				case "btn_New":
					initAll(formObject);
					break;		 			
					
				
				case "btn_Transmit":		
					doActionIBSheet(sheetObject1,formObject,MULTI02);
				break;
				
				case "btn_Print2":
					rdOpen2();
	 				break;	 					

				
				case "btn_CargoDown":
					
					rdOpen2(sheetObject1);
					return;

 					break;
					
					
				break;
				
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_Print":
					
					var selArr = getCheckedRowsByName(sheetObject1,"check","bkg_no");
					var bkg_nos = "";
					
					if(selArr == null){
						ComShowCodeMessage("COM12189");
						return;
					}

					for(var i=0;i < selArr.length;i++){
						bkg_nos += selArr[i]+"@";
					}
					
					var form3 = document.form3;
					form3.bkg_no   .value = bkg_nos;
					form3.mode_type.value = getRadioValue2(formObject.mode_type);
					form3.vvd_cd   .value = formObject.vvd_cd.value;
					form3.pol_cd   .value = formObject.pol_cd.value;
					form3.pol_yd_cd.value = formObject.pol_yd_cd.value;
					form3.pod_cd   .value = formObject.pod_cd.value;
					form3.pod_yd_cd.value = formObject.pod_yd_cd.value;

					rdOpen(rdObject);
					break;

				case "btn_check_all":
					CellCheckAll(sheetObject1,true,"check");
					checkBlock(sheetObject1);
					break;
							
				case "btn_uncheck_all":
					CellCheckAll(sheetObject1,false,"check");
					break;    
        		
				case "mode_type":
					if(form.mode_type[0].checked){
						form.pol_cd.className = "input1";
//						form.pol_yd_cd.className = "input1";
						form.pod_cd.className = "input";
						form.pod_yd_cd.className = "input";
					}else if(form.mode_type[1].checked){
						form.pol_cd.className = "input";
//						form.pol_yd_cd.className = "input";
						form.pod_cd.className = "input1";
						form.pod_yd_cd.className = "input1";
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
	
	
	function rdOpen(rdObject){
		
		var formObj = document.form;
		var rdPath  = "";
		var rdParam = "/rv ";
		
		rdParam += "vvd_cd[" + form3.vvd_cd.value  + "] "; 
		rdParam += "mode_type[" + form3.mode_type.value + "] ";
		
		if(form3.mode_type.value == "I"){
			rdParam += "pol_pod_cd[" + form3.pod_cd.value + "] pol_pod_yd_cd[" + form3.pod_yd_cd.value + "] pol_cd[" + form3.pol_cd.value + "] pod_cd[" + form3.pod_cd.value + "] "; 
		}else{
			rdParam += "pol_pod_cd[" + form3.pol_cd.value + "] pol_pod_yd_cd[" + form3.pol_yd_cd.value + "] pol_cd[" + form3.pol_cd.value + "] pod_cd[" + form3.pod_cd.value + "] ";
		}
		
		var arrBkgNo = form3.bkg_no.value; //.split('|');
		
		if(arrBkgNo ==""){
			ComShowCodeMessage("BKG95009");
			return; 
		}
		
		for(var index=0; index<arrBkgNo.length; index++) {
			bkgNoPolPod = arrBkgNo.split('@');
		}
		
		rdParam += "bkg_nos[" + bkgNoPolPod + "] "; // form_type
		//alert(rdParam);
//		alert("rdParam >>>> " + rdParam);
		rdPath = "apps/alps/esm/bkg/customsdeclaration/manifestlistdownload/report/ESM_BKG_1163.mrd";
		
		formObj.com_mrdPath.value = rdPath;
		formObj.com_mrdArguments.value 	= rdParam + " /riprnmargin /rwait";

 		formObj.com_mrdTitle.value = "Russia Customs Manifest";
 		formObj.com_mrdDisableToolbar.value = "";
		formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>Russia Customs Manifest</span>";

		ComOpenRDPopup();
	}
	
	
	function initAll(formObj){
		formObj.reset();
		formObj.mode_type[0].checked;
		formObj.pol_cd.className = "input1";
//		formObj.pol_yd_cd.className = "input1";
		formObj.pod_cd.className = "input";
		formObj.pod_yd_cd.className = "input";
	} 


	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //조회
				if(form.order_by.value == ""){
					form.order_by.value = "POD_CD";
				}	
				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html"); 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
				
				sheetObj.RemoveAll();
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1163_1GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.WaitImageVisible = false;	
				sheetObj.Redraw = true;
							
				//alert(ComGetEtcData(sXml, "total_40t"));
				if(ComGetEtcData(sXml, "hd_vvd_cd") == undefined){
					if(form.mode_type[0].checked){
						form.hd_vvd_cd.value	   = form.vvd_cd.value;
						hd_pol_pod.innerHTML     = "POL";
						form.hd_pol_pod_cd.value = form.pol_cd.value;
						hd_eta_etd.innerHTML     = "ETD";
						form.hd_eta_etd_cd.value = "";
						form.hd_mode_type.value	 = "Outbound";									
					}else{
						form.hd_vvd_cd.value	   = form.vvd_cd.value;
						hd_pol_pod.innerHTML     = "POD";
						form.hd_pol_pod_cd.value = form.pod_cd.value;
						hd_eta_etd.innerHTML     = "ETA";
						form.hd_eta_etd_cd.value = "";
						form.hd_mode_type.value	 = "Inbound";
					}
					break;
				}
				
				form.hd_vvd_cd.value	   = ComGetEtcData(sXml, "hd_vvd_cd");
				hd_pol_pod.innerHTML     = ComGetEtcData(sXml, "hd_pol_pod");
				form.hd_pol_pod_cd.value = ComGetEtcData(sXml, "hd_pol_pod_cd");
				hd_eta_etd.innerHTML= ComGetEtcData(sXml, "hd_eta_etd");
				form.hd_eta_etd_cd.value = ComGetEtcData(sXml, "hd_eta_etd_cd");
				form.hd_mode_type.value	 = ComGetEtcData(sXml, "hd_mode_type");
				break;
				
				
			case MULTI01: // SAVE
				
				if (!validateForm(sheetObj, formObj, sAction))	return;
				
				formObj.f_cmd.value = MULTI01;

		        if(!ComShowCodeConfirm("BKG00498", "changed CNTR WGT")) {
		        	return false;
		        }
				var sParam = sheetObjects[0].GetSaveString();
//				alert("sParam : " + sParam);
				sParam += "&" + FormQueryString(formObj);  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1163GS.do", sParam);
				
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
				break;
				
				
			case IBDOWNEXCEL:   // 엑셀다운로드
				sheetObj.Down2Excel();
				break;		
					
				
			case MULTI02:	//Transmit Manifest
				//if (!validateForm(sheetObj, formObj, sAction))	return false; // 2014.06.11 Add. Hannah Lee
				
				formObj.f_cmd.value = MULTI02;
//				if(formObj.trans_mode.value == 'O' && formObj.eta_flg.value == '-1'){
//					ComShowCodeMessage('BKG06006');
//				}
//				if(formObj.trans_mode.value == 'O' && formObj.etd_flg.value == '-1'){
//					ComShowCodeMessage('BKG06007');
//				}
//				if(formObj.trans_mode.value == 'D' && formObj.eta_flg.value == '-1'){
//					ComShowCodeMessage('BKG06008');
//				}
				//ComOpenWait(true,true); 
				var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1163GS.do", sParam);
				
				// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림 3초마다
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

			break;	

			case MULTI04:	//btn_CargoDown
				
				var sheetObject2 = sheetObjects[1];
				
				if (sheetObject2.RowCount > 0) {
					sheetObject2.RemoveAll() 
				} 
				sheetObject2.DataInsert(1);
				
				formObj.f_cmd.value = MULTI04;
				
				ComOpenWait(true);
				var vvd = formObj.vvd_cd.value;
				var pol = formObj.pol_cd.value;
				var pod = formObj.pod_cd.value;			
				var savedFileName = vvd +"_"+ pol;	
				if ( formObj.mode_type[1].checked ) savedFileName  = vvd +"_"+ pod ;
				
				var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1163GS.do", sParam);

				var flatFile = ComGetEtcData(sXml, "cargo_down");
 				sheetObject2.CellText(1, "flat_file") = flatFile;
 				ComOpenWait(false);
  				
				sheetObject2.Down2Text("", "", "", savedFileName, "c:\\flatFile\\", "", false, false, true);
				
			break;	
				
				
				
				
		}
	}
	
	
	/**
	 * 저장을 BackEndJob으로 하기 때문에 저장버튼 클릭 후 완료되었는지 확인하는 로직
	 * @param sheetObj 시트오브젝트
	 * @param sKey BackEndJob Key
	 */
	
	function doActionValidationResult(sheetObj, sKey) {

		var sXml = sheetObj.GetSearchXml("ESM_BKG_1163GS.do?f_cmd=" + MULTI03 + "&key=" + sKey);
		var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
		// 에러가 발생했을 경우 대기사항을 종료한다.

		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// 성공메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
			// sheet1 다시 조회
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
			return;
		} else if (sJbStsFlg == "FAIL") {
			//에러
			clearInterval(intervalId);
			ComOpenWait(false);
			// 에러메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
		}
	}

	
	
	
	
	/*
	 *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
	 * 초기값은 쉬트 헤더 개수
	 */ 
	var pagedMaxCnt=2; 
	
	
	
	function checkBlock(sheetObj){

		var preBkg = "";
		var nextBkg = "";

		for(var i = sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			if(i < 1) continue;//header 부분

			preBkg = sheetObj.CellValue(i, "bl_no");
			nextBkg = sheetObj.CellValue(i+1, "bl_no");
			
			if(preBkg == nextBkg){
				sheetObj.CellEditable(i+1, "check") = false;
				sheetObj.CellBackColor(i+1, "check") = sheetObj.RgbColor(232, 231, 236); // gray color
				sheetObj.CellValue(i+1, "check") = 0;
			}
		}
	}
	
	
	/**
	 * 조회후  이벤트 처리
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		checkBlock(sheetObj);
	}

	/*
	 *  Search Option or Item Option Modify
	 * */
	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	}
	
	/**
	 * 시트의 값 변경 시 발생하는 이벤트
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj = document.form;
		
		if (sheetObj.ColSaveName(Col) == "wgt1" || sheetObj.ColSaveName(Col) == "tare_wgt") {
			
			// Cargo wgt 의 값이 null 인 경우 0 으로 초기화
			if( sheetObj.CellValue(Row, "wgt1") == null || sheetObj.CellValue(Row, "wgt1") == '' ){
				sheetObj.CellValue(Row, "wgt1") = "0";
			}
			
			// Tare wgt 의 값이 null 인 경우 0 으로 초기화
			if( sheetObj.CellValue(Row, "tare_wgt") == null || sheetObj.CellValue(Row, "tare_wgt") == '' ){
				sheetObj.CellValue(Row, "tare_wgt") = "0";
			}
			
			sheetObj.CellValue(Row, "total_wgt") = parseFloat(sheetObj.CellValue(Row, "wgt1")) + parseFloat(sheetObj.CellValue(Row, "tare_wgt"));

		}
	}
	
	
	/**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function obj_change() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (srcName == "pol_cd") {
    		set_pod();
    	}
    }
    
    /**
	 * Click 이벤트 Catch
	 */
	function obj_click() {
		var formObj = document.form;
		var srcObj = window.event.srcElement;
		var srcName = srcObj.getAttribute("name");
		var srcVal = srcObj.checked;
		if (srcName == "mode_type") {
			set_pod();
		}
	}
	
	/*
	 * Outbound 이고 POL 이 RULED 인 경우
	 * POD 를 DEHAM 으로 자동 셋팅
	 */
	function set_pod() {
		var formObj = document.form;
		if(formObj.mode_type[0].checked && formObj.pol_cd.value == "RULED"){
//			alert("Please input POD Yard");
			formObj.pod_cd.value = "DEHAM";
		}
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if ( ComIsNull(formObj.vvd_cd)) {
					ComShowCodeMessage('BKG00626','VVD');
					formObj.vvd_cd.focus();
					return false;	
				}else if ( formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
					ComShowCodeMessage('BKG00626','POL');
					formObj.pol_cd.focus();
					return false;
//				}else if ( formObj.mode_type[0].checked && ComIsNull(formObj.pol_yd_cd)) {
//					ComShowCodeMessage('BKG00626','POL Yard');
//					formObj.pol_yd_cd.focus();
//					return false;
				}else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
					ComShowCodeMessage('BKG00626','POD');
					formObj.pod_cd.focus();
					return false;
				}else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_yd_cd)) {
					ComShowCodeMessage('BKG00626','POD Yard');
					formObj.pod_yd_cd.focus();
					return false;
				}
				
				return true;
				break;
				
				
			 case MULTI02: //When Transmit button is clicked

			    	var sheetObject1 = sheetObjects[0];
			    	
			    	// header lines = 2
			    	for( var i = 2; i <= sheetObject1.RowCount+1; i++ ) {
			    		
			    		if ( sheetObject1.CellValue(i, "Chk") == "1" &&  sheetObject1.CellValue(i, "bkg_cgo_tp_cd") == "F"  ) // when the row checked
						{
							//when CNTR_CNT is zero
							if(sheetObject1.CellValue(i, "cntr_cnt") == 0 ){
								ComShowCodeMessage("BKG06155", sheetObject1.CellValue(i, "bl_no"));
								return false;
							}
							
							// when the column value is N
							for( var j=8; j<= 20; j++){
								
								if(sheetObject1.CellValue(i,j)== "N") {
									ComShowCodeMessage("BKG06155", sheetObject1.CellValue(i, "bl_no"));
									return false;
								}
							}
							
							for( var j=24; j<= 26; j++){
								
								if(sheetObject1.CellValue(i,j)== "N") {
									ComShowCodeMessage("BKG06155", sheetObject1.CellValue(i, "bl_no"));
									return false;
								}
							}
							

							for( var j=29; j<= 31; j++){
								
								if(sheetObject1.CellValue(i,j)== "N") {
									ComShowCodeMessage("BKG06155",   sheetObject1.CellValue(i, "bl_no"));
									return false;
								}
							}
						}// end if
						
					}//end for
			    	
			    	return true;
			    	break;
			
				
		}
		
	}
    
	function isNullEtcData(xmlStr){
		var rtn = false;
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if(xmlRoot == null) return true;

		var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if(etcDataNode == null) return true;

		var etcNodes = etcDataNode.childNodes;
		if(etcNodes == null) return true;
		if(etcNodes.length == 0) rtn = true;
		
		return rtn;
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id) {
		
			case "sheet1":
				with (sheetObj) {
				// 높이 설정
				style.height = 370; //326;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet =  msHeaderOnly + msPrevColumnMerge ;
				MergeSheet =  msAll;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, rowsPerPage);

				var HeadTitle1 = "|Seq.|BKG No.|B/L No.|GROUP_POL_POD|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Shipper|Consignee|CNTR No.|SEAL No.|PKG|PKG|CARGO WGT|CARGO WGT|TARE WGT|TARE WGT|TOTAL WGT|TOTAL WGT|Notify Country|Notify Name|Notify Addr|Cntr Pacakge|Cntr Weight|Cntr Seq|Cargo Package|Cargo Weight|Cargo DESC|BL Commodity|BL Commodity Name|";
                
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, false);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW,	COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//				InitDataProperty(0, cnt++,  dtCheckBox, 40, 	daCenter,   true,   "sel",      	false,  "",  	dfNone,  	0,  	true,   	false);
				InitDataProperty(0,	cnt++ , dtCheckBox,	20,		daCenter,	false,	"check",		false,	"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"seq",			false,	"",		dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	false,	"bkg_no",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	"bl_no",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	false,	"group_pol_pod",false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"por_cd",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"pol_cd",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"pol_yd_cd",	false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"pod_cd",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"pod_yd_cd",	false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"del_cd",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"del_yd_cd",	false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"rd_cd1",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"rd_cd2",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		210,	daLeft,		false,	"sh_nm",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		210,	daLeft,		false,	"cnee_nm",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cntr_no",		false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"cntr_seal_no",	false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"pkg1",			false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"pkg2",			false,	"",		dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"wgt1",			false,	"",		dfNone,		3,		true,		true); //dfFloat,		3,		true,		true);
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"wgt2",			false,	"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"tare_wgt",		false,	"",		dfNone,		3,		true,		true);
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"wgt2",			false,	"",		dfNone,		0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"total_wgt",	false,	"",		dfNone,		3,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"nf_cust_cnt",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"nf_cust_nm",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"nf_cust_addr",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cntr_pck",		false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cntr_wgt",		false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cntr_mf_seq",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cargo_pck",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cargo_wgt",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cargo_desc",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"bl_cmdt_cd",	false,	"",		dfNone,		3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"bl_cmdt_nm",	false,	"",		dfNone,		3,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"wgt2",			false,	"",		dfNone,		0,		false,		false);

				InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,	false,	"ibflag", false,	"",		dfNone,		0,		false,		false);
				CountPosition = 0;
				InitDataValid(0, "wgt1", vtNumericOther, ".");
				InitDataValid(0, "tare_wgt", vtNumericOther, ".");
				InitDataValid(0, "total_wgt", vtNumericOther, ".");
				}
				break;
				
			case "sheet2":  //
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "flatFile";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,			"flat_file",	false,			"",      dfNone,	0,		false,		false);
					
					CellSpeedOption="NOFORMAT";
				}
             break;
		}
	}
    
	
	/**
	 * Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function sheet1_OnSearchEnd(sheetObj, formObj, ErrMsg) {
		var formObject = document.form;
		
		if(document.form.pod_cd.value == "RUVVO"){
			
			sheetObjects[0].ColHidden("nf_cust_cnt") = 	false;
			sheetObjects[0].ColHidden("nf_cust_nm") = 	false;
			sheetObjects[0].ColHidden("nf_cust_addr") = false;
			sheetObjects[0].ColHidden("cntr_pck") = 	false;
			sheetObjects[0].ColHidden("cntr_wgt") = 	false;
			sheetObjects[0].ColHidden("cntr_mf_seq") = 	false;
			sheetObjects[0].ColHidden("cargo_pck") = 	false;
			sheetObjects[0].ColHidden("cargo_wgt") = 	false;
			sheetObjects[0].ColHidden("cargo_desc") = 	false;
			sheetObjects[0].ColHidden("bl_cmdt_cd") = 	false;
			sheetObjects[0].ColHidden("bl_cmdt_nm") = 	false;
			
//			formObj.btn_Transmit.disabled=false;
			ComBtnEnable("btn_Transmit");
			ComBtnEnable("btn_CargoDown");
						 
		}else{
			sheetObjects[0].ColHidden("nf_cust_cnt") = 	true;
			sheetObjects[0].ColHidden("nf_cust_nm") = 	true;
			sheetObjects[0].ColHidden("nf_cust_addr") = true;
			sheetObjects[0].ColHidden("cntr_pck") = 	true;
			sheetObjects[0].ColHidden("cntr_wgt") = 	true;
			sheetObjects[0].ColHidden("cntr_mf_seq") = 	true;
			sheetObjects[0].ColHidden("cargo_pck") = 	true;
			sheetObjects[0].ColHidden("cargo_wgt") = 	true;
			sheetObjects[0].ColHidden("cargo_desc") = 	true;
			sheetObjects[0].ColHidden("bl_cmdt_cd") = 	true;
			sheetObjects[0].ColHidden("bl_cmdt_nm") = 	true;
			
//			formObj.btn_Transmit.disabled=true;
			
			ComBtnDisable("btn_Transmit");
			ComBtnDisable("btn_CargoDown"); 
			
			// FR이 기존에 선택시 Receiver ID를 다시 조회해 오기 위해서
			//doActionIBSheet(sheetObjects[0], formObject, SEARCH09);
		}
	}
	
	
	  function rdOpen2(sheetObject)	{		

		  	var formObj = document.form;
			var bkg_nos = "";		  	
			var bkg_no = getCheckedRowsByName(sheetObject,"check","bkg_no");

			if(bkg_no == null){
					ComShowCodeMessage("COM12189");
					return;
			}

			var rdPath  = "";		  	
		    rdParam = "/rv mode_type[" + getRadioValue2(formObj.mode_type) + "] print_form[] "  ; // bkg_no		    
			rdParam += "vvd_cd[" + formObj.vvd_cd.value  + "] "; 
			
			if(form.mode_type[1].checked){
				rdParam += "pol_pod_cd[" + formObj.pod_cd.value + "] "; 
				rdParam += "pol_yd_cd[] "; 
				rdParam += "pod_yd_cd[" + formObj.pod_yd_cd.value + "] "; 
			}else{
				rdParam += "pol_pod_cd[" + formObj.pol_cd.value + "] "; 
				rdParam += "pol_yd_cd[" + formObj.pol_yd_cd.value + "] "; 
				rdParam += "pod_yd_cd[] "; 
			}
			
			rdParam += " bkg_nos[" + bkg_no + "] "; // form_type				
			rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_8888.mrd";				
	 	//alert(rdParam);
			formObj.com_mrdPath.value 		= rdPath;
	 		formObj.com_mrdArguments.value 	= rdParam + " /riprnmargin /rwait";
	 		formObj.com_mrdTitle.value = "Cargo Manifest";
	 		formObj.com_mrdDisableToolbar.value = "";
			formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>Cargo Manifest</span>";
				
	
			ComOpenRDPopup();
	  }
	

	/* 개발자 작업  끝 */    