/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1168.js
*@FileTitle  : ESM_BKG_1168
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var intervalId="";
	
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		
		var formObject=document.form;
		try { 
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1], formObject, SEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObjects[1], formObject, IBCLEAR);
					break; 
				case "btn_DownExcel":
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
					}
					break; 
				case "btn_transmit":
					doActionIBSheet(sheetObjects[1], formObject, MULTI);
					break; 
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
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
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj; 
	}
	
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */                   
	function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm ('change', 'obj_change',  document.form); //- change    	
	}
	/**
	 * ?? ?????, ?? ??
	 * param : sheetObj ==> ??????, sheetNo ==> ?????? ??? ???? ?? ????
	 * ??? ??? ?? ?? ??? case? ???? ?? ?????? ????
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
		        var HeadTitle="|flatFile";
		        var headCount=ComCountHeadTitle(HeadTitle);
		        
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flat_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(220);
				}
				break;
			case 2:      //sheet2 init
				with (sheetObj) {
		        var HeadTitle1="|Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Sent Time|Received Time|Package|Package Unit|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|ERR_YN";
		        var HeadTitle2="|Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Sent Time|Received Time|Package|Package Unit|NM|AD|NM|AD|NM|AD|ERR_YN";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        headCount=ComCountHeadTitle(HeadTitle1);
		        
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, FrozenCol:4 } );
		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);

		        var cols = [ {Type:"Status",    Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" ,     Wrap:1},
				       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sel",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"il_eta",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"snd_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 ,MultiLineText:1},
		               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rcv_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 ,MultiLineText:1},
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"sh_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"sh_ad",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cnee_ad",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_ad",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"err_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		        InitColumns(cols);
		        SetRangeBackColor(1, 3, 1, 17,"#555555");
	        	SetEditable(1);
	            SetSelectionMode(smSelectionRow);
	            SetCountPosition(0);
			      
	            SetSheetHeight(480);
			}
			break;
			case 3:      //sheet3 init
            with (sheetObj) {
		        var HeadTitle1="|Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|ERR_YN";
		        var HeadTitle2="|Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|NM|AD|NM|AD|NM|AD|ERR_YN";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		       
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);

		        var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sel",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"il_eta",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"sh_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"sh_ad",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cnee_ad",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_ad",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"err_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		        InitColumns(cols);
				SetEditable(1);
	            SetSelectionMode(smSelectionRow);
	            SetSheetHeight(450);
			}
            break;
		}
	}
	/**
	 * Sheet?? ???? ??<br>
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case SEARCH: // retrieve
				ComSetFocus(formObj.f_cmd);
				if(!validateForm(sheetObj,formObj,sAction))return;

				sheetObjects[1].SetWaitImageVisible(1);

				formObj.f_cmd.value=SEARCH;
				
				var sXml=sheetObj.GetSearchData("ESM_BKG_1168GS.do", FormQueryString(formObj));
				
				if (ComBkgErrMessage(sheetObj, sXml)) {
						formObj.vvd_nm.value=(ComGetEtcData(sXml,"vvd_nm") != undefined ? ComGetEtcData(sXml,"vvd_nm") : "") ;
						formObj.vvd_ld.value=(ComGetEtcData(sXml,"vvd_ld") != undefined ? ComGetEtcData(sXml,"vvd_ld") : "") ;
						formObj.vvd_call.value=(ComGetEtcData(sXml,"vvd_call") != undefined ? ComGetEtcData(sXml,"vvd_call") : "") ;
						formObj.eta.value=(ComGetEtcData(sXml,"eta") != undefined ? ComGetEtcData(sXml,"eta") : "") ;
						formObj.etd.value=(ComGetEtcData(sXml,"etd") != undefined ? ComGetEtcData(sXml,"etd") : "") ;
						
						sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				
				sheetObjects[1].CheckAll("sel",0,1);
				formObj.p_ori_amd_cd[0].checked=true;

				sheetObjects[1].SetWaitImageVisible(0);
				break;
				
			case SEARCH01: // Does VVD route include ISRAEL Port? 
				if (!validateForm(sheetObj, formObj, sAction))	return;
				
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObjects[1].GetSearchData("ESM_BKG_1168GS.do", FormQueryString(formObj));
				var skdFlg=ComGetEtcData(sXml, "skd_flg");
				
				if (skdFlg == "N") {
					ComShowCodeMessage('BKG06149', "Israel");
					return false;
				}
				break;
				
			case IBDOWNEXCEL:
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObjects[2].RemoveAll();
	    	    sheetObj.Copy2SheetCol(sheetObjects[2],"","",-1,-1,-1,2,true,false,"sel","");
				if(sheetObjects[2].RowCount()) {
					sheet3_OnSearchEnd(sheetObjects[2], "");
				}
				sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
			case IBCLEAR: // form & sheet clear
				sheetObjects[1].RemoveAll();
				formObj.reset();
				formObj.vvd_cd.focus();
				break;
			case MULTI: // create & transmit EDI FLAT FILE
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
					return false;
				}
				// ??? ?? B/L????? ????.
				if (sheetObj.CheckedRows("sel") <= 0 ) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
				var arrRow=ComFindText(sheetObj, "sel", 1);
				var sParam="";  
				var tempBlno=""; //bl_no? ?? ???? ??? ????? ?? ???? ??? ????.
				for(var i=0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// ?? bl? ??? ????.
					sParam +=   "ibflag=U"     +"&"+
								//"p_send_yn="   +formObj.p_send_yn.value+"&"+
					            "vsl_cd="		+formObj.vvd_cd.value.substring(0, 4)+"&"+
					            "skd_voy_no="	+formObj.vvd_cd.value.substring(4, 8)+"&"+
					            "skd_dir_cd="	+formObj.vvd_cd.value.substring(8)+"&"+
					            "bl_no="		+sheetObj.GetCellValue(arrRow[i], "bl_no"        )+"&"+
					            "pol_cd=" 		+formObj.pol_cd.value+"&";
					tempBlno=sheetObj.GetCellValue(arrRow[i], "bl_no");
				}
				formObj.f_cmd.value=MULTI;
				sParam += "&" + FormQueryString(formObj);
				ComOpenWait(true,true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_1168GS.do", sParam)
				var key=ComGetEtcData(sXml, "KEY");
				
				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				
				break;
		}
	}
	/**
	 * BackEndJob ??????<br>
	 * 
	 * @param sheetObj
	 * @param sKey
	 */
	function doActionValidationResult(sheetObj, sKey) {
		//ComShowMessage("1");
		var sXml=sheetObj.GetSearchData("ESM_BKG_1168GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		//ComShowMessage("doActionValidationResult "+sJbStsFlg);
		// ??? ???? ?? ????? ????.
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// ????? ????
			ComShowCodeMessage('BKG00101');	
			doActionIBSheet(sheetObjects[1],document.form,SEARCH); // 전송 성공 후 재조회
			return;
		} else if (sJbStsFlg == "FAIL") {
			//??
			clearInterval(intervalId);
			ComOpenWait(false);
			// ????? ????
			ComShowMessage(ComResultMessage(sXml));
		}
	}
	/**
     * handling process for input validation
     */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case SEARCH: { // Retrieve
				if (!ComChkValid(formObj)) return false;
				
				break;
			}
			case IBDOWNEXCEL: {
				if (sheetObj.CheckedRows("sel") <= 0 ) {
					ComShowCodeMessage("COM12189");
					return false;
				}
				break;
			}
			case MULTI: {
				
				if (sheetObj.CheckedRows("sel") <= 0 ) {
					ComShowCodeMessage("COM12189");
					return false;
				}
				var arrRow=ComFindText(sheetObj, "sel", 1);

				var ackBls = "";
	    		var ackCnt=0;
	    		var errBlArray=new Array();
	    		

				for (var i=0; i<arrRow.length; i++) {
					if(sheetObj.GetCellValue(arrRow[i], "rcv_time") == "Not Received"){
						if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
							errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")]=sheetObj.GetCellValue(arrRow[i], "bl_no");
							ackCnt++;
							if(ackCnt <= 5) 
								ackBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
						}
					}
				}
			
				if(ackCnt > 0 ){
					ackBls=ackCnt > 5 ? ackBls+"..etc.":ackBls.substring(0,ackBls.length-1); //5개 이상이면 etc로 나오게함. 
					if(!ComShowConfirm(ComGetMsg("BKG08333",ackBls," ")) ){
						return false;
					}
				}
	    		
//				var errYN = "N";
//				var arrRow = ComFindText(sheetObj, "sel", 1);
//				
//				/*
//				 * Error BL?? B/L ??? ???? ????.
//				 * */
//				var errorCnt = 0;  //error??? 10? ??? BL??? ???? ? ? ??? etc.
//				var errorBls = "";
//				
//				
//				var tempBl = "";
//				var errBlArray = new Array();
//				
//				for (var i=0; i<arrRow.length; i++) {
//					
//					if(sheetObj.CellValue(arrRow[i], "err_yn") == "Y"){
//						if(errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] == undefined){ // bl??? ?? ???? ???? ??.
//							errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] = sheetObj.CellValue(arrRow[i], "bl_no");
//							
//							errorCnt++;
//							if(errorCnt <= 10)
//								errorBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
//						}
//					}
//					
//					if (tempBl== sheetObj.CellValue(arrRow[i], "bl_no")) continue;// ?? bl? ??? ????.
//					
//					tempBl = sheetObj.CellValue(arrRow[i], "bl_no");
//					
//				}//end for
//				
//				if(errorCnt > 0){
//					errorBls = errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
//					ComShowCodeMessage("BKG01133",errorBls,"");
//					return false;
//				}
//				
				break;
			}
		}
		return true;
	}
	
	/**
	 * ???? ??? ? ??
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	/**
	 * ? ?? ??? ???
	 * @return
	 */
	function obj_change() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (srcName == "vvd_cd") {
			doActionIBSheet(sheetObjects[1], formObject, SEARCH01);
		}
	}
	/**
	 * ???  ??? ?? >>> ?? ????
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			//ShowSubSum([{StdCol:"pod_cd", SumCols:"err_yn", Sort:true, ShowCumulate:false, CaptionCol:SaveNameCol("cntr_no")}]);
			var redColor="#FF0000";
			var blueColor="#0000FF";
			for(var i=HeaderRows(); i<= LastRow(); i++) {
				SetColFontUnderline("bl_no",1);
				SetColFontColor("bl_no",blueColor);
				if (isError(SetCellValue(i,"sh_nm"))) GetCellFontColor(i,"sh_nm",redColor);
				if (isError(SetCellValue(i,"sh_ad")))GetCellFontColor(i,"sh_ad",redColor);
				if (isError(SetCellValue(i,"cnee_nm"))) GetCellFontColor(i,"cnee_nm",redColor);
				if (isError(SetCellValue(i,"cnee_ad"))) GetCellFontColor(i,"cnee_ad",redColor);
				if (isError(SetCellValue(i,"ntfy_nm"))) GetCellFontColor(i,"ntfy_nm",redColor);
				if (isError(SetCellValue(i,"ntfy_ad"))) GetCellFontColor(i,"ntfy_ad",redColor);
			}
		}//end width
		pagedMaxCnt=sheetObj.LastRow();
	}
	/**
	 * Excel Down ? group ?? ???
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			//ShowSubSum([{StdCol:"pod_cd", SumCols:"err_yn", Sort:true, ShowCumulate:false, CaptionCol:SaveNameCol("cntr_no")}]);
		}
	}
	/**
	 * Booking Creation ?? ??
	 * @param String cellValue
	 * return boolean ????
	 */
function isError(GetCellValue) {
	if(GetCellValue== "E") return true;
		return false;
	}
	/**
	 * B/L Inquiry ?? ??
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	function sheet2_OnDblClick(sheetObj, row, col) {
		var colSaveName=sheetObj.ColSaveName(col);
			switch(colSaveName) {
				case "bl_no" :
					ComBkgCall0079(sheetObj.GetCellValue(row, "bl_no"));
					break;
			} // end switch
	}
	/**
     * ??? ? ???? ? ??
     */
    function sheet2_OnSelectMenu(sheetObj, sAction) {
    	 //??? ?? ?? Check selected|Unheck selected|-|Check all|Uncheck all
    	  switch(sAction){
    	    case "Check selected" :
    	      var sRowStr=sheetObj.GetSelectionRows("/");
    	      //?? ???? ??? ???
    	      var arr=sRowStr.split("/");
    	      for (i=0; i<arr.length; i++) {
    	    	  if(arr[i] < 2) continue;//header ??
    	    	  if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum ???
    	    	  if(i== arr.length-1){//??? ??? ??? ??? ??? ?? ?? ?? ????. ??? ???? ?? ????.
    	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
	  		    		for(var j=0; j <= sameRows.length ; j++) {
	  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
	  		    			sheetObj.SetCellValue(sameRows[j], "sel",1,0);
	  		    		}
    	    	  }else
    	    		  sheetObj.SetCellValue(arr[i], "sel",1,0);
    	      }
    	      break;
    	    case "Unheck selected" :
    	    	var sRowStr=sheetObj.GetSelectionRows("/");
    	    	//?? ???? ??? ???
    	    	var arr=sRowStr.split("/");
    	    	for (i=0; i<arr.length; i++) {
    	    		if(arr[i] < 2) continue;//header ??
    	    		if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum ???
    	    		if(i== arr.length-1){//??? ??? ??? ??? ??? ?? ?? ?? ????. ??? ???? ?? ????.
    	    			var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
    	    			for(var j=0; j <= sameRows.length ; j++) {
    	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
    	    				sheetObj.SetCellValue(sameRows[j], "sel",0,0);
    	    			}
    	    		}else
    	    			sheetObj.SetCellValue(arr[i], "sel",0,0);
    	    	}
    	      break;
    	    case "Check all" :
    	    	sheetObj.CheckAll("sel",1,1);break;
    	    case "Uncheck all" :
    	    	sheetObj.CheckAll("sel",0,1);break;
    	  }
    }
    /**
     * sheet1 All ??? ????? ??
     * @param sheetObj ??????
     * @param Button ????? ??
     * @param Shift Shift?? ?? ?? 1, Ctrl?? ?? ?? 2, ??0
     * @param X X ??
     * @param Y Y ??
     */
/*    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
    	startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//?? ??? seq? ?? ?? ?? ???. merge ??.
		
    	var colSaveName=sheetObj.ColSaveName(sheetObj.MouseCol());
		var check=sheetObj.GetCellValue(startSelectedRow,"sel") == 0?1:0;//down?? ?? ????? ??? ???? ?? ??? ???.
		var keySeq=sheetObj.GetCellValue(startSelectedRow,"dt_seq");
        switch(colSaveName) {
	    	case "sel" :
	    		if(startSelectedRow < 2) return;
	    		//alert(startSelectedRow +" "+check+" "+keySeq);
	    		for(i=startSelectedRow ; i<= sheetObj.LastRow(); i++) {
	    			if(eval(keySeq) < eval(sheetObj.GetCellValue(i, "dt_seq")) ) break;
	    			
	    			if(keySeq == sheetObj.GetCellValue(i, "dt_seq")) {
	    				sheetObj.SetCellValue(i, "sel",check);
	    			}
	    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
	    		}
	    		break;
        } // end switch
    }//method end
    */
    
    function sheet2_OnClick(sheetObj, row, col) {
        var colSaveName=sheetObj.ColSaveName(col);
        switch(colSaveName) {
            case "sel" :
            	if(sheetObj.GetCellValue(row,"bl_no") == "") return;//subsum ???
            	//var check=sheetObj.GetCellValue(row,"sel") == 1 ?0:1;
            	//sheetObj.SetCellValue(row, "sel",check,0);//mousedown ?? ????? ?? ??? ????? ??? ?? ??? ????.
            	
            	sheetObj.RenderSheet(0);
            	startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(row,"dt_seq"));
            	
            	var check=sheetObj.GetCellValue(startSelectedRow,"sel");
            	var keySeq=sheetObj.GetCellValue(startSelectedRow,"dt_seq");
            	
            	if(startSelectedRow < 2) return;
            	
            	for(i=startSelectedRow ; i<= sheetObj.LastRow(); i++) {
            		if(eval(keySeq) < eval(sheetObj.GetCellValue(i, "dt_seq")) ) break;
            		
            		if(keySeq == sheetObj.GetCellValue(i, "dt_seq")) {
            			sheetObj.SetCellValue(i, "sel",check,0);
            		}
                }
                   
                sheetObj.RenderSheet(1);
                   
            break;
        } // end switch
    }

