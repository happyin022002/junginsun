/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0443.js
*@FileTitle  : CRN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	
	/* Developer Work */

 	// global variable

    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    
    var sheetObjects=new Array();
    var sheetCnt=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    // Event handler processing by button name */
	function processButtonClick(){
	 	    /***** using extra sheet valuable if there are more 2 sheets *****/
	 	    var sheetObject1=sheetObjects[0];
	 	    /*******************************************************/
	 	    var formObject=document.form;
	 		try {
	 			var srcName=ComGetEvent("name");
	 	        if (!ComIsBtnEnable(srcName)) return;
	 			switch(srcName) {
	 			    case "btn_new":
						initForm(formObject);
						break;
	 				case "btn_retrieve": 	
	 					formObject.ibflag.value = "";
	 					formObject.f_flag.value="SEARCH";  					
	 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	 					break;
					case "btn_save":
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						break;  
					case "btn_list":
						doActionIBSheet(sheetObject1, formObject, COMMAND01);
						break;  
					case "btn_changeCrn":
						doActionIBSheet(sheetObject1, formObject, COMMAND02);
						break;  	
					case "btns_calendar": //calendar button
		       	 		var cal=new ComCalendar();
		       	 		cal.select(formObject.frm_dem_free_dt ,'yyyy-MM-dd');
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
 	 * initializing sheet
 	 * implementing onLoad event handler in body tag
 	 * adding first-served functions after loading screen.
 	 */
 	function loadPage() {
 		var formObj=document.form;
 		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
// 		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
// 		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- When typing the keyboard    
    	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
    	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObj); //- focus in
    	axon_event.addListenerFormat('focus', 'obj_activate', formObj); //- focus out
 		initSheetData(sheetObjects[0], formObj);
        if(formObj.cn_no.value != "" || formObj.vvd_no.value != "")
        {	
        	formObj.frm_vvd_number.value=formObj.vvd_no.value;
        	formObj.frm_vsl_call_ref_no.value=formObj.cn_no.value;
        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
//        	formObj.frm_vsl_call_ref_no.focus();
        }
        else{
 		formObj.frm_cstms_decl_usr_id.value=formObj.f_user_id.value;
 		ComBtnDisable("btn_changeCrn");
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){			        
			      //no support[check again]CLT 	    						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			      var HeadTitle1="| |vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|vvd_number|user_ofc_cd";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dem_free_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"brth_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ntfy_ltr_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_decl_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vps_eta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vvd_number",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"user_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);	
			      SetEditable(1);
			      SetCountPosition(0);
			      SetSheetHeight(302);
				}
				break;
		}
	}
	 /**
	  * 
	  * @param sheetObj
	  * @param formObj
	  * @param sAction
	  * @return
	  */
    function doActionIBSheet(sheetObj,formObj,sAction) {        	         
   	 sheetObj.ShowDebugMsg(false);
   	 switch(sAction) {
   	 	case IBSEARCH:
   	 		
   	 	    if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}   
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
   	 	    if(formObj.f_flag.value == "SEARCH"){
   	 	    	if(!validateForm(sheetObj,formObj,sAction)) {
   	 	    		return false;
   	 	    	}
   	 	    	var searchFlag=true;
   	 	    	//VVD Check
   	 	    	if(formObj.frm_vvd_number.value != ""){
   	 	    		formObj.f_cmd.value=SEARCH01;
   	 	    		formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
   	 	    		formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
   	 	    		formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
   	 	    		
   	 	    		
   	 	    		//sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) ); 		       	 	    	
   	 	    		var sXml=sheetObj.GetSearchData("ESM_BKG_0443GS.do", FormQueryString(formObj),{Sync:2});//***** 		   	 	    		
   	 	    		sheetObj.LoadSaveData(sXml , {Sync:1});//*****
	   	 	    	//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	   	 	        var xmlDoc = ComGetXmlDoc(sXml);
//			        xmlDoc.async="false";
//			        xmlDoc.loadXML(sXml);
			        var dataNode=xmlDoc.documentElement.getElementsByTagName("MESSAGE").item(0);
			        if(dataNode != null) {
				        var dataChildNodes=dataNode.childNodes;
				        if(dataChildNodes.length > 0) {
				        	searchFlag=false
				        }     
   	 	    		}
   	 	    		ComEtcDataToForm(formObj, sheetObj);
   	 	    	}
   	 	    	if(searchFlag) {
       	 	    	formObj.f_cmd.value=SEARCH;       	 	    	
       	 	    	formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
       	 	    	formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
       	 	    	formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
       	 	        formObj.frm_crn_number.value=formObj.frm_vsl_call_ref_no.value; 							
       	 	        sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj),{Sync:2});//*****
					if(sheetObj.RowCount()== 1){
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");	
						formObj.ibflag.value = formObj.frm_vsl_call_ref_no.value;
					}  
   	 	    	}
   	 	    }
   	 	    if(formObj.f_flag.value == "SEARCH01")//vvd event
   	 	    {       	 	        
   	 	    	formObj.f_cmd.value=SEARCH01;
 	    		formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
 	    		formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
 	    		formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8); 		 	    		
 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) ,{Sync:2} );//****
 	    		ComEtcDataToForm(formObj, sheetObj);
   	 	    	if(formObj.frm_vvd_number.value != "")
   	 	    	{       	 	    	    
   	 	    		formObj.f_cmd.value=SEARCH;
   	 	    		formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
   	 	    		formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
   	 	    		formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
   	 	    		formObj.frm_crn_number.value="";
   	 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) ,{Sync:2} );//*****
        	 	    		 
   	 	    	}
   	 	    }
   	 	    if(formObj.f_flag.value == "SEARCH02")//crn_number
   	 	    {
   	 	    	if(!validateForm(sheetObj,formObj,sAction)) {
   	 	    		return false;
   	 	    	}
   	 	    	formObj.f_cmd.value=SEARCH03;
   	 	    	formObj.vsl_cd.value="";
   	 	    	formObj.skd_voy_no.value="";
   	 	    	formObj.skd_dir_cd.value="";
   	 	    	formObj.frm_crn_number.value=formObj.frm_vsl_call_ref_no.value;
   	 	    	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj),{Sync:2}  );//*****
   	 	    	if(sheetObj.RowCount()== 1){
   	 	    		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");	
   	 	    		//if(sheetObj.CellValue(0,"frm_vsl_call_ref_no"))
   	 	    	} 
   	 	    	formObj.f_cmd.value=SEARCH02;
   	 	    	formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
   	 	    	formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
   	 	    	formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
   	 	    	if(sheetObj.GetCellValue(1, "ibflag") == "R")
   	 	    	{
   	 	    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj)  ,{Sync:2});
   	 	        	//New CRN number
   	 	        	if(sheetObj.RowCount()== 0){
   	 	        	    formObj.frm_vvd_number.value="";
   	 	        	    formObj.frm_vsl_eng_nm.value="";
   	 	        	    formObj.frm_cstms_decl_usr_id.value="";
   	 	        	    init_combobox("frm_brth_ctnt","  ");
   	 	        		formObj.frm_cstms_decl_usr_id.value=formObj.f_user_id.value;
   	 	        	}
   	 	        }       	 	               	 	    	
   	 	    }
   	 	    if ( formObj.frm_vsl_call_ref_no.value != "" && formObj.frm_vvd_number.value != "" )
   	 	    {
   	 	    	ComBtnEnable("btn_changeCrn");
   	 	    } else {
   	 	    	ComBtnDisable("btn_changeCrn");
   	 	    }
   	    	IBS_CopyRowToForm(sheetObjects[0], document.form, 1, "frm_");
   	 	    ComOpenWait(false);
		break;
		case IBSAVE:   
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
 	    	formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
 	    	formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
 	    	formObj.frm_crn_number.value=formObj.frm_vsl_call_ref_no.value;
 	    	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) ,{Sync:2} );//*****
 	    	 if(sheetObj.GetEtcData("err_msg") == "BKG06142"){   
 	    		 ComOpenWait(false);
                 return;
             } 
 	    	
 	    	if(sheetObj.RowCount()== 1){
 	    		//IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
 	    	    if(formObj.frm_vsl_call_ref_no.value.length == 0)
 	    	    	formObj.frm_vsl_call_ref_no.value=sheetObj.GetCellValue(1,"vsl_call_ref_no");
 	    	    if(formObj.frm_vvd_number.value.length == 0)
 	    	    	formObj.frm_vvd_number.value=sheetObj.GetCellValue(1,"vvd_number");
 	    	    if(formObj.frm_vsl_eng_nm.value.length == 0)
 	    	    	formObj.frm_vsl_eng_nm.value=sheetObj.GetCellValue(1,"vsl_eng_nm");
 	    	    if(formObj.frm_vps_eta_dt.value.length == 0)
 	    	    	formObj.frm_vps_eta_dt.value=sheetObj.GetCellValue(1,"vps_eta_dt");
 	    	    if(formObj.frm_dem_free_dt.value.length == 0)
 	    	    	formObj.frm_dem_free_dt.value=sheetObj.GetCellValue(1,"dem_free_dt");
 	    	    if(formObj.frm_ntfy_ltr_ctnt.value.length == 0)
 	    	    	formObj.frm_ntfy_ltr_ctnt.value=sheetObj.GetCellValue(1,"ntfy_ltr_ctnt");
 	    	    if(formObj.frm_cstms_decl_usr_id.value.length == 0)
 	    	    	formObj.frm_cstms_decl_usr_id.value=sheetObj.GetCellValue(1,"cstms_decl_usr_id");
 	    	    if(formObj.frm_cre_dt.value.length == 0)
 	    	    	formObj.frm_cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
 	    	} 
 	        formObj.f_cmd.value=SEARCH01;
    		formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
    		formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
    		formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);					 
    		sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj),{Sync:2}  );//*****
    		ComEtcDataToForm(formObj, sheetObj);
    		if(sheetObj.GetEtcData("frm_vsl_eng_nm") == "")
    		{
    			ComOpenWait(false);
    			formObj.frm_vvd_number.focus();
    			return;
    		}
    		if(sheetObj.GetEtcData("err_msg") == "BKG00547")
    		{	ComOpenWait(false);
    			return;
    		}
    		if(!validateForm(sheetObj,formObj,sAction)) {
    			ComOpenWait(false);
				return false;
			}  
   			formObj.f_cmd.value=SEARCH02;
       	 	formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
       	 	formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
       	 	formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
       	 	formObj.frm_vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
    	 	formObj.frm_skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
    	 	formObj.frm_skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);   	    	 	       	       	 	  
    	 	sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) , {Sync:2}  );//*****
				// data check
				if(sheetObj.RowCount()== 0){
	   					sheetObj.DataInsert();
	   					IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
	   					//sheetObj.CellValue2(1, "ibflag") = "I";	
	   					sheetObj.SetRowStatus(1,"I");
	   					var rowCnt=sheetObj.RowCount();
	   					for(var i=1; i<=rowCnt; i++) {						
	   							sheetObj.SetCellValue(i,"brth_ctnt",formObj.frm_brth_ctnt.value,0);
	   					}
	   					formObj.f_cmd.value=MULTI;   					
	   			        sheetObj.DoSave("ESM_BKG_0443GS.do", FormQueryString(formObj));
				}
				else
				{					 
					IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
					//sheetObj.CellValue2(1, "ibflag") = "U";	
					sheetObj.SetRowStatus(1,"U");
					sheetObj.SetCellValue(1,"brth_ctnt",formObj.frm_brth_ctnt.value,0);
					formObj.f_cmd.value=MULTI;   					 
   			        sheetObj.DoSave("ESM_BKG_0443GS.do", FormQueryString(formObj));
				}
				//formObj.f_cmd.value = SEARCH;
   	 	    	//formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
   	 	    	//formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
   	 	    	//formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
   	 	        //formObj.frm_crn_number.value = formObj.frm_vsl_call_ref_no.value;
				//sheetObj.DoSearch("ESM_BKG_0443GS.do", FormQueryString(formObj) );
				//if(sheetObj.RowCount == 1){
					//IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");							 
				//}  
			ComOpenWait(false);
		break;  
		case COMMAND01:      //LIST
			var sUrl="/opuscntr/ESM_BKG_0444_POP.do?pgmNo=ESM_BKG_0444&crn_no="+formObj.frm_vsl_call_ref_no.value+"&vvd_no="+formObj.frm_vvd_number.value+"&pop_up=Y";
			ComOpenWindowCenter(sUrl, "ESM_BKG_0444", 1070, 650, false);
		break;
		case COMMAND02:      //LIST
		var sUrl="/opuscntr/ESM_BKG_1094.do?pgmNo=ESM_BKG_1094&crn_no="+formObj.frm_vsl_call_ref_no.value+"&vvd_no="+formObj.frm_vvd_number.value;
		ComOpenWindowCenter(sUrl, "ESM_BKG_1094", 400, 240, true);
	break;			
	}
  }       	    
 // sheet data Initialization
	function initSheetData(sheetObj, formObj) {
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");		
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
 		case IBSEARCH: // Retrieve
 			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
 				ComShowCodeMessage('BKG00538');
 				formObj.frm_vvd_number.focus();
 				return false;
 			}
 			if (ComIsNull(formObj.frm_vvd_number)) {
				ComShowCodeMessage('BKG00626','VVD');
				return false;	
			} 
 		return true;
 			break;
 		case IBSAVE: // save
 			if (formObj.frm_vsl_call_ref_no.value == "")
 			{
 				ComShowCodeMessage('BKG00537');
 				formObj.frm_vsl_call_ref_no.focus();
 				return false;
 			}
 			if (formObj.frm_vvd_number.value == "")
 			{
 				ComShowCodeMessage('BKG00549');
 				formObj.frm_vvd_number.focus();
 				return false;
 			}
 			if (formObj.frm_vsl_call_ref_no.value.length < 13) {
 				ComShowCodeMessage('BKG00537');
 				formObj.frm_vsl_call_ref_no.focus();
 				return false;
 			}
 		return true;
 			 break;
 		}	
    }
      /**
       * Keyboard input contol in onkeypress event of HTML Control
       **/
       function obj_keypress() {
       	 	switch(event.srcElement.dataformat){
       	 	case "uppernum":
                //Only upper eng input, upper eng+num -> ComKeyOnlyAlphabet('uppernum');
                ComKeyOnlyAlphabet('uppernum');
                break;
       	 	default:
                //Only num input(num,date,time)
                ComKeyOnlyNumber(event.srcElement);
       	 	}
       	 	var formObject=document.form;        
       	    var srcName=ComGetEvent("name");
       	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
       	    var srcValue=window.event.srcElement.getAttribute("value");
       	    var crn_number=formObject.frm_vsl_call_ref_no.value;
       	    var vvd_cd=formObject.frm_vvd_number.value;
       	    if(window.event.keyCode == 13)
       	    {              	    		 
       	    	if (srcName == "frm_vvd_number" && vvd_cd.length > 0)
       	    	{           	    			 
       	    		formObject.f_flag.value="SEARCH01";  
       	    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);            	    			
       	    	}   
       	    	if (srcName == "frm_vsl_call_ref_no" && crn_number.length > 0)
       	    	{           	    			 
       	    		formObject.f_flag.value="SEARCH02";  
       	    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);           	    			 
       	    	}             	    	
       	    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
        	    	ComSetNextFocus();        	    		
        	    }  
       	    }           	 	
        }
      /**
       * 
       * @param combo_id
       * @param combo_value
       * @return
       */
     function init_combobox(combo_id,combo_value)
     {
    	 var combox=document.getElementById(combo_id);
    	 if(combox == null)
    	 {
    		 return;
    	 }
    	 for(ix=0;ix < combox.length;ix++)
    	 {
    		 if(combox.options[ix].value=combo_value )
    		 {
    			 combox.options[ix].selected=true;
        		 return;
    		 }        		
    	 }
     }
     /**
      * 
      * @param formObj
      * @return
      */
     function initForm(formObj){    	 
    	 formObj.frm_vsl_call_ref_no.value="";
    	 formObj.frm_vvd_number.value="";
    	 formObj.frm_vsl_eng_nm.value="";
    	 formObj.frm_vps_eta_dt.value="";
    	 formObj.frm_dem_free_dt.value="";
    	 formObj.frm_ntfy_ltr_ctnt.value="";
    	 formObj.frm_cre_dt.value="";
    	 init_combobox("frm_brth_ctnt","  ");
    	 initSheetData(sheetObjects[0], formObj);
    	 formObj.frm_vsl_call_ref_no.focus();
    	 formObj.ibflag.value = "";
     }
	/**
	* onblur event Validation check. <br>
	**/          
     
     function obj_ComKeyEnter() {
      	var formObject=document.form;
      	var srcName=ComGetEvent("name");
        if( event.keyCode != 13){return;}
      	if(srcName == "frm_vsl_call_ref_no" || srcName == "frm_vvd_number") {         		 
      		ComKeyEnter();
      	}         	         
     }
     
	function obj_activate(){
		//input Validation check
		switch(event.srcElement.name){
			case "frm_dem_free_dt":
				ComClearSeparator(event.srcElement);
				break;	
			default:
				break;
				//return;
				//ComAddSeparator(event.srcElement);
				//ComChkObjValid(event.srcElement);
		}
	}
	/**   
	 * onblur event Validation check. <br>
	 **/
	function obj_deactivate(){
	    //input Validation check
		switch(event.srcElement.name){
	    	case "frm_dem_free_dt":
	    		ComAddSeparator(event.srcElement);
				break;
			default:
				break;
				//ComAddSeparator(event.srcElement);
				//ComChkObjValid(event.srcElement);
		}
	}
	function retrieve(crnNo)
	{
		document.form.frm_vsl_call_ref_no.value=crnNo;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
    		if(sheetObjects[0].RowCount()== 1){
	    			//IBS_CopyRowToForm(sheetObjects[0], document.form, 1, "frm_");							 
	    	}   
	}	
    