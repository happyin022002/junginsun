/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0053.js
*@FileTitle : Stevedore Damage Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.02 이선영
* 1.0 Creation
* 2010.10.26 이윤정 [CHM-201006565-01] SDMS Creation 및 inquiry &update 화면 변경
* 2011.02.10 김기종 [CHM-201108942-01] Stevedore Damage Inquiry & Update메뉴내 칼럼 추가
									(Quotation,Repair,Settled amount,Claim Handling Office)
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
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
     * @class vop_opf_0053 : vop_opf_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0053() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setDefaultComboData	= setDefaultComboData;
    	this.event_keypress			= event_keypress;
    	this.event_keyup			= event_keyup;
    	this.dataClear				= dataClear;
    	this.isNull					= isNull;
    	this.initCombo				= initCombo;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var sdmsConditionFlag = false;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		var prefix = "sheet1_"

            switch(srcName) {
            	
	            case "vvd_cd_pop":
	            	var vsl_cd = formObject.vvd_cd.value;
	            	ComOpenPopup("VOP_VSK_0219.do?vsl_cd="+vsl_cd, 460, 500, "event_vvd_cd_pop", "0,0", true);
	            	break;
	            	
	            case "vps_port_cd_pop":
	            	var port_cd = formObject.vps_port_cd.value;
	            	ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 425, 520, "event_vps_port_cd_pop", "0,0", true);
	            	break;
	            	
	            case "slan_cd_pop":
	            	var slan_cd = formObject.slan_cd.value;
	            	ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 425, 480, "event_slan_cd_pop", "0,0", true);
	            	break;
	            	
	            case "cal_stv_dmg_evnt_dt_to":
                	var cal = new ComCalendarFromTo();
                	cal.select(formObject.stv_dmg_evnt_dt_from, formObject.stv_dmg_evnt_dt_to, 'yyyy-MM-dd');
	            	break;
	            	
				case "btn_DownExcel":
					//sheetObject1.ExcelPrint = "PreView";
					sheetObject1.Down2Excel(-1);
					break;
					
				case "btn_Retrieve":
					if(!sdmsConditionFlag && !ComChkValid(formObject)){
			        	return false;
			        }
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_New":
					dataClear(sheetObject1, formObject);
					break;
					
				case "btn_Open":
					if(sheetObject1.SelectRow>0){
						sheet1_OnDblClick(sheetObject1, sheetObject1.SelectRow);
					}else{
						//ComShowMessage("Open Data is not Selected.");
						//ComShowCodeMessage("OPF07012");
					}
					break;
    			
				case "btn_History":
					if(sheetObject1.SelectRow > 0){
						var paramNo = sheetObject1.CellValue(sheetObject1.SelectRow,"sheet1_stv_dmg_no");
						ComOpenPopup("VOP_OPF_0054.do?stv_dmg_no="+paramNo, 800, 545, "", "0,0", true);
					}
					else{
						//ComShowMessage("There is no Selected Row.");
						//ComShowCodeMessage("OPF07012");
						return false;
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
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
    	
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
    	//Code 입력 시 영문 대문자만 입력하기.
    	axon_event.addListener  ('keypress', 'event_keypress' , 'vvd_cd'
    														, 'stv_dmg_no_prefix'
    														, 'stv_dmg_no_suffix'
															, 'vps_port_cd'
															, 'slan_cd');
    	
    	// MaxLength 입력 시 Focus 이동하기.
    	axon_event.addListener  ('keyup', 'event_keyup' , 'vvd_cd'
    													, 'stv_dmg_no_suffix'
														, 'vps_port_cd'
														, 'slan_cd'
														, 'stv_dmg_evnt_dt_from'
														, 'cmpn_cost_usd_amt');
    	
    	axon_event.addListener  ('change', 'change_event' , 'vvd_cd'
    													, 'stv_dmg_no_prefix'
    													, 'stv_dmg_no_suffix'
														, 'vps_port_cd'
														, 'slan_cd'
														//, 'elapse_day'
														);
    	// Enter Key Search.
        axon_event.addListener ('keydown', 'ComKeyEnter', 'vvd_cd'
        												, 'stv_dmg_no_suffix'
        												, 'vps_port_cd'
        												, 'slan_cd'
        												, 'stv_dmg_evnt_dt_from'
        												, 'stv_dmg_evnt_dt_to'
        												, 'elapse_day'
        												//, 'vsl_type_cd'
        												//, 'stv_dmg_req_cate_cd'
        												//, 'stv_dmg_rpr_proc_sts_cd'
        												//, 'stv_dmg_cmpn_proc_sts_cd'
        												//, 'stv_dmg_stl_proc_sts_cd'
        												, 'cmpn_cost_usd_amt');
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
    	
       comboObjects[comboCnt++] = combo_obj;
    }
     
     /**
      * Combo 기본 설정
      * Combo의 항목을 설정한다.
      */
     function initCombo(comboObj) {
     	with(comboObj) {
     		switch(id) {
 		        case "vsl_type_cd":
 	            	SetTitle("Category");
 	            	//SetColWidth("100|50|200")
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_req_cate_cd":
 	            	SetTitle("Category");
 	            	//SetColWidth("100|50|200")
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_rpr_proc_sts_cd":
 	            	SetTitle("Repair");
 	            	//SetColWidth("100|50|200")
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_cmpn_proc_sts_cd":
 	            	SetTitle("Compensation");
 	            	//SetColWidth("100|50|200")
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_stl_proc_sts_cd":
 	            	SetTitle("Settlement");
 	            	//SetColWidth("100|50|200")
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		    }
     	}
 	}
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	ComKeyOnlyNumber(event.srcElement,'.');
    	
//    	if(event.srcElement.name=="cmpn_cost_usd_amt"){
//    		var str = event.srcElement.value;
//        	//alert(str.indexOf("."));
//    		if(str.indexOf(".") > 0 && str.substring(str.indexOf(".")).length > 2){
//    			//event.srcElement.value = str.substring(0,str.length-1);
//    			return false;
//    		}
//    	}
    }
    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
        event.srcElement.select();
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	// dataformat Validation Check!
    	ComChkObjValid(event.srcElement);
    }
    
    /**
     * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
     **/
    function vsl_type_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
    }
    /**
     * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
     **/
    function stv_dmg_req_cate_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
    }
    /**
     * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
     **/
    function stv_dmg_rpr_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
     	 
     	 if(keyCode==13){
     		 var obj = document.getElementById("btn_Retrieve");
      		 obj.fireEvent("onclick");
     	 }
    }
    /**
     * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
     **/
    function stv_dmg_cmpn_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
     	 
     	 if(keyCode==13){
     		 var obj = document.getElementById("btn_Retrieve");
      		 obj.fireEvent("onclick");
     	 }
    }
    /**
     * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
     **/
    function stv_dmg_stl_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
     	 
     	 if(keyCode==13){
     		 var obj = document.getElementById("btn_Retrieve");
      		 obj.fireEvent("onclick");
     	 }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

			for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );

				initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			//Combo Object초기화
	    	for(var k=0; k<comboObjects.length; k++){
	        	initCombo(comboObjects[k]);
	        }
			
			initControl();
			
			setDefaultComboData(sheetObjects[0], document.form);
//			document.form.stv_dmg_evnt_dt_from.value = "2001-01-01";
//			document.form.stv_dmg_evnt_dt_to.value = ComGetNowInfo("ymd");
			ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
			setSubButton();
	}
    
    /**
     * 화면 초기화. <br>
     **/
    function dataClear(sheetObj, formObj) {
    	
    	formObj.vvd_cd.value = "";
    	formObj.stv_dmg_no_prefix.value = "";
    	formObj.stv_dmg_no_suffix.value = "";
    	formObj.vps_port_cd.value = "";
    	formObj.slan_cd.value = "";
    	formObj.stv_dmg_evnt_dt_from.value = "";
    	formObj.stv_dmg_evnt_dt_from.value = "2010-01-01";
    	formObj.stv_dmg_evnt_dt_to.value = ComGetNowInfo("ymd");
    	formObj.elapse_day.value = "";
    	formObj.cmpn_cost_usd_amt.value = "";
    	comboObjects[0].Index = 0;
    	comboObjects[1].Index = 0;
    	comboObjects[2].Index = 0;
    	comboObjects[3].Index = 0;
    	comboObjects[4].Index = 0;
    	
    	sheetObj.RemoveAll();
    }
    
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(sheetObj, formObj) {
    	
    	var comboXml = sheetObj.GetSearchXml("VOP_OPF_0053GS.do" , FormQueryString(formObj));
    	
    	// Vessel Category Combo List Set..
    	var vslCateCode = ComGetEtcData(comboXml, "vslCategory");
    	if(!isNull(vslCateCode)){
    		setComboItem(comboObjects[0], vslCateCode);
    	}
    	// Category Combo List Set..
    	var categoryCode = ComGetEtcData(comboXml, "categoryCode");
    	if(!isNull(categoryCode)){
    		setComboItem(comboObjects[1], categoryCode);
    	}
    	// Repair Combo List Set..
    	var repairCode = ComGetEtcData(comboXml, "repairCode");
    	if(!isNull(repairCode)){
    		setComboItem(comboObjects[2], repairCode);
    	}
    	// Compensation Combo List Set..
    	var compenCode = ComGetEtcData(comboXml, "compenCode");
    	if(!isNull(compenCode)){
    		setComboItem(comboObjects[3], compenCode);
    	}
    	// Settlement Combo List Set..
    	var stlmntCode = ComGetEtcData(comboXml, "stlmntCode");
    	if(!isNull(stlmntCode)){
    		setComboItem(comboObjects[4], stlmntCode);
    	}
    	
    	// Default Combo Data Set..
    	comboObjects[0].Index = 0;
    	comboObjects[1].Index = 0;
    	comboObjects[2].InsertItem(1, "None", "None");
    	comboObjects[2].Index = 0;
    	comboObjects[3].InsertItem(1, "None", "None");
    	comboObjects[3].Index = 0;
    	comboObjects[4].InsertItem(1, "None", "None");
    	comboObjects[4].Index = 0;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    	}
    	// 조회 조건의 Combo Item: "ALL" 추가.
    	comboObj.InsertItem(0, "All", "All");
    }
    
    /**
     * 코드성 Data 영문대문자 입력 함수.
     */
    function event_keypress() {
        if(event.srcElement.name=="vvd_cd" || event.srcElement.name=="slan_cd")
        {
        	//영대문자 & 숫자만 입력가능.
            ComKeyOnlyAlphabet('uppernum');
        }else if(event.srcElement.name=="stv_dmg_no_suffix")
        {	
        	//숫자만 입력가능.
        	ComKeyOnlyNumber(event.srcElement);
        }else{
        	ComKeyOnlyAlphabet('upper');
        }
    }
     
     /**
      * Data Max Length 입력시 focus 이동 함수.
      */
     function event_keyup() {
     	ComKeyEnter('LengthNextFocus');
    	
     	// 소수점 2자리 이상 입력 금지!
    	if(event.srcElement.name=="cmpn_cost_usd_amt"){
    		var str = event.srcElement.value;
        	
    		if(str.indexOf(".") > 0 && str.substring(str.indexOf(".")).length > 3){
    			event.srcElement.value = str.substring(0,str.length-1);
    			return false;
    		}
    	}
     }
    
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	var gubun = "";
    	var sdmsFlag = false;
    	
//    	if(elementObj.name=="elapse_day"){
//    		var days = elementObj.value;
//    		if(isNull(days)){
//    			document.form.elapse_day_from.value = "";
//        		document.form.elapse_day_to.value = "";
//    		}else{
//        		document.form.elapse_day_from.value = ComGetDateAdd(null, "D", -days);
//        		document.form.elapse_day_to.value = ComGetNowInfo("ymd");
//    		}
//    	}
//    	else if(!isNull(elementObj.value)){
    	//alert(elementObj.name);
    	if(!isNull(elementObj.value)){
    		// Object의 Length Check..
        	if(elementObj.maxLength != elementObj.value.length){
        		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
        		//elementObj.focus();
        		elementObj.select();
        		return false;
        	}
    		
    		if(elementObj.name=="vvd_cd"){
    			gubun = "vvdCd";
    			if(elementObj.value!="") {
    				formObj.stv_dmg_no_prefix.value = elementObj.value;
    				formObj.stv_dmg_no_suffix.value = "";
    			}
        	}
    		else if(elementObj.name=="stv_dmg_no_prefix") {
    			gubun = "vvdCd";
    			sdmsFlag = true;
    			if(elementObj.value!=formObj.vvd_cd.value) formObj.vvd_cd.value = "";
    			
    			//Period 설정
    			if(form.stv_dmg_no_suffix.value != "") setPeriodBySdms(true);
    			else setPeriodBySdms(false);
    		}
    		else if(elementObj.name="stv_dmg_no_suffix") {
    			//Period 설정
    			if(form.stv_dmg_no_prefix.value != "") setPeriodBySdms(true);
    			else setPeriodBySdms(false);
    		}
        	else if(elementObj.name=="vps_port_cd"){
        		gubun = "portCd";
        	}
        	else if(elementObj.name=="slan_cd"){
        		gubun = "slanCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun, sdmsFlag);
    	}else {
    		if(elementObj.name=="stv_dmg_no_prefix"){
    			setPeriodBySdms(false);
    		}else if(elementObj.name=="stv_dmg_no_suffix"){
    			setPeriodBySdms(false);
    		}
    	}
    }
    
    	
    function setPeriodBySdms(flag) {
    	var formObj = document.form;
    	
    	sdmsConditionFlag = flag;
    	if(flag) {
			formObj.stv_dmg_evnt_dt_from.value = "";
			formObj.stv_dmg_evnt_dt_to.value = "";
			formObj.stv_dmg_evnt_dt_from.className = "input";
			formObj.stv_dmg_evnt_dt_to.className = "input";
    	}else {
    		formObj.stv_dmg_evnt_dt_from.value = "2010-01-01"; 
			formObj.stv_dmg_evnt_dt_to.value = today.substring(0, 4)+"-"+today.substring(4, 6)+"-"+today.substring(6);
			formObj.stv_dmg_evnt_dt_from.className = "input1";
			formObj.stv_dmg_evnt_dt_to.className = "input1";
    	}
    }
    
    /**
     * vvd_cd Data PopUp Value 입력 함수.
     */
    function event_vvd_cd_pop(aryPopupData) {
    	document.form.vvd_cd.value = aryPopupData[0][1];
    }
    
    /**
     * vps_port_cd Data PopUp Value 입력 함수.
     */
    function event_vps_port_cd_pop(aryPopupData) {
    	document.form.vps_port_cd.value = aryPopupData[0][2];
    }
    
    /**
     * slan_cd Data PopUp Value 입력 함수.
     */
    function event_slan_cd_pop(aryPopupData) {
    	document.form.slan_cd.value = aryPopupData[0][1];
    }
    
//    /**
//     * slan_cd Data PopUp Value 입력 함수.
//     */
//    function sheet1_OnDblClick(sheetObj, row, col) {
//    	//location.href = "VOP_OPF_1053.do?stv_dmg_no="+ sheetObj.CellValue(row,"sheet1_stv_dmg_no");
//    	ComOpenPopup("VOP_OPF_1053.do?stv_dmg_no="+ sheetObj.CellValue(row,"sheet1_stv_dmg_no"), 1000, 650, "", "0,0", true);
//    }
    /**
     * slan_cd Data PopUp Value 입력 함수.
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObj = document.form;
//    	if(ComGetObjValue(formObj.popUpOpen) == "Y") {
	    	//location.href = "VOP_OPF_1053.do?stv_dmg_no="+ sheetObj.CellValue(row,"sheet1_stv_dmg_no");
	    	ComOpenPopup("VOP_OPF_1053.do?stv_dmg_no="+ sheetObj.CellValue(row,"sheet1_stv_dmg_no"), 1000, 650, "", "0,0", true);
//	    	ComOpenPopup("VOP_OPF_1053.do?stv_dmg_no="+ sheetObj.CellValue(row,"sheet1_stv_dmg_no"), 1000, 650, "", "0,0", true, false, '', '', '', '', 'yes');
//		}
    }
     
     /**
      * slan_cd Data PopUp Value 입력 함수.
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) 
     {
    	 with(sheetObj)
 		 {
    		 //CellFontColor(0,prefix+"dmg_auth_sts_cd") = RgbColor(255,0,0);
 	         //sheetObj.ColFontColor("sheet1_dmg_auth_sts_cd") = sheetObj.RgbColor(0,0,255);
    		 for(var i=2; i < LastRow; i++){
    			 if(CellValue(i,"sheet1_dmg_auth_sts_cd")=="Y" || CellValue(i,"sheet1_dmg_auth_sts_cd")=="N")
    			 {
    				 CellFont("FontColor", i, "sheet1_dmg_auth_sts_cd") = RgbColor(255,0,0);
    	    		 CellFont("FontBold", i, "sheet1_dmg_auth_sts_cd") = true;
    			 }
    		 }
 		 }
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

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    //var HeadTitle = "|STV_DMG_NO|VVD_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|STV_DMG_TP_CD|elapseDay|DMG_AUTH_STS_CD|STV_DMG_REQ_CATE_CD|STV_DMG_RPR_PROC_STS_CD|STV_DMG_CMPN_PROC_STS_CD|STV_DMG_STL_PROC_STS_CD|REQ_PORT_CD|REQ_ETA_DT";
					//var headCount = ComCountHeadTitle(HeadTitle);
                    var HeadTitle1 = "|SDMS No.|VVD CD|Port|Damage\nDate|Claim\nhandling\nOffice|Damage\nCategory|Elapsed\nDays|APVL|Damage\nRequirement|Process|Process|Process|Cost|Cost|Cost|Requirement|Requirement";
					var HeadTitle2 = "|SDMS No.|VVD CD|Port|Damage\nDate|Claim\nhandling\nOffice|Damage\nCategory|Elapsed\nDays|APVL|Damage\nRequirement|Repair|Compen.|Settle|Quotation|Repair|Settled|Port|ETA";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
					
					InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"stv_dmg_no",				false,	"",  dfUserFormat,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"vvd_cd",					false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"vps_port_cd",				false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"stv_dmg_evnt_dt",			false,	"",  dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"clm_hndl_ofc_cd",			false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"stv_dmg_tp_cd",				false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"elapse_day",				false,	"",  dfNullInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"dmg_auth_sts_cd",			false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"stv_dmg_req_cate_cd",		false,	"",  dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"stv_dmg_rpr_proc_sts_cd",	false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"stv_dmg_cmpn_proc_sts_cd",	false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"stv_dmg_stl_proc_sts_cd",	false,	"",  dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	80,	daRight,	true,	prefix+"qttn_cost_usd_amt",			false,	"",		dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daRight,	true,	prefix+"rpr_cost_usd_amt",			false,	"",		dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,	daRight,	true,	prefix+"pay_usd_amt",				false,	"",		dfFloat,	3,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"req_port_cd",				false,	"",  dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"req_eta_dt",				false,	"",  dfNone,	0,	false,	false);
					
					//CellFontColor(0,prefix+"dmg_auth_sts_cd") = RgbColor(255,0,0);
					//CountPosition = 0;
					
					InitUserFormat(0, prefix+"stv_dmg_no", "LLLL-#######", "-");
				}
                break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction, gubun, sdmsFlag) {
    	sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	    
	      case IBSEARCH:
	    	if(!sdmsConditionFlag && !ComChkValid(formObj)){
	    		return false;
	    	}
	        formObj.f_cmd.value = SEARCH;
	        var stvDmgNo = "";
			if(formObj.stv_dmg_no_prefix.value!="" && formObj.stv_dmg_no_suffix.value!="") 
				stvDmgNo =  formObj.stv_dmg_no_prefix.value + formObj.stv_dmg_no_suffix.value;
	        sheetObj.DoSearch("VOP_OPF_0053GS.do", FormQueryString(formObj) + "&stv_dmg_no=" + stvDmgNo + "&" + ComGetPrefixParam("sheet1_"));
	        break;
	        
	      case IBROWSEARCH:
	    	  if(gubun=="vvdCd"){
	    		  formObj.f_cmd.value = COMMAND16;
	    		  var vvdCd = sdmsFlag? formObj.stv_dmg_no_prefix.value : formObj.vvd_cd.value;
	    		  var vslXml = sheetObj.GetSearchXml("VOP_VSK_0219GS.do?vsl_cd="+vvdCd , FormQueryString(formObj));
	    		  //alert(vslXml);
	    		  var strVslCd = ComGetEtcData(vslXml, "vsl_eng_nm");
	    		  
	    		  if(isNull(strVslCd)){
	    			  //ComShowMessage("Data is not available.");
					  ComShowCodeMessage("OPF50004", "Data");
					  if(sdmsFlag) {
						  formObj.stv_dmg_no_prefix.value = "";
		    			  formObj.stv_dmg_no_prefix.focus();
					  }else {
						  formObj.stv_dmg_no_prefix.value = "";
						  formObj.stv_dmg_no_suffix.value = "";
		    			  formObj.vvd_cd.value = "";
		    			  formObj.vvd_cd.focus();
					  }
	    			  return;
	    		  }else{
	    			  if(sdmsFlag) {
	    				  formObj.stv_dmg_no_suffix.focus();
	    			  }else {
	    				  formObj.stv_dmg_no_prefix.focus();
	    			  }
	    		  }
	    	  }
	    	  else if(gubun=="portCd"){
	    		  formObj.f_cmd.value = COMMAND13;
	    		  var polXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?loc_cd="+formObj.vps_port_cd.value , FormQueryString(formObj));
	    		  var strPolCd = ComGetEtcData(polXml, "port_name");
	    		  
	    		  if(isNull(strPolCd)){
	    			  //ComShowMessage("Data is not available.");
					  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.vps_port_cd.value = "";
	    			  formObj.vps_port_cd.focus();
	    			  return;
	    		  }else{
	    			  formObj.slan_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="slanCd"){
	    		  
	      		
    	    	  var auto_skd_cng_flg="LANE";
    	    	  var lane_cd="";
    	    	  lane_cd = formObj.slan_cd.value; 
    	    	  formObj.f_cmd.value = COMMAND01;
	    		  var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+auto_skd_cng_flg+"&slan_cd="+lane_cd);
	    		  var strLanCdDesc = ComGetEtcData(resultXml, "result_chk");
    	    	  if (strLanCdDesc==null ||strLanCdDesc =="null"|| strLanCdDesc=="" || strLanCdDesc==undefined){
					  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.slan_cd.value = "";
	    			  formObj.slan_cd.focus();
    	    		  return false;
	  	    	  } else {
	  	    		  return true;
	  	    	  }
//	    		  formObj.f_cmd.value = COMMAND12;
//	    		  var lanXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?&vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
//	    		  var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
//	    		  if(isNull(strLanCdDesc)){
//	    			  //ComShowMessage("Data is not available.");
//					  ComShowCodeMessage("OPF50004", "Data");
//	    			  formObj.slan_cd.value = "";
//	    			  formObj.slan_cd.focus();
//	    			  return;
//	    		  }else{
//	    			  formObj.stv_dmg_evnt_dt_from.select();
//	    		  }
	    	  }
	    	  break;
 	          
	    }
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
    
    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    /**
     * Sub Button의 Disable/Enable 설정. <br>
     **/
    function setSubButton(){
    	var formObj = document.form;
//    	if(ComGetObjValue(formObj.popUpOpen) == "Y"){
    		 ComBtnEnable("btn_Open");
//    	 } else {
//    		 ComBtnDisable("btn_Open");
//    	 }
    }
    //VOP_OPF_1053 에서 Close 시 이벤트 발생
    function call_1053(){
        var sheetObject1 = sheetObjects[0];
        var formObject = document.form;		
		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }    
	/* 개발자 작업  끝 */