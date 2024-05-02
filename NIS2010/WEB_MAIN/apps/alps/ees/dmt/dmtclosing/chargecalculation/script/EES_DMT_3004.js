/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3004.js
*@FileTitle : Charge Inquiry by Office Or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.02 황효근
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2013.04.18 임창빈 [CHM-201324214] [DMT] 미주 MT Notification data display 요청
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
     * @class ees_dmt_3004 : ees_dmt_3004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_3004() {
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
	
	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var USR_TRF_TP;
	var SHEET_HEIGHT = 340;
	
	// 버튼 기능 구분을 위한  Action 변수 정의
	var IBDELREQCANCEL = 96;
	

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");
     		
     		// 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
     		if(!ComIsBtnEnable(srcName)) return;

             switch(srcName) {
             	case "btns_calendar": //달력 버튼
             		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');
             		}
					break;
             	case "btns_calendar1": //달력 버튼
					var cal = new ComCalendarFromTo();
					cal.select(formObj.fm_bzc_trf_aply_dt1, formObj.to_bzc_trf_aply_dt1, 'yyyy-MM-dd');
    				break;
    				
                case "btns_calendar2": //달력 버튼
         			 var cal = new ComCalendar();
         		     cal.setDisplayType('month');
         		     cal.select(formObj.cost_yrmon1, 'yyyy-MM');

    				break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObj,formObj,IBSEARCH);
 					break;

 				case "btn_New":
 					doInit();
 					break;
 					
 				case "btn_Minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'inline') {
 						schCondDiv.style.display = 'none';
 						sheetObj.style.height = 508;
 					} else {
 						schCondDiv.style.display = 'inline';
 						sheetObj.style.height = SHEET_HEIGHT;
 					}
 					break;
 				
 				case "btn_DelReqCancel":
 					doActionIBSheet(sheetObj,formObj,IBDELREQCANCEL);
 					break;
 					
 				case "btn_DownExcel":
 					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
 					break;
 					
 				/*default:
 					doProcessPopup(srcName);
 					break;*/
 				case "btn_ByBKG":
 				case "btn_ByCNTR":
 				case "btn_MVMTInq":
 				case "btn_ExceptionInq":
 				case "m_bkg_no":
 				case "m_bl_no":
 				case "m_cntr_no":
 					doProcessPopup(srcName);
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
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}


     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
	function loadPage() {
	    var formObj = document.form;

	    document.all.mvmtDt.style.display = "inline";
        document.all.appDt.style.display   = "none";
        document.all.revMon.style.display   = "none";
        
        document.all.orgConti.style.display = "none";
        document.all.orgLoc.style.display = "inline";
        
        document.all.destConti.style.display = "none";
        document.all.destLoc.style.display = "inline";
        
   	  	for(var i=0;i<sheetObjects.length;i++){
   	  		ComConfigSheet (sheetObjects[i] );
   	  		initSheet(sheetObjects[i],i+1);
   	  		ComEndConfigSheet(sheetObjects[i]);
   	  	}
		 
   	  	setHiddenInitDataProperty ();
		
   	  	// IBMultiCombo초기화 
	 	for(var k=0;k<comboObjects.length;k++){
	 		initCombo(comboObjects[k],k+1);
	 	}
	 
		//html컨트롤 이벤트초기화
		initControl();		
   	  	
	}
      
      
	// 화면 초기화
	function doInit() {
  		var formObj = document.form;
  		
  		sheetObjects[0].CheckAll("chk") = 0;
  		ComResetAll();
  		
  		//조회조건 부분적으로 활성화/비활성화  처리
  		doEnableCondObj("date");
  		
  		//Status 멀티콤보 초기화
  		comboObjects[2].Code = 'F';
  		comboObjects[4].Text = 'All';
  		comboObjects[5].Text = 'All';
  		comboObjects[6].Text = 'All';
  		comboObjects[7].Text = 'All';
  		comboObjects[8].Text = 'All';
  		comboObjects[9].Text = 'All';
  		
  		// Org. & Dest. 초기화
        document.all.orgConti.style.display = "none";
        document.all.orgLoc.style.display = "inline";
        document.all["fm_loc_cd2"].maxLength = "0";
        
        document.all.destConti.style.display = "none";
        document.all.destLoc.style.display = "inline";
        document.all["to_loc_cd2"].maxLength = "0";
        
  		setHiddenInitDataProperty();
  		
  		initBtns();
  	}

     
	function initControl() {
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('mouseover', 'obj_mouseover',	'tdGB');
		axon_event.addListener('mouseout',	'obj_mouseout',		'tdGB');
	}
     
	// onMouseover 이벤트  (버튼 말풍선  보여줌)
    function obj_mouseover() {
    	var msg = '';
    	switch(event.srcElement.id){
     		case 'tdGB':
     			msg = "General/Balance Charge Type";
     			break;
    	}
    		
    	var bak = 'lightyellow';
   	 	var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
   	 	var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x-10;
		skn.top  = y+10;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
    }
    
    // onMouseout 이벤트  (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
	
     
     function condType_click() {
    	 doEnableCondObj(event.srcElement.value);
     }
     
     
     function doEnableCondObj(condType) {
    	 var formObj = document.form;
    	 
    	 with (formObj) {
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, opt_date, yard_fmto[0], yard_fmto[1], yd_cd, org_gubun_cd, fm_loc_cd1, fm_loc_cd2, dest_gubun_cd, to_loc_cd1, to_loc_cd2);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type);	//VVD CD: Disable
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);		//CNTR: Disable
	    	 		DmtComSetClassManyObjects('input', fm_loc_cd1, to_loc_cd1);
	    	 		if (formObj.org_gubun_cd.value == "") {	// fm_loc_cd2 비활성화
	    	 			DmtComSetClassManyObjects('input2', fm_loc_cd2);
	    	 		}
	    	 		if (formObj.dest_gubun_cd.value == "") { // to_loc_cd2 비활성화
	    	 			DmtComSetClassManyObjects('input2', to_loc_cd2);
	    	 		}
	    	 		DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd, bkg_no, bl_no, cntr_no, dem_type); //비활성화 class (input2)
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].Enable = true;	//Date YD
	    	 		//comboObjects[4].Enable = false; //VVD CD YD
	    	 		//===> 검색조건 항목(VVD CD, CNTR) Clear
	    	 		ComSetObjValue(yard_fmto, "yard_fm");
	    	 		ComClearManyObjects(vvd_cd, tmnl_cd, dem_type);		//VVD CD
	    	 		//comboObjects[4].RemoveAll();						//VVD CD
	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		//CNTR
	    	 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    	 		break;
	    	 	case "vvd_cd":
	    	 		ComEnableManyObjects(false, opt_date, yard_fmto[0], yard_fmto[1], yd_cd, fm_loc_cd1, fm_loc_cd2, to_loc_cd1, to_loc_cd2, org_gubun_cd, dest_gubun_cd);
	    	 		ComEnableManyObjects(true, vvd_cd, tmnl_cd, dem_type);
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', vvd_cd); 			//필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no, opt_date, org_gubun_cd, fm_loc_cd1, fm_loc_cd2, dest_gubun_cd, to_loc_cd1, to_loc_cd2);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].Enable = false;		//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		// 검색조건 항목(Date, CNTR) Clear
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, bkg_no, bl_no, cntr_no);	//CNTR
	    	 		setDemType();
	    	 		break;
	    	 	case "cntr":
	    	 		ComEnableManyObjects(false, opt_date, yard_fmto[0], yard_fmto[1], yd_cd, fm_loc_cd1, fm_loc_cd2, to_loc_cd1, to_loc_cd2, org_gubun_cd, dest_gubun_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type);
	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no); //필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', yd_cd, vvd_cd, tmnl_cd, dem_type, opt_date, org_gubun_cd, fm_loc_cd1, fm_loc_cd2, dest_gubun_cd, to_loc_cd1, to_loc_cd2);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].Enable = false;		//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		//===> 검색조건 항목(Date, VVD CD) Clear
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, vvd_cd, tmnl_cd, dem_type);	//VVD CD
	    	 		//comboObjects[4].RemoveAll();							//VVD CD
	    	 		break;
	    	 }
	    	 
	    	 // Period 활성화 처리
	    	 if(condType == 'date') {
	    		 ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar, fm_bzc_trf_aply_dt1, to_bzc_trf_aply_dt1, btns_calendar1);
	    		 DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1, fm_bzc_trf_aply_dt1, to_bzc_trf_aply_dt1);
	    		 
	    		 //Period Date 초기화
	    		 //사용자 Office 의 현재 날짜를 조회한다.
	    		 var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
	    		 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -15);
	    		 var toMvmtDt = ofcCurrDate;
	    		 var revMon =  ComReplaceStr(toMvmtDt, '-', '')
	    	
	    		 ComSetObjValue(fm_mvmt_dt1, fmMvmtDt);
	    		 ComSetObjValue(to_mvmt_dt1, toMvmtDt);
	    		 
	    		 ComSetObjValue(fm_bzc_trf_aply_dt1, fmMvmtDt);
	    		 ComSetObjValue(to_bzc_trf_aply_dt1, toMvmtDt);
	    		 
	    		 ComSetObjValue(cost_yrmon1, revMon.substring(0,4) + "-" + revMon.substring(4, 6) )
	    	 } else {
	    		 ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar, fm_bzc_trf_aply_dt1, to_bzc_trf_aply_dt1, btns_calendar1);
	    		 DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1, fm_bzc_trf_aply_dt1, to_bzc_trf_aply_dt1);
	    		 ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, fm_bzc_trf_aply_dt1, to_bzc_trf_aply_dt1, fm_loc_cd1, fm_loc_cd2, to_loc_cd1, to_loc_cd2);
	    	 }
	    	 
	    	 if(condType == 'cntr') {
	    		 ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 } else {
	    		 ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 }
    	 }
     }
     
     
	function setStatusCombo(condType) {
    	 var comboObj = comboObjects[2];
    	 var orgCode = comboObj.Code;
    	 
    	 if(condType=='date') {
    		 if(comboObj.GetCount() != 5) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 3);
    		 }
    	 } else {
    		 if(comboObj.GetCount() != 4) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 4);
    			 
    			 if(orgCode.indexOf('T') != -1) {
    				 orgCode = ComReplaceStr(orgCode, 'T', 'L');
    				 // 전체선택('All') 항목 체크 처리
    				 if(orgCode == 'F,E,N,D,U,C,I,L,R')
    					 orgCode = 'A,F,E,N,D,U,C,I,L,R';
    			 }
    		 }
    	 }
    	 
    	 comboObj.Code = orgCode;
	}
	

	/**
	 * Hidden Col Setting...
	 * 
	 * @param sheetObj
	 * @param Col
	 * @param colName
	 * @return
	 */
	function setHiddenInitDataProperty(){
		var sheetObj = sheetObjects[0];
		
		sheetObj.ColHidden("op_bkg_no") = true;

		sheetObj.ColHidden("soc_flg") = true;
		sheetObj.ColHidden("li") = true;
		sheetObj.ColHidden("ch") = true;
		sheetObj.ColHidden("d_o") = true;
		sheetObj.ColHidden("rlse_ofc") = true;
		sheetObj.ColHidden("clt_ofc_cd") = true;

		sheetObj.ColHidden("payer_cd") = true;
		sheetObj.ColHidden("payer_nm") = true;
		sheetObj.ColHidden("shipper_cd") = true;
		sheetObj.ColHidden("shipper_nm") = true;
		sheetObj.ColHidden("cnee_cd") = true;
		sheetObj.ColHidden("cnee_nm") = true;
		sheetObj.ColHidden("ntfy_cd") = true;
		sheetObj.ColHidden("ntfy_nm") = true;
		sheetObj.ColHidden("ar_act_cd") = true;
		sheetObj.ColHidden("ar_act_nm") = true;
		sheetObj.ColHidden("svc_provdr_cd") = true;
		sheetObj.ColHidden("svc_provdr_nm") = true;		

		sheetObj.ColHidden("corr_rmk") = true;
	}
	
	// 버튼 상태 초기화
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_DelReqCancel", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
	}
	
   	// IBMultiCombo Office 초기화
   	function initComboValue_office() {
   		comboObjects[0].Enable = true;
   		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
   	}
   	// IBMultiCombo Tariff Type 초기화
   	function initComboValue_tariff_type() {
   		comboObjects[1].Enable = true;
   		comboObjects[1].Code = USR_TRF_TP;
   		ComSetObjValue(document.form.usr_trf_tp, USR_TRF_TP);
   	}
   	// IBMultiCombo Status 초기화
   	function initComboValue_status() {
   		comboObjects[2].Enable = true;
   		ComSetObjValue(comboObjects[2], "F");
   	}
	// IBMultiCombo YardCode2 초기화
   	function initComboValue_yd_cd2() {
   		comboObjects[3].RemoveAll();
   	}
   	
   	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObjects[0].Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND01)
		} else {
			ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
		}
	}
   	
     
     //포커스가 나갈 때
     function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
    	 var obj = event.srcElement;
    	 var formObj = document.form;
    	 
    	 if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    		 
    	 } else if(obj.name == 'tmnl_cd') {
    		 if(obj.value.length > 0 && obj.value.length < 5) {
     			var cdDiv = (obj.name == 'yd_cd') ? 'Yard' : 'Location';
 	 			ComShowCodeMessage('DMT00110', cdDiv);
 	 		 }
    	 } else if(obj.name == 'yd_cd') {
    		 if(obj.value.length > 0 && obj.value.length < 2) {
    			 var cdDiv = (obj.name == 'yd_cd') ? 'Yard' : 'Location';
  	 			ComShowCodeMessage('DMT00110', cdDiv);
  	 		 }
    	 } else {
    		 ComChkObjValid(obj);
    	 }
      }
     
     /**
      * HTML Control Foucs in
      */
     function obj_focus(){
    	 var obj = event.srcElement;
         ComClearSeparator(obj);
         
         //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
         if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
     }
     
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	// 영문대+숫자+예외문자
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
     
	
	/*
	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation을 위한 KeyUp 이벤트 처리 함수
	 */
	function obj_keyup() {
		var srcObj = event.srcElement;
		checkLocYdCd(srcObj);
	}
	
	/*
	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation 처리 함수
	 */
	function checkLocYdCd(srcObj) {
		var formObj = document.form;
		var cd = ComTrim(ComGetObjValue(srcObj));
		
		if (cd.length == 5) {
			//var comboObj = (srcObj.name == 'yd_cd') ? comboObjects[3]:comboObjects[4];
			var comboObj = comboObjects[3];
			
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value = cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				
				if(comboObj.GetCount() == 0) {
					formObj.loc_cd.value = cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.tmnl_cd);
				}
			} else {
				formObj.loc_cd.value = cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
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

		switch(sheetNo) {
			case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = SHEET_HEIGHT;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 7, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(85, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);
                     
                     // Ctrl키를 눌러 다중행 선택가능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;

                     var HeadTitle1 = " ||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|Tariff|F/T|Over|Overdue|From DT|To DT|MT DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT";
			 			HeadTitle1 += "|Billable AMT|BKG No.|OP BKG No.|B/L No.|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|G/B|UC|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No|ISS DT";
			 			HeadTitle1 += "|INV Cur.|Billing AMT|A/R|AR I/F DT|AFT DAR No.|AFT DAR Status|Inactive No.|Inactive Status|ADL|CDDL|WEB|Web M'ty|Grace End|PIC Name|Payer CD|Payer Name|SHPR CD|Shipper Name|CNEE CD|Cosignee Name|NTFY CD|Notify Name";
			 			HeadTitle1 += "|A/R Cust.|A/R Actual Payer Name|S/P CD|Service Provider Name|Remark(s)|||Cyc No|BKG Cyc No";
			 			
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	30,	daCenter,	true,	"chk");
					InitDataProperty(0, cnt++ , dtSeq,		40,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"dmdt_chg_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"cntr_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"ofc_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"to_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"fm_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"to_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"dmdt_trf_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ft_dys",			false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"fx_ft_ovr_dys",	false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	60,	daCenter,	true,	"ovr_due",			false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"to_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"mt_dt",			false,	"",		dfDateYmd,		0,	false,	true, -1, false, true, "Actual MT Movement Date");
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_cmnc_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_end_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"bzc_trf_curr_cd",	false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	90,	daRight,	true,	"org_chg_amt",		false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,daRight,	true,	"sc_rfa_expt_amt",	false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daRight,	true,	"aft_expt_dc_amt",	false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"bil_amt",			false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		100,daCenter,	true,	"bkg_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		100,daCenter,	true,	"op_bkg_no",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"bl_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"vvd_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"lane",				false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"por_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pol_cd",			false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pod_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"del_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_rcv_term_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_de_term_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"sc_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"rfa_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"chg_type",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "General/Balance Charge Type");
					//컬럼추가
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"uclm_flg",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Uclaimed Cargo Flag");
					//컬럼추가
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"soc_flg",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"li",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Local/Intransit DEM Type");
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ch",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Carrier's Haulage");
					
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"d_o",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release");
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"rlse_ofc",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release Office");
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"clt_ofc_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ofc_trns_flg",		false,	"",		dfNone,			0,	false,	true, -1, false, true, "Office Transferred");
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"roll_ovr",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Roll Over due to Customs or Customer Request");
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"dmdt_inv_no",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"iss_dt",			false,	"",		dfDateYmd,		0,	false,	false);	
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"inv_curr_cd",		false,	"",		dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"inv_chg_amt",		false,	"",		dfNullFloat,	2,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"dmdt_ar_if_cd",	false,	"",		dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ar_if_dt",			false,	"",		dfDateYmd,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,     120,daCenter,	true,	"aft_expt_dar_no", 	false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,     100,daCenter,	true,	"dmdt_expt_rqst_sts_cd_desc", 	false,	"",		dfNone,			0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtData,     120,daCenter,	true,	"inact_rqst_no", 	false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,     100,daCenter,	true,	"inact_sts_mn", 	false,	"",		dfNone,			0,	false,  false);
					
	                InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	"x1_dt",			false,	"",		dfDateYmd,		0,	false,	false);	// 2014.09.16 Added
	                InitDataProperty(0, cnt++ , dtData,  	80,	daCenter,	true,	"cd_dt",			false,	"",		dfDateYmd,		0,	false,	false);	// 2014.09.16 Added
	                
	                InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"web_ind_flg",		false,	"",		dfNone,			0,	false,	false, -1, false, true, "Web Empty Notification");
	                InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"web_cre_dt",		false,	"",		dfDateYmd,		0,	false,	false, -1, false, true, "Web Empty Notified Date");
	                InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"web_mty_dt",		false,	"",		dfDateYmd,		0,	false,	false, -1, false, true, "Grace Period End Date");
	                InitDataProperty(0, cnt++ , dtData,    100,	daLeft,  	true,	"web_ntfy_pic_nm",	false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"payer_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"payer_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"shipper_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"shipper_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"cnee_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"cnee_nm",			false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ntfy_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ntfy_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ar_act_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ar_act_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"svc_provdr_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"svc_provdr_nm",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"corr_rmk",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"svr_id",			false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"chg_seq",			false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"cntr_cyc_no",		false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"bkg_cntr_cyc_no",	false,  "",		dfNone,			0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_chg_loc_div_cd",   false, "",	dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_delt_rqst_sts_cd", false, "",	dfNone,			0,	false,  false);

					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_expt_rqst_sts_cd", false, "",	dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_expt_rqst_sts_color", false, "",	dfNone,			0,	false,  false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("cntr_tpsz_cd");
					ToolTipOption="balloon:true;width:50;";
					Ellipsis = true;
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
   		var i=0;
   	    var formObj = document.form;
   	    var arrDmdtCntrTpCdText = f_dmdt_cntr_tp_cdText.split("|");
   	    var arrDmdtCntrTpCdCode = f_dmdt_cntr_tp_cdCode.split("|");
   	    var arrDmdtBkgCgoTpCdText = f_dmdt_bkg_cgo_tp_cdText.split("|");
   	    var arrDmdtBkgCgoTpCdCode = f_dmdt_bkg_cgo_tp_cdCode.split("|");
   	    var arrBkgRcvTermCdText = f_bkg_rcv_term_cdText.split("|");
	    var arrBkgRcvTermCdCode = f_bkg_rcv_term_cdCode.split("|");
	    var arrBkgDeTermCdText = f_bkg_de_term_cdText.split("|");
	    var arrBkgDeTermCdCode = f_bkg_de_term_cdCode.split("|");
	    var arrFmMvmtStsCdText = f_fm_mvmt_sts_cdText.split("|");
	    var arrFmMvmtStsCdCode = f_fm_mvmt_sts_cdCode.split("|");
	    
   	    switch(comboObj.id) {
		   	 case "dmdt_cntr_tp_cd":
		   		 
					with(comboObj) {
						DropHeight=200;
						MultiSelect = true;
						MultiSeparator=",";
						UseEdit = false;
						SetColWidth("100");
						InsertItem(i++,  "All",  "");
						for (j=0; j<arrDmdtCntrTpCdText.length; j++){
							InsertItem(i++,  arrDmdtCntrTpCdText[j],  arrDmdtCntrTpCdCode[j]);
						}
		     	}
					break;
			
		   	 case "dmdt_bkg_cgo_tp_cd":
		   		 
					with(comboObj) {
						DropHeight=200;
						MultiSelect = true;
						MultiSeparator=",";
						UseEdit = false;
						SetColWidth("130");
						InsertItem(i++,  "All",  "");
						for (j=0; j<arrDmdtBkgCgoTpCdText.length; j++){
							InsertItem(i++,  arrDmdtBkgCgoTpCdText[j],  arrDmdtBkgCgoTpCdCode[j]);
						}
		     	}
					break;
				
		   	case "bkg_rcv_term_cd":
		   		 
				with(comboObj) {
					DropHeight=200;
					MultiSelect = true;
					MultiSeparator=",";
					UseEdit = false;
					SetColWidth("80");
					InsertItem(i++,  "All",  "");
					for (j=0; j<arrBkgRcvTermCdText.length; j++){
						InsertItem(i++,  arrBkgRcvTermCdText[j],  arrBkgRcvTermCdCode[j]);
					}
	     	}
				break;
				
		   	case "bkg_de_term_cd":
		   		 
				with(comboObj) {
					DropHeight=200;
					MultiSelect = true;
					MultiSeparator=",";
					UseEdit = false;
					SetColWidth("80");
					InsertItem(i++,  "All",  "");
					for (j=0; j<arrBkgDeTermCdText.length; j++){
						InsertItem(i++,  arrBkgDeTermCdText[j],  arrBkgDeTermCdCode[j]);
					}
	     	}
				break;
				
		   	 case "fm_mvmt_sts_cd":
		   		 
					with(comboObj) {
						DropHeight=400;
						MultiSelect = true;
						MultiSeparator=",";
						UseEdit = false;
						InsertItem(i++,  "All",  "");
						InsertItem(i++,  "N/A",  "N/A");
						for (j=0; j<arrFmMvmtStsCdCode.length; j++){
							InsertItem(i++,  arrFmMvmtStsCdCode[j],  arrFmMvmtStsCdCode[j]);
						}
		     	}
					break;
		   	 case "to_mvmt_sts_cd":
		   		 
					with(comboObj) {
						DropHeight=400;
						MultiSelect = true;
						MultiSeparator=",";
						UseEdit = false;
						InsertItem(i++,  "All",  "");
						InsertItem(i++,  "N/A",  "N/A");
						for (j=0; j<arrFmMvmtStsCdCode.length; j++){
							InsertItem(i++,  arrFmMvmtStsCdCode[j],  arrFmMvmtStsCdCode[j]);
						}
						
		     	}
					break;  
		   	case "opt_item_list":
		   		 
				with(comboObj) {
					DropHeight=400;
					MultiSelect = true;
					MultiSeparator=",";
					UseEdit = false;
					InsertItem(i++,  "BKG infor",  "BKG_INFO");
					InsertItem(i++,  "Customer infor",  "CUST_INFO");
					InsertItem(i++,  "Remarks",  "CORR_INFO");
					InsertItem(i++,  "OP BKG nbr (Only O/B DET)",  "OP_BKG_INFO");
				}
				
				break;  
   	    	case "office": 
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					
  					ValidChar(2, 2);	// 영어대문자 사용
   		    	}
   				break; 
   				
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = true;
					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
   		    	}
   				break; 
   				
   	    	case "status":
   	    		with (comboObj) { 
   	    			if(comboNo==3) {
	   					MultiSelect = true;
						SetColAlign("left|left");        
						SetColWidth("110|150");
						DropHeight = 190;
						ColBackColor(0) = "#CCFFFD";
	  					ColBackColor(1) = "#CCFFFD";
						addComboItem(comboObj, comboNo);
						//Code = "F";
   	    			} else {
   	    				MultiSelect = true;
   						SetColAlign("left");        
   						SetColWidth("120");
   						DropHeight = 170;
   						ColBackColor(0) = "#CCFFFD";
   						addComboItem(comboObj, comboNo);
   						//Code = "F";
   	    			}
   		    	}
   	    		break;
   	    		
   	    	case "yd_cd2":
   	    	case "tmnl_cd2":
   	    		with (comboObj) { 
   	    			MultiSelect = false; 
  					UseAutoComplete = true;
	    			SetColAlign("left");
	    			SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
   	    		

	   	    	//status
	  	    case "inact_sts": 
		        	with (comboObj) {
	                    MultiSelect = true; 
	                    UseAutoComplete = true; 
						SetColAlign("left|left");
						SetColWidth("40|120");
	                    DropHeight = 190;
						ValidChar(2,2);		//영문 대문자
						IMEMode = 0;
			    	}  	        	  
					break;   
		  	 
	  	    case "aft_dar_sts": 
		        	with (comboObj) {
	                  MultiSelect = true; 
	                  UseAutoComplete = true; 
						SetColAlign("left|left");
						SetColWidth("40|120");
	                  DropHeight = 190;
						ValidChar(2,2);		//영문 대문자
						IMEMode = 0;
			    	}  	        	  
					break;    
   	     }
   	}
   	
	
	function dmdt_cntr_tp_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function dmdt_bkg_cgo_tp_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function bkg_rcv_term_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function bkg_de_term_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function fm_mvmt_sts_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	function opt_item_list_OnCheckClick(comboObj, index, code) {
		var sheetObj = sheetObjects[0];
		if( code == "BKG_INFO" ){
			if( comboObj.CheckIndex(0) == false ){
				sheetObj.ColHidden("soc_flg") = true;
				sheetObj.ColHidden("li") = true;
				sheetObj.ColHidden("ch") = true;
				sheetObj.ColHidden("d_o") = true;
				sheetObj.ColHidden("rlse_ofc") = true;
				sheetObj.ColHidden("clt_ofc_cd") = true;
				sheetObj.ColHidden("cntr_cyc_no") = true;	
				sheetObj.ColHidden("bkg_cntr_cyc_no") = true;				
			} else {
				sheetObj.ColHidden("soc_flg") = false;
				sheetObj.ColHidden("li") = false;
				sheetObj.ColHidden("ch") = false;
				sheetObj.ColHidden("d_o") = false;
				sheetObj.ColHidden("rlse_ofc") = false;
				sheetObj.ColHidden("clt_ofc_cd") = false;
				sheetObj.ColHidden("cntr_cyc_no") = false;
				sheetObj.ColHidden("bkg_cntr_cyc_no") = false;	
			}
		}
		else if( code == "CUST_INFO" ){
			if( comboObj.CheckIndex(1) == false ){
				sheetObj.ColHidden("payer_cd") = true;
				sheetObj.ColHidden("payer_nm") = true;
				sheetObj.ColHidden("shipper_cd") = true;
				sheetObj.ColHidden("shipper_nm") = true;
				sheetObj.ColHidden("cnee_cd") = true;
				sheetObj.ColHidden("cnee_nm") = true;
				sheetObj.ColHidden("ntfy_cd") = true;
				sheetObj.ColHidden("ntfy_nm") = true;
				sheetObj.ColHidden("ar_act_cd") = true;
				sheetObj.ColHidden("ar_act_nm") = true;
				sheetObj.ColHidden("svc_provdr_cd") = true;
				sheetObj.ColHidden("svc_provdr_nm") = true;	
			} else {
				sheetObj.ColHidden("payer_cd") = false;
				sheetObj.ColHidden("payer_nm") = false;
				sheetObj.ColHidden("shipper_cd") = false;
				sheetObj.ColHidden("shipper_nm") = false;
				sheetObj.ColHidden("cnee_cd") = false;
				sheetObj.ColHidden("cnee_nm") = false;
				sheetObj.ColHidden("ntfy_cd") = false;
				sheetObj.ColHidden("ntfy_nm") = false;
				sheetObj.ColHidden("ar_act_cd") = false;
				sheetObj.ColHidden("ar_act_nm") = false;
				sheetObj.ColHidden("svc_provdr_cd") = false;
				sheetObj.ColHidden("svc_provdr_nm") = false;		
			}
		}
		else if( code == "CORR_INFO" ){
			if( comboObj.CheckIndex(2) == false ){
				sheetObj.ColHidden("corr_rmk") = true;
			} else {
				sheetObj.ColHidden("corr_rmk") = false;
			}
		}
		else if( code == "OP_BKG_INFO" ){
			if( comboObj.CheckIndex(3) == false ){
				sheetObj.ColHidden("op_bkg_no") = true;
			} else {
				sheetObj.ColHidden("op_bkg_no") = false;
			}
		}		
		 
	}	
    
	function to_mvmt_sts_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "All";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	
	
   	/**
   	 * Sheet관련 프로세스 처리
   	 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      //조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
            	formObj.f_cmd.value = SEARCH;
            	
            	/*** 주의 ***
            	Office 콤보리스트에 없는 코드도 입력가능하고 조회도 가능하게 해야 하므로,
           		선택Item의 Code값이 아닌 Text값으로 hidden필드 세팅
            	*/
            	formObj.ofc_cd.value = comboObjects[0].Text;
            	
            	//Tariff Type
            	var trf_tp = comboObjects[1].Code;
            	if(trf_tp.indexOf('All') != -1)
            		trf_tp = ComReplaceStr(trf_tp, "All,", "");
            	
            	var chgStsCd = comboObjects[2].Code;
            	if(chgStsCd.indexOf('A') != -1)
            		chgStsCd = ComReplaceStr(chgStsCd, "A,", "");
            	
            	formObj.dmdt_trf_cd.value = trf_tp;
            	formObj.dmdt_chg_sts_cd.value = chgStsCd;
            	if(formObj.fx_ft_ovr_dys.value == '') formObj.fx_ft_ovr_dys.value='0';

            	formObj.inact_sts_cd.value = comboObjects[11].Code;
            	formObj.aft_dar_sts_cd.value = comboObjects[12].Code;
            	
            	sheetObj.DoSearch("EES_DMT_3004GS.do", FormQueryString(formObj));	// + "&" + ComGetPrefixParam(prefix));
            	ComOpenWait(false);
            	
            	for (var j=1; j<=sheetObj.RowCount; j++) {
	   		        var deltRqstStsCd = sheetObj.CellValue(j,"dmdt_delt_rqst_sts_cd");
	   		          
	   		        // 1. 파랑색 : Charge Deletion 요청한 상태로 Charge Deletion 취소가 가능한 상태입니다.(승인처리가 전혀 이루어지지 않은 상태임)
	   		        if (deltRqstStsCd == 'R') {
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(30,144,255);
	   		            sheetObj.CellFont("FontBold", j, 3) = true;	   		        	
	   		        }
	   		        // 2. 분홍색 : Charge Deletion 요청에 대해서 승인처리가 진행중인 상태로 Charge Deletion 취소가 불가한 상태입니다.
	   		        else if (isProcessingInactive(deltRqstStsCd)) {
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,100,255);
	   		            sheetObj.CellFont("FontBold", j, 3) = true;
	   		        }
	   		        // 3. 녹색 : Charge Deletion 요청에 대해서 필수최종승인단계까지의 처리가 완료된 상태입니다.
	   		        else if (deltRqstStsCd == 'X') {
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(207,240,88);
	   		        	sheetObj.CellFont("FontBold", j, 3) = true;
	   		        } 	   		        
	   		        // 4. 빨간색 : 기존 상태값으로 Charge Deletion 요청에 대해서 취소한 상태입니다.
	   		        else if (isProcessingInactiveReject(deltRqstStsCd)) {
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,0,0);
	   		        	sheetObj.CellFont("FontBold", j, 3) = true;
	   		        } 
	   		        // 5. 검정색 : 그 이외의 상태입니다.
	   		        else { 
	   		              sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(0,0,0); 
	   		              sheetObj.CellFont("FontBold", j, 3) = false;	 
	   		        }
	   		        // AFT DAR 상태별 색상 추가
	   		        var aftDarStsColor = sheetObj.CellValue(j,"dmdt_expt_rqst_sts_color");
	   		        switch(aftDarStsColor) {
	   		        case 'BLUE':
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(30,144,255);
	   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
//	   		        	sheetObj.RowFontColor(j) = sheetObj.RgbColor(30,144,255);
	   		        	break;
	   		        case 'RED':
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,0,0);
	   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
	   		        	break;
	   		        case 'PINK':
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,100,255);
	   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
	   		        	break;
	   		        case 'BLACK':
	   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(0,0,0);
	   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
	   		        	break;
	   		        }
		        }
            	
            break;
            
            case SEARCH21:	// Change Office에 대한 RHQ Office Code를 조회
            	
            	sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH21;
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				 
				formObj.cng_rhq_ofc_cd.value = ComGetEtcData(sXml, "CNG_RHQ_OFC_CD");

				// US Office 여부에 따라서, ADL, CDDL 조회를 실행한다. 2014.09.20
				if (ComGetObjValue(formObj.cng_rhq_ofc_cd) == "NYCRA") {
					ComSetObjValue(formObj.us_ofc_yn, "Y");
				}
				else {
					ComSetObjValue(formObj.us_ofc_yn, "N");
				}
				
				if(formObj.cng_rhq_ofc_cd.value == 'SELHO' || formObj.cng_rhq_ofc_cd.value == 'NYCRA') {
		   	  		ComSetDisplay('cs_webmt_chk', true);
		   	  		SHEET_HEIGHT = 310;
		   	  	}				
				
            	ComOpenWait(false);
 			break;
 				
            case IBDELREQCANCEL:	// Delete Cancel
            	if (!validateForm(sheetObj,formObj,sAction)) return;
				 
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("EES_DMT_3004GS.do", FormQueryString(formObj), "chk");
				ComOpenWait(false);
			break;
         }
     }

     
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
    	 sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
    	 switch(comboObj.id) {
 	       case "office":
 	    	   
	 	      formObj.f_cmd.value = formCmd;
	 	      var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	 	      
 	    	   if(formCmd == SEARCHLIST02) {
	 	    	   	// Office List
					var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
					
					if (ofc_cds != undefined && ofc_cds != '') {
						var comboCodeArr = ofc_cds.split("|");
			    	    var comboTextArr = ofc_nms.split("|");
			    	    
			    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
		    	  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
		    	  		var idx = 0; 
		    	  		
			    	    if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			    	    	comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
			    	    	idx = 1;
			    	    }
			    	    
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
			    	    
			    	    comboObj.Code = usr_ofc_cd;
					}
	    	  		
 	    	   } else { // formCmd == COMMAND01 (Incl. Sub Office)
 	    		   	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
 	    	   			var arrOfcCd = subOfcCds.split(',');
 	    	   			var str = '';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {
 	    	   				var idx = comboObj.FindIndex(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str = str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str = str.substring(1);
 	    	   			
 	    	   			// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
 	    	   			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
 	    	   			if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str = usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.Code = str;
 	    			 }
 	    	   }
    	 		break;
 	        	
 	        case "tariff_type":
  	    	   
 		 	    formObj.f_cmd.value = formCmd;
 		 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 		 	      
 		 		// Tariff type comboList
 				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems = data.split(ROWMARK);
 					addComboItem(comboObj,comboItems);
 				}
 				
 				if ( formObj.usr_rhq_ofc_cd.value == "NYCRA" ) {
 					// [CHM-201324396] 미주 지역일 경우. 2013.05.07
 					// 미주 지역일 경우 하나만 Tariff Type 를 선택하도록 한다.
 					data2 = 'DMIF';
 					
 				} else {
 				
	 				// User별 Tariff Type Set-Up 값 조회
	 				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
	 				
	 				// User별 Tariff Type Set-Up 값이 없을 경우 Default값으로 세팅.
	 				if(data2 == '') data2 = 'CTIC,DMIF';
 				
 				}
 				
 				// Tariff Type IBMultiCombo 초기값 설정
 				comboObj.Code = data2;
 				
 				// IBMultiCombo Tariff Type 초기화 함수(initComboValue_tariff_type())에서 사용하기 위해 전역변수(USR_TRF_TP)에 세팅
 				USR_TRF_TP = data2;
 				
 				formObj.usr_trf_tp.value = data2;
 				break;
 				
 	        case "yd_cd2":
 	        //case "tmnl_cd2":
  	    	   
 		 	    formObj.f_cmd.value = formCmd;
 		 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 		 	      
 	        	var comboDatas;
 	        	var chkObj;
 	        	var condType = ComGetObjValue(formObj.cond_type);
 	        	
 	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();			
	 	        	chkObj = formObj.chk_yd_cd;
	 	        	comboDatas = ComGetEtcData(sXml, "YD");
 	        	} else {
 	        		if(condType == 'date')
 	        			chkObj = formObj.chk_yd_cd;
 	        		else
 	        			chkObj = formObj.chk_loc_cd;
 	        		
 	        		comboDatas = ComGetEtcData(sXml, "LOC_CD");
 	        	}
				
				if (comboDatas != undefined && comboDatas != '') {
					ComSetObjValue(chkObj, "Y");
					if(srcObj.name == 'yd_cd') {
						comboItems = comboDatas.split(ROWMARK);
						addComboItem(comboObj, comboItems);
					}
				} else {
					if(srcObj.name == 'yd_cd') {
						sheetObj.WaitImageVisible = true;
						return;
					}
					
					ComSetObjValue(chkObj, "N");
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
 	        	break;

	    	case "inact_sts":
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, formCmd); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 var comboItems = ComGetEtcData(sXml, "chg_delt_proc_sts").split(ROWMARK);
	        	 addComboItem(comboObj, comboItems);
	        	 break;
	        	 
	    	case "aft_dar_sts":

	        	 var comboItems = ['All=All', 'A=Approved', 'R=Requested', 'P=Process', 'RC=Rejected/Counter offer'];
	        	 addComboItem(comboObj, comboItems);

	        	 break;

         }
         sheetObj.WaitImageVisible = true;
     }

     
     /**
      * 콤보필드에 데이터를 추가해준다.
      */	
  	function addComboItem(comboObj,comboItems) {
  		var formObj = document.form;
  		
  		switch(comboObj.id) {
  			case "tariff_type":
  				
  				var j = 0;
  				
  				if ( formObj.usr_rhq_ofc_cd.value == "NYCRA" ) {
  					// [CHM-201324396] 미주 지역일 경우. 2013.05.07
  					// 미주 지역은 ALL Item를 사용하지 못하도록 한다.
  					j = 0;
  				} else {
  					comboObj.InsertItem(0, "All|All", "All");
  					j = 1;
  				}
  				
  				for (var i = 0 ; i < comboItems.length ; i++) {
  					var comboItem = comboItems[i].split(FIELDMARK);
  					
  					comboObj.InsertItem(i+j, comboItem[0] + "|" + comboItem[1], comboItem[0]);
  				}
  				
		  		break;
		  		
  			case "status":
  				if(comboItems == 3) {
	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished|To Date", "F");
	  				comboObj.InsertItem(2, "Long Staying|From Date", "L");
	  				comboObj.InsertItem(3, "System Error|From Date/To Date", "E");
	  				comboObj.InsertItem(4, "No Charge|To Date", "N");
	  				//comboObj.InsertItem(5, "Deleted|From Date", "D");
	  				comboObj.InsertItem(5, "D / Inactive|From Date", "D");
	  				comboObj.InsertItem(6, "Unfinished|From Date", "U");
	  				comboObj.InsertItem(7, "Confirmed|To Date", "C");
	  				comboObj.InsertItem(8, "Invoiced|To Date", "I");
	  				comboObj.InsertItem(9, "US Inland Delivery", "R");
	  				comboObj.InsertItem(10, "All Long Staying|Regardless of Date", "T");
  				} else {
  					comboObj.InsertItem(0, "All", "A");
  	  				comboObj.InsertItem(1, "Finished", "F");
  	  				comboObj.InsertItem(2, "Long Staying", "L");
  	  				comboObj.InsertItem(3, "System Error", "E");
	  	  			comboObj.InsertItem(4, "No Charge", "N");
	  				//comboObj.InsertItem(5, "Deleted", "D");
	  	  			comboObj.InsertItem(5, "D / Inactive", "D");
	  				comboObj.InsertItem(6, "Unfinished", "U");
	  				comboObj.InsertItem(7, "Confirmed", "C");
	  				comboObj.InsertItem(8, "Invoiced", "I");
	  				comboObj.InsertItem(9, "US Inland Delivery", "R");
  				}
  				break;
  				
  			case "yd_cd2":
  			case "tmnl_cd2":
  				for (var i = 0 ; i < comboItems.length ; i++) {
  		    		var comboItem = comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
  		    	}
  				break;

  			case "inact_sts":
  				for (var i = 0 ; i < comboItems.length ; i++) {
  		    		var comboItem = comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[0], comboItem[0]);		
  		    	}  
  				break;
  				
  			case "aft_dar_sts":
  				for (var i = 0 ; i < comboItems.length ; i++) {
  		    		var comboItem = comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[0], comboItem[0]);		
  		    	}  
  				break;
  		}
  	}
  	
  	
  	/**
  	 * Tariff Type 선택값에 따른 DEM Type 선택항목 활성화/비활성화 처리
  	 */
  	function setDemType() {
  		var formObj = document.form;
  		
  		with(formObj) {
	  		if(ComGetObjValue(cond_type) != 'vvd_cd') return;
	  		
	  		var trf_tp = comboObjects[1].Code;
	  		if(trf_tp.indexOf('DMIF') != -1 || trf_tp.indexOf('DMOF') != -1) {
	  			ComEnableObject(dem_type, true);
	  			dem_type.className = 'input';
	  			ComClearObject(dem_type);
	  		} else {
	  			ComEnableObject(dem_type, false);
	  			dem_type.className = 'input2';
	  			ComClearObject(dem_type);
	  		}
  		}
  	}
  	
  	
	//멀티콤보 클릭 이벤트
	function tariff_type_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		
		if ( formObj.usr_rhq_ofc_cd.value == "NYCRA" ) {
			// [CHM-201324396] 미주 지역일 경우. 2013.05.07
			for(var i = 0 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = false;
	    	}
			
			comboObj.CheckIndex(index) = true;
		} else {
		    if(index==0) {
		    	var bChk = comboObj.CheckIndex(index);
	    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	    			comboObj.CheckIndex(i) = bChk;
		    	}
		    } else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
		    } else if(comboObj.Code == 'DMIF,DTIC,DMOF,DTOC,CTIC,CTOC') {
		    	comboObj.CheckIndex(0) = true;
		    }
		}
	    setDemType();
	}
	
	function status_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.Code;
		var formObj = document.form;
		
		if(codes.indexOf('L')!=-1 && codes.indexOf('T')!=-1) {
			ComShowCodeMessage('DMT01067');
			comboObj.CheckIndex(index) = false;
			return;
		}
		
		var formObj = document.form;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All
					comboObj.Code = "A,F,L,E,N,D,U,C,I,R";
				else
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			} else if(codes == 'F,L,E,N,D,U,C,I,R') {
				comboObj.CheckIndex(0) = true;
			}
			
			// [CHM-201324396] 미주 지역일 경우. 2013.05.07
			if ( formObj.usr_rhq_ofc_cd.value == "NYCRA" ) {
				if( code == 'N' ) {
					if (comboObj.CheckIndex(index) == true) {
						// N 만 선택 가능
						for(var i = 0 ; i < comboObj.GetCount() ; i++) {
			    			comboObj.CheckIndex(i) = false;
				    	}
						comboObj.CheckIndex(index) = true;
					} 
				} else {
					// N 과 동시에 선택될 경우 N 를 제외
					for(var i = 0 ; i < comboObj.GetCount() ; i++) {
						if ( (comboObj.GetIndexText(i, 0) == "No Charge") && (comboObj.CheckIndex(i) == true )) {
							comboObj.CheckIndex(i) = false;
							break;
						}
			    	}
				}
			}
			
			if(codes == '' || codes == 'T') {	//전체 미선택 or All Long Statying --> 날짜,달력아이콘 비활성
				ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
				DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
			} else {
				if(ComGetObjValue(cond_type) == 'date') {
					ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
					DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
				}
			}
		}
	}
	
	
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
  	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		var sheetObj = sheetObjects[0];
		//sheetObjects[0].WaitImageVisible = false;
  		
  		// Office MultiCombo List조회
  		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST02);
  		
  		// Tariff Type MultiCombo List조회
		doActionIBCombo(sheetObj, formObj, comboObjects[1], SEARCHLIST);
 		
 		doActionIBCombo(sheetObj, formObj, comboObjects[11], SEARCH03);	//DEL Process Status
 		doActionIBCombo(sheetObj, formObj, comboObjects[12], '');	//AFT DAR Status
		
		// 조회조건 초기화
		doInit();
        //sheetObjects[0].WaitImageVisible = true;
		
		// Change Office의 RHQ Office 정보를 조회
   	  	doActionIBSheet(sheetObj, formObj, SEARCH21);	
   	  	
   	  	var cngRhqOfcCd = ComGetObjValue(formObj.cng_rhq_ofc_cd);
   	  	
		if(cngRhqOfcCd != 'NYCRA') {
			// 비 미주지역 로그인시 그리드의 해당 컬럼을 숨김.
			with(sheetObj) {
//				ColHidden("mt_dt")			= true;
				ColHidden("web_ind_flg")	= true;
				ColHidden("web_cre_dt")		= true;
				ColHidden("web_mty_dt")		= true;
				ColHidden("web_ntfy_pic_nm")= true;
				
				// ADL, CDDL 컬럼은 NYCRA 에서만 보여준다. 2014.09.20
				ColHidden("x1_dt")			= true;
				ColHidden("cd_dt")			= true;
			}
		}
  	}
	
	
  	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "chk")) {
                        	// 토글 기능
                            CellValue2(arr[i], "chk") = (CellValue(arr[i], "chk") == '0') ? "1" : "0";
                        }
                    }
                    
                    // AllCheck box 상태 동기화
                    HeadCheck(0, "chk") = (CheckedRows("chk") == RowCount);
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
  	
	
	/**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form;
		with(formObj) {
			sheetObj.CheckAll("chk") = 0;
			
  			// 결과데이터가 없을경우, 검색조건 입력데이터 유지
        	if(sheetObj.SearchRows == 0) {
        		initBtns();
        	} else {
    			// 버튼 활성화
    			DmtComEnableManyBtns(true, "btn_DelReqCancel", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
    			
    			// 페이지 접근 권한정보
    			var rolePermit	= sheetObj.EtcData("ROLE_PERMIT");
    			var roleAuth	= sheetObj.EtcData("ROLE_AUTH");
    			ComSetObjValue(role_permit, rolePermit);
    			ComSetObjValue(role_auth,	roleAuth);
  			}
        	
		} // with end
  	}
	
	
	/*
	 * Grid에서 말풍선 처리
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			Col = MouseCol;
			if (Row > 0) {
				var ttText='';
				var colSaveNm = ColSaveName(Col);
				
				if(colSaveNm == 'corr_rmk') {	// Remark 전체내용을 보여줌
					var corrRmk = CellValue(Row, "corr_rmk");
					if(corrRmk == '') return;
					ttText = corrRmk;
				}
				else if(colSaveNm == 'x1_dt') {
					ttText = "Arrival at Delivery Location";
				}
				else if(colSaveNm == 'cd_dt') {
					ttText = "Carrier Departed from Delivery Location";
				}
				MouseToolTipText = ttText;
			} else {
				MouseToolTipText = "";
			}
		}
	}
	
	
	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		 if(ErrMsg != '') {	// 저장 오류 발생
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			 // Retrieve 수행
			 doActionIBSheet(sheetObj,document.form,IBSEARCH);
		 }
    }
    
    
    /**
	 * 선택된 Row의 해당정보를 EES_DMT_3003.do 페이지로 전달해서 팝업으로 호출한다.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		
		doProcessPopup('btn_ByCNTR', Row);
	}
    
    
	// 멀티콤보 Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
 	
 	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
    }
    
    /*
  	 * Service Provider Inquiry 공통팝업 호출
  	 */
    function getSvcProvdr(aryPopupData) {
    	document.form.svc_provdr.value = aryPopupData[0][2];
    }
    
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    
    
  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(srcName, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
	  				return;
					break;
				
	  			case 'svc_provdr':	// Service Provider Popup
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				return;
					break;
					
	  			case 'm_bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'm_bl_no':			// B/L No. 멀티입력 팝업 호출
	  			case 'm_cntr_no':		// CNTR No. 멀티입력 팝업 호출
	  				var flag = ComReplaceStr(srcName,"m_","");
	  			
			  		// 멀티입력 팝업 타이틀 세부 내용 지정
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				return;
					break;
             	
	  			case 'btn_ByBKG':
	  				var chkRow = SelectRow;
	  				
		  			var bkgNo		= CellValue(chkRow , "bkg_no");
		  			var blNo		= CellValue(chkRow , "bl_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal	= "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
		  			
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl = 'EES_DMT_3002P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl = 'EES_DMT_3005P.do' + paramVal;
		  			}
		  			
	  				sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  			
	  			case 'btn_ByCNTR':
	  				var chkRow = SelectRow;
		  			
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl = 'EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl = 'EES_DMT_3006P.do' + paramVal;
		  			}
		  			
	  				sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  				
	  			case 'btn_MVMTInq':
	  				if(SearchRows == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				
	  				var inqRow = 0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows = FindCheckedRow("chk").split("|");
	  					inqRow = chkRows[0];
	  				} else if(SelectRow > 0) {
	  					inqRow = SelectRow;
	  				}
	  				
	  				var cntrNo = CellValue(inqRow , "cntr_no");
	  				var cntrTpszCd = CellValue(inqRow , "cntr_tpsz_cd");
	  				var paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '690';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
  	
    
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    		 
         with(formObj){
        	 switch(sAction) {
             	case IBSEARCH:      //조회
             		
             		// Office Combo Check
             		if(comboObjects[0].Text == '') {
             			ComShowCodeMessage('COM12113', "Office");
             			return false;
             		}
             		
             		// Tariff Type Combo Check
             		if(comboObjects[1].Code == '') {
             			ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
             		}
             		
             		// Status Combo Check
             		if(comboObjects[2].Code == '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}
             		
             		ComSetObjValue(fm_mvmt_yd_cd, '');
             		ComSetObjValue(to_mvmt_yd_cd, '');
             		
             		var condType = ComGetObjValue(cond_type);
             		
             		//******************** Date 조건  ************************
             		if(condType == 'date') {
             			
             			var optDate = ComGetObjValue(opt_date);
             			
             			if (optDate == "MVMT_DT") {
	             			if(!ComIsDate(fm_mvmt_dt1)) {
	             				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
	             				return false;
	             			}
	             			if(!ComIsDate(to_mvmt_dt1)) {
	             				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
	             				return false;
	             			}
	             			
	             			var startDt = ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
	             			var endDt = ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
	             			
	             			// 기간체크
	                        if (ComChkPeriod(startDt, endDt) == 0) {
	                        	ComShowCodeMessage("DMT01020");
	                        	return false;
	                        }
	                        
	                        var uclmFlg = ComGetObjValue(uclm_flg);
	                        var limitDt = "";
	                        var	mssg = ""
	                        	
	                        if (uclmFlg == "Y") {
	                        	// Unclaimed Container 데이터량이 적기 때문에 기간을 1년으로 한다.
	                        	limitDt = ComGetDateAdd(startDt, "M", 6);
	                        	mssg = "6 month"
	                        } else {
	                        	limitDt = ComGetDateAdd(startDt, "M", 1);
	                        	mssg = "1 month"
	                        }
	                        
	                        if (ComChkPeriod(endDt, limitDt) == 0) {
	                        	ComShowCodeMessage("DMT00162", mssg);
	                        	return false;
	                        }
	                        
	                        ComSetObjValue(fm_mvmt_dt, startDt);
	                        ComSetObjValue(to_mvmt_dt, endDt);
	             		} else if (optDate == "APP_DT") {
	             			if(!ComIsDate(fm_bzc_trf_aply_dt1)) {
	             				ComAlertFocus(fm_bzc_trf_aply_dt1, ComGetMsg('COM12134', 'Period From Date'));
	             				return false;
	             			}
	             			if(!ComIsDate(to_bzc_trf_aply_dt1)) {
	             				ComAlertFocus(to_bzc_trf_aply_dt1, ComGetMsg('COM12134', 'Period To Date'));
	             				return false;
	             			}
	             			
	             			var startDt = ComGetUnMaskedValue(fm_bzc_trf_aply_dt1, 'ymd');
	             			var endDt = ComGetUnMaskedValue(to_bzc_trf_aply_dt1, 'ymd');
	             			
	             			// 기간체크
	                        if (ComChkPeriod(startDt, endDt) == 0) {
	                        	ComShowCodeMessage("DMT01020");
	                        	return false;
	                        }
	                        
	                        var uclmFlg = ComGetObjValue(uclm_flg);
	                        var limitDt = "";
	                        var	mssg = ""
	                        
	                        if (uclmFlg == "Y") {
	                        	// Unclaimed Container 데이터량이 적기 때문에 기간을 1년으로 한다.
	                        	limitDt = ComGetDateAdd(startDt, "M", 6);
	                        	mssg = "6 month"
	                        } else {
	                        	limitDt = ComGetDateAdd(startDt, "M", 1);
	                        	mssg = "1 month"
	                        }
	                        
	                        if (ComChkPeriod(endDt, limitDt) == 0) {
	                        	ComShowCodeMessage("DMT00162", mssg);
	                        	return false;
	                        }
	                        
	                        ComSetObjValue(fm_bzc_trf_aply_dt, startDt);
	                        ComSetObjValue(to_bzc_trf_aply_dt, endDt);
	                        
	             		} else if (optDate == "REV_MON") {
	             			ComSetObjValue(cost_yrmon, ComGetUnMaskedValue(cost_yrmon1, 'ym'));
	             		}
             			
             			var orgLoc = ComGetObjValue(org_gubun_cd);
             			
             			if (orgLoc == "CONTI_CD") {
             				ComSetObjValue(fm_loc_cd, formObj.fm_loc_cd1.value);
             			} else if (orgLoc == "POR_CD") {
             				ComSetObjValue(fm_loc_cd, formObj.fm_loc_cd2.value);
             			} else if (orgLoc == "POL_CD") {
             				ComSetObjValue(fm_loc_cd, formObj.fm_loc_cd2.value);
             			}
             			
             			var destLoc = ComGetObjValue(dest_gubun_cd);
             			
             			if (destLoc == "CONTI_CD") {
             				ComSetObjValue(to_loc_cd, formObj.to_loc_cd1.value);
             			} else if (destLoc == "POD_CD") {
             				ComSetObjValue(to_loc_cd, formObj.to_loc_cd2.value);
             			} else if (destLoc == "DEL_CD") {
             				ComSetObjValue(to_loc_cd, formObj.to_loc_cd2.value);
             			}
                        
                        var yardCd = ComGetObjValue(yd_cd);
                        
                        // YardCode를 입력했는지
                        if((yardCd != '' && yardCd.length < 2) || (yardCd.length == 5 && ComGetObjValue(chk_yd_cd) == "N")) {
                        	ComShowCodeMessage('DMT00110', 'Yard');
        					return false;
        	       		} else if(yardCd.length > 1) {
        	       			var yardFmto = ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd);
             				}
        	       		}
             			
             			var yardCd2 = ComGetObjValue(comboObjects[3]);
             			// YardCode를 선택했는지
             			if(yardCd2 != '') {
             				var yardFmto = ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd2);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd2);
             				}
             			}
             			
             			// System performance can be slow with "No Charge" included.
             			// Do you want to proceed?
             			var stsCd = comboObjects[2].Code;
             			if(stsCd.indexOf('N') != -1) {
             				if(!ComShowCodeConfirm('DMT01142'))
             					return false;
             			}
             			
             		//******************** VVD CD 조건  ************************
             		} else if(condType == 'vvd_cd') {
             			if( ComChkLen(vvd_cd, 9) != 2) {	// 9자리가 아니면
             				//ComShowCodeMessage('DMT00102', "VVD CD");
             				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
         					return false;
             			}
             			
             			ComSetObjValue(pod_cd, "");
             			ComSetObjValue(pol_cd, "");
             			var tmnlCd = ComGetObjValue(tmnl_cd);
             			
             			if(tmnlCd != '') {
             				if( tmnlCd.length < 5 || tmnlCd.length == 5 && ComGetObjValue(chk_loc_cd) == "N" ) {	
             					//ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
             					ComShowCodeMessage('DMT00110', 'Location');
            	       			return false;
             				}
             				
             				var trf_cd = comboObjects[1].Code;
             				if(trf_cd.indexOf('I') != -1)	// Inbound
             					ComSetObjValue(pod_cd, tmnlCd);
             				
             				if(trf_cd.indexOf('O') != -1)	// Outbound
             					ComSetObjValue(pol_cd, tmnlCd);
             			}
             			
             		//******************** CNTR 조건  ************************	
             		} else {
         				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
                 			return false;
         				}
             			
             			var bkgNo = ComGetObjValue(bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo = bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			
             			var blNo = ComGetObjValue(bl_no);
             			if(blNo != '') {
             				var arrBlNo = blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
             			
             			var cntrNo = ComGetObjValue(cntr_no);
             			if(cntrNo != '') {
             				var arrCntrNo = cntrNo.split(',');
             				for(var i=0; i<arrCntrNo.length; i++) {
             					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
             						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
    	                 			return false;
             					}
             				}
             			}
             		}
             		
	             	
             		if(svc_provdr.value != '') {
             			if(!ComIsNumber(svc_provdr)) {
             				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
             				return false;
             			}
             			if(ComChkLen(svc_provdr, 6) != 2) {
         					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
         					return false;
         				}
             		}
             		break;
             	
             	case IBDELREQCANCEL:
//             		if(ComGetObjValue(formObj.role_permit) != 'Y') {           		
//             			ComShowCodeMessage('DMT01145', 'DEL Cancel');
//             			return false;
//             		}

             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('DMT01042');
             			return false;
             		}
             		
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    				CHM-201533805 [DMT] Deletion Cancel 기능 개선(기존 : 삭제된 Charge 의 상태를 원상태로 복구시킨다.) 2015.02.10
//             		Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다.
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////                  		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for (var i=0; i < chkRows.length-1; i++) {
             			var cntrNo        = sheetObj.CellValue(chkRows[i], "cntr_no");
             			var bkgNo         = sheetObj.CellValue(chkRows[i], "bkg_no");
             			var trfCd         = sheetObj.CellValue(chkRows[i], "dmdt_trf_cd");             			
             			var deltRqstStsCd = sheetObj.CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd");
             			if (!isValidChgDeltRqstCancel(bkgNo, cntrNo, trfCd, deltRqstStsCd)) {
         					sheetObj.SelectRow = chkRows[i];
         					return false;             				
             			}
             		}
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		if(!ComShowCodeConfirm('DMT01171', "inactivation request"))
             			return false;
             		
             		break;
             		
        	 } // switch-end
        	 
         } // with-end
         
         return true;
     }
    
     function changeDate(value) {
    	 var formObj	= document.form;
    	 
    	 with(formObj){
    		 var fromToPeriod = 0;
    		 var startDate = new Array();
	    	 var endDate = new Array();

	    	 endDate[0] = ComGetUnMaskedValue(formObj.to_mvmt_dt1, 'ymd');
	    	 endDate[1] = ComGetUnMaskedValue(formObj.to_bzc_trf_aply_dt1, 'ymd');
	    	 
	    	 if (value == "Y"){
	    		 fromToPeriod = -6;
	    	 } else {
	    		 fromToPeriod = -1;
	    	 }
	    	 
	    	 startDate[0] = ComGetDateAdd(endDate[0], "M", fromToPeriod);
    		 ComSetObjValue(formObj.fm_mvmt_dt1, startDate[0]);
    		 
    		 startDate[1] = ComGetDateAdd(endDate[1], "M", fromToPeriod);
    		 ComSetObjValue(formObj.fm_bzc_trf_aply_dt1, startDate[1]);
    	 }
     }
     
     function optDate(value){
     	var gubun = value;
     	if (gubun == 'MVMT_DT'){
     		  document.all.mvmtDt.style.display = "inline";
     	      document.all.appDt.style.display   = "none";
     	      document.all.revMon.style.display   = "none";
     	}else if (gubun == 'APP_DT'){
     		document.all.mvmtDt.style.display = "none";
   	        document.all.appDt.style.display   = "inline";
   	        document.all.revMon.style.display   = "none";
     	}else if (gubun == 'REV_MON'){
     		document.all.mvmtDt.style.display = "none";
   	        document.all.appDt.style.display   = "none";
   	        document.all.revMon.style.display   = "inline";
     	}
     } 
 
     function orgNDestMaxLengthChange(name, value) {
    	var formObj	= document.form;
    	 
		if (name == "org_gubun_cd") {
			document.all["fm_loc_cd2"].value = "";
			
			if (value == "") {
				DmtComSetClassManyObjects('input2', formObj.fm_loc_cd2);
				document.all["fm_loc_cd2"].maxLength = "0";
				
				document.all.orgConti.style.display = "none";
				document.all.orgLoc.style.display = "inline";
			} else if (value == "CONTI_CD") {
				document.all["fm_loc_cd2"].maxLength = "1";
				DmtComSetClassManyObjects('input', formObj.fm_loc_cd2);
				
				document.all.orgConti.style.display = "inline";
				document.all.orgLoc.style.display = "none";
			} else {
				document.all["fm_loc_cd2"].maxLength = "5";
				DmtComSetClassManyObjects('input', formObj.fm_loc_cd2);
				
				document.all.orgConti.style.display = "none";
				document.all.orgLoc.style.display = "inline";
			}
		} else {
			document.all["to_loc_cd2"].value = "";
			
			if (value == "") {
				DmtComSetClassManyObjects('input2', formObj.to_loc_cd2);
				document.all["to_loc_cd2"].maxLength = "0";
				
				document.all.destConti.style.display = "none";
				document.all.destLoc.style.display = "inline";
			} else if (value == "CONTI_CD") {
				DmtComSetClassManyObjects('input', formObj.to_loc_cd2);
				document.all["to_loc_cd2"].maxLength = "1";
				
				document.all.destConti.style.display = "inline";
				document.all.destLoc.style.display = "none";
			} else {
				DmtComSetClassManyObjects('input', formObj.to_loc_cd2);
				document.all["to_loc_cd2"].maxLength = "5";
				
				document.all.destConti.style.display = "none";
				document.all.destLoc.style.display = "inline";
			}
		}
		
     }
   	

  	//Inactive Status 멀티콤보 클릭 이벤트
  	function inact_sts_OnCheckClick(comboObj, index, code) {
  		setMultiCombo(comboObj, index, code) ;
  	}
  	
  	//AFT DAR Status 멀티콤보 클릭 이벤트
  	function aft_dar_sts_OnCheckClick(comboObj, index, code) {
  		setMultiCombo(comboObj, index, code) ;
  	}
	 
	/* 개발자 작업  끝 */