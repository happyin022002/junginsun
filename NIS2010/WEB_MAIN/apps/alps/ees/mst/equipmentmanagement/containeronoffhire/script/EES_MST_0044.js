/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0044.js
*@FileTitle : Container Master Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.23 이호선
* 1.0 Creation
* =========================================================
* 2010.07.14 남궁진호 CNTR TYPE SIZE 수정 할수 없도록 변경 유저요청
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
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
     * @class ees_mst_0044 : ees_mst_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0044() {
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
 var head_cntr_tpsz_cd ="";
 var tot_cntr_tpsz_cd ="";
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var IBSEARCH01  = 29; 
 var SEARCH_ENABLE = true; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var formObj = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					break;
					
					case "btn_new":
						initDisplay(); 
						formObj.cntr_no.value  = "";
						formObj.rf_tp_cd.text  = "";
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
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
    * IBMultiCombo Object를 배열로 등록
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
         //페이지 로드시 선처리 기능을 호출한다.
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        }
         
 		// IBMultiCombo초기화 
 	    for(var k=0;k<comboObjects.length;k++){  	    	
 	        initCombo(comboObjects[k],k+1);
 	    } 
    	document.getElementById("vndr_abbr_nm").BackColor = "#CCFFFD"; 
//    	document.getElementById("cntr_tpsz_cd").BackColor = "#CCFFFD";
    	
     	initControl();    
     	
//       	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);   
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
     	doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
     }
      
  	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObject = document.form;   
		switch(comboObj.id) {
		
		    case "cntr_tpsz_cd":
			   with (comboObj) { 
				   SetColAlign("center");
				   DropHeight = 160;   
	  	           MultiSelect = false;
	   	           MaxSelect = 1;
	   	           BackColor == "#CCFFFD"
	    		   Style = 0;				    
  				   ValidChar(2,1);
   				   UseAutoComplete = true;
		    }				   
			break;		
		
			case "vndr_abbr_nm": 
			   with (comboObj) { 
				   SetColAlign("center|left");        
				   SetColWidth("70|200");         
				   DropHeight = 160;   
	  	           MultiSelect = false;
	   	           MaxSelect = 1;
	   	           BackColor == "#CCFFFD"
		    	   Style = 0;				    
  	               ValidChar(2,1);
   				   UseAutoComplete = true;
			}				   
			break;
			
			case "rf_tp_cd": 
			   with (comboObj) { 
				   SetColAlign("left");        
				   SetColWidth("170");         
				   DropHeight = 160;   
	  	           MultiSelect = false;
	   	           MaxSelect = 1;
	   	           BackColor == "#CCFFFD"
	    		   Style = 0;				    
  				   ValidChar(2,1);
   				   UseAutoComplete = true;
			   }   
			   break;
		 } 
  	}     

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		
	    axon_event.addListenerFormat('blur',    'obj_blur',     form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('beforeactivate',   'obj_focus',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
		axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때  
 		axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때.		
		
		formObj.cntr_no.focus();
		ComBtnDisable("btn_save");
  		if (formObj.cntr_no.value.length > 0)
  		    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  	}       
      
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var obj = event.srcElement;
        if(event.srcElement.name == "mft_dt"){		
        	ComChkObjValid(obj);
        }
	}
	
	function obj_focus(){
		var obj = event.srcElement;
        if(event.srcElement.name == "mft_dt"){		
        	ComClearSeparator(obj);
        }
	}
	
  	/**
 	* Key-Down Event 처리
 	*/
	function obj_keydown() {
		var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		var formObj  = document.form;

  		switch (obj.name) {
			case "cntr_no":
				if ( vKeyCode == 9 || vKeyCode == 13 ) {
		  			SEARCH_ENABLE = false;
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  			SEARCH_ENABLE = true;
		  			ComSetFocus(formObj.cntr_no);  			
		  		}
  		   break;
	   }			
	}
	
  	function obj_keyup() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

  		switch(obj.name) {
			case "cntr_no":
				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
					ComKeyEnter('LengthNextFocus');
				}
			break;
	   }
 	}  	 
  	 
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
	        break;
	            
	        case "ymd":
	        	if(obj.name=="mft_dt") ComKeyOnlyNumber('int', "-");
	        break;
	        case "int":
	        	if(obj.name=="chk_dgt") ComKeyOnlyNumber('int');
	        break;
	    }        
	}
 	
	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.chk_dgt.value ="";
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase(); // Copy&paste 소문자를 대문자로 변경
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
		    }
		}	
	}	 	
 	
    /**
	 * cntr_tpsz_cd_OnBlur
	 */
	function cntr_tpsz_cd_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
	}

    /**
	 * vndr_abbr_nm_OnBlur
	 */
	function vndr_abbr_nm_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.vndr_abbr_nm_h.value = ComGetObjValue(comboObj);
	}
	 
	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function cntr_tpsz_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;

		with(comboObj) {
			if(KeyCode == 13) {
				formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
			}
		}
	}
	 
	function vndr_abbr_nm_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;

		with(comboObj) {
			if(KeyCode == 13) {
				formObj.vndr_abbr_nm_h.value = ComGetObjValue(comboObj);
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
             case 1:      //sheet1 init
                 with (sheetObj) {
                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                }
             break;
         }
     }    
      
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //조회
		        initDisplay();
            	formObj.f_cmd.value = SEARCH;
            	if (formObj.cntr_no.value.trim().length == 0) {
            		ComShowCodeMessage("MST00001", "Cntr No.");
            		formObj.cntr_no.focus();
            		return;
            	}
            	sheetObj.WaitImageVisible=false;            	
            	ComOpenWait(true);	
            	var sXml = sheetObj.GetSearchXml("EES_MST_0044GS.do", FormQueryString(formObj)+"&gubun=1");
            	var chk = sXml.indexOf("ERROR");
            	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
            		sheetObj.LoadSearchXml(sXml);
            		ComOpenWait(false);
            		return;
            	}            	
            	ComOpenWait(false);
                // 입력 박스 데이타 채우기 	  
            	formObj.chk_dgt.value          = ComXmlString(sXml, "chk_dgt");
            	formObj.aciac_div_cd.value     = ComXmlString(sXml, "aciac_div_cd");
            	formObj.cntr_tpsz_cd.value     = ComXmlString(sXml, "cntr_tpsz_cd");
            	formObj.sub_lstm_cd.value      = ComXmlString(sXml, "sub_lstm_cd");
            	formObj.lstm_cd.value          = ComXmlString(sXml, "lstm_cd");
            	formObj.cntr_tpsz_iso_cd.value = ComXmlString(sXml, "cntr_tpsz_iso_cd");
            	formObj.cntr_mtrl_cd.value		= ComXmlString(sXml, "cntr_mtrl_cd");  
            	if (ComXmlString(sXml, "tare_wgt").toString() != "")
            	   formObj.tare_wgt.value          = ComAddComma(ComXmlString(sXml, "tare_wgt").toString());
            	if (ComXmlString(sXml, "tare_wgt_lbs").toString() != "")
            	   formObj.tare_wgt_lbs.value      = ComAddComma(ComXmlString(sXml, "tare_wgt_lbs").toString());
            	formObj.cntr_use_co_cd.value    = ComXmlString(sXml, "cntr_use_co_cd");
            	formObj.ownr_co_cd.value        = ComXmlString(sXml, "ownr_co_cd");
            	formObj.vndr_abbr_nm.Text      = ComXmlString(sXml, "vndr_abbr_nm");
            	formObj.vndr_lgl_eng_nm.value   = ComXmlString(sXml, "vndr_lgl_eng_nm");
            	formObj.mft_dt.value            = ComXmlString(sXml, "mft_dt");
            	if (ComXmlString(sXml, "d2_payld_flg") == 'Y')
            	    formObj.d2_payld_flg.checked = true;
            	if (formObj.lstm_cd.value == "LT" && formObj.cntr_tpsz_cd.value.substring(0, 1) == "R"){
            		comboObjects[1].Enable = true;
            		document.getElementById("rf_tp_cd").BackColor = "#CCFFFD";
            	}else{
            		comboObjects[1].Enable = false;
            		document.getElementById("rf_tp_cd").BackColor = "#FFFFFF";
            	}
            	ComSetObjValue(formObj.rf_tp_cd,	ComXmlString(sXml, "rf_tp_cd"));
            	
            	if (formObj.vndr_abbr_nm.Text == ""){
            		comboObjects[0].InsertItem(-1, ComXmlString(sXml, "vndr_abbr_nm") + '|' + ComXmlString(sXml, "vndr_lgl_eng_nm"), ComXmlString(sXml, "vndr_abbr_nm"));
            		formObj.vndr_abbr_nm.Text      = ComXmlString(sXml, "vndr_abbr_nm");
            	}
            	
            	if (formObj.chk_dgt.value == "" && formObj.lstm_cd.value == "" && formObj.cntr_tpsz_cd.value == "" && formObj.aciac_div_cd.value == "" ){
            		ComBtnDisable("btn_save");
            	} else {
            		ComBtnEnable("btn_save");
            	}
            	
            	ComOpenWait(false);
            	//시트 데이타 채우기
 			break;
 			
			case IBSEARCH01:
				 form.cntr_tpsz_cd.RemoveAll();
	             form.f_cmd.value = SEARCH02;
	             var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do" , FormQueryString(formObj)+"&eq_knd_cd=U");
	    		 var chk = sXml.indexOf("ERROR");
	    		 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
	    		    sheetObj.LoadSearchXml(sXml);
	    			return;
	    		 }	             
	             
	             //TP/SZ 조회
	             var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");
	             head_cntr_tpsz_cd = cntr_tpsz_cd;
	             tot_cntr_tpsz_cd = cntr_tpsz_cd;
	             formObj.head_cntr_tpsz_cd.value = head_cntr_tpsz_cd; 
	             var strCntrTpszCd  = cntr_tpsz_cd.split("|");
	             
		         with (form.cntr_tpsz_cd) {
		        	 MultiSelect = false;
		        	 DropHeight = 150;
		        	 for ( var i=0; i<cntr_tpsz_cd.split("|").length; i++) {
	  		        	 InsertItem(i, strCntrTpszCd[i], strCntrTpszCd[i]);
		        	 }
		         }
			break;
			
	        case IBSEARCH_ASYNC01:     
				formObj.f_cmd.value = SEARCH01;
				var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
	    		var chk = xmlStr.indexOf("ERROR");
	    		if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
	    		   sheetObj.LoadSearchXml(xmlStr);
	    		   return;
	    		}				
				var sStr = ComGetEtcData(xmlStr, "comboList");
				var arrStr = sStr.split("@");
				MakeComboObject(formObj.vndr_abbr_nm, arrStr, 1, 0); 
				
				with (formObj.vndr_abbr_nm) { 
				   SetColAlign("center|left");        
				   SetColWidth("70|200");         
				   DropHeight = 160;   
  	               MultiSelect = false;
   	               MaxSelect = 1;
   	               BackColor == "#CCFFFD"
				}
			break;
			
	        case IBSAVE:
			    if (formObj.cntr_no.value.trim().length == 0 ||
			    	formObj.cntr_mtrl_cd.value.trim() == "" ||
			    	formObj.vndr_abbr_nm.Text.trim() == ""){
			    	
			    	if (formObj.cntr_no.value.trim().length == 0){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   formObj.cntr_no.focus();
				    	   return;
				    } else if (formObj.cntr_tpsz_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "TP/SZ");
				    	   formObj.cntr_tpsz_cd.focus();
				    	   return;
				    } else if (formObj.cntr_mtrl_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Material");
				    	   formObj.cntr_mtrl_cd.focus();
				    	   return;
				    } else if (formObj.vndr_abbr_nm.Text.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Manufacturer");
				    	   formObj.vndr_abbr_nm.focus();
				    	   return;
				    }
			    	
			    	if (formObj.sub_lstm_cd.value.trim() == "" && formObj.lstm_cd.value.trim() == "") {
			    		   ComShowCodeMessage("MST00012");
				    	   formObj.cntr_no.focus();
				    	   return;
			    	} 
			    }	
	        	
		    	if (formObj.lstm_cd.value == "OW" || 
			    	formObj.lstm_cd.value == "LP" || 
			    	formObj.lstm_cd.value == "OL"){
			    	ComShowCodeMessage("MST02007", formObj.lstm_cd.value);
			    	return;
			    }
		    	if(formObj.lstm_cd.value == "LT" && formObj.cntr_tpsz_cd.value.substring(0, 1) == "R" && formObj.rf_tp_cd.text.length == 0){
		    		ComShowCodeMessage("MST02021", formObj.rf_tp_cd);
		    	}
		    	sheetObj.WaitImageVisible=false;
		    	ComOpenWait(true);
	        	formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("EES_MST_0044GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") == -1 && sXml.indexOf("Error") == -1)
				    ComShowCodeMessage("MST01025")
				else
					sheetObj.LoadSearchXml(sXml);
	        break;
	        
	        case SEARCH08:      //Unit Type 조회
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);			
				formObj.f_cmd.value = SEARCH08;			
			var xml = "";
			xml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
			var comboItems = ComGetEtcData(xml, "unit_type").split("|");
			if(comboItems != ""){
				addComboItem(formObj.rf_tp_cd,comboItems);
			}
			ComOpenWait(false);
		break;
       }
    }
    
  	/**
  	 * 콤보 오브젝트 생성(Spec No * Type/Size)
  	 */
  	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
  		cmbObj.RemoveAll();
  		cmbObj.InsertItem(0, "", "");
  		
  		for (var i=0; i<arrStr.length; i++) {
  			var arrCode = arrStr[i].split("|");
  			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
  		}
  		cmbObj.Index2 = "" ;
  	}    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
       
    function initDisplay(){
    	  var formObj = document.form;
         	//formObj.chk_dgt.value           = "";
         	formObj.aciac_div_cd.value      = "";
         	formObj.cntr_tpsz_cd.value      = "";
         	formObj.sub_lstm_cd.value       = "";
         	formObj.lstm_cd.value           = "";
         	formObj.cntr_mtrl_cd.value		= "";         
         	formObj.tare_wgt.value          = "";
         	formObj.tare_wgt_lbs.value      = "";
         	formObj.cntr_use_co_cd.value    = "";
         	formObj.ownr_co_cd.value        = "";
         	formObj.vndr_abbr_nm.Text       = "";
         	formObj.vndr_lgl_eng_nm.value   = "";
         	formObj.mft_dt.value            = "";
         	formObj.d2_payld_flg.checked    = false;
         	formObj.rf_tp_cd.text          = "";
         	formObj.cntr_tpsz_iso_cd.value  = "";
         	formObj.cntr_no.focus();
    }
    
	/*
	 * vndr_abbr_nm OnChange 이벤트 처리 
	 */
	function vndr_abbr_nm_OnChange(comboObj,Index_Code, Text){
		var formObj = document.form;
		formObj.vndr_lgl_eng_nm.value = comboObj.GetText(Index_Code, 1);
	}	
	
	function cntr_tpsz_cd_OnChange(comboObj,Index_Code, Text){
		var formObj = document.form;
		if (Text.substring(0,1) == "R" && formObj.lstm_cd.value == "LT"){
			formObj.rf_tp_cd.disabled = false;
    		document.getElementById("rf_tp_cd").className = "input1";			
		} else {
			formObj.rf_tp_cd.disabled = true;
    		document.getElementById("rf_tp_cd").className = "input2";
    		formObj.rf_tp_cd.value = "";
		}
	}
	 
	/*
	 * vndr_abbr_nm OnChange 이벤트 처리 
	 */
     function func_calendar(){
     	var formObj = document.form; 
         if (formObj.mft_dt.readOnly == false){    	 
 	         var cal = new ComCalendar();
 	         cal.select(document.form.mft_dt, "yyyy-MM-dd");
         } 
      }
	 
	 /**
	  * 콤보필드에 데이터를 추가해준다.
	  */
	 function addComboItem(comboObj, comboItems) {
		  for ( var i = 0; i < comboItems.length; i++) {
	 		var comboItem = comboItems[i].split(",");
	 		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	 	}
		  comboObj.InsertItem(0,"","");
	 }
	 
	/* 개발자 작업  끝 */