/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CCD_0002.js
*@FileTitle  :  Charge
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
     * @class BCM_CCD_0002 : BCM_CCD_0002 on the screen for creating the script defines the task using.
     */
    /** Common global variable */

    function BCM_CCD_0002() {
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
	        	var tblNo = 'MDM_CHARGE';
	        	var chgCd = formObj.chg_cd.value;
	        	var mstKey = nullToBlank(chgCd);
	        	if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Charge Code");
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
            	formObj.creflag.value="N";
            	formObj.chg_cd.focus();
            	ComBtnDisable("btn_Save");
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObject, formObj, MULTI);
            	break;
			case "btn_Close":
				ComClosePopup(); 
				break;
            case "btn_Create":
 				doActionIBSheet(sheetObject,formObj,IBCLEAR);
 				formObj.creflag.value="Y";
 				formObj.chg_cd.focus();
 				ComBtnEnable("btn_Save");
 				break;
    		case "input_seach_btn":
    			//ComOpenPopup('/hanjin/COM_COM_0001.do?mdm_yn='+formObj.mdm_yn.value+"&chg_cd=" + formObj.chg_cd.value, 600, 430, 'getChg_cd', "1,0,1", true);
    			ComOpenPopup('/hanjin/ESM_BKG_0975.do?pgmNo=ESM_BKG_0975&chg_cd='+formObj.chg_cd.value, 650, 610, 'getChg_cd', "0,0", true);
    			break;				
    		case "btns_search1":
                ComOpenPopup('/hanjin/COM_ENS_N11.do', 770, 520, 'getAcct_cd', "1,0,1", true);
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
        formObj.creflag.value="N";
        
        initComboSetVal(sheetObjects[0],document.form);

        for(var k=0;k<comboObjects.length;k++){
 	 		initCombo(comboObjects[k],comboObjects[k].id);
 	 	}

        x_sheetObject1 = sheetObjects[0];
 	    ComBtnDisable("btn_Save");
    }
    
	 /**
	 * BCM_CCD_0002 콤보 데이타를 가져온다.
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value = SEARCH01;
	 	
	 	var sXml = sheetObj.GetSearchXml("BCM_CCD_0002GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.chg_rev_tp_cd, "cd", "cd|cd_desc");
		if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1], formObj.chg_aply_tp_cd, "cd", "cd|cd_desc");
		if (arrXml.length > 2) 
			ComXml2ComboItem(arrXml[2], formObj.chg_aply_area_cd, "cd", "cd|cd_desc");
		if (arrXml.length > 3) 
			ComXml2ComboItem(arrXml[3], formObj.rep_chg_cd, "cd", "cd|cd_desc");
		if (arrXml.length > 4) 
			ComXml2ComboItem(arrXml[4], formObj.use_co_tp_cd, "cd", "cd|cd_desc");
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
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "hjs_chg_acct_cd");
						InitDataProperty(0, cnt++ , dtData, 		30,    daCenter,  true,    "rep_chg_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_rev_tp_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_aply_tp_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_aply_area_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cy_rd_term_flg");
						InitDataProperty(0, cnt++ , dtData, 		30,    daCenter,  true,    "cfs_rd_term_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "dor_rd_term_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "na_rd_term_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "tkl_tml_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "aply_svc_mod_flg");
						InitDataProperty(0, cnt++ , dtData, 		30,    daCenter,  true,    "use_co_tp_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "auto_rat_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "tax_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "tax_cnt_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "dp_seq");
						
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_edi_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "mdt_rat_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "chg_sts_cd");
						
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
	    		    var sXml = sheetObj.GetSearchXml("BCM_CCD_0002GS.do", FormQueryString(formObj));				
					var arrXml = sXml.split("|$$|"); 

					if (arrXml.length > 0) {
						x_sheetObject1.LoadSearchXml(arrXml[0]);
					}
	    			ComOpenWait(false);
	    								
	    			formObj.creflag.value = "N";
	    			formObj.ibflag.value = "N";
	    				    			
	    			formObj.chg_cd.value=sheetObj.CellValue(1, "chg_cd");
	    			if (formObj.chg_cd.value.length != 0){
	    				formObj.chg_nm.value=sheetObj.CellValue(1, "chg_nm");
	    				ComSetObjValue(formObj.chg_rev_tp_cd,sheetObj.CellValue(1, "chg_rev_tp_cd"));
	    				ComSetObjValue(formObj.chg_aply_tp_cd,sheetObj.CellValue(1, "chg_aply_tp_cd"));
	    				ComSetObjValue(formObj.chg_aply_area_cd,sheetObj.CellValue(1, "chg_aply_area_cd"));
	    				formObj.hjs_chg_acct_cd.value=sheetObj.CellValue(1, "hjs_chg_acct_cd");
	    				ComSetObjValue(formObj.rep_chg_cd,sheetObj.CellValue(1, "rep_chg_cd"));
	    				
	    				ComSetObjValue(formObj.use_co_tp_cd,sheetObj.CellValue(1, "use_co_tp_cd"));
	    				ComSetObjValue(formObj.aply_svc_mod_flg,sheetObj.CellValue(1, "aply_svc_mod_flg"));
	    				formObj.dp_seq.value=sheetObj.CellValue(1, "dp_seq");
	    				
	    				formObj.chg_edi_cd.value=sheetObj.CellValue(1, "chg_edi_cd");
	    				ComSetObjValue(formObj.mdt_rat_flg,sheetObj.CellValue(1, "mdt_rat_flg"));
	    				ComSetObjValue(formObj.chg_sts_cd,sheetObj.CellValue(1, "chg_sts_cd"));
	    				
	    				if(sheetObj.CellValue(1, "cy_rd_term_flg")=='Y'){
	                        formObj.cy_rd_term_flg.checked=true;
	                    }else{
	                        formObj.cy_rd_term_flg.checked=false;
	                    }
	    				if(sheetObj.CellValue(1, "cfs_rd_term_flg")=='Y'){
	                        formObj.cfs_rd_term_flg.checked=true;
	                    }else{
	                        formObj.cfs_rd_term_flg.checked=false;
	                    }
	    				if(sheetObj.CellValue(1, "dor_rd_term_flg")=='Y'){
	                        formObj.dor_rd_term_flg.checked=true;
	                    }else{
	                        formObj.dor_rd_term_flg.checked=false;
	                    }
	    				if(sheetObj.CellValue(1, "tkl_tml_flg")=='Y'){
	                        formObj.tkl_tml_flg.checked=true;
	                    }else{
	                        formObj.tkl_tml_flg.checked=false;
	                    }
	    				if(sheetObj.CellValue(1, "na_rd_term_flg")=='Y'){
	                        formObj.na_rd_term_flg.checked=true;
	                    }else{
	                        formObj.na_rd_term_flg.checked=false;
	                    }	    				
	    				
	    				ComSetObjValue(formObj.delt_flg,sheetObj.CellValue(1, "delt_flg"));
			    		formObj.cre_usr_id.value=sheetObj.CellValue(1, "cre_usr_id");
			    		formObj.cre_dt.value=sheetObj.CellValue(1, "cre_dt");
			    		formObj.upd_usr_id.value=sheetObj.CellValue(1, "upd_usr_id");
			    		formObj.upd_dt.value=sheetObj.CellValue(1, "upd_dt");
			    		
			    		formObj.chg_cd.readOnly=true;
			    		formObj.chg_cd.style.backgroundColor="#bebebe";
			    		ComBtnEnable("btn_Save");
	    			} else {
	    				ComShowCodeMessage("CCD00002");
	    				ComBtnDisable("btn_Save");
	    			}
	    		}
	    		break;
	    	case MULTI:				//Save
	    		if (validateForm(sheetObj, formObj, sAction)) {
	    			formObj.f_cmd.value=MULTI;
	          	    
	          	    var sParam = FormQueryString(formObj);

	          	    if(formObj.ibflag.value == "N") {
		              	ComShowCodeMessage("COM130503");
		              	return;
		            }
	          	    if(ComShowCodeConfirm("COM130101", "Data")){

		    			ComOpenWait(true); //대기이미지 표시
		
		    			var SaveXml = sheetObj.GetSaveXml("BCM_CCD_0002GS.do", sParam);
		    			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
		    			//var l_srep_cd=ComGetEtcData(SaveXml, "SREP_CD");
		    			
		    			ComOpenWait(false); //대기이미지 숨김
		
		    			if(sav == "S"  ){
		    				ComShowCodeMessage("COM130102", "Data");
		    				//formObj.srep_cd.value = l_srep_cd;
		     				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		     			}else{
		     				ComShowCodeMessage("COM130103", "Data");
		     			}
	          	    }
	    		}
	    		break;
	    	case IBCLEAR:
	    		formObj.reset();
	    		formObj.chg_cd.readOnly=false;		
	    		formObj.ibflag.value = "I";
	    		//formObj.creflag.value = "Y";
	    		
	    		ComSetObjValue(formObj.chg_rev_tp_cd,"");
	    		ComSetObjValue(formObj.chg_aply_tp_cd,"");
	    		ComSetObjValue(formObj.chg_aply_area_cd,"");
	    		ComSetObjValue(formObj.rep_chg_cd,"");
	    		ComSetObjValue(formObj.use_co_tp_cd,"");

	    		formObj.chg_cd.className= "input1";
	    		formObj.chg_cd.style.backgroundColor="#d4f6ff";
	    		
	    		break;
	    		
	    	case SEARCH02:      //Account Code check
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("BCM_CCD_0002GS.do", sParam);
			        var result=ComGetEtcData(sXml, "result");
			        if(result==""){
			        	ComShowCodeMessage("COM130402", "Account Code");
			        	formObj.hjs_chg_acct_cd.value="";
			        }
					ComOpenWait(false);
				}
				break;
	    	case SEARCH05:      //Charge Code check
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH05;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("BCM_CCD_0002GS.do", sParam);
			        var result=ComGetEtcData(sXml, "result");
			        if(result!=""){
			        	ComShowCodeMessage("CCD00004", "Charge Code");
			        	formObj.chg_cd.value="";
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
     with(formObj){
         switch ( sAction ) {
             case SEARCH:
                 if (formObj.chg_cd.value.length == 0){
                	 ComShowCodeMessage("CCD00001", "Charge Code");
                     formObj.cntr_sz_cd.focus();
                     return false;
                 }
                 break;
             case MULTI:  
            	 if (formObj.chg_cd.value.length == 0){
                	 ComShowCodeMessage("CCD00001", "Charge Code");
                     formObj.cntr_sz_cd.focus();
                     return false;
                 } 
            	 if (formObj.chg_nm.value.length == 0){
                	 ComShowCodeMessage("CCD00001", "Charge Name");
                	 formObj.cntr_sz_desc.focus();
                	 return false;
         		 }
                 break;
         }
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
	  	case "delt_flg":
			if (formObj.delt_flg.value == 'Y'){
				var checkFirm=ComShowConfirm(ComGetMsg("CCD00012"));
				if (checkFirm == 1){
					formObj.delt_flg.value='Y';
				}else{
					formObj.delt_flg.value='N';
				}
			}
			break;
	  	case "chg_cd":
	  		if(formObj.chg_cd.value.length>0 && formObj.creflag.value == 'Y'){
       			doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
       			if(formObj.chg_cd.value.length==0){
					document.form.chg_cd.focus();
    			}else{
    				document.form.chg_nm.focus();
    			}
       		} else if (formObj.chg_cd.value.length>0) {
       			doActionIBSheet(sheetObjects[0],formObj,SEARCH);
       		}
           	break;
	  	case "hjs_chg_acct_cd":
       		if(formObj.hjs_chg_acct_cd.value.length>0){
       			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
       			if(formObj.hjs_chg_acct_cd.value.length==0){
   					document.form.hjs_chg_acct_cd.focus();
       			}else{
       				document.form.rep_chg_cd.focus();
       			}
       		}
       		break;
  	}
}

function chg_rev_tp_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function chg_aply_tp_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function chg_aply_area_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function rep_chg_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function use_co_tp_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function mdt_rat_flg_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function chg_sts_cd_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function delt_flg_OnChange(Code, Text){
	var formObj = document.form;
	if(formObj.ibflag.value == 'N' ){
			formObj.ibflag.value					="U";
		}
}

function getAcct_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.hjs_chg_acct_cd.value=colArray[2];
}

function getChg_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.chg_cd.value=colArray[1];
    if(formObj.chg_cd.value.length > 0){
        doActionIBSheet(sheetObjects[0], formObj, SEARCH);
    }
}