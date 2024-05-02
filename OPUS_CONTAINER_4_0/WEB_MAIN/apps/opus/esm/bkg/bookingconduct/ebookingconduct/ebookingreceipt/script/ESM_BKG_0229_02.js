/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_02.js
*@FileTitle  : e-Booking & S/I Detail (Customer)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
/****************************************************************************************
   Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    	[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    	character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* Developer Work */
	// global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;     
	var isCopy="false";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick() {
		/** *** using extra sheet valuable if there are more 2 sheets **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		var bkgNo=formObj.bkg_no.value;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case IBCLEAR:
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
				break;
			case "btn_cancelcopydata":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				isCopy="false";
				top.isCopyAllRequested=false;
				//ComBtnColor("btn_cancelcopydata", "blue");
				//ComBtnColor("btn_datacopytoopus", "#737373");	
				
				document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
				document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
				break;
			case "btn_datacopytoopus":
				if (isCopy == "false") {
					dataCopy();
				}
				break;
			case "btn_upload":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_t7Sa0190":   
				var scNo=formObj.sc_no.value;
				var rfaNo=formObj.rfa_no.value;
				var svcScpCd=formObj.svc_scp_cd.value;
				var applDt=formObj.appl_dt.value;
				ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObj.bkg_no.value+"&sc_no="+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ applDt, 850, 345, "callBackSa0190","1,0,1,1,1", true);			
				customerDataDiffCheck(formObj);
				break;        		
			case "btn_t7Sh0192":
				var custCntCd=ComGetObjValue(formObj.sh_cust_cnt_cd);
				var custSeq=ComGetObjValue(formObj.sh_cust_seq);
				var custNm="";
				var custAddr="";
				if(ComChkLen(formObj.sh_cust_nm) != 1){
					custNm=ComGetObjValue(formObj.sh_cust_nm).substring(0,10);
				}else{
					custNm=ComGetObjValue(formObj.sh_cust_nm);
				}
				if(ComChkLen(formObj.sh_cust_addr) != 1){
					custAddr=ComGetObjValue(formObj.sh_cust_addr).substring(0,10);
				}else{
					custAddr=ComGetObjValue(formObj.sh_cust_addr);
				}    					
				var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+encodeURI(custNm)+"&cust_addr="+"";
				ComOpenPopup(url,970, 620, "callBackSh0192","0,0,1,1,1", true);
				customerDataDiffCheck(formObj);
				break;    		
			case "btn_t7Cn0192":
				var custCntCd=formObj.cn_cust_cnt_cd.value;
				var custSeq=formObj.cn_cust_seq.value;
				var custNm="";
				var custAddr="";
				if(ComChkLen(formObj.cn_cust_nm) != 1){
					custNm=ComGetObjValue(formObj.cn_cust_nm).substring(0,10);
				}else{
					custNm=ComGetObjValue(formObj.cn_cust_nm);
				}
				if(ComChkLen(formObj.cn_cust_addr) != 1){
					custAddr=ComGetObjValue(formObj.cn_cust_addr).substring(0,10);
				}else{
					custAddr=ComGetObjValue(formObj.cn_cust_addr);
				}    					
				var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+encodeURI(custNm)+"&cust_addr="+"";    					
				ComOpenPopup(url,970, 620, "callBackCn0192","0,0,1,1,1", true);
				customerDataDiffCheck(formObj);
				break;   		
			case "btn_t7Nf0192":
				var custCntCd=formObj.nf_cust_cnt_cd.value;
				var custSeq=formObj.nf_cust_seq.value;
				var custNm="";
				var custAddr="";
				if(ComChkLen(formObj.nf_cust_nm) != 1){
					custNm=ComGetObjValue(formObj.nf_cust_nm).substring(0,10);
				}else{
					custNm=ComGetObjValue(formObj.nf_cust_nm);
				}
				if(ComChkLen(formObj.nf_cust_addr) != 1){
					custAddr=ComGetObjValue(formObj.nf_cust_addr).substring(0,10);
				}else{
					custAddr=ComGetObjValue(formObj.nf_cust_addr);
				}    					
				var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+encodeURI(custNm)+"&cust_addr="+"";    					
				ComOpenPopup(url,970, 620, "callBackNf0192","0,0,1,1,1", true);
				customerDataDiffCheck(formObj);
				break; 
			case "btn_t7Ff0192":
				var custCntCd=formObj.ff_cust_cnt_cd.value;
				var custSeq=formObj.ff_cust_seq.value;
					var custNm="";
				if(ComChkLen(formObj.ff_cust_nm) != 1){
					custNm=ComGetObjValue(formObj.ff_cust_nm).substring(0,10);
				}else{
					custNm=ComGetObjValue(formObj.ff_cust_nm);
				}
				var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+encodeURI(custNm);    					
				ComOpenPopup(url,970, 620, "callBackFf0192","0,0,1,1,1", true);
				customerDataDiffCheck(formObj);
				break;
			case "btn_t7An0192":
				var custCntCd=formObj.an_cust_cnt_cd.value;
				var custSeq=formObj.an_cust_seq.value;
				var custNm="";
				if(ComChkLen(formObj.an_cust_nm) != 1){
					custNm=ComGetObjValue(formObj.an_cust_nm).substring(0,10);
				}else{
					custNm=ComGetObjValue(formObj.an_cust_nm);
				}
				var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+encodeURI(custNm);    		    					
				ComOpenPopup(url,970, 620, "callBackAn0192","0,0,1,1,1", true);
				customerDataDiffCheck(formObj)
				break; 
			case "btn_t7ShMdmCustNm":
				var custCntCd=formObj.sh_cust_cnt_cd.value;
				var custSeq=formObj.sh_cust_seq.value;
				var custNm=formObj.sh_cust_nm.value;
				var custAddress=formObj.sh_cust_addr.value;
				if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
					if ( ComIsNull(formObj.sh_cust_lgl_eng_nm.value) || ComIsNull(formObj.sh_mdm_address.value) ) {
						searchMdmCustNm(sheetObjects[0], formObj, "SH", custCntCd, custSeq);
					}
					if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
						if(ComShowCodeConfirm("BKG00343")){
							formObj.sh_cust_nm.value=getMakeBrData("NAME",formObj.sh_cust_lgl_eng_nm.value);
							formObj.sh_cust_addr.value=getMakeBrData("ADDR",formObj.sh_mdm_address.value); 
						}
					}else{
						formObj.sh_cust_nm.value=getMakeBrData("NAME",formObj.sh_cust_lgl_eng_nm.value);
						formObj.sh_cust_addr.value=getMakeBrData("ADDR",formObj.sh_mdm_address.value); 
					}
				}else{
					ComShowCodeMessage("BKG00340");
				}
				customerDataDiffCheck(formObj);
				break;
			case "btn_t7CnMdmCustNm":
				var custCntCd=formObj.cn_cust_cnt_cd.value;
				var custSeq=formObj.cn_cust_seq.value;
				var custNm=formObj.cn_cust_nm.value;
				var custAddress=formObj.cn_cust_addr.value;
				if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
					if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
						if(ComShowCodeConfirm("BKG00343")){
							formObj.cn_cust_nm.value=getMakeBrData("NAME",formObj.cn_cust_lgl_eng_nm.value);
							formObj.cn_cust_addr.value=getMakeBrData("ADDR",formObj.cn_mdm_address.value); 
						}
					}else{
						formObj.cn_cust_nm.value=getMakeBrData("NAME",formObj.cn_cust_lgl_eng_nm.value);
						formObj.cn_cust_addr.value=getMakeBrData("ADDR",formObj.cn_mdm_address.value); 
					}
				}else{
					ComShowCodeMessage("BKG00340");
				}
				customerDataDiffCheck(formObj);
				break;     		
			case "btn_t7NfMdmCustNm":
				var custCntCd=formObj.nf_cust_cnt_cd.value;
				var custSeq=formObj.nf_cust_seq.value;
				var custNm=formObj.nf_cust_nm.value;
				var custAddress=formObj.nf_cust_addr.value;
				if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
					if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
						if(ComShowCodeConfirm("BKG00343")){
							formObj.nf_cust_nm.value=getMakeBrData("NAME",formObj.nf_cust_lgl_eng_nm.value);
							formObj.nf_cust_addr.value=getMakeBrData("ADDR",formObj.nf_mdm_address.value); 
						}
					}else{
						formObj.nf_cust_nm.value=getMakeBrData("NAME",formObj.nf_cust_lgl_eng_nm.value);
						formObj.nf_cust_addr.value=getMakeBrData("ADDR",formObj.nf_mdm_address.value); 
					}
				}else{
					ComShowCodeMessage("BKG00340");
				}
				customerDataDiffCheck(formObj);
				break;     		
			case "btn_t7FfMdmCustNm":
				var custCntCd=formObj.ff_cust_cnt_cd.value;
				var custSeq=formObj.ff_cust_seq.value;
				var custNm=formObj.ff_cust_nm.value;
				if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
					if(!ComIsNull(custNm)){
						if(ComShowCodeConfirm("BKG00343")){    								
							if(ComIsNull(formObj.ff_cust_lgl_eng_nm.value)){
								formObj.ff_cust_nm.value=getMakeBrData("ADDR",formObj.ff_mdm_address.value);
							}else{
								if(!ComIsNull(formObj.ff_mdm_address.value)){
									formObj.ff_cust_nm.value=getMakeBrData("NAME",formObj.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.ff_mdm_address.value); 
								}
							}
						}
					}else{
						if(ComIsNull(formObj.ff_cust_lgl_eng_nm.value)){
							formObj.ff_cust_nm.value=getMakeBrData("ADDR",formObj.ff_mdm_address.value);
						}else{
							if(!ComIsNull(formObj.ff_mdm_address.value)){
								formObj.ff_cust_nm.value=getMakeBrData("NAME",formObj.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.ff_mdm_address.value); 
							}
						}
					}
				}else{
					ComShowCodeMessage("BKG00340");
				}
				customerDataDiffCheck(formObj);
				break;     		
			case "btn_t7AnMdmCustNm":    		
				var custCntCd=formObj.an_cust_cnt_cd.value;
				var custSeq=formObj.an_cust_seq.value;
				var custNm=formObj.an_cust_nm.value;
				if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
					if(!ComIsNull(custNm)){
						if(ComShowCodeConfirm("BKG00343")){
							if(ComIsNull(formObj.an_cust_lgl_eng_nm.value)){
								formObj.an_cust_nm.value=getMakeBrData("ADDR",formObj.an_mdm_address.value);
							}else{
								if(!ComIsNull(formObj.an_mdm_address.value)){
									formObj.an_cust_nm.value=getMakeBrData("NAME",formObj.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.an_mdm_address.value); 
								}
							}
						}
					}else{
						if(ComIsNull(formObj.an_cust_lgl_eng_nm.value)){
							formObj.an_cust_nm.value=getMakeBrData("ADDR",formObj.an_mdm_address.value);
						}else{
							if(!ComIsNull(formObj.an_mdm_address.value)){										
								formObj.an_cust_nm.value=getMakeBrData("NAME",formObj.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.an_mdm_address.value); 
							}
						}
					}
				}else{
					ComShowCodeMessage("BKG00340");
				}
				customerDataDiffCheck(formObj);
				break;
			case "btn_t7ShZipCode":
				var zip_cd=formObj.sh_cust_zip_id.value;
				var cnt_cd=formObj.sh_cust_cnt_cd.value;
				ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
						,800, 510, "callBackShZipCode","0,1", false);
				break;
			case "btn_t7CnZipCode":
				var zip_cd=formObj.cn_cust_zip_id.value;
				var cnt_cd=formObj.cn_cust_cnt_cd.value;
				ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
						,800, 510, "callBackCnZipCode","0,1", false);
				break;
			case "btn_t7NfZipCode":
				var zip_cd=formObj.nf_cust_zip_id.value;
				var cnt_cd=formObj.nf_cust_cnt_cd.value;
				ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
						,800, 510, "callBackNfZipCode","0,1", false);
				break;     
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    for(var j=0; j < comboObjects.length; j++){
	        initCombo(comboObjects[j]);
	    }     
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		initControl();
	}
	function initControl() {
		var formObj=document.form;
		//	axon_event.addListenerFormat("keypress", "form_keypress", formObj);
		//	axon_event.addListenerForm  ("blur", "form_blur", formObj);
		axon_event.addListenerForm  ("change", "form_onChange", formObj);
		axon_event.addListenerForm  ('click', 'form_click', formObj); //- click
//		axon_event.addListenerForm  ('beforedeactivate', 'form_deactivate',  formObj); //- focus out     
		applyShortcut();
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	  * Set Combo
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator("|");
	}
	/**
	* Set IBCombo Object In comboObjects array
	* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	**/
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}	  
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(false);
				}
			break;
		}
	}

	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSAVE: // save for test
			if (! validateForUpload()) return false;
			var params=getSaveStringForUpload();
			//ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0229_02GS.do", params);
			//ComOpenWait(false);
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
				sheetObj.LoadSaveData(sXml);
				return false;
			}
			formObj.f_cmd.value=SEARCH;
			var aXml=formObj.sXml.value;
			formObj.sXml.value="";
			//ComOpenWait(true);
			sXml=sheetObj.GetSearchData("ESM_BKG_0229_02GS.do", FormQueryString(formObj));
			//ComOpenWait(false);
			formObj.sXml.value=aXml;
			arrXml=sXml.split("|$$|");
			// Combo setting
			if (arrXml.length > 0){			
				ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "val|name");
				sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
			}   			
			BkgEtcDataXmlToForm(arrXml[0], formObj);
			customerSearchEnd(formObj);
			customerDataDiffCheck(formObj);
			break;
		case IBSEARCH: // Retrieve
			resetopusCustomer(formObj);
		case IBCLEAR: // initial setting	
			var sXml=formObj.sXml.value;
			var arrXml=sXml.split("|$$|");  
			// Combo setting
			if (arrXml.length > 0){	
				ComXml2ComboItem(arrXml[0],comboObjects[0], "val", "val|name");
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			}
			BkgEtcDataXmlToForm(arrXml[0], formObj);
			if(formObj.sh_cust_seq2.value=="0") formObj.sh_cust_seq2.value="";
			if(formObj.cn_cust_seq2.value=="0") formObj.cn_cust_seq2.value="";
			if(formObj.nf_cust_seq2.value=="0") formObj.nf_cust_seq2.value="";
			if(formObj.ff_cust_seq2.value=="0") formObj.ff_cust_seq2.value="";
			if(formObj.an_cust_seq2.value=="0") formObj.an_cust_seq2.value="";
			ComSetObjValue(formObj.bl_tp_cd, ComGetEtcData(arrXml[0], "cust_to_ord_flg"));
			if(top.document.form.tabload2.value == "COPY"){
				dataCopy();
			}
			top.document.form.tabload2.value="LOAD";
			customerSearchEnd(formObj);
			customerDataDiffCheck(formObj);
			
			if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_02');
			break;
		case IBSEARCH_ASYNC02: // Data Copy
			var eSvc=0;
			var opus=1;
			var tbl=new Array(
					// Shipper
					new Array ("sh_cust_cnt_cd2",		"sh_cust_cnt_cd"),
					new Array ("sh_cust_seq2", 			"sh_cust_seq"),
					new Array ("sh_cust_lgl_eng_nm2", 	"sh_cust_lgl_eng_nm"),
					new Array ("sh_cust_nm2", 			"sh_cust_nm"),
					new Array ("sh_cust_addr2", 		"sh_cust_addr"),
					new Array ("sh_cust_cty_nm2", 		"sh_cust_cty_nm"),
					new Array ("sh_cust_ste_cd2", 		"sh_cust_ste_cd"),
					new Array ("sh_cstms_decl_cnt_cd2", "sh_cstms_decl_cnt_cd"),
					new Array ("sh_cust_zip_id2", 		"sh_cust_zip_id"),
					new Array ("sh_eur_cstms_st_nm2", 	"sh_eur_cstms_st_nm"),
					new Array ("sh_eori_no2", 			"sh_eori_no"),
					// Consignee
					new Array ("cn_cust_cnt_cd2", 		"cn_cust_cnt_cd"),
					new Array ("cn_cust_seq2", 			"cn_cust_seq"),
					new Array ("cn_cust_lgl_eng_nm2",	"cn_cust_lgl_eng_nm"),
					new Array ("cn_cust_nm2", 			"cn_cust_nm"),
					new Array ("cn_cust_addr2", 		"cn_cust_addr"),
					new Array ("cn_cust_cty_nm2", 		"cn_cust_cty_nm"),
					new Array ("cn_cust_ste_cd2", 		"cn_cust_ste_cd"),
					new Array ("cn_cstms_decl_cnt_cd2", "cn_cstms_decl_cnt_cd"),
					new Array ("cn_cust_zip_id2", 		"cn_cust_zip_id"),
					new Array ("cn_cust_fax_no2", 		"cn_cust_fax_no"),
					new Array ("cn_cust_eml2", 			"cn_cust_eml"),
					new Array ("cn_eur_cstms_st_nm2", 	"cn_eur_cstms_st_nm"),
					new Array ("cn_eori_no2", 			"cn_eori_no"),
					// Notify
					new Array ("nf_cust_cnt_cd2", 		"nf_cust_cnt_cd"),
					new Array ("nf_cust_seq2", 			"nf_cust_seq"),
					new Array ("nf_cust_lgl_eng_nm2", 	"nf_cust_lgl_eng_nm"),
					new Array ("nf_cust_nm2", 			"nf_cust_nm"),
					new Array ("nf_cust_addr2", 		"nf_cust_addr"),
					new Array ("nf_cust_cty_nm2", 		"nf_cust_cty_nm"),
					new Array ("nf_cust_ste_cd2", 		"nf_cust_ste_cd"),
					new Array ("nf_cstms_decl_cnt_cd2", "nf_cstms_decl_cnt_cd"),
					new Array ("nf_cust_zip_id2", 		"nf_cust_zip_id"),
					new Array ("nf_cust_fax_no2", 		"nf_cust_fax_no"),
					new Array ("nf_cust_eml2", 			"nf_cust_eml"),
					new Array ("nf_eur_cstms_st_nm2", 	"nf_eur_cstms_st_nm"),
					new Array ("nf_eori_no2", 			"nf_eori_no"),
					// Freight Forwarder
					new Array ("ff_cust_cnt_cd2", 		"ff_cust_cnt_cd"),
					new Array ("ff_cust_seq2", 			"ff_cust_seq"),
					new Array ("ff_cust_lgl_eng_nm2", 	"ff_cust_lgl_eng_nm"),
					new Array ("ff_cust_nm2", 			"ff_cust_nm"),
					// Also Notify
					new Array ("an_cust_cnt_cd2", 		"an_cust_cnt_cd"),
					new Array ("an_cust_seq2",			"an_cust_seq"),
					new Array ("an_cust_lgl_eng_nm2", 	"an_cust_lgl_eng_nm"),
					new Array ("an_cust_nm2", 			"an_cust_nm"),
					// Export Ref No
					new Array ("ex_cust_nm2", 			"ex_cust_nm"),
					// Broker
//					new Array ("br_cust_cnt_cd2", 		"br_cust_cnt_cd"),
//					new Array ("br_cust_nm2", 			"br_cust_nm"),
//					new Array ("br_cust_addr2", 		"br_cust_addr"),			
					new Array ("org_cnt_nm2", 			"org_cnt_nm")
					);
			var j = 0;
			for (i=0; i < tbl.length; i++) {
				var eSvcElem=document.getElementsByName(tbl[i][eSvc])[0];
				var opusElem=document.getElementsByName(tbl[i][opus])[0];
					if (eSvcElem.name.indexOf("_cust_seq") >= 0) {
						if (parseFloat(eSvcElem.value) > 0) {
							opusElem.value=ComTrim(eSvcElem.value);
						}
					} else if(eSvcElem.name.indexOf("_cust_cnt_cd") >= 0) {
						if (eSvcElem.value != null && eSvcElem.value != "") {
							opusElem.value=ComTrim(eSvcElem.value);
						}
					} else if(eSvcElem.name == "sh_cstms_decl_cnt_cd2") {
						var shCstmsDeclCnt = eSvcElem.value;
						if (shCstmsDeclCnt.length > 2) {
							shCstmsDeclCnt = shCstmsDeclCnt.substring(0,2);
						}
						opusElem.value = shCstmsDeclCnt;
					} else { 
						opusElem.value=chekcSpecialValue(ComTrim(eSvcElem.value));
					}
			}
			ComSetObjValue(formObj.sh_addr_prn_flg, "Y");
			ComSetObjValue(formObj.cn_addr_prn_flg, "Y");
			ComSetObjValue(formObj.nf_addr_prn_flg, "Y");
			ComSetObjValue(formObj.ff_addr_prn_flg, "Y");
			ComSetObjValue(formObj.an_addr_prn_flg, "Y");
			ComSetObjValue(formObj.ex_addr_prn_flg, "Y");
			if (formObj.sh_kr_cstms_cust_tp_cd2.value != null && formObj.sh_kr_cstms_cust_tp_cd2.value != ''){
				kr_cstms_cust_tp_cd.SetSelectCode(formObj.sh_kr_cstms_cust_tp_cd2.value);
			}
			if (formObj.cn_cust_to_ord_flg2.value != null && formObj.cn_cust_to_ord_flg2.value != ''){			
				ComSetObjValue(formObj.bl_tp_cd, formObj.cn_cust_to_ord_flg2.value);
			}
			if (formObj.cust_opus.value == "N") {
				if (formObj.rvis_cntr_cust_tp_cd2.value != null && formObj.rvis_cntr_cust_tp_cd2.value != ''){
					kr_cstms_cust_tp_cd.SetSelectCode(formObj.rvis_cntr_cust_tp_cd2.value);
				}
			}
			if (formObj.sh_cust_cnt_cd.value == "" || formObj.sh_cust_cnt_cd.value == null) {
				if (formObj.sh_cust_seq.value == null || formObj.sh_cust_seq.value.length == 0) {
					//formObj.sh_cust_cnt_cd.value=formObj.ff_cust_cnt_cd.value;
					//formObj.sh_cust_seq.value=formObj.ff_cust_seq.value;
				}
			}
			customerTextCheck(formObj);
			customerSearchEnd(formObj);
			customerDataDiffCheck(formObj);
			isCopy="true";
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(formObj,sAction){
	    switch(sAction) {
				case IBSAVE:      // Save   
					// validation
					if(!ComIsNull(formObj.sh_cust_zip_id) && formObj.sh_cust_zip_id.value.length>10){ 						 		
						ComShowCodeMessage("BKG06065", "Zip CD");
						ComSetFocus(formObj.sh_cust_zip_id); 						
						return false; 	 	 						
					}
					if(!ComIsNull(formObj.cn_cust_zip_id) && formObj.cn_cust_zip_id.value.length>10){ 						 		
						ComShowCodeMessage("BKG06065", "Zip CD");
						ComSetFocus(formObj.cn_cust_zip_id); 						
						return false; 	 	 						
					}
					if(!ComIsNull(formObj.nf_cust_zip_id) && formObj.nf_cust_zip_id.value.length>10){ 					 		
						ComShowCodeMessage("BKG06065", "Zip CD");
						ComSetFocus(formObj.nf_cust_zip_id); 						
						return false; 	 	 						
					}
					if (parent.frames["t1frame"].document.form.doc_tp_cd.value=="S") {
						if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
			 				if(ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "CA"){
			 					if(ComIsNull(formObj.sh_cust_zip_id||ComChkLen(formObj.sh_cust_zip_id)>10)){ 						 		
			 						ComShowCodeMessage("BKG00344");
			 						ComSetFocus(formObj.sh_cust_zip_id); 						
			 						return false; 	 	 						
			 					}
			 				}
			 				if(ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "CA"){
			 					if(ComIsNull(formObj.cn_cust_zip_id)||ComChkLen(formObj.cn_cust_zip_id)>10){ 						 		
			 						ComShowCodeMessage("BKG00344");
			 						ComSetFocus(formObj.cn_cust_zip_id); 						
			 						return false; 	 	 						
			 					}
			 				}
			 				if(ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "CA"){
			 					if(ComIsNull(formObj.nf_cust_zip_id)||ComChkLen(formObj.nf_cust_zip_id)>10){ 						 		
			 						ComShowCodeMessage("BKG00344");
			 						ComSetFocus(formObj.nf_cust_zip_id); 						
			 						return false; 	 	 						
			 					}
			 				} 			
						}
						if(formObj.cust_to_ord_flg.value == "Y" && formObj.cn_cust_yn.value == "N"){
							if(ComIsNull(formObj.nf_cust_cnt_cd.value) || ComIsNull(formObj.nf_cust_seq.value)){
			  					if(ComChkLen(formObj.nf_cust_nm) != 1){
			  						custNm=ComGetObjValue(formObj.nf_cust_nm).substring(0,10);
			  					}else{
			  						custNm=ComGetObjValue(formObj.nf_cust_nm);
			  					}
			  					if(ComChkLen(formObj.nf_cust_addr) != 1){
			  						custAddr=ComGetObjValue(formObj.nf_cust_addr).substring(0,10);
			  					}else{
			  						custAddr=ComGetObjValue(formObj.nf_cust_addr);
			  					}    					
								ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.nf_cust_cnt_cd.value+"&cust_seq="+formObj.nf_cust_seq.value+"&cust_nm="+encodeURI(custNm)+"&cust_addr="+"&cust_val=Y"+"",970, 620, "callBackNf0192","0,0,1,1,1", true);
								return false;
							}
						}
						if(formObj.cust_to_ord_flg.value == "N" && formObj.cn_cust_yn.value == "N"){
							if(ComIsNull(formObj.cn_cust_cnt_cd.value) || ComIsNull(formObj.cn_cust_seq.value)){
			  					if(ComChkLen(formObj.cn_cust_nm) != 1){
			  						custNm=ComGetObjValue(formObj.cn_cust_nm).substring(0,10);
			  					}else{
			  						custNm=ComGetObjValue(formObj.cn_cust_nm);
			  					}
			  					if(ComChkLen(formObj.cn_cust_addr) != 1){
			  						custAddr=ComGetObjValue(formObj.cn_cust_addr).substring(0,10);
			  					}else{
			  						custAddr=ComGetObjValue(formObj.cn_cust_addr);
			  					}    					
								ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.cn_cust_cnt_cd.value+"&cust_seq="+formObj.cn_cust_seq.value+"&cust_nm="+encodeURI(custNm)+"&cust_addr="+"&cust_val=Y"+"",970, 620, "callBackCn0192","0,0,1,1,1", true);
								return false;
							}
						} 			
						if(formObj.ca_manifest_flag.value == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
		 					if(ComIsNull(formObj.sh_cust_cty_nm.value) || ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
								ComShowCodeMessage("BKG00346");
								return false;
							} 
							if(formObj.cust_to_ord_flg.value == "N"){
								if(formObj.cn_cstms_decl_cnt_cd.value == "US" || formObj.cn_cstms_decl_cnt_cd.value == "CA") {
			 	 					if(ComIsNull(formObj.cn_cust_cty_nm.value) || ComIsNull(formObj.cn_cust_ste_cd.value) || ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
				 						ComShowCodeMessage("BKG00346");
				 						return false;
				 					} 	
								}
							}
							if(formObj.nf_cstms_decl_cnt_cd.value == "US" || formObj.nf_cstms_decl_cnt_cd.value == "CA") {
								if(ComIsNull(formObj.nf_cust_cty_nm.value) || ComIsNull(formObj.nf_cust_ste_cd.value) || ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
									ComShowCodeMessage("BKG00346");
									return false;
								}
							}
			 				if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
			 					BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
			 					BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
			 					BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
			 					BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
			 					BkgIsContainsChars(formObj.nf_cust_nm,"as per con")){
			 					ComShowCodeMessage("BKG00345");
			 					return false; 	 						
							}
						}
						var delCd=parent.frames["t1frame"].form.bkg_del_cd.value;
						var podCd=parent.frames["t1frame"].form.bkg_pod_cd.value;
						if(formObj.nl_flag.value == "Y" || podCd.substring(0,2)=="NL"){
							if(ComIsNull(formObj.sh_eori_no.value)){
								if(ComIsNull(formObj.sh_eur_cstms_st_nm.value) 
										|| ComIsNull(formObj.sh_cust_cty_nm.value)
										|| ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)
										|| ComIsNull(formObj.sh_cust_zip_id.value)){
									ComShowCodeMessage("BKG02063", "Shipper");
									if(ComIsNull(formObj.sh_eur_cstms_st_nm.value)){
										ComSetFocus(formObj.sh_eur_cstms_st_nm);
										return false;
									}
									if(ComIsNull(formObj.sh_cust_cty_nm.value)){
										ComSetFocus(formObj.sh_cust_cty_nm);
										return false;
									}
									if(ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
										ComSetFocus(formObj.sh_cstms_decl_cnt_cd);
										return false;
									}
									if(ComIsNull(formObj.sh_cust_zip_id.value)){
										ComSetFocus(formObj.sh_cust_zip_id);
										return false;
									}
								}
							}
			 				if(formObj.bl_tp_cd.value == "N"){
			 					if(ComIsNull(formObj.cn_eori_no.value)){
				 					if(ComIsNull(formObj.cn_eur_cstms_st_nm.value) 
												|| ComIsNull(formObj.cn_cust_cty_nm.value)
												|| ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)
												|| ComIsNull(formObj.cn_cust_zip_id.value)){
					 						ComShowCodeMessage("BKG02063", "Consignee");
											if(ComIsNull(formObj.cn_eur_cstms_st_nm.value)){
												ComSetFocus(formObj.cn_eur_cstms_st_nm);
												return false;
											}
											if(ComIsNull(formObj.cn_cust_cty_nm.value)){
												ComSetFocus(formObj.cn_cust_cty_nm);
												return false;
											}
											if(ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
												ComSetFocus(formObj.cn_cstms_decl_cnt_cd);
												return false;
											}
											if(ComIsNull(formObj.cn_cust_zip_id.value)){
												ComSetFocus(formObj.cn_cust_zip_id);
												return false;
											}
									}
								}
			 				} else {
			 					if(ComIsNull(formObj.nf_eori_no.value)){
			 						if(ComIsNull(formObj.nf_eur_cstms_st_nm.value) 
											|| ComIsNull(formObj.nf_cust_cty_nm.value)
											|| ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)
											|| ComIsNull(formObj.nf_cust_zip_id.value)){
				 						ComShowCodeMessage("BKG02063", "Notify");
										if(ComIsNull(formObj.nf_eur_cstms_st_nm.value)){
											ComSetFocus(formObj.nf_eur_cstms_st_nm);
											return false;
										}
										if(ComIsNull(formObj.nf_cust_cty_nm.value)){
											ComSetFocus(formObj.nf_cust_cty_nm);
											return false;
										}
										if(ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
											ComSetFocus(formObj.nf_cstms_decl_cnt_cd);
											return false;
										}
										if(ComIsNull(formObj.nf_cust_zip_id.value)){
											ComSetFocus(formObj.nf_cust_zip_id);
											return false;
										}
									}
								}
			 				}
						}
					}
					var custCnts=[formObj.sh_cust_cnt_cd, formObj.cn_cust_cnt_cd, formObj.nf_cust_cnt_cd];
					var declCnts=[formObj.sh_cstms_decl_cnt_cd, formObj.cn_cstms_decl_cnt_cd, formObj.nf_cstms_decl_cnt_cd];
					var eoris=[formObj.sh_eori_no, formObj.cn_eori_no, formObj.nf_eori_no];
					for (var ii=0; ii<custCnts.length; ii++) {
						if (!ComIsNull(custCnts[ii]) && !ComIsNull(declCnts[ii]) && ComGetObjValue(custCnts[ii])!=ComGetObjValue(declCnts[ii])) {
							if (!ComShowCodeConfirm("BKG01151")) {
								ComSetFocus(declCnts[ii]);
								return false;
							}
						}
					}
	 				for (var ii=0; ii<eoris.length; ii++) {
	 					if (!ComIsNull(eoris[ii])) {
	 						if ("TEST"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							"NONE"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							/[^A-Za-z0-9]/g.test(ComGetObjValue(eoris[ii]))) {
	 							ComShowCodeMessage("BKG01152");
	 							ComSetFocus(eoris[ii]);
	 							return false;
	 						} else if (3>eoris[ii].value.length || 17<eoris[ii].value.length) {  //length check
	 							ComShowCodeMessage("BKG01152");
								ComSetFocus(eoris[ii]);
								return false;
	 						} else if (1<ComGetLenByByte(eoris[ii])) {
	 							if (!ComIsAlphabet(ComGetObjValue(eoris[ii]).substring(0,2),"u")) {
	 	 							ComShowCodeMessage("BKG01152");
	 								ComSetFocus(eoris[ii]);
	 								return false;
	 							}
	 						}
	 					}
	 				}
					if(formObj.cust_to_ord_flg.value == "Y"){					
						if(formObj.sam_cnee_ntfy_flg.checked){
		 					ComShowCodeMessage("BKG00438");
		 					return false; 	 				 						
						}
						if(!BkgIsContainsChars(formObj.cn_cust_nm,"order")){
							if(ComShowCodeConfirm("BKG00348")){
								formObj.cust_to_ord_flg.value="N";
							}  						
						}
		 				if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
		 					BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as per con")){
		 					if(ComShowCodeConfirm("BKG10001")){
								formObj.cust_to_ord_flg.value="N";
							}  						
		 				}	
					}
					if(formObj.cust_to_ord_flg.value == "N"){
						if(BkgIsContainsChars(formObj.cn_cust_nm,"order")){
							if(ComShowCodeConfirm("BKG00347")){
								formObj.cust_to_ord_flg.value="Y";
							}  						
						}				
					}		
					var isSame=false;
					if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
						BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
						BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
						BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
						BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
						BkgIsContainsChars(formObj.nf_cust_nm,"as per con") ||
	 					(!ComIsNull(formObj.cn_cust_nm) && !ComIsNull(formObj.cn_cust_addr) &&
	 					ComIsNull(formObj.nf_cust_nm) && ComIsNull(formObj.nf_cust_addr))){
						isSame=true;
					} else if(!ComIsNull(formObj.nf_cust_nm) && !ComIsNull(formObj.cn_cust_nm)){
						if(BkgGetCharsLen(formObj.nf_cust_nm, 0, 10, 10) == BkgGetCharsLen(formObj.cn_cust_nm, 0, 10, 10)){
							isSame=true;
						}
					} 				
					if(isSame){
						ComSetObjValue(formObj.sam_cnee_ntfy_flg, "Y");
					}else{
						ComSetObjValue(formObj.sam_cnee_ntfy_flg, "N");
					} 				
					if(!validateCols(2, 35, formObj.sh_cust_nm, "Shipper")){
						return false;
					}
					if(!validateCols(3, 35, formObj.sh_cust_addr, "Shipper")){
						return false;
					}
					if(!validateCols(2, 35, formObj.cn_cust_nm, "Consignee")){
						return false;
					}
					if(!validateCols(3, 35, formObj.cn_cust_addr, "Consignee")){
						return false;
					} 				
					if(!validateCols(2, 35, formObj.nf_cust_nm, "Notify")){
						return false;
					}
					if(!validateCols(3, 35, formObj.nf_cust_addr, "Notify")){
						return false;
					} 				
					if(!validateCols(5, 35, formObj.ff_cust_nm, " F/Forwarder")){
						return false;
					}
					if(!validateCols(5, 35, formObj.an_cust_nm, "A/Notify")){
						return false;
					} 		
					if(!validateCols(3, 35, formObj.ex_cust_nm, "Export Ref.")){
						return false;
					} 	 			
			 		// Case to Consignee Fax No excess maxlength
			 		if (ComChkLen(formObj.cn_cust_fax_no) == 0) {
			 			ComShowCodeMessage("BKG06065", "Consignee's Fax No");
			 			ComSetFocus(formObj.cn_cust_fax_no);
			 			return false;
			 		}
			 		// Case to Notify Fax No excess maxlength
			 		if (ComChkLen(formObj.nf_cust_fax_no) == 0) {
			 			ComShowCodeMessage("BKG06065", "Notify's Fax No");
			 			ComSetFocus(formObj.nf_cust_fax_no);
			 			return false;
			 		}
			 		// Case to Broker Code not exits
//			 		if(ComGetObjValue(formObj.sh_cust_cnt_cd) == "IN" ){
//				 		if(ComIsNull(formObj.br_cust_cnt_cd.value)){
//				 			ComShowCodeMessage("BKG95001", "Pan Code in","Broker column");
//				 			ComSetFocus(formObj.br_cust_cnt_cd);
//				 			return false;
//				 		}
//			 		}
					// Black Customer Check
			 		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0229_02GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
					var black_cust_flag=ComGetEtcData(sXml, "black_cust_flag");
					var black_cust_list=ComGetEtcData(sXml, "black_cust_list");
					if(black_cust_flag == "Y"){
						if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
							return false;
						}
					}
			 		if(!ComIsNull(formObj.val_msg.value) && formObj.val_msg_chk.value != "Y"){
			 			ComShowCodeMessage("BKG08323", formObj.val_msg.value);
			 			formObj.val_msg_chk.value = "Y";
			 		}					
				break;              		
	     } 		
	    return true;
	}
	/**
	 * Upload Validate function
	 */
	function validateForUpload() {
		var formObj=document.form;
		if (parent.frames["t1frame"].document.form) {
			formObj.bkg_no.value=parent.frames["t1frame"].document.form.bkg_no.value;
		}
		return validateForm(formObj, IBSAVE);
	}
	/**
	 * Upload Save String Handling
	*/
	function getSaveStringForUpload() {
		var formObj=document.form;
		
		ComSetObjValue(formObj.sh_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.sh_cust_nm)));
		ComSetObjValue(formObj.sh_cust_addr, chekcSpecialValue(ComGetObjValue(formObj.sh_cust_addr)));
		ComSetObjValue(formObj.cn_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.cn_cust_nm)));
		ComSetObjValue(formObj.cn_cust_addr, chekcSpecialValue(ComGetObjValue(formObj.cn_cust_addr)));
		ComSetObjValue(formObj.nf_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.nf_cust_nm)));
		ComSetObjValue(formObj.nf_cust_addr, chekcSpecialValue(ComGetObjValue(formObj.nf_cust_addr)));
		ComSetObjValue(formObj.ff_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.ff_cust_nm)));
		ComSetObjValue(formObj.an_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.an_cust_nm)));
		ComSetObjValue(formObj.ex_cust_nm, chekcSpecialValue(ComGetObjValue(formObj.ex_cust_nm)));

		formObj.f_cmd.value=MULTI;	
		var sXml=formObj.sXml.value;
		formObj.sXml.value="";
		var params=FormQueryString(formObj);
		formObj.sXml.value=sXml;
		return (params);
	}
	function customerDataDiffCheck(formObj){
		// SHIPPER
		setDiffCheckColor(formObj.sh_cust_cnt_cd.value,     	formObj.sh_cust_cnt_cd2.value, 		'sh_cust_cnt_cd2');
		setDiffCheckColor(formObj.sh_cust_seq.value,        	formObj.sh_cust_seq2.value, 		'sh_cust_seq2');
		setDiffCheckColor(formObj.sh_cust_nm.value,         	formObj.sh_cust_nm2.value, 			'sh_cust_nm2');
		setDiffCheckColor(formObj.sh_cust_lgl_eng_nm.value, 	formObj.sh_cust_lgl_eng_nm2.value, 	'sh_cust_lgl_eng_nm2');
		setDiffCheckColor(formObj.sh_cust_addr.value,			formObj.sh_cust_addr2.value, 		'sh_cust_addr2');
		setDiffCheckColor(formObj.sh_cust_cty_nm.value, 		formObj.sh_cust_cty_nm2.value, 		'sh_cust_cty_nm2');
		setDiffCheckColor(formObj.sh_cust_ste_cd.value, 		formObj.sh_cust_ste_cd2.value, 		'sh_cust_ste_cd2');
		setDiffCheckColor(formObj.sh_cstms_decl_cnt_cd.value, 	formObj.sh_cstms_decl_cnt_cd2.value,'sh_cstms_decl_cnt_cd2');
		setDiffCheckColor(formObj.sh_cust_zip_id.value, 		formObj.sh_cust_zip_id2.value, 		'sh_cust_zip_id2');
		setDiffCheckColor(formObj.sh_eur_cstms_st_nm.value, 	formObj.sh_eur_cstms_st_nm2.value, 	'sh_eur_cstms_st_nm2');
		setDiffCheckColor(formObj.sh_eori_no.value, 			formObj.sh_eori_no2.value, 			'sh_eori_no2');
		//CONSIGNEE
		setDiffCheckColor(formObj.cn_cust_cnt_cd.value, 		formObj.cn_cust_cnt_cd2.value, 		'cn_cust_cnt_cd2');	
		setDiffCheckColor(formObj.cn_cust_seq.value, 			formObj.cn_cust_seq2.value, 		'cn_cust_seq2');	
		setDiffCheckColor(formObj.cn_cust_nm.value, 			formObj.cn_cust_nm2.value, 			'cn_cust_nm2');	
		setDiffCheckColor(formObj.cn_cust_lgl_eng_nm.value, 	formObj.cn_cust_lgl_eng_nm2.value, 	'cn_cust_lgl_eng_nm2');	
		setDiffCheckColor(formObj.cn_cust_addr.value, 			formObj.cn_cust_addr2.value, 		'cn_cust_addr2');	
		setDiffCheckColor(formObj.cn_cust_cty_nm.value, 		formObj.cn_cust_cty_nm2.value, 		'cn_cust_cty_nm2');	
		setDiffCheckColor(formObj.cn_cust_ste_cd.value, 		formObj.cn_cust_ste_cd2.value, 		'cn_cust_ste_cd2');	
		setDiffCheckColor(formObj.cn_cstms_decl_cnt_cd.value, 	formObj.cn_cstms_decl_cnt_cd2.value,'cn_cstms_decl_cnt_cd2');	
		setDiffCheckColor(formObj.cn_cust_zip_id.value, 		formObj.cn_cust_zip_id2.value, 		'cn_cust_zip_id2');	
		setDiffCheckColor(formObj.cn_cust_fax_no.value, 		formObj.cn_cust_fax_no2.value, 		'cn_cust_fax_no2');	
		setDiffCheckColor(formObj.cn_cust_eml.value, 			formObj.cn_cust_eml2.value,			'cn_cust_eml2');
		setDiffCheckColor(formObj.cn_eur_cstms_st_nm.value, 	formObj.cn_eur_cstms_st_nm2.value, 	'cn_eur_cstms_st_nm2');
		setDiffCheckColor(formObj.cn_eori_no.value, 			formObj.cn_eori_no2.value, 			'cn_eori_no2');
		//NOTIFY
		setDiffCheckColor(formObj.nf_cust_cnt_cd.value, 		formObj.nf_cust_cnt_cd2.value,		'nf_cust_cnt_cd2');	
		setDiffCheckColor(formObj.nf_cust_seq.value, 			formObj.nf_cust_seq2.value, 		'nf_cust_seq2');	
		setDiffCheckColor(formObj.nf_cust_nm.value, 			formObj.nf_cust_nm2.value, 			'nf_cust_nm2');
		setDiffCheckColor(formObj.nf_cust_lgl_eng_nm.value, 	formObj.nf_cust_lgl_eng_nm2.value, 	'nf_cust_lgl_eng_nm2');	
		setDiffCheckColor(formObj.nf_cust_addr.value, 			formObj.nf_cust_addr2.value, 		'nf_cust_addr2');	
		setDiffCheckColor(formObj.nf_cust_cty_nm.value, 		formObj.nf_cust_cty_nm2.value, 		'nf_cust_cty_nm2');	
		setDiffCheckColor(formObj.nf_cust_ste_cd.value, 		formObj.nf_cust_ste_cd2.value, 		'nf_cust_ste_cd2');	
		setDiffCheckColor(formObj.nf_cstms_decl_cnt_cd.value, 	formObj.nf_cstms_decl_cnt_cd2.value,'nf_cstms_decl_cnt_cd2');	
		setDiffCheckColor(formObj.nf_cust_zip_id.value, 		formObj.nf_cust_zip_id2.value, 		'nf_cust_zip_id2');	
		setDiffCheckColor(formObj.nf_cust_fax_no.value, 		formObj.nf_cust_fax_no2.value, 		'nf_cust_fax_no2');	
		setDiffCheckColor(formObj.nf_cust_eml.value, 			formObj.nf_cust_eml2.value, 		'nf_cust_eml2');
		setDiffCheckColor(formObj.nf_eur_cstms_st_nm.value, 	formObj.nf_eur_cstms_st_nm2.value, 	'nf_eur_cstms_st_nm2');
		setDiffCheckColor(formObj.nf_eori_no.value, 			formObj.nf_eori_no2.value, 			'nf_eori_no2');
		//FORWARDER
		setDiffCheckColor(formObj.ff_cust_cnt_cd.value, 		formObj.ff_cust_cnt_cd2.value, 		'ff_cust_cnt_cd2');	
		setDiffCheckColor(formObj.ff_cust_seq.value, 			formObj.ff_cust_seq2.value, 		'ff_cust_seq2');	
		setDiffCheckColor(formObj.ff_cust_nm.value, 			formObj.ff_cust_nm2.value, 			'ff_cust_nm2');	
		setDiffCheckColor(formObj.ff_cust_lgl_eng_nm.value, 	formObj.ff_cust_lgl_eng_nm2.value, 	'ff_cust_lgl_eng_nm2');
		setDiffCheckColor(formObj.an_cust_cnt_cd.value, 		formObj.an_cust_cnt_cd2.value, 		'an_cust_cnt_cd2');	
		setDiffCheckColor(formObj.an_cust_seq.value, 			formObj.an_cust_seq2.value, 		'an_cust_seq2');	
		setDiffCheckColor(formObj.an_cust_nm.value, 			formObj.an_cust_nm2.value,			'an_cust_nm2');	
		setDiffCheckColor(formObj.an_cust_lgl_eng_nm.value, 	formObj.an_cust_lgl_eng_nm2.value, 	'an_cust_lgl_eng_nm2');	
		//EXPORT
		setDiffCheckColor(formObj.ex_cust_nm.value, 			formObj.ex_cust_nm2.value,			'ex_cust_nm2');
		//broker
//		setDiffCheckColor(formObj.br_cust_cnt_cd.value, 		formObj.br_cust_cnt_cd2.value, 		'br_cust_cnt_cd2');	
//		setDiffCheckColor(formObj.br_cust_nm.value, 			formObj.br_cust_nm2.value, 			'br_cust_nm2');	
//		setDiffCheckColor(formObj.br_cust_addr.value, 			formObj.br_cust_addr2.value, 		'br_cust_addr2');
		// Country of Origin
		setDiffCheckColor(formObj.org_cnt_nm.value, 			formObj.org_cnt_nm2.value, 			'org_cnt_nm2');
	}
	function dataCopy() {
		//ComBtnColor("btn_cancelcopydata", "#737373");
		//ComBtnColor("btn_datacopytoopus", "blue");	
		
		document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;;font-weight:bold;";
		document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;;font-weight:normal;";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	}
	function setCopyFlag(flag){
		isCopy=flag;
	}
	function resetopusCustomer(formObj){
		var eSvc=0;
		var opus=1;
		var tbl=new Array(
				// Shipper
				new Array ("sh_cust_cnt_cd2",		"sh_cust_cnt_cd"),
				new Array ("sh_cust_seq2", 			"sh_cust_seq"),
				new Array ("sh_cust_lgl_eng_nm2", 	"sh_cust_lgl_eng_nm"),
				new Array ("sh_cust_nm2", 			"sh_cust_nm"),
				new Array ("sh_cust_addr2", 		"sh_cust_addr"),
				new Array ("sh_cust_cty_nm2", 		"sh_cust_cty_nm"),
				new Array ("sh_cust_ste_cd2", 		"sh_cust_ste_cd"),
				new Array ("sh_cstms_decl_cnt_cd2", "sh_cstms_decl_cnt_cd"),
				new Array ("sh_cust_zip_id2", 		"sh_cust_zip_id"),
				// Consignee
				new Array ("cn_cust_cnt_cd2", 		"cn_cust_cnt_cd"),
				new Array ("cn_cust_seq2", 			"cn_cust_seq"),
				new Array ("cn_cust_lgl_eng_nm2",	"cn_cust_lgl_eng_nm"),
				new Array ("cn_cust_nm2", 			"cn_cust_nm"),
				new Array ("cn_cust_addr2", 		"cn_cust_addr"),
				new Array ("cn_cust_cty_nm2", 		"cn_cust_cty_nm"),
				new Array ("cn_cust_ste_cd2", 		"cn_cust_ste_cd"),
				new Array ("cn_cstms_decl_cnt_cd2", "cn_cstms_decl_cnt_cd"),
				new Array ("cn_cust_zip_id2", 		"cn_cust_zip_id"),
				new Array ("cn_cust_fax_no2", 		"cn_cust_fax_no"),
				new Array ("cn_cust_eml2", 			"cn_cust_eml"),
				// Notify
				new Array ("nf_cust_cnt_cd2", 		"nf_cust_cnt_cd"),
				new Array ("nf_cust_seq2", 			"nf_cust_seq"),
				new Array ("nf_cust_lgl_eng_nm2", 	"nf_cust_lgl_eng_nm"),
				new Array ("nf_cust_nm2", 			"nf_cust_nm"),
				new Array ("nf_cust_addr2", 		"nf_cust_addr"),
				new Array ("nf_cust_cty_nm2", 		"nf_cust_cty_nm"),
				new Array ("nf_cust_ste_cd2", 		"nf_cust_ste_cd"),
				new Array ("nf_cstms_decl_cnt_cd2", "nf_cstms_decl_cnt_cd"),
				new Array ("nf_cust_zip_id2", 		"nf_cust_zip_id"),
				new Array ("nf_cust_fax_no2", 		"nf_cust_fax_no"),
				new Array ("nf_cust_eml2", 			"nf_cust_eml"),
				// Freight Forwarder
				new Array ("ff_cust_cnt_cd2", 		"ff_cust_cnt_cd"),
				new Array ("ff_cust_seq2", 			"ff_cust_seq"),
				new Array ("ff_cust_lgl_eng_nm2", 	"ff_cust_lgl_eng_nm"),
				new Array ("ff_cust_nm2", 			"ff_cust_nm"),
				// Also Notify
				new Array ("an_cust_cnt_cd2", 		"an_cust_cnt_cd"),
				new Array ("an_cust_seq2",			"an_cust_seq"),
				new Array ("an_cust_lgl_eng_nm2", 	"an_cust_lgl_eng_nm"),
				new Array ("an_cust_nm2", 			"an_cust_nm"),
				// Export Ref No
				new Array ("ex_cust_nm2", 			"ex_cust_nm"),
				new Array ("fmc_cd2", 			"fmc_cd")
				// Broker
//				new Array ("br_cust_cnt_cd2", 		"br_cust_cnt_cd"),
//				new Array ("br_cust_nm2", 			"br_cust_nm"),
//				new Array ("br_cust_addr2", 		"br_cust_addr")
				);
		// OPUS data remove 
		for (i=0; i < tbl.length; i++) {
			var opusElem=document.getElementsByName(tbl[i][opus])[0];
			opusElem.value="";
		}
		//print flag set default
		ComSetObjValue(formObj.sh_addr_prn_flg, "Y");
		ComSetObjValue(formObj.cn_addr_prn_flg, "Y");
		ComSetObjValue(formObj.nf_addr_prn_flg, "Y");
		ComSetObjValue(formObj.ff_addr_prn_flg, "Y");
		ComSetObjValue(formObj.an_addr_prn_flg, "Y");
		ComSetObjValue(formObj.ex_addr_prn_flg, "Y");
		formObj.kr_cstms_cust_tp_cd.value="";
		formObj.bl_tp_cd.value="";
		formObj.kr_cstms_cust_tp_cd.value="";
		
	}
	function customerSearchEnd(formObj){	
		var delCd=parent.frames["t1frame"].form.bkg_del_cd.value;
		var podCd=parent.frames["t1frame"].form.bkg_pod_cd.value;
		var porCd=parent.frames["t1frame"].form.bkg_por_cd.value;
		if(ComIsNull(formObj.sh_cust_cnt_cd.value) && !ComIsNull(porCd)){
			ComSetObjValue(formObj.sh_cust_cnt_cd, porCd.substring(0,2));
		}			
		if(ComIsNull(formObj.cn_cust_cnt_cd.value) && !ComIsNull(delCd)){
			ComSetObjValue(formObj.cn_cust_cnt_cd, delCd.substring(0,2));
		}	
		if(ComIsNull(formObj.nf_cust_cnt_cd.value) && !ComIsNull(delCd)){
			ComSetObjValue(formObj.nf_cust_cnt_cd, delCd.substring(0,2));
		}
		if( ComIsNull(formObj.kr_cstms_cust_tp_cd) ){
			if(formObj.sh_cust_tp.value == "B"){
				formObj.kr_cstms_cust_tp_cd.value="S";
			}else{
				formObj.kr_cstms_cust_tp_cd.value="C";
			}
		}
		// CA Manifest Flag setting
		var frobFlag=ComGetObjValue(formObj.frob_flag);
		var polCd=ComGetObjValue(formObj.pol_cd);
		var podCd=ComGetObjValue(formObj.pod_cd);
		var delCd=ComGetObjValue(formObj.del_cd);
		if(polCd.substring(0,2) != "CA"){
			if(podCd.substring(0,2) == "CA" || delCd.substring(0,2) == "CA" || frobFlag == "Y"){
				formObj.ca_manifest_flag.value="Y";
			}else{
				formObj.ca_manifest_flag.value="N";
			}		
		}
		if(ComGetObjValue(formObj.ca_manifest_flag) == "Y"){
			document.getElementById("sh_cust_cty_nm").className="input1";
			document.getElementById("sh_cust_ste_cd").className="input1";
			document.getElementById("sh_cstms_decl_cnt_cd").className="input1";					
			document.getElementById("cn_cust_cty_nm").className="input1";
			document.getElementById("cn_cust_ste_cd").className="input1";
			document.getElementById("cn_cstms_decl_cnt_cd").className="input1";
			document.getElementById("nf_cust_cty_nm").className="input1";
			document.getElementById("nf_cust_ste_cd").className="input1";
			document.getElementById("nf_cstms_decl_cnt_cd").className="input1";
			//ca 향 default setting
			if(ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
				formObj.sh_cstms_decl_cnt_cd.value=polCd.substring(0, 2);
			}
			if(ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
				formObj.cn_cstms_decl_cnt_cd.value=delCd.substring(0, 2);
			}
			if(ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
				formObj.nf_cstms_decl_cnt_cd.value=delCd.substring(0, 2);
			}
		}else{
			document.getElementById("sh_cust_cty_nm").className="input";
			document.getElementById("sh_cust_ste_cd").className="input";
			document.getElementById("sh_cstms_decl_cnt_cd").className="input";							
			document.getElementById("cn_cust_cty_nm").className="input";
			document.getElementById("cn_cust_ste_cd").className="input";
			document.getElementById("cn_cstms_decl_cnt_cd").className="input";
			document.getElementById("nf_cust_cty_nm").className="input";
			document.getElementById("nf_cust_ste_cd").className="input";
			document.getElementById("nf_cstms_decl_cnt_cd").className="input";					
		}
		formObj.same_as_flag.value="N";
		formObj.sam_cnee_ntfy_flg.value='N';
	}
	/**
	 * Cust Name Retrieve
	 */
	function searchMdmCustNm(sheetObject, formObj, custTp, custCntCd, custSeq){
		ComSetObjValue(formObj.f_cmd,SEARCHLIST11);
		var sXml=sheetObject.GetSearchData("ESM_BKG_0079_05GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq, FormQueryString(formObj));
		var custNm=ComGetEtcData(sXml,"cust_nm");
		var custAddr=ComGetEtcData(sXml,"cust_addr");
		var custTpCd=ComGetEtcData(sXml,"rvis_cntr_cust_tp_cd");
		var fmcNo=ComGetEtcData(sXml,"frt_fwrd_fmc_no");
		if ("SH"==custTp) {
			ComSetObjValue(formObj.sh_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.sh_mdm_address, custAddr ? custAddr : "");
			kr_cstms_cust_tp_cd.SetSelectCode("B"==custTpCd ? "S" : "C");
		} else if ("CN"==custTp) {
			ComSetObjValue(formObj.cn_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.cn_mdm_address, custAddr ? custAddr : "");
		} else if ("NF"==custTp) {
			ComSetObjValue(formObj.nf_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.nf_mdm_address, custAddr ? custAddr : "");
		} else if ("FF"==custTp) {
			ComSetObjValue(formObj.ff_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.ff_mdm_address, custAddr ? custAddr : "");
			ComSetObjValue(formObj.fmc_cd, fmcNo ? fmcNo : "");
		} else if ("AN"==custTp) {
			ComSetObjValue(formObj.an_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.an_mdm_address, custAddr ? custAddr : "");
		}			
	}
	/**
	 * Chars Validate
	 */     
	function BkgIsContainsChars(obj,chars) {
		try {
	        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
	        var sVal=getArgValue(obj);
	        sVal=sVal.toUpperCase();
	        chars=chars.toUpperCase();
	        if(sVal.indexOf(chars) != -1){
	        	return true;
	        }
	        return false;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}     
	 /**
	 * Get Data Length Function 
	 */        
	function BkgGetCharsLen(obj, startIdx, endIdx, chkLen){
		try {        
	    	var sVal=getArgValue(obj);
	        sVal=sVal.toUpperCase();
	        if(sVal.length > chkLen){
	        	sVal=sVal.substring(startIdx, endIdx);
	        }
	        return sVal;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}     
	
	function getMakeBrData(dataNm, dataValue){
	 	var rtnValue="";
	 	if(dataValue != null && dataValue.length > 0){
	 		if(dataNm == "NAME"){
	 			if(dataValue.length > 35){
	 				rtnValue=dataValue.substring(0,35) + "\n" + dataValue.substring(35);
	 			}else{
	 				rtnValue=dataValue;
	 			}			 
	 		}else if(dataNm == "ADDR"){
	 			if(dataValue.length > 70){
	 				rtnValue=dataValue.substring(0,35) + "\n" + dataValue.substring(35,70) + "\n" + dataValue.substring(70);
	 			}else if(dataValue.length > 35){
	 				rtnValue=dataValue.substring(0,35) + "\n" + dataValue.substring(35);
	 			}else{
	 				rtnValue=dataValue;
	 			}				
	 		}			 
	 	} else {
	 		rtnValue="";
	 	}
	 	return rtnValue.toUpperCase();		 
	}
	function replaceAll(str, orgStr, repStr){
		return str.split(orgStr).join(repStr); 
	}
	function form_keypress() {
	//		var srcName=ComGetEvent("name");
	//				if(ComGetBtnDisable(srcName)) return false;
	//		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	//	    switch(event.srcElement.dataformat){
	//	    	case "engup":
	//	    		// Only upper eng input, upper eng+num -> ComKeyOnlyAlphabet('uppernum');
	//	    		ComKeyOnlyAlphabet('uppernum');
	//	    		break;
	//	    	case "int":
	//	    	  	ComKeyOnlyNumber(event.srcElement);
	//	        break;	      
	//	     	case "zipcode":
	//	     		ComKeyOnlyAlphabet('uppernum','45|32');
	//	        break;	            
	//	     	case "etc": 
	//	     		if(keyValue >= 97 && keyValue <= 122) {
	//	     			event.keyCode=keyValue + 65 - 97;
	//	     		}
	//	    	break;	        
	//	     	default:
	//	    }
	}
	/**
	* Mouse Out Event Handling 
	*/
	function form_deactivate() {
	//	var formObj = document.form;
	//	var srcName = window.event.srcElement.getAttribute("name");
	//	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	//	var srcValue = window.event.srcElement.getAttribute("value");
	//	if(srcName == "agmt_act_cust_seq"){
	//		formObj.agmt_act_cust_seq.value = ComLpad(srcValue,6,"0");   
	//	}else if(srcName == "sh_cust_cnt_cd"){		
	//		if(ComIsNull(srcValue)){
	//			formObj.sh_cust_lgl_eng_nm.value = "";			
	//		} else {
	//			if(ComChkLen(srcValue, srcMaxLength) == "2" && srcValue == "KR"){
	//				if(rArray2[1] == "KR"){
	//					document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled=false;
	//				}else{
	//					document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled=false;
	//				} 	
	//			}
	//		}
	//	}else if(srcName == "sh_cust_seq"){    		
	//		if(ComIsNull(srcValue)){
	//			formObj.sh_cust_lgl_eng_nm.value = "";
	//		}else{
	//			formObj.sh_cust_seq.value = ComLpad(srcValue,6,"0");   
	//		}
	//	}else if(srcName == "cn_cust_cnt_cd"){		
	//		if(ComIsNull(srcValue)){
	//			formObj.cn_cust_lgl_eng_nm.value = "";			
	//		}
	//	}else if(srcName == "cn_cust_seq"){    		
	//		if(ComIsNull(srcValue)){
	//			formObj.cn_cust_lgl_eng_nm.value = "";
	//		}else{
	//			formObj.cn_cust_seq.value = ComLpad(srcValue,6,"0");    
	//		}   		
	//	}else if(srcName == "nf_cust_cnt_cd"){		
	//		if(ComIsNull(srcValue)){
	//			formObj.nf_cust_lgl_eng_nm.value = "";			
	//		}
	//	}else if(srcName == "nf_cust_seq"){
	//		if(ComIsNull(srcValue)){
	//			formObj.nf_cust_lgl_eng_nm.value = "";
	//		}else{
	//			formObj.nf_cust_seq.value = ComLpad(srcValue,6,"0");   
	//		}      			
	//	}else if(srcName == "ff_cust_cnt_cd"){		
	//		if(ComIsNull(srcValue)){
	//			formObj.ff_cust_lgl_eng_nm.value = "";			
	//		}
	//	}else if(srcName == "ff_cust_seq"){
	//		if(ComIsNull(srcValue)){
	//			formObj.ff_cust_lgl_eng_nm.value = "";
	//		}else{
	//			formObj.ff_cust_seq.value = ComLpad(srcValue,6,"0");    
	//		}      				}
	//	else if(srcName == "an_cust_cnt_cd"){		
	//		if(ComIsNull(srcValue)){
	//			formObj.an_cust_lgl_eng_nm.value = "";			
	//		}
	//	}else if(srcName == "an_cust_seq"){
	//		if(ComIsNull(srcValue)){
	//			formObj.an_cust_lgl_eng_nm.value = "";
	//		}else{
	//			formObj.an_cust_seq.value = ComLpad(srcValue,6,"0");   
	//		}       			
	//	}
	}	
	function form_click(){
		var formObj=document.form;
		var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
		if(srcName == "sam_cnee_copy_flg"){
			if(formObj.sam_cnee_copy_flg.checked){
				if(!ComIsNull(formObj.nf_cust_nm.value) || !ComIsNull(formObj.nf_cust_addr.value)){
					if(ComShowCodeConfirm("BKG00343")){
						ComSetObjValue(formObj.nf_cust_nm,ComGetObjValue(formObj.cn_cust_nm));
						ComSetObjValue(formObj.nf_cust_addr,ComGetObjValue(formObj.cn_cust_addr));
						ComSetObjValue(formObj.nf_cust_cty_nm,ComGetObjValue(formObj.cn_cust_cty_nm));
						ComSetObjValue(formObj.nf_cust_ste_cd,ComGetObjValue(formObj.cn_cust_ste_cd));
						ComSetObjValue(formObj.nf_cstms_decl_cnt_cd,ComGetObjValue(formObj.cn_cstms_decl_cnt_cd));
						ComSetObjValue(formObj.nf_cust_zip_id,ComGetObjValue(formObj.cn_cust_zip_id));
						ComSetObjValue(formObj.nf_cust_fax_no,ComGetObjValue(formObj.cn_cust_fax_no));
						ComSetObjValue(formObj.nf_cust_eml,ComGetObjValue(formObj.cn_cust_eml));						
					}  			    				
				}else{
					ComSetObjValue(formObj.nf_cust_nm,ComGetObjValue(formObj.cn_cust_nm));
					ComSetObjValue(formObj.nf_cust_addr,ComGetObjValue(formObj.cn_cust_addr));
					ComSetObjValue(formObj.nf_cust_cty_nm,ComGetObjValue(formObj.cn_cust_cty_nm));
					ComSetObjValue(formObj.nf_cust_ste_cd,ComGetObjValue(formObj.cn_cust_ste_cd));
					ComSetObjValue(formObj.nf_cstms_decl_cnt_cd,ComGetObjValue(formObj.cn_cstms_decl_cnt_cd));
					ComSetObjValue(formObj.nf_cust_zip_id,ComGetObjValue(formObj.cn_cust_zip_id));
					ComSetObjValue(formObj.nf_cust_fax_no,ComGetObjValue(formObj.cn_cust_fax_no));
					ComSetObjValue(formObj.nf_cust_eml,ComGetObjValue(formObj.cn_cust_eml));					
				}
			}   		
		}
	}
	function form_onChange() {
		var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
		var formObj=document.form;
		switch (srcName) {
			case "agmt_act_cust_seq" :
				formObj.agmt_act_cust_seq.value=ComLpad(formObj.agmt_act_cust_seq.value,6,"0");   
			break;
			case "sh_cust_cnt_cd" :
			case "sh_cust_seq" :
				if (ComChkLen(formObj.sh_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.sh_cust_seq.value) > 0) {
					searchMdmCustNm(sheetObjects[0], formObj, "SH", formObj.sh_cust_cnt_cd.value, formObj.sh_cust_seq.value);
					formObj.sh_cust_seq.value=ComLpad(formObj.sh_cust_seq.value,6,"0");  
				}
			break;
			case "ff_cust_cnt_cd" :
			case "ff_cust_seq" :
				if (ComChkLen(formObj.ff_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.ff_cust_seq.value) > 0) {
					searchMdmCustNm(sheetObjects[0], formObj, "FF", formObj.ff_cust_cnt_cd.value, formObj.ff_cust_seq.value);
					formObj.ff_cust_seq.value=ComLpad(formObj.ff_cust_seq.value,6,"0");  
				}
			break;
			case "cn_cust_cnt_cd" :
			case "cn_cust_seq" :
				if (ComChkLen(formObj.cn_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.cn_cust_seq.value) > 0) {
					searchMdmCustNm(sheetObjects[0], formObj, "CN", formObj.cn_cust_cnt_cd.value, formObj.cn_cust_seq.value);
					formObj.cn_cust_seq.value=ComLpad(formObj.cn_cust_seq.value,6,"0");  
				}
			break;
			case "nf_cust_cnt_cd" :
			case "nf_cust_seq" :
				if (ComChkLen(formObj.nf_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.nf_cust_seq.value) > 0) {
					searchMdmCustNm(sheetObjects[0], formObj, "NF", formObj.nf_cust_cnt_cd.value, formObj.nf_cust_seq.value);
					formObj.nf_cust_seq.value=ComLpad(formObj.nf_cust_seq.value,6,"0");  
				}
			break;
			case "an_cust_cnt_cd" :
			case "an_cust_seq" :
				if (ComChkLen(formObj.an_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.an_cust_seq.value) > 0) {
					searchMdmCustNm(sheetObjects[0], formObj, "AN", formObj.an_cust_cnt_cd.value, formObj.an_cust_seq.value);
					formObj.an_cust_seq.value=ComLpad(formObj.an_cust_seq.value,6,"0");  
				}
			break;
		}
		isCopy="false";
		customerDataDiffCheck(formObj);
		return true;
	}
	/**
	 * set value that recevied from Actual Customer
	 */
	function callBackSa0190(rArray){    	
		var formObj=document.form;
		if(rArray != null){
			ComSetObjValue(formObj.agmt_act_cnt_cd, rArray[0][0]);
			ComSetObjValue(formObj.agmt_act_cust_seq, ComLpad(rArray[0][1],6,"0"));
		}
	} 
	/**
	 * set value that recevied from B/L Customer
	 */
	function callBackSh0192(rArray, rArray2) {
		var formObj=document.form;
		if (rArray2) {
	  		if (!ComIsNull(formObj.sh_cust_nm) || !ComIsNull(formObj.sh_cust_addr)) {
	  			if (!ComShowCodeConfirm("BKG00343")) return;
	  		}
	  		kr_cstms_cust_tp_cd.SetEnable(true);
	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray2[1]);
	  		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray2[2],6,"0"));
	  		ComSetObjValue(formObj.sh_cust_cty_nm      , rArray2[11]);  //City
	  		ComSetObjValue(formObj.sh_cust_ste_cd      , rArray2[12]);  //State
	  		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray2[13]);  //Country
	  		ComSetObjValue(formObj.sh_cust_zip_id      , rArray2[14]);  //ZIP Code
	  		ComSetObjValue(formObj.sh_eur_cstms_st_nm  , rArray2[16]);  //Street / P.O.Box
	  		ComSetObjValue(formObj.sh_eori_no          , rArray2[17]);  //EORI#
			searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray2[1],rArray2[2]);
		} else {
//			document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled=false;
			kr_cstms_cust_tp_cd.SetEnable(true);
	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray[0]);
			ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray[1],6,"0"));
			ComSetObjValue(formObj.sh_cust_cty_nm      , rArray[10]);  //City
			ComSetObjValue(formObj.sh_cust_ste_cd      , rArray[11]);  //State
			ComSetObjValue(formObj.sh_cust_zip_id      , rArray[12]);  //ZIP Code
			searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray[0],rArray[1]);
		}
	}
	/**
	 * set value that recevied from B/L Customer
	 */
	function callBackCn0192(rArray, rArray2, type) {
		var formObj=document.form;
		if (rArray2) {
	  		if (!ComIsNull(formObj.cn_cust_nm) || !ComIsNull(formObj.cn_cust_addr)) {
	  			if (!ComShowCodeConfirm("BKG00343")) return;
	  		}
	  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray2[1]);
	  		ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray2[2],6,"0"));
	  		ComSetObjValue(formObj.cn_cust_cty_nm      , rArray2[11]);  //City
	  		ComSetObjValue(formObj.cn_cust_ste_cd      , rArray2[12]);  //State
	  		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray2[13]);  //Country
	  		ComSetObjValue(formObj.cn_cust_zip_id      , rArray2[14]);  //ZIP Code
	  		ComSetObjValue(formObj.cn_eur_cstms_st_nm  , rArray2[16]);  //Street / P.O.Box
	  		ComSetObjValue(formObj.cn_eori_no          , rArray2[17]);  //EORI#
	  		ComSetObjValue(formObj.cn_cust_fax_no      , rArray2[9]);   //Fax
	  		ComSetObjValue(formObj.cn_cust_eml         , rArray2[15]);  //E-mail
			searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray2[1],rArray2[2]);
		} else if (rArray) {
	  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray[0]);
			ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray[1],6,"0"));
			ComSetObjValue(formObj.cn_cust_cty_nm      , rArray[10]);  //City
			ComSetObjValue(formObj.cn_cust_ste_cd      , rArray[11]);  //State
			ComSetObjValue(formObj.cn_cust_zip_id      , rArray[12]);  //ZIP Code
			searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray[0],rArray[1]);
		} else {
			formObj.cn_cust_yn.value = "Y";
    		// IST 강제 이벤트 실행 
    		parent.document.getElementById("btn_opusupload").click();
		}
	}
	/**
	* set value that recevied from B/L Customer
	*/
	function callBackNf0192(rArray, rArray2) {
		var formObj=document.form;
		if (rArray2) {
			if (!ComIsNull(formObj.nf_cust_nm) || !ComIsNull(formObj.nf_cust_addr)) {
				if (!ComShowCodeConfirm("BKG00343")) return;
			}
			ComSetObjValue(formObj.nf_cust_cnt_cd      , rArray2[1]);
			ComSetObjValue(formObj.nf_cust_seq         , ComLpad(rArray2[2],6,"0"));
			ComSetObjValue(formObj.nf_cust_cty_nm      , rArray2[11]);  //City
			ComSetObjValue(formObj.nf_cust_ste_cd      , rArray2[12]);  //State
			ComSetObjValue(formObj.nf_cstms_decl_cnt_cd, rArray2[13]);  //Country
			ComSetObjValue(formObj.nf_cust_zip_id      , rArray2[14]);  //ZIP Code
			ComSetObjValue(formObj.nf_eur_cstms_st_nm  , rArray2[16]);  //Street / P.O.Box
			ComSetObjValue(formObj.nf_eori_no          , rArray2[17]);  //EORI#
			ComSetObjValue(formObj.nf_cust_fax_no      , rArray2[9]);   //Fax
			ComSetObjValue(formObj.nf_cust_eml         , rArray2[15]);  //E-mail
			searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray2[1],rArray2[2]);
		} else {
			ComSetObjValue(formObj.nf_cust_cnt_cd      , rArray[0]);
			ComSetObjValue(formObj.nf_cust_seq         , ComLpad(rArray[1],6,"0"));
			ComSetObjValue(formObj.nf_cust_cty_nm      , rArray[10]);  //City
			ComSetObjValue(formObj.nf_cust_ste_cd      , rArray[11]);  //State
			ComSetObjValue(formObj.nf_cust_zip_id      , rArray[12]);  //ZIP Code
			searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray[0],rArray[1]);
		}
	}
	/**
	* set value that recevied from B/L Customer
	*/
	function callBackFf0192(rArray, rArray2) {
		var formObj=document.form;
		if (rArray2) {
			if (!ComIsNull(formObj.ff_cust_nm)) {
				if (!ComShowCodeConfirm("BKG00343")) return;
			}
			ComSetObjValue(formObj.ff_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray2[2],6,"0"));
			searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray2[1],rArray2[2]);
		} else {
			ComSetObjValue(formObj.ff_cust_cnt_cd, rArray[0]);
			ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray[1],6,"0"));
			searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray[0],rArray[1]);
		}
	}
	/**
	* set value that recevied from B/L Customer
	*/
	function callBackAn0192(rArray, rArray2) {
		var formObj=document.form;
		if (rArray2) {
			if (!ComIsNull(formObj.an_cust_nm)) {
				if (!ComShowCodeConfirm("BKG00343")) return;
			}
			ComSetObjValue(formObj.an_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.an_cust_seq   , ComLpad(rArray2[2],6,"0"));
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray2[1],rArray2[2]);
		} else {
			ComSetObjValue(formObj.an_cust_cnt_cd, rArray[0]);
			ComSetObjValue(formObj.an_cust_seq   , ComLpad(rArray[1],6,"0"));
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray[0],rArray[1]);
		}
	}
	/**
	* set value that recevied from Zip Code
	*/
	 function callBackShZipCode(rArray){
	 	var formObj=document.form;
	 	if(rArray != null){
	 		ComSetObjValue(formObj.sh_cust_cty_nm, rArray[0]);
	 		ComSetObjValue(formObj.sh_cust_ste_cd, rArray[1]);
	 		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray[2]);
	 		ComSetObjValue(formObj.sh_cust_zip_id, rArray[3]);
	 		ComSetObjValue(formObj.sh_eur_cstms_st_nm, rArray[4]);
	 	}
	 } 
	 /**
	 * set value that recevied from Zip Code
	 */
	 function callBackCnZipCode(rArray){
	 	var formObj=document.form;
	 	if(rArray != null){
	 		ComSetObjValue(formObj.cn_cust_cty_nm, rArray[0]);
	 		ComSetObjValue(formObj.cn_cust_ste_cd, rArray[1]);
	 		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray[2]);
	 		ComSetObjValue(formObj.cn_cust_zip_id, rArray[3]);
	 		ComSetObjValue(formObj.cn_eur_cstms_st_nm, rArray[4]);
	 	}
	 } 
	 /**
	 * set value that recevied from Zip Code
	 */
	 function callBackNfZipCode(rArray){
	 	var formObj=document.form;
	 	if(rArray != null){
	 		ComSetObjValue(formObj.nf_cust_cty_nm, rArray[0]);
	 		ComSetObjValue(formObj.nf_cust_ste_cd, rArray[1]);
	 		ComSetObjValue(formObj.nf_cstms_decl_cnt_cd, rArray[2]);
	 		ComSetObjValue(formObj.nf_cust_zip_id, rArray[3]);
	 		ComSetObjValue(formObj.nf_eur_cstms_st_nm, rArray[4]);
	 	}
	 } 
	 
	 // combobox events
	 function kr_cstms_cust_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		 //eval("document.form." + comboObj.options.id + "_text").value = comboObj.GetText(newCode, 0);
	 }
	 
	 function kr_cstms_cust_tp_cd_OnBlur(comboObj) {
		 //eval("document.form." + comboObj.options.id + "_text").value = comboObj.GetText(comboObj.GetSelectCode(), 0);
	 }
	 
	 function customerTextCheck(formObj) {
		 formObj.val_msg_chk.value = "N";
		 var arrTrimVal=new Array();
		 var arrOvflw=new Array();
		 var eSvc=0;
		 var opus=1;
		 var tbl=new Array(
				 new Array ("sh_cust_nm2", 			"sh_cust_nm"),
				 new Array ("sh_cust_addr2", 		"sh_cust_addr"),
				 new Array ("cn_cust_nm2", 			"cn_cust_nm"),
				 new Array ("cn_cust_addr2", 		"cn_cust_addr"),
				 new Array ("nf_cust_nm2", 			"nf_cust_nm"),
				 new Array ("nf_cust_addr2", 		"nf_cust_addr"),
				 new Array ("ff_cust_nm2", 			"ff_cust_nm"),
				 new Array ("an_cust_nm2", 			"an_cust_nm"),
				 new Array ("ex_cust_nm2", 			"ex_cust_nm")
				);
		 for (i=0; i < tbl.length; i++) {
			var eSvcElem=document.getElementsByName(tbl[i][eSvc])[0];
			var opusElem=document.getElementsByName(tbl[i][opus])[0];
			var opusElemRows=document.getElementsByName(tbl[i][opus])[0].rows;
			if (ComTrim(opusElem.value) != "") {
				var txtVal = "";
				var z=1;
				var arrText = opusElem.value.split("\n");
			    for (var j=0, line=[]; j < arrText.length; j++) {
			    	if (arrText[j].length > 35) {
			    		for (k=0; k < Math.ceil(arrText[j].length/35); k++) {
						     if (z > opusElemRows) {
						    	 if (opusElem.name == "sh_cust_nm" || opusElem.name == "sh_cust_addr") {
						    		if (arrTrimVal[arrTrimVal.length-1] != "Shipper") {
						    			 arrTrimVal[arrTrimVal.length] = "Shipper";
						    			 arrOvflw[arrOvflw.length] = "S";
					    		 	}
						    	 }else if (opusElem.name == "cn_cust_nm" || opusElem.name == "cn_cust_addr") {
						    		 if (arrTrimVal[arrTrimVal.length-1] != "Consignee") {
						    			 arrTrimVal[arrTrimVal.length] = "Consignee";							
						    			 arrOvflw[arrOvflw.length] = "C";
						    		 }
						    	 }else if (opusElem.name == "nf_cust_nm" || opusElem.name == "nf_cust_addr") {
						    		 if (arrTrimVal[arrTrimVal.length-1] != "Notify") {
						    			 arrTrimVal[arrTrimVal.length] = "Notify";							
						    			 arrOvflw[arrOvflw.length] = "N";
						    		 }
						    	 }else if (opusElem.name == "ff_cust_nm") {
						    		 arrTrimVal[arrTrimVal.length] = "Forwarder";
					    			 arrOvflw[arrOvflw.length] = "F";
						    	 }else if (opusElem.name == "an_cust_nm") {
						    		 arrTrimVal[arrTrimVal.length] = "Also NTFY";
					    			 arrOvflw[arrOvflw.length] = "A";
						    	 }else if (opusElem.name == "ex_cust_nm") {
						    		 arrTrimVal[arrTrimVal.length] = "Export";
					    			 arrOvflw[arrOvflw.length] = "E";
						    	 }
						    	 break;
						     }else{
						    	 if (z < opusElemRows) {
							    	 txtVal = txtVal + arrText[j].substring((k*35), ((k+1)*35)) + "\n";						    		 
						    	 }else{
							    	 txtVal = txtVal + arrText[j].substring((k*35), ((k+1)*35));						    		 
						    	 }
						     }
						     z++;
			    		}
			    	}else{
 				    	if (z > opusElemRows && arrText[j].trim() != "") {
 				    		if (opusElem.name == "sh_cust_nm" || opusElem.name == "sh_cust_addr") {
					    		arrTrimVal[arrTrimVal.length] = "Shipper";
					    		arrOvflw[arrOvflw.length] = "S";
					    	 }else if (opusElem.name == "cn_cust_nm" || opusElem.name == "cn_cust_addr") {
					    		arrTrimVal[arrTrimVal.length] = "Consignee";							
					    		arrOvflw[arrOvflw.length] = "C";
					    	 }else if (opusElem.name == "nf_cust_nm" || opusElem.name == "nf_cust_addr") {
					    		arrTrimVal[arrTrimVal.length] = "Notify";							
					    		arrOvflw[arrOvflw.length] = "N";
					    	 }else if (opusElem.name == "ff_cust_nm") {
					    		 arrTrimVal[arrTrimVal.length] = "Forwarder";
				    			 arrOvflw[arrOvflw.length] = "F";
					    	 }else if (opusElem.name == "an_cust_nm") {
					    		 arrTrimVal[arrTrimVal.length] = "Also NTFY";
				    			 arrOvflw[arrOvflw.length] = "A";
					    	 }else if (opusElem.name == "ex_cust_nm") {
					    		 arrTrimVal[arrTrimVal.length] = "Export";
				    			 arrOvflw[arrOvflw.length] = "E";
					    	 }
 				    		break;
 				    	}else{
					    	 if (z < opusElemRows && z < arrText.length) {
		 			    			txtVal = txtVal + arrText[j] + "\n";
					    	 }else{
		 			    			txtVal = txtVal + arrText[j];
					    	 }
 				    	}
			    		z++;
			    	}
			    }
			    opusElem.value=txtVal.substring(0, txtVal.length).toUpperCase();			    	
			}
			
		}		
		formObj.val_msg.value = arrTrimVal.toString();
		formObj.nm_and_addr_ovflw_flg.value = arrOvflw.toString();
	}