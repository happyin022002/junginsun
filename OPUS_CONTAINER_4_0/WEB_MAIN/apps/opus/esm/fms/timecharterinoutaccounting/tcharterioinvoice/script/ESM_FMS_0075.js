/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0075.js
*@FileTitle  : E-mail / Print - window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class E-mail / Print - window : E-mail / Print - window definition of biz script for creation screen
     */
    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var queryStr="";
	var uploadObjects=new Array();
	var uploadCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_makefile":
    				rdOpen(formObject, "down");    		
    				break;
    			case "btn_email":
    				// RD Down
    				// e-mail type 2번 클릭해야만 파일 선택 화면 호출		
//    				doActionIBSheet(sheetObject, formObject, IBSEARCH);
            		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");    				
    				break;   
    			case "btn_print":
					// RD Open
					rdOpen(formObject, "print");
    				break;  
    			case "btn_tofile":
    				// RD Save
					rdOpen(formObject, "save");
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
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	// fileSetting UPLOAD Environment
    	 initUpload();
    	 
    }
    
    function initUpload(){
    	upload1.Initialize({
			SaveUrl:'/opuscntr/ESM_FMS_0075GS.do',
			ShowButtonArea: true,
			ShowInfoArea: false,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
			AfterSaveStatus : function(result) {
				var code = result.code;
				document.form.f_cmd.value=SEARCH;
      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
      			sXml = convert2ibsheet7(sXml);      			
	      		if( code == 0) {
	      			var fileKey=ComGetEtcData(sXml, "fileKey");
	         		if(typeof fileKey != "undefined" && fileKey != "") {
	         			var param="";
	         			param=param + "?file_path=" + form.file_path.value; 
	         			param=param + "&subject=" + encodeURIComponent(form.subject.value); //form.subject.value.replace(/ /gi,"_");
	         			param=param + "&fileKey=" + fileKey;
	         			ComOpenWindowCenter("ESM_FMS_0079.do" + param, "ESM_FMS_0079", 480, 550, false);
	         		}
	      		}else {
	      			showErrorMsg(sXml);
				}
			},
			AfterAddFile : function(result) {
				document.form.f_cmd.value=SEARCH;
				var sParam=FormQueryString(document.form);
				paramToForm(sParam);
				upload1.SaveStatus();
			},
			BeforeAddFile : function(result){
 				var files = result.files;
                for( var i = 0; i < files.length; i++) {
                    files[i].DeleteFromList();
                }
				return true;
			}
		});
    }
    
    
    /**
     * Handling IBSheet's process <br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	switch(sAction) {
    		case IBSEARCH:
    			upload1.AddFile();    			         	
         		break;
    	}
    }
    /**
     * Handling process for input validation <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }

	/**
	 * Printing as File to attach File in case of sending retrieved information by Email<br>
	 */
	function rdOpen(formObject, viewType){
		var rdParam="";
		var rdUrl="";
		var pgmId=formObject.pgm_id.value;
		var subject=formObject.subject.value;
		if(pgmId == "esm_fms_0012") {
			//Hire No
			opener.document.form.hire_no.value=ComLpad(opener.document.form.ppay_hir_no.value,5,'0');
			rdParam="";
			rdParam="/rv "+ RD_FormQueryString(opener.form, 1);
			rdParam=rdParam + getHireInvList();
			rdUrl="apps/opus/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/ESM_FMS_013.mrd";
		} else {
			rdParam = "";
			rdParam = "/rv "+ RD_FormQueryString(formObject, 1);
			rdUrl="apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_030.mrd";
		}
		
		if(viewType == "print") {	
			formObject.com_mrdPath.value = rdUrl;
			formObject.com_mrdArguments.value = rdParam;
			formObject.com_mrdTitle.value = subject;
			formObject.com_mrdBodyTitle.value = subject;
			formObject.com_mrdSaveDialogFileName.value = subject.replace(/ /g, "_");
			
		    ComOpenRDPopup();
		} else{
			
		    var appendReport = [];
            var mrdPath = RDServerIP + "/" + rdUrl;
            var mrdParam = RDServer + rdParam;
            appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
            directReportDownload(appendReport);
		}	
	}
	/**
     * Generating Hire Invoice List from Opener for Printing <br>
     **/
	function getHireInvList() {
		var formObject=opener.document.form;
		var sheetObject1=opener.sheetObjects[0];
		var sheetObject2=opener.sheetObjects[1];
	    var arrItemName=new Array();
	    var arrAcctCd=new Array();
	    var arrCurrCd=new Array();
	    var arrInvAmt1=new Array();
	    var arrInvAmt2=new Array();
		var rowCnt=sheetObject2.RowCount()+1;
		var addRow=0;
		// ---------------------------------------------------------------------------
		// Iterating by Main amount of Main Grid, Checking Hire / Lumpsum of Form 
		// Comparing Currency / Account Code
		// ---------------------------------------------------------------------------
		for (i=1; i<rowCnt; i++) {
			var acctCd=sheetObject2.GetCellValue(i,"inv_acct_cd");
			if (acctCd == gAcctCdByBrokerage) {//Brokerage 
				continue;
			}	
			var colNo;
			if (sheetObject2.GetCellValue(i,"inv_curr_cd") != '') {
				colNo="";
			} else {
				colNo="2";
			}
			var currCd=sheetObject2.GetCellValue(i,"inv_curr_cd"+colNo);
			var itemName;
			var invAmt1=0;
			var invAmt2=parseFloat(sheetObject2.GetCellValue(i,"inv_inv_amt"+colNo));
			//Hire
			if (acctCd == "510911") {
				if (invAmt2 > 0) {
					itemName="Hire : " + formObject.inv_usd_dys.value + " days";
					//Hire Amount
					if (currCd == formObject.hir_hir_curr_n1st_cd.value) {
						invAmt1=parseFloat(ComReplaceStr(formObject.hir_hir_rt_n1st_amt.value,',',''));
					} else if (currCd == formObject.hir_hir_curr_n2nd_cd.value) {
						invAmt1=parseFloat(ComReplaceStr(formObject.hir_hir_rt_n2nd_amt.value,',',''));
					}
				} else {	
					itemName="Address Commission : " + formObject.inv_usd_dys.value + " days";
				} 	
			//Lumpsum
			} else {
				itemName="Lumpsum : " + sheetObject2.GetCellValue(i,"inv_acct_itm_nm");
				var findRow=1;
				while ((findRow=sheetObject1.FindText("oli_acct_itm_nm", sheetObject2.GetCellValue(i,"inv_acct_itm_nm"), findRow)) > 0) {
					if (sheetObject1.GetCellValue(findRow, "oli_curr_cd") == currCd) {
						invAmt1=parseFloat(sheetObject1.GetCellValue(findRow,"oli_otr_expn_amt"));
						break;
					}
				}
			}		
			//In case of first row / Item Name, Account, Currency are different
			if (i == 1) {
				arrInvAmt1[addRow]=0;
				arrInvAmt2[addRow]=0;
			} else if (arrItemName[addRow] != itemName || arrAcctCd[addRow] != acctCd || arrCurrCd[addRow] != currCd) {
				addRow++;
				arrInvAmt1[addRow]=0;
				arrInvAmt2[addRow]=0;
			}
			arrItemName[addRow]=itemName;
			// -------------------------------------------------------
			// RD Left side Data (Hire / Lumpsum Information on Top of Screen)
			// -------------------------------------------------------
			arrCurrCd[addRow]=currCd;
			arrInvAmt1[addRow]=invAmt1;
			// --------------------------------------------------------------------
			// RD Right side Data (Screen main Grid information - Sum amount separating by period)
			// --------------------------------------------------------------------
			arrInvAmt2[addRow]=arrInvAmt2[addRow] + invAmt2;
			arrAcctCd[addRow]=acctCd;
		} 
	    var arrTotCurrCd=new Array();
	    var arrTotInvAmt=new Array();
		var arrLen=arrAcctCd.length;
		addRow=0;
		var param='';
		for (i=0; i<arrLen; i++) {
			if (i==0) {
				arrTotInvAmt[addRow]=0;
				findRow=addRow;
			} else {
				var arrTotLen=arrTotCurrCd.length;
				findRow=-1;
				for (j=0; j<arrTotLen; j++) {
					if (arrTotCurrCd[j] == arrCurrCd[i]) {
						findRow=j;
						break;
					}
				}
				if (findRow == -1) {
					addRow++;
					arrTotInvAmt[addRow]=0;
					findRow=addRow;
				}
			}
			param=param + " frm1_prn_item_name"+(i+1)+"["+arrItemName[i]+"]";
			param=param + " frm1_prn_curr_cd"+(i+1)+"["+arrCurrCd[i]+"]";
			param=param + " frm1_prn_inv1_amt"+(i+1)+"["+ComAddComma2(arrInvAmt1[i]+"", "#,###.00")+"]";
			param=param + " frm1_prn_inv2_amt"+(i+1)+"["+ComAddComma2(arrInvAmt2[i]+"", "#,###.00")+"]";
			arrTotCurrCd[findRow]=arrCurrCd[i];
			arrTotInvAmt[findRow]=arrTotInvAmt[findRow] + arrInvAmt2[i];
		}
		arrLen=arrTotCurrCd.length;
		for (i=0; i<arrLen; i++) {
			param=param + " frm1_prn_tot_curr_cd"+(i+1)+"["+arrTotCurrCd[i]+"]";
			param=param + " frm1_prn_tot_inv_amt"+(i+1)+"["+ComAddComma2(arrTotInvAmt[i]+"", "#,###.00")+"]";
		}
		return param;
	}
	
    /**
     * Setting Email selected in E-mail List Select PopUp <br>
     * @param aryPopupData
     */
    function setEmail(aryPopupData) {
    	form.com_recipient.value="";
    	var com_recipient="";
    	var idx=0;
    	var chkCnt=aryPopupData.length;
        for(var i=0; i<aryPopupData.length; i++) {
        	idx++;
 		    var emailData=aryPopupData[i];
 		    if(chkCnt == 1) {
 		    	com_recipient=emailData.cntc_pson_eml;
 		    } else {
 		    	if(chkCnt == idx) {
 		    		com_recipient += emailData.cntc_pson_eml;
 		    	} else {
 		    		com_recipient += emailData.cntc_pson_eml+";";
 		    	}
 		    }
    	}
        form.com_recipient.value=com_recipient;           
        //--------------------------------------------
        sendMail();   				        
     }	
        
	function sendMail(){
		var formObject = document.form;
		var rdParam="";
		var rdUrl="";
		var pgmId=formObject.pgm_id.value;
		var subject=formObject.subject.value;
		if(pgmId == "esm_fms_0012") {
			//Hire No
			opener.document.form.hire_no.value=ComLpad(opener.document.form.ppay_hir_no.value,5,'0');
			rdParam="";
			rdParam="/rv "+ RD_FormQueryString(opener.form, 1);
			rdParam=rdParam + getHireInvList();
			rdUrl="apps/opus/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/ESM_FMS_013.mrd";
		} else {
			rdParam="";
			rdParam="/rv "+ RD_FormQueryString(formObject, 1);
			rdUrl="apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_030.mrd";
		}
		
		form.com_rdExportFileName.value = subject+".pdf";
        form.com_subject.value = subject;
        form.com_templateMrd.value = rdUrl;
        form.com_templateMrdArguments.value=rdParam;
                
        ComSendMail();
	}