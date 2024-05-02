/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0075.js
*@FileTitle : SPCL CGO Irregular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.22 김현욱
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
     * @class vop_scg_0075 : vop_scg_0075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0075() {
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
    
    /*****************************************************************************************
     * 공통전역변수 시작 *
     ****************************************************************************************/  
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefixs = new Array("sheet1_","sheet2_");  
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
    
    //VVD CD 관련 항목들
    var strVVDOptions = "vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|vsl_slan_cd|vsl_slan_nm|vsl_opr_tp_cd|vsl_opr_tp_nm";
    //BKG No. 관련 항목들
    var strBKGOptions = "bkg_no|bl_no|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|f_cust_nm|c_cust_nm|dcgo_flg|rc_flg|awk_cgo_flg|bb_cgo_flg|set_bkg_no|set_bl_no";   
    
    /*****************************************************************************************
     * 공통전역변수 끝 *
     ****************************************************************************************/  

//////////////////////////////////////////////////////////////////////////////////////////////
//
// ▩Step-By-Step▩
//--------------------------------------------------------------------------------------------
//    
// 
// ►0. 화면로딩시
//   .desc  : Option을 기본으로 Dangerous Goods로 한다.
//   .step1 : Option을 선택한후 수행되는 Step을 기본적으로 수행한다.
//   .step2 : 파일 업로드 관련 Sheet, Upload Component를 초기화 한다.  
//   .step3 : 초기 포커스를 VVD란에 위치시킨다.
//   .goto  : [#0-0]
//  
//  
//  
// ►1. VVD Key In 또는 팝업을 이용한 Setting
//   .desc  : VVD, Lane, Vessel Operator 을 채운다.
//   .see   : ►3 수행
//   .goto  : [#1-1][#1-2][#1-3]
//
//
//
// ►2. Irregular Occurred Key In 또는 팝업을 이용한 Setting
//  .desc  : Irregular Occurred Date 를 채운다.
//  .see   : ►3 수행
//  .goto  : [#3-1]
//  
//  
//  
// ►3. Cargo Operator Key In 또는 팝업을 이용한 Setting
//   .desc  : 타선사일 경우 Booking 정보를 Key In 으로 입력하도록 변경한다.
//   .step1 : Cargo Operator 를 변경할 경우 해당 Container 정보를 삭제상태로 변경하여 Parameter로 셋팅해 놓는다.    
//   .step2 : Booking 정보를 초기화 한다.
//   .step3 : Container 정보(Sheet)의 CNTR No. TP/SZ 컬럼을 Cargo Operator 종류에 따라 Combo와 Text Box로 타입변경 한다.
//   .event : Focus-Out, Pop-Up CallBack
//   .goto  : [#3-1][#3-2]
//  
//  
//  
// ►4. Option 선택
//   .desc  : Option에 따라 Container 입력 항목이 달라진다.
//   .req   : Cargo Operator 가 입력되어 있어야 한다.   
//   .step1 : Option 을 변경할 경우 해당 Container 정보를 삭제상태로 변경하여 Parameter로 셋팅해 놓는다.
//   .step2 : Option에 따른 Irregulars Type Combo Box 를 채운다.
//   .step3 : Sheet의 종류를 선택 후 초기화 한다.
//   .step4 : Booking 정보를 초기화 한다.
//   .step5 : Container 정보(Sheet)의 CNTR No. TP/SZ 컬럼을 Cargo Operator 종류에 따라 Combo와 Text Box로 타입변경 한다.
//   .event : Radio 선택
//   .goto  : [#4-1]
//  
//  
//  
// ►5. BKG No. 또는 B/L No. Key In
//   .desc  : Booking 및 관련 정보를 셋팅하고 Container Combo Box를 채운다.
//   .step1 : Booking 및 관련 정보를 셋팅한다.
//   .step2 : Sheet의 Container Combo Box를 채운다.
//   .event : Key-In
//   .goto  : [#5-1][#5-2]
//  
//  
//  
// ►9. 조회시
//   .desc  : 조회결과가 있는지 없는지에 따라 기존상태유지와 수정상태로 변경한다.
//            조회 참여 항목 : (필수)VVD CD, Irregular Occurred, Cargo Operator (옵션) BKG No.  --> 에 따라 Max값으로 조회
//   .step1 : 조회된 Irregular Sequence가 있는지 없는지 확인한다. 이하는 단계는 조회성공 상태의 처리단계이다.
//   .step2 : 화면을 초기화 한다.
//   .step3 : 조회한 Irregular 일반정보를 셋팅한다.
//   .step4 : VVD 일반정보를 조회하여 셋팅한다.
//   .step5 : Option을 선택한후 수행되는 Step을 기본적으로 수행한다.
//   .step6 : 다시 조회한 Irregular 일반정보를 셋팅한다.
//   .step7 : Booking 일반정보를 조회하여 셋팅한다.
//   .step8 : Container 정보를 Sheet에 채운다.
//   .goto  : [#9-9]
// 
//////////////////////////////////////////////////////////////////////////////////////////////    

	/*****************************************************************************************
	 * 이벤트 처리 시작 *
	 ****************************************************************************************/    
    
    // 업무 자바스크립트 OnKeyPress 이벤트 Catch
    function initControl() {
        // Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        axon_event.addListenerFormat ('focus',    'obj_activate',   form);
        axon_event.addListenerFormat ('blur', 	  'obj_deactivate', form);
        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);
        axon_event.addListenerForm   ("keyup",    'obj_keyup',      form);
    }
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 업무 자바스크립트 OnFocusOut 이벤트 처리
    function obj_focusout() {
    	switch(event.srcElement.name){ 
	    	case "skd_dir_cd":
	        	//[#1-1]VVD 정보 조회
	        	searchVVDInfo();
	        	//[#1-3]Cargo Operator에 따라 초기화 작업 수행
	        	resetBKGCntrInfo(false, false); 

	        	break;
	    	case "irr_occr_dt":
	        	//[#3-1]Cargo Operator에 따라 초기화 작업 수행
	        	resetBKGCntrInfo(false, false); 	
	        	
	        	//변경된 Irregular Occurred Date 셋팅
 				setObjValue("set_irr_occr_dt", getObjValue("irr_occr_dt"));
 				
 				//포커스 이동
 				setFocus("cgo_opr_cd");
	        	break;
	        case "bkg_no":
	        	//[#5-1]Booking 정보 조회
	        	searchBKGInfo(0);
	        	break; 
	        case "bl_no":
	        	//[#5-2]Booking 정보 조회
	        	searchBKGInfo(2);
	        	break;	   
	        case "cgo_opr_cd":
	        	//[#3-1]Cargo Operator에 따라 초기화 작업 수행
	        	resetBKGCntrInfo(false, true); 	   			
	        	break;	  
    	}
    } 

    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "vsl_cd":	
	    	        	//영문대문자 입력하기
	    	    		ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	    	        	//숫자입력하기
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "vsl_opr_tp_cd":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	//영문대문자 입력하기	    	        	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "bkg_no":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "bl_no":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//공통기준:영문, 숫자만을 인식
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
    	// 마스크 구분자 없애기
    	ComClearSeparator (event.srcElement);
    }

    // 업무 자바스크립트 OnBlur 이벤트 처리
    function obj_deactivate() {
    	// 마스크 구분자 더하기
    	ComAddSeparator (event.srcElement);    
    	// 하나의 컨트롤의 Validation을 확인
    	ComChkObjValid(event.srcElement);
    }
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	obj_nextfocus(event.srcElement);
    }  
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		ComSetNextFocus(obj);
    	}
    }
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObj = sheetObjects[0];
         
        /*******************************************************/
        var formObj = document.form;

    	try {
    		var eventObj = window.event.srcElement;
    		var srcName  = eventObj.getAttribute("name");
    		
            switch(srcName) {
	            case "btn_Retrieve":
	            	doActionIBSheet(sheetObj,formObj,IBSEARCH,'SELF');
	            	break;
				case "btn_New":
					doActionIBSheet(sheetObj,formObj,IBCLEAR,'SELF');
					break;					
				case "btn_Close":
					window.close();
					break;
				case "btn_VVDpop":
					//VVD 선택팝업 열기					
					var vsl_cd = getObjValue("vsl_cd");
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 465, 485, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 385, "setCallBackVVD", "0,0", true);
                	}
					break;
				case "btn_calendar": 
					//날짜 선택 달력열기
					var cal = new ComCalendar();
		            cal.select(formObj.irr_occr_dt, "yyyy-MM-dd"); 
   	                break;	
				case "btn_carrier":
					//Cargo Operator 선택팝업 열기
					ComOpenPopup('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 420, "setCallBackCP", '0,0,1,1,1', true);	
					break;				
				case "spcl_cgo_cate_cd":					
					//[#4-1]Option 선택
					setSelectedOption(eventObj.value);
					break;
				case "btn_etc":
					setDelCNTRToForm(sheetObj, false);
					break;
				case "btn_file":
					//Supporting Documents or Pictures 팝업 열기
					formObj.f_cmd.value = "";
					ComOpenPopup('/hanjin/VOP_SCG_2013_01.do?'+FormQueryString(formObj), 605, 270, "setFileUpload", 'none', false);	
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
    
    /*****************************************************************************************
     * 이벤트 처리 끝 *
     ****************************************************************************************/  
    
    /*****************************************************************************************
     * Sheet 이벤트 처리 시작 *
     ****************************************************************************************/ 
    
    /**
     * Sheet1 Combo Change Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value)  {
    	//Container Combo OnChange
    	if(Col == sheetObj.SaveNameCol(prefixs[0]+"cntr_no")) {
    		//Combo Box일 경우에만 조회
			var idx = sheetObj.GetComboInfo(Row,Col, "SelectedIndex");
			
			//Merge시 선택된 Value 인식하지 못함.
			Value = sheetObj.CellText(Row,prefixs[0]+"cntr_no");
			if(idx != -1) {
				if(idx != 0) {
		    		//Container No 셋팅
		    		setObjValue("set_cntr_no", Value);
		    		//Container 정보 조회
		    		searchCNTRInfo(sheetObj, Row, Col, Value);
		    	//Null을 선택할 경우 이전값으로 복귀
				} else {
					sheetObj.CellValue2(Row, prefixs[0]+"cntr_no") = beforeComboCntrNo;
					
					//Combo Filtering <-- 재선택을 위하여 --> 이벤트 유효화 시킴
					setFilterCNTRCombo(sheetObj, Row, Col);
				}				
			}
    	} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_clss_cd") {
    		var selVal = sheetObj.CellValue(Row, Col);
    		if (selVal == "1" || selVal == "1.1" || selVal == "1.2" || selVal == "1.3" || selVal == "1.4" || selVal == "1.5" || selVal == "1.6" ){
    			sheetObj.CellEditable(Row, prefixs[0]+"imdg_comp_grp_cd") = true;
    			sheetObj.CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = "A";
    		} else {
    			sheetObj.CellEditable(Row, prefixs[0]+"imdg_comp_grp_cd") = false;
    			sheetObj.CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = "";
    		}
    	}
	}
    
    /**
     * Sheet1 Popup Click Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			var imdgUnNo = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no");
			var imdgUnNoSeq = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no_seq");
			var vsl_slan_cd = getObjValue("vsl_slan_cd"); 
			ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq+"&lane_cd="+vsl_slan_cd, 940, 400, "setCallBackUNNo", "0,0,1,1,1,1,1,1", false,false, Row, Col, 0);
 		}
 	}
    
    /**
     * Sheet1 Cell Select Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 Row ==> NewRow, 선택한 Col ==> NewCol
     * 
     */
    var beforeComboCntrNo;
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	if(sheetObj.ColSaveName(OldCol) == prefixs[0]+"imdg_un_no_seq" 
    	&& sheetObj.CellValue(OldRow, OldCol-1) != ""
    	&& sheetObj.CellValue(OldRow, OldCol) != ""
    	&& !isHJSSEN()) {
    		searchUNNoInfo(sheetObj, OldRow, OldCol);
    	} else if(sheetObj.ColSaveName(NewCol) == prefixs[0]+"cntr_no" && isHJSSEN()) {
    		//Combo Filtering
    		setFilterCNTRCombo(sheetObj, NewRow, NewCol);
    	}
	}
    
    /**
     * Sheet1 OnAfterEdit Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[0]+"cell_psn_no") {
    		//Merge용으로 셋팅한 임시값 없애기
    		var cellPsnNo = sheetObj.CellText(Row, prefixs[0]+"cell_psn_no");
    		if(cellPsnNo == "") {
    			var stanCntrNo = sheetObj.CellText(Row, prefixs[0]+"cntr_no");
    			var rowCntrNo;
    			for(var rowIdx=Row; rowIdx<=sheetObj.LastRow; rowIdx++) {
    				rowCntrNo = sheetObj.CellText(rowIdx, prefixs[0]+"cntr_no");
    				if(stanCntrNo == rowCntrNo) sheetObj.CellValue(rowIdx, prefixs[0]+"cell_psn_no") = "0";
    			}
    		}
    	}
    }
    
    /*****************************************************************************************
     * Sheet 이벤트 처리 끝 *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * 화면 초기화 시작 *
     ****************************************************************************************/  

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
	/**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(preCondition) {
    	//Combo 초기화
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
        }
    	
    	//[#0-0]Sheet 기본 설정 및 초기화
    	setSelectedOption('init');
    	
    	//Upload Sheet 기본 설정 및 초기화
    	initUpload();
        
        //이벤트 리스너 등록
        initControl();
        
        //초기 조건 셋팅
        for(var condIdx=0; condIdx<4; condIdx++) {
        	setObjValue(preCondition[condIdx][0],preCondition[condIdx][1]);
        	if(condIdx<3) setObjValue("set_"+preCondition[condIdx][0],preCondition[condIdx][1]);
        }
        
        //조회
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"POP");
    }
    
    /**
     * Option 선택에 따른 초기화
     */
    function setSelectedOption(selVal) { 
    	
    	var cgo_opr_cd = getObjValue("cgo_opr_cd");
    	if (selVal==null || selVal==undefined) 
    		selVal = getObjValue("spcl_cgo_cate_cd");    	
    	
    	if(selVal == 'init' || cgo_opr_cd != '') {
	    	var sheetObj = sheetObjects[0];
	    	var formObj = document.form;
	    	
	    	//화면 로딩시에는 Option을 기본적으로 Dangerous Goods 으로 선택한다.
	    	if(selVal == 'init') selVal = "DG";
	    	
	    	//선택 Option 셋팅 --> Sheet 헤더 타입 결정
	    	setObjValue("set_spcl_cgo_cate_cd", selVal);
	    	
	    	//0. Option 을 변경할 경우 해당 Container 정보를 삭제상태로 변경하여 Parameter로 셋팅해 놓는다.
			setDelCNTRToForm(sheetObj, true);
	    	
	    	//1. Option 에 따른 Irregulars Type 가져오기    	
	    	doActionIBCombo(sheetObj,formObj,IBSEARCH_ASYNC01);
	    	
	    	//2. Sheet 형태 선택 후 초기화
	    	setSheet(sheetObj, selVal=='DG'?1:2);
	    	
	    	//3. Cargo Operator의 변경에 따른 초기화 --> Sheet 컬럼 타입결정 및 채우기
			resetBKGCntrInfo(true, false);	    	
	    	
    	} else {
    		if(selVal == 'AC') selVal = "DG";
    		else if(selVal == 'DG') selVal = "AC";
	    	
    		ComShowCodeMessage('SCG50007', 'Cargo Operator Code');	//'Please input {?msg1}.'	
    		
    		//이전상태로 원복하고 Cargo Operator 입력하도록 유도하기
    		setObjValue("spcl_cgo_cate_cd", selVal);
    		setFocus("cgo_opr_cd");    		
    	}
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     */
    function setSheet(sheetObj, sheetNo) { 
    	sheetObj.Reset();

    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj,sheetNo);    
    	ComEndConfigSheet(sheetObj);
    }
    
    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo(comboObj) {
	    switch(comboObj.id) {
	        case "spcl_cgo_irr_tp_cd":
	            with(comboObj) {
	            	SetTitle("Name|Code|Description");
	            	SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;	   
	    }
	}
    
    /**
     * Upload Sheet 기본 설정 및 초기화
     */
    function initUpload() { 
    	//Hidden Sheet 초기화
    	setSheet(sheetObjects[1], 3);
        
        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_0013GS.do");
		}
    }
    
    /**
     * 화면설정을 유지한체로 전체화면 Value 초기화
     */
    function initUI() { 
    	//1. 화면을 초기화 한다.
 	   	resetObjs();	 	
 	   	
 	    //2. Upload Sheet 기본 설정 및 초기화
    	initUpload();	
    	
    	//3. Sheet  초기화
    	sheetObjects[1].removeAll();
    	
    	//포커스 셋팅
        setFocus("vsl_cd");
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        sheetObj.WaitImageVisible = false;
        switch(sheetNo) {
            case 1:      // sheet1 init : Dangerous Goods
               with (sheetObj) {
                    // 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "CNTR No.|TP/SZ|Cell Position|Sel|Seq.|UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefixs[0]+"cntr_no",			false,           "",      dfNone, 			0,     true,       true,	14);
					InitDataProperty(0, cnt++ , dtCombo,		55,		daCenter,	true,	prefixs[0]+"cntr_tpsz_cd",		false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefixs[0]+"cell_psn_no",		false,           "",      dfNone, 			0,     true,       true,	6);
					
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	prefixs[0]+"del_chk");
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	prefixs[0]+"cgo_seq",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefixs[0]+"imdg_un_no",		false,           "",      dfNone, 			0,     true,       true,	4, true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	prefixs[0]+"imdg_un_no_seq",	false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtCombo,		65,		daCenter,	false,	prefixs[0]+"imdg_clss_cd",		false,           "",      dfNone, 			0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtCombo,		45,		daCenter,	false,	prefixs[0]+"imdg_comp_grp_cd",  false,           "",      dfNone, 			0,     false,      false);
					
					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		false,	prefixs[0]+"prp_shp_nm",		false,           "",      dfNone, 			0,     true,       true,	500);
					
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,	prefixs[0]+"spcl_cgo_irr_cntr_seq");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	prefixs[0]+"ibflag");
					
					InitDataValid(0, prefixs[0]+"cell_psn_no", vtNumericOther, "");
					
					ShowButtonImage = 1;

               }
               break;

            case 2:      // sheet2 init : Awkward Cargo
                with (sheetObj) {

                	// 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "CNTR No.|TP/SZ|AWK Type|Cell Position||Sel|Seq.|Weight(kg)|Weight(kg)|Dimension(cm)|Dimension(cm)|Dimension(cm)|Commodity||";
                    var HeadTitle2 = "CNTR No.|TP/SZ|AWK Type|Cell Position||Sel|Seq.|Gross|Net|L|W|H|Commodity||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,					95,		daCenter,	true,		prefixs[0]+"cntr_no",			false,           "",      dfNone, 			0,     true,       true,	14);
					InitDataProperty(0, cnt++ , dtCombo,				55,		daCenter,	true,		prefixs[0]+"cntr_tpsz_cd",		false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtCombo,				70,		daCenter,	true,		prefixs[0]+"spcl_cgo_cate_cd",  false,           "",      dfNone, 			0,     true,       true,	2);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefixs[0]+"cell_psn_no",		false,           "",      dfNone, 			0,     true,       true,	6);
					
					InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	false,		prefixs[0]+"seq",               false,           prefixs[0]+"cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	true,		prefixs[0]+"del_chk");
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,	true,		prefixs[0]+"cgo_seq",			false,           "",      dfNone, 			0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"awk_cgo_grs_wgt",	false,           "",      dfFloat, 			3,     true,       true,	18);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"awk_cgo_net_wgt",	false,           "",      dfFloat, 			3,     true,       true,	18);
					
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"dim_len",			false,           "",      dfFloat, 			2,     true,       true,	7);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"dim_wdt",			false,           "",      dfFloat, 			2,     true,       true,	7);					
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefixs[0]+"dim_hgt",			false,           "",      dfFloat, 			3,     true,       true,	8);
					
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,		true,		prefixs[0]+"cmdt_desc",		    false,           "",      dfNone, 			0,     true,       true,	4000);
										
					InitDataProperty(0, cnt++ , dtHidden,	    		10,		daCenter,	false,		prefixs[0]+"spcl_cgo_irr_cntr_seq");
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefixs[0]+"ibflag");
					
					InitDataValid(0, prefixs[0]+"cell_psn_no", vtNumericOther, "");
					
					InitDataCombo(0, prefixs[0]+"spcl_cgo_cate_cd", " |AW|RF|BB", " |AW|RF|BB");
					
               }
               break;
            case 3:      // sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    var HeadTitle = "|Seq.||File Name||ID|Date|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	        30,		daCenter,	false,	prefixs[1]+"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	false,	prefixs[1]+"No");
					InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   false,  prefixs[1]+"file_set_yn",	false,  "",     dfNone,         0,     		true,    	true);
					InitDataProperty(0, cnt++ , dtData,			245,	daCenter,	false,	prefixs[1]+"file_nm",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	    daCenter,	false,	prefixs[1]+"file_path_desc",false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	prefixs[1]+"cre_usr_id",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefixs[1]+"cre_dt",		false,	"",		dfDateYmd,		0,			true,		true);

					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	prefixs[1]+"spcl_cgo_irr_file_seq");
			   }
			   break;

        }
    }
    
    /*****************************************************************************************
     * 화면 초기화 끝 *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * 초기화 시작 *
     ****************************************************************************************/ 
    
    /**
     * Cargo Operator의 변경에 따른 초기화 : 타선사일 경우 Booking 정보를 Key In
     */
    function resetBKGCntrInfo(forceYn, keyInYn) {
    	var sheetObj = sheetObjects[0];
    	var formObj  = document.form;
    	
    	var set_cgo_opr_cd = getObjValue("set_cgo_opr_cd");   
    	var cgo_opr_cd 	   = getObjValue("cgo_opr_cd");    
    	
    	var set_vvd_cd = getObjValue("set_vsl_cd")+getObjValue("set_skd_voy_no")+getObjValue("set_skd_dir_cd");   
    	var vvd_cd = getObjValue("vsl_cd")+getObjValue("skd_voy_no")+getObjValue("skd_dir_cd");   
    	
    	var set_irr_occr_dt = ComReplaceStr(getObjValue("set_irr_occr_dt"),"-","");   
    	var irr_occr_dt = ComReplaceStr(getObjValue("irr_occr_dt"),"-","");    
    	
    	//변경되었을 경우에만 수행
    	if(forceYn || set_cgo_opr_cd != cgo_opr_cd || set_vvd_cd != vvd_cd || set_irr_occr_dt != irr_occr_dt) {
    		//0. Cargo Operator 를 변경할 경우 해당 Container 정보를 삭제상태로 변경하여 Parameter로 셋팅해 놓는다.
			setDelCNTRToForm(sheetObj, true);
			
	    	//1. Booking 정보 초기화
			initObjs("form", formObj, strBKGOptions, -1, "");
			
	    	//2. Container 정보 초기화 <-- Sheet Grid 초기화
	    	sheetObj.RemoveAll();
	    	
			//3. Container 정보 Key In OR 조회선택 형태 결정 <-- Column 형식 변경
			setSheetColProp(sheetObj, formObj); 
			
			//4. Cargo Operator 항목 셋팅
			if(keyInYn && cgo_opr_cd != '') searchCarrierInfo(cgo_opr_cd);
	   		
			//5. 변경된 Cargo Operator 코드 셋팅
			setObjValue("set_cgo_opr_cd", cgo_opr_cd);
			
			//6. 한진인가? 스타일 필수로 변경    		
			setRequiredForm();
    	}
    }  
    
    /**
     * 선택된 Object의 초기화와 포커스 이동
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs = nameVars.split("|");
    	
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		
    		if(type == 'sheet') sheetObj.CellValue2(etcVal, prefixs[0]+nameArrs[objIdx]) = "";
    		else ComClearObject(eval("document.form."+nameArrs[objIdx]));
    		
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, focusIdx);
    			else setFocus(nameArrs[objIdx]);
    		}
    	}
    }
    
    /**
     * 선택된 Cell의 초기화와 포커스 이동
     */
    function initCell(sheetObj, Row, Col) {
    	sheetObj.CellValue2(Row,Col) = "";
		sheetObj.SelectCell(Row,Col);
    }
    
    /**
     * document 안에 있는 모든 Object의 값을 초기화
     */
    function resetObjs() {
    	ComResetAll();
    }  
    
    /**
     * 조회후 조회조건외 화면 초기화
     */
    function resetExCondObj(sheetObj){
    	//1. 조회조건회 폼 초기화
    	setObjValue("spcl_cgo_irr_seq", "");
    	setObjValue("irr_smry_rmk", ""); 
    	setObjValue("irr_rsn_rmk", "");       
    	setObjValue("cmsr_desc", "");   
    	setObjValue("file_cnt", "0");  
    	
    	//2. Upload Sheet 기본 설정 및 초기화
    	initUpload();	
    	
    	//3. 생성해 놓은 파라미터 폼 삭제 
    	setDelCNTRToForm(sheetObj, false);
    }
    
    /*****************************************************************************************
     * 초기화 끝 *
     ****************************************************************************************/ 

    /*****************************************************************************************
     * 팝업창의 Call Back 처리 시작 *
     ****************************************************************************************/  
    
    /**
  	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					
					//포커스 이동
					setFocus("skd_voy_no");
				}
			}
    	}
  	} 
  	
    /**
  	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("skd_voy_no", rtnDatas[2]);
					setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
    	}
  		
  		//[#1-2]VVD 관련 항목 채우기
  		searchVVDInfo();
  		
  		//[#1-3]Cargo Operator에 따라 초기화 작업 수행
    	resetBKGCntrInfo(false, false); 	
  	} 
  	
  	/**
  	 * Carrier Code Inquiry부분.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function setCallBackCP(aryPopupData) {
  		setObjValue("cgo_opr_cd", aryPopupData[0][3]);
  		setObjValue("cgo_opr_nm", aryPopupData[0][4]);
  		
  		//[#3-2]Cargo Operator에 따라 초기화 작업 수행
  		resetBKGCntrInfo(false, false);
  	} 
  	
  	/**
	 * Sheet1 OnPopupClick ImdgUnNoSeq 이벤트 처리에 대한 CallBack 함수 
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param seetIdx 
	 * @return
	 */
	function setCallBackUNNo(aryPopupData, row, col, seetIdx){
		//UN No., Seq., Class, Class Comp Group, Proper Shipping Name	
		setUNNoInfo(seetIdx, row, aryPopupData[0][2], aryPopupData[0][3], aryPopupData[0][4], aryPopupData[0][10], aryPopupData[0][6]);
	}
  	
  	/*****************************************************************************************
     * 팝업창의 Call Back 처리 끝 *
     ****************************************************************************************/  
  	
  	/*****************************************************************************************
     * Setter/Getter 시작 *
     ****************************************************************************************/ 
  	
  	/**
     * VVD 정보 관련 항목 셋팅 : VVD, Lane, Vessel Operator
     */
    function setVVDInfo(formObj, sXml) { 	 
    	var vvdData = ComScgXml2Array(sXml, strVVDOptions);
    	
 	   	if(vvdData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		} else {
 	   			var arrHeads = strVVDOptions.split("|");
 	   			for(var headIdx=3; headIdx<arrHeads.length; headIdx++) {
 	   				setObjValue(arrHeads[headIdx], vvdData[0][headIdx]);
 	   			}
 	   			//Subject 명 Prefix 구성
 	   			var subjectStr = "["+vvdData[0][4]+"] "+vvdData[0][0]+vvdData[0][1]+vvdData[0][2]+" - "; 	
 	   			setObjValue("irr_subj_nm", subjectStr);
 	   			
 	   			//변경된 VVD 코드 셋팅
 				setObjValue("set_vsl_cd", 	  getObjValue("vsl_cd"));
 				setObjValue("set_skd_voy_no", getObjValue("skd_voy_no"));
 				setObjValue("set_skd_dir_cd", getObjValue("skd_dir_cd"));
 				
 				//포커스 이동
 				setFocus("irr_occr_dt");
 	   		}
 	   	}
 	   	//조회된 Key 값 초기화
 	   	setObjValue("spcl_cgo_irr_seq", "");
    }
    
    /**
     * Cargo Operator 항목 셋팅 : Cargo Operator
     */
    function setCarrierInfo(formObj, sXml, cgoOprCd) { 	
    	var carrierData = ComScgXml2Array(sXml, "crr_cd|crr_nm");
    	
 	   	if(carrierData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, "cgo_opr_cd|cgo_opr_nm", 0, "");
 	   	} else {
 	   		if(carrierData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   		} else {
 	   			setObjValue("cgo_opr_nm", carrierData[0][1]);
 	   		}
 	   	}
    }
    
    /**
     * Booking 정보 관련 항목 셋팅 : BKG No., B/L No., POR, POL, POD, Delivery, SHPR, FWDR, CNEE, dcgo_flg, rc_flg, awk_cgo_flg, bb_cgo_flg
     */
    function setBKGInfo(sheetObj, formObj, sXml, focusIdx) {    	
    	var bkgData = ComScgXml2Array(sXml, strBKGOptions);
 	    
    	var set_bkg_no = "", set_bl_no = "";
 	   	if(bkgData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data'");	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, strBKGOptions, focusIdx, "");
 	   	} else {
 	   		if(bkgData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   			initObjs("form", formObj, strBKGOptions, focusIdx, "");
 	   		} else {
 	   			var arrHeads = strBKGOptions.split("|");
 	   			for(var headIdx=0; headIdx<arrHeads.length; headIdx++) {
 	   				setObjValue(arrHeads[headIdx], bkgData[0][headIdx]);
 	   			}
 	   			set_bkg_no = bkgData[0][0];
 	   			set_bl_no = bkgData[0][1];
 	   			
 	   			//Container Combo 목록 조회
 	      		searchCNTRList(sheetObj, formObj);
 	   		}
 	   	}
 	   	//현재값 셋팅
 	   	setObjValue("set_bkg_no",set_bkg_no);
		setObjValue("set_bl_no", set_bl_no);
    }
    
    /**
     * Sheet Column 재정의
     */
    function setSheetColProp(sheetObj, formObj) {
    	//Column 형식 변경(2x2)
    	with (sheetObj) {
    		var selIdx = getObjValue("set_spcl_cgo_cate_cd");
    		
    		//데이타 삭제 <-- Row를 유지할경우 ibFlg가 U상태로 유지되므로 초기화가 필요하다.
    		removeAll();
    		
    		//1. 한진인가?
    		if(isHJSSEN()) {
    			//2. Option이 무엇인가?
    			if(selIdx == 'DG') {
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),          dtCombo, 95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true,  true,14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),     dtData,  55, daCenter, true,  prefixs[0]+"cntr_tpsz_cd",     false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),   dtData,  55, daCenter, false, prefixs[0]+"imdg_un_no_seq",   false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),     dtData,  65, daCenter, false, prefixs[0]+"imdg_clss_cd",     false, "", dfNone, 0, true,  true, 3);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"), dtData,  45, daCenter, false, prefixs[0]+"imdg_comp_grp_cd", false, "", dfNone, 0, false, false);
    			} else {
    				InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),      dtCombo, 95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true, true, 14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"), dtData,  55, daCenter, true,  prefixs[0]+"cntr_tpsz_cd",     false, "", dfNone, 0, true, true, 4);
    			}
    		} else {
    			if(selIdx == 'DG') {
	    			InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),          dtData,      95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true,  true,14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),     dtCombo,     55, daCenter, true, prefixs[0]+"cntr_tpsz_cd",      false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),   dtPopupEdit, 55, daCenter, false, prefixs[0]+"imdg_un_no_seq",   false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),     dtCombo,     65, daCenter, false, prefixs[0]+"imdg_clss_cd",     false, "", dfNone, 0, true,  true, 3);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"), dtCombo,     45, daCenter, false, prefixs[0]+"imdg_comp_grp_cd", false, "", dfNone, 0, false, false);
		    		
		    		//Class Combo 목록 가져오기
	    	   		searchClsList(formObj);
	    	   		//Class Comp Group Combo 목록 가져오기
	    	   		searchClsCompGrpList(formObj);
    			} else {
    				InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),      dtData,  95, daCenter, true, prefixs[0]+"cntr_no",      false, "", dfNone, 0, true, true, 14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"), dtCombo, 55, daCenter, true, prefixs[0]+"cntr_tpsz_cd", false, "", dfNone, 0, true, true, 4);
    			}
    			//Container No. 대문자 처리
    			InitDataValid(0, prefixs[0]+"cntr_no", vtEngUpOther, "1234567890-");
    			//TP/SZ Combo 목록 가져오기
    	   		searchTPSZList(formObj);
    		}
    	}
    }
    
    /**
     * Container Combo 목록 셋팅
     */
    var arrCombo;
    function setCNTRCombo(sXml, sheetObj) {
    	arrCombo = ComXml2ComboString(sXml, prefixs[0]+"cntr_no", prefixs[0]+"cntr_no");
    	if(arrCombo != null && arrCombo.length > 0) 
    		sheetObj.InitDataCombo(0, prefixs[0]+"cntr_no", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");
    }
    
    /**
     * Container Combo List를 필터링한다.
     */
    var beforeComboCntrNo;
    function setFilterCNTRCombo(sheetObj, Row, Col) {  
    	if(arrCombo != null) {
    		var cCombos = arrCombo[0].split("|");
			
			var cCombo = new Array();
			var selVal = sheetObj.CellValue(Row, Col);
			//Null이 아닐경우 자신의 값만 가진 콤보 생성
    		if(selVal != '') {
    			for(var comIdx1=0; comIdx1<cCombos.length; comIdx1++) {
    				if(selVal == cCombos[comIdx1]) cCombo[comIdx1]  = cCombos[comIdx1];
    			}
    			
    			//현재값 셋팅
    			beforeComboCntrNo = selVal;
    		//Null일 경우 현재 Sheet에 셋팅되지 않은 값만으로 구성된 콤보 생성
    		} else {
    			var isCt = 0, cIdx = 0;
    			for(var comIdx2=0; comIdx2<cCombos.length; comIdx2++) {
    				isVal = 0;
	    			for(var rowIdx=sheetObj.HeaderRows; rowIdx<sheetObj.LastRow; rowIdx++) {
	    				if(sheetObj.CellValue(rowIdx, Col) == cCombos[comIdx2]) isVal++;
	    			}
	    			if(isVal == 0) cCombo[cIdx++] = cCombos[comIdx2];
    			}
    		}
    		
    		sheetObj.CellComboItem(Row, Col, "| |"+cCombo.join("|"), "|NULL|"+cCombo.join("|"), 0);
		}
    }
    
    /**
     * TP/SZ Combo 목록 셋팅
     */
    function setTPSZCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObjects[0].InitDataCombo(0, prefixs[0]+"cntr_tpsz_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");
    }
    
    /**
     * Class Combo 목록 셋팅
     */
    function setClsCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var comboCds = arrCombo[0].split("|");
    		var comboTxts = arrCombo[1].split("|");
    		var comboTxtStrs = "";
    		for(var colIdx=0; colIdx<comboCds.length; colIdx++) {
    			comboTxtStrs += "|"+comboCds[colIdx]+"\t"+comboTxts[colIdx];
    		}
    		
    		sheetObjects[0].InitDataCombo(0, prefixs[0]+"imdg_clss_cd", "| "+comboTxtStrs, "| |"+arrCombo[0], "", "", 0);
    	}
    }
    
    /**
     * Class Comp Group Combo 목록 셋팅
     */
    function setClsCompGrpCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
    	
    	if(arrCombo != null && arrCombo.length > 0) 
    		sheetObjects[0].InitDataCombo(0, prefixs[0]+"imdg_comp_grp_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");    	
    }
    
    /**
     * UN No. 관련정보 셋팅
     */
    function setUNNoInfo(seetIdx, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm) {    
    	sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_un_no")       = imdg_un_no;			//UN No.
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_un_no_seq")   = imdg_un_no_seq;		//Seq.
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_clss_cd")     = imdg_clss_cd;		//Class
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = imdg_comp_grp_cd;	//Class Comp Group
	 
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"prp_shp_nm")       = prp_shp_nm;			//Proper Shipping Name	
    }
    
    /**
     * Container 정보 관련 항목 셋팅 : 
     * 1. Dangerous Goods : TP/SZ, UN No/Seq, Class, Proper Shipping Name	
     * 2. Awkward Cargo : TP/SZ, AWK_Type, Gross, Net, L, W, H, Commodity
     */
    function setCNTRInfo(sheetObj, Row, Col, sXml, Value) {
    	var sArr = ComScgXml2Array(sXml, prefixs[0]+"cntr_no");
		if(sArr == null) {
			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			
			//Sheet Row 초기화
			var nameVars = "", nameVar = "";
			for(var paramIdx=0; paramIdx<sheetObj.LastCol-1; paramIdx++) {
				nameVar = sheetObj.ColSaveName(paramIdx);
				nameVars += nameVar.substring(7,nameVar.length);
				nameVars += "|";
			}
			if (nameVars != "") nameVars = nameVars.substr(0, nameVars.length -1);
			
			initObjs("sheet", sheetObj, nameVars, -1, Row);
		} else {			
			//Sheet Row 값 셋팅 <-- ibFlag는 셋팅하지 않는다.
			var cntrNoCol = sheetObj.SaveNameCol(prefixs[0]+"cntr_no");
			var cntrNo = "", cgoSeq = "", dupRowIdx = -1, colValue = "";
			for(var rsltRowIdx = 0; rsltRowIdx<sArr.length; rsltRowIdx++) {
				//첫 Row와 기존에 있는 Row의 경우 덮어쓰기
				cntrNo = ComScgXml2Array(sXml,prefixs[0]+"cntr_no")[rsltRowIdx];
				cgoSeq = ComScgXml2Array(sXml,prefixs[0]+"cgo_seq")[rsltRowIdx];
				
				dupRowIdx = colDupCheck(sheetObj, cntrNo+cgoSeq);
				if(rsltRowIdx != 0 && dupRowIdx == -1) sheetObj.DataInsert(Row-1,0);	//Tip! : Header가 2일 경우 1부터 첫행이고 Header가 1일 경우 0부터 첫행이다.
				for(var paramIdx=sheetObj.SaveNameCol(prefixs[0]+"cntr_no"); paramIdx<sheetObj.LastCol-1; paramIdx++) {
					colValue = ComScgXml2Array(sXml,sheetObj.ColSaveName(paramIdx))[rsltRowIdx];
					if(colValue != "" && sheetObj.CellValue(Row, paramIdx) == "") {
						sheetObj.CellValue(Row, paramIdx) = colValue;
						sheetObj.CellText(Row, paramIdx) = colValue;
					}
				}
				
				//Merge를 위해 Cell Position값을 임의로 셋팅
				sheetObj.CellValue(Row, sheetObj.SaveNameCol(prefixs[0]+"cell_psn_no")) = "0";
	    		
				Row++;
			}
		}
	}
		
	/**
     * Option 을 변경할 경우 해당 Container 정보를 삭제상태로 변경하여 Parameter로 셋팅해 놓는다.
     */
    function setDelCNTRToForm(sheetObj, option) {  
    	var paramObj = document.getElementById('cntr_del_param');
    	if(option) {    		
    		if(paramObj == null && sheetObj.RowCount > 0) {
		    	var formObj = document.form;
		    	var dyParamDiv = document.createElement("<div name='cntr_del_param' id='cntr_del_param' style='display:'></div>");
		    	var ibFlag, valParam1, valParam2;
		    	for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {   
		    		ibFlag = sheetObj.CellValue(rowIdx, prefixs[0]+"ibflag");
		    		if(ibFlag != 'I') {
			    		valParam1 = document.createElement("<input type='hidden' name='sheet1_ibflag' value='D'>");
			    		valParam2 = document.createElement("<input type='hidden' name='sheet1_spcl_cgo_irr_cntr_seq' value='"+sheetObj.CellValue(rowIdx, prefixs[0]+"spcl_cgo_irr_cntr_seq")+"'>");
			    		dyParamDiv.appendChild(valParam1);
			    		dyParamDiv.appendChild(valParam2);   
		    		}
		    	}
		    	formObj.appendChild(dyParamDiv);
    		}
    	} else {
    		if(paramObj != null) paramObj.removeNode(true);
    	}
    }
    
    /**
     * document 안에 있는 특정 Object의 값을 Parameter로 생성
     */
    function FormParamString(form, type) {
        var name = new Array(form.elements.length);
        var value = new Array(form.elements.length);
        var j = 0;
        var plain_text="";

        //사용가능한 컨트롤을 배열로 생성한다.
        var len = form.elements.length;
        var objType;
        for (var i = 0; i < len; i++) {
        	objType = form.elements[i].type;
        	if(type == objType) {
        		switch (form.elements[i].type) {
        			case "hidden":
        				name[j] = form.elements[i].name;
        				name[j] = ComReplaceStr(name[j],"set_","");
                        value[j] = form.elements[i].value;
                        j++;
                        break;
        		}
            }
        }

        // QueryString을 조합 & URL Encoding
        var webBrowserName = navigator.appName;
        var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                            navigator.appVersion.indexOf("MSIE") + 8)

        if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
            for (i = 0; i < j; i++) {
                if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
            }
        }

        //마지막에 &를 없애기 위함
        if (plain_text != "") plain_text = plain_text.substr(0, plain_text.length -1);
        
        return plain_text;
    }
    
    /**
     * EtcData의 값을 Form에 셋팅한다.
     */
    function setXmlEtcDataToForm(formObj, sXml) {
    	var iMatchCnt = 0;
    	try {
    		var elements = formObj.elements;

    		// 사용가능한 HTML컨트롤을 배열로 생성한다.
    		for ( var i = 0; i < elements.length; i++) {
    			var sValue, eNmPrefix, eName;
    			if (elements[i].classid == undefined) {
    				eName = elements[i].name; 	// Html오브젝트인경우
    			} else {
    				eName = elements[i].id; 	// IBMultiCombo인경우
    			}
    			
    			//예외항목들
    			if (eName == "" || eName == "vsl_slan_cd" || eName == "vsl_slan_nm" || eName == "vsl_opr_tp_cd")
    				continue;
    			
    			//set_XXXX Hidden 오브젝트인 경우 'set_' Prefix를 Trim후 값 가져오기
    			eNmPrefix = eName.substring(0,4);
    			if(eNmPrefix == 'set_') eName = eName.substring(4,eName.length);

    			sValue = ComGetEtcData(sXml, eName);
    			
    			// 해당이름의 EtcData가 없는 경우 다음 항목 찾기
    			if (sValue == undefined)
    				continue;

    			// radio인 경우 같은이름으로 여러개 있는 경우
    			if (elements[i].type == "radio") {
    				var eRadio = document.all[eName];
    				// 첫번째 radio만 체크하고 나머지 건너뛰기
    				if (eRadio.length > 1)
    					i += (eRadio.length - 1);

    				if (sValue != undefined) {
    					ComSetObjValue(eRadio, sValue);
    					iMatchCnt++;
    				}
    				continue;
    			}

    			// radio인 경우를 제외하고 모두 여기서 값이 설정된다.
    			ComSetObjValue(elements[i], sValue);

    			iMatchCnt++;
    		}// for
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}

    	return iMatchCnt;
    }
    
    /**
     * Cargo Operator 의 HJS 또는 SEN 입력여부
     */
    function isHJSSEN() {
    	var value = getObjValue("cgo_opr_cd");
    	
    	if(value == '' || value == 'SML' || value == 'SEN')
    		return true;
    	
    	return false;
    }
    
    /**
     * Cargo Operator가 HJS일 경우 BKG No., B/L No. 필수입력 항목으로 표시와 입력 자리수 변경
     */
    function setRequiredForm() {
    	var itemObj;
    	var arrForms = strBKGOptions.split("|");
		for(var itemIdx=0; itemIdx<2; itemIdx++) {
			itemObj = document.getElementsByName(arrForms[itemIdx])[0];
			if(isHJSSEN()) {
				itemObj.className = "input";
				itemObj.setAttribute("required", "true");
				if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 11);
				itemObj.setAttribute("fullfill", "true");
				itemObj.readOnly = false;
			} else {
				if(itemObj.name == 'bl_no') {
					itemObj.className = "input2";
					itemObj.readOnly = true;
				} else {
					itemObj.className = "input";
				}
				
				itemObj.removeAttribute("required");
				if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 30);
				itemObj.removeAttribute("fullfill");
			}
		}
    }
    
    /**
	 * 팝업 IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다.
	 **/
	function setFileUpload(aryPopupData) {
		var sheetObj  = sheetObjects[1];
		var uploadObj = uploadObjects[0];
		
		uploadObj.Files="";					//먼저기존파일을 모두 지운후 추가함
		sheetObj.removeAll();
		
		var file_cnt = 0;
		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
			var fileSetYn = aryPopupData[rowIdx][2];	//신규추가 파일여부 확인
			var ibFlag    = aryPopupData[rowIdx][0];	//Row 상태
			
			//파일 경로 가져오기
			if(fileSetYn == 'Y') {
				var sFile = aryPopupData[rowIdx][3];
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				
				//IBUpload에 파일 추가하기
				var ret = uploadObj.AddFile(sFile);
			}
			
			//파일 갯수 가져오기
			if(ibFlag != 'D') file_cnt++;
			
			//Sheet 정보 가져오기			
			sheetObj.DataInsert(-1,0);	//신규행 생성
			for (var colIdx=0; colIdx<=sheetObj.LastCol; colIdx++){ 
				sheetObj.CellValue2(rowIdx+1, colIdx) = aryPopupData[rowIdx][colIdx];
			}
		}
		//파일 갯수 셋팅
		setObjValue("file_cnt", file_cnt);
	
		return; 
	}
	
	/**
	 * 업로드용 Hidden IBSheet의 정보를 가져온다.
	 **/
	function getFileUpload() {
	
		return sheetObjects[1]; 
	}
	
	/**
     * 조회 후 화면 구성
     */
    function setAfterSearch(sXml, sheetObj, formObj) {
    	//조회성공|실패 결정 인자
    	var spcl_cgo_irr_seq = ComGetEtcData(sXml,"spcl_cgo_irr_seq");
    	
    	if(spcl_cgo_irr_seq != '' && spcl_cgo_irr_seq != 'null') {
    		
	    	//1. 화면을 초기화 한다.
	 	   	resetObjs();	 	    
	    	initUpload();	//Upload Sheet 기본 설정 및 초기화
	    	
	 	   	//2. 조회한 Irregular 일반정보를 셋팅한다.
	 	   	setXmlEtcDataToForm(formObj, sXml);
	 	   	
	 	   	//3. VVD 일반정보를 조회하여 셋팅한다.
	 	   	searchVVDInfo();
	 	    
	 	   	//4. Option을 선택한후 수행되는 Step을 기본적으로 수행한다.
	 	    setSelectedOption();
	 	   
	 	    //5. 다시 조회한 Irregular 일반정보를 셋팅한다.
	 	    setXmlEtcDataToForm(formObj, sXml);
	 	   
	 	    //6. Booking 일반정보를 조회하여 셋팅한다.
	 	    searchBKGInfo(-1);
	 	    
	 	    //7. Container 정보를 Sheet에 채운다.
	 	    if(sXml.length>0) sheetObj.LoadSearchXml(sXml);	 	    

    	} else {
    		//조회 결과 메시지 보이기
    		if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
    		
    		//조회조건을 제외한 화면 초기화
    		resetExCondObj(sheetObj);
    	}
    }
    
    /**
     * Get Count of Search List
     */
    function getTotal(sXml){
	    if ( sXml == null  || sXml == "" ) return;

	    try {
	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
	        xmlDoc.loadXML(sXml);

	        var xmlRoot = xmlDoc.documentElement;
	        if(xmlRoot == null) return;

	        var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	      
	        if(dataNode == null) return "";

	        return dataNode.getAttribute("TOTAL");
	    } catch(err) { ComFuncErrMsg(err.message); }
	} 
	
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    }
  	
  	/*****************************************************************************************
     * Setter/Getter 끝 *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * Transaction 시작 *
     ****************************************************************************************/ 
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,source) {
    	sheetObj.ShowDebugMsg = false;   
        switch(sAction) {

           case IBSEARCH:      //조회        	   
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
        	   
        	   //Sequence 초기화
        	   if(source == 'SELF') setObjValue("spcl_cgo_irr_seq","");
        	   
        	   formObj.f_cmd.value = SEARCH;
        	   var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[0]);
        	   
        	   var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", sParam);
        	   
        	   //[#9-9]조회 후 화면 구성
        	   setAfterSearch(sXml, sheetObj, formObj);

               break;
           
           case IBCLEAR:      
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
        	   
    		   //화면설정을 유지한체로 전체화면 Value 초기화
    		   initUI();
    		   
    		   //포커스 셋팅
    	       setFocus("vsl_cd");
        		   
               break;  
        }
        
        //생성해 놓은 파라미터 폼 삭제 
    	setDelCNTRToForm(sheetObj, false);
    }
    
    // IBCombo관련 프로세스 처리
    function doActionIBCombo(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	//Irregulars Type Combo Box Item 가져오기 - Option별 구분
        	case IBSEARCH_ASYNC01:
        		formObj.f_cmd.value = SEARCH04;        	   
        		var set_spcl_cgo_cate_cd = getObjValue("set_spcl_cgo_cate_cd");
        	   
        		var sParam = FormQueryString(formObj);
        		if(set_spcl_cgo_cate_cd == 'DG') 
        			sParam += "&dg_flg=Y";
        		else 
        			sParam += "&awk_flg=Y";
        		
        		var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", sParam);
        		ComXml2ComboItem(sXml, formObj.spcl_cgo_irr_tp_cd, "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_nm|spcl_cgo_irr_tp_cd|spcl_cgo_irr_tp_desc");
        		formObj.spcl_cgo_irr_tp_cd.Index = 0;
			   
        		break;
        }
    }
  	
  	/**
     * VVD 정보 조회
     */
    function searchVVDInfo() {
    	var formObj = document.form;
    	
    	formObj.f_cmd.value = SEARCH05;
 	   	var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)); 	   	
 	    
 	   	//VVD 정보 관련 항목 셋팅
 	    setVVDInfo(formObj, sXml);
    }
    
    /**
     * Cargo Operator 정보 조회
     */
    function searchCarrierInfo(cgoOprCd) {
    	var formObj = document.form;
    	
    	formObj.f_cmd.value = SEARCH01;
 	   	var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)+"&crr_cd="+cgoOprCd); 	   	
 	    
 	   	//Cargo Operator 항목 셋팅
 	    setCarrierInfo(formObj, sXml, cgoOprCd);
    }
    
    /**
     * Booking 정보 조회
     */
    function searchBKGInfo(focusIdx) {
    	//타선사일 경우는 수행하지 않는다.
    	if(isHJSSEN()) {
    		var sheetObj = sheetObjects[0];
	    	var formObj = document.form;
	    	
	    	//BKG No. 와  B/L No. 가 null일경우 무효처리
	    	if(getObjValue("bkg_no") == "" && getObjValue("bl_no") == "") return; 
	    	
	    	//BKG No. 와  B/L No. 가 변경이 없을 경우 무효처리
	    	if(focusIdx == 0 && getObjValue("set_bkg_no") == getObjValue("bkg_no")) return;
	    	if(focusIdx == 2 && getObjValue("set_bl_no") == getObjValue("bl_no")) return;
	    	
	    	//VVD 정보는 Key 이므로 기본 적으로 확인한다.
    		if(!ComChkObjValid(formObj.vsl_cd) || !ComChkObjValid(formObj.skd_voy_no) || !ComChkObjValid(formObj.skd_dir_cd)) {
    			setObjValue("set_bl_no","");
	    		setObjValue("bl_no","");
	    		setObjValue("set_bkg_no","");
	    		setObjValue("bkg_no","");
	    			
	    		return;
    		}
    		
	    	//서로간의 값을 초기화
	    	if(focusIdx == 0 && getObjValue("bkg_no") != "") {
	    		setObjValue("set_bl_no","");
	    		setObjValue("bl_no","");
	    	} else if(focusIdx == 2 && getObjValue("bl_no") != "") {
	    		setObjValue("set_bkg_no","");
	    		setObjValue("bkg_no","");
	    	}
	    	
	    	formObj.f_cmd.value = SEARCH01;
	 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", FormQueryString(formObj));
	 	   	
	 	    //BKG No. 정보 관련 항목 셋팅
	 	    setBKGInfo(sheetObj, formObj, sXml, focusIdx);
    	}
    }
    
    /**
     * Container Combo 목록 조회
     */
    function searchCNTRList(sheetObj, formObj) {  
    	formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefixs[0]));

		//Container Combo 목록 셋팅
		setCNTRCombo(sXml, sheetObj);
    }
    
    /**
     * Container 정보 조회
     */
    function searchCNTRInfo(sheetObj, Row, Col, Value)  {
    	var formObj = document.form;    	
    	formObj.f_cmd.value = SEARCH03;
    	var sParam = FormParamString(formObj, "hidden");
 	    
		var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", sParam+ "&" + ComGetPrefixParam(prefixs[0]));
		
		//Container 정보 관련 항목 셋팅
		setCNTRInfo(sheetObj, Row, Col, sXml, Value);		
	}
    
    /**
     * TP/SZ Combo 목록 조회
     */
    function searchTPSZList(formObj) {  
    	formObj.f_cmd.value = SEARCH06;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		
		//TP/SZ Combo 목록 셋팅
		setTPSZCombo(sXml);
    }
    
    /**
     * Class Combo 목록 조회
     */
    function searchClsList(formObj) {  
    	formObj.f_cmd.value = SEARCH02;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
		
		//Class Combo 목록 셋팅
		setClsCombo(sXml);
    }
    
    /**
     * Class Comp Group Combo 목록 조회
     */
    function searchClsCompGrpList(formObj) {  
    	formObj.f_cmd.value = SEARCH08;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		
		//Class Comp Group Combo 목록 셋팅
		setClsCompGrpCombo(sXml);
    }
    
    /**
     * UN No. 관련 정보 조회
     */
    function searchUNNoInfo(sheetObj, Row, Col) {  
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH05;
    	
    	var imdgUnNo = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no");
		var imdgUnNoSeq = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no_seq");
		
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq);
		
		var sArr = ComScgXml2Array(sXml, "imdg_un_no");
		
		var imdg_un_no       = "";
		var imdg_un_no_seq   = ""; 
		var imdg_clss_cd     = "";
		var imdg_comp_grp_cd = "";
		var prp_shp_nm       = "";
		
		if(sArr == null) {
			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			
			//Sheet Row 초기화			
			initObjs("sheet", sheetObj, prefixs[0]+"imdg_un_no|"+prefixs[0]+"imdg_un_no_seq", 0, Row);
		} else {
			imdg_un_no       = ComScgXml2Array(sXml, "imdg_un_no")[0];
			imdg_un_no_seq   = ComScgXml2Array(sXml, "imdg_un_no_seq")[0];
			imdg_clss_cd     = ComScgXml2Array(sXml, "imdg_clss_cd")[0];
			imdg_comp_grp_cd = ComScgXml2Array(sXml, "imdg_comp_grp_cd")[0];
			prp_shp_nm       = ComScgXml2Array(sXml, "prp_shp_nm")[0];
		}	
		
		//UN No. 정보 셋팅
		setUNNoInfo(0, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm);
    }
    
    /*****************************************************************************************
     * Transaction 끝 *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * Validation 시작 *
     ****************************************************************************************/ 
    
    /**
     * Grid 내의 특정 Column 중복 여부 체크
     */
    function colDupCheck(sheetObj, Value) {    	
    	if(Value != '') {       		
    		var loopVal;
	    	for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	    		loopVal = sheetObj.CellText(rowIdx, prefixs[0]+"cntr_no") + sheetObj.CellValue(rowIdx, prefixs[0]+"cgo_seq");	    		
	    		if(loopVal == Value) {
		    		return rowIdx;
		    	}
	    	}
    	}

    	return -1;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {

        	case IBSEARCH:
        		//VVD 정보는 Key 이므로 기본 적으로 확인한다.
        		if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
        		if(!ComChkObjValid(formObj.skd_voy_no)) return false;
        		if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
        		
        		//Sequence를 체크하여 조회시 필수항목 분리
        		var spcl_cgo_irr_seq = getObjValue("spcl_cgo_irr_seq");
        		if(spcl_cgo_irr_seq == '') {
	        		//Irregular Occurred 필수입력
	        		if(!ComChkObjValid(formObj.irr_occr_dt)) return false;
	        		
	        		//Cargo Operator 필수입력
	        		if(!ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		}
        		
        		//BKG No.가 조회 조건으로 입력되었을 경우 Cargo Operator가 bkg_no와 bkg_ref_no를 결정하기 위해 필수항목으로 체크한다.
        		if(getObjValue("bkg_no") != '' && !ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		break;
    	}

        return true;
    }
    
    /*****************************************************************************************
     * Validation 끝 *
     ****************************************************************************************/ 

	/* 개발자 작업  끝 */