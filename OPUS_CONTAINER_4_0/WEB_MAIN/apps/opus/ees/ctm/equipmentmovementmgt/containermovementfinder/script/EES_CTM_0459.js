/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1949.jsp
*@FileTitle  : Load Factor by Trade-RD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
	// common global variables
	var docObjects=new Array();
	var sheetCnt=0;
//	var rdObjects=new Array();
//	var rdCnt=0;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=docObjects[0];
         var sheetObject1=docObjects[1];
         var sheetObject2=docObjects[2];
         /*******************************************************/
         var formObject=document.form;
//         var rdObject=rdObjects[0];
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
//       	rdObjects[0].ApplyLicense("0.0.0.0");
//		rdObjects[0].PrintDialog();
    }
    /**
     * opening print screen
     */
	function rdOpen(){
		var fromObj=new Array();
//		var rdObj=new Array();
        fromObj=document.form;                            // inputting as array for sending to RD
        cntr_no=opener.document.form.p_cntrno.value;
//        chk_dgt=opener.document.form.check_digit.value
        tpsz_cd=opener.document.form.ctnr_tpsz_cd.value;
        p_date1=opener.document.form.p_date1.value;
        p_date2=opener.document.form.p_date2.value;
        usr_id=opener.document.form.user_id.value;
        ofc_cd=opener.document.form.ofc_cd.value;
        cntCd=opener.document.form.cnt_cd.value;
//		rdObjects[0].AutoAdjust=true;
//		rdObjects[0].ApplyLicense("0.0.0.0");
//		rdObjects[0].HideToolBar();
//		rdObjects[0].HideStatusbar();
//		rdObjects[0].ViewShowMode(0);
		if (cntCd == 'US' )
			param="/rpaper [LETTER] /rp [" + cntr_no + "][" +"" + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
		else
			param="/rpaper [A4] /rp [" + cntr_no + "][" +"" + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
		//param = "/rp [" + cntr_no + chk_dgt + "][" +chk_dgt + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
//		rdObjects[0].SetBackgroundColor(255,255,255);
//		rdObjects[0].SetPageLineColor(255,255,255);
		viewer.openFile(RD_path+'apps/opus/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0459.mrd', RDServer+param, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0459.mrd', param);
	}