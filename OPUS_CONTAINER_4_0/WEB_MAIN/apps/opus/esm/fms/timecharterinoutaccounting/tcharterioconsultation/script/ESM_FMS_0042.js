﻿/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0042.js
*@FileTitle  : Slip Inquiry Detail 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================
*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0042 : ESM_FMS_0042 definition of biz script for creation screen
     */
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var apArFlg = "";
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_print":
						rdOpen(document.form);
						break;
					case "btn_hire":
						if(sheetObject.RowCount()> 0){
							var csr_no=formObject.csr_no.value;
							var vsl_eng_nm=formObject.vsl_eng_name.value;
					 		/*if (csr_no.substring(2,3) == 'P'  || csr_no.substring(2,3) == 'T' || csr_no.substring(2,3) == 'S') {
					 			ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0042&vsl_eng_nm="+vsl_eng_nm+"", 500, 133, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
					 		} else {
								ComShowCodeMessage("FMS01511");
								return;
					 		}*/
					 		ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0042&vsl_eng_nm="+vsl_eng_nm+"", 500, 133, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
						} else {
							ComShowCodeMessage('FMS00015');
						}
	                    break;
					case "btn_tax":
						var csr_no=form.csr_no.value;
		        		ComOpenPopup("ESM_FMS_0086.do?csr_no="+csr_no, 917, 540,"setTaxEvidence", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0086");
						break;
					case "btn_close":
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
   	 	var tmpCsrNo = document.form.csr_no.value; 
   	 	apArFlg = tmpCsrNo.substr(0,2);
     
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }        	
        sheet1_OnLoadFinish(sheetObjects[0]);
        
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * * adding first-served functions after loading screen. 
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
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
            case 1:
            	with(sheetObj){
	            	var HeadTitle1=" |Seq|Acct Code|Vendor Code|Center Code|City|Eff. Date|Slip Amount|Dr Amount|Cr Amount|Flet Ctrt Tp Cd";
	            	if("20" == apArFlg){
	            		HeadTitle1=" |Seq|Acct Code|Customer Code|Center Code|City|Eff. Date|Slip Amount|Dr Amount|Cr Amount|Flet Ctrt Tp Cd";
	            	}
	            	var HeadTitle2=" |Seq|Description|Description|Description|Description|VVD Code|Key Number|Dr Amount|Cr Amount|Flet Ctrt Tp Cd";
	            	var headCount=ComCountHeadTitle(HeadTitle1);
	            	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	            	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slp_seq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"ownr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"slp_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Date",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Float",     Hidden:0,  Width:250,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"dr_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
	            	             ],[
	            	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag1" },
	            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slp_seq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"csr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Right",   ColMerge:0,   SaveName:"key_num",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"dr_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ]];
	            	InitColumns(cols,2);
	            	SetEditable(1);
	            	cnt=0;
	            	SetSheetHeight(262);
	            	SetCountPosition(0);
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
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
	  			formObj.f_cmd.value=SEARCH;
	  			sheetObj.DoSearch("ESM_FMS_0042GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount()> 0){
    		var csr_no=form.csr_no.value;
    		var dr_amt=0;
    		var cr_amt=0;
    		var balance_amt=0;
    		for(var ir=2; ir<=sheetObj.LastRow(); ir++) {
    			if(ir%2 == 0) {
    				dr_amt += parseFloat(sheetObj.GetCellValue(ir,"dr_amt"));
    				cr_amt += parseFloat(sheetObj.GetCellValue(ir,"cr_amt"));
    			}
    		}
    		form.dr_amt.value=ComAddComma(dr_amt.toFixed(2));
    		form.cr_amt.value=ComAddComma(cr_amt.toFixed(2));
    		if(csr_no.substring(0,2) == "20") {
    			form.diff.value="CR";
    		} else {
    			form.diff.value="Diff";
    			document.all.balanceAmt.style.display="";
    				balance_amt=dr_amt + cr_amt;
    				if(parseFloat(balance_amt.toFixed(2)) == 0) {
    					form.balance_amt.value="0.00";
    				} else {
    					form.balance_amt.value=ComAddComma(balance_amt.toFixed(2));
    				}
    			//}
    		}
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
  		if(formObject.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		if(formObject.csr_no.value.substring(0,2) == "07") {
  			formObject.csr_type.value="AP";
  		} else {
  			formObject.csr_type.value="AR";
  		}
  		
  		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();

 	}