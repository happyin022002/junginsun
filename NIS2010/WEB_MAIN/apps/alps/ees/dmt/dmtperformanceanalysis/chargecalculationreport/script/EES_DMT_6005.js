/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6005.js
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
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
     * @class EES_DMT_6005 : EES_DMT_6005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6005() {
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
	var initOfcCurrDate = "";

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
     		
     		// 팝업창 링크 아이콘 클릭시  비활성화 상태이면 그냥 return
     		if(!ComIsBtnEnable(srcName)) return;

     		switch(srcName) {
     			case "btns_calendar":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
					break;
					
     			case "btns_calendar1": //달력 버튼
					var cal = new ComCalendarFromTo();
					cal.select(formObj.fm_aply_dt1, formObj.to_aply_dt1, 'yyyy-MM-dd');
    				break;
    				
                case "btns_calendar2": //달력 버튼
         			 var cal = new ComCalendar();
         		     cal.setDisplayType('month');
         		     cal.select(formObj.cost_yrmon1, 'yyyy-MM');

    				break;
        		     
     			case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				
				case "btn_New":
					doInit();
					break;
					
				case "btn_Minimize":
					var schCondDiv = document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {	// 조건 선택부분 보임 상태
 						schCondDiv.style.display = 'none';
 						sheetObj.style.height = 500;
 					} else {
 						schCondDiv.style.display = 'block';
 						sheetObj.style.height = 370;
 					}
					break;	
				
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
					break;
					
				case "btn_Detail":
					doProcessPopup(srcName);
					break;
					
				case "btns_multisearch":
//					if(srcObj.style.cursor == "hand") {
						var returntitle = '';
						if(ComGetObjValue(formObj.sch_flg) == 'SC')
							returntitle = 'S/C No.';
						else
							returntitle = 'RFA No.';
							
						var param = "?returnval=sc_rfa_no" + "&returntitle=" + returntitle;
		  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
//					}
		  			break;
	  				
				case "btns_customer":
//					if(srcObj.style.cursor == "hand")
						ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
					
				case "btns_ctrt_ofc":
//					if(srcObj.style.cursor == "hand")
						ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
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
		  for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
		  }
		  
		  // IBMultiCombo초기화 
		  for(var k=0;k<comboObjects.length;k++){
			  initCombo(comboObjects[k],k+1);
		  }
		  
		  //html컨트롤 이벤트초기화
		  initControl();
	}
	  
	  
	// 이벤트 처리 함수 선언
  	function initControl() {
  		axon_event.addListenerForm('blur',	'obj_blur',	document.form); //- 포커스 나갈때
  		axon_event.addListenerFormat('focus', 'obj_focus', document.form);
   		axon_event.addListenerFormat('keypress','obj_keypress', document.form);			//- 키보드 입력할때
   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
   		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');	// DEM/DET Office 라디오버튼 클릭시
   		axon_event.addListener('click', 'incl_dc_click', 'incl_dc');	// 'Incl. CNTR Column' CheckBox 클릭시
   		axon_event.addListener('click', 'sch_flg_click', 'sch_flg');
   		axon_event.addListener('change','sttl_lvl_change', 'sttl_lvl');
   		/*==============================================================================================================
   	 		2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
   	 		Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
        	(Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)
   		===============================================================================================================*/    		
   		axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');
  	}
	
//  	function obj_keydown() {
//  		//if(CHK_LOCK_FLG) return;
//  		ComKeyEnter();
//  	}
	
  	var CHK_LOCK_FLG = false;
  	
  	
	//포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
    	var obj = event.srcElement;
        var objName = obj.name;
        
        if(objName == 'fm_dt' || objName == 'to_dt' || objName == 'fm_aply_dt1' || objName == 'to_aply_dt1' || objName == 'cost_yrmon1') {
        	ComChkObjValid(obj);
        	
        } else if(objName == 'cust_cd') {
        	var formObj = document.form;
        	var custCd = ComGetObjValue(obj);
        	var custLen = ComGetLenByByte(custCd);

            if(custLen == 0) {
	            ComSetObjValue(formObj.cust_nm, "");
            	return;
            }

            if(custLen > 2) {
    			//첫 2자리가 영문자이면 CUSTOMER 조회
    			if(ComIsAlphabet(custCd.substring(0,2))) {
    				ComSetObjValue(formObj.s_cust_gubun, "2");
    	            ComSetObjValue(formObj.s_cust_cd, custCd);
    	            
    	            doActionIBCombo(sheetObjects[0], formObj, null, SEARCH20);
    	            
    			//아니면 VENDOR 조회
    			} else {
    				ComShowCodeMessage("DMT00165", "Customer");
    				ComSetObjValue(formObj.s_cust_gubun, "");
    	            ComSetObjValue(formObj.cust_cd, "");
    	            ComSetObjValue(formObj.cust_nm, "");
    	            ComSetFocus(formObj.cust_cd);
    				return;
    			}
    		} else {
    			ComShowCodeMessage("DMT00165", "Customer");
    			ComSetObjValue(formObj.s_cust_gubun, "");
                ComSetObjValue(formObj.cust_cd, "");
                ComSetObjValue(formObj.cust_nm, "");
                ComSetFocus(formObj.cust_cd);
    			return;
    		}
        	
        } else if(objName == 'cvr_cd' || objName == 'por_cd' || objName == 'pol_cd' || objName == 'pod_cd' || objName == 'del_cd') {
        	if(obj.value.length > 0) {
        		
        		CHK_LOCK_FLG = false;

	        	if(obj.value.length != 2 && obj.value.length != 5) {
	        		CHK_LOCK_FLG = true;
	        		
	   	 			ComShowCodeMessage('DMT05015');
	   	 			ComClearObject(obj);
	   	 			ComSetFocus(obj);
	        	} else {
	        		checkLocCntCd(obj);
	        	}
        	}
    	}
	}
	
	
    function checkLocCntCd(srcObj) {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
		var cd = ComTrim(ComGetObjValue(srcObj));
		
		if(cd.length == 2) {
			// Country Code 유효성 체크
			ComSetObjValue(formObj.cnt_cd, cd);
			doActionIBCombo(sheetObj, formObj, null, COMMAND11, srcObj);
		} else {
			// Location Code 유효성 체크
			ComSetObjValue(formObj.loc_cd, cd);
			doActionIBCombo(sheetObj, formObj, null, COMMAND07, srcObj);
		}
    }
    
	
  	function sttl_lvl_change() {
  		var sheetObj = sheetObjects[0];
  		sheet1_OnSearchEnd(sheetObj, '');
  	}
	
	
	// S/C No, RFA No, Contract Office, Customer Code 검색조건 선택시(라디오 버튼 체크) 이벤트 전달
//  	function sch_flg_click() {
//  		doEnableCondObj(event.srcElement.value);
//  	}
	
  	// S/C No, RFA No, Contract Office, Customer Code 검색조건 선택시(라디오 버튼 체크) 이벤트 처리
  	function doEnableCondObj(condType) {
  		var formObj = document.form;
   	 
  		with (formObj) {
  			incl_dc.checked = true;
			//ComEnableObject(incl_dc, true);
  			
  			switch(condType) {
  				case "SC":
  				case "RFA":
  					ComEnableManyObjects(true, sc_rfa_no, btns_multisearch);
  					ComEnableManyObjects(false, ctrt_ofc, btns_ctrt_ofc, cust_cd, btns_customer);	
  					
  					ComClearManyObjects(sc_rfa_no, ctrt_ofc, cust_cd, cust_nm);
  					
  			    	comboObjects[1].Enable = false; 
  			    	comboObjects[1].Index="-1";
  					
  					DmtComSetClassManyObjects('input1', sc_rfa_no); 			//필수항목 표시
	    	 		//DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no);
  					
  					ComSetFocus(sc_rfa_no);
  					
//  					if(condType == 'SC') {
//  						incl_dc.checked = false;
//  						//ComEnableObject(incl_dc, false);
//  					}
  					break;			
  							
  				case "CTRT":
  					ComEnableManyObjects(true, ctrt_ofc, btns_ctrt_ofc);
  					ComEnableManyObjects(false, sc_rfa_no, btns_multisearch, cust_cd, btns_customer);	
  					
  					ComClearManyObjects(sc_rfa_no, cust_cd, cust_nm);
  					
  			    	comboObjects[1].Enable = false; 
  			    	comboObjects[1].Index="-1";
  					
  					DmtComSetClassManyObjects('input1', ctrt_ofc); 			//필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', sc_rfa_no, cust_cd);
  					
  					ComSetObjValue(ctrt_ofc, ComGetObjValue(usr_ofc_cd));
  					ComSetFocus(ctrt_ofc);
  					break;
  					
  				case "CUST":
  					ComEnableManyObjects(true, cust_cd, btns_customer);
  					ComEnableManyObjects(false, sc_rfa_no, btns_multisearch, ctrt_ofc, btns_ctrt_ofc);		
  					
  					ComClearManyObjects(sc_rfa_no, ctrt_ofc, cust_cd, cust_nm);
  					
  			    	comboObjects[1].Enable = true; 
  			    	comboObjects[1].Index="0";

  					DmtComSetClassManyObjects('input1', cust_cd); 			//필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', sc_rfa_no, ctrt_ofc);
  					
  					ComSetFocus(cust_cd);
  					break;
  				
  				case "date" :
		    		 ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar, fm_aply_dt1, to_aply_dt1, btns_calendar1);
		    		 DmtComSetClassManyObjects('input1', fm_dt, to_dt, fm_aply_dt1, to_aply_dt1);
		    		 
		    		 //Period Date 초기화
		    		 //사용자 Office 의 현재 날짜를 조회한다.
		    		 var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
		    		 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -15);
		    		 var toMvmtDt = ofcCurrDate;
		    		 var revMon =  ComReplaceStr(toMvmtDt, '-', '')
		    	
		    		 ComSetObjValue(fm_dt, fmMvmtDt);
		    		 ComSetObjValue(to_dt, toMvmtDt);
		    		 
		    		 ComSetObjValue(fm_aply_dt1, fmMvmtDt);
		    		 ComSetObjValue(to_aply_dt1, toMvmtDt);
		    		 
		    		 ComSetObjValue(cost_yrmon1, revMon.substring(0,4) + "-" + revMon.substring(4, 6) )
		    		 
  					break;
  			} // switch - end
  		} // with end
  		
  		incl_dc_click();
  	}
	      
	   
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		ComResetAll();
		
		//조회조건 부분적으로 활성화/비활성화  처리
//  		doEnableCondObj("date");
  		
		// To MVMT Date 검색기간 초기화

  		doActionIBCombo(sheetObj, formObj, "", SEARCHLIST11);
		
        //=========================================================================================
        // 변경일자 : 2017.10.16 
        // 변경내용 : Period 를 12개월로 변경함.
        // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
        //==========================================================================================
		var fmDt = ComGetDateAdd(initOfcCurrDate, "M", -1 * REPORT_INQUIRY_PERIOD);
		var toDt = initOfcCurrDate;
		ComSetObjValue(formObj.fm_dt, fmDt);
		ComSetObjValue(formObj.to_dt, toDt);
		
		// DEM/DET Office 검색 조건 초기화 (Default: RHQ)
		ofc_flg_click();
		
		// 'Incl. CNTR Column' CheckBox 체크시 로직 실행
		incl_dc_click();
		
		// Contract Office Default값을  로그인 Office 로  설정한다.
		//ComSetObjValue(formObj.ctrt_ofc, ComGetObjValue(formObj.usr_ofc_cd));
//		doEnableCondObj('SC');

		ComEnableManyObjects(true, formObj.sc_rfa_no, formObj.btns_multisearch);
		ComEnableManyObjects(true, formObj.ctrt_ofc, formObj.btns_ctrt_ofc, formObj.cust_cd, formObj.btns_customer);

    	comboObjects[1].Enable = true; 
    	comboObjects[1].Index="0";

		DmtComSetClassManyObjects('input1', formObj.sc_rfa_no); 			//필수항목 표시
		DmtComSetClassManyObjects('input1', formObj.ctrt_ofc); 			//필수항목 표시
		DmtComSetClassManyObjects('input1', formObj.cust_cd); 			//필수항목 표시
		
		DmtComEnableManyBtns(false, "btn_Detail", "btn_DownExcel");
	}
	

	// 'Incl. D/C Column' CheckBox 체크시 발생이벤트 처리
	function incl_dc_click() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var indcCntr = ComGetObjValue(formObj.incl_dc);
		
		var hiddenFlg = true;
		if (indcCntr == 'Y')	// CNTR Col 보여줌
			hiddenFlg = false;

		sheetObj.ColHidden("dc_amt") = hiddenFlg;
		
		/*==============================================================================================================
		 2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
		 Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
	     (Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)
		===============================================================================================================*/
		if (!hiddenFlg) {	// 보여줘야될 경우
			var inclCntr = ComGetObjValue(formObj.incl_cntr);
			hiddenFlg = (inclCntr == 'Y') ? false : true;
		}
		
		sheetObj.ColHidden("dc_cntr") = hiddenFlg; 
	}
	  
    
	// DEM/DET Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[2];
		
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST01);
			ComEnableObject(formObj.chk_sub_ofc, true);
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
		    	// 영대문자만
         		ComKeyOnlyAlphabet('upper');
		        break;
		        
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
		        
    	 	case "engnum2":
		    	// 영대문자+숫자 + ',' 
		    	DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
		        
         	/*case "int":
    	        //숫자만
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;*/
    	        
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }

	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[2];
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObj.Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
			
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}
	 
	 
	// Office IBMultiCombo 초기화
	function initComboValue_tariff_type() {
		ComSetObjValue(comboObjects[0], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
	}
	
	
	// Tariff Type IBMultiCombo 클릭 이벤트 처리
	function tariff_type_OnCheckClick(comboObj, index, code) {
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


	// 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
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
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(srcName) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		/*
		if(sheetObj.CheckedRows("chk") == 0) {
 			ComShowCodeMessage('COM12114', 'Charge');
 			return;
 		}*/
  		
  		sUrl	= 'EES_DMT_6006.do';
  		sWidth	= '1000';
  		sHeight	= '590';
  		
  		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
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
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
    	document.form.cust_nm.value = aryPopupData[0][4];
    }
  	
    
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCtrtOfcCd(aryPopupData) {
    	document.form.ctrt_ofc.value = aryPopupData[0][3];
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
                     style.height = 370;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);
                     
                     var HeadTitle1 = " |Seq.|S/C No.|RFA No.|Customer|Customer|CTRT\nOFC|Tariff|DMT\nOFC|CVR|POR|POL|POD|DEL|Incurred%|Exception%|Over\nCNTR|AVG\nOver|TTL\nCNTR|AVG\nSTY|Basic F/T|Extended F/T|AVG Used F/T|Cur.|Incurred|Incurred|CMDT EXPT|CMDT EXPT|Exception|Exception|Discount|Discount|Billable|Billable|Invoiced|Invoiced|A/R I/F|A/R I/F|Collected(in ERP)|Collected(in ERP)|US Rail Storage|US Rail Storage";
                     var HeadTitle2 = " |Seq.|S/C No.|RFA No.|Code|Name|CTRT\nOFC|Tariff|DMT\nOFC|CVR|POR|POL|POD|DEL|Incurred%|Exception%|Over\nCNTR|AVG\nOver|TTL\nCNTR|AVG\nSTY|Basic F/T|Extended F/T|AVG Used F/T|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT"; 
                     //var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(45, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,		daCenter,   false,	"ibflag");
                     //InitDataProperty(0, cnt++ , dtRadioCheck,	35,		daCenter,	true,	"chk",			false,	"",		dfNone,			0,	true,	true);
                     InitDataProperty(0, cnt++ , dtSeq,    		50,    	daCenter,   true,   "seq",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,	true,	"sc_no",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		90,		daCenter,	true,	"rfa_no",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,	true,	"cust_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		100,	daLeft,		true,	"cust_nm",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,	true,	"ctrt_ofc",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"trf_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,	true,	"dmdt_ofc",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"cvr_cd",		false,	"",		dfNone,			0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"por_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"pol_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"pod_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"del_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"incur_rto",	false,	"Round(|incur_cntr|/|ttl_cntr|,4)*100",	dfNullFloat, 2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"expt_rto",		false,	"Round(|expt_cntr|/|ttl_cntr|,4)*100",	dfNullFloat,	2,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"over_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"avg_over",		false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	true,	"ttl_cntr",		false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	true,	"avg_sty",		false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"bz_ft_dys",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	85,		daRight,	true,	"ex_ft_dys",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	85,		daRight,	true,	"used_ft",		false,	"",		dfNullInteger,	0,	false,	true);
//                     InitDataProperty(0, cnt++ , dtAutoSum,   	85,		daRight,	true,	"styg_dys",		false,	"",		dfNullInteger,	0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		50,		daCenter,	true,	"curr_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"incur_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	true,	"incur_amt",	false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"cmdt_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"cmdt_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"expt_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"expt_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"dc_cntr",		false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"dc_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"bill_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"bill_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"inv_cntr",		false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"inv_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"ar_if_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"ar_if_amt",	false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"coll_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"coll_amt",		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	60,		daRight,	true,	"us_rail_cntr",	false,	"",		dfNullInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	80,		daRight,	true,	"us_rail_amt",	false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,		30,		daCenter,	true,	"ttl_sty",		false,  "",		dfNone,			0,	false,  true);
                     InitDataProperty(0, cnt++ , dtAutoSum,		30,		daCenter,	true,	"ttl_over",		false,  "",		dfNone,			0,	false,  true);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sc_rfa_no",	false,  "",		dfNone,			0,	false,  true);
                     
                     // 좌측 틀고정 컬럼 설정
                     FrozenCols = SaveNameCol("cust_cd");

                     CountPosition = 2;
                     ToolTipOption="balloon:true;width:400;";
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
  		var formObj = document.form;
  		
  	    switch(comboObj.id) {  
  	    	case "office":
  	    		with (comboObj) { 
  					//MultiSelect = false;
  	    			UseAutoComplete = true;
  					SetColAlign("left");
  					DropHeight = 160;
  					//ColBackColor(0) = "#CCFFFD";
  					
  					//ValidChar(2);	// 영어대문자 사용
  					//MaxLength = 6;
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

            case "cust_type": // CUSTOMER TYPE
                with (comboObj) { 
                    MultiSelect = true; 
//                    UseAutoComplete = true; 
                    SetColAlign("left|left");   
                    SetColWidth("60|300");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "All"  , "A" );
                comboObj.InsertItem( 1 , "SHPR" , "S" );
                comboObj.InsertItem( 2 , "CNEE" , "C" );
                comboObj.InsertItem( 3 , "NTFY" , "N" );
                comboObj.Code2 = "A,S,C,N";
            break;
  	    }
  	}
      
      
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
			
				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH;
	       		sheetObj.DoSearch("EES_DMT_6005GS.do", FormQueryString(formObj));
	       		ComOpenWait(false);
				break;
         }
	}


	// IBCombo 데이터 조회 및 세팅
 	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
     	 sheetObj.ShowDebugMsg = false;
     	 sheetObj.WaitImageVisible = false;

     	 formObj.f_cmd.value = formCmd;
     	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
     	 
     	 switch(formCmd) {
	     	case SEARCHLIST:	// tariff type
 				var data = ComGetEtcData(sXml, "common_tariff_cd");
 				if (data != undefined && data != '') {
 					var comboItems = data.split("|");
 					comboObj.InsertItem(0, "All|All", "All");
 					
 			  		for (var i = 0 ; i < comboItems.length ; i++) {
 			  	   		var comboItem = comboItems[i].split("=");
 			  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
 			  	   	}
 				}
				break;
	     	case SEARCHLIST11:	// From ~ To Date 설정
	    		
	     		initOfcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
	     		
	    		break;
     	 	case COMMAND06:	// RHQ
     	 		with (comboObj) { 
 	    	 		RemoveAll();
 					MultiSelect = false;
 					SetColWidth("45");
 					ValidChar(2);	// 영대문자만 사용
 					//MaxLength = 6;
     	 		}
     	 		
     	 		var data = ComGetEtcData(sXml, "common_cd");
 				if (data != undefined && data != '') {
 					var comboItems = data.split("|");
 					comboObj.InsertItem(0, "All", "All");
 					
 					for (var i = 0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
 		         	}
 				}
 				break;
     	 
     	 	case SEARCHLIST01: // Office
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
 	    	    
     	 	case COMMAND01:	// Incl. Sub Office
	     	 	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	     	 	if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
     	 		break;
     	 		
     		case COMMAND07:	// Location Code Check
	 	 		var locCd = ComGetEtcData(sXml, "LOC_CD");
	 	 		if(locCd == '') {
	 	 			ComShowCodeMessage('DMT00110', "Location");
	 	 			ComClearObject(srcObj);
	 	 			CHK_LOCK_FLG = true;
	 	 			//ComSetFocus(srcObj);
	 	 		}
	 	 		break;
	 	 		
     		case COMMAND11:	// Country Code Check
	 	 		var cntCd = ComGetEtcData(sXml, "CNT_CD");
	 	 		if(cntCd == '') {
	 	 			ComShowCodeMessage('DMT00110', "Country");
	 	 			ComClearObject(srcObj);
	 	 			CHK_LOCK_FLG = true;
	 	 			//ComSetFocus(srcObj);
	 	 		}
	 	 		break;
	 	 		
     		case SEARCH20: // Customer Name 조회	
	     		var custCd = ComGetEtcData(sXml, "PAYER_CODE");
	            var custNm = ComGetEtcData(sXml, "PAYER_NM");
	            
	            if(custNm == null || custNm == "" || custNm == undefined) {
	            	ComSetObjValue(form.s_cust_gubun, "");
	                ComSetObjValue(form.cust_cd, "");
	                ComSetObjValue(form.cust_nm, "");
	                
	            	ComShowCodeMessage("DMT00165", "Customer");
	                ComSetFocus(formObj.cust_cd);
	            } else {
	            	ComSetObjValue(form.cust_cd, custCd);
	                ComSetObjValue(form.cust_nm, custNm);
	            }
     			break;
     	 }
     	 
     	sheetObj.WaitImageVisible = true;
 	}
 	

	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
	function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
        	 	case IBSEARCH:
        	 		
        	 		
        	 		var optDate = ComGetObjValue(opt_date);
         			
         			if (optDate == "MVMT_DT") {
	        	 		if(!ComIsDate(fm_dt)) {
	         				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date From Date'));
	         				return false;
	         			}
	         			if(!ComIsDate(to_dt)) {
	         				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'To MVMT Date To Date'));
	         				return false;
	         			}
	         			
	  					var fmDt = ComGetObjValue(fm_dt);
	         			var toDt = ComGetObjValue(to_dt);
	 					
	         			/*
	         			ComChkPeriod(fromDate, toDate)
	         			0 : fromDate > toDate
	         			1 : fromDate < toDate
	         			2 : fromDate = toDate
	         			*/
	         			// 기간체크
	                    if (ComChkPeriod(fmDt, toDt) == 0) {
	                    	ComShowCodeMessage("DMT01020");
	                    	return false;
	                    }
	                    
	                      //=========================================================================================
	                     // 변경일자 : 2017.10.16 
	                     // 변경내용 : Period 를 12개월로 변경함.
	                     // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
	                     //==========================================================================================	                    
	                    var limitDt = ComGetDateAdd(fmDt, "M", REPORT_INQUIRY_PERIOD);
	                    if (ComChkPeriod(toDt, limitDt) == 0) {
	                    	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
	                    	return false;
	                    }
	                    
	                    // 'To MVMT Date' 검색조건값을 hidden변수에 최종적으로 세팅한다.
	                    ComSetObjValue(start_dt, ComGetUnMaskedValue(fm_dt, "ymd"));
	                    ComSetObjValue(end_dt, ComGetUnMaskedValue(to_dt, "ymd"));
	                    
		         	} else if (optDate == "APP_DT") {
		      			if(!ComIsDate(fm_aply_dt1)) {
		      				ComAlertFocus(fm_aply_dt1, ComGetMsg('COM12134', 'Period From Date'));
		      				return false;
		      			}
		      			if(!ComIsDate(to_aply_dt1)) {
		      				ComAlertFocus(to_aply_dt1, ComGetMsg('COM12134', 'Period To Date'));
		      				return false;
		      			}
		      			
		      			var startDt = ComGetUnMaskedValue(fm_aply_dt1, 'ymd');
		      			var endDt = ComGetUnMaskedValue(to_aply_dt1, 'ymd');
		      			
		      			// 기간체크
		                 if (ComChkPeriod(startDt, endDt) == 0) {
		                 	ComShowCodeMessage("DMT01020");
		                 	return false;
		                 }
		                 
	                      //=========================================================================================
	                     // 변경일자 : 2017.10.16 
	                     // 변경내용 : Period 를 12개월로 변경함.
	                     // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
	                     //==========================================================================================		                 
		                 var limitDt = ComGetDateAdd(startDt, "M", REPORT_INQUIRY_PERIOD);
		                 if (ComChkPeriod(endDt, limitDt) == 0) {
		                 	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
		                 	return false;
		                 }
		                 
		                 ComSetObjValue(fm_aply_dt, startDt);
		                 ComSetObjValue(to_aply_dt, endDt);
		                 
		      		} else if (optDate == "REV_MON") {
		      			if(ComIsEmpty(cost_yrmon1)) {
		      				ComAlertFocus(cost_yrmon1, ComGetMsg('DMT05014', "R.Month"));
		         			return false;
		                }
		      			
		      			ComSetObjValue(cost_yrmon, ComGetUnMaskedValue(cost_yrmon1, 'ym'));
		      		}
         			
                    // Tariff Type
	                var trfCd = comboObjects[0].Code;
	                if(ComIsEmpty(trfCd)) {
	                	ComShowCodeMessage('COM12113', "Tariff Type");
	         			return false;
	                }
	                
	                // 전체선택이면, 'All'값을 제거해서 보냄.(DBDAO 내부로직 필요상)
	                if(trfCd.indexOf('All') != -1)
	                	trfCd = ComReplaceStr(trfCd, "All,", "");
	                	
	                ComSetObjValue(dmdt_trf_cd, trfCd);
	                
	                
	                // ******** Code 조회 Option 입력 체크  ******* START
	                //  S/C No., RFA No., Contract Office, Customer 
	                var schFlg = ComGetObjValue(sch_flg);	
	                
	                var scRfaNo = ComGetObjValue(sc_rfa_no);
	                var ctrtOfc = ComGetObjValue(ctrt_ofc);
	                var custCd = ComGetObjValue(cust_cd);
	                if(ComIsEmpty(scRfaNo)&&ComIsEmpty(ctrtOfc)&&ComIsEmpty(custCd)) {
	                	var fldNm = (schFlg == 'SC') ? 'S/C No' : 'RFA No';
	                	
	                	ComAlertFocus(sc_rfa_no, ComGetMsg('DMT05014', fldNm+', Contract Office, Customer Code'));
	         			return false;
	                }
	                
	                // S/C No. or RFA No.
//	                if(schFlg == 'SC' || schFlg == 'RFA') {
//	                	var scRfaNo = ComGetObjValue(sc_rfa_no);
//		                if(ComIsEmpty(scRfaNo)) {
//		                	var fldNm = (schFlg == 'SC') ? 'S/C No' : 'RFA No';
//		                	
//		                	ComAlertFocus(sc_rfa_no, ComGetMsg('DMT05014', fldNm));
//		         			return false;
//		                }
//	                }
	                
	                // Contract Office
//	                if(schFlg == 'CTRT') {
//	                	var ctrtOfc = ComGetObjValue(ctrt_ofc);
//		                if(ComIsEmpty(ctrtOfc)) {
//		                	ComAlertFocus(ctrt_ofc, ComGetMsg('DMT05014', 'Contract Office'));
//		         			return false;
//		                }
//	                }
	                
	                // Customer Code
//	                if(schFlg == 'CUST') {
//	                	var custCd = ComGetObjValue(cust_cd);
//		                if(ComIsEmpty(custCd)) {
//		                	ComAlertFocus(cust_cd, ComGetMsg('DMT05014', 'Customer Code'));
//		         			return false;
//		                }
//	                }
	                // ********* Code 입력 체크  *********** END
	                
  				
	                // DEM/DET Office
	                var ofcCd = comboObjects[2].Code;
	                if(ComIsEmpty(ofcCd)) {
	                	ComShowCodeMessage('DMT05014', "DEM/DET Office");
	         			return false;
	                }
	                
	                ComSetObjValue(ofc_cd, ofcCd);
	                
	                // Coverage Location 입력 체크
	                if(!ComIsEmpty(cvr_cd)) {
	                	var len = ComGetLenByByte(cvr_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(cvr_cd);
	                		return false;
	                	}
	                }
	                
	                // ***** BKG Location 입력 체크
	                if(!ComIsEmpty(por_cd)) {
	                	var len = ComGetLenByByte(por_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(por_cd);
	                		return false;
	                	}
	                }
	                
	                if(!ComIsEmpty(pol_cd)) {
	                	var len = ComGetLenByByte(pol_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(pol_cd);
	                		return false;
	                	}
	                }
	                
	                if(!ComIsEmpty(pod_cd)) {
	                	var len = ComGetLenByByte(pod_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(pod_cd);
	                		return false;
	                	}
	                }
	                
	                if(!ComIsEmpty(del_cd)) {
	                	var len = ComGetLenByByte(del_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(del_cd);
	                		return false;
	                	}
	                }
	                //************************************
	                
        	 		break;
        	 		
        	 } // switch - end
         } // with - end

         return true;
	}
	
	
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		//sheetObj.WaitImageVisible = false;
  			
  		sheetObj.ColHidden("ttl_sty")	= true;
  		sheetObj.ColHidden("ttl_over")	= true;
        
  		// Tariff Type MultiCombo List조회
		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
		
  		//OPEN 화면 호출
        doInit();

		cust_click();
        //sheetObj.WaitImageVisible = true; 
	}

	  
	//말풍선
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	 
    	with(sheetObj)
    	{
    		//마우스 위치를 행과 컬럼과 값 가져오기
    		var Row = MouseRow;
    		var mttText = '';
    		//ComDebug(Row);
    		
    		if(Row == 0 || Row == 1) {
    			var colSaveNm = ColSaveName(MouseCol);
    			
    			switch(colSaveNm) {
    				case "cvr_cd":
									mttText = 'Coverage';
									break;
    				case "ttl_cntr":
									mttText = 'Total General Charge with Status F, C, I, N';
									break;
    				case "avg_sty":
									mttText = 'Average Statying Days of Total CNTR';
									break;
    				case 'over_cntr':
									mttText = 'Total General Charge over F/T with Status F,C,I';
									break;
    				case 'avg_over':
									mttText = 'Average Over Days of Total CNTR over F/T';
									break;
    				case "incur_cntr":
    				case "incur_amt":
									mttText = 'DEM/DET Incurrence per Basic Tariff';
									break;		
    				case "cmdt_cntr":
    				case "cmdt_amt":
									mttText = 'Exception per Commodity Exception Tariff';
									break;				
    				case "expt_cntr":
    				case "expt_amt":
									mttText = 'Exception per S/C Exception Tariff/Before Booking';
									break;
    				case "dc_cntr":
    				case "dc_amt":
									mttText = 'Discount per After Booking';
									break;				
    				case "bill_cntr":
    				case "bill_amt":
									mttText = 'Billable AMT = Incurred - CMDT EXPT - Exception - Discount AMT';
									break;
    			}
    		} else
    			mttText = '';
    		
    		MouseToolTipText = mttText;
    	}
	}
    

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.SearchRows == 0) {
			DmtComEnableManyBtns(false, "btn_Detail", "btn_DownExcel");
			return;
		}
		
		DmtComEnableManyBtns(true, "btn_Detail", "btn_DownExcel");
		
		var formObj = document.form;
		var schFlg = ComGetObjValue(formObj.sch_flg);
		var sttlLvl = ComGetObjValue(formObj.sttl_lvl);

		// 1단계 소계를 계산할 기준 컬럼명
		var stdCol;
		
		with(sheetObj) {
			ColumnSort("seq", "ASC");
			
//			if(schFlg == 'SC') {
//				stdCol = "sc_no";
//				ColHidden("sc_no") = false;
//				ColHidden("rfa_no") = true;
//			} else if(schFlg == 'RFA') {
//				stdCol = "rfa_no";
//				ColHidden("sc_no") = true;
//				ColHidden("rfa_no") = false;
//			} else {
//				stdCol = "sc_rfa_no";
//				ColHidden("sc_no") = false;
//				ColHidden("rfa_no") = false;
//			}
			
			HideSubSum(stdCol);
			HideSubSum("trf_cd");
			HideSubSum("dmdt_ofc");
			HideSubSum("cvr_cd");
			
			sttlLvl = ComParseInt(sttlLvl);
        
			// 1단계 소계 기준컬럼  -  S/C No. or RFA No. 
   			ShowSubSum(stdCol, "ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|bz_ft_dys|ex_ft_dys|used_ft|styg_dys|curr_cd|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|ar_if_cntr|ar_if_amt|coll_cntr|coll_amt", -1, false, false, -1
   						, "chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=;cust_nm=;ctrt_ofc=;trf_cd=;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"
   						+ "avg_sty=Round(|ttl_sty|/|ttl_cntr|, 0);avg_over=Round(|ttl_over|/|over_cntr|, 0);"
   						+ "incur_rto=Round(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=Round(|expt_cntr|/|ttl_cntr|,4)*100");
   			
   			// 2단계 소계 기준컬럼  - trf_cd
   			if(sttlLvl >= 2) {
	   			ShowSubSum("trf_cd", "ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|bz_ft_dys|ex_ft_dys|used_ft|styg_dys|curr_cd|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|ar_if_cntr|ar_if_amt|coll_cntr|coll_amt", -1, false, false, -1
							, "chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"
							+ "avg_sty=Round(|ttl_sty|/|ttl_cntr|, 0);avg_over=Round(|ttl_over|/|over_cntr|, 0);"
	   						+ "incur_rto=Round(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=Round(|expt_cntr|/|ttl_cntr|,4)*100");
   			}
   			
   			// 3단계 소계 기준컬럼  - dmdt_ofc
   			if(sttlLvl >= 3) {
	   			ShowSubSum("dmdt_ofc", "ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|bz_ft_dys|ex_ft_dys|used_ft|styg_dys|curr_cd|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|ar_if_cntr|ar_if_amt|coll_cntr|coll_amt", -1, false, false, -1
							, "chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=%s;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"
							+ "avg_sty=Round(|ttl_sty|/|ttl_cntr|, 0);avg_over=Round(|ttl_over|/|over_cntr|, 0);"
	   						+ "incur_rto=Round(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=Round(|expt_cntr|/|ttl_cntr|,4)*100");
   			}
   			
   			// 4단계 소계 기준컬럼  - cvr_cd
   			if(sttlLvl == 4) {
	   			ShowSubSum("cvr_cd", "ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|bz_ft_dys|ex_ft_dys|used_ft|styg_dys|curr_cd|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|ar_if_cntr|ar_if_amt|coll_cntr|coll_amt", -1, false, false, -1
							, "chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=%s;cvr_cd=%s;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"
							+ "avg_sty=Round(|ttl_sty|/|ttl_cntr|, 0);avg_over=Round(|ttl_over|/|over_cntr|, 0);"
	   						+ "incur_rto=Round(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=Round(|expt_cntr|/|ttl_cntr|,4)*100");
   			}
   			
   			//var row = LastRow;
    		SumText(0, "seq") = "TTL";
    		
    		
    		var avgStySum	= '0';
    		var avgOverSum	= '0';
    		var totIncurRto = '0';
    		var totExptRto	= '0';
    		
    		if(SumValue(0, "ttl_cntr") != '0') {
    			avgStySum = ComRound(SumValue(0, "ttl_sty") / SumValue(0, "ttl_cntr"), 0);
    			totIncurRto = ComRound(SumValue(0, "incur_cntr") / SumValue(0, "ttl_cntr"), 4)*100;
    			totExptRto = ComRound(SumValue(0, "expt_cntr") / SumValue(0, "ttl_cntr"), 4)*100;
    		}
    		
    		if(SumValue(0, "over_cntr") != '0')
    			avgOverSum = ComRound(SumValue(0, "ttl_over") / SumValue(0, "over_cntr"), 0);
    		    		
    		SumValue(0, "avg_sty")	= avgStySum;
    		SumValue(0, "avg_over")	= avgOverSum;
    		SumValue(0, "incur_rto")= totIncurRto;
    		SumValue(0, "expt_rto")	= totExptRto;
   		
		} // with - end
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
    
    //멀티콤보 클릭 이벤트
    function cust_type_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }    
    
    function cust_click(){
    	//doEnableCondObj(event.srcElement.value);
    	var formObj = document.form;
   		if (formObj.cust_flg[0].checked ) {
    		comboObjects[1].Enable = false; 
        	comboObjects[1].Index="-1";

    	}else if (formObj.cust_flg[1].checked ) {
   			comboObjects[1].Enable = true; 
   	    	comboObjects[1].Index="0";
    	}
    	
    }
    
	/*==============================================================================================================
	 2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
	 Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
     (Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)
	===============================================================================================================*/    
	function incl_cntr_click() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var inclCntr = ComGetObjValue(formObj.incl_cntr);
		
		var hiddenFlg = true;
		if(inclCntr == 'Y')	// CNTR Col 보여줌
			hiddenFlg = false;
			
		with(sheetObj) {
			ColHidden("incur_cntr")	  = hiddenFlg; 
			ColHidden("cmdt_cntr")	  = hiddenFlg; 
			ColHidden("expt_cntr")	  = hiddenFlg;
			ColHidden("dc_cntr")      = hiddenFlg;
			ColHidden("bill_cntr")	  = hiddenFlg; 
			ColHidden("inv_cntr")	  = hiddenFlg; 
			ColHidden("ar_if_cntr")	  = hiddenFlg; 
			ColHidden("coll_cntr")	  = hiddenFlg; 
			ColHidden("us_rail_cntr") = hiddenFlg;
		}
	}    
	/* 개발자 작업  끝 */