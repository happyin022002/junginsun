/*=========================================================
*1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003.js
*@FileTitle  : S/C Proposal & Amendment Creation
*@author     : CLT
*@version    : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common Global Variable
    var tabObjects=new Array();
    var tabCnt=0;
    //Variable for previous position when moving tab 
    var beforetab=1;    
    var sheetObjects=new Array();
    var sheetCnt=0;    
    var comboObjects=new Array();
    var comboCnt=0;
    //Variable to focus on modified scope
    var saveSvcScpCd="";
    //Variable to show hidden part in case of hidden control except tab when clicking new button
    var controlHidden=false;
    //Count of Back End Job execution
    var backEndJobCnt=0;
    //enable or disable of IHC Tab
    var ihcTabSts=true;
    //Special Note Dem/Det  , checkin whether saving(Prohibiting from moving tab in case of no saving after modification
    var returnValue="Y";
    //icon address variable to show each term's status
    var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif"; 
    var ICON_URL_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
    var ICON_URL_AMEND="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon4.gif";
    var ICON_URL_ACCEPT="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon3.gif";
    //Setting tab color to activate , deactivate tab
//    var TAB_SELECT_COLOR = "131,133,217"; 
    var TAB_TRUE_COLOR="206,220,246";
    var TAB_FALSE_COLOR="192,192,192";    
	 /*
	  *  Flag to have super user's authority
	  */
	 var IS_SUPER_USER=false;
	 var superUserRoute="";
	 var STANDARD_SUPER_USER_ROUTE="btn_new|btn_amend|btn_request|btn_coffer|btn_approve|btn_scnoassign|btn_file|btn_cancel|btn_copy|btn_print|btn_prop_mqc_pop|btn_ctrt_pty_pop";
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function processButtonClick() {
        /** **************************************************** */
        var formObj=document.form;
       // try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
            case "btn_hidden":            	
            	setControlHidden();
            	break;
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                
                formObj.sc_no.readOnly=false;
           	    formObj.prop_no.readOnly=false;
                break;
            case "btn_amend":   
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }   
    	        /////////////////////////////////////////////////////////////////////
    	        // Checking update date 
    	        var checkSheetObj=sheetObjects[0];
    	        var checkTpCd="CHECK2";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        /////////////////////////////////////////////////////////////////////
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sParam="sc_no="+sSc_No+"&sEffDt="+sheetObjects[0].GetCellValue(1,"eff_dt")
                + "&sExpDt="+sheetObjects[0].GetCellValue(1,"exp_dt");
                ComOpenPopup("ESM_PRI_0036.do?"+sParam, 500, 320, "btn_amend_returnVal", "1,0,1,1,1,1,1", true);
                
                break;              
            case "btn_dur_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sSvcScpCd="";
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq
                		  + "&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd 
                		  + "&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr
                		  + "&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg +"&sLgcyIfFlg="+sLgcyIfFlg;
                ComOpenPopup("ESM_PRI_0019.do?"+sParam, 640, 380, "btn_dur_pop_returnVal", "none", true);
                break;          
            case "btn_ctrt_pty_pop": //customer button
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }                   
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sEffDt=sheetObj.GetCellValue(1, "eff_dt");
                var sExpDt=sheetObj.GetCellValue(1, "exp_dt");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sCustCntCd=sheetObj.GetCellValue(1, "cust_cnt_cd");
                var sCustSeq=ComLpad(sheetObj.GetCellValue(1, "cust_seq"), 6, "0");
                var sCustNm=encodeURIComponent(sheetObj.GetCellValue(1, "ctrt_pty_nm"));
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="
                             +sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt+"&sCustCntCd="+sCustCntCd+"&sCustSeq="+sCustSeq+"&sCustNm="+sCustNm
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;
            	ComOpenPopup("ESM_PRI_0022.do?"+sParam,  900, 430, "btn_ctrt_pty_pop_returnVal", "none", true);
                
                break;      
            case "btn_ctrt_cust_tp_pop":  //customer 줄의 두번째 돋보기 아이콘         
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sEffDt=sheetObj.GetCellValue(1, "eff_dt");
                var sExpDt=sheetObj.GetCellValue(1, "exp_dt");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="
                             +sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt+"&sSrepCd="+sSrepCd
                             +"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;
                ComOpenPopup("ESM_PRI_0017.do?"+sParam, 600, 320, "btn_ctrt_cust_tp_pop_returnVal", "none", true);
                
                break;  
            case "btn_ctrt_cust": //customer 줄의 첫번째 돋보기 아이콘
            	var sParam = "is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value;
            	 ComOpenPopup("ESM_PRI_4014_POP.do?"+sParam, 640, 465, "btn_ctrt_cust_returnVal", "none", true);
                
                break;  
            case "btn_real_cust":   
            	var sParam = "is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.real_cust_cnt_cd.value+"&cust_seq="+formObj.real_cust_seq.value;
                ComOpenPopup("ESM_PRI_4014_POP.do?"+sParam, 640, 465, "btn_real_cust_returnVal", "none", true);
                break;
            case "btn_prop_mqc_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sSvcScpCd="";
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg
                			+"&sPreExpDt="+sPreExpDt+"&sLgcyIfFlg="+sLgcyIfFlg;
                ComOpenPopup("ESM_PRI_0020.do?"+sParam, 750, 570, "btn_prop_mqc_pop_returnVal", "1,0,1,1,1,1,1", true); //570
                
                break;      
            case "btn_save":             	
                var effDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
                var sEffDt=sheetObjects[0].GetCellValue(1, "ctrt_eff_dt");
                if (effDt != sEffDt){
                	com_change_sheet( sheetObjects[0], "ctrt_eff_dt" );
                }
                
                var expDt=ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd");
                var sExpDt=sheetObjects[0].GetCellValue(1, "ctrt_exp_dt");
                if (expDt != sExpDt){
                	com_change_sheet( sheetObjects[0], "ctrt_exp_dt" );
                }
                
                 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
            case "btn_request": 

                //2015.05.14 when the file date exsits, forcely filed
            	var fileDt = formObj.file_dt.value;
                if(fileDt != null && fileDt != "")  {
                	
                	if (!ComShowCodeConfirm("PRI01032","File")){                 
                        return false;
                    }
                	
                	formObj.f_cmd.value=MULTI08;
     	            //forcely
                	sheetObjects[0].SetCellValue(1,"prop_sts_cd","A",0);
     	            var sParam="";  
     	            var sParamSheet1=sheetObjects[0].GetSaveString(1);
     	            if (sParamSheet1 != "") {
     	                sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
     	            }
     	            var sParamSheet2=sheetObjects[1].GetSaveString(1);
     	            if (sParamSheet2 != "") {
     	                sParam +=  "&"+ComPriSetPrifix(sParamSheet2, "sheet2_");
     	            }
     	            sParam += "&f_cmd=" + MULTI08;
     	            var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
     	            sheetObjects[0].LoadSaveData(sXml);
     	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	            ComOpenWait(false); //->waiting->End
                	
                	return;
                }
            	
            	doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
                break; 
            case "btn_coffer":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                doActionIBSheet(sheetObjects[0],document.form,COMMAND03);
                break;
            case "btn_approve":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
                break;
            case "btn_scnoassign":
                var sheetObj=sheetObjects[0];
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var ctrtEffDt=formObj.ctrt_eff_dt.value;
                var ctrtExpDt=formObj.ctrt_exp_dt.value;
                var svcScpCd=sheetObjects[1].GetCellValue(1,"svc_scp_cd");
                var svcCnt=sheetObjects[1].RowCount();
                var ofcCd=sheetObj.GetCellValue(1,"prop_ofc_cd");
                var sParam="sPropNo="+sPropNo+"&amdt_seq="+sAmdtSeq+"&sCtrtEffDt="+ctrtEffDt
                            +"&sCtrtExpDt="+ctrtExpDt+"&svcScpCd="+svcScpCd+"&svcCnt="+svcCnt+"&sOfcCd="+ofcCd  ;
                ComOpenPopup("ESM_PRI_0056.do?"+sParam, 550, 200, "btn_scnoassign_returnVal", "1,0,1,1,1,1,1", true);
                break;
            case "btn_file":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
    	        /////////////////////////////////////////////////////////////////////
    	        // Checking update date
    	        var checkSheetObj=sheetObjects[0];
    	        var checkTpCd="CHECK1";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        /////////////////////////////////////////////////////////////////////
                var sheetObj=sheetObjects[0];
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var ctrtEffDt=formObj.ctrt_eff_dt.value;
                var ctrtExpDt=formObj.ctrt_exp_dt.value;
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sEffDt=sheetObj.GetCellValue(1, "eff_dt");
                var sSlsLdNo=sheetObj.GetCellValue(1, "sls_ld_no");
                var sParam="sPropNo="+sPropNo+"&amdt_seq="+sAmdtSeq+"&sCtrtEffDt="+ctrtEffDt
                			 +"&sCtrtExpDt="+ctrtExpDt+"&sSc_No="+sSc_No+"&sEffDt="+sEffDt+"&sSlsLdNo="+sSlsLdNo;
                ComOpenPopup("ESM_PRI_0058.do?"+sParam, 450, 330, "btn_file_returnVal", "1,0,1,1,1,1,1", true);
                break;                   
            case "btn_cancel":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }   
                doActionIBSheet(sheetObjects[0],document.form,COMMAND05);                
                break;              
            case "btn_copy":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sCustTp=prc_ctrt_cust_tp_cd.GetSelectCode();
                var sParam="sc_no="+sSc_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                sParam=sParam + "&cust_tp=" + sCustTp;
                ComOpenPopup("ESM_PRI_0096.do?"+sParam, 950, 300, "btn_copy_returnVal", "1,0,1,1,1,1,1", true);
                break;  
            case "btn_print":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sScNo=sheetObj.GetCellValue(1,"sc_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sParam="";    
                var prop_sts_cd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var rtnVal="";
                var isPrintFull="";

                if(sAmdtSeq != "0") {
                //In case of amend seq != 0, user can select full print or amend draft
	            	$("#confirmDialog").dialog(
	                		{
	                		title : "S/C Print",
	                		resizable: false,
	                		beforeClose: function( event, ui ) {
	                			$(this).parent().parent().find(".layer_popup_bg").remove();
	        					$(parent.document.body).find(".layer_popup_bgTop,.layer_popup_bgBtm").remove();
	                		},
	                		buttons: [
	                			{
	                				text: "Full S/C ",
	                				click: function() {
	                					isPrintFull="Y";
	                					sParam="prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
	                                	ComOpenPopup("ESM_PRI_0061.do?"+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
	                					$(this).dialog("close");
	
	                				}
	                			},
	                			{
	                				text: "Amend Draft",
	                				click: function() {
	                					isPrintFull="N";
	                					sParam=sPropNo + ":" + sScNo + ":" + sAmdtSeq + ";"
	                                	ComOpenPopup("ESM_PRI_0079.do?sParam="+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
	                					$(this).dialog("close");
	                				}
	                			},
	                			{
	                				text: "Cancel",
	                				click: function() {
	                					isPrintFull="C";
	                					$(this).dialog("close");
	                				}
	                			}
	                		]
	                	}
	                );                	
                } else {
                	sParam="prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                	ComOpenPopup("ESM_PRI_0061.do?"+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
                }                
                break;
                
            case "btn_blpl_pop":
                var formObj=document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sEffDt=sheetObj.GetCellValue(1, "eff_dt");
                var sExpDt=sheetObj.GetCellValue(1, "exp_dt");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sCtrtEffDt=document.form.ctrt_eff_dt.value;
                var sCtrtExpDt=document.form.ctrt_exp_dt.value;
                var sBlplHdrSeq=sheetObj.GetCellValue(1, "blpl_hdr_seq");
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+
                             "&sPropStsCd="+sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sCtrtEffDt="+sCtrtEffDt
                             +"&sCtrtExpDt="+sCtrtExpDt +"&sBlplHdrSeq="+sBlplHdrSeq+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;                     
                ComOpenPopup("ESM_PRI_0023.do?"+sParam, 1000, 652, "btn_blpl_pop_returnVal", "1,0,1,1,1,1,1", true);
                break;  
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                var sheetObj=sheetObjects[0];
                var sSc_No=sheetObj.GetCellValue(1,"sc_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
                var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
                var sEffDt=sheetObj.GetCellValue(1, "eff_dt");
                var sExpDt=sheetObj.GetCellValue(1, "exp_dt");
                var sPreExpDt=sheetObj.GetCellValue(1, "pre_exp_dt");
                var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
                var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
                var sCtrtEffDt=document.form.ctrt_eff_dt.value;
                var sCtrtExpDt=document.form.ctrt_exp_dt.value;   
                var sLgcyIfFlg=sheetObj.GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+
                             "&sPropStsCd="+sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sCtrtEffDt="+sCtrtEffDt
                             +"&sCtrtExpDt="+sCtrtExpDt+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;                                 
                
                ComOpenPopup("ESM_PRI_0025.do?"+sParam, 1000, 370, "afil_pop_returnVal", "1,0", true);
                break;                  
            case "btn_rowadd":
                doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
                break;
            case "btn_delete":
                doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
                break;      
            case "btns_calendar1":
            	//calendar button
            	 var cal=new ComCalendar();
                 cal.select(formObj.ctrt_eff_dt,'yyyy-MM-dd');
                 break;
            case "btns_calendar2":               
                var cal=new ComCalendar();
                cal.select(formObj.ctrt_exp_dt,'yyyy-MM-dd');
                break;
            case "conv_cfm_flg":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    formObj.conv_cfm_flg.checked=false;                    
                    return;
                } 
            	conversionConfirm();
            	break;
            case "btn_cancel_file": // Cancel filing functino for only Superuser
            	doFileCancel(true);               
                break;                     
            } // end switch

    }
    
    /**
     * cancel File status</b>
     * <br><b>Example :</b>
     * <pre>
     *     doFileCancel(true);
     * </pre>
     * @param {bool} true/false
     * @return N/A
     * @author 
     * @version 2015.04.16
     */  
    function doFileCancel(isSPUser) {
    	var formObj = document.form;
    	if (formObj.prop_no.value ==""){
            ComShowCodeMessage('PRI01021');                    
            return;
        }
    	if (isSPUser && !ComShowCodeConfirm("PRI01046")) {
	        return false;
	    } 
        doActionIBSheet(sheetObjects[0],document.form,COMMAND06);
    }
    
    function afil_pop_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
        }
    }
    
    function btn_prop_mqc_pop_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
        }           
    }
    
    function btn_ctrt_cust_tp_pop_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
        }      
    }
    
    function btn_ctrt_pty_pop_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
        }      
    }
    
    function btn_ctrt_cust_returnVal(rtnVal) {
    	var formObj = document.form;
    	if (rtnVal != null){
            formObj.cust_cnt_cd.value=rtnVal.custCntCd;
            formObj.cust_seq.value=rtnVal.custSeq;
            formObj.ctrt_pty_nm.value=rtnVal.custNm;                    
            custNameFind("cust_cnt_cd");
            //sale rep
            setCustSaleRep();
            comboObjects[3].SetSelectCode(sheetObjects[0].GetCellValue(1,"ctrt_cust_srep_cd"),false);
            com_change_sheet( sheetObjects[0], "cust_seq");
        }
    }
    
    function btn_dur_pop_returnVal(rtnVal) {
    	 if (rtnVal != null && rtnVal =="Y"){
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
         }
    }
    
    function btn_amend_returnVal(rtnVal) {
    	if(rtnVal){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    function btn_blpl_pop_returnVal(rtnVal) {
    	 if (rtnVal != null && rtnVal =="Y"){
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
         }
    }
    
    function btn_copy_returnVal(rtnVal) {
    	if(rtnVal != null){
            document.form.prop_no.value=rtnVal;
            document.form.sc_no.value="";
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    function btn_file_returnVal(rtnVal) {
    	if(rtnVal != null && rtnVal == "Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                    
        }
    }
    
    function btn_real_cust_returnVal(rtnVal) {
    	if (rtnVal != null){
            document.form.real_cust_cnt_cd.value=rtnVal.custCntCd;
            document.form.real_cust_seq.value=rtnVal.custSeq;
            document.form.real_cust_nm.value=rtnVal.custNm; 
            realCustNameFind("real_cust_cnt_cd");
            //sale rep
            setRealCustSaleRep();
            comboObjects[5].SetSelectCode(sheetObjects[0].GetCellValue(1,"real_cust_srep_cd"),false);
            com_change_sheet( sheetObjects[0], "real_cust_seq");
        }               
    }
    
    function btn_scnoassign_returnVal(rtnVal) {
    	if(rtnVal !=null && rtnVal[0] =="Y"){
            document.form.sc_no.value=rtnVal[1];
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */    
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
     * <br><b>Example :</b>
     * <pre>
     *     setTabObject(tab_obj);
     * </pre>
     * @param {ibtab} tab_obj Mandatory IBTab Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */    
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
      * registering IBMultiCombo Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
    * @return N/A
    * @author 
    * @version 2009.04.17
    */      
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function loadPage() {
    	ComSetDisplay("btn_cancel_file",false);  
    	
        for (var i=0; i < sheetObjects.length; i++) { 
            ComConfigSheet(sheetObjects[i]);    
            initSheet(sheetObjects[i], i + 1);   
            ComEndConfigSheet(sheetObjects[i]);
            sheetObjects[i].XmlHttpVer=2;
        }
        for (var k=0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
            tabObjects[k].SetSelectedIndex(0);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initControl();        
   	 	var form=document.form;
         if (form.cond_prop_no.value != "") {//In case of calling from S/C Proposal & Amendment Inquiry
            form.prop_no.value=form.cond_prop_no.value;
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
            doActionIBSheet(sheetObjects[0],form,IBSEARCH);
        }else{
        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        }
        // 2015-07-28 CHLOE : Hide IHC tab       
        tab1.SetTabHidden(8, true);
         
    }
    /**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */ 	    
     function initControl() {           
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerFormat('focusout', 'obj_deactivate', document.form);       
        axon_event.addListener('change', 'rf_flg_OnChange', 'rf_flg');
        axon_event.addListener('change', 'gamt_flg_OnChange', 'gamt_flg');
        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
        
        //2014.11.25 [NYK]
        axon_event.addListenerForm('click', 'obj_click', form);

     }
     var ctrl = false;
     var ctrlAlt = false;
     var ctrlAltShift = false;
     /**
     * Handling OnKeyDown even <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */       
   function obj_keydown(){
       //Proposal No,S/C No.,Retrieving by enter key
       var eleName=ComGetEvent("name");
       if (eleName == "prop_no" || eleName == "sc_no"){
	       var keyValue=null;
	       if(event == undefined || event == null) {
	    	   keyValue=13;
	       }else{
	    	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	       }
	       if (keyValue == 13){
	    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	       }
	       //Cancel File(Special Function) 
	       if(eleName == "sc_no"){
	    	   	   if(keyValue == 17) {
	    	           ctrl = true;
	    	   	   }else if(ctrl && keyValue == 18) {
	    	   		   ctrlAlt = true;
	    	   	   }else if(ctrlAlt && keyValue == 16) {
	    	   		   ctrlAltShift = true;
	    	       }else if(ctrlAltShift && keyValue == 81) {
	    	    	   ctrl = false;
	    	    	   ctrlAlt = false;
	    	    	   ctrlAltShift = false;
	    	    	   IS_SUPER_USER = true;
	    	    	   ComSetDisplay("btn_cancel_file", true);
	    	    	   ComBtnEnable("btn_cancel_file");  
	    	    	   
	    	    	   ComBtnEnable("btn_retrieve");
	    	    	   ComBtnEnable("btn_new");
	    	    	   ComBtnEnable("btn_amend");
	    	    	   ComBtnEnable("btn_save");
	    	    	   ComBtnEnable("btn_request");
	    	    	   ComBtnEnable("btn_coffer");
	    	    	   ComBtnEnable("btn_approve");
	    	    	   ComBtnEnable("btn_scnoassign");
	    	    	   ComBtnEnable("btn_file");
	    	    	   ComBtnEnable("btn_cancel");
	    	    	   ComBtnEnable("btn_copy");
	    	    	   ComBtnEnable("btn_print");
	    	    	   
	    	       }else if(ctrlAltShift && keyValue == 90) {
	    	    	   ctrl = false;
	    	    	   ctrlAlt = false;
	    	    	   ctrlAltShift = false;
	    	    	   IS_SUPER_USER = false;
	    	    	   ComSetDisplay("btn_cancel_file", false);
	    	    	   ComBtnDisable("btn_cancel_file");  
	    	       }

	       }
       }
   }
   
     /**
      * handling OnKeyPress event <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_keypress()
      * </pre>
      * @param N/A
      * @return N/A
      * @author 
      * @version 2009.04.17
      */     
//    function obj_keypress() {
//        switch (event.srcElement.dataformat) {
//            case "engup":
//                if (event.srcElement.name == "sc_no" ||event.srcElement.name == "prop_no") {
//                    ComKeyOnlyAlphabet('uppernum');
//                } else {
//                    ComKeyOnlyAlphabet('upper');
//                }    
//                break;
//            case "int":
//                ComKeyOnlyNumber(event.srcElement);
//                break;
//            case "float":
//                ComKeyOnlyNumber(event.srcElement, ".");
//                break;
//            case "ymd":
//            	ComKeyOnlyNumber(event.srcElement, "-");
//                break;
//            default:
//        }
//    }    
    /**
     * Handling onMouseMove event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_onmousemove()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */       
    function obj_onmousemove(){
    	var formObj=document.form;
    	var eleName=event.srcElement.name;
        switch(eleName){
        case "oti_no"://OTI Bond No 표시
        	var title="";
        	if (formObj.oti_eff_dt.value == "" && formObj.oti_exp_dt.value == "" 
        		&& formObj.oti_lic_no.value == "" && formObj.oti_amt.value == ""){        		
        		document.getElementById("oti_no").title="...............";
        	}else{
        		title="License No : "+ formObj.oti_lic_no.value +"\n";
        		title +="Effective      : "+ ComGetMaskedValue(formObj.oti_eff_dt,"ymd")+"\n";  
        		title +="Expires       : " + ComGetMaskedValue(formObj.oti_exp_dt,"ymd")+"\n"; 
        		title +="AMT           : "+ ComAddComma(formObj.oti_amt.value);
            	document.getElementById("oti_no").title=title;        		
        	}
            break;
        default:
        }    	
    }
    /**
    * Handling Onbeforedeactivate  event <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function obj_deactivate() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0]; 
        var sheetObj1=sheetObjects[0];    
        var eleName=event.srcElement.name;
        switch(eleName){
            case "sc_no":    
                com_change_sheet( sheetObj, eleName );
                break;
            case "prop_no":
//                formObj.prop_no.value = comKeyUpChangeCapital(formObj.prop_no.value);       
                break;
            case "cust_cnt_cd":
                //cust name find
            	if (sheetObj.GetCellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
                	if (formObj.cust_cnt_cd.value == ""){
                		clearCustName();
                	}else{
                    	custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        //Setting code from retrievd data after setting COMBO
                        comboObjects[3].SetSelectCode(sheetObj1.GetCellValue(1,"ctrt_cust_srep_cd"),false);
                        //sale lead
//                        setSaleLeadCombo(true); 
                        sheetObj.SetCellValue(1, "sls_ld_no","");
                	}
                }
                ComChkObjValid(event.srcElement);
                break;          
            case "cust_seq":
                var custSeq=formObj.cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value=ComLpad(custSeq, 6, "0");
                }
                //cust name find                
                if (ComParseInt(sheetObj.GetCellValue(1, "cust_seq")) != ComParseInt(formObj.cust_seq.value)){
                    if (formObj.cust_seq.value ==""){ 
                    	clearCustName();
                    }else{
                        custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        comboObjects[3].SetSelectCode(sheetObj1.GetCellValue(1,"ctrt_cust_srep_cd"),false);
                        //sale lead
//                        setSaleLeadCombo(true); 
                        sheetObj.SetCellValue(1, "sls_ld_no","");
                    }
                }
                break;
            case "real_cust_cnt_cd":
                //real cust name find
            	if (sheetObj.GetCellValue(1, "real_cust_cnt_cd") != formObj.real_cust_cnt_cd.value){
                    if (formObj.real_cust_cnt_cd.value == "" ){
                    	clearRealCustName();
                    }else{
                        realCustNameFind(eleName);
                        //sale rep
                        setRealCustSaleRep();
                        comboObjects[5].SetSelectCode(sheetObj1.GetCellValue(1,"real_cust_srep_cd"),false);
                        //sale lead
//                        setSaleLeadCombo(true); 
                        sheetObj.SetCellValue(1, "sls_ld_no","");
                    }
                }               
                ComChkObjValid(event.srcElement);
                break;          
            case "real_cust_seq":
                var realCustSeq=formObj.real_cust_seq.value; 
                if (realCustSeq.length < 6 && realCustSeq.length != 0 ){
                    formObj.real_cust_seq.value=ComLpad(realCustSeq, 6, "0");
                }            
                //real cust name find               
                if (ComParseInt(sheetObj.GetCellValue(1, "real_cust_seq")) != ComParseInt(formObj.real_cust_seq.value)){
                	if ( formObj.real_cust_seq.value == "" ){           
                    	clearRealCustName();
                    }else{
                    	realCustNameFind(eleName);
                        //sale rep
                        setRealCustSaleRep();
                        comboObjects[5].SetSelectCode(sheetObj1.GetCellValue(1,"real_cust_srep_cd"),false);
                        //sale lead
//                        setSaleLeadCombo(true); 
                        sheetObj.SetCellValue(1, "sls_ld_no","");
                    }
                }               
                break;      
            case "ctrt_exp_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
                com_change_sheet( sheetObj, "ctrt_exp_dt" );
                break;
            case "ctrt_eff_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
                com_change_sheet( sheetObj, "ctrt_eff_dt" );
                break;
            case "prop_mqc_qty":
                com_change_sheet( sheetObj, eleName );  
                break;              
            case "prop_ofc_cd"://Changing Sales Rep. Combo when modifying Request Office
            	if (sheetObj.GetCellValue(1,"prop_ofc_cd") != formObj.prop_ofc_cd.value){
                    var sheetObj=sheetObjects[0];                                                 
                    var cd=formObj.prop_ofc_cd.value;         
                    formObj.f_cmd.value=COMMAND22;
                    var sParam=FormQueryString(formObj)+"&cd="+cd;
                    var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                    var arrData=ComPriXml2Array(sXml, "cd|nm");
                    if (arrData != null && arrData.length > 0) {
                    	setRequestOfficeSaleRep();
                    }else{  
                    	formObj.prop_ofc_cd.value="";
                        prop_srep_cd.RemoveAll();
                        formObj.prop_srep_nm.value="";                        
                        formObj.prop_ofc_cd.focus();
                    }                           
                    com_change_sheet( sheetObj, "prop_ofc_cd" );                    
                }
                break;     
            default:
                ComChkObjValid(event.srcElement);       
        }
    } 
    
    /**
     * 2014-11-25 [NYK]
     * Applying modified value to hidden sheet when modifying value<br>
     * Modifying N in case of unchecking Y when checking value<br>
     * <br><b>Example :</b>
     * <pre>
     *    obj_click();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2014-11-25
     */  
    function obj_click(){
    	var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		if(event.srcElement.name == "prxy_flg") {

	        var vChkVal = document.form.prxy_flg.checked;
	        sheetObj.SetCellValue(1,event.srcElement.name, (vChkVal == true) ? "Y" : "N");   

		} //end if

        
        
    }
    
    
    /**
    * Handling OnBeforeActivate event <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        ComClearSeparator (event.srcElement);
    }
    /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2009.04.17
     */    
    function doActionIBSheet(sheetObj, formObj, sAction) {
//        sheetObj.ShowDebugMsg(false);
        try{
            switch (sAction) {            
            case IBSEARCH: 
            	ComOpenWait(true); //->waiting->start
            	clearAllTabPages();
            	sheetObj=sheetObjects[0];
            	var params="";
            	var arrXml="";            	
            	var researchXml="";//
                if (validateForm(sheetObj,document.form,sAction)) {
                	formObj.f_cmd.value=SEARCH01;
                    if(formObj.sc_no.value!="")
                        formObj.prop_no.value="";
                    params=FormQueryString(formObj);
                    var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , params);
                    arrXml=sXml.split("|$$|");
                    if (arrXml.length > 0) {
                    	sheetObjects[0].LoadSearchData(arrXml[0], {Sync:1});
                    	//re-Retrieving in case of empty value
                    	researchXml=arrXml[0];                    	
                    	//조회될 당시의 Proposal No,Amend Seq. S/C no. Setting
                    	formObj.ori_prop_no.value=sheetObj.GetCellValue(1, "prop_no");
                    	formObj.amdt_seq.value=sheetObj.GetCellValue(1, "amdt_seq");
                    	formObj.ori_sc_no.value=sheetObj.GetCellValue(1, "sc_no");
                        if (arrXml.length > 2){
                        	ComPriXml2ComboItem(arrXml[2], prop_srep_cd, "cd", "cd|nm");      
                        }
                        if (arrXml.length > 3){
                        	ComPriXml2ComboItem(arrXml[3], ctrt_cust_srep_cd, "cd", "cd|nm|etc1");      
                        }
                        if (arrXml.length > 4){
                        	ComPriXml2ComboItem(arrXml[4], real_cust_srep_cd, "cd", "cd|nm|etc1");
                        }
                        if (arrXml.length > 1){
                        	sheetObjects[1].LoadSearchData(arrXml[1], {Sync:1} );
                        	for (var i=5;i < arrXml.length; i++){ 
                        		setSheetRequestOfficeSaleRep(sheetObjects[1], i-4, sheetObjects[1].GetCellValue(i-4, "prop_scp_ofc_cd"));
                        	}
                        }    
                    }
                }
                calcMVC();
                ComOpenWait(false); //->waiting->End
                // Re-Retrieving if Search Xml is empty
                if (arrXml[0] != null && ComPriGetRowCountFromXML(arrXml[0]) == -1){
                	if (researchXml != ""){
                		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                	}else if (researchXml==""){                	
                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	}
                }
                buttonControl();
                formObj.prop_no.focus();
                
                //2015.05.12 ADD
           	 	formObj.sc_no.readOnly=true;
           	 	formObj.prop_no.readOnly=true;

                break;
            case IBCREATE: // New
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
            	if (controlHidden) setControlHidden();
            	//for new inputting
        		if (tabObjects[0].GetSelectedIndex()== 0) {
        			tab1_OnChange(tabObjects[0], 0);
        		} else {
        			tabObjects[0].SetSelectedIndex(0);
        		}            	
                clearAllForms();
                clearAllTabPages();
                clearButtonImages();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);                 
                sheetObjects[0].DataInsert();
                var sheetObj=sheetObjects[0];
                var formObj=document.form;
                sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                sheetObj.SetCellValue(1,"prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(1,"src_info_cd","NW",0);
                sheetObj.SetCellValue(1,"rf_flg","N",0);
                sheetObj.SetCellValue(1,"gamt_flg","N",0);
                sheetObj.SetCellValue(1,"prc_ctrt_pty_tp_cd","C",0);
                sheetObj.SetCellValue(1, "prc_prop_cre_tp_cd","G",0);
                sheetObj.SetCellValue(1,"prop_ofc_cd",formObj.in_usr_ofc_cd.value,0);
                sheetObj.SetCellValue(1,"cntr_lod_ut_cd","F",0);
                sheet1_OnSearchEnd(sheetObj);
                setRequestOfficeSaleRep();
                sheetObj.SetCellValue(1,"amdt_seq","0",0);
                formObj.amdt_seq.value="0";
                cntr_lod_ut_cd.SetSelectText("F");
                prop_srep_cd.SetSelectCode(formObj.in_usr_srep_cd.value);
                prop_srep_cd_OnBlur(comboObjects[0])
                ComOpenWait(false); //->waiting->End
                if (formObj.mst_prop_no.value != "") {  // REtrieving by proposal no in case of from S/C Master
                    formObj.prop_no.value=formObj.mst_prop_no.value;
                    sheetObj.SetCellValue(1, "prop_no",formObj.mst_prop_no.value,0);
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
                    formObj.mst_prop_no.value="";
                }else{
                    formObj.ctrt_eff_dt.focus();
                    buttonControl();
                    setNewDataControl();
                }
                break;
            case IBSAVE: // Save
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                if (!ComPriConfirmSave()) {
                    return false;
                }
                //duration change 
                if (!saveChangeDuration("false")){
                    return false;
                }
                // Transmitting whether proposed or not to parameter. except main , skip in case of no proposal
                // proposal 이 아닌 경우는 건너뜀
                var mstAmdtSeq=sheetObjects[0].GetCellValue(1, "amdt_seq");
                formObj.f_cmd.value=MULTI01;
                var sParam="";
                //Putting value to transmit to server to variable(Html Objects), 
                var sParamSheet1=sheetObjects[0].GetSaveString(true);
                if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
                    return;
                }                
                if (sParamSheet1 != "") {         	
                	sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheetObjects[1].GetSaveString(true);
                if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
                    return;
                }                
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;
                var sXml=sheetObjects[1].GetSaveData("ESM_PRI_0003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml, {Sync:1});
                sXml=ComDeleteMsg(sXml);//Deleting sucessful saving message
                sheetObjects[1].LoadSaveData(sXml, {Sync:1});
                var formObj=document.form;
                //in case of new row, Proposal No. setting
                if(formObj.sc_no.value=="" && formObj.prop_no.value==""){           
                    formObj.prop_no.value=ComGetEtcData(sXml,"prop_no");          
                }
                //Variable for moving highlight to previous saving position
                saveSvcScpCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "svc_scp_cd");
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                ComOpenWait(false); //->waiting->End
                break;
            case IBSEARCH_ASYNC01: // Setting Approval Office Code, customer type
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }            
                comboObjects[1].RemoveAll();
    	        comboObjects[2].RemoveAll();
    	        comboObjects[4].RemoveAll();
    	        comboObjects[6].RemoveAll();
    	        comboObjects[7].RemoveAll();
    	        //apvl ofc
    	        sheetObjects[1].SetColProperty("prop_scp_apro_ofc_cd", {ComboText:appAllCdText , ComboCode:appAllCdValue} );
    	        ComPriTextCode2ComboItem(appCdValue, appCdText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
    			//scope cd
    	        sheetObjects[1].SetColProperty("svc_scp_cd", {ComboText:scopeCdText, ComboCode:scopeCdValue} );
    	        //cust type cd
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'real_cust_tp_cd') ,"|","\t" );
    	        //lodUtCd
    	        ComPriTextCode2ComboItem(lodUtCdValue, lodUtCdText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    	        sheetObjects[1].SetColProperty("cntr_lod_ut_cd", {ComboText:lodUtCdText, ComboCode:lodUtCdValue} );
    	        //scope status
    	        sheetObjects[1].SetColProperty("prop_scp_sts_cd", {ComboText:scpStsCdText, ComboCode:scpStsCdValue} );
    	        //ctrtDurTpCd : 2017.07.23 ADD
    	        ComPriTextCode2ComboItem(ctrtDurTpCdValue, ctrtDurTpCdText, getComboObject(comboObjects, 'ctrt_dur_tp_cd') ,"|","\t" );
    	        
                break;
            case COMMAND02:// REQUEST
            	ComOpenWait(true); //->waiting->start
    	        if (!validateForm(sheetObjects[0],document.form,sAction)) {
    	            return false;
    	        }
    	        //Retrieving whether requesting before
    	        //Don't call GW main PipUp if requested before
	   	         formObj.f_cmd.value=SEARCH;
	   	         sPara="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
		         sPara += "&" + FormQueryString(formObj);
		         cXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sPara);
		         var arrData=ComPriXml2Array(cXml, "etc1");   
		         var chkReq="";
		         if (arrData !=null && arrData.length > 0){
		        	 if (arrData[0][0] == 0){
		        		 chkReq="Y";
		             }
		         }
    	        formObj.f_cmd.value=MULTI02;
    	        sheetObjects[0].SetCellValue(1,"prop_sts_cd","Q",0);
    	        var rDate=new Date();
    	        var yy=rDate.getFullYear();
    	        var mm=rDate.getMonth() + 1 +"";
    	        var dd=rDate.getDate() +"";
    	        if (mm.length == 1) mm="0" + mm;
    	        if (dd.length == 1) dd="0" + dd;              
    	        sheetObjects[0].SetCellValue(1,"cre_dt",yy+mm+dd,0);
    	        var sParam="";   	
    	        var sParamSheet1=sheetObjects[0].GetSaveString(true);
    	        if (sParamSheet1 != "") {
    	            sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
    	        }
    	        var sParamSheet2=sheetObjects[1].GetSaveString(true);
    	        if (sParamSheet2 != "") {
    	            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
    	        }else{
    	        	return;
    	        }
    	        sParam += "&" + FormQueryString(formObj); 
    	        var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
    	        sheetObjects[0].LoadSaveData(sXml);
    	        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	        ComOpenWait(false); //->waiting->End
            	break;
            case COMMAND03: // Counter Offer       
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }       
                formObj.f_cmd.value=MULTI02;                
                sheetObj.SetCellValue(1,"prop_sts_cd","R",0);
                var sParam="";
                var sParamSheet1=sheetObjects[0].GetSaveString(true);
                if (sParamSheet1 != "") {
                    sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheetObjects[1].GetSaveString(true);
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj);
                var sXml=sheetObj.GetSaveData("ESM_PRI_0003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveData(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;
            case COMMAND04: // Approve     
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=MULTI03;
                sheetObj.SetCellValue(1,"prop_sts_cd","A",0);
                var sParam=sheetObjects[0].GetSaveString(true);
                sParam += "&" + FormQueryString(formObj);
                var sXml=sheetObj.GetSaveData("ESM_PRI_0003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveData(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                ComOpenWait(false); //->waiting->End
                break;            
            case COMMAND05: // Cancel
            	ComOpenWait(true); //->waiting->start
	            if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
	                ComShowCodeMessage('PRI01057'); 
	                return false;
	            }         
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
            	var amdtSeq=formObj.amdt_seq.value;            	
            	if (amdtSeq =="0"){
        	        if (prop_sts_cd !="I" && !ComShowCodeConfirm("PRI01046")) {
        	            return false;
        	        }   
            	}else{
        	        if (!ComShowCodeConfirm("PRI01046")) {
        	            return false;
        	        }   
            	}
                formObj.f_cmd.value=MULTI04;
                switch(prop_sts_cd){
                case 'I':
                case 'Q':
                case 'R':
                case 'A':
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);// Transmitting all data of scope
                    if (sParamSheet2 == "") {
                    	return;
                    }
                	break;
                }
                switch(prop_sts_cd) {
                case 'I':   //Deleting all of Initial data
                	var rValue=checkDemDetCancel();
            		if (rValue !="Y"){
            			ComShowCodeMessage("PRI01123");
            			return false;
            		}  
                	if (amdtSeq == "0"){
                		if (!ComShowCodeConfirm("PRI01124")) {
                            return false;
                        }    
                	}else{
                        if (!ComShowCodeConfirm("PRI01050")) {
                            return false;
                        }    
                	}
                	formObj.f_cmd.value=MULTI04;
                    sheetObj.SetCellValue(1,"prop_sts_cd","D",0);
                    var sParam="";           
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);// Transmitting all data of scope
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }          
                    sParam += "&" + FormQueryString(formObj);
                    var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    var amdtSeq=formObj.amdt_seq.value;
                    if (amdtSeq != "0"){
                    	formObj.amdt_seq.value=ComParseInt(amdtSeq) - 1;
                    }else{
                    	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    }
                    break;
                case 'Q':   // Requested  
                	var reqUsrFlg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
                	var aproUsrFlg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
	            	if (reqUsrFlg == "Y" && aproUsrFlg !="Y"){
	            		if (checkRequestCancel() == "N"){	            			
	            			return false;
	            		}
	            	}
                	formObj.f_cmd.value=MULTI04;
                    sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                    var sParam="";           
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }               
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }            
                    sParam += "&" + FormQueryString(formObj);
                    var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    break;
                case 'R':   // Returned
                    sheetObj.SetCellValue(1,"prop_sts_cd","Q",0);
	                var sParam="";              
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }        
                    sParam += "&" + FormQueryString(formObj);
                    var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    break;
                case 'A':   // Approved
                    sheetObj.SetCellValue(1,"prop_sts_cd","Q",0);
	                var sParam="";
	            	//              var sParam = FormQueryString(formObj);            
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }       
                    sParam += "&" + FormQueryString(formObj);
                    var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    if (formObj.amdt_seq.value=="0"){
                    	formObj.sc_no.value="";
                    }
                    break; 
                    
                case 'F': //Filed
                	doFileCancel(false);
                	break;
                    
                }   
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;      
            case IBINSERT: // Row Add
            	if (formObj.amdt_seq.value == "0"){
                    sheetObj.InitCellProperty(0, 12, dtData, 85, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, true, true);
                    sheetObj.InitCellProperty(0, 13, dtData, 85, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, true, true);   
                }else{
                    sheetObj.InitCellProperty(0, 12, dtData, 85, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
                    sheetObj.InitCellProperty(0, 13, dtData, 85, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, true); 
                }
                var idx=sheetObj.DataInsert();
                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
                sheetObj.SetCellValue(idx, "prop_scp_ofc_cd",formObj.prop_ofc_cd.value,0);
                setSheetRequestOfficeSaleRep(sheetObj, idx, sheetObj.GetCellValue(idx, "prop_scp_ofc_cd"));
                sheetObj.SetCellValue(idx, "prop_scp_apro_ofc_cd","",0);
                sheetObj.SetCellValue(idx, "prop_scp_apro_ofc_cd",comboObjects[1].GetSelectCode(),0);
                sheetObj.SetCellValue(idx, "prop_scp_apro_ofc_cd","",0);
                sheetObj.SetCellValue(idx, "prop_scp_apro_ofc_cd",comboObjects[1].GetSelectCode(),0);
                sheetObj.SetCellValue(idx, "cntr_lod_ut_cd",cntr_lod_ut_cd.GetSelectCode(),0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "ctrt_eff_dt",formObj.ctrt_eff_dt.value,0);
                }else{
                	sheetObj.SetCellValue(idx, "ctrt_eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "ctrt_exp_dt",formObj.ctrt_exp_dt.value,0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "eff_dt",formObj.ctrt_eff_dt.value,0);
                }else{
                	sheetObj.SetCellValue(idx, "eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "exp_dt",formObj.ctrt_exp_dt.value,0);
                sheetObj.SetCellValue(idx, "pre_exp_dt",sheetObjects[0].GetCellValue(1, "pre_exp_dt"),0);
                sheetObj.SetCellValue(idx, "prop_scp_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
                sheetObj.SetCellValue(idx, "n1st_cmnc_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                //Setting default value as same Sales Rep with MAIN's SALE REP
                sheetObj.SetCellValue(idx, "prop_scp_srep_cd",prop_srep_cd.GetSelectText(),0);
                sheetButtonImageChange(sheetObj,idx, 0);//Deactivation
                //no support[check again]CLT sheetObj.PopupButtonImage(idx, "gline_cp_flg_lnk")=0;
                //Getting Main MQC value for first row
                if ( getAmendValidRowCount(sheetObj, formObj.amdt_seq.value) == 1){   
                	var v_prop_mqc_qty = formObj.prop_mqc_qty.value;
                	sheetObj.SetCellValue(idx, "prop_scp_mqc_qty",v_prop_mqc_qty,0);
                }
                if(formObj.amdt_seq.value!=0){
                	sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd", "#FF0000");
                }                 
                var preIbflag=sheetObjects[0].GetRowStatus(1);
                if (preIbflag == "R"){
                	sheetObjects[0].SetRowStatus(1,"U");
                }
                sheetObj.SelectCell(idx, "svc_scp_cd");
                break;
            case IBDELETE: // Delete
                if (validateForm(sheetObj,document.form,sAction)) {         
                    deleteRowCheck(sheetObj, "chk" ,true);  
                }       
                break;      
            case COMMAND06: // btn_cancel_file
//	        	ComOpenWait(true); //->waiting->start
//	        	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
//	        	var amdtSeq=formObj.amdt_seq.value;            	
//	            formObj.f_cmd.value=MULTI08;
//	            sheetObj.SetCellValue(1,"prop_sts_cd","A",0);
//	            var sParam="";           
//	            var sParamSheet1=sheetObjects[0].GetSaveString(true);
//	            if (sParamSheet1 != "") {
//	                sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
//	            }                        
//	            sParam += "&" + FormQueryString(formObj);
//	            var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
//	            sheetObjects[0].LoadSaveData(sXml);
//	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//	            ComOpenWait(false); //->waiting->End
            	
            	formObj.f_cmd.value=MULTI08;
 	            //Revert forcely
            	sheetObjects[0].SetCellValue(1,"prop_sts_cd","I",0);
 	            var sParam="";  
 	            var sParamSheet1=sheetObjects[0].GetSaveString(1);
 	            if (sParamSheet1 != "") {
 	                sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
 	            }
 	            var sParamSheet2=sheetObjects[1].GetSaveString(1);
 	            if (sParamSheet2 != "") {
 	                sParam +=  "&"+ComPriSetPrifix(sParamSheet2, "sheet2_");
 	            }
 	            sParam += "&f_cmd=" + MULTI08;
 	            var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
 	            sheetObjects[0].LoadSaveData(sXml);
 	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	            ComOpenWait(false); //->waiting->End
            	
            	
	            break;      
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == COMMAND10 || sAction == IBDELETE || sAction == IBINSERT
        			|| sAction == IBSEARCH_ASYNC01) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        case "sheet1":
            with (sheetObj) {            	
	            if (location.hostname != "")
	                var HeadTitle="|sc_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_dt|prc_prog_sts_cd|src_info_cd|pre_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt";
	                HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
	                HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm";
	                HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|sls_ld_no|blpl_hdr_seq";
	                HeadTitle += "|request user flag|approval user flag|all usr flag|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|ctrt_eff_dt_ori|ctrt_exp_dt_ori|oti_no";
	                HeadTitle += "|oti_eff_dt|oti_exp_dt|oti_amt|prop_prpr_flg|cretype|dur_dup_flg|cust_tp_ori"
	                HeadTitle += "|prop_apro_staff|act_cm|est_cm|ori_real_cust_cd|ori_real_cust_seq|conv_cfm_flg|n_conv_cfm_flg|lgcy_if_flg|oti_lic_no|oti_map|n1st_if_flg|upd_dt|prxy_flg|ctrt_dur_tp_cd"
	                var headCount=ComCountHeadTitle(HeadTitle);
	                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rf_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gamt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"file_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_val_sgm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_mqc_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"unit",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sls_ld_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"all_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_prpr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prop_cre_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dur_dup_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cust_tp_ori",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_staff",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prs_crnt_cm_amt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prs_estm_cm_amt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ori_real_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ori_real_cust_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"conv_cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n_conv_cfm_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"lgcy_if_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_lic_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_map",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_if_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prxy_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_dur_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	                 
	                InitColumns(cols);
	                SetWaitImageVisible(0);
	                SetVisible(false);
               }
            break;
        case "sheet2":
            with(sheetObj){	            
	          if (location.hostname != "")
	          var HeadTitle="|Sel.|Seq.|Prop No.|Amendment Seq|SVC Scope|Approval Office|Request Office|Request Office|MQC|MQC|MQC|Sales Rep|Duration|Duration|Duration|eff_dt"; //14
	          HeadTitle += "|exp_dt|n1st_cmnc_dt|pre_exp_dt|G/L Copy|Status|Note Header Seq|Status";
	          HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|dur_dup_flg|scpnm|PRE_EXT_SCP|";
	          var headCount=ComCountHeadTitle(HeadTitle);
	          (headCount, 0, 0, true);
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Combo", 	Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                 {Type:"Combo", 	Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_apro_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Int",       Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"prop_scp_mqc_qty",      KeyField:1,   CalcLogic:"",   Format:"Integer", 	   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_mqc_pop",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"scp_dur_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Popup",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"gline_cp_flg_lnk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:4 },
	                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"note_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Int",       Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_mqc_qty_ori",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dur_dup_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"scp_nm",                KeyField:0,   CaldcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pre_ext_scp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	           
	          InitColumns(cols);
	
	          SetEditable(1);
	          SetWaitImageVisible(0);
	          SetImageList(0,"img/btns_search_off.gif");
	          SetImageList(1,"img/btns_search.gif");
	          SetColProperty("prop_scp_ofc_cd", {AcceptKeys: "E", InputCaseSensitive:1} );
	          SetShowButtonImage(2);
	          SetSheetHeight(120);
          }
            break;      
        }
    }
     /**
     * registering IBTab Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
      * <br><b>Example :</b>
      * <pre>
      *     initTab(tabObj,1);
      * </pre>
      * @param {tabObj} tabObj Mandatory IBTab Object
      * @param {int} tabNo Mandatory IBTab Object ,Serial no for Tag's ID
      * @return N/A
      * @author 
      * @version 2009.04.17
      */     
    function initTab(tabObj, tabNo) {
        switch (tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0;
                InsertItem( "Ori/Dest", "");
                InsertItem( "LOC Group ", "");
                InsertItem( "CMDT Group ", "");
                InsertItem( "Arbitrary", "");
                InsertItem( "Rate", "");
                InsertItem( "Standard Note", "");
                InsertItem( "Special Note", "");
                InsertItem( "L/Agent", "");
                InsertItem( "IHC", "");
                InsertItem( "GOH", "");
                //no support[implemented common]CLT ShowIcon=true;
                //no support[check again]CLT UseLargeIcon=false;
                SetTabIcon(0,ICON_URL_NOT_EXIST);
                SetTabIcon(1,ICON_URL_NOT_EXIST);
                SetTabIcon(2,ICON_URL_NOT_EXIST);
                SetTabIcon(3,ICON_URL_NOT_EXIST);
                SetTabIcon(4,ICON_URL_NOT_EXIST);
                SetTabIcon(5,ICON_URL_NOT_EXIST);
                SetTabIcon(6,ICON_URL_NOT_EXIST);
                SetTabIcon(7,ICON_URL_NOT_EXIST);
                SetTabIcon(8,ICON_URL_NOT_EXIST);
                SetTabIcon(9,ICON_URL_NOT_EXIST);
            }
            break;
        }
    }
    /**
     * initializing Tab</b>
     * setting Tab items</b>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.04.17
     */        
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
            case "prop_srep_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                }
                break;
            case "prc_ctrt_cust_tp_cd":
                with(comboObj) {
                    SetDropHeight(86);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;     
            case "real_cust_tp_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;                     
            case "prop_apro_ofc_cd":
                with(comboObj) {
                    SetDropHeight(129);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;
            case "ctrt_cust_srep_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                }
                break;
            case "real_cust_srep_cd":
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                }
                break;       
            case "cntr_lod_ut_cd":
                with(comboObj) {
                    SetDropHeight(43);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
              //2015.07.23 ADD
            case "ctrt_dur_tp_cd":
                with(comboObj) {
                    SetDropHeight(80);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }
    /**
     * handling process for input validation<br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         handling logic;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2009.04.17
     */
    function validateForm(sheetObj, formObj, sAction) {
        var sc_no=formObj.sc_no.value;
        var prop_no=formObj.prop_no.value;
        var amdt_seq=formObj.amdt_seq.value;
        switch (sAction) {
        case IBSEARCH: 
        	if ((sc_no == "" && prop_no == "") || (sc_no == null && prop_no == null))  {
        		formObj.sc_no.readOnly=false;
            	formObj.prop_no.readOnly=false;
            	return false;
            }else{
            	formObj.sc_no.readOnly=true;
            	formObj.prop_no.readOnly=true;
            	return true;
            }
            break;
        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified()||sheetObjects[1].IsDataModified()){
                return ComPriClearChange;
            }
            break;
        case COMMAND02: // Request
        	if (formObj.prop_no.value ==""){
	            ComShowCodeMessage('PRI01021');
	            return false;
	        }               
	        var rValue="";
	        if (formObj.sc_no.value == "" && formObj.prop_no.value == "") {                	
	        	return false;
	        }
	        if (sheetObjects[1].RowCount()== 0){
	        	return false;
	        } 
            if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }
	        if (!ComShowCodeConfirm("PRI01032","Request")){                	
	        	return false;
	        }
	        //Checking all same for Main,Scope Duration Eff_dt,Exp_dt
	        var mainCtrtEffDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
	        var mainCtrtExpDt=ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd");
	        var scpCtrtEffDt="";
	        var scpCtrtExpDt="";
	        var ctrtDateMatch=false;  
	        for (var i = 1; i <= getValidRowCount(sheetObjects[1]); i++){
	        	scpCtrtEffDt=sheetObjects[1].GetCellValue(i, "ctrt_eff_dt");
	        	scpCtrtExpDt=sheetObjects[1].GetCellValue(i, "ctrt_exp_dt");
	        	if (mainCtrtEffDt == scpCtrtEffDt && mainCtrtExpDt == scpCtrtExpDt ){
	        		ctrtDateMatch=true;
	        		continue;
	        	}
	        }
	        //Showing message in case of no scope with same duration with main
	        if (!ctrtDateMatch){
	        	 ComShowCodeMessage("PRI01096");
	        }
	        if (comboObjects[2].GetSelectCode()== "N"
	        	&& formObj.oti_no.value == ""
	        	&& formObj.oti_lic_no.value == ""
	        	&& formObj.amdt_seq.value == "0"
	        		&& sheetObjects[0].GetCellValue(1, "oti_map") =="Y"){
	        	ComShowCodeMessage('PRI01076');
	        	return false;
	        }	
	        rValue=checkRequest();
	        if (rValue !="Y"){                	
	        	return false;
	        }
            /////////////////////////////////////////////////////////////////////
            // update date checking
            var checkSheetObj=sheetObjects[0];
            var checkTpCd="CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
        	break;
        case COMMAND03: // Counter Offer
        	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        	var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        	var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
            //Approval authority
            if (apro_usr_flg!="Y"){
                ComShowCodeMessage('PRI01033','C/Offer');
                return false;
            }
            // Checking whether all terms is accepted or returned
            var initCheck=checkCountOffer();
            if (initCheck !="Y"){
                ComShowCodeMessage('PRI01039');
                return false;
            }           
            if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }            
    	      //counter office in case of Request
	        if (prop_sts_cd !="Q" ){
	            ComShowCodeMessage('PRI01034');
	            return false;
	        }             
            if (!ComShowCodeConfirm("PRI01032","C/Offer")){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // Checking update date 
            var checkSheetObj=sheetObjects[0];
            var checkTpCd="CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;        
        case COMMAND04: // Approve
        	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        	var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        	var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
            //Approval authority
            if (apro_usr_flg=="N"){
                ComShowCodeMessage('PRI01033','Approve');
                return false;
            }           
            if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }            
            //Approval in case of Request
            if (prop_sts_cd !="Q"){
                ComShowCodeMessage('PRI01034');
                return false;
            }    
            if (!ComShowCodeConfirm("PRI01032","Approve")){
                return false;
            }
            //DEM/DET CHECK
	        if ( checkDmdtData() !="Y"){
	        	return false;
	        }	
            var rValue=checkAccept();            
            //Activating approve , deactivating C/Offer in case of all accept
            if (rValue != "Y"){
                ComShowCodeMessage('PRI01031');
                return false;
            } 
            /////////////////////////////////////////////////////////////////////
            // Checking update date
            var checkSheetObj=sheetObjects[0];
            var checkTpCd="CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;        
        case COMMAND05: // Cancel
	        /////////////////////////////////////////////////////////////////////
	        // Checking update date
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            break;
        case IBSAVE: // Save
            var formObj=document.form;        
        	//Checking Html Mandatory item
            if(!ComChkRequired(document.form)){
                return false;
            }
            //Checking combo Mandatory item
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','Sale Rep.'); 
                comboObjects[0].Focus();
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','Approval Office');   
                comboObjects[1].Focus();
                return false;
            }
            if (comboObjects[3].GetSelectCode()== "" || formObj.ctrt_cust_srep_nm.value == "") {
                ComShowCodeMessage('PRI00316','Customer S.Rep.');   
                comboObjects[3].Focus();
                return false;
            }           
            if (comboObjects[5].GetSelectCode()== "" && formObj.real_cust_srep_nm.value != "") {
                ComShowCodeMessage('PRI00316','Real Customer S.Rep.');   
                comboObjects[5].Focus();
                return false;
            }
            if (comboObjects[6].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','UNIT'); 
                comboObjects[6].Focus();
                return false;
            }
            
            //duration check
            var rowCnt = getValidRowCount(sheetObjects[1]); //PRI Common function to get row's count except deleted row
            var ctrtEffDt=sheetObjects[0].GetCellValue(1, "ctrt_eff_dt");//Main Duration
            var ctrtExpDt=sheetObjects[0].GetCellValue(1, "ctrt_exp_dt");
            var sheet2=sheetObjects[1];
            for (var i=1; i <= rowCnt; i++){
            	var effDt=ComGetUnMaskedValue(sheet2.GetCellValue(i, "ctrt_eff_dt"),"ymd");//Scope Duration
            	var expDt=ComGetUnMaskedValue(sheet2.GetCellValue(i, "ctrt_exp_dt"),"ymd");
            	if (effDt != "" && expDt != ""){
                	if (effDt < ctrtEffDt){
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"S/C");
                		sheet2.SelectCell(i, "ctrt_eff_dt");
                		return false;
                	}
                	if (expDt > ctrtExpDt){            		
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"S/C");
                		sheet2.SelectCell(i, "ctrt_exp_dt");
                		return false;
                	}
            	}
            }
            //no inputted Scope
            if (rowCnt <= 0){
                ComShowCodeMessage('PRI01029'); 
                return false;
            }
            //Nothing modified
            if(!sheetObjects[0].IsDataModified()&&!sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }
            // dup check
             var rowM=sheetObjects[1].ColValueDup("svc_scp_cd", false);
             if (rowM >= 0) {
                 ComShowCodeMessage("PRI00303", "Sheet", rowM);
                 return false;
            }
         	for( var i=1 ; i<=sheetObjects[1].RowCount(); i++){
         		if(sheetObjects[1].GetCellValue(i,"ibflag")=='I' || sheetObjects[1].GetCellValue(i,"ibflag")=='U'){	
 	        		if(sheetObjects[1].GetCellValue(i, "prop_scp_ofc_cd") != "" && sheetObjects[1].GetCellValue(i, "prop_scp_ofc_cd").length == 5){
 						if(sheetObjects[1].GetCellValue(i, "prop_scp_srep_cd")==null || sheetObjects[1].GetCellValue(i, "prop_scp_srep_cd")==""){
 							ComShowCodeMessage('COM130403', 'Service Scope Sales Rep');//key field missing
 		        			sheetObjects[1].SelectCell(i, "prop_scp_srep_cd");
 							return false;
 						}
 					}
 				}
 	        }
            //MQC chk : scope Mqc <= Main Mqc
            var mainMqc=ComReplaceStr(document.form.prop_mqc_qty.value,",","");
            var subMqc=0;//scope
            var sheetObj=sheetObjects[1];//scope
            for (var i=1; i <= sheetObj.RowCount(); i++){
            	subMqc += ComParseInt(sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori"));//Summary scope MQC before changing
                //Adding modified value to sub mqc or extracting modified value from sub mqc in case of changing scope Mqc
            	if (sheetObj.GetCellValue(i,"prop_scp_mqc_qty") != sheetObj.GetCellValue(i,"prop_scp_mqc_qty_ori")){
            		subMqc += ComParseInt(sheetObj.GetCellValue(i, "prop_scp_mqc_qty")) - ComParseInt(sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori"));
                }
            }
            if ((subMqc - mainMqc) > 0){
                 ComShowCodeMessage("PRI01008");                 
                 return false;
            }
            if(sc_no!="" && amdt_seq == "0" && prop_no == "" && sheetObjects[0].GetCellValue(1, "prop_sts_cd")=="I"){
            	ComShowCodeMessage("PRI01141");
            	formObj.sc_no.value = "";
            	sheetObjects[0].SetCellValue(1, "sc_no", "");
            }
	        /////////////////////////////////////////////////////////////////////
	        // checking update date
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            break;
        case IBSEARCH_ASYNC01: 
            return true;
            if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
                return false;
            }
            break;           
        case IBDELETE: // Delete
            var sCheckedRows=sheetObj.FindCheckedRow("chk");
            var arrCheckedRows=new Array();
            if (sCheckedRows== "") {
                arrCheckedRows.push(sheetObj.GetSelectRow());
            } else { 
                arrCheckedRows=sCheckedRows.split("|");
            }       
            var effDt=sheetObjects[0].GetCellValue(1,"eff_dt");
            var amdtSeq=sheetObjects[0].GetCellValue(1,"amdt_seq");
            //Can delete added scope at current amdt_seq
            if (amdtSeq != "0"){        
                for (var i=0; i < arrCheckedRows.length; i++){
                	if (effDt != sheetObj.GetCellValue(arrCheckedRows[i], "eff_dt")){
                        ComShowCodeMessage('PRI01036');
                        sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");//PRI01036
                        return false;
                    }                    
                }
            }
            var rValue="";
            for (var i=0; i< arrCheckedRows.length; i++){
                rValue=checkScopeDelete(arrCheckedRows[i]);
                //Can delete in case of no sub data of Scope
                if (rValue != "Y"){
                    ComShowCodeMessage('PRI01051');
                    sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");
                    return false;
                }
            }
            break;
        case IBCOPYROW: // Copy
            if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
                return false;
            }
//            if (formObj.cfm_flg.value != "No") {
//                return false;
//            }
            break;
        }
		return true;
    }           
     /**
      * Activating selected tab in case of cliking Tab <br>
      * <br><b>Example :</b>
      * <pre>
      *     tab1_OnChange(tabObj, tabIndex)
      * </pre>
      * @param {tabObj} tabObj Mandatory IBTab Object
      * @param {int} tabIndex Mandatory ,Process Flag constant variable
      * @return N/A
      * @author 
      * @version 2009.04.17
      */     
    function tab1_OnChange(tabObj, tabIndex) {
    	  if (!ihcTabSts && tabIndex ==8){//Return in case of deactivating IHC tab
    		  if (beforetab !=tabIndex){
    			  tabObj.SetSelectedIndex(beforetab);
    		  }    		  
    		  return;
    	  }
    	  var sNoteIdx=6;//Standard Note(Prohibiting from moving tab in case of not saving Dem/Det)
          if (beforetab == sNoteIdx ){        	  
    		  if (tabIndex !=sNoteIdx){
    			  returnValue=document.getElementById("t7frame").contentWindow.getDemDetSaveCheck();
    			  if (returnValue == "N"){
    				  tabObj.SetSelectedIndex(sNoteIdx);
            		  beforetab=sNoteIdx;
            		  return;
    			  }
    		  }        	 
          }    	  
    	  if (beforetab != tabIndex) {	  
    		  var objs=document.all.item("tabLayer");
    		  objs[tabIndex].style.display="inline";
    		  objs[beforetab].style.display="none";
    		  for (var i = 0; i < objs.length; i ++) {
				  if (i != tabIndex) {
					  objs[i].style.display = "none";
				      objs[i].style.zIndex=objs[tabIndex].style.zIndex -1 ;
				 }
			 }
         }
        beforetab=tabIndex;
        loadTabPage(tabIndex);
    }
      /**
       * Activating selected tab in case of cliking Tab<br>
       * <br><b>Example :</b>
       * <pre>
       *     tab1_OnClick(tabObj, tabIndex)
       * </pre>
       * @param {tabObj} tabObj Mandatory IBTab Object
       * @param {int} tabIndex Mandatory ,Process Flag constant variable
       * @return N/A
       * @author 
       * @version 2009.04.17
       */           
      function tab1_OnClick(tabObj,  tabIndex) {
     	  if (!ihcTabSts && tabIndex ==8){//Return in case of deactivating IHC tab
     		  tabObj.SetSelectedIndex(beforetab);
     		  return;
    	  }    	
    	   //Standard Note(Prohibiting from moving tab in case of not saving Dem/Det)
    	  if (beforetab == 6 && returnValue =="N"){
    		  tabObj.SetSelectedIndex(6);
    	  }
      }
     /**
     * Loading a screen to frame when changing Tab<br>
     * <br><b>Example :</b>
     * <pre>
     *     loadTabPage(tabIndex)
     * </pre>
     * @param {tabIndex} tabIndex Mandatory tab's serial no
     * @param {selRow} selected  Row
     * @return N/A
     * @author 
     * @version 2009.04.17
     */          
    function loadTabPage(tabIndex, selRow) {
        if (tabIndex == null || tabIndex == "") {
            tabIndex=tabObjects[0].GetSelectedIndex();
        }
       
        
        var objTabWindow=document.getElementById("t" + (ComParseInt(tabIndex) + 1)  + "frame").contentWindow;   
              
        if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
            var sUrl="";
            switch (tabIndex) {
            case 0:
                sUrl="ESM_PRI_0003_01.do"; //Ori/Dest - ok
                break;
            case 1:
                sUrl="ESM_PRI_0003_02.do"; // LOC Group - OK
                break;
            case 2:
                sUrl="ESM_PRI_0003_03.do";  //CMDT Group - ok
                break;
            case 3:
                sUrl="ESM_PRI_0003_04.do"; //Arbitrary - OK.
                break;
            case 4:
                sUrl="ESM_PRI_0003_08.do";  //Rate 나중에 하기로 함.
                break;
            case 5:
                sUrl="ESM_PRI_0003_09.do";  //Standard Note --- 값을 못만듬
                break;
            case 6:
                sUrl="ESM_PRI_0003_10.do"; //Special Note --- 값을 못만듬
                break;
            case 7:
                sUrl="ESM_PRI_0003_07.do"; //L/Agent - OK
                break;
            case 8:
                sUrl="ESM_PRI_0003_05.do";  //IHC - OK
                break;
            case 9:
                sUrl="ESM_PRI_0003_06.do";  //GOH - OK
                break;              
            }
            objTabWindow.location.href=sUrl;
            return true;
        }
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var sRow=sheetObj2.GetSelectRow();
        if (selRow != null && selRow != undefined){
        	sRow=selRow;
        }
        var sPropNo=sheetObj2.GetCellValue(sRow,"prop_no");
        var sAmdtSeq=sheetObj2.GetCellValue(sRow, "amdt_seq");
        var sSvcScpCd=sheetObj2.GetCellValue(sRow, "svc_scp_cd");
        var sPreAmdtSeq=sheetObj1.GetCellValue(1, "pre_amdt_seq");   //Amend시 사용
        var sPropStsCd=sheetObj1.GetCellValue(1, "prop_sts_cd");
        var sEffDt=sheetObj2.GetCellValue(sRow, "eff_dt");
        var sExpDt=sheetObj2.GetCellValue(sRow, "exp_dt");
        var sPreExpDt=sheetObj2.GetCellValue(sRow, "pre_exp_dt");
        var sIsReqUsr=sheetObj1.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
        var sIsAproUsr=sheetObj1.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
        var sDurDupFlg=sheetObj2.GetCellValue(sRow, "dur_dup_flg");
        var sLgcyIfFlg=sheetObj1.GetCellValue(1, "lgcy_if_flg");
        sLgcyIfFlg="N";
        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sPreAmdtSeq != null && sPreAmdtSeq != ""
        	&& sPropStsCd != null && sPropStsCd != "" && sEffDt != null && sEffDt != "" && sPreExpDt != null && sPreExpDt != "" && sheetObj2.GetCellValue(sRow, "ibflag")!="I") {
        	        	
        	if(objTabWindow != null && objTabWindow.tabLoadSheet  != null ){
        	 	objTabWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg);
        	}
        	
        }
    }
    /**
     * Clearing all data of sheet which is loaded on Tab<br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllTabPages()
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  
    function clearAllTabPages() {
        for (var i=0; i < tabObjects[0].GetCount(); i++) {
            tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
            if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
            }
        }
    }
    /**
    * Clearing inputted fields on screen and a value of IBMulti Combo Object <br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllForms()
    * </pre>
    * @param  N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  
    function clearAllForms(){
        var formObj=document.form;        
        formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.rf_flg.value="";
        formObj.gamt_flg.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        comboObjects[0].SetSelectIndex(-1);
        formObj.prop_srep_nm.value="";
        comboObjects[1].SetSelectIndex(-1);
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.file_dt.value="";
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        comboObjects[2].SetSelectIndex(-1);
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        comboObjects[3].SetSelectIndex(-1);//여기
        formObj.ctrt_cust_srep_nm.value="";
        formObj.oti_no.value="";
        formObj.oti_eff_dt.value="";
        formObj.oti_exp_dt.value="";
        formObj.oti_amt.value="";
        formObj.oti_lic_no.value="";
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        comboObjects[4].SetSelectIndex(-1);
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        comboObjects[5].SetSelectIndex(-1);
        formObj.real_cust_srep_nm.value="";
        formObj.prop_mqc_qty.value="";
        comboObjects[6].SetSelectIndex(-1);
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
        /*formObj.prop_pfmc.value="";
        formObj.prop_atmt.value="";*/
        /*formObj.prs_crnt_cm_amt.value="";
        formObj.prs_estm_cm_amt.value="";
        formObj.prs_sum_cm_amt.value="";*/
        formObj.sale_lead_ori.value="";
    }
   /**
    * Changing Sheet's popup button image<br>
    * <br><b>Example :</b>
    * <pre>
    *     sheetButtonImageChange()
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory ,Cell'sRow Index    
    * @return {int} <br>
    *          0 : Deactivation<br>
    *          1 : Activation
    * @author 
    * @version 2009.04.17
    */  
    function sheetButtonImageChange(sheetObj, Row, sw){
    //no support[check again]CLT 	sheetObj.PopupButtonImage(Row, "scp_dur_pop")=sw;
        //no support[check again]CLT sheetObj.PopupButtonImage(Row, "prop_scp_mqc_pop")=sw;
    }    
    /**
     * Control function to control button authority<br>
     * Activating,deactivating buttons according to status<br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @param   N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  
    function buttonControl(){
        var formObj=document.form;
        var sts=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        var reqUsrFlg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        var aproUsrFlg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
        var allUsrFlg=sheetObjects[0].GetCellValue(1, "all_usr_flg");
        var amdt_seq=sheetObjects[0].GetCellValue(1, "amdt_seq");
        var lgcyIfFlg=sheetObjects[0].GetCellValue(1, "lgcy_if_flg");
        lgcyIfFlg="N";
        var sheetObj=sheetObjects[1];        
        var scp_req_usr_flg=reqUsrFlg;
        var scp_apro_usr_flg=aproUsrFlg;
        var conAuth=true;
//        aproUsrFlg="Y"
        try{
            btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);
            ComBtnDisable("btn_ctrt_pty_pop");
            ComBtnDisable("btn_dur_pop");
            ComBtnDisable("btn_prop_mqc_pop"); 
            //document.getElementById("btn_ctrt_pty_pop").style.color="black";
            //document.getElementById("btn_prop_mqc_pop").style.color="black";
            //document.getElementById("btn_dur_pop").style.color="black";
            //document.getElementById("btn_blpl_pop").style.color="black";
            //document.getElementById("btn_afil_pop").style.color="black";            
            btnImgEnable(formObj.btn_ctrt_cust, false);
            btnImgEnable(formObj.btn_real_cust, false);
            btnImgEnable(formObj.btns_calendar1, false);
            btnImgEnable(formObj.btns_calendar2, false);    
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_save");  
            ComBtnDisable("btn_amend");         
            ComBtnDisable("btn_request");           
            ComBtnDisable("btn_coffer");            
            ComBtnDisable("btn_approve");           
            ComBtnDisable("btn_scnoassign");            
            ComBtnDisable("btn_file");            
            ComBtnDisable("btn_cancel");            
            ComBtnEnable("btn_copy");          
            ComBtnDisable("btn_print");    
            ComBtnDisable("btn_cancel_file"); 
            /*
            btnImgEnable("btn_mqc_estimate",false);
*/
           formObj.conv_cfm_flg.disabled=true;
            if (sts == "I"){
            	formObj.conv_cfm_flg.disabled=true;
            }else{
            	if (sheetObjects[0].GetCellValue(1, "n_conv_cfm_flg") == "Y" ||formObj.amdt_seq.value == "0" ){
            		if (sheetObjects[0].GetCellValue(1, "conv_cfm_flg") == "Y"){
                    	formObj.conv_cfm_flg.disabled=true
                    }else{        	
                    	if (conAuth){
                    		formObj.conv_cfm_flg.disabled=false;
                    	}
                    }            
                }else{        	
                	formObj.conv_cfm_flg.disabled=true;
                }
            }
            if ((reqUsrFlg =="Y" && sts=="Q") || aproUsrFlg =="Y"){
            	ComBtnEnable("btn_cancel");           	
            }
            ComBtnDisable("btn_rowadd");            
            ComBtnDisable("btn_delete");            
            formObj.prop_mqc_qty.readOnly=false;          
            formObj.ctrt_eff_dt.readOnly=false;
            formObj.ctrt_exp_dt.readOnly=false;           
            formObj.prop_ofc_cd.readOnly=true;
            formObj.cust_cnt_cd.readOnly=false;
            formObj.cust_seq.readOnly=false;            
            //real customer
            changeRealCustomerEditable(false);
            formObj.rf_flg.disabled=true;//reefer
            formObj.gamt_flg.disabled=true;//garment
            prop_srep_cd.SetEnable(false); //Proposal Sales Rep
            prop_apro_ofc_cd.SetEnable(false);//Approval Office
            ctrt_cust_srep_cd.SetEnable(false); //Contract Customer Sales Rep
            
            formObj.prxy_flg.disabled = true;
            ctrt_dur_tp_cd.SetEnable(false); //2015.07.23 ADD

            if(reqUsrFlg !="Y" && aproUsrFlg !="Y"){
                //all authority N/A...
                formObj.prop_mqc_qty.readOnly=true;          
                formObj.ctrt_eff_dt.readOnly=true;
                formObj.ctrt_exp_dt.readOnly=true;           
                formObj.cust_cnt_cd.readOnly=true;
                formObj.cust_seq.readOnly=true;
              	prc_ctrt_cust_tp_cd.SetEnable(false);
              	cntr_lod_ut_cd.SetEnable(false);                
                btnImgEnable(formObj.btn_ctrt_cust, false);
                btnImgEnable(formObj.btns_calendar1, false);
                btnImgEnable(formObj.btns_calendar2, false); 
                ComBtnDisable("btn_save");
                ComBtnDisable("btn_copy");
                if(amdt_seq != "0"){
                	 ComBtnEnable("btn_dur_pop");
                	 ComBtnEnable("btn_prop_mqc_pop");
                	 ComBtnEnable("btn_ctrt_pty_pop");
                	 btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                }
        		for (var i=1; i <= sheetObj.RowCount();i++){
    		        for (var j=2; j <= 22; j++){
    		            sheetObj.SetCellEditable(i,j,0);
    		        }

        		    sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",0);
        		    if (amdt_seq == "0"){
        		    	sheetObj.SetCellEditable(i, "scp_dur_pop",0);
        		    	sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",0);
        		    	sheetButtonImageChange(sheetObj,i, 0);// Deactivation
        		    }else{
        		    	sheetObj.SetCellEditable(i, "scp_dur_pop",1);
        		    	sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",1);
        		    	sheetButtonImageChange(sheetObj,i, 1);// activation
        		    }
        		}         		
               // return;
            }           
            for (var i=1; i <= sheetObj.RowCount(); i++){
                sheetButtonImageChange(sheetObj,i, 1);//activation
            }
            //mqc activation
            //ComBtnEnable("btn_prop_mqc_pop");
            switch(sts) {
                case 'I':   // Initial      
                	formObj.prxy_flg.disabled = false;
                	ctrt_dur_tp_cd.SetEnable(true);//2015.07.23 ADD
                    if(reqUsrFlg=="Y"||aproUsrFlg=="Y"){                        
                        if (formObj.prop_no.value !=""){
                            ComBtnEnable("btn_request");   
                            ComBtnEnable("btn_blpl_pop");           
                            ComBtnEnable("btn_afil_pop");
                            ComBtnEnable("btn_ctrt_pty_pop"); 
                            ComBtnEnable("btn_prop_mqc_pop");
                            ComBtnEnable("btn_cancel");
                            
                            /*btnImgEnable("btn_mqc_estimate",true);*/
                        }
                        ComBtnEnable("btn_rowadd");         
                        ComBtnEnable("btn_delete");
//                        ComBtnDisable("btn_prop_mqc_pop");
                        btnImgEnable(formObj.btn_ctrt_cust, true);
                        ComBtnEnable("btn_print");
                        if(amdt_seq == "0"){
                            btnImgEnable(formObj.btns_calendar1, true);
                            btnImgEnable(formObj.btns_calendar2, true);   
                            formObj.prop_mqc_qty.readOnly=false;
                            formObj.ctrt_eff_dt.readOnly=false;
                            formObj.ctrt_exp_dt.readOnly=false;
                            formObj.cust_cnt_cd.readOnly=false;
                            formObj.cust_seq.readOnly=false;
                            prc_ctrt_cust_tp_cd.SetEnable(true);
                            cntr_lod_ut_cd.SetEnable(true);
                        }else{           
                        	//duration
                            formObj.ctrt_eff_dt.readOnly=true;
                            formObj.ctrt_exp_dt.readOnly=true;
                            //customer
                            formObj.cust_cnt_cd.readOnly=true;
                            formObj.cust_seq.readOnly=true;
                            prc_ctrt_cust_tp_cd.SetEnable(false);
                            btnImgEnable(formObj.btn_ctrt_cust, false);
                            btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
//                            ComBtnEnable("btn_prop_mqc_pop");
                            ComBtnEnable("btn_dur_pop");
                            formObj.prop_mqc_qty.readOnly=true;
                            cntr_lod_ut_cd.SetEnable(false);
                        }
                    }
                    break;
                case 'Q':   // Requested
                	ComBtnEnable("btn_print");                
                	ComBtnEnable("btn_prop_mqc_pop");
                    if (amdt_seq =="0"){
                    	ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);
                    }else{
                        ComBtnEnable("btn_dur_pop");
//                        ComBtnEnable("btn_prop_mqc_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                    }
                    if(aproUsrFlg=="Y"){                        
                        var rValue=checkAccept();                        
                        //Activating approve , deactivating C/office in case of all accept
                        if (rValue == "Y"){
                            ComBtnEnable("btn_approve"); //(in case of terms is all accepted)-in case of clicking
                            ComBtnDisable("btn_coffer");    
                        }else{
                            ComBtnDisable("btn_approve");
                            ComBtnEnable("btn_coffer"); 
                        }                                             
                    }
                    formObj.ctrt_eff_dt.readOnly=true;    //duration
                    formObj.ctrt_exp_dt.readOnly=true;                    
                    //customer
                    formObj.cust_cnt_cd.readOnly=true;
                    formObj.cust_seq.readOnly=true;
                    prc_ctrt_cust_tp_cd.SetEnable(false);
                    btnImgEnable(formObj.btn_ctrt_cust, false);
                    ComBtnEnable("btn_ctrt_pty_pop");
                    formObj.prop_mqc_qty.readOnly=true;
                    cntr_lod_ut_cd.SetEnable(false);
                    break;
                case 'R':   // Returned
                	ComBtnEnable("btn_prop_mqc_pop");
                    if (amdt_seq =="0"){
                    	ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);
                    }else{ 
                        ComBtnEnable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                        ComBtnEnable("btn_print");
                    }
                    /*if(reqUsrFlg=="Y" ){   
                    	btnImgEnable("btn_mqc_estimate",true);
                    }*/
                    //duration
                    formObj.ctrt_eff_dt.readOnly=true;
                    formObj.ctrt_exp_dt.readOnly=true;                    
                    //customer
                    formObj.cust_cnt_cd.readOnly=true;
                    formObj.cust_seq.readOnly=true;
                    prc_ctrt_cust_tp_cd.SetEnable(false);
                    btnImgEnable(formObj.btn_ctrt_cust, false);                     
                    ComBtnEnable("btn_ctrt_pty_pop");
                    formObj.prop_mqc_qty.readOnly=true;
                    cntr_lod_ut_cd.SetEnable(false);
                case 'A':   // Approved
                	ComBtnEnable("btn_print");
                	ComBtnEnable("btn_prop_mqc_pop");
                    if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);                    
                    }else{
                        ComBtnEnable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                    }
                    if(allUsrFlg=="Y"){
                        if (amdt_seq == "0"){ //Activating File button in case of assign
                            if (formObj.sc_no.value ==""){
                                ComBtnDisable("btn_file");
                            }else{
                                ComBtnEnable("btn_file");
                            }                
                        	ComBtnEnable("btn_scnoassign");                        
                        }else{
                            ComBtnEnable("btn_file");   
                        }                         
                    }
                    //duration
                    formObj.ctrt_eff_dt.readOnly=true;
                    formObj.ctrt_exp_dt.readOnly=true;
                    //customer
                    formObj.cust_cnt_cd.readOnly=true;
                    formObj.cust_seq.readOnly=true;
                    prc_ctrt_cust_tp_cd.SetEnable(false);
                    ComBtnEnable("btn_ctrt_pty_pop");
                    btnImgEnable(formObj.btn_ctrt_cust, false);     
                    formObj.prop_mqc_qty.readOnly=true;
                    cntr_lod_ut_cd.SetEnable(false);
                    break;
                case 'F':   // Filed
                	ComBtnDisable("btn_cancel");
                    ComBtnEnable("btn_amend");
                    ComBtnEnable("btn_print");
                    ComBtnEnable("btn_cancel");
                    ComBtnEnable("btn_prop_mqc_pop");
                	if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);     
                    }else{      
                        ComBtnEnable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true); 
                    }
                	if(IS_SUPER_USER == true && lgcyIfFlg == "N" ){                		
                		ComBtnEnable("btn_cancel_file");                		
                	}
                    //duration
                    formObj.ctrt_eff_dt.readOnly=true;
                    formObj.ctrt_exp_dt.readOnly=true;
                    //customer
                    formObj.cust_cnt_cd.readOnly=true;
                    formObj.cust_seq.readOnly=true;
                    prc_ctrt_cust_tp_cd.SetEnable(false);
                    ComBtnEnable("btn_ctrt_pty_pop");
                    btnImgEnable(formObj.btn_ctrt_cust, false);                     
                    formObj.prop_mqc_qty.readOnly=true;
                    cntr_lod_ut_cd.SetEnable(false);
                    break;                    
            }
            otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
            sheetControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
    * Activating or deactivating Html tag object ,IBMultiCombo according to main status<br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
    * </pre>
    * @param   {string} sts Mandatory          main status
    * @param   {string} amdt_seq Mandatory     amend seq Number
    * @param   {string} reqUsrFlg Mandatory  ,authority for screen <br>
    *                   Y : Autority
    *                   N : No authority
    * @param   {string} aproUsrFlg Mandatory  ,authority for approval  <br>
    *                   Y : Autority
    *                   N : No authority
    * @return N/A
    * @author 
    * @version 2009.04.17
    */      
    function otherFormControl(sts,amdtSeq,reqUsrFlg,aproUsrFlg){
        var formObj=document.form;
        var tpCd=prc_ctrt_cust_tp_cd.GetSelectCode();
    	if (aproUsrFlg == "Y"){
        	formObj.prop_ofc_cd.readOnly=false;
        	prop_apro_ofc_cd.SetEnable(true);
        	prop_srep_cd.SetEnable(true);
        	ctrt_cust_srep_cd.SetEnable(true);
        	cntr_lod_ut_cd.SetEnable(true);
        	ctrt_dur_tp_cd.SetEnable(true);
        	formObj.rf_flg.disabled=false;//reefer
    		formObj.gamt_flg.disabled=false;//garment
        }else{
        	formObj.prop_ofc_cd.readOnly=true;
        	prop_apro_ofc_cd.SetEnable(false);
        	prop_srep_cd.SetEnable(false);
        	ctrt_cust_srep_cd.SetEnable(false);
        	cntr_lod_ut_cd.SetEnable(false);
        	ctrt_dur_tp_cd.SetEnable(false);
        	formObj.rf_flg.disabled=true;//reefer
    		formObj.gamt_flg.disabled=true;//garment
        }
    	switch (sts){
	    	case "I":
	    		if (aproUsrFlg == "Y" || reqUsrFlg == "Y"){
	            	prop_apro_ofc_cd.SetEnable(true);
	            	prop_srep_cd.SetEnable(true);
	            	ctrt_cust_srep_cd.SetEnable(true);
	            	cntr_lod_ut_cd.SetEnable(true);
	            	ctrt_dur_tp_cd.SetEnable(true);
	            	if (tpCd =="N"){
						changeRealCustomerEditable(true); //Real Customer
					}
	            	if(amdtSeq == "0"){
	            		formObj.rf_flg.disabled=false;//reefer
	            		formObj.gamt_flg.disabled=false;//garment
	            	}else{
	            		formObj.rf_flg.disabled=true;//reefer
	            		formObj.gamt_flg.disabled=true;//garment
	            	}
	            }
	    		break;
	    	case "Q":
	    		formObj.prop_ofc_cd.readOnly=true;
	        	cntr_lod_ut_cd.SetEnable(false);
	        	ctrt_dur_tp_cd.SetEnable(false);
	    		break;
	    	case "R":
	    		formObj.prop_ofc_cd.readOnly=true;
	        	cntr_lod_ut_cd.SetEnable(false);
	        	ctrt_dur_tp_cd.SetEnable(false);
	    		break;
	    	case "A":
	    		formObj.prop_ofc_cd.readOnly=true;
	        	cntr_lod_ut_cd.SetEnable(false);
	        	ctrt_dur_tp_cd.SetEnable(false);
	    		break;
	    	case "F":
	    		formObj.prop_ofc_cd.readOnly=true;
	        	cntr_lod_ut_cd.SetEnable(false);
	        	ctrt_dur_tp_cd.SetEnable(false);
	    		break;
    	}
    }
    /**
    * ctivating or deactivating IBSheet's Cell according to main status <br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
    * </pre>
    * @param   {string} sts Mandatory        main status
    * @param   {string} amdtSeq Mandatory    amend seq Number
    * @param   {string} reqUsrFlg Mandatory  Authority for writing<br>
    *                   Y : Autority
    *                   N : No authority
    * @param   {string} aproUsrFlg Mandatory Authority for approval <br>
    *                   Y : Autority
    *                   N : No authority
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function sheetControl(stsCd,amdtSeq,reqUsrFlg,aproUsrFlg){
    	var sheetObj=sheetObjects[1];
    	for(var i=1; i<=sheetObj.LastRow(); i++){
    		for (var j=2; j <=sheetObj.LastCol(); j++){
                sheetObj.SetCellEditable(i,j,0);
            }
    	}
    	
    	if (stsCd == "I"){
    		for (var i=1; i <= sheetObj.RowCount();i++){
	              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
	                  sheetObj.SetCellEditable(i,"prop_scp_mqc_qty",1);
	                  sheetObj.SetCellEditable(i,"cntr_lod_ut_cd",1);
	                  sheetObj.SetCellEditable(i,"ctrt_eff_dt",1);
	                  sheetObj.SetCellEditable(i,"ctrt_exp_dt",1);
	                  sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_apro_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",1);
	              }
	          }
    		if(amdtSeq == "0"){
    			for (var i=1; i <= sheetObj.RowCount();i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
		                  sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",0);
		                  sheetObj.SetCellEditable(i, "scp_dur_pop",0);
		                  sheetObj.SetCellEditable(i,"ctrt_eff_dt",1);
		                  sheetObj.SetCellEditable(i,"ctrt_exp_dt",1);
		              }
		          }
    		}else{
		          for (var i=1; i <= sheetObj.RowCount();i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
		            	  sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",1);
		            	  sheetObj.SetCellEditable(i, "scp_dur_pop",1);
		            	  sheetObj.SetCellEditable(i,"ctrt_eff_dt",0);
		            	  sheetObj.SetCellEditable(i,"ctrt_exp_dt",0);
		            	  if(sheetObj.GetCellValue(i,"ctrt_eff_dt") == sheetObjects[0].GetCellValue(1,"eff_dt")){
		                	  sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",1);
		                  }else{
		                	  sheetObj.SetCellEditable(i, "ctrt_exp_dt",0);
		                	  sheetObj.SetCellEditable(i, "prop_scp_mqc_qty",0);
		                	  sheetObj.SetCellEditable(i, "cntr_lod_ut_cd",0);
		                  }
		              }
		          }
	        }
    	}else if (stsCd == "F"){
    		for (var i=1; i <= sheetObj.RowCount();i++){
    			for (var j=2; j <=sheetObj.LastCol(); j++){
    				sheetObj.SetCellEditable(i,j,0);
    			}
    			if(aproUsrFlg == "Y"){
    				sheetObj.SetCellEditable(i, "prop_scp_apro_ofc_cd",1);
    				sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
    				sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
    				sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
    			}
		        if (amdtSeq == "0"){
			        sheetObj.SetCellEditable(i,"scp_dur_pop",0);
			        sheetObj.SetCellEditable(i,"prop_scp_mqc_pop",0);
			        sheetButtonImageChange(sheetObj,i, 0);
		        }else{
			        sheetObj.SetCellEditable(i,"scp_dur_pop",1);
			        sheetObj.SetCellEditable(i,"prop_scp_mqc_pop",1);
		        }
    		    sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",0);
    		}
    	}else{
    		for (var i=1; i <= sheetObj.RowCount();i++){
    		    if (amdtSeq != "0"){
    		        sheetObj.SetCellEditable(i, "prop_scp_mqc_pop",1);
    		        sheetObj.SetCellEditable(i, "scp_dur_pop",1);
    		        sheetButtonImageChange(sheetObj,i, 0);
    		    }else{
    		        sheetObj.SetCellEditable(i, "prop_scp_mqc_pop", 0);
    		        sheetObj.SetCellEditable(i, "scp_dur_pop", 0);
    		        sheetButtonImageChange(sheetObj,i, 0);
    		    }
    		    if (aproUsrFlg == "Y"){
	                  sheetObj.SetCellEditable(i, "prop_scp_apro_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
	              }
    		}
    	}
    }                            
    /**
    * Modifying summary table accorting to added data and modification of each terms in main and scope<br>
    * <br><b>Example :</b>
    * <pre>
    *    comUpdateProposalStatusSummary(termTpCd, svcScpCd);
    * </pre>
    * @param   {string} termTpCd Mandatory   Defined code of Terms
    * @param   {string} svcScpCd Mandatory   Scope's cde
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function comUpdateProposalStatusSummary(termTpCd, svcScpCd){
        var sParam="";
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        try{
        	ComOpenWait(true); //->waiting->start 
            //Changing Main's status
            changeMainStatus();
            if(svcScpCd != undefined && svcScpCd != ""){
            	comApplyStyleProposalStatusSummary(svcScpCd);
                scopeStatusChange(svcScpCd) //modifying scope status
            }
            ComOpenWait(false); //->waiting->End
            buttonControl();        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	ComOpenWait(false); //->waiting->End
        }        
    }
 /**
  * Modifying Tab's icon accorting to added data and modification of each terms in main and scope<br>
  * <br><b>Example :</b>
  * <pre>
  *    comApplyStyleProposalStatusSummary( svcScpCd);
  * </pre>
  * @param   {string} svcScpCd selection   Scope code
  * @return N/A
  * @author 
  * @version 2009.04.17
  */ 
 function comApplyStyleProposalStatusSummary(svcScpCd){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
     formObj.f_cmd.value=SEARCH04;
     var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
     sParam += "&" + FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd;     
     var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0003GS.do", sParam);
     var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
     var icon="";
     var tabIdx="";
     var imgName="";
     var lgcyIfFlg=sheetObjects[0].GetCellValue(1, "lgcy_if_flg");
     lgcyIfFlg="N";
     for (i=0; arrText != null && i < arrText.length; i++){
    	 imgName="";
    	 tabIdx="";
    	 switch(arrText[i][0]){
	     	case '01':  //Duration,Scope Duration
	         	imgName="img_dur";
	             break;
	        case '02':  //MQC,Scope MQC
		         imgName="img_mqc";
	             break;  
	        case '04':  //contract party
	         	imgName="img_ctrt";
	         	break;  	             
	        case '05':
	        	 imgName="img_affil";
	        	 break;
	        case '06':
	        	 imgName="img_blpl";
	        	 break;	           
	        case '07':
	        	 imgName="img_ctrt_tpy";
	        	 break;	     	        	 
	        case '13':  //Group Location
	             tabIdx="1";
	             break;	               
	        case '14':  //Group Commodity
	             tabIdx="2";                 
	             break;	               
	        case '15':  //Loading Agent
	             tabIdx="7";
	             break;	               
	        case '31':  //Standard Note
	             tabIdx="5";                 
	             break;	           
	        case '32':  //Special Note
	             tabIdx="6";
	             break;	               
	        case '42':                
	             tabIdx="0";                     
	             break;	               
	        case '52':            
	             tabIdx="3";
	             break;	               
	        case '62':                 
	             tabIdx="8";
	             break;	               
	        case '16':  //GOH Charge
	             tabIdx="9";
	             break;	               
	        case '72':
                 tabIdx="4";
	             break;  
    	 }
    	 icon=ICON_URL_NOT_EXIST;
    	 switch(arrText[i][1]){
        	 case "1":
        		 icon=ICON_URL_EXIST;
        		 break;
        	 case "2":
        		 if (lgcyIfFlg == "Y"){
        			 icon=ICON_URL_EXIST;
        		 }else{
        			 icon=ICON_URL_AMEND;
        		 }        		 
        		 break;
        	 case "3":
        		 if (lgcyIfFlg == "Y"){
        			 icon=ICON_URL_EXIST;
        		 }else{
        			 icon=ICON_URL_ACCEPT;
        		 }        		 
        		 break;
    	 }
         // Default : Black , In case of Amend : Red, In case of All Accept : Blue
         if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "04"
        	 ||arrText[i][0] == "05"||arrText[i][0] == "06" ||arrText[i][0] == "07"){
       		 if (imgName !="") {
//        			var butObj = document.getElementById(imgName);
//        			$("#"+imgName+" .btn_img").remove();
//        			 $(butObj).prepend("<img class='btn_img'  src='"+icon+"'>");
       			 eval("document.form."+imgName+".src='"+icon+"'");
        		 }
         }else{
             if (tabIdx != ""){
            	 tabObjects[0].SetTabIcon(tabIdx,icon);
             }        	  
         }
     }        
 }    
/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////   
//  comb    (S)   -----   
 /**
  * event in case of changing selected item of IBMulti Combo<br>
  * Applying modified item to sheet by com_change_sheet() function <br>
  * <br><b>Example :</b>
  * <pre>
  *    prop_apro_ofc_cd_OnChange(comboObj, code, text);
  * </pre>
  * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
  * @param   {string} code Mandatory code
  * @param   {string} text ,character on screen
  * @return N/A
  * @author 
  * @version 2009.04.17
  */ 
    function prop_apro_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "prop_apro_ofc_cd" )
    }   
    /**
     * event in case of changing selected item of IBMulti Combo.<br>
     * Applying modified item to sheet by com_change_sheet() function <br>
     * <br><b>Example :</b>
     * <pre>
     *    prop_srep_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param   {string} code Mandatory code
     * @param   {string} text character on screen
     * @return N/A
     * @author 
     * @version 2009.04.17
     */     
    
    function prop_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=newText.split("|");
    	if (arrText != null && arrText.length > 0) {
    		formObj.prop_srep_nm.value=comboObj.GetText(newCode, 1);
    	}
        com_change_sheet( sheetObj, "prop_srep_cd" );
    }   
    /**
    * event in case of changing selected item of IBMulti Combo.<br>
    *  Applying modified item to sheet by com_change_sheet() function . <br>
    * <br><b>Example :</b>
    * <pre>
    *    ctrt_cust_srep_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text ,Character on screen
    * @return N/A
    * @author 
    * @version 2009.04.17
    */    
    function ctrt_cust_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=oldText.split("|");

        var newRowIdx = parseInt(newIndex);
        if (comboObj.GetText(newRowIdx, 1) != null && comboObj.GetText(newRowIdx, 1) != undefined){
            formObj.ctrt_cust_srep_nm.value=comboObj.GetText(newRowIdx, 1); //arrText[1];
            formObj.ctrt_cust_sls_ofc_cd.value=comboObj.GetText(newRowIdx, 2); //arrText[2];
        }else{
        	formObj.ctrt_cust_srep_nm.value="";
        	formObj.ctrt_cust_sls_ofc_cd.value="";    
        }
        //sale lead
//        setSaleLeadCombo(true);   
        sheetObj.SetCellValue(1, "sls_ld_no","");
        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
        //com_change_sheet( sheetObj, "ctrt_cust_sls_ofc_cd" );
    }    
//    function ctrt_cust_srep_cd_OnChange(comboObj, code, text) {
//        var formObj = document.form;
//        var sheetObj = sheetObjects[0];
//        var arrText = text.split("|");
//        if (arrText[1] != null && arrText[1] != undefined){
//            formObj.ctrt_cust_srep_nm.value = arrText[1];
//        }
//        
//        if (code != ""){
//        	formObj.ctrt_cust_sls_ofc_cd.value = getOfficeCd(code); 
//        }else{
//        	formObj.ctrt_cust_srep_nm.value = "";
//        }        
//        //sale lead
//        setSaleLeadCombo(true);   
//        sheetObj.CellValue(1, "sls_ld_no")= "";     
//        
//        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
//    }
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * Setting Combo's text value to Html object<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  
     function ctrt_cust_srep_cd_OnBlur(comboObj) {
   		var formObj=document.form;		
   		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
   		var sheetObj=sheetObjects[0];
   		var ofc=comboObj.GetText(comboObj.GetSelectCode(),2);
   		if (code != null && code != "") {
   			var text=comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
   				formObj.ctrt_cust_srep_nm.value=comboObj.GetText(code, 1);
   				formObj.ctrt_cust_sls_ofc_cd.value=ofc;
   			}
   		}  		
		if (code == -1){
			formObj.ctrt_cust_srep_nm.value="";
		}   		
   	}      
//    function ctrt_cust_srep_cd_OnBlur(comboObj) {
//  		var formObj = document.form;		
//  		var code = comboObj.FindIndex(comboObj.Code, 0);
//  		if (code != null && code != "") {
//  			var text = comboObj.GetText(code, 1);
//  			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
//  				formObj.ctrt_cust_srep_nm.value = comboObj.GetText(code, 1);
//  			}
//  		}  		
//  	}     
    /**
    * event in case of changing selected item of IBMulti Combo.<br>
    *  Applying modified item to sheet by com_change_sheet() function . <br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_srep_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text charater on screen
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 
    function real_cust_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=oldText.split("|");  
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.real_cust_srep_nm.value=arrText[1];
            formObj.real_cust_sls_ofc_cd.value=arrText[2];
        }else{
        	formObj.real_cust_srep_nm.value="";
        	formObj.real_cust_sls_ofc_cd.value=""; 
        }
        //sale lead
//        setSaleLeadCombo(true); 
        sheetObj.SetCellValue(1, "sls_ld_no","");
        com_change_sheet( sheetObj, "real_cust_srep_cd" );
        com_change_sheet( sheetObj, "real_cust_sls_ofc_cd" );
    }
//    function real_cust_srep_cd_OnChange(comboObj, code, text) {
//        var formObj = document.form;
//        var sheetObj = sheetObjects[0];
//        var arrText = text.split("|");  
//        if (arrText[1] != null && arrText[1] != undefined){
//            formObj.real_cust_srep_nm.value = arrText[1];
//        }       
//        if (code != ""){
//            formObj.real_cust_sls_ofc_cd.value = getOfficeCd(code);
//        }else{
//        	formObj.real_cust_srep_nm.value = "";
//        }
//        //sale lead
//        setSaleLeadCombo(true); 
//        sheetObj.CellValue(1, "sls_ld_no")= ""; 
//        com_change_sheet( sheetObj, "real_cust_srep_cd" )       
//    }   
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * Setting Combo's text value to Html object<br>
     * <br><b>Example :</b>
     * <pre>
     *   
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  
     function real_cust_srep_cd_OnBlur(comboObj) {
   		var formObj=document.form;		
   		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
   		var sheetObj=sheetObjects[0];
   		var ofc=comboObj.GetText(comboObj.GetSelectCode(),2);
   		if (code != null && code != "") {
   			var text=comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.real_cust_srep_nm.value) {
   				formObj.real_cust_srep_nm.value=comboObj.GetText(code, 1);
   				formObj.real_cust_sls_ofc_cd.value=ofc;
   			}
   		}
		if (code == -1){
			formObj.real_cust_srep_nm.value="";
		}   		
   	}      
//    function real_cust_srep_cd_OnBlur(comboObj) {
//  		var formObj = document.form;		
//  		var code = comboObj.FindIndex(comboObj.Code, 0);
//  		var sheetObj = sheetObjects[0];
//  		if (code != null && code != "") {
//  			var text = comboObj.GetText(code, 1);
//  			if (text != null && text != "" && text != formObj.real_cust_srep_nm.value) {
//  				formObj.real_cust_srep_nm.value = comboObj.GetText(code, 1);
//
//  			}
//  		}
//  	}    
    /**
    * event in case of changing selected item of IBMulti Combo.<br>
    *  Applying modified item to sheet by com_change_sheet() function . <br>
    * <br><b>Example :</b>
    * <pre>
    *    prc_ctrt_cust_tp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text Mandatory ,Character on screen
    * @return N/A
    * @author 
    * @version 2009.04.17
    */     
    function prc_ctrt_cust_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var amdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
        var aproUsrFlg=sheetObj.GetCellValue(1, "apro_usr_flg");
        var reqUsrFlg=sheetObj.GetCellValue(1, "req_usr_flg");
        var sw=false;
        if (formObj.cust_cnt_cd.value =="" && formObj.cust_seq.value == ""){
        	return;
        }
        if (newCode == "N"){        	
        	if (sheetObj.GetCellValue(1, "prop_sts_cd") == "I"){
        		sw=true;
        		if (amdtSeq == "0"){
        			if (reqUsrFlg == "Y" || aproUsrFlg =="Y"){
        				sw=true;
        			}        			
        		}else{
        			if (aproUsrFlg =="Y"){
        				sw=true;	
        			}
        		}
        	}
        }else{
        	if (formObj.real_cust_cnt_cd.value !="" && formObj.real_cust_seq.value != "" 
        		&& formObj.prop_no.value != "" && amdtSeq !="0"){
        		ComShowCodeMessage("PRI01079");
        		comboObjects[2].SetSelectText("N",false);
        		return;
        	}
        }
        changeRealCustomerEditable(sw);
        com_change_sheet( sheetObj, "prc_ctrt_cust_tp_cd" )     
        //In case of modifying Customer Type
        if (amdtSeq =="0" && checkCustomerType() == 'Y'){
        	ComShowCodeMessage('PRI01111');
        }
    }
    /**
    * event in case of changing selected item of IBMulti Combo.<br>
    *  Applying modified item to sheet by com_change_sheet() function . <br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_tp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text Mandatory ,Character on screen
    * @return N/A
    * @author 
    * @version 2009.04.17
    */     
    function real_cust_tp_cd_OnChange(comboObj, oldindex , oldtext , oldcode,  newindex , text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "real_cust_tp_cd" )     
    }   
    /**
    * event in case of changing selected item of IBMulti Combo.<br>
    *  Applying modified item to sheet by com_change_sheet() function . <br>
    * <br><b>Example :</b>
    * <pre>
    *    cntr_lod_ut_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text Mandatory ,Character on screen
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 
    function cntr_lod_ut_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "cntr_lod_ut_cd" )      
    } 
    
    /**
     * event in case of changing selected item of IBMulti Combo.<br>
     *  Applying modified item to sheet by com_change_sheet() function . <br>
     * <br><b>Example :</b>
     * <pre>
     *    ctrt_dur_tp_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param   {string} code Mandatory code
     * @param   {string} text Mandatory ,Character on screen
     * @return N/A
     * @author 
     * @version 2015.07.23
     */ 
     function ctrt_dur_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         com_change_sheet( sheetObj, "ctrt_dur_tp_cd" )      
     } 
    /**
    * event in case of pressing KeyBoard in IBMulti Comb<br>
    * changing focus to next object in case of exceeding designated length<br>
    * <br><b>Example :</b>
    * <pre>
    *    prc_ctrt_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory 아스키 code값
    * @param   {string} Shift   Displaying whether Mandatory shift is keyup
    * @return N/A
    * @author 
    * @version 2009.04.17
    */         
	function prc_ctrt_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var tpCd=comboObj.GetSelectText();
		if (tpCd.length > 1) {
			ctrt_cust_srep_cd.focus();
		}
	}
    /**
    * event in case of pressing KeyBoard in IBMulti Comb<br>
    * changing focus to next object in case of exceeding designated length<br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory ASC code value
    * @param   {string} Shift    Displaying whether Mandatory shift is keyup
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
	function real_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var tpCd=comboObj.GetSelectText();
		if (tpCd.length > 1) {
			document.form.real_cust_val_sgm.focus();
		}
	}
//    combo (E)   -----
    /**
    * Event in case of modifying Reefer Check Box Object's Check value<br>
    * Applying modified value to hidden sheet when modifying value<br>
    * Modifying N in case of unchecking Y when checking value<br>
    * <br><b>Example :</b>
    * <pre>
    *    rf_flg_OnChange();
    * </pre>
    * @param  N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  
    function rf_flg_OnChange(){
        var sheetObj=sheetObjects[0]; 
        sheetObj.SetCellValue(1,"rf_flg",document.form.rf_flg.checked == 1 ? "Y" : "N",0);
    }
    /**
     * Event in case of modifying Garment Check Box Object's Check value<br>
    * Applying modified value to hidden sheet when modifying value<br>
    * Modifying N in case of unchecking Y when checking value<br>
     * <br><b>Example :</b>
     * <pre>
     *    rf_flg_OnChange();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  
    function gamt_flg_OnChange(){
        var sheetObj=sheetObjects[0]; 
        sheetObj.SetCellValue(1,"gamt_flg",document.form.gamt_flg.checked == 1 ? "Y" : "N",0);
    }
    /**
    *  Event in case of modifying Html Object's Check value.<br>
    *  Saving values by using hidden sheet<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {string} colNm Mandatory Html Object의 name
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  
    function com_change_sheet( sheetObj, colNm ){
        var eleValue="";
        if( document.getElementById(colNm) != null &&/* event.srcElement.type */ document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "ctrt_eff_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;
                case "ctrt_exp_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "cre_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "file_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;  
                case "n1st_cmnc_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;                  
                case "cust_seq":
                    if (document.getElementById(colNm).value != ""){
                    	eleValue=ComParseInt(document.getElementById(colNm).value);
                    }else{
                    	eleValue=document.getElementById(colNm).value;
                    }                	
                    break;
                case "real_cust_seq":
                    if (document.getElementById(colNm).value != ""){
                    	eleValue=ComParseInt(document.getElementById(colNm).value);
                    }else{
                    	eleValue=document.getElementById(colNm).value;
                    } 
                    break;  
                default:
                    eleValue=document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.SetCellValue(1, colNm, eleValue);
        }else{
            sheetObj.SetCellValue(1, colNm, eval(colNm+".GetSelectCode()"));
        }
//        alert("colnm="+colNm+"  elevalue="+eleValue+"  cheeto="+sheetObj.CellValue(1, colNm)+" ibflag="+sheetObj.RowStatus(1))
    }
//    form   (E)   -----
//    sheet   (S)   -----
    /**
    * Calling function in case of OnChange event <br>
    * Modifying Effective,Expire Date of main in case of Amend Seq.=0 and modifying Main Duration<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  
    function sheet1_OnChange(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "ctrt_eff_dt":
            	if (sheetObj.GetCellValue(Row,"amdt_seq") == "0"){
            		sheetObj.SetCellValue(Row, "eff_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
            		sheetObj.SetCellValue(Row, "n1st_cmnc_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
                }                
                break;                
            case "ctrt_exp_dt":
            	if (sheetObj.GetCellValue(Row,"amdt_seq") == "0"){
            		sheetObj.SetCellValue(Row, "exp_dt",sheetObj.GetCellValue(Row, "ctrt_exp_dt"),0);
                }                   
                break;
        }
    }  
    /**
    * Calling function in case of OnChange event <br>
    * handling validation in case of modifying Scope Duration,Request Office,Scope<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  
    function sheet2_OnChange(sheetObj, Row, Col)
    {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "ctrt_eff_dt":                
                var mnEffDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd","-");
                if (mnEffDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.SetCellValue(Row,"ctrt_eff_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                    return;
                }
                if (mnEffDt > sheetObj.GetCellValue(Row,"ctrt_eff_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_eff_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                }else{
                	sheetObj.SetCellValue(Row, "eff_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
                    //In case of Proposal
                	sheetObj.SetCellValue(Row, "n1st_cmnc_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
                }
                break;
            case "ctrt_exp_dt":
                var mnExpDt=ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd","-");
                if (mnExpDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                if (mnExpDt < sheetObj.GetCellValue(Row,"ctrt_exp_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;                     
                }
                if (sheetObj.GetCellValue(Row, "ctrt_eff_dt") > sheetObj.GetCellValue(Row, "ctrt_exp_dt") ){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                sheetObj.SetCellValue(Row, "exp_dt",sheetObj.GetCellValue(Row, "ctrt_exp_dt"),0);
                break;
            case "prop_scp_ofc_cd":
            	var cd=sheetObj.GetCellValue(Row,"prop_scp_ofc_cd");
                formObj.f_cmd.value=COMMAND22;
                var sParam="prop_no="+sheetObjects[0].GetCellValue(1,"prop_no") + "&amdt_seq="+sheetObjects[0].GetCellValue(1, "amdt_seq");
                sParam += "&" + FormQueryString(formObj)+"&cd="+cd;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                var arrData=ComPriXml2Array(sXml, "cd|nm");
                if (arrData != null && arrData.length>0){
                    //sales Rep
                    setSheetRequestOfficeSaleRep(sheetObj, Row, cd);
                }else{
                    sheetObj.SetCellValue(Row,"prop_scp_ofc_cd","",0);
                    sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:"", ComboCode:""} );
                }
                if(formObj.prop_ofc_cd.value == sheetObj.GetCellValue(Row, Col)){
                	sheetObj.SetCellValue(Row, "prop_scp_srep_cd",prop_srep_cd.GetSelectText(),0);
                }
                break;
            case "svc_scp_cd":
            	//mySheet.GetComboInfo(Row, Col, Flag) 
            	sheetObj.SetCellValue(Row, "scp_nm","",0);
        	  //Getting combo code and text
        	  var sText=sheetObj.GetComboInfo(Row, "svc_scp_cd", "Text");
        	  //Setting each array
        	   var arrText=sText.split("|");
        	   var idx=sheetObj.GetComboInfo(Row, "svc_scp_cd", "SelectedIndex");
        	   if (idx == -1){
        		   sheetObj.SetCellValue(Row, "scp_nm","",0);
        		   sheetObj.SetCellValue(Row, "svc_scp_cd","",0);
        	   }else{
        		   sheetObj.SetCellValue(Row, "scp_nm",arrText[idx],0);
        	   }
            	break;
            case "prop_scp_mqc_qty":
            	if (sheetObj.GetCellValue(Row,Col) < 0){
            		sheetObj.SetCellValue(Row, Col,0,0);
            	}
            	break;
        }
    }   
    /**
     * Calling function in case of OnSearchEnd<br>
     * Setting HTML object's value to sheet's value after retrieving sheet<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet1_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.05.20
     */ 	
    function sheet1_OnSearchEnd(sheetObj, code , errMsg){
    	var formObj=document.form;
    	if( sheetObj.RowCount() == 0){
    		formObj.sc_no.readOnly=false;
    		formObj.prop_no.readOnly=false;
    		return;
    	}
    		
         //Keeping original duration to compare duration with scope when saving
//         var preIbflag = sheetObj.CellValue(1,"ibflag");
    	var preIbflag=sheetObj.GetRowStatus(1);
    	 
    	 /*
    	  *  User have almighty authority if activating super user authority as hidden function
    	  */
    	 if( IS_SUPER_USER ){
	         sheetObj.SetCellValue(1, "req_usr_flg","Y");
	         sheetObj.SetCellValue(1, "apro_usr_flg","Y");
	         sheetObj.SetCellValue(1, "all_usr_flg","Y");
    	 }
    	 comboObjects[1].RemoveAll();
    	 ComPriTextCode2ComboItem(appCdValue, appCdText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
    	 formObj.sc_no.value=sheetObj.GetCellValue(1,"sc_no");
    	 formObj.prop_no.value=sheetObj.GetCellValue(1,"prop_no");
    	 formObj.amdt_seq.value=sheetObj.GetCellValue(1,"amdt_seq");
    	 formObj.ctrt_eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_eff_dt"), "ymd");
    	 formObj.ctrt_exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_exp_dt"), "ymd");
    	 formObj.rf_flg.checked=sheetObj.GetCellValue(1,"rf_flg")=="Y"?true:false;
    	 formObj.gamt_flg.checked=sheetObj.GetCellValue(1,"gamt_flg")=="Y"?true:false;
    	 formObj.prop_sts.value=sheetObj.GetCellValue(1,"prop_sts");
    	 formObj.prop_ofc_cd.value=sheetObj.GetCellValue(1,"prop_ofc_cd");
    	 comboObjects[0].SetSelectCode(sheetObj.GetCellValue(1,"prop_srep_cd"),false);
    	 formObj.prop_srep_nm.value=sheetObj.GetCellValue(1,"prop_srep_nm");
    	 comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1,"prop_apro_ofc_cd"),false);
    	 formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"cre_dt"),"ymd");
    	 formObj.file_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"file_dt"),"ymd");
    	 formObj.cust_cnt_cd.value=sheetObj.GetCellValue(1,"cust_cnt_cd");
    	 if (sheetObj.GetCellValue(1, "cust_seq") !="" ){
    		 formObj.cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"cust_seq"), 6, "0");
         }else{
            formObj.cust_seq.value="";
         }        
    	 formObj.ctrt_pty_nm.value=sheetObj.GetCellValue(1,"ctrt_pty_nm");
    	 comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1,"prc_ctrt_cust_tp_cd"),false);
    	 formObj.ctrt_cust_val_sgm.value=sheetObj.GetCellValue(1,"ctrt_cust_val_sgm");
    	 formObj.ctrt_cust_sls_ofc_cd.value=sheetObj.GetCellValue(1,"ctrt_cust_sls_ofc_cd");
    	 comboObjects[3].SetSelectCode(sheetObj.GetCellValue(1,"ctrt_cust_srep_cd"),false);
    	 formObj.ctrt_cust_srep_nm.value=sheetObj.GetCellValue(1,"ctrt_cust_srep_nm");
    	 formObj.real_cust_cnt_cd.value=sheetObj.GetCellValue(1,"real_cust_cnt_cd");
    	 if (sheetObj.GetCellValue(1, "real_cust_seq") !="" ){
    		 formObj.real_cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"real_cust_seq"), 6, "0");
         }else{
            formObj.real_cust_seq.value="";
         }
    	 formObj.real_cust_nm.value=sheetObj.GetCellValue(1,"real_cust_nm");
    	 comboObjects[4].SetSelectCode(sheetObj.GetCellValue(1,"real_cust_tp_cd"),false);
    	 formObj.real_cust_val_sgm.value=sheetObj.GetCellValue(1,"real_cust_val_sgm");
    	 formObj.real_cust_sls_ofc_cd.value=sheetObj.GetCellValue(1,"real_cust_sls_ofc_cd");
        //Real Customer checking
    	 sheetObj.SetCellValue(1,"ori_real_cust_cd",sheetObj.GetCellValue(1,"real_cust_cnt_cd"));
    	 sheetObj.SetCellValue(1,"ori_real_cust_seq",sheetObj.GetCellValue(1,"real_cust_seq"));
    	 comboObjects[5].SetSelectCode(sheetObj.GetCellValue(1,"real_cust_srep_cd"),false);
    	 formObj.real_cust_srep_nm.value=sheetObj.GetCellValue(1,"real_cust_srep_nm");
    	 formObj.prop_mqc_qty.value=ComAddComma(sheetObj.GetCellValue(1,"prop_mqc_qty"));
    	 comboObjects[6].SetSelectCode(sheetObj.GetCellValue(1,"cntr_lod_ut_cd"),false);
        //OTI
    	 formObj.oti_no.value=sheetObj.GetCellValue(1, "oti_no");
    	 formObj.oti_lic_no.value=sheetObj.GetCellValue(1, "oti_lic_no");
    	 formObj.oti_eff_dt.value=sheetObj.GetCellValue(1, "oti_eff_dt");
    	 formObj.oti_exp_dt.value=sheetObj.GetCellValue(1, "oti_exp_dt");
    	 formObj.oti_amt.value=sheetObj.GetCellValue(1, "oti_amt");
    	 formObj.prop_apro_staff.value=sheetObj.GetCellValue(1, "prop_apro_staff");
        //sale lead

    	 formObj.sale_lead_ori.value=sheetObj.GetCellValue(1,"sls_ld_no");//for checking modifying value after retrieving(when saving)
    
    	 sheetObj.SetCellValue(1,"ctrt_eff_dt_ori",sheetObj.GetCellValue(1,"ctrt_eff_dt"));
    	 sheetObj.SetCellValue(1,"ctrt_exp_dt_ori",sheetObj.GetCellValue(1,"ctrt_exp_dt"));
        //keeping origin data to compare whether cust type cd is changed when saving
    	 sheetObj.SetCellValue(1, "cust_tp_ori",sheetObj.GetCellValue(1, "prc_ctrt_cust_tp_cd"));
        //prop_prpr_flg = Y
    	 sheetObj.SetCellValue(1, "prop_prpr_flg","Y",0);
    	 sheetObj.SetRowStatus(1,preIbflag);
    	 setCancelText();
    	 formObj.conv_cfm_flg.checked=sheetObj.GetCellValue(1,"conv_cfm_flg")=="Y"?true:false;
    	 formObj.prxy_flg.checked = sheetObj.GetCellValue(1,"prxy_flg")=="Y"?true:false;
    	 //2015.07.23 ADD
    	 comboObjects[7].SetSelectCode(sheetObj.GetCellValue(1,"ctrt_dur_tp_cd"),false);

    }   
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Setting value to added column to calculate MQC<br>
     * Modifying added data's color for Scope<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet2_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.05.20
     */         
    function sheet2_OnSearchEnd(sheetObj, code , errMsg){
    	var sheetObj=sheetObjects[1];
        var sheetObj1=sheetObjects[0];
        var formObj=document.form;
        if( sheetObj.RowCount() == 0) return;
        for ( var i=1; i <= sheetObj.RowCount(); i++ ){
        	sheetObj.SetCellValue(i,"prop_scp_mqc_qty_ori",sheetObj.GetCellValue(i,"prop_scp_mqc_qty"),0);
        	sheetObj.SetCellValue(i,"sale_rep_cd",sheetObj.GetCellValue(i,"prop_scp_srep_cd"),0);
            sheetObj.SetRowStatus(i,"R");
        }
        //Moving focus to position of selected scope when saving and retrieving
        for (var i = 1; i <= getValidRowCount(sheetObj); i++){        	
        	if (saveSvcScpCd == sheetObj.GetCellValue(i, "svc_scp_cd")){
        		sheetObj.SelectCell(i, 1);
        		break;
        	}
        }
        //Inputting Sales Rep in case of no retrieved Sales rep in combo
        var cboObj=comboObjects[0];
        var srepCd=sheetObj1.GetCellValue(1,"prop_srep_cd");
        var ofcCd=sheetObj1.GetCellValue(1,"ctrt_cust_sls_ofc_cd");
        if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.prop_srep_nm.value,srepCd);
        }
        //Inputing Approval office in case of no retrieved Approval Office in combo
        var cboObj=comboObjects[1];
        var aproOfcCd=sheetObj1.GetCellValue(1,"prop_apro_ofc_cd");
        if (aproOfcCd !="" && cboObj.FindItem(aproOfcCd, 0) == -1 ){
        	cboObj.InsertItem(0,aproOfcCd + "| "  ,aproOfcCd);
        	cboObj.SetSelectCode(aproOfcCd,false);
        }
        cboObj=comboObjects[3];
        srepCd=sheetObj1.GetCellValue(1,"ctrt_cust_srep_cd");
        if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.ctrt_cust_srep_nm.value,srepCd);
        }
        cboObj=comboObjects[5];
        srepCd=sheetObj1.GetCellValue(1,"real_cust_srep_cd");
        if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.real_cust_srep_nm.value,srepCd);
        }
        //Adding empty row
        comboObjects[3].InsertItem(0, " | | "," ");
        comboObjects[5].InsertItem(0, " | | "," ");
        //sale rep
        //SEtting IBMulti Combo
        comboObjects[0].SetSelectCode(sheetObj1.GetCellValue(1,"prop_srep_cd"),false);
        comboObjects[3].SetSelectCode(sheetObj1.GetCellValue(1,"ctrt_cust_srep_cd"),false);
        comboObjects[5].SetSelectCode(sheetObj1.GetCellValue(1,"real_cust_srep_cd"),false);
        //font
        var amdt_seq=document.form.amdt_seq.value;                
        if(amdt_seq==0 || sheetObjects[0].GetCellValue(1, "lgcy_if_flg") =="Y" ){
            return;
        }
        for(var i=1 ; i <= sheetObj.RowCount(); i++) {
	        if(sheetObj.GetCellValue(i,"pre_ext_scp") == "N"){
	        	sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(), "#FF0000");
	        }      
        }
    }   
     /**
      * Calling Function in case of OnSelectCell event <br>
      * Changing tab's icon after loading term's data for selected scope to Frame<br>
      * <br><b>Example :</b>
      * <pre>
      *		sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} OldRow Mandatory ,previous selected cell's Row Index
      * @param {int} OldCol Mandatory ,Previous selected cell's Column Index
      * @param {int} NewRow Mandatory ,current selected cell's Row Index
      * @param {int} NewCol Mandatory ,current selected cell's Column Index
      * @return N/A
      * @author 
      * @version 2009.04.17
      */  
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	  try{
    		  ComOpenWait(true); //->waiting->start
    		  if (saveSvcScpCd != "" && saveSvcScpCd != sheetObj.GetCellValue(NewRow, "svc_scp_cd")){
	    		  return;
	    	  }    	  
	          if (OldRow != NewRow) {
//no support[implemented common]CLT 	              changeSelectBackColor4Main(sheetObj);
	          }
    	  	  saveSvcScpCd="";
    	  	  if(sheetObj.GetCellValue(NewRow,"svc_scp_cd")!=""&&OldRow!=NewRow&&sheetObj.GetCellValue(NewRow,"ibflag")!="I"){
	    		  //Activating IHD Tab with only selected scope
    	  		  comApplyStyleProposalStatusSummary(sheetObj.GetCellValue(NewRow,"svc_scp_cd"));
		        	//0728
		    		if (tabObjects[0].GetSelectedIndex()== 0) {
		    			tab1_OnChange(tabObjects[0], 0);
		    		} else {
		    			tabObjects[0].SetSelectedIndex(0);
		    		}        	
		            loadTabPage(beforetab, NewRow);            
    	  	  }else if(sheetObj.GetCellValue(NewRow,"ibflag")=="I"){
	        	  if (NewRow != OldRow){
	              	clearAllTabPages();	
	              }        	
	          }
    	  	ComOpenWait(false); //->waiting->End
          } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e.message);
              }
          }finally{
        	  ComOpenWait(false); //->waiting->End
          }
    }
    /**
    * Calling Function in case of OnPopupClick event <br>
    * Calling Scope Duration,Scope MQC, G/L Copy. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.07
    */    
    var popupRow = 0;
    function sheet2_OnPopupClick(sheetObj, Row, Col)
    {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        popupRow=Row;
        switch(colName)
        {
            case "scp_dur_pop":
            	var sPropNo=sheetObjects[0].GetCellValue(1,"prop_no");
            	var sAmdtSeq=sheetObjects[0].GetCellValue(1, "amdt_seq");
            	var sPreAmdtSeq=sheetObjects[0].GetCellValue(1, "pre_amdt_seq");
            	var sPropStsCd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
            	var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
            	var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
            	var sSc_No=sheetObjects[0].GetCellValue(1,"sc_no");
            	var sPreExpDt=sheetObj.GetCellValue(Row, "pre_exp_dt");
            	var sIsReqUsr=sheetObjects[0].GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
            	var sIsAproUsr=sheetObjects[0].GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
            	var sDurDupFlg=sheetObj.GetCellValue(Row, "dur_dup_flg");
            	var sLgcyIfFlg=sheetObjects[0].GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+ "&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+ "&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg
                			+ "&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sLgcyIfFlg="+sLgcyIfFlg;
                ComOpenPopup("ESM_PRI_0019.do?"+sParam, 640, 380, "scp_dur_pop_returnVal", "1,0,1,1,1,1,1", true);
                    
                break;
            case "prop_scp_mqc_pop":
            	var sPropNo=sheetObjects[0].GetCellValue(1,"prop_no");
            	var sAmdtSeq=sheetObjects[0].GetCellValue(1, "amdt_seq");
            	var sPreAmdtSeq=sheetObjects[0].GetCellValue(1, "pre_amdt_seq");
            	var sPropStsCd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
            	var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
            	var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
            	var sPreExpDt=sheetObj.GetCellValue(Row, "pre_exp_dt");
            	var sIsReqUsr=sheetObjects[0].GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
            	var sIsAproUsr=sheetObjects[0].GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
            	var sDurDupFlg=sheetObj.GetCellValue(Row, "dur_dup_flg");
            	var sLgcyIfFlg=sheetObjects[0].GetCellValue(1, "lgcy_if_flg");
                sLgcyIfFlg="N";
                var sParam="sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+"&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg
                			+ "&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sLgcyIfFlg="+sLgcyIfFlg;
                ComOpenPopup("ESM_PRI_0020.do?"+sParam, 700, 570, "prop_scp_mqc_pop_returnVal", "1,0,1,1,1,1,1", true);
                break;
            case "gline_cp_flg_lnk":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }  
                var sParam="prop_no="+sheetObjects[0].GetCellValue(1, "prop_no")+"&amdt_seq="+sheetObjects[0].GetCellValue(1, "amdt_seq")+"&sc_no="+sheetObjects[0].GetCellValue(1, "sc_no")
                +"&svc_scp_cd="+sheetObjects[1].GetCellValue(Row, "svc_scp_cd")+"&prc_cust_tp_cd="+getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").GetSelectCode()
                +"&eff_dt="+sheetObjects[1].GetCellValue(Row, "ctrt_eff_dt")+"&exp_dt="+sheetObjects[1].GetCellValue(Row, "ctrt_exp_dt");
                ComOpenPopup("ESM_PRI_0018.do?"+sParam, 522, 330, "gline_cp_flg_lnk_returnVal", "1,0,1,1,1,1,1", true);
                break;
            case "prop_scp_ofc_pop":
                ComOpenPopup("COM_ENS_071.do?", 1000, 520, "prop_scp_ofc_pop_returnVal", '1,0,1,1,1,1,1', true);
                break;
        }
    }       
    
    function scp_dur_pop_returnVal(rtnVal) {
    	  if (rtnVal != null && rtnVal =="Y"){
              doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
          }             
    }
    
    function prop_scp_mqc_pop_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
        }   
    }
    
    function gline_cp_flg_lnk_returnVal(rtnVal) {
    	if (rtnVal != null && rtnVal =="OK"){
            clearAllTabPages();
            // Retrieving sub-Terms
            comApplyStyleProposalStatusSummary(sheetObjects[1].GetCellValue(popupRow,"svc_scp_cd"));
    		if (tabObjects[0].GetSelectedIndex()== 0) {
    			tab1_OnChange(tabObjects[0], 0);
    		} else {
    			tabObjects[0].SetSelectedIndex(0);
    		}        	
            loadTabPage(beforetab);                  	
        }
    }
    
    function prop_scp_ofc_pop_returnVal(rtnVal) {
 		if(rtnVal != null){
 			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "prop_scp_ofc_cd", ComLpad(rtnVal[0][3],6,""));
 		}
    }
    
//--> jin add (S)
    /**
    * Calculating MVC with MQC<br>
    * MVC = MQC / Duration valid days x 7 <br>
    * <br><b>Example :</b>
    * <pre>
    *		calcMVC();
    * </pre>
    * @param  N/A
    * @return N/A
    * @author 
    * @version 2009.05.07
    */  
    function calcMVC(){
        var formObj=document.form;
        var mqcQty=sheetObjects[0].GetCellValue(1, "prop_mqc_qty");
        var sDay=formObj.ctrt_eff_dt.value;
        var eDay=formObj.ctrt_exp_dt.value;
        var mvcQty=0;     
        var durDay=ComGetDaysBetween(sDay, eDay);        
        if (mqcQty != "" && mqcQty != "0"){            
            if (durDay !=0){
            	mvcQty=ComRound((mqcQty / durDay * 7),0);
            }
        }   
        formObj.prop_mvc.value=mvcQty;
        formObj.prop_mvc_tp.value=comboObjects[6].GetSelectText();
    }   
   /**
    * Return a result after checking whether each terms's have data in scope when deleting scope<br>
    * <br><b>Example :</b>
    * <pre>
    *		checkScopeDelete(Row)
    * </pre>
    * @param  {int}    Row Mandatory selected Scope's Row Index 
    * @return {string} <br>
    *                   Y : impossible to delete
    *                   N : possible to delete
    * @author 
    * @version 2009.05.07
    */  
    function checkScopeDelete(Row){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];
        var scpCd=sheetObj1.GetCellValue(Row, "svc_scp_cd");
        var rValue="N";//     (impossible to delete)             
        formObj.f_cmd.value=SEARCH09;
        var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj)+"&svc_scp_cd="+scpCd;
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "delcnt");
        if (arrData !=null && arrData.length > 0){
            if (arrData[0] == 0){
                rValue="Y";
            }
        }
        return rValue;
    }
    /**
     * Modifying scope main's status and button's activation/Deactivation after modifying mai's status data<br>
     * Activating approval button and deactivating c/offer button in case of all accept about Terms<br> 
     * Modifying Scope's status to init and deactivating Approval button/C/Offer button if status of terms is changed from accept to init once
     * <br><b>Example :</b>
     * <pre>
     *		scopeStatusChange(scpCd);
     * </pre>
     * @param  {string}  scpCd Mandatory Scope code
     * @return N/A
     * @author 
     * @version 2009.05.07
     */      
    function scopeStatusChange(scpCd){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];      
        var aproUsrFlg=sheetObj.GetCellValue(1, "apro_usr_flg")
        var sts=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        formObj.f_cmd.value=SEARCH08;     
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no") +"&amdt_seq="+sheetObj.GetCellValue(1,"amdt_seq");
        sParam += "&svc_scp_cd=" + scpCd + "&" + FormQueryString(formObj);
        var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "prop_scp_sts_cd","");
        if (arrData !=null && arrData.length > 0){  
            // Changing svc_scp_cd     
            for (var i=1; i <= sheetObj1.RowCount(); i++ ){
            	if (sheetObj1.GetCellValue(i, "svc_scp_cd") == scpCd ){
            		var flag=sheetObj1.GetRowStatus(i);
                	sheetObj1.SetCellValue(i, "prop_scp_sts_cd",arrData[0]);
                	sheetObj1.SetRowStatus(i,flag);
                    break;
                }
            }    
        	if (arrData[0] == "A"){       
                // Checking all accept
                if (checkAccept() == "Y"){
                    if(aproUsrFlg == "Y"){            
                        ComBtnEnable("btn_approve"); //(in case of all accept for terms)
                        ComBtnDisable("btn_coffer");
                    }             
                }else{          
                    ComBtnDisable("btn_approve"); //(in case of all accept for terms)
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }       
                }           
            }else if (arrData[0] =="I") {    
            	if (sheetObj.GetCellValue(1,"prop_sts_cd") == "Q" || aproUsrFlg=="Y" ){
                    ComBtnDisable("btn_approve");   
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }
                }
            }
        }
    }
    /**
     * Checking wheter dem/det is inputted or not when approving<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkDmdtData();
     * </pre>
     * @param  N/A
     * @return {string} <br>
     *          Y : Impossible to Approve<br>
     *          N : Possible to Approve할<br>
     * @author 
     * @version 2009.05.07
     */  
    function checkDmdtData(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var rValue="N";                          
        formObj.f_cmd.value=SEARCH10;
        try{
        	var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
            sParam += "&" + FormQueryString(formObj);            
            var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
            var arrData=ComPriXml2Array(sXml, "etc1|etc2");
            if (arrData != null && arrData.length > 0) {
                if (arrData[0][0] == "1" ){
                	rValue="Y";	
                }  
            }        	
        	if (rValue == "N"){
        		ComShowCodeMessage('PRI01122');
        	}
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        	rValue="N";
        }finally{
        	return rValue;
        }       
    }       
    /**
     * Checking wheter Terms is all accepted<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkAccept();
     * </pre>
     * @param  N/A
     * @return {string} <br>
     *          Y : all accepted<br>
     *          N : Exist one more un-accepted data<br>
     * @author 
     * @version 2009.05.07
     */      
    function checkAccept(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var rValue="Y";// all accepted                        
        formObj.f_cmd.value=SEARCH05;
        var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj);
        var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
        var arrData=ComPriXml2ComboString(sXml, "prop_no","prop_no");
        if (arrData !=null && arrData.length > 0){
            rValue="N";
        }
        return rValue;
    }
    /**
    * Checking whether all terms is accepted or returned<br>
    * impossible of C/Offer in case of return ="N"<br> 
    * <br><b>Example :</b>
    * <pre>
    *		checkCountOffer();
    * </pre>
    * @param  N/A
    * @return {string} <br>
    *          Y : all accepted or returned.<br>
    *          N : one more init data<br>
    * @author 
    * @version 2009.05.07
    */      
    function checkCountOffer(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var rValue="N";// impossible to C/Offer
        formObj.f_cmd.value=SEARCH06;
        var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj);
        var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
        var arrData=ComPriXml2ComboString(sXml, "status","cnt");        
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue="Y"
            }
        }
        return rValue;        
    }
    /**
     * showing message in case of modifying Customer Type.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkCustomerType();
     * </pre>
     * @param  N/A
     * @return {string} <br>
     *          Y : in case of modified Customer Type .<br>
     *          N : in case of not modified Customer Type<br>
     * @author 
     * @version 2009.05.07
     */ 
    function checkCustomerType(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var rValue="N";
        //sheetObj.CellValue(1, "cust_tp_ori") = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");
        var custTpOri=sheetObj.GetCellValue(1, "cust_tp_ori");
        var custSeq=ComParseInt(sheetObj.GetCellValue(1, "cust_seq"));
        var custCntCd=sheetObj.GetCellValue(1, "cust_cnt_cd")
        if (custTpOri != sheetObj.GetCellValue(1, "prc_ctrt_cust_tp_cd")
        		&& formObj.prop_no.value != "" && custTpOri !=""
        		&& custSeq == ComParseInt(formObj.cust_seq.value)
        		&& custCntCd == formObj.cust_cnt_cd.value){        	
        	rValue="Y";
        }
        return rValue;
    }        
     /**
      * Can't cancel init if there is data with DEM/DET when canceling Init<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkDemDetCancel();
      * </pre>
      * @param  N/A
      * @return {string} <br>
      *          Y : Init Cancel Possible<br>
      *          N : Init Cancel Impossible<br>
      * @author 
      * @version 2009.05.07
      */ 
     function checkDemDetCancel(){
         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         var rValue="N";
         formObj.f_cmd.value=SEARCH18;
         var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
         var arrData=ComPriXml2Array(sXml, "etc1");
         if(ComGetEtcData(sXml, "isNull") == "Y"){
        	 rValue = "Y";
         }else{
        	 if (arrData[0][0] == 0){
            	 rValue="Y";
             }
         }
         return rValue;  
     }       
     /**
      * Checking case not to be able to request when Request<br>
      * <br><b>Example :</b>
      * <pre>
      *         checkRequest
      * </pre>
      * @return N/A
      * @author 
      * @version 2009.04.17
      */    
      function checkRequest(){
          document.form.f_cmd.value=SEARCH07;
          var rMsg="";
          var msgParam="";
          var rValue="N"; //Request X
          var sheetObj=sheetObjects[0];
          var formObj=document.form;
          var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0003GS.do", sParam);
          var arrData=ComPriXml2Array(sXml, "terms|cnt|note");
          //Different message by checkType
          var checkType=0;
          if (arrData != null && arrData.length > 0) {
              for (var i=0; i < arrData.length; i++){
            	  if (arrData[i][0] == "DEMDET"){
                	  	checkType=1;
                	// S/C: Y , DEM/DET : N
	                	if (arrData[i][1] == "1"){ //need to create DEM/DET
	                  		rValue="N";
	                  		rMsg="PRI01120";
	                  		break;
	                  	}else if (arrData[i][1] == "2"){ //S/C: N , DEM/DET : Y
	                  		rValue="N";
	                  		rMsg="PRI01121"; 
	                  		break;
	                  	}else if (arrData[i][1] == "3"){
	                  		rValue="Y";
	                  	}
            	  }
//            	  else if (arrData[i][0] == "CALC_CHK") {// Rate Calculate check,
//            		  checkType = 4;
//            		  if (arrData[i][1] == "0"){
//            			  rValue ="Y";
//            		  }else{
//            			  rValue ="N";
//            			  msgParam = arrData[i][2];
//            			  break;
//            		  }
//            	  }
            	  else if (arrData[i][0] == "CTRT_CHK"){// Checking whether CTRT PTY Please Input exists or not
            		  checkType=5;
            		  if (arrData[i][1] == "0"){
            			  rValue="Y";
            		  }else{
            			  rValue="N";
            			  break;
            		  }            	  
                  }else{// Mandatory check
                      checkType=2;
                  	if (arrData[i][1] != "0"){
                          rValue="Y";
                    }else{                                   	
                      	rMsg += " "+arrData[i][0]+" " 
                        rValue="N";
                      	if (arrData[i][0] == "AMEND"){
                      		checkType=3;
                      	}
                        break;
                     }
                  }
              }
              if (rValue =="N" && checkType == 2){
                  ComShowCodeMessage("PRI01042",rMsg);
              }else if (rValue == "N" && checkType == 3){
              	ComShowCodeMessage("PRI01105");
              }else if (rValue == "N" && checkType == 1){
					ComShowCodeMessage(rMsg); 
              }else if (rValue =="N" && checkType == 4){
            	  ComShowCodeMessage("PRI03027", msgParam,"Request");
              }else if (rValue =="N" && checkType == 5){
            	  ComShowCodeMessage("PRI01128");
              }
          }else{
          	ComShowMessage(OBJECT_ERROR);
          }
          return rValue;
       }      
  /**
   * Prohibiting from canceling request if there is any accepted ,returned data when cancelling Request.<br>
   * <br><b>Example :</b>
   * <pre>
   *		checkRequestCancel();
   * </pre>
   * @param  N/A
   * @return {string} <br>
   *          Y : Possible to cancel Request<br>
   *          N : Impossible to cancel Request<br>
   * @author 
   * @version 2009.05.07
   */  
  function checkRequestCancel(){
      var formObj=document.form;
      var sheetObj=sheetObjects[0];
      var rValue="N";                          
      formObj.f_cmd.value=SEARCH20;
      try{
    	  var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
          var arrData=ComPriXml2Array(sXml, "cnt");
          if (arrData != null && arrData.length > 0) {
        	  if (arrData[0][0] == "0" ){
        		  rValue="Y";	
              }  
          }        	
      	  if (rValue == "N"){
      		  ComShowCodeMessage("PRI01129");
      	  }
      } catch (e) {
		  	if (e == "[object Error]") {
		          ComShowMessage(OBJECT_ERROR);
		      } else {
		          ComShowMessage(e.message);
		      }
		  	rValue="N";
      }finally{
    	  return rValue;
      }       
  }             
/**
 * Retrieving main's status after changing summary information<br>
 * Changing status to request if all terms is accepted in case returned main's status<br>
 * <br><b>Example :</b>
 * <pre>
 *		changeMainStatus();
 * </pre>
 * @param  N/A
 * @author 
 * @version 2009.05.07
 */      
function changeMainStatus(){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];                         
    formObj.f_cmd.value=SEARCH19;
    var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
    sParam += "&f_cmd="+SEARCH19;
    var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do" , sParam);
    var arrData=ComPriXml2Array(sXml, "prop_sts_cd|prop_sts");
    if (arrData !=null && arrData.length > 0){
    	if (arrData[0][0] == "Q"){
          sheetObj.SetCellValue(1,"prop_sts_cd",arrData[0][0],0);
          formObj.prop_sts.value=arrData[0][1];
          sheetObj.SetCellValue(1,"prop_sts",arrData[0][1],0);
    	}
    }    
}
 /**
  * Setting Sales rep for inputted Customer Sale Office to IBMulti Combo<br>
  * <br><b>Example :</b>
  * <pre>
  *		setCustSaleRep();
  * </pre>
  * @param  N/A
  * @return N/A
  * @author 
  * @version 2009.05.07
  */       
    function setCustSaleRep(){              
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (formObj.cust_cnt_cd.value !="" && formObj.cust_seq.value !=""){         
			formObj.f_cmd.value=SEARCHLIST;
		    sParam=FormQueryString(formObj) +"&etc1="+formObj.ctrt_cust_sls_ofc_cd.value
		    	+"&etc2="+formObj.cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.cust_seq.value);
		    sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
		    ComPriXml2ComboItem(sXml, ctrt_cust_srep_cd, "cd", "cd|nm|etc1");
	        comboObjects[3].InsertItem(0, " | | "," ");
		}
    }
  /**
   * Setting Sales rep for inputted Real Customer Sale Office to IBMulti Combo<br>
   * <br><b>Example :</b>
   * <pre>
   *		setRealCustSaleRep();
   * </pre>
   * @param  N/A
   * @return N/A
   * @author 
   * @version 2009.05.07
   */
    function setRealCustSaleRep(){
		  var formObj=document.form;
		  var sheetObj=sheetObjects[0];
		  if (formObj.real_cust_cnt_cd.value !="" && formObj.real_cust_seq.value !=""){
		      formObj.f_cmd.value=SEARCHLIST;            
		      sParam=FormQueryString(formObj) +"&etc1="+formObj.real_cust_sls_ofc_cd.value
		      +"&etc2="+formObj.real_cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.real_cust_seq.value);
		      sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
		      ComPriXml2ComboItem(sXml, real_cust_srep_cd, "cd", "cd|nm|etc1");    
		        comboObjects[5].InsertItem(0, " | | "," ");
		  }
    }     
    /**
     * Setting Sales rep for inputted Office to IBMulti Combo<br>
     * <br><b>Example :</b>
     * <pre>
     *		setRequestOfficeSaleRep();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.05.07
     */         
    function setRequestOfficeSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH15;     
        var sParam=FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
        var sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml,prop_srep_cd, "cd", "cd|nm");  
        formObj.prop_srep_nm.value="";
    }
    /**
     * Setting Sales rep for inputted Scope's Request Office  to sheet Combo<br>    
     * <br><b>Example :</b>
     * <pre>
     *		setSheetRequestOfficeSaleRep(sheetObj, Row, offCd);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int}     Row      Mandatory selection한 Row Index
     * @param {string}  offCd    Mandatory Scope의 Request Office code
     * @return N/A
     * @author 
     * @version 2009.05.07
     */           
    function setSheetRequestOfficeSaleRep(sheetObj, Row, offCd){
        var formObj=document.form;        
        formObj.f_cmd.value=SEARCH15;        
        var sParam=FormQueryString(formObj) +"&etc1="+ offCd;        
        var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do",sParam);
        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
        if (arrData !=null && arrData.length > 0){
            var arrCode=arrData[0].split("|");
            var arrText=arrData[1].split("|");        
            var aText="";
            if (arrCode != null && arrCode.length > 0){         
                for (var i=0; i < arrCode.length; i++){
                    aText += arrCode[i]+"\t"+arrText[i]+"|";
                }
            }
            var aTextSub = aText.substring(0,aText.length-1);
            sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:aTextSub, ComboCode:arrData[0]} );
        }else{
        	sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:"", ComboCode:""} );
        }
    }   
    /**
    * Retrieving SaleRep.'s Office Code<br>
    * <br><b>Example :</b>
    * <pre>
    *		getOfficeCd(srepCd);
    * </pre>
    * @param  {string} srepCd Mandatory sale rep. code
    * @return  string  Office Code
    * @author 
    * @version 2009.05.07
    */      
    function getOfficeCd(srepCd){
        document.form.f_cmd.value=COMMAND21;
        var sParam=FormQueryString(document.form)+"&etc1="+srepCd;
        var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", sParam);
        var arrData=ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            return arrData[0];
        }                                   
        return null;
    }
    /**
    * Clearing HTML Object's value about Customer<br>
    * <br><b>Example :</b>
    * <pre>
    *		clearCustName();
    * </pre>
    * @param  N/A
    * @return N/A
    * @author 
    * @version 2009.05.07
    */     
    function clearCustName(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        sheetObj.SetCellValue(1, "cust_cnt_cd","");
        sheetObj.SetCellValue(1, "cust_seq","");
        sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd","");
        sheetObj.SetCellValue(1,"ctrt_pty_nm","");
        sheetObj.SetCellValue(1,"ctrt_pty_addr","");
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd","");
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm","");
        sheetObj.SetCellValue(1,"ctrt_cust_srep_cd","");
        sheetObj.SetCellValue(1,"ctrt_cust_sls_ofc_cd","");
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_nm","");//arrText[0][6];
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_tit_nm","");//arrText[0][7];
        sheetObj.SetCellValue(1,"oti_no","");
        sheetObj.SetCellValue(1,"oti_lic_no","");
        sheetObj.SetCellValue(1,"oti_eff_dt","");
        sheetObj.SetCellValue(1,"oti_exp_dt","");
        sheetObj.SetCellValue(1,"oti_amt","");
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        comboObjects[2].SetSelectCode("");
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_nm.value="";
        comboObjects[3].SetSelectCode("");
        formObj.oti_no.value="";
        formObj.oti_lic_no.value="";
    }
    /**
    * Retrieving Customer information<br>
    * <br><b>Example :</b>
    * <pre>
    *		custNameFind(eleName);
    * </pre>
    * @param  {string} eleName Mandatory Html Object Name
    * @return N/A
    * @author 
    * @version 2009.05.07
    */      
    function custNameFind(eleName){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var cust_cnt_cd=formObj.cust_cnt_cd.value;        
        var cust_seq=formObj.cust_seq.value;
        var propOfcCd=formObj.prop_ofc_cd.value;
        if(cust_cnt_cd != "" && cust_seq !=""){
            var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq+"&prop_ofc_cd="+propOfcCd;        
            var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do", sParam);
            var saveName="prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|"
            	+"ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|oti_no|"
            	+"oti_eff_dt|oti_exp_dt|oti_amt|oti_lic_no|ctrt_cust_srep_nm"
            	var arrText=ComPriXml2Array(sXml, saveName);
            if(arrText==undefined){
                clearCustName();
                formObj.cust_cnt_cd.focus();
            }else{
//                comboObjects[2]2.Code = "";              
                comboObjects[3].SetSelectCode("",false);
                sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd",arrText[0][0]);
                sheetObj.SetCellValue(1,"ctrt_pty_nm",arrText[0][1]);
                sheetObj.SetCellValue(1,"ctrt_pty_addr",arrText[0][2]);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd",arrText[0][3]);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm",arrText[0][4]);
                sheetObj.SetCellValue(1,"ctrt_cust_srep_cd",arrText[0][5]);
                sheetObj.SetCellValue(1,"ctrt_cust_sls_ofc_cd",arrText[0][6]);
                sheetObj.SetCellValue(1,"ctrt_pty_sgn_nm",arrText[0][7]);
                sheetObj.SetCellValue(1,"ctrt_pty_sgn_tit_nm",arrText[0][8]);
                sheetObj.SetCellValue(1,"oti_no",arrText[0][9]);//arrText[0][7];
                sheetObj.SetCellValue(1,"oti_eff_dt",arrText[0][10]);
                sheetObj.SetCellValue(1,"oti_exp_dt",arrText[0][11]);
                sheetObj.SetCellValue(1,"oti_amt",arrText[0][12]);
                sheetObj.SetCellValue(1,"oti_lic_no",arrText[0][13]);
                formObj.ctrt_pty_nm.value=arrText[0][1];
                comboObjects[2].SetSelectCode(arrText[0][0],false);
                formObj.ctrt_cust_val_sgm.value=arrText[0][4];
                formObj.ctrt_cust_sls_ofc_cd.value=arrText[0][6];
                comboObjects[3].SetSelectCode(arrText[0][5],false);
                formObj.ctrt_cust_srep_nm.value=arrText[0][14];
                formObj.oti_no.value=arrText[0][9];
                formObj.oti_eff_dt.value=arrText[0][10];
                formObj.oti_exp_dt.value=arrText[0][11];
                formObj.oti_amt.value=arrText[0][12];  
                formObj.oti_lic_no.value=arrText[0][13];
            }
        }
        var sheetObj=sheetObjects[0]; 
        com_change_sheet( sheetObj, eleName);
//        alert(formObj.ctrt_cust_sls_ofc_cd.value)
    }   
    /**
     * Initializaing duration,Mvc,afiliate button's image<br>
     * <br><b>Example :</b>
     * <pre>
     *		clearButtonImages();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.05.07
     */
    function clearButtonImages(){
    	document.form.img_mqc.src=ICON_URL_NOT_EXIST;
    	document.form.img_affil.src=ICON_URL_NOT_EXIST;
    	document.form.img_blpl.src=ICON_URL_NOT_EXIST;
    	document.form.img_ctrt.src=ICON_URL_NOT_EXIST;
    	document.form.img_ctrt_tpy.src=ICON_URL_NOT_EXIST;
    	document.form.img_dur.src=ICON_URL_NOT_EXIST;
    }
    /**
    * Clearing html object's value about Real Customer<br>
    * <br><b>Example :</b>
    * <pre>
    *		clearRealCustName();
    * </pre>
    * @param  N/A
    * @return N/A
    * @author 
    * @version 2009.05.07
    */         
    function clearRealCustName(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
    	sheetObj.SetCellValue(1,"real_cust_seq","");
    	sheetObj.SetCellValue(1,"real_cust_cnt_cd","");
        sheetObj.SetCellValue(1,"real_cust_tp_cd","");
        sheetObj.SetCellValue(1,"real_cust_nm","");
//        sheetObj.CellValue(1,"real_cust_val_sgm_cd") = "";
        sheetObj.SetCellValue(1,"real_cust_val_sgm","");
        sheetObj.SetCellValue(1,"real_cust_srep_cd","");
        sheetObj.SetCellValue(1,"real_cust_sls_ofc_cd","");
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_seq.value="";
        comboObjects[4].SetSelectCode("");
        formObj.real_cust_nm.value="";
        formObj.real_cust_val_sgm.value="";
        comboObjects[5].SetSelectCode("");
        formObj.real_cust_sls_ofc_cd.value="";
        formObj.real_cust_srep_nm.value="";        
    }   
    /**
    * Retrieving Real Customer information.<br>
    * <br><b>Example :</b>
    * <pre>
    *		realCustNameFind(eleName);
    * </pre>
    * @param  {string} eleName Mandatory Html Object Name
    * @return N/A
    * @author 
    * @version 2009.05.07
    */      
    function realCustNameFind(eleName){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var real_cust_cnt_cd=formObj.real_cust_cnt_cd.value;
        var real_cust_seq=formObj.real_cust_seq.value;
        if(real_cust_cnt_cd != ""  && real_cust_seq !=""){
            var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+real_cust_cnt_cd+"&cust_seq="+real_cust_seq;
            var sXml=sheetObj.GetSearchData("ESM_PRI_0003GS.do", sParam);
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm");
            if(arrText==undefined){
                clearRealCustName();
                formObj.real_cust_cnt_cd.focus();
            }else{
                comboObjects[4].SetSelectCode("");
                comboObjects[5].SetSelectCode("");
                sheetObj.SetCellValue(1,"real_cust_tp_cd",arrText[0][0]);
                sheetObj.SetCellValue(1,"real_cust_nm",arrText[0][1]);
//                sheetObj.CellValue(1,"real_cust_val_sgm_cd") = arrText[0][3];
                sheetObj.SetCellValue(1,"real_cust_val_sgm",arrText[0][4]);
                sheetObj.SetCellValue(1,"real_cust_srep_cd",arrText[0][5]);
                sheetObj.SetCellValue(1,"real_cust_sls_ofc_cd",arrText[0][6]);
                comboObjects[4].SetSelectCode(arrText[0][0],false);
                formObj.real_cust_nm.value=arrText[0][1];
                formObj.real_cust_val_sgm.value=arrText[0][4];
                comboObjects[5].SetSelectCode(arrText[0][5],false);
                formObj.real_cust_sls_ofc_cd.value=arrText[0][6]; 
                formObj.real_cust_srep_nm.value=arrText[0][7];        
            }
        }else if (real_cust_cnt_cd == "" || real_cust_seq ==""){
//          clearRealCustName();
        }
        var sheetObj=sheetObjects[0]; 
        com_change_sheet( sheetObj, eleName);
    }   
    /**
     * Modifying scope's duration according to conditions in case of changing main duration<br>
     * Modifying scope's duration before saving<br>
     * <br><b>Example :</b>
     * <pre>
     *      saveChangeDuration(true);
     * </pre>
     * @param {msgPass} Mandatory , true : with message box, false : without message box
     * @return N/A
     * @author 
     * @version 2009.04.17
     */     
    function saveChangeDuration(msgPass){
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];
        var oriCtrtEffDt=sheetObj.GetCellValue(1, "ctrt_eff_dt_ori");//before modifying  duration
        var oriCtrtExpDt=sheetObj.GetCellValue(1, "ctrt_exp_dt_ori");//before modifying   duration
        var ctrtEffDt=sheetObj.GetCellValue(1, "ctrt_eff_dt");//after modifying duration
        var ctrtExpDt=sheetObj.GetCellValue(1, "ctrt_exp_dt");//after modifying duration
        var effChk=0;// 1 : extending duration eff, 2 : Reducing Duration Eff 
        var expChk=0;// 1 : Reducing Duration Eff ,               ,  2 : reducing Duration Exp 
        var msgChk=0;
        var amdtSeq=sheetObj.GetCellValue(1,"amdt_seq");
        if (sheetObj.GetCellValue(1, "ibflag")=="I"){//new
            for( var i=1; i <= sheetObj1.RowCount(); i++){
            	sheetObj1.SetCellValue(i, "ctrt_eff_dt",ctrtEffDt);
            	sheetObj1.SetCellValue(i, "ctrt_exp_dt",ctrtExpDt);
            }        	
        	return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk=1; //extending days ahead,extending duration eff
             //if selecting no,extending Proposal Duration Eff 
            for ( var i=1 ; i <=sheetObj1.RowCount(); i++){
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){ 
            effChk=2; //reducing days and Duration Eff
            //if selecting no, return after cancelling all processing
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ //reducing days and Duration Eff 
            expChk=1; //reducing days and Duration Eff 
           //if selecting no, return after cancelling all processing
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 3; 
                    break;
                }
            }
        }else if (oriCtrtExpDt < ctrtExpDt){ 
            expChk=2; //extending days backward and extending Duration Exp
            //if selecting no, extending Proposal Duration Exp only
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtExpDt == sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 6;
                    break;
                }               
            }
        }       
        if ((effChk + expChk) == 0){ //Modifying only duration
            return true;
        }
        if (msgPass == "true"){
            msgChk=0;
        }
      //Diplaying SCOPE DURATION modification confirm message
        switch (msgChk){
            case 1://although selecting NO ,Modifying main duration
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }
                break;
            case 2:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }               
                break;
            case 3:         
            case 4:
            case 5:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }                       
                break;
            case 6://although selecting NO ,Modifying main duration
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }               
                break;
            case 7://although selecting NO ,Modifying main duration
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }               
                break;
            case 8:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }                   
                break;
        }
        if (effChk == 1){           
            //effChk = 1; //extending days ahead,extending duration eff
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
                //if previous Main duration = Scope Duration
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i,"eff_dt",ctrtEffDt,0);
                    if (amdtSeq =="0"){
                        sheetObj1.SetCellValue(i, "n1st_cmnc_dt",ctrtEffDt,0);// not used
                    }
                }
            }
        }else if (effChk == 2){
            //effChk = 2; //reducing days andDuration Eff 
            //if selecting no, return after cancelling all processing
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i, "ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i, "eff_dt",ctrtEffDt,0);
                    if (amdtSeq =="0"){
                        sheetObj1.SetCellValue(i, "n1st_cmnc_dt",ctrtEffDt,0);
                    }
                }
            }
        }
        if (expChk == 1){
            //expChk = 1; //reducing days andDuration Eff 
             //if selecting no, return after cancelling all processing
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_exp_dt",ctrtExpDt,0);
                    sheetObj1.SetCellValue(i,"exp_dt",ctrtExpDt,0);
                }
            }
        }else if (expChk == 2){
            //expChk = 2; ////extending days backward and extending Duration Exp
             //if selecting no, return after cancelling all processing
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtExpDt == sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    sheetObj1.SetCellValue(i, "ctrt_exp_dt",ctrtExpDt,0);
                    sheetObj1.SetCellValue(i, "exp_dt",ctrtExpDt,0);
                }               
            }
        }       
        return true;
    }
 /**
  * Enable/Disable Real customer according to Customer Type  <br>
  * <br><b>Example :</b>
  * <pre>
  *      changeRealCustomerEditable(true);
  * </pre>
  * @param {Boolean} Mandatory true, false
  * @return N/A
  * @author 
  * @version 2009.04.17
  */     
 function changeRealCustomerEditable(sw){
     var formObj=document.form;
	 formObj.real_cust_cnt_cd.readOnly=!sw;
     formObj.real_cust_seq.readOnly=!sw;
     btnImgEnable(formObj.btn_real_cust, sw);
     real_cust_tp_cd.SetEnable(sw);
     real_cust_srep_cd.SetEnable(sw);
 }
 /**
  * Allowing to use control when inputting data at first time by using new button by user without authority <br>
  * <br><b>Example :</b>
  * <pre>
  *      setNewDataControl();
  * </pre>
  * @param  N/A
  * @return N/A
  * @author 
  * @version 2009.04.17
  */      
  function setNewDataControl(){
	  var formObj=document.form;
	  formObj.ctrt_eff_dt.readOnly=false;    
	  formObj.ctrt_exp_dt.readOnly=false;
	  btnImgEnable(formObj.btn_ctrt_cust, true);
	  ComBtnDisable("btn_ctrt_pty_pop");
	  btnImgEnable(formObj.btns_calendar1, true);
	  btnImgEnable(formObj.btns_calendar2, true);   	  	
	  formObj.prop_mqc_qty.readOnly=false;
	  ctrt_cust_srep_cd.SetEnable(true);
	  prc_ctrt_cust_tp_cd.SetEnable(true);
	  formObj.cust_cnt_cd.readOnly=false;
	  formObj.cust_seq.readOnly=false;    
	  formObj.rf_flg.disabled=false;//reefer            
	  formObj.gamt_flg.disabled=false;//garment
	  prop_srep_cd.SetEnable(true);
	  prop_apro_ofc_cd.SetEnable(true);
	  cntr_lod_ut_cd.SetEnable(true);
	  ctrt_dur_tp_cd.SetEnable(true);
	  /*
	  document.images("img_lgcy").src=ICON_URL_NOT_EXIST;
	  */
      ComBtnEnable("btn_save"); 
      ComBtnEnable("btn_rowadd");            
      ComBtnEnable("btn_delete");  
  }  
  /**
   * Event in cae of losting IBMulti Combo's focus.<br>
   * Displaying Combo's text value to HTML object. <br>
   * <br><b>Example :</b>
   * <pre>
   *    prop_srep_cd_OnBlur(comboObj);
   * </pre>
   * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
   * @return N/A
   * @author 
   * @version 2009.04.17
   */  
  function prop_srep_cd_OnBlur(comboObj) {
		var formObj=document.form;		
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
		var sheetObj=sheetObjects[0];
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" ) {
				formObj.prop_srep_nm.value=comboObj.GetText(code, 1);
			} else {
				formObj.prop_srep_nm.value="";
			}
		}
		if ( code == -1 ) {
			formObj.prop_srep_nm.value="";
		}
	}       
  /**
   * changing cancel button's text according to main's status<br>
   * <br><b>Example :</b>
   * <pre>
   *    setCancelText();
   * </pre>
   * @param  N/A
   * @return N/A
   * @author 
   * @version 2009.04.17
   */ 
  function setCancelText(){
		var formObj=document.form;
		var cancelTxt=formObj.prop_sts.value ;
		if (cancelTxt == "Requested"){
			cancelTxt="Request Cancel";
		}else if(cancelTxt == "Approved"){
			cancelTxt="Approve Cancel";
		}else if(cancelTxt == "Filed"){
			cancelTxt="Revert";
		}else{
			cancelTxt="Cancel";
		}
		document.getElementById("btn_cancel").innerText=cancelTxt;  	
  } 
  /**
  * allowing to use widely a screen by showing or hiding a part of screen<br>
  * <br><b>Example :</b>
  * <pre>
  *    setControlHidden();
  * </pre>
  * @param  N/A
  * @return N/A
  * @author 
  * @version 2009.04.17
  */   
	function setControlHidden(){
		if (!controlHidden){
			document.all.subterms.style.display="none";
			controlHidden=true;
		}else{
			document.all.subterms.style.display="inline";
			controlHidden=false;
			sheet1_OnSearchEnd(sheetObjects[0], "");
		}
		try{
		    parent.syncHeight();  
			}catch(e){}
	}
//--> jin add (E)
//    sheet     (E)   -----
/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (E)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
  /**
  * Activating and deactivating image buttons<br>
  * <br><b>Example :</b>
  * <pre>
  *    btnImgEnable(obj, gb);
  * </pre>
  * @param  {form} obj Mandatory Html Object
  * @param  {bool} gb  Mandatory true : Activating, false : Deactivation
  * @return N/A
  * @author 
  * @version 2009.04.17
  */ 
function btnImgEnable(obj, gb) {
    if(obj.constructor == String){
        obj=document.getElementsByName(obj)[0];        
    }
    var btnStyle=obj.style;
    if (gb){
//        obj.SetEnable(1);
    	obj.enable=true;
        btnStyle.cursor="hand";
        btnStyle.filter="";
        obj.disabled=false;
    } else {
        obj.enable=false;
        btnStyle.cursor="auto";
        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
        obj.disabled=true;
    }
}
   /**
    * Confirming Conversion\br>
    * Activating in case of confirmed previous amend seq<br>
    * Disable to check box after Confirm <br>
    * <br><b>Example :</b>
    * <pre>
    *		conversionConfirm();
    * </pre>
    * @return N/A
    * @author 
    * @version 2009.05.07
    */      
    function conversionConfirm(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        try{
        	ComOpenWait(true); //->waiting->start
        	if (!ComShowCodeConfirm("PRI01118")){
                formObj.conv_cfm_flg.checked=false;            
            	return false;
            }
            formObj.f_cmd.value=MULTI07;   
            var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+"&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
            sParam += "&"+ FormQueryString(formObj);            
            var saveXml=sheetObjects[0].GetSaveData("ESM_PRI_0003GS.do", sParam);
            sheetObjects[0].LoadSaveData(saveXml);
            ComOpenWait(false); //->waiting->End
            formObj.conv_cfm_flg.disabled=true;        	
        } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e.message);
              }
          }finally{
        	  ComOpenWait(false); //->waiting->End
          }
    }     

    /**
    * showing button to be available to super user<br>
    * <br><b>Example :</b>
    * <pre>
    *     showButtonsForSuperUser();
    * </pre>
    * @return N/A
    * @author 
    * @version 2010.06.29
    */
   function showButtonsForSuperUser(){
		// showing button to allow to cancel filed status
		var file_btn_obj=document.getElementById("span_cancel_filing");
		file_btn_obj.style.display="inline";
   }
    /**
    * checking whether other user modified datas already about same s/c no.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     checkChangingUpdateDate(sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj ,sheet object with update date,key
    * @param {String} checkTpCd ,code to be define table to check update date
    *  
    * @return boolean , true :modified, false: not modified
    * @author 
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
        // checking update date
	   switch(checkTpCd){
	   case "CHECK1" :
		   var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_SP_MN&page_name=S/C&key1=" + checkSheetObj.GetCellValue(1, "prop_no") + "&key2="+checkSheetObj.GetCellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.GetCellValue(1, "upd_dt");
		   var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   case "CHECK2" : //amend
		   var amdt_seq=parseInt(checkSheetObj.GetCellValue(1, "amdt_seq"));
	   		//checking if next seq is created already
	   		amdt_seq++;
	   		var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_SP_MN&page_name=S/C&key1=" + checkSheetObj.GetCellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.GetCellValue(1, "upd_dt");
	   		var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
