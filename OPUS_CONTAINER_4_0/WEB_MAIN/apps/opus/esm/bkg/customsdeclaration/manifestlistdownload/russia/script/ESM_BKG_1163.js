/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1163.js
*@FileTitle  : Russia Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
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
//	function ESM_BKG_1163() {
//		this.processButtonClick=processButtonClick;
//		this.setSheetObject=setSheetObject;
//		this.loadPage=loadPage;
//		this.initSheet=initSheet;
//		this.initControl=initControl;
//		this.doActionIBSheet=doActionIBSheet;
//		this.validateForm=validateForm;
//		this.sheet1_OnClick=sheet1_OnClick;
//		this.sheet1_OnKeyUp=sheet1_OnKeyUp;
//		this.setComboObject=setComboObject;
//	}
	/* 개발자 작업	*/
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var rowsPerPage=50;
	var prefix="";//IBSheet 구분자
	// var grp_cd ="";//Current Queue 조회를 위한 전역변수  
	// var queueMap = new Array();
	var rdObjects=new Array();
	var rdCnt=0;
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
//    	axon_event.addListenerForm ('change', 'obj_change',  document.form); 
//    	axon_event.addListenerForm("click", "obj_click", document.form);
		initControl();
		initRdConfig(rdObjects[0]);
	}
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboId) {
		var formObject=document.form
		initComboEditable(comboObj, comboId)
	}
	//콤보 멀티 셀렉트 및 수정 여부 초기 설정
	function initComboEditable(combo, comboId){
		with (combo.options.id) {
			if(comboId == "order_by" ){
				//alert(comboId);
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetUseEdit(0);
				SetDropHeight(150);
			}else{
				SetDropHeight(150);
				SetMultiSelect(0);
				SetUseEdit(0);
			}
		}
	}
	function initControl() {
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
//        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
//        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
//		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}     
	function initRdConfig(rdObject){
		var Rdviewer=rdObject ;
		Rdviewer.AutoAdjust=true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetBackgroundColor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.style.height = 0;
		//Rdviewer.SetSheetHeight(0);
		// Rdviewer.hidden="true";
		 Rdviewer.ApplyLicense("0.0.0.0"); 
	}
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
		switch(event.srcElement.dataformat){
			case "ymd":
		        //number
		        ComKeyOnlyNumber(ComGetEvent(), "-");
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
				ComKeyOnlyNumber(ComGetEvent());
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
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		var comboObject1=comboObjects[0]; 
		var rdObject=rdObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
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
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "btn_Print":
//					var selArr=getCheckedRowsByName(sheet1,"check","bkg_no");
					 var selArr=sheet1.FindCheckedRow("check");
					var bkg_nos="";
					if(selArr == null||selArr==""){
						ComShowCodeMessage("COM12189");
						return;
					}
					for(var i=0;i < selArr.length;i++){
						bkg_nos += selArr[i]+"@";
					}
					var form3=document.form3;
					form3.bkg_no   .value=bkg_nos;
					form3.mode_type.value=getRadioValue2(formObject.mode_type);
					form3.vvd_cd   .value=formObject.vvd_cd.value;
					form3.pol_cd   .value=formObject.pol_cd.value;
					form3.pol_yd_cd.value=formObject.pol_yd_cd.value;
					form3.pod_cd   .value=formObject.pod_cd.value;
					form3.pod_yd_cd.value=formObject.pod_yd_cd.value;
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
						form.pol_cd.className="input1";
//						form.pol_yd_cd.className = "input1";
						form.pod_cd.className="input";
						form.pod_yd_cd.className="input";
					}else if(form.mode_type[1].checked){
						form.pol_cd.className="input";
//						form.pol_yd_cd.className = "input";
						form.pod_cd.className="input1";
						form.pod_yd_cd.className="input1";
					} 
					break; 		
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}		     	
		}
	}
	function rdOpen(rdObject){
		var formObj=document.form;
		var rdPath="";
		var rdParam="/rv ";
		rdParam += "vvd_cd[" + form3.vvd_cd.value  + "] "; 
		rdParam += "mode_type[" + form3.mode_type.value + "] ";
		if(form3.mode_type.value == "I"){
			rdParam += "pol_pod_cd[" + form3.pod_cd.value + "] pol_pod_yd_cd[" + form3.pod_yd_cd.value + "] pol_cd[" + form3.pol_cd.value + "] pod_cd[" + form3.pod_cd.value + "] "; 
		}else{
			rdParam += "pol_pod_cd[" + form3.pol_cd.value + "] pol_pod_yd_cd[" + form3.pol_yd_cd.value + "] pol_cd[" + form3.pol_cd.value + "] pod_cd[" + form3.pod_cd.value + "] ";
		}
		var arrBkgNo=form3.bkg_no.value; //.split('|');
		if(arrBkgNo ==""){
			ComShowCodeMessage("BKG95009");
			return; 
		}
		for(var index=0; index<arrBkgNo.length; index++) {
			bkgNoPolPod=arrBkgNo.split('@');
		}
		rdParam += "bkg_nos[" + bkgNoPolPod + "] "; // form_type
//		alert("rdParam >>>> " + rdParam);
		rdPath="apps/alps/esm/bkg/customsdeclaration/manifestlistdownload/report/ESM_BKG_1163.mrd";
		formObj.com_mrdPath.value=rdPath;
		formObj.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
 		formObj.com_mrdTitle.value="Russia Customs Manifest";
 		formObj.com_mrdDisableToolbar.value="";
		formObj.com_mrdBodyTitle.value="<span style=&quot;color:red&quot;>Russia Customs Manifest</span>";
		ComOpenRDPopup();
	}
	function initAll(formObj){
		formObj.reset();
		formObj.mode_type[0].checked;
		formObj.pol_cd.className="input1";
//		formObj.pol_yd_cd.className = "input1";
		formObj.pod_cd.className="input";
		formObj.pod_yd_cd.className="input";
	} 
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //조회
				if(form.order_by.value == ""){
					form.order_by.value="POD_CD";
				}	
				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html"); 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				var sXml=sheetObj.GetSearchData("ESM_BKG_1163_1GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.SetWaitImageVisible(0);
				sheetObj.RenderSheet(1);
				//alert(ComGetEtcData(sXml, "total_40t"));
				if(ComGetEtcData(sXml, "hd_vvd_cd") == undefined){
					if(form.mode_type[0].checked){
						form.hd_vvd_cd.value=form.vvd_cd.value;
						hd_pol_pod.innerHTML="POL";
						form.hd_pol_pod_cd.value=form.pol_cd.value;
						hd_eta_etd.innerHTML="ETD";
						form.hd_eta_etd_cd.value="";
						form.hd_mode_type.value="Outbound";									
					}else{
						form.hd_vvd_cd.value=form.vvd_cd.value;
						hd_pol_pod.innerHTML="POD";
						form.hd_pol_pod_cd.value=form.pod_cd.value;
						hd_eta_etd.innerHTML="ETA";
						form.hd_eta_etd_cd.value="";
						form.hd_mode_type.value="Inbound";
					}
					break;
				}
				form.hd_vvd_cd.value=ComGetEtcData(sXml, "hd_vvd_cd");
				hd_pol_pod.innerHTML=ComGetEtcData(sXml, "hd_pol_pod");
				form.hd_pol_pod_cd.value=ComGetEtcData(sXml, "hd_pol_pod_cd");
				hd_eta_etd.innerHTML=ComGetEtcData(sXml, "hd_eta_etd");
				form.hd_eta_etd_cd.value=ComGetEtcData(sXml, "hd_eta_etd_cd");
				form.hd_mode_type.value=ComGetEtcData(sXml, "hd_mode_type");
				break;
			case MULTI01: // SAVE
				if (!validateForm(sheetObj, formObj, sAction))	return;
				formObj.f_cmd.value=MULTI01;
		        if(!ComShowCodeConfirm("BKG00498", "changed CNTR WGT")) {
		        	return false;
		        }
				var sParam=sheetObjects[0].GetSaveString();
//				alert("sParam : " + sParam);
				sParam += "&" + FormQueryString(formObj);  
				var sXml=sheetObj.GetSaveData("ESM_BKG_1163GS.do", sParam);
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
				break;
			case IBDOWNEXCEL:   // 엑셀다운로드
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel();
				}
				break;			
		}
	}
	/*
	 *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
	 * 초기값은 쉬트 헤더 개수
	 */ 
	var pagedMaxCnt=2; 
	function checkBlock(sheetObj){
		var preBkg="";
		var nextBkg="";
		for(var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++) {
			if(i < 1) continue;//header 부분
			preBkg=sheetObj.GetCellValue(i, "bl_no");
			nextBkg=sheetObj.GetCellValue(i+1, "bl_no");
			if(preBkg == nextBkg){
				sheetObj.SetCellEditable(i+1, "check",0);
				sheetObj.SetCellBackColor(i+1, "check","#E8E7EC");// gray color
				sheetObj.SetCellValue(i+1, "check",0);
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
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "wgt1" || sheetObj.ColSaveName(Col) == "tare_wgt") {
			// Cargo wgt 의 값이 null 인 경우 0 으로 초기화
			if( sheetObj.GetCellValue(Row, "wgt1") == null || sheetObj.GetCellValue(Row, "wgt1") == '' ){
				sheetObj.SetCellValue(Row, "wgt1","0");
			}
			// Tare wgt 의 값이 null 인 경우 0 으로 초기화
			if( sheetObj.GetCellValue(Row, "tare_wgt") == null || sheetObj.GetCellValue(Row, "tare_wgt") == '' ){
				sheetObj.SetCellValue(Row, "tare_wgt","0");
			}
			sheetObj.SetCellValue(Row, "total_wgt",parseFloat(sheetObj.GetCellValue(Row, "wgt1")) + parseFloat(sheetObj.GetCellValue(Row, "tare_wgt")));
		}
	}
	/**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function obj_change() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if (srcName == "pol_cd") {
    		set_pod();
    	}
    }
    /**
	 * Click 이벤트 Catch
	 */
	function obj_click() {
		var formObj=document.form;
		var srcObj=window.event.srcElement;
		var srcName=srcObj.getAttribute("name");
		var srcVal=srcObj.checked;
		if (srcName == "mode_type") {
			set_pod();
		}
	}
	/*
	 * Outbound 이고 POL 이 RULED 인 경우
	 * POD 를 DEHAM 으로 자동 셋팅
	 */
	function set_pod() {
		var formObj=document.form;
		if(formObj.mode_type[0].checked && formObj.pol_cd.value == "RULED"){
//			alert("Please input POD Yard");
			formObj.pod_cd.value="DEHAM";
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
				break;
		}
		return true;
	}
	function isNullEtcData(xmlStr){
		var rtn=false;
//		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
//		xmlDoc.loadXML(xmlStr);
//		var xmlRoot=xmlDoc.documentElement;
//		if(xmlRoot == null) return true;
		
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
		var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if(etcDataNode == null) return true;
		var etcNodes=etcDataNode.childNodes;
		if(etcNodes == null) return true;
		if(etcNodes.length == 0) rtn=true;
		return rtn;
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
		       
			        var HeadTitle1="|||BKG No.|B/L No.|GROUP_POL_POD|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Shipper|Consignee|CNTR No.|SEAL No.|PKG|PKG|CARGO WGT|CARGO WGT|TARE WGT|TARE WGT|TOTAL WGT|TOTAL WGT|";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	//		        (headCount, 0, 0, false);
			        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"group_pol_pod",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"del_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rd_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rd_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:"sh_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:"cnee_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkg1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pkg2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wgt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tare_wgt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"total_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
			        SetEditable(1);
			        SetSheetHeight(370);//326;
			        SetCountPosition(0);
			        
				}
				break;
		}
	}
	/* 개발자 작업  끝 */    
