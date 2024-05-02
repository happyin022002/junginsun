
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5011.js
*@FileTitle  : DG EDI Transmit History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17 
=========================================================*/

/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_SCG_5011 : business script for VOP_SCG_5011
     */
    // common global variables
    var comboObjects=new Array();
	var comboCnt=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    
    var gRgnShpOprCd	= "";
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObj=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                case "expand":
                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                    break;
                case "btn_new":
                	ComResetAll();
                	
                	ComBtnDisable("btn_details");
                    ComSetObjValue(formObj.trsm_from_dt, ComGetDateAdd(null, "d", -7));
                    ComSetObjValue(formObj.trsm_to_dt  , ComGetDateAdd(null, "d", 0));
                    
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                    break;
                   
                case "btn_SlanCd":
	 				onPopupClick(sheetObj, srcName, "Lane");
	 				break;
                case "btn_VVDpop":
	 				onPopupClick(sheetObj, srcName, "VVD");
	 				break;
                case "btn_Pol":
	 				onPopupClick(sheetObj, srcName, "POL");
	 				break;
                case "btn_Pod":
	 				onPopupClick(sheetObj, srcName, "POD");
	 				break;
                case "btn_Carrier":
	 				onPopupClick(sheetObj, srcName, "Carrier");
	 				break;
                case "btn_VVDpop":
	 				onPopupClick(sheetObj, srcName, "VVD");
	 				break;
                case "btn_Calendar":
                	var cal=new ComCalendarFromTo();                	
                	cal.select(formObj.trsm_from_dt, formObj.trsm_to_dt, 'yyyy-MM-dd');
                	break;
                case "btn_details":
                	onPopupClick(sheetObj, srcName, "details");
                	break;
                	expand
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    
    function obj_blur() {
    	var formObj=document.form;
	   	switch(ComGetEvent("name")){
	   		case "slan_cd":
		       	var objName="slan_cd";
		       	var srcName=ComGetEvent("name");
		    		 
	   	 		var sLen=formObj.slan_cd.value.length;
	   	 		if (sLen == 3) {
	   	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	   	 		}else if (sLen != 0) {
	        			ComShowCodeMessage('SCG50006',"Lane Code"+sInt, "3");
	        			event.srcElement.focus();
	        	     	event.srcElement.select();
	   	    		return false;
	   	 		}
	   	 		break;
	   		case "vsl_cd": case "skd_voy_no": case "skd_dir_cd":	
	   			var value = ComGetObjValue(formObj.vsl_cd);
		 		if(value.length == 0) {
		 			ComSetObjValue(formObj.vsl_eng_nm, "");
		 		}
		 		if(ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '' && ComGetObjValue(formObj.skd_dir_cd) != '') {
		 			searchVVDCheck();						//VVD Check
		 		}
		 		break;
	 	case "pol_cd": case "pod_cd":	 
	 		searchPortCheck(ComGetEvent());		//Port Check
	     	break;
	 	case "cgo_opr_cd":	
    		searchCarrierCheck(ComGetEvent());	//Carrier Check
        	break;
	 	case "trsm_from_dt":	
	 		ComAddSeparator(ComGetEvent());
	 		break;
	 	case "trsm_to_dt":
	 		ComAddSeparator(ComGetEvent());    		
	     	break;
	    }
    }
    
    function obj_click() {
    	var formObj=document.form;
	   	switch(ComGetEvent("name")) {
		 	case "trsm_bnd_cd":
		 		var value = ComGetObjValue(formObj.trsm_bnd_cd);
		 		sheetObjects[0] = sheet1.Reset();
		 		ComConfigSheet (sheetObjects[0]);
	            initSheet(sheetObjects[0],1);
	            ComEndConfigSheet(sheetObjects[0]);
		 		ComBtnDisable("btn_details");
		 		
		 		comboObjects[2].SetEnable((value == "O") ? false : true);
		 		comboObjects[2].SetSelectIndex("0", true);
		 		
		 		if(formObj.trsm_bnd_cd[0].checked){
		 			
					formObj.f_cmd.value			= SEARCH01;
					var sXml					= sheetObjects[0].GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
					ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
					rgn_shp_opr_cd.InsertItem	(0, "All|All", "");
					
			     	if(gRgnShpOprCd == ""){
			     		comboObjects[0].SetSelectIndex(0, false);
			     	}else{
			     		comboObjects[0].SetSelectCode(gRgnShpOprCd, false);
			     	}
					
		 		}else if(formObj.trsm_bnd_cd[1].checked){
		 			
					formObj.f_cmd.value			= SEARCH11;
					var sXml					= sheetObjects[0].GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
					ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
					rgn_shp_opr_cd.InsertItem	(0, "All|All", "");
					
			     	if(gRgnShpOprCd == ""){
			     		comboObjects[0].SetSelectIndex(0, false);
			     	}else{
			     		comboObjects[0].SetSelectCode(gRgnShpOprCd, false);
			     	}
		 			
		 		}
		 		
		     	break;
	    }
    }
    
    //S// Initialize 
    // business javascript OnKeyPress event Catch
    function initControl() {
        // Axon event handling 1. event       
        axon_event.addListenerForm('blur' , 'obj_blur' ,  document.form);
        axon_event.addListenerForm('click', 'obj_click',  document.form);
//        axon_event.addListenerForm('keydown', 'monitor', document.form);
    }
    
//    function monitor() {
//    	if((ComGetEvent("keycode") == 118) && (ComGetEvent().name == "pod_cd")) {
//    		onPopupClick(sheetObjects[0], "", "flat");
//    	}
//    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        //initalizing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++) {
       	 	initCombo(comboObjects[k], k + 1);
        }
        initControl();
        
        ComBtnDisable("btn_details");
        comboObjects[2].SetEnable(false);
        
        var formObj = document.form;
        ComSetObjValue(formObj.trsm_from_dt, ComGetDateAdd(null, "d", -7));
        ComSetObjValue(formObj.trsm_to_dt  , ComGetDateAdd(null, "d", 0));        
        
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        
        switch(sheetNo) {
            case 1:      //t1sheet1 init
              with (sheetObj) {
              
              var trsmVal =	ComGetObjValue(document.form.trsm_bnd_cd);
              
              var HeadTitle1  = "";
              var HeadTitle2  = "";
              
              if (trsmVal == "O") {
            	  HeadTitle1  = "No|VSL\nOPR|RSO|Lane|BKG Ref No|POL|ETA|POD|VVD CD|VVD CD|VVD CD";
                  HeadTitle1 += "|EDI Msg\nType|Message Date\n(O/B)|APERAK(I/B)|APERAK(I/B)|APERAK(I/B)|||";
                  HeadTitle2  = "No|VSL\nOPR|RSO|Lane|BKG Ref No|POL|ETA|POD|VVD CD|VVD CD|VVD CD";
                  HeadTitle2 += "|EDI Msg\nType|Message Date\n(O/B)|Receive Date|Received Result|Received Result|||";              
              } else {
            	  HeadTitle1  = "No|CGO\nOPR|RSO|Lane|BKG Ref No|POL|ETA|POD|Call Sign\n/ Lloyd|Con-\nsortium|VVD CD|VVD CD|VVD CD|Alliance DG\nAppl. Status";
                  HeadTitle1 += "|EDI Msg\nType|Unmapped EDI|Unmapped EDI|Receive(I/B)|Receive(I/B)|Receive(I/B)|APERAK(O/B)|APERAK(O/B)|||";
                  HeadTitle2  = "No|CGO\nOPR|RSO|Lane|BKG Ref No|POL|ETA|POD|Call Sign\n/ Lloyd|Con-\nsortium|VVD CD|VVD CD|VVD CD|Alliance DG\nAppl. Status";
                  HeadTitle2 += "|EDI Msg\nType|Original|Updated|EDI Status|EDI Status|Message Date|Send Date|Send Status|||";
              }
              
              var headCount = ComCountHeadTitle(HeadTitle1);
             
              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                              { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);
              if (trsmVal == "O") {
	              var cols = [
	                     {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",	          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"edi_msg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tran_if_date",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"ark_if_date",         KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"msg_ack_rslt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:275,  Align:"Left",    ColMerge:0,   SaveName:"msg_rjct_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cgo_opr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"err_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"method",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsm_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prnr_spcl_cgo_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
	              ];
	              
              } else {
            	  var cols = [
            	              
     	                     {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },     	                     
     	                     
     	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
   	                     
     	                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     
     	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"call_sign_lloyd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ob_cssm_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                    
     	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",	          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                    
     	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cgo_create_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",	          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
   	                     
     	                     {Type:"Combo",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"edi_msg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     
     	                     ////{Type:"CheckBox",  Hidden:0,  Width:55,  Align:"Center",  ColMerge:0,   SaveName:"edi_unmap_flg",        KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Image",     Hidden:0,  Width:55,  Align:"Center",  ColMerge:0,   SaveName:"edi_unmap_flg",        KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0,	ImgWidth:13, ImgHeight:13 },
    	                     {Type:"Text",      Hidden:0,  Width:55,  Align:"Center",  ColMerge:0,   SaveName:"edi_unmap_corr_cd",    KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                     
     	                     {Type:"Combo",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"err_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:275,  Align:"Left",    ColMerge:0,   SaveName:"msg_rjct_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"tran_if_date",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"ark_if_date",         KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"msg_ack_rslt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     	                     {Type:"Text",      Hidden:1,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                     {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"method",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                     {Type:"Combo",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsm_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                     {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prnr_spcl_cgo_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
     	              ];
              }
              
              InitColumns(cols);
              SetEditable(0);
              
              SetColProperty("err_knd_cd"      , {ComboText:"Success|Reject|Error|Exception|Clear", ComboCode:"O|R|U|E|C"} );
              SetColProperty("edi_msg_sts_cd"  , {ComboText:"Original|Update|Cancel"        , ComboCode:"N|U|R"} );
              SetColProperty("trsm_sts_cd"     , {ComboText:"SEND|FAIL|SUCCESS|RECEIVED"    , ComboCode:"N|F|S|R"} );
              SetColProperty("msg_ack_rslt_cd" , {ComboText:"Success|Fail"                  , ComboCode:"A|R"} );
              //SetColProperty("msg_ack_rslt_cd" , {ComboText:"Accepted|Rejected"             , ComboCode:"A|R"} );
              
              
              
              SetImageList(0, "js/ibsheet/Main/chk0R.gif");
              SetImageList(1, "js/ibsheet/Main/chk1.gif");
              
              
              
              resizeSheet();              
            }
            break;
        }
    }
    
    /**
     * Initialzing Combo
     * param : sheetObj, sheetNo
     * adding case as numbers of counting combo
     */ 
    function initCombo(comboObj, comboNo) {
    	 switch(comboObj.options.id) {
	 	  	case "rgn_shp_opr_cd":
			  		with(comboObj) {
		  			SetTitle("Code|Description");
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
		  			SetDropHeight(200);
		         	}
		  		break;
	   	 	case "err_knd_cd":
	    		with (comboObj) {
					SetMultiSelect(0);
	   				SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "80");
	   				SetBackColor("#FFFFFF");
	   				SetFontColor("#000000");
	   				SetColBackColor(0,"#FFFFFF");
	   				SetColFontColor(0,"#000000");
					SetDropHeight(160);
					
					comboObj.InsertItem(0, "ALL"      , "");
					comboObj.InsertItem(1, "Success"  , "O");
		   	     	comboObj.InsertItem(2, "Reject"   , "R");
		   	     	comboObj.InsertItem(3, "Error"    , "U");	/* for Unmapping EDI */
		   	     	comboObj.InsertItem(4, "Exception", "E");		   	     	
		   	     	comboObj.InsertItem(5, "Clear"    , "C");
		   	     	
		   	     	comboObj.SetSelectIndex(0, true);
		    	}
	    		break;
	   	case "edi_msg_sts_cd":
    		with (comboObj) {
				SetMultiSelect(0);
   				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "80");
   				SetBackColor("#FFFFFF");
   				SetFontColor("#000000");
   				SetColBackColor(0,"#FFFFFF");
   				SetColFontColor(0,"#000000");
				SetDropHeight(160);
				
				comboObj.InsertItem(0, "ALL"     , "");
	   	     	comboObj.InsertItem(1, "Original", "N");
	   	     	comboObj.InsertItem(2, "Update"  , "U");
	   	     	comboObj.InsertItem(3, "Cancel"  , "R");
	   	     	
	   	     	comboObj.SetSelectIndex(0, true);
	    	}
    		break;
   	  	}
    	 
    }
    
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve again	    		
				formObj.f_cmd.value=SEARCH;
				var tmpBkgRefNo = ComGetObjValue(document.form.bkg_ref_no);
				if(tmpBkgRefNo == "CLT"){
					ComSetObjValue(document.form.bkg_ref_no, "");
				}
				var xml=sheetObj.GetSearchData("VOP_SCG_5011GS.do", FormQueryString(formObj));
	 			
	 			sheetObj.LoadSearchData(xml,{Sync:1});
	 			
				if(tmpBkgRefNo == "CLT"){
					ComSetObjValue(document.form.bkg_ref_no, tmpBkgRefNo);
				}
				
	 			if (sheetObj.SearchRows() > 0) {
	 				ComBtnEnable("btn_details");
	 			}
	     		break;
	     		
			case IBSEARCH_ASYNC01:   //RSO 조회
				
				//formObj.f_cmd.value=SEARCH01; SEARCH01 > SEARCH11 : 2016-02-15
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObjects[0].GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
				rgn_shp_opr_cd.InsertItem(0, "All|All", "");
				
				formObj.f_cmd.value=SEARCH10;
		     	var param   =FormQueryString(formObj) ;
		      	var sXml    =sheetObjects[0].GetSearchData("SCG_COM_INTERNALGS.do", param);
		      	
		      	gRgnShpOprCd = ComGetEtcData(sXml,"rgn_shp_opr_cd");  
		     	if(gRgnShpOprCd == ""){
		     		comboObjects[0].SetSelectIndex(0, false);
		     	}else{
		     		comboObjects[0].SetSelectCode(gRgnShpOprCd, false);
		     	}
		     	
				break;	    	     		
        	case IBSEARCH_ASYNC02: //checkLane retrieve
         		sheetObj.SetWaitImageVisible(0);
         		formObj.f_cmd.value=SEARCH02;
         		var sName=ComGetEvent("name");
          		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do" , FormQueryString(formObj)+"&vsl_slan_cd="+event.srcElement.value);
         		var arrData=ComScgXml2Array(sXml, "vsl_slan_cd");
         		if (arrData != null && arrData.length > 0) {
         			ComSetNextFocus(event.srcElement);
         		}else{
         			ComShowCodeMessage('SCG50010',"Data" );
         			event.srcElement.value="";
         			event.srcElement.focus();
					return false;
         		}
         		break;
        }
    }
    
    /**
     * Handling Sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    }
    
    function sheet1_OnDblClick(obj, Row, Col, CellX, CellY, CellW, CellH) { 
    	if(sheetObjects[0].ColSaveName(Col) == "Seq") {
    		if(ComGetObjValue(document.form.bkg_ref_no) == "CLT"){
    			onPopupClick(sheetObjects[0], "", "flat");	
    		}
    	} else {
    		onPopupClick(sheetObjects[0], "", "details");
    	}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
    	switch(sAction) {
	    	case IBSEARCH:
	    		//Check Validation in all controls inside form object
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
	    		break;
		}
	    return true;
    }
    
    /**
     * Lane Check
     */
    function searchLaneCheck() {
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[0];
     	var slan_cd  = ComGetObjValue(formObj.slan_cd);
     	if (slan_cd != '') {
	     	var sParam=Array();
	 	  	sParam[0]="vsl_slan_cd=" + slan_cd;
	 	  	sParam[3]="f_cmd=" + SEARCH02;
	 	  	sheetObj.SetWaitImageVisible(0);
 	     	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	     	sheetObj.SetWaitImageVisible(1);
	     	var slan_cd=ComScgXml2Array(sXml, "vsl_slan_cd");
	  	   	if(slan_cd == null || slan_cd == undefined) {
	  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	  		    ComSetFocus(formObj.slan_cd);
	  		    formObj.slan_cd.select();
	  	   	}
     	}
    }
    
    /**
     * Vessel Name retrieve
     */
    function searchVVDCheck() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var sParam=Array();
	  	sParam[0]="vsl_cd="     + ComGetObjValue(formObj.vsl_cd);
	  	sParam[1]="skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2]="skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3]="f_cmd="      + SEARCH05;
	  	if(sParam.join("").length > 38) {
	  		sheetObj.SetWaitImageVisible(0);
 	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	    	sheetObj.SetWaitImageVisible(1);
	    	var vsl_eng_nm=ComScgXml2Array(sXml, "vsl_eng_nm");
	 	   	if(vsl_eng_nm == null || vsl_eng_nm == undefined) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    ComSetObjValue(formObj.vsl_eng_nm, "");
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	} else {		    	
	 	   		ComSetObjValue(formObj.vsl_eng_nm, vsl_eng_nm);
	 	   	}
	  	}
    }
    
    /**
     * Port Validation
     */
    function searchPortCheck(obj) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	var sParam=Array();
 	  	sParam[0]="port_cd="+ obj.value;
 	  	sParam[3]="f_cmd="  + SEARCH09;
 	  	if (sParam.join("").length > 17) {
 	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	    	sheetObj.SetWaitImageVisible(1);
 	    	var port_cd_nm = ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
 	 	   	if(port_cd_nm == '') {
 	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	 		    ComSetObjValue(obj, ""); 	 		    
 	 		    ComSetFocus(obj);
 	 	   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	var sParam=Array();
 	  	sParam[0]="crr_cd=" + obj.value;
 	  	sParam[3]="f_cmd="  + SEARCH01;
 	  	if (sParam.join("").length > 17) {
 	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	    	sheetObj.SetWaitImageVisible(1);
 	    	var crrData=ComScgXml2Array(sXml, "crr_cd");
 		   	if (crrData == null || crrData == undefined) {
 			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 			    ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
 		   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    /**
     * @@ 수정
     * Clicking popup in IBSheet Object
     */
    /**
     * When clicking popup in retriving condition
     */
    function onPopupClick(sheetObj, srcName, srcType) {
    	var sUrl = "";
    	var formObj = document.form;
    	
    	if (srcType == "Lane") {
    		ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 470, 470, "getSlanCdData", "0,0", true);
   	 	} else if (srcType == "POL" || srcType == "POD") {
   	 		helper = "";
   	 		var pol_pod = "";
   	 		if (srcType == "POL") {
   	 			pol_pod = ComGetObjValue(formObj.pol_cd);
   	 			helper = "getPolData";
   	 		}else{
   	 			pol_pod = ComGetObjValue(formObj.pod_cd);
   	 			helper = "getPodData"; 			
   	 		}
			sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + pol_pod;
    		ComOpenPopup(sUrl, 422, 530, helper, "0,0", true);
    		
   	 	} else if (srcType == "details") {
   	 		var Row = sheetObj.GetSelectRow();
   	 		
   	 		/** Conversion character 
   	 		 * &	-> %26
   	 		 * +	-> %2B
   	 		 */
   	 		var param  = "cgo_opr_cd="  + sheetObj.GetCellValue(Row, "cgo_opr_cd") + "&";
   	 	        param += "bkg_ref_no="  + ComReplaceStr(ComReplaceStr(sheetObj.GetCellValue(Row, "bkg_ref_no"),'+','%2B'),'&','%26') + "&";
   	 	        param += "slan_cd="     + sheetObj.GetCellValue(Row, "slan_cd")    + "&";
   	 	        param += "vsl_cd="      + sheetObj.GetCellValue(Row, "vsl_cd")     + "&";
   	 	        param += "skd_voy_no="  + sheetObj.GetCellValue(Row, "skd_voy_no") + "&";
   	 	        param += "skd_dir_cd="  + sheetObj.GetCellValue(Row, "skd_dir_cd") + "&";
   	 	        param += "crr_cd="      + sheetObj.GetCellValue(Row, "crr_cd")     + "&";
   	 	        
   	 	        param += "pol_cd="      + sheetObj.GetCellValue(Row, "pol_cd")     + "&";
   	 	        param += "pod_cd="      + sheetObj.GetCellValue(Row, "pod_cd")     + "&";
	        
   	 	        
   	 	        param += "trsm_bnd_cd=" + ComGetObjValue(formObj.trsm_bnd_cd);
   	 	        
   	 	        //alert('param >>> ['+param+']');
   	 	        
   	 	    if (ComGetObjValue(formObj.trsm_bnd_cd) == "O") {
   	 	    	ComOpenPopup('/opuscntr/VOP_SCG_5911.do?' + param, 1000, 600, null, "0,0", true);
   	 	    } else {
   	 	    	ComOpenPopup('/opuscntr/VOP_SCG_5913.do?' + param, 1080, 600, null, "0,0", true);
   	 	    }
   	 	    
	 	} else if (srcType == "Carrier") {
	 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(formObj.cgo_opr_cd), 600, 470, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
	 		
	 	} else if (srcType == "VVD") {
	 		
   	 		//VVD select popup open	
			var vsl_cd = ComGetObjValue(formObj.vsl_cd);
        	if (vsl_cd == "") {
        		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
        		ComOpenPopupWithTarget(sUrl, 480, 480, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
        	}else{
        		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopupWithTarget(sUrl, 480, 480, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0", true);
        	}
	 	} else if (srcType == "flat") {
	 		var Row = sheetObj.GetSelectRow();
   	 		
   	 		/** Conversion character 
   	 		 * &	-> %26
   	 		 * +	-> %2B
   	 		 */
   	 		var param  = "cgo_opr_cd="        + sheetObj.GetCellValue(Row, "cgo_opr_cd");
   	 	        param += "&bkg_ref_no="       + ComReplaceStr(ComReplaceStr(sheetObj.GetCellValue(Row, "bkg_ref_no"),'+','%2B'),'&','%26') + "&";
   	 	        param += "&slan_cd="          + sheetObj.GetCellValue(Row, "slan_cd");
   	 	        param += "&vsl_cd="           + sheetObj.GetCellValue(Row, "vsl_cd");
   	 	        param += "&skd_voy_no="       + sheetObj.GetCellValue(Row, "skd_voy_no");
   	 	        param += "&skd_dir_cd="       + sheetObj.GetCellValue(Row, "skd_dir_cd");
   	 	        param += "&crr_cd="           + sheetObj.GetCellValue(Row, "crr_cd");
   	 	        param += "&pol_cd="           + sheetObj.GetCellValue(Row, "pol_cd");
   	 	        param += "&pod_cd="           + sheetObj.GetCellValue(Row, "pod_cd");
   	 	        param += "&prnr_spcl_cgo_seq="+ sheetObj.GetCellValue(Row, "prnr_spcl_cgo_seq");
   	 	        param += "&trsm_bnd_cd="      + ComGetObjValue(formObj.trsm_bnd_cd);
   	 	        
   	 	        //alert('param >>> ['+param+']');
   	 	        
   	 	    ComOpenPopup('/opuscntr/VOP_SCG_5991.do?' + param, 800, 600, null, "0,0", true);
	 	}
    }
    /**
	 * Handling data from slan Code Help (Pop-Up)
	 * @param obj
	 * @return
	 */
    function getSlanCdData(obj) {
		if (obj) {
			var rtnDatas=obj[0];
			
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(document.form.slan_cd, rtnDatas[1]);
				}
			}
		}
	}
    
    /**
	 * Handling data from pol Code Help (Pop-Up)
	 * @param obj
	 * @return
	 */
	function getPolData(rtnDatas) {
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				ComSetObjValue(document.form.pol_cd, rtnDatas);
			}
		}
	}
	/**
	 * Handling data from pod Code Help (Pop-Up)
	 * @param obj
	 * @return
	 */
	function getPodData(rtnDatas) {
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				ComSetObjValue(document.form.pod_cd, rtnDatas);
			}
		}
	}
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    } 