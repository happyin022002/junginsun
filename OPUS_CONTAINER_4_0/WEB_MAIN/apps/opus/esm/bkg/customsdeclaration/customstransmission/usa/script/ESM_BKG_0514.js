/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0514.js
*@FileTitle  : Vessel Arrival Transmit (HI)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	function processButtonClick(){
	    /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	    /*******************************************************/
	    var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break; 
				case "btn_TransToUSCS":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;
				case "btn_close":
					ComClosePopup(); 
					break; 
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 */
	function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag 
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		sheetObjects[0].RemoveAll();
		sheetObjects[0].DataInsert(-1);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		document.form.vvd.focus();
	}
	/**
	 * setting sheet initial values and header param : sheetObj , sheetNo 
	 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1": // sheet1 init
			    with(sheetObj){			        
			      if (location.hostname != "")
			      //no support[check again]CLT 					InitHostInfo(location.hostname, location.port, page_path);
			      var HeadTitle1="Flag|vvd|Eta|pod_cd|Name|B/L count";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vvd" },
			             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eta" },
			             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
			             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"name" },
			             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bl_count" } ];
			       
			      InitColumns(cols);	
			      SetEditable(1);			      
			      SetSheetHeight(225);
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: // retrieve
				if (validateForm(sheetObj, formObj, sAction))
				{
					formObj.f_cmd.value=SEARCH01;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_0514GS.do", FormQueryString(formObj) ); // ***
					ComOpenWait(false);
				}
				break;			
			case COMMAND01:
				formObj.f_cmd.value=MULTI01;
				if (validateForm(sheetObj, formObj, sAction))
				{
					for(var i=1; i < sheetObj.rowCount+1; i++){
						sheetObj.SetRowStatus(i,"U");
					}
					if(confirm("Do you want to transmit HI to US Customs?")){
						ComOpenWait(true);	
						var sParam=FormQueryString(formObj); + "&f_cmd=" + MULTI01;
						var sXml=sheetObj.GetSearchData("ESM_BKG_0514GS.do", sParam); //***
						ComOpenWait(false);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
				    	//formObj.output.value = sheetObj.EtcData("flatFile");
				    	if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0)				
						{
				    		ComShowCodeMessage('BKG00101');
						}else{
							ComShowCodeMessage('BKG00099');
						}	
						for(var i=1; i < sheetObj.rowCount+1; i++){
							sheetObj.SetRowStatus(i,"");
						}
					}
				}
				break;	
		}
	}
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI) {
				ComShowCodeMessage('BKG00166');
			} 
		} else {
			ComShowCodeMessage('BKG00167');
		}
		

	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if(sheetObj.RowCount()> 0){
				document.form.vvd.value=sheetObj.GetCellValue(1, "vvd");
				document.form.pod_cd.value=sheetObj.GetCellValue(1, "pod_cd");
				document.form.bl_count.value=sheetObj.GetCellValue(1, "bl_count");
				document.form.name.value=sheetObj.GetCellValue(1, "name");
				var etaFull=sheetObj.GetCellValue(1, "eta");
				if(etaFull.length > 8){
					document.form.eta.value=etaFull.substring(0, 8);
					document.form.eta_time.value=etaFull.substring(9);
				}else{
					document.form.eta.value="";
					document.form.eta_time.value="";
				}
			}
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
		case IBSEARCH:
			if(!ComChkRequired(formObj)) return false;
			return true;
			break;	
		case COMMAND01:
			if(!ComChkRequired(formObj)) return false;
			if(formObj.bl_count.value == "" || formObj.name.value == ""){
				ComShowCodeMessage('BKG00266');
				return false;
			}
			return true;
			break;			
		}
	}
