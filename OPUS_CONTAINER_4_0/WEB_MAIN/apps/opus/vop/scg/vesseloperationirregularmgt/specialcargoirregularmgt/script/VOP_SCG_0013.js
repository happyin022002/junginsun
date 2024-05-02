/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0013.js
*@FileTitle  :  SPCL CGO Irregular Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefixs=new Array("sheet1_","sheet2_");  
    var uploadObjects=new Array();
	var uploadCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    //VVD CD related items
    var strVVDOptions="vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|vsl_slan_cd|vsl_slan_nm|vsl_opr_tp_cd|vsl_opr_tp_nm|set_vsl_cd|set_skd_voy_no|set_skd_dir_cd";
    //Option related items
    var strOptions="spcl_cgo_cate_cd|set_spcl_cgo_cate_cd|irr_subj_nm|spcl_cgo_irr_plc_cd|irr_plc_desc|spcl_cgo_irr_tp_cd|upd_usr_id|upd_dt|spcl_cgo_irr_seq";
    //BKG No. related items
    var strBKGOptions="bkg_no|bl_no|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|f_cust_nm|c_cust_nm|dcgo_flg|rc_flg|awk_cgo_flg|bb_cgo_flg|set_bkg_no|set_bl_no"; 
    //Remark related items
    var strRemarkOptions="irr_smry_rmk|irr_rsn_rmk|cmsr_desc|file_cnt";
    var gSource="";

    //////////////////////////////////////////////////////////////////////////////////////////////
//
// ▩Step-By-Step▩
//--------------------------------------------------------------------------------------------
//    
// 
// ►0. screen loading
//   .desc  : Option as basic, Dangerous Goods.
//   .step1 : Select Option and perform basic steps.
//   .step2 : file upload related Sheet, initialize Upload Component.  
//   .step3 : Place initial focus in VVD.
//   .goto  : [#0-0]
//  
//  
//  
// ►1. Setting using VVD Key In or popup
//   .desc  : Fill VVD, Lane, Vessel Operator.
//   .see   : Perform ►3.
//   .goto  : [#1-1][#1-2][#1-3]
//
//
//
// ►2. Setting using Irregular Occurred Key In or popup
//  .desc  : Fill Irregular Occurred Date.
//  .see   : Perform ►3.
//  .goto  : [#3-1]
//  
//  
//  
// ►3. Setting using Cargo Operator Key In or popup
//   .desc  : Change to input Key In in Booking information in case if other shipping company.
//   .step1 : change related Container information to delete status and set parameter in case changing Cargo Operator.
//   .step2 : Initialize Booking information.
//   .step3 : Change Container information(Sheet)'s CNTR No. TP/SZ column type to Combo/Text Box according to Cargo Operator type.
//   .event : Focus-Out, Pop-Up CallBack
//   .goto  : [#3-1][#3-2]
//  
//  
//  
// ►4. Selecting Option
//   .desc  : Container input item changes according to option.
//   .req   : Cargo Operator should be input.   
//   .step1 : change related Container information to delete status and set parameter in case changing option.
//   .step2 : Fill Irregulars Type Combo Box according to option.
//   .step3 : Select Sheet type and initialize.
//   .step4 : Initialize Booking information.
//   .step5 : Change Container information(Sheet)'s CNTR No. TP/SZ column type to Combo/Text Box according to Cargo Operator type.
//   .event : Select Radio
//   .goto  : [#4-1]
//  
//  
//  
// ►5. BKG No. or B/L No. Key In
//   .desc  : Set Booking and related information and fill Container Combo Box.
//   .step1 : Set Booking and related information.
//   .step2 : Fill Sheet's Container Combo Box.
//   .event : Key-In
//   .goto  : [#5-1][#5-2]
//  
//  
//  
// ►9. Retrieve
//   .desc  : Maintain existing status or change to modify status according to retrieve result.
//            retrieve participating item : (compulsory)VVD CD, Irregular Occurred, Cargo Operator (optional) BKG No.  --> according to this, retrieve by max value
//   .step1 : Check wheter retrieved Irregular Sequence exists or not. Below steps are handling retrieve success status.
//   .step2 : Initialize screen.
//   .step3 : Set retrieved Irregular general information.
//   .step4 : Set retrieved VVD general information.
//   .step5 : Select Option and perform basic steps.
//   .step6 : Set Irregular general information again.
//   .step7 : Set retrieved Booking general information.
//   .step8 : Fill Container information in Sheet.
//   .goto  : [#9-9]
// 
//--------------------------------------------------------------------------------------------    
//  ▩Modified▩
//--------------------------------------------------------------------------------------------     
// 1. Select Option, and retrieve Irregular (already registered) at the same time.    
// 2. Save BKG related information Key-In in case of other company.
// 3. Display Irregualr Type according to Option.    
//--------------------------------------------------------------------------------------------  
//    
//////////////////////////////////////////////////////////////////////////////////////////////    

    
    // business javascript OnKeyPress event Catch
    function initControl() {
        //axon event handling1. event catch
        //axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
    	//axon_event.addListenerFormat ('focus',    'obj_activate',   form);        
    	axon_event.addListenerForm   ("keyup",    'obj_keyup',      form);
    	//axon_event.addListenerForm   ("keydown",  'obj_keydown',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
    }
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // business javascript OnKeyPress 이벤트 처리
//    function obj_keypress() {
//    	switch(ComGetEvent().dataformat){
//    	    case "engup":
//    	    	switch(ComGetEvent().name){
//	    	    	case "vsl_cd":		    	        	
//	    	    		ComKeyOnlyAlphabet('uppernum');		//input English upper and number
//	    	        	break;
//	    	        case "skd_voy_no":		    	        	
//	        	    	ComKeyOnlyNumber(ComGetEvent());	//input number
//	    	        	break;
//	    	        case "skd_dir_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//	    	        case "vsl_opr_tp_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//	    	        case "cgo_opr_cd":	   	        	   	
//	    	        	ComKeyOnlyAlphabet('uppernum');		//input English upper	    	     
//	    	        	break;
//	    	        case "bkg_no":		    	        	
//	    	        	ComKeyOnlyAlphabet('uppernum');		//input English upper
//	    	        	break;
//	    	        case "bl_no":		    	        	
//	    	        	ComKeyOnlyAlphabet('uppernum');		//input English upper
//	    	        	break;
//	    	        case "por_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//	    	        case "pol_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//	    	        case "pod_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//	    	        case "del_cd":		    	        	
//	    	        	ComKeyOnlyAlphabet('upper');		//input English upper
//	    	        	break;
//    	    	}
//    	    	break;
//    	    default:    	    	
//    	    	ComKeyOnlyAlphabet("num");					//common standard : only English, number
//    	    	break;     
//    	}
//    } 
    
    // Handling business javascript OnFocus event
    function obj_activate() {
    	switch(ComGetEvent().name){ 
    		case "irr_occr_dt":
    			// deleting mask separator
    			ComClearSeparator (ComGetEvent());
    			setFocus("irr_occr_dt");
    			break;
    	}
    }
    
    // Handling business javascript OnKeyDown event
    var noeditBkgNo;
//    function obj_keydown() {
//    	if(!isOwnCarrier()) {
//    		with(ComGetEvent()) {
//		    	switch(name){ 
//		    		case "bkg_no":
//		    			noeditBkgNo=getObjValue(name);
//		    			break;
//		    	}
//    		}
//    	}
//    }
    
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(ComGetEvent());
    	//Perform Booking information Key In modify mode in case of other company
    	if(!isOwnCarrier()) {
    		var sheetObj=sheetObjects[0];
    		with(ComGetEvent()) {
    			if(sheetObj.GetSelectRow()!= -1 && sheetObj.RowCount()!= 0) {
			    	switch(name){ 
			    		case "bkg_no": case "bl_no": case "por_cd": case "pol_cd": case "pod_cd": case "del_cd": case "s_cust_nm": case "f_cust_nm": case "c_cust_nm":
			    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefixs[0]+name,getObjValue(name),0);
			    			if(name == "bkg_no") {
			    				if(sheetObj.GetSelectRow()!= sheetObj.LastRow()) {
				    				for(var dupIdx=sheetObj.GetSelectRow()+1; dupIdx<=sheetObj.LastRow(); dupIdx++) {
				    					if(noeditBkgNo == sheetObj.GetCellValue(dupIdx, prefixs[0]+name))
				    						sheetObj.SetCellValue(dupIdx, prefixs[0]+name,getObjValue(name),0);
				    					else 
				    						dupIdx=sheetObj.LastRow();
				    				}
			    				}
			    				if(sheetObj.GetSelectRow()!= sheetObj.HeaderRows()) {
				    				for(var dupIdx=sheetObj.GetSelectRow()-1; dupIdx>=sheetObj.HeaderRows(); dupIdx--) {
				    					if(noeditBkgNo == sheetObj.GetCellValue(dupIdx, prefixs[0]+name))
				    						sheetObj.SetCellValue(dupIdx, prefixs[0]+name,getObjValue(name),0);
				    					else 
				    						dupIdx=sheetObj.HeaderRows();
				    				}
			    				}
			    			}
			    			break;
			    	}
    			}
    		}
    	}
    }  
    
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    /*function obj_nextfocus(obj) {
    	var formObj=document.form;
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		if(obj.name != 'bkg_no' && obj.name != 'bl_no') {
    			ComSetNextFocus(obj);
    			if(obj.name == 'vsl_cd') {
    				formObj.skd_voy_no.select();
    			} else if(obj.name == 'skd_voy_no') {
    				formObj.skd_dir_cd.select();
    			} else if(obj.name == 'skd_dir_cd') formObj.irr_occr_dt.select();
    			else if(obj.name == 'vsl_opr_tp_cd') formObj.cgo_opr_cd.select();
    			else if(obj.name == 'irr_occr_dt') formObj.cgo_opr_cd.select();
    		} else {
    			obj.blur();
    		}
    	}
    }
	function obj_nextfocus(obj) {
		var formObj=document.form;
		var objMaxLength=obj.getAttribute("maxlength");
		var objValue=obj.getAttribute("value");
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else if(obj.name != 'crr_cd') ComSetNextFocus(obj);
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if(obj.name == 'skd_dir_cd') formObj.irr_occr_dt.select();
			else if(obj.name == 'vsl_opr_tp_cd') formObj.cgo_opr_cd.select();
			else if(obj.name == 'irr_occr_dt') formObj.cgo_opr_cd.select();
		}
	}*/
    
	function obj_nextfocus(obj) {
		var formObj=document.form;
		var objMaxLength=obj.getAttribute("maxlength");
		var objValue=obj.getAttribute("value");
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else if(obj.name != 'crr_cd') ComSetNextFocus(obj);
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}
    
	function obj_change() {
		var formObj=document.form;		
		with (ComGetEvent()) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					//initializing related item					
					//resetForCondition(formObj, "vvd");
					
		        	//[#3-1]Initialize according to Cargo Operator
		        	resetBKGCntrInfo(false, true, 'all');
		    		//combo Remove
		    		comboObjects[0].RemoveAll();					
					break;
		    	case "irr_occr_dt":
		    		// add mask separator
		    		var rslt=ComAddSeparator (ComGetEvent());
		        	// Check Validation in one control
		        	if(!rslt) {
		        		ComGetEvent().select();
		        	}
		        	if(rslt) {
			        	//[#3-1]Initialize according to Cargo Operator
			        	resetBKGCntrInfo(false, false, 'all'); 	
			        	//Set changed Irregular Occurred Date
		 				setObjValue("set_irr_occr_dt", getObjValue("irr_occr_dt"));
		 				//move focus
		 				setFocus("cgo_opr_cd");
		        	}
		        	break;
		    	case "cgo_opr_cd":
		        	//[#3-1]Initialize according to Cargo Operator
		        	resetBKGCntrInfo(false, true, 'all');
		    		//combo Remove
		    		comboObjects[0].RemoveAll();
		        	break;
		    	case "vsl_opr_tp_cd":
		        	//[#3-1]Initialize according to Cargo Operator
		        	resetBKGCntrInfo(true, true, 'all');
		    		//combo Remove
		    		comboObjects[0].RemoveAll();
		        	break;	
			}
		}
	}
    // Handling business javascript OnChange event
    /*function obj_change() {
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){ 
		    	case "vsl_cd":		
		    		setObjValue("skd_voy_no", "");
		    		setObjValue("skd_dir_cd", "");
		    		setObjValue("vsl_eng_nm", "");
		    		setObjValue("vsl_slan_cd", "");
		    		setObjValue("vsl_slan_nm", "");
		    		setObjValue("vsl_opr_tp_cd", "");
		    		setObjValue("vsl_opr_tp_nm", "");
		        	break;
		    	case "skd_voy_no":		
		    		setObjValue("skd_dir_cd", "");
	    			setObjValue("vsl_eng_nm", "");
	    			setObjValue("vsl_slan_cd", "");
	    			setObjValue("vsl_slan_nm", "");
	    			setObjValue("vsl_opr_tp_cd", "");
	    			setObjValue("vsl_opr_tp_nm", "");
		        	break;
		    	case "skd_dir_cd":	    			
		    		setObjValue("vsl_eng_nm", "");
		    		setObjValue("vsl_slan_cd", "");
		    		setObjValue("vsl_slan_nm", "");
		    		setObjValue("vsl_opr_tp_cd", "");
		    		setObjValue("vsl_opr_tp_nm", "");
		        	break;
		    	case "irr_occr_dt":
		    		// add mask separator
		    		var rslt=ComAddSeparator (ComGetEvent());
		        	// Check Validation in one control
		        	if(!rslt) {
		        		ComGetEvent().select();
		        	}
		        	if(rslt) {
			        	//[#3-1]Initialize according to Cargo Operator
			        	resetBKGCntrInfo(false, false, 'all'); 	
			        	//Set changed Irregular Occurred Date
		 				setObjValue("set_irr_occr_dt", getObjValue("irr_occr_dt"));
		 				//move focus
		 				setFocus("cgo_opr_cd");
		        	}
		        	break;
		    	case "cgo_opr_cd":
		        	//[#3-1]Initialize according to Cargo Operator
		        	resetBKGCntrInfo(false, true, 'all'); 	
		        	break;	 		        
	    	}
    	}
    }*/
    // Handling business javascript OnBlur event
    function obj_blur() {
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){ 
		    	case "skd_dir_cd":
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
			        	//[#1-1]retrieve VVD information
			        	searchVVDInfo();
		    		}
		    		//[#1-3]Initialize according to Cargo Operator
		        	resetBKGCntrInfo(false, false, 'all');
		        	break;
		    	case "irr_occr_dt":
		    		// add mask separator	
		    		var rslt=ComAddSeparator (ComGetEvent());
		        	// check validation in one control
		        	if(!rslt) {
		        		ComGetEvent().select();
		        	}
		        	if(rslt) {
			        	//[#3-1]Initialize according to Cargo Operator
			        	resetBKGCntrInfo(false, false, 'all'); 	
			        	//Set changed Irregular Occurred Date
		 				setObjValue("set_irr_occr_dt", getObjValue("irr_occr_dt"));
		 				//move focus
		 				setFocus("cgo_opr_cd");
		        	} else {
		        		setFocus("irr_occr_dt");
		        	}
		        	break;
		    	case "bkg_no":
		        	//[#5-1]retrieve Booking information
		        	searchBKGInfo(0);
		        	break; 
		        case "bl_no":
		        	//[#5-2]retrieve Booking information
		        	searchBKGInfo(2);
		        	break;
		        case "por_cd": case "pol_cd": case "pod_cd": case "del_cd":
		        	if(!isOwnCarrier()) {
			        	if(ComChkObjValid(ComGetEvent())) {
			        		searchPortCheck(ComGetEvent());		//Port Check
			        	}
		        	}
		        	break;
		    	case "vsl_opr_tp_cd":
		    		if (ComGetObjValue(formObj.vsl_opr_tp_cd) != "") searchCarrierInfo(ComGetObjValue(formObj.vsl_opr_tp_cd), 'VSL');	
		    		else ComSetObjValue(formObj.vsl_opr_tp_nm, "");
		        	break; 
	    	}
    	}
    }
    // Event handler processing by button name */
    function processButtonClick() {
        var sheetObj=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var eventObj=ComGetEvent();
    		var srcName=eventObj.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_RowAdd":
					if(isSetBkgNo()) return; 
					sheetObj.DataInsert(-1,0);						//create at last row[Sheet1]
					setBKGNoToGrid(sheetObj, "ADD");
					break;
				case "btn_RowInsert":
					if(isSetBkgNo()) return; 
					sheetObj.DataInsert();							//create below selected row[Sheet1]
					setBKGNoToGrid(sheetObj, "INSERT");
					break;
				case "btn_RowCopy":
					sheetObj.DataCopy();							//copy below selected row[Sheet1]
					if(sheetObj.RowCount()!= 0) setBKGNoToGrid(sheetObj, "COPY");
					break;
				case "btn_Delete":
					ComRowHideDelete(sheetObj, prefixs[0]+"del_chk");
					break;	
				case "btn_New":
					doActionIBSheet(sheetObj,formObj,IBCLEAR,'SELF');
					break;					
				case "btn_Delete2":
					doActionIBSheet(sheetObj,formObj,IBDELETE,'SELF');
					break;					
				case "btn_Save":
					doActionIBSheet(sheetObj,formObj,IBSAVE,'SELF');
					break;
				case "btn_VVDpop":
					//VVD select popup open					
					var vsl_cd=getObjValue("vsl_cd");
                	var sUrl="";
                	if(vsl_cd == ""){
                		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219"; 
                		ComOpenPopup(sUrl, 465, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                	}
					break;
				case "btn_calendar": 
					//open calendar to select date
					var cal=new ComCalendar();
		            cal.select(formObj.irr_occr_dt, "yyyy-MM-dd"); 
   	                break;	
				case "btn_vslopr":
					//open Cargo Operator select popup
					ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.vsl_opr_tp_cd), 600, 490, "setCallBackVP", '0,0,1,1,1', true);	
					break;				
				case "btn_carrier":
					//open Cargo Operator select popup
					ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 600, 490, "setCallBackCP", '0,0,1,1,1', true);	
					break;				
				case "spcl_cgo_cate_cd":
					//[#4-1]select Option
					setSelectedOption(eventObj.value);
					break;
/*				case "btn_file":
					//Open Supporting Documents or Pictures popup
					formObj.f_cmd.value="";
					ComOpenPopup('/opuscntr/VOP_SCG_2013_01.do?'+FormQueryString(formObj), 605, 290, "setFileUpload", 'none', true);	
					break;
*/				case "btn_FileAdd":
					sheetObjects[1].DataInsert();
					break;
				case "btn_FileDelete": //ibupload 파일삭제 로직
					sheetObj= sheetObjects[1];
					var row =sheetObj.GetSelectRow();
				    var sheet_serial = sheetObj.GetCellValue(row, prefixs[1]+"file_sav_id"); 
				    
				    //ibsheet에 이미 업로드된 파일이 있으면 해당 serial의 파일을 삭제한다.
				    if (sheet_serial!="") {
				    	ComUploadRemoveFile(upload1, sheet_serial, false);
				    }
				    
				    sheetObj.SetRowHidden(row,1);
			    	sheetObj.SetRowStatus(row,"D");

					break;
				case "btn_Close":
					ComClosePopup(); 
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
    /*****************************************************************************************
     * event handling end *
     ****************************************************************************************/  
    /*****************************************************************************************
     * Sheet event handling start *
     ****************************************************************************************/ 
    /**
     * Handling Sheet1 Combo Change Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col, Value ==> Grid Cell Value
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_un_no_seq" && !isOwnCarrier()) {
    		if(Value != "") {
    			searchUNNoInfo(sheetObj, Row, Col);
    		} else {
    			//Initialize Sheet Row	
     			initObjs("sheet", sheetObj, "imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", -1, Row);
    		}
      	} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_un_no" && !isOwnCarrier()) {
      		if(Value != "") {
      			checkUNNo(sheetObj, Row, Col);
      		} else {
    			//Initialize Sheet Row
     			initObjs("sheet", sheetObj, "imdg_un_no_seq|imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", -1, Row);
    		}
      	} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_clss_cd") {
      		var selVal=sheetObj.GetCellValue(Row, Col);
    		if (selVal == "1" || selVal == "1.1" || selVal == "1.2" || selVal == "1.3" || selVal == "1.4" || selVal == "1.5" || selVal == "1.6" ){
    			sheetObj.SetCellEditable(Row, prefixs[0]+"imdg_comp_grp_cd",1);
    			sheetObj.SetCellValue(Row, prefixs[0]+"imdg_comp_grp_cd","A",0);
    		} else {
    			sheetObj.SetCellEditable(Row, prefixs[0]+"imdg_comp_grp_cd",0);
    			sheetObj.SetCellValue(Row, prefixs[0]+"imdg_comp_grp_cd","",0);
    		}
    	}
	}
    /**
     * Handling Sheet1 Popup Click Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			var imdgUnNo=sheetObj.GetCellValue(Row, prefixs[0]+"imdg_un_no");
			var imdgUnNoSeq=sheetObj.GetCellValue(Row, prefixs[0]+"imdg_un_no_seq");
			var var_vsl_slan_cd=getObjValue("vsl_slan_cd"); 
			ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq+"&lane_cd="+var_vsl_slan_cd, 940, 420, "setCallBackUNNo", "0,0,1,1,1,1,1,1", true,false, Row, Col, 0);
 		}
 	}
    /**
     * Handling Sheet1 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting  Row, OldCol ==> before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * 
     */
    var preCntrNo;
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	if(sheetObj.ColSaveName(NewCol) == prefixs[0]+"cntr_no") {
    		//perform in case of Combo Box
    		var idx=sheetObj.GetComboInfo(NewRow, NewCol, "SelectedIndex");
    		if(idx != -1 && isOwnCarrier()) {
	    		//Set last Container value to rollback
    			preCntrNo=sheetObj.GetCellValue(NewRow, prefixs[0]+"cntr_no");
	    		setFilterCNTRCombo(sheetObj, NewRow, NewCol);
    		}
    	}
	}
    /**
     * Handling Sheet1 OnAfterEdit Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     * 
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[0]+"cell_psn_no") {
    		//Delete temporary value to Merge
    		var cellPsnNo=sheetObj.GetCellText(Row, prefixs[0]+"cell_psn_no");
    		if(cellPsnNo == "") {
    			var stanCntrNo=sheetObj.GetCellText(Row, prefixs[0]+"cntr_no");
    			var rowCntrNo;
    			for(var rowIdx=Row; rowIdx<=sheetObj.LastRow(); rowIdx++) {
    				rowCntrNo=sheetObj.GetCellText(rowIdx, prefixs[0]+"cntr_no");
    				if(stanCntrNo == rowCntrNo) sheetObj.SetCellValue(rowIdx, prefixs[0]+"cell_psn_no"," ");
    			}
    		}
    	} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"cntr_no") {
    		var Value=sheetObj.GetCellValue(Row, Col);
    		//Handling Container Combo select result
    		changeContCombo(sheetObj, Row, Col, Value);
    	}
    }
    /**
     * Handling Sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//sheetObj.RenderSheet(0);
    	//perform in case retrieved data exists
    	if(sheetObj.RowCount()!= 0) {
	    	var beforeBkgNo, bkgNo, cntrNo, colName;
	    	with (sheetObj) {    		
	    		for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
	    			//perform in case of Combo Box
//	        		var idx=sheetObj.GetComboInfo(checkRow, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"), "SelectedIndex");
	        		var idx=-1;
	        		bkgNo=GetCellValue(checkRow, prefixs[0]+"bkg_no");
	        		setObjValue("bkg_no", bkgNo); 
	        		if(idx == -1 && isOwnCarrier()) {		    			
	        			cntrNo=GetCellValue(checkRow, prefixs[0]+"cntr_no");
		    			//Retrieve Container Combo by BKG No. in form.
		    			//Preventing duplication
		    			if(checkRow == HeaderRows()|| bkgNo != beforeBkgNo) {
			    			setFocus("bkg_no");
			    			setObjValue("bl_no", ""); 	
			    			document.form.bkg_no.blur();
		    			}
		    			searchCNTRList(sheetObj, checkRow, document.form, true);
		    			SetCellValue(checkRow, prefixs[0]+"cntr_no",cntrNo);
		    			beforeBkgNo=bkgNo;
	        		} else if(!isOwnCarrier()) {
	    				for(var bkgIdx=SaveNameCol(prefixs[0]+"bl_no"); bkgIdx<=SaveNameCol(prefixs[0]+"c_cust_nm"); bkgIdx++) {
	    					colName=ColSaveName(bkgIdx);
	    					colName=colName.substring(7, colName.length);
	    					eval("document.form."+colName).value=GetCellValue(GetSelectRow(), bkgIdx);
	    				}
	    			}
	        		if(checkRow == LastRow()) {
	        			bkgNo=GetCellValue(HeaderRows(), prefixs[0]+"bkg_no");
		        		setObjValue("bkg_no", bkgNo); 
		        		if(idx == -1 && isOwnCarrier()) {
		        			setFocus("bkg_no");
			    			setObjValue("bl_no", ""); 	
			    			document.form.bkg_no.blur();
		        		} else if(!isOwnCarrier()) {
		        			for(var bkgIdx=SaveNameCol(prefixs[0]+"bl_no"); bkgIdx<=SaveNameCol(prefixs[0]+"c_cust_nm"); bkgIdx++) {
		    					colName=ColSaveName(bkgIdx);
		    					colName=colName.substring(7, colName.length);
		    					eval("document.form."+colName).value=GetCellValue(HeaderRows(), bkgIdx);
		    				}
		        		}
	        		}
	    		} 
	    	}
    	}
    	//sheetObj.RenderSheet(1);
    }
    /**
     * Handling Sheet1 Cell Click Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col, Value ==> Grid Cell Value
     * note  : Change to SelectCell <-- Because of event no occuring in Editable status
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
		with(sheetObj) { 
			//Setting BKG No.
			setObjValue("bkg_no", GetCellValue(Row, prefixs[0]+"bkg_no"));
			if(isOwnCarrier()) {
				if(ColSaveName(Col) == prefixs[0]+"bkg_no") {
					//retrieving BKG No.				 	
					setFocus("bkg_no");
					setObjValue("bl_no", "");
					document.form.bkg_no.blur();
				}			
			//change to modify mode in case of other company
			} else if(!isOwnCarrier()) {
				var colName="";
				for(var bkgIdx=SaveNameCol(prefixs[0]+"bl_no"); bkgIdx<=SaveNameCol(prefixs[0]+"c_cust_nm"); bkgIdx++) {
					colName=ColSaveName(bkgIdx);
					colName=colName.substring(7, colName.length);
					eval("document.form."+colName).value=GetCellValue(GetSelectRow(), bkgIdx);
				}
			}
//	    	if(GetCellEditable(Row, Col)) SelectCell(Row, Col);
 		}
 	}
    
    /**
     * Handling Sheet1 OnKeyUp Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
   /* function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
 		with(sheetObj) { 
 			var len=sheetObj.GetEditText().length;
 			if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_un_no") {
 				if(len == 4) {
 					sheetObj.SelectCell(Row, prefixs[0]+"imdg_un_no_seq");
 				}
 			} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_un_no_seq") {
 				if(len == 4) sheetObj.SelectCell(Row, prefixs[0]+"prp_shp_nm");
 			} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"bkg_no") {
 	    		if(!isOwnCarrier()) {
 	    			setObjValue("bkg_no", sheetObj.GetEditText());
 	    		}
 	    	}
  		}
    } */
    /**
     * Handling Sheet1 OnLoadFinish Event 
     * param : sheetObj ==> sheet object
     * 
     */
 //no support[check again]CLT 	function sheet1_OnLoadFinish(sheetObj) {
 	//}
    /*****************************************************************************************
     * Sheet event handling end *
     ****************************************************************************************/ 
    /*****************************************************************************************
     * screen initializing start *
     ****************************************************************************************/  
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * register IBUpload Object created in page as uploadObjects list. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++]=uploadObj;
	}
	/**
     * register IBCombo Object created in page as comboObjects list.
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(preCondition) {
    	//initializing Combo
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
        }
		//Check initial create&retrieve status
        if(preConds.vsl_cd == '') {
        	//[#0-0]initializing sheet
        	setSelectedOption('init');
 	        //set focus
 	        setFocus("vsl_cd");
        } else {
        	//initializing Sheet 
        	setSheet(sheetObjects[0], 1);
        }
    	//Upload initializing sheet
    	initUpload();
        //register event listener
        initControl();
        //Check initial retrieve
        if(preConds.vsl_cd != '') {
         	//initial condition setting
            setObjValue("vsl_cd",           preConds.vsl_cd);
            setObjValue("set_vsl_cd",       preConds.vsl_cd);
            setObjValue("skd_voy_no",       preConds.skd_voy_no);
            setObjValue("set_skd_voy_no",   preConds.skd_voy_no);
            setObjValue("skd_dir_cd",       preConds.skd_dir_cd);
            setObjValue("set_skd_dir_cd",   preConds.skd_dir_cd);
            setObjValue("spcl_cgo_irr_seq", preConds.spcl_cgo_irr_seq);
         	//retrieve
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"POP");
        }
        
        searchFileList(sheetObjects[1]);
        
        /*var formObj=document.form;
    	formObj.f_cmd.value=SEARCH;
    	sheetObjects[1].DoSearch("VOP_SCG_2013_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[1]) );*/
    }
    /**
     * Option 선택에 따른 초기화
     */
    function setSelectedOption(selVal) { 
    	var callType=selVal;
    	var vsl_slan_cd=getObjValue("vsl_slan_cd");
    	var irr_occr_dt=getObjValue("irr_occr_dt");
    	var cgo_opr_cd=getObjValue("cgo_opr_cd");
    	if(callType == 'init' || (vsl_slan_cd != '' && irr_occr_dt != '' && cgo_opr_cd != '')) {
	    	var sheetObj=sheetObjects[0];
	    	var formObj=document.form;
	    	//Select basic option as Dangerous Goods when loading screen.
	    	if(callType == 'init') selVal="DG";	 
	    	//perform after retrieving
	    	else if(callType == 'search') selVal=getObjValue("spcl_cgo_cate_cd"); 
	    	//Set select Option --> decide Sheet header type
	    	else {
	    		//Check change status
	    		if(getObjValue("spcl_cgo_cate_cd") == getObjValue("set_spcl_cgo_cate_cd")) return;
	    		//Change save status
	    		if(!validateForm(sheetObj,formObj,IBRESET)) return;
	    		setObjValue("set_spcl_cgo_cate_cd", selVal);
	    	}
	    	//0. Change related container information to delete status as parameter,in case of changing Option.
			setDelCNTRToForm(sheetObj, true);
	    	//1. Retrieve Irregulars Type according to option	
			if(callType != 'init') doActionIBCombo(sheetObj,formObj,IBSEARCH_ASYNC01);
	    	//2. Initialize after selecting Sheet type
	    	setSheet(sheetObj, selVal=='DG'?1:2);
	    	//3. Initialize according to change of Cargo Operator --> Sheet column type decision and fill
			resetBKGCntrInfo(true, false, '');	  
			//4. retrieve
			if(callType != 'init' && callType != 'search')
				doActionIBSheet(sheetObj,formObj,IBSEARCH,'SELF');
    	} else {
    		if(selVal == 'AC') selVal="DG";
    		else if(selVal == 'DG') selVal="AC";
    		var msgStr="";
    		var focusObj="";
    		if(vsl_slan_cd == '') {
    			msgStr="VVD CD";
    			focusObj="vsl_cd";
    		} else if(irr_occr_dt == '') {
    			msgStr="Irregular Occured Date";
    			focusObj="irr_occr_dt";
    		} else if(cgo_opr_cd == '') {
    			msgStr="Cargo Operator";
    			focusObj="cgo_opr_cd";
    		}
    		ComShowCodeMessage('SCG50007', msgStr);	//'Please input {?msg1}.'
    		//rollback in case before selecting initial status
    		if(getObjValue("set_spcl_cgo_cate_cd") == "") {
    			selVal="";
    			document.all.spcl_cgo_cate_cd[0].checked=false;
    			document.all.spcl_cgo_cate_cd[1].checked=false;
    		}
    		//rollback and input Cargo Operator
    		setObjValue("spcl_cgo_cate_cd", selVal);
    		setFocus(focusObj);    		
    	}
    	
    	searchFileList(sheetObjects[1]); 
    }
    /**
     * initializing sheet
     */
    function setSheet(sheetObj, sheetNo) { 
    	sheetObj = sheetObj.Reset();
    	if(sheetObj.id == "sheet1"){
    		sheetObjects[0] = sheetObj ;
    	} else if(sheetObj.id == "sheet2"){
    		sheetObjects[1] = sheetObj ;
    	}
    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj,sheetNo);    
//    	ComEndConfigSheet(sheetObj);
    }
    /**
     * initializing Combo
     * Setting Combo items
     */
    function initCombo(comboObj) {
	    switch(comboObj.options.id) {
	        case "spcl_cgo_irr_tp_cd":
	            with(comboObj) {
	            	SetTitle("Name|Code|Description");
	            	SetColWidth(0, "100");
	            	SetColWidth(1, "50");
	            	SetColWidth(2, "200");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	Index="";
	            }
	            break;	   
	    }
	}
    /**
     * Upload initializing sheet
     */
    function initUpload() { 
    	//initializing Hidden Sheet
    	setSheet(sheetObjects[1], 3);
        //setting for UPLOAD

    	upload1.Initialize({
			SaveUrl:'/opuscntr/VOP_SCG_0013GS.do',
			ShowButtonArea: true,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
			AfterSaveStatus : function(result) {
				var code = result.code;
				var formObj=document.form;
				ComUploadRemoveFile(upload1, "", true);
				if(document.upLoadForm){
					document.body.removeChild(document.upLoadForm);
				}
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			sXml = convert2ibsheet7(sXml);

	      			//ibupload-page별 변경 영역--s
	      			if (sXml.length > 0) sheetObjects[1].LoadSaveData(sXml);  
	        	   
					ComOpenWait(false);
					if(gSource == 'CLEAR') {
						initUI();
						setFocus("vsl_cd");
					} else {
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH,'POP');
						searchFileList(sheetObjects[1]);
					}
	      		}else {
					ComShowMessage(result.msg);
				}
			},
			BeforeSaveStatus : function(result) {
			   return true;
			},
			AfterAddFile : function(result) {
				var files = upload1.GetList();
			    var fileName=files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();
			    var sheetObj = sheetObjects[1];
			    var row = sheetObj.GetSelectRow();
			    			    
			    //ibupload-page별 변경 영역--s
			    //if (row==-1) row=sheetObj.DataInsert(-1);
			    var sheet_serial = sheetObj.GetCellValue(row, prefixs[1]+"file_sav_id"); 
			    //ibupload-page별 변경 영역--e
			    
			    //ibsheet에 이미 업로드된 파일이 있으면 해당 serial의 파일을 삭제한다.
			    if (sheet_serial!="") {
			    	ComUploadRemoveFile(upload1, sheet_serial, false);
			    }
                
			    //ibupload-page별 변경 영역--s
			    //(필수)
				sheetObj.SetCellValue(row, prefixs[1]+"serial_no",serialNo,0); //현재 full local url 은 지원되지않음.
				sheetObj.SetCellValue(row, prefixs[1]+"file_nm",fileName,0);
				
				//(선택)
				sheetObj.SetCellValue(row, prefixs[1]+"file_set_yn","Y",0);
				sheetObj.SetCellFontUnderline(row, prefixs[1]+"file_nm",1);
			    //ibupload-page별 변경 영역--e
			},
			BeforeAddFile : function(result){
				if(sheetObjects[1].GetSelectRow() == -1) return false;
				return true;
			},
			AfterOnload : function() {
				//ibupload-page별 변경 영역--s
		        //upload1.SetCustomAddButtonAsID('btn_file');
		        //ibupload-page별 변경 영역--e
			}
		});    	
    }
    
    //ibupload-page별 변경 영역--s
    function sheet2_OnMouseMove(sheetObj){
    	var row = sheetObj.MouseRow(),
        col = sheetObj.MouseCol(),
        col_nm = sheetObj.ColSaveName(col),
        info = null;
             
        if (row > 0 && col_nm == prefixs[1]+"file_nm") {
        	info = sheetObj.GetCellElement(row, col, 1);
        	upload1.SetFileUploadElement(info);
        } 
    }    
    //ibupload-page별 변경 영역--e

    function sheet2_OnDblClick(sheetObj, Row, Col, Value){
		with(sheetObj) { 
			if (Row <= 0 	|| sheetObj.ColSaveName(Col) != prefixs[1]+"file_nm") return;
	        if (Value == "" || sheetObj.GetRowStatus(Row) == "I") return;

	        parent.location.href = "/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefixs[1]+"file_sav_id");
	        return;
 		}
 	}
    
    //ibupload-page별 변경 영역--s
    function resetUpload(){
    	sheetObjects[1].RemoveAll();
    	ComUploadRemoveFile(upload1, "", true);
    }
    //ibupload-page별 변경 영역--e
    
    /**
     * Initialize full scrren value maintaining screen basic setting
     */
    function initUI() { 
    	//1. Initialize scrren
    	resetAllObjs();	 	
 	    //2. Upload initializing sheet
    	resetUpload();
    	/*//ibupload-initUpload함수는 초기화시 1회만 호출한다.
    	initUpload();
    	if(sheetObjects[1].GetTotalRows() > 0){
	    	//3. Initialize Sheet
	    	sheetObjects[1].RemoveAll();
    	}*/
    	//4. Initialize Combo
    	comboObjects[0].RemoveAll();
    	//set focus
        setFocus("vsl_cd");
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
//        sheetObj.SetWaitImageVisible(0);
        switch(sheetNo) {
            case 1:      // sheet1 init : Dangerous Goods
                with(sheetObj){
              
		             var HeadTitle1="Sel|BKG Ref. No.|CNTR No.|TP/SZ|Cell Position|Seq.|UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name|||||||||||";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ 
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_chk" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"ComboEdit", Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		                 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cell_psn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_comp_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefixs[0]+"prp_shp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_irr_cntr_seq" },
		                 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"ibflag" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_cate_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"bl_no" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"por_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pol_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pod_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"s_cust_nm" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"f_cust_nm" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"c_cust_nm" } ];
		              
		             InitColumns(cols);
		             InitComboNoMatchText(1,"",1);
		             
		             SetEditable(1);
		             SetEditableColorDiff(0);
		             SetWaitImageVisible(0);
		             SetShowButtonImage(2);
		             SetSheetHeight(340);
		             
            	}
               break;
            case 2:      // sheet2 init : Awkward Cargo
                with(sheetObj){
               
		             var HeadTitle1="Sel|BKG Ref. No.|CNTR No.|TP/SZ|AWK Type|Cell Position||Seq.|Weight(kg)|Weight(kg)|Dimension(cm)|Dimension(cm)|Dimension(cm)|Commodity||||||||||";
		             var HeadTitle2="Sel|BKG Ref. No.|CNTR No.|TP/SZ|AWK Type|Cell Position||Seq.|Gross|Net|L|W|H|Commodity||||||||||";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                       { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ 
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"del_chk" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		                 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"spcl_cgo_cate_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cell_psn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"seq",                   KeyField:0,   CalcLogic:prefixs[0]+"cgo_seq" },
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_grs_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_net_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_len",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_wdt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"dim_hgt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefixs[0]+"cmdt_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		                 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"spcl_cgo_irr_cntr_seq" },
		                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"ibflag" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"bl_no" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"por_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pol_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"pod_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_cd" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"s_cust_nm" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"f_cust_nm" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"c_cust_nm" } ];
		              
		             InitColumns(cols);
		             InitComboNoMatchText(1,"",1);
		             
		             SetEditable(1);
		             SetEditableColorDiff(0);
		             SetWaitImageVisible(0);
		             SetColProperty(prefixs[0]+"spcl_cgo_cate_cd", {ComboText:"|AK|RF|BB", ComboCode:"|AK|RF|BB"} );
		             SetSheetHeight(340);
             }
               break;
            case 3:      // sheet3 init
                with(sheetObj){
		              var HeadTitle="|Seq.|||File Name||User ID|Date";
		
		              SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		            //ibupload- prefixs[1]+"file_nm" 을 PopupEdit로 변경
		              var cols = [	{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"ibflag" },
		                          	{Type:"Seq",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"No" },
				                    {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"spcl_cgo_irr_file_seq" },
				                    {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"file_set_yn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                    {Type:"PopupEdit", Hidden:0,  Width:545,  Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"file_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                    {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"file_sav_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                    {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                    {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"serial_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		              
		              InitColumns(cols);
		              SetDataLinkMouse(prefixs[1]+"file_nm", true);
		              SetShowButtonImage(2);
		              //SetVisible(false);
		              SetSheetHeight(200);
                    }
			   break;
        }
    }
    /*****************************************************************************************
     * screen initializing end *
     ****************************************************************************************/ 
    /*****************************************************************************************
     * initializing start *
     ****************************************************************************************/ 
    /**
     * initialize according to Cargo Operator : Booking info Key In in case of other company
     */
    function resetBKGCntrInfo(forceYn, keyInYn, allYn) {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	var set_cgo_opr_cd=getObjValue("set_cgo_opr_cd");   
    	var cgo_opr_cd=getObjValue("cgo_opr_cd");    
    	var set_vvd_cd=getObjValue("set_vsl_cd")+getObjValue("set_skd_voy_no")+getObjValue("set_skd_dir_cd");    
    	var vvd_cd=getObjValue("vsl_cd")+getObjValue("skd_voy_no")+getObjValue("skd_dir_cd");   
    	var set_irr_occr_dt=ComReplaceStr(getObjValue("set_irr_occr_dt"),"-","");   
    	var irr_occr_dt=ComReplaceStr(getObjValue("irr_occr_dt"),"-","");    
    	//perform in case of change
    	if(forceYn || set_cgo_opr_cd != cgo_opr_cd || set_vvd_cd != vvd_cd || set_irr_occr_dt != irr_occr_dt) {
    		//0. Change related container information to delete status as parameter,in case of changing Cargo Operator.
			setDelCNTRToForm(sheetObj, true);
	    	//1. initialize all info
    		var expObjs="spcl_cgo_cate_cd|set_spcl_cgo_cate_cd";
    		if(allYn == 'all') expObjs="";
			resetExCondObj(sheetObj, expObjs);
	    	//2. initialize Container info <-- initialize Sheet Grid
			if(sheetObj.GetTotalRows() > 0){
				sheetObj.RemoveAll();
			}
			//3. Container info Key In OR select type decision <-- Column type change
			setSheetColProp(sheetObj, formObj); 
			//4. Cargo Operator item setting
			if(keyInYn && cgo_opr_cd != '') searchCarrierInfo(cgo_opr_cd, 'CGO');
			//5. changed Cargo Operator code setting
			setObjValue("set_cgo_opr_cd", cgo_opr_cd);
			//6.   		
			setRequiredForm();
    	}
    }  
    /**
     * selected Object initialize and move focus
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs=nameVars.split("|");
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		if(type == 'sheet') sheetObj.SetCellValue(etcVal, prefixs[0]+nameArrs[objIdx],"",0);
    		else {
    			if(eval("document.form."+nameArrs[objIdx]).type == 'hidden') {
    				setObjValue(nameArrs[objIdx],"");
    			} else {
    				ComClearObject(eval("document.form."+nameArrs[objIdx]));
    			}
    		}
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, prefixs[0]+nameArrs[objIdx]);
    			else {
    				setFocus(nameArrs[objIdx]);
    			}
    		}
    	}
    }
    /**
     * selected Cell initialize and move focus
     */
    function initCell(sheetObj, Row, Col) {
    	sheetObj.SetCellValue(Row,Col,"",0);
		sheetObj.SelectCell(Row,Col);
    }
    /**
     * initialize all object value in document
     */
    function resetAllObjs() {
    	ComResetAll();
    }  
    /**
     * initialize screen after retrieving
     */
    function resetExCondObj(sheetObj, expStrs){
    	//1. initialize form
    	resetObjs(strOptions+"|"+strBKGOptions+"|"+strRemarkOptions, expStrs);
    	//2. Upload initializing sheet
    	//ibupload-initUpload함수는 초기화시 1회만 호출한다.
    	//initUpload();
    	resetUpload();
    	//3. delete parameter form
    	setDelCNTRToForm(sheetObj, false);
    	return true;
    }
    /**
     * initialize all object value in document
     */
    function resetObjs(strs, expStrs) {
    	try {
            var objs=strs.split("|");
            var expObjs=expStrs.split("|");
            var obj;
            var expYn;
            for(var i=0; i<objs.length; i++) {
            	expYn=true;            	
            	for(var j=0; j<expStrs.length; j++) {
            		if(objs[i] == expObjs[j]) expYn=false;
            	}
            	obj=eval("document.all."+objs[i]);
            	if(expYn) {
	            	if(obj.classid==undefined){
		            	switch( obj.type ) {
			                case "select-one" :
			                	obj.selectedIndex='1';
			                	break;		                
			                case "text" :
			                	if(obj.name == 'file_cnt') 
			                		obj.value="0";
			                	else if(obj.name == 'irr_subj_nm') 
			                		obj.value="["+getObjValue("vsl_slan_cd")+"] "+getObjValue("vsl_cd")+getObjValue("skd_voy_no")+getObjValue("skd_dir_cd")+" - ";
			                	//else if(obj.name == 'upd_usr_id') 
			                		//obj.value=userId;
			                	//else if(obj.name == 'upd_dt')
			                		//obj.value=curDate;
			                	else obj.value="";
			                    break;
			                case "textarea" :
			                	obj.value="";
			                    break;
			                case "hidden" :
			                	obj.value="";
			                    break;
			                default:
			                	if(obj[0].type == 'radio') {		                
				                	obj[0].checked=false;
				                	obj[1].checked=false;
			                	}
			                    break;
			            }
	            	} else {
	                    if(obj.classid==CLSID_IBMCOMBO) {
	                        obj.SetSelectIndex(-1);;
	                    }
	                }
            	}
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    } 
    /*****************************************************************************************
     * initializing end *
     ****************************************************************************************/ 
    /*****************************************************************************************
     * Handling Call Back in popup start *
     ****************************************************************************************/  
    /**
  	 * Setting data from VSL Code Help (Pop-Up).<br>
  	 * @param {arry} rtnObjs
  	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value=rtnDatas[1];
					clearAllFormData(formObj, "S");
					//move focus
					setFocus("skd_voy_no");
				}
			}
    	}
    }
    
	/**
	 * Setting data from VSL Code Help (Pop-Up)<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj=document.form;
		if (rtnObjs) {
			var rtnDatas=rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
					// changing focus
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}
	/**
	 * Setting data from VVD Code Help (Pop-Up).<br>
	 */
	function setCallBackVVD(obj) {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		if (obj) {
			var rtnDatas=obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					//Get VVD Info 
					searchVVDInfo();
				}
			}
		}
	} 
  	/**
  	 * Vessel Operator Code Inquiry.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function setCallBackVP(aryPopupData) {
  		setObjValue("vsl_opr_tp_cd", aryPopupData[0][3]);
  		setObjValue("vsl_opr_tp_nm", aryPopupData[0][4]);
  		//[#3-2]Initialize according to Cargo Operator
  		resetBKGCntrInfo(false, false, 'all');
  	} 
  	/**
  	 * Carrier Code Inquiry.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function setCallBackCP(aryPopupData) {
  		setObjValue("cgo_opr_cd", aryPopupData[0][3]);
  		setObjValue("cgo_opr_nm", aryPopupData[0][4]);
  		//[#3-2]Initialize according to Cargo Operator
  		resetBKGCntrInfo(false, false, 'all');
  	} 
  	/**
	 * Handling Sheet1 OnPopupClick ImdgUnNoSeq event - CallBack function
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
     * Call Back handling in popup end *
     ****************************************************************************************/  
  	/*****************************************************************************************
     * Setter/Getter start *
     ****************************************************************************************/ 
  	/**
     * VVD info related item setting : VVD, Lane, Vessel Operator
     */
    function setVVDInfo(formObj, sXml) { 	 
    	var vvdData=ComScgXml2Array(sXml, strVVDOptions);
    	var isChecked=false;
    	for (var i=0; i<formObj.spcl_cgo_cate_cd.length; i++){
    		if(formObj.spcl_cgo_cate_cd[i].checked){
    			isChecked=true;
    		}
    	} 
 	   	if(vvdData == null) {
 	   		ComShowCodeMessage("SCG50051", getObjValue("vsl_cd"));	//Vessel Code [{?msg1}] is invalid.
 		    //ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 0) {
 	   			var arrHeads=strVVDOptions.split("|");
 	   			for(var headIdx=3; headIdx<arrHeads.length; headIdx++) {
 	   				if (isChecked){
 	   					if (headIdx != "6" && headIdx != "7") {
 	 	   					setObjValue(arrHeads[headIdx], vvdData[0][headIdx]);
 	   					}
 	   				}else{
 	   					setObjValue(arrHeads[headIdx], vvdData[0][headIdx]);
 	   				}
 	   			}
 	   			//changed VVD code setting
 				setObjValue("set_vsl_cd", 	  getObjValue("vsl_cd"));
 				setObjValue("set_skd_voy_no", getObjValue("skd_voy_no"));
 				setObjValue("set_skd_dir_cd", getObjValue("skd_dir_cd"));
// 				ComSetObjValue(formObj.vsl_eng_nm,  vvdData[1][0]);
// 				ComSetObjValue(formObj.vsl_slan_cd, vvdData[1][1]);
// 				ComSetObjValue(formObj.vsl_slan_nm, vvdData[1][2]);
 				//move focus
 				setFocus("irr_occr_dt"); 	   			
 	   		} else {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		}
 	   	}
 	   	//Subject Prefix
		var subjectStr="["+getObjValue("vsl_slan_cd")+"] "+getObjValue("vsl_cd")+getObjValue("skd_voy_no")+getObjValue("skd_dir_cd")+" - ";	
		setObjValue("irr_subj_nm", subjectStr);
 	   	//initializing retrieved Key value
 	   	setObjValue("spcl_cgo_irr_seq", "");
    }
    /**
     * Cargo Operator item setting : Cargo Operator
     */
    function setCarrierInfo(formObj, sXml, cgoOprCd, type) {
    	var carrierData=ComScgXml2Array(sXml, "crr_cd|crr_nm");
 	   	if(carrierData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
   			if (type=='VSL') {
   				initObjs("form", formObj, "vsl_opr_tp_cd|vsl_opr_tp_nm", 0, "");
   			}else{
   				initObjs("form", formObj, "cgo_opr_cd|cgo_opr_nm", 0, "");   				
   			}
 	   	} else {
   			if (type=='VSL') {
   				setObjValue("vsl_opr_tp_nm", carrierData[0][1]); 	   				
   			}else{
   				setObjValue("cgo_opr_nm", carrierData[0][1]);
   			}
// 	   		if(carrierData.length > 1) {		>carrierData 는 배열을 리턴받는것이지 여러개의 배열을 리턴받는것이 아니다
// 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
// 	   		} else {
// 	   			if (type=='VSL') {
// 	   				setObjValue("vsl_opr_tp_nm", carrierData[0][1]); 	   				
// 	   			}else{
// 	   				setObjValue("cgo_opr_nm", carrierData[0][1]);
// 	   			}
// 	   		}
 	   	}
    }
    /**
     * Booking info related item setting : BKG No., B/L No., POR, POL, POD, Delivery, SHPR, FWDR, CNEE, dcgo_flg, rc_flg, awk_cgo_flg, bb_cgo_flg
     */
    function setBKGInfo(sheetObj, formObj, sXml, focusIdx) {    
    	var bkgData=ComScgXml2Array(sXml, strBKGOptions);
    	var set_bkg_no="", set_bl_no="", rslt=true;
 	   	if(bkgData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    rslt=false;
 	   	} else {
 	   		//Check Waiting(W), Cancelled(X) 
   			var bkgStsCd=ComScgXml2Array(sXml, "bkg_sts_cd")[0][0]; 	//ComScgXml2Array(sXml, "bkg_sts_cd")[0][0]
   			if(bkgStsCd == 'X') {
   				ComShowCodeMessage("SCG50017", bkgData[0][0]);	//'BKG No. {?msg1} was cancelled.'
   				rslt=false;
   			} else {
	   			if(bkgStsCd == 'W') ComShowCodeMessage("SCG50021", bkgData[0][0]);	//'BKG No. {?msg1} is on waiting status.'
 	   			var arrHeads=strBKGOptions.split("|");
 	   			for(var headIdx=0; headIdx<arrHeads.length; headIdx++) { 
 	   				setObjValue(arrHeads[headIdx], bkgData[0][headIdx]);
 	   			}
 	   			set_bkg_no=bkgData[0][0];
 	   			set_bl_no=bkgData[0][1];
	   		}
 	   	}
 	   	//initialize in case of fail
 	   	if(!rslt) initObjs("form", formObj, strBKGOptions, focusIdx, "");
 	   	//value setting
 	   	setObjValue("set_bkg_no",set_bkg_no);
		setObjValue("set_bl_no", set_bl_no);
    }
    /**
     * Sheet Column
     */
    function setSheetColProp(sheetObj, formObj) {
    	//Column change(2x2)
    	with (sheetObj) {
    		var selIdx=getObjValue("set_spcl_cgo_cate_cd");
    		//delete data
//    		RemoveAll();
    		var cols;
    		if(isOwnCarrier()) {
    			 if(selIdx == 'AC') {
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"bkg_no"),{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),{Type:"ComboEdit", Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"spcl_cgo_cate_cd"),{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"spcl_cgo_cate_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cgo_seq"),{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"awk_cgo_grs_wgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_grs_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"awk_cgo_net_wgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_net_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_len"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_len",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_wdt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_wdt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_hgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"dim_hgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cmdt_desc"),{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefixs[0]+"cmdt_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 });
    			 } else if(selIdx == 'DG'){
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"bkg_no"),{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),{Type:"ComboEdit", Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cgo_seq"),{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no"),{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"),{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_comp_grp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				 SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"prp_shp_nm"),{Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefixs[0]+"prp_shp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 });

    			} 
    			SetColProperty(prefixs[0]+"cntr_no", {ComboText:"||", ComboCode:"||"} );
    		}else {
    			if(selIdx == 'AC') {
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"bkg_no"),{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),{Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),{Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"spcl_cgo_cate_cd"),{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"spcl_cgo_cate_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cgo_seq"),{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"awk_cgo_grs_wgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_grs_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"awk_cgo_net_wgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"awk_cgo_net_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_len"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_len",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_wdt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefixs[0]+"dim_wdt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"dim_hgt"),{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"dim_hgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
    				SetColProperty(0,sheetObj.SaveNameCol(prefixs[0]+"cmdt_desc"),{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefixs[0]+"cmdt_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 });

    			} else if(selIdx == 'DG'){
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"bkg_no"),{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),{Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),{Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cgo_seq"),{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"cgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no"),{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),{Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_un_no_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"),{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_comp_grp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    				SetColProperty(0, sheetObj.SaveNameCol(prefixs[0]+"prp_shp_nm"),{Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefixs[0]+"prp_shp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 });

    				searchClsList(formObj);
    				searchClsCompGrpList(formObj);
				}
    	   		searchTPSZList(formObj);
    		}
    	}
    }
    /**
     * Handling result after selecting Container Combo
     */
    function changeContCombo(sheetObj, Row, Col, Value) {
 		Value=sheetObj.GetCellText(Row,prefixs[0]+"cntr_no");
 		var firstRow=getFindRow(sheetObj, Col, Value, "ASC");
		if(Row != firstRow) Row=firstRow;
    	//perform in case of Combo Box
		var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var sText=sheetObj.GetComboInfo(Row, Col, "Text");
		if(idx != -1 && isOwnCarrier()) {
			if(idx != 0 || (idx == 0 && ComTrim(Value) != '')) {
				var isRow=colDupCheck(sheetObj, ["cntr_no"], [Value], [Row]);
				if((idx == 0 && ComTrim(Value) != '') || preCntrNo == Value) isRow=-1;
				if(isRow == -1) {
		    		setObjValue("set_cntr_no", Value);
		    		searchCNTRInfo(sheetObj, Row, Col, Value);
				} else {						
					sheetObj.SetCellValue(Row, Col,preCntrNo,0);
					ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'  	
				}
			} else {
				sheetObj.SetCellValue(Row, Col,preCntrNo,0);
			}			
		}
    }
    /**
     * Setting Container Combo list
     */
    var contCombo="| | | | | | | | | |";
    function setCNTRCombo(sXml, sheetObj, Row) {
    	var arrCombo=ComXml2ComboString(sXml, prefixs[0]+"cntr_no", prefixs[0]+"cntr_no");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var newCombos=arrCombo[0].split("|");
    		var oldCombos=contCombo.split("|");
    		var isVal=true;
    		var bkgNo=sheetObj.GetCellValue(Row, prefixs[0]+"bkg_no");
    		var joinVal;
    		for(var newCt=0; newCt<newCombos.length; newCt++) {
    			isVal=true;
    			joinVal=bkgNo +":"+ newCombos[newCt];
    			for(var oldCt=0; oldCt<oldCombos.length; oldCt++) {
        			if(joinVal == oldCombos[oldCt]) isVal=false;
        		}
    			if(isVal && joinVal != '') contCombo += joinVal + "|";
    		}
    		sheetObj.SetColProperty(prefixs[0]+"cntr_no", {ComboText:contCombo, ComboCode:contCombo} );
    		sheetObj.CellComboItem(Row,prefixs[0]+"cntr_no", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
    	}
    }
    /**
     * Filtering Container Combo List.
     */
    function setFilterCNTRCombo(sheetObj, Row, Col) {
    	if(contCombo != null) {
    		var cCombos=contCombo.split("|");
			var cCombo=new Array();
			var selVal=sheetObj.GetCellValue(Row, Col);
			var curBkgNo=sheetObj.GetCellValue(Row, prefixs[0]+"bkg_no");
			var joinVal, joinBkgNo, joinCntrNo;
			var isVal=true, cIdx=0;
			for(var comIdx1=0; comIdx1<cCombos.length; comIdx1++) {
				joinVal=cCombos[comIdx1].split(":");
				if(joinVal.length > 1) {
					joinBkgNo=joinVal[0];
					joinCntrNo=joinVal[1];
				} else {
					joinBkgNo="";
					joinCntrNo="";
				}
	    		if(ComTrim(selVal) != '') {
	    			if(curBkgNo == joinBkgNo && selVal == joinCntrNo) cCombo[comIdx1]=joinCntrNo;
	    		} else {
	    			isVal=true;
	    			for(var rowIdx=sheetObj.HeaderRows(); rowIdx<sheetObj.LastRow(); rowIdx++) {
	    				if(sheetObj.GetRowStatus(rowIdx) != 'D' && sheetObj.GetCellValue(rowIdx, Col) == joinCntrNo) isVal=false;
	    			}
	    			if(isVal && joinBkgNo == curBkgNo) cCombo[cIdx++]=joinCntrNo;
	    		}
			}
//			sheetObj.CellComboItem(Row,Col, {ComboText:"|"+cCombo.join("|")+"||"+cCombo.join("|"), ComboCode:0} );
			var strCombo = cCombo.join("|").replace(/\|{2,}/gi, "|");
//			sheetObj.CellComboItem(Row,Col, {ComboText:strCombo, ComboCode:0} );
			sheetObj.CellComboItem(Row,Col, {ComboText:strCombo, ComboCode:strCombo} );
		}
    }
    /**
     * Set TP/SZ Combo list
     */
    function setTPSZCombo(sXml) {    	
    	var arrCombo=ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObjects[0].SetColProperty(prefixs[0]+"cntr_tpsz_cd", {ComboText:"||"+arrCombo[0], ComboCode:"||"+arrCombo[1]} );
    }
    /**
     * Set Class Combo list
     */
    function setClsCombo(sXml) {    	
//    	var arrCombo=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
    	var arrCombo=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var comboCds=arrCombo[0].split("|");
    		var comboTxts=arrCombo[1].split("|");
    		var comboTxtStrs="";
    		for(var colIdx=0; colIdx<comboCds.length; colIdx++) {
    			comboTxtStrs += "|"+comboCds[colIdx]+"\t"+comboTxts[colIdx];
    		}
//    	//	sheetObjects[0].SetColProperty(prefixs[0]+"imdg_clss_cd", {ComboText:"|"+comboTxtStrs ,"||"+arrCombo[0], ComboCode:"",""} );
//    		sheetObjects[0].SetColProperty(prefixs[0]+"imdg_clss_cd", {ComboText:"|"+comboTxtStrs +"||"+arrCombo[0], ComboCode:""} );
    		
//    		sheetObjects[0].SetColProperty(prefixs[0]+"imdg_clss_cd", {ComboText:"||"+arrCombo[0], ComboCode:"||"+arrCombo[1]} );
    		sheetObjects[0].SetColProperty(prefixs[0]+"imdg_clss_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
    	}
    }
    /**
     * Set Class Comp Group Combo list
     */
    function setClsCompGrpCombo(sXml) {    	
    	var arrCombo=ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
    	if(arrCombo != null && arrCombo.length > 0) 
    		sheetObjects[0].SetColProperty(prefixs[0]+"imdg_comp_grp_cd", {ComboText:"||"+arrCombo[0], ComboCode:"||"+arrCombo[1]} );
    }
    /**
     * Set UN No. related info 
     */
    function setUNNoInfo(seetIdx, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm) {
    	sheetObjects[seetIdx].SetCellValue(Row, prefixs[0]+"imdg_un_no",imdg_un_no,0);//UN No.
		sheetObjects[seetIdx].SetCellValue(Row, prefixs[0]+"imdg_un_no_seq",imdg_un_no_seq,0);//Seq.
		sheetObjects[seetIdx].SetCellValue(Row, prefixs[0]+"imdg_clss_cd",imdg_clss_cd,0);//Class
		sheetObjects[seetIdx].SetCellValue(Row, prefixs[0]+"imdg_comp_grp_cd",imdg_comp_grp_cd,0);//Class Comp Group
		sheetObjects[seetIdx].SetCellValue(Row, prefixs[0]+"prp_shp_nm",prp_shp_nm,0);//Proper Shipping Name
    }
    /**
     * Set Container info related item : 
     * 1. Dangerous Goods : TP/SZ, UN No/Seq, Class, Proper Shipping Name	
     * 2. Awkward Cargo : TP/SZ, AWK_Type, Gross, Net, L, W, H, Commodity
     */
    function setCNTRInfo(sheetObj, Row, Col, sXml, Value) {
    	var sArr=ComScgXml2Array(sXml, prefixs[0]+"cntr_no");
		if(sArr == null) {
			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			//Initializing Sheet Row 
			var nameVars="", nameVar="";
			for(var paramIdx=1; paramIdx<=sheetObj.SaveNameCol(prefixs[0]+"prp_shp_nm"); paramIdx++) {
				nameVar=sheetObj.ColSaveName(paramIdx);
				if(nameVar != prefixs[0]+"spcl_cgo_cate_cd") {
					nameVars += nameVar.substring(7,nameVar.length);
					nameVars += "|";
				}
			}
			if (nameVars != "") nameVars=nameVars.substr(0, nameVars.length -1);
			initObjs("sheet", sheetObj, nameVars, -1, Row);
		} else {			
			var cntrNoCol=sheetObj.SaveNameCol(prefixs[0]+"cntr_no");
			var cntrNo="", cgoSeq="", dupRowIdx=-1, colValue="", colName="", rowState="";
			for(var rsltRowIdx=0; rsltRowIdx<sArr.length; rsltRowIdx++) {		
				for(var skipIdx=0; skipIdx<sArr.length; skipIdx++) {
					rowState=sheetObj.GetRowStatus(Row);
					if(rowState == 'D') Row++;
				}
				cntrNo=ComScgXml2Array(sXml,prefixs[0]+"cntr_no")[rsltRowIdx];
				cgoSeq=ComScgXml2Array(sXml,prefixs[0]+"cgo_seq")[rsltRowIdx];
				dupRowIdx=colDupCheck(sheetObj, ["cntr_no","cgo_seq"], [cntrNo,cgoSeq], [-1]);
//				if(rsltRowIdx != 0 && dupRowIdx == -1) {					
//					sheetObj.SelectCell(Row-1,0);
//					sheetObj.DataCopy();
//					sheetObj.SetRowHidden(Row,0);
//					sheetObj.SetCellValue(Row, prefixs[0]+"spcl_cgo_irr_cntr_seq","",0);
//				}
				var selIdx=getObjValue("set_spcl_cgo_cate_cd");
				var lastCol=0;
				if(selIdx == 'DG') {
					lastCol=sheetObj.SaveNameCol(prefixs[0]+"prp_shp_nm");
				} else if(selIdx == 'AC') {
					lastCol=sheetObj.SaveNameCol(prefixs[0]+"cmdt_desc");
				}
				for(var paramIdx=sheetObj.SaveNameCol(prefixs[0]+"bkg_no"); paramIdx<=lastCol; paramIdx++) {
					colName=sheetObj.ColSaveName(paramIdx);
					if(colName != prefixs[0]+"spcl_cgo_irr_cntr_seq" && colName != prefixs[0]+"spcl_cgo_cate_cd") {
						colValue=ComScgXml2Array(sXml,colName)[rsltRowIdx];
						sheetObj.SetCellValue(Row, paramIdx,colValue,0);
						sheetObj.SetCellText(Row, paramIdx ,colValue);
					}
				}
				if(sheetObj.GetCellValue(Row, sheetObj.SaveNameCol(prefixs[0]+"cell_psn_no")) == "") {
					sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs[0]+"cell_psn_no")," ",0);
				}
				Row++;
			}
		}
	}
	/**
     * Change related container information to delete status as parameter,in case of changing Option.
     */
    function setDelCNTRToForm(sheetObj, option) {  
    	var paramObj=document.getElementById('cntrDelParam');
    	if(option) {
    		if(paramObj == null && sheetObj.RowCount()> 0) {
		    	var formObj=document.form;
		    	//var dyParamDiv=document.createElement("<div id='cntrDelParam' name='cntrDelParam' style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;'></div>");
		    	var dyParamDiv = document.createElement("DIV");
		    	dyParamDiv.setAttribute('id', 'cntrDelParam');
		    	dyParamDiv.setAttribute('name', 'cntrDelParam');
		    	dyParamDiv.setAttribute('style', 'position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;');
		    	document.body.appendChild(dyParamDiv);
		    	
		    	var ibFlag, valParam1, valParam2;
		    	for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
		    		ibFlag=sheetObj.GetCellValue(rowIdx, prefixs[0]+"ibflag");
		    		if(ibFlag != 'I') {
//			    		valParam1=document.createElement("<input type='hidden' name='sheet1_ibflag' value='D'>");
//			    		valParam2=document.createElement("<input type='hidden' name='sheet1_spcl_cgo_irr_cntr_seq' value='"+sheetObj.GetCellValue(rowIdx, prefixs[0]+"spcl_cgo_irr_cntr_seq")+"'>");
		    			valParam1 = document.createElement("INPUT");
			    		var val1  = 'D';
			    		valParam1.setAttribute('type', 'hidden');
			    		valParam1.setAttribute('name', 'sheet1_ibflag');
			    		valParam1.setAttribute('value', val1);
			    		
		    			valParam2 = document.createElement("INPUT");
			    		var val2  = sheetObj.GetCellValue(rowIdx, prefixs[0]+"spcl_cgo_irr_cntr_seq");
			    		valParam2.setAttribute('type', 'hidden');
			    		valParam2.setAttribute('name', 'sheet1_spcl_cgo_irr_cntr_seq');
			    		valParam2.setAttribute('value', val2);
			    		
			    		dyParamDiv.appendChild(valParam1);
			    		dyParamDiv.appendChild(valParam2);   
		    		}
		    	}
		    	formObj.appendChild(dyParamDiv);
    		}
    	} else {
//    		if(paramObj != null) paramObj.removeNode(true);
    		if(paramObj != null){
    			if(sheetObjects[0].RowCount() > 0){
    				//sheetObj.RemoveAll();
//        			if (typeof sheet1_ibflag != undefined || typeof sheet1_ibflag != "undefined") {
//        				paramObj.removeChild(sheet1_ibflag.parentNode);  
//        			}
    			}
    		}
    	}
    }
    /**
     * create specific object as parameter in document
     */
    function FormParamString(form, type) {
        var name=new Array(form.elements.length);
        var value=new Array(form.elements.length);
        var j=0;
        var plain_text="";
        //create list
        var len=form.elements.length;
        var objType;
        for (var i=0; i < len; i++) {
        	objType=form.elements[i].type;
        	if(type == objType) {
        		switch (form.elements[i].type) {
        			case "hidden":
        				name[j]=form.elements[i].name;
        				name[j]=ComReplaceStr(name[j],"set_","");
                        value[j]=form.elements[i].value;
                        j++;
                        break;
        		}
            }
        }
        /*
        // QueryString & URL Encoding
        var webBrowserName=navigator.appName;
        var webBrowserVer=navigator.appVersion()().substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                            navigator.appVersion().indexOf("MSIE") + 8)
        if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
            for (i=0; i < j; i++) {
                if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
            }
        }
        */
        if(plain_text == "") {
            for (i=0; i < j; i++) {
                if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
            }
        if (plain_text != "") plain_text=plain_text.substr(0, plain_text.length -1);
        }
        return plain_text;
    }
    /**
     * Set EtcData value in Form.
     */
    function setXmlEtcDataToForm(formObj, sXml) {
    	var iMatchCnt=0;
    	try {
    		var elements=formObj.elements;
    		// create list 
    		for ( var i=0; i < elements.length; i++) {
    			var sValue, eNmPrefix, eName;
    			if (elements[i].classid == undefined) {
    				eName=elements[i].name; 
    			} else {
    				eName=elements[i].id; 
    			}
    			
    			if (eName == "" || eName == "vsl_slan_cd" || eName == "vsl_slan_nm" || eName == "bkg_no" || eName == "bl_no")
    				continue;
    			eNmPrefix=eName.substring(0,4);
    			if(eNmPrefix == 'set_') eName=eName.substring(4,eName.length);
    			sValue=ComGetEtcData(sXml, eName);
    			if (sValue == undefined)
    				continue;
    			if (elements[i].type == "radio") {
    				var eRadio=document.all[eName];
    				if (eRadio.length > 1)
    					i += (eRadio.length - 1);
    				if (sValue != undefined) {
    					ComSetObjValue(eRadio, sValue);
    					iMatchCnt++;
    				}
    				continue;
    			}
    			
    			ComSetObjValue(elements[i], sValue);
    			
    			//콤보 셋팅 
    			if (elements[i].getAttribute("ibcb-delegate") == "true"){
		           	if(elements[i].id == 'spcl_cgo_irr_tp_cd'){
		           		eval(elements[i].id).SetSelectCode(sValue, false);
		        	}
    			}
    			
    			iMatchCnt++;
    		}// for
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return iMatchCnt;
    }
    /**
     * Cargo Operator's OWN Company code 
     */
    function isOwnCarrier() {
    	var value=getObjValue("cgo_opr_cd");
    	if(value == '' || value == ConstantMgr.getCompanyCode())
    		return true;
    	return false;
    }
    /**
     * Setting bkg_no to grid of sheet
     */
    function setBKGNoToGrid(sheetObj, callType) {
    	//perform in case of Combo Box
		var idx=sheetObj.GetComboInfo(sheetObj.GetSelectRow(), sheetObj.SaveNameCol(prefixs[0]+"cntr_no"), "SelectedIndex");
		if(idx != -1 && isOwnCarrier()) {
			//BKG No. setting
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefixs[0]+"bkg_no",getObjValue("bkg_no"));
			//Container Info retrieve condition setting
			var dcgo_flg=getObjValue("dcgo_flg");
			var awk_cgo_flg=getObjValue("awk_cgo_flg");
			var rc_flg=getObjValue("rc_flg");
			var bb_cgo_flg=getObjValue("bb_cgo_flg");
			var cgo_type="";
			if(dcgo_flg == 'Y') cgo_type="DG";
			else if(awk_cgo_flg == 'Y') cgo_type="AK";
			else if(rc_flg == 'Y') cgo_type="RF";
			else if(bb_cgo_flg == 'Y') cgo_type="BB";
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefixs[0]+"spcl_cgo_cate_cd",cgo_type);
	    	//Container Combo list retrieve
	   		searchCNTRList(sheetObj, sheetObj.GetSelectRow(), document.form, false);
		} else if(!isOwnCarrier()) {
			if(callType != "COPY") initObjs("form", document.form, "bkg_no|bl_no|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|f_cust_nm|c_cust_nm", 0, "");
		}
    }
    /**
     * If Cargo Operator is OWN Company code, show BKG No., B/L No. as compulsory item and change input digit
     */
    function setRequiredForm() {
    	var itemObj;
    	var arrForms=strBKGOptions.split("|");
		for(var itemIdx=0; itemIdx<9; itemIdx++) {
			itemObj=document.getElementsByName(arrForms[itemIdx])[0];
			if(isOwnCarrier()) {
				if(itemIdx < 2) {
					itemObj.className="input";
					if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 13);
					else if(itemObj.name == 'bl_no') itemObj.setAttribute("maxLength", 12);
					itemObj.readOnly=false;
				} else {
					itemObj.className="input2";
					itemObj.readOnly=true;
					itemObj.removeAttribute("fullfill");
					itemObj.removeAttribute("maxLength");
				}
			} else {
				itemObj.className="input";
				itemObj.readOnly=false;
				if(itemIdx < 2) {
					if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 30);
					else if(itemObj.name == 'bl_no') itemObj.setAttribute("maxLength", 30);
					itemObj.removeAttribute("fullfill");
				} else if(itemIdx < 6) {
					itemObj.setAttribute("maxLength", 5);
					itemObj.setAttribute("fullfill", "true");
				} else {
					if(itemIdx == 7) itemObj.setAttribute("maxLength", 200);	//FWDR
					else itemObj.setAttribute("maxLength", 500);				//SHPR, CNEE
				}
			}
		}
		//deactivate Row Copy Button
		if(isOwnCarrier()) {
			ComBtnDisable("btn_RowCopy");
			ComBtnDisable("•btn_RowCopy");
		}else ComBtnEnable("btn_RowCopy");
    }
    /**
	 * Add files selected to upload IBSheet popup by IBUpload.
	 **/
	function setFileUpload(aryPopupData) {
		var sheetObj=sheetObjects[1];
		var uploadObj=uploadObjects[0];
		uploadObj.Files="";
		if(sheetObj.GetTotalRows() > 0){
			sheetObj.RemoveAll();
		}
		var file_cnt=0;
		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
			var fileSetYn=aryPopupData[rowIdx][2];
			var ibFlag=aryPopupData[rowIdx][0];
			if(fileSetYn == 'Y') {
				var sFile=aryPopupData[rowIdx][3];
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				var ret=uploadObj.AddFile(sFile);
			}
			if(ibFlag != 'D') file_cnt++;
			sheetObj.DataInsert(-1,0);
			for (var colIdx=0; colIdx<=sheetObj.LastCol(); colIdx++){
				sheetObj.SetCellValue(rowIdx+1, colIdx,aryPopupData[rowIdx][colIdx],0);
			}
		}
		setObjValue("file_cnt", file_cnt);
		return; 
	}
	/**
	 * Retrieve Hidden IBSheet info for upload
	 **/
	function getFileUpload() {
		return sheetObjects[1]; 
	}
	/**
     * screen after retrieving
     */
    function setAfterSearch(sXml, sheetObj, formObj, source) {
    	//조회성공|실패 결정 인자
    	var spcl_cgo_irr_seq = ComGetEtcData(sXml,"spcl_cgo_irr_seq");
    	
    	if(spcl_cgo_irr_seq != '' && spcl_cgo_irr_seq != 'null') {
    		//0. [Option을 선택해서 조회한 경우에만 해당]이미 등록된 정보를 수정할지의 여부를 판단한다.
    		var confirmYn = false;
    		if(source == 'SELF') {
    			//'The same irregular type exists aleady on VVD CD/Irregular Occurred/Cargo Operator. Do you want to update the irregular?'
    			//if(!ComShowCodeConfirm('SCG40013')) confirmYn = true;	//삭제  <-- 확인 메시지 없이 Display
    		}
    		
	    	//1. 화면을 초기화 한다.
    		resetAllObjs();	 	   
    		//ibupload-initUpload는 1회만 호출한다.
	    	//initUpload();	//Upload Sheet 기본 설정 및 초기화
        	resetUpload();
	    	
	    	if(confirmYn) {
	    		//포커스 셋팅
	            setFocus("vsl_cd");
	    		return;
	    	}
	    	
	 	   	//2. 조회한 Irregular 일반정보를 셋팅한다.
	 	   	setXmlEtcDataToForm(formObj, sXml);
	 	   	//3. VVD 일반정보를 조회하여 셋팅한다.
	 	   	searchVVDInfo();
	 	   	//4. Option을 선택한후 수행되는 Step을 기본적으로 수행한다.
	 	    setSelectedOption('search');
	 	    //5. 다시 조회한 Irregular 일반정보를 셋팅한다.
	 	    setXmlEtcDataToForm(formObj, sXml);
	 	    //6. Booking 일반정보를 조회하여 셋팅한다.
	 	    searchBKGInfo(-1);
	 	    //7. Container 정보를 Sheet에 채운다. 
//     	   if(getTotal(sXml) > 0){
//    		   sheetObj.LoadSaveData(sXml);
//    	   }
//	 	    if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
     	   if(sXml.length>0){
     		  if(sheetObj.id == "sheet1"){
  				sheet1.LoadSearchData(sXml,{Sync:0} );
  			}else if(sheetObj.id == "sheet2"){
  				sheet2.LoadSearchData(sXml,{Sync:0} );
  			}
     		//   sheetObj.LoadSearchData(sXml,{Sync:0} );
     	   }
    	} else {
    		//조회 결과 메시지 보이기
      	   if(sXml.length>0){
      		  if(sheetObj.id == "sheet1"){
   				sheet1.LoadSearchData(sXml,{Sync:0} );
   			}else if(sheetObj.id == "sheet2"){
   				sheet2.LoadSearchData(sXml,{Sync:0} );
   			}
      		//   sheetObj.LoadSearchData(sXml,{Sync:0} );
      	   }
    		
    		//조회조건을 제외한 화면 초기화
    		resetExCondObj(sheetObj, "spcl_cgo_cate_cd|set_spcl_cgo_cate_cd");
    	}
    }	
    
    function getTotal(sXml){
        if ( sXml == null  || sXml == "" ) return;
        try {
        	var xmlDoc = ComGetXmlDoc(sXml);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
            if(dataNode == null) return "";
            return dataNode.getAttribute("TOTAL");
        } catch(err) { ComFuncErrMsg(err.message); }
    } 
    
    
//    function setAfterSearch(sXml, sheetObj, formObj, source) {
//    	var spcl_cgo_irr_seq=ComGetEtcData(sXml,"spcl_cgo_irr_seq");
//    	if(spcl_cgo_irr_seq != '' && spcl_cgo_irr_seq != 'null') {
//    		var confirmYn=false;
//    		if(source == 'SELF') {
//    		}
//    		resetAllObjs();	 	   
//	    	initUpload();	//Upload initializing sheet
//	    	if(confirmYn) {
//	            setFocus("vsl_cd");
//	    		return;
//	    	}
//	 	   	setXmlEtcDataToForm(formObj, sXml);
//	 	   	searchVVDInfo();
//	 	    setSelectedOption('search');
//	 	    setXmlEtcDataToForm(formObj, sXml);
//	 	    searchBKGInfo(-1);
//	 	    if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
//    	} else {
//    		if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
//    		resetExCondObj(sheetObj, "spcl_cgo_cate_cd|set_spcl_cgo_cate_cd");
//    	}
//    }
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
    	eval("document.form."+name).select();
    }
    /**
     * Get row of same data in column
     */
    function getFindRow(sheetObj, col, value, sort) {
    	if(sort == 'DESC') {
	     	for(var findIdx=sheetObj.LastRow(); findIdx>=sheetObj.HeaderRows(); findIdx--) {
	     		if(sheetObj.GetCellText(findIdx, col) == value && sheetObj.GetRowStatus(findIdx) != "D") return findIdx;
	     	}
    	} else {
    		//return sheetObj.FindText(col, value);
    		for(var findIdx=sheetObj.HeaderRows(); findIdx<=sheetObj.LastRow(); findIdx++) {
    			if(sheetObj.GetCellText(findIdx, col) == value && sheetObj.GetRowStatus(findIdx) != "D") return findIdx;
	     	}
    	}
    }
  	/*****************************************************************************************
     * Setter/Getter end *
     ****************************************************************************************/ 
    /*****************************************************************************************
     * Transaction start *
     ****************************************************************************************/ 
    // Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction, source) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //retrieve  
           	   if(source != 'POP') {
	        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
	        	   setObjValue("spcl_cgo_irr_seq", "");
           	   }
               formObj.f_cmd.value=SEARCH;
        	   var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[0]);
         	   var sXml=sheetObj.GetSearchData("VOP_SCG_0013GS.do", sParam);
        	   setAfterSearch(sXml, sheetObj, formObj, source); 
               break;
               
           case IBSAVE:        //save
           	   if(!validateForm(sheetObj,formObj,sAction)) return false;
			   var sParam="";
			   sParam += ComGetSaveString(sheetObj, false, true, -1);
			   if(sParam == "") {
				   if(sheetObj.RowCount()== 0) ComShowCodeMessage('SCG50007','Special Cargo');   //'Please input {?msg1}.'
				   return; 
			   }
	   		   if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'		   
        	   formObj.f_cmd.value=MULTI;
        	   var uploadObj=upload1; //ibupload-uploadObjects[0]는 인식하지 못함	
        	   var sXml="";			
        	   if (uploadObj.GetList().length == 0) {
        		   ComOpenWait(true);
        		   sParam += "&" + ComGetSaveString(sheetObjects[1], false);
        		   sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixs);
        		   sXml=sheetObj.GetSaveData("VOP_SCG_0013GS.do", sParam);
        		   ComOpenWait(true);
        		   doActionIBSheet(sheetObjects[0],formObj,IBSEARCH,'POP');
				   searchFileList(sheetObjects[1]);
        		   ComOpenWait(false);
        	   } else {
        		   //ibupload-ComGetSaveString 대신 ComGetFileSaveString 사용하기
        		   //sParam += "&" + ComGetSaveString(sheetObjects[1], true);
        		   sParam += "&" + ComGetFileSaveString(sheetObjects[1], upload1, prefixs[1]+"serial_no");
        		   sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixs);
        		   
        		   ComOpenWait(true);
        		   paramToForm(sParam);
        		   upload1.SaveStatus();
        	   }
        	   
        	   //ibupload-upload1.SaveStatus()코드 아래쪽은 initUpload()함수의 AfterSaveStatus()함수로 옮긴다. 
        	   //비동기로 모두 실행될수 있으므로 그 아래 코드는 반드시 남겨둠과 함께 복사하여 옮긴다.
        	   /*if (uploadObj.GetList().length == 0) {
	        	   if(getTotal(sXml) > 0){
	        		   sheetObj.LoadSaveData(sXml);
	        	   }
	        	   
	        	   ComOpenWait(false);
	        	   if(source == 'CLEAR') {
	        		   initUI();
	        	       setFocus("vsl_cd");
	        	   } else {
		        	   doActionIBSheet(sheetObj,formObj,IBSEARCH,'RESEARCH');
	        	   }
        	   }*/
        	   
               break;
           case IBDELETE:        //delete
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
        	   formObj.f_cmd.value=REMOVE;
    		   sheetObj.DoAllSave("VOP_SCG_0013GS.do", FormQueryString(formObj));
    		   initUI();
               break;  
           case IBCLEAR:      
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
    		   initUI();
    	       setFocus("vsl_cd");
               break;
        }
    	setDelCNTRToForm(sheetObj, false);
    }
    // IBCombo related process handling
    function doActionIBCombo(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	//Irregulars Type Combo Box Item retrieve
        	case IBSEARCH_ASYNC01:
        		formObj.f_cmd.value=SEARCH04;        	   
        		var set_spcl_cgo_cate_cd=getObjValue("set_spcl_cgo_cate_cd");
        		var sParam=FormQueryString(formObj);
        		if(set_spcl_cgo_cate_cd == 'DG') 
        			sParam += "&dg_flg=Y";
        		else 
        			sParam += "&awk_flg=Y";
        		sheetObj.SetWaitImageVisible(0);
         		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", sParam);
        		sheetObj.SetWaitImageVisible(1);
        		ComXml2ComboItem(sXml, spcl_cgo_irr_tp_cd, "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_nm|spcl_cgo_irr_tp_cd|spcl_cgo_irr_tp_desc");
        		spcl_cgo_irr_tp_cd.SetSelectIndex(-1);
        		break;
        }
    }
  	/**
     * retrieve VVD information
     */
    function searchVVDInfo() {
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH05;
    	sheetObjects[0].SetWaitImageVisible(0);
  	   	var sXml=sheetObjects[0].GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		//var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		/*var vvdData=ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
		if (vvdData == null) {
			ComShowCodeMessage("OPF50004", 'Data');
			//initializing related item
			resetForCondition(formObj, "vvd");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			//chage focus
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.vsl_slan_cd, vvdData[0][1]);
			ComSetObjValue(formObj.vsl_slan_nm, vvdData[0][2]);
//			//Get POL 
//			formObj.f_cmd.value=SEARCH01;
//			//evincive Creation parameter 
// 			var formParams="";
//     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
//     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
//     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
//     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd);     		
     		
		}*/
		setVVDInfo(formObj, sXml);
 	    sheetObjects[0].SetWaitImageVisible(1);
 	    //setVVDInfo(formObj, sXml);
    } 
    /**
     * Cargo Operator info retrieve
     */
    function searchCarrierInfo(cgoOprCd, type) {
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH01;
    	sheetObjects[0].SetWaitImageVisible(0);
  	   	var sXml=sheetObjects[0].GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)+"&crr_cd="+cgoOprCd);
 	    sheetObjects[0].SetWaitImageVisible(1);
 	   	//Cargo Operator 항목 셋팅
 	    setCarrierInfo(formObj, sXml, cgoOprCd, type);
    }
    /**
     * retrieve Booking information
     */
    function searchBKGInfo(focusIdx) {
    	if(isOwnCarrier()) {
    		var sheetObj=sheetObjects[0];
	    	var formObj=document.form;
	    	if(getObjValue("bkg_no") == "" && getObjValue("bl_no") == "") return; 
    		if(!ComChkObjValid(formObj.vsl_cd) || !ComChkObjValid(formObj.skd_voy_no) || !ComChkObjValid(formObj.skd_dir_cd)) {
    			setObjValue("set_bl_no","");
	    		setObjValue("bl_no","");
	    		setObjValue("set_bkg_no","");
	    		setObjValue("bkg_no","");
	    		return;
    		}
	    	if(focusIdx == 0) {
	    		setObjValue("bl_no","");
	    		if(getObjValue("bkg_no") == "") initObjs("form", formObj, strBKGOptions, -1, "");
	    	} else if(focusIdx == 2) {
	    		setObjValue("bkg_no","");
	    		if(getObjValue("bl_no") == "") initObjs("form", formObj, strBKGOptions, -1, "");
	    	}
	    	if(getObjValue("bkg_no") == "" && getObjValue("bl_no") == "") return;
	    	formObj.f_cmd.value=SEARCH01;
	    	sheetObj.SetWaitImageVisible(0);
 	 	   	var sXml=sheetObj.GetSearchData("VOP_SCG_0013GS.do", FormQueryString(formObj));
	 	    sheetObj.SetWaitImageVisible(1);
	 	    setBKGInfo(sheetObj, formObj, sXml, focusIdx);
    	}
    }
    /**
     * Container Combo list retrieve
     */
    var contComboXml;
    function searchCNTRList(sheetObj, Row, formObj, copyYn) {  
    	var reSearchYn=true;
    	if(copyYn) {
    		if(Row != sheetObj.HeaderRows()) {
    			var preBkgNo=sheetObj.GetCellValue(Row-1, prefixs[0]+"bkg_no");
    			var curBkgNo=sheetObj.GetCellValue(Row, prefixs[0]+"bkg_no");
    			if(preBkgNo == curBkgNo) reSearchYn=false;
    		}
    	}
    	if(reSearchYn) {
	    	formObj.f_cmd.value=SEARCH02;
	    	sheetObj.SetWaitImageVisible(0);
 	    	contComboXml=sheetObj.GetSearchData("VOP_SCG_0013GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefixs[0]));
	    	sheetObj.SetWaitImageVisible(1);
    	}
		setCNTRCombo(contComboXml, sheetObj, Row);
    }
    /**
     * Container info retrieve
     */
    function searchCNTRInfo(sheetObj, Row, Col, Value)  {
    	var formObj=document.form;    	
    	formObj.f_cmd.value=SEARCH03;
    	var beforeBkgNo=getObjValue("set_bkg_no");
    	setObjValue("set_bkg_no", sheetObj.GetCellValue(Row, prefixs[0]+"bkg_no"));
    	var spcl_cgo_cate_cd=sheetObj.GetCellValue(Row, prefixs[0]+"spcl_cgo_cate_cd");
    	setObjValue("dcgo_flg", spcl_cgo_cate_cd=='DG'?'Y':'');
    	setObjValue("awk_cgo_flg", spcl_cgo_cate_cd=='AK'?'Y':'');
    	setObjValue("rc_flg", spcl_cgo_cate_cd=='RF'?'Y':'');
    	setObjValue("bb_cgo_flg", spcl_cgo_cate_cd=='BB'?'Y':'');
    	var sParam=FormParamString(formObj, "hidden");
    	sheetObj.SetWaitImageVisible(0);
 		var sXml=sheetObj.GetSearchData("VOP_SCG_0013GS.do", sParam + "&pol_yd_cd=" + getObjValue("pol_cd") + "&" + ComGetPrefixParam(prefixs[0]));
		sheetObj.SetWaitImageVisible(1);
		
		var tpSzVar1 = sheetObjects[0].GetCellValue(1, prefixs[0]+"cntr_tpsz_cd");	//@@첫번째로우 계속변경되는현상
		setCNTRInfo(sheetObj, Row, Col, sXml, Value);		
		setObjValue("set_bkg_no", beforeBkgNo);
		
		setTPSZCombo2(sXml, tpSzVar1, sheetObj);
	}
    
    /**
     * Set TP/SZ Combo list
     */
    function setTPSZCombo2(sXml, tpSzVar1, sheetObj) {
    	var selRow=sheetObj.GetSelectRow();
    	var arrCombo;
    	
    	if(sheetObj.id == "sheet1"){
    		arrCombo=ComXml2ComboString(sXml, prefixs[0]+"cntr_tpsz_cd", prefixs[0]+"cntr_tpsz_cd");
    		sheetObjects[0].SetColProperty(prefixs[0]+"cntr_tpsz_cd", {ComboText:""+arrCombo[0], ComboCode:""+arrCombo[1]} );
    		if(tpSzVar1 != ""){
    			sheetObjects[0].SetCellValue(1, prefixs[0]+"cntr_tpsz_cd", tpSzVar1);
    		}
    		//sheetObjects[0].SetCellValue(selRow, prefixs[0]+"cntr_tpsz_cd", arrCombo[0]);
    	} else if(sheetObj.id == "sheet2"){
    		arrCombo=ComXml2ComboString(sXml, prefixs[1]+"cntr_tpsz_cd", prefixs[1]+"cntr_tpsz_cd");
    		sheetObjects[1].SetColProperty(prefixs[1]+"cntr_tpsz_cd", {ComboText:""+arrCombo[1], ComboCode:""+arrCombo[1]} );
    		if(tpSzVar1 != ""){
    			sheetObjects[1].SetCellValue(1, prefixs[1]+"cntr_tpsz_cd", tpSzVar1);
    		}
    		sheetObjects[1].SetCellValue(selRow, prefixs[1]+"cntr_tpsz_cd", arrCombo[0]); 
    	}
    	
//		if(arrCombo != null && arrCombo.length > 0){
//			var selRow=sheetObj.GetSelectRow();
//	    	if(sheetObj.id == "sheet1"){
//	    		//sheetObjects[0].SetColProperty(prefixs[0]+"cntr_tpsz_cd", {ComboText:""+arrCombo[0], ComboCode:""+arrCombo[1]} );
//	    		//sheetObjects[0].SetColProperty(prefixs[0]+"cntr_tpsz_cd", {Type: "Text", Align: "Center", Edit: 0});
//	    		sheetObjects[0].SetCellValue(selRow, prefixs[0]+"cntr_tpsz_cd", arrCombo[0]); 
//	    	} else if(sheetObj.id == "sheet2"){
//	    		//sheetObjects[1].SetColProperty(prefixs[1]+"cntr_tpsz_cd", {ComboText:""+arrCombo[0], ComboCode:""+arrCombo[1]} );
//	    		sheetObjects[1].SetCellValue(selRow, prefixs[1]+"cntr_tpsz_cd", arrCombo[0]); 
//	    	}
//		}
    }
    
    /**
     * TP/SZ Combo list retrieve
     */
    function searchTPSZList(formObj) {  
    	formObj.f_cmd.value=SEARCH06;
    	sheetObjects[0].SetWaitImageVisible(0);
 		var sXml=sheetObjects[0].GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		sheetObjects[0].SetWaitImageVisible(1);
		setTPSZCombo(sXml);
    }
    /**
     * Class Combo list retrieve
     */
    function searchClsList(formObj) {  
    	formObj.f_cmd.value=SEARCH02;
    	sheetObjects[0].SetWaitImageVisible(0);
 		var sXml=sheetObjects[0].GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
		sheetObjects[0].SetWaitImageVisible(1);
		setClsCombo(sXml);
    }
    /**
     * Class Comp Group Combo list retrieve
     */
    function searchClsCompGrpList(formObj) {  
    	formObj.f_cmd.value=SEARCH08;
    	sheetObjects[0].SetWaitImageVisible(0);
 		var sXml=sheetObjects[0].GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		sheetObjects[0].SetWaitImageVisible(1);
		//Class Comp Group Combo list retrieve
		setClsCompGrpCombo(sXml);
    }
    /**
     * UN No. Validation
     */
    function checkUNNo(sheetObj, Row, Col) {  
     	var formObj=document.form;
     	formObj.f_cmd.value=SEARCH01;
     	//var imdgUnNo = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no");
     	//var imdgUnNo=sheetObj.GetEditText();
     	var imdgUnNo=sheetObj.GetCellValue(Row, Col);
     	
     	sheetObjects[0].SetWaitImageVisible(0);
  		var sXml=sheetObjects[0].GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_un_no="+imdgUnNo);
 		sheetObjects[0].SetWaitImageVisible(1);
 		var sTotal=ComScgGetTotalValue(sXml);
 		if( sTotal == "0"){
 			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 			initObjs("sheet", sheetObj, "imdg_un_no|imdg_un_no_seq|imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", 0, Row);
 			sheetObj.SelectCell(Row, prefixs[0]+"imdg_un_no");
 		} else { 			
 			initObjs("sheet", sheetObj, "imdg_un_no_seq|imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", 0, Row);
 			sheetObj.SelectCell(Row, prefixs[0]+"imdg_un_no_seq");
 		}
    }
    /**
     * UN No. info retrieve
     */
    function searchUNNoInfo(sheetObj, Row, Col) {  
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH05;
    	var imdgUnNo=sheetObj.GetCellValue(Row, prefixs[0]+"imdg_un_no");
    	var imdgUnNoSeq=sheetObj.GetCellValue(Row, prefixs[0]+"imdg_un_no_seq");
		if(imdgUnNo != '') {
			sheetObjects[0].SetWaitImageVisible(0);
 			var sXml=sheetObjects[0].GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq);
			sheetObjects[0].SetWaitImageVisible(1);
			var sArr=ComScgXml2Array(sXml, "imdg_un_no");
			var imdg_un_no="";
			var imdg_un_no_seq=""; 
			var imdg_clss_cd="";
			var imdg_comp_grp_cd="";
			var prp_shp_nm="";
			if(sArr == null) {
				ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
				initObjs("sheet", sheetObj, "imdg_un_no_seq|imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", 0, Row);
			} else {
				imdg_un_no=ComScgXml2Array(sXml, "imdg_un_no").toString();
				imdg_un_no_seq=ComScgXml2Array(sXml, "imdg_un_no_seq").toString();
				imdg_clss_cd=ComScgXml2Array(sXml, "imdg_clss_cd").toString();
				imdg_comp_grp_cd=ComScgXml2Array(sXml, "imdg_comp_grp_cd").toString();
				prp_shp_nm=ComScgXml2Array(sXml, "prp_shp_nm").toString();
				setUNNoInfo(0, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm);
			}
		} else {
			ComShowCodeMessage("SCG50007", "UN No.");	//'Please input {?msg1}.'
			initObjs("sheet", sheetObj, "imdg_un_no_seq|imdg_clss_cd|imdg_comp_grp_cd|prp_shp_nm", 0, Row);
			sheetObj.SelectCell(Row, prefixs[0]+"imdg_un_no");
		}
    }
    /**
     * Port Validation
     */
    function searchPortCheck(obj) {
      	var formObj=document.form;
      	var sheetObj=sheetObjects[0];
      	var sParam=Array();
  	  	sParam[0]="port_cd="+obj.value;
  	  	sParam[3]="f_cmd="+SEARCH09;
  	  	if(sParam.join("").length > 17) {
  	  		sheetObj.SetWaitImageVisible(0);
   	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
  	    	sheetObj.SetWaitImageVisible(1);
  	    	var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
  	 	   	if(port_cd_nm == '') {
  	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
  	 		    ComSetObjValue(obj, ""); 	 		    
  	 		    ComSetFocus(obj);
  	 	   	} else {
  	 	   		ComSetNextFocus(obj);
  	 	   	}
  	  	}
    }
    /*****************************************************************************************
     * Transaction end *
     ****************************************************************************************/ 
    /*****************************************************************************************
     * Validation start *
     ****************************************************************************************/ 
    /**
     * In Grid Column duplication check
     */
    function colDupCheck(sheetObj, colNms, values, expRows) { 
    	if(values != null) {       		
    		var loopVal, value, rowState, expCt;
	    	for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	    		loopVal="";
	    		rowState=sheetObj.GetRowStatus(rowIdx);
	    		for(var colIdx=0; colIdx<colNms.length; colIdx++) {
	    			value=sheetObj.GetCellValue(rowIdx, prefixs[0]+colNms[colIdx]);
	    			if(value == '') value=sheetObj.GetCellText(rowIdx, prefixs[0]+colNms[colIdx]);
	    			loopVal += value;
	    		}    		
	    		if(rowState != 'D' && loopVal == values.join("")) {
	    			expCt=0;
	    			for(var expIdx=0; expIdx<expRows.length; expIdx++) {
	    				if(rowIdx == expRows[expIdx]) expCt++;
	    			}
	    			if(expCt == 0) return rowIdx;
		    	}
	    	}
    	}
    	return -1;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
    	switch(sAction) {
        	case IBSEARCH:
        		if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
        		if(!ComChkObjValid(formObj.skd_voy_no)) return false;
        		if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
        		if(!ComChkObjValid(formObj.irr_occr_dt)) return false;
        		if(!ComChkObjValid(formObj.vsl_opr_tp_cd)) return false;
        		if(!ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		if(getObjValue("bkg_no") != '' && !ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		break;
        	case IBSAVE:        		
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
		    	//Check requirement of Option
		    	var isChecked=false;
		    	for (var i=0; i<formObj.spcl_cgo_cate_cd.length; i++){
		    		if(formObj.spcl_cgo_cate_cd[i].checked){
		    			isChecked=true;
		    		}
		    	}
		    	if(!isChecked) {
		    		ComAlertFocus(document.all.spcl_cgo_cate_cd[0], "'Option' " +Msg_Required);		    		
		    		return;
		    	}
		    	//Check requirement of Irregulars Type
		    	if(ComGetObjValue(document.all.spcl_cgo_irr_tp_cd) == '') {
		    		ComAlertFocus(document.all.spcl_cgo_irr_tp_cd, "'Irregulars Type' " +Msg_Required);		    		
		    		return;
		    	}
		    	var ibflag;
		    	var sVal1;
		    	var sVal2;
		    	for(var rowIdx1=sheetObj.HeaderRows(); rowIdx1<sheetObj.LastRow(); rowIdx1++) {
		    		ibflag=sheetObj.GetRowStatus(rowIdx1);
		    		sVal1=sheetObj.GetCellText(rowIdx1, prefixs[0]+"cntr_no")+sheetObj.GetCellValue(rowIdx1, prefixs[0]+"cgo_seq");
					if(ibflag != 'D' && sVal1 != '') {				
			    		for(var rowIdx2=rowIdx1+1; rowIdx2<=sheetObj.LastRow(); rowIdx2++) {
			    			ibflag=sheetObj.GetRowStatus(rowIdx2);
			    			sVal2=sheetObj.GetCellText(rowIdx2, prefixs[0]+"cntr_no")+sheetObj.GetCellValue(rowIdx2, prefixs[0]+"cgo_seq");
							if(ibflag != 'D' && sVal2 != '') {
				    			if(sVal1 == sVal2) {
				    				ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'				
				    				initCell(sheetObj, rowIdx2, sheetObj.SaveNameCol(prefixs[0]+"cgo_seq"));
				    				return false;
				    			}
				    		}
						}
					}
		    	}
		    	break;
        	case IBDELETE:
        		if(getObjValue("spcl_cgo_irr_seq") == '') {
        			//ComShowCodeMessage('SCG02001','Irregular');   //'"No Data not found! Do you want to insert new {?msg1}.?"'
        			return false;
        		}
        		if(!ComShowCodeConfirm('SCG50002', 'data')) return false;	//'Do you want to delete {?msg1}?'
        		break;
        	case IBCLEAR:
        		if(getObjValue("spcl_cgo_irr_seq") != '' && sheetObj.IsDataModified()) {
        			if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
        				doActionIBSheet(sheetObj,formObj,IBSAVE,'CLEAR');
        				return false;
        			}
        		}
        		break;
        	case IBRESET:
        		if(getObjValue("spcl_cgo_irr_seq") != '' && sheetObj.IsDataModified()) {
        			if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
        				var optionVal=getObjValue("spcl_cgo_cate_cd");
        				if(optionVal == 'AC') document.all.spcl_cgo_cate_cd[0].checked=true;
        	    		else if(optionVal == 'DG') document.all.spcl_cgo_cate_cd[1].checked=true;
        				doActionIBSheet(sheetObj,formObj,IBSAVE,'CHANGE');
        				return false;
        			}
        		}
        		break;
    	}
        return true;
    }
    /**
     *  Available to Add&Insert Sheet-Row
     */
    function isSetBkgNo() { 
    	if(getObjValue("bkg_no") == "" && isOwnCarrier()) {
    		ComShowCodeMessage('SCG50007','BKG No. or B/L No.');   //'Please input {?msg1}.'
    		//move focus
			setFocus("bkg_no");
    		return true;
    	}
    	return false;
    }
    
    function searchFileList(sheetObj) {
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH;
    	sheetObj.DoSearch("VOP_SCG_2013_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[1]) );
    }
    /*****************************************************************************************
     * Validation end *
     ****************************************************************************************/ 
