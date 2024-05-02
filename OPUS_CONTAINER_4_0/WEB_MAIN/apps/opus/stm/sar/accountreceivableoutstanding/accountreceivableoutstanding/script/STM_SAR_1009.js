/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_1009.js
*@FileTitle : Payment Request Letter History
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
    /**
     * @extends 
     * @class STM_SAR_1009 : STM_SAR_1009 Defining business script.
     */
	// Common variables.
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Defining button events. */
	document.onclick=processButtonClick;
	/**
	 * Handling button event. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  none.  
	 * @return none.
	 * @see #
	 * @author 
	 * @version 2009.10.19
	 */
    function processButtonClick(){
         /***** Setting each tab's sheet variable. *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    	   var srcName=ComGetEvent("name");
    	   if(ComGetBtnDisable(srcName)) return false;
           switch(srcName) {
                case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                    break; 
                case "btn_new":
					//ComResetAll();
					//ComSetFocus(formObject.cust_cnt_cd);
                    break; 
             /*   case "btn_apply":
					//callParent();
                	comPopupOK();
                    break; */
                case "btn_close":
                	ComClosePopup(); 
                    break;    
                case "btnCalduedtFm": 
					var cal=new ComCalendar();
					cal.select(form.send_dt_fm, 'yyyy-MM-dd');
    				break;
    			case "btnCalduedtTo": 
    				var cal=new ComCalendar();
					cal.select(form.send_dt_to, 'yyyy-MM-dd'); 
    				break;	
    			case "btn_pop_cust_cd":
    				var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
    				var cust_seq=formObj.rct_cust_seq.value;
    				var classId="STM_SAR_9003"; 
    				var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId +'&office='+agn_ofc_cd.GetSelectText();
    				ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 450, 'getSTM_SAR_9003', '0,0', true, false);
    				break;		
    			case "btn_pop_credit_cust":
    				var formObject=document.form; 
    				if(formObject.cust_cnt_cd.value != "" && formObject.cust_seq.value != "") {        
    					var param='?cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y&ret_yn=Y'; 
    					ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1300, 650, 'getPopData', '0,0', false, false, null, null, null, 'customer', "no", null);  
    				}  
    				break;	
                    
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    
    function getSTM_SAR_9003(rowArray) {
    	var colArray=rowArray[0];
    	var formObj=document.form;
    	formObj.cust_cnt_cd.value=colArray[8];
    	formObj.cust_seq.value=ComLpad(colArray[9], 6, '0');
    	formObj.cust_nm.value=colArray[4];
    }

    /** 
     * Register IBSheet object on sheetObjects array. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return none.
     * @see #
     * @author 
     * @version 2009.10.19
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
     * Coding event handler for body tag's OnLoad. <br>
     * Add  pre-process functions after loading by browser. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  none.
     * @return none.
     * @see #
     * @author 
     * @version 2009.10.19
     */
    function loadPage() {
    	var formObject=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		initControl();  
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		initFormData();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    function initFormData() {
    	var formObject=document.form;
    	formObject.send_dt_to.value = ComGetNowInfo("ymd");  
		formObject.send_dt_fm.value = ComGetDateAdd(formObject.send_dt_to.value, "M", -1);
		//넘어온 값이 있으면
		if(!ComIsEmpty(formObject.rec_r_type)){
			if(formObject.rec_r_type.value == "O"){
				clearCustomer(); 
			}
			var send_r_type =  formObject.rec_r_type.value  
			$( "input[name=r_type]:radio:input[value=" + send_r_type + "]" ).attr( "checked", "checked" );
			
		}
		
		if(!ComIsEmpty(formObject.ar_ofc_cd)){
			agn_ofc_cd.SetSelectText(formObject.ar_ofc_cd.value);
		}
	}
    
    function agn_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
    	// ----------------------------------------
		//|CtrlOfcCd^OtsCd^ChkOfcYn^RhqCd^OtsSmryCd
		//|0        ^1    ^2       ^3    ^4 
		// -----------------------------------------  
    	var formObj=document.form; 
    	var sheetObj=sheetObjects[0];
    	var arrStr=newCode.split("^");  
    	sheetObjects[0].RemoveAll();
    	formObj.ar_ofc_cd.value=arrStr[0];
    }
    
    function initControl() {
	var formObj=document.form;
    //handling Axon event. event catch
	//axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
	//axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	//axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
	axon_event.addListenerFormat('change'          , 'obj_onchange', formObj);
//	axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//	axon_event.addListenerFormat('keyup'           , 'obj_keyup'   , formObj);
    }
    
	function obj_onchange(){
			var formObj=document.form;
			var sheetObject=sheetObjects[0];
			switch(ComGetEvent("name")){
				case "cust_seq":
					if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
						var valueCustSeq=formObj.cust_seq.value;
						formObj.cust_seq.value=ComLpad(valueCustSeq,6,"0");
						var cust_cd=formObj.cust_cnt_cd.value + formObj.cust_seq.value;
						formObj.cust_cd.value=cust_cd;
						doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
					}
					break;
			}
	}
	
    /** 
     * Initialize sheets. <br>
     * Add  pre-process functions after loading by browser. <br>
     * Coding initial modules as sheet's count. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : Sheet object.
     * @param Serial number for sheet object's ID.  
     * @return none.
     * @see #
     * @author 
     * @version 2009.10.19
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
            	 with(sheetObj){
            	   var HeadTitle="|Request ID|Request Type|Office|Send Time|Sender|Status|Customer|Customer Name"; 
            	   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stmt_rqst_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"stmt_rqst_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:"stmt_st_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"stmt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"stmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cs_cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	           		  {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",  ColMerge:0,   SaveName:"cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ]
               		InitColumns(cols);  
	                SetColProperty("stmt_sts_cd", {ComboText:"Processing|Success|Error", ComboCode:"P|S|E"} );      
               		SetEditable(1);  
               		resizeSheet();
                }
            break;
        }
    }
    /** 
     * Coding retrieve, save... <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet object.  
     * @param  {object} formObj : Form object.
     * @param  {sAction} sAction : f_cmd.
     * @param  {int} Row : Selected row.
     * @param  {int} Col : Selected column.
     * @param  {String}Val : Selected row, column value
     * @return none.
     * @see #
     * @author 
     * @version 2009.10.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBSEARCH:      //retrieve
				if (!validateForm(sheetObj, formObj, sAction)){return;}
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				setTimeout( function () {  
					formObj.f_cmd.value=SEARCH;			
		 			var sXml=sheetObj.GetSearchData("STM_SAR_1009GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					ComOpenWait(false); 
			    } , 100);		
                break;      
	        case IBSEARCH_ASYNC01:
				formObj.f_cmd.value=SEARCH14;  
	 			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var ctrlOfcStr=ComGetEtcData(sXml,"ctrl_ofc_cd"); 
				var arrCtrlStr=ctrlOfcStr.split("|"); 
				// ----------------------------------------
				//|CtrlOfcCd^OtsCd^ChkOfcYn^RhqCd^OtsSmryCd
				//|0        ^1    ^2       ^3    ^4 
				// -----------------------------------------
				var checkNum = 0;
				for (var i=1; i < arrCtrlStr.length; i++ ) {
					var arrStr=arrCtrlStr[i].split("^");
					var ctrlOfcCd=arrStr[0];
					agn_ofc_cd.InsertItem(i-1, ctrlOfcCd, arrCtrlStr[i]);	
					if(arrStr[2] == 'Y'){
						checkNum = i-1;
					}
				}
				
				break;     
	        case IBSEARCH_ASYNC02:	//Search Customer Info
				formObj.f_cmd.value=SEARCH06;
	 			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
	 				ComShowMessage(SarShowXmlMessage(sXml));
	 				ComClearObject(formObj.cust_cnt_cd);
	 				ComClearObject(formObj.cust_seq);
	 				ComClearObject(formObj.cust_nm);
	 				formObj.rct_cust_cnt_cd.focus();
	 			}else{
	 				formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
	 			}
				break;	
                
        }
    }    
    /** 
     * Validating input value. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet object.  
     * @param  {object} formObj : Form object.
     * @param  {sAction} sAction : f_cmd.
     * @return true, false
     * @see #
     * @author 
     * @version 2009.10.19
     */
    function validateForm(sheetObj,formObj,sAction){
    	var formObj=document.form;
    	var prefix="sheet1_";
        //var sail_arr_dt = formObject.sail_arr_dt.value;
    	switch (sAction) {
    		case IBSEARCH: //retrieve
    			if($('#r_type:checked').val() == "C"){
    				var cust_cd=formObj.cust_cnt_cd.value + formObj.cust_seq.value;
        			formObj.cust_cd.value=cust_cd;
        			if (formObj.cust_seq.value ==null || formObj.cust_seq.value ==""||formObj.cust_cnt_cd.value ==null || formObj.cust_cnt_cd.value ==""){
        				ComShowCodeMessage('COM130403','Customer');
        				ComSetFocus(formObj.cust_cd);
        				return false;
        			}	
    			}
    			
    			if(formObj.send_dt_fm.value == ""||ComIsNull(formObj.send_dt_fm.value)){
    				ComShowCodeMessage("COM12113", "From Send Date");
    				ComSetFocus(document.all.item("send_dt_fm"));
    				return false;
    			}
    			if(formObj.send_dt_to.value == ""||ComIsNull(formObj.send_dt_to.value)){
    				ComShowCodeMessage("COM12113", "To Send Date");
    				ComSetFocus(document.all.item("send_dt_to"));
    				return false;
    			}
    			var frDt1=ComReplaceStr(formObj.send_dt_fm,"-","");
    			var toDt1=ComReplaceStr(formObj.send_dt_to,"-","");
    			if (ComGetDaysBetween(frDt1, toDt1) < 0){
    				ComShowCodeMessage("COM132002");
    				return false;
    			}
    			return true;
    		break;
//           case IBSAVE: //retrieve			
//    			
//        	   if (sheetObj.RowCount == 0){
//    			    ComShowCodeMessage('COM130403','List');
//    				ComSetFocus(formObj.sheetObj);
//    				return false;
//    			}	
//    		break;
    	default:
    		break;
    	}
    	return true;
    }
    
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	}
	
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
	
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeRctOfcComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("^");
			var ots_ofc_cd=arrStr2[0];
			cmbObj.InsertItem(i-1, ots_ofc_cd, arrStr[i]);			 
		}
		
		cmbObj.SetDropHeight(190);
	}
	
	function clearCustomer(){ 
		var formObj=document.form;
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		formObj.cust_nm.value = "";
		ComSetDisplay("cust_cnt_cd",false); 
		ComSetDisplay("cust_seq",false);
		ComSetDisplay("cust_nm",false);
		ComSetDisplay("btn_pop_cust_cd",false);
		ComSetDisplay("btn_pop_credit_cust",false); 
		$("th#search1").hide();
		sheetObjects[0].RemoveAll();
	}

	function change_event_radio1(){ 
		clearCustomer();
	} 

	function change_event_radio2(){
		$("th#search1").show(); 
		ComSetDisplay("cust_cnt_cd",true);
		ComSetDisplay("cust_seq",true);
		ComSetDisplay("cust_nm",true);
		ComSetDisplay("btn_pop_cust_cd",true);
		ComSetDisplay("btn_pop_credit_cust",true);
		sheetObjects[0].RemoveAll();
	}


