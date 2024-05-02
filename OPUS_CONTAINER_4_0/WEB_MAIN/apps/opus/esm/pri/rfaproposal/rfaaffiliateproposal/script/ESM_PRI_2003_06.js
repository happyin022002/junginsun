/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_06.js
*@FileTitle  : RFA Proposal Affiliate Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_PRI_2003_06 : business script for ESM_PRI_2003_06 
 */
    // global variables
    var sheetObjects=new Array();
 	var sheetCnt=0;
 	var rData="N";
 	//Event handler processing by button click event */
 	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
    function processButtonClick(){
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
	    /** **************************************************** */
	    var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	 		if(ComGetBtnDisable(srcName)) return false;
	 		switch(srcName) {
	 			case "btn_RowAdd":				
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;	
				case "btn_Delete":					
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;	
				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;
				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break;
				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;
				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
				case "btn_CancelAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break;
				case "btn_Close":
//					window.returnValue = rData;
					//ComClosePopup(); 
					ComPopUpReturnValue(rData);
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
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
  	 * body tag's unonLoad event handler <br>
  	 * adding function when closing the screen <br>
  	 */      
	function unloadPage(){
		ComPopUpReturnValue(rData);
	}
	/**
	 * Initializing and setting Sheet basics <br>
	 * Setting body tag's onLoad event handler <br>
	 * Adding pre-handling function after loading screen on the browser  <br>
	 */
	 function loadPage() {
	     for(i=0;i<sheetObjects.length;i++){
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         ComEndConfigSheet(sheetObjects[i]);
	     }
	     pageOnLoadFinish(); 
	}
	/**
	 * handling OnKeyPress events <br>
	 */        
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}
	/**
	 * handling OnBeforeActivate  event <br>
	 */    
	function obj_activate() {
	    var srcName=ComGetEvent("name");
	    ComClearSeparator (event.srcElement);
	}
    /**
	 * handling Onbeforedeactivate events <br>
	 */   	
	function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}     
	/**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        var amdt_seq=document.form.amdt_seq.value;
        switch(sheetID) {
             case "sheet1":
            	   with(sheetObj){
                
			               var HeadTitle="|Sel.|Seq.|propno|amdtseq|afilseq|n1stCmncAmdtSeq|Customer code|Customer code|Customer Name|Location|Effective Date|Expiration Date|Source|Status||||||";
			               var headCount=ComCountHeadTitle(HeadTitle);
			
			               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			               var headers = [ { Text:HeadTitle, Align:"Center"} ];
			               InitHeaders(headers, info);
			
			               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                      {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                      {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"afil_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			                     if (amdt_seq == "0"){
			               cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,AcceptKeys:"E" , InputCaseSensitive:1 });
			               cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6,AcceptKeys:"N"});
			               }else{
			               cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2,AcceptKeys:"E" , InputCaseSensitive:1 });
			               cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6,AcceptKeys:"N"});
			               }
			               cols.push({Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 });
			               cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			               cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_tmp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
			               cols.push({Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq_tmp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
			          
			               InitColumns(cols);
			
			               SetEditable(1);
			               SetEllipsis(1);
			               SetWaitImageVisible(0);
			               SetShowButtonImage(2);
			               //SetAutoRowHeight(0);
			               SetSheetHeight(160);
               		}


                break;
         }
     }
     /**
      * Handling sheet process <br>
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH_ASYNC01: 
				sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
				break;
			case IBINSERT: // Row Add			
				var eff_dt=formObj.eff_dt.value;
				var exp_dt=formObj.exp_dt.value;
				var amdt_seq=formObj.amdt_seq.value;
				if (validateForm(sheetObj,document.form,sAction)) {	
	 				var idx=sheetObj.DataInsert();
	 				sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
	 				sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
	 				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
	 				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
	 				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
	 				sheetObj.SetCellValue(idx, "afil_seq",parseInt(ComPriGetMax(sheetObj, "afil_seq")) + 1,0);
					if(amdt_seq!=0){
 						sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prc_prog_sts_cd","#FF0000");
					}	
					sheetObj.SelectCell(idx, "cust_cnt_cd");
				}
				break;    
			case IBDELETE: // Delete
				var amdt_seq=formObj.amdt_seq.value;
				if(amdt_seq=="0"){	
					if (validateForm(sheetObj,document.form,sAction)) {
						deleteRowCheck(sheetObj, "chk", true);
					}
				}else{
					var eff_dt=formObj.eff_dt.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0){			
						for(i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="NW"&&sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq)){
								ComShowCodeMessage("PRI01002");
								return;
							}
						}
						var sRow=0;
						for(j=0;j < chkArr.length;j++){
								if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","");
								sRow++;
							}
						}
						deleteRowCheck(sheetObj, "chk", true);
					}else{ 
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq || ( sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")==amdt_seq && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd")!="NW")){
								ComShowCodeMessage("PRI01002");
								return;
							}
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")!= amdt_seq){
								comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"D","");
							}else{
								sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
								deleteRowCheck(sheetObj, "chk", true);
							}	
					}					
				}
				break;					
			case COMMAND01: // Amend			
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				var columns="";
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						columns="cust_seq|cust_cnt_cd";
						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", columns);						
					}
				}else{ 			
					columns="cust_seq|cust_cnt_cd";
					comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", columns);
				}
				break;	
			case COMMAND02: // Amend Cancel
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				var columns="";
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						columns="cust_seq|cust_cnt_cd";
						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", columns);		
					}
				}else{ 
					columns="cust_seq|cust_cnt_cd";
					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", columns);
				}	
				break;				
			case MODIFY01: // Accept
				if (!ComShowCodeConfirm("PRI00008")) {
					return false;
	            }
				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY01;
				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do");
				//2014.09.12 the opener of iframe popup is parent 
				parent.comUpdateProposalStatusSummary("05", "");
				rData="Y";
				ComOpenWait(false);
				break;				
			case MODIFY02: // Accept Cancel
				if (!ComShowCodeConfirm("PRI00009")) {
					return false;
	            }
				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY02;
				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do");
				//2014.09.12 the opener of iframe popup is parent 
				parent.comUpdateProposalStatusSummary("05", "");
				rData="Y";
				ComOpenWait(false);
				break;						
			case IBSEARCH: 
				if (!validateForm(sheetObj,document.form,sAction)) {
					ComOpenWait(false);
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("ESM_PRI_2003_06GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;				
			case IBSAVE: 
				ComOpenWait(true);
				
				if (!validateForm(sheetObj,document.form,sAction)) {
					ComOpenWait(false);
					return false;
				}
	            if (!ComPriConfirmSave()) {
	            	ComOpenWait(false);
	            	return false;
	            }
	        	for (var a=0; a <= 0; a++) {
	        		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
	        			// setting GM(Guideline Modification) after modifying, in case of "Proposal step" and src_info_cd = GC(Guideline Copy)
	        			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
							sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
	            		}
	            		// setting PM(Previous Contract Modification) after modifying, in case of "Proposal step" and src_info_cd = PC(Previous Contract)
	        			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
	        				sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
	            		}
	        		}
	        	}						
		 		formObj.f_cmd.value=MULTI01;
		 		comChangeValue(sheetObj, "ibflag", "R", "amdt_seq", formObj.pre_amdt_seq.value);
 				var sParam=FormQueryString(formObj);
 				var sParamSheet=sheetObj.GetSaveString();
  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_06GS.do", sParam+"&"+sParamSheet);
  				sheetObj.LoadSaveData(sXml);
 				rData="Y";
 				
 				ComOpenWait(false);
		 		break;
			case MODIFY05: // Accept All
				if (!ComShowCodeConfirm("PRI01015")){
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY03;
				formObj.sts_cd.value='A';
				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do", true);
				//2014.09.12 the opener of iframe popup is parent 
				parent.comUpdateProposalStatusSummary("05", "");
				rData="Y";
				ComOpenWait(false);
				break;			
			case MODIFY06: // Cancel All
				if (!ComShowCodeConfirm("PRI01010")){
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY04;
				formObj.sts_cd.value='I';
				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do", true);
				//2014.09.12 the opener of iframe popup is parent 
				parent.comUpdateProposalStatusSummary("05", "");
				rData="Y";
				ComOpenWait(false);
				break;
        }
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	   
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var sCols="";
		searchEndFontChange(sheetObj, sCols);
        columnControl();		
		buttonControl()
 	}  	 
 	/**
 	 * checking validation process of inputed form data <br>
 	 */
  	function validateForm(sheetObj, formObj, sAction) {
  		switch (sAction) {
  		case IBSEARCH: 
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
  				return false;
  			}
			if ( sheetObj.IsDataModified()) {
            	if ( ComShowCodeConfirm("PRI00010") ) {
            		return true;
            	}else {
            		return false;
            	}				
			}
			return true;
  			break;
  		case IBSAVE: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
			var sParamSheet=sheetObj.GetSaveString();
			if (!sheetObj.IsDataModified()&& sParamSheet == "") {
				ComShowCodeMessage("PRI00301");
				return false;
			}	 		
  			for (i=1 ; i <= sheetObj.RowCount(); i++){
  				if(sheetObj.GetCellValue(i, "cust_cnt_cd") == "" || sheetObj.GetCellValue(i, "cust_seq") == ""){
						ComShowCodeMessage("PRI01014", i);
						sheetObj.SelectCell(i,"cust_cnt_cd");
						return false;
				}
  			}
  			var preIbflag="";
  			for (var i=1; i<= sheetObj.RowCount(); i++){
  				preIbflag=sheetObj.GetRowStatus(i);
  				sheetObj.SetCellValue(i, "cust_cnt_cd_tmp",ComTrim(sheetObj.GetCellValue(i, "cust_cnt_cd")),0);
  				sheetObj.SetCellValue(i, "cust_seq_tmp",ComTrim(sheetObj.GetCellValue(i, "cust_seq")),0);

  				sheetObj.SetRowStatus(i,preIbflag);
  			}
			 var rowM=priAmendDupCheck(sheetObj, "cust_cnt_cd_tmp|cust_seq_tmp", formObj.amdt_seq.value)
			 if (rowM >= 0) {
				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
			     return false;
		    }    			
  			return true;
  			break;
  		case IBINSERT: // Row Add
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
  			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) { //amend 사이에 add 안되게 막기
				ComShowCodeMessage("PRI01002");		
				return false;
			}
			return true;
  			break;
  		case IBDELETE: // Delete
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
  			return true;
  			break;
  		}
  	}
	/**
     * button authority control function<br>
     */
	function buttonControl(){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		if(amdt_seq == 0) {
			hiddenButton("btn_Amend");
			hiddenButton("btn_AmendCancel");
		} else {
			showButton("btn_Amend");
			showButton("btn_AmendCancel");	
		}	
		if (apro_usr_flg == "false" && req_usr_flg == "false"){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_Amend");
			ComBtnDisable("btn_AmendCancel");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_AcceptCancel");
			ComBtnDisable("btn_AcceptAll");
			ComBtnDisable("btn_CancelAll"); 	
			for (var i=1; i <= sheetObjects[0].RowCount();i++){
				sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
				sheetObjects[0].SetCellEditable(i,"cust_seq",0);
				sheetObjects[0].SetCellEditable(i,"cust_nm",0);
				sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
			}					
			return;
		}
		try{
			switch(sts) { 				
				case 'I':  
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					break;
				case 'A': 
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
					}					
					break;
				case 'Q':
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}else{
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}						
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
					}						
					break;
				case 'R': 
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_LoadExcel");	
					if(req_usr_flg == "true"){
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
					}	
					break;
				case 'F': 
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					break;
				case 'C': 
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					break;
				default:
    				showButton("btn_Amend");
    				showButton("btn_AmendCancel");
    				ComBtnEnable("btn_AcceptAll");
    				ComBtnEnable("btn_CancelAll");
    				ComBtnEnable("btn_Accept");
    				ComBtnEnable("btn_AcceptCancel");
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
     * setting column's editable or not <br>
     */       	
    function columnControl(){
    	var sheetObj=sheetObjects[0];
    	var amdt_seq=document.form.amdt_seq.value;
    	var eff_dt=document.form.eff_dt.value;
		if(amdt_seq == 0){
         	for(i=1 ; i < sheetObj.RowCount(); i++){
				sheetObj.SetCellEditable(i,"cust_cnt_cd",1);
				sheetObj.SetCellEditable(i,"cust_seq",1);
				sheetObj.SetCellEditable(i, "cust_nm",0);
			}			
			return;
		}	

 		for(i=1 ; i <= sheetObj.RowCount(); i++){
 			if(sheetObj.GetCellValue(i, "amdt_seq") != amdt_seq){ 			
    			sheetObj.SetCellEditable(i,"cust_cnt_cd",0);
    			sheetObj.SetCellEditable(i,"cust_seq",0);
			} else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
 				if (sheetObj.GetCellValue(i, "src_info_cd") != "AD"){
        			sheetObj.SetCellEditable(i, "cust_cnt_cd",1);
        			sheetObj.SetCellEditable(i, "cust_seq",1);
				}
			}
		}
		changeSheetMemoColor();
    }
    /**
     * setting Sheet's MemoPad color <br>
     */ 				
    function changeSheetMemoColor(){
		var sheetObj=sheetObjects[0];
    	for (var i=1; i <= sheetObj.RowCount();i++)
    	{
    		sheetObj.SetRangeBackColor(i,10,i,10,sheetObj.GetRangeBackColor(i,9,i,9));
		}
    }
  
    /**
 	 * calling function when occurring OnSelectCell Event <br>
     * Amend Row's Highlight color is different <br>
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
        	//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
    /**
     * calling function when occurring OnChange Event <br>
     */  	
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colname=sheetObj.ColSaveName(Col);
     	var formObj=document.form;
     	switch(colname)
     	{
 	    	case "cust_cnt_cd":
 	    		if (Value.length > 0 && sheetObj.GetCellValue(Row, "cust_seq") != ""){
 	    			formObj.f_cmd.value=SEARCH01;  
 	    			var param=FormQueryString(formObj)+"&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.GetCellValue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row,"cust_seq");
  	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", param);
   	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 					if (arrData != null){
 						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0],0);
 						sheetObj.SetCellValue(Row,"cust_loc_cd",arrData[0][2],0);
 					}else{
 						locationCellClear(sheetObj,Row);
 					}
 	    		}
 	    		break;
 	    	case "cust_seq":
 	    		if (Value.length > 0 && sheetObj.GetCellValue(Row, "cust_cnt_cd") != "" && sheetObj.GetCellValue(Row, "cust_cnt_cd").length == 2){
 	    			formObj.f_cmd.value=SEARCH01;  
 	    			var param=FormQueryString(formObj)+"&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.GetCellValue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row,"cust_seq");
  	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", param);
   	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 					if (arrData != null){
 						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0],0);
 						sheetObj.SetCellValue(Row,"cust_loc_cd",arrData[0][2],0);
         	    		if (Value.length < 6 && Value.length != 0){	 	    		
         	    			sheetObj.SetCellValue(Row,"cust_seq",ComTrim(ComLpad(Value, 6, "0")),0);
        	 	    	}         	    		
 					}else{
 						locationCellClear(sheetObj,Row);
 					}	  				
 	    		}   
 	    		break;
 	    	case "cust_loc_cd":
    			if (Value.length == 5) {		
    				formObj.f_cmd.value=SEARCH05;
    				formObj.cd.value=Value;
					var sParam=FormQueryString(formObj);
 					var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
					var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
					if (arrDesc != null && arrDesc.length > 0) {
					} else {
						sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
 						sheetObj.SelectCell(Row, "cust_loc_cd");
					}
				}else{
					sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
					sheetObj.SelectCell(Row, "cust_loc_cd");
				}
 	    		break;
     	}
    }    
    /**
     * calling function when occurring OnPopupClick Event <br>
     * calling Location PopUp<br>
     */  	      	 
 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
       	switch(colName)
       	{
   	    	case "cust_seq":		

   	    		//2014.09.12 change function
   	    		var sUrl="/opuscntr/ESM_PRI_4014_POP.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+sheetObj.GetCellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
 	  			ComOpenPopup(sUrl, 640, 465, "getCustInfoPop", "none", false); 

 	  			
   	    		break;
       	}
 	} 
    /**
     * calling function when occurring OnSaveEnd event  <br>
     * setting editable column after successful saving<br>
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			//ComPriSaveCompleted();
    		//2014.09.12 the opener of iframe popup is parent 
			parent.comUpdateProposalStatusSummary("05", "");
			changeSheetMemoColor();
		}
	}
 	
 	/**
     * set Cust and Sale Representitive Info From Customer Inquiry(ESM_PRI_4014) <br>
     * callback function of Popup
     * 2014.09.12 NYK
     */
    function getCustInfoPop(rtnVal) {
    	var sheetObj = sheetObjects[0];
    	var Row = sheetObj.GetSelectRow();
    	
    	if (rtnVal != null && Row != null && Row > 0){
				sheetObj.SetCellValue(Row, "cust_cnt_cd",rtnVal.custCntCd,0);
				sheetObj.SetCellValue(Row, "cust_seq",rtnVal.custSeq,0);
	    		if (rtnVal.custSeq.length < 6 && rtnVal.custSeq.length != 0){	 	    		
	    			sheetObj.SetCellValue(Row,"cust_seq",ComLpad(rtnVal.custSeq, 6, "0"),0);
	    		} 
	    		sheetObj.SetCellValue(Row, "cust_nm",rtnVal.custNm,0);
	    		sheetObj.SetCellValue(Row, "cust_loc_cd",rtnVal.LocCd,0);
			}
    }	
 	
 	/**
     * calling function when Page Loading <br>
     */ 
     function pageOnLoadFinish() {
    	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
 		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);  
 		var formObj=document.form;
 		
 		//set Control readOnly
		$("#rfaNo, #amdt_seq, #prop_no, #hdr_eff_dt, #hdr_exp_dt").prop("readOnly", true);
 		
 		formObj.hdr_eff_dt.focus();
 		formObj.hdr_exp_dt.focus();
 	    buttonControl();
 	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 	     	    
    }
    /**
     * initializing sheet's specific cell <br>
     */  	    
  	function locationCellClear(sheetObj,Row){
  		sheetObj.SetCellValue(Row, "cust_seq","",0);
  		sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
  		sheetObj.SetCellValue(Row, "cust_nm","",0);
  		sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
  		sheetObj.SelectCell(Row, "cust_cnt_cd");
  	}
     	     
 	/**
 	 * checking duplicate 
 	 * except previous Amend Sequence's row,  Amend Delete(AD) row
 	 * when duplicated value exist, returning row Index 
 	 * duplicated value not exist returning -1 
 	 */
 	function priAmendDupCheck(sheetObj, sCol, amdtSeq) {
 		try {
 			if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
 				return;
 			}
 			if (sCol == undefined || sCol == null || sCol == "") {
 				return;
 			}
 			if (sheetObj.RowCount()<= 0) {
 				return -1;
 			}
 			var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
 			if (dupRow == null || dupRow == "") {
 				return -1;
 			}
 			var arrCol=sCol.split("|");
 			var arrTemp=dupRow.split("|");
 			var arrBaseRow=arrTemp[0].split(",");
 			var arrDesRow=arrTemp[1].split(",");
 			for (var i=arrDesRow.length - 1; i >= 0; i--) {
 				if (sheetObj.GetCellValue(arrDesRow[i], "amdt_seq") != amdtSeq
 						|| sheetObj.GetCellValue(arrDesRow[i], "src_info_cd") == "AD") {
 					arrDesRow.splice(i, 1);
 				}
 			}
 			for (var i=arrBaseRow.length - 1; i >= 0; i--) {
 				if (sheetObj.GetCellValue(arrBaseRow[i], "amdt_seq") != amdtSeq
 						|| sheetObj.GetCellValue(arrBaseRow[i], "src_info_cd") == "AD") {
 					for (var j=0; j < arrDesRow.length; j++) {
 						var isSame=true;
 						for (var k=0; k < arrCol.length; k++) {
 							if (sheetObj.GetCellValue(arrBaseRow[i], arrCol[k]) != sheetObj.GetCellValue(arrDesRow[j], arrCol[k])) {
 								isSame=false;
 								break;
 							}
 						}
 						if (isSame) {
 							arrDesRow.splice(j, 1);
 							break;
 						}
 					}
 					arrBaseRow.splice(i, 1);
 				}
 			}
 			if (arrDesRow.length > 0) {
 				return arrDesRow[0];
 			} else {
 				return -1;
 			}
 		} catch(err) { ComFuncErrMsg(err.message); }
 	}      
