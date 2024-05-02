/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1004.js
*@FileTitle : Chassis Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.17 조재성
* 1.0 Creation
=========================================================*/
	
	// 공통전역변수
	var docObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= docObjects[0];
         var sheetObject1 = docObjects[1];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				
				case "btn_close":
					window.close();
	        break;

				case "btng_print":					
					rdObject.PrintDialog();
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg = getMsg("TES22506" );
                showErrMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
       	rdOpen();	
		//rdObjects[0].PrintDialog();
    }

    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0; 
		var opener_obj = window.dialogArguments;	
		var opener_sheet_obj1 =  opener_obj.document.sheet1;
		var opener_sheet_obj2 =  opener_obj.document.sheet2;
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
        rdObj[0] = opener_sheet_obj1;    
         
        sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET><SHEET1><DATA TOTAL='0'><TR><TD></TD></TR></DATA></SHEET1>";
		
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
		
		var tmpDispFlag = "";if(opener_obj.document.form.disp_flg.checked){tmpDispFlag = "Y";} else {tmpDispFlag = "N";}
		sXmlEtc +="	<DISP_FLG>"+tmpDispFlag+"</DISP_FLG>";
		sXmlEtc +="	<EQ_SPEC_NO>"+opener_obj.document.form.eq_spec_no.value+"</EQ_SPEC_NO>";
		sXmlEtc +="	<CHSS_TARE_WGT>"+opener_obj.document.form.chss_tare_wgt.value+"</CHSS_TARE_WGT>";
		
		sXmlEtc +="	<CHSS_MVMT_STS_CD>"+opener_obj.document.form.chss_mvmt_sts_cd.value+"</CHSS_MVMT_STS_CD>";
		sXmlEtc +="	<CRNT_YD_CD>"+opener_obj.document.form.crnt_yd_cd.value+"</CRNT_YD_CD>";
		sXmlEtc +="	<CHSS_MVMT_DT>"+opener_obj.document.form.chss_mvmt_dt.value+"</CHSS_MVMT_DT>";
		
		
		var tmpCntrChk = "";if(opener_obj.document.form.cntr_chk.checked){tmpCntrChk = "Y";} else {tmpCntrChk = "N";}
		sXmlEtc +="	<CNTR_CHK>"+tmpCntrChk+"</CNTR_CHK>";
		var tmpMGSetChk = "";if(opener_obj.document.form.mgset_chk.checked){tmpMGSetChk = "Y";} else {tmpMGSetChk = "N";}
		sXmlEtc +="	<MGSET_CHK>"+tmpMGSetChk+"</MGSET_CHK>";
		//chungpa 20091203 추가됨 start
		sXmlEtc +=" <ATCH_CNTR>"+opener_obj.document.form.atch_cntr.value+"</ATCH_CNTR>";
		sXmlEtc +=" <ATCH_MGS>"+opener_obj.document.form.atch_mgs.value+"</ATCH_MGS>";
		//chungpa 20091203 추가됨 end
		var tmpBareChk = "";if(opener_obj.document.form.bare_chk.checked){tmpBareChk = "Y";} else {tmpBareChk = "N";}
		sXmlEtc +="	<BARE_CHK>"+tmpBareChk+"</BARE_CHK>";
		var tmpDamageChk = "";if(opener_obj.document.form.damage_chk.checked){tmpDamageChk = "Y";} else {tmpDamageChk = "N";}
		sXmlEtc +="	<DAMAGE_CHK>"+tmpDamageChk+"</DAMAGE_CHK>";
		var tmpLStayChk = "";if(opener_obj.document.form.lstay_chk.checked){tmpLStayChk = "Y";} else {tmpLStayChk = "N";}
		sXmlEtc +="	<LSTAY_CHK>"+tmpLStayChk+"</LSTAY_CHK>";
		
		sXmlEtc +="	<AGREEMENT_NO>"+opener_obj.document.form.agreement_no.value+"</AGREEMENT_NO>";
		sXmlEtc +="	<AGMT_LSTM_CD>"+opener_obj.document.form.agmt_lstm_cd.value+"</AGMT_LSTM_CD>";
		sXmlEtc +="	<ACT_ONH_DT>"+opener_obj.document.form.act_onh_dt.value+"</ACT_ONH_DT>";
		sXmlEtc +="	<AGMT_REF_NO>"+opener_obj.document.form.agmt_ref_no.value+"</AGMT_REF_NO>";
		sXmlEtc +="	<VNDR_ABBR_NM>"+opener_obj.document.form.vndr_abbr_nm.value+"</VNDR_ABBR_NM>";
		sXmlEtc +="	<CHSS_ALS_NO>"+opener_obj.document.form.chss_als_no.value+"</CHSS_ALS_NO>";
		sXmlEtc +="	<N2ND_CHSS_ALS_NO>"+opener_obj.document.form.n2nd_chss_als_no.value+"</N2ND_CHSS_ALS_NO>";
		
		sXmlEtc +="	<CHSS_RGST_STE_CD>"+opener_obj.document.form.chss_rgst_ste_cd.value+"</CHSS_RGST_STE_CD>";
		sXmlEtc +="	<CHSS_RGST_LIC_NO>"+opener_obj.document.form.chss_rgst_lic_no.value+"</CHSS_RGST_LIC_NO>";
		sXmlEtc +="	<CHSS_RGST_YR>"+opener_obj.document.form.chss_rgst_yr.value+"</CHSS_RGST_YR>";
		sXmlEtc +="	<CHSS_VEH_ID_NO>"+opener_obj.document.form.chss_veh_id_no.value+"</CHSS_VEH_ID_NO>";
		sXmlEtc +="	<CHSS_TIT_NO></CHSS_TIT_NO>";//삭제됨. 20091120 by chungpa "	<CHSS_TIT_NO>"+opener_obj.document.form.chss_tit_no.value+"</CHSS_TIT_NO>";
		
		var tmpChssRgstPrdCd = "";
		if(opener_obj.document.form.chss_rgst_prd_cd[0].checked==true){ tmpChssRgstPrdCd = "PMNT"; }
		else if(opener_obj.document.form.chss_rgst_prd_cd[1].checked==true){ tmpChssRgstPrdCd = "Fixed"; }
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
		)                     // RD 로 보낼 sheet 에 데이타가 없으면(기본데이터 없으면 데이터가 없는  것으로 판단함 ) Error
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
		rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolbar();
		//rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(0);
				
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);			

		rdObjects[0].SetRData(sXml);
		rdObjects[0].FileOpen(RD_path+'apps/alps/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1004.mrd',RDServer);
		//rdObjects[0].FileOpen('http://localhost:7001/hanjin/apps/alps/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1004.mrd',RDServer);
		
	}