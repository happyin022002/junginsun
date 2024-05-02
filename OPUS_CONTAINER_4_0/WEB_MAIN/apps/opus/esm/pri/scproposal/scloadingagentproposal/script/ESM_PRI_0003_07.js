/*=========================================================
* 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_07.js
*@FileTitle  :  S/C Proposal Loading Agent Creation
*@author     : CLT
*@version    : 1.0
*@since      : 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0003_07 : business script for ESM_PRI_0003_07 
     */
    // global variables 
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var tabLoad=new Array();
 tabLoad[0]=0;
 tabLoad[1]=0;
 var opener;
//Event handler processing by button click event */
 document.onclick=processButtonClick;
/**
  * Event handler processing by button name 
  */
 function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
			case "btn_retrieve":
				if(validateForm(sheetObject1,formObject,IBSEARCH)) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} 
				break;
			case "btn_save":
				if(validateForm(sheetObject1,formObject,IBSAVE)) {
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				}
				break;
			case "btn_acceptall":
				if(validateForm(sheetObject1,formObject,MODIFY01)) {
					doActionIBSheet(sheetObject1,formObject,MODIFY01);
				}
				break;
			case "btn_cancelall":
				if(validateForm(sheetObject1,formObject,MODIFY02)) {
					doActionIBSheet(sheetObject1,formObject,MODIFY02);
				}
				break;
			case "btn_rowadd":
				if(validateForm(sheetObject1,formObject,IBINSERT)) {
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				}
				break;
			case "btn_delete":
				if(validateForm(sheetObject1,formObject,IBDELETE)) {
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				}
				break;	
			case "btn_amend":
				if(validateForm(sheetObject1,formObject,COMMAND01)) {
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
				}
				break;
			case "btn_amendcancel":
				if(validateForm(sheetObject1,formObject,COMMAND02)) {
					doActionIBSheet(sheetObject1,formObject,COMMAND02);
				}
				break;
			case "btn_accept":
				if(validateForm(sheetObject1,formObject,MODIFY03)) {
					doActionIBSheet(sheetObject1,document.form,MODIFY03);
				}
				break;
			case "btn_acceptcancel":
				if(validateForm(sheetObject1,formObject,MODIFY04)) {
					doActionIBSheet(sheetObject1,document.form,MODIFY04);
				}
				break;
        } // end switch
	}catch(e) {
		if (e == "[object Error]") {
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
      * Initializing and setting Sheet basics<br> 
      * Setting body tag's onLoad event handler<br>
      * Adding pre-handling function after loading screen on the browser <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return N/A
      * @author 
      * @version 
      */
     function loadPage() {
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
         buttonControl();
         opener.loadTabPage();
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var formObj=document.form;
         switch(sheetID) {             
             case "sheet1":
                 with(sheetObj){
		                 
		              var HeadTitle="|Sel.|Seq.|lodg_agn_seq|amdt_seq|Customer Code|Customer Code|Customer Name|Address|Location|EFF Date|EXP Date|Source|Status" +
		              "|1|2|3|4|5";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Seq",        Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                  {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lodg_agn_seq" },
		                  {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                  {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, InputCaseSensitive:1, AcceptKeys:"E"  },
		                  {Type:"PopupEdit",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 , AcceptKeys:"N", InputCaseSensitive:1},
		                  {Type:"Text",       Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",       Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                  {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Combo",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Combo",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                  {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                  {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl" },
		                  {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl" },
		                  {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
		               
		              InitColumns(cols);	
		              SetEditable(1);
		              SetEllipsis(1);
		              SetWaitImageVisible(0);
		              SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
		              SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
		              SetShowButtonImage(2);
		              //SetAutoRowHeight(1);
		              resizeSheet(); //SetSheetHeight(290);
              }
                break
         }
     }
     
     function resizeSheet() {
 	 	ComResizeSheet(sheetObjects[0]);
 	 }
	  /**
	   * Handling sheet process<br>
	   */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          switch(sAction) {
	 	        case IBSEARCH: 
	  				ComOpenWait(true);
	 	         	formObj.f_cmd.value=SEARCH;
	 	         	sheetObj.DoSearch("ESM_PRI_0003_07GS.do", FormQueryString(formObj) );
	 				break;
	  			case IBSAVE:         			
		  			if(ComShowCodeConfirm("PRI00001")) {	
		  				ComOpenWait(true);
			  			formObj.f_cmd.value=MULTI01;
						var sParam=FormQueryString(formObj);
		  				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_07GS.do", sParam);
		  				sheetObj.LoadSaveData(sXml);
		  				doActionIBSheet( sheetObj , formObj , IBSEARCH );
		  			}
	 				break;
	  			case IBINSERT:       // Row Add
	  				var prop_no=formObj.prop_no.value;
					var amdt_seq=formObj.amdt_seq.value; 
					var svc_scp_cd=formObj.svc_scp_cd.value;
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					if(amdt_seq == 0){
						var idx=sheetObj.DataInsert();
						sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
						sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
						sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "lodg_agn_seq",parseInt(ComPriGetMax(sheetObj, "lodg_agn_seq"))+ 1,0);
						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObj.SelectCell(idx, "cust_cnt_cd");
					}else{
						if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
							ComShowCodeMessage("PRI01002");		
						 	return;
						}							
						var idx=sheetObj.DataInsert();
						sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
						sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
						sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "lodg_agn_seq",parseInt(ComPriGetMax(sheetObj, "lodg_agn_seq"))+ 1,0);
						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObj.SelectCell(idx, "cust_cnt_cd");
						sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
					}
	 				break;
	  			case IBDELETE: // Delete
	 				var eff_dt=formObj.eff_dt.value;
	 				var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					for(var i=0;i < chkArr.length;i++){
						if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq
								||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq
										&& (sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
							ComShowCodeMessage("PRI01002");
							return;
						}
					}
					var sRow=0;
					for(var j=0;j < chkArr.length;j++){
						if(sheetObj.GetCellValue(Number(chkArr[j])+sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
							comSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow,"D","cust_cnt_cd|cust_seq|cust_nm|cust_loc_cd");	
							sRow++;								
						}
					}
					deleteRowCheck(sheetObj, "chk");
					break;
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {
		  				formObj.f_cmd.value=MULTI02;
		  				comSheetAcceptCheckedRows(sheetObj,document.form,"ESM_PRI_0003_07GS.do",true);
		  				opener.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
					}
	 				break;
	  			case MODIFY02: // Cancel 
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				formObj.f_cmd.value=MULTI03;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_07GS.do", true);
		  				opener.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
					}
	 				break;		
	  	      	case MODIFY03: // Accept
		  	      	if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value=MULTI04;
		  				comSheetAcceptCheckedRows(sheetObjects[0],document.form,"ESM_PRI_0003_07GS.do",false);
		  				opener.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
		  	      	}
	  				break;
	  	      	case MODIFY04: // Accept Cancel
		  	      	if(ComShowCodeConfirm("PRI00009")) {
		 				formObj.f_cmd.value=MULTI05;
		  	      		comSheetAcceptCancelCheckedRows(sheetObjects[0],document.form,"ESM_PRI_0003_07GS.do",false);
		  	      		opener.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
		  	      	}
	 				break;			
	 			case COMMAND01: // Amend
	 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	 				if(chkArr.length > 0){
	 					if(chkArr.length > 1){					
	 						ComShowCodeMessage("PRI00310");
	 					}else{					
	 						comSheetAmendRow(sheetObjects[0],document.form,sheetObjects[0].GetSelectRow(),"M", "cust_cnt_cd|cust_seq");
	 					}
	 				}else{ 					
	 					comSheetAmendRow(sheetObjects[0],document.form,sheetObjects[0].GetSelectRow(),"M", "cust_cnt_cd|cust_seq");
					}
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "cust_cnt_cd");
	 				break;		
	 			case COMMAND02: // Amend Cancel
	 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	 				if(chkArr.length > 0){
	 					if(chkArr.length > 1){					
	 						ComShowCodeMessage("PRI00310");
	 					}else{
	 						comSheetAmendCancelRow(sheetObjects[0],document.form,sheetObjects[0].GetSelectRow(),"M", "cust_cnt_cd|cust_seq|cust_nm|cust_loc_cd");
	 						sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_cnt_cd",0);
	 						sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_seq",0);
	 						sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_loc_cd",0);
	 					}
	 				}else{ 
	 					comSheetAmendCancelRow(sheetObjects[0],document.form,sheetObjects[0].GetSelectRow(),"M", "cust_cnt_cd|cust_seq|cust_nm|cust_loc_cd");
	 					sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_cnt_cd",0);
						sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_seq",0);
						sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cust_loc_cd",0);
	 				}
	 				break;
	          }
    	  }catch(e){
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e.message);
    			}
    		}finally {
    			 ComOpenWait(false);
    		}
      }
      /**
       * registering IBTab Object as array
       * adding process for list in case of needing batch processing with other items 
       * defining list on the top of source
       */
      function setTabObject(tab_obj){
          tabObjects[tabCnt++]=tab_obj;
      }
      /**
      * checking validation process of inputted form data <br>
      */
       function validateForm(sheetObj,formObj,sAction){
    		switch (sAction) {
	   		case IBSEARCH: 	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   		case IBSAVE: 
				if (!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
	 	  		if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
	 				return false;
	 			}
	   			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	   				// not checking pre SEQ
	   				if(sheetObj.GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	   					continue;
	   				}
	   				// not mandatory checking all items when Amend Delete
	   				if(sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
	   					continue;
	   				}
   					if(sheetObj.GetCellValue(i, "cust_cnt_cd") == "") {
   						ComShowCodeMessage("PRI08010", i, "Customer Code");
   						sheetObj.SelectCell(i, "cust_cnt_cd");
   						return false;
   					} else if(sheetObj.GetCellValue(i, "cust_seq") == "") {
   						ComShowCodeMessage("PRI08010", i, "Customer Code");
   						sheetObj.SelectCell(i, "cust_seq");
   						return false;
   					} else if(sheetObj.GetCellValue(i, "cust_nm") == "") {
   						ComShowCodeMessage("PRI08010", i, "Customer Name");
   						sheetObj.SelectCell(i, "cust_nm");
   						return false;
   					}
	   			}
				if (sheetObjects[0].IsDataModified()) {
					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "cust_cnt_cd|cust_seq|cust_nm", formObj.amdt_seq.value);
					if (dupRow >= 0) {
						sheetObjects[0].SetSelectRow(dupRow);
			             ComShowCodeMessage("PRI00302");
			             return false;
					}
				}				
	   			break;
	   		case IBINSERT: // Row Add
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   		case IBDELETE: // Delete  	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	   			break;
	   		case MODIFY01: // Accept All
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
				if (getValidRowCount(sheetObj) <= 0) {
		            return false;
				}
	 			break;
	   		case MODIFY02: // Cancel
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
				if (getValidRowCount(sheetObj) <= 0) {
		            return false;
				}
	 			break;	
			case MODIFY03: // Accept
				var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
				if(chkArr.length == 0){
					if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
				}	
				chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
				for(var i=0;i < chkArr.length;i++){
					if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
						ComShowCodeMessage("PRI01037");
						return false;
					}
				}
				break;
			case MODIFY04: // Accept cancel
				var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
				if(chkArr.length == 0){
					if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
				}	
				chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
				for(var i=0;i < chkArr.length;i++){
					if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
						ComShowCodeMessage("PRI00313");
						return false;
					}
					if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
						ComShowCodeMessage("PRI01038");
						return false;
					}
				}
				break;	
	   		case COMMAND01: // Amend	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	 			break;
	   		case COMMAND02: // Amend Cancel	
	 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
	 				return false;
	 			}
	 			break;
	   		}     
    		return true;
       }
       /**
        * handling event in case of specific cell on the sheet selected <br>
        * showing different color Amend Row's Highlight <br>
        */     
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
            if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
            }
        } 
        /**
        * calling function when occurring OnChange Event <br> 
        * when selecting multi comboBox, showing description and retrieveing validation <br>
        */ 	
   		  function sheet1_OnChange(sheetObj, Row, Col, Value){
             	var colname=sheetObj.ColSaveName(Col);
             	var formObj=document.form
             	switch(colname)
             	{
	             	case "cust_cnt_cd":
	             		if (Value.length != 2){
	             			ComShowCodeMessage("PRI00315");
	             			sheetObj.SelectCell(Row, "cust_cnt_cd");
	             		} else {
	             			sheetObj.SetCellValue(Row,"cust_seq","",0);
	             		}
	     	    		break;
         	    	case "cust_seq":
         	    		if (Value.length > 0 && sheetObj.GetCellValue(Row,"cust_cnt_cd").length == 2){
         	    			formObj.f_cmd.value=SEARCH01;
         	    			formObj.cust_cnt_cd.value=sheetObj.GetCellValue(Row,"cust_cnt_cd");  
         	    			formObj.cust_seq.value=sheetObj.GetCellValue(Row,"cust_seq");         	    			
         	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", FormQueryString(formObj)+"&nmd_cust_flg=N");
	       	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");
         					if (arrData != null){
         						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0],0);
         						sheetObj.SetCellValue(Row,"cust_addr",arrData[0][1],0);
         						sheetObj.SetCellValue(Row,"cust_loc_cd",arrData[0][2],0);
         						//putting '0' in front of CUST_SEQ
                 	    		if (Value.length < 6 && Value.length != 0){	 	    		
                	 	    		sheetObj.SetCellValue(Row,"cust_seq",ComLpad(Value, 6, "0"),0);
                	 	    	}
         					}else{
         						ComShowCodeMessage("PRI00315");
         						locationCellClear(sheetObj,Row);
         					}
         					//changing customer name, address, location impossible, when customer Code exists
             	    		//sheetObj.CellEditable(Row,"cust_nm") = false;
            	   	  		sheetObj.SetCellEditable(Row,"cust_loc_cd",0);
         	    		} else {
         	    			ComShowCodeMessage("PRI00315");
         	    			locationCellClear(sheetObj,Row);
         	    			//sheetObj.CellEditable(Row,"cust_nm") = false;
            	   	  		sheetObj.SetCellEditable(Row,"cust_loc_cd",1);
         	    		}
         	    		break;
         	    	case "cust_loc_cd":
         	    		if (Value.length==5){
         	    			formObj.f_cmd.value=SEARCH05;
         	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);       	    			
         	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	       	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
         					if (arrData == null){
         						//ComShowCodeMessage("PRI00315");
         						sheetObj.SetCellValue(Row,"cust_loc_cd","",0);
         					}	  				
         	    		} else {
         	    			//ComShowCodeMessage("PRI00315");
         	    			sheetObj.SetCellValue(Row,"cust_loc_cd","",0);
         	    		}
         	    		break;         	    		
             	}
             }
   	    /**
   	     * initializing specific cell of the sheet  <br>
   	     */  
   	  	function locationCellClear(sheetObj,Row){
   	  		sheetObj.SetCellEditable(Row,"cust_seq",1);
   	  		sheetObj.SetCellEditable(Row,"cust_cnt_cd",1);
    		sheetObj.SetCellValue(Row,"cust_seq","",0);
   	  		sheetObj.SetCellValue(Row,"cust_cnt_cd","",0);
   	  		sheetObj.SetCellValue(Row,"cust_nm","",0);
   	  		sheetObj.SetCellValue(Row,"cust_addr","",0);
   	  		sheetObj.SetCellValue(Row,"cust_loc_cd","",0);
   	  		sheetObj.SelectCell(Row, "cust_cnt_cd");
   	  	}   
   	    /**
   	     * calling function when occurring OnSaveEnd event <br>
   	     * showing the save completion message in case of successful saving
   	     */ 		
   	   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
   	    	var formObj=document.form;   				
   	    	opener.comUpdateProposalStatusSummary("15", formObj.svc_scp_cd.value);
   		} 
   	   	
	   	function tmp_object(sheet, row){
	  		this.row = row;
	  		this.sheet = sheet;
	  	}
	  	var G_TMP_OBJECT;
  	
   	     /**
  	    * sheet1 OnPopupClick event function <br>
  	    * calling Location PopUp<br>
  	    */  	      	 
 	 	function sheet1_OnPopupClick(sheetObj, Row, Col)
 	 	{
 	 		var colName=sheetObj.ColSaveName(Col);
 	 		var formObj=document.form;
 	 		G_TMP_OBJECT = new tmp_object(sheetObj, Row);
 	       	switch(colName)
 	       	{
 	   	    	case "cust_seq":		
 	   	    		var sUrl="ESM_PRI_4014_POP.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.GetCellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
 	   	    		ComOpenPopup(sUrl, 640, 300, "sheet1_returnVal", "none", true);
 	   	    		break;
 	       	}
 	 	} 
 	 	
 	 	function sheet1_returnVal(rtnVal) {
 	 		var sheetObj = G_TMP_OBJECT.sheet;
 	 		if (rtnVal != null){
	  				sheetObj.SetCellValue(G_TMP_OBJECT.row, "cust_cnt_cd",rtnVal.custCntCd,0);
	  				sheetObj.SetCellValue(G_TMP_OBJECT.row, "cust_seq",ComLpad(rtnVal.custSeq, 6, "0"),0);
	  				sheetObj.SetCellValue(G_TMP_OBJECT.row, "cust_nm",rtnVal.custNm,0);
	  				sheetObj.SetCellValue(G_TMP_OBJECT.row, "cust_addr",rtnVal.Addr,0);
	  				sheetObj.SetCellValue(G_TMP_OBJECT.row, "cust_loc_cd",rtnVal.LocCd,0);
	  			}
 	 	}
		 /**
		* calling function when occurring OnClick Event <br>
		* showing memo pad when mutiple lines
		*/
   	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
   		    var colname=sheetObj.ColSaveName(Col);
   		    var amdtSeq=document.form.amdt_seq.value;
   		    var sts=document.form.prop_sts_cd.value;
   		    var readOnly=false;
   	     	switch(colname)
   	     	{
   	 	    	case "cust_addr":
    				readOnly=true;
	 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 200);
	 	    		break;
   	 	    	case "cust_nm":
    				readOnly=true;
	 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 285);
	 	    		break;
   	     	}    	 
   	    }
   	    /**
    * calling function when click the tab of parent screen <br> 
    * showing retrieved data
    */ 
  		function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
  			var formObject=document.form;
  			if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
  				formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
  				formObject.prop_no.value=sPropNo;
  				formObject.amdt_seq.value=sAmdtSeq;
  				formObject.svc_scp_cd.value=sSvcScpCd;
  				formObject.pre_amdt_seq.value=sPreAmdtSeq;
  				formObject.prop_sts_cd.value=sPropStsCd; 
  				formObject.eff_dt.value=sEffDt;
  				formObject.exp_dt.value=sExpDt;			
  				formObject.pre_exp_dt.value=sPreExpDt ;
  				formObject.req_usr_flg.value=sIsReqUsr ;
  				formObject.apro_usr_flg.value=sIsAproUsr ;	
  	 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
	 			formObject.dur_dup_flg.value="Y" ;
  				buttonControl();
  				doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
  			}
  		}
	    /**
	    * initializing sheet and variables in the page
	    */
  		function tabClearSheet() {
  			var formObject=document.form;
 			formObject.prop_no.value="";
			formObject.amdt_seq.value="";
			formObject.svc_scp_cd.value="";
			formObject.pre_amdt_seq.value="";
			formObject.prop_sts_cd.value="";
			formObject.eff_dt.value="";
			formObject.exp_dt.value="";
			formObject.pre_exp_dt.value="";
			formObject.req_usr_flg.value="";
			formObject.apro_usr_flg.value="";
 			formObject.lgcy_if_flg .value="";
 			formObject.dur_dup_flg.value="";
  			sheetObjects[0].RemoveAll();
 			buttonControl("CLEAR");
  		}
  		var enableFlag=true;
 		/**
 	     * calling from main screen  <br>
 	     * prohibiting input, modify, delete in case of Confirmation = YES <br>
 	     */
  		function tabEnableSheet(flag) {
  			var formObject=document.form;
  			enableFlag=flag;
  			sheetObjects[0].SetEditable(flag);
  		}
  		/**
  	     * button authority control function by button status<br>
  	     */
  	 	function buttonControl(mode){
  			var formObj=document.form;
  			var req_usr_flg=formObj.req_usr_flg.value;
  			var apro_usr_flg=formObj.apro_usr_flg.value;
  			var amdt_seq=formObj.amdt_seq.value;
  			var sts=formObj.prop_sts_cd.value;
  			var row_cnt=sheetObjects[0].RowCount();
  			try{		
  				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_delete");				
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				if(amdt_seq > 0){
					showButton("btn_amend");
					showButton("btn_amendcancel");
					ComBtnDisable("btn_amendcancel");
					ComBtnDisable("btn_amend");
				} else {
					hiddenButton("btn_amend");
					hiddenButton("btn_amendcancel");
				}
				if(mode == "CLEAR") {
					return;
				}
  				switch(sts) {
  					case 'I':   // Initial
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" || req_usr_flg=="true" ){
  							ComBtnEnable("btn_save");
  							ComBtnEnable("btn_rowadd");
  							ComBtnEnable("btn_delete");
  							ComBtnEnable("btn_amend");
  							ComBtnEnable("btn_amendcancel");
  							if(amdt_seq > 0){
  								showButton("btn_amend");
  								showButton("btn_amendcancel");
  							}
  						}				
  						break;
  					case 'Q':   // Requested
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" ){
  							ComBtnEnable("btn_acceptall");
  							ComBtnEnable("btn_cancelall");
  							ComBtnEnable("btn_accept");
  							ComBtnEnable("btn_acceptcancel");
  						}
  						break;
  					case 'R':   // Returned
  		  				ComBtnEnable("btn_retrieve");
  						if(apro_usr_flg=="true" || req_usr_flg=="true" ){
  							ComBtnEnable("btn_accept");
  							ComBtnEnable("btn_acceptcancel");
  						}				
  						break;
  					case 'A':   // Approved
  		  				ComBtnEnable("btn_retrieve");
  					case 'F':   // Filed
  		  				ComBtnEnable("btn_retrieve");
  					case 'C':   // Cancled
  		  				ComBtnEnable("btn_retrieve");
  						break;		
  				}	
  			} catch (e) {
  				if (e == "[object Error]") {
  					ComShowMessage(OBJECT_ERROR);
  				} else {
  					ComShowMessage(e.message);
  				}
  			}
  		}
  	     /**
  	      * OnSearchEnd event function <br>
  	      */
 	    function sheet1_OnSearchEnd(sheetObj, errMsg){
 	    	manageGetCellEditable(sheetObj);
 		} 
  
 		/**
	     * changing SHEET's CELL editable  <br>
	     */
	     function manageGetCellEditable(sheetObj) {
	    	 var formObj=document.form;
	    	 var amdtSeq=formObj.amdt_seq.value;
	    	 var propStsCd=formObj.prop_sts_cd.value;
	    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
	    	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
	    		  // DISABLE in case of different AMDT_SEQ
	    		 if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq){
	    			 sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(), true);
	    			  sheetObj.SetRowEditable(i,0);
	    		  }
	    		  if(amdtSeq == 0) {
    				  sheetObj.SetCellEditable(i, "cust_cnt_cd",1);
    				  sheetObj.SetCellEditable(i, "cust_seq",1);
    				  sheetObj.SetCellEditable(i, "cust_loc_cd",0);
	    		  } else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
	    			  // setting red color in case of same EFF_DT based on existing AMEND
	    			  sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
	    			  if (sheetObj.GetCellValue(i, "src_info_cd") == "AM"){
    					  sheetObj.SetCellEditable(i, "cust_cnt_cd",1);
    					  sheetObj.SetCellEditable(i, "cust_seq",1);
    					  sheetObj.SetCellEditable(i, "cust_loc_cd",0);
	    			  } else if (sheetObj.GetCellValue(i, "src_info_cd") == "AD"){
	    				  sheetObj.SetCellEditable(i, "cust_cnt_cd",0);
	    				  sheetObj.SetCellEditable(i, "cust_seq",0);
	    				  sheetObj.SetCellEditable(i, "cust_loc_cd",0);
	    			  } else {
    					  sheetObj.SetCellEditable(i, "cust_cnt_cd",1);
    					  sheetObj.SetCellEditable(i, "cust_seq",1);
    					  sheetObj.SetCellEditable(i, "cust_loc_cd",0);
	    			  }	    			  
	    		  } else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && amdtSeq > 0){
	    			  	sheetObj.SetCellEditable(i,"cust_cnt_cd",0);
						sheetObj.SetCellEditable(i,"cust_seq",0);
						sheetObj.SetCellEditable(i,"cust_loc_cd",0);
	    		  } else {
	    			  	sheetObj.SetCellEditable(i,"cust_cnt_cd",0);
						sheetObj.SetCellEditable(i,"cust_seq",0);
						sheetObj.SetCellEditable(i,"cust_loc_cd",0);
	    		  }
	    		  if(propStsCd != "I" || sheetObj.GetCellValue(i,"prc_prog_sts_cd")!="I") {
	    			  	sheetObj.SetCellEditable(i,"cust_cnt_cd",0);
						sheetObj.SetCellEditable(i,"cust_seq",0);
						sheetObj.SetCellEditable(i,"cust_loc_cd",0);
	    		  }
	    	 }
	     }
