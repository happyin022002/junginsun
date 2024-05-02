/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3011.js
*@FileTitle  : Deleted Charge Report by Office - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
				case "btn_ByBKG":
				case "btn_ByCNTR":
					doProcessPopup(srcName);
					break;
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
					
					break;
				case "btn_Close":
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
      * Register as an array IBSheet Object
      * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
      * Array defined at the top of the source
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
   /**
      * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	    with(sheetObj){                 
	               var HeadTitle="|Seq.|Office|Delete Reason|Tariff|CNTR No.|T/S|From YD|To YD|Fm|To|F/T|Over|From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|BKG No.|B/L No.|VVD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|G/B|SOC|L/I|C/H|O/T|R/O|Payer|Payer|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider|DEL DT|DEL OFC|DEL Name|Delete Remark(s)";

	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	               
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:"delt_rsn_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"li",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ch",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_trns_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"roll_ovr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"del_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_ofc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"del_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"corr_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, 	ToolTip:1 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ofc_rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                
	               InitColumns(cols);
	               SetEditable(1);
	               SetEllipsis(1);
	               FrozenCols = SaveNameCol("dmdt_trf_cd");
	               SetSheetHeight(420);
               }
             	break;
         }
     }
   // Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      
            	formObj.f_cmd.value=SEARCH;

				var sXml = sheetObj.GetSearchData("EES_DMT_3011GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1});
				
				var varcntrQty = ComGetEtcData(sXml, "cntr_qty");
				ComSetObjValue(formObj.cntr_qty, ComAddComma2(varcntrQty, "#,###"));

				var rolePermit = ComGetEtcData("ROLE_PERMIT");
				var roleAuth   = ComGetEtcData("ROLE_AUTH");
				ComSetObjValue(formObj.role_permit, rolePermit);
				ComSetObjValue(formObj.role_auth,	roleAuth);
			break;
         }
     }

//	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//  		with(sheetObj){
//  			Row = MouseRow();
//  			Col = MouseCol();
//  			if (Row > 0) {
//  				var ttText='';
//  				var colSaveNm = ColSaveName(Col);
//  				if (colSaveNm == 'corr_rmk') {	
//  					var ttText = GetCellValue(Row, colSaveNm);
//  					if (ComGetLenByByte(ttText) > 30) {
//  						SetToolTipText(Row, Col, ttText);
//  					}
//  				} 
//  				else {
//  					SetToolTipText(Row, Col, '');
//  				}
//  			}
//  		}
//  	}
	function doProcessPopup(srcName) {
   		var sheetObj=sheetObjects[0];
   		var formObj=document.form;
   		var sUrl='';
   		var sWidth='';
   		var sHeight='';
   		with(sheetObj) {
 	  		switch(srcName) {
	 	  		case 'btn_ByBKG':
	 	  			var chkRow=GetSelectRow();
					var bkgNo=GetCellValue(chkRow , "bkg_no");
					var blNo=GetCellValue(chkRow , "bl_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation view
		  				sUrl='EES_DMT_3002P.do' + paramVal;
		  			} else {
		  				// Inquiry view
		  				sUrl='EES_DMT_3005P.do' + paramVal;
		  			}
		  			sWidth='1200';
	          		sHeight='700';
	  				break;
	  			case 'btn_ByCNTR':
	  				var chkRow=GetSelectRow();
					var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			if( ComGetObjValue(formObj.role_permit) == 'Y'
		  				&& GetCellValue(chkRow , "ofc_rhq_cd") == ComGetObjValue(formObj.usr_rhq_ofc_cd) ) {
		  				// Calculation view
		  				sUrl='EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				// Inquiry view
		  				sUrl='EES_DMT_3006P.do' + paramVal;
		  			}
		  			sWidth='1150';
	          		sHeight='700';
	  				break;
 	  		} // switch end
   		} // with end
   		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
   	 }
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
	/* Developer's task end */
