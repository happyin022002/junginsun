/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0247.js
*@FileTitle : SHA Loadable weight 계산/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.07.01 Jung Jinwoo
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
	 * @class vop_vsk_0247 : vop_vsk_0247 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0247() {
		this.processButtonClick		= tprocessButtonClick;
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var glbPortCds = new Array();
	var glbVslCds = new Array();
	var glbSkdVoyNos = new Array();
	var glbSkdDirCds = new Array();
	var glbClptIndSeqs = new Array();
	
	var glbInitHeaderTitle = "||||||";
	
	var arrTitle = "Calculation Cargo Weight for the ARR. Draft";
	var depTitle = "Calculation Cargo Weight for the DEP. Draft";


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
		var sheetObject = sheetObjects[0];   //t1sheet1
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_calculaton":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
							
				case "btn_close":
					window.close();
					break;
							
				case "rdo_tran":
					doActionIBSheet(sheetObject, formObject, COMMAND02);
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
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(){
		var formObj = document.form;
		
		for(i=0; i<sheetObjects.length; i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		document.all.item("titleLayer").innerHTML = arrTitle;
		
		initControl();
		
		initCallBaseData(formObj);
		
		//화면 OPEN 시 ARRIVAL 이므로 post_type = "ARRIVAL" 로 셋팅.
		formObj.post_type.value = "ARRIVAL";
	}
	

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 1, false);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, false, false, false)

                    var HeadTitle = glbInitHeaderTitle;
                    var LeftHeadTitle = "BSA|Loadable Cargo Weight|Loaded Cargo Weight|Actual Loadable Weight"

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //좌측 해더가 있는 경우 좌측 해더에 표시할 값 및 정렬을 설정한다.
                    InitHeadColumn(0, LeftHeadTitle);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,    		150,   daCenter,  true,    prefix+"left_header",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col01",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col02",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col03",     		false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col04",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col05",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		85,    daRight,  true,    prefix+"col06",     	false,          "",      dfNone,				0,			true,		true);
                    
                    CountPosition = "0";
                }
                
                break;
		}
    }
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {
	    	case "wgt_port_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("center|left|left");
  					SetColWidth("24|50|40");
  					DropHeight = 160;
   		    	}
   	    		break;
   	     }
   	}

	/**
	 * Sheet관련 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetID = sheetObj.id;
		
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)){
					if (sheetID == "sheet1"){
						formObj.f_cmd.value = SEARCH;
						
						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
						var sXml = sheetObj.GetSearchXml("VOP_VSK_0247GS.do", sParam);
						
						showSheetData(sheetObj, formObj, sXml);
					}
				}

				break;

			case SEARCH01:        //Open(Call Indicator 조회).
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH01;
					
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0247GS.do", sParam);
					
					return sXml;
				}

				break;

			case COMMAND02:        //[ARRIVAL / DEPARTURE] Radio Button
				clearAllData(sheetObj, formObj);
				
				if(formObj.rdo_tran[0].checked){
					formObj.post_type.value = "ARRIVAL";
					document.all.item("titleLayer").innerHTML = arrTitle;
				}else{
					formObj.post_type.value = "DEPARTURE";
					document.all.item("titleLayer").innerHTML = depTitle;
				}

				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//	        if (!isNumber(formObj.iPage)) {
//	            return false;
//	        }
		}

		return true;
	}
	
	/**
     * 조회 후 처리로직.
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){
		var vslClass = ComGetEtcData(sXml, "vsl_class");
		var lightShip = ComGetEtcData(sXml, "light_ship");

		var fuelOil = ComGetEtcData(sXml, "fuel_oil");
		var dieselOil = ComGetEtcData(sXml, "diesel_oil");
		var freshWater = ComGetEtcData(sXml, "fresh_water");
		var ballast = ComGetEtcData(sXml, "ballast");
		
		var draft = ComGetEtcData(sXml, "draft");
		
		var tpc = ComGetEtcData(sXml, "tpc");
		var displacement = ComGetEtcData(sXml, "displacement");
		var cargoWeight = ComGetEtcData(sXml, "cargo_weight");
		
		var title = ComGetEtcData(sXml, "title");
		
		if(vslClass != null && vslClass != undefined && vslClass != ""){
			formObj.vsl_class.value = vslClass;
		}
		if(lightShip != null && lightShip != undefined && lightShip != ""){
			formObj.light_ship.value = ComAddComma(lightShip);
		}
		
		if(fuelOil != null && fuelOil != undefined && fuelOil != ""){
			formObj.fuel_oil.value = ComAddComma(fuelOil);
		}
		if(dieselOil != null && dieselOil != undefined && dieselOil != ""){
			formObj.diesel_oil.value = ComAddComma(dieselOil);
		}
		if(freshWater != null && freshWater != undefined && freshWater != ""){
			formObj.fresh_water.value = ComAddComma(freshWater);
		}
		if(ballast != null && ballast != undefined && ballast != ""){
			formObj.ballast.value = ComAddComma(ballast);
		}
		
		if(draft != null && draft != undefined && draft != "" && draft != "null"){
			formObj.draft.value = ComAddComma(draft) + "M";
		}

		if(tpc != null && tpc != undefined && tpc != ""){
			formObj.tpc.value = ComAddComma(tpc);
		}
		if(displacement != null && displacement != undefined && displacement != ""){
			formObj.displacement.value = ComAddComma(displacement);
		}

		if(cargoWeight != null && cargoWeight != undefined && cargoWeight != ""){
			formObj.cargo_weight.value = ComAddComma(cargoWeight);
		}

//		if(displacement != null && displacement != undefined && displacement != ""){
//			var constant = formObj.constant.value;
//			var sumWt = Number(ComGetUnMaskedValue(ComNullToZero(lightShip), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(constant), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(fuelOil), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(dieselOil), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(freshWater), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(ballast), "float"))
//						;
//			
//			formObj.cargo_weight.value = ComAddComma(displacement - sumWt);
//		}
		
		sheetObj.Redraw = false;
		sheetObj.InitHeadRow(0, "|"+title, true);
		sheetObj.LoadSearchXml(sXml);
		sheetObj.Redraw = true;
	}

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function wgt_port_cd_OnChange(comboObj, Code, Text) {
//		comboObj.UseCode = true;
		var formObj = document.form;
		for(var i=0; i<glbPortCds.length; i++){
			if(Text == glbSkdDirCds[i] + "|" + glbPortCds[i] + "|" + glbClptIndSeqs[i]){
				formObj.wgt_vsl_cd.value = glbVslCds[i];
				formObj.wgt_skd_voy_no.value = glbSkdVoyNos[i];
				formObj.wgt_skd_dir_cd.value = glbSkdDirCds[i];
				formObj.wgt_clpt_ind_seq.value = glbClptIndSeqs[i];
				
				break;
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
	}
	
	function obj_change(){
		var formObject = document.form;
	    var sheetObj = sheetObjects[0];
		
	    try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "test":
	            	break;
	                
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function obj_keypress(){
		var formObj = document.form;
		switch (event.srcElement.name) {
		    case "fuel_oil":
		    	ComKeyOnlyNumber(formObj.fuel_oil, ".");
				break;
		    case "diesel_oil":
		    	ComKeyOnlyNumber(formObj.diesel_oil, ".");
				break;
		    case "fresh_water":
		    	ComKeyOnlyNumber(formObj.fresh_water, ".");
				break;
		    case "ballast":
		    	ComKeyOnlyNumber(formObj.ballast, ".");
				break;
		    case "constant":
		    	ComKeyOnlyNumber(formObj.constant, ".");
				break;
		}
	}
	
	/**
     * 화면을 초기화 한다.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	
    	sheetObj.InitHeadRow(0, glbInitHeaderTitle, true);
    	sheetObj.RemoveAll();
    	
    	formObj.vsl_class.value = "";
		formObj.fuel_oil.value = "";
		formObj.light_ship.value = "";
		formObj.diesel_oil.value = "";
		formObj.draft.value = "";
		formObj.tpc.value = "";
		formObj.fresh_water.value = "";
		formObj.cargo_weight.value = "";
		formObj.constant.value = "";
		formObj.ballast.value = "";
		formObj.displacement.value = "";
    	
//    	formObj.constant.focus();
    }
	
	/**
	 * 부모창의 선택된 기초 DATA를 가져온다.
	 * 
	 * @param formObj
	 * @return
	 */
	function initCallBaseData(formObj){
		var opner = window.dialogArguments;
		var pSheetObj = getParentSheet();
		var prefix = pSheetObj.id + "_";
		var selRow = pSheetObj.SelectRow;
		var headRow = pSheetObj.HeaderRows;
		
		formObj.vsl_cd.value = pSheetObj.CellValue(selRow, prefix+"vsl_cd");
		formObj.skd_voy_no.value = pSheetObj.CellValue(selRow, prefix+"skd_voy_no");
		formObj.skd_dir_cd.value = pSheetObj.CellValue(selRow, prefix+"skd_dir_cd");
		formObj.loc_cd.value = pSheetObj.CellValue(selRow, prefix+"vps_port_cd");
		
		formObj.vps_port_cd.value = pSheetObj.CellValue(selRow, prefix+"vps_port_cd");
		formObj.clpt_ind_seq.value = pSheetObj.CellValue(selRow, prefix+"clpt_ind_seq");

		formObj.vps_eta_dt.value = Usr_GetDateTimeSet(pSheetObj.CellValue(selRow, prefix+"vps_eta_dt"));
		formObj.vps_etd_dt.value = Usr_GetDateTimeSet(pSheetObj.CellValue(selRow, prefix+"vps_etd_dt"));
		
		var clptSeq = pSheetObj.CellValue(selRow, prefix+"clpt_ind_seq");
		
		var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		var callIndCds = ComGetEtcData(sXml, "call_ind_cd").split("|");
		var callIndNms = ComGetEtcData(sXml, "call_ind_nm").split("|");
		
		if(callIndCds){
			for(var i=0; i<callIndCds.length; i++){
				if(clptSeq == callIndCds[i]){
					formObj.call_ind_cd.value = clptSeq;
					formObj.call_ind_nm.value = callIndNms[i];
					break;
				}
			}
		}
		
		//이전 Port 정보
		var sVslCd = ComGetEtcData(sXml, "vsl_cd_list");
		if(sVslCd != null && sVslCd != undefined && sVslCd != ""){
			//Port List(Select Element) Setting...
			var comboObj = getComboObject("wgt_port_cd");
//			ComClearCombo(comboObj);
			comboObj.RemoveAll();

			glbVslCds = ComGetEtcData(sXml, "vsl_cd_list").split("|");
			glbSkdVoyNos = ComGetEtcData(sXml, "skd_voy_no_list").split("|");
			glbSkdDirCds = ComGetEtcData(sXml, "skd_dir_cd_list").split("|");
			glbPortCds = ComGetEtcData(sXml, "vps_port_cd_list").split("|");
			glbClptIndSeqs = ComGetEtcData(sXml, "clpt_ind_seq_list").split("|");
			
			formObj.wgt_vsl_cd.value = glbVslCds[0];
			formObj.wgt_skd_voy_no.value = glbSkdVoyNos[0];
			formObj.wgt_skd_dir_cd.value = glbSkdDirCds[0];
			formObj.wgt_clpt_ind_seq.value = glbClptIndSeqs[0];
			
			for(var i=0; i<glbPortCds.length; i++){
//				ComAddComboItem(comboObj, glbPortCds[i], glbPortCds[i]);
				comboObj.InsertItem(i, glbSkdDirCds[i]+"|"+glbPortCds[i]+"|"+glbClptIndSeqs[i], glbPortCds[i]);
			}
			comboObj.Code2 = glbPortCds[0];
		}
	}

	
	/**
	 * 부모창의 활성화된 Sheet 정보를 가져온다.
	 * @return
	 */
	function getParentSheet(){
		var opner = window.dialogArguments;
		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 0){
				for(var i=0; i<opner.sheetObjects.length; i++){
					if(opner.document.form.rdo_tran[i].checked){
						return opner.sheetObjects[i];
					}
				}
			}else{
				return opner.sheetObjects[0];
			}
		}
		
		return null;
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
	
	/**
	 * 
	 * @param sDate
	 * @return
	 */
	function Usr_GetDateTimeSet(sDate){
		var ymd = "";
		var hm = "";
		if(ComIsDateTime2(sDate, "ymdhm")){
			ymd = ComGetMaskedValue(sDate.substring(0, 8), "ymd");
			hm = ComGetMaskedValue(sDate.substring(8, 12), "hm");
		}else{
			return "";
		}
		
		return ymd + " " + hm;
	}



    
	/* 개발자 작업  끝 */