/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0056.js
*@FileTitle : SDMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.01 이선영
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
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
     * @class vop_opf_0056 : vop_opf_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0056() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    	this.initTab				= initTab;
    	this.initCombo				= initCombo;
    	this.setDefaultComboData	= setDefaultComboData;
    	this.setComboItem			= setComboItem;
    	this.setComboItem2			= setComboItem2;
    	this.isNull					= isNull;
    	this.dataClear				= dataClear;
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	     var sheetObject1 = sheetObjects[0];
	     var sheetObject2 = sheetObjects[1];
	     var sheetObject3 = sheetObjects[2];
	     var sheetObject4 = sheetObjects[3];
	     var sheetObject5 = sheetObjects[4];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "cal_stv_dmg_evnt_dt_to":
            		var cal = new ComCalendarFromTo();
                	cal.select(formObject.stv_dmg_evnt_dt_from, formObject.stv_dmg_evnt_dt_to, 'yyyy-MM-dd');
            		break;
            		
            	case "loc_cd_pop":
            		ComOpenPopup("COM_ENS_0M1.do", 564, 470, "loc_cd_pop_event", "1,0,1", true);
            		break;
            		
            	case "vps_port_cd_pop":
            		var port_cd = formObject.vps_port_cd.value;
            		ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 425, 520, "vps_port_cd_pop_event", "0,0", true);
            		break;
            		
            	case "slan_cd_pop":
            		var slan_cd = formObject.slan_cd.value;
            		ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 425, 480, "slan_cd_pop_event", "0,0", true);
            		break;
            		
            	case "vsl_cd_pop":
            		ComOpenPopup("COM_ENS_0A1.do", 620, 470, "vsl_cd_pop_event", "1,0,1", true);
            		break;
            		
            	case "btn_t1DownExcel":
            		//sheetObject1.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.title = "";
                    paramObj.datarowheight = "1:30";
                    paramObj.columnwidth = "1:8|2:20|3:20|4:22|5:22|6:24";
                    var url = ComOpfGetExcelSet(sheetObject1, paramObj);
                    sheetObject1.Down2Excel(-1, false,false, true, "", url);     		
            		break;
            		
            	case "btn_t2DownExcel":
            		//sheetObject2.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.title = "";
                    paramObj.orientation = "Portrait";
                    paramObj.columnwidth = "1:5|2:9|3:8|4:8|5:8|6:12|7:8|8:8|9:9";
                    var url = ComOpfGetExcelSet(sheetObject2, paramObj);
                    sheetObject2.Down2Excel(-1, false,false, true, "", url);
            		break;
            		
            	case "btn_t3DownExcel":
            		//sheetObject3.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.title = "";
                    paramObj.orientation = "Portrait";
                    paramObj.columnwidth = "1:5|2:12|3:12|4:12|5:12|6:12|7:12";
                    var url = ComOpfGetExcelSet(sheetObject3, paramObj);
                    sheetObject3.Down2Excel(-1, false,false, true, "", url);            		
            		break;
            		
            	case "btn_t4DownExcel":
            		//sheetObject4.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.title = "";
                    paramObj.orientation = "Portrait";
                    paramObj.datarowheight = "1:30";
                    paramObj.columnwidth = "1:5|2:9|3:8|4:8|5:9|6:9|7:9|8:9|9:9";
                    var url = ComOpfGetExcelSet(sheetObject4, paramObj);
                    sheetObject4.Down2Excel(-1, false,false, true, "", url);            		
            		break;
            		
            	case "btn_t5DownExcel":
            		//sheetObject5.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.title = "";
                    paramObj.orientation = "Portrait";
                    paramObj.columnwidth = "1:8|2:36|3:36";
                    var url = ComOpfGetExcelSet(sheetObject5, paramObj);
                    sheetObject5.Down2Excel(-1, false,false, true, "", url);              		
            		break;

				case "btn_Retrieve":
					if(validateForm(sheetObject1,formObject)){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
					
				case "btn_New":
					dataClear(formObject);
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
    	var i=0;
     	with(comboObj) {
     		switch(id) {
 		        case "vsl_oshp_cntr_blk_tp_cd":
 	            	SetTitle("Category");
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "group_by":
 					with(comboObj) {
 						comboObj.DropHeight=270;
 						InsertItem(i++,  "By Month/Qtr/Half/Year", "A");
 						InsertItem(i++,  "By Port               ", "D");
 						InsertItem(i++,  "By Country            ", "C");
 						InsertItem(i++,  "By Lane               ", "E");
 						InsertItem(i++,  "By Vessel             ", "F");
 						InsertItem(i++,  "By Damage Category    ", "G");
 						InsertItem(i++,  "By Damage Part        ", "H");
 						InsertItem(i++,  "By Responsible Party  ", "I");
 						InsertItem(i++,  "By Vessel Category    ", "B");
						comboObj.Code = "A"; 
 		        	}
 		            break; 		            
 		            
 		        case "stv_dmg_prt_cate_cd":
 	            	SetTitle("Category");
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_prt_cd":
 	            	SetTitle("Code|Description");
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_tp_cd":
 	            	SetTitle("Code|Description");
 	            	DropHeight = 230;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 		            break;
 		            
 		        case "stv_dmg_respb_pty_kwn_cd":
 					with(comboObj) {
 						comboObj.DropHeight=120;
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "Yes", "Y");
 						InsertItem(i++,  "No", "N");
						comboObj.Text = "All"; 
 		        	}
 		            break;
 		            
 		        case "stv_dmg_step_cd":
 					with(comboObj) {
 						comboObj.DropHeight=120;
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "Repair", "R");
 						InsertItem(i++,  "Supply", "S");
 						InsertItem(i++,  "Quotation", "Q");
						comboObj.Text = "All"; 
 		        	}
 		            break;
 		            
 		        case "stv_dmg_rpr_proc_sts_cd":
 					with(comboObj) {
 						comboObj.DropHeight=120;
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None", "NN");
 						InsertItem(i++,  "Ordered", "O");
 						InsertItem(i++,  "Repairing", "R");
 						InsertItem(i++,  "Completed", "C"); 						
 						InsertItem(i++,  "Quoted", "Q");
						comboObj.Text = "All"; 
 		        	}
 		            break;
 		            
 		        case "stv_dmg_cmpn_proc_sts_cd":
 					with(comboObj) {
 						comboObj.DropHeight=240;
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None        ", "NN");
 						InsertItem(i++,  "Ready       ", "R");
 						InsertItem(i++,  "Claimed     ", "C");
 						InsertItem(i++,  "Noticed     ", "N");
 						InsertItem(i++,  "Accepted    ", "A");
 						InsertItem(i++,  "Rejected    ", "J");
 						InsertItem(i++,  "Completed   ", "P");
 						InsertItem(i++,  "Cancellation", "E");
 						comboObj.Text = "All"; 
 		        	}
 		            break;
 		            
 		        case "stv_dmg_stl_proc_sts_cd":
 					with(comboObj) {
 						comboObj.DropHeight=90;
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None", "NN");
 						InsertItem(i++,  "Paid ", "P");
 						comboObj.Text = "All"; 
 		        	}
 		            break; 		            
 		    }
     	}
 	}
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Performance" , -1 );
                    InsertTab( cnt++ , "Damage" , -1 );
                    InsertTab( cnt++ , "Repair" , -1 );
                    InsertTab( cnt++ , "Compensation" , -1 );
                    InsertTab( cnt++ , "Settlement" , -1 );
                }
             break;

         }
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

    	objs[beforetab].style.display = "none";
    	objs[nItem].style.display = "Inline";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }
    
     /**
      * loc_cd Data PopUp Value 입력 함수.
      */
     function loc_cd_pop_event(aryPopupData) {
     	document.form.loc_cd.value = aryPopupData[0][3];
     }
     
    /**
     * vps_port_cd Data PopUp Value 입력 함수.
     */
    function vps_port_cd_pop_event(aryPopupData) {
    	document.form.vps_port_cd.value = aryPopupData[0][2];
    }
    
    /**
     * slan_cd Data PopUp Value 입력 함수.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value = aryPopupData[0][1];
    }
     
     /**
      * vsl_cd Data PopUp Value 입력 함수.
      */
     function vsl_cd_pop_event(aryPopupData) {
     	document.form.vsl_cd.value = aryPopupData[0][3];
     }
    
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function focus_event() {
    	event.srcElement.select();
    }
    
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function blur_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[0];
    	var gubun = "";
    	
    	if(!isNull(elementObj.value)){
    		
    		// Object의 Length Check..
	    	if(elementObj.maxLength != elementObj.value.length){
	    		//ComShowMessage(elementObj.caption+" is must be input data "+elementObj.maxLength+" Length.");
	    		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
	    		elementObj.focus();
	    		return false;
	    	}
	    	
    		// Popup Data Validation Check!
    		if(elementObj.name=="loc_cd"){
    			gubun = "locCd";
        	}
        	else if(elementObj.name=="vps_port_cd"){
        		gubun = "portCd";
        	}
        	else if(elementObj.name=="slan_cd"){
        		gubun = "slanCd";
        	}
        	else if(elementObj.name=="vsl_cd"){
        		gubun = "vslCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(comboXml) {
    	
    	//Vessel Category Combo List Set..
    	var vslCateCode = ComGetEtcData(comboXml, "vslCategory");
    	setComboItem(comboObjects[0], vslCateCode);
    	comboObjects[0].InsertItem(0, "All", "All");
    	comboObjects[0].Index = 0;
    	
    	//Damage Category Combo List Set..
    	var categoryCode = ComGetEtcData(comboXml, "categoryCode");
    	setComboItem(comboObjects[2], categoryCode);
    	
    	//Damage Type Combo List Set..
    	var damageCode = ComGetEtcData(comboXml, "damageCode");
    	setComboItem2(comboObjects[4], damageCode);
    }
    
    /**
     * Data Clear <br>
     **/
    function dataClear(formObj) {
		ComResetAll();
		ComAddSeparator(document.form.stv_dmg_evnt_dt_from);
        ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
    	
    	comboObjects[0].Index = 0;
    	comboObjects[2].Index = "";
    	comboObjects[3].Index = "";
    	comboObjects[4].Index = "";
    	
    	sheetObjects[0].removeAll();
    	sheetObjects[1].removeAll();
    	sheetObjects[2].removeAll();
    	sheetObjects[3].removeAll();
    	sheetObjects[4].removeAll();
    	
    	formObj.stv_dmg_evnt_dt_from.focus();
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(strUsrId, strUsrNm, strOffcCd) {
    	
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// Combo Object초기화
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k]);
        }
    	// Tab 초기화
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "Combo");
		
		ComAddSeparator(document.form.stv_dmg_evnt_dt_from);
        ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
        comboObjects[0].Index = 0;
        
		document.form.stv_dmg_evnt_dt_from.focus();
		//document.form.vsl_oshp_cntr_blk_tp_cd.select();
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
        
    	//Code 입력 시 영문 대문자만 입력하기
    	axon_event.addListener  ('keypress', 'eng_keypress' , 'loc_cd'
    														, 'vps_port_cd'
    														, 'slan_cd'
    														, 'vsl_cd');
    	
    	axon_event.addListener  ('keyup', 'obj_keyup' , 'stv_dmg_evnt_dt_from');
    	
    	axon_event.addListener  ('blur', 'blur_event' , 'loc_cd'
														, 'vps_port_cd'
														, 'slan_cd'
														, 'vsl_cd');
    	
    	axon_event.addListener  ('focus', 'focus_event' , 'loc_cd'
														, 'vps_port_cd'
														, 'slan_cd'
														, 'vsl_cd');
    	
    	// Enter Key Search.
        axon_event.addListener ('keydown', 'ComKeyEnter', 'stv_dmg_evnt_dt_from'
        												, 'stv_dmg_evnt_dt_to'
        												//, 'vsl_oshp_cntr_blk_tp_cd'
        												, 'group_by'
        												, 'loc_cd'
        												, 'vps_port_cd'
        												, 'slan_cd'
        												, 'vsl_cd'
        												//, 'stv_dmg_prt_cate_cd'
        												//, 'stv_dmg_prt_cd'
        												//, 'stv_dmg_tp_cd'
        												, 'stv_dmg_respb_pty_kwn_cd'
        												, 'stv_dmg_step_cd'
        												, 'stv_dmg_rpr_proc_sts_cd'
        												, 'stv_dmg_cmpn_proc_sts_cd'
        												, 'stv_dmg_stl_proc_sts_cd');
    }
    
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문 대문자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
    	if(event.srcElement.name=="vvd_cd" || event.srcElement.name=="slan_cd" || event.srcElement.name=="vsl_cd")
        {
        	//영대문자 & 숫자만 입력가능.
            ComKeyOnlyAlphabet('uppernum');
        }else{
        	//영대문자 자동변환
        	ComKeyOnlyAlphabet('upper');
        }
    }
     
    /**
     * 특정 Data의 Max Length 입력시, 포커스 이동. <br>
     **/
    function obj_keyup() {
    	ComKeyEnter('LengthNextFocus');
    }
     
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	ComKeyOnlyNumber(event.srcElement);
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
     	var formObj = document.form;
     	var elementObj = event.srcElement;
    	//alert(elementObj.value);
    	if(!isNull(elementObj.value)){
    		
	    	// dataformat Validation Check!
	    	if(!ComChkObjValid(elementObj)){
	    		elementObj.value = "";
	    		elementObj.focus();
	    		return false;
	    	}	
	     	//ComAddSeparator(elementObj);
	    	
	    	// From To Date Validation Check!
    		if(elementObj.name=="stv_dmg_evnt_dt_from")
        	{
        		var dateFlagFrom = ComGetDaysBetween(elementObj.value, formObj.stv_dmg_evnt_dt_to.value);
        		if(dateFlagFrom < 0){
        			//ComShowMessage("[From Date] must be earlier than [To Date].");
        			ComShowCodeMessage("OPF50013", "To Date", "From Date");
        			elementObj.value="";
        			elementObj.focus();
        			return false;
        		}
        	}
        	else if(elementObj.name=="stv_dmg_evnt_dt_to"){
        		var dateFlagTo = ComGetDaysBetween(formObj.stv_dmg_evnt_dt_from.value, elementObj.value);
        		if(dateFlagTo < 0){
        			//ComShowMessage("[To Date] must be later than [From Date].");
        			ComShowCodeMessage("OPF50013", "To Date", "From Date");
        			elementObj.value="";
        			elementObj.focus();
        			return false;
        		}
        		formObj.vsl_oshp_cntr_blk_tp_cd.focus();
        	}
    	}
		if(elementObj.name=="stv_dmg_evnt_dt_to"){
			formObj.vsl_oshp_cntr_blk_tp_cd.focus();
		}
    }
    
     /**
      * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
      **/
     function vsl_oshp_cntr_blk_tp_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
    	 //ComKeyEnter();
     }
     /**
      * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
      **/
     function stv_dmg_prt_cate_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
     /**
      * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
      **/
     function stv_dmg_prt_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
     /**
      * Combo Object Enter Key 입력시 조회 이벤트 발생. <br>
      **/
     function stv_dmg_tp_cd_OnKeyDown(comboObj, keyCode, text) {
    	 
    	 if(keyCode==13){
    		 var obj = document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
     
    /**
     * Damage Category Combo Data 선택시 Damage Part Combo List에 해당 Data Set. <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
    	
    	if(!isNull(comboObj.Code)){

	    	// 선택된 Category에 해당하는 Part Code 가져오기.
	    	formObj.f_cmd.value = SEARCH03;
	    	var categoryPartXml = sheetObjects[0].GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart = ComGetEtcData(categoryPartXml, "catePart");
	    	
	    	if(categoryPart==null || categoryPart.length<1){
	    		//ComShowMessage("Part Code not exist.");
    			ComShowCodeMessage("OPF50009", "Part Code");
	    		comboObjects[3].RemoveAll();
	    		return false;
	    	}else{
	    		setComboItem2(comboObjects[3], categoryPart);
	    		formObj.stv_dmg_prt_cate_cd.focus();
	    	}
    	}else{
    		comboObjects[3].RemoveAll();
    		formObj.stv_dmg_prt_cate_cd.focus();
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        	}
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
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
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    var HeadTitle1 = "|Group|Performance|Performance|Performance|Performance|Performance";
                    var HeadTitle2 = "|Group|Unknown 3RD Party\n/ Total Damage|Repair(Completed)\n/ Total Damage|Compensation(Completed)\n/ Total Damage|Amount of Compensation\n/ Total Amount of Repair|Paid for Owner's Billing Amount\n/ Total Amount of Repair";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,	prefix+"grp",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	160,	daRight,		true,	prefix+"rat_unknown",  	false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	160,	daRight,		true,	prefix+"rat_rep",  		false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	170,	daRight,		true,	prefix+"rat_comp",  	false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	170,	daRight,		true,	prefix+"rat_amt_comp",  false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	175,	daRight,		true,	prefix+"rat_bill_amt",	false,	"",		dfFloat,	2,	false,	false);
                    
                    RowHeight(1) = 30;
                    //CountPosition = 0;
				}
                break;
                
            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    var HeadTitle1 = "|Group|Damage|Damage|Damage|Damage|Damage|Damage|Damage|Damage";
					var HeadTitle2 = "|Group|Damage Count|Repair|Supply|Quotation|Unknown 3rd Party|Hull|Material|Machinery";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet2_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,	prefix+"grp",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,	daRight,		true,	prefix+"dmg_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,	prefix+"rep_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,	prefix+"sup_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,	prefix+"quo_cnt", 	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	115,	daRight,		true,	prefix+"unk_cnt", 	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,	daRight,		true,	prefix+"hull",		false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,	daRight,		true,	prefix+"matl", 		false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,	daRight,		true,	prefix+"mach",  	false,	"",		dfNullInteger,		0,	false,	false);
                    
                    RowHeight(1) = 30;
                    //CountPosition = 0;
				}
                break;
                
            case "sheet3":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    var HeadTitle1 = "|Group|Repair|Repair|Repair|Repair|Repair|Repair";
					var HeadTitle2 = "|Group|Ordered|Repairing|Completed|Completed Amount|Quoted|Quoted Amount";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet3_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,	prefix+"grp",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"order_cnt",	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"repr_cnt",	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"comp_cnt",	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"comp_amt",	false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"quo_cnt",	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	140,	daRight,		true,	prefix+"quo_amt",	false,	"",		dfFloat,	2,	false,	false);
                    
                    RowHeight(1) = 30;
                    //CountPosition = 0;
				}
                break;
                
            case "sheet4":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    var HeadTitle1 = "|Group|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation";
					var HeadTitle2 = "|Group|Ready|Claimed|Noticed|Accepted|Rejected|Completed|Completed\nAmount|Cancellation";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet4_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	120,		daCenter,		true,	prefix+"grp",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"ready_cnt",  false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"claim_cnt",  false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"not_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"acc_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"rej_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"com_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"com_amt", 	false,	"",		dfFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	105,		daRight,		true,	prefix+"can_cnt",  	false,	"",		dfNullInteger,		0,	false,	false);
                    
                    RowHeight(1) = 30;
				}
                break;
                
            case "sheet5":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    //var HeadTitle1 = "|Period|Settlement|Settlement|Settlement|Settlement|Settlement|Settlement";
					//var HeadTitle2 = "|Period|Received|Received Amount|Rejected|Rejected Amount|Paid|Paid Amount";
                    var HeadTitle1 = "|Group|Settlement|Settlement";
					var HeadTitle2 = "|Group|Paid|Paid Amount";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet5_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,	prefix+"grp",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	400,	daRight,		true,	prefix+"pay_cnt",	false,	"",	dfNullInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	400,	daRight,		true,	prefix+"pay_amt",	false,	"",	dfFloat,	2,	false,	false);
                    
                    RowHeight(1) = 30;
                    //CountPosition = 0;
				}
                break;
                
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
    	
    	sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	    
	      case IBSEARCH:      //조회
	    	  if(gubun=="Combo"){
	    		  formObj.f_cmd.value = SEARCH01;
	    		  var comboXml = sheetObj.GetSearchXml("VOP_OPF_0056GS.do" , FormQueryString(formObj));
	    		  //Default ComboData Set..
	              setDefaultComboData(comboXml);
	    	  }
	    	  else{
	    		  	formObj.f_cmd.value = SEARCH;
		    	  	
	    	    	var aryPrefix = new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_");
	  	    		var sXml = sheetObj.GetSearchXml("VOP_OPF_0056GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	  	    		var arrXml = sXml.split("|$$|");
	              	
	              	if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
	              	if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
	              	if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
	              	if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
	              	if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
	    	  }
	        break;
	        
	      case IBROWSEARCH:
	    	  if(gubun=="locCd"){
	    		  formObj.f_cmd.value = SEARCH;
	    		  var locXml = sheetObj.GetSearchXml("COM_ENS_0M1GS.do?cnt_cd="+formObj.loc_cd.value, FormQueryString(formObj));
	    		  //alert(locXml);
	    		  var locArr = ComOpfXml2Array(locXml, "cnt_cd");
	    		  //alert(ofcArr);
	    		  if(isNull(locArr) || locArr.length < 1){
	    			  //ComShowMessage("Data is not available.");
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.loc_cd.value = "";
	    			  formObj.loc_cd.focus();
	    			  return false;
	    		  }else{
	    			  formObj.vps_port_cd.focus();
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
	    			  return false;
	    		  }else{
	    			  formObj.slan_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="slanCd"){
	    		  formObj.f_cmd.value = COMMAND12;
	    		  var lanXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
	    		  var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
	    		  //alert(lanXml+"|"+strLanCdDesc);
	    		  
	    		  if(isNull(strLanCdDesc)){
	    			  //ComShowMessage("Data is not available.");
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.slan_cd.value = "";
	    			  formObj.slan_cd.focus();
	    			  return false;
	    		  }else{
	    			  formObj.vsl_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="vslCd"){
	    		  formObj.f_cmd.value = SEARCH;
	    		  var vslXml = sheetObj.GetSearchXml("COM_ENS_0A1GS.do", FormQueryString(formObj));
	    		  //alert(vslXml);
	    		  var vslArr = ComOpfXml2Array(vslXml, "vsl_cd");
	    		  //alert(vslArr);
	    		  if(isNull(vslArr) || vslArr.length < 1){
	    			  //ComShowMessage("Data is not available.");
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.vsl_cd.value = "";
	    			  formObj.vsl_cd.focus();
	    			  return false;
	    		  }else{
	    			  formObj.stv_dmg_prt_cate_cd.focus();
	    		  }
	    	  }
	    	  break;
	    }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj){
    	if(ComChkValid(formObj)){
    		return true;
    	}
    	else{
    		return false;
    	}
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

	/* 개발자 작업  끝 */