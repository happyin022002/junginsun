/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1090.js
*@FileTitle : General Inventory(Print)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
	
	// common global variables
	var docObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/* Event handler processing by button name */
    function processButtonClick(){
         /***** use additional sheet var in case of more than 2 tap each sheet *****/
         var sheetObject 	= docObjects[0];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
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
                errMsg = getMsg("TES22506" );
                showErrMessage(errMsg);
    		} else {
    			ComShowMessage(e);
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
		
		var sXml = "";		
		var i=0;
		var j=0; 
		var opener_obj=window.dialogArguments;
        if (!opener_obj) opener_obj=parent;			
		var opener_sheet_obj1=opener_obj.sheet1;
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[1] = document.form;                            // 
        rdObj[0] = opener_sheet_obj1;    
         
        sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		
		sheetCnt = 1;
		//i = sheet count
		for(i=0;i<1;i++){
			sheetCnt = i+1;
			if(rdObj[i].RowCount ==0){
				sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 				for(j=0;j<=rdObj[i].LastCol;j++){
					sXml +="<TD></TD>";
 				}
				sXml +="</TR></DATA></SHEET"+sheetCnt+">";
			}else{
				sXml += RD_GetDataSearchXml(rdObj[i],sheetCnt); //CimMakeRDXml2(rdObj[i], sheetCnt);			
			}			
		}
		
				
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";		
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";

		sXmlEtc +="	<HEAD_LOCATION>"+opener_obj.combo_location.GetText(parseInt(opener_obj.combo_location.GetSelectIndex()), 0)+"</HEAD_LOCATION>";
		sXmlEtc +="	<HEAD_CRNT_LOC_CD>"+opener_obj.document.form.crnt_loc_cd.value+"</HEAD_CRNT_LOC_CD>";
		sXmlEtc +="	<HEAD_CRNT_YD_CD>"+opener_obj.document.form.crnt_yd_cd.value+"</HEAD_CRNT_YD_CD>";

		sXmlEtc +="	<HEAD_ACIAC_DIV_CD>"+opener_obj.aciac_div_cd.GetText(parseInt(opener_obj.aciac_div_cd.GetSelectIndex()), 0)+"</HEAD_ACIAC_DIV_CD>";
		sXmlEtc +="	<HEAD_CHSS_POOL_CD>"+opener_obj.chss_pool_cd.GetText(parseInt(opener_obj.chss_pool_cd.GetSelectIndex()), 0)+"</HEAD_CHSS_POOL_CD>";
		
		var tmpDispFlag = "";if(opener_obj.document.form.include_np.checked){tmpDispFlag = "Y";} else {tmpDispFlag = "N";}
		sXmlEtc +="	<HEAD_INCLUDE_NP>"+tmpDispFlag+"</HEAD_INCLUDE_NP>";
		sXmlEtc +="	<HEAD_STAYING_DAYS>"+opener_obj.document.form.staying_days.value+"</HEAD_STAYING_DAYS>";
		
		sXmlEtc +="	<HEAD_GROUP1>"+opener_obj.group1.GetText(parseInt(opener_obj.group1.GetSelectIndex()), 0)+"</HEAD_GROUP1>";
		sXmlEtc +="	<HEAD_GROUP2>"+opener_obj.group2.GetText(parseInt(opener_obj.group2.GetSelectIndex()), 0)+"</HEAD_GROUP2>";
		sXmlEtc +="	<HEAD_GROUP3>"+opener_obj.group3.GetText(parseInt(opener_obj.group3.GetSelectIndex()), 0)+"</HEAD_GROUP3>";

		sXmlEtc +="	<HEAD_EQ_TPSZ_CD>"+opener_obj.document.form.eq_tpsz_cd.Text+"</HEAD_EQ_TPSZ_CD>";
		sXmlEtc +="	<HEAD_AGMT_LSTM_CD>"+opener_obj.document.form.agmt_lstm_cd.Text+"</HEAD_AGMT_LSTM_CD>";
		sXmlEtc +="	<HEAD_VNDR_SEQ>"+opener_obj.document.form.vndr_seq.value+"</HEAD_VNDR_SEQ>";
		sXmlEtc +="	<HEAD_CHSS_MVMT_STS_CD>"+opener_obj.document.form.chss_mvmt_sts_cd.Text+"</HEAD_CHSS_MVMT_STS_CD>";
		
		sXmlEtc +="	<TOT_TOTAL>"+rdObj[0].GetSumText(0,"total")+"</TOT_TOTAL>";
		
		var arrHeadType = opener_obj.document.form.head_eq_tpsz_cd.value.split("|");
		var kk = 1;
		for(var k = 0 ; k < arrHeadType.length ; k++){
			sXmlEtc +="	<TOT_CD" + kk + ">"+rdObj[0].GetSumText(0,"eq_tpsz_cd"+kk)+"</TOT_CD" + kk + ">";
			kk++;
		}
		
		var ii = 0;
		for ( var i = 0; i < arrHeadType.length; i++) { 
			ii++;
			sXmlEtc += "    <HEAD_CNTR_TPSZ_CD" + ii + ">" + arrHeadType[i] + "</HEAD_CNTR_TPSZ_CD" + ii + ">"
		}
		
		sXmlEtc +="</ETC>"
		sXml +=sXmlEtc;
		sXml +="</SHEET>";
		
		if ( rdObj[0].RowCount  == "0")                    
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
		
		
		//rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolbar();
		//rdObjects[0].HideStatusbar();
		//rdObjects[0].ViewShowMode(2);
		
//		rdObjects[0].AutoAdjust=true;
		//rdObjects[0].SetSheetHeight(500);
		
//		rdObjects[0].HideToolBar();
//		rdObjects[0].HideStatusBar();
//		rdObjects[0].ViewShowMode(0);
		//rdObjects[0].SetBackgroundColor(255,255,255);
		//rdObjects[0].SetPageLineColor(255,255,255);			
		viewer.setRData(sXml);
//		rdObjects[0].ApplyLicense("0.0.0.0");
		viewer.openFile(RD_path+'apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1090.mrd',RDServer, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1090.mrd',RDServer);
		
	}