/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0096.js
*@FileTitle  : Lease Agreement Version Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================*/
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
        var formObj=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {
        		case "btns_calendar1":
        			var cal=new ComCalendar();
	                cal.select(formObj.new_exp_dt, 'yyyy-MM-dd');
        			break;
        		case "btn_OK":
//        			ComPopUpReturnValue(ComGetObjValue(formObj.new_eff_dt) + "|" + ComGetObjValue(formObj.new_exp_dt));
//        			ComClosePopup();
//        			comPopupOK();
        			if ( validateForm(formObj) ) {
        				ComPopUpReturnValue(ComGetObjValue(formObj.new_eff_dt) + "|" + ComGetObjValue(formObj.new_exp_dt));
//        				window.returnValue=ComGetObjValue(formObj.new_eff_dt) + "|" + ComGetObjValue(formObj.new_exp_dt)
        				ComClosePopup(); 
        			}

        			break;
        		case "btn_Close":
        			ComClosePopup(); 
        			break;
        	} // end switch
        } catch(e) {
        	if( e == "[object Error]") {
        		ComShowMessage(OBJECT_ERROR);
        	} else {
        		ComShowMessage(e.message);
        	}
        }
	}
	/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
	 */
	function loadPage() {
		/* Axon Control Setting*/
		initControl();
		ComAddSeparator(form.eff_dt, "ymd");
		ComAddSeparator(form.exp_dt, "ymd");
		ComAddSeparator(form.new_eff_dt, "ymd");
		ComSetFocus(document.form.new_exp_dt);
	 }
	//Axon 이벤트 처리1. 이벤트catch
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * 키보드가 눌릴 때
	 **/
	function obj_keypress() {
		var obj=ComGetEvent;
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet('num');
	        	} else {
	        		ComKeyOnlyAlphabet(); 
	        	}
	            break;
	        case "engup":
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
	}
	/**
	 * handling Location blur event
	 **/
	function obj_blur(){
	    switch(ComGetEvent("name")){
	        default:
	            //checking Validation
	            ComChkObjValid(ComGetEvent());
	        	ComAddSeparator(form.new_exp_dt, "ymd");
	    }
	}
	/**
	 * handling event in case of focus
	 **/
	function obj_focus(){
		var obj=ComGetEvent();
		if( obj.readOnly ) {
		  	ComSetNextFocus(obj);
		} else {
			//deleting data unit separator
			ComClearSeparator(obj);
		}
	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- End
	/**
	 * handling process for input validation
	 */
	function validateForm(formObj) {
		// Effective Date Validation(eff_dt < exp_dt)
		var vEffDt=ComReplaceStr(ComGetObjValue(formObj.new_eff_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.new_exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.new_exp_dt,"");
			ComSetFocus(formObj.new_exp_dt);
			return false;
		}
		return true;
	}
	/* end of developer job */
