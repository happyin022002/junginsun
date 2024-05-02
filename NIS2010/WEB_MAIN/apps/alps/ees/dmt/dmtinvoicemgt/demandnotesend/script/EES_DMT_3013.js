/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3013.js
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
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
     * @class EES_DMT_3013 : EES_DMT_3013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_3013() {
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


	//공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var PERIOD_GAP = 15;
	var USR_TRF_TP = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
		var sheetObject1 = sheetObjects[0];
          
		/*******************************************************/
		var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		var srcObj = window.event.srcElement;

     		switch(srcName) {
	         	case "btns_calendar": //달력 버튼
		         	if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendarFromTo();
			            cal.select(formObj.fm_dt,  formObj.to_dt,  'yyyy-MM-dd');
		         	}
					break;

     			case "btn_retrieve":
 					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
 					break;
 				
 				case "btn_new":
 					//Form.reset()하고, IBSheet.RemoveAll()처리한다. 
	 				//IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()"
 					ComResetAll();
 					doInit();	// 조회조건 초기화
 					buttonMode("NEW");
 					break; 

 				case "btn_minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					
 					if(schCondDiv.style.display == 'block') {
 						DmtComShowObject(schCondDiv,  false);
 						sheetObject1.style.height = 350+145;
 					} else {
 						DmtComShowObject(schCondDiv,  true);
 						sheetObject1.style.height = 350;
 					}

 					break;
 					
				case "btn_demand":
					if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
					break;
					
				case "btn_grp_demand":
					if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
					break;					

 				case "btn_downexcel":
					sheetObject1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk_box');
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
     * 인자로 받은 HTML태그(Object)의 obj.style.display 속성을 변경하여 화면에 표시여부를 변경시킨다. <br>
     * 주로 Tab형태 div 태그를 사용할때 이 함수를 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComShowObject(txtName,  true);   // 결과 : txtName컨트롤을 show한다.
     *     ComShowObject(txtName,  false);  // 결과 : txtName컨트롤을 hide한다.
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {bool}   bShow   필수,표시여부를 true/false로 설정한다.
     * @return 없음
     * @see #ComShowManyObjects
     */
    function DmtComShowObject(obj, bShow) {
        try {
            if (bShow) {
                obj.style.display = "block";
            } else {
                obj.style.display = "none";
            }
        } catch(err) { ComFuncErrMsg(err.message); }
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

    	  for(var i=0;i<sheetObjects.length;i++){
    		 ComConfigSheet (sheetObjects[i] );
    		 initSheet(sheetObjects[i],i+1);
    		 ComEndConfigSheet(sheetObjects[i]);
    	  }
    	  
    	  // IBMultiCombo초기화 
    	  for(var k=0;k<comboObjects.length;k++){
    		  initCombo(comboObjects[k],k+1);
    	  }
 		
    	  var formObj = document.form;
  
    	  //html컨트롤 이벤트초기화
    	  initControl();
 		

     }
      
	function initControl() {
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
  		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
  		axon_event.addListener('click', 'condType_click', 'cond_type'); //date or vvd cd or cntr radio button
  		axon_event.addListener('click', 'locType_click', 'loc_type'); 	//location radio button
  		axon_event.addListener('click', 'chkAllOffice_click', 'chk_all_office'); 	//location radio button
		axon_event.addListener('mouseover', 'obj_mouseover', 'btn_demand', 'td_gb');	// 말풍선 표시
		axon_event.addListener('mouseout',	'obj_mouseout',	 'btn_demand', 'td_gb');	// 말풍선 숨김
//		axon_event.addListener('mouseover', 'obj_mouseover', 'btn_demand', 'btn_grp_demand', 'td_gb');	// 말풍선 표시
//		axon_event.addListener('mouseout',	'obj_mouseout',	 'btn_demand', 'btn_grp_demand', 'td_gb');	// 말풍선 숨김
		
				
  		//axon_event.addListener('change', 'grpType_change', 'grp_type');
	} 
	
	// 'btn_demand' onMouseover 이벤트  (버튼 말풍선 표시)
	function obj_mouseover() {
 		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;
 		
     	switch(event.srcElement.id){
      		case 'btn_demand':
      			msg = "Demand Note Issue by Booking";
      			x = x;
      			y = y-20;
      			break;
      			
      		case 'btn_grp_demand':
      			msg = "Demand Note Issue by Tariff/Payer Group";
      			x = x;
      			y = y-20;
      			break;
      		case 'td_gb':
      			msg = "General/Balance Charge Type";
      			x = x;
      			y = y-20;
      			break;
     	}
 		
 		var bak = 'lightyellow';
 		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn = document.all("topdeck").style;
	 		skn.left = x;
	 		skn.top  = y;
	 		document.all("topdeck").innerHTML = content;
	 		skn.visibility = 'visible';
	}
	// 'btn_demand' onMouseout 이벤트  (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
	
	//ALL OFFICE CHECK
	function grpType_change() {
		var formObj = document.form;
		var grpType = ComGetObjValue(formObj.grp_type);
		if(grpType == '1'){
			// grp_type == 1 일경우  B/L NO GROUPING
			sheetObjects[0].ColHidden("cntr_qty") 		= false;
			sheetObjects[0].ColHidden("cntr_no")		= true;
			sheetObjects[0].ColHidden("dmdt_chg_sts_cd")= true;
			sheetObjects[0].ColHidden("ofc_cd") 		= false;
			sheetObjects[0].ColHidden("fm_mvmt_yd_cd") 	= false;
		} else if(grpType == '2'){
			// grp_type == 12일경우 CNTR NO
			sheetObjects[0].ColHidden("cntr_qty") 		= true;
			sheetObjects[0].ColHidden("cntr_no")		= false;
			sheetObjects[0].ColHidden("dmdt_chg_sts_cd")= false;
			sheetObjects[0].ColHidden("ofc_cd") 		= false;
			sheetObjects[0].ColHidden("fm_mvmt_yd_cd") 	= false;
		}
	}
	
	
	//ALL OFFICE CHECK
	function chkAllOffice_click() {
		
		var formObj = document.form;
		with (formObj) {
			if(chk_all_office.checked){
				comboObjects[0].Enable = false;
				ComSetObjValue(ofc_cd, 	comboObjects[0].Code);
				comboObjects[0].Code = '';
//				comboObjects[0].Text = '';
				DmtComSetClassManyObjects('input1', port_cd); 	
				
			} else {
				comboObjects[0].Enable = true;
				comboObjects[0].Code = ComGetObjValue(ofc_cd);
				ComSetObjValue(ofc_cd, "");
				DmtComSetClassManyObjects('input', port_cd);
			}
		}
		
	}
	//LOCATION CHECK
	function locType_click() {
		doEnableLocTypeObj(event.srcElement.value);
	}
	function doEnableLocTypeObj(condType) {
		var formObj = document.form;
		with (formObj) {
			switch(condType){
				
			 	case "1":
			 		//from yard
			 		comboObjects[3].Enable = true;
			 		break;
			 	case "2":
			 		//por/del
			 		comboObjects[3].Enable = false;
			 		ComClearManyObjects(yd_cd1);
			 		//comboObjects[3].RemoveAll(); 
			 		comboObjects[3].Text = '';
			 		break;
			}
			 
		} // end of the with (formObj) 
	}
	
	
	function condType_click() {
	   	 doEnableCondObj(event.srcElement.value);
    }
    
    
	function doEnableCondObj(condType) {
		var formObj = document.form;
		with (formObj) {
			//0. status 상태 변경 date: 
			//1. comboObjects[2].Code : code 값을 dmdt_chg_sts_cd setting 한후 ..
			//2. setStatusCombo(condType); 각 조건에 맞게 콤보리스트를 초기한 후..
			//3. comboObjects[2].Code = ComGetObjValue(dmdt_chg_sts_cd); 맨아래 -> 다시 콤보에 값을 셋팅 
			//ComSetObjValue(dmdt_chg_sts_cd, ComReplaceStr(comboObjects[2].Code, "R", "L"));

			switch(condType){
				
			 	case "date":
			 		//date
			 		ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input1', fm_dt, to_dt); 		
			 		DmtComSetClassManyObjects('input', yd_cd); 
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		comboObjects[3].Enable = true;
			 	    
			 		// 초기 날짜 값 셋팅 (한달전의 오늘날짜- 오늘날짜ㅣ
			 		//사용자 Office 의 현재 날짜를 조회한다.
					var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj); 
					//조회한 날짜를 화면의 필드에 매핑 시킨다.
					ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -15)); //15일  이전 날짜.
					ComSetObjValue(formObj.to_dt,   ofcCurrDate);  //오늘 날짜.
					
 					//fm_dt.value = ComGetDateAdd(null, "D", -15); //15일  이전 날짜.
 					//to_dt.value = ComGetNowInfo("ymd"); //오늘 날짜.
			 		
			 		
			 		//vvd_cd
			 		ComEnableManyObjects(false, vvd_cd, port_cd, chk_all_office);	
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input2', vvd_cd, port_cd); 
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked = false;
		    		}
			 	
			 		//cntr
			 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, cntr_no); 
		
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			 	case "vvd_cd":
			 		//date
			 		ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input2', fm_dt, to_dt, yd_cd); 		
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		ComClearManyObjects(fm_dt, to_dt, yd_cd);
			 		comboObjects[3].Enable = false;		
	    	 		comboObjects[3].RemoveAll();		
			 		
			 		//vvd_cd
			 		ComEnableManyObjects(true, vvd_cd, port_cd, chk_all_office);
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input1', vvd_cd);
			 		DmtComSetClassManyObjects('input', port_cd);
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked = false;
		    		}
			 	
			 		//cntr
			 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);	
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, cntr_no); 
		
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			 	case "cntr":
			 		//date
			 		ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input2', fm_dt, to_dt, yd_cd); 		
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		ComClearManyObjects(fm_dt, to_dt, yd_cd);
			 		comboObjects[3].Enable = false;		
	    	 		comboObjects[3].RemoveAll();	
			 		
			 		//vvd_cd
			 		ComEnableManyObjects(false, vvd_cd, port_cd, chk_all_office);	
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input2', vvd_cd, port_cd);
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked = false;
		    		}
			 	
			 		//cntr
			 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no);
		
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			}
			 
			// Period 활성화 처리
			if(condType == 'date') {
				//Period Date 초기화
				//var data = getDefaultDate(PERIOD_GAP).split("|");
				//fm_dt.value = data[1];
				//to_dt.value = data[0];
		 		//사용자 Office 의 현재 날짜를 조회한다.
				var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj); 
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -15)); //15일  이전 날짜.
				ComSetObjValue(formObj.to_dt,   ofcCurrDate);  //오늘 날짜.
			}
			//office combo list 활성화 & all office를 uncheck 한 이전 상태의 데이터를 가져오기
			//check시에 ofc_cd에 콤보 데이터를 잠시 두었다가 all office가 상태가 해제 되었을 때 ofc_cd에 두었던 데이터 reset하기.
			comboObjects[0].Enable = true;
			if(ComGetObjValue(ofc_cd) != ''){
				comboObjects[0].Code = ComGetObjValue(ofc_cd);
				ComSetObjValue(ofc_cd, "");
			}
			
			
//			if(ComGetObjValue(dmdt_chg_sts_cd) != ''){
//				comboObjects[2].Code = ComGetObjValue(dmdt_chg_sts_cd);
//				ComSetObjValue(dmdt_chg_sts_cd, "");
//			}
			
			
		} // end of the with (formObj) 
	}
    
	//reset status combo list
	function setStatusCombo(condType) {
		var comboObj = comboObjects[2];
		var orgCode = comboObj.Code;
		
   	 	if(condType=='date') {
   	 		//전체 리스트 갯수가 7일때 해당 함수를 다시 호출하지 않기 위해서 조건을 추가.
   	 		//예)date radio 상태에서 다시 date radio를 선택 했을 경우.
   	 		if(comboObj.GetCount() != 7) {
   	 			comboObj.RemoveAll();
   	 			initCombo(comboObj, 3);
   	 		}
   	 	} else {
   	 		if(comboObj.GetCount() != 6) {
   	 			comboObj.RemoveAll();
   	 			initCombo(comboObj, 4);
   	 			
	   	 		if(orgCode.indexOf('R') != -1) {
					 orgCode = ComReplaceStr(orgCode, 'R', 'L');
					 
					 // 전체선택('All') 항목 체크 처리
					 if(orgCode == 'F,U,C,I,L')
						 orgCode = 'A,F,U,C,I,L';
				 }
   	 			
   	 		}
   	 	}
   	 	
   	 	comboObj.Code = orgCode;
    }
	
	function status_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.Code;
		
		if(codes.indexOf('L')!=-1 && codes.indexOf('R')!=-1) {
			ComShowCodeMessage('DMT01067');
			comboObj.CheckIndex(index) = false;
			return;
		}
		
		var formObj = document.form;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All
					comboObj.Code = "A,F,L,U,C,I";
				else
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			} else if(codes == 'F,L,U,C,I') {
				comboObj.CheckIndex(0) = true;
			}
			
			if(codes == '' || codes == 'R') {	//전체 미선택 or All Long Statying --> 날짜,달력아이콘 비활성
				ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input2', fm_dt, to_dt);
			} else {
				if(ComGetObjValue(cond_type) == 'date') {
					ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
					DmtComSetClassManyObjects('input1', fm_dt, to_dt);
				}
			}
		}
	}
	
	// caller: ComResetAll호출 후 아래 적용.
   	// IBMultiCombo Office 초기화
   	function initComboValue_office() {
   		comboObjects[0].Enable = true;
   		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
   	}
   	// IBMultiCombo Tariff Type 초기화
   	function initComboValue_tariff_type() {
   		document.form.usr_trf_tp.value = USR_TRF_TP;
   		comboObjects[1].Enable = true;
   		ComSetObjValue(comboObjects[1], document.form.usr_trf_tp.value);
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
	
    //포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
	 
        } else if(obj.name == 'yd_cd' || obj.name == 'port_cd') {
        	if(obj.value.length > 0 && obj.value.length < 5) {
        		var cdDiv = (obj.name == 'yd_cd') ? 'Yard' : 'Location';
        		ComShowCodeMessage('DMT00110', cdDiv);
        		if(obj.name == 'yd_cd'){
        			document.form.yd_cd.value = "";
        		} else {
        			document.form.port_cd.value = "";
        		}
				
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
		        ComKeyOnlyNumber(event.srcElement,"-.");//&lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
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
			var comboObj = comboObjects[3];
			
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value = cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				
				if(comboObj.GetCount() == 0) {
					formObj.loc_cd.value = cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.port_cd);
				}
			} else {
					formObj.loc_cd.value = cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
				
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
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
				
	  			case 'svc_provdr':	// Service Provider Popup
					ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);//COM_ENS_0C1
					break;
					
	  			case 'bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 'cntr_no':		// CNTR No. 멀티입력 팝업 호출
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
					break;
	  		} // switch-end
  		} // with-end
  		
  		if(sUrl.indexOf('.do') != -1) {
  			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
  		}
  	}
  
  	/**
 	 * BUTTON MODE
 	 */
 	function buttonMode(mode) {
 		 var formObj = document.form;
 		 with (formObj) {
 			 if(mode == "NEW"){
 				 DmtComEnableManyBtns(true,  "btn_retrieve", "btn_new", "btn_minimize");
 				DmtComEnableManyBtns(false, "btn_demand", "btn_grp_demand", "btn_downexcel");
 			 }else if(mode == "RETRIEVE"){
 				 DmtComEnableManyBtns(true,  "btn_retrieve", "btn_new");
 				DmtComEnableManyBtns(true,  "btn_minimize", "btn_demand", "btn_grp_demand", "btn_downexcel");
 			 } 
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
   	    	case "office": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 6;
   		    	}
   				break; 
   				
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = false;
					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
   		    	}
   				break; 
   				
   	    	case "status":
   	    		with (comboObj) { 
   	    			// comboNo = 3은 caller에서 구분하기 위한 구분자로 따로 의미는 없음.
   					MultiSelect = true;
					if(comboNo==3) {
						SetColAlign("left|left");  
						SetColWidth("110|150");
						ColBackColor(0) = "#CCFFFD";
	  					ColBackColor(1) = "#CCFFFD";
					} else{
						SetColAlign("left");        
   						SetColWidth("110");
   						ColBackColor(0) = "#CCFFFD";
					}
					DropHeight = 160;
					addComboItem(comboObj, comboNo);
//					Code = "F";
   		    	}
   	    		break;
   	    		
   	    	case "yd_cd2":
   	    		with (comboObj) { 
   	    			MultiSelect = false; 
  					UseAutoComplete = true;
	    			SetColAlign("left");
	    			SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
   		 }
	}	 
	 
	
	 /**
  	  * INIT SETTING
  	  */
	function doInit() {
  		var formObj = document.form;
	    
	    //Period Date 초기화
//		var data = getDefaultDate(PERIOD_GAP).split("|");
//		formObj.fm_dt.value = data[1];
//		formObj.to_dt.value = data[0];
       
		doEnableCondObj("date");
		//grid 초기 셋팅
		sheetObjects[0].ColHidden("cntr_qty") 		= false;
		sheetObjects[0].ColHidden("cntr_no")		= true;
		sheetObjects[0].ColHidden("dmdt_chg_sts_cd")= true;
		sheetObjects[0].ColHidden("ofc_cd") 		= true;
		sheetObjects[0].ColHidden("fm_mvmt_yd_cd") 	= true;
				
		comboObjects[2].Code = 'F';
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
                     style.height = 360;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 2, 100);


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);
                     
                     // Ctrl키를 눌러 다중행 선택가능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;

                     var HeadTitle  = "||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|STS|Office|From YD|BKG DEL|Tariff|Payer|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd";
                     var HeadTitle1  = "||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|STS|Office|From YD|BKG DEL|Tariff|Code|Name|S/C No.|RFA No.|Cur.|Billing AMT|inv_org_amt|inv_dc_amt|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd";

                     var headCount = ComCountHeadTitle(HeadTitle);
                     var headCount1 = ComCountHeadTitle(HeadTitle1);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,daCenter,   true,     	"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,	true,		"chk_box");
					InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"bl_no",			false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"cntr_qty",			false,		"",			dfInteger,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"dmdt_chg_sts_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"ofc_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"fm_mvmt_yd_cd",	false,		"",			dfNone,			0,		true,		true);
					                                      
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"port",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"payer_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"payer_nm",			false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"sc_no",			false,		"",			dfNone,			0,		true,		true);					                                     
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"rfa_no",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"inv_curr_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,		"inv_chg_amt",		false,		"",			dfFloat,		2,		true,		true);
					//rd용 아래 2개 추가. inv_org_amt, inv_dc_amt
					InitDataProperty(0, cnt++ , dtHidden,	80,		daRight,	true,		"inv_org_amt",		false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daRight,	true,		"inv_dc_amt",		false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"org_curr_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,		"org_chg_amt",		false,		"",			dfFloat,		2,		true,		true);
					                                      
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,		"expt_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,		"dc_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,		"bil_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,		"inv_xch_rt",		false,		"",			dfFloat,		7,		true,		true);

					//
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"shipper_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"shipper_nm",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"cnee_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"cnee_nm",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"ntfy_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"ntfy_nm",			false,		"",			dfNone,			0,		true,		true);
					                                      
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"ar_act_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"ar_act_nm",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"svc_provdr_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"svc_provdr_nm",	false,		"",			dfNone,			0,		true,		true);
					//
					
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"svr_id",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"cntr_cyc_no",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"dmdt_chg_loc_div_cd",false,	"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"dmdt_inv_no",		false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"vsl_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"skd_voy_no",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"skd_dir_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"pol_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"pod_cd",			false,		"",			dfNone,			0,		true,		true);
					
					FrozenCols = SaveNameCol("cntr_qty");
					
					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"inv_curr_cd") = "Amount per A/R Office Currency";
					ToolTipText(0,"inv_chg_amt") = "Amount per A/R Office Currency";
					ToolTipText(1,"inv_curr_cd") = "Amount per A/R Office Currency";
					ToolTipText(1,"inv_chg_amt") = "Amount per A/R Office Currency";
					
 					CountPosition = 2;
 					
 					Ellipsis = true;//문자가 범위를  초과할때 말줄임표...로 표현
 			   }
                 break;

    	  }
     }

   	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}

//				if (!validateDate(formObj)) {
//					return false
//				}
			
				//그리드 포맷 셋팅.
				grpType_change();

				//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
			
				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch4Post("EES_DMT_3013GS.do",	FormQueryString(formObj));

 				//ComOpenWait End
				ComOpenWait(false);
				
 				var totRowCnt = sheetObj.RowCount;
 				//데이터가 있을 경우에서 처리.
    			if(totRowCnt > 0){
    				//버튼을 조회시로 변경 
    				buttonMode("RETRIEVE");
    				//첵크 상태 해제
    				sheetObj.CheckAll("chk_box") = 0;
    			} 
    			
 				break;

         }
	}
   	
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
	function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
			
			
			if(!chk_all_office.checked){
				// Office Combo Check (단, check all office만 제외)
	     		if(comboObjects[0].Code == '') {
	     			ComShowCodeMessage('COM12113', "Office");
	     			return false;
	     		}
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
     		
     		var condType = ComGetObjValue(cond_type);
     		
     		//******************** Date 조건  ************************
     		if(condType == 'date') {
     			if(!ComIsDate(fm_dt)) {
     				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
     				return false;
     			}
     			if(!ComIsDate(to_dt)) {
     				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
     				return false;
     			}
     			
                if(ComChkPeriod(fm_dt.value, to_dt.value) > 0){
        			if(ComGetDaysBetween(fm_dt.value, to_dt.value) > 31){
        				ComShowCodeMessage('DMT00162','1 Month');
        				return false;
        			}
        		} else if (ComChkPeriod(fm_dt.value, to_dt.value) <= 0){
        			ComShowCodeMessage('DMT01020');
        			return false;
        		} 
                
                var yardCd = ComGetObjValue(yd_cd);
                
                // YardCode를 입력했는지
                if( yardCd != '' && yardCd.length < 5 ) {
					ComAlertFocus(yd_cd, ComGetMsg('DMT00110', 'Yard'));
					return false;
	       		} 
     			
     		//******************** VVD CD 조건  ************************
     		} else if(condType == 'vvd_cd') {
     			if( ComChkLen(vvd_cd, 9) != 2) {	// 9자리가 아니면
     				//ComShowCodeMessage('DMT00102', "VVD CD");
     				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
 					return false;
     			}
     			
     			var portCd = ComGetObjValue(port_cd);
     			//chk_all_office가 체크시에는 필수 
     			if(chk_all_office.checked){
     				if(ComIsNull(portCd)){
     					ComShowCodeMessage('COM12113', "Port CD");
    	     			return false;
     				}
     			} 
     			
     			//chk_all_office가 체크 해제시에는 선택 
     			if(!ComIsNull(portCd)){
     				if(ComChkLen(portCd, 5) != 2) {
     					ComAlertFocus(port_cd, ComGetMsg('DMT00119', 'Port', '5'));
     					return false;
     				}
     			}
 				
     				
     			
     		//******************** CNTR 조건  ************************	
     		} else if(condType == 'cntr') {
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
     		
     		//주요 필수 정보 셋팅.
			ComSetObjValue(ofc_cd, 			comboObjects[0].Code);
			ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].Code);
			ComSetObjValue(dmdt_chg_sts_cd, comboObjects[2].Code);
			
			if(ComGetObjValue(cond_type) == 'date'){
				ComSetObjValue(loc_cd, ComGetObjValue(yd_cd) + comboObjects[3].Text);
			} else if(ComGetObjValue(cond_type) == 'vvd_cd'){
				//all_office가 check 되면 office code를 사용하지 않고 port_cd를 사용한다.
				if(chk_all_office.checked){
					ComSetObjValue(all_office,  "Y");
					ComSetObjValue(ofc_cd, 		"");
				}
			} 
  	  	} //end of the with(formObj){ clause

  	  return true;
	}
    
	/**
	 * 날짜값의 유효성검증 프로세스 처리
	 */
	function validateDate(formObj){
		if(ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) > 0){
			if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 31){
				ComShowCodeMessage('DMT00162','1 Month');
				return false;
			}
		} else if (ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
   	 
		formObj.f_cmd.value = formCmd;
		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
   	 
		switch(comboObj.id) {
	       case "office":
	    	   	// Office List
				var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
				var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
   	    	
	    	    var comboCodeArr = ofc_cds.split("|");
	    	    var comboTextArr = ofc_nms.split("|");
	    	    
	    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
	    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
	         	}
	    	    
	    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
	   	  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
	   	  		comboObj.Code = usr_ofc_cd;
	   	  		
	   	  		if(comboObj.Code != usr_ofc_cd) {
		    	  		comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
		    	  		comboObj.Code = usr_ofc_cd;
	   	  		}
	    	    break;
	        	
	        case "tariff_type":
		 		// Tariff type comboList
				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
				}
				// User별 Tariff Type Set-Up 값 조회
 				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				
 				// User별 Tariff Type Set-Up 값이 없을 경우 Default값으로 세팅.
 				if(data2 == '')
 					data2 = 'DMIF';
 				else {
 					// Tariff Type Set-Up값이 여러 건일 경우 첫번째 Tariff Type으로 설정
 					data2 = data2.split(',')[0];
 				}
 				
 				// Tariff Type IBMultiCombo 초기값 설정
 				comboObj.Code = data2;
 				
 				// IBMultiCombo Tariff Type 초기화 함수(initComboValue_tariff_type())에서 사용하기 위해 전역변수(USR_TRF_TP)에 세팅
 				USR_TRF_TP = data2;
 				
 				formObj.usr_trf_tp.value = data2;
 				
 				break;
				
	        case "yd_cd2":
	        	var comboDatas;
	        	var chkObj;
	        	var condType = ComGetObjValue(formObj.cond_type);
	        	
	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();			
	 	        	comboDatas = ComGetEtcData(sXml, "YD");
	        	} else {
	        		comboDatas = ComGetEtcData(sXml, "LOC_CD");
	        	}
				
				if (comboDatas != undefined && comboDatas != '') {
					if(srcObj.name == 'yd_cd') {
						comboItems = comboDatas.split(ROWMARK);
						addComboItem(comboObj, comboItems);
					}
				} else {
					if(srcObj.name == 'yd_cd') {
						sheetObj.WaitImageVisible = true;
						return;
					}
					
					if(condType == 'date')
 	        			formObj.yd_cd.value = "";
 	        		else
 	        			formObj.port_cd.value = "";
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
	        	break;
        }
		sheetObj.WaitImageVisible = true;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		
 		switch(comboObj.id) {
 			case "tariff_type":
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
		  		
 			case "status":
 				if(comboItems == 3) {
	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished|To Date", "F");
	  				comboObj.InsertItem(2, "Long Staying|From Date", "L");
	  				comboObj.InsertItem(3, "Unfinished|From Date", "U");
	  				comboObj.InsertItem(4, "Confirmed|To Date", "C");
	  				comboObj.InsertItem(5, "Invoiced|To Date", "I");
	  				comboObj.InsertItem(6, "All Long Staying|Regardless of Date", "R");
 				} else {
 	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished", "F");
	  				comboObj.InsertItem(2, "Long Staying", "L");
	  				comboObj.InsertItem(3, "Unfinished", "U");
	  				comboObj.InsertItem(4, "Confirmed", "C");
	  				comboObj.InsertItem(5, "Invoiced", "I");
 				}
 				break;
 				
 			case "yd_cd2":
 				for (var i = 0 ; i < comboItems.length ; i++) {
 		    		var comboItem = comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
 		    	}
 				break;
 		}
 	}
    
    //쉬트 로드 후에 콤보리스트 콜. 깜빡임 방지 방안
  	function sheet1_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;   

		//office combo list
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST02);
		//tariff type combo list
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST);
      	
		//OPEN화면 호출
      	doInit();
      	sheetObjects[0].WaitImageVisible = true;   
      	
      	buttonMode("NEW");
	}        
    
    
    //Check box에서 check all을 할 경우 처리 되는 이벤트. 
//	function sheet1_OnClick(sheetObj, row, col, Value){
//		if(sheetObj.ColSaveName(col) == "chk_box")
//			ComSyncAllCheck(sheetObj, col, Value);
//	}
    
    
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
            if (ColSaveName(Col) != "chk_box") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
//                        if (CellEditable(arr[i], "chk_box")) {
//                            CellValue2(arr[i], "chk_box") = "1";    // 선택된 행의 CheckBox 체크
//                        }
                        // 토글 기능
                    	if(CellValue(arr[i], "chk_box") == '0'){
                    		CellValue2(arr[i], "chk_box") = '1';
                    	} else {
                    		CellValue2(arr[i], "chk_box") = '0';
                    	}
                    }
                    
                    if (CheckedRows("chk_box") == RowCount) {
                    	HeadCheck(0, "chk_box") = true;
                        HeadCheck(1, "chk_box") = true;
                    } else {
                    	HeadCheck(0, "chk_box") = false;
                        HeadCheck(1, "chk_box") = false;
                    }
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
    
	
	//save name에서 port에다  조회 후 결과값에 따라 아래 해당title로 변경 . 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {   	
		with(sheetObj) {
			var formObj = document.form;
			ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].Code);
    		var dmdtTrfCd = formObj.dmdt_trf_cd.value;
    		if(!ComIsEmpty(dmdtTrfCd)){
    		    //tariff type code 에서 Outbound 일 경우
    			if(dmdtTrfCd.substr(2,1) == 'O'){
    				CellValue(0, "port") = "BKG POR";
        			CellValue(1, "port") = "BKG POR";
        			
    			} else {
    			//tariff type code 에서 Inbound 일 경우	
    				CellValue(0, "port") = "BKG DEL";
        			CellValue(1, "port") = "BKG DEL";
        			
    			}
    		} else {
    			//default
    			CellValue(0, "port") = "BKG POR";
    			CellValue(1, "port") = "BKG POR";
    		}
		}
	}

    /*
 	 * 더블클릭 팝업(Billing)
 	 */
 	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
		
 		var formObj = document.form;
 		
 		//ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
 		ComSetObjValue(formObj.ofc_cd, 			sheetObj.CellValue(sheetObj.SelectRow, "ofc_cd"));
		ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].Code);
		ComSetObjValue(formObj.dmdt_chg_sts_cd, comboObjects[2].Code);
 		
		var url = "EES_DMT_3109.do"
 			+"?group_by="//+ComGetObjValue(formObj.grp_type)
 			+"&chg_type="+ComGetObjValue(formObj.chg_type)
 			+"&ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "ofc_cd") //ComGetObjValue(formObj.ofc_cd)
 			+"&dmdt_chg_sts_cd="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_chg_sts_cd") //ComGetObjValue(formObj.dmdt_chg_sts_cd)
 			+"&bkg_no="+sheetObj.CellValue(Row, "bkg_no")
 			+"&dmdt_trf_cd="+sheetObj.CellValue(Row, "dmdt_trf_cd")
 			+"&cntr_no="//+sheetObj.CellValue(Row, "cntr_no")
 			+"&dmdt_inv_no="//+sheetObj.CellValue(Row, "dmdt_inv_no")
 			+"&invoice_issue=1"	//Invoice Issue BEFORE
 			;
 		var returnValue = ComOpenWindowCenter(url, "EES_DMT_3109", EES_DMT_3109_WIDTH, EES_DMT_3109_HEIGHT, true);
 		if(returnValue == "Y") {
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		}
 	}  
 	 
 	/**
 	 * EES_DMT_3109 팝업 호출
 	 * @param sheetObj
 	 * @param formObj
 	 * @param srcName
 	 * @return
 	 */
 	function openPopupWindow(sheetObj, formObj, srcName) {

 			
 		 if(srcName == "btn_demand") {
 	 		 //ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
 	 		 ComSetObjValue(formObj.ofc_cd, 			sheetObj.CellValue(sheetObj.SelectRow, "ofc_cd"));
 	 		 ComSetObjValue(formObj.dmdt_trf_cd, 		comboObjects[1].Code);
 	 		 ComSetObjValue(formObj.dmdt_chg_sts_cd, 	comboObjects[2].Code);
 	 		 
 			 var url = "EES_DMT_3109.do"
 				+"?group_by="//+ComGetObjValue(formObj.grp_type)
 	 			+"&chg_type="+ComGetObjValue(formObj.chg_type)
 	 			+"&ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "ofc_cd") //ComGetObjValue(formObj.ofc_cd)
 				+"&dmdt_chg_sts_cd="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_chg_sts_cd") //ComGetObjValue(formObj.dmdt_chg_sts_cd)
 				+"&bkg_no="+sheetObj.CellValue(sheetObj.SelectRow, "bkg_no")
 				+"&dmdt_trf_cd="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_trf_cd")
 				+"&cntr_no="//+sheetObj.CellValue(sheetObj.SelectRow, "cntr_no")
 				+"&dmdt_inv_no="//+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_inv_no")
 				+"&invoice_issue=1"	//Invoice Issue BEFORE
 				;

 			var returnValue = ComOpenWindowCenter(url, "EES_DMT_3109", EES_DMT_3109_WIDTH, EES_DMT_3109_HEIGHT, true);
 			if(returnValue == "Y") {
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			}

 		}else if(srcName == "btn_grp_demand") {
 			if(sheetObj.CheckedRows("chk_box") == 0) {
     			ComShowCodeMessage('COM12114', 'BKG No');
     			return;
     		}
 			
 			//ALL CHECK 시 여러 ofc cd를 넘기지 못하도록 함.
 			if(formObj.chk_all_office.checked){
 				var chkRows = sheetObj.FindCheckedRow("chk_box").split("|");
 	 			for(var i=0; i < chkRows.length-1; i++) {
 	 				for(var j=0; j < chkRows.length-1; j++) {
 	 					if(sheetObj.CellValue(chkRows[i], "ofc_cd") != sheetObj.CellValue(chkRows[j], "ofc_cd")){
 	 						ComShowCodeMessage('DMT01095');
 	 						return;
 	 					} else {
 	 						//if(formObj.chk_all_office.checked){ 가 check 되었을 경우 사용.
 	 						ComSetObjValue(formObj.ofc_cd, 	sheetObj.CellValue(chkRows[i], "ofc_cd"));
 	 					}
 	 	     		} //for(var j=0; i < chkRows.length-1; j++) {
 	     		} //for(var i=0; i < chkRows.length-1; i++) {
 			} //if(formObj.chk_all_office.checked){
 			else {
 				ComSetObjValue(formObj.ofc_cd, 				comboObjects[0].Code);
 			}
 			
 			ComSetObjValue(formObj.dmdt_trf_cd, 		comboObjects[1].Code);
 			ComSetObjValue(formObj.dmdt_chg_sts_cd, 	comboObjects[2].Text);
 			ComSetObjValue(formObj.dmdt_chg_sts_cd_2, 	comboObjects[2].Code);
			var url = "EES_DMT_3108.do"
				+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
				+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_chg_sts_cd="+ComGetObjValue(formObj.dmdt_chg_sts_cd)	 //텍스트
				+"&dmdt_chg_sts_cd_2="+ComGetObjValue(formObj.dmdt_chg_sts_cd_2) //코드
				//+"&bkg_no="+bksNos
				;
		
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_3108", "1020","730", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
 		}
 	} 	 
	/* 개발자 작업  끝 */