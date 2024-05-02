/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0044.js
*@FileTitle  : Receivable Invoice - Container List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================
*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0044 :  business script for EES_LSE_0044
 */
	var vRcvRntlNo="";
	var vInvAgmtNo="";
	var vInvLstmCd="";
	var vChgCdNmTypes="";
	var vChgTypes="";
	
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
		/**********/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
           	switch(srcName) {
           		case "btn_Retrieve":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					}
                	break;
				case "btn_RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBINSERT);
 					}
                	break;
				case "btn_Delete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 						var vTtlInvAmt=0;
						for(var i=sheetObject1.HeaderRows(); i <= sheetObject1.RowCount(); i++) {
							if(sheetObject1.GetRowStatus(i) != "D") {
								vTtlInvAmt += Number(sheetObject1.GetCellValue(i, "cost_amt"));
								vTtlInvAmt += Number(sheetObject1.GetCellValue(i, "cr_amt"));
							}
						}
						ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));
 					}
                    break;
                case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
                    break;
                case "btn_Close":
                	if(formObj.edit_mode.value == "T") {
	                	var opener=window.dialogArguments;
	                	if (!opener)
	                		opener = parent;
						opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, IBSEARCH_ASYNC09);
						opener.clearForm("inv_isu_dt");
                	}
                	ComClosePopup(); 
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
		//전역변수 설정
		vRcvRntlNo=ComGetObjValue(formObj.rcv_rntl_seq);
		vInvAgmtNo=ComGetObjValue(formObj.inv_agmt_seq);
		vInvLstmCd=ComGetObjValue(formObj.inv_lstm_cd);
		doActionIBSheet(sheetObjects[0], formObj, SEARCH12);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		var formObj=document.form;
        switch(sheetID) {
             case "sheet1":
        	    with(sheetObj){
	               var HeadTitle="|Sel.|Seq.|* CNTR No.|TP/SZ|AGMT No.|AGMT No.|Term|Out date|Out Loc|Rtn date|Rtn Loc|Used\ndays|Charge\nType|Rate|Charge\nAmount|Credit\nAmount|Free\ndays||||";
	               var headCount=ComCountHeadTitle(HeadTitle);
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               Editable = (formObj.edit_mode.value == "T");
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq_no" },
	                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen: 15 },
	                      {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               if(Editable == true) {
	            	   cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	            	   cols.push({Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               } else {
	            	   cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	            	   cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               }
	               cols.push({Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"onh_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               cols.push({Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"onh_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
	               cols.push({Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"offh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               cols.push({Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"offh_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
	               cols.push({Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"bil_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
	               if(Editable == true) {
	            	   cols.push({Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lse_rcv_chg_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               } else {
	            	   cols.push({Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lse_rcv_chg_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               }
	               cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"chg_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 });
	               cols.push({Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"cost_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 });
	               cols.push({Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 });
	               cols.push({Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"free_dys",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 });
	               cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",          KeyField:0,   CalcLogic:"",   Format:"" });
	               cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rcv_rntl_seq",        KeyField:0,   CalcLogic:"",   Format:"" });
	               cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rcv_rntl_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"" });
	               cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_rcv_chg_cre_cd",  KeyField:0,   CalcLogic:"",   Format:"" });
	               InitColumns(cols);
	               if(Editable==true){
	            	   SetColProperty("lse_rcv_chg_tp_cd", {ComboText:vChgCdNmTypes, ComboCode:vChgTypes} );
		               SetColProperty("rcv_rntl_seq", {ComboText:vRcvRntlNo, ComboCode:vRcvRntlNo} );
		               SetColProperty("agmt_seq", {ComboText:vInvAgmtNo, ComboCode:vInvAgmtNo} );
		               SetColProperty("lstm_cd", {ComboText:vInvLstmCd, ComboCode:vInvLstmCd} );
		               var vRcvRntlNo="";
	               }
	               SetSheetHeight(215);
				break;
             }
        }
    }
  	// handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCREATE: 	//Container Type/Size Grid Combo Item Setting
				sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:ComGetEtcData(sXml ,"cntr_tpsz_nm"), ComboCode:ComGetEtcData(sXml,"cntr_tpsz_cd")} );
				}
				break;
			case IBSEARCH: 
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("EES_LSE_0044GS.do",FormQueryString(formObj) );
				}
				break;
			case IBINSERT:
				if(validateForm(sheetObj, formObj, sAction)) {
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row,"agmt_cty_cd","HHO",0);
		            sheetObj.SetCellValue(Row,"cost_yrmon",ComGetObjValue(formObj.cost_yrmon),0);
		            sheetObj.SetCellValue(Row,"lse_rcv_chg_cre_cd","A",0);
		            sheetObj.SetCellValue(Row,"rcv_rntl_seq",vRcvRntlNo.split("|")[0],0);
					sheetObj.SelectCell(Row,"agmt_seq");
					sheetObj.SetCellEditable(Row, "cntr_no",0);
					sheetObj.SetCellEditable(Row, "cntr_tpsz_cd",0);
					sheetObj.SetCellEditable(Row, "lse_rcv_chg_tp_cd",1);
					sheetObj.SetCellEditable(Row, "cost_amt",0);
					sheetObj.SetCellValue(Row,"cntr_no",getCreditCntrNo(sheetObj, Row),0);
					sheetObj.SetCellValue(Row,"cntr_tpsz_cd","BX",0);
				}
				break;
			case IBSAVE:	
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("EES_LSE_0044GS.do", FormQueryString(formObj), -1, false);
				}
				break;
			case SEARCH12:      //Unit Type retrieve
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);			
 				var param="f_cmd="+SEARCH20+"&intg_cd_id=CD30024"; 	
				var xml="";
				xml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
				var strCode= "";
				var strCodeNm = "";
				strCode = ""+ComGetEtcData(xml, "tp_cd").split("|");
				strCodeNm=""+ComGetEtcData(xml, "tp_cd_nm").split("|");
				
				var arrStrCode = strCode.split(",");
				var arrStrCodeNm = strCodeNm.split(",");
				vChgTypes = "";
				if(arrStrCode.length > 1) {
					for(var i=0;i<arrStrCode.length;i++) {
						if(i == 0) {
							vChgTypes = arrStrCode[i];
							vChgCdNmTypes = arrStrCode[i]+"	"+arrStrCodeNm[i]; 
						}else{
							vChgTypes = vChgTypes + "|" + arrStrCode[i]; 
							vChgCdNmTypes = vChgCdNmTypes + "|" + arrStrCode[i]+"	"+arrStrCodeNm[i]; 
						}
					}
				}
				ComOpenWait(false);
				break;				
        }
    }
	/**
	 * handling event when changing Sheet.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "cntr_no":
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="  + SEARCH02 + "&cntr_no="+ GetCellValue(Row,Col);
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_0027GS.do",param);
 						SetWaitImageVisible(1);
 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "cntr_no") != undefined) {
				 				if (ComGetEtcData(sXml, "cntr_no") != "") {
				 					SetCellValue(Row,"cntr_no",ComGetEtcData(sXml, "cntr_no"),0);
				 					SetCellValue(Row,"cntr_tpsz_cd",ComGetEtcData(sXml, "cntr_tpsz_cd"),0);
		 						}
 							} else {
 								SetCellValue(Row,"cntr_tpsz_cd","D2",0);
 							}
 						}
					}
					break;
				case "agmt_seq":
					var index=GetComboInfo(Row, "agmt_seq", "SelectedIndex");
					SetCellValue(Row,"lstm_cd",vInvLstmCd.split("|")[index],0);
					SetCellValue(Row,"rcv_rntl_seq",vRcvRntlNo.split("|")[index],0);
					break;
				case "onh_loc_cd":		// Grid Location Code Check
				case "offh_loc_cd":		// Grid Location Code Check
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="  + SEARCH05 + "&loc_cd=" + GetCellValue(Row,Col) + "&loc_tp=SCC";
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
 						SetWaitImageVisible(1);
 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "scc_cd") != undefined) {
				 				if (ComGetEtcData(sXml, "scc_cd") != "") {
				 					SetCellValue(Row,Col,ComGetEtcData(sXml, "scc_cd"),0);
		 						} else {
		 							ComShowCodeMessage("LSE01037");
		 							SetCellValue(Row,Col,"",0);
		 						}
 							} else {
 								var errMsg=LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								SetCellValue(Row,Col,"",0);
 								SelectCell(Row,Col);
 							}
 						}
					}
					break;
				case "cost_amt":
					if(Value < 0) {
						SetCellValue(Row,Col,0);
					}
					var vTtlInvAmt=0;
					for(var i=HeaderRows(); i <= RowCount(); i++) {
						if(GetRowStatus(i) != "D") {
							vTtlInvAmt += Number(GetCellValue(i, "cost_amt"));
							vTtlInvAmt += Number(GetCellValue(i, "cr_amt"));
						}
					}
					ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));
					break;
				case "cr_amt":
					if(Value > 0) {
						SetCellValue(Row,Col,-Number(Value));
					}
					var vTtlInvAmt=0;
					for(var i=HeaderRows(); i <= RowCount(); i++) {
						if(GetRowStatus(i) != "D") {
							vTtlInvAmt += Number(GetCellValue(i, "cost_amt"));
							vTtlInvAmt += Number(GetCellValue(i, "cr_amt"));
						}
					}
					ComSetObjValue(formObj.inv_amt,	ComGetMaskedValue(vTtlInvAmt.toFixed(2), "float"));
					break;
				case "bil_dys":
				case "free_dys":
					if(Value < 0) {
						SetCellValue(Row,Col,0,0);
					}
					break;
				case "lse_rcv_chg_tp_cd":
					var vEditable=/CRD|PDM/.test(Value);
					if(Value == "CRD") {
						SetCellEditable(Row, "cntr_no",0);
						SetCellEditable(Row, "cntr_tpsz_cd",0);
						SetCellEditable(Row, "cost_amt",0);
						SetCellValue(Row,"cntr_no",getCreditCntrNo(sheetObj, Row),0);
						SetCellValue(Row,"cntr_tpsz_cd","BX",0);
						SetCellValue(Row, "cost_amt",0);
					} else {
						SetCellEditable(Row, "cntr_no",1);
						SetCellEditable(Row, "cntr_tpsz_cd",1);
						SetCellEditable(Row, "cost_amt",1);
						SetCellValue(Row,"cntr_no","",0);
						SetCellValue(Row,"cntr_tpsz_cd","D2",0);
						//CellValue(Row, "cr_amt") = 0;
					}
					if(vEditable == false) {
						SetCellValue(Row, "bil_dys",0,0);
						SetCellValue(Row, "free_dys",0,0);
					}
					SetCellEditable(Row, "bil_dys",vEditable);
					SetCellEditable(Row, "free_dys",vEditable);
					SelectCell(Row, "cntr_no");
					break;
			}
 		}
 	}
 	/**
 	 * handling event in case of Popup-Click sheet<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "offh_loc_cd":	// Delivery Location Pop-up
				case "onh_loc_cd":
					openPopup("1", Row, Col);
					break;
			}
 		}
    }
    /**
     * handling event in case of Validation sheet
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		if(GetRowStatus(Row) == "D") return;
    		//mandatory item
    		if(GetCellValue(Row, "cntr_no") == "") {
				ComShowCodeMessage("LSE01064");
				ValidateFail(true);
		        SelectCell(Row, "cntr_no");
				return;
			}
    	}
    }
	/**
     * handling after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		//doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }
    /**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	with(sheetObj) {
			for(var i=HeaderRows(); i <= SearchRows(); i++) {
				if(formObj.edit_mode.value == "T") {
					var vChargeType=GetCellValue(i, "lse_rcv_chg_tp_cd");
					if(/PDM/.test(vChargeType) == false) {
						SetCellEditable(i, "bil_dys",0);
						SetCellEditable(i, "free_dys",0);
					}
				}
				if(GetCellValue(i, "cntr_tpsz_cd") == "") {
					SetCellText(i, "cntr_tpsz_cd" ,"BX");
				}
			}
    	}
    }
	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', true, false, Row, Col, 0);
    	}
    	return;
    }
  	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				SetCellValue(Row, Col,aryPopupData[0][10],0);//SCC
			}
		}
	}
	/**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    			case IBINSERT:
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}
	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
	}
	/**
	 * handling process for CNTR No.
	 * @param sheetObj
	 * @param rowIdx
	 * @return vCrdCntrNo
	 */
	function getCreditCntrNo(sheetObj, rowIdx) {
		var formObj=document.form;
		var vCrdMaxSeq=0;
		var vCrdCntrNo="CRD" + ComReplaceStr(ComGetObjValue(formObj.cost_yrmon), "-", "").substr(2);
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
			if ( sheetObj.GetCellValue(i, "lse_rcv_chg_tp_cd") == "CRD" && i != rowIdx ) {
				var vCrdSeq=ComParseInt(ComLtrim(sheetObj.GetCellValue(i, "cntr_no").substr(7), "0"));
				if ( vCrdMaxSeq < vCrdSeq ) {
					vCrdMaxSeq=vCrdSeq;
				}
			}
		}
		vCrdCntrNo=vCrdCntrNo + ComLpad((vCrdMaxSeq+1)+"", 4, "0");
		return vCrdCntrNo;
	}