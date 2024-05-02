/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2006.js
*@FileTitle : Irregular Creation & Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TES_2006 : business script for ESD_TES_2006
     */

 // global variable
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Event handler processing by button click event 
 */
document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 **/
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];	// Irregular Container List Sheet.
		var sheetObject2=sheetObjects[1];	// Irregular Header Info Hidden Sheet.
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					if ( ComIsNull( formObject.irr_no.value ) ) {
						ComShowCodeMessage('TES70101');    // Please enter Reference Number.
						formObject.irr_no.focus();
						return false;
					}
					if ( formObject.irr_no.value.length != 12 ) {
						ComShowCodeMessage('TES70109');    // Please check length Reference Number.
						formObject.irr_no.focus();
						return false;
					}
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
					break;
				case "btn_new":
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
					initFormHdr();		// Irregular Header Form Init.
					initFormCntrList();	// Irregular Container List Sheet Init.
					
					setInitGuarantee(); //2017.01.02 Add
					break; 
				case "btn_save":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					/* Header Info */
					//if (!ComIsNull(sheetObject2.GetCellValue(1, "ofc_cd") ) &&
					if ( sheetObject2.GetCellValue(1, "ofc_cd") != "-1" &&
							sheetObject2.GetCellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value
					) {
						ComShowCodeMessage('TES70606');    // No authority to correct/delete the Irregular - Creation office mismatch!
						return false;
					}
					if ( ComIsNull( document.getElementById("irr_tp_cd").value ) ) {
						ComShowCodeMessage('TES70602');    // Please enter Irregular Type.
						return false;
					}
					if ( ComIsNull( document.getElementById("dept_no").value ) ) {
						ComShowCodeMessage('TES70603');    // This is invalid Depart.
						return false;
					}
					/* Container List */
					for ( var i=sheetObject1.HeaderRows(); i < sheetObject1.HeaderRows()+ sheetObject1.RowCount(); i++ ) {
						if ( ComIsNull( sheetObject1.GetCellValue(i , "cntr_no") ) ) {
							ComShowCodeMessage('TES70104');    // Please enter Container No.
							return false;
						}
						if ( !checkDupCntrNo( sheetObject1, i) ) {
							return false;
						}
						if ( formObject.gnte_tp_cd.value == "ST" ) {
							if ( ComIsNull( sheetObject1.GetCellValue(i , "fm_dt") ) ) {
								ComShowCodeMessage('TES70106');		// Please enter Container List start date.
								return false;
							}
							if ( ComIsNull( sheetObject1.GetCellValue(i , "to_dt") ) ) {
								ComShowCodeMessage('TES70107');		// Please enter Container List end date.
								return false;
							}
							if ( ComGetDaysBetween(sheetObject1.GetCellValue(i , "fm_dt"), sheetObject1.GetCellValue(i , "to_dt")) < 0 ) {
								ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
								return false;
							}
						} else {
							sheetObject1.SetCellValue(i , "fm_dt","",0);
							sheetObject1.SetCellValue(i , "to_dt","",0);
						}
						if ( ComIsNull( sheetObject1.GetCellValue(i , "gnte_amt") ) ) {
							ComShowCodeMessage('TES70105');    // Please enter Amount.
							return false;
						}
					}
					irrTpCdSaveInit();
					ComEnableManyObjects(true 
							, document.form.gnte_tp_cd 
							, document.form.curr_cd
							, document.form.bkg_sts_cd
							);
					if (ComIsNull( document.getElementById("irr_no").value ) ) {
						// Guarantee 에서 Irregular 등록할 경우.
						if ( document.getElementById("gnte_flg").value == 'Y') {
							formObject.f_cmd.value=MULTI01;
//							doActionIBSheet(sheetObject2, formObject, IBSEARCH_ASYNC02);
						} else {
							formObject.f_cmd.value=ADD;
						}
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					} else if (!ComIsNull( document.getElementById("irr_no").value ) &&
							formObject.irr_no.value == sheetObject2.GetCellValue(1, "irr_no") ) {
						formObject.f_cmd.value=MODIFY;
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					}
					break;
				case "btn_guarantee":
				    //2017.01.02 Add 
				    var tmpDmyFlg = ComGetObjValue(document.getElementById("dmy_flg"));
			        if (ComIsEmpty(tmpDmyFlg) || "Y" == tmpDmyFlg) {
                        ComShowCodeMessage('TES70701'); // This Is Not A Guarantee.
                        return false;
                    }
				    
					// Irregular Popup 
					//if ( document.getElementById("gnte_flg").value == "Y" ) {
					if ( document.getElementById("gnte_flg").value == "Y" || "N" == tmpDmyFlg) { //2017.01.02 Add
						var guaranteeUrl="ESD_TES_2001.do?pgmNo=ESD_TES_2001&parentPgmNo=ESD_TES_M001&irr_flg=Y"
							+ "&gnte_no=" + document.getElementById("gnte_no").value
							;
						window.location.replace(guaranteeUrl);
					}
					break; 
				case "btn_delete":
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
				    if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
				    if (!ComIsNull(sheetObject2.GetCellValue(1, "ofc_cd") ) &&
				    		sheetObject2.GetCellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value
					) {
						ComShowCodeMessage('TES70606');    // No authority to correct/delete the Irregular - Creation office mismatch!
						return false;
					}
					if ( ComShowConfirm(ComGetMsg('TES70604') ) ) {
						tes_getInputValueGuarantee('is_valid_TPB', SEARCH03, 'gnte_no|irr_no', 'checkNonTPB');
					}				    
					break;
				case "btn_refno":
					var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId="ESD_TES_2004";
					var param='?cre_flg=I&classId='+classId;
					var chkStr=dispaly.substring(0,3);
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('ESD_TES_2004.do' + param, 500, 360, '', dispaly, true);
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;
				case "btng_rowadd":
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					var Row=sheetObject1.DataInsert();
					break; 
				case "btng_rowdelete":					
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }				    
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}					
					var selectedRow=sheetObject1.GetSelectionRows('|').split('|');					
					for(var i=selectedRow.length - 1; i >= 0; i-- ) {
						if (sheetObject1.GetCellValue(selectedRow[i], "cntr_no") == null ) {
					    	sheetObject1.RowDelete(selectedRow[i], false);
						} else {
							sheetObject1.SetRowStatus(selectedRow[i],'D');
							sheetObject1.SetRowHidden(selectedRow[i],1);
//							sheetObject1.CellValue2(selectedRow[i], "gnte_amt") = 0;
						}
					}					
					//document.getElementById("irr_ttl_amt").value=getShtTotAmt(sheetObject1, "gnte_amt" );					
					break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source. <br>
	 * @param{ibsheet}		sheet_obj		IBSheet Object
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
		for(i=0; i < sheetObjects.length; i++) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		if ( document.getElementById("gnte_flg").value == "Y" ) {
			// Header 정보. Container List 정보 
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01); // IBSEARCH01
		}
		else if ( document.getElementById("inq_flg").value == "Y" ) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} 
		else {
			initFormHdr();
			
			setInitGuarantee();//2017.01.02 Add
		}
		document.getElementById("irr_no").focus();
		
		axon_event.addListener('keydown', 'ComKeyEnter', 'form'); 
	}
	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init ( Container List )
			    with(sheetObj){
				        
				      var HeadTitle1="|Seq|Container No.|SZ|BKG No.|BL No.|SC No.|From DT|To DT|Amount|VVD CD|Bkg No List|Bkg No. Org|IF OfC|IF SEQ";
				      var headCount=ComCountHeadTitle(HeadTitle1);

				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tml_gnte_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"fm_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"to_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gnte_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_list_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);

				      SetEditable(1);
				            SetCountPosition(0);
				            SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
//				            SetSheetHeight(220);//162;
				            SetColProperty("bkg_no", {ComboText:"", ComboCode:""} );
				      resizeSheet();
				      }
				break;
			case "sheet2":      //sheet2 init ( Header Info )
			    with(sheetObj){
		        
		      var HeadTitle1="STS|Irr No|Ref no|Office|Gnte Type|Currency|Bkg Sts|Irr Type|Irr Rsn Remark|Irr Prvt Remark|" +
		      "Irr Amt|Staff|System|Chassis|Other|Dispatch|Lack|Canceled|Shortage|" +
		      "OP Cost Ocp|Team|Tank Ord|Ext Ft|Spot Inc|Tml Chz|MnR|Triaxle|" +
		      "Depart|Resp Part|Del|Cre User|Cre Date|Upd User|Upd Date|dmy_flg";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"irr_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"irr_tp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"irr_rsn_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"irr_prvt_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"irr_ttl_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"irr_stf_err_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_sys_err_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_chss_shtg_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_otr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_late_dis_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_lack_of_flw_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_cxl_wo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_eq_shtg_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_ocp_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_tnk_ord_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_team_trkg_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_xtra_ft_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_sptg_icrz_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_otr_tml_chss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_mnr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"op_cost_tri_axl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dept_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"respb_pty_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"delt_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmy_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetCountPosition(0);
		      SetSheetHeight(100);
		            }
				break;				
		}
	}
	/**
	 * handling IBSheet ( Header ) process<br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */
	function doActionIBSheet( sheetObj, formObj, sAction ) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
	    		formObj.f_cmd.value=SEARCH;
     	 		var	sXml=sheetObj.GetSearchData("ESD_TES_2006GS.do", tesFrmQryStr(formObj) );
    	 		var arrXml=sXml.split("|$$|"); 
				for (var i=0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
                sXml=null;
                arrXml=null;
				break;
			case IBSEARCH_ASYNC01:      
	    		formObj.f_cmd.value=SEARCH01;
     	 		var	sXml=sheetObj.GetSearchData("ESD_TES_2006GS.do", tesFrmQryStr(formObj) );
    	 		var arrXml=sXml.split("|$$|"); 
				for (var i=0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
                sXml=null;
                arrXml=null;
				break;
			case IBSAVE:        // save
				var param=sheetObj.GetSaveString();
 				var savexml=sheetObjects[1].GetSaveData("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param);
 				sheetObjects[1].LoadSaveData(savexml, true);
				break;
			case IBDELETE:      // delete
				formObj.f_cmd.value=REMOVE;
				var param=sheetObj.GetSaveString();
 				var savexml=sheetObj.GetSaveData("ESD_TES_2006GS.do", tesFrmQryStr(formObj));
				doActionIBSheet( sheetObj, formObj, IBSEARCH );
				sheetObj.RemoveAll();
				break;
		}
	}	
	/**
	 * handling IBSheet (Container List ) process <br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */	
	function doActionIBSheet1( sheetObj, formObj, sAction ) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
	    		formObj.f_cmd.value=SEARCH;
     	 		var	sXml = sheetObj.DoSearch("ESD_TES_2006GS.do", tesFrmQryStr(formObj)  );
    	 		sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;
			case IBSAVE:        //Save
				formObj.f_cmd.value=MULTI;
				var param=sheetObjects[0].GetSaveString();
 				var saveXml=sheetObjects[0].GetSaveData("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param);
    	 		var arrXml=saveXml.split("|$$|"); 
				for (var i=0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
                sXml=null;
                arrXml=null;
				break;
			case IBDELETE:      // delete
				formObj.f_cmd.value=MULTI;
                var param=sheetObj.GetSaveString();
 		        var savexml=sheetObj.GetSaveData("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param );
				break;
		}
	}
	/**
	 * sheet1 ( Container List ) Data change event <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		Row			Row Index.
	 * @param{string}		Col			Col Index.
	 * @param{string}		Value		Value
	 */
	function sheet1_OnChange(sheet1, Row, Col, Value) {
		var sName=sheet1.ColSaveName(Col);
		var formObject=document.form;
		document.getElementById("rowId").value=Row;
		// container bkg no inquiry
		document.getElementById("cntr_no_tmp").value=sheet1.GetCellValue(Row, "cntr_no");
		if ( sName == 'cntr_no' ) {
			if ( ComIsNull( sheet1.GetCellValue(Row, "cntr_no") ) ) {
				return false;				
			}
			// UpperCase
			sheet1.SetCellValue(Row, "cntr_no",sheet1.GetCellValue(Row, "cntr_no").toUpperCase(),0);
			// checkDigsit
			sheet1.SetCellValue(Row, "cntr_no",cntrCheckDigit( sheet1.GetCellValue(Row, "cntr_no") ),0);
			// Container No. Duplication Check.
			if ( !checkDupCntrNo(sheet1, Row) ) {
				return false;
			}
			searchBkgNoList(sheet1, Row);
		}
	    if ( sName == 'bkg_no' && document.getElementById("retrieveFlg").value == 'N') {
	    	searchCntrInfo();
	    }
	    if ( sName == 'gnte_amt' ) {
	    	document.getElementById("irr_ttl_amt").value=getShtTotAmt(sheet1, 'gnte_amt');
	    }
	    if ( sName == 'to_dt' ) {
	    	if ( ComGetDaysBetween(sheet1.GetCellValue(Row , "fm_dt"), sheet1.GetCellValue(Row , "to_dt")) < 0 ) {
				ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
				sheet1.SetCellValue(Row , "to_dt","",0);
				return false;
			}
	    }
	}
	/**
	 * sheet2 (Irregular Header Info ) search end event <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg){
	    var formObject=document.form;
	    if( errMsg == '' ) {
	    	//if ( !ComIsNull( sheetObjects[1].GetCellValue(1, "gnte_no") ) ) {
	    	if (  sheetObjects[1].RowCount() > 0 ) {
				// 저장 Flag 
				document.getElementById("regflag").value="N";
				document.getElementById("retrieveFlg").value="Y";
				document.getElementById("irr_no"					).value=sheetObjects[1].GetCellValue(1, "irr_no"						);
				document.getElementById("gnte_no"					).value=sheetObjects[1].GetCellValue(1, "gnte_no"					);
				document.getElementById("ofc_cd"					).value=sheetObjects[1].GetCellValue(1, "ofc_cd"					    );
				document.getElementById("gnte_tp_cd"				).value=sheetObjects[1].GetCellValue(1, "gnte_tp_cd"				    );
				document.getElementById("curr_cd"					).value=sheetObjects[1].GetCellValue(1, "curr_cd"					);
				document.getElementById("bkg_sts_cd"				).value=sheetObjects[1].GetCellValue(1, "bkg_sts_cd"				    );
				document.getElementById("irr_rsn_rmk"				).value=sheetObjects[1].GetCellValue(1, "irr_rsn_rmk"				);
				document.getElementById("irr_prvt_rmk"				).value=sheetObjects[1].GetCellValue(1, "irr_prvt_rmk"				);
				document.getElementById("irr_ttl_amt"				).value=tes_chkAmtFmt( sheetObjects[1].GetCellValue(1, "irr_ttl_amt"));
				
				//if ( !ComIsNull( sheetObjects[1].GetCellValue(1, "irr_stf_err_flg"	) ) ) {
					document.getElementById("irr_tp_cd").value=sheetObjects[1].GetCellValue(1, "irr_tp_cd"				    );
				//}
				if ( sheetObjects[1].GetCellValue(1, "irr_tp_cd") == "O" ) {
					document.getElementsByName("irLayer")[0].style.display="none"; 
					document.getElementsByName("irLayer")[1].style.display="inline"; 
					if ( sheetObjects[1].GetCellValue(1, "op_cost_ocp_flg"		    ) == 'Y' ) {
						document.getElementById("op_cost_ocp_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_tnk_ord_flg"		) == 'Y' ) {
						document.getElementById("op_cost_tnk_ord_flg"		).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_team_trkg_flg"	) == 'Y' ) {
						document.getElementById("op_cost_team_trkg_flg"		).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_xtra_ft_flg"		) == 'Y' ) {
						document.getElementById("op_cost_xtra_ft_flg"		).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_sptg_icrz_flg"	) == 'Y' ) {
						document.getElementById("op_cost_sptg_icrz_flg"		).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_otr_tml_chss_flg") == 'Y' ) {
						document.getElementById("op_cost_otr_tml_chss_flg"	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_mnr_flg"		    ) == 'Y' ) {
						document.getElementById("op_cost_mnr_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "op_cost_tri_axl_flg"		) == 'Y' ) {
						document.getElementById("op_cost_tri_axl_flg"		).checked=true;
					}
				} else {
					document.getElementsByName("irLayer")[0].style.display="inline"; 
					document.getElementsByName("irLayer")[1].style.display="none";
					if ( sheetObjects[1].GetCellValue(1, "irr_stf_err_flg"		    ) == 'Y' ) {
						document.getElementById("irr_stf_err_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_sys_err_flg"		    ) == 'Y' ) {
						document.getElementById("irr_sys_err_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_chss_shtg_flg"		    ) == 'Y' ) {
						document.getElementById("irr_chss_shtg_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_otr_flg"		    ) == 'Y' ) {
						document.getElementById("irr_otr_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_late_dis_flg"		    ) == 'Y' ) {
						document.getElementById("irr_late_dis_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_lack_of_flw_flg"		    ) == 'Y' ) {
						document.getElementById("irr_lack_of_flw_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_cxl_wo_flg"		    ) == 'Y' ) {
						document.getElementById("irr_cxl_wo_flg"		  	).checked=true;
					}
					if ( sheetObjects[1].GetCellValue(1, "irr_eq_shtg_flg"		    ) == 'Y' ) {
						document.getElementById("irr_eq_shtg_flg"		  	).checked=true;
					}					
				}
				
				//2017.01.02 Add
				var tmpDeptNo = sheetObjects[1].GetCellValue(1, "dept_no"                   );
				if(ComIsEmpty(tmpDeptNo)){
				    tmpDeptNo = document.getElementById("cost_ofc_cd").value;
				}
				document.getElementById("dept_no"                   ).value=tmpDeptNo;
                document.getElementById("cost_ofc_cd"               ).value=tmpDeptNo;
                
				//document.getElementById("dept_no"				  	).value=sheetObjects[1].GetCellValue(1, "dept_no"				    );
				//document.getElementById("cost_ofc_cd"				).value=sheetObjects[1].GetCellValue(1, "dept_no"				    );
				document.getElementById("is_valid_dept_no"			).value="Y";
				document.getElementById("respb_pty_nm"			  	).value=sheetObjects[1].GetCellValue(1, "respb_pty_nm"			    );
				document.getElementById("delt_flg"		          	).value=sheetObjects[1].GetCellValue(1, "delt_flg"		            );
				document.getElementById("cre_usr_id"	          	).value=sheetObjects[1].GetCellValue(1, "cre_usr_id"	                );
				document.getElementById("cre_dt"		          	).value=sheetObjects[1].GetCellValue(1, "cre_dt"		                );
				document.getElementById("irr_no").readOnly=true;
				document.getElementById("irr_no").className="input2";
				// fm_dt, to_dt CellHidden
				setTypeCntrDt();
				// Container Bkg No. List ComboBox
				for (var i=sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount()); i++)
				{
					//sheetObjects[0].CellComboItem(i,"bkg_no", {ComboText:sheetObjects[0].CellValue(i, ComboCode:"bkg_no_list_ctnt")} );
					sheetObjects[0].CellComboItem(i,"bkg_no", {ComboText:sheetObjects[0].GetCellValue(i, "bkg_no_list_ctnt")} );
					sheetObjects[0].SetCellValue(i, "bkg_no",sheetObjects[0].GetCellValue(i, "bkg_no2"),0);
				}
				if ( document.getElementById("gnte_flg").value == 'Y' ) {
					// 모두 Editable false. ibflag = 'U'
					setEditable()
			    	document.getElementById("irr_ttl_amt").value=getShtTotAmt(sheetObjects[0], 'gnte_amt');
				}
				document.getElementById("retrieveFlg").value="N";
				
				//2017.01.02 Add 
				var tmpDmyFlg = sheetObjects[1].GetCellValue(1, "dmy_flg"                       );
				setInitGuarantee(tmpDmyFlg);
	    	} else {
	    		document.getElementById("regflag").value="Y";
	    		initFormHdr();		// Header Form Init.
				initFormCntrList();	// Container List Sheet Init.
				
				//2017.01.02 Add
                setInitGuarantee("Y"); //2017.01.02 Add 메뉴 신규 생성일겨우이므로 무조건 Y 처리.
	    	}
	    } else {
			ComShowMessage( errMsg );
	    }
	}
	/**
     * Guarantee Irregular set editable
     **/
	function setEditable() {
		if ( document.getElementById("gnte_flg").value == 'Y' ) {
			for (var i=sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount()); i++) {
				sheetObjects[0].SetRowStatus(i,"U");
				sheetObjects[0].SetRowEditable(i,0);
			}
			ComEnableManyObjects(false
					, document.form.gnte_tp_cd
					, document.form.curr_cd
					, document.form.bkg_sts_cd
					);
		}
	}	
	/**
	 * sheet2 (Irregular Header Info ) save end event <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSaveEnd(sheetObj, errMsg){
	    var formObject=document.form;
	    if( errMsg == '' ) {
	        var tmpDmyFlg = "Y"; //2017.01.02 Add Default로 메뉴를 통해서 들어올 경우로 봄.
	    	// Header 저장후 Container List 저장
    		if ( formObject.f_cmd.value == ADD ) {
				document.getElementById("gnte_no").value=sheetObj.GetEtcData("gnte_no");
				document.getElementById("irr_no").value=sheetObj.GetEtcData("irr_no");
				
				tmpDmyFlg = sheetObj.GetEtcData("dmy_flg"); //2017.01.02 Add 
				
    		}
    		// Guarantee 에서 Irregular 저장시.
    		else if ( formObject.f_cmd.value == MULTI01 ) {
				document.getElementById("irr_no").value=sheetObj.GetEtcData("irr_no");
				
				tmpDmyFlg = "N";//무조건 N 처리.
    		}
    		
    		setInitGuarantee(tmpDmyFlg);
    		
			doActionIBSheet1(sheetObjects[0], formObject, IBSAVE);
	    } else {
			ComShowMessage( errMsg );
	    }
	}
	/**
     * Initialization Form Object Irregular Value <br>
     **/
	function initFormHdr() {
		sheetObjects[1].RemoveAll();
		document.getElementById("irr_no").value="";
		document.getElementById("gnte_no").value="";
		document.getElementById("delt_flg").value="";
		document.getElementById("gnte_tp_cd").value="ST";
		document.getElementById("curr_cd").value="USD";
		document.getElementById("bkg_sts_cd").value="F";
		document.getElementById("irr_tp_cd").value="I";
		document.getElementById("dept_no").value=document.getElementById("cre_ofc_cd").value;//"";
		document.getElementById("irr_ttl_amt").value="";
		document.getElementById("irr_rsn_rmk").value="";
		document.getElementById("irr_prvt_rmk").value="";
		document.getElementById("irr_stf_err_flg").checked=false;
		document.getElementById("irr_late_dis_flg").checked=false;
		document.getElementById("irr_sys_err_flg").checked=false;
		document.getElementById("irr_lack_of_flw_flg").checked=false;
		document.getElementById("irr_chss_shtg_flg").checked=false;
		document.getElementById("irr_cxl_wo_flg").checked=false;
		document.getElementById("irr_otr_flg").checked=false;
		document.getElementById("irr_eq_shtg_flg").checked=false;
		document.getElementById("op_cost_ocp_flg").checked=false;
		document.getElementById("op_cost_sptg_icrz_flg").checked=false;
		document.getElementById("op_cost_tnk_ord_flg").checked=false;
		document.getElementById("op_cost_otr_tml_chss_flg").checked=false;
		document.getElementById("op_cost_team_trkg_flg").checked=false;
		document.getElementById("op_cost_mnr_flg").checked=false;
		document.getElementById("op_cost_xtra_ft_flg").checked=false;
		document.getElementById("op_cost_tri_axl_flg").checked=false;
		document.getElementById("respb_pty_nm").value="";
		document.getElementById("ofc_cd").value=document.getElementById("cre_ofc_cd").value;
		tes_getInputValue('DB_DATE', SEARCH06, '', 'setCreDate');
		irrTpCdChange();
		document.getElementById("irr_no").readOnly=false;
		document.getElementById("irr_no").className="";
		document.getElementById("regflag").value="Y";
		
	}
	/**
     * InitializationForm Object Irregular Value<br>
     **/
	function initFormCntrList() {
		sheetObjects[0].RemoveAll();
		sheetObjects[0].SetColHidden("fm_dt",0);
		sheetObjects[0].SetColHidden("to_dt",0);
	}
	/**
	 * set Reference No. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getRefNo(rowArray) {
		document.all.irr_no.value=rowArray[0];
	}
	/**
     * irr_tp_cd(IRR Type) change event<br>
     **/
	function irrTpCdChange() {
		var	arrLayer=document.getElementsByName("irLayer");		
		if ( document.getElementById("irr_tp_cd").value == 'O' ) { 
			arrLayer[0].style.display="none";
			arrLayer[1].style.display="inline";
		} else {
			arrLayer[0].style.display="inline";
			arrLayer[1].style.display="none";
		}
	}
	/**
     * irr_tp_cd(IRR Type) save event<br>
     **/
	function irrTpCdSaveInit() {
		var	arrLayer=document.getElementsByName("irLayer");
		if ( document.getElementById("irr_tp_cd").value == 'O' ) { 
			document.getElementById("irr_stf_err_flg").checked=false;
			document.getElementById("irr_late_dis_flg").checked=false;
			document.getElementById("irr_sys_err_flg").checked=false;
			document.getElementById("irr_lack_of_flw_flg").checked=false;
			document.getElementById("irr_chss_shtg_flg").checked=false;
			document.getElementById("irr_cxl_wo_flg").checked=false;
			document.getElementById("irr_otr_flg").checked=false;
			document.getElementById("irr_eq_shtg_flg").checked=false;
		} else {
			document.getElementById("op_cost_ocp_flg").checked=false;
			document.getElementById("op_cost_sptg_icrz_flg").checked=false;
			document.getElementById("op_cost_tnk_ord_flg").checked=false;
			document.getElementById("op_cost_otr_tml_chss_flg").checked=false;
			document.getElementById("op_cost_team_trkg_flg").checked=false;
			document.getElementById("op_cost_mnr_flg").checked=false;
			document.getElementById("op_cost_xtra_ft_flg").checked=false;
			document.getElementById("op_cost_tri_axl_flg").checked=false;
		}
	}
	/**
	 * sheet2 (Guarantee Header Info ) get total amount <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{int,string}	colnm		Column Index
	 */
	function getShtTotAmt(sheetObj, colnm) {		
		var tot_amt_val=0;		
		for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++)
		{			
			if (//sheetObj.RowSumable(i) 
					sheetObj.GetCellValue(i, colnm) != null 
					&& sheetObj.GetCellValue(i, colnm) != ''
					&& sheetObj.GetCellValue(i, colnm) != undefined
					&& !isNaN(parseFloat(sheetObj.GetCellValue(i, colnm)))
					&& sheetObj.GetRowStatus(i) != 'D'
			) {				
				tot_amt_val=Math.round(Number(tot_amt_val) * 10000) / 10000 + Math.round(Number(sheetObj.GetCellValue(i, colnm)) * 10000) / 10000;
			}			
		}		
		tot_amt_val=Math.round(Number(tot_amt_val) * 10000) / 10000;		
		tot_amt_val=tes_chkAmtFmt(tot_amt_val,document.form.curr_cd.value);		
		return tot_amt_val;
	}
	/**
     * check create date format
     * 
     */
	function setCreDate() {
		var formObj=document.form;
		var cre_dt=new String(formObj.DB_DATE.value).substring(0, 8);
		if (cre_dt != undefined && cre_dt != null && cre_dt.trim() != '' && cre_dt.length == 8) {
			formObj.cre_dt.value=cre_dt.substring(0, 4) + '-' + cre_dt.substring(4, 6) + '-' + cre_dt.substring(6, 8);
		}
	}
	function setTypeCntrDt() {
		// gnte_tp_cd(Type) 가 'ST'(Storage) 인 경우에만 보여주고 입력 가능하게 한다.
		if ( document.getElementById("gnte_tp_cd").value == 'ST' ) { 
			sheetObjects[0].SetColHidden("fm_dt",0);
			sheetObjects[0].SetColHidden("to_dt",0);
		} else {
			sheetObjects[0].SetColHidden("fm_dt",1);
			sheetObjects[0].SetColHidden("to_dt",1);
		}
	}
	/**
	 * TPB I/F Guarantee retrieve <br>
	 */
	function tpbRetrive() {
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
	/**
     * TPB IF Delete Check.
     * 
     */
	function checkNonTPB() {
		var arrTPB=document.getElementById("is_valid_TPB").value.split("|");
		var	delCnt=0;
		for( var i=0; i < arrTPB.length; i++ ) {
			if ( arrTPB[i] == "Y" ) {
				delCnt++;
			} else if ( arrTPB[i] == "N" ) {
				delNotCnt++;
//				ComShowCodeMessage('TES70114'); // 'The amount has been interfaced to TPB.';
			} else if ( arrTPB[i] == "X" ) {
				delNotCnt++;
			} else if ( arrTPB[i] == "O" ) {
				delCnt++;
			}
		}
		if ( delCnt == arrTPB.length ) {
			doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
		} else if ( delNotCnt > 0 ) {
			ComShowCodeMessage('TES70114'); // 'The amount has been interfaced to TPB.';
			return false;
		}
	}
	/**
	 * Container No. Duplication Check. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function checkDupCntrNo(sheetObj, row) {
		for (var i=sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount()); i++) {
			if ( i != row ) {
				if ((sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[0].GetCellValue(row, "cntr_no") ) &&
						(sheetObjects[0].GetCellValue(i, "bkg_no") == sheetObjects[0].GetCellValue(row, "bkg_no") ) &&
						sheetObjects[0].GetCellValue(i, "ibflag") != 'D'
				) {
					ComShowCodeMessage("TES70117", sheetObjects[0].GetCellValue(row, "cntr_no"), sheetObjects[0].GetCellValue(row, "bkg_no"));		//[Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Container No. BKG No. List retrieve <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchBkgNoList(sheetObj, row, retrieveFlg) {
		// container bkg no inquiry
		document.getElementById("cntr_no_tmp").value=sheetObj.GetCellValue(row, "cntr_no");
		if ( retrieveFlg == 'Y' ) {
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', '');
		} else {
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'searchCntrInfo', sheetObj);
		}
	}
	/**
	 * Container No. BKG No. Container Info retrieve <br>
	 * 
	 */
	function searchCntrInfo(){
		//alert("searchCntrInfo");
		if ( !ComIsNull( sheetObjects[0].GetCellValue( document.getElementById("rowId").value, "bkg_no") ) ) {
			document.getElementById("bkg_no_tmp").value=sheetObjects[0].GetCellValue( document.getElementById("rowId").value, "bkg_no");
			tes_getInputValueGuarantee('is_valid_cntr_info', SEARCH01, 'cntr_no_tmp|bkg_no_tmp', 'checkValidCntrInfo');
		} else {
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_no","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_tpsz_cd","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bkg_no","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bl_no","",0);
//			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "";
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "sc_no","",0);
			document.getElementById("cntr_no_tmp").value="";
			document.getElementById("bkg_no_tmp").value="";
			ComShowCodeMessage("TES70116"); // This is invalid Container No.
		}
	}
	/**
	 * set Container Info  <br>
	 * tmp[0]. Valid
	 * tmp[1]. cntr_no
	 * tmp[2]. cntr_tpsz_cd
	 * tmp[3]. bkg_no
	 * tmp[4]. bl_no
	 * tmp[5]. vvd_cd
	 * tmp[6]. sc_no
	 */
	function checkValidCntrInfo(){
		// Container Info Setting. 
		var formObj=document.form;
		var tmp='';
		if (formObj.is_valid_cntr_info.value != undefined && 
			formObj.is_valid_cntr_info.value != null && 
			formObj.is_valid_cntr_info.value.trim() != '' ) {
			tmp=formObj.is_valid_cntr_info.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_cntr_info.value=(tmp[0] != undefined && tmp[0] != null ? tmp[0] : '' );
				if (formObj.is_valid_cntr_info.value != null && formObj.is_valid_cntr_info.value == 'Y'){
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_tpsz_cd",(tmp[2] != undefined && tmp[2] != null ? tmp[2] : ''),0);
//					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bl_no",(tmp[4] != undefined && tmp[4] != null ? tmp[4] : ''),0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "vvd_cd",(tmp[5] != undefined && tmp[5] != null ? tmp[5] : ''),0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "sc_no",(tmp[6] != undefined && tmp[6] != null ? tmp[6] : ''),0);
//					document.getElementById("cntr_no_tmp").value	= "";
					document.getElementById("bkg_no_tmp").value="";
				} else {
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_no","",0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_tpsz_cd","",0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bkg_no","",0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bl_no","",0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "vvd_cd","",0);
					sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "sc_no","",0);
					document.getElementById("cntr_no_tmp").value="";
					document.getElementById("bkg_no_tmp").value="";
					ComShowCodeMessage("TES70116"); // This is invalid Container No.
				}
			} else {
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_no","",0);
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_tpsz_cd","",0);
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bkg_no","",0);
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bl_no","",0);
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "vvd_cd","",0);
				sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "sc_no","",0);
				document.getElementById("cntr_no_tmp").value="";
				document.getElementById("bkg_no_tmp").value="";
				ComShowCodeMessage("TES70116"); // This is invalid Container No.
			}
		} else {
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_no","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "cntr_tpsz_cd","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bkg_no","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "bl_no","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "vvd_cd","",0);
			sheetObjects[0].SetCellValue( document.getElementById("rowId").value, "sc_no","",0);
			document.getElementById("cntr_no_tmp").value="";
			document.getElementById("bkg_no_tmp").value="";
			ComShowCodeMessage("TES70116"); // This is invalid Container No.
		}		
	}
    /**
	 * validation check Depart no
	 *
	 */
	function validateDeptNo() {
		var formObj=document.form;
		if (formObj.dept_no.readOnly == false && formObj.cost_ofc_cd.value != "" ) {
			if ((formObj.dept_no.value == null || formObj.dept_no.value.trim() == '') ||
				formObj.dept_no.value != formObj.cost_ofc_cd.value ) {
				//2017.01.02 Add Depart 체크 로직 주석처리함.
			    //tes_getInputValue('is_valid_dept_no', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidDeptNo');
			}
		}
	}
	/**
	 * validation check Depart no
	 */
	function checkValidDeptNo(){
		var formObj=document.form;
		var tmp='';
		if (formObj.is_valid_dept_no.value != undefined && formObj.is_valid_dept_no.value != null &&
			formObj.is_valid_dept_no.value.trim() != '' ){
			tmp=formObj.is_valid_dept_no.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_dept_no.value=(tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_dept_no.value != null && formObj.is_valid_dept_no.value == 'Y'){
					formObj.dept_no.value=document.getElementById("cost_ofc_cd").value;
				} else {
					formObj.is_valid_dept_no.value='';
					formObj.dept_no.value='';
					ComShowCodeMessage('TES70603');	// This is invalid Depart.
				}
			} else {
				formObj.is_valid_dept_no.value='';
				formObj.dept_no.value='';
				ComShowCodeMessage('TES70603');	// This is invalid Depart.
			}
		} else {
			formObj.is_valid_dept_no.value='';
			formObj.dept_no.value='';
			ComShowCodeMessage('TES70603');	// This is invalid Depart.
		}
	}
	/**
     * @param {obj}    Text Value
     **/
	function isApNum(obj){
		if (!ComIsAlphabet(obj,'u')){
			obj.value='';
		}
	}
	/**
     * @param {obj}    Text Value
     **/
	function isApNum2(obj){
		if (!ComIsAlphabet(obj,'n')){
			obj.value='';
		}
		obj.value=obj.value.toUpperCase();
	}
	// UI 표준화관련 하단 여백 설정
	function resizeSheet() {
		    ComResizeSheet(sheetObjects[0]);
	}
	
	function setInitGuarantee(flg){
	    if(!ComIsEmpty(flg) && "N" == flg){
	        //button enable
	        ComEnableObject(document.getElementById("btn_guarantee"), true);
	        ComSetObjValue(document.getElementById("dmy_flg"), "N");
	    }else{
            //button disable
            ComEnableObject(document.getElementById("btn_guarantee"), false);
            ComSetObjValue(document.getElementById("dmy_flg"), "Y");
	    }
	}