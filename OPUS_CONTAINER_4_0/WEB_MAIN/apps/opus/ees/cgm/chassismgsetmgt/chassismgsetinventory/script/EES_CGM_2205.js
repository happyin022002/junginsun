/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2205.js
*@FileTitle  : General Inventory(Print)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
	// common global variables
	var docObjects=new Array();
	var sheetCnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	//var sheet1="sheet1";
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
    function processButtonClick(){
         /***** use additional sheet var in case of more than 2 tap each sheet *****/
         var sheetObject=docObjects[0];
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
		if (!opener_obj) opener_obj = parent;
		var opener_sheet_obj1 = opener_obj.sheet1;
		var fromObj=new Array();
		var rdObj=new Array();
        fromObj[1]=document.form;                            // 
        rdObj[0]=opener_sheet_obj1;    
        sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		sheetCnt=1;
		//i = sheet count
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
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";		
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";
		sXmlEtc +="	<HEAD_LOCATION>"+opener_obj.combo_location.GetSelectText()+"</HEAD_LOCATION>";
		sXmlEtc +="	<HEAD_CRNT_LOC_CD>"+opener_obj.document.form.crnt_loc_cd.value+"</HEAD_CRNT_LOC_CD>";
		sXmlEtc +="	<HEAD_CRNT_YD_CD>"+opener_obj.document.form.crnt_yd_cd.value+"</HEAD_CRNT_YD_CD>";
		sXmlEtc +="	<HEAD_ACIAC_DIV_CD>"+opener_obj.aciac_div_cd.GetSelectText()+"</HEAD_ACIAC_DIV_CD>";
		sXmlEtc +="	<HEAD_EQ_TPSZ_CD>"+opener_obj.eq_tpsz_cd.GetSelectText()+"</HEAD_EQ_TPSZ_CD>";
		sXmlEtc +="	<HEAD_GROUP1>"+opener_obj.group1.GetSelectText()+"</HEAD_GROUP1>";
		sXmlEtc +=" <TOT_TOTAL>"+rdObj[0].GetSumText(0,"eq_tpsz_cd_total")+"</TOT_TOTAL>";
		sXmlEtc +="	<TOT_UMG>"+rdObj[0].GetSumText(0,"eq_tpsz_cd_umg")+"</TOT_UMG>";
		sXmlEtc +="	<TOT_CLG>"+rdObj[0].GetSumText(0,"eq_tpsz_cd_clg")+"</TOT_CLG>";
		var atch="";
		var bare="";
		var dmg="";
		var snd="";
		/* chungpa 20091125 radio에서 combo로 대체됨.
		//attached / bare
		if(opener_obj.document.form.rdo_atch_bare[0].checked)
		{
			atch="Y";
		}else
		{
			bare="Y";
		}
		sXmlEtc +="	<HEAD_ATCH>"+atch+"</HEAD_ATCH>";
		sXmlEtc +="	<HEAD_BARE>"+bare+"</HEAD_BARE>";
		//damage / sound
		var dmg_snd="";
		if(opener_obj.document.form.rdo_dmg_snd[0].checked)
		{
			dmg="Y";
		}else
		{
			snd="Y";
		}
		sXmlEtc +="	<HEAD_DMG>"+dmg+"</HEAD_DMG>";
		sXmlEtc +="	<HEAD_SND>"+snd+"</HEAD_SND>";
		*/
		if(opener_obj.atch_bare.GetSelectCode()== "ATTACHED")
		{
			atch="Y";
		}else if(opener_obj.atch_bare.GetSelectCode() == "BARE")
		{
			bare="Y";
		}
		if(opener_obj.dmg_snd.GetSelectCode()== "DAMAGE")
		{
			dmg="Y";
		}else if(opener_obj.dmg_snd.GetSelectCode()== "SOUND")
		{
			snd="Y";
		}
		sXmlEtc +="	<HEAD_ATCH>"+atch+"</HEAD_ATCH>";
		sXmlEtc +="	<HEAD_BARE>"+bare+"</HEAD_BARE>";
		sXmlEtc +="	<HEAD_DMG>"+dmg+"</HEAD_DMG>";
		sXmlEtc +="	<HEAD_SND>"+snd+"</HEAD_SND>";
		
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
		if ( rdObj[0].RowCount()== "0")                     
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
//		rdObjects[0].ApplyLicense("0.0.0.0");
		viewer.setRData(sXml);
		viewer.openFile(RD_path+'apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_2205.mrd',RDServer, {timeout:1800});
		//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_2205.mrd',RDServer);
	}
