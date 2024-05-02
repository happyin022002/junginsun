/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CCD_0033.jsp
*@FileTitle  : Sales rep
*@author     : jklim
*@version    : 1.0
*@since      : 2017/12/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BCM_CCD_0033 : BCM_CCD_0033 on the screen for creating the script defines the task using.
     */
    /** Common global variable */

    function BCM_CCD_0033() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl; 
    	this.doActionIBSheet 		= doActionIBSheet;
		this.obj_keypress_loc       = obj_keypress_loc;
		this.obj_keyup              = obj_keyup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

    var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    var isdoActionIBSheetBeingProcessed=false;
    
    var x_sheetObject1 = null;
    
    /** Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name */
	function processButtonClick() {
/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		
        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {
        	case "btn_History":
	        	var tblNo = 'MDM_SLS_REP';
	        	var srepCd = formObj.srep_cd.value;
	        	var mstKey = nullToBlank(srepCd);
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Sales Rep Code");
					return false;
				}
	        	comMdmCallPop(tblNo, mstKey);
        		break;
            case "btn_Retrieve":
            	doActionIBSheet(sheetObject,formObj,SEARCH);
//				formObj.srep_cd.focus();
				break;
            case "btn_New":
            	doActionIBSheet(sheetObject,formObj,IBCLEAR);
            	formObj.srep_cd.focus();
            	ComBtnDisable("btn_Save");
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObject,formObj,MULTI01);
            	break;
			case "btn_Close":
				ComClosePopup(); 
				break;
            case "btn_Create":
 				doActionIBSheet(sheetObject,formObj,IBCLEAR);
 				formObj.creflag.value="Y";
 				formObj.srep_cd.readOnly=true;
 				formObj.srep_cd.style.backgroundColor="#bebebe";
 				formObj.btn_com_ens_043.disabled = true;
 				formObj.cnt_cd.focus();
 				ComBtnEnable("btn_Save");
 				break;
			case "btn_com_ens_0M1": // country pop-up
				var param="";
	    		param=param + "&" + "cnt_cd=" + form.cnt_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0M1.do?' + param, 780, 470, 'setCallBack0B5', '1,0,1,1,1,1,1,1', true);
				break;
            case "btn_com_ens_071": // office pop-up
 				var param="";
 	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
 	    		if(!form.btn_com_ens_071.disabled)
 	    			ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
 				break;
            case "btn_code_create":
				doActionIBSheet(sheetObject,formObj,SEARCH05);
//            	formObj.cnt_cd.focus();
				break;
            case "btn_com_ens_043": // sales rep
 			   var param="";
 			   if(!form.btn_com_ens_043.disabled)
 				   ComOpenPopup('/hanjin/COM_ENS_043.do?' + param, 780, 400, 'setCallBack0B7', '1,0,1,1,1,1,1,1', true);
     		   break;   			
            }
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
   	function setComboObject(combo_obj){	     
       	comboObjects[comboCnt++]=combo_obj;  
   	} 
   	/**
   	 * initializing sheet
   	 * implementing onLoad event handler in body tag
   	 * adding first-served functions after loading screen.
   	 */
    function loadPage() {
    	var formObj=document.form;
    	for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        initControl();
        
        initComboSetVal(sheetObjects[0],document.form);
 	   
 	    for(var k=0;k<comboObjects.length;k++){
 	 		initCombo(comboObjects[k],comboObjects[k].id);
 	 	}
     
 	    x_sheetObject1 = sheetObjects[0];  //customer main
 	    ComBtnDisable("btn_Save");
    }
    
    
	 /**
	 * BCM_CCD_0033 콤보 데이타를 가져온다.
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value = SEARCH01;
	 	
	 	var sXml = sheetObj.GetSearchXml("BCM_CCD_0033GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.sex_cd, "cd", "cd_desc");
	 }
	 
		/**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  UseAutoComplete = true; // 편집시 자동 코드 검색
      } 
    

 	/**
 	  * setting sheet initial values and header
 	  * param : sheetObj, sheetNo
 	  * adding case as numbers of counting sheets
 	  */
	 function initSheet(sheetObj,sheetNo) {
			var cnt = 0;
		    switch(sheetObj.id) {
		        case "sheet1":   //sheet1 init
		            with (sheetObj) {
		                //Host정보 설정[필수][HostIp, Port, PagePath]
		                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
		                
		              //전체Merge 종류 [선택, Default msNone]
		    			MergeSheet = msNone;
		
		    			//전체Edit 허용 여부 [선택, Default false]
		    			Editable = true;
		    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		    			InitRowInfo(1, 1, 15, 100);
		    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		    			InitColumnInfo(60, 0, 0, true);
		
		    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		    			InitHeadMode(true, true, false, true, false, false)
		    			var HeadTitle1 = " |";
		
		    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		    			InitHeadRow(0, HeadTitle1, true);
		
		    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		    			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
						InitDataProperty(0, cnt++ , dtSeq,          40,    daCenter,  false,   "Seq");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "glo_usr_id");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cnt_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ofc_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "sex_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_abbr_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ib_srep_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ob_srep_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "empe_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_eml");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "mphn_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "creflag");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "delt_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cre_usr_id");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cre_dt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "upd_usr_id");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "upd_dt");
		            }
		            break;
		    }
		}
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	switch(sAction) {
    	case SEARCH:				//Retrieve
    		
    		if (validateForm(sheetObj, formObj, sAction)) {
    			//isdoActionIBSheetBeingProcessed=true;
    			
    			ComOpenWait(true);					
				
				formObj.f_cmd.value = SEARCH;
				
				//formObj.creflag.value="R";
    		    var sXml = sheetObj.GetSearchXml("BCM_CCD_0033GS.do", FormQueryString(formObj));				
				var arrXml = sXml.split("|$$|"); 
				
				if (arrXml.length > 0) {
					x_sheetObject1.LoadSearchXml(arrXml[0]);
				}
    			
				ComOpenWait(false);
				
    			formObj.creflag.value = "N";
    			formObj.ibflag.value = "N";
    			
	    		formObj.glo_usr_id.value=sheetObj.CellValue(1, "glo_usr_id");
	    		formObj.cnt_cd.value=sheetObj.CellValue(1, "cnt_cd");
	    		formObj.ofc_cd.value=sheetObj.CellValue(1, "ofc_cd");
	    		formObj.srep_nm.value=sheetObj.CellValue(1, "srep_nm");
	    		ComSetObjValue(formObj.sex_cd,sheetObj.CellValue(1, "sex_cd"));
	    		formObj.srep_abbr_nm.value=sheetObj.CellValue(1, "srep_abbr_nm");
	    		ComSetObjValue(formObj.ib_srep_flg,sheetObj.CellValue(1, "ib_srep_flg"));
	    		ComSetObjValue(formObj.ob_srep_flg,sheetObj.CellValue(1, "ob_srep_flg"));
	    		ComSetObjValue(formObj.delt_flg,sheetObj.CellValue(1, "delt_flg"));
	    		formObj.empe_cd.value=sheetObj.CellValue(1, "empe_cd");
	    		formObj.srep_eml.value=sheetObj.CellValue(1, "srep_eml");
	    		formObj.mphn_no.value=sheetObj.CellValue(1, "mphn_no");
	    		formObj.cre_usr_id.value=sheetObj.CellValue(1, "cre_usr_id");
	    		formObj.cre_dt.value=sheetObj.CellValue(1, "cre_dt");
	    		formObj.upd_usr_id.value=sheetObj.CellValue(1, "upd_usr_id");
	    		formObj.upd_dt.value=sheetObj.CellValue(1, "upd_dt");
	    		formObj.srep_cd.readOnly=true;
	    		formObj.srep_cd.style.backgroundColor="#bebebe";
	    		formObj.glo_usr_id.readOnly=true;
	    		formObj.glo_usr_id.style.backgroundColor="#bebebe";
	    		
	    		if (sheetObj.CellValue(1, "delt_flg") == ""){
    		    	ComBtnDisable("btn_Save");
    		    } else {
    		    	ComBtnEnable("btn_Save");
    		    }
	    		
    		}
    		break;
    	case MULTI01:				//Save
    		if (validateForm(sheetObj, formObj, sAction)) {
    			formObj.f_cmd.value=MULTI01;
          	    
          	    var sParam = FormQueryString(formObj);

          	    if(formObj.ibflag.value == "N") {
	              	ComShowCodeMessage("COM130503");
	              	return;
	            }
          	    
          	    if(ComShowCodeConfirm("COM130101", "Data")){

	    			ComOpenWait(true); //대기이미지 표시
	
	    			var SaveXml = sheetObj.GetSaveXml("BCM_CCD_0033GS.do", sParam);
	    			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
	    			var l_srep_cd=ComGetEtcData(SaveXml, "SREP_CD");
	    			
	    			ComOpenWait(false); //대기이미지 숨김
	
	    			if(sav == "S"  ){
	    				ComShowCodeMessage("COM130102", "Data");
	    				formObj.srep_cd.value = l_srep_cd;
	     				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	     			}else{
	     				ComShowCodeMessage("COM130103", "Data");
	     			}
          	    }
    		}
    		break;
    	case IBCLEAR:
    		formObj.reset();
    		formObj.ibflag.value = "I";
    		formObj.creflag.value = "Y";
    		ComSetObjValue(formObj.sex_cd,"");
    		ComSetObjValue(formObj.ib_srep_flg,"");
    		ComSetObjValue(formObj.ob_srep_flg,"");
    		ComSetObjValue(formObj.delt_flg,"N");
    		//ComBtnEnable("btn_code_create");

    		formObj.srep_cd.readOnly=false;		
    		formObj.srep_cd.className= "input1";
    		formObj.srep_cd.style.backgroundColor="#d4f6ff";
    		
    		formObj.glo_usr_id.readOnly=false;		
    		formObj.glo_usr_id.className= "input1";
    		formObj.glo_usr_id.style.backgroundColor="#d4f6ff";
    		formObj.btn_com_ens_043.disabled = false;
    		//ComBtnEnable("btn_save");
    		
    		break;
    	case SEARCH02:      //Country Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				var sParam = "f_cmd=102&" + "&val_type=Country"+"&cust_cnt_cd="+formObj.cnt_cd.value;
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Country Code");
		        	formObj.cnt_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;
    	case SEARCH04:      //Office Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH04;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Office Code");
		        	formObj.ofc_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;
    	case SEARCH10:      //Sales Rep Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH10;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Sales Rep Code");
		        	formObj.srep_cd.value="";
		        	//document.form.srep_cd.focus();
		        }
				ComOpenWait(false);
			}
			break;
    	}
    	return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction) {
    	switch (sAction) {
    	case SEARCH:
			if(formObj.srep_cd.value == "" || formObj.srep_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Sales Rep.");
    			formObj.srep_cd.focus();
    			return false;
	    	}
    		break;
    	case MULTI01:
    		if((formObj.srep_cd.value == "" || formObj.srep_cd.value == null) && formObj.ibflag.value != "I"){
    			ComShowCodeMessage("CCD00001", "Sales Rep.");
    			formObj.srep_cd.focus();
    			return false;
    		}
    		if(formObj.glo_usr_id.value == "" || formObj.glo_usr_id.value == null){
    			ComShowCodeMessage("CCD00001", "Global ID");
    			formObj.glo_usr_id.focus();
    			return false;
    		}
    		if(formObj.cnt_cd.value == "" || formObj.cnt_cd.value == null){
    			ComShowCodeMessage("CCD00001", "SR Country");
    			formObj.cnt_cd.focus();
    			return false;
    		}
    		if(formObj.ofc_cd.value == "" || formObj.ofc_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Office Code");
    			formObj.ofc_cd.focus();
    			return false;
    		}
    		if(formObj.srep_nm.value == "" || formObj.srep_nm.value == null){
    			ComShowCodeMessage("CCD00001", "Name");
    			formObj.srep_nm.focus();
    			return false;
    		}
    		
    		if(formObj.srep_eml.value == "" || formObj.srep_eml.value == null){
    			ComShowCodeMessage("CCD00001", "Email");
    			formObj.srep_eml.focus();
    			return false;
    		}else if(!checkEmailValue(formObj.srep_eml)){
    			return false;
    		}
    		if(formObj.mphn_no.value == "" || formObj.mphn_no.value == null){
    			ComShowCodeMessage("CCD00001", "Mobile Number");
    			formObj.mphn_no.focus();
    			return false;
    		}
    		break;
		case SEARCH05:
    		if(formObj.cnt_cd.value == "" || formObj.cnt_cd.value == null){
    			ComShowCodeMessage("CCD00001", "SR Country");
//    			formObj.cnt_cd.focus();
    			return false;
    		}
    		break;
    	}
    	return true;
    }

    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm  ("change", 	 "form_onChange", 		formObj);
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	    axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 	    axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
        
        //applyShortcut();
    }	
    
	// 업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress_loc() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
	       case "float":
	           //숫자+"."입력하기
	           ComKeyOnlyNumber(event.srcElement, ".");
	           break;
	       case "eng":
	           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	           ComKeyOnlyAlphabet();
	           break;
	       case "engdn":
	           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	           ComKeyOnlyAlphabet('lower');
	           break;
	       case "engup":
	           //영문 대문자만 입력하기
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //숫자만입력하기(정수,날짜,시간)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
	       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
	     			event.keyCode = keyValue + 65 - 97;
	     		}
	           break;
	       case "tel":
		        // 숫자+"-"입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		        break;
           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
	    }
	}
   /**
   * HTML Object OnKeyUp event handling
   */
   function obj_keypress(event) {
      var obj=event.srcElement;
      keyValidation(obj);
   }
   
   
   function form_onChange(evt,el) {
	  	var formObj = document.form;
	  	var xml = "";
	  	var srcName;
	  	var srcValue;
		var srcObj;
		
	  	if (el) {
	  		srcObj = el;
	  		srcName = el.getAttribute("name");
	  		srcValue = el.getAttribute("value");
	  	} else {
	  		srcObj = window.event.srcElement;
	  		srcName = srcObj.getAttribute("name");
	  		srcValue = srcObj.getAttribute("value");
	  		if(formObj.ibflag.value != 'I'){
	  			formObj.ibflag.value = "U";
	  		}
	  	}
	  	
	  	switch(srcName) {
	  	case "cnt_cd":
       		if(formObj.cnt_cd.value.length>0){
       			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
       			if(formObj.cnt_cd.value.length==0){
   					document.form.cnt_cd.focus();
       			}else{
       				document.form.ofc_cd.focus();
       			}
       		}
       		break;
	  	
  		case "ofc_cd":
       		if(formObj.ofc_cd.value.length>0){
       			doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
       			if(formObj.ofc_cd.value.length==0){
   					document.form.ofc_cd.focus();
       			}else{
       				document.form.srep_nm.focus();
       			}
       		}
       		break;
       	
       	case "srep_cd":
       		if(formObj.srep_cd.value.length>0){
       			doActionIBSheet(sheetObjects[0], formObj, SEARCH10);

       			if(formObj.srep_cd.value.length==0){
       				document.form.srep_cd.focus();
       			}else{
       				doActionIBSheet(sheetObjects[0],formObj,SEARCH);
       			}
       		}
           	break;
	  	}
	}

	/**
	 * Sales Rep Code Pop up to read from. <br>
	 */
	function setCallBack0B7(aryPopupData) {
		var form=document.form;
		if (form.srep_cd.value != aryPopupData[0][4]){
			form.srep_cd.value=aryPopupData[0][4];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	
	/**
	 * Office Code Pop up to read from. <br>
	 */
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		if (form.ofc_cd.value != aryPopupData[0][3]){
			form.ofc_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	
	/**
	 * Country Code Pop up to read from. <br>
	 */
	function setCallBack0B5(aryPopupData) {
		var form=document.form;
		if (form.cnt_cd.value != aryPopupData[0][3]){
			form.cnt_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
    
	  function getValueForCombo(obj) {
		  if (Object.prototype.toString.call(obj) === '[object Array]') {
			  var str = obj[0];
			  if(str == undefined) return obj;
			  return str.split('|')[0];
		  }
		  return obj;
	  }
	    
	function isEmailAddr(event){
	    eventElement=ComGetEvent();
		if(eventElement.value.length > 0) {
			if(!ComIsEmailAddr(eventElement)) {
				ComShowCodeMessage("CCD00007");
				eventElement.focus();
			}
		}
	}
	
	// Gender 변경시
	function sex_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}