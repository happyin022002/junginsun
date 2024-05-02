/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1004.js
*@FileTitle  : Chassis Master Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
	// common global variables
	var docObjects=new Array();
	var sheetCnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
    function processButtonClick(){
         /***** use additional sheet var in case of more than 2 tap each sheet *****/
         var sheetObject=docObjects[0];
         var sheetObject1=docObjects[1];
         /*******************************************************/
         var formObject=document.form; 
         var rdObject=rdObjects[0];
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
	        break;
				case "btng_print":					
					viewer.print({isServerSide:true});
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg=getMsg("TES22506" );
                showErrMessage(errMsg);
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
       	rdOpen();	
		//rdObjects[0].PrintDialog();
    }
    /**
     * printpage open
     * printpage open
     * printable page open
     */
	function rdOpen(){		
		var sXml = "";		
		var i=0;
		var j=0; 

		var opener_obj=window.dialogArguments;
		if (!opener_obj) opener_obj=parent; //이 코드 추가할것
		
		var opener_sheet_obj1 =  opener_obj.sheet1;
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[1] = document.form;                            // 
        rdObj[0] = opener_sheet_obj1;    
        
        sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET><SHEET1><DATA TOTAL='0'><TR><TD></TD></TR></DATA></SHEET1>";
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;  
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";
		sXmlEtc +="	<EQ_NO>"+opener_obj.document.form.eq_no.value+"</EQ_NO>";
		sXmlEtc +="	<ACIAC_DIV_CD>"+opener_obj.document.form.aciac_div_cd.value+"</ACIAC_DIV_CD>";
		sXmlEtc +="	<ONH_DT>"+opener_obj.document.form.onh_dt.value+"</ONH_DT>";
		sXmlEtc +="	<ONH_OFC_CD>"+opener_obj.document.form.onh_ofc_cd.value+"</ONH_OFC_CD>";
		sXmlEtc +="	<EQ_TPSZ_CD>"+opener_obj.document.form.eq_tpsz_cd.value+"</EQ_TPSZ_CD>";
		sXmlEtc +="	<MFT_DT>"+opener_obj.document.form.mft_dt.value+"</MFT_DT>";
		sXmlEtc +="	<CHSS_POOL_CD>"+opener_obj.document.form.chss_pool_cd.value+"</CHSS_POOL_CD>";
		var tmpDispFlag="";if(opener_obj.document.form.disp_flg.checked){tmpDispFlag="Y";} else {tmpDispFlag="N";}
		sXmlEtc +="	<DISP_FLG>"+tmpDispFlag+"</DISP_FLG>";
		sXmlEtc +="	<EQ_SPEC_NO>"+opener_obj.document.form.eq_spec_no.value+"</EQ_SPEC_NO>";
		sXmlEtc +="	<CHSS_TARE_WGT>"+opener_obj.document.form.chss_tare_wgt.value+"</CHSS_TARE_WGT>";
		sXmlEtc +="	<CHSS_MVMT_STS_CD>"+opener_obj.document.form.chss_mvmt_sts_cd.value+"</CHSS_MVMT_STS_CD>";
		sXmlEtc +="	<CRNT_YD_CD>"+opener_obj.document.form.crnt_yd_cd.value+"</CRNT_YD_CD>";
		sXmlEtc +="	<CHSS_MVMT_DT>"+opener_obj.document.form.chss_mvmt_dt.value+"</CHSS_MVMT_DT>";
		var tmpCntrChk="";if(opener_obj.document.form.cntr_chk.checked){tmpCntrChk="Y";} else {tmpCntrChk="N";}
		sXmlEtc +="	<CNTR_CHK>"+tmpCntrChk+"</CNTR_CHK>";
		var tmpMGSetChk="";if(opener_obj.document.form.mgset_chk.checked){tmpMGSetChk="Y";} else {tmpMGSetChk="N";}
		sXmlEtc +="	<MGSET_CHK>"+tmpMGSetChk+"</MGSET_CHK>";
		//added start
		sXmlEtc +=" <ATCH_CNTR>"+opener_obj.document.form.atch_cntr.value+"</ATCH_CNTR>";
		sXmlEtc +=" <ATCH_MGS>"+opener_obj.document.form.atch_mgs.value+"</ATCH_MGS>";
		//added end
		var tmpBareChk="";if(opener_obj.document.form.bare_chk.checked){tmpBareChk="Y";} else {tmpBareChk="N";}
		sXmlEtc +="	<BARE_CHK>"+tmpBareChk+"</BARE_CHK>";
		var tmpDamageChk="";if(opener_obj.document.form.damage_chk.checked){tmpDamageChk="Y";} else {tmpDamageChk="N";}
		sXmlEtc +="	<DAMAGE_CHK>"+tmpDamageChk+"</DAMAGE_CHK>";
		var tmpLStayChk="";if(opener_obj.document.form.lstay_chk.checked){tmpLStayChk="Y";} else {tmpLStayChk="N";}
		sXmlEtc +="	<LSTAY_CHK>"+tmpLStayChk+"</LSTAY_CHK>";
		sXmlEtc +="	<AGREEMENT_NO>"+opener_obj.document.form.agreement_no.value+"</AGREEMENT_NO>";
		sXmlEtc +="	<AGMT_LSTM_CD>"+opener_obj.document.form.agmt_lstm_cd.value+"</AGMT_LSTM_CD>";
		sXmlEtc +="	<ACT_ONH_DT>"+opener_obj.document.form.act_onh_dt.value+"</ACT_ONH_DT>";
		sXmlEtc +="	<AGMT_REF_NO><![CDATA["+opener_obj.document.form.agmt_ref_no.value+"]]></AGMT_REF_NO>";
		sXmlEtc +="	<VNDR_ABBR_NM>"+opener_obj.document.form.vndr_abbr_nm.value+"</VNDR_ABBR_NM>";
		sXmlEtc +="	<CHSS_ALS_NO>"+opener_obj.document.form.chss_als_no.value+"</CHSS_ALS_NO>";
		sXmlEtc +="	<N2ND_CHSS_ALS_NO>"+opener_obj.document.form.n2nd_chss_als_no.value+"</N2ND_CHSS_ALS_NO>";
		sXmlEtc +="	<CHSS_RGST_STE_CD>"+opener_obj.document.form.chss_rgst_ste_cd.value+"</CHSS_RGST_STE_CD>";
		sXmlEtc +="	<CHSS_RGST_LIC_NO>"+opener_obj.document.form.chss_rgst_lic_no.value+"</CHSS_RGST_LIC_NO>";
		sXmlEtc +="	<CHSS_RGST_YR>"+opener_obj.document.form.chss_rgst_yr.value+"</CHSS_RGST_YR>";
		sXmlEtc +="	<CHSS_VEH_ID_NO>"+opener_obj.document.form.chss_veh_id_no.value+"</CHSS_VEH_ID_NO>";
		sXmlEtc +="	<CHSS_TIT_NO></CHSS_TIT_NO>";//
		var tmpChssRgstPrdCd="";
		if(opener_obj.document.form.chss_rgst_prd_cd[0].checked==true){ tmpChssRgstPrdCd="PMNT"; }
		else if(opener_obj.document.form.chss_rgst_prd_cd[1].checked==true){ tmpChssRgstPrdCd="Fixed"; }
		sXmlEtc +="	<CHSS_RGST_PRD_CD>"+tmpChssRgstPrdCd+"</CHSS_RGST_PRD_CD>";
		sXmlEtc +="	<CHSS_RGST_EXP_DT>"+opener_obj.document.form.chss_rgst_exp_dt.value+"</CHSS_RGST_EXP_DT>";
		sXmlEtc +="	<CHSS_RGST_UPD_DT>"+opener_obj.document.form.chss_rgst_upd_dt.value+"</CHSS_RGST_UPD_DT>";
		sXmlEtc +="	<CHSS_RGST_UPD_ID>"+opener_obj.document.form.chss_rgst_upd_id.value+"</CHSS_RGST_UPD_ID>";
		sXmlEtc +="	<UPD_DT>"+opener_obj.document.form.upd_dt.value+"</UPD_DT>";
		sXmlEtc +="	<UPD_USR_ID>"+opener_obj.document.form.upd_usr_id.value+"</UPD_USR_ID>";
		sXmlEtc +="</ETC>"
		sXml +=sXmlEtc;
		sXml +="</SHEET>";
		if ( 
				opener_obj.document.form.aciac_div_cd.value == ""
			&&  opener_obj.document.form.onh_dt.value == ""
			&&  opener_obj.document.form.onh_ofc_cd.value == ""
			&&  opener_obj.document.form.eq_tpsz_cd.value == ""
			&&  opener_obj.document.form.mft_dt.value == ""
			&&  opener_obj.document.form.chss_pool_cd.value == ""
			&&  opener_obj.document.form.eq_spec_no.value == ""
			&&  opener_obj.document.form.chss_tare_wgt.value == ""
		)                     // error in case of no sheet data for RD
		{
		    errMsg='No data found.';
		    showErrMessage(errMsg);
		    return;
		}
//		rdObjects[0].AutoAdjust=true;
		//rdObjects[0].HideToolBar();
		//rdObjects[0].HideStatusBar();
//		rdObjects[0].ViewShowMode(0);
//		rdObjects[0].SetBackgroundColor(255,255,255);
//		rdObjects[0].SetPageLineColor(255,255,255);			
		viewer.setRData(sXml);
//		rdObjects[0].ApplyLicense("0.0.0.0");
		viewer.openFile(RD_path+'apps/opus/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1004.mrd',RDServer, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1004.mrd',RDServer);
		
	}
