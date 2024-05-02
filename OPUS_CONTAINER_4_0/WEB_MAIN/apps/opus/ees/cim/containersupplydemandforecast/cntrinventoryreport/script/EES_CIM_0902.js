/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0902.js
*@FileTitle  : EQ Operation Trend (Inventory Trend) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================
*/
	// common global variables
	var docObjects=new Array();
	var sheetCnt=0;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=docObjects[0];
         var sheetObject1=docObjects[1];
         var sheetObject2=docObjects[2];
         /*******************************************************/
         var formObject=document.form; 
         
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
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
    }
    /**
     * opening print screen
     */
	function rdOpen(){		
		var sXml="";		
		var i=0;
		var j=0; 
		var opener_obj=window.dialogArguments;	
		if (!opener_obj)  opener_obj=window.opener;
		if (!opener_obj) opener_obj=parent;
		var opener_sheet_obj1=opener_obj.sheet1;
		var fromObj=new Array();
		var rdObj=new Array();
        fromObj[1]=document.form;                            // putting in list for sending to RD
        rdObj[0]=opener_sheet_obj1;     
        sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		sheetCnt=1;
		for(i=0;i<1;i++){
			sheetCnt=i+1;
			if(rdObj[i].RowCount()==0){
				sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 				for(j=0;j<=rdObj[i].LastCol();j++){
					sXml +="<TD></TD>";
 				}
				sXml +="</TR></DATA></SHEET"+sheetCnt+">";
			}else{
				sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 					
			}			
		}
		var prt_cntr_tpsz_cd=opener_obj.document.form.prt_chk_cntr_tpsz_cd.value;
		if ( prt_cntr_tpsz_cd == 'true' ) {
			prt_cntr_tpsz_cd="";
		} else {
			prt_cntr_tpsz_cd=opener_obj.document.form.prt_chk_cntr_tpsz_cd.value
		}
		sXml +="<ETC>" ;  
		sXml +="	<CHK_CNTR_TPSZ_CD>"+prt_cntr_tpsz_cd+"</CHK_CNTR_TPSZ_CD>"
		sXml +="	<CNMV_STS_CD>"+opener_obj.document.form.prt_cnmv_sts_cd.value+"</CNMV_STS_CD>"
		sXml +="	<LSTM_CD>"+opener_obj.document.form.prt_lstm_cd.value+"</LSTM_CD>"
		var full_flg="";
		if ( opener_obj.document.form.prt_full_flg.value == 'Y' ) {
			full_flg="Full";
		} else if  ( opener_obj.document.form.prt_full_flg.value == 'N' ) {
			full_flg="MTY";
		}
		sXml +="	<FULL_FLG>"+full_flg+"</FULL_FLG>"
		var dmg_flg="Include";
		if ( opener_obj.document.form.prt_dmg_flg.value == 'Y' ) {
			dmg_flg="Only";
		} else if  ( opener_obj.document.form.prt_dmg_flg.value == 'N' ) {
			dmg_flg="Exclude";
		} 
		sXml +="	<DMG_FLG>"+dmg_flg+"</DMG_FLG>"
		var soc_cd="";
		if ( opener_obj.document.form.prt_soc_cd.value == '1' ) {
			soc_cd="Exclude";
		} else if  ( opener_obj.document.form.prt_soc_cd.value == '2' ) {
			soc_cd="Only";
		} else {
			soc_cd="Include";
		}
		sXml +="	<SOC_CD>"+soc_cd+"</SOC_CD>"
		if ( opener_obj.document.form.prt_cntr_hngr_rck_cd.value == 'Y' ) {
			sXml +="	<CNTR_HNGR_RCK_CD>Hanger Rack/Bar : √</CNTR_HNGR_RCK_CD>"
		} else {
			sXml +="	<CNTR_HNGR_RCK_CD>Hanger Rack/Bar :</CNTR_HNGR_RCK_CD>"
		}
		if ( opener_obj.document.form.prt_disp_flg.value == 'Y' ) {
			sXml +="	<DISP_FLG>DPSL :√</DISP_FLG>"
		} else {
			sXml +="	<DISP_FLG>DPSL :</DISP_FLG>"
		}
		if ( opener_obj.document.form.prt_d2_payld_flg.value == 'Y' ) {
			sXml +="	<D2_PAYLD_FLG>/D2_PAYLD_FLG>" 
		} else {
			sXml +="	<D2_PAYLD_FLG></D2_PAYLD_FLG>"
		}
		sXml +="	<CNTR_NO>"+opener_obj.document.form.prt_cntr_no.value+"</CNTR_NO>"
		sXml +="	<CNTR_USE_CO_CD>"+opener_obj.document.form.prt_cntr_use_co_cd.value+"</CNTR_USE_CO_CD>"
		var real_cntr_tpsz_cd=opener_obj.head_cntr_tpsz_cd.split("|")
		var ii=0;
		for ( var i=0; i<real_cntr_tpsz_cd.length; i++ ) {
			ii++;
			sXml +="	<HEAD_CNTR_TPSZ_CD"+ii+">"+real_cntr_tpsz_cd[i]+"</HEAD_CNTR_TPSZ_CD"+ii+">"
		}
		sXml +="</ETC>"
		sXml +="</SHEET>";
		if ( rdObj[0].RowCount()== "0")                     // Error in case of no data for sending to RD
		{
		    errMsg='No data found.';
		    showErrMessage(errMsg);
		    return;
		}
		
		viewer.setRData(sXml);
		// setting 'LETTER' print paper type in case of US 
		if(opener_obj.document.form.prt_cnt_cd.value == "US"){ 
			RDServer += "/rpaper [LETTER]";
		}		
		viewer.openFile(RD_path+'apps/opus/ees/cim/containersupplydemandforecast/cntrinventoryreport/report/EES_CIM_0902.mrd',RDServer, {timeout:1800});
	}