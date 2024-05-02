/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0206.js
*@FileTitle  : COD Approval Detail at RSO Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0206 : VOP_OPF_0206 business script for
     */
    
   	/* Developer performance	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var strDate="";
	var mailToCarrier="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0]; // sheet1
		var sheetObject2 = sheetObjects[1]; // sheet2	
		var sheetObject3 = sheetObjects[2]; // sheet3

		var formObject = document.form;

		try {
			var srcName = ComGetEvent("name");
			if (ComGetBtnDisable(srcName)) return;

			switch (srcName) {
			case "btn_update" :
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
			case "btn_add" :
				var inx = sheetObject3.DataInsert(-1);
				row_add_sheet3(inx);
				break;
			case "btn_del" :
				ComRowHideDelete(sheetObject3, "sheet3_del_chk");
				break;
			case "btn_close" :
				ComClosePopup(); 
				break;
			case "btn_ok" :
				doActionIBSheet(sheetObject3, formObject, IBSAVE);
				break;
			case "btn_Mail" :
				// Get Receipt
				formObject.f_cmd.value = SEARCH09;
				var mailToXml = sheetObject1.GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObject));
				var mailStr = ComGetEtcData(mailToXml, "picEml");
				formObject.com_recipient.value = ComZeroToNull(mailStr);
				var obCssmVoyNoStr=ComGetEtcData(mailToXml, "obCssmVoyNo");
//				formObject.com_subject.value = "[" + ComGetObjValue(formObject.slan_cd) + "] COD Application " + sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_vsl_eng_nm") +" " + formObject.vvd.value.substring(4,9) + "(" + ComGetObjValue(formObject.bkg_no) + ")";
				formObject.com_subject.value = "[" + ComGetObjValue(formObject.slan_cd) + "] COD Application " + sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_vsl_eng_nm") +" " + obCssmVoyNoStr + "(" + ComGetObjValue(formObject.bkg_no) + ")";
				formObject.com_content.value = getMailContents(formObject, mailToXml);
				// ComSendMailModal();
				ComOpenWindowCenter("COM_MAIL_COMMON_POPUP_MODAL.do", null, 770, 560, true); 
				break;
			case "old_ts_route" :
				var vBkgNo = ComGetObjValue(formObject.bkg_no);
				var vCodRqstSeq = ComGetObjValue(formObject.cod_rqst_seq);
				var sUrl = "/opuscntr/ESM_BKG_0650.do?bkg_no=" + vBkgNo + "&cod_rqst_seq=" + vCodRqstSeq + "&op_cd=O";
				ComOpenPopup(sUrl, 710, 310, "", "0,0", true, false, "", "", "", "Transhipment Route and VVD");
				break;
			case "new_ts_route" :
				var vBkgNo = ComGetObjValue(formObject.bkg_no);
				var vCodRqstSeq = ComGetObjValue(formObject.cod_rqst_seq);
				var sUrl="/opuscntr/ESM_BKG_0650.do?bkg_no=" + vBkgNo + "&cod_rqst_seq=" + vCodRqstSeq + "&op_cd=N";
				ComOpenPopup(sUrl, 710, 310, "", "0,0", true, false, "", "", "", "Transhipment Route and VVD");
				break;
/*
			case "new_detail" :
			var sUrl = "/opuscntr/ESM_BKG_0156.do";
			ComOpenPopup(sUrl, 1024, 610, "", "0,0", false, false, "", "", "", "COD History");
			break;
*/
			case "btn_calculation" :
				doActionIBSheet(sheetObject3, formObject, IBSEARCH);
				break;
			case "btn_reject" :
/*
				document.getElementById('rejectRmkView').style.left=300+"px"; 
				document.getElementById('rejectRmkView').style.top=-200+"px"; //AnchorPosition_getPageOffsetTop(document.getElementById('rejectRmkView'))+10;
				document.getElementById('rejectRmkView').style.display="inline";
				// document.getElementById('rejectRmkView').style.overflow="hidden";
				document.getElementById('rejectRmkView').width=440+"px";
                document.getElementById('rejectRmkView').height=230+"px";
				document.rejectRmkIfrm.document.forms[0].rejectRmk.value=ComGetObjValue(formObject.rejectRmk);
*/
				ComOpenPopup("/opuscntr/VOP_OPF_1206.do?isPop=R&rejectRmk="+escape(ComGetObjValue(formObject.rejectRmk)), 440, 230, "", "0,0", true, false, "", "", "", "RejectRemark");
				break;
			case "new_detail" :
/*
				document.getElementById('codRemarkView').style.left = 300 + "px"; 
				document.getElementById('codRemarkView').style.top = 150 + "px";
				document.getElementById('codRemarkView').style.padding_top = 5 + "px";
				document.getElementById('codRemarkView').style.display = "inline";
				// document.getElementById('codRemarkView').style.overflow = "hidden";
				document.getElementById('codRemarkView').width = 400 + "px";
				document.getElementById('codRemarkView').height = 260 + "px";
				document.codRemarkIfrm.document.forms[0].rejectRmk.value = ComGetObjValue(formObject.codRemark);
*/
				ComOpenPopup("/opuscntr/VOP_OPF_1206.do?isPop=C&rejectRmk="+escape(ComGetObjValue(formObject.codRemark)), 400, 260, "", "0,0", true, false, "", "", "", "CODRemark");
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function getMailContents(formObj,mailToXml) { 		 
		var crrStr=ComGetEtcData(mailToXml, "carrierCd");
		var oldPodCdStr=ComGetEtcData(mailToXml, "oldPodCd");
		var oldPodFullNmStr=ComGetEtcData(mailToXml, "oldPodFullNm");
		var newPodCdStr=ComGetEtcData(mailToXml, "newPodCd");
		var newPodFullNmStr=ComGetEtcData(mailToXml, "newPodFullNm");
		var obCssmVoyNoStr=ComGetEtcData(mailToXml, "obCssmVoyNo");
		var contents="";
		contents += "Date : "+ sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_cre_dt");
		contents += "                                                                                                    <br>";
		contents += "To :  "+ crrStr +"                                                                         		 <br>";
		contents += "From : "+ ConstantMgr.getCompanyCode() +"                                                           <br>";
		contents += "                                                                                                    <br>";
//		contents += "Please kindly check this COD Application and offer Rehandling CNTR Q'ty each                        <br>";
//		contents += "CNTR Type & Size if acceptable.                                                                     <br>";
		contents += "Please kindly check this COD Application and offer Rehandling CNTR Q'ty each CNTR Type & Size if acceptable.<br>";
		contents += "                                                                                                    <br>";
		contents += "1. Ref No : "+ ComGetObjValue(formObj.bkg_no) +"                                                    <br>";
		contents += "2. Vessel : "+ sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_vsl_eng_nm") +"           <br>";
//		contents += "3. Voyage number : "+ formObj.vvd.value.substring(4,9) +"                                           <br>";
		contents += "3. Voyage number : "+ obCssmVoyNoStr +"                                           <br>";
		contents += "4. Container number & TPSZ & weight 										                          <br>";
		//& special cargo IND & stowage position 제거 
		contents += "                                                                                                    <br>";
		contents += "<table width=100% border=2 style='border-collapse: collapse; background-color: white; color: #272727;'>";
		contents += "	<tr style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>";
		contents += "		<td>Container Number</td>                                                                    ";
		contents += "		<td>TPSZ</td>                                                                                ";
		contents += "		<td>Weight</td>                                                                              ";
		//contents += "		<td>Container Condition</td>                                                                 ";
		//contents += "		<td>Stowage Position </td>                                                                   ";
		contents += "	</tr>                                                                                            ";
		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
			contents += "	<tr align=center>                                                                            ";
			contents += "		<td>"+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_no") +"</td>                            ";
			contents += "		<td>"+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_tpsz_cd")+" ["+sheetObjects[0].GetCellValue(i, "sheet1_cntr_tpsz_desc") +"]</td>                       ";
			contents += "		<td>"+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_wgt")  +"</td>                           ";
			//contents += "		<td>"+ sheetObjects[0].GetCellValue(i, "sheet1_condition") +"</td>                          ";
			//contents += "		<td>"+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_stwg_no") +"</td>                       ";
			contents += "				</tr>                                                                                        ";
		}	
		contents += "</table>                                                                                            <br>";
		contents += "5. Port of loading on VVD : "+ sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_old_pol") +"("+ sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "sheet2_pol_full_nm") +")				             <br>";
		contents += "6. Old Port of discharging on VVD : "+ oldPodCdStr +"("+ oldPodFullNmStr +")				     <br>";
		contents += "7. New Port of discharging on VVD : "+ newPodCdStr +"("+ newPodFullNmStr +")				     <br>";
		return contents; 
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
     * register Combo Object to array
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage(strDate) {
    	strDate=strDate;
		ComOpenWait(true);
 	    var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		//Auth Result
		initCombo(comboObjects[0]);
		initCombo(comboObjects[1]);
		initCombo(comboObjects[2]);
		searchPortCd(sheetObjects[2], -1, formObj.vvd.value);
		//COD Request Information retrieve
		doActionIBSheet(sheetObjects[3],document.form,IBROWSEARCH);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		ComOpenWait(false);
		//in case of vCodStsCd R, approval is available
		var vCodStsCd=formObj.cod_sts_cd.value;
		if( !(vCodStsCd == "R" || vCodStsCd == "W" || vCodStsCd == "N" || vCodStsCd == "Y") ){
			rso.SetEnable(false);//Approval RSO
			ComBtnDisable("btn_update"); //Approval RSO Update
			ComBtnDisable("btn_calculation");
			ComBtnDisable("btn_add");    //Row Add
			ComBtnDisable("btn_del");    //Delete
			authflag.SetEnable(false);
			rejectcd.SetEnable(false);
		}
//		ComBtnDisable("btn_reject");     //Reject Reason Remarks
		if(formObj.rejectcd.value!=""){
    		ComBtnEnable("btn_reject");
    	}else{
    		ComBtnDisable("btn_reject");
    		ComSetObjValue(formObj.rejectRmk, "");
    	}
		var vCodEmailSendYn=formObj.cod_email_send_yn.value;
		if(vCodEmailSendYn == "N")ComBtnDisable("btn_Mail") 
		else ComBtnEnable("btn_Mail") ;     // Mail
		if( !(vCodStsCd == "R" || vCodStsCd == "W" || vCodStsCd == "N" || vCodStsCd == "Y") ){
			ComBtnDisable("btn_ok");         //OK
		}
		if(comboObjects[1].GetSelectCode()== 'N'){
			rejectcd.SetEnable(true);
		}else{
			rejectcd.SetEnable(false);
		}
	}
 	/**
 	 * set Combo
 	 * param :  comboObj , comboNo　
 	 *adding case as numbers of counting combos
 	 */ 
 	function initCombo(comboObj) {
 		var i=0;
    	    switch(comboObj.options.id) {
 			case "authflag":
 				with(comboObj) {
 					comboObj.SetDropHeight(100);
 					InsertItem(i++, "", ""); 					
 					InsertItem(i++, "Y", "Y");
 					InsertItem(i++, "N", "N");
 					InsertItem(i++, "W", "W");
 					comboObj.SetSelectCode("");
 	        	}
 				break;
 			case "rso":
 				setRso_Combo(comboObj);
 				break;
 			case "rejectcd":
 				setRjct_Combo(comboObj);
 				comboObj.SetDropHeight(200);
 				break;
 		}
 	}
//	ComBtnDisable("btn_reject");
//	ComBtnEnable("btn_reject");
    /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
            	 
	            	 var HeadTitle="|Seq.|Container No.|Container Type|Cargo Type|Stowage Location|CNTR WGT|";
	            	 var prefix="sheet1_";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	            	              {Type:"Seq",       Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	            	              {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_stwg_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	  
	            	 InitColumns(cols);
	
	            	 SetWaitImageVisible(0);
	            	  SetEditable(0);
	            	  SetSheetHeight(100);
	            	  SetCountPosition(0);
	            	  
                 	}
                 break;
             case "sheet2":      // sheet1 init
                 with (sheetObj) {
            	   
            	    var HeadTitle="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|||||||||";
            	    var prefix="sheet2_";

            	    SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

            	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	    InitHeaders(headers, info);

            	    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rgn_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_por",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pol",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_del",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_por",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pol",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_del",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pol_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pod_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pol_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pod_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_rsn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rhnd_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rjct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_full_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pod_full_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pod_full_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trk_old_pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trk_new_pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trk_old_pod_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trk_new_pod_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rjct_rsn_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
            	     
            	    InitColumns(cols);

            	     SetWaitImageVisible(0);
            	      SetEditable(0);
            	      SetSheetHeight(100);
            	      SetCountPosition(0);

				   }
                 break;                 
             case "sheet3":      // sheet1 init
                 with (sheetObj) {
	            	
	            	 var HeadTitle="|Sel.|Seq.|Re-Handling Port|Re-Handling Port||Charge|Currency|Rate|CNTR TP/SZ|Full/Empty|CNTR Qty|Amount|bkg_no|cod_rqst_seq|cgo_cate_cd";
	            	 var prefix="sheet3_";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:30,  Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
            	              {Type:"Seq",       Hidden:0, Width:50,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_cd_rqst_seq" },
            	              {Type:"Combo",     Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cod_rhnd_port_cd",     KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Combo",     Hidden:0, Width:50,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cod_rhnd_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Combo",     Hidden:0, Width:100, Align:"Center",  ColMerge:0,   SaveName:prefix+"chg_cd",               KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Combo",     Hidden:0, Width:100, Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Float",     Hidden:0, Width:120, Align:"Right",   ColMerge:0,   SaveName:prefix+"chg_ut_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:3,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1,   EditLen:2 },
            	              {Type:"Combo",     Hidden:0, Width:70,  Align:"Center",  ColMerge:i,   SaveName:prefix+"cntr_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"PopupEdit", Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rat_as_qty",           keyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Float",     Hidden:0, Width:80,  Align:"Right",   ColMerge:0,   SaveName:prefix+"chg_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:3,   UpdateEdit:0,  InsertEdit:0 },
            	              //{Type:"Float",   Hidden:0, Width:140, Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_amt",              KeyField:0,   CalcLogic:"|sheet3_chg_ut_amt|*|sheet3_rat_as_qty|",Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:100, Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100, Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_seq",         KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:100, Align:"Center",  ColMerge:1,   SaveName:prefix+"cgo_cate_cd",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,  InsertEdit:1 } ];
            	  
	            	 InitColumns(cols);
	
	            	 SetWaitImageVisible(0);
	            	 SetEditable(1);
	            	 SetSheetHeight(100);
	            	 SetColProperty(prefix+"chg_cd", {ComboText:"RLO|DVC", ComboCode:"RLO|DVC"} );
	            	 SetColProperty(prefix+"cntr_cgo_tp_cd", {ComboText:"|E|F", ComboCode:"|E|F"} );
	            	 SetColProperty(0 ,prefix+"rat_as_qty" , {AcceptKeys:"[0123456789]" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,prefix+"rat_ut_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,prefix+"rat_as_qty", {ButtonUrl:"/opuscntr/img/opus/ico_w.gif"} );
	            	 
	 	        	 SetColProperty(prefix+"yd_cd", {ComboText:"", ComboCode:""} );
	            	 SetShowButtonImage(2);
	            	 SetCountPosition(0);


				   }
                 break;                 
             case "sheet5":      // sheet1 init
                 with (sheetObj) {
            	 
	//            	 (2, 0, 0, true);
	            	 var HeadTitle="|Seq.";
	            	 var prefix="sheet5_";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	            	              {Type:"Seq",       Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" } ];
	            	  
	            	 InitColumns(cols);
	
	            	 SetWaitImageVisible(0);
	            	 SetEditable(0);
	            	 SetSheetHeight(120);
 					
			   }
                 break;
         }
     }
   // handling process related Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH;
					var arr=new Array("sheet1_", "sheet2_", "sheet3_");
					var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i<arrXml.length; i++){ 
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					}
					break;						
				}else if(sheetObj.id == "sheet3"){
					formObj.f_cmd.value=SEARCH07;
		        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_");
					var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", sParam);
					if(sXml.length>0){ 
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
					break;
				}
			case IBROWSEARCH:      //Retrieve
				if ( sheetObj.id == "sheet4"){
			   		/*formObj.f_cmd.value=SEARCH01;
			   		var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
			   		//var vBayPlanCnt = ComGetEtcData(sXml,"BayPlanCnt");
			   		ComOpfGetMessageFromXml(sXml);
			   		//Freight & Charges for COD 시작
			   		//if( !vBayPlanCnt == "0"){
						formObj.f_cmd.value=SEARCH02;
			        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_");
						var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", sParam);
						var vBayPlanCnt=ComGetEtcData(sXml,"BayPlanCnt");
						if(sXml.length>0){ 
							sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
						}
			   		//}
					*/
			 		formObj.f_cmd.value=SEARCH04;
			 		var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
					var arrCombo=ComXml2ComboString(sXml, "curr_cd", "curr_cd");
					if(arrCombo != null){
						sheetObjects[2].SetColProperty("sheet3_curr_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[0]} );
					} 
					break;						
				}
			case IBSAVE:        //save
				if ( sheetObj.id == "sheet2"){
					formObj.f_cmd.value=MODIFY;
					formObj.rgn_cd.value=comboObjects[0].GetSelectCode();
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet2_rgn_cd",comboObjects[0].GetSelectCode());
					sheetObj.DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"),-1,false,true);
				}else if(validateForm(sheetObj,formObj,sAction))
				{
	        		if(comboObjects[1].GetSelectCode()== "N"){
						sheetObjects[4].DataInsert(-1);
						formObj.codstscd.value=comboObjects[1].GetSelectCode();
	        			formObj.f_cmd.value=MULTI;
	        			sheetObjects[4].DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),-1,false,true);
	        		}else if(comboObjects[1].GetSelectCode()== "W"){
						formObj.codstscd.value=comboObjects[1].GetSelectCode();
	        			formObj.f_cmd.value=MULTI;
	        			//sheetObj.DoSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),-1,false,true);
	        			//mySheet.DoSave(PageUrl, [SubParam], [Col] , [Quest], [UrlEncode]))  
	        			//mySheet.DoAllSave(PageUrl, [SubParam], [UrlEncode]) 
	        			//sheetObj.DoAllSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"), true);
						var sParam=ComGetSaveString(sheetObjects, true, true);
						if( sParam == ""){ return;}
						var sXml=sheetObj.GetSaveData("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + sParam, true);
						sheetObj.LoadSaveData(sXml);
	        		}else{
	        			formObj.codstscd.value=comboObjects[1].GetSelectCode();
	        			formObj.f_cmd.value=MULTI;
	        			//sheetObj.DoAllSave("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"), true);
						var sParam=ComGetSaveString(sheetObjects, true, true);
						if( sParam == ""){ return;}
						var sXml=sheetObj.GetSaveData("VOP_OPF_0206GS.do", FormQueryString(formObj) + "&" + sParam, true);
						sheetObj.LoadSaveData(sXml);
	        		}
				}
				break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 var prefix = "sheet3_";
    	 var sheet3 = sheetObjects[2];
         with(formObj){
    		if(comboObjects[1].GetSelectCode()== "N"){
    			if(comboObjects[2].GetSelectCode()== ""){
					ComShowCodeMessage("OPF50009", "Reject Reason");
					ComAlertFocus(formObj.rejectcd, "");
    				return false;			
    			}
    		}
    		// 필수체크
    		for(var i=sheet3.HeaderRows(); i <= sheet3.RowCount(); i++) {
    			var vCod_rhnd_port_cd = sheet3.GetCellValue(i, prefix+"cod_rhnd_port_cd");
    			var vYd_cd = sheet3.GetCellValue(i, prefix+"yd_cd");
    			var vChg_cd = sheet3.GetCellValue(i, prefix+"chg_cd");
    			var vCurr_cd = sheet3.GetCellValue(i, prefix+"curr_cd");
    			var vChg_ut_amt = sheet3.GetCellValue(i, prefix+"chg_ut_amt");
    			var vRat_ut_cd = sheet3.GetCellValue(i, prefix+"rat_ut_cd");
    			var vCntr_cgo_tp_cd = sheet3.GetCellValue(i, prefix+"cntr_cgo_tp_cd");
    			var vRat_as_qty = sheet3.GetCellValue(i, prefix+"rat_as_qty");
    			if(vCod_rhnd_port_cd == '' || vYd_cd == '') {
    				ComShowCodeMessage("OPF50025", i, "Re-Handling Port Code");
    				return false;
    			}
    			if(vChg_cd == '') {
    				ComShowCodeMessage("OPF50025", i, "Charge");
    				return false;
    			}
    			if(vCurr_cd == '') {
    				ComShowCodeMessage("OPF50025", i, "Currency");
    				return false;
    			}
    			if(parseFloat(vChg_ut_amt) == 0.0) {
    				ComShowCodeMessage("OPF50025", i, "Rate");
    				return false;
    			}
    			if(vChg_cd != 'DVC') {
//	    			if(vRat_ut_cd == '') {
//	    				ComShowCodeMessage("OPF50025", i, "CNTR TP/SZ");
//	    				return false;
//	    			}
//	    			if(vCntr_cgo_tp_cd == '') {
//	    				ComShowCodeMessage("OPF50025", i, "Full/Empty");
//	    				return false;
//	    			}
	    			if(vRat_as_qty == '' || parseInt(vRat_as_qty) == 0) {
	    				ComShowCodeMessage("OPF50025", i, "CNTR Qty.");
	    				return false;
	    			}
    			}
    		}
         }
         return true;
     }
     /* get RSO combo */
 	function setRso_Combo(comboObj){
 	    var formObj=document.form;
 		formObj.f_cmd.value=SEARCH01;
 		var sXml=sheetObjects[3].GetSearchData("VOP_OPF_0033GS.do", FormQueryString(formObj));
 		ComXml2ComboItem(sXml, comboObj, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
 		//comboObj.Code = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_rgn_cd");
 	}
    /* get Reject Reason combo */
 	function setRjct_Combo(comboObj){
 	    var formObj=document.form;
 		formObj.f_cmd.value=SEARCH02;
  		var sXml=sheetObjects[3].GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
 		ComXml2ComboItem(sXml, comboObj, "cod_rjct_cd", "cod_rjct_cd|cod_rjct_desc");
//		formObj.rejectcd.SetEnable(0);
 		//rejectcd.SetEnable(false);
 	}  	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		if(sheetObj.RowCount()> 0){
			ComSetObjValue(formObj.cntr_no, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cntr_no"));
		}
	}
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		if(sheetObj.RowCount()> 0){
			ComSetObjValue(formObj.old_por, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_old_por"));
			ComSetObjValue(formObj.old_pol, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_old_pol"));
			ComSetObjValue(formObj.old_pod, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_old_pod"));
			ComSetObjValue(formObj.old_del, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_old_del"));
			ComSetObjValue(formObj.new_por, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_new_por"));
			ComSetObjValue(formObj.new_pol, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_new_pol"));
			ComSetObjValue(formObj.new_pod, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_new_pod"));
			ComSetObjValue(formObj.new_del, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_new_del"));
			ComSetObjValue(formObj.old_vvd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_old_vvd"));
			ComSetObjValue(formObj.new_vvd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_new_vvd"));
			ComSetObjValue(formObj.cod_rqst_rsn_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_cod_rqst_rsn_cd"));
			    		//ComSetObjValue(formObj.cod_rhnd_port_cd, sheetObj.CellValue(sheetObj.SelectRow, "sheet2_cod_rhnd_port_cd"));   		
			ComSetObjValue(formObj.codRemark, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_diff_rmk"));
			comboObjects[0].SetSelectCode(sheetObjects[1].GetCellValue(sheetObj.GetSelectRow(), "sheet2_rgn_cd"));
			comboObjects[1].SetSelectCode(sheetObjects[1].GetCellValue(sheetObj.GetSelectRow(), "sheet2_cod_sts_cd"));
			comboObjects[2].SetSelectCode(sheetObjects[1].GetCellValue(sheetObj.GetSelectRow(), "sheet2_cod_rjct_cd"));
			ComSetObjValue(formObj.rcvr_usr_id, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_cre_usr_id"));
			ComSetObjValue(formObj.rcvr_usr_nm, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_cre_usr_nm"));
			ComSetObjValue(formObj.rejectRmk, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_cod_rjct_rsn_rmk"));
			ComSetObjValue(formObj.codRemark, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet2_diff_rmk"));
		}
	}
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		var prefix = "sheet3_";
//		if( formObj.f_cmd.value == SEARCH07 ){
//			if(sheetObj.RowCount()== 0){
//				var inx=sheetObj.DataInsert(-1);
//				row_add_sheet3(inx);
//			}else{
//				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
//					initReHandlingSheet(sheetObj, i, "INIT");					
//				}
//			}
//		}else{
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
				initReHandlingSheet(sheetObj, i, "INIT");	
			}
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount();i++) {
				var codRhndPortYdCd = sheetObj.GetCellValue(i, prefix+"cod_rhnd_port_yd_cd");
				if(codRhndPortYdCd != "") {
					sheetObj.SetCellValue(i, prefix+"cod_rhnd_port_cd",codRhndPortYdCd.substring(0,5), 0);
					setTmnlCombo(sheetObj, i, codRhndPortYdCd.substring(0,5));
					if(codRhndPortYdCd.length == 7){
						sheetObj.SetCellValue(i, prefix+"yd_cd",codRhndPortYdCd.substring(5,7), 0);
					}
				}
				// currency
				setCurrencyCombo(sheetObj, i, codRhndPortYdCd.substring(0,5));
			}
//		}
	}
	
	function initReHandlingSheet(sheetObj, Row, flag){
		
		var chgCd = sheetObj.GetCellValue(Row, "sheet3_chg_cd");
		
		if(flag == "INIT"){
			var chgUtAmt = sheetObj.GetCellValue(i, "sheet3_rat_ut_cd");
			var ratAsQty = sheetObj.GetCellValue(i, "sheet3_rat_as_qty");
			
			if(chgCd == "DVC"){
				sheetObj.InitCellProperty(Row, "sheet3_rat_as_qty", {Type:"Text"} );
				
				sheetObj.SetCellValue(i, "sheet3_chg_amt"			, chgUtAmt, 0);				
			}else{
				
				sheetObj.InitCellProperty(Row ,"sheet3_rat_as_qty", {Type:"PopupEdit", ButtonUrl:"/opuscntr/img/opus/ico_w.gif"} );
				
				sheetObj.SetCellValue(i, "sheet3_chg_amt"			, Number(chgUtAmt) * Number(ratAsQty), 0);
			}
		}else{
			
			if(chgCd == "DVC"){
				sheetObj.InitCellProperty(Row, "sheet3_rat_as_qty", {Type:"Text"} );
				
				sheetObj.SetCellValue(Row, "sheet3_chg_ut_amt"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_rat_ut_cd"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_cntr_cgo_tp_cd"	, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_rat_as_qty"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_chg_amt"			, "", 0);
				
				sheetObj.SetCellEditable(Row, "sheet3_rat_ut_cd"		, 0);
				sheetObj.SetCellEditable(Row, "sheet3_cntr_cgo_tp_cd"	, 0);
				sheetObj.SetCellEditable(Row, "sheet3_rat_as_qty"		, 0);
				
				var formObj = document.form;
				formObj.f_cmd.value=SEARCH10;
	        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_");
				var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", sParam);
				
				if(ComOpfGetMessageFromXml(sXml) != ""){
   	 				ComShowMessage(ComOpfGetMessageFromXml(sXml));
   	 			}else{
   	 				sheetObj.SetCellValue(Row, "sheet3_curr_cd"		,ComGetEtcData(sXml,"etcDvcCurrCd")		, 0);
   	 				sheetObj.SetCellValue(Row, "sheet3_chg_ut_amt"	,ComGetEtcData(sXml,"etcDvcChgUtAmt")	, 0);
   	 				sheetObj.SetCellValue(Row, "sheet3_chg_amt"		, ComGetEtcData(sXml,"etcDvcChgUtAmt")	, 0);
   	 			}				
				
			}else{
				sheetObj.InitCellProperty(Row ,"sheet3_rat_as_qty", {Type:"PopupEdit", ButtonUrl:"/opuscntr/img/opus/ico_w.gif"} );
				
				sheetObj.SetCellValue(Row, "sheet3_chg_ut_amt"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_rat_ut_cd"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_cntr_cgo_tp_cd"	, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_rat_as_qty"		, "", 0);
				sheetObj.SetCellValue(Row, "sheet3_chg_amt"			, "", 0);
				
				sheetObj.SetCellEditable(Row, "sheet3_rat_ut_cd"		, 1);
				sheetObj.SetCellEditable(Row, "sheet3_cntr_cgo_tp_cd"	, 1);
				sheetObj.SetCellEditable(Row, "sheet3_rat_as_qty"		, 1);
			}
		}
	}
	
	//in case of changing Freight & Charges for COD - Grid , put in action
	function sheet3_OnChange(sheetObj, Row, Col, Value){
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var prefix="sheet3_";
		if(sName == prefix+"chg_cd"){
			initReHandlingSheet(sheetObj, Row, "CHG");
		}else if (sName == prefix+"rat_ut_cd" || sName == prefix+"cntr_cgo_tp_cd") {			
			//in case of inputting CNTR Type/SIZE , put in action
			if(sheetObj.GetCellValue(Row, prefix+"rat_ut_cd") != ""){
				ComSetObjValue(formObj.rat_ut_cd, sheetObj.GetCellValue(Row, prefix+"rat_ut_cd"));
				ComSetObjValue(formObj.tpsz, ComGetObjValue(formObj.rat_ut_cd));
				//in case of CNTR Type/SIZE, check validation
				formObj.f_cmd.value=SEARCH06;
    	 		var sXml2=sheetObjects[3].GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
   	 			if(ComOpfGetMessageFromXml(sXml2) != ""){
	 				ComShowMessage(ComOpfGetMessageFromXml(sXml2));
	 				ComSetObjValue(formObj.tpsz, "");
	 				sheetObj.SelectCell(Row, Col, true, "");
   	 			}else{
   	 				ComSetObjValue(formObj.cntr_cgo_tp_cd, sheetObj.GetCellValue(Row, prefix+"cntr_cgo_tp_cd"));
   	 				//retrieve CHR, CUR, Rate
//					formObj.f_cmd.value=SEARCH03;
			    	var sParam=Array();
				  	sParam[0]="bkg_no="+sheetObj.GetCellValue(Row, prefix+"bkg_no");
				  	sParam[1]="chg_cd="+sheetObj.GetCellValue(Row, prefix+"chg_cd");
				  	sParam[2]="rat_ut_cd="+sheetObj.GetCellValue(Row, prefix+"rat_ut_cd");
				  	sParam[3]="rat_as_qty="+sheetObj.GetCellValue(Row, prefix+"rat_as_qty");
				  	sParam[4]="cgo_cate_cd="+sheetObj.GetCellValue(Row, prefix+"cgo_cate_cd");
				  	sParam[5]="cod_rqst_seq="+sheetObj.GetCellValue(Row, prefix+"cod_rqst_seq");
				  	sParam[6]="cntr_cgo_tp_cd="+sheetObj.GetCellValue(Row, prefix+"cntr_cgo_tp_cd");
				  	sParam[7]="cod_rhnd_port_cd="+sheetObj.GetCellValue(Row, prefix+"cod_rhnd_port_cd");
				  	sParam[8]="f_cmd="+SEARCH03;
 	   	 			var sXml=sheetObjects[3].GetSearchData("VOP_OPF_0206GS.do", sParam.join("&"));
	   	 			if(ComOpfGetMessageFromXml(sXml) != ""){
//	   	 				ComShowMessage(ComOpfGetMessageFromXml(sXml));
	   	 			}else{
	   	 				/** 
	   	 				sheetObj.SetCellValue(Row, "sheet3_chg_cd",ComGetEtcData(sXml,"etcChgCd"));
	   	 				sheetObj.SetCellValue(Row, "sheet3_curr_cd",ComGetEtcData(sXml,"etcCurrCd"));
	   	 				sheetObj.SetCellValue(Row, "sheet3_chg_ut_amt",ComGetEtcData(sXml,"etcChgUtAmt"));
	   	 				 **/
	   	 				sheetObj.SetCellValue(Row, prefix+"curr_cd",ComGetEtcData(sXml,"etcCurrCd"));
	   	 				sheetObj.SetCellValue(Row, prefix+"chg_ut_amt",ComGetEtcData(sXml,"etcChgUtAmt"));
	   	 			}
	   	 			//initializie F/M 
	 				ComSetObjValue(formObj.cntr_cgo_tp_cd, "");
   	 			}
			}
		}else if(sName == prefix+"chg_ut_amt"){
			var chgCd = sheetObj.GetCellValue(Row, prefix+"chg_cd");
			
			var chgUtAmt = Value; //sheetObj.GetCellValue(Row, "sheet3_rat_ut_cd");
			var ratAsQty = sheetObj.GetCellValue(Row, prefix+"rat_as_qty");
			
			if(chgCd == "DVC"){
				sheetObj.SetCellValue(Row, prefix+"chg_amt", chgUtAmt	, 0);
			}else{
				sheetObj.SetCellValue(Row, prefix+"chg_amt", Number(chgUtAmt) * Number(ratAsQty)		, 0);
			}
			
		}else if(sName == prefix+"rat_as_qty"){
			
			sheetObj.SetCellValue(Row, prefix+"chg_amt", Number(sheetObj.GetCellValue(Row, prefix+"chg_ut_amt")) * Number(Value)		, 0);
		}else if (sName == prefix+"cod_rhnd_port_cd") {
			sheetObj.SetCellValue(Row, prefix+"cod_rhnd_port_yd_cd",Value+"  ",0);//clear
			setTmnlCombo(sheetObj, Row, Value);
			sheetObj.SetCellValue(Row, prefix+"yd_cd",'', 0);
			// currency
			setCurrencyCombo(sheetObj, Row, sheetObj.GetCellValue(Row, prefix+"cod_rhnd_port_cd"));
		}else if (sName == prefix+"yd_cd") {
			sheetObj.SetCellValue(Row, prefix+"cod_rhnd_port_yd_cd",sheetObj.GetCellValue(Row, prefix+"cod_rhnd_port_cd")+sheetObj.GetCellValue(Row, prefix+"yd_cd"), 0);
		}
		if(sheetObj.GetCellValue(Row, prefix+"ibflag") == "R"){
			sheetObj.SetCellValue(Row, prefix+"del_chk",0);
		}		
	}
	//modifying data input before is unavailable
	function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var formObj=document.form;
		//if(sheetObj.CellValue(NewRow, "sheet3_ibflag") == "R"){
		if(formObj.cod_sts_cd.value == "R" || formObj.cod_sts_cd.value == "N" || formObj.cod_sts_cd.value == "Y" || formObj.cod_sts_cd.value == "W"){
			sheetObj.SetEditable(1);
		}else{
			sheetObj.SetEditable(0);
		}
	}

	// [t2sheet1] Event occured after retrieving by retrieve method
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		var formObj = document.form;
        //InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,	prefix+"rat_ut_cd",		false,	"",		dfNone,		0,	true,	true, 2);
        //InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"cntr_cgo_tp_cd",false,	"",		dfNone,		0,	true,	true);
		var sName=sheetObj.ColSaveName(Col);
		if (sName == "sheet3_rat_as_qty"){
			if(sheetObj.GetCellValue(Row, "sheet3_rat_ut_cd") == ""){
				ComShowCodeMessage("OPF50009", "[CNTR Type/SIZE]");
				sheetObj.SelectCell(Row, "sheet3_rat_ut_cd", true, "");
				return false;
			}
		}
		with(sheetObj)
		{
			ComSetObjValue(formObj.tpsz, sheetObj.GetCellValue(Row, "sheet3_rat_ut_cd"));
			ComSetObjValue(formObj.cntr_cgo_tp_cd, sheetObj.GetCellValue(Row, "sheet3_cntr_cgo_tp_cd"));
			ComSetObjValue(formObj.cgo_cate_cd, sheetObj.GetCellValue(Row, "sheet3_cgo_cate_cd"));
	 		formObj.f_cmd.value=SEARCH08;
 	 		var sXml=sheetObjects[3].GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
            var result = ComGetEtcData(sXml,"etcContainerList");
            if(result == '') {
            	ComShowCodeMessage("OPF50028");
            } else {
            	ComSetObjValue(formObj.qty_list, result);
            	ComOpenPopup("/opuscntr/VOP_OPF_1206.do?isPop=Q", 440, 230, "", "0,0", true, false, "", "", "", "Quantity List");
//    			document.getElementById('qtyView').style.left=50; 
//    			document.getElementById('qtyView').style.top=50;
//    			document.getElementById('qtyView').style.visibility="visible";
//    			document.getElementById('qtyView').style.overflow="visible";
//    			document.getElementById('qtyView').style.display="block";
//    			document.getElementById('qtyView').width=400;
//                document.getElementById('qtyView').height=260;
//            	document.frames("qtyIfrm").document.forms[0].rejectRmk.value=ComGetEtcData(sXml,"etcContainerList");
            }
		}
	}
	//in case of changing Row Add - Freight & Charges for COD - Grid, put in action
	function row_add_sheet3(row){
		var formObj=document.form;
		sheetObjects[2].SetCellValue(row, "sheet3_bkg_no",ComGetObjValue(formObj.bkg_no));
		sheetObjects[2].SetCellValue(row, "sheet3_cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq));
		sheetObjects[2].SetCellValue(row, "sheet3_cgo_cate_cd","DR");
		/*var vRow=sheetObjects[2].GetSelectRow();
		formObj.f_cmd.value=SEARCH05;
		var sXml=sheetObjects[3].GetSearchData("VOP_OPF_0206GS.do", FormQueryString(formObj));
		sheetObjects[2].SetCellValue(vRow, "sheet3_bkg_no",ComGetObjValue(formObj.bkg_no));
		sheetObjects[2].SetCellValue(vRow, "sheet3_cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq));
		sheetObjects[2].SetCellValue(vRow, "sheet3_cgo_cate_cd",ComGetEtcData(sXml,"etcCgoCateCd"));
		if(ComGetEtcData(sXml,"etcChgCd") == undefined){
			ComShowMessage(ComOpfGetMessageFromXml(sXml));
		}else{
			sheetObjects[2].SetCellValue(vRow, "sheet3_chg_cd",ComGetEtcData(sXml,"etcChgCd"));
			sheetObjects[2].SetCellValue(vRow, "sheet3_curr_cd",ComGetEtcData(sXml,"etcCurrCd"));
			sheetObjects[2].SetCellValue(vRow, "sheet3_chg_ut_amt",ComGetEtcData(sXml,"etcChgUtAmt"));
			sheetObjects[2].SetCellValue(vRow, "sheet3_rat_ut_cd",ComGetEtcData(sXml,"etcRatUtCd"));
			sheetObjects[2].SetCellValue(vRow, "sheet3_rat_as_qty",ComGetEtcData(sXml,"etcRatAsQty"));
		}*/
		searchPortCd(sheetObjects[2], row, formObj.vvd.value);
	}	
	// in case of changing Auth Result - Multi Combo, put in action
    function authflag_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code)
    {
    	var formObj=document.form;
    	var vMsg_ctnt="";
    	if(text == ""){
    		ComBtnDisable("btn_reject");
    		ComSetObjValue(formObj.rejectRmk, "");
    		ComBtnDisable("btn_ok");
    		rejectcd.SetEnable(false);
    	//	comboObjects[2].SetSelectCode("");
    	}else{	
    		if(text == "N"){
//    			formObj.rejectcd.SetEnable(1);
    			//rejectcd.SetEnable(false);
    		}else if(text == "Y"){
//    			formObj.rejectcd.SetEnable(0);
    			//rejectcd.SetEnable(false);
    			//rejectcd.SetEnable(true);
    			vMsg_ctnt += "<< COD Approval Notice (BKG No. : "+ ComGetObjValue(formObj.bkg_no)  +") >>\n\n";
    			vMsg_ctnt += "Please be advised that your COD application has been approved.\n\n";
    			vMsg_ctnt += " - BKG No.: "+ ComGetObjValue(formObj.bkg_no) +"\n";
    			for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].RowCount(); i++){
    				if(i ==sheetObjects[0].HeaderRows()){
    					vMsg_ctnt += " - Container No.: "+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_no") +"\n";
    				}else{
    					vMsg_ctnt += " "+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_no") +"\n";
    				}
    			}
    			//vMsg_ctnt += " - Container No.: "+ ComGetObjValue(formObj.cntr_no) +"\n";
    			vMsg_ctnt += "\n";
    			vMsg_ctnt += "Please reply your final confirmation ASAP.";
    			ComSetObjValue(formObj.msg_ctnt, vMsg_ctnt);    			
    		}
    		ComBtnEnable("btn_ok");
    	}
    	    	
    
    	if(formObj.authflag.value=="N"){
    		rejectcd.SetEnable(true);
    	}else{
    		rejectcd.SetEnable(false);
    		initCombo(comboObjects[2]);
    		ComBtnDisable("btn_reject");
    		ComSetObjValue(formObj.rejectRmk, "");
    	}
    }
    // in case of changing Reject Reason - Multi Combo , put in action
    function rejectcd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code)
    {
    	var formObj=document.form;    	
    	var vMsg_ctnt="";
    	if(text == ""){
    		//ComBtnDisable("btn_reject");
    	}else{	
   			//ComBtnEnable("btn_reject");
			vMsg_ctnt += "<< COD Rejection Notice (BKG No. : "+ ComGetObjValue(formObj.bkg_no)  +") >>\n\n";
			vMsg_ctnt += "Please be advised that your COD application has been rejected.\n";
			vMsg_ctnt += "For details please refer to followings.\n\n";
			vMsg_ctnt += " - BKG No.: "+ ComGetObjValue(formObj.bkg_no) +"\n";
			//vMsg_ctnt += " - Container No.: "+ ComGetObjValue(formObj.cntr_no) +"\n";
			for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].RowCount(); i++){
				if(i ==sheetObjects[0].HeaderRows()){
					vMsg_ctnt += " - Container No.: "+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_no") +"\n";
				}else{
					vMsg_ctnt += " "+ sheetObjects[0].GetCellValue(i, "sheet1_cntr_no") +"\n";
				}
			}
			vMsg_ctnt += " - Reject Reason : "+ comboObj.GetText(code,1) +"\n";
			vMsg_ctnt += "\n";
			vMsg_ctnt += "Please reply your final confirmation ASAP.";
			ComSetObjValue(formObj.msg_ctnt, vMsg_ctnt);
    	}
    	
    	if(formObj.rejectcd.value!=""){
    		ComBtnEnable("btn_reject");
    	}else{
    		ComBtnDisable("btn_reject");
    		ComSetObjValue(formObj.rejectRmk, "");
    	}
    }    
    function sheet3_OnSaveEnd(ErrMsg){
 		var opener=window.dialogArguments;
		if (!opener) 
			opener=parent;
		opener.call_0206(); 		
 		ComClosePopup();
 	}    
 	function sheet5_OnSaveEnd(ErrMsg){
 		var opener=window.dialogArguments;
		if (!opener)
			opener=parent;
		opener.call_0206();
 		ComClosePopup(); 
 	}  
 	
    function searchPortCd(sheetObj, Row, vvd) { 
    	if(vvd.length != 9) {
    		return false;
    	}
    	var vsl_cd = vvd.substring(0, 4);
    	var skd_voy_no = vvd.substring(4, 8);
    	var skd_dir_cd = vvd.substring(8, 9);
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+vsl_cd;
	  	sParam[1]="skd_voy_no="+skd_voy_no;
	  	sParam[2]="skd_dir_cd="+skd_dir_cd;
	  	sParam[3]="f_cmd="+SEARCH10;
	  	sheetObj.SetWaitImageVisible(0);
	  	var portXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	  	sheetObj.SetWaitImageVisible(1);
		setPortCombo(sheetObj, Row, portXml);
		return true;
    }
    
    function setPortCombo(sheetObj, Row, sXml) {
    	var prefixs = "sheet3_";
    	var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var loc_cds=ComOpfXml2Array(sXml, "loc_cd");
    		var clptIndSeqs=ComOpfXml2Array(sXml, "clpt_ind_seq");
    		var turnPortIndCds=ComOpfXml2Array(sXml, "turn_port_ind_cd");
    		var skdCngStsCd=ComOpfXml2Array(sXml, "skd_cng_sts_cd");
    		var polCdCombo=new Array();
    		var polTxCombo=new Array();
    		var newPolIdx=1;
    		var newPodIdx=1;
    		polCdCombo[0]='';
			polTxCombo[0]='';
    		// parent의 pol-pod사이의 정보만 표시
    		var start = document.form.p_new_pol.value;
    		var end = document.form.p_new_pod.value;
    		var isStart = false;
    		var isEnd = false;
    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '') {
    				if(start == loc_cds[arrIdx]) {
    					isStart = true;
    				}
    				if(end == loc_cds[arrIdx]) {
    					isEnd = true;
    				}
    				//if(isStart && start != loc_cds[arrIdx] && end != loc_cds[arrIdx]) {
    				if(isStart && start != loc_cds[arrIdx]) {
//	    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') {
    					// Skip, CANAL 제외
	    				if(skdCngStsCd[arrIdx] != 'S' && loc_cds[arrIdx] != 'EGSCA' && loc_cds[arrIdx] != 'PAPCA') {
	    					polCdCombo[newPolIdx]=loc_cds[arrIdx];
	    					polTxCombo[newPolIdx++]=loc_cds[arrIdx];
	    				} 
//	    			}
    				}
    				if(isEnd) {
    					break;
    				}
    			}
    		}
    		if(Row==-1) {
    			sheetObj.SetColProperty(prefixs+"cod_rhnd_port_cd", {ComboText:polTxCombo.join("|"), ComboCode:polCdCombo.join("|")});
    		} else {
    			sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs+"cod_rhnd_port_cd"), {ComboText:polTxCombo.join("|"), ComboCode:polCdCombo.join("|")});
    			setTmnlCombo(sheetObj, Row, sheetObj.GetCellValue(Row, sheetObj.SaveNameCol(prefixs+"cod_rhnd_port_cd")));
    		}
    	}
    	else {
    		if(Row==-1) {
    			sheetObj.SetColProperty(prefixs+"cod_rhnd_port_cd", {ComboText:polTxCombo.join("|"), ComboCode:polCdCombo.join("|")});
    		} else {
	    		sheetObj.CellComboItem(Row,sheetObj.SaveNameCol(prefixs+"cod_rhnd_port_cd"), {ComboText:"", ComboCode:""} );
	    		sheetObj.SetCellValue(Row, sheetObj.SaveNameCol(prefixs+"cod_rhnd_port_cd"),"",0);
    		}
    	}
    	return true;
    }
    
 	function setTmnlCombo(sheetObj, Row, portCd) {
 		var sParam=Array();
 		sParam[0]="loc_cd="+portCd;
 		sParam[1]="f_cmd="+SEARCH01;
 		var xmlStr=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam.join("&"));
 		if(xmlStr != null && xmlStr != undefined && xmlStr != "") {
 			var ydKind=" |" + ComGetEtcData(xmlStr, "yd_kind");
 			var ydNm=" |" + ComGetEtcData(xmlStr, "yd_nm");
 			var ydTxt="";
 			var ydCdTxt="";
 			if(ydKind != null && ydKind != undefined && ydKind != ""){
 				var ydNmArr=ydNm.split("|");
 				var ydKindArr=ydKind.split("|");
 				var ydCnt=ydKindArr.length;
 				for(var i=0; i<ydCnt; i++){
					if(ydTxt!='') {
						ydTxt = ydTxt + "|";
						ydCdTxt = ydCdTxt + "|";
					}
					ydTxt = ydTxt + ydKindArr[i] + "\t" + ydNmArr[i];
					ydCdTxt = ydCdTxt + ydKindArr[i];
 				}
 				sheetObj.CellComboItem(Row,sheetObj.SaveNameCol("sheet3_yd_cd"), {ComboText:ydTxt, ComboCode:ydCdTxt} );
 			}
 		}
 	}
 	
 	function setCurrencyCombo(sheetObj, Row, loc) {
		var sParam=Array();
 		sParam[0]="cod_rhnd_port_cd="+loc;
 		sParam[1]="f_cmd="+SEARCH04;
 		var sXml=sheetObj.GetSearchData("VOP_OPF_0206GS.do", sParam.join("&"));
		var arrCombo=ComXml2ComboString(sXml, "curr_cd", "curr_cd");
		if(arrCombo != null){
			sheetObj.CellComboItem(Row, sheetObj.SaveNameCol("sheet3_curr_cd"), {ComboText:arrCombo[0], ComboCode:arrCombo[0]} );
		}
 	}
	/* Developer performance  end */
