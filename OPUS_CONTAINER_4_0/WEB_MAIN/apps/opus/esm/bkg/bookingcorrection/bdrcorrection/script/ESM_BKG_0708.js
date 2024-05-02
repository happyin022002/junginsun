/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0708.js
*@FileTitle  : C/A Issue Reason Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;    
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        sheetObject1=sheetObjects[0];
        sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_select":				
					if (!validateForm(sheetObjects[0], document.form, IBSAVE)) return;
					var modeCd=formObject.mode_cd.value;
					if (modeCd == "S") {
						if (!ComBkgProcessYn("start C/A")) {
	        	    		return false;
	        	    	}	
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
					} else if (modeCd == "R") {
						if (!ComBkgProcessYn("modify C/A Reason")) {
	        	    		return false;
	        	    	}
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
					} else if (modeCd == "C") {
						if (!ComBkgProcessYn("Confirm C/A")) {
	        	    		return false;
	        	    	}
						pre_comPopupOK(sheetObjects[0], sheetObject1.GetSelectRow());
					}
			    	break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
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
     * registering the created IBCombo Object at page as comboObjects list
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        //---------------
        //IBMultiCombo initializing
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k],k+1);
        } 
        initControl(); 
        //initParam();  
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }
    function initControl() {
  	  
  	}
  
    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		SetMultiSeparator("|");
	    	switch(comboObj.options.id) {
	    	    case "rdn_acpt_flg" : 	    	    	
	    	    	comboObj.InsertItem(0, "Accept",     "Y");     
	    	    	comboObj.InsertItem(1, "Not Accept", "N"); 
	    	    	comboObj.SetSelectIndex(-1,false);
			        break;
	    	}
        }
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
		        with(sheetObj){
		            var HeadTitle=" Chk||Type|Description";
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             
		            InitColumns(cols);
		            SetCountPosition(0);
		            SetEditable(1);
		            SetSheetHeight(200);
			}

		        break;
			case "h1sheet1":      //hidden h1sheet1
			    with(sheetObj){
				      var HeadTitle="|bkg_no|ca_rsn_cd|ca_remark|rdn_sts_cd";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ca_rsn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"ca_remark",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rdn_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(0);
				}
		        break; 
		}
	}
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="sheet1") {
	      	    	formObj.f_cmd.value=SEARCH;
  	          		sheetObj.DoSearch("ESM_BKG_0708GS.do", FormQueryString(formObj) );
      	    	}
                break;
     		case IBSAVE:
                if (formObj.mode_cd.value == "S") {         //startCA
                	formObj.f_cmd.value=MULTI;
		    	} else if (formObj.mode_cd.value == "R") {  //modifyCaReason
		    		formObj.f_cmd.value=MULTI01;
		    	}
                ComSetObjValue(formObj.bkg_corr_rmk, RemoveIsNonAscii(ComGetObjValue(formObj.bkg_corr_rmk)));
                var nChkRow=sheetObj.FindCheckedRow("radio");
                var arrRow=nChkRow.split("|");
                if (arrRow.length > 0) {
                	formObj.ca_rsn_cd.value=sheetObj.GetCellValue(arrRow[0], "val");
                }
          	    var sParam1=ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
          	    var sParam=FormQueryString(formObj);
          		sParam += "&" + sParam1; 
           		var sXml=sheetObj.GetSaveData("ESM_BKG_0708GS.do", sParam);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	            if(State != "S"){	            	
 	            	sheetObjects[0].LoadSaveData(sXml);
	            } else {
	    			if (formObj.f_cmd.value == MULTI01) {
	    				ComClosePopup(); 
	    			} else {
	    				pre_comPopupOK(sheetObjects[0], sheetObjects[0].GetSelectRow());
	    			}
	            }
	            break;
        }
    }
    //######################[1. Event]############################################################

    /**
    * after completed retrieve 
    */ 
    function sheet1_OnSearchEnd(sheetObj, code , ErrMsg) { 
	   	var formObj=document.form;
	   	if (ErrMsg.trim().length > 0) {
	   		ComClosePopup(); 
	   		return;
	   	}
	   	//01. BkgBlNoVO initializing 
	   	formObj.ca_rsn_cd.value=sheetObj.GetEtcData("ca_rsn_cd");
	   	formObj.bkg_corr_rmk.value=sheetObj.GetEtcData("bkg_corr_rmk");
	   	//02. RDN initializing 
	   	var strRdnStsCd=sheetObj.GetEtcData("rdn_sts_cd");
	   	formObj.rdn_sts_cd.value=strRdnStsCd;
	   	formObj.rdn_no.value=sheetObj.GetEtcData("rdn_no");
	   	formObj.rvis_seq.value=sheetObj.GetEtcData("rvis_seq");
	   	formObj.intg_cd_val_dp_desc.value=sheetObj.GetEtcData("intg_cd_val_dp_desc");
	   	rdn_acpt_flg.SetSelectCode(sheetObj.GetEtcData("rdn_acpt_flg"),false);
	   	var modeCd=formObj.mode_cd.value;
	   	if ("C" == modeCd) {
	   		rdn_acpt_flg.SetEnable(0);
	   	} else {
	   		if ("IS" == strRdnStsCd || "RV" == strRdnStsCd) {
	   			rdn_acpt_flg.SetEnable(1);
	   		} else {
	   			rdn_acpt_flg.SetEnable(0);
	   		}
	   	}	   	
	   	var nSRow=sheetObj.FindText("val", sheetObj.GetEtcData("ca_rsn_cd"));
	   	if (nSRow > -1) {
	   		sheetObj.SetCellValue(nSRow, "radio",1,0);
	   	}
	   	initControl(); 
    }
	//######################[2. Etc]##############################################################	    
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj, formObj, sAction){
	   	if (!ComChkValid(formObj)) return false;
	   	with(formObj) {
	         switch (sAction) {	                 
	             case IBSAVE: 
	                 if (sheetObj.CheckedRows("radio") <= 0) {
	                	 ComShowCodeMessage("BKG00249");
	                	 return false;
	                 } 
	                 if (formObj.bkg_corr_rmk.value == "") {
	                	 ComShowCodeMessage("BKG00888", "[Remark]");
	                	 formObj.bkg_corr_rmk.focus();
	                	 return false;
	                 }
	            	 break;
	         }
        }
        return true;
    }
	/**
	 * CA Reason : Recall 
	 */
    function pre_comPopupOK(sheetObj_org, nSRow) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[1];
        sheetObj.RemoveAll();                //grid initializing
        var nRow=sheetObj.DataInsert(-1);  //add new row
		sheetObj.SetCellValue(nRow, "bkg_no",sheetObj_org.GetCellValue(nSRow, "bkg_no"),0);
		sheetObj.SetCellValue(nRow, "ca_rsn_cd",sheetObj_org.GetCellValue(nSRow, "val"),0);
 		sheetObj.SetCellValue(nRow, "ca_remark",formObj.bkg_corr_rmk.value,0);
 		sheetObj.SetCellValue(nRow, "rdn_sts_cd",formObj.rdn_sts_cd.value,0);
 		sheetObj.SetCellValue(nRow, "radio","1",0);
    	comPopupOK();
    }    
    //#############################(3. Util/Etc)##################################################
