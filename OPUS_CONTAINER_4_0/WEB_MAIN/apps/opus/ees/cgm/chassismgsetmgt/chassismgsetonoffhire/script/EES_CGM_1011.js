/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1011.js
*@FileTitle  : On Off-Hire Status Summary Inquiry(Print)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/21
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
         var sheetObject = docObjects[0];
         var sheetObject1 = docObjects[1];
         /*******************************************************/
         var formObject = document.form; 
         var rdObject = rdObjects[0];

    	try {
    		var srcName = ComGetEvent("name");
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

    
    function CgmMakeRDXml(sheet_obj,no){
  	  //함수 인자 유효성 확인
  	  if (!sheet_obj) {
  		  ComFuncErrMsg("CimMakeRDXml2 function sheet_obj entry in not IBSheet.");
  			return "";
  	  }
  	  var rowXml="";
  	  var allXml="<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow()+"'>";
  	  var rowcount=sheet_obj.RowCount()+ sheet_obj.HeaderRows() - 1;
  	  for (ir=sheet_obj.HeaderRows(); ir <= sheet_obj.LastRow() -1; ir++) {
  		rowXml="<TR>";
  		for (ic=1; ic<= sheet_obj.LastCol(); ic++) {
  			rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,ic) + "]]></TD>";
  		}
  		rowXml += "</TR>";
  		allXml += rowXml;
  	  }
  	  allXml += "  </DATA></SHEET" + no + ">";
  	  return allXml;
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
		if (!opener_obj) opener_obj=parent; //이 코드 추가할것
		var opener_sheet_obj1 =  opener_obj.sheet1;
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[1] = document.form;                            // 
        rdObj[0] = opener_sheet_obj1;    
         
        sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		
    	sheetCnt=1;
		//i = sheet count
		for(i=0;i<1;i++){
			sheetCnt=i+1;
			if(rdObj[i].RowCount()==0){
				sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 				for(j=0;j<=rdObj[i].LastCol()+1;j++){
					sXml +="<TD></TD>";
 				}
				sXml +="</TR></DATA></SHEET"+sheetCnt+">";
			}else{
			//	sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 		
				sXml +=CgmMakeRDXml(rdObj[i],sheetCnt);
				
			}			
		}
		
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";		
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";
		sXmlEtc +="	<EVNT_DT_STR>"+opener_obj.document.form.evnt_dt_str.value+"</EVNT_DT_STR>";
		sXmlEtc +="	<EVNT_DT_END>"+opener_obj.document.form.evnt_dt_end.value+"</EVNT_DT_END>";
		sXmlEtc +="	<EQ_ASET_STS_CD>"+opener_obj.document.form.eq_aset_sts_cd.options[opener_obj.document.form.eq_aset_sts_cd.selectedIndex].text+"</EQ_ASET_STS_CD>";
		sXmlEtc +="	<LOCATION>"+opener_obj.combo_location.GetSelectText()+"</LOCATION>";
		sXmlEtc +="	<SCC_CD>"+opener_obj.document.form.scc_cd.value+"</SCC_CD>";
		sXmlEtc +="	<STS_EVNT_YD_CD>"+opener_obj.document.form.sts_evnt_yd_cd.value+"</STS_EVNT_YD_CD>";
		sXmlEtc +="	<HEAD_AGMT_LSTM_CD>"+opener_obj.agmt_lstm_cd.GetSelectCode()+"</HEAD_AGMT_LSTM_CD>";
		sXmlEtc +="	<KIND>"+opener_obj.document.form.kind.options[opener_obj.document.form.kind.selectedIndex].text+"</KIND>";
		sXmlEtc +="	<HEAD_VNDR_SEQ>"+opener_obj.document.form.vndr_seq.value+"</HEAD_VNDR_SEQ>";
		
		
		sXmlEtc +="	<TOT_TOTAL>"+rdObj[0].GetSumText("total")+"</TOT_TOTAL>";
		
		
		
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

		
		if ( rdObj[0].RowCount()  == 0)                     // 
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
//		rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolBar();
		//rdObjects[0].HideStatusBar();
//		rdObjects[0].ViewShowMode(0);
				
//		rdObjects[0].SetBackgroundColor(255,255,255);
//		rdObjects[0].SetPageLineColor(255,255,255);			
		viewer.setRData(sXml);
//		rdObjects[0].ApplyLicense("0.0.0.0");
		viewer.openFile(RD_path+'apps/opus/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1011.mrd',RDServer, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1011.mrd',RDServer);
		
	}