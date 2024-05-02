/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_05.js
*@FileTitle  : Customer Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
===============================================================================
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    /**
     * @extends 
     * @class ESM_BKG_0079_05 : business script for ESM_BKG_0079_05 
     */
//    function ESM_BKG_0079_05() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
 // Common global variable
    var comboObjects=new Array();
    var comboCnt=0;     
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isShowOrgBlNo=true;
    var sheetOverFlgList = ["sh_ovflw_flg", "cn_ovflw_flg", "nf_ovflw_flg", "ff_ovflw_flg", "an_ovflw_flg", "ex_ovflw_flg"];
    var ovrChkFlgAll = [ "sh_ovflw_chk_flg", "cn_ovflw_chk_flg", "nf_ovflw_chk_flg", "ff_ovflw_chk_flg", "an_ovflw_chk_flg", "ex_ovflw_chk_flg" ];
    var ovrChkFlgLblAll = [ "sh_ovflw_chk_flg_lbl", "cn_ovflw_chk_flg_lbl", "nf_ovflw_chk_flg_lbl", "ff_ovflw_chk_flg_lbl", "an_ovflw_chk_flg_lbl", "ex_ovflw_chk_flg_lbl" ];
    var ovrDtlBtnAll = [ "btn_sh_cust_nm_detail", "btn_cn_cust_nm_detail", "btn_nf_cust_nm_detail", "btn_ff_cust_nm_detail", "btn_an_cust_nm_detail", "btn_ex_cust_nm_detail" ];
    var ovrDtlBtnLblAll = [ "btn_sh_cust_nm_detail_lbl", "btn_cn_cust_nm_detail_lbl", "btn_nf_cust_nm_detail_lbl", "btn_ff_cust_nm_detail_lbl", "btn_an_cust_nm_detail_lbl", "btn_ex_cust_nm_detail_lbl" ]
    // Event handler processing by button click event */
    document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
    // Event handler processing by button name */
        function processButtonClick(){
             /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
            var sheetObject1=sheetObjects[0];
             /*******************************************************/
            var formObject=document.form;
     		var bkgNo=formObject.bkg_no.value;
    		var blNo=formObject.bl_no.value;
    		var modifyFlag=formObject.modify_flag.value;
        	try {
        		var srcName=ComGetEvent("name");
        		if(srcName != "btn_splitPop"){
            		if(layList.style.display == ""){
            			layList.style.display="none";
            		}    	    			
        		}
                switch(srcName) {
					case "btn_splitPop":
						doActionIBSheet(sheetObject1,formObject,COMMAND03);					
						break;           
					case "btn_OrgBlPop":
						if(isShowOrgBlNo){
							blNoSet();
							isShowOrgBlNo=false;
						}else{
							blNoHide();
							isShowOrgBlNo=true;
						}					
						break;						
    				case "btn_t5retrieve":
                		if(bkgNo != null && bkgNo.length > 0){
                			ComResetAll();
                			formObject.bkg_no.value=bkgNo;
                			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                		}else if(blNo != null && blNo.length > 0){
                			ComResetAll();
                			formObject.bl_no.value=blNo;
                			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                		}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObject.bkg_no);            			
                		}
    					break;
    				case "btn_t7New":   					
    					setCustomerEditable(true);
    					changeDisplayOnOff(ovrChkFlgAll, "On");
    		        	changeDisplayOnOff(ovrChkFlgLblAll, "On");
    		        	changeDisplayOnOff(ovrDtlBtnAll, "On");
    		        	changeBtnEnable(ovrChkFlgAll, "Off");
    		        	changeBtnEnable(ovrChkFlgLblAll, "Off");
    		        	changeBtnEnable(ovrDtlBtnAll, "Off");
    		        	setOvrChkFlg("Off");
    		        	changeDisplayColor(ovrChkFlgLblAll, "gray");
    					ComResetAll();
/*
    					if(modifyFlag == "Y"){    						
							if(ComShowCodeConfirm("BKG00169")){
								ComResetAll();
							}    						
    					}else{
    						ComResetAll();
    					}
*/    					
    					break;
    				case "btn_t7Save":    					
    					doActionIBSheet(sheetObject1, formObject, IBSAVE);
    					break;
    				case "btn_t7CustomerCodeRqst":
    					var url="ESM_BKG_0957.do?pgmNo=ESM_BKG_0957&bkg_no="+formObject.bkg_no.value;
    					url=url + "&bl_no="+formObject.bl_no.value;
    					url=url + "&bl_no_tp="+formObject.bl_no_tp.value;
    					url=url + "&bl_tp_cd="+formObject.bl_tp_cd.value;
    					url=url + "&sh_cust_cnt_cd="+formObject.sh_cust_cnt_cd.value;
    					url=url + "&sh_cust_seq="+formObject.sh_cust_seq.value;
    					//url = url + "&sh_cust_tp_cd="+formObject.sh_cust_tp_cd.value;
    					url=url + "&sh_cust_nm="+formObject.sh_cust_nm.value;
    					url=url + "&sh_cust_addr="+formObject.sh_cust_addr.value;
    					url=url + "&sh_cust_cty_nm="+formObject.sh_cust_cty_nm.value;
    					url=url + "&sh_cust_ste_cd="+formObject.sh_cust_ste_cd.value;
    					url=url + "&sh_cstms_decl_cnt_cd="+formObject.sh_cstms_decl_cnt_cd.value;
    					url=url + "&sh_cust_zip_id="+formObject.sh_cust_zip_id.value;
    					url=url + "&cn_cust_cnt_cd="+formObject.cn_cust_cnt_cd.value;
    					url=url + "&cn_cust_seq="+formObject.cn_cust_seq.value;
    					//url = url + "&cn_cust_tp_cd="+formObject.cn_cust_tp_cd.value;
    					url=url + "&cn_cust_nm="+formObject.cn_cust_nm.value;
    					url=url + "&cn_cust_addr="+formObject.cn_cust_addr.value;
    					url=url + "&cn_cust_cty_nm="+formObject.cn_cust_cty_nm.value;
    					url=url + "&cn_cust_ste_cd="+formObject.cn_cust_ste_cd.value;
    					url=url + "&cn_cstms_decl_cnt_cd="+formObject.cn_cstms_decl_cnt_cd.value;
    					url=url + "&cn_cust_zip_id="+formObject.cn_cust_zip_id.value;    					
    					url=url + "&cn_cust_fax_no="+formObject.cn_cust_fax_no.value;
    					url=url + "&cn_cust_eml="+formObject.cn_cust_eml.value;
    					url=url + "&nf_cust_cnt_cd="+formObject.nf_cust_cnt_cd.value;
    					url=url + "&nf_cust_seq="+formObject.nf_cust_seq.value;
    					//url = url + "&nf_cust_tp_cd="+formObject.nf_cust_tp_cd.value;
    					url=url + "&nf_cust_nm="+formObject.nf_cust_nm.value;
    					url=url + "&nf_cust_addr="+formObject.nf_cust_addr.value;
    					url=url + "&nf_cust_cty_nm="+formObject.nf_cust_cty_nm.value;
    					url=url + "&nf_cust_ste_cd="+formObject.nf_cust_ste_cd.value;
    					url=url + "&nf_cstms_decl_cnt_cd="+formObject.nf_cstms_decl_cnt_cd.value;
    					url=url + "&nf_cust_zip_id="+formObject.nf_cust_zip_id.value;    					
    					url=url + "&nf_cust_fax_no="+formObject.nf_cust_fax_no.value;
    					url=url + "&nf_cust_eml="+formObject.nf_cust_eml.value;
    					ComOpenPopup(url,520, 220, "","1,0,1,1,1", true);
    					break;
    				case "btn_t7EDIRemark":
    					break;
    				case "btn_t7Sa0190":   
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}
    					var scNo=formObject.sc_no.value;
    					var rfaNo=formObject.rfa_no.value;
    					var svcScpCd=formObject.svc_scp_cd.value;
    					var strCaFlg=formObject.ca_flg.value; 
    					ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObject.bkg_no.value+"&sc_no="
    							+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ formObject.appl_dt.value+"&ca_flg="+strCaFlg
    							,800, 390, "callBackSa0190","1,0,1,1,1", true);
    					break;        					
    				case "btn_t7Sh0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=ComGetObjValue(formObject.sh_cust_cnt_cd);
    					var custSeq=ComGetObjValue(formObject.sh_cust_seq);
    					var custNm="";
    					var custAddr="";
    					if(ComChkLen(formObject.sh_cust_nm) != 1){
    						custNm=ComGetObjValue(formObject.sh_cust_nm).substring(0,10);
    					}else{
    						custNm=ComGetObjValue(formObject.sh_cust_nm);
    					}
    					if(ComChkLen(formObject.sh_cust_addr) != 1){
    						custAddr=ComGetObjValue(formObject.sh_cust_addr).substring(0,10);
    					}else{
    						custAddr=ComGetObjValue(formObject.sh_cust_addr);
    					}    					
    					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";
    					ComOpenPopup(url,970, 655, "callBackSh0192","0,0,1,1,1", true);
    					break;    		
    				case "btn_t7Cn0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.cn_cust_cnt_cd.value;
    					var custSeq=formObject.cn_cust_seq.value;
    					var custNm="";
    					var custAddr="";
    					if(ComChkLen(formObject.cn_cust_nm) != 1){
    						custNm=ComGetObjValue(formObject.cn_cust_nm).substring(0,10);
    					}else{
    						custNm=ComGetObjValue(formObject.cn_cust_nm);
    					}
    					if(ComChkLen(formObject.cn_cust_addr) != 1){
    						custAddr=ComGetObjValue(formObject.cn_cust_addr).substring(0,10);
    					}else{
    						custAddr=ComGetObjValue(formObject.cn_cust_addr);
    					}    					
    					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
    					ComOpenPopup(url,970, 655, "callBackCn0192","0,0,1,1,1", true);
    					break;    		
    				case "btn_t7Nf0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}
    					var custCntCd=formObject.nf_cust_cnt_cd.value;
    					var custSeq=formObject.nf_cust_seq.value;
    					var custNm="";
    					var custAddr="";
    					if(ComChkLen(formObject.nf_cust_nm) != 1){
    						custNm=ComGetObjValue(formObject.nf_cust_nm).substring(0,10);
    					}else{
    						custNm=ComGetObjValue(formObject.nf_cust_nm);
    					}
    					if(ComChkLen(formObject.nf_cust_addr) != 1){
    						custAddr=ComGetObjValue(formObject.nf_cust_addr).substring(0,10);
    					}else{
    						custAddr=ComGetObjValue(formObject.nf_cust_addr);
    					}    					
    					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
    					ComOpenPopup(url,970, 655, "callBackNf0192","0,0,1,1,1", true);
    					break;    		
    				case "btn_t7Ff0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.ff_cust_cnt_cd.value;
    					var custSeq=formObject.ff_cust_seq.value;
       					var custNm="";
    					if(ComChkLen(formObject.ff_cust_nm) != 1){
    						custNm=ComGetObjValue(formObject.ff_cust_nm).substring(0,10);
    					}else{
    						custNm=ComGetObjValue(formObject.ff_cust_nm);
    					}
    					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    					
    					ComOpenPopup(url,970, 655, "callBackFf0192","0,0,1,1,1", true);
    					break;    		
    				case "btn_t7An0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.an_cust_cnt_cd.value;
    					var custSeq=formObject.an_cust_seq.value;
       					var custNm="";
    					if(ComChkLen(formObject.an_cust_nm) != 1){
    						custNm=ComGetObjValue(formObject.an_cust_nm).substring(0,10);
    					}else{
    						custNm=ComGetObjValue(formObject.an_cust_nm);
    					}
    					var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    		    					
    					ComOpenPopup(url,970, 655, "callBackAn0192","0,0,1,1,1", true);
    					break;    	
    				case "btn_t7Ex0192":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.ex_cust_cnt_cd.value;
    					var custSeq=formObject.ex_cust_seq.value;
    					ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq,970, 655, "callBackEx0192","0,0,1,1,1", true);
    					break;       					
    				case "btn_t7ShMdmCustNm":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.sh_cust_cnt_cd.value;
    					var custSeq=formObject.sh_cust_seq.value;
    					var custNm=formObject.sh_cust_nm.value;
    					var custAddress=formObject.sh_cust_addr.value;
    					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
    						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
    							if(ComShowCodeConfirm("BKG00343")){
    								formObject.sh_cust_nm.value=getMakeBrData("NAME",formObject.sh_cust_lgl_eng_nm.value);
    								formObject.sh_cust_addr.value=getMakeBrData("ADDR",formObject.sh_mdm_address.value); 
    							}
    						}else{
								formObject.sh_cust_nm.value=getMakeBrData("NAME",formObject.sh_cust_lgl_eng_nm.value);
								formObject.sh_cust_addr.value=getMakeBrData("ADDR",formObject.sh_mdm_address.value); 
    						}
    					}else{
    						ComShowCodeMessage("BKG00340");
    					}
    					break;     	
    				case "btn_t7CnMdmCustNm":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.cn_cust_cnt_cd.value;
    					var custSeq=formObject.cn_cust_seq.value;
    					var custNm=formObject.cn_cust_nm.value;
    					var custAddress=formObject.cn_cust_addr.value;
    					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
    						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
    							if(ComShowCodeConfirm("BKG00343")){
    								formObject.cn_cust_nm.value=getMakeBrData("NAME",formObject.cn_cust_lgl_eng_nm.value);
    								formObject.cn_cust_addr.value=getMakeBrData("ADDR",formObject.cn_mdm_address.value); 
    							}
    						}else{
								formObject.cn_cust_nm.value=getMakeBrData("NAME",formObject.cn_cust_lgl_eng_nm.value);
								formObject.cn_cust_addr.value=getMakeBrData("ADDR",formObject.cn_mdm_address.value); 
    						}
    					}else{
    						ComShowCodeMessage("BKG00340");
    					}
    					break;     		
    				case "btn_t7NfMdmCustNm":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.nf_cust_cnt_cd.value;
    					var custSeq=formObject.nf_cust_seq.value;
    					var custNm=formObject.nf_cust_nm.value;
    					var custAddress=formObject.nf_cust_addr.value;
    					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
    						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
    							if(ComShowCodeConfirm("BKG00343")){
    								formObject.nf_cust_nm.value=getMakeBrData("NAME",formObject.nf_cust_lgl_eng_nm.value);
    								formObject.nf_cust_addr.value=getMakeBrData("ADDR",formObject.nf_mdm_address.value); 
    							}
    						}else{
								formObject.nf_cust_nm.value=getMakeBrData("NAME",formObject.nf_cust_lgl_eng_nm.value);
								formObject.nf_cust_addr.value=getMakeBrData("ADDR",formObject.nf_mdm_address.value); 
    						}
    					}else{
    						ComShowCodeMessage("BKG00340");
    					}
    					break;     		
    				case "btn_t7FfMdmCustNm":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.ff_cust_cnt_cd.value;
    					var custSeq=formObject.ff_cust_seq.value;
    					var custNm=formObject.ff_cust_nm.value;
    					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
    						if(!ComIsNull(custNm)){
    							if(ComShowCodeConfirm("BKG00343")){    								
    								if(ComIsNull(formObject.ff_cust_lgl_eng_nm.value)){
    									formObject.ff_cust_nm.value=getMakeBrData("ADDR",formObject.ff_mdm_address.value);
    								}else{
    									if(!ComIsNull(formObject.ff_mdm_address.value)){
    										formObject.ff_cust_nm.value=getMakeBrData("NAME",formObject.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.ff_mdm_address.value); 
    									}
    								}
    							}
    						}else{
								if(ComIsNull(formObject.ff_cust_lgl_eng_nm.value)){
									formObject.ff_cust_nm.value=getMakeBrData("ADDR",formObject.ff_mdm_address.value);
								}else{
									if(!ComIsNull(formObject.ff_mdm_address.value)){
										formObject.ff_cust_nm.value=getMakeBrData("NAME",formObject.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.ff_mdm_address.value); 
									}
								}
    						}
    					}else{
    						ComShowCodeMessage("BKG00340");
    					}
    					break;     		
    				case "btn_t7AnMdmCustNm":    		
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var custCntCd=formObject.an_cust_cnt_cd.value;
    					var custSeq=formObject.an_cust_seq.value;
    					var custNm=formObject.an_cust_nm.value;
    					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
    						if(!ComIsNull(custNm)){
    							if(ComShowCodeConfirm("BKG00343")){
    								if(ComIsNull(formObject.an_cust_lgl_eng_nm.value)){
    									formObject.an_cust_nm.value=getMakeBrData("ADDR",formObject.an_mdm_address.value);
    								}else{
    									if(!ComIsNull(formObject.an_mdm_address.value)){
    										formObject.an_cust_nm.value=getMakeBrData("NAME",formObject.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.an_mdm_address.value); 
    									}
    								}
    							}
    						}else{
								if(ComIsNull(formObject.an_cust_lgl_eng_nm.value)){
									formObject.an_cust_nm.value=getMakeBrData("ADDR",formObject.an_mdm_address.value);
								}else{
									if(!ComIsNull(formObject.an_mdm_address.value)){										
										formObject.an_cust_nm.value=getMakeBrData("NAME",formObject.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.an_mdm_address.value); 
									}
								}
    						}
    					}else{
    						ComShowCodeMessage("BKG00340");
    					}
    					break;     		    	
    				case "btn_t7FwRefNo":    	
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var ffRefNo=formObject.ff_ref_no.value;
    					if(!ComIsNull(ffRefNo)){
    						var exCustNm=formObject.ex_cust_nm.value;
    						if(ComIsNull(exCustNm)){
    							formObject.ex_cust_nm.value=ffRefNo;
    						}else{
    							if(countLineBreaks(exCustNm) >= 2){
    								ComShowCodeMessage("BKG00381");
    							}else{
    								formObject.ex_cust_nm.value=exCustNm + "\n" + ffRefNo;
    							}
    						}
    					}
    					break;    
    				case "btn_t7ExRef":
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var bkg_no=ComGetObjValue(formObject.bkg_no);
    					if(!ComIsNull(bkg_no)){
        					var url="ESM_BKG_0367_02.do?func=callBackExRef&bkg_no="+bkg_no;
        					ComOpenWindow(url, "ESM_BKG_0367_02", "dialogWidth:900px;dialogHeight:650px", true);
    					}
    					break;   					
    				case "btn_t7Delete":    	
    					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    						break;
    					}    					
    					var agmtActCustCntCd=formObject.agmt_act_cnt_cd.value;
    					if(!ComIsNull(agmtActCustCntCd)){
    						formObject.agmt_act_cnt_cd.value="";
    						formObject.agmt_act_cust_seq.value="";
    					}
    					break;    
    				case "btn_t7ShZipCode":
    					var zip_cd=formObject.sh_cust_zip_id.value;
    					var cnt_cd=formObject.sh_cust_cnt_cd.value;
    					ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd,1000, 520, "callBackShZipCode","0,1,1,1,1", true);
    					break;
    				case "btn_t7CnZipCode":
    					var zip_cd=formObject.cn_cust_zip_id.value;
    					var cnt_cd=formObject.cn_cust_cnt_cd.value;
    					ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd,1000, 520, "callBackCnZipCode","0,1,1,1,1", true);			
    					break;
    				case "btn_t7NfZipCode":
    					var zip_cd=formObject.nf_cust_zip_id.value;
    					var cnt_cd=formObject.nf_cust_cnt_cd.value;
    					ComOpenPopup("/opuscntr/ESM_BKG_1114_POP.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd,1000, 520, "callBackNfZipCode","0,1,1,1,1", true);			
    					break;
    				case "btn_sh_cust_nm_detail":
    					if(!document.getElementById("btn_sh_cust_nm_detail").disabled){
    						var MEMO_TEXT_SH = [ "memoTextSh01", "memoTextSh02" ];
        					var MEMO_TEXT_TITLE_SH = [ "NAME", "Address" ];
        					var MEMO_TEXT_VALUE_SH = [ memoShowValue("sh_cust_nm"), memoShowValue("sh_cust_addr")];
        					var shAppScreenObjList = [ "sh_cust_nm", "sh_cust_addr" ];
        					if(ComGetObjValue(formObject.isInquiry) == "Y" || sheetObjects[1].GetCellValue(1, "sh_ovflw_flg") == "N" | sheetObjects[1].GetCellValue(1, "sh_ovflw_flg") == "" ){
        						ComShowFormMemoPad("btn_sh_cust_nm_detail", "DivMemoSh", MEMO_TEXT_SH, MEMO_TEXT_TITLE_SH, MEMO_TEXT_VALUE_SH, true, 15, 120, true, false, shAppScreenObjList);
        					}else{
        						ComShowFormMemoPad("btn_sh_cust_nm_detail", "DivMemoSh", MEMO_TEXT_SH, MEMO_TEXT_TITLE_SH, MEMO_TEXT_VALUE_SH, true, 15, 120, false, true, shAppScreenObjList);
        					}
    					}
    					break;
    				case "btn_ff_cust_nm_detail":
    					if(!document.getElementById("btn_ff_cust_nm_detail").disabled){
	    					var MEMO_TEXT_FF = [ "memoTextFf01" ];
	    					var MEMO_TEXT_TITLE_FF = [ "Name & Address" ];
	    					var MEMO_TEXT_VALUE_FF = [ memoShowValue("ff_cust_nm")];
	    					var ffAppScreenObjList = [ "ff_cust_nm" ];
	    					if(ComGetObjValue(formObject.isInquiry) == "Y" || sheetObjects[1].GetCellValue(1, "ff_ovflw_flg") == "N" || sheetObjects[1].GetCellValue(1, "ff_ovflw_flg") == "" ){
	    						ComShowFormMemoPad("btn_ff_cust_nm_detail", "DivMemoFf", MEMO_TEXT_FF, MEMO_TEXT_TITLE_FF, MEMO_TEXT_VALUE_FF, true, 620, 120, true, false, ffAppScreenObjList);
	    					}else{
	    						ComShowFormMemoPad("btn_ff_cust_nm_detail", "DivMemoFf", MEMO_TEXT_FF, MEMO_TEXT_TITLE_FF, MEMO_TEXT_VALUE_FF, true, 620, 120, false, true, ffAppScreenObjList);
	    					}
    					}
    					break;
    				case "btn_cn_cust_nm_detail":
    					if(!document.getElementById("btn_cn_cust_nm_detail").disabled){
	    					var MEMO_TEXT_CN = [ "memoTextCn01", "memoTextCn02" ];
	    					var MEMO_TEXT_TITLE_CN = [ "NAME", "Address" ];
	    					var MEMO_TEXT_VALUE_CN = [ memoShowValue("cn_cust_nm"), memoShowValue("cn_cust_addr") ];
	    					var cnAppScreenObjList = [ "cn_cust_nm", "cn_cust_addr" ];
	    					if(ComGetObjValue(formObject.isInquiry) == "Y" || sheetObjects[1].GetCellValue(1, "cn_ovflw_flg") == "N" || sheetObjects[1].GetCellValue(1, "cn_ovflw_flg") == ""){
	    						ComShowFormMemoPad("btn_cn_cust_nm_detail", "DivMemoCn", MEMO_TEXT_CN, MEMO_TEXT_TITLE_CN, MEMO_TEXT_VALUE_CN, true, 15, 360, true, false, cnAppScreenObjList);
	    					}else{
	    						ComShowFormMemoPad("btn_cn_cust_nm_detail", "DivMemoCn", MEMO_TEXT_CN, MEMO_TEXT_TITLE_CN, MEMO_TEXT_VALUE_CN, true, 15, 360, false, true, cnAppScreenObjList);
	    					}
    					}
    					break;
    				case "btn_an_cust_nm_detail":
    					if(!document.getElementById("btn_an_cust_nm_detail").disabled){
	    					var MEMO_TEXT_AN = [ "memoTextAn01" ];
	    					var MEMO_TEXT_TITLE_AN = [ "Name & Address" ];
	    					var MEMO_TEXT_VALUE_AN = [ memoShowValue("an_cust_nm") ];
	    					var anAppScreenObjList = [ "an_cust_nm" ];
	    					if(ComGetObjValue(formObject.isInquiry) == "Y"|| sheetObjects[1].GetCellValue(1, "an_ovflw_flg") == "N" || sheetObjects[1].GetCellValue(1, "an_ovflw_flg") == "" ){
	    						ComShowFormMemoPad("btn_an_cust_nm_detail", "DivMemoAn", MEMO_TEXT_AN, MEMO_TEXT_TITLE_AN, MEMO_TEXT_VALUE_AN, true, 620, 360, true, false, anAppScreenObjList);
	    					}else{
	    						ComShowFormMemoPad("btn_an_cust_nm_detail", "DivMemoAn", MEMO_TEXT_AN, MEMO_TEXT_TITLE_AN, MEMO_TEXT_VALUE_AN, true, 620, 360, false, true, anAppScreenObjList);
	    					}
    					}
    					break;
    				case "btn_nf_cust_nm_detail":
    					if(!document.getElementById("btn_nf_cust_nm_detail").disabled){
	    					var MEMO_TEXT_NF = [ "memoTextNf01", "memoTextNf02" ];
	    					var MEMO_TEXT_TITLE_NF = [ "NAME", "Address" ];
	    					var MEMO_TEXT_VALUE_NF = [ memoShowValue("nf_cust_nm"), memoShowValue("nf_cust_addr")];
	    					var nfAppScreenObjList = [ "nf_cust_nm", "nf_cust_addr" ];
	    					if(ComGetObjValue(formObject.isInquiry) == "Y"|| sheetObjects[1].GetCellValue(1, "nf_ovflw_flg") == "N" || sheetObjects[1].GetCellValue(1, "nf_ovflw_flg") == ""){
	    						ComShowFormMemoPad("btn_nf_cust_nm_detail", "DivMemoNf", MEMO_TEXT_NF, MEMO_TEXT_TITLE_NF, MEMO_TEXT_VALUE_NF, true, 15, 625, true, false, nfAppScreenObjList);
	    					}else{
	    						ComShowFormMemoPad("btn_nf_cust_nm_detail", "DivMemoNf", MEMO_TEXT_NF, MEMO_TEXT_TITLE_NF, MEMO_TEXT_VALUE_NF, true, 15, 625, false, true, nfAppScreenObjList);
	    					}
    					}
    					break;
    				case "btn_ex_cust_nm_detail":
    					if(!document.getElementById("btn_ex_cust_nm_detail").disabled){
	    					var MEMO_TEXT_EX = [ "memoTextEx01" ];
	    					var MEMO_TEXT_TITLE_EX = [ "NExport Ref." ];
	    					var MEMO_TEXT_VALUE_EX = [ memoShowValue("ex_cust_nm") ];
	    					var exAppScreenObjList = [ "ex_cust_nm" ];
	    					if(ComGetObjValue(formObject.isInquiry) == "Y"|| sheetObjects[1].GetCellValue(1, "xter_ex_ovflw_flg") == "N" || sheetObjects[1].GetCellValue(1, "xter_ex_ovflw_flg") == ""){
	    						ComShowFormMemoPad("btn_ex_cust_nm_detail", "DivMemoEx", MEMO_TEXT_EX, MEMO_TEXT_TITLE_EX, MEMO_TEXT_VALUE_EX, true, 620, 625, true, false, exAppScreenObjList);
	    					}else{
	    						ComShowFormMemoPad("btn_ex_cust_nm_detail", "DivMemoEx", MEMO_TEXT_EX, MEMO_TEXT_TITLE_EX, MEMO_TEXT_VALUE_EX, true, 620, 625, false, true, exAppScreenObjList);
	    					}
    					}
    					break;
                } // end switch
        	}catch(e) {
        		if( e.name == "TypeError") {
        			return false;
        		}else{
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
         * adding first-served functions after loading screen.
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
       	    // IBMultiCombo initialization
       	    for(var j=0; j<comboObjects.length; j++){
       	        initCombo(comboObjects[j]);
       	    }     
            var formObj=document.form;
            initDisplayOnOff();
            if(formObj.old_bkg_no.value != ""){ 
            	formObj.bkg_no.value=formObj.old_bkg_no.value;
            	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            } else {
				ComSetFocus(formObj.bkg_no);
            }
			if(ComGetObjValue(formObj.isInquiry) == "Y"){
				ComBtnDisable("btn_t7Save");
				ComBtnDisable("btn_t7CustomerCodeRqst");
			}				
            initControl();
        }
        
	 /**
	  * The initial setting combo
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator("|");
	}
   /**
   * registering IBCombo Object as list
   * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
   **/
   function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
   }	  
	function initControl() {
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress','bkg007905_keypress',formObject); //- When typing the keyboard
		axon_event.addListenerForm('blur', 'bkg007905_blur',  formObject); //- out  focus 
		axon_event.addListenerForm('click', 'bkg007905_click',    formObject); //- in case of occurring click event
		axon_event.addListenerForm('change', 'bkg007905_change',    formObject); //- in case of occurring change event
		axon_event.addListenerForm('keydown', 'check_Enter', document.form);
		applyShortcut();
		inputEngSet();
	}

	function check_Enter() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (event.keyCode == 13) {
			if(ComGetEvent("name") == "bkg_no" || ComGetEvent("name") == "bl_no"){
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);  
			}
		}
	}	
	
    var inputEngSet = function(){
        $("[data-eng='on']").keyup(function(event){
    	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
    	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
    		                                 var inputVal = $(this).val();
    	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
    	                                 }
                             });
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
			case "t7sheet1":
			    with(sheetObj){		    
			      var HeadTitle="|";	
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];			       
			      InitColumns(cols);	
			      SetEditable(1);			    
			      SetVisible(false);
		        }
				break;
			case "t7sheet2":
			    with(sheetObj){		    
			      var HeadTitle="eBKG S/I SH OVERLENTH FLAG|eBKG S/I SH Name|eBKG S/I SH Address|eBKG S/I CN OVERLENTH FLAG|eBKG S/I CN Name|eBKG S/I CN Address|eBKG S/I NF OVERLENTH FLAG|eBKG S/I NF Name|eBKG S/I NF Address|eBKG S/I FF OVERLENTH FLAG|eBKG S/I FF Name|eBKG S/I AN OVERLENTH FLAG|eBKG S/I AN Name|eBKG S/I EX OVERLENTH FLAG|eBKG S/I EX Name";	
//			      var HeadTitle="||||||||||||||||"
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);	
			      var cols = [ {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"sh_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"sh_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  		   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"sh_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"cn_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"cn_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  	   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"cn_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  	   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"nf_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"nf_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  	   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"nf_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                  	   {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"ff_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"ff_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"an_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"an_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"ex_ovflw_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"ex_cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			      			  ];			       
			      InitColumns(cols);	
			      SetEditable(0);	
			      SetVisible(false);
		        }
				break;
	    }
	}
      // Sheet handling process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = 1;
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(ComIsNull(formObj.bkg_no.value) && ComIsNull(formObj.bl_no.value)){
					ComShowCodeMessage("BKG00426");
					return false; 					
				}
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&bl_no="+formObj.bl_no.value);
				ComOpenWait(false); 
				var arrXml=sXml.split("|$$|");  
        		// setting Combo
				if (arrXml.length > 0){	
    				//ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
    				ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
    				sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
				}   				
				BkgEtcDataXmlToForm(arrXml[0], formObj);		// Booking Customer information
				formObj.old_bkg_no.value=ComGetEtcData(arrXml[0],"bkg_no");
				formObj.old_bl_no.value=ComGetEtcData(arrXml[0],"bl_no");
				var orgBlNo=ComGetEtcData(arrXml[0], "OrgBlNo");
				var frobFlag=ComGetEtcData(arrXml[0], "frob_flag");
				var polCd=ComGetEtcData(arrXml[0], "pol_cd");
				var podCd=ComGetEtcData(arrXml[0], "pod_cd");
				var delCd=ComGetEtcData(arrXml[0], "del_cd");
				var agmtActCntCd=ComGetEtcData(arrXml[0],"agmt_act_cnt_cd");
				var agmtActCustSeq=ComGetEtcData(arrXml[0],"agmt_act_cust_seq")!=""?ComLpad(ComGetEtcData(arrXml[0],"agmt_act_cust_seq"),6,0):""
				formObj.old_act_cust_cd.value=agmtActCntCd +agmtActCustSeq;
				if(ComIsNull(formObj.cn_cust_cnt_cd.value)){
					if(!ComIsNull(delCd)){
						ComSetObjValue(formObj.cn_cust_cnt_cd, delCd.substring(0,2));	
					}
				}
				if(ComIsNull(formObj.nf_cust_cnt_cd.value)){
					if(!ComIsNull(delCd)){
						ComSetObjValue(formObj.nf_cust_cnt_cd, delCd.substring(0,2));
					}
				}
				if(ComGetEtcData(arrXml[0],"kr_cstms_cust_tp_cd") == ""){
//					if(ComGetEtcData(sXml,"sh_cust_tp") == "B"){
//						kr_cstms_cust_tp_cd.SetSelectCode("S");
//					}else{
//						kr_cstms_cust_tp_cd.SetSelectCode("C");
//					}							
				}
//				if(polCd != null && polCd.substring(0,2) == "KR"){
					if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
						comboEnable(false);	
					} else {
						comboEnable(true);
					}
//				}else{	
//					comboEnable(false);
//				}
				// saving Original Bl No 
				if(orgBlNo != undefined && orgBlNo != ""){
					formObj.org_bl_no.value=orgBlNo;
					document.getElementById("org_bl").style.display="block";
				}else{
					document.getElementById("org_bl").style.display="none";
				}				
				// setting CA Manifest Flag 
				if(!ComIsNull(polCd)){
					if(polCd.substring(0,2) != "CA"){
						if(podCd.substring(0,2) == "CA" || delCd.substring(0,2) == "CA" || frobFlag == "Y"){
							formObj.ca_manifest_flag.value="Y";
						}else{
							formObj.ca_manifest_flag.value="N";
						}
					}
				}
				if(ComGetEtcData(arrXml[0], "bkg_sts_cd") == "X"
					|| ComGetEtcData(sXml, "DataYn") == "N" 
					|| ComGetObjValue(formObj.isInquiry) == "Y"){
					ComBtnDisable("btn_t7Save");
				}else{
					ComBtnEnable("btn_t7Save");					
				}	
				// activating Print Flag and fax/email in case of being BDR
				if(ComGetEtcData(sXml, "bdr_flg") == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
					setCustomerEditable(false);
				}else{
					setCustomerEditable(true);
					if(ComGetObjValue(formObj.ca_manifest_flag) == "Y"){
						if(ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
							formObj.sh_cstms_decl_cnt_cd.value=polCd.substring(0, 2);
						}
						if(ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
							formObj.cn_cstms_decl_cnt_cd.value=delCd.substring(0, 2);
						}
						if(ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
							formObj.nf_cstms_decl_cnt_cd.value=delCd.substring(0, 2);
						}
					}
				}
				// showing unchecked
				formObj.sam_cnee_ntfy_flg.value='N';
				formObj.modify_flag.value="N";
				formObj.same_as_flag.value="N";
	            setTimeout(function(){
	    			ComSetFocus(formObj.sh_cust_seq);
	    			ComSetFocus(formObj.bkg_no);
	            	},10);				
				// controlling C/A button
				if(parent.t1frame != undefined && typeof(parent.t1frame) == "object") {
					parent.initCAControl(ComGetObjValue(formObj.bkg_no), ComGetObjValue(formObj.ca_flg), ComGetObjValue(formObj.bdr_flg), ComGetObjValue(formObj.ca_exist_flg), ComGetObjValue(formObj.bl_no));
				}
				break;
			case COMMAND03:      //retrieving booking split no 
				formObj.f_cmd.value=COMMAND03;				
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value);
			 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,-15);         	
			 	break;			
			case IBSAVE:        //Save
				if(validateForm(formObj,sAction)){
	        		// Black List Check
					formObj.f_cmd.value=COMMAND04;	
 					var sXml=sheetObj.GetSaveData("ESM_BKG_0079_05GS.do", FormQueryString(formObj));
					var black_cust_flag=ComGetEtcData(sXml, "black_cust_flag");
					var black_cust_list=ComGetEtcData(sXml, "black_cust_list");
					if(black_cust_flag == "Y"){
						if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
							return false;
						}
					}
					if(ComShowCodeConfirm("BKG00254")){
						formObj.f_cmd.value = MULTI;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						setCustomerEditable(true);
						
						// 특수문자 제거로직
						var v_sh_cust_nm 	= chekcSpecialValue(ComGetObjValue(formObj.sh_cust_nm));
						var v_sh_cust_addr	= chekcSpecialValue(ComGetObjValue(formObj.sh_cust_addr));
						var v_ff_cust_nm	= chekcSpecialValue(ComGetObjValue(formObj.ff_cust_nm));
						var v_cn_cust_nm	= chekcSpecialValue(ComGetObjValue(formObj.cn_cust_nm));
						var v_cn_cust_addr	= chekcSpecialValue(ComGetObjValue(formObj.cn_cust_addr));
						var v_an_cust_nm	= chekcSpecialValue(ComGetObjValue(formObj.an_cust_nm));
						var v_nf_cust_nm	= chekcSpecialValue(ComGetObjValue(formObj.nf_cust_nm));
						var v_nf_cust_addr	= chekcSpecialValue(ComGetObjValue(formObj.nf_cust_addr));
						var v_ex_cust_nm	= chekcSpecialValue(ComGetObjValue(formObj.ex_cust_nm));
						
						ComSetObjValue(formObj.sh_cust_nm, v_sh_cust_nm);
						ComSetObjValue(formObj.sh_cust_addr, v_sh_cust_addr);
						ComSetObjValue(formObj.ff_cust_nm, v_ff_cust_nm);
						ComSetObjValue(formObj.cn_cust_nm, v_cn_cust_nm);
						ComSetObjValue(formObj.cn_cust_addr, v_cn_cust_addr);
						ComSetObjValue(formObj.an_cust_nm, v_an_cust_nm);
						ComSetObjValue(formObj.nf_cust_nm, v_nf_cust_nm);
						ComSetObjValue(formObj.nf_cust_addr, v_nf_cust_addr);
						ComSetObjValue(formObj.ex_cust_nm, v_ex_cust_nm);
						
						
 						var sXml=sheetObj.GetSaveData("ESM_BKG_0079_05GS.do", getOvrChkFlg() + "&" +FormQueryString(formObj));
						if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
							setCustomerEditable(false);
						}else{
							setCustomerEditable(true);
						}						
						ComOpenWait(false); 		
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
							ComBkgSaveCompleted();
							ComSetObjValue(formObj.modify_flag, "N");	
							var agmtActCntCd=formObj.agmt_act_cnt_cd.value;
							var agmtActCustSeq=formObj.agmt_act_cust_seq.value!=""?ComLpad(formObj.agmt_act_cust_seq.value,6,0):""
							formObj.old_act_cust_cd.value=agmtActCntCd +agmtActCustSeq;
						}		
					}
				}				
				break;
			case IBINSERT:      // insert
				break;
			case SEARCH01:      // SEARCH01
				if(ComIsNull(formObj.bkg_no.value) && ComIsNull(formObj.bl_no.value)){
					return false; 					
				}
				initSheet(sheetObjects[1],2);
				formObj.f_cmd.value=SEARCH01;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH01+"&bkg_no="+formObj.bkg_no.value);
				ComOpenWait(false); 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0){
					initDisplayOnOff();
    				sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
    				if(ComGetTotalRows(arrXml[0]) > 0){
    					if(ComGetObjValue(formObj.isInquiry) !="Y"){
    		        		changeBtnEnable(gatherOvrCustInfo("Y", ovrChkFlgAll), "On");
    		        		changeBtnEnable(gatherOvrCustInfo("N", ovrChkFlgAll), "Off");
    			        	changeBtnEnable(gatherOvrCustInfo("Y", ovrChkFlgLblAll), "On");
    			        	changeBtnEnable(gatherOvrCustInfo("N", ovrChkFlgLblAll), "Off");
    			        	setOvrChkFlg("On");
    			        	changeBtnEnable(gatherOvrCustInfo("Y", ovrDtlBtnAll), "On");
    			        	changeBtnEnable(gatherOvrCustInfo("N", ovrDtlBtnAll), "Off");
    			        	changeDisplayColor(gatherOvrCustInfo("Y", ovrChkFlgLblAll), "black");
    			        	changeDisplayColor(gatherOvrCustInfo("N", ovrChkFlgLblAll), "gray");
    			        	changeDisplayColor(gatherOvrCustInfo("Y", ovrDtlBtnLblAll), "red");
    			        	changeDisplayColor(gatherOvrCustInfo("N", ovrDtlBtnLblAll), "black");
    		        	}else if(ComGetObjValue(formObj.isInquiry) =="Y"){
    						changeBtnEnable(ovrChkFlgAll, "Off");
    			        	changeBtnEnable(ovrChkFlgLblAll, "Off");
    			        	setOvrChkFlg("On");
    			        	changeBtnEnable(ovrDtlBtnAll, "On");
    			        	changeDisplayColor(ovrChkFlgLblAll, "gray");
    			        	changeDisplayColor(ovrDtlBtnLblAll, "black");
    					}
    				}
				} else {
		        	changeBtnEnable(ovrChkFlgAll, "Off");
		        	changeBtnEnable(ovrChkFlgLblAll, "Off");
		        	setOvrChkFlg("Off");
		        	changeBtnEnable(ovrDtlBtnAll, "Off");
		        	changeDisplayColor(ovrChkFlgLblAll, "gray");
		        	changeDisplayColor(ovrDtlBtnLblAll, "black");
				}
								
				break;
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(formObj,sAction){
        switch(sAction) {
 			case IBSAVE:      // Save   
				// occurring error after changing BkgNo
				if(formObj.bkg_no.value != formObj.old_bkg_no.value){
					ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,formObj.bkg_no.value);
 					return false; 					
				}
				// occurring error after changing BlNo
				if(formObj.bl_no.value != formObj.old_bl_no.value){
					ComShowCodeMessage("BKG00439",formObj.old_bl_no.value,formObj.bl_no.value);					
 					return false; 					
				} 		
 				if(ComIsNull(formObj.bkg_no)){ 					
					ComShowCodeMessage("BKG00255");
					ComSetFocus(formObj.bkg_no);
					return false; 					
 				}
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 
    				ComShowCodeMessage("BKG00005");
    				return false;
    			} 				
 				if(formObj.sh_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Shipper", formObj.sh_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.sh_cstms_decl_cnt_cd); 
					return false;
 				}		
 				if(formObj.cn_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Consignee", formObj.cn_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.cn_cstms_decl_cnt_cd); 
					return false;
 				}		
 				if(formObj.nf_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Notify", formObj.nf_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.nf_cstms_decl_cnt_cd); 
					return false;
 				}
 				// for usa, canada
 				// mandatory condition(item) - ZipCode when the country code is 'US' or 'CA'
 				if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
	 				if(ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "CA"){
	 					if(ComIsNull(formObj.sh_cust_zip_id)){ 						 		
	 						ComShowCodeMessage("BKG00344");
	 						ComSetFocus(formObj.sh_cust_zip_id); 						
	 						return false; 	 	 						
	 					}
	 				}
	 				if(ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "CA"){
	 					if(ComIsNull(formObj.cn_cust_zip_id)){ 						 		
	 						ComShowCodeMessage("BKG00344");
	 						ComSetFocus(formObj.cn_cust_zip_id); 						
	 						return false; 	 	 						
	 					}
	 				}
	 				if(ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "CA"){
	 					if(!ComIsNull(formObj.nf_cust_seq)||!ComIsNull(formObj.nf_cust_addr)||!ComIsNull(formObj.nf_cust_nm)){
		 					if(ComIsNull(formObj.nf_cust_zip_id)){ 						 		
		 						ComShowCodeMessage("BKG00344");
		 						ComSetFocus(formObj.nf_cust_zip_id); 						
		 						return false; 	 	 						
		 					}
	 					}
	 				} 			
 				}
 				// Calling the popup of Notify if there is no data in this condition, B/L Type = 'Order' And Notify Code,Seq
 				if(formObj.cust_to_ord_flg.value == "Y"){
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
 						ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.nf_cust_cnt_cd.value+"&cust_seq="+formObj.nf_cust_seq.value+"&cust_nm="+custNm, 970, 640, "callBackNf0192","0,0,1,1,1", true);
 						return false;
 					}
 				}
 				// Calling the popup of Consignee if there is no data in this condition, B/L Type = 'Straight' And Consignee Code,Seq
 				if(formObj.cust_to_ord_flg.value == "N"){
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
 						ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.cn_cust_cnt_cd.value+"&cust_seq="+formObj.cn_cust_seq.value+"&cust_nm="+custNm, 970, 640, "callBackCn0192","0,0,1,1,1", true);
 						return false;
 					}
 				} 			
 				// caManifestFlag = 'Y' -> city,state/country, zip -> (B/L Type  'Y' -> Notify, B/L Type 'N' -> Consignee)
 				// pol -> 'US' Exclusion
 				if(formObj.ca_manifest_flag.value == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
 					//shipper validation check
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
 						if(!ComIsNull(formObj.nf_cust_seq)||!ComIsNull(formObj.nf_cust_addr)||!ComIsNull(formObj.nf_cust_nm)){
							if(ComIsNull(formObj.nf_cust_cty_nm.value) || ComIsNull(formObj.nf_cust_ste_cd.value) || ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
								ComShowCodeMessage("BKG00346");
								return false;
							}
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
				//EORI no 
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
				//EORI no End
 				// for roterdam
				if(formObj.nl_flag.value == "Y"){
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
	 				if(formObj.cust_to_ord_flg.value == "N"){
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
 				// Shipper Code Check
 				if(ComChkLen(formObj.sh_cust_cnt_cd.value, 2) != "2"){
 					ComShowCodeMessage("BKG00300");
 					ComSetFocus(formObj.sh_cust_cnt_cd);
	 				return false; 					
 				}
 				// Shipper Seq Check
 				if(ComIsNull(formObj.sh_cust_seq.value)){
 					ComShowCodeMessage("BKG00008");
 					ComSetFocus(formObj.sh_cust_seq);
	 				return false; 					
 				} 				
 				// Shipper Name Check
 				if(ComIsNull(formObj.sh_cust_nm.value)){
 					ComShowCodeMessage("BKG00351");
 					ComSetFocus(formObj.sh_cust_nm);
	 				return false; 					
 				} 		 				
 				// Shipper Address Check
 				if(ComIsNull(formObj.sh_cust_addr.value)){
 					ComShowCodeMessage("BKG00352");
 					ComSetFocus(formObj.sh_cust_addr);
	 				return false; 					
 				}
 				// Consignee Code Check
 				if(ComChkLen(formObj.cn_cust_cnt_cd.value, 2) != "2"){
 					ComShowCodeMessage("BKG00291");
 					ComSetFocus(formObj.cn_cust_cnt_cd);
	 				return false; 					
 				}
 				// B/L Type = 'O'
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
 				// B/L Type = 'S'
 				if(formObj.cust_to_ord_flg.value == "N"){
 					if(BkgIsContainsChars(formObj.cn_cust_nm,"order")){
						if(ComShowCodeConfirm("BKG00347")){
							formObj.cust_to_ord_flg.value="Y";
						}  						
 					}				
 				}		
 				// Same As CNEE Auto Flagging
 				// cnee, ntfy added  the same name
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
 				//  Text Size Validation
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
 				if(!validateCols(5, 35, formObj.ex_cust_nm, "Export Ref.")){
 					return false;
 				} 	 			
 			break;              		
         } 		
        return true;
    }
    function setCustomerEditable(isEnable){
    	var formObj=document.form;
    	//BkgEnableObject(formObj.agmt_act_cnt_cd, isEnable);
    	//BkgEnableObject(formObj.agmt_act_cust_seq, isEnable);  
    	BkgEnableObject(formObj.agmt_act_cnt_cd, false);
    	BkgEnableObject(formObj.agmt_act_cust_seq, false);  
    	if(formObj.agmt_act_cnt_cd.value ==""){
    		document.getElementById("del_btn").style.display="none";
		}else{	
			document.getElementById("del_btn").style.display="block";
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("btn_t7Delete").className="btn2";
			}else{
				document.getElementById("btn_t7Delete").className="btn2_3";
			}
		}		
//    	BkgEnableObject(formObj.sh_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.sh_cust_seq, isEnable);
    	if(isEnable){
        	formObj.sh_cust_nm.readOnly=false;
        	formObj.sh_cust_addr.readOnly=false;    		
    	}else{
        	formObj.sh_cust_nm.readOnly=true;
        	formObj.sh_cust_addr.readOnly=true;    		
    	}    	
    	BkgEnableObject(formObj.sh_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.sh_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.sh_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.sh_cust_zip_id, isEnable);
    	BkgEnableObject(formObj.sh_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.sh_eori_no, isEnable);
//    	BkgEnableObject(formObj.cn_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.cn_cust_seq, isEnable);
    	if(isEnable){
        	formObj.cn_cust_nm.readOnly=false;
        	formObj.cn_cust_addr.readOnly=false;    	
    	}else{
        	formObj.cn_cust_nm.readOnly=true;
        	formObj.cn_cust_addr.readOnly=true;    			
    	}    	
    	BkgEnableObject(formObj.cn_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.cn_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.cn_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.cn_cust_zip_id, isEnable);
//    	BkgEnableObject(formObj.cn_cust_fax_no, isEnable);  
//    	BkgEnableObject(formObj.cn_cust_eml, isEnable); 	 
    	BkgEnableObject(formObj.cn_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.cn_eori_no, isEnable);
    	BkgEnableObject(formObj.cust_to_ord_flg, isEnable);
//    	BkgEnableObject(formObj.nf_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.nf_cust_seq, isEnable);
    	if(isEnable){
        	formObj.nf_cust_nm.readOnly=false;
        	formObj.nf_cust_addr.readOnly=false;   	
    	}else{
        	formObj.nf_cust_nm.readOnly=true;
        	formObj.nf_cust_addr.readOnly=true;    			
    	}    	    	
    	BkgEnableObject(formObj.nf_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.nf_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.nf_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.nf_cust_zip_id, isEnable);
//    	BkgEnableObject(formObj.nf_cust_fax_no, isEnable);   
//    	BkgEnableObject(formObj.nf_cust_eml, isEnable); 	 
    	BkgEnableObject(formObj.nf_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.nf_eori_no, isEnable);
    	BkgEnableObject(formObj.sam_cnee_copy_flg, isEnable);
//    	BkgEnableObject(formObj.ff_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.ff_cust_seq, isEnable);
    	if(isEnable){
    		formObj.ff_cust_nm.readOnly=false;	
    	}else{
    		formObj.ff_cust_nm.readOnly=true;  			
    	}        	
    	BkgEnableObject(formObj.fmc_cd, isEnable);
//    	BkgEnableObject(formObj.an_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.an_cust_seq, isEnable);
    	if(isEnable){
    		formObj.an_cust_nm.readOnly=false;	
    	}else{
    		formObj.an_cust_nm.readOnly=true;	
    	}           	
//    	BkgEnableObject(formObj.an_cust_fax_no, isEnable);     
//    	BkgEnableObject(formObj.an_cust_eml, isEnable);    	 	
    	if(isEnable){
    		formObj.ex_cust_nm.readOnly=false;	
    	}else{
    		formObj.ex_cust_nm.readOnly=true; 			
    	}    	
    	BkgEnableObject(formObj.ff_ref_no, isEnable);
    	BkgEnableObject(formObj.ex_cust_cnt_cd, isEnable);
    	BkgEnableObject(formObj.ex_cust_seq, isEnable);
    	BkgEnableObject(formObj.org_cnt_nm, isEnable);
    	if(isEnable){
    		formObj.sh_cust_cnt_cd.style.background="#CCFFFD";
    		formObj.sh_cust_seq.style.background="#CCFFFD";    		
    		formObj.cn_cust_cnt_cd.style.background="#CCFFFD";
    		formObj.cn_cust_seq.style.background="#CCFFFD";
    		formObj.sh_cust_nm.style.background="#FFFFFF";
    		formObj.sh_cust_addr.style.background="#FFFFFF";    		
    		formObj.cn_cust_nm.style.background="#FFFFFF";
    		formObj.cn_cust_addr.style.background="#FFFFFF";    	
    		formObj.nf_cust_nm.style.background="#FFFFFF";
    		formObj.nf_cust_addr.style.background="#FFFFFF";    	
    		formObj.ff_cust_nm.style.background="#FFFFFF";
    		formObj.an_cust_nm.style.background="#FFFFFF";    	    		
    		formObj.ex_cust_nm.style.background="#FFFFFF"; 
    		if(comboObjects[0].GetEnable()){
    			comboEnable(isEnable);
    		}
    	}else{
    		formObj.sh_cust_nm.style.background="#E8E7EC";
    		formObj.sh_cust_addr.style.background="#E8E7EC";    		
    		formObj.cn_cust_nm.style.background="#E8E7EC";
    		formObj.cn_cust_addr.style.background="#E8E7EC";    	
    		formObj.nf_cust_nm.style.background="#E8E7EC";
    		formObj.nf_cust_addr.style.background="#E8E7EC";    	
    		formObj.ff_cust_nm.style.background="#E8E7EC";
    		formObj.an_cust_nm.style.background="#E8E7EC";    	    		
    		formObj.ex_cust_nm.style.background="#E8E7EC";
    		if(comboObjects[0].GetEnable()){
    			comboEnable(isEnable);
    		}
    	}    	
    	if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
    		return;
    	}
		document.getElementById("sh_eur_cstms_st_nm").className="input";
		document.getElementById("sh_eori_no").className="input";
		document.getElementById("sh_cust_ste_cd").className="input";
		document.getElementById("sh_cust_cty_nm").className="input";
		document.getElementById("sh_cstms_decl_cnt_cd").className="input";		
		document.getElementById("sh_cust_zip_id").className="input";
		document.getElementById("cn_eur_cstms_st_nm").className="input";
		document.getElementById("cn_eori_no").className="input";
		document.getElementById("cn_cust_ste_cd").className="input";
		document.getElementById("cn_cust_cty_nm").className="input";
		document.getElementById("cn_cstms_decl_cnt_cd").className="input";		
		document.getElementById("cn_cust_zip_id").className="input";
		document.getElementById("nf_eur_cstms_st_nm").className="input";
		document.getElementById("nf_eori_no").className="input";			
		document.getElementById("nf_cust_ste_cd").className="input";
		document.getElementById("nf_cust_cty_nm").className="input";
		document.getElementById("nf_cstms_decl_cnt_cd").className="input";		
		document.getElementById("nf_cust_zip_id").className="input";	
		// Canada -> City/State/Country -> blue handling
//		if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
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
		}else{
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("sh_cust_cty_nm").className="input2";
				document.getElementById("sh_cust_ste_cd").className="input2";
				document.getElementById("sh_cstms_decl_cnt_cd").className="input2";		
				document.getElementById("sh_cust_zip_id").className="input2";
				document.getElementById("cn_cust_cty_nm").className="input2";
				document.getElementById("cn_cust_ste_cd").className="input2";
				document.getElementById("cn_cstms_decl_cnt_cd").className="input2";	
				document.getElementById("cn_cust_zip_id").className="input2";
				document.getElementById("nf_cust_cty_nm").className="input2";
				document.getElementById("nf_cust_ste_cd").className="input2";						
				document.getElementById("nf_cstms_decl_cnt_cd").className="input2";	
				document.getElementById("cn_cust_zip_id").className="input2";
			}
		}				
				// NL Manifest Flag setting
		if(formObj.nl_flag.value == "Y"){
			document.getElementById("sh_eur_cstms_st_nm").className="input1";
			document.getElementById("sh_eori_no").className="input1";
			document.getElementById("sh_cust_cty_nm").className="input1";
			document.getElementById("sh_cstms_decl_cnt_cd").className="input1";		
			document.getElementById("sh_cust_zip_id").className="input1";
			document.getElementById("cn_eur_cstms_st_nm").className="input1";
			document.getElementById("cn_eori_no").className="input1";
			document.getElementById("cn_cust_cty_nm").className="input1";
			document.getElementById("cn_cstms_decl_cnt_cd").className="input1";		
			document.getElementById("cn_cust_zip_id").className="input1";
			document.getElementById("nf_eur_cstms_st_nm").className="input1";
			document.getElementById("nf_eori_no").className="input1";
			document.getElementById("nf_cust_cty_nm").className="input1";
			document.getElementById("nf_cstms_decl_cnt_cd").className="input1";		
			document.getElementById("nf_cust_zip_id").className="input1";
		} else {
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("sh_eur_cstms_st_nm").className="input2";
				document.getElementById("sh_eori_no").className="input2";
				document.getElementById("sh_cust_cty_nm").className="input2";
				document.getElementById("sh_cstms_decl_cnt_cd").className="input2";		
				document.getElementById("sh_cust_zip_id").className="input2";
				document.getElementById("cn_eur_cstms_st_nm").className="input2";
				document.getElementById("cn_eori_no").className="input2";
				document.getElementById("cn_cust_cty_nm").className="input2";
				document.getElementById("cn_cstms_decl_cnt_cd").className="input2";		
				document.getElementById("cn_cust_zip_id").className="input2";
				document.getElementById("nf_eur_cstms_st_nm").className="input2";
				document.getElementById("nf_eori_no").className="input2";
				document.getElementById("nf_cust_cty_nm").className="input2";
				document.getElementById("nf_cstms_decl_cnt_cd").className="input2";		
				document.getElementById("nf_cust_zip_id").className="input2";		
			}						
		}
    }
    /**
     * Search condition :CustCntCd, CustSeq.result Retrieve :CustNm
     */
    function searchMdmCustNm(sheetObject,formObj,custTp,custCntCd,custSeq){
    	ComSetObjValue(formObj.f_cmd,SEARCHLIST11);
 		var sXml=sheetObject.GetSearchData("ESM_BKG_0079_05GS.do", "f_cmd="+SEARCHLIST11+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq);
		var custNm=ComGetEtcData(sXml,"cust_nm");
		var custAddr=ComGetEtcData(sXml,"cust_addr");
		var custTpCd=ComGetEtcData(sXml,"rvis_cntr_cust_tp_cd")
		var fmcNo=ComGetEtcData(sXml,"frt_fwrd_fmc_no");
		if ("SH"==custTp) {
			ComSetObjValue(formObj.sh_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.sh_mdm_address, custAddr ? custAddr : "");
			/* Simple & Console 버그 수정 TK */
			if(kr_cstms_cust_tp_cd.GetSelectCode() == '' || kr_cstms_cust_tp_cd.GetSelectCode() == null || kr_cstms_cust_tp_cd.GetSelectCode() == undefined){
				kr_cstms_cust_tp_cd.SetSelectCode("B"==custTpCd ? "S" : "C");
			}
		} else if ("CN"==custTp) {
			ComSetObjValue(formObj.cn_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.cn_mdm_address, custAddr ? custAddr : "");
		} else if ("NF"==custTp) {
			ComSetObjValue(formObj.nf_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.nf_mdm_address, custAddr ? custAddr : "");
		} else if ("FF"==custTp) {
			ComSetObjValue(formObj.ff_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.ff_cust_nm, custAddr ? custAddr : "");
			ComSetObjValue(formObj.fmc_cd, fmcNo ? fmcNo : "");
		} else if ("AN"==custTp) {
			ComSetObjValue(formObj.an_cust_lgl_eng_nm, custNm ? custNm : "");
			ComSetObjValue(formObj.an_cust_nm, custAddr ? custAddr : "");
		}
    }
    /**
     * function that checks a particular string 
     *
     * @param 	obj, chars  <br>
     * @returns 	boolean <br>
     * @author	
     */     
	function BkgIsContainsChars(obj,chars) {
		try {
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
     * a particular string data extraction
     *
     * @param 	obj, startIdx, endIdx  <br>
     * @returns 	boolean <br>
     * @author	
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
//	// handling process after ending  retrieve
//	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
//		with(sheetObj){
//		}
//	}
	// Event  after saved 
	function t7sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg != ""){
			ComBkgSaveCompleted();
		}
	}
	
	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
    	doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
	}
    //Run in 0079
    function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);				
//			}
		}	
    }
    //Run in 0079
    function searchData(bkgNo){
    	if(ComIsNull(bkgNo)) return;
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no,bkgNo);
		ComSetObjValue(formObj.modify_flag,"N");
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);        
    }
//	function bkg007905_keypress(){
//    	var srcName=ComGetEvent("name");
//    	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	    switch(event.srcElement.dataformat){
//	    	case "engup":
//	        //English uppercase characters
//    			ComKeyOnlyAlphabet('upper');
//	        break;
//	      case "engupnum":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('uppernum');
//	        break;
//          case "engupspace": //English uppercase characters + Space
//          if(event.keyCode != 32) {
//            ComKeyOnlyAlphabet('uppernum');
//          }	        
//	      case "custname":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('uppernum','32');
//	        break;
//	      case "engdnnum":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('lowernum');
//	        break;
//	      case "int":
//	        //Numeric input
//	        ComKeyOnlyNumber(event.srcElement);
//	        break;	            
//	      case "address":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
//	        break;
//	      case "num":
//	      case "zipcode":
//	        //Numeric input
//	        ComKeyOnlyAlphabet('uppernum','45|32');
//	        break;
//	      case "etc": //English uppercase
//	        if(keyValue >= 97 && keyValue <= 122) {//Lowercase letters
//                event.keyCode=keyValue + 65 - 97;
//            }
//        	break;
//	      case "phone":
//	    	  ComKeyOnlyNumber(event.srcElement, '-');
//	      default:
//	    }
//    	if(srcName == "bkg_no" || srcName == "bl_no"){
//    		if(event.keyCode == 13){
//    			var formObj=document.form;
//    	    	var srcName=ComGetEvent("name");
//    	    	var srcValue=window.event.srcElement.getAttribute("value");
//    			formObj.elements[srcName].value=srcValue.toUpperCase();
//    			ComKeyEnter();
//    		}
//    	} 
//	}         
	function bkg007905_click(){
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	if(srcName == "sam_cnee_copy_flg"){
    		if(formObject.sam_cnee_copy_flg.checked){
    			if(!ComIsNull(formObject.nf_cust_nm.value) || !ComIsNull(formObject.nf_cust_addr.value)){
					if(ComShowCodeConfirm("BKG00343")){
						ComSetObjValue(formObject.nf_cust_nm,ComGetObjValue(formObject.cn_cust_nm));
						ComSetObjValue(formObject.nf_cust_addr,ComGetObjValue(formObject.cn_cust_addr));
						ComSetObjValue(formObject.nf_cust_cty_nm,ComGetObjValue(formObject.cn_cust_cty_nm));
						ComSetObjValue(formObject.nf_cust_ste_cd,ComGetObjValue(formObject.cn_cust_ste_cd));
						ComSetObjValue(formObject.nf_cstms_decl_cnt_cd,ComGetObjValue(formObject.cn_cstms_decl_cnt_cd));
						ComSetObjValue(formObject.nf_cust_zip_id,ComGetObjValue(formObject.cn_cust_zip_id));
						ComSetObjValue(formObject.nf_cust_fax_no,ComGetObjValue(formObject.cn_cust_fax_no));
						ComSetObjValue(formObject.nf_cust_eml,ComGetObjValue(formObject.cn_cust_eml));
						ComSetObjValue(formObject.nf_eur_cstms_st_nm,ComGetObjValue(formObject.cn_eur_cstms_st_nm));
						/* Blue Print #9252 로 CNEE Code copy 기능 추가 */
						ComSetObjValue(formObject.nf_cust_cnt_cd, ComGetObjValue(formObject.cn_cust_cnt_cd));
						ComSetObjValue(formObject.nf_cust_seq, ComGetObjValue(formObject.cn_cust_seq));
						ComSetObjValue(formObject.nf_cust_lgl_eng_nm, ComGetObjValue(formObject.cn_cust_lgl_eng_nm));
					}  			    				
    			}else{
					ComSetObjValue(formObject.nf_cust_nm,ComGetObjValue(formObject.cn_cust_nm));
					ComSetObjValue(formObject.nf_cust_addr,ComGetObjValue(formObject.cn_cust_addr));
					ComSetObjValue(formObject.nf_cust_cty_nm,ComGetObjValue(formObject.cn_cust_cty_nm));
					ComSetObjValue(formObject.nf_cust_ste_cd,ComGetObjValue(formObject.cn_cust_ste_cd));
					ComSetObjValue(formObject.nf_cstms_decl_cnt_cd,ComGetObjValue(formObject.cn_cstms_decl_cnt_cd));
					ComSetObjValue(formObject.nf_cust_zip_id,ComGetObjValue(formObject.cn_cust_zip_id));
					ComSetObjValue(formObject.nf_cust_fax_no,ComGetObjValue(formObject.cn_cust_fax_no));
					ComSetObjValue(formObject.nf_cust_eml,ComGetObjValue(formObject.cn_cust_eml));
					ComSetObjValue(formObject.nf_eur_cstms_st_nm,ComGetObjValue(formObject.cn_eur_cstms_st_nm));
					/* Blue Print #9252 로 CNEE Code copy 기능 추가 */
					ComSetObjValue(formObject.nf_cust_cnt_cd, ComGetObjValue(formObject.cn_cust_cnt_cd));
					ComSetObjValue(formObject.nf_cust_seq, ComGetObjValue(formObject.cn_cust_seq));
					ComSetObjValue(formObject.nf_cust_lgl_eng_nm, ComGetObjValue(formObject.cn_cust_lgl_eng_nm));
    			}
    		}
    		formObject.modify_flag.value="Y"; 
    	}else if(srcName == "sh_addr_prn_flg"||srcName == "cn_addr_prn_flg"||srcName == "nf_addr_prn_flg"
    		||srcName == "ff_addr_prn_flg"||srcName == "an_addr_prn_flg"||srcName == "ex_addr_prn_flg"){
    		formObject.modify_flag.value="Y"; 
//    	}else if(srcName == "cn_addr_prn_flg"){
//    		formObject.modify_flag.value = "Y"; 
//    	}else if(srcName == "nf_addr_prn_flg"){
//    		formObject.modify_flag.value = "Y"; 
//    	}else if(srcName == "ff_addr_prn_flg"){
//    		formObject.modify_flag.value = "Y"; 
//    	}else if(srcName == "an_addr_prn_flg"){
//    		formObject.modify_flag.value = "Y"; 
//    	}else if(srcName == "ex_addr_prn_flg"){
//    		formObject.modify_flag.value = "Y";     		
    	}
	}
	function bkg007905_change(){
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	if(srcName == "sh_cust_cnt_cd"||srcName == "sh_cust_seq"||srcName == "sh_cust_nm"||srcName == "sh_cust_addr"
    		||srcName == "sh_cust_cty_nm"||srcName == "sh_cust_ste_cd"||srcName == "sh_cstms_decl_cnt_cd"||srcName == "sh_cust_zip_id"){    		
   			formObject.modify_flag.value="Y"; 
//    	} else if(srcName == "sh_cust_addr"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "sh_cust_cty_nm"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "sh_cust_ste_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "sh_cstms_decl_cnt_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "sh_cust_zip_id"){    		
//   			formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "cn_cust_cnt_cd"||srcName == "cn_cust_seq"||srcName == "cn_cust_nm"||srcName == "cn_cust_addr"
    		||srcName == "cn_cust_cty_nm"||srcName == "cn_cust_ste_cd"||srcName == "cn_cstms_decl_cnt_cd"||srcName == "cn_cust_zip_id"
    		||srcName == "cn_cust_fax_no"||srcName == "cn_cust_eml"){    		
   			formObject.modify_flag.value="Y";      		
//    	} else if(srcName == "cn_cust_nm"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_addr"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_cty_nm"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_ste_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cstms_decl_cnt_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_zip_id"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_fax_no"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "cn_cust_eml"){    		
//    		formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "nf_cust_cnt_cd"||srcName == "nf_cust_seq"||srcName == "nf_cust_nm"||srcName == "nf_cust_addr"
    		||srcName == "nf_cust_cty_nm"||srcName == "nf_cust_ste_cd"||srcName == "nf_cstms_decl_cnt_cd"||srcName == "nf_cust_zip_id"
    		||srcName == "nf_cust_fax_no"||srcName == "nf_cust_eml"){    		
   			formObject.modify_flag.value="Y";      
//    	} else if(srcName == "nf_cust_nm"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_addr"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_cty_nm"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_ste_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cstms_decl_cnt_cd"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_zip_id"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_fax_no"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "nf_cust_eml"){    	
//   			formObject.modify_flag.value = "Y";    
    	} else if(srcName == "ff_cust_cnt_cd"||srcName == "ff_cust_seq"||srcName == "ff_cust_nm"){    		
   			formObject.modify_flag.value="Y";     		 	
//		}else if(srcName == "ff_cust_nm"){    		
//			formObject.modify_flag.value = "Y";  
		}else if(srcName == "an_cust_cnt_cd"||srcName == "an_cust_seq"||srcName == "an_cust_nm"
			||srcName == "an_cust_fax_no"||srcName == "an_cust_eml"){    		
			formObject.modify_flag.value="Y";   	    		
//    	} else if(srcName == "an_cust_nm"){    		
//   			formObject.modify_flag.value = "Y";    
//    	} else if(srcName == "an_cust_fax_no"){    		
//   			formObject.modify_flag.value = "Y"; 
//    	} else if(srcName == "an_cust_eml"){    	
//   			formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "ex_cust_cnt_cd"||srcName == "ex_cust_seq"){    	
   			formObject.modify_flag.value="Y";      
//    	} else if(srcName == "ex_cust_seq"){    		
//   			formObject.modify_flag.value = "Y";   
    	}
    	if(srcName == "agmt_act_cnt_cd"){
   			formObject.modify_flag.value="Y"; 
    	} else if(srcName == "cust_to_ord_flg"){
    		formObject.modify_flag.value="Y";  
    	} else if(srcName == "ff_ref_no"){    		
   			formObject.modify_flag.value="Y"; 
    	} else if(srcName == "org_cnt_nm"){    	
   			formObject.modify_flag.value="Y";   
    	}else if(srcName == "fmc_cd"){    		
			formObject.modify_flag.value="Y";     
		}
	}
	 /**
	 * Mouse out Event
	 */
    function bkg007905_blur() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=ComGetEvent("maxlength");
    	var srcValue=ComGetEvent("value");
    	
    	if(srcName == "sh_cust_cnt_cd"){
//    		if(ComChkLen(srcValue, srcMaxLength) == "2" && srcValue == "KR"){
    			if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
    				comboEnable(false);	
				} else {
					comboEnable(true);
				}
//    		}else{
//    			comboEnable(false);
//    		}    	
    	}else if(srcName == "sh_cust_seq"){    		
    		if(ComIsNull(srcValue)){
    			formObject.sh_cust_lgl_eng_nm.value="";
    		}else{
    			formObject.sh_cust_seq.value=ComLpad(srcValue,6,"0");    		
    			if(ComChkLen(formObject.sh_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"SH",formObject.sh_cust_cnt_cd.value,formObject.sh_cust_seq.value);        							
    			}    			
    		} 
    	}else if(srcName == "cn_cust_seq"){    		
    		if(ComIsNull(srcValue)){
    			formObject.cn_cust_lgl_eng_nm.value="";
    		}else{
    			formObject.cn_cust_seq.value=ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.cn_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"CN",formObject.cn_cust_cnt_cd.value,formObject.cn_cust_seq.value);        					
    			}		
    		}   		
    	}else if(srcName == "nf_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.nf_cust_lgl_eng_nm.value="";
    		}else{
    			formObject.nf_cust_seq.value=ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.nf_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"NF",formObject.nf_cust_cnt_cd.value,formObject.nf_cust_seq.value);
    			}
    		}   			
    	}else if(srcName == "ff_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.ff_cust_lgl_eng_nm.value="";
    		}else{
    			formObject.ff_cust_seq.value=ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.ff_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"FF",formObject.ff_cust_cnt_cd.value,formObject.ff_cust_seq.value);
    			}
    		}       			
    	}else if(srcName == "an_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.an_cust_lgl_eng_nm.value="";
    		}else{
    			formObject.an_cust_seq.value=ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.an_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"AN",formObject.an_cust_cnt_cd.value,formObject.an_cust_seq.value);		
    			}
    		}       			
    	} else if (srcName == "bkg_no" || srcName == "bl_no") {
    		formObject.elements[srcName].value=srcValue.toUpperCase();
    	} else if (srcName == "cn_cust_eml" || srcName == "nf_cust_eml" || srcName == "an_cust_eml"){
    		if(!ComIsNull(srcValue) && !ComIsEmailAddr(srcValue)){
    			 ComShowCodeMessage("BKG95001", " enter correct 'Email Address'", "");
    			 formObject.elements[srcName].value="";
    		}
    	}
    }
	function getMakeBrData(dataNm, dataValue){
		var rtnValue="";
		var strValue="";
		var resArray=dataValue.split("\n");
		var resValue="";
		
		if(dataValue != null && dataValue.length > 0){
			if(dataNm == "NAME"){
				for(var i=0; i<resArray.length; i++){
					strValue = resArray[i];
					
					if(strValue.length > 35){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35);
					}else{
						rtnValue=strValue;
					}
					
					if(i==0){
						resValue=rtnValue;
					}else{
						resValue=resValue+"\n"+rtnValue;
					}
				}
			}else if(dataNm == "ADDR"){
				for(var i=0; i<resArray.length; i++){
					strValue = resArray[i];

					if(strValue.length > 70){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35,70) + "\n" + strValue.substring(70);
					}else if(strValue.length > 35){
						rtnValue=strValue.substring(0,35) + "\n" + strValue.substring(35);
					}else{
						rtnValue=strValue;
					}
					if(i==0){
						resValue=rtnValue;
					}else{
						resValue=resValue+"\n"+rtnValue;
					}
				}
			}			 
		}else{
			resValue="";
		}
		return resValue.toUpperCase();		 
	}
	// BlNo Information (Balloons Help)
	function blNoSet(){
		var obj=document.form.bl_no;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+5	;
		var sleft=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetLeft+7; 
//		orgBlNo.style.left=sleft;
//		orgBlNo.style.top=stop;	
		var obj1 = $("#bl_no").offset();
		$("#orgBlNo").css({
			   "position" : "absolute",
			   "top" : (obj1.top  + 28) +"px",
			   "left" : obj1.left + "px"
			});
		var strMsg=document.form.org_bl_no.value;
		if(strMsg != ""){
			text='<table  width=115  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strMsg + '</td></tr></table>';
			orgBlNo.innerHTML=text;
		}
	}
	function blNoHide(){
		orgBlNo.innerHTML='';
	}
    function kr_cstms_cust_tp_cd_OnChange(Code, Text){
    	//alert(comboObjects[0].Code);
	}
	 /**
	 * Manifest Type setting
	 */	 
	 function comboEnable(val){
		 comboObjects[0].SetEnable(val);
	 }
     function replaceAll(str, orgStr, repStr){
    	return str.split(orgStr).join(repStr); 
     }
     /**
      * 'Actual Customer' received value Saved <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBackSa0190(rArray);
      * </pre>
      * @param Popup -> received values ​​  
      * @return 
      * @author 
      * @version 2009.05.14
      */
      function callBackSa0190(rArray){    	
  		var formObj=document.form;
  		if(rArray != null){
  			ComSetObjValue(formObj.agmt_act_cnt_cd, rArray[0][0]);
  			ComSetObjValue(formObj.agmt_act_cust_seq, ComLpad(rArray[0][1],6,"0"));
  			if(formObj.agmt_act_cnt_cd.value ==""){
  	    		document.getElementById("del_btn").style.display="none";
  			}else{	
  				document.getElementById("del_btn").style.display="block";
  			}	
  			formObj.modify_flag.value="Y";
  		}
      }  
	/**
     *From 'B/L Customer' received value Save<br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackSh0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values ​​ 
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackSh0192(rArray, rArray2) {
  		var formObj=document.form;  		
		if (rArray2) {
			
  	  		if (!ComIsNull(formObj.sh_cust_nm) || !ComIsNull(formObj.sh_cust_addr)) {
  	  			if (!ComShowCodeConfirm("BKG00343")) return;
  	  		}
  	  		comboEnable("KR"==rArray2[0] && ("Y"!=ComGetObjValue(formObj.bdr_flg) || "N"!=ComGetObjValue(formObj.ca_flg)));
  	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray2[1]);
  	  		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray2[2],6,"0"));
  	  		ComSetObjValue(formObj.sh_cust_cty_nm      , rArray2[11]);  //City
  	  		ComSetObjValue(formObj.sh_cust_ste_cd      , rArray2[12]);  //State
  	  		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray2[13]);  //Country
  	  		ComSetObjValue(formObj.sh_cust_zip_id      , rArray2[14]);  //ZIP Code
  	  		ComSetObjValue(formObj.sh_eur_cstms_st_nm  , rArray2[16]);  //Street / P.O.Box
  	  		ComSetObjValue(formObj.sh_eori_no          , rArray2[17]);  //EORI#
			ComSetObjValue(formObj.sh_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray2[6]))); // cust_nm
			ComSetObjValue(formObj.sh_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n")); // Addr
  			searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray2[1],rArray2[2]);
  		} else {
  	  		comboEnable("KR"==rArray[0] && ("Y"!=ComGetObjValue(formObj.bdr_flg) || "N"!=ComGetObjValue(formObj.ca_flg)));
  	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray[0]);
  			ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray[1],6,"0"));
  			ComSetObjValue(formObj.sh_cust_cty_nm      , rArray[10]);  //City
  			ComSetObjValue(formObj.sh_cust_ste_cd      , rArray[11]);  //State
  			ComSetObjValue(formObj.sh_cust_zip_id      , rArray[12]);  //ZIP Code
			ComSetObjValue(formObj.sh_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray[7]))); // cust_nm
			ComSetObjValue(formObj.sh_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n")); // Addr
  			searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray[0],rArray[1]);
  		}
  		ComSetObjValue(formObj.modify_flag, "Y");
    }
	/**
     * From 'B/L Customer' received value Save <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackCn0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values ​​ 
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackCn0192(rArray, rArray2) {
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
			ComSetObjValue(formObj.cn_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray2[6]))); // cust_nm
			ComSetObjValue(formObj.cn_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n")); // Addr
  			searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray2[1],rArray2[2]);
  		} else {
  	  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray[0]);
  			ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray[1],6,"0"));
  			ComSetObjValue(formObj.cn_cust_cty_nm      , rArray[10]);  //City
  			ComSetObjValue(formObj.cn_cust_ste_cd      , rArray[11]);  //State
  			ComSetObjValue(formObj.cn_cust_zip_id      , rArray[12]);  //ZIP Code
			ComSetObjValue(formObj.cn_cust_nm    	   , getMakeBrData("NAME",rArray[7])); // cust_nm
			ComSetObjValue(formObj.cn_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n")); // Addr
  			searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray[0],rArray[1]);
  		}
  		ComSetObjValue(formObj.modify_flag, "Y");
	}
	/**
	 * From 'B/L Customer' received value Save <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     callBackNf0192(rArray, rArray2);
	 * </pre>
	 * @param Popup -> received values
	 * @return 
	 * @author 
	 * @version 2009.05.14
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
			ComSetObjValue(formObj.nf_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray2[6]))); // cust_nm
			ComSetObjValue(formObj.nf_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n")); // Addr
			searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray2[1],rArray2[2]);
		} else {
			ComSetObjValue(formObj.nf_cust_cnt_cd      , rArray[0]);
			ComSetObjValue(formObj.nf_cust_seq         , ComLpad(rArray[1],6,"0"));
			ComSetObjValue(formObj.nf_cust_cty_nm      , rArray[10]);  //City
			ComSetObjValue(formObj.nf_cust_ste_cd      , rArray[11]);  //State
			ComSetObjValue(formObj.nf_cust_zip_id      , rArray[12]);  //ZIP Code
			ComSetObjValue(formObj.nf_cust_nm    	   , getMakeBrData("NAME",chekcSpecialValue(rArray[7]))); // cust_nm
			ComSetObjValue(formObj.nf_cust_addr    	   , replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n")); // Addr
			searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray[0],rArray[1]);
		}
  		ComSetObjValue(formObj.modify_flag, "Y");
	}
    /**
     * From 'B/L Customer' received value Save <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackFf0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackFf0192(rArray, rArray2) {    	
		var formObj=document.form;
		if (rArray2) {
			if (!ComIsNull(formObj.ff_cust_nm)) {
				if (!ComShowCodeConfirm("BKG00343")) return;
			}
			ComSetObjValue(formObj.ff_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray2[2],6,"0"));
			ComSetObjValue(formObj.ff_cust_nm    , getMakeBrData("NAME",chekcSpecialValue(rArray2[6])) + "\n" 
									             + replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n"));
			searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray2[1],rArray2[2]);
		} else {
			ComSetObjValue(formObj.ff_cust_cnt_cd, rArray[0]);
			ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray[1],6,"0"));
			ComSetObjValue(formObj.ff_cust_nm    , getMakeBrData("NAME",chekcSpecialValue(rArray[7])) + "\n" 
		             + replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n"));
			searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray[0],rArray[1]);
		}
  		ComSetObjValue(formObj.modify_flag, "Y");
	}
	/**
     * From 'B/L Customer' received value Save <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackAn0192(rArray, rArray2);
     * </pre>
     * @param Popup -> received values
     * @return 
     * @author 
     * @version 2009.05.14
     */
    function callBackAn0192(rArray, rArray2) {    	
  		var formObj=document.form;
		if (rArray2) {
			if (!ComIsNull(formObj.an_cust_nm)) {
				if (!ComShowCodeConfirm("BKG00343")) return;
			}
			ComSetObjValue(formObj.an_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.an_cust_seq   , ComLpad(rArray2[2],6,"0"));
			ComSetObjValue(formObj.an_cust_nm    , getMakeBrData("NAME",chekcSpecialValue(rArray2[6])) + "\n" 
									             + replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray2[7])), "@*", "\n"));
			ComSetObjValue(formObj.an_cust_fax_no, rArray2[9]);
			ComSetObjValue(formObj.an_cust_eml   , rArray2[15]);
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray2[1],rArray2[2]);
		} else {
			formObj.an_cust_cnt_cd.value=rArray[0];
			formObj.an_cust_seq.value=ComLpad(rArray[1],6,"0");
			ComSetObjValue(formObj.an_cust_nm    , getMakeBrData("NAME",chekcSpecialValue(rArray[7])) + "\n" 
		             + replaceAll(getMakeBrData("ADDR",chekcSpecialValue(rArray[8])), "@*", "\n"));
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray[0],rArray[1]);
		}   		    		
  		ComSetObjValue(formObj.modify_flag, "Y");
	}
	/**
	 * From 'B/L Customer' received value Save <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     callBackEx0192(rArray, rArray2);
	 * </pre>
	 * @param Popup -> received values
	 * @return 
	 * @author 
	 * @version 2009.05.14
	 */
    function callBackEx0192(rArray, rArray2) {    	
   		var formObj=document.form;
		if (rArray2) {
			ComSetObjValue(formObj.ex_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.ex_cust_seq   , ComLpad(rArray2[2],6,"0"));
		} else {
			ComSetObjValue(formObj.ex_cust_cnt_cd, rArray[0]);
			ComSetObjValue(formObj.ex_cust_seq   , ComLpad(rArray[1],6,"0"));
		}   		    		
  		ComSetObjValue(formObj.modify_flag, "Y");
	}
	/**
	 * 'Zip Code' received value Save (Shipper)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     callBackShZipCode(rArray);
	 * </pre>
	 * @param Popup -> received values
	 * @return 
	 * @author 
	 * @version 2010.12.27
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
     * 'Zip Code' received value Save (Consignee)<br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackShZipCode(rArray);
     * </pre>
     * @param Popup -> received values
     * @return 
     * @author 
     * @version 2010.12.27
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
     * 'Zip Code' received value Save (Notify)<br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackShZipCode(rArray);
     * </pre>
     * @param Popup -> received values
     * @return 
     * @author 
     * @version 2010.12.27
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
    /**
     * Export Ref.	
     * @param rArray
     */
    function callBackExRef(rArray){
    	var formObject=document.form;
    	var exRef = "";
    	var exCustNm=formObject.ex_cust_nm.value;
    	if(rArray != null){
    		for(var i = 0 ; i < rArray[0].length; i++){
    			exRef += rArray[0][i][3] + "\n";
    		} 
    		for(var i = 0 ; i < rArray[1].length; i++){
    			exRef += rArray[1][i][4] + "\n";
    		} 
    	}
    	if(ComIsNull(exCustNm)){
        	formObject.ex_cust_nm.value=exRef;
    	}else{
        	formObject.ex_cust_nm.value=exCustNm + "\n" + exRef;
    	}
    }

    /*
     * KEY UP 이벤트 처리
     */
    function checkUpdate(obj){
    	var updateString = checkSpecial(obj);	//특수문자 제외 로직
    	if(obj.value != updateString){
    		document.form.modify_flag.value="Y";	//변경사항 체크
    	}
    }    
    
    /*
     * MOUSE PASTE 이벤트
     */
    function mousePaste(obj){
    	setTimeout(function(){
        	var updateString = checkSpecial(obj);	//특수문자 제외 로직
        	if(obj.value != updateString){
        		document.form.modify_flag.value="Y";	//변경사항 체크
        	}
    	}, 100)
    }
    
    function changeDisplayOnOff(trgObj, onFlg) {
    	if (onFlg == undefined || onFlg == null || onFlg != "On")
    		onFlg = "Off";

    	if (onFlg == "On") {
    		for (var i = 0; i < trgObj.length; i++) {
    			ComSetDisplay(trgObj[i], true);
    		}
    	} else {
    		for (var i = 0; i < trgObj.length; i++) {
    			ComSetDisplay(trgObj[i], false);
    		}
    	}

    }

    function changeBtnEnable(trgObj, onFlg) {
    	if (onFlg == undefined || onFlg == null || onFlg != "On")
    		onFlg = "Off";
    	if (onFlg == "On") {
    		for (var i = 0; i < trgObj.length; i++) {
    			document.getElementById(trgObj[i]).disabled = false;
    		}
    	} else {
    		for (var i = 0; i < trgObj.length; i++) {
    			
    			document.getElementById(trgObj[i]).disabled = true;
    		}
    	}

    }

    function changeDisplayColor(trgObj, color) {
    	if (color == undefined || color == null)
    		color = "gray";

    	for (var i = 0; i < trgObj.length; i++) {
    		document.getElementById(trgObj[i]).style.color = color;
    	}
    }

    function gatherOvrCustInfo(ovrChkFlg, tgtObj) {
    	var overObjList = new Array();
    	var overCustNum = 0;
    	
    	for (var i = 0; i < sheetOverFlgList.length; i++) {
    		if (sheetObjects[1].GetCellValue(1, sheetOverFlgList[i]) == ovrChkFlg) {
    			overObjList[overCustNum] = tgtObj[i];
    			overCustNum = overCustNum + 1;
    		}
    		
    	}
    	return overObjList;
    }
    
    function setOvrChkFlg (onFlg){
    	if(onFlg == null || onFlg == undefined){
    		onFlg = "Off";
    	}
    	if(onFlg == "On"){
    		for (var i = 0; i < sheetOverFlgList.length; i++) {
        		if (sheetObjects[1].GetCellValue(1, sheetOverFlgList[i]) == "N" ) {
        			document.getElementById(ovrChkFlgAll[i]).checked = true;    			
        		}else {
        			document.getElementById(ovrChkFlgAll[i]).checked = false;   
        		}
        	}
    	} else {
    		for (var i = 0; i < sheetOverFlgList.length; i++) {
    			document.getElementById(ovrChkFlgAll[i]).checked = false; 
        	}
    	}
    }
    
    function getOvrChkFlg(){
    	var ovrChkStr = "";
    	
    	if(sheetObjects[1].GetCellValue(1, "xter_rqst_no") == -1){
    		ovrChkStr = ovrChkStr + "&xter_rqst_no=";
    	}else{
    		ovrChkStr = ovrChkStr + "&xter_rqst_no=" + encodeURIComponent(sheetObjects[1].GetCellValue(1, "xter_rqst_no"));
    	}
    	
    	if(sheetObjects[1].GetCellValue(1, "xter_rqst_seq") == -1){
    		ovrChkStr = ovrChkStr + "&xter_rqst_seq=";
    	}else{
    		ovrChkStr = ovrChkStr + "&xter_rqst_seq=" + encodeURIComponent(sheetObjects[1].GetCellValue(1, "xter_rqst_seq"));
    	}
    	
		for (var i = 0; i < sheetOverFlgList.length; i++) {
    		if (document.getElementById(ovrChkFlgAll[i]).checked == true && sheetObjects[1].GetCellValue(1, sheetOverFlgList[i]) == "Y") {
    			ovrChkStr = ovrChkStr +"&" +ovrChkFlgAll[i]+"=Y";      			
    		}else{
    			ovrChkStr = ovrChkStr +"&" +ovrChkFlgAll[i]+"=";
    			document.getElementById(ovrChkFlgAll[i]).checked == false; 
    		}
    	}
		return ovrChkStr;
    }
    
    function memoShowValue(colNm){
    	var returnVal = "";
    	if(sheetObjects[1].GetCellValue(1, colNm) == -1){
    		returnVal = "";
    	}else {
    		returnVal = sheetObjects[1].GetCellValue(1, colNm);
    	}
    	return returnVal;
    }
    
    function initDisplayOnOff(){
    	changeDisplayOnOff(ovrChkFlgAll, "On");
     	changeDisplayOnOff(ovrChkFlgLblAll, "On");
     	changeDisplayOnOff(ovrDtlBtnAll, "On");
     	changeBtnEnable(ovrChkFlgAll, "Off");
     	changeBtnEnable(ovrChkFlgLblAll, "Off");
     	changeBtnEnable(ovrDtlBtnAll, "Off");
     	setOvrChkFlg("Off");
     	changeDisplayColor(ovrChkFlgLblAll, "gray");
     	changeDisplayColor(ovrDtlBtnLblAll, "black");
     }
