﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0041.js
*@FileTitle  : Slip Inquiry Master
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0041 : ESM_FMS_0041 definition of biz script for creation screen
     */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
            switch(srcName) {
                case "btn_retrieve":
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				case "btn_new":
					formReset();
                    break;
				case "btn_Down_Excel":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}	
	                break;                
				case "btn_print":
					rdOpen(document.form);
					break;
				case "btn_save":
					alert(srcName);
                    break;
				case "btn_hire":
					if(sheetObject.RowCount()> 0){
						var csr_no=formObject.slp_no.value;
						var vsl_eng_nm=formObject.vsl_eng_name.value;
				 		//Print only in case of SLP_FUNC_CD = 'P' or 'T'
				 		/*if (   csr_no.substring(2,3) == 'P'  
				 			|| csr_no.substring(2,3) == 'T'
				 			|| csr_no.substring(2,3) == 'S') {
				 			ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0041&vsl_eng_nm="+vsl_eng_nm+"", 750, 153, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
				 		} else {
							ComShowCodeMessage("FMS01511");
							return;
				 		}*/
				 		ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0041&vsl_eng_nm="+vsl_eng_nm+"", 750, 153, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
					} else {
						ComShowCodeMessage('FMS00015');
					}
                    break;
				case "btn_tax":
					if(sheetObject.RowCount()> 0){
						var csr_no=form.slp_no.value;
						ComOpenPopup("ESM_FMS_0086.do?csr_no="+csr_no, 917, 540,"setTaxEvidence", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0086");
					} else {
						ComShowCodeMessage('FMS00019');
					}
                    break; 
				case "btn_slip":
					if(sheetObject.RowCount()> 0){
						var csr_no=formObject.slp_no.value;
						var vsl_cd=formObject.vsl_code.value;
						var vsl_eng_nm=formObject.vsl_eng_name.value;
						var csr_curr_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "csr_curr_cd");
						if(formObject.popup.value == 'yes') {
			 				//UI개선(201408 민정호)							
							ComOpenPopup("ESM_FMS_0042.do?csr_no="+ csr_no+"&vsl_cd="+vsl_cd+"&vsl_eng_nm="+vsl_eng_nm+"&csr_curr_cd="+csr_curr_cd, 1024, 530, "setSlipInquiry", "1,0", true, false, 0, 0, 0, "ESM_FMS_0042");
			 			} else {
			 				//UI개선(201408 민정호)
			 				ComOpenPopup("ESM_FMS_0042.do?csr_no="+ csr_no+"&vsl_cd="+vsl_cd+"&vsl_eng_nm="+vsl_eng_nm+"&csr_curr_cd="+csr_curr_cd, 1024, 530, "setSlipInquiry", "1,0", true, false, 0, 0, 0, "ESM_FMS_0042");
			 			}
					} else {
						ComShowCodeMessage('FMS00019');
					}
                    break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "from_ef_dt": 
					var cal=new ComCalendar();
					cal.select(form.from_eff_dt, 'yyyy-MM-dd');
					break;
	 			case "to_ef_dt": 
					var cal=new ComCalendar();
					cal.select(form.to_eff_dt, 'yyyy-MM-dd');
					break;
	 			case "from_cr_dt": 
					var cal=new ComCalendar();
					cal.select(form.from_cre_dt, 'yyyy-MM-dd');
					break;
	 			case "to_cr_dt": 
					var cal=new ComCalendar();
					cal.select(form.to_cre_dt, 'yyyy-MM-dd');
					break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true);
					break;
				case "btn_ap_cancel":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
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
    /**
     * registering IBSheet Object as list 
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * * adding first-served functions after loading screen. 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
        resizeSheet();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
//              (21, 0, 0, true);
              var HeadTitle1="|Seq|Approval|CSR No.|CSR Date|Produced By|Currency|CSR Amount|CSR Description|Request Team|Rqst Date|Ownr Code|Ownr Name|Evid Type|Deduction|Rqst Amt|Diff Desc|Cxl Flg|Cxl Desc|Vsl Code|Vsl Eng Name|AP/AR Status|AP Reject Description|Reject Flg||ownr_full_nm|ownr_tp_cd";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:00,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"csr_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"produced_by",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"request_team",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ownr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ownr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"evid_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"deduction",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rqst_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"diff_desc",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cxl_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rcv_err_rsn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rcv_err_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ownr_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ownr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
               
              InitColumns(cols);

              SetEditable(1);
              SetDataLinkMouse("Status",1);
              SetDataLinkMouse("Seq",1);
              SetDataLinkMouse("apro_flg",1);
              SetDataLinkMouse("csr_no",1);
              SetDataLinkMouse("csr_dt",1);
              SetDataLinkMouse("produced_by",1);
              SetDataLinkMouse("csr_curr_cd",1);
              SetDataLinkMouse("csr_amt",1);
              SetDataLinkMouse("csr_desc",1);
              SetSheetHeight(157);
              }
            break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
           		if(   formObj.csr_no.value != ""
           		   && formObj.csr_no.value.length < 3) {
           			formObj.csr_no.value="";
					ComAlertFocus(formObj.csr_no, ComGetMsg('FMS01331'));
					return;
           		}
           		if(!(   formObj.csr_no.value != ""
           		     && formObj.from_eff_dt.value == ""
           		     && formObj.to_eff_dt.value == ""
           		     && formObj.from_cre_dt.value == ""
           		     && formObj.to_cre_dt.value == "")) {
           			if(!validateForm(sheetObj,formObj,sAction))  return true;
           		}
	  			formObj.f_cmd.value=SEARCH;
 	  			sheetObj.DoSearch("ESM_FMS_0041GS.do", FormQueryString(formObj) );
                break;
			 case IBROWSEARCH:      
	 			if(gubun == "Vessel") {
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value="";
			    		return;
			    	}
			    	formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				document.body.focus();
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
				}
	 			break;
			 case IBSAVE:
				 if (!ComShowCodeConfirm("FMS20004")){ //Are you sure to reject it?
					return false;
				 }
				 
				 if(!validateForm(sheetObj,formObj,sAction))  return true;
				 formObj.f_cmd.value=MULTI;
				 var sXml=sheetObj.GetSaveData("ESM_FMS_0041GS.do", FormQueryString(formObj));
			     var saveFlag=ComFmsGetXMLData(sXml, "TR-ALL");
	 			 sheetObjects[0].LoadSaveData(sXml);
				 if (saveFlag == "OK") {
			  	    formObj.f_cmd.value=SEARCH;
	 		  		sheetObj.DoSearch("ESM_FMS_0041GS.do", FormQueryString(formObj) );
				 }	
				 
				 break;
        }
    }
    /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
    	//Axon Event Handling1. Event catch
        axon_event.addListener  ('change'  , 'vsl_cd_change'   , 'vsl_cd');		  	// Getting Name information after inserting Vessel Code
        axon_event.addListener  ('click'   , 'condition_click' , 'condition');		// Getting Name information after inserting Vessel Code
//        axon_event.addListener  ('keypress', 'eng_num_keypress', 'vsl_cd', 'csr_no');
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form Code Handling to OnBeforeDeactivate Event of All Controls having dataformat attribute
//        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); //- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        //setCsrDate();

        setInitDefaultDate('E');
    }

    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
        //Checking Input Validation
    	switch(event.srcElement.name){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
    	ComClearSeparator(event.srcElement);
    }
    /**
     * Getting relevant Name when Changing VslCd <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH,'Vessel');
    }
    
    //NYK Modify 2014.10.15
    function condition_click() {
    	if(form.condition[0].checked){
    		setInitDefaultDate(form.condition[0].value);
    	}else{
    		setInitDefaultDate(form.condition[1].value);
    	}
    	/*
    	if(form.condition[0].checked) {
    		setEffectiveDate(form.condition[0].value);
    	} else {
    		setCsrDate(form.condition[1].value);
    	}*/
    }
    //Axon Event Handling2. Event Handling Function --- end
    /**
	  * Insert Part of Vessel Code<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			// Getting Name information after inserting Vessel Code
		//form.vsl_cd.readOnly = true;
		//form.btn_vslpop.style.cursor = "default";
		//document.images["btn_vslpop"].name = "no_btn_vslpop";
	}	
	
	//NYK Modify 2014.10.15
	function setInitDefaultDate(val){
		var formObj = document.form;
		switch(val){
			case "E" :
				formObj.from_eff_dt.readOnly=false;
		    	formObj.to_eff_dt.readOnly=false;
		    	formObj.from_eff_dt.className="input1";
		    	formObj.to_eff_dt.className="input1";
				formObj.from_ef_dt.style.cursor="hand";
				formObj.to_ef_dt.style.cursor="hand";
				formObj.from_ef_dt.name="from_ef_dt";
				formObj.to_ef_dt.name="to_ef_dt";
				
				formObj.from_cre_dt.readOnly=true;
	        	formObj.to_cre_dt.readOnly=true;
	        	formObj.from_cre_dt.className="input2";
	        	formObj.to_cre_dt.className="input2";
	    		formObj.from_cr_dt.style.cursor="default";
	    		formObj.to_cr_dt.style.cursor="default";
	    		formObj.from_cr_dt.name="no_from_cr_dt";
	    		formObj.to_cr_dt.name="no_to_cr_dt";
	    		
	    		//(Sysdate - 한달) ~ (Sysdate + 한달)
	    		var varFrDt = ComGetDateAdd(null, "M", -1);
	    		var varToDt = ComGetDateAdd(null, "M", 1);
	    		
	    		formObj.from_eff_dt.value = ComGetMaskedValue(varFrDt,"ymd");
	    		formObj.to_eff_dt.value = ComGetMaskedValue(varToDt,"ymd");
	    		formObj.from_cre_dt.value = "";
	    		formObj.to_cre_dt.value = "";
	    		
				break;
			case "C" :
				formObj.from_eff_dt.readOnly=true;
		    	formObj.to_eff_dt.readOnly=true;
		    	formObj.from_eff_dt.className="input2";
		    	formObj.to_eff_dt.className="input2";
				formObj.from_ef_dt.style.cursor="default";
				formObj.to_ef_dt.style.cursor="default";
				formObj.from_ef_dt.name="no_from_ef_dt";
				formObj.to_ef_dt.name="no_to_ef_dt";
				
				formObj.from_cre_dt.readOnly=false;
		    	formObj.to_cre_dt.readOnly=false;
		    	formObj.from_cre_dt.className="input1";
		    	formObj.to_cre_dt.className="input1";
				formObj.from_cr_dt.style.cursor="hand";
				formObj.to_cr_dt.style.cursor="hand";
				formObj.from_cr_dt.name="from_cr_dt";
				formObj.to_cr_dt.name="to_cr_dt";
				
				//한달 전 ~ Sysdate
	    		var varFrDt = ComGetDateAdd(null, "M", -1);
	    		var varToDt = ComFmsCurrentDate();
	    		
	    		formObj.from_eff_dt.value = "";
	    		formObj.to_eff_dt.value = "";
	    		formObj.from_cre_dt.value = ComGetMaskedValue(varFrDt,"ymd");
	    		formObj.to_cre_dt.value = ComGetMaskedValue(varToDt,"ymd");
				
				break;
		}
		
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
    
    /**
     * Initializing screen <br>
     * @return none
     * @see #ComResetAll
     **/
 	function formReset() {
 	    ComResetAll();
 	    setInitDefaultDate('E');
 		form.vsl_cd.readOnly=false;
 		form.btn_vslpop.style.cursor="hand";
// 		document.images["btn_vslpop"].name="btn_vslpop";
 		form.btn_vslpop.name="btn_vslpop";
 		form.vsl_cd.value="";
 	}
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction      Action code(example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL - Define in CoObject.js)
     **/
    function validateForm(sheetObj,formObj,sAction){

    	if(sAction == IBSEARCH){
        	if(formObj.condition[0].checked) {
        		if(formObj.from_eff_dt.value == "") {
        			ComAlertFocus(formObj.from_eff_dt, ComGetMsg('FMS01430'));
        			return;
        		} else if(formObj.to_eff_dt.value == "") {
        			ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS01431'));
        			return;
        		} else {
        			if(parseInt(formObj.from_eff_dt.value.trimAll('-')) > parseInt(formObj.to_eff_dt.value.trimAll('-'))) {
        				ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS01432'));
            			return;
        			}
        		}
        	} else {
        		if(formObj.from_cre_dt.value == "") {
        			ComAlertFocus(formObj.from_cre_dt, ComGetMsg('FMS01433'));
        			return;
        		} else if(formObj.to_cre_dt.value == "") {
        			ComAlertFocus(formObj.to_cre_dt, ComGetMsg('FMS01434'));
        			return;
        		} else {
        			if(parseInt(formObj.from_cre_dt.value.trimAll('-')) > parseInt(formObj.to_cre_dt.value.trimAll('-'))) {
        				ComAlertFocus(formObj.to_cre_dt, ComGetMsg('FMS01435'));
            			return;
        			}
        		}
        	}
        	if(formObj.csr_no.value != "") {
        		if(formObj.csr_no.value.length < 3) {
        			ComAlertFocus(formObj.csr_no, ComGetMsg('FMS01437'));
        			return;
        		}
        		/*
    	    	if(ComGetMaskedValue(formObj,formObj.csr_no.value,'eng')) {
    	    	}
    	    	*/
        	}
    	}else if(sAction == IBSAVE){
    		if(formObj.slp_no.value == ""){
    			ComAlertFocus(formObj.csr_no, ComGetMsg('FMS20002'));
    			return;
    		}
    		
    		
    		if(formObj.csr_no.value != "") {
        		if(formObj.csr_no.value.length < 3) {
        			ComAlertFocus(formObj.csr_no, ComGetMsg('FMS01437'));
        			return;
        		}
        	}    		
    		//AP Cancel Y가 아니면 Reject 을 하면 안된다.
    		if(!formObj.rcv_err_flg[0].checked){
    			ComAlertFocus(formObj.csr_no, ComGetMsg('FMS20003'));
    			return;
    		}
    		
    		//Reject Y 일경우 Cancel 에 데이타를 넣어주어서 Cancel 처리 한다.
        	if (formObj.rcv_err_flg[0].checked) {
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "apro_flg","N",0);
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cxl_flg","Y",0);
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cxl_desc",formObj.rcv_err_rsn.value,0);        		
        		
        	}
        	
        	formObj.apro_flg.value = "N";
        	formObj.cxl_flg.value = "Y";
        	formObj.cxl_desc.value = formObj.rcv_err_rsn.value;        	
        	formObj.flet_ctrt_tp_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "flet_ctrt_tp_cd");
    		
    	}
        return true;
    }
    /**
     * Showing Click Information of each Grid on CSR Head Information <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @return none
     **/
    function setCsrHeadInfomation(sheetObj, row) {
    	//form.csr_no.value = sheetObj.GetCellValue(row,"csr_no");
    	form.request_team.value=sheetObj.GetCellValue(row,"request_team");
    	form.csr_dt.value=sheetObj.GetCellText(row,"csr_dt");
    	form.rqst_dt.value=sheetObj.GetCellText(row,"rqst_dt");
		form.produced_by.value=sheetObj.GetCellValue(row,"produced_by");
		form.csr_desc.value=sheetObj.GetCellValue(row,"csr_desc");
		form.ownr_cd.value=sheetObj.GetCellValue(row,"ownr_cd");
		form.ownr_nm.value=sheetObj.GetCellValue(row,"ownr_nm");
		form.csr_curr_cd.value=sheetObj.GetCellValue(row,"csr_curr_cd");
    	form.csr_amt.value=sheetObj.GetCellText(row,"csr_amt");
    	form.evid_tp.value=sheetObj.GetCellText(row,"evid_tp");
    	if(sheetObj.GetCellValue(row,"deduction") == "Y") {
    		form.deduction[0].checked=true;
    		form.deduction[1].checked=false;
    	} else {
    		form.deduction[0].checked=false;
    		form.deduction[1].checked=true;
    	}
    	form.rqst_amt.value=sheetObj.GetCellText(row,"rqst_amt");
    	form.diff_desc.value=sheetObj.GetCellText(row,"diff_desc");
    	if(sheetObj.GetCellValue(row,"cxl_flg") == "Y") {
    		form.cxl_flg[0].checked=true;
    		form.cxl_flg[1].checked=false;
    	} else {
    		form.cxl_flg[0].checked=false;
    		form.cxl_flg[1].checked=true;
    	}
		form.cxl_desc.value=sheetObj.GetCellValue(row,"cxl_desc");
		form.slp_no.value=sheetObj.GetCellValue(row,"csr_no");
		form.vsl_code.value=sheetObj.GetCellValue(row,"vsl_cd");
		form.vsl_eng_name.value=sheetObj.GetCellValue(row,"vsl_eng_nm");
		
		//NYK Modify 2014.11.11
		if(sheetObj.GetCellValue(row,"rcv_err_flg") == "Y") {
    		form.rcv_err_flg[0].checked=true;
    		form.rcv_err_flg[1].checked=false;
    		
		} else {
    		form.rcv_err_flg[0].checked=false;
    		form.rcv_err_flg[1].checked=true;
    	}
		form.rcv_err_rsn.value=sheetObj.GetCellValue(row,"rcv_err_rsn");
		
		if(sheetObj.GetCellValue(row,"ownr_tp_cd") == "C") {
			//Customer
			document.getElementById("owner_full_nm_txt").innerText = "Customer Name";
		}else{
			//Vendor
			document.getElementById("owner_full_nm_txt").innerText = "Vendor Name";
			
		}		
		form.ownr_full_nm.value=sheetObj.GetCellValue(row,"ownr_full_nm");
		
		initAPCancelButton();
    }
	/**
	 * Showing CSR Head Information corresponding to CSR No <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row of sheetObj
     * @param {ibsheet} col     	selected Col of sheetObj
     * @param {int}     cellX     	X coordinate value
     * @param {int} 	cellY     	Y coordinate value
     * @param {int}     cellW     	Cell Width
     * @param {int}     cellW     	Cell Height
     **/
	function sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
		 setCsrHeadInfomation(sheetObj, row);
	}
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount()> 0){
    		setCsrHeadInfomation(sheetObj, 1);
    	} else {
    		form.request_team.value="";
    		form.csr_dt.value="";
    		form.rqst_dt.value="";
    		form.produced_by.value="";
    		form.csr_desc.value="";
    		form.ownr_cd.value="";
    		form.ownr_nm.value="";
    		form.csr_curr_cd.value="";
    		form.csr_amt.value="";
    		form.evid_tp.value="";
    		form.deduction[0].checked=false;
    		form.deduction[1].checked=false;
    		form.rqst_amt.value="";
    		form.diff_desc.value="";
    		form.cxl_flg[0].checked=false;
    		form.cxl_flg[1].checked=false;
    		form.cxl_desc.value="";
    		form.slp_no.value="";
    		form.vsl_code.value="";
    		form.vsl_eng_name.value="";
    		//NYK Modify 2014.11.11
    		form.rcv_err_flg[0].checked=false;
    		form.rcv_err_flg[1].checked=false;
    		form.ownr_full_nm.value="";
    	}
    }

    /**
     * Printing RD <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     **/
    function rdOpen(formObject){
  		if(sheetObjects[0].RowCount()== 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		if(formObject.slp_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		var searchFlg="Y";
  		if(formObject.csr_no.value == "") {
  			searchFlg="N";
  			formObject.csr_no.value=formObject.slp_no.value;
  		}
  		if(formObject.slp_no.value.substring(0,2) == "07") {
  			formObject.csr_type.value="AP";
  		} else {
  			formObject.csr_type.value="AR";
  		}
  		
 		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();

 		if(searchFlg == "N") {
 			form.csr_no.value="";
 		}
 	}
    //NYK Modify 2014.11.11
    function initAPCancelButton(){
    	if(form.rcv_err_flg[0].checked){
    		ComBtnEnable("btn_ap_cancel");
    	}else{
    		ComBtnDisable("btn_ap_cancel");
    	}
    }

    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i], 290);
        }
    }    
    