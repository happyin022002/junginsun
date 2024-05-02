/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1106.js
*@FileTitle  : Movement Inquiry by Chassis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
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
         var sheetObject2=docObjects[2];
         /*******************************************************/
         var formObject=document.form; 
         var rdObject=rdObjects[0];
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
		//rdObjects[0].PrintDialog();
    }
    /**
     * printpage open
     * printpage open
     * print page open
     */
	function rdOpen(){		
		var sXml="";		
		var i=0;
		var j=0; 
		var opener_obj=window.dialogArguments;	
		if (!opener_obj) opener_obj=parent;
		var opener_sheet_obj1=opener_obj.sheet1;
		var opener_sheet_obj2=opener_obj.sheet2;
		var fromObj=new Array();
		var rdObj=new Array();
        fromObj[1]=document.form;                            // 
        rdObj[0]=opener_sheet_obj1;    
        rdObj[1]=opener_sheet_obj2;
        sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		sheetCnt=2;
		//i = sheet count
		for(i=0;i<2;i++){
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
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";		
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";
		sXmlEtc +="	<EQ_NO>"+opener_obj.document.form.eq_no.value+"</EQ_NO>";
		sXmlEtc +="	<STR_MVMT_DT>"+opener_obj.document.form.str_mvmt_dt.value+"</STR_MVMT_DT>";
		sXmlEtc +="	<END_MVMT_DT>"+opener_obj.document.form.end_mvmt_dt.value+"</END_MVMT_DT>";
		sXmlEtc +="	<EQ_TPSZ_CD>"+opener_obj.document.form.eq_tpsz_cd.value+"</EQ_TPSZ_CD>";
		sXmlEtc +="	<AGMT_LSTM_CD>"+opener_obj.document.form.agmt_lstm_cd.value+"</AGMT_LSTM_CD>";
		sXmlEtc +="	<CHSS_POOL_CD>"+opener_obj.document.form.chss_pool_cd.value+"</CHSS_POOL_CD>";
		sXmlEtc +="	<MFT_DT>"+opener_obj.document.form.onh_dt.value+"</MFT_DT>";
		sXmlEtc +="	<ACIAC_DIV_CD>"+opener_obj.document.form.aciac_div_cd.value+"</ACIAC_DIV_CD>";
		sXmlEtc +="</ETC>"
		sXml +=sXmlEtc;
		sXml +="</SHEET>";
		if ( rdObj[0].RowCount()== "0" && rdObj[1].RowCount()== "0")                     //
		{
		    errMsg='No data found.';
		    showErrMessage(errMsg);
		    return;
		}
//		rdObjects[0].AutoAdjust=true;
		//rdObjects[0].HideToolBar();
		//rdObjects[0].HideStatusBar();
//		rdObjects[0].ApplyLicense("0.0.0.0");
//		rdObjects[0].ViewShowMode(0);
//		rdObjects[0].SetBackgroundColor(255,255,255);
//		rdObjects[0].SetPageLineColor(255,255,255);			
		viewer.setRData(sXml);
		viewer.openFile(RD_path+'apps/opus/ees/cgm/movementmnrhistory/chassismovementhistory/report/EES_CGM_1106.mrd',RDServer, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/movementmnrhistory/chassismovementhistory/report/EES_CGM_1106.mrd',RDServer);
	}
