/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0102.js
*@FileTitle  : Total Loss Performance 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
     * @extends 
     * @class EES_MNR_0102 : business script for EES_MNR_0102.
     */

   	/* developer job	*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;     
 var HOOfc="";	
 var initLoader=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
		  var sheetObject1=sheetObjects[0];
		  /*******************************************************/
		  var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 				switch(srcName) {
 						case "btn_Retrieve":
 							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 							break;
 						case "btn_New":
 							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
 							break;
 						case "btn_Excel":
 							if(sheetObject1.RowCount() < 1){//no data
 								ComShowCodeMessage("COM132501");
 							}else{
 								doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 							}
 							
 							break;
	   					case "cre_dt_cal":
	   						var cal=new ComCalendarFromTo();
	   						cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');       						
	   						break; 				
	   					case "eq_no_multi": 
	   					    rep_Multiful_inquiry("eq_no"); 
	   						break;    			
	   					case "tln_multi": 
	   					    rep_Multiful_inquiry("total_loss_no"); 
	   						break;	   
						case "btn_vndr":		      
							ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
							break;			  		
						case "btn_Detail":
							if(sheetObjects[0].RowCount()>0)
							{
								var Row=sheetObjects[0].GetSelectRow();
								var ttl_lss_no=sheetObjects[0].GetCellValue(Row,"ttl_lss_no");
								var rqst_ofc_cd=sheetObjects[0].GetCellValue(Row,"rqst_ofc_cd");
								var apro_ofc_cd=sheetObjects[0].GetCellValue(Row,"apro_ofc_cd");
								var respb_ofc_cd=sheetObjects[0].GetCellValue(Row,"respb_ofc_cd");
								var ttl_lss_dt=sheetObjects[0].GetCellValue(Row,"ttl_lss_dt");
									ttl_lss_dt=ttl_lss_dt.substring(0,4)+ "-" + ttl_lss_dt.substring(4,6)+ "-" + ttl_lss_dt.substring(6,8);
								var rqst_dt=sheetObjects[0].GetCellValue(Row,"rqst_dt");
									rqst_dt=rqst_dt.substring(0,4)+ "-" + rqst_dt.substring(4,6)+ "-" + rqst_dt.substring(6,8);
								var ttl_lss_sts_nm=sheetObjects[0].GetCellValue(Row,"ttl_lss_sts_nm");
								var ttl_lss_rsn_nm=sheetObjects[0].GetCellValue(Row,"ttl_lss_rsn_nm");
								var ttl_lss_dtl_rsn_nm=sheetObjects[0].GetCellValue(Row,"ttl_lss_dtl_rsn_nm");
								var params="?ttl_lss_no="+ttl_lss_no;
								    params+="&rqst_ofc_cd="+rqst_ofc_cd;
								    params+="&apro_ofc_cd="+apro_ofc_cd;
								    params+="&respb_ofc_cd="+respb_ofc_cd;
								    params+="&ttl_lss_dt="+ttl_lss_dt;
								    params+="&rqst_dt="+rqst_dt;
								    params+="&ttl_lss_sts_nm="+ttl_lss_sts_nm;
								    params+="&ttl_lss_rsn_nm="+ttl_lss_rsn_nm;
								    params+="&ttl_lss_dtl_rsn_nm="+ttl_lss_dtl_rsn_nm;
								ComOpenPopup("EES_MNR_0234.do"+params, 1200, 750, '', '1,0', true);
							}
							break;	
							
						case "btn_rulabel_cd":	//RU Label 조회 팝업
							var par_rulabel_type = form.hid_rulabel_type.value;
							var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
							var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
							ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true); 
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
  	 * registering IBCombo Object as list
  	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
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
  	    initControl();    	  
        for(i=0;i<sheetObjects.length;i++){
        	 //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i + 1);
             //
             ComEndConfigSheet(sheetObjects[i]);
        }
        //initializing IBMultiCombo 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	         
	    MnrOfficeLevel(currOfcCd,rhqOfcCd);
 	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     }
      /**   
     	 * setting combo basic info    
     	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
     	 * @param	{Number}	comboNo		ComboObject tag number 
     	 * adding case as numbers of counting combos 
     	 */     
     	function initCombo (comboObj, comboNo) {        
     	    var formObject=document.form
     	    switch(comboNo) {          	    
     	        case 1: 
     	           	with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "80");
						SetColWidth(1, "100");
     			   		SetDropHeight(160);
     					SetUseAutoComplete(1);
     		    	}      
     	        	break;      
     	        case 2: 
     	           	with (comboObj) { 
     				SetMultiSeparator("|");
     				SetTitle("Office Code|Office Name");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
     				//SetColWidth("100|150"); 
     			   	SetDropHeight(160);
     				SetUseAutoComplete(1);
     		    	}      
     	        	break;    
     	        case 3: 
     	           	with (comboObj) { 
     				SetMultiSeparator("|");
     				SetTitle("Office Code|Office Name");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
     				//SetColWidth("100|150");
     			   	SetDropHeight(160);
     				SetUseAutoComplete(1);
     		    	}      
     	        	break;
     	        case 4: 
     	           	with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "80");
						SetColWidth(1, "100");
     			   		SetDropHeight(160);
     			   		SetUseAutoComplete(1);
     		    	}      
     	        	break;   
     	        case 5: 
     	           	with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "80");
						SetColWidth(1, "100");
	     			   	SetDropHeight(160);
	     				SetUseAutoComplete(1);
     		    	}      
     	        	break;    
//      	       case 9: 
//    	    		with(comboObj) {
//	      		  		SetBackColor("#CCFFFA");
//	      	 			SetDropHeight(150);
//	      	 			SetMultiSelect(0);
//	      	 			SetMaxSelect(1);
//	      	 			SetUseAutoComplete(1);
//    	    		}
//    	        	break; 
//    	       case 10: 
//    	      		with(comboObj) {
//	    	   			SetBackColor("#CCFFFA");
//	    	   			SetDropHeight(150);
//	    	   			SetMultiSelect(1);
//	    	   			SetUseAutoComplete(1);
//	    	      	 	SetMultiSeparator(",");
//	    	   			Style=0;
//    	      		}
//    	      		break; 	
     	        	
     	     } 
     	}       
    	function resizeSheet( sheetObj ){
    	    ComResizeSheet( sheetObj );
    	}
    	
        /**
         * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
         * @return
         */
        function rstr_usg_lbl_OnCheckClick(comboObj, index, code) {
        	if(index==0) { 	    	
        		var bChk=comboObj.GetItemCheck(index);
        		if(bChk){
        			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
        				comboObj.SetItemCheck(i,0);
        			}
        		}
        	} else {
        		var bChk=comboObj.GetItemCheck(index);
        		if (bChk) {
        			comboObj.SetItemCheck(0,0);
        		}
        	}
        }
        
        
        /**
         * in case of onChange combo event
         * @param comboObj
         * @param Index_Code
         * @param Text
         * @return
         */
//        function ru_lable_type_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
//        	comboOnChange2(NewIndex,NewText, NewCode);
//        }        
        
        
        /**
         * handling in case of onChange combo event 
         * @param comboObj
         * @param Index_Code
         * @param Text
         * @return
         */   
        function comboOnChange2(NewIndex,NewText,NewCode){ 	
        	
        	var formObj=document.form;
        	comboObjects[9].RemoveAll();
            form.f_cmd.value=SEARCH02;
            var ruLabelType=NewCode;
       //    ruLabelType = comboObjects[9].GetSelectCode();
        	var param="&ru_label_type="+ruLabelType;
        	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
        	var chk=sXml.indexOf("ERROR");
        	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
        		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
        		 return;
        	}	             
        	 
        	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
            var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
             
            comboObjects[9].InsertItem(0 , 'ALL',''); 
            if(strRstrUsgTblNm.length > 1) {
            	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
            		 var arrCode=strRstrUsgTblNm[i].split("|");
            		 comboObjects[9].InsertItem(i+1, arrCode[0], arrCode[0]);
            	}	
            }
            comboObjects[9].SetItemCheck(0,1);
            comboObjects[9].SetEnable(1);
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
               
			              var HeadTitle1="|Seq.|TLL No.|TLL DT|REQ OFC|RES OFC|REQ DT|Status|Completion\nDT|Main Reason|Sub Reason|D.V Expense|D.V Expense|D.V Expense|3rd Party|3rd Party|Disposal|Disposal|EQ No|Agreement No|Contract No|Yard|Lessor|TP/SZ|RU Label Type|RU Label Value|Close Type\nBy EQ|Close Date\nBy EQ";
			              var HeadTitle2="|Seq.|TLL No.|TLL DT|REQ OFC|RES OFC|REQ DT|Status|Completion\nDT|Main Reason|Sub Reason|D.V Value|Pay Amount|Currency|Amount|Currency|Amount|Currency|EQ No|Agreement No|Contract No|Yard|Lessor|TP/SZ|RU Label Type|RU Label Value|Close Type\nBy EQ|Close Date\nBy EQ";
			              var headCount=ComCountHeadTitle(HeadTitle1);
//			              (headCount + 9, 4, 0, true);
			              SetConfig( { SearchMode:2, MergeSheet:7, DataRowMerge:0, FrozenCol:4, PrevColumnMergeMode:0 } );
			              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			              InitHeaders(headers, info);
			              var cols = [   {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					                     {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tmpseq",                 KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"rqst_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"respb_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_rsn_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_dtl_rsn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"dv_dv_val",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"dv_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:75,  Align:"Center",    ColMerge:0,  SaveName:"dv_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"tp_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:75,  Align:"Center",    ColMerge:0,  SaveName:"tp_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"ds_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:75,  Align:"Center",    ColMerge:0,  SaveName:"ds_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"rqst_eq_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",    ColMerge:0,   SaveName:"agmt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",    ColMerge:0,   SaveName:"ctrt_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",    ColMerge:0,   SaveName:"crnt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"lessor_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",    ColMerge:0,   SaveName:"eq_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:80,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_tp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_val",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_dtl_cmpl_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_dtl_cmpl_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//					                     {Type:"Float",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"sc_exp",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
//					                     {Type:"Float",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ir_exp",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_dtl_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];             
			              
			              
			              InitColumns(cols);
			              SetEditable(1);
//			              SetSheetHeight(382);
			              resizeSheet( sheetObj );
                    }
                break;
         }
     }
   // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieving
 				if(validateForm(sheetObj,formObj,sAction))
   					if (sheetObj.id == "sheet1"){
   						formObj.f_cmd.value=SEARCH;     						
   						sheetObj.DoSearch("EES_MNR_0102GS.do",FormQueryString(formObj) );
   					}
           		break;
  			case IBCLEAR:        //initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//initializing combo
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}
					var sCondition=new Array (
							new Array("MnrGenCd","TR", "COMMON")	 //Main Reason 
						   ,new Array("MnrGenCd","","CUSTOM9")  //EQ Type 
						   ,new Array("MdmOrganization","RHQ","FALSE") //Regional HQ
						   ,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
						   ,new Array("ComIntgCd","CD20097", "COMMON") // RU TYPE	
					);   
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					for(var i=0; i<comboList.length; i++)
					{	
						if(comboList[i] != null)
						{
							for(var j=0; j < comboList[i].length;j++)
							{   
								var xmlVal=comboList[i][j].split("|");  
								if(i==0){
									rsn_cd.InsertItem(j, xmlVal[1] ,xmlVal[0]);
								} else if(i==1){
									combo_eq_kind.InsertItem(j, xmlVal[1] , xmlVal[0]);
								} else if(i==2){
									combo_rhq.InsertItem(j, comboList[i][j], xmlVal[0]);
								} else if(i==3){
									ttl_lss_cmpl_cd.InsertItem(j, xmlVal[1] , xmlVal[0]);
								} 
//								else if(i==4){
//									ru_lable_type.InsertItem(j, xmlVal[1] , xmlVal[0]);
//								}		
							}			
							if(i==0){
								rsn_cd.InsertItem(0, "ALL" ,"A");
								rsn_cd.SetSelectCode("A");
							} else if(i==1){
								combo_eq_kind.InsertItem(0, "ALL" ,"A");
								combo_eq_kind.SetSelectCode("A");
								formObj.eq_kind.value=combo_eq_kind.GetSelectCode();
							} else if(i==2){
								combo_rhq.InsertItem(0, "ALL" ,"A");  
							} else if(i==3){ 
								ttl_lss_cmpl_cd.InsertItem(0, "ALL" ,"A"); 
							} 
//							else if(i==4){ 
//								ru_lable_type.InsertItem(0, "ALL" ,"ALL"); 
//								ru_lable_type.Index = 0;
//							}
						}
						else
						{		
							if(i==0){	
								ComShowCodeMessage("MNR00005", "Main Reason");
							}else if(i==1){	
								ComShowCodeMessage("MNR00005", "EQ Type");
							}else if(i==2){
								ComShowCodeMessage("MNR00005", "Regional HQ");
							}else if(i==3){
								ComShowCodeMessage("MNR00005", "Close Type");
							}else if(i==4){
								ComShowCodeMessage("MNR00005", "RU Type");
							}
						}
					}		
					
					if(strMnrOfficeLevel=="L1"){
						combo_rhq.SetSelectCode("A");
					} else {
						combo_rhq.SetSelectCode(rhqOfcCd);
					}
					
					formObj.rhq.value=combo_rhq.GetSelectCode();
					formObj.ofc_cd.value=combo_office.GetSelectCode();
					in_status_tp.RemoveAll();
					in_status_tp.InsertItem(0, "ALL"," ");					
					in_status_tp.InsertItem(1, "Save","S");			
					in_status_tp.InsertItem(2, "Request","R");
					in_status_tp.InsertItem(3, "Processing","P");
					in_status_tp.InsertItem(4, "Complete ","C");
					in_status_tp.SetSelectIndex(0);
					initLoader=1;	
				}
				//initializing sheet   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();
		        }  
		 		combo_eq_kind.SetSelectCode("A");
//		 		combo_rhq.SetSelectCode("A");
//		 		combo_office.SetSelectCode("A");
		 		rsn_cd.SetSelectCode("A");
		 		ttl_lss_cmpl_cd.SetSelectCode("A");
		 		formObj.eq_no.value="";
		 		formObj.total_loss_no.value="";
				in_search_dt_tp.RemoveAll();
//		 		ru_lable_type.SetSelectCode("ALL");
				formObj.rstr_usg_lbl.value = "";
				in_status_tp.SetSelectIndex(0);
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value = "";
				in_search_dt_tp.SetEditFontBold(1);
				in_search_dt_tp.InsertItem(0, "Creation Date","R");
				in_search_dt_tp.InsertItem(1, "Total Loss Date","C");
				in_search_dt_tp.InsertItem(2, "Complete Date","E");		
				in_search_dt_tp.SetSelectCode("R",false);
				formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_dt.value=ComGetNowInfo();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);    			
				break;
   			case IBDOWNEXCEL:
   					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
   				break;	
			case IBSEARCH_ASYNC01:	//retrieving(in case of existing Lessor.)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//retrieving service provider     
					var sCondition=new Array ( 	 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
					)  	                           
					//setting in case of existing retrieving result	
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
					if(comboList[0] != null){	  
						var tempText=comboList[0][0].split("|");  
						formObj.vndr_nm.value=tempText[1];   
					} else {		        
						ComShowCodeMessage("MNR00005", "Lessor");              
						ComSetObjValue(formObj.vndr_nm, "");  
						ComSetObjValue(formObj.vndr_seq, ""); 
						ComSetFocus(formObj.vndr_seq);	
					}		  
				}			
				break;				 				
         }	
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
      /**
       * OnChange event on combo_eq_kind
       * @param comboObj
       * @param Index_Code
       * @param Text
       * @return
       */   
      function comboOnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
      		var formObj=document.form;
      		combo_office.RemoveAll();
    		var sCondition=new Array (
    				new Array("MdmOrganization","SEARCH",newCode)   //Office
    			);   
    		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
	       	if(comboList[0] != null){
	      	 	for(var i=0; i < comboList[0].length;i++){ 
	      		 	   var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
	      	 		   combo_office.InsertItem(i, comboList[0][i] , code);			   
	      	 	}
	      	 	combo_office.InsertItem(0, "ALL" , "A");
	      	 	combo_office.SetSelectCode("A");
	       	}
      }         
   	/**  
   	 * rsn_cd Change event      
   	 * @param {IBMultiCombo}  comboObj ComboObject  
   	 * @param  {String}    Index_Code   Index or Code
   	 * @param  {String}    Text
   	 */  
   	function rsn_cd_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
   		var formObj=document.form;        
		//initializing Sub Reason
		var ttlLssDtlRsnCdObj=ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll();
		ttlLssDtlRsnCdObj.InsertItem(0, "ALL" ,"A");    
		//checking Main Reason 	
		if(oldCode == "A" || oldCode == "") {
			ttlLssDtlRsnCdObj.SetSelectCode("A");
			return;		
		}	 	
		//retrieving Sub Reason 		
		var sCondition=new Array (	
			new Array("MnrGenCd",rsn_cd.GetSelectCode(), "COMMON") 		
		)      
		sheetObjects[0].SetWaitImageVisible(0);
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].SetWaitImageVisible(1);
		for(var j=0; j < comboList[0].length;j++){ 	
			var tempText=comboList[0][j].split("|");   	  
			ttlLssDtlRsnCdObj.InsertItem(j + 1, tempText[1] ,tempText[0]);
		}	
		ttlLssDtlRsnCdObj.SetSelectCode("A");
   	}        
	/**  
	 * combo_eq_kind Change event      
	 * @param {IBMultiCombo}  comboObj ComboObject  
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */  
	function combo_eq_kind_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		var formObj=document.form;        
		formObj.eq_kind.value=combo_eq_kind.GetSelectCode();
	} 
   	/**  
   	 * combo_rhq Change event      
   	 * @param {IBMultiCombo}  comboObj ComboObject  
   	 * @param  {String}    Index_Code   Index or Code
   	 * @param  {String}    Text
   	 */  	
   	function combo_rhq_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;       
//   		if(oldCode==""){
//   			combo_rhq.SetSelectCode("A");
//   		}
   		if(combo_rhq.GetSelectCode()=="A"){
   			formObj.rhq.value="A"; 
   			newCode = "A";
   		}else{
   			formObj.rhq.value=combo_rhq.GetSelectCode();
   		}
   		comboOnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode);   		 
   	}  	 
   	/**  
   	 * combo_office Change event      
   	 * @param {IBMultiCombo}  comboObj ComboObject  
   	 * @param  {String}    Index_Code   Index or Code
   	 * @param  {String}    Text
   	 */  
   	function combo_office_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
 		var formObj=document.form;     
 		if(oldCode==""){
 			combo_office.SetSelectCode("A");
		}
		if(combo_office.GetSelectCode()=="A"){
			formObj.ofc_cd.value=""; 
		}else{
			formObj.ofc_cd.value=combo_office.GetSelectCode();
		}
   	}   	   	
 	function initControl() { 		 
	    //Axon handling event1. event catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
//	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
	    axon_event.addListenerFormat('change',	 'obj_change',		form); 			
	}		 	 	         
	/**
	 * HTML Control deactivate event <br>
	 **/
	function obj_deactivate(){    
		obj=ComGetEvent();       
	    ComChkObjValid(ComGetEvent()); 
	} 
	/**
	 * HTML Control activate event <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}  
	function obj_change(){	     
		var obj=ComGetEvent(); 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {				       
	    		case "vndr_seq":		  
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);	
				   	break;			   
			}	 	      
	    } else {					
			switch(ComGetEvent("name")) {			      
	    		case "vndr_seq":    
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;					 		 		 	
			}	 	 		
		}			
	} 		   
	/**
	 * HTML Control keypress event <br>
	 **/     
//	function obj_keypress(){     
//	    obj=event.srcElement;    
//	    if(obj.dataformat == null) return; 
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {  
//	        case "ymd":   
//	        case "int":    
//				ComKeyOnlyNumber(obj); 
//	            break;     
//	        case "float":   
//	            ComKeyOnlyNumber(obj, ".");
//	            break; 
//	        case "eng":   
//	            ComKeyOnlyAlphabet();
//				break;   
//	        case "engup": 
//	        	ComKeyOnlyAlphabet('uppernum');   
//	        break;	  
//	    }
//	} 
	/**
	 * (Service Provider) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index 
	 */		
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form; 	    
		if ( aryPopupData.length > 0 ) {		 
			formObj.vndr_seq.value=ComLpad(aryPopupData[0][2],6,"0");   
			formObj.vndr_nm.value=aryPopupData[0][4];	
		}			
	}	
 	/**
 	 * getting rep_Multiful_inquiry  
 	 *           
 	 * Location : in case of Single choice     
 	 */      
 	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;  
 		var tempText=""; 	
 		//initializing	   
 		if(return_val == "eq_no"){
 			formObj.eq_no.value='';
 		}else{
 			formObj.total_loss_no.value='';
 		}
 		for(var i=0; i<rowArray.length; i++) {   
 			var colArray=rowArray[i];     
 			tempText +=  rowArray[i] + ','; 	  
 		}      
 		//clearing comma(,)     
 		tempText=MnrDelLastDelim(tempText);	 
 		tempText=tempText.toUpperCase(); 	            
 		eval("document.form." + return_val + ".value='" + tempText + "';"); 
 	}
 	
 	
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		
 		if(sheetObj.RowCount() > 0){
 			
 //			sheetObj.SetRangeBackColor(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FFA7A7");
 //			sheetObj.SetRangeFontBold(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);
  			
 			with(sheetObj){
 				SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
 				SetSumText(0, "ttl_lss_no","Total");
 				SetCellAlign(0, "ttl_lss_no","Center");
 				
//				SetSumValue(0,"dv_eq_qty", ComAddComma(GetCellValue(LastRow()-1, "dv_eq_qty")));
//				SetSumValue(0,"dv_dv_val", ComAddComma(GetCellValue(LastRow()-1, "dv_dv_val")));
//				SetSumValue(0,"dv_exp", ComAddComma(GetCellValue(LastRow()-1, "dv_exp")));
//				SetSumValue(0,"dv_bal", ComAddComma(GetCellValue(LastRow()-1, "dv_bal")));
//				SetSumValue(0,"dv_recovery", ComAddComma(GetCellValue(LastRow()-1, "dv_recovery")));
//				SetSumValue(0,"tp_eq_qty", ComAddComma(GetCellValue(LastRow()-1, "tp_eq_qty")));
//				SetSumValue(0,"dv_balance", ComAddComma(GetCellValue(LastRow()-1, "dv_balance")));
//				SetSumValue(0,"tp_exp", ComAddComma(GetCellValue(LastRow()-1, "tp_exp")));
//				SetSumValue(0,"ds_eq_qty", ComAddComma(GetCellValue(LastRow()-1, "ds_eq_qty")));
//				SetSumValue(0,"ds_exp", ComAddComma(GetCellValue(LastRow()-1, "ds_exp")));
//				SetSumValue(0,"clt_amt", ComAddComma(GetCellValue(LastRow()-1, "clt_amt")));
//				RowDelete(LastRow()-1, 0);
				
			//	SetSumText(0,"dv_recovery", GetCellValue(LastRow()-1, "dv_balance"));
			//	alert(GetCellValue(LastRow()-1, "dv_recovery"));
			//	alert(GetCellValue(LastRow()-1, "dv_exp"));
			//	alert(GetCellValue(LastRow(), "dv_recovery")-GetCellValue(LastRow() "ds_exp"));
			//	SetSumValue(0,"dv_balance", GetCellValue(LastRow()-1, "dv_recovery")-GetCellValue(LastRow()-1, "dv_exp"));
 			//	RowDelete(LastRow()-1, 0);
				

 				
 			}
 			
 		}
 	}
 	
 	function ComToHtml2(obj){
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var str = getArgValue(obj);

            str = str.replace(/&/gi, "@amp;");
            return str;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

	/* developer job */
